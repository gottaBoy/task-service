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
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlLogicGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlMsg;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCounter;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSearchBarItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSearchBarLogic;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgGroup;
import net.ibizsys.pscore.srv.sysdesign.service.PSCtrlLogicGroupService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCtrlMsgService;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCounterService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSearchBarItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSearchBarLogicService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSearchBarService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGroupService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysSearchBarBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysSearchBarBase.class);
    public static final String FIELD_BARSTYLE = "BARSTYLE";
    public static final String FIELD_BUSYINDICATOR = "BUSYINDICATOR";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENABLECUSTOMIZED = "ENABLECUSTOMIZED";
    public static final String FIELD_ENABLEQUICKSEARCH = "ENABLEQUICKSEARCH";
    public static final String FIELD_GROUPMODE = "GROUPMODE";
    public static final String FIELD_GROUPMORETEXT = "GROUPMORETEXT";
    public static final String FIELD_GROUPMORETEXTPSLANRESID = "GROUPMORETEXTPSLANRESID";
    public static final String FIELD_GROUPMORETEXTPSLANRESNAME = "GROUPMORETEXTPSLANRESNAME";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MOBFLAG = "MOBFLAG";
    public static final String FIELD_PSCTRLLOGICGROUPID = "PSCTRLLOGICGROUPID";
    public static final String FIELD_PSCTRLLOGICGROUPNAME = "PSCTRLLOGICGROUPNAME";
    public static final String FIELD_PSCTRLMSGID = "PSCTRLMSGID";
    public static final String FIELD_PSCTRLMSGNAME = "PSCTRLMSGNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSCOUNTERID = "PSSYSCOUNTERID";
    public static final String FIELD_PSSYSCOUNTERNAME = "PSSYSCOUNTERNAME";
    public static final String FIELD_PSSYSCSSID = "PSSYSCSSID";
    public static final String FIELD_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_PSSYSSEARCHBARID = "PSSYSSEARCHBARID";
    public static final String FIELD_PSSYSSEARCHBARNAME = "PSSYSSEARCHBARNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSVIEWMSGGROUPID = "PSVIEWMSGGROUPID";
    public static final String FIELD_PSVIEWMSGGROUPNAME = "PSVIEWMSGGROUPNAME";
    public static final String FIELD_QUICKGROUPCNT = "QUICKGROUPCNT";
    public static final String FIELD_QUICKSEARCHWIDTH = "QUICKSEARCHWIDTH";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    private static final int INDEX_BARSTYLE = 0;
    private static final int INDEX_BUSYINDICATOR = 1;
    private static final int INDEX_CODENAME = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEMAN = 4;
    private static final int INDEX_ENABLECUSTOMIZED = 5;
    private static final int INDEX_ENABLEQUICKSEARCH = 6;
    private static final int INDEX_GROUPMODE = 7;
    private static final int INDEX_GROUPMORETEXT = 8;
    private static final int INDEX_GROUPMORETEXTPSLANRESID = 9;
    private static final int INDEX_GROUPMORETEXTPSLANRESNAME = 10;
    private static final int INDEX_LOCKFLAG = 11;
    private static final int INDEX_MEMO = 12;
    private static final int INDEX_MOBFLAG = 13;
    private static final int INDEX_PSCTRLLOGICGROUPID = 14;
    private static final int INDEX_PSCTRLLOGICGROUPNAME = 15;
    private static final int INDEX_PSCTRLMSGID = 16;
    private static final int INDEX_PSCTRLMSGNAME = 17;
    private static final int INDEX_PSDEID = 18;
    private static final int INDEX_PSDENAME = 19;
    private static final int INDEX_PSMODULEID = 20;
    private static final int INDEX_PSMODULENAME = 21;
    private static final int INDEX_PSSYSCOUNTERID = 22;
    private static final int INDEX_PSSYSCOUNTERNAME = 23;
    private static final int INDEX_PSSYSCSSID = 24;
    private static final int INDEX_PSSYSCSSNAME = 25;
    private static final int INDEX_PSSYSPFPLUGINID = 26;
    private static final int INDEX_PSSYSPFPLUGINNAME = 27;
    private static final int INDEX_PSSYSSEARCHBARID = 28;
    private static final int INDEX_PSSYSSEARCHBARNAME = 29;
    private static final int INDEX_PSSYSTEMID = 30;
    private static final int INDEX_PSSYSTEMNAME = 31;
    private static final int INDEX_PSVIEWMSGGROUPID = 32;
    private static final int INDEX_PSVIEWMSGGROUPNAME = 33;
    private static final int INDEX_QUICKGROUPCNT = 34;
    private static final int INDEX_QUICKSEARCHWIDTH = 35;
    private static final int INDEX_UPDATEDATE = 36;
    private static final int INDEX_UPDATEMAN = 37;
    private static final int INDEX_USERTAG = 38;
    private static final int INDEX_USERTAG2 = 39;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysSearchBarBase proxyPSSysSearchBarBase = null;
    private boolean barstyleDirtyFlag = false;
    private boolean busyindicatorDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean enablecustomizedDirtyFlag = false;
    private boolean enablequicksearchDirtyFlag = false;
    private boolean groupmodeDirtyFlag = false;
    private boolean groupmoretextDirtyFlag = false;
    private boolean groupmoretextpslanresidDirtyFlag = false;
    private boolean groupmoretextpslanresnameDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean mobflagDirtyFlag = false;
    private boolean psctrllogicgroupidDirtyFlag = false;
    private boolean psctrllogicgroupnameDirtyFlag = false;
    private boolean psctrlmsgidDirtyFlag = false;
    private boolean psctrlmsgnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssyscounteridDirtyFlag = false;
    private boolean pssyscounternameDirtyFlag = false;
    private boolean pssyscssidDirtyFlag = false;
    private boolean pssyscssnameDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean pssyssearchbaridDirtyFlag = false;
    private boolean pssyssearchbarnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean psviewmsggroupidDirtyFlag = false;
    private boolean psviewmsggroupnameDirtyFlag = false;
    private boolean quickgroupcntDirtyFlag = false;
    private boolean quicksearchwidthDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    @Column(name="barstyle")
    private String barstyle;
    @Column(name="busyindicator")
    private Integer busyindicator;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="enablecustomized")
    private Integer enablecustomized;
    @Column(name="enablequicksearch")
    private Integer enablequicksearch;
    @Column(name="groupmode")
    private String groupmode;
    @Column(name="groupmoretext")
    private String groupmoretext;
    @Column(name="groupmoretextpslanresid")
    private String groupmoretextpslanresid;
    @Column(name="groupmoretextpslanresname")
    private String groupmoretextpslanresname;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
    @Column(name="mobflag")
    private Integer mobflag;
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
    @Column(name="pssyscounterid")
    private String pssyscounterid;
    @Column(name="pssyscountername")
    private String pssyscountername;
    @Column(name="pssyscssid")
    private String pssyscssid;
    @Column(name="pssyscssname")
    private String pssyscssname;
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
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="psviewmsggroupid")
    private String psviewmsggroupid;
    @Column(name="psviewmsggroupname")
    private String psviewmsggroupname;
    @Column(name="quickgroupcnt")
    private Integer quickgroupcnt;
    @Column(name="quicksearchwidth")
    private Integer quicksearchwidth;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    private Integer objPSCtrlLogicGroupLock = new Integer(1);
    private PSCtrlLogicGroup psctrllogicgroup = null;
    private Integer objPSCtrlMsgLock = new Integer(1);
    private PSCtrlMsg psctrlmsg = null;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objGroupMoreTextPSLanResLock = new Integer(1);
    private PSLanguageRes groupmoretextpslanres = null;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSysCounterLock = new Integer(1);
    private PSSysCounter pssyscounter = null;
    private Integer objPSSysCssLock = new Integer(1);
    private PSSysCss pssyscss = null;
    private Integer objPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin pssyspfplugin = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSViewMsgGroupLock = new Integer(1);
    private PSViewMsgGroup psviewmsggroup = null;
    private Integer objPSSysSearchBarItemsLock = new Integer(1);
    private ArrayList<PSSysSearchBarItem> pssyssearchbaritems = null;
    private Integer objPSSysSearchBarLogicsLock = new Integer(1);
    private ArrayList<PSSysSearchBarLogic> pssyssearchbarlogics = null;

    public void setBarStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBarStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.barstyle = string;
        this.barstyleDirtyFlag = true;
    }

    public String getBarStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBarStyle();
        }
        return this.barstyle;
    }

    public boolean isBarStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBarStyleDirty();
        }
        return this.barstyleDirtyFlag;
    }

    public void resetBarStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBarStyle();
            return;
        }
        this.barstyleDirtyFlag = false;
        this.barstyle = null;
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

    public void setEnableCustomized(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableCustomized(n);
            return;
        }
        this.enablecustomized = n;
        this.enablecustomizedDirtyFlag = true;
    }

    public Integer getEnableCustomized() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableCustomized();
        }
        return this.enablecustomized;
    }

    public boolean isEnableCustomizedDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableCustomizedDirty();
        }
        return this.enablecustomizedDirtyFlag;
    }

    public void resetEnableCustomized() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableCustomized();
            return;
        }
        this.enablecustomizedDirtyFlag = false;
        this.enablecustomized = null;
    }

    public void setEnableQuickSearch(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableQuickSearch(n);
            return;
        }
        this.enablequicksearch = n;
        this.enablequicksearchDirtyFlag = true;
    }

    public Integer getEnableQuickSearch() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableQuickSearch();
        }
        return this.enablequicksearch;
    }

    public boolean isEnableQuickSearchDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableQuickSearchDirty();
        }
        return this.enablequicksearchDirtyFlag;
    }

    public void resetEnableQuickSearch() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableQuickSearch();
            return;
        }
        this.enablequicksearchDirtyFlag = false;
        this.enablequicksearch = null;
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

    public void setGroupMoreText(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupMoreText(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.groupmoretext = string;
        this.groupmoretextDirtyFlag = true;
    }

    public String getGroupMoreText() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupMoreText();
        }
        return this.groupmoretext;
    }

    public boolean isGroupMoreTextDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupMoreTextDirty();
        }
        return this.groupmoretextDirtyFlag;
    }

    public void resetGroupMoreText() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupMoreText();
            return;
        }
        this.groupmoretextDirtyFlag = false;
        this.groupmoretext = null;
    }

    public void setGroupMoreTextPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupMoreTextPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.groupmoretextpslanresid = string;
        this.groupmoretextpslanresidDirtyFlag = true;
    }

    public String getGroupMoreTextPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupMoreTextPSLanResId();
        }
        return this.groupmoretextpslanresid;
    }

    public boolean isGroupMoreTextPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupMoreTextPSLanResIdDirty();
        }
        return this.groupmoretextpslanresidDirtyFlag;
    }

    public void resetGroupMoreTextPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupMoreTextPSLanResId();
            return;
        }
        this.groupmoretextpslanresidDirtyFlag = false;
        this.groupmoretextpslanresid = null;
    }

    public void setGroupMoreTextPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupMoreTextPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.groupmoretextpslanresname = string;
        this.groupmoretextpslanresnameDirtyFlag = true;
    }

    public String getGroupMoreTextPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupMoreTextPSLanResName();
        }
        return this.groupmoretextpslanresname;
    }

    public boolean isGroupMoreTextPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupMoreTextPSLanResNameDirty();
        }
        return this.groupmoretextpslanresnameDirtyFlag;
    }

    public void resetGroupMoreTextPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupMoreTextPSLanResName();
            return;
        }
        this.groupmoretextpslanresnameDirtyFlag = false;
        this.groupmoretextpslanresname = null;
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

    public void setQuickGroupCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setQuickGroupCnt(n);
            return;
        }
        this.quickgroupcnt = n;
        this.quickgroupcntDirtyFlag = true;
    }

    public Integer getQuickGroupCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getQuickGroupCnt();
        }
        return this.quickgroupcnt;
    }

    public boolean isQuickGroupCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isQuickGroupCntDirty();
        }
        return this.quickgroupcntDirtyFlag;
    }

    public void resetQuickGroupCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetQuickGroupCnt();
            return;
        }
        this.quickgroupcntDirtyFlag = false;
        this.quickgroupcnt = null;
    }

    public void setQuickSearchWidth(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setQuickSearchWidth(n);
            return;
        }
        this.quicksearchwidth = n;
        this.quicksearchwidthDirtyFlag = true;
    }

    public Integer getQuickSearchWidth() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getQuickSearchWidth();
        }
        return this.quicksearchwidth;
    }

    public boolean isQuickSearchWidthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isQuickSearchWidthDirty();
        }
        return this.quicksearchwidthDirtyFlag;
    }

    public void resetQuickSearchWidth() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetQuickSearchWidth();
            return;
        }
        this.quicksearchwidthDirtyFlag = false;
        this.quicksearchwidth = null;
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
        PSSysSearchBarBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysSearchBarBase pSSysSearchBarBase) {
        pSSysSearchBarBase.resetBarStyle();
        pSSysSearchBarBase.resetBusyIndicator();
        pSSysSearchBarBase.resetCodeName();
        pSSysSearchBarBase.resetCreateDate();
        pSSysSearchBarBase.resetCreateMan();
        pSSysSearchBarBase.resetEnableCustomized();
        pSSysSearchBarBase.resetEnableQuickSearch();
        pSSysSearchBarBase.resetGroupMode();
        pSSysSearchBarBase.resetGroupMoreText();
        pSSysSearchBarBase.resetGroupMoreTextPSLanResId();
        pSSysSearchBarBase.resetGroupMoreTextPSLanResName();
        pSSysSearchBarBase.resetLockFlag();
        pSSysSearchBarBase.resetMemo();
        pSSysSearchBarBase.resetMobFlag();
        pSSysSearchBarBase.resetPSCtrlLogicGroupId();
        pSSysSearchBarBase.resetPSCtrlLogicGroupName();
        pSSysSearchBarBase.resetPSCtrlMsgId();
        pSSysSearchBarBase.resetPSCtrlMsgName();
        pSSysSearchBarBase.resetPSDEId();
        pSSysSearchBarBase.resetPSDEName();
        pSSysSearchBarBase.resetPSModuleId();
        pSSysSearchBarBase.resetPSModuleName();
        pSSysSearchBarBase.resetPSSysCounterId();
        pSSysSearchBarBase.resetPSSysCounterName();
        pSSysSearchBarBase.resetPSSysCssId();
        pSSysSearchBarBase.resetPSSysCssName();
        pSSysSearchBarBase.resetPSSysPFPluginId();
        pSSysSearchBarBase.resetPSSysPFPluginName();
        pSSysSearchBarBase.resetPSSysSearchBarId();
        pSSysSearchBarBase.resetPSSysSearchBarName();
        pSSysSearchBarBase.resetPSSystemId();
        pSSysSearchBarBase.resetPSSystemName();
        pSSysSearchBarBase.resetPSViewMsgGroupId();
        pSSysSearchBarBase.resetPSViewMsgGroupName();
        pSSysSearchBarBase.resetQuickGroupCnt();
        pSSysSearchBarBase.resetQuickSearchWidth();
        pSSysSearchBarBase.resetUpdateDate();
        pSSysSearchBarBase.resetUpdateMan();
        pSSysSearchBarBase.resetUserTag();
        pSSysSearchBarBase.resetUserTag2();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBarStyleDirty()) {
            hashMap.put(FIELD_BARSTYLE, this.getBarStyle());
        }
        if (!bl || this.isBusyIndicatorDirty()) {
            hashMap.put(FIELD_BUSYINDICATOR, this.getBusyIndicator());
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
        if (!bl || this.isEnableCustomizedDirty()) {
            hashMap.put(FIELD_ENABLECUSTOMIZED, this.getEnableCustomized());
        }
        if (!bl || this.isEnableQuickSearchDirty()) {
            hashMap.put(FIELD_ENABLEQUICKSEARCH, this.getEnableQuickSearch());
        }
        if (!bl || this.isGroupModeDirty()) {
            hashMap.put(FIELD_GROUPMODE, this.getGroupMode());
        }
        if (!bl || this.isGroupMoreTextDirty()) {
            hashMap.put(FIELD_GROUPMORETEXT, this.getGroupMoreText());
        }
        if (!bl || this.isGroupMoreTextPSLanResIdDirty()) {
            hashMap.put(FIELD_GROUPMORETEXTPSLANRESID, this.getGroupMoreTextPSLanResId());
        }
        if (!bl || this.isGroupMoreTextPSLanResNameDirty()) {
            hashMap.put(FIELD_GROUPMORETEXTPSLANRESNAME, this.getGroupMoreTextPSLanResName());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMobFlagDirty()) {
            hashMap.put(FIELD_MOBFLAG, this.getMobFlag());
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
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isPSViewMsgGroupIdDirty()) {
            hashMap.put(FIELD_PSVIEWMSGGROUPID, this.getPSViewMsgGroupId());
        }
        if (!bl || this.isPSViewMsgGroupNameDirty()) {
            hashMap.put(FIELD_PSVIEWMSGGROUPNAME, this.getPSViewMsgGroupName());
        }
        if (!bl || this.isQuickGroupCntDirty()) {
            hashMap.put(FIELD_QUICKGROUPCNT, this.getQuickGroupCnt());
        }
        if (!bl || this.isQuickSearchWidthDirty()) {
            hashMap.put(FIELD_QUICKSEARCHWIDTH, this.getQuickSearchWidth());
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
        return PSSysSearchBarBase.get(this, n);
    }

    private static Object get(PSSysSearchBarBase pSSysSearchBarBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysSearchBarBase.getBarStyle();
            }
            case 1: {
                return pSSysSearchBarBase.getBusyIndicator();
            }
            case 2: {
                return pSSysSearchBarBase.getCodeName();
            }
            case 3: {
                return pSSysSearchBarBase.getCreateDate();
            }
            case 4: {
                return pSSysSearchBarBase.getCreateMan();
            }
            case 5: {
                return pSSysSearchBarBase.getEnableCustomized();
            }
            case 6: {
                return pSSysSearchBarBase.getEnableQuickSearch();
            }
            case 7: {
                return pSSysSearchBarBase.getGroupMode();
            }
            case 8: {
                return pSSysSearchBarBase.getGroupMoreText();
            }
            case 9: {
                return pSSysSearchBarBase.getGroupMoreTextPSLanResId();
            }
            case 10: {
                return pSSysSearchBarBase.getGroupMoreTextPSLanResName();
            }
            case 11: {
                return pSSysSearchBarBase.getLockFlag();
            }
            case 12: {
                return pSSysSearchBarBase.getMemo();
            }
            case 13: {
                return pSSysSearchBarBase.getMobFlag();
            }
            case 14: {
                return pSSysSearchBarBase.getPSCtrlLogicGroupId();
            }
            case 15: {
                return pSSysSearchBarBase.getPSCtrlLogicGroupName();
            }
            case 16: {
                return pSSysSearchBarBase.getPSCtrlMsgId();
            }
            case 17: {
                return pSSysSearchBarBase.getPSCtrlMsgName();
            }
            case 18: {
                return pSSysSearchBarBase.getPSDEId();
            }
            case 19: {
                return pSSysSearchBarBase.getPSDEName();
            }
            case 20: {
                return pSSysSearchBarBase.getPSModuleId();
            }
            case 21: {
                return pSSysSearchBarBase.getPSModuleName();
            }
            case 22: {
                return pSSysSearchBarBase.getPSSysCounterId();
            }
            case 23: {
                return pSSysSearchBarBase.getPSSysCounterName();
            }
            case 24: {
                return pSSysSearchBarBase.getPSSysCssId();
            }
            case 25: {
                return pSSysSearchBarBase.getPSSysCssName();
            }
            case 26: {
                return pSSysSearchBarBase.getPSSysPFPluginId();
            }
            case 27: {
                return pSSysSearchBarBase.getPSSysPFPluginName();
            }
            case 28: {
                return pSSysSearchBarBase.getPSSysSearchBarId();
            }
            case 29: {
                return pSSysSearchBarBase.getPSSysSearchBarName();
            }
            case 30: {
                return pSSysSearchBarBase.getPSSystemId();
            }
            case 31: {
                return pSSysSearchBarBase.getPSSystemName();
            }
            case 32: {
                return pSSysSearchBarBase.getPSViewMsgGroupId();
            }
            case 33: {
                return pSSysSearchBarBase.getPSViewMsgGroupName();
            }
            case 34: {
                return pSSysSearchBarBase.getQuickGroupCnt();
            }
            case 35: {
                return pSSysSearchBarBase.getQuickSearchWidth();
            }
            case 36: {
                return pSSysSearchBarBase.getUpdateDate();
            }
            case 37: {
                return pSSysSearchBarBase.getUpdateMan();
            }
            case 38: {
                return pSSysSearchBarBase.getUserTag();
            }
            case 39: {
                return pSSysSearchBarBase.getUserTag2();
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
        PSSysSearchBarBase.set(this, n, object);
    }

    private static void set(PSSysSearchBarBase pSSysSearchBarBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysSearchBarBase.setBarStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysSearchBarBase.setBusyIndicator(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 2: {
                pSSysSearchBarBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysSearchBarBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSSysSearchBarBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysSearchBarBase.setEnableCustomized(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSSysSearchBarBase.setEnableQuickSearch(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSSysSearchBarBase.setGroupMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysSearchBarBase.setGroupMoreText(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysSearchBarBase.setGroupMoreTextPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysSearchBarBase.setGroupMoreTextPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysSearchBarBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSSysSearchBarBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysSearchBarBase.setMobFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSSysSearchBarBase.setPSCtrlLogicGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysSearchBarBase.setPSCtrlLogicGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysSearchBarBase.setPSCtrlMsgId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysSearchBarBase.setPSCtrlMsgName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysSearchBarBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysSearchBarBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysSearchBarBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysSearchBarBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysSearchBarBase.setPSSysCounterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysSearchBarBase.setPSSysCounterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysSearchBarBase.setPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysSearchBarBase.setPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysSearchBarBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysSearchBarBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysSearchBarBase.setPSSysSearchBarId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysSearchBarBase.setPSSysSearchBarName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysSearchBarBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysSearchBarBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysSearchBarBase.setPSViewMsgGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysSearchBarBase.setPSViewMsgGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysSearchBarBase.setQuickGroupCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 35: {
                pSSysSearchBarBase.setQuickSearchWidth(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 36: {
                pSSysSearchBarBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 37: {
                pSSysSearchBarBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSSysSearchBarBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSSysSearchBarBase.setUserTag2(DataObject.getStringValue((Object)object));
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
        return PSSysSearchBarBase.isNull(this, n);
    }

    private static boolean isNull(PSSysSearchBarBase pSSysSearchBarBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysSearchBarBase.getBarStyle() == null;
            }
            case 1: {
                return pSSysSearchBarBase.getBusyIndicator() == null;
            }
            case 2: {
                return pSSysSearchBarBase.getCodeName() == null;
            }
            case 3: {
                return pSSysSearchBarBase.getCreateDate() == null;
            }
            case 4: {
                return pSSysSearchBarBase.getCreateMan() == null;
            }
            case 5: {
                return pSSysSearchBarBase.getEnableCustomized() == null;
            }
            case 6: {
                return pSSysSearchBarBase.getEnableQuickSearch() == null;
            }
            case 7: {
                return pSSysSearchBarBase.getGroupMode() == null;
            }
            case 8: {
                return pSSysSearchBarBase.getGroupMoreText() == null;
            }
            case 9: {
                return pSSysSearchBarBase.getGroupMoreTextPSLanResId() == null;
            }
            case 10: {
                return pSSysSearchBarBase.getGroupMoreTextPSLanResName() == null;
            }
            case 11: {
                return pSSysSearchBarBase.getLockFlag() == null;
            }
            case 12: {
                return pSSysSearchBarBase.getMemo() == null;
            }
            case 13: {
                return pSSysSearchBarBase.getMobFlag() == null;
            }
            case 14: {
                return pSSysSearchBarBase.getPSCtrlLogicGroupId() == null;
            }
            case 15: {
                return pSSysSearchBarBase.getPSCtrlLogicGroupName() == null;
            }
            case 16: {
                return pSSysSearchBarBase.getPSCtrlMsgId() == null;
            }
            case 17: {
                return pSSysSearchBarBase.getPSCtrlMsgName() == null;
            }
            case 18: {
                return pSSysSearchBarBase.getPSDEId() == null;
            }
            case 19: {
                return pSSysSearchBarBase.getPSDEName() == null;
            }
            case 20: {
                return pSSysSearchBarBase.getPSModuleId() == null;
            }
            case 21: {
                return pSSysSearchBarBase.getPSModuleName() == null;
            }
            case 22: {
                return pSSysSearchBarBase.getPSSysCounterId() == null;
            }
            case 23: {
                return pSSysSearchBarBase.getPSSysCounterName() == null;
            }
            case 24: {
                return pSSysSearchBarBase.getPSSysCssId() == null;
            }
            case 25: {
                return pSSysSearchBarBase.getPSSysCssName() == null;
            }
            case 26: {
                return pSSysSearchBarBase.getPSSysPFPluginId() == null;
            }
            case 27: {
                return pSSysSearchBarBase.getPSSysPFPluginName() == null;
            }
            case 28: {
                return pSSysSearchBarBase.getPSSysSearchBarId() == null;
            }
            case 29: {
                return pSSysSearchBarBase.getPSSysSearchBarName() == null;
            }
            case 30: {
                return pSSysSearchBarBase.getPSSystemId() == null;
            }
            case 31: {
                return pSSysSearchBarBase.getPSSystemName() == null;
            }
            case 32: {
                return pSSysSearchBarBase.getPSViewMsgGroupId() == null;
            }
            case 33: {
                return pSSysSearchBarBase.getPSViewMsgGroupName() == null;
            }
            case 34: {
                return pSSysSearchBarBase.getQuickGroupCnt() == null;
            }
            case 35: {
                return pSSysSearchBarBase.getQuickSearchWidth() == null;
            }
            case 36: {
                return pSSysSearchBarBase.getUpdateDate() == null;
            }
            case 37: {
                return pSSysSearchBarBase.getUpdateMan() == null;
            }
            case 38: {
                return pSSysSearchBarBase.getUserTag() == null;
            }
            case 39: {
                return pSSysSearchBarBase.getUserTag2() == null;
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
        return PSSysSearchBarBase.contains(this, n);
    }

    private static boolean contains(PSSysSearchBarBase pSSysSearchBarBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysSearchBarBase.isBarStyleDirty();
            }
            case 1: {
                return pSSysSearchBarBase.isBusyIndicatorDirty();
            }
            case 2: {
                return pSSysSearchBarBase.isCodeNameDirty();
            }
            case 3: {
                return pSSysSearchBarBase.isCreateDateDirty();
            }
            case 4: {
                return pSSysSearchBarBase.isCreateManDirty();
            }
            case 5: {
                return pSSysSearchBarBase.isEnableCustomizedDirty();
            }
            case 6: {
                return pSSysSearchBarBase.isEnableQuickSearchDirty();
            }
            case 7: {
                return pSSysSearchBarBase.isGroupModeDirty();
            }
            case 8: {
                return pSSysSearchBarBase.isGroupMoreTextDirty();
            }
            case 9: {
                return pSSysSearchBarBase.isGroupMoreTextPSLanResIdDirty();
            }
            case 10: {
                return pSSysSearchBarBase.isGroupMoreTextPSLanResNameDirty();
            }
            case 11: {
                return pSSysSearchBarBase.isLockFlagDirty();
            }
            case 12: {
                return pSSysSearchBarBase.isMemoDirty();
            }
            case 13: {
                return pSSysSearchBarBase.isMobFlagDirty();
            }
            case 14: {
                return pSSysSearchBarBase.isPSCtrlLogicGroupIdDirty();
            }
            case 15: {
                return pSSysSearchBarBase.isPSCtrlLogicGroupNameDirty();
            }
            case 16: {
                return pSSysSearchBarBase.isPSCtrlMsgIdDirty();
            }
            case 17: {
                return pSSysSearchBarBase.isPSCtrlMsgNameDirty();
            }
            case 18: {
                return pSSysSearchBarBase.isPSDEIdDirty();
            }
            case 19: {
                return pSSysSearchBarBase.isPSDENameDirty();
            }
            case 20: {
                return pSSysSearchBarBase.isPSModuleIdDirty();
            }
            case 21: {
                return pSSysSearchBarBase.isPSModuleNameDirty();
            }
            case 22: {
                return pSSysSearchBarBase.isPSSysCounterIdDirty();
            }
            case 23: {
                return pSSysSearchBarBase.isPSSysCounterNameDirty();
            }
            case 24: {
                return pSSysSearchBarBase.isPSSysCssIdDirty();
            }
            case 25: {
                return pSSysSearchBarBase.isPSSysCssNameDirty();
            }
            case 26: {
                return pSSysSearchBarBase.isPSSysPFPluginIdDirty();
            }
            case 27: {
                return pSSysSearchBarBase.isPSSysPFPluginNameDirty();
            }
            case 28: {
                return pSSysSearchBarBase.isPSSysSearchBarIdDirty();
            }
            case 29: {
                return pSSysSearchBarBase.isPSSysSearchBarNameDirty();
            }
            case 30: {
                return pSSysSearchBarBase.isPSSystemIdDirty();
            }
            case 31: {
                return pSSysSearchBarBase.isPSSystemNameDirty();
            }
            case 32: {
                return pSSysSearchBarBase.isPSViewMsgGroupIdDirty();
            }
            case 33: {
                return pSSysSearchBarBase.isPSViewMsgGroupNameDirty();
            }
            case 34: {
                return pSSysSearchBarBase.isQuickGroupCntDirty();
            }
            case 35: {
                return pSSysSearchBarBase.isQuickSearchWidthDirty();
            }
            case 36: {
                return pSSysSearchBarBase.isUpdateDateDirty();
            }
            case 37: {
                return pSSysSearchBarBase.isUpdateManDirty();
            }
            case 38: {
                return pSSysSearchBarBase.isUserTagDirty();
            }
            case 39: {
                return pSSysSearchBarBase.isUserTag2Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysSearchBarBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysSearchBarBase pSSysSearchBarBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysSearchBarBase.getBarStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"barstyle", (Object)PSSysSearchBarBase.getJSONValue((Object)pSSysSearchBarBase.getBarStyle()), (boolean)false);
        }
        if (bl || pSSysSearchBarBase.getBusyIndicator() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"busyindicator", (Object)PSSysSearchBarBase.getJSONValue((Object)pSSysSearchBarBase.getBusyIndicator()), (boolean)false);
        }
        if (bl || pSSysSearchBarBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysSearchBarBase.getJSONValue((Object)pSSysSearchBarBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysSearchBarBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysSearchBarBase.getJSONValue((Object)pSSysSearchBarBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysSearchBarBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysSearchBarBase.getJSONValue((Object)pSSysSearchBarBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysSearchBarBase.getEnableCustomized() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablecustomized", (Object)PSSysSearchBarBase.getJSONValue((Object)pSSysSearchBarBase.getEnableCustomized()), (boolean)false);
        }
        if (bl || pSSysSearchBarBase.getEnableQuickSearch() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablequicksearch", (Object)PSSysSearchBarBase.getJSONValue((Object)pSSysSearchBarBase.getEnableQuickSearch()), (boolean)false);
        }
        if (bl || pSSysSearchBarBase.getGroupMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"groupmode", (Object)PSSysSearchBarBase.getJSONValue((Object)pSSysSearchBarBase.getGroupMode()), (boolean)false);
        }
        if (bl || pSSysSearchBarBase.getGroupMoreText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"groupmoretext", (Object)PSSysSearchBarBase.getJSONValue((Object)pSSysSearchBarBase.getGroupMoreText()), (boolean)false);
        }
        if (bl || pSSysSearchBarBase.getGroupMoreTextPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"groupmoretextpslanresid", (Object)PSSysSearchBarBase.getJSONValue((Object)pSSysSearchBarBase.getGroupMoreTextPSLanResId()), (boolean)false);
        }
        if (bl || pSSysSearchBarBase.getGroupMoreTextPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"groupmoretextpslanresname", (Object)PSSysSearchBarBase.getJSONValue((Object)pSSysSearchBarBase.getGroupMoreTextPSLanResName()), (boolean)false);
        }
        if (bl || pSSysSearchBarBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSSysSearchBarBase.getJSONValue((Object)pSSysSearchBarBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSSysSearchBarBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysSearchBarBase.getJSONValue((Object)pSSysSearchBarBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysSearchBarBase.getMobFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobflag", (Object)PSSysSearchBarBase.getJSONValue((Object)pSSysSearchBarBase.getMobFlag()), (boolean)false);
        }
        if (bl || pSSysSearchBarBase.getPSCtrlLogicGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrllogicgroupid", (Object)PSSysSearchBarBase.getJSONValue((Object)pSSysSearchBarBase.getPSCtrlLogicGroupId()), (boolean)false);
        }
        if (bl || pSSysSearchBarBase.getPSCtrlLogicGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrllogicgroupname", (Object)PSSysSearchBarBase.getJSONValue((Object)pSSysSearchBarBase.getPSCtrlLogicGroupName()), (boolean)false);
        }
        if (bl || pSSysSearchBarBase.getPSCtrlMsgId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrlmsgid", (Object)PSSysSearchBarBase.getJSONValue((Object)pSSysSearchBarBase.getPSCtrlMsgId()), (boolean)false);
        }
        if (bl || pSSysSearchBarBase.getPSCtrlMsgName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrlmsgname", (Object)PSSysSearchBarBase.getJSONValue((Object)pSSysSearchBarBase.getPSCtrlMsgName()), (boolean)false);
        }
        if (bl || pSSysSearchBarBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysSearchBarBase.getJSONValue((Object)pSSysSearchBarBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysSearchBarBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSSysSearchBarBase.getJSONValue((Object)pSSysSearchBarBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSSysSearchBarBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysSearchBarBase.getJSONValue((Object)pSSysSearchBarBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysSearchBarBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysSearchBarBase.getJSONValue((Object)pSSysSearchBarBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysSearchBarBase.getPSSysCounterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscounterid", (Object)PSSysSearchBarBase.getJSONValue((Object)pSSysSearchBarBase.getPSSysCounterId()), (boolean)false);
        }
        if (bl || pSSysSearchBarBase.getPSSysCounterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscountername", (Object)PSSysSearchBarBase.getJSONValue((Object)pSSysSearchBarBase.getPSSysCounterName()), (boolean)false);
        }
        if (bl || pSSysSearchBarBase.getPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssid", (Object)PSSysSearchBarBase.getJSONValue((Object)pSSysSearchBarBase.getPSSysCssId()), (boolean)false);
        }
        if (bl || pSSysSearchBarBase.getPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssname", (Object)PSSysSearchBarBase.getJSONValue((Object)pSSysSearchBarBase.getPSSysCssName()), (boolean)false);
        }
        if (bl || pSSysSearchBarBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSSysSearchBarBase.getJSONValue((Object)pSSysSearchBarBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSSysSearchBarBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSSysSearchBarBase.getJSONValue((Object)pSSysSearchBarBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSSysSearchBarBase.getPSSysSearchBarId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssearchbarid", (Object)PSSysSearchBarBase.getJSONValue((Object)pSSysSearchBarBase.getPSSysSearchBarId()), (boolean)false);
        }
        if (bl || pSSysSearchBarBase.getPSSysSearchBarName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssearchbarname", (Object)PSSysSearchBarBase.getJSONValue((Object)pSSysSearchBarBase.getPSSysSearchBarName()), (boolean)false);
        }
        if (bl || pSSysSearchBarBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysSearchBarBase.getJSONValue((Object)pSSysSearchBarBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysSearchBarBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysSearchBarBase.getJSONValue((Object)pSSysSearchBarBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysSearchBarBase.getPSViewMsgGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewmsggroupid", (Object)PSSysSearchBarBase.getJSONValue((Object)pSSysSearchBarBase.getPSViewMsgGroupId()), (boolean)false);
        }
        if (bl || pSSysSearchBarBase.getPSViewMsgGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewmsggroupname", (Object)PSSysSearchBarBase.getJSONValue((Object)pSSysSearchBarBase.getPSViewMsgGroupName()), (boolean)false);
        }
        if (bl || pSSysSearchBarBase.getQuickGroupCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"quickgroupcnt", (Object)PSSysSearchBarBase.getJSONValue((Object)pSSysSearchBarBase.getQuickGroupCnt()), (boolean)false);
        }
        if (bl || pSSysSearchBarBase.getQuickSearchWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"quicksearchwidth", (Object)PSSysSearchBarBase.getJSONValue((Object)pSSysSearchBarBase.getQuickSearchWidth()), (boolean)false);
        }
        if (bl || pSSysSearchBarBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysSearchBarBase.getJSONValue((Object)pSSysSearchBarBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysSearchBarBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysSearchBarBase.getJSONValue((Object)pSSysSearchBarBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysSearchBarBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysSearchBarBase.getJSONValue((Object)pSSysSearchBarBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysSearchBarBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysSearchBarBase.getJSONValue((Object)pSSysSearchBarBase.getUserTag2()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysSearchBarBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysSearchBarBase pSSysSearchBarBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysSearchBarBase.getBarStyle() != null) {
            object = pSSysSearchBarBase.getBarStyle();
            xmlNode.setAttribute(FIELD_BARSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarBase.getBusyIndicator() != null) {
            object = pSSysSearchBarBase.getBusyIndicator();
            xmlNode.setAttribute(FIELD_BUSYINDICATOR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSearchBarBase.getCodeName() != null) {
            object = pSSysSearchBarBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarBase.getCreateDate() != null) {
            object = pSSysSearchBarBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysSearchBarBase.getCreateMan() != null) {
            object = pSSysSearchBarBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarBase.getEnableCustomized() != null) {
            object = pSSysSearchBarBase.getEnableCustomized();
            xmlNode.setAttribute(FIELD_ENABLECUSTOMIZED, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSearchBarBase.getEnableQuickSearch() != null) {
            object = pSSysSearchBarBase.getEnableQuickSearch();
            xmlNode.setAttribute(FIELD_ENABLEQUICKSEARCH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSearchBarBase.getGroupMode() != null) {
            object = pSSysSearchBarBase.getGroupMode();
            xmlNode.setAttribute(FIELD_GROUPMODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarBase.getGroupMoreText() != null) {
            object = pSSysSearchBarBase.getGroupMoreText();
            xmlNode.setAttribute(FIELD_GROUPMORETEXT, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarBase.getGroupMoreTextPSLanResId() != null) {
            object = pSSysSearchBarBase.getGroupMoreTextPSLanResId();
            xmlNode.setAttribute(FIELD_GROUPMORETEXTPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarBase.getGroupMoreTextPSLanResName() != null) {
            object = pSSysSearchBarBase.getGroupMoreTextPSLanResName();
            xmlNode.setAttribute(FIELD_GROUPMORETEXTPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarBase.getLockFlag() != null) {
            object = pSSysSearchBarBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSearchBarBase.getMemo() != null) {
            object = pSSysSearchBarBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarBase.getMobFlag() != null) {
            object = pSSysSearchBarBase.getMobFlag();
            xmlNode.setAttribute(FIELD_MOBFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSearchBarBase.getPSCtrlLogicGroupId() != null) {
            object = pSSysSearchBarBase.getPSCtrlLogicGroupId();
            xmlNode.setAttribute(FIELD_PSCTRLLOGICGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarBase.getPSCtrlLogicGroupName() != null) {
            object = pSSysSearchBarBase.getPSCtrlLogicGroupName();
            xmlNode.setAttribute(FIELD_PSCTRLLOGICGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarBase.getPSCtrlMsgId() != null) {
            object = pSSysSearchBarBase.getPSCtrlMsgId();
            xmlNode.setAttribute(FIELD_PSCTRLMSGID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarBase.getPSCtrlMsgName() != null) {
            object = pSSysSearchBarBase.getPSCtrlMsgName();
            xmlNode.setAttribute(FIELD_PSCTRLMSGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarBase.getPSDEId() != null) {
            object = pSSysSearchBarBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarBase.getPSDEName() != null) {
            object = pSSysSearchBarBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarBase.getPSModuleId() != null) {
            object = pSSysSearchBarBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarBase.getPSModuleName() != null) {
            object = pSSysSearchBarBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarBase.getPSSysCounterId() != null) {
            object = pSSysSearchBarBase.getPSSysCounterId();
            xmlNode.setAttribute(FIELD_PSSYSCOUNTERID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarBase.getPSSysCounterName() != null) {
            object = pSSysSearchBarBase.getPSSysCounterName();
            xmlNode.setAttribute(FIELD_PSSYSCOUNTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarBase.getPSSysCssId() != null) {
            object = pSSysSearchBarBase.getPSSysCssId();
            xmlNode.setAttribute(FIELD_PSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarBase.getPSSysCssName() != null) {
            object = pSSysSearchBarBase.getPSSysCssName();
            xmlNode.setAttribute(FIELD_PSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarBase.getPSSysPFPluginId() != null) {
            object = pSSysSearchBarBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarBase.getPSSysPFPluginName() != null) {
            object = pSSysSearchBarBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarBase.getPSSysSearchBarId() != null) {
            object = pSSysSearchBarBase.getPSSysSearchBarId();
            xmlNode.setAttribute(FIELD_PSSYSSEARCHBARID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarBase.getPSSysSearchBarName() != null) {
            object = pSSysSearchBarBase.getPSSysSearchBarName();
            xmlNode.setAttribute(FIELD_PSSYSSEARCHBARNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarBase.getPSSystemId() != null) {
            object = pSSysSearchBarBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarBase.getPSSystemName() != null) {
            object = pSSysSearchBarBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarBase.getPSViewMsgGroupId() != null) {
            object = pSSysSearchBarBase.getPSViewMsgGroupId();
            xmlNode.setAttribute(FIELD_PSVIEWMSGGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarBase.getPSViewMsgGroupName() != null) {
            object = pSSysSearchBarBase.getPSViewMsgGroupName();
            xmlNode.setAttribute(FIELD_PSVIEWMSGGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarBase.getQuickGroupCnt() != null) {
            object = pSSysSearchBarBase.getQuickGroupCnt();
            xmlNode.setAttribute(FIELD_QUICKGROUPCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSearchBarBase.getQuickSearchWidth() != null) {
            object = pSSysSearchBarBase.getQuickSearchWidth();
            xmlNode.setAttribute(FIELD_QUICKSEARCHWIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSearchBarBase.getUpdateDate() != null) {
            object = pSSysSearchBarBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysSearchBarBase.getUpdateMan() != null) {
            object = pSSysSearchBarBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarBase.getUserTag() != null) {
            object = pSSysSearchBarBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarBase.getUserTag2() != null) {
            object = pSSysSearchBarBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysSearchBarBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysSearchBarBase pSSysSearchBarBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysSearchBarBase.isBarStyleDirty() && (bl || pSSysSearchBarBase.getBarStyle() != null)) {
            iDataObject.set(FIELD_BARSTYLE, (Object)pSSysSearchBarBase.getBarStyle());
        }
        if (pSSysSearchBarBase.isBusyIndicatorDirty() && (bl || pSSysSearchBarBase.getBusyIndicator() != null)) {
            iDataObject.set(FIELD_BUSYINDICATOR, (Object)pSSysSearchBarBase.getBusyIndicator());
        }
        if (pSSysSearchBarBase.isCodeNameDirty() && (bl || pSSysSearchBarBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysSearchBarBase.getCodeName());
        }
        if (pSSysSearchBarBase.isCreateDateDirty() && (bl || pSSysSearchBarBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysSearchBarBase.getCreateDate());
        }
        if (pSSysSearchBarBase.isCreateManDirty() && (bl || pSSysSearchBarBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysSearchBarBase.getCreateMan());
        }
        if (pSSysSearchBarBase.isEnableCustomizedDirty() && (bl || pSSysSearchBarBase.getEnableCustomized() != null)) {
            iDataObject.set(FIELD_ENABLECUSTOMIZED, (Object)pSSysSearchBarBase.getEnableCustomized());
        }
        if (pSSysSearchBarBase.isEnableQuickSearchDirty() && (bl || pSSysSearchBarBase.getEnableQuickSearch() != null)) {
            iDataObject.set(FIELD_ENABLEQUICKSEARCH, (Object)pSSysSearchBarBase.getEnableQuickSearch());
        }
        if (pSSysSearchBarBase.isGroupModeDirty() && (bl || pSSysSearchBarBase.getGroupMode() != null)) {
            iDataObject.set(FIELD_GROUPMODE, (Object)pSSysSearchBarBase.getGroupMode());
        }
        if (pSSysSearchBarBase.isGroupMoreTextDirty() && (bl || pSSysSearchBarBase.getGroupMoreText() != null)) {
            iDataObject.set(FIELD_GROUPMORETEXT, (Object)pSSysSearchBarBase.getGroupMoreText());
        }
        if (pSSysSearchBarBase.isGroupMoreTextPSLanResIdDirty() && (bl || pSSysSearchBarBase.getGroupMoreTextPSLanResId() != null)) {
            iDataObject.set(FIELD_GROUPMORETEXTPSLANRESID, (Object)pSSysSearchBarBase.getGroupMoreTextPSLanResId());
        }
        if (pSSysSearchBarBase.isGroupMoreTextPSLanResNameDirty() && (bl || pSSysSearchBarBase.getGroupMoreTextPSLanResName() != null)) {
            iDataObject.set(FIELD_GROUPMORETEXTPSLANRESNAME, (Object)pSSysSearchBarBase.getGroupMoreTextPSLanResName());
        }
        if (pSSysSearchBarBase.isLockFlagDirty() && (bl || pSSysSearchBarBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSSysSearchBarBase.getLockFlag());
        }
        if (pSSysSearchBarBase.isMemoDirty() && (bl || pSSysSearchBarBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysSearchBarBase.getMemo());
        }
        if (pSSysSearchBarBase.isMobFlagDirty() && (bl || pSSysSearchBarBase.getMobFlag() != null)) {
            iDataObject.set(FIELD_MOBFLAG, (Object)pSSysSearchBarBase.getMobFlag());
        }
        if (pSSysSearchBarBase.isPSCtrlLogicGroupIdDirty() && (bl || pSSysSearchBarBase.getPSCtrlLogicGroupId() != null)) {
            iDataObject.set(FIELD_PSCTRLLOGICGROUPID, (Object)pSSysSearchBarBase.getPSCtrlLogicGroupId());
        }
        if (pSSysSearchBarBase.isPSCtrlLogicGroupNameDirty() && (bl || pSSysSearchBarBase.getPSCtrlLogicGroupName() != null)) {
            iDataObject.set(FIELD_PSCTRLLOGICGROUPNAME, (Object)pSSysSearchBarBase.getPSCtrlLogicGroupName());
        }
        if (pSSysSearchBarBase.isPSCtrlMsgIdDirty() && (bl || pSSysSearchBarBase.getPSCtrlMsgId() != null)) {
            iDataObject.set(FIELD_PSCTRLMSGID, (Object)pSSysSearchBarBase.getPSCtrlMsgId());
        }
        if (pSSysSearchBarBase.isPSCtrlMsgNameDirty() && (bl || pSSysSearchBarBase.getPSCtrlMsgName() != null)) {
            iDataObject.set(FIELD_PSCTRLMSGNAME, (Object)pSSysSearchBarBase.getPSCtrlMsgName());
        }
        if (pSSysSearchBarBase.isPSDEIdDirty() && (bl || pSSysSearchBarBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysSearchBarBase.getPSDEId());
        }
        if (pSSysSearchBarBase.isPSDENameDirty() && (bl || pSSysSearchBarBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSSysSearchBarBase.getPSDEName());
        }
        if (pSSysSearchBarBase.isPSModuleIdDirty() && (bl || pSSysSearchBarBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysSearchBarBase.getPSModuleId());
        }
        if (pSSysSearchBarBase.isPSModuleNameDirty() && (bl || pSSysSearchBarBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysSearchBarBase.getPSModuleName());
        }
        if (pSSysSearchBarBase.isPSSysCounterIdDirty() && (bl || pSSysSearchBarBase.getPSSysCounterId() != null)) {
            iDataObject.set(FIELD_PSSYSCOUNTERID, (Object)pSSysSearchBarBase.getPSSysCounterId());
        }
        if (pSSysSearchBarBase.isPSSysCounterNameDirty() && (bl || pSSysSearchBarBase.getPSSysCounterName() != null)) {
            iDataObject.set(FIELD_PSSYSCOUNTERNAME, (Object)pSSysSearchBarBase.getPSSysCounterName());
        }
        if (pSSysSearchBarBase.isPSSysCssIdDirty() && (bl || pSSysSearchBarBase.getPSSysCssId() != null)) {
            iDataObject.set(FIELD_PSSYSCSSID, (Object)pSSysSearchBarBase.getPSSysCssId());
        }
        if (pSSysSearchBarBase.isPSSysCssNameDirty() && (bl || pSSysSearchBarBase.getPSSysCssName() != null)) {
            iDataObject.set(FIELD_PSSYSCSSNAME, (Object)pSSysSearchBarBase.getPSSysCssName());
        }
        if (pSSysSearchBarBase.isPSSysPFPluginIdDirty() && (bl || pSSysSearchBarBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSSysSearchBarBase.getPSSysPFPluginId());
        }
        if (pSSysSearchBarBase.isPSSysPFPluginNameDirty() && (bl || pSSysSearchBarBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSSysSearchBarBase.getPSSysPFPluginName());
        }
        if (pSSysSearchBarBase.isPSSysSearchBarIdDirty() && (bl || pSSysSearchBarBase.getPSSysSearchBarId() != null)) {
            iDataObject.set(FIELD_PSSYSSEARCHBARID, (Object)pSSysSearchBarBase.getPSSysSearchBarId());
        }
        if (pSSysSearchBarBase.isPSSysSearchBarNameDirty() && (bl || pSSysSearchBarBase.getPSSysSearchBarName() != null)) {
            iDataObject.set(FIELD_PSSYSSEARCHBARNAME, (Object)pSSysSearchBarBase.getPSSysSearchBarName());
        }
        if (pSSysSearchBarBase.isPSSystemIdDirty() && (bl || pSSysSearchBarBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysSearchBarBase.getPSSystemId());
        }
        if (pSSysSearchBarBase.isPSSystemNameDirty() && (bl || pSSysSearchBarBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysSearchBarBase.getPSSystemName());
        }
        if (pSSysSearchBarBase.isPSViewMsgGroupIdDirty() && (bl || pSSysSearchBarBase.getPSViewMsgGroupId() != null)) {
            iDataObject.set(FIELD_PSVIEWMSGGROUPID, (Object)pSSysSearchBarBase.getPSViewMsgGroupId());
        }
        if (pSSysSearchBarBase.isPSViewMsgGroupNameDirty() && (bl || pSSysSearchBarBase.getPSViewMsgGroupName() != null)) {
            iDataObject.set(FIELD_PSVIEWMSGGROUPNAME, (Object)pSSysSearchBarBase.getPSViewMsgGroupName());
        }
        if (pSSysSearchBarBase.isQuickGroupCntDirty() && (bl || pSSysSearchBarBase.getQuickGroupCnt() != null)) {
            iDataObject.set(FIELD_QUICKGROUPCNT, (Object)pSSysSearchBarBase.getQuickGroupCnt());
        }
        if (pSSysSearchBarBase.isQuickSearchWidthDirty() && (bl || pSSysSearchBarBase.getQuickSearchWidth() != null)) {
            iDataObject.set(FIELD_QUICKSEARCHWIDTH, (Object)pSSysSearchBarBase.getQuickSearchWidth());
        }
        if (pSSysSearchBarBase.isUpdateDateDirty() && (bl || pSSysSearchBarBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysSearchBarBase.getUpdateDate());
        }
        if (pSSysSearchBarBase.isUpdateManDirty() && (bl || pSSysSearchBarBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysSearchBarBase.getUpdateMan());
        }
        if (pSSysSearchBarBase.isUserTagDirty() && (bl || pSSysSearchBarBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysSearchBarBase.getUserTag());
        }
        if (pSSysSearchBarBase.isUserTag2Dirty() && (bl || pSSysSearchBarBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysSearchBarBase.getUserTag2());
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
        return PSSysSearchBarBase.remove(this, n);
    }

    private static boolean remove(PSSysSearchBarBase pSSysSearchBarBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysSearchBarBase.resetBarStyle();
                return true;
            }
            case 1: {
                pSSysSearchBarBase.resetBusyIndicator();
                return true;
            }
            case 2: {
                pSSysSearchBarBase.resetCodeName();
                return true;
            }
            case 3: {
                pSSysSearchBarBase.resetCreateDate();
                return true;
            }
            case 4: {
                pSSysSearchBarBase.resetCreateMan();
                return true;
            }
            case 5: {
                pSSysSearchBarBase.resetEnableCustomized();
                return true;
            }
            case 6: {
                pSSysSearchBarBase.resetEnableQuickSearch();
                return true;
            }
            case 7: {
                pSSysSearchBarBase.resetGroupMode();
                return true;
            }
            case 8: {
                pSSysSearchBarBase.resetGroupMoreText();
                return true;
            }
            case 9: {
                pSSysSearchBarBase.resetGroupMoreTextPSLanResId();
                return true;
            }
            case 10: {
                pSSysSearchBarBase.resetGroupMoreTextPSLanResName();
                return true;
            }
            case 11: {
                pSSysSearchBarBase.resetLockFlag();
                return true;
            }
            case 12: {
                pSSysSearchBarBase.resetMemo();
                return true;
            }
            case 13: {
                pSSysSearchBarBase.resetMobFlag();
                return true;
            }
            case 14: {
                pSSysSearchBarBase.resetPSCtrlLogicGroupId();
                return true;
            }
            case 15: {
                pSSysSearchBarBase.resetPSCtrlLogicGroupName();
                return true;
            }
            case 16: {
                pSSysSearchBarBase.resetPSCtrlMsgId();
                return true;
            }
            case 17: {
                pSSysSearchBarBase.resetPSCtrlMsgName();
                return true;
            }
            case 18: {
                pSSysSearchBarBase.resetPSDEId();
                return true;
            }
            case 19: {
                pSSysSearchBarBase.resetPSDEName();
                return true;
            }
            case 20: {
                pSSysSearchBarBase.resetPSModuleId();
                return true;
            }
            case 21: {
                pSSysSearchBarBase.resetPSModuleName();
                return true;
            }
            case 22: {
                pSSysSearchBarBase.resetPSSysCounterId();
                return true;
            }
            case 23: {
                pSSysSearchBarBase.resetPSSysCounterName();
                return true;
            }
            case 24: {
                pSSysSearchBarBase.resetPSSysCssId();
                return true;
            }
            case 25: {
                pSSysSearchBarBase.resetPSSysCssName();
                return true;
            }
            case 26: {
                pSSysSearchBarBase.resetPSSysPFPluginId();
                return true;
            }
            case 27: {
                pSSysSearchBarBase.resetPSSysPFPluginName();
                return true;
            }
            case 28: {
                pSSysSearchBarBase.resetPSSysSearchBarId();
                return true;
            }
            case 29: {
                pSSysSearchBarBase.resetPSSysSearchBarName();
                return true;
            }
            case 30: {
                pSSysSearchBarBase.resetPSSystemId();
                return true;
            }
            case 31: {
                pSSysSearchBarBase.resetPSSystemName();
                return true;
            }
            case 32: {
                pSSysSearchBarBase.resetPSViewMsgGroupId();
                return true;
            }
            case 33: {
                pSSysSearchBarBase.resetPSViewMsgGroupName();
                return true;
            }
            case 34: {
                pSSysSearchBarBase.resetQuickGroupCnt();
                return true;
            }
            case 35: {
                pSSysSearchBarBase.resetQuickSearchWidth();
                return true;
            }
            case 36: {
                pSSysSearchBarBase.resetUpdateDate();
                return true;
            }
            case 37: {
                pSSysSearchBarBase.resetUpdateMan();
                return true;
            }
            case 38: {
                pSSysSearchBarBase.resetUserTag();
                return true;
            }
            case 39: {
                pSSysSearchBarBase.resetUserTag2();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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
    public PSLanguageRes getGroupMoreTextPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupMoreTextPSLanRes();
        }
        if (this.getGroupMoreTextPSLanResId() == null) {
            return null;
        }
        Integer n = this.objGroupMoreTextPSLanResLock;
        synchronized (n) {
            if (this.groupmoretextpslanres != null && DataTypeHelper.compare((int)25, (Object)this.getGroupMoreTextPSLanResId(), (Object)this.groupmoretextpslanres.getPSLanguageResId()) != 0L) {
                this.groupmoretextpslanres = null;
            }
            if (this.groupmoretextpslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getGroupMoreTextPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet(pSLanguageRes);
                this.groupmoretextpslanres = pSLanguageRes;
            }
            return this.groupmoretextpslanres;
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
                pSViewMsgGroupService.autoGet(pSViewMsgGroup);
                this.psviewmsggroup = pSViewMsgGroup;
            }
            return this.psviewmsggroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysSearchBarItem> getPSSysSearchBarItems() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchBarItems();
        }
        if (this.getPSSysSearchBarId() == null) {
            return null;
        }
        PSSysSearchBarService pSSysSearchBarService = (PSSysSearchBarService)ServiceGlobal.getService(PSSysSearchBarService.class, (SessionFactory)this.getSessionFactory());
        PSSysSearchBarItemService pSSysSearchBarItemService = (PSSysSearchBarItemService)ServiceGlobal.getService(PSSysSearchBarItemService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysSearchBarItemsLock;
        synchronized (n) {
            if (this.pssyssearchbaritems == null) {
                this.pssyssearchbaritems = pSSysSearchBarService.isTempData(this) ? pSSysSearchBarItemService.selectTempByPSSysSearchBar(this) : pSSysSearchBarItemService.selectByPSSysSearchBar(this);
            }
            return this.pssyssearchbaritems;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysSearchBarLogic> getPSSysSearchBarLogics() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchBarLogics();
        }
        if (this.getPSSysSearchBarId() == null) {
            return null;
        }
        PSSysSearchBarService pSSysSearchBarService = (PSSysSearchBarService)ServiceGlobal.getService(PSSysSearchBarService.class, (SessionFactory)this.getSessionFactory());
        PSSysSearchBarLogicService pSSysSearchBarLogicService = (PSSysSearchBarLogicService)ServiceGlobal.getService(PSSysSearchBarLogicService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysSearchBarLogicsLock;
        synchronized (n) {
            if (this.pssyssearchbarlogics == null) {
                this.pssyssearchbarlogics = pSSysSearchBarService.isTempData(this) ? pSSysSearchBarLogicService.selectTempByPSSysSearchBar(this) : pSSysSearchBarLogicService.selectByPSSysSearchBar(this);
            }
            return this.pssyssearchbarlogics;
        }
    }

    private PSSysSearchBarBase getProxyEntity() {
        return this.proxyPSSysSearchBarBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysSearchBarBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysSearchBarBase) {
            this.proxyPSSysSearchBarBase = (PSSysSearchBarBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSearchBarService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BARSTYLE, 0);
        fieldIndexMap.put(FIELD_BUSYINDICATOR, 1);
        fieldIndexMap.put(FIELD_CODENAME, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_ENABLECUSTOMIZED, 5);
        fieldIndexMap.put(FIELD_ENABLEQUICKSEARCH, 6);
        fieldIndexMap.put(FIELD_GROUPMODE, 7);
        fieldIndexMap.put(FIELD_GROUPMORETEXT, 8);
        fieldIndexMap.put(FIELD_GROUPMORETEXTPSLANRESID, 9);
        fieldIndexMap.put(FIELD_GROUPMORETEXTPSLANRESNAME, 10);
        fieldIndexMap.put(FIELD_LOCKFLAG, 11);
        fieldIndexMap.put(FIELD_MEMO, 12);
        fieldIndexMap.put(FIELD_MOBFLAG, 13);
        fieldIndexMap.put(FIELD_PSCTRLLOGICGROUPID, 14);
        fieldIndexMap.put(FIELD_PSCTRLLOGICGROUPNAME, 15);
        fieldIndexMap.put(FIELD_PSCTRLMSGID, 16);
        fieldIndexMap.put(FIELD_PSCTRLMSGNAME, 17);
        fieldIndexMap.put(FIELD_PSDEID, 18);
        fieldIndexMap.put(FIELD_PSDENAME, 19);
        fieldIndexMap.put(FIELD_PSMODULEID, 20);
        fieldIndexMap.put(FIELD_PSMODULENAME, 21);
        fieldIndexMap.put(FIELD_PSSYSCOUNTERID, 22);
        fieldIndexMap.put(FIELD_PSSYSCOUNTERNAME, 23);
        fieldIndexMap.put(FIELD_PSSYSCSSID, 24);
        fieldIndexMap.put(FIELD_PSSYSCSSNAME, 25);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 26);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 27);
        fieldIndexMap.put(FIELD_PSSYSSEARCHBARID, 28);
        fieldIndexMap.put(FIELD_PSSYSSEARCHBARNAME, 29);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 30);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 31);
        fieldIndexMap.put(FIELD_PSVIEWMSGGROUPID, 32);
        fieldIndexMap.put(FIELD_PSVIEWMSGGROUPNAME, 33);
        fieldIndexMap.put(FIELD_QUICKGROUPCNT, 34);
        fieldIndexMap.put(FIELD_QUICKSEARCHWIDTH, 35);
        fieldIndexMap.put(FIELD_UPDATEDATE, 36);
        fieldIndexMap.put(FIELD_UPDATEMAN, 37);
        fieldIndexMap.put(FIELD_USERTAG, 38);
        fieldIndexMap.put(FIELD_USERTAG2, 39);
    }
}

