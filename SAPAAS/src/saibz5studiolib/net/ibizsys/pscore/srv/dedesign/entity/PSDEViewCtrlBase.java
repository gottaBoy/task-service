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
import net.ibizsys.pscore.srv.config.entity.PSPF;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.service.PSPFService;
import net.ibizsys.pscore.srv.config.service.PSSysPFPluginService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEChart;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataExp;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataImp;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataRelation;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataView;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEForm;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGrid;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEList;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPriv;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEReport;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbar;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeView;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEWizard;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataExpService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataImpService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataRelationService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEReportService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeViewService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSACHandler;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlLogicGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlMsg;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCalendar;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCounter;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDashboard;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMapView;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMsgTempl;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSearchBar;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCtrlLogicGroupService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCtrlMsgService;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCounterService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDashboardService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMapViewService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgTemplService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSearchBarService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEViewCtrlBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEViewCtrlBase.class);
    public static final String FIELD_ADPSDELOGICID = "ADPSDELOGICID";
    public static final String FIELD_ADPSDELOGICNAME = "ADPSDELOGICNAME";
    public static final String FIELD_BOTTOMPOS = "BOTTOMPOS";
    public static final String FIELD_BTNACTIONTYPE = "BTNACTIONTYPE";
    public static final String FIELD_BUSYINDICATOR = "BUSYINDICATOR";
    public static final String FIELD_CAPPSLANRESID = "CAPPSLANRESID";
    public static final String FIELD_CAPPSLANRESNAME = "CAPPSLANRESNAME";
    public static final String FIELD_CAPTION = "CAPTION";
    public static final String FIELD_CONFIGINFO = "CONFIGINFO";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CTRLPARAM = "CTRLPARAM";
    public static final String FIELD_CTRLPARAM10 = "CTRLPARAM10";
    public static final String FIELD_CTRLPARAM11 = "CTRLPARAM11";
    public static final String FIELD_CTRLPARAM12 = "CTRLPARAM12";
    public static final String FIELD_CTRLPARAM2 = "CTRLPARAM2";
    public static final String FIELD_CTRLPARAM3 = "CTRLPARAM3";
    public static final String FIELD_CTRLPARAM4 = "CTRLPARAM4";
    public static final String FIELD_CTRLPARAM5 = "CTRLPARAM5";
    public static final String FIELD_CTRLPARAM6 = "CTRLPARAM6";
    public static final String FIELD_CTRLPARAM7 = "CTRLPARAM7";
    public static final String FIELD_CTRLPARAM8 = "CTRLPARAM8";
    public static final String FIELD_CTRLPARAM9 = "CTRLPARAM9";
    public static final String FIELD_CTRLPARAMS = "CTRLPARAMS";
    public static final String FIELD_CUSTOMCOND = "CUSTOMCOND";
    public static final String FIELD_CUSTOMTYPE = "CUSTOMTYPE";
    public static final String FIELD_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_DYNCMODE = "DYNCMODE";
    public static final String FIELD_ENABLEDYNASYS = "ENABLEDYNASYS";
    public static final String FIELD_ENABLEITEMPRIV = "ENABLEITEMPRIV";
    public static final String FIELD_ENABLEVIEWACTIONS = "ENABLEVIEWACTIONS";
    public static final String FIELD_HEIGHT = "HEIGHT";
    public static final String FIELD_INSERTPOS = "INSERTPOS";
    public static final String FIELD_LEFTPOS = "LEFTPOS";
    public static final String FIELD_LOCALMODE = "LOCALMODE";
    public static final String FIELD_MARGIN = "MARGIN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MULTISELECT = "MULTISELECT";
    public static final String FIELD_NO2PSDEUAGROUPID = "NO2PSDEUAGROUPID";
    public static final String FIELD_NO2PSDEUAGROUPNAME = "NO2PSDEUAGROUPNAME";
    public static final String FIELD_NO3PSDEUAGROUPID = "NO3PSDEUAGROUPID";
    public static final String FIELD_NO3PSDEUAGROUPNAME = "NO3PSDEUAGROUPNAME";
    public static final String FIELD_NO4PSDEUAGROUPID = "NO4PSDEUAGROUPID";
    public static final String FIELD_NO4PSDEUAGROUPNAME = "NO4PSDEUAGROUPNAME";
    public static final String FIELD_NO5PSDEUAGROUPID = "NO5PSDEUAGROUPID";
    public static final String FIELD_NO5PSDEUAGROUPNAME = "NO5PSDEUAGROUPNAME";
    public static final String FIELD_NO6PSDEUAGROUPID = "NO6PSDEUAGROUPID";
    public static final String FIELD_NO6PSDEUAGROUPNAME = "NO6PSDEUAGROUPNAME";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PADDING = "PADDING";
    public static final String FIELD_PREDEFINEDTYPE = "PREDEFINEDTYPE";
    public static final String FIELD_PREDEFINEDTYPETEXT = "PREDEFINEDTYPETEXT";
    public static final String FIELD_PSACHANDLERID = "PSACHANDLERID";
    public static final String FIELD_PSACHANDLERNAME = "PSACHANDLERNAME";
    public static final String FIELD_PSCTRLID = "PSCTRLID";
    public static final String FIELD_PSCTRLLOGICGROUPID = "PSCTRLLOGICGROUPID";
    public static final String FIELD_PSCTRLLOGICGROUPNAME = "PSCTRLLOGICGROUPNAME";
    public static final String FIELD_PSCTRLMSGID = "PSCTRLMSGID";
    public static final String FIELD_PSCTRLMSGNAME = "PSCTRLMSGNAME";
    public static final String FIELD_PSCTRLNAME = "PSCTRLNAME";
    public static final String FIELD_PSDEACTIONID = "PSDEACTIONID";
    public static final String FIELD_PSDEACTIONNAME = "PSDEACTIONNAME";
    public static final String FIELD_PSDECHARTID = "PSDECHARTID";
    public static final String FIELD_PSDECHARTNAME = "PSDECHARTNAME";
    public static final String FIELD_PSDEDATAEXPID = "PSDEDATAEXPID";
    public static final String FIELD_PSDEDATAEXPNAME = "PSDEDATAEXPNAME";
    public static final String FIELD_PSDEDATAIMPID = "PSDEDATAIMPID";
    public static final String FIELD_PSDEDATAIMPNAME = "PSDEDATAIMPNAME";
    public static final String FIELD_PSDEDATASETID = "PSDEDATASETID";
    public static final String FIELD_PSDEDATASETNAME = "PSDEDATASETNAME";
    public static final String FIELD_PSDEDATAVIEWID = "PSDEDATAVIEWID";
    public static final String FIELD_PSDEDATAVIEWNAME = "PSDEDATAVIEWNAME";
    public static final String FIELD_PSDEDRID = "PSDEDRID";
    public static final String FIELD_PSDEDRNAME = "PSDEDRNAME";
    public static final String FIELD_PSDEFORMID = "PSDEFORMID";
    public static final String FIELD_PSDEFORMNAME = "PSDEFORMNAME";
    public static final String FIELD_PSDEGRIDID = "PSDEGRIDID";
    public static final String FIELD_PSDEGRIDNAME = "PSDEGRIDNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDELISTID = "PSDELISTID";
    public static final String FIELD_PSDELISTNAME = "PSDELISTNAME";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDEOPPRIVID = "PSDEOPPRIVID";
    public static final String FIELD_PSDEOPPRIVNAME = "PSDEOPPRIVNAME";
    public static final String FIELD_PSDEREPORTID = "PSDEREPORTID";
    public static final String FIELD_PSDEREPORTNAME = "PSDEREPORTNAME";
    public static final String FIELD_PSDETOOLBARID = "PSDETOOLBARID";
    public static final String FIELD_PSDETOOLBARNAME = "PSDETOOLBARNAME";
    public static final String FIELD_PSDETREEVIEWID = "PSDETREEVIEWID";
    public static final String FIELD_PSDETREEVIEWNAME = "PSDETREEVIEWNAME";
    public static final String FIELD_PSDEUAGROUPID = "PSDEUAGROUPID";
    public static final String FIELD_PSDEUAGROUPNAME = "PSDEUAGROUPNAME";
    public static final String FIELD_PSDEVIEWBASEID = "PSDEVIEWBASEID";
    public static final String FIELD_PSDEVIEWBASENAME = "PSDEVIEWBASENAME";
    public static final String FIELD_PSDEVIEWCTRLID = "PSDEVIEWCTRLID";
    public static final String FIELD_PSDEVIEWCTRLNAME = "PSDEVIEWCTRLNAME";
    public static final String FIELD_PSDEVIEWCTRLTYPE = "PSDEVIEWCTRLTYPE";
    public static final String FIELD_PSDEVIEWID = "PSDEVIEWID";
    public static final String FIELD_PSDEVIEWNAME = "PSDEVIEWNAME";
    public static final String FIELD_PSDEWIZARDID = "PSDEWIZARDID";
    public static final String FIELD_PSDEWIZARDNAME = "PSDEWIZARDNAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSPFID = "PSPFID";
    public static final String FIELD_PSPFNAME = "PSPFNAME";
    public static final String FIELD_PSSYSCALENDARID = "PSSYSCALENDARID";
    public static final String FIELD_PSSYSCALENDARNAME = "PSSYSCALENDARNAME";
    public static final String FIELD_PSSYSCOUNTERID = "PSSYSCOUNTERID";
    public static final String FIELD_PSSYSCOUNTERNAME = "PSSYSCOUNTERNAME";
    public static final String FIELD_PSSYSCSSID = "PSSYSCSSID";
    public static final String FIELD_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String FIELD_PSSYSDASHBOARDID = "PSSYSDASHBOARDID";
    public static final String FIELD_PSSYSDASHBOARDNAME = "PSSYSDASHBOARDNAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String FIELD_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String FIELD_PSSYSMAPVIEWID = "PSSYSMAPVIEWID";
    public static final String FIELD_PSSYSMAPVIEWNAME = "PSSYSMAPVIEWNAME";
    public static final String FIELD_PSSYSMSGTEMPLID = "PSSYSMSGTEMPLID";
    public static final String FIELD_PSSYSMSGTEMPLNAME = "PSSYSMSGTEMPLNAME";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_PSSYSSEARCHBARID = "PSSYSSEARCHBARID";
    public static final String FIELD_PSSYSSEARCHBARNAME = "PSSYSSEARCHBARNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSVIEWPANELID = "PSSYSVIEWPANELID";
    public static final String FIELD_PSSYSVIEWPANELNAME = "PSSYSVIEWPANELNAME";
    public static final String FIELD_READONLYMODE = "READONLYMODE";
    public static final String FIELD_REFCTRL2NAME = "REFCTRL2NAME";
    public static final String FIELD_REFCTRL2USAGE = "REFCTRL2USAGE";
    public static final String FIELD_REFCTRL2USAGETEXT = "REFCTRL2USAGETEXT";
    public static final String FIELD_REFCTRLNAME = "REFCTRLNAME";
    public static final String FIELD_REFCTRLUSAGE = "REFCTRLUSAGE";
    public static final String FIELD_REFCTRLUSAGETEXT = "REFCTRLUSAGETEXT";
    public static final String FIELD_RIGHTPOS = "RIGHTPOS";
    public static final String FIELD_SUBPSACHANDLERID = "SUBPSACHANDLERID";
    public static final String FIELD_SUBPSACHANDLERNAME = "SUBPSACHANDLERNAME";
    public static final String FIELD_TOPPOS = "TOPPOS";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_WIDTH = "WIDTH";
    private static final int INDEX_ADPSDELOGICID = 0;
    private static final int INDEX_ADPSDELOGICNAME = 1;
    private static final int INDEX_BOTTOMPOS = 2;
    private static final int INDEX_BTNACTIONTYPE = 3;
    private static final int INDEX_BUSYINDICATOR = 4;
    private static final int INDEX_CAPPSLANRESID = 5;
    private static final int INDEX_CAPPSLANRESNAME = 6;
    private static final int INDEX_CAPTION = 7;
    private static final int INDEX_CONFIGINFO = 8;
    private static final int INDEX_CREATEDATE = 9;
    private static final int INDEX_CREATEMAN = 10;
    private static final int INDEX_CTRLPARAM = 11;
    private static final int INDEX_CTRLPARAM10 = 12;
    private static final int INDEX_CTRLPARAM11 = 13;
    private static final int INDEX_CTRLPARAM12 = 14;
    private static final int INDEX_CTRLPARAM2 = 15;
    private static final int INDEX_CTRLPARAM3 = 16;
    private static final int INDEX_CTRLPARAM4 = 17;
    private static final int INDEX_CTRLPARAM5 = 18;
    private static final int INDEX_CTRLPARAM6 = 19;
    private static final int INDEX_CTRLPARAM7 = 20;
    private static final int INDEX_CTRLPARAM8 = 21;
    private static final int INDEX_CTRLPARAM9 = 22;
    private static final int INDEX_CTRLPARAMS = 23;
    private static final int INDEX_CUSTOMCOND = 24;
    private static final int INDEX_CUSTOMTYPE = 25;
    private static final int INDEX_DEFAULTFLAG = 26;
    private static final int INDEX_DYNAMODELFLAG = 27;
    private static final int INDEX_DYNCMODE = 28;
    private static final int INDEX_ENABLEDYNASYS = 29;
    private static final int INDEX_ENABLEITEMPRIV = 30;
    private static final int INDEX_ENABLEVIEWACTIONS = 31;
    private static final int INDEX_HEIGHT = 32;
    private static final int INDEX_INSERTPOS = 33;
    private static final int INDEX_LEFTPOS = 34;
    private static final int INDEX_LOCALMODE = 35;
    private static final int INDEX_MARGIN = 36;
    private static final int INDEX_MEMO = 37;
    private static final int INDEX_MULTISELECT = 38;
    private static final int INDEX_NO2PSDEUAGROUPID = 39;
    private static final int INDEX_NO2PSDEUAGROUPNAME = 40;
    private static final int INDEX_NO3PSDEUAGROUPID = 41;
    private static final int INDEX_NO3PSDEUAGROUPNAME = 42;
    private static final int INDEX_NO4PSDEUAGROUPID = 43;
    private static final int INDEX_NO4PSDEUAGROUPNAME = 44;
    private static final int INDEX_NO5PSDEUAGROUPID = 45;
    private static final int INDEX_NO5PSDEUAGROUPNAME = 46;
    private static final int INDEX_NO6PSDEUAGROUPID = 47;
    private static final int INDEX_NO6PSDEUAGROUPNAME = 48;
    private static final int INDEX_ORDERVALUE = 49;
    private static final int INDEX_PADDING = 50;
    private static final int INDEX_PREDEFINEDTYPE = 51;
    private static final int INDEX_PREDEFINEDTYPETEXT = 52;
    private static final int INDEX_PSACHANDLERID = 53;
    private static final int INDEX_PSACHANDLERNAME = 54;
    private static final int INDEX_PSCTRLID = 55;
    private static final int INDEX_PSCTRLLOGICGROUPID = 56;
    private static final int INDEX_PSCTRLLOGICGROUPNAME = 57;
    private static final int INDEX_PSCTRLMSGID = 58;
    private static final int INDEX_PSCTRLMSGNAME = 59;
    private static final int INDEX_PSCTRLNAME = 60;
    private static final int INDEX_PSDEACTIONID = 61;
    private static final int INDEX_PSDEACTIONNAME = 62;
    private static final int INDEX_PSDECHARTID = 63;
    private static final int INDEX_PSDECHARTNAME = 64;
    private static final int INDEX_PSDEDATAEXPID = 65;
    private static final int INDEX_PSDEDATAEXPNAME = 66;
    private static final int INDEX_PSDEDATAIMPID = 67;
    private static final int INDEX_PSDEDATAIMPNAME = 68;
    private static final int INDEX_PSDEDATASETID = 69;
    private static final int INDEX_PSDEDATASETNAME = 70;
    private static final int INDEX_PSDEDATAVIEWID = 71;
    private static final int INDEX_PSDEDATAVIEWNAME = 72;
    private static final int INDEX_PSDEDRID = 73;
    private static final int INDEX_PSDEDRNAME = 74;
    private static final int INDEX_PSDEFORMID = 75;
    private static final int INDEX_PSDEFORMNAME = 76;
    private static final int INDEX_PSDEGRIDID = 77;
    private static final int INDEX_PSDEGRIDNAME = 78;
    private static final int INDEX_PSDEID = 79;
    private static final int INDEX_PSDELISTID = 80;
    private static final int INDEX_PSDELISTNAME = 81;
    private static final int INDEX_PSDENAME = 82;
    private static final int INDEX_PSDEOPPRIVID = 83;
    private static final int INDEX_PSDEOPPRIVNAME = 84;
    private static final int INDEX_PSDEREPORTID = 85;
    private static final int INDEX_PSDEREPORTNAME = 86;
    private static final int INDEX_PSDETOOLBARID = 87;
    private static final int INDEX_PSDETOOLBARNAME = 88;
    private static final int INDEX_PSDETREEVIEWID = 89;
    private static final int INDEX_PSDETREEVIEWNAME = 90;
    private static final int INDEX_PSDEUAGROUPID = 91;
    private static final int INDEX_PSDEUAGROUPNAME = 92;
    private static final int INDEX_PSDEVIEWBASEID = 93;
    private static final int INDEX_PSDEVIEWBASENAME = 94;
    private static final int INDEX_PSDEVIEWCTRLID = 95;
    private static final int INDEX_PSDEVIEWCTRLNAME = 96;
    private static final int INDEX_PSDEVIEWCTRLTYPE = 97;
    private static final int INDEX_PSDEVIEWID = 98;
    private static final int INDEX_PSDEVIEWNAME = 99;
    private static final int INDEX_PSDEWIZARDID = 100;
    private static final int INDEX_PSDEWIZARDNAME = 101;
    private static final int INDEX_PSDYNAINSTID = 102;
    private static final int INDEX_PSPFID = 103;
    private static final int INDEX_PSPFNAME = 104;
    private static final int INDEX_PSSYSCALENDARID = 105;
    private static final int INDEX_PSSYSCALENDARNAME = 106;
    private static final int INDEX_PSSYSCOUNTERID = 107;
    private static final int INDEX_PSSYSCOUNTERNAME = 108;
    private static final int INDEX_PSSYSCSSID = 109;
    private static final int INDEX_PSSYSCSSNAME = 110;
    private static final int INDEX_PSSYSDASHBOARDID = 111;
    private static final int INDEX_PSSYSDASHBOARDNAME = 112;
    private static final int INDEX_PSSYSDYNAMODELID = 113;
    private static final int INDEX_PSSYSDYNAMODELNAME = 114;
    private static final int INDEX_PSSYSIMAGEID = 115;
    private static final int INDEX_PSSYSIMAGENAME = 116;
    private static final int INDEX_PSSYSMAPVIEWID = 117;
    private static final int INDEX_PSSYSMAPVIEWNAME = 118;
    private static final int INDEX_PSSYSMSGTEMPLID = 119;
    private static final int INDEX_PSSYSMSGTEMPLNAME = 120;
    private static final int INDEX_PSSYSPFPLUGINID = 121;
    private static final int INDEX_PSSYSPFPLUGINNAME = 122;
    private static final int INDEX_PSSYSSEARCHBARID = 123;
    private static final int INDEX_PSSYSSEARCHBARNAME = 124;
    private static final int INDEX_PSSYSTEMID = 125;
    private static final int INDEX_PSSYSVIEWPANELID = 126;
    private static final int INDEX_PSSYSVIEWPANELNAME = 127;
    private static final int INDEX_READONLYMODE = 128;
    private static final int INDEX_REFCTRL2NAME = 129;
    private static final int INDEX_REFCTRL2USAGE = 130;
    private static final int INDEX_REFCTRL2USAGETEXT = 131;
    private static final int INDEX_REFCTRLNAME = 132;
    private static final int INDEX_REFCTRLUSAGE = 133;
    private static final int INDEX_REFCTRLUSAGETEXT = 134;
    private static final int INDEX_RIGHTPOS = 135;
    private static final int INDEX_SUBPSACHANDLERID = 136;
    private static final int INDEX_SUBPSACHANDLERNAME = 137;
    private static final int INDEX_TOPPOS = 138;
    private static final int INDEX_UPDATEDATE = 139;
    private static final int INDEX_UPDATEMAN = 140;
    private static final int INDEX_USERTAG = 141;
    private static final int INDEX_USERTAG2 = 142;
    private static final int INDEX_VALIDFLAG = 143;
    private static final int INDEX_WIDTH = 144;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEViewCtrlBase proxyPSDEViewCtrlBase = null;
    private boolean adpsdelogicidDirtyFlag = false;
    private boolean adpsdelogicnameDirtyFlag = false;
    private boolean bottomposDirtyFlag = false;
    private boolean btnactiontypeDirtyFlag = false;
    private boolean busyindicatorDirtyFlag = false;
    private boolean cappslanresidDirtyFlag = false;
    private boolean cappslanresnameDirtyFlag = false;
    private boolean captionDirtyFlag = false;
    private boolean configinfoDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean ctrlparamDirtyFlag = false;
    private boolean ctrlparam10DirtyFlag = false;
    private boolean ctrlparam11DirtyFlag = false;
    private boolean ctrlparam12DirtyFlag = false;
    private boolean ctrlparam2DirtyFlag = false;
    private boolean ctrlparam3DirtyFlag = false;
    private boolean ctrlparam4DirtyFlag = false;
    private boolean ctrlparam5DirtyFlag = false;
    private boolean ctrlparam6DirtyFlag = false;
    private boolean ctrlparam7DirtyFlag = false;
    private boolean ctrlparam8DirtyFlag = false;
    private boolean ctrlparam9DirtyFlag = false;
    private boolean ctrlparamsDirtyFlag = false;
    private boolean customcondDirtyFlag = false;
    private boolean customtypeDirtyFlag = false;
    private boolean defaultflagDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean dyncmodeDirtyFlag = false;
    private boolean enabledynasysDirtyFlag = false;
    private boolean enableitemprivDirtyFlag = false;
    private boolean enableviewactionsDirtyFlag = false;
    private boolean heightDirtyFlag = false;
    private boolean insertposDirtyFlag = false;
    private boolean leftposDirtyFlag = false;
    private boolean localmodeDirtyFlag = false;
    private boolean marginDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean multiselectDirtyFlag = false;
    private boolean no2psdeuagroupidDirtyFlag = false;
    private boolean no2psdeuagroupnameDirtyFlag = false;
    private boolean no3psdeuagroupidDirtyFlag = false;
    private boolean no3psdeuagroupnameDirtyFlag = false;
    private boolean no4psdeuagroupidDirtyFlag = false;
    private boolean no4psdeuagroupnameDirtyFlag = false;
    private boolean no5psdeuagroupidDirtyFlag = false;
    private boolean no5psdeuagroupnameDirtyFlag = false;
    private boolean no6psdeuagroupidDirtyFlag = false;
    private boolean no6psdeuagroupnameDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean paddingDirtyFlag = false;
    private boolean predefinedtypeDirtyFlag = false;
    private boolean predefinedtypetextDirtyFlag = false;
    private boolean psachandleridDirtyFlag = false;
    private boolean psachandlernameDirtyFlag = false;
    private boolean psctrlidDirtyFlag = false;
    private boolean psctrllogicgroupidDirtyFlag = false;
    private boolean psctrllogicgroupnameDirtyFlag = false;
    private boolean psctrlmsgidDirtyFlag = false;
    private boolean psctrlmsgnameDirtyFlag = false;
    private boolean psctrlnameDirtyFlag = false;
    private boolean psdeactionidDirtyFlag = false;
    private boolean psdeactionnameDirtyFlag = false;
    private boolean psdechartidDirtyFlag = false;
    private boolean psdechartnameDirtyFlag = false;
    private boolean psdedataexpidDirtyFlag = false;
    private boolean psdedataexpnameDirtyFlag = false;
    private boolean psdedataimpidDirtyFlag = false;
    private boolean psdedataimpnameDirtyFlag = false;
    private boolean psdedatasetidDirtyFlag = false;
    private boolean psdedatasetnameDirtyFlag = false;
    private boolean psdedataviewidDirtyFlag = false;
    private boolean psdedataviewnameDirtyFlag = false;
    private boolean psdedridDirtyFlag = false;
    private boolean psdedrnameDirtyFlag = false;
    private boolean psdeformidDirtyFlag = false;
    private boolean psdeformnameDirtyFlag = false;
    private boolean psdegrididDirtyFlag = false;
    private boolean psdegridnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdelistidDirtyFlag = false;
    private boolean psdelistnameDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdeopprividDirtyFlag = false;
    private boolean psdeopprivnameDirtyFlag = false;
    private boolean psdereportidDirtyFlag = false;
    private boolean psdereportnameDirtyFlag = false;
    private boolean psdetoolbaridDirtyFlag = false;
    private boolean psdetoolbarnameDirtyFlag = false;
    private boolean psdetreeviewidDirtyFlag = false;
    private boolean psdetreeviewnameDirtyFlag = false;
    private boolean psdeuagroupidDirtyFlag = false;
    private boolean psdeuagroupnameDirtyFlag = false;
    private boolean psdeviewbaseidDirtyFlag = false;
    private boolean psdeviewbasenameDirtyFlag = false;
    private boolean psdeviewctrlidDirtyFlag = false;
    private boolean psdeviewctrlnameDirtyFlag = false;
    private boolean psdeviewctrltypeDirtyFlag = false;
    private boolean psdeviewidDirtyFlag = false;
    private boolean psdeviewnameDirtyFlag = false;
    private boolean psdewizardidDirtyFlag = false;
    private boolean psdewizardnameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pspfidDirtyFlag = false;
    private boolean pspfnameDirtyFlag = false;
    private boolean pssyscalendaridDirtyFlag = false;
    private boolean pssyscalendarnameDirtyFlag = false;
    private boolean pssyscounteridDirtyFlag = false;
    private boolean pssyscounternameDirtyFlag = false;
    private boolean pssyscssidDirtyFlag = false;
    private boolean pssyscssnameDirtyFlag = false;
    private boolean pssysdashboardidDirtyFlag = false;
    private boolean pssysdashboardnameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssysimageidDirtyFlag = false;
    private boolean pssysimagenameDirtyFlag = false;
    private boolean pssysmapviewidDirtyFlag = false;
    private boolean pssysmapviewnameDirtyFlag = false;
    private boolean pssysmsgtemplidDirtyFlag = false;
    private boolean pssysmsgtemplnameDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean pssyssearchbaridDirtyFlag = false;
    private boolean pssyssearchbarnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssysviewpanelidDirtyFlag = false;
    private boolean pssysviewpanelnameDirtyFlag = false;
    private boolean readonlymodeDirtyFlag = false;
    private boolean refctrl2nameDirtyFlag = false;
    private boolean refctrl2usageDirtyFlag = false;
    private boolean refctrl2usagetextDirtyFlag = false;
    private boolean refctrlnameDirtyFlag = false;
    private boolean refctrlusageDirtyFlag = false;
    private boolean refctrlusagetextDirtyFlag = false;
    private boolean rightposDirtyFlag = false;
    private boolean subpsachandleridDirtyFlag = false;
    private boolean subpsachandlernameDirtyFlag = false;
    private boolean topposDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean widthDirtyFlag = false;
    @Column(name="adpsdelogicid")
    private String adpsdelogicid;
    @Column(name="adpsdelogicname")
    private String adpsdelogicname;
    @Column(name="bottompos")
    private Integer bottompos;
    @Column(name="btnactiontype")
    private String btnactiontype;
    @Column(name="busyindicator")
    private Integer busyindicator;
    @Column(name="cappslanresid")
    private String cappslanresid;
    @Column(name="cappslanresname")
    private String cappslanresname;
    @Column(name="caption")
    private String caption;
    @Column(name="configinfo")
    private String configinfo;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="ctrlparam")
    private String ctrlparam;
    @Column(name="ctrlparam10")
    private Double ctrlparam10;
    @Column(name="ctrlparam11")
    private Integer ctrlparam11;
    @Column(name="ctrlparam12")
    private Integer ctrlparam12;
    @Column(name="ctrlparam2")
    private String ctrlparam2;
    @Column(name="ctrlparam3")
    private String ctrlparam3;
    @Column(name="ctrlparam4")
    private String ctrlparam4;
    @Column(name="ctrlparam5")
    private Integer ctrlparam5;
    @Column(name="ctrlparam6")
    private Integer ctrlparam6;
    @Column(name="ctrlparam7")
    private Integer ctrlparam7;
    @Column(name="ctrlparam8")
    private Integer ctrlparam8;
    @Column(name="ctrlparam9")
    private Double ctrlparam9;
    @Column(name="ctrlparams")
    private String ctrlparams;
    @Column(name="customcond")
    private String customcond;
    @Column(name="customtype")
    private String customtype;
    @Column(name="defaultflag")
    private Integer defaultflag;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="dyncmode")
    private Integer dyncmode;
    @Column(name="enabledynasys")
    private Integer enabledynasys;
    @Column(name="enableitempriv")
    private Integer enableitempriv;
    @Column(name="enableviewactions")
    private Integer enableviewactions;
    @Column(name="height")
    private Double height;
    @Column(name="insertpos")
    private Integer insertpos;
    @Column(name="leftpos")
    private Integer leftpos;
    @Column(name="localmode")
    private Integer localmode;
    @Column(name="margin")
    private String margin;
    @Column(name="memo")
    private String memo;
    @Column(name="multiselect")
    private Integer multiselect;
    @Column(name="no2psdeuagroupid")
    private String no2psdeuagroupid;
    @Column(name="no2psdeuagroupname")
    private String no2psdeuagroupname;
    @Column(name="no3psdeuagroupid")
    private String no3psdeuagroupid;
    @Column(name="no3psdeuagroupname")
    private String no3psdeuagroupname;
    @Column(name="no4psdeuagroupid")
    private String no4psdeuagroupid;
    @Column(name="no4psdeuagroupname")
    private String no4psdeuagroupname;
    @Column(name="no5psdeuagroupid")
    private String no5psdeuagroupid;
    @Column(name="no5psdeuagroupname")
    private String no5psdeuagroupname;
    @Column(name="no6psdeuagroupid")
    private String no6psdeuagroupid;
    @Column(name="no6psdeuagroupname")
    private String no6psdeuagroupname;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="padding")
    private String padding;
    @Column(name="predefinedtype")
    private String predefinedtype;
    @Column(name="predefinedtypetext")
    private String predefinedtypetext;
    @Column(name="psachandlerid")
    private String psachandlerid;
    @Column(name="psachandlername")
    private String psachandlername;
    @Column(name="psctrlid")
    private String psctrlid;
    @Column(name="psctrllogicgroupid")
    private String psctrllogicgroupid;
    @Column(name="psctrllogicgroupname")
    private String psctrllogicgroupname;
    @Column(name="psctrlmsgid")
    private String psctrlmsgid;
    @Column(name="psctrlmsgname")
    private String psctrlmsgname;
    @Column(name="psctrlname")
    private String psctrlname;
    @Column(name="psdeactionid")
    private String psdeactionid;
    @Column(name="psdeactionname")
    private String psdeactionname;
    @Column(name="psdechartid")
    private String psdechartid;
    @Column(name="psdechartname")
    private String psdechartname;
    @Column(name="psdedataexpid")
    private String psdedataexpid;
    @Column(name="psdedataexpname")
    private String psdedataexpname;
    @Column(name="psdedataimpid")
    private String psdedataimpid;
    @Column(name="psdedataimpname")
    private String psdedataimpname;
    @Column(name="psdedatasetid")
    private String psdedatasetid;
    @Column(name="psdedatasetname")
    private String psdedatasetname;
    @Column(name="psdedataviewid")
    private String psdedataviewid;
    @Column(name="psdedataviewname")
    private String psdedataviewname;
    @Column(name="psdedrid")
    private String psdedrid;
    @Column(name="psdedrname")
    private String psdedrname;
    @Column(name="psdeformid")
    private String psdeformid;
    @Column(name="psdeformname")
    private String psdeformname;
    @Column(name="psdegridid")
    private String psdegridid;
    @Column(name="psdegridname")
    private String psdegridname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdelistid")
    private String psdelistid;
    @Column(name="psdelistname")
    private String psdelistname;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdeopprivid")
    private String psdeopprivid;
    @Column(name="psdeopprivname")
    private String psdeopprivname;
    @Column(name="psdereportid")
    private String psdereportid;
    @Column(name="psdereportname")
    private String psdereportname;
    @Column(name="psdetoolbarid")
    private String psdetoolbarid;
    @Column(name="psdetoolbarname")
    private String psdetoolbarname;
    @Column(name="psdetreeviewid")
    private String psdetreeviewid;
    @Column(name="psdetreeviewname")
    private String psdetreeviewname;
    @Column(name="psdeuagroupid")
    private String psdeuagroupid;
    @Column(name="psdeuagroupname")
    private String psdeuagroupname;
    @Column(name="psdeviewbaseid")
    private String psdeviewbaseid;
    @Column(name="psdeviewbasename")
    private String psdeviewbasename;
    @Column(name="psdeviewctrlid")
    private String psdeviewctrlid;
    @Column(name="psdeviewctrlname")
    private String psdeviewctrlname;
    @Column(name="psdeviewctrltype")
    private String psdeviewctrltype;
    @Column(name="psdeviewid")
    private String psdeviewid;
    @Column(name="psdeviewname")
    private String psdeviewname;
    @Column(name="psdewizardid")
    private String psdewizardid;
    @Column(name="psdewizardname")
    private String psdewizardname;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="pspfid")
    private String pspfid;
    @Column(name="pspfname")
    private String pspfname;
    @Column(name="pssyscalendarid")
    private String pssyscalendarid;
    @Column(name="pssyscalendarname")
    private String pssyscalendarname;
    @Column(name="pssyscounterid")
    private String pssyscounterid;
    @Column(name="pssyscountername")
    private String pssyscountername;
    @Column(name="pssyscssid")
    private String pssyscssid;
    @Column(name="pssyscssname")
    private String pssyscssname;
    @Column(name="pssysdashboardid")
    private String pssysdashboardid;
    @Column(name="pssysdashboardname")
    private String pssysdashboardname;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssysimageid")
    private String pssysimageid;
    @Column(name="pssysimagename")
    private String pssysimagename;
    @Column(name="pssysmapviewid")
    private String pssysmapviewid;
    @Column(name="pssysmapviewname")
    private String pssysmapviewname;
    @Column(name="pssysmsgtemplid")
    private String pssysmsgtemplid;
    @Column(name="pssysmsgtemplname")
    private String pssysmsgtemplname;
    @Column(name="pssyspfpluginid")
    private String pssyspfpluginid;
    @Column(name="pssyspfpluginname")
    private String pssyspfpluginname;
    @Column(name="pssyssearchbarid")
    private String pssyssearchbarid;
    @Column(name="pssyssearchbarname")
    private String pssyssearchbarname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssysviewpanelid")
    private String pssysviewpanelid;
    @Column(name="pssysviewpanelname")
    private String pssysviewpanelname;
    @Column(name="readonlymode")
    private Integer readonlymode;
    @Column(name="refctrl2name")
    private String refctrl2name;
    @Column(name="refctrl2usage")
    private String refctrl2usage;
    @Column(name="refctrl2usagetext")
    private String refctrl2usagetext;
    @Column(name="refctrlname")
    private String refctrlname;
    @Column(name="refctrlusage")
    private String refctrlusage;
    @Column(name="refctrlusagetext")
    private String refctrlusagetext;
    @Column(name="rightpos")
    private Integer rightpos;
    @Column(name="subpsachandlerid")
    private String subpsachandlerid;
    @Column(name="subpsachandlername")
    private String subpsachandlername;
    @Column(name="toppos")
    private Integer toppos;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="validflag")
    private Integer validflag;
    @Column(name="width")
    private Double width;
    private Integer objPSACHandlerLock = new Integer(1);
    private PSACHandler psachandler = null;
    private Integer objSubPSACHandlerLock = new Integer(1);
    private PSACHandler subpsachandler = null;
    private Integer objPSCtrlLogicGroupLock = new Integer(1);
    private PSCtrlLogicGroup psctrllogicgroup = null;
    private Integer objPSCtrlMsgLock = new Integer(1);
    private PSCtrlMsg psctrlmsg = null;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSDEActionLock = new Integer(1);
    private PSDEAction psdeaction = null;
    private Integer objPSDEChartLock = new Integer(1);
    private PSDEChart psdechart = null;
    private Integer objPSDEDataExpLock = new Integer(1);
    private PSDEDataExp psdedataexp = null;
    private Integer objPSDEDataImpLock = new Integer(1);
    private PSDEDataImp psdedataimp = null;
    private Integer objPSDEDRLock = new Integer(1);
    private PSDEDataRelation psdedr = null;
    private Integer objPSDEDataSetLock = new Integer(1);
    private PSDEDataSet psdedataset = null;
    private Integer objPSDEDataViewLock = new Integer(1);
    private PSDEDataView psdedataview = null;
    private Integer objPSDEFormLock = new Integer(1);
    private PSDEForm psdeform = null;
    private Integer objPSDEGridLock = new Integer(1);
    private PSDEGrid psdegrid = null;
    private Integer objPSDEListLock = new Integer(1);
    private PSDEList psdelist = null;
    private Integer objADPSDELogicLock = new Integer(1);
    private PSDELogic adpsdelogic = null;
    private Integer objPSDEOPPrivLock = new Integer(1);
    private PSDEOPPriv psdeoppriv = null;
    private Integer objPSDEReportLock = new Integer(1);
    private PSDEReport psdereport = null;
    private Integer objPSDEToolbarLock = new Integer(1);
    private PSDEToolbar psdetoolbar = null;
    private Integer objPSDETreeViewLock = new Integer(1);
    private PSDETreeView psdetreeview = null;
    private Integer objNo2PSDEUAGroupLock = new Integer(1);
    private PSDEUAGroup no2psdeuagroup = null;
    private Integer objNo3PSDEUAGroupLock = new Integer(1);
    private PSDEUAGroup no3psdeuagroup = null;
    private Integer objNo4PSDEUAGroupLock = new Integer(1);
    private PSDEUAGroup no4psdeuagroup = null;
    private Integer objNo5PSDEUAGroupLock = new Integer(1);
    private PSDEUAGroup no5psdeuagroup = null;
    private Integer objNo6PSDEUAGroupLock = new Integer(1);
    private PSDEUAGroup no6psdeuagroup = null;
    private Integer objPSDEUAGroupLock = new Integer(1);
    private PSDEUAGroup psdeuagroup = null;
    private Integer objPSDEViewBaseLock = new Integer(1);
    private PSDEViewBase psdeviewbase = null;
    private Integer objPSDEViewLock = new Integer(1);
    private PSDEViewBase psdeview = null;
    private Integer objPSDEWizardLock = new Integer(1);
    private PSDEWizard psdewizard = null;
    private Integer objCapPSLanResLock = new Integer(1);
    private PSLanguageRes cappslanres = null;
    private Integer objPSPFLock = new Integer(1);
    private PSPF pspf = null;
    private Integer objPSSysCalendarLock = new Integer(1);
    private PSSysCalendar pssyscalendar = null;
    private Integer objPSSysCounterLock = new Integer(1);
    private PSSysCounter pssyscounter = null;
    private Integer objPSSysCssLock = new Integer(1);
    private PSSysCss pssyscss = null;
    private Integer objPSSysDashboardLock = new Integer(1);
    private PSSysDashboard pssysdashboard = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSysImageLock = new Integer(1);
    private PSSysImage pssysimage = null;
    private Integer objPSSysMapViewLock = new Integer(1);
    private PSSysMapView pssysmapview = null;
    private Integer objPSSysMsgTemplLock = new Integer(1);
    private PSSysMsgTempl pssysmsgtempl = null;
    private Integer objPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin pssyspfplugin = null;
    private Integer objPSSysSearchBarLock = new Integer(1);
    private PSSysSearchBar pssyssearchbar = null;
    private Integer objPSSysViewPanelLock = new Integer(1);
    private PSSysViewPanel pssysviewpanel = null;

    public void setADPSDELogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setADPSDELogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.adpsdelogicid = string;
        this.adpsdelogicidDirtyFlag = true;
    }

    public String getADPSDELogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getADPSDELogicId();
        }
        return this.adpsdelogicid;
    }

    public boolean isADPSDELogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isADPSDELogicIdDirty();
        }
        return this.adpsdelogicidDirtyFlag;
    }

    public void resetADPSDELogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetADPSDELogicId();
            return;
        }
        this.adpsdelogicidDirtyFlag = false;
        this.adpsdelogicid = null;
    }

    public void setADPSDELogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setADPSDELogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.adpsdelogicname = string;
        this.adpsdelogicnameDirtyFlag = true;
    }

    public String getADPSDELogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getADPSDELogicName();
        }
        return this.adpsdelogicname;
    }

    public boolean isADPSDELogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isADPSDELogicNameDirty();
        }
        return this.adpsdelogicnameDirtyFlag;
    }

    public void resetADPSDELogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetADPSDELogicName();
            return;
        }
        this.adpsdelogicnameDirtyFlag = false;
        this.adpsdelogicname = null;
    }

    public void setBottomPos(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBottomPos(n);
            return;
        }
        this.bottompos = n;
        this.bottomposDirtyFlag = true;
    }

    public Integer getBottomPos() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBottomPos();
        }
        return this.bottompos;
    }

    public boolean isBottomPosDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBottomPosDirty();
        }
        return this.bottomposDirtyFlag;
    }

    public void resetBottomPos() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBottomPos();
            return;
        }
        this.bottomposDirtyFlag = false;
        this.bottompos = null;
    }

    public void setBtnActionType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBtnActionType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.btnactiontype = string;
        this.btnactiontypeDirtyFlag = true;
    }

    public String getBtnActionType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBtnActionType();
        }
        return this.btnactiontype;
    }

    public boolean isBtnActionTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBtnActionTypeDirty();
        }
        return this.btnactiontypeDirtyFlag;
    }

    public void resetBtnActionType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBtnActionType();
            return;
        }
        this.btnactiontypeDirtyFlag = false;
        this.btnactiontype = null;
    }

    public void setBusyIndicator(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBusyIndicator(n);
            return;
        }
        this.busyindicator = n;
        this.busyindicatorDirtyFlag = true;
    }

    public Integer getBusyIndicator() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBusyIndicator();
        }
        return this.busyindicator;
    }

    public boolean isBusyIndicatorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBusyIndicatorDirty();
        }
        return this.busyindicatorDirtyFlag;
    }

    public void resetBusyIndicator() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBusyIndicator();
            return;
        }
        this.busyindicatorDirtyFlag = false;
        this.busyindicator = null;
    }

    public void setCapPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCapPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cappslanresid = string;
        this.cappslanresidDirtyFlag = true;
    }

    public String getCapPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCapPSLanResId();
        }
        return this.cappslanresid;
    }

    public boolean isCapPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCapPSLanResIdDirty();
        }
        return this.cappslanresidDirtyFlag;
    }

    public void resetCapPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCapPSLanResId();
            return;
        }
        this.cappslanresidDirtyFlag = false;
        this.cappslanresid = null;
    }

    public void setCapPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCapPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cappslanresname = string;
        this.cappslanresnameDirtyFlag = true;
    }

    public String getCapPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCapPSLanResName();
        }
        return this.cappslanresname;
    }

    public boolean isCapPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCapPSLanResNameDirty();
        }
        return this.cappslanresnameDirtyFlag;
    }

    public void resetCapPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCapPSLanResName();
            return;
        }
        this.cappslanresnameDirtyFlag = false;
        this.cappslanresname = null;
    }

    public void setCaption(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCaption(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.caption = string;
        this.captionDirtyFlag = true;
    }

    public String getCaption() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCaption();
        }
        return this.caption;
    }

    public boolean isCaptionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCaptionDirty();
        }
        return this.captionDirtyFlag;
    }

    public void resetCaption() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCaption();
            return;
        }
        this.captionDirtyFlag = false;
        this.caption = null;
    }

    public void setConfigInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setConfigInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.configinfo = string;
        this.configinfoDirtyFlag = true;
    }

    public String getConfigInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getConfigInfo();
        }
        return this.configinfo;
    }

    public boolean isConfigInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isConfigInfoDirty();
        }
        return this.configinfoDirtyFlag;
    }

    public void resetConfigInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetConfigInfo();
            return;
        }
        this.configinfoDirtyFlag = false;
        this.configinfo = null;
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

    public void setCtrlParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ctrlparam = string;
        this.ctrlparamDirtyFlag = true;
    }

    public String getCtrlParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam();
        }
        return this.ctrlparam;
    }

    public boolean isCtrlParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParamDirty();
        }
        return this.ctrlparamDirtyFlag;
    }

    public void resetCtrlParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam();
            return;
        }
        this.ctrlparamDirtyFlag = false;
        this.ctrlparam = null;
    }

    public void setCtrlParam10(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam10(d);
            return;
        }
        this.ctrlparam10 = d;
        this.ctrlparam10DirtyFlag = true;
    }

    public Double getCtrlParam10() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam10();
        }
        return this.ctrlparam10;
    }

    public boolean isCtrlParam10Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParam10Dirty();
        }
        return this.ctrlparam10DirtyFlag;
    }

    public void resetCtrlParam10() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam10();
            return;
        }
        this.ctrlparam10DirtyFlag = false;
        this.ctrlparam10 = null;
    }

    public void setCtrlParam11(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam11(n);
            return;
        }
        this.ctrlparam11 = n;
        this.ctrlparam11DirtyFlag = true;
    }

    public Integer getCtrlParam11() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam11();
        }
        return this.ctrlparam11;
    }

    public boolean isCtrlParam11Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParam11Dirty();
        }
        return this.ctrlparam11DirtyFlag;
    }

    public void resetCtrlParam11() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam11();
            return;
        }
        this.ctrlparam11DirtyFlag = false;
        this.ctrlparam11 = null;
    }

    public void setCtrlParam12(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam12(n);
            return;
        }
        this.ctrlparam12 = n;
        this.ctrlparam12DirtyFlag = true;
    }

    public Integer getCtrlParam12() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam12();
        }
        return this.ctrlparam12;
    }

    public boolean isCtrlParam12Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParam12Dirty();
        }
        return this.ctrlparam12DirtyFlag;
    }

    public void resetCtrlParam12() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam12();
            return;
        }
        this.ctrlparam12DirtyFlag = false;
        this.ctrlparam12 = null;
    }

    public void setCtrlParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ctrlparam2 = string;
        this.ctrlparam2DirtyFlag = true;
    }

    public String getCtrlParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam2();
        }
        return this.ctrlparam2;
    }

    public boolean isCtrlParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParam2Dirty();
        }
        return this.ctrlparam2DirtyFlag;
    }

    public void resetCtrlParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam2();
            return;
        }
        this.ctrlparam2DirtyFlag = false;
        this.ctrlparam2 = null;
    }

    public void setCtrlParam3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ctrlparam3 = string;
        this.ctrlparam3DirtyFlag = true;
    }

    public String getCtrlParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam3();
        }
        return this.ctrlparam3;
    }

    public boolean isCtrlParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParam3Dirty();
        }
        return this.ctrlparam3DirtyFlag;
    }

    public void resetCtrlParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam3();
            return;
        }
        this.ctrlparam3DirtyFlag = false;
        this.ctrlparam3 = null;
    }

    public void setCtrlParam4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ctrlparam4 = string;
        this.ctrlparam4DirtyFlag = true;
    }

    public String getCtrlParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam4();
        }
        return this.ctrlparam4;
    }

    public boolean isCtrlParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParam4Dirty();
        }
        return this.ctrlparam4DirtyFlag;
    }

    public void resetCtrlParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam4();
            return;
        }
        this.ctrlparam4DirtyFlag = false;
        this.ctrlparam4 = null;
    }

    public void setCtrlParam5(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam5(n);
            return;
        }
        this.ctrlparam5 = n;
        this.ctrlparam5DirtyFlag = true;
    }

    public Integer getCtrlParam5() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam5();
        }
        return this.ctrlparam5;
    }

    public boolean isCtrlParam5Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParam5Dirty();
        }
        return this.ctrlparam5DirtyFlag;
    }

    public void resetCtrlParam5() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam5();
            return;
        }
        this.ctrlparam5DirtyFlag = false;
        this.ctrlparam5 = null;
    }

    public void setCtrlParam6(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam6(n);
            return;
        }
        this.ctrlparam6 = n;
        this.ctrlparam6DirtyFlag = true;
    }

    public Integer getCtrlParam6() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam6();
        }
        return this.ctrlparam6;
    }

    public boolean isCtrlParam6Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParam6Dirty();
        }
        return this.ctrlparam6DirtyFlag;
    }

    public void resetCtrlParam6() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam6();
            return;
        }
        this.ctrlparam6DirtyFlag = false;
        this.ctrlparam6 = null;
    }

    public void setCtrlParam7(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam7(n);
            return;
        }
        this.ctrlparam7 = n;
        this.ctrlparam7DirtyFlag = true;
    }

    public Integer getCtrlParam7() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam7();
        }
        return this.ctrlparam7;
    }

    public boolean isCtrlParam7Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParam7Dirty();
        }
        return this.ctrlparam7DirtyFlag;
    }

    public void resetCtrlParam7() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam7();
            return;
        }
        this.ctrlparam7DirtyFlag = false;
        this.ctrlparam7 = null;
    }

    public void setCtrlParam8(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam8(n);
            return;
        }
        this.ctrlparam8 = n;
        this.ctrlparam8DirtyFlag = true;
    }

    public Integer getCtrlParam8() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam8();
        }
        return this.ctrlparam8;
    }

    public boolean isCtrlParam8Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParam8Dirty();
        }
        return this.ctrlparam8DirtyFlag;
    }

    public void resetCtrlParam8() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam8();
            return;
        }
        this.ctrlparam8DirtyFlag = false;
        this.ctrlparam8 = null;
    }

    public void setCtrlParam9(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam9(d);
            return;
        }
        this.ctrlparam9 = d;
        this.ctrlparam9DirtyFlag = true;
    }

    public Double getCtrlParam9() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam9();
        }
        return this.ctrlparam9;
    }

    public boolean isCtrlParam9Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParam9Dirty();
        }
        return this.ctrlparam9DirtyFlag;
    }

    public void resetCtrlParam9() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam9();
            return;
        }
        this.ctrlparam9DirtyFlag = false;
        this.ctrlparam9 = null;
    }

    public void setCtrlParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ctrlparams = string;
        this.ctrlparamsDirtyFlag = true;
    }

    public String getCtrlParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParams();
        }
        return this.ctrlparams;
    }

    public boolean isCtrlParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParamsDirty();
        }
        return this.ctrlparamsDirtyFlag;
    }

    public void resetCtrlParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParams();
            return;
        }
        this.ctrlparamsDirtyFlag = false;
        this.ctrlparams = null;
    }

    public void setCustomCond(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomCond(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customcond = string;
        this.customcondDirtyFlag = true;
    }

    public String getCustomCond() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomCond();
        }
        return this.customcond;
    }

    public boolean isCustomCondDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomCondDirty();
        }
        return this.customcondDirtyFlag;
    }

    public void resetCustomCond() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomCond();
            return;
        }
        this.customcondDirtyFlag = false;
        this.customcond = null;
    }

    public void setCustomType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customtype = string;
        this.customtypeDirtyFlag = true;
    }

    public String getCustomType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomType();
        }
        return this.customtype;
    }

    public boolean isCustomTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomTypeDirty();
        }
        return this.customtypeDirtyFlag;
    }

    public void resetCustomType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomType();
            return;
        }
        this.customtypeDirtyFlag = false;
        this.customtype = null;
    }

    public void setDefaultFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultFlag(n);
            return;
        }
        this.defaultflag = n;
        this.defaultflagDirtyFlag = true;
    }

    public Integer getDefaultFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultFlag();
        }
        return this.defaultflag;
    }

    public boolean isDefaultFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultFlagDirty();
        }
        return this.defaultflagDirtyFlag;
    }

    public void resetDefaultFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultFlag();
            return;
        }
        this.defaultflagDirtyFlag = false;
        this.defaultflag = null;
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

    public void setDyncMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDyncMode(n);
            return;
        }
        this.dyncmode = n;
        this.dyncmodeDirtyFlag = true;
    }

    public Integer getDyncMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDyncMode();
        }
        return this.dyncmode;
    }

    public boolean isDyncModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDyncModeDirty();
        }
        return this.dyncmodeDirtyFlag;
    }

    public void resetDyncMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDyncMode();
            return;
        }
        this.dyncmodeDirtyFlag = false;
        this.dyncmode = null;
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

    public void setEnableItemPriv(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableItemPriv(n);
            return;
        }
        this.enableitempriv = n;
        this.enableitemprivDirtyFlag = true;
    }

    public Integer getEnableItemPriv() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableItemPriv();
        }
        return this.enableitempriv;
    }

    public boolean isEnableItemPrivDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableItemPrivDirty();
        }
        return this.enableitemprivDirtyFlag;
    }

    public void resetEnableItemPriv() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableItemPriv();
            return;
        }
        this.enableitemprivDirtyFlag = false;
        this.enableitempriv = null;
    }

    public void setEnableViewActions(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableViewActions(n);
            return;
        }
        this.enableviewactions = n;
        this.enableviewactionsDirtyFlag = true;
    }

    public Integer getEnableViewActions() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableViewActions();
        }
        return this.enableviewactions;
    }

    public boolean isEnableViewActionsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableViewActionsDirty();
        }
        return this.enableviewactionsDirtyFlag;
    }

    public void resetEnableViewActions() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableViewActions();
            return;
        }
        this.enableviewactionsDirtyFlag = false;
        this.enableviewactions = null;
    }

    public void setHeight(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHeight(d);
            return;
        }
        this.height = d;
        this.heightDirtyFlag = true;
    }

    public Double getHeight() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHeight();
        }
        return this.height;
    }

    public boolean isHeightDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHeightDirty();
        }
        return this.heightDirtyFlag;
    }

    public void resetHeight() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHeight();
            return;
        }
        this.heightDirtyFlag = false;
        this.height = null;
    }

    public void setInsertPos(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInsertPos(n);
            return;
        }
        this.insertpos = n;
        this.insertposDirtyFlag = true;
    }

    public Integer getInsertPos() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInsertPos();
        }
        return this.insertpos;
    }

    public boolean isInsertPosDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInsertPosDirty();
        }
        return this.insertposDirtyFlag;
    }

    public void resetInsertPos() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInsertPos();
            return;
        }
        this.insertposDirtyFlag = false;
        this.insertpos = null;
    }

    public void setLeftPos(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLeftPos(n);
            return;
        }
        this.leftpos = n;
        this.leftposDirtyFlag = true;
    }

    public Integer getLeftPos() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLeftPos();
        }
        return this.leftpos;
    }

    public boolean isLeftPosDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLeftPosDirty();
        }
        return this.leftposDirtyFlag;
    }

    public void resetLeftPos() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLeftPos();
            return;
        }
        this.leftposDirtyFlag = false;
        this.leftpos = null;
    }

    public void setLocalMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLocalMode(n);
            return;
        }
        this.localmode = n;
        this.localmodeDirtyFlag = true;
    }

    public Integer getLocalMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLocalMode();
        }
        return this.localmode;
    }

    public boolean isLocalModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLocalModeDirty();
        }
        return this.localmodeDirtyFlag;
    }

    public void resetLocalMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLocalMode();
            return;
        }
        this.localmodeDirtyFlag = false;
        this.localmode = null;
    }

    public void setMargin(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMargin(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.margin = string;
        this.marginDirtyFlag = true;
    }

    public String getMargin() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMargin();
        }
        return this.margin;
    }

    public boolean isMarginDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMarginDirty();
        }
        return this.marginDirtyFlag;
    }

    public void resetMargin() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMargin();
            return;
        }
        this.marginDirtyFlag = false;
        this.margin = null;
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

    public void setMultiSelect(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMultiSelect(n);
            return;
        }
        this.multiselect = n;
        this.multiselectDirtyFlag = true;
    }

    public Integer getMultiSelect() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMultiSelect();
        }
        return this.multiselect;
    }

    public boolean isMultiSelectDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMultiSelectDirty();
        }
        return this.multiselectDirtyFlag;
    }

    public void resetMultiSelect() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMultiSelect();
            return;
        }
        this.multiselectDirtyFlag = false;
        this.multiselect = null;
    }

    public void setNO2PSDEUAGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNO2PSDEUAGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no2psdeuagroupid = string;
        this.no2psdeuagroupidDirtyFlag = true;
    }

    public String getNO2PSDEUAGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNO2PSDEUAGroupId();
        }
        return this.no2psdeuagroupid;
    }

    public boolean isNO2PSDEUAGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNO2PSDEUAGroupIdDirty();
        }
        return this.no2psdeuagroupidDirtyFlag;
    }

    public void resetNO2PSDEUAGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNO2PSDEUAGroupId();
            return;
        }
        this.no2psdeuagroupidDirtyFlag = false;
        this.no2psdeuagroupid = null;
    }

    public void setNO2PSDEUAGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNO2PSDEUAGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no2psdeuagroupname = string;
        this.no2psdeuagroupnameDirtyFlag = true;
    }

    public String getNO2PSDEUAGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNO2PSDEUAGroupName();
        }
        return this.no2psdeuagroupname;
    }

    public boolean isNO2PSDEUAGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNO2PSDEUAGroupNameDirty();
        }
        return this.no2psdeuagroupnameDirtyFlag;
    }

    public void resetNO2PSDEUAGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNO2PSDEUAGroupName();
            return;
        }
        this.no2psdeuagroupnameDirtyFlag = false;
        this.no2psdeuagroupname = null;
    }

    public void setNO3PSDEUAGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNO3PSDEUAGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no3psdeuagroupid = string;
        this.no3psdeuagroupidDirtyFlag = true;
    }

    public String getNO3PSDEUAGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNO3PSDEUAGroupId();
        }
        return this.no3psdeuagroupid;
    }

    public boolean isNO3PSDEUAGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNO3PSDEUAGroupIdDirty();
        }
        return this.no3psdeuagroupidDirtyFlag;
    }

    public void resetNO3PSDEUAGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNO3PSDEUAGroupId();
            return;
        }
        this.no3psdeuagroupidDirtyFlag = false;
        this.no3psdeuagroupid = null;
    }

    public void setNO3PSDEUAGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNO3PSDEUAGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no3psdeuagroupname = string;
        this.no3psdeuagroupnameDirtyFlag = true;
    }

    public String getNO3PSDEUAGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNO3PSDEUAGroupName();
        }
        return this.no3psdeuagroupname;
    }

    public boolean isNO3PSDEUAGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNO3PSDEUAGroupNameDirty();
        }
        return this.no3psdeuagroupnameDirtyFlag;
    }

    public void resetNO3PSDEUAGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNO3PSDEUAGroupName();
            return;
        }
        this.no3psdeuagroupnameDirtyFlag = false;
        this.no3psdeuagroupname = null;
    }

    public void setNO4PSDEUAGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNO4PSDEUAGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no4psdeuagroupid = string;
        this.no4psdeuagroupidDirtyFlag = true;
    }

    public String getNO4PSDEUAGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNO4PSDEUAGroupId();
        }
        return this.no4psdeuagroupid;
    }

    public boolean isNO4PSDEUAGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNO4PSDEUAGroupIdDirty();
        }
        return this.no4psdeuagroupidDirtyFlag;
    }

    public void resetNO4PSDEUAGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNO4PSDEUAGroupId();
            return;
        }
        this.no4psdeuagroupidDirtyFlag = false;
        this.no4psdeuagroupid = null;
    }

    public void setNO4PSDEUAGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNO4PSDEUAGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no4psdeuagroupname = string;
        this.no4psdeuagroupnameDirtyFlag = true;
    }

    public String getNO4PSDEUAGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNO4PSDEUAGroupName();
        }
        return this.no4psdeuagroupname;
    }

    public boolean isNO4PSDEUAGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNO4PSDEUAGroupNameDirty();
        }
        return this.no4psdeuagroupnameDirtyFlag;
    }

    public void resetNO4PSDEUAGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNO4PSDEUAGroupName();
            return;
        }
        this.no4psdeuagroupnameDirtyFlag = false;
        this.no4psdeuagroupname = null;
    }

    public void setNO5PSDEUAGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNO5PSDEUAGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no5psdeuagroupid = string;
        this.no5psdeuagroupidDirtyFlag = true;
    }

    public String getNO5PSDEUAGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNO5PSDEUAGroupId();
        }
        return this.no5psdeuagroupid;
    }

    public boolean isNO5PSDEUAGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNO5PSDEUAGroupIdDirty();
        }
        return this.no5psdeuagroupidDirtyFlag;
    }

    public void resetNO5PSDEUAGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNO5PSDEUAGroupId();
            return;
        }
        this.no5psdeuagroupidDirtyFlag = false;
        this.no5psdeuagroupid = null;
    }

    public void setNO5PSDEUAGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNO5PSDEUAGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no5psdeuagroupname = string;
        this.no5psdeuagroupnameDirtyFlag = true;
    }

    public String getNO5PSDEUAGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNO5PSDEUAGroupName();
        }
        return this.no5psdeuagroupname;
    }

    public boolean isNO5PSDEUAGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNO5PSDEUAGroupNameDirty();
        }
        return this.no5psdeuagroupnameDirtyFlag;
    }

    public void resetNO5PSDEUAGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNO5PSDEUAGroupName();
            return;
        }
        this.no5psdeuagroupnameDirtyFlag = false;
        this.no5psdeuagroupname = null;
    }

    public void setNO6PSDEUAGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNO6PSDEUAGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no6psdeuagroupid = string;
        this.no6psdeuagroupidDirtyFlag = true;
    }

    public String getNO6PSDEUAGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNO6PSDEUAGroupId();
        }
        return this.no6psdeuagroupid;
    }

    public boolean isNO6PSDEUAGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNO6PSDEUAGroupIdDirty();
        }
        return this.no6psdeuagroupidDirtyFlag;
    }

    public void resetNO6PSDEUAGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNO6PSDEUAGroupId();
            return;
        }
        this.no6psdeuagroupidDirtyFlag = false;
        this.no6psdeuagroupid = null;
    }

    public void setNO6PSDEUAGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNO6PSDEUAGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no6psdeuagroupname = string;
        this.no6psdeuagroupnameDirtyFlag = true;
    }

    public String getNO6PSDEUAGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNO6PSDEUAGroupName();
        }
        return this.no6psdeuagroupname;
    }

    public boolean isNO6PSDEUAGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNO6PSDEUAGroupNameDirty();
        }
        return this.no6psdeuagroupnameDirtyFlag;
    }

    public void resetNO6PSDEUAGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNO6PSDEUAGroupName();
            return;
        }
        this.no6psdeuagroupnameDirtyFlag = false;
        this.no6psdeuagroupname = null;
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

    public void setPadding(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPadding(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.padding = string;
        this.paddingDirtyFlag = true;
    }

    public String getPadding() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPadding();
        }
        return this.padding;
    }

    public boolean isPaddingDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPaddingDirty();
        }
        return this.paddingDirtyFlag;
    }

    public void resetPadding() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPadding();
            return;
        }
        this.paddingDirtyFlag = false;
        this.padding = null;
    }

    public void setPredefinedType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPredefinedType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.predefinedtype = string;
        this.predefinedtypeDirtyFlag = true;
    }

    public String getPredefinedType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPredefinedType();
        }
        return this.predefinedtype;
    }

    public boolean isPredefinedTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPredefinedTypeDirty();
        }
        return this.predefinedtypeDirtyFlag;
    }

    public void resetPredefinedType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPredefinedType();
            return;
        }
        this.predefinedtypeDirtyFlag = false;
        this.predefinedtype = null;
    }

    public void setPredefinedTypeText(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPredefinedTypeText(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.predefinedtypetext = string;
        this.predefinedtypetextDirtyFlag = true;
    }

    public String getPredefinedTypeText() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPredefinedTypeText();
        }
        return this.predefinedtypetext;
    }

    public boolean isPredefinedTypeTextDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPredefinedTypeTextDirty();
        }
        return this.predefinedtypetextDirtyFlag;
    }

    public void resetPredefinedTypeText() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPredefinedTypeText();
            return;
        }
        this.predefinedtypetextDirtyFlag = false;
        this.predefinedtypetext = null;
    }

    public void setPSACHandlerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSACHandlerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psachandlerid = string;
        this.psachandleridDirtyFlag = true;
    }

    public String getPSACHandlerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSACHandlerId();
        }
        return this.psachandlerid;
    }

    public boolean isPSACHandlerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSACHandlerIdDirty();
        }
        return this.psachandleridDirtyFlag;
    }

    public void resetPSACHandlerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSACHandlerId();
            return;
        }
        this.psachandleridDirtyFlag = false;
        this.psachandlerid = null;
    }

    public void setPSACHandlerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSACHandlerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psachandlername = string;
        this.psachandlernameDirtyFlag = true;
    }

    public String getPSACHandlerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSACHandlerName();
        }
        return this.psachandlername;
    }

    public boolean isPSACHandlerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSACHandlerNameDirty();
        }
        return this.psachandlernameDirtyFlag;
    }

    public void resetPSACHandlerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSACHandlerName();
            return;
        }
        this.psachandlernameDirtyFlag = false;
        this.psachandlername = null;
    }

    public void setPSCtrlId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrlid = string;
        this.psctrlidDirtyFlag = true;
    }

    public String getPSCtrlId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlId();
        }
        return this.psctrlid;
    }

    public boolean isPSCtrlIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlIdDirty();
        }
        return this.psctrlidDirtyFlag;
    }

    public void resetPSCtrlId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlId();
            return;
        }
        this.psctrlidDirtyFlag = false;
        this.psctrlid = null;
    }

    public void setPSCtrlLogicGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlLogicGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrllogicgroupid = string;
        this.psctrllogicgroupidDirtyFlag = true;
    }

    public String getPSCtrlLogicGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlLogicGroupId();
        }
        return this.psctrllogicgroupid;
    }

    public boolean isPSCtrlLogicGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlLogicGroupIdDirty();
        }
        return this.psctrllogicgroupidDirtyFlag;
    }

    public void resetPSCtrlLogicGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlLogicGroupId();
            return;
        }
        this.psctrllogicgroupidDirtyFlag = false;
        this.psctrllogicgroupid = null;
    }

    public void setPSCtrlLogicGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlLogicGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrllogicgroupname = string;
        this.psctrllogicgroupnameDirtyFlag = true;
    }

    public String getPSCtrlLogicGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlLogicGroupName();
        }
        return this.psctrllogicgroupname;
    }

    public boolean isPSCtrlLogicGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlLogicGroupNameDirty();
        }
        return this.psctrllogicgroupnameDirtyFlag;
    }

    public void resetPSCtrlLogicGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlLogicGroupName();
            return;
        }
        this.psctrllogicgroupnameDirtyFlag = false;
        this.psctrllogicgroupname = null;
    }

    public void setPSCtrlMsgId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlMsgId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrlmsgid = string;
        this.psctrlmsgidDirtyFlag = true;
    }

    public String getPSCtrlMsgId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlMsgId();
        }
        return this.psctrlmsgid;
    }

    public boolean isPSCtrlMsgIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlMsgIdDirty();
        }
        return this.psctrlmsgidDirtyFlag;
    }

    public void resetPSCtrlMsgId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlMsgId();
            return;
        }
        this.psctrlmsgidDirtyFlag = false;
        this.psctrlmsgid = null;
    }

    public void setPSCtrlMsgName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlMsgName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrlmsgname = string;
        this.psctrlmsgnameDirtyFlag = true;
    }

    public String getPSCtrlMsgName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlMsgName();
        }
        return this.psctrlmsgname;
    }

    public boolean isPSCtrlMsgNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlMsgNameDirty();
        }
        return this.psctrlmsgnameDirtyFlag;
    }

    public void resetPSCtrlMsgName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlMsgName();
            return;
        }
        this.psctrlmsgnameDirtyFlag = false;
        this.psctrlmsgname = null;
    }

    public void setPSCtrlName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrlname = string;
        this.psctrlnameDirtyFlag = true;
    }

    public String getPSCtrlName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlName();
        }
        return this.psctrlname;
    }

    public boolean isPSCtrlNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlNameDirty();
        }
        return this.psctrlnameDirtyFlag;
    }

    public void resetPSCtrlName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlName();
            return;
        }
        this.psctrlnameDirtyFlag = false;
        this.psctrlname = null;
    }

    public void setPSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeactionid = string;
        this.psdeactionidDirtyFlag = true;
    }

    public String getPSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionId();
        }
        return this.psdeactionid;
    }

    public boolean isPSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEActionIdDirty();
        }
        return this.psdeactionidDirtyFlag;
    }

    public void resetPSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEActionId();
            return;
        }
        this.psdeactionidDirtyFlag = false;
        this.psdeactionid = null;
    }

    public void setPSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeactionname = string;
        this.psdeactionnameDirtyFlag = true;
    }

    public String getPSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionName();
        }
        return this.psdeactionname;
    }

    public boolean isPSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEActionNameDirty();
        }
        return this.psdeactionnameDirtyFlag;
    }

    public void resetPSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEActionName();
            return;
        }
        this.psdeactionnameDirtyFlag = false;
        this.psdeactionname = null;
    }

    public void setPSDEChartId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEChartId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdechartid = string;
        this.psdechartidDirtyFlag = true;
    }

    public String getPSDEChartId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEChartId();
        }
        return this.psdechartid;
    }

    public boolean isPSDEChartIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEChartIdDirty();
        }
        return this.psdechartidDirtyFlag;
    }

    public void resetPSDEChartId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEChartId();
            return;
        }
        this.psdechartidDirtyFlag = false;
        this.psdechartid = null;
    }

    public void setPSDEChartName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEChartName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdechartname = string;
        this.psdechartnameDirtyFlag = true;
    }

    public String getPSDEChartName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEChartName();
        }
        return this.psdechartname;
    }

    public boolean isPSDEChartNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEChartNameDirty();
        }
        return this.psdechartnameDirtyFlag;
    }

    public void resetPSDEChartName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEChartName();
            return;
        }
        this.psdechartnameDirtyFlag = false;
        this.psdechartname = null;
    }

    public void setPSDEDataExpId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataExpId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedataexpid = string;
        this.psdedataexpidDirtyFlag = true;
    }

    public String getPSDEDataExpId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataExpId();
        }
        return this.psdedataexpid;
    }

    public boolean isPSDEDataExpIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataExpIdDirty();
        }
        return this.psdedataexpidDirtyFlag;
    }

    public void resetPSDEDataExpId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataExpId();
            return;
        }
        this.psdedataexpidDirtyFlag = false;
        this.psdedataexpid = null;
    }

    public void setPSDEDataExpName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataExpName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedataexpname = string;
        this.psdedataexpnameDirtyFlag = true;
    }

    public String getPSDEDataExpName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataExpName();
        }
        return this.psdedataexpname;
    }

    public boolean isPSDEDataExpNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataExpNameDirty();
        }
        return this.psdedataexpnameDirtyFlag;
    }

    public void resetPSDEDataExpName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataExpName();
            return;
        }
        this.psdedataexpnameDirtyFlag = false;
        this.psdedataexpname = null;
    }

    public void setPSDEDataImpId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataImpId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedataimpid = string;
        this.psdedataimpidDirtyFlag = true;
    }

    public String getPSDEDataImpId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataImpId();
        }
        return this.psdedataimpid;
    }

    public boolean isPSDEDataImpIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataImpIdDirty();
        }
        return this.psdedataimpidDirtyFlag;
    }

    public void resetPSDEDataImpId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataImpId();
            return;
        }
        this.psdedataimpidDirtyFlag = false;
        this.psdedataimpid = null;
    }

    public void setPSDEDataImpName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataImpName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedataimpname = string;
        this.psdedataimpnameDirtyFlag = true;
    }

    public String getPSDEDataImpName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataImpName();
        }
        return this.psdedataimpname;
    }

    public boolean isPSDEDataImpNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataImpNameDirty();
        }
        return this.psdedataimpnameDirtyFlag;
    }

    public void resetPSDEDataImpName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataImpName();
            return;
        }
        this.psdedataimpnameDirtyFlag = false;
        this.psdedataimpname = null;
    }

    public void setPSDEDataSetId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataSetId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedatasetid = string;
        this.psdedatasetidDirtyFlag = true;
    }

    public String getPSDEDataSetId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataSetId();
        }
        return this.psdedatasetid;
    }

    public boolean isPSDEDataSetIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataSetIdDirty();
        }
        return this.psdedatasetidDirtyFlag;
    }

    public void resetPSDEDataSetId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataSetId();
            return;
        }
        this.psdedatasetidDirtyFlag = false;
        this.psdedatasetid = null;
    }

    public void setPSDEDataSetName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataSetName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedatasetname = string;
        this.psdedatasetnameDirtyFlag = true;
    }

    public String getPSDEDataSetName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataSetName();
        }
        return this.psdedatasetname;
    }

    public boolean isPSDEDataSetNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataSetNameDirty();
        }
        return this.psdedatasetnameDirtyFlag;
    }

    public void resetPSDEDataSetName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataSetName();
            return;
        }
        this.psdedatasetnameDirtyFlag = false;
        this.psdedatasetname = null;
    }

    public void setPSDEDataViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedataviewid = string;
        this.psdedataviewidDirtyFlag = true;
    }

    public String getPSDEDataViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataViewId();
        }
        return this.psdedataviewid;
    }

    public boolean isPSDEDataViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataViewIdDirty();
        }
        return this.psdedataviewidDirtyFlag;
    }

    public void resetPSDEDataViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataViewId();
            return;
        }
        this.psdedataviewidDirtyFlag = false;
        this.psdedataviewid = null;
    }

    public void setPSDEDataViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedataviewname = string;
        this.psdedataviewnameDirtyFlag = true;
    }

    public String getPSDEDataViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataViewName();
        }
        return this.psdedataviewname;
    }

    public boolean isPSDEDataViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataViewNameDirty();
        }
        return this.psdedataviewnameDirtyFlag;
    }

    public void resetPSDEDataViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataViewName();
            return;
        }
        this.psdedataviewnameDirtyFlag = false;
        this.psdedataviewname = null;
    }

    public void setPSDEDRId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDRId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedrid = string;
        this.psdedridDirtyFlag = true;
    }

    public String getPSDEDRId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDRId();
        }
        return this.psdedrid;
    }

    public boolean isPSDEDRIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDRIdDirty();
        }
        return this.psdedridDirtyFlag;
    }

    public void resetPSDEDRId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDRId();
            return;
        }
        this.psdedridDirtyFlag = false;
        this.psdedrid = null;
    }

    public void setPSDEDRName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDRName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedrname = string;
        this.psdedrnameDirtyFlag = true;
    }

    public String getPSDEDRName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDRName();
        }
        return this.psdedrname;
    }

    public boolean isPSDEDRNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDRNameDirty();
        }
        return this.psdedrnameDirtyFlag;
    }

    public void resetPSDEDRName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDRName();
            return;
        }
        this.psdedrnameDirtyFlag = false;
        this.psdedrname = null;
    }

    public void setPSDEFormId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFormId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeformid = string;
        this.psdeformidDirtyFlag = true;
    }

    public String getPSDEFormId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFormId();
        }
        return this.psdeformid;
    }

    public boolean isPSDEFormIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFormIdDirty();
        }
        return this.psdeformidDirtyFlag;
    }

    public void resetPSDEFormId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFormId();
            return;
        }
        this.psdeformidDirtyFlag = false;
        this.psdeformid = null;
    }

    public void setPSDEFormName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFormName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeformname = string;
        this.psdeformnameDirtyFlag = true;
    }

    public String getPSDEFormName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFormName();
        }
        return this.psdeformname;
    }

    public boolean isPSDEFormNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFormNameDirty();
        }
        return this.psdeformnameDirtyFlag;
    }

    public void resetPSDEFormName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFormName();
            return;
        }
        this.psdeformnameDirtyFlag = false;
        this.psdeformname = null;
    }

    public void setPSDEGridId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEGridId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdegridid = string;
        this.psdegrididDirtyFlag = true;
    }

    public String getPSDEGridId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGridId();
        }
        return this.psdegridid;
    }

    public boolean isPSDEGridIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEGridIdDirty();
        }
        return this.psdegrididDirtyFlag;
    }

    public void resetPSDEGridId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEGridId();
            return;
        }
        this.psdegrididDirtyFlag = false;
        this.psdegridid = null;
    }

    public void setPSDEGridName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEGridName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdegridname = string;
        this.psdegridnameDirtyFlag = true;
    }

    public String getPSDEGridName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGridName();
        }
        return this.psdegridname;
    }

    public boolean isPSDEGridNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEGridNameDirty();
        }
        return this.psdegridnameDirtyFlag;
    }

    public void resetPSDEGridName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEGridName();
            return;
        }
        this.psdegridnameDirtyFlag = false;
        this.psdegridname = null;
    }

    public void setPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeid = string;
        this.psdeidDirtyFlag = true;
    }

    public String getPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEId();
        }
        return this.psdeid;
    }

    public boolean isPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEIdDirty();
        }
        return this.psdeidDirtyFlag;
    }

    public void resetPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEId();
            return;
        }
        this.psdeidDirtyFlag = false;
        this.psdeid = null;
    }

    public void setPSDEListId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEListId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdelistid = string;
        this.psdelistidDirtyFlag = true;
    }

    public String getPSDEListId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEListId();
        }
        return this.psdelistid;
    }

    public boolean isPSDEListIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEListIdDirty();
        }
        return this.psdelistidDirtyFlag;
    }

    public void resetPSDEListId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEListId();
            return;
        }
        this.psdelistidDirtyFlag = false;
        this.psdelistid = null;
    }

    public void setPSDEListName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEListName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdelistname = string;
        this.psdelistnameDirtyFlag = true;
    }

    public String getPSDEListName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEListName();
        }
        return this.psdelistname;
    }

    public boolean isPSDEListNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEListNameDirty();
        }
        return this.psdelistnameDirtyFlag;
    }

    public void resetPSDEListName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEListName();
            return;
        }
        this.psdelistnameDirtyFlag = false;
        this.psdelistname = null;
    }

    public void setPSDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdename = string;
        this.psdenameDirtyFlag = true;
    }

    public String getPSDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEName();
        }
        return this.psdename;
    }

    public boolean isPSDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDENameDirty();
        }
        return this.psdenameDirtyFlag;
    }

    public void resetPSDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEName();
            return;
        }
        this.psdenameDirtyFlag = false;
        this.psdename = null;
    }

    public void setPSDEOPPrivId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEOPPrivId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeopprivid = string;
        this.psdeopprividDirtyFlag = true;
    }

    public String getPSDEOPPrivId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEOPPrivId();
        }
        return this.psdeopprivid;
    }

    public boolean isPSDEOPPrivIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEOPPrivIdDirty();
        }
        return this.psdeopprividDirtyFlag;
    }

    public void resetPSDEOPPrivId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEOPPrivId();
            return;
        }
        this.psdeopprividDirtyFlag = false;
        this.psdeopprivid = null;
    }

    public void setPSDEOPPrivName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEOPPrivName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeopprivname = string;
        this.psdeopprivnameDirtyFlag = true;
    }

    public String getPSDEOPPrivName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEOPPrivName();
        }
        return this.psdeopprivname;
    }

    public boolean isPSDEOPPrivNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEOPPrivNameDirty();
        }
        return this.psdeopprivnameDirtyFlag;
    }

    public void resetPSDEOPPrivName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEOPPrivName();
            return;
        }
        this.psdeopprivnameDirtyFlag = false;
        this.psdeopprivname = null;
    }

    public void setPSDEReportId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEReportId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdereportid = string;
        this.psdereportidDirtyFlag = true;
    }

    public String getPSDEReportId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEReportId();
        }
        return this.psdereportid;
    }

    public boolean isPSDEReportIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEReportIdDirty();
        }
        return this.psdereportidDirtyFlag;
    }

    public void resetPSDEReportId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEReportId();
            return;
        }
        this.psdereportidDirtyFlag = false;
        this.psdereportid = null;
    }

    public void setPSDEReportName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEReportName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdereportname = string;
        this.psdereportnameDirtyFlag = true;
    }

    public String getPSDEReportName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEReportName();
        }
        return this.psdereportname;
    }

    public boolean isPSDEReportNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEReportNameDirty();
        }
        return this.psdereportnameDirtyFlag;
    }

    public void resetPSDEReportName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEReportName();
            return;
        }
        this.psdereportnameDirtyFlag = false;
        this.psdereportname = null;
    }

    public void setPSDEToolbarId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEToolbarId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdetoolbarid = string;
        this.psdetoolbaridDirtyFlag = true;
    }

    public String getPSDEToolbarId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEToolbarId();
        }
        return this.psdetoolbarid;
    }

    public boolean isPSDEToolbarIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEToolbarIdDirty();
        }
        return this.psdetoolbaridDirtyFlag;
    }

    public void resetPSDEToolbarId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEToolbarId();
            return;
        }
        this.psdetoolbaridDirtyFlag = false;
        this.psdetoolbarid = null;
    }

    public void setPSDEToolbarName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEToolbarName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdetoolbarname = string;
        this.psdetoolbarnameDirtyFlag = true;
    }

    public String getPSDEToolbarName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEToolbarName();
        }
        return this.psdetoolbarname;
    }

    public boolean isPSDEToolbarNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEToolbarNameDirty();
        }
        return this.psdetoolbarnameDirtyFlag;
    }

    public void resetPSDEToolbarName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEToolbarName();
            return;
        }
        this.psdetoolbarnameDirtyFlag = false;
        this.psdetoolbarname = null;
    }

    public void setPSDETreeViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDETreeViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdetreeviewid = string;
        this.psdetreeviewidDirtyFlag = true;
    }

    public String getPSDETreeViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETreeViewId();
        }
        return this.psdetreeviewid;
    }

    public boolean isPSDETreeViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDETreeViewIdDirty();
        }
        return this.psdetreeviewidDirtyFlag;
    }

    public void resetPSDETreeViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDETreeViewId();
            return;
        }
        this.psdetreeviewidDirtyFlag = false;
        this.psdetreeviewid = null;
    }

    public void setPSDETreeViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDETreeViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdetreeviewname = string;
        this.psdetreeviewnameDirtyFlag = true;
    }

    public String getPSDETreeViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETreeViewName();
        }
        return this.psdetreeviewname;
    }

    public boolean isPSDETreeViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDETreeViewNameDirty();
        }
        return this.psdetreeviewnameDirtyFlag;
    }

    public void resetPSDETreeViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDETreeViewName();
            return;
        }
        this.psdetreeviewnameDirtyFlag = false;
        this.psdetreeviewname = null;
    }

    public void setPSDEUAGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEUAGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeuagroupid = string;
        this.psdeuagroupidDirtyFlag = true;
    }

    public String getPSDEUAGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUAGroupId();
        }
        return this.psdeuagroupid;
    }

    public boolean isPSDEUAGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEUAGroupIdDirty();
        }
        return this.psdeuagroupidDirtyFlag;
    }

    public void resetPSDEUAGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEUAGroupId();
            return;
        }
        this.psdeuagroupidDirtyFlag = false;
        this.psdeuagroupid = null;
    }

    public void setPSDEUAGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEUAGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeuagroupname = string;
        this.psdeuagroupnameDirtyFlag = true;
    }

    public String getPSDEUAGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUAGroupName();
        }
        return this.psdeuagroupname;
    }

    public boolean isPSDEUAGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEUAGroupNameDirty();
        }
        return this.psdeuagroupnameDirtyFlag;
    }

    public void resetPSDEUAGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEUAGroupName();
            return;
        }
        this.psdeuagroupnameDirtyFlag = false;
        this.psdeuagroupname = null;
    }

    public void setPSDEViewBaseId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewBaseId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewbaseid = string;
        this.psdeviewbaseidDirtyFlag = true;
    }

    public String getPSDEViewBaseId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBaseId();
        }
        return this.psdeviewbaseid;
    }

    public boolean isPSDEViewBaseIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewBaseIdDirty();
        }
        return this.psdeviewbaseidDirtyFlag;
    }

    public void resetPSDEViewBaseId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewBaseId();
            return;
        }
        this.psdeviewbaseidDirtyFlag = false;
        this.psdeviewbaseid = null;
    }

    public void setPSDEViewBaseName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewBaseName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewbasename = string;
        this.psdeviewbasenameDirtyFlag = true;
    }

    public String getPSDEViewBaseName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBaseName();
        }
        return this.psdeviewbasename;
    }

    public boolean isPSDEViewBaseNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewBaseNameDirty();
        }
        return this.psdeviewbasenameDirtyFlag;
    }

    public void resetPSDEViewBaseName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewBaseName();
            return;
        }
        this.psdeviewbasenameDirtyFlag = false;
        this.psdeviewbasename = null;
    }

    public void setPSDEViewCtrlId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewCtrlId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewctrlid = string;
        this.psdeviewctrlidDirtyFlag = true;
    }

    public String getPSDEViewCtrlId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewCtrlId();
        }
        return this.psdeviewctrlid;
    }

    public boolean isPSDEViewCtrlIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewCtrlIdDirty();
        }
        return this.psdeviewctrlidDirtyFlag;
    }

    public void resetPSDEViewCtrlId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewCtrlId();
            return;
        }
        this.psdeviewctrlidDirtyFlag = false;
        this.psdeviewctrlid = null;
    }

    public void setPSDEViewCtrlName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewCtrlName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        if (string != null) {
            string = string.toUpperCase();
        }
        this.psdeviewctrlname = string;
        this.psdeviewctrlnameDirtyFlag = true;
    }

    public String getPSDEViewCtrlName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewCtrlName();
        }
        return this.psdeviewctrlname;
    }

    public boolean isPSDEViewCtrlNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewCtrlNameDirty();
        }
        return this.psdeviewctrlnameDirtyFlag;
    }

    public void resetPSDEViewCtrlName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewCtrlName();
            return;
        }
        this.psdeviewctrlnameDirtyFlag = false;
        this.psdeviewctrlname = null;
    }

    public void setPSDEViewCtrlType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewCtrlType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewctrltype = string;
        this.psdeviewctrltypeDirtyFlag = true;
    }

    public String getPSDEViewCtrlType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewCtrlType();
        }
        return this.psdeviewctrltype;
    }

    public boolean isPSDEViewCtrlTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewCtrlTypeDirty();
        }
        return this.psdeviewctrltypeDirtyFlag;
    }

    public void resetPSDEViewCtrlType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewCtrlType();
            return;
        }
        this.psdeviewctrltypeDirtyFlag = false;
        this.psdeviewctrltype = null;
    }

    public void setPSDEViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewid = string;
        this.psdeviewidDirtyFlag = true;
    }

    public String getPSDEViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewId();
        }
        return this.psdeviewid;
    }

    public boolean isPSDEViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewIdDirty();
        }
        return this.psdeviewidDirtyFlag;
    }

    public void resetPSDEViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewId();
            return;
        }
        this.psdeviewidDirtyFlag = false;
        this.psdeviewid = null;
    }

    public void setPSDEViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewname = string;
        this.psdeviewnameDirtyFlag = true;
    }

    public String getPSDEViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewName();
        }
        return this.psdeviewname;
    }

    public boolean isPSDEViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewNameDirty();
        }
        return this.psdeviewnameDirtyFlag;
    }

    public void resetPSDEViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewName();
            return;
        }
        this.psdeviewnameDirtyFlag = false;
        this.psdeviewname = null;
    }

    public void setPSDEWizardId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEWizardId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdewizardid = string;
        this.psdewizardidDirtyFlag = true;
    }

    public String getPSDEWizardId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEWizardId();
        }
        return this.psdewizardid;
    }

    public boolean isPSDEWizardIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEWizardIdDirty();
        }
        return this.psdewizardidDirtyFlag;
    }

    public void resetPSDEWizardId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEWizardId();
            return;
        }
        this.psdewizardidDirtyFlag = false;
        this.psdewizardid = null;
    }

    public void setPSDEWizardName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEWizardName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdewizardname = string;
        this.psdewizardnameDirtyFlag = true;
    }

    public String getPSDEWizardName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEWizardName();
        }
        return this.psdewizardname;
    }

    public boolean isPSDEWizardNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEWizardNameDirty();
        }
        return this.psdewizardnameDirtyFlag;
    }

    public void resetPSDEWizardName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEWizardName();
            return;
        }
        this.psdewizardnameDirtyFlag = false;
        this.psdewizardname = null;
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

    public void setPSPFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfid = string;
        this.pspfidDirtyFlag = true;
    }

    public String getPSPFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFId();
        }
        return this.pspfid;
    }

    public boolean isPSPFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFIdDirty();
        }
        return this.pspfidDirtyFlag;
    }

    public void resetPSPFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFId();
            return;
        }
        this.pspfidDirtyFlag = false;
        this.pspfid = null;
    }

    public void setPSPFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfname = string;
        this.pspfnameDirtyFlag = true;
    }

    public String getPSPFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFName();
        }
        return this.pspfname;
    }

    public boolean isPSPFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFNameDirty();
        }
        return this.pspfnameDirtyFlag;
    }

    public void resetPSPFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFName();
            return;
        }
        this.pspfnameDirtyFlag = false;
        this.pspfname = null;
    }

    public void setPSSysCalendarId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCalendarId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscalendarid = string;
        this.pssyscalendaridDirtyFlag = true;
    }

    public String getPSSysCalendarId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCalendarId();
        }
        return this.pssyscalendarid;
    }

    public boolean isPSSysCalendarIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCalendarIdDirty();
        }
        return this.pssyscalendaridDirtyFlag;
    }

    public void resetPSSysCalendarId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCalendarId();
            return;
        }
        this.pssyscalendaridDirtyFlag = false;
        this.pssyscalendarid = null;
    }

    public void setPSSysCalendarName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCalendarName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscalendarname = string;
        this.pssyscalendarnameDirtyFlag = true;
    }

    public String getPSSysCalendarName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCalendarName();
        }
        return this.pssyscalendarname;
    }

    public boolean isPSSysCalendarNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCalendarNameDirty();
        }
        return this.pssyscalendarnameDirtyFlag;
    }

    public void resetPSSysCalendarName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCalendarName();
            return;
        }
        this.pssyscalendarnameDirtyFlag = false;
        this.pssyscalendarname = null;
    }

    public void setPSSysCounterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCounterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscounterid = string;
        this.pssyscounteridDirtyFlag = true;
    }

    public String getPSSysCounterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCounterId();
        }
        return this.pssyscounterid;
    }

    public boolean isPSSysCounterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCounterIdDirty();
        }
        return this.pssyscounteridDirtyFlag;
    }

    public void resetPSSysCounterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCounterId();
            return;
        }
        this.pssyscounteridDirtyFlag = false;
        this.pssyscounterid = null;
    }

    public void setPSSysCounterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCounterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscountername = string;
        this.pssyscounternameDirtyFlag = true;
    }

    public String getPSSysCounterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCounterName();
        }
        return this.pssyscountername;
    }

    public boolean isPSSysCounterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCounterNameDirty();
        }
        return this.pssyscounternameDirtyFlag;
    }

    public void resetPSSysCounterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCounterName();
            return;
        }
        this.pssyscounternameDirtyFlag = false;
        this.pssyscountername = null;
    }

    public void setPSSysCssId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCssId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscssid = string;
        this.pssyscssidDirtyFlag = true;
    }

    public String getPSSysCssId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCssId();
        }
        return this.pssyscssid;
    }

    public boolean isPSSysCssIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCssIdDirty();
        }
        return this.pssyscssidDirtyFlag;
    }

    public void resetPSSysCssId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCssId();
            return;
        }
        this.pssyscssidDirtyFlag = false;
        this.pssyscssid = null;
    }

    public void setPSSysCssName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCssName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscssname = string;
        this.pssyscssnameDirtyFlag = true;
    }

    public String getPSSysCssName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCssName();
        }
        return this.pssyscssname;
    }

    public boolean isPSSysCssNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCssNameDirty();
        }
        return this.pssyscssnameDirtyFlag;
    }

    public void resetPSSysCssName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCssName();
            return;
        }
        this.pssyscssnameDirtyFlag = false;
        this.pssyscssname = null;
    }

    public void setPSSysDashboardId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDashboardId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdashboardid = string;
        this.pssysdashboardidDirtyFlag = true;
    }

    public String getPSSysDashboardId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDashboardId();
        }
        return this.pssysdashboardid;
    }

    public boolean isPSSysDashboardIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDashboardIdDirty();
        }
        return this.pssysdashboardidDirtyFlag;
    }

    public void resetPSSysDashboardId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDashboardId();
            return;
        }
        this.pssysdashboardidDirtyFlag = false;
        this.pssysdashboardid = null;
    }

    public void setPSSysDashboardName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDashboardName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdashboardname = string;
        this.pssysdashboardnameDirtyFlag = true;
    }

    public String getPSSysDashboardName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDashboardName();
        }
        return this.pssysdashboardname;
    }

    public boolean isPSSysDashboardNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDashboardNameDirty();
        }
        return this.pssysdashboardnameDirtyFlag;
    }

    public void resetPSSysDashboardName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDashboardName();
            return;
        }
        this.pssysdashboardnameDirtyFlag = false;
        this.pssysdashboardname = null;
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

    public void setPSSysMapViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysMapViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmapviewid = string;
        this.pssysmapviewidDirtyFlag = true;
    }

    public String getPSSysMapViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMapViewId();
        }
        return this.pssysmapviewid;
    }

    public boolean isPSSysMapViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysMapViewIdDirty();
        }
        return this.pssysmapviewidDirtyFlag;
    }

    public void resetPSSysMapViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysMapViewId();
            return;
        }
        this.pssysmapviewidDirtyFlag = false;
        this.pssysmapviewid = null;
    }

    public void setPSSysMapViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysMapViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmapviewname = string;
        this.pssysmapviewnameDirtyFlag = true;
    }

    public String getPSSysMapViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMapViewName();
        }
        return this.pssysmapviewname;
    }

    public boolean isPSSysMapViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysMapViewNameDirty();
        }
        return this.pssysmapviewnameDirtyFlag;
    }

    public void resetPSSysMapViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysMapViewName();
            return;
        }
        this.pssysmapviewnameDirtyFlag = false;
        this.pssysmapviewname = null;
    }

    public void setPSSysMsgTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysMsgTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmsgtemplid = string;
        this.pssysmsgtemplidDirtyFlag = true;
    }

    public String getPSSysMsgTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMsgTemplId();
        }
        return this.pssysmsgtemplid;
    }

    public boolean isPSSysMsgTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysMsgTemplIdDirty();
        }
        return this.pssysmsgtemplidDirtyFlag;
    }

    public void resetPSSysMsgTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysMsgTemplId();
            return;
        }
        this.pssysmsgtemplidDirtyFlag = false;
        this.pssysmsgtemplid = null;
    }

    public void setPSSysMsgTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysMsgTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmsgtemplname = string;
        this.pssysmsgtemplnameDirtyFlag = true;
    }

    public String getPSSysMsgTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMsgTemplName();
        }
        return this.pssysmsgtemplname;
    }

    public boolean isPSSysMsgTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysMsgTemplNameDirty();
        }
        return this.pssysmsgtemplnameDirtyFlag;
    }

    public void resetPSSysMsgTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysMsgTemplName();
            return;
        }
        this.pssysmsgtemplnameDirtyFlag = false;
        this.pssysmsgtemplname = null;
    }

    public void setPSSysPFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyspfpluginid = string;
        this.pssyspfpluginidDirtyFlag = true;
    }

    public String getPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPluginId();
        }
        return this.pssyspfpluginid;
    }

    public boolean isPSSysPFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPFPluginIdDirty();
        }
        return this.pssyspfpluginidDirtyFlag;
    }

    public void resetPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPFPluginId();
            return;
        }
        this.pssyspfpluginidDirtyFlag = false;
        this.pssyspfpluginid = null;
    }

    public void setPSSysPFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyspfpluginname = string;
        this.pssyspfpluginnameDirtyFlag = true;
    }

    public String getPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPluginName();
        }
        return this.pssyspfpluginname;
    }

    public boolean isPSSysPFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPFPluginNameDirty();
        }
        return this.pssyspfpluginnameDirtyFlag;
    }

    public void resetPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPFPluginName();
            return;
        }
        this.pssyspfpluginnameDirtyFlag = false;
        this.pssyspfpluginname = null;
    }

    public void setPSSysSearchBarId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSearchBarId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssearchbarid = string;
        this.pssyssearchbaridDirtyFlag = true;
    }

    public String getPSSysSearchBarId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchBarId();
        }
        return this.pssyssearchbarid;
    }

    public boolean isPSSysSearchBarIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSearchBarIdDirty();
        }
        return this.pssyssearchbaridDirtyFlag;
    }

    public void resetPSSysSearchBarId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSearchBarId();
            return;
        }
        this.pssyssearchbaridDirtyFlag = false;
        this.pssyssearchbarid = null;
    }

    public void setPSSysSearchBarName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSearchBarName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssearchbarname = string;
        this.pssyssearchbarnameDirtyFlag = true;
    }

    public String getPSSysSearchBarName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchBarName();
        }
        return this.pssyssearchbarname;
    }

    public boolean isPSSysSearchBarNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSearchBarNameDirty();
        }
        return this.pssyssearchbarnameDirtyFlag;
    }

    public void resetPSSysSearchBarName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSearchBarName();
            return;
        }
        this.pssyssearchbarnameDirtyFlag = false;
        this.pssyssearchbarname = null;
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

    public void setPSSysViewPanelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysViewPanelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysviewpanelid = string;
        this.pssysviewpanelidDirtyFlag = true;
    }

    public String getPSSysViewPanelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanelId();
        }
        return this.pssysviewpanelid;
    }

    public boolean isPSSysViewPanelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysViewPanelIdDirty();
        }
        return this.pssysviewpanelidDirtyFlag;
    }

    public void resetPSSysViewPanelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysViewPanelId();
            return;
        }
        this.pssysviewpanelidDirtyFlag = false;
        this.pssysviewpanelid = null;
    }

    public void setPSSysViewPanelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysViewPanelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysviewpanelname = string;
        this.pssysviewpanelnameDirtyFlag = true;
    }

    public String getPSSysViewPanelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanelName();
        }
        return this.pssysviewpanelname;
    }

    public boolean isPSSysViewPanelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysViewPanelNameDirty();
        }
        return this.pssysviewpanelnameDirtyFlag;
    }

    public void resetPSSysViewPanelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysViewPanelName();
            return;
        }
        this.pssysviewpanelnameDirtyFlag = false;
        this.pssysviewpanelname = null;
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

    public void setRefCtrl2Name(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefCtrl2Name(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refctrl2name = string;
        this.refctrl2nameDirtyFlag = true;
    }

    public String getRefCtrl2Name() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefCtrl2Name();
        }
        return this.refctrl2name;
    }

    public boolean isRefCtrl2NameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefCtrl2NameDirty();
        }
        return this.refctrl2nameDirtyFlag;
    }

    public void resetRefCtrl2Name() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefCtrl2Name();
            return;
        }
        this.refctrl2nameDirtyFlag = false;
        this.refctrl2name = null;
    }

    public void setRefCtrl2Usage(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefCtrl2Usage(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refctrl2usage = string;
        this.refctrl2usageDirtyFlag = true;
    }

    public String getRefCtrl2Usage() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefCtrl2Usage();
        }
        return this.refctrl2usage;
    }

    public boolean isRefCtrl2UsageDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefCtrl2UsageDirty();
        }
        return this.refctrl2usageDirtyFlag;
    }

    public void resetRefCtrl2Usage() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefCtrl2Usage();
            return;
        }
        this.refctrl2usageDirtyFlag = false;
        this.refctrl2usage = null;
    }

    public void setRefCtrl2UsageText(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefCtrl2UsageText(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refctrl2usagetext = string;
        this.refctrl2usagetextDirtyFlag = true;
    }

    public String getRefCtrl2UsageText() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefCtrl2UsageText();
        }
        return this.refctrl2usagetext;
    }

    public boolean isRefCtrl2UsageTextDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefCtrl2UsageTextDirty();
        }
        return this.refctrl2usagetextDirtyFlag;
    }

    public void resetRefCtrl2UsageText() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefCtrl2UsageText();
            return;
        }
        this.refctrl2usagetextDirtyFlag = false;
        this.refctrl2usagetext = null;
    }

    public void setRefCtrlName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefCtrlName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refctrlname = string;
        this.refctrlnameDirtyFlag = true;
    }

    public String getRefCtrlName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefCtrlName();
        }
        return this.refctrlname;
    }

    public boolean isRefCtrlNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefCtrlNameDirty();
        }
        return this.refctrlnameDirtyFlag;
    }

    public void resetRefCtrlName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefCtrlName();
            return;
        }
        this.refctrlnameDirtyFlag = false;
        this.refctrlname = null;
    }

    public void setRefCtrlUsage(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefCtrlUsage(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refctrlusage = string;
        this.refctrlusageDirtyFlag = true;
    }

    public String getRefCtrlUsage() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefCtrlUsage();
        }
        return this.refctrlusage;
    }

    public boolean isRefCtrlUsageDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefCtrlUsageDirty();
        }
        return this.refctrlusageDirtyFlag;
    }

    public void resetRefCtrlUsage() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefCtrlUsage();
            return;
        }
        this.refctrlusageDirtyFlag = false;
        this.refctrlusage = null;
    }

    public void setRefCtrlUsageText(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefCtrlUsageText(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refctrlusagetext = string;
        this.refctrlusagetextDirtyFlag = true;
    }

    public String getRefCtrlUsageText() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefCtrlUsageText();
        }
        return this.refctrlusagetext;
    }

    public boolean isRefCtrlUsageTextDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefCtrlUsageTextDirty();
        }
        return this.refctrlusagetextDirtyFlag;
    }

    public void resetRefCtrlUsageText() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefCtrlUsageText();
            return;
        }
        this.refctrlusagetextDirtyFlag = false;
        this.refctrlusagetext = null;
    }

    public void setRightPos(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRightPos(n);
            return;
        }
        this.rightpos = n;
        this.rightposDirtyFlag = true;
    }

    public Integer getRightPos() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRightPos();
        }
        return this.rightpos;
    }

    public boolean isRightPosDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRightPosDirty();
        }
        return this.rightposDirtyFlag;
    }

    public void resetRightPos() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRightPos();
            return;
        }
        this.rightposDirtyFlag = false;
        this.rightpos = null;
    }

    public void setSubPSACHandlerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSubPSACHandlerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.subpsachandlerid = string;
        this.subpsachandleridDirtyFlag = true;
    }

    public String getSubPSACHandlerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSubPSACHandlerId();
        }
        return this.subpsachandlerid;
    }

    public boolean isSubPSACHandlerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSubPSACHandlerIdDirty();
        }
        return this.subpsachandleridDirtyFlag;
    }

    public void resetSubPSACHandlerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSubPSACHandlerId();
            return;
        }
        this.subpsachandleridDirtyFlag = false;
        this.subpsachandlerid = null;
    }

    public void setSubPSACHandlerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSubPSACHandlerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.subpsachandlername = string;
        this.subpsachandlernameDirtyFlag = true;
    }

    public String getSubPSACHandlerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSubPSACHandlerName();
        }
        return this.subpsachandlername;
    }

    public boolean isSubPSACHandlerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSubPSACHandlerNameDirty();
        }
        return this.subpsachandlernameDirtyFlag;
    }

    public void resetSubPSACHandlerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSubPSACHandlerName();
            return;
        }
        this.subpsachandlernameDirtyFlag = false;
        this.subpsachandlername = null;
    }

    public void setTopPos(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTopPos(n);
            return;
        }
        this.toppos = n;
        this.topposDirtyFlag = true;
    }

    public Integer getTopPos() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTopPos();
        }
        return this.toppos;
    }

    public boolean isTopPosDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTopPosDirty();
        }
        return this.topposDirtyFlag;
    }

    public void resetTopPos() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTopPos();
            return;
        }
        this.topposDirtyFlag = false;
        this.toppos = null;
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

    public void setWidth(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWidth(d);
            return;
        }
        this.width = d;
        this.widthDirtyFlag = true;
    }

    public Double getWidth() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWidth();
        }
        return this.width;
    }

    public boolean isWidthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWidthDirty();
        }
        return this.widthDirtyFlag;
    }

    public void resetWidth() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWidth();
            return;
        }
        this.widthDirtyFlag = false;
        this.width = null;
    }

    protected void onReset() {
        PSDEViewCtrlBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEViewCtrlBase pSDEViewCtrlBase) {
        pSDEViewCtrlBase.resetADPSDELogicId();
        pSDEViewCtrlBase.resetADPSDELogicName();
        pSDEViewCtrlBase.resetBottomPos();
        pSDEViewCtrlBase.resetBtnActionType();
        pSDEViewCtrlBase.resetBusyIndicator();
        pSDEViewCtrlBase.resetCapPSLanResId();
        pSDEViewCtrlBase.resetCapPSLanResName();
        pSDEViewCtrlBase.resetCaption();
        pSDEViewCtrlBase.resetConfigInfo();
        pSDEViewCtrlBase.resetCreateDate();
        pSDEViewCtrlBase.resetCreateMan();
        pSDEViewCtrlBase.resetCtrlParam();
        pSDEViewCtrlBase.resetCtrlParam10();
        pSDEViewCtrlBase.resetCtrlParam11();
        pSDEViewCtrlBase.resetCtrlParam12();
        pSDEViewCtrlBase.resetCtrlParam2();
        pSDEViewCtrlBase.resetCtrlParam3();
        pSDEViewCtrlBase.resetCtrlParam4();
        pSDEViewCtrlBase.resetCtrlParam5();
        pSDEViewCtrlBase.resetCtrlParam6();
        pSDEViewCtrlBase.resetCtrlParam7();
        pSDEViewCtrlBase.resetCtrlParam8();
        pSDEViewCtrlBase.resetCtrlParam9();
        pSDEViewCtrlBase.resetCtrlParams();
        pSDEViewCtrlBase.resetCustomCond();
        pSDEViewCtrlBase.resetCustomType();
        pSDEViewCtrlBase.resetDefaultFlag();
        pSDEViewCtrlBase.resetDynaModelFlag();
        pSDEViewCtrlBase.resetDyncMode();
        pSDEViewCtrlBase.resetEnableDynaSys();
        pSDEViewCtrlBase.resetEnableItemPriv();
        pSDEViewCtrlBase.resetEnableViewActions();
        pSDEViewCtrlBase.resetHeight();
        pSDEViewCtrlBase.resetInsertPos();
        pSDEViewCtrlBase.resetLeftPos();
        pSDEViewCtrlBase.resetLocalMode();
        pSDEViewCtrlBase.resetMargin();
        pSDEViewCtrlBase.resetMemo();
        pSDEViewCtrlBase.resetMultiSelect();
        pSDEViewCtrlBase.resetNO2PSDEUAGroupId();
        pSDEViewCtrlBase.resetNO2PSDEUAGroupName();
        pSDEViewCtrlBase.resetNO3PSDEUAGroupId();
        pSDEViewCtrlBase.resetNO3PSDEUAGroupName();
        pSDEViewCtrlBase.resetNO4PSDEUAGroupId();
        pSDEViewCtrlBase.resetNO4PSDEUAGroupName();
        pSDEViewCtrlBase.resetNO5PSDEUAGroupId();
        pSDEViewCtrlBase.resetNO5PSDEUAGroupName();
        pSDEViewCtrlBase.resetNO6PSDEUAGroupId();
        pSDEViewCtrlBase.resetNO6PSDEUAGroupName();
        pSDEViewCtrlBase.resetOrderValue();
        pSDEViewCtrlBase.resetPadding();
        pSDEViewCtrlBase.resetPredefinedType();
        pSDEViewCtrlBase.resetPredefinedTypeText();
        pSDEViewCtrlBase.resetPSACHandlerId();
        pSDEViewCtrlBase.resetPSACHandlerName();
        pSDEViewCtrlBase.resetPSCtrlId();
        pSDEViewCtrlBase.resetPSCtrlLogicGroupId();
        pSDEViewCtrlBase.resetPSCtrlLogicGroupName();
        pSDEViewCtrlBase.resetPSCtrlMsgId();
        pSDEViewCtrlBase.resetPSCtrlMsgName();
        pSDEViewCtrlBase.resetPSCtrlName();
        pSDEViewCtrlBase.resetPSDEActionId();
        pSDEViewCtrlBase.resetPSDEActionName();
        pSDEViewCtrlBase.resetPSDEChartId();
        pSDEViewCtrlBase.resetPSDEChartName();
        pSDEViewCtrlBase.resetPSDEDataExpId();
        pSDEViewCtrlBase.resetPSDEDataExpName();
        pSDEViewCtrlBase.resetPSDEDataImpId();
        pSDEViewCtrlBase.resetPSDEDataImpName();
        pSDEViewCtrlBase.resetPSDEDataSetId();
        pSDEViewCtrlBase.resetPSDEDataSetName();
        pSDEViewCtrlBase.resetPSDEDataViewId();
        pSDEViewCtrlBase.resetPSDEDataViewName();
        pSDEViewCtrlBase.resetPSDEDRId();
        pSDEViewCtrlBase.resetPSDEDRName();
        pSDEViewCtrlBase.resetPSDEFormId();
        pSDEViewCtrlBase.resetPSDEFormName();
        pSDEViewCtrlBase.resetPSDEGridId();
        pSDEViewCtrlBase.resetPSDEGridName();
        pSDEViewCtrlBase.resetPSDEId();
        pSDEViewCtrlBase.resetPSDEListId();
        pSDEViewCtrlBase.resetPSDEListName();
        pSDEViewCtrlBase.resetPSDEName();
        pSDEViewCtrlBase.resetPSDEOPPrivId();
        pSDEViewCtrlBase.resetPSDEOPPrivName();
        pSDEViewCtrlBase.resetPSDEReportId();
        pSDEViewCtrlBase.resetPSDEReportName();
        pSDEViewCtrlBase.resetPSDEToolbarId();
        pSDEViewCtrlBase.resetPSDEToolbarName();
        pSDEViewCtrlBase.resetPSDETreeViewId();
        pSDEViewCtrlBase.resetPSDETreeViewName();
        pSDEViewCtrlBase.resetPSDEUAGroupId();
        pSDEViewCtrlBase.resetPSDEUAGroupName();
        pSDEViewCtrlBase.resetPSDEViewBaseId();
        pSDEViewCtrlBase.resetPSDEViewBaseName();
        pSDEViewCtrlBase.resetPSDEViewCtrlId();
        pSDEViewCtrlBase.resetPSDEViewCtrlName();
        pSDEViewCtrlBase.resetPSDEViewCtrlType();
        pSDEViewCtrlBase.resetPSDEViewId();
        pSDEViewCtrlBase.resetPSDEViewName();
        pSDEViewCtrlBase.resetPSDEWizardId();
        pSDEViewCtrlBase.resetPSDEWizardName();
        pSDEViewCtrlBase.resetPSDynaInstId();
        pSDEViewCtrlBase.resetPSPFId();
        pSDEViewCtrlBase.resetPSPFName();
        pSDEViewCtrlBase.resetPSSysCalendarId();
        pSDEViewCtrlBase.resetPSSysCalendarName();
        pSDEViewCtrlBase.resetPSSysCounterId();
        pSDEViewCtrlBase.resetPSSysCounterName();
        pSDEViewCtrlBase.resetPSSysCssId();
        pSDEViewCtrlBase.resetPSSysCssName();
        pSDEViewCtrlBase.resetPSSysDashboardId();
        pSDEViewCtrlBase.resetPSSysDashboardName();
        pSDEViewCtrlBase.resetPSSysDynaModelId();
        pSDEViewCtrlBase.resetPSSysDynaModelName();
        pSDEViewCtrlBase.resetPSSysImageId();
        pSDEViewCtrlBase.resetPSSysImageName();
        pSDEViewCtrlBase.resetPSSysMapViewId();
        pSDEViewCtrlBase.resetPSSysMapViewName();
        pSDEViewCtrlBase.resetPSSysMsgTemplId();
        pSDEViewCtrlBase.resetPSSysMsgTemplName();
        pSDEViewCtrlBase.resetPSSysPFPluginId();
        pSDEViewCtrlBase.resetPSSysPFPluginName();
        pSDEViewCtrlBase.resetPSSysSearchBarId();
        pSDEViewCtrlBase.resetPSSysSearchBarName();
        pSDEViewCtrlBase.resetPSSystemId();
        pSDEViewCtrlBase.resetPSSysViewPanelId();
        pSDEViewCtrlBase.resetPSSysViewPanelName();
        pSDEViewCtrlBase.resetReadOnlyMode();
        pSDEViewCtrlBase.resetRefCtrl2Name();
        pSDEViewCtrlBase.resetRefCtrl2Usage();
        pSDEViewCtrlBase.resetRefCtrl2UsageText();
        pSDEViewCtrlBase.resetRefCtrlName();
        pSDEViewCtrlBase.resetRefCtrlUsage();
        pSDEViewCtrlBase.resetRefCtrlUsageText();
        pSDEViewCtrlBase.resetRightPos();
        pSDEViewCtrlBase.resetSubPSACHandlerId();
        pSDEViewCtrlBase.resetSubPSACHandlerName();
        pSDEViewCtrlBase.resetTopPos();
        pSDEViewCtrlBase.resetUpdateDate();
        pSDEViewCtrlBase.resetUpdateMan();
        pSDEViewCtrlBase.resetUserTag();
        pSDEViewCtrlBase.resetUserTag2();
        pSDEViewCtrlBase.resetValidFlag();
        pSDEViewCtrlBase.resetWidth();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isADPSDELogicIdDirty()) {
            hashMap.put(FIELD_ADPSDELOGICID, this.getADPSDELogicId());
        }
        if (!bl || this.isADPSDELogicNameDirty()) {
            hashMap.put(FIELD_ADPSDELOGICNAME, this.getADPSDELogicName());
        }
        if (!bl || this.isBottomPosDirty()) {
            hashMap.put(FIELD_BOTTOMPOS, this.getBottomPos());
        }
        if (!bl || this.isBtnActionTypeDirty()) {
            hashMap.put(FIELD_BTNACTIONTYPE, this.getBtnActionType());
        }
        if (!bl || this.isBusyIndicatorDirty()) {
            hashMap.put(FIELD_BUSYINDICATOR, this.getBusyIndicator());
        }
        if (!bl || this.isCapPSLanResIdDirty()) {
            hashMap.put(FIELD_CAPPSLANRESID, this.getCapPSLanResId());
        }
        if (!bl || this.isCapPSLanResNameDirty()) {
            hashMap.put(FIELD_CAPPSLANRESNAME, this.getCapPSLanResName());
        }
        if (!bl || this.isCaptionDirty()) {
            hashMap.put(FIELD_CAPTION, this.getCaption());
        }
        if (!bl || this.isConfigInfoDirty()) {
            hashMap.put(FIELD_CONFIGINFO, this.getConfigInfo());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCtrlParamDirty()) {
            hashMap.put(FIELD_CTRLPARAM, this.getCtrlParam());
        }
        if (!bl || this.isCtrlParam10Dirty()) {
            hashMap.put(FIELD_CTRLPARAM10, this.getCtrlParam10());
        }
        if (!bl || this.isCtrlParam11Dirty()) {
            hashMap.put(FIELD_CTRLPARAM11, this.getCtrlParam11());
        }
        if (!bl || this.isCtrlParam12Dirty()) {
            hashMap.put(FIELD_CTRLPARAM12, this.getCtrlParam12());
        }
        if (!bl || this.isCtrlParam2Dirty()) {
            hashMap.put(FIELD_CTRLPARAM2, this.getCtrlParam2());
        }
        if (!bl || this.isCtrlParam3Dirty()) {
            hashMap.put(FIELD_CTRLPARAM3, this.getCtrlParam3());
        }
        if (!bl || this.isCtrlParam4Dirty()) {
            hashMap.put(FIELD_CTRLPARAM4, this.getCtrlParam4());
        }
        if (!bl || this.isCtrlParam5Dirty()) {
            hashMap.put(FIELD_CTRLPARAM5, this.getCtrlParam5());
        }
        if (!bl || this.isCtrlParam6Dirty()) {
            hashMap.put(FIELD_CTRLPARAM6, this.getCtrlParam6());
        }
        if (!bl || this.isCtrlParam7Dirty()) {
            hashMap.put(FIELD_CTRLPARAM7, this.getCtrlParam7());
        }
        if (!bl || this.isCtrlParam8Dirty()) {
            hashMap.put(FIELD_CTRLPARAM8, this.getCtrlParam8());
        }
        if (!bl || this.isCtrlParam9Dirty()) {
            hashMap.put(FIELD_CTRLPARAM9, this.getCtrlParam9());
        }
        if (!bl || this.isCtrlParamsDirty()) {
            hashMap.put(FIELD_CTRLPARAMS, this.getCtrlParams());
        }
        if (!bl || this.isCustomCondDirty()) {
            hashMap.put(FIELD_CUSTOMCOND, this.getCustomCond());
        }
        if (!bl || this.isCustomTypeDirty()) {
            hashMap.put(FIELD_CUSTOMTYPE, this.getCustomType());
        }
        if (!bl || this.isDefaultFlagDirty()) {
            hashMap.put(FIELD_DEFAULTFLAG, this.getDefaultFlag());
        }
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isDyncModeDirty()) {
            hashMap.put(FIELD_DYNCMODE, this.getDyncMode());
        }
        if (!bl || this.isEnableDynaSysDirty()) {
            hashMap.put(FIELD_ENABLEDYNASYS, this.getEnableDynaSys());
        }
        if (!bl || this.isEnableItemPrivDirty()) {
            hashMap.put(FIELD_ENABLEITEMPRIV, this.getEnableItemPriv());
        }
        if (!bl || this.isEnableViewActionsDirty()) {
            hashMap.put(FIELD_ENABLEVIEWACTIONS, this.getEnableViewActions());
        }
        if (!bl || this.isHeightDirty()) {
            hashMap.put(FIELD_HEIGHT, this.getHeight());
        }
        if (!bl || this.isInsertPosDirty()) {
            hashMap.put(FIELD_INSERTPOS, this.getInsertPos());
        }
        if (!bl || this.isLeftPosDirty()) {
            hashMap.put(FIELD_LEFTPOS, this.getLeftPos());
        }
        if (!bl || this.isLocalModeDirty()) {
            hashMap.put(FIELD_LOCALMODE, this.getLocalMode());
        }
        if (!bl || this.isMarginDirty()) {
            hashMap.put(FIELD_MARGIN, this.getMargin());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMultiSelectDirty()) {
            hashMap.put(FIELD_MULTISELECT, this.getMultiSelect());
        }
        if (!bl || this.isNO2PSDEUAGroupIdDirty()) {
            hashMap.put(FIELD_NO2PSDEUAGROUPID, this.getNO2PSDEUAGroupId());
        }
        if (!bl || this.isNO2PSDEUAGroupNameDirty()) {
            hashMap.put(FIELD_NO2PSDEUAGROUPNAME, this.getNO2PSDEUAGroupName());
        }
        if (!bl || this.isNO3PSDEUAGroupIdDirty()) {
            hashMap.put(FIELD_NO3PSDEUAGROUPID, this.getNO3PSDEUAGroupId());
        }
        if (!bl || this.isNO3PSDEUAGroupNameDirty()) {
            hashMap.put(FIELD_NO3PSDEUAGROUPNAME, this.getNO3PSDEUAGroupName());
        }
        if (!bl || this.isNO4PSDEUAGroupIdDirty()) {
            hashMap.put(FIELD_NO4PSDEUAGROUPID, this.getNO4PSDEUAGroupId());
        }
        if (!bl || this.isNO4PSDEUAGroupNameDirty()) {
            hashMap.put(FIELD_NO4PSDEUAGROUPNAME, this.getNO4PSDEUAGroupName());
        }
        if (!bl || this.isNO5PSDEUAGroupIdDirty()) {
            hashMap.put(FIELD_NO5PSDEUAGROUPID, this.getNO5PSDEUAGroupId());
        }
        if (!bl || this.isNO5PSDEUAGroupNameDirty()) {
            hashMap.put(FIELD_NO5PSDEUAGROUPNAME, this.getNO5PSDEUAGroupName());
        }
        if (!bl || this.isNO6PSDEUAGroupIdDirty()) {
            hashMap.put(FIELD_NO6PSDEUAGROUPID, this.getNO6PSDEUAGroupId());
        }
        if (!bl || this.isNO6PSDEUAGroupNameDirty()) {
            hashMap.put(FIELD_NO6PSDEUAGROUPNAME, this.getNO6PSDEUAGroupName());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPaddingDirty()) {
            hashMap.put(FIELD_PADDING, this.getPadding());
        }
        if (!bl || this.isPredefinedTypeDirty()) {
            hashMap.put(FIELD_PREDEFINEDTYPE, this.getPredefinedType());
        }
        if (!bl || this.isPredefinedTypeTextDirty()) {
            hashMap.put(FIELD_PREDEFINEDTYPETEXT, this.getPredefinedTypeText());
        }
        if (!bl || this.isPSACHandlerIdDirty()) {
            hashMap.put(FIELD_PSACHANDLERID, this.getPSACHandlerId());
        }
        if (!bl || this.isPSACHandlerNameDirty()) {
            hashMap.put(FIELD_PSACHANDLERNAME, this.getPSACHandlerName());
        }
        if (!bl || this.isPSCtrlIdDirty()) {
            hashMap.put(FIELD_PSCTRLID, this.getPSCtrlId());
        }
        if (!bl || this.isPSCtrlLogicGroupIdDirty()) {
            hashMap.put(FIELD_PSCTRLLOGICGROUPID, this.getPSCtrlLogicGroupId());
        }
        if (!bl || this.isPSCtrlLogicGroupNameDirty()) {
            hashMap.put(FIELD_PSCTRLLOGICGROUPNAME, this.getPSCtrlLogicGroupName());
        }
        if (!bl || this.isPSCtrlMsgIdDirty()) {
            hashMap.put(FIELD_PSCTRLMSGID, this.getPSCtrlMsgId());
        }
        if (!bl || this.isPSCtrlMsgNameDirty()) {
            hashMap.put(FIELD_PSCTRLMSGNAME, this.getPSCtrlMsgName());
        }
        if (!bl || this.isPSCtrlNameDirty()) {
            hashMap.put(FIELD_PSCTRLNAME, this.getPSCtrlName());
        }
        if (!bl || this.isPSDEActionIdDirty()) {
            hashMap.put(FIELD_PSDEACTIONID, this.getPSDEActionId());
        }
        if (!bl || this.isPSDEActionNameDirty()) {
            hashMap.put(FIELD_PSDEACTIONNAME, this.getPSDEActionName());
        }
        if (!bl || this.isPSDEChartIdDirty()) {
            hashMap.put(FIELD_PSDECHARTID, this.getPSDEChartId());
        }
        if (!bl || this.isPSDEChartNameDirty()) {
            hashMap.put(FIELD_PSDECHARTNAME, this.getPSDEChartName());
        }
        if (!bl || this.isPSDEDataExpIdDirty()) {
            hashMap.put(FIELD_PSDEDATAEXPID, this.getPSDEDataExpId());
        }
        if (!bl || this.isPSDEDataExpNameDirty()) {
            hashMap.put(FIELD_PSDEDATAEXPNAME, this.getPSDEDataExpName());
        }
        if (!bl || this.isPSDEDataImpIdDirty()) {
            hashMap.put(FIELD_PSDEDATAIMPID, this.getPSDEDataImpId());
        }
        if (!bl || this.isPSDEDataImpNameDirty()) {
            hashMap.put(FIELD_PSDEDATAIMPNAME, this.getPSDEDataImpName());
        }
        if (!bl || this.isPSDEDataSetIdDirty()) {
            hashMap.put(FIELD_PSDEDATASETID, this.getPSDEDataSetId());
        }
        if (!bl || this.isPSDEDataSetNameDirty()) {
            hashMap.put(FIELD_PSDEDATASETNAME, this.getPSDEDataSetName());
        }
        if (!bl || this.isPSDEDataViewIdDirty()) {
            hashMap.put(FIELD_PSDEDATAVIEWID, this.getPSDEDataViewId());
        }
        if (!bl || this.isPSDEDataViewNameDirty()) {
            hashMap.put(FIELD_PSDEDATAVIEWNAME, this.getPSDEDataViewName());
        }
        if (!bl || this.isPSDEDRIdDirty()) {
            hashMap.put(FIELD_PSDEDRID, this.getPSDEDRId());
        }
        if (!bl || this.isPSDEDRNameDirty()) {
            hashMap.put(FIELD_PSDEDRNAME, this.getPSDEDRName());
        }
        if (!bl || this.isPSDEFormIdDirty()) {
            hashMap.put(FIELD_PSDEFORMID, this.getPSDEFormId());
        }
        if (!bl || this.isPSDEFormNameDirty()) {
            hashMap.put(FIELD_PSDEFORMNAME, this.getPSDEFormName());
        }
        if (!bl || this.isPSDEGridIdDirty()) {
            hashMap.put(FIELD_PSDEGRIDID, this.getPSDEGridId());
        }
        if (!bl || this.isPSDEGridNameDirty()) {
            hashMap.put(FIELD_PSDEGRIDNAME, this.getPSDEGridName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDEListIdDirty()) {
            hashMap.put(FIELD_PSDELISTID, this.getPSDEListId());
        }
        if (!bl || this.isPSDEListNameDirty()) {
            hashMap.put(FIELD_PSDELISTNAME, this.getPSDEListName());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDEOPPrivIdDirty()) {
            hashMap.put(FIELD_PSDEOPPRIVID, this.getPSDEOPPrivId());
        }
        if (!bl || this.isPSDEOPPrivNameDirty()) {
            hashMap.put(FIELD_PSDEOPPRIVNAME, this.getPSDEOPPrivName());
        }
        if (!bl || this.isPSDEReportIdDirty()) {
            hashMap.put(FIELD_PSDEREPORTID, this.getPSDEReportId());
        }
        if (!bl || this.isPSDEReportNameDirty()) {
            hashMap.put(FIELD_PSDEREPORTNAME, this.getPSDEReportName());
        }
        if (!bl || this.isPSDEToolbarIdDirty()) {
            hashMap.put(FIELD_PSDETOOLBARID, this.getPSDEToolbarId());
        }
        if (!bl || this.isPSDEToolbarNameDirty()) {
            hashMap.put(FIELD_PSDETOOLBARNAME, this.getPSDEToolbarName());
        }
        if (!bl || this.isPSDETreeViewIdDirty()) {
            hashMap.put(FIELD_PSDETREEVIEWID, this.getPSDETreeViewId());
        }
        if (!bl || this.isPSDETreeViewNameDirty()) {
            hashMap.put(FIELD_PSDETREEVIEWNAME, this.getPSDETreeViewName());
        }
        if (!bl || this.isPSDEUAGroupIdDirty()) {
            hashMap.put(FIELD_PSDEUAGROUPID, this.getPSDEUAGroupId());
        }
        if (!bl || this.isPSDEUAGroupNameDirty()) {
            hashMap.put(FIELD_PSDEUAGROUPNAME, this.getPSDEUAGroupName());
        }
        if (!bl || this.isPSDEViewBaseIdDirty()) {
            hashMap.put(FIELD_PSDEVIEWBASEID, this.getPSDEViewBaseId());
        }
        if (!bl || this.isPSDEViewBaseNameDirty()) {
            hashMap.put(FIELD_PSDEVIEWBASENAME, this.getPSDEViewBaseName());
        }
        if (!bl || this.isPSDEViewCtrlIdDirty()) {
            hashMap.put(FIELD_PSDEVIEWCTRLID, this.getPSDEViewCtrlId());
        }
        if (!bl || this.isPSDEViewCtrlNameDirty()) {
            hashMap.put(FIELD_PSDEVIEWCTRLNAME, this.getPSDEViewCtrlName());
        }
        if (!bl || this.isPSDEViewCtrlTypeDirty()) {
            hashMap.put(FIELD_PSDEVIEWCTRLTYPE, this.getPSDEViewCtrlType());
        }
        if (!bl || this.isPSDEViewIdDirty()) {
            hashMap.put(FIELD_PSDEVIEWID, this.getPSDEViewId());
        }
        if (!bl || this.isPSDEViewNameDirty()) {
            hashMap.put(FIELD_PSDEVIEWNAME, this.getPSDEViewName());
        }
        if (!bl || this.isPSDEWizardIdDirty()) {
            hashMap.put(FIELD_PSDEWIZARDID, this.getPSDEWizardId());
        }
        if (!bl || this.isPSDEWizardNameDirty()) {
            hashMap.put(FIELD_PSDEWIZARDNAME, this.getPSDEWizardName());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSPFIdDirty()) {
            hashMap.put(FIELD_PSPFID, this.getPSPFId());
        }
        if (!bl || this.isPSPFNameDirty()) {
            hashMap.put(FIELD_PSPFNAME, this.getPSPFName());
        }
        if (!bl || this.isPSSysCalendarIdDirty()) {
            hashMap.put(FIELD_PSSYSCALENDARID, this.getPSSysCalendarId());
        }
        if (!bl || this.isPSSysCalendarNameDirty()) {
            hashMap.put(FIELD_PSSYSCALENDARNAME, this.getPSSysCalendarName());
        }
        if (!bl || this.isPSSysCounterIdDirty()) {
            hashMap.put(FIELD_PSSYSCOUNTERID, this.getPSSysCounterId());
        }
        if (!bl || this.isPSSysCounterNameDirty()) {
            hashMap.put(FIELD_PSSYSCOUNTERNAME, this.getPSSysCounterName());
        }
        if (!bl || this.isPSSysCssIdDirty()) {
            hashMap.put(FIELD_PSSYSCSSID, this.getPSSysCssId());
        }
        if (!bl || this.isPSSysCssNameDirty()) {
            hashMap.put(FIELD_PSSYSCSSNAME, this.getPSSysCssName());
        }
        if (!bl || this.isPSSysDashboardIdDirty()) {
            hashMap.put(FIELD_PSSYSDASHBOARDID, this.getPSSysDashboardId());
        }
        if (!bl || this.isPSSysDashboardNameDirty()) {
            hashMap.put(FIELD_PSSYSDASHBOARDNAME, this.getPSSysDashboardName());
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
        if (!bl || this.isPSSysMapViewIdDirty()) {
            hashMap.put(FIELD_PSSYSMAPVIEWID, this.getPSSysMapViewId());
        }
        if (!bl || this.isPSSysMapViewNameDirty()) {
            hashMap.put(FIELD_PSSYSMAPVIEWNAME, this.getPSSysMapViewName());
        }
        if (!bl || this.isPSSysMsgTemplIdDirty()) {
            hashMap.put(FIELD_PSSYSMSGTEMPLID, this.getPSSysMsgTemplId());
        }
        if (!bl || this.isPSSysMsgTemplNameDirty()) {
            hashMap.put(FIELD_PSSYSMSGTEMPLNAME, this.getPSSysMsgTemplName());
        }
        if (!bl || this.isPSSysPFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINID, this.getPSSysPFPluginId());
        }
        if (!bl || this.isPSSysPFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINNAME, this.getPSSysPFPluginName());
        }
        if (!bl || this.isPSSysSearchBarIdDirty()) {
            hashMap.put(FIELD_PSSYSSEARCHBARID, this.getPSSysSearchBarId());
        }
        if (!bl || this.isPSSysSearchBarNameDirty()) {
            hashMap.put(FIELD_PSSYSSEARCHBARNAME, this.getPSSysSearchBarName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSysViewPanelIdDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELID, this.getPSSysViewPanelId());
        }
        if (!bl || this.isPSSysViewPanelNameDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELNAME, this.getPSSysViewPanelName());
        }
        if (!bl || this.isReadOnlyModeDirty()) {
            hashMap.put(FIELD_READONLYMODE, this.getReadOnlyMode());
        }
        if (!bl || this.isRefCtrl2NameDirty()) {
            hashMap.put(FIELD_REFCTRL2NAME, this.getRefCtrl2Name());
        }
        if (!bl || this.isRefCtrl2UsageDirty()) {
            hashMap.put(FIELD_REFCTRL2USAGE, this.getRefCtrl2Usage());
        }
        if (!bl || this.isRefCtrl2UsageTextDirty()) {
            hashMap.put(FIELD_REFCTRL2USAGETEXT, this.getRefCtrl2UsageText());
        }
        if (!bl || this.isRefCtrlNameDirty()) {
            hashMap.put(FIELD_REFCTRLNAME, this.getRefCtrlName());
        }
        if (!bl || this.isRefCtrlUsageDirty()) {
            hashMap.put(FIELD_REFCTRLUSAGE, this.getRefCtrlUsage());
        }
        if (!bl || this.isRefCtrlUsageTextDirty()) {
            hashMap.put(FIELD_REFCTRLUSAGETEXT, this.getRefCtrlUsageText());
        }
        if (!bl || this.isRightPosDirty()) {
            hashMap.put(FIELD_RIGHTPOS, this.getRightPos());
        }
        if (!bl || this.isSubPSACHandlerIdDirty()) {
            hashMap.put(FIELD_SUBPSACHANDLERID, this.getSubPSACHandlerId());
        }
        if (!bl || this.isSubPSACHandlerNameDirty()) {
            hashMap.put(FIELD_SUBPSACHANDLERNAME, this.getSubPSACHandlerName());
        }
        if (!bl || this.isTopPosDirty()) {
            hashMap.put(FIELD_TOPPOS, this.getTopPos());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bl || this.isUserTag2Dirty()) {
            hashMap.put(FIELD_USERTAG2, this.getUserTag2());
        }
        if (!bl || this.isValidFlagDirty()) {
            hashMap.put(FIELD_VALIDFLAG, this.getValidFlag());
        }
        if (!bl || this.isWidthDirty()) {
            hashMap.put(FIELD_WIDTH, this.getWidth());
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
        return PSDEViewCtrlBase.get(this, n);
    }

    private static Object get(PSDEViewCtrlBase pSDEViewCtrlBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEViewCtrlBase.getADPSDELogicId();
            }
            case 1: {
                return pSDEViewCtrlBase.getADPSDELogicName();
            }
            case 2: {
                return pSDEViewCtrlBase.getBottomPos();
            }
            case 3: {
                return pSDEViewCtrlBase.getBtnActionType();
            }
            case 4: {
                return pSDEViewCtrlBase.getBusyIndicator();
            }
            case 5: {
                return pSDEViewCtrlBase.getCapPSLanResId();
            }
            case 6: {
                return pSDEViewCtrlBase.getCapPSLanResName();
            }
            case 7: {
                return pSDEViewCtrlBase.getCaption();
            }
            case 8: {
                return pSDEViewCtrlBase.getConfigInfo();
            }
            case 9: {
                return pSDEViewCtrlBase.getCreateDate();
            }
            case 10: {
                return pSDEViewCtrlBase.getCreateMan();
            }
            case 11: {
                return pSDEViewCtrlBase.getCtrlParam();
            }
            case 12: {
                return pSDEViewCtrlBase.getCtrlParam10();
            }
            case 13: {
                return pSDEViewCtrlBase.getCtrlParam11();
            }
            case 14: {
                return pSDEViewCtrlBase.getCtrlParam12();
            }
            case 15: {
                return pSDEViewCtrlBase.getCtrlParam2();
            }
            case 16: {
                return pSDEViewCtrlBase.getCtrlParam3();
            }
            case 17: {
                return pSDEViewCtrlBase.getCtrlParam4();
            }
            case 18: {
                return pSDEViewCtrlBase.getCtrlParam5();
            }
            case 19: {
                return pSDEViewCtrlBase.getCtrlParam6();
            }
            case 20: {
                return pSDEViewCtrlBase.getCtrlParam7();
            }
            case 21: {
                return pSDEViewCtrlBase.getCtrlParam8();
            }
            case 22: {
                return pSDEViewCtrlBase.getCtrlParam9();
            }
            case 23: {
                return pSDEViewCtrlBase.getCtrlParams();
            }
            case 24: {
                return pSDEViewCtrlBase.getCustomCond();
            }
            case 25: {
                return pSDEViewCtrlBase.getCustomType();
            }
            case 26: {
                return pSDEViewCtrlBase.getDefaultFlag();
            }
            case 27: {
                return pSDEViewCtrlBase.getDynaModelFlag();
            }
            case 28: {
                return pSDEViewCtrlBase.getDyncMode();
            }
            case 29: {
                return pSDEViewCtrlBase.getEnableDynaSys();
            }
            case 30: {
                return pSDEViewCtrlBase.getEnableItemPriv();
            }
            case 31: {
                return pSDEViewCtrlBase.getEnableViewActions();
            }
            case 32: {
                return pSDEViewCtrlBase.getHeight();
            }
            case 33: {
                return pSDEViewCtrlBase.getInsertPos();
            }
            case 34: {
                return pSDEViewCtrlBase.getLeftPos();
            }
            case 35: {
                return pSDEViewCtrlBase.getLocalMode();
            }
            case 36: {
                return pSDEViewCtrlBase.getMargin();
            }
            case 37: {
                return pSDEViewCtrlBase.getMemo();
            }
            case 38: {
                return pSDEViewCtrlBase.getMultiSelect();
            }
            case 39: {
                return pSDEViewCtrlBase.getNO2PSDEUAGroupId();
            }
            case 40: {
                return pSDEViewCtrlBase.getNO2PSDEUAGroupName();
            }
            case 41: {
                return pSDEViewCtrlBase.getNO3PSDEUAGroupId();
            }
            case 42: {
                return pSDEViewCtrlBase.getNO3PSDEUAGroupName();
            }
            case 43: {
                return pSDEViewCtrlBase.getNO4PSDEUAGroupId();
            }
            case 44: {
                return pSDEViewCtrlBase.getNO4PSDEUAGroupName();
            }
            case 45: {
                return pSDEViewCtrlBase.getNO5PSDEUAGroupId();
            }
            case 46: {
                return pSDEViewCtrlBase.getNO5PSDEUAGroupName();
            }
            case 47: {
                return pSDEViewCtrlBase.getNO6PSDEUAGroupId();
            }
            case 48: {
                return pSDEViewCtrlBase.getNO6PSDEUAGroupName();
            }
            case 49: {
                return pSDEViewCtrlBase.getOrderValue();
            }
            case 50: {
                return pSDEViewCtrlBase.getPadding();
            }
            case 51: {
                return pSDEViewCtrlBase.getPredefinedType();
            }
            case 52: {
                return pSDEViewCtrlBase.getPredefinedTypeText();
            }
            case 53: {
                return pSDEViewCtrlBase.getPSACHandlerId();
            }
            case 54: {
                return pSDEViewCtrlBase.getPSACHandlerName();
            }
            case 55: {
                return pSDEViewCtrlBase.getPSCtrlId();
            }
            case 56: {
                return pSDEViewCtrlBase.getPSCtrlLogicGroupId();
            }
            case 57: {
                return pSDEViewCtrlBase.getPSCtrlLogicGroupName();
            }
            case 58: {
                return pSDEViewCtrlBase.getPSCtrlMsgId();
            }
            case 59: {
                return pSDEViewCtrlBase.getPSCtrlMsgName();
            }
            case 60: {
                return pSDEViewCtrlBase.getPSCtrlName();
            }
            case 61: {
                return pSDEViewCtrlBase.getPSDEActionId();
            }
            case 62: {
                return pSDEViewCtrlBase.getPSDEActionName();
            }
            case 63: {
                return pSDEViewCtrlBase.getPSDEChartId();
            }
            case 64: {
                return pSDEViewCtrlBase.getPSDEChartName();
            }
            case 65: {
                return pSDEViewCtrlBase.getPSDEDataExpId();
            }
            case 66: {
                return pSDEViewCtrlBase.getPSDEDataExpName();
            }
            case 67: {
                return pSDEViewCtrlBase.getPSDEDataImpId();
            }
            case 68: {
                return pSDEViewCtrlBase.getPSDEDataImpName();
            }
            case 69: {
                return pSDEViewCtrlBase.getPSDEDataSetId();
            }
            case 70: {
                return pSDEViewCtrlBase.getPSDEDataSetName();
            }
            case 71: {
                return pSDEViewCtrlBase.getPSDEDataViewId();
            }
            case 72: {
                return pSDEViewCtrlBase.getPSDEDataViewName();
            }
            case 73: {
                return pSDEViewCtrlBase.getPSDEDRId();
            }
            case 74: {
                return pSDEViewCtrlBase.getPSDEDRName();
            }
            case 75: {
                return pSDEViewCtrlBase.getPSDEFormId();
            }
            case 76: {
                return pSDEViewCtrlBase.getPSDEFormName();
            }
            case 77: {
                return pSDEViewCtrlBase.getPSDEGridId();
            }
            case 78: {
                return pSDEViewCtrlBase.getPSDEGridName();
            }
            case 79: {
                return pSDEViewCtrlBase.getPSDEId();
            }
            case 80: {
                return pSDEViewCtrlBase.getPSDEListId();
            }
            case 81: {
                return pSDEViewCtrlBase.getPSDEListName();
            }
            case 82: {
                return pSDEViewCtrlBase.getPSDEName();
            }
            case 83: {
                return pSDEViewCtrlBase.getPSDEOPPrivId();
            }
            case 84: {
                return pSDEViewCtrlBase.getPSDEOPPrivName();
            }
            case 85: {
                return pSDEViewCtrlBase.getPSDEReportId();
            }
            case 86: {
                return pSDEViewCtrlBase.getPSDEReportName();
            }
            case 87: {
                return pSDEViewCtrlBase.getPSDEToolbarId();
            }
            case 88: {
                return pSDEViewCtrlBase.getPSDEToolbarName();
            }
            case 89: {
                return pSDEViewCtrlBase.getPSDETreeViewId();
            }
            case 90: {
                return pSDEViewCtrlBase.getPSDETreeViewName();
            }
            case 91: {
                return pSDEViewCtrlBase.getPSDEUAGroupId();
            }
            case 92: {
                return pSDEViewCtrlBase.getPSDEUAGroupName();
            }
            case 93: {
                return pSDEViewCtrlBase.getPSDEViewBaseId();
            }
            case 94: {
                return pSDEViewCtrlBase.getPSDEViewBaseName();
            }
            case 95: {
                return pSDEViewCtrlBase.getPSDEViewCtrlId();
            }
            case 96: {
                return pSDEViewCtrlBase.getPSDEViewCtrlName();
            }
            case 97: {
                return pSDEViewCtrlBase.getPSDEViewCtrlType();
            }
            case 98: {
                return pSDEViewCtrlBase.getPSDEViewId();
            }
            case 99: {
                return pSDEViewCtrlBase.getPSDEViewName();
            }
            case 100: {
                return pSDEViewCtrlBase.getPSDEWizardId();
            }
            case 101: {
                return pSDEViewCtrlBase.getPSDEWizardName();
            }
            case 102: {
                return pSDEViewCtrlBase.getPSDynaInstId();
            }
            case 103: {
                return pSDEViewCtrlBase.getPSPFId();
            }
            case 104: {
                return pSDEViewCtrlBase.getPSPFName();
            }
            case 105: {
                return pSDEViewCtrlBase.getPSSysCalendarId();
            }
            case 106: {
                return pSDEViewCtrlBase.getPSSysCalendarName();
            }
            case 107: {
                return pSDEViewCtrlBase.getPSSysCounterId();
            }
            case 108: {
                return pSDEViewCtrlBase.getPSSysCounterName();
            }
            case 109: {
                return pSDEViewCtrlBase.getPSSysCssId();
            }
            case 110: {
                return pSDEViewCtrlBase.getPSSysCssName();
            }
            case 111: {
                return pSDEViewCtrlBase.getPSSysDashboardId();
            }
            case 112: {
                return pSDEViewCtrlBase.getPSSysDashboardName();
            }
            case 113: {
                return pSDEViewCtrlBase.getPSSysDynaModelId();
            }
            case 114: {
                return pSDEViewCtrlBase.getPSSysDynaModelName();
            }
            case 115: {
                return pSDEViewCtrlBase.getPSSysImageId();
            }
            case 116: {
                return pSDEViewCtrlBase.getPSSysImageName();
            }
            case 117: {
                return pSDEViewCtrlBase.getPSSysMapViewId();
            }
            case 118: {
                return pSDEViewCtrlBase.getPSSysMapViewName();
            }
            case 119: {
                return pSDEViewCtrlBase.getPSSysMsgTemplId();
            }
            case 120: {
                return pSDEViewCtrlBase.getPSSysMsgTemplName();
            }
            case 121: {
                return pSDEViewCtrlBase.getPSSysPFPluginId();
            }
            case 122: {
                return pSDEViewCtrlBase.getPSSysPFPluginName();
            }
            case 123: {
                return pSDEViewCtrlBase.getPSSysSearchBarId();
            }
            case 124: {
                return pSDEViewCtrlBase.getPSSysSearchBarName();
            }
            case 125: {
                return pSDEViewCtrlBase.getPSSystemId();
            }
            case 126: {
                return pSDEViewCtrlBase.getPSSysViewPanelId();
            }
            case 127: {
                return pSDEViewCtrlBase.getPSSysViewPanelName();
            }
            case 128: {
                return pSDEViewCtrlBase.getReadOnlyMode();
            }
            case 129: {
                return pSDEViewCtrlBase.getRefCtrl2Name();
            }
            case 130: {
                return pSDEViewCtrlBase.getRefCtrl2Usage();
            }
            case 131: {
                return pSDEViewCtrlBase.getRefCtrl2UsageText();
            }
            case 132: {
                return pSDEViewCtrlBase.getRefCtrlName();
            }
            case 133: {
                return pSDEViewCtrlBase.getRefCtrlUsage();
            }
            case 134: {
                return pSDEViewCtrlBase.getRefCtrlUsageText();
            }
            case 135: {
                return pSDEViewCtrlBase.getRightPos();
            }
            case 136: {
                return pSDEViewCtrlBase.getSubPSACHandlerId();
            }
            case 137: {
                return pSDEViewCtrlBase.getSubPSACHandlerName();
            }
            case 138: {
                return pSDEViewCtrlBase.getTopPos();
            }
            case 139: {
                return pSDEViewCtrlBase.getUpdateDate();
            }
            case 140: {
                return pSDEViewCtrlBase.getUpdateMan();
            }
            case 141: {
                return pSDEViewCtrlBase.getUserTag();
            }
            case 142: {
                return pSDEViewCtrlBase.getUserTag2();
            }
            case 143: {
                return pSDEViewCtrlBase.getValidFlag();
            }
            case 144: {
                return pSDEViewCtrlBase.getWidth();
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
        PSDEViewCtrlBase.set(this, n, object);
    }

    private static void set(PSDEViewCtrlBase pSDEViewCtrlBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEViewCtrlBase.setADPSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEViewCtrlBase.setADPSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEViewCtrlBase.setBottomPos(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSDEViewCtrlBase.setBtnActionType(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEViewCtrlBase.setBusyIndicator(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDEViewCtrlBase.setCapPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEViewCtrlBase.setCapPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEViewCtrlBase.setCaption(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEViewCtrlBase.setConfigInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEViewCtrlBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSDEViewCtrlBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEViewCtrlBase.setCtrlParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEViewCtrlBase.setCtrlParam10(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 13: {
                pSDEViewCtrlBase.setCtrlParam11(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSDEViewCtrlBase.setCtrlParam12(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSDEViewCtrlBase.setCtrlParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEViewCtrlBase.setCtrlParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEViewCtrlBase.setCtrlParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEViewCtrlBase.setCtrlParam5(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSDEViewCtrlBase.setCtrlParam6(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 20: {
                pSDEViewCtrlBase.setCtrlParam7(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 21: {
                pSDEViewCtrlBase.setCtrlParam8(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 22: {
                pSDEViewCtrlBase.setCtrlParam9(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 23: {
                pSDEViewCtrlBase.setCtrlParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEViewCtrlBase.setCustomCond(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEViewCtrlBase.setCustomType(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEViewCtrlBase.setDefaultFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 27: {
                pSDEViewCtrlBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 28: {
                pSDEViewCtrlBase.setDyncMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 29: {
                pSDEViewCtrlBase.setEnableDynaSys(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 30: {
                pSDEViewCtrlBase.setEnableItemPriv(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 31: {
                pSDEViewCtrlBase.setEnableViewActions(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 32: {
                pSDEViewCtrlBase.setHeight(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 33: {
                pSDEViewCtrlBase.setInsertPos(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 34: {
                pSDEViewCtrlBase.setLeftPos(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 35: {
                pSDEViewCtrlBase.setLocalMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 36: {
                pSDEViewCtrlBase.setMargin(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDEViewCtrlBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDEViewCtrlBase.setMultiSelect(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 39: {
                pSDEViewCtrlBase.setNO2PSDEUAGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDEViewCtrlBase.setNO2PSDEUAGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDEViewCtrlBase.setNO3PSDEUAGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDEViewCtrlBase.setNO3PSDEUAGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSDEViewCtrlBase.setNO4PSDEUAGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSDEViewCtrlBase.setNO4PSDEUAGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSDEViewCtrlBase.setNO5PSDEUAGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSDEViewCtrlBase.setNO5PSDEUAGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSDEViewCtrlBase.setNO6PSDEUAGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSDEViewCtrlBase.setNO6PSDEUAGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSDEViewCtrlBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 50: {
                pSDEViewCtrlBase.setPadding(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSDEViewCtrlBase.setPredefinedType(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSDEViewCtrlBase.setPredefinedTypeText(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSDEViewCtrlBase.setPSACHandlerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSDEViewCtrlBase.setPSACHandlerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSDEViewCtrlBase.setPSCtrlId(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSDEViewCtrlBase.setPSCtrlLogicGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSDEViewCtrlBase.setPSCtrlLogicGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 58: {
                pSDEViewCtrlBase.setPSCtrlMsgId(DataObject.getStringValue((Object)object));
                return;
            }
            case 59: {
                pSDEViewCtrlBase.setPSCtrlMsgName(DataObject.getStringValue((Object)object));
                return;
            }
            case 60: {
                pSDEViewCtrlBase.setPSCtrlName(DataObject.getStringValue((Object)object));
                return;
            }
            case 61: {
                pSDEViewCtrlBase.setPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 62: {
                pSDEViewCtrlBase.setPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 63: {
                pSDEViewCtrlBase.setPSDEChartId(DataObject.getStringValue((Object)object));
                return;
            }
            case 64: {
                pSDEViewCtrlBase.setPSDEChartName(DataObject.getStringValue((Object)object));
                return;
            }
            case 65: {
                pSDEViewCtrlBase.setPSDEDataExpId(DataObject.getStringValue((Object)object));
                return;
            }
            case 66: {
                pSDEViewCtrlBase.setPSDEDataExpName(DataObject.getStringValue((Object)object));
                return;
            }
            case 67: {
                pSDEViewCtrlBase.setPSDEDataImpId(DataObject.getStringValue((Object)object));
                return;
            }
            case 68: {
                pSDEViewCtrlBase.setPSDEDataImpName(DataObject.getStringValue((Object)object));
                return;
            }
            case 69: {
                pSDEViewCtrlBase.setPSDEDataSetId(DataObject.getStringValue((Object)object));
                return;
            }
            case 70: {
                pSDEViewCtrlBase.setPSDEDataSetName(DataObject.getStringValue((Object)object));
                return;
            }
            case 71: {
                pSDEViewCtrlBase.setPSDEDataViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 72: {
                pSDEViewCtrlBase.setPSDEDataViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 73: {
                pSDEViewCtrlBase.setPSDEDRId(DataObject.getStringValue((Object)object));
                return;
            }
            case 74: {
                pSDEViewCtrlBase.setPSDEDRName(DataObject.getStringValue((Object)object));
                return;
            }
            case 75: {
                pSDEViewCtrlBase.setPSDEFormId(DataObject.getStringValue((Object)object));
                return;
            }
            case 76: {
                pSDEViewCtrlBase.setPSDEFormName(DataObject.getStringValue((Object)object));
                return;
            }
            case 77: {
                pSDEViewCtrlBase.setPSDEGridId(DataObject.getStringValue((Object)object));
                return;
            }
            case 78: {
                pSDEViewCtrlBase.setPSDEGridName(DataObject.getStringValue((Object)object));
                return;
            }
            case 79: {
                pSDEViewCtrlBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 80: {
                pSDEViewCtrlBase.setPSDEListId(DataObject.getStringValue((Object)object));
                return;
            }
            case 81: {
                pSDEViewCtrlBase.setPSDEListName(DataObject.getStringValue((Object)object));
                return;
            }
            case 82: {
                pSDEViewCtrlBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 83: {
                pSDEViewCtrlBase.setPSDEOPPrivId(DataObject.getStringValue((Object)object));
                return;
            }
            case 84: {
                pSDEViewCtrlBase.setPSDEOPPrivName(DataObject.getStringValue((Object)object));
                return;
            }
            case 85: {
                pSDEViewCtrlBase.setPSDEReportId(DataObject.getStringValue((Object)object));
                return;
            }
            case 86: {
                pSDEViewCtrlBase.setPSDEReportName(DataObject.getStringValue((Object)object));
                return;
            }
            case 87: {
                pSDEViewCtrlBase.setPSDEToolbarId(DataObject.getStringValue((Object)object));
                return;
            }
            case 88: {
                pSDEViewCtrlBase.setPSDEToolbarName(DataObject.getStringValue((Object)object));
                return;
            }
            case 89: {
                pSDEViewCtrlBase.setPSDETreeViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 90: {
                pSDEViewCtrlBase.setPSDETreeViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 91: {
                pSDEViewCtrlBase.setPSDEUAGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 92: {
                pSDEViewCtrlBase.setPSDEUAGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 93: {
                pSDEViewCtrlBase.setPSDEViewBaseId(DataObject.getStringValue((Object)object));
                return;
            }
            case 94: {
                pSDEViewCtrlBase.setPSDEViewBaseName(DataObject.getStringValue((Object)object));
                return;
            }
            case 95: {
                pSDEViewCtrlBase.setPSDEViewCtrlId(DataObject.getStringValue((Object)object));
                return;
            }
            case 96: {
                pSDEViewCtrlBase.setPSDEViewCtrlName(DataObject.getStringValue((Object)object));
                return;
            }
            case 97: {
                pSDEViewCtrlBase.setPSDEViewCtrlType(DataObject.getStringValue((Object)object));
                return;
            }
            case 98: {
                pSDEViewCtrlBase.setPSDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 99: {
                pSDEViewCtrlBase.setPSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 100: {
                pSDEViewCtrlBase.setPSDEWizardId(DataObject.getStringValue((Object)object));
                return;
            }
            case 101: {
                pSDEViewCtrlBase.setPSDEWizardName(DataObject.getStringValue((Object)object));
                return;
            }
            case 102: {
                pSDEViewCtrlBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 103: {
                pSDEViewCtrlBase.setPSPFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 104: {
                pSDEViewCtrlBase.setPSPFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 105: {
                pSDEViewCtrlBase.setPSSysCalendarId(DataObject.getStringValue((Object)object));
                return;
            }
            case 106: {
                pSDEViewCtrlBase.setPSSysCalendarName(DataObject.getStringValue((Object)object));
                return;
            }
            case 107: {
                pSDEViewCtrlBase.setPSSysCounterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 108: {
                pSDEViewCtrlBase.setPSSysCounterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 109: {
                pSDEViewCtrlBase.setPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 110: {
                pSDEViewCtrlBase.setPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 111: {
                pSDEViewCtrlBase.setPSSysDashboardId(DataObject.getStringValue((Object)object));
                return;
            }
            case 112: {
                pSDEViewCtrlBase.setPSSysDashboardName(DataObject.getStringValue((Object)object));
                return;
            }
            case 113: {
                pSDEViewCtrlBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 114: {
                pSDEViewCtrlBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 115: {
                pSDEViewCtrlBase.setPSSysImageId(DataObject.getStringValue((Object)object));
                return;
            }
            case 116: {
                pSDEViewCtrlBase.setPSSysImageName(DataObject.getStringValue((Object)object));
                return;
            }
            case 117: {
                pSDEViewCtrlBase.setPSSysMapViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 118: {
                pSDEViewCtrlBase.setPSSysMapViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 119: {
                pSDEViewCtrlBase.setPSSysMsgTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 120: {
                pSDEViewCtrlBase.setPSSysMsgTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 121: {
                pSDEViewCtrlBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 122: {
                pSDEViewCtrlBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 123: {
                pSDEViewCtrlBase.setPSSysSearchBarId(DataObject.getStringValue((Object)object));
                return;
            }
            case 124: {
                pSDEViewCtrlBase.setPSSysSearchBarName(DataObject.getStringValue((Object)object));
                return;
            }
            case 125: {
                pSDEViewCtrlBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 126: {
                pSDEViewCtrlBase.setPSSysViewPanelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 127: {
                pSDEViewCtrlBase.setPSSysViewPanelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 128: {
                pSDEViewCtrlBase.setReadOnlyMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 129: {
                pSDEViewCtrlBase.setRefCtrl2Name(DataObject.getStringValue((Object)object));
                return;
            }
            case 130: {
                pSDEViewCtrlBase.setRefCtrl2Usage(DataObject.getStringValue((Object)object));
                return;
            }
            case 131: {
                pSDEViewCtrlBase.setRefCtrl2UsageText(DataObject.getStringValue((Object)object));
                return;
            }
            case 132: {
                pSDEViewCtrlBase.setRefCtrlName(DataObject.getStringValue((Object)object));
                return;
            }
            case 133: {
                pSDEViewCtrlBase.setRefCtrlUsage(DataObject.getStringValue((Object)object));
                return;
            }
            case 134: {
                pSDEViewCtrlBase.setRefCtrlUsageText(DataObject.getStringValue((Object)object));
                return;
            }
            case 135: {
                pSDEViewCtrlBase.setRightPos(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 136: {
                pSDEViewCtrlBase.setSubPSACHandlerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 137: {
                pSDEViewCtrlBase.setSubPSACHandlerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 138: {
                pSDEViewCtrlBase.setTopPos(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 139: {
                pSDEViewCtrlBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 140: {
                pSDEViewCtrlBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 141: {
                pSDEViewCtrlBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 142: {
                pSDEViewCtrlBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 143: {
                pSDEViewCtrlBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 144: {
                pSDEViewCtrlBase.setWidth(DataObject.getDoubleValue((Object)object));
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
        return PSDEViewCtrlBase.isNull(this, n);
    }

    private static boolean isNull(PSDEViewCtrlBase pSDEViewCtrlBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEViewCtrlBase.getADPSDELogicId() == null;
            }
            case 1: {
                return pSDEViewCtrlBase.getADPSDELogicName() == null;
            }
            case 2: {
                return pSDEViewCtrlBase.getBottomPos() == null;
            }
            case 3: {
                return pSDEViewCtrlBase.getBtnActionType() == null;
            }
            case 4: {
                return pSDEViewCtrlBase.getBusyIndicator() == null;
            }
            case 5: {
                return pSDEViewCtrlBase.getCapPSLanResId() == null;
            }
            case 6: {
                return pSDEViewCtrlBase.getCapPSLanResName() == null;
            }
            case 7: {
                return pSDEViewCtrlBase.getCaption() == null;
            }
            case 8: {
                return pSDEViewCtrlBase.getConfigInfo() == null;
            }
            case 9: {
                return pSDEViewCtrlBase.getCreateDate() == null;
            }
            case 10: {
                return pSDEViewCtrlBase.getCreateMan() == null;
            }
            case 11: {
                return pSDEViewCtrlBase.getCtrlParam() == null;
            }
            case 12: {
                return pSDEViewCtrlBase.getCtrlParam10() == null;
            }
            case 13: {
                return pSDEViewCtrlBase.getCtrlParam11() == null;
            }
            case 14: {
                return pSDEViewCtrlBase.getCtrlParam12() == null;
            }
            case 15: {
                return pSDEViewCtrlBase.getCtrlParam2() == null;
            }
            case 16: {
                return pSDEViewCtrlBase.getCtrlParam3() == null;
            }
            case 17: {
                return pSDEViewCtrlBase.getCtrlParam4() == null;
            }
            case 18: {
                return pSDEViewCtrlBase.getCtrlParam5() == null;
            }
            case 19: {
                return pSDEViewCtrlBase.getCtrlParam6() == null;
            }
            case 20: {
                return pSDEViewCtrlBase.getCtrlParam7() == null;
            }
            case 21: {
                return pSDEViewCtrlBase.getCtrlParam8() == null;
            }
            case 22: {
                return pSDEViewCtrlBase.getCtrlParam9() == null;
            }
            case 23: {
                return pSDEViewCtrlBase.getCtrlParams() == null;
            }
            case 24: {
                return pSDEViewCtrlBase.getCustomCond() == null;
            }
            case 25: {
                return pSDEViewCtrlBase.getCustomType() == null;
            }
            case 26: {
                return pSDEViewCtrlBase.getDefaultFlag() == null;
            }
            case 27: {
                return pSDEViewCtrlBase.getDynaModelFlag() == null;
            }
            case 28: {
                return pSDEViewCtrlBase.getDyncMode() == null;
            }
            case 29: {
                return pSDEViewCtrlBase.getEnableDynaSys() == null;
            }
            case 30: {
                return pSDEViewCtrlBase.getEnableItemPriv() == null;
            }
            case 31: {
                return pSDEViewCtrlBase.getEnableViewActions() == null;
            }
            case 32: {
                return pSDEViewCtrlBase.getHeight() == null;
            }
            case 33: {
                return pSDEViewCtrlBase.getInsertPos() == null;
            }
            case 34: {
                return pSDEViewCtrlBase.getLeftPos() == null;
            }
            case 35: {
                return pSDEViewCtrlBase.getLocalMode() == null;
            }
            case 36: {
                return pSDEViewCtrlBase.getMargin() == null;
            }
            case 37: {
                return pSDEViewCtrlBase.getMemo() == null;
            }
            case 38: {
                return pSDEViewCtrlBase.getMultiSelect() == null;
            }
            case 39: {
                return pSDEViewCtrlBase.getNO2PSDEUAGroupId() == null;
            }
            case 40: {
                return pSDEViewCtrlBase.getNO2PSDEUAGroupName() == null;
            }
            case 41: {
                return pSDEViewCtrlBase.getNO3PSDEUAGroupId() == null;
            }
            case 42: {
                return pSDEViewCtrlBase.getNO3PSDEUAGroupName() == null;
            }
            case 43: {
                return pSDEViewCtrlBase.getNO4PSDEUAGroupId() == null;
            }
            case 44: {
                return pSDEViewCtrlBase.getNO4PSDEUAGroupName() == null;
            }
            case 45: {
                return pSDEViewCtrlBase.getNO5PSDEUAGroupId() == null;
            }
            case 46: {
                return pSDEViewCtrlBase.getNO5PSDEUAGroupName() == null;
            }
            case 47: {
                return pSDEViewCtrlBase.getNO6PSDEUAGroupId() == null;
            }
            case 48: {
                return pSDEViewCtrlBase.getNO6PSDEUAGroupName() == null;
            }
            case 49: {
                return pSDEViewCtrlBase.getOrderValue() == null;
            }
            case 50: {
                return pSDEViewCtrlBase.getPadding() == null;
            }
            case 51: {
                return pSDEViewCtrlBase.getPredefinedType() == null;
            }
            case 52: {
                return pSDEViewCtrlBase.getPredefinedTypeText() == null;
            }
            case 53: {
                return pSDEViewCtrlBase.getPSACHandlerId() == null;
            }
            case 54: {
                return pSDEViewCtrlBase.getPSACHandlerName() == null;
            }
            case 55: {
                return pSDEViewCtrlBase.getPSCtrlId() == null;
            }
            case 56: {
                return pSDEViewCtrlBase.getPSCtrlLogicGroupId() == null;
            }
            case 57: {
                return pSDEViewCtrlBase.getPSCtrlLogicGroupName() == null;
            }
            case 58: {
                return pSDEViewCtrlBase.getPSCtrlMsgId() == null;
            }
            case 59: {
                return pSDEViewCtrlBase.getPSCtrlMsgName() == null;
            }
            case 60: {
                return pSDEViewCtrlBase.getPSCtrlName() == null;
            }
            case 61: {
                return pSDEViewCtrlBase.getPSDEActionId() == null;
            }
            case 62: {
                return pSDEViewCtrlBase.getPSDEActionName() == null;
            }
            case 63: {
                return pSDEViewCtrlBase.getPSDEChartId() == null;
            }
            case 64: {
                return pSDEViewCtrlBase.getPSDEChartName() == null;
            }
            case 65: {
                return pSDEViewCtrlBase.getPSDEDataExpId() == null;
            }
            case 66: {
                return pSDEViewCtrlBase.getPSDEDataExpName() == null;
            }
            case 67: {
                return pSDEViewCtrlBase.getPSDEDataImpId() == null;
            }
            case 68: {
                return pSDEViewCtrlBase.getPSDEDataImpName() == null;
            }
            case 69: {
                return pSDEViewCtrlBase.getPSDEDataSetId() == null;
            }
            case 70: {
                return pSDEViewCtrlBase.getPSDEDataSetName() == null;
            }
            case 71: {
                return pSDEViewCtrlBase.getPSDEDataViewId() == null;
            }
            case 72: {
                return pSDEViewCtrlBase.getPSDEDataViewName() == null;
            }
            case 73: {
                return pSDEViewCtrlBase.getPSDEDRId() == null;
            }
            case 74: {
                return pSDEViewCtrlBase.getPSDEDRName() == null;
            }
            case 75: {
                return pSDEViewCtrlBase.getPSDEFormId() == null;
            }
            case 76: {
                return pSDEViewCtrlBase.getPSDEFormName() == null;
            }
            case 77: {
                return pSDEViewCtrlBase.getPSDEGridId() == null;
            }
            case 78: {
                return pSDEViewCtrlBase.getPSDEGridName() == null;
            }
            case 79: {
                return pSDEViewCtrlBase.getPSDEId() == null;
            }
            case 80: {
                return pSDEViewCtrlBase.getPSDEListId() == null;
            }
            case 81: {
                return pSDEViewCtrlBase.getPSDEListName() == null;
            }
            case 82: {
                return pSDEViewCtrlBase.getPSDEName() == null;
            }
            case 83: {
                return pSDEViewCtrlBase.getPSDEOPPrivId() == null;
            }
            case 84: {
                return pSDEViewCtrlBase.getPSDEOPPrivName() == null;
            }
            case 85: {
                return pSDEViewCtrlBase.getPSDEReportId() == null;
            }
            case 86: {
                return pSDEViewCtrlBase.getPSDEReportName() == null;
            }
            case 87: {
                return pSDEViewCtrlBase.getPSDEToolbarId() == null;
            }
            case 88: {
                return pSDEViewCtrlBase.getPSDEToolbarName() == null;
            }
            case 89: {
                return pSDEViewCtrlBase.getPSDETreeViewId() == null;
            }
            case 90: {
                return pSDEViewCtrlBase.getPSDETreeViewName() == null;
            }
            case 91: {
                return pSDEViewCtrlBase.getPSDEUAGroupId() == null;
            }
            case 92: {
                return pSDEViewCtrlBase.getPSDEUAGroupName() == null;
            }
            case 93: {
                return pSDEViewCtrlBase.getPSDEViewBaseId() == null;
            }
            case 94: {
                return pSDEViewCtrlBase.getPSDEViewBaseName() == null;
            }
            case 95: {
                return pSDEViewCtrlBase.getPSDEViewCtrlId() == null;
            }
            case 96: {
                return pSDEViewCtrlBase.getPSDEViewCtrlName() == null;
            }
            case 97: {
                return pSDEViewCtrlBase.getPSDEViewCtrlType() == null;
            }
            case 98: {
                return pSDEViewCtrlBase.getPSDEViewId() == null;
            }
            case 99: {
                return pSDEViewCtrlBase.getPSDEViewName() == null;
            }
            case 100: {
                return pSDEViewCtrlBase.getPSDEWizardId() == null;
            }
            case 101: {
                return pSDEViewCtrlBase.getPSDEWizardName() == null;
            }
            case 102: {
                return pSDEViewCtrlBase.getPSDynaInstId() == null;
            }
            case 103: {
                return pSDEViewCtrlBase.getPSPFId() == null;
            }
            case 104: {
                return pSDEViewCtrlBase.getPSPFName() == null;
            }
            case 105: {
                return pSDEViewCtrlBase.getPSSysCalendarId() == null;
            }
            case 106: {
                return pSDEViewCtrlBase.getPSSysCalendarName() == null;
            }
            case 107: {
                return pSDEViewCtrlBase.getPSSysCounterId() == null;
            }
            case 108: {
                return pSDEViewCtrlBase.getPSSysCounterName() == null;
            }
            case 109: {
                return pSDEViewCtrlBase.getPSSysCssId() == null;
            }
            case 110: {
                return pSDEViewCtrlBase.getPSSysCssName() == null;
            }
            case 111: {
                return pSDEViewCtrlBase.getPSSysDashboardId() == null;
            }
            case 112: {
                return pSDEViewCtrlBase.getPSSysDashboardName() == null;
            }
            case 113: {
                return pSDEViewCtrlBase.getPSSysDynaModelId() == null;
            }
            case 114: {
                return pSDEViewCtrlBase.getPSSysDynaModelName() == null;
            }
            case 115: {
                return pSDEViewCtrlBase.getPSSysImageId() == null;
            }
            case 116: {
                return pSDEViewCtrlBase.getPSSysImageName() == null;
            }
            case 117: {
                return pSDEViewCtrlBase.getPSSysMapViewId() == null;
            }
            case 118: {
                return pSDEViewCtrlBase.getPSSysMapViewName() == null;
            }
            case 119: {
                return pSDEViewCtrlBase.getPSSysMsgTemplId() == null;
            }
            case 120: {
                return pSDEViewCtrlBase.getPSSysMsgTemplName() == null;
            }
            case 121: {
                return pSDEViewCtrlBase.getPSSysPFPluginId() == null;
            }
            case 122: {
                return pSDEViewCtrlBase.getPSSysPFPluginName() == null;
            }
            case 123: {
                return pSDEViewCtrlBase.getPSSysSearchBarId() == null;
            }
            case 124: {
                return pSDEViewCtrlBase.getPSSysSearchBarName() == null;
            }
            case 125: {
                return pSDEViewCtrlBase.getPSSystemId() == null;
            }
            case 126: {
                return pSDEViewCtrlBase.getPSSysViewPanelId() == null;
            }
            case 127: {
                return pSDEViewCtrlBase.getPSSysViewPanelName() == null;
            }
            case 128: {
                return pSDEViewCtrlBase.getReadOnlyMode() == null;
            }
            case 129: {
                return pSDEViewCtrlBase.getRefCtrl2Name() == null;
            }
            case 130: {
                return pSDEViewCtrlBase.getRefCtrl2Usage() == null;
            }
            case 131: {
                return pSDEViewCtrlBase.getRefCtrl2UsageText() == null;
            }
            case 132: {
                return pSDEViewCtrlBase.getRefCtrlName() == null;
            }
            case 133: {
                return pSDEViewCtrlBase.getRefCtrlUsage() == null;
            }
            case 134: {
                return pSDEViewCtrlBase.getRefCtrlUsageText() == null;
            }
            case 135: {
                return pSDEViewCtrlBase.getRightPos() == null;
            }
            case 136: {
                return pSDEViewCtrlBase.getSubPSACHandlerId() == null;
            }
            case 137: {
                return pSDEViewCtrlBase.getSubPSACHandlerName() == null;
            }
            case 138: {
                return pSDEViewCtrlBase.getTopPos() == null;
            }
            case 139: {
                return pSDEViewCtrlBase.getUpdateDate() == null;
            }
            case 140: {
                return pSDEViewCtrlBase.getUpdateMan() == null;
            }
            case 141: {
                return pSDEViewCtrlBase.getUserTag() == null;
            }
            case 142: {
                return pSDEViewCtrlBase.getUserTag2() == null;
            }
            case 143: {
                return pSDEViewCtrlBase.getValidFlag() == null;
            }
            case 144: {
                return pSDEViewCtrlBase.getWidth() == null;
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
        return PSDEViewCtrlBase.contains(this, n);
    }

    private static boolean contains(PSDEViewCtrlBase pSDEViewCtrlBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEViewCtrlBase.isADPSDELogicIdDirty();
            }
            case 1: {
                return pSDEViewCtrlBase.isADPSDELogicNameDirty();
            }
            case 2: {
                return pSDEViewCtrlBase.isBottomPosDirty();
            }
            case 3: {
                return pSDEViewCtrlBase.isBtnActionTypeDirty();
            }
            case 4: {
                return pSDEViewCtrlBase.isBusyIndicatorDirty();
            }
            case 5: {
                return pSDEViewCtrlBase.isCapPSLanResIdDirty();
            }
            case 6: {
                return pSDEViewCtrlBase.isCapPSLanResNameDirty();
            }
            case 7: {
                return pSDEViewCtrlBase.isCaptionDirty();
            }
            case 8: {
                return pSDEViewCtrlBase.isConfigInfoDirty();
            }
            case 9: {
                return pSDEViewCtrlBase.isCreateDateDirty();
            }
            case 10: {
                return pSDEViewCtrlBase.isCreateManDirty();
            }
            case 11: {
                return pSDEViewCtrlBase.isCtrlParamDirty();
            }
            case 12: {
                return pSDEViewCtrlBase.isCtrlParam10Dirty();
            }
            case 13: {
                return pSDEViewCtrlBase.isCtrlParam11Dirty();
            }
            case 14: {
                return pSDEViewCtrlBase.isCtrlParam12Dirty();
            }
            case 15: {
                return pSDEViewCtrlBase.isCtrlParam2Dirty();
            }
            case 16: {
                return pSDEViewCtrlBase.isCtrlParam3Dirty();
            }
            case 17: {
                return pSDEViewCtrlBase.isCtrlParam4Dirty();
            }
            case 18: {
                return pSDEViewCtrlBase.isCtrlParam5Dirty();
            }
            case 19: {
                return pSDEViewCtrlBase.isCtrlParam6Dirty();
            }
            case 20: {
                return pSDEViewCtrlBase.isCtrlParam7Dirty();
            }
            case 21: {
                return pSDEViewCtrlBase.isCtrlParam8Dirty();
            }
            case 22: {
                return pSDEViewCtrlBase.isCtrlParam9Dirty();
            }
            case 23: {
                return pSDEViewCtrlBase.isCtrlParamsDirty();
            }
            case 24: {
                return pSDEViewCtrlBase.isCustomCondDirty();
            }
            case 25: {
                return pSDEViewCtrlBase.isCustomTypeDirty();
            }
            case 26: {
                return pSDEViewCtrlBase.isDefaultFlagDirty();
            }
            case 27: {
                return pSDEViewCtrlBase.isDynaModelFlagDirty();
            }
            case 28: {
                return pSDEViewCtrlBase.isDyncModeDirty();
            }
            case 29: {
                return pSDEViewCtrlBase.isEnableDynaSysDirty();
            }
            case 30: {
                return pSDEViewCtrlBase.isEnableItemPrivDirty();
            }
            case 31: {
                return pSDEViewCtrlBase.isEnableViewActionsDirty();
            }
            case 32: {
                return pSDEViewCtrlBase.isHeightDirty();
            }
            case 33: {
                return pSDEViewCtrlBase.isInsertPosDirty();
            }
            case 34: {
                return pSDEViewCtrlBase.isLeftPosDirty();
            }
            case 35: {
                return pSDEViewCtrlBase.isLocalModeDirty();
            }
            case 36: {
                return pSDEViewCtrlBase.isMarginDirty();
            }
            case 37: {
                return pSDEViewCtrlBase.isMemoDirty();
            }
            case 38: {
                return pSDEViewCtrlBase.isMultiSelectDirty();
            }
            case 39: {
                return pSDEViewCtrlBase.isNO2PSDEUAGroupIdDirty();
            }
            case 40: {
                return pSDEViewCtrlBase.isNO2PSDEUAGroupNameDirty();
            }
            case 41: {
                return pSDEViewCtrlBase.isNO3PSDEUAGroupIdDirty();
            }
            case 42: {
                return pSDEViewCtrlBase.isNO3PSDEUAGroupNameDirty();
            }
            case 43: {
                return pSDEViewCtrlBase.isNO4PSDEUAGroupIdDirty();
            }
            case 44: {
                return pSDEViewCtrlBase.isNO4PSDEUAGroupNameDirty();
            }
            case 45: {
                return pSDEViewCtrlBase.isNO5PSDEUAGroupIdDirty();
            }
            case 46: {
                return pSDEViewCtrlBase.isNO5PSDEUAGroupNameDirty();
            }
            case 47: {
                return pSDEViewCtrlBase.isNO6PSDEUAGroupIdDirty();
            }
            case 48: {
                return pSDEViewCtrlBase.isNO6PSDEUAGroupNameDirty();
            }
            case 49: {
                return pSDEViewCtrlBase.isOrderValueDirty();
            }
            case 50: {
                return pSDEViewCtrlBase.isPaddingDirty();
            }
            case 51: {
                return pSDEViewCtrlBase.isPredefinedTypeDirty();
            }
            case 52: {
                return pSDEViewCtrlBase.isPredefinedTypeTextDirty();
            }
            case 53: {
                return pSDEViewCtrlBase.isPSACHandlerIdDirty();
            }
            case 54: {
                return pSDEViewCtrlBase.isPSACHandlerNameDirty();
            }
            case 55: {
                return pSDEViewCtrlBase.isPSCtrlIdDirty();
            }
            case 56: {
                return pSDEViewCtrlBase.isPSCtrlLogicGroupIdDirty();
            }
            case 57: {
                return pSDEViewCtrlBase.isPSCtrlLogicGroupNameDirty();
            }
            case 58: {
                return pSDEViewCtrlBase.isPSCtrlMsgIdDirty();
            }
            case 59: {
                return pSDEViewCtrlBase.isPSCtrlMsgNameDirty();
            }
            case 60: {
                return pSDEViewCtrlBase.isPSCtrlNameDirty();
            }
            case 61: {
                return pSDEViewCtrlBase.isPSDEActionIdDirty();
            }
            case 62: {
                return pSDEViewCtrlBase.isPSDEActionNameDirty();
            }
            case 63: {
                return pSDEViewCtrlBase.isPSDEChartIdDirty();
            }
            case 64: {
                return pSDEViewCtrlBase.isPSDEChartNameDirty();
            }
            case 65: {
                return pSDEViewCtrlBase.isPSDEDataExpIdDirty();
            }
            case 66: {
                return pSDEViewCtrlBase.isPSDEDataExpNameDirty();
            }
            case 67: {
                return pSDEViewCtrlBase.isPSDEDataImpIdDirty();
            }
            case 68: {
                return pSDEViewCtrlBase.isPSDEDataImpNameDirty();
            }
            case 69: {
                return pSDEViewCtrlBase.isPSDEDataSetIdDirty();
            }
            case 70: {
                return pSDEViewCtrlBase.isPSDEDataSetNameDirty();
            }
            case 71: {
                return pSDEViewCtrlBase.isPSDEDataViewIdDirty();
            }
            case 72: {
                return pSDEViewCtrlBase.isPSDEDataViewNameDirty();
            }
            case 73: {
                return pSDEViewCtrlBase.isPSDEDRIdDirty();
            }
            case 74: {
                return pSDEViewCtrlBase.isPSDEDRNameDirty();
            }
            case 75: {
                return pSDEViewCtrlBase.isPSDEFormIdDirty();
            }
            case 76: {
                return pSDEViewCtrlBase.isPSDEFormNameDirty();
            }
            case 77: {
                return pSDEViewCtrlBase.isPSDEGridIdDirty();
            }
            case 78: {
                return pSDEViewCtrlBase.isPSDEGridNameDirty();
            }
            case 79: {
                return pSDEViewCtrlBase.isPSDEIdDirty();
            }
            case 80: {
                return pSDEViewCtrlBase.isPSDEListIdDirty();
            }
            case 81: {
                return pSDEViewCtrlBase.isPSDEListNameDirty();
            }
            case 82: {
                return pSDEViewCtrlBase.isPSDENameDirty();
            }
            case 83: {
                return pSDEViewCtrlBase.isPSDEOPPrivIdDirty();
            }
            case 84: {
                return pSDEViewCtrlBase.isPSDEOPPrivNameDirty();
            }
            case 85: {
                return pSDEViewCtrlBase.isPSDEReportIdDirty();
            }
            case 86: {
                return pSDEViewCtrlBase.isPSDEReportNameDirty();
            }
            case 87: {
                return pSDEViewCtrlBase.isPSDEToolbarIdDirty();
            }
            case 88: {
                return pSDEViewCtrlBase.isPSDEToolbarNameDirty();
            }
            case 89: {
                return pSDEViewCtrlBase.isPSDETreeViewIdDirty();
            }
            case 90: {
                return pSDEViewCtrlBase.isPSDETreeViewNameDirty();
            }
            case 91: {
                return pSDEViewCtrlBase.isPSDEUAGroupIdDirty();
            }
            case 92: {
                return pSDEViewCtrlBase.isPSDEUAGroupNameDirty();
            }
            case 93: {
                return pSDEViewCtrlBase.isPSDEViewBaseIdDirty();
            }
            case 94: {
                return pSDEViewCtrlBase.isPSDEViewBaseNameDirty();
            }
            case 95: {
                return pSDEViewCtrlBase.isPSDEViewCtrlIdDirty();
            }
            case 96: {
                return pSDEViewCtrlBase.isPSDEViewCtrlNameDirty();
            }
            case 97: {
                return pSDEViewCtrlBase.isPSDEViewCtrlTypeDirty();
            }
            case 98: {
                return pSDEViewCtrlBase.isPSDEViewIdDirty();
            }
            case 99: {
                return pSDEViewCtrlBase.isPSDEViewNameDirty();
            }
            case 100: {
                return pSDEViewCtrlBase.isPSDEWizardIdDirty();
            }
            case 101: {
                return pSDEViewCtrlBase.isPSDEWizardNameDirty();
            }
            case 102: {
                return pSDEViewCtrlBase.isPSDynaInstIdDirty();
            }
            case 103: {
                return pSDEViewCtrlBase.isPSPFIdDirty();
            }
            case 104: {
                return pSDEViewCtrlBase.isPSPFNameDirty();
            }
            case 105: {
                return pSDEViewCtrlBase.isPSSysCalendarIdDirty();
            }
            case 106: {
                return pSDEViewCtrlBase.isPSSysCalendarNameDirty();
            }
            case 107: {
                return pSDEViewCtrlBase.isPSSysCounterIdDirty();
            }
            case 108: {
                return pSDEViewCtrlBase.isPSSysCounterNameDirty();
            }
            case 109: {
                return pSDEViewCtrlBase.isPSSysCssIdDirty();
            }
            case 110: {
                return pSDEViewCtrlBase.isPSSysCssNameDirty();
            }
            case 111: {
                return pSDEViewCtrlBase.isPSSysDashboardIdDirty();
            }
            case 112: {
                return pSDEViewCtrlBase.isPSSysDashboardNameDirty();
            }
            case 113: {
                return pSDEViewCtrlBase.isPSSysDynaModelIdDirty();
            }
            case 114: {
                return pSDEViewCtrlBase.isPSSysDynaModelNameDirty();
            }
            case 115: {
                return pSDEViewCtrlBase.isPSSysImageIdDirty();
            }
            case 116: {
                return pSDEViewCtrlBase.isPSSysImageNameDirty();
            }
            case 117: {
                return pSDEViewCtrlBase.isPSSysMapViewIdDirty();
            }
            case 118: {
                return pSDEViewCtrlBase.isPSSysMapViewNameDirty();
            }
            case 119: {
                return pSDEViewCtrlBase.isPSSysMsgTemplIdDirty();
            }
            case 120: {
                return pSDEViewCtrlBase.isPSSysMsgTemplNameDirty();
            }
            case 121: {
                return pSDEViewCtrlBase.isPSSysPFPluginIdDirty();
            }
            case 122: {
                return pSDEViewCtrlBase.isPSSysPFPluginNameDirty();
            }
            case 123: {
                return pSDEViewCtrlBase.isPSSysSearchBarIdDirty();
            }
            case 124: {
                return pSDEViewCtrlBase.isPSSysSearchBarNameDirty();
            }
            case 125: {
                return pSDEViewCtrlBase.isPSSystemIdDirty();
            }
            case 126: {
                return pSDEViewCtrlBase.isPSSysViewPanelIdDirty();
            }
            case 127: {
                return pSDEViewCtrlBase.isPSSysViewPanelNameDirty();
            }
            case 128: {
                return pSDEViewCtrlBase.isReadOnlyModeDirty();
            }
            case 129: {
                return pSDEViewCtrlBase.isRefCtrl2NameDirty();
            }
            case 130: {
                return pSDEViewCtrlBase.isRefCtrl2UsageDirty();
            }
            case 131: {
                return pSDEViewCtrlBase.isRefCtrl2UsageTextDirty();
            }
            case 132: {
                return pSDEViewCtrlBase.isRefCtrlNameDirty();
            }
            case 133: {
                return pSDEViewCtrlBase.isRefCtrlUsageDirty();
            }
            case 134: {
                return pSDEViewCtrlBase.isRefCtrlUsageTextDirty();
            }
            case 135: {
                return pSDEViewCtrlBase.isRightPosDirty();
            }
            case 136: {
                return pSDEViewCtrlBase.isSubPSACHandlerIdDirty();
            }
            case 137: {
                return pSDEViewCtrlBase.isSubPSACHandlerNameDirty();
            }
            case 138: {
                return pSDEViewCtrlBase.isTopPosDirty();
            }
            case 139: {
                return pSDEViewCtrlBase.isUpdateDateDirty();
            }
            case 140: {
                return pSDEViewCtrlBase.isUpdateManDirty();
            }
            case 141: {
                return pSDEViewCtrlBase.isUserTagDirty();
            }
            case 142: {
                return pSDEViewCtrlBase.isUserTag2Dirty();
            }
            case 143: {
                return pSDEViewCtrlBase.isValidFlagDirty();
            }
            case 144: {
                return pSDEViewCtrlBase.isWidthDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEViewCtrlBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEViewCtrlBase pSDEViewCtrlBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEViewCtrlBase.getADPSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"adpsdelogicid", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getADPSDELogicId()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getADPSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"adpsdelogicname", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getADPSDELogicName()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getBottomPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bottompos", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getBottomPos()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getBtnActionType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"btnactiontype", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getBtnActionType()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getBusyIndicator() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"busyindicator", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getBusyIndicator()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getCapPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cappslanresid", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getCapPSLanResId()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getCapPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cappslanresname", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getCapPSLanResName()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getCaption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"caption", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getCaption()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getConfigInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"configinfo", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getConfigInfo()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getCtrlParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getCtrlParam()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getCtrlParam10() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam10", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getCtrlParam10()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getCtrlParam11() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam11", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getCtrlParam11()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getCtrlParam12() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam12", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getCtrlParam12()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getCtrlParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam2", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getCtrlParam2()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getCtrlParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam3", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getCtrlParam3()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getCtrlParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam4", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getCtrlParam4()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getCtrlParam5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam5", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getCtrlParam5()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getCtrlParam6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam6", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getCtrlParam6()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getCtrlParam7() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam7", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getCtrlParam7()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getCtrlParam8() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam8", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getCtrlParam8()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getCtrlParam9() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam9", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getCtrlParam9()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getCtrlParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparams", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getCtrlParams()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getCustomCond() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcond", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getCustomCond()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getCustomType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customtype", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getCustomType()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getDefaultFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultflag", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getDefaultFlag()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getDyncMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dyncmode", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getDyncMode()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getEnableDynaSys() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enabledynasys", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getEnableDynaSys()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getEnableItemPriv() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableitempriv", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getEnableItemPriv()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getEnableViewActions() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableviewactions", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getEnableViewActions()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"height", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getHeight()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getInsertPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"insertpos", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getInsertPos()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getLeftPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"leftpos", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getLeftPos()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getLocalMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"localmode", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getLocalMode()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getMargin() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"margin", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getMargin()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getMultiSelect() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"multiselect", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getMultiSelect()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getNO2PSDEUAGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no2psdeuagroupid", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getNO2PSDEUAGroupId()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getNO2PSDEUAGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no2psdeuagroupname", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getNO2PSDEUAGroupName()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getNO3PSDEUAGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no3psdeuagroupid", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getNO3PSDEUAGroupId()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getNO3PSDEUAGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no3psdeuagroupname", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getNO3PSDEUAGroupName()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getNO4PSDEUAGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no4psdeuagroupid", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getNO4PSDEUAGroupId()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getNO4PSDEUAGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no4psdeuagroupname", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getNO4PSDEUAGroupName()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getNO5PSDEUAGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no5psdeuagroupid", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getNO5PSDEUAGroupId()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getNO5PSDEUAGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no5psdeuagroupname", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getNO5PSDEUAGroupName()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getNO6PSDEUAGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no6psdeuagroupid", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getNO6PSDEUAGroupId()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getNO6PSDEUAGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no6psdeuagroupname", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getNO6PSDEUAGroupName()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPadding() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"padding", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPadding()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPredefinedType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"predefinedtype", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPredefinedType()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPredefinedTypeText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"predefinedtypetext", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPredefinedTypeText()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSACHandlerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psachandlerid", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSACHandlerId()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSACHandlerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psachandlername", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSACHandlerName()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSCtrlId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrlid", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSCtrlId()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSCtrlLogicGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrllogicgroupid", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSCtrlLogicGroupId()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSCtrlLogicGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrllogicgroupname", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSCtrlLogicGroupName()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSCtrlMsgId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrlmsgid", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSCtrlMsgId()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSCtrlMsgName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrlmsgname", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSCtrlMsgName()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSCtrlName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrlname", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSCtrlName()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionid", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSDEActionId()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionname", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSDEActionName()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSDEChartId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdechartid", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSDEChartId()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSDEChartName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdechartname", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSDEChartName()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSDEDataExpId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedataexpid", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSDEDataExpId()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSDEDataExpName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedataexpname", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSDEDataExpName()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSDEDataImpId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedataimpid", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSDEDataImpId()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSDEDataImpName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedataimpname", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSDEDataImpName()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSDEDataSetId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedatasetid", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSDEDataSetId()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSDEDataSetName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedatasetname", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSDEDataSetName()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSDEDataViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedataviewid", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSDEDataViewId()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSDEDataViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedataviewname", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSDEDataViewName()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSDEDRId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedrid", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSDEDRId()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSDEDRName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedrname", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSDEDRName()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSDEFormId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformid", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSDEFormId()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSDEFormName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformname", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSDEFormName()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSDEGridId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdegridid", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSDEGridId()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSDEGridName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdegridname", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSDEGridName()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSDEListId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelistid", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSDEListId()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSDEListName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelistname", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSDEListName()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSDEOPPrivId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeopprivid", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSDEOPPrivId()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSDEOPPrivName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeopprivname", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSDEOPPrivName()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSDEReportId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdereportid", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSDEReportId()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSDEReportName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdereportname", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSDEReportName()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSDEToolbarId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetoolbarid", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSDEToolbarId()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSDEToolbarName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetoolbarname", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSDEToolbarName()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSDETreeViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetreeviewid", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSDETreeViewId()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSDETreeViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetreeviewname", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSDETreeViewName()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSDEUAGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuagroupid", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSDEUAGroupId()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSDEUAGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuagroupname", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSDEUAGroupName()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSDEViewBaseId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbaseid", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSDEViewBaseId()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSDEViewBaseName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbasename", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSDEViewBaseName()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSDEViewCtrlId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewctrlid", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSDEViewCtrlId()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSDEViewCtrlName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewctrlname", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSDEViewCtrlName()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSDEViewCtrlType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewctrltype", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSDEViewCtrlType()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewid", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSDEViewId()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewname", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSDEViewName()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSDEWizardId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdewizardid", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSDEWizardId()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSDEWizardName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdewizardname", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSDEWizardName()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSPFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfid", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSPFId()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSPFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfname", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSPFName()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSSysCalendarId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscalendarid", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSSysCalendarId()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSSysCalendarName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscalendarname", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSSysCalendarName()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSSysCounterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscounterid", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSSysCounterId()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSSysCounterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscountername", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSSysCounterName()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssid", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSSysCssId()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssname", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSSysCssName()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSSysDashboardId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdashboardid", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSSysDashboardId()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSSysDashboardName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdashboardname", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSSysDashboardName()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSSysImageId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimageid", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSSysImageId()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSSysImageName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimagename", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSSysImageName()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSSysMapViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmapviewid", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSSysMapViewId()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSSysMapViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmapviewname", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSSysMapViewName()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSSysMsgTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmsgtemplid", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSSysMsgTemplId()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSSysMsgTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmsgtemplname", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSSysMsgTemplName()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSSysSearchBarId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssearchbarid", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSSysSearchBarId()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSSysSearchBarName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssearchbarname", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSSysSearchBarName()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSSysViewPanelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelid", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSSysViewPanelId()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getPSSysViewPanelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelname", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getPSSysViewPanelName()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getReadOnlyMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"readonlymode", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getReadOnlyMode()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getRefCtrl2Name() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refctrl2name", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getRefCtrl2Name()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getRefCtrl2Usage() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refctrl2usage", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getRefCtrl2Usage()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getRefCtrl2UsageText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refctrl2usagetext", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getRefCtrl2UsageText()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getRefCtrlName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refctrlname", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getRefCtrlName()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getRefCtrlUsage() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refctrlusage", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getRefCtrlUsage()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getRefCtrlUsageText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refctrlusagetext", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getRefCtrlUsageText()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getRightPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rightpos", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getRightPos()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getSubPSACHandlerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"subpsachandlerid", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getSubPSACHandlerId()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getSubPSACHandlerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"subpsachandlername", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getSubPSACHandlerName()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getTopPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"toppos", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getTopPos()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSDEViewCtrlBase.getWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"width", (Object)PSDEViewCtrlBase.getJSONValue((Object)pSDEViewCtrlBase.getWidth()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEViewCtrlBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEViewCtrlBase pSDEViewCtrlBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEViewCtrlBase.getADPSDELogicId() != null) {
            object = pSDEViewCtrlBase.getADPSDELogicId();
            xmlNode.setAttribute(FIELD_ADPSDELOGICID, (String)(object == null ? "" : object));
        }
        if (bl || pSDEViewCtrlBase.getADPSDELogicName() != null) {
            object = pSDEViewCtrlBase.getADPSDELogicName();
            xmlNode.setAttribute(FIELD_ADPSDELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getBottomPos() != null) {
            object = pSDEViewCtrlBase.getBottomPos();
            xmlNode.setAttribute(FIELD_BOTTOMPOS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewCtrlBase.getBtnActionType() != null) {
            object = pSDEViewCtrlBase.getBtnActionType();
            xmlNode.setAttribute(FIELD_BTNACTIONTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getBusyIndicator() != null) {
            object = pSDEViewCtrlBase.getBusyIndicator();
            xmlNode.setAttribute(FIELD_BUSYINDICATOR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewCtrlBase.getCapPSLanResId() != null) {
            object = pSDEViewCtrlBase.getCapPSLanResId();
            xmlNode.setAttribute(FIELD_CAPPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getCapPSLanResName() != null) {
            object = pSDEViewCtrlBase.getCapPSLanResName();
            xmlNode.setAttribute(FIELD_CAPPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getCaption() != null) {
            object = pSDEViewCtrlBase.getCaption();
            xmlNode.setAttribute(FIELD_CAPTION, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getConfigInfo() != null) {
            object = pSDEViewCtrlBase.getConfigInfo();
            xmlNode.setAttribute(FIELD_CONFIGINFO, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getCreateDate() != null) {
            object = pSDEViewCtrlBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEViewCtrlBase.getCreateMan() != null) {
            object = pSDEViewCtrlBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getCtrlParam() != null) {
            object = pSDEViewCtrlBase.getCtrlParam();
            xmlNode.setAttribute(FIELD_CTRLPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getCtrlParam10() != null) {
            object = pSDEViewCtrlBase.getCtrlParam10();
            xmlNode.setAttribute(FIELD_CTRLPARAM10, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewCtrlBase.getCtrlParam11() != null) {
            object = pSDEViewCtrlBase.getCtrlParam11();
            xmlNode.setAttribute(FIELD_CTRLPARAM11, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewCtrlBase.getCtrlParam12() != null) {
            object = pSDEViewCtrlBase.getCtrlParam12();
            xmlNode.setAttribute(FIELD_CTRLPARAM12, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewCtrlBase.getCtrlParam2() != null) {
            object = pSDEViewCtrlBase.getCtrlParam2();
            xmlNode.setAttribute(FIELD_CTRLPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getCtrlParam3() != null) {
            object = pSDEViewCtrlBase.getCtrlParam3();
            xmlNode.setAttribute(FIELD_CTRLPARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getCtrlParam4() != null) {
            object = pSDEViewCtrlBase.getCtrlParam4();
            xmlNode.setAttribute(FIELD_CTRLPARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getCtrlParam5() != null) {
            object = pSDEViewCtrlBase.getCtrlParam5();
            xmlNode.setAttribute(FIELD_CTRLPARAM5, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewCtrlBase.getCtrlParam6() != null) {
            object = pSDEViewCtrlBase.getCtrlParam6();
            xmlNode.setAttribute(FIELD_CTRLPARAM6, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewCtrlBase.getCtrlParam7() != null) {
            object = pSDEViewCtrlBase.getCtrlParam7();
            xmlNode.setAttribute(FIELD_CTRLPARAM7, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewCtrlBase.getCtrlParam8() != null) {
            object = pSDEViewCtrlBase.getCtrlParam8();
            xmlNode.setAttribute(FIELD_CTRLPARAM8, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewCtrlBase.getCtrlParam9() != null) {
            object = pSDEViewCtrlBase.getCtrlParam9();
            xmlNode.setAttribute(FIELD_CTRLPARAM9, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewCtrlBase.getCtrlParams() != null) {
            object = pSDEViewCtrlBase.getCtrlParams();
            xmlNode.setAttribute(FIELD_CTRLPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getCustomCond() != null) {
            object = pSDEViewCtrlBase.getCustomCond();
            xmlNode.setAttribute(FIELD_CUSTOMCOND, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getCustomType() != null) {
            object = pSDEViewCtrlBase.getCustomType();
            xmlNode.setAttribute(FIELD_CUSTOMTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getDefaultFlag() != null) {
            object = pSDEViewCtrlBase.getDefaultFlag();
            xmlNode.setAttribute(FIELD_DEFAULTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewCtrlBase.getDynaModelFlag() != null) {
            object = pSDEViewCtrlBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewCtrlBase.getDyncMode() != null) {
            object = pSDEViewCtrlBase.getDyncMode();
            xmlNode.setAttribute(FIELD_DYNCMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewCtrlBase.getEnableDynaSys() != null) {
            object = pSDEViewCtrlBase.getEnableDynaSys();
            xmlNode.setAttribute(FIELD_ENABLEDYNASYS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewCtrlBase.getEnableItemPriv() != null) {
            object = pSDEViewCtrlBase.getEnableItemPriv();
            xmlNode.setAttribute(FIELD_ENABLEITEMPRIV, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewCtrlBase.getEnableViewActions() != null) {
            object = pSDEViewCtrlBase.getEnableViewActions();
            xmlNode.setAttribute(FIELD_ENABLEVIEWACTIONS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewCtrlBase.getHeight() != null) {
            object = pSDEViewCtrlBase.getHeight();
            xmlNode.setAttribute(FIELD_HEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewCtrlBase.getInsertPos() != null) {
            object = pSDEViewCtrlBase.getInsertPos();
            xmlNode.setAttribute(FIELD_INSERTPOS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewCtrlBase.getLeftPos() != null) {
            object = pSDEViewCtrlBase.getLeftPos();
            xmlNode.setAttribute(FIELD_LEFTPOS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewCtrlBase.getLocalMode() != null) {
            object = pSDEViewCtrlBase.getLocalMode();
            xmlNode.setAttribute(FIELD_LOCALMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewCtrlBase.getMargin() != null) {
            object = pSDEViewCtrlBase.getMargin();
            xmlNode.setAttribute(FIELD_MARGIN, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getMemo() != null) {
            object = pSDEViewCtrlBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getMultiSelect() != null) {
            object = pSDEViewCtrlBase.getMultiSelect();
            xmlNode.setAttribute(FIELD_MULTISELECT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewCtrlBase.getNO2PSDEUAGroupId() != null) {
            object = pSDEViewCtrlBase.getNO2PSDEUAGroupId();
            xmlNode.setAttribute(FIELD_NO2PSDEUAGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getNO2PSDEUAGroupName() != null) {
            object = pSDEViewCtrlBase.getNO2PSDEUAGroupName();
            xmlNode.setAttribute(FIELD_NO2PSDEUAGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getNO3PSDEUAGroupId() != null) {
            object = pSDEViewCtrlBase.getNO3PSDEUAGroupId();
            xmlNode.setAttribute(FIELD_NO3PSDEUAGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getNO3PSDEUAGroupName() != null) {
            object = pSDEViewCtrlBase.getNO3PSDEUAGroupName();
            xmlNode.setAttribute(FIELD_NO3PSDEUAGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getNO4PSDEUAGroupId() != null) {
            object = pSDEViewCtrlBase.getNO4PSDEUAGroupId();
            xmlNode.setAttribute(FIELD_NO4PSDEUAGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getNO4PSDEUAGroupName() != null) {
            object = pSDEViewCtrlBase.getNO4PSDEUAGroupName();
            xmlNode.setAttribute(FIELD_NO4PSDEUAGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getNO5PSDEUAGroupId() != null) {
            object = pSDEViewCtrlBase.getNO5PSDEUAGroupId();
            xmlNode.setAttribute(FIELD_NO5PSDEUAGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getNO5PSDEUAGroupName() != null) {
            object = pSDEViewCtrlBase.getNO5PSDEUAGroupName();
            xmlNode.setAttribute(FIELD_NO5PSDEUAGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getNO6PSDEUAGroupId() != null) {
            object = pSDEViewCtrlBase.getNO6PSDEUAGroupId();
            xmlNode.setAttribute(FIELD_NO6PSDEUAGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getNO6PSDEUAGroupName() != null) {
            object = pSDEViewCtrlBase.getNO6PSDEUAGroupName();
            xmlNode.setAttribute(FIELD_NO6PSDEUAGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getOrderValue() != null) {
            object = pSDEViewCtrlBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewCtrlBase.getPadding() != null) {
            object = pSDEViewCtrlBase.getPadding();
            xmlNode.setAttribute(FIELD_PADDING, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPredefinedType() != null) {
            object = pSDEViewCtrlBase.getPredefinedType();
            xmlNode.setAttribute(FIELD_PREDEFINEDTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPredefinedTypeText() != null) {
            object = pSDEViewCtrlBase.getPredefinedTypeText();
            xmlNode.setAttribute(FIELD_PREDEFINEDTYPETEXT, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSACHandlerId() != null) {
            object = pSDEViewCtrlBase.getPSACHandlerId();
            xmlNode.setAttribute(FIELD_PSACHANDLERID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSACHandlerName() != null) {
            object = pSDEViewCtrlBase.getPSACHandlerName();
            xmlNode.setAttribute(FIELD_PSACHANDLERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSCtrlId() != null) {
            object = pSDEViewCtrlBase.getPSCtrlId();
            xmlNode.setAttribute(FIELD_PSCTRLID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSCtrlLogicGroupId() != null) {
            object = pSDEViewCtrlBase.getPSCtrlLogicGroupId();
            xmlNode.setAttribute(FIELD_PSCTRLLOGICGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSCtrlLogicGroupName() != null) {
            object = pSDEViewCtrlBase.getPSCtrlLogicGroupName();
            xmlNode.setAttribute(FIELD_PSCTRLLOGICGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSCtrlMsgId() != null) {
            object = pSDEViewCtrlBase.getPSCtrlMsgId();
            xmlNode.setAttribute(FIELD_PSCTRLMSGID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSCtrlMsgName() != null) {
            object = pSDEViewCtrlBase.getPSCtrlMsgName();
            xmlNode.setAttribute(FIELD_PSCTRLMSGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSCtrlName() != null) {
            object = pSDEViewCtrlBase.getPSCtrlName();
            xmlNode.setAttribute(FIELD_PSCTRLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSDEActionId() != null) {
            object = pSDEViewCtrlBase.getPSDEActionId();
            xmlNode.setAttribute(FIELD_PSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSDEActionName() != null) {
            object = pSDEViewCtrlBase.getPSDEActionName();
            xmlNode.setAttribute(FIELD_PSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSDEChartId() != null) {
            object = pSDEViewCtrlBase.getPSDEChartId();
            xmlNode.setAttribute(FIELD_PSDECHARTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSDEChartName() != null) {
            object = pSDEViewCtrlBase.getPSDEChartName();
            xmlNode.setAttribute(FIELD_PSDECHARTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSDEDataExpId() != null) {
            object = pSDEViewCtrlBase.getPSDEDataExpId();
            xmlNode.setAttribute(FIELD_PSDEDATAEXPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSDEDataExpName() != null) {
            object = pSDEViewCtrlBase.getPSDEDataExpName();
            xmlNode.setAttribute(FIELD_PSDEDATAEXPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSDEDataImpId() != null) {
            object = pSDEViewCtrlBase.getPSDEDataImpId();
            xmlNode.setAttribute(FIELD_PSDEDATAIMPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSDEDataImpName() != null) {
            object = pSDEViewCtrlBase.getPSDEDataImpName();
            xmlNode.setAttribute(FIELD_PSDEDATAIMPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSDEDataSetId() != null) {
            object = pSDEViewCtrlBase.getPSDEDataSetId();
            xmlNode.setAttribute(FIELD_PSDEDATASETID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSDEDataSetName() != null) {
            object = pSDEViewCtrlBase.getPSDEDataSetName();
            xmlNode.setAttribute(FIELD_PSDEDATASETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSDEDataViewId() != null) {
            object = pSDEViewCtrlBase.getPSDEDataViewId();
            xmlNode.setAttribute(FIELD_PSDEDATAVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSDEDataViewName() != null) {
            object = pSDEViewCtrlBase.getPSDEDataViewName();
            xmlNode.setAttribute(FIELD_PSDEDATAVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSDEDRId() != null) {
            object = pSDEViewCtrlBase.getPSDEDRId();
            xmlNode.setAttribute(FIELD_PSDEDRID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSDEDRName() != null) {
            object = pSDEViewCtrlBase.getPSDEDRName();
            xmlNode.setAttribute(FIELD_PSDEDRNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSDEFormId() != null) {
            object = pSDEViewCtrlBase.getPSDEFormId();
            xmlNode.setAttribute(FIELD_PSDEFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSDEFormName() != null) {
            object = pSDEViewCtrlBase.getPSDEFormName();
            xmlNode.setAttribute(FIELD_PSDEFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSDEGridId() != null) {
            object = pSDEViewCtrlBase.getPSDEGridId();
            xmlNode.setAttribute(FIELD_PSDEGRIDID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSDEGridName() != null) {
            object = pSDEViewCtrlBase.getPSDEGridName();
            xmlNode.setAttribute(FIELD_PSDEGRIDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSDEId() != null) {
            object = pSDEViewCtrlBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSDEListId() != null) {
            object = pSDEViewCtrlBase.getPSDEListId();
            xmlNode.setAttribute(FIELD_PSDELISTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSDEListName() != null) {
            object = pSDEViewCtrlBase.getPSDEListName();
            xmlNode.setAttribute(FIELD_PSDELISTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSDEName() != null) {
            object = pSDEViewCtrlBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSDEOPPrivId() != null) {
            object = pSDEViewCtrlBase.getPSDEOPPrivId();
            xmlNode.setAttribute(FIELD_PSDEOPPRIVID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSDEOPPrivName() != null) {
            object = pSDEViewCtrlBase.getPSDEOPPrivName();
            xmlNode.setAttribute(FIELD_PSDEOPPRIVNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSDEReportId() != null) {
            object = pSDEViewCtrlBase.getPSDEReportId();
            xmlNode.setAttribute(FIELD_PSDEREPORTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSDEReportName() != null) {
            object = pSDEViewCtrlBase.getPSDEReportName();
            xmlNode.setAttribute(FIELD_PSDEREPORTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSDEToolbarId() != null) {
            object = pSDEViewCtrlBase.getPSDEToolbarId();
            xmlNode.setAttribute(FIELD_PSDETOOLBARID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSDEToolbarName() != null) {
            object = pSDEViewCtrlBase.getPSDEToolbarName();
            xmlNode.setAttribute(FIELD_PSDETOOLBARNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSDETreeViewId() != null) {
            object = pSDEViewCtrlBase.getPSDETreeViewId();
            xmlNode.setAttribute(FIELD_PSDETREEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSDETreeViewName() != null) {
            object = pSDEViewCtrlBase.getPSDETreeViewName();
            xmlNode.setAttribute(FIELD_PSDETREEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSDEUAGroupId() != null) {
            object = pSDEViewCtrlBase.getPSDEUAGroupId();
            xmlNode.setAttribute(FIELD_PSDEUAGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSDEUAGroupName() != null) {
            object = pSDEViewCtrlBase.getPSDEUAGroupName();
            xmlNode.setAttribute(FIELD_PSDEUAGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSDEViewBaseId() != null) {
            object = pSDEViewCtrlBase.getPSDEViewBaseId();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSDEViewBaseName() != null) {
            object = pSDEViewCtrlBase.getPSDEViewBaseName();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSDEViewCtrlId() != null) {
            object = pSDEViewCtrlBase.getPSDEViewCtrlId();
            xmlNode.setAttribute(FIELD_PSDEVIEWCTRLID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSDEViewCtrlName() != null) {
            object = pSDEViewCtrlBase.getPSDEViewCtrlName();
            xmlNode.setAttribute(FIELD_PSDEVIEWCTRLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSDEViewCtrlType() != null) {
            object = pSDEViewCtrlBase.getPSDEViewCtrlType();
            xmlNode.setAttribute(FIELD_PSDEVIEWCTRLTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSDEViewId() != null) {
            object = pSDEViewCtrlBase.getPSDEViewId();
            xmlNode.setAttribute(FIELD_PSDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSDEViewName() != null) {
            object = pSDEViewCtrlBase.getPSDEViewName();
            xmlNode.setAttribute(FIELD_PSDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSDEWizardId() != null) {
            object = pSDEViewCtrlBase.getPSDEWizardId();
            xmlNode.setAttribute(FIELD_PSDEWIZARDID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSDEWizardName() != null) {
            object = pSDEViewCtrlBase.getPSDEWizardName();
            xmlNode.setAttribute(FIELD_PSDEWIZARDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSDynaInstId() != null) {
            object = pSDEViewCtrlBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSPFId() != null) {
            object = pSDEViewCtrlBase.getPSPFId();
            xmlNode.setAttribute(FIELD_PSPFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSPFName() != null) {
            object = pSDEViewCtrlBase.getPSPFName();
            xmlNode.setAttribute(FIELD_PSPFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSSysCalendarId() != null) {
            object = pSDEViewCtrlBase.getPSSysCalendarId();
            xmlNode.setAttribute(FIELD_PSSYSCALENDARID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSSysCalendarName() != null) {
            object = pSDEViewCtrlBase.getPSSysCalendarName();
            xmlNode.setAttribute(FIELD_PSSYSCALENDARNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSSysCounterId() != null) {
            object = pSDEViewCtrlBase.getPSSysCounterId();
            xmlNode.setAttribute(FIELD_PSSYSCOUNTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSSysCounterName() != null) {
            object = pSDEViewCtrlBase.getPSSysCounterName();
            xmlNode.setAttribute(FIELD_PSSYSCOUNTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSSysCssId() != null) {
            object = pSDEViewCtrlBase.getPSSysCssId();
            xmlNode.setAttribute(FIELD_PSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSSysCssName() != null) {
            object = pSDEViewCtrlBase.getPSSysCssName();
            xmlNode.setAttribute(FIELD_PSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSSysDashboardId() != null) {
            object = pSDEViewCtrlBase.getPSSysDashboardId();
            xmlNode.setAttribute(FIELD_PSSYSDASHBOARDID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSSysDashboardName() != null) {
            object = pSDEViewCtrlBase.getPSSysDashboardName();
            xmlNode.setAttribute(FIELD_PSSYSDASHBOARDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSSysDynaModelId() != null) {
            object = pSDEViewCtrlBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSSysDynaModelName() != null) {
            object = pSDEViewCtrlBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSSysImageId() != null) {
            object = pSDEViewCtrlBase.getPSSysImageId();
            xmlNode.setAttribute(FIELD_PSSYSIMAGEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSSysImageName() != null) {
            object = pSDEViewCtrlBase.getPSSysImageName();
            xmlNode.setAttribute(FIELD_PSSYSIMAGENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSSysMapViewId() != null) {
            object = pSDEViewCtrlBase.getPSSysMapViewId();
            xmlNode.setAttribute(FIELD_PSSYSMAPVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSSysMapViewName() != null) {
            object = pSDEViewCtrlBase.getPSSysMapViewName();
            xmlNode.setAttribute(FIELD_PSSYSMAPVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSSysMsgTemplId() != null) {
            object = pSDEViewCtrlBase.getPSSysMsgTemplId();
            xmlNode.setAttribute(FIELD_PSSYSMSGTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSSysMsgTemplName() != null) {
            object = pSDEViewCtrlBase.getPSSysMsgTemplName();
            xmlNode.setAttribute(FIELD_PSSYSMSGTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSSysPFPluginId() != null) {
            object = pSDEViewCtrlBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSSysPFPluginName() != null) {
            object = pSDEViewCtrlBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSSysSearchBarId() != null) {
            object = pSDEViewCtrlBase.getPSSysSearchBarId();
            xmlNode.setAttribute(FIELD_PSSYSSEARCHBARID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSSysSearchBarName() != null) {
            object = pSDEViewCtrlBase.getPSSysSearchBarName();
            xmlNode.setAttribute(FIELD_PSSYSSEARCHBARNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSSystemId() != null) {
            object = pSDEViewCtrlBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSSysViewPanelId() != null) {
            object = pSDEViewCtrlBase.getPSSysViewPanelId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getPSSysViewPanelName() != null) {
            object = pSDEViewCtrlBase.getPSSysViewPanelName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getReadOnlyMode() != null) {
            object = pSDEViewCtrlBase.getReadOnlyMode();
            xmlNode.setAttribute(FIELD_READONLYMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewCtrlBase.getRefCtrl2Name() != null) {
            object = pSDEViewCtrlBase.getRefCtrl2Name();
            xmlNode.setAttribute(FIELD_REFCTRL2NAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getRefCtrl2Usage() != null) {
            object = pSDEViewCtrlBase.getRefCtrl2Usage();
            xmlNode.setAttribute(FIELD_REFCTRL2USAGE, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getRefCtrl2UsageText() != null) {
            object = pSDEViewCtrlBase.getRefCtrl2UsageText();
            xmlNode.setAttribute(FIELD_REFCTRL2USAGETEXT, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getRefCtrlName() != null) {
            object = pSDEViewCtrlBase.getRefCtrlName();
            xmlNode.setAttribute(FIELD_REFCTRLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getRefCtrlUsage() != null) {
            object = pSDEViewCtrlBase.getRefCtrlUsage();
            xmlNode.setAttribute(FIELD_REFCTRLUSAGE, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getRefCtrlUsageText() != null) {
            object = pSDEViewCtrlBase.getRefCtrlUsageText();
            xmlNode.setAttribute(FIELD_REFCTRLUSAGETEXT, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getRightPos() != null) {
            object = pSDEViewCtrlBase.getRightPos();
            xmlNode.setAttribute(FIELD_RIGHTPOS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewCtrlBase.getSubPSACHandlerId() != null) {
            object = pSDEViewCtrlBase.getSubPSACHandlerId();
            xmlNode.setAttribute(FIELD_SUBPSACHANDLERID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getSubPSACHandlerName() != null) {
            object = pSDEViewCtrlBase.getSubPSACHandlerName();
            xmlNode.setAttribute(FIELD_SUBPSACHANDLERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getTopPos() != null) {
            object = pSDEViewCtrlBase.getTopPos();
            xmlNode.setAttribute(FIELD_TOPPOS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewCtrlBase.getUpdateDate() != null) {
            object = pSDEViewCtrlBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEViewCtrlBase.getUpdateMan() != null) {
            object = pSDEViewCtrlBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getUserTag() != null) {
            object = pSDEViewCtrlBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getUserTag2() != null) {
            object = pSDEViewCtrlBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlBase.getValidFlag() != null) {
            object = pSDEViewCtrlBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewCtrlBase.getWidth() != null) {
            object = pSDEViewCtrlBase.getWidth();
            xmlNode.setAttribute(FIELD_WIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEViewCtrlBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEViewCtrlBase pSDEViewCtrlBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEViewCtrlBase.isADPSDELogicIdDirty() && (bl || pSDEViewCtrlBase.getADPSDELogicId() != null)) {
            iDataObject.set(FIELD_ADPSDELOGICID, (Object)pSDEViewCtrlBase.getADPSDELogicId());
        }
        if (pSDEViewCtrlBase.isADPSDELogicNameDirty() && (bl || pSDEViewCtrlBase.getADPSDELogicName() != null)) {
            iDataObject.set(FIELD_ADPSDELOGICNAME, (Object)pSDEViewCtrlBase.getADPSDELogicName());
        }
        if (pSDEViewCtrlBase.isBottomPosDirty() && (bl || pSDEViewCtrlBase.getBottomPos() != null)) {
            iDataObject.set(FIELD_BOTTOMPOS, (Object)pSDEViewCtrlBase.getBottomPos());
        }
        if (pSDEViewCtrlBase.isBtnActionTypeDirty() && (bl || pSDEViewCtrlBase.getBtnActionType() != null)) {
            iDataObject.set(FIELD_BTNACTIONTYPE, (Object)pSDEViewCtrlBase.getBtnActionType());
        }
        if (pSDEViewCtrlBase.isBusyIndicatorDirty() && (bl || pSDEViewCtrlBase.getBusyIndicator() != null)) {
            iDataObject.set(FIELD_BUSYINDICATOR, (Object)pSDEViewCtrlBase.getBusyIndicator());
        }
        if (pSDEViewCtrlBase.isCapPSLanResIdDirty() && (bl || pSDEViewCtrlBase.getCapPSLanResId() != null)) {
            iDataObject.set(FIELD_CAPPSLANRESID, (Object)pSDEViewCtrlBase.getCapPSLanResId());
        }
        if (pSDEViewCtrlBase.isCapPSLanResNameDirty() && (bl || pSDEViewCtrlBase.getCapPSLanResName() != null)) {
            iDataObject.set(FIELD_CAPPSLANRESNAME, (Object)pSDEViewCtrlBase.getCapPSLanResName());
        }
        if (pSDEViewCtrlBase.isCaptionDirty() && (bl || pSDEViewCtrlBase.getCaption() != null)) {
            iDataObject.set(FIELD_CAPTION, (Object)pSDEViewCtrlBase.getCaption());
        }
        if (pSDEViewCtrlBase.isConfigInfoDirty() && (bl || pSDEViewCtrlBase.getConfigInfo() != null)) {
            iDataObject.set(FIELD_CONFIGINFO, (Object)pSDEViewCtrlBase.getConfigInfo());
        }
        if (pSDEViewCtrlBase.isCreateDateDirty() && (bl || pSDEViewCtrlBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEViewCtrlBase.getCreateDate());
        }
        if (pSDEViewCtrlBase.isCreateManDirty() && (bl || pSDEViewCtrlBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEViewCtrlBase.getCreateMan());
        }
        if (pSDEViewCtrlBase.isCtrlParamDirty() && (bl || pSDEViewCtrlBase.getCtrlParam() != null)) {
            iDataObject.set(FIELD_CTRLPARAM, (Object)pSDEViewCtrlBase.getCtrlParam());
        }
        if (pSDEViewCtrlBase.isCtrlParam10Dirty() && (bl || pSDEViewCtrlBase.getCtrlParam10() != null)) {
            iDataObject.set(FIELD_CTRLPARAM10, (Object)pSDEViewCtrlBase.getCtrlParam10());
        }
        if (pSDEViewCtrlBase.isCtrlParam11Dirty() && (bl || pSDEViewCtrlBase.getCtrlParam11() != null)) {
            iDataObject.set(FIELD_CTRLPARAM11, (Object)pSDEViewCtrlBase.getCtrlParam11());
        }
        if (pSDEViewCtrlBase.isCtrlParam12Dirty() && (bl || pSDEViewCtrlBase.getCtrlParam12() != null)) {
            iDataObject.set(FIELD_CTRLPARAM12, (Object)pSDEViewCtrlBase.getCtrlParam12());
        }
        if (pSDEViewCtrlBase.isCtrlParam2Dirty() && (bl || pSDEViewCtrlBase.getCtrlParam2() != null)) {
            iDataObject.set(FIELD_CTRLPARAM2, (Object)pSDEViewCtrlBase.getCtrlParam2());
        }
        if (pSDEViewCtrlBase.isCtrlParam3Dirty() && (bl || pSDEViewCtrlBase.getCtrlParam3() != null)) {
            iDataObject.set(FIELD_CTRLPARAM3, (Object)pSDEViewCtrlBase.getCtrlParam3());
        }
        if (pSDEViewCtrlBase.isCtrlParam4Dirty() && (bl || pSDEViewCtrlBase.getCtrlParam4() != null)) {
            iDataObject.set(FIELD_CTRLPARAM4, (Object)pSDEViewCtrlBase.getCtrlParam4());
        }
        if (pSDEViewCtrlBase.isCtrlParam5Dirty() && (bl || pSDEViewCtrlBase.getCtrlParam5() != null)) {
            iDataObject.set(FIELD_CTRLPARAM5, (Object)pSDEViewCtrlBase.getCtrlParam5());
        }
        if (pSDEViewCtrlBase.isCtrlParam6Dirty() && (bl || pSDEViewCtrlBase.getCtrlParam6() != null)) {
            iDataObject.set(FIELD_CTRLPARAM6, (Object)pSDEViewCtrlBase.getCtrlParam6());
        }
        if (pSDEViewCtrlBase.isCtrlParam7Dirty() && (bl || pSDEViewCtrlBase.getCtrlParam7() != null)) {
            iDataObject.set(FIELD_CTRLPARAM7, (Object)pSDEViewCtrlBase.getCtrlParam7());
        }
        if (pSDEViewCtrlBase.isCtrlParam8Dirty() && (bl || pSDEViewCtrlBase.getCtrlParam8() != null)) {
            iDataObject.set(FIELD_CTRLPARAM8, (Object)pSDEViewCtrlBase.getCtrlParam8());
        }
        if (pSDEViewCtrlBase.isCtrlParam9Dirty() && (bl || pSDEViewCtrlBase.getCtrlParam9() != null)) {
            iDataObject.set(FIELD_CTRLPARAM9, (Object)pSDEViewCtrlBase.getCtrlParam9());
        }
        if (pSDEViewCtrlBase.isCtrlParamsDirty() && (bl || pSDEViewCtrlBase.getCtrlParams() != null)) {
            iDataObject.set(FIELD_CTRLPARAMS, (Object)pSDEViewCtrlBase.getCtrlParams());
        }
        if (pSDEViewCtrlBase.isCustomCondDirty() && (bl || pSDEViewCtrlBase.getCustomCond() != null)) {
            iDataObject.set(FIELD_CUSTOMCOND, (Object)pSDEViewCtrlBase.getCustomCond());
        }
        if (pSDEViewCtrlBase.isCustomTypeDirty() && (bl || pSDEViewCtrlBase.getCustomType() != null)) {
            iDataObject.set(FIELD_CUSTOMTYPE, (Object)pSDEViewCtrlBase.getCustomType());
        }
        if (pSDEViewCtrlBase.isDefaultFlagDirty() && (bl || pSDEViewCtrlBase.getDefaultFlag() != null)) {
            iDataObject.set(FIELD_DEFAULTFLAG, (Object)pSDEViewCtrlBase.getDefaultFlag());
        }
        if (pSDEViewCtrlBase.isDynaModelFlagDirty() && (bl || pSDEViewCtrlBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSDEViewCtrlBase.getDynaModelFlag());
        }
        if (pSDEViewCtrlBase.isDyncModeDirty() && (bl || pSDEViewCtrlBase.getDyncMode() != null)) {
            iDataObject.set(FIELD_DYNCMODE, (Object)pSDEViewCtrlBase.getDyncMode());
        }
        if (pSDEViewCtrlBase.isEnableDynaSysDirty() && (bl || pSDEViewCtrlBase.getEnableDynaSys() != null)) {
            iDataObject.set(FIELD_ENABLEDYNASYS, (Object)pSDEViewCtrlBase.getEnableDynaSys());
        }
        if (pSDEViewCtrlBase.isEnableItemPrivDirty() && (bl || pSDEViewCtrlBase.getEnableItemPriv() != null)) {
            iDataObject.set(FIELD_ENABLEITEMPRIV, (Object)pSDEViewCtrlBase.getEnableItemPriv());
        }
        if (pSDEViewCtrlBase.isEnableViewActionsDirty() && (bl || pSDEViewCtrlBase.getEnableViewActions() != null)) {
            iDataObject.set(FIELD_ENABLEVIEWACTIONS, (Object)pSDEViewCtrlBase.getEnableViewActions());
        }
        if (pSDEViewCtrlBase.isHeightDirty() && (bl || pSDEViewCtrlBase.getHeight() != null)) {
            iDataObject.set(FIELD_HEIGHT, (Object)pSDEViewCtrlBase.getHeight());
        }
        if (pSDEViewCtrlBase.isInsertPosDirty() && (bl || pSDEViewCtrlBase.getInsertPos() != null)) {
            iDataObject.set(FIELD_INSERTPOS, (Object)pSDEViewCtrlBase.getInsertPos());
        }
        if (pSDEViewCtrlBase.isLeftPosDirty() && (bl || pSDEViewCtrlBase.getLeftPos() != null)) {
            iDataObject.set(FIELD_LEFTPOS, (Object)pSDEViewCtrlBase.getLeftPos());
        }
        if (pSDEViewCtrlBase.isLocalModeDirty() && (bl || pSDEViewCtrlBase.getLocalMode() != null)) {
            iDataObject.set(FIELD_LOCALMODE, (Object)pSDEViewCtrlBase.getLocalMode());
        }
        if (pSDEViewCtrlBase.isMarginDirty() && (bl || pSDEViewCtrlBase.getMargin() != null)) {
            iDataObject.set(FIELD_MARGIN, (Object)pSDEViewCtrlBase.getMargin());
        }
        if (pSDEViewCtrlBase.isMemoDirty() && (bl || pSDEViewCtrlBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEViewCtrlBase.getMemo());
        }
        if (pSDEViewCtrlBase.isMultiSelectDirty() && (bl || pSDEViewCtrlBase.getMultiSelect() != null)) {
            iDataObject.set(FIELD_MULTISELECT, (Object)pSDEViewCtrlBase.getMultiSelect());
        }
        if (pSDEViewCtrlBase.isNO2PSDEUAGroupIdDirty() && (bl || pSDEViewCtrlBase.getNO2PSDEUAGroupId() != null)) {
            iDataObject.set(FIELD_NO2PSDEUAGROUPID, (Object)pSDEViewCtrlBase.getNO2PSDEUAGroupId());
        }
        if (pSDEViewCtrlBase.isNO2PSDEUAGroupNameDirty() && (bl || pSDEViewCtrlBase.getNO2PSDEUAGroupName() != null)) {
            iDataObject.set(FIELD_NO2PSDEUAGROUPNAME, (Object)pSDEViewCtrlBase.getNO2PSDEUAGroupName());
        }
        if (pSDEViewCtrlBase.isNO3PSDEUAGroupIdDirty() && (bl || pSDEViewCtrlBase.getNO3PSDEUAGroupId() != null)) {
            iDataObject.set(FIELD_NO3PSDEUAGROUPID, (Object)pSDEViewCtrlBase.getNO3PSDEUAGroupId());
        }
        if (pSDEViewCtrlBase.isNO3PSDEUAGroupNameDirty() && (bl || pSDEViewCtrlBase.getNO3PSDEUAGroupName() != null)) {
            iDataObject.set(FIELD_NO3PSDEUAGROUPNAME, (Object)pSDEViewCtrlBase.getNO3PSDEUAGroupName());
        }
        if (pSDEViewCtrlBase.isNO4PSDEUAGroupIdDirty() && (bl || pSDEViewCtrlBase.getNO4PSDEUAGroupId() != null)) {
            iDataObject.set(FIELD_NO4PSDEUAGROUPID, (Object)pSDEViewCtrlBase.getNO4PSDEUAGroupId());
        }
        if (pSDEViewCtrlBase.isNO4PSDEUAGroupNameDirty() && (bl || pSDEViewCtrlBase.getNO4PSDEUAGroupName() != null)) {
            iDataObject.set(FIELD_NO4PSDEUAGROUPNAME, (Object)pSDEViewCtrlBase.getNO4PSDEUAGroupName());
        }
        if (pSDEViewCtrlBase.isNO5PSDEUAGroupIdDirty() && (bl || pSDEViewCtrlBase.getNO5PSDEUAGroupId() != null)) {
            iDataObject.set(FIELD_NO5PSDEUAGROUPID, (Object)pSDEViewCtrlBase.getNO5PSDEUAGroupId());
        }
        if (pSDEViewCtrlBase.isNO5PSDEUAGroupNameDirty() && (bl || pSDEViewCtrlBase.getNO5PSDEUAGroupName() != null)) {
            iDataObject.set(FIELD_NO5PSDEUAGROUPNAME, (Object)pSDEViewCtrlBase.getNO5PSDEUAGroupName());
        }
        if (pSDEViewCtrlBase.isNO6PSDEUAGroupIdDirty() && (bl || pSDEViewCtrlBase.getNO6PSDEUAGroupId() != null)) {
            iDataObject.set(FIELD_NO6PSDEUAGROUPID, (Object)pSDEViewCtrlBase.getNO6PSDEUAGroupId());
        }
        if (pSDEViewCtrlBase.isNO6PSDEUAGroupNameDirty() && (bl || pSDEViewCtrlBase.getNO6PSDEUAGroupName() != null)) {
            iDataObject.set(FIELD_NO6PSDEUAGROUPNAME, (Object)pSDEViewCtrlBase.getNO6PSDEUAGroupName());
        }
        if (pSDEViewCtrlBase.isOrderValueDirty() && (bl || pSDEViewCtrlBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEViewCtrlBase.getOrderValue());
        }
        if (pSDEViewCtrlBase.isPaddingDirty() && (bl || pSDEViewCtrlBase.getPadding() != null)) {
            iDataObject.set(FIELD_PADDING, (Object)pSDEViewCtrlBase.getPadding());
        }
        if (pSDEViewCtrlBase.isPredefinedTypeDirty() && (bl || pSDEViewCtrlBase.getPredefinedType() != null)) {
            iDataObject.set(FIELD_PREDEFINEDTYPE, (Object)pSDEViewCtrlBase.getPredefinedType());
        }
        if (pSDEViewCtrlBase.isPredefinedTypeTextDirty() && (bl || pSDEViewCtrlBase.getPredefinedTypeText() != null)) {
            iDataObject.set(FIELD_PREDEFINEDTYPETEXT, (Object)pSDEViewCtrlBase.getPredefinedTypeText());
        }
        if (pSDEViewCtrlBase.isPSACHandlerIdDirty() && (bl || pSDEViewCtrlBase.getPSACHandlerId() != null)) {
            iDataObject.set(FIELD_PSACHANDLERID, (Object)pSDEViewCtrlBase.getPSACHandlerId());
        }
        if (pSDEViewCtrlBase.isPSACHandlerNameDirty() && (bl || pSDEViewCtrlBase.getPSACHandlerName() != null)) {
            iDataObject.set(FIELD_PSACHANDLERNAME, (Object)pSDEViewCtrlBase.getPSACHandlerName());
        }
        if (pSDEViewCtrlBase.isPSCtrlIdDirty() && (bl || pSDEViewCtrlBase.getPSCtrlId() != null)) {
            iDataObject.set(FIELD_PSCTRLID, (Object)pSDEViewCtrlBase.getPSCtrlId());
        }
        if (pSDEViewCtrlBase.isPSCtrlLogicGroupIdDirty() && (bl || pSDEViewCtrlBase.getPSCtrlLogicGroupId() != null)) {
            iDataObject.set(FIELD_PSCTRLLOGICGROUPID, (Object)pSDEViewCtrlBase.getPSCtrlLogicGroupId());
        }
        if (pSDEViewCtrlBase.isPSCtrlLogicGroupNameDirty() && (bl || pSDEViewCtrlBase.getPSCtrlLogicGroupName() != null)) {
            iDataObject.set(FIELD_PSCTRLLOGICGROUPNAME, (Object)pSDEViewCtrlBase.getPSCtrlLogicGroupName());
        }
        if (pSDEViewCtrlBase.isPSCtrlMsgIdDirty() && (bl || pSDEViewCtrlBase.getPSCtrlMsgId() != null)) {
            iDataObject.set(FIELD_PSCTRLMSGID, (Object)pSDEViewCtrlBase.getPSCtrlMsgId());
        }
        if (pSDEViewCtrlBase.isPSCtrlMsgNameDirty() && (bl || pSDEViewCtrlBase.getPSCtrlMsgName() != null)) {
            iDataObject.set(FIELD_PSCTRLMSGNAME, (Object)pSDEViewCtrlBase.getPSCtrlMsgName());
        }
        if (pSDEViewCtrlBase.isPSCtrlNameDirty() && (bl || pSDEViewCtrlBase.getPSCtrlName() != null)) {
            iDataObject.set(FIELD_PSCTRLNAME, (Object)pSDEViewCtrlBase.getPSCtrlName());
        }
        if (pSDEViewCtrlBase.isPSDEActionIdDirty() && (bl || pSDEViewCtrlBase.getPSDEActionId() != null)) {
            iDataObject.set(FIELD_PSDEACTIONID, (Object)pSDEViewCtrlBase.getPSDEActionId());
        }
        if (pSDEViewCtrlBase.isPSDEActionNameDirty() && (bl || pSDEViewCtrlBase.getPSDEActionName() != null)) {
            iDataObject.set(FIELD_PSDEACTIONNAME, (Object)pSDEViewCtrlBase.getPSDEActionName());
        }
        if (pSDEViewCtrlBase.isPSDEChartIdDirty() && (bl || pSDEViewCtrlBase.getPSDEChartId() != null)) {
            iDataObject.set(FIELD_PSDECHARTID, (Object)pSDEViewCtrlBase.getPSDEChartId());
        }
        if (pSDEViewCtrlBase.isPSDEChartNameDirty() && (bl || pSDEViewCtrlBase.getPSDEChartName() != null)) {
            iDataObject.set(FIELD_PSDECHARTNAME, (Object)pSDEViewCtrlBase.getPSDEChartName());
        }
        if (pSDEViewCtrlBase.isPSDEDataExpIdDirty() && (bl || pSDEViewCtrlBase.getPSDEDataExpId() != null)) {
            iDataObject.set(FIELD_PSDEDATAEXPID, (Object)pSDEViewCtrlBase.getPSDEDataExpId());
        }
        if (pSDEViewCtrlBase.isPSDEDataExpNameDirty() && (bl || pSDEViewCtrlBase.getPSDEDataExpName() != null)) {
            iDataObject.set(FIELD_PSDEDATAEXPNAME, (Object)pSDEViewCtrlBase.getPSDEDataExpName());
        }
        if (pSDEViewCtrlBase.isPSDEDataImpIdDirty() && (bl || pSDEViewCtrlBase.getPSDEDataImpId() != null)) {
            iDataObject.set(FIELD_PSDEDATAIMPID, (Object)pSDEViewCtrlBase.getPSDEDataImpId());
        }
        if (pSDEViewCtrlBase.isPSDEDataImpNameDirty() && (bl || pSDEViewCtrlBase.getPSDEDataImpName() != null)) {
            iDataObject.set(FIELD_PSDEDATAIMPNAME, (Object)pSDEViewCtrlBase.getPSDEDataImpName());
        }
        if (pSDEViewCtrlBase.isPSDEDataSetIdDirty() && (bl || pSDEViewCtrlBase.getPSDEDataSetId() != null)) {
            iDataObject.set(FIELD_PSDEDATASETID, (Object)pSDEViewCtrlBase.getPSDEDataSetId());
        }
        if (pSDEViewCtrlBase.isPSDEDataSetNameDirty() && (bl || pSDEViewCtrlBase.getPSDEDataSetName() != null)) {
            iDataObject.set(FIELD_PSDEDATASETNAME, (Object)pSDEViewCtrlBase.getPSDEDataSetName());
        }
        if (pSDEViewCtrlBase.isPSDEDataViewIdDirty() && (bl || pSDEViewCtrlBase.getPSDEDataViewId() != null)) {
            iDataObject.set(FIELD_PSDEDATAVIEWID, (Object)pSDEViewCtrlBase.getPSDEDataViewId());
        }
        if (pSDEViewCtrlBase.isPSDEDataViewNameDirty() && (bl || pSDEViewCtrlBase.getPSDEDataViewName() != null)) {
            iDataObject.set(FIELD_PSDEDATAVIEWNAME, (Object)pSDEViewCtrlBase.getPSDEDataViewName());
        }
        if (pSDEViewCtrlBase.isPSDEDRIdDirty() && (bl || pSDEViewCtrlBase.getPSDEDRId() != null)) {
            iDataObject.set(FIELD_PSDEDRID, (Object)pSDEViewCtrlBase.getPSDEDRId());
        }
        if (pSDEViewCtrlBase.isPSDEDRNameDirty() && (bl || pSDEViewCtrlBase.getPSDEDRName() != null)) {
            iDataObject.set(FIELD_PSDEDRNAME, (Object)pSDEViewCtrlBase.getPSDEDRName());
        }
        if (pSDEViewCtrlBase.isPSDEFormIdDirty() && (bl || pSDEViewCtrlBase.getPSDEFormId() != null)) {
            iDataObject.set(FIELD_PSDEFORMID, (Object)pSDEViewCtrlBase.getPSDEFormId());
        }
        if (pSDEViewCtrlBase.isPSDEFormNameDirty() && (bl || pSDEViewCtrlBase.getPSDEFormName() != null)) {
            iDataObject.set(FIELD_PSDEFORMNAME, (Object)pSDEViewCtrlBase.getPSDEFormName());
        }
        if (pSDEViewCtrlBase.isPSDEGridIdDirty() && (bl || pSDEViewCtrlBase.getPSDEGridId() != null)) {
            iDataObject.set(FIELD_PSDEGRIDID, (Object)pSDEViewCtrlBase.getPSDEGridId());
        }
        if (pSDEViewCtrlBase.isPSDEGridNameDirty() && (bl || pSDEViewCtrlBase.getPSDEGridName() != null)) {
            iDataObject.set(FIELD_PSDEGRIDNAME, (Object)pSDEViewCtrlBase.getPSDEGridName());
        }
        if (pSDEViewCtrlBase.isPSDEIdDirty() && (bl || pSDEViewCtrlBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEViewCtrlBase.getPSDEId());
        }
        if (pSDEViewCtrlBase.isPSDEListIdDirty() && (bl || pSDEViewCtrlBase.getPSDEListId() != null)) {
            iDataObject.set(FIELD_PSDELISTID, (Object)pSDEViewCtrlBase.getPSDEListId());
        }
        if (pSDEViewCtrlBase.isPSDEListNameDirty() && (bl || pSDEViewCtrlBase.getPSDEListName() != null)) {
            iDataObject.set(FIELD_PSDELISTNAME, (Object)pSDEViewCtrlBase.getPSDEListName());
        }
        if (pSDEViewCtrlBase.isPSDENameDirty() && (bl || pSDEViewCtrlBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEViewCtrlBase.getPSDEName());
        }
        if (pSDEViewCtrlBase.isPSDEOPPrivIdDirty() && (bl || pSDEViewCtrlBase.getPSDEOPPrivId() != null)) {
            iDataObject.set(FIELD_PSDEOPPRIVID, (Object)pSDEViewCtrlBase.getPSDEOPPrivId());
        }
        if (pSDEViewCtrlBase.isPSDEOPPrivNameDirty() && (bl || pSDEViewCtrlBase.getPSDEOPPrivName() != null)) {
            iDataObject.set(FIELD_PSDEOPPRIVNAME, (Object)pSDEViewCtrlBase.getPSDEOPPrivName());
        }
        if (pSDEViewCtrlBase.isPSDEReportIdDirty() && (bl || pSDEViewCtrlBase.getPSDEReportId() != null)) {
            iDataObject.set(FIELD_PSDEREPORTID, (Object)pSDEViewCtrlBase.getPSDEReportId());
        }
        if (pSDEViewCtrlBase.isPSDEReportNameDirty() && (bl || pSDEViewCtrlBase.getPSDEReportName() != null)) {
            iDataObject.set(FIELD_PSDEREPORTNAME, (Object)pSDEViewCtrlBase.getPSDEReportName());
        }
        if (pSDEViewCtrlBase.isPSDEToolbarIdDirty() && (bl || pSDEViewCtrlBase.getPSDEToolbarId() != null)) {
            iDataObject.set(FIELD_PSDETOOLBARID, (Object)pSDEViewCtrlBase.getPSDEToolbarId());
        }
        if (pSDEViewCtrlBase.isPSDEToolbarNameDirty() && (bl || pSDEViewCtrlBase.getPSDEToolbarName() != null)) {
            iDataObject.set(FIELD_PSDETOOLBARNAME, (Object)pSDEViewCtrlBase.getPSDEToolbarName());
        }
        if (pSDEViewCtrlBase.isPSDETreeViewIdDirty() && (bl || pSDEViewCtrlBase.getPSDETreeViewId() != null)) {
            iDataObject.set(FIELD_PSDETREEVIEWID, (Object)pSDEViewCtrlBase.getPSDETreeViewId());
        }
        if (pSDEViewCtrlBase.isPSDETreeViewNameDirty() && (bl || pSDEViewCtrlBase.getPSDETreeViewName() != null)) {
            iDataObject.set(FIELD_PSDETREEVIEWNAME, (Object)pSDEViewCtrlBase.getPSDETreeViewName());
        }
        if (pSDEViewCtrlBase.isPSDEUAGroupIdDirty() && (bl || pSDEViewCtrlBase.getPSDEUAGroupId() != null)) {
            iDataObject.set(FIELD_PSDEUAGROUPID, (Object)pSDEViewCtrlBase.getPSDEUAGroupId());
        }
        if (pSDEViewCtrlBase.isPSDEUAGroupNameDirty() && (bl || pSDEViewCtrlBase.getPSDEUAGroupName() != null)) {
            iDataObject.set(FIELD_PSDEUAGROUPNAME, (Object)pSDEViewCtrlBase.getPSDEUAGroupName());
        }
        if (pSDEViewCtrlBase.isPSDEViewBaseIdDirty() && (bl || pSDEViewCtrlBase.getPSDEViewBaseId() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASEID, (Object)pSDEViewCtrlBase.getPSDEViewBaseId());
        }
        if (pSDEViewCtrlBase.isPSDEViewBaseNameDirty() && (bl || pSDEViewCtrlBase.getPSDEViewBaseName() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASENAME, (Object)pSDEViewCtrlBase.getPSDEViewBaseName());
        }
        if (pSDEViewCtrlBase.isPSDEViewCtrlIdDirty() && (bl || pSDEViewCtrlBase.getPSDEViewCtrlId() != null)) {
            iDataObject.set(FIELD_PSDEVIEWCTRLID, (Object)pSDEViewCtrlBase.getPSDEViewCtrlId());
        }
        if (pSDEViewCtrlBase.isPSDEViewCtrlNameDirty() && (bl || pSDEViewCtrlBase.getPSDEViewCtrlName() != null)) {
            iDataObject.set(FIELD_PSDEVIEWCTRLNAME, (Object)pSDEViewCtrlBase.getPSDEViewCtrlName());
        }
        if (pSDEViewCtrlBase.isPSDEViewCtrlTypeDirty() && (bl || pSDEViewCtrlBase.getPSDEViewCtrlType() != null)) {
            iDataObject.set(FIELD_PSDEVIEWCTRLTYPE, (Object)pSDEViewCtrlBase.getPSDEViewCtrlType());
        }
        if (pSDEViewCtrlBase.isPSDEViewIdDirty() && (bl || pSDEViewCtrlBase.getPSDEViewId() != null)) {
            iDataObject.set(FIELD_PSDEVIEWID, (Object)pSDEViewCtrlBase.getPSDEViewId());
        }
        if (pSDEViewCtrlBase.isPSDEViewNameDirty() && (bl || pSDEViewCtrlBase.getPSDEViewName() != null)) {
            iDataObject.set(FIELD_PSDEVIEWNAME, (Object)pSDEViewCtrlBase.getPSDEViewName());
        }
        if (pSDEViewCtrlBase.isPSDEWizardIdDirty() && (bl || pSDEViewCtrlBase.getPSDEWizardId() != null)) {
            iDataObject.set(FIELD_PSDEWIZARDID, (Object)pSDEViewCtrlBase.getPSDEWizardId());
        }
        if (pSDEViewCtrlBase.isPSDEWizardNameDirty() && (bl || pSDEViewCtrlBase.getPSDEWizardName() != null)) {
            iDataObject.set(FIELD_PSDEWIZARDNAME, (Object)pSDEViewCtrlBase.getPSDEWizardName());
        }
        if (pSDEViewCtrlBase.isPSDynaInstIdDirty() && (bl || pSDEViewCtrlBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSDEViewCtrlBase.getPSDynaInstId());
        }
        if (pSDEViewCtrlBase.isPSPFIdDirty() && (bl || pSDEViewCtrlBase.getPSPFId() != null)) {
            iDataObject.set(FIELD_PSPFID, (Object)pSDEViewCtrlBase.getPSPFId());
        }
        if (pSDEViewCtrlBase.isPSPFNameDirty() && (bl || pSDEViewCtrlBase.getPSPFName() != null)) {
            iDataObject.set(FIELD_PSPFNAME, (Object)pSDEViewCtrlBase.getPSPFName());
        }
        if (pSDEViewCtrlBase.isPSSysCalendarIdDirty() && (bl || pSDEViewCtrlBase.getPSSysCalendarId() != null)) {
            iDataObject.set(FIELD_PSSYSCALENDARID, (Object)pSDEViewCtrlBase.getPSSysCalendarId());
        }
        if (pSDEViewCtrlBase.isPSSysCalendarNameDirty() && (bl || pSDEViewCtrlBase.getPSSysCalendarName() != null)) {
            iDataObject.set(FIELD_PSSYSCALENDARNAME, (Object)pSDEViewCtrlBase.getPSSysCalendarName());
        }
        if (pSDEViewCtrlBase.isPSSysCounterIdDirty() && (bl || pSDEViewCtrlBase.getPSSysCounterId() != null)) {
            iDataObject.set(FIELD_PSSYSCOUNTERID, (Object)pSDEViewCtrlBase.getPSSysCounterId());
        }
        if (pSDEViewCtrlBase.isPSSysCounterNameDirty() && (bl || pSDEViewCtrlBase.getPSSysCounterName() != null)) {
            iDataObject.set(FIELD_PSSYSCOUNTERNAME, (Object)pSDEViewCtrlBase.getPSSysCounterName());
        }
        if (pSDEViewCtrlBase.isPSSysCssIdDirty() && (bl || pSDEViewCtrlBase.getPSSysCssId() != null)) {
            iDataObject.set(FIELD_PSSYSCSSID, (Object)pSDEViewCtrlBase.getPSSysCssId());
        }
        if (pSDEViewCtrlBase.isPSSysCssNameDirty() && (bl || pSDEViewCtrlBase.getPSSysCssName() != null)) {
            iDataObject.set(FIELD_PSSYSCSSNAME, (Object)pSDEViewCtrlBase.getPSSysCssName());
        }
        if (pSDEViewCtrlBase.isPSSysDashboardIdDirty() && (bl || pSDEViewCtrlBase.getPSSysDashboardId() != null)) {
            iDataObject.set(FIELD_PSSYSDASHBOARDID, (Object)pSDEViewCtrlBase.getPSSysDashboardId());
        }
        if (pSDEViewCtrlBase.isPSSysDashboardNameDirty() && (bl || pSDEViewCtrlBase.getPSSysDashboardName() != null)) {
            iDataObject.set(FIELD_PSSYSDASHBOARDNAME, (Object)pSDEViewCtrlBase.getPSSysDashboardName());
        }
        if (pSDEViewCtrlBase.isPSSysDynaModelIdDirty() && (bl || pSDEViewCtrlBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSDEViewCtrlBase.getPSSysDynaModelId());
        }
        if (pSDEViewCtrlBase.isPSSysDynaModelNameDirty() && (bl || pSDEViewCtrlBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSDEViewCtrlBase.getPSSysDynaModelName());
        }
        if (pSDEViewCtrlBase.isPSSysImageIdDirty() && (bl || pSDEViewCtrlBase.getPSSysImageId() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGEID, (Object)pSDEViewCtrlBase.getPSSysImageId());
        }
        if (pSDEViewCtrlBase.isPSSysImageNameDirty() && (bl || pSDEViewCtrlBase.getPSSysImageName() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGENAME, (Object)pSDEViewCtrlBase.getPSSysImageName());
        }
        if (pSDEViewCtrlBase.isPSSysMapViewIdDirty() && (bl || pSDEViewCtrlBase.getPSSysMapViewId() != null)) {
            iDataObject.set(FIELD_PSSYSMAPVIEWID, (Object)pSDEViewCtrlBase.getPSSysMapViewId());
        }
        if (pSDEViewCtrlBase.isPSSysMapViewNameDirty() && (bl || pSDEViewCtrlBase.getPSSysMapViewName() != null)) {
            iDataObject.set(FIELD_PSSYSMAPVIEWNAME, (Object)pSDEViewCtrlBase.getPSSysMapViewName());
        }
        if (pSDEViewCtrlBase.isPSSysMsgTemplIdDirty() && (bl || pSDEViewCtrlBase.getPSSysMsgTemplId() != null)) {
            iDataObject.set(FIELD_PSSYSMSGTEMPLID, (Object)pSDEViewCtrlBase.getPSSysMsgTemplId());
        }
        if (pSDEViewCtrlBase.isPSSysMsgTemplNameDirty() && (bl || pSDEViewCtrlBase.getPSSysMsgTemplName() != null)) {
            iDataObject.set(FIELD_PSSYSMSGTEMPLNAME, (Object)pSDEViewCtrlBase.getPSSysMsgTemplName());
        }
        if (pSDEViewCtrlBase.isPSSysPFPluginIdDirty() && (bl || pSDEViewCtrlBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSDEViewCtrlBase.getPSSysPFPluginId());
        }
        if (pSDEViewCtrlBase.isPSSysPFPluginNameDirty() && (bl || pSDEViewCtrlBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSDEViewCtrlBase.getPSSysPFPluginName());
        }
        if (pSDEViewCtrlBase.isPSSysSearchBarIdDirty() && (bl || pSDEViewCtrlBase.getPSSysSearchBarId() != null)) {
            iDataObject.set(FIELD_PSSYSSEARCHBARID, (Object)pSDEViewCtrlBase.getPSSysSearchBarId());
        }
        if (pSDEViewCtrlBase.isPSSysSearchBarNameDirty() && (bl || pSDEViewCtrlBase.getPSSysSearchBarName() != null)) {
            iDataObject.set(FIELD_PSSYSSEARCHBARNAME, (Object)pSDEViewCtrlBase.getPSSysSearchBarName());
        }
        if (pSDEViewCtrlBase.isPSSystemIdDirty() && (bl || pSDEViewCtrlBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSDEViewCtrlBase.getPSSystemId());
        }
        if (pSDEViewCtrlBase.isPSSysViewPanelIdDirty() && (bl || pSDEViewCtrlBase.getPSSysViewPanelId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELID, (Object)pSDEViewCtrlBase.getPSSysViewPanelId());
        }
        if (pSDEViewCtrlBase.isPSSysViewPanelNameDirty() && (bl || pSDEViewCtrlBase.getPSSysViewPanelName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELNAME, (Object)pSDEViewCtrlBase.getPSSysViewPanelName());
        }
        if (pSDEViewCtrlBase.isReadOnlyModeDirty() && (bl || pSDEViewCtrlBase.getReadOnlyMode() != null)) {
            iDataObject.set(FIELD_READONLYMODE, (Object)pSDEViewCtrlBase.getReadOnlyMode());
        }
        if (pSDEViewCtrlBase.isRefCtrl2NameDirty() && (bl || pSDEViewCtrlBase.getRefCtrl2Name() != null)) {
            iDataObject.set(FIELD_REFCTRL2NAME, (Object)pSDEViewCtrlBase.getRefCtrl2Name());
        }
        if (pSDEViewCtrlBase.isRefCtrl2UsageDirty() && (bl || pSDEViewCtrlBase.getRefCtrl2Usage() != null)) {
            iDataObject.set(FIELD_REFCTRL2USAGE, (Object)pSDEViewCtrlBase.getRefCtrl2Usage());
        }
        if (pSDEViewCtrlBase.isRefCtrl2UsageTextDirty() && (bl || pSDEViewCtrlBase.getRefCtrl2UsageText() != null)) {
            iDataObject.set(FIELD_REFCTRL2USAGETEXT, (Object)pSDEViewCtrlBase.getRefCtrl2UsageText());
        }
        if (pSDEViewCtrlBase.isRefCtrlNameDirty() && (bl || pSDEViewCtrlBase.getRefCtrlName() != null)) {
            iDataObject.set(FIELD_REFCTRLNAME, (Object)pSDEViewCtrlBase.getRefCtrlName());
        }
        if (pSDEViewCtrlBase.isRefCtrlUsageDirty() && (bl || pSDEViewCtrlBase.getRefCtrlUsage() != null)) {
            iDataObject.set(FIELD_REFCTRLUSAGE, (Object)pSDEViewCtrlBase.getRefCtrlUsage());
        }
        if (pSDEViewCtrlBase.isRefCtrlUsageTextDirty() && (bl || pSDEViewCtrlBase.getRefCtrlUsageText() != null)) {
            iDataObject.set(FIELD_REFCTRLUSAGETEXT, (Object)pSDEViewCtrlBase.getRefCtrlUsageText());
        }
        if (pSDEViewCtrlBase.isRightPosDirty() && (bl || pSDEViewCtrlBase.getRightPos() != null)) {
            iDataObject.set(FIELD_RIGHTPOS, (Object)pSDEViewCtrlBase.getRightPos());
        }
        if (pSDEViewCtrlBase.isSubPSACHandlerIdDirty() && (bl || pSDEViewCtrlBase.getSubPSACHandlerId() != null)) {
            iDataObject.set(FIELD_SUBPSACHANDLERID, (Object)pSDEViewCtrlBase.getSubPSACHandlerId());
        }
        if (pSDEViewCtrlBase.isSubPSACHandlerNameDirty() && (bl || pSDEViewCtrlBase.getSubPSACHandlerName() != null)) {
            iDataObject.set(FIELD_SUBPSACHANDLERNAME, (Object)pSDEViewCtrlBase.getSubPSACHandlerName());
        }
        if (pSDEViewCtrlBase.isTopPosDirty() && (bl || pSDEViewCtrlBase.getTopPos() != null)) {
            iDataObject.set(FIELD_TOPPOS, (Object)pSDEViewCtrlBase.getTopPos());
        }
        if (pSDEViewCtrlBase.isUpdateDateDirty() && (bl || pSDEViewCtrlBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEViewCtrlBase.getUpdateDate());
        }
        if (pSDEViewCtrlBase.isUpdateManDirty() && (bl || pSDEViewCtrlBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEViewCtrlBase.getUpdateMan());
        }
        if (pSDEViewCtrlBase.isUserTagDirty() && (bl || pSDEViewCtrlBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEViewCtrlBase.getUserTag());
        }
        if (pSDEViewCtrlBase.isUserTag2Dirty() && (bl || pSDEViewCtrlBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEViewCtrlBase.getUserTag2());
        }
        if (pSDEViewCtrlBase.isValidFlagDirty() && (bl || pSDEViewCtrlBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDEViewCtrlBase.getValidFlag());
        }
        if (pSDEViewCtrlBase.isWidthDirty() && (bl || pSDEViewCtrlBase.getWidth() != null)) {
            iDataObject.set(FIELD_WIDTH, (Object)pSDEViewCtrlBase.getWidth());
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
        return PSDEViewCtrlBase.remove(this, n);
    }

    private static boolean remove(PSDEViewCtrlBase pSDEViewCtrlBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEViewCtrlBase.resetADPSDELogicId();
                return true;
            }
            case 1: {
                pSDEViewCtrlBase.resetADPSDELogicName();
                return true;
            }
            case 2: {
                pSDEViewCtrlBase.resetBottomPos();
                return true;
            }
            case 3: {
                pSDEViewCtrlBase.resetBtnActionType();
                return true;
            }
            case 4: {
                pSDEViewCtrlBase.resetBusyIndicator();
                return true;
            }
            case 5: {
                pSDEViewCtrlBase.resetCapPSLanResId();
                return true;
            }
            case 6: {
                pSDEViewCtrlBase.resetCapPSLanResName();
                return true;
            }
            case 7: {
                pSDEViewCtrlBase.resetCaption();
                return true;
            }
            case 8: {
                pSDEViewCtrlBase.resetConfigInfo();
                return true;
            }
            case 9: {
                pSDEViewCtrlBase.resetCreateDate();
                return true;
            }
            case 10: {
                pSDEViewCtrlBase.resetCreateMan();
                return true;
            }
            case 11: {
                pSDEViewCtrlBase.resetCtrlParam();
                return true;
            }
            case 12: {
                pSDEViewCtrlBase.resetCtrlParam10();
                return true;
            }
            case 13: {
                pSDEViewCtrlBase.resetCtrlParam11();
                return true;
            }
            case 14: {
                pSDEViewCtrlBase.resetCtrlParam12();
                return true;
            }
            case 15: {
                pSDEViewCtrlBase.resetCtrlParam2();
                return true;
            }
            case 16: {
                pSDEViewCtrlBase.resetCtrlParam3();
                return true;
            }
            case 17: {
                pSDEViewCtrlBase.resetCtrlParam4();
                return true;
            }
            case 18: {
                pSDEViewCtrlBase.resetCtrlParam5();
                return true;
            }
            case 19: {
                pSDEViewCtrlBase.resetCtrlParam6();
                return true;
            }
            case 20: {
                pSDEViewCtrlBase.resetCtrlParam7();
                return true;
            }
            case 21: {
                pSDEViewCtrlBase.resetCtrlParam8();
                return true;
            }
            case 22: {
                pSDEViewCtrlBase.resetCtrlParam9();
                return true;
            }
            case 23: {
                pSDEViewCtrlBase.resetCtrlParams();
                return true;
            }
            case 24: {
                pSDEViewCtrlBase.resetCustomCond();
                return true;
            }
            case 25: {
                pSDEViewCtrlBase.resetCustomType();
                return true;
            }
            case 26: {
                pSDEViewCtrlBase.resetDefaultFlag();
                return true;
            }
            case 27: {
                pSDEViewCtrlBase.resetDynaModelFlag();
                return true;
            }
            case 28: {
                pSDEViewCtrlBase.resetDyncMode();
                return true;
            }
            case 29: {
                pSDEViewCtrlBase.resetEnableDynaSys();
                return true;
            }
            case 30: {
                pSDEViewCtrlBase.resetEnableItemPriv();
                return true;
            }
            case 31: {
                pSDEViewCtrlBase.resetEnableViewActions();
                return true;
            }
            case 32: {
                pSDEViewCtrlBase.resetHeight();
                return true;
            }
            case 33: {
                pSDEViewCtrlBase.resetInsertPos();
                return true;
            }
            case 34: {
                pSDEViewCtrlBase.resetLeftPos();
                return true;
            }
            case 35: {
                pSDEViewCtrlBase.resetLocalMode();
                return true;
            }
            case 36: {
                pSDEViewCtrlBase.resetMargin();
                return true;
            }
            case 37: {
                pSDEViewCtrlBase.resetMemo();
                return true;
            }
            case 38: {
                pSDEViewCtrlBase.resetMultiSelect();
                return true;
            }
            case 39: {
                pSDEViewCtrlBase.resetNO2PSDEUAGroupId();
                return true;
            }
            case 40: {
                pSDEViewCtrlBase.resetNO2PSDEUAGroupName();
                return true;
            }
            case 41: {
                pSDEViewCtrlBase.resetNO3PSDEUAGroupId();
                return true;
            }
            case 42: {
                pSDEViewCtrlBase.resetNO3PSDEUAGroupName();
                return true;
            }
            case 43: {
                pSDEViewCtrlBase.resetNO4PSDEUAGroupId();
                return true;
            }
            case 44: {
                pSDEViewCtrlBase.resetNO4PSDEUAGroupName();
                return true;
            }
            case 45: {
                pSDEViewCtrlBase.resetNO5PSDEUAGroupId();
                return true;
            }
            case 46: {
                pSDEViewCtrlBase.resetNO5PSDEUAGroupName();
                return true;
            }
            case 47: {
                pSDEViewCtrlBase.resetNO6PSDEUAGroupId();
                return true;
            }
            case 48: {
                pSDEViewCtrlBase.resetNO6PSDEUAGroupName();
                return true;
            }
            case 49: {
                pSDEViewCtrlBase.resetOrderValue();
                return true;
            }
            case 50: {
                pSDEViewCtrlBase.resetPadding();
                return true;
            }
            case 51: {
                pSDEViewCtrlBase.resetPredefinedType();
                return true;
            }
            case 52: {
                pSDEViewCtrlBase.resetPredefinedTypeText();
                return true;
            }
            case 53: {
                pSDEViewCtrlBase.resetPSACHandlerId();
                return true;
            }
            case 54: {
                pSDEViewCtrlBase.resetPSACHandlerName();
                return true;
            }
            case 55: {
                pSDEViewCtrlBase.resetPSCtrlId();
                return true;
            }
            case 56: {
                pSDEViewCtrlBase.resetPSCtrlLogicGroupId();
                return true;
            }
            case 57: {
                pSDEViewCtrlBase.resetPSCtrlLogicGroupName();
                return true;
            }
            case 58: {
                pSDEViewCtrlBase.resetPSCtrlMsgId();
                return true;
            }
            case 59: {
                pSDEViewCtrlBase.resetPSCtrlMsgName();
                return true;
            }
            case 60: {
                pSDEViewCtrlBase.resetPSCtrlName();
                return true;
            }
            case 61: {
                pSDEViewCtrlBase.resetPSDEActionId();
                return true;
            }
            case 62: {
                pSDEViewCtrlBase.resetPSDEActionName();
                return true;
            }
            case 63: {
                pSDEViewCtrlBase.resetPSDEChartId();
                return true;
            }
            case 64: {
                pSDEViewCtrlBase.resetPSDEChartName();
                return true;
            }
            case 65: {
                pSDEViewCtrlBase.resetPSDEDataExpId();
                return true;
            }
            case 66: {
                pSDEViewCtrlBase.resetPSDEDataExpName();
                return true;
            }
            case 67: {
                pSDEViewCtrlBase.resetPSDEDataImpId();
                return true;
            }
            case 68: {
                pSDEViewCtrlBase.resetPSDEDataImpName();
                return true;
            }
            case 69: {
                pSDEViewCtrlBase.resetPSDEDataSetId();
                return true;
            }
            case 70: {
                pSDEViewCtrlBase.resetPSDEDataSetName();
                return true;
            }
            case 71: {
                pSDEViewCtrlBase.resetPSDEDataViewId();
                return true;
            }
            case 72: {
                pSDEViewCtrlBase.resetPSDEDataViewName();
                return true;
            }
            case 73: {
                pSDEViewCtrlBase.resetPSDEDRId();
                return true;
            }
            case 74: {
                pSDEViewCtrlBase.resetPSDEDRName();
                return true;
            }
            case 75: {
                pSDEViewCtrlBase.resetPSDEFormId();
                return true;
            }
            case 76: {
                pSDEViewCtrlBase.resetPSDEFormName();
                return true;
            }
            case 77: {
                pSDEViewCtrlBase.resetPSDEGridId();
                return true;
            }
            case 78: {
                pSDEViewCtrlBase.resetPSDEGridName();
                return true;
            }
            case 79: {
                pSDEViewCtrlBase.resetPSDEId();
                return true;
            }
            case 80: {
                pSDEViewCtrlBase.resetPSDEListId();
                return true;
            }
            case 81: {
                pSDEViewCtrlBase.resetPSDEListName();
                return true;
            }
            case 82: {
                pSDEViewCtrlBase.resetPSDEName();
                return true;
            }
            case 83: {
                pSDEViewCtrlBase.resetPSDEOPPrivId();
                return true;
            }
            case 84: {
                pSDEViewCtrlBase.resetPSDEOPPrivName();
                return true;
            }
            case 85: {
                pSDEViewCtrlBase.resetPSDEReportId();
                return true;
            }
            case 86: {
                pSDEViewCtrlBase.resetPSDEReportName();
                return true;
            }
            case 87: {
                pSDEViewCtrlBase.resetPSDEToolbarId();
                return true;
            }
            case 88: {
                pSDEViewCtrlBase.resetPSDEToolbarName();
                return true;
            }
            case 89: {
                pSDEViewCtrlBase.resetPSDETreeViewId();
                return true;
            }
            case 90: {
                pSDEViewCtrlBase.resetPSDETreeViewName();
                return true;
            }
            case 91: {
                pSDEViewCtrlBase.resetPSDEUAGroupId();
                return true;
            }
            case 92: {
                pSDEViewCtrlBase.resetPSDEUAGroupName();
                return true;
            }
            case 93: {
                pSDEViewCtrlBase.resetPSDEViewBaseId();
                return true;
            }
            case 94: {
                pSDEViewCtrlBase.resetPSDEViewBaseName();
                return true;
            }
            case 95: {
                pSDEViewCtrlBase.resetPSDEViewCtrlId();
                return true;
            }
            case 96: {
                pSDEViewCtrlBase.resetPSDEViewCtrlName();
                return true;
            }
            case 97: {
                pSDEViewCtrlBase.resetPSDEViewCtrlType();
                return true;
            }
            case 98: {
                pSDEViewCtrlBase.resetPSDEViewId();
                return true;
            }
            case 99: {
                pSDEViewCtrlBase.resetPSDEViewName();
                return true;
            }
            case 100: {
                pSDEViewCtrlBase.resetPSDEWizardId();
                return true;
            }
            case 101: {
                pSDEViewCtrlBase.resetPSDEWizardName();
                return true;
            }
            case 102: {
                pSDEViewCtrlBase.resetPSDynaInstId();
                return true;
            }
            case 103: {
                pSDEViewCtrlBase.resetPSPFId();
                return true;
            }
            case 104: {
                pSDEViewCtrlBase.resetPSPFName();
                return true;
            }
            case 105: {
                pSDEViewCtrlBase.resetPSSysCalendarId();
                return true;
            }
            case 106: {
                pSDEViewCtrlBase.resetPSSysCalendarName();
                return true;
            }
            case 107: {
                pSDEViewCtrlBase.resetPSSysCounterId();
                return true;
            }
            case 108: {
                pSDEViewCtrlBase.resetPSSysCounterName();
                return true;
            }
            case 109: {
                pSDEViewCtrlBase.resetPSSysCssId();
                return true;
            }
            case 110: {
                pSDEViewCtrlBase.resetPSSysCssName();
                return true;
            }
            case 111: {
                pSDEViewCtrlBase.resetPSSysDashboardId();
                return true;
            }
            case 112: {
                pSDEViewCtrlBase.resetPSSysDashboardName();
                return true;
            }
            case 113: {
                pSDEViewCtrlBase.resetPSSysDynaModelId();
                return true;
            }
            case 114: {
                pSDEViewCtrlBase.resetPSSysDynaModelName();
                return true;
            }
            case 115: {
                pSDEViewCtrlBase.resetPSSysImageId();
                return true;
            }
            case 116: {
                pSDEViewCtrlBase.resetPSSysImageName();
                return true;
            }
            case 117: {
                pSDEViewCtrlBase.resetPSSysMapViewId();
                return true;
            }
            case 118: {
                pSDEViewCtrlBase.resetPSSysMapViewName();
                return true;
            }
            case 119: {
                pSDEViewCtrlBase.resetPSSysMsgTemplId();
                return true;
            }
            case 120: {
                pSDEViewCtrlBase.resetPSSysMsgTemplName();
                return true;
            }
            case 121: {
                pSDEViewCtrlBase.resetPSSysPFPluginId();
                return true;
            }
            case 122: {
                pSDEViewCtrlBase.resetPSSysPFPluginName();
                return true;
            }
            case 123: {
                pSDEViewCtrlBase.resetPSSysSearchBarId();
                return true;
            }
            case 124: {
                pSDEViewCtrlBase.resetPSSysSearchBarName();
                return true;
            }
            case 125: {
                pSDEViewCtrlBase.resetPSSystemId();
                return true;
            }
            case 126: {
                pSDEViewCtrlBase.resetPSSysViewPanelId();
                return true;
            }
            case 127: {
                pSDEViewCtrlBase.resetPSSysViewPanelName();
                return true;
            }
            case 128: {
                pSDEViewCtrlBase.resetReadOnlyMode();
                return true;
            }
            case 129: {
                pSDEViewCtrlBase.resetRefCtrl2Name();
                return true;
            }
            case 130: {
                pSDEViewCtrlBase.resetRefCtrl2Usage();
                return true;
            }
            case 131: {
                pSDEViewCtrlBase.resetRefCtrl2UsageText();
                return true;
            }
            case 132: {
                pSDEViewCtrlBase.resetRefCtrlName();
                return true;
            }
            case 133: {
                pSDEViewCtrlBase.resetRefCtrlUsage();
                return true;
            }
            case 134: {
                pSDEViewCtrlBase.resetRefCtrlUsageText();
                return true;
            }
            case 135: {
                pSDEViewCtrlBase.resetRightPos();
                return true;
            }
            case 136: {
                pSDEViewCtrlBase.resetSubPSACHandlerId();
                return true;
            }
            case 137: {
                pSDEViewCtrlBase.resetSubPSACHandlerName();
                return true;
            }
            case 138: {
                pSDEViewCtrlBase.resetTopPos();
                return true;
            }
            case 139: {
                pSDEViewCtrlBase.resetUpdateDate();
                return true;
            }
            case 140: {
                pSDEViewCtrlBase.resetUpdateMan();
                return true;
            }
            case 141: {
                pSDEViewCtrlBase.resetUserTag();
                return true;
            }
            case 142: {
                pSDEViewCtrlBase.resetUserTag2();
                return true;
            }
            case 143: {
                pSDEViewCtrlBase.resetValidFlag();
                return true;
            }
            case 144: {
                pSDEViewCtrlBase.resetWidth();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSACHandler getPSACHandler() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSACHandler();
        }
        if (this.getPSACHandlerId() == null) {
            return null;
        }
        Integer n = this.objPSACHandlerLock;
        synchronized (n) {
            if (this.psachandler != null && DataTypeHelper.compare((int)25, (Object)this.getPSACHandlerId(), (Object)this.psachandler.getPSACHandlerId()) != 0L) {
                this.psachandler = null;
            }
            if (this.psachandler == null) {
                PSACHandler pSACHandler = new PSACHandler();
                pSACHandler.setPSACHandlerId(this.getPSACHandlerId());
                PSACHandlerService pSACHandlerService = (PSACHandlerService)ServiceGlobal.getService(PSACHandlerService.class, (SessionFactory)this.getSessionFactory());
                pSACHandlerService.autoGet(pSACHandler);
                this.psachandler = pSACHandler;
            }
            return this.psachandler;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSACHandler getSubPSACHandler() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSubPSACHandler();
        }
        if (this.getSubPSACHandlerId() == null) {
            return null;
        }
        Integer n = this.objSubPSACHandlerLock;
        synchronized (n) {
            if (this.subpsachandler != null && DataTypeHelper.compare((int)25, (Object)this.getSubPSACHandlerId(), (Object)this.subpsachandler.getPSACHandlerId()) != 0L) {
                this.subpsachandler = null;
            }
            if (this.subpsachandler == null) {
                PSACHandler pSACHandler = new PSACHandler();
                pSACHandler.setPSACHandlerId(this.getSubPSACHandlerId());
                PSACHandlerService pSACHandlerService = (PSACHandlerService)ServiceGlobal.getService(PSACHandlerService.class, (SessionFactory)this.getSessionFactory());
                pSACHandlerService.autoGet(pSACHandler);
                this.subpsachandler = pSACHandler;
            }
            return this.subpsachandler;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCtrlLogicGroup getPSCtrlLogicGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlLogicGroup();
        }
        if (this.getPSCtrlLogicGroupId() == null) {
            return null;
        }
        Integer n = this.objPSCtrlLogicGroupLock;
        synchronized (n) {
            if (this.psctrllogicgroup != null && DataTypeHelper.compare((int)25, (Object)this.getPSCtrlLogicGroupId(), (Object)this.psctrllogicgroup.getPSCtrlLogicGroupId()) != 0L) {
                this.psctrllogicgroup = null;
            }
            if (this.psctrllogicgroup == null) {
                PSCtrlLogicGroup pSCtrlLogicGroup = new PSCtrlLogicGroup();
                pSCtrlLogicGroup.setPSCtrlLogicGroupId(this.getPSCtrlLogicGroupId());
                PSCtrlLogicGroupService pSCtrlLogicGroupService = (PSCtrlLogicGroupService)ServiceGlobal.getService(PSCtrlLogicGroupService.class, (SessionFactory)this.getSessionFactory());
                pSCtrlLogicGroupService.autoGet(pSCtrlLogicGroup);
                this.psctrllogicgroup = pSCtrlLogicGroup;
            }
            return this.psctrllogicgroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCtrlMsg getPSCtrlMsg() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlMsg();
        }
        if (this.getPSCtrlMsgId() == null) {
            return null;
        }
        Integer n = this.objPSCtrlMsgLock;
        synchronized (n) {
            if (this.psctrlmsg != null && DataTypeHelper.compare((int)25, (Object)this.getPSCtrlMsgId(), (Object)this.psctrlmsg.getPSCtrlMsgId()) != 0L) {
                this.psctrlmsg = null;
            }
            if (this.psctrlmsg == null) {
                PSCtrlMsg pSCtrlMsg = new PSCtrlMsg();
                pSCtrlMsg.setPSCtrlMsgId(this.getPSCtrlMsgId());
                PSCtrlMsgService pSCtrlMsgService = (PSCtrlMsgService)ServiceGlobal.getService(PSCtrlMsgService.class, (SessionFactory)this.getSessionFactory());
                pSCtrlMsgService.autoGet(pSCtrlMsg);
                this.psctrlmsg = pSCtrlMsg;
            }
            return this.psctrlmsg;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getPSDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDE();
        }
        if (this.getPSDEId() == null) {
            return null;
        }
        Integer n = this.objPSDELock;
        synchronized (n) {
            if (this.psde != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEId(), (Object)this.psde.getPSDataEntityId()) != 0L) {
                this.psde = null;
            }
            if (this.psde == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getPSDEId());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.psde = pSDataEntity;
            }
            return this.psde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEAction getPSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEAction();
        }
        if (this.getPSDEActionId() == null) {
            return null;
        }
        Integer n = this.objPSDEActionLock;
        synchronized (n) {
            if (this.psdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEActionId(), (Object)this.psdeaction.getPSDEActionId()) != 0L) {
                this.psdeaction = null;
            }
            if (this.psdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getPSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet(pSDEAction);
                this.psdeaction = pSDEAction;
            }
            return this.psdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEChart getPSDEChart() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEChart();
        }
        if (this.getPSDEChartId() == null) {
            return null;
        }
        Integer n = this.objPSDEChartLock;
        synchronized (n) {
            if (this.psdechart != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEChartId(), (Object)this.psdechart.getPSDEChartId()) != 0L) {
                this.psdechart = null;
            }
            if (this.psdechart == null) {
                PSDEChart pSDEChart = new PSDEChart();
                pSDEChart.setPSDEChartId(this.getPSDEChartId());
                PSDEChartService pSDEChartService = (PSDEChartService)ServiceGlobal.getService(PSDEChartService.class, (SessionFactory)this.getSessionFactory());
                pSDEChartService.autoGet(pSDEChart);
                this.psdechart = pSDEChart;
            }
            return this.psdechart;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataExp getPSDEDataExp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataExp();
        }
        if (this.getPSDEDataExpId() == null) {
            return null;
        }
        Integer n = this.objPSDEDataExpLock;
        synchronized (n) {
            if (this.psdedataexp != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDataExpId(), (Object)this.psdedataexp.getPSDEDataExpId()) != 0L) {
                this.psdedataexp = null;
            }
            if (this.psdedataexp == null) {
                PSDEDataExp pSDEDataExp = new PSDEDataExp();
                pSDEDataExp.setPSDEDataExpId(this.getPSDEDataExpId());
                PSDEDataExpService pSDEDataExpService = (PSDEDataExpService)ServiceGlobal.getService(PSDEDataExpService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataExpService.autoGet(pSDEDataExp);
                this.psdedataexp = pSDEDataExp;
            }
            return this.psdedataexp;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataImp getPSDEDataImp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataImp();
        }
        if (this.getPSDEDataImpId() == null) {
            return null;
        }
        Integer n = this.objPSDEDataImpLock;
        synchronized (n) {
            if (this.psdedataimp != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDataImpId(), (Object)this.psdedataimp.getPSDEDataImpId()) != 0L) {
                this.psdedataimp = null;
            }
            if (this.psdedataimp == null) {
                PSDEDataImp pSDEDataImp = new PSDEDataImp();
                pSDEDataImp.setPSDEDataImpId(this.getPSDEDataImpId());
                PSDEDataImpService pSDEDataImpService = (PSDEDataImpService)ServiceGlobal.getService(PSDEDataImpService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataImpService.autoGet(pSDEDataImp);
                this.psdedataimp = pSDEDataImp;
            }
            return this.psdedataimp;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataRelation getPSDEDR() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDR();
        }
        if (this.getPSDEDRId() == null) {
            return null;
        }
        Integer n = this.objPSDEDRLock;
        synchronized (n) {
            if (this.psdedr != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDRId(), (Object)this.psdedr.getPSDEDataRelationId()) != 0L) {
                this.psdedr = null;
            }
            if (this.psdedr == null) {
                PSDEDataRelation pSDEDataRelation = new PSDEDataRelation();
                pSDEDataRelation.setPSDEDataRelationId(this.getPSDEDRId());
                PSDEDataRelationService pSDEDataRelationService = (PSDEDataRelationService)ServiceGlobal.getService(PSDEDataRelationService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataRelationService.autoGet(pSDEDataRelation);
                this.psdedr = pSDEDataRelation;
            }
            return this.psdedr;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataSet getPSDEDataSet() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataSet();
        }
        if (this.getPSDEDataSetId() == null) {
            return null;
        }
        Integer n = this.objPSDEDataSetLock;
        synchronized (n) {
            if (this.psdedataset != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDataSetId(), (Object)this.psdedataset.getPSDEDataSetId()) != 0L) {
                this.psdedataset = null;
            }
            if (this.psdedataset == null) {
                PSDEDataSet pSDEDataSet = new PSDEDataSet();
                pSDEDataSet.setPSDEDataSetId(this.getPSDEDataSetId());
                PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataSetService.autoGet(pSDEDataSet);
                this.psdedataset = pSDEDataSet;
            }
            return this.psdedataset;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataView getPSDEDataView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataView();
        }
        if (this.getPSDEDataViewId() == null) {
            return null;
        }
        Integer n = this.objPSDEDataViewLock;
        synchronized (n) {
            if (this.psdedataview != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDataViewId(), (Object)this.psdedataview.getPSDEDataViewId()) != 0L) {
                this.psdedataview = null;
            }
            if (this.psdedataview == null) {
                PSDEDataView pSDEDataView = new PSDEDataView();
                pSDEDataView.setPSDEDataViewId(this.getPSDEDataViewId());
                PSDEDataViewService pSDEDataViewService = (PSDEDataViewService)ServiceGlobal.getService(PSDEDataViewService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataViewService.autoGet(pSDEDataView);
                this.psdedataview = pSDEDataView;
            }
            return this.psdedataview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEForm getPSDEForm() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEForm();
        }
        if (this.getPSDEFormId() == null) {
            return null;
        }
        Integer n = this.objPSDEFormLock;
        synchronized (n) {
            if (this.psdeform != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFormId(), (Object)this.psdeform.getPSDEFormId()) != 0L) {
                this.psdeform = null;
            }
            if (this.psdeform == null) {
                PSDEForm pSDEForm = new PSDEForm();
                pSDEForm.setPSDEFormId(this.getPSDEFormId());
                PSDEFormService pSDEFormService = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
                pSDEFormService.autoGet(pSDEForm);
                this.psdeform = pSDEForm;
            }
            return this.psdeform;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEGrid getPSDEGrid() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGrid();
        }
        if (this.getPSDEGridId() == null) {
            return null;
        }
        Integer n = this.objPSDEGridLock;
        synchronized (n) {
            if (this.psdegrid != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEGridId(), (Object)this.psdegrid.getPSDEGridId()) != 0L) {
                this.psdegrid = null;
            }
            if (this.psdegrid == null) {
                PSDEGrid pSDEGrid = new PSDEGrid();
                pSDEGrid.setPSDEGridId(this.getPSDEGridId());
                PSDEGridService pSDEGridService = (PSDEGridService)ServiceGlobal.getService(PSDEGridService.class, (SessionFactory)this.getSessionFactory());
                pSDEGridService.autoGet(pSDEGrid);
                this.psdegrid = pSDEGrid;
            }
            return this.psdegrid;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEList getPSDEList() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEList();
        }
        if (this.getPSDEListId() == null) {
            return null;
        }
        Integer n = this.objPSDEListLock;
        synchronized (n) {
            if (this.psdelist != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEListId(), (Object)this.psdelist.getPSDEListId()) != 0L) {
                this.psdelist = null;
            }
            if (this.psdelist == null) {
                PSDEList pSDEList = new PSDEList();
                pSDEList.setPSDEListId(this.getPSDEListId());
                PSDEListService pSDEListService = (PSDEListService)ServiceGlobal.getService(PSDEListService.class, (SessionFactory)this.getSessionFactory());
                pSDEListService.autoGet(pSDEList);
                this.psdelist = pSDEList;
            }
            return this.psdelist;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDELogic getADPSDELogic() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getADPSDELogic();
        }
        if (this.getADPSDELogicId() == null) {
            return null;
        }
        Integer n = this.objADPSDELogicLock;
        synchronized (n) {
            if (this.adpsdelogic != null && DataTypeHelper.compare((int)25, (Object)this.getADPSDELogicId(), (Object)this.adpsdelogic.getPSDELogicId()) != 0L) {
                this.adpsdelogic = null;
            }
            if (this.adpsdelogic == null) {
                PSDELogic pSDELogic = new PSDELogic();
                pSDELogic.setPSDELogicId(this.getADPSDELogicId());
                PSDELogicService pSDELogicService = (PSDELogicService)ServiceGlobal.getService(PSDELogicService.class, (SessionFactory)this.getSessionFactory());
                pSDELogicService.autoGet(pSDELogic);
                this.adpsdelogic = pSDELogic;
            }
            return this.adpsdelogic;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEOPPriv getPSDEOPPriv() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEOPPriv();
        }
        if (this.getPSDEOPPrivId() == null) {
            return null;
        }
        Integer n = this.objPSDEOPPrivLock;
        synchronized (n) {
            if (this.psdeoppriv != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEOPPrivId(), (Object)this.psdeoppriv.getPSDEOPPrivId()) != 0L) {
                this.psdeoppriv = null;
            }
            if (this.psdeoppriv == null) {
                PSDEOPPriv pSDEOPPriv = new PSDEOPPriv();
                pSDEOPPriv.setPSDEOPPrivId(this.getPSDEOPPrivId());
                PSDEOPPrivService pSDEOPPrivService = (PSDEOPPrivService)ServiceGlobal.getService(PSDEOPPrivService.class, (SessionFactory)this.getSessionFactory());
                pSDEOPPrivService.autoGet(pSDEOPPriv);
                this.psdeoppriv = pSDEOPPriv;
            }
            return this.psdeoppriv;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEReport getPSDEReport() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEReport();
        }
        if (this.getPSDEReportId() == null) {
            return null;
        }
        Integer n = this.objPSDEReportLock;
        synchronized (n) {
            if (this.psdereport != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEReportId(), (Object)this.psdereport.getPSDEReportId()) != 0L) {
                this.psdereport = null;
            }
            if (this.psdereport == null) {
                PSDEReport pSDEReport = new PSDEReport();
                pSDEReport.setPSDEReportId(this.getPSDEReportId());
                PSDEReportService pSDEReportService = (PSDEReportService)ServiceGlobal.getService(PSDEReportService.class, (SessionFactory)this.getSessionFactory());
                pSDEReportService.autoGet(pSDEReport);
                this.psdereport = pSDEReport;
            }
            return this.psdereport;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEToolbar getPSDEToolbar() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEToolbar();
        }
        if (this.getPSDEToolbarId() == null) {
            return null;
        }
        Integer n = this.objPSDEToolbarLock;
        synchronized (n) {
            if (this.psdetoolbar != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEToolbarId(), (Object)this.psdetoolbar.getPSDEToolbarId()) != 0L) {
                this.psdetoolbar = null;
            }
            if (this.psdetoolbar == null) {
                PSDEToolbar pSDEToolbar = new PSDEToolbar();
                pSDEToolbar.setPSDEToolbarId(this.getPSDEToolbarId());
                PSDEToolbarService pSDEToolbarService = (PSDEToolbarService)ServiceGlobal.getService(PSDEToolbarService.class, (SessionFactory)this.getSessionFactory());
                pSDEToolbarService.autoGet(pSDEToolbar);
                this.psdetoolbar = pSDEToolbar;
            }
            return this.psdetoolbar;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDETreeView getPSDETreeView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETreeView();
        }
        if (this.getPSDETreeViewId() == null) {
            return null;
        }
        Integer n = this.objPSDETreeViewLock;
        synchronized (n) {
            if (this.psdetreeview != null && DataTypeHelper.compare((int)25, (Object)this.getPSDETreeViewId(), (Object)this.psdetreeview.getPSDETreeViewId()) != 0L) {
                this.psdetreeview = null;
            }
            if (this.psdetreeview == null) {
                PSDETreeView pSDETreeView = new PSDETreeView();
                pSDETreeView.setPSDETreeViewId(this.getPSDETreeViewId());
                PSDETreeViewService pSDETreeViewService = (PSDETreeViewService)ServiceGlobal.getService(PSDETreeViewService.class, (SessionFactory)this.getSessionFactory());
                pSDETreeViewService.autoGet(pSDETreeView);
                this.psdetreeview = pSDETreeView;
            }
            return this.psdetreeview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEUAGroup getNo2PSDEUAGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo2PSDEUAGroup();
        }
        if (this.getNO2PSDEUAGroupId() == null) {
            return null;
        }
        Integer n = this.objNo2PSDEUAGroupLock;
        synchronized (n) {
            if (this.no2psdeuagroup != null && DataTypeHelper.compare((int)25, (Object)this.getNO2PSDEUAGroupId(), (Object)this.no2psdeuagroup.getPSDEUAGroupId()) != 0L) {
                this.no2psdeuagroup = null;
            }
            if (this.no2psdeuagroup == null) {
                PSDEUAGroup pSDEUAGroup = new PSDEUAGroup();
                pSDEUAGroup.setPSDEUAGroupId(this.getNO2PSDEUAGroupId());
                PSDEUAGroupService pSDEUAGroupService = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)this.getSessionFactory());
                pSDEUAGroupService.autoGet(pSDEUAGroup);
                this.no2psdeuagroup = pSDEUAGroup;
            }
            return this.no2psdeuagroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEUAGroup getNo3PSDEUAGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo3PSDEUAGroup();
        }
        if (this.getNO3PSDEUAGroupId() == null) {
            return null;
        }
        Integer n = this.objNo3PSDEUAGroupLock;
        synchronized (n) {
            if (this.no3psdeuagroup != null && DataTypeHelper.compare((int)25, (Object)this.getNO3PSDEUAGroupId(), (Object)this.no3psdeuagroup.getPSDEUAGroupId()) != 0L) {
                this.no3psdeuagroup = null;
            }
            if (this.no3psdeuagroup == null) {
                PSDEUAGroup pSDEUAGroup = new PSDEUAGroup();
                pSDEUAGroup.setPSDEUAGroupId(this.getNO3PSDEUAGroupId());
                PSDEUAGroupService pSDEUAGroupService = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)this.getSessionFactory());
                pSDEUAGroupService.autoGet(pSDEUAGroup);
                this.no3psdeuagroup = pSDEUAGroup;
            }
            return this.no3psdeuagroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEUAGroup getNo4PSDEUAGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo4PSDEUAGroup();
        }
        if (this.getNO4PSDEUAGroupId() == null) {
            return null;
        }
        Integer n = this.objNo4PSDEUAGroupLock;
        synchronized (n) {
            if (this.no4psdeuagroup != null && DataTypeHelper.compare((int)25, (Object)this.getNO4PSDEUAGroupId(), (Object)this.no4psdeuagroup.getPSDEUAGroupId()) != 0L) {
                this.no4psdeuagroup = null;
            }
            if (this.no4psdeuagroup == null) {
                PSDEUAGroup pSDEUAGroup = new PSDEUAGroup();
                pSDEUAGroup.setPSDEUAGroupId(this.getNO4PSDEUAGroupId());
                PSDEUAGroupService pSDEUAGroupService = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)this.getSessionFactory());
                pSDEUAGroupService.autoGet(pSDEUAGroup);
                this.no4psdeuagroup = pSDEUAGroup;
            }
            return this.no4psdeuagroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEUAGroup getNo5PSDEUAGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo5PSDEUAGroup();
        }
        if (this.getNO5PSDEUAGroupId() == null) {
            return null;
        }
        Integer n = this.objNo5PSDEUAGroupLock;
        synchronized (n) {
            if (this.no5psdeuagroup != null && DataTypeHelper.compare((int)25, (Object)this.getNO5PSDEUAGroupId(), (Object)this.no5psdeuagroup.getPSDEUAGroupId()) != 0L) {
                this.no5psdeuagroup = null;
            }
            if (this.no5psdeuagroup == null) {
                PSDEUAGroup pSDEUAGroup = new PSDEUAGroup();
                pSDEUAGroup.setPSDEUAGroupId(this.getNO5PSDEUAGroupId());
                PSDEUAGroupService pSDEUAGroupService = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)this.getSessionFactory());
                pSDEUAGroupService.autoGet(pSDEUAGroup);
                this.no5psdeuagroup = pSDEUAGroup;
            }
            return this.no5psdeuagroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEUAGroup getNo6PSDEUAGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo6PSDEUAGroup();
        }
        if (this.getNO6PSDEUAGroupId() == null) {
            return null;
        }
        Integer n = this.objNo6PSDEUAGroupLock;
        synchronized (n) {
            if (this.no6psdeuagroup != null && DataTypeHelper.compare((int)25, (Object)this.getNO6PSDEUAGroupId(), (Object)this.no6psdeuagroup.getPSDEUAGroupId()) != 0L) {
                this.no6psdeuagroup = null;
            }
            if (this.no6psdeuagroup == null) {
                PSDEUAGroup pSDEUAGroup = new PSDEUAGroup();
                pSDEUAGroup.setPSDEUAGroupId(this.getNO6PSDEUAGroupId());
                PSDEUAGroupService pSDEUAGroupService = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)this.getSessionFactory());
                pSDEUAGroupService.autoGet(pSDEUAGroup);
                this.no6psdeuagroup = pSDEUAGroup;
            }
            return this.no6psdeuagroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEUAGroup getPSDEUAGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUAGroup();
        }
        if (this.getPSDEUAGroupId() == null) {
            return null;
        }
        Integer n = this.objPSDEUAGroupLock;
        synchronized (n) {
            if (this.psdeuagroup != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEUAGroupId(), (Object)this.psdeuagroup.getPSDEUAGroupId()) != 0L) {
                this.psdeuagroup = null;
            }
            if (this.psdeuagroup == null) {
                PSDEUAGroup pSDEUAGroup = new PSDEUAGroup();
                pSDEUAGroup.setPSDEUAGroupId(this.getPSDEUAGroupId());
                PSDEUAGroupService pSDEUAGroupService = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)this.getSessionFactory());
                pSDEUAGroupService.autoGet(pSDEUAGroup);
                this.psdeuagroup = pSDEUAGroup;
            }
            return this.psdeuagroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewBase getPSDEViewBase() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBase();
        }
        if (this.getPSDEViewBaseId() == null) {
            return null;
        }
        Integer n = this.objPSDEViewBaseLock;
        synchronized (n) {
            if (this.psdeviewbase != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEViewBaseId(), (Object)this.psdeviewbase.getPSDEViewBaseId()) != 0L) {
                this.psdeviewbase = null;
            }
            if (this.psdeviewbase == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getPSDEViewBaseId());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet(pSDEViewBase);
                this.psdeviewbase = pSDEViewBase;
            }
            return this.psdeviewbase;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewBase getPSDEView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEView();
        }
        if (this.getPSDEViewId() == null) {
            return null;
        }
        Integer n = this.objPSDEViewLock;
        synchronized (n) {
            if (this.psdeview != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEViewId(), (Object)this.psdeview.getPSDEViewBaseId()) != 0L) {
                this.psdeview = null;
            }
            if (this.psdeview == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getPSDEViewId());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet(pSDEViewBase);
                this.psdeview = pSDEViewBase;
            }
            return this.psdeview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEWizard getPSDEWizard() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEWizard();
        }
        if (this.getPSDEWizardId() == null) {
            return null;
        }
        Integer n = this.objPSDEWizardLock;
        synchronized (n) {
            if (this.psdewizard != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEWizardId(), (Object)this.psdewizard.getPSDEWizardId()) != 0L) {
                this.psdewizard = null;
            }
            if (this.psdewizard == null) {
                PSDEWizard pSDEWizard = new PSDEWizard();
                pSDEWizard.setPSDEWizardId(this.getPSDEWizardId());
                PSDEWizardService pSDEWizardService = (PSDEWizardService)ServiceGlobal.getService(PSDEWizardService.class, (SessionFactory)this.getSessionFactory());
                pSDEWizardService.autoGet(pSDEWizard);
                this.psdewizard = pSDEWizard;
            }
            return this.psdewizard;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getCapPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCapPSLanRes();
        }
        if (this.getCapPSLanResId() == null) {
            return null;
        }
        Integer n = this.objCapPSLanResLock;
        synchronized (n) {
            if (this.cappslanres != null && DataTypeHelper.compare((int)25, (Object)this.getCapPSLanResId(), (Object)this.cappslanres.getPSLanguageResId()) != 0L) {
                this.cappslanres = null;
            }
            if (this.cappslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getCapPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet(pSLanguageRes);
                this.cappslanres = pSLanguageRes;
            }
            return this.cappslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPF getPSPF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPF();
        }
        if (this.getPSPFId() == null) {
            return null;
        }
        Integer n = this.objPSPFLock;
        synchronized (n) {
            if (this.pspf != null && DataTypeHelper.compare((int)25, (Object)this.getPSPFId(), (Object)this.pspf.getPSPFId()) != 0L) {
                this.pspf = null;
            }
            if (this.pspf == null) {
                PSPF pSPF = new PSPF();
                pSPF.setPSPFId(this.getPSPFId());
                PSPFService pSPFService = (PSPFService)ServiceGlobal.getService(PSPFService.class, (SessionFactory)this.getSessionFactory());
                pSPFService.autoGet(pSPF);
                this.pspf = pSPF;
            }
            return this.pspf;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysCalendar getPSSysCalendar() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCalendar();
        }
        if (this.getPSSysCalendarId() == null) {
            return null;
        }
        Integer n = this.objPSSysCalendarLock;
        synchronized (n) {
            if (this.pssyscalendar != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysCalendarId(), (Object)this.pssyscalendar.getPSSysCalendarId()) != 0L) {
                this.pssyscalendar = null;
            }
            if (this.pssyscalendar == null) {
                PSSysCalendar pSSysCalendar = new PSSysCalendar();
                pSSysCalendar.setPSSysCalendarId(this.getPSSysCalendarId());
                PSSysCalendarService pSSysCalendarService = (PSSysCalendarService)ServiceGlobal.getService(PSSysCalendarService.class, (SessionFactory)this.getSessionFactory());
                pSSysCalendarService.autoGet(pSSysCalendar);
                this.pssyscalendar = pSSysCalendar;
            }
            return this.pssyscalendar;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysCounter getPSSysCounter() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCounter();
        }
        if (this.getPSSysCounterId() == null) {
            return null;
        }
        Integer n = this.objPSSysCounterLock;
        synchronized (n) {
            if (this.pssyscounter != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysCounterId(), (Object)this.pssyscounter.getPSSysCounterId()) != 0L) {
                this.pssyscounter = null;
            }
            if (this.pssyscounter == null) {
                PSSysCounter pSSysCounter = new PSSysCounter();
                pSSysCounter.setPSSysCounterId(this.getPSSysCounterId());
                PSSysCounterService pSSysCounterService = (PSSysCounterService)ServiceGlobal.getService(PSSysCounterService.class, (SessionFactory)this.getSessionFactory());
                pSSysCounterService.autoGet(pSSysCounter);
                this.pssyscounter = pSSysCounter;
            }
            return this.pssyscounter;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysCss getPSSysCss() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCss();
        }
        if (this.getPSSysCssId() == null) {
            return null;
        }
        Integer n = this.objPSSysCssLock;
        synchronized (n) {
            if (this.pssyscss != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysCssId(), (Object)this.pssyscss.getPSSysCssId()) != 0L) {
                this.pssyscss = null;
            }
            if (this.pssyscss == null) {
                PSSysCss pSSysCss = new PSSysCss();
                pSSysCss.setPSSysCssId(this.getPSSysCssId());
                PSSysCssService pSSysCssService = (PSSysCssService)ServiceGlobal.getService(PSSysCssService.class, (SessionFactory)this.getSessionFactory());
                pSSysCssService.autoGet(pSSysCss);
                this.pssyscss = pSSysCss;
            }
            return this.pssyscss;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDashboard getPSSysDashboard() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDashboard();
        }
        if (this.getPSSysDashboardId() == null) {
            return null;
        }
        Integer n = this.objPSSysDashboardLock;
        synchronized (n) {
            if (this.pssysdashboard != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysDashboardId(), (Object)this.pssysdashboard.getPSSysDashboardId()) != 0L) {
                this.pssysdashboard = null;
            }
            if (this.pssysdashboard == null) {
                PSSysDashboard pSSysDashboard = new PSSysDashboard();
                pSSysDashboard.setPSSysDashboardId(this.getPSSysDashboardId());
                PSSysDashboardService pSSysDashboardService = (PSSysDashboardService)ServiceGlobal.getService(PSSysDashboardService.class, (SessionFactory)this.getSessionFactory());
                pSSysDashboardService.autoGet(pSSysDashboard);
                this.pssysdashboard = pSSysDashboard;
            }
            return this.pssysdashboard;
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
    public PSSysMapView getPSSysMapView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMapView();
        }
        if (this.getPSSysMapViewId() == null) {
            return null;
        }
        Integer n = this.objPSSysMapViewLock;
        synchronized (n) {
            if (this.pssysmapview != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysMapViewId(), (Object)this.pssysmapview.getPSSysMapViewId()) != 0L) {
                this.pssysmapview = null;
            }
            if (this.pssysmapview == null) {
                PSSysMapView pSSysMapView = new PSSysMapView();
                pSSysMapView.setPSSysMapViewId(this.getPSSysMapViewId());
                PSSysMapViewService pSSysMapViewService = (PSSysMapViewService)ServiceGlobal.getService(PSSysMapViewService.class, (SessionFactory)this.getSessionFactory());
                pSSysMapViewService.autoGet(pSSysMapView);
                this.pssysmapview = pSSysMapView;
            }
            return this.pssysmapview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysMsgTempl getPSSysMsgTempl() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMsgTempl();
        }
        if (this.getPSSysMsgTemplId() == null) {
            return null;
        }
        Integer n = this.objPSSysMsgTemplLock;
        synchronized (n) {
            if (this.pssysmsgtempl != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysMsgTemplId(), (Object)this.pssysmsgtempl.getPSSysMsgTemplId()) != 0L) {
                this.pssysmsgtempl = null;
            }
            if (this.pssysmsgtempl == null) {
                PSSysMsgTempl pSSysMsgTempl = new PSSysMsgTempl();
                pSSysMsgTempl.setPSSysMsgTemplId(this.getPSSysMsgTemplId());
                PSSysMsgTemplService pSSysMsgTemplService = (PSSysMsgTemplService)ServiceGlobal.getService(PSSysMsgTemplService.class, (SessionFactory)this.getSessionFactory());
                pSSysMsgTemplService.autoGet(pSSysMsgTempl);
                this.pssysmsgtempl = pSSysMsgTempl;
            }
            return this.pssysmsgtempl;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysPFPlugin getPSSysPFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPlugin();
        }
        if (this.getPSSysPFPluginId() == null) {
            return null;
        }
        Integer n = this.objPSSysPFPluginLock;
        synchronized (n) {
            if (this.pssyspfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysPFPluginId(), (Object)this.pssyspfplugin.getPSSysPFPluginId()) != 0L) {
                this.pssyspfplugin = null;
            }
            if (this.pssyspfplugin == null) {
                PSSysPFPlugin pSSysPFPlugin = new PSSysPFPlugin();
                pSSysPFPlugin.setPSSysPFPluginId(this.getPSSysPFPluginId());
                PSSysPFPluginService pSSysPFPluginService = (PSSysPFPluginService)ServiceGlobal.getService(PSSysPFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysPFPluginService.autoGet(pSSysPFPlugin);
                this.pssyspfplugin = pSSysPFPlugin;
            }
            return this.pssyspfplugin;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysSearchBar getPSSysSearchBar() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchBar();
        }
        if (this.getPSSysSearchBarId() == null) {
            return null;
        }
        Integer n = this.objPSSysSearchBarLock;
        synchronized (n) {
            if (this.pssyssearchbar != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysSearchBarId(), (Object)this.pssyssearchbar.getPSSysSearchBarId()) != 0L) {
                this.pssyssearchbar = null;
            }
            if (this.pssyssearchbar == null) {
                PSSysSearchBar pSSysSearchBar = new PSSysSearchBar();
                pSSysSearchBar.setPSSysSearchBarId(this.getPSSysSearchBarId());
                PSSysSearchBarService pSSysSearchBarService = (PSSysSearchBarService)ServiceGlobal.getService(PSSysSearchBarService.class, (SessionFactory)this.getSessionFactory());
                pSSysSearchBarService.autoGet(pSSysSearchBar);
                this.pssyssearchbar = pSSysSearchBar;
            }
            return this.pssyssearchbar;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysViewPanel getPSSysViewPanel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanel();
        }
        if (this.getPSSysViewPanelId() == null) {
            return null;
        }
        Integer n = this.objPSSysViewPanelLock;
        synchronized (n) {
            if (this.pssysviewpanel != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysViewPanelId(), (Object)this.pssysviewpanel.getPSSysViewPanelId()) != 0L) {
                this.pssysviewpanel = null;
            }
            if (this.pssysviewpanel == null) {
                PSSysViewPanel pSSysViewPanel = new PSSysViewPanel();
                pSSysViewPanel.setPSSysViewPanelId(this.getPSSysViewPanelId());
                PSSysViewPanelService pSSysViewPanelService = (PSSysViewPanelService)ServiceGlobal.getService(PSSysViewPanelService.class, (SessionFactory)this.getSessionFactory());
                pSSysViewPanelService.autoGet(pSSysViewPanel);
                this.pssysviewpanel = pSSysViewPanel;
            }
            return this.pssysviewpanel;
        }
    }

    private PSDEViewCtrlBase getProxyEntity() {
        return this.proxyPSDEViewCtrlBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEViewCtrlBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEViewCtrlBase) {
            this.proxyPSDEViewCtrlBase = (PSDEViewCtrlBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ADPSDELOGICID, 0);
        fieldIndexMap.put(FIELD_ADPSDELOGICNAME, 1);
        fieldIndexMap.put(FIELD_BOTTOMPOS, 2);
        fieldIndexMap.put(FIELD_BTNACTIONTYPE, 3);
        fieldIndexMap.put(FIELD_BUSYINDICATOR, 4);
        fieldIndexMap.put(FIELD_CAPPSLANRESID, 5);
        fieldIndexMap.put(FIELD_CAPPSLANRESNAME, 6);
        fieldIndexMap.put(FIELD_CAPTION, 7);
        fieldIndexMap.put(FIELD_CONFIGINFO, 8);
        fieldIndexMap.put(FIELD_CREATEDATE, 9);
        fieldIndexMap.put(FIELD_CREATEMAN, 10);
        fieldIndexMap.put(FIELD_CTRLPARAM, 11);
        fieldIndexMap.put(FIELD_CTRLPARAM10, 12);
        fieldIndexMap.put(FIELD_CTRLPARAM11, 13);
        fieldIndexMap.put(FIELD_CTRLPARAM12, 14);
        fieldIndexMap.put(FIELD_CTRLPARAM2, 15);
        fieldIndexMap.put(FIELD_CTRLPARAM3, 16);
        fieldIndexMap.put(FIELD_CTRLPARAM4, 17);
        fieldIndexMap.put(FIELD_CTRLPARAM5, 18);
        fieldIndexMap.put(FIELD_CTRLPARAM6, 19);
        fieldIndexMap.put(FIELD_CTRLPARAM7, 20);
        fieldIndexMap.put(FIELD_CTRLPARAM8, 21);
        fieldIndexMap.put(FIELD_CTRLPARAM9, 22);
        fieldIndexMap.put(FIELD_CTRLPARAMS, 23);
        fieldIndexMap.put(FIELD_CUSTOMCOND, 24);
        fieldIndexMap.put(FIELD_CUSTOMTYPE, 25);
        fieldIndexMap.put(FIELD_DEFAULTFLAG, 26);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 27);
        fieldIndexMap.put(FIELD_DYNCMODE, 28);
        fieldIndexMap.put(FIELD_ENABLEDYNASYS, 29);
        fieldIndexMap.put(FIELD_ENABLEITEMPRIV, 30);
        fieldIndexMap.put(FIELD_ENABLEVIEWACTIONS, 31);
        fieldIndexMap.put(FIELD_HEIGHT, 32);
        fieldIndexMap.put(FIELD_INSERTPOS, 33);
        fieldIndexMap.put(FIELD_LEFTPOS, 34);
        fieldIndexMap.put(FIELD_LOCALMODE, 35);
        fieldIndexMap.put(FIELD_MARGIN, 36);
        fieldIndexMap.put(FIELD_MEMO, 37);
        fieldIndexMap.put(FIELD_MULTISELECT, 38);
        fieldIndexMap.put(FIELD_NO2PSDEUAGROUPID, 39);
        fieldIndexMap.put(FIELD_NO2PSDEUAGROUPNAME, 40);
        fieldIndexMap.put(FIELD_NO3PSDEUAGROUPID, 41);
        fieldIndexMap.put(FIELD_NO3PSDEUAGROUPNAME, 42);
        fieldIndexMap.put(FIELD_NO4PSDEUAGROUPID, 43);
        fieldIndexMap.put(FIELD_NO4PSDEUAGROUPNAME, 44);
        fieldIndexMap.put(FIELD_NO5PSDEUAGROUPID, 45);
        fieldIndexMap.put(FIELD_NO5PSDEUAGROUPNAME, 46);
        fieldIndexMap.put(FIELD_NO6PSDEUAGROUPID, 47);
        fieldIndexMap.put(FIELD_NO6PSDEUAGROUPNAME, 48);
        fieldIndexMap.put(FIELD_ORDERVALUE, 49);
        fieldIndexMap.put(FIELD_PADDING, 50);
        fieldIndexMap.put(FIELD_PREDEFINEDTYPE, 51);
        fieldIndexMap.put(FIELD_PREDEFINEDTYPETEXT, 52);
        fieldIndexMap.put(FIELD_PSACHANDLERID, 53);
        fieldIndexMap.put(FIELD_PSACHANDLERNAME, 54);
        fieldIndexMap.put(FIELD_PSCTRLID, 55);
        fieldIndexMap.put(FIELD_PSCTRLLOGICGROUPID, 56);
        fieldIndexMap.put(FIELD_PSCTRLLOGICGROUPNAME, 57);
        fieldIndexMap.put(FIELD_PSCTRLMSGID, 58);
        fieldIndexMap.put(FIELD_PSCTRLMSGNAME, 59);
        fieldIndexMap.put(FIELD_PSCTRLNAME, 60);
        fieldIndexMap.put(FIELD_PSDEACTIONID, 61);
        fieldIndexMap.put(FIELD_PSDEACTIONNAME, 62);
        fieldIndexMap.put(FIELD_PSDECHARTID, 63);
        fieldIndexMap.put(FIELD_PSDECHARTNAME, 64);
        fieldIndexMap.put(FIELD_PSDEDATAEXPID, 65);
        fieldIndexMap.put(FIELD_PSDEDATAEXPNAME, 66);
        fieldIndexMap.put(FIELD_PSDEDATAIMPID, 67);
        fieldIndexMap.put(FIELD_PSDEDATAIMPNAME, 68);
        fieldIndexMap.put(FIELD_PSDEDATASETID, 69);
        fieldIndexMap.put(FIELD_PSDEDATASETNAME, 70);
        fieldIndexMap.put(FIELD_PSDEDATAVIEWID, 71);
        fieldIndexMap.put(FIELD_PSDEDATAVIEWNAME, 72);
        fieldIndexMap.put(FIELD_PSDEDRID, 73);
        fieldIndexMap.put(FIELD_PSDEDRNAME, 74);
        fieldIndexMap.put(FIELD_PSDEFORMID, 75);
        fieldIndexMap.put(FIELD_PSDEFORMNAME, 76);
        fieldIndexMap.put(FIELD_PSDEGRIDID, 77);
        fieldIndexMap.put(FIELD_PSDEGRIDNAME, 78);
        fieldIndexMap.put(FIELD_PSDEID, 79);
        fieldIndexMap.put(FIELD_PSDELISTID, 80);
        fieldIndexMap.put(FIELD_PSDELISTNAME, 81);
        fieldIndexMap.put(FIELD_PSDENAME, 82);
        fieldIndexMap.put(FIELD_PSDEOPPRIVID, 83);
        fieldIndexMap.put(FIELD_PSDEOPPRIVNAME, 84);
        fieldIndexMap.put(FIELD_PSDEREPORTID, 85);
        fieldIndexMap.put(FIELD_PSDEREPORTNAME, 86);
        fieldIndexMap.put(FIELD_PSDETOOLBARID, 87);
        fieldIndexMap.put(FIELD_PSDETOOLBARNAME, 88);
        fieldIndexMap.put(FIELD_PSDETREEVIEWID, 89);
        fieldIndexMap.put(FIELD_PSDETREEVIEWNAME, 90);
        fieldIndexMap.put(FIELD_PSDEUAGROUPID, 91);
        fieldIndexMap.put(FIELD_PSDEUAGROUPNAME, 92);
        fieldIndexMap.put(FIELD_PSDEVIEWBASEID, 93);
        fieldIndexMap.put(FIELD_PSDEVIEWBASENAME, 94);
        fieldIndexMap.put(FIELD_PSDEVIEWCTRLID, 95);
        fieldIndexMap.put(FIELD_PSDEVIEWCTRLNAME, 96);
        fieldIndexMap.put(FIELD_PSDEVIEWCTRLTYPE, 97);
        fieldIndexMap.put(FIELD_PSDEVIEWID, 98);
        fieldIndexMap.put(FIELD_PSDEVIEWNAME, 99);
        fieldIndexMap.put(FIELD_PSDEWIZARDID, 100);
        fieldIndexMap.put(FIELD_PSDEWIZARDNAME, 101);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 102);
        fieldIndexMap.put(FIELD_PSPFID, 103);
        fieldIndexMap.put(FIELD_PSPFNAME, 104);
        fieldIndexMap.put(FIELD_PSSYSCALENDARID, 105);
        fieldIndexMap.put(FIELD_PSSYSCALENDARNAME, 106);
        fieldIndexMap.put(FIELD_PSSYSCOUNTERID, 107);
        fieldIndexMap.put(FIELD_PSSYSCOUNTERNAME, 108);
        fieldIndexMap.put(FIELD_PSSYSCSSID, 109);
        fieldIndexMap.put(FIELD_PSSYSCSSNAME, 110);
        fieldIndexMap.put(FIELD_PSSYSDASHBOARDID, 111);
        fieldIndexMap.put(FIELD_PSSYSDASHBOARDNAME, 112);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 113);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 114);
        fieldIndexMap.put(FIELD_PSSYSIMAGEID, 115);
        fieldIndexMap.put(FIELD_PSSYSIMAGENAME, 116);
        fieldIndexMap.put(FIELD_PSSYSMAPVIEWID, 117);
        fieldIndexMap.put(FIELD_PSSYSMAPVIEWNAME, 118);
        fieldIndexMap.put(FIELD_PSSYSMSGTEMPLID, 119);
        fieldIndexMap.put(FIELD_PSSYSMSGTEMPLNAME, 120);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 121);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 122);
        fieldIndexMap.put(FIELD_PSSYSSEARCHBARID, 123);
        fieldIndexMap.put(FIELD_PSSYSSEARCHBARNAME, 124);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 125);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELID, 126);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELNAME, 127);
        fieldIndexMap.put(FIELD_READONLYMODE, 128);
        fieldIndexMap.put(FIELD_REFCTRL2NAME, 129);
        fieldIndexMap.put(FIELD_REFCTRL2USAGE, 130);
        fieldIndexMap.put(FIELD_REFCTRL2USAGETEXT, 131);
        fieldIndexMap.put(FIELD_REFCTRLNAME, 132);
        fieldIndexMap.put(FIELD_REFCTRLUSAGE, 133);
        fieldIndexMap.put(FIELD_REFCTRLUSAGETEXT, 134);
        fieldIndexMap.put(FIELD_RIGHTPOS, 135);
        fieldIndexMap.put(FIELD_SUBPSACHANDLERID, 136);
        fieldIndexMap.put(FIELD_SUBPSACHANDLERNAME, 137);
        fieldIndexMap.put(FIELD_TOPPOS, 138);
        fieldIndexMap.put(FIELD_UPDATEDATE, 139);
        fieldIndexMap.put(FIELD_UPDATEMAN, 140);
        fieldIndexMap.put(FIELD_USERTAG, 141);
        fieldIndexMap.put(FIELD_USERTAG2, 142);
        fieldIndexMap.put(FIELD_VALIDFLAG, 143);
        fieldIndexMap.put(FIELD_WIDTH, 144);
    }
}

