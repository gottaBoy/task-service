/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.entity.IEntityActionHelper
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.dedesign.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import javax.persistence.Column;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDTable;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEACMode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAWGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionLogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionWizard;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEChart;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDBCfg;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDBIndex;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDRGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDRItem;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDTSQueue;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataExp;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataImp;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQuery;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataRelation;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSync;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataView;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFInputTipSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFSFItem;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFValueRule;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEForm;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGrid;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEList;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMainState;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMap;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDENotify;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPriv;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPrivRole;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEPrint;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEReport;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEServiceAPI;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETable;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbar;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeView;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUserRole;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUtilDE;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEVRGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEWizard;
import net.ibizsys.pscore.srv.dedesign.service.PSDEACModeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEAWGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionWizardService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDBCfgService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDBIndexService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDTSQueueService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataExpService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataImpService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataQueryService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataRelationService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSyncService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFInputTipSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFSFItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFValueRuleService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMainStateService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMapService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEModelService;
import net.ibizsys.pscore.srv.dedesign.service.PSDENotifyService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivRoleService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEPrintService;
import net.ibizsys.pscore.srv.dedesign.service.PSDERService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEReportService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEServiceAPIService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETableService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeViewService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUserRoleService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUtilDEService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEVRGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardService;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDETempl;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaDETemplService;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpModule;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpResource;
import net.ibizsys.pscore.srv.helpdesign.service.PSHelpModuleService;
import net.ibizsys.pscore.srv.helpdesign.service.PSHelpResourceService;
import net.ibizsys.pscore.srv.search.entity.PSSysSearchDE;
import net.ibizsys.pscore.srv.search.service.PSSysSearchDEService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSACHandler;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlLogicGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDERGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADE;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCounter;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDMItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDMVerItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDashboard;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMapView;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysModelChgLog;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysModelGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSearchBar;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTask;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniState;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUserCase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCtrlLogicGroupService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDERGroupService;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADEService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysServiceAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCounterService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDMItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDMVerItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDashboardService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMapViewService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysModelChgLogService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysModelGroupService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSearchBarService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysTaskService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUniResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUniStateService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUserCaseService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestCase;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestData;
import net.ibizsys.pscore.srv.systest.service.PSSysTestCaseService;
import net.ibizsys.pscore.srv.systest.service.PSSysTestDataService;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFDE;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFDEService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDataEntityBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDataEntityBase.class);
    public static final String FIELD_ACCCTRLARCH = "ACCCTRLARCH";
    public static final String FIELD_AUDITMODE = "AUDITMODE";
    public static final String FIELD_BASECLSPARAMS = "BASECLSPARAMS";
    public static final String FIELD_BIZTAG = "BIZTAG";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CODENAMEMODE = "CODENAMEMODE";
    public static final String FIELD_COLOR = "COLOR";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_CUSTOMMODE = "CUSTOMMODE";
    public static final String FIELD_DATAACCMODE = "DATAACCMODE";
    public static final String FIELD_DATACHGLOGMODE = "DATACHGLOGMODE";
    public static final String FIELD_DATAIMPEXPFLAG = "DATAIMPEXPFLAG";
    public static final String FIELD_DBTABSPACE = "DBTABSPACE";
    public static final String FIELD_DBVER = "DBVER";
    public static final String FIELD_DECAT = "DECAT";
    public static final String FIELD_DEHOLDER = "DEHOLDER";
    public static final String FIELD_DELOCKFLAG = "DELOCKFLAG";
    public static final String FIELD_DESN = "DESN";
    public static final String FIELD_DETAG = "DETAG";
    public static final String FIELD_DETAG2 = "DETAG2";
    public static final String FIELD_DETYPE = "DETYPE";
    public static final String FIELD_DSLINK = "DSLINK";
    public static final String FIELD_DSTPSDEACTIONLOGICSCNT = "DSTPSDEACTIONLOGICSCNT";
    public static final String FIELD_DYNAMICMODE = "DYNAMICMODE";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_DYNATABLEMODE = "DYNATABLEMODE";
    public static final String FIELD_ENABLEAUDIT = "ENABLEAUDIT";
    public static final String FIELD_ENABLEDALOG = "ENABLEDALOG";
    public static final String FIELD_ENABLEDATAVER = "ENABLEDATAVER";
    public static final String FIELD_ENABLEDEACTION = "ENABLEDEACTION";
    public static final String FIELD_ENABLEDEDATASET = "ENABLEDEDATASET";
    public static final String FIELD_ENABLEDYNASYS = "ENABLEDYNASYS";
    public static final String FIELD_ENABLEENTITYCACHE = "ENABLEENTITYCACHE";
    public static final String FIELD_ENABLEMOB = "ENABLEMOB";
    public static final String FIELD_ENABLEMULTIDS = "ENABLEMULTIDS";
    public static final String FIELD_ENABLEOPNAMEMODEL = "ENABLEOPNAMEMODEL";
    public static final String FIELD_ENABLEORGMODEL = "ENABLEORGMODEL";
    public static final String FIELD_ENABLEPQL = "ENABLEPQL";
    public static final String FIELD_ENABLESELECT = "ENABLESELECT";
    public static final String FIELD_ENABLEWFMODEL = "ENABLEWFMODEL";
    public static final String FIELD_ENAMULTIFORM = "ENAMULTIFORM";
    public static final String FIELD_ENATEMPDATA = "ENATEMPDATA";
    public static final String FIELD_ENTITYCACHETIMEOUT = "ENTITYCACHETIMEOUT";
    public static final String FIELD_EXISTINGMODEL = "EXISTINGMODEL";
    public static final String FIELD_EXTABLENAME = "EXTABLENAME";
    public static final String FIELD_INDEXDETYPE = "INDEXDETYPE";
    public static final String FIELD_KEYRULE = "KEYRULE";
    public static final String FIELD_LNPSLANRESID = "LNPSLANRESID";
    public static final String FIELD_LNPSLANRESNAME = "LNPSLANRESNAME";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_LOGICINVALIDVALUE = "LOGICINVALIDVALUE";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_LOGICVALID = "LOGICVALID";
    public static final String FIELD_LOGICVALIDVALUE = "LOGICVALIDVALUE";
    public static final String FIELD_MAJORPSDERSCNT = "MAJORPSDERSCNT";
    public static final String FIELD_MAXENTITYCACHECNT = "MAXENTITYCACHECNT";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MINORPSDERSCNT = "MINORPSDERSCNT";
    public static final String FIELD_MODCOLOR = "MODCOLOR";
    public static final String FIELD_MODELIMPEXPFLAG = "MODELIMPEXPFLAG";
    public static final String FIELD_MODELSTATE = "MODELSTATE";
    public static final String FIELD_MODELVER = "MODELVER";
    public static final String FIELD_MSACTIONLOGICFLAG = "MSACTIONLOGICFLAG";
    public static final String FIELD_NOVIEWMODE = "NOVIEWMODE";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSACHANDLERSCNT = "PSACHANDLERSCNT";
    public static final String FIELD_PSCODELISTSCNT = "PSCODELISTSCNT";
    public static final String FIELD_PSDATAENTITYID = "PSDATAENTITYID";
    public static final String FIELD_PSDATAENTITYNAME = "PSDATAENTITYNAME";
    public static final String FIELD_PSDEACMODESCNT = "PSDEACMODESCNT";
    public static final String FIELD_PSDEACTIONLOGICSCNT = "PSDEACTIONLOGICSCNT";
    public static final String FIELD_PSDEACTIONSCNT = "PSDEACTIONSCNT";
    public static final String FIELD_PSDEAWGRPSCNT = "PSDEAWGRPSCNT";
    public static final String FIELD_PSDEAWSCNT = "PSDEAWSCNT";
    public static final String FIELD_PSDECHARTSCNT = "PSDECHARTSCNT";
    public static final String FIELD_PSDEDATAEXPSCNT = "PSDEDATAEXPSCNT";
    public static final String FIELD_PSDEDATAIMPSCNT = "PSDEDATAIMPSCNT";
    public static final String FIELD_PSDEDATAQUERYSCNT = "PSDEDATAQUERYSCNT";
    public static final String FIELD_PSDEDATARELATIONSCNT = "PSDEDATARELATIONSCNT";
    public static final String FIELD_PSDEDATASETSCNT = "PSDEDATASETSCNT";
    public static final String FIELD_PSDEDATASYNCSCNT = "PSDEDATASYNCSCNT";
    public static final String FIELD_PSDEDATAVIEWSCNT = "PSDEDATAVIEWSCNT";
    public static final String FIELD_PSDEDBCFGSCNT = "PSDEDBCFGSCNT";
    public static final String FIELD_PSDEDBINDEXSCNT = "PSDEDBINDEXSCNT";
    public static final String FIELD_PSDEDRGROUPSCNT = "PSDEDRGROUPSCNT";
    public static final String FIELD_PSDEDRITEMSCNT = "PSDEDRITEMSCNT";
    public static final String FIELD_PSDEDTSQUEUESCNT = "PSDEDTSQUEUESCNT";
    public static final String FIELD_PSDEFIELDSCNT = "PSDEFIELDSCNT";
    public static final String FIELD_PSDEFINPUTTIPSETID = "PSDEFINPUTTIPSETID";
    public static final String FIELD_PSDEFINPUTTIPSETNAME = "PSDEFINPUTTIPSETNAME";
    public static final String FIELD_PSDEFORMSCNT = "PSDEFORMSCNT";
    public static final String FIELD_PSDEFSFITEMSCNT = "PSDEFSFITEMSCNT";
    public static final String FIELD_PSDEFVALUERULESCNT = "PSDEFVALUERULESCNT";
    public static final String FIELD_PSDEGRIDSCNT = "PSDEGRIDSCNT";
    public static final String FIELD_PSDELISTSCNT = "PSDELISTSCNT";
    public static final String FIELD_PSDELOGICSCNT = "PSDELOGICSCNT";
    public static final String FIELD_PSDEMAINSTATESCNT = "PSDEMAINSTATESCNT";
    public static final String FIELD_PSDEOPPRIVROLESCNT = "PSDEOPPRIVROLESCNT";
    public static final String FIELD_PSDEOPPRIVSCNT = "PSDEOPPRIVSCNT";
    public static final String FIELD_PSDEPRINTSCNT = "PSDEPRINTSCNT";
    public static final String FIELD_PSDEREPORTSCNT = "PSDEREPORTSCNT";
    public static final String FIELD_PSDESERVICEAPISCNT = "PSDESERVICEAPISCNT";
    public static final String FIELD_PSDETOOLBARSCNT = "PSDETOOLBARSCNT";
    public static final String FIELD_PSDETREEVIEWSCNT = "PSDETREEVIEWSCNT";
    public static final String FIELD_PSDEUAGROUPSCNT = "PSDEUAGROUPSCNT";
    public static final String FIELD_PSDEUIACTIONSCNT = "PSDEUIACTIONSCNT";
    public static final String FIELD_PSDEUSERROLESCNT = "PSDEUSERROLESCNT";
    public static final String FIELD_PSDEVIEWBASESCNT = "PSDEVIEWBASESCNT";
    public static final String FIELD_PSDEWIZARDSCNT = "PSDEWIZARDSCNT";
    public static final String FIELD_PSDYNADETEMPLID = "PSDYNADETEMPLID";
    public static final String FIELD_PSDYNADETEMPLNAME = "PSDYNADETEMPLNAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSHELPMODULEID = "PSHELPMODULEID";
    public static final String FIELD_PSHELPMODULENAME = "PSHELPMODULENAME";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSUBSYSSADEID = "PSSUBSYSSADEID";
    public static final String FIELD_PSSUBSYSSADENAME = "PSSUBSYSSADENAME";
    public static final String FIELD_PSSUBSYSSERVICEAPIID = "PSSUBSYSSERVICEAPIID";
    public static final String FIELD_PSSUBSYSSERVICEAPINAME = "PSSUBSYSSERVICEAPINAME";
    public static final String FIELD_PSSYSBDTABLESCNT = "PSSYSBDTABLESCNT";
    public static final String FIELD_PSSYSCOUNTERSCNT = "PSSYSCOUNTERSCNT";
    public static final String FIELD_PSSYSDMITEMSCNT = "PSSYSDMITEMSCNT";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String FIELD_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String FIELD_PSSYSMODELCHGLOGSCNT = "PSSYSMODELCHGLOGSCNT";
    public static final String FIELD_PSSYSMODELGROUPID = "PSSYSMODELGROUPID";
    public static final String FIELD_PSSYSMODELGROUPNAME = "PSSYSMODELGROUPNAME";
    public static final String FIELD_PSSYSREQITEMID = "PSSYSREQITEMID";
    public static final String FIELD_PSSYSREQITEMNAME = "PSSYSREQITEMNAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_PSSYSTASKSCNT = "PSSYSTASKSCNT";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSSYSTESTCASESCNT = "PSSYSTESTCASESCNT";
    public static final String FIELD_PSSYSTESTDATASCNT = "PSSYSTESTDATASCNT";
    public static final String FIELD_PSSYSUNIRESID = "PSSYSUNIRESID";
    public static final String FIELD_PSSYSUNIRESNAME = "PSSYSUNIRESNAME";
    public static final String FIELD_PSWFDESCNT = "PSWFDESCNT";
    public static final String FIELD_READONLYMODE = "READONLYMODE";
    public static final String FIELD_REMOVEFLAG = "REMOVEFLAG";
    public static final String FIELD_SAASMODE = "SAASMODE";
    public static final String FIELD_SERVICEAPIFLAG = "SERVICEAPIFLAG";
    public static final String FIELD_SERVICECODENAME = "SERVICECODENAME";
    public static final String FIELD_SRCPSDEMAPSCNT = "SRCPSDEMAPSCNT";
    public static final String FIELD_STORAGEMODE = "STORAGEMODE";
    public static final String FIELD_SUBSYSDE = "SUBSYSDE";
    public static final String FIELD_SUBSYSMODULE = "SUBSYSMODULE";
    public static final String FIELD_SVRPUBMODE = "SVRPUBMODE";
    public static final String FIELD_SYSTEMFLAG = "SYSTEMFLAG";
    public static final String FIELD_TABLENAME = "TABLENAME";
    public static final String FIELD_TESTCASEFLAG = "TESTCASEFLAG";
    public static final String FIELD_TODOTASK = "TODOTASK";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERACTION = "USERACTION";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_VIEWLEVEL = "VIEWLEVEL";
    public static final String FIELD_VIEWNAME = "VIEWNAME";
    public static final String FIELD_VIEWNAME2 = "VIEWNAME2";
    public static final String FIELD_VIEWNAME3 = "VIEWNAME3";
    public static final String FIELD_VIEWNAME4 = "VIEWNAME4";
    public static final String FIELD_VIRTUALFLAG = "VIRTUALFLAG";
    public static final String FIELD_VKEYSEPARATOR = "VKEYSEPARATOR";
    private static final int INDEX_ACCCTRLARCH = 0;
    private static final int INDEX_AUDITMODE = 1;
    private static final int INDEX_BASECLSPARAMS = 2;
    private static final int INDEX_BIZTAG = 3;
    private static final int INDEX_CODENAME = 4;
    private static final int INDEX_CODENAMEMODE = 5;
    private static final int INDEX_COLOR = 6;
    private static final int INDEX_CREATEDATE = 7;
    private static final int INDEX_CREATEMAN = 8;
    private static final int INDEX_CUSTOMCODE = 9;
    private static final int INDEX_CUSTOMMODE = 10;
    private static final int INDEX_DATAACCMODE = 11;
    private static final int INDEX_DATACHGLOGMODE = 12;
    private static final int INDEX_DATAIMPEXPFLAG = 13;
    private static final int INDEX_DBTABSPACE = 14;
    private static final int INDEX_DBVER = 15;
    private static final int INDEX_DECAT = 16;
    private static final int INDEX_DEHOLDER = 17;
    private static final int INDEX_DELOCKFLAG = 18;
    private static final int INDEX_DESN = 19;
    private static final int INDEX_DETAG = 20;
    private static final int INDEX_DETAG2 = 21;
    private static final int INDEX_DETYPE = 22;
    private static final int INDEX_DSLINK = 23;
    private static final int INDEX_DSTPSDEACTIONLOGICSCNT = 24;
    private static final int INDEX_DYNAMICMODE = 25;
    private static final int INDEX_DYNAMODELFLAG = 26;
    private static final int INDEX_DYNATABLEMODE = 27;
    private static final int INDEX_ENABLEAUDIT = 28;
    private static final int INDEX_ENABLEDALOG = 29;
    private static final int INDEX_ENABLEDATAVER = 30;
    private static final int INDEX_ENABLEDEACTION = 31;
    private static final int INDEX_ENABLEDEDATASET = 32;
    private static final int INDEX_ENABLEDYNASYS = 33;
    private static final int INDEX_ENABLEENTITYCACHE = 34;
    private static final int INDEX_ENABLEMOB = 35;
    private static final int INDEX_ENABLEMULTIDS = 36;
    private static final int INDEX_ENABLEOPNAMEMODEL = 37;
    private static final int INDEX_ENABLEORGMODEL = 38;
    private static final int INDEX_ENABLEPQL = 39;
    private static final int INDEX_ENABLESELECT = 40;
    private static final int INDEX_ENABLEWFMODEL = 41;
    private static final int INDEX_ENAMULTIFORM = 42;
    private static final int INDEX_ENATEMPDATA = 43;
    private static final int INDEX_ENTITYCACHETIMEOUT = 44;
    private static final int INDEX_EXISTINGMODEL = 45;
    private static final int INDEX_EXTABLENAME = 46;
    private static final int INDEX_INDEXDETYPE = 47;
    private static final int INDEX_KEYRULE = 48;
    private static final int INDEX_LNPSLANRESID = 49;
    private static final int INDEX_LNPSLANRESNAME = 50;
    private static final int INDEX_LOCKFLAG = 51;
    private static final int INDEX_LOGICINVALIDVALUE = 52;
    private static final int INDEX_LOGICNAME = 53;
    private static final int INDEX_LOGICVALID = 54;
    private static final int INDEX_LOGICVALIDVALUE = 55;
    private static final int INDEX_MAJORPSDERSCNT = 56;
    private static final int INDEX_MAXENTITYCACHECNT = 57;
    private static final int INDEX_MEMO = 58;
    private static final int INDEX_MINORPSDERSCNT = 59;
    private static final int INDEX_MODCOLOR = 60;
    private static final int INDEX_MODELIMPEXPFLAG = 61;
    private static final int INDEX_MODELSTATE = 62;
    private static final int INDEX_MODELVER = 63;
    private static final int INDEX_MSACTIONLOGICFLAG = 64;
    private static final int INDEX_NOVIEWMODE = 65;
    private static final int INDEX_ORDERVALUE = 66;
    private static final int INDEX_PSACHANDLERSCNT = 67;
    private static final int INDEX_PSCODELISTSCNT = 68;
    private static final int INDEX_PSDATAENTITYID = 69;
    private static final int INDEX_PSDATAENTITYNAME = 70;
    private static final int INDEX_PSDEACMODESCNT = 71;
    private static final int INDEX_PSDEACTIONLOGICSCNT = 72;
    private static final int INDEX_PSDEACTIONSCNT = 73;
    private static final int INDEX_PSDEAWGRPSCNT = 74;
    private static final int INDEX_PSDEAWSCNT = 75;
    private static final int INDEX_PSDECHARTSCNT = 76;
    private static final int INDEX_PSDEDATAEXPSCNT = 77;
    private static final int INDEX_PSDEDATAIMPSCNT = 78;
    private static final int INDEX_PSDEDATAQUERYSCNT = 79;
    private static final int INDEX_PSDEDATARELATIONSCNT = 80;
    private static final int INDEX_PSDEDATASETSCNT = 81;
    private static final int INDEX_PSDEDATASYNCSCNT = 82;
    private static final int INDEX_PSDEDATAVIEWSCNT = 83;
    private static final int INDEX_PSDEDBCFGSCNT = 84;
    private static final int INDEX_PSDEDBINDEXSCNT = 85;
    private static final int INDEX_PSDEDRGROUPSCNT = 86;
    private static final int INDEX_PSDEDRITEMSCNT = 87;
    private static final int INDEX_PSDEDTSQUEUESCNT = 88;
    private static final int INDEX_PSDEFIELDSCNT = 89;
    private static final int INDEX_PSDEFINPUTTIPSETID = 90;
    private static final int INDEX_PSDEFINPUTTIPSETNAME = 91;
    private static final int INDEX_PSDEFORMSCNT = 92;
    private static final int INDEX_PSDEFSFITEMSCNT = 93;
    private static final int INDEX_PSDEFVALUERULESCNT = 94;
    private static final int INDEX_PSDEGRIDSCNT = 95;
    private static final int INDEX_PSDELISTSCNT = 96;
    private static final int INDEX_PSDELOGICSCNT = 97;
    private static final int INDEX_PSDEMAINSTATESCNT = 98;
    private static final int INDEX_PSDEOPPRIVROLESCNT = 99;
    private static final int INDEX_PSDEOPPRIVSCNT = 100;
    private static final int INDEX_PSDEPRINTSCNT = 101;
    private static final int INDEX_PSDEREPORTSCNT = 102;
    private static final int INDEX_PSDESERVICEAPISCNT = 103;
    private static final int INDEX_PSDETOOLBARSCNT = 104;
    private static final int INDEX_PSDETREEVIEWSCNT = 105;
    private static final int INDEX_PSDEUAGROUPSCNT = 106;
    private static final int INDEX_PSDEUIACTIONSCNT = 107;
    private static final int INDEX_PSDEUSERROLESCNT = 108;
    private static final int INDEX_PSDEVIEWBASESCNT = 109;
    private static final int INDEX_PSDEWIZARDSCNT = 110;
    private static final int INDEX_PSDYNADETEMPLID = 111;
    private static final int INDEX_PSDYNADETEMPLNAME = 112;
    private static final int INDEX_PSDYNAINSTID = 113;
    private static final int INDEX_PSHELPMODULEID = 114;
    private static final int INDEX_PSHELPMODULENAME = 115;
    private static final int INDEX_PSMODULEID = 116;
    private static final int INDEX_PSMODULENAME = 117;
    private static final int INDEX_PSSUBSYSSADEID = 118;
    private static final int INDEX_PSSUBSYSSADENAME = 119;
    private static final int INDEX_PSSUBSYSSERVICEAPIID = 120;
    private static final int INDEX_PSSUBSYSSERVICEAPINAME = 121;
    private static final int INDEX_PSSYSBDTABLESCNT = 122;
    private static final int INDEX_PSSYSCOUNTERSCNT = 123;
    private static final int INDEX_PSSYSDMITEMSCNT = 124;
    private static final int INDEX_PSSYSDYNAMODELID = 125;
    private static final int INDEX_PSSYSDYNAMODELNAME = 126;
    private static final int INDEX_PSSYSIMAGEID = 127;
    private static final int INDEX_PSSYSIMAGENAME = 128;
    private static final int INDEX_PSSYSMODELCHGLOGSCNT = 129;
    private static final int INDEX_PSSYSMODELGROUPID = 130;
    private static final int INDEX_PSSYSMODELGROUPNAME = 131;
    private static final int INDEX_PSSYSREQITEMID = 132;
    private static final int INDEX_PSSYSREQITEMNAME = 133;
    private static final int INDEX_PSSYSSFPLUGINID = 134;
    private static final int INDEX_PSSYSSFPLUGINNAME = 135;
    private static final int INDEX_PSSYSTASKSCNT = 136;
    private static final int INDEX_PSSYSTEMID = 137;
    private static final int INDEX_PSSYSTEMNAME = 138;
    private static final int INDEX_PSSYSTESTCASESCNT = 139;
    private static final int INDEX_PSSYSTESTDATASCNT = 140;
    private static final int INDEX_PSSYSUNIRESID = 141;
    private static final int INDEX_PSSYSUNIRESNAME = 142;
    private static final int INDEX_PSWFDESCNT = 143;
    private static final int INDEX_READONLYMODE = 144;
    private static final int INDEX_REMOVEFLAG = 145;
    private static final int INDEX_SAASMODE = 146;
    private static final int INDEX_SERVICEAPIFLAG = 147;
    private static final int INDEX_SERVICECODENAME = 148;
    private static final int INDEX_SRCPSDEMAPSCNT = 149;
    private static final int INDEX_STORAGEMODE = 150;
    private static final int INDEX_SUBSYSDE = 151;
    private static final int INDEX_SUBSYSMODULE = 152;
    private static final int INDEX_SVRPUBMODE = 153;
    private static final int INDEX_SYSTEMFLAG = 154;
    private static final int INDEX_TABLENAME = 155;
    private static final int INDEX_TESTCASEFLAG = 156;
    private static final int INDEX_TODOTASK = 157;
    private static final int INDEX_UPDATEDATE = 158;
    private static final int INDEX_UPDATEMAN = 159;
    private static final int INDEX_USERACTION = 160;
    private static final int INDEX_USERCAT = 161;
    private static final int INDEX_USERPARAMS = 162;
    private static final int INDEX_USERTAG = 163;
    private static final int INDEX_USERTAG2 = 164;
    private static final int INDEX_USERTAG3 = 165;
    private static final int INDEX_USERTAG4 = 166;
    private static final int INDEX_VALIDFLAG = 167;
    private static final int INDEX_VIEWLEVEL = 168;
    private static final int INDEX_VIEWNAME = 169;
    private static final int INDEX_VIEWNAME2 = 170;
    private static final int INDEX_VIEWNAME3 = 171;
    private static final int INDEX_VIEWNAME4 = 172;
    private static final int INDEX_VIRTUALFLAG = 173;
    private static final int INDEX_VKEYSEPARATOR = 174;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDataEntityBase proxyPSDataEntityBase = null;
    private boolean accctrlarchDirtyFlag = false;
    private boolean auditmodeDirtyFlag = false;
    private boolean baseclsparamsDirtyFlag = false;
    private boolean biztagDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean codenamemodeDirtyFlag = false;
    private boolean colorDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean custommodeDirtyFlag = false;
    private boolean dataaccmodeDirtyFlag = false;
    private boolean datachglogmodeDirtyFlag = false;
    private boolean dataimpexpflagDirtyFlag = false;
    private boolean dbtabspaceDirtyFlag = false;
    private boolean dbverDirtyFlag = false;
    private boolean decatDirtyFlag = false;
    private boolean deholderDirtyFlag = false;
    private boolean delockflagDirtyFlag = false;
    private boolean desnDirtyFlag = false;
    private boolean detagDirtyFlag = false;
    private boolean detag2DirtyFlag = false;
    private boolean detypeDirtyFlag = false;
    private boolean dslinkDirtyFlag = false;
    private boolean dstpsdeactionlogicscntDirtyFlag = false;
    private boolean dynamicmodeDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean dynatablemodeDirtyFlag = false;
    private boolean enableauditDirtyFlag = false;
    private boolean enabledalogDirtyFlag = false;
    private boolean enabledataverDirtyFlag = false;
    private boolean enabledeactionDirtyFlag = false;
    private boolean enablededatasetDirtyFlag = false;
    private boolean enabledynasysDirtyFlag = false;
    private boolean enableentitycacheDirtyFlag = false;
    private boolean enablemobDirtyFlag = false;
    private boolean enablemultidsDirtyFlag = false;
    private boolean enableopnamemodelDirtyFlag = false;
    private boolean enableorgmodelDirtyFlag = false;
    private boolean enablepqlDirtyFlag = false;
    private boolean enableselectDirtyFlag = false;
    private boolean enablewfmodelDirtyFlag = false;
    private boolean enamultiformDirtyFlag = false;
    private boolean enatempdataDirtyFlag = false;
    private boolean entitycachetimeoutDirtyFlag = false;
    private boolean existingmodelDirtyFlag = false;
    private boolean extablenameDirtyFlag = false;
    private boolean indexdetypeDirtyFlag = false;
    private boolean keyruleDirtyFlag = false;
    private boolean lnpslanresidDirtyFlag = false;
    private boolean lnpslanresnameDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean logicinvalidvalueDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean logicvalidDirtyFlag = false;
    private boolean logicvalidvalueDirtyFlag = false;
    private boolean majorpsderscntDirtyFlag = false;
    private boolean maxentitycachecntDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean minorpsderscntDirtyFlag = false;
    private boolean modcolorDirtyFlag = false;
    private boolean modelimpexpflagDirtyFlag = false;
    private boolean modelstateDirtyFlag = false;
    private boolean modelverDirtyFlag = false;
    private boolean msactionlogicflagDirtyFlag = false;
    private boolean noviewmodeDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psachandlerscntDirtyFlag = false;
    private boolean pscodelistscntDirtyFlag = false;
    private boolean psdataentityidDirtyFlag = false;
    private boolean psdataentitynameDirtyFlag = false;
    private boolean psdeacmodescntDirtyFlag = false;
    private boolean psdeactionlogicscntDirtyFlag = false;
    private boolean psdeactionscntDirtyFlag = false;
    private boolean psdeawgrpscntDirtyFlag = false;
    private boolean psdeawscntDirtyFlag = false;
    private boolean psdechartscntDirtyFlag = false;
    private boolean psdedataexpscntDirtyFlag = false;
    private boolean psdedataimpscntDirtyFlag = false;
    private boolean psdedataqueryscntDirtyFlag = false;
    private boolean psdedatarelationscntDirtyFlag = false;
    private boolean psdedatasetscntDirtyFlag = false;
    private boolean psdedatasyncscntDirtyFlag = false;
    private boolean psdedataviewscntDirtyFlag = false;
    private boolean psdedbcfgscntDirtyFlag = false;
    private boolean psdedbindexscntDirtyFlag = false;
    private boolean psdedrgroupscntDirtyFlag = false;
    private boolean psdedritemscntDirtyFlag = false;
    private boolean psdedtsqueuescntDirtyFlag = false;
    private boolean psdefieldscntDirtyFlag = false;
    private boolean psdefinputtipsetidDirtyFlag = false;
    private boolean psdefinputtipsetnameDirtyFlag = false;
    private boolean psdeformscntDirtyFlag = false;
    private boolean psdefsfitemscntDirtyFlag = false;
    private boolean psdefvaluerulescntDirtyFlag = false;
    private boolean psdegridscntDirtyFlag = false;
    private boolean psdelistscntDirtyFlag = false;
    private boolean psdelogicscntDirtyFlag = false;
    private boolean psdemainstatescntDirtyFlag = false;
    private boolean psdeopprivrolescntDirtyFlag = false;
    private boolean psdeopprivscntDirtyFlag = false;
    private boolean psdeprintscntDirtyFlag = false;
    private boolean psdereportscntDirtyFlag = false;
    private boolean psdeserviceapiscntDirtyFlag = false;
    private boolean psdetoolbarscntDirtyFlag = false;
    private boolean psdetreeviewscntDirtyFlag = false;
    private boolean psdeuagroupscntDirtyFlag = false;
    private boolean psdeuiactionscntDirtyFlag = false;
    private boolean psdeuserrolescntDirtyFlag = false;
    private boolean psdeviewbasescntDirtyFlag = false;
    private boolean psdewizardscntDirtyFlag = false;
    private boolean psdynadetemplidDirtyFlag = false;
    private boolean psdynadetemplnameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pshelpmoduleidDirtyFlag = false;
    private boolean pshelpmodulenameDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssubsyssadeidDirtyFlag = false;
    private boolean pssubsyssadenameDirtyFlag = false;
    private boolean pssubsysserviceapiidDirtyFlag = false;
    private boolean pssubsysserviceapinameDirtyFlag = false;
    private boolean pssysbdtablescntDirtyFlag = false;
    private boolean pssyscounterscntDirtyFlag = false;
    private boolean pssysdmitemscntDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssysimageidDirtyFlag = false;
    private boolean pssysimagenameDirtyFlag = false;
    private boolean pssysmodelchglogscntDirtyFlag = false;
    private boolean pssysmodelgroupidDirtyFlag = false;
    private boolean pssysmodelgroupnameDirtyFlag = false;
    private boolean pssysreqitemidDirtyFlag = false;
    private boolean pssysreqitemnameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean pssystaskscntDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean pssystestcasescntDirtyFlag = false;
    private boolean pssystestdatascntDirtyFlag = false;
    private boolean pssysuniresidDirtyFlag = false;
    private boolean pssysuniresnameDirtyFlag = false;
    private boolean pswfdescntDirtyFlag = false;
    private boolean readonlymodeDirtyFlag = false;
    private boolean removeflagDirtyFlag = false;
    private boolean saasmodeDirtyFlag = false;
    private boolean serviceapiflagDirtyFlag = false;
    private boolean servicecodenameDirtyFlag = false;
    private boolean srcpsdemapscntDirtyFlag = false;
    private boolean storagemodeDirtyFlag = false;
    private boolean subsysdeDirtyFlag = false;
    private boolean subsysmoduleDirtyFlag = false;
    private boolean svrpubmodeDirtyFlag = false;
    private boolean systemflagDirtyFlag = false;
    private boolean tablenameDirtyFlag = false;
    private boolean testcaseflagDirtyFlag = false;
    private boolean todotaskDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean useractionDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean viewlevelDirtyFlag = false;
    private boolean viewnameDirtyFlag = false;
    private boolean viewname2DirtyFlag = false;
    private boolean viewname3DirtyFlag = false;
    private boolean viewname4DirtyFlag = false;
    private boolean virtualflagDirtyFlag = false;
    private boolean vkeyseparatorDirtyFlag = false;
    @Column(name="accctrlarch")
    private Integer accctrlarch;
    @Column(name="auditmode")
    private Integer auditmode;
    @Column(name="baseclsparams")
    private String baseclsparams;
    @Column(name="biztag")
    private String biztag;
    @Column(name="codename")
    private String codename;
    @Column(name="codenamemode")
    private String codenamemode;
    @Column(name="color")
    private String color;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customcode")
    private String customcode;
    @Column(name="custommode")
    private Integer custommode;
    @Column(name="dataaccmode")
    private Integer dataaccmode;
    @Column(name="datachglogmode")
    private Integer datachglogmode;
    @Column(name="dataimpexpflag")
    private Integer dataimpexpflag;
    @Column(name="dbtabspace")
    private String dbtabspace;
    @Column(name="dbver")
    private Integer dbver;
    @Column(name="decat")
    private String decat;
    @Column(name="deholder")
    private Integer deholder;
    @Column(name="delockflag")
    private Integer delockflag;
    @Column(name="desn")
    private String desn;
    @Column(name="detag")
    private String detag;
    @Column(name="detag2")
    private String detag2;
    @Column(name="detype")
    private Integer detype;
    @Column(name="dslink")
    private String dslink;
    @Column(name="dstpsdeactionlogicscnt")
    private Integer dstpsdeactionlogicscnt;
    @Column(name="dynamicmode")
    private Integer dynamicmode;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="dynatablemode")
    private Integer dynatablemode;
    @Column(name="enableaudit")
    private Integer enableaudit;
    @Column(name="enabledalog")
    private Integer enabledalog;
    @Column(name="enabledataver")
    private Integer enabledataver;
    @Column(name="enabledeaction")
    private Integer enabledeaction;
    @Column(name="enablededataset")
    private Integer enablededataset;
    @Column(name="enabledynasys")
    private Integer enabledynasys;
    @Column(name="enableentitycache")
    private Integer enableentitycache;
    @Column(name="enablemob")
    private Integer enablemob;
    @Column(name="enablemultids")
    private Integer enablemultids;
    @Column(name="enableopnamemodel")
    private Integer enableopnamemodel;
    @Column(name="enableorgmodel")
    private Integer enableorgmodel;
    @Column(name="enablepql")
    private Integer enablepql;
    @Column(name="enableselect")
    private Integer enableselect;
    @Column(name="enablewfmodel")
    private Integer enablewfmodel;
    @Column(name="enamultiform")
    private Integer enamultiform;
    @Column(name="enatempdata")
    private Integer enatempdata;
    @Column(name="entitycachetimeout")
    private Integer entitycachetimeout;
    @Column(name="existingmodel")
    private Integer existingmodel;
    @Column(name="extablename")
    private String extablename;
    @Column(name="indexdetype")
    private String indexdetype;
    @Column(name="keyrule")
    private String keyrule;
    @Column(name="lnpslanresid")
    private String lnpslanresid;
    @Column(name="lnpslanresname")
    private String lnpslanresname;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="logicinvalidvalue")
    private String logicinvalidvalue;
    @Column(name="logicname")
    private String logicname;
    @Column(name="logicvalid")
    private Integer logicvalid;
    @Column(name="logicvalidvalue")
    private String logicvalidvalue;
    @Column(name="majorpsderscnt")
    private Integer majorpsderscnt;
    @Column(name="maxentitycachecnt")
    private Integer maxentitycachecnt;
    @Column(name="memo")
    private String memo;
    @Column(name="minorpsderscnt")
    private Integer minorpsderscnt;
    @Column(name="modcolor")
    private String modcolor;
    @Column(name="modelimpexpflag")
    private Integer modelimpexpflag;
    @Column(name="modelstate")
    private Integer modelstate;
    @Column(name="modelver")
    private Integer modelver;
    @Column(name="msactionlogicflag")
    private Integer msactionlogicflag;
    @Column(name="noviewmode")
    private Integer noviewmode;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psachandlerscnt")
    private Integer psachandlerscnt;
    @Column(name="pscodelistscnt")
    private Integer pscodelistscnt;
    @Column(name="psdataentityid")
    private String psdataentityid;
    @Column(name="psdataentityname")
    private String psdataentityname;
    @Column(name="psdeacmodescnt")
    private Integer psdeacmodescnt;
    @Column(name="psdeactionlogicscnt")
    private Integer psdeactionlogicscnt;
    @Column(name="psdeactionscnt")
    private Integer psdeactionscnt;
    @Column(name="psdeawgrpscnt")
    private Integer psdeawgrpscnt;
    @Column(name="psdeawscnt")
    private Integer psdeawscnt;
    @Column(name="psdechartscnt")
    private Integer psdechartscnt;
    @Column(name="psdedataexpscnt")
    private Integer psdedataexpscnt;
    @Column(name="psdedataimpscnt")
    private Integer psdedataimpscnt;
    @Column(name="psdedataqueryscnt")
    private Integer psdedataqueryscnt;
    @Column(name="psdedatarelationscnt")
    private Integer psdedatarelationscnt;
    @Column(name="psdedatasetscnt")
    private Integer psdedatasetscnt;
    @Column(name="psdedatasyncscnt")
    private Integer psdedatasyncscnt;
    @Column(name="psdedataviewscnt")
    private Integer psdedataviewscnt;
    @Column(name="psdedbcfgscnt")
    private Integer psdedbcfgscnt;
    @Column(name="psdedbindexscnt")
    private Integer psdedbindexscnt;
    @Column(name="psdedrgroupscnt")
    private Integer psdedrgroupscnt;
    @Column(name="psdedritemscnt")
    private Integer psdedritemscnt;
    @Column(name="psdedtsqueuescnt")
    private Integer psdedtsqueuescnt;
    @Column(name="psdefieldscnt")
    private Integer psdefieldscnt;
    @Column(name="psdefinputtipsetid")
    private String psdefinputtipsetid;
    @Column(name="psdefinputtipsetname")
    private String psdefinputtipsetname;
    @Column(name="psdeformscnt")
    private Integer psdeformscnt;
    @Column(name="psdefsfitemscnt")
    private Integer psdefsfitemscnt;
    @Column(name="psdefvaluerulescnt")
    private Integer psdefvaluerulescnt;
    @Column(name="psdegridscnt")
    private Integer psdegridscnt;
    @Column(name="psdelistscnt")
    private Integer psdelistscnt;
    @Column(name="psdelogicscnt")
    private Integer psdelogicscnt;
    @Column(name="psdemainstatescnt")
    private Integer psdemainstatescnt;
    @Column(name="psdeopprivrolescnt")
    private Integer psdeopprivrolescnt;
    @Column(name="psdeopprivscnt")
    private Integer psdeopprivscnt;
    @Column(name="psdeprintscnt")
    private Integer psdeprintscnt;
    @Column(name="psdereportscnt")
    private Integer psdereportscnt;
    @Column(name="psdeserviceapiscnt")
    private Integer psdeserviceapiscnt;
    @Column(name="psdetoolbarscnt")
    private Integer psdetoolbarscnt;
    @Column(name="psdetreeviewscnt")
    private Integer psdetreeviewscnt;
    @Column(name="psdeuagroupscnt")
    private Integer psdeuagroupscnt;
    @Column(name="psdeuiactionscnt")
    private Integer psdeuiactionscnt;
    @Column(name="psdeuserrolescnt")
    private Integer psdeuserrolescnt;
    @Column(name="psdeviewbasescnt")
    private Integer psdeviewbasescnt;
    @Column(name="psdewizardscnt")
    private Integer psdewizardscnt;
    @Column(name="psdynadetemplid")
    private String psdynadetemplid;
    @Column(name="psdynadetemplname")
    private String psdynadetemplname;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="pshelpmoduleid")
    private String pshelpmoduleid;
    @Column(name="pshelpmodulename")
    private String pshelpmodulename;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssubsyssadeid")
    private String pssubsyssadeid;
    @Column(name="pssubsyssadename")
    private String pssubsyssadename;
    @Column(name="pssubsysserviceapiid")
    private String pssubsysserviceapiid;
    @Column(name="pssubsysserviceapiname")
    private String pssubsysserviceapiname;
    @Column(name="pssysbdtablescnt")
    private Integer pssysbdtablescnt;
    @Column(name="pssyscounterscnt")
    private Integer pssyscounterscnt;
    @Column(name="pssysdmitemscnt")
    private Integer pssysdmitemscnt;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssysimageid")
    private String pssysimageid;
    @Column(name="pssysimagename")
    private String pssysimagename;
    @Column(name="pssysmodelchglogscnt")
    private Integer pssysmodelchglogscnt;
    @Column(name="pssysmodelgroupid")
    private String pssysmodelgroupid;
    @Column(name="pssysmodelgroupname")
    private String pssysmodelgroupname;
    @Column(name="pssysreqitemid")
    private String pssysreqitemid;
    @Column(name="pssysreqitemname")
    private String pssysreqitemname;
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
    @Column(name="pssystaskscnt")
    private Integer pssystaskscnt;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="pssystestcasescnt")
    private Integer pssystestcasescnt;
    @Column(name="pssystestdatascnt")
    private Integer pssystestdatascnt;
    @Column(name="pssysuniresid")
    private String pssysuniresid;
    @Column(name="pssysuniresname")
    private String pssysuniresname;
    @Column(name="pswfdescnt")
    private Integer pswfdescnt;
    @Column(name="readonlymode")
    private Integer readonlymode;
    @Column(name="removeflag")
    private Integer removeflag;
    @Column(name="saasmode")
    private Integer saasmode;
    @Column(name="serviceapiflag")
    private Integer serviceapiflag;
    @Column(name="servicecodename")
    private String servicecodename;
    @Column(name="srcpsdemapscnt")
    private Integer srcpsdemapscnt;
    @Column(name="storagemode")
    private Integer storagemode;
    @Column(name="subsysde")
    private Integer subsysde;
    @Column(name="subsysmodule")
    private Integer subsysmodule;
    @Column(name="svrpubmode")
    private Integer svrpubmode;
    @Column(name="systemflag")
    private Integer systemflag;
    @Column(name="tablename")
    private String tablename;
    @Column(name="testcaseflag")
    private Integer testcaseflag;
    @Column(name="todotask")
    private String todotask;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="useraction")
    private Integer useraction;
    @Column(name="usercat")
    private String usercat;
    @Column(name="userparams")
    private String userparams;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    @Column(name="validflag")
    private Integer validflag;
    @Column(name="viewlevel")
    private Integer viewlevel;
    @Column(name="viewname")
    private String viewname;
    @Column(name="viewname2")
    private String viewname2;
    @Column(name="viewname3")
    private String viewname3;
    @Column(name="viewname4")
    private String viewname4;
    @Column(name="virtualflag")
    private Integer virtualflag;
    @Column(name="vkeyseparator")
    private String vkeyseparator;
    private Integer objPSDEFInputTipSetLock = new Integer(1);
    private PSDEFInputTipSet psdefinputtipset = null;
    private Integer objPSDynaDETemplLock = new Integer(1);
    private PSDynaDETempl psdynadetempl = null;
    private Integer objPSHelpModuleLock = new Integer(1);
    private PSHelpModule pshelpmodule = null;
    private Integer objLNPSLanResLock = new Integer(1);
    private PSLanguageRes lnpslanres = null;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSubSysSADELock = new Integer(1);
    private PSSubSysSADE pssubsyssade = null;
    private Integer objPSSubSysServiceAPILock = new Integer(1);
    private PSSubSysServiceAPI pssubsysserviceapi = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSysImageLock = new Integer(1);
    private PSSysImage pssysimage = null;
    private Integer objPSSysModelGroupLock = new Integer(1);
    private PSSysModelGroup pssysmodelgroup = null;
    private Integer objPSSysReqItemLock = new Integer(1);
    private PSSysReqItem pssysreqitem = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSSysUniResLock = new Integer(1);
    private PSSysUniRes pssysunires = null;
    private Integer objPSACHandlersLock = new Integer(1);
    private ArrayList<PSACHandler> psachandlers = null;
    private Integer objPSCodeListsLock = new Integer(1);
    private ArrayList<PSCodeList> pscodelists = null;
    private Integer objPSCtrlLogicGroupsLock = new Integer(1);
    private ArrayList<PSCtrlLogicGroup> psctrllogicgroups = null;
    private Integer objPSDEACModesLock = new Integer(1);
    private ArrayList<PSDEACMode> psdeacmodes = null;
    private Integer objPSDEActionGroupsLock = new Integer(1);
    private ArrayList<PSDEActionGroup> psdeactiongroups = null;
    private Integer objDstPSDEActionLogicsLock = new Integer(1);
    private ArrayList<PSDEActionLogic> dstpsdeactionlogics = null;
    private Integer objPSDEActionLogicsLock = new Integer(1);
    private ArrayList<PSDEActionLogic> psdeactionlogics = null;
    private Integer objPSDEAWsLock = new Integer(1);
    private ArrayList<PSDEActionWizard> psdeaws = null;
    private Integer objPSDEActionsLock = new Integer(1);
    private ArrayList<PSDEAction> psdeactions = null;
    private Integer objPSDEAWGroupsLock = new Integer(1);
    private ArrayList<PSDEAWGroup> psdeawgroups = null;
    private Integer objPSDEChartsLock = new Integer(1);
    private ArrayList<PSDEChart> psdecharts = null;
    private Integer objPSDEDataExpsLock = new Integer(1);
    private ArrayList<PSDEDataExp> psdedataexps = null;
    private Integer objPSDEDataImpsLock = new Integer(1);
    private ArrayList<PSDEDataImp> psdedataimps = null;
    private Integer objPSDEDataQueriesLock = new Integer(1);
    private ArrayList<PSDEDataQuery> psdedataqueries = null;
    private Integer objPSDEDataRelationsLock = new Integer(1);
    private ArrayList<PSDEDataRelation> psdedatarelations = null;
    private Integer objPSDEDataSetsLock = new Integer(1);
    private ArrayList<PSDEDataSet> psdedatasets = null;
    private Integer objPSDEDataSyncsLock = new Integer(1);
    private ArrayList<PSDEDataSync> psdedatasyncs = null;
    private Integer objPSDEDataViewsLock = new Integer(1);
    private ArrayList<PSDEDataView> psdedataviews = null;
    private Integer objPSDEDBCfgsLock = new Integer(1);
    private ArrayList<PSDEDBCfg> psdedbcfgs = null;
    private Integer objPSDEDBIndexsLock = new Integer(1);
    private ArrayList<PSDEDBIndex> psdedbindexs = null;
    private Integer objPSDEDRGroupsLock = new Integer(1);
    private ArrayList<PSDEDRGroup> psdedrgroups = null;
    private Integer objPSDEDRItemsLock = new Integer(1);
    private ArrayList<PSDEDRItem> psdedritems = null;
    private Integer objPSDTSQueuesLock = new Integer(1);
    private ArrayList<PSDEDTSQueue> psdtsqueues = null;
    private Integer objPSDEFGroupsLock = new Integer(1);
    private ArrayList<PSDEFGroup> psdefgroups = null;
    private Integer objPSDEFieldsLock = new Integer(1);
    private ArrayList<PSDEField> psdefields = null;
    private Integer objPSDEFormsLock = new Integer(1);
    private ArrayList<PSDEForm> psdeforms = null;
    private Integer objPSDEFSFItemsLock = new Integer(1);
    private ArrayList<PSDEFSFItem> psdefsfitems = null;
    private Integer objPSDEFValueRulesLock = new Integer(1);
    private ArrayList<PSDEFValueRule> psdefvaluerules = null;
    private Integer objPSDEGridsLock = new Integer(1);
    private ArrayList<PSDEGrid> psdegrids = null;
    private Integer objPSDEGroupsLock = new Integer(1);
    private ArrayList<PSDEGroup> psdegroups = null;
    private Integer objPSDEListsLock = new Integer(1);
    private ArrayList<PSDEList> psdelists = null;
    private Integer objPSDELogicsLock = new Integer(1);
    private ArrayList<PSDELogic> psdelogics = null;
    private Integer objPSDEMainStatesLock = new Integer(1);
    private ArrayList<PSDEMainState> psdemainstates = null;
    private Integer objPSDEMapsLock = new Integer(1);
    private ArrayList<PSDEMap> psdemaps = null;
    private Integer objSrcPSDEMapsLock = new Integer(1);
    private ArrayList<PSDEMap> srcpsdemaps = null;
    private Integer objPSDEModelsLock = new Integer(1);
    private ArrayList<PSDEModel> psdemodels = null;
    private Integer objPSDENotifiesLock = new Integer(1);
    private ArrayList<PSDENotify> psdenotifies = null;
    private Integer objPSDEOPPrivRolesLock = new Integer(1);
    private ArrayList<PSDEOPPrivRole> psdeopprivroles = null;
    private Integer objPSDEOPPrivsLock = new Integer(1);
    private ArrayList<PSDEOPPriv> psdeopprivs = null;
    private Integer objPSDEPrintsLock = new Integer(1);
    private ArrayList<PSDEPrint> psdeprints = null;
    private Integer objPSDEReportsLock = new Integer(1);
    private ArrayList<PSDEReport> psdereports = null;
    private Integer objPSDERGroupsLock = new Integer(1);
    private ArrayList<PSDERGroup> psdergroups = null;
    private Integer objMajorPSDERsLock = new Integer(1);
    private ArrayList<PSDER> majorpsders = null;
    private Integer objMinorPSDERsLock = new Integer(1);
    private ArrayList<PSDER> minorpsders = null;
    private Integer objPSDEServiceAPIsLock = new Integer(1);
    private ArrayList<PSDEServiceAPI> psdeserviceapis = null;
    private Integer objPSDETablesLock = new Integer(1);
    private ArrayList<PSDETable> psdetables = null;
    private Integer objPSDEToolbarsLock = new Integer(1);
    private ArrayList<PSDEToolbar> psdetoolbars = null;
    private Integer objPSDETreeViewsLock = new Integer(1);
    private ArrayList<PSDETreeView> psdetreeviews = null;
    private Integer objPSDEUAGroupsLock = new Integer(1);
    private ArrayList<PSDEUAGroup> psdeuagroups = null;
    private Integer objPSDEUIActionsLock = new Integer(1);
    private ArrayList<PSDEUIAction> psdeuiactions = null;
    private Integer objPSDEUserRolesLock = new Integer(1);
    private ArrayList<PSDEUserRole> psdeuserroles = null;
    private Integer objPSDEUtilDEsLock = new Integer(1);
    private ArrayList<PSDEUtilDE> psdeutildes = null;
    private Integer objPSDEViewBasesLock = new Integer(1);
    private ArrayList<PSDEViewBase> psdeviewbases = null;
    private Integer objPSDEVRGroupsLock = new Integer(1);
    private ArrayList<PSDEVRGroup> psdevrgroups = null;
    private Integer objPSDEWizardsLock = new Integer(1);
    private ArrayList<PSDEWizard> psdewizards = null;
    private Integer objPSHelpResourcesLock = new Integer(1);
    private ArrayList<PSHelpResource> pshelpresources = null;
    private Integer objPSSysBDTablesLock = new Integer(1);
    private ArrayList<PSSysBDTable> pssysbdtables = null;
    private Integer objPSSysCountersLock = new Integer(1);
    private ArrayList<PSSysCounter> pssyscounters = null;
    private Integer objPSSysDashboardsLock = new Integer(1);
    private ArrayList<PSSysDashboard> pssysdashboards = null;
    private Integer objPSSysModelChgLogsLock = new Integer(1);
    private ArrayList<PSSysModelChgLog> pssysmodelchglogs = null;
    private Integer objPSSysDMItemsLock = new Integer(1);
    private ArrayList<PSSysDMItem> pssysdmitems = null;
    private Integer objPSSysDMVerItemsLock = new Integer(1);
    private ArrayList<PSSysDMVerItem> pssysdmveritems = null;
    private Integer objPSSysMapViewsLock = new Integer(1);
    private ArrayList<PSSysMapView> pssysmapviews = null;
    private Integer objPSSysSearchBarsLock = new Integer(1);
    private ArrayList<PSSysSearchBar> pssyssearchbars = null;
    private Integer objPSSysSearchDEsLock = new Integer(1);
    private ArrayList<PSSysSearchDE> pssyssearchdes = null;
    private Integer objPSSysTasksLock = new Integer(1);
    private ArrayList<PSSysTask> pssystasks = null;
    private Integer objPSSysTestCasesLock = new Integer(1);
    private ArrayList<PSSysTestCase> pssystestcases = null;
    private Integer objPSSysTestDatasLock = new Integer(1);
    private ArrayList<PSSysTestData> pssystestdatas = null;
    private Integer objPSSysUniStatesLock = new Integer(1);
    private ArrayList<PSSysUniState> pssysunistates = null;
    private Integer objPSSysUserCasesLock = new Integer(1);
    private ArrayList<PSSysUserCase> pssysusercases = null;
    private Integer objPSSysViewPanelsLock = new Integer(1);
    private ArrayList<PSSysViewPanel> pssysviewpanels = null;
    private Integer objPSWFDEsLock = new Integer(1);
    private ArrayList<PSWFDE> pswfdes = null;

    public void setAccCtrlArch(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAccCtrlArch(n);
            return;
        }
        this.accctrlarch = n;
        this.accctrlarchDirtyFlag = true;
    }

    public Integer getAccCtrlArch() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAccCtrlArch();
        }
        return this.accctrlarch;
    }

    public boolean isAccCtrlArchDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAccCtrlArchDirty();
        }
        return this.accctrlarchDirtyFlag;
    }

    public void resetAccCtrlArch() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAccCtrlArch();
            return;
        }
        this.accctrlarchDirtyFlag = false;
        this.accctrlarch = null;
    }

    public void setAuditMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAuditMode(n);
            return;
        }
        this.auditmode = n;
        this.auditmodeDirtyFlag = true;
    }

    public Integer getAuditMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAuditMode();
        }
        return this.auditmode;
    }

    public boolean isAuditModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAuditModeDirty();
        }
        return this.auditmodeDirtyFlag;
    }

    public void resetAuditMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAuditMode();
            return;
        }
        this.auditmodeDirtyFlag = false;
        this.auditmode = null;
    }

    public void setBaseClsParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBaseClsParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.baseclsparams = string;
        this.baseclsparamsDirtyFlag = true;
    }

    public String getBaseClsParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBaseClsParams();
        }
        return this.baseclsparams;
    }

    public boolean isBaseClsParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBaseClsParamsDirty();
        }
        return this.baseclsparamsDirtyFlag;
    }

    public void resetBaseClsParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBaseClsParams();
            return;
        }
        this.baseclsparamsDirtyFlag = false;
        this.baseclsparams = null;
    }

    public void setBizTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBizTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.biztag = string;
        this.biztagDirtyFlag = true;
    }

    public String getBizTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBizTag();
        }
        return this.biztag;
    }

    public boolean isBizTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBizTagDirty();
        }
        return this.biztagDirtyFlag;
    }

    public void resetBizTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBizTag();
            return;
        }
        this.biztagDirtyFlag = false;
        this.biztag = null;
    }

    public void setCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codename = string;
        this.codenameDirtyFlag = true;
    }

    public String getCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeName();
        }
        return this.codename;
    }

    public boolean isCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeNameDirty();
        }
        return this.codenameDirtyFlag;
    }

    public void resetCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeName();
            return;
        }
        this.codenameDirtyFlag = false;
        this.codename = null;
    }

    public void setCodeNameMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeNameMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codenamemode = string;
        this.codenamemodeDirtyFlag = true;
    }

    public String getCodeNameMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeNameMode();
        }
        return this.codenamemode;
    }

    public boolean isCodeNameModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeNameModeDirty();
        }
        return this.codenamemodeDirtyFlag;
    }

    public void resetCodeNameMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeNameMode();
            return;
        }
        this.codenamemodeDirtyFlag = false;
        this.codenamemode = null;
    }

    public void setColor(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setColor(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.color = string;
        this.colorDirtyFlag = true;
    }

    public String getColor() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getColor();
        }
        return this.color;
    }

    public boolean isColorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isColorDirty();
        }
        return this.colorDirtyFlag;
    }

    public void resetColor() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetColor();
            return;
        }
        this.colorDirtyFlag = false;
        this.color = null;
    }

    public void setCreateDate(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateDate(timestamp);
            return;
        }
        this.createdate = timestamp;
        this.createdateDirtyFlag = true;
    }

    public Timestamp getCreateDate() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreateDate();
        }
        return this.createdate;
    }

    public boolean isCreateDateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreateDateDirty();
        }
        return this.createdateDirtyFlag;
    }

    public void resetCreateDate() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreateDate();
            return;
        }
        this.createdateDirtyFlag = false;
        this.createdate = null;
    }

    public void setCreateMan(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateMan(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.createman = string;
        this.createmanDirtyFlag = true;
    }

    public String getCreateMan() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreateMan();
        }
        return this.createman;
    }

    public boolean isCreateManDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreateManDirty();
        }
        return this.createmanDirtyFlag;
    }

    public void resetCreateMan() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreateMan();
            return;
        }
        this.createmanDirtyFlag = false;
        this.createman = null;
    }

    public void setCustomCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customcode = string;
        this.customcodeDirtyFlag = true;
    }

    public String getCustomCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomCode();
        }
        return this.customcode;
    }

    public boolean isCustomCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomCodeDirty();
        }
        return this.customcodeDirtyFlag;
    }

    public void resetCustomCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomCode();
            return;
        }
        this.customcodeDirtyFlag = false;
        this.customcode = null;
    }

    public void setCustomMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomMode(n);
            return;
        }
        this.custommode = n;
        this.custommodeDirtyFlag = true;
    }

    public Integer getCustomMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomMode();
        }
        return this.custommode;
    }

    public boolean isCustomModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomModeDirty();
        }
        return this.custommodeDirtyFlag;
    }

    public void resetCustomMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomMode();
            return;
        }
        this.custommodeDirtyFlag = false;
        this.custommode = null;
    }

    public void setDataAccMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataAccMode(n);
            return;
        }
        this.dataaccmode = n;
        this.dataaccmodeDirtyFlag = true;
    }

    public Integer getDataAccMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataAccMode();
        }
        return this.dataaccmode;
    }

    public boolean isDataAccModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataAccModeDirty();
        }
        return this.dataaccmodeDirtyFlag;
    }

    public void resetDataAccMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataAccMode();
            return;
        }
        this.dataaccmodeDirtyFlag = false;
        this.dataaccmode = null;
    }

    public void setDataChgLogMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataChgLogMode(n);
            return;
        }
        this.datachglogmode = n;
        this.datachglogmodeDirtyFlag = true;
    }

    public Integer getDataChgLogMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataChgLogMode();
        }
        return this.datachglogmode;
    }

    public boolean isDataChgLogModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataChgLogModeDirty();
        }
        return this.datachglogmodeDirtyFlag;
    }

    public void resetDataChgLogMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataChgLogMode();
            return;
        }
        this.datachglogmodeDirtyFlag = false;
        this.datachglogmode = null;
    }

    public void setDataImpExpFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataImpExpFlag(n);
            return;
        }
        this.dataimpexpflag = n;
        this.dataimpexpflagDirtyFlag = true;
    }

    public Integer getDataImpExpFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataImpExpFlag();
        }
        return this.dataimpexpflag;
    }

    public boolean isDataImpExpFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataImpExpFlagDirty();
        }
        return this.dataimpexpflagDirtyFlag;
    }

    public void resetDataImpExpFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataImpExpFlag();
            return;
        }
        this.dataimpexpflagDirtyFlag = false;
        this.dataimpexpflag = null;
    }

    public void setDBTabSpace(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDBTabSpace(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dbtabspace = string;
        this.dbtabspaceDirtyFlag = true;
    }

    public String getDBTabSpace() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDBTabSpace();
        }
        return this.dbtabspace;
    }

    public boolean isDBTabSpaceDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDBTabSpaceDirty();
        }
        return this.dbtabspaceDirtyFlag;
    }

    public void resetDBTabSpace() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDBTabSpace();
            return;
        }
        this.dbtabspaceDirtyFlag = false;
        this.dbtabspace = null;
    }

    public void setDBVer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDBVer(n);
            return;
        }
        this.dbver = n;
        this.dbverDirtyFlag = true;
    }

    public Integer getDBVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDBVer();
        }
        return this.dbver;
    }

    public boolean isDBVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDBVerDirty();
        }
        return this.dbverDirtyFlag;
    }

    public void resetDBVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDBVer();
            return;
        }
        this.dbverDirtyFlag = false;
        this.dbver = null;
    }

    public void setDECat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDECat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.decat = string;
        this.decatDirtyFlag = true;
    }

    public String getDECat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDECat();
        }
        return this.decat;
    }

    public boolean isDECatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDECatDirty();
        }
        return this.decatDirtyFlag;
    }

    public void resetDECat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDECat();
            return;
        }
        this.decatDirtyFlag = false;
        this.decat = null;
    }

    public void setDEHolder(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEHolder(n);
            return;
        }
        this.deholder = n;
        this.deholderDirtyFlag = true;
    }

    public Integer getDEHolder() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEHolder();
        }
        return this.deholder;
    }

    public boolean isDEHolderDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEHolderDirty();
        }
        return this.deholderDirtyFlag;
    }

    public void resetDEHolder() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEHolder();
            return;
        }
        this.deholderDirtyFlag = false;
        this.deholder = null;
    }

    public void setDELockFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDELockFlag(n);
            return;
        }
        this.delockflag = n;
        this.delockflagDirtyFlag = true;
    }

    public Integer getDELockFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDELockFlag();
        }
        return this.delockflag;
    }

    public boolean isDELockFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDELockFlagDirty();
        }
        return this.delockflagDirtyFlag;
    }

    public void resetDELockFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDELockFlag();
            return;
        }
        this.delockflagDirtyFlag = false;
        this.delockflag = null;
    }

    public void setDESN(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDESN(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.desn = string;
        this.desnDirtyFlag = true;
    }

    public String getDESN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDESN();
        }
        return this.desn;
    }

    public boolean isDESNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDESNDirty();
        }
        return this.desnDirtyFlag;
    }

    public void resetDESN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDESN();
            return;
        }
        this.desnDirtyFlag = false;
        this.desn = null;
    }

    public void setDETag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDETag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.detag = string;
        this.detagDirtyFlag = true;
    }

    public String getDETag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDETag();
        }
        return this.detag;
    }

    public boolean isDETagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDETagDirty();
        }
        return this.detagDirtyFlag;
    }

    public void resetDETag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDETag();
            return;
        }
        this.detagDirtyFlag = false;
        this.detag = null;
    }

    public void setDETag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDETag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.detag2 = string;
        this.detag2DirtyFlag = true;
    }

    public String getDETag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDETag2();
        }
        return this.detag2;
    }

    public boolean isDETag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDETag2Dirty();
        }
        return this.detag2DirtyFlag;
    }

    public void resetDETag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDETag2();
            return;
        }
        this.detag2DirtyFlag = false;
        this.detag2 = null;
    }

    public void setDEType(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEType(n);
            return;
        }
        this.detype = n;
        this.detypeDirtyFlag = true;
    }

    public Integer getDEType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEType();
        }
        return this.detype;
    }

    public boolean isDETypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDETypeDirty();
        }
        return this.detypeDirtyFlag;
    }

    public void resetDEType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEType();
            return;
        }
        this.detypeDirtyFlag = false;
        this.detype = null;
    }

    public void setDSLink(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDSLink(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dslink = string;
        this.dslinkDirtyFlag = true;
    }

    public String getDSLink() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDSLink();
        }
        return this.dslink;
    }

    public boolean isDSLinkDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDSLinkDirty();
        }
        return this.dslinkDirtyFlag;
    }

    public void resetDSLink() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDSLink();
            return;
        }
        this.dslinkDirtyFlag = false;
        this.dslink = null;
    }

    public void setDstPSDEActionLogicsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEActionLogicsCnt(n);
            return;
        }
        this.dstpsdeactionlogicscnt = n;
        this.dstpsdeactionlogicscntDirtyFlag = true;
    }

    public Integer getDstPSDEActionLogicsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEActionLogicsCnt();
        }
        return this.dstpsdeactionlogicscnt;
    }

    public boolean isDstPSDEActionLogicsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEActionLogicsCntDirty();
        }
        return this.dstpsdeactionlogicscntDirtyFlag;
    }

    public void resetDstPSDEActionLogicsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEActionLogicsCnt();
            return;
        }
        this.dstpsdeactionlogicscntDirtyFlag = false;
        this.dstpsdeactionlogicscnt = null;
    }

    public void setDynamicMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynamicMode(n);
            return;
        }
        this.dynamicmode = n;
        this.dynamicmodeDirtyFlag = true;
    }

    public Integer getDynamicMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynamicMode();
        }
        return this.dynamicmode;
    }

    public boolean isDynamicModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynamicModeDirty();
        }
        return this.dynamicmodeDirtyFlag;
    }

    public void resetDynamicMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynamicMode();
            return;
        }
        this.dynamicmodeDirtyFlag = false;
        this.dynamicmode = null;
    }

    public void setDynaModelFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaModelFlag(n);
            return;
        }
        this.dynamodelflag = n;
        this.dynamodelflagDirtyFlag = true;
    }

    public Integer getDynaModelFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaModelFlag();
        }
        return this.dynamodelflag;
    }

    public boolean isDynaModelFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaModelFlagDirty();
        }
        return this.dynamodelflagDirtyFlag;
    }

    public void resetDynaModelFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaModelFlag();
            return;
        }
        this.dynamodelflagDirtyFlag = false;
        this.dynamodelflag = null;
    }

    public void setDynaTableMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaTableMode(n);
            return;
        }
        this.dynatablemode = n;
        this.dynatablemodeDirtyFlag = true;
    }

    public Integer getDynaTableMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaTableMode();
        }
        return this.dynatablemode;
    }

    public boolean isDynaTableModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaTableModeDirty();
        }
        return this.dynatablemodeDirtyFlag;
    }

    public void resetDynaTableMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaTableMode();
            return;
        }
        this.dynatablemodeDirtyFlag = false;
        this.dynatablemode = null;
    }

    public void setEnableAudit(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableAudit(n);
            return;
        }
        this.enableaudit = n;
        this.enableauditDirtyFlag = true;
    }

    public Integer getEnableAudit() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableAudit();
        }
        return this.enableaudit;
    }

    public boolean isEnableAuditDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableAuditDirty();
        }
        return this.enableauditDirtyFlag;
    }

    public void resetEnableAudit() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableAudit();
            return;
        }
        this.enableauditDirtyFlag = false;
        this.enableaudit = null;
    }

    public void setEnableDALog(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableDALog(n);
            return;
        }
        this.enabledalog = n;
        this.enabledalogDirtyFlag = true;
    }

    public Integer getEnableDALog() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableDALog();
        }
        return this.enabledalog;
    }

    public boolean isEnableDALogDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableDALogDirty();
        }
        return this.enabledalogDirtyFlag;
    }

    public void resetEnableDALog() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableDALog();
            return;
        }
        this.enabledalogDirtyFlag = false;
        this.enabledalog = null;
    }

    public void setEnableDataVer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableDataVer(n);
            return;
        }
        this.enabledataver = n;
        this.enabledataverDirtyFlag = true;
    }

    public Integer getEnableDataVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableDataVer();
        }
        return this.enabledataver;
    }

    public boolean isEnableDataVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableDataVerDirty();
        }
        return this.enabledataverDirtyFlag;
    }

    public void resetEnableDataVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableDataVer();
            return;
        }
        this.enabledataverDirtyFlag = false;
        this.enabledataver = null;
    }

    public void setEnableDEAction(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableDEAction(n);
            return;
        }
        this.enabledeaction = n;
        this.enabledeactionDirtyFlag = true;
    }

    public Integer getEnableDEAction() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableDEAction();
        }
        return this.enabledeaction;
    }

    public boolean isEnableDEActionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableDEActionDirty();
        }
        return this.enabledeactionDirtyFlag;
    }

    public void resetEnableDEAction() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableDEAction();
            return;
        }
        this.enabledeactionDirtyFlag = false;
        this.enabledeaction = null;
    }

    public void setEnableDEDataSet(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableDEDataSet(n);
            return;
        }
        this.enablededataset = n;
        this.enablededatasetDirtyFlag = true;
    }

    public Integer getEnableDEDataSet() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableDEDataSet();
        }
        return this.enablededataset;
    }

    public boolean isEnableDEDataSetDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableDEDataSetDirty();
        }
        return this.enablededatasetDirtyFlag;
    }

    public void resetEnableDEDataSet() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableDEDataSet();
            return;
        }
        this.enablededatasetDirtyFlag = false;
        this.enablededataset = null;
    }

    public void setEnableDynaSys(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableDynaSys(n);
            return;
        }
        this.enabledynasys = n;
        this.enabledynasysDirtyFlag = true;
    }

    public Integer getEnableDynaSys() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableDynaSys();
        }
        return this.enabledynasys;
    }

    public boolean isEnableDynaSysDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableDynaSysDirty();
        }
        return this.enabledynasysDirtyFlag;
    }

    public void resetEnableDynaSys() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableDynaSys();
            return;
        }
        this.enabledynasysDirtyFlag = false;
        this.enabledynasys = null;
    }

    public void setEnableEntityCache(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableEntityCache(n);
            return;
        }
        this.enableentitycache = n;
        this.enableentitycacheDirtyFlag = true;
    }

    public Integer getEnableEntityCache() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableEntityCache();
        }
        return this.enableentitycache;
    }

    public boolean isEnableEntityCacheDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableEntityCacheDirty();
        }
        return this.enableentitycacheDirtyFlag;
    }

    public void resetEnableEntityCache() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableEntityCache();
            return;
        }
        this.enableentitycacheDirtyFlag = false;
        this.enableentitycache = null;
    }

    public void setEnableMob(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableMob(n);
            return;
        }
        this.enablemob = n;
        this.enablemobDirtyFlag = true;
    }

    public Integer getEnableMob() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableMob();
        }
        return this.enablemob;
    }

    public boolean isEnableMobDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableMobDirty();
        }
        return this.enablemobDirtyFlag;
    }

    public void resetEnableMob() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableMob();
            return;
        }
        this.enablemobDirtyFlag = false;
        this.enablemob = null;
    }

    public void setEnableMultiDS(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableMultiDS(n);
            return;
        }
        this.enablemultids = n;
        this.enablemultidsDirtyFlag = true;
    }

    public Integer getEnableMultiDS() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableMultiDS();
        }
        return this.enablemultids;
    }

    public boolean isEnableMultiDSDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableMultiDSDirty();
        }
        return this.enablemultidsDirtyFlag;
    }

    public void resetEnableMultiDS() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableMultiDS();
            return;
        }
        this.enablemultidsDirtyFlag = false;
        this.enablemultids = null;
    }

    public void setEnableOPNameModel(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableOPNameModel(n);
            return;
        }
        this.enableopnamemodel = n;
        this.enableopnamemodelDirtyFlag = true;
    }

    public Integer getEnableOPNameModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableOPNameModel();
        }
        return this.enableopnamemodel;
    }

    public boolean isEnableOPNameModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableOPNameModelDirty();
        }
        return this.enableopnamemodelDirtyFlag;
    }

    public void resetEnableOPNameModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableOPNameModel();
            return;
        }
        this.enableopnamemodelDirtyFlag = false;
        this.enableopnamemodel = null;
    }

    public void setEnableOrgModel(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableOrgModel(n);
            return;
        }
        this.enableorgmodel = n;
        this.enableorgmodelDirtyFlag = true;
    }

    public Integer getEnableOrgModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableOrgModel();
        }
        return this.enableorgmodel;
    }

    public boolean isEnableOrgModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableOrgModelDirty();
        }
        return this.enableorgmodelDirtyFlag;
    }

    public void resetEnableOrgModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableOrgModel();
            return;
        }
        this.enableorgmodelDirtyFlag = false;
        this.enableorgmodel = null;
    }

    public void setEnablePQL(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnablePQL(n);
            return;
        }
        this.enablepql = n;
        this.enablepqlDirtyFlag = true;
    }

    public Integer getEnablePQL() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnablePQL();
        }
        return this.enablepql;
    }

    public boolean isEnablePQLDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnablePQLDirty();
        }
        return this.enablepqlDirtyFlag;
    }

    public void resetEnablePQL() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnablePQL();
            return;
        }
        this.enablepqlDirtyFlag = false;
        this.enablepql = null;
    }

    public void setEnableSelect(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableSelect(n);
            return;
        }
        this.enableselect = n;
        this.enableselectDirtyFlag = true;
    }

    public Integer getEnableSelect() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableSelect();
        }
        return this.enableselect;
    }

    public boolean isEnableSelectDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableSelectDirty();
        }
        return this.enableselectDirtyFlag;
    }

    public void resetEnableSelect() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableSelect();
            return;
        }
        this.enableselectDirtyFlag = false;
        this.enableselect = null;
    }

    public void setEnableWFModel(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableWFModel(n);
            return;
        }
        this.enablewfmodel = n;
        this.enablewfmodelDirtyFlag = true;
    }

    public Integer getEnableWFModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableWFModel();
        }
        return this.enablewfmodel;
    }

    public boolean isEnableWFModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableWFModelDirty();
        }
        return this.enablewfmodelDirtyFlag;
    }

    public void resetEnableWFModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableWFModel();
            return;
        }
        this.enablewfmodelDirtyFlag = false;
        this.enablewfmodel = null;
    }

    public void setEnaMultiForm(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnaMultiForm(n);
            return;
        }
        this.enamultiform = n;
        this.enamultiformDirtyFlag = true;
    }

    public Integer getEnaMultiForm() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnaMultiForm();
        }
        return this.enamultiform;
    }

    public boolean isEnaMultiFormDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnaMultiFormDirty();
        }
        return this.enamultiformDirtyFlag;
    }

    public void resetEnaMultiForm() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnaMultiForm();
            return;
        }
        this.enamultiformDirtyFlag = false;
        this.enamultiform = null;
    }

    public void setEnaTempData(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnaTempData(n);
            return;
        }
        this.enatempdata = n;
        this.enatempdataDirtyFlag = true;
    }

    public Integer getEnaTempData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnaTempData();
        }
        return this.enatempdata;
    }

    public boolean isEnaTempDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnaTempDataDirty();
        }
        return this.enatempdataDirtyFlag;
    }

    public void resetEnaTempData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnaTempData();
            return;
        }
        this.enatempdataDirtyFlag = false;
        this.enatempdata = null;
    }

    public void setEntityCacheTimeout(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEntityCacheTimeout(n);
            return;
        }
        this.entitycachetimeout = n;
        this.entitycachetimeoutDirtyFlag = true;
    }

    public Integer getEntityCacheTimeout() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEntityCacheTimeout();
        }
        return this.entitycachetimeout;
    }

    public boolean isEntityCacheTimeoutDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEntityCacheTimeoutDirty();
        }
        return this.entitycachetimeoutDirtyFlag;
    }

    public void resetEntityCacheTimeout() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEntityCacheTimeout();
            return;
        }
        this.entitycachetimeoutDirtyFlag = false;
        this.entitycachetimeout = null;
    }

    public void setExistingModel(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExistingModel(n);
            return;
        }
        this.existingmodel = n;
        this.existingmodelDirtyFlag = true;
    }

    public Integer getExistingModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExistingModel();
        }
        return this.existingmodel;
    }

    public boolean isExistingModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExistingModelDirty();
        }
        return this.existingmodelDirtyFlag;
    }

    public void resetExistingModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExistingModel();
            return;
        }
        this.existingmodelDirtyFlag = false;
        this.existingmodel = null;
    }

    public void setExTableName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExTableName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.extablename = string;
        this.extablenameDirtyFlag = true;
    }

    public String getExTableName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExTableName();
        }
        return this.extablename;
    }

    public boolean isExTableNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExTableNameDirty();
        }
        return this.extablenameDirtyFlag;
    }

    public void resetExTableName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExTableName();
            return;
        }
        this.extablenameDirtyFlag = false;
        this.extablename = null;
    }

    public void setIndexDEType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIndexDEType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.indexdetype = string;
        this.indexdetypeDirtyFlag = true;
    }

    public String getIndexDEType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIndexDEType();
        }
        return this.indexdetype;
    }

    public boolean isIndexDETypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIndexDETypeDirty();
        }
        return this.indexdetypeDirtyFlag;
    }

    public void resetIndexDEType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIndexDEType();
            return;
        }
        this.indexdetypeDirtyFlag = false;
        this.indexdetype = null;
    }

    public void setKeyRule(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setKeyRule(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.keyrule = string;
        this.keyruleDirtyFlag = true;
    }

    public String getKeyRule() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKeyRule();
        }
        return this.keyrule;
    }

    public boolean isKeyRuleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isKeyRuleDirty();
        }
        return this.keyruleDirtyFlag;
    }

    public void resetKeyRule() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetKeyRule();
            return;
        }
        this.keyruleDirtyFlag = false;
        this.keyrule = null;
    }

    public void setLNPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLNPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.lnpslanresid = string;
        this.lnpslanresidDirtyFlag = true;
    }

    public String getLNPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLNPSLanResId();
        }
        return this.lnpslanresid;
    }

    public boolean isLNPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLNPSLanResIdDirty();
        }
        return this.lnpslanresidDirtyFlag;
    }

    public void resetLNPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLNPSLanResId();
            return;
        }
        this.lnpslanresidDirtyFlag = false;
        this.lnpslanresid = null;
    }

    public void setLNPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLNPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.lnpslanresname = string;
        this.lnpslanresnameDirtyFlag = true;
    }

    public String getLNPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLNPSLanResName();
        }
        return this.lnpslanresname;
    }

    public boolean isLNPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLNPSLanResNameDirty();
        }
        return this.lnpslanresnameDirtyFlag;
    }

    public void resetLNPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLNPSLanResName();
            return;
        }
        this.lnpslanresnameDirtyFlag = false;
        this.lnpslanresname = null;
    }

    public void setLockFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLockFlag(n);
            return;
        }
        this.lockflag = n;
        this.lockflagDirtyFlag = true;
    }

    public Integer getLockFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLockFlag();
        }
        return this.lockflag;
    }

    public boolean isLockFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLockFlagDirty();
        }
        return this.lockflagDirtyFlag;
    }

    public void resetLockFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLockFlag();
            return;
        }
        this.lockflagDirtyFlag = false;
        this.lockflag = null;
    }

    public void setLogicInvalidValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicInvalidValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logicinvalidvalue = string;
        this.logicinvalidvalueDirtyFlag = true;
    }

    public String getLogicInvalidValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicInvalidValue();
        }
        return this.logicinvalidvalue;
    }

    public boolean isLogicInvalidValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicInvalidValueDirty();
        }
        return this.logicinvalidvalueDirtyFlag;
    }

    public void resetLogicInvalidValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicInvalidValue();
            return;
        }
        this.logicinvalidvalueDirtyFlag = false;
        this.logicinvalidvalue = null;
    }

    public void setLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logicname = string;
        this.logicnameDirtyFlag = true;
    }

    public String getLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicName();
        }
        return this.logicname;
    }

    public boolean isLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicNameDirty();
        }
        return this.logicnameDirtyFlag;
    }

    public void resetLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicName();
            return;
        }
        this.logicnameDirtyFlag = false;
        this.logicname = null;
    }

    public void setLogicValid(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicValid(n);
            return;
        }
        this.logicvalid = n;
        this.logicvalidDirtyFlag = true;
    }

    public Integer getLogicValid() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicValid();
        }
        return this.logicvalid;
    }

    public boolean isLogicValidDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicValidDirty();
        }
        return this.logicvalidDirtyFlag;
    }

    public void resetLogicValid() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicValid();
            return;
        }
        this.logicvalidDirtyFlag = false;
        this.logicvalid = null;
    }

    public void setLogicValidValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicValidValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logicvalidvalue = string;
        this.logicvalidvalueDirtyFlag = true;
    }

    public String getLogicValidValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicValidValue();
        }
        return this.logicvalidvalue;
    }

    public boolean isLogicValidValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicValidValueDirty();
        }
        return this.logicvalidvalueDirtyFlag;
    }

    public void resetLogicValidValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicValidValue();
            return;
        }
        this.logicvalidvalueDirtyFlag = false;
        this.logicvalidvalue = null;
    }

    public void setMajorPSDERsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMajorPSDERsCnt(n);
            return;
        }
        this.majorpsderscnt = n;
        this.majorpsderscntDirtyFlag = true;
    }

    public Integer getMajorPSDERsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorPSDERsCnt();
        }
        return this.majorpsderscnt;
    }

    public boolean isMajorPSDERsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMajorPSDERsCntDirty();
        }
        return this.majorpsderscntDirtyFlag;
    }

    public void resetMajorPSDERsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMajorPSDERsCnt();
            return;
        }
        this.majorpsderscntDirtyFlag = false;
        this.majorpsderscnt = null;
    }

    public void setMaxEntityCacheCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxEntityCacheCnt(n);
            return;
        }
        this.maxentitycachecnt = n;
        this.maxentitycachecntDirtyFlag = true;
    }

    public Integer getMaxEntityCacheCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxEntityCacheCnt();
        }
        return this.maxentitycachecnt;
    }

    public boolean isMaxEntityCacheCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxEntityCacheCntDirty();
        }
        return this.maxentitycachecntDirtyFlag;
    }

    public void resetMaxEntityCacheCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxEntityCacheCnt();
            return;
        }
        this.maxentitycachecntDirtyFlag = false;
        this.maxentitycachecnt = null;
    }

    public void setMemo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMemo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.memo = string;
        this.memoDirtyFlag = true;
    }

    public String getMemo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMemo();
        }
        return this.memo;
    }

    public boolean isMemoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMemoDirty();
        }
        return this.memoDirtyFlag;
    }

    public void resetMemo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMemo();
            return;
        }
        this.memoDirtyFlag = false;
        this.memo = null;
    }

    public void setMinorPSDERsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinorPSDERsCnt(n);
            return;
        }
        this.minorpsderscnt = n;
        this.minorpsderscntDirtyFlag = true;
    }

    public Integer getMinorPSDERsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorPSDERsCnt();
        }
        return this.minorpsderscnt;
    }

    public boolean isMinorPSDERsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinorPSDERsCntDirty();
        }
        return this.minorpsderscntDirtyFlag;
    }

    public void resetMinorPSDERsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinorPSDERsCnt();
            return;
        }
        this.minorpsderscntDirtyFlag = false;
        this.minorpsderscnt = null;
    }

    public void setModColor(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModColor(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modcolor = string;
        this.modcolorDirtyFlag = true;
    }

    public String getModColor() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModColor();
        }
        return this.modcolor;
    }

    public boolean isModColorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModColorDirty();
        }
        return this.modcolorDirtyFlag;
    }

    public void resetModColor() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModColor();
            return;
        }
        this.modcolorDirtyFlag = false;
        this.modcolor = null;
    }

    public void setModelImpExpFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelImpExpFlag(n);
            return;
        }
        this.modelimpexpflag = n;
        this.modelimpexpflagDirtyFlag = true;
    }

    public Integer getModelImpExpFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelImpExpFlag();
        }
        return this.modelimpexpflag;
    }

    public boolean isModelImpExpFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelImpExpFlagDirty();
        }
        return this.modelimpexpflagDirtyFlag;
    }

    public void resetModelImpExpFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelImpExpFlag();
            return;
        }
        this.modelimpexpflagDirtyFlag = false;
        this.modelimpexpflag = null;
    }

    public void setModelState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelState(n);
            return;
        }
        this.modelstate = n;
        this.modelstateDirtyFlag = true;
    }

    public Integer getModelState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelState();
        }
        return this.modelstate;
    }

    public boolean isModelStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelStateDirty();
        }
        return this.modelstateDirtyFlag;
    }

    public void resetModelState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelState();
            return;
        }
        this.modelstateDirtyFlag = false;
        this.modelstate = null;
    }

    public void setModelVer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelVer(n);
            return;
        }
        this.modelver = n;
        this.modelverDirtyFlag = true;
    }

    public Integer getModelVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelVer();
        }
        return this.modelver;
    }

    public boolean isModelVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelVerDirty();
        }
        return this.modelverDirtyFlag;
    }

    public void resetModelVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelVer();
            return;
        }
        this.modelverDirtyFlag = false;
        this.modelver = null;
    }

    public void setMSActionLogicFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMSActionLogicFlag(n);
            return;
        }
        this.msactionlogicflag = n;
        this.msactionlogicflagDirtyFlag = true;
    }

    public Integer getMSActionLogicFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMSActionLogicFlag();
        }
        return this.msactionlogicflag;
    }

    public boolean isMSActionLogicFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMSActionLogicFlagDirty();
        }
        return this.msactionlogicflagDirtyFlag;
    }

    public void resetMSActionLogicFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMSActionLogicFlag();
            return;
        }
        this.msactionlogicflagDirtyFlag = false;
        this.msactionlogicflag = null;
    }

    public void setNoViewMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNoViewMode(n);
            return;
        }
        this.noviewmode = n;
        this.noviewmodeDirtyFlag = true;
    }

    public Integer getNoViewMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNoViewMode();
        }
        return this.noviewmode;
    }

    public boolean isNoViewModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNoViewModeDirty();
        }
        return this.noviewmodeDirtyFlag;
    }

    public void resetNoViewMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNoViewMode();
            return;
        }
        this.noviewmodeDirtyFlag = false;
        this.noviewmode = null;
    }

    public void setOrderValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrderValue(n);
            return;
        }
        this.ordervalue = n;
        this.ordervalueDirtyFlag = true;
    }

    public Integer getOrderValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrderValue();
        }
        return this.ordervalue;
    }

    public boolean isOrderValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrderValueDirty();
        }
        return this.ordervalueDirtyFlag;
    }

    public void resetOrderValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrderValue();
            return;
        }
        this.ordervalueDirtyFlag = false;
        this.ordervalue = null;
    }

    public void setPSACHandlersCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSACHandlersCnt(n);
            return;
        }
        this.psachandlerscnt = n;
        this.psachandlerscntDirtyFlag = true;
    }

    public Integer getPSACHandlersCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSACHandlersCnt();
        }
        return this.psachandlerscnt;
    }

    public boolean isPSACHandlersCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSACHandlersCntDirty();
        }
        return this.psachandlerscntDirtyFlag;
    }

    public void resetPSACHandlersCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSACHandlersCnt();
            return;
        }
        this.psachandlerscntDirtyFlag = false;
        this.psachandlerscnt = null;
    }

    public void setPSCodeListsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCodeListsCnt(n);
            return;
        }
        this.pscodelistscnt = n;
        this.pscodelistscntDirtyFlag = true;
    }

    public Integer getPSCodeListsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeListsCnt();
        }
        return this.pscodelistscnt;
    }

    public boolean isPSCodeListsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCodeListsCntDirty();
        }
        return this.pscodelistscntDirtyFlag;
    }

    public void resetPSCodeListsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCodeListsCnt();
            return;
        }
        this.pscodelistscntDirtyFlag = false;
        this.pscodelistscnt = null;
    }

    public void setPSDataEntityId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDataEntityId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdataentityid = string;
        this.psdataentityidDirtyFlag = true;
    }

    public String getPSDataEntityId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDataEntityId();
        }
        return this.psdataentityid;
    }

    public boolean isPSDataEntityIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDataEntityIdDirty();
        }
        return this.psdataentityidDirtyFlag;
    }

    public void resetPSDataEntityId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDataEntityId();
            return;
        }
        this.psdataentityidDirtyFlag = false;
        this.psdataentityid = null;
    }

    public void setPSDataEntityName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDataEntityName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        if (string != null) {
            string = string.toUpperCase();
        }
        this.psdataentityname = string;
        this.psdataentitynameDirtyFlag = true;
    }

    public String getPSDataEntityName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDataEntityName();
        }
        return this.psdataentityname;
    }

    public boolean isPSDataEntityNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDataEntityNameDirty();
        }
        return this.psdataentitynameDirtyFlag;
    }

    public void resetPSDataEntityName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDataEntityName();
            return;
        }
        this.psdataentitynameDirtyFlag = false;
        this.psdataentityname = null;
    }

    public void setPSDEACModesCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEACModesCnt(n);
            return;
        }
        this.psdeacmodescnt = n;
        this.psdeacmodescntDirtyFlag = true;
    }

    public Integer getPSDEACModesCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEACModesCnt();
        }
        return this.psdeacmodescnt;
    }

    public boolean isPSDEACModesCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEACModesCntDirty();
        }
        return this.psdeacmodescntDirtyFlag;
    }

    public void resetPSDEACModesCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEACModesCnt();
            return;
        }
        this.psdeacmodescntDirtyFlag = false;
        this.psdeacmodescnt = null;
    }

    public void setPSDEActionLogicsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEActionLogicsCnt(n);
            return;
        }
        this.psdeactionlogicscnt = n;
        this.psdeactionlogicscntDirtyFlag = true;
    }

    public Integer getPSDEActionLogicsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionLogicsCnt();
        }
        return this.psdeactionlogicscnt;
    }

    public boolean isPSDEActionLogicsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEActionLogicsCntDirty();
        }
        return this.psdeactionlogicscntDirtyFlag;
    }

    public void resetPSDEActionLogicsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEActionLogicsCnt();
            return;
        }
        this.psdeactionlogicscntDirtyFlag = false;
        this.psdeactionlogicscnt = null;
    }

    public void setPSDEActionsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEActionsCnt(n);
            return;
        }
        this.psdeactionscnt = n;
        this.psdeactionscntDirtyFlag = true;
    }

    public Integer getPSDEActionsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionsCnt();
        }
        return this.psdeactionscnt;
    }

    public boolean isPSDEActionsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEActionsCntDirty();
        }
        return this.psdeactionscntDirtyFlag;
    }

    public void resetPSDEActionsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEActionsCnt();
            return;
        }
        this.psdeactionscntDirtyFlag = false;
        this.psdeactionscnt = null;
    }

    public void setPSDEAWGrpsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEAWGrpsCnt(n);
            return;
        }
        this.psdeawgrpscnt = n;
        this.psdeawgrpscntDirtyFlag = true;
    }

    public Integer getPSDEAWGrpsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEAWGrpsCnt();
        }
        return this.psdeawgrpscnt;
    }

    public boolean isPSDEAWGrpsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEAWGrpsCntDirty();
        }
        return this.psdeawgrpscntDirtyFlag;
    }

    public void resetPSDEAWGrpsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEAWGrpsCnt();
            return;
        }
        this.psdeawgrpscntDirtyFlag = false;
        this.psdeawgrpscnt = null;
    }

    public void setPSDEAWsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEAWsCnt(n);
            return;
        }
        this.psdeawscnt = n;
        this.psdeawscntDirtyFlag = true;
    }

    public Integer getPSDEAWsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEAWsCnt();
        }
        return this.psdeawscnt;
    }

    public boolean isPSDEAWsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEAWsCntDirty();
        }
        return this.psdeawscntDirtyFlag;
    }

    public void resetPSDEAWsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEAWsCnt();
            return;
        }
        this.psdeawscntDirtyFlag = false;
        this.psdeawscnt = null;
    }

    public void setPSDEChartsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEChartsCnt(n);
            return;
        }
        this.psdechartscnt = n;
        this.psdechartscntDirtyFlag = true;
    }

    public Integer getPSDEChartsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEChartsCnt();
        }
        return this.psdechartscnt;
    }

    public boolean isPSDEChartsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEChartsCntDirty();
        }
        return this.psdechartscntDirtyFlag;
    }

    public void resetPSDEChartsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEChartsCnt();
            return;
        }
        this.psdechartscntDirtyFlag = false;
        this.psdechartscnt = null;
    }

    public void setPSDEDataExpsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataExpsCnt(n);
            return;
        }
        this.psdedataexpscnt = n;
        this.psdedataexpscntDirtyFlag = true;
    }

    public Integer getPSDEDataExpsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataExpsCnt();
        }
        return this.psdedataexpscnt;
    }

    public boolean isPSDEDataExpsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataExpsCntDirty();
        }
        return this.psdedataexpscntDirtyFlag;
    }

    public void resetPSDEDataExpsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataExpsCnt();
            return;
        }
        this.psdedataexpscntDirtyFlag = false;
        this.psdedataexpscnt = null;
    }

    public void setPSDEDataImpsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataImpsCnt(n);
            return;
        }
        this.psdedataimpscnt = n;
        this.psdedataimpscntDirtyFlag = true;
    }

    public Integer getPSDEDataImpsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataImpsCnt();
        }
        return this.psdedataimpscnt;
    }

    public boolean isPSDEDataImpsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataImpsCntDirty();
        }
        return this.psdedataimpscntDirtyFlag;
    }

    public void resetPSDEDataImpsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataImpsCnt();
            return;
        }
        this.psdedataimpscntDirtyFlag = false;
        this.psdedataimpscnt = null;
    }

    public void setPSDEDataQuerysCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataQuerysCnt(n);
            return;
        }
        this.psdedataqueryscnt = n;
        this.psdedataqueryscntDirtyFlag = true;
    }

    public Integer getPSDEDataQuerysCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataQuerysCnt();
        }
        return this.psdedataqueryscnt;
    }

    public boolean isPSDEDataQuerysCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataQuerysCntDirty();
        }
        return this.psdedataqueryscntDirtyFlag;
    }

    public void resetPSDEDataQuerysCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataQuerysCnt();
            return;
        }
        this.psdedataqueryscntDirtyFlag = false;
        this.psdedataqueryscnt = null;
    }

    public void setPSDEDataRelationsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataRelationsCnt(n);
            return;
        }
        this.psdedatarelationscnt = n;
        this.psdedatarelationscntDirtyFlag = true;
    }

    public Integer getPSDEDataRelationsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataRelationsCnt();
        }
        return this.psdedatarelationscnt;
    }

    public boolean isPSDEDataRelationsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataRelationsCntDirty();
        }
        return this.psdedatarelationscntDirtyFlag;
    }

    public void resetPSDEDataRelationsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataRelationsCnt();
            return;
        }
        this.psdedatarelationscntDirtyFlag = false;
        this.psdedatarelationscnt = null;
    }

    public void setPSDEDataSetsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataSetsCnt(n);
            return;
        }
        this.psdedatasetscnt = n;
        this.psdedatasetscntDirtyFlag = true;
    }

    public Integer getPSDEDataSetsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataSetsCnt();
        }
        return this.psdedatasetscnt;
    }

    public boolean isPSDEDataSetsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataSetsCntDirty();
        }
        return this.psdedatasetscntDirtyFlag;
    }

    public void resetPSDEDataSetsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataSetsCnt();
            return;
        }
        this.psdedatasetscntDirtyFlag = false;
        this.psdedatasetscnt = null;
    }

    public void setPSDEDataSyncsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataSyncsCnt(n);
            return;
        }
        this.psdedatasyncscnt = n;
        this.psdedatasyncscntDirtyFlag = true;
    }

    public Integer getPSDEDataSyncsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataSyncsCnt();
        }
        return this.psdedatasyncscnt;
    }

    public boolean isPSDEDataSyncsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataSyncsCntDirty();
        }
        return this.psdedatasyncscntDirtyFlag;
    }

    public void resetPSDEDataSyncsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataSyncsCnt();
            return;
        }
        this.psdedatasyncscntDirtyFlag = false;
        this.psdedatasyncscnt = null;
    }

    public void setPSDEDataViewsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataViewsCnt(n);
            return;
        }
        this.psdedataviewscnt = n;
        this.psdedataviewscntDirtyFlag = true;
    }

    public Integer getPSDEDataViewsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataViewsCnt();
        }
        return this.psdedataviewscnt;
    }

    public boolean isPSDEDataViewsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataViewsCntDirty();
        }
        return this.psdedataviewscntDirtyFlag;
    }

    public void resetPSDEDataViewsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataViewsCnt();
            return;
        }
        this.psdedataviewscntDirtyFlag = false;
        this.psdedataviewscnt = null;
    }

    public void setPSDEDBCfgsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDBCfgsCnt(n);
            return;
        }
        this.psdedbcfgscnt = n;
        this.psdedbcfgscntDirtyFlag = true;
    }

    public Integer getPSDEDBCfgsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDBCfgsCnt();
        }
        return this.psdedbcfgscnt;
    }

    public boolean isPSDEDBCfgsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDBCfgsCntDirty();
        }
        return this.psdedbcfgscntDirtyFlag;
    }

    public void resetPSDEDBCfgsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDBCfgsCnt();
            return;
        }
        this.psdedbcfgscntDirtyFlag = false;
        this.psdedbcfgscnt = null;
    }

    public void setPSDEDBIndexsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDBIndexsCnt(n);
            return;
        }
        this.psdedbindexscnt = n;
        this.psdedbindexscntDirtyFlag = true;
    }

    public Integer getPSDEDBIndexsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDBIndexsCnt();
        }
        return this.psdedbindexscnt;
    }

    public boolean isPSDEDBIndexsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDBIndexsCntDirty();
        }
        return this.psdedbindexscntDirtyFlag;
    }

    public void resetPSDEDBIndexsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDBIndexsCnt();
            return;
        }
        this.psdedbindexscntDirtyFlag = false;
        this.psdedbindexscnt = null;
    }

    public void setPSDEDRGroupsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDRGroupsCnt(n);
            return;
        }
        this.psdedrgroupscnt = n;
        this.psdedrgroupscntDirtyFlag = true;
    }

    public Integer getPSDEDRGroupsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDRGroupsCnt();
        }
        return this.psdedrgroupscnt;
    }

    public boolean isPSDEDRGroupsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDRGroupsCntDirty();
        }
        return this.psdedrgroupscntDirtyFlag;
    }

    public void resetPSDEDRGroupsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDRGroupsCnt();
            return;
        }
        this.psdedrgroupscntDirtyFlag = false;
        this.psdedrgroupscnt = null;
    }

    public void setPSDEDRItemsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDRItemsCnt(n);
            return;
        }
        this.psdedritemscnt = n;
        this.psdedritemscntDirtyFlag = true;
    }

    public Integer getPSDEDRItemsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDRItemsCnt();
        }
        return this.psdedritemscnt;
    }

    public boolean isPSDEDRItemsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDRItemsCntDirty();
        }
        return this.psdedritemscntDirtyFlag;
    }

    public void resetPSDEDRItemsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDRItemsCnt();
            return;
        }
        this.psdedritemscntDirtyFlag = false;
        this.psdedritemscnt = null;
    }

    public void setPSDEDTSQueuesCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDTSQueuesCnt(n);
            return;
        }
        this.psdedtsqueuescnt = n;
        this.psdedtsqueuescntDirtyFlag = true;
    }

    public Integer getPSDEDTSQueuesCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDTSQueuesCnt();
        }
        return this.psdedtsqueuescnt;
    }

    public boolean isPSDEDTSQueuesCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDTSQueuesCntDirty();
        }
        return this.psdedtsqueuescntDirtyFlag;
    }

    public void resetPSDEDTSQueuesCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDTSQueuesCnt();
            return;
        }
        this.psdedtsqueuescntDirtyFlag = false;
        this.psdedtsqueuescnt = null;
    }

    public void setPSDEFieldsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFieldsCnt(n);
            return;
        }
        this.psdefieldscnt = n;
        this.psdefieldscntDirtyFlag = true;
    }

    public Integer getPSDEFieldsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFieldsCnt();
        }
        return this.psdefieldscnt;
    }

    public boolean isPSDEFieldsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFieldsCntDirty();
        }
        return this.psdefieldscntDirtyFlag;
    }

    public void resetPSDEFieldsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFieldsCnt();
            return;
        }
        this.psdefieldscntDirtyFlag = false;
        this.psdefieldscnt = null;
    }

    public void setPSDEFInputTipSetId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFInputTipSetId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefinputtipsetid = string;
        this.psdefinputtipsetidDirtyFlag = true;
    }

    public String getPSDEFInputTipSetId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFInputTipSetId();
        }
        return this.psdefinputtipsetid;
    }

    public boolean isPSDEFInputTipSetIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFInputTipSetIdDirty();
        }
        return this.psdefinputtipsetidDirtyFlag;
    }

    public void resetPSDEFInputTipSetId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFInputTipSetId();
            return;
        }
        this.psdefinputtipsetidDirtyFlag = false;
        this.psdefinputtipsetid = null;
    }

    public void setPSDEFInputTipSetName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFInputTipSetName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefinputtipsetname = string;
        this.psdefinputtipsetnameDirtyFlag = true;
    }

    public String getPSDEFInputTipSetName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFInputTipSetName();
        }
        return this.psdefinputtipsetname;
    }

    public boolean isPSDEFInputTipSetNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFInputTipSetNameDirty();
        }
        return this.psdefinputtipsetnameDirtyFlag;
    }

    public void resetPSDEFInputTipSetName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFInputTipSetName();
            return;
        }
        this.psdefinputtipsetnameDirtyFlag = false;
        this.psdefinputtipsetname = null;
    }

    public void setPSDEFormsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFormsCnt(n);
            return;
        }
        this.psdeformscnt = n;
        this.psdeformscntDirtyFlag = true;
    }

    public Integer getPSDEFormsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFormsCnt();
        }
        return this.psdeformscnt;
    }

    public boolean isPSDEFormsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFormsCntDirty();
        }
        return this.psdeformscntDirtyFlag;
    }

    public void resetPSDEFormsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFormsCnt();
            return;
        }
        this.psdeformscntDirtyFlag = false;
        this.psdeformscnt = null;
    }

    public void setPSDEFSFItemsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFSFItemsCnt(n);
            return;
        }
        this.psdefsfitemscnt = n;
        this.psdefsfitemscntDirtyFlag = true;
    }

    public Integer getPSDEFSFItemsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFSFItemsCnt();
        }
        return this.psdefsfitemscnt;
    }

    public boolean isPSDEFSFItemsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFSFItemsCntDirty();
        }
        return this.psdefsfitemscntDirtyFlag;
    }

    public void resetPSDEFSFItemsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFSFItemsCnt();
            return;
        }
        this.psdefsfitemscntDirtyFlag = false;
        this.psdefsfitemscnt = null;
    }

    public void setPSDEFValueRulesCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFValueRulesCnt(n);
            return;
        }
        this.psdefvaluerulescnt = n;
        this.psdefvaluerulescntDirtyFlag = true;
    }

    public Integer getPSDEFValueRulesCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFValueRulesCnt();
        }
        return this.psdefvaluerulescnt;
    }

    public boolean isPSDEFValueRulesCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFValueRulesCntDirty();
        }
        return this.psdefvaluerulescntDirtyFlag;
    }

    public void resetPSDEFValueRulesCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFValueRulesCnt();
            return;
        }
        this.psdefvaluerulescntDirtyFlag = false;
        this.psdefvaluerulescnt = null;
    }

    public void setPSDEGridsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEGridsCnt(n);
            return;
        }
        this.psdegridscnt = n;
        this.psdegridscntDirtyFlag = true;
    }

    public Integer getPSDEGridsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGridsCnt();
        }
        return this.psdegridscnt;
    }

    public boolean isPSDEGridsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEGridsCntDirty();
        }
        return this.psdegridscntDirtyFlag;
    }

    public void resetPSDEGridsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEGridsCnt();
            return;
        }
        this.psdegridscntDirtyFlag = false;
        this.psdegridscnt = null;
    }

    public void setPSDEListsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEListsCnt(n);
            return;
        }
        this.psdelistscnt = n;
        this.psdelistscntDirtyFlag = true;
    }

    public Integer getPSDEListsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEListsCnt();
        }
        return this.psdelistscnt;
    }

    public boolean isPSDEListsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEListsCntDirty();
        }
        return this.psdelistscntDirtyFlag;
    }

    public void resetPSDEListsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEListsCnt();
            return;
        }
        this.psdelistscntDirtyFlag = false;
        this.psdelistscnt = null;
    }

    public void setPSDELogicsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDELogicsCnt(n);
            return;
        }
        this.psdelogicscnt = n;
        this.psdelogicscntDirtyFlag = true;
    }

    public Integer getPSDELogicsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELogicsCnt();
        }
        return this.psdelogicscnt;
    }

    public boolean isPSDELogicsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDELogicsCntDirty();
        }
        return this.psdelogicscntDirtyFlag;
    }

    public void resetPSDELogicsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDELogicsCnt();
            return;
        }
        this.psdelogicscntDirtyFlag = false;
        this.psdelogicscnt = null;
    }

    public void setPSDEMainStatesCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEMainStatesCnt(n);
            return;
        }
        this.psdemainstatescnt = n;
        this.psdemainstatescntDirtyFlag = true;
    }

    public Integer getPSDEMainStatesCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMainStatesCnt();
        }
        return this.psdemainstatescnt;
    }

    public boolean isPSDEMainStatesCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEMainStatesCntDirty();
        }
        return this.psdemainstatescntDirtyFlag;
    }

    public void resetPSDEMainStatesCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEMainStatesCnt();
            return;
        }
        this.psdemainstatescntDirtyFlag = false;
        this.psdemainstatescnt = null;
    }

    public void setPSDEOPPrivRolesCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEOPPrivRolesCnt(n);
            return;
        }
        this.psdeopprivrolescnt = n;
        this.psdeopprivrolescntDirtyFlag = true;
    }

    public Integer getPSDEOPPrivRolesCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEOPPrivRolesCnt();
        }
        return this.psdeopprivrolescnt;
    }

    public boolean isPSDEOPPrivRolesCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEOPPrivRolesCntDirty();
        }
        return this.psdeopprivrolescntDirtyFlag;
    }

    public void resetPSDEOPPrivRolesCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEOPPrivRolesCnt();
            return;
        }
        this.psdeopprivrolescntDirtyFlag = false;
        this.psdeopprivrolescnt = null;
    }

    public void setPSDEOPPrivsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEOPPrivsCnt(n);
            return;
        }
        this.psdeopprivscnt = n;
        this.psdeopprivscntDirtyFlag = true;
    }

    public Integer getPSDEOPPrivsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEOPPrivsCnt();
        }
        return this.psdeopprivscnt;
    }

    public boolean isPSDEOPPrivsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEOPPrivsCntDirty();
        }
        return this.psdeopprivscntDirtyFlag;
    }

    public void resetPSDEOPPrivsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEOPPrivsCnt();
            return;
        }
        this.psdeopprivscntDirtyFlag = false;
        this.psdeopprivscnt = null;
    }

    public void setPSDEPrintsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEPrintsCnt(n);
            return;
        }
        this.psdeprintscnt = n;
        this.psdeprintscntDirtyFlag = true;
    }

    public Integer getPSDEPrintsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEPrintsCnt();
        }
        return this.psdeprintscnt;
    }

    public boolean isPSDEPrintsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEPrintsCntDirty();
        }
        return this.psdeprintscntDirtyFlag;
    }

    public void resetPSDEPrintsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEPrintsCnt();
            return;
        }
        this.psdeprintscntDirtyFlag = false;
        this.psdeprintscnt = null;
    }

    public void setPSDEReportsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEReportsCnt(n);
            return;
        }
        this.psdereportscnt = n;
        this.psdereportscntDirtyFlag = true;
    }

    public Integer getPSDEReportsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEReportsCnt();
        }
        return this.psdereportscnt;
    }

    public boolean isPSDEReportsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEReportsCntDirty();
        }
        return this.psdereportscntDirtyFlag;
    }

    public void resetPSDEReportsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEReportsCnt();
            return;
        }
        this.psdereportscntDirtyFlag = false;
        this.psdereportscnt = null;
    }

    public void setPSDEServiceAPIsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEServiceAPIsCnt(n);
            return;
        }
        this.psdeserviceapiscnt = n;
        this.psdeserviceapiscntDirtyFlag = true;
    }

    public Integer getPSDEServiceAPIsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEServiceAPIsCnt();
        }
        return this.psdeserviceapiscnt;
    }

    public boolean isPSDEServiceAPIsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEServiceAPIsCntDirty();
        }
        return this.psdeserviceapiscntDirtyFlag;
    }

    public void resetPSDEServiceAPIsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEServiceAPIsCnt();
            return;
        }
        this.psdeserviceapiscntDirtyFlag = false;
        this.psdeserviceapiscnt = null;
    }

    public void setPSDEToolbarsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEToolbarsCnt(n);
            return;
        }
        this.psdetoolbarscnt = n;
        this.psdetoolbarscntDirtyFlag = true;
    }

    public Integer getPSDEToolbarsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEToolbarsCnt();
        }
        return this.psdetoolbarscnt;
    }

    public boolean isPSDEToolbarsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEToolbarsCntDirty();
        }
        return this.psdetoolbarscntDirtyFlag;
    }

    public void resetPSDEToolbarsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEToolbarsCnt();
            return;
        }
        this.psdetoolbarscntDirtyFlag = false;
        this.psdetoolbarscnt = null;
    }

    public void setPSDETreeViewsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDETreeViewsCnt(n);
            return;
        }
        this.psdetreeviewscnt = n;
        this.psdetreeviewscntDirtyFlag = true;
    }

    public Integer getPSDETreeViewsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETreeViewsCnt();
        }
        return this.psdetreeviewscnt;
    }

    public boolean isPSDETreeViewsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDETreeViewsCntDirty();
        }
        return this.psdetreeviewscntDirtyFlag;
    }

    public void resetPSDETreeViewsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDETreeViewsCnt();
            return;
        }
        this.psdetreeviewscntDirtyFlag = false;
        this.psdetreeviewscnt = null;
    }

    public void setPSDEUAGroupsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEUAGroupsCnt(n);
            return;
        }
        this.psdeuagroupscnt = n;
        this.psdeuagroupscntDirtyFlag = true;
    }

    public Integer getPSDEUAGroupsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUAGroupsCnt();
        }
        return this.psdeuagroupscnt;
    }

    public boolean isPSDEUAGroupsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEUAGroupsCntDirty();
        }
        return this.psdeuagroupscntDirtyFlag;
    }

    public void resetPSDEUAGroupsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEUAGroupsCnt();
            return;
        }
        this.psdeuagroupscntDirtyFlag = false;
        this.psdeuagroupscnt = null;
    }

    public void setPSDEUIActionsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEUIActionsCnt(n);
            return;
        }
        this.psdeuiactionscnt = n;
        this.psdeuiactionscntDirtyFlag = true;
    }

    public Integer getPSDEUIActionsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUIActionsCnt();
        }
        return this.psdeuiactionscnt;
    }

    public boolean isPSDEUIActionsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEUIActionsCntDirty();
        }
        return this.psdeuiactionscntDirtyFlag;
    }

    public void resetPSDEUIActionsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEUIActionsCnt();
            return;
        }
        this.psdeuiactionscntDirtyFlag = false;
        this.psdeuiactionscnt = null;
    }

    public void setPSDEUserRolesCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEUserRolesCnt(n);
            return;
        }
        this.psdeuserrolescnt = n;
        this.psdeuserrolescntDirtyFlag = true;
    }

    public Integer getPSDEUserRolesCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUserRolesCnt();
        }
        return this.psdeuserrolescnt;
    }

    public boolean isPSDEUserRolesCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEUserRolesCntDirty();
        }
        return this.psdeuserrolescntDirtyFlag;
    }

    public void resetPSDEUserRolesCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEUserRolesCnt();
            return;
        }
        this.psdeuserrolescntDirtyFlag = false;
        this.psdeuserrolescnt = null;
    }

    public void setPSDEViewBasesCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewBasesCnt(n);
            return;
        }
        this.psdeviewbasescnt = n;
        this.psdeviewbasescntDirtyFlag = true;
    }

    public Integer getPSDEViewBasesCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBasesCnt();
        }
        return this.psdeviewbasescnt;
    }

    public boolean isPSDEViewBasesCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewBasesCntDirty();
        }
        return this.psdeviewbasescntDirtyFlag;
    }

    public void resetPSDEViewBasesCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewBasesCnt();
            return;
        }
        this.psdeviewbasescntDirtyFlag = false;
        this.psdeviewbasescnt = null;
    }

    public void setPSDEWizardsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEWizardsCnt(n);
            return;
        }
        this.psdewizardscnt = n;
        this.psdewizardscntDirtyFlag = true;
    }

    public Integer getPSDEWizardsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEWizardsCnt();
        }
        return this.psdewizardscnt;
    }

    public boolean isPSDEWizardsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEWizardsCntDirty();
        }
        return this.psdewizardscntDirtyFlag;
    }

    public void resetPSDEWizardsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEWizardsCnt();
            return;
        }
        this.psdewizardscntDirtyFlag = false;
        this.psdewizardscnt = null;
    }

    public void setPSDynaDETemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaDETemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynadetemplid = string;
        this.psdynadetemplidDirtyFlag = true;
    }

    public String getPSDynaDETemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaDETemplId();
        }
        return this.psdynadetemplid;
    }

    public boolean isPSDynaDETemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaDETemplIdDirty();
        }
        return this.psdynadetemplidDirtyFlag;
    }

    public void resetPSDynaDETemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaDETemplId();
            return;
        }
        this.psdynadetemplidDirtyFlag = false;
        this.psdynadetemplid = null;
    }

    public void setPSDynaDETemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaDETemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynadetemplname = string;
        this.psdynadetemplnameDirtyFlag = true;
    }

    public String getPSDynaDETemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaDETemplName();
        }
        return this.psdynadetemplname;
    }

    public boolean isPSDynaDETemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaDETemplNameDirty();
        }
        return this.psdynadetemplnameDirtyFlag;
    }

    public void resetPSDynaDETemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaDETemplName();
            return;
        }
        this.psdynadetemplnameDirtyFlag = false;
        this.psdynadetemplname = null;
    }

    public void setPSDynaInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynainstid = string;
        this.psdynainstidDirtyFlag = true;
    }

    public String getPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaInstId();
        }
        return this.psdynainstid;
    }

    public boolean isPSDynaInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaInstIdDirty();
        }
        return this.psdynainstidDirtyFlag;
    }

    public void resetPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaInstId();
            return;
        }
        this.psdynainstidDirtyFlag = false;
        this.psdynainstid = null;
    }

    public void setPSHelpModuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSHelpModuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pshelpmoduleid = string;
        this.pshelpmoduleidDirtyFlag = true;
    }

    public String getPSHelpModuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpModuleId();
        }
        return this.pshelpmoduleid;
    }

    public boolean isPSHelpModuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSHelpModuleIdDirty();
        }
        return this.pshelpmoduleidDirtyFlag;
    }

    public void resetPSHelpModuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSHelpModuleId();
            return;
        }
        this.pshelpmoduleidDirtyFlag = false;
        this.pshelpmoduleid = null;
    }

    public void setPSHelpModuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSHelpModuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pshelpmodulename = string;
        this.pshelpmodulenameDirtyFlag = true;
    }

    public String getPSHelpModuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpModuleName();
        }
        return this.pshelpmodulename;
    }

    public boolean isPSHelpModuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSHelpModuleNameDirty();
        }
        return this.pshelpmodulenameDirtyFlag;
    }

    public void resetPSHelpModuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSHelpModuleName();
            return;
        }
        this.pshelpmodulenameDirtyFlag = false;
        this.pshelpmodulename = null;
    }

    public void setPSModuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmoduleid = string;
        this.psmoduleidDirtyFlag = true;
    }

    public String getPSModuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModuleId();
        }
        return this.psmoduleid;
    }

    public boolean isPSModuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModuleIdDirty();
        }
        return this.psmoduleidDirtyFlag;
    }

    public void resetPSModuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModuleId();
            return;
        }
        this.psmoduleidDirtyFlag = false;
        this.psmoduleid = null;
    }

    public void setPSModuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodulename = string;
        this.psmodulenameDirtyFlag = true;
    }

    public String getPSModuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModuleName();
        }
        return this.psmodulename;
    }

    public boolean isPSModuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModuleNameDirty();
        }
        return this.psmodulenameDirtyFlag;
    }

    public void resetPSModuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModuleName();
            return;
        }
        this.psmodulenameDirtyFlag = false;
        this.psmodulename = null;
    }

    public void setPSSubSysSADEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysSADEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsyssadeid = string;
        this.pssubsyssadeidDirtyFlag = true;
    }

    public String getPSSubSysSADEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysSADEId();
        }
        return this.pssubsyssadeid;
    }

    public boolean isPSSubSysSADEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysSADEIdDirty();
        }
        return this.pssubsyssadeidDirtyFlag;
    }

    public void resetPSSubSysSADEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysSADEId();
            return;
        }
        this.pssubsyssadeidDirtyFlag = false;
        this.pssubsyssadeid = null;
    }

    public void setPSSubSysSADEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysSADEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsyssadename = string;
        this.pssubsyssadenameDirtyFlag = true;
    }

    public String getPSSubSysSADEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysSADEName();
        }
        return this.pssubsyssadename;
    }

    public boolean isPSSubSysSADENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysSADENameDirty();
        }
        return this.pssubsyssadenameDirtyFlag;
    }

    public void resetPSSubSysSADEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysSADEName();
            return;
        }
        this.pssubsyssadenameDirtyFlag = false;
        this.pssubsyssadename = null;
    }

    public void setPSSubSysServiceAPIId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysServiceAPIId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsysserviceapiid = string;
        this.pssubsysserviceapiidDirtyFlag = true;
    }

    public String getPSSubSysServiceAPIId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysServiceAPIId();
        }
        return this.pssubsysserviceapiid;
    }

    public boolean isPSSubSysServiceAPIIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysServiceAPIIdDirty();
        }
        return this.pssubsysserviceapiidDirtyFlag;
    }

    public void resetPSSubSysServiceAPIId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysServiceAPIId();
            return;
        }
        this.pssubsysserviceapiidDirtyFlag = false;
        this.pssubsysserviceapiid = null;
    }

    public void setPSSubSysServiceAPIName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysServiceAPIName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsysserviceapiname = string;
        this.pssubsysserviceapinameDirtyFlag = true;
    }

    public String getPSSubSysServiceAPIName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysServiceAPIName();
        }
        return this.pssubsysserviceapiname;
    }

    public boolean isPSSubSysServiceAPINameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysServiceAPINameDirty();
        }
        return this.pssubsysserviceapinameDirtyFlag;
    }

    public void resetPSSubSysServiceAPIName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysServiceAPIName();
            return;
        }
        this.pssubsysserviceapinameDirtyFlag = false;
        this.pssubsysserviceapiname = null;
    }

    public void setPSSysBDTablesCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBDTablesCnt(n);
            return;
        }
        this.pssysbdtablescnt = n;
        this.pssysbdtablescntDirtyFlag = true;
    }

    public Integer getPSSysBDTablesCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDTablesCnt();
        }
        return this.pssysbdtablescnt;
    }

    public boolean isPSSysBDTablesCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBDTablesCntDirty();
        }
        return this.pssysbdtablescntDirtyFlag;
    }

    public void resetPSSysBDTablesCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBDTablesCnt();
            return;
        }
        this.pssysbdtablescntDirtyFlag = false;
        this.pssysbdtablescnt = null;
    }

    public void setPSSysCountersCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCountersCnt(n);
            return;
        }
        this.pssyscounterscnt = n;
        this.pssyscounterscntDirtyFlag = true;
    }

    public Integer getPSSysCountersCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCountersCnt();
        }
        return this.pssyscounterscnt;
    }

    public boolean isPSSysCountersCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCountersCntDirty();
        }
        return this.pssyscounterscntDirtyFlag;
    }

    public void resetPSSysCountersCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCountersCnt();
            return;
        }
        this.pssyscounterscntDirtyFlag = false;
        this.pssyscounterscnt = null;
    }

    public void setPSSysDMItemsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDMItemsCnt(n);
            return;
        }
        this.pssysdmitemscnt = n;
        this.pssysdmitemscntDirtyFlag = true;
    }

    public Integer getPSSysDMItemsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDMItemsCnt();
        }
        return this.pssysdmitemscnt;
    }

    public boolean isPSSysDMItemsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDMItemsCntDirty();
        }
        return this.pssysdmitemscntDirtyFlag;
    }

    public void resetPSSysDMItemsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDMItemsCnt();
            return;
        }
        this.pssysdmitemscntDirtyFlag = false;
        this.pssysdmitemscnt = null;
    }

    public void setPSSysDynaModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDynaModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdynamodelid = string;
        this.pssysdynamodelidDirtyFlag = true;
    }

    public String getPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModelId();
        }
        return this.pssysdynamodelid;
    }

    public boolean isPSSysDynaModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDynaModelIdDirty();
        }
        return this.pssysdynamodelidDirtyFlag;
    }

    public void resetPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDynaModelId();
            return;
        }
        this.pssysdynamodelidDirtyFlag = false;
        this.pssysdynamodelid = null;
    }

    public void setPSSysDynaModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDynaModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdynamodelname = string;
        this.pssysdynamodelnameDirtyFlag = true;
    }

    public String getPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModelName();
        }
        return this.pssysdynamodelname;
    }

    public boolean isPSSysDynaModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDynaModelNameDirty();
        }
        return this.pssysdynamodelnameDirtyFlag;
    }

    public void resetPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDynaModelName();
            return;
        }
        this.pssysdynamodelnameDirtyFlag = false;
        this.pssysdynamodelname = null;
    }

    public void setPSSysImageId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysImageId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysimageid = string;
        this.pssysimageidDirtyFlag = true;
    }

    public String getPSSysImageId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysImageId();
        }
        return this.pssysimageid;
    }

    public boolean isPSSysImageIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysImageIdDirty();
        }
        return this.pssysimageidDirtyFlag;
    }

    public void resetPSSysImageId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysImageId();
            return;
        }
        this.pssysimageidDirtyFlag = false;
        this.pssysimageid = null;
    }

    public void setPSSysImageName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysImageName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysimagename = string;
        this.pssysimagenameDirtyFlag = true;
    }

    public String getPSSysImageName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysImageName();
        }
        return this.pssysimagename;
    }

    public boolean isPSSysImageNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysImageNameDirty();
        }
        return this.pssysimagenameDirtyFlag;
    }

    public void resetPSSysImageName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysImageName();
            return;
        }
        this.pssysimagenameDirtyFlag = false;
        this.pssysimagename = null;
    }

    public void setPSSysModelChgLogsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelChgLogsCnt(n);
            return;
        }
        this.pssysmodelchglogscnt = n;
        this.pssysmodelchglogscntDirtyFlag = true;
    }

    public Integer getPSSysModelChgLogsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelChgLogsCnt();
        }
        return this.pssysmodelchglogscnt;
    }

    public boolean isPSSysModelChgLogsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelChgLogsCntDirty();
        }
        return this.pssysmodelchglogscntDirtyFlag;
    }

    public void resetPSSysModelChgLogsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelChgLogsCnt();
            return;
        }
        this.pssysmodelchglogscntDirtyFlag = false;
        this.pssysmodelchglogscnt = null;
    }

    public void setPSSysModelGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelgroupid = string;
        this.pssysmodelgroupidDirtyFlag = true;
    }

    public String getPSSysModelGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelGroupId();
        }
        return this.pssysmodelgroupid;
    }

    public boolean isPSSysModelGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelGroupIdDirty();
        }
        return this.pssysmodelgroupidDirtyFlag;
    }

    public void resetPSSysModelGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelGroupId();
            return;
        }
        this.pssysmodelgroupidDirtyFlag = false;
        this.pssysmodelgroupid = null;
    }

    public void setPSSysModelGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelgroupname = string;
        this.pssysmodelgroupnameDirtyFlag = true;
    }

    public String getPSSysModelGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelGroupName();
        }
        return this.pssysmodelgroupname;
    }

    public boolean isPSSysModelGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelGroupNameDirty();
        }
        return this.pssysmodelgroupnameDirtyFlag;
    }

    public void resetPSSysModelGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelGroupName();
            return;
        }
        this.pssysmodelgroupnameDirtyFlag = false;
        this.pssysmodelgroupname = null;
    }

    public void setPSSysReqItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysReqItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysreqitemid = string;
        this.pssysreqitemidDirtyFlag = true;
    }

    public String getPSSysReqItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItemId();
        }
        return this.pssysreqitemid;
    }

    public boolean isPSSysReqItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysReqItemIdDirty();
        }
        return this.pssysreqitemidDirtyFlag;
    }

    public void resetPSSysReqItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysReqItemId();
            return;
        }
        this.pssysreqitemidDirtyFlag = false;
        this.pssysreqitemid = null;
    }

    public void setPSSysReqItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysReqItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysreqitemname = string;
        this.pssysreqitemnameDirtyFlag = true;
    }

    public String getPSSysReqItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItemName();
        }
        return this.pssysreqitemname;
    }

    public boolean isPSSysReqItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysReqItemNameDirty();
        }
        return this.pssysreqitemnameDirtyFlag;
    }

    public void resetPSSysReqItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysReqItemName();
            return;
        }
        this.pssysreqitemnameDirtyFlag = false;
        this.pssysreqitemname = null;
    }

    public void setPSSysSFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpluginid = string;
        this.pssyssfpluginidDirtyFlag = true;
    }

    public String getPSSysSFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPluginId();
        }
        return this.pssyssfpluginid;
    }

    public boolean isPSSysSFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPluginIdDirty();
        }
        return this.pssyssfpluginidDirtyFlag;
    }

    public void resetPSSysSFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPluginId();
            return;
        }
        this.pssyssfpluginidDirtyFlag = false;
        this.pssyssfpluginid = null;
    }

    public void setPSSysSFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpluginname = string;
        this.pssyssfpluginnameDirtyFlag = true;
    }

    public String getPSSysSFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPluginName();
        }
        return this.pssyssfpluginname;
    }

    public boolean isPSSysSFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPluginNameDirty();
        }
        return this.pssyssfpluginnameDirtyFlag;
    }

    public void resetPSSysSFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPluginName();
            return;
        }
        this.pssyssfpluginnameDirtyFlag = false;
        this.pssyssfpluginname = null;
    }

    public void setPSSysTasksCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTasksCnt(n);
            return;
        }
        this.pssystaskscnt = n;
        this.pssystaskscntDirtyFlag = true;
    }

    public Integer getPSSysTasksCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTasksCnt();
        }
        return this.pssystaskscnt;
    }

    public boolean isPSSysTasksCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTasksCntDirty();
        }
        return this.pssystaskscntDirtyFlag;
    }

    public void resetPSSysTasksCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTasksCnt();
            return;
        }
        this.pssystaskscntDirtyFlag = false;
        this.pssystaskscnt = null;
    }

    public void setPSSystemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemid = string;
        this.pssystemidDirtyFlag = true;
    }

    public String getPSSystemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemId();
        }
        return this.pssystemid;
    }

    public boolean isPSSystemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemIdDirty();
        }
        return this.pssystemidDirtyFlag;
    }

    public void resetPSSystemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemId();
            return;
        }
        this.pssystemidDirtyFlag = false;
        this.pssystemid = null;
    }

    public void setPSSystemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemname = string;
        this.pssystemnameDirtyFlag = true;
    }

    public String getPSSystemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemName();
        }
        return this.pssystemname;
    }

    public boolean isPSSystemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemNameDirty();
        }
        return this.pssystemnameDirtyFlag;
    }

    public void resetPSSystemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemName();
            return;
        }
        this.pssystemnameDirtyFlag = false;
        this.pssystemname = null;
    }

    public void setPSSysTestCasesCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTestCasesCnt(n);
            return;
        }
        this.pssystestcasescnt = n;
        this.pssystestcasescntDirtyFlag = true;
    }

    public Integer getPSSysTestCasesCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTestCasesCnt();
        }
        return this.pssystestcasescnt;
    }

    public boolean isPSSysTestCasesCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTestCasesCntDirty();
        }
        return this.pssystestcasescntDirtyFlag;
    }

    public void resetPSSysTestCasesCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTestCasesCnt();
            return;
        }
        this.pssystestcasescntDirtyFlag = false;
        this.pssystestcasescnt = null;
    }

    public void setPSSysTestDatasCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTestDatasCnt(n);
            return;
        }
        this.pssystestdatascnt = n;
        this.pssystestdatascntDirtyFlag = true;
    }

    public Integer getPSSysTestDatasCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTestDatasCnt();
        }
        return this.pssystestdatascnt;
    }

    public boolean isPSSysTestDatasCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTestDatasCntDirty();
        }
        return this.pssystestdatascntDirtyFlag;
    }

    public void resetPSSysTestDatasCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTestDatasCnt();
            return;
        }
        this.pssystestdatascntDirtyFlag = false;
        this.pssystestdatascnt = null;
    }

    public void setPSSysUniResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUniResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysuniresid = string;
        this.pssysuniresidDirtyFlag = true;
    }

    public String getPSSysUniResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUniResId();
        }
        return this.pssysuniresid;
    }

    public boolean isPSSysUniResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUniResIdDirty();
        }
        return this.pssysuniresidDirtyFlag;
    }

    public void resetPSSysUniResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUniResId();
            return;
        }
        this.pssysuniresidDirtyFlag = false;
        this.pssysuniresid = null;
    }

    public void setPSSysUniResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUniResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysuniresname = string;
        this.pssysuniresnameDirtyFlag = true;
    }

    public String getPSSysUniResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUniResName();
        }
        return this.pssysuniresname;
    }

    public boolean isPSSysUniResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUniResNameDirty();
        }
        return this.pssysuniresnameDirtyFlag;
    }

    public void resetPSSysUniResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUniResName();
            return;
        }
        this.pssysuniresnameDirtyFlag = false;
        this.pssysuniresname = null;
    }

    public void setPSWFDEsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFDEsCnt(n);
            return;
        }
        this.pswfdescnt = n;
        this.pswfdescntDirtyFlag = true;
    }

    public Integer getPSWFDEsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFDEsCnt();
        }
        return this.pswfdescnt;
    }

    public boolean isPSWFDEsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFDEsCntDirty();
        }
        return this.pswfdescntDirtyFlag;
    }

    public void resetPSWFDEsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFDEsCnt();
            return;
        }
        this.pswfdescntDirtyFlag = false;
        this.pswfdescnt = null;
    }

    public void setReadOnlyMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReadOnlyMode(n);
            return;
        }
        this.readonlymode = n;
        this.readonlymodeDirtyFlag = true;
    }

    public Integer getReadOnlyMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReadOnlyMode();
        }
        return this.readonlymode;
    }

    public boolean isReadOnlyModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReadOnlyModeDirty();
        }
        return this.readonlymodeDirtyFlag;
    }

    public void resetReadOnlyMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReadOnlyMode();
            return;
        }
        this.readonlymodeDirtyFlag = false;
        this.readonlymode = null;
    }

    public void setRemoveFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRemoveFlag(n);
            return;
        }
        this.removeflag = n;
        this.removeflagDirtyFlag = true;
    }

    public Integer getRemoveFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRemoveFlag();
        }
        return this.removeflag;
    }

    public boolean isRemoveFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRemoveFlagDirty();
        }
        return this.removeflagDirtyFlag;
    }

    public void resetRemoveFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRemoveFlag();
            return;
        }
        this.removeflagDirtyFlag = false;
        this.removeflag = null;
    }

    public void setSaaSMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSaaSMode(n);
            return;
        }
        this.saasmode = n;
        this.saasmodeDirtyFlag = true;
    }

    public Integer getSaaSMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSaaSMode();
        }
        return this.saasmode;
    }

    public boolean isSaaSModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSaaSModeDirty();
        }
        return this.saasmodeDirtyFlag;
    }

    public void resetSaaSMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSaaSMode();
            return;
        }
        this.saasmodeDirtyFlag = false;
        this.saasmode = null;
    }

    public void setServiceAPIFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServiceAPIFlag(n);
            return;
        }
        this.serviceapiflag = n;
        this.serviceapiflagDirtyFlag = true;
    }

    public Integer getServiceAPIFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServiceAPIFlag();
        }
        return this.serviceapiflag;
    }

    public boolean isServiceAPIFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServiceAPIFlagDirty();
        }
        return this.serviceapiflagDirtyFlag;
    }

    public void resetServiceAPIFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServiceAPIFlag();
            return;
        }
        this.serviceapiflagDirtyFlag = false;
        this.serviceapiflag = null;
    }

    public void setServiceCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServiceCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.servicecodename = string;
        this.servicecodenameDirtyFlag = true;
    }

    public String getServiceCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServiceCodeName();
        }
        return this.servicecodename;
    }

    public boolean isServiceCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServiceCodeNameDirty();
        }
        return this.servicecodenameDirtyFlag;
    }

    public void resetServiceCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServiceCodeName();
            return;
        }
        this.servicecodenameDirtyFlag = false;
        this.servicecodename = null;
    }

    public void setSrcPSDEMapsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrcPSDEMapsCnt(n);
            return;
        }
        this.srcpsdemapscnt = n;
        this.srcpsdemapscntDirtyFlag = true;
    }

    public Integer getSrcPSDEMapsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcPSDEMapsCnt();
        }
        return this.srcpsdemapscnt;
    }

    public boolean isSrcPSDEMapsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrcPSDEMapsCntDirty();
        }
        return this.srcpsdemapscntDirtyFlag;
    }

    public void resetSrcPSDEMapsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrcPSDEMapsCnt();
            return;
        }
        this.srcpsdemapscntDirtyFlag = false;
        this.srcpsdemapscnt = null;
    }

    public void setStorageMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStorageMode(n);
            return;
        }
        this.storagemode = n;
        this.storagemodeDirtyFlag = true;
    }

    public Integer getStorageMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStorageMode();
        }
        return this.storagemode;
    }

    public boolean isStorageModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStorageModeDirty();
        }
        return this.storagemodeDirtyFlag;
    }

    public void resetStorageMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStorageMode();
            return;
        }
        this.storagemodeDirtyFlag = false;
        this.storagemode = null;
    }

    public void setSubSysDE(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSubSysDE(n);
            return;
        }
        this.subsysde = n;
        this.subsysdeDirtyFlag = true;
    }

    public Integer getSubSysDE() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSubSysDE();
        }
        return this.subsysde;
    }

    public boolean isSubSysDEDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSubSysDEDirty();
        }
        return this.subsysdeDirtyFlag;
    }

    public void resetSubSysDE() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSubSysDE();
            return;
        }
        this.subsysdeDirtyFlag = false;
        this.subsysde = null;
    }

    public void setSubSysModule(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSubSysModule(n);
            return;
        }
        this.subsysmodule = n;
        this.subsysmoduleDirtyFlag = true;
    }

    public Integer getSubSysModule() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSubSysModule();
        }
        return this.subsysmodule;
    }

    public boolean isSubSysModuleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSubSysModuleDirty();
        }
        return this.subsysmoduleDirtyFlag;
    }

    public void resetSubSysModule() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSubSysModule();
            return;
        }
        this.subsysmoduleDirtyFlag = false;
        this.subsysmodule = null;
    }

    public void setSvrPubMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSvrPubMode(n);
            return;
        }
        this.svrpubmode = n;
        this.svrpubmodeDirtyFlag = true;
    }

    public Integer getSvrPubMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSvrPubMode();
        }
        return this.svrpubmode;
    }

    public boolean isSvrPubModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSvrPubModeDirty();
        }
        return this.svrpubmodeDirtyFlag;
    }

    public void resetSvrPubMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSvrPubMode();
            return;
        }
        this.svrpubmodeDirtyFlag = false;
        this.svrpubmode = null;
    }

    public void setSystemFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSystemFlag(n);
            return;
        }
        this.systemflag = n;
        this.systemflagDirtyFlag = true;
    }

    public Integer getSystemFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSystemFlag();
        }
        return this.systemflag;
    }

    public boolean isSystemFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSystemFlagDirty();
        }
        return this.systemflagDirtyFlag;
    }

    public void resetSystemFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSystemFlag();
            return;
        }
        this.systemflagDirtyFlag = false;
        this.systemflag = null;
    }

    public void setTableName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTableName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tablename = string;
        this.tablenameDirtyFlag = true;
    }

    public String getTableName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTableName();
        }
        return this.tablename;
    }

    public boolean isTableNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTableNameDirty();
        }
        return this.tablenameDirtyFlag;
    }

    public void resetTableName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTableName();
            return;
        }
        this.tablenameDirtyFlag = false;
        this.tablename = null;
    }

    public void setTestCaseFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTestCaseFlag(n);
            return;
        }
        this.testcaseflag = n;
        this.testcaseflagDirtyFlag = true;
    }

    public Integer getTestCaseFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTestCaseFlag();
        }
        return this.testcaseflag;
    }

    public boolean isTestCaseFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTestCaseFlagDirty();
        }
        return this.testcaseflagDirtyFlag;
    }

    public void resetTestCaseFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTestCaseFlag();
            return;
        }
        this.testcaseflagDirtyFlag = false;
        this.testcaseflag = null;
    }

    public void setToDoTask(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setToDoTask(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.todotask = string;
        this.todotaskDirtyFlag = true;
    }

    public String getToDoTask() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getToDoTask();
        }
        return this.todotask;
    }

    public boolean isToDoTaskDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isToDoTaskDirty();
        }
        return this.todotaskDirtyFlag;
    }

    public void resetToDoTask() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetToDoTask();
            return;
        }
        this.todotaskDirtyFlag = false;
        this.todotask = null;
    }

    public void setUpdateDate(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateDate(timestamp);
            return;
        }
        this.updatedate = timestamp;
        this.updatedateDirtyFlag = true;
    }

    public Timestamp getUpdateDate() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdateDate();
        }
        return this.updatedate;
    }

    public boolean isUpdateDateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdateDateDirty();
        }
        return this.updatedateDirtyFlag;
    }

    public void resetUpdateDate() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdateDate();
            return;
        }
        this.updatedateDirtyFlag = false;
        this.updatedate = null;
    }

    public void setUpdateMan(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateMan(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.updateman = string;
        this.updatemanDirtyFlag = true;
    }

    public String getUpdateMan() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdateMan();
        }
        return this.updateman;
    }

    public boolean isUpdateManDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdateManDirty();
        }
        return this.updatemanDirtyFlag;
    }

    public void resetUpdateMan() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdateMan();
            return;
        }
        this.updatemanDirtyFlag = false;
        this.updateman = null;
    }

    public void setUserAction(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserAction(n);
            return;
        }
        this.useraction = n;
        this.useractionDirtyFlag = true;
    }

    public Integer getUserAction() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserAction();
        }
        return this.useraction;
    }

    public boolean isUserActionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserActionDirty();
        }
        return this.useractionDirtyFlag;
    }

    public void resetUserAction() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserAction();
            return;
        }
        this.useractionDirtyFlag = false;
        this.useraction = null;
    }

    public void setUserCat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserCat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usercat = string;
        this.usercatDirtyFlag = true;
    }

    public String getUserCat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserCat();
        }
        return this.usercat;
    }

    public boolean isUserCatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserCatDirty();
        }
        return this.usercatDirtyFlag;
    }

    public void resetUserCat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserCat();
            return;
        }
        this.usercatDirtyFlag = false;
        this.usercat = null;
    }

    public void setUserParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userparams = string;
        this.userparamsDirtyFlag = true;
    }

    public String getUserParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserParams();
        }
        return this.userparams;
    }

    public boolean isUserParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserParamsDirty();
        }
        return this.userparamsDirtyFlag;
    }

    public void resetUserParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserParams();
            return;
        }
        this.userparamsDirtyFlag = false;
        this.userparams = null;
    }

    public void setUserTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag = string;
        this.usertagDirtyFlag = true;
    }

    public String getUserTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag();
        }
        return this.usertag;
    }

    public boolean isUserTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTagDirty();
        }
        return this.usertagDirtyFlag;
    }

    public void resetUserTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag();
            return;
        }
        this.usertagDirtyFlag = false;
        this.usertag = null;
    }

    public void setUserTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag2 = string;
        this.usertag2DirtyFlag = true;
    }

    public String getUserTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag2();
        }
        return this.usertag2;
    }

    public boolean isUserTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag2Dirty();
        }
        return this.usertag2DirtyFlag;
    }

    public void resetUserTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag2();
            return;
        }
        this.usertag2DirtyFlag = false;
        this.usertag2 = null;
    }

    public void setUserTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag3 = string;
        this.usertag3DirtyFlag = true;
    }

    public String getUserTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag3();
        }
        return this.usertag3;
    }

    public boolean isUserTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag3Dirty();
        }
        return this.usertag3DirtyFlag;
    }

    public void resetUserTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag3();
            return;
        }
        this.usertag3DirtyFlag = false;
        this.usertag3 = null;
    }

    public void setUserTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag4 = string;
        this.usertag4DirtyFlag = true;
    }

    public String getUserTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag4();
        }
        return this.usertag4;
    }

    public boolean isUserTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag4Dirty();
        }
        return this.usertag4DirtyFlag;
    }

    public void resetUserTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag4();
            return;
        }
        this.usertag4DirtyFlag = false;
        this.usertag4 = null;
    }

    public void setValidFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValidFlag(n);
            return;
        }
        this.validflag = n;
        this.validflagDirtyFlag = true;
    }

    public Integer getValidFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValidFlag();
        }
        return this.validflag;
    }

    public boolean isValidFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValidFlagDirty();
        }
        return this.validflagDirtyFlag;
    }

    public void resetValidFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValidFlag();
            return;
        }
        this.validflagDirtyFlag = false;
        this.validflag = null;
    }

    public void setViewLevel(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewLevel(n);
            return;
        }
        this.viewlevel = n;
        this.viewlevelDirtyFlag = true;
    }

    public Integer getViewLevel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewLevel();
        }
        return this.viewlevel;
    }

    public boolean isViewLevelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewLevelDirty();
        }
        return this.viewlevelDirtyFlag;
    }

    public void resetViewLevel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewLevel();
            return;
        }
        this.viewlevelDirtyFlag = false;
        this.viewlevel = null;
    }

    public void setViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.viewname = string;
        this.viewnameDirtyFlag = true;
    }

    public String getViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewName();
        }
        return this.viewname;
    }

    public boolean isViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewNameDirty();
        }
        return this.viewnameDirtyFlag;
    }

    public void resetViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewName();
            return;
        }
        this.viewnameDirtyFlag = false;
        this.viewname = null;
    }

    public void setViewName2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewName2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.viewname2 = string;
        this.viewname2DirtyFlag = true;
    }

    public String getViewName2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewName2();
        }
        return this.viewname2;
    }

    public boolean isViewName2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewName2Dirty();
        }
        return this.viewname2DirtyFlag;
    }

    public void resetViewName2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewName2();
            return;
        }
        this.viewname2DirtyFlag = false;
        this.viewname2 = null;
    }

    public void setViewName3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewName3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.viewname3 = string;
        this.viewname3DirtyFlag = true;
    }

    public String getViewName3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewName3();
        }
        return this.viewname3;
    }

    public boolean isViewName3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewName3Dirty();
        }
        return this.viewname3DirtyFlag;
    }

    public void resetViewName3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewName3();
            return;
        }
        this.viewname3DirtyFlag = false;
        this.viewname3 = null;
    }

    public void setViewName4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewName4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.viewname4 = string;
        this.viewname4DirtyFlag = true;
    }

    public String getViewName4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewName4();
        }
        return this.viewname4;
    }

    public boolean isViewName4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewName4Dirty();
        }
        return this.viewname4DirtyFlag;
    }

    public void resetViewName4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewName4();
            return;
        }
        this.viewname4DirtyFlag = false;
        this.viewname4 = null;
    }

    public void setVirtualFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVirtualFlag(n);
            return;
        }
        this.virtualflag = n;
        this.virtualflagDirtyFlag = true;
    }

    public Integer getVirtualFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVirtualFlag();
        }
        return this.virtualflag;
    }

    public boolean isVirtualFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVirtualFlagDirty();
        }
        return this.virtualflagDirtyFlag;
    }

    public void resetVirtualFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVirtualFlag();
            return;
        }
        this.virtualflagDirtyFlag = false;
        this.virtualflag = null;
    }

    public void setVKeySeparator(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVKeySeparator(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.vkeyseparator = string;
        this.vkeyseparatorDirtyFlag = true;
    }

    public String getVKeySeparator() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVKeySeparator();
        }
        return this.vkeyseparator;
    }

    public boolean isVKeySeparatorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVKeySeparatorDirty();
        }
        return this.vkeyseparatorDirtyFlag;
    }

    public void resetVKeySeparator() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVKeySeparator();
            return;
        }
        this.vkeyseparatorDirtyFlag = false;
        this.vkeyseparator = null;
    }

    protected void onReset() {
        PSDataEntityBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDataEntityBase pSDataEntityBase) {
        pSDataEntityBase.resetAccCtrlArch();
        pSDataEntityBase.resetAuditMode();
        pSDataEntityBase.resetBaseClsParams();
        pSDataEntityBase.resetBizTag();
        pSDataEntityBase.resetCodeName();
        pSDataEntityBase.resetCodeNameMode();
        pSDataEntityBase.resetColor();
        pSDataEntityBase.resetCreateDate();
        pSDataEntityBase.resetCreateMan();
        pSDataEntityBase.resetCustomCode();
        pSDataEntityBase.resetCustomMode();
        pSDataEntityBase.resetDataAccMode();
        pSDataEntityBase.resetDataChgLogMode();
        pSDataEntityBase.resetDataImpExpFlag();
        pSDataEntityBase.resetDBTabSpace();
        pSDataEntityBase.resetDBVer();
        pSDataEntityBase.resetDECat();
        pSDataEntityBase.resetDEHolder();
        pSDataEntityBase.resetDELockFlag();
        pSDataEntityBase.resetDESN();
        pSDataEntityBase.resetDETag();
        pSDataEntityBase.resetDETag2();
        pSDataEntityBase.resetDEType();
        pSDataEntityBase.resetDSLink();
        pSDataEntityBase.resetDstPSDEActionLogicsCnt();
        pSDataEntityBase.resetDynamicMode();
        pSDataEntityBase.resetDynaModelFlag();
        pSDataEntityBase.resetDynaTableMode();
        pSDataEntityBase.resetEnableAudit();
        pSDataEntityBase.resetEnableDALog();
        pSDataEntityBase.resetEnableDataVer();
        pSDataEntityBase.resetEnableDEAction();
        pSDataEntityBase.resetEnableDEDataSet();
        pSDataEntityBase.resetEnableDynaSys();
        pSDataEntityBase.resetEnableEntityCache();
        pSDataEntityBase.resetEnableMob();
        pSDataEntityBase.resetEnableMultiDS();
        pSDataEntityBase.resetEnableOPNameModel();
        pSDataEntityBase.resetEnableOrgModel();
        pSDataEntityBase.resetEnablePQL();
        pSDataEntityBase.resetEnableSelect();
        pSDataEntityBase.resetEnableWFModel();
        pSDataEntityBase.resetEnaMultiForm();
        pSDataEntityBase.resetEnaTempData();
        pSDataEntityBase.resetEntityCacheTimeout();
        pSDataEntityBase.resetExistingModel();
        pSDataEntityBase.resetExTableName();
        pSDataEntityBase.resetIndexDEType();
        pSDataEntityBase.resetKeyRule();
        pSDataEntityBase.resetLNPSLanResId();
        pSDataEntityBase.resetLNPSLanResName();
        pSDataEntityBase.resetLockFlag();
        pSDataEntityBase.resetLogicInvalidValue();
        pSDataEntityBase.resetLogicName();
        pSDataEntityBase.resetLogicValid();
        pSDataEntityBase.resetLogicValidValue();
        pSDataEntityBase.resetMajorPSDERsCnt();
        pSDataEntityBase.resetMaxEntityCacheCnt();
        pSDataEntityBase.resetMemo();
        pSDataEntityBase.resetMinorPSDERsCnt();
        pSDataEntityBase.resetModColor();
        pSDataEntityBase.resetModelImpExpFlag();
        pSDataEntityBase.resetModelState();
        pSDataEntityBase.resetModelVer();
        pSDataEntityBase.resetMSActionLogicFlag();
        pSDataEntityBase.resetNoViewMode();
        pSDataEntityBase.resetOrderValue();
        pSDataEntityBase.resetPSACHandlersCnt();
        pSDataEntityBase.resetPSCodeListsCnt();
        pSDataEntityBase.resetPSDataEntityId();
        pSDataEntityBase.resetPSDataEntityName();
        pSDataEntityBase.resetPSDEACModesCnt();
        pSDataEntityBase.resetPSDEActionLogicsCnt();
        pSDataEntityBase.resetPSDEActionsCnt();
        pSDataEntityBase.resetPSDEAWGrpsCnt();
        pSDataEntityBase.resetPSDEAWsCnt();
        pSDataEntityBase.resetPSDEChartsCnt();
        pSDataEntityBase.resetPSDEDataExpsCnt();
        pSDataEntityBase.resetPSDEDataImpsCnt();
        pSDataEntityBase.resetPSDEDataQuerysCnt();
        pSDataEntityBase.resetPSDEDataRelationsCnt();
        pSDataEntityBase.resetPSDEDataSetsCnt();
        pSDataEntityBase.resetPSDEDataSyncsCnt();
        pSDataEntityBase.resetPSDEDataViewsCnt();
        pSDataEntityBase.resetPSDEDBCfgsCnt();
        pSDataEntityBase.resetPSDEDBIndexsCnt();
        pSDataEntityBase.resetPSDEDRGroupsCnt();
        pSDataEntityBase.resetPSDEDRItemsCnt();
        pSDataEntityBase.resetPSDEDTSQueuesCnt();
        pSDataEntityBase.resetPSDEFieldsCnt();
        pSDataEntityBase.resetPSDEFInputTipSetId();
        pSDataEntityBase.resetPSDEFInputTipSetName();
        pSDataEntityBase.resetPSDEFormsCnt();
        pSDataEntityBase.resetPSDEFSFItemsCnt();
        pSDataEntityBase.resetPSDEFValueRulesCnt();
        pSDataEntityBase.resetPSDEGridsCnt();
        pSDataEntityBase.resetPSDEListsCnt();
        pSDataEntityBase.resetPSDELogicsCnt();
        pSDataEntityBase.resetPSDEMainStatesCnt();
        pSDataEntityBase.resetPSDEOPPrivRolesCnt();
        pSDataEntityBase.resetPSDEOPPrivsCnt();
        pSDataEntityBase.resetPSDEPrintsCnt();
        pSDataEntityBase.resetPSDEReportsCnt();
        pSDataEntityBase.resetPSDEServiceAPIsCnt();
        pSDataEntityBase.resetPSDEToolbarsCnt();
        pSDataEntityBase.resetPSDETreeViewsCnt();
        pSDataEntityBase.resetPSDEUAGroupsCnt();
        pSDataEntityBase.resetPSDEUIActionsCnt();
        pSDataEntityBase.resetPSDEUserRolesCnt();
        pSDataEntityBase.resetPSDEViewBasesCnt();
        pSDataEntityBase.resetPSDEWizardsCnt();
        pSDataEntityBase.resetPSDynaDETemplId();
        pSDataEntityBase.resetPSDynaDETemplName();
        pSDataEntityBase.resetPSDynaInstId();
        pSDataEntityBase.resetPSHelpModuleId();
        pSDataEntityBase.resetPSHelpModuleName();
        pSDataEntityBase.resetPSModuleId();
        pSDataEntityBase.resetPSModuleName();
        pSDataEntityBase.resetPSSubSysSADEId();
        pSDataEntityBase.resetPSSubSysSADEName();
        pSDataEntityBase.resetPSSubSysServiceAPIId();
        pSDataEntityBase.resetPSSubSysServiceAPIName();
        pSDataEntityBase.resetPSSysBDTablesCnt();
        pSDataEntityBase.resetPSSysCountersCnt();
        pSDataEntityBase.resetPSSysDMItemsCnt();
        pSDataEntityBase.resetPSSysDynaModelId();
        pSDataEntityBase.resetPSSysDynaModelName();
        pSDataEntityBase.resetPSSysImageId();
        pSDataEntityBase.resetPSSysImageName();
        pSDataEntityBase.resetPSSysModelChgLogsCnt();
        pSDataEntityBase.resetPSSysModelGroupId();
        pSDataEntityBase.resetPSSysModelGroupName();
        pSDataEntityBase.resetPSSysReqItemId();
        pSDataEntityBase.resetPSSysReqItemName();
        pSDataEntityBase.resetPSSysSFPluginId();
        pSDataEntityBase.resetPSSysSFPluginName();
        pSDataEntityBase.resetPSSysTasksCnt();
        pSDataEntityBase.resetPSSystemId();
        pSDataEntityBase.resetPSSystemName();
        pSDataEntityBase.resetPSSysTestCasesCnt();
        pSDataEntityBase.resetPSSysTestDatasCnt();
        pSDataEntityBase.resetPSSysUniResId();
        pSDataEntityBase.resetPSSysUniResName();
        pSDataEntityBase.resetPSWFDEsCnt();
        pSDataEntityBase.resetReadOnlyMode();
        pSDataEntityBase.resetRemoveFlag();
        pSDataEntityBase.resetSaaSMode();
        pSDataEntityBase.resetServiceAPIFlag();
        pSDataEntityBase.resetServiceCodeName();
        pSDataEntityBase.resetSrcPSDEMapsCnt();
        pSDataEntityBase.resetStorageMode();
        pSDataEntityBase.resetSubSysDE();
        pSDataEntityBase.resetSubSysModule();
        pSDataEntityBase.resetSvrPubMode();
        pSDataEntityBase.resetSystemFlag();
        pSDataEntityBase.resetTableName();
        pSDataEntityBase.resetTestCaseFlag();
        pSDataEntityBase.resetToDoTask();
        pSDataEntityBase.resetUpdateDate();
        pSDataEntityBase.resetUpdateMan();
        pSDataEntityBase.resetUserAction();
        pSDataEntityBase.resetUserCat();
        pSDataEntityBase.resetUserParams();
        pSDataEntityBase.resetUserTag();
        pSDataEntityBase.resetUserTag2();
        pSDataEntityBase.resetUserTag3();
        pSDataEntityBase.resetUserTag4();
        pSDataEntityBase.resetValidFlag();
        pSDataEntityBase.resetViewLevel();
        pSDataEntityBase.resetViewName();
        pSDataEntityBase.resetViewName2();
        pSDataEntityBase.resetViewName3();
        pSDataEntityBase.resetViewName4();
        pSDataEntityBase.resetVirtualFlag();
        pSDataEntityBase.resetVKeySeparator();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAccCtrlArchDirty()) {
            hashMap.put(FIELD_ACCCTRLARCH, this.getAccCtrlArch());
        }
        if (!bl || this.isAuditModeDirty()) {
            hashMap.put(FIELD_AUDITMODE, this.getAuditMode());
        }
        if (!bl || this.isBaseClsParamsDirty()) {
            hashMap.put(FIELD_BASECLSPARAMS, this.getBaseClsParams());
        }
        if (!bl || this.isBizTagDirty()) {
            hashMap.put(FIELD_BIZTAG, this.getBizTag());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCodeNameModeDirty()) {
            hashMap.put(FIELD_CODENAMEMODE, this.getCodeNameMode());
        }
        if (!bl || this.isColorDirty()) {
            hashMap.put(FIELD_COLOR, this.getColor());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCustomCodeDirty()) {
            hashMap.put(FIELD_CUSTOMCODE, this.getCustomCode());
        }
        if (!bl || this.isCustomModeDirty()) {
            hashMap.put(FIELD_CUSTOMMODE, this.getCustomMode());
        }
        if (!bl || this.isDataAccModeDirty()) {
            hashMap.put(FIELD_DATAACCMODE, this.getDataAccMode());
        }
        if (!bl || this.isDataChgLogModeDirty()) {
            hashMap.put(FIELD_DATACHGLOGMODE, this.getDataChgLogMode());
        }
        if (!bl || this.isDataImpExpFlagDirty()) {
            hashMap.put(FIELD_DATAIMPEXPFLAG, this.getDataImpExpFlag());
        }
        if (!bl || this.isDBTabSpaceDirty()) {
            hashMap.put(FIELD_DBTABSPACE, this.getDBTabSpace());
        }
        if (!bl || this.isDBVerDirty()) {
            hashMap.put(FIELD_DBVER, this.getDBVer());
        }
        if (!bl || this.isDECatDirty()) {
            hashMap.put(FIELD_DECAT, this.getDECat());
        }
        if (!bl || this.isDEHolderDirty()) {
            hashMap.put(FIELD_DEHOLDER, this.getDEHolder());
        }
        if (!bl || this.isDELockFlagDirty()) {
            hashMap.put(FIELD_DELOCKFLAG, this.getDELockFlag());
        }
        if (!bl || this.isDESNDirty()) {
            hashMap.put(FIELD_DESN, this.getDESN());
        }
        if (!bl || this.isDETagDirty()) {
            hashMap.put(FIELD_DETAG, this.getDETag());
        }
        if (!bl || this.isDETag2Dirty()) {
            hashMap.put(FIELD_DETAG2, this.getDETag2());
        }
        if (!bl || this.isDETypeDirty()) {
            hashMap.put(FIELD_DETYPE, this.getDEType());
        }
        if (!bl || this.isDSLinkDirty()) {
            hashMap.put(FIELD_DSLINK, this.getDSLink());
        }
        if (!bl || this.isDstPSDEActionLogicsCntDirty()) {
            hashMap.put(FIELD_DSTPSDEACTIONLOGICSCNT, this.getDstPSDEActionLogicsCnt());
        }
        if (!bl || this.isDynamicModeDirty()) {
            hashMap.put(FIELD_DYNAMICMODE, this.getDynamicMode());
        }
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isDynaTableModeDirty()) {
            hashMap.put(FIELD_DYNATABLEMODE, this.getDynaTableMode());
        }
        if (!bl || this.isEnableAuditDirty()) {
            hashMap.put(FIELD_ENABLEAUDIT, this.getEnableAudit());
        }
        if (!bl || this.isEnableDALogDirty()) {
            hashMap.put(FIELD_ENABLEDALOG, this.getEnableDALog());
        }
        if (!bl || this.isEnableDataVerDirty()) {
            hashMap.put(FIELD_ENABLEDATAVER, this.getEnableDataVer());
        }
        if (!bl || this.isEnableDEActionDirty()) {
            hashMap.put(FIELD_ENABLEDEACTION, this.getEnableDEAction());
        }
        if (!bl || this.isEnableDEDataSetDirty()) {
            hashMap.put(FIELD_ENABLEDEDATASET, this.getEnableDEDataSet());
        }
        if (!bl || this.isEnableDynaSysDirty()) {
            hashMap.put(FIELD_ENABLEDYNASYS, this.getEnableDynaSys());
        }
        if (!bl || this.isEnableEntityCacheDirty()) {
            hashMap.put(FIELD_ENABLEENTITYCACHE, this.getEnableEntityCache());
        }
        if (!bl || this.isEnableMobDirty()) {
            hashMap.put(FIELD_ENABLEMOB, this.getEnableMob());
        }
        if (!bl || this.isEnableMultiDSDirty()) {
            hashMap.put(FIELD_ENABLEMULTIDS, this.getEnableMultiDS());
        }
        if (!bl || this.isEnableOPNameModelDirty()) {
            hashMap.put(FIELD_ENABLEOPNAMEMODEL, this.getEnableOPNameModel());
        }
        if (!bl || this.isEnableOrgModelDirty()) {
            hashMap.put(FIELD_ENABLEORGMODEL, this.getEnableOrgModel());
        }
        if (!bl || this.isEnablePQLDirty()) {
            hashMap.put(FIELD_ENABLEPQL, this.getEnablePQL());
        }
        if (!bl || this.isEnableSelectDirty()) {
            hashMap.put(FIELD_ENABLESELECT, this.getEnableSelect());
        }
        if (!bl || this.isEnableWFModelDirty()) {
            hashMap.put(FIELD_ENABLEWFMODEL, this.getEnableWFModel());
        }
        if (!bl || this.isEnaMultiFormDirty()) {
            hashMap.put(FIELD_ENAMULTIFORM, this.getEnaMultiForm());
        }
        if (!bl || this.isEnaTempDataDirty()) {
            hashMap.put(FIELD_ENATEMPDATA, this.getEnaTempData());
        }
        if (!bl || this.isEntityCacheTimeoutDirty()) {
            hashMap.put(FIELD_ENTITYCACHETIMEOUT, this.getEntityCacheTimeout());
        }
        if (!bl || this.isExistingModelDirty()) {
            hashMap.put(FIELD_EXISTINGMODEL, this.getExistingModel());
        }
        if (!bl || this.isExTableNameDirty()) {
            hashMap.put(FIELD_EXTABLENAME, this.getExTableName());
        }
        if (!bl || this.isIndexDETypeDirty()) {
            hashMap.put(FIELD_INDEXDETYPE, this.getIndexDEType());
        }
        if (!bl || this.isKeyRuleDirty()) {
            hashMap.put(FIELD_KEYRULE, this.getKeyRule());
        }
        if (!bl || this.isLNPSLanResIdDirty()) {
            hashMap.put(FIELD_LNPSLANRESID, this.getLNPSLanResId());
        }
        if (!bl || this.isLNPSLanResNameDirty()) {
            hashMap.put(FIELD_LNPSLANRESNAME, this.getLNPSLanResName());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isLogicInvalidValueDirty()) {
            hashMap.put(FIELD_LOGICINVALIDVALUE, this.getLogicInvalidValue());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isLogicValidDirty()) {
            hashMap.put(FIELD_LOGICVALID, this.getLogicValid());
        }
        if (!bl || this.isLogicValidValueDirty()) {
            hashMap.put(FIELD_LOGICVALIDVALUE, this.getLogicValidValue());
        }
        if (!bl || this.isMajorPSDERsCntDirty()) {
            hashMap.put(FIELD_MAJORPSDERSCNT, this.getMajorPSDERsCnt());
        }
        if (!bl || this.isMaxEntityCacheCntDirty()) {
            hashMap.put(FIELD_MAXENTITYCACHECNT, this.getMaxEntityCacheCnt());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMinorPSDERsCntDirty()) {
            hashMap.put(FIELD_MINORPSDERSCNT, this.getMinorPSDERsCnt());
        }
        if (!bl || this.isModColorDirty()) {
            hashMap.put(FIELD_MODCOLOR, this.getModColor());
        }
        if (!bl || this.isModelImpExpFlagDirty()) {
            hashMap.put(FIELD_MODELIMPEXPFLAG, this.getModelImpExpFlag());
        }
        if (!bl || this.isModelStateDirty()) {
            hashMap.put(FIELD_MODELSTATE, this.getModelState());
        }
        if (!bl || this.isModelVerDirty()) {
            hashMap.put(FIELD_MODELVER, this.getModelVer());
        }
        if (!bl || this.isMSActionLogicFlagDirty()) {
            hashMap.put(FIELD_MSACTIONLOGICFLAG, this.getMSActionLogicFlag());
        }
        if (!bl || this.isNoViewModeDirty()) {
            hashMap.put(FIELD_NOVIEWMODE, this.getNoViewMode());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSACHandlersCntDirty()) {
            hashMap.put(FIELD_PSACHANDLERSCNT, this.getPSACHandlersCnt());
        }
        if (!bl || this.isPSCodeListsCntDirty()) {
            hashMap.put(FIELD_PSCODELISTSCNT, this.getPSCodeListsCnt());
        }
        if (!bl || this.isPSDataEntityIdDirty()) {
            hashMap.put(FIELD_PSDATAENTITYID, this.getPSDataEntityId());
        }
        if (!bl || this.isPSDataEntityNameDirty()) {
            hashMap.put(FIELD_PSDATAENTITYNAME, this.getPSDataEntityName());
        }
        if (!bl || this.isPSDEACModesCntDirty()) {
            hashMap.put(FIELD_PSDEACMODESCNT, this.getPSDEACModesCnt());
        }
        if (!bl || this.isPSDEActionLogicsCntDirty()) {
            hashMap.put(FIELD_PSDEACTIONLOGICSCNT, this.getPSDEActionLogicsCnt());
        }
        if (!bl || this.isPSDEActionsCntDirty()) {
            hashMap.put(FIELD_PSDEACTIONSCNT, this.getPSDEActionsCnt());
        }
        if (!bl || this.isPSDEAWGrpsCntDirty()) {
            hashMap.put(FIELD_PSDEAWGRPSCNT, this.getPSDEAWGrpsCnt());
        }
        if (!bl || this.isPSDEAWsCntDirty()) {
            hashMap.put(FIELD_PSDEAWSCNT, this.getPSDEAWsCnt());
        }
        if (!bl || this.isPSDEChartsCntDirty()) {
            hashMap.put(FIELD_PSDECHARTSCNT, this.getPSDEChartsCnt());
        }
        if (!bl || this.isPSDEDataExpsCntDirty()) {
            hashMap.put(FIELD_PSDEDATAEXPSCNT, this.getPSDEDataExpsCnt());
        }
        if (!bl || this.isPSDEDataImpsCntDirty()) {
            hashMap.put(FIELD_PSDEDATAIMPSCNT, this.getPSDEDataImpsCnt());
        }
        if (!bl || this.isPSDEDataQuerysCntDirty()) {
            hashMap.put(FIELD_PSDEDATAQUERYSCNT, this.getPSDEDataQuerysCnt());
        }
        if (!bl || this.isPSDEDataRelationsCntDirty()) {
            hashMap.put(FIELD_PSDEDATARELATIONSCNT, this.getPSDEDataRelationsCnt());
        }
        if (!bl || this.isPSDEDataSetsCntDirty()) {
            hashMap.put(FIELD_PSDEDATASETSCNT, this.getPSDEDataSetsCnt());
        }
        if (!bl || this.isPSDEDataSyncsCntDirty()) {
            hashMap.put(FIELD_PSDEDATASYNCSCNT, this.getPSDEDataSyncsCnt());
        }
        if (!bl || this.isPSDEDataViewsCntDirty()) {
            hashMap.put(FIELD_PSDEDATAVIEWSCNT, this.getPSDEDataViewsCnt());
        }
        if (!bl || this.isPSDEDBCfgsCntDirty()) {
            hashMap.put(FIELD_PSDEDBCFGSCNT, this.getPSDEDBCfgsCnt());
        }
        if (!bl || this.isPSDEDBIndexsCntDirty()) {
            hashMap.put(FIELD_PSDEDBINDEXSCNT, this.getPSDEDBIndexsCnt());
        }
        if (!bl || this.isPSDEDRGroupsCntDirty()) {
            hashMap.put(FIELD_PSDEDRGROUPSCNT, this.getPSDEDRGroupsCnt());
        }
        if (!bl || this.isPSDEDRItemsCntDirty()) {
            hashMap.put(FIELD_PSDEDRITEMSCNT, this.getPSDEDRItemsCnt());
        }
        if (!bl || this.isPSDEDTSQueuesCntDirty()) {
            hashMap.put(FIELD_PSDEDTSQUEUESCNT, this.getPSDEDTSQueuesCnt());
        }
        if (!bl || this.isPSDEFieldsCntDirty()) {
            hashMap.put(FIELD_PSDEFIELDSCNT, this.getPSDEFieldsCnt());
        }
        if (!bl || this.isPSDEFInputTipSetIdDirty()) {
            hashMap.put(FIELD_PSDEFINPUTTIPSETID, this.getPSDEFInputTipSetId());
        }
        if (!bl || this.isPSDEFInputTipSetNameDirty()) {
            hashMap.put(FIELD_PSDEFINPUTTIPSETNAME, this.getPSDEFInputTipSetName());
        }
        if (!bl || this.isPSDEFormsCntDirty()) {
            hashMap.put(FIELD_PSDEFORMSCNT, this.getPSDEFormsCnt());
        }
        if (!bl || this.isPSDEFSFItemsCntDirty()) {
            hashMap.put(FIELD_PSDEFSFITEMSCNT, this.getPSDEFSFItemsCnt());
        }
        if (!bl || this.isPSDEFValueRulesCntDirty()) {
            hashMap.put(FIELD_PSDEFVALUERULESCNT, this.getPSDEFValueRulesCnt());
        }
        if (!bl || this.isPSDEGridsCntDirty()) {
            hashMap.put(FIELD_PSDEGRIDSCNT, this.getPSDEGridsCnt());
        }
        if (!bl || this.isPSDEListsCntDirty()) {
            hashMap.put(FIELD_PSDELISTSCNT, this.getPSDEListsCnt());
        }
        if (!bl || this.isPSDELogicsCntDirty()) {
            hashMap.put(FIELD_PSDELOGICSCNT, this.getPSDELogicsCnt());
        }
        if (!bl || this.isPSDEMainStatesCntDirty()) {
            hashMap.put(FIELD_PSDEMAINSTATESCNT, this.getPSDEMainStatesCnt());
        }
        if (!bl || this.isPSDEOPPrivRolesCntDirty()) {
            hashMap.put(FIELD_PSDEOPPRIVROLESCNT, this.getPSDEOPPrivRolesCnt());
        }
        if (!bl || this.isPSDEOPPrivsCntDirty()) {
            hashMap.put(FIELD_PSDEOPPRIVSCNT, this.getPSDEOPPrivsCnt());
        }
        if (!bl || this.isPSDEPrintsCntDirty()) {
            hashMap.put(FIELD_PSDEPRINTSCNT, this.getPSDEPrintsCnt());
        }
        if (!bl || this.isPSDEReportsCntDirty()) {
            hashMap.put(FIELD_PSDEREPORTSCNT, this.getPSDEReportsCnt());
        }
        if (!bl || this.isPSDEServiceAPIsCntDirty()) {
            hashMap.put(FIELD_PSDESERVICEAPISCNT, this.getPSDEServiceAPIsCnt());
        }
        if (!bl || this.isPSDEToolbarsCntDirty()) {
            hashMap.put(FIELD_PSDETOOLBARSCNT, this.getPSDEToolbarsCnt());
        }
        if (!bl || this.isPSDETreeViewsCntDirty()) {
            hashMap.put(FIELD_PSDETREEVIEWSCNT, this.getPSDETreeViewsCnt());
        }
        if (!bl || this.isPSDEUAGroupsCntDirty()) {
            hashMap.put(FIELD_PSDEUAGROUPSCNT, this.getPSDEUAGroupsCnt());
        }
        if (!bl || this.isPSDEUIActionsCntDirty()) {
            hashMap.put(FIELD_PSDEUIACTIONSCNT, this.getPSDEUIActionsCnt());
        }
        if (!bl || this.isPSDEUserRolesCntDirty()) {
            hashMap.put(FIELD_PSDEUSERROLESCNT, this.getPSDEUserRolesCnt());
        }
        if (!bl || this.isPSDEViewBasesCntDirty()) {
            hashMap.put(FIELD_PSDEVIEWBASESCNT, this.getPSDEViewBasesCnt());
        }
        if (!bl || this.isPSDEWizardsCntDirty()) {
            hashMap.put(FIELD_PSDEWIZARDSCNT, this.getPSDEWizardsCnt());
        }
        if (!bl || this.isPSDynaDETemplIdDirty()) {
            hashMap.put(FIELD_PSDYNADETEMPLID, this.getPSDynaDETemplId());
        }
        if (!bl || this.isPSDynaDETemplNameDirty()) {
            hashMap.put(FIELD_PSDYNADETEMPLNAME, this.getPSDynaDETemplName());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSHelpModuleIdDirty()) {
            hashMap.put(FIELD_PSHELPMODULEID, this.getPSHelpModuleId());
        }
        if (!bl || this.isPSHelpModuleNameDirty()) {
            hashMap.put(FIELD_PSHELPMODULENAME, this.getPSHelpModuleName());
        }
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
        }
        if (!bl || this.isPSSubSysSADEIdDirty()) {
            hashMap.put(FIELD_PSSUBSYSSADEID, this.getPSSubSysSADEId());
        }
        if (!bl || this.isPSSubSysSADENameDirty()) {
            hashMap.put(FIELD_PSSUBSYSSADENAME, this.getPSSubSysSADEName());
        }
        if (!bl || this.isPSSubSysServiceAPIIdDirty()) {
            hashMap.put(FIELD_PSSUBSYSSERVICEAPIID, this.getPSSubSysServiceAPIId());
        }
        if (!bl || this.isPSSubSysServiceAPINameDirty()) {
            hashMap.put(FIELD_PSSUBSYSSERVICEAPINAME, this.getPSSubSysServiceAPIName());
        }
        if (!bl || this.isPSSysBDTablesCntDirty()) {
            hashMap.put(FIELD_PSSYSBDTABLESCNT, this.getPSSysBDTablesCnt());
        }
        if (!bl || this.isPSSysCountersCntDirty()) {
            hashMap.put(FIELD_PSSYSCOUNTERSCNT, this.getPSSysCountersCnt());
        }
        if (!bl || this.isPSSysDMItemsCntDirty()) {
            hashMap.put(FIELD_PSSYSDMITEMSCNT, this.getPSSysDMItemsCnt());
        }
        if (!bl || this.isPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELID, this.getPSSysDynaModelId());
        }
        if (!bl || this.isPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELNAME, this.getPSSysDynaModelName());
        }
        if (!bl || this.isPSSysImageIdDirty()) {
            hashMap.put(FIELD_PSSYSIMAGEID, this.getPSSysImageId());
        }
        if (!bl || this.isPSSysImageNameDirty()) {
            hashMap.put(FIELD_PSSYSIMAGENAME, this.getPSSysImageName());
        }
        if (!bl || this.isPSSysModelChgLogsCntDirty()) {
            hashMap.put(FIELD_PSSYSMODELCHGLOGSCNT, this.getPSSysModelChgLogsCnt());
        }
        if (!bl || this.isPSSysModelGroupIdDirty()) {
            hashMap.put(FIELD_PSSYSMODELGROUPID, this.getPSSysModelGroupId());
        }
        if (!bl || this.isPSSysModelGroupNameDirty()) {
            hashMap.put(FIELD_PSSYSMODELGROUPNAME, this.getPSSysModelGroupName());
        }
        if (!bl || this.isPSSysReqItemIdDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMID, this.getPSSysReqItemId());
        }
        if (!bl || this.isPSSysReqItemNameDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMNAME, this.getPSSysReqItemName());
        }
        if (!bl || this.isPSSysSFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINID, this.getPSSysSFPluginId());
        }
        if (!bl || this.isPSSysSFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINNAME, this.getPSSysSFPluginName());
        }
        if (!bl || this.isPSSysTasksCntDirty()) {
            hashMap.put(FIELD_PSSYSTASKSCNT, this.getPSSysTasksCnt());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isPSSysTestCasesCntDirty()) {
            hashMap.put(FIELD_PSSYSTESTCASESCNT, this.getPSSysTestCasesCnt());
        }
        if (!bl || this.isPSSysTestDatasCntDirty()) {
            hashMap.put(FIELD_PSSYSTESTDATASCNT, this.getPSSysTestDatasCnt());
        }
        if (!bl || this.isPSSysUniResIdDirty()) {
            hashMap.put(FIELD_PSSYSUNIRESID, this.getPSSysUniResId());
        }
        if (!bl || this.isPSSysUniResNameDirty()) {
            hashMap.put(FIELD_PSSYSUNIRESNAME, this.getPSSysUniResName());
        }
        if (!bl || this.isPSWFDEsCntDirty()) {
            hashMap.put(FIELD_PSWFDESCNT, this.getPSWFDEsCnt());
        }
        if (!bl || this.isReadOnlyModeDirty()) {
            hashMap.put(FIELD_READONLYMODE, this.getReadOnlyMode());
        }
        if (!bl || this.isRemoveFlagDirty()) {
            hashMap.put(FIELD_REMOVEFLAG, this.getRemoveFlag());
        }
        if (!bl || this.isSaaSModeDirty()) {
            hashMap.put(FIELD_SAASMODE, this.getSaaSMode());
        }
        if (!bl || this.isServiceAPIFlagDirty()) {
            hashMap.put(FIELD_SERVICEAPIFLAG, this.getServiceAPIFlag());
        }
        if (!bl || this.isServiceCodeNameDirty()) {
            hashMap.put(FIELD_SERVICECODENAME, this.getServiceCodeName());
        }
        if (!bl || this.isSrcPSDEMapsCntDirty()) {
            hashMap.put(FIELD_SRCPSDEMAPSCNT, this.getSrcPSDEMapsCnt());
        }
        if (!bl || this.isStorageModeDirty()) {
            hashMap.put(FIELD_STORAGEMODE, this.getStorageMode());
        }
        if (!bl || this.isSubSysDEDirty()) {
            hashMap.put(FIELD_SUBSYSDE, this.getSubSysDE());
        }
        if (!bl || this.isSubSysModuleDirty()) {
            hashMap.put(FIELD_SUBSYSMODULE, this.getSubSysModule());
        }
        if (!bl || this.isSvrPubModeDirty()) {
            hashMap.put(FIELD_SVRPUBMODE, this.getSvrPubMode());
        }
        if (!bl || this.isSystemFlagDirty()) {
            hashMap.put(FIELD_SYSTEMFLAG, this.getSystemFlag());
        }
        if (!bl || this.isTableNameDirty()) {
            hashMap.put(FIELD_TABLENAME, this.getTableName());
        }
        if (!bl || this.isTestCaseFlagDirty()) {
            hashMap.put(FIELD_TESTCASEFLAG, this.getTestCaseFlag());
        }
        if (!bl || this.isToDoTaskDirty()) {
            hashMap.put(FIELD_TODOTASK, this.getToDoTask());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserActionDirty()) {
            hashMap.put(FIELD_USERACTION, this.getUserAction());
        }
        if (!bl || this.isUserCatDirty()) {
            hashMap.put(FIELD_USERCAT, this.getUserCat());
        }
        if (!bl || this.isUserParamsDirty()) {
            hashMap.put(FIELD_USERPARAMS, this.getUserParams());
        }
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bl || this.isUserTag2Dirty()) {
            hashMap.put(FIELD_USERTAG2, this.getUserTag2());
        }
        if (!bl || this.isUserTag3Dirty()) {
            hashMap.put(FIELD_USERTAG3, this.getUserTag3());
        }
        if (!bl || this.isUserTag4Dirty()) {
            hashMap.put(FIELD_USERTAG4, this.getUserTag4());
        }
        if (!bl || this.isValidFlagDirty()) {
            hashMap.put(FIELD_VALIDFLAG, this.getValidFlag());
        }
        if (!bl || this.isViewLevelDirty()) {
            hashMap.put(FIELD_VIEWLEVEL, this.getViewLevel());
        }
        if (!bl || this.isViewNameDirty()) {
            hashMap.put(FIELD_VIEWNAME, this.getViewName());
        }
        if (!bl || this.isViewName2Dirty()) {
            hashMap.put(FIELD_VIEWNAME2, this.getViewName2());
        }
        if (!bl || this.isViewName3Dirty()) {
            hashMap.put(FIELD_VIEWNAME3, this.getViewName3());
        }
        if (!bl || this.isViewName4Dirty()) {
            hashMap.put(FIELD_VIEWNAME4, this.getViewName4());
        }
        if (!bl || this.isVirtualFlagDirty()) {
            hashMap.put(FIELD_VIRTUALFLAG, this.getVirtualFlag());
        }
        if (!bl || this.isVKeySeparatorDirty()) {
            hashMap.put(FIELD_VKEYSEPARATOR, this.getVKeySeparator());
        }
        super.onFillMap(hashMap, bl);
    }

    public Object get(String string) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().get(string);
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            return super.get(string);
        }
        return PSDataEntityBase.get(this, n);
    }

    private static Object get(PSDataEntityBase pSDataEntityBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDataEntityBase.getAccCtrlArch();
            }
            case 1: {
                return pSDataEntityBase.getAuditMode();
            }
            case 2: {
                return pSDataEntityBase.getBaseClsParams();
            }
            case 3: {
                return pSDataEntityBase.getBizTag();
            }
            case 4: {
                return pSDataEntityBase.getCodeName();
            }
            case 5: {
                return pSDataEntityBase.getCodeNameMode();
            }
            case 6: {
                return pSDataEntityBase.getColor();
            }
            case 7: {
                return pSDataEntityBase.getCreateDate();
            }
            case 8: {
                return pSDataEntityBase.getCreateMan();
            }
            case 9: {
                return pSDataEntityBase.getCustomCode();
            }
            case 10: {
                return pSDataEntityBase.getCustomMode();
            }
            case 11: {
                return pSDataEntityBase.getDataAccMode();
            }
            case 12: {
                return pSDataEntityBase.getDataChgLogMode();
            }
            case 13: {
                return pSDataEntityBase.getDataImpExpFlag();
            }
            case 14: {
                return pSDataEntityBase.getDBTabSpace();
            }
            case 15: {
                return pSDataEntityBase.getDBVer();
            }
            case 16: {
                return pSDataEntityBase.getDECat();
            }
            case 17: {
                return pSDataEntityBase.getDEHolder();
            }
            case 18: {
                return pSDataEntityBase.getDELockFlag();
            }
            case 19: {
                return pSDataEntityBase.getDESN();
            }
            case 20: {
                return pSDataEntityBase.getDETag();
            }
            case 21: {
                return pSDataEntityBase.getDETag2();
            }
            case 22: {
                return pSDataEntityBase.getDEType();
            }
            case 23: {
                return pSDataEntityBase.getDSLink();
            }
            case 24: {
                return pSDataEntityBase.getDstPSDEActionLogicsCnt();
            }
            case 25: {
                return pSDataEntityBase.getDynamicMode();
            }
            case 26: {
                return pSDataEntityBase.getDynaModelFlag();
            }
            case 27: {
                return pSDataEntityBase.getDynaTableMode();
            }
            case 28: {
                return pSDataEntityBase.getEnableAudit();
            }
            case 29: {
                return pSDataEntityBase.getEnableDALog();
            }
            case 30: {
                return pSDataEntityBase.getEnableDataVer();
            }
            case 31: {
                return pSDataEntityBase.getEnableDEAction();
            }
            case 32: {
                return pSDataEntityBase.getEnableDEDataSet();
            }
            case 33: {
                return pSDataEntityBase.getEnableDynaSys();
            }
            case 34: {
                return pSDataEntityBase.getEnableEntityCache();
            }
            case 35: {
                return pSDataEntityBase.getEnableMob();
            }
            case 36: {
                return pSDataEntityBase.getEnableMultiDS();
            }
            case 37: {
                return pSDataEntityBase.getEnableOPNameModel();
            }
            case 38: {
                return pSDataEntityBase.getEnableOrgModel();
            }
            case 39: {
                return pSDataEntityBase.getEnablePQL();
            }
            case 40: {
                return pSDataEntityBase.getEnableSelect();
            }
            case 41: {
                return pSDataEntityBase.getEnableWFModel();
            }
            case 42: {
                return pSDataEntityBase.getEnaMultiForm();
            }
            case 43: {
                return pSDataEntityBase.getEnaTempData();
            }
            case 44: {
                return pSDataEntityBase.getEntityCacheTimeout();
            }
            case 45: {
                return pSDataEntityBase.getExistingModel();
            }
            case 46: {
                return pSDataEntityBase.getExTableName();
            }
            case 47: {
                return pSDataEntityBase.getIndexDEType();
            }
            case 48: {
                return pSDataEntityBase.getKeyRule();
            }
            case 49: {
                return pSDataEntityBase.getLNPSLanResId();
            }
            case 50: {
                return pSDataEntityBase.getLNPSLanResName();
            }
            case 51: {
                return pSDataEntityBase.getLockFlag();
            }
            case 52: {
                return pSDataEntityBase.getLogicInvalidValue();
            }
            case 53: {
                return pSDataEntityBase.getLogicName();
            }
            case 54: {
                return pSDataEntityBase.getLogicValid();
            }
            case 55: {
                return pSDataEntityBase.getLogicValidValue();
            }
            case 56: {
                return pSDataEntityBase.getMajorPSDERsCnt();
            }
            case 57: {
                return pSDataEntityBase.getMaxEntityCacheCnt();
            }
            case 58: {
                return pSDataEntityBase.getMemo();
            }
            case 59: {
                return pSDataEntityBase.getMinorPSDERsCnt();
            }
            case 60: {
                return pSDataEntityBase.getModColor();
            }
            case 61: {
                return pSDataEntityBase.getModelImpExpFlag();
            }
            case 62: {
                return pSDataEntityBase.getModelState();
            }
            case 63: {
                return pSDataEntityBase.getModelVer();
            }
            case 64: {
                return pSDataEntityBase.getMSActionLogicFlag();
            }
            case 65: {
                return pSDataEntityBase.getNoViewMode();
            }
            case 66: {
                return pSDataEntityBase.getOrderValue();
            }
            case 67: {
                return pSDataEntityBase.getPSACHandlersCnt();
            }
            case 68: {
                return pSDataEntityBase.getPSCodeListsCnt();
            }
            case 69: {
                return pSDataEntityBase.getPSDataEntityId();
            }
            case 70: {
                return pSDataEntityBase.getPSDataEntityName();
            }
            case 71: {
                return pSDataEntityBase.getPSDEACModesCnt();
            }
            case 72: {
                return pSDataEntityBase.getPSDEActionLogicsCnt();
            }
            case 73: {
                return pSDataEntityBase.getPSDEActionsCnt();
            }
            case 74: {
                return pSDataEntityBase.getPSDEAWGrpsCnt();
            }
            case 75: {
                return pSDataEntityBase.getPSDEAWsCnt();
            }
            case 76: {
                return pSDataEntityBase.getPSDEChartsCnt();
            }
            case 77: {
                return pSDataEntityBase.getPSDEDataExpsCnt();
            }
            case 78: {
                return pSDataEntityBase.getPSDEDataImpsCnt();
            }
            case 79: {
                return pSDataEntityBase.getPSDEDataQuerysCnt();
            }
            case 80: {
                return pSDataEntityBase.getPSDEDataRelationsCnt();
            }
            case 81: {
                return pSDataEntityBase.getPSDEDataSetsCnt();
            }
            case 82: {
                return pSDataEntityBase.getPSDEDataSyncsCnt();
            }
            case 83: {
                return pSDataEntityBase.getPSDEDataViewsCnt();
            }
            case 84: {
                return pSDataEntityBase.getPSDEDBCfgsCnt();
            }
            case 85: {
                return pSDataEntityBase.getPSDEDBIndexsCnt();
            }
            case 86: {
                return pSDataEntityBase.getPSDEDRGroupsCnt();
            }
            case 87: {
                return pSDataEntityBase.getPSDEDRItemsCnt();
            }
            case 88: {
                return pSDataEntityBase.getPSDEDTSQueuesCnt();
            }
            case 89: {
                return pSDataEntityBase.getPSDEFieldsCnt();
            }
            case 90: {
                return pSDataEntityBase.getPSDEFInputTipSetId();
            }
            case 91: {
                return pSDataEntityBase.getPSDEFInputTipSetName();
            }
            case 92: {
                return pSDataEntityBase.getPSDEFormsCnt();
            }
            case 93: {
                return pSDataEntityBase.getPSDEFSFItemsCnt();
            }
            case 94: {
                return pSDataEntityBase.getPSDEFValueRulesCnt();
            }
            case 95: {
                return pSDataEntityBase.getPSDEGridsCnt();
            }
            case 96: {
                return pSDataEntityBase.getPSDEListsCnt();
            }
            case 97: {
                return pSDataEntityBase.getPSDELogicsCnt();
            }
            case 98: {
                return pSDataEntityBase.getPSDEMainStatesCnt();
            }
            case 99: {
                return pSDataEntityBase.getPSDEOPPrivRolesCnt();
            }
            case 100: {
                return pSDataEntityBase.getPSDEOPPrivsCnt();
            }
            case 101: {
                return pSDataEntityBase.getPSDEPrintsCnt();
            }
            case 102: {
                return pSDataEntityBase.getPSDEReportsCnt();
            }
            case 103: {
                return pSDataEntityBase.getPSDEServiceAPIsCnt();
            }
            case 104: {
                return pSDataEntityBase.getPSDEToolbarsCnt();
            }
            case 105: {
                return pSDataEntityBase.getPSDETreeViewsCnt();
            }
            case 106: {
                return pSDataEntityBase.getPSDEUAGroupsCnt();
            }
            case 107: {
                return pSDataEntityBase.getPSDEUIActionsCnt();
            }
            case 108: {
                return pSDataEntityBase.getPSDEUserRolesCnt();
            }
            case 109: {
                return pSDataEntityBase.getPSDEViewBasesCnt();
            }
            case 110: {
                return pSDataEntityBase.getPSDEWizardsCnt();
            }
            case 111: {
                return pSDataEntityBase.getPSDynaDETemplId();
            }
            case 112: {
                return pSDataEntityBase.getPSDynaDETemplName();
            }
            case 113: {
                return pSDataEntityBase.getPSDynaInstId();
            }
            case 114: {
                return pSDataEntityBase.getPSHelpModuleId();
            }
            case 115: {
                return pSDataEntityBase.getPSHelpModuleName();
            }
            case 116: {
                return pSDataEntityBase.getPSModuleId();
            }
            case 117: {
                return pSDataEntityBase.getPSModuleName();
            }
            case 118: {
                return pSDataEntityBase.getPSSubSysSADEId();
            }
            case 119: {
                return pSDataEntityBase.getPSSubSysSADEName();
            }
            case 120: {
                return pSDataEntityBase.getPSSubSysServiceAPIId();
            }
            case 121: {
                return pSDataEntityBase.getPSSubSysServiceAPIName();
            }
            case 122: {
                return pSDataEntityBase.getPSSysBDTablesCnt();
            }
            case 123: {
                return pSDataEntityBase.getPSSysCountersCnt();
            }
            case 124: {
                return pSDataEntityBase.getPSSysDMItemsCnt();
            }
            case 125: {
                return pSDataEntityBase.getPSSysDynaModelId();
            }
            case 126: {
                return pSDataEntityBase.getPSSysDynaModelName();
            }
            case 127: {
                return pSDataEntityBase.getPSSysImageId();
            }
            case 128: {
                return pSDataEntityBase.getPSSysImageName();
            }
            case 129: {
                return pSDataEntityBase.getPSSysModelChgLogsCnt();
            }
            case 130: {
                return pSDataEntityBase.getPSSysModelGroupId();
            }
            case 131: {
                return pSDataEntityBase.getPSSysModelGroupName();
            }
            case 132: {
                return pSDataEntityBase.getPSSysReqItemId();
            }
            case 133: {
                return pSDataEntityBase.getPSSysReqItemName();
            }
            case 134: {
                return pSDataEntityBase.getPSSysSFPluginId();
            }
            case 135: {
                return pSDataEntityBase.getPSSysSFPluginName();
            }
            case 136: {
                return pSDataEntityBase.getPSSysTasksCnt();
            }
            case 137: {
                return pSDataEntityBase.getPSSystemId();
            }
            case 138: {
                return pSDataEntityBase.getPSSystemName();
            }
            case 139: {
                return pSDataEntityBase.getPSSysTestCasesCnt();
            }
            case 140: {
                return pSDataEntityBase.getPSSysTestDatasCnt();
            }
            case 141: {
                return pSDataEntityBase.getPSSysUniResId();
            }
            case 142: {
                return pSDataEntityBase.getPSSysUniResName();
            }
            case 143: {
                return pSDataEntityBase.getPSWFDEsCnt();
            }
            case 144: {
                return pSDataEntityBase.getReadOnlyMode();
            }
            case 145: {
                return pSDataEntityBase.getRemoveFlag();
            }
            case 146: {
                return pSDataEntityBase.getSaaSMode();
            }
            case 147: {
                return pSDataEntityBase.getServiceAPIFlag();
            }
            case 148: {
                return pSDataEntityBase.getServiceCodeName();
            }
            case 149: {
                return pSDataEntityBase.getSrcPSDEMapsCnt();
            }
            case 150: {
                return pSDataEntityBase.getStorageMode();
            }
            case 151: {
                return pSDataEntityBase.getSubSysDE();
            }
            case 152: {
                return pSDataEntityBase.getSubSysModule();
            }
            case 153: {
                return pSDataEntityBase.getSvrPubMode();
            }
            case 154: {
                return pSDataEntityBase.getSystemFlag();
            }
            case 155: {
                return pSDataEntityBase.getTableName();
            }
            case 156: {
                return pSDataEntityBase.getTestCaseFlag();
            }
            case 157: {
                return pSDataEntityBase.getToDoTask();
            }
            case 158: {
                return pSDataEntityBase.getUpdateDate();
            }
            case 159: {
                return pSDataEntityBase.getUpdateMan();
            }
            case 160: {
                return pSDataEntityBase.getUserAction();
            }
            case 161: {
                return pSDataEntityBase.getUserCat();
            }
            case 162: {
                return pSDataEntityBase.getUserParams();
            }
            case 163: {
                return pSDataEntityBase.getUserTag();
            }
            case 164: {
                return pSDataEntityBase.getUserTag2();
            }
            case 165: {
                return pSDataEntityBase.getUserTag3();
            }
            case 166: {
                return pSDataEntityBase.getUserTag4();
            }
            case 167: {
                return pSDataEntityBase.getValidFlag();
            }
            case 168: {
                return pSDataEntityBase.getViewLevel();
            }
            case 169: {
                return pSDataEntityBase.getViewName();
            }
            case 170: {
                return pSDataEntityBase.getViewName2();
            }
            case 171: {
                return pSDataEntityBase.getViewName3();
            }
            case 172: {
                return pSDataEntityBase.getViewName4();
            }
            case 173: {
                return pSDataEntityBase.getVirtualFlag();
            }
            case 174: {
                return pSDataEntityBase.getVKeySeparator();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    public void set(String string, Object object) throws Exception {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().set(string, object);
            return;
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            super.set(string, object);
            return;
        }
        PSDataEntityBase.set(this, n, object);
    }

    private static void set(PSDataEntityBase pSDataEntityBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDataEntityBase.setAccCtrlArch(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDataEntityBase.setAuditMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 2: {
                pSDataEntityBase.setBaseClsParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDataEntityBase.setBizTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDataEntityBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDataEntityBase.setCodeNameMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDataEntityBase.setColor(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDataEntityBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSDataEntityBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDataEntityBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDataEntityBase.setCustomMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSDataEntityBase.setDataAccMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSDataEntityBase.setDataChgLogMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSDataEntityBase.setDataImpExpFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSDataEntityBase.setDBTabSpace(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDataEntityBase.setDBVer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSDataEntityBase.setDECat(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDataEntityBase.setDEHolder(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSDataEntityBase.setDELockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSDataEntityBase.setDESN(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDataEntityBase.setDETag(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDataEntityBase.setDETag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDataEntityBase.setDEType(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 23: {
                pSDataEntityBase.setDSLink(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDataEntityBase.setDstPSDEActionLogicsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 25: {
                pSDataEntityBase.setDynamicMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 26: {
                pSDataEntityBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 27: {
                pSDataEntityBase.setDynaTableMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 28: {
                pSDataEntityBase.setEnableAudit(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 29: {
                pSDataEntityBase.setEnableDALog(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 30: {
                pSDataEntityBase.setEnableDataVer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 31: {
                pSDataEntityBase.setEnableDEAction(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 32: {
                pSDataEntityBase.setEnableDEDataSet(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 33: {
                pSDataEntityBase.setEnableDynaSys(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 34: {
                pSDataEntityBase.setEnableEntityCache(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 35: {
                pSDataEntityBase.setEnableMob(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 36: {
                pSDataEntityBase.setEnableMultiDS(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 37: {
                pSDataEntityBase.setEnableOPNameModel(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 38: {
                pSDataEntityBase.setEnableOrgModel(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 39: {
                pSDataEntityBase.setEnablePQL(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 40: {
                pSDataEntityBase.setEnableSelect(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 41: {
                pSDataEntityBase.setEnableWFModel(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 42: {
                pSDataEntityBase.setEnaMultiForm(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 43: {
                pSDataEntityBase.setEnaTempData(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 44: {
                pSDataEntityBase.setEntityCacheTimeout(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 45: {
                pSDataEntityBase.setExistingModel(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 46: {
                pSDataEntityBase.setExTableName(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSDataEntityBase.setIndexDEType(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSDataEntityBase.setKeyRule(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSDataEntityBase.setLNPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSDataEntityBase.setLNPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSDataEntityBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 52: {
                pSDataEntityBase.setLogicInvalidValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSDataEntityBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSDataEntityBase.setLogicValid(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 55: {
                pSDataEntityBase.setLogicValidValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSDataEntityBase.setMajorPSDERsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 57: {
                pSDataEntityBase.setMaxEntityCacheCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 58: {
                pSDataEntityBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 59: {
                pSDataEntityBase.setMinorPSDERsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 60: {
                pSDataEntityBase.setModColor(DataObject.getStringValue((Object)object));
                return;
            }
            case 61: {
                pSDataEntityBase.setModelImpExpFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 62: {
                pSDataEntityBase.setModelState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 63: {
                pSDataEntityBase.setModelVer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 64: {
                pSDataEntityBase.setMSActionLogicFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 65: {
                pSDataEntityBase.setNoViewMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 66: {
                pSDataEntityBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 67: {
                pSDataEntityBase.setPSACHandlersCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 68: {
                pSDataEntityBase.setPSCodeListsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 69: {
                pSDataEntityBase.setPSDataEntityId(DataObject.getStringValue((Object)object));
                return;
            }
            case 70: {
                pSDataEntityBase.setPSDataEntityName(DataObject.getStringValue((Object)object));
                return;
            }
            case 71: {
                pSDataEntityBase.setPSDEACModesCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 72: {
                pSDataEntityBase.setPSDEActionLogicsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 73: {
                pSDataEntityBase.setPSDEActionsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 74: {
                pSDataEntityBase.setPSDEAWGrpsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 75: {
                pSDataEntityBase.setPSDEAWsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 76: {
                pSDataEntityBase.setPSDEChartsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 77: {
                pSDataEntityBase.setPSDEDataExpsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 78: {
                pSDataEntityBase.setPSDEDataImpsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 79: {
                pSDataEntityBase.setPSDEDataQuerysCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 80: {
                pSDataEntityBase.setPSDEDataRelationsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 81: {
                pSDataEntityBase.setPSDEDataSetsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 82: {
                pSDataEntityBase.setPSDEDataSyncsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 83: {
                pSDataEntityBase.setPSDEDataViewsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 84: {
                pSDataEntityBase.setPSDEDBCfgsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 85: {
                pSDataEntityBase.setPSDEDBIndexsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 86: {
                pSDataEntityBase.setPSDEDRGroupsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 87: {
                pSDataEntityBase.setPSDEDRItemsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 88: {
                pSDataEntityBase.setPSDEDTSQueuesCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 89: {
                pSDataEntityBase.setPSDEFieldsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 90: {
                pSDataEntityBase.setPSDEFInputTipSetId(DataObject.getStringValue((Object)object));
                return;
            }
            case 91: {
                pSDataEntityBase.setPSDEFInputTipSetName(DataObject.getStringValue((Object)object));
                return;
            }
            case 92: {
                pSDataEntityBase.setPSDEFormsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 93: {
                pSDataEntityBase.setPSDEFSFItemsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 94: {
                pSDataEntityBase.setPSDEFValueRulesCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 95: {
                pSDataEntityBase.setPSDEGridsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 96: {
                pSDataEntityBase.setPSDEListsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 97: {
                pSDataEntityBase.setPSDELogicsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 98: {
                pSDataEntityBase.setPSDEMainStatesCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 99: {
                pSDataEntityBase.setPSDEOPPrivRolesCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 100: {
                pSDataEntityBase.setPSDEOPPrivsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 101: {
                pSDataEntityBase.setPSDEPrintsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 102: {
                pSDataEntityBase.setPSDEReportsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 103: {
                pSDataEntityBase.setPSDEServiceAPIsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 104: {
                pSDataEntityBase.setPSDEToolbarsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 105: {
                pSDataEntityBase.setPSDETreeViewsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 106: {
                pSDataEntityBase.setPSDEUAGroupsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 107: {
                pSDataEntityBase.setPSDEUIActionsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 108: {
                pSDataEntityBase.setPSDEUserRolesCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 109: {
                pSDataEntityBase.setPSDEViewBasesCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 110: {
                pSDataEntityBase.setPSDEWizardsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 111: {
                pSDataEntityBase.setPSDynaDETemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 112: {
                pSDataEntityBase.setPSDynaDETemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 113: {
                pSDataEntityBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 114: {
                pSDataEntityBase.setPSHelpModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 115: {
                pSDataEntityBase.setPSHelpModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 116: {
                pSDataEntityBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 117: {
                pSDataEntityBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 118: {
                pSDataEntityBase.setPSSubSysSADEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 119: {
                pSDataEntityBase.setPSSubSysSADEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 120: {
                pSDataEntityBase.setPSSubSysServiceAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 121: {
                pSDataEntityBase.setPSSubSysServiceAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 122: {
                pSDataEntityBase.setPSSysBDTablesCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 123: {
                pSDataEntityBase.setPSSysCountersCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 124: {
                pSDataEntityBase.setPSSysDMItemsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 125: {
                pSDataEntityBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 126: {
                pSDataEntityBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 127: {
                pSDataEntityBase.setPSSysImageId(DataObject.getStringValue((Object)object));
                return;
            }
            case 128: {
                pSDataEntityBase.setPSSysImageName(DataObject.getStringValue((Object)object));
                return;
            }
            case 129: {
                pSDataEntityBase.setPSSysModelChgLogsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 130: {
                pSDataEntityBase.setPSSysModelGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 131: {
                pSDataEntityBase.setPSSysModelGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 132: {
                pSDataEntityBase.setPSSysReqItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 133: {
                pSDataEntityBase.setPSSysReqItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 134: {
                pSDataEntityBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 135: {
                pSDataEntityBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 136: {
                pSDataEntityBase.setPSSysTasksCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 137: {
                pSDataEntityBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 138: {
                pSDataEntityBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 139: {
                pSDataEntityBase.setPSSysTestCasesCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 140: {
                pSDataEntityBase.setPSSysTestDatasCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 141: {
                pSDataEntityBase.setPSSysUniResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 142: {
                pSDataEntityBase.setPSSysUniResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 143: {
                pSDataEntityBase.setPSWFDEsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 144: {
                pSDataEntityBase.setReadOnlyMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 145: {
                pSDataEntityBase.setRemoveFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 146: {
                pSDataEntityBase.setSaaSMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 147: {
                pSDataEntityBase.setServiceAPIFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 148: {
                pSDataEntityBase.setServiceCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 149: {
                pSDataEntityBase.setSrcPSDEMapsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 150: {
                pSDataEntityBase.setStorageMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 151: {
                pSDataEntityBase.setSubSysDE(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 152: {
                pSDataEntityBase.setSubSysModule(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 153: {
                pSDataEntityBase.setSvrPubMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 154: {
                pSDataEntityBase.setSystemFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 155: {
                pSDataEntityBase.setTableName(DataObject.getStringValue((Object)object));
                return;
            }
            case 156: {
                pSDataEntityBase.setTestCaseFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 157: {
                pSDataEntityBase.setToDoTask(DataObject.getStringValue((Object)object));
                return;
            }
            case 158: {
                pSDataEntityBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 159: {
                pSDataEntityBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 160: {
                pSDataEntityBase.setUserAction(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 161: {
                pSDataEntityBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 162: {
                pSDataEntityBase.setUserParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 163: {
                pSDataEntityBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 164: {
                pSDataEntityBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 165: {
                pSDataEntityBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 166: {
                pSDataEntityBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 167: {
                pSDataEntityBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 168: {
                pSDataEntityBase.setViewLevel(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 169: {
                pSDataEntityBase.setViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 170: {
                pSDataEntityBase.setViewName2(DataObject.getStringValue((Object)object));
                return;
            }
            case 171: {
                pSDataEntityBase.setViewName3(DataObject.getStringValue((Object)object));
                return;
            }
            case 172: {
                pSDataEntityBase.setViewName4(DataObject.getStringValue((Object)object));
                return;
            }
            case 173: {
                pSDataEntityBase.setVirtualFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 174: {
                pSDataEntityBase.setVKeySeparator(DataObject.getStringValue((Object)object));
                return;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    public boolean isNull(String string) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNull(string);
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            return super.isNull(string);
        }
        return PSDataEntityBase.isNull(this, n);
    }

    private static boolean isNull(PSDataEntityBase pSDataEntityBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDataEntityBase.getAccCtrlArch() == null;
            }
            case 1: {
                return pSDataEntityBase.getAuditMode() == null;
            }
            case 2: {
                return pSDataEntityBase.getBaseClsParams() == null;
            }
            case 3: {
                return pSDataEntityBase.getBizTag() == null;
            }
            case 4: {
                return pSDataEntityBase.getCodeName() == null;
            }
            case 5: {
                return pSDataEntityBase.getCodeNameMode() == null;
            }
            case 6: {
                return pSDataEntityBase.getColor() == null;
            }
            case 7: {
                return pSDataEntityBase.getCreateDate() == null;
            }
            case 8: {
                return pSDataEntityBase.getCreateMan() == null;
            }
            case 9: {
                return pSDataEntityBase.getCustomCode() == null;
            }
            case 10: {
                return pSDataEntityBase.getCustomMode() == null;
            }
            case 11: {
                return pSDataEntityBase.getDataAccMode() == null;
            }
            case 12: {
                return pSDataEntityBase.getDataChgLogMode() == null;
            }
            case 13: {
                return pSDataEntityBase.getDataImpExpFlag() == null;
            }
            case 14: {
                return pSDataEntityBase.getDBTabSpace() == null;
            }
            case 15: {
                return pSDataEntityBase.getDBVer() == null;
            }
            case 16: {
                return pSDataEntityBase.getDECat() == null;
            }
            case 17: {
                return pSDataEntityBase.getDEHolder() == null;
            }
            case 18: {
                return pSDataEntityBase.getDELockFlag() == null;
            }
            case 19: {
                return pSDataEntityBase.getDESN() == null;
            }
            case 20: {
                return pSDataEntityBase.getDETag() == null;
            }
            case 21: {
                return pSDataEntityBase.getDETag2() == null;
            }
            case 22: {
                return pSDataEntityBase.getDEType() == null;
            }
            case 23: {
                return pSDataEntityBase.getDSLink() == null;
            }
            case 24: {
                return pSDataEntityBase.getDstPSDEActionLogicsCnt() == null;
            }
            case 25: {
                return pSDataEntityBase.getDynamicMode() == null;
            }
            case 26: {
                return pSDataEntityBase.getDynaModelFlag() == null;
            }
            case 27: {
                return pSDataEntityBase.getDynaTableMode() == null;
            }
            case 28: {
                return pSDataEntityBase.getEnableAudit() == null;
            }
            case 29: {
                return pSDataEntityBase.getEnableDALog() == null;
            }
            case 30: {
                return pSDataEntityBase.getEnableDataVer() == null;
            }
            case 31: {
                return pSDataEntityBase.getEnableDEAction() == null;
            }
            case 32: {
                return pSDataEntityBase.getEnableDEDataSet() == null;
            }
            case 33: {
                return pSDataEntityBase.getEnableDynaSys() == null;
            }
            case 34: {
                return pSDataEntityBase.getEnableEntityCache() == null;
            }
            case 35: {
                return pSDataEntityBase.getEnableMob() == null;
            }
            case 36: {
                return pSDataEntityBase.getEnableMultiDS() == null;
            }
            case 37: {
                return pSDataEntityBase.getEnableOPNameModel() == null;
            }
            case 38: {
                return pSDataEntityBase.getEnableOrgModel() == null;
            }
            case 39: {
                return pSDataEntityBase.getEnablePQL() == null;
            }
            case 40: {
                return pSDataEntityBase.getEnableSelect() == null;
            }
            case 41: {
                return pSDataEntityBase.getEnableWFModel() == null;
            }
            case 42: {
                return pSDataEntityBase.getEnaMultiForm() == null;
            }
            case 43: {
                return pSDataEntityBase.getEnaTempData() == null;
            }
            case 44: {
                return pSDataEntityBase.getEntityCacheTimeout() == null;
            }
            case 45: {
                return pSDataEntityBase.getExistingModel() == null;
            }
            case 46: {
                return pSDataEntityBase.getExTableName() == null;
            }
            case 47: {
                return pSDataEntityBase.getIndexDEType() == null;
            }
            case 48: {
                return pSDataEntityBase.getKeyRule() == null;
            }
            case 49: {
                return pSDataEntityBase.getLNPSLanResId() == null;
            }
            case 50: {
                return pSDataEntityBase.getLNPSLanResName() == null;
            }
            case 51: {
                return pSDataEntityBase.getLockFlag() == null;
            }
            case 52: {
                return pSDataEntityBase.getLogicInvalidValue() == null;
            }
            case 53: {
                return pSDataEntityBase.getLogicName() == null;
            }
            case 54: {
                return pSDataEntityBase.getLogicValid() == null;
            }
            case 55: {
                return pSDataEntityBase.getLogicValidValue() == null;
            }
            case 56: {
                return pSDataEntityBase.getMajorPSDERsCnt() == null;
            }
            case 57: {
                return pSDataEntityBase.getMaxEntityCacheCnt() == null;
            }
            case 58: {
                return pSDataEntityBase.getMemo() == null;
            }
            case 59: {
                return pSDataEntityBase.getMinorPSDERsCnt() == null;
            }
            case 60: {
                return pSDataEntityBase.getModColor() == null;
            }
            case 61: {
                return pSDataEntityBase.getModelImpExpFlag() == null;
            }
            case 62: {
                return pSDataEntityBase.getModelState() == null;
            }
            case 63: {
                return pSDataEntityBase.getModelVer() == null;
            }
            case 64: {
                return pSDataEntityBase.getMSActionLogicFlag() == null;
            }
            case 65: {
                return pSDataEntityBase.getNoViewMode() == null;
            }
            case 66: {
                return pSDataEntityBase.getOrderValue() == null;
            }
            case 67: {
                return pSDataEntityBase.getPSACHandlersCnt() == null;
            }
            case 68: {
                return pSDataEntityBase.getPSCodeListsCnt() == null;
            }
            case 69: {
                return pSDataEntityBase.getPSDataEntityId() == null;
            }
            case 70: {
                return pSDataEntityBase.getPSDataEntityName() == null;
            }
            case 71: {
                return pSDataEntityBase.getPSDEACModesCnt() == null;
            }
            case 72: {
                return pSDataEntityBase.getPSDEActionLogicsCnt() == null;
            }
            case 73: {
                return pSDataEntityBase.getPSDEActionsCnt() == null;
            }
            case 74: {
                return pSDataEntityBase.getPSDEAWGrpsCnt() == null;
            }
            case 75: {
                return pSDataEntityBase.getPSDEAWsCnt() == null;
            }
            case 76: {
                return pSDataEntityBase.getPSDEChartsCnt() == null;
            }
            case 77: {
                return pSDataEntityBase.getPSDEDataExpsCnt() == null;
            }
            case 78: {
                return pSDataEntityBase.getPSDEDataImpsCnt() == null;
            }
            case 79: {
                return pSDataEntityBase.getPSDEDataQuerysCnt() == null;
            }
            case 80: {
                return pSDataEntityBase.getPSDEDataRelationsCnt() == null;
            }
            case 81: {
                return pSDataEntityBase.getPSDEDataSetsCnt() == null;
            }
            case 82: {
                return pSDataEntityBase.getPSDEDataSyncsCnt() == null;
            }
            case 83: {
                return pSDataEntityBase.getPSDEDataViewsCnt() == null;
            }
            case 84: {
                return pSDataEntityBase.getPSDEDBCfgsCnt() == null;
            }
            case 85: {
                return pSDataEntityBase.getPSDEDBIndexsCnt() == null;
            }
            case 86: {
                return pSDataEntityBase.getPSDEDRGroupsCnt() == null;
            }
            case 87: {
                return pSDataEntityBase.getPSDEDRItemsCnt() == null;
            }
            case 88: {
                return pSDataEntityBase.getPSDEDTSQueuesCnt() == null;
            }
            case 89: {
                return pSDataEntityBase.getPSDEFieldsCnt() == null;
            }
            case 90: {
                return pSDataEntityBase.getPSDEFInputTipSetId() == null;
            }
            case 91: {
                return pSDataEntityBase.getPSDEFInputTipSetName() == null;
            }
            case 92: {
                return pSDataEntityBase.getPSDEFormsCnt() == null;
            }
            case 93: {
                return pSDataEntityBase.getPSDEFSFItemsCnt() == null;
            }
            case 94: {
                return pSDataEntityBase.getPSDEFValueRulesCnt() == null;
            }
            case 95: {
                return pSDataEntityBase.getPSDEGridsCnt() == null;
            }
            case 96: {
                return pSDataEntityBase.getPSDEListsCnt() == null;
            }
            case 97: {
                return pSDataEntityBase.getPSDELogicsCnt() == null;
            }
            case 98: {
                return pSDataEntityBase.getPSDEMainStatesCnt() == null;
            }
            case 99: {
                return pSDataEntityBase.getPSDEOPPrivRolesCnt() == null;
            }
            case 100: {
                return pSDataEntityBase.getPSDEOPPrivsCnt() == null;
            }
            case 101: {
                return pSDataEntityBase.getPSDEPrintsCnt() == null;
            }
            case 102: {
                return pSDataEntityBase.getPSDEReportsCnt() == null;
            }
            case 103: {
                return pSDataEntityBase.getPSDEServiceAPIsCnt() == null;
            }
            case 104: {
                return pSDataEntityBase.getPSDEToolbarsCnt() == null;
            }
            case 105: {
                return pSDataEntityBase.getPSDETreeViewsCnt() == null;
            }
            case 106: {
                return pSDataEntityBase.getPSDEUAGroupsCnt() == null;
            }
            case 107: {
                return pSDataEntityBase.getPSDEUIActionsCnt() == null;
            }
            case 108: {
                return pSDataEntityBase.getPSDEUserRolesCnt() == null;
            }
            case 109: {
                return pSDataEntityBase.getPSDEViewBasesCnt() == null;
            }
            case 110: {
                return pSDataEntityBase.getPSDEWizardsCnt() == null;
            }
            case 111: {
                return pSDataEntityBase.getPSDynaDETemplId() == null;
            }
            case 112: {
                return pSDataEntityBase.getPSDynaDETemplName() == null;
            }
            case 113: {
                return pSDataEntityBase.getPSDynaInstId() == null;
            }
            case 114: {
                return pSDataEntityBase.getPSHelpModuleId() == null;
            }
            case 115: {
                return pSDataEntityBase.getPSHelpModuleName() == null;
            }
            case 116: {
                return pSDataEntityBase.getPSModuleId() == null;
            }
            case 117: {
                return pSDataEntityBase.getPSModuleName() == null;
            }
            case 118: {
                return pSDataEntityBase.getPSSubSysSADEId() == null;
            }
            case 119: {
                return pSDataEntityBase.getPSSubSysSADEName() == null;
            }
            case 120: {
                return pSDataEntityBase.getPSSubSysServiceAPIId() == null;
            }
            case 121: {
                return pSDataEntityBase.getPSSubSysServiceAPIName() == null;
            }
            case 122: {
                return pSDataEntityBase.getPSSysBDTablesCnt() == null;
            }
            case 123: {
                return pSDataEntityBase.getPSSysCountersCnt() == null;
            }
            case 124: {
                return pSDataEntityBase.getPSSysDMItemsCnt() == null;
            }
            case 125: {
                return pSDataEntityBase.getPSSysDynaModelId() == null;
            }
            case 126: {
                return pSDataEntityBase.getPSSysDynaModelName() == null;
            }
            case 127: {
                return pSDataEntityBase.getPSSysImageId() == null;
            }
            case 128: {
                return pSDataEntityBase.getPSSysImageName() == null;
            }
            case 129: {
                return pSDataEntityBase.getPSSysModelChgLogsCnt() == null;
            }
            case 130: {
                return pSDataEntityBase.getPSSysModelGroupId() == null;
            }
            case 131: {
                return pSDataEntityBase.getPSSysModelGroupName() == null;
            }
            case 132: {
                return pSDataEntityBase.getPSSysReqItemId() == null;
            }
            case 133: {
                return pSDataEntityBase.getPSSysReqItemName() == null;
            }
            case 134: {
                return pSDataEntityBase.getPSSysSFPluginId() == null;
            }
            case 135: {
                return pSDataEntityBase.getPSSysSFPluginName() == null;
            }
            case 136: {
                return pSDataEntityBase.getPSSysTasksCnt() == null;
            }
            case 137: {
                return pSDataEntityBase.getPSSystemId() == null;
            }
            case 138: {
                return pSDataEntityBase.getPSSystemName() == null;
            }
            case 139: {
                return pSDataEntityBase.getPSSysTestCasesCnt() == null;
            }
            case 140: {
                return pSDataEntityBase.getPSSysTestDatasCnt() == null;
            }
            case 141: {
                return pSDataEntityBase.getPSSysUniResId() == null;
            }
            case 142: {
                return pSDataEntityBase.getPSSysUniResName() == null;
            }
            case 143: {
                return pSDataEntityBase.getPSWFDEsCnt() == null;
            }
            case 144: {
                return pSDataEntityBase.getReadOnlyMode() == null;
            }
            case 145: {
                return pSDataEntityBase.getRemoveFlag() == null;
            }
            case 146: {
                return pSDataEntityBase.getSaaSMode() == null;
            }
            case 147: {
                return pSDataEntityBase.getServiceAPIFlag() == null;
            }
            case 148: {
                return pSDataEntityBase.getServiceCodeName() == null;
            }
            case 149: {
                return pSDataEntityBase.getSrcPSDEMapsCnt() == null;
            }
            case 150: {
                return pSDataEntityBase.getStorageMode() == null;
            }
            case 151: {
                return pSDataEntityBase.getSubSysDE() == null;
            }
            case 152: {
                return pSDataEntityBase.getSubSysModule() == null;
            }
            case 153: {
                return pSDataEntityBase.getSvrPubMode() == null;
            }
            case 154: {
                return pSDataEntityBase.getSystemFlag() == null;
            }
            case 155: {
                return pSDataEntityBase.getTableName() == null;
            }
            case 156: {
                return pSDataEntityBase.getTestCaseFlag() == null;
            }
            case 157: {
                return pSDataEntityBase.getToDoTask() == null;
            }
            case 158: {
                return pSDataEntityBase.getUpdateDate() == null;
            }
            case 159: {
                return pSDataEntityBase.getUpdateMan() == null;
            }
            case 160: {
                return pSDataEntityBase.getUserAction() == null;
            }
            case 161: {
                return pSDataEntityBase.getUserCat() == null;
            }
            case 162: {
                return pSDataEntityBase.getUserParams() == null;
            }
            case 163: {
                return pSDataEntityBase.getUserTag() == null;
            }
            case 164: {
                return pSDataEntityBase.getUserTag2() == null;
            }
            case 165: {
                return pSDataEntityBase.getUserTag3() == null;
            }
            case 166: {
                return pSDataEntityBase.getUserTag4() == null;
            }
            case 167: {
                return pSDataEntityBase.getValidFlag() == null;
            }
            case 168: {
                return pSDataEntityBase.getViewLevel() == null;
            }
            case 169: {
                return pSDataEntityBase.getViewName() == null;
            }
            case 170: {
                return pSDataEntityBase.getViewName2() == null;
            }
            case 171: {
                return pSDataEntityBase.getViewName3() == null;
            }
            case 172: {
                return pSDataEntityBase.getViewName4() == null;
            }
            case 173: {
                return pSDataEntityBase.getVirtualFlag() == null;
            }
            case 174: {
                return pSDataEntityBase.getVKeySeparator() == null;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    public boolean contains(String string) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().contains(string);
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            return super.contains(string);
        }
        return PSDataEntityBase.contains(this, n);
    }

    private static boolean contains(PSDataEntityBase pSDataEntityBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDataEntityBase.isAccCtrlArchDirty();
            }
            case 1: {
                return pSDataEntityBase.isAuditModeDirty();
            }
            case 2: {
                return pSDataEntityBase.isBaseClsParamsDirty();
            }
            case 3: {
                return pSDataEntityBase.isBizTagDirty();
            }
            case 4: {
                return pSDataEntityBase.isCodeNameDirty();
            }
            case 5: {
                return pSDataEntityBase.isCodeNameModeDirty();
            }
            case 6: {
                return pSDataEntityBase.isColorDirty();
            }
            case 7: {
                return pSDataEntityBase.isCreateDateDirty();
            }
            case 8: {
                return pSDataEntityBase.isCreateManDirty();
            }
            case 9: {
                return pSDataEntityBase.isCustomCodeDirty();
            }
            case 10: {
                return pSDataEntityBase.isCustomModeDirty();
            }
            case 11: {
                return pSDataEntityBase.isDataAccModeDirty();
            }
            case 12: {
                return pSDataEntityBase.isDataChgLogModeDirty();
            }
            case 13: {
                return pSDataEntityBase.isDataImpExpFlagDirty();
            }
            case 14: {
                return pSDataEntityBase.isDBTabSpaceDirty();
            }
            case 15: {
                return pSDataEntityBase.isDBVerDirty();
            }
            case 16: {
                return pSDataEntityBase.isDECatDirty();
            }
            case 17: {
                return pSDataEntityBase.isDEHolderDirty();
            }
            case 18: {
                return pSDataEntityBase.isDELockFlagDirty();
            }
            case 19: {
                return pSDataEntityBase.isDESNDirty();
            }
            case 20: {
                return pSDataEntityBase.isDETagDirty();
            }
            case 21: {
                return pSDataEntityBase.isDETag2Dirty();
            }
            case 22: {
                return pSDataEntityBase.isDETypeDirty();
            }
            case 23: {
                return pSDataEntityBase.isDSLinkDirty();
            }
            case 24: {
                return pSDataEntityBase.isDstPSDEActionLogicsCntDirty();
            }
            case 25: {
                return pSDataEntityBase.isDynamicModeDirty();
            }
            case 26: {
                return pSDataEntityBase.isDynaModelFlagDirty();
            }
            case 27: {
                return pSDataEntityBase.isDynaTableModeDirty();
            }
            case 28: {
                return pSDataEntityBase.isEnableAuditDirty();
            }
            case 29: {
                return pSDataEntityBase.isEnableDALogDirty();
            }
            case 30: {
                return pSDataEntityBase.isEnableDataVerDirty();
            }
            case 31: {
                return pSDataEntityBase.isEnableDEActionDirty();
            }
            case 32: {
                return pSDataEntityBase.isEnableDEDataSetDirty();
            }
            case 33: {
                return pSDataEntityBase.isEnableDynaSysDirty();
            }
            case 34: {
                return pSDataEntityBase.isEnableEntityCacheDirty();
            }
            case 35: {
                return pSDataEntityBase.isEnableMobDirty();
            }
            case 36: {
                return pSDataEntityBase.isEnableMultiDSDirty();
            }
            case 37: {
                return pSDataEntityBase.isEnableOPNameModelDirty();
            }
            case 38: {
                return pSDataEntityBase.isEnableOrgModelDirty();
            }
            case 39: {
                return pSDataEntityBase.isEnablePQLDirty();
            }
            case 40: {
                return pSDataEntityBase.isEnableSelectDirty();
            }
            case 41: {
                return pSDataEntityBase.isEnableWFModelDirty();
            }
            case 42: {
                return pSDataEntityBase.isEnaMultiFormDirty();
            }
            case 43: {
                return pSDataEntityBase.isEnaTempDataDirty();
            }
            case 44: {
                return pSDataEntityBase.isEntityCacheTimeoutDirty();
            }
            case 45: {
                return pSDataEntityBase.isExistingModelDirty();
            }
            case 46: {
                return pSDataEntityBase.isExTableNameDirty();
            }
            case 47: {
                return pSDataEntityBase.isIndexDETypeDirty();
            }
            case 48: {
                return pSDataEntityBase.isKeyRuleDirty();
            }
            case 49: {
                return pSDataEntityBase.isLNPSLanResIdDirty();
            }
            case 50: {
                return pSDataEntityBase.isLNPSLanResNameDirty();
            }
            case 51: {
                return pSDataEntityBase.isLockFlagDirty();
            }
            case 52: {
                return pSDataEntityBase.isLogicInvalidValueDirty();
            }
            case 53: {
                return pSDataEntityBase.isLogicNameDirty();
            }
            case 54: {
                return pSDataEntityBase.isLogicValidDirty();
            }
            case 55: {
                return pSDataEntityBase.isLogicValidValueDirty();
            }
            case 56: {
                return pSDataEntityBase.isMajorPSDERsCntDirty();
            }
            case 57: {
                return pSDataEntityBase.isMaxEntityCacheCntDirty();
            }
            case 58: {
                return pSDataEntityBase.isMemoDirty();
            }
            case 59: {
                return pSDataEntityBase.isMinorPSDERsCntDirty();
            }
            case 60: {
                return pSDataEntityBase.isModColorDirty();
            }
            case 61: {
                return pSDataEntityBase.isModelImpExpFlagDirty();
            }
            case 62: {
                return pSDataEntityBase.isModelStateDirty();
            }
            case 63: {
                return pSDataEntityBase.isModelVerDirty();
            }
            case 64: {
                return pSDataEntityBase.isMSActionLogicFlagDirty();
            }
            case 65: {
                return pSDataEntityBase.isNoViewModeDirty();
            }
            case 66: {
                return pSDataEntityBase.isOrderValueDirty();
            }
            case 67: {
                return pSDataEntityBase.isPSACHandlersCntDirty();
            }
            case 68: {
                return pSDataEntityBase.isPSCodeListsCntDirty();
            }
            case 69: {
                return pSDataEntityBase.isPSDataEntityIdDirty();
            }
            case 70: {
                return pSDataEntityBase.isPSDataEntityNameDirty();
            }
            case 71: {
                return pSDataEntityBase.isPSDEACModesCntDirty();
            }
            case 72: {
                return pSDataEntityBase.isPSDEActionLogicsCntDirty();
            }
            case 73: {
                return pSDataEntityBase.isPSDEActionsCntDirty();
            }
            case 74: {
                return pSDataEntityBase.isPSDEAWGrpsCntDirty();
            }
            case 75: {
                return pSDataEntityBase.isPSDEAWsCntDirty();
            }
            case 76: {
                return pSDataEntityBase.isPSDEChartsCntDirty();
            }
            case 77: {
                return pSDataEntityBase.isPSDEDataExpsCntDirty();
            }
            case 78: {
                return pSDataEntityBase.isPSDEDataImpsCntDirty();
            }
            case 79: {
                return pSDataEntityBase.isPSDEDataQuerysCntDirty();
            }
            case 80: {
                return pSDataEntityBase.isPSDEDataRelationsCntDirty();
            }
            case 81: {
                return pSDataEntityBase.isPSDEDataSetsCntDirty();
            }
            case 82: {
                return pSDataEntityBase.isPSDEDataSyncsCntDirty();
            }
            case 83: {
                return pSDataEntityBase.isPSDEDataViewsCntDirty();
            }
            case 84: {
                return pSDataEntityBase.isPSDEDBCfgsCntDirty();
            }
            case 85: {
                return pSDataEntityBase.isPSDEDBIndexsCntDirty();
            }
            case 86: {
                return pSDataEntityBase.isPSDEDRGroupsCntDirty();
            }
            case 87: {
                return pSDataEntityBase.isPSDEDRItemsCntDirty();
            }
            case 88: {
                return pSDataEntityBase.isPSDEDTSQueuesCntDirty();
            }
            case 89: {
                return pSDataEntityBase.isPSDEFieldsCntDirty();
            }
            case 90: {
                return pSDataEntityBase.isPSDEFInputTipSetIdDirty();
            }
            case 91: {
                return pSDataEntityBase.isPSDEFInputTipSetNameDirty();
            }
            case 92: {
                return pSDataEntityBase.isPSDEFormsCntDirty();
            }
            case 93: {
                return pSDataEntityBase.isPSDEFSFItemsCntDirty();
            }
            case 94: {
                return pSDataEntityBase.isPSDEFValueRulesCntDirty();
            }
            case 95: {
                return pSDataEntityBase.isPSDEGridsCntDirty();
            }
            case 96: {
                return pSDataEntityBase.isPSDEListsCntDirty();
            }
            case 97: {
                return pSDataEntityBase.isPSDELogicsCntDirty();
            }
            case 98: {
                return pSDataEntityBase.isPSDEMainStatesCntDirty();
            }
            case 99: {
                return pSDataEntityBase.isPSDEOPPrivRolesCntDirty();
            }
            case 100: {
                return pSDataEntityBase.isPSDEOPPrivsCntDirty();
            }
            case 101: {
                return pSDataEntityBase.isPSDEPrintsCntDirty();
            }
            case 102: {
                return pSDataEntityBase.isPSDEReportsCntDirty();
            }
            case 103: {
                return pSDataEntityBase.isPSDEServiceAPIsCntDirty();
            }
            case 104: {
                return pSDataEntityBase.isPSDEToolbarsCntDirty();
            }
            case 105: {
                return pSDataEntityBase.isPSDETreeViewsCntDirty();
            }
            case 106: {
                return pSDataEntityBase.isPSDEUAGroupsCntDirty();
            }
            case 107: {
                return pSDataEntityBase.isPSDEUIActionsCntDirty();
            }
            case 108: {
                return pSDataEntityBase.isPSDEUserRolesCntDirty();
            }
            case 109: {
                return pSDataEntityBase.isPSDEViewBasesCntDirty();
            }
            case 110: {
                return pSDataEntityBase.isPSDEWizardsCntDirty();
            }
            case 111: {
                return pSDataEntityBase.isPSDynaDETemplIdDirty();
            }
            case 112: {
                return pSDataEntityBase.isPSDynaDETemplNameDirty();
            }
            case 113: {
                return pSDataEntityBase.isPSDynaInstIdDirty();
            }
            case 114: {
                return pSDataEntityBase.isPSHelpModuleIdDirty();
            }
            case 115: {
                return pSDataEntityBase.isPSHelpModuleNameDirty();
            }
            case 116: {
                return pSDataEntityBase.isPSModuleIdDirty();
            }
            case 117: {
                return pSDataEntityBase.isPSModuleNameDirty();
            }
            case 118: {
                return pSDataEntityBase.isPSSubSysSADEIdDirty();
            }
            case 119: {
                return pSDataEntityBase.isPSSubSysSADENameDirty();
            }
            case 120: {
                return pSDataEntityBase.isPSSubSysServiceAPIIdDirty();
            }
            case 121: {
                return pSDataEntityBase.isPSSubSysServiceAPINameDirty();
            }
            case 122: {
                return pSDataEntityBase.isPSSysBDTablesCntDirty();
            }
            case 123: {
                return pSDataEntityBase.isPSSysCountersCntDirty();
            }
            case 124: {
                return pSDataEntityBase.isPSSysDMItemsCntDirty();
            }
            case 125: {
                return pSDataEntityBase.isPSSysDynaModelIdDirty();
            }
            case 126: {
                return pSDataEntityBase.isPSSysDynaModelNameDirty();
            }
            case 127: {
                return pSDataEntityBase.isPSSysImageIdDirty();
            }
            case 128: {
                return pSDataEntityBase.isPSSysImageNameDirty();
            }
            case 129: {
                return pSDataEntityBase.isPSSysModelChgLogsCntDirty();
            }
            case 130: {
                return pSDataEntityBase.isPSSysModelGroupIdDirty();
            }
            case 131: {
                return pSDataEntityBase.isPSSysModelGroupNameDirty();
            }
            case 132: {
                return pSDataEntityBase.isPSSysReqItemIdDirty();
            }
            case 133: {
                return pSDataEntityBase.isPSSysReqItemNameDirty();
            }
            case 134: {
                return pSDataEntityBase.isPSSysSFPluginIdDirty();
            }
            case 135: {
                return pSDataEntityBase.isPSSysSFPluginNameDirty();
            }
            case 136: {
                return pSDataEntityBase.isPSSysTasksCntDirty();
            }
            case 137: {
                return pSDataEntityBase.isPSSystemIdDirty();
            }
            case 138: {
                return pSDataEntityBase.isPSSystemNameDirty();
            }
            case 139: {
                return pSDataEntityBase.isPSSysTestCasesCntDirty();
            }
            case 140: {
                return pSDataEntityBase.isPSSysTestDatasCntDirty();
            }
            case 141: {
                return pSDataEntityBase.isPSSysUniResIdDirty();
            }
            case 142: {
                return pSDataEntityBase.isPSSysUniResNameDirty();
            }
            case 143: {
                return pSDataEntityBase.isPSWFDEsCntDirty();
            }
            case 144: {
                return pSDataEntityBase.isReadOnlyModeDirty();
            }
            case 145: {
                return pSDataEntityBase.isRemoveFlagDirty();
            }
            case 146: {
                return pSDataEntityBase.isSaaSModeDirty();
            }
            case 147: {
                return pSDataEntityBase.isServiceAPIFlagDirty();
            }
            case 148: {
                return pSDataEntityBase.isServiceCodeNameDirty();
            }
            case 149: {
                return pSDataEntityBase.isSrcPSDEMapsCntDirty();
            }
            case 150: {
                return pSDataEntityBase.isStorageModeDirty();
            }
            case 151: {
                return pSDataEntityBase.isSubSysDEDirty();
            }
            case 152: {
                return pSDataEntityBase.isSubSysModuleDirty();
            }
            case 153: {
                return pSDataEntityBase.isSvrPubModeDirty();
            }
            case 154: {
                return pSDataEntityBase.isSystemFlagDirty();
            }
            case 155: {
                return pSDataEntityBase.isTableNameDirty();
            }
            case 156: {
                return pSDataEntityBase.isTestCaseFlagDirty();
            }
            case 157: {
                return pSDataEntityBase.isToDoTaskDirty();
            }
            case 158: {
                return pSDataEntityBase.isUpdateDateDirty();
            }
            case 159: {
                return pSDataEntityBase.isUpdateManDirty();
            }
            case 160: {
                return pSDataEntityBase.isUserActionDirty();
            }
            case 161: {
                return pSDataEntityBase.isUserCatDirty();
            }
            case 162: {
                return pSDataEntityBase.isUserParamsDirty();
            }
            case 163: {
                return pSDataEntityBase.isUserTagDirty();
            }
            case 164: {
                return pSDataEntityBase.isUserTag2Dirty();
            }
            case 165: {
                return pSDataEntityBase.isUserTag3Dirty();
            }
            case 166: {
                return pSDataEntityBase.isUserTag4Dirty();
            }
            case 167: {
                return pSDataEntityBase.isValidFlagDirty();
            }
            case 168: {
                return pSDataEntityBase.isViewLevelDirty();
            }
            case 169: {
                return pSDataEntityBase.isViewNameDirty();
            }
            case 170: {
                return pSDataEntityBase.isViewName2Dirty();
            }
            case 171: {
                return pSDataEntityBase.isViewName3Dirty();
            }
            case 172: {
                return pSDataEntityBase.isViewName4Dirty();
            }
            case 173: {
                return pSDataEntityBase.isVirtualFlagDirty();
            }
            case 174: {
                return pSDataEntityBase.isVKeySeparatorDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDataEntityBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDataEntityBase pSDataEntityBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDataEntityBase.getAccCtrlArch() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"accctrlarch", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getAccCtrlArch()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getAuditMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"auditmode", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getAuditMode()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getBaseClsParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"baseclsparams", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getBaseClsParams()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getBizTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"biztag", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getBizTag()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getCodeNameMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codenamemode", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getCodeNameMode()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getColor() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"color", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getColor()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getCustomMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"custommode", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getCustomMode()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getDataAccMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dataaccmode", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getDataAccMode()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getDataChgLogMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"datachglogmode", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getDataChgLogMode()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getDataImpExpFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dataimpexpflag", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getDataImpExpFlag()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getDBTabSpace() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dbtabspace", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getDBTabSpace()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getDBVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dbver", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getDBVer()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getDECat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"decat", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getDECat()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getDEHolder() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deholder", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getDEHolder()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getDELockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"delockflag", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getDELockFlag()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getDESN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"desn", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getDESN()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getDETag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"detag", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getDETag()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getDETag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"detag2", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getDETag2()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getDEType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"detype", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getDEType()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getDSLink() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dslink", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getDSLink()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getDstPSDEActionLogicsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdeactionlogicscnt", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getDstPSDEActionLogicsCnt()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getDynamicMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamicmode", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getDynamicMode()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getDynaTableMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynatablemode", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getDynaTableMode()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getEnableAudit() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableaudit", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getEnableAudit()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getEnableDALog() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enabledalog", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getEnableDALog()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getEnableDataVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enabledataver", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getEnableDataVer()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getEnableDEAction() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enabledeaction", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getEnableDEAction()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getEnableDEDataSet() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablededataset", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getEnableDEDataSet()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getEnableDynaSys() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enabledynasys", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getEnableDynaSys()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getEnableEntityCache() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableentitycache", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getEnableEntityCache()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getEnableMob() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablemob", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getEnableMob()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getEnableMultiDS() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablemultids", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getEnableMultiDS()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getEnableOPNameModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableopnamemodel", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getEnableOPNameModel()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getEnableOrgModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableorgmodel", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getEnableOrgModel()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getEnablePQL() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablepql", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getEnablePQL()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getEnableSelect() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableselect", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getEnableSelect()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getEnableWFModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablewfmodel", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getEnableWFModel()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getEnaMultiForm() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enamultiform", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getEnaMultiForm()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getEnaTempData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enatempdata", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getEnaTempData()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getEntityCacheTimeout() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"entitycachetimeout", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getEntityCacheTimeout()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getExistingModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"existingmodel", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getExistingModel()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getExTableName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"extablename", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getExTableName()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getIndexDEType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"indexdetype", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getIndexDEType()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getKeyRule() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"keyrule", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getKeyRule()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getLNPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lnpslanresid", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getLNPSLanResId()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getLNPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lnpslanresname", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getLNPSLanResName()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getLogicInvalidValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicinvalidvalue", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getLogicInvalidValue()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getLogicName()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getLogicValid() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicvalid", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getLogicValid()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getLogicValidValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicvalidvalue", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getLogicValidValue()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getMajorPSDERsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"majorpsderscnt", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getMajorPSDERsCnt()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getMaxEntityCacheCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxentitycachecnt", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getMaxEntityCacheCnt()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getMemo()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getMinorPSDERsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minorpsderscnt", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getMinorPSDERsCnt()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getModColor() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modcolor", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getModColor()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getModelImpExpFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelimpexpflag", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getModelImpExpFlag()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getModelState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelstate", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getModelState()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getModelVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelver", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getModelVer()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getMSActionLogicFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"msactionlogicflag", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getMSActionLogicFlag()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getNoViewMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"noviewmode", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getNoViewMode()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSACHandlersCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psachandlerscnt", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSACHandlersCnt()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSCodeListsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelistscnt", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSCodeListsCnt()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSDataEntityId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdataentityid", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSDataEntityId()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSDataEntityName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdataentityname", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSDataEntityName()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSDEACModesCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeacmodescnt", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSDEACModesCnt()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSDEActionLogicsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionlogicscnt", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSDEActionLogicsCnt()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSDEActionsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionscnt", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSDEActionsCnt()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSDEAWGrpsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeawgrpscnt", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSDEAWGrpsCnt()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSDEAWsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeawscnt", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSDEAWsCnt()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSDEChartsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdechartscnt", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSDEChartsCnt()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSDEDataExpsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedataexpscnt", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSDEDataExpsCnt()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSDEDataImpsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedataimpscnt", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSDEDataImpsCnt()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSDEDataQuerysCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedataqueryscnt", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSDEDataQuerysCnt()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSDEDataRelationsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedatarelationscnt", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSDEDataRelationsCnt()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSDEDataSetsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedatasetscnt", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSDEDataSetsCnt()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSDEDataSyncsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedatasyncscnt", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSDEDataSyncsCnt()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSDEDataViewsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedataviewscnt", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSDEDataViewsCnt()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSDEDBCfgsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedbcfgscnt", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSDEDBCfgsCnt()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSDEDBIndexsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedbindexscnt", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSDEDBIndexsCnt()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSDEDRGroupsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedrgroupscnt", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSDEDRGroupsCnt()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSDEDRItemsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedritemscnt", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSDEDRItemsCnt()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSDEDTSQueuesCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedtsqueuescnt", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSDEDTSQueuesCnt()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSDEFieldsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefieldscnt", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSDEFieldsCnt()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSDEFInputTipSetId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefinputtipsetid", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSDEFInputTipSetId()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSDEFInputTipSetName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefinputtipsetname", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSDEFInputTipSetName()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSDEFormsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformscnt", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSDEFormsCnt()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSDEFSFItemsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefsfitemscnt", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSDEFSFItemsCnt()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSDEFValueRulesCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefvaluerulescnt", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSDEFValueRulesCnt()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSDEGridsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdegridscnt", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSDEGridsCnt()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSDEListsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelistscnt", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSDEListsCnt()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSDELogicsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicscnt", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSDELogicsCnt()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSDEMainStatesCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdemainstatescnt", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSDEMainStatesCnt()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSDEOPPrivRolesCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeopprivrolescnt", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSDEOPPrivRolesCnt()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSDEOPPrivsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeopprivscnt", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSDEOPPrivsCnt()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSDEPrintsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeprintscnt", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSDEPrintsCnt()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSDEReportsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdereportscnt", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSDEReportsCnt()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSDEServiceAPIsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeserviceapiscnt", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSDEServiceAPIsCnt()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSDEToolbarsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetoolbarscnt", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSDEToolbarsCnt()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSDETreeViewsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetreeviewscnt", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSDETreeViewsCnt()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSDEUAGroupsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuagroupscnt", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSDEUAGroupsCnt()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSDEUIActionsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionscnt", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSDEUIActionsCnt()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSDEUserRolesCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuserrolescnt", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSDEUserRolesCnt()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSDEViewBasesCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbasescnt", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSDEViewBasesCnt()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSDEWizardsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdewizardscnt", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSDEWizardsCnt()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSDynaDETemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynadetemplid", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSDynaDETemplId()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSDynaDETemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynadetemplname", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSDynaDETemplName()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSHelpModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pshelpmoduleid", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSHelpModuleId()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSHelpModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pshelpmodulename", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSHelpModuleName()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSSubSysSADEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsyssadeid", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSSubSysSADEId()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSSubSysSADEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsyssadename", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSSubSysSADEName()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSSubSysServiceAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysserviceapiid", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSSubSysServiceAPIId()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSSubSysServiceAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysserviceapiname", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSSubSysServiceAPIName()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSSysBDTablesCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbdtablescnt", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSSysBDTablesCnt()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSSysCountersCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscounterscnt", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSSysCountersCnt()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSSysDMItemsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdmitemscnt", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSSysDMItemsCnt()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSSysImageId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimageid", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSSysImageId()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSSysImageName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimagename", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSSysImageName()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSSysModelChgLogsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelchglogscnt", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSSysModelChgLogsCnt()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSSysModelGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelgroupid", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSSysModelGroupId()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSSysModelGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelgroupname", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSSysModelGroupName()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSSysReqItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemid", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSSysReqItemId()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSSysReqItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemname", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSSysReqItemName()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSSysTasksCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystaskscnt", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSSysTasksCnt()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSSysTestCasesCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystestcasescnt", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSSysTestCasesCnt()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSSysTestDatasCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystestdatascnt", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSSysTestDatasCnt()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSSysUniResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuniresid", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSSysUniResId()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSSysUniResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuniresname", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSSysUniResName()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getPSWFDEsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfdescnt", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getPSWFDEsCnt()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getReadOnlyMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"readonlymode", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getReadOnlyMode()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getRemoveFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"removeflag", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getRemoveFlag()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getSaaSMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"saasmode", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getSaaSMode()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getServiceAPIFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"serviceapiflag", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getServiceAPIFlag()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getServiceCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"servicecodename", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getServiceCodeName()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getSrcPSDEMapsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcpsdemapscnt", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getSrcPSDEMapsCnt()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getStorageMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"storagemode", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getStorageMode()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getSubSysDE() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"subsysde", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getSubSysDE()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getSubSysModule() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"subsysmodule", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getSubSysModule()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getSvrPubMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"svrpubmode", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getSvrPubMode()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getSystemFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"systemflag", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getSystemFlag()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getTableName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tablename", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getTableName()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getTestCaseFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"testcaseflag", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getTestCaseFlag()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getToDoTask() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"todotask", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getToDoTask()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getUserAction() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"useraction", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getUserAction()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getUserParams()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getViewLevel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewlevel", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getViewLevel()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewname", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getViewName()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getViewName2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewname2", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getViewName2()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getViewName3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewname3", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getViewName3()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getViewName4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewname4", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getViewName4()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getVirtualFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"virtualflag", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getVirtualFlag()), (boolean)false);
        }
        if (bl || pSDataEntityBase.getVKeySeparator() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"vkeyseparator", (Object)PSDataEntityBase.getJSONValue((Object)pSDataEntityBase.getVKeySeparator()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDataEntityBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDataEntityBase pSDataEntityBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDataEntityBase.getAccCtrlArch() != null) {
            object = pSDataEntityBase.getAccCtrlArch();
            xmlNode.setAttribute(FIELD_ACCCTRLARCH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getAuditMode() != null) {
            object = pSDataEntityBase.getAuditMode();
            xmlNode.setAttribute(FIELD_AUDITMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getBaseClsParams() != null) {
            object = pSDataEntityBase.getBaseClsParams();
            xmlNode.setAttribute(FIELD_BASECLSPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getBizTag() != null) {
            object = pSDataEntityBase.getBizTag();
            xmlNode.setAttribute(FIELD_BIZTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getCodeName() != null) {
            object = pSDataEntityBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getCodeNameMode() != null) {
            object = pSDataEntityBase.getCodeNameMode();
            xmlNode.setAttribute(FIELD_CODENAMEMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getColor() != null) {
            object = pSDataEntityBase.getColor();
            xmlNode.setAttribute(FIELD_COLOR, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getCreateDate() != null) {
            object = pSDataEntityBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDataEntityBase.getCreateMan() != null) {
            object = pSDataEntityBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getCustomCode() != null) {
            object = pSDataEntityBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getCustomMode() != null) {
            object = pSDataEntityBase.getCustomMode();
            xmlNode.setAttribute(FIELD_CUSTOMMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getDataAccMode() != null) {
            object = pSDataEntityBase.getDataAccMode();
            xmlNode.setAttribute(FIELD_DATAACCMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getDataChgLogMode() != null) {
            object = pSDataEntityBase.getDataChgLogMode();
            xmlNode.setAttribute(FIELD_DATACHGLOGMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getDataImpExpFlag() != null) {
            object = pSDataEntityBase.getDataImpExpFlag();
            xmlNode.setAttribute(FIELD_DATAIMPEXPFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getDBTabSpace() != null) {
            object = pSDataEntityBase.getDBTabSpace();
            xmlNode.setAttribute(FIELD_DBTABSPACE, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getDBVer() != null) {
            object = pSDataEntityBase.getDBVer();
            xmlNode.setAttribute(FIELD_DBVER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getDECat() != null) {
            object = pSDataEntityBase.getDECat();
            xmlNode.setAttribute(FIELD_DECAT, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getDEHolder() != null) {
            object = pSDataEntityBase.getDEHolder();
            xmlNode.setAttribute(FIELD_DEHOLDER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getDELockFlag() != null) {
            object = pSDataEntityBase.getDELockFlag();
            xmlNode.setAttribute(FIELD_DELOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getDESN() != null) {
            object = pSDataEntityBase.getDESN();
            xmlNode.setAttribute(FIELD_DESN, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getDETag() != null) {
            object = pSDataEntityBase.getDETag();
            xmlNode.setAttribute(FIELD_DETAG, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getDETag2() != null) {
            object = pSDataEntityBase.getDETag2();
            xmlNode.setAttribute(FIELD_DETAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getDEType() != null) {
            object = pSDataEntityBase.getDEType();
            xmlNode.setAttribute(FIELD_DETYPE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getDSLink() != null) {
            object = pSDataEntityBase.getDSLink();
            xmlNode.setAttribute(FIELD_DSLINK, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getDstPSDEActionLogicsCnt() != null) {
            object = pSDataEntityBase.getDstPSDEActionLogicsCnt();
            xmlNode.setAttribute(FIELD_DSTPSDEACTIONLOGICSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getDynamicMode() != null) {
            object = pSDataEntityBase.getDynamicMode();
            xmlNode.setAttribute(FIELD_DYNAMICMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getDynaModelFlag() != null) {
            object = pSDataEntityBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getDynaTableMode() != null) {
            object = pSDataEntityBase.getDynaTableMode();
            xmlNode.setAttribute(FIELD_DYNATABLEMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getEnableAudit() != null) {
            object = pSDataEntityBase.getEnableAudit();
            xmlNode.setAttribute(FIELD_ENABLEAUDIT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getEnableDALog() != null) {
            object = pSDataEntityBase.getEnableDALog();
            xmlNode.setAttribute(FIELD_ENABLEDALOG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getEnableDataVer() != null) {
            object = pSDataEntityBase.getEnableDataVer();
            xmlNode.setAttribute(FIELD_ENABLEDATAVER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getEnableDEAction() != null) {
            object = pSDataEntityBase.getEnableDEAction();
            xmlNode.setAttribute(FIELD_ENABLEDEACTION, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getEnableDEDataSet() != null) {
            object = pSDataEntityBase.getEnableDEDataSet();
            xmlNode.setAttribute(FIELD_ENABLEDEDATASET, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getEnableDynaSys() != null) {
            object = pSDataEntityBase.getEnableDynaSys();
            xmlNode.setAttribute(FIELD_ENABLEDYNASYS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getEnableEntityCache() != null) {
            object = pSDataEntityBase.getEnableEntityCache();
            xmlNode.setAttribute(FIELD_ENABLEENTITYCACHE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getEnableMob() != null) {
            object = pSDataEntityBase.getEnableMob();
            xmlNode.setAttribute(FIELD_ENABLEMOB, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getEnableMultiDS() != null) {
            object = pSDataEntityBase.getEnableMultiDS();
            xmlNode.setAttribute(FIELD_ENABLEMULTIDS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getEnableOPNameModel() != null) {
            object = pSDataEntityBase.getEnableOPNameModel();
            xmlNode.setAttribute(FIELD_ENABLEOPNAMEMODEL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getEnableOrgModel() != null) {
            object = pSDataEntityBase.getEnableOrgModel();
            xmlNode.setAttribute(FIELD_ENABLEORGMODEL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getEnablePQL() != null) {
            object = pSDataEntityBase.getEnablePQL();
            xmlNode.setAttribute(FIELD_ENABLEPQL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getEnableSelect() != null) {
            object = pSDataEntityBase.getEnableSelect();
            xmlNode.setAttribute(FIELD_ENABLESELECT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getEnableWFModel() != null) {
            object = pSDataEntityBase.getEnableWFModel();
            xmlNode.setAttribute(FIELD_ENABLEWFMODEL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getEnaMultiForm() != null) {
            object = pSDataEntityBase.getEnaMultiForm();
            xmlNode.setAttribute(FIELD_ENAMULTIFORM, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getEnaTempData() != null) {
            object = pSDataEntityBase.getEnaTempData();
            xmlNode.setAttribute(FIELD_ENATEMPDATA, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getEntityCacheTimeout() != null) {
            object = pSDataEntityBase.getEntityCacheTimeout();
            xmlNode.setAttribute(FIELD_ENTITYCACHETIMEOUT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getExistingModel() != null) {
            object = pSDataEntityBase.getExistingModel();
            xmlNode.setAttribute(FIELD_EXISTINGMODEL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getExTableName() != null) {
            object = pSDataEntityBase.getExTableName();
            xmlNode.setAttribute(FIELD_EXTABLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getIndexDEType() != null) {
            object = pSDataEntityBase.getIndexDEType();
            xmlNode.setAttribute(FIELD_INDEXDETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getKeyRule() != null) {
            object = pSDataEntityBase.getKeyRule();
            xmlNode.setAttribute(FIELD_KEYRULE, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getLNPSLanResId() != null) {
            object = pSDataEntityBase.getLNPSLanResId();
            xmlNode.setAttribute(FIELD_LNPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getLNPSLanResName() != null) {
            object = pSDataEntityBase.getLNPSLanResName();
            xmlNode.setAttribute(FIELD_LNPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getLockFlag() != null) {
            object = pSDataEntityBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getLogicInvalidValue() != null) {
            object = pSDataEntityBase.getLogicInvalidValue();
            xmlNode.setAttribute(FIELD_LOGICINVALIDVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getLogicName() != null) {
            object = pSDataEntityBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getLogicValid() != null) {
            object = pSDataEntityBase.getLogicValid();
            xmlNode.setAttribute(FIELD_LOGICVALID, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getLogicValidValue() != null) {
            object = pSDataEntityBase.getLogicValidValue();
            xmlNode.setAttribute(FIELD_LOGICVALIDVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getMajorPSDERsCnt() != null) {
            object = pSDataEntityBase.getMajorPSDERsCnt();
            xmlNode.setAttribute(FIELD_MAJORPSDERSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getMaxEntityCacheCnt() != null) {
            object = pSDataEntityBase.getMaxEntityCacheCnt();
            xmlNode.setAttribute(FIELD_MAXENTITYCACHECNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getMemo() != null) {
            object = pSDataEntityBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getMinorPSDERsCnt() != null) {
            object = pSDataEntityBase.getMinorPSDERsCnt();
            xmlNode.setAttribute(FIELD_MINORPSDERSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getModColor() != null) {
            object = pSDataEntityBase.getModColor();
            xmlNode.setAttribute(FIELD_MODCOLOR, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getModelImpExpFlag() != null) {
            object = pSDataEntityBase.getModelImpExpFlag();
            xmlNode.setAttribute(FIELD_MODELIMPEXPFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getModelState() != null) {
            object = pSDataEntityBase.getModelState();
            xmlNode.setAttribute(FIELD_MODELSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getModelVer() != null) {
            object = pSDataEntityBase.getModelVer();
            xmlNode.setAttribute(FIELD_MODELVER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getMSActionLogicFlag() != null) {
            object = pSDataEntityBase.getMSActionLogicFlag();
            xmlNode.setAttribute(FIELD_MSACTIONLOGICFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getNoViewMode() != null) {
            object = pSDataEntityBase.getNoViewMode();
            xmlNode.setAttribute(FIELD_NOVIEWMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getOrderValue() != null) {
            object = pSDataEntityBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getPSACHandlersCnt() != null) {
            object = pSDataEntityBase.getPSACHandlersCnt();
            xmlNode.setAttribute(FIELD_PSACHANDLERSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getPSCodeListsCnt() != null) {
            object = pSDataEntityBase.getPSCodeListsCnt();
            xmlNode.setAttribute(FIELD_PSCODELISTSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getPSDataEntityId() != null) {
            object = pSDataEntityBase.getPSDataEntityId();
            xmlNode.setAttribute(FIELD_PSDATAENTITYID, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getPSDataEntityName() != null) {
            object = pSDataEntityBase.getPSDataEntityName();
            xmlNode.setAttribute(FIELD_PSDATAENTITYNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getPSDEACModesCnt() != null) {
            object = pSDataEntityBase.getPSDEACModesCnt();
            xmlNode.setAttribute(FIELD_PSDEACMODESCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getPSDEActionLogicsCnt() != null) {
            object = pSDataEntityBase.getPSDEActionLogicsCnt();
            xmlNode.setAttribute(FIELD_PSDEACTIONLOGICSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getPSDEActionsCnt() != null) {
            object = pSDataEntityBase.getPSDEActionsCnt();
            xmlNode.setAttribute(FIELD_PSDEACTIONSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getPSDEAWGrpsCnt() != null) {
            object = pSDataEntityBase.getPSDEAWGrpsCnt();
            xmlNode.setAttribute(FIELD_PSDEAWGRPSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getPSDEAWsCnt() != null) {
            object = pSDataEntityBase.getPSDEAWsCnt();
            xmlNode.setAttribute(FIELD_PSDEAWSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getPSDEChartsCnt() != null) {
            object = pSDataEntityBase.getPSDEChartsCnt();
            xmlNode.setAttribute(FIELD_PSDECHARTSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getPSDEDataExpsCnt() != null) {
            object = pSDataEntityBase.getPSDEDataExpsCnt();
            xmlNode.setAttribute(FIELD_PSDEDATAEXPSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getPSDEDataImpsCnt() != null) {
            object = pSDataEntityBase.getPSDEDataImpsCnt();
            xmlNode.setAttribute(FIELD_PSDEDATAIMPSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getPSDEDataQuerysCnt() != null) {
            object = pSDataEntityBase.getPSDEDataQuerysCnt();
            xmlNode.setAttribute(FIELD_PSDEDATAQUERYSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getPSDEDataRelationsCnt() != null) {
            object = pSDataEntityBase.getPSDEDataRelationsCnt();
            xmlNode.setAttribute(FIELD_PSDEDATARELATIONSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getPSDEDataSetsCnt() != null) {
            object = pSDataEntityBase.getPSDEDataSetsCnt();
            xmlNode.setAttribute(FIELD_PSDEDATASETSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getPSDEDataSyncsCnt() != null) {
            object = pSDataEntityBase.getPSDEDataSyncsCnt();
            xmlNode.setAttribute(FIELD_PSDEDATASYNCSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getPSDEDataViewsCnt() != null) {
            object = pSDataEntityBase.getPSDEDataViewsCnt();
            xmlNode.setAttribute(FIELD_PSDEDATAVIEWSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getPSDEDBCfgsCnt() != null) {
            object = pSDataEntityBase.getPSDEDBCfgsCnt();
            xmlNode.setAttribute(FIELD_PSDEDBCFGSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getPSDEDBIndexsCnt() != null) {
            object = pSDataEntityBase.getPSDEDBIndexsCnt();
            xmlNode.setAttribute(FIELD_PSDEDBINDEXSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getPSDEDRGroupsCnt() != null) {
            object = pSDataEntityBase.getPSDEDRGroupsCnt();
            xmlNode.setAttribute(FIELD_PSDEDRGROUPSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getPSDEDRItemsCnt() != null) {
            object = pSDataEntityBase.getPSDEDRItemsCnt();
            xmlNode.setAttribute(FIELD_PSDEDRITEMSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getPSDEDTSQueuesCnt() != null) {
            object = pSDataEntityBase.getPSDEDTSQueuesCnt();
            xmlNode.setAttribute(FIELD_PSDEDTSQUEUESCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getPSDEFieldsCnt() != null) {
            object = pSDataEntityBase.getPSDEFieldsCnt();
            xmlNode.setAttribute(FIELD_PSDEFIELDSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getPSDEFInputTipSetId() != null) {
            object = pSDataEntityBase.getPSDEFInputTipSetId();
            xmlNode.setAttribute(FIELD_PSDEFINPUTTIPSETID, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getPSDEFInputTipSetName() != null) {
            object = pSDataEntityBase.getPSDEFInputTipSetName();
            xmlNode.setAttribute(FIELD_PSDEFINPUTTIPSETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getPSDEFormsCnt() != null) {
            object = pSDataEntityBase.getPSDEFormsCnt();
            xmlNode.setAttribute(FIELD_PSDEFORMSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getPSDEFSFItemsCnt() != null) {
            object = pSDataEntityBase.getPSDEFSFItemsCnt();
            xmlNode.setAttribute(FIELD_PSDEFSFITEMSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getPSDEFValueRulesCnt() != null) {
            object = pSDataEntityBase.getPSDEFValueRulesCnt();
            xmlNode.setAttribute(FIELD_PSDEFVALUERULESCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getPSDEGridsCnt() != null) {
            object = pSDataEntityBase.getPSDEGridsCnt();
            xmlNode.setAttribute(FIELD_PSDEGRIDSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getPSDEListsCnt() != null) {
            object = pSDataEntityBase.getPSDEListsCnt();
            xmlNode.setAttribute(FIELD_PSDELISTSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getPSDELogicsCnt() != null) {
            object = pSDataEntityBase.getPSDELogicsCnt();
            xmlNode.setAttribute(FIELD_PSDELOGICSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getPSDEMainStatesCnt() != null) {
            object = pSDataEntityBase.getPSDEMainStatesCnt();
            xmlNode.setAttribute(FIELD_PSDEMAINSTATESCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getPSDEOPPrivRolesCnt() != null) {
            object = pSDataEntityBase.getPSDEOPPrivRolesCnt();
            xmlNode.setAttribute(FIELD_PSDEOPPRIVROLESCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getPSDEOPPrivsCnt() != null) {
            object = pSDataEntityBase.getPSDEOPPrivsCnt();
            xmlNode.setAttribute(FIELD_PSDEOPPRIVSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getPSDEPrintsCnt() != null) {
            object = pSDataEntityBase.getPSDEPrintsCnt();
            xmlNode.setAttribute(FIELD_PSDEPRINTSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getPSDEReportsCnt() != null) {
            object = pSDataEntityBase.getPSDEReportsCnt();
            xmlNode.setAttribute(FIELD_PSDEREPORTSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getPSDEServiceAPIsCnt() != null) {
            object = pSDataEntityBase.getPSDEServiceAPIsCnt();
            xmlNode.setAttribute(FIELD_PSDESERVICEAPISCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getPSDEToolbarsCnt() != null) {
            object = pSDataEntityBase.getPSDEToolbarsCnt();
            xmlNode.setAttribute(FIELD_PSDETOOLBARSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getPSDETreeViewsCnt() != null) {
            object = pSDataEntityBase.getPSDETreeViewsCnt();
            xmlNode.setAttribute(FIELD_PSDETREEVIEWSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getPSDEUAGroupsCnt() != null) {
            object = pSDataEntityBase.getPSDEUAGroupsCnt();
            xmlNode.setAttribute(FIELD_PSDEUAGROUPSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getPSDEUIActionsCnt() != null) {
            object = pSDataEntityBase.getPSDEUIActionsCnt();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getPSDEUserRolesCnt() != null) {
            object = pSDataEntityBase.getPSDEUserRolesCnt();
            xmlNode.setAttribute(FIELD_PSDEUSERROLESCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getPSDEViewBasesCnt() != null) {
            object = pSDataEntityBase.getPSDEViewBasesCnt();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASESCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getPSDEWizardsCnt() != null) {
            object = pSDataEntityBase.getPSDEWizardsCnt();
            xmlNode.setAttribute(FIELD_PSDEWIZARDSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getPSDynaDETemplId() != null) {
            object = pSDataEntityBase.getPSDynaDETemplId();
            xmlNode.setAttribute(FIELD_PSDYNADETEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getPSDynaDETemplName() != null) {
            object = pSDataEntityBase.getPSDynaDETemplName();
            xmlNode.setAttribute(FIELD_PSDYNADETEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getPSDynaInstId() != null) {
            object = pSDataEntityBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getPSHelpModuleId() != null) {
            object = pSDataEntityBase.getPSHelpModuleId();
            xmlNode.setAttribute(FIELD_PSHELPMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getPSHelpModuleName() != null) {
            object = pSDataEntityBase.getPSHelpModuleName();
            xmlNode.setAttribute(FIELD_PSHELPMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getPSModuleId() != null) {
            object = pSDataEntityBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getPSModuleName() != null) {
            object = pSDataEntityBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getPSSubSysSADEId() != null) {
            object = pSDataEntityBase.getPSSubSysSADEId();
            xmlNode.setAttribute(FIELD_PSSUBSYSSADEID, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getPSSubSysSADEName() != null) {
            object = pSDataEntityBase.getPSSubSysSADEName();
            xmlNode.setAttribute(FIELD_PSSUBSYSSADENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getPSSubSysServiceAPIId() != null) {
            object = pSDataEntityBase.getPSSubSysServiceAPIId();
            xmlNode.setAttribute(FIELD_PSSUBSYSSERVICEAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getPSSubSysServiceAPIName() != null) {
            object = pSDataEntityBase.getPSSubSysServiceAPIName();
            xmlNode.setAttribute(FIELD_PSSUBSYSSERVICEAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getPSSysBDTablesCnt() != null) {
            object = pSDataEntityBase.getPSSysBDTablesCnt();
            xmlNode.setAttribute(FIELD_PSSYSBDTABLESCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getPSSysCountersCnt() != null) {
            object = pSDataEntityBase.getPSSysCountersCnt();
            xmlNode.setAttribute(FIELD_PSSYSCOUNTERSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getPSSysDMItemsCnt() != null) {
            object = pSDataEntityBase.getPSSysDMItemsCnt();
            xmlNode.setAttribute(FIELD_PSSYSDMITEMSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getPSSysDynaModelId() != null) {
            object = pSDataEntityBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getPSSysDynaModelName() != null) {
            object = pSDataEntityBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getPSSysImageId() != null) {
            object = pSDataEntityBase.getPSSysImageId();
            xmlNode.setAttribute(FIELD_PSSYSIMAGEID, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getPSSysImageName() != null) {
            object = pSDataEntityBase.getPSSysImageName();
            xmlNode.setAttribute(FIELD_PSSYSIMAGENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getPSSysModelChgLogsCnt() != null) {
            object = pSDataEntityBase.getPSSysModelChgLogsCnt();
            xmlNode.setAttribute(FIELD_PSSYSMODELCHGLOGSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getPSSysModelGroupId() != null) {
            object = pSDataEntityBase.getPSSysModelGroupId();
            xmlNode.setAttribute(FIELD_PSSYSMODELGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getPSSysModelGroupName() != null) {
            object = pSDataEntityBase.getPSSysModelGroupName();
            xmlNode.setAttribute(FIELD_PSSYSMODELGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getPSSysReqItemId() != null) {
            object = pSDataEntityBase.getPSSysReqItemId();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getPSSysReqItemName() != null) {
            object = pSDataEntityBase.getPSSysReqItemName();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getPSSysSFPluginId() != null) {
            object = pSDataEntityBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getPSSysSFPluginName() != null) {
            object = pSDataEntityBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getPSSysTasksCnt() != null) {
            object = pSDataEntityBase.getPSSysTasksCnt();
            xmlNode.setAttribute(FIELD_PSSYSTASKSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getPSSystemId() != null) {
            object = pSDataEntityBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getPSSystemName() != null) {
            object = pSDataEntityBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getPSSysTestCasesCnt() != null) {
            object = pSDataEntityBase.getPSSysTestCasesCnt();
            xmlNode.setAttribute(FIELD_PSSYSTESTCASESCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getPSSysTestDatasCnt() != null) {
            object = pSDataEntityBase.getPSSysTestDatasCnt();
            xmlNode.setAttribute(FIELD_PSSYSTESTDATASCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getPSSysUniResId() != null) {
            object = pSDataEntityBase.getPSSysUniResId();
            xmlNode.setAttribute(FIELD_PSSYSUNIRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getPSSysUniResName() != null) {
            object = pSDataEntityBase.getPSSysUniResName();
            xmlNode.setAttribute(FIELD_PSSYSUNIRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getPSWFDEsCnt() != null) {
            object = pSDataEntityBase.getPSWFDEsCnt();
            xmlNode.setAttribute(FIELD_PSWFDESCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getReadOnlyMode() != null) {
            object = pSDataEntityBase.getReadOnlyMode();
            xmlNode.setAttribute(FIELD_READONLYMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getRemoveFlag() != null) {
            object = pSDataEntityBase.getRemoveFlag();
            xmlNode.setAttribute(FIELD_REMOVEFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getSaaSMode() != null) {
            object = pSDataEntityBase.getSaaSMode();
            xmlNode.setAttribute(FIELD_SAASMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getServiceAPIFlag() != null) {
            object = pSDataEntityBase.getServiceAPIFlag();
            xmlNode.setAttribute(FIELD_SERVICEAPIFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getServiceCodeName() != null) {
            object = pSDataEntityBase.getServiceCodeName();
            xmlNode.setAttribute(FIELD_SERVICECODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getSrcPSDEMapsCnt() != null) {
            object = pSDataEntityBase.getSrcPSDEMapsCnt();
            xmlNode.setAttribute(FIELD_SRCPSDEMAPSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getStorageMode() != null) {
            object = pSDataEntityBase.getStorageMode();
            xmlNode.setAttribute(FIELD_STORAGEMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getSubSysDE() != null) {
            object = pSDataEntityBase.getSubSysDE();
            xmlNode.setAttribute(FIELD_SUBSYSDE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getSubSysModule() != null) {
            object = pSDataEntityBase.getSubSysModule();
            xmlNode.setAttribute(FIELD_SUBSYSMODULE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getSvrPubMode() != null) {
            object = pSDataEntityBase.getSvrPubMode();
            xmlNode.setAttribute(FIELD_SVRPUBMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getSystemFlag() != null) {
            object = pSDataEntityBase.getSystemFlag();
            xmlNode.setAttribute(FIELD_SYSTEMFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getTableName() != null) {
            object = pSDataEntityBase.getTableName();
            xmlNode.setAttribute(FIELD_TABLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getTestCaseFlag() != null) {
            object = pSDataEntityBase.getTestCaseFlag();
            xmlNode.setAttribute(FIELD_TESTCASEFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getToDoTask() != null) {
            object = pSDataEntityBase.getToDoTask();
            xmlNode.setAttribute(FIELD_TODOTASK, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getUpdateDate() != null) {
            object = pSDataEntityBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDataEntityBase.getUpdateMan() != null) {
            object = pSDataEntityBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getUserAction() != null) {
            object = pSDataEntityBase.getUserAction();
            xmlNode.setAttribute(FIELD_USERACTION, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getUserCat() != null) {
            object = pSDataEntityBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getUserParams() != null) {
            object = pSDataEntityBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getUserTag() != null) {
            object = pSDataEntityBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getUserTag2() != null) {
            object = pSDataEntityBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getUserTag3() != null) {
            object = pSDataEntityBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getUserTag4() != null) {
            object = pSDataEntityBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getValidFlag() != null) {
            object = pSDataEntityBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getViewLevel() != null) {
            object = pSDataEntityBase.getViewLevel();
            xmlNode.setAttribute(FIELD_VIEWLEVEL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getViewName() != null) {
            object = pSDataEntityBase.getViewName();
            xmlNode.setAttribute(FIELD_VIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getViewName2() != null) {
            object = pSDataEntityBase.getViewName2();
            xmlNode.setAttribute(FIELD_VIEWNAME2, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getViewName3() != null) {
            object = pSDataEntityBase.getViewName3();
            xmlNode.setAttribute(FIELD_VIEWNAME3, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getViewName4() != null) {
            object = pSDataEntityBase.getViewName4();
            xmlNode.setAttribute(FIELD_VIEWNAME4, object == null ? "" : (String)object);
        }
        if (bl || pSDataEntityBase.getVirtualFlag() != null) {
            object = pSDataEntityBase.getVirtualFlag();
            xmlNode.setAttribute(FIELD_VIRTUALFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataEntityBase.getVKeySeparator() != null) {
            object = pSDataEntityBase.getVKeySeparator();
            xmlNode.setAttribute(FIELD_VKEYSEPARATOR, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDataEntityBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDataEntityBase pSDataEntityBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDataEntityBase.isAccCtrlArchDirty() && (bl || pSDataEntityBase.getAccCtrlArch() != null)) {
            iDataObject.set(FIELD_ACCCTRLARCH, (Object)pSDataEntityBase.getAccCtrlArch());
        }
        if (pSDataEntityBase.isAuditModeDirty() && (bl || pSDataEntityBase.getAuditMode() != null)) {
            iDataObject.set(FIELD_AUDITMODE, (Object)pSDataEntityBase.getAuditMode());
        }
        if (pSDataEntityBase.isBaseClsParamsDirty() && (bl || pSDataEntityBase.getBaseClsParams() != null)) {
            iDataObject.set(FIELD_BASECLSPARAMS, (Object)pSDataEntityBase.getBaseClsParams());
        }
        if (pSDataEntityBase.isBizTagDirty() && (bl || pSDataEntityBase.getBizTag() != null)) {
            iDataObject.set(FIELD_BIZTAG, (Object)pSDataEntityBase.getBizTag());
        }
        if (pSDataEntityBase.isCodeNameDirty() && (bl || pSDataEntityBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDataEntityBase.getCodeName());
        }
        if (pSDataEntityBase.isCodeNameModeDirty() && (bl || pSDataEntityBase.getCodeNameMode() != null)) {
            iDataObject.set(FIELD_CODENAMEMODE, (Object)pSDataEntityBase.getCodeNameMode());
        }
        if (pSDataEntityBase.isColorDirty() && (bl || pSDataEntityBase.getColor() != null)) {
            iDataObject.set(FIELD_COLOR, (Object)pSDataEntityBase.getColor());
        }
        if (pSDataEntityBase.isCreateDateDirty() && (bl || pSDataEntityBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDataEntityBase.getCreateDate());
        }
        if (pSDataEntityBase.isCreateManDirty() && (bl || pSDataEntityBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDataEntityBase.getCreateMan());
        }
        if (pSDataEntityBase.isCustomCodeDirty() && (bl || pSDataEntityBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSDataEntityBase.getCustomCode());
        }
        if (pSDataEntityBase.isCustomModeDirty() && (bl || pSDataEntityBase.getCustomMode() != null)) {
            iDataObject.set(FIELD_CUSTOMMODE, (Object)pSDataEntityBase.getCustomMode());
        }
        if (pSDataEntityBase.isDataAccModeDirty() && (bl || pSDataEntityBase.getDataAccMode() != null)) {
            iDataObject.set(FIELD_DATAACCMODE, (Object)pSDataEntityBase.getDataAccMode());
        }
        if (pSDataEntityBase.isDataChgLogModeDirty() && (bl || pSDataEntityBase.getDataChgLogMode() != null)) {
            iDataObject.set(FIELD_DATACHGLOGMODE, (Object)pSDataEntityBase.getDataChgLogMode());
        }
        if (pSDataEntityBase.isDataImpExpFlagDirty() && (bl || pSDataEntityBase.getDataImpExpFlag() != null)) {
            iDataObject.set(FIELD_DATAIMPEXPFLAG, (Object)pSDataEntityBase.getDataImpExpFlag());
        }
        if (pSDataEntityBase.isDBTabSpaceDirty() && (bl || pSDataEntityBase.getDBTabSpace() != null)) {
            iDataObject.set(FIELD_DBTABSPACE, (Object)pSDataEntityBase.getDBTabSpace());
        }
        if (pSDataEntityBase.isDBVerDirty() && (bl || pSDataEntityBase.getDBVer() != null)) {
            iDataObject.set(FIELD_DBVER, (Object)pSDataEntityBase.getDBVer());
        }
        if (pSDataEntityBase.isDECatDirty() && (bl || pSDataEntityBase.getDECat() != null)) {
            iDataObject.set(FIELD_DECAT, (Object)pSDataEntityBase.getDECat());
        }
        if (pSDataEntityBase.isDEHolderDirty() && (bl || pSDataEntityBase.getDEHolder() != null)) {
            iDataObject.set(FIELD_DEHOLDER, (Object)pSDataEntityBase.getDEHolder());
        }
        if (pSDataEntityBase.isDELockFlagDirty() && (bl || pSDataEntityBase.getDELockFlag() != null)) {
            iDataObject.set(FIELD_DELOCKFLAG, (Object)pSDataEntityBase.getDELockFlag());
        }
        if (pSDataEntityBase.isDESNDirty() && (bl || pSDataEntityBase.getDESN() != null)) {
            iDataObject.set(FIELD_DESN, (Object)pSDataEntityBase.getDESN());
        }
        if (pSDataEntityBase.isDETagDirty() && (bl || pSDataEntityBase.getDETag() != null)) {
            iDataObject.set(FIELD_DETAG, (Object)pSDataEntityBase.getDETag());
        }
        if (pSDataEntityBase.isDETag2Dirty() && (bl || pSDataEntityBase.getDETag2() != null)) {
            iDataObject.set(FIELD_DETAG2, (Object)pSDataEntityBase.getDETag2());
        }
        if (pSDataEntityBase.isDETypeDirty() && (bl || pSDataEntityBase.getDEType() != null)) {
            iDataObject.set(FIELD_DETYPE, (Object)pSDataEntityBase.getDEType());
        }
        if (pSDataEntityBase.isDSLinkDirty() && (bl || pSDataEntityBase.getDSLink() != null)) {
            iDataObject.set(FIELD_DSLINK, (Object)pSDataEntityBase.getDSLink());
        }
        if (pSDataEntityBase.isDstPSDEActionLogicsCntDirty() && (bl || pSDataEntityBase.getDstPSDEActionLogicsCnt() != null)) {
            iDataObject.set(FIELD_DSTPSDEACTIONLOGICSCNT, (Object)pSDataEntityBase.getDstPSDEActionLogicsCnt());
        }
        if (pSDataEntityBase.isDynamicModeDirty() && (bl || pSDataEntityBase.getDynamicMode() != null)) {
            iDataObject.set(FIELD_DYNAMICMODE, (Object)pSDataEntityBase.getDynamicMode());
        }
        if (pSDataEntityBase.isDynaModelFlagDirty() && (bl || pSDataEntityBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSDataEntityBase.getDynaModelFlag());
        }
        if (pSDataEntityBase.isDynaTableModeDirty() && (bl || pSDataEntityBase.getDynaTableMode() != null)) {
            iDataObject.set(FIELD_DYNATABLEMODE, (Object)pSDataEntityBase.getDynaTableMode());
        }
        if (pSDataEntityBase.isEnableAuditDirty() && (bl || pSDataEntityBase.getEnableAudit() != null)) {
            iDataObject.set(FIELD_ENABLEAUDIT, (Object)pSDataEntityBase.getEnableAudit());
        }
        if (pSDataEntityBase.isEnableDALogDirty() && (bl || pSDataEntityBase.getEnableDALog() != null)) {
            iDataObject.set(FIELD_ENABLEDALOG, (Object)pSDataEntityBase.getEnableDALog());
        }
        if (pSDataEntityBase.isEnableDataVerDirty() && (bl || pSDataEntityBase.getEnableDataVer() != null)) {
            iDataObject.set(FIELD_ENABLEDATAVER, (Object)pSDataEntityBase.getEnableDataVer());
        }
        if (pSDataEntityBase.isEnableDEActionDirty() && (bl || pSDataEntityBase.getEnableDEAction() != null)) {
            iDataObject.set(FIELD_ENABLEDEACTION, (Object)pSDataEntityBase.getEnableDEAction());
        }
        if (pSDataEntityBase.isEnableDEDataSetDirty() && (bl || pSDataEntityBase.getEnableDEDataSet() != null)) {
            iDataObject.set(FIELD_ENABLEDEDATASET, (Object)pSDataEntityBase.getEnableDEDataSet());
        }
        if (pSDataEntityBase.isEnableDynaSysDirty() && (bl || pSDataEntityBase.getEnableDynaSys() != null)) {
            iDataObject.set(FIELD_ENABLEDYNASYS, (Object)pSDataEntityBase.getEnableDynaSys());
        }
        if (pSDataEntityBase.isEnableEntityCacheDirty() && (bl || pSDataEntityBase.getEnableEntityCache() != null)) {
            iDataObject.set(FIELD_ENABLEENTITYCACHE, (Object)pSDataEntityBase.getEnableEntityCache());
        }
        if (pSDataEntityBase.isEnableMobDirty() && (bl || pSDataEntityBase.getEnableMob() != null)) {
            iDataObject.set(FIELD_ENABLEMOB, (Object)pSDataEntityBase.getEnableMob());
        }
        if (pSDataEntityBase.isEnableMultiDSDirty() && (bl || pSDataEntityBase.getEnableMultiDS() != null)) {
            iDataObject.set(FIELD_ENABLEMULTIDS, (Object)pSDataEntityBase.getEnableMultiDS());
        }
        if (pSDataEntityBase.isEnableOPNameModelDirty() && (bl || pSDataEntityBase.getEnableOPNameModel() != null)) {
            iDataObject.set(FIELD_ENABLEOPNAMEMODEL, (Object)pSDataEntityBase.getEnableOPNameModel());
        }
        if (pSDataEntityBase.isEnableOrgModelDirty() && (bl || pSDataEntityBase.getEnableOrgModel() != null)) {
            iDataObject.set(FIELD_ENABLEORGMODEL, (Object)pSDataEntityBase.getEnableOrgModel());
        }
        if (pSDataEntityBase.isEnablePQLDirty() && (bl || pSDataEntityBase.getEnablePQL() != null)) {
            iDataObject.set(FIELD_ENABLEPQL, (Object)pSDataEntityBase.getEnablePQL());
        }
        if (pSDataEntityBase.isEnableSelectDirty() && (bl || pSDataEntityBase.getEnableSelect() != null)) {
            iDataObject.set(FIELD_ENABLESELECT, (Object)pSDataEntityBase.getEnableSelect());
        }
        if (pSDataEntityBase.isEnableWFModelDirty() && (bl || pSDataEntityBase.getEnableWFModel() != null)) {
            iDataObject.set(FIELD_ENABLEWFMODEL, (Object)pSDataEntityBase.getEnableWFModel());
        }
        if (pSDataEntityBase.isEnaMultiFormDirty() && (bl || pSDataEntityBase.getEnaMultiForm() != null)) {
            iDataObject.set(FIELD_ENAMULTIFORM, (Object)pSDataEntityBase.getEnaMultiForm());
        }
        if (pSDataEntityBase.isEnaTempDataDirty() && (bl || pSDataEntityBase.getEnaTempData() != null)) {
            iDataObject.set(FIELD_ENATEMPDATA, (Object)pSDataEntityBase.getEnaTempData());
        }
        if (pSDataEntityBase.isEntityCacheTimeoutDirty() && (bl || pSDataEntityBase.getEntityCacheTimeout() != null)) {
            iDataObject.set(FIELD_ENTITYCACHETIMEOUT, (Object)pSDataEntityBase.getEntityCacheTimeout());
        }
        if (pSDataEntityBase.isExistingModelDirty() && (bl || pSDataEntityBase.getExistingModel() != null)) {
            iDataObject.set(FIELD_EXISTINGMODEL, (Object)pSDataEntityBase.getExistingModel());
        }
        if (pSDataEntityBase.isExTableNameDirty() && (bl || pSDataEntityBase.getExTableName() != null)) {
            iDataObject.set(FIELD_EXTABLENAME, (Object)pSDataEntityBase.getExTableName());
        }
        if (pSDataEntityBase.isIndexDETypeDirty() && (bl || pSDataEntityBase.getIndexDEType() != null)) {
            iDataObject.set(FIELD_INDEXDETYPE, (Object)pSDataEntityBase.getIndexDEType());
        }
        if (pSDataEntityBase.isKeyRuleDirty() && (bl || pSDataEntityBase.getKeyRule() != null)) {
            iDataObject.set(FIELD_KEYRULE, (Object)pSDataEntityBase.getKeyRule());
        }
        if (pSDataEntityBase.isLNPSLanResIdDirty() && (bl || pSDataEntityBase.getLNPSLanResId() != null)) {
            iDataObject.set(FIELD_LNPSLANRESID, (Object)pSDataEntityBase.getLNPSLanResId());
        }
        if (pSDataEntityBase.isLNPSLanResNameDirty() && (bl || pSDataEntityBase.getLNPSLanResName() != null)) {
            iDataObject.set(FIELD_LNPSLANRESNAME, (Object)pSDataEntityBase.getLNPSLanResName());
        }
        if (pSDataEntityBase.isLockFlagDirty() && (bl || pSDataEntityBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSDataEntityBase.getLockFlag());
        }
        if (pSDataEntityBase.isLogicInvalidValueDirty() && (bl || pSDataEntityBase.getLogicInvalidValue() != null)) {
            iDataObject.set(FIELD_LOGICINVALIDVALUE, (Object)pSDataEntityBase.getLogicInvalidValue());
        }
        if (pSDataEntityBase.isLogicNameDirty() && (bl || pSDataEntityBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSDataEntityBase.getLogicName());
        }
        if (pSDataEntityBase.isLogicValidDirty() && (bl || pSDataEntityBase.getLogicValid() != null)) {
            iDataObject.set(FIELD_LOGICVALID, (Object)pSDataEntityBase.getLogicValid());
        }
        if (pSDataEntityBase.isLogicValidValueDirty() && (bl || pSDataEntityBase.getLogicValidValue() != null)) {
            iDataObject.set(FIELD_LOGICVALIDVALUE, (Object)pSDataEntityBase.getLogicValidValue());
        }
        if (pSDataEntityBase.isMajorPSDERsCntDirty() && (bl || pSDataEntityBase.getMajorPSDERsCnt() != null)) {
            iDataObject.set(FIELD_MAJORPSDERSCNT, (Object)pSDataEntityBase.getMajorPSDERsCnt());
        }
        if (pSDataEntityBase.isMaxEntityCacheCntDirty() && (bl || pSDataEntityBase.getMaxEntityCacheCnt() != null)) {
            iDataObject.set(FIELD_MAXENTITYCACHECNT, (Object)pSDataEntityBase.getMaxEntityCacheCnt());
        }
        if (pSDataEntityBase.isMemoDirty() && (bl || pSDataEntityBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDataEntityBase.getMemo());
        }
        if (pSDataEntityBase.isMinorPSDERsCntDirty() && (bl || pSDataEntityBase.getMinorPSDERsCnt() != null)) {
            iDataObject.set(FIELD_MINORPSDERSCNT, (Object)pSDataEntityBase.getMinorPSDERsCnt());
        }
        if (pSDataEntityBase.isModColorDirty() && (bl || pSDataEntityBase.getModColor() != null)) {
            iDataObject.set(FIELD_MODCOLOR, (Object)pSDataEntityBase.getModColor());
        }
        if (pSDataEntityBase.isModelImpExpFlagDirty() && (bl || pSDataEntityBase.getModelImpExpFlag() != null)) {
            iDataObject.set(FIELD_MODELIMPEXPFLAG, (Object)pSDataEntityBase.getModelImpExpFlag());
        }
        if (pSDataEntityBase.isModelStateDirty() && (bl || pSDataEntityBase.getModelState() != null)) {
            iDataObject.set(FIELD_MODELSTATE, (Object)pSDataEntityBase.getModelState());
        }
        if (pSDataEntityBase.isModelVerDirty() && (bl || pSDataEntityBase.getModelVer() != null)) {
            iDataObject.set(FIELD_MODELVER, (Object)pSDataEntityBase.getModelVer());
        }
        if (pSDataEntityBase.isMSActionLogicFlagDirty() && (bl || pSDataEntityBase.getMSActionLogicFlag() != null)) {
            iDataObject.set(FIELD_MSACTIONLOGICFLAG, (Object)pSDataEntityBase.getMSActionLogicFlag());
        }
        if (pSDataEntityBase.isNoViewModeDirty() && (bl || pSDataEntityBase.getNoViewMode() != null)) {
            iDataObject.set(FIELD_NOVIEWMODE, (Object)pSDataEntityBase.getNoViewMode());
        }
        if (pSDataEntityBase.isOrderValueDirty() && (bl || pSDataEntityBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDataEntityBase.getOrderValue());
        }
        if (pSDataEntityBase.isPSACHandlersCntDirty() && (bl || pSDataEntityBase.getPSACHandlersCnt() != null)) {
            iDataObject.set(FIELD_PSACHANDLERSCNT, (Object)pSDataEntityBase.getPSACHandlersCnt());
        }
        if (pSDataEntityBase.isPSCodeListsCntDirty() && (bl || pSDataEntityBase.getPSCodeListsCnt() != null)) {
            iDataObject.set(FIELD_PSCODELISTSCNT, (Object)pSDataEntityBase.getPSCodeListsCnt());
        }
        if (pSDataEntityBase.isPSDataEntityIdDirty() && (bl || pSDataEntityBase.getPSDataEntityId() != null)) {
            iDataObject.set(FIELD_PSDATAENTITYID, (Object)pSDataEntityBase.getPSDataEntityId());
        }
        if (pSDataEntityBase.isPSDataEntityNameDirty() && (bl || pSDataEntityBase.getPSDataEntityName() != null)) {
            iDataObject.set(FIELD_PSDATAENTITYNAME, (Object)pSDataEntityBase.getPSDataEntityName());
        }
        if (pSDataEntityBase.isPSDEACModesCntDirty() && (bl || pSDataEntityBase.getPSDEACModesCnt() != null)) {
            iDataObject.set(FIELD_PSDEACMODESCNT, (Object)pSDataEntityBase.getPSDEACModesCnt());
        }
        if (pSDataEntityBase.isPSDEActionLogicsCntDirty() && (bl || pSDataEntityBase.getPSDEActionLogicsCnt() != null)) {
            iDataObject.set(FIELD_PSDEACTIONLOGICSCNT, (Object)pSDataEntityBase.getPSDEActionLogicsCnt());
        }
        if (pSDataEntityBase.isPSDEActionsCntDirty() && (bl || pSDataEntityBase.getPSDEActionsCnt() != null)) {
            iDataObject.set(FIELD_PSDEACTIONSCNT, (Object)pSDataEntityBase.getPSDEActionsCnt());
        }
        if (pSDataEntityBase.isPSDEAWGrpsCntDirty() && (bl || pSDataEntityBase.getPSDEAWGrpsCnt() != null)) {
            iDataObject.set(FIELD_PSDEAWGRPSCNT, (Object)pSDataEntityBase.getPSDEAWGrpsCnt());
        }
        if (pSDataEntityBase.isPSDEAWsCntDirty() && (bl || pSDataEntityBase.getPSDEAWsCnt() != null)) {
            iDataObject.set(FIELD_PSDEAWSCNT, (Object)pSDataEntityBase.getPSDEAWsCnt());
        }
        if (pSDataEntityBase.isPSDEChartsCntDirty() && (bl || pSDataEntityBase.getPSDEChartsCnt() != null)) {
            iDataObject.set(FIELD_PSDECHARTSCNT, (Object)pSDataEntityBase.getPSDEChartsCnt());
        }
        if (pSDataEntityBase.isPSDEDataExpsCntDirty() && (bl || pSDataEntityBase.getPSDEDataExpsCnt() != null)) {
            iDataObject.set(FIELD_PSDEDATAEXPSCNT, (Object)pSDataEntityBase.getPSDEDataExpsCnt());
        }
        if (pSDataEntityBase.isPSDEDataImpsCntDirty() && (bl || pSDataEntityBase.getPSDEDataImpsCnt() != null)) {
            iDataObject.set(FIELD_PSDEDATAIMPSCNT, (Object)pSDataEntityBase.getPSDEDataImpsCnt());
        }
        if (pSDataEntityBase.isPSDEDataQuerysCntDirty() && (bl || pSDataEntityBase.getPSDEDataQuerysCnt() != null)) {
            iDataObject.set(FIELD_PSDEDATAQUERYSCNT, (Object)pSDataEntityBase.getPSDEDataQuerysCnt());
        }
        if (pSDataEntityBase.isPSDEDataRelationsCntDirty() && (bl || pSDataEntityBase.getPSDEDataRelationsCnt() != null)) {
            iDataObject.set(FIELD_PSDEDATARELATIONSCNT, (Object)pSDataEntityBase.getPSDEDataRelationsCnt());
        }
        if (pSDataEntityBase.isPSDEDataSetsCntDirty() && (bl || pSDataEntityBase.getPSDEDataSetsCnt() != null)) {
            iDataObject.set(FIELD_PSDEDATASETSCNT, (Object)pSDataEntityBase.getPSDEDataSetsCnt());
        }
        if (pSDataEntityBase.isPSDEDataSyncsCntDirty() && (bl || pSDataEntityBase.getPSDEDataSyncsCnt() != null)) {
            iDataObject.set(FIELD_PSDEDATASYNCSCNT, (Object)pSDataEntityBase.getPSDEDataSyncsCnt());
        }
        if (pSDataEntityBase.isPSDEDataViewsCntDirty() && (bl || pSDataEntityBase.getPSDEDataViewsCnt() != null)) {
            iDataObject.set(FIELD_PSDEDATAVIEWSCNT, (Object)pSDataEntityBase.getPSDEDataViewsCnt());
        }
        if (pSDataEntityBase.isPSDEDBCfgsCntDirty() && (bl || pSDataEntityBase.getPSDEDBCfgsCnt() != null)) {
            iDataObject.set(FIELD_PSDEDBCFGSCNT, (Object)pSDataEntityBase.getPSDEDBCfgsCnt());
        }
        if (pSDataEntityBase.isPSDEDBIndexsCntDirty() && (bl || pSDataEntityBase.getPSDEDBIndexsCnt() != null)) {
            iDataObject.set(FIELD_PSDEDBINDEXSCNT, (Object)pSDataEntityBase.getPSDEDBIndexsCnt());
        }
        if (pSDataEntityBase.isPSDEDRGroupsCntDirty() && (bl || pSDataEntityBase.getPSDEDRGroupsCnt() != null)) {
            iDataObject.set(FIELD_PSDEDRGROUPSCNT, (Object)pSDataEntityBase.getPSDEDRGroupsCnt());
        }
        if (pSDataEntityBase.isPSDEDRItemsCntDirty() && (bl || pSDataEntityBase.getPSDEDRItemsCnt() != null)) {
            iDataObject.set(FIELD_PSDEDRITEMSCNT, (Object)pSDataEntityBase.getPSDEDRItemsCnt());
        }
        if (pSDataEntityBase.isPSDEDTSQueuesCntDirty() && (bl || pSDataEntityBase.getPSDEDTSQueuesCnt() != null)) {
            iDataObject.set(FIELD_PSDEDTSQUEUESCNT, (Object)pSDataEntityBase.getPSDEDTSQueuesCnt());
        }
        if (pSDataEntityBase.isPSDEFieldsCntDirty() && (bl || pSDataEntityBase.getPSDEFieldsCnt() != null)) {
            iDataObject.set(FIELD_PSDEFIELDSCNT, (Object)pSDataEntityBase.getPSDEFieldsCnt());
        }
        if (pSDataEntityBase.isPSDEFInputTipSetIdDirty() && (bl || pSDataEntityBase.getPSDEFInputTipSetId() != null)) {
            iDataObject.set(FIELD_PSDEFINPUTTIPSETID, (Object)pSDataEntityBase.getPSDEFInputTipSetId());
        }
        if (pSDataEntityBase.isPSDEFInputTipSetNameDirty() && (bl || pSDataEntityBase.getPSDEFInputTipSetName() != null)) {
            iDataObject.set(FIELD_PSDEFINPUTTIPSETNAME, (Object)pSDataEntityBase.getPSDEFInputTipSetName());
        }
        if (pSDataEntityBase.isPSDEFormsCntDirty() && (bl || pSDataEntityBase.getPSDEFormsCnt() != null)) {
            iDataObject.set(FIELD_PSDEFORMSCNT, (Object)pSDataEntityBase.getPSDEFormsCnt());
        }
        if (pSDataEntityBase.isPSDEFSFItemsCntDirty() && (bl || pSDataEntityBase.getPSDEFSFItemsCnt() != null)) {
            iDataObject.set(FIELD_PSDEFSFITEMSCNT, (Object)pSDataEntityBase.getPSDEFSFItemsCnt());
        }
        if (pSDataEntityBase.isPSDEFValueRulesCntDirty() && (bl || pSDataEntityBase.getPSDEFValueRulesCnt() != null)) {
            iDataObject.set(FIELD_PSDEFVALUERULESCNT, (Object)pSDataEntityBase.getPSDEFValueRulesCnt());
        }
        if (pSDataEntityBase.isPSDEGridsCntDirty() && (bl || pSDataEntityBase.getPSDEGridsCnt() != null)) {
            iDataObject.set(FIELD_PSDEGRIDSCNT, (Object)pSDataEntityBase.getPSDEGridsCnt());
        }
        if (pSDataEntityBase.isPSDEListsCntDirty() && (bl || pSDataEntityBase.getPSDEListsCnt() != null)) {
            iDataObject.set(FIELD_PSDELISTSCNT, (Object)pSDataEntityBase.getPSDEListsCnt());
        }
        if (pSDataEntityBase.isPSDELogicsCntDirty() && (bl || pSDataEntityBase.getPSDELogicsCnt() != null)) {
            iDataObject.set(FIELD_PSDELOGICSCNT, (Object)pSDataEntityBase.getPSDELogicsCnt());
        }
        if (pSDataEntityBase.isPSDEMainStatesCntDirty() && (bl || pSDataEntityBase.getPSDEMainStatesCnt() != null)) {
            iDataObject.set(FIELD_PSDEMAINSTATESCNT, (Object)pSDataEntityBase.getPSDEMainStatesCnt());
        }
        if (pSDataEntityBase.isPSDEOPPrivRolesCntDirty() && (bl || pSDataEntityBase.getPSDEOPPrivRolesCnt() != null)) {
            iDataObject.set(FIELD_PSDEOPPRIVROLESCNT, (Object)pSDataEntityBase.getPSDEOPPrivRolesCnt());
        }
        if (pSDataEntityBase.isPSDEOPPrivsCntDirty() && (bl || pSDataEntityBase.getPSDEOPPrivsCnt() != null)) {
            iDataObject.set(FIELD_PSDEOPPRIVSCNT, (Object)pSDataEntityBase.getPSDEOPPrivsCnt());
        }
        if (pSDataEntityBase.isPSDEPrintsCntDirty() && (bl || pSDataEntityBase.getPSDEPrintsCnt() != null)) {
            iDataObject.set(FIELD_PSDEPRINTSCNT, (Object)pSDataEntityBase.getPSDEPrintsCnt());
        }
        if (pSDataEntityBase.isPSDEReportsCntDirty() && (bl || pSDataEntityBase.getPSDEReportsCnt() != null)) {
            iDataObject.set(FIELD_PSDEREPORTSCNT, (Object)pSDataEntityBase.getPSDEReportsCnt());
        }
        if (pSDataEntityBase.isPSDEServiceAPIsCntDirty() && (bl || pSDataEntityBase.getPSDEServiceAPIsCnt() != null)) {
            iDataObject.set(FIELD_PSDESERVICEAPISCNT, (Object)pSDataEntityBase.getPSDEServiceAPIsCnt());
        }
        if (pSDataEntityBase.isPSDEToolbarsCntDirty() && (bl || pSDataEntityBase.getPSDEToolbarsCnt() != null)) {
            iDataObject.set(FIELD_PSDETOOLBARSCNT, (Object)pSDataEntityBase.getPSDEToolbarsCnt());
        }
        if (pSDataEntityBase.isPSDETreeViewsCntDirty() && (bl || pSDataEntityBase.getPSDETreeViewsCnt() != null)) {
            iDataObject.set(FIELD_PSDETREEVIEWSCNT, (Object)pSDataEntityBase.getPSDETreeViewsCnt());
        }
        if (pSDataEntityBase.isPSDEUAGroupsCntDirty() && (bl || pSDataEntityBase.getPSDEUAGroupsCnt() != null)) {
            iDataObject.set(FIELD_PSDEUAGROUPSCNT, (Object)pSDataEntityBase.getPSDEUAGroupsCnt());
        }
        if (pSDataEntityBase.isPSDEUIActionsCntDirty() && (bl || pSDataEntityBase.getPSDEUIActionsCnt() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONSCNT, (Object)pSDataEntityBase.getPSDEUIActionsCnt());
        }
        if (pSDataEntityBase.isPSDEUserRolesCntDirty() && (bl || pSDataEntityBase.getPSDEUserRolesCnt() != null)) {
            iDataObject.set(FIELD_PSDEUSERROLESCNT, (Object)pSDataEntityBase.getPSDEUserRolesCnt());
        }
        if (pSDataEntityBase.isPSDEViewBasesCntDirty() && (bl || pSDataEntityBase.getPSDEViewBasesCnt() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASESCNT, (Object)pSDataEntityBase.getPSDEViewBasesCnt());
        }
        if (pSDataEntityBase.isPSDEWizardsCntDirty() && (bl || pSDataEntityBase.getPSDEWizardsCnt() != null)) {
            iDataObject.set(FIELD_PSDEWIZARDSCNT, (Object)pSDataEntityBase.getPSDEWizardsCnt());
        }
        if (pSDataEntityBase.isPSDynaDETemplIdDirty() && (bl || pSDataEntityBase.getPSDynaDETemplId() != null)) {
            iDataObject.set(FIELD_PSDYNADETEMPLID, (Object)pSDataEntityBase.getPSDynaDETemplId());
        }
        if (pSDataEntityBase.isPSDynaDETemplNameDirty() && (bl || pSDataEntityBase.getPSDynaDETemplName() != null)) {
            iDataObject.set(FIELD_PSDYNADETEMPLNAME, (Object)pSDataEntityBase.getPSDynaDETemplName());
        }
        if (pSDataEntityBase.isPSDynaInstIdDirty() && (bl || pSDataEntityBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSDataEntityBase.getPSDynaInstId());
        }
        if (pSDataEntityBase.isPSHelpModuleIdDirty() && (bl || pSDataEntityBase.getPSHelpModuleId() != null)) {
            iDataObject.set(FIELD_PSHELPMODULEID, (Object)pSDataEntityBase.getPSHelpModuleId());
        }
        if (pSDataEntityBase.isPSHelpModuleNameDirty() && (bl || pSDataEntityBase.getPSHelpModuleName() != null)) {
            iDataObject.set(FIELD_PSHELPMODULENAME, (Object)pSDataEntityBase.getPSHelpModuleName());
        }
        if (pSDataEntityBase.isPSModuleIdDirty() && (bl || pSDataEntityBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSDataEntityBase.getPSModuleId());
        }
        if (pSDataEntityBase.isPSModuleNameDirty() && (bl || pSDataEntityBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSDataEntityBase.getPSModuleName());
        }
        if (pSDataEntityBase.isPSSubSysSADEIdDirty() && (bl || pSDataEntityBase.getPSSubSysSADEId() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSADEID, (Object)pSDataEntityBase.getPSSubSysSADEId());
        }
        if (pSDataEntityBase.isPSSubSysSADENameDirty() && (bl || pSDataEntityBase.getPSSubSysSADEName() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSADENAME, (Object)pSDataEntityBase.getPSSubSysSADEName());
        }
        if (pSDataEntityBase.isPSSubSysServiceAPIIdDirty() && (bl || pSDataEntityBase.getPSSubSysServiceAPIId() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSERVICEAPIID, (Object)pSDataEntityBase.getPSSubSysServiceAPIId());
        }
        if (pSDataEntityBase.isPSSubSysServiceAPINameDirty() && (bl || pSDataEntityBase.getPSSubSysServiceAPIName() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSERVICEAPINAME, (Object)pSDataEntityBase.getPSSubSysServiceAPIName());
        }
        if (pSDataEntityBase.isPSSysBDTablesCntDirty() && (bl || pSDataEntityBase.getPSSysBDTablesCnt() != null)) {
            iDataObject.set(FIELD_PSSYSBDTABLESCNT, (Object)pSDataEntityBase.getPSSysBDTablesCnt());
        }
        if (pSDataEntityBase.isPSSysCountersCntDirty() && (bl || pSDataEntityBase.getPSSysCountersCnt() != null)) {
            iDataObject.set(FIELD_PSSYSCOUNTERSCNT, (Object)pSDataEntityBase.getPSSysCountersCnt());
        }
        if (pSDataEntityBase.isPSSysDMItemsCntDirty() && (bl || pSDataEntityBase.getPSSysDMItemsCnt() != null)) {
            iDataObject.set(FIELD_PSSYSDMITEMSCNT, (Object)pSDataEntityBase.getPSSysDMItemsCnt());
        }
        if (pSDataEntityBase.isPSSysDynaModelIdDirty() && (bl || pSDataEntityBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSDataEntityBase.getPSSysDynaModelId());
        }
        if (pSDataEntityBase.isPSSysDynaModelNameDirty() && (bl || pSDataEntityBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSDataEntityBase.getPSSysDynaModelName());
        }
        if (pSDataEntityBase.isPSSysImageIdDirty() && (bl || pSDataEntityBase.getPSSysImageId() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGEID, (Object)pSDataEntityBase.getPSSysImageId());
        }
        if (pSDataEntityBase.isPSSysImageNameDirty() && (bl || pSDataEntityBase.getPSSysImageName() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGENAME, (Object)pSDataEntityBase.getPSSysImageName());
        }
        if (pSDataEntityBase.isPSSysModelChgLogsCntDirty() && (bl || pSDataEntityBase.getPSSysModelChgLogsCnt() != null)) {
            iDataObject.set(FIELD_PSSYSMODELCHGLOGSCNT, (Object)pSDataEntityBase.getPSSysModelChgLogsCnt());
        }
        if (pSDataEntityBase.isPSSysModelGroupIdDirty() && (bl || pSDataEntityBase.getPSSysModelGroupId() != null)) {
            iDataObject.set(FIELD_PSSYSMODELGROUPID, (Object)pSDataEntityBase.getPSSysModelGroupId());
        }
        if (pSDataEntityBase.isPSSysModelGroupNameDirty() && (bl || pSDataEntityBase.getPSSysModelGroupName() != null)) {
            iDataObject.set(FIELD_PSSYSMODELGROUPNAME, (Object)pSDataEntityBase.getPSSysModelGroupName());
        }
        if (pSDataEntityBase.isPSSysReqItemIdDirty() && (bl || pSDataEntityBase.getPSSysReqItemId() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMID, (Object)pSDataEntityBase.getPSSysReqItemId());
        }
        if (pSDataEntityBase.isPSSysReqItemNameDirty() && (bl || pSDataEntityBase.getPSSysReqItemName() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMNAME, (Object)pSDataEntityBase.getPSSysReqItemName());
        }
        if (pSDataEntityBase.isPSSysSFPluginIdDirty() && (bl || pSDataEntityBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSDataEntityBase.getPSSysSFPluginId());
        }
        if (pSDataEntityBase.isPSSysSFPluginNameDirty() && (bl || pSDataEntityBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSDataEntityBase.getPSSysSFPluginName());
        }
        if (pSDataEntityBase.isPSSysTasksCntDirty() && (bl || pSDataEntityBase.getPSSysTasksCnt() != null)) {
            iDataObject.set(FIELD_PSSYSTASKSCNT, (Object)pSDataEntityBase.getPSSysTasksCnt());
        }
        if (pSDataEntityBase.isPSSystemIdDirty() && (bl || pSDataEntityBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSDataEntityBase.getPSSystemId());
        }
        if (pSDataEntityBase.isPSSystemNameDirty() && (bl || pSDataEntityBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSDataEntityBase.getPSSystemName());
        }
        if (pSDataEntityBase.isPSSysTestCasesCntDirty() && (bl || pSDataEntityBase.getPSSysTestCasesCnt() != null)) {
            iDataObject.set(FIELD_PSSYSTESTCASESCNT, (Object)pSDataEntityBase.getPSSysTestCasesCnt());
        }
        if (pSDataEntityBase.isPSSysTestDatasCntDirty() && (bl || pSDataEntityBase.getPSSysTestDatasCnt() != null)) {
            iDataObject.set(FIELD_PSSYSTESTDATASCNT, (Object)pSDataEntityBase.getPSSysTestDatasCnt());
        }
        if (pSDataEntityBase.isPSSysUniResIdDirty() && (bl || pSDataEntityBase.getPSSysUniResId() != null)) {
            iDataObject.set(FIELD_PSSYSUNIRESID, (Object)pSDataEntityBase.getPSSysUniResId());
        }
        if (pSDataEntityBase.isPSSysUniResNameDirty() && (bl || pSDataEntityBase.getPSSysUniResName() != null)) {
            iDataObject.set(FIELD_PSSYSUNIRESNAME, (Object)pSDataEntityBase.getPSSysUniResName());
        }
        if (pSDataEntityBase.isPSWFDEsCntDirty() && (bl || pSDataEntityBase.getPSWFDEsCnt() != null)) {
            iDataObject.set(FIELD_PSWFDESCNT, (Object)pSDataEntityBase.getPSWFDEsCnt());
        }
        if (pSDataEntityBase.isReadOnlyModeDirty() && (bl || pSDataEntityBase.getReadOnlyMode() != null)) {
            iDataObject.set(FIELD_READONLYMODE, (Object)pSDataEntityBase.getReadOnlyMode());
        }
        if (pSDataEntityBase.isRemoveFlagDirty() && (bl || pSDataEntityBase.getRemoveFlag() != null)) {
            iDataObject.set(FIELD_REMOVEFLAG, (Object)pSDataEntityBase.getRemoveFlag());
        }
        if (pSDataEntityBase.isSaaSModeDirty() && (bl || pSDataEntityBase.getSaaSMode() != null)) {
            iDataObject.set(FIELD_SAASMODE, (Object)pSDataEntityBase.getSaaSMode());
        }
        if (pSDataEntityBase.isServiceAPIFlagDirty() && (bl || pSDataEntityBase.getServiceAPIFlag() != null)) {
            iDataObject.set(FIELD_SERVICEAPIFLAG, (Object)pSDataEntityBase.getServiceAPIFlag());
        }
        if (pSDataEntityBase.isServiceCodeNameDirty() && (bl || pSDataEntityBase.getServiceCodeName() != null)) {
            iDataObject.set(FIELD_SERVICECODENAME, (Object)pSDataEntityBase.getServiceCodeName());
        }
        if (pSDataEntityBase.isSrcPSDEMapsCntDirty() && (bl || pSDataEntityBase.getSrcPSDEMapsCnt() != null)) {
            iDataObject.set(FIELD_SRCPSDEMAPSCNT, (Object)pSDataEntityBase.getSrcPSDEMapsCnt());
        }
        if (pSDataEntityBase.isStorageModeDirty() && (bl || pSDataEntityBase.getStorageMode() != null)) {
            iDataObject.set(FIELD_STORAGEMODE, (Object)pSDataEntityBase.getStorageMode());
        }
        if (pSDataEntityBase.isSubSysDEDirty() && (bl || pSDataEntityBase.getSubSysDE() != null)) {
            iDataObject.set(FIELD_SUBSYSDE, (Object)pSDataEntityBase.getSubSysDE());
        }
        if (pSDataEntityBase.isSubSysModuleDirty() && (bl || pSDataEntityBase.getSubSysModule() != null)) {
            iDataObject.set(FIELD_SUBSYSMODULE, (Object)pSDataEntityBase.getSubSysModule());
        }
        if (pSDataEntityBase.isSvrPubModeDirty() && (bl || pSDataEntityBase.getSvrPubMode() != null)) {
            iDataObject.set(FIELD_SVRPUBMODE, (Object)pSDataEntityBase.getSvrPubMode());
        }
        if (pSDataEntityBase.isSystemFlagDirty() && (bl || pSDataEntityBase.getSystemFlag() != null)) {
            iDataObject.set(FIELD_SYSTEMFLAG, (Object)pSDataEntityBase.getSystemFlag());
        }
        if (pSDataEntityBase.isTableNameDirty() && (bl || pSDataEntityBase.getTableName() != null)) {
            iDataObject.set(FIELD_TABLENAME, (Object)pSDataEntityBase.getTableName());
        }
        if (pSDataEntityBase.isTestCaseFlagDirty() && (bl || pSDataEntityBase.getTestCaseFlag() != null)) {
            iDataObject.set(FIELD_TESTCASEFLAG, (Object)pSDataEntityBase.getTestCaseFlag());
        }
        if (pSDataEntityBase.isToDoTaskDirty() && (bl || pSDataEntityBase.getToDoTask() != null)) {
            iDataObject.set(FIELD_TODOTASK, (Object)pSDataEntityBase.getToDoTask());
        }
        if (pSDataEntityBase.isUpdateDateDirty() && (bl || pSDataEntityBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDataEntityBase.getUpdateDate());
        }
        if (pSDataEntityBase.isUpdateManDirty() && (bl || pSDataEntityBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDataEntityBase.getUpdateMan());
        }
        if (pSDataEntityBase.isUserActionDirty() && (bl || pSDataEntityBase.getUserAction() != null)) {
            iDataObject.set(FIELD_USERACTION, (Object)pSDataEntityBase.getUserAction());
        }
        if (pSDataEntityBase.isUserCatDirty() && (bl || pSDataEntityBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDataEntityBase.getUserCat());
        }
        if (pSDataEntityBase.isUserParamsDirty() && (bl || pSDataEntityBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSDataEntityBase.getUserParams());
        }
        if (pSDataEntityBase.isUserTagDirty() && (bl || pSDataEntityBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDataEntityBase.getUserTag());
        }
        if (pSDataEntityBase.isUserTag2Dirty() && (bl || pSDataEntityBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDataEntityBase.getUserTag2());
        }
        if (pSDataEntityBase.isUserTag3Dirty() && (bl || pSDataEntityBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDataEntityBase.getUserTag3());
        }
        if (pSDataEntityBase.isUserTag4Dirty() && (bl || pSDataEntityBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDataEntityBase.getUserTag4());
        }
        if (pSDataEntityBase.isValidFlagDirty() && (bl || pSDataEntityBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDataEntityBase.getValidFlag());
        }
        if (pSDataEntityBase.isViewLevelDirty() && (bl || pSDataEntityBase.getViewLevel() != null)) {
            iDataObject.set(FIELD_VIEWLEVEL, (Object)pSDataEntityBase.getViewLevel());
        }
        if (pSDataEntityBase.isViewNameDirty() && (bl || pSDataEntityBase.getViewName() != null)) {
            iDataObject.set(FIELD_VIEWNAME, (Object)pSDataEntityBase.getViewName());
        }
        if (pSDataEntityBase.isViewName2Dirty() && (bl || pSDataEntityBase.getViewName2() != null)) {
            iDataObject.set(FIELD_VIEWNAME2, (Object)pSDataEntityBase.getViewName2());
        }
        if (pSDataEntityBase.isViewName3Dirty() && (bl || pSDataEntityBase.getViewName3() != null)) {
            iDataObject.set(FIELD_VIEWNAME3, (Object)pSDataEntityBase.getViewName3());
        }
        if (pSDataEntityBase.isViewName4Dirty() && (bl || pSDataEntityBase.getViewName4() != null)) {
            iDataObject.set(FIELD_VIEWNAME4, (Object)pSDataEntityBase.getViewName4());
        }
        if (pSDataEntityBase.isVirtualFlagDirty() && (bl || pSDataEntityBase.getVirtualFlag() != null)) {
            iDataObject.set(FIELD_VIRTUALFLAG, (Object)pSDataEntityBase.getVirtualFlag());
        }
        if (pSDataEntityBase.isVKeySeparatorDirty() && (bl || pSDataEntityBase.getVKeySeparator() != null)) {
            iDataObject.set(FIELD_VKEYSEPARATOR, (Object)pSDataEntityBase.getVKeySeparator());
        }
    }

    public boolean remove(String string) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().remove(string);
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            return super.remove(string);
        }
        return PSDataEntityBase.remove(this, n);
    }

    private static boolean remove(PSDataEntityBase pSDataEntityBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDataEntityBase.resetAccCtrlArch();
                return true;
            }
            case 1: {
                pSDataEntityBase.resetAuditMode();
                return true;
            }
            case 2: {
                pSDataEntityBase.resetBaseClsParams();
                return true;
            }
            case 3: {
                pSDataEntityBase.resetBizTag();
                return true;
            }
            case 4: {
                pSDataEntityBase.resetCodeName();
                return true;
            }
            case 5: {
                pSDataEntityBase.resetCodeNameMode();
                return true;
            }
            case 6: {
                pSDataEntityBase.resetColor();
                return true;
            }
            case 7: {
                pSDataEntityBase.resetCreateDate();
                return true;
            }
            case 8: {
                pSDataEntityBase.resetCreateMan();
                return true;
            }
            case 9: {
                pSDataEntityBase.resetCustomCode();
                return true;
            }
            case 10: {
                pSDataEntityBase.resetCustomMode();
                return true;
            }
            case 11: {
                pSDataEntityBase.resetDataAccMode();
                return true;
            }
            case 12: {
                pSDataEntityBase.resetDataChgLogMode();
                return true;
            }
            case 13: {
                pSDataEntityBase.resetDataImpExpFlag();
                return true;
            }
            case 14: {
                pSDataEntityBase.resetDBTabSpace();
                return true;
            }
            case 15: {
                pSDataEntityBase.resetDBVer();
                return true;
            }
            case 16: {
                pSDataEntityBase.resetDECat();
                return true;
            }
            case 17: {
                pSDataEntityBase.resetDEHolder();
                return true;
            }
            case 18: {
                pSDataEntityBase.resetDELockFlag();
                return true;
            }
            case 19: {
                pSDataEntityBase.resetDESN();
                return true;
            }
            case 20: {
                pSDataEntityBase.resetDETag();
                return true;
            }
            case 21: {
                pSDataEntityBase.resetDETag2();
                return true;
            }
            case 22: {
                pSDataEntityBase.resetDEType();
                return true;
            }
            case 23: {
                pSDataEntityBase.resetDSLink();
                return true;
            }
            case 24: {
                pSDataEntityBase.resetDstPSDEActionLogicsCnt();
                return true;
            }
            case 25: {
                pSDataEntityBase.resetDynamicMode();
                return true;
            }
            case 26: {
                pSDataEntityBase.resetDynaModelFlag();
                return true;
            }
            case 27: {
                pSDataEntityBase.resetDynaTableMode();
                return true;
            }
            case 28: {
                pSDataEntityBase.resetEnableAudit();
                return true;
            }
            case 29: {
                pSDataEntityBase.resetEnableDALog();
                return true;
            }
            case 30: {
                pSDataEntityBase.resetEnableDataVer();
                return true;
            }
            case 31: {
                pSDataEntityBase.resetEnableDEAction();
                return true;
            }
            case 32: {
                pSDataEntityBase.resetEnableDEDataSet();
                return true;
            }
            case 33: {
                pSDataEntityBase.resetEnableDynaSys();
                return true;
            }
            case 34: {
                pSDataEntityBase.resetEnableEntityCache();
                return true;
            }
            case 35: {
                pSDataEntityBase.resetEnableMob();
                return true;
            }
            case 36: {
                pSDataEntityBase.resetEnableMultiDS();
                return true;
            }
            case 37: {
                pSDataEntityBase.resetEnableOPNameModel();
                return true;
            }
            case 38: {
                pSDataEntityBase.resetEnableOrgModel();
                return true;
            }
            case 39: {
                pSDataEntityBase.resetEnablePQL();
                return true;
            }
            case 40: {
                pSDataEntityBase.resetEnableSelect();
                return true;
            }
            case 41: {
                pSDataEntityBase.resetEnableWFModel();
                return true;
            }
            case 42: {
                pSDataEntityBase.resetEnaMultiForm();
                return true;
            }
            case 43: {
                pSDataEntityBase.resetEnaTempData();
                return true;
            }
            case 44: {
                pSDataEntityBase.resetEntityCacheTimeout();
                return true;
            }
            case 45: {
                pSDataEntityBase.resetExistingModel();
                return true;
            }
            case 46: {
                pSDataEntityBase.resetExTableName();
                return true;
            }
            case 47: {
                pSDataEntityBase.resetIndexDEType();
                return true;
            }
            case 48: {
                pSDataEntityBase.resetKeyRule();
                return true;
            }
            case 49: {
                pSDataEntityBase.resetLNPSLanResId();
                return true;
            }
            case 50: {
                pSDataEntityBase.resetLNPSLanResName();
                return true;
            }
            case 51: {
                pSDataEntityBase.resetLockFlag();
                return true;
            }
            case 52: {
                pSDataEntityBase.resetLogicInvalidValue();
                return true;
            }
            case 53: {
                pSDataEntityBase.resetLogicName();
                return true;
            }
            case 54: {
                pSDataEntityBase.resetLogicValid();
                return true;
            }
            case 55: {
                pSDataEntityBase.resetLogicValidValue();
                return true;
            }
            case 56: {
                pSDataEntityBase.resetMajorPSDERsCnt();
                return true;
            }
            case 57: {
                pSDataEntityBase.resetMaxEntityCacheCnt();
                return true;
            }
            case 58: {
                pSDataEntityBase.resetMemo();
                return true;
            }
            case 59: {
                pSDataEntityBase.resetMinorPSDERsCnt();
                return true;
            }
            case 60: {
                pSDataEntityBase.resetModColor();
                return true;
            }
            case 61: {
                pSDataEntityBase.resetModelImpExpFlag();
                return true;
            }
            case 62: {
                pSDataEntityBase.resetModelState();
                return true;
            }
            case 63: {
                pSDataEntityBase.resetModelVer();
                return true;
            }
            case 64: {
                pSDataEntityBase.resetMSActionLogicFlag();
                return true;
            }
            case 65: {
                pSDataEntityBase.resetNoViewMode();
                return true;
            }
            case 66: {
                pSDataEntityBase.resetOrderValue();
                return true;
            }
            case 67: {
                pSDataEntityBase.resetPSACHandlersCnt();
                return true;
            }
            case 68: {
                pSDataEntityBase.resetPSCodeListsCnt();
                return true;
            }
            case 69: {
                pSDataEntityBase.resetPSDataEntityId();
                return true;
            }
            case 70: {
                pSDataEntityBase.resetPSDataEntityName();
                return true;
            }
            case 71: {
                pSDataEntityBase.resetPSDEACModesCnt();
                return true;
            }
            case 72: {
                pSDataEntityBase.resetPSDEActionLogicsCnt();
                return true;
            }
            case 73: {
                pSDataEntityBase.resetPSDEActionsCnt();
                return true;
            }
            case 74: {
                pSDataEntityBase.resetPSDEAWGrpsCnt();
                return true;
            }
            case 75: {
                pSDataEntityBase.resetPSDEAWsCnt();
                return true;
            }
            case 76: {
                pSDataEntityBase.resetPSDEChartsCnt();
                return true;
            }
            case 77: {
                pSDataEntityBase.resetPSDEDataExpsCnt();
                return true;
            }
            case 78: {
                pSDataEntityBase.resetPSDEDataImpsCnt();
                return true;
            }
            case 79: {
                pSDataEntityBase.resetPSDEDataQuerysCnt();
                return true;
            }
            case 80: {
                pSDataEntityBase.resetPSDEDataRelationsCnt();
                return true;
            }
            case 81: {
                pSDataEntityBase.resetPSDEDataSetsCnt();
                return true;
            }
            case 82: {
                pSDataEntityBase.resetPSDEDataSyncsCnt();
                return true;
            }
            case 83: {
                pSDataEntityBase.resetPSDEDataViewsCnt();
                return true;
            }
            case 84: {
                pSDataEntityBase.resetPSDEDBCfgsCnt();
                return true;
            }
            case 85: {
                pSDataEntityBase.resetPSDEDBIndexsCnt();
                return true;
            }
            case 86: {
                pSDataEntityBase.resetPSDEDRGroupsCnt();
                return true;
            }
            case 87: {
                pSDataEntityBase.resetPSDEDRItemsCnt();
                return true;
            }
            case 88: {
                pSDataEntityBase.resetPSDEDTSQueuesCnt();
                return true;
            }
            case 89: {
                pSDataEntityBase.resetPSDEFieldsCnt();
                return true;
            }
            case 90: {
                pSDataEntityBase.resetPSDEFInputTipSetId();
                return true;
            }
            case 91: {
                pSDataEntityBase.resetPSDEFInputTipSetName();
                return true;
            }
            case 92: {
                pSDataEntityBase.resetPSDEFormsCnt();
                return true;
            }
            case 93: {
                pSDataEntityBase.resetPSDEFSFItemsCnt();
                return true;
            }
            case 94: {
                pSDataEntityBase.resetPSDEFValueRulesCnt();
                return true;
            }
            case 95: {
                pSDataEntityBase.resetPSDEGridsCnt();
                return true;
            }
            case 96: {
                pSDataEntityBase.resetPSDEListsCnt();
                return true;
            }
            case 97: {
                pSDataEntityBase.resetPSDELogicsCnt();
                return true;
            }
            case 98: {
                pSDataEntityBase.resetPSDEMainStatesCnt();
                return true;
            }
            case 99: {
                pSDataEntityBase.resetPSDEOPPrivRolesCnt();
                return true;
            }
            case 100: {
                pSDataEntityBase.resetPSDEOPPrivsCnt();
                return true;
            }
            case 101: {
                pSDataEntityBase.resetPSDEPrintsCnt();
                return true;
            }
            case 102: {
                pSDataEntityBase.resetPSDEReportsCnt();
                return true;
            }
            case 103: {
                pSDataEntityBase.resetPSDEServiceAPIsCnt();
                return true;
            }
            case 104: {
                pSDataEntityBase.resetPSDEToolbarsCnt();
                return true;
            }
            case 105: {
                pSDataEntityBase.resetPSDETreeViewsCnt();
                return true;
            }
            case 106: {
                pSDataEntityBase.resetPSDEUAGroupsCnt();
                return true;
            }
            case 107: {
                pSDataEntityBase.resetPSDEUIActionsCnt();
                return true;
            }
            case 108: {
                pSDataEntityBase.resetPSDEUserRolesCnt();
                return true;
            }
            case 109: {
                pSDataEntityBase.resetPSDEViewBasesCnt();
                return true;
            }
            case 110: {
                pSDataEntityBase.resetPSDEWizardsCnt();
                return true;
            }
            case 111: {
                pSDataEntityBase.resetPSDynaDETemplId();
                return true;
            }
            case 112: {
                pSDataEntityBase.resetPSDynaDETemplName();
                return true;
            }
            case 113: {
                pSDataEntityBase.resetPSDynaInstId();
                return true;
            }
            case 114: {
                pSDataEntityBase.resetPSHelpModuleId();
                return true;
            }
            case 115: {
                pSDataEntityBase.resetPSHelpModuleName();
                return true;
            }
            case 116: {
                pSDataEntityBase.resetPSModuleId();
                return true;
            }
            case 117: {
                pSDataEntityBase.resetPSModuleName();
                return true;
            }
            case 118: {
                pSDataEntityBase.resetPSSubSysSADEId();
                return true;
            }
            case 119: {
                pSDataEntityBase.resetPSSubSysSADEName();
                return true;
            }
            case 120: {
                pSDataEntityBase.resetPSSubSysServiceAPIId();
                return true;
            }
            case 121: {
                pSDataEntityBase.resetPSSubSysServiceAPIName();
                return true;
            }
            case 122: {
                pSDataEntityBase.resetPSSysBDTablesCnt();
                return true;
            }
            case 123: {
                pSDataEntityBase.resetPSSysCountersCnt();
                return true;
            }
            case 124: {
                pSDataEntityBase.resetPSSysDMItemsCnt();
                return true;
            }
            case 125: {
                pSDataEntityBase.resetPSSysDynaModelId();
                return true;
            }
            case 126: {
                pSDataEntityBase.resetPSSysDynaModelName();
                return true;
            }
            case 127: {
                pSDataEntityBase.resetPSSysImageId();
                return true;
            }
            case 128: {
                pSDataEntityBase.resetPSSysImageName();
                return true;
            }
            case 129: {
                pSDataEntityBase.resetPSSysModelChgLogsCnt();
                return true;
            }
            case 130: {
                pSDataEntityBase.resetPSSysModelGroupId();
                return true;
            }
            case 131: {
                pSDataEntityBase.resetPSSysModelGroupName();
                return true;
            }
            case 132: {
                pSDataEntityBase.resetPSSysReqItemId();
                return true;
            }
            case 133: {
                pSDataEntityBase.resetPSSysReqItemName();
                return true;
            }
            case 134: {
                pSDataEntityBase.resetPSSysSFPluginId();
                return true;
            }
            case 135: {
                pSDataEntityBase.resetPSSysSFPluginName();
                return true;
            }
            case 136: {
                pSDataEntityBase.resetPSSysTasksCnt();
                return true;
            }
            case 137: {
                pSDataEntityBase.resetPSSystemId();
                return true;
            }
            case 138: {
                pSDataEntityBase.resetPSSystemName();
                return true;
            }
            case 139: {
                pSDataEntityBase.resetPSSysTestCasesCnt();
                return true;
            }
            case 140: {
                pSDataEntityBase.resetPSSysTestDatasCnt();
                return true;
            }
            case 141: {
                pSDataEntityBase.resetPSSysUniResId();
                return true;
            }
            case 142: {
                pSDataEntityBase.resetPSSysUniResName();
                return true;
            }
            case 143: {
                pSDataEntityBase.resetPSWFDEsCnt();
                return true;
            }
            case 144: {
                pSDataEntityBase.resetReadOnlyMode();
                return true;
            }
            case 145: {
                pSDataEntityBase.resetRemoveFlag();
                return true;
            }
            case 146: {
                pSDataEntityBase.resetSaaSMode();
                return true;
            }
            case 147: {
                pSDataEntityBase.resetServiceAPIFlag();
                return true;
            }
            case 148: {
                pSDataEntityBase.resetServiceCodeName();
                return true;
            }
            case 149: {
                pSDataEntityBase.resetSrcPSDEMapsCnt();
                return true;
            }
            case 150: {
                pSDataEntityBase.resetStorageMode();
                return true;
            }
            case 151: {
                pSDataEntityBase.resetSubSysDE();
                return true;
            }
            case 152: {
                pSDataEntityBase.resetSubSysModule();
                return true;
            }
            case 153: {
                pSDataEntityBase.resetSvrPubMode();
                return true;
            }
            case 154: {
                pSDataEntityBase.resetSystemFlag();
                return true;
            }
            case 155: {
                pSDataEntityBase.resetTableName();
                return true;
            }
            case 156: {
                pSDataEntityBase.resetTestCaseFlag();
                return true;
            }
            case 157: {
                pSDataEntityBase.resetToDoTask();
                return true;
            }
            case 158: {
                pSDataEntityBase.resetUpdateDate();
                return true;
            }
            case 159: {
                pSDataEntityBase.resetUpdateMan();
                return true;
            }
            case 160: {
                pSDataEntityBase.resetUserAction();
                return true;
            }
            case 161: {
                pSDataEntityBase.resetUserCat();
                return true;
            }
            case 162: {
                pSDataEntityBase.resetUserParams();
                return true;
            }
            case 163: {
                pSDataEntityBase.resetUserTag();
                return true;
            }
            case 164: {
                pSDataEntityBase.resetUserTag2();
                return true;
            }
            case 165: {
                pSDataEntityBase.resetUserTag3();
                return true;
            }
            case 166: {
                pSDataEntityBase.resetUserTag4();
                return true;
            }
            case 167: {
                pSDataEntityBase.resetValidFlag();
                return true;
            }
            case 168: {
                pSDataEntityBase.resetViewLevel();
                return true;
            }
            case 169: {
                pSDataEntityBase.resetViewName();
                return true;
            }
            case 170: {
                pSDataEntityBase.resetViewName2();
                return true;
            }
            case 171: {
                pSDataEntityBase.resetViewName3();
                return true;
            }
            case 172: {
                pSDataEntityBase.resetViewName4();
                return true;
            }
            case 173: {
                pSDataEntityBase.resetVirtualFlag();
                return true;
            }
            case 174: {
                pSDataEntityBase.resetVKeySeparator();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEFInputTipSet getPSDEFInputTipSet() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFInputTipSet();
        }
        if (this.getPSDEFInputTipSetId() == null) {
            return null;
        }
        Integer n = this.objPSDEFInputTipSetLock;
        synchronized (n) {
            if (this.psdefinputtipset != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFInputTipSetId(), (Object)this.psdefinputtipset.getPSDEFInputTipSetId()) != 0L) {
                this.psdefinputtipset = null;
            }
            if (this.psdefinputtipset == null) {
                PSDEFInputTipSet pSDEFInputTipSet = new PSDEFInputTipSet();
                pSDEFInputTipSet.setPSDEFInputTipSetId(this.getPSDEFInputTipSetId());
                PSDEFInputTipSetService pSDEFInputTipSetService = (PSDEFInputTipSetService)ServiceGlobal.getService(PSDEFInputTipSetService.class, (SessionFactory)this.getSessionFactory());
                pSDEFInputTipSetService.autoGet(pSDEFInputTipSet);
                this.psdefinputtipset = pSDEFInputTipSet;
            }
            return this.psdefinputtipset;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDynaDETempl getPSDynaDETempl() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaDETempl();
        }
        if (this.getPSDynaDETemplId() == null) {
            return null;
        }
        Integer n = this.objPSDynaDETemplLock;
        synchronized (n) {
            if (this.psdynadetempl != null && DataTypeHelper.compare((int)25, (Object)this.getPSDynaDETemplId(), (Object)this.psdynadetempl.getPSDynaDETemplId()) != 0L) {
                this.psdynadetempl = null;
            }
            if (this.psdynadetempl == null) {
                PSDynaDETempl pSDynaDETempl = new PSDynaDETempl();
                pSDynaDETempl.setPSDynaDETemplId(this.getPSDynaDETemplId());
                PSDynaDETemplService pSDynaDETemplService = (PSDynaDETemplService)ServiceGlobal.getService(PSDynaDETemplService.class, (SessionFactory)this.getSessionFactory());
                pSDynaDETemplService.autoGet(pSDynaDETempl);
                this.psdynadetempl = pSDynaDETempl;
            }
            return this.psdynadetempl;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSHelpModule getPSHelpModule() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpModule();
        }
        if (this.getPSHelpModuleId() == null) {
            return null;
        }
        Integer n = this.objPSHelpModuleLock;
        synchronized (n) {
            if (this.pshelpmodule != null && DataTypeHelper.compare((int)25, (Object)this.getPSHelpModuleId(), (Object)this.pshelpmodule.getPSHelpModuleId()) != 0L) {
                this.pshelpmodule = null;
            }
            if (this.pshelpmodule == null) {
                PSHelpModule pSHelpModule = new PSHelpModule();
                pSHelpModule.setPSHelpModuleId(this.getPSHelpModuleId());
                PSHelpModuleService pSHelpModuleService = (PSHelpModuleService)ServiceGlobal.getService(PSHelpModuleService.class, (SessionFactory)this.getSessionFactory());
                pSHelpModuleService.autoGet(pSHelpModule);
                this.pshelpmodule = pSHelpModule;
            }
            return this.pshelpmodule;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getLNPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLNPSLanRes();
        }
        if (this.getLNPSLanResId() == null) {
            return null;
        }
        Integer n = this.objLNPSLanResLock;
        synchronized (n) {
            if (this.lnpslanres != null && DataTypeHelper.compare((int)25, (Object)this.getLNPSLanResId(), (Object)this.lnpslanres.getPSLanguageResId()) != 0L) {
                this.lnpslanres = null;
            }
            if (this.lnpslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getLNPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet(pSLanguageRes);
                this.lnpslanres = pSLanguageRes;
            }
            return this.lnpslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSModule getPSModule() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModule();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        Integer n = this.objPSModuleLock;
        synchronized (n) {
            if (this.psmodule != null && DataTypeHelper.compare((int)25, (Object)this.getPSModuleId(), (Object)this.psmodule.getPSModuleId()) != 0L) {
                this.psmodule = null;
            }
            if (this.psmodule == null) {
                PSModule pSModule = new PSModule();
                pSModule.setPSModuleId(this.getPSModuleId());
                PSModuleService pSModuleService = (PSModuleService)ServiceGlobal.getService(PSModuleService.class, (SessionFactory)this.getSessionFactory());
                pSModuleService.autoGet(pSModule);
                this.psmodule = pSModule;
            }
            return this.psmodule;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSubSysSADE getPSSubSysSADE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysSADE();
        }
        if (this.getPSSubSysSADEId() == null) {
            return null;
        }
        Integer n = this.objPSSubSysSADELock;
        synchronized (n) {
            if (this.pssubsyssade != null && DataTypeHelper.compare((int)25, (Object)this.getPSSubSysSADEId(), (Object)this.pssubsyssade.getPSSubSysSADEId()) != 0L) {
                this.pssubsyssade = null;
            }
            if (this.pssubsyssade == null) {
                PSSubSysSADE pSSubSysSADE = new PSSubSysSADE();
                pSSubSysSADE.setPSSubSysSADEId(this.getPSSubSysSADEId());
                PSSubSysSADEService pSSubSysSADEService = (PSSubSysSADEService)ServiceGlobal.getService(PSSubSysSADEService.class, (SessionFactory)this.getSessionFactory());
                pSSubSysSADEService.autoGet(pSSubSysSADE);
                this.pssubsyssade = pSSubSysSADE;
            }
            return this.pssubsyssade;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSubSysServiceAPI getPSSubSysServiceAPI() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysServiceAPI();
        }
        if (this.getPSSubSysServiceAPIId() == null) {
            return null;
        }
        Integer n = this.objPSSubSysServiceAPILock;
        synchronized (n) {
            if (this.pssubsysserviceapi != null && DataTypeHelper.compare((int)25, (Object)this.getPSSubSysServiceAPIId(), (Object)this.pssubsysserviceapi.getPSSubSysServiceAPIId()) != 0L) {
                this.pssubsysserviceapi = null;
            }
            if (this.pssubsysserviceapi == null) {
                PSSubSysServiceAPI pSSubSysServiceAPI = new PSSubSysServiceAPI();
                pSSubSysServiceAPI.setPSSubSysServiceAPIId(this.getPSSubSysServiceAPIId());
                PSSubSysServiceAPIService pSSubSysServiceAPIService = (PSSubSysServiceAPIService)ServiceGlobal.getService(PSSubSysServiceAPIService.class, (SessionFactory)this.getSessionFactory());
                pSSubSysServiceAPIService.autoGet(pSSubSysServiceAPI);
                this.pssubsysserviceapi = pSSubSysServiceAPI;
            }
            return this.pssubsysserviceapi;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDynaModel getPSSysDynaModel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModel();
        }
        if (this.getPSSysDynaModelId() == null) {
            return null;
        }
        Integer n = this.objPSSysDynaModelLock;
        synchronized (n) {
            if (this.pssysdynamodel != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysDynaModelId(), (Object)this.pssysdynamodel.getPSSysDynaModelId()) != 0L) {
                this.pssysdynamodel = null;
            }
            if (this.pssysdynamodel == null) {
                PSSysDynaModel pSSysDynaModel = new PSSysDynaModel();
                pSSysDynaModel.setPSSysDynaModelId(this.getPSSysDynaModelId());
                PSSysDynaModelService pSSysDynaModelService = (PSSysDynaModelService)ServiceGlobal.getService(PSSysDynaModelService.class, (SessionFactory)this.getSessionFactory());
                pSSysDynaModelService.autoGet(pSSysDynaModel);
                this.pssysdynamodel = pSSysDynaModel;
            }
            return this.pssysdynamodel;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysImage getPSSysImage() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysImage();
        }
        if (this.getPSSysImageId() == null) {
            return null;
        }
        Integer n = this.objPSSysImageLock;
        synchronized (n) {
            if (this.pssysimage != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysImageId(), (Object)this.pssysimage.getPSSysImageId()) != 0L) {
                this.pssysimage = null;
            }
            if (this.pssysimage == null) {
                PSSysImage pSSysImage = new PSSysImage();
                pSSysImage.setPSSysImageId(this.getPSSysImageId());
                PSSysImageService pSSysImageService = (PSSysImageService)ServiceGlobal.getService(PSSysImageService.class, (SessionFactory)this.getSessionFactory());
                pSSysImageService.autoGet(pSSysImage);
                this.pssysimage = pSSysImage;
            }
            return this.pssysimage;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysModelGroup getPSSysModelGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelGroup();
        }
        if (this.getPSSysModelGroupId() == null) {
            return null;
        }
        Integer n = this.objPSSysModelGroupLock;
        synchronized (n) {
            if (this.pssysmodelgroup != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysModelGroupId(), (Object)this.pssysmodelgroup.getPSSysModelGroupId()) != 0L) {
                this.pssysmodelgroup = null;
            }
            if (this.pssysmodelgroup == null) {
                PSSysModelGroup pSSysModelGroup = new PSSysModelGroup();
                pSSysModelGroup.setPSSysModelGroupId(this.getPSSysModelGroupId());
                PSSysModelGroupService pSSysModelGroupService = (PSSysModelGroupService)ServiceGlobal.getService(PSSysModelGroupService.class, (SessionFactory)this.getSessionFactory());
                pSSysModelGroupService.autoGet(pSSysModelGroup);
                this.pssysmodelgroup = pSSysModelGroup;
            }
            return this.pssysmodelgroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysReqItem getPSSysReqItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItem();
        }
        if (this.getPSSysReqItemId() == null) {
            return null;
        }
        Integer n = this.objPSSysReqItemLock;
        synchronized (n) {
            if (this.pssysreqitem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysReqItemId(), (Object)this.pssysreqitem.getPSSysReqItemId()) != 0L) {
                this.pssysreqitem = null;
            }
            if (this.pssysreqitem == null) {
                PSSysReqItem pSSysReqItem = new PSSysReqItem();
                pSSysReqItem.setPSSysReqItemId(this.getPSSysReqItemId());
                PSSysReqItemService pSSysReqItemService = (PSSysReqItemService)ServiceGlobal.getService(PSSysReqItemService.class, (SessionFactory)this.getSessionFactory());
                pSSysReqItemService.autoGet(pSSysReqItem);
                this.pssysreqitem = pSSysReqItem;
            }
            return this.pssysreqitem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysSFPlugin getPSSysSFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPlugin();
        }
        if (this.getPSSysSFPluginId() == null) {
            return null;
        }
        Integer n = this.objPSSysSFPluginLock;
        synchronized (n) {
            if (this.pssyssfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysSFPluginId(), (Object)this.pssyssfplugin.getPSSysSFPluginId()) != 0L) {
                this.pssyssfplugin = null;
            }
            if (this.pssyssfplugin == null) {
                PSSysSFPlugin pSSysSFPlugin = new PSSysSFPlugin();
                pSSysSFPlugin.setPSSysSFPluginId(this.getPSSysSFPluginId());
                PSSysSFPluginService pSSysSFPluginService = (PSSysSFPluginService)ServiceGlobal.getService(PSSysSFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysSFPluginService.autoGet(pSSysSFPlugin);
                this.pssyssfplugin = pSSysSFPlugin;
            }
            return this.pssyssfplugin;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSystem getPSSystem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystem();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        Integer n = this.objPSSystemLock;
        synchronized (n) {
            if (this.pssystem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSystemId(), (Object)this.pssystem.getPSSystemId()) != 0L) {
                this.pssystem = null;
            }
            if (this.pssystem == null) {
                PSSystem pSSystem = new PSSystem();
                pSSystem.setPSSystemId(this.getPSSystemId());
                PSSystemService pSSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)this.getSessionFactory());
                pSSystemService.autoGet(pSSystem);
                this.pssystem = pSSystem;
            }
            return this.pssystem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysUniRes getPSSysUniRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUniRes();
        }
        if (this.getPSSysUniResId() == null) {
            return null;
        }
        Integer n = this.objPSSysUniResLock;
        synchronized (n) {
            if (this.pssysunires != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysUniResId(), (Object)this.pssysunires.getPSSysUniResId()) != 0L) {
                this.pssysunires = null;
            }
            if (this.pssysunires == null) {
                PSSysUniRes pSSysUniRes = new PSSysUniRes();
                pSSysUniRes.setPSSysUniResId(this.getPSSysUniResId());
                PSSysUniResService pSSysUniResService = (PSSysUniResService)ServiceGlobal.getService(PSSysUniResService.class, (SessionFactory)this.getSessionFactory());
                pSSysUniResService.autoGet(pSSysUniRes);
                this.pssysunires = pSSysUniRes;
            }
            return this.pssysunires;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSACHandler> getPSACHandlers() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSACHandlers();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSACHandlerService pSACHandlerService = (PSACHandlerService)ServiceGlobal.getService(PSACHandlerService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSACHandlersLock;
        synchronized (n) {
            if (this.psachandlers == null) {
                this.psachandlers = pSACHandlerService.selectByPSDE(this);
            }
            return this.psachandlers;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSCodeList> getPSCodeLists() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeLists();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSCodeListService pSCodeListService = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSCodeListsLock;
        synchronized (n) {
            if (this.pscodelists == null) {
                this.pscodelists = pSCodeListService.selectByPSDE(this);
            }
            return this.pscodelists;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSCtrlLogicGroup> getPSCtrlLogicGroups() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlLogicGroups();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSCtrlLogicGroupService pSCtrlLogicGroupService = (PSCtrlLogicGroupService)ServiceGlobal.getService(PSCtrlLogicGroupService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSCtrlLogicGroupsLock;
        synchronized (n) {
            if (this.psctrllogicgroups == null) {
                this.psctrllogicgroups = pSCtrlLogicGroupService.selectByPSDE(this);
            }
            return this.psctrllogicgroups;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEACMode> getPSDEACModes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEACModes();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSDEACModeService pSDEACModeService = (PSDEACModeService)ServiceGlobal.getService(PSDEACModeService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEACModesLock;
        synchronized (n) {
            if (this.psdeacmodes == null) {
                this.psdeacmodes = pSDEACModeService.selectByPSDE(this);
            }
            return this.psdeacmodes;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEActionGroup> getPSDEActionGroups() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionGroups();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSDEActionGroupService pSDEActionGroupService = (PSDEActionGroupService)ServiceGlobal.getService(PSDEActionGroupService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEActionGroupsLock;
        synchronized (n) {
            if (this.psdeactiongroups == null) {
                this.psdeactiongroups = pSDEActionGroupService.selectByPSDE(this);
            }
            return this.psdeactiongroups;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEActionLogic> getDstPSDEActionLogics() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEActionLogics();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSDEActionLogicService pSDEActionLogicService = (PSDEActionLogicService)ServiceGlobal.getService(PSDEActionLogicService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objDstPSDEActionLogicsLock;
        synchronized (n) {
            if (this.dstpsdeactionlogics == null) {
                this.dstpsdeactionlogics = pSDEActionLogicService.selectByDstPSDE(this);
            }
            return this.dstpsdeactionlogics;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEActionLogic> getPSDEActionLogics() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionLogics();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSDEActionLogicService pSDEActionLogicService = (PSDEActionLogicService)ServiceGlobal.getService(PSDEActionLogicService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEActionLogicsLock;
        synchronized (n) {
            if (this.psdeactionlogics == null) {
                this.psdeactionlogics = pSDEActionLogicService.selectByPSDE(this);
            }
            return this.psdeactionlogics;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEActionWizard> getPSDEAWs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEAWs();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSDEActionWizardService pSDEActionWizardService = (PSDEActionWizardService)ServiceGlobal.getService(PSDEActionWizardService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEAWsLock;
        synchronized (n) {
            if (this.psdeaws == null) {
                this.psdeaws = pSDEActionWizardService.selectByPSDE(this);
            }
            return this.psdeaws;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEAction> getPSDEActions() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActions();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEActionsLock;
        synchronized (n) {
            if (this.psdeactions == null) {
                this.psdeactions = pSDEActionService.selectByPSDE(this);
            }
            return this.psdeactions;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEAWGroup> getPSDEAWGroups() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEAWGroups();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSDEAWGroupService pSDEAWGroupService = (PSDEAWGroupService)ServiceGlobal.getService(PSDEAWGroupService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEAWGroupsLock;
        synchronized (n) {
            if (this.psdeawgroups == null) {
                this.psdeawgroups = pSDEAWGroupService.selectByPSDE(this);
            }
            return this.psdeawgroups;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEChart> getPSDECharts() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDECharts();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSDEChartService pSDEChartService = (PSDEChartService)ServiceGlobal.getService(PSDEChartService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEChartsLock;
        synchronized (n) {
            if (this.psdecharts == null) {
                this.psdecharts = pSDEChartService.selectByPSDE(this);
            }
            return this.psdecharts;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEDataExp> getPSDEDataExps() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataExps();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSDEDataExpService pSDEDataExpService = (PSDEDataExpService)ServiceGlobal.getService(PSDEDataExpService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEDataExpsLock;
        synchronized (n) {
            if (this.psdedataexps == null) {
                this.psdedataexps = pSDEDataExpService.selectByPSDE(this);
            }
            return this.psdedataexps;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEDataImp> getPSDEDataImps() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataImps();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSDEDataImpService pSDEDataImpService = (PSDEDataImpService)ServiceGlobal.getService(PSDEDataImpService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEDataImpsLock;
        synchronized (n) {
            if (this.psdedataimps == null) {
                this.psdedataimps = pSDEDataImpService.selectByPSDE(this);
            }
            return this.psdedataimps;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEDataQuery> getPSDEDataQueries() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataQueries();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSDEDataQueryService pSDEDataQueryService = (PSDEDataQueryService)ServiceGlobal.getService(PSDEDataQueryService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEDataQueriesLock;
        synchronized (n) {
            if (this.psdedataqueries == null) {
                this.psdedataqueries = pSDEDataQueryService.selectByPSDE(this);
            }
            return this.psdedataqueries;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEDataRelation> getPSDEDataRelations() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataRelations();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSDEDataRelationService pSDEDataRelationService = (PSDEDataRelationService)ServiceGlobal.getService(PSDEDataRelationService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEDataRelationsLock;
        synchronized (n) {
            if (this.psdedatarelations == null) {
                this.psdedatarelations = pSDEDataRelationService.selectByPSDE(this);
            }
            return this.psdedatarelations;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEDataSet> getPSDEDataSets() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataSets();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEDataSetsLock;
        synchronized (n) {
            if (this.psdedatasets == null) {
                this.psdedatasets = pSDEDataSetService.selectByPSDE(this);
            }
            return this.psdedatasets;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEDataSync> getPSDEDataSyncs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataSyncs();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSDEDataSyncService pSDEDataSyncService = (PSDEDataSyncService)ServiceGlobal.getService(PSDEDataSyncService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEDataSyncsLock;
        synchronized (n) {
            if (this.psdedatasyncs == null) {
                this.psdedatasyncs = pSDEDataSyncService.selectByPSDE(this);
            }
            return this.psdedatasyncs;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEDataView> getPSDEDataViews() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataViews();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSDEDataViewService pSDEDataViewService = (PSDEDataViewService)ServiceGlobal.getService(PSDEDataViewService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEDataViewsLock;
        synchronized (n) {
            if (this.psdedataviews == null) {
                this.psdedataviews = pSDEDataViewService.selectByPSDE(this);
            }
            return this.psdedataviews;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEDBCfg> getPSDEDBCfgs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDBCfgs();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSDEDBCfgService pSDEDBCfgService = (PSDEDBCfgService)ServiceGlobal.getService(PSDEDBCfgService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEDBCfgsLock;
        synchronized (n) {
            if (this.psdedbcfgs == null) {
                this.psdedbcfgs = pSDEDBCfgService.selectByPSDE(this);
            }
            return this.psdedbcfgs;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEDBIndex> getPSDEDBIndexs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDBIndexs();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSDEDBIndexService pSDEDBIndexService = (PSDEDBIndexService)ServiceGlobal.getService(PSDEDBIndexService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEDBIndexsLock;
        synchronized (n) {
            if (this.psdedbindexs == null) {
                this.psdedbindexs = pSDEDBIndexService.selectByPSDE(this);
            }
            return this.psdedbindexs;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEDRGroup> getPSDEDRGroups() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDRGroups();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSDEDRGroupService pSDEDRGroupService = (PSDEDRGroupService)ServiceGlobal.getService(PSDEDRGroupService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEDRGroupsLock;
        synchronized (n) {
            if (this.psdedrgroups == null) {
                this.psdedrgroups = pSDEDRGroupService.selectByPSDE(this);
            }
            return this.psdedrgroups;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEDRItem> getPSDEDRItems() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDRItems();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSDEDRItemService pSDEDRItemService = (PSDEDRItemService)ServiceGlobal.getService(PSDEDRItemService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEDRItemsLock;
        synchronized (n) {
            if (this.psdedritems == null) {
                this.psdedritems = pSDEDRItemService.selectByPSDE(this);
            }
            return this.psdedritems;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEDTSQueue> getPSDTSQueues() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDTSQueues();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSDEDTSQueueService pSDEDTSQueueService = (PSDEDTSQueueService)ServiceGlobal.getService(PSDEDTSQueueService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDTSQueuesLock;
        synchronized (n) {
            if (this.psdtsqueues == null) {
                this.psdtsqueues = pSDEDTSQueueService.selectByPSDE(this);
            }
            return this.psdtsqueues;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEFGroup> getPSDEFGroups() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFGroups();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSDEFGroupService pSDEFGroupService = (PSDEFGroupService)ServiceGlobal.getService(PSDEFGroupService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEFGroupsLock;
        synchronized (n) {
            if (this.psdefgroups == null) {
                this.psdefgroups = pSDEFGroupService.selectByPSDE(this);
            }
            return this.psdefgroups;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEField> getPSDEFields() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFields();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEFieldsLock;
        synchronized (n) {
            if (this.psdefields == null) {
                this.psdefields = pSDEFieldService.selectByPSDE(this);
            }
            return this.psdefields;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEForm> getPSDEForms() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEForms();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSDEFormService pSDEFormService = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEFormsLock;
        synchronized (n) {
            if (this.psdeforms == null) {
                this.psdeforms = pSDEFormService.selectByPSDE(this);
            }
            return this.psdeforms;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEFSFItem> getPSDEFSFItems() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFSFItems();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSDEFSFItemService pSDEFSFItemService = (PSDEFSFItemService)ServiceGlobal.getService(PSDEFSFItemService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEFSFItemsLock;
        synchronized (n) {
            if (this.psdefsfitems == null) {
                this.psdefsfitems = pSDEFSFItemService.selectByPSDE(this);
            }
            return this.psdefsfitems;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEFValueRule> getPSDEFValueRules() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFValueRules();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSDEFValueRuleService pSDEFValueRuleService = (PSDEFValueRuleService)ServiceGlobal.getService(PSDEFValueRuleService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEFValueRulesLock;
        synchronized (n) {
            if (this.psdefvaluerules == null) {
                this.psdefvaluerules = pSDEFValueRuleService.selectByPSDE(this);
            }
            return this.psdefvaluerules;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEGrid> getPSDEGrids() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGrids();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSDEGridService pSDEGridService = (PSDEGridService)ServiceGlobal.getService(PSDEGridService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEGridsLock;
        synchronized (n) {
            if (this.psdegrids == null) {
                this.psdegrids = pSDEGridService.selectByPSDE(this);
            }
            return this.psdegrids;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEGroup> getPSDEGroups() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGroups();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSDEGroupService pSDEGroupService = (PSDEGroupService)ServiceGlobal.getService(PSDEGroupService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEGroupsLock;
        synchronized (n) {
            if (this.psdegroups == null) {
                this.psdegroups = pSDEGroupService.selectByPSDE(this);
            }
            return this.psdegroups;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEList> getPSDELists() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELists();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSDEListService pSDEListService = (PSDEListService)ServiceGlobal.getService(PSDEListService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEListsLock;
        synchronized (n) {
            if (this.psdelists == null) {
                this.psdelists = pSDEListService.selectByPSDE(this);
            }
            return this.psdelists;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDELogic> getPSDELogics() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELogics();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSDELogicService pSDELogicService = (PSDELogicService)ServiceGlobal.getService(PSDELogicService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDELogicsLock;
        synchronized (n) {
            if (this.psdelogics == null) {
                this.psdelogics = pSDELogicService.selectByPSDE(this);
            }
            return this.psdelogics;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEMainState> getPSDEMainStates() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMainStates();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSDEMainStateService pSDEMainStateService = (PSDEMainStateService)ServiceGlobal.getService(PSDEMainStateService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEMainStatesLock;
        synchronized (n) {
            if (this.psdemainstates == null) {
                this.psdemainstates = pSDEMainStateService.selectByPSDE(this);
            }
            return this.psdemainstates;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEMap> getPSDEMaps() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMaps();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSDEMapService pSDEMapService = (PSDEMapService)ServiceGlobal.getService(PSDEMapService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEMapsLock;
        synchronized (n) {
            if (this.psdemaps == null) {
                this.psdemaps = pSDEMapService.selectByDstPSDE(this);
            }
            return this.psdemaps;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEMap> getSrcPSDEMaps() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcPSDEMaps();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSDEMapService pSDEMapService = (PSDEMapService)ServiceGlobal.getService(PSDEMapService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objSrcPSDEMapsLock;
        synchronized (n) {
            if (this.srcpsdemaps == null) {
                this.srcpsdemaps = pSDEMapService.selectByPSDE(this);
            }
            return this.srcpsdemaps;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEModel> getPSDEModels() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEModels();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSDEModelService pSDEModelService = (PSDEModelService)ServiceGlobal.getService(PSDEModelService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEModelsLock;
        synchronized (n) {
            if (this.psdemodels == null) {
                this.psdemodels = pSDEModelService.selectByPSDE(this);
            }
            return this.psdemodels;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDENotify> getPSDENotifies() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDENotifies();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSDENotifyService pSDENotifyService = (PSDENotifyService)ServiceGlobal.getService(PSDENotifyService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDENotifiesLock;
        synchronized (n) {
            if (this.psdenotifies == null) {
                this.psdenotifies = pSDENotifyService.selectByPSDE(this);
            }
            return this.psdenotifies;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEOPPrivRole> getPSDEOPPrivRoles() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEOPPrivRoles();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSDEOPPrivRoleService pSDEOPPrivRoleService = (PSDEOPPrivRoleService)ServiceGlobal.getService(PSDEOPPrivRoleService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEOPPrivRolesLock;
        synchronized (n) {
            if (this.psdeopprivroles == null) {
                this.psdeopprivroles = pSDEOPPrivRoleService.selectByPSDE(this);
            }
            return this.psdeopprivroles;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEOPPriv> getPSDEOPPrivs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEOPPrivs();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSDEOPPrivService pSDEOPPrivService = (PSDEOPPrivService)ServiceGlobal.getService(PSDEOPPrivService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEOPPrivsLock;
        synchronized (n) {
            if (this.psdeopprivs == null) {
                this.psdeopprivs = pSDEOPPrivService.selectByPSDE(this);
            }
            return this.psdeopprivs;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEPrint> getPSDEPrints() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEPrints();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSDEPrintService pSDEPrintService = (PSDEPrintService)ServiceGlobal.getService(PSDEPrintService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEPrintsLock;
        synchronized (n) {
            if (this.psdeprints == null) {
                this.psdeprints = pSDEPrintService.selectByPSDE(this);
            }
            return this.psdeprints;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEReport> getPSDEReports() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEReports();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSDEReportService pSDEReportService = (PSDEReportService)ServiceGlobal.getService(PSDEReportService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEReportsLock;
        synchronized (n) {
            if (this.psdereports == null) {
                this.psdereports = pSDEReportService.selectByPSDE(this);
            }
            return this.psdereports;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDERGroup> getPSDERGroups() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDERGroups();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSDERGroupService pSDERGroupService = (PSDERGroupService)ServiceGlobal.getService(PSDERGroupService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDERGroupsLock;
        synchronized (n) {
            if (this.psdergroups == null) {
                this.psdergroups = pSDERGroupService.selectByPSDE(this);
            }
            return this.psdergroups;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDER> getMajorPSDERs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorPSDERs();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSDERService pSDERService = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objMajorPSDERsLock;
        synchronized (n) {
            if (this.majorpsders == null) {
                this.majorpsders = pSDERService.selectByMajorPSDE(this);
            }
            return this.majorpsders;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDER> getMinorPSDERs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorPSDERs();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSDERService pSDERService = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objMinorPSDERsLock;
        synchronized (n) {
            if (this.minorpsders == null) {
                this.minorpsders = pSDERService.selectByMinorPSDE(this);
            }
            return this.minorpsders;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEServiceAPI> getPSDEServiceAPIs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEServiceAPIs();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSDEServiceAPIService pSDEServiceAPIService = (PSDEServiceAPIService)ServiceGlobal.getService(PSDEServiceAPIService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEServiceAPIsLock;
        synchronized (n) {
            if (this.psdeserviceapis == null) {
                this.psdeserviceapis = pSDEServiceAPIService.selectByPSDE(this);
            }
            return this.psdeserviceapis;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDETable> getPSDETables() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETables();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSDETableService pSDETableService = (PSDETableService)ServiceGlobal.getService(PSDETableService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDETablesLock;
        synchronized (n) {
            if (this.psdetables == null) {
                this.psdetables = pSDETableService.selectByPSDE(this);
            }
            return this.psdetables;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEToolbar> getPSDEToolbars() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEToolbars();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSDEToolbarService pSDEToolbarService = (PSDEToolbarService)ServiceGlobal.getService(PSDEToolbarService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEToolbarsLock;
        synchronized (n) {
            if (this.psdetoolbars == null) {
                this.psdetoolbars = pSDEToolbarService.selectByPSDE(this);
            }
            return this.psdetoolbars;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDETreeView> getPSDETreeViews() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETreeViews();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSDETreeViewService pSDETreeViewService = (PSDETreeViewService)ServiceGlobal.getService(PSDETreeViewService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDETreeViewsLock;
        synchronized (n) {
            if (this.psdetreeviews == null) {
                this.psdetreeviews = pSDETreeViewService.selectByPSDE(this);
            }
            return this.psdetreeviews;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEUAGroup> getPSDEUAGroups() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUAGroups();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSDEUAGroupService pSDEUAGroupService = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEUAGroupsLock;
        synchronized (n) {
            if (this.psdeuagroups == null) {
                this.psdeuagroups = pSDEUAGroupService.selectByPSDE(this);
            }
            return this.psdeuagroups;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEUIAction> getPSDEUIActions() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUIActions();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSDEUIActionService pSDEUIActionService = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEUIActionsLock;
        synchronized (n) {
            if (this.psdeuiactions == null) {
                this.psdeuiactions = pSDEUIActionService.selectByPSDE(this);
            }
            return this.psdeuiactions;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEUserRole> getPSDEUserRoles() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUserRoles();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSDEUserRoleService pSDEUserRoleService = (PSDEUserRoleService)ServiceGlobal.getService(PSDEUserRoleService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEUserRolesLock;
        synchronized (n) {
            if (this.psdeuserroles == null) {
                this.psdeuserroles = pSDEUserRoleService.selectByPSDE(this);
            }
            return this.psdeuserroles;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEUtilDE> getPSDEUtilDEs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUtilDEs();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSDEUtilDEService pSDEUtilDEService = (PSDEUtilDEService)ServiceGlobal.getService(PSDEUtilDEService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEUtilDEsLock;
        synchronized (n) {
            if (this.psdeutildes == null) {
                this.psdeutildes = pSDEUtilDEService.selectByPSDE(this);
            }
            return this.psdeutildes;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEViewBase> getPSDEViewBases() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBases();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEViewBasesLock;
        synchronized (n) {
            if (this.psdeviewbases == null) {
                this.psdeviewbases = pSDEViewBaseService.selectByPSDE(this);
            }
            return this.psdeviewbases;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEVRGroup> getPSDEVRGroups() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEVRGroups();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSDEVRGroupService pSDEVRGroupService = (PSDEVRGroupService)ServiceGlobal.getService(PSDEVRGroupService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEVRGroupsLock;
        synchronized (n) {
            if (this.psdevrgroups == null) {
                this.psdevrgroups = pSDEVRGroupService.selectByPSDE(this);
            }
            return this.psdevrgroups;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEWizard> getPSDEWizards() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEWizards();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSDEWizardService pSDEWizardService = (PSDEWizardService)ServiceGlobal.getService(PSDEWizardService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEWizardsLock;
        synchronized (n) {
            if (this.psdewizards == null) {
                this.psdewizards = pSDEWizardService.selectByPSDE(this);
            }
            return this.psdewizards;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSHelpResource> getPSHelpResources() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpResources();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSHelpResourceService pSHelpResourceService = (PSHelpResourceService)ServiceGlobal.getService(PSHelpResourceService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSHelpResourcesLock;
        synchronized (n) {
            if (this.pshelpresources == null) {
                this.pshelpresources = pSHelpResourceService.selectByPSDE(this);
            }
            return this.pshelpresources;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysBDTable> getPSSysBDTables() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDTables();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSSysBDTableService pSSysBDTableService = (PSSysBDTableService)ServiceGlobal.getService(PSSysBDTableService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysBDTablesLock;
        synchronized (n) {
            if (this.pssysbdtables == null) {
                this.pssysbdtables = pSSysBDTableService.selectByPSDE(this);
            }
            return this.pssysbdtables;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysCounter> getPSSysCounters() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCounters();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSSysCounterService pSSysCounterService = (PSSysCounterService)ServiceGlobal.getService(PSSysCounterService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysCountersLock;
        synchronized (n) {
            if (this.pssyscounters == null) {
                this.pssyscounters = pSSysCounterService.selectByPSDE(this);
            }
            return this.pssyscounters;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysDashboard> getPSSysDashboards() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDashboards();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSSysDashboardService pSSysDashboardService = (PSSysDashboardService)ServiceGlobal.getService(PSSysDashboardService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysDashboardsLock;
        synchronized (n) {
            if (this.pssysdashboards == null) {
                this.pssysdashboards = pSSysDashboardService.selectByPSDE(this);
            }
            return this.pssysdashboards;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysModelChgLog> getPSSysModelChgLogs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelChgLogs();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSSysModelChgLogService pSSysModelChgLogService = (PSSysModelChgLogService)ServiceGlobal.getService(PSSysModelChgLogService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysModelChgLogsLock;
        synchronized (n) {
            if (this.pssysmodelchglogs == null) {
                this.pssysmodelchglogs = pSSysModelChgLogService.selectByPSDE(this);
            }
            return this.pssysmodelchglogs;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysDMItem> getPSSysDMItems() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDMItems();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSSysDMItemService pSSysDMItemService = (PSSysDMItemService)ServiceGlobal.getService(PSSysDMItemService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysDMItemsLock;
        synchronized (n) {
            if (this.pssysdmitems == null) {
                this.pssysdmitems = pSSysDMItemService.selectByPSDE(this);
            }
            return this.pssysdmitems;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysDMVerItem> getPSSysDMVerItems() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDMVerItems();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSSysDMVerItemService pSSysDMVerItemService = (PSSysDMVerItemService)ServiceGlobal.getService(PSSysDMVerItemService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysDMVerItemsLock;
        synchronized (n) {
            if (this.pssysdmveritems == null) {
                this.pssysdmveritems = pSSysDMVerItemService.selectByPSDE(this);
            }
            return this.pssysdmveritems;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysMapView> getPSSysMapViews() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMapViews();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSSysMapViewService pSSysMapViewService = (PSSysMapViewService)ServiceGlobal.getService(PSSysMapViewService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysMapViewsLock;
        synchronized (n) {
            if (this.pssysmapviews == null) {
                this.pssysmapviews = pSSysMapViewService.selectByPSDE(this);
            }
            return this.pssysmapviews;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysSearchBar> getPSSysSearchBars() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchBars();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSSysSearchBarService pSSysSearchBarService = (PSSysSearchBarService)ServiceGlobal.getService(PSSysSearchBarService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysSearchBarsLock;
        synchronized (n) {
            if (this.pssyssearchbars == null) {
                this.pssyssearchbars = pSSysSearchBarService.selectByPSDE(this);
            }
            return this.pssyssearchbars;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysSearchDE> getPSSysSearchDEs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchDEs();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSSysSearchDEService pSSysSearchDEService = (PSSysSearchDEService)ServiceGlobal.getService(PSSysSearchDEService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysSearchDEsLock;
        synchronized (n) {
            if (this.pssyssearchdes == null) {
                this.pssyssearchdes = pSSysSearchDEService.selectByPSDE(this);
            }
            return this.pssyssearchdes;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysTask> getPSSysTasks() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTasks();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSSysTaskService pSSysTaskService = (PSSysTaskService)ServiceGlobal.getService(PSSysTaskService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysTasksLock;
        synchronized (n) {
            if (this.pssystasks == null) {
                this.pssystasks = pSSysTaskService.selectByPSDE(this);
            }
            return this.pssystasks;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysTestCase> getPSSysTestCases() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTestCases();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSSysTestCaseService pSSysTestCaseService = (PSSysTestCaseService)ServiceGlobal.getService(PSSysTestCaseService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysTestCasesLock;
        synchronized (n) {
            if (this.pssystestcases == null) {
                this.pssystestcases = pSSysTestCaseService.selectByPSDE(this);
            }
            return this.pssystestcases;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysTestData> getPSSysTestDatas() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTestDatas();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSSysTestDataService pSSysTestDataService = (PSSysTestDataService)ServiceGlobal.getService(PSSysTestDataService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysTestDatasLock;
        synchronized (n) {
            if (this.pssystestdatas == null) {
                this.pssystestdatas = pSSysTestDataService.selectByPSDE(this);
            }
            return this.pssystestdatas;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysUniState> getPSSysUniStates() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUniStates();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSSysUniStateService pSSysUniStateService = (PSSysUniStateService)ServiceGlobal.getService(PSSysUniStateService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysUniStatesLock;
        synchronized (n) {
            if (this.pssysunistates == null) {
                this.pssysunistates = pSSysUniStateService.selectByPSDE(this);
            }
            return this.pssysunistates;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysUserCase> getPSSysUserCases() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUserCases();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSSysUserCaseService pSSysUserCaseService = (PSSysUserCaseService)ServiceGlobal.getService(PSSysUserCaseService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysUserCasesLock;
        synchronized (n) {
            if (this.pssysusercases == null) {
                this.pssysusercases = pSSysUserCaseService.selectByPSDE(this);
            }
            return this.pssysusercases;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysViewPanel> getPSSysViewPanels() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanels();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSSysViewPanelService pSSysViewPanelService = (PSSysViewPanelService)ServiceGlobal.getService(PSSysViewPanelService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysViewPanelsLock;
        synchronized (n) {
            if (this.pssysviewpanels == null) {
                this.pssysviewpanels = pSSysViewPanelService.selectByPSDE(this);
            }
            return this.pssysviewpanels;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSWFDE> getPSWFDEs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFDEs();
        }
        if (this.getPSDataEntityId() == null) {
            return null;
        }
        PSWFDEService pSWFDEService = (PSWFDEService)ServiceGlobal.getService(PSWFDEService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSWFDEsLock;
        synchronized (n) {
            if (this.pswfdes == null) {
                this.pswfdes = pSWFDEService.selectByPSDE(this);
            }
            return this.pswfdes;
        }
    }

    private PSDataEntityBase getProxyEntity() {
        return this.proxyPSDataEntityBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDataEntityBase = null;
        if (iDataObject != null && iDataObject instanceof PSDataEntityBase) {
            this.proxyPSDataEntityBase = (PSDataEntityBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ACCCTRLARCH, 0);
        fieldIndexMap.put(FIELD_AUDITMODE, 1);
        fieldIndexMap.put(FIELD_BASECLSPARAMS, 2);
        fieldIndexMap.put(FIELD_BIZTAG, 3);
        fieldIndexMap.put(FIELD_CODENAME, 4);
        fieldIndexMap.put(FIELD_CODENAMEMODE, 5);
        fieldIndexMap.put(FIELD_COLOR, 6);
        fieldIndexMap.put(FIELD_CREATEDATE, 7);
        fieldIndexMap.put(FIELD_CREATEMAN, 8);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 9);
        fieldIndexMap.put(FIELD_CUSTOMMODE, 10);
        fieldIndexMap.put(FIELD_DATAACCMODE, 11);
        fieldIndexMap.put(FIELD_DATACHGLOGMODE, 12);
        fieldIndexMap.put(FIELD_DATAIMPEXPFLAG, 13);
        fieldIndexMap.put(FIELD_DBTABSPACE, 14);
        fieldIndexMap.put(FIELD_DBVER, 15);
        fieldIndexMap.put(FIELD_DECAT, 16);
        fieldIndexMap.put(FIELD_DEHOLDER, 17);
        fieldIndexMap.put(FIELD_DELOCKFLAG, 18);
        fieldIndexMap.put(FIELD_DESN, 19);
        fieldIndexMap.put(FIELD_DETAG, 20);
        fieldIndexMap.put(FIELD_DETAG2, 21);
        fieldIndexMap.put(FIELD_DETYPE, 22);
        fieldIndexMap.put(FIELD_DSLINK, 23);
        fieldIndexMap.put(FIELD_DSTPSDEACTIONLOGICSCNT, 24);
        fieldIndexMap.put(FIELD_DYNAMICMODE, 25);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 26);
        fieldIndexMap.put(FIELD_DYNATABLEMODE, 27);
        fieldIndexMap.put(FIELD_ENABLEAUDIT, 28);
        fieldIndexMap.put(FIELD_ENABLEDALOG, 29);
        fieldIndexMap.put(FIELD_ENABLEDATAVER, 30);
        fieldIndexMap.put(FIELD_ENABLEDEACTION, 31);
        fieldIndexMap.put(FIELD_ENABLEDEDATASET, 32);
        fieldIndexMap.put(FIELD_ENABLEDYNASYS, 33);
        fieldIndexMap.put(FIELD_ENABLEENTITYCACHE, 34);
        fieldIndexMap.put(FIELD_ENABLEMOB, 35);
        fieldIndexMap.put(FIELD_ENABLEMULTIDS, 36);
        fieldIndexMap.put(FIELD_ENABLEOPNAMEMODEL, 37);
        fieldIndexMap.put(FIELD_ENABLEORGMODEL, 38);
        fieldIndexMap.put(FIELD_ENABLEPQL, 39);
        fieldIndexMap.put(FIELD_ENABLESELECT, 40);
        fieldIndexMap.put(FIELD_ENABLEWFMODEL, 41);
        fieldIndexMap.put(FIELD_ENAMULTIFORM, 42);
        fieldIndexMap.put(FIELD_ENATEMPDATA, 43);
        fieldIndexMap.put(FIELD_ENTITYCACHETIMEOUT, 44);
        fieldIndexMap.put(FIELD_EXISTINGMODEL, 45);
        fieldIndexMap.put(FIELD_EXTABLENAME, 46);
        fieldIndexMap.put(FIELD_INDEXDETYPE, 47);
        fieldIndexMap.put(FIELD_KEYRULE, 48);
        fieldIndexMap.put(FIELD_LNPSLANRESID, 49);
        fieldIndexMap.put(FIELD_LNPSLANRESNAME, 50);
        fieldIndexMap.put(FIELD_LOCKFLAG, 51);
        fieldIndexMap.put(FIELD_LOGICINVALIDVALUE, 52);
        fieldIndexMap.put(FIELD_LOGICNAME, 53);
        fieldIndexMap.put(FIELD_LOGICVALID, 54);
        fieldIndexMap.put(FIELD_LOGICVALIDVALUE, 55);
        fieldIndexMap.put(FIELD_MAJORPSDERSCNT, 56);
        fieldIndexMap.put(FIELD_MAXENTITYCACHECNT, 57);
        fieldIndexMap.put(FIELD_MEMO, 58);
        fieldIndexMap.put(FIELD_MINORPSDERSCNT, 59);
        fieldIndexMap.put(FIELD_MODCOLOR, 60);
        fieldIndexMap.put(FIELD_MODELIMPEXPFLAG, 61);
        fieldIndexMap.put(FIELD_MODELSTATE, 62);
        fieldIndexMap.put(FIELD_MODELVER, 63);
        fieldIndexMap.put(FIELD_MSACTIONLOGICFLAG, 64);
        fieldIndexMap.put(FIELD_NOVIEWMODE, 65);
        fieldIndexMap.put(FIELD_ORDERVALUE, 66);
        fieldIndexMap.put(FIELD_PSACHANDLERSCNT, 67);
        fieldIndexMap.put(FIELD_PSCODELISTSCNT, 68);
        fieldIndexMap.put(FIELD_PSDATAENTITYID, 69);
        fieldIndexMap.put(FIELD_PSDATAENTITYNAME, 70);
        fieldIndexMap.put(FIELD_PSDEACMODESCNT, 71);
        fieldIndexMap.put(FIELD_PSDEACTIONLOGICSCNT, 72);
        fieldIndexMap.put(FIELD_PSDEACTIONSCNT, 73);
        fieldIndexMap.put(FIELD_PSDEAWGRPSCNT, 74);
        fieldIndexMap.put(FIELD_PSDEAWSCNT, 75);
        fieldIndexMap.put(FIELD_PSDECHARTSCNT, 76);
        fieldIndexMap.put(FIELD_PSDEDATAEXPSCNT, 77);
        fieldIndexMap.put(FIELD_PSDEDATAIMPSCNT, 78);
        fieldIndexMap.put(FIELD_PSDEDATAQUERYSCNT, 79);
        fieldIndexMap.put(FIELD_PSDEDATARELATIONSCNT, 80);
        fieldIndexMap.put(FIELD_PSDEDATASETSCNT, 81);
        fieldIndexMap.put(FIELD_PSDEDATASYNCSCNT, 82);
        fieldIndexMap.put(FIELD_PSDEDATAVIEWSCNT, 83);
        fieldIndexMap.put(FIELD_PSDEDBCFGSCNT, 84);
        fieldIndexMap.put(FIELD_PSDEDBINDEXSCNT, 85);
        fieldIndexMap.put(FIELD_PSDEDRGROUPSCNT, 86);
        fieldIndexMap.put(FIELD_PSDEDRITEMSCNT, 87);
        fieldIndexMap.put(FIELD_PSDEDTSQUEUESCNT, 88);
        fieldIndexMap.put(FIELD_PSDEFIELDSCNT, 89);
        fieldIndexMap.put(FIELD_PSDEFINPUTTIPSETID, 90);
        fieldIndexMap.put(FIELD_PSDEFINPUTTIPSETNAME, 91);
        fieldIndexMap.put(FIELD_PSDEFORMSCNT, 92);
        fieldIndexMap.put(FIELD_PSDEFSFITEMSCNT, 93);
        fieldIndexMap.put(FIELD_PSDEFVALUERULESCNT, 94);
        fieldIndexMap.put(FIELD_PSDEGRIDSCNT, 95);
        fieldIndexMap.put(FIELD_PSDELISTSCNT, 96);
        fieldIndexMap.put(FIELD_PSDELOGICSCNT, 97);
        fieldIndexMap.put(FIELD_PSDEMAINSTATESCNT, 98);
        fieldIndexMap.put(FIELD_PSDEOPPRIVROLESCNT, 99);
        fieldIndexMap.put(FIELD_PSDEOPPRIVSCNT, 100);
        fieldIndexMap.put(FIELD_PSDEPRINTSCNT, 101);
        fieldIndexMap.put(FIELD_PSDEREPORTSCNT, 102);
        fieldIndexMap.put(FIELD_PSDESERVICEAPISCNT, 103);
        fieldIndexMap.put(FIELD_PSDETOOLBARSCNT, 104);
        fieldIndexMap.put(FIELD_PSDETREEVIEWSCNT, 105);
        fieldIndexMap.put(FIELD_PSDEUAGROUPSCNT, 106);
        fieldIndexMap.put(FIELD_PSDEUIACTIONSCNT, 107);
        fieldIndexMap.put(FIELD_PSDEUSERROLESCNT, 108);
        fieldIndexMap.put(FIELD_PSDEVIEWBASESCNT, 109);
        fieldIndexMap.put(FIELD_PSDEWIZARDSCNT, 110);
        fieldIndexMap.put(FIELD_PSDYNADETEMPLID, 111);
        fieldIndexMap.put(FIELD_PSDYNADETEMPLNAME, 112);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 113);
        fieldIndexMap.put(FIELD_PSHELPMODULEID, 114);
        fieldIndexMap.put(FIELD_PSHELPMODULENAME, 115);
        fieldIndexMap.put(FIELD_PSMODULEID, 116);
        fieldIndexMap.put(FIELD_PSMODULENAME, 117);
        fieldIndexMap.put(FIELD_PSSUBSYSSADEID, 118);
        fieldIndexMap.put(FIELD_PSSUBSYSSADENAME, 119);
        fieldIndexMap.put(FIELD_PSSUBSYSSERVICEAPIID, 120);
        fieldIndexMap.put(FIELD_PSSUBSYSSERVICEAPINAME, 121);
        fieldIndexMap.put(FIELD_PSSYSBDTABLESCNT, 122);
        fieldIndexMap.put(FIELD_PSSYSCOUNTERSCNT, 123);
        fieldIndexMap.put(FIELD_PSSYSDMITEMSCNT, 124);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 125);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 126);
        fieldIndexMap.put(FIELD_PSSYSIMAGEID, 127);
        fieldIndexMap.put(FIELD_PSSYSIMAGENAME, 128);
        fieldIndexMap.put(FIELD_PSSYSMODELCHGLOGSCNT, 129);
        fieldIndexMap.put(FIELD_PSSYSMODELGROUPID, 130);
        fieldIndexMap.put(FIELD_PSSYSMODELGROUPNAME, 131);
        fieldIndexMap.put(FIELD_PSSYSREQITEMID, 132);
        fieldIndexMap.put(FIELD_PSSYSREQITEMNAME, 133);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 134);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 135);
        fieldIndexMap.put(FIELD_PSSYSTASKSCNT, 136);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 137);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 138);
        fieldIndexMap.put(FIELD_PSSYSTESTCASESCNT, 139);
        fieldIndexMap.put(FIELD_PSSYSTESTDATASCNT, 140);
        fieldIndexMap.put(FIELD_PSSYSUNIRESID, 141);
        fieldIndexMap.put(FIELD_PSSYSUNIRESNAME, 142);
        fieldIndexMap.put(FIELD_PSWFDESCNT, 143);
        fieldIndexMap.put(FIELD_READONLYMODE, 144);
        fieldIndexMap.put(FIELD_REMOVEFLAG, 145);
        fieldIndexMap.put(FIELD_SAASMODE, 146);
        fieldIndexMap.put(FIELD_SERVICEAPIFLAG, 147);
        fieldIndexMap.put(FIELD_SERVICECODENAME, 148);
        fieldIndexMap.put(FIELD_SRCPSDEMAPSCNT, 149);
        fieldIndexMap.put(FIELD_STORAGEMODE, 150);
        fieldIndexMap.put(FIELD_SUBSYSDE, 151);
        fieldIndexMap.put(FIELD_SUBSYSMODULE, 152);
        fieldIndexMap.put(FIELD_SVRPUBMODE, 153);
        fieldIndexMap.put(FIELD_SYSTEMFLAG, 154);
        fieldIndexMap.put(FIELD_TABLENAME, 155);
        fieldIndexMap.put(FIELD_TESTCASEFLAG, 156);
        fieldIndexMap.put(FIELD_TODOTASK, 157);
        fieldIndexMap.put(FIELD_UPDATEDATE, 158);
        fieldIndexMap.put(FIELD_UPDATEMAN, 159);
        fieldIndexMap.put(FIELD_USERACTION, 160);
        fieldIndexMap.put(FIELD_USERCAT, 161);
        fieldIndexMap.put(FIELD_USERPARAMS, 162);
        fieldIndexMap.put(FIELD_USERTAG, 163);
        fieldIndexMap.put(FIELD_USERTAG2, 164);
        fieldIndexMap.put(FIELD_USERTAG3, 165);
        fieldIndexMap.put(FIELD_USERTAG4, 166);
        fieldIndexMap.put(FIELD_VALIDFLAG, 167);
        fieldIndexMap.put(FIELD_VIEWLEVEL, 168);
        fieldIndexMap.put(FIELD_VIEWNAME, 169);
        fieldIndexMap.put(FIELD_VIEWNAME2, 170);
        fieldIndexMap.put(FIELD_VIEWNAME3, 171);
        fieldIndexMap.put(FIELD_VIEWNAME4, 172);
        fieldIndexMap.put(FIELD_VIRTUALFLAG, 173);
        fieldIndexMap.put(FIELD_VKEYSEPARATOR, 174);
    }
}

