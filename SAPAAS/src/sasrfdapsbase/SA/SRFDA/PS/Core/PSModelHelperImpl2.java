/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.psba.dao.IBASelectContext
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.PSModelHelperImpl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import java.util.HashMap;
import java.util.Vector;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.psba.dao.IBASelectContext;

public class PSModelHelperImpl2
extends PSModelHelperImpl {
    private HashMap<String, HBaseSelectFilter> selectFilterMap = new HashMap();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, String strPSSysModelInstId, boolean bAlwaysActive) throws Exception {
        super.init(iDAGlobalHelper, strPSSysModelInstId, bAlwaysActive);
    }

    @Override
    protected String getSQL_getAllPSAppDEViews(String strPSSysAppId, String strPSDEId) {
        return super.getSQL_getAllPSAppDEViews(strPSSysAppId, strPSDEId);
    }

    @Override
    protected String getSQL_getAllPSAppDEViews(String strPSSysAppId) {
        return super.getSQL_getAllPSAppDEViews(strPSSysAppId);
    }

    @Override
    protected String getSQL_getAllPSAppEditorTempls(String strPSApplicationId) {
        return super.getSQL_getAllPSAppEditorTempls(strPSApplicationId);
    }

    @Override
    protected String getSQL_getAllPSSubApps(String strPSSubSysId) {
        return super.getSQL_getAllPSSubApps(strPSSubSysId);
    }

    @Override
    protected String getSQL_getAllPSSubAppViews(String strPSSubSysId) {
        return super.getSQL_getAllPSSubAppViews(strPSSubSysId);
    }

    @Override
    protected String getSQL_getAllPSModelPlugins() {
        return super.getSQL_getAllPSModelPlugins();
    }

    @Override
    protected String getSQL_getAllPSLanguageReses(String strPSSystemId) {
        return super.getSQL_getAllPSLanguageReses(strPSSystemId);
    }

    @Override
    protected String getSQL_getAllPSLanguageItems(String strPSSystemId) {
        return super.getSQL_getAllPSLanguageItems(strPSSystemId);
    }

    @Override
    protected String getSQL_getAllPSMobAppStartPages(String strPSApplicationId) {
        return super.getSQL_getAllPSMobAppStartPages(strPSApplicationId);
    }

    @Override
    protected String getSQL_getAllPSMobAppPacks(String strPSApplicationId) {
        return super.getSQL_getAllPSMobAppPacks(strPSApplicationId);
    }

    @Override
    protected String getSQL_getAllPSMobAppPackCerts(String strPSApplicationId) {
        return super.getSQL_getAllPSMobAppPackCerts(strPSApplicationId);
    }

    @Override
    protected String getSQL_getPSCodeList(String strPSCodeListId) {
        return super.getSQL_getPSCodeList(strPSCodeListId);
    }

    @Override
    protected String getSQL_getPSCodeListByTempl(String strPSCodeListTemplId) {
        return super.getSQL_getPSCodeListByTempl(strPSCodeListTemplId);
    }

    @Override
    protected String getSQL_getPSDBType(String strPSDBTypeId) {
        return super.getSQL_getPSDBType(strPSDBTypeId);
    }

    @Override
    protected String getSQL_getPSDataEntity(String strPSSystemId, String strPSDataEntityName) {
        return super.getSQL_getPSDataEntity(strPSSystemId, strPSDataEntityName);
    }

    @Override
    protected String getSQL_getPSDataEntity(String strPSDataEntityId) {
        return super.getSQL_getPSDataEntity(strPSDataEntityId);
    }

    @Override
    protected String getSQL_getPSDEDBConfigs(String strPSDataEntityId) {
        return super.getSQL_getPSDEDBConfigs(strPSDataEntityId);
    }

    @Override
    protected String getSQL_getPSDEDBConfigsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEDBConfigsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEDBConfig(String strPSDataEntityId, String strDBType) {
        return super.getSQL_getPSDEDBConfig(strPSDataEntityId, strDBType);
    }

    @Override
    protected String getSQL_getAllPSSystemApplications(String strPSSystemId) {
        return super.getSQL_getAllPSSystemApplications(strPSSystemId);
    }

    @Override
    protected String getSQL_getAllPSSystemModules(String strPSSystemId) {
        return super.getSQL_getAllPSSystemModules(strPSSystemId);
    }

    @Override
    protected String getSQL_getAllPSSystemDBConfigs(String strPSSystemId) {
        return super.getSQL_getAllPSSystemDBConfigs(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSApplicationView(String strPSApplicationViewId) {
        return super.getSQL_getPSApplicationView(strPSApplicationViewId);
    }

    @Override
    protected String getSQL_getPSAppIndexView(String strPSAppIndexViewId) {
        return super.getSQL_getPSAppIndexView(strPSAppIndexViewId);
    }

    @Override
    protected String getSQL_getPSAppPortalView(String strPSAppPortalViewId) {
        return super.getSQL_getPSAppPortalView(strPSAppPortalViewId);
    }

    @Override
    protected String getSQL_getPSDEChartsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEChartsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEChartAxesesBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEChartAxesesBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEChartSeriesesBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEChartSeriesesBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSControlType(String strPSControlTypeId) {
        return super.getSQL_getPSControlType(strPSControlTypeId);
    }

    @Override
    protected String getSQL_getPSAppModule(String strPSAppModuleId) {
        return super.getSQL_getPSAppModule(strPSAppModuleId);
    }

    @Override
    protected String getSQL_getPSAppUtilPage(String strPSAppUtilPageId) {
        return super.getSQL_getPSAppUtilPage(strPSAppUtilPageId);
    }

    @Override
    protected String getSQL_getPSAppUIStyle(String strPSAppUIStyleId) {
        return super.getSQL_getPSAppUIStyle(strPSAppUIStyleId);
    }

    @Override
    protected String getSQL_getPSAppType(String strPSAppTypeId) {
        return super.getSQL_getPSAppType(strPSAppTypeId);
    }

    @Override
    protected String getSQL_getPSDEChartAxeses(String strPSDEChartId) {
        return super.getSQL_getPSDEChartAxeses(strPSDEChartId);
    }

    @Override
    protected String getSQL_getPSDEChartSerieses(String strPSDEChartId) {
        return super.getSQL_getPSDEChartSerieses(strPSDEChartId);
    }

    @Override
    protected String getSQL_getPSAppViewStyle(String strPSAppViewStyleId) {
        return super.getSQL_getPSAppViewStyle(strPSAppViewStyleId);
    }

    @Override
    protected String getSQL_getPSAppEditorTempl(String strPSAppEditorTemplId) {
        return super.getSQL_getPSAppEditorTempl(strPSAppEditorTemplId);
    }

    @Override
    protected String getSQL_getPSAppFunc(String strPSAppFuncId) {
        return super.getSQL_getPSAppFunc(strPSAppFuncId);
    }

    @Override
    protected String getSQL_getPSAppMenuItemsBySysApp(String strPSSysAppId) {
        return super.getSQL_getPSAppMenuItemsBySysApp(strPSSysAppId);
    }

    @Override
    protected String getSQL_getPSAppMenuItems(String strPSAppMenuId) {
        return super.getSQL_getPSAppMenuItems(strPSAppMenuId);
    }

    @Override
    protected String getSQL_getPSAppMenuItemType(String strPSAppMenuItemTypeId) {
        return super.getSQL_getPSAppMenuItemType(strPSAppMenuItemTypeId);
    }

    @Override
    protected String getSQL_getPSDBValueFunc(String strPSDBValueFuncId) {
        return super.getSQL_getPSDBValueFunc(strPSDBValueFuncId);
    }

    @Override
    protected String getSQL_getPSDEDataQueries(String strPSDataEntityId) {
        return super.getSQL_getPSDEDataQueries(strPSDataEntityId);
    }

    @Override
    protected String getSQL_getPSDEDataQueriesBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEDataQueriesBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEDataQuery(String strPSDEDataQueryId) {
        return super.getSQL_getPSDEDataQuery(strPSDEDataQueryId);
    }

    @Override
    protected String getSQL_getPSDEDataQueryJoins(String strPSDEDataQueryId) {
        return super.getSQL_getPSDEDataQueryJoins(strPSDEDataQueryId);
    }

    @Override
    protected String getSQL_getPSDEDataQueryJoinsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEDataQueryJoinsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEDataQueryConds(String strPSDEDataQueryId) {
        return super.getSQL_getPSDEDataQueryConds(strPSDEDataQueryId);
    }

    @Override
    protected String getSQL_getPSDEDataQueryCondsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEDataQueryCondsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEDataSets(String strPSDataEntityId) {
        return super.getSQL_getPSDEDataSets(strPSDataEntityId);
    }

    @Override
    protected String getSQL_getPSDEDataSetsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEDataSetsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEDataSet(String strPSDEDataSetId) {
        return super.getSQL_getPSDEDataSet(strPSDEDataSetId);
    }

    @Override
    protected String getSQL_getPSDEDSDQs(String strPSDataSetId) {
        return super.getSQL_getPSDEDSDQs(strPSDataSetId);
    }

    @Override
    protected String getSQL_getPSDEDSDQsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEDSDQsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEDSGroupParams(String strPSDataSetId) {
        return super.getSQL_getPSDEDSGroupParams(strPSDataSetId);
    }

    @Override
    protected String getSQL_getPSAjaxControlHandlers(String strPSDataEntityId) {
        return super.getSQL_getPSAjaxControlHandlers(strPSDataEntityId);
    }

    @Override
    protected String getSQL_getPSACHandlersBySystem(String strPSSystemId) {
        return super.getSQL_getPSACHandlersBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSAjaxControlHandler(String strPSDataEntityId, String strPSAjaxControlHandlerId) {
        return super.getSQL_getPSAjaxControlHandler(strPSDataEntityId, strPSAjaxControlHandlerId);
    }

    @Override
    protected String getSQL_getPSDEDataSetCodes(String strPSDEDataSetId) {
        return super.getSQL_getPSDEDataSetCodes(strPSDEDataSetId);
    }

    @Override
    protected String getSQL_getPSDEDataSetCode(String strPSDEDataSetId, String strPSDEDataSetCodeId) {
        return super.getSQL_getPSDEDataSetCode(strPSDEDataSetId, strPSDEDataSetCodeId);
    }

    @Override
    protected String getSQL_getPSDBDevInst(String strPSDBDevInstId) {
        return super.getSQL_getPSDBDevInst(strPSDBDevInstId);
    }

    @Override
    protected String getSQL_getPSAppViewRefs(String strPSAppViewId) {
        return super.getSQL_getPSAppViewRefs(strPSAppViewId);
    }

    @Override
    protected String getSQL_getPSAppViewRefsBySystem(String strPSSystemId) {
        return super.getSQL_getPSAppViewRefsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEAction(String strPSDEActionId) {
        return super.getSQL_getPSDEAction(strPSDEActionId);
    }

    @Override
    protected String getSQL_getPSDEActionsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEActionsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEActionLogics(String strPSDEActionId) {
        return super.getSQL_getPSDEActionLogics(strPSDEActionId);
    }

    @Override
    protected String getSQL_getPSDEActionLogicsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEActionLogicsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEActionParams(String strPSDEActionId) {
        return super.getSQL_getPSDEActionParams(strPSDEActionId);
    }

    @Override
    protected String getSQL_getPSDEActionParamsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEActionParamsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEActions(String strPSDataEntityId) {
        return super.getSQL_getPSDEActions(strPSDataEntityId);
    }

    @Override
    protected String getSQL_getPSDEActionType(String strPSDEActionTypeId) {
        return super.getSQL_getPSDEActionType(strPSDEActionTypeId);
    }

    @Override
    protected String getSQL_getPSDBSPPartTempl(String strPSDBSPPartTemplId) {
        return super.getSQL_getPSDBSPPartTempl(strPSDBSPPartTemplId);
    }

    @Override
    protected String getSQL_getPSDBSysProcTempl(String strPSDBSysProcTemplId) {
        return super.getSQL_getPSDBSysProcTempl(strPSDBSysProcTemplId);
    }

    @Override
    protected String getSQL_getPSDEDBSysProcCode(String strPSDEDBSysProcId) {
        return super.getSQL_getPSDEDBSysProcCode(strPSDEDBSysProcId);
    }

    @Override
    protected String getSQL_getPSDEDBSysProcs(String strPSDataEntityId) {
        return super.getSQL_getPSDEDBSysProcs(strPSDataEntityId);
    }

    @Override
    protected String getSQL_getPSDEDBSysProc(String strPSDataEntityId, String strPSDEDBSysProcId) {
        return super.getSQL_getPSDEDBSysProc(strPSDataEntityId, strPSDEDBSysProcId);
    }

    @Override
    protected String getSQL_getPSDBSysProcParams(String strPSDEDBSysProcCodeId) {
        return super.getSQL_getPSDBSysProcParams(strPSDEDBSysProcCodeId);
    }

    @Override
    protected String getSQL_getPSCodeItems(String strPSCodeListId) {
        return super.getSQL_getPSCodeItems(strPSCodeListId);
    }

    @Override
    protected String getSQL_getPSCodeItemsBySystem(String strPSSystemId) {
        return super.getSQL_getPSCodeItemsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSAppViewLogics(String strPSAppViewId) {
        return super.getSQL_getPSAppViewLogics(strPSAppViewId);
    }

    @Override
    protected String getSQL_getPSAppViewLogicsBySystem(String strPSSystemId) {
        return super.getSQL_getPSAppViewLogicsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEACMode(String strPSDEACModeId) {
        return super.getSQL_getPSDEACMode(strPSDEACModeId);
    }

    @Override
    protected String getSQL_getPSDEACModes(String strPSDataEntityId) {
        return super.getSQL_getPSDEACModes(strPSDataEntityId);
    }

    @Override
    protected String getSQL_getPSDEACModesBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEACModesBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEACModeItems(String strPSDEACModeId) {
        return super.getSQL_getPSDEACModeItems(strPSDEACModeId);
    }

    @Override
    protected String getSQL_getPSDEACModeItemsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEACModeItemsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDBValueOP(String strPSDBValueOPId) {
        return super.getSQL_getPSDBValueOP(strPSDBValueOPId);
    }

    @Override
    protected String getSQL_getPSDEDRGroups(String strPSDataEntityId) {
        return super.getSQL_getPSDEDRGroups(strPSDataEntityId);
    }

    @Override
    protected String getSQL_getPSDEDRGroupsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEDRGroupsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEDRItems(String strPSDEId) {
        return super.getSQL_getPSDEDRItems(strPSDEId);
    }

    @Override
    protected String getSQL_getPSDEDRItemsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEDRItemsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEDRDetails(String strPSDEDRId) {
        return super.getSQL_getPSDEDRDetails(strPSDEDRId);
    }

    @Override
    protected String getSQL_getPSDEDRDetailsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEDRDetailsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSAppMenu(String strPSAppMenuId) {
        return super.getSQL_getPSAppMenu(strPSAppMenuId);
    }

    @Override
    protected String getSQL_getPSDEChart(String strPSDEChartId) {
        return super.getSQL_getPSDEChart(strPSDEChartId);
    }

    @Override
    protected String getSQL_getPSDEDataRelations(String strPSDEId) {
        return super.getSQL_getPSDEDataRelations(strPSDEId);
    }

    @Override
    protected String getSQL_getPSDEDataRelationsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEDataRelationsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEDataQueryCodes(String strPSDEDataQueryId) {
        return super.getSQL_getPSDEDataQueryCodes(strPSDEDataQueryId);
    }

    @Override
    protected String getSQL_getPSDEDataQueryCodesBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEDataQueryCodesBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEDataQueryCode(String strPSDEDataQueryId, String strPSDEDataQueryCodeId) {
        return super.getSQL_getPSDEDataQueryCode(strPSDEDataQueryId, strPSDEDataQueryCodeId);
    }

    @Override
    protected String getSQL_getPSDEDataQueryCodeExps(String strPSDEDataQueryCodeId) {
        return super.getSQL_getPSDEDataQueryCodeExps(strPSDEDataQueryCodeId);
    }

    @Override
    protected String getSQL_getPSDEDataQueryCodeExpsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEDataQueryCodeExpsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDBSysProcType(String strPSDBSysProcTypeId) {
        return super.getSQL_getPSDBSysProcType(strPSDBSysProcTypeId);
    }

    @Override
    protected String getSQL_getPSDEDataQueryCodeConds(String strPSDEDataQueryCodeId) {
        return super.getSQL_getPSDEDataQueryCodeConds(strPSDEDataQueryCodeId);
    }

    @Override
    protected String getSQL_getPSDEDataQueryCodeCondsSystem(String strPSSystemId) {
        return super.getSQL_getPSDEDataQueryCodeCondsSystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEDataView(String strPSDEDataViewId) {
        return super.getSQL_getPSDEDataView(strPSDEDataViewId);
    }

    @Override
    protected String getSQL_getPSDEDataViewItems(String strPSDEDataViewId) {
        return super.getSQL_getPSDEDataViewItems(strPSDEDataViewId);
    }

    @Override
    protected String getSQL_getPSDEDataViewsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEDataViewsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEDataViewItemsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEDataViewItemsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getAllPSWorkflows(String strPSSystemId) {
        return super.getSQL_getAllPSWorkflows(strPSSystemId);
    }

    @Override
    protected String getSQL_getAllPSWFRoles(String strPSSystemId) {
        return super.getSQL_getAllPSWFRoles(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSAppServerType(String strPSAppServerTypeId) {
        return super.getSQL_getPSAppServerType(strPSAppServerTypeId);
    }

    @Override
    protected String getSQL_getPSAppServer(String strPSAppServerId) {
        return super.getSQL_getPSAppServer(strPSAppServerId);
    }

    @Override
    protected String getSQL_getPSAppSubApp(String strPSAppSubAppId) {
        return super.getSQL_getPSAppSubApp(strPSAppSubAppId);
    }

    @Override
    protected String getSQL_getAllPSSysRefs(String strPSSystemId) {
        return super.getSQL_getAllPSSysRefs(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEDQPDCond(String strPSDEDQPDCondId) {
        return super.getSQL_getPSDEDQPDCond(strPSDEDQPDCondId);
    }

    @Override
    protected String getSQL_getAllPSSysImages(String strPSSystemId) {
        return super.getSQL_getAllPSSysImages(strPSSystemId);
    }

    @Override
    protected String getSQL_getAllPSSysCsses(String strPSSystemId) {
        return super.getSQL_getAllPSSysCsses(strPSSystemId);
    }

    @Override
    protected String getSQL_getAllPSSysUniReses(String strPSSystemId) {
        return super.getSQL_getAllPSSysUniReses(strPSSystemId);
    }

    @Override
    protected String getSQL_getAllPSSysMsgTempls(String strPSSystemId) {
        return super.getSQL_getAllPSSysMsgTempls(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSAppPortalViewParts(String strPSAppPortalViewId) {
        return super.getSQL_getPSAppPortalViewParts(strPSAppPortalViewId);
    }

    @Override
    protected String getSQL_getAllPSSysPortlets(String strPSSystemId) {
        return super.getSQL_getAllPSSysPortlets(strPSSystemId);
    }

    @Override
    protected String getSQL_getAllPSSysValueRules(String strPSSystemId) {
        return super.getSQL_getAllPSSysValueRules(strPSSystemId);
    }

    @Override
    protected String getSQL_getAllPSSysPDTViews(String strPSSystemId) {
        return super.getSQL_getAllPSSysPDTViews(strPSSystemId);
    }

    @Override
    protected String getSQL_getAllPSSysPFPlugins(String strPSSystemId) {
        return super.getSQL_getAllPSSysPFPlugins(strPSSystemId);
    }

    @Override
    protected String getSQL_getAllPSSysPFPluginTempls(String strPSSystemId) {
        return super.getSQL_getAllPSSysPFPluginTempls(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSCounterType(String strPSCounterTypeId) {
        return super.getSQL_getPSCounterType(strPSCounterTypeId);
    }

    @Override
    protected String getSQL_getAllPSSysCounters(String strPSSystemId) {
        return super.getSQL_getAllPSSysCounters(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSCounter(String strPSCounterId) {
        return super.getSQL_getPSCounter(strPSCounterId);
    }

    @Override
    protected String getSQL_getAllPSSysDictCats(String strPSSystemId) {
        return super.getSQL_getAllPSSysDictCats(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSBackService(String strPSBackServiceId) {
        return super.getSQL_getPSBackService(strPSBackServiceId);
    }

    @Override
    protected String getSQL_getAllPSSysEditorStyles(String strPSSystemId) {
        return super.getSQL_getAllPSSysEditorStyles(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEDBIndexs(String strPSDataEntityId) {
        return super.getSQL_getPSDEDBIndexs(strPSDataEntityId);
    }

    @Override
    protected String getSQL_getPSDEDBIndexsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEDBIndexsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEDBIndexFields(String strPSDEDataQueryId) {
        return super.getSQL_getPSDEDBIndexFields(strPSDEDataQueryId);
    }

    @Override
    protected String getSQL_getPSDEDBIndexFieldsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEDBIndexFieldsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getAllPSSysIssueEngines() {
        return super.getSQL_getAllPSSysIssueEngines();
    }

    @Override
    protected String getSQL_getAllPSSysViewLogics(String strPSSystemId) {
        return super.getSQL_getAllPSSysViewLogics(strPSSystemId);
    }

    @Override
    protected String getSQL_getAllPSSysDMItems(String strPSSystemId) {
        return super.getSQL_getAllPSSysDMItems(strPSSystemId);
    }

    @Override
    protected String getSQL_getAllPSSysUserCases(String strPSSystemId) {
        return super.getSQL_getAllPSSysUserCases(strPSSystemId);
    }

    @Override
    protected String getSQL_getAllPSSysTestCases(String strPSSystemId) {
        return super.getSQL_getAllPSSysTestCases(strPSSystemId);
    }

    @Override
    protected String getSQL_getAllPSSysTestDatas(String strPSSystemId) {
        return super.getSQL_getAllPSSysTestDatas(strPSSystemId);
    }

    @Override
    protected String getSQL_getAllPSSysSampleValues(String strPSSystemId) {
        return super.getSQL_getAllPSSysSampleValues(strPSSystemId);
    }

    @Override
    protected String getSQL_getAllPSSysUserModes(String strPSSystemId) {
        return super.getSQL_getAllPSSysUserModes(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSAppUserMode(String strPSAppUserModeId) {
        return super.getSQL_getPSAppUserMode(strPSAppUserModeId);
    }

    @Override
    protected String getSQL_getPSAppUITheme(String strPSAppUIThemeId) {
        return super.getSQL_getPSAppUITheme(strPSAppUIThemeId);
    }

    @Override
    protected String getSQL_getAllPSSysERMaps(String strPSSystemId) {
        return super.getSQL_getAllPSSysERMaps(strPSSystemId);
    }

    @Override
    protected String getSQL_getAllPSSysDynaModels(String strPSSystemId) {
        return super.getSQL_getAllPSSysDynaModels(strPSSystemId);
    }

    @Override
    protected String getSQL_getAllPSSysSFPubs(String strPSSystemId) {
        return super.getSQL_getAllPSSysSFPubs(strPSSystemId);
    }

    @Override
    protected String getSQL_getAllPSSysDataSyncAgents(String strPSSystemId) {
        return super.getSQL_getAllPSSysDataSyncAgents(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEDataSync(String strPSDEDataSyncId) {
        return super.getSQL_getPSDEDataSync(strPSDEDataSyncId);
    }

    @Override
    protected String getSQL_getPSDEDataSyncs(String strPSDEId) {
        return super.getSQL_getPSDEDataSyncs(strPSDEId);
    }

    @Override
    protected String getSQL_getPSDEDataSyncsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEDataSyncsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getAllPSSysUserDRs(String strPSSystemId) {
        return super.getSQL_getAllPSSysUserDRs(strPSSystemId);
    }

    @Override
    protected String getSQL_getAllPSSysBDSchemes(String strPSSystemId) {
        return super.getSQL_getAllPSSysBDSchemes(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSAppLan(String strPSAppLanId) {
        return super.getSQL_getPSAppLan(strPSAppLanId);
    }

    @Override
    protected String getSQL_getPSBDType(String strPSBDTypeId) {
        return super.getSQL_getPSBDType(strPSBDTypeId);
    }

    @Override
    protected String getSQL_getPSDEBDTablesBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEBDTablesBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEBDTables(String strPSDEId) {
        return super.getSQL_getPSDEBDTables(strPSDEId);
    }

    @Override
    protected String getSQL_getAllPSViewMsgs(String strPSSystemId) {
        return super.getSQL_getAllPSViewMsgs(strPSSystemId);
    }

    @Override
    protected String getSQL_getAllPSViewMsgGroups(String strPSSystemId) {
        return super.getSQL_getAllPSViewMsgGroups(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEDataExport(String strPSDEDataExportId) {
        return super.getSQL_getPSDEDataExport(strPSDEDataExportId);
    }

    @Override
    protected String getSQL_getPSDEDataExports(String strPSDEId) {
        return super.getSQL_getPSDEDataExports(strPSDEId);
    }

    @Override
    protected String getSQL_getPSDEDataExportsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEDataExportsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEDataImport(String strPSDEDataImportId) {
        return super.getSQL_getPSDEDataImport(strPSDEDataImportId);
    }

    @Override
    protected String getSQL_getPSDEDataImports(String strPSDEId) {
        return super.getSQL_getPSDEDataImports(strPSDEId);
    }

    @Override
    protected String getSQL_getPSDEDataImportsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEDataImportsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEDataImportItems(String strPSDEDataImportId) {
        return super.getSQL_getPSDEDataImportItems(strPSDEDataImportId);
    }

    @Override
    protected String getSQL_getPSDEDataImportItemsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEDataImportItemsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEDataExportItems(String strPSDEDataExportId) {
        return super.getSQL_getPSDEDataExportItems(strPSDEDataExportId);
    }

    @Override
    protected String getSQL_getPSDEDataExportItemsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEDataExportItemsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEActionWizard(String strPSDEActionWizardId) {
        return super.getSQL_getPSDEActionWizard(strPSDEActionWizardId);
    }

    @Override
    protected String getSQL_getPSDEActionWizards(String strPSDEId) {
        return super.getSQL_getPSDEActionWizards(strPSDEId);
    }

    @Override
    protected String getSQL_getPSDEActionWizardsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEActionWizardsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEActionWizardItems(String strPSDEActionWizardId) {
        return super.getSQL_getPSDEActionWizardItems(strPSDEActionWizardId);
    }

    @Override
    protected String getSQL_getPSDEActionWizardItemsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEActionWizardItemsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEActionWizardGroups(String strPSDEId) {
        return super.getSQL_getPSDEActionWizardGroups(strPSDEId);
    }

    @Override
    protected String getSQL_getPSDEActionWizardGroupsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEActionWizardGroupsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEActionWizardGroupDetails(String strPSDEActionWizardGroupId) {
        return super.getSQL_getPSDEActionWizardGroupDetails(strPSDEActionWizardGroupId);
    }

    @Override
    protected String getSQL_getPSDEActionWizardGroupDetailsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEActionWizardGroupDetailsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getAllPSWXAccounts(String strPSSystemId) {
        return super.getSQL_getAllPSWXAccounts(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSCtrlMsg(String strPSCtrlMsgId) {
        return super.getSQL_getPSCtrlMsg(strPSCtrlMsgId);
    }

    @Override
    protected String getSQL_getAllPSSysUnits(String strPSSystemId) {
        return super.getSQL_getAllPSSysUnits(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSAppPkg(String strPSAppPkgId) {
        return super.getSQL_getPSAppPkg(strPSAppPkgId);
    }

    @Override
    protected String getSQL_getAllPSSysLans(String strPSSystemId) {
        return super.getSQL_getAllPSSysLans(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDCDBInst(String strPSDCDBInstId) {
        return super.getSQL_getPSDCDBInst(strPSDCDBInstId);
    }

    @Override
    protected String getSQL_getPSDCDBInst(String strPSDevCenterASId, String strDBType) {
        return super.getSQL_getPSDCDBInst(strPSDevCenterASId, strDBType);
    }

    @Override
    protected String getSQL_getPSDCASGroup(String strPSDCASGroupId) {
        return super.getSQL_getPSDCASGroup(strPSDCASGroupId);
    }

    @Override
    protected String getSQL_getPSASGroup(String strPSASGroupId) {
        return super.getSQL_getPSASGroup(strPSASGroupId);
    }

    @Override
    protected String getSQL_getPSDCMQInst(String strPSDCMQInstId) {
        return super.getSQL_getPSDCMQInst(strPSDCMQInstId);
    }

    @Override
    protected String getSQL_getPSDCRobots(String strPSDevCenterId) {
        return super.getSQL_getPSDCRobots(strPSDevCenterId);
    }

    @Override
    protected String getSQL_getAllPSSysUniStates(String strPSSystemId) {
        return super.getSQL_getAllPSSysUniStates(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSBookingResType(String strPSBookingResTypeId) {
        return super.getSQL_getPSBookingResType(strPSBookingResTypeId);
    }

    @Override
    protected String getSQL_getAllPSSysDEFTypes(String strPSSystemId) {
        return super.getSQL_getAllPSSysDEFTypes(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDCMobAppPackCerts(String strPSDevCenterId) {
        return super.getSQL_getPSDCMobAppPackCerts(strPSDevCenterId);
    }

    @Override
    protected String getSQL_getPSDCMobAppTestDevices(String strPSDevCenterId) {
        return super.getSQL_getPSDCMobAppTestDevices(strPSDevCenterId);
    }

    @Override
    protected String getSQL_getAllPSSysLogics(String strPSSystemId) {
        return super.getSQL_getAllPSSysLogics(strPSSystemId);
    }

    @Override
    protected String getSQL_getAllPSSysSearchBars(String strPSSystemId) {
        return super.getSQL_getAllPSSysSearchBars(strPSSystemId);
    }

    @Override
    protected String getSQL_getAllPSSysServiceAPIs(String strPSSystemId) {
        return super.getSQL_getAllPSSysServiceAPIs(strPSSystemId);
    }

    @Override
    protected String getSQL_getAllPSSysDTSQueues(String strPSSystemId) {
        return super.getSQL_getAllPSSysDTSQueues(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDCDeployServer(String strPSDCDeployServerId) {
        return super.getSQL_getPSDCDeployServer(strPSDCDeployServerId);
    }

    @Override
    protected String getSQL_getDefaultPSDCDeployServer(String strPSDevCenterId) {
        return super.getSQL_getDefaultPSDCDeployServer(strPSDevCenterId);
    }

    @Override
    protected String getSQL_getAllPSSysDashboards(String strPSSystemId) {
        return super.getSQL_getAllPSSysDashboards(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSAppLocalDE(String strPSAppLocalDEId) {
        return super.getSQL_getPSAppLocalDE(strPSAppLocalDEId);
    }

    @Override
    protected String getSQL_getAllPSSysSFPlugins(String strPSSystemId) {
        return super.getSQL_getAllPSSysSFPlugins(strPSSystemId);
    }

    @Override
    protected String getSQL_getAllPSSysSFPluginTempls(String strPSSystemId) {
        return super.getSQL_getAllPSSysSFPluginTempls(strPSSystemId);
    }

    @Override
    protected String getSQL_getAllPSSysUtils(String strPSSystemId) {
        return super.getSQL_getAllPSSysUtils(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDCCodeSnippet(String strPSDCCodeSnippetId) {
        return super.getSQL_getPSDCCodeSnippet(strPSDCCodeSnippetId);
    }

    @Override
    protected String getSQL_getPSDCCodeSnippetRefs(String strPSDCCodeSnippetId) {
        return super.getSQL_getPSDCCodeSnippetRefs(strPSDCCodeSnippetId);
    }

    @Override
    protected String getSQL_getPSCodeSnippetType(String strPSCodeSnippetTypeId) {
        return super.getSQL_getPSCodeSnippetType(strPSCodeSnippetTypeId);
    }

    @Override
    protected String getSQL_getPSDCDeployCenter(String strPSDCDeployCenterId) {
        return super.getSQL_getPSDCDeployCenter(strPSDCDeployCenterId);
    }

    @Override
    protected String getSQL_getDefaultPSDCDeployCenter(String strPSDevCenterId) {
        return super.getSQL_getDefaultPSDCDeployCenter(strPSDevCenterId);
    }

    @Override
    protected String getSQL_getPSDCWorkshopServer(String strPSDCWorkshopServerId) {
        return super.getSQL_getPSDCWorkshopServer(strPSDCWorkshopServerId);
    }

    @Override
    protected String getSQL_getDefaultPSDCWorkshopServer(String strPSDevCenterId) {
        return super.getSQL_getDefaultPSDCWorkshopServer(strPSDevCenterId);
    }

    @Override
    protected String getSQL_getPSDCMSPlatform(String strPSDCMSPlatformId) {
        return super.getSQL_getPSDCMSPlatform(strPSDCMSPlatformId);
    }

    @Override
    protected String getSQL_getPSDCMSPlatformFuncs(String strPSDCMSPlatformId) {
        return super.getSQL_getPSDCMSPlatformFuncs(strPSDCMSPlatformId);
    }

    @Override
    protected String getSQL_getPSDCMSPlatformNodes(String strPSDCMSPlatformId) {
        return super.getSQL_getPSDCMSPlatformNodes(strPSDCMSPlatformId);
    }

    @Override
    protected String getSQL_getAllPSSysTitleBars(String strPSSystemId) {
        return super.getSQL_getAllPSSysTitleBars(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSAppTitleBar(String strPSAppTitleBarId) {
        return super.getSQL_getPSAppTitleBar(strPSAppTitleBarId);
    }

    @Override
    protected String getSQL_getPSDBServer(String strPSDBServerId) {
        return super.getSQL_getPSDBServer(strPSDBServerId);
    }

    @Override
    protected String getSQL_getAllPSSysDMVers(String strPSSystemId) {
        return super.getSQL_getAllPSSysDMVers(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEActionTempl(String strPSDEActionTemplId) {
        return super.getSQL_getPSDEActionTempl(strPSDEActionTemplId);
    }

    @Override
    protected String getSQL_getAllPSSysCalendars(String strPSSystemId) {
        return super.getSQL_getAllPSSysCalendars(strPSSystemId);
    }

    @Override
    protected String getSQL_getAllPSSysPanels(String strPSSystemId) {
        return super.getSQL_getAllPSSysPanels(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSAppUtilView(String strPSAppUtilViewId) {
        return super.getSQL_getPSAppUtilView(strPSAppUtilViewId);
    }

    @Override
    protected String getSQL_getPSAppPanelView(String strPSAppPanelViewId) {
        return super.getSQL_getPSAppPanelView(strPSAppPanelViewId);
    }

    @Override
    protected String getSQL_getAllPSSysServiceAPIHandlers(String strPSSystemId) {
        return super.getSQL_getAllPSSysServiceAPIHandlers(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSAppPDTView(String strPSAppPDTViewId) {
        return super.getSQL_getPSAppPDTView(strPSAppPDTViewId);
    }

    @Override
    protected String getSQL_getAllPSDEFieldTypes() {
        return super.getSQL_getAllPSDEFieldTypes();
    }

    @Override
    protected String getSQL_getAllPSApplicationViews(String strPSApplicationId) {
        return super.getSQL_getAllPSApplicationViews(strPSApplicationId);
    }

    @Override
    protected String getSQL_getAllPSAppUtilPages(String strPSApplicationId) {
        return super.getSQL_getAllPSAppUtilPages(strPSApplicationId);
    }

    @Override
    protected String getSQL_getAllPSAppViewCodes(String strPSApplicationId) {
        return super.getSQL_getAllPSAppViewCodes(strPSApplicationId);
    }

    @Override
    protected String getSQL_getAllPSDEViewBasesBySystem(String strPSSystemId) {
        return super.getSQL_getAllPSDEViewBasesBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getAllPSAppModules(String strPSApplicationId) {
        return super.getSQL_getAllPSAppModules(strPSApplicationId);
    }

    @Override
    protected String getSQL_getAllPSAppFuncs(String strPSApplicationId) {
        return super.getSQL_getAllPSAppFuncs(strPSApplicationId);
    }

    @Override
    protected String getSQL_getAllPSDataEntities(String strPSSystemId) {
        return super.getSQL_getAllPSDataEntities(strPSSystemId);
    }

    @Override
    protected String getSQL_getAllPSCodeLists(String strPSSystemId) {
        return super.getSQL_getAllPSCodeLists(strPSSystemId);
    }

    @Override
    protected String getSQL_getAllPSAppMenus(String strPSApplicationId) {
        return super.getSQL_getAllPSAppMenus(strPSApplicationId);
    }

    @Override
    protected String getSQL_getAllPSDERs(String strPSSystemId) {
        return super.getSQL_getAllPSDERs(strPSSystemId);
    }

    @Override
    protected String getSQL_getAllPSSubDEs(String strPSSubSysId) {
        return super.getSQL_getAllPSSubDEs(strPSSubSysId);
    }

    @Override
    protected String getSQL_getAllPSSubDEViews(String strPSSubSysId) {
        return super.getSQL_getAllPSSubDEViews(strPSSubSysId);
    }

    @Override
    protected String getSQL_getAllPSSubSysSFs(String strPSSubSysId) {
        return super.getSQL_getAllPSSubSysSFs(strPSSubSysId);
    }

    @Override
    protected String getSQL_getAllPSAppSubApps(String strPSApplicationId) {
        return super.getSQL_getAllPSAppSubApps(strPSApplicationId);
    }

    @Override
    protected String getSQL_getAllPSSubViewTypes(String strPSSystemId) {
        return super.getSQL_getAllPSSubViewTypes(strPSSystemId);
    }

    @Override
    protected String getSQL_getAllPSSubSysVers(String strPSSubSysId) {
        return super.getSQL_getAllPSSubSysVers(strPSSubSysId);
    }

    @Override
    protected String getSQL_getAllPSAppUserModes(String strPSApplicationId) {
        return super.getSQL_getAllPSAppUserModes(strPSApplicationId);
    }

    @Override
    protected String getSQL_getAllPSAppUIThemes(String strPSApplicationId) {
        return super.getSQL_getAllPSAppUIThemes(strPSApplicationId);
    }

    @Override
    protected String getSQL_getAllPSAppLans(String strPSApplicationId) {
        return super.getSQL_getAllPSAppLans(strPSApplicationId);
    }

    @Override
    protected String getSQL_getAllPSCtrlMsgs(String strPSSystemId) {
        return super.getSQL_getAllPSCtrlMsgs(strPSSystemId);
    }

    @Override
    protected String getSQL_getAllPSAppPkgs(String strPSApplicationId) {
        return super.getSQL_getAllPSAppPkgs(strPSApplicationId);
    }

    @Override
    protected String getSQL_getAllPSHelpArticles(String strPSSystemId) {
        return super.getSQL_getAllPSHelpArticles(strPSSystemId);
    }

    @Override
    protected String getSQL_getAllPSHelpSections(String strPSSystemId) {
        return super.getSQL_getAllPSHelpSections(strPSSystemId);
    }

    @Override
    protected String getSQL_getAllPSHelpModules(String strPSSystemId) {
        return super.getSQL_getAllPSHelpModules(strPSSystemId);
    }

    @Override
    protected String getSQL_getAllPSHelpPrjs(String strPSSystemId) {
        return super.getSQL_getAllPSHelpPrjs(strPSSystemId);
    }

    @Override
    protected String getSQL_getAllPSHelpResources(String strPSSystemId) {
        return super.getSQL_getAllPSHelpResources(strPSSystemId);
    }

    @Override
    protected String getSQL_getAllPSDepSlnHosts(String strPSDepSlnId) {
        return super.getSQL_getAllPSDepSlnHosts(strPSDepSlnId);
    }

    @Override
    protected String getSQL_getAllPSDepSlnDBInsts(String strPSDepSlnId) {
        return super.getSQL_getAllPSDepSlnDBInsts(strPSDepSlnId);
    }

    @Override
    protected String getSQL_getAllPSDepSlnMQInsts(String strPSDepSlnId) {
        return super.getSQL_getAllPSDepSlnMQInsts(strPSDepSlnId);
    }

    @Override
    protected String getSQL_getAllPSDepSlnASes(String strPSDepSlnId) {
        return super.getSQL_getAllPSDepSlnASes(strPSDepSlnId);
    }

    @Override
    protected String getSQL_getAllPSDepSlnASGroups(String strPSDepSlnId) {
        return super.getSQL_getAllPSDepSlnASGroups(strPSDepSlnId);
    }

    @Override
    protected String getSQL_getAllPSDepSlnASGroupItems(String strPSDepSlnId) {
        return super.getSQL_getAllPSDepSlnASGroupItems(strPSDepSlnId);
    }

    @Override
    protected String getSQL_getAllPSDepSlnSyses(String strPSDepSlnId) {
        return super.getSQL_getAllPSDepSlnSyses(strPSDepSlnId);
    }

    @Override
    protected String getSQL_getAllPSDepSlnSysDBs(String strPSDepSlnId) {
        return super.getSQL_getAllPSDepSlnSysDBs(strPSDepSlnId);
    }

    @Override
    protected String getSQL_getAllPSDepSlnSysMQs(String strPSDepSlnId) {
        return super.getSQL_getAllPSDepSlnSysMQs(strPSDepSlnId);
    }

    @Override
    protected String getSQL_getAllPSDepSlnSysASes(String strPSDepSlnId) {
        return super.getSQL_getAllPSDepSlnSysASes(strPSDepSlnId);
    }

    @Override
    protected String getSQL_getAllPSDepSysApps(String strPSDepSysVerId) {
        return super.getSQL_getAllPSDepSysApps(strPSDepSysVerId);
    }

    @Override
    protected String getSQL_getAllPSDEFInputTipSets(String strPSSystemId) {
        return super.getSQL_getAllPSDEFInputTipSets(strPSSystemId);
    }

    @Override
    protected String getSQL_getAllPSSubSysServiceAPIs(String strPSSystemId) {
        return super.getSQL_getAllPSSubSysServiceAPIs(strPSSystemId);
    }

    @Override
    protected String getSQL_getAllPSAppLocalDEs(String strPSApplicationId) {
        return super.getSQL_getAllPSAppLocalDEs(strPSApplicationId);
    }

    @Override
    protected String getSQL_getAllPSAppTitleBars(String strPSApplicationId) {
        return super.getSQL_getAllPSAppTitleBars(strPSApplicationId);
    }

    @Override
    protected String getSQL_getAllPSDEActionTempls(String strPSSystemId) {
        return super.getSQL_getAllPSDEActionTempls(strPSSystemId);
    }

    @Override
    protected String getSQL_getAllPSAppUIStyles(String strPSApplicationId) {
        return super.getSQL_getAllPSAppUIStyles(strPSApplicationId);
    }

    @Override
    protected String getSQL_getAllPSDynaDETempls(String strPSSystemId) {
        return super.getSQL_getAllPSDynaDETempls(strPSSystemId);
    }

    @Override
    protected String getSQL_getAllPSDynaDEViewTemplsBySystem(String strPSSystemId) {
        return super.getSQL_getAllPSDynaDEViewTemplsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getAllPSAppPDTViews(String strPSApplicationId) {
        return super.getSQL_getAllPSAppPDTViews(strPSApplicationId);
    }

    @Override
    protected String getSQL_getPSSystem(String strPSSystemId) {
        return super.getSQL_getPSSystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSSysWFSetting(String strPSSysWFSettingId) {
        return super.getSQL_getPSSysWFSetting(strPSSysWFSettingId);
    }

    @Override
    protected String getSQL_getPSSystemDeployDBs(String strPSSystemDeployId) {
        return super.getSQL_getPSSystemDeployDBs(strPSSystemDeployId);
    }

    @Override
    protected String getSQL_getPSSystemDBConfigs(String strPSSystemId) {
        return super.getSQL_getPSSystemDBConfigs(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSSystemDBConfig(String strPSSystemId, String strDBType) {
        return super.getSQL_getPSSystemDBConfig(strPSSystemId, strDBType);
    }

    @Override
    protected String getSQL_getPSSystemDeploy(String strPSSystemDeployId) {
        return super.getSQL_getPSSystemDeploy(strPSSystemDeployId);
    }

    @Override
    protected String getSQL_getPSSystemApplication(String strPSSystemApplicationId) {
        return super.getSQL_getPSSystemApplication(strPSSystemApplicationId);
    }

    @Override
    protected String getSQL_getPSViewType(String strPSViewTypeId) {
        return super.getSQL_getPSViewType(strPSViewTypeId);
    }

    @Override
    protected String getSQL_getPSToolbarItemType(String strPSToolbarItemTypeId) {
        return super.getSQL_getPSToolbarItemType(strPSToolbarItemTypeId);
    }

    @Override
    protected String getSQL_getPSV3Migrate(String strPSV3MigrateId) {
        return super.getSQL_getPSV3Migrate(strPSV3MigrateId);
    }

    @Override
    protected String getSQL_getPSViewTypeViews(String strPSViewTypeId) {
        return super.getSQL_getPSViewTypeViews(strPSViewTypeId);
    }

    @Override
    protected String getSQL_getPSViewTypeCtrls(String strPSViewTypeId) {
        return super.getSQL_getPSViewTypeCtrls(strPSViewTypeId);
    }

    @Override
    protected String getSQL_getPSViewLogicType(String strPSViewLogicTypeId) {
        return super.getSQL_getPSViewLogicType(strPSViewLogicTypeId);
    }

    @Override
    protected String getSQL_getPSSystemModule(String strPSSystemModuleId) {
        return super.getSQL_getPSSystemModule(strPSSystemModuleId);
    }

    @Override
    protected String getSQL_getPSSysRef(String strPSSysRefId) {
        return super.getSQL_getPSSysRef(strPSSysRefId);
    }

    @Override
    protected String getSQL_getPSSysRefDEs(String strPSSysRefId) {
        return super.getSQL_getPSSysRefDEs(strPSSysRefId);
    }

    @Override
    protected String getSQL_getPSVersions(String strPSWFId) {
        return super.getSQL_getPSVersions(strPSWFId);
    }

    @Override
    protected String getSQL_getPSVersionsBySystem(String strPSSystemId) {
        return super.getSQL_getPSVersionsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSWFProcesses(String strPSWFVersionId) {
        return super.getSQL_getPSWFProcesses(strPSWFVersionId);
    }

    @Override
    protected String getSQL_getPSWFProcessesBySystem(String strPSSystemId) {
        return super.getSQL_getPSWFProcessesBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSWFLinks(String strPSWFVersionId) {
        return super.getSQL_getPSWFLinks(strPSWFVersionId);
    }

    @Override
    protected String getSQL_getPSWFLinksBySystem(String strPSSystemId) {
        return super.getSQL_getPSWFLinksBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSWFLinkConds(String strPSWFVersionId) {
        return super.getSQL_getPSWFLinkConds(strPSWFVersionId);
    }

    @Override
    protected String getSQL_getPSWFLinkCondsBySystem(String strPSSystemId) {
        return super.getSQL_getPSWFLinkCondsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSWFProcParams(String strPSWFVersionId) {
        return super.getSQL_getPSWFProcParams(strPSWFVersionId);
    }

    @Override
    protected String getSQL_getPSWFProcParamsBySystem(String strPSSystemId) {
        return super.getSQL_getPSWFProcParamsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSWFProcSubWFs(String strPSWFVersionId) {
        return super.getSQL_getPSWFProcSubWFs(strPSWFVersionId);
    }

    @Override
    protected String getSQL_getPSWFProcSubWFsBySystem(String strPSSystemId) {
        return super.getSQL_getPSWFProcSubWFsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSWFProcessType(String strPSWFProcessTypeId) {
        return super.getSQL_getPSWFProcessType(strPSWFProcessTypeId);
    }

    @Override
    protected String getSQL_getPSWFLinkType(String strPSWFLinkTypeId) {
        return super.getSQL_getPSWFLinkType(strPSWFLinkTypeId);
    }

    @Override
    protected String getSQL_getPSWFLinkCondType(String strPSWFLinkCondTypeId) {
        return super.getSQL_getPSWFLinkCondType(strPSWFLinkCondTypeId);
    }

    @Override
    protected String getSQL_getPSWFDEs(String strPSDataEntityId) {
        return super.getSQL_getPSWFDEs(strPSDataEntityId);
    }

    @Override
    protected String getSQL_getPSWFDEsBySystem(String strPSSystemId) {
        return super.getSQL_getPSWFDEsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSWFDEsByWF(String strPSWFId) {
        return super.getSQL_getPSWFDEsByWF(strPSWFId);
    }

    @Override
    protected String getSQL_getPSWFUIActions(String strPSWFVersionId) {
        return super.getSQL_getPSWFUIActions(strPSWFVersionId);
    }

    @Override
    protected String getSQL_getPSWFUIActionsBySystem(String strPSSystemId) {
        return super.getSQL_getPSWFUIActionsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSWFUIActions2(String strPSWorkflowId) {
        return super.getSQL_getPSWFUIActions2(strPSWorkflowId);
    }

    @Override
    protected String getSQL_getPSWFUIActions2BySystem(String strPSSystemId) {
        return super.getSQL_getPSWFUIActions2BySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSWFUIActionGroups(String strPSWFVersionId) {
        return super.getSQL_getPSWFUIActionGroups(strPSWFVersionId);
    }

    @Override
    protected String getSQL_getPSWFUIActionGroupsBySystem(String strPSSystemId) {
        return super.getSQL_getPSWFUIActionGroupsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSWFUIActionGroups2(String strPSWorkflowId) {
        return super.getSQL_getPSWFUIActionGroups2(strPSWorkflowId);
    }

    @Override
    protected String getSQL_getPSWFUIActionGroups2BySystem(String strPSSystemId) {
        return super.getSQL_getPSWFUIActionGroups2BySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSSysImage(String strPSSysImageId) {
        return super.getSQL_getPSSysImage(strPSSysImageId);
    }

    @Override
    protected String getSQL_getPSSysUniRes(String strPSSysUniResId) {
        return super.getSQL_getPSSysUniRes(strPSSysUniResId);
    }

    @Override
    protected String getSQL_getPSSysMsgTempl(String strPSSysMsgTemplId) {
        return super.getSQL_getPSSysMsgTempl(strPSSysMsgTemplId);
    }

    @Override
    protected String getSQL_getPSSysPortlet(String strPSSysPortletId) {
        return super.getSQL_getPSSysPortlet(strPSSysPortletId);
    }

    @Override
    protected String getSQL_getPSSysValueRule(String strPSSysValueRuleId) {
        return super.getSQL_getPSSysValueRule(strPSSysValueRuleId);
    }

    @Override
    protected String getSQL_getPSSysRunSession(String strPSSysRunSessionId) {
        return super.getSQL_getPSSysRunSession(strPSSysRunSessionId);
    }

    @Override
    protected String getSQL_getPSSystemASes(String strPSSystemId) {
        return super.getSQL_getPSSystemASes(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSSystemAS(String strPSSystemASId) {
        return super.getSQL_getPSSystemAS(strPSSystemASId);
    }

    @Override
    protected String getSQL_getPSSysPDTView(String strPSSysPDTViewId) {
        return super.getSQL_getPSSysPDTView(strPSSysPDTViewId);
    }

    @Override
    protected String getSQL_getPSSysPFPlugin(String strPSSysPFPluginId) {
        return super.getSQL_getPSSysPFPlugin(strPSSysPFPluginId);
    }

    @Override
    protected String getSQL_getPSSysPFPluginTempl(String strPSSysPFPluginTemplId) {
        return super.getSQL_getPSSysPFPluginTempl(strPSSysPFPluginTemplId);
    }

    @Override
    protected String getSQL_getPSSysEditorStyle(String strPSSysEditorStyleId) {
        return super.getSQL_getPSSysEditorStyle(strPSSysEditorStyleId);
    }

    @Override
    protected String getSQL_getPSSysViewLogic(String strPSSysViewLogicId) {
        return super.getSQL_getPSSysViewLogic(strPSSysViewLogicId);
    }

    @Override
    protected String getSQL_getPSSysUserCase(String strPSSysUserCaseId) {
        return super.getSQL_getPSSysUserCase(strPSSysUserCaseId);
    }

    @Override
    protected String getSQL_getPSSysTestCase(String strPSSysTestCaseId) {
        return super.getSQL_getPSSysTestCase(strPSSysTestCaseId);
    }

    @Override
    protected String getSQL_getPSSysTestCaseAssertsBySystem(String strPSSystemId) {
        return super.getSQL_getPSSysTestCaseAssertsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSSysTestCaseInputsBySystem(String strPSSystemId) {
        return super.getSQL_getPSSysTestCaseInputsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSSysTestCaseInputs(String strPSSysTestCaseId) {
        return super.getSQL_getPSSysTestCaseInputs(strPSSysTestCaseId);
    }

    @Override
    protected String getSQL_getPSSysTestCaseAsserts(String strPSSysTestCaseInputId) {
        return super.getSQL_getPSSysTestCaseAsserts(strPSSysTestCaseInputId);
    }

    @Override
    protected String getSQL_getPSSysTestData(String strPSSysTestDataId) {
        return super.getSQL_getPSSysTestData(strPSSysTestDataId);
    }

    @Override
    protected String getSQL_getPSSysTestDataItemsBySystem(String strPSSystemId) {
        return super.getSQL_getPSSysTestDataItemsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSSysTestDataItems(String strPSSysTestDataId) {
        return super.getSQL_getPSSysTestDataItems(strPSSysTestDataId);
    }

    @Override
    protected String getSQL_getPSSysSampleValue(String strPSSysSampleValueId) {
        return super.getSQL_getPSSysSampleValue(strPSSysSampleValueId);
    }

    @Override
    protected String getSQL_getPSSysUserMode(String strPSSysUserModeId) {
        return super.getSQL_getPSSysUserMode(strPSSysUserModeId);
    }

    @Override
    protected String getSQL_getPSSysERMap(String strPSSysERMapId) {
        return super.getSQL_getPSSysERMap(strPSSysERMapId);
    }

    @Override
    protected String getSQL_getPSSysERMapNodesBySystem(String strPSSystemId) {
        return super.getSQL_getPSSysERMapNodesBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSSysERMapNodes(String strPSSysERMapId) {
        return super.getSQL_getPSSysERMapNodes(strPSSysERMapId);
    }

    @Override
    protected String getSQL_getPSSysDynaModelAttrsBySystem(String strPSSystemId) {
        return super.getSQL_getPSSysDynaModelAttrsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSSysDynaModelAttrs(String strPSSysDynaModelId) {
        return super.getSQL_getPSSysDynaModelAttrs(strPSSysDynaModelId);
    }

    @Override
    protected String getSQL_getPSSysSFPub(String strPSSysSFPubId) {
        return super.getSQL_getPSSysSFPub(strPSSysSFPubId);
    }

    @Override
    protected String getSQL_getPSSysDataSyncAgent(String strPSSysDataSyncAgentId) {
        return super.getSQL_getPSSysDataSyncAgent(strPSSysDataSyncAgentId);
    }

    @Override
    protected String getSQL_getPSSysSFCodes(String strPSSysSFPubId) {
        return super.getSQL_getPSSysSFCodes(strPSSysSFPubId);
    }

    @Override
    protected String getSQL_getPSSysUserDR(String strPSSysUserDRId) {
        return super.getSQL_getPSSysUserDR(strPSSysUserDRId);
    }

    @Override
    protected String getSQL_getPSViewMsg(String strPSViewMsgId) {
        return super.getSQL_getPSViewMsg(strPSViewMsgId);
    }

    @Override
    protected String getSQL_getPSViewMsgGroup(String strPSViewMsgGroupId) {
        return super.getSQL_getPSViewMsgGroup(strPSViewMsgGroupId);
    }

    @Override
    protected String getSQL_getPSViewMsgGroupDetails(String strPSViewMsgGroupId) {
        return super.getSQL_getPSViewMsgGroupDetails(strPSViewMsgGroupId);
    }

    @Override
    protected String getSQL_getPSViewMsgGroupDetailsBySystem(String strPSSystemId) {
        return super.getSQL_getPSViewMsgGroupDetailsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSSysModelLogs(String strPSSystemId) {
        return super.getSQL_getPSSysModelLogs(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSWXAccount(String strPSWXAccountId) {
        return super.getSQL_getPSWXAccount(strPSWXAccountId);
    }

    @Override
    protected String getSQL_getPSWXMenuItemsBySystem(String strPSSystemId) {
        return super.getSQL_getPSWXMenuItemsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSWXMenuItems(String strPSWXMenuId) {
        return super.getSQL_getPSWXMenuItems(strPSWXMenuId);
    }

    @Override
    protected String getSQL_getPSWXEntAppsBySystem(String strPSSystemId) {
        return super.getSQL_getPSWXEntAppsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSWXEntApps(String strPSWXAccountId) {
        return super.getSQL_getPSWXEntApps(strPSWXAccountId);
    }

    @Override
    protected String getSQL_getPSWXMenuFuncsBySystem(String strPSSystemId) {
        return super.getSQL_getPSWXMenuFuncsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSWXMenuFuncs(String strPSWXAccountId) {
        return super.getSQL_getPSWXMenuFuncs(strPSWXAccountId);
    }

    @Override
    protected String getSQL_getPSWXMenuFuncsByApp(String strPSWXEntAppId) {
        return super.getSQL_getPSWXMenuFuncsByApp(strPSWXEntAppId);
    }

    @Override
    protected String getSQL_getPSWXLogicsBySystem(String strPSSystemId) {
        return super.getSQL_getPSWXLogicsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSWXLogics(String strPSWXAccountId) {
        return super.getSQL_getPSWXLogics(strPSWXAccountId);
    }

    @Override
    protected String getSQL_getPSWXLogicsByApp(String strPSWXEntAppId) {
        return super.getSQL_getPSWXLogicsByApp(strPSWXEntAppId);
    }

    @Override
    protected String getSQL_getPSWXMenusBySystem(String strPSSystemId) {
        return super.getSQL_getPSWXMenusBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSWXMenus(String strPSWXAccountId) {
        return super.getSQL_getPSWXMenus(strPSWXAccountId);
    }

    @Override
    protected String getSQL_getPSWXMenusByApp(String strPSWXEntAppId) {
        return super.getSQL_getPSWXMenusByApp(strPSWXEntAppId);
    }

    @Override
    protected String getSQL_getPSWXMenu(String strPSWXMenuId) {
        return super.getSQL_getPSWXMenu(strPSWXMenuId);
    }

    @Override
    protected String getSQL_getPSSysUnit(String strPSSysUnitId) {
        return super.getSQL_getPSSysUnit(strPSSysUnitId);
    }

    @Override
    protected String getSQL_getPSSysSFPubPkgs(String strPSSysSFPubId) {
        return super.getSQL_getPSSysSFPubPkgs(strPSSysSFPubId);
    }

    @Override
    protected String getSQL_getPSSysEngineConfig(String strPSSysEngineConfigId) {
        return super.getSQL_getPSSysEngineConfig(strPSSysEngineConfigId);
    }

    @Override
    protected String getSQL_getPSSysUniState(String strPSSysUniStateId) {
        return super.getSQL_getPSSysUniState(strPSSysUniStateId);
    }

    @Override
    protected String getSQL_getPSSysLogic(String strPSSysLogicId) {
        return super.getSQL_getPSSysLogic(strPSSysLogicId);
    }

    @Override
    protected String getSQL_getPSSysSearchBar(String strPSSysSearchBarId) {
        return super.getSQL_getPSSysSearchBar(strPSSysSearchBarId);
    }

    @Override
    protected String getSQL_getPSSysSearchBarItemsBySystem(String strPSSystemId) {
        return super.getSQL_getPSSysSearchBarItemsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSSysSearchBarItems(String strPSSysSearchBarId) {
        return super.getSQL_getPSSysSearchBarItems(strPSSysSearchBarId);
    }

    @Override
    protected String getSQL_getPSViewEngine(String strPSViewEngineId) {
        return super.getSQL_getPSViewEngine(strPSViewEngineId);
    }

    @Override
    protected String getSQL_getPSSysServiceAPI(String strPSSysServiceAPIId) {
        return super.getSQL_getPSSysServiceAPI(strPSSysServiceAPIId);
    }

    @Override
    protected String getSQL_getPSSysUserRole(String strPSSysUserRoleId) {
        return super.getSQL_getPSSysUserRole(strPSSysUserRoleId);
    }

    @Override
    protected String getSQL_getPSSysDashboardPartsBySystem(String strPSSystemId) {
        return super.getSQL_getPSSysDashboardPartsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSSysUserRoleResesBySystem(String strPSSystemId) {
        return super.getSQL_getPSSysUserRoleResesBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSSysUserRoleRess(String strPSSysUserRoleId) {
        return super.getSQL_getPSSysUserRoleRess(strPSSysUserRoleId);
    }

    @Override
    protected String getSQL_getPSSysSFPlugin(String strPSSysSFPluginId) {
        return super.getSQL_getPSSysSFPlugin(strPSSysSFPluginId);
    }

    @Override
    protected String getSQL_getPSSysSFPluginTempl(String strPSSysSFPluginTemplId) {
        return super.getSQL_getPSSysSFPluginTempl(strPSSysSFPluginTemplId);
    }

    @Override
    protected String getSQL_getPSSysUtil(String strPSSysUtilId) {
        return super.getSQL_getPSSysUtil(strPSSysUtilId);
    }

    @Override
    protected String getSQL_getPSWorkshopServer(String strPSWorkshopServerId) {
        return super.getSQL_getPSWorkshopServer(strPSWorkshopServerId);
    }

    @Override
    protected String getSQL_getPSSysTitleBar(String strPSSysTitleBarId) {
        return super.getSQL_getPSSysTitleBar(strPSSysTitleBarId);
    }

    @Override
    protected String getSQL_getPSSysPanel(String strPSSysPanelId) {
        return super.getSQL_getPSSysPanel(strPSSysPanelId);
    }

    @Override
    protected String getSQL_getPSSysPanelItemsBySystem(String strPSSystemId) {
        return super.getSQL_getPSSysPanelItemsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSSysPanelItems(String strPSSysPanelId) {
        return super.getSQL_getPSSysPanelItems(strPSSysPanelId);
    }

    @Override
    protected String getSQL_getPSSysPanelModelsBySystem(String strPSSystemId) {
        return super.getSQL_getPSSysPanelModelsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSSysPanelModels(String strPSSysPanelId) {
        return super.getSQL_getPSSysPanelModels(strPSSysPanelId);
    }

    @Override
    protected String getSQL_getPSSysPanelLogicsBySystem(String strPSSystemId) {
        return super.getSQL_getPSSysPanelLogicsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSSysPanelLogics(String strPSSysPanelId) {
        return super.getSQL_getPSSysPanelLogics(strPSSysPanelId);
    }

    @Override
    protected String getSQL_getPSSysUtilType(String strPSSysUtilTypeId) {
        return super.getSQL_getPSSysUtilType(strPSSysUtilTypeId);
    }

    @Override
    protected String getSQL_getPSSysServiceAPIHandler(String strPSSysServiceAPIHandlerId) {
        return super.getSQL_getPSSysServiceAPIHandler(strPSSysServiceAPIHandlerId);
    }

    @Override
    protected String getSQL_getPSUIEngineType(String strPSUIEngineTypeId) {
        return super.getSQL_getPSUIEngineType(strPSUIEngineTypeId);
    }

    @Override
    protected String getSQL_getPSDevCenter(String strPSDevCenterId) {
        return super.getSQL_getPSDevCenter(strPSDevCenterId);
    }

    @Override
    protected String getSQL_getPSDevSln(String strPSDevSlnId) {
        return super.getSQL_getPSDevSln(strPSDevSlnId);
    }

    @Override
    protected String getSQL_getPSDevSlnSys(String strPSDevSlnSysId) {
        return super.getSQL_getPSDevSlnSys(strPSDevSlnSysId);
    }

    @Override
    protected String getSQL_getPSModelInit(String strPSModelInitId) {
        return super.getSQL_getPSModelInit(strPSModelInitId);
    }

    @Override
    protected String getSQL_getPSModelInitSteps(String strPSModelInitId) {
        return super.getSQL_getPSModelInitSteps(strPSModelInitId);
    }

    @Override
    protected String getSQL_getPSDEFieldType(String strPSDEFieldTypeId) {
        return super.getSQL_getPSDEFieldType(strPSDEFieldTypeId);
    }

    @Override
    protected String getSQL_getPSDEFieldsNoSort(String strPSDataEntityId) {
        return super.getSQL_getPSDEFieldsNoSort(strPSDataEntityId);
    }

    @Override
    protected String getSQL_getPSDEFieldsNoSortBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEFieldsNoSortBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEField(String strPSDEFieldId) {
        return super.getSQL_getPSDEField(strPSDEFieldId);
    }

    @Override
    protected String getSQL_getPSDEFDTColumns(String strPSDataEntityId, String strDBType) {
        return super.getSQL_getPSDEFDTColumns(strPSDataEntityId, strDBType);
    }

    @Override
    protected String getSQL_getPSDEToolbarsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEToolbarsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEToolbarItemsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEToolbarItemsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEFormsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEFormsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEGridsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEGridsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEFormDetailsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEFormDetailsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEGridColumnsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEGridColumnsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSEditorType(String strPSEditorTypeId) {
        return super.getSQL_getPSEditorType(strPSEditorTypeId);
    }

    @Override
    protected String getSQL_getPSPFStyle(String strPSPFStyleId) {
        return super.getSQL_getPSPFStyle(strPSPFStyleId);
    }

    @Override
    protected String getSQL_getPSPFStyleRefreshVersion(String strPSPFStyleId) {
        return super.getSQL_getPSPFStyleRefreshVersion(strPSPFStyleId);
    }

    @Override
    protected String getSQL_getPSPFCodeFolder(String strPSPFCodeFolderId) {
        return super.getSQL_getPSPFCodeFolder(strPSPFCodeFolderId);
    }

    @Override
    protected String getSQL_getPSPFPubCodes(String strPSPFId) {
        return super.getSQL_getPSPFPubCodes(strPSPFId);
    }

    @Override
    protected String getSQL_getPSPFPubCodesByPPSPFPubCode(String strPSPFPubCodeId) {
        return super.getSQL_getPSPFPubCodesByPPSPFPubCode(strPSPFPubCodeId);
    }

    @Override
    protected String getSQL_getPSPFViewTempl(String strPSPFViewTemplId) {
        return super.getSQL_getPSPFViewTempl(strPSPFViewTemplId);
    }

    @Override
    protected String getSQL_getPSPFViewTemplsByPF(String strPSPFId) {
        return super.getSQL_getPSPFViewTemplsByPF(strPSPFId);
    }

    @Override
    protected String getSQL_getPSPFViewTemplsByPFStyle(String strPSPFStyleId) {
        return super.getSQL_getPSPFViewTemplsByPFStyle(strPSPFStyleId);
    }

    @Override
    protected String getSQL_getPSPFPubCode(String strPSPFPubCodeId) {
        return super.getSQL_getPSPFPubCode(strPSPFPubCodeId);
    }

    @Override
    protected String getSQL_getPSDEUIActionType(String strPSDEUIActionTypeId) {
        return super.getSQL_getPSDEUIActionType(strPSDEUIActionTypeId);
    }

    @Override
    protected String getSQL_getPSPFCtrlTempl(String strPSPFCtrlTemplId) {
        return super.getSQL_getPSPFCtrlTempl(strPSPFCtrlTemplId);
    }

    @Override
    protected String getSQL_getPSDEGridColumnType(String strPSDEGridColumnTypeId) {
        return super.getSQL_getPSDEGridColumnType(strPSDEGridColumnTypeId);
    }

    @Override
    protected String getSQL_getPSDEFGridColumns(String strPSDEFieldId) {
        return super.getSQL_getPSDEFGridColumns(strPSDEFieldId);
    }

    @Override
    protected String getSQL_getPSDEGridColumns(String strPSDEGridId) {
        return super.getSQL_getPSDEGridColumns(strPSDEGridId);
    }

    @Override
    protected String getSQL_getPSPFCtrlTemplDetails(String strPSPFCtrlTemplId) {
        return super.getSQL_getPSPFCtrlTemplDetails(strPSPFCtrlTemplId);
    }

    @Override
    protected String getSQL_getPSDERType(String strPSDERTypeId) {
        return super.getSQL_getPSDERType(strPSDERTypeId);
    }

    @Override
    protected String getSQL_getPSDEToolbarItems(String strPSDEToolbarId) {
        return super.getSQL_getPSDEToolbarItems(strPSDEToolbarId);
    }

    @Override
    protected String getSQL_getPSDEUIActionsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEUIActionsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEUIActions(String strPSDataEntityId) {
        return super.getSQL_getPSDEUIActions(strPSDataEntityId);
    }

    @Override
    protected String getSQL_getPSSysDEUIActions(String strPSSystemId) {
        return super.getSQL_getPSSysDEUIActions(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEUIAction(String strPSDEUIActionId) {
        return super.getSQL_getPSDEUIAction(strPSDEUIActionId);
    }

    @Override
    protected String getSQL_getPSDEUIActionGroup(String strPSDEUIActionGroupId) {
        return super.getSQL_getPSDEUIActionGroup(strPSDEUIActionGroupId);
    }

    @Override
    protected String getSQL_getPSFormType(String strPSFormTypeId) {
        return super.getSQL_getPSFormType(strPSFormTypeId);
    }

    @Override
    protected String getSQL_getPSDEFormDetails(String strPSDEFormId) {
        return super.getSQL_getPSDEFormDetails(strPSDEFormId);
    }

    @Override
    protected String getSQL_getPSFormDetailType(String strPSFormDetailTypeId) {
        return super.getSQL_getPSFormDetailType(strPSFormDetailTypeId);
    }

    @Override
    protected String getSQL_getPSDEFGridColumnsByDataEntity(String strPSDEId) {
        return super.getSQL_getPSDEFGridColumnsByDataEntity(strPSDEId);
    }

    @Override
    protected String getSQL_getPSDEFGridColumnsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEFGridColumnsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEFUIModesByDataEntity(String strPSDEId) {
        return super.getSQL_getPSDEFUIModesByDataEntity(strPSDEId);
    }

    @Override
    protected String getSQL_getPSDEFUIModesBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEFUIModesBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEFSearchModesByDataEntity(String strPSDEId) {
        return super.getSQL_getPSDEFSearchModesByDataEntity(strPSDEId);
    }

    @Override
    protected String getSQL_getPSDEFSearchModesBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEFSearchModesBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEFDTColumnsByDataEntity(String strPSDEId) {
        return super.getSQL_getPSDEFDTColumnsByDataEntity(strPSDEId);
    }

    @Override
    protected String getSQL_getPSDEFDTColumnsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEFDTColumnsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSPFEditorTempl(String strPSPFEditorTemplId) {
        return super.getSQL_getPSPFEditorTempl(strPSPFEditorTemplId);
    }

    @Override
    protected String getSQL_getPSDERs(String strPSDataEntityId) {
        return super.getSQL_getPSDERs(strPSDataEntityId);
    }

    @Override
    protected String getSQL_getPSDERsByMinorDEId(String strPSDataEntityId) {
        return super.getSQL_getPSDERsByMinorDEId(strPSDataEntityId);
    }

    @Override
    protected String getSQL_getPSDER(String strPSDERId) {
        return super.getSQL_getPSDER(strPSDERId);
    }

    @Override
    protected String getSQL_getPSSysDBValueFunc(String strPSSystemId, String strPSSysDBValueFuncId) {
        return super.getSQL_getPSSysDBValueFunc(strPSSystemId, strPSSysDBValueFuncId);
    }

    @Override
    protected String getSQL_getPSDEJoinType(String strPSDEJoinTypeId) {
        return super.getSQL_getPSDEJoinType(strPSDEJoinTypeId);
    }

    @Override
    protected String getSQL_getPSDEDSGroupParamsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEDSGroupParamsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSSF(String strPSSFId) {
        return super.getSQL_getPSSF(strPSSFId);
    }

    @Override
    protected String getSQL_getPSSFStyle(String strPSSFStyleId) {
        return super.getSQL_getPSSFStyle(strPSSFStyleId);
    }

    @Override
    protected String getSQL_getPSSFStyleVer(String strPSSFStyleVerId) {
        return super.getSQL_getPSSFStyleVer(strPSSFStyleVerId);
    }

    @Override
    protected String getSQL_getPSSFACHandler(String strPSSFACHandlerId) {
        return super.getSQL_getPSSFACHandler(strPSSFACHandlerId);
    }

    @Override
    protected String getSQL_getPSSFCodeFolders(String strPSSFStyleId) {
        return super.getSQL_getPSSFCodeFolders(strPSSFStyleId);
    }

    @Override
    protected String getSQL_getPSSFCodeTempl(String strPSSFCodeTemplId) {
        return super.getSQL_getPSSFCodeTempl(strPSSFCodeTemplId);
    }

    @Override
    protected String getSQL_getPSSFCodeTempls(String strPSSFCodeTypeId) {
        return super.getSQL_getPSSFCodeTempls(strPSSFCodeTypeId);
    }

    @Override
    protected String getSQL_getPSSFCodeTypes(String strPSSFCodeFolderId) {
        return super.getSQL_getPSSFCodeTypes(strPSSFCodeFolderId);
    }

    @Override
    protected String getSQL_getPSSysAjaxControlHandlers(String strPSSystemId) {
        return super.getSQL_getPSSysAjaxControlHandlers(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEViewViews(String strPSDEViewId) {
        return super.getSQL_getPSDEViewViews(strPSDEViewId);
    }

    @Override
    protected String getSQL_getPSDEViewViewsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEViewViewsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEViewCtrls(String strPSDEViewId) {
        return super.getSQL_getPSDEViewCtrls(strPSDEViewId);
    }

    @Override
    protected String getSQL_getPSDEViewCtrlsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEViewCtrlsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDELogic(String strPSDELogicId) {
        return super.getSQL_getPSDELogic(strPSDELogicId);
    }

    @Override
    protected String getSQL_getPSPFUIActionTempl(String strPSPFUIActionTemplId) {
        return super.getSQL_getPSPFUIActionTempl(strPSPFUIActionTemplId);
    }

    @Override
    protected String getSQL_getPSPFViewLogicTempl(String strPSPFViewLogicTemplId) {
        return super.getSQL_getPSPFViewLogicTempl(strPSPFViewLogicTemplId);
    }

    @Override
    protected String getSQL_getPSDEFValueRulesByDataEntity(String strPSDEId) {
        return super.getSQL_getPSDEFValueRulesByDataEntity(strPSDEId);
    }

    @Override
    protected String getSQL_getPSDEFValueRulesBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEFValueRulesBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEFValueRuleConds(String strPSDEFValueRuleId) {
        return super.getSQL_getPSDEFValueRuleConds(strPSDEFValueRuleId);
    }

    @Override
    protected String getSQL_getPSDEFValueRuleCondsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEFValueRuleCondsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEFValueRuleType(String strPSDEFValueRuleTypeId) {
        return super.getSQL_getPSDEFValueRuleType(strPSDEFValueRuleTypeId);
    }

    @Override
    protected String getSQL_getPSDEFValueRuleTypeDetail(String strPSDEFValueRuleTypeDetailId) {
        return super.getSQL_getPSDEFValueRuleTypeDetail(strPSDEFValueRuleTypeDetailId);
    }

    @Override
    protected String getSQL_getPSDRItemType(String strPSDRItemTypeId) {
        return super.getSQL_getPSDRItemType(strPSDRItemTypeId);
    }

    @Override
    protected String getSQL_getPSDEGrid(String strPSDEGridId) {
        return super.getSQL_getPSDEGrid(strPSDEGridId);
    }

    @Override
    protected String getSQL_getPSDEToolbar(String strPSDEToolbarId) {
        return super.getSQL_getPSDEToolbar(strPSDEToolbarId);
    }

    @Override
    protected String getSQL_getPSDEForm(String strPSDEFormId) {
        return super.getSQL_getPSDEForm(strPSDEFormId);
    }

    @Override
    protected String getSQL_getPSFDLogicType(String strPSFDLogicTypeId) {
        return super.getSQL_getPSFDLogicType(strPSFDLogicTypeId);
    }

    @Override
    protected String getSQL_getPSDEFDLogics(String strPSDEFormId) {
        return super.getSQL_getPSDEFDLogics(strPSDEFormId);
    }

    @Override
    protected String getSQL_getPSDEFDLogicsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEFDLogicsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSPFAppTempl(String strPSPFAppTemplId) {
        return super.getSQL_getPSPFAppTempl(strPSPFAppTemplId);
    }

    @Override
    protected String getSQL_getPSDEUIActionGroups(String strPSDataEntityId) {
        return super.getSQL_getPSDEUIActionGroups(strPSDataEntityId);
    }

    @Override
    protected String getSQL_getPSDEUIActionGroupsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEUIActionGroupsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEUIActionGroupDetails(String strPSDEUIActionGroupId) {
        return super.getSQL_getPSDEUIActionGroupDetails(strPSDEUIActionGroupId);
    }

    @Override
    protected String getSQL_getPSDEUIActionGroupDetailsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEUIActionGroupDetailsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDELogicNodeType(String strPSDELogicNodeTypeId) {
        return super.getSQL_getPSDELogicNodeType(strPSDELogicNodeTypeId);
    }

    @Override
    protected String getSQL_getPSDELogicLinkType(String strPSDELogicLinkTypeId) {
        return super.getSQL_getPSDELogicLinkType(strPSDELogicLinkTypeId);
    }

    @Override
    protected String getSQL_getPSDELogicLinkCondType(String strPSDELogicLinkCondTypeId) {
        return super.getSQL_getPSDELogicLinkCondType(strPSDELogicLinkCondTypeId);
    }

    @Override
    protected String getSQL_getPSDELogicNodes(String strPSDELogicId) {
        return super.getSQL_getPSDELogicNodes(strPSDELogicId);
    }

    @Override
    protected String getSQL_getPSDELogicNodesBySystem(String strPSSystemId) {
        return super.getSQL_getPSDELogicNodesBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDELogicLinks(String strPSDELogicId) {
        return super.getSQL_getPSDELogicLinks(strPSDELogicId);
    }

    @Override
    protected String getSQL_getPSDELogicLinksBySystem(String strPSSystemId) {
        return super.getSQL_getPSDELogicLinksBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDELogicLinkConds(String strPSDELogicId) {
        return super.getSQL_getPSDELogicLinkConds(strPSDELogicId);
    }

    @Override
    protected String getSQL_getPSDELogicLinkCondsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDELogicLinkCondsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDELogics(String strPSDataEntityId) {
        return super.getSQL_getPSDELogics(strPSDataEntityId);
    }

    @Override
    protected String getSQL_getPSDELogicsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDELogicsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDELogicNodeParams(String strPSDELogicId) {
        return super.getSQL_getPSDELogicNodeParams(strPSDELogicId);
    }

    @Override
    protected String getSQL_getPSDELogicNodeParamsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDELogicNodeParamsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDELogicParams(String strPSDELogicId) {
        return super.getSQL_getPSDELogicParams(strPSDELogicId);
    }

    @Override
    protected String getSQL_getPSDELogicParamsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDELogicParamsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEPredefinedViews(String strPSDataEntityId) {
        return super.getSQL_getPSDEPredefinedViews(strPSDataEntityId);
    }

    @Override
    protected String getSQL_getPSDEPredefinedViewsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEPredefinedViewsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEViews(String strPSDataEntityId) {
        return super.getSQL_getPSDEViews(strPSDataEntityId);
    }

    @Override
    protected String getSQL_getPSDEViewsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEViewsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEFIUpdates(String strPSDEFormId) {
        return super.getSQL_getPSDEFIUpdates(strPSDEFormId);
    }

    @Override
    protected String getSQL_getPSDEFIUpdatesBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEFIUpdatesBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEFIUDetails(String strPSDEFormId) {
        return super.getSQL_getPSDEFIUDetails(strPSDEFormId);
    }

    @Override
    protected String getSQL_getPSDEFIUDetailsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEFIUDetailsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEFormRFs(String strPSDEFormId) {
        return super.getSQL_getPSDEFormRFs(strPSDEFormId);
    }

    @Override
    protected String getSQL_getPSDEFormRFsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEFormRFsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEFormItemVRs(String strPSDEFormId) {
        return super.getSQL_getPSDEFormItemVRs(strPSDEFormId);
    }

    @Override
    protected String getSQL_getPSDEFormItemVRsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEFormItemVRsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEMap(String strPSDEMapId) {
        return super.getSQL_getPSDEMap(strPSDEMapId);
    }

    @Override
    protected String getSQL_getPSDEMaps(String strPSDEId) {
        return super.getSQL_getPSDEMaps(strPSDEId);
    }

    @Override
    protected String getSQL_getPSDEMapsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEMapsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEMapDetails(String strPSDEMapId) {
        return super.getSQL_getPSDEMapDetails(strPSDEMapId);
    }

    @Override
    protected String getSQL_getPSDEMapDetailsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEMapDetailsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSProcRoles(String strPSWFVersionId) {
        return super.getSQL_getPSProcRoles(strPSWFVersionId);
    }

    @Override
    protected String getSQL_getPSProcRolesBySystem(String strPSSystemId) {
        return super.getSQL_getPSProcRolesBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEViewBase(String strPSDEViewBaseId) {
        return super.getSQL_getPSDEViewBase(strPSDEViewBaseId);
    }

    @Override
    protected String getSQL_getPSSysDevBTType(String strPSSysDevBTTypeId) {
        return super.getSQL_getPSSysDevBTType(strPSSysDevBTTypeId);
    }

    @Override
    protected String getSQL_getPSSysDevBKTasks(String strPSSysDevBKTaskId) {
        return super.getSQL_getPSSysDevBKTasks(strPSSysDevBKTaskId);
    }

    @Override
    protected String getSQL_getPSSVNInstRepo(String strPSSVNInstRepoId) {
        return super.getSQL_getPSSVNInstRepo(strPSSVNInstRepoId);
    }

    @Override
    protected String getSQL_getPSSVNInstRepoByDevCenterSVNId(String strPSDevCenterSVNId) {
        return super.getSQL_getPSSVNInstRepoByDevCenterSVNId(strPSDevCenterSVNId);
    }

    @Override
    protected String getSQL_getPSSubDE(String strPSSubDEId) {
        return super.getSQL_getPSSubDE(strPSSubDEId);
    }

    @Override
    protected String getSQL_getPSSubDEView(String strPSSubDEViewId) {
        return super.getSQL_getPSSubDEView(strPSSubDEViewId);
    }

    @Override
    protected String getSQL_getPSSubApp(String strPSSubAppId) {
        return super.getSQL_getPSSubApp(strPSSubAppId);
    }

    @Override
    protected String getSQL_getPSSubSys(String strPSSubSysId) {
        return super.getSQL_getPSSubSys(strPSSubSysId);
    }

    @Override
    protected String getSQL_getPSSubSysSF(String strPSSubSysSFId) {
        return super.getSQL_getPSSubSysSF(strPSSubSysSFId);
    }

    @Override
    protected String getSQL_getPSSubAppView(String strPSSubAppViewId) {
        return super.getSQL_getPSSubAppView(strPSSubAppViewId);
    }

    @Override
    protected String getSQL_getPSSysCss(String strPSSysCssId) {
        return super.getSQL_getPSSysCss(strPSSysCssId);
    }

    @Override
    protected String getSQL_getPSSubViewType(String strPSSubViewTypeId) {
        return super.getSQL_getPSSubViewType(strPSSubViewTypeId);
    }

    @Override
    protected String getSQL_getAllPSSysBackServices(String strPSSystemId) {
        return super.getSQL_getAllPSSysBackServices(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSSysBackService(String strPSSysBackServiceId) {
        return super.getSQL_getPSSysBackService(strPSSysBackServiceId);
    }

    @Override
    protected String getSQL_getPSPortletType(String strPSPortletTypeId) {
        return super.getSQL_getPSPortletType(strPSPortletTypeId);
    }

    @Override
    protected String getSQL_getPSDEList(String strPSDEListId) {
        return super.getSQL_getPSDEList(strPSDEListId);
    }

    @Override
    protected String getSQL_getPSDEListItems(String strPSDEListId) {
        return super.getSQL_getPSDEListItems(strPSDEListId);
    }

    @Override
    protected String getSQL_getPSDEListsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEListsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEListItemsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEListItemsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEOPPriv(String strPSDEOPPrivId) {
        return super.getSQL_getPSDEOPPriv(strPSDEOPPrivId);
    }

    @Override
    protected String getSQL_getPSDEOPPrivs(String strPSDataEntityId) {
        return super.getSQL_getPSDEOPPrivs(strPSDataEntityId);
    }

    @Override
    protected String getSQL_getPSDEOPPrivsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEOPPrivsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEMainStates(String strPSDEId) {
        return super.getSQL_getPSDEMainStates(strPSDEId);
    }

    @Override
    protected String getSQL_getPSDEMainStatesBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEMainStatesBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEMainStateActions(String strPSDEMainStateId) {
        return super.getSQL_getPSDEMainStateActions(strPSDEMainStateId);
    }

    @Override
    protected String getSQL_getPSDEMainStateActionsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEMainStateActionsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEMainStateOPPrivs(String strPSDEMainStateId) {
        return super.getSQL_getPSDEMainStateOPPrivs(strPSDEMainStateId);
    }

    @Override
    protected String getSQL_getPSDEMainStateOPPrivsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEMainStateOPPrivsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSPFPluginType(String strPSPFPluginTypeId) {
        return super.getSQL_getPSPFPluginType(strPSPFPluginTypeId);
    }

    @Override
    protected String getSQL_getPSDETreeView(String strPSDETreeViewId) {
        return super.getSQL_getPSDETreeView(strPSDETreeViewId);
    }

    @Override
    protected String getSQL_getPSDETreeNodeType(String strPSDETreeNodeTypeId) {
        return super.getSQL_getPSDETreeNodeType(strPSDETreeNodeTypeId);
    }

    @Override
    protected String getSQL_getPSDETreeNodesBySystem(String strPSSystemId) {
        return super.getSQL_getPSDETreeNodesBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDETreeNodes(String strPSDETreeId) {
        return super.getSQL_getPSDETreeNodes(strPSDETreeId);
    }

    @Override
    protected String getSQL_getPSDETreeColumnsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDETreeColumnsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDETreeColumns(String strPSDETreeId) {
        return super.getSQL_getPSDETreeColumns(strPSDETreeId);
    }

    @Override
    protected String getSQL_getPSDETreeNodeColumnsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDETreeNodeColumnsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDETreeNodeColumns(String strPSDETreeId) {
        return super.getSQL_getPSDETreeNodeColumns(strPSDETreeId);
    }

    @Override
    protected String getSQL_getPSDETreeViewsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDETreeViewsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDETreeNodeRSesBySystem(String strPSSystemId) {
        return super.getSQL_getPSDETreeNodeRSesBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDETreeNodeRSes(String strPSDETreeId) {
        return super.getSQL_getPSDETreeNodeRSes(strPSDETreeId);
    }

    @Override
    protected String getSQL_getPSDETreeNodeRVsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDETreeNodeRVsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDETreeNodeRVs(String strPSDETreeId) {
        return super.getSQL_getPSDETreeNodeRVs(strPSDETreeId);
    }

    @Override
    protected String getSQL_getPSSysCounter(String strPSSysCounterId) {
        return super.getSQL_getPSSysCounter(strPSSysCounterId);
    }

    @Override
    protected String getSQL_getPSPFStyleCodes(String strPSPFStyleId) {
        return super.getSQL_getPSPFStyleCodes(strPSPFStyleId);
    }

    @Override
    protected String getSQL_getPSSysDictCat(String strPSSysDictCatId) {
        return super.getSQL_getPSSysDictCat(strPSSysDictCatId);
    }

    @Override
    protected String getSQL_getPSDEReports(String strPSDEId) {
        return super.getSQL_getPSDEReports(strPSDEId);
    }

    @Override
    protected String getSQL_getPSDEReportsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEReportsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEReportItems(String strPSDEReportId) {
        return super.getSQL_getPSDEReportItems(strPSDEReportId);
    }

    @Override
    protected String getSQL_getPSDEReportItemsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEReportItemsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEPrints(String strPSDEId) {
        return super.getSQL_getPSDEPrints(strPSDEId);
    }

    @Override
    protected String getSQL_getPSDEPrintsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEPrintsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDepSlnPrd(String strPSDepSlnPrdId) {
        return super.getSQL_getPSDepSlnPrd(strPSDepSlnPrdId);
    }

    @Override
    protected String getSQL_getPSPF(String strPSPFId) {
        return super.getSQL_getPSPF(strPSPFId);
    }

    @Override
    protected String getSQL_getPSDEViewLogics(String strPSDEViewId) {
        return super.getSQL_getPSDEViewLogics(strPSDEViewId);
    }

    @Override
    protected String getSQL_getPSDEViewLogicsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEViewLogicsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSSysDEUIActionGroups(String strPSSystemId) {
        return super.getSQL_getPSSysDEUIActionGroups(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSPFCtrlTemplsByPFStyle(String strPSPFStyleId) {
        return super.getSQL_getPSPFCtrlTemplsByPFStyle(strPSPFStyleId);
    }

    @Override
    protected String getSQL_getPSPFViewLogicTemplsByPFStyle(String strPSPFStyleId) {
        return super.getSQL_getPSPFViewLogicTemplsByPFStyle(strPSPFStyleId);
    }

    @Override
    protected String getSQL_getPSPFUIActionTemplsByPFStyle(String strPSPFStyleId) {
        return super.getSQL_getPSPFUIActionTemplsByPFStyle(strPSPFStyleId);
    }

    @Override
    protected String getSQL_getPSPFAppTemplsByPFStyle(String strPSPFStyleId) {
        return super.getSQL_getPSPFAppTemplsByPFStyle(strPSPFStyleId);
    }

    @Override
    protected String getSQL_getPSPFEditorTemplsByPFStyle(String strPSPFStyleId) {
        return super.getSQL_getPSPFEditorTemplsByPFStyle(strPSPFStyleId);
    }

    @Override
    protected String getSQL_getPSPFEditorTemplsByPF(String strPSPFId) {
        return super.getSQL_getPSPFEditorTemplsByPF(strPSPFId);
    }

    @Override
    protected String getSQL_getPSSubSysVer(String strPSSubSysVerId) {
        return super.getSQL_getPSSubSysVer(strPSSubSysVerId);
    }

    @Override
    protected String getSQL_getAllPSSysActors(String strPSSystemId) {
        return super.getSQL_getAllPSSysActors(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSSysActor(String strPSSysActorId) {
        return super.getSQL_getPSSysActor(strPSSysActorId);
    }

    @Override
    protected String getSQL_getPSSFVerCodeItem(String strPSSFVerCodeItemId) {
        return super.getSQL_getPSSFVerCodeItem(strPSSFVerCodeItemId);
    }

    @Override
    protected String getSQL_getPSSFVerCodes(String strPSSFStyleVerId) {
        return super.getSQL_getPSSFVerCodes(strPSSFStyleVerId);
    }

    @Override
    protected String getSQL_getPSSFVerCodeItems(String strPSSFVerCodeId) {
        return super.getSQL_getPSSFVerCodeItems(strPSSFVerCodeId);
    }

    @Override
    protected String getSQL_getPSDERDEFMaps(String strPSDERId) {
        return super.getSQL_getPSDERDEFMaps(strPSDERId);
    }

    @Override
    protected String getSQL_getPSDERDEFMapsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDERDEFMapsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSSysDynaModel(String strPSSysDynaModelId) {
        return super.getSQL_getPSSysDynaModel(strPSSysDynaModelId);
    }

    @Override
    protected String getSQL_getPSPFStylePrjs(String strPSPFStyleId) {
        return super.getSQL_getPSPFStylePrjs(strPSPFStyleId);
    }

    @Override
    protected String getSQL_getPSSFStylePrjs(String strPSSFStyleId) {
        return super.getSQL_getPSSFStylePrjs(strPSSFStyleId);
    }

    @Override
    protected String getSQL_getPSSFPkg(String strPSSFPkgId) {
        return super.getSQL_getPSSFPkg(strPSSFPkgId);
    }

    @Override
    protected String getSQL_getPSSFPkgVer(String strPSSFPkgVerId) {
        return super.getSQL_getPSSFPkgVer(strPSSFPkgVerId);
    }

    @Override
    protected String getSQL_getPSSFStylePkgs(String strPSSFStyleId) {
        return super.getSQL_getPSSFStylePkgs(strPSSFStyleId);
    }

    @Override
    protected String getSQL_getPSDEGEIUpdates(String strPSDEGridId) {
        return super.getSQL_getPSDEGEIUpdates(strPSDEGridId);
    }

    @Override
    protected String getSQL_getPSDEGEIUpdatesBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEGEIUpdatesBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEGEIUDetails(String strPSDEGridId) {
        return super.getSQL_getPSDEGEIUDetails(strPSDEGridId);
    }

    @Override
    protected String getSQL_getPSDEGEIUDetailsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEGEIUDetailsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEWizard(String strPSDEWizardId) {
        return super.getSQL_getPSDEWizard(strPSDEWizardId);
    }

    @Override
    protected String getSQL_getPSDEWizards(String strPSDEId) {
        return super.getSQL_getPSDEWizards(strPSDEId);
    }

    @Override
    protected String getSQL_getPSDEWizardsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEWizardsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEWizardStep(String strPSDEWizardStepId) {
        return super.getSQL_getPSDEWizardStep(strPSDEWizardStepId);
    }

    @Override
    protected String getSQL_getPSDEWizardSteps(String strPSDEWizardId) {
        return super.getSQL_getPSDEWizardSteps(strPSDEWizardId);
    }

    @Override
    protected String getSQL_getPSDEWizardStepsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEWizardStepsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEWizardForms(String strPSDEWizardId) {
        return super.getSQL_getPSDEWizardForms(strPSDEWizardId);
    }

    @Override
    protected String getSQL_getPSDEWizardFormsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEWizardFormsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDevUser(String strPSDevUserId) {
        return super.getSQL_getPSDevUser(strPSDevUserId);
    }

    @Override
    protected String getSQL_getPSSysBDScheme(String strPSSysBDSchemeId) {
        return super.getSQL_getPSSysBDScheme(strPSSysBDSchemeId);
    }

    @Override
    protected String getSQL_getPSSysBDModulesBySystem(String strPSSystemId) {
        return super.getSQL_getPSSysBDModulesBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSSysBDModules(String strPSSysBDSchemeId) {
        return super.getSQL_getPSSysBDModules(strPSSysBDSchemeId);
    }

    @Override
    protected String getSQL_getPSSysBDPartsBySystem(String strPSSystemId) {
        return super.getSQL_getPSSysBDPartsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSSysBDParts(String strPSSysBDSchemeId) {
        return super.getSQL_getPSSysBDParts(strPSSysBDSchemeId);
    }

    @Override
    protected String getSQL_getPSSysBDTablesBySystem(String strPSSystemId) {
        return super.getSQL_getPSSysBDTablesBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSSysBDTables(String strPSSysBDSchemeId) {
        return super.getSQL_getPSSysBDTables(strPSSysBDSchemeId);
    }

    @Override
    protected String getSQL_getPSSysBDTableRSesBySystem(String strPSSystemId) {
        return super.getSQL_getPSSysBDTableRSesBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSSysBDTableRSes(String strPSSysBDSchemeId) {
        return super.getSQL_getPSSysBDTableRSes(strPSSysBDSchemeId);
    }

    @Override
    protected String getSQL_getPSSysBDColumns(String strPSSysBDTableId) {
        return super.getSQL_getPSSysBDColumns(strPSSysBDTableId);
    }

    @Override
    protected String getSQL_getPSSysBDColumnsBySystem(String strPSSystemId) {
        return super.getSQL_getPSSysBDColumnsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSSysBDColSets(String strPSSysBDTableId) {
        return super.getSQL_getPSSysBDColSets(strPSSysBDTableId);
    }

    @Override
    protected String getSQL_getPSSysBDColSetsBySystem(String strPSSystemId) {
        return super.getSQL_getPSSysBDColSetsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSSysBDTableDEs(String strPSSysBDTableId) {
        return super.getSQL_getPSSysBDTableDEs(strPSSysBDTableId);
    }

    @Override
    protected String getSQL_getPSSysBDTableDEsBySystem(String strPSSystemId) {
        return super.getSQL_getPSSysBDTableDEsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSSysBDTableDERs(String strPSSysBDTableId) {
        return super.getSQL_getPSSysBDTableDERs(strPSSysBDTableId);
    }

    @Override
    protected String getSQL_getPSSysBDTableDERsBySystem(String strPSSystemId) {
        return super.getSQL_getPSSysBDTableDERsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSModelPlugin(String strPSModelPluginId) {
        return super.getSQL_getPSModelPlugin(strPSModelPluginId);
    }

    @Override
    protected String getSQL_getPSDevCenterBTType(String strPSDevCenterBTTypeId) {
        return super.getSQL_getPSDevCenterBTType(strPSDevCenterBTTypeId);
    }

    @Override
    protected String getSQL_getPSDEFInputTipsByDataEntity(String strPSDEId) {
        return super.getSQL_getPSDEFInputTipsByDataEntity(strPSDEId);
    }

    @Override
    protected String getSQL_getPSDEFInputTipsBySystem2(String strPSSystemId) {
        return super.getSQL_getPSDEFInputTipsBySystem2(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEFInputTipsBySystem3(String strPSSystemId) {
        return super.getSQL_getPSDEFInputTipsBySystem3(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSModel(String strPSModelId) {
        return super.getSQL_getPSModel(strPSModelId);
    }

    @Override
    protected String getSQL_getPSModelPlugins(String strPSModelId) {
        return super.getSQL_getPSModelPlugins(strPSModelId);
    }

    @Override
    protected String getSQL_getPSDevCenterBKTasks(String strPSDevCenterBKTaskId) {
        return super.getSQL_getPSDevCenterBKTasks(strPSDevCenterBKTaskId);
    }

    @Override
    protected String getSQL_getPSLanguageRes(String strPSLanguageResId) {
        return super.getSQL_getPSLanguageRes(strPSLanguageResId);
    }

    @Override
    protected String getSQL_getPSLanguageItem(String strPSLanguageItemId) {
        return super.getSQL_getPSLanguageItem(strPSLanguageItemId);
    }

    @Override
    protected String getSQL_getPSHelpArticleType(String strPSHelpArticleTypeId) {
        return super.getSQL_getPSHelpArticleType(strPSHelpArticleTypeId);
    }

    @Override
    protected String getSQL_getPSHelpSectionType(String strPSHelpSectionTypeId) {
        return super.getSQL_getPSHelpSectionType(strPSHelpSectionTypeId);
    }

    @Override
    protected String getSQL_getPSHelpArticleTempls() {
        return super.getSQL_getPSHelpArticleTempls();
    }

    @Override
    protected String getSQL_getPSHelpSectionTempls() {
        return super.getSQL_getPSHelpSectionTempls();
    }

    @Override
    protected String getSQL_getPSHelpPrjTempls() {
        return super.getSQL_getPSHelpPrjTempls();
    }

    @Override
    protected String getSQL_getPSHelpPrjType(String strPSHelpPrjTemplId) {
        return super.getSQL_getPSHelpPrjType(strPSHelpPrjTemplId);
    }

    @Override
    protected String getSQL_getPSHelpPrjTempl(String strPSHelpPrjTemplId) {
        return super.getSQL_getPSHelpPrjTempl(strPSHelpPrjTemplId);
    }

    @Override
    protected String getSQL_getPSHelpArticleTempl(String strPSHelpArticleTemplId) {
        return super.getSQL_getPSHelpArticleTempl(strPSHelpArticleTemplId);
    }

    @Override
    protected String getSQL_getPSHelpSectionTempl(String strPSHelpSectionTemplId) {
        return super.getSQL_getPSHelpSectionTempl(strPSHelpSectionTemplId);
    }

    @Override
    protected String getSQL_getPSPFPkg(String strPSPFPkgId) {
        return super.getSQL_getPSPFPkg(strPSPFPkgId);
    }

    @Override
    protected String getSQL_getPSPFPkgVer(String strPSPFPkgVerId) {
        return super.getSQL_getPSPFPkgVer(strPSPFPkgVerId);
    }

    @Override
    protected String getSQL_getPSPFStylePkgs(String strPSPFStyleId) {
        return super.getSQL_getPSPFStylePkgs(strPSPFStyleId);
    }

    @Override
    protected String getSQL_getPSPFCDN(String strPSPFCDNId) {
        return super.getSQL_getPSPFCDN(strPSPFCDNId);
    }

    @Override
    protected String getSQL_getPSPFPkgVerCDN(String strPSPFPkgVerCDNId) {
        return super.getSQL_getPSPFPkgVerCDN(strPSPFPkgVerCDNId);
    }

    @Override
    protected String getSQL_getPSDepSysType(String strPSDepSysTypeId) {
        return super.getSQL_getPSDepSysType(strPSDepSysTypeId);
    }

    @Override
    protected String getSQL_getPSDepSlnType(String strPSDepSlnTypeId) {
        return super.getSQL_getPSDepSlnType(strPSDepSlnTypeId);
    }

    @Override
    protected String getSQL_getPSDevCenterAS(String strPSDevCenterASId) {
        return super.getSQL_getPSDevCenterAS(strPSDevCenterASId);
    }

    @Override
    protected String getSQL_getPSMQType(String strPSMQTypeId) {
        return super.getSQL_getPSMQType(strPSMQTypeId);
    }

    @Override
    protected String getSQL_getPSMQInst(String strPSMQInstId) {
        return super.getSQL_getPSMQInst(strPSMQInstId);
    }

    @Override
    protected String getSQL_getPSDepSys(String strPSDepSysId) {
        return super.getSQL_getPSDepSys(strPSDepSysId);
    }

    @Override
    protected String getSQL_getPSDepSysVer(String strPSDepSysVerId) {
        return super.getSQL_getPSDepSysVer(strPSDepSysVerId);
    }

    @Override
    protected String getSQL_getPSDepSaaSSysVer(String strPSDepSaaSSysVerId) {
        return super.getSQL_getPSDepSaaSSysVer(strPSDepSaaSSysVerId);
    }

    @Override
    protected String getSQL_getPSDepToolType(String strPSDepToolTypeId) {
        return super.getSQL_getPSDepToolType(strPSDepToolTypeId);
    }

    @Override
    protected String getSQL_getPSDevCenterSVN(String strPSDevCenterSVNId) {
        return super.getSQL_getPSDevCenterSVN(strPSDevCenterSVNId);
    }

    @Override
    protected String getSQL_getPSRobotType(String strPSRobotTypeId) {
        return super.getSQL_getPSRobotType(strPSRobotTypeId);
    }

    @Override
    protected String getSQL_getPSRobotWorkType(String strPSRobotWorkTypeId) {
        return super.getSQL_getPSRobotWorkType(strPSRobotWorkTypeId);
    }

    @Override
    protected String getSQL_getPSRobot(String strPSRobotId) {
        return super.getSQL_getPSRobot(strPSRobotId);
    }

    @Override
    protected String getSQL_getPSGitUser(String strPSGitUserId) {
        return super.getSQL_getPSGitUser(strPSGitUserId);
    }

    @Override
    protected String getSQL_getPSDEFInputTipSet(String strPSDEFInputTipSetId) {
        return super.getSQL_getPSDEFInputTipSet(strPSDEFInputTipSetId);
    }

    @Override
    protected String getSQL_getPSDevServerType(String strPSDevServerTypeId) {
        return super.getSQL_getPSDevServerType(strPSDevServerTypeId);
    }

    @Override
    protected String getSQL_getPSDevServer(String strPSDevServerId) {
        return super.getSQL_getPSDevServer(strPSDevServerId);
    }

    @Override
    protected String getSQL_getPSSysDEFType(String strPSSysDEFTypeId) {
        return super.getSQL_getPSSysDEFType(strPSSysDEFTypeId);
    }

    @Override
    protected String getSQL_getPSMobAppStartPage(String strPSMobAppStartPageId) {
        return super.getSQL_getPSMobAppStartPage(strPSMobAppStartPageId);
    }

    @Override
    protected String getSQL_getPSMobAppPack(String strPSMobAppPackId) {
        return super.getSQL_getPSMobAppPack(strPSMobAppPackId);
    }

    @Override
    protected String getSQL_getPSMobAppPackTDsBySysApp(String strPSSysAppId) {
        return super.getSQL_getPSMobAppPackTDsBySysApp(strPSSysAppId);
    }

    @Override
    protected String getSQL_getPSMobAppPackTDs(String strPSMobAppPackId) {
        return super.getSQL_getPSMobAppPackTDs(strPSMobAppPackId);
    }

    @Override
    protected String getSQL_getPSMobAppPackCert(String strPSMobAppPackCertId) {
        return super.getSQL_getPSMobAppPackCert(strPSMobAppPackCertId);
    }

    @Override
    protected String getSQL_getPSMobAppPackServer(String strPSMobAppPackServerId) {
        return super.getSQL_getPSMobAppPackServer(strPSMobAppPackServerId);
    }

    @Override
    protected String getSQL_getPSDEUniStates(String strPSDataEntityId) {
        return super.getSQL_getPSDEUniStates(strPSDataEntityId);
    }

    @Override
    protected String getSQL_getPSDEUniStatesBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEUniStatesBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEServiceAPI(String strPSDEServiceAPIId) {
        return super.getSQL_getPSDEServiceAPI(strPSDEServiceAPIId);
    }

    @Override
    protected String getSQL_getPSDEServiceAPIs(String strPSDEId) {
        return super.getSQL_getPSDEServiceAPIs(strPSDEId);
    }

    @Override
    protected String getSQL_getPSDEServiceAPIsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEServiceAPIsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDESADetail(String strPSDESADetailId) {
        return super.getSQL_getPSDESADetail(strPSDESADetailId);
    }

    @Override
    protected String getSQL_getPSDESADetails(String strPSDEServiceAPIId) {
        return super.getSQL_getPSDESADetails(strPSDEServiceAPIId);
    }

    @Override
    protected String getSQL_getPSDESADetailsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDESADetailsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEServiceAPIsBySSA(String strPSSysServiceAPIId) {
        return super.getSQL_getPSDEServiceAPIsBySSA(strPSSysServiceAPIId);
    }

    @Override
    protected String getSQL_getPSDEDTSQueues(String strPSDataEntityId) {
        return super.getSQL_getPSDEDTSQueues(strPSDataEntityId);
    }

    @Override
    protected String getSQL_getPSDEDTSQueuesBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEDTSQueuesBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSSysDTSQueue(String strPSSysDTSQueueId) {
        return super.getSQL_getPSSysDTSQueue(strPSSysDTSQueueId);
    }

    @Override
    protected String getSQL_getPSDeployServer(String strPSDeployServerId) {
        return super.getSQL_getPSDeployServer(strPSDeployServerId);
    }

    @Override
    protected String getSQL_getPSSubSysServiceAPI(String strPSSubSysServiceAPIId) {
        return super.getSQL_getPSSubSysServiceAPI(strPSSubSysServiceAPIId);
    }

    @Override
    protected String getSQL_getPSSubSysSADetails(String strPSSubSysServiceAPIId) {
        return super.getSQL_getPSSubSysSADetails(strPSSubSysServiceAPIId);
    }

    @Override
    protected String getSQL_getPSDevSlnSysRes(String strPSDevSlnSysResId) {
        return super.getSQL_getPSDevSlnSysRes(strPSDevSlnSysResId);
    }

    @Override
    protected String getSQL_getPSDEUserRoles(String strPSDEId) {
        return super.getSQL_getPSDEUserRoles(strPSDEId);
    }

    @Override
    protected String getSQL_getPSDEUserRolesBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEUserRolesBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDEOPPrivRoles(String strPSDEId) {
        return super.getSQL_getPSDEOPPrivRoles(strPSDEId);
    }

    @Override
    protected String getSQL_getPSDEOPPrivRolesBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEOPPrivRolesBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getAllPSSysUserRoles(String strPSSystemId) {
        return super.getSQL_getAllPSSysUserRoles(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSSysDashboard(String strPSSysDashboardId) {
        return super.getSQL_getPSSysDashboard(strPSSysDashboardId);
    }

    @Override
    protected String getSQL_getPSSysDashboardParts(String strPSSysDashboardId) {
        return super.getSQL_getPSSysDashboardParts(strPSSysDashboardId);
    }

    @Override
    protected String getSQL_getPSSFPluginTempl(String strPSSFPluginTemplId) {
        return super.getSQL_getPSSFPluginTempl(strPSSFPluginTemplId);
    }

    @Override
    protected String getSQL_getPSPFPluginTempl(String strPSPFPluginTemplId) {
        return super.getSQL_getPSPFPluginTempl(strPSPFPluginTemplId);
    }

    @Override
    protected String getSQL_getPSDEUtils(String strPSDEId) {
        return super.getSQL_getPSDEUtils(strPSDEId);
    }

    @Override
    protected String getSQL_getPSDEUtilsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDEUtilsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDeployCenter(String strPSDeployCenterId) {
        return super.getSQL_getPSDeployCenter(strPSDeployCenterId);
    }

    @Override
    protected String getSQL_getPSMSPlatform(String strPSMSPlatformId) {
        return super.getSQL_getPSMSPlatform(strPSMSPlatformId);
    }

    @Override
    protected String getSQL_getPSMSPlatformFuncs(String strPSMSPlatformId) {
        return super.getSQL_getPSMSPlatformFuncs(strPSMSPlatformId);
    }

    @Override
    protected String getSQL_getPSMSPlatformNodes(String strPSMSPlatformId) {
        return super.getSQL_getPSMSPlatformNodes(strPSMSPlatformId);
    }

    @Override
    protected String getSQL_getPSDevSlnMSDepApp(String strPSDevSlnMSDepAppId) {
        return super.getSQL_getPSDevSlnMSDepApp(strPSDevSlnMSDepAppId);
    }

    @Override
    protected String getSQL_getPSDevSlnMSDepAPI(String strPSDevSlnMSDepAPIId) {
        return super.getSQL_getPSDevSlnMSDepAPI(strPSDevSlnMSDepAPIId);
    }

    @Override
    protected String getSQL_getPSDevSlnMSDepAPIs(String strPSDevSlnSysId) {
        return super.getSQL_getPSDevSlnMSDepAPIs(strPSDevSlnSysId);
    }

    @Override
    protected String getSQL_getPSDevSlnMSDepApps(String strPSDevSlnSysId) {
        return super.getSQL_getPSDevSlnMSDepApps(strPSDevSlnSysId);
    }

    @Override
    protected String getSQL_getPSSVNServer(String strPSSVNServerId) {
        return super.getSQL_getPSSVNServer(strPSSVNServerId);
    }

    @Override
    protected String getSQL_getPSDevSlnSysWSGit(String strPSDevSlnSysWSGitId) {
        return super.getSQL_getPSDevSlnSysWSGit(strPSDevSlnSysWSGitId);
    }

    @Override
    protected String getSQL_getPSSFStyleParam(String strPSSFStyleParamId) {
        return super.getSQL_getPSSFStyleParam(strPSSFStyleParamId);
    }

    @Override
    protected String getSQL_getPSMavenServer(String strPSMavenServerId) {
        return super.getSQL_getPSMavenServer(strPSMavenServerId);
    }

    @Override
    protected String getSQL_getPSMavenServerType(String strPSMavenServerTypeId) {
        return super.getSQL_getPSMavenServerType(strPSMavenServerTypeId);
    }

    @Override
    protected String getSQL_getPSMavenRepo(String strPSMavenRepoId) {
        return super.getSQL_getPSMavenRepo(strPSMavenRepoId);
    }

    @Override
    protected String getSQL_getPSSysCalendar(String strPSSysCalendarId) {
        return super.getSQL_getPSSysCalendar(strPSSysCalendarId);
    }

    @Override
    protected String getSQL_getPSSysCalendarItemsBySystem(String strPSSystemId) {
        return super.getSQL_getPSSysCalendarItemsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSSysCalendarItems(String strPSSysCalendarId) {
        return super.getSQL_getPSSysCalendarItems(strPSSysCalendarId);
    }

    @Override
    protected String getSQL_getPSSysCalendarItemRVsBySystem(String strPSSystemId) {
        return super.getSQL_getPSSysCalendarItemRVsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSSysCalendarItemRVs(String strPSSysCalendarId) {
        return super.getSQL_getPSSysCalendarItemRVs(strPSSysCalendarId);
    }

    @Override
    protected String getSQL_getPSDESampleDatas(String strPSDataEntityId) {
        return super.getSQL_getPSDESampleDatas(strPSDataEntityId);
    }

    @Override
    protected String getSQL_getPSDESampleDatasBySystem(String strPSSystemId) {
        return super.getSQL_getPSDESampleDatasBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSPanelDetailType(String strPSPanelDetailTypeId) {
        return super.getSQL_getPSPanelDetailType(strPSPanelDetailTypeId);
    }

    @Override
    protected String getSQL_getPSPanelItemLogicsBySystem(String strPSSystemId) {
        return super.getSQL_getPSPanelItemLogicsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSPanelItemLogics(String strPSSysPanelId) {
        return super.getSQL_getPSPanelItemLogics(strPSSysPanelId);
    }

    @Override
    protected String getSQL_getPSPanelItemLogicType(String strPSPanelItemLogicTypeId) {
        return super.getSQL_getPSPanelItemLogicType(strPSPanelItemLogicTypeId);
    }

    @Override
    protected String getSQL_getPSPanelLogicLinkCondType(String strPSPanelLogicLinkCondTypeId) {
        return super.getSQL_getPSPanelLogicLinkCondType(strPSPanelLogicLinkCondTypeId);
    }

    @Override
    protected String getSQL_getPSPanelLogicParamsBySystem(String strPSSystemId) {
        return super.getSQL_getPSPanelLogicParamsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSPanelLogicParams(String strPSPanelLogicId) {
        return super.getSQL_getPSPanelLogicParams(strPSPanelLogicId);
    }

    @Override
    protected String getSQL_getPSPanelLogicNodesBySystem(String strPSSystemId) {
        return super.getSQL_getPSPanelLogicNodesBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSPanelLogicNodes(String strPSPanelLogicId) {
        return super.getSQL_getPSPanelLogicNodes(strPSPanelLogicId);
    }

    @Override
    protected String getSQL_getPSPanelLogicLinksBySystem(String strPSSystemId) {
        return super.getSQL_getPSPanelLogicLinksBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSPanelLogicLinks(String strPSPanelLogicId) {
        return super.getSQL_getPSPanelLogicLinks(strPSPanelLogicId);
    }

    @Override
    protected String getSQL_getPSPanelLogicNodeParamsBySystem(String strPSSystemId) {
        return super.getSQL_getPSPanelLogicNodeParamsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSPanelLogicNodeParams(String strPSPanelLogicId) {
        return super.getSQL_getPSPanelLogicNodeParams(strPSPanelLogicId);
    }

    @Override
    protected String getSQL_getPSPanelLogicLinkCondsBySystem(String strPSSystemId) {
        return super.getSQL_getPSPanelLogicLinkCondsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSPanelLogicLinkConds(String strPSPanelLogicId) {
        return super.getSQL_getPSPanelLogicLinkConds(strPSPanelLogicId);
    }

    @Override
    protected String getSQL_getPSPanelLogicNodeType(String strPSPanelLogicNodeTypeId) {
        return super.getSQL_getPSPanelLogicNodeType(strPSPanelLogicNodeTypeId);
    }

    @Override
    protected String getSQL_getPSPanelLogicLinkType(String strPSPanelLogicLinkTypeId) {
        return super.getSQL_getPSPanelLogicLinkType(strPSPanelLogicLinkTypeId);
    }

    @Override
    protected String getSQL_getPSDynaDETempl(String strPSDynaDETemplId) {
        return super.getSQL_getPSDynaDETempl(strPSDynaDETemplId);
    }

    @Override
    protected String getSQL_getPSDynaDEViewTempl(String strPSDynaDEViewTemplId) {
        return super.getSQL_getPSDynaDEViewTempl(strPSDynaDEViewTemplId);
    }

    @Override
    protected String getSQL_getPSDynaDEViewTemplsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDynaDEViewTemplsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDynaDEViewTempls(String strPSDynaDETemplId) {
        return super.getSQL_getPSDynaDEViewTempls(strPSDynaDETemplId);
    }

    @Override
    protected String getSQL_getPSDynaDEFormTemplsBySystem(String strPSSystemId) {
        return super.getSQL_getPSDynaDEFormTemplsBySystem(strPSSystemId);
    }

    @Override
    protected String getSQL_getPSDynaDEFormTempls(String strPSDynaDETemplId) {
        return super.getSQL_getPSDynaDEFormTempls(strPSDynaDETemplId);
    }

    @Override
    protected String getSQL_getPSDevSlnMSDepFuncItems(String strPSDevSlnMSDepFuncId) {
        return super.getSQL_getPSDevSlnMSDepFuncItems(strPSDevSlnMSDepFuncId);
    }

    @Override
    protected String getSQL_getPSDevSlnMSDepFunc(String strPSDevSlnMSDepFuncId) {
        return super.getSQL_getPSDevSlnMSDepFunc(strPSDevSlnMSDepFuncId);
    }

    @Override
    protected String getSQL_getPSDevSlnMSDepFuncs(String strPSDevSlnSysId) {
        return super.getSQL_getPSDevSlnMSDepFuncs(strPSDevSlnSysId);
    }

    @Override
    protected String getSQL_getPSSFPubObj(String strPSSFPubObjId) {
        return super.getSQL_getPSSFPubObj(strPSSFPubObjId);
    }

    @Override
    protected String getSQL_getPSPFPubObj(String strPSPFPubObjId) {
        return super.getSQL_getPSPFPubObj(strPSPFPubObjId);
    }

    @Override
    protected String getSQL_getPSSysDBValueOP(String strPSSystemId, String strPSSysDBValueOPId) {
        return super.getSQL_getPSSysDBValueOP(strPSSystemId, strPSSysDBValueOPId);
    }

    @Override
    protected CallResult selectSingle(String strSQL, BaseDataEntity dataEntity, String strOpPersonId) {
        return super.selectSingle(strSQL, dataEntity, strOpPersonId);
    }

    @Override
    protected CallResult selectSingle(String strSQL, IEntity dataEntity, String strOpPersonId) {
        return super.selectSingle(strSQL, dataEntity, strOpPersonId);
    }

    @Override
    protected CallResult selectMulti(String strSQL, Vector list, Class classType, String strOpPersonId) {
        return super.selectMulti(strSQL, list, classType, strOpPersonId);
    }

    @Override
    protected CallResult selectMulti(String strSQL, Vector list, Class classType, String strOpPersonId, boolean bSystemFields) {
        return super.selectMulti(strSQL, list, classType, strOpPersonId, bSystemFields);
    }

    @Override
    protected CallResult selectMulti(String strSQL, Vector list, String strObjectName, String strOpPersonId) {
        return super.selectMulti(strSQL, list, strObjectName, strOpPersonId);
    }

    @Override
    protected CallResult selectMulti(String strSQL, Vector list, String strObjectName, String strOpPersonId, boolean bSystemFields) {
        return super.selectMulti(strSQL, list, strObjectName, strOpPersonId, bSystemFields);
    }

    protected static class HBaseSelectFilter {
        private IBASelectContext iBASelectContext = null;
        private String strTableName = null;

        public HBaseSelectFilter(IBASelectContext iBASelectContext, String strTableName) {
            this.iBASelectContext = iBASelectContext;
            this.strTableName = strTableName;
        }

        public IBASelectContext getSelectContext() {
            return this.iBASelectContext;
        }

        public String getTableName() {
            return this.strTableName;
        }
    }
}

