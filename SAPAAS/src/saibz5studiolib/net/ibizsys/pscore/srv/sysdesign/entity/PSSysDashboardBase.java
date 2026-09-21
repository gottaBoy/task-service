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
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBPart;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDashboardLogic;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgGroup;
import net.ibizsys.pscore.srv.sysdesign.service.PSCtrlLogicGroupService;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBPartService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDashboardLogicService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDashboardService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGroupService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysDashboardBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysDashboardBase.class);
    public static final String FIELD_BUSYINDICATOR = "BUSYINDICATOR";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_COLMODEL = "COLMODEL";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DASHBOARDNAVBAR = "DASHBOARDNAVBAR";
    public static final String FIELD_DASHBOARDSTYLE = "DASHBOARDSTYLE";
    public static final String FIELD_DASHBOARDTAG = "DASHBOARDTAG";
    public static final String FIELD_DASHBOARDTAG2 = "DASHBOARDTAG2";
    public static final String FIELD_DBMODEL = "DBMODEL";
    public static final String FIELD_ENABLECUSTOMIZED = "ENABLECUSTOMIZED";
    public static final String FIELD_FLEXALIGN = "FLEXALIGN";
    public static final String FIELD_FLEXDIR = "FLEXDIR";
    public static final String FIELD_FLEXVALIGN = "FLEXVALIGN";
    public static final String FIELD_LAYOUTMODE = "LAYOUTMODE";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_NAVBARHEIGHT = "NAVBARHEIGHT";
    public static final String FIELD_NAVBARPOS = "NAVBARPOS";
    public static final String FIELD_NAVBARPSSYSCSSID = "NAVBARPSSYSCSSID";
    public static final String FIELD_NAVBARPSSYSCSSNAME = "NAVBARPSSYSCSSNAME";
    public static final String FIELD_NAVBARSTYLE = "NAVBARSTYLE";
    public static final String FIELD_NAVBARWIDTH = "NAVBARWIDTH";
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
    public static final String FIELD_PSSYSDASHBOARDID = "PSSYSDASHBOARDID";
    public static final String FIELD_PSSYSDASHBOARDNAME = "PSSYSDASHBOARDNAME";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSVIEWMSGGROUPID = "PSVIEWMSGGROUPID";
    public static final String FIELD_PSVIEWMSGGROUPNAME = "PSVIEWMSGGROUPNAME";
    public static final String FIELD_SYSAPPFLAG = "SYSAPPFLAG";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_BUSYINDICATOR = 0;
    private static final int INDEX_CODENAME = 1;
    private static final int INDEX_COLMODEL = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEMAN = 4;
    private static final int INDEX_DASHBOARDNAVBAR = 5;
    private static final int INDEX_DASHBOARDSTYLE = 6;
    private static final int INDEX_DASHBOARDTAG = 7;
    private static final int INDEX_DASHBOARDTAG2 = 8;
    private static final int INDEX_DBMODEL = 9;
    private static final int INDEX_ENABLECUSTOMIZED = 10;
    private static final int INDEX_FLEXALIGN = 11;
    private static final int INDEX_FLEXDIR = 12;
    private static final int INDEX_FLEXVALIGN = 13;
    private static final int INDEX_LAYOUTMODE = 14;
    private static final int INDEX_LOCKFLAG = 15;
    private static final int INDEX_MEMO = 16;
    private static final int INDEX_NAVBARHEIGHT = 17;
    private static final int INDEX_NAVBARPOS = 18;
    private static final int INDEX_NAVBARPSSYSCSSID = 19;
    private static final int INDEX_NAVBARPSSYSCSSNAME = 20;
    private static final int INDEX_NAVBARSTYLE = 21;
    private static final int INDEX_NAVBARWIDTH = 22;
    private static final int INDEX_PSCTRLLOGICGROUPID = 23;
    private static final int INDEX_PSCTRLLOGICGROUPNAME = 24;
    private static final int INDEX_PSDEID = 25;
    private static final int INDEX_PSDENAME = 26;
    private static final int INDEX_PSMODULEID = 27;
    private static final int INDEX_PSMODULENAME = 28;
    private static final int INDEX_PSSYSAPPID = 29;
    private static final int INDEX_PSSYSAPPNAME = 30;
    private static final int INDEX_PSSYSCSSID = 31;
    private static final int INDEX_PSSYSCSSNAME = 32;
    private static final int INDEX_PSSYSDASHBOARDID = 33;
    private static final int INDEX_PSSYSDASHBOARDNAME = 34;
    private static final int INDEX_PSSYSPFPLUGINID = 35;
    private static final int INDEX_PSSYSPFPLUGINNAME = 36;
    private static final int INDEX_PSSYSTEMID = 37;
    private static final int INDEX_PSSYSTEMNAME = 38;
    private static final int INDEX_PSVIEWMSGGROUPID = 39;
    private static final int INDEX_PSVIEWMSGGROUPNAME = 40;
    private static final int INDEX_SYSAPPFLAG = 41;
    private static final int INDEX_UPDATEDATE = 42;
    private static final int INDEX_UPDATEMAN = 43;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysDashboardBase proxyPSSysDashboardBase = null;
    private boolean busyindicatorDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean colmodelDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dashboardnavbarDirtyFlag = false;
    private boolean dashboardstyleDirtyFlag = false;
    private boolean dashboardtagDirtyFlag = false;
    private boolean dashboardtag2DirtyFlag = false;
    private boolean dbmodelDirtyFlag = false;
    private boolean enablecustomizedDirtyFlag = false;
    private boolean flexalignDirtyFlag = false;
    private boolean flexdirDirtyFlag = false;
    private boolean flexvalignDirtyFlag = false;
    private boolean layoutmodeDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean navbarheightDirtyFlag = false;
    private boolean navbarposDirtyFlag = false;
    private boolean navbarpssyscssidDirtyFlag = false;
    private boolean navbarpssyscssnameDirtyFlag = false;
    private boolean navbarstyleDirtyFlag = false;
    private boolean navbarwidthDirtyFlag = false;
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
    private boolean pssysdashboardidDirtyFlag = false;
    private boolean pssysdashboardnameDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean psviewmsggroupidDirtyFlag = false;
    private boolean psviewmsggroupnameDirtyFlag = false;
    private boolean sysappflagDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="busyindicator")
    private Integer busyindicator;
    @Column(name="codename")
    private String codename;
    @Column(name="colmodel")
    private String colmodel;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dashboardnavbar")
    private Integer dashboardnavbar;
    @Column(name="dashboardstyle")
    private String dashboardstyle;
    @Column(name="dashboardtag")
    private String dashboardtag;
    @Column(name="dashboardtag2")
    private String dashboardtag2;
    @Column(name="dbmodel")
    private String dbmodel;
    @Column(name="enablecustomized")
    private Integer enablecustomized;
    @Column(name="flexalign")
    private String flexalign;
    @Column(name="flexdir")
    private String flexdir;
    @Column(name="flexvalign")
    private String flexvalign;
    @Column(name="layoutmode")
    private String layoutmode;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
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
    @Column(name="pssysdashboardid")
    private String pssysdashboardid;
    @Column(name="pssysdashboardname")
    private String pssysdashboardname;
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
    @Column(name="sysappflag")
    private Integer sysappflag;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSCtrlLogicGroupLock = new Integer(1);
    private PSCtrlLogicGroup psctrllogicgroup = null;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
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
    private Integer objPSSysDashboardLogicsLock = new Integer(1);
    private ArrayList<PSSysDashboardLogic> pssysdashboardlogics = null;
    private Integer objPSSysDBPartsLock = new Integer(1);
    private ArrayList<PSSysDBPart> pssysdbparts = null;

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

    public void setColModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setColModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.colmodel = string;
        this.colmodelDirtyFlag = true;
    }

    public String getColModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getColModel();
        }
        return this.colmodel;
    }

    public boolean isColModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isColModelDirty();
        }
        return this.colmodelDirtyFlag;
    }

    public void resetColModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetColModel();
            return;
        }
        this.colmodelDirtyFlag = false;
        this.colmodel = null;
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

    public void setDashboardNavBar(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDashboardNavBar(n);
            return;
        }
        this.dashboardnavbar = n;
        this.dashboardnavbarDirtyFlag = true;
    }

    public Integer getDashboardNavBar() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDashboardNavBar();
        }
        return this.dashboardnavbar;
    }

    public boolean isDashboardNavBarDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDashboardNavBarDirty();
        }
        return this.dashboardnavbarDirtyFlag;
    }

    public void resetDashboardNavBar() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDashboardNavBar();
            return;
        }
        this.dashboardnavbarDirtyFlag = false;
        this.dashboardnavbar = null;
    }

    public void setDashboardStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDashboardStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dashboardstyle = string;
        this.dashboardstyleDirtyFlag = true;
    }

    public String getDashboardStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDashboardStyle();
        }
        return this.dashboardstyle;
    }

    public boolean isDashboardStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDashboardStyleDirty();
        }
        return this.dashboardstyleDirtyFlag;
    }

    public void resetDashboardStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDashboardStyle();
            return;
        }
        this.dashboardstyleDirtyFlag = false;
        this.dashboardstyle = null;
    }

    public void setDashboardTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDashboardTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dashboardtag = string;
        this.dashboardtagDirtyFlag = true;
    }

    public String getDashboardTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDashboardTag();
        }
        return this.dashboardtag;
    }

    public boolean isDashboardTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDashboardTagDirty();
        }
        return this.dashboardtagDirtyFlag;
    }

    public void resetDashboardTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDashboardTag();
            return;
        }
        this.dashboardtagDirtyFlag = false;
        this.dashboardtag = null;
    }

    public void setDashboardTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDashboardTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dashboardtag2 = string;
        this.dashboardtag2DirtyFlag = true;
    }

    public String getDashboardTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDashboardTag2();
        }
        return this.dashboardtag2;
    }

    public boolean isDashboardTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDashboardTag2Dirty();
        }
        return this.dashboardtag2DirtyFlag;
    }

    public void resetDashboardTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDashboardTag2();
            return;
        }
        this.dashboardtag2DirtyFlag = false;
        this.dashboardtag2 = null;
    }

    public void setDBModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDBModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dbmodel = string;
        this.dbmodelDirtyFlag = true;
    }

    public String getDBModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDBModel();
        }
        return this.dbmodel;
    }

    public boolean isDBModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDBModelDirty();
        }
        return this.dbmodelDirtyFlag;
    }

    public void resetDBModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDBModel();
            return;
        }
        this.dbmodelDirtyFlag = false;
        this.dbmodel = null;
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

    public void setFlexAlign(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFlexAlign(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.flexalign = string;
        this.flexalignDirtyFlag = true;
    }

    public String getFlexAlign() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFlexAlign();
        }
        return this.flexalign;
    }

    public boolean isFlexAlignDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFlexAlignDirty();
        }
        return this.flexalignDirtyFlag;
    }

    public void resetFlexAlign() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFlexAlign();
            return;
        }
        this.flexalignDirtyFlag = false;
        this.flexalign = null;
    }

    public void setFlexDir(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFlexDir(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.flexdir = string;
        this.flexdirDirtyFlag = true;
    }

    public String getFlexDir() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFlexDir();
        }
        return this.flexdir;
    }

    public boolean isFlexDirDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFlexDirDirty();
        }
        return this.flexdirDirtyFlag;
    }

    public void resetFlexDir() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFlexDir();
            return;
        }
        this.flexdirDirtyFlag = false;
        this.flexdir = null;
    }

    public void setFlexVAlign(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFlexVAlign(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.flexvalign = string;
        this.flexvalignDirtyFlag = true;
    }

    public String getFlexVAlign() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFlexVAlign();
        }
        return this.flexvalign;
    }

    public boolean isFlexVAlignDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFlexVAlignDirty();
        }
        return this.flexvalignDirtyFlag;
    }

    public void resetFlexVAlign() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFlexVAlign();
            return;
        }
        this.flexvalignDirtyFlag = false;
        this.flexvalign = null;
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
        PSSysDashboardBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysDashboardBase pSSysDashboardBase) {
        pSSysDashboardBase.resetBusyIndicator();
        pSSysDashboardBase.resetCodeName();
        pSSysDashboardBase.resetColModel();
        pSSysDashboardBase.resetCreateDate();
        pSSysDashboardBase.resetCreateMan();
        pSSysDashboardBase.resetDashboardNavBar();
        pSSysDashboardBase.resetDashboardStyle();
        pSSysDashboardBase.resetDashboardTag();
        pSSysDashboardBase.resetDashboardTag2();
        pSSysDashboardBase.resetDBModel();
        pSSysDashboardBase.resetEnableCustomized();
        pSSysDashboardBase.resetFlexAlign();
        pSSysDashboardBase.resetFlexDir();
        pSSysDashboardBase.resetFlexVAlign();
        pSSysDashboardBase.resetLayoutMode();
        pSSysDashboardBase.resetLockFlag();
        pSSysDashboardBase.resetMemo();
        pSSysDashboardBase.resetNavBarHeight();
        pSSysDashboardBase.resetNavBarPos();
        pSSysDashboardBase.resetNavBarPSSysCssId();
        pSSysDashboardBase.resetNavBarPSSysCssName();
        pSSysDashboardBase.resetNavBarStyle();
        pSSysDashboardBase.resetNavBarWidth();
        pSSysDashboardBase.resetPSCtrlLogicGroupId();
        pSSysDashboardBase.resetPSCtrlLogicGroupName();
        pSSysDashboardBase.resetPSDEId();
        pSSysDashboardBase.resetPSDEName();
        pSSysDashboardBase.resetPSModuleId();
        pSSysDashboardBase.resetPSModuleName();
        pSSysDashboardBase.resetPSSysAppId();
        pSSysDashboardBase.resetPSSysAppName();
        pSSysDashboardBase.resetPSSysCssId();
        pSSysDashboardBase.resetPSSysCssName();
        pSSysDashboardBase.resetPSSysDashboardId();
        pSSysDashboardBase.resetPSSysDashboardName();
        pSSysDashboardBase.resetPSSysPFPluginId();
        pSSysDashboardBase.resetPSSysPFPluginName();
        pSSysDashboardBase.resetPSSystemId();
        pSSysDashboardBase.resetPSSystemName();
        pSSysDashboardBase.resetPSViewMsgGroupId();
        pSSysDashboardBase.resetPSViewMsgGroupName();
        pSSysDashboardBase.resetSysAppFlag();
        pSSysDashboardBase.resetUpdateDate();
        pSSysDashboardBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBusyIndicatorDirty()) {
            hashMap.put(FIELD_BUSYINDICATOR, this.getBusyIndicator());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isColModelDirty()) {
            hashMap.put(FIELD_COLMODEL, this.getColModel());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDashboardNavBarDirty()) {
            hashMap.put(FIELD_DASHBOARDNAVBAR, this.getDashboardNavBar());
        }
        if (!bl || this.isDashboardStyleDirty()) {
            hashMap.put(FIELD_DASHBOARDSTYLE, this.getDashboardStyle());
        }
        if (!bl || this.isDashboardTagDirty()) {
            hashMap.put(FIELD_DASHBOARDTAG, this.getDashboardTag());
        }
        if (!bl || this.isDashboardTag2Dirty()) {
            hashMap.put(FIELD_DASHBOARDTAG2, this.getDashboardTag2());
        }
        if (!bl || this.isDBModelDirty()) {
            hashMap.put(FIELD_DBMODEL, this.getDBModel());
        }
        if (!bl || this.isEnableCustomizedDirty()) {
            hashMap.put(FIELD_ENABLECUSTOMIZED, this.getEnableCustomized());
        }
        if (!bl || this.isFlexAlignDirty()) {
            hashMap.put(FIELD_FLEXALIGN, this.getFlexAlign());
        }
        if (!bl || this.isFlexDirDirty()) {
            hashMap.put(FIELD_FLEXDIR, this.getFlexDir());
        }
        if (!bl || this.isFlexVAlignDirty()) {
            hashMap.put(FIELD_FLEXVALIGN, this.getFlexVAlign());
        }
        if (!bl || this.isLayoutModeDirty()) {
            hashMap.put(FIELD_LAYOUTMODE, this.getLayoutMode());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
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
        if (!bl || this.isPSSysDashboardIdDirty()) {
            hashMap.put(FIELD_PSSYSDASHBOARDID, this.getPSSysDashboardId());
        }
        if (!bl || this.isPSSysDashboardNameDirty()) {
            hashMap.put(FIELD_PSSYSDASHBOARDNAME, this.getPSSysDashboardName());
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
        return PSSysDashboardBase.get(this, n);
    }

    private static Object get(PSSysDashboardBase pSSysDashboardBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDashboardBase.getBusyIndicator();
            }
            case 1: {
                return pSSysDashboardBase.getCodeName();
            }
            case 2: {
                return pSSysDashboardBase.getColModel();
            }
            case 3: {
                return pSSysDashboardBase.getCreateDate();
            }
            case 4: {
                return pSSysDashboardBase.getCreateMan();
            }
            case 5: {
                return pSSysDashboardBase.getDashboardNavBar();
            }
            case 6: {
                return pSSysDashboardBase.getDashboardStyle();
            }
            case 7: {
                return pSSysDashboardBase.getDashboardTag();
            }
            case 8: {
                return pSSysDashboardBase.getDashboardTag2();
            }
            case 9: {
                return pSSysDashboardBase.getDBModel();
            }
            case 10: {
                return pSSysDashboardBase.getEnableCustomized();
            }
            case 11: {
                return pSSysDashboardBase.getFlexAlign();
            }
            case 12: {
                return pSSysDashboardBase.getFlexDir();
            }
            case 13: {
                return pSSysDashboardBase.getFlexVAlign();
            }
            case 14: {
                return pSSysDashboardBase.getLayoutMode();
            }
            case 15: {
                return pSSysDashboardBase.getLockFlag();
            }
            case 16: {
                return pSSysDashboardBase.getMemo();
            }
            case 17: {
                return pSSysDashboardBase.getNavBarHeight();
            }
            case 18: {
                return pSSysDashboardBase.getNavBarPos();
            }
            case 19: {
                return pSSysDashboardBase.getNavBarPSSysCssId();
            }
            case 20: {
                return pSSysDashboardBase.getNavBarPSSysCssName();
            }
            case 21: {
                return pSSysDashboardBase.getNavBarStyle();
            }
            case 22: {
                return pSSysDashboardBase.getNavBarWidth();
            }
            case 23: {
                return pSSysDashboardBase.getPSCtrlLogicGroupId();
            }
            case 24: {
                return pSSysDashboardBase.getPSCtrlLogicGroupName();
            }
            case 25: {
                return pSSysDashboardBase.getPSDEId();
            }
            case 26: {
                return pSSysDashboardBase.getPSDEName();
            }
            case 27: {
                return pSSysDashboardBase.getPSModuleId();
            }
            case 28: {
                return pSSysDashboardBase.getPSModuleName();
            }
            case 29: {
                return pSSysDashboardBase.getPSSysAppId();
            }
            case 30: {
                return pSSysDashboardBase.getPSSysAppName();
            }
            case 31: {
                return pSSysDashboardBase.getPSSysCssId();
            }
            case 32: {
                return pSSysDashboardBase.getPSSysCssName();
            }
            case 33: {
                return pSSysDashboardBase.getPSSysDashboardId();
            }
            case 34: {
                return pSSysDashboardBase.getPSSysDashboardName();
            }
            case 35: {
                return pSSysDashboardBase.getPSSysPFPluginId();
            }
            case 36: {
                return pSSysDashboardBase.getPSSysPFPluginName();
            }
            case 37: {
                return pSSysDashboardBase.getPSSystemId();
            }
            case 38: {
                return pSSysDashboardBase.getPSSystemName();
            }
            case 39: {
                return pSSysDashboardBase.getPSViewMsgGroupId();
            }
            case 40: {
                return pSSysDashboardBase.getPSViewMsgGroupName();
            }
            case 41: {
                return pSSysDashboardBase.getSysAppFlag();
            }
            case 42: {
                return pSSysDashboardBase.getUpdateDate();
            }
            case 43: {
                return pSSysDashboardBase.getUpdateMan();
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
        PSSysDashboardBase.set(this, n, object);
    }

    private static void set(PSSysDashboardBase pSSysDashboardBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysDashboardBase.setBusyIndicator(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSSysDashboardBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysDashboardBase.setColModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysDashboardBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSSysDashboardBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysDashboardBase.setDashboardNavBar(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSSysDashboardBase.setDashboardStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysDashboardBase.setDashboardTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysDashboardBase.setDashboardTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysDashboardBase.setDBModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysDashboardBase.setEnableCustomized(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSSysDashboardBase.setFlexAlign(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysDashboardBase.setFlexDir(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysDashboardBase.setFlexVAlign(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysDashboardBase.setLayoutMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysDashboardBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSSysDashboardBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysDashboardBase.setNavBarHeight(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSSysDashboardBase.setNavBarPos(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysDashboardBase.setNavBarPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysDashboardBase.setNavBarPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysDashboardBase.setNavBarStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysDashboardBase.setNavBarWidth(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 23: {
                pSSysDashboardBase.setPSCtrlLogicGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysDashboardBase.setPSCtrlLogicGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysDashboardBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysDashboardBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysDashboardBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysDashboardBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysDashboardBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysDashboardBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysDashboardBase.setPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysDashboardBase.setPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysDashboardBase.setPSSysDashboardId(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysDashboardBase.setPSSysDashboardName(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSysDashboardBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSSysDashboardBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSSysDashboardBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSSysDashboardBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSSysDashboardBase.setPSViewMsgGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSSysDashboardBase.setPSViewMsgGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSSysDashboardBase.setSysAppFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 42: {
                pSSysDashboardBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 43: {
                pSSysDashboardBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSysDashboardBase.isNull(this, n);
    }

    private static boolean isNull(PSSysDashboardBase pSSysDashboardBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDashboardBase.getBusyIndicator() == null;
            }
            case 1: {
                return pSSysDashboardBase.getCodeName() == null;
            }
            case 2: {
                return pSSysDashboardBase.getColModel() == null;
            }
            case 3: {
                return pSSysDashboardBase.getCreateDate() == null;
            }
            case 4: {
                return pSSysDashboardBase.getCreateMan() == null;
            }
            case 5: {
                return pSSysDashboardBase.getDashboardNavBar() == null;
            }
            case 6: {
                return pSSysDashboardBase.getDashboardStyle() == null;
            }
            case 7: {
                return pSSysDashboardBase.getDashboardTag() == null;
            }
            case 8: {
                return pSSysDashboardBase.getDashboardTag2() == null;
            }
            case 9: {
                return pSSysDashboardBase.getDBModel() == null;
            }
            case 10: {
                return pSSysDashboardBase.getEnableCustomized() == null;
            }
            case 11: {
                return pSSysDashboardBase.getFlexAlign() == null;
            }
            case 12: {
                return pSSysDashboardBase.getFlexDir() == null;
            }
            case 13: {
                return pSSysDashboardBase.getFlexVAlign() == null;
            }
            case 14: {
                return pSSysDashboardBase.getLayoutMode() == null;
            }
            case 15: {
                return pSSysDashboardBase.getLockFlag() == null;
            }
            case 16: {
                return pSSysDashboardBase.getMemo() == null;
            }
            case 17: {
                return pSSysDashboardBase.getNavBarHeight() == null;
            }
            case 18: {
                return pSSysDashboardBase.getNavBarPos() == null;
            }
            case 19: {
                return pSSysDashboardBase.getNavBarPSSysCssId() == null;
            }
            case 20: {
                return pSSysDashboardBase.getNavBarPSSysCssName() == null;
            }
            case 21: {
                return pSSysDashboardBase.getNavBarStyle() == null;
            }
            case 22: {
                return pSSysDashboardBase.getNavBarWidth() == null;
            }
            case 23: {
                return pSSysDashboardBase.getPSCtrlLogicGroupId() == null;
            }
            case 24: {
                return pSSysDashboardBase.getPSCtrlLogicGroupName() == null;
            }
            case 25: {
                return pSSysDashboardBase.getPSDEId() == null;
            }
            case 26: {
                return pSSysDashboardBase.getPSDEName() == null;
            }
            case 27: {
                return pSSysDashboardBase.getPSModuleId() == null;
            }
            case 28: {
                return pSSysDashboardBase.getPSModuleName() == null;
            }
            case 29: {
                return pSSysDashboardBase.getPSSysAppId() == null;
            }
            case 30: {
                return pSSysDashboardBase.getPSSysAppName() == null;
            }
            case 31: {
                return pSSysDashboardBase.getPSSysCssId() == null;
            }
            case 32: {
                return pSSysDashboardBase.getPSSysCssName() == null;
            }
            case 33: {
                return pSSysDashboardBase.getPSSysDashboardId() == null;
            }
            case 34: {
                return pSSysDashboardBase.getPSSysDashboardName() == null;
            }
            case 35: {
                return pSSysDashboardBase.getPSSysPFPluginId() == null;
            }
            case 36: {
                return pSSysDashboardBase.getPSSysPFPluginName() == null;
            }
            case 37: {
                return pSSysDashboardBase.getPSSystemId() == null;
            }
            case 38: {
                return pSSysDashboardBase.getPSSystemName() == null;
            }
            case 39: {
                return pSSysDashboardBase.getPSViewMsgGroupId() == null;
            }
            case 40: {
                return pSSysDashboardBase.getPSViewMsgGroupName() == null;
            }
            case 41: {
                return pSSysDashboardBase.getSysAppFlag() == null;
            }
            case 42: {
                return pSSysDashboardBase.getUpdateDate() == null;
            }
            case 43: {
                return pSSysDashboardBase.getUpdateMan() == null;
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
        return PSSysDashboardBase.contains(this, n);
    }

    private static boolean contains(PSSysDashboardBase pSSysDashboardBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDashboardBase.isBusyIndicatorDirty();
            }
            case 1: {
                return pSSysDashboardBase.isCodeNameDirty();
            }
            case 2: {
                return pSSysDashboardBase.isColModelDirty();
            }
            case 3: {
                return pSSysDashboardBase.isCreateDateDirty();
            }
            case 4: {
                return pSSysDashboardBase.isCreateManDirty();
            }
            case 5: {
                return pSSysDashboardBase.isDashboardNavBarDirty();
            }
            case 6: {
                return pSSysDashboardBase.isDashboardStyleDirty();
            }
            case 7: {
                return pSSysDashboardBase.isDashboardTagDirty();
            }
            case 8: {
                return pSSysDashboardBase.isDashboardTag2Dirty();
            }
            case 9: {
                return pSSysDashboardBase.isDBModelDirty();
            }
            case 10: {
                return pSSysDashboardBase.isEnableCustomizedDirty();
            }
            case 11: {
                return pSSysDashboardBase.isFlexAlignDirty();
            }
            case 12: {
                return pSSysDashboardBase.isFlexDirDirty();
            }
            case 13: {
                return pSSysDashboardBase.isFlexVAlignDirty();
            }
            case 14: {
                return pSSysDashboardBase.isLayoutModeDirty();
            }
            case 15: {
                return pSSysDashboardBase.isLockFlagDirty();
            }
            case 16: {
                return pSSysDashboardBase.isMemoDirty();
            }
            case 17: {
                return pSSysDashboardBase.isNavBarHeightDirty();
            }
            case 18: {
                return pSSysDashboardBase.isNavBarPosDirty();
            }
            case 19: {
                return pSSysDashboardBase.isNavBarPSSysCssIdDirty();
            }
            case 20: {
                return pSSysDashboardBase.isNavBarPSSysCssNameDirty();
            }
            case 21: {
                return pSSysDashboardBase.isNavBarStyleDirty();
            }
            case 22: {
                return pSSysDashboardBase.isNavBarWidthDirty();
            }
            case 23: {
                return pSSysDashboardBase.isPSCtrlLogicGroupIdDirty();
            }
            case 24: {
                return pSSysDashboardBase.isPSCtrlLogicGroupNameDirty();
            }
            case 25: {
                return pSSysDashboardBase.isPSDEIdDirty();
            }
            case 26: {
                return pSSysDashboardBase.isPSDENameDirty();
            }
            case 27: {
                return pSSysDashboardBase.isPSModuleIdDirty();
            }
            case 28: {
                return pSSysDashboardBase.isPSModuleNameDirty();
            }
            case 29: {
                return pSSysDashboardBase.isPSSysAppIdDirty();
            }
            case 30: {
                return pSSysDashboardBase.isPSSysAppNameDirty();
            }
            case 31: {
                return pSSysDashboardBase.isPSSysCssIdDirty();
            }
            case 32: {
                return pSSysDashboardBase.isPSSysCssNameDirty();
            }
            case 33: {
                return pSSysDashboardBase.isPSSysDashboardIdDirty();
            }
            case 34: {
                return pSSysDashboardBase.isPSSysDashboardNameDirty();
            }
            case 35: {
                return pSSysDashboardBase.isPSSysPFPluginIdDirty();
            }
            case 36: {
                return pSSysDashboardBase.isPSSysPFPluginNameDirty();
            }
            case 37: {
                return pSSysDashboardBase.isPSSystemIdDirty();
            }
            case 38: {
                return pSSysDashboardBase.isPSSystemNameDirty();
            }
            case 39: {
                return pSSysDashboardBase.isPSViewMsgGroupIdDirty();
            }
            case 40: {
                return pSSysDashboardBase.isPSViewMsgGroupNameDirty();
            }
            case 41: {
                return pSSysDashboardBase.isSysAppFlagDirty();
            }
            case 42: {
                return pSSysDashboardBase.isUpdateDateDirty();
            }
            case 43: {
                return pSSysDashboardBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysDashboardBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysDashboardBase pSSysDashboardBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysDashboardBase.getBusyIndicator() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"busyindicator", (Object)PSSysDashboardBase.getJSONValue((Object)pSSysDashboardBase.getBusyIndicator()), (boolean)false);
        }
        if (bl || pSSysDashboardBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysDashboardBase.getJSONValue((Object)pSSysDashboardBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysDashboardBase.getColModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"colmodel", (Object)PSSysDashboardBase.getJSONValue((Object)pSSysDashboardBase.getColModel()), (boolean)false);
        }
        if (bl || pSSysDashboardBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysDashboardBase.getJSONValue((Object)pSSysDashboardBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysDashboardBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysDashboardBase.getJSONValue((Object)pSSysDashboardBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysDashboardBase.getDashboardNavBar() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dashboardnavbar", (Object)PSSysDashboardBase.getJSONValue((Object)pSSysDashboardBase.getDashboardNavBar()), (boolean)false);
        }
        if (bl || pSSysDashboardBase.getDashboardStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dashboardstyle", (Object)PSSysDashboardBase.getJSONValue((Object)pSSysDashboardBase.getDashboardStyle()), (boolean)false);
        }
        if (bl || pSSysDashboardBase.getDashboardTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dashboardtag", (Object)PSSysDashboardBase.getJSONValue((Object)pSSysDashboardBase.getDashboardTag()), (boolean)false);
        }
        if (bl || pSSysDashboardBase.getDashboardTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dashboardtag2", (Object)PSSysDashboardBase.getJSONValue((Object)pSSysDashboardBase.getDashboardTag2()), (boolean)false);
        }
        if (bl || pSSysDashboardBase.getDBModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dbmodel", (Object)PSSysDashboardBase.getJSONValue((Object)pSSysDashboardBase.getDBModel()), (boolean)false);
        }
        if (bl || pSSysDashboardBase.getEnableCustomized() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablecustomized", (Object)PSSysDashboardBase.getJSONValue((Object)pSSysDashboardBase.getEnableCustomized()), (boolean)false);
        }
        if (bl || pSSysDashboardBase.getFlexAlign() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"flexalign", (Object)PSSysDashboardBase.getJSONValue((Object)pSSysDashboardBase.getFlexAlign()), (boolean)false);
        }
        if (bl || pSSysDashboardBase.getFlexDir() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"flexdir", (Object)PSSysDashboardBase.getJSONValue((Object)pSSysDashboardBase.getFlexDir()), (boolean)false);
        }
        if (bl || pSSysDashboardBase.getFlexVAlign() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"flexvalign", (Object)PSSysDashboardBase.getJSONValue((Object)pSSysDashboardBase.getFlexVAlign()), (boolean)false);
        }
        if (bl || pSSysDashboardBase.getLayoutMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"layoutmode", (Object)PSSysDashboardBase.getJSONValue((Object)pSSysDashboardBase.getLayoutMode()), (boolean)false);
        }
        if (bl || pSSysDashboardBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSSysDashboardBase.getJSONValue((Object)pSSysDashboardBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSSysDashboardBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysDashboardBase.getJSONValue((Object)pSSysDashboardBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysDashboardBase.getNavBarHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navbarheight", (Object)PSSysDashboardBase.getJSONValue((Object)pSSysDashboardBase.getNavBarHeight()), (boolean)false);
        }
        if (bl || pSSysDashboardBase.getNavBarPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navbarpos", (Object)PSSysDashboardBase.getJSONValue((Object)pSSysDashboardBase.getNavBarPos()), (boolean)false);
        }
        if (bl || pSSysDashboardBase.getNavBarPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navbarpssyscssid", (Object)PSSysDashboardBase.getJSONValue((Object)pSSysDashboardBase.getNavBarPSSysCssId()), (boolean)false);
        }
        if (bl || pSSysDashboardBase.getNavBarPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navbarpssyscssname", (Object)PSSysDashboardBase.getJSONValue((Object)pSSysDashboardBase.getNavBarPSSysCssName()), (boolean)false);
        }
        if (bl || pSSysDashboardBase.getNavBarStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navbarstyle", (Object)PSSysDashboardBase.getJSONValue((Object)pSSysDashboardBase.getNavBarStyle()), (boolean)false);
        }
        if (bl || pSSysDashboardBase.getNavBarWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navbarwidth", (Object)PSSysDashboardBase.getJSONValue((Object)pSSysDashboardBase.getNavBarWidth()), (boolean)false);
        }
        if (bl || pSSysDashboardBase.getPSCtrlLogicGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrllogicgroupid", (Object)PSSysDashboardBase.getJSONValue((Object)pSSysDashboardBase.getPSCtrlLogicGroupId()), (boolean)false);
        }
        if (bl || pSSysDashboardBase.getPSCtrlLogicGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrllogicgroupname", (Object)PSSysDashboardBase.getJSONValue((Object)pSSysDashboardBase.getPSCtrlLogicGroupName()), (boolean)false);
        }
        if (bl || pSSysDashboardBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysDashboardBase.getJSONValue((Object)pSSysDashboardBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysDashboardBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSSysDashboardBase.getJSONValue((Object)pSSysDashboardBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSSysDashboardBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysDashboardBase.getJSONValue((Object)pSSysDashboardBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysDashboardBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysDashboardBase.getJSONValue((Object)pSSysDashboardBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysDashboardBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSSysDashboardBase.getJSONValue((Object)pSSysDashboardBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSSysDashboardBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSSysDashboardBase.getJSONValue((Object)pSSysDashboardBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSSysDashboardBase.getPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssid", (Object)PSSysDashboardBase.getJSONValue((Object)pSSysDashboardBase.getPSSysCssId()), (boolean)false);
        }
        if (bl || pSSysDashboardBase.getPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssname", (Object)PSSysDashboardBase.getJSONValue((Object)pSSysDashboardBase.getPSSysCssName()), (boolean)false);
        }
        if (bl || pSSysDashboardBase.getPSSysDashboardId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdashboardid", (Object)PSSysDashboardBase.getJSONValue((Object)pSSysDashboardBase.getPSSysDashboardId()), (boolean)false);
        }
        if (bl || pSSysDashboardBase.getPSSysDashboardName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdashboardname", (Object)PSSysDashboardBase.getJSONValue((Object)pSSysDashboardBase.getPSSysDashboardName()), (boolean)false);
        }
        if (bl || pSSysDashboardBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSSysDashboardBase.getJSONValue((Object)pSSysDashboardBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSSysDashboardBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSSysDashboardBase.getJSONValue((Object)pSSysDashboardBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSSysDashboardBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysDashboardBase.getJSONValue((Object)pSSysDashboardBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysDashboardBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysDashboardBase.getJSONValue((Object)pSSysDashboardBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysDashboardBase.getPSViewMsgGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewmsggroupid", (Object)PSSysDashboardBase.getJSONValue((Object)pSSysDashboardBase.getPSViewMsgGroupId()), (boolean)false);
        }
        if (bl || pSSysDashboardBase.getPSViewMsgGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewmsggroupname", (Object)PSSysDashboardBase.getJSONValue((Object)pSSysDashboardBase.getPSViewMsgGroupName()), (boolean)false);
        }
        if (bl || pSSysDashboardBase.getSysAppFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sysappflag", (Object)PSSysDashboardBase.getJSONValue((Object)pSSysDashboardBase.getSysAppFlag()), (boolean)false);
        }
        if (bl || pSSysDashboardBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysDashboardBase.getJSONValue((Object)pSSysDashboardBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysDashboardBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysDashboardBase.getJSONValue((Object)pSSysDashboardBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysDashboardBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysDashboardBase pSSysDashboardBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysDashboardBase.getBusyIndicator() != null) {
            object = pSSysDashboardBase.getBusyIndicator();
            xmlNode.setAttribute(FIELD_BUSYINDICATOR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDashboardBase.getCodeName() != null) {
            object = pSSysDashboardBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardBase.getColModel() != null) {
            object = pSSysDashboardBase.getColModel();
            xmlNode.setAttribute(FIELD_COLMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardBase.getCreateDate() != null) {
            object = pSSysDashboardBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDashboardBase.getCreateMan() != null) {
            object = pSSysDashboardBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardBase.getDashboardNavBar() != null) {
            object = pSSysDashboardBase.getDashboardNavBar();
            xmlNode.setAttribute(FIELD_DASHBOARDNAVBAR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDashboardBase.getDashboardStyle() != null) {
            object = pSSysDashboardBase.getDashboardStyle();
            xmlNode.setAttribute(FIELD_DASHBOARDSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardBase.getDashboardTag() != null) {
            object = pSSysDashboardBase.getDashboardTag();
            xmlNode.setAttribute(FIELD_DASHBOARDTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardBase.getDashboardTag2() != null) {
            object = pSSysDashboardBase.getDashboardTag2();
            xmlNode.setAttribute(FIELD_DASHBOARDTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardBase.getDBModel() != null) {
            object = pSSysDashboardBase.getDBModel();
            xmlNode.setAttribute(FIELD_DBMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardBase.getEnableCustomized() != null) {
            object = pSSysDashboardBase.getEnableCustomized();
            xmlNode.setAttribute(FIELD_ENABLECUSTOMIZED, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDashboardBase.getFlexAlign() != null) {
            object = pSSysDashboardBase.getFlexAlign();
            xmlNode.setAttribute(FIELD_FLEXALIGN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardBase.getFlexDir() != null) {
            object = pSSysDashboardBase.getFlexDir();
            xmlNode.setAttribute(FIELD_FLEXDIR, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardBase.getFlexVAlign() != null) {
            object = pSSysDashboardBase.getFlexVAlign();
            xmlNode.setAttribute(FIELD_FLEXVALIGN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardBase.getLayoutMode() != null) {
            object = pSSysDashboardBase.getLayoutMode();
            xmlNode.setAttribute(FIELD_LAYOUTMODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardBase.getLockFlag() != null) {
            object = pSSysDashboardBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDashboardBase.getMemo() != null) {
            object = pSSysDashboardBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardBase.getNavBarHeight() != null) {
            object = pSSysDashboardBase.getNavBarHeight();
            xmlNode.setAttribute(FIELD_NAVBARHEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDashboardBase.getNavBarPos() != null) {
            object = pSSysDashboardBase.getNavBarPos();
            xmlNode.setAttribute(FIELD_NAVBARPOS, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardBase.getNavBarPSSysCssId() != null) {
            object = pSSysDashboardBase.getNavBarPSSysCssId();
            xmlNode.setAttribute(FIELD_NAVBARPSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardBase.getNavBarPSSysCssName() != null) {
            object = pSSysDashboardBase.getNavBarPSSysCssName();
            xmlNode.setAttribute(FIELD_NAVBARPSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardBase.getNavBarStyle() != null) {
            object = pSSysDashboardBase.getNavBarStyle();
            xmlNode.setAttribute(FIELD_NAVBARSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardBase.getNavBarWidth() != null) {
            object = pSSysDashboardBase.getNavBarWidth();
            xmlNode.setAttribute(FIELD_NAVBARWIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDashboardBase.getPSCtrlLogicGroupId() != null) {
            object = pSSysDashboardBase.getPSCtrlLogicGroupId();
            xmlNode.setAttribute(FIELD_PSCTRLLOGICGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardBase.getPSCtrlLogicGroupName() != null) {
            object = pSSysDashboardBase.getPSCtrlLogicGroupName();
            xmlNode.setAttribute(FIELD_PSCTRLLOGICGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardBase.getPSDEId() != null) {
            object = pSSysDashboardBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardBase.getPSDEName() != null) {
            object = pSSysDashboardBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardBase.getPSModuleId() != null) {
            object = pSSysDashboardBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardBase.getPSModuleName() != null) {
            object = pSSysDashboardBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardBase.getPSSysAppId() != null) {
            object = pSSysDashboardBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardBase.getPSSysAppName() != null) {
            object = pSSysDashboardBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardBase.getPSSysCssId() != null) {
            object = pSSysDashboardBase.getPSSysCssId();
            xmlNode.setAttribute(FIELD_PSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardBase.getPSSysCssName() != null) {
            object = pSSysDashboardBase.getPSSysCssName();
            xmlNode.setAttribute(FIELD_PSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardBase.getPSSysDashboardId() != null) {
            object = pSSysDashboardBase.getPSSysDashboardId();
            xmlNode.setAttribute(FIELD_PSSYSDASHBOARDID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardBase.getPSSysDashboardName() != null) {
            object = pSSysDashboardBase.getPSSysDashboardName();
            xmlNode.setAttribute(FIELD_PSSYSDASHBOARDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardBase.getPSSysPFPluginId() != null) {
            object = pSSysDashboardBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardBase.getPSSysPFPluginName() != null) {
            object = pSSysDashboardBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardBase.getPSSystemId() != null) {
            object = pSSysDashboardBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardBase.getPSSystemName() != null) {
            object = pSSysDashboardBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardBase.getPSViewMsgGroupId() != null) {
            object = pSSysDashboardBase.getPSViewMsgGroupId();
            xmlNode.setAttribute(FIELD_PSVIEWMSGGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardBase.getPSViewMsgGroupName() != null) {
            object = pSSysDashboardBase.getPSViewMsgGroupName();
            xmlNode.setAttribute(FIELD_PSVIEWMSGGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardBase.getSysAppFlag() != null) {
            object = pSSysDashboardBase.getSysAppFlag();
            xmlNode.setAttribute(FIELD_SYSAPPFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDashboardBase.getUpdateDate() != null) {
            object = pSSysDashboardBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDashboardBase.getUpdateMan() != null) {
            object = pSSysDashboardBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysDashboardBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysDashboardBase pSSysDashboardBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysDashboardBase.isBusyIndicatorDirty() && (bl || pSSysDashboardBase.getBusyIndicator() != null)) {
            iDataObject.set(FIELD_BUSYINDICATOR, (Object)pSSysDashboardBase.getBusyIndicator());
        }
        if (pSSysDashboardBase.isCodeNameDirty() && (bl || pSSysDashboardBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysDashboardBase.getCodeName());
        }
        if (pSSysDashboardBase.isColModelDirty() && (bl || pSSysDashboardBase.getColModel() != null)) {
            iDataObject.set(FIELD_COLMODEL, (Object)pSSysDashboardBase.getColModel());
        }
        if (pSSysDashboardBase.isCreateDateDirty() && (bl || pSSysDashboardBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysDashboardBase.getCreateDate());
        }
        if (pSSysDashboardBase.isCreateManDirty() && (bl || pSSysDashboardBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysDashboardBase.getCreateMan());
        }
        if (pSSysDashboardBase.isDashboardNavBarDirty() && (bl || pSSysDashboardBase.getDashboardNavBar() != null)) {
            iDataObject.set(FIELD_DASHBOARDNAVBAR, (Object)pSSysDashboardBase.getDashboardNavBar());
        }
        if (pSSysDashboardBase.isDashboardStyleDirty() && (bl || pSSysDashboardBase.getDashboardStyle() != null)) {
            iDataObject.set(FIELD_DASHBOARDSTYLE, (Object)pSSysDashboardBase.getDashboardStyle());
        }
        if (pSSysDashboardBase.isDashboardTagDirty() && (bl || pSSysDashboardBase.getDashboardTag() != null)) {
            iDataObject.set(FIELD_DASHBOARDTAG, (Object)pSSysDashboardBase.getDashboardTag());
        }
        if (pSSysDashboardBase.isDashboardTag2Dirty() && (bl || pSSysDashboardBase.getDashboardTag2() != null)) {
            iDataObject.set(FIELD_DASHBOARDTAG2, (Object)pSSysDashboardBase.getDashboardTag2());
        }
        if (pSSysDashboardBase.isDBModelDirty() && (bl || pSSysDashboardBase.getDBModel() != null)) {
            iDataObject.set(FIELD_DBMODEL, (Object)pSSysDashboardBase.getDBModel());
        }
        if (pSSysDashboardBase.isEnableCustomizedDirty() && (bl || pSSysDashboardBase.getEnableCustomized() != null)) {
            iDataObject.set(FIELD_ENABLECUSTOMIZED, (Object)pSSysDashboardBase.getEnableCustomized());
        }
        if (pSSysDashboardBase.isFlexAlignDirty() && (bl || pSSysDashboardBase.getFlexAlign() != null)) {
            iDataObject.set(FIELD_FLEXALIGN, (Object)pSSysDashboardBase.getFlexAlign());
        }
        if (pSSysDashboardBase.isFlexDirDirty() && (bl || pSSysDashboardBase.getFlexDir() != null)) {
            iDataObject.set(FIELD_FLEXDIR, (Object)pSSysDashboardBase.getFlexDir());
        }
        if (pSSysDashboardBase.isFlexVAlignDirty() && (bl || pSSysDashboardBase.getFlexVAlign() != null)) {
            iDataObject.set(FIELD_FLEXVALIGN, (Object)pSSysDashboardBase.getFlexVAlign());
        }
        if (pSSysDashboardBase.isLayoutModeDirty() && (bl || pSSysDashboardBase.getLayoutMode() != null)) {
            iDataObject.set(FIELD_LAYOUTMODE, (Object)pSSysDashboardBase.getLayoutMode());
        }
        if (pSSysDashboardBase.isLockFlagDirty() && (bl || pSSysDashboardBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSSysDashboardBase.getLockFlag());
        }
        if (pSSysDashboardBase.isMemoDirty() && (bl || pSSysDashboardBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysDashboardBase.getMemo());
        }
        if (pSSysDashboardBase.isNavBarHeightDirty() && (bl || pSSysDashboardBase.getNavBarHeight() != null)) {
            iDataObject.set(FIELD_NAVBARHEIGHT, (Object)pSSysDashboardBase.getNavBarHeight());
        }
        if (pSSysDashboardBase.isNavBarPosDirty() && (bl || pSSysDashboardBase.getNavBarPos() != null)) {
            iDataObject.set(FIELD_NAVBARPOS, (Object)pSSysDashboardBase.getNavBarPos());
        }
        if (pSSysDashboardBase.isNavBarPSSysCssIdDirty() && (bl || pSSysDashboardBase.getNavBarPSSysCssId() != null)) {
            iDataObject.set(FIELD_NAVBARPSSYSCSSID, (Object)pSSysDashboardBase.getNavBarPSSysCssId());
        }
        if (pSSysDashboardBase.isNavBarPSSysCssNameDirty() && (bl || pSSysDashboardBase.getNavBarPSSysCssName() != null)) {
            iDataObject.set(FIELD_NAVBARPSSYSCSSNAME, (Object)pSSysDashboardBase.getNavBarPSSysCssName());
        }
        if (pSSysDashboardBase.isNavBarStyleDirty() && (bl || pSSysDashboardBase.getNavBarStyle() != null)) {
            iDataObject.set(FIELD_NAVBARSTYLE, (Object)pSSysDashboardBase.getNavBarStyle());
        }
        if (pSSysDashboardBase.isNavBarWidthDirty() && (bl || pSSysDashboardBase.getNavBarWidth() != null)) {
            iDataObject.set(FIELD_NAVBARWIDTH, (Object)pSSysDashboardBase.getNavBarWidth());
        }
        if (pSSysDashboardBase.isPSCtrlLogicGroupIdDirty() && (bl || pSSysDashboardBase.getPSCtrlLogicGroupId() != null)) {
            iDataObject.set(FIELD_PSCTRLLOGICGROUPID, (Object)pSSysDashboardBase.getPSCtrlLogicGroupId());
        }
        if (pSSysDashboardBase.isPSCtrlLogicGroupNameDirty() && (bl || pSSysDashboardBase.getPSCtrlLogicGroupName() != null)) {
            iDataObject.set(FIELD_PSCTRLLOGICGROUPNAME, (Object)pSSysDashboardBase.getPSCtrlLogicGroupName());
        }
        if (pSSysDashboardBase.isPSDEIdDirty() && (bl || pSSysDashboardBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysDashboardBase.getPSDEId());
        }
        if (pSSysDashboardBase.isPSDENameDirty() && (bl || pSSysDashboardBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSSysDashboardBase.getPSDEName());
        }
        if (pSSysDashboardBase.isPSModuleIdDirty() && (bl || pSSysDashboardBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysDashboardBase.getPSModuleId());
        }
        if (pSSysDashboardBase.isPSModuleNameDirty() && (bl || pSSysDashboardBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysDashboardBase.getPSModuleName());
        }
        if (pSSysDashboardBase.isPSSysAppIdDirty() && (bl || pSSysDashboardBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSSysDashboardBase.getPSSysAppId());
        }
        if (pSSysDashboardBase.isPSSysAppNameDirty() && (bl || pSSysDashboardBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSSysDashboardBase.getPSSysAppName());
        }
        if (pSSysDashboardBase.isPSSysCssIdDirty() && (bl || pSSysDashboardBase.getPSSysCssId() != null)) {
            iDataObject.set(FIELD_PSSYSCSSID, (Object)pSSysDashboardBase.getPSSysCssId());
        }
        if (pSSysDashboardBase.isPSSysCssNameDirty() && (bl || pSSysDashboardBase.getPSSysCssName() != null)) {
            iDataObject.set(FIELD_PSSYSCSSNAME, (Object)pSSysDashboardBase.getPSSysCssName());
        }
        if (pSSysDashboardBase.isPSSysDashboardIdDirty() && (bl || pSSysDashboardBase.getPSSysDashboardId() != null)) {
            iDataObject.set(FIELD_PSSYSDASHBOARDID, (Object)pSSysDashboardBase.getPSSysDashboardId());
        }
        if (pSSysDashboardBase.isPSSysDashboardNameDirty() && (bl || pSSysDashboardBase.getPSSysDashboardName() != null)) {
            iDataObject.set(FIELD_PSSYSDASHBOARDNAME, (Object)pSSysDashboardBase.getPSSysDashboardName());
        }
        if (pSSysDashboardBase.isPSSysPFPluginIdDirty() && (bl || pSSysDashboardBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSSysDashboardBase.getPSSysPFPluginId());
        }
        if (pSSysDashboardBase.isPSSysPFPluginNameDirty() && (bl || pSSysDashboardBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSSysDashboardBase.getPSSysPFPluginName());
        }
        if (pSSysDashboardBase.isPSSystemIdDirty() && (bl || pSSysDashboardBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysDashboardBase.getPSSystemId());
        }
        if (pSSysDashboardBase.isPSSystemNameDirty() && (bl || pSSysDashboardBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysDashboardBase.getPSSystemName());
        }
        if (pSSysDashboardBase.isPSViewMsgGroupIdDirty() && (bl || pSSysDashboardBase.getPSViewMsgGroupId() != null)) {
            iDataObject.set(FIELD_PSVIEWMSGGROUPID, (Object)pSSysDashboardBase.getPSViewMsgGroupId());
        }
        if (pSSysDashboardBase.isPSViewMsgGroupNameDirty() && (bl || pSSysDashboardBase.getPSViewMsgGroupName() != null)) {
            iDataObject.set(FIELD_PSVIEWMSGGROUPNAME, (Object)pSSysDashboardBase.getPSViewMsgGroupName());
        }
        if (pSSysDashboardBase.isSysAppFlagDirty() && (bl || pSSysDashboardBase.getSysAppFlag() != null)) {
            iDataObject.set(FIELD_SYSAPPFLAG, (Object)pSSysDashboardBase.getSysAppFlag());
        }
        if (pSSysDashboardBase.isUpdateDateDirty() && (bl || pSSysDashboardBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysDashboardBase.getUpdateDate());
        }
        if (pSSysDashboardBase.isUpdateManDirty() && (bl || pSSysDashboardBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysDashboardBase.getUpdateMan());
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
        return PSSysDashboardBase.remove(this, n);
    }

    private static boolean remove(PSSysDashboardBase pSSysDashboardBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysDashboardBase.resetBusyIndicator();
                return true;
            }
            case 1: {
                pSSysDashboardBase.resetCodeName();
                return true;
            }
            case 2: {
                pSSysDashboardBase.resetColModel();
                return true;
            }
            case 3: {
                pSSysDashboardBase.resetCreateDate();
                return true;
            }
            case 4: {
                pSSysDashboardBase.resetCreateMan();
                return true;
            }
            case 5: {
                pSSysDashboardBase.resetDashboardNavBar();
                return true;
            }
            case 6: {
                pSSysDashboardBase.resetDashboardStyle();
                return true;
            }
            case 7: {
                pSSysDashboardBase.resetDashboardTag();
                return true;
            }
            case 8: {
                pSSysDashboardBase.resetDashboardTag2();
                return true;
            }
            case 9: {
                pSSysDashboardBase.resetDBModel();
                return true;
            }
            case 10: {
                pSSysDashboardBase.resetEnableCustomized();
                return true;
            }
            case 11: {
                pSSysDashboardBase.resetFlexAlign();
                return true;
            }
            case 12: {
                pSSysDashboardBase.resetFlexDir();
                return true;
            }
            case 13: {
                pSSysDashboardBase.resetFlexVAlign();
                return true;
            }
            case 14: {
                pSSysDashboardBase.resetLayoutMode();
                return true;
            }
            case 15: {
                pSSysDashboardBase.resetLockFlag();
                return true;
            }
            case 16: {
                pSSysDashboardBase.resetMemo();
                return true;
            }
            case 17: {
                pSSysDashboardBase.resetNavBarHeight();
                return true;
            }
            case 18: {
                pSSysDashboardBase.resetNavBarPos();
                return true;
            }
            case 19: {
                pSSysDashboardBase.resetNavBarPSSysCssId();
                return true;
            }
            case 20: {
                pSSysDashboardBase.resetNavBarPSSysCssName();
                return true;
            }
            case 21: {
                pSSysDashboardBase.resetNavBarStyle();
                return true;
            }
            case 22: {
                pSSysDashboardBase.resetNavBarWidth();
                return true;
            }
            case 23: {
                pSSysDashboardBase.resetPSCtrlLogicGroupId();
                return true;
            }
            case 24: {
                pSSysDashboardBase.resetPSCtrlLogicGroupName();
                return true;
            }
            case 25: {
                pSSysDashboardBase.resetPSDEId();
                return true;
            }
            case 26: {
                pSSysDashboardBase.resetPSDEName();
                return true;
            }
            case 27: {
                pSSysDashboardBase.resetPSModuleId();
                return true;
            }
            case 28: {
                pSSysDashboardBase.resetPSModuleName();
                return true;
            }
            case 29: {
                pSSysDashboardBase.resetPSSysAppId();
                return true;
            }
            case 30: {
                pSSysDashboardBase.resetPSSysAppName();
                return true;
            }
            case 31: {
                pSSysDashboardBase.resetPSSysCssId();
                return true;
            }
            case 32: {
                pSSysDashboardBase.resetPSSysCssName();
                return true;
            }
            case 33: {
                pSSysDashboardBase.resetPSSysDashboardId();
                return true;
            }
            case 34: {
                pSSysDashboardBase.resetPSSysDashboardName();
                return true;
            }
            case 35: {
                pSSysDashboardBase.resetPSSysPFPluginId();
                return true;
            }
            case 36: {
                pSSysDashboardBase.resetPSSysPFPluginName();
                return true;
            }
            case 37: {
                pSSysDashboardBase.resetPSSystemId();
                return true;
            }
            case 38: {
                pSSysDashboardBase.resetPSSystemName();
                return true;
            }
            case 39: {
                pSSysDashboardBase.resetPSViewMsgGroupId();
                return true;
            }
            case 40: {
                pSSysDashboardBase.resetPSViewMsgGroupName();
                return true;
            }
            case 41: {
                pSSysDashboardBase.resetSysAppFlag();
                return true;
            }
            case 42: {
                pSSysDashboardBase.resetUpdateDate();
                return true;
            }
            case 43: {
                pSSysDashboardBase.resetUpdateMan();
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
    public ArrayList<PSSysDashboardLogic> getPSSysDashboardLogics() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDashboardLogics();
        }
        if (this.getPSSysDashboardId() == null) {
            return null;
        }
        PSSysDashboardService pSSysDashboardService = (PSSysDashboardService)ServiceGlobal.getService(PSSysDashboardService.class, (SessionFactory)this.getSessionFactory());
        PSSysDashboardLogicService pSSysDashboardLogicService = (PSSysDashboardLogicService)ServiceGlobal.getService(PSSysDashboardLogicService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysDashboardLogicsLock;
        synchronized (n) {
            if (this.pssysdashboardlogics == null) {
                this.pssysdashboardlogics = pSSysDashboardService.isTempData((IEntity)this) ? pSSysDashboardLogicService.selectTempByPSSysDashboard(this) : pSSysDashboardLogicService.selectByPSSysDashboard(this);
            }
            return this.pssysdashboardlogics;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysDBPart> getPSSysDBParts() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBParts();
        }
        if (this.getPSSysDashboardId() == null) {
            return null;
        }
        PSSysDashboardService pSSysDashboardService = (PSSysDashboardService)ServiceGlobal.getService(PSSysDashboardService.class, (SessionFactory)this.getSessionFactory());
        PSSysDBPartService pSSysDBPartService = (PSSysDBPartService)ServiceGlobal.getService(PSSysDBPartService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysDBPartsLock;
        synchronized (n) {
            if (this.pssysdbparts == null) {
                this.pssysdbparts = pSSysDashboardService.isTempData((IEntity)this) ? pSSysDBPartService.selectTempByPSSysDashboard(this) : pSSysDBPartService.selectByPSSysDashboard(this);
            }
            return this.pssysdbparts;
        }
    }

    private PSSysDashboardBase getProxyEntity() {
        return this.proxyPSSysDashboardBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysDashboardBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysDashboardBase) {
            this.proxyPSSysDashboardBase = (PSSysDashboardBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDashboardService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BUSYINDICATOR, 0);
        fieldIndexMap.put(FIELD_CODENAME, 1);
        fieldIndexMap.put(FIELD_COLMODEL, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_DASHBOARDNAVBAR, 5);
        fieldIndexMap.put(FIELD_DASHBOARDSTYLE, 6);
        fieldIndexMap.put(FIELD_DASHBOARDTAG, 7);
        fieldIndexMap.put(FIELD_DASHBOARDTAG2, 8);
        fieldIndexMap.put(FIELD_DBMODEL, 9);
        fieldIndexMap.put(FIELD_ENABLECUSTOMIZED, 10);
        fieldIndexMap.put(FIELD_FLEXALIGN, 11);
        fieldIndexMap.put(FIELD_FLEXDIR, 12);
        fieldIndexMap.put(FIELD_FLEXVALIGN, 13);
        fieldIndexMap.put(FIELD_LAYOUTMODE, 14);
        fieldIndexMap.put(FIELD_LOCKFLAG, 15);
        fieldIndexMap.put(FIELD_MEMO, 16);
        fieldIndexMap.put(FIELD_NAVBARHEIGHT, 17);
        fieldIndexMap.put(FIELD_NAVBARPOS, 18);
        fieldIndexMap.put(FIELD_NAVBARPSSYSCSSID, 19);
        fieldIndexMap.put(FIELD_NAVBARPSSYSCSSNAME, 20);
        fieldIndexMap.put(FIELD_NAVBARSTYLE, 21);
        fieldIndexMap.put(FIELD_NAVBARWIDTH, 22);
        fieldIndexMap.put(FIELD_PSCTRLLOGICGROUPID, 23);
        fieldIndexMap.put(FIELD_PSCTRLLOGICGROUPNAME, 24);
        fieldIndexMap.put(FIELD_PSDEID, 25);
        fieldIndexMap.put(FIELD_PSDENAME, 26);
        fieldIndexMap.put(FIELD_PSMODULEID, 27);
        fieldIndexMap.put(FIELD_PSMODULENAME, 28);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 29);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 30);
        fieldIndexMap.put(FIELD_PSSYSCSSID, 31);
        fieldIndexMap.put(FIELD_PSSYSCSSNAME, 32);
        fieldIndexMap.put(FIELD_PSSYSDASHBOARDID, 33);
        fieldIndexMap.put(FIELD_PSSYSDASHBOARDNAME, 34);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 35);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 36);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 37);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 38);
        fieldIndexMap.put(FIELD_PSVIEWMSGGROUPID, 39);
        fieldIndexMap.put(FIELD_PSVIEWMSGGROUPNAME, 40);
        fieldIndexMap.put(FIELD_SYSAPPFLAG, 41);
        fieldIndexMap.put(FIELD_UPDATEDATE, 42);
        fieldIndexMap.put(FIELD_UPDATEMAN, 43);
    }
}

