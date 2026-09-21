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
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.service.PSSysPFPluginService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSACHandler;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlLogicGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelEngine;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelItemLogic;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLLCond;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLNParam;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLogicLink;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLogicNode;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLogicParam;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelLogic;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgGroup;
import net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCtrlLogicGroupService;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelEngineService;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelItemLogicService;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLLCondService;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLNParamService;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLogicLinkService;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLogicNodeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLogicParamService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelLogicService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGroupService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysViewPanelBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysViewPanelBase.class);
    public static final String FIELD_BODYONLYFLAG = "BODYONLYFLAG";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DATANAME = "DATANAME";
    public static final String FIELD_ENABLEPAGEFOOTER = "ENABLEPAGEFOOTER";
    public static final String FIELD_ENABLEPAGEHEADER = "ENABLEPAGEHEADER";
    public static final String FIELD_GETDATAMODE = "GETDATAMODE";
    public static final String FIELD_GETDATATIMER = "GETDATATIMER";
    public static final String FIELD_GETPSDEACTIONID = "GETPSDEACTIONID";
    public static final String FIELD_GETPSDEACTIONNAME = "GETPSDEACTIONNAME";
    public static final String FIELD_LAYOUTCAT = "LAYOUTCAT";
    public static final String FIELD_LAYOUTMODE = "LAYOUTMODE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MOBFLAG = "MOBFLAG";
    public static final String FIELD_NAVBARHEIGHT = "NAVBARHEIGHT";
    public static final String FIELD_NAVBARPOS = "NAVBARPOS";
    public static final String FIELD_NAVBARPSSYSCSSID = "NAVBARPSSYSCSSID";
    public static final String FIELD_NAVBARPSSYSCSSNAME = "NAVBARPSSYSCSSNAME";
    public static final String FIELD_NAVBARSTYLE = "NAVBARSTYLE";
    public static final String FIELD_NAVBARWIDTH = "NAVBARWIDTH";
    public static final String FIELD_OWNERID = "OWNERID";
    public static final String FIELD_OWNERTAG = "OWNERTAG";
    public static final String FIELD_OWNERTYPE = "OWNERTYPE";
    public static final String FIELD_PAGEFORMAT = "PAGEFORMAT";
    public static final String FIELD_PAGEHEIGHT = "PAGEHEIGHT";
    public static final String FIELD_PAGEMARGINBOTTOM = "PAGEMARGINBOTTOM";
    public static final String FIELD_PAGEMARGINLEFT = "PAGEMARGINLEFT";
    public static final String FIELD_PAGEMARGINRIGHT = "PAGEMARGINRIGHT";
    public static final String FIELD_PAGEMARGINTOP = "PAGEMARGINTOP";
    public static final String FIELD_PAGEWIDTH = "PAGEWIDTH";
    public static final String FIELD_PANELHEIGHT = "PANELHEIGHT";
    public static final String FIELD_PANELMODEL = "PANELMODEL";
    public static final String FIELD_PANELNAVBAR = "PANELNAVBAR";
    public static final String FIELD_PANELSTYLE = "PANELSTYLE";
    public static final String FIELD_PANELWIDTH = "PANELWIDTH";
    public static final String FIELD_PPI = "PPI";
    public static final String FIELD_PSACHANDLERID = "PSACHANDLERID";
    public static final String FIELD_PSACHANDLERNAME = "PSACHANDLERNAME";
    public static final String FIELD_PSCTRLLOGICGROUPID = "PSCTRLLOGICGROUPID";
    public static final String FIELD_PSCTRLLOGICGROUPNAME = "PSCTRLLOGICGROUPNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_PSSYSCSSID = "PSSYSCSSID";
    public static final String FIELD_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSSYSVIEWPANELID = "PSSYSVIEWPANELID";
    public static final String FIELD_PSSYSVIEWPANELNAME = "PSSYSVIEWPANELNAME";
    public static final String FIELD_PSVIEWMSGGROUPID = "PSVIEWMSGGROUPID";
    public static final String FIELD_PSVIEWMSGGROUPNAME = "PSVIEWMSGGROUPNAME";
    public static final String FIELD_PUBLICFLAG = "PUBLICFLAG";
    public static final String FIELD_SHOWFOOTERFIRSTPAGE = "SHOWFOOTERFIRSTPAGE";
    public static final String FIELD_SHOWHEADERFIRSTPAGE = "SHOWHEADERFIRSTPAGE";
    public static final String FIELD_SYSAPPFLAG = "SYSAPPFLAG";
    public static final String FIELD_TODOTASK = "TODOTASK";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VIEWLAYOUTFLAG = "VIEWLAYOUTFLAG";
    private static final int INDEX_BODYONLYFLAG = 0;
    private static final int INDEX_CODENAME = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_DATANAME = 4;
    private static final int INDEX_ENABLEPAGEFOOTER = 5;
    private static final int INDEX_ENABLEPAGEHEADER = 6;
    private static final int INDEX_GETDATAMODE = 7;
    private static final int INDEX_GETDATATIMER = 8;
    private static final int INDEX_GETPSDEACTIONID = 9;
    private static final int INDEX_GETPSDEACTIONNAME = 10;
    private static final int INDEX_LAYOUTCAT = 11;
    private static final int INDEX_LAYOUTMODE = 12;
    private static final int INDEX_MEMO = 13;
    private static final int INDEX_MOBFLAG = 14;
    private static final int INDEX_NAVBARHEIGHT = 15;
    private static final int INDEX_NAVBARPOS = 16;
    private static final int INDEX_NAVBARPSSYSCSSID = 17;
    private static final int INDEX_NAVBARPSSYSCSSNAME = 18;
    private static final int INDEX_NAVBARSTYLE = 19;
    private static final int INDEX_NAVBARWIDTH = 20;
    private static final int INDEX_OWNERID = 21;
    private static final int INDEX_OWNERTAG = 22;
    private static final int INDEX_OWNERTYPE = 23;
    private static final int INDEX_PAGEFORMAT = 24;
    private static final int INDEX_PAGEHEIGHT = 25;
    private static final int INDEX_PAGEMARGINBOTTOM = 26;
    private static final int INDEX_PAGEMARGINLEFT = 27;
    private static final int INDEX_PAGEMARGINRIGHT = 28;
    private static final int INDEX_PAGEMARGINTOP = 29;
    private static final int INDEX_PAGEWIDTH = 30;
    private static final int INDEX_PANELHEIGHT = 31;
    private static final int INDEX_PANELMODEL = 32;
    private static final int INDEX_PANELNAVBAR = 33;
    private static final int INDEX_PANELSTYLE = 34;
    private static final int INDEX_PANELWIDTH = 35;
    private static final int INDEX_PPI = 36;
    private static final int INDEX_PSACHANDLERID = 37;
    private static final int INDEX_PSACHANDLERNAME = 38;
    private static final int INDEX_PSCTRLLOGICGROUPID = 39;
    private static final int INDEX_PSCTRLLOGICGROUPNAME = 40;
    private static final int INDEX_PSDEID = 41;
    private static final int INDEX_PSDENAME = 42;
    private static final int INDEX_PSMODULEID = 43;
    private static final int INDEX_PSMODULENAME = 44;
    private static final int INDEX_PSSYSAPPID = 45;
    private static final int INDEX_PSSYSAPPNAME = 46;
    private static final int INDEX_PSSYSCSSID = 47;
    private static final int INDEX_PSSYSCSSNAME = 48;
    private static final int INDEX_PSSYSPFPLUGINID = 49;
    private static final int INDEX_PSSYSPFPLUGINNAME = 50;
    private static final int INDEX_PSSYSTEMID = 51;
    private static final int INDEX_PSSYSTEMNAME = 52;
    private static final int INDEX_PSSYSVIEWPANELID = 53;
    private static final int INDEX_PSSYSVIEWPANELNAME = 54;
    private static final int INDEX_PSVIEWMSGGROUPID = 55;
    private static final int INDEX_PSVIEWMSGGROUPNAME = 56;
    private static final int INDEX_PUBLICFLAG = 57;
    private static final int INDEX_SHOWFOOTERFIRSTPAGE = 58;
    private static final int INDEX_SHOWHEADERFIRSTPAGE = 59;
    private static final int INDEX_SYSAPPFLAG = 60;
    private static final int INDEX_TODOTASK = 61;
    private static final int INDEX_UPDATEDATE = 62;
    private static final int INDEX_UPDATEMAN = 63;
    private static final int INDEX_VIEWLAYOUTFLAG = 64;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysViewPanelBase proxyPSSysViewPanelBase = null;
    private boolean bodyonlyflagDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean datanameDirtyFlag = false;
    private boolean enablepagefooterDirtyFlag = false;
    private boolean enablepageheaderDirtyFlag = false;
    private boolean getdatamodeDirtyFlag = false;
    private boolean getdatatimerDirtyFlag = false;
    private boolean getpsdeactionidDirtyFlag = false;
    private boolean getpsdeactionnameDirtyFlag = false;
    private boolean layoutcatDirtyFlag = false;
    private boolean layoutmodeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean mobflagDirtyFlag = false;
    private boolean navbarheightDirtyFlag = false;
    private boolean navbarposDirtyFlag = false;
    private boolean navbarpssyscssidDirtyFlag = false;
    private boolean navbarpssyscssnameDirtyFlag = false;
    private boolean navbarstyleDirtyFlag = false;
    private boolean navbarwidthDirtyFlag = false;
    private boolean owneridDirtyFlag = false;
    private boolean ownertagDirtyFlag = false;
    private boolean ownertypeDirtyFlag = false;
    private boolean pageformatDirtyFlag = false;
    private boolean pageheightDirtyFlag = false;
    private boolean pagemarginbottomDirtyFlag = false;
    private boolean pagemarginleftDirtyFlag = false;
    private boolean pagemarginrightDirtyFlag = false;
    private boolean pagemargintopDirtyFlag = false;
    private boolean pagewidthDirtyFlag = false;
    private boolean panelheightDirtyFlag = false;
    private boolean panelmodelDirtyFlag = false;
    private boolean panelnavbarDirtyFlag = false;
    private boolean panelstyleDirtyFlag = false;
    private boolean panelwidthDirtyFlag = false;
    private boolean ppiDirtyFlag = false;
    private boolean psachandleridDirtyFlag = false;
    private boolean psachandlernameDirtyFlag = false;
    private boolean psctrllogicgroupidDirtyFlag = false;
    private boolean psctrllogicgroupnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean pssyscssidDirtyFlag = false;
    private boolean pssyscssnameDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean pssysviewpanelidDirtyFlag = false;
    private boolean pssysviewpanelnameDirtyFlag = false;
    private boolean psviewmsggroupidDirtyFlag = false;
    private boolean psviewmsggroupnameDirtyFlag = false;
    private boolean publicflagDirtyFlag = false;
    private boolean showfooterfirstpageDirtyFlag = false;
    private boolean showheaderfirstpageDirtyFlag = false;
    private boolean sysappflagDirtyFlag = false;
    private boolean todotaskDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean viewlayoutflagDirtyFlag = false;
    @Column(name="bodyonlyflag")
    private Integer bodyonlyflag;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dataname")
    private String dataname;
    @Column(name="enablepagefooter")
    private Integer enablepagefooter;
    @Column(name="enablepageheader")
    private Integer enablepageheader;
    @Column(name="getdatamode")
    private Integer getdatamode;
    @Column(name="getdatatimer")
    private Integer getdatatimer;
    @Column(name="getpsdeactionid")
    private String getpsdeactionid;
    @Column(name="getpsdeactionname")
    private String getpsdeactionname;
    @Column(name="layoutcat")
    private String layoutcat;
    @Column(name="layoutmode")
    private String layoutmode;
    @Column(name="memo")
    private String memo;
    @Column(name="mobflag")
    private Integer mobflag;
    @Column(name="navbarheight")
    private Integer navbarheight;
    @Column(name="navbarpos")
    private String navbarpos;
    @Column(name="navbarpssyscssid")
    private String navbarpssyscssid;
    @Column(name="navbarpssyscssname")
    private String navbarpssyscssname;
    @Column(name="navbarstyle")
    private String navbarstyle;
    @Column(name="navbarwidth")
    private Integer navbarwidth;
    @Column(name="ownerid")
    private String ownerid;
    @Column(name="ownertag")
    private String ownertag;
    @Column(name="ownertype")
    private String ownertype;
    @Column(name="pageformat")
    private String pageformat;
    @Column(name="pageheight")
    private Double pageheight;
    @Column(name="pagemarginbottom")
    private Double pagemarginbottom;
    @Column(name="pagemarginleft")
    private Double pagemarginleft;
    @Column(name="pagemarginright")
    private Double pagemarginright;
    @Column(name="pagemargintop")
    private Double pagemargintop;
    @Column(name="pagewidth")
    private Double pagewidth;
    @Column(name="panelheight")
    private Integer panelheight;
    @Column(name="panelmodel")
    private String panelmodel;
    @Column(name="panelnavbar")
    private Integer panelnavbar;
    @Column(name="panelstyle")
    private String panelstyle;
    @Column(name="panelwidth")
    private Integer panelwidth;
    @Column(name="ppi")
    private Double ppi;
    @Column(name="psachandlerid")
    private String psachandlerid;
    @Column(name="psachandlername")
    private String psachandlername;
    @Column(name="psctrllogicgroupid")
    private String psctrllogicgroupid;
    @Column(name="psctrllogicgroupname")
    private String psctrllogicgroupname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysappname")
    private String pssysappname;
    @Column(name="pssyscssid")
    private String pssyscssid;
    @Column(name="pssyscssname")
    private String pssyscssname;
    @Column(name="pssyspfpluginid")
    private String pssyspfpluginid;
    @Column(name="pssyspfpluginname")
    private String pssyspfpluginname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="pssysviewpanelid")
    private String pssysviewpanelid;
    @Column(name="pssysviewpanelname")
    private String pssysviewpanelname;
    @Column(name="psviewmsggroupid")
    private String psviewmsggroupid;
    @Column(name="psviewmsggroupname")
    private String psviewmsggroupname;
    @Column(name="publicflag")
    private Integer publicflag;
    @Column(name="showfooterfirstpage")
    private Integer showfooterfirstpage;
    @Column(name="showheaderfirstpage")
    private Integer showheaderfirstpage;
    @Column(name="sysappflag")
    private Integer sysappflag;
    @Column(name="todotask")
    private String todotask;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="viewlayoutflag")
    private Integer viewlayoutflag;
    private Integer objPSACHandlerLock = new Integer(1);
    private PSACHandler psachandler = null;
    private Integer objPSCtrlLogicGroupLock = new Integer(1);
    private PSCtrlLogicGroup psctrllogicgroup = null;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objGetPSDEActionLock = new Integer(1);
    private PSDEAction getpsdeaction = null;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSysAppLock = new Integer(1);
    private PSSysApp pssysapp = null;
    private Integer objNavBarPSSysCssLock = new Integer(1);
    private PSSysCss navbarpssyscss = null;
    private Integer objPSSysCssLock = new Integer(1);
    private PSSysCss pssyscss = null;
    private Integer objPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin pssyspfplugin = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSViewMsgGroupLock = new Integer(1);
    private PSViewMsgGroup psviewmsggroup = null;
    private Integer objPSPanelEnginesLock = new Integer(1);
    private ArrayList<PSPanelEngine> pspanelengines = null;
    private Integer objPSPanelItemLogicsLock = new Integer(1);
    private ArrayList<PSPanelItemLogic> pspanelitemlogics = null;
    private Integer objPSPanelLLCondsLock = new Integer(1);
    private ArrayList<PSPanelLLCond> pspanelllconds = null;
    private Integer objPSPanelLNParamsLock = new Integer(1);
    private ArrayList<PSPanelLNParam> pspanellnparams = null;
    private Integer objPSPanelLogicLinksLock = new Integer(1);
    private ArrayList<PSPanelLogicLink> pspanellogiclinks = null;
    private Integer objPSPanelLogicNodesLock = new Integer(1);
    private ArrayList<PSPanelLogicNode> pspanellogicnodes = null;
    private Integer objPSPanelLogicParamsLock = new Integer(1);
    private ArrayList<PSPanelLogicParam> pspanellogicparams = null;
    private Integer objPSSysViewPanelItemsLock = new Integer(1);
    private ArrayList<PSSysViewPanelItem> pssysviewpanelitems = null;
    private Integer objPSSysViewPanelLogicsLock = new Integer(1);
    private ArrayList<PSSysViewPanelLogic> pssysviewpanellogics = null;
    private Integer objPSSysViewPanelModelsLock = new Integer(1);
    private ArrayList<PSSysViewPanelModel> pssysviewpanelmodels = null;

    public void setBodyOnlyFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBodyOnlyFlag(n);
            return;
        }
        this.bodyonlyflag = n;
        this.bodyonlyflagDirtyFlag = true;
    }

    public Integer getBodyOnlyFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBodyOnlyFlag();
        }
        return this.bodyonlyflag;
    }

    public boolean isBodyOnlyFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBodyOnlyFlagDirty();
        }
        return this.bodyonlyflagDirtyFlag;
    }

    public void resetBodyOnlyFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBodyOnlyFlag();
            return;
        }
        this.bodyonlyflagDirtyFlag = false;
        this.bodyonlyflag = null;
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

    public void setDataName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dataname = string;
        this.datanameDirtyFlag = true;
    }

    public String getDataName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataName();
        }
        return this.dataname;
    }

    public boolean isDataNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataNameDirty();
        }
        return this.datanameDirtyFlag;
    }

    public void resetDataName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataName();
            return;
        }
        this.datanameDirtyFlag = false;
        this.dataname = null;
    }

    public void setEnablePageFooter(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnablePageFooter(n);
            return;
        }
        this.enablepagefooter = n;
        this.enablepagefooterDirtyFlag = true;
    }

    public Integer getEnablePageFooter() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnablePageFooter();
        }
        return this.enablepagefooter;
    }

    public boolean isEnablePageFooterDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnablePageFooterDirty();
        }
        return this.enablepagefooterDirtyFlag;
    }

    public void resetEnablePageFooter() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnablePageFooter();
            return;
        }
        this.enablepagefooterDirtyFlag = false;
        this.enablepagefooter = null;
    }

    public void setEnablePageHeader(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnablePageHeader(n);
            return;
        }
        this.enablepageheader = n;
        this.enablepageheaderDirtyFlag = true;
    }

    public Integer getEnablePageHeader() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnablePageHeader();
        }
        return this.enablepageheader;
    }

    public boolean isEnablePageHeaderDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnablePageHeaderDirty();
        }
        return this.enablepageheaderDirtyFlag;
    }

    public void resetEnablePageHeader() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnablePageHeader();
            return;
        }
        this.enablepageheaderDirtyFlag = false;
        this.enablepageheader = null;
    }

    public void setGetDataMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGetDataMode(n);
            return;
        }
        this.getdatamode = n;
        this.getdatamodeDirtyFlag = true;
    }

    public Integer getGetDataMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGetDataMode();
        }
        return this.getdatamode;
    }

    public boolean isGetDataModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGetDataModeDirty();
        }
        return this.getdatamodeDirtyFlag;
    }

    public void resetGetDataMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGetDataMode();
            return;
        }
        this.getdatamodeDirtyFlag = false;
        this.getdatamode = null;
    }

    public void setGetDataTimer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGetDataTimer(n);
            return;
        }
        this.getdatatimer = n;
        this.getdatatimerDirtyFlag = true;
    }

    public Integer getGetDataTimer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGetDataTimer();
        }
        return this.getdatatimer;
    }

    public boolean isGetDataTimerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGetDataTimerDirty();
        }
        return this.getdatatimerDirtyFlag;
    }

    public void resetGetDataTimer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGetDataTimer();
            return;
        }
        this.getdatatimerDirtyFlag = false;
        this.getdatatimer = null;
    }

    public void setGetPSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGetPSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.getpsdeactionid = string;
        this.getpsdeactionidDirtyFlag = true;
    }

    public String getGetPSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGetPSDEActionId();
        }
        return this.getpsdeactionid;
    }

    public boolean isGetPSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGetPSDEActionIdDirty();
        }
        return this.getpsdeactionidDirtyFlag;
    }

    public void resetGetPSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGetPSDEActionId();
            return;
        }
        this.getpsdeactionidDirtyFlag = false;
        this.getpsdeactionid = null;
    }

    public void setGetPSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGetPSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.getpsdeactionname = string;
        this.getpsdeactionnameDirtyFlag = true;
    }

    public String getGetPSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGetPSDEActionName();
        }
        return this.getpsdeactionname;
    }

    public boolean isGetPSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGetPSDEActionNameDirty();
        }
        return this.getpsdeactionnameDirtyFlag;
    }

    public void resetGetPSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGetPSDEActionName();
            return;
        }
        this.getpsdeactionnameDirtyFlag = false;
        this.getpsdeactionname = null;
    }

    public void setLayoutCat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLayoutCat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.layoutcat = string;
        this.layoutcatDirtyFlag = true;
    }

    public String getLayoutCat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLayoutCat();
        }
        return this.layoutcat;
    }

    public boolean isLayoutCatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLayoutCatDirty();
        }
        return this.layoutcatDirtyFlag;
    }

    public void resetLayoutCat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLayoutCat();
            return;
        }
        this.layoutcatDirtyFlag = false;
        this.layoutcat = null;
    }

    public void setLayoutMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLayoutMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.layoutmode = string;
        this.layoutmodeDirtyFlag = true;
    }

    public String getLayoutMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLayoutMode();
        }
        return this.layoutmode;
    }

    public boolean isLayoutModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLayoutModeDirty();
        }
        return this.layoutmodeDirtyFlag;
    }

    public void resetLayoutMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLayoutMode();
            return;
        }
        this.layoutmodeDirtyFlag = false;
        this.layoutmode = null;
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

    public void setMobFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobFlag(n);
            return;
        }
        this.mobflag = n;
        this.mobflagDirtyFlag = true;
    }

    public Integer getMobFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobFlag();
        }
        return this.mobflag;
    }

    public boolean isMobFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobFlagDirty();
        }
        return this.mobflagDirtyFlag;
    }

    public void resetMobFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobFlag();
            return;
        }
        this.mobflagDirtyFlag = false;
        this.mobflag = null;
    }

    public void setNavBarHeight(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNavBarHeight(n);
            return;
        }
        this.navbarheight = n;
        this.navbarheightDirtyFlag = true;
    }

    public Integer getNavBarHeight() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNavBarHeight();
        }
        return this.navbarheight;
    }

    public boolean isNavBarHeightDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNavBarHeightDirty();
        }
        return this.navbarheightDirtyFlag;
    }

    public void resetNavBarHeight() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNavBarHeight();
            return;
        }
        this.navbarheightDirtyFlag = false;
        this.navbarheight = null;
    }

    public void setNavBarPos(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNavBarPos(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.navbarpos = string;
        this.navbarposDirtyFlag = true;
    }

    public String getNavBarPos() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNavBarPos();
        }
        return this.navbarpos;
    }

    public boolean isNavBarPosDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNavBarPosDirty();
        }
        return this.navbarposDirtyFlag;
    }

    public void resetNavBarPos() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNavBarPos();
            return;
        }
        this.navbarposDirtyFlag = false;
        this.navbarpos = null;
    }

    public void setNavBarPSSysCssId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNavBarPSSysCssId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.navbarpssyscssid = string;
        this.navbarpssyscssidDirtyFlag = true;
    }

    public String getNavBarPSSysCssId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNavBarPSSysCssId();
        }
        return this.navbarpssyscssid;
    }

    public boolean isNavBarPSSysCssIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNavBarPSSysCssIdDirty();
        }
        return this.navbarpssyscssidDirtyFlag;
    }

    public void resetNavBarPSSysCssId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNavBarPSSysCssId();
            return;
        }
        this.navbarpssyscssidDirtyFlag = false;
        this.navbarpssyscssid = null;
    }

    public void setNavBarPSSysCssName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNavBarPSSysCssName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.navbarpssyscssname = string;
        this.navbarpssyscssnameDirtyFlag = true;
    }

    public String getNavBarPSSysCssName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNavBarPSSysCssName();
        }
        return this.navbarpssyscssname;
    }

    public boolean isNavBarPSSysCssNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNavBarPSSysCssNameDirty();
        }
        return this.navbarpssyscssnameDirtyFlag;
    }

    public void resetNavBarPSSysCssName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNavBarPSSysCssName();
            return;
        }
        this.navbarpssyscssnameDirtyFlag = false;
        this.navbarpssyscssname = null;
    }

    public void setNavBarStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNavBarStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.navbarstyle = string;
        this.navbarstyleDirtyFlag = true;
    }

    public String getNavBarStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNavBarStyle();
        }
        return this.navbarstyle;
    }

    public boolean isNavBarStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNavBarStyleDirty();
        }
        return this.navbarstyleDirtyFlag;
    }

    public void resetNavBarStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNavBarStyle();
            return;
        }
        this.navbarstyleDirtyFlag = false;
        this.navbarstyle = null;
    }

    public void setNavBarWidth(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNavBarWidth(n);
            return;
        }
        this.navbarwidth = n;
        this.navbarwidthDirtyFlag = true;
    }

    public Integer getNavBarWidth() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNavBarWidth();
        }
        return this.navbarwidth;
    }

    public boolean isNavBarWidthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNavBarWidthDirty();
        }
        return this.navbarwidthDirtyFlag;
    }

    public void resetNavBarWidth() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNavBarWidth();
            return;
        }
        this.navbarwidthDirtyFlag = false;
        this.navbarwidth = null;
    }

    public void setOwnerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOwnerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ownerid = string;
        this.owneridDirtyFlag = true;
    }

    public String getOwnerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOwnerId();
        }
        return this.ownerid;
    }

    public boolean isOwnerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOwnerIdDirty();
        }
        return this.owneridDirtyFlag;
    }

    public void resetOwnerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOwnerId();
            return;
        }
        this.owneridDirtyFlag = false;
        this.ownerid = null;
    }

    public void setOwnerTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOwnerTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ownertag = string;
        this.ownertagDirtyFlag = true;
    }

    public String getOwnerTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOwnerTag();
        }
        return this.ownertag;
    }

    public boolean isOwnerTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOwnerTagDirty();
        }
        return this.ownertagDirtyFlag;
    }

    public void resetOwnerTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOwnerTag();
            return;
        }
        this.ownertagDirtyFlag = false;
        this.ownertag = null;
    }

    public void setOwnerType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOwnerType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ownertype = string;
        this.ownertypeDirtyFlag = true;
    }

    public String getOwnerType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOwnerType();
        }
        return this.ownertype;
    }

    public boolean isOwnerTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOwnerTypeDirty();
        }
        return this.ownertypeDirtyFlag;
    }

    public void resetOwnerType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOwnerType();
            return;
        }
        this.ownertypeDirtyFlag = false;
        this.ownertype = null;
    }

    public void setPageFormat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPageFormat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pageformat = string;
        this.pageformatDirtyFlag = true;
    }

    public String getPageFormat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPageFormat();
        }
        return this.pageformat;
    }

    public boolean isPageFormatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPageFormatDirty();
        }
        return this.pageformatDirtyFlag;
    }

    public void resetPageFormat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPageFormat();
            return;
        }
        this.pageformatDirtyFlag = false;
        this.pageformat = null;
    }

    public void setPageHeight(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPageHeight(d);
            return;
        }
        this.pageheight = d;
        this.pageheightDirtyFlag = true;
    }

    public Double getPageHeight() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPageHeight();
        }
        return this.pageheight;
    }

    public boolean isPageHeightDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPageHeightDirty();
        }
        return this.pageheightDirtyFlag;
    }

    public void resetPageHeight() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPageHeight();
            return;
        }
        this.pageheightDirtyFlag = false;
        this.pageheight = null;
    }

    public void setPageMarginBottom(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPageMarginBottom(d);
            return;
        }
        this.pagemarginbottom = d;
        this.pagemarginbottomDirtyFlag = true;
    }

    public Double getPageMarginBottom() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPageMarginBottom();
        }
        return this.pagemarginbottom;
    }

    public boolean isPageMarginBottomDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPageMarginBottomDirty();
        }
        return this.pagemarginbottomDirtyFlag;
    }

    public void resetPageMarginBottom() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPageMarginBottom();
            return;
        }
        this.pagemarginbottomDirtyFlag = false;
        this.pagemarginbottom = null;
    }

    public void setPageMarginLeft(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPageMarginLeft(d);
            return;
        }
        this.pagemarginleft = d;
        this.pagemarginleftDirtyFlag = true;
    }

    public Double getPageMarginLeft() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPageMarginLeft();
        }
        return this.pagemarginleft;
    }

    public boolean isPageMarginLeftDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPageMarginLeftDirty();
        }
        return this.pagemarginleftDirtyFlag;
    }

    public void resetPageMarginLeft() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPageMarginLeft();
            return;
        }
        this.pagemarginleftDirtyFlag = false;
        this.pagemarginleft = null;
    }

    public void setPageMarginRight(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPageMarginRight(d);
            return;
        }
        this.pagemarginright = d;
        this.pagemarginrightDirtyFlag = true;
    }

    public Double getPageMarginRight() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPageMarginRight();
        }
        return this.pagemarginright;
    }

    public boolean isPageMarginRightDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPageMarginRightDirty();
        }
        return this.pagemarginrightDirtyFlag;
    }

    public void resetPageMarginRight() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPageMarginRight();
            return;
        }
        this.pagemarginrightDirtyFlag = false;
        this.pagemarginright = null;
    }

    public void setPageMarginTop(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPageMarginTop(d);
            return;
        }
        this.pagemargintop = d;
        this.pagemargintopDirtyFlag = true;
    }

    public Double getPageMarginTop() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPageMarginTop();
        }
        return this.pagemargintop;
    }

    public boolean isPageMarginTopDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPageMarginTopDirty();
        }
        return this.pagemargintopDirtyFlag;
    }

    public void resetPageMarginTop() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPageMarginTop();
            return;
        }
        this.pagemargintopDirtyFlag = false;
        this.pagemargintop = null;
    }

    public void setPageWidth(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPageWidth(d);
            return;
        }
        this.pagewidth = d;
        this.pagewidthDirtyFlag = true;
    }

    public Double getPageWidth() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPageWidth();
        }
        return this.pagewidth;
    }

    public boolean isPageWidthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPageWidthDirty();
        }
        return this.pagewidthDirtyFlag;
    }

    public void resetPageWidth() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPageWidth();
            return;
        }
        this.pagewidthDirtyFlag = false;
        this.pagewidth = null;
    }

    public void setPanelHeight(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPanelHeight(n);
            return;
        }
        this.panelheight = n;
        this.panelheightDirtyFlag = true;
    }

    public Integer getPanelHeight() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPanelHeight();
        }
        return this.panelheight;
    }

    public boolean isPanelHeightDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPanelHeightDirty();
        }
        return this.panelheightDirtyFlag;
    }

    public void resetPanelHeight() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPanelHeight();
            return;
        }
        this.panelheightDirtyFlag = false;
        this.panelheight = null;
    }

    public void setPanelModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPanelModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.panelmodel = string;
        this.panelmodelDirtyFlag = true;
    }

    public String getPanelModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPanelModel();
        }
        return this.panelmodel;
    }

    public boolean isPanelModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPanelModelDirty();
        }
        return this.panelmodelDirtyFlag;
    }

    public void resetPanelModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPanelModel();
            return;
        }
        this.panelmodelDirtyFlag = false;
        this.panelmodel = null;
    }

    public void setPanelNavBar(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPanelNavBar(n);
            return;
        }
        this.panelnavbar = n;
        this.panelnavbarDirtyFlag = true;
    }

    public Integer getPanelNavBar() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPanelNavBar();
        }
        return this.panelnavbar;
    }

    public boolean isPanelNavBarDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPanelNavBarDirty();
        }
        return this.panelnavbarDirtyFlag;
    }

    public void resetPanelNavBar() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPanelNavBar();
            return;
        }
        this.panelnavbarDirtyFlag = false;
        this.panelnavbar = null;
    }

    public void setPanelStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPanelStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.panelstyle = string;
        this.panelstyleDirtyFlag = true;
    }

    public String getPanelStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPanelStyle();
        }
        return this.panelstyle;
    }

    public boolean isPanelStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPanelStyleDirty();
        }
        return this.panelstyleDirtyFlag;
    }

    public void resetPanelStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPanelStyle();
            return;
        }
        this.panelstyleDirtyFlag = false;
        this.panelstyle = null;
    }

    public void setPanelWidth(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPanelWidth(n);
            return;
        }
        this.panelwidth = n;
        this.panelwidthDirtyFlag = true;
    }

    public Integer getPanelWidth() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPanelWidth();
        }
        return this.panelwidth;
    }

    public boolean isPanelWidthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPanelWidthDirty();
        }
        return this.panelwidthDirtyFlag;
    }

    public void resetPanelWidth() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPanelWidth();
            return;
        }
        this.panelwidthDirtyFlag = false;
        this.panelwidth = null;
    }

    public void setPPI(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPI(d);
            return;
        }
        this.ppi = d;
        this.ppiDirtyFlag = true;
    }

    public Double getPPI() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPI();
        }
        return this.ppi;
    }

    public boolean isPPIDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPIDirty();
        }
        return this.ppiDirtyFlag;
    }

    public void resetPPI() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPI();
            return;
        }
        this.ppiDirtyFlag = false;
        this.ppi = null;
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

    public void setPSViewMsgGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewMsgGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewmsggroupid = string;
        this.psviewmsggroupidDirtyFlag = true;
    }

    public String getPSViewMsgGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewMsgGroupId();
        }
        return this.psviewmsggroupid;
    }

    public boolean isPSViewMsgGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewMsgGroupIdDirty();
        }
        return this.psviewmsggroupidDirtyFlag;
    }

    public void resetPSViewMsgGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewMsgGroupId();
            return;
        }
        this.psviewmsggroupidDirtyFlag = false;
        this.psviewmsggroupid = null;
    }

    public void setPSViewMsgGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewMsgGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewmsggroupname = string;
        this.psviewmsggroupnameDirtyFlag = true;
    }

    public String getPSViewMsgGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewMsgGroupName();
        }
        return this.psviewmsggroupname;
    }

    public boolean isPSViewMsgGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewMsgGroupNameDirty();
        }
        return this.psviewmsggroupnameDirtyFlag;
    }

    public void resetPSViewMsgGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewMsgGroupName();
            return;
        }
        this.psviewmsggroupnameDirtyFlag = false;
        this.psviewmsggroupname = null;
    }

    public void setPublicFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPublicFlag(n);
            return;
        }
        this.publicflag = n;
        this.publicflagDirtyFlag = true;
    }

    public Integer getPublicFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPublicFlag();
        }
        return this.publicflag;
    }

    public boolean isPublicFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPublicFlagDirty();
        }
        return this.publicflagDirtyFlag;
    }

    public void resetPublicFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPublicFlag();
            return;
        }
        this.publicflagDirtyFlag = false;
        this.publicflag = null;
    }

    public void setShowFooterFirstPage(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setShowFooterFirstPage(n);
            return;
        }
        this.showfooterfirstpage = n;
        this.showfooterfirstpageDirtyFlag = true;
    }

    public Integer getShowFooterFirstPage() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getShowFooterFirstPage();
        }
        return this.showfooterfirstpage;
    }

    public boolean isShowFooterFirstPageDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isShowFooterFirstPageDirty();
        }
        return this.showfooterfirstpageDirtyFlag;
    }

    public void resetShowFooterFirstPage() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetShowFooterFirstPage();
            return;
        }
        this.showfooterfirstpageDirtyFlag = false;
        this.showfooterfirstpage = null;
    }

    public void setShowHeaderFirstPage(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setShowHeaderFirstPage(n);
            return;
        }
        this.showheaderfirstpage = n;
        this.showheaderfirstpageDirtyFlag = true;
    }

    public Integer getShowHeaderFirstPage() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getShowHeaderFirstPage();
        }
        return this.showheaderfirstpage;
    }

    public boolean isShowHeaderFirstPageDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isShowHeaderFirstPageDirty();
        }
        return this.showheaderfirstpageDirtyFlag;
    }

    public void resetShowHeaderFirstPage() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetShowHeaderFirstPage();
            return;
        }
        this.showheaderfirstpageDirtyFlag = false;
        this.showheaderfirstpage = null;
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

    public void setViewLayoutFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewLayoutFlag(n);
            return;
        }
        this.viewlayoutflag = n;
        this.viewlayoutflagDirtyFlag = true;
    }

    public Integer getViewLayoutFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewLayoutFlag();
        }
        return this.viewlayoutflag;
    }

    public boolean isViewLayoutFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewLayoutFlagDirty();
        }
        return this.viewlayoutflagDirtyFlag;
    }

    public void resetViewLayoutFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewLayoutFlag();
            return;
        }
        this.viewlayoutflagDirtyFlag = false;
        this.viewlayoutflag = null;
    }

    protected void onReset() {
        PSSysViewPanelBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysViewPanelBase pSSysViewPanelBase) {
        pSSysViewPanelBase.resetBodyOnlyFlag();
        pSSysViewPanelBase.resetCodeName();
        pSSysViewPanelBase.resetCreateDate();
        pSSysViewPanelBase.resetCreateMan();
        pSSysViewPanelBase.resetDataName();
        pSSysViewPanelBase.resetEnablePageFooter();
        pSSysViewPanelBase.resetEnablePageHeader();
        pSSysViewPanelBase.resetGetDataMode();
        pSSysViewPanelBase.resetGetDataTimer();
        pSSysViewPanelBase.resetGetPSDEActionId();
        pSSysViewPanelBase.resetGetPSDEActionName();
        pSSysViewPanelBase.resetLayoutCat();
        pSSysViewPanelBase.resetLayoutMode();
        pSSysViewPanelBase.resetMemo();
        pSSysViewPanelBase.resetMobFlag();
        pSSysViewPanelBase.resetNavBarHeight();
        pSSysViewPanelBase.resetNavBarPos();
        pSSysViewPanelBase.resetNavBarPSSysCssId();
        pSSysViewPanelBase.resetNavBarPSSysCssName();
        pSSysViewPanelBase.resetNavBarStyle();
        pSSysViewPanelBase.resetNavBarWidth();
        pSSysViewPanelBase.resetOwnerId();
        pSSysViewPanelBase.resetOwnerTag();
        pSSysViewPanelBase.resetOwnerType();
        pSSysViewPanelBase.resetPageFormat();
        pSSysViewPanelBase.resetPageHeight();
        pSSysViewPanelBase.resetPageMarginBottom();
        pSSysViewPanelBase.resetPageMarginLeft();
        pSSysViewPanelBase.resetPageMarginRight();
        pSSysViewPanelBase.resetPageMarginTop();
        pSSysViewPanelBase.resetPageWidth();
        pSSysViewPanelBase.resetPanelHeight();
        pSSysViewPanelBase.resetPanelModel();
        pSSysViewPanelBase.resetPanelNavBar();
        pSSysViewPanelBase.resetPanelStyle();
        pSSysViewPanelBase.resetPanelWidth();
        pSSysViewPanelBase.resetPPI();
        pSSysViewPanelBase.resetPSACHandlerId();
        pSSysViewPanelBase.resetPSACHandlerName();
        pSSysViewPanelBase.resetPSCtrlLogicGroupId();
        pSSysViewPanelBase.resetPSCtrlLogicGroupName();
        pSSysViewPanelBase.resetPSDEId();
        pSSysViewPanelBase.resetPSDEName();
        pSSysViewPanelBase.resetPSModuleId();
        pSSysViewPanelBase.resetPSModuleName();
        pSSysViewPanelBase.resetPSSysAppId();
        pSSysViewPanelBase.resetPSSysAppName();
        pSSysViewPanelBase.resetPSSysCssId();
        pSSysViewPanelBase.resetPSSysCssName();
        pSSysViewPanelBase.resetPSSysPFPluginId();
        pSSysViewPanelBase.resetPSSysPFPluginName();
        pSSysViewPanelBase.resetPSSystemId();
        pSSysViewPanelBase.resetPSSystemName();
        pSSysViewPanelBase.resetPSSysViewPanelId();
        pSSysViewPanelBase.resetPSSysViewPanelName();
        pSSysViewPanelBase.resetPSViewMsgGroupId();
        pSSysViewPanelBase.resetPSViewMsgGroupName();
        pSSysViewPanelBase.resetPublicFlag();
        pSSysViewPanelBase.resetShowFooterFirstPage();
        pSSysViewPanelBase.resetShowHeaderFirstPage();
        pSSysViewPanelBase.resetSysAppFlag();
        pSSysViewPanelBase.resetToDoTask();
        pSSysViewPanelBase.resetUpdateDate();
        pSSysViewPanelBase.resetUpdateMan();
        pSSysViewPanelBase.resetViewLayoutFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBodyOnlyFlagDirty()) {
            hashMap.put(FIELD_BODYONLYFLAG, this.getBodyOnlyFlag());
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
        if (!bl || this.isDataNameDirty()) {
            hashMap.put(FIELD_DATANAME, this.getDataName());
        }
        if (!bl || this.isEnablePageFooterDirty()) {
            hashMap.put(FIELD_ENABLEPAGEFOOTER, this.getEnablePageFooter());
        }
        if (!bl || this.isEnablePageHeaderDirty()) {
            hashMap.put(FIELD_ENABLEPAGEHEADER, this.getEnablePageHeader());
        }
        if (!bl || this.isGetDataModeDirty()) {
            hashMap.put(FIELD_GETDATAMODE, this.getGetDataMode());
        }
        if (!bl || this.isGetDataTimerDirty()) {
            hashMap.put(FIELD_GETDATATIMER, this.getGetDataTimer());
        }
        if (!bl || this.isGetPSDEActionIdDirty()) {
            hashMap.put(FIELD_GETPSDEACTIONID, this.getGetPSDEActionId());
        }
        if (!bl || this.isGetPSDEActionNameDirty()) {
            hashMap.put(FIELD_GETPSDEACTIONNAME, this.getGetPSDEActionName());
        }
        if (!bl || this.isLayoutCatDirty()) {
            hashMap.put(FIELD_LAYOUTCAT, this.getLayoutCat());
        }
        if (!bl || this.isLayoutModeDirty()) {
            hashMap.put(FIELD_LAYOUTMODE, this.getLayoutMode());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMobFlagDirty()) {
            hashMap.put(FIELD_MOBFLAG, this.getMobFlag());
        }
        if (!bl || this.isNavBarHeightDirty()) {
            hashMap.put(FIELD_NAVBARHEIGHT, this.getNavBarHeight());
        }
        if (!bl || this.isNavBarPosDirty()) {
            hashMap.put(FIELD_NAVBARPOS, this.getNavBarPos());
        }
        if (!bl || this.isNavBarPSSysCssIdDirty()) {
            hashMap.put(FIELD_NAVBARPSSYSCSSID, this.getNavBarPSSysCssId());
        }
        if (!bl || this.isNavBarPSSysCssNameDirty()) {
            hashMap.put(FIELD_NAVBARPSSYSCSSNAME, this.getNavBarPSSysCssName());
        }
        if (!bl || this.isNavBarStyleDirty()) {
            hashMap.put(FIELD_NAVBARSTYLE, this.getNavBarStyle());
        }
        if (!bl || this.isNavBarWidthDirty()) {
            hashMap.put(FIELD_NAVBARWIDTH, this.getNavBarWidth());
        }
        if (!bl || this.isOwnerIdDirty()) {
            hashMap.put(FIELD_OWNERID, this.getOwnerId());
        }
        if (!bl || this.isOwnerTagDirty()) {
            hashMap.put(FIELD_OWNERTAG, this.getOwnerTag());
        }
        if (!bl || this.isOwnerTypeDirty()) {
            hashMap.put(FIELD_OWNERTYPE, this.getOwnerType());
        }
        if (!bl || this.isPageFormatDirty()) {
            hashMap.put(FIELD_PAGEFORMAT, this.getPageFormat());
        }
        if (!bl || this.isPageHeightDirty()) {
            hashMap.put(FIELD_PAGEHEIGHT, this.getPageHeight());
        }
        if (!bl || this.isPageMarginBottomDirty()) {
            hashMap.put(FIELD_PAGEMARGINBOTTOM, this.getPageMarginBottom());
        }
        if (!bl || this.isPageMarginLeftDirty()) {
            hashMap.put(FIELD_PAGEMARGINLEFT, this.getPageMarginLeft());
        }
        if (!bl || this.isPageMarginRightDirty()) {
            hashMap.put(FIELD_PAGEMARGINRIGHT, this.getPageMarginRight());
        }
        if (!bl || this.isPageMarginTopDirty()) {
            hashMap.put(FIELD_PAGEMARGINTOP, this.getPageMarginTop());
        }
        if (!bl || this.isPageWidthDirty()) {
            hashMap.put(FIELD_PAGEWIDTH, this.getPageWidth());
        }
        if (!bl || this.isPanelHeightDirty()) {
            hashMap.put(FIELD_PANELHEIGHT, this.getPanelHeight());
        }
        if (!bl || this.isPanelModelDirty()) {
            hashMap.put(FIELD_PANELMODEL, this.getPanelModel());
        }
        if (!bl || this.isPanelNavBarDirty()) {
            hashMap.put(FIELD_PANELNAVBAR, this.getPanelNavBar());
        }
        if (!bl || this.isPanelStyleDirty()) {
            hashMap.put(FIELD_PANELSTYLE, this.getPanelStyle());
        }
        if (!bl || this.isPanelWidthDirty()) {
            hashMap.put(FIELD_PANELWIDTH, this.getPanelWidth());
        }
        if (!bl || this.isPPIDirty()) {
            hashMap.put(FIELD_PPI, this.getPPI());
        }
        if (!bl || this.isPSACHandlerIdDirty()) {
            hashMap.put(FIELD_PSACHANDLERID, this.getPSACHandlerId());
        }
        if (!bl || this.isPSACHandlerNameDirty()) {
            hashMap.put(FIELD_PSACHANDLERNAME, this.getPSACHandlerName());
        }
        if (!bl || this.isPSCtrlLogicGroupIdDirty()) {
            hashMap.put(FIELD_PSCTRLLOGICGROUPID, this.getPSCtrlLogicGroupId());
        }
        if (!bl || this.isPSCtrlLogicGroupNameDirty()) {
            hashMap.put(FIELD_PSCTRLLOGICGROUPNAME, this.getPSCtrlLogicGroupName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysAppNameDirty()) {
            hashMap.put(FIELD_PSSYSAPPNAME, this.getPSSysAppName());
        }
        if (!bl || this.isPSSysCssIdDirty()) {
            hashMap.put(FIELD_PSSYSCSSID, this.getPSSysCssId());
        }
        if (!bl || this.isPSSysCssNameDirty()) {
            hashMap.put(FIELD_PSSYSCSSNAME, this.getPSSysCssName());
        }
        if (!bl || this.isPSSysPFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINID, this.getPSSysPFPluginId());
        }
        if (!bl || this.isPSSysPFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINNAME, this.getPSSysPFPluginName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isPSSysViewPanelIdDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELID, this.getPSSysViewPanelId());
        }
        if (!bl || this.isPSSysViewPanelNameDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELNAME, this.getPSSysViewPanelName());
        }
        if (!bl || this.isPSViewMsgGroupIdDirty()) {
            hashMap.put(FIELD_PSVIEWMSGGROUPID, this.getPSViewMsgGroupId());
        }
        if (!bl || this.isPSViewMsgGroupNameDirty()) {
            hashMap.put(FIELD_PSVIEWMSGGROUPNAME, this.getPSViewMsgGroupName());
        }
        if (!bl || this.isPublicFlagDirty()) {
            hashMap.put(FIELD_PUBLICFLAG, this.getPublicFlag());
        }
        if (!bl || this.isShowFooterFirstPageDirty()) {
            hashMap.put(FIELD_SHOWFOOTERFIRSTPAGE, this.getShowFooterFirstPage());
        }
        if (!bl || this.isShowHeaderFirstPageDirty()) {
            hashMap.put(FIELD_SHOWHEADERFIRSTPAGE, this.getShowHeaderFirstPage());
        }
        if (!bl || this.isSysAppFlagDirty()) {
            hashMap.put(FIELD_SYSAPPFLAG, this.getSysAppFlag());
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
        if (!bl || this.isViewLayoutFlagDirty()) {
            hashMap.put(FIELD_VIEWLAYOUTFLAG, this.getViewLayoutFlag());
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
        return PSSysViewPanelBase.get(this, n);
    }

    private static Object get(PSSysViewPanelBase pSSysViewPanelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysViewPanelBase.getBodyOnlyFlag();
            }
            case 1: {
                return pSSysViewPanelBase.getCodeName();
            }
            case 2: {
                return pSSysViewPanelBase.getCreateDate();
            }
            case 3: {
                return pSSysViewPanelBase.getCreateMan();
            }
            case 4: {
                return pSSysViewPanelBase.getDataName();
            }
            case 5: {
                return pSSysViewPanelBase.getEnablePageFooter();
            }
            case 6: {
                return pSSysViewPanelBase.getEnablePageHeader();
            }
            case 7: {
                return pSSysViewPanelBase.getGetDataMode();
            }
            case 8: {
                return pSSysViewPanelBase.getGetDataTimer();
            }
            case 9: {
                return pSSysViewPanelBase.getGetPSDEActionId();
            }
            case 10: {
                return pSSysViewPanelBase.getGetPSDEActionName();
            }
            case 11: {
                return pSSysViewPanelBase.getLayoutCat();
            }
            case 12: {
                return pSSysViewPanelBase.getLayoutMode();
            }
            case 13: {
                return pSSysViewPanelBase.getMemo();
            }
            case 14: {
                return pSSysViewPanelBase.getMobFlag();
            }
            case 15: {
                return pSSysViewPanelBase.getNavBarHeight();
            }
            case 16: {
                return pSSysViewPanelBase.getNavBarPos();
            }
            case 17: {
                return pSSysViewPanelBase.getNavBarPSSysCssId();
            }
            case 18: {
                return pSSysViewPanelBase.getNavBarPSSysCssName();
            }
            case 19: {
                return pSSysViewPanelBase.getNavBarStyle();
            }
            case 20: {
                return pSSysViewPanelBase.getNavBarWidth();
            }
            case 21: {
                return pSSysViewPanelBase.getOwnerId();
            }
            case 22: {
                return pSSysViewPanelBase.getOwnerTag();
            }
            case 23: {
                return pSSysViewPanelBase.getOwnerType();
            }
            case 24: {
                return pSSysViewPanelBase.getPageFormat();
            }
            case 25: {
                return pSSysViewPanelBase.getPageHeight();
            }
            case 26: {
                return pSSysViewPanelBase.getPageMarginBottom();
            }
            case 27: {
                return pSSysViewPanelBase.getPageMarginLeft();
            }
            case 28: {
                return pSSysViewPanelBase.getPageMarginRight();
            }
            case 29: {
                return pSSysViewPanelBase.getPageMarginTop();
            }
            case 30: {
                return pSSysViewPanelBase.getPageWidth();
            }
            case 31: {
                return pSSysViewPanelBase.getPanelHeight();
            }
            case 32: {
                return pSSysViewPanelBase.getPanelModel();
            }
            case 33: {
                return pSSysViewPanelBase.getPanelNavBar();
            }
            case 34: {
                return pSSysViewPanelBase.getPanelStyle();
            }
            case 35: {
                return pSSysViewPanelBase.getPanelWidth();
            }
            case 36: {
                return pSSysViewPanelBase.getPPI();
            }
            case 37: {
                return pSSysViewPanelBase.getPSACHandlerId();
            }
            case 38: {
                return pSSysViewPanelBase.getPSACHandlerName();
            }
            case 39: {
                return pSSysViewPanelBase.getPSCtrlLogicGroupId();
            }
            case 40: {
                return pSSysViewPanelBase.getPSCtrlLogicGroupName();
            }
            case 41: {
                return pSSysViewPanelBase.getPSDEId();
            }
            case 42: {
                return pSSysViewPanelBase.getPSDEName();
            }
            case 43: {
                return pSSysViewPanelBase.getPSModuleId();
            }
            case 44: {
                return pSSysViewPanelBase.getPSModuleName();
            }
            case 45: {
                return pSSysViewPanelBase.getPSSysAppId();
            }
            case 46: {
                return pSSysViewPanelBase.getPSSysAppName();
            }
            case 47: {
                return pSSysViewPanelBase.getPSSysCssId();
            }
            case 48: {
                return pSSysViewPanelBase.getPSSysCssName();
            }
            case 49: {
                return pSSysViewPanelBase.getPSSysPFPluginId();
            }
            case 50: {
                return pSSysViewPanelBase.getPSSysPFPluginName();
            }
            case 51: {
                return pSSysViewPanelBase.getPSSystemId();
            }
            case 52: {
                return pSSysViewPanelBase.getPSSystemName();
            }
            case 53: {
                return pSSysViewPanelBase.getPSSysViewPanelId();
            }
            case 54: {
                return pSSysViewPanelBase.getPSSysViewPanelName();
            }
            case 55: {
                return pSSysViewPanelBase.getPSViewMsgGroupId();
            }
            case 56: {
                return pSSysViewPanelBase.getPSViewMsgGroupName();
            }
            case 57: {
                return pSSysViewPanelBase.getPublicFlag();
            }
            case 58: {
                return pSSysViewPanelBase.getShowFooterFirstPage();
            }
            case 59: {
                return pSSysViewPanelBase.getShowHeaderFirstPage();
            }
            case 60: {
                return pSSysViewPanelBase.getSysAppFlag();
            }
            case 61: {
                return pSSysViewPanelBase.getToDoTask();
            }
            case 62: {
                return pSSysViewPanelBase.getUpdateDate();
            }
            case 63: {
                return pSSysViewPanelBase.getUpdateMan();
            }
            case 64: {
                return pSSysViewPanelBase.getViewLayoutFlag();
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
        PSSysViewPanelBase.set(this, n, object);
    }

    private static void set(PSSysViewPanelBase pSSysViewPanelBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysViewPanelBase.setBodyOnlyFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSSysViewPanelBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysViewPanelBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSSysViewPanelBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysViewPanelBase.setDataName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysViewPanelBase.setEnablePageFooter(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSSysViewPanelBase.setEnablePageHeader(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSSysViewPanelBase.setGetDataMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSSysViewPanelBase.setGetDataTimer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSSysViewPanelBase.setGetPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysViewPanelBase.setGetPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysViewPanelBase.setLayoutCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysViewPanelBase.setLayoutMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysViewPanelBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysViewPanelBase.setMobFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSSysViewPanelBase.setNavBarHeight(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSSysViewPanelBase.setNavBarPos(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysViewPanelBase.setNavBarPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysViewPanelBase.setNavBarPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysViewPanelBase.setNavBarStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysViewPanelBase.setNavBarWidth(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 21: {
                pSSysViewPanelBase.setOwnerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysViewPanelBase.setOwnerTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysViewPanelBase.setOwnerType(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysViewPanelBase.setPageFormat(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysViewPanelBase.setPageHeight(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 26: {
                pSSysViewPanelBase.setPageMarginBottom(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 27: {
                pSSysViewPanelBase.setPageMarginLeft(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 28: {
                pSSysViewPanelBase.setPageMarginRight(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 29: {
                pSSysViewPanelBase.setPageMarginTop(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 30: {
                pSSysViewPanelBase.setPageWidth(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 31: {
                pSSysViewPanelBase.setPanelHeight(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 32: {
                pSSysViewPanelBase.setPanelModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysViewPanelBase.setPanelNavBar(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 34: {
                pSSysViewPanelBase.setPanelStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSysViewPanelBase.setPanelWidth(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 36: {
                pSSysViewPanelBase.setPPI(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 37: {
                pSSysViewPanelBase.setPSACHandlerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSSysViewPanelBase.setPSACHandlerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSSysViewPanelBase.setPSCtrlLogicGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSSysViewPanelBase.setPSCtrlLogicGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSSysViewPanelBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSSysViewPanelBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSSysViewPanelBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSSysViewPanelBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSSysViewPanelBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSSysViewPanelBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSSysViewPanelBase.setPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSSysViewPanelBase.setPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSSysViewPanelBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSSysViewPanelBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSSysViewPanelBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSSysViewPanelBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSSysViewPanelBase.setPSSysViewPanelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSSysViewPanelBase.setPSSysViewPanelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSSysViewPanelBase.setPSViewMsgGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSSysViewPanelBase.setPSViewMsgGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSSysViewPanelBase.setPublicFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 58: {
                pSSysViewPanelBase.setShowFooterFirstPage(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 59: {
                pSSysViewPanelBase.setShowHeaderFirstPage(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 60: {
                pSSysViewPanelBase.setSysAppFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 61: {
                pSSysViewPanelBase.setToDoTask(DataObject.getStringValue((Object)object));
                return;
            }
            case 62: {
                pSSysViewPanelBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 63: {
                pSSysViewPanelBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 64: {
                pSSysViewPanelBase.setViewLayoutFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysViewPanelBase.isNull(this, n);
    }

    private static boolean isNull(PSSysViewPanelBase pSSysViewPanelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysViewPanelBase.getBodyOnlyFlag() == null;
            }
            case 1: {
                return pSSysViewPanelBase.getCodeName() == null;
            }
            case 2: {
                return pSSysViewPanelBase.getCreateDate() == null;
            }
            case 3: {
                return pSSysViewPanelBase.getCreateMan() == null;
            }
            case 4: {
                return pSSysViewPanelBase.getDataName() == null;
            }
            case 5: {
                return pSSysViewPanelBase.getEnablePageFooter() == null;
            }
            case 6: {
                return pSSysViewPanelBase.getEnablePageHeader() == null;
            }
            case 7: {
                return pSSysViewPanelBase.getGetDataMode() == null;
            }
            case 8: {
                return pSSysViewPanelBase.getGetDataTimer() == null;
            }
            case 9: {
                return pSSysViewPanelBase.getGetPSDEActionId() == null;
            }
            case 10: {
                return pSSysViewPanelBase.getGetPSDEActionName() == null;
            }
            case 11: {
                return pSSysViewPanelBase.getLayoutCat() == null;
            }
            case 12: {
                return pSSysViewPanelBase.getLayoutMode() == null;
            }
            case 13: {
                return pSSysViewPanelBase.getMemo() == null;
            }
            case 14: {
                return pSSysViewPanelBase.getMobFlag() == null;
            }
            case 15: {
                return pSSysViewPanelBase.getNavBarHeight() == null;
            }
            case 16: {
                return pSSysViewPanelBase.getNavBarPos() == null;
            }
            case 17: {
                return pSSysViewPanelBase.getNavBarPSSysCssId() == null;
            }
            case 18: {
                return pSSysViewPanelBase.getNavBarPSSysCssName() == null;
            }
            case 19: {
                return pSSysViewPanelBase.getNavBarStyle() == null;
            }
            case 20: {
                return pSSysViewPanelBase.getNavBarWidth() == null;
            }
            case 21: {
                return pSSysViewPanelBase.getOwnerId() == null;
            }
            case 22: {
                return pSSysViewPanelBase.getOwnerTag() == null;
            }
            case 23: {
                return pSSysViewPanelBase.getOwnerType() == null;
            }
            case 24: {
                return pSSysViewPanelBase.getPageFormat() == null;
            }
            case 25: {
                return pSSysViewPanelBase.getPageHeight() == null;
            }
            case 26: {
                return pSSysViewPanelBase.getPageMarginBottom() == null;
            }
            case 27: {
                return pSSysViewPanelBase.getPageMarginLeft() == null;
            }
            case 28: {
                return pSSysViewPanelBase.getPageMarginRight() == null;
            }
            case 29: {
                return pSSysViewPanelBase.getPageMarginTop() == null;
            }
            case 30: {
                return pSSysViewPanelBase.getPageWidth() == null;
            }
            case 31: {
                return pSSysViewPanelBase.getPanelHeight() == null;
            }
            case 32: {
                return pSSysViewPanelBase.getPanelModel() == null;
            }
            case 33: {
                return pSSysViewPanelBase.getPanelNavBar() == null;
            }
            case 34: {
                return pSSysViewPanelBase.getPanelStyle() == null;
            }
            case 35: {
                return pSSysViewPanelBase.getPanelWidth() == null;
            }
            case 36: {
                return pSSysViewPanelBase.getPPI() == null;
            }
            case 37: {
                return pSSysViewPanelBase.getPSACHandlerId() == null;
            }
            case 38: {
                return pSSysViewPanelBase.getPSACHandlerName() == null;
            }
            case 39: {
                return pSSysViewPanelBase.getPSCtrlLogicGroupId() == null;
            }
            case 40: {
                return pSSysViewPanelBase.getPSCtrlLogicGroupName() == null;
            }
            case 41: {
                return pSSysViewPanelBase.getPSDEId() == null;
            }
            case 42: {
                return pSSysViewPanelBase.getPSDEName() == null;
            }
            case 43: {
                return pSSysViewPanelBase.getPSModuleId() == null;
            }
            case 44: {
                return pSSysViewPanelBase.getPSModuleName() == null;
            }
            case 45: {
                return pSSysViewPanelBase.getPSSysAppId() == null;
            }
            case 46: {
                return pSSysViewPanelBase.getPSSysAppName() == null;
            }
            case 47: {
                return pSSysViewPanelBase.getPSSysCssId() == null;
            }
            case 48: {
                return pSSysViewPanelBase.getPSSysCssName() == null;
            }
            case 49: {
                return pSSysViewPanelBase.getPSSysPFPluginId() == null;
            }
            case 50: {
                return pSSysViewPanelBase.getPSSysPFPluginName() == null;
            }
            case 51: {
                return pSSysViewPanelBase.getPSSystemId() == null;
            }
            case 52: {
                return pSSysViewPanelBase.getPSSystemName() == null;
            }
            case 53: {
                return pSSysViewPanelBase.getPSSysViewPanelId() == null;
            }
            case 54: {
                return pSSysViewPanelBase.getPSSysViewPanelName() == null;
            }
            case 55: {
                return pSSysViewPanelBase.getPSViewMsgGroupId() == null;
            }
            case 56: {
                return pSSysViewPanelBase.getPSViewMsgGroupName() == null;
            }
            case 57: {
                return pSSysViewPanelBase.getPublicFlag() == null;
            }
            case 58: {
                return pSSysViewPanelBase.getShowFooterFirstPage() == null;
            }
            case 59: {
                return pSSysViewPanelBase.getShowHeaderFirstPage() == null;
            }
            case 60: {
                return pSSysViewPanelBase.getSysAppFlag() == null;
            }
            case 61: {
                return pSSysViewPanelBase.getToDoTask() == null;
            }
            case 62: {
                return pSSysViewPanelBase.getUpdateDate() == null;
            }
            case 63: {
                return pSSysViewPanelBase.getUpdateMan() == null;
            }
            case 64: {
                return pSSysViewPanelBase.getViewLayoutFlag() == null;
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
        return PSSysViewPanelBase.contains(this, n);
    }

    private static boolean contains(PSSysViewPanelBase pSSysViewPanelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysViewPanelBase.isBodyOnlyFlagDirty();
            }
            case 1: {
                return pSSysViewPanelBase.isCodeNameDirty();
            }
            case 2: {
                return pSSysViewPanelBase.isCreateDateDirty();
            }
            case 3: {
                return pSSysViewPanelBase.isCreateManDirty();
            }
            case 4: {
                return pSSysViewPanelBase.isDataNameDirty();
            }
            case 5: {
                return pSSysViewPanelBase.isEnablePageFooterDirty();
            }
            case 6: {
                return pSSysViewPanelBase.isEnablePageHeaderDirty();
            }
            case 7: {
                return pSSysViewPanelBase.isGetDataModeDirty();
            }
            case 8: {
                return pSSysViewPanelBase.isGetDataTimerDirty();
            }
            case 9: {
                return pSSysViewPanelBase.isGetPSDEActionIdDirty();
            }
            case 10: {
                return pSSysViewPanelBase.isGetPSDEActionNameDirty();
            }
            case 11: {
                return pSSysViewPanelBase.isLayoutCatDirty();
            }
            case 12: {
                return pSSysViewPanelBase.isLayoutModeDirty();
            }
            case 13: {
                return pSSysViewPanelBase.isMemoDirty();
            }
            case 14: {
                return pSSysViewPanelBase.isMobFlagDirty();
            }
            case 15: {
                return pSSysViewPanelBase.isNavBarHeightDirty();
            }
            case 16: {
                return pSSysViewPanelBase.isNavBarPosDirty();
            }
            case 17: {
                return pSSysViewPanelBase.isNavBarPSSysCssIdDirty();
            }
            case 18: {
                return pSSysViewPanelBase.isNavBarPSSysCssNameDirty();
            }
            case 19: {
                return pSSysViewPanelBase.isNavBarStyleDirty();
            }
            case 20: {
                return pSSysViewPanelBase.isNavBarWidthDirty();
            }
            case 21: {
                return pSSysViewPanelBase.isOwnerIdDirty();
            }
            case 22: {
                return pSSysViewPanelBase.isOwnerTagDirty();
            }
            case 23: {
                return pSSysViewPanelBase.isOwnerTypeDirty();
            }
            case 24: {
                return pSSysViewPanelBase.isPageFormatDirty();
            }
            case 25: {
                return pSSysViewPanelBase.isPageHeightDirty();
            }
            case 26: {
                return pSSysViewPanelBase.isPageMarginBottomDirty();
            }
            case 27: {
                return pSSysViewPanelBase.isPageMarginLeftDirty();
            }
            case 28: {
                return pSSysViewPanelBase.isPageMarginRightDirty();
            }
            case 29: {
                return pSSysViewPanelBase.isPageMarginTopDirty();
            }
            case 30: {
                return pSSysViewPanelBase.isPageWidthDirty();
            }
            case 31: {
                return pSSysViewPanelBase.isPanelHeightDirty();
            }
            case 32: {
                return pSSysViewPanelBase.isPanelModelDirty();
            }
            case 33: {
                return pSSysViewPanelBase.isPanelNavBarDirty();
            }
            case 34: {
                return pSSysViewPanelBase.isPanelStyleDirty();
            }
            case 35: {
                return pSSysViewPanelBase.isPanelWidthDirty();
            }
            case 36: {
                return pSSysViewPanelBase.isPPIDirty();
            }
            case 37: {
                return pSSysViewPanelBase.isPSACHandlerIdDirty();
            }
            case 38: {
                return pSSysViewPanelBase.isPSACHandlerNameDirty();
            }
            case 39: {
                return pSSysViewPanelBase.isPSCtrlLogicGroupIdDirty();
            }
            case 40: {
                return pSSysViewPanelBase.isPSCtrlLogicGroupNameDirty();
            }
            case 41: {
                return pSSysViewPanelBase.isPSDEIdDirty();
            }
            case 42: {
                return pSSysViewPanelBase.isPSDENameDirty();
            }
            case 43: {
                return pSSysViewPanelBase.isPSModuleIdDirty();
            }
            case 44: {
                return pSSysViewPanelBase.isPSModuleNameDirty();
            }
            case 45: {
                return pSSysViewPanelBase.isPSSysAppIdDirty();
            }
            case 46: {
                return pSSysViewPanelBase.isPSSysAppNameDirty();
            }
            case 47: {
                return pSSysViewPanelBase.isPSSysCssIdDirty();
            }
            case 48: {
                return pSSysViewPanelBase.isPSSysCssNameDirty();
            }
            case 49: {
                return pSSysViewPanelBase.isPSSysPFPluginIdDirty();
            }
            case 50: {
                return pSSysViewPanelBase.isPSSysPFPluginNameDirty();
            }
            case 51: {
                return pSSysViewPanelBase.isPSSystemIdDirty();
            }
            case 52: {
                return pSSysViewPanelBase.isPSSystemNameDirty();
            }
            case 53: {
                return pSSysViewPanelBase.isPSSysViewPanelIdDirty();
            }
            case 54: {
                return pSSysViewPanelBase.isPSSysViewPanelNameDirty();
            }
            case 55: {
                return pSSysViewPanelBase.isPSViewMsgGroupIdDirty();
            }
            case 56: {
                return pSSysViewPanelBase.isPSViewMsgGroupNameDirty();
            }
            case 57: {
                return pSSysViewPanelBase.isPublicFlagDirty();
            }
            case 58: {
                return pSSysViewPanelBase.isShowFooterFirstPageDirty();
            }
            case 59: {
                return pSSysViewPanelBase.isShowHeaderFirstPageDirty();
            }
            case 60: {
                return pSSysViewPanelBase.isSysAppFlagDirty();
            }
            case 61: {
                return pSSysViewPanelBase.isToDoTaskDirty();
            }
            case 62: {
                return pSSysViewPanelBase.isUpdateDateDirty();
            }
            case 63: {
                return pSSysViewPanelBase.isUpdateManDirty();
            }
            case 64: {
                return pSSysViewPanelBase.isViewLayoutFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysViewPanelBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysViewPanelBase pSSysViewPanelBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysViewPanelBase.getBodyOnlyFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bodyonlyflag", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getBodyOnlyFlag()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getDataName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dataname", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getDataName()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getEnablePageFooter() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablepagefooter", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getEnablePageFooter()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getEnablePageHeader() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablepageheader", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getEnablePageHeader()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getGetDataMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"getdatamode", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getGetDataMode()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getGetDataTimer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"getdatatimer", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getGetDataTimer()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getGetPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"getpsdeactionid", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getGetPSDEActionId()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getGetPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"getpsdeactionname", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getGetPSDEActionName()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getLayoutCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"layoutcat", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getLayoutCat()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getLayoutMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"layoutmode", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getLayoutMode()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getMobFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobflag", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getMobFlag()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getNavBarHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navbarheight", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getNavBarHeight()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getNavBarPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navbarpos", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getNavBarPos()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getNavBarPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navbarpssyscssid", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getNavBarPSSysCssId()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getNavBarPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navbarpssyscssname", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getNavBarPSSysCssName()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getNavBarStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navbarstyle", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getNavBarStyle()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getNavBarWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navbarwidth", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getNavBarWidth()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getOwnerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ownerid", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getOwnerId()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getOwnerTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ownertag", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getOwnerTag()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getOwnerType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ownertype", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getOwnerType()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getPageFormat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pageformat", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getPageFormat()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getPageHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pageheight", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getPageHeight()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getPageMarginBottom() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pagemarginbottom", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getPageMarginBottom()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getPageMarginLeft() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pagemarginleft", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getPageMarginLeft()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getPageMarginRight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pagemarginright", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getPageMarginRight()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getPageMarginTop() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pagemargintop", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getPageMarginTop()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getPageWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pagewidth", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getPageWidth()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getPanelHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"panelheight", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getPanelHeight()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getPanelModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"panelmodel", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getPanelModel()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getPanelNavBar() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"panelnavbar", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getPanelNavBar()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getPanelStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"panelstyle", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getPanelStyle()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getPanelWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"panelwidth", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getPanelWidth()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getPPI() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppi", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getPPI()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getPSACHandlerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psachandlerid", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getPSACHandlerId()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getPSACHandlerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psachandlername", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getPSACHandlerName()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getPSCtrlLogicGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrllogicgroupid", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getPSCtrlLogicGroupId()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getPSCtrlLogicGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrllogicgroupname", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getPSCtrlLogicGroupName()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssid", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getPSSysCssId()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssname", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getPSSysCssName()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getPSSysViewPanelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelid", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getPSSysViewPanelId()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getPSSysViewPanelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelname", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getPSSysViewPanelName()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getPSViewMsgGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewmsggroupid", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getPSViewMsgGroupId()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getPSViewMsgGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewmsggroupname", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getPSViewMsgGroupName()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getPublicFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"publicflag", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getPublicFlag()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getShowFooterFirstPage() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"showfooterfirstpage", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getShowFooterFirstPage()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getShowHeaderFirstPage() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"showheaderfirstpage", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getShowHeaderFirstPage()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getSysAppFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sysappflag", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getSysAppFlag()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getToDoTask() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"todotask", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getToDoTask()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysViewPanelBase.getViewLayoutFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewlayoutflag", (Object)PSSysViewPanelBase.getJSONValue((Object)pSSysViewPanelBase.getViewLayoutFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysViewPanelBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysViewPanelBase pSSysViewPanelBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysViewPanelBase.getBodyOnlyFlag() != null) {
            object = pSSysViewPanelBase.getBodyOnlyFlag();
            xmlNode.setAttribute(FIELD_BODYONLYFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelBase.getCodeName() != null) {
            object = pSSysViewPanelBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelBase.getCreateDate() != null) {
            object = pSSysViewPanelBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysViewPanelBase.getCreateMan() != null) {
            object = pSSysViewPanelBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelBase.getDataName() != null) {
            object = pSSysViewPanelBase.getDataName();
            xmlNode.setAttribute(FIELD_DATANAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelBase.getEnablePageFooter() != null) {
            object = pSSysViewPanelBase.getEnablePageFooter();
            xmlNode.setAttribute(FIELD_ENABLEPAGEFOOTER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelBase.getEnablePageHeader() != null) {
            object = pSSysViewPanelBase.getEnablePageHeader();
            xmlNode.setAttribute(FIELD_ENABLEPAGEHEADER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelBase.getGetDataMode() != null) {
            object = pSSysViewPanelBase.getGetDataMode();
            xmlNode.setAttribute(FIELD_GETDATAMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelBase.getGetDataTimer() != null) {
            object = pSSysViewPanelBase.getGetDataTimer();
            xmlNode.setAttribute(FIELD_GETDATATIMER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelBase.getGetPSDEActionId() != null) {
            object = pSSysViewPanelBase.getGetPSDEActionId();
            xmlNode.setAttribute(FIELD_GETPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelBase.getGetPSDEActionName() != null) {
            object = pSSysViewPanelBase.getGetPSDEActionName();
            xmlNode.setAttribute(FIELD_GETPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelBase.getLayoutCat() != null) {
            object = pSSysViewPanelBase.getLayoutCat();
            xmlNode.setAttribute(FIELD_LAYOUTCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelBase.getLayoutMode() != null) {
            object = pSSysViewPanelBase.getLayoutMode();
            xmlNode.setAttribute(FIELD_LAYOUTMODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelBase.getMemo() != null) {
            object = pSSysViewPanelBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelBase.getMobFlag() != null) {
            object = pSSysViewPanelBase.getMobFlag();
            xmlNode.setAttribute(FIELD_MOBFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelBase.getNavBarHeight() != null) {
            object = pSSysViewPanelBase.getNavBarHeight();
            xmlNode.setAttribute(FIELD_NAVBARHEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelBase.getNavBarPos() != null) {
            object = pSSysViewPanelBase.getNavBarPos();
            xmlNode.setAttribute(FIELD_NAVBARPOS, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelBase.getNavBarPSSysCssId() != null) {
            object = pSSysViewPanelBase.getNavBarPSSysCssId();
            xmlNode.setAttribute(FIELD_NAVBARPSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelBase.getNavBarPSSysCssName() != null) {
            object = pSSysViewPanelBase.getNavBarPSSysCssName();
            xmlNode.setAttribute(FIELD_NAVBARPSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelBase.getNavBarStyle() != null) {
            object = pSSysViewPanelBase.getNavBarStyle();
            xmlNode.setAttribute(FIELD_NAVBARSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelBase.getNavBarWidth() != null) {
            object = pSSysViewPanelBase.getNavBarWidth();
            xmlNode.setAttribute(FIELD_NAVBARWIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelBase.getOwnerId() != null) {
            object = pSSysViewPanelBase.getOwnerId();
            xmlNode.setAttribute(FIELD_OWNERID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelBase.getOwnerTag() != null) {
            object = pSSysViewPanelBase.getOwnerTag();
            xmlNode.setAttribute(FIELD_OWNERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelBase.getOwnerType() != null) {
            object = pSSysViewPanelBase.getOwnerType();
            xmlNode.setAttribute(FIELD_OWNERTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelBase.getPageFormat() != null) {
            object = pSSysViewPanelBase.getPageFormat();
            xmlNode.setAttribute(FIELD_PAGEFORMAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelBase.getPageHeight() != null) {
            object = pSSysViewPanelBase.getPageHeight();
            xmlNode.setAttribute(FIELD_PAGEHEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelBase.getPageMarginBottom() != null) {
            object = pSSysViewPanelBase.getPageMarginBottom();
            xmlNode.setAttribute(FIELD_PAGEMARGINBOTTOM, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelBase.getPageMarginLeft() != null) {
            object = pSSysViewPanelBase.getPageMarginLeft();
            xmlNode.setAttribute(FIELD_PAGEMARGINLEFT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelBase.getPageMarginRight() != null) {
            object = pSSysViewPanelBase.getPageMarginRight();
            xmlNode.setAttribute(FIELD_PAGEMARGINRIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelBase.getPageMarginTop() != null) {
            object = pSSysViewPanelBase.getPageMarginTop();
            xmlNode.setAttribute(FIELD_PAGEMARGINTOP, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelBase.getPageWidth() != null) {
            object = pSSysViewPanelBase.getPageWidth();
            xmlNode.setAttribute(FIELD_PAGEWIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelBase.getPanelHeight() != null) {
            object = pSSysViewPanelBase.getPanelHeight();
            xmlNode.setAttribute(FIELD_PANELHEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelBase.getPanelModel() != null) {
            object = pSSysViewPanelBase.getPanelModel();
            xmlNode.setAttribute(FIELD_PANELMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelBase.getPanelNavBar() != null) {
            object = pSSysViewPanelBase.getPanelNavBar();
            xmlNode.setAttribute(FIELD_PANELNAVBAR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelBase.getPanelStyle() != null) {
            object = pSSysViewPanelBase.getPanelStyle();
            xmlNode.setAttribute(FIELD_PANELSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelBase.getPanelWidth() != null) {
            object = pSSysViewPanelBase.getPanelWidth();
            xmlNode.setAttribute(FIELD_PANELWIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelBase.getPPI() != null) {
            object = pSSysViewPanelBase.getPPI();
            xmlNode.setAttribute(FIELD_PPI, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelBase.getPSACHandlerId() != null) {
            object = pSSysViewPanelBase.getPSACHandlerId();
            xmlNode.setAttribute(FIELD_PSACHANDLERID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelBase.getPSACHandlerName() != null) {
            object = pSSysViewPanelBase.getPSACHandlerName();
            xmlNode.setAttribute(FIELD_PSACHANDLERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelBase.getPSCtrlLogicGroupId() != null) {
            object = pSSysViewPanelBase.getPSCtrlLogicGroupId();
            xmlNode.setAttribute(FIELD_PSCTRLLOGICGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelBase.getPSCtrlLogicGroupName() != null) {
            object = pSSysViewPanelBase.getPSCtrlLogicGroupName();
            xmlNode.setAttribute(FIELD_PSCTRLLOGICGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelBase.getPSDEId() != null) {
            object = pSSysViewPanelBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelBase.getPSDEName() != null) {
            object = pSSysViewPanelBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelBase.getPSModuleId() != null) {
            object = pSSysViewPanelBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelBase.getPSModuleName() != null) {
            object = pSSysViewPanelBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelBase.getPSSysAppId() != null) {
            object = pSSysViewPanelBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelBase.getPSSysAppName() != null) {
            object = pSSysViewPanelBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelBase.getPSSysCssId() != null) {
            object = pSSysViewPanelBase.getPSSysCssId();
            xmlNode.setAttribute(FIELD_PSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelBase.getPSSysCssName() != null) {
            object = pSSysViewPanelBase.getPSSysCssName();
            xmlNode.setAttribute(FIELD_PSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelBase.getPSSysPFPluginId() != null) {
            object = pSSysViewPanelBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelBase.getPSSysPFPluginName() != null) {
            object = pSSysViewPanelBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelBase.getPSSystemId() != null) {
            object = pSSysViewPanelBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelBase.getPSSystemName() != null) {
            object = pSSysViewPanelBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelBase.getPSSysViewPanelId() != null) {
            object = pSSysViewPanelBase.getPSSysViewPanelId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelBase.getPSSysViewPanelName() != null) {
            object = pSSysViewPanelBase.getPSSysViewPanelName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelBase.getPSViewMsgGroupId() != null) {
            object = pSSysViewPanelBase.getPSViewMsgGroupId();
            xmlNode.setAttribute(FIELD_PSVIEWMSGGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelBase.getPSViewMsgGroupName() != null) {
            object = pSSysViewPanelBase.getPSViewMsgGroupName();
            xmlNode.setAttribute(FIELD_PSVIEWMSGGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelBase.getPublicFlag() != null) {
            object = pSSysViewPanelBase.getPublicFlag();
            xmlNode.setAttribute(FIELD_PUBLICFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelBase.getShowFooterFirstPage() != null) {
            object = pSSysViewPanelBase.getShowFooterFirstPage();
            xmlNode.setAttribute(FIELD_SHOWFOOTERFIRSTPAGE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelBase.getShowHeaderFirstPage() != null) {
            object = pSSysViewPanelBase.getShowHeaderFirstPage();
            xmlNode.setAttribute(FIELD_SHOWHEADERFIRSTPAGE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelBase.getSysAppFlag() != null) {
            object = pSSysViewPanelBase.getSysAppFlag();
            xmlNode.setAttribute(FIELD_SYSAPPFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelBase.getToDoTask() != null) {
            object = pSSysViewPanelBase.getToDoTask();
            xmlNode.setAttribute(FIELD_TODOTASK, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelBase.getUpdateDate() != null) {
            object = pSSysViewPanelBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysViewPanelBase.getUpdateMan() != null) {
            object = pSSysViewPanelBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelBase.getViewLayoutFlag() != null) {
            object = pSSysViewPanelBase.getViewLayoutFlag();
            xmlNode.setAttribute(FIELD_VIEWLAYOUTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysViewPanelBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysViewPanelBase pSSysViewPanelBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysViewPanelBase.isBodyOnlyFlagDirty() && (bl || pSSysViewPanelBase.getBodyOnlyFlag() != null)) {
            iDataObject.set(FIELD_BODYONLYFLAG, (Object)pSSysViewPanelBase.getBodyOnlyFlag());
        }
        if (pSSysViewPanelBase.isCodeNameDirty() && (bl || pSSysViewPanelBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysViewPanelBase.getCodeName());
        }
        if (pSSysViewPanelBase.isCreateDateDirty() && (bl || pSSysViewPanelBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysViewPanelBase.getCreateDate());
        }
        if (pSSysViewPanelBase.isCreateManDirty() && (bl || pSSysViewPanelBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysViewPanelBase.getCreateMan());
        }
        if (pSSysViewPanelBase.isDataNameDirty() && (bl || pSSysViewPanelBase.getDataName() != null)) {
            iDataObject.set(FIELD_DATANAME, (Object)pSSysViewPanelBase.getDataName());
        }
        if (pSSysViewPanelBase.isEnablePageFooterDirty() && (bl || pSSysViewPanelBase.getEnablePageFooter() != null)) {
            iDataObject.set(FIELD_ENABLEPAGEFOOTER, (Object)pSSysViewPanelBase.getEnablePageFooter());
        }
        if (pSSysViewPanelBase.isEnablePageHeaderDirty() && (bl || pSSysViewPanelBase.getEnablePageHeader() != null)) {
            iDataObject.set(FIELD_ENABLEPAGEHEADER, (Object)pSSysViewPanelBase.getEnablePageHeader());
        }
        if (pSSysViewPanelBase.isGetDataModeDirty() && (bl || pSSysViewPanelBase.getGetDataMode() != null)) {
            iDataObject.set(FIELD_GETDATAMODE, (Object)pSSysViewPanelBase.getGetDataMode());
        }
        if (pSSysViewPanelBase.isGetDataTimerDirty() && (bl || pSSysViewPanelBase.getGetDataTimer() != null)) {
            iDataObject.set(FIELD_GETDATATIMER, (Object)pSSysViewPanelBase.getGetDataTimer());
        }
        if (pSSysViewPanelBase.isGetPSDEActionIdDirty() && (bl || pSSysViewPanelBase.getGetPSDEActionId() != null)) {
            iDataObject.set(FIELD_GETPSDEACTIONID, (Object)pSSysViewPanelBase.getGetPSDEActionId());
        }
        if (pSSysViewPanelBase.isGetPSDEActionNameDirty() && (bl || pSSysViewPanelBase.getGetPSDEActionName() != null)) {
            iDataObject.set(FIELD_GETPSDEACTIONNAME, (Object)pSSysViewPanelBase.getGetPSDEActionName());
        }
        if (pSSysViewPanelBase.isLayoutCatDirty() && (bl || pSSysViewPanelBase.getLayoutCat() != null)) {
            iDataObject.set(FIELD_LAYOUTCAT, (Object)pSSysViewPanelBase.getLayoutCat());
        }
        if (pSSysViewPanelBase.isLayoutModeDirty() && (bl || pSSysViewPanelBase.getLayoutMode() != null)) {
            iDataObject.set(FIELD_LAYOUTMODE, (Object)pSSysViewPanelBase.getLayoutMode());
        }
        if (pSSysViewPanelBase.isMemoDirty() && (bl || pSSysViewPanelBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysViewPanelBase.getMemo());
        }
        if (pSSysViewPanelBase.isMobFlagDirty() && (bl || pSSysViewPanelBase.getMobFlag() != null)) {
            iDataObject.set(FIELD_MOBFLAG, (Object)pSSysViewPanelBase.getMobFlag());
        }
        if (pSSysViewPanelBase.isNavBarHeightDirty() && (bl || pSSysViewPanelBase.getNavBarHeight() != null)) {
            iDataObject.set(FIELD_NAVBARHEIGHT, (Object)pSSysViewPanelBase.getNavBarHeight());
        }
        if (pSSysViewPanelBase.isNavBarPosDirty() && (bl || pSSysViewPanelBase.getNavBarPos() != null)) {
            iDataObject.set(FIELD_NAVBARPOS, (Object)pSSysViewPanelBase.getNavBarPos());
        }
        if (pSSysViewPanelBase.isNavBarPSSysCssIdDirty() && (bl || pSSysViewPanelBase.getNavBarPSSysCssId() != null)) {
            iDataObject.set(FIELD_NAVBARPSSYSCSSID, (Object)pSSysViewPanelBase.getNavBarPSSysCssId());
        }
        if (pSSysViewPanelBase.isNavBarPSSysCssNameDirty() && (bl || pSSysViewPanelBase.getNavBarPSSysCssName() != null)) {
            iDataObject.set(FIELD_NAVBARPSSYSCSSNAME, (Object)pSSysViewPanelBase.getNavBarPSSysCssName());
        }
        if (pSSysViewPanelBase.isNavBarStyleDirty() && (bl || pSSysViewPanelBase.getNavBarStyle() != null)) {
            iDataObject.set(FIELD_NAVBARSTYLE, (Object)pSSysViewPanelBase.getNavBarStyle());
        }
        if (pSSysViewPanelBase.isNavBarWidthDirty() && (bl || pSSysViewPanelBase.getNavBarWidth() != null)) {
            iDataObject.set(FIELD_NAVBARWIDTH, (Object)pSSysViewPanelBase.getNavBarWidth());
        }
        if (pSSysViewPanelBase.isOwnerIdDirty() && (bl || pSSysViewPanelBase.getOwnerId() != null)) {
            iDataObject.set(FIELD_OWNERID, (Object)pSSysViewPanelBase.getOwnerId());
        }
        if (pSSysViewPanelBase.isOwnerTagDirty() && (bl || pSSysViewPanelBase.getOwnerTag() != null)) {
            iDataObject.set(FIELD_OWNERTAG, (Object)pSSysViewPanelBase.getOwnerTag());
        }
        if (pSSysViewPanelBase.isOwnerTypeDirty() && (bl || pSSysViewPanelBase.getOwnerType() != null)) {
            iDataObject.set(FIELD_OWNERTYPE, (Object)pSSysViewPanelBase.getOwnerType());
        }
        if (pSSysViewPanelBase.isPageFormatDirty() && (bl || pSSysViewPanelBase.getPageFormat() != null)) {
            iDataObject.set(FIELD_PAGEFORMAT, (Object)pSSysViewPanelBase.getPageFormat());
        }
        if (pSSysViewPanelBase.isPageHeightDirty() && (bl || pSSysViewPanelBase.getPageHeight() != null)) {
            iDataObject.set(FIELD_PAGEHEIGHT, (Object)pSSysViewPanelBase.getPageHeight());
        }
        if (pSSysViewPanelBase.isPageMarginBottomDirty() && (bl || pSSysViewPanelBase.getPageMarginBottom() != null)) {
            iDataObject.set(FIELD_PAGEMARGINBOTTOM, (Object)pSSysViewPanelBase.getPageMarginBottom());
        }
        if (pSSysViewPanelBase.isPageMarginLeftDirty() && (bl || pSSysViewPanelBase.getPageMarginLeft() != null)) {
            iDataObject.set(FIELD_PAGEMARGINLEFT, (Object)pSSysViewPanelBase.getPageMarginLeft());
        }
        if (pSSysViewPanelBase.isPageMarginRightDirty() && (bl || pSSysViewPanelBase.getPageMarginRight() != null)) {
            iDataObject.set(FIELD_PAGEMARGINRIGHT, (Object)pSSysViewPanelBase.getPageMarginRight());
        }
        if (pSSysViewPanelBase.isPageMarginTopDirty() && (bl || pSSysViewPanelBase.getPageMarginTop() != null)) {
            iDataObject.set(FIELD_PAGEMARGINTOP, (Object)pSSysViewPanelBase.getPageMarginTop());
        }
        if (pSSysViewPanelBase.isPageWidthDirty() && (bl || pSSysViewPanelBase.getPageWidth() != null)) {
            iDataObject.set(FIELD_PAGEWIDTH, (Object)pSSysViewPanelBase.getPageWidth());
        }
        if (pSSysViewPanelBase.isPanelHeightDirty() && (bl || pSSysViewPanelBase.getPanelHeight() != null)) {
            iDataObject.set(FIELD_PANELHEIGHT, (Object)pSSysViewPanelBase.getPanelHeight());
        }
        if (pSSysViewPanelBase.isPanelModelDirty() && (bl || pSSysViewPanelBase.getPanelModel() != null)) {
            iDataObject.set(FIELD_PANELMODEL, (Object)pSSysViewPanelBase.getPanelModel());
        }
        if (pSSysViewPanelBase.isPanelNavBarDirty() && (bl || pSSysViewPanelBase.getPanelNavBar() != null)) {
            iDataObject.set(FIELD_PANELNAVBAR, (Object)pSSysViewPanelBase.getPanelNavBar());
        }
        if (pSSysViewPanelBase.isPanelStyleDirty() && (bl || pSSysViewPanelBase.getPanelStyle() != null)) {
            iDataObject.set(FIELD_PANELSTYLE, (Object)pSSysViewPanelBase.getPanelStyle());
        }
        if (pSSysViewPanelBase.isPanelWidthDirty() && (bl || pSSysViewPanelBase.getPanelWidth() != null)) {
            iDataObject.set(FIELD_PANELWIDTH, (Object)pSSysViewPanelBase.getPanelWidth());
        }
        if (pSSysViewPanelBase.isPPIDirty() && (bl || pSSysViewPanelBase.getPPI() != null)) {
            iDataObject.set(FIELD_PPI, (Object)pSSysViewPanelBase.getPPI());
        }
        if (pSSysViewPanelBase.isPSACHandlerIdDirty() && (bl || pSSysViewPanelBase.getPSACHandlerId() != null)) {
            iDataObject.set(FIELD_PSACHANDLERID, (Object)pSSysViewPanelBase.getPSACHandlerId());
        }
        if (pSSysViewPanelBase.isPSACHandlerNameDirty() && (bl || pSSysViewPanelBase.getPSACHandlerName() != null)) {
            iDataObject.set(FIELD_PSACHANDLERNAME, (Object)pSSysViewPanelBase.getPSACHandlerName());
        }
        if (pSSysViewPanelBase.isPSCtrlLogicGroupIdDirty() && (bl || pSSysViewPanelBase.getPSCtrlLogicGroupId() != null)) {
            iDataObject.set(FIELD_PSCTRLLOGICGROUPID, (Object)pSSysViewPanelBase.getPSCtrlLogicGroupId());
        }
        if (pSSysViewPanelBase.isPSCtrlLogicGroupNameDirty() && (bl || pSSysViewPanelBase.getPSCtrlLogicGroupName() != null)) {
            iDataObject.set(FIELD_PSCTRLLOGICGROUPNAME, (Object)pSSysViewPanelBase.getPSCtrlLogicGroupName());
        }
        if (pSSysViewPanelBase.isPSDEIdDirty() && (bl || pSSysViewPanelBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysViewPanelBase.getPSDEId());
        }
        if (pSSysViewPanelBase.isPSDENameDirty() && (bl || pSSysViewPanelBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSSysViewPanelBase.getPSDEName());
        }
        if (pSSysViewPanelBase.isPSModuleIdDirty() && (bl || pSSysViewPanelBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysViewPanelBase.getPSModuleId());
        }
        if (pSSysViewPanelBase.isPSModuleNameDirty() && (bl || pSSysViewPanelBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysViewPanelBase.getPSModuleName());
        }
        if (pSSysViewPanelBase.isPSSysAppIdDirty() && (bl || pSSysViewPanelBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSSysViewPanelBase.getPSSysAppId());
        }
        if (pSSysViewPanelBase.isPSSysAppNameDirty() && (bl || pSSysViewPanelBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSSysViewPanelBase.getPSSysAppName());
        }
        if (pSSysViewPanelBase.isPSSysCssIdDirty() && (bl || pSSysViewPanelBase.getPSSysCssId() != null)) {
            iDataObject.set(FIELD_PSSYSCSSID, (Object)pSSysViewPanelBase.getPSSysCssId());
        }
        if (pSSysViewPanelBase.isPSSysCssNameDirty() && (bl || pSSysViewPanelBase.getPSSysCssName() != null)) {
            iDataObject.set(FIELD_PSSYSCSSNAME, (Object)pSSysViewPanelBase.getPSSysCssName());
        }
        if (pSSysViewPanelBase.isPSSysPFPluginIdDirty() && (bl || pSSysViewPanelBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSSysViewPanelBase.getPSSysPFPluginId());
        }
        if (pSSysViewPanelBase.isPSSysPFPluginNameDirty() && (bl || pSSysViewPanelBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSSysViewPanelBase.getPSSysPFPluginName());
        }
        if (pSSysViewPanelBase.isPSSystemIdDirty() && (bl || pSSysViewPanelBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysViewPanelBase.getPSSystemId());
        }
        if (pSSysViewPanelBase.isPSSystemNameDirty() && (bl || pSSysViewPanelBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysViewPanelBase.getPSSystemName());
        }
        if (pSSysViewPanelBase.isPSSysViewPanelIdDirty() && (bl || pSSysViewPanelBase.getPSSysViewPanelId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELID, (Object)pSSysViewPanelBase.getPSSysViewPanelId());
        }
        if (pSSysViewPanelBase.isPSSysViewPanelNameDirty() && (bl || pSSysViewPanelBase.getPSSysViewPanelName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELNAME, (Object)pSSysViewPanelBase.getPSSysViewPanelName());
        }
        if (pSSysViewPanelBase.isPSViewMsgGroupIdDirty() && (bl || pSSysViewPanelBase.getPSViewMsgGroupId() != null)) {
            iDataObject.set(FIELD_PSVIEWMSGGROUPID, (Object)pSSysViewPanelBase.getPSViewMsgGroupId());
        }
        if (pSSysViewPanelBase.isPSViewMsgGroupNameDirty() && (bl || pSSysViewPanelBase.getPSViewMsgGroupName() != null)) {
            iDataObject.set(FIELD_PSVIEWMSGGROUPNAME, (Object)pSSysViewPanelBase.getPSViewMsgGroupName());
        }
        if (pSSysViewPanelBase.isPublicFlagDirty() && (bl || pSSysViewPanelBase.getPublicFlag() != null)) {
            iDataObject.set(FIELD_PUBLICFLAG, (Object)pSSysViewPanelBase.getPublicFlag());
        }
        if (pSSysViewPanelBase.isShowFooterFirstPageDirty() && (bl || pSSysViewPanelBase.getShowFooterFirstPage() != null)) {
            iDataObject.set(FIELD_SHOWFOOTERFIRSTPAGE, (Object)pSSysViewPanelBase.getShowFooterFirstPage());
        }
        if (pSSysViewPanelBase.isShowHeaderFirstPageDirty() && (bl || pSSysViewPanelBase.getShowHeaderFirstPage() != null)) {
            iDataObject.set(FIELD_SHOWHEADERFIRSTPAGE, (Object)pSSysViewPanelBase.getShowHeaderFirstPage());
        }
        if (pSSysViewPanelBase.isSysAppFlagDirty() && (bl || pSSysViewPanelBase.getSysAppFlag() != null)) {
            iDataObject.set(FIELD_SYSAPPFLAG, (Object)pSSysViewPanelBase.getSysAppFlag());
        }
        if (pSSysViewPanelBase.isToDoTaskDirty() && (bl || pSSysViewPanelBase.getToDoTask() != null)) {
            iDataObject.set(FIELD_TODOTASK, (Object)pSSysViewPanelBase.getToDoTask());
        }
        if (pSSysViewPanelBase.isUpdateDateDirty() && (bl || pSSysViewPanelBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysViewPanelBase.getUpdateDate());
        }
        if (pSSysViewPanelBase.isUpdateManDirty() && (bl || pSSysViewPanelBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysViewPanelBase.getUpdateMan());
        }
        if (pSSysViewPanelBase.isViewLayoutFlagDirty() && (bl || pSSysViewPanelBase.getViewLayoutFlag() != null)) {
            iDataObject.set(FIELD_VIEWLAYOUTFLAG, (Object)pSSysViewPanelBase.getViewLayoutFlag());
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
        return PSSysViewPanelBase.remove(this, n);
    }

    private static boolean remove(PSSysViewPanelBase pSSysViewPanelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysViewPanelBase.resetBodyOnlyFlag();
                return true;
            }
            case 1: {
                pSSysViewPanelBase.resetCodeName();
                return true;
            }
            case 2: {
                pSSysViewPanelBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSSysViewPanelBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSSysViewPanelBase.resetDataName();
                return true;
            }
            case 5: {
                pSSysViewPanelBase.resetEnablePageFooter();
                return true;
            }
            case 6: {
                pSSysViewPanelBase.resetEnablePageHeader();
                return true;
            }
            case 7: {
                pSSysViewPanelBase.resetGetDataMode();
                return true;
            }
            case 8: {
                pSSysViewPanelBase.resetGetDataTimer();
                return true;
            }
            case 9: {
                pSSysViewPanelBase.resetGetPSDEActionId();
                return true;
            }
            case 10: {
                pSSysViewPanelBase.resetGetPSDEActionName();
                return true;
            }
            case 11: {
                pSSysViewPanelBase.resetLayoutCat();
                return true;
            }
            case 12: {
                pSSysViewPanelBase.resetLayoutMode();
                return true;
            }
            case 13: {
                pSSysViewPanelBase.resetMemo();
                return true;
            }
            case 14: {
                pSSysViewPanelBase.resetMobFlag();
                return true;
            }
            case 15: {
                pSSysViewPanelBase.resetNavBarHeight();
                return true;
            }
            case 16: {
                pSSysViewPanelBase.resetNavBarPos();
                return true;
            }
            case 17: {
                pSSysViewPanelBase.resetNavBarPSSysCssId();
                return true;
            }
            case 18: {
                pSSysViewPanelBase.resetNavBarPSSysCssName();
                return true;
            }
            case 19: {
                pSSysViewPanelBase.resetNavBarStyle();
                return true;
            }
            case 20: {
                pSSysViewPanelBase.resetNavBarWidth();
                return true;
            }
            case 21: {
                pSSysViewPanelBase.resetOwnerId();
                return true;
            }
            case 22: {
                pSSysViewPanelBase.resetOwnerTag();
                return true;
            }
            case 23: {
                pSSysViewPanelBase.resetOwnerType();
                return true;
            }
            case 24: {
                pSSysViewPanelBase.resetPageFormat();
                return true;
            }
            case 25: {
                pSSysViewPanelBase.resetPageHeight();
                return true;
            }
            case 26: {
                pSSysViewPanelBase.resetPageMarginBottom();
                return true;
            }
            case 27: {
                pSSysViewPanelBase.resetPageMarginLeft();
                return true;
            }
            case 28: {
                pSSysViewPanelBase.resetPageMarginRight();
                return true;
            }
            case 29: {
                pSSysViewPanelBase.resetPageMarginTop();
                return true;
            }
            case 30: {
                pSSysViewPanelBase.resetPageWidth();
                return true;
            }
            case 31: {
                pSSysViewPanelBase.resetPanelHeight();
                return true;
            }
            case 32: {
                pSSysViewPanelBase.resetPanelModel();
                return true;
            }
            case 33: {
                pSSysViewPanelBase.resetPanelNavBar();
                return true;
            }
            case 34: {
                pSSysViewPanelBase.resetPanelStyle();
                return true;
            }
            case 35: {
                pSSysViewPanelBase.resetPanelWidth();
                return true;
            }
            case 36: {
                pSSysViewPanelBase.resetPPI();
                return true;
            }
            case 37: {
                pSSysViewPanelBase.resetPSACHandlerId();
                return true;
            }
            case 38: {
                pSSysViewPanelBase.resetPSACHandlerName();
                return true;
            }
            case 39: {
                pSSysViewPanelBase.resetPSCtrlLogicGroupId();
                return true;
            }
            case 40: {
                pSSysViewPanelBase.resetPSCtrlLogicGroupName();
                return true;
            }
            case 41: {
                pSSysViewPanelBase.resetPSDEId();
                return true;
            }
            case 42: {
                pSSysViewPanelBase.resetPSDEName();
                return true;
            }
            case 43: {
                pSSysViewPanelBase.resetPSModuleId();
                return true;
            }
            case 44: {
                pSSysViewPanelBase.resetPSModuleName();
                return true;
            }
            case 45: {
                pSSysViewPanelBase.resetPSSysAppId();
                return true;
            }
            case 46: {
                pSSysViewPanelBase.resetPSSysAppName();
                return true;
            }
            case 47: {
                pSSysViewPanelBase.resetPSSysCssId();
                return true;
            }
            case 48: {
                pSSysViewPanelBase.resetPSSysCssName();
                return true;
            }
            case 49: {
                pSSysViewPanelBase.resetPSSysPFPluginId();
                return true;
            }
            case 50: {
                pSSysViewPanelBase.resetPSSysPFPluginName();
                return true;
            }
            case 51: {
                pSSysViewPanelBase.resetPSSystemId();
                return true;
            }
            case 52: {
                pSSysViewPanelBase.resetPSSystemName();
                return true;
            }
            case 53: {
                pSSysViewPanelBase.resetPSSysViewPanelId();
                return true;
            }
            case 54: {
                pSSysViewPanelBase.resetPSSysViewPanelName();
                return true;
            }
            case 55: {
                pSSysViewPanelBase.resetPSViewMsgGroupId();
                return true;
            }
            case 56: {
                pSSysViewPanelBase.resetPSViewMsgGroupName();
                return true;
            }
            case 57: {
                pSSysViewPanelBase.resetPublicFlag();
                return true;
            }
            case 58: {
                pSSysViewPanelBase.resetShowFooterFirstPage();
                return true;
            }
            case 59: {
                pSSysViewPanelBase.resetShowHeaderFirstPage();
                return true;
            }
            case 60: {
                pSSysViewPanelBase.resetSysAppFlag();
                return true;
            }
            case 61: {
                pSSysViewPanelBase.resetToDoTask();
                return true;
            }
            case 62: {
                pSSysViewPanelBase.resetUpdateDate();
                return true;
            }
            case 63: {
                pSSysViewPanelBase.resetUpdateMan();
                return true;
            }
            case 64: {
                pSSysViewPanelBase.resetViewLayoutFlag();
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
                pSCtrlLogicGroupService.autoGet((IEntity)pSCtrlLogicGroup);
                this.psctrllogicgroup = pSCtrlLogicGroup;
            }
            return this.psctrllogicgroup;
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
    public PSDEAction getGetPSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGetPSDEAction();
        }
        if (this.getGetPSDEActionId() == null) {
            return null;
        }
        Integer n = this.objGetPSDEActionLock;
        synchronized (n) {
            if (this.getpsdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getGetPSDEActionId(), (Object)this.getpsdeaction.getPSDEActionId()) != 0L) {
                this.getpsdeaction = null;
            }
            if (this.getpsdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getGetPSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet((IEntity)pSDEAction);
                this.getpsdeaction = pSDEAction;
            }
            return this.getpsdeaction;
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
    public PSSysCss getNavBarPSSysCss() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNavBarPSSysCss();
        }
        if (this.getNavBarPSSysCssId() == null) {
            return null;
        }
        Integer n = this.objNavBarPSSysCssLock;
        synchronized (n) {
            if (this.navbarpssyscss != null && DataTypeHelper.compare((int)25, (Object)this.getNavBarPSSysCssId(), (Object)this.navbarpssyscss.getPSSysCssId()) != 0L) {
                this.navbarpssyscss = null;
            }
            if (this.navbarpssyscss == null) {
                PSSysCss pSSysCss = new PSSysCss();
                pSSysCss.setPSSysCssId(this.getNavBarPSSysCssId());
                PSSysCssService pSSysCssService = (PSSysCssService)ServiceGlobal.getService(PSSysCssService.class, (SessionFactory)this.getSessionFactory());
                pSSysCssService.autoGet((IEntity)pSSysCss);
                this.navbarpssyscss = pSSysCss;
            }
            return this.navbarpssyscss;
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
    public PSViewMsgGroup getPSViewMsgGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewMsgGroup();
        }
        if (this.getPSViewMsgGroupId() == null) {
            return null;
        }
        Integer n = this.objPSViewMsgGroupLock;
        synchronized (n) {
            if (this.psviewmsggroup != null && DataTypeHelper.compare((int)25, (Object)this.getPSViewMsgGroupId(), (Object)this.psviewmsggroup.getPSViewMsgGroupId()) != 0L) {
                this.psviewmsggroup = null;
            }
            if (this.psviewmsggroup == null) {
                PSViewMsgGroup pSViewMsgGroup = new PSViewMsgGroup();
                pSViewMsgGroup.setPSViewMsgGroupId(this.getPSViewMsgGroupId());
                PSViewMsgGroupService pSViewMsgGroupService = (PSViewMsgGroupService)ServiceGlobal.getService(PSViewMsgGroupService.class, (SessionFactory)this.getSessionFactory());
                pSViewMsgGroupService.autoGet((IEntity)pSViewMsgGroup);
                this.psviewmsggroup = pSViewMsgGroup;
            }
            return this.psviewmsggroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSPanelEngine> getPSPanelEngines() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPanelEngines();
        }
        if (this.getPSSysViewPanelId() == null) {
            return null;
        }
        PSSysViewPanelService pSSysViewPanelService = (PSSysViewPanelService)ServiceGlobal.getService(PSSysViewPanelService.class, (SessionFactory)this.getSessionFactory());
        PSPanelEngineService pSPanelEngineService = (PSPanelEngineService)ServiceGlobal.getService(PSPanelEngineService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSPanelEnginesLock;
        synchronized (n) {
            if (this.pspanelengines == null) {
                this.pspanelengines = pSSysViewPanelService.isTempData((IEntity)this) ? pSPanelEngineService.selectTempByPSSysViewPanel(this) : pSPanelEngineService.selectByPSSysViewPanel(this);
            }
            return this.pspanelengines;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSPanelItemLogic> getPSPanelItemLogics() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPanelItemLogics();
        }
        if (this.getPSSysViewPanelId() == null) {
            return null;
        }
        PSSysViewPanelService pSSysViewPanelService = (PSSysViewPanelService)ServiceGlobal.getService(PSSysViewPanelService.class, (SessionFactory)this.getSessionFactory());
        PSPanelItemLogicService pSPanelItemLogicService = (PSPanelItemLogicService)ServiceGlobal.getService(PSPanelItemLogicService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSPanelItemLogicsLock;
        synchronized (n) {
            if (this.pspanelitemlogics == null) {
                this.pspanelitemlogics = pSSysViewPanelService.isTempData((IEntity)this) ? pSPanelItemLogicService.selectTempByPSSysViewPanel(this) : pSPanelItemLogicService.selectByPSSysViewPanel(this);
            }
            return this.pspanelitemlogics;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSPanelLLCond> getPSPanelLLConds() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPanelLLConds();
        }
        if (this.getPSSysViewPanelId() == null) {
            return null;
        }
        PSSysViewPanelService pSSysViewPanelService = (PSSysViewPanelService)ServiceGlobal.getService(PSSysViewPanelService.class, (SessionFactory)this.getSessionFactory());
        PSPanelLLCondService pSPanelLLCondService = (PSPanelLLCondService)ServiceGlobal.getService(PSPanelLLCondService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSPanelLLCondsLock;
        synchronized (n) {
            if (this.pspanelllconds == null) {
                this.pspanelllconds = pSSysViewPanelService.isTempData((IEntity)this) ? pSPanelLLCondService.selectTempByPSSysViewPanel(this) : pSPanelLLCondService.selectByPSSysViewPanel(this);
            }
            return this.pspanelllconds;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSPanelLNParam> getPSPanelLNParams() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPanelLNParams();
        }
        if (this.getPSSysViewPanelId() == null) {
            return null;
        }
        PSSysViewPanelService pSSysViewPanelService = (PSSysViewPanelService)ServiceGlobal.getService(PSSysViewPanelService.class, (SessionFactory)this.getSessionFactory());
        PSPanelLNParamService pSPanelLNParamService = (PSPanelLNParamService)ServiceGlobal.getService(PSPanelLNParamService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSPanelLNParamsLock;
        synchronized (n) {
            if (this.pspanellnparams == null) {
                this.pspanellnparams = pSSysViewPanelService.isTempData((IEntity)this) ? pSPanelLNParamService.selectTempByPSSysViewPanel(this) : pSPanelLNParamService.selectByPSSysViewPanel(this);
            }
            return this.pspanellnparams;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSPanelLogicLink> getPSPanelLogicLinks() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPanelLogicLinks();
        }
        if (this.getPSSysViewPanelId() == null) {
            return null;
        }
        PSSysViewPanelService pSSysViewPanelService = (PSSysViewPanelService)ServiceGlobal.getService(PSSysViewPanelService.class, (SessionFactory)this.getSessionFactory());
        PSPanelLogicLinkService pSPanelLogicLinkService = (PSPanelLogicLinkService)ServiceGlobal.getService(PSPanelLogicLinkService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSPanelLogicLinksLock;
        synchronized (n) {
            if (this.pspanellogiclinks == null) {
                this.pspanellogiclinks = pSSysViewPanelService.isTempData((IEntity)this) ? pSPanelLogicLinkService.selectTempByPSSysViewPanel(this) : pSPanelLogicLinkService.selectByPSSysViewPanel(this);
            }
            return this.pspanellogiclinks;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSPanelLogicNode> getPSPanelLogicNodes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPanelLogicNodes();
        }
        if (this.getPSSysViewPanelId() == null) {
            return null;
        }
        PSSysViewPanelService pSSysViewPanelService = (PSSysViewPanelService)ServiceGlobal.getService(PSSysViewPanelService.class, (SessionFactory)this.getSessionFactory());
        PSPanelLogicNodeService pSPanelLogicNodeService = (PSPanelLogicNodeService)ServiceGlobal.getService(PSPanelLogicNodeService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSPanelLogicNodesLock;
        synchronized (n) {
            if (this.pspanellogicnodes == null) {
                this.pspanellogicnodes = pSSysViewPanelService.isTempData((IEntity)this) ? pSPanelLogicNodeService.selectTempByPSSysViewPanel(this) : pSPanelLogicNodeService.selectByPSSysViewPanel(this);
            }
            return this.pspanellogicnodes;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSPanelLogicParam> getPSPanelLogicParams() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPanelLogicParams();
        }
        if (this.getPSSysViewPanelId() == null) {
            return null;
        }
        PSSysViewPanelService pSSysViewPanelService = (PSSysViewPanelService)ServiceGlobal.getService(PSSysViewPanelService.class, (SessionFactory)this.getSessionFactory());
        PSPanelLogicParamService pSPanelLogicParamService = (PSPanelLogicParamService)ServiceGlobal.getService(PSPanelLogicParamService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSPanelLogicParamsLock;
        synchronized (n) {
            if (this.pspanellogicparams == null) {
                this.pspanellogicparams = pSSysViewPanelService.isTempData((IEntity)this) ? pSPanelLogicParamService.selectTempByPSSysViewPanel(this) : pSPanelLogicParamService.selectByPSSysViewPanel(this);
            }
            return this.pspanellogicparams;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysViewPanelItem> getPSSysViewPanelItems() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanelItems();
        }
        if (this.getPSSysViewPanelId() == null) {
            return null;
        }
        PSSysViewPanelService pSSysViewPanelService = (PSSysViewPanelService)ServiceGlobal.getService(PSSysViewPanelService.class, (SessionFactory)this.getSessionFactory());
        PSSysViewPanelItemService pSSysViewPanelItemService = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysViewPanelItemsLock;
        synchronized (n) {
            if (this.pssysviewpanelitems == null) {
                this.pssysviewpanelitems = pSSysViewPanelService.isTempData((IEntity)this) ? pSSysViewPanelItemService.selectTempByPSSysViewPanel(this) : pSSysViewPanelItemService.selectByPSSysViewPanel(this);
            }
            return this.pssysviewpanelitems;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysViewPanelLogic> getPSSysViewPanelLogics() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanelLogics();
        }
        if (this.getPSSysViewPanelId() == null) {
            return null;
        }
        PSSysViewPanelService pSSysViewPanelService = (PSSysViewPanelService)ServiceGlobal.getService(PSSysViewPanelService.class, (SessionFactory)this.getSessionFactory());
        PSSysViewPanelLogicService pSSysViewPanelLogicService = (PSSysViewPanelLogicService)ServiceGlobal.getService(PSSysViewPanelLogicService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysViewPanelLogicsLock;
        synchronized (n) {
            if (this.pssysviewpanellogics == null) {
                this.pssysviewpanellogics = pSSysViewPanelService.isTempData((IEntity)this) ? pSSysViewPanelLogicService.selectTempByPSSysViewPanel(this) : pSSysViewPanelLogicService.selectByPSSysViewPanel(this);
            }
            return this.pssysviewpanellogics;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysViewPanelModel> getPSSysViewPanelModels() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanelModels();
        }
        if (this.getPSSysViewPanelId() == null) {
            return null;
        }
        PSSysViewPanelService pSSysViewPanelService = (PSSysViewPanelService)ServiceGlobal.getService(PSSysViewPanelService.class, (SessionFactory)this.getSessionFactory());
        PSSysViewPanelModelService pSSysViewPanelModelService = (PSSysViewPanelModelService)ServiceGlobal.getService(PSSysViewPanelModelService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysViewPanelModelsLock;
        synchronized (n) {
            if (this.pssysviewpanelmodels == null) {
                this.pssysviewpanelmodels = pSSysViewPanelService.isTempData((IEntity)this) ? pSSysViewPanelModelService.selectTempByPSSysViewPanel(this) : pSSysViewPanelModelService.selectByPSSysViewPanel(this);
            }
            return this.pssysviewpanelmodels;
        }
    }

    private PSSysViewPanelBase getProxyEntity() {
        return this.proxyPSSysViewPanelBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysViewPanelBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysViewPanelBase) {
            this.proxyPSSysViewPanelBase = (PSSysViewPanelBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BODYONLYFLAG, 0);
        fieldIndexMap.put(FIELD_CODENAME, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_DATANAME, 4);
        fieldIndexMap.put(FIELD_ENABLEPAGEFOOTER, 5);
        fieldIndexMap.put(FIELD_ENABLEPAGEHEADER, 6);
        fieldIndexMap.put(FIELD_GETDATAMODE, 7);
        fieldIndexMap.put(FIELD_GETDATATIMER, 8);
        fieldIndexMap.put(FIELD_GETPSDEACTIONID, 9);
        fieldIndexMap.put(FIELD_GETPSDEACTIONNAME, 10);
        fieldIndexMap.put(FIELD_LAYOUTCAT, 11);
        fieldIndexMap.put(FIELD_LAYOUTMODE, 12);
        fieldIndexMap.put(FIELD_MEMO, 13);
        fieldIndexMap.put(FIELD_MOBFLAG, 14);
        fieldIndexMap.put(FIELD_NAVBARHEIGHT, 15);
        fieldIndexMap.put(FIELD_NAVBARPOS, 16);
        fieldIndexMap.put(FIELD_NAVBARPSSYSCSSID, 17);
        fieldIndexMap.put(FIELD_NAVBARPSSYSCSSNAME, 18);
        fieldIndexMap.put(FIELD_NAVBARSTYLE, 19);
        fieldIndexMap.put(FIELD_NAVBARWIDTH, 20);
        fieldIndexMap.put(FIELD_OWNERID, 21);
        fieldIndexMap.put(FIELD_OWNERTAG, 22);
        fieldIndexMap.put(FIELD_OWNERTYPE, 23);
        fieldIndexMap.put(FIELD_PAGEFORMAT, 24);
        fieldIndexMap.put(FIELD_PAGEHEIGHT, 25);
        fieldIndexMap.put(FIELD_PAGEMARGINBOTTOM, 26);
        fieldIndexMap.put(FIELD_PAGEMARGINLEFT, 27);
        fieldIndexMap.put(FIELD_PAGEMARGINRIGHT, 28);
        fieldIndexMap.put(FIELD_PAGEMARGINTOP, 29);
        fieldIndexMap.put(FIELD_PAGEWIDTH, 30);
        fieldIndexMap.put(FIELD_PANELHEIGHT, 31);
        fieldIndexMap.put(FIELD_PANELMODEL, 32);
        fieldIndexMap.put(FIELD_PANELNAVBAR, 33);
        fieldIndexMap.put(FIELD_PANELSTYLE, 34);
        fieldIndexMap.put(FIELD_PANELWIDTH, 35);
        fieldIndexMap.put(FIELD_PPI, 36);
        fieldIndexMap.put(FIELD_PSACHANDLERID, 37);
        fieldIndexMap.put(FIELD_PSACHANDLERNAME, 38);
        fieldIndexMap.put(FIELD_PSCTRLLOGICGROUPID, 39);
        fieldIndexMap.put(FIELD_PSCTRLLOGICGROUPNAME, 40);
        fieldIndexMap.put(FIELD_PSDEID, 41);
        fieldIndexMap.put(FIELD_PSDENAME, 42);
        fieldIndexMap.put(FIELD_PSMODULEID, 43);
        fieldIndexMap.put(FIELD_PSMODULENAME, 44);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 45);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 46);
        fieldIndexMap.put(FIELD_PSSYSCSSID, 47);
        fieldIndexMap.put(FIELD_PSSYSCSSNAME, 48);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 49);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 50);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 51);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 52);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELID, 53);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELNAME, 54);
        fieldIndexMap.put(FIELD_PSVIEWMSGGROUPID, 55);
        fieldIndexMap.put(FIELD_PSVIEWMSGGROUPNAME, 56);
        fieldIndexMap.put(FIELD_PUBLICFLAG, 57);
        fieldIndexMap.put(FIELD_SHOWFOOTERFIRSTPAGE, 58);
        fieldIndexMap.put(FIELD_SHOWHEADERFIRSTPAGE, 59);
        fieldIndexMap.put(FIELD_SYSAPPFLAG, 60);
        fieldIndexMap.put(FIELD_TODOTASK, 61);
        fieldIndexMap.put(FIELD_UPDATEDATE, 62);
        fieldIndexMap.put(FIELD_UPDATEMAN, 63);
        fieldIndexMap.put(FIELD_VIEWLAYOUTFLAG, 64);
    }
}

