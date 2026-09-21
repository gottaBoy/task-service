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
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.config.service;

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
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppLogicService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppLogicServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuItemService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuItemServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuLogicService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuLogicServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppPFPluginService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppPFPluginServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppPVPartService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppPVPartServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppTitleBarService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppTitleBarServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppUtilService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppUtilServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewLogicService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewLogicServiceBase;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIReportService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIReportServiceBase;
import net.ibizsys.pscore.srv.config.dao.PSSysPFPluginDAO;
import net.ibizsys.pscore.srv.config.demodel.PSSysPFPluginDEModel;
import net.ibizsys.pscore.srv.config.entity.PSPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSPFPluginBase;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.service.PSDEACModeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEACModeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartAxesService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartAxesServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartParamService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartParamServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRDetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRGroupServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRItemServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataExpService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataExpServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataImpService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataImpServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFInputTipSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFInputTipSetServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFUIModeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFUIModeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFValueRuleService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFValueRuleServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridColService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridColServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListItemServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicParamService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicParamServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMapService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMapServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEPrintService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEPrintServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEReportService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEReportServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETBItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETBItemServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeColService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeColServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeColService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeColServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeViewService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeViewServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupDetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewEngineService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewEngineServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysPFPITempl;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSCtrlLogicGrpDetailService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCtrlLogicGrpDetailServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelEngineService;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelEngineServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubViewTypeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubViewTypeServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarItemServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarLogicService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarLogicServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCounterService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCounterServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBPartService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBPartServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDashboardLogicService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDashboardLogicServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDashboardService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDashboardServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysEditorStyleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysEditorStyleServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMapItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMapItemServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMapLogicService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMapLogicServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMapViewService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMapViewServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPFPITemplService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPFPITemplServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPortletService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPortletServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSearchBarItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSearchBarItemServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSearchBarLogicService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSearchBarLogicServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSearchBarService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSearchBarServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysTitleBarService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysTitleBarServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysValueRuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysValueRuleServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewLogicService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewLogicServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelLogicService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelLogicServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSMOSFileUtil;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysPFPluginServiceBase
extends PSCoreSysServiceBase<PSSysPFPlugin> {
    private static final Log log = LogFactory.getLog(PSSysPFPluginServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_CURSYSACI = "CurSysACI";
    public static final String DATASET_CURSYSAPPCOUNTER = "CurSysAppCounter";
    public static final String DATASET_CURSYSAPPMENU = "CurSysAppMenu";
    public static final String DATASET_CURSYSAPPMENUITEM = "CurSysAppMenuItem";
    public static final String DATASET_CURSYSAPPUILOGIC = "CurSysAppUILogic";
    public static final String DATASET_CURSYSAPPUTIL = "CurSysAppUtil";
    public static final String DATASET_CURSYSAPPVALUERULE = "CurSysAppValueRule";
    public static final String DATASET_CURSYSCDV = "CurSysCDV";
    public static final String DATASET_CURSYSCALENDAR = "CurSysCalendar";
    public static final String DATASET_CURSYSCALENDARITEM = "CurSysCalendarItem";
    public static final String DATASET_CURSYSCHARTAXIS = "CurSysChartAxis";
    public static final String DATASET_CURSYSCHARTCS = "CurSysChartCS";
    public static final String DATASET_CURSYSCHARTSERIES = "CurSysChartSeries";
    public static final String DATASET_CURSYSCUSTOM = "CurSysCustom";
    public static final String DATASET_CURSYSDCR = "CurSysDCR";
    public static final String DATASET_CURSYSDEDATAEXPORT = "CurSysDEDataExport";
    public static final String DATASET_CURSYSDEDATAIMPORT = "CurSysDEDataImport";
    public static final String DATASET_CURSYSDEFVALUERULE = "CurSysDEFValueRule";
    public static final String DATASET_CURSYSDEMETHOD = "CurSysDEMethod";
    public static final String DATASET_CURSYSDEUIACTION = "CurSysDEUIAction";
    public static final String DATASET_CURSYSDLR = "CurSysDLR";
    public static final String DATASET_CURSYSDVI = "CurSysDVI";
    public static final String DATASET_CURSYSDASHBOARD = "CurSysDashboard";
    public static final String DATASET_CURSYSDATAVIEW = "CurSysDataView";
    public static final String DATASET_CURSYSECS = "CurSysECS";
    public static final String DATASET_CURSYSEF = "CurSysEF";
    public static final String DATASET_CURSYSFUC = "CurSysFUC";
    public static final String DATASET_CURSYSGCR = "CurSysGCR";
    public static final String DATASET_CURSYSGRID = "CurSysGrid";
    public static final String DATASET_CURSYSLIR = "CurSysLIR";
    public static final String DATASET_CURSYSMAPVIEW = "CurSysMapView";
    public static final String DATASET_CURSYSMAPVIEWITEM = "CurSysMapViewItem";
    public static final String DATASET_CURSYSPC = "CurSysPC";
    public static final String DATASET_CURSYSPTB = "CurSysPTB";
    public static final String DATASET_CURSYSPANEL = "CurSysPanel";
    public static final String DATASET_CURSYSPANELITEM = "CurSysPanelItem";
    public static final String DATASET_CURSYSSB = "CurSysSB";
    public static final String DATASET_CURSYSSBI = "CurSysSBI";
    public static final String DATASET_CURSYSSF = "CurSysSF";
    public static final String DATASET_CURSYSTB = "CurSysTB";
    public static final String DATASET_CURSYSTBI = "CurSysTBI";
    public static final String DATASET_CURSYSTITLEBAR = "CurSysTitleBar";
    public static final String DATASET_CURSYSTREE = "CurSysTree";
    public static final String DATASET_CURSYSTREEEXPBAR = "CurSysTreeExpBar";
    public static final String DATASET_CURSYSUE = "CurSysUE";
    public static final String DATASET_CURSYSULN = "CurSysULN";
    public static final String DATASET_CURSYSWITHICON = "CurSysWithIcon";
    public static final String DATASET_CURSYSWIZARDPANEL = "CurSysWizardPanel";
    public static final String DATASET_CURSYSDASHBOARDPART = "CurSysDashboardPart";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_CALCPLUGINTYPE = "CALCPLUGINTYPE";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSSysPFPluginDEModel pSSysPFPluginDEModel;
    private PSSysPFPluginDAO pSSysPFPluginDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSSysPFPluginService";
    }

    public PSSysPFPluginDEModel getPSSysPFPluginDEModel() {
        if (this.pSSysPFPluginDEModel == null) {
            try {
                this.pSSysPFPluginDEModel = (PSSysPFPluginDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSSysPFPluginDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysPFPluginDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysPFPluginDEModel();
    }

    public PSSysPFPluginDAO getPSSysPFPluginDAO() {
        if (this.pSSysPFPluginDAO == null) {
            try {
                this.pSSysPFPluginDAO = (PSSysPFPluginDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSSysPFPluginDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysPFPluginDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysPFPluginDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSACI, (boolean)true) == 0) {
            return this.fetchCurSysACI(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSAPPCOUNTER, (boolean)true) == 0) {
            return this.fetchCurSysAppCounter(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSAPPMENU, (boolean)true) == 0) {
            return this.fetchCurSysAppMenu(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSAPPMENUITEM, (boolean)true) == 0) {
            return this.fetchCurSysAppMenuItem(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSAPPUILOGIC, (boolean)true) == 0) {
            return this.fetchCurSysAppUILogic(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSAPPUTIL, (boolean)true) == 0) {
            return this.fetchCurSysAppUtil(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSAPPVALUERULE, (boolean)true) == 0) {
            return this.fetchCurSysAppValueRule(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSCDV, (boolean)true) == 0) {
            return this.fetchCurSysCDV(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSCALENDAR, (boolean)true) == 0) {
            return this.fetchCurSysCalendar(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSCALENDARITEM, (boolean)true) == 0) {
            return this.fetchCurSysCalendarItem(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSCHARTAXIS, (boolean)true) == 0) {
            return this.fetchCurSysChartAxis(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSCHARTCS, (boolean)true) == 0) {
            return this.fetchCurSysChartCS(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSCHARTSERIES, (boolean)true) == 0) {
            return this.fetchCurSysChartSeries(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSCUSTOM, (boolean)true) == 0) {
            return this.fetchCurSysCustom(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSDCR, (boolean)true) == 0) {
            return this.fetchCurSysDCR(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSDEDATAEXPORT, (boolean)true) == 0) {
            return this.fetchCurSysDEDataExport(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSDEDATAIMPORT, (boolean)true) == 0) {
            return this.fetchCurSysDEDataImport(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSDEFVALUERULE, (boolean)true) == 0) {
            return this.fetchCurSysDEFValueRule(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSDEMETHOD, (boolean)true) == 0) {
            return this.fetchCurSysDEMethod(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSDEUIACTION, (boolean)true) == 0) {
            return this.fetchCurSysDEUIAction(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSDLR, (boolean)true) == 0) {
            return this.fetchCurSysDLR(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSDVI, (boolean)true) == 0) {
            return this.fetchCurSysDVI(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSDASHBOARD, (boolean)true) == 0) {
            return this.fetchCurSysDashboard(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSDATAVIEW, (boolean)true) == 0) {
            return this.fetchCurSysDataView(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSECS, (boolean)true) == 0) {
            return this.fetchCurSysECS(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSEF, (boolean)true) == 0) {
            return this.fetchCurSysEF(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSFUC, (boolean)true) == 0) {
            return this.fetchCurSysFUC(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSGCR, (boolean)true) == 0) {
            return this.fetchCurSysGCR(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSGRID, (boolean)true) == 0) {
            return this.fetchCurSysGrid(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSLIR, (boolean)true) == 0) {
            return this.fetchCurSysLIR(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSMAPVIEW, (boolean)true) == 0) {
            return this.fetchCurSysMapView(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSMAPVIEWITEM, (boolean)true) == 0) {
            return this.fetchCurSysMapViewItem(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSPC, (boolean)true) == 0) {
            return this.fetchCurSysPC(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSPTB, (boolean)true) == 0) {
            return this.fetchCurSysPTB(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSPANEL, (boolean)true) == 0) {
            return this.fetchCurSysPanel(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSPANELITEM, (boolean)true) == 0) {
            return this.fetchCurSysPanelItem(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSSB, (boolean)true) == 0) {
            return this.fetchCurSysSB(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSSBI, (boolean)true) == 0) {
            return this.fetchCurSysSBI(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSSF, (boolean)true) == 0) {
            return this.fetchCurSysSF(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSTB, (boolean)true) == 0) {
            return this.fetchCurSysTB(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSTBI, (boolean)true) == 0) {
            return this.fetchCurSysTBI(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSTITLEBAR, (boolean)true) == 0) {
            return this.fetchCurSysTitleBar(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSTREE, (boolean)true) == 0) {
            return this.fetchCurSysTree(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSTREEEXPBAR, (boolean)true) == 0) {
            return this.fetchCurSysTreeExpBar(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSUE, (boolean)true) == 0) {
            return this.fetchCurSysUE(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSULN, (boolean)true) == 0) {
            return this.fetchCurSysULN(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSWITHICON, (boolean)true) == 0) {
            return this.fetchCurSysWithIcon(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSWIZARDPANEL, (boolean)true) == 0) {
            return this.fetchCurSysWizardPanel(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSDASHBOARDPART, (boolean)true) == 0) {
            return this.fetchDashboardPart(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_CALCPLUGINTYPE, (boolean)true) == 0) {
            this.calcPluginType((PSSysPFPlugin)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysACI(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSACI, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysAppCounter(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSAPPCOUNTER, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysAppMenu(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSAPPMENU, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysAppMenuItem(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSAPPMENUITEM, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysAppUILogic(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSAPPUILOGIC, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysAppUtil(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSAPPUTIL, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysAppValueRule(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSAPPVALUERULE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysCDV(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSCDV, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysCalendar(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSCALENDAR, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysCalendarItem(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSCALENDARITEM, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysChartAxis(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSCHARTAXIS, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysChartCS(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSCHARTCS, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysChartSeries(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSCHARTSERIES, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysCustom(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSCUSTOM, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysDCR(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSDCR, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysDEDataExport(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSDEDATAEXPORT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysDEDataImport(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSDEDATAIMPORT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysDEFValueRule(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSDEFVALUERULE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysDEMethod(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSDEMETHOD, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysDEUIAction(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSDEUIACTION, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysDLR(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSDLR, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysDVI(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSDVI, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysDashboard(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSDASHBOARD, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysDataView(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSDATAVIEW, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysECS(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSECS, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysEF(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSEF, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysFUC(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSFUC, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysGCR(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSGCR, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysGrid(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSGRID, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysLIR(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSLIR, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysMapView(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSMAPVIEW, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysMapViewItem(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSMAPVIEWITEM, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysPC(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSPC, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysPTB(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSPTB, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysPanel(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSPANEL, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysPanelItem(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSPANELITEM, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysSB(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSSB, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysSBI(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSSBI, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysSF(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSSF, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysTB(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSTB, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysTBI(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSTBI, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysTitleBar(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSTITLEBAR, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysTree(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSTREE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysTreeExpBar(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSTREEEXPBAR, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysUE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSUE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysULN(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSULN, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysWithIcon(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSWITHICON, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysWizardPanel(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSWIZARDPANEL, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDashboardPart(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSDASHBOARDPART, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public void calcPluginType(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CALCPLUGINTYPE, 0, (IEntity)pSSysPFPlugin, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSSysPFPlugin, ACTION_CALCPLUGINTYPE);
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysPFPluginServiceBase.this.getService(), PSSysPFPluginServiceBase.ACTION_CALCPLUGINTYPE, 40, (IEntity)pSSysPFPlugin2, null).getResult() != 1) {
                    PSSysPFPluginServiceBase.this.onCalcPluginType(pSSysPFPlugin2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CALCPLUGINTYPE, 99, (IEntity)pSSysPFPlugin, null);
        }
    }

    protected void onCalcPluginType(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CALCPLUGINTYPE]");
    }

    protected void onFillParentInfo(PSSysPFPlugin pSSysPFPlugin, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSPFPLUGIN_PSMODULE_PSMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModuleService", (SessionFactory)this.getSessionFactory());
            PSModule pSModule = (PSModule)iService.getDEModel().createEntity();
            pSModule.set("PSMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSModule);
            } else {
                iService.get((IEntity)pSModule);
            }
            this.onFillParentInfo_PSModule(pSSysPFPlugin, pSModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSPFPLUGIN_PSPFPLUGIN_PSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFPluginService", (SessionFactory)this.getSessionFactory());
            PSPFPlugin pSPFPlugin = (PSPFPlugin)iService.getDEModel().createEntity();
            pSPFPlugin.set("PSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSPFPlugin);
            } else {
                iService.get((IEntity)pSPFPlugin);
            }
            this.onFillParentInfo_PSPFPlugin(pSSysPFPlugin, pSPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSPFPLUGIN_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSystem);
            } else {
                iService.get((IEntity)pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSSysPFPlugin, pSSystem);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysPFPlugin, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSModule(PSSysPFPlugin pSSysPFPlugin, PSModule pSModule) throws Exception {
        pSSysPFPlugin.setPSModuleId(pSModule.getPSModuleId());
        pSSysPFPlugin.setPSModuleName(pSModule.getPSModuleName());
    }

    protected void onFillParentInfo_PSPFPlugin(PSSysPFPlugin pSSysPFPlugin, PSPFPlugin pSPFPlugin) throws Exception {
        pSSysPFPlugin.setPSPFPluginId(pSPFPlugin.getPSPFPluginId());
        pSSysPFPlugin.setPSPFPluginName(pSPFPlugin.getPSPFPluginName());
    }

    protected void onFillParentInfo_PSSystem(PSSysPFPlugin pSSysPFPlugin, PSSystem pSSystem) throws Exception {
        pSSysPFPlugin.setPSSystemId(pSSystem.getPSSystemId());
        pSSysPFPlugin.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillEntityFullInfo(PSSysPFPlugin pSSysPFPlugin, boolean bl) throws Exception {
        if (bl) {
            if (pSSysPFPlugin.getCodeName() == null) {
                pSSysPFPlugin.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "PFPlugin", 25));
            }
            if (pSSysPFPlugin.getPSSysPFPITemplsCnt() == null) {
                pSSysPFPlugin.setPSSysPFPITemplsCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSSysPFPlugin.getPSSysPFPluginName() == null) {
                pSSysPFPlugin.setPSSysPFPluginName((String)this.getDefaultValue(this.getWebContext(), "USER", "\u524d\u7aef\u6a21\u677f\u63d2\u4ef6", 25));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSSysPFPlugin, bl);
        this.onFillEntityFullInfo_PSModule(pSSysPFPlugin, bl);
        this.onFillEntityFullInfo_PSPFPlugin(pSSysPFPlugin, bl);
        this.onFillEntityFullInfo_PSSystem(pSSysPFPlugin, bl);
    }

    protected void onFillEntityFullInfo_PSModule(PSSysPFPlugin pSSysPFPlugin, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSPFPlugin(PSSysPFPlugin pSSysPFPlugin, boolean bl) throws Exception {
        if (pSSysPFPlugin.isPSPFPluginIdDirty()) {
            if (pSSysPFPlugin.getPSPFPluginId() != null) {
                if (pSSysPFPlugin.getPSPFPluginId() == null || pSSysPFPlugin.getPSPFPluginName() == null) {
                    PSPFPlugin pSPFPlugin = pSSysPFPlugin.getPSPFPlugin();
                    pSSysPFPlugin.setPSPFPluginName(pSPFPlugin.getPSPFPluginName());
                }
            } else {
                pSSysPFPlugin.setPSPFPluginName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSystem(PSSysPFPlugin pSSysPFPlugin, boolean bl) throws Exception {
        if (pSSysPFPlugin.isPSSystemIdDirty()) {
            if (pSSysPFPlugin.getPSSystemId() != null) {
                if (pSSysPFPlugin.getPSSystemId() == null || pSSysPFPlugin.getPSSystemName() == null) {
                    PSSystem pSSystem = pSSysPFPlugin.getPSSystem();
                    pSSysPFPlugin.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSSysPFPlugin.setPSSystemName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSysPFPlugin pSSysPFPlugin, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysPFPlugin, bl);
    }

    public ArrayList<PSSysPFPlugin> selectByPSModule(PSModuleBase pSModuleBase) throws Exception {
        return this.selectByPSModule(pSModuleBase, "", -1);
    }

    public ArrayList<PSSysPFPlugin> selectByPSModule(PSModuleBase pSModuleBase, String string) throws Exception {
        return this.selectByPSModule(pSModuleBase, string, -1);
    }

    public ArrayList<PSSysPFPlugin> selectByPSModule(PSModuleBase pSModuleBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysPFPlugin> selectByPSPFPlugin(PSPFPluginBase pSPFPluginBase) throws Exception {
        return this.selectByPSPFPlugin(pSPFPluginBase, "", -1);
    }

    public ArrayList<PSSysPFPlugin> selectByPSPFPlugin(PSPFPluginBase pSPFPluginBase, String string) throws Exception {
        return this.selectByPSPFPlugin(pSPFPluginBase, string, -1);
    }

    public ArrayList<PSSysPFPlugin> selectByPSPFPlugin(PSPFPluginBase pSPFPluginBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSPFPLUGINID", (Object)pSPFPluginBase.getPSPFPluginId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSPFPluginCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSPFPluginCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysPFPlugin> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSSysPFPlugin> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSSysPFPlugin> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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

    public void testRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysPFPlugin> arrayList = this.selectByPSModule(pSModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSPFPLUGIN_PSMODULE_PSMODULEID", "", iDataEntityModel.getName(), "PSSYSPFPLUGIN", iDataEntityModel.getDataInfo((IEntity)pSModule), arrayList.get(0)));
        }
    }

    public void resetPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysPFPlugin> arrayList = this.selectByPSModule(pSModule);
        for (PSSysPFPlugin pSSysPFPlugin : arrayList) {
            PSSysPFPlugin pSSysPFPlugin2 = (PSSysPFPlugin)this.getDEModel().createEntity();
            pSSysPFPlugin2.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
            pSSysPFPlugin2.setPSModuleId(null);
            this.update(pSSysPFPlugin2);
        }
    }

    public void removeByPSModule(PSModule pSModule) throws Exception {
        final PSModule pSModule2 = pSModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysPFPluginServiceBase.this.onBeforeRemoveByPSModule(pSModule2);
                PSSysPFPluginServiceBase.this.internalRemoveByPSModule(pSModule2);
                PSSysPFPluginServiceBase.this.onAfterRemoveByPSModule(pSModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void internalRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysPFPlugin> arrayList = this.selectByPSModule(pSModule);
        this.onBeforeRemoveByPSModule(pSModule, arrayList);
        for (PSSysPFPlugin pSSysPFPlugin : arrayList) {
            this.remove((IEntity)pSSysPFPlugin);
        }
        this.onAfterRemoveByPSModule(pSModule, arrayList);
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule, ArrayList<PSSysPFPlugin> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule, ArrayList<PSSysPFPlugin> arrayList) throws Exception {
    }

    public void testRemoveByPSPFPlugin(PSPFPlugin pSPFPlugin) throws Exception {
    }

    public void resetPSPFPlugin(PSPFPlugin pSPFPlugin) throws Exception {
        ArrayList<PSSysPFPlugin> arrayList = this.selectByPSPFPlugin(pSPFPlugin);
        for (PSSysPFPlugin pSSysPFPlugin : arrayList) {
            PSSysPFPlugin pSSysPFPlugin2 = (PSSysPFPlugin)this.getDEModel().createEntity();
            pSSysPFPlugin2.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
            pSSysPFPlugin2.setPSPFPluginId(null);
            this.update(pSSysPFPlugin2);
        }
    }

    public void removeByPSPFPlugin(PSPFPlugin pSPFPlugin) throws Exception {
        final PSPFPlugin pSPFPlugin2 = pSPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysPFPluginServiceBase.this.onBeforeRemoveByPSPFPlugin(pSPFPlugin2);
                PSSysPFPluginServiceBase.this.internalRemoveByPSPFPlugin(pSPFPlugin2);
                PSSysPFPluginServiceBase.this.onAfterRemoveByPSPFPlugin(pSPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSPFPlugin(PSPFPlugin pSPFPlugin) throws Exception {
    }

    protected void internalRemoveByPSPFPlugin(PSPFPlugin pSPFPlugin) throws Exception {
        ArrayList<PSSysPFPlugin> arrayList = this.selectByPSPFPlugin(pSPFPlugin);
        this.onBeforeRemoveByPSPFPlugin(pSPFPlugin, arrayList);
        for (PSSysPFPlugin pSSysPFPlugin : arrayList) {
            this.remove((IEntity)pSSysPFPlugin);
        }
        this.onAfterRemoveByPSPFPlugin(pSPFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSPFPlugin(PSPFPlugin pSPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSPFPlugin(PSPFPlugin pSPFPlugin, ArrayList<PSSysPFPlugin> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPFPlugin(PSPFPlugin pSPFPlugin, ArrayList<PSSysPFPlugin> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysPFPlugin> arrayList = this.selectByPSSystem(pSSystem);
        for (PSSysPFPlugin pSSysPFPlugin : arrayList) {
            PSSysPFPlugin pSSysPFPlugin2 = (PSSysPFPlugin)this.getDEModel().createEntity();
            pSSysPFPlugin2.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
            pSSysPFPlugin2.setPSSystemId(null);
            this.update(pSSysPFPlugin2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysPFPluginServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSSysPFPluginServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSSysPFPluginServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysPFPlugin> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSSysPFPlugin pSSysPFPlugin : arrayList) {
            this.remove((IEntity)pSSysPFPlugin);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysPFPlugin> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysPFPlugin> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSAppLogicService)ServiceGlobal.getService(PSAppLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSAppMenuItemService)ServiceGlobal.getService(PSAppMenuItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppMenuItemServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSAppMenuLogicService)ServiceGlobal.getService(PSAppMenuLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppMenuLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSAppMenuService)ServiceGlobal.getService(PSAppMenuService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppMenuServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSAppPFPluginService)ServiceGlobal.getService(PSAppPFPluginService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppPFPluginServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSAppPVPartService)ServiceGlobal.getService(PSAppPVPartService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppPVPartServiceBase)pSCoreSysServiceBase).testRemoveByAMPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSAppPVPartService)ServiceGlobal.getService(PSAppPVPartService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppPVPartServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSAppTitleBarService)ServiceGlobal.getService(PSAppTitleBarService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppTitleBarServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSAppUtilService)ServiceGlobal.getService(PSAppUtilService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppUtilServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSAppViewLogicService)ServiceGlobal.getService(PSAppViewLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppViewLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.getSessionFactory());
        ((PSCodeListServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSCtrlLogicGrpDetailService)ServiceGlobal.getService(PSCtrlLogicGrpDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSCtrlLogicGrpDetailServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSDEACModeService)ServiceGlobal.getService(PSDEACModeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEACModeServiceBase)pSCoreSysServiceBase).testRemoveByACIPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSDEActionLogicService)ServiceGlobal.getService(PSDEActionLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEActionLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEActionServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSDEChartAxesService)ServiceGlobal.getService(PSDEChartAxesService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEChartAxesServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSDEChartLogicService)ServiceGlobal.getService(PSDEChartLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEChartLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSDEChartParamService)ServiceGlobal.getService(PSDEChartParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEChartParamServiceBase)pSCoreSysServiceBase).testRemoveByCSPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSDEChartParamService)ServiceGlobal.getService(PSDEChartParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEChartParamServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSDEChartService)ServiceGlobal.getService(PSDEChartService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEChartServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSDEDataExpService)ServiceGlobal.getService(PSDEDataExpService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataExpServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSDEDataImpService)ServiceGlobal.getService(PSDEDataImpService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataImpServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataSetServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSDEDataViewLogicService)ServiceGlobal.getService(PSDEDataViewLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataViewLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSDEDataViewService)ServiceGlobal.getService(PSDEDataViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataViewServiceBase)pSCoreSysServiceBase).testRemoveByGroupPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSDEDataViewService)ServiceGlobal.getService(PSDEDataViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataViewServiceBase)pSCoreSysServiceBase).testRemoveByItemPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSDEDataViewService)ServiceGlobal.getService(PSDEDataViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataViewServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSDEDRDetailService)ServiceGlobal.getService(PSDEDRDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDRDetailServiceBase)pSCoreSysServiceBase).testRemoveByHeaderPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSDEDRGroupService)ServiceGlobal.getService(PSDEDRGroupService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDRGroupServiceBase)pSCoreSysServiceBase).testRemoveByHeaderPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSDEDRItemService)ServiceGlobal.getService(PSDEDRItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDRItemServiceBase)pSCoreSysServiceBase).testRemoveByHeaderPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSDEDRLogicService)ServiceGlobal.getService(PSDEDRLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDRLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSDEFUIModeService)ServiceGlobal.getService(PSDEFUIModeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFUIModeServiceBase)pSCoreSysServiceBase).testRemoveByGCRPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSDEFInputTipSetService)ServiceGlobal.getService(PSDEFInputTipSetService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFInputTipSetServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormDetailServiceBase)pSCoreSysServiceBase).testRemoveByUCPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSDEFormLogicService)ServiceGlobal.getService(PSDEFormLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSDEFValueRuleService)ServiceGlobal.getService(PSDEFValueRuleService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFValueRuleServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSDEGridColService)ServiceGlobal.getService(PSDEGridColService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridColServiceBase)pSCoreSysServiceBase).testRemoveByGCRPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSDEGridLogicService)ServiceGlobal.getService(PSDEGridLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSDEGridService)ServiceGlobal.getService(PSDEGridService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridServiceBase)pSCoreSysServiceBase).testRemoveByGroupPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSDEGridService)ServiceGlobal.getService(PSDEGridService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSDEListItemService)ServiceGlobal.getService(PSDEListItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEListItemServiceBase)pSCoreSysServiceBase).testRemoveByLCRPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSDEListLogicService)ServiceGlobal.getService(PSDEListLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEListLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSDEListService)ServiceGlobal.getService(PSDEListService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEListServiceBase)pSCoreSysServiceBase).testRemoveByGroupPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSDEListService)ServiceGlobal.getService(PSDEListService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEListServiceBase)pSCoreSysServiceBase).testRemoveByItemPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSDEListService)ServiceGlobal.getService(PSDEListService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEListServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSDELogicNodeService)ServiceGlobal.getService(PSDELogicNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELogicNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSDELogicParamService)ServiceGlobal.getService(PSDELogicParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELogicParamServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSDEMapService)ServiceGlobal.getService(PSDEMapService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEMapServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSDEPrintService)ServiceGlobal.getService(PSDEPrintService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEPrintServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSDEReportService)ServiceGlobal.getService(PSDEReportService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEReportServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSDETBItemService)ServiceGlobal.getService(PSDETBItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETBItemServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSDEToolbarLogicService)ServiceGlobal.getService(PSDEToolbarLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEToolbarLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSDEToolbarService)ServiceGlobal.getService(PSDEToolbarService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEToolbarServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSDETreeColService)ServiceGlobal.getService(PSDETreeColService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeColServiceBase)pSCoreSysServiceBase).testRemoveByGCRPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSDETreeLogicService)ServiceGlobal.getService(PSDETreeLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSDETreeNodeColService)ServiceGlobal.getService(PSDETreeNodeColService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeColServiceBase)pSCoreSysServiceBase).testRemoveByGCRPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSDETreeViewService)ServiceGlobal.getService(PSDETreeViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeViewServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSDEUAGroupDetailService)ServiceGlobal.getService(PSDEUAGroupDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEUAGroupDetailServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEUIActionServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewBaseServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewCtrlServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSDEViewEngineService)ServiceGlobal.getService(PSDEViewEngineService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewEngineServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSDEViewLogicService)ServiceGlobal.getService(PSDEViewLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSDEWizardLogicService)ServiceGlobal.getService(PSDEWizardLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEWizardLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSDEWizardService)ServiceGlobal.getService(PSDEWizardService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEWizardServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSPanelEngineService)ServiceGlobal.getService(PSPanelEngineService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelEngineServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSSubViewTypeService)ServiceGlobal.getService(PSSubViewTypeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSubViewTypeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        ((PSSubViewTypeServiceBase)pSCoreSysServiceBase).resetPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSSysBIReportService)ServiceGlobal.getService(PSSysBIReportService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBIReportServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSSysCalendarItemService)ServiceGlobal.getService(PSSysCalendarItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarItemServiceBase)pSCoreSysServiceBase).testRemoveByGanttPSSysPFPluin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSSysCalendarItemService)ServiceGlobal.getService(PSSysCalendarItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarItemServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSSysCalendarLogicService)ServiceGlobal.getService(PSSysCalendarLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSSysCalendarService)ServiceGlobal.getService(PSSysCalendarService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarServiceBase)pSCoreSysServiceBase).testRemoveByGanttPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSSysCalendarService)ServiceGlobal.getService(PSSysCalendarService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarServiceBase)pSCoreSysServiceBase).testRemoveByGroupPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSSysCalendarService)ServiceGlobal.getService(PSSysCalendarService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSSysCounterService)ServiceGlobal.getService(PSSysCounterService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCounterServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSSysDashboardLogicService)ServiceGlobal.getService(PSSysDashboardLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysDashboardLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSSysDashboardService)ServiceGlobal.getService(PSSysDashboardService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysDashboardServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSSysDBPartService)ServiceGlobal.getService(PSSysDBPartService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysDBPartServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSSysEditorStyleService)ServiceGlobal.getService(PSSysEditorStyleService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysEditorStyleServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSSysMapItemService)ServiceGlobal.getService(PSSysMapItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMapItemServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSSysMapLogicService)ServiceGlobal.getService(PSSysMapLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMapLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSSysMapViewService)ServiceGlobal.getService(PSSysMapViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMapViewServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSSysPFPITemplService)ServiceGlobal.getService(PSSysPFPITemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysPFPITemplServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        ((PSSysPFPITemplServiceBase)pSCoreSysServiceBase).removeByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSSysPortletService)ServiceGlobal.getService(PSSysPortletService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysPortletServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSSysPortletService)ServiceGlobal.getService(PSSysPortletService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysPortletServiceBase)pSCoreSysServiceBase).testRemoveByTitlePSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSSysSearchBarItemService)ServiceGlobal.getService(PSSysSearchBarItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysSearchBarItemServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSSysSearchBarLogicService)ServiceGlobal.getService(PSSysSearchBarLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysSearchBarLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSSysSearchBarService)ServiceGlobal.getService(PSSysSearchBarService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysSearchBarServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSSysTitleBarService)ServiceGlobal.getService(PSSysTitleBarService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysTitleBarServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSSysValueRuleService)ServiceGlobal.getService(PSSysValueRuleService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysValueRuleServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSSysViewLogicService)ServiceGlobal.getService(PSSysViewLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelItemServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSSysViewPanelLogicService)ServiceGlobal.getService(PSSysViewPanelLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        pSCoreSysServiceBase = (PSSysViewPanelService)ServiceGlobal.getService(PSSysViewPanelService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPFPlugin(pSSysPFPlugin);
        super.onBeforeRemove(pSSysPFPlugin);
    }

    protected void replaceParentInfo(PSSysPFPlugin pSSysPFPlugin, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysPFPlugin, cloneSession);
        if (pSSysPFPlugin.getPSModuleId() != null && (iEntity = cloneSession.getEntity("PSMODULE", (Object)pSSysPFPlugin.getPSModuleId())) != null) {
            this.onFillParentInfo_PSModule(pSSysPFPlugin, (PSModule)iEntity);
        }
        if (pSSysPFPlugin.getPSPFPluginId() != null && (iEntity = cloneSession.getEntity("PSPFPLUGIN", (Object)pSSysPFPlugin.getPSPFPluginId())) != null) {
            this.onFillParentInfo_PSPFPlugin(pSSysPFPlugin, (PSPFPlugin)iEntity);
        }
        if (pSSysPFPlugin.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSSysPFPlugin.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSSysPFPlugin, (PSSystem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysPFPlugin pSSysPFPlugin, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysPFPlugin, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysPFPlugin pSSysPFPlugin, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSSysPFPlugin, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFlag(bl, pSSysPFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExtendStyleOnly(bl, pSSysPFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Keywords(bl, pSSysPFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSSysPFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysPFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSSysPFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PluginDesc(bl, pSSysPFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PluginModel(bl, pSSysPFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PluginParams(bl, pSSysPFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PluginTag(bl, pSSysPFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PluginTag2(bl, pSSysPFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PluginType(bl, pSSysPFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PreviewHtml(bl, pSSysPFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PreviewPSNDFileId(bl, pSSysPFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PreviewUrl(bl, pSSysPFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSSysPFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModuleId(bl, pSSysPFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFPluginId(bl, pSSysPFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFPluginName(bl, pSSysPFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysFileId(bl, pSSysPFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPFPITemplsCnt(bl, pSSysPFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPFPluginId(bl, pSSysPFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPFPluginName(bl, pSSysPFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSSysPFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSSysPFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RepDefault(bl, pSSysPFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RTObjectMode(bl, pSSysPFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RTObjectName(bl, pSSysPFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RTObjectRepo(bl, pSSysPFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StudioIcon(bl, pSSysPFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TempalteFunc(bl, pSSysPFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplateMode(bl, pSSysPFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysPFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysPFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysPFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysPFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysPFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysPFPlugin, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysPFPlugin pSSysPFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPFPlugin.isCodeNameDirty() : !pSSysPFPlugin.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysPFPlugin.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSSysPFPlugin, bl2, bl3);
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
                string3 = "PSMODULEID";
                string3 = string3 + ";";
                string3 = string3 + "PSSYSTEMID";
                String string4 = this.checkFieldDupRule(this.getPSSysPFPluginDEModel(), "CODENAME", string3, pSSysPFPlugin, bl2, bl3);
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

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSSysPFPlugin pSSysPFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPFPlugin.isDynaModelFlagDirty() : !pSSysPFPlugin.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSSysPFPlugin.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default((IEntity)pSSysPFPlugin, bl2, bl3);
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

    protected EntityFieldError onCheckField_ExtendStyleOnly(boolean bl, PSSysPFPlugin pSSysPFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPFPlugin.isExtendStyleOnlyDirty() : !pSSysPFPlugin.isExtendStyleOnlyDirty()) {
            return null;
        }
        Integer n = pSSysPFPlugin.getExtendStyleOnly();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExtendStyleOnly_Default((IEntity)pSSysPFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXTENDSTYLEONLY");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Keywords(boolean bl, PSSysPFPlugin pSSysPFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPFPlugin.isKeywordsDirty() : !pSSysPFPlugin.isKeywordsDirty()) {
            return null;
        }
        String string = pSSysPFPlugin.getKeywords();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Keywords_Default((IEntity)pSSysPFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("KEYWORDS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSSysPFPlugin pSSysPFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPFPlugin.isLockFlagDirty() : !pSSysPFPlugin.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSSysPFPlugin.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default((IEntity)pSSysPFPlugin, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysPFPlugin pSSysPFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPFPlugin.isMemoDirty() : !pSSysPFPlugin.isMemoDirty()) {
            return null;
        }
        String string = pSSysPFPlugin.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSysPFPlugin, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSSysPFPlugin pSSysPFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPFPlugin.isOrderValueDirty() : !pSSysPFPlugin.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSSysPFPlugin.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSSysPFPlugin, bl2, bl3);
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

    protected EntityFieldError onCheckField_PluginDesc(boolean bl, PSSysPFPlugin pSSysPFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPFPlugin.isPluginDescDirty() : !pSSysPFPlugin.isPluginDescDirty()) {
            return null;
        }
        String string = pSSysPFPlugin.getPluginDesc();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PluginDesc_Default((IEntity)pSSysPFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PLUGINDESC");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PluginModel(boolean bl, PSSysPFPlugin pSSysPFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPFPlugin.isPluginModelDirty() : !pSSysPFPlugin.isPluginModelDirty()) {
            return null;
        }
        String string = pSSysPFPlugin.getPluginModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PluginModel_Default((IEntity)pSSysPFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PLUGINMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PluginParams(boolean bl, PSSysPFPlugin pSSysPFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPFPlugin.isPluginParamsDirty() : !pSSysPFPlugin.isPluginParamsDirty()) {
            return null;
        }
        String string = pSSysPFPlugin.getPluginParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PluginParams_Default((IEntity)pSSysPFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PLUGINPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PluginTag(boolean bl, PSSysPFPlugin pSSysPFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPFPlugin.isPluginTagDirty() : !pSSysPFPlugin.isPluginTagDirty()) {
            return null;
        }
        String string = pSSysPFPlugin.getPluginTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PluginTag_Default((IEntity)pSSysPFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PLUGINTAG");
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
                string3 = "PLUGINTYPE";
                String string4 = this.checkFieldDupRule(this.getPSSysPFPluginDEModel(), "PLUGINTAG", string3, pSSysPFPlugin, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PLUGINTAG");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PluginTag2(boolean bl, PSSysPFPlugin pSSysPFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPFPlugin.isPluginTag2Dirty() : !pSSysPFPlugin.isPluginTag2Dirty()) {
            return null;
        }
        String string = pSSysPFPlugin.getPluginTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PluginTag2_Default((IEntity)pSSysPFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PLUGINTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PluginType(boolean bl, PSSysPFPlugin pSSysPFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPFPlugin.isPluginTypeDirty() && !bl2 : !pSSysPFPlugin.isPluginTypeDirty()) {
            return null;
        }
        String string = pSSysPFPlugin.getPluginType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PLUGINTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PluginType_Default((IEntity)pSSysPFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PLUGINTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PreviewHtml(boolean bl, PSSysPFPlugin pSSysPFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPFPlugin.isPreviewHtmlDirty() : !pSSysPFPlugin.isPreviewHtmlDirty()) {
            return null;
        }
        String string = pSSysPFPlugin.getPreviewHtml();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PreviewHtml_Default((IEntity)pSSysPFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PREVIEWHTML");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PreviewPSNDFileId(boolean bl, PSSysPFPlugin pSSysPFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPFPlugin.isPreviewPSNDFileIdDirty() : !pSSysPFPlugin.isPreviewPSNDFileIdDirty()) {
            return null;
        }
        String string = pSSysPFPlugin.getPreviewPSNDFileId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PreviewPSNDFileId_Default((IEntity)pSSysPFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PREVIEWPSNDFILEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PreviewUrl(boolean bl, PSSysPFPlugin pSSysPFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPFPlugin.isPreviewUrlDirty() : !pSSysPFPlugin.isPreviewUrlDirty()) {
            return null;
        }
        String string = pSSysPFPlugin.getPreviewUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PreviewUrl_Default((IEntity)pSSysPFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PREVIEWURL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSSysPFPlugin pSSysPFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPFPlugin.isPSDynaInstIdDirty() : !pSSysPFPlugin.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSSysPFPlugin.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default((IEntity)pSSysPFPlugin, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSModuleId(boolean bl, PSSysPFPlugin pSSysPFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPFPlugin.isPSModuleIdDirty() : !pSSysPFPlugin.isPSModuleIdDirty()) {
            return null;
        }
        String string = pSSysPFPlugin.getPSModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModuleId_Default((IEntity)pSSysPFPlugin, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSPFPluginId(boolean bl, PSSysPFPlugin pSSysPFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPFPlugin.isPSPFPluginIdDirty() : !pSSysPFPlugin.isPSPFPluginIdDirty()) {
            return null;
        }
        String string = pSSysPFPlugin.getPSPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFPluginId_Default((IEntity)pSSysPFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFPLUGINID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFPluginName(boolean bl, PSSysPFPlugin pSSysPFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPFPlugin.isPSPFPluginNameDirty() : !pSSysPFPlugin.isPSPFPluginNameDirty()) {
            return null;
        }
        String string = pSSysPFPlugin.getPSPFPluginName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFPluginName_Default((IEntity)pSSysPFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFPLUGINNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysFileId(boolean bl, PSSysPFPlugin pSSysPFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPFPlugin.isPSSysFileIdDirty() : !pSSysPFPlugin.isPSSysFileIdDirty()) {
            return null;
        }
        String string = pSSysPFPlugin.getPSSysFileId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysFileId_Default((IEntity)pSSysPFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSFILEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysPFPITemplsCnt(boolean bl, PSSysPFPlugin pSSysPFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPFPlugin.isPSSysPFPITemplsCntDirty() : !pSSysPFPlugin.isPSSysPFPITemplsCntDirty()) {
            return null;
        }
        Integer n = pSSysPFPlugin.getPSSysPFPITemplsCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSSysPFPITemplsCnt_Default((IEntity)pSSysPFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSPFPITEMPLSCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysPFPluginId(boolean bl, PSSysPFPlugin pSSysPFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPFPlugin.isPSSysPFPluginIdDirty() && !bl2 : !pSSysPFPlugin.isPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSSysPFPlugin.getPSSysPFPluginId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSPFPLUGINID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPFPluginId_Default((IEntity)pSSysPFPlugin, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysPFPluginName(boolean bl, PSSysPFPlugin pSSysPFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPFPlugin.isPSSysPFPluginNameDirty() && !bl2 : !pSSysPFPlugin.isPSSysPFPluginNameDirty()) {
            return null;
        }
        String string = pSSysPFPlugin.getPSSysPFPluginName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSPFPLUGINNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPFPluginName_Default((IEntity)pSSysPFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSPFPLUGINNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSSysPFPlugin pSSysPFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPFPlugin.isPSSystemIdDirty() && !bl2 : !pSSysPFPlugin.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSSysPFPlugin.getPSSystemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default((IEntity)pSSysPFPlugin, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSSysPFPlugin pSSysPFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPFPlugin.isPSSystemNameDirty() && !bl2 : !pSSysPFPlugin.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSSysPFPlugin.getPSSystemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default((IEntity)pSSysPFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RepDefault(boolean bl, PSSysPFPlugin pSSysPFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPFPlugin.isRepDefaultDirty() : !pSSysPFPlugin.isRepDefaultDirty()) {
            return null;
        }
        Integer n = pSSysPFPlugin.getRepDefault();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_RepDefault_Default((IEntity)pSSysPFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REPDEFAULT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RTObjectMode(boolean bl, PSSysPFPlugin pSSysPFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPFPlugin.isRTObjectModeDirty() : !pSSysPFPlugin.isRTObjectModeDirty()) {
            return null;
        }
        Integer n = pSSysPFPlugin.getRTObjectMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_RTObjectMode_Default((IEntity)pSSysPFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RTOBJECTMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RTObjectName(boolean bl, PSSysPFPlugin pSSysPFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPFPlugin.isRTObjectNameDirty() : !pSSysPFPlugin.isRTObjectNameDirty()) {
            return null;
        }
        String string = pSSysPFPlugin.getRTObjectName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RTObjectName_Default((IEntity)pSSysPFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RTOBJECTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RTObjectRepo(boolean bl, PSSysPFPlugin pSSysPFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPFPlugin.isRTObjectRepoDirty() : !pSSysPFPlugin.isRTObjectRepoDirty()) {
            return null;
        }
        String string = pSSysPFPlugin.getRTObjectRepo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RTObjectRepo_Default((IEntity)pSSysPFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RTOBJECTREPO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StudioIcon(boolean bl, PSSysPFPlugin pSSysPFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPFPlugin.isStudioIconDirty() : !pSSysPFPlugin.isStudioIconDirty()) {
            return null;
        }
        String string = pSSysPFPlugin.getStudioIcon();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_StudioIcon_Default((IEntity)pSSysPFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STUDIOICON");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TempalteFunc(boolean bl, PSSysPFPlugin pSSysPFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPFPlugin.isTempalteFuncDirty() : !pSSysPFPlugin.isTempalteFuncDirty()) {
            return null;
        }
        String string = pSSysPFPlugin.getTempalteFunc();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TempalteFunc_Default((IEntity)pSSysPFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLATEFUNC");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplateMode(boolean bl, PSSysPFPlugin pSSysPFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPFPlugin.isTemplateModeDirty() : !pSSysPFPlugin.isTemplateModeDirty()) {
            return null;
        }
        Integer n = pSSysPFPlugin.getTemplateMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TemplateMode_Default((IEntity)pSSysPFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLATEMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysPFPlugin pSSysPFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPFPlugin.isUserCatDirty() : !pSSysPFPlugin.isUserCatDirty()) {
            return null;
        }
        String string = pSSysPFPlugin.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSSysPFPlugin, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysPFPlugin pSSysPFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPFPlugin.isUserTagDirty() : !pSSysPFPlugin.isUserTagDirty()) {
            return null;
        }
        String string = pSSysPFPlugin.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSSysPFPlugin, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysPFPlugin pSSysPFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPFPlugin.isUserTag2Dirty() : !pSSysPFPlugin.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysPFPlugin.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSSysPFPlugin, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysPFPlugin pSSysPFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPFPlugin.isUserTag3Dirty() : !pSSysPFPlugin.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysPFPlugin.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSSysPFPlugin, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysPFPlugin pSSysPFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPFPlugin.isUserTag4Dirty() : !pSSysPFPlugin.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysPFPlugin.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSSysPFPlugin, bl2, bl3);
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

    protected void onSyncEntity(PSSysPFPlugin pSSysPFPlugin, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysPFPlugin, bl);
    }

    protected void onSyncIndexEntities(PSSysPFPlugin pSSysPFPlugin, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysPFPlugin, bl);
    }

    public Object getDataContextValue(PSSysPFPlugin pSSysPFPlugin, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysPFPlugin, string, iDataContextParam)) != null) {
            return object;
        }
        PSSystem pSSystem = pSSysPFPlugin.getPSSystem();
        if (pSSystem != null && pSSystem.contains(string)) {
            return pSSystem.get(string);
        }
        return null;
    }

    protected void onExportRelatedModel(PSSysPFPlugin pSSysPFPlugin, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportRelatedModel_PSSysPFPITempl_PSSysPFPlugin(pSSysPFPlugin, arrayList, n);
        super.onExportRelatedModel((IEntity)pSSysPFPlugin, arrayList, n);
    }

    protected void onExportRelatedModel_PSSysPFPITempl_PSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSSysPFPITemplService pSSysPFPITemplService = (PSSysPFPITemplService)ServiceGlobal.getService(PSSysPFPITemplService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysPFPITempl> arrayList2 = pSSysPFPITemplService.selectByPSSysPFPlugin(pSSysPFPlugin);
        for (PSSysPFPITempl pSSysPFPITempl : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSSysPFPITempl, (String)"srfsyspub", (int)1) == 0) continue;
            pSSysPFPITemplService.exportModel(pSSysPFPITempl, arrayList, n);
        }
    }

    protected void onExportMajorModel(PSSysPFPlugin pSSysPFPlugin, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysPFPlugin, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXTENDSTYLEONLY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExtendStyleOnly_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"KEYWORDS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Keywords_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PLUGINDESC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PluginDesc_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PLUGINMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PluginModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PLUGINPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PluginParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PLUGINTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PluginTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PLUGINTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PluginTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PLUGINTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PluginType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREVIEWHTML", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PreviewHtml_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREVIEWPSNDFILEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PreviewPSNDFileId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREVIEWURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PreviewUrl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSFILEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysFileId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPFPITEMPLSCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPFPITemplsCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REPDEFAULT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RepDefault_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RTOBJECTMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RTObjectMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RTOBJECTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RTObjectName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RTOBJECTREPO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RTObjectRepo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STUDIOICON", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StudioIcon_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLATEFUNC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TempalteFunc_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLATEMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplateMode_Default(iEntity, bl, bl2);
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
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_DynaModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ExtendStyleOnly_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Keywords_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("KEYWORDS", iEntity, bl2, null, false, 300, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[300]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[300]";
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
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PluginDesc_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PLUGINDESC", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PluginModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PLUGINMODEL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PluginParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PLUGINPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PluginTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PLUGINTAG", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false) && this.checkFieldRegExRule("PLUGINTAG", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PluginTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PLUGINTAG2", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PluginType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PLUGINTYPE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PreviewHtml_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PREVIEWHTML", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PreviewPSNDFileId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PREVIEWPSNDFILEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PreviewUrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PREVIEWURL", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
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

    protected String onTestValueRule_PSPFPluginId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFPLUGINID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFPluginName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFPLUGINNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysFileId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSFILEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysPFPITemplsCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_RepDefault_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_RTObjectMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_RTObjectName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RTOBJECTNAME", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RTObjectRepo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RTOBJECTREPO", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StudioIcon_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STUDIOICON", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TempalteFunc_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEMPLATEFUNC", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TemplateMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        boolean bl = false;
        if ((StringHelper.isNullOrEmpty((String)string) || (StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSPFPITEMPL_PSSYSPFPLUGIN_PSSYSPFPLUGINID", (boolean)true) == 0) && this.onMergeChild_PSSysPFPITempls(pSSysPFPlugin)) {
            bl = true;
        }
        if (super.onMergeChild(string, string2, (IEntity)pSSysPFPlugin)) {
            bl = true;
        }
        return bl;
    }

    protected boolean onMergeChild_PSSysPFPITempls(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        SelectContext selectContext = new SelectContext();
        SelectField selectField = new SelectField();
        selectField.setAlias("PSSYSPFPITEMPLSCNT");
        selectField.setFunc("COUNT");
        selectContext.addSelectField((ISelectField)selectField);
        String string = DataObject.getStringValue((Object)pSSysPFPlugin.getPSSysPFPluginId());
        IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysPFPITemplService", (SessionFactory)this.getSessionFactory());
        selectContext.set("PSSYSPFPLUGINID", (Object)pSSysPFPlugin.getPSSysPFPluginId());
        ArrayList arrayList = null;
        arrayList = string.indexOf("SRFTEMPKEY:") == 0 ? iService.selectTemp((ISelectCond)selectContext) : iService.select((ISelectCond)selectContext);
        if (arrayList.size() == 0) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e");
        }
        IEntity iEntity = (IEntity)arrayList.get(0);
        iEntity.copyTo((IDataObject)pSSysPFPlugin, false);
        return true;
    }

    protected void onUpdateParent(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        super.onUpdateParent((IEntity)pSSysPFPlugin);
    }

    protected void onCopyDetails(PSSysPFPlugin pSSysPFPlugin, Object object) throws Exception {
        PSSysPFPlugin pSSysPFPlugin2 = new PSSysPFPlugin();
        pSSysPFPlugin2.set("PSSYSPFPLUGINID", object);
        String string = DataObject.getStringValue((Object)pSSysPFPlugin.get("PSSYSPFPLUGINID"));
        PSSysPFPITemplService pSSysPFPITemplService = (PSSysPFPITemplService)ServiceGlobal.getService(PSSysPFPITemplService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysPFPITempl> arrayList = pSSysPFPITemplService.selectByPSSysPFPlugin(pSSysPFPlugin2);
        for (PSSysPFPITempl pSSysPFPITempl : arrayList) {
            Object object2 = pSSysPFPITempl.get("PSSYSPFPITEMPLID");
            pSSysPFPITemplService.getDraftFrom((IEntity)pSSysPFPITempl);
            pSSysPFPITemplService.fillParentInfo((IEntity)pSSysPFPITempl, "DER1N", "DER1N_PSSYSPFPITEMPL_PSSYSPFPLUGIN_PSSYSPFPLUGINID", string);
            pSSysPFPITemplService.create(pSSysPFPITempl);
            pSSysPFPITemplService.copyDetails(pSSysPFPITempl, object2);
        }
        super.onCopyDetails((IEntity)pSSysPFPlugin, object);
    }

    @Override
    protected void exportCurXmlModel(PSSysPFPlugin pSSysPFPlugin, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSPFPLUGIN");
        if (!bl) {
            pSSysPFPlugin.setPSSysPFPITemplsCnt(null);
            super.exportCurXmlModel(pSSysPFPlugin, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysPFPlugin pSSysPFPlugin, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysPFPlugin, string);
        objectNode.remove("pssyspfpitemplscnt");
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
            return "DER1N_PSSYSPFPLUGIN_PSMODULE_PSMODULEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSPFPLUGIN_PSSYSTEM_PSSYSTEMID";
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
    public String getModelV2Tag(PSSysPFPlugin pSSysPFPlugin) {
        if (!StringHelper.isNullOrEmpty((String)pSSysPFPlugin.getCodeName())) {
            return pSSysPFPlugin.getCodeName();
        }
        return super.getModelV2Tag(pSSysPFPlugin);
    }

    @Override
    public boolean setModelV2Tag(PSSysPFPlugin pSSysPFPlugin, String string) {
        pSSysPFPlugin.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSMODULEID", "");
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysPFPlugin pSSysPFPlugin, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysPFPlugin.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysPFPlugin, true);
        pSSysPFPlugin.set("CODENAME", string);
        if (this.select(pSSysPFPlugin, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysPFPlugin, true);
        return super.getModelV2Entity(pSSysPFPlugin, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysPFPlugin pSSysPFPlugin, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysPFPlugin, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSSYSPFPITEMPL_PSSYSPFPLUGIN_PSSYSPFPLUGINID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 40;
        }
        return true;
    }

    @Override
    protected void onExportRelatedModelV2(PSSysPFPlugin pSSysPFPlugin, String string, String string2) throws Exception {
        File file = null;
        if (this.isExportRelatedModelV2("DER1N_PSSYSPFPITEMPL_PSSYSPFPLUGIN_PSSYSPFPLUGINID") && (file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSPFPLUGIN#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSSYSPFPITEMPL", (Object)pSSysPFPlugin.getPSSysPFPluginId()))).exists()) {
            PSSysPFPITemplService pSSysPFPITemplService = (PSSysPFPITemplService)ServiceGlobal.getService(PSSysPFPITemplService.class, (SessionFactory)this.getSessionFactory());
            String string3 = pSSysPFPITemplService.getModelV2Name(false);
            String string4 = string + File.separator + string3;
            File file2 = new File(string4);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            ArrayList<String> arrayList = PSModelV2Helper.readFile2(file);
            for (String string5 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string5)) continue;
                ObjectNode objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string5);
                PSSysPFPITempl pSSysPFPITempl = new PSSysPFPITempl();
                PSModelV2Helper.fromJSONObject((IDataObject)pSSysPFPITempl, objectNode, false);
                String string6 = pSSysPFPITemplService.getModelV2Tag(pSSysPFPITempl);
                if (StringHelper.isNullOrEmpty((String)string6)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSSYSPFPITEMPL", (Object)pSSysPFPITempl.getPSSysPFPITemplId()));
                }
                string6 = PSModelV2Helper.getModelV2TagFolderName(string6);
                file2 = new File(string4 + File.separator + string6);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                pSSysPFPITemplService.exportModelV2(pSSysPFPITempl, string4 + File.separator + string6, string2);
            }
        }
        super.onExportRelatedModelV2(pSSysPFPlugin, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSSysPFPlugin pSSysPFPlugin, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSPFPITEMPL_PSSYSPFPLUGIN_PSSYSPFPLUGINID")) {
            Object object;
            PSSysPFPITempl pSSysPFPITempl2;
            Object object2;
            Object object3;
            Object object4;
            PSSysPFPITemplService pSSysPFPITemplService = (PSSysPFPITemplService)ServiceGlobal.getService(PSSysPFPITemplService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<PSSysPFPITempl> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSPFPLUGIN#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSPFPITEMPL", (Object)pSSysPFPlugin.getPSSysPFPluginId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        pSSysPFPITempl2 = (ObjectNode)JsonNodeHelper.fromString((String)object2);
                        arrayList.add(pSSysPFPITempl2);
                    }
                }
            } else {
                arrayList = new ArrayList<PSSysPFPITempl>();
                object4 = pSSysPFPITemplService.selectByPSSysPFPlugin(pSSysPFPlugin);
                object3 = StringHelper.format((String)"PSSYSPFPLUGIN#%1$s", (Object)pSSysPFPlugin.getPSSysPFPluginId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    pSSysPFPITempl2 = object2.next();
                    object = pSSysPFPITemplService.getModelV2ResScope((IEntity)pSSysPFPITempl2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSSysPFPITempl)PSModelV2Helper.toJSONObject((IEntity)pSSysPFPITempl2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSSysPFPITemplService.getModelV2Name(false);
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
                        if (objectNode.has("pssyspfpitemplname")) {
                            string = objectNode.get("pssyspfpitemplname").asText();
                        }
                        if (objectNode2.has("pssyspfpitemplname")) {
                            string2 = objectNode2.get("pssyspfpitemplname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (PSSysPFPITempl pSSysPFPITempl2 : arrayList) {
                    object = new PSSysPFPITempl();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)pSSysPFPITempl2, false);
                    object3.add((JsonNode)pSSysPFPITemplService.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSSysPFPlugin, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        super.onEmptyModelV2(pSSysPFPlugin);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSSysPFPITemplService pSSysPFPITemplService = (PSSysPFPITemplService)ServiceGlobal.getService(PSSysPFPITemplService.class, (SessionFactory)this.getSessionFactory());
        if (pSSysPFPITemplService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSSysPFPlugin pSSysPFPlugin, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSSysPFPITempl pSSysPFPITempl = new PSSysPFPITempl();
        pSSysPFPITempl.set("PSSYSPFPLUGINID", pSSysPFPlugin.getPSSysPFPluginId());
        PSSysPFPITemplService pSSysPFPITemplService = (PSSysPFPITemplService)ServiceGlobal.getService(PSSysPFPITemplService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSSysPFPITemplService.getModelV2Entity(pSSysPFPITempl, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSSysPFPlugin, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSSysPFPlugin pSSysPFPlugin, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (!PSSysPFPluginServiceBase.isSimpleImportExportMode("")) {
            PSSysPFPITemplService pSSysPFPITemplService = (PSSysPFPITemplService)ServiceGlobal.getService(PSSysPFPITemplService.class, (SessionFactory)this.getSessionFactory());
            ArrayNode arrayNode = null;
            String string3 = pSSysPFPITemplService.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                    PSSysPFPITempl pSSysPFPITempl = new PSSysPFPITempl();
                    pSSysPFPITempl.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
                    pSSysPFPITempl.setPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
                    pSSysPFPITemplService.compileModelV2(pSSysPFPITempl, objectNode2, string, null, n);
                }
            } else {
                String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                File file = new File(string4);
                if (file.exists()) {
                    File[] fileArray;
                    for (File file2 : fileArray = file.listFiles()) {
                        if (!file2.isDirectory()) continue;
                        PSSysPFPITempl pSSysPFPITempl = new PSSysPFPITempl();
                        pSSysPFPITempl.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
                        pSSysPFPITempl.setPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
                        pSSysPFPITemplService.compileModelV2(pSSysPFPITempl, null, string, file2.getCanonicalPath(), n);
                    }
                }
            }
        }
        super.onCompileRelatedModelV2(pSSysPFPlugin, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSSysPFPlugin pSSysPFPlugin, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSYSPFPITEMPL_PSSYSPFPLUGIN_PSSYSPFPLUGINID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSysPFPITempls(pSSysPFPlugin, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSSysPFPlugin, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSSysPFPITempls(PSSysPFPlugin pSSysPFPlugin, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSPFPITEMPL", true), (boolean)false) == 0) {
            PSSysPFPITemplService pSSysPFPITemplService = (PSSysPFPITemplService)ServiceGlobal.getService(PSSysPFPITemplService.class, (SessionFactory)this.getSessionFactory());
            PSSysPFPITempl pSSysPFPITempl = new PSSysPFPITempl();
            pSSysPFPITempl.setPSSysPFPITemplId(pSMOSFile.getPSModelId());
            if (!pSSysPFPITemplService.get((IEntity)pSSysPFPITempl, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSysPFPITempl.getPSSysPFPluginId(), (String)pSSysPFPlugin.getPSSysPFPluginId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSysPFPITemplService.exportModelV2(pSSysPFPITempl);
            pSSysPFPITempl.reset();
            if (!pSSysPFPITemplService.setModelV2ResScope((IEntity)pSSysPFPITempl, "PSSYSPFPLUGIN", pSSysPFPlugin.getPSSysPFPluginId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSysPFPITemplService.importModelV2(pSSysPFPITempl, objectNode);
            SessionFactoryManager.commit();
            return pSSysPFPITemplService.getFile((IEntity)pSSysPFPITempl);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSSysPFPlugin pSSysPFPlugin, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSSysPFPITempls(pSSysPFPlugin, list);
        super.onFillPasteHelps(pSSysPFPlugin, list);
    }

    protected void onFillPasteHelps_PSSysPFPITempls(PSSysPFPlugin pSSysPFPlugin, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSPFPITEMPL");
        pSHelpSection.setSectionParam2("DER1N_PSSYSPFPITEMPL_PSSYSPFPLUGIN_PSSYSPFPLUGINID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u524d\u7aef\u6a21\u677f\u63d2\u4ef6]\u7684[\u524d\u7aef\u6a21\u677f\u63d2\u4ef6\u4ee3\u7801]");
        list.add(pSHelpSection);
    }

    @Override
    protected PSMOSFile[] onListDRFolders(PSMOSFile pSMOSFile, String string, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        HashMap<String, PSMOSFile> hashMap = new HashMap<String, PSMOSFile>();
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u63d2\u4ef6\u6a21\u677f>", "DER1N_PSSYSPFPITEMPL_PSSYSPFPLUGIN_PSSYSPFPLUGINID", "PSSYSPFPLUGINID", pSMOSFile.getPSModelId(), "", "")) {
            PSMOSFile pSMOSFile2 = new PSMOSFile();
            if (PSSysPFPluginServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u63d2\u4ef6\u6a21\u677f>");
            } else if (PSSysPFPluginServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("pssyspfpitempls");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSSYSPFPITEMPL_PSSYSPFPLUGIN_PSSYSPFPLUGINID|PSSYSPFPLUGINID");
            pSMOSFile2.setFileTag3("PSSYSPFPITEMPL");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSSYSPFPITEMPL_PSSYSPFPLUGIN_PSSYSPFPLUGINID", "PSSYSPFPLUGINID", pSMOSFile.getPSModelId(), "", "")) {
                PSSysPFPITemplService pSSysPFPITemplService = (PSSysPFPITemplService)ServiceGlobal.getService(PSSysPFPITemplService.class, (SessionFactory)this.getSessionFactory());
                SelectContext selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSSysPFPITemplService, "DER1N_PSSYSPFPITEMPL_PSSYSPFPLUGIN_PSSYSPFPLUGINID", "PSSYSPFPLUGINID", pSMOSFile.getPSModelId(), "", "");
                SelectField selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                ArrayList arrayList = pSSysPFPITemplService.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSSysPFPluginServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
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
        ArrayList<PSMOSFile> arrayList = new ArrayList<PSMOSFile>();
        if (PSSysPFPluginServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u63d2\u4ef6\u6a21\u677f>", (boolean)false) == 0 || PSSysPFPluginServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSSysPFPITempls", (boolean)true) == 0) {
            PSSysPFPITemplService pSSysPFPITemplService = (PSSysPFPITemplService)ServiceGlobal.getService(PSSysPFPITemplService.class, (SessionFactory)this.getSessionFactory());
            SelectContext selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSSysPFPITemplService, "DER1N_PSSYSPFPITEMPL_PSSYSPFPLUGIN_PSSYSPFPLUGINID", "PSSYSPFPLUGINID", pSMOSFile.getPSModelId(), "", "");
            ArrayList arrayList2 = pSSysPFPITemplService.selectEx((ISelectContext)selectContext);
            for (PSSysPFPITempl pSSysPFPITempl : arrayList2) {
                PSMOSFile pSMOSFile2 = pSSysPFPITemplService.getFile(pSMOSFile, (IEntity)pSSysPFPITempl, bl);
                if (pSMOSFile2 == null) continue;
                arrayList.add(pSMOSFile2);
            }
        }
        if (arrayList.size() > 0) {
            return PSMOSFileUtil.append(arrayList.toArray(new PSMOSFile[arrayList.size()]), super.onListDRDataFolders(pSMOSFile, string, string2, iPSMOSFileFilter, bl));
        }
        return super.onListDRDataFolders(pSMOSFile, string, string2, iPSMOSFileFilter, bl);
    }

    @Override
    public String getDRFolderPath(String string, IEntity iEntity, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSSYSPFPITEMPL_PSSYSPFPLUGIN_PSSYSPFPLUGINID", (boolean)false) == 0) {
            if (PSSysPFPluginServiceBase.getMOSVer() == 1) {
                return "<\u63d2\u4ef6\u6a21\u677f>";
            }
            if (PSSysPFPluginServiceBase.getMOSVer() == 2) {
                return "pssyspfpitempls";
            }
        }
        return super.getDRFolderPath(string, iEntity, string2);
    }

    @Override
    public boolean isOutputDRFolders() {
        return true;
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSSysPFPlugin pSSysPFPlugin, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "PFPlugin");
        defaultValueMap.put("PSSYSPFPLUGINNAME", "\u524d\u7aef\u6a21\u677f\u63d2\u4ef6");
    }
}

