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
package net.ibizsys.pscore.srv.sysdesign.entity;

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
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenu;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppView;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewService;
import net.ibizsys.pscore.srv.config.entity.PSPortlet;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.service.PSPortletService;
import net.ibizsys.pscore.srv.config.service.PSSysPFPluginService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEChart;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataView;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEForm;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEList;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEReport;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbar;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEReportService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSACHandler;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCalendar;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMapView;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysPortletCat;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMapViewService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPortletCatService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUniResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysPortletBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysPortletBase.class);
    public static final String FIELD_ADPSDELOGICID = "ADPSDELOGICID";
    public static final String FIELD_ADPSDELOGICNAME = "ADPSDELOGICNAME";
    public static final String FIELD_BASECLSPARAMS = "BASECLSPARAMS";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DASHBOARDSCOPE = "DASHBOARDSCOPE";
    public static final String FIELD_EMPTYTEXT = "EMPTYTEXT";
    public static final String FIELD_EMPTYTEXTPSLANRESID = "EMPTYTEXTPSLANRESID";
    public static final String FIELD_EMPTYTEXTPSLANRESNAME = "EMPTYTEXTPSLANRESNAME";
    public static final String FIELD_FILTERPSDEDSID = "FILTERPSDEDSID";
    public static final String FIELD_FILTERPSDEDSNAME = "FILTERPSDEDSNAME";
    public static final String FIELD_GROUPEXTRACTMODE = "GROUPEXTRACTMODE";
    public static final String FIELD_HEIGHT = "HEIGHT";
    public static final String FIELD_HTMLSHOWMODE = "HTMLSHOWMODE";
    public static final String FIELD_HTMLURL = "HTMLURL";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PORTLETPARAMS = "PORTLETPARAMS";
    public static final String FIELD_PORTLETSTYLE = "PORTLETSTYLE";
    public static final String FIELD_PORTLETTYPE = "PORTLETTYPE";
    public static final String FIELD_PSACHANDLERID = "PSACHANDLERID";
    public static final String FIELD_PSACHANDLERNAME = "PSACHANDLERNAME";
    public static final String FIELD_PSAPPMENUID = "PSAPPMENUID";
    public static final String FIELD_PSAPPMENUNAME = "PSAPPMENUNAME";
    public static final String FIELD_PSAPPVIEWID = "PSAPPVIEWID";
    public static final String FIELD_PSAPPVIEWNAME = "PSAPPVIEWNAME";
    public static final String FIELD_PSDECHARTID = "PSDECHARTID";
    public static final String FIELD_PSDECHARTNAME = "PSDECHARTNAME";
    public static final String FIELD_PSDEDATAVIEWID = "PSDEDATAVIEWID";
    public static final String FIELD_PSDEDATAVIEWNAME = "PSDEDATAVIEWNAME";
    public static final String FIELD_PSDEDSID = "PSDEDSID";
    public static final String FIELD_PSDEDSNAME = "PSDEDSNAME";
    public static final String FIELD_PSDEFORMID = "PSDEFORMID";
    public static final String FIELD_PSDEFORMNAME = "PSDEFORMNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDELISTID = "PSDELISTID";
    public static final String FIELD_PSDELISTNAME = "PSDELISTNAME";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDEREPORTID = "PSDEREPORTID";
    public static final String FIELD_PSDEREPORTNAME = "PSDEREPORTNAME";
    public static final String FIELD_PSDETOOLBARID = "PSDETOOLBARID";
    public static final String FIELD_PSDETOOLBARNAME = "PSDETOOLBARNAME";
    public static final String FIELD_PSDEUAGROUPID = "PSDEUAGROUPID";
    public static final String FIELD_PSDEUAGROUPNAME = "PSDEUAGROUPNAME";
    public static final String FIELD_PSDEVIEWID = "PSDEVIEWID";
    public static final String FIELD_PSDEVIEWNAME = "PSDEVIEWNAME";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSPORTLETID = "PSPORTLETID";
    public static final String FIELD_PSPORTLETNAME = "PSPORTLETNAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_PSSYSCALENDARID = "PSSYSCALENDARID";
    public static final String FIELD_PSSYSCALENDARNAME = "PSSYSCALENDARNAME";
    public static final String FIELD_PSSYSCSSID = "PSSYSCSSID";
    public static final String FIELD_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String FIELD_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String FIELD_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String FIELD_PSSYSMAPVIEWID = "PSSYSMAPVIEWID";
    public static final String FIELD_PSSYSMAPVIEWNAME = "PSSYSMAPVIEWNAME";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_PSSYSPORTLETCATID = "PSSYSPORTLETCATID";
    public static final String FIELD_PSSYSPORTLETCATNAME = "PSSYSPORTLETCATNAME";
    public static final String FIELD_PSSYSPORTLETID = "PSSYSPORTLETID";
    public static final String FIELD_PSSYSPORTLETNAME = "PSSYSPORTLETNAME";
    public static final String FIELD_PSSYSREQITEMID = "PSSYSREQITEMID";
    public static final String FIELD_PSSYSREQITEMNAME = "PSSYSREQITEMNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSSYSUNIRESID = "PSSYSUNIRESID";
    public static final String FIELD_PSSYSUNIRESNAME = "PSSYSUNIRESNAME";
    public static final String FIELD_PSSYSVIEWPANELID = "PSSYSVIEWPANELID";
    public static final String FIELD_PSSYSVIEWPANELNAME = "PSSYSVIEWPANELNAME";
    public static final String FIELD_RELOADTIMER = "RELOADTIMER";
    public static final String FIELD_SHOWTITLEBAR = "SHOWTITLEBAR";
    public static final String FIELD_SYSAPPFLAG = "SYSAPPFLAG";
    public static final String FIELD_TEMPLENGINE = "TEMPLENGINE";
    public static final String FIELD_TITLEPSLANRESID = "TITLEPSLANRESID";
    public static final String FIELD_TITLEPSLANRESNAME = "TITLEPSLANRESNAME";
    public static final String FIELD_TITLEPSSYSPFPLUGINID = "TITLEPSSYSPFPLUGINID";
    public static final String FIELD_TITLEPSSYSPFPLUGINNAME = "TITLEPSSYSPFPLUGINNAME";
    public static final String FIELD_TODOTASK = "TODOTASK";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    private static final int INDEX_ADPSDELOGICID = 0;
    private static final int INDEX_ADPSDELOGICNAME = 1;
    private static final int INDEX_BASECLSPARAMS = 2;
    private static final int INDEX_CODENAME = 3;
    private static final int INDEX_CREATEDATE = 4;
    private static final int INDEX_CREATEMAN = 5;
    private static final int INDEX_DASHBOARDSCOPE = 6;
    private static final int INDEX_EMPTYTEXT = 7;
    private static final int INDEX_EMPTYTEXTPSLANRESID = 8;
    private static final int INDEX_EMPTYTEXTPSLANRESNAME = 9;
    private static final int INDEX_FILTERPSDEDSID = 10;
    private static final int INDEX_FILTERPSDEDSNAME = 11;
    private static final int INDEX_GROUPEXTRACTMODE = 12;
    private static final int INDEX_HEIGHT = 13;
    private static final int INDEX_HTMLSHOWMODE = 14;
    private static final int INDEX_HTMLURL = 15;
    private static final int INDEX_LOCKFLAG = 16;
    private static final int INDEX_LOGICNAME = 17;
    private static final int INDEX_MEMO = 18;
    private static final int INDEX_PORTLETPARAMS = 19;
    private static final int INDEX_PORTLETSTYLE = 20;
    private static final int INDEX_PORTLETTYPE = 21;
    private static final int INDEX_PSACHANDLERID = 22;
    private static final int INDEX_PSACHANDLERNAME = 23;
    private static final int INDEX_PSAPPMENUID = 24;
    private static final int INDEX_PSAPPMENUNAME = 25;
    private static final int INDEX_PSAPPVIEWID = 26;
    private static final int INDEX_PSAPPVIEWNAME = 27;
    private static final int INDEX_PSDECHARTID = 28;
    private static final int INDEX_PSDECHARTNAME = 29;
    private static final int INDEX_PSDEDATAVIEWID = 30;
    private static final int INDEX_PSDEDATAVIEWNAME = 31;
    private static final int INDEX_PSDEDSID = 32;
    private static final int INDEX_PSDEDSNAME = 33;
    private static final int INDEX_PSDEFORMID = 34;
    private static final int INDEX_PSDEFORMNAME = 35;
    private static final int INDEX_PSDEID = 36;
    private static final int INDEX_PSDELISTID = 37;
    private static final int INDEX_PSDELISTNAME = 38;
    private static final int INDEX_PSDENAME = 39;
    private static final int INDEX_PSDEREPORTID = 40;
    private static final int INDEX_PSDEREPORTNAME = 41;
    private static final int INDEX_PSDETOOLBARID = 42;
    private static final int INDEX_PSDETOOLBARNAME = 43;
    private static final int INDEX_PSDEUAGROUPID = 44;
    private static final int INDEX_PSDEUAGROUPNAME = 45;
    private static final int INDEX_PSDEVIEWID = 46;
    private static final int INDEX_PSDEVIEWNAME = 47;
    private static final int INDEX_PSMODULEID = 48;
    private static final int INDEX_PSMODULENAME = 49;
    private static final int INDEX_PSPORTLETID = 50;
    private static final int INDEX_PSPORTLETNAME = 51;
    private static final int INDEX_PSSYSAPPID = 52;
    private static final int INDEX_PSSYSAPPNAME = 53;
    private static final int INDEX_PSSYSCALENDARID = 54;
    private static final int INDEX_PSSYSCALENDARNAME = 55;
    private static final int INDEX_PSSYSCSSID = 56;
    private static final int INDEX_PSSYSCSSNAME = 57;
    private static final int INDEX_PSSYSIMAGEID = 58;
    private static final int INDEX_PSSYSIMAGENAME = 59;
    private static final int INDEX_PSSYSMAPVIEWID = 60;
    private static final int INDEX_PSSYSMAPVIEWNAME = 61;
    private static final int INDEX_PSSYSPFPLUGINID = 62;
    private static final int INDEX_PSSYSPFPLUGINNAME = 63;
    private static final int INDEX_PSSYSPORTLETCATID = 64;
    private static final int INDEX_PSSYSPORTLETCATNAME = 65;
    private static final int INDEX_PSSYSPORTLETID = 66;
    private static final int INDEX_PSSYSPORTLETNAME = 67;
    private static final int INDEX_PSSYSREQITEMID = 68;
    private static final int INDEX_PSSYSREQITEMNAME = 69;
    private static final int INDEX_PSSYSTEMID = 70;
    private static final int INDEX_PSSYSTEMNAME = 71;
    private static final int INDEX_PSSYSUNIRESID = 72;
    private static final int INDEX_PSSYSUNIRESNAME = 73;
    private static final int INDEX_PSSYSVIEWPANELID = 74;
    private static final int INDEX_PSSYSVIEWPANELNAME = 75;
    private static final int INDEX_RELOADTIMER = 76;
    private static final int INDEX_SHOWTITLEBAR = 77;
    private static final int INDEX_SYSAPPFLAG = 78;
    private static final int INDEX_TEMPLENGINE = 79;
    private static final int INDEX_TITLEPSLANRESID = 80;
    private static final int INDEX_TITLEPSLANRESNAME = 81;
    private static final int INDEX_TITLEPSSYSPFPLUGINID = 82;
    private static final int INDEX_TITLEPSSYSPFPLUGINNAME = 83;
    private static final int INDEX_TODOTASK = 84;
    private static final int INDEX_UPDATEDATE = 85;
    private static final int INDEX_UPDATEMAN = 86;
    private static final int INDEX_USERTAG = 87;
    private static final int INDEX_USERTAG2 = 88;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysPortletBase proxyPSSysPortletBase = null;
    private boolean adpsdelogicidDirtyFlag = false;
    private boolean adpsdelogicnameDirtyFlag = false;
    private boolean baseclsparamsDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dashboardscopeDirtyFlag = false;
    private boolean emptytextDirtyFlag = false;
    private boolean emptytextpslanresidDirtyFlag = false;
    private boolean emptytextpslanresnameDirtyFlag = false;
    private boolean filterpsdedsidDirtyFlag = false;
    private boolean filterpsdedsnameDirtyFlag = false;
    private boolean groupextractmodeDirtyFlag = false;
    private boolean heightDirtyFlag = false;
    private boolean htmlshowmodeDirtyFlag = false;
    private boolean htmlurlDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean portletparamsDirtyFlag = false;
    private boolean portletstyleDirtyFlag = false;
    private boolean portlettypeDirtyFlag = false;
    private boolean psachandleridDirtyFlag = false;
    private boolean psachandlernameDirtyFlag = false;
    private boolean psappmenuidDirtyFlag = false;
    private boolean psappmenunameDirtyFlag = false;
    private boolean psappviewidDirtyFlag = false;
    private boolean psappviewnameDirtyFlag = false;
    private boolean psdechartidDirtyFlag = false;
    private boolean psdechartnameDirtyFlag = false;
    private boolean psdedataviewidDirtyFlag = false;
    private boolean psdedataviewnameDirtyFlag = false;
    private boolean psdedsidDirtyFlag = false;
    private boolean psdedsnameDirtyFlag = false;
    private boolean psdeformidDirtyFlag = false;
    private boolean psdeformnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdelistidDirtyFlag = false;
    private boolean psdelistnameDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdereportidDirtyFlag = false;
    private boolean psdereportnameDirtyFlag = false;
    private boolean psdetoolbaridDirtyFlag = false;
    private boolean psdetoolbarnameDirtyFlag = false;
    private boolean psdeuagroupidDirtyFlag = false;
    private boolean psdeuagroupnameDirtyFlag = false;
    private boolean psdeviewidDirtyFlag = false;
    private boolean psdeviewnameDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean psportletidDirtyFlag = false;
    private boolean psportletnameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean pssyscalendaridDirtyFlag = false;
    private boolean pssyscalendarnameDirtyFlag = false;
    private boolean pssyscssidDirtyFlag = false;
    private boolean pssyscssnameDirtyFlag = false;
    private boolean pssysimageidDirtyFlag = false;
    private boolean pssysimagenameDirtyFlag = false;
    private boolean pssysmapviewidDirtyFlag = false;
    private boolean pssysmapviewnameDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean pssysportletcatidDirtyFlag = false;
    private boolean pssysportletcatnameDirtyFlag = false;
    private boolean pssysportletidDirtyFlag = false;
    private boolean pssysportletnameDirtyFlag = false;
    private boolean pssysreqitemidDirtyFlag = false;
    private boolean pssysreqitemnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean pssysuniresidDirtyFlag = false;
    private boolean pssysuniresnameDirtyFlag = false;
    private boolean pssysviewpanelidDirtyFlag = false;
    private boolean pssysviewpanelnameDirtyFlag = false;
    private boolean reloadtimerDirtyFlag = false;
    private boolean showtitlebarDirtyFlag = false;
    private boolean sysappflagDirtyFlag = false;
    private boolean templengineDirtyFlag = false;
    private boolean titlepslanresidDirtyFlag = false;
    private boolean titlepslanresnameDirtyFlag = false;
    private boolean titlepssyspfpluginidDirtyFlag = false;
    private boolean titlepssyspfpluginnameDirtyFlag = false;
    private boolean todotaskDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    @Column(name="adpsdelogicid")
    private String adpsdelogicid;
    @Column(name="adpsdelogicname")
    private String adpsdelogicname;
    @Column(name="baseclsparams")
    private String baseclsparams;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dashboardscope")
    private Integer dashboardscope;
    @Column(name="emptytext")
    private String emptytext;
    @Column(name="emptytextpslanresid")
    private String emptytextpslanresid;
    @Column(name="emptytextpslanresname")
    private String emptytextpslanresname;
    @Column(name="filterpsdedsid")
    private String filterpsdedsid;
    @Column(name="filterpsdedsname")
    private String filterpsdedsname;
    @Column(name="groupextractmode")
    private String groupextractmode;
    @Column(name="height")
    private Integer height;
    @Column(name="htmlshowmode")
    private String htmlshowmode;
    @Column(name="htmlurl")
    private String htmlurl;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="portletparams")
    private String portletparams;
    @Column(name="portletstyle")
    private String portletstyle;
    @Column(name="portlettype")
    private String portlettype;
    @Column(name="psachandlerid")
    private String psachandlerid;
    @Column(name="psachandlername")
    private String psachandlername;
    @Column(name="psappmenuid")
    private String psappmenuid;
    @Column(name="psappmenuname")
    private String psappmenuname;
    @Column(name="psappviewid")
    private String psappviewid;
    @Column(name="psappviewname")
    private String psappviewname;
    @Column(name="psdechartid")
    private String psdechartid;
    @Column(name="psdechartname")
    private String psdechartname;
    @Column(name="psdedataviewid")
    private String psdedataviewid;
    @Column(name="psdedataviewname")
    private String psdedataviewname;
    @Column(name="psdedsid")
    private String psdedsid;
    @Column(name="psdedsname")
    private String psdedsname;
    @Column(name="psdeformid")
    private String psdeformid;
    @Column(name="psdeformname")
    private String psdeformname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdelistid")
    private String psdelistid;
    @Column(name="psdelistname")
    private String psdelistname;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdereportid")
    private String psdereportid;
    @Column(name="psdereportname")
    private String psdereportname;
    @Column(name="psdetoolbarid")
    private String psdetoolbarid;
    @Column(name="psdetoolbarname")
    private String psdetoolbarname;
    @Column(name="psdeuagroupid")
    private String psdeuagroupid;
    @Column(name="psdeuagroupname")
    private String psdeuagroupname;
    @Column(name="psdeviewid")
    private String psdeviewid;
    @Column(name="psdeviewname")
    private String psdeviewname;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="psportletid")
    private String psportletid;
    @Column(name="psportletname")
    private String psportletname;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysappname")
    private String pssysappname;
    @Column(name="pssyscalendarid")
    private String pssyscalendarid;
    @Column(name="pssyscalendarname")
    private String pssyscalendarname;
    @Column(name="pssyscssid")
    private String pssyscssid;
    @Column(name="pssyscssname")
    private String pssyscssname;
    @Column(name="pssysimageid")
    private String pssysimageid;
    @Column(name="pssysimagename")
    private String pssysimagename;
    @Column(name="pssysmapviewid")
    private String pssysmapviewid;
    @Column(name="pssysmapviewname")
    private String pssysmapviewname;
    @Column(name="pssyspfpluginid")
    private String pssyspfpluginid;
    @Column(name="pssyspfpluginname")
    private String pssyspfpluginname;
    @Column(name="pssysportletcatid")
    private String pssysportletcatid;
    @Column(name="pssysportletcatname")
    private String pssysportletcatname;
    @Column(name="pssysportletid")
    private String pssysportletid;
    @Column(name="pssysportletname")
    private String pssysportletname;
    @Column(name="pssysreqitemid")
    private String pssysreqitemid;
    @Column(name="pssysreqitemname")
    private String pssysreqitemname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="pssysuniresid")
    private String pssysuniresid;
    @Column(name="pssysuniresname")
    private String pssysuniresname;
    @Column(name="pssysviewpanelid")
    private String pssysviewpanelid;
    @Column(name="pssysviewpanelname")
    private String pssysviewpanelname;
    @Column(name="reloadtimer")
    private Integer reloadtimer;
    @Column(name="showtitlebar")
    private Integer showtitlebar;
    @Column(name="sysappflag")
    private Integer sysappflag;
    @Column(name="templengine")
    private String templengine;
    @Column(name="titlepslanresid")
    private String titlepslanresid;
    @Column(name="titlepslanresname")
    private String titlepslanresname;
    @Column(name="titlepssyspfpluginid")
    private String titlepssyspfpluginid;
    @Column(name="titlepssyspfpluginname")
    private String titlepssyspfpluginname;
    @Column(name="todotask")
    private String todotask;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    private Integer objPSACHandlerLock = new Integer(1);
    private PSACHandler psachandler = null;
    private Integer objPSAppMenuLock = new Integer(1);
    private PSAppMenu psappmenu = null;
    private Integer objPSAppViewLock = new Integer(1);
    private PSAppView psappview = null;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSDEChartLock = new Integer(1);
    private PSDEChart psdechart = null;
    private Integer objFilterPSDEDSLock = new Integer(1);
    private PSDEDataSet filterpsdeds = null;
    private Integer objPSDEDSLock = new Integer(1);
    private PSDEDataSet psdeds = null;
    private Integer objPSDEDataViewLock = new Integer(1);
    private PSDEDataView psdedataview = null;
    private Integer objPSDEFormLock = new Integer(1);
    private PSDEForm psdeform = null;
    private Integer objPSDEListLock = new Integer(1);
    private PSDEList psdelist = null;
    private Integer objADPSDElogicLock = new Integer(1);
    private PSDELogic adpsdelogic = null;
    private Integer objPSDEReportLock = new Integer(1);
    private PSDEReport psdereport = null;
    private Integer objPSDEToolbarLock = new Integer(1);
    private PSDEToolbar psdetoolbar = null;
    private Integer objPSDEUAGroupLock = new Integer(1);
    private PSDEUAGroup psdeuagroup = null;
    private Integer objPSDEViewLock = new Integer(1);
    private PSDEViewBase psdeview = null;
    private Integer objEmptyTextPSLanResLock = new Integer(1);
    private PSLanguageRes emptytextpslanres = null;
    private Integer objTitlePSLanResLock = new Integer(1);
    private PSLanguageRes titlepslanres = null;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSPortletLock = new Integer(1);
    private PSPortlet psportlet = null;
    private Integer objPSSysAppLock = new Integer(1);
    private PSSysApp pssysapp = null;
    private Integer objPSSysCalendarLock = new Integer(1);
    private PSSysCalendar pssyscalendar = null;
    private Integer objPSSysCssLock = new Integer(1);
    private PSSysCss pssyscss = null;
    private Integer objPSSysImageLock = new Integer(1);
    private PSSysImage pssysimage = null;
    private Integer objPSSysMapViewLock = new Integer(1);
    private PSSysMapView pssysmapview = null;
    private Integer objPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin pssyspfplugin = null;
    private Integer objTitlePSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin titlepssyspfplugin = null;
    private Integer objPSSysPortletCatLock = new Integer(1);
    private PSSysPortletCat pssysportletcat = null;
    private Integer objPSSysReqItemLock = new Integer(1);
    private PSSysReqItem pssysreqitem = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSSysUniResLock = new Integer(1);
    private PSSysUniRes pssysunires = null;
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

    public void setDashboardScope(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDashboardScope(n);
            return;
        }
        this.dashboardscope = n;
        this.dashboardscopeDirtyFlag = true;
    }

    public Integer getDashboardScope() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDashboardScope();
        }
        return this.dashboardscope;
    }

    public boolean isDashboardScopeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDashboardScopeDirty();
        }
        return this.dashboardscopeDirtyFlag;
    }

    public void resetDashboardScope() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDashboardScope();
            return;
        }
        this.dashboardscopeDirtyFlag = false;
        this.dashboardscope = null;
    }

    public void setEmptyText(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEmptyText(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.emptytext = string;
        this.emptytextDirtyFlag = true;
    }

    public String getEmptyText() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEmptyText();
        }
        return this.emptytext;
    }

    public boolean isEmptyTextDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEmptyTextDirty();
        }
        return this.emptytextDirtyFlag;
    }

    public void resetEmptyText() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEmptyText();
            return;
        }
        this.emptytextDirtyFlag = false;
        this.emptytext = null;
    }

    public void setEmptyTextPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEmptyTextPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.emptytextpslanresid = string;
        this.emptytextpslanresidDirtyFlag = true;
    }

    public String getEmptyTextPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEmptyTextPSLanResId();
        }
        return this.emptytextpslanresid;
    }

    public boolean isEmptyTextPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEmptyTextPSLanResIdDirty();
        }
        return this.emptytextpslanresidDirtyFlag;
    }

    public void resetEmptyTextPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEmptyTextPSLanResId();
            return;
        }
        this.emptytextpslanresidDirtyFlag = false;
        this.emptytextpslanresid = null;
    }

    public void setEmptyTextPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEmptyTextPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.emptytextpslanresname = string;
        this.emptytextpslanresnameDirtyFlag = true;
    }

    public String getEmptyTextPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEmptyTextPSLanResName();
        }
        return this.emptytextpslanresname;
    }

    public boolean isEmptyTextPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEmptyTextPSLanResNameDirty();
        }
        return this.emptytextpslanresnameDirtyFlag;
    }

    public void resetEmptyTextPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEmptyTextPSLanResName();
            return;
        }
        this.emptytextpslanresnameDirtyFlag = false;
        this.emptytextpslanresname = null;
    }

    public void setFilterPSDEDSId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFilterPSDEDSId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.filterpsdedsid = string;
        this.filterpsdedsidDirtyFlag = true;
    }

    public String getFilterPSDEDSId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFilterPSDEDSId();
        }
        return this.filterpsdedsid;
    }

    public boolean isFilterPSDEDSIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFilterPSDEDSIdDirty();
        }
        return this.filterpsdedsidDirtyFlag;
    }

    public void resetFilterPSDEDSId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFilterPSDEDSId();
            return;
        }
        this.filterpsdedsidDirtyFlag = false;
        this.filterpsdedsid = null;
    }

    public void setFilterPSDEDSName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFilterPSDEDSName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.filterpsdedsname = string;
        this.filterpsdedsnameDirtyFlag = true;
    }

    public String getFilterPSDEDSName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFilterPSDEDSName();
        }
        return this.filterpsdedsname;
    }

    public boolean isFilterPSDEDSNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFilterPSDEDSNameDirty();
        }
        return this.filterpsdedsnameDirtyFlag;
    }

    public void resetFilterPSDEDSName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFilterPSDEDSName();
            return;
        }
        this.filterpsdedsnameDirtyFlag = false;
        this.filterpsdedsname = null;
    }

    public void setGroupExtractMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupExtractMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.groupextractmode = string;
        this.groupextractmodeDirtyFlag = true;
    }

    public String getGroupExtractMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupExtractMode();
        }
        return this.groupextractmode;
    }

    public boolean isGroupExtractModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupExtractModeDirty();
        }
        return this.groupextractmodeDirtyFlag;
    }

    public void resetGroupExtractMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupExtractMode();
            return;
        }
        this.groupextractmodeDirtyFlag = false;
        this.groupextractmode = null;
    }

    public void setHeight(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHeight(n);
            return;
        }
        this.height = n;
        this.heightDirtyFlag = true;
    }

    public Integer getHeight() {
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

    public void setHtmlShowMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHtmlShowMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.htmlshowmode = string;
        this.htmlshowmodeDirtyFlag = true;
    }

    public String getHtmlShowMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHtmlShowMode();
        }
        return this.htmlshowmode;
    }

    public boolean isHtmlShowModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHtmlShowModeDirty();
        }
        return this.htmlshowmodeDirtyFlag;
    }

    public void resetHtmlShowMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHtmlShowMode();
            return;
        }
        this.htmlshowmodeDirtyFlag = false;
        this.htmlshowmode = null;
    }

    public void setHtmlUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHtmlUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.htmlurl = string;
        this.htmlurlDirtyFlag = true;
    }

    public String getHtmlUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHtmlUrl();
        }
        return this.htmlurl;
    }

    public boolean isHtmlUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHtmlUrlDirty();
        }
        return this.htmlurlDirtyFlag;
    }

    public void resetHtmlUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHtmlUrl();
            return;
        }
        this.htmlurlDirtyFlag = false;
        this.htmlurl = null;
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

    public void setPortletParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPortletParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.portletparams = string;
        this.portletparamsDirtyFlag = true;
    }

    public String getPortletParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPortletParams();
        }
        return this.portletparams;
    }

    public boolean isPortletParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPortletParamsDirty();
        }
        return this.portletparamsDirtyFlag;
    }

    public void resetPortletParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPortletParams();
            return;
        }
        this.portletparamsDirtyFlag = false;
        this.portletparams = null;
    }

    public void setPortletStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPortletStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.portletstyle = string;
        this.portletstyleDirtyFlag = true;
    }

    public String getPortletStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPortletStyle();
        }
        return this.portletstyle;
    }

    public boolean isPortletStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPortletStyleDirty();
        }
        return this.portletstyleDirtyFlag;
    }

    public void resetPortletStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPortletStyle();
            return;
        }
        this.portletstyleDirtyFlag = false;
        this.portletstyle = null;
    }

    public void setPortletType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPortletType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.portlettype = string;
        this.portlettypeDirtyFlag = true;
    }

    public String getPortletType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPortletType();
        }
        return this.portlettype;
    }

    public boolean isPortletTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPortletTypeDirty();
        }
        return this.portlettypeDirtyFlag;
    }

    public void resetPortletType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPortletType();
            return;
        }
        this.portlettypeDirtyFlag = false;
        this.portlettype = null;
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

    public void setPSAppMenuId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppMenuId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappmenuid = string;
        this.psappmenuidDirtyFlag = true;
    }

    public String getPSAppMenuId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppMenuId();
        }
        return this.psappmenuid;
    }

    public boolean isPSAppMenuIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppMenuIdDirty();
        }
        return this.psappmenuidDirtyFlag;
    }

    public void resetPSAppMenuId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppMenuId();
            return;
        }
        this.psappmenuidDirtyFlag = false;
        this.psappmenuid = null;
    }

    public void setPSAppMenuName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppMenuName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappmenuname = string;
        this.psappmenunameDirtyFlag = true;
    }

    public String getPSAppMenuName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppMenuName();
        }
        return this.psappmenuname;
    }

    public boolean isPSAppMenuNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppMenuNameDirty();
        }
        return this.psappmenunameDirtyFlag;
    }

    public void resetPSAppMenuName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppMenuName();
            return;
        }
        this.psappmenunameDirtyFlag = false;
        this.psappmenuname = null;
    }

    public void setPSAppViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappviewid = string;
        this.psappviewidDirtyFlag = true;
    }

    public String getPSAppViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppViewId();
        }
        return this.psappviewid;
    }

    public boolean isPSAppViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppViewIdDirty();
        }
        return this.psappviewidDirtyFlag;
    }

    public void resetPSAppViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppViewId();
            return;
        }
        this.psappviewidDirtyFlag = false;
        this.psappviewid = null;
    }

    public void setPSAppViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappviewname = string;
        this.psappviewnameDirtyFlag = true;
    }

    public String getPSAppViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppViewName();
        }
        return this.psappviewname;
    }

    public boolean isPSAppViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppViewNameDirty();
        }
        return this.psappviewnameDirtyFlag;
    }

    public void resetPSAppViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppViewName();
            return;
        }
        this.psappviewnameDirtyFlag = false;
        this.psappviewname = null;
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

    public void setPSDEDSId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDSId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedsid = string;
        this.psdedsidDirtyFlag = true;
    }

    public String getPSDEDSId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDSId();
        }
        return this.psdedsid;
    }

    public boolean isPSDEDSIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDSIdDirty();
        }
        return this.psdedsidDirtyFlag;
    }

    public void resetPSDEDSId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDSId();
            return;
        }
        this.psdedsidDirtyFlag = false;
        this.psdedsid = null;
    }

    public void setPSDEDSName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDSName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedsname = string;
        this.psdedsnameDirtyFlag = true;
    }

    public String getPSDEDSName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDSName();
        }
        return this.psdedsname;
    }

    public boolean isPSDEDSNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDSNameDirty();
        }
        return this.psdedsnameDirtyFlag;
    }

    public void resetPSDEDSName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDSName();
            return;
        }
        this.psdedsnameDirtyFlag = false;
        this.psdedsname = null;
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

    public void setPSPortletId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPortletId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psportletid = string;
        this.psportletidDirtyFlag = true;
    }

    public String getPSPortletId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPortletId();
        }
        return this.psportletid;
    }

    public boolean isPSPortletIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPortletIdDirty();
        }
        return this.psportletidDirtyFlag;
    }

    public void resetPSPortletId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPortletId();
            return;
        }
        this.psportletidDirtyFlag = false;
        this.psportletid = null;
    }

    public void setPSPortletName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPortletName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psportletname = string;
        this.psportletnameDirtyFlag = true;
    }

    public String getPSPortletName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPortletName();
        }
        return this.psportletname;
    }

    public boolean isPSPortletNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPortletNameDirty();
        }
        return this.psportletnameDirtyFlag;
    }

    public void resetPSPortletName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPortletName();
            return;
        }
        this.psportletnameDirtyFlag = false;
        this.psportletname = null;
    }

    public void setPSSysAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysappid = string;
        this.pssysappidDirtyFlag = true;
    }

    public String getPSSysAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAppId();
        }
        return this.pssysappid;
    }

    public boolean isPSSysAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAppIdDirty();
        }
        return this.pssysappidDirtyFlag;
    }

    public void resetPSSysAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAppId();
            return;
        }
        this.pssysappidDirtyFlag = false;
        this.pssysappid = null;
    }

    public void setPSSysAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysappname = string;
        this.pssysappnameDirtyFlag = true;
    }

    public String getPSSysAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAppName();
        }
        return this.pssysappname;
    }

    public boolean isPSSysAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAppNameDirty();
        }
        return this.pssysappnameDirtyFlag;
    }

    public void resetPSSysAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAppName();
            return;
        }
        this.pssysappnameDirtyFlag = false;
        this.pssysappname = null;
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

    public void setPSSysPortletCatId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPortletCatId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysportletcatid = string;
        this.pssysportletcatidDirtyFlag = true;
    }

    public String getPSSysPortletCatId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPortletCatId();
        }
        return this.pssysportletcatid;
    }

    public boolean isPSSysPortletCatIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPortletCatIdDirty();
        }
        return this.pssysportletcatidDirtyFlag;
    }

    public void resetPSSysPortletCatId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPortletCatId();
            return;
        }
        this.pssysportletcatidDirtyFlag = false;
        this.pssysportletcatid = null;
    }

    public void setPSSysPortletCatName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPortletCatName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysportletcatname = string;
        this.pssysportletcatnameDirtyFlag = true;
    }

    public String getPSSysPortletCatName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPortletCatName();
        }
        return this.pssysportletcatname;
    }

    public boolean isPSSysPortletCatNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPortletCatNameDirty();
        }
        return this.pssysportletcatnameDirtyFlag;
    }

    public void resetPSSysPortletCatName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPortletCatName();
            return;
        }
        this.pssysportletcatnameDirtyFlag = false;
        this.pssysportletcatname = null;
    }

    public void setPSSysPortletId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPortletId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysportletid = string;
        this.pssysportletidDirtyFlag = true;
    }

    public String getPSSysPortletId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPortletId();
        }
        return this.pssysportletid;
    }

    public boolean isPSSysPortletIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPortletIdDirty();
        }
        return this.pssysportletidDirtyFlag;
    }

    public void resetPSSysPortletId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPortletId();
            return;
        }
        this.pssysportletidDirtyFlag = false;
        this.pssysportletid = null;
    }

    public void setPSSysPortletName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPortletName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysportletname = string;
        this.pssysportletnameDirtyFlag = true;
    }

    public String getPSSysPortletName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPortletName();
        }
        return this.pssysportletname;
    }

    public boolean isPSSysPortletNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPortletNameDirty();
        }
        return this.pssysportletnameDirtyFlag;
    }

    public void resetPSSysPortletName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPortletName();
            return;
        }
        this.pssysportletnameDirtyFlag = false;
        this.pssysportletname = null;
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

    public void setReloadTimer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReloadTimer(n);
            return;
        }
        this.reloadtimer = n;
        this.reloadtimerDirtyFlag = true;
    }

    public Integer getReloadTimer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReloadTimer();
        }
        return this.reloadtimer;
    }

    public boolean isReloadTimerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReloadTimerDirty();
        }
        return this.reloadtimerDirtyFlag;
    }

    public void resetReloadTimer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReloadTimer();
            return;
        }
        this.reloadtimerDirtyFlag = false;
        this.reloadtimer = null;
    }

    public void setShowTitleBar(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setShowTitleBar(n);
            return;
        }
        this.showtitlebar = n;
        this.showtitlebarDirtyFlag = true;
    }

    public Integer getShowTitleBar() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getShowTitleBar();
        }
        return this.showtitlebar;
    }

    public boolean isShowTitleBarDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isShowTitleBarDirty();
        }
        return this.showtitlebarDirtyFlag;
    }

    public void resetShowTitleBar() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetShowTitleBar();
            return;
        }
        this.showtitlebarDirtyFlag = false;
        this.showtitlebar = null;
    }

    public void setSysAppFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysAppFlag(n);
            return;
        }
        this.sysappflag = n;
        this.sysappflagDirtyFlag = true;
    }

    public Integer getSysAppFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysAppFlag();
        }
        return this.sysappflag;
    }

    public boolean isSysAppFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysAppFlagDirty();
        }
        return this.sysappflagDirtyFlag;
    }

    public void resetSysAppFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysAppFlag();
            return;
        }
        this.sysappflagDirtyFlag = false;
        this.sysappflag = null;
    }

    public void setTemplEngine(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplEngine(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templengine = string;
        this.templengineDirtyFlag = true;
    }

    public String getTemplEngine() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplEngine();
        }
        return this.templengine;
    }

    public boolean isTemplEngineDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplEngineDirty();
        }
        return this.templengineDirtyFlag;
    }

    public void resetTemplEngine() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplEngine();
            return;
        }
        this.templengineDirtyFlag = false;
        this.templengine = null;
    }

    public void setTitlePSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTitlePSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.titlepslanresid = string;
        this.titlepslanresidDirtyFlag = true;
    }

    public String getTitlePSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTitlePSLanResId();
        }
        return this.titlepslanresid;
    }

    public boolean isTitlePSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTitlePSLanResIdDirty();
        }
        return this.titlepslanresidDirtyFlag;
    }

    public void resetTitlePSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTitlePSLanResId();
            return;
        }
        this.titlepslanresidDirtyFlag = false;
        this.titlepslanresid = null;
    }

    public void setTitlePSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTitlePSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.titlepslanresname = string;
        this.titlepslanresnameDirtyFlag = true;
    }

    public String getTitlePSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTitlePSLanResName();
        }
        return this.titlepslanresname;
    }

    public boolean isTitlePSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTitlePSLanResNameDirty();
        }
        return this.titlepslanresnameDirtyFlag;
    }

    public void resetTitlePSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTitlePSLanResName();
            return;
        }
        this.titlepslanresnameDirtyFlag = false;
        this.titlepslanresname = null;
    }

    public void setTitlePSSysPFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTitlePSSysPFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.titlepssyspfpluginid = string;
        this.titlepssyspfpluginidDirtyFlag = true;
    }

    public String getTitlePSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTitlePSSysPFPluginId();
        }
        return this.titlepssyspfpluginid;
    }

    public boolean isTitlePSSysPFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTitlePSSysPFPluginIdDirty();
        }
        return this.titlepssyspfpluginidDirtyFlag;
    }

    public void resetTitlePSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTitlePSSysPFPluginId();
            return;
        }
        this.titlepssyspfpluginidDirtyFlag = false;
        this.titlepssyspfpluginid = null;
    }

    public void setTitlePSSysPFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTitlePSSysPFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.titlepssyspfpluginname = string;
        this.titlepssyspfpluginnameDirtyFlag = true;
    }

    public String getTitlePSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTitlePSSysPFPluginName();
        }
        return this.titlepssyspfpluginname;
    }

    public boolean isTitlePSSysPFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTitlePSSysPFPluginNameDirty();
        }
        return this.titlepssyspfpluginnameDirtyFlag;
    }

    public void resetTitlePSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTitlePSSysPFPluginName();
            return;
        }
        this.titlepssyspfpluginnameDirtyFlag = false;
        this.titlepssyspfpluginname = null;
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

    protected void onReset() {
        PSSysPortletBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysPortletBase pSSysPortletBase) {
        pSSysPortletBase.resetADPSDELogicId();
        pSSysPortletBase.resetADPSDELogicName();
        pSSysPortletBase.resetBaseClsParams();
        pSSysPortletBase.resetCodeName();
        pSSysPortletBase.resetCreateDate();
        pSSysPortletBase.resetCreateMan();
        pSSysPortletBase.resetDashboardScope();
        pSSysPortletBase.resetEmptyText();
        pSSysPortletBase.resetEmptyTextPSLanResId();
        pSSysPortletBase.resetEmptyTextPSLanResName();
        pSSysPortletBase.resetFilterPSDEDSId();
        pSSysPortletBase.resetFilterPSDEDSName();
        pSSysPortletBase.resetGroupExtractMode();
        pSSysPortletBase.resetHeight();
        pSSysPortletBase.resetHtmlShowMode();
        pSSysPortletBase.resetHtmlUrl();
        pSSysPortletBase.resetLockFlag();
        pSSysPortletBase.resetLogicName();
        pSSysPortletBase.resetMemo();
        pSSysPortletBase.resetPortletParams();
        pSSysPortletBase.resetPortletStyle();
        pSSysPortletBase.resetPortletType();
        pSSysPortletBase.resetPSACHandlerId();
        pSSysPortletBase.resetPSACHandlerName();
        pSSysPortletBase.resetPSAppMenuId();
        pSSysPortletBase.resetPSAppMenuName();
        pSSysPortletBase.resetPSAppViewId();
        pSSysPortletBase.resetPSAppViewName();
        pSSysPortletBase.resetPSDEChartId();
        pSSysPortletBase.resetPSDEChartName();
        pSSysPortletBase.resetPSDEDataViewId();
        pSSysPortletBase.resetPSDEDataViewName();
        pSSysPortletBase.resetPSDEDSId();
        pSSysPortletBase.resetPSDEDSName();
        pSSysPortletBase.resetPSDEFormId();
        pSSysPortletBase.resetPSDEFormName();
        pSSysPortletBase.resetPSDEId();
        pSSysPortletBase.resetPSDEListId();
        pSSysPortletBase.resetPSDEListName();
        pSSysPortletBase.resetPSDEName();
        pSSysPortletBase.resetPSDEReportId();
        pSSysPortletBase.resetPSDEReportName();
        pSSysPortletBase.resetPSDEToolbarId();
        pSSysPortletBase.resetPSDEToolbarName();
        pSSysPortletBase.resetPSDEUAGroupId();
        pSSysPortletBase.resetPSDEUAGroupName();
        pSSysPortletBase.resetPSDEViewId();
        pSSysPortletBase.resetPSDEViewName();
        pSSysPortletBase.resetPSModuleId();
        pSSysPortletBase.resetPSModuleName();
        pSSysPortletBase.resetPSPortletId();
        pSSysPortletBase.resetPSPortletName();
        pSSysPortletBase.resetPSSysAppId();
        pSSysPortletBase.resetPSSysAppName();
        pSSysPortletBase.resetPSSysCalendarId();
        pSSysPortletBase.resetPSSysCalendarName();
        pSSysPortletBase.resetPSSysCssId();
        pSSysPortletBase.resetPSSysCssName();
        pSSysPortletBase.resetPSSysImageId();
        pSSysPortletBase.resetPSSysImageName();
        pSSysPortletBase.resetPSSysMapViewId();
        pSSysPortletBase.resetPSSysMapViewName();
        pSSysPortletBase.resetPSSysPFPluginId();
        pSSysPortletBase.resetPSSysPFPluginName();
        pSSysPortletBase.resetPSSysPortletCatId();
        pSSysPortletBase.resetPSSysPortletCatName();
        pSSysPortletBase.resetPSSysPortletId();
        pSSysPortletBase.resetPSSysPortletName();
        pSSysPortletBase.resetPSSysReqItemId();
        pSSysPortletBase.resetPSSysReqItemName();
        pSSysPortletBase.resetPSSystemId();
        pSSysPortletBase.resetPSSystemName();
        pSSysPortletBase.resetPSSysUniResId();
        pSSysPortletBase.resetPSSysUniResName();
        pSSysPortletBase.resetPSSysViewPanelId();
        pSSysPortletBase.resetPSSysViewPanelName();
        pSSysPortletBase.resetReloadTimer();
        pSSysPortletBase.resetShowTitleBar();
        pSSysPortletBase.resetSysAppFlag();
        pSSysPortletBase.resetTemplEngine();
        pSSysPortletBase.resetTitlePSLanResId();
        pSSysPortletBase.resetTitlePSLanResName();
        pSSysPortletBase.resetTitlePSSysPFPluginId();
        pSSysPortletBase.resetTitlePSSysPFPluginName();
        pSSysPortletBase.resetToDoTask();
        pSSysPortletBase.resetUpdateDate();
        pSSysPortletBase.resetUpdateMan();
        pSSysPortletBase.resetUserTag();
        pSSysPortletBase.resetUserTag2();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isADPSDELogicIdDirty()) {
            hashMap.put(FIELD_ADPSDELOGICID, this.getADPSDELogicId());
        }
        if (!bl || this.isADPSDELogicNameDirty()) {
            hashMap.put(FIELD_ADPSDELOGICNAME, this.getADPSDELogicName());
        }
        if (!bl || this.isBaseClsParamsDirty()) {
            hashMap.put(FIELD_BASECLSPARAMS, this.getBaseClsParams());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDashboardScopeDirty()) {
            hashMap.put(FIELD_DASHBOARDSCOPE, this.getDashboardScope());
        }
        if (!bl || this.isEmptyTextDirty()) {
            hashMap.put(FIELD_EMPTYTEXT, this.getEmptyText());
        }
        if (!bl || this.isEmptyTextPSLanResIdDirty()) {
            hashMap.put(FIELD_EMPTYTEXTPSLANRESID, this.getEmptyTextPSLanResId());
        }
        if (!bl || this.isEmptyTextPSLanResNameDirty()) {
            hashMap.put(FIELD_EMPTYTEXTPSLANRESNAME, this.getEmptyTextPSLanResName());
        }
        if (!bl || this.isFilterPSDEDSIdDirty()) {
            hashMap.put(FIELD_FILTERPSDEDSID, this.getFilterPSDEDSId());
        }
        if (!bl || this.isFilterPSDEDSNameDirty()) {
            hashMap.put(FIELD_FILTERPSDEDSNAME, this.getFilterPSDEDSName());
        }
        if (!bl || this.isGroupExtractModeDirty()) {
            hashMap.put(FIELD_GROUPEXTRACTMODE, this.getGroupExtractMode());
        }
        if (!bl || this.isHeightDirty()) {
            hashMap.put(FIELD_HEIGHT, this.getHeight());
        }
        if (!bl || this.isHtmlShowModeDirty()) {
            hashMap.put(FIELD_HTMLSHOWMODE, this.getHtmlShowMode());
        }
        if (!bl || this.isHtmlUrlDirty()) {
            hashMap.put(FIELD_HTMLURL, this.getHtmlUrl());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPortletParamsDirty()) {
            hashMap.put(FIELD_PORTLETPARAMS, this.getPortletParams());
        }
        if (!bl || this.isPortletStyleDirty()) {
            hashMap.put(FIELD_PORTLETSTYLE, this.getPortletStyle());
        }
        if (!bl || this.isPortletTypeDirty()) {
            hashMap.put(FIELD_PORTLETTYPE, this.getPortletType());
        }
        if (!bl || this.isPSACHandlerIdDirty()) {
            hashMap.put(FIELD_PSACHANDLERID, this.getPSACHandlerId());
        }
        if (!bl || this.isPSACHandlerNameDirty()) {
            hashMap.put(FIELD_PSACHANDLERNAME, this.getPSACHandlerName());
        }
        if (!bl || this.isPSAppMenuIdDirty()) {
            hashMap.put(FIELD_PSAPPMENUID, this.getPSAppMenuId());
        }
        if (!bl || this.isPSAppMenuNameDirty()) {
            hashMap.put(FIELD_PSAPPMENUNAME, this.getPSAppMenuName());
        }
        if (!bl || this.isPSAppViewIdDirty()) {
            hashMap.put(FIELD_PSAPPVIEWID, this.getPSAppViewId());
        }
        if (!bl || this.isPSAppViewNameDirty()) {
            hashMap.put(FIELD_PSAPPVIEWNAME, this.getPSAppViewName());
        }
        if (!bl || this.isPSDEChartIdDirty()) {
            hashMap.put(FIELD_PSDECHARTID, this.getPSDEChartId());
        }
        if (!bl || this.isPSDEChartNameDirty()) {
            hashMap.put(FIELD_PSDECHARTNAME, this.getPSDEChartName());
        }
        if (!bl || this.isPSDEDataViewIdDirty()) {
            hashMap.put(FIELD_PSDEDATAVIEWID, this.getPSDEDataViewId());
        }
        if (!bl || this.isPSDEDataViewNameDirty()) {
            hashMap.put(FIELD_PSDEDATAVIEWNAME, this.getPSDEDataViewName());
        }
        if (!bl || this.isPSDEDSIdDirty()) {
            hashMap.put(FIELD_PSDEDSID, this.getPSDEDSId());
        }
        if (!bl || this.isPSDEDSNameDirty()) {
            hashMap.put(FIELD_PSDEDSNAME, this.getPSDEDSName());
        }
        if (!bl || this.isPSDEFormIdDirty()) {
            hashMap.put(FIELD_PSDEFORMID, this.getPSDEFormId());
        }
        if (!bl || this.isPSDEFormNameDirty()) {
            hashMap.put(FIELD_PSDEFORMNAME, this.getPSDEFormName());
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
        if (!bl || this.isPSDEUAGroupIdDirty()) {
            hashMap.put(FIELD_PSDEUAGROUPID, this.getPSDEUAGroupId());
        }
        if (!bl || this.isPSDEUAGroupNameDirty()) {
            hashMap.put(FIELD_PSDEUAGROUPNAME, this.getPSDEUAGroupName());
        }
        if (!bl || this.isPSDEViewIdDirty()) {
            hashMap.put(FIELD_PSDEVIEWID, this.getPSDEViewId());
        }
        if (!bl || this.isPSDEViewNameDirty()) {
            hashMap.put(FIELD_PSDEVIEWNAME, this.getPSDEViewName());
        }
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
        }
        if (!bl || this.isPSPortletIdDirty()) {
            hashMap.put(FIELD_PSPORTLETID, this.getPSPortletId());
        }
        if (!bl || this.isPSPortletNameDirty()) {
            hashMap.put(FIELD_PSPORTLETNAME, this.getPSPortletName());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysAppNameDirty()) {
            hashMap.put(FIELD_PSSYSAPPNAME, this.getPSSysAppName());
        }
        if (!bl || this.isPSSysCalendarIdDirty()) {
            hashMap.put(FIELD_PSSYSCALENDARID, this.getPSSysCalendarId());
        }
        if (!bl || this.isPSSysCalendarNameDirty()) {
            hashMap.put(FIELD_PSSYSCALENDARNAME, this.getPSSysCalendarName());
        }
        if (!bl || this.isPSSysCssIdDirty()) {
            hashMap.put(FIELD_PSSYSCSSID, this.getPSSysCssId());
        }
        if (!bl || this.isPSSysCssNameDirty()) {
            hashMap.put(FIELD_PSSYSCSSNAME, this.getPSSysCssName());
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
        if (!bl || this.isPSSysPFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINID, this.getPSSysPFPluginId());
        }
        if (!bl || this.isPSSysPFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINNAME, this.getPSSysPFPluginName());
        }
        if (!bl || this.isPSSysPortletCatIdDirty()) {
            hashMap.put(FIELD_PSSYSPORTLETCATID, this.getPSSysPortletCatId());
        }
        if (!bl || this.isPSSysPortletCatNameDirty()) {
            hashMap.put(FIELD_PSSYSPORTLETCATNAME, this.getPSSysPortletCatName());
        }
        if (!bl || this.isPSSysPortletIdDirty()) {
            hashMap.put(FIELD_PSSYSPORTLETID, this.getPSSysPortletId());
        }
        if (!bl || this.isPSSysPortletNameDirty()) {
            hashMap.put(FIELD_PSSYSPORTLETNAME, this.getPSSysPortletName());
        }
        if (!bl || this.isPSSysReqItemIdDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMID, this.getPSSysReqItemId());
        }
        if (!bl || this.isPSSysReqItemNameDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMNAME, this.getPSSysReqItemName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isPSSysUniResIdDirty()) {
            hashMap.put(FIELD_PSSYSUNIRESID, this.getPSSysUniResId());
        }
        if (!bl || this.isPSSysUniResNameDirty()) {
            hashMap.put(FIELD_PSSYSUNIRESNAME, this.getPSSysUniResName());
        }
        if (!bl || this.isPSSysViewPanelIdDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELID, this.getPSSysViewPanelId());
        }
        if (!bl || this.isPSSysViewPanelNameDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELNAME, this.getPSSysViewPanelName());
        }
        if (!bl || this.isReloadTimerDirty()) {
            hashMap.put(FIELD_RELOADTIMER, this.getReloadTimer());
        }
        if (!bl || this.isShowTitleBarDirty()) {
            hashMap.put(FIELD_SHOWTITLEBAR, this.getShowTitleBar());
        }
        if (!bl || this.isSysAppFlagDirty()) {
            hashMap.put(FIELD_SYSAPPFLAG, this.getSysAppFlag());
        }
        if (!bl || this.isTemplEngineDirty()) {
            hashMap.put(FIELD_TEMPLENGINE, this.getTemplEngine());
        }
        if (!bl || this.isTitlePSLanResIdDirty()) {
            hashMap.put(FIELD_TITLEPSLANRESID, this.getTitlePSLanResId());
        }
        if (!bl || this.isTitlePSLanResNameDirty()) {
            hashMap.put(FIELD_TITLEPSLANRESNAME, this.getTitlePSLanResName());
        }
        if (!bl || this.isTitlePSSysPFPluginIdDirty()) {
            hashMap.put(FIELD_TITLEPSSYSPFPLUGINID, this.getTitlePSSysPFPluginId());
        }
        if (!bl || this.isTitlePSSysPFPluginNameDirty()) {
            hashMap.put(FIELD_TITLEPSSYSPFPLUGINNAME, this.getTitlePSSysPFPluginName());
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
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bl || this.isUserTag2Dirty()) {
            hashMap.put(FIELD_USERTAG2, this.getUserTag2());
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
        return PSSysPortletBase.get(this, n);
    }

    private static Object get(PSSysPortletBase pSSysPortletBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysPortletBase.getADPSDELogicId();
            }
            case 1: {
                return pSSysPortletBase.getADPSDELogicName();
            }
            case 2: {
                return pSSysPortletBase.getBaseClsParams();
            }
            case 3: {
                return pSSysPortletBase.getCodeName();
            }
            case 4: {
                return pSSysPortletBase.getCreateDate();
            }
            case 5: {
                return pSSysPortletBase.getCreateMan();
            }
            case 6: {
                return pSSysPortletBase.getDashboardScope();
            }
            case 7: {
                return pSSysPortletBase.getEmptyText();
            }
            case 8: {
                return pSSysPortletBase.getEmptyTextPSLanResId();
            }
            case 9: {
                return pSSysPortletBase.getEmptyTextPSLanResName();
            }
            case 10: {
                return pSSysPortletBase.getFilterPSDEDSId();
            }
            case 11: {
                return pSSysPortletBase.getFilterPSDEDSName();
            }
            case 12: {
                return pSSysPortletBase.getGroupExtractMode();
            }
            case 13: {
                return pSSysPortletBase.getHeight();
            }
            case 14: {
                return pSSysPortletBase.getHtmlShowMode();
            }
            case 15: {
                return pSSysPortletBase.getHtmlUrl();
            }
            case 16: {
                return pSSysPortletBase.getLockFlag();
            }
            case 17: {
                return pSSysPortletBase.getLogicName();
            }
            case 18: {
                return pSSysPortletBase.getMemo();
            }
            case 19: {
                return pSSysPortletBase.getPortletParams();
            }
            case 20: {
                return pSSysPortletBase.getPortletStyle();
            }
            case 21: {
                return pSSysPortletBase.getPortletType();
            }
            case 22: {
                return pSSysPortletBase.getPSACHandlerId();
            }
            case 23: {
                return pSSysPortletBase.getPSACHandlerName();
            }
            case 24: {
                return pSSysPortletBase.getPSAppMenuId();
            }
            case 25: {
                return pSSysPortletBase.getPSAppMenuName();
            }
            case 26: {
                return pSSysPortletBase.getPSAppViewId();
            }
            case 27: {
                return pSSysPortletBase.getPSAppViewName();
            }
            case 28: {
                return pSSysPortletBase.getPSDEChartId();
            }
            case 29: {
                return pSSysPortletBase.getPSDEChartName();
            }
            case 30: {
                return pSSysPortletBase.getPSDEDataViewId();
            }
            case 31: {
                return pSSysPortletBase.getPSDEDataViewName();
            }
            case 32: {
                return pSSysPortletBase.getPSDEDSId();
            }
            case 33: {
                return pSSysPortletBase.getPSDEDSName();
            }
            case 34: {
                return pSSysPortletBase.getPSDEFormId();
            }
            case 35: {
                return pSSysPortletBase.getPSDEFormName();
            }
            case 36: {
                return pSSysPortletBase.getPSDEId();
            }
            case 37: {
                return pSSysPortletBase.getPSDEListId();
            }
            case 38: {
                return pSSysPortletBase.getPSDEListName();
            }
            case 39: {
                return pSSysPortletBase.getPSDEName();
            }
            case 40: {
                return pSSysPortletBase.getPSDEReportId();
            }
            case 41: {
                return pSSysPortletBase.getPSDEReportName();
            }
            case 42: {
                return pSSysPortletBase.getPSDEToolbarId();
            }
            case 43: {
                return pSSysPortletBase.getPSDEToolbarName();
            }
            case 44: {
                return pSSysPortletBase.getPSDEUAGroupId();
            }
            case 45: {
                return pSSysPortletBase.getPSDEUAGroupName();
            }
            case 46: {
                return pSSysPortletBase.getPSDEViewId();
            }
            case 47: {
                return pSSysPortletBase.getPSDEViewName();
            }
            case 48: {
                return pSSysPortletBase.getPSModuleId();
            }
            case 49: {
                return pSSysPortletBase.getPSModuleName();
            }
            case 50: {
                return pSSysPortletBase.getPSPortletId();
            }
            case 51: {
                return pSSysPortletBase.getPSPortletName();
            }
            case 52: {
                return pSSysPortletBase.getPSSysAppId();
            }
            case 53: {
                return pSSysPortletBase.getPSSysAppName();
            }
            case 54: {
                return pSSysPortletBase.getPSSysCalendarId();
            }
            case 55: {
                return pSSysPortletBase.getPSSysCalendarName();
            }
            case 56: {
                return pSSysPortletBase.getPSSysCssId();
            }
            case 57: {
                return pSSysPortletBase.getPSSysCssName();
            }
            case 58: {
                return pSSysPortletBase.getPSSysImageId();
            }
            case 59: {
                return pSSysPortletBase.getPSSysImageName();
            }
            case 60: {
                return pSSysPortletBase.getPSSysMapViewId();
            }
            case 61: {
                return pSSysPortletBase.getPSSysMapViewName();
            }
            case 62: {
                return pSSysPortletBase.getPSSysPFPluginId();
            }
            case 63: {
                return pSSysPortletBase.getPSSysPFPluginName();
            }
            case 64: {
                return pSSysPortletBase.getPSSysPortletCatId();
            }
            case 65: {
                return pSSysPortletBase.getPSSysPortletCatName();
            }
            case 66: {
                return pSSysPortletBase.getPSSysPortletId();
            }
            case 67: {
                return pSSysPortletBase.getPSSysPortletName();
            }
            case 68: {
                return pSSysPortletBase.getPSSysReqItemId();
            }
            case 69: {
                return pSSysPortletBase.getPSSysReqItemName();
            }
            case 70: {
                return pSSysPortletBase.getPSSystemId();
            }
            case 71: {
                return pSSysPortletBase.getPSSystemName();
            }
            case 72: {
                return pSSysPortletBase.getPSSysUniResId();
            }
            case 73: {
                return pSSysPortletBase.getPSSysUniResName();
            }
            case 74: {
                return pSSysPortletBase.getPSSysViewPanelId();
            }
            case 75: {
                return pSSysPortletBase.getPSSysViewPanelName();
            }
            case 76: {
                return pSSysPortletBase.getReloadTimer();
            }
            case 77: {
                return pSSysPortletBase.getShowTitleBar();
            }
            case 78: {
                return pSSysPortletBase.getSysAppFlag();
            }
            case 79: {
                return pSSysPortletBase.getTemplEngine();
            }
            case 80: {
                return pSSysPortletBase.getTitlePSLanResId();
            }
            case 81: {
                return pSSysPortletBase.getTitlePSLanResName();
            }
            case 82: {
                return pSSysPortletBase.getTitlePSSysPFPluginId();
            }
            case 83: {
                return pSSysPortletBase.getTitlePSSysPFPluginName();
            }
            case 84: {
                return pSSysPortletBase.getToDoTask();
            }
            case 85: {
                return pSSysPortletBase.getUpdateDate();
            }
            case 86: {
                return pSSysPortletBase.getUpdateMan();
            }
            case 87: {
                return pSSysPortletBase.getUserTag();
            }
            case 88: {
                return pSSysPortletBase.getUserTag2();
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
        PSSysPortletBase.set(this, n, object);
    }

    private static void set(PSSysPortletBase pSSysPortletBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysPortletBase.setADPSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysPortletBase.setADPSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysPortletBase.setBaseClsParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysPortletBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysPortletBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 5: {
                pSSysPortletBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysPortletBase.setDashboardScope(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSSysPortletBase.setEmptyText(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysPortletBase.setEmptyTextPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysPortletBase.setEmptyTextPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysPortletBase.setFilterPSDEDSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysPortletBase.setFilterPSDEDSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysPortletBase.setGroupExtractMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysPortletBase.setHeight(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSSysPortletBase.setHtmlShowMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysPortletBase.setHtmlUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysPortletBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSSysPortletBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysPortletBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysPortletBase.setPortletParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysPortletBase.setPortletStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysPortletBase.setPortletType(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysPortletBase.setPSACHandlerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysPortletBase.setPSACHandlerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysPortletBase.setPSAppMenuId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysPortletBase.setPSAppMenuName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysPortletBase.setPSAppViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysPortletBase.setPSAppViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysPortletBase.setPSDEChartId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysPortletBase.setPSDEChartName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysPortletBase.setPSDEDataViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysPortletBase.setPSDEDataViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysPortletBase.setPSDEDSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysPortletBase.setPSDEDSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysPortletBase.setPSDEFormId(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSysPortletBase.setPSDEFormName(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSSysPortletBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSSysPortletBase.setPSDEListId(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSSysPortletBase.setPSDEListName(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSSysPortletBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSSysPortletBase.setPSDEReportId(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSSysPortletBase.setPSDEReportName(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSSysPortletBase.setPSDEToolbarId(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSSysPortletBase.setPSDEToolbarName(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSSysPortletBase.setPSDEUAGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSSysPortletBase.setPSDEUAGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSSysPortletBase.setPSDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSSysPortletBase.setPSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSSysPortletBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSSysPortletBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSSysPortletBase.setPSPortletId(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSSysPortletBase.setPSPortletName(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSSysPortletBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSSysPortletBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSSysPortletBase.setPSSysCalendarId(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSSysPortletBase.setPSSysCalendarName(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSSysPortletBase.setPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSSysPortletBase.setPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 58: {
                pSSysPortletBase.setPSSysImageId(DataObject.getStringValue((Object)object));
                return;
            }
            case 59: {
                pSSysPortletBase.setPSSysImageName(DataObject.getStringValue((Object)object));
                return;
            }
            case 60: {
                pSSysPortletBase.setPSSysMapViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 61: {
                pSSysPortletBase.setPSSysMapViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 62: {
                pSSysPortletBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 63: {
                pSSysPortletBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 64: {
                pSSysPortletBase.setPSSysPortletCatId(DataObject.getStringValue((Object)object));
                return;
            }
            case 65: {
                pSSysPortletBase.setPSSysPortletCatName(DataObject.getStringValue((Object)object));
                return;
            }
            case 66: {
                pSSysPortletBase.setPSSysPortletId(DataObject.getStringValue((Object)object));
                return;
            }
            case 67: {
                pSSysPortletBase.setPSSysPortletName(DataObject.getStringValue((Object)object));
                return;
            }
            case 68: {
                pSSysPortletBase.setPSSysReqItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 69: {
                pSSysPortletBase.setPSSysReqItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 70: {
                pSSysPortletBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 71: {
                pSSysPortletBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 72: {
                pSSysPortletBase.setPSSysUniResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 73: {
                pSSysPortletBase.setPSSysUniResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 74: {
                pSSysPortletBase.setPSSysViewPanelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 75: {
                pSSysPortletBase.setPSSysViewPanelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 76: {
                pSSysPortletBase.setReloadTimer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 77: {
                pSSysPortletBase.setShowTitleBar(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 78: {
                pSSysPortletBase.setSysAppFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 79: {
                pSSysPortletBase.setTemplEngine(DataObject.getStringValue((Object)object));
                return;
            }
            case 80: {
                pSSysPortletBase.setTitlePSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 81: {
                pSSysPortletBase.setTitlePSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 82: {
                pSSysPortletBase.setTitlePSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 83: {
                pSSysPortletBase.setTitlePSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 84: {
                pSSysPortletBase.setToDoTask(DataObject.getStringValue((Object)object));
                return;
            }
            case 85: {
                pSSysPortletBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 86: {
                pSSysPortletBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 87: {
                pSSysPortletBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 88: {
                pSSysPortletBase.setUserTag2(DataObject.getStringValue((Object)object));
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
        return PSSysPortletBase.isNull(this, n);
    }

    private static boolean isNull(PSSysPortletBase pSSysPortletBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysPortletBase.getADPSDELogicId() == null;
            }
            case 1: {
                return pSSysPortletBase.getADPSDELogicName() == null;
            }
            case 2: {
                return pSSysPortletBase.getBaseClsParams() == null;
            }
            case 3: {
                return pSSysPortletBase.getCodeName() == null;
            }
            case 4: {
                return pSSysPortletBase.getCreateDate() == null;
            }
            case 5: {
                return pSSysPortletBase.getCreateMan() == null;
            }
            case 6: {
                return pSSysPortletBase.getDashboardScope() == null;
            }
            case 7: {
                return pSSysPortletBase.getEmptyText() == null;
            }
            case 8: {
                return pSSysPortletBase.getEmptyTextPSLanResId() == null;
            }
            case 9: {
                return pSSysPortletBase.getEmptyTextPSLanResName() == null;
            }
            case 10: {
                return pSSysPortletBase.getFilterPSDEDSId() == null;
            }
            case 11: {
                return pSSysPortletBase.getFilterPSDEDSName() == null;
            }
            case 12: {
                return pSSysPortletBase.getGroupExtractMode() == null;
            }
            case 13: {
                return pSSysPortletBase.getHeight() == null;
            }
            case 14: {
                return pSSysPortletBase.getHtmlShowMode() == null;
            }
            case 15: {
                return pSSysPortletBase.getHtmlUrl() == null;
            }
            case 16: {
                return pSSysPortletBase.getLockFlag() == null;
            }
            case 17: {
                return pSSysPortletBase.getLogicName() == null;
            }
            case 18: {
                return pSSysPortletBase.getMemo() == null;
            }
            case 19: {
                return pSSysPortletBase.getPortletParams() == null;
            }
            case 20: {
                return pSSysPortletBase.getPortletStyle() == null;
            }
            case 21: {
                return pSSysPortletBase.getPortletType() == null;
            }
            case 22: {
                return pSSysPortletBase.getPSACHandlerId() == null;
            }
            case 23: {
                return pSSysPortletBase.getPSACHandlerName() == null;
            }
            case 24: {
                return pSSysPortletBase.getPSAppMenuId() == null;
            }
            case 25: {
                return pSSysPortletBase.getPSAppMenuName() == null;
            }
            case 26: {
                return pSSysPortletBase.getPSAppViewId() == null;
            }
            case 27: {
                return pSSysPortletBase.getPSAppViewName() == null;
            }
            case 28: {
                return pSSysPortletBase.getPSDEChartId() == null;
            }
            case 29: {
                return pSSysPortletBase.getPSDEChartName() == null;
            }
            case 30: {
                return pSSysPortletBase.getPSDEDataViewId() == null;
            }
            case 31: {
                return pSSysPortletBase.getPSDEDataViewName() == null;
            }
            case 32: {
                return pSSysPortletBase.getPSDEDSId() == null;
            }
            case 33: {
                return pSSysPortletBase.getPSDEDSName() == null;
            }
            case 34: {
                return pSSysPortletBase.getPSDEFormId() == null;
            }
            case 35: {
                return pSSysPortletBase.getPSDEFormName() == null;
            }
            case 36: {
                return pSSysPortletBase.getPSDEId() == null;
            }
            case 37: {
                return pSSysPortletBase.getPSDEListId() == null;
            }
            case 38: {
                return pSSysPortletBase.getPSDEListName() == null;
            }
            case 39: {
                return pSSysPortletBase.getPSDEName() == null;
            }
            case 40: {
                return pSSysPortletBase.getPSDEReportId() == null;
            }
            case 41: {
                return pSSysPortletBase.getPSDEReportName() == null;
            }
            case 42: {
                return pSSysPortletBase.getPSDEToolbarId() == null;
            }
            case 43: {
                return pSSysPortletBase.getPSDEToolbarName() == null;
            }
            case 44: {
                return pSSysPortletBase.getPSDEUAGroupId() == null;
            }
            case 45: {
                return pSSysPortletBase.getPSDEUAGroupName() == null;
            }
            case 46: {
                return pSSysPortletBase.getPSDEViewId() == null;
            }
            case 47: {
                return pSSysPortletBase.getPSDEViewName() == null;
            }
            case 48: {
                return pSSysPortletBase.getPSModuleId() == null;
            }
            case 49: {
                return pSSysPortletBase.getPSModuleName() == null;
            }
            case 50: {
                return pSSysPortletBase.getPSPortletId() == null;
            }
            case 51: {
                return pSSysPortletBase.getPSPortletName() == null;
            }
            case 52: {
                return pSSysPortletBase.getPSSysAppId() == null;
            }
            case 53: {
                return pSSysPortletBase.getPSSysAppName() == null;
            }
            case 54: {
                return pSSysPortletBase.getPSSysCalendarId() == null;
            }
            case 55: {
                return pSSysPortletBase.getPSSysCalendarName() == null;
            }
            case 56: {
                return pSSysPortletBase.getPSSysCssId() == null;
            }
            case 57: {
                return pSSysPortletBase.getPSSysCssName() == null;
            }
            case 58: {
                return pSSysPortletBase.getPSSysImageId() == null;
            }
            case 59: {
                return pSSysPortletBase.getPSSysImageName() == null;
            }
            case 60: {
                return pSSysPortletBase.getPSSysMapViewId() == null;
            }
            case 61: {
                return pSSysPortletBase.getPSSysMapViewName() == null;
            }
            case 62: {
                return pSSysPortletBase.getPSSysPFPluginId() == null;
            }
            case 63: {
                return pSSysPortletBase.getPSSysPFPluginName() == null;
            }
            case 64: {
                return pSSysPortletBase.getPSSysPortletCatId() == null;
            }
            case 65: {
                return pSSysPortletBase.getPSSysPortletCatName() == null;
            }
            case 66: {
                return pSSysPortletBase.getPSSysPortletId() == null;
            }
            case 67: {
                return pSSysPortletBase.getPSSysPortletName() == null;
            }
            case 68: {
                return pSSysPortletBase.getPSSysReqItemId() == null;
            }
            case 69: {
                return pSSysPortletBase.getPSSysReqItemName() == null;
            }
            case 70: {
                return pSSysPortletBase.getPSSystemId() == null;
            }
            case 71: {
                return pSSysPortletBase.getPSSystemName() == null;
            }
            case 72: {
                return pSSysPortletBase.getPSSysUniResId() == null;
            }
            case 73: {
                return pSSysPortletBase.getPSSysUniResName() == null;
            }
            case 74: {
                return pSSysPortletBase.getPSSysViewPanelId() == null;
            }
            case 75: {
                return pSSysPortletBase.getPSSysViewPanelName() == null;
            }
            case 76: {
                return pSSysPortletBase.getReloadTimer() == null;
            }
            case 77: {
                return pSSysPortletBase.getShowTitleBar() == null;
            }
            case 78: {
                return pSSysPortletBase.getSysAppFlag() == null;
            }
            case 79: {
                return pSSysPortletBase.getTemplEngine() == null;
            }
            case 80: {
                return pSSysPortletBase.getTitlePSLanResId() == null;
            }
            case 81: {
                return pSSysPortletBase.getTitlePSLanResName() == null;
            }
            case 82: {
                return pSSysPortletBase.getTitlePSSysPFPluginId() == null;
            }
            case 83: {
                return pSSysPortletBase.getTitlePSSysPFPluginName() == null;
            }
            case 84: {
                return pSSysPortletBase.getToDoTask() == null;
            }
            case 85: {
                return pSSysPortletBase.getUpdateDate() == null;
            }
            case 86: {
                return pSSysPortletBase.getUpdateMan() == null;
            }
            case 87: {
                return pSSysPortletBase.getUserTag() == null;
            }
            case 88: {
                return pSSysPortletBase.getUserTag2() == null;
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
        return PSSysPortletBase.contains(this, n);
    }

    private static boolean contains(PSSysPortletBase pSSysPortletBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysPortletBase.isADPSDELogicIdDirty();
            }
            case 1: {
                return pSSysPortletBase.isADPSDELogicNameDirty();
            }
            case 2: {
                return pSSysPortletBase.isBaseClsParamsDirty();
            }
            case 3: {
                return pSSysPortletBase.isCodeNameDirty();
            }
            case 4: {
                return pSSysPortletBase.isCreateDateDirty();
            }
            case 5: {
                return pSSysPortletBase.isCreateManDirty();
            }
            case 6: {
                return pSSysPortletBase.isDashboardScopeDirty();
            }
            case 7: {
                return pSSysPortletBase.isEmptyTextDirty();
            }
            case 8: {
                return pSSysPortletBase.isEmptyTextPSLanResIdDirty();
            }
            case 9: {
                return pSSysPortletBase.isEmptyTextPSLanResNameDirty();
            }
            case 10: {
                return pSSysPortletBase.isFilterPSDEDSIdDirty();
            }
            case 11: {
                return pSSysPortletBase.isFilterPSDEDSNameDirty();
            }
            case 12: {
                return pSSysPortletBase.isGroupExtractModeDirty();
            }
            case 13: {
                return pSSysPortletBase.isHeightDirty();
            }
            case 14: {
                return pSSysPortletBase.isHtmlShowModeDirty();
            }
            case 15: {
                return pSSysPortletBase.isHtmlUrlDirty();
            }
            case 16: {
                return pSSysPortletBase.isLockFlagDirty();
            }
            case 17: {
                return pSSysPortletBase.isLogicNameDirty();
            }
            case 18: {
                return pSSysPortletBase.isMemoDirty();
            }
            case 19: {
                return pSSysPortletBase.isPortletParamsDirty();
            }
            case 20: {
                return pSSysPortletBase.isPortletStyleDirty();
            }
            case 21: {
                return pSSysPortletBase.isPortletTypeDirty();
            }
            case 22: {
                return pSSysPortletBase.isPSACHandlerIdDirty();
            }
            case 23: {
                return pSSysPortletBase.isPSACHandlerNameDirty();
            }
            case 24: {
                return pSSysPortletBase.isPSAppMenuIdDirty();
            }
            case 25: {
                return pSSysPortletBase.isPSAppMenuNameDirty();
            }
            case 26: {
                return pSSysPortletBase.isPSAppViewIdDirty();
            }
            case 27: {
                return pSSysPortletBase.isPSAppViewNameDirty();
            }
            case 28: {
                return pSSysPortletBase.isPSDEChartIdDirty();
            }
            case 29: {
                return pSSysPortletBase.isPSDEChartNameDirty();
            }
            case 30: {
                return pSSysPortletBase.isPSDEDataViewIdDirty();
            }
            case 31: {
                return pSSysPortletBase.isPSDEDataViewNameDirty();
            }
            case 32: {
                return pSSysPortletBase.isPSDEDSIdDirty();
            }
            case 33: {
                return pSSysPortletBase.isPSDEDSNameDirty();
            }
            case 34: {
                return pSSysPortletBase.isPSDEFormIdDirty();
            }
            case 35: {
                return pSSysPortletBase.isPSDEFormNameDirty();
            }
            case 36: {
                return pSSysPortletBase.isPSDEIdDirty();
            }
            case 37: {
                return pSSysPortletBase.isPSDEListIdDirty();
            }
            case 38: {
                return pSSysPortletBase.isPSDEListNameDirty();
            }
            case 39: {
                return pSSysPortletBase.isPSDENameDirty();
            }
            case 40: {
                return pSSysPortletBase.isPSDEReportIdDirty();
            }
            case 41: {
                return pSSysPortletBase.isPSDEReportNameDirty();
            }
            case 42: {
                return pSSysPortletBase.isPSDEToolbarIdDirty();
            }
            case 43: {
                return pSSysPortletBase.isPSDEToolbarNameDirty();
            }
            case 44: {
                return pSSysPortletBase.isPSDEUAGroupIdDirty();
            }
            case 45: {
                return pSSysPortletBase.isPSDEUAGroupNameDirty();
            }
            case 46: {
                return pSSysPortletBase.isPSDEViewIdDirty();
            }
            case 47: {
                return pSSysPortletBase.isPSDEViewNameDirty();
            }
            case 48: {
                return pSSysPortletBase.isPSModuleIdDirty();
            }
            case 49: {
                return pSSysPortletBase.isPSModuleNameDirty();
            }
            case 50: {
                return pSSysPortletBase.isPSPortletIdDirty();
            }
            case 51: {
                return pSSysPortletBase.isPSPortletNameDirty();
            }
            case 52: {
                return pSSysPortletBase.isPSSysAppIdDirty();
            }
            case 53: {
                return pSSysPortletBase.isPSSysAppNameDirty();
            }
            case 54: {
                return pSSysPortletBase.isPSSysCalendarIdDirty();
            }
            case 55: {
                return pSSysPortletBase.isPSSysCalendarNameDirty();
            }
            case 56: {
                return pSSysPortletBase.isPSSysCssIdDirty();
            }
            case 57: {
                return pSSysPortletBase.isPSSysCssNameDirty();
            }
            case 58: {
                return pSSysPortletBase.isPSSysImageIdDirty();
            }
            case 59: {
                return pSSysPortletBase.isPSSysImageNameDirty();
            }
            case 60: {
                return pSSysPortletBase.isPSSysMapViewIdDirty();
            }
            case 61: {
                return pSSysPortletBase.isPSSysMapViewNameDirty();
            }
            case 62: {
                return pSSysPortletBase.isPSSysPFPluginIdDirty();
            }
            case 63: {
                return pSSysPortletBase.isPSSysPFPluginNameDirty();
            }
            case 64: {
                return pSSysPortletBase.isPSSysPortletCatIdDirty();
            }
            case 65: {
                return pSSysPortletBase.isPSSysPortletCatNameDirty();
            }
            case 66: {
                return pSSysPortletBase.isPSSysPortletIdDirty();
            }
            case 67: {
                return pSSysPortletBase.isPSSysPortletNameDirty();
            }
            case 68: {
                return pSSysPortletBase.isPSSysReqItemIdDirty();
            }
            case 69: {
                return pSSysPortletBase.isPSSysReqItemNameDirty();
            }
            case 70: {
                return pSSysPortletBase.isPSSystemIdDirty();
            }
            case 71: {
                return pSSysPortletBase.isPSSystemNameDirty();
            }
            case 72: {
                return pSSysPortletBase.isPSSysUniResIdDirty();
            }
            case 73: {
                return pSSysPortletBase.isPSSysUniResNameDirty();
            }
            case 74: {
                return pSSysPortletBase.isPSSysViewPanelIdDirty();
            }
            case 75: {
                return pSSysPortletBase.isPSSysViewPanelNameDirty();
            }
            case 76: {
                return pSSysPortletBase.isReloadTimerDirty();
            }
            case 77: {
                return pSSysPortletBase.isShowTitleBarDirty();
            }
            case 78: {
                return pSSysPortletBase.isSysAppFlagDirty();
            }
            case 79: {
                return pSSysPortletBase.isTemplEngineDirty();
            }
            case 80: {
                return pSSysPortletBase.isTitlePSLanResIdDirty();
            }
            case 81: {
                return pSSysPortletBase.isTitlePSLanResNameDirty();
            }
            case 82: {
                return pSSysPortletBase.isTitlePSSysPFPluginIdDirty();
            }
            case 83: {
                return pSSysPortletBase.isTitlePSSysPFPluginNameDirty();
            }
            case 84: {
                return pSSysPortletBase.isToDoTaskDirty();
            }
            case 85: {
                return pSSysPortletBase.isUpdateDateDirty();
            }
            case 86: {
                return pSSysPortletBase.isUpdateManDirty();
            }
            case 87: {
                return pSSysPortletBase.isUserTagDirty();
            }
            case 88: {
                return pSSysPortletBase.isUserTag2Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysPortletBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysPortletBase pSSysPortletBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysPortletBase.getADPSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"adpsdelogicid", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getADPSDELogicId()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getADPSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"adpsdelogicname", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getADPSDELogicName()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getBaseClsParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"baseclsparams", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getBaseClsParams()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getDashboardScope() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dashboardscope", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getDashboardScope()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getEmptyText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"emptytext", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getEmptyText()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getEmptyTextPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"emptytextpslanresid", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getEmptyTextPSLanResId()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getEmptyTextPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"emptytextpslanresname", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getEmptyTextPSLanResName()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getFilterPSDEDSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"filterpsdedsid", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getFilterPSDEDSId()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getFilterPSDEDSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"filterpsdedsname", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getFilterPSDEDSName()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getGroupExtractMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"groupextractmode", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getGroupExtractMode()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"height", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getHeight()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getHtmlShowMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"htmlshowmode", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getHtmlShowMode()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getHtmlUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"htmlurl", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getHtmlUrl()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getLogicName()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getPortletParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"portletparams", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getPortletParams()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getPortletStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"portletstyle", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getPortletStyle()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getPortletType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"portlettype", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getPortletType()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getPSACHandlerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psachandlerid", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getPSACHandlerId()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getPSACHandlerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psachandlername", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getPSACHandlerName()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getPSAppMenuId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappmenuid", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getPSAppMenuId()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getPSAppMenuName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappmenuname", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getPSAppMenuName()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getPSAppViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewid", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getPSAppViewId()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getPSAppViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewname", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getPSAppViewName()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getPSDEChartId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdechartid", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getPSDEChartId()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getPSDEChartName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdechartname", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getPSDEChartName()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getPSDEDataViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedataviewid", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getPSDEDataViewId()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getPSDEDataViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedataviewname", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getPSDEDataViewName()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getPSDEDSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedsid", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getPSDEDSId()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getPSDEDSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedsname", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getPSDEDSName()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getPSDEFormId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformid", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getPSDEFormId()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getPSDEFormName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformname", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getPSDEFormName()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getPSDEListId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelistid", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getPSDEListId()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getPSDEListName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelistname", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getPSDEListName()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getPSDEReportId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdereportid", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getPSDEReportId()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getPSDEReportName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdereportname", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getPSDEReportName()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getPSDEToolbarId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetoolbarid", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getPSDEToolbarId()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getPSDEToolbarName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetoolbarname", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getPSDEToolbarName()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getPSDEUAGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuagroupid", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getPSDEUAGroupId()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getPSDEUAGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuagroupname", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getPSDEUAGroupName()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getPSDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewid", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getPSDEViewId()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getPSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewname", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getPSDEViewName()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getPSPortletId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psportletid", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getPSPortletId()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getPSPortletName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psportletname", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getPSPortletName()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getPSSysCalendarId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscalendarid", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getPSSysCalendarId()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getPSSysCalendarName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscalendarname", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getPSSysCalendarName()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssid", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getPSSysCssId()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssname", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getPSSysCssName()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getPSSysImageId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimageid", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getPSSysImageId()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getPSSysImageName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimagename", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getPSSysImageName()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getPSSysMapViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmapviewid", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getPSSysMapViewId()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getPSSysMapViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmapviewname", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getPSSysMapViewName()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getPSSysPortletCatId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysportletcatid", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getPSSysPortletCatId()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getPSSysPortletCatName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysportletcatname", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getPSSysPortletCatName()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getPSSysPortletId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysportletid", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getPSSysPortletId()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getPSSysPortletName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysportletname", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getPSSysPortletName()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getPSSysReqItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemid", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getPSSysReqItemId()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getPSSysReqItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemname", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getPSSysReqItemName()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getPSSysUniResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuniresid", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getPSSysUniResId()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getPSSysUniResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuniresname", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getPSSysUniResName()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getPSSysViewPanelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelid", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getPSSysViewPanelId()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getPSSysViewPanelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelname", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getPSSysViewPanelName()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getReloadTimer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"reloadtimer", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getReloadTimer()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getShowTitleBar() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"showtitlebar", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getShowTitleBar()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getSysAppFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sysappflag", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getSysAppFlag()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getTemplEngine() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templengine", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getTemplEngine()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getTitlePSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"titlepslanresid", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getTitlePSLanResId()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getTitlePSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"titlepslanresname", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getTitlePSLanResName()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getTitlePSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"titlepssyspfpluginid", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getTitlePSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getTitlePSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"titlepssyspfpluginname", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getTitlePSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getToDoTask() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"todotask", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getToDoTask()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysPortletBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysPortletBase.getJSONValue((Object)pSSysPortletBase.getUserTag2()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysPortletBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysPortletBase pSSysPortletBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysPortletBase.getADPSDELogicId() != null) {
            object = pSSysPortletBase.getADPSDELogicId();
            xmlNode.setAttribute(FIELD_ADPSDELOGICID, (String)(object == null ? "" : object));
        }
        if (bl || pSSysPortletBase.getADPSDELogicName() != null) {
            object = pSSysPortletBase.getADPSDELogicName();
            xmlNode.setAttribute(FIELD_ADPSDELOGICNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSSysPortletBase.getBaseClsParams() != null) {
            object = pSSysPortletBase.getBaseClsParams();
            xmlNode.setAttribute(FIELD_BASECLSPARAMS, (String)(object == null ? "" : object));
        }
        if (bl || pSSysPortletBase.getCodeName() != null) {
            object = pSSysPortletBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getCreateDate() != null) {
            object = pSSysPortletBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysPortletBase.getCreateMan() != null) {
            object = pSSysPortletBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getDashboardScope() != null) {
            object = pSSysPortletBase.getDashboardScope();
            xmlNode.setAttribute(FIELD_DASHBOARDSCOPE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysPortletBase.getEmptyText() != null) {
            object = pSSysPortletBase.getEmptyText();
            xmlNode.setAttribute(FIELD_EMPTYTEXT, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getEmptyTextPSLanResId() != null) {
            object = pSSysPortletBase.getEmptyTextPSLanResId();
            xmlNode.setAttribute(FIELD_EMPTYTEXTPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getEmptyTextPSLanResName() != null) {
            object = pSSysPortletBase.getEmptyTextPSLanResName();
            xmlNode.setAttribute(FIELD_EMPTYTEXTPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getFilterPSDEDSId() != null) {
            object = pSSysPortletBase.getFilterPSDEDSId();
            xmlNode.setAttribute(FIELD_FILTERPSDEDSID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getFilterPSDEDSName() != null) {
            object = pSSysPortletBase.getFilterPSDEDSName();
            xmlNode.setAttribute(FIELD_FILTERPSDEDSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getGroupExtractMode() != null) {
            object = pSSysPortletBase.getGroupExtractMode();
            xmlNode.setAttribute(FIELD_GROUPEXTRACTMODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getHeight() != null) {
            object = pSSysPortletBase.getHeight();
            xmlNode.setAttribute(FIELD_HEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysPortletBase.getHtmlShowMode() != null) {
            object = pSSysPortletBase.getHtmlShowMode();
            xmlNode.setAttribute(FIELD_HTMLSHOWMODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getHtmlUrl() != null) {
            object = pSSysPortletBase.getHtmlUrl();
            xmlNode.setAttribute(FIELD_HTMLURL, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getLockFlag() != null) {
            object = pSSysPortletBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysPortletBase.getLogicName() != null) {
            object = pSSysPortletBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getMemo() != null) {
            object = pSSysPortletBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getPortletParams() != null) {
            object = pSSysPortletBase.getPortletParams();
            xmlNode.setAttribute(FIELD_PORTLETPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getPortletStyle() != null) {
            object = pSSysPortletBase.getPortletStyle();
            xmlNode.setAttribute(FIELD_PORTLETSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getPortletType() != null) {
            object = pSSysPortletBase.getPortletType();
            xmlNode.setAttribute(FIELD_PORTLETTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getPSACHandlerId() != null) {
            object = pSSysPortletBase.getPSACHandlerId();
            xmlNode.setAttribute(FIELD_PSACHANDLERID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getPSACHandlerName() != null) {
            object = pSSysPortletBase.getPSACHandlerName();
            xmlNode.setAttribute(FIELD_PSACHANDLERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getPSAppMenuId() != null) {
            object = pSSysPortletBase.getPSAppMenuId();
            xmlNode.setAttribute(FIELD_PSAPPMENUID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getPSAppMenuName() != null) {
            object = pSSysPortletBase.getPSAppMenuName();
            xmlNode.setAttribute(FIELD_PSAPPMENUNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getPSAppViewId() != null) {
            object = pSSysPortletBase.getPSAppViewId();
            xmlNode.setAttribute(FIELD_PSAPPVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getPSAppViewName() != null) {
            object = pSSysPortletBase.getPSAppViewName();
            xmlNode.setAttribute(FIELD_PSAPPVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getPSDEChartId() != null) {
            object = pSSysPortletBase.getPSDEChartId();
            xmlNode.setAttribute(FIELD_PSDECHARTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getPSDEChartName() != null) {
            object = pSSysPortletBase.getPSDEChartName();
            xmlNode.setAttribute(FIELD_PSDECHARTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getPSDEDataViewId() != null) {
            object = pSSysPortletBase.getPSDEDataViewId();
            xmlNode.setAttribute(FIELD_PSDEDATAVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getPSDEDataViewName() != null) {
            object = pSSysPortletBase.getPSDEDataViewName();
            xmlNode.setAttribute(FIELD_PSDEDATAVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getPSDEDSId() != null) {
            object = pSSysPortletBase.getPSDEDSId();
            xmlNode.setAttribute(FIELD_PSDEDSID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getPSDEDSName() != null) {
            object = pSSysPortletBase.getPSDEDSName();
            xmlNode.setAttribute(FIELD_PSDEDSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getPSDEFormId() != null) {
            object = pSSysPortletBase.getPSDEFormId();
            xmlNode.setAttribute(FIELD_PSDEFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getPSDEFormName() != null) {
            object = pSSysPortletBase.getPSDEFormName();
            xmlNode.setAttribute(FIELD_PSDEFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getPSDEId() != null) {
            object = pSSysPortletBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getPSDEListId() != null) {
            object = pSSysPortletBase.getPSDEListId();
            xmlNode.setAttribute(FIELD_PSDELISTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getPSDEListName() != null) {
            object = pSSysPortletBase.getPSDEListName();
            xmlNode.setAttribute(FIELD_PSDELISTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getPSDEName() != null) {
            object = pSSysPortletBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getPSDEReportId() != null) {
            object = pSSysPortletBase.getPSDEReportId();
            xmlNode.setAttribute(FIELD_PSDEREPORTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getPSDEReportName() != null) {
            object = pSSysPortletBase.getPSDEReportName();
            xmlNode.setAttribute(FIELD_PSDEREPORTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getPSDEToolbarId() != null) {
            object = pSSysPortletBase.getPSDEToolbarId();
            xmlNode.setAttribute(FIELD_PSDETOOLBARID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getPSDEToolbarName() != null) {
            object = pSSysPortletBase.getPSDEToolbarName();
            xmlNode.setAttribute(FIELD_PSDETOOLBARNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getPSDEUAGroupId() != null) {
            object = pSSysPortletBase.getPSDEUAGroupId();
            xmlNode.setAttribute(FIELD_PSDEUAGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getPSDEUAGroupName() != null) {
            object = pSSysPortletBase.getPSDEUAGroupName();
            xmlNode.setAttribute(FIELD_PSDEUAGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getPSDEViewId() != null) {
            object = pSSysPortletBase.getPSDEViewId();
            xmlNode.setAttribute(FIELD_PSDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getPSDEViewName() != null) {
            object = pSSysPortletBase.getPSDEViewName();
            xmlNode.setAttribute(FIELD_PSDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getPSModuleId() != null) {
            object = pSSysPortletBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getPSModuleName() != null) {
            object = pSSysPortletBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getPSPortletId() != null) {
            object = pSSysPortletBase.getPSPortletId();
            xmlNode.setAttribute(FIELD_PSPORTLETID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getPSPortletName() != null) {
            object = pSSysPortletBase.getPSPortletName();
            xmlNode.setAttribute(FIELD_PSPORTLETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getPSSysAppId() != null) {
            object = pSSysPortletBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getPSSysAppName() != null) {
            object = pSSysPortletBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getPSSysCalendarId() != null) {
            object = pSSysPortletBase.getPSSysCalendarId();
            xmlNode.setAttribute(FIELD_PSSYSCALENDARID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getPSSysCalendarName() != null) {
            object = pSSysPortletBase.getPSSysCalendarName();
            xmlNode.setAttribute(FIELD_PSSYSCALENDARNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getPSSysCssId() != null) {
            object = pSSysPortletBase.getPSSysCssId();
            xmlNode.setAttribute(FIELD_PSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getPSSysCssName() != null) {
            object = pSSysPortletBase.getPSSysCssName();
            xmlNode.setAttribute(FIELD_PSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getPSSysImageId() != null) {
            object = pSSysPortletBase.getPSSysImageId();
            xmlNode.setAttribute(FIELD_PSSYSIMAGEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getPSSysImageName() != null) {
            object = pSSysPortletBase.getPSSysImageName();
            xmlNode.setAttribute(FIELD_PSSYSIMAGENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getPSSysMapViewId() != null) {
            object = pSSysPortletBase.getPSSysMapViewId();
            xmlNode.setAttribute(FIELD_PSSYSMAPVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getPSSysMapViewName() != null) {
            object = pSSysPortletBase.getPSSysMapViewName();
            xmlNode.setAttribute(FIELD_PSSYSMAPVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getPSSysPFPluginId() != null) {
            object = pSSysPortletBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getPSSysPFPluginName() != null) {
            object = pSSysPortletBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getPSSysPortletCatId() != null) {
            object = pSSysPortletBase.getPSSysPortletCatId();
            xmlNode.setAttribute(FIELD_PSSYSPORTLETCATID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getPSSysPortletCatName() != null) {
            object = pSSysPortletBase.getPSSysPortletCatName();
            xmlNode.setAttribute(FIELD_PSSYSPORTLETCATNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getPSSysPortletId() != null) {
            object = pSSysPortletBase.getPSSysPortletId();
            xmlNode.setAttribute(FIELD_PSSYSPORTLETID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getPSSysPortletName() != null) {
            object = pSSysPortletBase.getPSSysPortletName();
            xmlNode.setAttribute(FIELD_PSSYSPORTLETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getPSSysReqItemId() != null) {
            object = pSSysPortletBase.getPSSysReqItemId();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getPSSysReqItemName() != null) {
            object = pSSysPortletBase.getPSSysReqItemName();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getPSSystemId() != null) {
            object = pSSysPortletBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getPSSystemName() != null) {
            object = pSSysPortletBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getPSSysUniResId() != null) {
            object = pSSysPortletBase.getPSSysUniResId();
            xmlNode.setAttribute(FIELD_PSSYSUNIRESID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getPSSysUniResName() != null) {
            object = pSSysPortletBase.getPSSysUniResName();
            xmlNode.setAttribute(FIELD_PSSYSUNIRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getPSSysViewPanelId() != null) {
            object = pSSysPortletBase.getPSSysViewPanelId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getPSSysViewPanelName() != null) {
            object = pSSysPortletBase.getPSSysViewPanelName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getReloadTimer() != null) {
            object = pSSysPortletBase.getReloadTimer();
            xmlNode.setAttribute(FIELD_RELOADTIMER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysPortletBase.getShowTitleBar() != null) {
            object = pSSysPortletBase.getShowTitleBar();
            xmlNode.setAttribute(FIELD_SHOWTITLEBAR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysPortletBase.getSysAppFlag() != null) {
            object = pSSysPortletBase.getSysAppFlag();
            xmlNode.setAttribute(FIELD_SYSAPPFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysPortletBase.getTemplEngine() != null) {
            object = pSSysPortletBase.getTemplEngine();
            xmlNode.setAttribute(FIELD_TEMPLENGINE, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getTitlePSLanResId() != null) {
            object = pSSysPortletBase.getTitlePSLanResId();
            xmlNode.setAttribute(FIELD_TITLEPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getTitlePSLanResName() != null) {
            object = pSSysPortletBase.getTitlePSLanResName();
            xmlNode.setAttribute(FIELD_TITLEPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getTitlePSSysPFPluginId() != null) {
            object = pSSysPortletBase.getTitlePSSysPFPluginId();
            xmlNode.setAttribute(FIELD_TITLEPSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getTitlePSSysPFPluginName() != null) {
            object = pSSysPortletBase.getTitlePSSysPFPluginName();
            xmlNode.setAttribute(FIELD_TITLEPSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getToDoTask() != null) {
            object = pSSysPortletBase.getToDoTask();
            xmlNode.setAttribute(FIELD_TODOTASK, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getUpdateDate() != null) {
            object = pSSysPortletBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysPortletBase.getUpdateMan() != null) {
            object = pSSysPortletBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getUserTag() != null) {
            object = pSSysPortletBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletBase.getUserTag2() != null) {
            object = pSSysPortletBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysPortletBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysPortletBase pSSysPortletBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysPortletBase.isADPSDELogicIdDirty() && (bl || pSSysPortletBase.getADPSDELogicId() != null)) {
            iDataObject.set(FIELD_ADPSDELOGICID, (Object)pSSysPortletBase.getADPSDELogicId());
        }
        if (pSSysPortletBase.isADPSDELogicNameDirty() && (bl || pSSysPortletBase.getADPSDELogicName() != null)) {
            iDataObject.set(FIELD_ADPSDELOGICNAME, (Object)pSSysPortletBase.getADPSDELogicName());
        }
        if (pSSysPortletBase.isBaseClsParamsDirty() && (bl || pSSysPortletBase.getBaseClsParams() != null)) {
            iDataObject.set(FIELD_BASECLSPARAMS, (Object)pSSysPortletBase.getBaseClsParams());
        }
        if (pSSysPortletBase.isCodeNameDirty() && (bl || pSSysPortletBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysPortletBase.getCodeName());
        }
        if (pSSysPortletBase.isCreateDateDirty() && (bl || pSSysPortletBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysPortletBase.getCreateDate());
        }
        if (pSSysPortletBase.isCreateManDirty() && (bl || pSSysPortletBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysPortletBase.getCreateMan());
        }
        if (pSSysPortletBase.isDashboardScopeDirty() && (bl || pSSysPortletBase.getDashboardScope() != null)) {
            iDataObject.set(FIELD_DASHBOARDSCOPE, (Object)pSSysPortletBase.getDashboardScope());
        }
        if (pSSysPortletBase.isEmptyTextDirty() && (bl || pSSysPortletBase.getEmptyText() != null)) {
            iDataObject.set(FIELD_EMPTYTEXT, (Object)pSSysPortletBase.getEmptyText());
        }
        if (pSSysPortletBase.isEmptyTextPSLanResIdDirty() && (bl || pSSysPortletBase.getEmptyTextPSLanResId() != null)) {
            iDataObject.set(FIELD_EMPTYTEXTPSLANRESID, (Object)pSSysPortletBase.getEmptyTextPSLanResId());
        }
        if (pSSysPortletBase.isEmptyTextPSLanResNameDirty() && (bl || pSSysPortletBase.getEmptyTextPSLanResName() != null)) {
            iDataObject.set(FIELD_EMPTYTEXTPSLANRESNAME, (Object)pSSysPortletBase.getEmptyTextPSLanResName());
        }
        if (pSSysPortletBase.isFilterPSDEDSIdDirty() && (bl || pSSysPortletBase.getFilterPSDEDSId() != null)) {
            iDataObject.set(FIELD_FILTERPSDEDSID, (Object)pSSysPortletBase.getFilterPSDEDSId());
        }
        if (pSSysPortletBase.isFilterPSDEDSNameDirty() && (bl || pSSysPortletBase.getFilterPSDEDSName() != null)) {
            iDataObject.set(FIELD_FILTERPSDEDSNAME, (Object)pSSysPortletBase.getFilterPSDEDSName());
        }
        if (pSSysPortletBase.isGroupExtractModeDirty() && (bl || pSSysPortletBase.getGroupExtractMode() != null)) {
            iDataObject.set(FIELD_GROUPEXTRACTMODE, (Object)pSSysPortletBase.getGroupExtractMode());
        }
        if (pSSysPortletBase.isHeightDirty() && (bl || pSSysPortletBase.getHeight() != null)) {
            iDataObject.set(FIELD_HEIGHT, (Object)pSSysPortletBase.getHeight());
        }
        if (pSSysPortletBase.isHtmlShowModeDirty() && (bl || pSSysPortletBase.getHtmlShowMode() != null)) {
            iDataObject.set(FIELD_HTMLSHOWMODE, (Object)pSSysPortletBase.getHtmlShowMode());
        }
        if (pSSysPortletBase.isHtmlUrlDirty() && (bl || pSSysPortletBase.getHtmlUrl() != null)) {
            iDataObject.set(FIELD_HTMLURL, (Object)pSSysPortletBase.getHtmlUrl());
        }
        if (pSSysPortletBase.isLockFlagDirty() && (bl || pSSysPortletBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSSysPortletBase.getLockFlag());
        }
        if (pSSysPortletBase.isLogicNameDirty() && (bl || pSSysPortletBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSSysPortletBase.getLogicName());
        }
        if (pSSysPortletBase.isMemoDirty() && (bl || pSSysPortletBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysPortletBase.getMemo());
        }
        if (pSSysPortletBase.isPortletParamsDirty() && (bl || pSSysPortletBase.getPortletParams() != null)) {
            iDataObject.set(FIELD_PORTLETPARAMS, (Object)pSSysPortletBase.getPortletParams());
        }
        if (pSSysPortletBase.isPortletStyleDirty() && (bl || pSSysPortletBase.getPortletStyle() != null)) {
            iDataObject.set(FIELD_PORTLETSTYLE, (Object)pSSysPortletBase.getPortletStyle());
        }
        if (pSSysPortletBase.isPortletTypeDirty() && (bl || pSSysPortletBase.getPortletType() != null)) {
            iDataObject.set(FIELD_PORTLETTYPE, (Object)pSSysPortletBase.getPortletType());
        }
        if (pSSysPortletBase.isPSACHandlerIdDirty() && (bl || pSSysPortletBase.getPSACHandlerId() != null)) {
            iDataObject.set(FIELD_PSACHANDLERID, (Object)pSSysPortletBase.getPSACHandlerId());
        }
        if (pSSysPortletBase.isPSACHandlerNameDirty() && (bl || pSSysPortletBase.getPSACHandlerName() != null)) {
            iDataObject.set(FIELD_PSACHANDLERNAME, (Object)pSSysPortletBase.getPSACHandlerName());
        }
        if (pSSysPortletBase.isPSAppMenuIdDirty() && (bl || pSSysPortletBase.getPSAppMenuId() != null)) {
            iDataObject.set(FIELD_PSAPPMENUID, (Object)pSSysPortletBase.getPSAppMenuId());
        }
        if (pSSysPortletBase.isPSAppMenuNameDirty() && (bl || pSSysPortletBase.getPSAppMenuName() != null)) {
            iDataObject.set(FIELD_PSAPPMENUNAME, (Object)pSSysPortletBase.getPSAppMenuName());
        }
        if (pSSysPortletBase.isPSAppViewIdDirty() && (bl || pSSysPortletBase.getPSAppViewId() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWID, (Object)pSSysPortletBase.getPSAppViewId());
        }
        if (pSSysPortletBase.isPSAppViewNameDirty() && (bl || pSSysPortletBase.getPSAppViewName() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWNAME, (Object)pSSysPortletBase.getPSAppViewName());
        }
        if (pSSysPortletBase.isPSDEChartIdDirty() && (bl || pSSysPortletBase.getPSDEChartId() != null)) {
            iDataObject.set(FIELD_PSDECHARTID, (Object)pSSysPortletBase.getPSDEChartId());
        }
        if (pSSysPortletBase.isPSDEChartNameDirty() && (bl || pSSysPortletBase.getPSDEChartName() != null)) {
            iDataObject.set(FIELD_PSDECHARTNAME, (Object)pSSysPortletBase.getPSDEChartName());
        }
        if (pSSysPortletBase.isPSDEDataViewIdDirty() && (bl || pSSysPortletBase.getPSDEDataViewId() != null)) {
            iDataObject.set(FIELD_PSDEDATAVIEWID, (Object)pSSysPortletBase.getPSDEDataViewId());
        }
        if (pSSysPortletBase.isPSDEDataViewNameDirty() && (bl || pSSysPortletBase.getPSDEDataViewName() != null)) {
            iDataObject.set(FIELD_PSDEDATAVIEWNAME, (Object)pSSysPortletBase.getPSDEDataViewName());
        }
        if (pSSysPortletBase.isPSDEDSIdDirty() && (bl || pSSysPortletBase.getPSDEDSId() != null)) {
            iDataObject.set(FIELD_PSDEDSID, (Object)pSSysPortletBase.getPSDEDSId());
        }
        if (pSSysPortletBase.isPSDEDSNameDirty() && (bl || pSSysPortletBase.getPSDEDSName() != null)) {
            iDataObject.set(FIELD_PSDEDSNAME, (Object)pSSysPortletBase.getPSDEDSName());
        }
        if (pSSysPortletBase.isPSDEFormIdDirty() && (bl || pSSysPortletBase.getPSDEFormId() != null)) {
            iDataObject.set(FIELD_PSDEFORMID, (Object)pSSysPortletBase.getPSDEFormId());
        }
        if (pSSysPortletBase.isPSDEFormNameDirty() && (bl || pSSysPortletBase.getPSDEFormName() != null)) {
            iDataObject.set(FIELD_PSDEFORMNAME, (Object)pSSysPortletBase.getPSDEFormName());
        }
        if (pSSysPortletBase.isPSDEIdDirty() && (bl || pSSysPortletBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysPortletBase.getPSDEId());
        }
        if (pSSysPortletBase.isPSDEListIdDirty() && (bl || pSSysPortletBase.getPSDEListId() != null)) {
            iDataObject.set(FIELD_PSDELISTID, (Object)pSSysPortletBase.getPSDEListId());
        }
        if (pSSysPortletBase.isPSDEListNameDirty() && (bl || pSSysPortletBase.getPSDEListName() != null)) {
            iDataObject.set(FIELD_PSDELISTNAME, (Object)pSSysPortletBase.getPSDEListName());
        }
        if (pSSysPortletBase.isPSDENameDirty() && (bl || pSSysPortletBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSSysPortletBase.getPSDEName());
        }
        if (pSSysPortletBase.isPSDEReportIdDirty() && (bl || pSSysPortletBase.getPSDEReportId() != null)) {
            iDataObject.set(FIELD_PSDEREPORTID, (Object)pSSysPortletBase.getPSDEReportId());
        }
        if (pSSysPortletBase.isPSDEReportNameDirty() && (bl || pSSysPortletBase.getPSDEReportName() != null)) {
            iDataObject.set(FIELD_PSDEREPORTNAME, (Object)pSSysPortletBase.getPSDEReportName());
        }
        if (pSSysPortletBase.isPSDEToolbarIdDirty() && (bl || pSSysPortletBase.getPSDEToolbarId() != null)) {
            iDataObject.set(FIELD_PSDETOOLBARID, (Object)pSSysPortletBase.getPSDEToolbarId());
        }
        if (pSSysPortletBase.isPSDEToolbarNameDirty() && (bl || pSSysPortletBase.getPSDEToolbarName() != null)) {
            iDataObject.set(FIELD_PSDETOOLBARNAME, (Object)pSSysPortletBase.getPSDEToolbarName());
        }
        if (pSSysPortletBase.isPSDEUAGroupIdDirty() && (bl || pSSysPortletBase.getPSDEUAGroupId() != null)) {
            iDataObject.set(FIELD_PSDEUAGROUPID, (Object)pSSysPortletBase.getPSDEUAGroupId());
        }
        if (pSSysPortletBase.isPSDEUAGroupNameDirty() && (bl || pSSysPortletBase.getPSDEUAGroupName() != null)) {
            iDataObject.set(FIELD_PSDEUAGROUPNAME, (Object)pSSysPortletBase.getPSDEUAGroupName());
        }
        if (pSSysPortletBase.isPSDEViewIdDirty() && (bl || pSSysPortletBase.getPSDEViewId() != null)) {
            iDataObject.set(FIELD_PSDEVIEWID, (Object)pSSysPortletBase.getPSDEViewId());
        }
        if (pSSysPortletBase.isPSDEViewNameDirty() && (bl || pSSysPortletBase.getPSDEViewName() != null)) {
            iDataObject.set(FIELD_PSDEVIEWNAME, (Object)pSSysPortletBase.getPSDEViewName());
        }
        if (pSSysPortletBase.isPSModuleIdDirty() && (bl || pSSysPortletBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysPortletBase.getPSModuleId());
        }
        if (pSSysPortletBase.isPSModuleNameDirty() && (bl || pSSysPortletBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysPortletBase.getPSModuleName());
        }
        if (pSSysPortletBase.isPSPortletIdDirty() && (bl || pSSysPortletBase.getPSPortletId() != null)) {
            iDataObject.set(FIELD_PSPORTLETID, (Object)pSSysPortletBase.getPSPortletId());
        }
        if (pSSysPortletBase.isPSPortletNameDirty() && (bl || pSSysPortletBase.getPSPortletName() != null)) {
            iDataObject.set(FIELD_PSPORTLETNAME, (Object)pSSysPortletBase.getPSPortletName());
        }
        if (pSSysPortletBase.isPSSysAppIdDirty() && (bl || pSSysPortletBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSSysPortletBase.getPSSysAppId());
        }
        if (pSSysPortletBase.isPSSysAppNameDirty() && (bl || pSSysPortletBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSSysPortletBase.getPSSysAppName());
        }
        if (pSSysPortletBase.isPSSysCalendarIdDirty() && (bl || pSSysPortletBase.getPSSysCalendarId() != null)) {
            iDataObject.set(FIELD_PSSYSCALENDARID, (Object)pSSysPortletBase.getPSSysCalendarId());
        }
        if (pSSysPortletBase.isPSSysCalendarNameDirty() && (bl || pSSysPortletBase.getPSSysCalendarName() != null)) {
            iDataObject.set(FIELD_PSSYSCALENDARNAME, (Object)pSSysPortletBase.getPSSysCalendarName());
        }
        if (pSSysPortletBase.isPSSysCssIdDirty() && (bl || pSSysPortletBase.getPSSysCssId() != null)) {
            iDataObject.set(FIELD_PSSYSCSSID, (Object)pSSysPortletBase.getPSSysCssId());
        }
        if (pSSysPortletBase.isPSSysCssNameDirty() && (bl || pSSysPortletBase.getPSSysCssName() != null)) {
            iDataObject.set(FIELD_PSSYSCSSNAME, (Object)pSSysPortletBase.getPSSysCssName());
        }
        if (pSSysPortletBase.isPSSysImageIdDirty() && (bl || pSSysPortletBase.getPSSysImageId() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGEID, (Object)pSSysPortletBase.getPSSysImageId());
        }
        if (pSSysPortletBase.isPSSysImageNameDirty() && (bl || pSSysPortletBase.getPSSysImageName() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGENAME, (Object)pSSysPortletBase.getPSSysImageName());
        }
        if (pSSysPortletBase.isPSSysMapViewIdDirty() && (bl || pSSysPortletBase.getPSSysMapViewId() != null)) {
            iDataObject.set(FIELD_PSSYSMAPVIEWID, (Object)pSSysPortletBase.getPSSysMapViewId());
        }
        if (pSSysPortletBase.isPSSysMapViewNameDirty() && (bl || pSSysPortletBase.getPSSysMapViewName() != null)) {
            iDataObject.set(FIELD_PSSYSMAPVIEWNAME, (Object)pSSysPortletBase.getPSSysMapViewName());
        }
        if (pSSysPortletBase.isPSSysPFPluginIdDirty() && (bl || pSSysPortletBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSSysPortletBase.getPSSysPFPluginId());
        }
        if (pSSysPortletBase.isPSSysPFPluginNameDirty() && (bl || pSSysPortletBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSSysPortletBase.getPSSysPFPluginName());
        }
        if (pSSysPortletBase.isPSSysPortletCatIdDirty() && (bl || pSSysPortletBase.getPSSysPortletCatId() != null)) {
            iDataObject.set(FIELD_PSSYSPORTLETCATID, (Object)pSSysPortletBase.getPSSysPortletCatId());
        }
        if (pSSysPortletBase.isPSSysPortletCatNameDirty() && (bl || pSSysPortletBase.getPSSysPortletCatName() != null)) {
            iDataObject.set(FIELD_PSSYSPORTLETCATNAME, (Object)pSSysPortletBase.getPSSysPortletCatName());
        }
        if (pSSysPortletBase.isPSSysPortletIdDirty() && (bl || pSSysPortletBase.getPSSysPortletId() != null)) {
            iDataObject.set(FIELD_PSSYSPORTLETID, (Object)pSSysPortletBase.getPSSysPortletId());
        }
        if (pSSysPortletBase.isPSSysPortletNameDirty() && (bl || pSSysPortletBase.getPSSysPortletName() != null)) {
            iDataObject.set(FIELD_PSSYSPORTLETNAME, (Object)pSSysPortletBase.getPSSysPortletName());
        }
        if (pSSysPortletBase.isPSSysReqItemIdDirty() && (bl || pSSysPortletBase.getPSSysReqItemId() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMID, (Object)pSSysPortletBase.getPSSysReqItemId());
        }
        if (pSSysPortletBase.isPSSysReqItemNameDirty() && (bl || pSSysPortletBase.getPSSysReqItemName() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMNAME, (Object)pSSysPortletBase.getPSSysReqItemName());
        }
        if (pSSysPortletBase.isPSSystemIdDirty() && (bl || pSSysPortletBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysPortletBase.getPSSystemId());
        }
        if (pSSysPortletBase.isPSSystemNameDirty() && (bl || pSSysPortletBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysPortletBase.getPSSystemName());
        }
        if (pSSysPortletBase.isPSSysUniResIdDirty() && (bl || pSSysPortletBase.getPSSysUniResId() != null)) {
            iDataObject.set(FIELD_PSSYSUNIRESID, (Object)pSSysPortletBase.getPSSysUniResId());
        }
        if (pSSysPortletBase.isPSSysUniResNameDirty() && (bl || pSSysPortletBase.getPSSysUniResName() != null)) {
            iDataObject.set(FIELD_PSSYSUNIRESNAME, (Object)pSSysPortletBase.getPSSysUniResName());
        }
        if (pSSysPortletBase.isPSSysViewPanelIdDirty() && (bl || pSSysPortletBase.getPSSysViewPanelId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELID, (Object)pSSysPortletBase.getPSSysViewPanelId());
        }
        if (pSSysPortletBase.isPSSysViewPanelNameDirty() && (bl || pSSysPortletBase.getPSSysViewPanelName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELNAME, (Object)pSSysPortletBase.getPSSysViewPanelName());
        }
        if (pSSysPortletBase.isReloadTimerDirty() && (bl || pSSysPortletBase.getReloadTimer() != null)) {
            iDataObject.set(FIELD_RELOADTIMER, (Object)pSSysPortletBase.getReloadTimer());
        }
        if (pSSysPortletBase.isShowTitleBarDirty() && (bl || pSSysPortletBase.getShowTitleBar() != null)) {
            iDataObject.set(FIELD_SHOWTITLEBAR, (Object)pSSysPortletBase.getShowTitleBar());
        }
        if (pSSysPortletBase.isSysAppFlagDirty() && (bl || pSSysPortletBase.getSysAppFlag() != null)) {
            iDataObject.set(FIELD_SYSAPPFLAG, (Object)pSSysPortletBase.getSysAppFlag());
        }
        if (pSSysPortletBase.isTemplEngineDirty() && (bl || pSSysPortletBase.getTemplEngine() != null)) {
            iDataObject.set(FIELD_TEMPLENGINE, (Object)pSSysPortletBase.getTemplEngine());
        }
        if (pSSysPortletBase.isTitlePSLanResIdDirty() && (bl || pSSysPortletBase.getTitlePSLanResId() != null)) {
            iDataObject.set(FIELD_TITLEPSLANRESID, (Object)pSSysPortletBase.getTitlePSLanResId());
        }
        if (pSSysPortletBase.isTitlePSLanResNameDirty() && (bl || pSSysPortletBase.getTitlePSLanResName() != null)) {
            iDataObject.set(FIELD_TITLEPSLANRESNAME, (Object)pSSysPortletBase.getTitlePSLanResName());
        }
        if (pSSysPortletBase.isTitlePSSysPFPluginIdDirty() && (bl || pSSysPortletBase.getTitlePSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_TITLEPSSYSPFPLUGINID, (Object)pSSysPortletBase.getTitlePSSysPFPluginId());
        }
        if (pSSysPortletBase.isTitlePSSysPFPluginNameDirty() && (bl || pSSysPortletBase.getTitlePSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_TITLEPSSYSPFPLUGINNAME, (Object)pSSysPortletBase.getTitlePSSysPFPluginName());
        }
        if (pSSysPortletBase.isToDoTaskDirty() && (bl || pSSysPortletBase.getToDoTask() != null)) {
            iDataObject.set(FIELD_TODOTASK, (Object)pSSysPortletBase.getToDoTask());
        }
        if (pSSysPortletBase.isUpdateDateDirty() && (bl || pSSysPortletBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysPortletBase.getUpdateDate());
        }
        if (pSSysPortletBase.isUpdateManDirty() && (bl || pSSysPortletBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysPortletBase.getUpdateMan());
        }
        if (pSSysPortletBase.isUserTagDirty() && (bl || pSSysPortletBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysPortletBase.getUserTag());
        }
        if (pSSysPortletBase.isUserTag2Dirty() && (bl || pSSysPortletBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysPortletBase.getUserTag2());
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
        return PSSysPortletBase.remove(this, n);
    }

    private static boolean remove(PSSysPortletBase pSSysPortletBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysPortletBase.resetADPSDELogicId();
                return true;
            }
            case 1: {
                pSSysPortletBase.resetADPSDELogicName();
                return true;
            }
            case 2: {
                pSSysPortletBase.resetBaseClsParams();
                return true;
            }
            case 3: {
                pSSysPortletBase.resetCodeName();
                return true;
            }
            case 4: {
                pSSysPortletBase.resetCreateDate();
                return true;
            }
            case 5: {
                pSSysPortletBase.resetCreateMan();
                return true;
            }
            case 6: {
                pSSysPortletBase.resetDashboardScope();
                return true;
            }
            case 7: {
                pSSysPortletBase.resetEmptyText();
                return true;
            }
            case 8: {
                pSSysPortletBase.resetEmptyTextPSLanResId();
                return true;
            }
            case 9: {
                pSSysPortletBase.resetEmptyTextPSLanResName();
                return true;
            }
            case 10: {
                pSSysPortletBase.resetFilterPSDEDSId();
                return true;
            }
            case 11: {
                pSSysPortletBase.resetFilterPSDEDSName();
                return true;
            }
            case 12: {
                pSSysPortletBase.resetGroupExtractMode();
                return true;
            }
            case 13: {
                pSSysPortletBase.resetHeight();
                return true;
            }
            case 14: {
                pSSysPortletBase.resetHtmlShowMode();
                return true;
            }
            case 15: {
                pSSysPortletBase.resetHtmlUrl();
                return true;
            }
            case 16: {
                pSSysPortletBase.resetLockFlag();
                return true;
            }
            case 17: {
                pSSysPortletBase.resetLogicName();
                return true;
            }
            case 18: {
                pSSysPortletBase.resetMemo();
                return true;
            }
            case 19: {
                pSSysPortletBase.resetPortletParams();
                return true;
            }
            case 20: {
                pSSysPortletBase.resetPortletStyle();
                return true;
            }
            case 21: {
                pSSysPortletBase.resetPortletType();
                return true;
            }
            case 22: {
                pSSysPortletBase.resetPSACHandlerId();
                return true;
            }
            case 23: {
                pSSysPortletBase.resetPSACHandlerName();
                return true;
            }
            case 24: {
                pSSysPortletBase.resetPSAppMenuId();
                return true;
            }
            case 25: {
                pSSysPortletBase.resetPSAppMenuName();
                return true;
            }
            case 26: {
                pSSysPortletBase.resetPSAppViewId();
                return true;
            }
            case 27: {
                pSSysPortletBase.resetPSAppViewName();
                return true;
            }
            case 28: {
                pSSysPortletBase.resetPSDEChartId();
                return true;
            }
            case 29: {
                pSSysPortletBase.resetPSDEChartName();
                return true;
            }
            case 30: {
                pSSysPortletBase.resetPSDEDataViewId();
                return true;
            }
            case 31: {
                pSSysPortletBase.resetPSDEDataViewName();
                return true;
            }
            case 32: {
                pSSysPortletBase.resetPSDEDSId();
                return true;
            }
            case 33: {
                pSSysPortletBase.resetPSDEDSName();
                return true;
            }
            case 34: {
                pSSysPortletBase.resetPSDEFormId();
                return true;
            }
            case 35: {
                pSSysPortletBase.resetPSDEFormName();
                return true;
            }
            case 36: {
                pSSysPortletBase.resetPSDEId();
                return true;
            }
            case 37: {
                pSSysPortletBase.resetPSDEListId();
                return true;
            }
            case 38: {
                pSSysPortletBase.resetPSDEListName();
                return true;
            }
            case 39: {
                pSSysPortletBase.resetPSDEName();
                return true;
            }
            case 40: {
                pSSysPortletBase.resetPSDEReportId();
                return true;
            }
            case 41: {
                pSSysPortletBase.resetPSDEReportName();
                return true;
            }
            case 42: {
                pSSysPortletBase.resetPSDEToolbarId();
                return true;
            }
            case 43: {
                pSSysPortletBase.resetPSDEToolbarName();
                return true;
            }
            case 44: {
                pSSysPortletBase.resetPSDEUAGroupId();
                return true;
            }
            case 45: {
                pSSysPortletBase.resetPSDEUAGroupName();
                return true;
            }
            case 46: {
                pSSysPortletBase.resetPSDEViewId();
                return true;
            }
            case 47: {
                pSSysPortletBase.resetPSDEViewName();
                return true;
            }
            case 48: {
                pSSysPortletBase.resetPSModuleId();
                return true;
            }
            case 49: {
                pSSysPortletBase.resetPSModuleName();
                return true;
            }
            case 50: {
                pSSysPortletBase.resetPSPortletId();
                return true;
            }
            case 51: {
                pSSysPortletBase.resetPSPortletName();
                return true;
            }
            case 52: {
                pSSysPortletBase.resetPSSysAppId();
                return true;
            }
            case 53: {
                pSSysPortletBase.resetPSSysAppName();
                return true;
            }
            case 54: {
                pSSysPortletBase.resetPSSysCalendarId();
                return true;
            }
            case 55: {
                pSSysPortletBase.resetPSSysCalendarName();
                return true;
            }
            case 56: {
                pSSysPortletBase.resetPSSysCssId();
                return true;
            }
            case 57: {
                pSSysPortletBase.resetPSSysCssName();
                return true;
            }
            case 58: {
                pSSysPortletBase.resetPSSysImageId();
                return true;
            }
            case 59: {
                pSSysPortletBase.resetPSSysImageName();
                return true;
            }
            case 60: {
                pSSysPortletBase.resetPSSysMapViewId();
                return true;
            }
            case 61: {
                pSSysPortletBase.resetPSSysMapViewName();
                return true;
            }
            case 62: {
                pSSysPortletBase.resetPSSysPFPluginId();
                return true;
            }
            case 63: {
                pSSysPortletBase.resetPSSysPFPluginName();
                return true;
            }
            case 64: {
                pSSysPortletBase.resetPSSysPortletCatId();
                return true;
            }
            case 65: {
                pSSysPortletBase.resetPSSysPortletCatName();
                return true;
            }
            case 66: {
                pSSysPortletBase.resetPSSysPortletId();
                return true;
            }
            case 67: {
                pSSysPortletBase.resetPSSysPortletName();
                return true;
            }
            case 68: {
                pSSysPortletBase.resetPSSysReqItemId();
                return true;
            }
            case 69: {
                pSSysPortletBase.resetPSSysReqItemName();
                return true;
            }
            case 70: {
                pSSysPortletBase.resetPSSystemId();
                return true;
            }
            case 71: {
                pSSysPortletBase.resetPSSystemName();
                return true;
            }
            case 72: {
                pSSysPortletBase.resetPSSysUniResId();
                return true;
            }
            case 73: {
                pSSysPortletBase.resetPSSysUniResName();
                return true;
            }
            case 74: {
                pSSysPortletBase.resetPSSysViewPanelId();
                return true;
            }
            case 75: {
                pSSysPortletBase.resetPSSysViewPanelName();
                return true;
            }
            case 76: {
                pSSysPortletBase.resetReloadTimer();
                return true;
            }
            case 77: {
                pSSysPortletBase.resetShowTitleBar();
                return true;
            }
            case 78: {
                pSSysPortletBase.resetSysAppFlag();
                return true;
            }
            case 79: {
                pSSysPortletBase.resetTemplEngine();
                return true;
            }
            case 80: {
                pSSysPortletBase.resetTitlePSLanResId();
                return true;
            }
            case 81: {
                pSSysPortletBase.resetTitlePSLanResName();
                return true;
            }
            case 82: {
                pSSysPortletBase.resetTitlePSSysPFPluginId();
                return true;
            }
            case 83: {
                pSSysPortletBase.resetTitlePSSysPFPluginName();
                return true;
            }
            case 84: {
                pSSysPortletBase.resetToDoTask();
                return true;
            }
            case 85: {
                pSSysPortletBase.resetUpdateDate();
                return true;
            }
            case 86: {
                pSSysPortletBase.resetUpdateMan();
                return true;
            }
            case 87: {
                pSSysPortletBase.resetUserTag();
                return true;
            }
            case 88: {
                pSSysPortletBase.resetUserTag2();
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
                pSACHandlerService.autoGet((IEntity)pSACHandler);
                this.psachandler = pSACHandler;
            }
            return this.psachandler;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppMenu getPSAppMenu() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppMenu();
        }
        if (this.getPSAppMenuId() == null) {
            return null;
        }
        Integer n = this.objPSAppMenuLock;
        synchronized (n) {
            if (this.psappmenu != null && DataTypeHelper.compare((int)25, (Object)this.getPSAppMenuId(), (Object)this.psappmenu.getPSAppMenuId()) != 0L) {
                this.psappmenu = null;
            }
            if (this.psappmenu == null) {
                PSAppMenu pSAppMenu = new PSAppMenu();
                pSAppMenu.setPSAppMenuId(this.getPSAppMenuId());
                PSAppMenuService pSAppMenuService = (PSAppMenuService)ServiceGlobal.getService(PSAppMenuService.class, (SessionFactory)this.getSessionFactory());
                pSAppMenuService.autoGet((IEntity)pSAppMenu);
                this.psappmenu = pSAppMenu;
            }
            return this.psappmenu;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppView getPSAppView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppView();
        }
        if (this.getPSAppViewId() == null) {
            return null;
        }
        Integer n = this.objPSAppViewLock;
        synchronized (n) {
            if (this.psappview != null && DataTypeHelper.compare((int)25, (Object)this.getPSAppViewId(), (Object)this.psappview.getPSAppViewId()) != 0L) {
                this.psappview = null;
            }
            if (this.psappview == null) {
                PSAppView pSAppView = new PSAppView();
                pSAppView.setPSAppViewId(this.getPSAppViewId());
                PSAppViewService pSAppViewService = (PSAppViewService)ServiceGlobal.getService(PSAppViewService.class, (SessionFactory)this.getSessionFactory());
                pSAppViewService.autoGet((IEntity)pSAppView);
                this.psappview = pSAppView;
            }
            return this.psappview;
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
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
                this.psde = pSDataEntity;
            }
            return this.psde;
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
                pSDEChartService.autoGet((IEntity)pSDEChart);
                this.psdechart = pSDEChart;
            }
            return this.psdechart;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataSet getFilterPSDEDS() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFilterPSDEDS();
        }
        if (this.getFilterPSDEDSId() == null) {
            return null;
        }
        Integer n = this.objFilterPSDEDSLock;
        synchronized (n) {
            if (this.filterpsdeds != null && DataTypeHelper.compare((int)25, (Object)this.getFilterPSDEDSId(), (Object)this.filterpsdeds.getPSDEDataSetId()) != 0L) {
                this.filterpsdeds = null;
            }
            if (this.filterpsdeds == null) {
                PSDEDataSet pSDEDataSet = new PSDEDataSet();
                pSDEDataSet.setPSDEDataSetId(this.getFilterPSDEDSId());
                PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataSetService.autoGet((IEntity)pSDEDataSet);
                this.filterpsdeds = pSDEDataSet;
            }
            return this.filterpsdeds;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataSet getPSDEDS() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDS();
        }
        if (this.getPSDEDSId() == null) {
            return null;
        }
        Integer n = this.objPSDEDSLock;
        synchronized (n) {
            if (this.psdeds != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDSId(), (Object)this.psdeds.getPSDEDataSetId()) != 0L) {
                this.psdeds = null;
            }
            if (this.psdeds == null) {
                PSDEDataSet pSDEDataSet = new PSDEDataSet();
                pSDEDataSet.setPSDEDataSetId(this.getPSDEDSId());
                PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataSetService.autoGet((IEntity)pSDEDataSet);
                this.psdeds = pSDEDataSet;
            }
            return this.psdeds;
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
                pSDEDataViewService.autoGet((IEntity)pSDEDataView);
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
                pSDEFormService.autoGet((IEntity)pSDEForm);
                this.psdeform = pSDEForm;
            }
            return this.psdeform;
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
                pSDEListService.autoGet((IEntity)pSDEList);
                this.psdelist = pSDEList;
            }
            return this.psdelist;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDELogic getADPSDElogic() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getADPSDElogic();
        }
        if (this.getADPSDELogicId() == null) {
            return null;
        }
        Integer n = this.objADPSDElogicLock;
        synchronized (n) {
            if (this.adpsdelogic != null && DataTypeHelper.compare((int)25, (Object)this.getADPSDELogicId(), (Object)this.adpsdelogic.getPSDELogicId()) != 0L) {
                this.adpsdelogic = null;
            }
            if (this.adpsdelogic == null) {
                PSDELogic pSDELogic = new PSDELogic();
                pSDELogic.setPSDELogicId(this.getADPSDELogicId());
                PSDELogicService pSDELogicService = (PSDELogicService)ServiceGlobal.getService(PSDELogicService.class, (SessionFactory)this.getSessionFactory());
                pSDELogicService.autoGet((IEntity)pSDELogic);
                this.adpsdelogic = pSDELogic;
            }
            return this.adpsdelogic;
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
                pSDEReportService.autoGet((IEntity)pSDEReport);
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
                pSDEToolbarService.autoGet((IEntity)pSDEToolbar);
                this.psdetoolbar = pSDEToolbar;
            }
            return this.psdetoolbar;
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
                pSDEUAGroupService.autoGet((IEntity)pSDEUAGroup);
                this.psdeuagroup = pSDEUAGroup;
            }
            return this.psdeuagroup;
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
                pSDEViewBaseService.autoGet((IEntity)pSDEViewBase);
                this.psdeview = pSDEViewBase;
            }
            return this.psdeview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getEmptyTextPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEmptyTextPSLanRes();
        }
        if (this.getEmptyTextPSLanResId() == null) {
            return null;
        }
        Integer n = this.objEmptyTextPSLanResLock;
        synchronized (n) {
            if (this.emptytextpslanres != null && DataTypeHelper.compare((int)25, (Object)this.getEmptyTextPSLanResId(), (Object)this.emptytextpslanres.getPSLanguageResId()) != 0L) {
                this.emptytextpslanres = null;
            }
            if (this.emptytextpslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getEmptyTextPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet((IEntity)pSLanguageRes);
                this.emptytextpslanres = pSLanguageRes;
            }
            return this.emptytextpslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getTitlePSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTitlePSLanRes();
        }
        if (this.getTitlePSLanResId() == null) {
            return null;
        }
        Integer n = this.objTitlePSLanResLock;
        synchronized (n) {
            if (this.titlepslanres != null && DataTypeHelper.compare((int)25, (Object)this.getTitlePSLanResId(), (Object)this.titlepslanres.getPSLanguageResId()) != 0L) {
                this.titlepslanres = null;
            }
            if (this.titlepslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getTitlePSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet((IEntity)pSLanguageRes);
                this.titlepslanres = pSLanguageRes;
            }
            return this.titlepslanres;
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
                pSModuleService.autoGet((IEntity)pSModule);
                this.psmodule = pSModule;
            }
            return this.psmodule;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPortlet getPSPortlet() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPortlet();
        }
        if (this.getPSPortletId() == null) {
            return null;
        }
        Integer n = this.objPSPortletLock;
        synchronized (n) {
            if (this.psportlet != null && DataTypeHelper.compare((int)25, (Object)this.getPSPortletId(), (Object)this.psportlet.getPSPortletId()) != 0L) {
                this.psportlet = null;
            }
            if (this.psportlet == null) {
                PSPortlet pSPortlet = new PSPortlet();
                pSPortlet.setPSPortletId(this.getPSPortletId());
                PSPortletService pSPortletService = (PSPortletService)ServiceGlobal.getService(PSPortletService.class, (SessionFactory)this.getSessionFactory());
                pSPortletService.autoGet((IEntity)pSPortlet);
                this.psportlet = pSPortlet;
            }
            return this.psportlet;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysApp getPSSysApp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysApp();
        }
        if (this.getPSSysAppId() == null) {
            return null;
        }
        Integer n = this.objPSSysAppLock;
        synchronized (n) {
            if (this.pssysapp != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysAppId(), (Object)this.pssysapp.getPSSysAppId()) != 0L) {
                this.pssysapp = null;
            }
            if (this.pssysapp == null) {
                PSSysApp pSSysApp = new PSSysApp();
                pSSysApp.setPSSysAppId(this.getPSSysAppId());
                PSSysAppService pSSysAppService = (PSSysAppService)ServiceGlobal.getService(PSSysAppService.class, (SessionFactory)this.getSessionFactory());
                pSSysAppService.autoGet((IEntity)pSSysApp);
                this.pssysapp = pSSysApp;
            }
            return this.pssysapp;
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
                pSSysCalendarService.autoGet((IEntity)pSSysCalendar);
                this.pssyscalendar = pSSysCalendar;
            }
            return this.pssyscalendar;
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
                pSSysCssService.autoGet((IEntity)pSSysCss);
                this.pssyscss = pSSysCss;
            }
            return this.pssyscss;
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
                pSSysImageService.autoGet((IEntity)pSSysImage);
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
                pSSysMapViewService.autoGet((IEntity)pSSysMapView);
                this.pssysmapview = pSSysMapView;
            }
            return this.pssysmapview;
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
                pSSysPFPluginService.autoGet((IEntity)pSSysPFPlugin);
                this.pssyspfplugin = pSSysPFPlugin;
            }
            return this.pssyspfplugin;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysPFPlugin getTitlePSSysPFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTitlePSSysPFPlugin();
        }
        if (this.getTitlePSSysPFPluginId() == null) {
            return null;
        }
        Integer n = this.objTitlePSSysPFPluginLock;
        synchronized (n) {
            if (this.titlepssyspfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getTitlePSSysPFPluginId(), (Object)this.titlepssyspfplugin.getPSSysPFPluginId()) != 0L) {
                this.titlepssyspfplugin = null;
            }
            if (this.titlepssyspfplugin == null) {
                PSSysPFPlugin pSSysPFPlugin = new PSSysPFPlugin();
                pSSysPFPlugin.setPSSysPFPluginId(this.getTitlePSSysPFPluginId());
                PSSysPFPluginService pSSysPFPluginService = (PSSysPFPluginService)ServiceGlobal.getService(PSSysPFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysPFPluginService.autoGet((IEntity)pSSysPFPlugin);
                this.titlepssyspfplugin = pSSysPFPlugin;
            }
            return this.titlepssyspfplugin;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysPortletCat getPSSysPortletCat() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPortletCat();
        }
        if (this.getPSSysPortletCatId() == null) {
            return null;
        }
        Integer n = this.objPSSysPortletCatLock;
        synchronized (n) {
            if (this.pssysportletcat != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysPortletCatId(), (Object)this.pssysportletcat.getPSSysPortletCatId()) != 0L) {
                this.pssysportletcat = null;
            }
            if (this.pssysportletcat == null) {
                PSSysPortletCat pSSysPortletCat = new PSSysPortletCat();
                pSSysPortletCat.setPSSysPortletCatId(this.getPSSysPortletCatId());
                PSSysPortletCatService pSSysPortletCatService = (PSSysPortletCatService)ServiceGlobal.getService(PSSysPortletCatService.class, (SessionFactory)this.getSessionFactory());
                pSSysPortletCatService.autoGet((IEntity)pSSysPortletCat);
                this.pssysportletcat = pSSysPortletCat;
            }
            return this.pssysportletcat;
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
                pSSysReqItemService.autoGet((IEntity)pSSysReqItem);
                this.pssysreqitem = pSSysReqItem;
            }
            return this.pssysreqitem;
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
                pSSystemService.autoGet((IEntity)pSSystem);
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
                pSSysUniResService.autoGet((IEntity)pSSysUniRes);
                this.pssysunires = pSSysUniRes;
            }
            return this.pssysunires;
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
                pSSysViewPanelService.autoGet((IEntity)pSSysViewPanel);
                this.pssysviewpanel = pSSysViewPanel;
            }
            return this.pssysviewpanel;
        }
    }

    private PSSysPortletBase getProxyEntity() {
        return this.proxyPSSysPortletBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysPortletBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysPortletBase) {
            this.proxyPSSysPortletBase = (PSSysPortletBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysPortletService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ADPSDELOGICID, 0);
        fieldIndexMap.put(FIELD_ADPSDELOGICNAME, 1);
        fieldIndexMap.put(FIELD_BASECLSPARAMS, 2);
        fieldIndexMap.put(FIELD_CODENAME, 3);
        fieldIndexMap.put(FIELD_CREATEDATE, 4);
        fieldIndexMap.put(FIELD_CREATEMAN, 5);
        fieldIndexMap.put(FIELD_DASHBOARDSCOPE, 6);
        fieldIndexMap.put(FIELD_EMPTYTEXT, 7);
        fieldIndexMap.put(FIELD_EMPTYTEXTPSLANRESID, 8);
        fieldIndexMap.put(FIELD_EMPTYTEXTPSLANRESNAME, 9);
        fieldIndexMap.put(FIELD_FILTERPSDEDSID, 10);
        fieldIndexMap.put(FIELD_FILTERPSDEDSNAME, 11);
        fieldIndexMap.put(FIELD_GROUPEXTRACTMODE, 12);
        fieldIndexMap.put(FIELD_HEIGHT, 13);
        fieldIndexMap.put(FIELD_HTMLSHOWMODE, 14);
        fieldIndexMap.put(FIELD_HTMLURL, 15);
        fieldIndexMap.put(FIELD_LOCKFLAG, 16);
        fieldIndexMap.put(FIELD_LOGICNAME, 17);
        fieldIndexMap.put(FIELD_MEMO, 18);
        fieldIndexMap.put(FIELD_PORTLETPARAMS, 19);
        fieldIndexMap.put(FIELD_PORTLETSTYLE, 20);
        fieldIndexMap.put(FIELD_PORTLETTYPE, 21);
        fieldIndexMap.put(FIELD_PSACHANDLERID, 22);
        fieldIndexMap.put(FIELD_PSACHANDLERNAME, 23);
        fieldIndexMap.put(FIELD_PSAPPMENUID, 24);
        fieldIndexMap.put(FIELD_PSAPPMENUNAME, 25);
        fieldIndexMap.put(FIELD_PSAPPVIEWID, 26);
        fieldIndexMap.put(FIELD_PSAPPVIEWNAME, 27);
        fieldIndexMap.put(FIELD_PSDECHARTID, 28);
        fieldIndexMap.put(FIELD_PSDECHARTNAME, 29);
        fieldIndexMap.put(FIELD_PSDEDATAVIEWID, 30);
        fieldIndexMap.put(FIELD_PSDEDATAVIEWNAME, 31);
        fieldIndexMap.put(FIELD_PSDEDSID, 32);
        fieldIndexMap.put(FIELD_PSDEDSNAME, 33);
        fieldIndexMap.put(FIELD_PSDEFORMID, 34);
        fieldIndexMap.put(FIELD_PSDEFORMNAME, 35);
        fieldIndexMap.put(FIELD_PSDEID, 36);
        fieldIndexMap.put(FIELD_PSDELISTID, 37);
        fieldIndexMap.put(FIELD_PSDELISTNAME, 38);
        fieldIndexMap.put(FIELD_PSDENAME, 39);
        fieldIndexMap.put(FIELD_PSDEREPORTID, 40);
        fieldIndexMap.put(FIELD_PSDEREPORTNAME, 41);
        fieldIndexMap.put(FIELD_PSDETOOLBARID, 42);
        fieldIndexMap.put(FIELD_PSDETOOLBARNAME, 43);
        fieldIndexMap.put(FIELD_PSDEUAGROUPID, 44);
        fieldIndexMap.put(FIELD_PSDEUAGROUPNAME, 45);
        fieldIndexMap.put(FIELD_PSDEVIEWID, 46);
        fieldIndexMap.put(FIELD_PSDEVIEWNAME, 47);
        fieldIndexMap.put(FIELD_PSMODULEID, 48);
        fieldIndexMap.put(FIELD_PSMODULENAME, 49);
        fieldIndexMap.put(FIELD_PSPORTLETID, 50);
        fieldIndexMap.put(FIELD_PSPORTLETNAME, 51);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 52);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 53);
        fieldIndexMap.put(FIELD_PSSYSCALENDARID, 54);
        fieldIndexMap.put(FIELD_PSSYSCALENDARNAME, 55);
        fieldIndexMap.put(FIELD_PSSYSCSSID, 56);
        fieldIndexMap.put(FIELD_PSSYSCSSNAME, 57);
        fieldIndexMap.put(FIELD_PSSYSIMAGEID, 58);
        fieldIndexMap.put(FIELD_PSSYSIMAGENAME, 59);
        fieldIndexMap.put(FIELD_PSSYSMAPVIEWID, 60);
        fieldIndexMap.put(FIELD_PSSYSMAPVIEWNAME, 61);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 62);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 63);
        fieldIndexMap.put(FIELD_PSSYSPORTLETCATID, 64);
        fieldIndexMap.put(FIELD_PSSYSPORTLETCATNAME, 65);
        fieldIndexMap.put(FIELD_PSSYSPORTLETID, 66);
        fieldIndexMap.put(FIELD_PSSYSPORTLETNAME, 67);
        fieldIndexMap.put(FIELD_PSSYSREQITEMID, 68);
        fieldIndexMap.put(FIELD_PSSYSREQITEMNAME, 69);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 70);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 71);
        fieldIndexMap.put(FIELD_PSSYSUNIRESID, 72);
        fieldIndexMap.put(FIELD_PSSYSUNIRESNAME, 73);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELID, 74);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELNAME, 75);
        fieldIndexMap.put(FIELD_RELOADTIMER, 76);
        fieldIndexMap.put(FIELD_SHOWTITLEBAR, 77);
        fieldIndexMap.put(FIELD_SYSAPPFLAG, 78);
        fieldIndexMap.put(FIELD_TEMPLENGINE, 79);
        fieldIndexMap.put(FIELD_TITLEPSLANRESID, 80);
        fieldIndexMap.put(FIELD_TITLEPSLANRESNAME, 81);
        fieldIndexMap.put(FIELD_TITLEPSSYSPFPLUGINID, 82);
        fieldIndexMap.put(FIELD_TITLEPSSYSPFPLUGINNAME, 83);
        fieldIndexMap.put(FIELD_TODOTASK, 84);
        fieldIndexMap.put(FIELD_UPDATEDATE, 85);
        fieldIndexMap.put(FIELD_UPDATEMAN, 86);
        fieldIndexMap.put(FIELD_USERTAG, 87);
        fieldIndexMap.put(FIELD_USERTAG2, 88);
    }
}

