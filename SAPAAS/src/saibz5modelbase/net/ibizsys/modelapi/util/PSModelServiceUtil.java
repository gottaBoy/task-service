/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.util;

import java.util.HashMap;
import java.util.Map;
import net.ibizsys.modelapi.service.IPSACHandlerActionService;
import net.ibizsys.modelapi.service.IPSACHandlerService;
import net.ibizsys.modelapi.service.IPSAppDERSService;
import net.ibizsys.modelapi.service.IPSAppDEViewService;
import net.ibizsys.modelapi.service.IPSAppDynaDEViewService;
import net.ibizsys.modelapi.service.IPSAppFuncService;
import net.ibizsys.modelapi.service.IPSAppIndexViewService;
import net.ibizsys.modelapi.service.IPSAppLanService;
import net.ibizsys.modelapi.service.IPSAppLocalDEService;
import net.ibizsys.modelapi.service.IPSAppLogicService;
import net.ibizsys.modelapi.service.IPSAppMenuItemService;
import net.ibizsys.modelapi.service.IPSAppMenuLogicService;
import net.ibizsys.modelapi.service.IPSAppMenuService;
import net.ibizsys.modelapi.service.IPSAppModuleService;
import net.ibizsys.modelapi.service.IPSAppPDTViewService;
import net.ibizsys.modelapi.service.IPSAppPVPartService;
import net.ibizsys.modelapi.service.IPSAppPanelViewService;
import net.ibizsys.modelapi.service.IPSAppPkgService;
import net.ibizsys.modelapi.service.IPSAppPortalViewService;
import net.ibizsys.modelapi.service.IPSAppPortletService;
import net.ibizsys.modelapi.service.IPSAppResourceService;
import net.ibizsys.modelapi.service.IPSAppSBItemRSService;
import net.ibizsys.modelapi.service.IPSAppSBItemService;
import net.ibizsys.modelapi.service.IPSAppStoryBoardService;
import net.ibizsys.modelapi.service.IPSAppTitleBarService;
import net.ibizsys.modelapi.service.IPSAppUIStyleService;
import net.ibizsys.modelapi.service.IPSAppUIThemeService;
import net.ibizsys.modelapi.service.IPSAppUserModeService;
import net.ibizsys.modelapi.service.IPSAppUtilPageService;
import net.ibizsys.modelapi.service.IPSAppUtilService;
import net.ibizsys.modelapi.service.IPSAppUtilViewService;
import net.ibizsys.modelapi.service.IPSAppViewServiceProxy;
import net.ibizsys.modelapi.service.IPSAppWFService;
import net.ibizsys.modelapi.service.IPSAppWFVerService;
import net.ibizsys.modelapi.service.IPSCodeItemService;
import net.ibizsys.modelapi.service.IPSCodeListService;
import net.ibizsys.modelapi.service.IPSCtrlLogicGroupService;
import net.ibizsys.modelapi.service.IPSCtrlLogicGrpDetailService;
import net.ibizsys.modelapi.service.IPSCtrlMsgItemService;
import net.ibizsys.modelapi.service.IPSCtrlMsgService;
import net.ibizsys.modelapi.service.IPSDEACModeItemService;
import net.ibizsys.modelapi.service.IPSDEACModeService;
import net.ibizsys.modelapi.service.IPSDEAGDetailService;
import net.ibizsys.modelapi.service.IPSDEActionGroupService;
import net.ibizsys.modelapi.service.IPSDEActionLogicService;
import net.ibizsys.modelapi.service.IPSDEActionParamService;
import net.ibizsys.modelapi.service.IPSDEActionService;
import net.ibizsys.modelapi.service.IPSDEActionTemplService;
import net.ibizsys.modelapi.service.IPSDEActionVRService;
import net.ibizsys.modelapi.service.IPSDEChartAxesService;
import net.ibizsys.modelapi.service.IPSDEChartLogicService;
import net.ibizsys.modelapi.service.IPSDEChartParamService;
import net.ibizsys.modelapi.service.IPSDEChartService;
import net.ibizsys.modelapi.service.IPSDEDBCfgService;
import net.ibizsys.modelapi.service.IPSDEDBIdxFieldService;
import net.ibizsys.modelapi.service.IPSDEDBIndexService;
import net.ibizsys.modelapi.service.IPSDEDQCodeCondService;
import net.ibizsys.modelapi.service.IPSDEDQCodeExpService;
import net.ibizsys.modelapi.service.IPSDEDQCodeService;
import net.ibizsys.modelapi.service.IPSDEDQCondService;
import net.ibizsys.modelapi.service.IPSDEDQJoinService;
import net.ibizsys.modelapi.service.IPSDEDRDetailService;
import net.ibizsys.modelapi.service.IPSDEDRGroupService;
import net.ibizsys.modelapi.service.IPSDEDRItemService;
import net.ibizsys.modelapi.service.IPSDEDSDQService;
import net.ibizsys.modelapi.service.IPSDEDSGrpParamService;
import net.ibizsys.modelapi.service.IPSDEDSParamService;
import net.ibizsys.modelapi.service.IPSDEDTSQueueService;
import net.ibizsys.modelapi.service.IPSDEDataExpService;
import net.ibizsys.modelapi.service.IPSDEDataImpItemService;
import net.ibizsys.modelapi.service.IPSDEDataImpService;
import net.ibizsys.modelapi.service.IPSDEDataQueryService;
import net.ibizsys.modelapi.service.IPSDEDataRelationService;
import net.ibizsys.modelapi.service.IPSDEDataSetService;
import net.ibizsys.modelapi.service.IPSDEDataSyncService;
import net.ibizsys.modelapi.service.IPSDEDataViewLogicService;
import net.ibizsys.modelapi.service.IPSDEDataViewService;
import net.ibizsys.modelapi.service.IPSDEFDLogicService;
import net.ibizsys.modelapi.service.IPSDEFDTColService;
import net.ibizsys.modelapi.service.IPSDEFGroupDetailService;
import net.ibizsys.modelapi.service.IPSDEFGroupService;
import net.ibizsys.modelapi.service.IPSDEFIUDetailService;
import net.ibizsys.modelapi.service.IPSDEFIUpdateService;
import net.ibizsys.modelapi.service.IPSDEFIVRService;
import net.ibizsys.modelapi.service.IPSDEFInputTipService;
import net.ibizsys.modelapi.service.IPSDEFInputTipSetService;
import net.ibizsys.modelapi.service.IPSDEFSFItemService;
import net.ibizsys.modelapi.service.IPSDEFUIModeService;
import net.ibizsys.modelapi.service.IPSDEFVRCondService;
import net.ibizsys.modelapi.service.IPSDEFValueRuleService;
import net.ibizsys.modelapi.service.IPSDEFieldService;
import net.ibizsys.modelapi.service.IPSDEFormDetailService;
import net.ibizsys.modelapi.service.IPSDEFormLogicService;
import net.ibizsys.modelapi.service.IPSDEFormRFService;
import net.ibizsys.modelapi.service.IPSDEFormService;
import net.ibizsys.modelapi.service.IPSDEGEIUDetailService;
import net.ibizsys.modelapi.service.IPSDEGEIUpdateService;
import net.ibizsys.modelapi.service.IPSDEGEIVRService;
import net.ibizsys.modelapi.service.IPSDEGridColService;
import net.ibizsys.modelapi.service.IPSDEGridLogicService;
import net.ibizsys.modelapi.service.IPSDEGridService;
import net.ibizsys.modelapi.service.IPSDEGroupDetailService;
import net.ibizsys.modelapi.service.IPSDEGroupService;
import net.ibizsys.modelapi.service.IPSDELLCondService;
import net.ibizsys.modelapi.service.IPSDELNParamService;
import net.ibizsys.modelapi.service.IPSDEListItemService;
import net.ibizsys.modelapi.service.IPSDEListLogicService;
import net.ibizsys.modelapi.service.IPSDEListService;
import net.ibizsys.modelapi.service.IPSDELogicLinkService;
import net.ibizsys.modelapi.service.IPSDELogicNodeService;
import net.ibizsys.modelapi.service.IPSDELogicParamService;
import net.ibizsys.modelapi.service.IPSDELogicService;
import net.ibizsys.modelapi.service.IPSDEMSActionService;
import net.ibizsys.modelapi.service.IPSDEMSOPPrivService;
import net.ibizsys.modelapi.service.IPSDEMainStateRSService;
import net.ibizsys.modelapi.service.IPSDEMainStateService;
import net.ibizsys.modelapi.service.IPSDEMapActionService;
import net.ibizsys.modelapi.service.IPSDEMapDQService;
import net.ibizsys.modelapi.service.IPSDEMapDSService;
import net.ibizsys.modelapi.service.IPSDEMapDetailService;
import net.ibizsys.modelapi.service.IPSDEMapService;
import net.ibizsys.modelapi.service.IPSDENotifyService;
import net.ibizsys.modelapi.service.IPSDENotifyTargetService;
import net.ibizsys.modelapi.service.IPSDEOPPrivRoleService;
import net.ibizsys.modelapi.service.IPSDEOPPrivService;
import net.ibizsys.modelapi.service.IPSDEPrintService;
import net.ibizsys.modelapi.service.IPSDERDEFMapService;
import net.ibizsys.modelapi.service.IPSDERGroupDetailService;
import net.ibizsys.modelapi.service.IPSDERGroupService;
import net.ibizsys.modelapi.service.IPSDERService;
import net.ibizsys.modelapi.service.IPSDERepItemService;
import net.ibizsys.modelapi.service.IPSDEReportService;
import net.ibizsys.modelapi.service.IPSDESADetailParamService;
import net.ibizsys.modelapi.service.IPSDESADetailService;
import net.ibizsys.modelapi.service.IPSDESARSService;
import net.ibizsys.modelapi.service.IPSDESAVRService;
import net.ibizsys.modelapi.service.IPSDESampleDataService;
import net.ibizsys.modelapi.service.IPSDEServiceAPIService;
import net.ibizsys.modelapi.service.IPSDETBItemService;
import net.ibizsys.modelapi.service.IPSDETableService;
import net.ibizsys.modelapi.service.IPSDEToolbarLogicService;
import net.ibizsys.modelapi.service.IPSDEToolbarService;
import net.ibizsys.modelapi.service.IPSDETreeColService;
import net.ibizsys.modelapi.service.IPSDETreeLogicService;
import net.ibizsys.modelapi.service.IPSDETreeNodeColService;
import net.ibizsys.modelapi.service.IPSDETreeNodeRSService;
import net.ibizsys.modelapi.service.IPSDETreeNodeRVService;
import net.ibizsys.modelapi.service.IPSDETreeNodeService;
import net.ibizsys.modelapi.service.IPSDETreeViewService;
import net.ibizsys.modelapi.service.IPSDEUAGroupDetailService;
import net.ibizsys.modelapi.service.IPSDEUAGroupService;
import net.ibizsys.modelapi.service.IPSDEUIActionService;
import net.ibizsys.modelapi.service.IPSDEUserRoleService;
import net.ibizsys.modelapi.service.IPSDEUtilDEService;
import net.ibizsys.modelapi.service.IPSDEVRGroupService;
import net.ibizsys.modelapi.service.IPSDEVRGrpDetailService;
import net.ibizsys.modelapi.service.IPSDEViewBaseService;
import net.ibizsys.modelapi.service.IPSDEViewCtrlService;
import net.ibizsys.modelapi.service.IPSDEViewEngineService;
import net.ibizsys.modelapi.service.IPSDEViewLogicService;
import net.ibizsys.modelapi.service.IPSDEViewRVService;
import net.ibizsys.modelapi.service.IPSDEWizardFormService;
import net.ibizsys.modelapi.service.IPSDEWizardLogicService;
import net.ibizsys.modelapi.service.IPSDEWizardService;
import net.ibizsys.modelapi.service.IPSDEWizardStepService;
import net.ibizsys.modelapi.service.IPSDataEntityService;
import net.ibizsys.modelapi.service.IPSLanguageItemService;
import net.ibizsys.modelapi.service.IPSLanguageResService;
import net.ibizsys.modelapi.service.IPSLanguageService;
import net.ibizsys.modelapi.service.IPSMobAppPackService;
import net.ibizsys.modelapi.service.IPSMobAppStartPageService;
import net.ibizsys.modelapi.service.IPSModuleService;
import net.ibizsys.modelapi.service.IPSPanelEngineService;
import net.ibizsys.modelapi.service.IPSPanelItemLogicService;
import net.ibizsys.modelapi.service.IPSSubSysSADEFieldService;
import net.ibizsys.modelapi.service.IPSSubSysSADERSService;
import net.ibizsys.modelapi.service.IPSSubSysSADEService;
import net.ibizsys.modelapi.service.IPSSubSysSADetailParamService;
import net.ibizsys.modelapi.service.IPSSubSysSADetailService;
import net.ibizsys.modelapi.service.IPSSubSysServiceAPIService;
import net.ibizsys.modelapi.service.IPSSubViewTypeService;
import net.ibizsys.modelapi.service.IPSSysActorService;
import net.ibizsys.modelapi.service.IPSSysAppService;
import net.ibizsys.modelapi.service.IPSSysBDColSetService;
import net.ibizsys.modelapi.service.IPSSysBDColumnService;
import net.ibizsys.modelapi.service.IPSSysBDInstCfgService;
import net.ibizsys.modelapi.service.IPSSysBDModuleService;
import net.ibizsys.modelapi.service.IPSSysBDPartService;
import net.ibizsys.modelapi.service.IPSSysBDSchemeService;
import net.ibizsys.modelapi.service.IPSSysBDTableDERService;
import net.ibizsys.modelapi.service.IPSSysBDTableDEService;
import net.ibizsys.modelapi.service.IPSSysBDTableRSService;
import net.ibizsys.modelapi.service.IPSSysBDTableService;
import net.ibizsys.modelapi.service.IPSSysBIAggColumnService;
import net.ibizsys.modelapi.service.IPSSysBIAggTableService;
import net.ibizsys.modelapi.service.IPSSysBICubeDimensionService;
import net.ibizsys.modelapi.service.IPSSysBICubeLevelService;
import net.ibizsys.modelapi.service.IPSSysBICubeMeasureService;
import net.ibizsys.modelapi.service.IPSSysBICubeService;
import net.ibizsys.modelapi.service.IPSSysBIDimensionService;
import net.ibizsys.modelapi.service.IPSSysBIHierarchyService;
import net.ibizsys.modelapi.service.IPSSysBILevelService;
import net.ibizsys.modelapi.service.IPSSysBISchemeService;
import net.ibizsys.modelapi.service.IPSSysBackServiceService;
import net.ibizsys.modelapi.service.IPSSysCalendarItemRVService;
import net.ibizsys.modelapi.service.IPSSysCalendarItemService;
import net.ibizsys.modelapi.service.IPSSysCalendarLogicService;
import net.ibizsys.modelapi.service.IPSSysCalendarService;
import net.ibizsys.modelapi.service.IPSSysCanvasModelService;
import net.ibizsys.modelapi.service.IPSSysCanvasService;
import net.ibizsys.modelapi.service.IPSSysChartThemeService;
import net.ibizsys.modelapi.service.IPSSysCodeSnippetService;
import net.ibizsys.modelapi.service.IPSSysContentCatService;
import net.ibizsys.modelapi.service.IPSSysContentService;
import net.ibizsys.modelapi.service.IPSSysCounterItemService;
import net.ibizsys.modelapi.service.IPSSysCounterService;
import net.ibizsys.modelapi.service.IPSSysCssCatService;
import net.ibizsys.modelapi.service.IPSSysCssService;
import net.ibizsys.modelapi.service.IPSSysDBColumnService;
import net.ibizsys.modelapi.service.IPSSysDBPartService;
import net.ibizsys.modelapi.service.IPSSysDBProcParamService;
import net.ibizsys.modelapi.service.IPSSysDBProcService;
import net.ibizsys.modelapi.service.IPSSysDBSchemeService;
import net.ibizsys.modelapi.service.IPSSysDBTableService;
import net.ibizsys.modelapi.service.IPSSysDBVFService;
import net.ibizsys.modelapi.service.IPSSysDEFTypeService;
import net.ibizsys.modelapi.service.IPSSysDELogicNodeService;
import net.ibizsys.modelapi.service.IPSSysDMItemService;
import net.ibizsys.modelapi.service.IPSSysDMVerService;
import net.ibizsys.modelapi.service.IPSSysDashboardLogicService;
import net.ibizsys.modelapi.service.IPSSysDashboardService;
import net.ibizsys.modelapi.service.IPSSysDataSyncAgentService;
import net.ibizsys.modelapi.service.IPSSysDictCatService;
import net.ibizsys.modelapi.service.IPSSysDynaModelAttrService;
import net.ibizsys.modelapi.service.IPSSysDynaModelCatService;
import net.ibizsys.modelapi.service.IPSSysDynaModelService;
import net.ibizsys.modelapi.service.IPSSysEAIDEFieldService;
import net.ibizsys.modelapi.service.IPSSysEAIDERService;
import net.ibizsys.modelapi.service.IPSSysEAIDEService;
import net.ibizsys.modelapi.service.IPSSysEAIDataTypeItemService;
import net.ibizsys.modelapi.service.IPSSysEAIDataTypeService;
import net.ibizsys.modelapi.service.IPSSysEAIElementAttrService;
import net.ibizsys.modelapi.service.IPSSysEAIElementREService;
import net.ibizsys.modelapi.service.IPSSysEAIElementService;
import net.ibizsys.modelapi.service.IPSSysEAISchemeService;
import net.ibizsys.modelapi.service.IPSSysERMapNodeService;
import net.ibizsys.modelapi.service.IPSSysERMapService;
import net.ibizsys.modelapi.service.IPSSysEditorStyleService;
import net.ibizsys.modelapi.service.IPSSysImageService;
import net.ibizsys.modelapi.service.IPSSysMapItemService;
import net.ibizsys.modelapi.service.IPSSysMapLogicService;
import net.ibizsys.modelapi.service.IPSSysMapViewService;
import net.ibizsys.modelapi.service.IPSSysModelGroupService;
import net.ibizsys.modelapi.service.IPSSysMsgQueueService;
import net.ibizsys.modelapi.service.IPSSysMsgTargetService;
import net.ibizsys.modelapi.service.IPSSysMsgTemplService;
import net.ibizsys.modelapi.service.IPSSysOPPrivService;
import net.ibizsys.modelapi.service.IPSSysPDTViewService;
import net.ibizsys.modelapi.service.IPSSysPFPITemplService;
import net.ibizsys.modelapi.service.IPSSysPFPluginService;
import net.ibizsys.modelapi.service.IPSSysPortletCatService;
import net.ibizsys.modelapi.service.IPSSysPortletService;
import net.ibizsys.modelapi.service.IPSSysRefService;
import net.ibizsys.modelapi.service.IPSSysReqItemDataService;
import net.ibizsys.modelapi.service.IPSSysReqItemHisService;
import net.ibizsys.modelapi.service.IPSSysReqItemService;
import net.ibizsys.modelapi.service.IPSSysReqModuleService;
import net.ibizsys.modelapi.service.IPSSysResourceService;
import net.ibizsys.modelapi.service.IPSSysSAHandlerService;
import net.ibizsys.modelapi.service.IPSSysSFPITemplService;
import net.ibizsys.modelapi.service.IPSSysSFPluginService;
import net.ibizsys.modelapi.service.IPSSysSFPubPkgService;
import net.ibizsys.modelapi.service.IPSSysSFPubService;
import net.ibizsys.modelapi.service.IPSSysSampleValueService;
import net.ibizsys.modelapi.service.IPSSysSearchBarItemService;
import net.ibizsys.modelapi.service.IPSSysSearchBarLogicService;
import net.ibizsys.modelapi.service.IPSSysSearchBarService;
import net.ibizsys.modelapi.service.IPSSysSearchDEFieldService;
import net.ibizsys.modelapi.service.IPSSysSearchDEService;
import net.ibizsys.modelapi.service.IPSSysSearchDocService;
import net.ibizsys.modelapi.service.IPSSysSearchFieldService;
import net.ibizsys.modelapi.service.IPSSysSearchSchemeService;
import net.ibizsys.modelapi.service.IPSSysSequenceService;
import net.ibizsys.modelapi.service.IPSSysServiceAPIService;
import net.ibizsys.modelapi.service.IPSSysTCAssertService;
import net.ibizsys.modelapi.service.IPSSysTCInputService;
import net.ibizsys.modelapi.service.IPSSysTDItemService;
import net.ibizsys.modelapi.service.IPSSysTestCaseService;
import net.ibizsys.modelapi.service.IPSSysTestDataService;
import net.ibizsys.modelapi.service.IPSSysTestModuleService;
import net.ibizsys.modelapi.service.IPSSysTestPrjService;
import net.ibizsys.modelapi.service.IPSSysTranslatorService;
import net.ibizsys.modelapi.service.IPSSysUCMapNodeService;
import net.ibizsys.modelapi.service.IPSSysUCMapService;
import net.ibizsys.modelapi.service.IPSSysUniResService;
import net.ibizsys.modelapi.service.IPSSysUniStateService;
import net.ibizsys.modelapi.service.IPSSysUnitService;
import net.ibizsys.modelapi.service.IPSSysUserCaseRSService;
import net.ibizsys.modelapi.service.IPSSysUserCaseService;
import net.ibizsys.modelapi.service.IPSSysUserDRService;
import net.ibizsys.modelapi.service.IPSSysUserModeService;
import net.ibizsys.modelapi.service.IPSSysUserRoleDataService;
import net.ibizsys.modelapi.service.IPSSysUserRoleResService;
import net.ibizsys.modelapi.service.IPSSysUtilDEService;
import net.ibizsys.modelapi.service.IPSSysValueRuleService;
import net.ibizsys.modelapi.service.IPSSysViewLogicParamService;
import net.ibizsys.modelapi.service.IPSSysViewLogicService;
import net.ibizsys.modelapi.service.IPSSysViewPanelItemService;
import net.ibizsys.modelapi.service.IPSSysViewPanelLogicService;
import net.ibizsys.modelapi.service.IPSSysViewPanelModelService;
import net.ibizsys.modelapi.service.IPSSysViewPanelService;
import net.ibizsys.modelapi.service.IPSSysWFCatService;
import net.ibizsys.modelapi.service.IPSSysWFModeService;
import net.ibizsys.modelapi.service.IPSSysWFSettingService;
import net.ibizsys.modelapi.service.IPSSystemDBCfgService;
import net.ibizsys.modelapi.service.IPSSystemRunService;
import net.ibizsys.modelapi.service.IPSSystemService;
import net.ibizsys.modelapi.service.IPSThresholdGroupService;
import net.ibizsys.modelapi.service.IPSThresholdService;
import net.ibizsys.modelapi.service.IPSViewMsgGroupService;
import net.ibizsys.modelapi.service.IPSViewMsgGrpDetailService;
import net.ibizsys.modelapi.service.IPSViewMsgService;
import net.ibizsys.modelapi.service.IPSWFDEService;
import net.ibizsys.modelapi.service.IPSWFLinkCondService;
import net.ibizsys.modelapi.service.IPSWFLinkRoleService;
import net.ibizsys.modelapi.service.IPSWFLinkService;
import net.ibizsys.modelapi.service.IPSWFProcParamService;
import net.ibizsys.modelapi.service.IPSWFProcRoleService;
import net.ibizsys.modelapi.service.IPSWFProcSubWFService;
import net.ibizsys.modelapi.service.IPSWFProcessService;
import net.ibizsys.modelapi.service.IPSWFRoleService;
import net.ibizsys.modelapi.service.IPSWFUtilUIActionService;
import net.ibizsys.modelapi.service.IPSWFVersionService;
import net.ibizsys.modelapi.service.IPSWFWorkTimeService;
import net.ibizsys.modelapi.service.IPSWXAccountService;
import net.ibizsys.modelapi.service.IPSWXEntAppService;
import net.ibizsys.modelapi.service.IPSWXLogicService;
import net.ibizsys.modelapi.service.IPSWXMenuFuncService;
import net.ibizsys.modelapi.service.IPSWXMenuItemService;
import net.ibizsys.modelapi.service.IPSWXMenuService;
import net.ibizsys.modelapi.service.IPSWorkflowService;
import net.ibizsys.modelapi.service.impl.PSACHandlerActionServiceImpl;
import net.ibizsys.modelapi.service.impl.PSACHandlerServiceImpl;
import net.ibizsys.modelapi.service.impl.PSAppDERSServiceImpl;
import net.ibizsys.modelapi.service.impl.PSAppDEViewServiceImpl;
import net.ibizsys.modelapi.service.impl.PSAppDynaDEViewServiceImpl;
import net.ibizsys.modelapi.service.impl.PSAppFuncServiceImpl;
import net.ibizsys.modelapi.service.impl.PSAppIndexViewServiceImpl;
import net.ibizsys.modelapi.service.impl.PSAppLanServiceImpl;
import net.ibizsys.modelapi.service.impl.PSAppLocalDEServiceImpl;
import net.ibizsys.modelapi.service.impl.PSAppLogicServiceImpl;
import net.ibizsys.modelapi.service.impl.PSAppMenuItemServiceImpl;
import net.ibizsys.modelapi.service.impl.PSAppMenuLogicServiceImpl;
import net.ibizsys.modelapi.service.impl.PSAppMenuServiceImpl;
import net.ibizsys.modelapi.service.impl.PSAppModuleServiceImpl;
import net.ibizsys.modelapi.service.impl.PSAppPDTViewServiceImpl;
import net.ibizsys.modelapi.service.impl.PSAppPVPartServiceImpl;
import net.ibizsys.modelapi.service.impl.PSAppPanelViewServiceImpl;
import net.ibizsys.modelapi.service.impl.PSAppPkgServiceImpl;
import net.ibizsys.modelapi.service.impl.PSAppPortalViewServiceImpl;
import net.ibizsys.modelapi.service.impl.PSAppPortletServiceImpl;
import net.ibizsys.modelapi.service.impl.PSAppResourceServiceImpl;
import net.ibizsys.modelapi.service.impl.PSAppSBItemRSServiceImpl;
import net.ibizsys.modelapi.service.impl.PSAppSBItemServiceImpl;
import net.ibizsys.modelapi.service.impl.PSAppStoryBoardServiceImpl;
import net.ibizsys.modelapi.service.impl.PSAppTitleBarServiceImpl;
import net.ibizsys.modelapi.service.impl.PSAppUIStyleServiceImpl;
import net.ibizsys.modelapi.service.impl.PSAppUIThemeServiceImpl;
import net.ibizsys.modelapi.service.impl.PSAppUserModeServiceImpl;
import net.ibizsys.modelapi.service.impl.PSAppUtilPageServiceImpl;
import net.ibizsys.modelapi.service.impl.PSAppUtilServiceImpl;
import net.ibizsys.modelapi.service.impl.PSAppUtilViewServiceImpl;
import net.ibizsys.modelapi.service.impl.PSAppViewServiceProxyImpl;
import net.ibizsys.modelapi.service.impl.PSAppWFServiceImpl;
import net.ibizsys.modelapi.service.impl.PSAppWFVerServiceImpl;
import net.ibizsys.modelapi.service.impl.PSCodeItemServiceImpl;
import net.ibizsys.modelapi.service.impl.PSCodeListServiceImpl;
import net.ibizsys.modelapi.service.impl.PSCtrlLogicGroupServiceImpl;
import net.ibizsys.modelapi.service.impl.PSCtrlLogicGrpDetailServiceImpl;
import net.ibizsys.modelapi.service.impl.PSCtrlMsgItemServiceImpl;
import net.ibizsys.modelapi.service.impl.PSCtrlMsgServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEACModeItemServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEACModeServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEAGDetailServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEActionGroupServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEActionLogicServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEActionParamServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEActionServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEActionTemplServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEActionVRServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEChartAxesServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEChartLogicServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEChartParamServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEChartServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEDBCfgServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEDBIdxFieldServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEDBIndexServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEDQCodeCondServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEDQCodeExpServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEDQCodeServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEDQCondServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEDQJoinServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEDRDetailServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEDRGroupServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEDRItemServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEDSDQServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEDSGrpParamServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEDSParamServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEDTSQueueServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEDataExpServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEDataImpItemServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEDataImpServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEDataQueryServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEDataRelationServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEDataSetServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEDataSyncServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEDataViewLogicServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEDataViewServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEFDLogicServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEFDTColServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEFGroupDetailServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEFGroupServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEFIUDetailServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEFIUpdateServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEFIVRServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEFInputTipServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEFInputTipSetServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEFSFItemServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEFUIModeServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEFVRCondServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEFValueRuleServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEFieldServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEFormDetailServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEFormLogicServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEFormRFServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEFormServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEGEIUDetailServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEGEIUpdateServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEGEIVRServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEGridColServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEGridLogicServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEGridServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEGroupDetailServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEGroupServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDELLCondServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDELNParamServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEListItemServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEListLogicServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEListServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDELogicLinkServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDELogicNodeServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDELogicParamServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDELogicServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEMSActionServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEMSOPPrivServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEMainStateRSServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEMainStateServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEMapActionServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEMapDQServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEMapDSServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEMapDetailServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEMapServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDENotifyServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDENotifyTargetServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEOPPrivRoleServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEOPPrivServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEPrintServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDERDEFMapServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDERGroupDetailServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDERGroupServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDERServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDERepItemServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEReportServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDESADetailParamServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDESADetailServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDESARSServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDESAVRServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDESampleDataServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEServiceAPIServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDETBItemServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDETableServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEToolbarLogicServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEToolbarServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDETreeColServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDETreeLogicServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDETreeNodeColServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDETreeNodeRSServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDETreeNodeRVServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDETreeNodeServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDETreeViewServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEUAGroupDetailServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEUAGroupServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEUIActionServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEUserRoleServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEUtilDEServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEVRGroupServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEVRGrpDetailServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEViewBaseServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEViewCtrlServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEViewEngineServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEViewLogicServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEViewRVServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEWizardFormServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEWizardLogicServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEWizardServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDEWizardStepServiceImpl;
import net.ibizsys.modelapi.service.impl.PSDataEntityServiceImpl;
import net.ibizsys.modelapi.service.impl.PSLanguageItemServiceImpl;
import net.ibizsys.modelapi.service.impl.PSLanguageResServiceImpl;
import net.ibizsys.modelapi.service.impl.PSLanguageServiceImpl;
import net.ibizsys.modelapi.service.impl.PSMobAppPackServiceImpl;
import net.ibizsys.modelapi.service.impl.PSMobAppStartPageServiceImpl;
import net.ibizsys.modelapi.service.impl.PSModuleServiceImpl;
import net.ibizsys.modelapi.service.impl.PSPanelEngineServiceImpl;
import net.ibizsys.modelapi.service.impl.PSPanelItemLogicServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSubSysSADEFieldServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSubSysSADERSServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSubSysSADEServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSubSysSADetailParamServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSubSysSADetailServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSubSysServiceAPIServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSubViewTypeServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysActorServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysAppServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysBDColSetServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysBDColumnServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysBDInstCfgServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysBDModuleServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysBDPartServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysBDSchemeServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysBDTableDERServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysBDTableDEServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysBDTableRSServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysBDTableServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysBIAggColumnServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysBIAggTableServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysBICubeDimensionServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysBICubeLevelServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysBICubeMeasureServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysBICubeServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysBIDimensionServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysBIHierarchyServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysBILevelServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysBISchemeServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysBackServiceServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysCalendarItemRVServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysCalendarItemServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysCalendarLogicServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysCalendarServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysCanvasModelServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysCanvasServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysChartThemeServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysCodeSnippetServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysContentCatServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysContentServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysCounterItemServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysCounterServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysCssCatServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysCssServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysDBColumnServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysDBPartServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysDBProcParamServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysDBProcServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysDBSchemeServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysDBTableServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysDBVFServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysDEFTypeServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysDELogicNodeServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysDMItemServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysDMVerServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysDashboardLogicServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysDashboardServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysDataSyncAgentServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysDictCatServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysDynaModelAttrServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysDynaModelCatServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysDynaModelServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysEAIDEFieldServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysEAIDERServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysEAIDEServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysEAIDataTypeItemServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysEAIDataTypeServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysEAIElementAttrServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysEAIElementREServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysEAIElementServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysEAISchemeServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysERMapNodeServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysERMapServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysEditorStyleServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysImageServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysMapItemServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysMapLogicServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysMapViewServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysModelGroupServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysMsgQueueServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysMsgTargetServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysMsgTemplServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysOPPrivServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysPDTViewServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysPFPITemplServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysPFPluginServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysPortletCatServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysPortletServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysRefServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysReqItemDataServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysReqItemHisServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysReqItemServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysReqModuleServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysResourceServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysSAHandlerServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysSFPITemplServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysSFPluginServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysSFPubPkgServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysSFPubServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysSampleValueServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysSearchBarItemServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysSearchBarLogicServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysSearchBarServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysSearchDEFieldServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysSearchDEServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysSearchDocServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysSearchFieldServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysSearchSchemeServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysSequenceServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysServiceAPIServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysTCAssertServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysTCInputServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysTDItemServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysTestCaseServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysTestDataServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysTestModuleServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysTestPrjServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysTranslatorServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysUCMapNodeServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysUCMapServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysUniResServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysUniStateServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysUnitServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysUserCaseRSServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysUserCaseServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysUserDRServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysUserModeServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysUserRoleDataServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysUserRoleResServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysUtilDEServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysValueRuleServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysViewLogicParamServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysViewLogicServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysViewPanelItemServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysViewPanelLogicServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysViewPanelModelServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysViewPanelServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysWFCatServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysWFModeServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSysWFSettingServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSystemDBCfgServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSystemRunServiceImpl;
import net.ibizsys.modelapi.service.impl.PSSystemServiceImpl;
import net.ibizsys.modelapi.service.impl.PSThresholdGroupServiceImpl;
import net.ibizsys.modelapi.service.impl.PSThresholdServiceImpl;
import net.ibizsys.modelapi.service.impl.PSViewMsgGroupServiceImpl;
import net.ibizsys.modelapi.service.impl.PSViewMsgGrpDetailServiceImpl;
import net.ibizsys.modelapi.service.impl.PSViewMsgServiceImpl;
import net.ibizsys.modelapi.service.impl.PSWFDEServiceImpl;
import net.ibizsys.modelapi.service.impl.PSWFLinkCondServiceImpl;
import net.ibizsys.modelapi.service.impl.PSWFLinkRoleServiceImpl;
import net.ibizsys.modelapi.service.impl.PSWFLinkServiceImpl;
import net.ibizsys.modelapi.service.impl.PSWFProcParamServiceImpl;
import net.ibizsys.modelapi.service.impl.PSWFProcRoleServiceImpl;
import net.ibizsys.modelapi.service.impl.PSWFProcSubWFServiceImpl;
import net.ibizsys.modelapi.service.impl.PSWFProcessServiceImpl;
import net.ibizsys.modelapi.service.impl.PSWFRoleServiceImpl;
import net.ibizsys.modelapi.service.impl.PSWFUtilUIActionServiceImpl;
import net.ibizsys.modelapi.service.impl.PSWFVersionServiceImpl;
import net.ibizsys.modelapi.service.impl.PSWFWorkTimeServiceImpl;
import net.ibizsys.modelapi.service.impl.PSWXAccountServiceImpl;
import net.ibizsys.modelapi.service.impl.PSWXEntAppServiceImpl;
import net.ibizsys.modelapi.service.impl.PSWXLogicServiceImpl;
import net.ibizsys.modelapi.service.impl.PSWXMenuFuncServiceImpl;
import net.ibizsys.modelapi.service.impl.PSWXMenuItemServiceImpl;
import net.ibizsys.modelapi.service.impl.PSWXMenuServiceImpl;
import net.ibizsys.modelapi.service.impl.PSWorkflowServiceImpl;
import net.ibizsys.modelapi.util.IPSModelService;

public class PSModelServiceUtil {
    private static PSModelServiceUtil instance = null;
    private Map<String, IPSModelService> psModelServiceMap = new HashMap<String, IPSModelService>();
    private IPSSystemService iPSSystemService;
    private IPSModuleService iPSModuleService;
    private IPSDataEntityService iPSDataEntityService;
    private IPSDEFieldService iPSDEFieldService;
    private IPSDERService iPSDERService;
    private IPSACHandlerService iPSACHandlerService;
    private IPSACHandlerActionService iPSACHandlerActionService;
    private IPSAppDERSService iPSAppDERSService;
    private IPSAppDEViewService iPSAppDEViewService;
    private IPSAppDynaDEViewService iPSAppDynaDEViewService;
    private IPSAppFuncService iPSAppFuncService;
    private IPSAppIndexViewService iPSAppIndexViewService;
    private IPSAppLanService iPSAppLanService;
    private IPSAppLocalDEService iPSAppLocalDEService;
    private IPSAppLogicService iPSAppLogicService;
    private IPSAppMenuService iPSAppMenuService;
    private IPSAppMenuItemService iPSAppMenuItemService;
    private IPSAppMenuLogicService iPSAppMenuLogicService;
    private IPSAppModuleService iPSAppModuleService;
    private IPSAppPDTViewService iPSAppPDTViewService;
    private IPSAppPVPartService iPSAppPVPartService;
    private IPSAppPanelViewService iPSAppPanelViewService;
    private IPSAppPkgService iPSAppPkgService;
    private IPSAppPortalViewService iPSAppPortalViewService;
    private IPSAppPortletService iPSAppPortletService;
    private IPSAppResourceService iPSAppResourceService;
    private IPSAppSBItemService iPSAppSBItemService;
    private IPSAppSBItemRSService iPSAppSBItemRSService;
    private IPSAppStoryBoardService iPSAppStoryBoardService;
    private IPSAppTitleBarService iPSAppTitleBarService;
    private IPSAppUIStyleService iPSAppUIStyleService;
    private IPSAppUIThemeService iPSAppUIThemeService;
    private IPSAppUserModeService iPSAppUserModeService;
    private IPSAppUtilService iPSAppUtilService;
    private IPSAppUtilPageService iPSAppUtilPageService;
    private IPSAppUtilViewService iPSAppUtilViewService;
    private IPSAppViewServiceProxy iPSAppViewService;
    private IPSAppWFService iPSAppWFService;
    private IPSAppWFVerService iPSAppWFVerService;
    private IPSCodeItemService iPSCodeItemService;
    private IPSCodeListService iPSCodeListService;
    private IPSCtrlLogicGroupService iPSCtrlLogicGroupService;
    private IPSCtrlLogicGrpDetailService iPSCtrlLogicGrpDetailService;
    private IPSCtrlMsgService iPSCtrlMsgService;
    private IPSCtrlMsgItemService iPSCtrlMsgItemService;
    private IPSDEACModeService iPSDEACModeService;
    private IPSDEACModeItemService iPSDEACModeItemService;
    private IPSDEAGDetailService iPSDEAGDetailService;
    private IPSDEActionService iPSDEActionService;
    private IPSDEActionGroupService iPSDEActionGroupService;
    private IPSDEActionLogicService iPSDEActionLogicService;
    private IPSDEActionParamService iPSDEActionParamService;
    private IPSDEActionTemplService iPSDEActionTemplService;
    private IPSDEActionVRService iPSDEActionVRService;
    private IPSDEChartService iPSDEChartService;
    private IPSDEChartAxesService iPSDEChartAxesService;
    private IPSDEChartLogicService iPSDEChartLogicService;
    private IPSDEChartParamService iPSDEChartParamService;
    private IPSDEDBCfgService iPSDEDBCfgService;
    private IPSDEDBIdxFieldService iPSDEDBIdxFieldService;
    private IPSDEDBIndexService iPSDEDBIndexService;
    private IPSDEDQCodeService iPSDEDQCodeService;
    private IPSDEDQCodeCondService iPSDEDQCodeCondService;
    private IPSDEDQCodeExpService iPSDEDQCodeExpService;
    private IPSDEDQCondService iPSDEDQCondService;
    private IPSDEDQJoinService iPSDEDQJoinService;
    private IPSDEDRDetailService iPSDEDRDetailService;
    private IPSDEDRGroupService iPSDEDRGroupService;
    private IPSDEDRItemService iPSDEDRItemService;
    private IPSDEDSDQService iPSDEDSDQService;
    private IPSDEDSGrpParamService iPSDEDSGrpParamService;
    private IPSDEDSParamService iPSDEDSParamService;
    private IPSDEDTSQueueService iPSDEDTSQueueService;
    private IPSDEDataExpService iPSDEDataExpService;
    private IPSDEDataImpService iPSDEDataImpService;
    private IPSDEDataImpItemService iPSDEDataImpItemService;
    private IPSDEDataQueryService iPSDEDataQueryService;
    private IPSDEDataRelationService iPSDEDataRelationService;
    private IPSDEDataSetService iPSDEDataSetService;
    private IPSDEDataSyncService iPSDEDataSyncService;
    private IPSDEDataViewService iPSDEDataViewService;
    private IPSDEDataViewLogicService iPSDEDataViewLogicService;
    private IPSDEFDLogicService iPSDEFDLogicService;
    private IPSDEFDTColService iPSDEFDTColService;
    private IPSDEFGroupService iPSDEFGroupService;
    private IPSDEFGroupDetailService iPSDEFGroupDetailService;
    private IPSDEFIUDetailService iPSDEFIUDetailService;
    private IPSDEFIUpdateService iPSDEFIUpdateService;
    private IPSDEFIVRService iPSDEFIVRService;
    private IPSDEFInputTipService iPSDEFInputTipService;
    private IPSDEFInputTipSetService iPSDEFInputTipSetService;
    private IPSDEFSFItemService iPSDEFSFItemService;
    private IPSDEFUIModeService iPSDEFUIModeService;
    private IPSDEFVRCondService iPSDEFVRCondService;
    private IPSDEFValueRuleService iPSDEFValueRuleService;
    private IPSDEFormService iPSDEFormService;
    private IPSDEFormDetailService iPSDEFormDetailService;
    private IPSDEFormLogicService iPSDEFormLogicService;
    private IPSDEFormRFService iPSDEFormRFService;
    private IPSDEGEIUDetailService iPSDEGEIUDetailService;
    private IPSDEGEIUpdateService iPSDEGEIUpdateService;
    private IPSDEGEIVRService iPSDEGEIVRService;
    private IPSDEGridService iPSDEGridService;
    private IPSDEGridColService iPSDEGridColService;
    private IPSDEGridLogicService iPSDEGridLogicService;
    private IPSDEGroupService iPSDEGroupService;
    private IPSDEGroupDetailService iPSDEGroupDetailService;
    private IPSDELLCondService iPSDELLCondService;
    private IPSDELNParamService iPSDELNParamService;
    private IPSDEListService iPSDEListService;
    private IPSDEListItemService iPSDEListItemService;
    private IPSDEListLogicService iPSDEListLogicService;
    private IPSDELogicService iPSDELogicService;
    private IPSDELogicLinkService iPSDELogicLinkService;
    private IPSDELogicNodeService iPSDELogicNodeService;
    private IPSDELogicParamService iPSDELogicParamService;
    private IPSDEMSActionService iPSDEMSActionService;
    private IPSDEMSOPPrivService iPSDEMSOPPrivService;
    private IPSDEMainStateService iPSDEMainStateService;
    private IPSDEMainStateRSService iPSDEMainStateRSService;
    private IPSDEMapService iPSDEMapService;
    private IPSDEMapActionService iPSDEMapActionService;
    private IPSDEMapDQService iPSDEMapDQService;
    private IPSDEMapDSService iPSDEMapDSService;
    private IPSDEMapDetailService iPSDEMapDetailService;
    private IPSDENotifyService iPSDENotifyService;
    private IPSDENotifyTargetService iPSDENotifyTargetService;
    private IPSDEOPPrivService iPSDEOPPrivService;
    private IPSDEOPPrivRoleService iPSDEOPPrivRoleService;
    private IPSDEPrintService iPSDEPrintService;
    private IPSDERDEFMapService iPSDERDEFMapService;
    private IPSDERGroupService iPSDERGroupService;
    private IPSDERGroupDetailService iPSDERGroupDetailService;
    private IPSDERepItemService iPSDERepItemService;
    private IPSDEReportService iPSDEReportService;
    private IPSDESADetailService iPSDESADetailService;
    private IPSDESADetailParamService iPSDESADetailParamService;
    private IPSDESARSService iPSDESARSService;
    private IPSDESAVRService iPSDESAVRService;
    private IPSDESampleDataService iPSDESampleDataService;
    private IPSDEServiceAPIService iPSDEServiceAPIService;
    private IPSDETBItemService iPSDETBItemService;
    private IPSDETableService iPSDETableService;
    private IPSDEToolbarService iPSDEToolbarService;
    private IPSDEToolbarLogicService iPSDEToolbarLogicService;
    private IPSDETreeColService iPSDETreeColService;
    private IPSDETreeLogicService iPSDETreeLogicService;
    private IPSDETreeNodeService iPSDETreeNodeService;
    private IPSDETreeNodeColService iPSDETreeNodeColService;
    private IPSDETreeNodeRSService iPSDETreeNodeRSService;
    private IPSDETreeNodeRVService iPSDETreeNodeRVService;
    private IPSDETreeViewService iPSDETreeViewService;
    private IPSDEUAGroupService iPSDEUAGroupService;
    private IPSDEUAGroupDetailService iPSDEUAGroupDetailService;
    private IPSDEUIActionService iPSDEUIActionService;
    private IPSDEUserRoleService iPSDEUserRoleService;
    private IPSDEUtilDEService iPSDEUtilDEService;
    private IPSDEVRGroupService iPSDEVRGroupService;
    private IPSDEVRGrpDetailService iPSDEVRGrpDetailService;
    private IPSDEViewBaseService iPSDEViewBaseService;
    private IPSDEViewCtrlService iPSDEViewCtrlService;
    private IPSDEViewEngineService iPSDEViewEngineService;
    private IPSDEViewLogicService iPSDEViewLogicService;
    private IPSDEViewRVService iPSDEViewRVService;
    private IPSDEWizardService iPSDEWizardService;
    private IPSDEWizardFormService iPSDEWizardFormService;
    private IPSDEWizardLogicService iPSDEWizardLogicService;
    private IPSDEWizardStepService iPSDEWizardStepService;
    private IPSLanguageService iPSLanguageService;
    private IPSLanguageItemService iPSLanguageItemService;
    private IPSLanguageResService iPSLanguageResService;
    private IPSMobAppPackService iPSMobAppPackService;
    private IPSMobAppStartPageService iPSMobAppStartPageService;
    private IPSPanelEngineService iPSPanelEngineService;
    private IPSPanelItemLogicService iPSPanelItemLogicService;
    private IPSSubSysSADEService iPSSubSysSADEService;
    private IPSSubSysSADEFieldService iPSSubSysSADEFieldService;
    private IPSSubSysSADERSService iPSSubSysSADERSService;
    private IPSSubSysSADetailService iPSSubSysSADetailService;
    private IPSSubSysSADetailParamService iPSSubSysSADetailParamService;
    private IPSSubSysServiceAPIService iPSSubSysServiceAPIService;
    private IPSSubViewTypeService iPSSubViewTypeService;
    private IPSSysActorService iPSSysActorService;
    private IPSSysAppService iPSSysAppService;
    private IPSSysBDColSetService iPSSysBDColSetService;
    private IPSSysBDColumnService iPSSysBDColumnService;
    private IPSSysBDInstCfgService iPSSysBDInstCfgService;
    private IPSSysBDModuleService iPSSysBDModuleService;
    private IPSSysBDPartService iPSSysBDPartService;
    private IPSSysBDSchemeService iPSSysBDSchemeService;
    private IPSSysBDTableService iPSSysBDTableService;
    private IPSSysBDTableDEService iPSSysBDTableDEService;
    private IPSSysBDTableDERService iPSSysBDTableDERService;
    private IPSSysBDTableRSService iPSSysBDTableRSService;
    private IPSSysBIAggColumnService iPSSysBIAggColumnService;
    private IPSSysBIAggTableService iPSSysBIAggTableService;
    private IPSSysBICubeService iPSSysBICubeService;
    private IPSSysBICubeDimensionService iPSSysBICubeDimensionService;
    private IPSSysBICubeLevelService iPSSysBICubeLevelService;
    private IPSSysBICubeMeasureService iPSSysBICubeMeasureService;
    private IPSSysBIDimensionService iPSSysBIDimensionService;
    private IPSSysBIHierarchyService iPSSysBIHierarchyService;
    private IPSSysBILevelService iPSSysBILevelService;
    private IPSSysBISchemeService iPSSysBISchemeService;
    private IPSSysBackServiceService iPSSysBackServiceService;
    private IPSSysCalendarService iPSSysCalendarService;
    private IPSSysCalendarItemService iPSSysCalendarItemService;
    private IPSSysCalendarItemRVService iPSSysCalendarItemRVService;
    private IPSSysCalendarLogicService iPSSysCalendarLogicService;
    private IPSSysCanvasService iPSSysCanvasService;
    private IPSSysCanvasModelService iPSSysCanvasModelService;
    private IPSSysChartThemeService iPSSysChartThemeService;
    private IPSSysCodeSnippetService iPSSysCodeSnippetService;
    private IPSSysContentService iPSSysContentService;
    private IPSSysContentCatService iPSSysContentCatService;
    private IPSSysCounterService iPSSysCounterService;
    private IPSSysCounterItemService iPSSysCounterItemService;
    private IPSSysCssService iPSSysCssService;
    private IPSSysCssCatService iPSSysCssCatService;
    private IPSSysDBColumnService iPSSysDBColumnService;
    private IPSSysDBPartService iPSSysDBPartService;
    private IPSSysDBProcService iPSSysDBProcService;
    private IPSSysDBProcParamService iPSSysDBProcParamService;
    private IPSSysDBSchemeService iPSSysDBSchemeService;
    private IPSSysDBTableService iPSSysDBTableService;
    private IPSSysDBVFService iPSSysDBVFService;
    private IPSSysDEFTypeService iPSSysDEFTypeService;
    private IPSSysDELogicNodeService iPSSysDELogicNodeService;
    private IPSSysDMItemService iPSSysDMItemService;
    private IPSSysDMVerService iPSSysDMVerService;
    private IPSSysDashboardService iPSSysDashboardService;
    private IPSSysDashboardLogicService iPSSysDashboardLogicService;
    private IPSSysDataSyncAgentService iPSSysDataSyncAgentService;
    private IPSSysDictCatService iPSSysDictCatService;
    private IPSSysDynaModelService iPSSysDynaModelService;
    private IPSSysDynaModelAttrService iPSSysDynaModelAttrService;
    private IPSSysDynaModelCatService iPSSysDynaModelCatService;
    private IPSSysEAIDEService iPSSysEAIDEService;
    private IPSSysEAIDEFieldService iPSSysEAIDEFieldService;
    private IPSSysEAIDERService iPSSysEAIDERService;
    private IPSSysEAIDataTypeService iPSSysEAIDataTypeService;
    private IPSSysEAIDataTypeItemService iPSSysEAIDataTypeItemService;
    private IPSSysEAIElementService iPSSysEAIElementService;
    private IPSSysEAIElementAttrService iPSSysEAIElementAttrService;
    private IPSSysEAIElementREService iPSSysEAIElementREService;
    private IPSSysEAISchemeService iPSSysEAISchemeService;
    private IPSSysERMapService iPSSysERMapService;
    private IPSSysERMapNodeService iPSSysERMapNodeService;
    private IPSSysEditorStyleService iPSSysEditorStyleService;
    private IPSSysImageService iPSSysImageService;
    private IPSSysMapItemService iPSSysMapItemService;
    private IPSSysMapLogicService iPSSysMapLogicService;
    private IPSSysMapViewService iPSSysMapViewService;
    private IPSSysModelGroupService iPSSysModelGroupService;
    private IPSSysMsgQueueService iPSSysMsgQueueService;
    private IPSSysMsgTargetService iPSSysMsgTargetService;
    private IPSSysMsgTemplService iPSSysMsgTemplService;
    private IPSSysOPPrivService iPSSysOPPrivService;
    private IPSSysPDTViewService iPSSysPDTViewService;
    private IPSSysPFPITemplService iPSSysPFPITemplService;
    private IPSSysPFPluginService iPSSysPFPluginService;
    private IPSSysPortletService iPSSysPortletService;
    private IPSSysPortletCatService iPSSysPortletCatService;
    private IPSSysRefService iPSSysRefService;
    private IPSSysReqItemService iPSSysReqItemService;
    private IPSSysReqItemDataService iPSSysReqItemDataService;
    private IPSSysReqItemHisService iPSSysReqItemHisService;
    private IPSSysReqModuleService iPSSysReqModuleService;
    private IPSSysResourceService iPSSysResourceService;
    private IPSSysSAHandlerService iPSSysSAHandlerService;
    private IPSSysSFPITemplService iPSSysSFPITemplService;
    private IPSSysSFPluginService iPSSysSFPluginService;
    private IPSSysSFPubService iPSSysSFPubService;
    private IPSSysSFPubPkgService iPSSysSFPubPkgService;
    private IPSSysSampleValueService iPSSysSampleValueService;
    private IPSSysSearchBarService iPSSysSearchBarService;
    private IPSSysSearchBarItemService iPSSysSearchBarItemService;
    private IPSSysSearchBarLogicService iPSSysSearchBarLogicService;
    private IPSSysSearchDEService iPSSysSearchDEService;
    private IPSSysSearchDEFieldService iPSSysSearchDEFieldService;
    private IPSSysSearchDocService iPSSysSearchDocService;
    private IPSSysSearchFieldService iPSSysSearchFieldService;
    private IPSSysSearchSchemeService iPSSysSearchSchemeService;
    private IPSSysSequenceService iPSSysSequenceService;
    private IPSSysServiceAPIService iPSSysServiceAPIService;
    private IPSSysTCAssertService iPSSysTCAssertService;
    private IPSSysTCInputService iPSSysTCInputService;
    private IPSSysTDItemService iPSSysTDItemService;
    private IPSSysTestCaseService iPSSysTestCaseService;
    private IPSSysTestDataService iPSSysTestDataService;
    private IPSSysTestModuleService iPSSysTestModuleService;
    private IPSSysTestPrjService iPSSysTestPrjService;
    private IPSSysTranslatorService iPSSysTranslatorService;
    private IPSSysUCMapService iPSSysUCMapService;
    private IPSSysUCMapNodeService iPSSysUCMapNodeService;
    private IPSSysUniResService iPSSysUniResService;
    private IPSSysUniStateService iPSSysUniStateService;
    private IPSSysUnitService iPSSysUnitService;
    private IPSSysUserCaseService iPSSysUserCaseService;
    private IPSSysUserCaseRSService iPSSysUserCaseRSService;
    private IPSSysUserDRService iPSSysUserDRService;
    private IPSSysUserModeService iPSSysUserModeService;
    private IPSSysUserRoleDataService iPSSysUserRoleDataService;
    private IPSSysUserRoleResService iPSSysUserRoleResService;
    private IPSSysUtilDEService iPSSysUtilDEService;
    private IPSSysValueRuleService iPSSysValueRuleService;
    private IPSSysViewLogicService iPSSysViewLogicService;
    private IPSSysViewLogicParamService iPSSysViewLogicParamService;
    private IPSSysViewPanelService iPSSysViewPanelService;
    private IPSSysViewPanelItemService iPSSysViewPanelItemService;
    private IPSSysViewPanelLogicService iPSSysViewPanelLogicService;
    private IPSSysViewPanelModelService iPSSysViewPanelModelService;
    private IPSSysWFCatService iPSSysWFCatService;
    private IPSSysWFModeService iPSSysWFModeService;
    private IPSSysWFSettingService iPSSysWFSettingService;
    private IPSSystemDBCfgService iPSSystemDBCfgService;
    private IPSSystemRunService iPSSystemRunService;
    private IPSThresholdService iPSThresholdService;
    private IPSThresholdGroupService iPSThresholdGroupService;
    private IPSViewMsgService iPSViewMsgService;
    private IPSViewMsgGroupService iPSViewMsgGroupService;
    private IPSViewMsgGrpDetailService iPSViewMsgGrpDetailService;
    private IPSWFDEService iPSWFDEService;
    private IPSWFLinkService iPSWFLinkService;
    private IPSWFLinkCondService iPSWFLinkCondService;
    private IPSWFLinkRoleService iPSWFLinkRoleService;
    private IPSWFProcParamService iPSWFProcParamService;
    private IPSWFProcRoleService iPSWFProcRoleService;
    private IPSWFProcSubWFService iPSWFProcSubWFService;
    private IPSWFProcessService iPSWFProcessService;
    private IPSWFRoleService iPSWFRoleService;
    private IPSWFUtilUIActionService iPSWFUtilUIActionService;
    private IPSWFVersionService iPSWFVersionService;
    private IPSWFWorkTimeService iPSWFWorkTimeService;
    private IPSWXAccountService iPSWXAccountService;
    private IPSWXEntAppService iPSWXEntAppService;
    private IPSWXLogicService iPSWXLogicService;
    private IPSWXMenuService iPSWXMenuService;
    private IPSWXMenuFuncService iPSWXMenuFuncService;
    private IPSWXMenuItemService iPSWXMenuItemService;
    private IPSWorkflowService iPSWorkflowService;

    public static PSModelServiceUtil getInstance() {
        return instance;
    }

    public static void setInstance(PSModelServiceUtil psModelServiceUtil) {
        instance = psModelServiceUtil;
    }

    public IPSSystemService getPSSystemService() {
        if (this.iPSSystemService == null) {
            this.iPSSystemService = this.createPSSystemService();
        }
        return this.iPSSystemService;
    }

    protected IPSSystemService createPSSystemService() {
        return new PSSystemServiceImpl();
    }

    public IPSModuleService getPSModuleService() {
        if (this.iPSModuleService == null) {
            this.iPSModuleService = this.createPSModuleService();
        }
        return this.iPSModuleService;
    }

    protected IPSModuleService createPSModuleService() {
        return new PSModuleServiceImpl();
    }

    public IPSDataEntityService getPSDataEntityService() {
        if (this.iPSDataEntityService == null) {
            this.iPSDataEntityService = this.createPSDataEntityService();
        }
        return this.iPSDataEntityService;
    }

    protected IPSDataEntityService createPSDataEntityService() {
        return new PSDataEntityServiceImpl();
    }

    public IPSDEFieldService getPSDEFieldService() {
        if (this.iPSDEFieldService == null) {
            this.iPSDEFieldService = this.createPSDEFieldService();
        }
        return this.iPSDEFieldService;
    }

    protected IPSDEFieldService createPSDEFieldService() {
        return new PSDEFieldServiceImpl();
    }

    public IPSDERService getPSDERService() {
        if (this.iPSDERService == null) {
            this.iPSDERService = this.createPSDERService();
        }
        return this.iPSDERService;
    }

    protected IPSDERService createPSDERService() {
        return new PSDERServiceImpl();
    }

    public IPSACHandlerService getPSACHandlerService() {
        if (this.iPSACHandlerService == null) {
            this.iPSACHandlerService = this.createPSACHandlerService();
        }
        return this.iPSACHandlerService;
    }

    protected IPSACHandlerService createPSACHandlerService() {
        return new PSACHandlerServiceImpl();
    }

    public IPSACHandlerActionService getPSACHandlerActionService() {
        if (this.iPSACHandlerActionService == null) {
            this.iPSACHandlerActionService = this.createPSACHandlerActionService();
        }
        return this.iPSACHandlerActionService;
    }

    protected IPSACHandlerActionService createPSACHandlerActionService() {
        return new PSACHandlerActionServiceImpl();
    }

    public IPSAppDERSService getPSAppDERSService() {
        if (this.iPSAppDERSService == null) {
            this.iPSAppDERSService = this.createPSAppDERSService();
        }
        return this.iPSAppDERSService;
    }

    protected IPSAppDERSService createPSAppDERSService() {
        return new PSAppDERSServiceImpl();
    }

    public IPSAppDEViewService getPSAppDEViewService() {
        if (this.iPSAppDEViewService == null) {
            this.iPSAppDEViewService = this.createPSAppDEViewService();
        }
        return this.iPSAppDEViewService;
    }

    protected IPSAppDEViewService createPSAppDEViewService() {
        return new PSAppDEViewServiceImpl();
    }

    public IPSAppDynaDEViewService getPSAppDynaDEViewService() {
        if (this.iPSAppDynaDEViewService == null) {
            this.iPSAppDynaDEViewService = this.createPSAppDynaDEViewService();
        }
        return this.iPSAppDynaDEViewService;
    }

    protected IPSAppDynaDEViewService createPSAppDynaDEViewService() {
        return new PSAppDynaDEViewServiceImpl();
    }

    public IPSAppFuncService getPSAppFuncService() {
        if (this.iPSAppFuncService == null) {
            this.iPSAppFuncService = this.createPSAppFuncService();
        }
        return this.iPSAppFuncService;
    }

    protected IPSAppFuncService createPSAppFuncService() {
        return new PSAppFuncServiceImpl();
    }

    public IPSAppIndexViewService getPSAppIndexViewService() {
        if (this.iPSAppIndexViewService == null) {
            this.iPSAppIndexViewService = this.createPSAppIndexViewService();
        }
        return this.iPSAppIndexViewService;
    }

    protected IPSAppIndexViewService createPSAppIndexViewService() {
        return new PSAppIndexViewServiceImpl();
    }

    public IPSAppLanService getPSAppLanService() {
        if (this.iPSAppLanService == null) {
            this.iPSAppLanService = this.createPSAppLanService();
        }
        return this.iPSAppLanService;
    }

    protected IPSAppLanService createPSAppLanService() {
        return new PSAppLanServiceImpl();
    }

    public IPSAppLocalDEService getPSAppLocalDEService() {
        if (this.iPSAppLocalDEService == null) {
            this.iPSAppLocalDEService = this.createPSAppLocalDEService();
        }
        return this.iPSAppLocalDEService;
    }

    protected IPSAppLocalDEService createPSAppLocalDEService() {
        return new PSAppLocalDEServiceImpl();
    }

    public IPSAppLogicService getPSAppLogicService() {
        if (this.iPSAppLogicService == null) {
            this.iPSAppLogicService = this.createPSAppLogicService();
        }
        return this.iPSAppLogicService;
    }

    protected IPSAppLogicService createPSAppLogicService() {
        return new PSAppLogicServiceImpl();
    }

    public IPSAppMenuService getPSAppMenuService() {
        if (this.iPSAppMenuService == null) {
            this.iPSAppMenuService = this.createPSAppMenuService();
        }
        return this.iPSAppMenuService;
    }

    protected IPSAppMenuService createPSAppMenuService() {
        return new PSAppMenuServiceImpl();
    }

    public IPSAppMenuItemService getPSAppMenuItemService() {
        if (this.iPSAppMenuItemService == null) {
            this.iPSAppMenuItemService = this.createPSAppMenuItemService();
        }
        return this.iPSAppMenuItemService;
    }

    protected IPSAppMenuItemService createPSAppMenuItemService() {
        return new PSAppMenuItemServiceImpl();
    }

    public IPSAppMenuLogicService getPSAppMenuLogicService() {
        if (this.iPSAppMenuLogicService == null) {
            this.iPSAppMenuLogicService = this.createPSAppMenuLogicService();
        }
        return this.iPSAppMenuLogicService;
    }

    protected IPSAppMenuLogicService createPSAppMenuLogicService() {
        return new PSAppMenuLogicServiceImpl();
    }

    public IPSAppModuleService getPSAppModuleService() {
        if (this.iPSAppModuleService == null) {
            this.iPSAppModuleService = this.createPSAppModuleService();
        }
        return this.iPSAppModuleService;
    }

    protected IPSAppModuleService createPSAppModuleService() {
        return new PSAppModuleServiceImpl();
    }

    public IPSAppPDTViewService getPSAppPDTViewService() {
        if (this.iPSAppPDTViewService == null) {
            this.iPSAppPDTViewService = this.createPSAppPDTViewService();
        }
        return this.iPSAppPDTViewService;
    }

    protected IPSAppPDTViewService createPSAppPDTViewService() {
        return new PSAppPDTViewServiceImpl();
    }

    public IPSAppPVPartService getPSAppPVPartService() {
        if (this.iPSAppPVPartService == null) {
            this.iPSAppPVPartService = this.createPSAppPVPartService();
        }
        return this.iPSAppPVPartService;
    }

    protected IPSAppPVPartService createPSAppPVPartService() {
        return new PSAppPVPartServiceImpl();
    }

    public IPSAppPanelViewService getPSAppPanelViewService() {
        if (this.iPSAppPanelViewService == null) {
            this.iPSAppPanelViewService = this.createPSAppPanelViewService();
        }
        return this.iPSAppPanelViewService;
    }

    protected IPSAppPanelViewService createPSAppPanelViewService() {
        return new PSAppPanelViewServiceImpl();
    }

    public IPSAppPkgService getPSAppPkgService() {
        if (this.iPSAppPkgService == null) {
            this.iPSAppPkgService = this.createPSAppPkgService();
        }
        return this.iPSAppPkgService;
    }

    protected IPSAppPkgService createPSAppPkgService() {
        return new PSAppPkgServiceImpl();
    }

    public IPSAppPortalViewService getPSAppPortalViewService() {
        if (this.iPSAppPortalViewService == null) {
            this.iPSAppPortalViewService = this.createPSAppPortalViewService();
        }
        return this.iPSAppPortalViewService;
    }

    protected IPSAppPortalViewService createPSAppPortalViewService() {
        return new PSAppPortalViewServiceImpl();
    }

    public IPSAppPortletService getPSAppPortletService() {
        if (this.iPSAppPortletService == null) {
            this.iPSAppPortletService = this.createPSAppPortletService();
        }
        return this.iPSAppPortletService;
    }

    protected IPSAppPortletService createPSAppPortletService() {
        return new PSAppPortletServiceImpl();
    }

    public IPSAppResourceService getPSAppResourceService() {
        if (this.iPSAppResourceService == null) {
            this.iPSAppResourceService = this.createPSAppResourceService();
        }
        return this.iPSAppResourceService;
    }

    protected IPSAppResourceService createPSAppResourceService() {
        return new PSAppResourceServiceImpl();
    }

    public IPSAppSBItemService getPSAppSBItemService() {
        if (this.iPSAppSBItemService == null) {
            this.iPSAppSBItemService = this.createPSAppSBItemService();
        }
        return this.iPSAppSBItemService;
    }

    protected IPSAppSBItemService createPSAppSBItemService() {
        return new PSAppSBItemServiceImpl();
    }

    public IPSAppSBItemRSService getPSAppSBItemRSService() {
        if (this.iPSAppSBItemRSService == null) {
            this.iPSAppSBItemRSService = this.createPSAppSBItemRSService();
        }
        return this.iPSAppSBItemRSService;
    }

    protected IPSAppSBItemRSService createPSAppSBItemRSService() {
        return new PSAppSBItemRSServiceImpl();
    }

    public IPSAppStoryBoardService getPSAppStoryBoardService() {
        if (this.iPSAppStoryBoardService == null) {
            this.iPSAppStoryBoardService = this.createPSAppStoryBoardService();
        }
        return this.iPSAppStoryBoardService;
    }

    protected IPSAppStoryBoardService createPSAppStoryBoardService() {
        return new PSAppStoryBoardServiceImpl();
    }

    public IPSAppTitleBarService getPSAppTitleBarService() {
        if (this.iPSAppTitleBarService == null) {
            this.iPSAppTitleBarService = this.createPSAppTitleBarService();
        }
        return this.iPSAppTitleBarService;
    }

    protected IPSAppTitleBarService createPSAppTitleBarService() {
        return new PSAppTitleBarServiceImpl();
    }

    public IPSAppUIStyleService getPSAppUIStyleService() {
        if (this.iPSAppUIStyleService == null) {
            this.iPSAppUIStyleService = this.createPSAppUIStyleService();
        }
        return this.iPSAppUIStyleService;
    }

    protected IPSAppUIStyleService createPSAppUIStyleService() {
        return new PSAppUIStyleServiceImpl();
    }

    public IPSAppUIThemeService getPSAppUIThemeService() {
        if (this.iPSAppUIThemeService == null) {
            this.iPSAppUIThemeService = this.createPSAppUIThemeService();
        }
        return this.iPSAppUIThemeService;
    }

    protected IPSAppUIThemeService createPSAppUIThemeService() {
        return new PSAppUIThemeServiceImpl();
    }

    public IPSAppUserModeService getPSAppUserModeService() {
        if (this.iPSAppUserModeService == null) {
            this.iPSAppUserModeService = this.createPSAppUserModeService();
        }
        return this.iPSAppUserModeService;
    }

    protected IPSAppUserModeService createPSAppUserModeService() {
        return new PSAppUserModeServiceImpl();
    }

    public IPSAppUtilService getPSAppUtilService() {
        if (this.iPSAppUtilService == null) {
            this.iPSAppUtilService = this.createPSAppUtilService();
        }
        return this.iPSAppUtilService;
    }

    protected IPSAppUtilService createPSAppUtilService() {
        return new PSAppUtilServiceImpl();
    }

    public IPSAppUtilPageService getPSAppUtilPageService() {
        if (this.iPSAppUtilPageService == null) {
            this.iPSAppUtilPageService = this.createPSAppUtilPageService();
        }
        return this.iPSAppUtilPageService;
    }

    protected IPSAppUtilPageService createPSAppUtilPageService() {
        return new PSAppUtilPageServiceImpl();
    }

    public IPSAppUtilViewService getPSAppUtilViewService() {
        if (this.iPSAppUtilViewService == null) {
            this.iPSAppUtilViewService = this.createPSAppUtilViewService();
        }
        return this.iPSAppUtilViewService;
    }

    protected IPSAppUtilViewService createPSAppUtilViewService() {
        return new PSAppUtilViewServiceImpl();
    }

    public IPSAppViewServiceProxy getPSAppViewService() {
        if (this.iPSAppViewService == null) {
            this.iPSAppViewService = this.createPSAppViewService();
        }
        return this.iPSAppViewService;
    }

    protected IPSAppViewServiceProxy createPSAppViewService() {
        return new PSAppViewServiceProxyImpl();
    }

    public IPSAppWFService getPSAppWFService() {
        if (this.iPSAppWFService == null) {
            this.iPSAppWFService = this.createPSAppWFService();
        }
        return this.iPSAppWFService;
    }

    protected IPSAppWFService createPSAppWFService() {
        return new PSAppWFServiceImpl();
    }

    public IPSAppWFVerService getPSAppWFVerService() {
        if (this.iPSAppWFVerService == null) {
            this.iPSAppWFVerService = this.createPSAppWFVerService();
        }
        return this.iPSAppWFVerService;
    }

    protected IPSAppWFVerService createPSAppWFVerService() {
        return new PSAppWFVerServiceImpl();
    }

    public IPSCodeItemService getPSCodeItemService() {
        if (this.iPSCodeItemService == null) {
            this.iPSCodeItemService = this.createPSCodeItemService();
        }
        return this.iPSCodeItemService;
    }

    protected IPSCodeItemService createPSCodeItemService() {
        return new PSCodeItemServiceImpl();
    }

    public IPSCodeListService getPSCodeListService() {
        if (this.iPSCodeListService == null) {
            this.iPSCodeListService = this.createPSCodeListService();
        }
        return this.iPSCodeListService;
    }

    protected IPSCodeListService createPSCodeListService() {
        return new PSCodeListServiceImpl();
    }

    public IPSCtrlLogicGroupService getPSCtrlLogicGroupService() {
        if (this.iPSCtrlLogicGroupService == null) {
            this.iPSCtrlLogicGroupService = this.createPSCtrlLogicGroupService();
        }
        return this.iPSCtrlLogicGroupService;
    }

    protected IPSCtrlLogicGroupService createPSCtrlLogicGroupService() {
        return new PSCtrlLogicGroupServiceImpl();
    }

    public IPSCtrlLogicGrpDetailService getPSCtrlLogicGrpDetailService() {
        if (this.iPSCtrlLogicGrpDetailService == null) {
            this.iPSCtrlLogicGrpDetailService = this.createPSCtrlLogicGrpDetailService();
        }
        return this.iPSCtrlLogicGrpDetailService;
    }

    protected IPSCtrlLogicGrpDetailService createPSCtrlLogicGrpDetailService() {
        return new PSCtrlLogicGrpDetailServiceImpl();
    }

    public IPSCtrlMsgService getPSCtrlMsgService() {
        if (this.iPSCtrlMsgService == null) {
            this.iPSCtrlMsgService = this.createPSCtrlMsgService();
        }
        return this.iPSCtrlMsgService;
    }

    protected IPSCtrlMsgService createPSCtrlMsgService() {
        return new PSCtrlMsgServiceImpl();
    }

    public IPSCtrlMsgItemService getPSCtrlMsgItemService() {
        if (this.iPSCtrlMsgItemService == null) {
            this.iPSCtrlMsgItemService = this.createPSCtrlMsgItemService();
        }
        return this.iPSCtrlMsgItemService;
    }

    protected IPSCtrlMsgItemService createPSCtrlMsgItemService() {
        return new PSCtrlMsgItemServiceImpl();
    }

    public IPSDEACModeService getPSDEACModeService() {
        if (this.iPSDEACModeService == null) {
            this.iPSDEACModeService = this.createPSDEACModeService();
        }
        return this.iPSDEACModeService;
    }

    protected IPSDEACModeService createPSDEACModeService() {
        return new PSDEACModeServiceImpl();
    }

    public IPSDEACModeItemService getPSDEACModeItemService() {
        if (this.iPSDEACModeItemService == null) {
            this.iPSDEACModeItemService = this.createPSDEACModeItemService();
        }
        return this.iPSDEACModeItemService;
    }

    protected IPSDEACModeItemService createPSDEACModeItemService() {
        return new PSDEACModeItemServiceImpl();
    }

    public IPSDEAGDetailService getPSDEAGDetailService() {
        if (this.iPSDEAGDetailService == null) {
            this.iPSDEAGDetailService = this.createPSDEAGDetailService();
        }
        return this.iPSDEAGDetailService;
    }

    protected IPSDEAGDetailService createPSDEAGDetailService() {
        return new PSDEAGDetailServiceImpl();
    }

    public IPSDEActionService getPSDEActionService() {
        if (this.iPSDEActionService == null) {
            this.iPSDEActionService = this.createPSDEActionService();
        }
        return this.iPSDEActionService;
    }

    protected IPSDEActionService createPSDEActionService() {
        return new PSDEActionServiceImpl();
    }

    public IPSDEActionGroupService getPSDEActionGroupService() {
        if (this.iPSDEActionGroupService == null) {
            this.iPSDEActionGroupService = this.createPSDEActionGroupService();
        }
        return this.iPSDEActionGroupService;
    }

    protected IPSDEActionGroupService createPSDEActionGroupService() {
        return new PSDEActionGroupServiceImpl();
    }

    public IPSDEActionLogicService getPSDEActionLogicService() {
        if (this.iPSDEActionLogicService == null) {
            this.iPSDEActionLogicService = this.createPSDEActionLogicService();
        }
        return this.iPSDEActionLogicService;
    }

    protected IPSDEActionLogicService createPSDEActionLogicService() {
        return new PSDEActionLogicServiceImpl();
    }

    public IPSDEActionParamService getPSDEActionParamService() {
        if (this.iPSDEActionParamService == null) {
            this.iPSDEActionParamService = this.createPSDEActionParamService();
        }
        return this.iPSDEActionParamService;
    }

    protected IPSDEActionParamService createPSDEActionParamService() {
        return new PSDEActionParamServiceImpl();
    }

    public IPSDEActionTemplService getPSDEActionTemplService() {
        if (this.iPSDEActionTemplService == null) {
            this.iPSDEActionTemplService = this.createPSDEActionTemplService();
        }
        return this.iPSDEActionTemplService;
    }

    protected IPSDEActionTemplService createPSDEActionTemplService() {
        return new PSDEActionTemplServiceImpl();
    }

    public IPSDEActionVRService getPSDEActionVRService() {
        if (this.iPSDEActionVRService == null) {
            this.iPSDEActionVRService = this.createPSDEActionVRService();
        }
        return this.iPSDEActionVRService;
    }

    protected IPSDEActionVRService createPSDEActionVRService() {
        return new PSDEActionVRServiceImpl();
    }

    public IPSDEChartService getPSDEChartService() {
        if (this.iPSDEChartService == null) {
            this.iPSDEChartService = this.createPSDEChartService();
        }
        return this.iPSDEChartService;
    }

    protected IPSDEChartService createPSDEChartService() {
        return new PSDEChartServiceImpl();
    }

    public IPSDEChartAxesService getPSDEChartAxesService() {
        if (this.iPSDEChartAxesService == null) {
            this.iPSDEChartAxesService = this.createPSDEChartAxesService();
        }
        return this.iPSDEChartAxesService;
    }

    protected IPSDEChartAxesService createPSDEChartAxesService() {
        return new PSDEChartAxesServiceImpl();
    }

    public IPSDEChartLogicService getPSDEChartLogicService() {
        if (this.iPSDEChartLogicService == null) {
            this.iPSDEChartLogicService = this.createPSDEChartLogicService();
        }
        return this.iPSDEChartLogicService;
    }

    protected IPSDEChartLogicService createPSDEChartLogicService() {
        return new PSDEChartLogicServiceImpl();
    }

    public IPSDEChartParamService getPSDEChartParamService() {
        if (this.iPSDEChartParamService == null) {
            this.iPSDEChartParamService = this.createPSDEChartParamService();
        }
        return this.iPSDEChartParamService;
    }

    protected IPSDEChartParamService createPSDEChartParamService() {
        return new PSDEChartParamServiceImpl();
    }

    public IPSDEDBCfgService getPSDEDBCfgService() {
        if (this.iPSDEDBCfgService == null) {
            this.iPSDEDBCfgService = this.createPSDEDBCfgService();
        }
        return this.iPSDEDBCfgService;
    }

    protected IPSDEDBCfgService createPSDEDBCfgService() {
        return new PSDEDBCfgServiceImpl();
    }

    public IPSDEDBIdxFieldService getPSDEDBIdxFieldService() {
        if (this.iPSDEDBIdxFieldService == null) {
            this.iPSDEDBIdxFieldService = this.createPSDEDBIdxFieldService();
        }
        return this.iPSDEDBIdxFieldService;
    }

    protected IPSDEDBIdxFieldService createPSDEDBIdxFieldService() {
        return new PSDEDBIdxFieldServiceImpl();
    }

    public IPSDEDBIndexService getPSDEDBIndexService() {
        if (this.iPSDEDBIndexService == null) {
            this.iPSDEDBIndexService = this.createPSDEDBIndexService();
        }
        return this.iPSDEDBIndexService;
    }

    protected IPSDEDBIndexService createPSDEDBIndexService() {
        return new PSDEDBIndexServiceImpl();
    }

    public IPSDEDQCodeService getPSDEDQCodeService() {
        if (this.iPSDEDQCodeService == null) {
            this.iPSDEDQCodeService = this.createPSDEDQCodeService();
        }
        return this.iPSDEDQCodeService;
    }

    protected IPSDEDQCodeService createPSDEDQCodeService() {
        return new PSDEDQCodeServiceImpl();
    }

    public IPSDEDQCodeCondService getPSDEDQCodeCondService() {
        if (this.iPSDEDQCodeCondService == null) {
            this.iPSDEDQCodeCondService = this.createPSDEDQCodeCondService();
        }
        return this.iPSDEDQCodeCondService;
    }

    protected IPSDEDQCodeCondService createPSDEDQCodeCondService() {
        return new PSDEDQCodeCondServiceImpl();
    }

    public IPSDEDQCodeExpService getPSDEDQCodeExpService() {
        if (this.iPSDEDQCodeExpService == null) {
            this.iPSDEDQCodeExpService = this.createPSDEDQCodeExpService();
        }
        return this.iPSDEDQCodeExpService;
    }

    protected IPSDEDQCodeExpService createPSDEDQCodeExpService() {
        return new PSDEDQCodeExpServiceImpl();
    }

    public IPSDEDQCondService getPSDEDQCondService() {
        if (this.iPSDEDQCondService == null) {
            this.iPSDEDQCondService = this.createPSDEDQCondService();
        }
        return this.iPSDEDQCondService;
    }

    protected IPSDEDQCondService createPSDEDQCondService() {
        return new PSDEDQCondServiceImpl();
    }

    public IPSDEDQJoinService getPSDEDQJoinService() {
        if (this.iPSDEDQJoinService == null) {
            this.iPSDEDQJoinService = this.createPSDEDQJoinService();
        }
        return this.iPSDEDQJoinService;
    }

    protected IPSDEDQJoinService createPSDEDQJoinService() {
        return new PSDEDQJoinServiceImpl();
    }

    public IPSDEDRDetailService getPSDEDRDetailService() {
        if (this.iPSDEDRDetailService == null) {
            this.iPSDEDRDetailService = this.createPSDEDRDetailService();
        }
        return this.iPSDEDRDetailService;
    }

    protected IPSDEDRDetailService createPSDEDRDetailService() {
        return new PSDEDRDetailServiceImpl();
    }

    public IPSDEDRGroupService getPSDEDRGroupService() {
        if (this.iPSDEDRGroupService == null) {
            this.iPSDEDRGroupService = this.createPSDEDRGroupService();
        }
        return this.iPSDEDRGroupService;
    }

    protected IPSDEDRGroupService createPSDEDRGroupService() {
        return new PSDEDRGroupServiceImpl();
    }

    public IPSDEDRItemService getPSDEDRItemService() {
        if (this.iPSDEDRItemService == null) {
            this.iPSDEDRItemService = this.createPSDEDRItemService();
        }
        return this.iPSDEDRItemService;
    }

    protected IPSDEDRItemService createPSDEDRItemService() {
        return new PSDEDRItemServiceImpl();
    }

    public IPSDEDSDQService getPSDEDSDQService() {
        if (this.iPSDEDSDQService == null) {
            this.iPSDEDSDQService = this.createPSDEDSDQService();
        }
        return this.iPSDEDSDQService;
    }

    protected IPSDEDSDQService createPSDEDSDQService() {
        return new PSDEDSDQServiceImpl();
    }

    public IPSDEDSGrpParamService getPSDEDSGrpParamService() {
        if (this.iPSDEDSGrpParamService == null) {
            this.iPSDEDSGrpParamService = this.createPSDEDSGrpParamService();
        }
        return this.iPSDEDSGrpParamService;
    }

    protected IPSDEDSGrpParamService createPSDEDSGrpParamService() {
        return new PSDEDSGrpParamServiceImpl();
    }

    public IPSDEDSParamService getPSDEDSParamService() {
        if (this.iPSDEDSParamService == null) {
            this.iPSDEDSParamService = this.createPSDEDSParamService();
        }
        return this.iPSDEDSParamService;
    }

    protected IPSDEDSParamService createPSDEDSParamService() {
        return new PSDEDSParamServiceImpl();
    }

    public IPSDEDTSQueueService getPSDEDTSQueueService() {
        if (this.iPSDEDTSQueueService == null) {
            this.iPSDEDTSQueueService = this.createPSDEDTSQueueService();
        }
        return this.iPSDEDTSQueueService;
    }

    protected IPSDEDTSQueueService createPSDEDTSQueueService() {
        return new PSDEDTSQueueServiceImpl();
    }

    public IPSDEDataExpService getPSDEDataExpService() {
        if (this.iPSDEDataExpService == null) {
            this.iPSDEDataExpService = this.createPSDEDataExpService();
        }
        return this.iPSDEDataExpService;
    }

    protected IPSDEDataExpService createPSDEDataExpService() {
        return new PSDEDataExpServiceImpl();
    }

    public IPSDEDataImpService getPSDEDataImpService() {
        if (this.iPSDEDataImpService == null) {
            this.iPSDEDataImpService = this.createPSDEDataImpService();
        }
        return this.iPSDEDataImpService;
    }

    protected IPSDEDataImpService createPSDEDataImpService() {
        return new PSDEDataImpServiceImpl();
    }

    public IPSDEDataImpItemService getPSDEDataImpItemService() {
        if (this.iPSDEDataImpItemService == null) {
            this.iPSDEDataImpItemService = this.createPSDEDataImpItemService();
        }
        return this.iPSDEDataImpItemService;
    }

    protected IPSDEDataImpItemService createPSDEDataImpItemService() {
        return new PSDEDataImpItemServiceImpl();
    }

    public IPSDEDataQueryService getPSDEDataQueryService() {
        if (this.iPSDEDataQueryService == null) {
            this.iPSDEDataQueryService = this.createPSDEDataQueryService();
        }
        return this.iPSDEDataQueryService;
    }

    protected IPSDEDataQueryService createPSDEDataQueryService() {
        return new PSDEDataQueryServiceImpl();
    }

    public IPSDEDataRelationService getPSDEDataRelationService() {
        if (this.iPSDEDataRelationService == null) {
            this.iPSDEDataRelationService = this.createPSDEDataRelationService();
        }
        return this.iPSDEDataRelationService;
    }

    protected IPSDEDataRelationService createPSDEDataRelationService() {
        return new PSDEDataRelationServiceImpl();
    }

    public IPSDEDataSetService getPSDEDataSetService() {
        if (this.iPSDEDataSetService == null) {
            this.iPSDEDataSetService = this.createPSDEDataSetService();
        }
        return this.iPSDEDataSetService;
    }

    protected IPSDEDataSetService createPSDEDataSetService() {
        return new PSDEDataSetServiceImpl();
    }

    public IPSDEDataSyncService getPSDEDataSyncService() {
        if (this.iPSDEDataSyncService == null) {
            this.iPSDEDataSyncService = this.createPSDEDataSyncService();
        }
        return this.iPSDEDataSyncService;
    }

    protected IPSDEDataSyncService createPSDEDataSyncService() {
        return new PSDEDataSyncServiceImpl();
    }

    public IPSDEDataViewService getPSDEDataViewService() {
        if (this.iPSDEDataViewService == null) {
            this.iPSDEDataViewService = this.createPSDEDataViewService();
        }
        return this.iPSDEDataViewService;
    }

    protected IPSDEDataViewService createPSDEDataViewService() {
        return new PSDEDataViewServiceImpl();
    }

    public IPSDEDataViewLogicService getPSDEDataViewLogicService() {
        if (this.iPSDEDataViewLogicService == null) {
            this.iPSDEDataViewLogicService = this.createPSDEDataViewLogicService();
        }
        return this.iPSDEDataViewLogicService;
    }

    protected IPSDEDataViewLogicService createPSDEDataViewLogicService() {
        return new PSDEDataViewLogicServiceImpl();
    }

    public IPSDEFDLogicService getPSDEFDLogicService() {
        if (this.iPSDEFDLogicService == null) {
            this.iPSDEFDLogicService = this.createPSDEFDLogicService();
        }
        return this.iPSDEFDLogicService;
    }

    protected IPSDEFDLogicService createPSDEFDLogicService() {
        return new PSDEFDLogicServiceImpl();
    }

    public IPSDEFDTColService getPSDEFDTColService() {
        if (this.iPSDEFDTColService == null) {
            this.iPSDEFDTColService = this.createPSDEFDTColService();
        }
        return this.iPSDEFDTColService;
    }

    protected IPSDEFDTColService createPSDEFDTColService() {
        return new PSDEFDTColServiceImpl();
    }

    public IPSDEFGroupService getPSDEFGroupService() {
        if (this.iPSDEFGroupService == null) {
            this.iPSDEFGroupService = this.createPSDEFGroupService();
        }
        return this.iPSDEFGroupService;
    }

    protected IPSDEFGroupService createPSDEFGroupService() {
        return new PSDEFGroupServiceImpl();
    }

    public IPSDEFGroupDetailService getPSDEFGroupDetailService() {
        if (this.iPSDEFGroupDetailService == null) {
            this.iPSDEFGroupDetailService = this.createPSDEFGroupDetailService();
        }
        return this.iPSDEFGroupDetailService;
    }

    protected IPSDEFGroupDetailService createPSDEFGroupDetailService() {
        return new PSDEFGroupDetailServiceImpl();
    }

    public IPSDEFIUDetailService getPSDEFIUDetailService() {
        if (this.iPSDEFIUDetailService == null) {
            this.iPSDEFIUDetailService = this.createPSDEFIUDetailService();
        }
        return this.iPSDEFIUDetailService;
    }

    protected IPSDEFIUDetailService createPSDEFIUDetailService() {
        return new PSDEFIUDetailServiceImpl();
    }

    public IPSDEFIUpdateService getPSDEFIUpdateService() {
        if (this.iPSDEFIUpdateService == null) {
            this.iPSDEFIUpdateService = this.createPSDEFIUpdateService();
        }
        return this.iPSDEFIUpdateService;
    }

    protected IPSDEFIUpdateService createPSDEFIUpdateService() {
        return new PSDEFIUpdateServiceImpl();
    }

    public IPSDEFIVRService getPSDEFIVRService() {
        if (this.iPSDEFIVRService == null) {
            this.iPSDEFIVRService = this.createPSDEFIVRService();
        }
        return this.iPSDEFIVRService;
    }

    protected IPSDEFIVRService createPSDEFIVRService() {
        return new PSDEFIVRServiceImpl();
    }

    public IPSDEFInputTipService getPSDEFInputTipService() {
        if (this.iPSDEFInputTipService == null) {
            this.iPSDEFInputTipService = this.createPSDEFInputTipService();
        }
        return this.iPSDEFInputTipService;
    }

    protected IPSDEFInputTipService createPSDEFInputTipService() {
        return new PSDEFInputTipServiceImpl();
    }

    public IPSDEFInputTipSetService getPSDEFInputTipSetService() {
        if (this.iPSDEFInputTipSetService == null) {
            this.iPSDEFInputTipSetService = this.createPSDEFInputTipSetService();
        }
        return this.iPSDEFInputTipSetService;
    }

    protected IPSDEFInputTipSetService createPSDEFInputTipSetService() {
        return new PSDEFInputTipSetServiceImpl();
    }

    public IPSDEFSFItemService getPSDEFSFItemService() {
        if (this.iPSDEFSFItemService == null) {
            this.iPSDEFSFItemService = this.createPSDEFSFItemService();
        }
        return this.iPSDEFSFItemService;
    }

    protected IPSDEFSFItemService createPSDEFSFItemService() {
        return new PSDEFSFItemServiceImpl();
    }

    public IPSDEFUIModeService getPSDEFUIModeService() {
        if (this.iPSDEFUIModeService == null) {
            this.iPSDEFUIModeService = this.createPSDEFUIModeService();
        }
        return this.iPSDEFUIModeService;
    }

    protected IPSDEFUIModeService createPSDEFUIModeService() {
        return new PSDEFUIModeServiceImpl();
    }

    public IPSDEFVRCondService getPSDEFVRCondService() {
        if (this.iPSDEFVRCondService == null) {
            this.iPSDEFVRCondService = this.createPSDEFVRCondService();
        }
        return this.iPSDEFVRCondService;
    }

    protected IPSDEFVRCondService createPSDEFVRCondService() {
        return new PSDEFVRCondServiceImpl();
    }

    public IPSDEFValueRuleService getPSDEFValueRuleService() {
        if (this.iPSDEFValueRuleService == null) {
            this.iPSDEFValueRuleService = this.createPSDEFValueRuleService();
        }
        return this.iPSDEFValueRuleService;
    }

    protected IPSDEFValueRuleService createPSDEFValueRuleService() {
        return new PSDEFValueRuleServiceImpl();
    }

    public IPSDEFormService getPSDEFormService() {
        if (this.iPSDEFormService == null) {
            this.iPSDEFormService = this.createPSDEFormService();
        }
        return this.iPSDEFormService;
    }

    protected IPSDEFormService createPSDEFormService() {
        return new PSDEFormServiceImpl();
    }

    public IPSDEFormDetailService getPSDEFormDetailService() {
        if (this.iPSDEFormDetailService == null) {
            this.iPSDEFormDetailService = this.createPSDEFormDetailService();
        }
        return this.iPSDEFormDetailService;
    }

    protected IPSDEFormDetailService createPSDEFormDetailService() {
        return new PSDEFormDetailServiceImpl();
    }

    public IPSDEFormLogicService getPSDEFormLogicService() {
        if (this.iPSDEFormLogicService == null) {
            this.iPSDEFormLogicService = this.createPSDEFormLogicService();
        }
        return this.iPSDEFormLogicService;
    }

    protected IPSDEFormLogicService createPSDEFormLogicService() {
        return new PSDEFormLogicServiceImpl();
    }

    public IPSDEFormRFService getPSDEFormRFService() {
        if (this.iPSDEFormRFService == null) {
            this.iPSDEFormRFService = this.createPSDEFormRFService();
        }
        return this.iPSDEFormRFService;
    }

    protected IPSDEFormRFService createPSDEFormRFService() {
        return new PSDEFormRFServiceImpl();
    }

    public IPSDEGEIUDetailService getPSDEGEIUDetailService() {
        if (this.iPSDEGEIUDetailService == null) {
            this.iPSDEGEIUDetailService = this.createPSDEGEIUDetailService();
        }
        return this.iPSDEGEIUDetailService;
    }

    protected IPSDEGEIUDetailService createPSDEGEIUDetailService() {
        return new PSDEGEIUDetailServiceImpl();
    }

    public IPSDEGEIUpdateService getPSDEGEIUpdateService() {
        if (this.iPSDEGEIUpdateService == null) {
            this.iPSDEGEIUpdateService = this.createPSDEGEIUpdateService();
        }
        return this.iPSDEGEIUpdateService;
    }

    protected IPSDEGEIUpdateService createPSDEGEIUpdateService() {
        return new PSDEGEIUpdateServiceImpl();
    }

    public IPSDEGEIVRService getPSDEGEIVRService() {
        if (this.iPSDEGEIVRService == null) {
            this.iPSDEGEIVRService = this.createPSDEGEIVRService();
        }
        return this.iPSDEGEIVRService;
    }

    protected IPSDEGEIVRService createPSDEGEIVRService() {
        return new PSDEGEIVRServiceImpl();
    }

    public IPSDEGridService getPSDEGridService() {
        if (this.iPSDEGridService == null) {
            this.iPSDEGridService = this.createPSDEGridService();
        }
        return this.iPSDEGridService;
    }

    protected IPSDEGridService createPSDEGridService() {
        return new PSDEGridServiceImpl();
    }

    public IPSDEGridColService getPSDEGridColService() {
        if (this.iPSDEGridColService == null) {
            this.iPSDEGridColService = this.createPSDEGridColService();
        }
        return this.iPSDEGridColService;
    }

    protected IPSDEGridColService createPSDEGridColService() {
        return new PSDEGridColServiceImpl();
    }

    public IPSDEGridLogicService getPSDEGridLogicService() {
        if (this.iPSDEGridLogicService == null) {
            this.iPSDEGridLogicService = this.createPSDEGridLogicService();
        }
        return this.iPSDEGridLogicService;
    }

    protected IPSDEGridLogicService createPSDEGridLogicService() {
        return new PSDEGridLogicServiceImpl();
    }

    public IPSDEGroupService getPSDEGroupService() {
        if (this.iPSDEGroupService == null) {
            this.iPSDEGroupService = this.createPSDEGroupService();
        }
        return this.iPSDEGroupService;
    }

    protected IPSDEGroupService createPSDEGroupService() {
        return new PSDEGroupServiceImpl();
    }

    public IPSDEGroupDetailService getPSDEGroupDetailService() {
        if (this.iPSDEGroupDetailService == null) {
            this.iPSDEGroupDetailService = this.createPSDEGroupDetailService();
        }
        return this.iPSDEGroupDetailService;
    }

    protected IPSDEGroupDetailService createPSDEGroupDetailService() {
        return new PSDEGroupDetailServiceImpl();
    }

    public IPSDELLCondService getPSDELLCondService() {
        if (this.iPSDELLCondService == null) {
            this.iPSDELLCondService = this.createPSDELLCondService();
        }
        return this.iPSDELLCondService;
    }

    protected IPSDELLCondService createPSDELLCondService() {
        return new PSDELLCondServiceImpl();
    }

    public IPSDELNParamService getPSDELNParamService() {
        if (this.iPSDELNParamService == null) {
            this.iPSDELNParamService = this.createPSDELNParamService();
        }
        return this.iPSDELNParamService;
    }

    protected IPSDELNParamService createPSDELNParamService() {
        return new PSDELNParamServiceImpl();
    }

    public IPSDEListService getPSDEListService() {
        if (this.iPSDEListService == null) {
            this.iPSDEListService = this.createPSDEListService();
        }
        return this.iPSDEListService;
    }

    protected IPSDEListService createPSDEListService() {
        return new PSDEListServiceImpl();
    }

    public IPSDEListItemService getPSDEListItemService() {
        if (this.iPSDEListItemService == null) {
            this.iPSDEListItemService = this.createPSDEListItemService();
        }
        return this.iPSDEListItemService;
    }

    protected IPSDEListItemService createPSDEListItemService() {
        return new PSDEListItemServiceImpl();
    }

    public IPSDEListLogicService getPSDEListLogicService() {
        if (this.iPSDEListLogicService == null) {
            this.iPSDEListLogicService = this.createPSDEListLogicService();
        }
        return this.iPSDEListLogicService;
    }

    protected IPSDEListLogicService createPSDEListLogicService() {
        return new PSDEListLogicServiceImpl();
    }

    public IPSDELogicService getPSDELogicService() {
        if (this.iPSDELogicService == null) {
            this.iPSDELogicService = this.createPSDELogicService();
        }
        return this.iPSDELogicService;
    }

    protected IPSDELogicService createPSDELogicService() {
        return new PSDELogicServiceImpl();
    }

    public IPSDELogicLinkService getPSDELogicLinkService() {
        if (this.iPSDELogicLinkService == null) {
            this.iPSDELogicLinkService = this.createPSDELogicLinkService();
        }
        return this.iPSDELogicLinkService;
    }

    protected IPSDELogicLinkService createPSDELogicLinkService() {
        return new PSDELogicLinkServiceImpl();
    }

    public IPSDELogicNodeService getPSDELogicNodeService() {
        if (this.iPSDELogicNodeService == null) {
            this.iPSDELogicNodeService = this.createPSDELogicNodeService();
        }
        return this.iPSDELogicNodeService;
    }

    protected IPSDELogicNodeService createPSDELogicNodeService() {
        return new PSDELogicNodeServiceImpl();
    }

    public IPSDELogicParamService getPSDELogicParamService() {
        if (this.iPSDELogicParamService == null) {
            this.iPSDELogicParamService = this.createPSDELogicParamService();
        }
        return this.iPSDELogicParamService;
    }

    protected IPSDELogicParamService createPSDELogicParamService() {
        return new PSDELogicParamServiceImpl();
    }

    public IPSDEMSActionService getPSDEMSActionService() {
        if (this.iPSDEMSActionService == null) {
            this.iPSDEMSActionService = this.createPSDEMSActionService();
        }
        return this.iPSDEMSActionService;
    }

    protected IPSDEMSActionService createPSDEMSActionService() {
        return new PSDEMSActionServiceImpl();
    }

    public IPSDEMSOPPrivService getPSDEMSOPPrivService() {
        if (this.iPSDEMSOPPrivService == null) {
            this.iPSDEMSOPPrivService = this.createPSDEMSOPPrivService();
        }
        return this.iPSDEMSOPPrivService;
    }

    protected IPSDEMSOPPrivService createPSDEMSOPPrivService() {
        return new PSDEMSOPPrivServiceImpl();
    }

    public IPSDEMainStateService getPSDEMainStateService() {
        if (this.iPSDEMainStateService == null) {
            this.iPSDEMainStateService = this.createPSDEMainStateService();
        }
        return this.iPSDEMainStateService;
    }

    protected IPSDEMainStateService createPSDEMainStateService() {
        return new PSDEMainStateServiceImpl();
    }

    public IPSDEMainStateRSService getPSDEMainStateRSService() {
        if (this.iPSDEMainStateRSService == null) {
            this.iPSDEMainStateRSService = this.createPSDEMainStateRSService();
        }
        return this.iPSDEMainStateRSService;
    }

    protected IPSDEMainStateRSService createPSDEMainStateRSService() {
        return new PSDEMainStateRSServiceImpl();
    }

    public IPSDEMapService getPSDEMapService() {
        if (this.iPSDEMapService == null) {
            this.iPSDEMapService = this.createPSDEMapService();
        }
        return this.iPSDEMapService;
    }

    protected IPSDEMapService createPSDEMapService() {
        return new PSDEMapServiceImpl();
    }

    public IPSDEMapActionService getPSDEMapActionService() {
        if (this.iPSDEMapActionService == null) {
            this.iPSDEMapActionService = this.createPSDEMapActionService();
        }
        return this.iPSDEMapActionService;
    }

    protected IPSDEMapActionService createPSDEMapActionService() {
        return new PSDEMapActionServiceImpl();
    }

    public IPSDEMapDQService getPSDEMapDQService() {
        if (this.iPSDEMapDQService == null) {
            this.iPSDEMapDQService = this.createPSDEMapDQService();
        }
        return this.iPSDEMapDQService;
    }

    protected IPSDEMapDQService createPSDEMapDQService() {
        return new PSDEMapDQServiceImpl();
    }

    public IPSDEMapDSService getPSDEMapDSService() {
        if (this.iPSDEMapDSService == null) {
            this.iPSDEMapDSService = this.createPSDEMapDSService();
        }
        return this.iPSDEMapDSService;
    }

    protected IPSDEMapDSService createPSDEMapDSService() {
        return new PSDEMapDSServiceImpl();
    }

    public IPSDEMapDetailService getPSDEMapDetailService() {
        if (this.iPSDEMapDetailService == null) {
            this.iPSDEMapDetailService = this.createPSDEMapDetailService();
        }
        return this.iPSDEMapDetailService;
    }

    protected IPSDEMapDetailService createPSDEMapDetailService() {
        return new PSDEMapDetailServiceImpl();
    }

    public IPSDENotifyService getPSDENotifyService() {
        if (this.iPSDENotifyService == null) {
            this.iPSDENotifyService = this.createPSDENotifyService();
        }
        return this.iPSDENotifyService;
    }

    protected IPSDENotifyService createPSDENotifyService() {
        return new PSDENotifyServiceImpl();
    }

    public IPSDENotifyTargetService getPSDENotifyTargetService() {
        if (this.iPSDENotifyTargetService == null) {
            this.iPSDENotifyTargetService = this.createPSDENotifyTargetService();
        }
        return this.iPSDENotifyTargetService;
    }

    protected IPSDENotifyTargetService createPSDENotifyTargetService() {
        return new PSDENotifyTargetServiceImpl();
    }

    public IPSDEOPPrivService getPSDEOPPrivService() {
        if (this.iPSDEOPPrivService == null) {
            this.iPSDEOPPrivService = this.createPSDEOPPrivService();
        }
        return this.iPSDEOPPrivService;
    }

    protected IPSDEOPPrivService createPSDEOPPrivService() {
        return new PSDEOPPrivServiceImpl();
    }

    public IPSDEOPPrivRoleService getPSDEOPPrivRoleService() {
        if (this.iPSDEOPPrivRoleService == null) {
            this.iPSDEOPPrivRoleService = this.createPSDEOPPrivRoleService();
        }
        return this.iPSDEOPPrivRoleService;
    }

    protected IPSDEOPPrivRoleService createPSDEOPPrivRoleService() {
        return new PSDEOPPrivRoleServiceImpl();
    }

    public IPSDEPrintService getPSDEPrintService() {
        if (this.iPSDEPrintService == null) {
            this.iPSDEPrintService = this.createPSDEPrintService();
        }
        return this.iPSDEPrintService;
    }

    protected IPSDEPrintService createPSDEPrintService() {
        return new PSDEPrintServiceImpl();
    }

    public IPSDERDEFMapService getPSDERDEFMapService() {
        if (this.iPSDERDEFMapService == null) {
            this.iPSDERDEFMapService = this.createPSDERDEFMapService();
        }
        return this.iPSDERDEFMapService;
    }

    protected IPSDERDEFMapService createPSDERDEFMapService() {
        return new PSDERDEFMapServiceImpl();
    }

    public IPSDERGroupService getPSDERGroupService() {
        if (this.iPSDERGroupService == null) {
            this.iPSDERGroupService = this.createPSDERGroupService();
        }
        return this.iPSDERGroupService;
    }

    protected IPSDERGroupService createPSDERGroupService() {
        return new PSDERGroupServiceImpl();
    }

    public IPSDERGroupDetailService getPSDERGroupDetailService() {
        if (this.iPSDERGroupDetailService == null) {
            this.iPSDERGroupDetailService = this.createPSDERGroupDetailService();
        }
        return this.iPSDERGroupDetailService;
    }

    protected IPSDERGroupDetailService createPSDERGroupDetailService() {
        return new PSDERGroupDetailServiceImpl();
    }

    public IPSDERepItemService getPSDERepItemService() {
        if (this.iPSDERepItemService == null) {
            this.iPSDERepItemService = this.createPSDERepItemService();
        }
        return this.iPSDERepItemService;
    }

    protected IPSDERepItemService createPSDERepItemService() {
        return new PSDERepItemServiceImpl();
    }

    public IPSDEReportService getPSDEReportService() {
        if (this.iPSDEReportService == null) {
            this.iPSDEReportService = this.createPSDEReportService();
        }
        return this.iPSDEReportService;
    }

    protected IPSDEReportService createPSDEReportService() {
        return new PSDEReportServiceImpl();
    }

    public IPSDESADetailService getPSDESADetailService() {
        if (this.iPSDESADetailService == null) {
            this.iPSDESADetailService = this.createPSDESADetailService();
        }
        return this.iPSDESADetailService;
    }

    protected IPSDESADetailService createPSDESADetailService() {
        return new PSDESADetailServiceImpl();
    }

    public IPSDESADetailParamService getPSDESADetailParamService() {
        if (this.iPSDESADetailParamService == null) {
            this.iPSDESADetailParamService = this.createPSDESADetailParamService();
        }
        return this.iPSDESADetailParamService;
    }

    protected IPSDESADetailParamService createPSDESADetailParamService() {
        return new PSDESADetailParamServiceImpl();
    }

    public IPSDESARSService getPSDESARSService() {
        if (this.iPSDESARSService == null) {
            this.iPSDESARSService = this.createPSDESARSService();
        }
        return this.iPSDESARSService;
    }

    protected IPSDESARSService createPSDESARSService() {
        return new PSDESARSServiceImpl();
    }

    public IPSDESAVRService getPSDESAVRService() {
        if (this.iPSDESAVRService == null) {
            this.iPSDESAVRService = this.createPSDESAVRService();
        }
        return this.iPSDESAVRService;
    }

    protected IPSDESAVRService createPSDESAVRService() {
        return new PSDESAVRServiceImpl();
    }

    public IPSDESampleDataService getPSDESampleDataService() {
        if (this.iPSDESampleDataService == null) {
            this.iPSDESampleDataService = this.createPSDESampleDataService();
        }
        return this.iPSDESampleDataService;
    }

    protected IPSDESampleDataService createPSDESampleDataService() {
        return new PSDESampleDataServiceImpl();
    }

    public IPSDEServiceAPIService getPSDEServiceAPIService() {
        if (this.iPSDEServiceAPIService == null) {
            this.iPSDEServiceAPIService = this.createPSDEServiceAPIService();
        }
        return this.iPSDEServiceAPIService;
    }

    protected IPSDEServiceAPIService createPSDEServiceAPIService() {
        return new PSDEServiceAPIServiceImpl();
    }

    public IPSDETBItemService getPSDETBItemService() {
        if (this.iPSDETBItemService == null) {
            this.iPSDETBItemService = this.createPSDETBItemService();
        }
        return this.iPSDETBItemService;
    }

    protected IPSDETBItemService createPSDETBItemService() {
        return new PSDETBItemServiceImpl();
    }

    public IPSDETableService getPSDETableService() {
        if (this.iPSDETableService == null) {
            this.iPSDETableService = this.createPSDETableService();
        }
        return this.iPSDETableService;
    }

    protected IPSDETableService createPSDETableService() {
        return new PSDETableServiceImpl();
    }

    public IPSDEToolbarService getPSDEToolbarService() {
        if (this.iPSDEToolbarService == null) {
            this.iPSDEToolbarService = this.createPSDEToolbarService();
        }
        return this.iPSDEToolbarService;
    }

    protected IPSDEToolbarService createPSDEToolbarService() {
        return new PSDEToolbarServiceImpl();
    }

    public IPSDEToolbarLogicService getPSDEToolbarLogicService() {
        if (this.iPSDEToolbarLogicService == null) {
            this.iPSDEToolbarLogicService = this.createPSDEToolbarLogicService();
        }
        return this.iPSDEToolbarLogicService;
    }

    protected IPSDEToolbarLogicService createPSDEToolbarLogicService() {
        return new PSDEToolbarLogicServiceImpl();
    }

    public IPSDETreeColService getPSDETreeColService() {
        if (this.iPSDETreeColService == null) {
            this.iPSDETreeColService = this.createPSDETreeColService();
        }
        return this.iPSDETreeColService;
    }

    protected IPSDETreeColService createPSDETreeColService() {
        return new PSDETreeColServiceImpl();
    }

    public IPSDETreeLogicService getPSDETreeLogicService() {
        if (this.iPSDETreeLogicService == null) {
            this.iPSDETreeLogicService = this.createPSDETreeLogicService();
        }
        return this.iPSDETreeLogicService;
    }

    protected IPSDETreeLogicService createPSDETreeLogicService() {
        return new PSDETreeLogicServiceImpl();
    }

    public IPSDETreeNodeService getPSDETreeNodeService() {
        if (this.iPSDETreeNodeService == null) {
            this.iPSDETreeNodeService = this.createPSDETreeNodeService();
        }
        return this.iPSDETreeNodeService;
    }

    protected IPSDETreeNodeService createPSDETreeNodeService() {
        return new PSDETreeNodeServiceImpl();
    }

    public IPSDETreeNodeColService getPSDETreeNodeColService() {
        if (this.iPSDETreeNodeColService == null) {
            this.iPSDETreeNodeColService = this.createPSDETreeNodeColService();
        }
        return this.iPSDETreeNodeColService;
    }

    protected IPSDETreeNodeColService createPSDETreeNodeColService() {
        return new PSDETreeNodeColServiceImpl();
    }

    public IPSDETreeNodeRSService getPSDETreeNodeRSService() {
        if (this.iPSDETreeNodeRSService == null) {
            this.iPSDETreeNodeRSService = this.createPSDETreeNodeRSService();
        }
        return this.iPSDETreeNodeRSService;
    }

    protected IPSDETreeNodeRSService createPSDETreeNodeRSService() {
        return new PSDETreeNodeRSServiceImpl();
    }

    public IPSDETreeNodeRVService getPSDETreeNodeRVService() {
        if (this.iPSDETreeNodeRVService == null) {
            this.iPSDETreeNodeRVService = this.createPSDETreeNodeRVService();
        }
        return this.iPSDETreeNodeRVService;
    }

    protected IPSDETreeNodeRVService createPSDETreeNodeRVService() {
        return new PSDETreeNodeRVServiceImpl();
    }

    public IPSDETreeViewService getPSDETreeViewService() {
        if (this.iPSDETreeViewService == null) {
            this.iPSDETreeViewService = this.createPSDETreeViewService();
        }
        return this.iPSDETreeViewService;
    }

    protected IPSDETreeViewService createPSDETreeViewService() {
        return new PSDETreeViewServiceImpl();
    }

    public IPSDEUAGroupService getPSDEUAGroupService() {
        if (this.iPSDEUAGroupService == null) {
            this.iPSDEUAGroupService = this.createPSDEUAGroupService();
        }
        return this.iPSDEUAGroupService;
    }

    protected IPSDEUAGroupService createPSDEUAGroupService() {
        return new PSDEUAGroupServiceImpl();
    }

    public IPSDEUAGroupDetailService getPSDEUAGroupDetailService() {
        if (this.iPSDEUAGroupDetailService == null) {
            this.iPSDEUAGroupDetailService = this.createPSDEUAGroupDetailService();
        }
        return this.iPSDEUAGroupDetailService;
    }

    protected IPSDEUAGroupDetailService createPSDEUAGroupDetailService() {
        return new PSDEUAGroupDetailServiceImpl();
    }

    public IPSDEUIActionService getPSDEUIActionService() {
        if (this.iPSDEUIActionService == null) {
            this.iPSDEUIActionService = this.createPSDEUIActionService();
        }
        return this.iPSDEUIActionService;
    }

    protected IPSDEUIActionService createPSDEUIActionService() {
        return new PSDEUIActionServiceImpl();
    }

    public IPSDEUserRoleService getPSDEUserRoleService() {
        if (this.iPSDEUserRoleService == null) {
            this.iPSDEUserRoleService = this.createPSDEUserRoleService();
        }
        return this.iPSDEUserRoleService;
    }

    protected IPSDEUserRoleService createPSDEUserRoleService() {
        return new PSDEUserRoleServiceImpl();
    }

    public IPSDEUtilDEService getPSDEUtilDEService() {
        if (this.iPSDEUtilDEService == null) {
            this.iPSDEUtilDEService = this.createPSDEUtilDEService();
        }
        return this.iPSDEUtilDEService;
    }

    protected IPSDEUtilDEService createPSDEUtilDEService() {
        return new PSDEUtilDEServiceImpl();
    }

    public IPSDEVRGroupService getPSDEVRGroupService() {
        if (this.iPSDEVRGroupService == null) {
            this.iPSDEVRGroupService = this.createPSDEVRGroupService();
        }
        return this.iPSDEVRGroupService;
    }

    protected IPSDEVRGroupService createPSDEVRGroupService() {
        return new PSDEVRGroupServiceImpl();
    }

    public IPSDEVRGrpDetailService getPSDEVRGrpDetailService() {
        if (this.iPSDEVRGrpDetailService == null) {
            this.iPSDEVRGrpDetailService = this.createPSDEVRGrpDetailService();
        }
        return this.iPSDEVRGrpDetailService;
    }

    protected IPSDEVRGrpDetailService createPSDEVRGrpDetailService() {
        return new PSDEVRGrpDetailServiceImpl();
    }

    public IPSDEViewBaseService getPSDEViewBaseService() {
        if (this.iPSDEViewBaseService == null) {
            this.iPSDEViewBaseService = this.createPSDEViewBaseService();
        }
        return this.iPSDEViewBaseService;
    }

    protected IPSDEViewBaseService createPSDEViewBaseService() {
        return new PSDEViewBaseServiceImpl();
    }

    public IPSDEViewCtrlService getPSDEViewCtrlService() {
        if (this.iPSDEViewCtrlService == null) {
            this.iPSDEViewCtrlService = this.createPSDEViewCtrlService();
        }
        return this.iPSDEViewCtrlService;
    }

    protected IPSDEViewCtrlService createPSDEViewCtrlService() {
        return new PSDEViewCtrlServiceImpl();
    }

    public IPSDEViewEngineService getPSDEViewEngineService() {
        if (this.iPSDEViewEngineService == null) {
            this.iPSDEViewEngineService = this.createPSDEViewEngineService();
        }
        return this.iPSDEViewEngineService;
    }

    protected IPSDEViewEngineService createPSDEViewEngineService() {
        return new PSDEViewEngineServiceImpl();
    }

    public IPSDEViewLogicService getPSDEViewLogicService() {
        if (this.iPSDEViewLogicService == null) {
            this.iPSDEViewLogicService = this.createPSDEViewLogicService();
        }
        return this.iPSDEViewLogicService;
    }

    protected IPSDEViewLogicService createPSDEViewLogicService() {
        return new PSDEViewLogicServiceImpl();
    }

    public IPSDEViewRVService getPSDEViewRVService() {
        if (this.iPSDEViewRVService == null) {
            this.iPSDEViewRVService = this.createPSDEViewRVService();
        }
        return this.iPSDEViewRVService;
    }

    protected IPSDEViewRVService createPSDEViewRVService() {
        return new PSDEViewRVServiceImpl();
    }

    public IPSDEWizardService getPSDEWizardService() {
        if (this.iPSDEWizardService == null) {
            this.iPSDEWizardService = this.createPSDEWizardService();
        }
        return this.iPSDEWizardService;
    }

    protected IPSDEWizardService createPSDEWizardService() {
        return new PSDEWizardServiceImpl();
    }

    public IPSDEWizardFormService getPSDEWizardFormService() {
        if (this.iPSDEWizardFormService == null) {
            this.iPSDEWizardFormService = this.createPSDEWizardFormService();
        }
        return this.iPSDEWizardFormService;
    }

    protected IPSDEWizardFormService createPSDEWizardFormService() {
        return new PSDEWizardFormServiceImpl();
    }

    public IPSDEWizardLogicService getPSDEWizardLogicService() {
        if (this.iPSDEWizardLogicService == null) {
            this.iPSDEWizardLogicService = this.createPSDEWizardLogicService();
        }
        return this.iPSDEWizardLogicService;
    }

    protected IPSDEWizardLogicService createPSDEWizardLogicService() {
        return new PSDEWizardLogicServiceImpl();
    }

    public IPSDEWizardStepService getPSDEWizardStepService() {
        if (this.iPSDEWizardStepService == null) {
            this.iPSDEWizardStepService = this.createPSDEWizardStepService();
        }
        return this.iPSDEWizardStepService;
    }

    protected IPSDEWizardStepService createPSDEWizardStepService() {
        return new PSDEWizardStepServiceImpl();
    }

    public IPSLanguageService getPSLanguageService() {
        if (this.iPSLanguageService == null) {
            this.iPSLanguageService = this.createPSLanguageService();
        }
        return this.iPSLanguageService;
    }

    protected IPSLanguageService createPSLanguageService() {
        return new PSLanguageServiceImpl();
    }

    public IPSLanguageItemService getPSLanguageItemService() {
        if (this.iPSLanguageItemService == null) {
            this.iPSLanguageItemService = this.createPSLanguageItemService();
        }
        return this.iPSLanguageItemService;
    }

    protected IPSLanguageItemService createPSLanguageItemService() {
        return new PSLanguageItemServiceImpl();
    }

    public IPSLanguageResService getPSLanguageResService() {
        if (this.iPSLanguageResService == null) {
            this.iPSLanguageResService = this.createPSLanguageResService();
        }
        return this.iPSLanguageResService;
    }

    protected IPSLanguageResService createPSLanguageResService() {
        return new PSLanguageResServiceImpl();
    }

    public IPSMobAppPackService getPSMobAppPackService() {
        if (this.iPSMobAppPackService == null) {
            this.iPSMobAppPackService = this.createPSMobAppPackService();
        }
        return this.iPSMobAppPackService;
    }

    protected IPSMobAppPackService createPSMobAppPackService() {
        return new PSMobAppPackServiceImpl();
    }

    public IPSMobAppStartPageService getPSMobAppStartPageService() {
        if (this.iPSMobAppStartPageService == null) {
            this.iPSMobAppStartPageService = this.createPSMobAppStartPageService();
        }
        return this.iPSMobAppStartPageService;
    }

    protected IPSMobAppStartPageService createPSMobAppStartPageService() {
        return new PSMobAppStartPageServiceImpl();
    }

    public IPSPanelEngineService getPSPanelEngineService() {
        if (this.iPSPanelEngineService == null) {
            this.iPSPanelEngineService = this.createPSPanelEngineService();
        }
        return this.iPSPanelEngineService;
    }

    protected IPSPanelEngineService createPSPanelEngineService() {
        return new PSPanelEngineServiceImpl();
    }

    public IPSPanelItemLogicService getPSPanelItemLogicService() {
        if (this.iPSPanelItemLogicService == null) {
            this.iPSPanelItemLogicService = this.createPSPanelItemLogicService();
        }
        return this.iPSPanelItemLogicService;
    }

    protected IPSPanelItemLogicService createPSPanelItemLogicService() {
        return new PSPanelItemLogicServiceImpl();
    }

    public IPSSubSysSADEService getPSSubSysSADEService() {
        if (this.iPSSubSysSADEService == null) {
            this.iPSSubSysSADEService = this.createPSSubSysSADEService();
        }
        return this.iPSSubSysSADEService;
    }

    protected IPSSubSysSADEService createPSSubSysSADEService() {
        return new PSSubSysSADEServiceImpl();
    }

    public IPSSubSysSADEFieldService getPSSubSysSADEFieldService() {
        if (this.iPSSubSysSADEFieldService == null) {
            this.iPSSubSysSADEFieldService = this.createPSSubSysSADEFieldService();
        }
        return this.iPSSubSysSADEFieldService;
    }

    protected IPSSubSysSADEFieldService createPSSubSysSADEFieldService() {
        return new PSSubSysSADEFieldServiceImpl();
    }

    public IPSSubSysSADERSService getPSSubSysSADERSService() {
        if (this.iPSSubSysSADERSService == null) {
            this.iPSSubSysSADERSService = this.createPSSubSysSADERSService();
        }
        return this.iPSSubSysSADERSService;
    }

    protected IPSSubSysSADERSService createPSSubSysSADERSService() {
        return new PSSubSysSADERSServiceImpl();
    }

    public IPSSubSysSADetailService getPSSubSysSADetailService() {
        if (this.iPSSubSysSADetailService == null) {
            this.iPSSubSysSADetailService = this.createPSSubSysSADetailService();
        }
        return this.iPSSubSysSADetailService;
    }

    protected IPSSubSysSADetailService createPSSubSysSADetailService() {
        return new PSSubSysSADetailServiceImpl();
    }

    public IPSSubSysSADetailParamService getPSSubSysSADetailParamService() {
        if (this.iPSSubSysSADetailParamService == null) {
            this.iPSSubSysSADetailParamService = this.createPSSubSysSADetailParamService();
        }
        return this.iPSSubSysSADetailParamService;
    }

    protected IPSSubSysSADetailParamService createPSSubSysSADetailParamService() {
        return new PSSubSysSADetailParamServiceImpl();
    }

    public IPSSubSysServiceAPIService getPSSubSysServiceAPIService() {
        if (this.iPSSubSysServiceAPIService == null) {
            this.iPSSubSysServiceAPIService = this.createPSSubSysServiceAPIService();
        }
        return this.iPSSubSysServiceAPIService;
    }

    protected IPSSubSysServiceAPIService createPSSubSysServiceAPIService() {
        return new PSSubSysServiceAPIServiceImpl();
    }

    public IPSSubViewTypeService getPSSubViewTypeService() {
        if (this.iPSSubViewTypeService == null) {
            this.iPSSubViewTypeService = this.createPSSubViewTypeService();
        }
        return this.iPSSubViewTypeService;
    }

    protected IPSSubViewTypeService createPSSubViewTypeService() {
        return new PSSubViewTypeServiceImpl();
    }

    public IPSSysActorService getPSSysActorService() {
        if (this.iPSSysActorService == null) {
            this.iPSSysActorService = this.createPSSysActorService();
        }
        return this.iPSSysActorService;
    }

    protected IPSSysActorService createPSSysActorService() {
        return new PSSysActorServiceImpl();
    }

    public IPSSysAppService getPSSysAppService() {
        if (this.iPSSysAppService == null) {
            this.iPSSysAppService = this.createPSSysAppService();
        }
        return this.iPSSysAppService;
    }

    protected IPSSysAppService createPSSysAppService() {
        return new PSSysAppServiceImpl();
    }

    public IPSSysBDColSetService getPSSysBDColSetService() {
        if (this.iPSSysBDColSetService == null) {
            this.iPSSysBDColSetService = this.createPSSysBDColSetService();
        }
        return this.iPSSysBDColSetService;
    }

    protected IPSSysBDColSetService createPSSysBDColSetService() {
        return new PSSysBDColSetServiceImpl();
    }

    public IPSSysBDColumnService getPSSysBDColumnService() {
        if (this.iPSSysBDColumnService == null) {
            this.iPSSysBDColumnService = this.createPSSysBDColumnService();
        }
        return this.iPSSysBDColumnService;
    }

    protected IPSSysBDColumnService createPSSysBDColumnService() {
        return new PSSysBDColumnServiceImpl();
    }

    public IPSSysBDInstCfgService getPSSysBDInstCfgService() {
        if (this.iPSSysBDInstCfgService == null) {
            this.iPSSysBDInstCfgService = this.createPSSysBDInstCfgService();
        }
        return this.iPSSysBDInstCfgService;
    }

    protected IPSSysBDInstCfgService createPSSysBDInstCfgService() {
        return new PSSysBDInstCfgServiceImpl();
    }

    public IPSSysBDModuleService getPSSysBDModuleService() {
        if (this.iPSSysBDModuleService == null) {
            this.iPSSysBDModuleService = this.createPSSysBDModuleService();
        }
        return this.iPSSysBDModuleService;
    }

    protected IPSSysBDModuleService createPSSysBDModuleService() {
        return new PSSysBDModuleServiceImpl();
    }

    public IPSSysBDPartService getPSSysBDPartService() {
        if (this.iPSSysBDPartService == null) {
            this.iPSSysBDPartService = this.createPSSysBDPartService();
        }
        return this.iPSSysBDPartService;
    }

    protected IPSSysBDPartService createPSSysBDPartService() {
        return new PSSysBDPartServiceImpl();
    }

    public IPSSysBDSchemeService getPSSysBDSchemeService() {
        if (this.iPSSysBDSchemeService == null) {
            this.iPSSysBDSchemeService = this.createPSSysBDSchemeService();
        }
        return this.iPSSysBDSchemeService;
    }

    protected IPSSysBDSchemeService createPSSysBDSchemeService() {
        return new PSSysBDSchemeServiceImpl();
    }

    public IPSSysBDTableService getPSSysBDTableService() {
        if (this.iPSSysBDTableService == null) {
            this.iPSSysBDTableService = this.createPSSysBDTableService();
        }
        return this.iPSSysBDTableService;
    }

    protected IPSSysBDTableService createPSSysBDTableService() {
        return new PSSysBDTableServiceImpl();
    }

    public IPSSysBDTableDEService getPSSysBDTableDEService() {
        if (this.iPSSysBDTableDEService == null) {
            this.iPSSysBDTableDEService = this.createPSSysBDTableDEService();
        }
        return this.iPSSysBDTableDEService;
    }

    protected IPSSysBDTableDEService createPSSysBDTableDEService() {
        return new PSSysBDTableDEServiceImpl();
    }

    public IPSSysBDTableDERService getPSSysBDTableDERService() {
        if (this.iPSSysBDTableDERService == null) {
            this.iPSSysBDTableDERService = this.createPSSysBDTableDERService();
        }
        return this.iPSSysBDTableDERService;
    }

    protected IPSSysBDTableDERService createPSSysBDTableDERService() {
        return new PSSysBDTableDERServiceImpl();
    }

    public IPSSysBDTableRSService getPSSysBDTableRSService() {
        if (this.iPSSysBDTableRSService == null) {
            this.iPSSysBDTableRSService = this.createPSSysBDTableRSService();
        }
        return this.iPSSysBDTableRSService;
    }

    protected IPSSysBDTableRSService createPSSysBDTableRSService() {
        return new PSSysBDTableRSServiceImpl();
    }

    public IPSSysBIAggColumnService getPSSysBIAggColumnService() {
        if (this.iPSSysBIAggColumnService == null) {
            this.iPSSysBIAggColumnService = this.createPSSysBIAggColumnService();
        }
        return this.iPSSysBIAggColumnService;
    }

    protected IPSSysBIAggColumnService createPSSysBIAggColumnService() {
        return new PSSysBIAggColumnServiceImpl();
    }

    public IPSSysBIAggTableService getPSSysBIAggTableService() {
        if (this.iPSSysBIAggTableService == null) {
            this.iPSSysBIAggTableService = this.createPSSysBIAggTableService();
        }
        return this.iPSSysBIAggTableService;
    }

    protected IPSSysBIAggTableService createPSSysBIAggTableService() {
        return new PSSysBIAggTableServiceImpl();
    }

    public IPSSysBICubeService getPSSysBICubeService() {
        if (this.iPSSysBICubeService == null) {
            this.iPSSysBICubeService = this.createPSSysBICubeService();
        }
        return this.iPSSysBICubeService;
    }

    protected IPSSysBICubeService createPSSysBICubeService() {
        return new PSSysBICubeServiceImpl();
    }

    public IPSSysBICubeDimensionService getPSSysBICubeDimensionService() {
        if (this.iPSSysBICubeDimensionService == null) {
            this.iPSSysBICubeDimensionService = this.createPSSysBICubeDimensionService();
        }
        return this.iPSSysBICubeDimensionService;
    }

    protected IPSSysBICubeDimensionService createPSSysBICubeDimensionService() {
        return new PSSysBICubeDimensionServiceImpl();
    }

    public IPSSysBICubeLevelService getPSSysBICubeLevelService() {
        if (this.iPSSysBICubeLevelService == null) {
            this.iPSSysBICubeLevelService = this.createPSSysBICubeLevelService();
        }
        return this.iPSSysBICubeLevelService;
    }

    protected IPSSysBICubeLevelService createPSSysBICubeLevelService() {
        return new PSSysBICubeLevelServiceImpl();
    }

    public IPSSysBICubeMeasureService getPSSysBICubeMeasureService() {
        if (this.iPSSysBICubeMeasureService == null) {
            this.iPSSysBICubeMeasureService = this.createPSSysBICubeMeasureService();
        }
        return this.iPSSysBICubeMeasureService;
    }

    protected IPSSysBICubeMeasureService createPSSysBICubeMeasureService() {
        return new PSSysBICubeMeasureServiceImpl();
    }

    public IPSSysBIDimensionService getPSSysBIDimensionService() {
        if (this.iPSSysBIDimensionService == null) {
            this.iPSSysBIDimensionService = this.createPSSysBIDimensionService();
        }
        return this.iPSSysBIDimensionService;
    }

    protected IPSSysBIDimensionService createPSSysBIDimensionService() {
        return new PSSysBIDimensionServiceImpl();
    }

    public IPSSysBIHierarchyService getPSSysBIHierarchyService() {
        if (this.iPSSysBIHierarchyService == null) {
            this.iPSSysBIHierarchyService = this.createPSSysBIHierarchyService();
        }
        return this.iPSSysBIHierarchyService;
    }

    protected IPSSysBIHierarchyService createPSSysBIHierarchyService() {
        return new PSSysBIHierarchyServiceImpl();
    }

    public IPSSysBILevelService getPSSysBILevelService() {
        if (this.iPSSysBILevelService == null) {
            this.iPSSysBILevelService = this.createPSSysBILevelService();
        }
        return this.iPSSysBILevelService;
    }

    protected IPSSysBILevelService createPSSysBILevelService() {
        return new PSSysBILevelServiceImpl();
    }

    public IPSSysBISchemeService getPSSysBISchemeService() {
        if (this.iPSSysBISchemeService == null) {
            this.iPSSysBISchemeService = this.createPSSysBISchemeService();
        }
        return this.iPSSysBISchemeService;
    }

    protected IPSSysBISchemeService createPSSysBISchemeService() {
        return new PSSysBISchemeServiceImpl();
    }

    public IPSSysBackServiceService getPSSysBackServiceService() {
        if (this.iPSSysBackServiceService == null) {
            this.iPSSysBackServiceService = this.createPSSysBackServiceService();
        }
        return this.iPSSysBackServiceService;
    }

    protected IPSSysBackServiceService createPSSysBackServiceService() {
        return new PSSysBackServiceServiceImpl();
    }

    public IPSSysCalendarService getPSSysCalendarService() {
        if (this.iPSSysCalendarService == null) {
            this.iPSSysCalendarService = this.createPSSysCalendarService();
        }
        return this.iPSSysCalendarService;
    }

    protected IPSSysCalendarService createPSSysCalendarService() {
        return new PSSysCalendarServiceImpl();
    }

    public IPSSysCalendarItemService getPSSysCalendarItemService() {
        if (this.iPSSysCalendarItemService == null) {
            this.iPSSysCalendarItemService = this.createPSSysCalendarItemService();
        }
        return this.iPSSysCalendarItemService;
    }

    protected IPSSysCalendarItemService createPSSysCalendarItemService() {
        return new PSSysCalendarItemServiceImpl();
    }

    public IPSSysCalendarItemRVService getPSSysCalendarItemRVService() {
        if (this.iPSSysCalendarItemRVService == null) {
            this.iPSSysCalendarItemRVService = this.createPSSysCalendarItemRVService();
        }
        return this.iPSSysCalendarItemRVService;
    }

    protected IPSSysCalendarItemRVService createPSSysCalendarItemRVService() {
        return new PSSysCalendarItemRVServiceImpl();
    }

    public IPSSysCalendarLogicService getPSSysCalendarLogicService() {
        if (this.iPSSysCalendarLogicService == null) {
            this.iPSSysCalendarLogicService = this.createPSSysCalendarLogicService();
        }
        return this.iPSSysCalendarLogicService;
    }

    protected IPSSysCalendarLogicService createPSSysCalendarLogicService() {
        return new PSSysCalendarLogicServiceImpl();
    }

    public IPSSysCanvasService getPSSysCanvasService() {
        if (this.iPSSysCanvasService == null) {
            this.iPSSysCanvasService = this.createPSSysCanvasService();
        }
        return this.iPSSysCanvasService;
    }

    protected IPSSysCanvasService createPSSysCanvasService() {
        return new PSSysCanvasServiceImpl();
    }

    public IPSSysCanvasModelService getPSSysCanvasModelService() {
        if (this.iPSSysCanvasModelService == null) {
            this.iPSSysCanvasModelService = this.createPSSysCanvasModelService();
        }
        return this.iPSSysCanvasModelService;
    }

    protected IPSSysCanvasModelService createPSSysCanvasModelService() {
        return new PSSysCanvasModelServiceImpl();
    }

    public IPSSysChartThemeService getPSSysChartThemeService() {
        if (this.iPSSysChartThemeService == null) {
            this.iPSSysChartThemeService = this.createPSSysChartThemeService();
        }
        return this.iPSSysChartThemeService;
    }

    protected IPSSysChartThemeService createPSSysChartThemeService() {
        return new PSSysChartThemeServiceImpl();
    }

    public IPSSysCodeSnippetService getPSSysCodeSnippetService() {
        if (this.iPSSysCodeSnippetService == null) {
            this.iPSSysCodeSnippetService = this.createPSSysCodeSnippetService();
        }
        return this.iPSSysCodeSnippetService;
    }

    protected IPSSysCodeSnippetService createPSSysCodeSnippetService() {
        return new PSSysCodeSnippetServiceImpl();
    }

    public IPSSysContentService getPSSysContentService() {
        if (this.iPSSysContentService == null) {
            this.iPSSysContentService = this.createPSSysContentService();
        }
        return this.iPSSysContentService;
    }

    protected IPSSysContentService createPSSysContentService() {
        return new PSSysContentServiceImpl();
    }

    public IPSSysContentCatService getPSSysContentCatService() {
        if (this.iPSSysContentCatService == null) {
            this.iPSSysContentCatService = this.createPSSysContentCatService();
        }
        return this.iPSSysContentCatService;
    }

    protected IPSSysContentCatService createPSSysContentCatService() {
        return new PSSysContentCatServiceImpl();
    }

    public IPSSysCounterService getPSSysCounterService() {
        if (this.iPSSysCounterService == null) {
            this.iPSSysCounterService = this.createPSSysCounterService();
        }
        return this.iPSSysCounterService;
    }

    protected IPSSysCounterService createPSSysCounterService() {
        return new PSSysCounterServiceImpl();
    }

    public IPSSysCounterItemService getPSSysCounterItemService() {
        if (this.iPSSysCounterItemService == null) {
            this.iPSSysCounterItemService = this.createPSSysCounterItemService();
        }
        return this.iPSSysCounterItemService;
    }

    protected IPSSysCounterItemService createPSSysCounterItemService() {
        return new PSSysCounterItemServiceImpl();
    }

    public IPSSysCssService getPSSysCssService() {
        if (this.iPSSysCssService == null) {
            this.iPSSysCssService = this.createPSSysCssService();
        }
        return this.iPSSysCssService;
    }

    protected IPSSysCssService createPSSysCssService() {
        return new PSSysCssServiceImpl();
    }

    public IPSSysCssCatService getPSSysCssCatService() {
        if (this.iPSSysCssCatService == null) {
            this.iPSSysCssCatService = this.createPSSysCssCatService();
        }
        return this.iPSSysCssCatService;
    }

    protected IPSSysCssCatService createPSSysCssCatService() {
        return new PSSysCssCatServiceImpl();
    }

    public IPSSysDBColumnService getPSSysDBColumnService() {
        if (this.iPSSysDBColumnService == null) {
            this.iPSSysDBColumnService = this.createPSSysDBColumnService();
        }
        return this.iPSSysDBColumnService;
    }

    protected IPSSysDBColumnService createPSSysDBColumnService() {
        return new PSSysDBColumnServiceImpl();
    }

    public IPSSysDBPartService getPSSysDBPartService() {
        if (this.iPSSysDBPartService == null) {
            this.iPSSysDBPartService = this.createPSSysDBPartService();
        }
        return this.iPSSysDBPartService;
    }

    protected IPSSysDBPartService createPSSysDBPartService() {
        return new PSSysDBPartServiceImpl();
    }

    public IPSSysDBProcService getPSSysDBProcService() {
        if (this.iPSSysDBProcService == null) {
            this.iPSSysDBProcService = this.createPSSysDBProcService();
        }
        return this.iPSSysDBProcService;
    }

    protected IPSSysDBProcService createPSSysDBProcService() {
        return new PSSysDBProcServiceImpl();
    }

    public IPSSysDBProcParamService getPSSysDBProcParamService() {
        if (this.iPSSysDBProcParamService == null) {
            this.iPSSysDBProcParamService = this.createPSSysDBProcParamService();
        }
        return this.iPSSysDBProcParamService;
    }

    protected IPSSysDBProcParamService createPSSysDBProcParamService() {
        return new PSSysDBProcParamServiceImpl();
    }

    public IPSSysDBSchemeService getPSSysDBSchemeService() {
        if (this.iPSSysDBSchemeService == null) {
            this.iPSSysDBSchemeService = this.createPSSysDBSchemeService();
        }
        return this.iPSSysDBSchemeService;
    }

    protected IPSSysDBSchemeService createPSSysDBSchemeService() {
        return new PSSysDBSchemeServiceImpl();
    }

    public IPSSysDBTableService getPSSysDBTableService() {
        if (this.iPSSysDBTableService == null) {
            this.iPSSysDBTableService = this.createPSSysDBTableService();
        }
        return this.iPSSysDBTableService;
    }

    protected IPSSysDBTableService createPSSysDBTableService() {
        return new PSSysDBTableServiceImpl();
    }

    public IPSSysDBVFService getPSSysDBVFService() {
        if (this.iPSSysDBVFService == null) {
            this.iPSSysDBVFService = this.createPSSysDBVFService();
        }
        return this.iPSSysDBVFService;
    }

    protected IPSSysDBVFService createPSSysDBVFService() {
        return new PSSysDBVFServiceImpl();
    }

    public IPSSysDEFTypeService getPSSysDEFTypeService() {
        if (this.iPSSysDEFTypeService == null) {
            this.iPSSysDEFTypeService = this.createPSSysDEFTypeService();
        }
        return this.iPSSysDEFTypeService;
    }

    protected IPSSysDEFTypeService createPSSysDEFTypeService() {
        return new PSSysDEFTypeServiceImpl();
    }

    public IPSSysDELogicNodeService getPSSysDELogicNodeService() {
        if (this.iPSSysDELogicNodeService == null) {
            this.iPSSysDELogicNodeService = this.createPSSysDELogicNodeService();
        }
        return this.iPSSysDELogicNodeService;
    }

    protected IPSSysDELogicNodeService createPSSysDELogicNodeService() {
        return new PSSysDELogicNodeServiceImpl();
    }

    public IPSSysDMItemService getPSSysDMItemService() {
        if (this.iPSSysDMItemService == null) {
            this.iPSSysDMItemService = this.createPSSysDMItemService();
        }
        return this.iPSSysDMItemService;
    }

    protected IPSSysDMItemService createPSSysDMItemService() {
        return new PSSysDMItemServiceImpl();
    }

    public IPSSysDMVerService getPSSysDMVerService() {
        if (this.iPSSysDMVerService == null) {
            this.iPSSysDMVerService = this.createPSSysDMVerService();
        }
        return this.iPSSysDMVerService;
    }

    protected IPSSysDMVerService createPSSysDMVerService() {
        return new PSSysDMVerServiceImpl();
    }

    public IPSSysDashboardService getPSSysDashboardService() {
        if (this.iPSSysDashboardService == null) {
            this.iPSSysDashboardService = this.createPSSysDashboardService();
        }
        return this.iPSSysDashboardService;
    }

    protected IPSSysDashboardService createPSSysDashboardService() {
        return new PSSysDashboardServiceImpl();
    }

    public IPSSysDashboardLogicService getPSSysDashboardLogicService() {
        if (this.iPSSysDashboardLogicService == null) {
            this.iPSSysDashboardLogicService = this.createPSSysDashboardLogicService();
        }
        return this.iPSSysDashboardLogicService;
    }

    protected IPSSysDashboardLogicService createPSSysDashboardLogicService() {
        return new PSSysDashboardLogicServiceImpl();
    }

    public IPSSysDataSyncAgentService getPSSysDataSyncAgentService() {
        if (this.iPSSysDataSyncAgentService == null) {
            this.iPSSysDataSyncAgentService = this.createPSSysDataSyncAgentService();
        }
        return this.iPSSysDataSyncAgentService;
    }

    protected IPSSysDataSyncAgentService createPSSysDataSyncAgentService() {
        return new PSSysDataSyncAgentServiceImpl();
    }

    public IPSSysDictCatService getPSSysDictCatService() {
        if (this.iPSSysDictCatService == null) {
            this.iPSSysDictCatService = this.createPSSysDictCatService();
        }
        return this.iPSSysDictCatService;
    }

    protected IPSSysDictCatService createPSSysDictCatService() {
        return new PSSysDictCatServiceImpl();
    }

    public IPSSysDynaModelService getPSSysDynaModelService() {
        if (this.iPSSysDynaModelService == null) {
            this.iPSSysDynaModelService = this.createPSSysDynaModelService();
        }
        return this.iPSSysDynaModelService;
    }

    protected IPSSysDynaModelService createPSSysDynaModelService() {
        return new PSSysDynaModelServiceImpl();
    }

    public IPSSysDynaModelAttrService getPSSysDynaModelAttrService() {
        if (this.iPSSysDynaModelAttrService == null) {
            this.iPSSysDynaModelAttrService = this.createPSSysDynaModelAttrService();
        }
        return this.iPSSysDynaModelAttrService;
    }

    protected IPSSysDynaModelAttrService createPSSysDynaModelAttrService() {
        return new PSSysDynaModelAttrServiceImpl();
    }

    public IPSSysDynaModelCatService getPSSysDynaModelCatService() {
        if (this.iPSSysDynaModelCatService == null) {
            this.iPSSysDynaModelCatService = this.createPSSysDynaModelCatService();
        }
        return this.iPSSysDynaModelCatService;
    }

    protected IPSSysDynaModelCatService createPSSysDynaModelCatService() {
        return new PSSysDynaModelCatServiceImpl();
    }

    public IPSSysEAIDEService getPSSysEAIDEService() {
        if (this.iPSSysEAIDEService == null) {
            this.iPSSysEAIDEService = this.createPSSysEAIDEService();
        }
        return this.iPSSysEAIDEService;
    }

    protected IPSSysEAIDEService createPSSysEAIDEService() {
        return new PSSysEAIDEServiceImpl();
    }

    public IPSSysEAIDEFieldService getPSSysEAIDEFieldService() {
        if (this.iPSSysEAIDEFieldService == null) {
            this.iPSSysEAIDEFieldService = this.createPSSysEAIDEFieldService();
        }
        return this.iPSSysEAIDEFieldService;
    }

    protected IPSSysEAIDEFieldService createPSSysEAIDEFieldService() {
        return new PSSysEAIDEFieldServiceImpl();
    }

    public IPSSysEAIDERService getPSSysEAIDERService() {
        if (this.iPSSysEAIDERService == null) {
            this.iPSSysEAIDERService = this.createPSSysEAIDERService();
        }
        return this.iPSSysEAIDERService;
    }

    protected IPSSysEAIDERService createPSSysEAIDERService() {
        return new PSSysEAIDERServiceImpl();
    }

    public IPSSysEAIDataTypeService getPSSysEAIDataTypeService() {
        if (this.iPSSysEAIDataTypeService == null) {
            this.iPSSysEAIDataTypeService = this.createPSSysEAIDataTypeService();
        }
        return this.iPSSysEAIDataTypeService;
    }

    protected IPSSysEAIDataTypeService createPSSysEAIDataTypeService() {
        return new PSSysEAIDataTypeServiceImpl();
    }

    public IPSSysEAIDataTypeItemService getPSSysEAIDataTypeItemService() {
        if (this.iPSSysEAIDataTypeItemService == null) {
            this.iPSSysEAIDataTypeItemService = this.createPSSysEAIDataTypeItemService();
        }
        return this.iPSSysEAIDataTypeItemService;
    }

    protected IPSSysEAIDataTypeItemService createPSSysEAIDataTypeItemService() {
        return new PSSysEAIDataTypeItemServiceImpl();
    }

    public IPSSysEAIElementService getPSSysEAIElementService() {
        if (this.iPSSysEAIElementService == null) {
            this.iPSSysEAIElementService = this.createPSSysEAIElementService();
        }
        return this.iPSSysEAIElementService;
    }

    protected IPSSysEAIElementService createPSSysEAIElementService() {
        return new PSSysEAIElementServiceImpl();
    }

    public IPSSysEAIElementAttrService getPSSysEAIElementAttrService() {
        if (this.iPSSysEAIElementAttrService == null) {
            this.iPSSysEAIElementAttrService = this.createPSSysEAIElementAttrService();
        }
        return this.iPSSysEAIElementAttrService;
    }

    protected IPSSysEAIElementAttrService createPSSysEAIElementAttrService() {
        return new PSSysEAIElementAttrServiceImpl();
    }

    public IPSSysEAIElementREService getPSSysEAIElementREService() {
        if (this.iPSSysEAIElementREService == null) {
            this.iPSSysEAIElementREService = this.createPSSysEAIElementREService();
        }
        return this.iPSSysEAIElementREService;
    }

    protected IPSSysEAIElementREService createPSSysEAIElementREService() {
        return new PSSysEAIElementREServiceImpl();
    }

    public IPSSysEAISchemeService getPSSysEAISchemeService() {
        if (this.iPSSysEAISchemeService == null) {
            this.iPSSysEAISchemeService = this.createPSSysEAISchemeService();
        }
        return this.iPSSysEAISchemeService;
    }

    protected IPSSysEAISchemeService createPSSysEAISchemeService() {
        return new PSSysEAISchemeServiceImpl();
    }

    public IPSSysERMapService getPSSysERMapService() {
        if (this.iPSSysERMapService == null) {
            this.iPSSysERMapService = this.createPSSysERMapService();
        }
        return this.iPSSysERMapService;
    }

    protected IPSSysERMapService createPSSysERMapService() {
        return new PSSysERMapServiceImpl();
    }

    public IPSSysERMapNodeService getPSSysERMapNodeService() {
        if (this.iPSSysERMapNodeService == null) {
            this.iPSSysERMapNodeService = this.createPSSysERMapNodeService();
        }
        return this.iPSSysERMapNodeService;
    }

    protected IPSSysERMapNodeService createPSSysERMapNodeService() {
        return new PSSysERMapNodeServiceImpl();
    }

    public IPSSysEditorStyleService getPSSysEditorStyleService() {
        if (this.iPSSysEditorStyleService == null) {
            this.iPSSysEditorStyleService = this.createPSSysEditorStyleService();
        }
        return this.iPSSysEditorStyleService;
    }

    protected IPSSysEditorStyleService createPSSysEditorStyleService() {
        return new PSSysEditorStyleServiceImpl();
    }

    public IPSSysImageService getPSSysImageService() {
        if (this.iPSSysImageService == null) {
            this.iPSSysImageService = this.createPSSysImageService();
        }
        return this.iPSSysImageService;
    }

    protected IPSSysImageService createPSSysImageService() {
        return new PSSysImageServiceImpl();
    }

    public IPSSysMapItemService getPSSysMapItemService() {
        if (this.iPSSysMapItemService == null) {
            this.iPSSysMapItemService = this.createPSSysMapItemService();
        }
        return this.iPSSysMapItemService;
    }

    protected IPSSysMapItemService createPSSysMapItemService() {
        return new PSSysMapItemServiceImpl();
    }

    public IPSSysMapLogicService getPSSysMapLogicService() {
        if (this.iPSSysMapLogicService == null) {
            this.iPSSysMapLogicService = this.createPSSysMapLogicService();
        }
        return this.iPSSysMapLogicService;
    }

    protected IPSSysMapLogicService createPSSysMapLogicService() {
        return new PSSysMapLogicServiceImpl();
    }

    public IPSSysMapViewService getPSSysMapViewService() {
        if (this.iPSSysMapViewService == null) {
            this.iPSSysMapViewService = this.createPSSysMapViewService();
        }
        return this.iPSSysMapViewService;
    }

    protected IPSSysMapViewService createPSSysMapViewService() {
        return new PSSysMapViewServiceImpl();
    }

    public IPSSysModelGroupService getPSSysModelGroupService() {
        if (this.iPSSysModelGroupService == null) {
            this.iPSSysModelGroupService = this.createPSSysModelGroupService();
        }
        return this.iPSSysModelGroupService;
    }

    protected IPSSysModelGroupService createPSSysModelGroupService() {
        return new PSSysModelGroupServiceImpl();
    }

    public IPSSysMsgQueueService getPSSysMsgQueueService() {
        if (this.iPSSysMsgQueueService == null) {
            this.iPSSysMsgQueueService = this.createPSSysMsgQueueService();
        }
        return this.iPSSysMsgQueueService;
    }

    protected IPSSysMsgQueueService createPSSysMsgQueueService() {
        return new PSSysMsgQueueServiceImpl();
    }

    public IPSSysMsgTargetService getPSSysMsgTargetService() {
        if (this.iPSSysMsgTargetService == null) {
            this.iPSSysMsgTargetService = this.createPSSysMsgTargetService();
        }
        return this.iPSSysMsgTargetService;
    }

    protected IPSSysMsgTargetService createPSSysMsgTargetService() {
        return new PSSysMsgTargetServiceImpl();
    }

    public IPSSysMsgTemplService getPSSysMsgTemplService() {
        if (this.iPSSysMsgTemplService == null) {
            this.iPSSysMsgTemplService = this.createPSSysMsgTemplService();
        }
        return this.iPSSysMsgTemplService;
    }

    protected IPSSysMsgTemplService createPSSysMsgTemplService() {
        return new PSSysMsgTemplServiceImpl();
    }

    public IPSSysOPPrivService getPSSysOPPrivService() {
        if (this.iPSSysOPPrivService == null) {
            this.iPSSysOPPrivService = this.createPSSysOPPrivService();
        }
        return this.iPSSysOPPrivService;
    }

    protected IPSSysOPPrivService createPSSysOPPrivService() {
        return new PSSysOPPrivServiceImpl();
    }

    public IPSSysPDTViewService getPSSysPDTViewService() {
        if (this.iPSSysPDTViewService == null) {
            this.iPSSysPDTViewService = this.createPSSysPDTViewService();
        }
        return this.iPSSysPDTViewService;
    }

    protected IPSSysPDTViewService createPSSysPDTViewService() {
        return new PSSysPDTViewServiceImpl();
    }

    public IPSSysPFPITemplService getPSSysPFPITemplService() {
        if (this.iPSSysPFPITemplService == null) {
            this.iPSSysPFPITemplService = this.createPSSysPFPITemplService();
        }
        return this.iPSSysPFPITemplService;
    }

    protected IPSSysPFPITemplService createPSSysPFPITemplService() {
        return new PSSysPFPITemplServiceImpl();
    }

    public IPSSysPFPluginService getPSSysPFPluginService() {
        if (this.iPSSysPFPluginService == null) {
            this.iPSSysPFPluginService = this.createPSSysPFPluginService();
        }
        return this.iPSSysPFPluginService;
    }

    protected IPSSysPFPluginService createPSSysPFPluginService() {
        return new PSSysPFPluginServiceImpl();
    }

    public IPSSysPortletService getPSSysPortletService() {
        if (this.iPSSysPortletService == null) {
            this.iPSSysPortletService = this.createPSSysPortletService();
        }
        return this.iPSSysPortletService;
    }

    protected IPSSysPortletService createPSSysPortletService() {
        return new PSSysPortletServiceImpl();
    }

    public IPSSysPortletCatService getPSSysPortletCatService() {
        if (this.iPSSysPortletCatService == null) {
            this.iPSSysPortletCatService = this.createPSSysPortletCatService();
        }
        return this.iPSSysPortletCatService;
    }

    protected IPSSysPortletCatService createPSSysPortletCatService() {
        return new PSSysPortletCatServiceImpl();
    }

    public IPSSysRefService getPSSysRefService() {
        if (this.iPSSysRefService == null) {
            this.iPSSysRefService = this.createPSSysRefService();
        }
        return this.iPSSysRefService;
    }

    protected IPSSysRefService createPSSysRefService() {
        return new PSSysRefServiceImpl();
    }

    public IPSSysReqItemService getPSSysReqItemService() {
        if (this.iPSSysReqItemService == null) {
            this.iPSSysReqItemService = this.createPSSysReqItemService();
        }
        return this.iPSSysReqItemService;
    }

    protected IPSSysReqItemService createPSSysReqItemService() {
        return new PSSysReqItemServiceImpl();
    }

    public IPSSysReqItemDataService getPSSysReqItemDataService() {
        if (this.iPSSysReqItemDataService == null) {
            this.iPSSysReqItemDataService = this.createPSSysReqItemDataService();
        }
        return this.iPSSysReqItemDataService;
    }

    protected IPSSysReqItemDataService createPSSysReqItemDataService() {
        return new PSSysReqItemDataServiceImpl();
    }

    public IPSSysReqItemHisService getPSSysReqItemHisService() {
        if (this.iPSSysReqItemHisService == null) {
            this.iPSSysReqItemHisService = this.createPSSysReqItemHisService();
        }
        return this.iPSSysReqItemHisService;
    }

    protected IPSSysReqItemHisService createPSSysReqItemHisService() {
        return new PSSysReqItemHisServiceImpl();
    }

    public IPSSysReqModuleService getPSSysReqModuleService() {
        if (this.iPSSysReqModuleService == null) {
            this.iPSSysReqModuleService = this.createPSSysReqModuleService();
        }
        return this.iPSSysReqModuleService;
    }

    protected IPSSysReqModuleService createPSSysReqModuleService() {
        return new PSSysReqModuleServiceImpl();
    }

    public IPSSysResourceService getPSSysResourceService() {
        if (this.iPSSysResourceService == null) {
            this.iPSSysResourceService = this.createPSSysResourceService();
        }
        return this.iPSSysResourceService;
    }

    protected IPSSysResourceService createPSSysResourceService() {
        return new PSSysResourceServiceImpl();
    }

    public IPSSysSAHandlerService getPSSysSAHandlerService() {
        if (this.iPSSysSAHandlerService == null) {
            this.iPSSysSAHandlerService = this.createPSSysSAHandlerService();
        }
        return this.iPSSysSAHandlerService;
    }

    protected IPSSysSAHandlerService createPSSysSAHandlerService() {
        return new PSSysSAHandlerServiceImpl();
    }

    public IPSSysSFPITemplService getPSSysSFPITemplService() {
        if (this.iPSSysSFPITemplService == null) {
            this.iPSSysSFPITemplService = this.createPSSysSFPITemplService();
        }
        return this.iPSSysSFPITemplService;
    }

    protected IPSSysSFPITemplService createPSSysSFPITemplService() {
        return new PSSysSFPITemplServiceImpl();
    }

    public IPSSysSFPluginService getPSSysSFPluginService() {
        if (this.iPSSysSFPluginService == null) {
            this.iPSSysSFPluginService = this.createPSSysSFPluginService();
        }
        return this.iPSSysSFPluginService;
    }

    protected IPSSysSFPluginService createPSSysSFPluginService() {
        return new PSSysSFPluginServiceImpl();
    }

    public IPSSysSFPubService getPSSysSFPubService() {
        if (this.iPSSysSFPubService == null) {
            this.iPSSysSFPubService = this.createPSSysSFPubService();
        }
        return this.iPSSysSFPubService;
    }

    protected IPSSysSFPubService createPSSysSFPubService() {
        return new PSSysSFPubServiceImpl();
    }

    public IPSSysSFPubPkgService getPSSysSFPubPkgService() {
        if (this.iPSSysSFPubPkgService == null) {
            this.iPSSysSFPubPkgService = this.createPSSysSFPubPkgService();
        }
        return this.iPSSysSFPubPkgService;
    }

    protected IPSSysSFPubPkgService createPSSysSFPubPkgService() {
        return new PSSysSFPubPkgServiceImpl();
    }

    public IPSSysSampleValueService getPSSysSampleValueService() {
        if (this.iPSSysSampleValueService == null) {
            this.iPSSysSampleValueService = this.createPSSysSampleValueService();
        }
        return this.iPSSysSampleValueService;
    }

    protected IPSSysSampleValueService createPSSysSampleValueService() {
        return new PSSysSampleValueServiceImpl();
    }

    public IPSSysSearchBarService getPSSysSearchBarService() {
        if (this.iPSSysSearchBarService == null) {
            this.iPSSysSearchBarService = this.createPSSysSearchBarService();
        }
        return this.iPSSysSearchBarService;
    }

    protected IPSSysSearchBarService createPSSysSearchBarService() {
        return new PSSysSearchBarServiceImpl();
    }

    public IPSSysSearchBarItemService getPSSysSearchBarItemService() {
        if (this.iPSSysSearchBarItemService == null) {
            this.iPSSysSearchBarItemService = this.createPSSysSearchBarItemService();
        }
        return this.iPSSysSearchBarItemService;
    }

    protected IPSSysSearchBarItemService createPSSysSearchBarItemService() {
        return new PSSysSearchBarItemServiceImpl();
    }

    public IPSSysSearchBarLogicService getPSSysSearchBarLogicService() {
        if (this.iPSSysSearchBarLogicService == null) {
            this.iPSSysSearchBarLogicService = this.createPSSysSearchBarLogicService();
        }
        return this.iPSSysSearchBarLogicService;
    }

    protected IPSSysSearchBarLogicService createPSSysSearchBarLogicService() {
        return new PSSysSearchBarLogicServiceImpl();
    }

    public IPSSysSearchDEService getPSSysSearchDEService() {
        if (this.iPSSysSearchDEService == null) {
            this.iPSSysSearchDEService = this.createPSSysSearchDEService();
        }
        return this.iPSSysSearchDEService;
    }

    protected IPSSysSearchDEService createPSSysSearchDEService() {
        return new PSSysSearchDEServiceImpl();
    }

    public IPSSysSearchDEFieldService getPSSysSearchDEFieldService() {
        if (this.iPSSysSearchDEFieldService == null) {
            this.iPSSysSearchDEFieldService = this.createPSSysSearchDEFieldService();
        }
        return this.iPSSysSearchDEFieldService;
    }

    protected IPSSysSearchDEFieldService createPSSysSearchDEFieldService() {
        return new PSSysSearchDEFieldServiceImpl();
    }

    public IPSSysSearchDocService getPSSysSearchDocService() {
        if (this.iPSSysSearchDocService == null) {
            this.iPSSysSearchDocService = this.createPSSysSearchDocService();
        }
        return this.iPSSysSearchDocService;
    }

    protected IPSSysSearchDocService createPSSysSearchDocService() {
        return new PSSysSearchDocServiceImpl();
    }

    public IPSSysSearchFieldService getPSSysSearchFieldService() {
        if (this.iPSSysSearchFieldService == null) {
            this.iPSSysSearchFieldService = this.createPSSysSearchFieldService();
        }
        return this.iPSSysSearchFieldService;
    }

    protected IPSSysSearchFieldService createPSSysSearchFieldService() {
        return new PSSysSearchFieldServiceImpl();
    }

    public IPSSysSearchSchemeService getPSSysSearchSchemeService() {
        if (this.iPSSysSearchSchemeService == null) {
            this.iPSSysSearchSchemeService = this.createPSSysSearchSchemeService();
        }
        return this.iPSSysSearchSchemeService;
    }

    protected IPSSysSearchSchemeService createPSSysSearchSchemeService() {
        return new PSSysSearchSchemeServiceImpl();
    }

    public IPSSysSequenceService getPSSysSequenceService() {
        if (this.iPSSysSequenceService == null) {
            this.iPSSysSequenceService = this.createPSSysSequenceService();
        }
        return this.iPSSysSequenceService;
    }

    protected IPSSysSequenceService createPSSysSequenceService() {
        return new PSSysSequenceServiceImpl();
    }

    public IPSSysServiceAPIService getPSSysServiceAPIService() {
        if (this.iPSSysServiceAPIService == null) {
            this.iPSSysServiceAPIService = this.createPSSysServiceAPIService();
        }
        return this.iPSSysServiceAPIService;
    }

    protected IPSSysServiceAPIService createPSSysServiceAPIService() {
        return new PSSysServiceAPIServiceImpl();
    }

    public IPSSysTCAssertService getPSSysTCAssertService() {
        if (this.iPSSysTCAssertService == null) {
            this.iPSSysTCAssertService = this.createPSSysTCAssertService();
        }
        return this.iPSSysTCAssertService;
    }

    protected IPSSysTCAssertService createPSSysTCAssertService() {
        return new PSSysTCAssertServiceImpl();
    }

    public IPSSysTCInputService getPSSysTCInputService() {
        if (this.iPSSysTCInputService == null) {
            this.iPSSysTCInputService = this.createPSSysTCInputService();
        }
        return this.iPSSysTCInputService;
    }

    protected IPSSysTCInputService createPSSysTCInputService() {
        return new PSSysTCInputServiceImpl();
    }

    public IPSSysTDItemService getPSSysTDItemService() {
        if (this.iPSSysTDItemService == null) {
            this.iPSSysTDItemService = this.createPSSysTDItemService();
        }
        return this.iPSSysTDItemService;
    }

    protected IPSSysTDItemService createPSSysTDItemService() {
        return new PSSysTDItemServiceImpl();
    }

    public IPSSysTestCaseService getPSSysTestCaseService() {
        if (this.iPSSysTestCaseService == null) {
            this.iPSSysTestCaseService = this.createPSSysTestCaseService();
        }
        return this.iPSSysTestCaseService;
    }

    protected IPSSysTestCaseService createPSSysTestCaseService() {
        return new PSSysTestCaseServiceImpl();
    }

    public IPSSysTestDataService getPSSysTestDataService() {
        if (this.iPSSysTestDataService == null) {
            this.iPSSysTestDataService = this.createPSSysTestDataService();
        }
        return this.iPSSysTestDataService;
    }

    protected IPSSysTestDataService createPSSysTestDataService() {
        return new PSSysTestDataServiceImpl();
    }

    public IPSSysTestModuleService getPSSysTestModuleService() {
        if (this.iPSSysTestModuleService == null) {
            this.iPSSysTestModuleService = this.createPSSysTestModuleService();
        }
        return this.iPSSysTestModuleService;
    }

    protected IPSSysTestModuleService createPSSysTestModuleService() {
        return new PSSysTestModuleServiceImpl();
    }

    public IPSSysTestPrjService getPSSysTestPrjService() {
        if (this.iPSSysTestPrjService == null) {
            this.iPSSysTestPrjService = this.createPSSysTestPrjService();
        }
        return this.iPSSysTestPrjService;
    }

    protected IPSSysTestPrjService createPSSysTestPrjService() {
        return new PSSysTestPrjServiceImpl();
    }

    public IPSSysTranslatorService getPSSysTranslatorService() {
        if (this.iPSSysTranslatorService == null) {
            this.iPSSysTranslatorService = this.createPSSysTranslatorService();
        }
        return this.iPSSysTranslatorService;
    }

    protected IPSSysTranslatorService createPSSysTranslatorService() {
        return new PSSysTranslatorServiceImpl();
    }

    public IPSSysUCMapService getPSSysUCMapService() {
        if (this.iPSSysUCMapService == null) {
            this.iPSSysUCMapService = this.createPSSysUCMapService();
        }
        return this.iPSSysUCMapService;
    }

    protected IPSSysUCMapService createPSSysUCMapService() {
        return new PSSysUCMapServiceImpl();
    }

    public IPSSysUCMapNodeService getPSSysUCMapNodeService() {
        if (this.iPSSysUCMapNodeService == null) {
            this.iPSSysUCMapNodeService = this.createPSSysUCMapNodeService();
        }
        return this.iPSSysUCMapNodeService;
    }

    protected IPSSysUCMapNodeService createPSSysUCMapNodeService() {
        return new PSSysUCMapNodeServiceImpl();
    }

    public IPSSysUniResService getPSSysUniResService() {
        if (this.iPSSysUniResService == null) {
            this.iPSSysUniResService = this.createPSSysUniResService();
        }
        return this.iPSSysUniResService;
    }

    protected IPSSysUniResService createPSSysUniResService() {
        return new PSSysUniResServiceImpl();
    }

    public IPSSysUniStateService getPSSysUniStateService() {
        if (this.iPSSysUniStateService == null) {
            this.iPSSysUniStateService = this.createPSSysUniStateService();
        }
        return this.iPSSysUniStateService;
    }

    protected IPSSysUniStateService createPSSysUniStateService() {
        return new PSSysUniStateServiceImpl();
    }

    public IPSSysUnitService getPSSysUnitService() {
        if (this.iPSSysUnitService == null) {
            this.iPSSysUnitService = this.createPSSysUnitService();
        }
        return this.iPSSysUnitService;
    }

    protected IPSSysUnitService createPSSysUnitService() {
        return new PSSysUnitServiceImpl();
    }

    public IPSSysUserCaseService getPSSysUserCaseService() {
        if (this.iPSSysUserCaseService == null) {
            this.iPSSysUserCaseService = this.createPSSysUserCaseService();
        }
        return this.iPSSysUserCaseService;
    }

    protected IPSSysUserCaseService createPSSysUserCaseService() {
        return new PSSysUserCaseServiceImpl();
    }

    public IPSSysUserCaseRSService getPSSysUserCaseRSService() {
        if (this.iPSSysUserCaseRSService == null) {
            this.iPSSysUserCaseRSService = this.createPSSysUserCaseRSService();
        }
        return this.iPSSysUserCaseRSService;
    }

    protected IPSSysUserCaseRSService createPSSysUserCaseRSService() {
        return new PSSysUserCaseRSServiceImpl();
    }

    public IPSSysUserDRService getPSSysUserDRService() {
        if (this.iPSSysUserDRService == null) {
            this.iPSSysUserDRService = this.createPSSysUserDRService();
        }
        return this.iPSSysUserDRService;
    }

    protected IPSSysUserDRService createPSSysUserDRService() {
        return new PSSysUserDRServiceImpl();
    }

    public IPSSysUserModeService getPSSysUserModeService() {
        if (this.iPSSysUserModeService == null) {
            this.iPSSysUserModeService = this.createPSSysUserModeService();
        }
        return this.iPSSysUserModeService;
    }

    protected IPSSysUserModeService createPSSysUserModeService() {
        return new PSSysUserModeServiceImpl();
    }

    public IPSSysUserRoleDataService getPSSysUserRoleDataService() {
        if (this.iPSSysUserRoleDataService == null) {
            this.iPSSysUserRoleDataService = this.createPSSysUserRoleDataService();
        }
        return this.iPSSysUserRoleDataService;
    }

    protected IPSSysUserRoleDataService createPSSysUserRoleDataService() {
        return new PSSysUserRoleDataServiceImpl();
    }

    public IPSSysUserRoleResService getPSSysUserRoleResService() {
        if (this.iPSSysUserRoleResService == null) {
            this.iPSSysUserRoleResService = this.createPSSysUserRoleResService();
        }
        return this.iPSSysUserRoleResService;
    }

    protected IPSSysUserRoleResService createPSSysUserRoleResService() {
        return new PSSysUserRoleResServiceImpl();
    }

    public IPSSysUtilDEService getPSSysUtilDEService() {
        if (this.iPSSysUtilDEService == null) {
            this.iPSSysUtilDEService = this.createPSSysUtilDEService();
        }
        return this.iPSSysUtilDEService;
    }

    protected IPSSysUtilDEService createPSSysUtilDEService() {
        return new PSSysUtilDEServiceImpl();
    }

    public IPSSysValueRuleService getPSSysValueRuleService() {
        if (this.iPSSysValueRuleService == null) {
            this.iPSSysValueRuleService = this.createPSSysValueRuleService();
        }
        return this.iPSSysValueRuleService;
    }

    protected IPSSysValueRuleService createPSSysValueRuleService() {
        return new PSSysValueRuleServiceImpl();
    }

    public IPSSysViewLogicService getPSSysViewLogicService() {
        if (this.iPSSysViewLogicService == null) {
            this.iPSSysViewLogicService = this.createPSSysViewLogicService();
        }
        return this.iPSSysViewLogicService;
    }

    protected IPSSysViewLogicService createPSSysViewLogicService() {
        return new PSSysViewLogicServiceImpl();
    }

    public IPSSysViewLogicParamService getPSSysViewLogicParamService() {
        if (this.iPSSysViewLogicParamService == null) {
            this.iPSSysViewLogicParamService = this.createPSSysViewLogicParamService();
        }
        return this.iPSSysViewLogicParamService;
    }

    protected IPSSysViewLogicParamService createPSSysViewLogicParamService() {
        return new PSSysViewLogicParamServiceImpl();
    }

    public IPSSysViewPanelService getPSSysViewPanelService() {
        if (this.iPSSysViewPanelService == null) {
            this.iPSSysViewPanelService = this.createPSSysViewPanelService();
        }
        return this.iPSSysViewPanelService;
    }

    protected IPSSysViewPanelService createPSSysViewPanelService() {
        return new PSSysViewPanelServiceImpl();
    }

    public IPSSysViewPanelItemService getPSSysViewPanelItemService() {
        if (this.iPSSysViewPanelItemService == null) {
            this.iPSSysViewPanelItemService = this.createPSSysViewPanelItemService();
        }
        return this.iPSSysViewPanelItemService;
    }

    protected IPSSysViewPanelItemService createPSSysViewPanelItemService() {
        return new PSSysViewPanelItemServiceImpl();
    }

    public IPSSysViewPanelLogicService getPSSysViewPanelLogicService() {
        if (this.iPSSysViewPanelLogicService == null) {
            this.iPSSysViewPanelLogicService = this.createPSSysViewPanelLogicService();
        }
        return this.iPSSysViewPanelLogicService;
    }

    protected IPSSysViewPanelLogicService createPSSysViewPanelLogicService() {
        return new PSSysViewPanelLogicServiceImpl();
    }

    public IPSSysViewPanelModelService getPSSysViewPanelModelService() {
        if (this.iPSSysViewPanelModelService == null) {
            this.iPSSysViewPanelModelService = this.createPSSysViewPanelModelService();
        }
        return this.iPSSysViewPanelModelService;
    }

    protected IPSSysViewPanelModelService createPSSysViewPanelModelService() {
        return new PSSysViewPanelModelServiceImpl();
    }

    public IPSSysWFCatService getPSSysWFCatService() {
        if (this.iPSSysWFCatService == null) {
            this.iPSSysWFCatService = this.createPSSysWFCatService();
        }
        return this.iPSSysWFCatService;
    }

    protected IPSSysWFCatService createPSSysWFCatService() {
        return new PSSysWFCatServiceImpl();
    }

    public IPSSysWFModeService getPSSysWFModeService() {
        if (this.iPSSysWFModeService == null) {
            this.iPSSysWFModeService = this.createPSSysWFModeService();
        }
        return this.iPSSysWFModeService;
    }

    protected IPSSysWFModeService createPSSysWFModeService() {
        return new PSSysWFModeServiceImpl();
    }

    public IPSSysWFSettingService getPSSysWFSettingService() {
        if (this.iPSSysWFSettingService == null) {
            this.iPSSysWFSettingService = this.createPSSysWFSettingService();
        }
        return this.iPSSysWFSettingService;
    }

    protected IPSSysWFSettingService createPSSysWFSettingService() {
        return new PSSysWFSettingServiceImpl();
    }

    public IPSSystemDBCfgService getPSSystemDBCfgService() {
        if (this.iPSSystemDBCfgService == null) {
            this.iPSSystemDBCfgService = this.createPSSystemDBCfgService();
        }
        return this.iPSSystemDBCfgService;
    }

    protected IPSSystemDBCfgService createPSSystemDBCfgService() {
        return new PSSystemDBCfgServiceImpl();
    }

    public IPSSystemRunService getPSSystemRunService() {
        if (this.iPSSystemRunService == null) {
            this.iPSSystemRunService = this.createPSSystemRunService();
        }
        return this.iPSSystemRunService;
    }

    protected IPSSystemRunService createPSSystemRunService() {
        return new PSSystemRunServiceImpl();
    }

    public IPSThresholdService getPSThresholdService() {
        if (this.iPSThresholdService == null) {
            this.iPSThresholdService = this.createPSThresholdService();
        }
        return this.iPSThresholdService;
    }

    protected IPSThresholdService createPSThresholdService() {
        return new PSThresholdServiceImpl();
    }

    public IPSThresholdGroupService getPSThresholdGroupService() {
        if (this.iPSThresholdGroupService == null) {
            this.iPSThresholdGroupService = this.createPSThresholdGroupService();
        }
        return this.iPSThresholdGroupService;
    }

    protected IPSThresholdGroupService createPSThresholdGroupService() {
        return new PSThresholdGroupServiceImpl();
    }

    public IPSViewMsgService getPSViewMsgService() {
        if (this.iPSViewMsgService == null) {
            this.iPSViewMsgService = this.createPSViewMsgService();
        }
        return this.iPSViewMsgService;
    }

    protected IPSViewMsgService createPSViewMsgService() {
        return new PSViewMsgServiceImpl();
    }

    public IPSViewMsgGroupService getPSViewMsgGroupService() {
        if (this.iPSViewMsgGroupService == null) {
            this.iPSViewMsgGroupService = this.createPSViewMsgGroupService();
        }
        return this.iPSViewMsgGroupService;
    }

    protected IPSViewMsgGroupService createPSViewMsgGroupService() {
        return new PSViewMsgGroupServiceImpl();
    }

    public IPSViewMsgGrpDetailService getPSViewMsgGrpDetailService() {
        if (this.iPSViewMsgGrpDetailService == null) {
            this.iPSViewMsgGrpDetailService = this.createPSViewMsgGrpDetailService();
        }
        return this.iPSViewMsgGrpDetailService;
    }

    protected IPSViewMsgGrpDetailService createPSViewMsgGrpDetailService() {
        return new PSViewMsgGrpDetailServiceImpl();
    }

    public IPSWFDEService getPSWFDEService() {
        if (this.iPSWFDEService == null) {
            this.iPSWFDEService = this.createPSWFDEService();
        }
        return this.iPSWFDEService;
    }

    protected IPSWFDEService createPSWFDEService() {
        return new PSWFDEServiceImpl();
    }

    public IPSWFLinkService getPSWFLinkService() {
        if (this.iPSWFLinkService == null) {
            this.iPSWFLinkService = this.createPSWFLinkService();
        }
        return this.iPSWFLinkService;
    }

    protected IPSWFLinkService createPSWFLinkService() {
        return new PSWFLinkServiceImpl();
    }

    public IPSWFLinkCondService getPSWFLinkCondService() {
        if (this.iPSWFLinkCondService == null) {
            this.iPSWFLinkCondService = this.createPSWFLinkCondService();
        }
        return this.iPSWFLinkCondService;
    }

    protected IPSWFLinkCondService createPSWFLinkCondService() {
        return new PSWFLinkCondServiceImpl();
    }

    public IPSWFLinkRoleService getPSWFLinkRoleService() {
        if (this.iPSWFLinkRoleService == null) {
            this.iPSWFLinkRoleService = this.createPSWFLinkRoleService();
        }
        return this.iPSWFLinkRoleService;
    }

    protected IPSWFLinkRoleService createPSWFLinkRoleService() {
        return new PSWFLinkRoleServiceImpl();
    }

    public IPSWFProcParamService getPSWFProcParamService() {
        if (this.iPSWFProcParamService == null) {
            this.iPSWFProcParamService = this.createPSWFProcParamService();
        }
        return this.iPSWFProcParamService;
    }

    protected IPSWFProcParamService createPSWFProcParamService() {
        return new PSWFProcParamServiceImpl();
    }

    public IPSWFProcRoleService getPSWFProcRoleService() {
        if (this.iPSWFProcRoleService == null) {
            this.iPSWFProcRoleService = this.createPSWFProcRoleService();
        }
        return this.iPSWFProcRoleService;
    }

    protected IPSWFProcRoleService createPSWFProcRoleService() {
        return new PSWFProcRoleServiceImpl();
    }

    public IPSWFProcSubWFService getPSWFProcSubWFService() {
        if (this.iPSWFProcSubWFService == null) {
            this.iPSWFProcSubWFService = this.createPSWFProcSubWFService();
        }
        return this.iPSWFProcSubWFService;
    }

    protected IPSWFProcSubWFService createPSWFProcSubWFService() {
        return new PSWFProcSubWFServiceImpl();
    }

    public IPSWFProcessService getPSWFProcessService() {
        if (this.iPSWFProcessService == null) {
            this.iPSWFProcessService = this.createPSWFProcessService();
        }
        return this.iPSWFProcessService;
    }

    protected IPSWFProcessService createPSWFProcessService() {
        return new PSWFProcessServiceImpl();
    }

    public IPSWFRoleService getPSWFRoleService() {
        if (this.iPSWFRoleService == null) {
            this.iPSWFRoleService = this.createPSWFRoleService();
        }
        return this.iPSWFRoleService;
    }

    protected IPSWFRoleService createPSWFRoleService() {
        return new PSWFRoleServiceImpl();
    }

    public IPSWFUtilUIActionService getPSWFUtilUIActionService() {
        if (this.iPSWFUtilUIActionService == null) {
            this.iPSWFUtilUIActionService = this.createPSWFUtilUIActionService();
        }
        return this.iPSWFUtilUIActionService;
    }

    protected IPSWFUtilUIActionService createPSWFUtilUIActionService() {
        return new PSWFUtilUIActionServiceImpl();
    }

    public IPSWFVersionService getPSWFVersionService() {
        if (this.iPSWFVersionService == null) {
            this.iPSWFVersionService = this.createPSWFVersionService();
        }
        return this.iPSWFVersionService;
    }

    protected IPSWFVersionService createPSWFVersionService() {
        return new PSWFVersionServiceImpl();
    }

    public IPSWFWorkTimeService getPSWFWorkTimeService() {
        if (this.iPSWFWorkTimeService == null) {
            this.iPSWFWorkTimeService = this.createPSWFWorkTimeService();
        }
        return this.iPSWFWorkTimeService;
    }

    protected IPSWFWorkTimeService createPSWFWorkTimeService() {
        return new PSWFWorkTimeServiceImpl();
    }

    public IPSWXAccountService getPSWXAccountService() {
        if (this.iPSWXAccountService == null) {
            this.iPSWXAccountService = this.createPSWXAccountService();
        }
        return this.iPSWXAccountService;
    }

    protected IPSWXAccountService createPSWXAccountService() {
        return new PSWXAccountServiceImpl();
    }

    public IPSWXEntAppService getPSWXEntAppService() {
        if (this.iPSWXEntAppService == null) {
            this.iPSWXEntAppService = this.createPSWXEntAppService();
        }
        return this.iPSWXEntAppService;
    }

    protected IPSWXEntAppService createPSWXEntAppService() {
        return new PSWXEntAppServiceImpl();
    }

    public IPSWXLogicService getPSWXLogicService() {
        if (this.iPSWXLogicService == null) {
            this.iPSWXLogicService = this.createPSWXLogicService();
        }
        return this.iPSWXLogicService;
    }

    protected IPSWXLogicService createPSWXLogicService() {
        return new PSWXLogicServiceImpl();
    }

    public IPSWXMenuService getPSWXMenuService() {
        if (this.iPSWXMenuService == null) {
            this.iPSWXMenuService = this.createPSWXMenuService();
        }
        return this.iPSWXMenuService;
    }

    protected IPSWXMenuService createPSWXMenuService() {
        return new PSWXMenuServiceImpl();
    }

    public IPSWXMenuFuncService getPSWXMenuFuncService() {
        if (this.iPSWXMenuFuncService == null) {
            this.iPSWXMenuFuncService = this.createPSWXMenuFuncService();
        }
        return this.iPSWXMenuFuncService;
    }

    protected IPSWXMenuFuncService createPSWXMenuFuncService() {
        return new PSWXMenuFuncServiceImpl();
    }

    public IPSWXMenuItemService getPSWXMenuItemService() {
        if (this.iPSWXMenuItemService == null) {
            this.iPSWXMenuItemService = this.createPSWXMenuItemService();
        }
        return this.iPSWXMenuItemService;
    }

    protected IPSWXMenuItemService createPSWXMenuItemService() {
        return new PSWXMenuItemServiceImpl();
    }

    public IPSWorkflowService getPSWorkflowService() {
        if (this.iPSWorkflowService == null) {
            this.iPSWorkflowService = this.createPSWorkflowService();
        }
        return this.iPSWorkflowService;
    }

    protected IPSWorkflowService createPSWorkflowService() {
        return new PSWorkflowServiceImpl();
    }

    public void init() {
        this.psModelServiceMap.put("PSSYSTEM", this.iPSSystemService);
        this.psModelServiceMap.put("PSMODULE", this.iPSModuleService);
        this.psModelServiceMap.put("PSDATAENTITY", this.iPSDataEntityService);
        this.psModelServiceMap.put("PSDEFIELD", this.iPSDEFieldService);
        this.psModelServiceMap.put("PSDER", this.iPSDERService);
        this.psModelServiceMap.put("PSACHANDLER", this.iPSACHandlerService);
        this.psModelServiceMap.put("PSACHANDLERACTION", this.iPSACHandlerActionService);
        this.psModelServiceMap.put("PSAPPDERS", this.iPSAppDERSService);
        this.psModelServiceMap.put("PSAPPDEVIEW", this.iPSAppDEViewService);
        this.psModelServiceMap.put("PSAPPDYNADEVIEW", this.iPSAppDynaDEViewService);
        this.psModelServiceMap.put("PSAPPFUNC", this.iPSAppFuncService);
        this.psModelServiceMap.put("PSAPPINDEXVIEW", this.iPSAppIndexViewService);
        this.psModelServiceMap.put("PSAPPLAN", this.iPSAppLanService);
        this.psModelServiceMap.put("PSAPPLOCALDE", this.iPSAppLocalDEService);
        this.psModelServiceMap.put("PSAPPLOGIC", this.iPSAppLogicService);
        this.psModelServiceMap.put("PSAPPMENU", this.iPSAppMenuService);
        this.psModelServiceMap.put("PSAPPMENUITEM", this.iPSAppMenuItemService);
        this.psModelServiceMap.put("PSAPPMENULOGIC", this.iPSAppMenuLogicService);
        this.psModelServiceMap.put("PSAPPMODULE", this.iPSAppModuleService);
        this.psModelServiceMap.put("PSAPPPDTVIEW", this.iPSAppPDTViewService);
        this.psModelServiceMap.put("PSAPPPVPART", this.iPSAppPVPartService);
        this.psModelServiceMap.put("PSAPPPANELVIEW", this.iPSAppPanelViewService);
        this.psModelServiceMap.put("PSAPPPKG", this.iPSAppPkgService);
        this.psModelServiceMap.put("PSAPPPORTALVIEW", this.iPSAppPortalViewService);
        this.psModelServiceMap.put("PSAPPPORTLET", this.iPSAppPortletService);
        this.psModelServiceMap.put("PSAPPRESOURCE", this.iPSAppResourceService);
        this.psModelServiceMap.put("PSAPPSBITEM", this.iPSAppSBItemService);
        this.psModelServiceMap.put("PSAPPSBITEMRS", this.iPSAppSBItemRSService);
        this.psModelServiceMap.put("PSAPPSTORYBOARD", this.iPSAppStoryBoardService);
        this.psModelServiceMap.put("PSAPPTITLEBAR", this.iPSAppTitleBarService);
        this.psModelServiceMap.put("PSAPPUISTYLE", this.iPSAppUIStyleService);
        this.psModelServiceMap.put("PSAPPUITHEME", this.iPSAppUIThemeService);
        this.psModelServiceMap.put("PSAPPUSERMODE", this.iPSAppUserModeService);
        this.psModelServiceMap.put("PSAPPUTIL", this.iPSAppUtilService);
        this.psModelServiceMap.put("PSAPPUTILPAGE", this.iPSAppUtilPageService);
        this.psModelServiceMap.put("PSAPPUTILVIEW", this.iPSAppUtilViewService);
        this.psModelServiceMap.put("PSAPPVIEW", this.iPSAppViewService);
        this.psModelServiceMap.put("PSAPPWF", this.iPSAppWFService);
        this.psModelServiceMap.put("PSAPPWFVER", this.iPSAppWFVerService);
        this.psModelServiceMap.put("PSCODEITEM", this.iPSCodeItemService);
        this.psModelServiceMap.put("PSCODELIST", this.iPSCodeListService);
        this.psModelServiceMap.put("PSCTRLLOGICGROUP", this.iPSCtrlLogicGroupService);
        this.psModelServiceMap.put("PSCTRLLOGICGRPDETAIL", this.iPSCtrlLogicGrpDetailService);
        this.psModelServiceMap.put("PSCTRLMSG", this.iPSCtrlMsgService);
        this.psModelServiceMap.put("PSCTRLMSGITEM", this.iPSCtrlMsgItemService);
        this.psModelServiceMap.put("PSDEACMODE", this.iPSDEACModeService);
        this.psModelServiceMap.put("PSDEACMODEITEM", this.iPSDEACModeItemService);
        this.psModelServiceMap.put("PSDEAGDETAIL", this.iPSDEAGDetailService);
        this.psModelServiceMap.put("PSDEACTION", this.iPSDEActionService);
        this.psModelServiceMap.put("PSDEACTIONGROUP", this.iPSDEActionGroupService);
        this.psModelServiceMap.put("PSDEACTIONLOGIC", this.iPSDEActionLogicService);
        this.psModelServiceMap.put("PSDEACTIONPARAM", this.iPSDEActionParamService);
        this.psModelServiceMap.put("PSDEACTIONTEMPL", this.iPSDEActionTemplService);
        this.psModelServiceMap.put("PSDEACTIONVR", this.iPSDEActionVRService);
        this.psModelServiceMap.put("PSDECHART", this.iPSDEChartService);
        this.psModelServiceMap.put("PSDECHARTAXES", this.iPSDEChartAxesService);
        this.psModelServiceMap.put("PSDECHARTLOGIC", this.iPSDEChartLogicService);
        this.psModelServiceMap.put("PSDECHARTPARAM", this.iPSDEChartParamService);
        this.psModelServiceMap.put("PSDEDBCFG", this.iPSDEDBCfgService);
        this.psModelServiceMap.put("PSDEDBIDXFIELD", this.iPSDEDBIdxFieldService);
        this.psModelServiceMap.put("PSDEDBINDEX", this.iPSDEDBIndexService);
        this.psModelServiceMap.put("PSDEDQCODE", this.iPSDEDQCodeService);
        this.psModelServiceMap.put("PSDEDQCODECOND", this.iPSDEDQCodeCondService);
        this.psModelServiceMap.put("PSDEDQCODEEXP", this.iPSDEDQCodeExpService);
        this.psModelServiceMap.put("PSDEDQCOND", this.iPSDEDQCondService);
        this.psModelServiceMap.put("PSDEDQJOIN", this.iPSDEDQJoinService);
        this.psModelServiceMap.put("PSDEDRDETAIL", this.iPSDEDRDetailService);
        this.psModelServiceMap.put("PSDEDRGROUP", this.iPSDEDRGroupService);
        this.psModelServiceMap.put("PSDEDRITEM", this.iPSDEDRItemService);
        this.psModelServiceMap.put("PSDEDSDQ", this.iPSDEDSDQService);
        this.psModelServiceMap.put("PSDEDSGRPPARAM", this.iPSDEDSGrpParamService);
        this.psModelServiceMap.put("PSDEDSPARAM", this.iPSDEDSParamService);
        this.psModelServiceMap.put("PSDEDTSQUEUE", this.iPSDEDTSQueueService);
        this.psModelServiceMap.put("PSDEDATAEXP", this.iPSDEDataExpService);
        this.psModelServiceMap.put("PSDEDATAIMP", this.iPSDEDataImpService);
        this.psModelServiceMap.put("PSDEDATAIMPITEM", this.iPSDEDataImpItemService);
        this.psModelServiceMap.put("PSDEDATAQUERY", this.iPSDEDataQueryService);
        this.psModelServiceMap.put("PSDEDATARELATION", this.iPSDEDataRelationService);
        this.psModelServiceMap.put("PSDEDATASET", this.iPSDEDataSetService);
        this.psModelServiceMap.put("PSDEDATASYNC", this.iPSDEDataSyncService);
        this.psModelServiceMap.put("PSDEDATAVIEW", this.iPSDEDataViewService);
        this.psModelServiceMap.put("PSDEDATAVIEWLOGIC", this.iPSDEDataViewLogicService);
        this.psModelServiceMap.put("PSDEFDLOGIC", this.iPSDEFDLogicService);
        this.psModelServiceMap.put("PSDEFDTCOL", this.iPSDEFDTColService);
        this.psModelServiceMap.put("PSDEFGROUP", this.iPSDEFGroupService);
        this.psModelServiceMap.put("PSDEFGROUPDETAIL", this.iPSDEFGroupDetailService);
        this.psModelServiceMap.put("PSDEFIUDETAIL", this.iPSDEFIUDetailService);
        this.psModelServiceMap.put("PSDEFIUPDATE", this.iPSDEFIUpdateService);
        this.psModelServiceMap.put("PSDEFIVR", this.iPSDEFIVRService);
        this.psModelServiceMap.put("PSDEFINPUTTIP", this.iPSDEFInputTipService);
        this.psModelServiceMap.put("PSDEFINPUTTIPSET", this.iPSDEFInputTipSetService);
        this.psModelServiceMap.put("PSDEFSFITEM", this.iPSDEFSFItemService);
        this.psModelServiceMap.put("PSDEFFORMITEM", this.iPSDEFUIModeService);
        this.psModelServiceMap.put("PSDEFVRCOND", this.iPSDEFVRCondService);
        this.psModelServiceMap.put("PSDEFVALUERULE", this.iPSDEFValueRuleService);
        this.psModelServiceMap.put("PSDEFORM", this.iPSDEFormService);
        this.psModelServiceMap.put("PSDEFORMDETAIL", this.iPSDEFormDetailService);
        this.psModelServiceMap.put("PSDEFORMLOGIC", this.iPSDEFormLogicService);
        this.psModelServiceMap.put("PSDEFORMRF", this.iPSDEFormRFService);
        this.psModelServiceMap.put("PSDEGEIUDETAIL", this.iPSDEGEIUDetailService);
        this.psModelServiceMap.put("PSDEGEIUPDATE", this.iPSDEGEIUpdateService);
        this.psModelServiceMap.put("PSDEGEIVR", this.iPSDEGEIVRService);
        this.psModelServiceMap.put("PSDEGRID", this.iPSDEGridService);
        this.psModelServiceMap.put("PSDEGRIDCOL", this.iPSDEGridColService);
        this.psModelServiceMap.put("PSDEGRIDLOGIC", this.iPSDEGridLogicService);
        this.psModelServiceMap.put("PSDEGROUP", this.iPSDEGroupService);
        this.psModelServiceMap.put("PSDEGROUPDETAIL", this.iPSDEGroupDetailService);
        this.psModelServiceMap.put("PSDELLCOND", this.iPSDELLCondService);
        this.psModelServiceMap.put("PSDELNPARAM", this.iPSDELNParamService);
        this.psModelServiceMap.put("PSDELIST", this.iPSDEListService);
        this.psModelServiceMap.put("PSDELISTITEM", this.iPSDEListItemService);
        this.psModelServiceMap.put("PSDELISTLOGIC", this.iPSDEListLogicService);
        this.psModelServiceMap.put("PSDELOGIC", this.iPSDELogicService);
        this.psModelServiceMap.put("PSDELOGICLINK", this.iPSDELogicLinkService);
        this.psModelServiceMap.put("PSDELOGICNODE", this.iPSDELogicNodeService);
        this.psModelServiceMap.put("PSDELOGICPARAM", this.iPSDELogicParamService);
        this.psModelServiceMap.put("PSDEMSACTION", this.iPSDEMSActionService);
        this.psModelServiceMap.put("PSDEMSOPPRIV", this.iPSDEMSOPPrivService);
        this.psModelServiceMap.put("PSDEMAINSTATE", this.iPSDEMainStateService);
        this.psModelServiceMap.put("PSDEMAINSTATERS", this.iPSDEMainStateRSService);
        this.psModelServiceMap.put("PSDEMAP", this.iPSDEMapService);
        this.psModelServiceMap.put("PSDEMAPACTION", this.iPSDEMapActionService);
        this.psModelServiceMap.put("PSDEMAPDQ", this.iPSDEMapDQService);
        this.psModelServiceMap.put("PSDEMAPDS", this.iPSDEMapDSService);
        this.psModelServiceMap.put("PSDEMAPDETAIL", this.iPSDEMapDetailService);
        this.psModelServiceMap.put("PSDENOTIFY", this.iPSDENotifyService);
        this.psModelServiceMap.put("PSDENOTIFYTARGET", this.iPSDENotifyTargetService);
        this.psModelServiceMap.put("PSDEOPPRIV", this.iPSDEOPPrivService);
        this.psModelServiceMap.put("PSDEOPPRIVROLE", this.iPSDEOPPrivRoleService);
        this.psModelServiceMap.put("PSDEPRINT", this.iPSDEPrintService);
        this.psModelServiceMap.put("PSDERDEFMAP", this.iPSDERDEFMapService);
        this.psModelServiceMap.put("PSDERGROUP", this.iPSDERGroupService);
        this.psModelServiceMap.put("PSDERGROUPDETAIL", this.iPSDERGroupDetailService);
        this.psModelServiceMap.put("PSDEREPITEM", this.iPSDERepItemService);
        this.psModelServiceMap.put("PSDEREPORT", this.iPSDEReportService);
        this.psModelServiceMap.put("PSDESADETAIL", this.iPSDESADetailService);
        this.psModelServiceMap.put("PSDESADETAILPARAM", this.iPSDESADetailParamService);
        this.psModelServiceMap.put("PSDESARS", this.iPSDESARSService);
        this.psModelServiceMap.put("PSDESAVR", this.iPSDESAVRService);
        this.psModelServiceMap.put("PSDESAMPLEDATA", this.iPSDESampleDataService);
        this.psModelServiceMap.put("PSDESERVICEAPI", this.iPSDEServiceAPIService);
        this.psModelServiceMap.put("PSDETBITEM", this.iPSDETBItemService);
        this.psModelServiceMap.put("PSDETABLE", this.iPSDETableService);
        this.psModelServiceMap.put("PSDETOOLBAR", this.iPSDEToolbarService);
        this.psModelServiceMap.put("PSDETOOLBARLOGIC", this.iPSDEToolbarLogicService);
        this.psModelServiceMap.put("PSDETREECOL", this.iPSDETreeColService);
        this.psModelServiceMap.put("PSDETREELOGIC", this.iPSDETreeLogicService);
        this.psModelServiceMap.put("PSDETREENODE", this.iPSDETreeNodeService);
        this.psModelServiceMap.put("PSDETREENODECOL", this.iPSDETreeNodeColService);
        this.psModelServiceMap.put("PSDETREENODERS", this.iPSDETreeNodeRSService);
        this.psModelServiceMap.put("PSDETREENODERV", this.iPSDETreeNodeRVService);
        this.psModelServiceMap.put("PSDETREEVIEW", this.iPSDETreeViewService);
        this.psModelServiceMap.put("PSDEUAGROUP", this.iPSDEUAGroupService);
        this.psModelServiceMap.put("PSDEUAGRPDETAIL", this.iPSDEUAGroupDetailService);
        this.psModelServiceMap.put("PSDEUIACTION", this.iPSDEUIActionService);
        this.psModelServiceMap.put("PSDEUSERROLE", this.iPSDEUserRoleService);
        this.psModelServiceMap.put("PSDEUTILDE", this.iPSDEUtilDEService);
        this.psModelServiceMap.put("PSDEVRGROUP", this.iPSDEVRGroupService);
        this.psModelServiceMap.put("PSDEVRGRPDETAIL", this.iPSDEVRGrpDetailService);
        this.psModelServiceMap.put("PSDEVIEWBASE", this.iPSDEViewBaseService);
        this.psModelServiceMap.put("PSDEVIEWCTRL", this.iPSDEViewCtrlService);
        this.psModelServiceMap.put("PSDEVIEWENGINE", this.iPSDEViewEngineService);
        this.psModelServiceMap.put("PSDEVIEWLOGIC", this.iPSDEViewLogicService);
        this.psModelServiceMap.put("PSDEVIEWRV", this.iPSDEViewRVService);
        this.psModelServiceMap.put("PSDEWIZARD", this.iPSDEWizardService);
        this.psModelServiceMap.put("PSDEWIZARDFORM", this.iPSDEWizardFormService);
        this.psModelServiceMap.put("PSDEWIZARDLOGIC", this.iPSDEWizardLogicService);
        this.psModelServiceMap.put("PSDEWIZARDSTEP", this.iPSDEWizardStepService);
        this.psModelServiceMap.put("PSLANGUAGE", this.iPSLanguageService);
        this.psModelServiceMap.put("PSLANGUAGEITEM", this.iPSLanguageItemService);
        this.psModelServiceMap.put("PSLANGUAGERES", this.iPSLanguageResService);
        this.psModelServiceMap.put("PSMOBAPPPACK", this.iPSMobAppPackService);
        this.psModelServiceMap.put("PSMOBAPPSTARTPAGE", this.iPSMobAppStartPageService);
        this.psModelServiceMap.put("PSPANELENGINE", this.iPSPanelEngineService);
        this.psModelServiceMap.put("PSPANELITEMLOGIC", this.iPSPanelItemLogicService);
        this.psModelServiceMap.put("PSSUBSYSSADE", this.iPSSubSysSADEService);
        this.psModelServiceMap.put("PSSUBSYSSADEFIELD", this.iPSSubSysSADEFieldService);
        this.psModelServiceMap.put("PSSUBSYSSADERS", this.iPSSubSysSADERSService);
        this.psModelServiceMap.put("PSSUBSYSSADETAIL", this.iPSSubSysSADetailService);
        this.psModelServiceMap.put("PSSUBSYSSADETAILPARAM", this.iPSSubSysSADetailParamService);
        this.psModelServiceMap.put("PSSUBSYSSERVICEAPI", this.iPSSubSysServiceAPIService);
        this.psModelServiceMap.put("PSSUBVIEWTYPE", this.iPSSubViewTypeService);
        this.psModelServiceMap.put("PSSYSACTOR", this.iPSSysActorService);
        this.psModelServiceMap.put("PSSYSAPP", this.iPSSysAppService);
        this.psModelServiceMap.put("PSSYSBDCOLSET", this.iPSSysBDColSetService);
        this.psModelServiceMap.put("PSSYSBDCOLUMN", this.iPSSysBDColumnService);
        this.psModelServiceMap.put("PSSYSBDINSTCFG", this.iPSSysBDInstCfgService);
        this.psModelServiceMap.put("PSSYSBDMODULE", this.iPSSysBDModuleService);
        this.psModelServiceMap.put("PSSYSBDPART", this.iPSSysBDPartService);
        this.psModelServiceMap.put("PSSYSBDSCHEME", this.iPSSysBDSchemeService);
        this.psModelServiceMap.put("PSSYSBDTABLE", this.iPSSysBDTableService);
        this.psModelServiceMap.put("PSSYSBDTABLEDE", this.iPSSysBDTableDEService);
        this.psModelServiceMap.put("PSSYSBDTABLEDER", this.iPSSysBDTableDERService);
        this.psModelServiceMap.put("PSSYSBDTABLERS", this.iPSSysBDTableRSService);
        this.psModelServiceMap.put("PSSYSBIAGGCOLUMN", this.iPSSysBIAggColumnService);
        this.psModelServiceMap.put("PSSYSBIAGGTABLE", this.iPSSysBIAggTableService);
        this.psModelServiceMap.put("PSSYSBICUBE", this.iPSSysBICubeService);
        this.psModelServiceMap.put("PSSYSBICUBEDIMENSION", this.iPSSysBICubeDimensionService);
        this.psModelServiceMap.put("PSSYSBICUBELEVEL", this.iPSSysBICubeLevelService);
        this.psModelServiceMap.put("PSSYSBICUBEMEASURE", this.iPSSysBICubeMeasureService);
        this.psModelServiceMap.put("PSSYSBIDIMENSION", this.iPSSysBIDimensionService);
        this.psModelServiceMap.put("PSSYSBIHIERARCHY", this.iPSSysBIHierarchyService);
        this.psModelServiceMap.put("PSSYSBILEVEL", this.iPSSysBILevelService);
        this.psModelServiceMap.put("PSSYSBISCHEME", this.iPSSysBISchemeService);
        this.psModelServiceMap.put("PSSYSBACKSERVICE", this.iPSSysBackServiceService);
        this.psModelServiceMap.put("PSSYSCALENDAR", this.iPSSysCalendarService);
        this.psModelServiceMap.put("PSSYSCALENDARITEM", this.iPSSysCalendarItemService);
        this.psModelServiceMap.put("PSSYSCALENDARITEMRV", this.iPSSysCalendarItemRVService);
        this.psModelServiceMap.put("PSSYSCALENDARLOGIC", this.iPSSysCalendarLogicService);
        this.psModelServiceMap.put("PSSYSCANVAS", this.iPSSysCanvasService);
        this.psModelServiceMap.put("PSSYSCANVASMODEL", this.iPSSysCanvasModelService);
        this.psModelServiceMap.put("PSSYSCHARTTHEME", this.iPSSysChartThemeService);
        this.psModelServiceMap.put("PSSYSCODESNIPPET", this.iPSSysCodeSnippetService);
        this.psModelServiceMap.put("PSSYSCONTENT", this.iPSSysContentService);
        this.psModelServiceMap.put("PSSYSCONTENTCAT", this.iPSSysContentCatService);
        this.psModelServiceMap.put("PSSYSCOUNTER", this.iPSSysCounterService);
        this.psModelServiceMap.put("PSSYSCOUNTERITEM", this.iPSSysCounterItemService);
        this.psModelServiceMap.put("PSSYSCSS", this.iPSSysCssService);
        this.psModelServiceMap.put("PSSYSCSSCAT", this.iPSSysCssCatService);
        this.psModelServiceMap.put("PSSYSDBCOLUMN", this.iPSSysDBColumnService);
        this.psModelServiceMap.put("PSSYSDBPART", this.iPSSysDBPartService);
        this.psModelServiceMap.put("PSSYSDBPROC", this.iPSSysDBProcService);
        this.psModelServiceMap.put("PSSYSDBPROCPARAM", this.iPSSysDBProcParamService);
        this.psModelServiceMap.put("PSSYSDBSCHEME", this.iPSSysDBSchemeService);
        this.psModelServiceMap.put("PSSYSDBTABLE", this.iPSSysDBTableService);
        this.psModelServiceMap.put("PSSYSDBVF", this.iPSSysDBVFService);
        this.psModelServiceMap.put("PSSYSDEFTYPE", this.iPSSysDEFTypeService);
        this.psModelServiceMap.put("PSSYSDELOGICNODE", this.iPSSysDELogicNodeService);
        this.psModelServiceMap.put("PSSYSDMITEM", this.iPSSysDMItemService);
        this.psModelServiceMap.put("PSSYSDMVER", this.iPSSysDMVerService);
        this.psModelServiceMap.put("PSSYSDASHBOARD", this.iPSSysDashboardService);
        this.psModelServiceMap.put("PSSYSDASHBOARDLOGIC", this.iPSSysDashboardLogicService);
        this.psModelServiceMap.put("PSSYSDATASYNCAGENT", this.iPSSysDataSyncAgentService);
        this.psModelServiceMap.put("PSSYSDICTCAT", this.iPSSysDictCatService);
        this.psModelServiceMap.put("PSSYSDYNAMODEL", this.iPSSysDynaModelService);
        this.psModelServiceMap.put("PSSYSDYNAMODELATTR", this.iPSSysDynaModelAttrService);
        this.psModelServiceMap.put("PSSYSDYNAMODELCAT", this.iPSSysDynaModelCatService);
        this.psModelServiceMap.put("PSSYSEAIDE", this.iPSSysEAIDEService);
        this.psModelServiceMap.put("PSSYSEAIDEFIELD", this.iPSSysEAIDEFieldService);
        this.psModelServiceMap.put("PSSYSEAIDER", this.iPSSysEAIDERService);
        this.psModelServiceMap.put("PSSYSEAIDATATYPE", this.iPSSysEAIDataTypeService);
        this.psModelServiceMap.put("PSSYSEAIDATATYPEITEM", this.iPSSysEAIDataTypeItemService);
        this.psModelServiceMap.put("PSSYSEAIELEMENT", this.iPSSysEAIElementService);
        this.psModelServiceMap.put("PSSYSEAIELEMENTATTR", this.iPSSysEAIElementAttrService);
        this.psModelServiceMap.put("PSSYSEAIELEMENTRE", this.iPSSysEAIElementREService);
        this.psModelServiceMap.put("PSSYSEAISCHEME", this.iPSSysEAISchemeService);
        this.psModelServiceMap.put("PSSYSERMAP", this.iPSSysERMapService);
        this.psModelServiceMap.put("PSSYSERMAPNODE", this.iPSSysERMapNodeService);
        this.psModelServiceMap.put("PSSYSEDITORSTYLE", this.iPSSysEditorStyleService);
        this.psModelServiceMap.put("PSSYSIMAGE", this.iPSSysImageService);
        this.psModelServiceMap.put("PSSYSMAPITEM", this.iPSSysMapItemService);
        this.psModelServiceMap.put("PSSYSMAPLOGIC", this.iPSSysMapLogicService);
        this.psModelServiceMap.put("PSSYSMAPVIEW", this.iPSSysMapViewService);
        this.psModelServiceMap.put("PSSYSMODELGROUP", this.iPSSysModelGroupService);
        this.psModelServiceMap.put("PSSYSMSGQUEUE", this.iPSSysMsgQueueService);
        this.psModelServiceMap.put("PSSYSMSGTARGET", this.iPSSysMsgTargetService);
        this.psModelServiceMap.put("PSSYSMSGTEMPL", this.iPSSysMsgTemplService);
        this.psModelServiceMap.put("PSSYSOPPRIV", this.iPSSysOPPrivService);
        this.psModelServiceMap.put("PSSYSPDTVIEW", this.iPSSysPDTViewService);
        this.psModelServiceMap.put("PSSYSPFPITEMPL", this.iPSSysPFPITemplService);
        this.psModelServiceMap.put("PSSYSPFPLUGIN", this.iPSSysPFPluginService);
        this.psModelServiceMap.put("PSSYSPORTLET", this.iPSSysPortletService);
        this.psModelServiceMap.put("PSSYSPORTLETCAT", this.iPSSysPortletCatService);
        this.psModelServiceMap.put("PSSYSREF", this.iPSSysRefService);
        this.psModelServiceMap.put("PSSYSREQITEM", this.iPSSysReqItemService);
        this.psModelServiceMap.put("PSSYSREQITEMDATA", this.iPSSysReqItemDataService);
        this.psModelServiceMap.put("PSSYSREQITEMHIS", this.iPSSysReqItemHisService);
        this.psModelServiceMap.put("PSSYSREQMODULE", this.iPSSysReqModuleService);
        this.psModelServiceMap.put("PSSYSRESOURCE", this.iPSSysResourceService);
        this.psModelServiceMap.put("PSSYSSAHANDLER", this.iPSSysSAHandlerService);
        this.psModelServiceMap.put("PSSYSSFPITEMPL", this.iPSSysSFPITemplService);
        this.psModelServiceMap.put("PSSYSSFPLUGIN", this.iPSSysSFPluginService);
        this.psModelServiceMap.put("PSSYSSFPUB", this.iPSSysSFPubService);
        this.psModelServiceMap.put("PSSYSSFPUBPKG", this.iPSSysSFPubPkgService);
        this.psModelServiceMap.put("PSSYSSAMPLEVALUE", this.iPSSysSampleValueService);
        this.psModelServiceMap.put("PSSYSSEARCHBAR", this.iPSSysSearchBarService);
        this.psModelServiceMap.put("PSSYSSEARCHBARITEM", this.iPSSysSearchBarItemService);
        this.psModelServiceMap.put("PSSYSSEARCHBARLOGIC", this.iPSSysSearchBarLogicService);
        this.psModelServiceMap.put("PSSYSSEARCHDE", this.iPSSysSearchDEService);
        this.psModelServiceMap.put("PSSYSSEARCHDEFIELD", this.iPSSysSearchDEFieldService);
        this.psModelServiceMap.put("PSSYSSEARCHDOC", this.iPSSysSearchDocService);
        this.psModelServiceMap.put("PSSYSSEARCHFIELD", this.iPSSysSearchFieldService);
        this.psModelServiceMap.put("PSSYSSEARCHSCHEME", this.iPSSysSearchSchemeService);
        this.psModelServiceMap.put("PSSYSSEQUENCE", this.iPSSysSequenceService);
        this.psModelServiceMap.put("PSSYSSERVICEAPI", this.iPSSysServiceAPIService);
        this.psModelServiceMap.put("PSSYSTCASSERT", this.iPSSysTCAssertService);
        this.psModelServiceMap.put("PSSYSTCINPUT", this.iPSSysTCInputService);
        this.psModelServiceMap.put("PSSYSTDITEM", this.iPSSysTDItemService);
        this.psModelServiceMap.put("PSSYSTESTCASE", this.iPSSysTestCaseService);
        this.psModelServiceMap.put("PSSYSTESTDATA", this.iPSSysTestDataService);
        this.psModelServiceMap.put("PSSYSTESTMODULE", this.iPSSysTestModuleService);
        this.psModelServiceMap.put("PSSYSTESTPRJ", this.iPSSysTestPrjService);
        this.psModelServiceMap.put("PSSYSTRANSLATOR", this.iPSSysTranslatorService);
        this.psModelServiceMap.put("PSSYSUCMAP", this.iPSSysUCMapService);
        this.psModelServiceMap.put("PSSYSUCMAPNODE", this.iPSSysUCMapNodeService);
        this.psModelServiceMap.put("PSSYSUNIRES", this.iPSSysUniResService);
        this.psModelServiceMap.put("PSSYSUNISTATE", this.iPSSysUniStateService);
        this.psModelServiceMap.put("PSSYSUNIT", this.iPSSysUnitService);
        this.psModelServiceMap.put("PSSYSUSERCASE", this.iPSSysUserCaseService);
        this.psModelServiceMap.put("PSSYSUSERCASERS", this.iPSSysUserCaseRSService);
        this.psModelServiceMap.put("PSSYSUSERDR", this.iPSSysUserDRService);
        this.psModelServiceMap.put("PSSYSUSERMODE", this.iPSSysUserModeService);
        this.psModelServiceMap.put("PSSYSUSERROLEDATA", this.iPSSysUserRoleDataService);
        this.psModelServiceMap.put("PSSYSUSERROLERES", this.iPSSysUserRoleResService);
        this.psModelServiceMap.put("PSSYSUTILDE", this.iPSSysUtilDEService);
        this.psModelServiceMap.put("PSSYSVALUERULE", this.iPSSysValueRuleService);
        this.psModelServiceMap.put("PSSYSVIEWLOGIC", this.iPSSysViewLogicService);
        this.psModelServiceMap.put("PSSYSVIEWLOGICPARAM", this.iPSSysViewLogicParamService);
        this.psModelServiceMap.put("PSSYSVIEWPANEL", this.iPSSysViewPanelService);
        this.psModelServiceMap.put("PSSYSVIEWPANELITEM", this.iPSSysViewPanelItemService);
        this.psModelServiceMap.put("PSSYSVIEWPANELLOGIC", this.iPSSysViewPanelLogicService);
        this.psModelServiceMap.put("PSSYSVIEWPANELMODEL", this.iPSSysViewPanelModelService);
        this.psModelServiceMap.put("PSSYSWFCAT", this.iPSSysWFCatService);
        this.psModelServiceMap.put("PSSYSWFMODE", this.iPSSysWFModeService);
        this.psModelServiceMap.put("PSSYSWFSETTING", this.iPSSysWFSettingService);
        this.psModelServiceMap.put("PSSYSTEMDBCFG", this.iPSSystemDBCfgService);
        this.psModelServiceMap.put("PSSYSTEMRUN", this.iPSSystemRunService);
        this.psModelServiceMap.put("PSTHRESHOLD", this.iPSThresholdService);
        this.psModelServiceMap.put("PSTHRESHOLDGROUP", this.iPSThresholdGroupService);
        this.psModelServiceMap.put("PSVIEWMSG", this.iPSViewMsgService);
        this.psModelServiceMap.put("PSVIEWMSGGROUP", this.iPSViewMsgGroupService);
        this.psModelServiceMap.put("PSVIEWMSGGRPDETAIL", this.iPSViewMsgGrpDetailService);
        this.psModelServiceMap.put("PSWFDE", this.iPSWFDEService);
        this.psModelServiceMap.put("PSWFLINK", this.iPSWFLinkService);
        this.psModelServiceMap.put("PSWFLINKCOND", this.iPSWFLinkCondService);
        this.psModelServiceMap.put("PSWFLINKROLE", this.iPSWFLinkRoleService);
        this.psModelServiceMap.put("PSWFPROCPARAM", this.iPSWFProcParamService);
        this.psModelServiceMap.put("PSWFPROCROLE", this.iPSWFProcRoleService);
        this.psModelServiceMap.put("PSWFPROCSUBWF", this.iPSWFProcSubWFService);
        this.psModelServiceMap.put("PSWFPROCESS", this.iPSWFProcessService);
        this.psModelServiceMap.put("PSWFROLE", this.iPSWFRoleService);
        this.psModelServiceMap.put("PSWFUTILUIACTION", this.iPSWFUtilUIActionService);
        this.psModelServiceMap.put("PSWFVERSION", this.iPSWFVersionService);
        this.psModelServiceMap.put("PSWFWORKTIME", this.iPSWFWorkTimeService);
        this.psModelServiceMap.put("PSWXACCOUNT", this.iPSWXAccountService);
        this.psModelServiceMap.put("PSWXENTAPP", this.iPSWXEntAppService);
        this.psModelServiceMap.put("PSWXLOGIC", this.iPSWXLogicService);
        this.psModelServiceMap.put("PSWXMENU", this.iPSWXMenuService);
        this.psModelServiceMap.put("PSWXMENUFUNC", this.iPSWXMenuFuncService);
        this.psModelServiceMap.put("PSWXMENUITEM", this.iPSWXMenuItemService);
        this.psModelServiceMap.put("PSWORKFLOW", this.iPSWorkflowService);
    }

    public IPSModelService getPSModelService(String strPSModel) throws Exception {
        IPSModelService iPSModelService = this.psModelServiceMap.get(strPSModel);
        if (iPSModelService == null) {
            throw new Exception(String.format("\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s]\u670d\u52a1\u5bf9\u8c61", strPSModel));
        }
        return iPSModelService;
    }
}

