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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbar;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlLogicGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlMsg;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCalendarItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCalendarLogic;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgGroup;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCtrlLogicGroupService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCtrlMsgService;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarLogicService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGroupService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysCalendarBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysCalendarBase.class);
    public static final String FIELD_BATPSDETOOLBARID = "BATPSDETOOLBARID";
    public static final String FIELD_BATPSDETOOLBARNAME = "BATPSDETOOLBARNAME";
    public static final String FIELD_BUSYINDICATOR = "BUSYINDICATOR";
    public static final String FIELD_CALENDARSTYLE = "CALENDARSTYLE";
    public static final String FIELD_CALENDARTAG = "CALENDARTAG";
    public static final String FIELD_CALENDARTAG2 = "CALENDARTAG2";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_EMPTYTEXT = "EMPTYTEXT";
    public static final String FIELD_EMPTYTEXTPSLANRESID = "EMPTYTEXTPSLANRESID";
    public static final String FIELD_EMPTYTEXTPSLANRESNAME = "EMPTYTEXTPSLANRESNAME";
    public static final String FIELD_ENABLEEDIT = "ENABLEEDIT";
    public static final String FIELD_GANTTFLAG = "GANTTFLAG";
    public static final String FIELD_GANTTPSSYSPFPLUGINID = "GANTTPSSYSPFPLUGINID";
    public static final String FIELD_GANTTPSSYSPFPLUGINNAME = "GANTTPSSYSPFPLUGINNAME";
    public static final String FIELD_GANTTSTYLE = "GANTTSTYLE";
    public static final String FIELD_GROUPHEIGHT = "GROUPHEIGHT";
    public static final String FIELD_GROUPLAYOUT = "GROUPLAYOUT";
    public static final String FIELD_GROUPMODE = "GROUPMODE";
    public static final String FIELD_GROUPPSCODELISTID = "GROUPPSCODELISTID";
    public static final String FIELD_GROUPPSCODELISTNAME = "GROUPPSCODELISTNAME";
    public static final String FIELD_GROUPPSDEFID = "GROUPPSDEFID";
    public static final String FIELD_GROUPPSDEFNAME = "GROUPPSDEFNAME";
    public static final String FIELD_GROUPPSSYSCSSID = "GROUPPSSYSCSSID";
    public static final String FIELD_GROUPPSSYSCSSNAME = "GROUPPSSYSCSSNAME";
    public static final String FIELD_GROUPPSSYSPFPLUGINID = "GROUPPSSYSPFPLUGINID";
    public static final String FIELD_GROUPPSSYSPFPLUGINNAME = "GROUPPSSYSPFPLUGINNAME";
    public static final String FIELD_GROUPSTYLE = "GROUPSTYLE";
    public static final String FIELD_GROUPTEXTPSDEFID = "GROUPTEXTPSDEFID";
    public static final String FIELD_GROUPTEXTPSDEFNAME = "GROUPTEXTPSDEFNAME";
    public static final String FIELD_GROUPWIDTH = "GROUPWIDTH";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_NAVVIEWHEIGHT = "NAVVIEWHEIGHT";
    public static final String FIELD_NAVVIEWMAXHEIGHT = "NAVVIEWMAXHEIGHT";
    public static final String FIELD_NAVVIEWMAXWIDTH = "NAVVIEWMAXWIDTH";
    public static final String FIELD_NAVVIEWMINHEIGHT = "NAVVIEWMINHEIGHT";
    public static final String FIELD_NAVVIEWMINWIDTH = "NAVVIEWMINWIDTH";
    public static final String FIELD_NAVVIEWPOS = "NAVVIEWPOS";
    public static final String FIELD_NAVVIEWSHOWMODE = "NAVVIEWSHOWMODE";
    public static final String FIELD_NAVVIEWWIDTH = "NAVVIEWWIDTH";
    public static final String FIELD_PSCTRLLOGICGROUPID = "PSCTRLLOGICGROUPID";
    public static final String FIELD_PSCTRLLOGICGROUPNAME = "PSCTRLLOGICGROUPNAME";
    public static final String FIELD_PSCTRLMSGID = "PSCTRLMSGID";
    public static final String FIELD_PSCTRLMSGNAME = "PSCTRLMSGNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_PSSYSCALENDARID = "PSSYSCALENDARID";
    public static final String FIELD_PSSYSCALENDARNAME = "PSSYSCALENDARNAME";
    public static final String FIELD_PSSYSCSSID = "PSSYSCSSID";
    public static final String FIELD_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSVIEWMSGGROUPID = "PSVIEWMSGGROUPID";
    public static final String FIELD_PSVIEWMSGGROUPNAME = "PSVIEWMSGGROUPNAME";
    public static final String FIELD_QUICKPSDETOOLBARID = "QUICKPSDETOOLBARID";
    public static final String FIELD_QUICKPSDETOOLBARNAME = "QUICKPSDETOOLBARNAME";
    public static final String FIELD_SYSAPPFLAG = "SYSAPPFLAG";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_BATPSDETOOLBARID = 0;
    private static final int INDEX_BATPSDETOOLBARNAME = 1;
    private static final int INDEX_BUSYINDICATOR = 2;
    private static final int INDEX_CALENDARSTYLE = 3;
    private static final int INDEX_CALENDARTAG = 4;
    private static final int INDEX_CALENDARTAG2 = 5;
    private static final int INDEX_CODENAME = 6;
    private static final int INDEX_CREATEDATE = 7;
    private static final int INDEX_CREATEMAN = 8;
    private static final int INDEX_EMPTYTEXT = 9;
    private static final int INDEX_EMPTYTEXTPSLANRESID = 10;
    private static final int INDEX_EMPTYTEXTPSLANRESNAME = 11;
    private static final int INDEX_ENABLEEDIT = 12;
    private static final int INDEX_GANTTFLAG = 13;
    private static final int INDEX_GANTTPSSYSPFPLUGINID = 14;
    private static final int INDEX_GANTTPSSYSPFPLUGINNAME = 15;
    private static final int INDEX_GANTTSTYLE = 16;
    private static final int INDEX_GROUPHEIGHT = 17;
    private static final int INDEX_GROUPLAYOUT = 18;
    private static final int INDEX_GROUPMODE = 19;
    private static final int INDEX_GROUPPSCODELISTID = 20;
    private static final int INDEX_GROUPPSCODELISTNAME = 21;
    private static final int INDEX_GROUPPSDEFID = 22;
    private static final int INDEX_GROUPPSDEFNAME = 23;
    private static final int INDEX_GROUPPSSYSCSSID = 24;
    private static final int INDEX_GROUPPSSYSCSSNAME = 25;
    private static final int INDEX_GROUPPSSYSPFPLUGINID = 26;
    private static final int INDEX_GROUPPSSYSPFPLUGINNAME = 27;
    private static final int INDEX_GROUPSTYLE = 28;
    private static final int INDEX_GROUPTEXTPSDEFID = 29;
    private static final int INDEX_GROUPTEXTPSDEFNAME = 30;
    private static final int INDEX_GROUPWIDTH = 31;
    private static final int INDEX_LOCKFLAG = 32;
    private static final int INDEX_LOGICNAME = 33;
    private static final int INDEX_MEMO = 34;
    private static final int INDEX_NAVVIEWHEIGHT = 35;
    private static final int INDEX_NAVVIEWMAXHEIGHT = 36;
    private static final int INDEX_NAVVIEWMAXWIDTH = 37;
    private static final int INDEX_NAVVIEWMINHEIGHT = 38;
    private static final int INDEX_NAVVIEWMINWIDTH = 39;
    private static final int INDEX_NAVVIEWPOS = 40;
    private static final int INDEX_NAVVIEWSHOWMODE = 41;
    private static final int INDEX_NAVVIEWWIDTH = 42;
    private static final int INDEX_PSCTRLLOGICGROUPID = 43;
    private static final int INDEX_PSCTRLLOGICGROUPNAME = 44;
    private static final int INDEX_PSCTRLMSGID = 45;
    private static final int INDEX_PSCTRLMSGNAME = 46;
    private static final int INDEX_PSDEID = 47;
    private static final int INDEX_PSDENAME = 48;
    private static final int INDEX_PSMODULEID = 49;
    private static final int INDEX_PSMODULENAME = 50;
    private static final int INDEX_PSSYSAPPID = 51;
    private static final int INDEX_PSSYSAPPNAME = 52;
    private static final int INDEX_PSSYSCALENDARID = 53;
    private static final int INDEX_PSSYSCALENDARNAME = 54;
    private static final int INDEX_PSSYSCSSID = 55;
    private static final int INDEX_PSSYSCSSNAME = 56;
    private static final int INDEX_PSSYSPFPLUGINID = 57;
    private static final int INDEX_PSSYSPFPLUGINNAME = 58;
    private static final int INDEX_PSSYSTEMID = 59;
    private static final int INDEX_PSSYSTEMNAME = 60;
    private static final int INDEX_PSVIEWMSGGROUPID = 61;
    private static final int INDEX_PSVIEWMSGGROUPNAME = 62;
    private static final int INDEX_QUICKPSDETOOLBARID = 63;
    private static final int INDEX_QUICKPSDETOOLBARNAME = 64;
    private static final int INDEX_SYSAPPFLAG = 65;
    private static final int INDEX_UPDATEDATE = 66;
    private static final int INDEX_UPDATEMAN = 67;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysCalendarBase proxyPSSysCalendarBase = null;
    private boolean batpsdetoolbaridDirtyFlag = false;
    private boolean batpsdetoolbarnameDirtyFlag = false;
    private boolean busyindicatorDirtyFlag = false;
    private boolean calendarstyleDirtyFlag = false;
    private boolean calendartagDirtyFlag = false;
    private boolean calendartag2DirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean emptytextDirtyFlag = false;
    private boolean emptytextpslanresidDirtyFlag = false;
    private boolean emptytextpslanresnameDirtyFlag = false;
    private boolean enableeditDirtyFlag = false;
    private boolean ganttflagDirtyFlag = false;
    private boolean ganttpssyspfpluginidDirtyFlag = false;
    private boolean ganttpssyspfpluginnameDirtyFlag = false;
    private boolean ganttstyleDirtyFlag = false;
    private boolean groupheightDirtyFlag = false;
    private boolean grouplayoutDirtyFlag = false;
    private boolean groupmodeDirtyFlag = false;
    private boolean grouppscodelistidDirtyFlag = false;
    private boolean grouppscodelistnameDirtyFlag = false;
    private boolean grouppsdefidDirtyFlag = false;
    private boolean grouppsdefnameDirtyFlag = false;
    private boolean grouppssyscssidDirtyFlag = false;
    private boolean grouppssyscssnameDirtyFlag = false;
    private boolean grouppssyspfpluginidDirtyFlag = false;
    private boolean grouppssyspfpluginnameDirtyFlag = false;
    private boolean groupstyleDirtyFlag = false;
    private boolean grouptextpsdefidDirtyFlag = false;
    private boolean grouptextpsdefnameDirtyFlag = false;
    private boolean groupwidthDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean navviewheightDirtyFlag = false;
    private boolean navviewmaxheightDirtyFlag = false;
    private boolean navviewmaxwidthDirtyFlag = false;
    private boolean navviewminheightDirtyFlag = false;
    private boolean navviewminwidthDirtyFlag = false;
    private boolean navviewposDirtyFlag = false;
    private boolean navviewshowmodeDirtyFlag = false;
    private boolean navviewwidthDirtyFlag = false;
    private boolean psctrllogicgroupidDirtyFlag = false;
    private boolean psctrllogicgroupnameDirtyFlag = false;
    private boolean psctrlmsgidDirtyFlag = false;
    private boolean psctrlmsgnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean pssyscalendaridDirtyFlag = false;
    private boolean pssyscalendarnameDirtyFlag = false;
    private boolean pssyscssidDirtyFlag = false;
    private boolean pssyscssnameDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean psviewmsggroupidDirtyFlag = false;
    private boolean psviewmsggroupnameDirtyFlag = false;
    private boolean quickpsdetoolbaridDirtyFlag = false;
    private boolean quickpsdetoolbarnameDirtyFlag = false;
    private boolean sysappflagDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="batpsdetoolbarid")
    private String batpsdetoolbarid;
    @Column(name="batpsdetoolbarname")
    private String batpsdetoolbarname;
    @Column(name="busyindicator")
    private Integer busyindicator;
    @Column(name="calendarstyle")
    private String calendarstyle;
    @Column(name="calendartag")
    private String calendartag;
    @Column(name="calendartag2")
    private String calendartag2;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="emptytext")
    private String emptytext;
    @Column(name="emptytextpslanresid")
    private String emptytextpslanresid;
    @Column(name="emptytextpslanresname")
    private String emptytextpslanresname;
    @Column(name="enableedit")
    private Integer enableedit;
    @Column(name="ganttflag")
    private Integer ganttflag;
    @Column(name="ganttpssyspfpluginid")
    private String ganttpssyspfpluginid;
    @Column(name="ganttpssyspfpluginname")
    private String ganttpssyspfpluginname;
    @Column(name="ganttstyle")
    private String ganttstyle;
    @Column(name="groupheight")
    private Integer groupheight;
    @Column(name="grouplayout")
    private String grouplayout;
    @Column(name="groupmode")
    private String groupmode;
    @Column(name="grouppscodelistid")
    private String grouppscodelistid;
    @Column(name="grouppscodelistname")
    private String grouppscodelistname;
    @Column(name="grouppsdefid")
    private String grouppsdefid;
    @Column(name="grouppsdefname")
    private String grouppsdefname;
    @Column(name="grouppssyscssid")
    private String grouppssyscssid;
    @Column(name="grouppssyscssname")
    private String grouppssyscssname;
    @Column(name="grouppssyspfpluginid")
    private String grouppssyspfpluginid;
    @Column(name="grouppssyspfpluginname")
    private String grouppssyspfpluginname;
    @Column(name="groupstyle")
    private String groupstyle;
    @Column(name="grouptextpsdefid")
    private String grouptextpsdefid;
    @Column(name="grouptextpsdefname")
    private String grouptextpsdefname;
    @Column(name="groupwidth")
    private Integer groupwidth;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="navviewheight")
    private Double navviewheight;
    @Column(name="navviewmaxheight")
    private Double navviewmaxheight;
    @Column(name="navviewmaxwidth")
    private Double navviewmaxwidth;
    @Column(name="navviewminheight")
    private Double navviewminheight;
    @Column(name="navviewminwidth")
    private Double navviewminwidth;
    @Column(name="navviewpos")
    private String navviewpos;
    @Column(name="navviewshowmode")
    private Integer navviewshowmode;
    @Column(name="navviewwidth")
    private Double navviewwidth;
    @Column(name="psctrllogicgroupid")
    private String psctrllogicgroupid;
    @Column(name="psctrllogicgroupname")
    private String psctrllogicgroupname;
    @Column(name="psctrlmsgid")
    private String psctrlmsgid;
    @Column(name="psctrlmsgname")
    private String psctrlmsgname;
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
    @Column(name="pssyscalendarid")
    private String pssyscalendarid;
    @Column(name="pssyscalendarname")
    private String pssyscalendarname;
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
    @Column(name="psviewmsggroupid")
    private String psviewmsggroupid;
    @Column(name="psviewmsggroupname")
    private String psviewmsggroupname;
    @Column(name="quickpsdetoolbarid")
    private String quickpsdetoolbarid;
    @Column(name="quickpsdetoolbarname")
    private String quickpsdetoolbarname;
    @Column(name="sysappflag")
    private Integer sysappflag;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objGroupPSCodeListLock = new Integer(1);
    private PSCodeList grouppscodelist = null;
    private Integer objPSCtrlLogicGroupLock = new Integer(1);
    private PSCtrlLogicGroup psctrllogicgroup = null;
    private Integer objPSCtrlMsgLock = new Integer(1);
    private PSCtrlMsg psctrlmsg = null;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objGroupPSDEFLock = new Integer(1);
    private PSDEField grouppsdef = null;
    private Integer objGroupTextPSDEFLock = new Integer(1);
    private PSDEField grouptextpsdef = null;
    private Integer objBatPSDEToolbarLock = new Integer(1);
    private PSDEToolbar batpsdetoolbar = null;
    private Integer objQuickPSDEToolbarLock = new Integer(1);
    private PSDEToolbar quickpsdetoolbar = null;
    private Integer objEmptyTextPSLanResLock = new Integer(1);
    private PSLanguageRes emptytextpslanres = null;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSysAppLock = new Integer(1);
    private PSSysApp pssysapp = null;
    private Integer objGroupPSSysCssLock = new Integer(1);
    private PSSysCss grouppssyscss = null;
    private Integer objPSSysCssLock = new Integer(1);
    private PSSysCss pssyscss = null;
    private Integer objGanttPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin ganttpssyspfplugin = null;
    private Integer objGroupPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin grouppssyspfplugin = null;
    private Integer objPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin pssyspfplugin = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSViewMsgGroupLock = new Integer(1);
    private PSViewMsgGroup psviewmsggroup = null;
    private Integer objPSSysCalendarItemsLock = new Integer(1);
    private ArrayList<PSSysCalendarItem> pssyscalendaritems = null;
    private Integer objPSSysCalendarLogicsLock = new Integer(1);
    private ArrayList<PSSysCalendarLogic> pssyscalendarlogics = null;

    public void setBatPSDEToolbarId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBatPSDEToolbarId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.batpsdetoolbarid = string;
        this.batpsdetoolbaridDirtyFlag = true;
    }

    public String getBatPSDEToolbarId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBatPSDEToolbarId();
        }
        return this.batpsdetoolbarid;
    }

    public boolean isBatPSDEToolbarIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBatPSDEToolbarIdDirty();
        }
        return this.batpsdetoolbaridDirtyFlag;
    }

    public void resetBatPSDEToolbarId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBatPSDEToolbarId();
            return;
        }
        this.batpsdetoolbaridDirtyFlag = false;
        this.batpsdetoolbarid = null;
    }

    public void setBatPSDEToolbarName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBatPSDEToolbarName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.batpsdetoolbarname = string;
        this.batpsdetoolbarnameDirtyFlag = true;
    }

    public String getBatPSDEToolbarName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBatPSDEToolbarName();
        }
        return this.batpsdetoolbarname;
    }

    public boolean isBatPSDEToolbarNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBatPSDEToolbarNameDirty();
        }
        return this.batpsdetoolbarnameDirtyFlag;
    }

    public void resetBatPSDEToolbarName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBatPSDEToolbarName();
            return;
        }
        this.batpsdetoolbarnameDirtyFlag = false;
        this.batpsdetoolbarname = null;
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

    public void setCalendarStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCalendarStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.calendarstyle = string;
        this.calendarstyleDirtyFlag = true;
    }

    public String getCalendarStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCalendarStyle();
        }
        return this.calendarstyle;
    }

    public boolean isCalendarStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCalendarStyleDirty();
        }
        return this.calendarstyleDirtyFlag;
    }

    public void resetCalendarStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCalendarStyle();
            return;
        }
        this.calendarstyleDirtyFlag = false;
        this.calendarstyle = null;
    }

    public void setCalendarTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCalendarTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.calendartag = string;
        this.calendartagDirtyFlag = true;
    }

    public String getCalendarTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCalendarTag();
        }
        return this.calendartag;
    }

    public boolean isCalendarTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCalendarTagDirty();
        }
        return this.calendartagDirtyFlag;
    }

    public void resetCalendarTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCalendarTag();
            return;
        }
        this.calendartagDirtyFlag = false;
        this.calendartag = null;
    }

    public void setCalendarTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCalendarTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.calendartag2 = string;
        this.calendartag2DirtyFlag = true;
    }

    public String getCalendarTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCalendarTag2();
        }
        return this.calendartag2;
    }

    public boolean isCalendarTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCalendarTag2Dirty();
        }
        return this.calendartag2DirtyFlag;
    }

    public void resetCalendarTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCalendarTag2();
            return;
        }
        this.calendartag2DirtyFlag = false;
        this.calendartag2 = null;
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

    public void setEnableEdit(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableEdit(n);
            return;
        }
        this.enableedit = n;
        this.enableeditDirtyFlag = true;
    }

    public Integer getEnableEdit() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableEdit();
        }
        return this.enableedit;
    }

    public boolean isEnableEditDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableEditDirty();
        }
        return this.enableeditDirtyFlag;
    }

    public void resetEnableEdit() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableEdit();
            return;
        }
        this.enableeditDirtyFlag = false;
        this.enableedit = null;
    }

    public void setGanttFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGanttFlag(n);
            return;
        }
        this.ganttflag = n;
        this.ganttflagDirtyFlag = true;
    }

    public Integer getGanttFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGanttFlag();
        }
        return this.ganttflag;
    }

    public boolean isGanttFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGanttFlagDirty();
        }
        return this.ganttflagDirtyFlag;
    }

    public void resetGanttFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGanttFlag();
            return;
        }
        this.ganttflagDirtyFlag = false;
        this.ganttflag = null;
    }

    public void setGanttPSSysPFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGanttPSSysPFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ganttpssyspfpluginid = string;
        this.ganttpssyspfpluginidDirtyFlag = true;
    }

    public String getGanttPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGanttPSSysPFPluginId();
        }
        return this.ganttpssyspfpluginid;
    }

    public boolean isGanttPSSysPFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGanttPSSysPFPluginIdDirty();
        }
        return this.ganttpssyspfpluginidDirtyFlag;
    }

    public void resetGanttPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGanttPSSysPFPluginId();
            return;
        }
        this.ganttpssyspfpluginidDirtyFlag = false;
        this.ganttpssyspfpluginid = null;
    }

    public void setGanttPSSysPFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGanttPSSysPFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ganttpssyspfpluginname = string;
        this.ganttpssyspfpluginnameDirtyFlag = true;
    }

    public String getGanttPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGanttPSSysPFPluginName();
        }
        return this.ganttpssyspfpluginname;
    }

    public boolean isGanttPSSysPFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGanttPSSysPFPluginNameDirty();
        }
        return this.ganttpssyspfpluginnameDirtyFlag;
    }

    public void resetGanttPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGanttPSSysPFPluginName();
            return;
        }
        this.ganttpssyspfpluginnameDirtyFlag = false;
        this.ganttpssyspfpluginname = null;
    }

    public void setGanttStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGanttStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ganttstyle = string;
        this.ganttstyleDirtyFlag = true;
    }

    public String getGanttStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGanttStyle();
        }
        return this.ganttstyle;
    }

    public boolean isGanttStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGanttStyleDirty();
        }
        return this.ganttstyleDirtyFlag;
    }

    public void resetGanttStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGanttStyle();
            return;
        }
        this.ganttstyleDirtyFlag = false;
        this.ganttstyle = null;
    }

    public void setGroupHeight(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupHeight(n);
            return;
        }
        this.groupheight = n;
        this.groupheightDirtyFlag = true;
    }

    public Integer getGroupHeight() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupHeight();
        }
        return this.groupheight;
    }

    public boolean isGroupHeightDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupHeightDirty();
        }
        return this.groupheightDirtyFlag;
    }

    public void resetGroupHeight() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupHeight();
            return;
        }
        this.groupheightDirtyFlag = false;
        this.groupheight = null;
    }

    public void setGroupLayout(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupLayout(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.grouplayout = string;
        this.grouplayoutDirtyFlag = true;
    }

    public String getGroupLayout() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupLayout();
        }
        return this.grouplayout;
    }

    public boolean isGroupLayoutDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupLayoutDirty();
        }
        return this.grouplayoutDirtyFlag;
    }

    public void resetGroupLayout() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupLayout();
            return;
        }
        this.grouplayoutDirtyFlag = false;
        this.grouplayout = null;
    }

    public void setGroupMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.groupmode = string;
        this.groupmodeDirtyFlag = true;
    }

    public String getGroupMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupMode();
        }
        return this.groupmode;
    }

    public boolean isGroupModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupModeDirty();
        }
        return this.groupmodeDirtyFlag;
    }

    public void resetGroupMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupMode();
            return;
        }
        this.groupmodeDirtyFlag = false;
        this.groupmode = null;
    }

    public void setGroupPSCodeListId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupPSCodeListId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.grouppscodelistid = string;
        this.grouppscodelistidDirtyFlag = true;
    }

    public String getGroupPSCodeListId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupPSCodeListId();
        }
        return this.grouppscodelistid;
    }

    public boolean isGroupPSCodeListIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupPSCodeListIdDirty();
        }
        return this.grouppscodelistidDirtyFlag;
    }

    public void resetGroupPSCodeListId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupPSCodeListId();
            return;
        }
        this.grouppscodelistidDirtyFlag = false;
        this.grouppscodelistid = null;
    }

    public void setGroupPSCodeListName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupPSCodeListName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.grouppscodelistname = string;
        this.grouppscodelistnameDirtyFlag = true;
    }

    public String getGroupPSCodeListName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupPSCodeListName();
        }
        return this.grouppscodelistname;
    }

    public boolean isGroupPSCodeListNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupPSCodeListNameDirty();
        }
        return this.grouppscodelistnameDirtyFlag;
    }

    public void resetGroupPSCodeListName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupPSCodeListName();
            return;
        }
        this.grouppscodelistnameDirtyFlag = false;
        this.grouppscodelistname = null;
    }

    public void setGroupPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.grouppsdefid = string;
        this.grouppsdefidDirtyFlag = true;
    }

    public String getGroupPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupPSDEFId();
        }
        return this.grouppsdefid;
    }

    public boolean isGroupPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupPSDEFIdDirty();
        }
        return this.grouppsdefidDirtyFlag;
    }

    public void resetGroupPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupPSDEFId();
            return;
        }
        this.grouppsdefidDirtyFlag = false;
        this.grouppsdefid = null;
    }

    public void setGroupPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.grouppsdefname = string;
        this.grouppsdefnameDirtyFlag = true;
    }

    public String getGroupPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupPSDEFName();
        }
        return this.grouppsdefname;
    }

    public boolean isGroupPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupPSDEFNameDirty();
        }
        return this.grouppsdefnameDirtyFlag;
    }

    public void resetGroupPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupPSDEFName();
            return;
        }
        this.grouppsdefnameDirtyFlag = false;
        this.grouppsdefname = null;
    }

    public void setGroupPSSysCssId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupPSSysCssId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.grouppssyscssid = string;
        this.grouppssyscssidDirtyFlag = true;
    }

    public String getGroupPSSysCssId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupPSSysCssId();
        }
        return this.grouppssyscssid;
    }

    public boolean isGroupPSSysCssIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupPSSysCssIdDirty();
        }
        return this.grouppssyscssidDirtyFlag;
    }

    public void resetGroupPSSysCssId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupPSSysCssId();
            return;
        }
        this.grouppssyscssidDirtyFlag = false;
        this.grouppssyscssid = null;
    }

    public void setGroupPSSysCssName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupPSSysCssName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.grouppssyscssname = string;
        this.grouppssyscssnameDirtyFlag = true;
    }

    public String getGroupPSSysCssName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupPSSysCssName();
        }
        return this.grouppssyscssname;
    }

    public boolean isGroupPSSysCssNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupPSSysCssNameDirty();
        }
        return this.grouppssyscssnameDirtyFlag;
    }

    public void resetGroupPSSysCssName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupPSSysCssName();
            return;
        }
        this.grouppssyscssnameDirtyFlag = false;
        this.grouppssyscssname = null;
    }

    public void setGroupPSSysPFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupPSSysPFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.grouppssyspfpluginid = string;
        this.grouppssyspfpluginidDirtyFlag = true;
    }

    public String getGroupPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupPSSysPFPluginId();
        }
        return this.grouppssyspfpluginid;
    }

    public boolean isGroupPSSysPFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupPSSysPFPluginIdDirty();
        }
        return this.grouppssyspfpluginidDirtyFlag;
    }

    public void resetGroupPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupPSSysPFPluginId();
            return;
        }
        this.grouppssyspfpluginidDirtyFlag = false;
        this.grouppssyspfpluginid = null;
    }

    public void setGroupPSSysPFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupPSSysPFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.grouppssyspfpluginname = string;
        this.grouppssyspfpluginnameDirtyFlag = true;
    }

    public String getGroupPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupPSSysPFPluginName();
        }
        return this.grouppssyspfpluginname;
    }

    public boolean isGroupPSSysPFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupPSSysPFPluginNameDirty();
        }
        return this.grouppssyspfpluginnameDirtyFlag;
    }

    public void resetGroupPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupPSSysPFPluginName();
            return;
        }
        this.grouppssyspfpluginnameDirtyFlag = false;
        this.grouppssyspfpluginname = null;
    }

    public void setGroupStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.groupstyle = string;
        this.groupstyleDirtyFlag = true;
    }

    public String getGroupStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupStyle();
        }
        return this.groupstyle;
    }

    public boolean isGroupStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupStyleDirty();
        }
        return this.groupstyleDirtyFlag;
    }

    public void resetGroupStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupStyle();
            return;
        }
        this.groupstyleDirtyFlag = false;
        this.groupstyle = null;
    }

    public void setGroupTextPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupTextPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.grouptextpsdefid = string;
        this.grouptextpsdefidDirtyFlag = true;
    }

    public String getGroupTextPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupTextPSDEFId();
        }
        return this.grouptextpsdefid;
    }

    public boolean isGroupTextPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupTextPSDEFIdDirty();
        }
        return this.grouptextpsdefidDirtyFlag;
    }

    public void resetGroupTextPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupTextPSDEFId();
            return;
        }
        this.grouptextpsdefidDirtyFlag = false;
        this.grouptextpsdefid = null;
    }

    public void setGroupTextPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupTextPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.grouptextpsdefname = string;
        this.grouptextpsdefnameDirtyFlag = true;
    }

    public String getGroupTextPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupTextPSDEFName();
        }
        return this.grouptextpsdefname;
    }

    public boolean isGroupTextPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupTextPSDEFNameDirty();
        }
        return this.grouptextpsdefnameDirtyFlag;
    }

    public void resetGroupTextPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupTextPSDEFName();
            return;
        }
        this.grouptextpsdefnameDirtyFlag = false;
        this.grouptextpsdefname = null;
    }

    public void setGroupWidth(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupWidth(n);
            return;
        }
        this.groupwidth = n;
        this.groupwidthDirtyFlag = true;
    }

    public Integer getGroupWidth() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupWidth();
        }
        return this.groupwidth;
    }

    public boolean isGroupWidthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupWidthDirty();
        }
        return this.groupwidthDirtyFlag;
    }

    public void resetGroupWidth() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupWidth();
            return;
        }
        this.groupwidthDirtyFlag = false;
        this.groupwidth = null;
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

    public void setNavViewHeight(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNavViewHeight(d);
            return;
        }
        this.navviewheight = d;
        this.navviewheightDirtyFlag = true;
    }

    public Double getNavViewHeight() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNavViewHeight();
        }
        return this.navviewheight;
    }

    public boolean isNavViewHeightDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNavViewHeightDirty();
        }
        return this.navviewheightDirtyFlag;
    }

    public void resetNavViewHeight() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNavViewHeight();
            return;
        }
        this.navviewheightDirtyFlag = false;
        this.navviewheight = null;
    }

    public void setNavViewMaxHeight(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNavViewMaxHeight(d);
            return;
        }
        this.navviewmaxheight = d;
        this.navviewmaxheightDirtyFlag = true;
    }

    public Double getNavViewMaxHeight() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNavViewMaxHeight();
        }
        return this.navviewmaxheight;
    }

    public boolean isNavViewMaxHeightDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNavViewMaxHeightDirty();
        }
        return this.navviewmaxheightDirtyFlag;
    }

    public void resetNavViewMaxHeight() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNavViewMaxHeight();
            return;
        }
        this.navviewmaxheightDirtyFlag = false;
        this.navviewmaxheight = null;
    }

    public void setNavViewMaxWidth(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNavViewMaxWidth(d);
            return;
        }
        this.navviewmaxwidth = d;
        this.navviewmaxwidthDirtyFlag = true;
    }

    public Double getNavViewMaxWidth() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNavViewMaxWidth();
        }
        return this.navviewmaxwidth;
    }

    public boolean isNavViewMaxWidthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNavViewMaxWidthDirty();
        }
        return this.navviewmaxwidthDirtyFlag;
    }

    public void resetNavViewMaxWidth() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNavViewMaxWidth();
            return;
        }
        this.navviewmaxwidthDirtyFlag = false;
        this.navviewmaxwidth = null;
    }

    public void setNavViewMinHeight(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNavViewMinHeight(d);
            return;
        }
        this.navviewminheight = d;
        this.navviewminheightDirtyFlag = true;
    }

    public Double getNavViewMinHeight() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNavViewMinHeight();
        }
        return this.navviewminheight;
    }

    public boolean isNavViewMinHeightDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNavViewMinHeightDirty();
        }
        return this.navviewminheightDirtyFlag;
    }

    public void resetNavViewMinHeight() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNavViewMinHeight();
            return;
        }
        this.navviewminheightDirtyFlag = false;
        this.navviewminheight = null;
    }

    public void setNavViewMinWidth(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNavViewMinWidth(d);
            return;
        }
        this.navviewminwidth = d;
        this.navviewminwidthDirtyFlag = true;
    }

    public Double getNavViewMinWidth() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNavViewMinWidth();
        }
        return this.navviewminwidth;
    }

    public boolean isNavViewMinWidthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNavViewMinWidthDirty();
        }
        return this.navviewminwidthDirtyFlag;
    }

    public void resetNavViewMinWidth() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNavViewMinWidth();
            return;
        }
        this.navviewminwidthDirtyFlag = false;
        this.navviewminwidth = null;
    }

    public void setNavViewPos(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNavViewPos(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.navviewpos = string;
        this.navviewposDirtyFlag = true;
    }

    public String getNavViewPos() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNavViewPos();
        }
        return this.navviewpos;
    }

    public boolean isNavViewPosDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNavViewPosDirty();
        }
        return this.navviewposDirtyFlag;
    }

    public void resetNavViewPos() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNavViewPos();
            return;
        }
        this.navviewposDirtyFlag = false;
        this.navviewpos = null;
    }

    public void setNavViewShowMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNavViewShowMode(n);
            return;
        }
        this.navviewshowmode = n;
        this.navviewshowmodeDirtyFlag = true;
    }

    public Integer getNavViewShowMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNavViewShowMode();
        }
        return this.navviewshowmode;
    }

    public boolean isNavViewShowModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNavViewShowModeDirty();
        }
        return this.navviewshowmodeDirtyFlag;
    }

    public void resetNavViewShowMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNavViewShowMode();
            return;
        }
        this.navviewshowmodeDirtyFlag = false;
        this.navviewshowmode = null;
    }

    public void setNavViewWidth(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNavViewWidth(d);
            return;
        }
        this.navviewwidth = d;
        this.navviewwidthDirtyFlag = true;
    }

    public Double getNavViewWidth() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNavViewWidth();
        }
        return this.navviewwidth;
    }

    public boolean isNavViewWidthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNavViewWidthDirty();
        }
        return this.navviewwidthDirtyFlag;
    }

    public void resetNavViewWidth() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNavViewWidth();
            return;
        }
        this.navviewwidthDirtyFlag = false;
        this.navviewwidth = null;
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

    public void setQuickPSDEToolbarId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setQuickPSDEToolbarId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.quickpsdetoolbarid = string;
        this.quickpsdetoolbaridDirtyFlag = true;
    }

    public String getQuickPSDEToolbarId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getQuickPSDEToolbarId();
        }
        return this.quickpsdetoolbarid;
    }

    public boolean isQuickPSDEToolbarIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isQuickPSDEToolbarIdDirty();
        }
        return this.quickpsdetoolbaridDirtyFlag;
    }

    public void resetQuickPSDEToolbarId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetQuickPSDEToolbarId();
            return;
        }
        this.quickpsdetoolbaridDirtyFlag = false;
        this.quickpsdetoolbarid = null;
    }

    public void setQuickPSDEToolbarName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setQuickPSDEToolbarName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.quickpsdetoolbarname = string;
        this.quickpsdetoolbarnameDirtyFlag = true;
    }

    public String getQuickPSDEToolbarName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getQuickPSDEToolbarName();
        }
        return this.quickpsdetoolbarname;
    }

    public boolean isQuickPSDEToolbarNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isQuickPSDEToolbarNameDirty();
        }
        return this.quickpsdetoolbarnameDirtyFlag;
    }

    public void resetQuickPSDEToolbarName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetQuickPSDEToolbarName();
            return;
        }
        this.quickpsdetoolbarnameDirtyFlag = false;
        this.quickpsdetoolbarname = null;
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

    protected void onReset() {
        PSSysCalendarBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysCalendarBase pSSysCalendarBase) {
        pSSysCalendarBase.resetBatPSDEToolbarId();
        pSSysCalendarBase.resetBatPSDEToolbarName();
        pSSysCalendarBase.resetBusyIndicator();
        pSSysCalendarBase.resetCalendarStyle();
        pSSysCalendarBase.resetCalendarTag();
        pSSysCalendarBase.resetCalendarTag2();
        pSSysCalendarBase.resetCodeName();
        pSSysCalendarBase.resetCreateDate();
        pSSysCalendarBase.resetCreateMan();
        pSSysCalendarBase.resetEmptyText();
        pSSysCalendarBase.resetEmptyTextPSLanResId();
        pSSysCalendarBase.resetEmptyTextPSLanResName();
        pSSysCalendarBase.resetEnableEdit();
        pSSysCalendarBase.resetGanttFlag();
        pSSysCalendarBase.resetGanttPSSysPFPluginId();
        pSSysCalendarBase.resetGanttPSSysPFPluginName();
        pSSysCalendarBase.resetGanttStyle();
        pSSysCalendarBase.resetGroupHeight();
        pSSysCalendarBase.resetGroupLayout();
        pSSysCalendarBase.resetGroupMode();
        pSSysCalendarBase.resetGroupPSCodeListId();
        pSSysCalendarBase.resetGroupPSCodeListName();
        pSSysCalendarBase.resetGroupPSDEFId();
        pSSysCalendarBase.resetGroupPSDEFName();
        pSSysCalendarBase.resetGroupPSSysCssId();
        pSSysCalendarBase.resetGroupPSSysCssName();
        pSSysCalendarBase.resetGroupPSSysPFPluginId();
        pSSysCalendarBase.resetGroupPSSysPFPluginName();
        pSSysCalendarBase.resetGroupStyle();
        pSSysCalendarBase.resetGroupTextPSDEFId();
        pSSysCalendarBase.resetGroupTextPSDEFName();
        pSSysCalendarBase.resetGroupWidth();
        pSSysCalendarBase.resetLockFlag();
        pSSysCalendarBase.resetLogicName();
        pSSysCalendarBase.resetMemo();
        pSSysCalendarBase.resetNavViewHeight();
        pSSysCalendarBase.resetNavViewMaxHeight();
        pSSysCalendarBase.resetNavViewMaxWidth();
        pSSysCalendarBase.resetNavViewMinHeight();
        pSSysCalendarBase.resetNavViewMinWidth();
        pSSysCalendarBase.resetNavViewPos();
        pSSysCalendarBase.resetNavViewShowMode();
        pSSysCalendarBase.resetNavViewWidth();
        pSSysCalendarBase.resetPSCtrlLogicGroupId();
        pSSysCalendarBase.resetPSCtrlLogicGroupName();
        pSSysCalendarBase.resetPSCtrlMsgId();
        pSSysCalendarBase.resetPSCtrlMsgName();
        pSSysCalendarBase.resetPSDEId();
        pSSysCalendarBase.resetPSDEName();
        pSSysCalendarBase.resetPSModuleId();
        pSSysCalendarBase.resetPSModuleName();
        pSSysCalendarBase.resetPSSysAppId();
        pSSysCalendarBase.resetPSSysAppName();
        pSSysCalendarBase.resetPSSysCalendarId();
        pSSysCalendarBase.resetPSSysCalendarName();
        pSSysCalendarBase.resetPSSysCssId();
        pSSysCalendarBase.resetPSSysCssName();
        pSSysCalendarBase.resetPSSysPFPluginId();
        pSSysCalendarBase.resetPSSysPFPluginName();
        pSSysCalendarBase.resetPSSystemId();
        pSSysCalendarBase.resetPSSystemName();
        pSSysCalendarBase.resetPSViewMsgGroupId();
        pSSysCalendarBase.resetPSViewMsgGroupName();
        pSSysCalendarBase.resetQuickPSDEToolbarId();
        pSSysCalendarBase.resetQuickPSDEToolbarName();
        pSSysCalendarBase.resetSysAppFlag();
        pSSysCalendarBase.resetUpdateDate();
        pSSysCalendarBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBatPSDEToolbarIdDirty()) {
            hashMap.put(FIELD_BATPSDETOOLBARID, this.getBatPSDEToolbarId());
        }
        if (!bl || this.isBatPSDEToolbarNameDirty()) {
            hashMap.put(FIELD_BATPSDETOOLBARNAME, this.getBatPSDEToolbarName());
        }
        if (!bl || this.isBusyIndicatorDirty()) {
            hashMap.put(FIELD_BUSYINDICATOR, this.getBusyIndicator());
        }
        if (!bl || this.isCalendarStyleDirty()) {
            hashMap.put(FIELD_CALENDARSTYLE, this.getCalendarStyle());
        }
        if (!bl || this.isCalendarTagDirty()) {
            hashMap.put(FIELD_CALENDARTAG, this.getCalendarTag());
        }
        if (!bl || this.isCalendarTag2Dirty()) {
            hashMap.put(FIELD_CALENDARTAG2, this.getCalendarTag2());
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
        if (!bl || this.isEmptyTextDirty()) {
            hashMap.put(FIELD_EMPTYTEXT, this.getEmptyText());
        }
        if (!bl || this.isEmptyTextPSLanResIdDirty()) {
            hashMap.put(FIELD_EMPTYTEXTPSLANRESID, this.getEmptyTextPSLanResId());
        }
        if (!bl || this.isEmptyTextPSLanResNameDirty()) {
            hashMap.put(FIELD_EMPTYTEXTPSLANRESNAME, this.getEmptyTextPSLanResName());
        }
        if (!bl || this.isEnableEditDirty()) {
            hashMap.put(FIELD_ENABLEEDIT, this.getEnableEdit());
        }
        if (!bl || this.isGanttFlagDirty()) {
            hashMap.put(FIELD_GANTTFLAG, this.getGanttFlag());
        }
        if (!bl || this.isGanttPSSysPFPluginIdDirty()) {
            hashMap.put(FIELD_GANTTPSSYSPFPLUGINID, this.getGanttPSSysPFPluginId());
        }
        if (!bl || this.isGanttPSSysPFPluginNameDirty()) {
            hashMap.put(FIELD_GANTTPSSYSPFPLUGINNAME, this.getGanttPSSysPFPluginName());
        }
        if (!bl || this.isGanttStyleDirty()) {
            hashMap.put(FIELD_GANTTSTYLE, this.getGanttStyle());
        }
        if (!bl || this.isGroupHeightDirty()) {
            hashMap.put(FIELD_GROUPHEIGHT, this.getGroupHeight());
        }
        if (!bl || this.isGroupLayoutDirty()) {
            hashMap.put(FIELD_GROUPLAYOUT, this.getGroupLayout());
        }
        if (!bl || this.isGroupModeDirty()) {
            hashMap.put(FIELD_GROUPMODE, this.getGroupMode());
        }
        if (!bl || this.isGroupPSCodeListIdDirty()) {
            hashMap.put(FIELD_GROUPPSCODELISTID, this.getGroupPSCodeListId());
        }
        if (!bl || this.isGroupPSCodeListNameDirty()) {
            hashMap.put(FIELD_GROUPPSCODELISTNAME, this.getGroupPSCodeListName());
        }
        if (!bl || this.isGroupPSDEFIdDirty()) {
            hashMap.put(FIELD_GROUPPSDEFID, this.getGroupPSDEFId());
        }
        if (!bl || this.isGroupPSDEFNameDirty()) {
            hashMap.put(FIELD_GROUPPSDEFNAME, this.getGroupPSDEFName());
        }
        if (!bl || this.isGroupPSSysCssIdDirty()) {
            hashMap.put(FIELD_GROUPPSSYSCSSID, this.getGroupPSSysCssId());
        }
        if (!bl || this.isGroupPSSysCssNameDirty()) {
            hashMap.put(FIELD_GROUPPSSYSCSSNAME, this.getGroupPSSysCssName());
        }
        if (!bl || this.isGroupPSSysPFPluginIdDirty()) {
            hashMap.put(FIELD_GROUPPSSYSPFPLUGINID, this.getGroupPSSysPFPluginId());
        }
        if (!bl || this.isGroupPSSysPFPluginNameDirty()) {
            hashMap.put(FIELD_GROUPPSSYSPFPLUGINNAME, this.getGroupPSSysPFPluginName());
        }
        if (!bl || this.isGroupStyleDirty()) {
            hashMap.put(FIELD_GROUPSTYLE, this.getGroupStyle());
        }
        if (!bl || this.isGroupTextPSDEFIdDirty()) {
            hashMap.put(FIELD_GROUPTEXTPSDEFID, this.getGroupTextPSDEFId());
        }
        if (!bl || this.isGroupTextPSDEFNameDirty()) {
            hashMap.put(FIELD_GROUPTEXTPSDEFNAME, this.getGroupTextPSDEFName());
        }
        if (!bl || this.isGroupWidthDirty()) {
            hashMap.put(FIELD_GROUPWIDTH, this.getGroupWidth());
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
        if (!bl || this.isNavViewHeightDirty()) {
            hashMap.put(FIELD_NAVVIEWHEIGHT, this.getNavViewHeight());
        }
        if (!bl || this.isNavViewMaxHeightDirty()) {
            hashMap.put(FIELD_NAVVIEWMAXHEIGHT, this.getNavViewMaxHeight());
        }
        if (!bl || this.isNavViewMaxWidthDirty()) {
            hashMap.put(FIELD_NAVVIEWMAXWIDTH, this.getNavViewMaxWidth());
        }
        if (!bl || this.isNavViewMinHeightDirty()) {
            hashMap.put(FIELD_NAVVIEWMINHEIGHT, this.getNavViewMinHeight());
        }
        if (!bl || this.isNavViewMinWidthDirty()) {
            hashMap.put(FIELD_NAVVIEWMINWIDTH, this.getNavViewMinWidth());
        }
        if (!bl || this.isNavViewPosDirty()) {
            hashMap.put(FIELD_NAVVIEWPOS, this.getNavViewPos());
        }
        if (!bl || this.isNavViewShowModeDirty()) {
            hashMap.put(FIELD_NAVVIEWSHOWMODE, this.getNavViewShowMode());
        }
        if (!bl || this.isNavViewWidthDirty()) {
            hashMap.put(FIELD_NAVVIEWWIDTH, this.getNavViewWidth());
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
        if (!bl || this.isPSViewMsgGroupIdDirty()) {
            hashMap.put(FIELD_PSVIEWMSGGROUPID, this.getPSViewMsgGroupId());
        }
        if (!bl || this.isPSViewMsgGroupNameDirty()) {
            hashMap.put(FIELD_PSVIEWMSGGROUPNAME, this.getPSViewMsgGroupName());
        }
        if (!bl || this.isQuickPSDEToolbarIdDirty()) {
            hashMap.put(FIELD_QUICKPSDETOOLBARID, this.getQuickPSDEToolbarId());
        }
        if (!bl || this.isQuickPSDEToolbarNameDirty()) {
            hashMap.put(FIELD_QUICKPSDETOOLBARNAME, this.getQuickPSDEToolbarName());
        }
        if (!bl || this.isSysAppFlagDirty()) {
            hashMap.put(FIELD_SYSAPPFLAG, this.getSysAppFlag());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
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
        return PSSysCalendarBase.get(this, n);
    }

    private static Object get(PSSysCalendarBase pSSysCalendarBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysCalendarBase.getBatPSDEToolbarId();
            }
            case 1: {
                return pSSysCalendarBase.getBatPSDEToolbarName();
            }
            case 2: {
                return pSSysCalendarBase.getBusyIndicator();
            }
            case 3: {
                return pSSysCalendarBase.getCalendarStyle();
            }
            case 4: {
                return pSSysCalendarBase.getCalendarTag();
            }
            case 5: {
                return pSSysCalendarBase.getCalendarTag2();
            }
            case 6: {
                return pSSysCalendarBase.getCodeName();
            }
            case 7: {
                return pSSysCalendarBase.getCreateDate();
            }
            case 8: {
                return pSSysCalendarBase.getCreateMan();
            }
            case 9: {
                return pSSysCalendarBase.getEmptyText();
            }
            case 10: {
                return pSSysCalendarBase.getEmptyTextPSLanResId();
            }
            case 11: {
                return pSSysCalendarBase.getEmptyTextPSLanResName();
            }
            case 12: {
                return pSSysCalendarBase.getEnableEdit();
            }
            case 13: {
                return pSSysCalendarBase.getGanttFlag();
            }
            case 14: {
                return pSSysCalendarBase.getGanttPSSysPFPluginId();
            }
            case 15: {
                return pSSysCalendarBase.getGanttPSSysPFPluginName();
            }
            case 16: {
                return pSSysCalendarBase.getGanttStyle();
            }
            case 17: {
                return pSSysCalendarBase.getGroupHeight();
            }
            case 18: {
                return pSSysCalendarBase.getGroupLayout();
            }
            case 19: {
                return pSSysCalendarBase.getGroupMode();
            }
            case 20: {
                return pSSysCalendarBase.getGroupPSCodeListId();
            }
            case 21: {
                return pSSysCalendarBase.getGroupPSCodeListName();
            }
            case 22: {
                return pSSysCalendarBase.getGroupPSDEFId();
            }
            case 23: {
                return pSSysCalendarBase.getGroupPSDEFName();
            }
            case 24: {
                return pSSysCalendarBase.getGroupPSSysCssId();
            }
            case 25: {
                return pSSysCalendarBase.getGroupPSSysCssName();
            }
            case 26: {
                return pSSysCalendarBase.getGroupPSSysPFPluginId();
            }
            case 27: {
                return pSSysCalendarBase.getGroupPSSysPFPluginName();
            }
            case 28: {
                return pSSysCalendarBase.getGroupStyle();
            }
            case 29: {
                return pSSysCalendarBase.getGroupTextPSDEFId();
            }
            case 30: {
                return pSSysCalendarBase.getGroupTextPSDEFName();
            }
            case 31: {
                return pSSysCalendarBase.getGroupWidth();
            }
            case 32: {
                return pSSysCalendarBase.getLockFlag();
            }
            case 33: {
                return pSSysCalendarBase.getLogicName();
            }
            case 34: {
                return pSSysCalendarBase.getMemo();
            }
            case 35: {
                return pSSysCalendarBase.getNavViewHeight();
            }
            case 36: {
                return pSSysCalendarBase.getNavViewMaxHeight();
            }
            case 37: {
                return pSSysCalendarBase.getNavViewMaxWidth();
            }
            case 38: {
                return pSSysCalendarBase.getNavViewMinHeight();
            }
            case 39: {
                return pSSysCalendarBase.getNavViewMinWidth();
            }
            case 40: {
                return pSSysCalendarBase.getNavViewPos();
            }
            case 41: {
                return pSSysCalendarBase.getNavViewShowMode();
            }
            case 42: {
                return pSSysCalendarBase.getNavViewWidth();
            }
            case 43: {
                return pSSysCalendarBase.getPSCtrlLogicGroupId();
            }
            case 44: {
                return pSSysCalendarBase.getPSCtrlLogicGroupName();
            }
            case 45: {
                return pSSysCalendarBase.getPSCtrlMsgId();
            }
            case 46: {
                return pSSysCalendarBase.getPSCtrlMsgName();
            }
            case 47: {
                return pSSysCalendarBase.getPSDEId();
            }
            case 48: {
                return pSSysCalendarBase.getPSDEName();
            }
            case 49: {
                return pSSysCalendarBase.getPSModuleId();
            }
            case 50: {
                return pSSysCalendarBase.getPSModuleName();
            }
            case 51: {
                return pSSysCalendarBase.getPSSysAppId();
            }
            case 52: {
                return pSSysCalendarBase.getPSSysAppName();
            }
            case 53: {
                return pSSysCalendarBase.getPSSysCalendarId();
            }
            case 54: {
                return pSSysCalendarBase.getPSSysCalendarName();
            }
            case 55: {
                return pSSysCalendarBase.getPSSysCssId();
            }
            case 56: {
                return pSSysCalendarBase.getPSSysCssName();
            }
            case 57: {
                return pSSysCalendarBase.getPSSysPFPluginId();
            }
            case 58: {
                return pSSysCalendarBase.getPSSysPFPluginName();
            }
            case 59: {
                return pSSysCalendarBase.getPSSystemId();
            }
            case 60: {
                return pSSysCalendarBase.getPSSystemName();
            }
            case 61: {
                return pSSysCalendarBase.getPSViewMsgGroupId();
            }
            case 62: {
                return pSSysCalendarBase.getPSViewMsgGroupName();
            }
            case 63: {
                return pSSysCalendarBase.getQuickPSDEToolbarId();
            }
            case 64: {
                return pSSysCalendarBase.getQuickPSDEToolbarName();
            }
            case 65: {
                return pSSysCalendarBase.getSysAppFlag();
            }
            case 66: {
                return pSSysCalendarBase.getUpdateDate();
            }
            case 67: {
                return pSSysCalendarBase.getUpdateMan();
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
        PSSysCalendarBase.set(this, n, object);
    }

    private static void set(PSSysCalendarBase pSSysCalendarBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysCalendarBase.setBatPSDEToolbarId(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysCalendarBase.setBatPSDEToolbarName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysCalendarBase.setBusyIndicator(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSSysCalendarBase.setCalendarStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysCalendarBase.setCalendarTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysCalendarBase.setCalendarTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysCalendarBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysCalendarBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSSysCalendarBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysCalendarBase.setEmptyText(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysCalendarBase.setEmptyTextPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysCalendarBase.setEmptyTextPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysCalendarBase.setEnableEdit(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSSysCalendarBase.setGanttFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSSysCalendarBase.setGanttPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysCalendarBase.setGanttPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysCalendarBase.setGanttStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysCalendarBase.setGroupHeight(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSSysCalendarBase.setGroupLayout(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysCalendarBase.setGroupMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysCalendarBase.setGroupPSCodeListId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysCalendarBase.setGroupPSCodeListName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysCalendarBase.setGroupPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysCalendarBase.setGroupPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysCalendarBase.setGroupPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysCalendarBase.setGroupPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysCalendarBase.setGroupPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysCalendarBase.setGroupPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysCalendarBase.setGroupStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysCalendarBase.setGroupTextPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysCalendarBase.setGroupTextPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysCalendarBase.setGroupWidth(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 32: {
                pSSysCalendarBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 33: {
                pSSysCalendarBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysCalendarBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSysCalendarBase.setNavViewHeight(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 36: {
                pSSysCalendarBase.setNavViewMaxHeight(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 37: {
                pSSysCalendarBase.setNavViewMaxWidth(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 38: {
                pSSysCalendarBase.setNavViewMinHeight(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 39: {
                pSSysCalendarBase.setNavViewMinWidth(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 40: {
                pSSysCalendarBase.setNavViewPos(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSSysCalendarBase.setNavViewShowMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 42: {
                pSSysCalendarBase.setNavViewWidth(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 43: {
                pSSysCalendarBase.setPSCtrlLogicGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSSysCalendarBase.setPSCtrlLogicGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSSysCalendarBase.setPSCtrlMsgId(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSSysCalendarBase.setPSCtrlMsgName(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSSysCalendarBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSSysCalendarBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSSysCalendarBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSSysCalendarBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSSysCalendarBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSSysCalendarBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSSysCalendarBase.setPSSysCalendarId(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSSysCalendarBase.setPSSysCalendarName(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSSysCalendarBase.setPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSSysCalendarBase.setPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSSysCalendarBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 58: {
                pSSysCalendarBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 59: {
                pSSysCalendarBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 60: {
                pSSysCalendarBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 61: {
                pSSysCalendarBase.setPSViewMsgGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 62: {
                pSSysCalendarBase.setPSViewMsgGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 63: {
                pSSysCalendarBase.setQuickPSDEToolbarId(DataObject.getStringValue((Object)object));
                return;
            }
            case 64: {
                pSSysCalendarBase.setQuickPSDEToolbarName(DataObject.getStringValue((Object)object));
                return;
            }
            case 65: {
                pSSysCalendarBase.setSysAppFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 66: {
                pSSysCalendarBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 67: {
                pSSysCalendarBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSysCalendarBase.isNull(this, n);
    }

    private static boolean isNull(PSSysCalendarBase pSSysCalendarBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysCalendarBase.getBatPSDEToolbarId() == null;
            }
            case 1: {
                return pSSysCalendarBase.getBatPSDEToolbarName() == null;
            }
            case 2: {
                return pSSysCalendarBase.getBusyIndicator() == null;
            }
            case 3: {
                return pSSysCalendarBase.getCalendarStyle() == null;
            }
            case 4: {
                return pSSysCalendarBase.getCalendarTag() == null;
            }
            case 5: {
                return pSSysCalendarBase.getCalendarTag2() == null;
            }
            case 6: {
                return pSSysCalendarBase.getCodeName() == null;
            }
            case 7: {
                return pSSysCalendarBase.getCreateDate() == null;
            }
            case 8: {
                return pSSysCalendarBase.getCreateMan() == null;
            }
            case 9: {
                return pSSysCalendarBase.getEmptyText() == null;
            }
            case 10: {
                return pSSysCalendarBase.getEmptyTextPSLanResId() == null;
            }
            case 11: {
                return pSSysCalendarBase.getEmptyTextPSLanResName() == null;
            }
            case 12: {
                return pSSysCalendarBase.getEnableEdit() == null;
            }
            case 13: {
                return pSSysCalendarBase.getGanttFlag() == null;
            }
            case 14: {
                return pSSysCalendarBase.getGanttPSSysPFPluginId() == null;
            }
            case 15: {
                return pSSysCalendarBase.getGanttPSSysPFPluginName() == null;
            }
            case 16: {
                return pSSysCalendarBase.getGanttStyle() == null;
            }
            case 17: {
                return pSSysCalendarBase.getGroupHeight() == null;
            }
            case 18: {
                return pSSysCalendarBase.getGroupLayout() == null;
            }
            case 19: {
                return pSSysCalendarBase.getGroupMode() == null;
            }
            case 20: {
                return pSSysCalendarBase.getGroupPSCodeListId() == null;
            }
            case 21: {
                return pSSysCalendarBase.getGroupPSCodeListName() == null;
            }
            case 22: {
                return pSSysCalendarBase.getGroupPSDEFId() == null;
            }
            case 23: {
                return pSSysCalendarBase.getGroupPSDEFName() == null;
            }
            case 24: {
                return pSSysCalendarBase.getGroupPSSysCssId() == null;
            }
            case 25: {
                return pSSysCalendarBase.getGroupPSSysCssName() == null;
            }
            case 26: {
                return pSSysCalendarBase.getGroupPSSysPFPluginId() == null;
            }
            case 27: {
                return pSSysCalendarBase.getGroupPSSysPFPluginName() == null;
            }
            case 28: {
                return pSSysCalendarBase.getGroupStyle() == null;
            }
            case 29: {
                return pSSysCalendarBase.getGroupTextPSDEFId() == null;
            }
            case 30: {
                return pSSysCalendarBase.getGroupTextPSDEFName() == null;
            }
            case 31: {
                return pSSysCalendarBase.getGroupWidth() == null;
            }
            case 32: {
                return pSSysCalendarBase.getLockFlag() == null;
            }
            case 33: {
                return pSSysCalendarBase.getLogicName() == null;
            }
            case 34: {
                return pSSysCalendarBase.getMemo() == null;
            }
            case 35: {
                return pSSysCalendarBase.getNavViewHeight() == null;
            }
            case 36: {
                return pSSysCalendarBase.getNavViewMaxHeight() == null;
            }
            case 37: {
                return pSSysCalendarBase.getNavViewMaxWidth() == null;
            }
            case 38: {
                return pSSysCalendarBase.getNavViewMinHeight() == null;
            }
            case 39: {
                return pSSysCalendarBase.getNavViewMinWidth() == null;
            }
            case 40: {
                return pSSysCalendarBase.getNavViewPos() == null;
            }
            case 41: {
                return pSSysCalendarBase.getNavViewShowMode() == null;
            }
            case 42: {
                return pSSysCalendarBase.getNavViewWidth() == null;
            }
            case 43: {
                return pSSysCalendarBase.getPSCtrlLogicGroupId() == null;
            }
            case 44: {
                return pSSysCalendarBase.getPSCtrlLogicGroupName() == null;
            }
            case 45: {
                return pSSysCalendarBase.getPSCtrlMsgId() == null;
            }
            case 46: {
                return pSSysCalendarBase.getPSCtrlMsgName() == null;
            }
            case 47: {
                return pSSysCalendarBase.getPSDEId() == null;
            }
            case 48: {
                return pSSysCalendarBase.getPSDEName() == null;
            }
            case 49: {
                return pSSysCalendarBase.getPSModuleId() == null;
            }
            case 50: {
                return pSSysCalendarBase.getPSModuleName() == null;
            }
            case 51: {
                return pSSysCalendarBase.getPSSysAppId() == null;
            }
            case 52: {
                return pSSysCalendarBase.getPSSysAppName() == null;
            }
            case 53: {
                return pSSysCalendarBase.getPSSysCalendarId() == null;
            }
            case 54: {
                return pSSysCalendarBase.getPSSysCalendarName() == null;
            }
            case 55: {
                return pSSysCalendarBase.getPSSysCssId() == null;
            }
            case 56: {
                return pSSysCalendarBase.getPSSysCssName() == null;
            }
            case 57: {
                return pSSysCalendarBase.getPSSysPFPluginId() == null;
            }
            case 58: {
                return pSSysCalendarBase.getPSSysPFPluginName() == null;
            }
            case 59: {
                return pSSysCalendarBase.getPSSystemId() == null;
            }
            case 60: {
                return pSSysCalendarBase.getPSSystemName() == null;
            }
            case 61: {
                return pSSysCalendarBase.getPSViewMsgGroupId() == null;
            }
            case 62: {
                return pSSysCalendarBase.getPSViewMsgGroupName() == null;
            }
            case 63: {
                return pSSysCalendarBase.getQuickPSDEToolbarId() == null;
            }
            case 64: {
                return pSSysCalendarBase.getQuickPSDEToolbarName() == null;
            }
            case 65: {
                return pSSysCalendarBase.getSysAppFlag() == null;
            }
            case 66: {
                return pSSysCalendarBase.getUpdateDate() == null;
            }
            case 67: {
                return pSSysCalendarBase.getUpdateMan() == null;
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
        return PSSysCalendarBase.contains(this, n);
    }

    private static boolean contains(PSSysCalendarBase pSSysCalendarBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysCalendarBase.isBatPSDEToolbarIdDirty();
            }
            case 1: {
                return pSSysCalendarBase.isBatPSDEToolbarNameDirty();
            }
            case 2: {
                return pSSysCalendarBase.isBusyIndicatorDirty();
            }
            case 3: {
                return pSSysCalendarBase.isCalendarStyleDirty();
            }
            case 4: {
                return pSSysCalendarBase.isCalendarTagDirty();
            }
            case 5: {
                return pSSysCalendarBase.isCalendarTag2Dirty();
            }
            case 6: {
                return pSSysCalendarBase.isCodeNameDirty();
            }
            case 7: {
                return pSSysCalendarBase.isCreateDateDirty();
            }
            case 8: {
                return pSSysCalendarBase.isCreateManDirty();
            }
            case 9: {
                return pSSysCalendarBase.isEmptyTextDirty();
            }
            case 10: {
                return pSSysCalendarBase.isEmptyTextPSLanResIdDirty();
            }
            case 11: {
                return pSSysCalendarBase.isEmptyTextPSLanResNameDirty();
            }
            case 12: {
                return pSSysCalendarBase.isEnableEditDirty();
            }
            case 13: {
                return pSSysCalendarBase.isGanttFlagDirty();
            }
            case 14: {
                return pSSysCalendarBase.isGanttPSSysPFPluginIdDirty();
            }
            case 15: {
                return pSSysCalendarBase.isGanttPSSysPFPluginNameDirty();
            }
            case 16: {
                return pSSysCalendarBase.isGanttStyleDirty();
            }
            case 17: {
                return pSSysCalendarBase.isGroupHeightDirty();
            }
            case 18: {
                return pSSysCalendarBase.isGroupLayoutDirty();
            }
            case 19: {
                return pSSysCalendarBase.isGroupModeDirty();
            }
            case 20: {
                return pSSysCalendarBase.isGroupPSCodeListIdDirty();
            }
            case 21: {
                return pSSysCalendarBase.isGroupPSCodeListNameDirty();
            }
            case 22: {
                return pSSysCalendarBase.isGroupPSDEFIdDirty();
            }
            case 23: {
                return pSSysCalendarBase.isGroupPSDEFNameDirty();
            }
            case 24: {
                return pSSysCalendarBase.isGroupPSSysCssIdDirty();
            }
            case 25: {
                return pSSysCalendarBase.isGroupPSSysCssNameDirty();
            }
            case 26: {
                return pSSysCalendarBase.isGroupPSSysPFPluginIdDirty();
            }
            case 27: {
                return pSSysCalendarBase.isGroupPSSysPFPluginNameDirty();
            }
            case 28: {
                return pSSysCalendarBase.isGroupStyleDirty();
            }
            case 29: {
                return pSSysCalendarBase.isGroupTextPSDEFIdDirty();
            }
            case 30: {
                return pSSysCalendarBase.isGroupTextPSDEFNameDirty();
            }
            case 31: {
                return pSSysCalendarBase.isGroupWidthDirty();
            }
            case 32: {
                return pSSysCalendarBase.isLockFlagDirty();
            }
            case 33: {
                return pSSysCalendarBase.isLogicNameDirty();
            }
            case 34: {
                return pSSysCalendarBase.isMemoDirty();
            }
            case 35: {
                return pSSysCalendarBase.isNavViewHeightDirty();
            }
            case 36: {
                return pSSysCalendarBase.isNavViewMaxHeightDirty();
            }
            case 37: {
                return pSSysCalendarBase.isNavViewMaxWidthDirty();
            }
            case 38: {
                return pSSysCalendarBase.isNavViewMinHeightDirty();
            }
            case 39: {
                return pSSysCalendarBase.isNavViewMinWidthDirty();
            }
            case 40: {
                return pSSysCalendarBase.isNavViewPosDirty();
            }
            case 41: {
                return pSSysCalendarBase.isNavViewShowModeDirty();
            }
            case 42: {
                return pSSysCalendarBase.isNavViewWidthDirty();
            }
            case 43: {
                return pSSysCalendarBase.isPSCtrlLogicGroupIdDirty();
            }
            case 44: {
                return pSSysCalendarBase.isPSCtrlLogicGroupNameDirty();
            }
            case 45: {
                return pSSysCalendarBase.isPSCtrlMsgIdDirty();
            }
            case 46: {
                return pSSysCalendarBase.isPSCtrlMsgNameDirty();
            }
            case 47: {
                return pSSysCalendarBase.isPSDEIdDirty();
            }
            case 48: {
                return pSSysCalendarBase.isPSDENameDirty();
            }
            case 49: {
                return pSSysCalendarBase.isPSModuleIdDirty();
            }
            case 50: {
                return pSSysCalendarBase.isPSModuleNameDirty();
            }
            case 51: {
                return pSSysCalendarBase.isPSSysAppIdDirty();
            }
            case 52: {
                return pSSysCalendarBase.isPSSysAppNameDirty();
            }
            case 53: {
                return pSSysCalendarBase.isPSSysCalendarIdDirty();
            }
            case 54: {
                return pSSysCalendarBase.isPSSysCalendarNameDirty();
            }
            case 55: {
                return pSSysCalendarBase.isPSSysCssIdDirty();
            }
            case 56: {
                return pSSysCalendarBase.isPSSysCssNameDirty();
            }
            case 57: {
                return pSSysCalendarBase.isPSSysPFPluginIdDirty();
            }
            case 58: {
                return pSSysCalendarBase.isPSSysPFPluginNameDirty();
            }
            case 59: {
                return pSSysCalendarBase.isPSSystemIdDirty();
            }
            case 60: {
                return pSSysCalendarBase.isPSSystemNameDirty();
            }
            case 61: {
                return pSSysCalendarBase.isPSViewMsgGroupIdDirty();
            }
            case 62: {
                return pSSysCalendarBase.isPSViewMsgGroupNameDirty();
            }
            case 63: {
                return pSSysCalendarBase.isQuickPSDEToolbarIdDirty();
            }
            case 64: {
                return pSSysCalendarBase.isQuickPSDEToolbarNameDirty();
            }
            case 65: {
                return pSSysCalendarBase.isSysAppFlagDirty();
            }
            case 66: {
                return pSSysCalendarBase.isUpdateDateDirty();
            }
            case 67: {
                return pSSysCalendarBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysCalendarBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysCalendarBase pSSysCalendarBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysCalendarBase.getBatPSDEToolbarId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"batpsdetoolbarid", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getBatPSDEToolbarId()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getBatPSDEToolbarName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"batpsdetoolbarname", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getBatPSDEToolbarName()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getBusyIndicator() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"busyindicator", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getBusyIndicator()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getCalendarStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"calendarstyle", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getCalendarStyle()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getCalendarTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"calendartag", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getCalendarTag()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getCalendarTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"calendartag2", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getCalendarTag2()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getEmptyText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"emptytext", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getEmptyText()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getEmptyTextPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"emptytextpslanresid", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getEmptyTextPSLanResId()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getEmptyTextPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"emptytextpslanresname", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getEmptyTextPSLanResName()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getEnableEdit() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableedit", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getEnableEdit()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getGanttFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ganttflag", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getGanttFlag()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getGanttPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ganttpssyspfpluginid", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getGanttPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getGanttPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ganttpssyspfpluginname", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getGanttPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getGanttStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ganttstyle", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getGanttStyle()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getGroupHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"groupheight", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getGroupHeight()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getGroupLayout() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouplayout", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getGroupLayout()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getGroupMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"groupmode", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getGroupMode()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getGroupPSCodeListId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouppscodelistid", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getGroupPSCodeListId()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getGroupPSCodeListName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouppscodelistname", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getGroupPSCodeListName()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getGroupPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouppsdefid", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getGroupPSDEFId()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getGroupPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouppsdefname", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getGroupPSDEFName()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getGroupPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouppssyscssid", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getGroupPSSysCssId()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getGroupPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouppssyscssname", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getGroupPSSysCssName()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getGroupPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouppssyspfpluginid", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getGroupPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getGroupPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouppssyspfpluginname", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getGroupPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getGroupStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"groupstyle", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getGroupStyle()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getGroupTextPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouptextpsdefid", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getGroupTextPSDEFId()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getGroupTextPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouptextpsdefname", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getGroupTextPSDEFName()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getGroupWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"groupwidth", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getGroupWidth()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getLogicName()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getNavViewHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewheight", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getNavViewHeight()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getNavViewMaxHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewmaxheight", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getNavViewMaxHeight()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getNavViewMaxWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewmaxwidth", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getNavViewMaxWidth()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getNavViewMinHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewminheight", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getNavViewMinHeight()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getNavViewMinWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewminwidth", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getNavViewMinWidth()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getNavViewPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewpos", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getNavViewPos()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getNavViewShowMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewshowmode", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getNavViewShowMode()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getNavViewWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewwidth", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getNavViewWidth()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getPSCtrlLogicGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrllogicgroupid", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getPSCtrlLogicGroupId()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getPSCtrlLogicGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrllogicgroupname", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getPSCtrlLogicGroupName()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getPSCtrlMsgId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrlmsgid", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getPSCtrlMsgId()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getPSCtrlMsgName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrlmsgname", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getPSCtrlMsgName()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getPSSysCalendarId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscalendarid", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getPSSysCalendarId()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getPSSysCalendarName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscalendarname", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getPSSysCalendarName()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssid", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getPSSysCssId()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssname", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getPSSysCssName()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getPSViewMsgGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewmsggroupid", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getPSViewMsgGroupId()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getPSViewMsgGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewmsggroupname", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getPSViewMsgGroupName()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getQuickPSDEToolbarId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"quickpsdetoolbarid", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getQuickPSDEToolbarId()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getQuickPSDEToolbarName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"quickpsdetoolbarname", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getQuickPSDEToolbarName()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getSysAppFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sysappflag", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getSysAppFlag()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysCalendarBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysCalendarBase.getJSONValue((Object)pSSysCalendarBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysCalendarBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysCalendarBase pSSysCalendarBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysCalendarBase.getBatPSDEToolbarId() != null) {
            object = pSSysCalendarBase.getBatPSDEToolbarId();
            xmlNode.setAttribute(FIELD_BATPSDETOOLBARID, (String)(object == null ? "" : object));
        }
        if (bl || pSSysCalendarBase.getBatPSDEToolbarName() != null) {
            object = pSSysCalendarBase.getBatPSDEToolbarName();
            xmlNode.setAttribute(FIELD_BATPSDETOOLBARNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarBase.getBusyIndicator() != null) {
            object = pSSysCalendarBase.getBusyIndicator();
            xmlNode.setAttribute(FIELD_BUSYINDICATOR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysCalendarBase.getCalendarStyle() != null) {
            object = pSSysCalendarBase.getCalendarStyle();
            xmlNode.setAttribute(FIELD_CALENDARSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarBase.getCalendarTag() != null) {
            object = pSSysCalendarBase.getCalendarTag();
            xmlNode.setAttribute(FIELD_CALENDARTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarBase.getCalendarTag2() != null) {
            object = pSSysCalendarBase.getCalendarTag2();
            xmlNode.setAttribute(FIELD_CALENDARTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarBase.getCodeName() != null) {
            object = pSSysCalendarBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarBase.getCreateDate() != null) {
            object = pSSysCalendarBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysCalendarBase.getCreateMan() != null) {
            object = pSSysCalendarBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarBase.getEmptyText() != null) {
            object = pSSysCalendarBase.getEmptyText();
            xmlNode.setAttribute(FIELD_EMPTYTEXT, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarBase.getEmptyTextPSLanResId() != null) {
            object = pSSysCalendarBase.getEmptyTextPSLanResId();
            xmlNode.setAttribute(FIELD_EMPTYTEXTPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarBase.getEmptyTextPSLanResName() != null) {
            object = pSSysCalendarBase.getEmptyTextPSLanResName();
            xmlNode.setAttribute(FIELD_EMPTYTEXTPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarBase.getEnableEdit() != null) {
            object = pSSysCalendarBase.getEnableEdit();
            xmlNode.setAttribute(FIELD_ENABLEEDIT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysCalendarBase.getGanttFlag() != null) {
            object = pSSysCalendarBase.getGanttFlag();
            xmlNode.setAttribute(FIELD_GANTTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysCalendarBase.getGanttPSSysPFPluginId() != null) {
            object = pSSysCalendarBase.getGanttPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_GANTTPSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarBase.getGanttPSSysPFPluginName() != null) {
            object = pSSysCalendarBase.getGanttPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_GANTTPSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarBase.getGanttStyle() != null) {
            object = pSSysCalendarBase.getGanttStyle();
            xmlNode.setAttribute(FIELD_GANTTSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarBase.getGroupHeight() != null) {
            object = pSSysCalendarBase.getGroupHeight();
            xmlNode.setAttribute(FIELD_GROUPHEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysCalendarBase.getGroupLayout() != null) {
            object = pSSysCalendarBase.getGroupLayout();
            xmlNode.setAttribute(FIELD_GROUPLAYOUT, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarBase.getGroupMode() != null) {
            object = pSSysCalendarBase.getGroupMode();
            xmlNode.setAttribute(FIELD_GROUPMODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarBase.getGroupPSCodeListId() != null) {
            object = pSSysCalendarBase.getGroupPSCodeListId();
            xmlNode.setAttribute(FIELD_GROUPPSCODELISTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarBase.getGroupPSCodeListName() != null) {
            object = pSSysCalendarBase.getGroupPSCodeListName();
            xmlNode.setAttribute(FIELD_GROUPPSCODELISTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarBase.getGroupPSDEFId() != null) {
            object = pSSysCalendarBase.getGroupPSDEFId();
            xmlNode.setAttribute(FIELD_GROUPPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarBase.getGroupPSDEFName() != null) {
            object = pSSysCalendarBase.getGroupPSDEFName();
            xmlNode.setAttribute(FIELD_GROUPPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarBase.getGroupPSSysCssId() != null) {
            object = pSSysCalendarBase.getGroupPSSysCssId();
            xmlNode.setAttribute(FIELD_GROUPPSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarBase.getGroupPSSysCssName() != null) {
            object = pSSysCalendarBase.getGroupPSSysCssName();
            xmlNode.setAttribute(FIELD_GROUPPSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarBase.getGroupPSSysPFPluginId() != null) {
            object = pSSysCalendarBase.getGroupPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_GROUPPSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarBase.getGroupPSSysPFPluginName() != null) {
            object = pSSysCalendarBase.getGroupPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_GROUPPSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarBase.getGroupStyle() != null) {
            object = pSSysCalendarBase.getGroupStyle();
            xmlNode.setAttribute(FIELD_GROUPSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarBase.getGroupTextPSDEFId() != null) {
            object = pSSysCalendarBase.getGroupTextPSDEFId();
            xmlNode.setAttribute(FIELD_GROUPTEXTPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarBase.getGroupTextPSDEFName() != null) {
            object = pSSysCalendarBase.getGroupTextPSDEFName();
            xmlNode.setAttribute(FIELD_GROUPTEXTPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarBase.getGroupWidth() != null) {
            object = pSSysCalendarBase.getGroupWidth();
            xmlNode.setAttribute(FIELD_GROUPWIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysCalendarBase.getLockFlag() != null) {
            object = pSSysCalendarBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysCalendarBase.getLogicName() != null) {
            object = pSSysCalendarBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarBase.getMemo() != null) {
            object = pSSysCalendarBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarBase.getNavViewHeight() != null) {
            object = pSSysCalendarBase.getNavViewHeight();
            xmlNode.setAttribute(FIELD_NAVVIEWHEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysCalendarBase.getNavViewMaxHeight() != null) {
            object = pSSysCalendarBase.getNavViewMaxHeight();
            xmlNode.setAttribute(FIELD_NAVVIEWMAXHEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysCalendarBase.getNavViewMaxWidth() != null) {
            object = pSSysCalendarBase.getNavViewMaxWidth();
            xmlNode.setAttribute(FIELD_NAVVIEWMAXWIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysCalendarBase.getNavViewMinHeight() != null) {
            object = pSSysCalendarBase.getNavViewMinHeight();
            xmlNode.setAttribute(FIELD_NAVVIEWMINHEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysCalendarBase.getNavViewMinWidth() != null) {
            object = pSSysCalendarBase.getNavViewMinWidth();
            xmlNode.setAttribute(FIELD_NAVVIEWMINWIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysCalendarBase.getNavViewPos() != null) {
            object = pSSysCalendarBase.getNavViewPos();
            xmlNode.setAttribute(FIELD_NAVVIEWPOS, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarBase.getNavViewShowMode() != null) {
            object = pSSysCalendarBase.getNavViewShowMode();
            xmlNode.setAttribute(FIELD_NAVVIEWSHOWMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysCalendarBase.getNavViewWidth() != null) {
            object = pSSysCalendarBase.getNavViewWidth();
            xmlNode.setAttribute(FIELD_NAVVIEWWIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysCalendarBase.getPSCtrlLogicGroupId() != null) {
            object = pSSysCalendarBase.getPSCtrlLogicGroupId();
            xmlNode.setAttribute(FIELD_PSCTRLLOGICGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarBase.getPSCtrlLogicGroupName() != null) {
            object = pSSysCalendarBase.getPSCtrlLogicGroupName();
            xmlNode.setAttribute(FIELD_PSCTRLLOGICGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarBase.getPSCtrlMsgId() != null) {
            object = pSSysCalendarBase.getPSCtrlMsgId();
            xmlNode.setAttribute(FIELD_PSCTRLMSGID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarBase.getPSCtrlMsgName() != null) {
            object = pSSysCalendarBase.getPSCtrlMsgName();
            xmlNode.setAttribute(FIELD_PSCTRLMSGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarBase.getPSDEId() != null) {
            object = pSSysCalendarBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarBase.getPSDEName() != null) {
            object = pSSysCalendarBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarBase.getPSModuleId() != null) {
            object = pSSysCalendarBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarBase.getPSModuleName() != null) {
            object = pSSysCalendarBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarBase.getPSSysAppId() != null) {
            object = pSSysCalendarBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarBase.getPSSysAppName() != null) {
            object = pSSysCalendarBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarBase.getPSSysCalendarId() != null) {
            object = pSSysCalendarBase.getPSSysCalendarId();
            xmlNode.setAttribute(FIELD_PSSYSCALENDARID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarBase.getPSSysCalendarName() != null) {
            object = pSSysCalendarBase.getPSSysCalendarName();
            xmlNode.setAttribute(FIELD_PSSYSCALENDARNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarBase.getPSSysCssId() != null) {
            object = pSSysCalendarBase.getPSSysCssId();
            xmlNode.setAttribute(FIELD_PSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarBase.getPSSysCssName() != null) {
            object = pSSysCalendarBase.getPSSysCssName();
            xmlNode.setAttribute(FIELD_PSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarBase.getPSSysPFPluginId() != null) {
            object = pSSysCalendarBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarBase.getPSSysPFPluginName() != null) {
            object = pSSysCalendarBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarBase.getPSSystemId() != null) {
            object = pSSysCalendarBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarBase.getPSSystemName() != null) {
            object = pSSysCalendarBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarBase.getPSViewMsgGroupId() != null) {
            object = pSSysCalendarBase.getPSViewMsgGroupId();
            xmlNode.setAttribute(FIELD_PSVIEWMSGGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarBase.getPSViewMsgGroupName() != null) {
            object = pSSysCalendarBase.getPSViewMsgGroupName();
            xmlNode.setAttribute(FIELD_PSVIEWMSGGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarBase.getQuickPSDEToolbarId() != null) {
            object = pSSysCalendarBase.getQuickPSDEToolbarId();
            xmlNode.setAttribute(FIELD_QUICKPSDETOOLBARID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarBase.getQuickPSDEToolbarName() != null) {
            object = pSSysCalendarBase.getQuickPSDEToolbarName();
            xmlNode.setAttribute(FIELD_QUICKPSDETOOLBARNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarBase.getSysAppFlag() != null) {
            object = pSSysCalendarBase.getSysAppFlag();
            xmlNode.setAttribute(FIELD_SYSAPPFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysCalendarBase.getUpdateDate() != null) {
            object = pSSysCalendarBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysCalendarBase.getUpdateMan() != null) {
            object = pSSysCalendarBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysCalendarBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysCalendarBase pSSysCalendarBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysCalendarBase.isBatPSDEToolbarIdDirty() && (bl || pSSysCalendarBase.getBatPSDEToolbarId() != null)) {
            iDataObject.set(FIELD_BATPSDETOOLBARID, (Object)pSSysCalendarBase.getBatPSDEToolbarId());
        }
        if (pSSysCalendarBase.isBatPSDEToolbarNameDirty() && (bl || pSSysCalendarBase.getBatPSDEToolbarName() != null)) {
            iDataObject.set(FIELD_BATPSDETOOLBARNAME, (Object)pSSysCalendarBase.getBatPSDEToolbarName());
        }
        if (pSSysCalendarBase.isBusyIndicatorDirty() && (bl || pSSysCalendarBase.getBusyIndicator() != null)) {
            iDataObject.set(FIELD_BUSYINDICATOR, (Object)pSSysCalendarBase.getBusyIndicator());
        }
        if (pSSysCalendarBase.isCalendarStyleDirty() && (bl || pSSysCalendarBase.getCalendarStyle() != null)) {
            iDataObject.set(FIELD_CALENDARSTYLE, (Object)pSSysCalendarBase.getCalendarStyle());
        }
        if (pSSysCalendarBase.isCalendarTagDirty() && (bl || pSSysCalendarBase.getCalendarTag() != null)) {
            iDataObject.set(FIELD_CALENDARTAG, (Object)pSSysCalendarBase.getCalendarTag());
        }
        if (pSSysCalendarBase.isCalendarTag2Dirty() && (bl || pSSysCalendarBase.getCalendarTag2() != null)) {
            iDataObject.set(FIELD_CALENDARTAG2, (Object)pSSysCalendarBase.getCalendarTag2());
        }
        if (pSSysCalendarBase.isCodeNameDirty() && (bl || pSSysCalendarBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysCalendarBase.getCodeName());
        }
        if (pSSysCalendarBase.isCreateDateDirty() && (bl || pSSysCalendarBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysCalendarBase.getCreateDate());
        }
        if (pSSysCalendarBase.isCreateManDirty() && (bl || pSSysCalendarBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysCalendarBase.getCreateMan());
        }
        if (pSSysCalendarBase.isEmptyTextDirty() && (bl || pSSysCalendarBase.getEmptyText() != null)) {
            iDataObject.set(FIELD_EMPTYTEXT, (Object)pSSysCalendarBase.getEmptyText());
        }
        if (pSSysCalendarBase.isEmptyTextPSLanResIdDirty() && (bl || pSSysCalendarBase.getEmptyTextPSLanResId() != null)) {
            iDataObject.set(FIELD_EMPTYTEXTPSLANRESID, (Object)pSSysCalendarBase.getEmptyTextPSLanResId());
        }
        if (pSSysCalendarBase.isEmptyTextPSLanResNameDirty() && (bl || pSSysCalendarBase.getEmptyTextPSLanResName() != null)) {
            iDataObject.set(FIELD_EMPTYTEXTPSLANRESNAME, (Object)pSSysCalendarBase.getEmptyTextPSLanResName());
        }
        if (pSSysCalendarBase.isEnableEditDirty() && (bl || pSSysCalendarBase.getEnableEdit() != null)) {
            iDataObject.set(FIELD_ENABLEEDIT, (Object)pSSysCalendarBase.getEnableEdit());
        }
        if (pSSysCalendarBase.isGanttFlagDirty() && (bl || pSSysCalendarBase.getGanttFlag() != null)) {
            iDataObject.set(FIELD_GANTTFLAG, (Object)pSSysCalendarBase.getGanttFlag());
        }
        if (pSSysCalendarBase.isGanttPSSysPFPluginIdDirty() && (bl || pSSysCalendarBase.getGanttPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_GANTTPSSYSPFPLUGINID, (Object)pSSysCalendarBase.getGanttPSSysPFPluginId());
        }
        if (pSSysCalendarBase.isGanttPSSysPFPluginNameDirty() && (bl || pSSysCalendarBase.getGanttPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_GANTTPSSYSPFPLUGINNAME, (Object)pSSysCalendarBase.getGanttPSSysPFPluginName());
        }
        if (pSSysCalendarBase.isGanttStyleDirty() && (bl || pSSysCalendarBase.getGanttStyle() != null)) {
            iDataObject.set(FIELD_GANTTSTYLE, (Object)pSSysCalendarBase.getGanttStyle());
        }
        if (pSSysCalendarBase.isGroupHeightDirty() && (bl || pSSysCalendarBase.getGroupHeight() != null)) {
            iDataObject.set(FIELD_GROUPHEIGHT, (Object)pSSysCalendarBase.getGroupHeight());
        }
        if (pSSysCalendarBase.isGroupLayoutDirty() && (bl || pSSysCalendarBase.getGroupLayout() != null)) {
            iDataObject.set(FIELD_GROUPLAYOUT, (Object)pSSysCalendarBase.getGroupLayout());
        }
        if (pSSysCalendarBase.isGroupModeDirty() && (bl || pSSysCalendarBase.getGroupMode() != null)) {
            iDataObject.set(FIELD_GROUPMODE, (Object)pSSysCalendarBase.getGroupMode());
        }
        if (pSSysCalendarBase.isGroupPSCodeListIdDirty() && (bl || pSSysCalendarBase.getGroupPSCodeListId() != null)) {
            iDataObject.set(FIELD_GROUPPSCODELISTID, (Object)pSSysCalendarBase.getGroupPSCodeListId());
        }
        if (pSSysCalendarBase.isGroupPSCodeListNameDirty() && (bl || pSSysCalendarBase.getGroupPSCodeListName() != null)) {
            iDataObject.set(FIELD_GROUPPSCODELISTNAME, (Object)pSSysCalendarBase.getGroupPSCodeListName());
        }
        if (pSSysCalendarBase.isGroupPSDEFIdDirty() && (bl || pSSysCalendarBase.getGroupPSDEFId() != null)) {
            iDataObject.set(FIELD_GROUPPSDEFID, (Object)pSSysCalendarBase.getGroupPSDEFId());
        }
        if (pSSysCalendarBase.isGroupPSDEFNameDirty() && (bl || pSSysCalendarBase.getGroupPSDEFName() != null)) {
            iDataObject.set(FIELD_GROUPPSDEFNAME, (Object)pSSysCalendarBase.getGroupPSDEFName());
        }
        if (pSSysCalendarBase.isGroupPSSysCssIdDirty() && (bl || pSSysCalendarBase.getGroupPSSysCssId() != null)) {
            iDataObject.set(FIELD_GROUPPSSYSCSSID, (Object)pSSysCalendarBase.getGroupPSSysCssId());
        }
        if (pSSysCalendarBase.isGroupPSSysCssNameDirty() && (bl || pSSysCalendarBase.getGroupPSSysCssName() != null)) {
            iDataObject.set(FIELD_GROUPPSSYSCSSNAME, (Object)pSSysCalendarBase.getGroupPSSysCssName());
        }
        if (pSSysCalendarBase.isGroupPSSysPFPluginIdDirty() && (bl || pSSysCalendarBase.getGroupPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_GROUPPSSYSPFPLUGINID, (Object)pSSysCalendarBase.getGroupPSSysPFPluginId());
        }
        if (pSSysCalendarBase.isGroupPSSysPFPluginNameDirty() && (bl || pSSysCalendarBase.getGroupPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_GROUPPSSYSPFPLUGINNAME, (Object)pSSysCalendarBase.getGroupPSSysPFPluginName());
        }
        if (pSSysCalendarBase.isGroupStyleDirty() && (bl || pSSysCalendarBase.getGroupStyle() != null)) {
            iDataObject.set(FIELD_GROUPSTYLE, (Object)pSSysCalendarBase.getGroupStyle());
        }
        if (pSSysCalendarBase.isGroupTextPSDEFIdDirty() && (bl || pSSysCalendarBase.getGroupTextPSDEFId() != null)) {
            iDataObject.set(FIELD_GROUPTEXTPSDEFID, (Object)pSSysCalendarBase.getGroupTextPSDEFId());
        }
        if (pSSysCalendarBase.isGroupTextPSDEFNameDirty() && (bl || pSSysCalendarBase.getGroupTextPSDEFName() != null)) {
            iDataObject.set(FIELD_GROUPTEXTPSDEFNAME, (Object)pSSysCalendarBase.getGroupTextPSDEFName());
        }
        if (pSSysCalendarBase.isGroupWidthDirty() && (bl || pSSysCalendarBase.getGroupWidth() != null)) {
            iDataObject.set(FIELD_GROUPWIDTH, (Object)pSSysCalendarBase.getGroupWidth());
        }
        if (pSSysCalendarBase.isLockFlagDirty() && (bl || pSSysCalendarBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSSysCalendarBase.getLockFlag());
        }
        if (pSSysCalendarBase.isLogicNameDirty() && (bl || pSSysCalendarBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSSysCalendarBase.getLogicName());
        }
        if (pSSysCalendarBase.isMemoDirty() && (bl || pSSysCalendarBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysCalendarBase.getMemo());
        }
        if (pSSysCalendarBase.isNavViewHeightDirty() && (bl || pSSysCalendarBase.getNavViewHeight() != null)) {
            iDataObject.set(FIELD_NAVVIEWHEIGHT, (Object)pSSysCalendarBase.getNavViewHeight());
        }
        if (pSSysCalendarBase.isNavViewMaxHeightDirty() && (bl || pSSysCalendarBase.getNavViewMaxHeight() != null)) {
            iDataObject.set(FIELD_NAVVIEWMAXHEIGHT, (Object)pSSysCalendarBase.getNavViewMaxHeight());
        }
        if (pSSysCalendarBase.isNavViewMaxWidthDirty() && (bl || pSSysCalendarBase.getNavViewMaxWidth() != null)) {
            iDataObject.set(FIELD_NAVVIEWMAXWIDTH, (Object)pSSysCalendarBase.getNavViewMaxWidth());
        }
        if (pSSysCalendarBase.isNavViewMinHeightDirty() && (bl || pSSysCalendarBase.getNavViewMinHeight() != null)) {
            iDataObject.set(FIELD_NAVVIEWMINHEIGHT, (Object)pSSysCalendarBase.getNavViewMinHeight());
        }
        if (pSSysCalendarBase.isNavViewMinWidthDirty() && (bl || pSSysCalendarBase.getNavViewMinWidth() != null)) {
            iDataObject.set(FIELD_NAVVIEWMINWIDTH, (Object)pSSysCalendarBase.getNavViewMinWidth());
        }
        if (pSSysCalendarBase.isNavViewPosDirty() && (bl || pSSysCalendarBase.getNavViewPos() != null)) {
            iDataObject.set(FIELD_NAVVIEWPOS, (Object)pSSysCalendarBase.getNavViewPos());
        }
        if (pSSysCalendarBase.isNavViewShowModeDirty() && (bl || pSSysCalendarBase.getNavViewShowMode() != null)) {
            iDataObject.set(FIELD_NAVVIEWSHOWMODE, (Object)pSSysCalendarBase.getNavViewShowMode());
        }
        if (pSSysCalendarBase.isNavViewWidthDirty() && (bl || pSSysCalendarBase.getNavViewWidth() != null)) {
            iDataObject.set(FIELD_NAVVIEWWIDTH, (Object)pSSysCalendarBase.getNavViewWidth());
        }
        if (pSSysCalendarBase.isPSCtrlLogicGroupIdDirty() && (bl || pSSysCalendarBase.getPSCtrlLogicGroupId() != null)) {
            iDataObject.set(FIELD_PSCTRLLOGICGROUPID, (Object)pSSysCalendarBase.getPSCtrlLogicGroupId());
        }
        if (pSSysCalendarBase.isPSCtrlLogicGroupNameDirty() && (bl || pSSysCalendarBase.getPSCtrlLogicGroupName() != null)) {
            iDataObject.set(FIELD_PSCTRLLOGICGROUPNAME, (Object)pSSysCalendarBase.getPSCtrlLogicGroupName());
        }
        if (pSSysCalendarBase.isPSCtrlMsgIdDirty() && (bl || pSSysCalendarBase.getPSCtrlMsgId() != null)) {
            iDataObject.set(FIELD_PSCTRLMSGID, (Object)pSSysCalendarBase.getPSCtrlMsgId());
        }
        if (pSSysCalendarBase.isPSCtrlMsgNameDirty() && (bl || pSSysCalendarBase.getPSCtrlMsgName() != null)) {
            iDataObject.set(FIELD_PSCTRLMSGNAME, (Object)pSSysCalendarBase.getPSCtrlMsgName());
        }
        if (pSSysCalendarBase.isPSDEIdDirty() && (bl || pSSysCalendarBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysCalendarBase.getPSDEId());
        }
        if (pSSysCalendarBase.isPSDENameDirty() && (bl || pSSysCalendarBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSSysCalendarBase.getPSDEName());
        }
        if (pSSysCalendarBase.isPSModuleIdDirty() && (bl || pSSysCalendarBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysCalendarBase.getPSModuleId());
        }
        if (pSSysCalendarBase.isPSModuleNameDirty() && (bl || pSSysCalendarBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysCalendarBase.getPSModuleName());
        }
        if (pSSysCalendarBase.isPSSysAppIdDirty() && (bl || pSSysCalendarBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSSysCalendarBase.getPSSysAppId());
        }
        if (pSSysCalendarBase.isPSSysAppNameDirty() && (bl || pSSysCalendarBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSSysCalendarBase.getPSSysAppName());
        }
        if (pSSysCalendarBase.isPSSysCalendarIdDirty() && (bl || pSSysCalendarBase.getPSSysCalendarId() != null)) {
            iDataObject.set(FIELD_PSSYSCALENDARID, (Object)pSSysCalendarBase.getPSSysCalendarId());
        }
        if (pSSysCalendarBase.isPSSysCalendarNameDirty() && (bl || pSSysCalendarBase.getPSSysCalendarName() != null)) {
            iDataObject.set(FIELD_PSSYSCALENDARNAME, (Object)pSSysCalendarBase.getPSSysCalendarName());
        }
        if (pSSysCalendarBase.isPSSysCssIdDirty() && (bl || pSSysCalendarBase.getPSSysCssId() != null)) {
            iDataObject.set(FIELD_PSSYSCSSID, (Object)pSSysCalendarBase.getPSSysCssId());
        }
        if (pSSysCalendarBase.isPSSysCssNameDirty() && (bl || pSSysCalendarBase.getPSSysCssName() != null)) {
            iDataObject.set(FIELD_PSSYSCSSNAME, (Object)pSSysCalendarBase.getPSSysCssName());
        }
        if (pSSysCalendarBase.isPSSysPFPluginIdDirty() && (bl || pSSysCalendarBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSSysCalendarBase.getPSSysPFPluginId());
        }
        if (pSSysCalendarBase.isPSSysPFPluginNameDirty() && (bl || pSSysCalendarBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSSysCalendarBase.getPSSysPFPluginName());
        }
        if (pSSysCalendarBase.isPSSystemIdDirty() && (bl || pSSysCalendarBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysCalendarBase.getPSSystemId());
        }
        if (pSSysCalendarBase.isPSSystemNameDirty() && (bl || pSSysCalendarBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysCalendarBase.getPSSystemName());
        }
        if (pSSysCalendarBase.isPSViewMsgGroupIdDirty() && (bl || pSSysCalendarBase.getPSViewMsgGroupId() != null)) {
            iDataObject.set(FIELD_PSVIEWMSGGROUPID, (Object)pSSysCalendarBase.getPSViewMsgGroupId());
        }
        if (pSSysCalendarBase.isPSViewMsgGroupNameDirty() && (bl || pSSysCalendarBase.getPSViewMsgGroupName() != null)) {
            iDataObject.set(FIELD_PSVIEWMSGGROUPNAME, (Object)pSSysCalendarBase.getPSViewMsgGroupName());
        }
        if (pSSysCalendarBase.isQuickPSDEToolbarIdDirty() && (bl || pSSysCalendarBase.getQuickPSDEToolbarId() != null)) {
            iDataObject.set(FIELD_QUICKPSDETOOLBARID, (Object)pSSysCalendarBase.getQuickPSDEToolbarId());
        }
        if (pSSysCalendarBase.isQuickPSDEToolbarNameDirty() && (bl || pSSysCalendarBase.getQuickPSDEToolbarName() != null)) {
            iDataObject.set(FIELD_QUICKPSDETOOLBARNAME, (Object)pSSysCalendarBase.getQuickPSDEToolbarName());
        }
        if (pSSysCalendarBase.isSysAppFlagDirty() && (bl || pSSysCalendarBase.getSysAppFlag() != null)) {
            iDataObject.set(FIELD_SYSAPPFLAG, (Object)pSSysCalendarBase.getSysAppFlag());
        }
        if (pSSysCalendarBase.isUpdateDateDirty() && (bl || pSSysCalendarBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysCalendarBase.getUpdateDate());
        }
        if (pSSysCalendarBase.isUpdateManDirty() && (bl || pSSysCalendarBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysCalendarBase.getUpdateMan());
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
        return PSSysCalendarBase.remove(this, n);
    }

    private static boolean remove(PSSysCalendarBase pSSysCalendarBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysCalendarBase.resetBatPSDEToolbarId();
                return true;
            }
            case 1: {
                pSSysCalendarBase.resetBatPSDEToolbarName();
                return true;
            }
            case 2: {
                pSSysCalendarBase.resetBusyIndicator();
                return true;
            }
            case 3: {
                pSSysCalendarBase.resetCalendarStyle();
                return true;
            }
            case 4: {
                pSSysCalendarBase.resetCalendarTag();
                return true;
            }
            case 5: {
                pSSysCalendarBase.resetCalendarTag2();
                return true;
            }
            case 6: {
                pSSysCalendarBase.resetCodeName();
                return true;
            }
            case 7: {
                pSSysCalendarBase.resetCreateDate();
                return true;
            }
            case 8: {
                pSSysCalendarBase.resetCreateMan();
                return true;
            }
            case 9: {
                pSSysCalendarBase.resetEmptyText();
                return true;
            }
            case 10: {
                pSSysCalendarBase.resetEmptyTextPSLanResId();
                return true;
            }
            case 11: {
                pSSysCalendarBase.resetEmptyTextPSLanResName();
                return true;
            }
            case 12: {
                pSSysCalendarBase.resetEnableEdit();
                return true;
            }
            case 13: {
                pSSysCalendarBase.resetGanttFlag();
                return true;
            }
            case 14: {
                pSSysCalendarBase.resetGanttPSSysPFPluginId();
                return true;
            }
            case 15: {
                pSSysCalendarBase.resetGanttPSSysPFPluginName();
                return true;
            }
            case 16: {
                pSSysCalendarBase.resetGanttStyle();
                return true;
            }
            case 17: {
                pSSysCalendarBase.resetGroupHeight();
                return true;
            }
            case 18: {
                pSSysCalendarBase.resetGroupLayout();
                return true;
            }
            case 19: {
                pSSysCalendarBase.resetGroupMode();
                return true;
            }
            case 20: {
                pSSysCalendarBase.resetGroupPSCodeListId();
                return true;
            }
            case 21: {
                pSSysCalendarBase.resetGroupPSCodeListName();
                return true;
            }
            case 22: {
                pSSysCalendarBase.resetGroupPSDEFId();
                return true;
            }
            case 23: {
                pSSysCalendarBase.resetGroupPSDEFName();
                return true;
            }
            case 24: {
                pSSysCalendarBase.resetGroupPSSysCssId();
                return true;
            }
            case 25: {
                pSSysCalendarBase.resetGroupPSSysCssName();
                return true;
            }
            case 26: {
                pSSysCalendarBase.resetGroupPSSysPFPluginId();
                return true;
            }
            case 27: {
                pSSysCalendarBase.resetGroupPSSysPFPluginName();
                return true;
            }
            case 28: {
                pSSysCalendarBase.resetGroupStyle();
                return true;
            }
            case 29: {
                pSSysCalendarBase.resetGroupTextPSDEFId();
                return true;
            }
            case 30: {
                pSSysCalendarBase.resetGroupTextPSDEFName();
                return true;
            }
            case 31: {
                pSSysCalendarBase.resetGroupWidth();
                return true;
            }
            case 32: {
                pSSysCalendarBase.resetLockFlag();
                return true;
            }
            case 33: {
                pSSysCalendarBase.resetLogicName();
                return true;
            }
            case 34: {
                pSSysCalendarBase.resetMemo();
                return true;
            }
            case 35: {
                pSSysCalendarBase.resetNavViewHeight();
                return true;
            }
            case 36: {
                pSSysCalendarBase.resetNavViewMaxHeight();
                return true;
            }
            case 37: {
                pSSysCalendarBase.resetNavViewMaxWidth();
                return true;
            }
            case 38: {
                pSSysCalendarBase.resetNavViewMinHeight();
                return true;
            }
            case 39: {
                pSSysCalendarBase.resetNavViewMinWidth();
                return true;
            }
            case 40: {
                pSSysCalendarBase.resetNavViewPos();
                return true;
            }
            case 41: {
                pSSysCalendarBase.resetNavViewShowMode();
                return true;
            }
            case 42: {
                pSSysCalendarBase.resetNavViewWidth();
                return true;
            }
            case 43: {
                pSSysCalendarBase.resetPSCtrlLogicGroupId();
                return true;
            }
            case 44: {
                pSSysCalendarBase.resetPSCtrlLogicGroupName();
                return true;
            }
            case 45: {
                pSSysCalendarBase.resetPSCtrlMsgId();
                return true;
            }
            case 46: {
                pSSysCalendarBase.resetPSCtrlMsgName();
                return true;
            }
            case 47: {
                pSSysCalendarBase.resetPSDEId();
                return true;
            }
            case 48: {
                pSSysCalendarBase.resetPSDEName();
                return true;
            }
            case 49: {
                pSSysCalendarBase.resetPSModuleId();
                return true;
            }
            case 50: {
                pSSysCalendarBase.resetPSModuleName();
                return true;
            }
            case 51: {
                pSSysCalendarBase.resetPSSysAppId();
                return true;
            }
            case 52: {
                pSSysCalendarBase.resetPSSysAppName();
                return true;
            }
            case 53: {
                pSSysCalendarBase.resetPSSysCalendarId();
                return true;
            }
            case 54: {
                pSSysCalendarBase.resetPSSysCalendarName();
                return true;
            }
            case 55: {
                pSSysCalendarBase.resetPSSysCssId();
                return true;
            }
            case 56: {
                pSSysCalendarBase.resetPSSysCssName();
                return true;
            }
            case 57: {
                pSSysCalendarBase.resetPSSysPFPluginId();
                return true;
            }
            case 58: {
                pSSysCalendarBase.resetPSSysPFPluginName();
                return true;
            }
            case 59: {
                pSSysCalendarBase.resetPSSystemId();
                return true;
            }
            case 60: {
                pSSysCalendarBase.resetPSSystemName();
                return true;
            }
            case 61: {
                pSSysCalendarBase.resetPSViewMsgGroupId();
                return true;
            }
            case 62: {
                pSSysCalendarBase.resetPSViewMsgGroupName();
                return true;
            }
            case 63: {
                pSSysCalendarBase.resetQuickPSDEToolbarId();
                return true;
            }
            case 64: {
                pSSysCalendarBase.resetQuickPSDEToolbarName();
                return true;
            }
            case 65: {
                pSSysCalendarBase.resetSysAppFlag();
                return true;
            }
            case 66: {
                pSSysCalendarBase.resetUpdateDate();
                return true;
            }
            case 67: {
                pSSysCalendarBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCodeList getGroupPSCodeList() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupPSCodeList();
        }
        if (this.getGroupPSCodeListId() == null) {
            return null;
        }
        Integer n = this.objGroupPSCodeListLock;
        synchronized (n) {
            if (this.grouppscodelist != null && DataTypeHelper.compare((int)25, (Object)this.getGroupPSCodeListId(), (Object)this.grouppscodelist.getPSCodeListId()) != 0L) {
                this.grouppscodelist = null;
            }
            if (this.grouppscodelist == null) {
                PSCodeList pSCodeList = new PSCodeList();
                pSCodeList.setPSCodeListId(this.getGroupPSCodeListId());
                PSCodeListService pSCodeListService = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.getSessionFactory());
                pSCodeListService.autoGet((IEntity)pSCodeList);
                this.grouppscodelist = pSCodeList;
            }
            return this.grouppscodelist;
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
                pSCtrlMsgService.autoGet((IEntity)pSCtrlMsg);
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
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
                this.psde = pSDataEntity;
            }
            return this.psde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getGroupPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupPSDEF();
        }
        if (this.getGroupPSDEFId() == null) {
            return null;
        }
        Integer n = this.objGroupPSDEFLock;
        synchronized (n) {
            if (this.grouppsdef != null && DataTypeHelper.compare((int)25, (Object)this.getGroupPSDEFId(), (Object)this.grouppsdef.getPSDEFieldId()) != 0L) {
                this.grouppsdef = null;
            }
            if (this.grouppsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getGroupPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.grouppsdef = pSDEField;
            }
            return this.grouppsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getGroupTextPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupTextPSDEF();
        }
        if (this.getGroupTextPSDEFId() == null) {
            return null;
        }
        Integer n = this.objGroupTextPSDEFLock;
        synchronized (n) {
            if (this.grouptextpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getGroupTextPSDEFId(), (Object)this.grouptextpsdef.getPSDEFieldId()) != 0L) {
                this.grouptextpsdef = null;
            }
            if (this.grouptextpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getGroupTextPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.grouptextpsdef = pSDEField;
            }
            return this.grouptextpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEToolbar getBatPSDEToolbar() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBatPSDEToolbar();
        }
        if (this.getBatPSDEToolbarId() == null) {
            return null;
        }
        Integer n = this.objBatPSDEToolbarLock;
        synchronized (n) {
            if (this.batpsdetoolbar != null && DataTypeHelper.compare((int)25, (Object)this.getBatPSDEToolbarId(), (Object)this.batpsdetoolbar.getPSDEToolbarId()) != 0L) {
                this.batpsdetoolbar = null;
            }
            if (this.batpsdetoolbar == null) {
                PSDEToolbar pSDEToolbar = new PSDEToolbar();
                pSDEToolbar.setPSDEToolbarId(this.getBatPSDEToolbarId());
                PSDEToolbarService pSDEToolbarService = (PSDEToolbarService)ServiceGlobal.getService(PSDEToolbarService.class, (SessionFactory)this.getSessionFactory());
                pSDEToolbarService.autoGet((IEntity)pSDEToolbar);
                this.batpsdetoolbar = pSDEToolbar;
            }
            return this.batpsdetoolbar;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEToolbar getQuickPSDEToolbar() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getQuickPSDEToolbar();
        }
        if (this.getQuickPSDEToolbarId() == null) {
            return null;
        }
        Integer n = this.objQuickPSDEToolbarLock;
        synchronized (n) {
            if (this.quickpsdetoolbar != null && DataTypeHelper.compare((int)25, (Object)this.getQuickPSDEToolbarId(), (Object)this.quickpsdetoolbar.getPSDEToolbarId()) != 0L) {
                this.quickpsdetoolbar = null;
            }
            if (this.quickpsdetoolbar == null) {
                PSDEToolbar pSDEToolbar = new PSDEToolbar();
                pSDEToolbar.setPSDEToolbarId(this.getQuickPSDEToolbarId());
                PSDEToolbarService pSDEToolbarService = (PSDEToolbarService)ServiceGlobal.getService(PSDEToolbarService.class, (SessionFactory)this.getSessionFactory());
                pSDEToolbarService.autoGet((IEntity)pSDEToolbar);
                this.quickpsdetoolbar = pSDEToolbar;
            }
            return this.quickpsdetoolbar;
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
    public PSSysCss getGroupPSSysCss() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupPSSysCss();
        }
        if (this.getGroupPSSysCssId() == null) {
            return null;
        }
        Integer n = this.objGroupPSSysCssLock;
        synchronized (n) {
            if (this.grouppssyscss != null && DataTypeHelper.compare((int)25, (Object)this.getGroupPSSysCssId(), (Object)this.grouppssyscss.getPSSysCssId()) != 0L) {
                this.grouppssyscss = null;
            }
            if (this.grouppssyscss == null) {
                PSSysCss pSSysCss = new PSSysCss();
                pSSysCss.setPSSysCssId(this.getGroupPSSysCssId());
                PSSysCssService pSSysCssService = (PSSysCssService)ServiceGlobal.getService(PSSysCssService.class, (SessionFactory)this.getSessionFactory());
                pSSysCssService.autoGet((IEntity)pSSysCss);
                this.grouppssyscss = pSSysCss;
            }
            return this.grouppssyscss;
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
    public PSSysPFPlugin getGanttPSSysPFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGanttPSSysPFPlugin();
        }
        if (this.getGanttPSSysPFPluginId() == null) {
            return null;
        }
        Integer n = this.objGanttPSSysPFPluginLock;
        synchronized (n) {
            if (this.ganttpssyspfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getGanttPSSysPFPluginId(), (Object)this.ganttpssyspfplugin.getPSSysPFPluginId()) != 0L) {
                this.ganttpssyspfplugin = null;
            }
            if (this.ganttpssyspfplugin == null) {
                PSSysPFPlugin pSSysPFPlugin = new PSSysPFPlugin();
                pSSysPFPlugin.setPSSysPFPluginId(this.getGanttPSSysPFPluginId());
                PSSysPFPluginService pSSysPFPluginService = (PSSysPFPluginService)ServiceGlobal.getService(PSSysPFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysPFPluginService.autoGet((IEntity)pSSysPFPlugin);
                this.ganttpssyspfplugin = pSSysPFPlugin;
            }
            return this.ganttpssyspfplugin;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysPFPlugin getGroupPSSysPFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupPSSysPFPlugin();
        }
        if (this.getGroupPSSysPFPluginId() == null) {
            return null;
        }
        Integer n = this.objGroupPSSysPFPluginLock;
        synchronized (n) {
            if (this.grouppssyspfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getGroupPSSysPFPluginId(), (Object)this.grouppssyspfplugin.getPSSysPFPluginId()) != 0L) {
                this.grouppssyspfplugin = null;
            }
            if (this.grouppssyspfplugin == null) {
                PSSysPFPlugin pSSysPFPlugin = new PSSysPFPlugin();
                pSSysPFPlugin.setPSSysPFPluginId(this.getGroupPSSysPFPluginId());
                PSSysPFPluginService pSSysPFPluginService = (PSSysPFPluginService)ServiceGlobal.getService(PSSysPFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysPFPluginService.autoGet((IEntity)pSSysPFPlugin);
                this.grouppssyspfplugin = pSSysPFPlugin;
            }
            return this.grouppssyspfplugin;
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
    public ArrayList<PSSysCalendarItem> getPSSysCalendarItems() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCalendarItems();
        }
        if (this.getPSSysCalendarId() == null) {
            return null;
        }
        PSSysCalendarService pSSysCalendarService = (PSSysCalendarService)ServiceGlobal.getService(PSSysCalendarService.class, (SessionFactory)this.getSessionFactory());
        PSSysCalendarItemService pSSysCalendarItemService = (PSSysCalendarItemService)ServiceGlobal.getService(PSSysCalendarItemService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysCalendarItemsLock;
        synchronized (n) {
            if (this.pssyscalendaritems == null) {
                this.pssyscalendaritems = pSSysCalendarService.isTempData((IEntity)this) ? pSSysCalendarItemService.selectTempByPSSysCalendar(this) : pSSysCalendarItemService.selectByPSSysCalendar(this);
            }
            return this.pssyscalendaritems;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysCalendarLogic> getPSSysCalendarLogics() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCalendarLogics();
        }
        if (this.getPSSysCalendarId() == null) {
            return null;
        }
        PSSysCalendarService pSSysCalendarService = (PSSysCalendarService)ServiceGlobal.getService(PSSysCalendarService.class, (SessionFactory)this.getSessionFactory());
        PSSysCalendarLogicService pSSysCalendarLogicService = (PSSysCalendarLogicService)ServiceGlobal.getService(PSSysCalendarLogicService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysCalendarLogicsLock;
        synchronized (n) {
            if (this.pssyscalendarlogics == null) {
                this.pssyscalendarlogics = pSSysCalendarService.isTempData((IEntity)this) ? pSSysCalendarLogicService.selectTempByPSSysCalendar(this) : pSSysCalendarLogicService.selectByPSSysCalendar(this);
            }
            return this.pssyscalendarlogics;
        }
    }

    private PSSysCalendarBase getProxyEntity() {
        return this.proxyPSSysCalendarBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysCalendarBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysCalendarBase) {
            this.proxyPSSysCalendarBase = (PSSysCalendarBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BATPSDETOOLBARID, 0);
        fieldIndexMap.put(FIELD_BATPSDETOOLBARNAME, 1);
        fieldIndexMap.put(FIELD_BUSYINDICATOR, 2);
        fieldIndexMap.put(FIELD_CALENDARSTYLE, 3);
        fieldIndexMap.put(FIELD_CALENDARTAG, 4);
        fieldIndexMap.put(FIELD_CALENDARTAG2, 5);
        fieldIndexMap.put(FIELD_CODENAME, 6);
        fieldIndexMap.put(FIELD_CREATEDATE, 7);
        fieldIndexMap.put(FIELD_CREATEMAN, 8);
        fieldIndexMap.put(FIELD_EMPTYTEXT, 9);
        fieldIndexMap.put(FIELD_EMPTYTEXTPSLANRESID, 10);
        fieldIndexMap.put(FIELD_EMPTYTEXTPSLANRESNAME, 11);
        fieldIndexMap.put(FIELD_ENABLEEDIT, 12);
        fieldIndexMap.put(FIELD_GANTTFLAG, 13);
        fieldIndexMap.put(FIELD_GANTTPSSYSPFPLUGINID, 14);
        fieldIndexMap.put(FIELD_GANTTPSSYSPFPLUGINNAME, 15);
        fieldIndexMap.put(FIELD_GANTTSTYLE, 16);
        fieldIndexMap.put(FIELD_GROUPHEIGHT, 17);
        fieldIndexMap.put(FIELD_GROUPLAYOUT, 18);
        fieldIndexMap.put(FIELD_GROUPMODE, 19);
        fieldIndexMap.put(FIELD_GROUPPSCODELISTID, 20);
        fieldIndexMap.put(FIELD_GROUPPSCODELISTNAME, 21);
        fieldIndexMap.put(FIELD_GROUPPSDEFID, 22);
        fieldIndexMap.put(FIELD_GROUPPSDEFNAME, 23);
        fieldIndexMap.put(FIELD_GROUPPSSYSCSSID, 24);
        fieldIndexMap.put(FIELD_GROUPPSSYSCSSNAME, 25);
        fieldIndexMap.put(FIELD_GROUPPSSYSPFPLUGINID, 26);
        fieldIndexMap.put(FIELD_GROUPPSSYSPFPLUGINNAME, 27);
        fieldIndexMap.put(FIELD_GROUPSTYLE, 28);
        fieldIndexMap.put(FIELD_GROUPTEXTPSDEFID, 29);
        fieldIndexMap.put(FIELD_GROUPTEXTPSDEFNAME, 30);
        fieldIndexMap.put(FIELD_GROUPWIDTH, 31);
        fieldIndexMap.put(FIELD_LOCKFLAG, 32);
        fieldIndexMap.put(FIELD_LOGICNAME, 33);
        fieldIndexMap.put(FIELD_MEMO, 34);
        fieldIndexMap.put(FIELD_NAVVIEWHEIGHT, 35);
        fieldIndexMap.put(FIELD_NAVVIEWMAXHEIGHT, 36);
        fieldIndexMap.put(FIELD_NAVVIEWMAXWIDTH, 37);
        fieldIndexMap.put(FIELD_NAVVIEWMINHEIGHT, 38);
        fieldIndexMap.put(FIELD_NAVVIEWMINWIDTH, 39);
        fieldIndexMap.put(FIELD_NAVVIEWPOS, 40);
        fieldIndexMap.put(FIELD_NAVVIEWSHOWMODE, 41);
        fieldIndexMap.put(FIELD_NAVVIEWWIDTH, 42);
        fieldIndexMap.put(FIELD_PSCTRLLOGICGROUPID, 43);
        fieldIndexMap.put(FIELD_PSCTRLLOGICGROUPNAME, 44);
        fieldIndexMap.put(FIELD_PSCTRLMSGID, 45);
        fieldIndexMap.put(FIELD_PSCTRLMSGNAME, 46);
        fieldIndexMap.put(FIELD_PSDEID, 47);
        fieldIndexMap.put(FIELD_PSDENAME, 48);
        fieldIndexMap.put(FIELD_PSMODULEID, 49);
        fieldIndexMap.put(FIELD_PSMODULENAME, 50);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 51);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 52);
        fieldIndexMap.put(FIELD_PSSYSCALENDARID, 53);
        fieldIndexMap.put(FIELD_PSSYSCALENDARNAME, 54);
        fieldIndexMap.put(FIELD_PSSYSCSSID, 55);
        fieldIndexMap.put(FIELD_PSSYSCSSNAME, 56);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 57);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 58);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 59);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 60);
        fieldIndexMap.put(FIELD_PSVIEWMSGGROUPID, 61);
        fieldIndexMap.put(FIELD_PSVIEWMSGGROUPNAME, 62);
        fieldIndexMap.put(FIELD_QUICKPSDETOOLBARID, 63);
        fieldIndexMap.put(FIELD_QUICKPSDETOOLBARNAME, 64);
        fieldIndexMap.put(FIELD_SYSAPPFLAG, 65);
        fieldIndexMap.put(FIELD_UPDATEDATE, 66);
        fieldIndexMap.put(FIELD_UPDATEMAN, 67);
    }
}

