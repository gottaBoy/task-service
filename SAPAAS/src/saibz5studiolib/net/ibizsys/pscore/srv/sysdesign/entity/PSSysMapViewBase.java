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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMapItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMapLogic;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgGroup;
import net.ibizsys.pscore.srv.sysdesign.service.PSCtrlLogicGroupService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCtrlMsgService;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMapItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMapLogicService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMapViewService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGroupService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysMapViewBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysMapViewBase.class);
    public static final String FIELD_BUSYINDICATOR = "BUSYINDICATOR";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_EMPTYTEXT = "EMPTYTEXT";
    public static final String FIELD_EMPTYTEXTPSLANRESID = "EMPTYTEXTPSLANRESID";
    public static final String FIELD_EMPTYTEXTPSLANRESNAME = "EMPTYTEXTPSLANRESNAME";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MAPVIEWSTYLE = "MAPVIEWSTYLE";
    public static final String FIELD_MAPVIEWTAG = "MAPVIEWTAG";
    public static final String FIELD_MAPVIEWTAG2 = "MAPVIEWTAG2";
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
    public static final String FIELD_PSSYSCSSID = "PSSYSCSSID";
    public static final String FIELD_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String FIELD_PSSYSMAPVIEWID = "PSSYSMAPVIEWID";
    public static final String FIELD_PSSYSMAPVIEWNAME = "PSSYSMAPVIEWNAME";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSVIEWMSGGROUPID = "PSVIEWMSGGROUPID";
    public static final String FIELD_PSVIEWMSGGROUPNAME = "PSVIEWMSGGROUPNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_BUSYINDICATOR = 0;
    private static final int INDEX_CODENAME = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_EMPTYTEXT = 4;
    private static final int INDEX_EMPTYTEXTPSLANRESID = 5;
    private static final int INDEX_EMPTYTEXTPSLANRESNAME = 6;
    private static final int INDEX_LOGICNAME = 7;
    private static final int INDEX_MAPVIEWSTYLE = 8;
    private static final int INDEX_MAPVIEWTAG = 9;
    private static final int INDEX_MAPVIEWTAG2 = 10;
    private static final int INDEX_MEMO = 11;
    private static final int INDEX_NAVVIEWHEIGHT = 12;
    private static final int INDEX_NAVVIEWMAXHEIGHT = 13;
    private static final int INDEX_NAVVIEWMAXWIDTH = 14;
    private static final int INDEX_NAVVIEWMINHEIGHT = 15;
    private static final int INDEX_NAVVIEWMINWIDTH = 16;
    private static final int INDEX_NAVVIEWPOS = 17;
    private static final int INDEX_NAVVIEWSHOWMODE = 18;
    private static final int INDEX_NAVVIEWWIDTH = 19;
    private static final int INDEX_PSCTRLLOGICGROUPID = 20;
    private static final int INDEX_PSCTRLLOGICGROUPNAME = 21;
    private static final int INDEX_PSCTRLMSGID = 22;
    private static final int INDEX_PSCTRLMSGNAME = 23;
    private static final int INDEX_PSDEID = 24;
    private static final int INDEX_PSDENAME = 25;
    private static final int INDEX_PSSYSCSSID = 26;
    private static final int INDEX_PSSYSCSSNAME = 27;
    private static final int INDEX_PSSYSMAPVIEWID = 28;
    private static final int INDEX_PSSYSMAPVIEWNAME = 29;
    private static final int INDEX_PSSYSPFPLUGINID = 30;
    private static final int INDEX_PSSYSPFPLUGINNAME = 31;
    private static final int INDEX_PSSYSTEMID = 32;
    private static final int INDEX_PSSYSTEMNAME = 33;
    private static final int INDEX_PSVIEWMSGGROUPID = 34;
    private static final int INDEX_PSVIEWMSGGROUPNAME = 35;
    private static final int INDEX_UPDATEDATE = 36;
    private static final int INDEX_UPDATEMAN = 37;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysMapViewBase proxyPSSysMapViewBase = null;
    private boolean busyindicatorDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean emptytextDirtyFlag = false;
    private boolean emptytextpslanresidDirtyFlag = false;
    private boolean emptytextpslanresnameDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean mapviewstyleDirtyFlag = false;
    private boolean mapviewtagDirtyFlag = false;
    private boolean mapviewtag2DirtyFlag = false;
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
    private boolean pssyscssidDirtyFlag = false;
    private boolean pssyscssnameDirtyFlag = false;
    private boolean pssysmapviewidDirtyFlag = false;
    private boolean pssysmapviewnameDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean psviewmsggroupidDirtyFlag = false;
    private boolean psviewmsggroupnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="busyindicator")
    private Integer busyindicator;
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
    @Column(name="logicname")
    private String logicname;
    @Column(name="mapviewstyle")
    private String mapviewstyle;
    @Column(name="mapviewtag")
    private String mapviewtag;
    @Column(name="mapviewtag2")
    private String mapviewtag2;
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
    @Column(name="pssyscssid")
    private String pssyscssid;
    @Column(name="pssyscssname")
    private String pssyscssname;
    @Column(name="pssysmapviewid")
    private String pssysmapviewid;
    @Column(name="pssysmapviewname")
    private String pssysmapviewname;
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
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSCtrlLogicGroupLock = new Integer(1);
    private PSCtrlLogicGroup psctrllogicgroup = null;
    private Integer objPSCtrlMsgLock = new Integer(1);
    private PSCtrlMsg psctrlmsg = null;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objEmptyTExtPSLanResLock = new Integer(1);
    private PSLanguageRes emptytextpslanres = null;
    private Integer objPSSysCssLock = new Integer(1);
    private PSSysCss pssyscss = null;
    private Integer objPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin pssyspfplugin = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSViewMsgGroupLock = new Integer(1);
    private PSViewMsgGroup psviewmsggroup = null;
    private Integer objPSSysMapItemLock = new Integer(1);
    private ArrayList<PSSysMapItem> pssysmapitem = null;
    private Integer objPSSysMapLogicsLock = new Integer(1);
    private ArrayList<PSSysMapLogic> pssysmaplogics = null;

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

    public void setMapViewStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMapViewStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mapviewstyle = string;
        this.mapviewstyleDirtyFlag = true;
    }

    public String getMapViewStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMapViewStyle();
        }
        return this.mapviewstyle;
    }

    public boolean isMapViewStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMapViewStyleDirty();
        }
        return this.mapviewstyleDirtyFlag;
    }

    public void resetMapViewStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMapViewStyle();
            return;
        }
        this.mapviewstyleDirtyFlag = false;
        this.mapviewstyle = null;
    }

    public void setMapViewTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMapViewTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mapviewtag = string;
        this.mapviewtagDirtyFlag = true;
    }

    public String getMapViewTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMapViewTag();
        }
        return this.mapviewtag;
    }

    public boolean isMapViewTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMapViewTagDirty();
        }
        return this.mapviewtagDirtyFlag;
    }

    public void resetMapViewTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMapViewTag();
            return;
        }
        this.mapviewtagDirtyFlag = false;
        this.mapviewtag = null;
    }

    public void setMapViewTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMapViewTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mapviewtag2 = string;
        this.mapviewtag2DirtyFlag = true;
    }

    public String getMapViewTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMapViewTag2();
        }
        return this.mapviewtag2;
    }

    public boolean isMapViewTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMapViewTag2Dirty();
        }
        return this.mapviewtag2DirtyFlag;
    }

    public void resetMapViewTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMapViewTag2();
            return;
        }
        this.mapviewtag2DirtyFlag = false;
        this.mapviewtag2 = null;
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
        PSSysMapViewBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysMapViewBase pSSysMapViewBase) {
        pSSysMapViewBase.resetBusyIndicator();
        pSSysMapViewBase.resetCodeName();
        pSSysMapViewBase.resetCreateDate();
        pSSysMapViewBase.resetCreateMan();
        pSSysMapViewBase.resetEmptyText();
        pSSysMapViewBase.resetEmptyTextPSLanResId();
        pSSysMapViewBase.resetEmptyTextPSLanResName();
        pSSysMapViewBase.resetLogicName();
        pSSysMapViewBase.resetMapViewStyle();
        pSSysMapViewBase.resetMapViewTag();
        pSSysMapViewBase.resetMapViewTag2();
        pSSysMapViewBase.resetMemo();
        pSSysMapViewBase.resetNavViewHeight();
        pSSysMapViewBase.resetNavViewMaxHeight();
        pSSysMapViewBase.resetNavViewMaxWidth();
        pSSysMapViewBase.resetNavViewMinHeight();
        pSSysMapViewBase.resetNavViewMinWidth();
        pSSysMapViewBase.resetNavViewPos();
        pSSysMapViewBase.resetNavViewShowMode();
        pSSysMapViewBase.resetNavViewWidth();
        pSSysMapViewBase.resetPSCtrlLogicGroupId();
        pSSysMapViewBase.resetPSCtrlLogicGroupName();
        pSSysMapViewBase.resetPSCtrlMsgId();
        pSSysMapViewBase.resetPSCtrlMsgName();
        pSSysMapViewBase.resetPSDEId();
        pSSysMapViewBase.resetPSDEName();
        pSSysMapViewBase.resetPSSysCssId();
        pSSysMapViewBase.resetPSSysCssName();
        pSSysMapViewBase.resetPSSysMapViewId();
        pSSysMapViewBase.resetPSSysMapViewName();
        pSSysMapViewBase.resetPSSysPFPluginId();
        pSSysMapViewBase.resetPSSysPFPluginName();
        pSSysMapViewBase.resetPSSystemId();
        pSSysMapViewBase.resetPSSystemName();
        pSSysMapViewBase.resetPSViewMsgGroupId();
        pSSysMapViewBase.resetPSViewMsgGroupName();
        pSSysMapViewBase.resetUpdateDate();
        pSSysMapViewBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
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
        if (!bl || this.isEmptyTextDirty()) {
            hashMap.put(FIELD_EMPTYTEXT, this.getEmptyText());
        }
        if (!bl || this.isEmptyTextPSLanResIdDirty()) {
            hashMap.put(FIELD_EMPTYTEXTPSLANRESID, this.getEmptyTextPSLanResId());
        }
        if (!bl || this.isEmptyTextPSLanResNameDirty()) {
            hashMap.put(FIELD_EMPTYTEXTPSLANRESNAME, this.getEmptyTextPSLanResName());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isMapViewStyleDirty()) {
            hashMap.put(FIELD_MAPVIEWSTYLE, this.getMapViewStyle());
        }
        if (!bl || this.isMapViewTagDirty()) {
            hashMap.put(FIELD_MAPVIEWTAG, this.getMapViewTag());
        }
        if (!bl || this.isMapViewTag2Dirty()) {
            hashMap.put(FIELD_MAPVIEWTAG2, this.getMapViewTag2());
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
        if (!bl || this.isPSSysCssIdDirty()) {
            hashMap.put(FIELD_PSSYSCSSID, this.getPSSysCssId());
        }
        if (!bl || this.isPSSysCssNameDirty()) {
            hashMap.put(FIELD_PSSYSCSSNAME, this.getPSSysCssName());
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
        return PSSysMapViewBase.get(this, n);
    }

    private static Object get(PSSysMapViewBase pSSysMapViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysMapViewBase.getBusyIndicator();
            }
            case 1: {
                return pSSysMapViewBase.getCodeName();
            }
            case 2: {
                return pSSysMapViewBase.getCreateDate();
            }
            case 3: {
                return pSSysMapViewBase.getCreateMan();
            }
            case 4: {
                return pSSysMapViewBase.getEmptyText();
            }
            case 5: {
                return pSSysMapViewBase.getEmptyTextPSLanResId();
            }
            case 6: {
                return pSSysMapViewBase.getEmptyTextPSLanResName();
            }
            case 7: {
                return pSSysMapViewBase.getLogicName();
            }
            case 8: {
                return pSSysMapViewBase.getMapViewStyle();
            }
            case 9: {
                return pSSysMapViewBase.getMapViewTag();
            }
            case 10: {
                return pSSysMapViewBase.getMapViewTag2();
            }
            case 11: {
                return pSSysMapViewBase.getMemo();
            }
            case 12: {
                return pSSysMapViewBase.getNavViewHeight();
            }
            case 13: {
                return pSSysMapViewBase.getNavViewMaxHeight();
            }
            case 14: {
                return pSSysMapViewBase.getNavViewMaxWidth();
            }
            case 15: {
                return pSSysMapViewBase.getNavViewMinHeight();
            }
            case 16: {
                return pSSysMapViewBase.getNavViewMinWidth();
            }
            case 17: {
                return pSSysMapViewBase.getNavViewPos();
            }
            case 18: {
                return pSSysMapViewBase.getNavViewShowMode();
            }
            case 19: {
                return pSSysMapViewBase.getNavViewWidth();
            }
            case 20: {
                return pSSysMapViewBase.getPSCtrlLogicGroupId();
            }
            case 21: {
                return pSSysMapViewBase.getPSCtrlLogicGroupName();
            }
            case 22: {
                return pSSysMapViewBase.getPSCtrlMsgId();
            }
            case 23: {
                return pSSysMapViewBase.getPSCtrlMsgName();
            }
            case 24: {
                return pSSysMapViewBase.getPSDEId();
            }
            case 25: {
                return pSSysMapViewBase.getPSDEName();
            }
            case 26: {
                return pSSysMapViewBase.getPSSysCssId();
            }
            case 27: {
                return pSSysMapViewBase.getPSSysCssName();
            }
            case 28: {
                return pSSysMapViewBase.getPSSysMapViewId();
            }
            case 29: {
                return pSSysMapViewBase.getPSSysMapViewName();
            }
            case 30: {
                return pSSysMapViewBase.getPSSysPFPluginId();
            }
            case 31: {
                return pSSysMapViewBase.getPSSysPFPluginName();
            }
            case 32: {
                return pSSysMapViewBase.getPSSystemId();
            }
            case 33: {
                return pSSysMapViewBase.getPSSystemName();
            }
            case 34: {
                return pSSysMapViewBase.getPSViewMsgGroupId();
            }
            case 35: {
                return pSSysMapViewBase.getPSViewMsgGroupName();
            }
            case 36: {
                return pSSysMapViewBase.getUpdateDate();
            }
            case 37: {
                return pSSysMapViewBase.getUpdateMan();
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
        PSSysMapViewBase.set(this, n, object);
    }

    private static void set(PSSysMapViewBase pSSysMapViewBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysMapViewBase.setBusyIndicator(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSSysMapViewBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysMapViewBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSSysMapViewBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysMapViewBase.setEmptyText(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysMapViewBase.setEmptyTextPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysMapViewBase.setEmptyTextPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysMapViewBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysMapViewBase.setMapViewStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysMapViewBase.setMapViewTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysMapViewBase.setMapViewTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysMapViewBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysMapViewBase.setNavViewHeight(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 13: {
                pSSysMapViewBase.setNavViewMaxHeight(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 14: {
                pSSysMapViewBase.setNavViewMaxWidth(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 15: {
                pSSysMapViewBase.setNavViewMinHeight(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 16: {
                pSSysMapViewBase.setNavViewMinWidth(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 17: {
                pSSysMapViewBase.setNavViewPos(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysMapViewBase.setNavViewShowMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSSysMapViewBase.setNavViewWidth(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 20: {
                pSSysMapViewBase.setPSCtrlLogicGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysMapViewBase.setPSCtrlLogicGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysMapViewBase.setPSCtrlMsgId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysMapViewBase.setPSCtrlMsgName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysMapViewBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysMapViewBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysMapViewBase.setPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysMapViewBase.setPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysMapViewBase.setPSSysMapViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysMapViewBase.setPSSysMapViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysMapViewBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysMapViewBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysMapViewBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysMapViewBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysMapViewBase.setPSViewMsgGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSysMapViewBase.setPSViewMsgGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSSysMapViewBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 37: {
                pSSysMapViewBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSysMapViewBase.isNull(this, n);
    }

    private static boolean isNull(PSSysMapViewBase pSSysMapViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysMapViewBase.getBusyIndicator() == null;
            }
            case 1: {
                return pSSysMapViewBase.getCodeName() == null;
            }
            case 2: {
                return pSSysMapViewBase.getCreateDate() == null;
            }
            case 3: {
                return pSSysMapViewBase.getCreateMan() == null;
            }
            case 4: {
                return pSSysMapViewBase.getEmptyText() == null;
            }
            case 5: {
                return pSSysMapViewBase.getEmptyTextPSLanResId() == null;
            }
            case 6: {
                return pSSysMapViewBase.getEmptyTextPSLanResName() == null;
            }
            case 7: {
                return pSSysMapViewBase.getLogicName() == null;
            }
            case 8: {
                return pSSysMapViewBase.getMapViewStyle() == null;
            }
            case 9: {
                return pSSysMapViewBase.getMapViewTag() == null;
            }
            case 10: {
                return pSSysMapViewBase.getMapViewTag2() == null;
            }
            case 11: {
                return pSSysMapViewBase.getMemo() == null;
            }
            case 12: {
                return pSSysMapViewBase.getNavViewHeight() == null;
            }
            case 13: {
                return pSSysMapViewBase.getNavViewMaxHeight() == null;
            }
            case 14: {
                return pSSysMapViewBase.getNavViewMaxWidth() == null;
            }
            case 15: {
                return pSSysMapViewBase.getNavViewMinHeight() == null;
            }
            case 16: {
                return pSSysMapViewBase.getNavViewMinWidth() == null;
            }
            case 17: {
                return pSSysMapViewBase.getNavViewPos() == null;
            }
            case 18: {
                return pSSysMapViewBase.getNavViewShowMode() == null;
            }
            case 19: {
                return pSSysMapViewBase.getNavViewWidth() == null;
            }
            case 20: {
                return pSSysMapViewBase.getPSCtrlLogicGroupId() == null;
            }
            case 21: {
                return pSSysMapViewBase.getPSCtrlLogicGroupName() == null;
            }
            case 22: {
                return pSSysMapViewBase.getPSCtrlMsgId() == null;
            }
            case 23: {
                return pSSysMapViewBase.getPSCtrlMsgName() == null;
            }
            case 24: {
                return pSSysMapViewBase.getPSDEId() == null;
            }
            case 25: {
                return pSSysMapViewBase.getPSDEName() == null;
            }
            case 26: {
                return pSSysMapViewBase.getPSSysCssId() == null;
            }
            case 27: {
                return pSSysMapViewBase.getPSSysCssName() == null;
            }
            case 28: {
                return pSSysMapViewBase.getPSSysMapViewId() == null;
            }
            case 29: {
                return pSSysMapViewBase.getPSSysMapViewName() == null;
            }
            case 30: {
                return pSSysMapViewBase.getPSSysPFPluginId() == null;
            }
            case 31: {
                return pSSysMapViewBase.getPSSysPFPluginName() == null;
            }
            case 32: {
                return pSSysMapViewBase.getPSSystemId() == null;
            }
            case 33: {
                return pSSysMapViewBase.getPSSystemName() == null;
            }
            case 34: {
                return pSSysMapViewBase.getPSViewMsgGroupId() == null;
            }
            case 35: {
                return pSSysMapViewBase.getPSViewMsgGroupName() == null;
            }
            case 36: {
                return pSSysMapViewBase.getUpdateDate() == null;
            }
            case 37: {
                return pSSysMapViewBase.getUpdateMan() == null;
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
        return PSSysMapViewBase.contains(this, n);
    }

    private static boolean contains(PSSysMapViewBase pSSysMapViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysMapViewBase.isBusyIndicatorDirty();
            }
            case 1: {
                return pSSysMapViewBase.isCodeNameDirty();
            }
            case 2: {
                return pSSysMapViewBase.isCreateDateDirty();
            }
            case 3: {
                return pSSysMapViewBase.isCreateManDirty();
            }
            case 4: {
                return pSSysMapViewBase.isEmptyTextDirty();
            }
            case 5: {
                return pSSysMapViewBase.isEmptyTextPSLanResIdDirty();
            }
            case 6: {
                return pSSysMapViewBase.isEmptyTextPSLanResNameDirty();
            }
            case 7: {
                return pSSysMapViewBase.isLogicNameDirty();
            }
            case 8: {
                return pSSysMapViewBase.isMapViewStyleDirty();
            }
            case 9: {
                return pSSysMapViewBase.isMapViewTagDirty();
            }
            case 10: {
                return pSSysMapViewBase.isMapViewTag2Dirty();
            }
            case 11: {
                return pSSysMapViewBase.isMemoDirty();
            }
            case 12: {
                return pSSysMapViewBase.isNavViewHeightDirty();
            }
            case 13: {
                return pSSysMapViewBase.isNavViewMaxHeightDirty();
            }
            case 14: {
                return pSSysMapViewBase.isNavViewMaxWidthDirty();
            }
            case 15: {
                return pSSysMapViewBase.isNavViewMinHeightDirty();
            }
            case 16: {
                return pSSysMapViewBase.isNavViewMinWidthDirty();
            }
            case 17: {
                return pSSysMapViewBase.isNavViewPosDirty();
            }
            case 18: {
                return pSSysMapViewBase.isNavViewShowModeDirty();
            }
            case 19: {
                return pSSysMapViewBase.isNavViewWidthDirty();
            }
            case 20: {
                return pSSysMapViewBase.isPSCtrlLogicGroupIdDirty();
            }
            case 21: {
                return pSSysMapViewBase.isPSCtrlLogicGroupNameDirty();
            }
            case 22: {
                return pSSysMapViewBase.isPSCtrlMsgIdDirty();
            }
            case 23: {
                return pSSysMapViewBase.isPSCtrlMsgNameDirty();
            }
            case 24: {
                return pSSysMapViewBase.isPSDEIdDirty();
            }
            case 25: {
                return pSSysMapViewBase.isPSDENameDirty();
            }
            case 26: {
                return pSSysMapViewBase.isPSSysCssIdDirty();
            }
            case 27: {
                return pSSysMapViewBase.isPSSysCssNameDirty();
            }
            case 28: {
                return pSSysMapViewBase.isPSSysMapViewIdDirty();
            }
            case 29: {
                return pSSysMapViewBase.isPSSysMapViewNameDirty();
            }
            case 30: {
                return pSSysMapViewBase.isPSSysPFPluginIdDirty();
            }
            case 31: {
                return pSSysMapViewBase.isPSSysPFPluginNameDirty();
            }
            case 32: {
                return pSSysMapViewBase.isPSSystemIdDirty();
            }
            case 33: {
                return pSSysMapViewBase.isPSSystemNameDirty();
            }
            case 34: {
                return pSSysMapViewBase.isPSViewMsgGroupIdDirty();
            }
            case 35: {
                return pSSysMapViewBase.isPSViewMsgGroupNameDirty();
            }
            case 36: {
                return pSSysMapViewBase.isUpdateDateDirty();
            }
            case 37: {
                return pSSysMapViewBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysMapViewBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysMapViewBase pSSysMapViewBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysMapViewBase.getBusyIndicator() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"busyindicator", (Object)PSSysMapViewBase.getJSONValue((Object)pSSysMapViewBase.getBusyIndicator()), (boolean)false);
        }
        if (bl || pSSysMapViewBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysMapViewBase.getJSONValue((Object)pSSysMapViewBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysMapViewBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysMapViewBase.getJSONValue((Object)pSSysMapViewBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysMapViewBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysMapViewBase.getJSONValue((Object)pSSysMapViewBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysMapViewBase.getEmptyText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"emptytext", (Object)PSSysMapViewBase.getJSONValue((Object)pSSysMapViewBase.getEmptyText()), (boolean)false);
        }
        if (bl || pSSysMapViewBase.getEmptyTextPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"emptytextpslanresid", (Object)PSSysMapViewBase.getJSONValue((Object)pSSysMapViewBase.getEmptyTextPSLanResId()), (boolean)false);
        }
        if (bl || pSSysMapViewBase.getEmptyTextPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"emptytextpslanresname", (Object)PSSysMapViewBase.getJSONValue((Object)pSSysMapViewBase.getEmptyTextPSLanResName()), (boolean)false);
        }
        if (bl || pSSysMapViewBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSSysMapViewBase.getJSONValue((Object)pSSysMapViewBase.getLogicName()), (boolean)false);
        }
        if (bl || pSSysMapViewBase.getMapViewStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mapviewstyle", (Object)PSSysMapViewBase.getJSONValue((Object)pSSysMapViewBase.getMapViewStyle()), (boolean)false);
        }
        if (bl || pSSysMapViewBase.getMapViewTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mapviewtag", (Object)PSSysMapViewBase.getJSONValue((Object)pSSysMapViewBase.getMapViewTag()), (boolean)false);
        }
        if (bl || pSSysMapViewBase.getMapViewTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mapviewtag2", (Object)PSSysMapViewBase.getJSONValue((Object)pSSysMapViewBase.getMapViewTag2()), (boolean)false);
        }
        if (bl || pSSysMapViewBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysMapViewBase.getJSONValue((Object)pSSysMapViewBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysMapViewBase.getNavViewHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewheight", (Object)PSSysMapViewBase.getJSONValue((Object)pSSysMapViewBase.getNavViewHeight()), (boolean)false);
        }
        if (bl || pSSysMapViewBase.getNavViewMaxHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewmaxheight", (Object)PSSysMapViewBase.getJSONValue((Object)pSSysMapViewBase.getNavViewMaxHeight()), (boolean)false);
        }
        if (bl || pSSysMapViewBase.getNavViewMaxWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewmaxwidth", (Object)PSSysMapViewBase.getJSONValue((Object)pSSysMapViewBase.getNavViewMaxWidth()), (boolean)false);
        }
        if (bl || pSSysMapViewBase.getNavViewMinHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewminheight", (Object)PSSysMapViewBase.getJSONValue((Object)pSSysMapViewBase.getNavViewMinHeight()), (boolean)false);
        }
        if (bl || pSSysMapViewBase.getNavViewMinWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewminwidth", (Object)PSSysMapViewBase.getJSONValue((Object)pSSysMapViewBase.getNavViewMinWidth()), (boolean)false);
        }
        if (bl || pSSysMapViewBase.getNavViewPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewpos", (Object)PSSysMapViewBase.getJSONValue((Object)pSSysMapViewBase.getNavViewPos()), (boolean)false);
        }
        if (bl || pSSysMapViewBase.getNavViewShowMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewshowmode", (Object)PSSysMapViewBase.getJSONValue((Object)pSSysMapViewBase.getNavViewShowMode()), (boolean)false);
        }
        if (bl || pSSysMapViewBase.getNavViewWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewwidth", (Object)PSSysMapViewBase.getJSONValue((Object)pSSysMapViewBase.getNavViewWidth()), (boolean)false);
        }
        if (bl || pSSysMapViewBase.getPSCtrlLogicGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrllogicgroupid", (Object)PSSysMapViewBase.getJSONValue((Object)pSSysMapViewBase.getPSCtrlLogicGroupId()), (boolean)false);
        }
        if (bl || pSSysMapViewBase.getPSCtrlLogicGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrllogicgroupname", (Object)PSSysMapViewBase.getJSONValue((Object)pSSysMapViewBase.getPSCtrlLogicGroupName()), (boolean)false);
        }
        if (bl || pSSysMapViewBase.getPSCtrlMsgId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrlmsgid", (Object)PSSysMapViewBase.getJSONValue((Object)pSSysMapViewBase.getPSCtrlMsgId()), (boolean)false);
        }
        if (bl || pSSysMapViewBase.getPSCtrlMsgName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrlmsgname", (Object)PSSysMapViewBase.getJSONValue((Object)pSSysMapViewBase.getPSCtrlMsgName()), (boolean)false);
        }
        if (bl || pSSysMapViewBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysMapViewBase.getJSONValue((Object)pSSysMapViewBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysMapViewBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSSysMapViewBase.getJSONValue((Object)pSSysMapViewBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSSysMapViewBase.getPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssid", (Object)PSSysMapViewBase.getJSONValue((Object)pSSysMapViewBase.getPSSysCssId()), (boolean)false);
        }
        if (bl || pSSysMapViewBase.getPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssname", (Object)PSSysMapViewBase.getJSONValue((Object)pSSysMapViewBase.getPSSysCssName()), (boolean)false);
        }
        if (bl || pSSysMapViewBase.getPSSysMapViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmapviewid", (Object)PSSysMapViewBase.getJSONValue((Object)pSSysMapViewBase.getPSSysMapViewId()), (boolean)false);
        }
        if (bl || pSSysMapViewBase.getPSSysMapViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmapviewname", (Object)PSSysMapViewBase.getJSONValue((Object)pSSysMapViewBase.getPSSysMapViewName()), (boolean)false);
        }
        if (bl || pSSysMapViewBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSSysMapViewBase.getJSONValue((Object)pSSysMapViewBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSSysMapViewBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSSysMapViewBase.getJSONValue((Object)pSSysMapViewBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSSysMapViewBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysMapViewBase.getJSONValue((Object)pSSysMapViewBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysMapViewBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysMapViewBase.getJSONValue((Object)pSSysMapViewBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysMapViewBase.getPSViewMsgGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewmsggroupid", (Object)PSSysMapViewBase.getJSONValue((Object)pSSysMapViewBase.getPSViewMsgGroupId()), (boolean)false);
        }
        if (bl || pSSysMapViewBase.getPSViewMsgGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewmsggroupname", (Object)PSSysMapViewBase.getJSONValue((Object)pSSysMapViewBase.getPSViewMsgGroupName()), (boolean)false);
        }
        if (bl || pSSysMapViewBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysMapViewBase.getJSONValue((Object)pSSysMapViewBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysMapViewBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysMapViewBase.getJSONValue((Object)pSSysMapViewBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysMapViewBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysMapViewBase pSSysMapViewBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysMapViewBase.getBusyIndicator() != null) {
            object = pSSysMapViewBase.getBusyIndicator();
            xmlNode.setAttribute(FIELD_BUSYINDICATOR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysMapViewBase.getCodeName() != null) {
            object = pSSysMapViewBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapViewBase.getCreateDate() != null) {
            object = pSSysMapViewBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysMapViewBase.getCreateMan() != null) {
            object = pSSysMapViewBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapViewBase.getEmptyText() != null) {
            object = pSSysMapViewBase.getEmptyText();
            xmlNode.setAttribute(FIELD_EMPTYTEXT, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapViewBase.getEmptyTextPSLanResId() != null) {
            object = pSSysMapViewBase.getEmptyTextPSLanResId();
            xmlNode.setAttribute(FIELD_EMPTYTEXTPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapViewBase.getEmptyTextPSLanResName() != null) {
            object = pSSysMapViewBase.getEmptyTextPSLanResName();
            xmlNode.setAttribute(FIELD_EMPTYTEXTPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapViewBase.getLogicName() != null) {
            object = pSSysMapViewBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapViewBase.getMapViewStyle() != null) {
            object = pSSysMapViewBase.getMapViewStyle();
            xmlNode.setAttribute(FIELD_MAPVIEWSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapViewBase.getMapViewTag() != null) {
            object = pSSysMapViewBase.getMapViewTag();
            xmlNode.setAttribute(FIELD_MAPVIEWTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapViewBase.getMapViewTag2() != null) {
            object = pSSysMapViewBase.getMapViewTag2();
            xmlNode.setAttribute(FIELD_MAPVIEWTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapViewBase.getMemo() != null) {
            object = pSSysMapViewBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapViewBase.getNavViewHeight() != null) {
            object = pSSysMapViewBase.getNavViewHeight();
            xmlNode.setAttribute(FIELD_NAVVIEWHEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysMapViewBase.getNavViewMaxHeight() != null) {
            object = pSSysMapViewBase.getNavViewMaxHeight();
            xmlNode.setAttribute(FIELD_NAVVIEWMAXHEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysMapViewBase.getNavViewMaxWidth() != null) {
            object = pSSysMapViewBase.getNavViewMaxWidth();
            xmlNode.setAttribute(FIELD_NAVVIEWMAXWIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysMapViewBase.getNavViewMinHeight() != null) {
            object = pSSysMapViewBase.getNavViewMinHeight();
            xmlNode.setAttribute(FIELD_NAVVIEWMINHEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysMapViewBase.getNavViewMinWidth() != null) {
            object = pSSysMapViewBase.getNavViewMinWidth();
            xmlNode.setAttribute(FIELD_NAVVIEWMINWIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysMapViewBase.getNavViewPos() != null) {
            object = pSSysMapViewBase.getNavViewPos();
            xmlNode.setAttribute(FIELD_NAVVIEWPOS, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapViewBase.getNavViewShowMode() != null) {
            object = pSSysMapViewBase.getNavViewShowMode();
            xmlNode.setAttribute(FIELD_NAVVIEWSHOWMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysMapViewBase.getNavViewWidth() != null) {
            object = pSSysMapViewBase.getNavViewWidth();
            xmlNode.setAttribute(FIELD_NAVVIEWWIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysMapViewBase.getPSCtrlLogicGroupId() != null) {
            object = pSSysMapViewBase.getPSCtrlLogicGroupId();
            xmlNode.setAttribute(FIELD_PSCTRLLOGICGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapViewBase.getPSCtrlLogicGroupName() != null) {
            object = pSSysMapViewBase.getPSCtrlLogicGroupName();
            xmlNode.setAttribute(FIELD_PSCTRLLOGICGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapViewBase.getPSCtrlMsgId() != null) {
            object = pSSysMapViewBase.getPSCtrlMsgId();
            xmlNode.setAttribute(FIELD_PSCTRLMSGID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapViewBase.getPSCtrlMsgName() != null) {
            object = pSSysMapViewBase.getPSCtrlMsgName();
            xmlNode.setAttribute(FIELD_PSCTRLMSGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapViewBase.getPSDEId() != null) {
            object = pSSysMapViewBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapViewBase.getPSDEName() != null) {
            object = pSSysMapViewBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapViewBase.getPSSysCssId() != null) {
            object = pSSysMapViewBase.getPSSysCssId();
            xmlNode.setAttribute(FIELD_PSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapViewBase.getPSSysCssName() != null) {
            object = pSSysMapViewBase.getPSSysCssName();
            xmlNode.setAttribute(FIELD_PSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapViewBase.getPSSysMapViewId() != null) {
            object = pSSysMapViewBase.getPSSysMapViewId();
            xmlNode.setAttribute(FIELD_PSSYSMAPVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapViewBase.getPSSysMapViewName() != null) {
            object = pSSysMapViewBase.getPSSysMapViewName();
            xmlNode.setAttribute(FIELD_PSSYSMAPVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapViewBase.getPSSysPFPluginId() != null) {
            object = pSSysMapViewBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapViewBase.getPSSysPFPluginName() != null) {
            object = pSSysMapViewBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapViewBase.getPSSystemId() != null) {
            object = pSSysMapViewBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapViewBase.getPSSystemName() != null) {
            object = pSSysMapViewBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapViewBase.getPSViewMsgGroupId() != null) {
            object = pSSysMapViewBase.getPSViewMsgGroupId();
            xmlNode.setAttribute(FIELD_PSVIEWMSGGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapViewBase.getPSViewMsgGroupName() != null) {
            object = pSSysMapViewBase.getPSViewMsgGroupName();
            xmlNode.setAttribute(FIELD_PSVIEWMSGGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapViewBase.getUpdateDate() != null) {
            object = pSSysMapViewBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysMapViewBase.getUpdateMan() != null) {
            object = pSSysMapViewBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysMapViewBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysMapViewBase pSSysMapViewBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysMapViewBase.isBusyIndicatorDirty() && (bl || pSSysMapViewBase.getBusyIndicator() != null)) {
            iDataObject.set(FIELD_BUSYINDICATOR, (Object)pSSysMapViewBase.getBusyIndicator());
        }
        if (pSSysMapViewBase.isCodeNameDirty() && (bl || pSSysMapViewBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysMapViewBase.getCodeName());
        }
        if (pSSysMapViewBase.isCreateDateDirty() && (bl || pSSysMapViewBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysMapViewBase.getCreateDate());
        }
        if (pSSysMapViewBase.isCreateManDirty() && (bl || pSSysMapViewBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysMapViewBase.getCreateMan());
        }
        if (pSSysMapViewBase.isEmptyTextDirty() && (bl || pSSysMapViewBase.getEmptyText() != null)) {
            iDataObject.set(FIELD_EMPTYTEXT, (Object)pSSysMapViewBase.getEmptyText());
        }
        if (pSSysMapViewBase.isEmptyTextPSLanResIdDirty() && (bl || pSSysMapViewBase.getEmptyTextPSLanResId() != null)) {
            iDataObject.set(FIELD_EMPTYTEXTPSLANRESID, (Object)pSSysMapViewBase.getEmptyTextPSLanResId());
        }
        if (pSSysMapViewBase.isEmptyTextPSLanResNameDirty() && (bl || pSSysMapViewBase.getEmptyTextPSLanResName() != null)) {
            iDataObject.set(FIELD_EMPTYTEXTPSLANRESNAME, (Object)pSSysMapViewBase.getEmptyTextPSLanResName());
        }
        if (pSSysMapViewBase.isLogicNameDirty() && (bl || pSSysMapViewBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSSysMapViewBase.getLogicName());
        }
        if (pSSysMapViewBase.isMapViewStyleDirty() && (bl || pSSysMapViewBase.getMapViewStyle() != null)) {
            iDataObject.set(FIELD_MAPVIEWSTYLE, (Object)pSSysMapViewBase.getMapViewStyle());
        }
        if (pSSysMapViewBase.isMapViewTagDirty() && (bl || pSSysMapViewBase.getMapViewTag() != null)) {
            iDataObject.set(FIELD_MAPVIEWTAG, (Object)pSSysMapViewBase.getMapViewTag());
        }
        if (pSSysMapViewBase.isMapViewTag2Dirty() && (bl || pSSysMapViewBase.getMapViewTag2() != null)) {
            iDataObject.set(FIELD_MAPVIEWTAG2, (Object)pSSysMapViewBase.getMapViewTag2());
        }
        if (pSSysMapViewBase.isMemoDirty() && (bl || pSSysMapViewBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysMapViewBase.getMemo());
        }
        if (pSSysMapViewBase.isNavViewHeightDirty() && (bl || pSSysMapViewBase.getNavViewHeight() != null)) {
            iDataObject.set(FIELD_NAVVIEWHEIGHT, (Object)pSSysMapViewBase.getNavViewHeight());
        }
        if (pSSysMapViewBase.isNavViewMaxHeightDirty() && (bl || pSSysMapViewBase.getNavViewMaxHeight() != null)) {
            iDataObject.set(FIELD_NAVVIEWMAXHEIGHT, (Object)pSSysMapViewBase.getNavViewMaxHeight());
        }
        if (pSSysMapViewBase.isNavViewMaxWidthDirty() && (bl || pSSysMapViewBase.getNavViewMaxWidth() != null)) {
            iDataObject.set(FIELD_NAVVIEWMAXWIDTH, (Object)pSSysMapViewBase.getNavViewMaxWidth());
        }
        if (pSSysMapViewBase.isNavViewMinHeightDirty() && (bl || pSSysMapViewBase.getNavViewMinHeight() != null)) {
            iDataObject.set(FIELD_NAVVIEWMINHEIGHT, (Object)pSSysMapViewBase.getNavViewMinHeight());
        }
        if (pSSysMapViewBase.isNavViewMinWidthDirty() && (bl || pSSysMapViewBase.getNavViewMinWidth() != null)) {
            iDataObject.set(FIELD_NAVVIEWMINWIDTH, (Object)pSSysMapViewBase.getNavViewMinWidth());
        }
        if (pSSysMapViewBase.isNavViewPosDirty() && (bl || pSSysMapViewBase.getNavViewPos() != null)) {
            iDataObject.set(FIELD_NAVVIEWPOS, (Object)pSSysMapViewBase.getNavViewPos());
        }
        if (pSSysMapViewBase.isNavViewShowModeDirty() && (bl || pSSysMapViewBase.getNavViewShowMode() != null)) {
            iDataObject.set(FIELD_NAVVIEWSHOWMODE, (Object)pSSysMapViewBase.getNavViewShowMode());
        }
        if (pSSysMapViewBase.isNavViewWidthDirty() && (bl || pSSysMapViewBase.getNavViewWidth() != null)) {
            iDataObject.set(FIELD_NAVVIEWWIDTH, (Object)pSSysMapViewBase.getNavViewWidth());
        }
        if (pSSysMapViewBase.isPSCtrlLogicGroupIdDirty() && (bl || pSSysMapViewBase.getPSCtrlLogicGroupId() != null)) {
            iDataObject.set(FIELD_PSCTRLLOGICGROUPID, (Object)pSSysMapViewBase.getPSCtrlLogicGroupId());
        }
        if (pSSysMapViewBase.isPSCtrlLogicGroupNameDirty() && (bl || pSSysMapViewBase.getPSCtrlLogicGroupName() != null)) {
            iDataObject.set(FIELD_PSCTRLLOGICGROUPNAME, (Object)pSSysMapViewBase.getPSCtrlLogicGroupName());
        }
        if (pSSysMapViewBase.isPSCtrlMsgIdDirty() && (bl || pSSysMapViewBase.getPSCtrlMsgId() != null)) {
            iDataObject.set(FIELD_PSCTRLMSGID, (Object)pSSysMapViewBase.getPSCtrlMsgId());
        }
        if (pSSysMapViewBase.isPSCtrlMsgNameDirty() && (bl || pSSysMapViewBase.getPSCtrlMsgName() != null)) {
            iDataObject.set(FIELD_PSCTRLMSGNAME, (Object)pSSysMapViewBase.getPSCtrlMsgName());
        }
        if (pSSysMapViewBase.isPSDEIdDirty() && (bl || pSSysMapViewBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysMapViewBase.getPSDEId());
        }
        if (pSSysMapViewBase.isPSDENameDirty() && (bl || pSSysMapViewBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSSysMapViewBase.getPSDEName());
        }
        if (pSSysMapViewBase.isPSSysCssIdDirty() && (bl || pSSysMapViewBase.getPSSysCssId() != null)) {
            iDataObject.set(FIELD_PSSYSCSSID, (Object)pSSysMapViewBase.getPSSysCssId());
        }
        if (pSSysMapViewBase.isPSSysCssNameDirty() && (bl || pSSysMapViewBase.getPSSysCssName() != null)) {
            iDataObject.set(FIELD_PSSYSCSSNAME, (Object)pSSysMapViewBase.getPSSysCssName());
        }
        if (pSSysMapViewBase.isPSSysMapViewIdDirty() && (bl || pSSysMapViewBase.getPSSysMapViewId() != null)) {
            iDataObject.set(FIELD_PSSYSMAPVIEWID, (Object)pSSysMapViewBase.getPSSysMapViewId());
        }
        if (pSSysMapViewBase.isPSSysMapViewNameDirty() && (bl || pSSysMapViewBase.getPSSysMapViewName() != null)) {
            iDataObject.set(FIELD_PSSYSMAPVIEWNAME, (Object)pSSysMapViewBase.getPSSysMapViewName());
        }
        if (pSSysMapViewBase.isPSSysPFPluginIdDirty() && (bl || pSSysMapViewBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSSysMapViewBase.getPSSysPFPluginId());
        }
        if (pSSysMapViewBase.isPSSysPFPluginNameDirty() && (bl || pSSysMapViewBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSSysMapViewBase.getPSSysPFPluginName());
        }
        if (pSSysMapViewBase.isPSSystemIdDirty() && (bl || pSSysMapViewBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysMapViewBase.getPSSystemId());
        }
        if (pSSysMapViewBase.isPSSystemNameDirty() && (bl || pSSysMapViewBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysMapViewBase.getPSSystemName());
        }
        if (pSSysMapViewBase.isPSViewMsgGroupIdDirty() && (bl || pSSysMapViewBase.getPSViewMsgGroupId() != null)) {
            iDataObject.set(FIELD_PSVIEWMSGGROUPID, (Object)pSSysMapViewBase.getPSViewMsgGroupId());
        }
        if (pSSysMapViewBase.isPSViewMsgGroupNameDirty() && (bl || pSSysMapViewBase.getPSViewMsgGroupName() != null)) {
            iDataObject.set(FIELD_PSVIEWMSGGROUPNAME, (Object)pSSysMapViewBase.getPSViewMsgGroupName());
        }
        if (pSSysMapViewBase.isUpdateDateDirty() && (bl || pSSysMapViewBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysMapViewBase.getUpdateDate());
        }
        if (pSSysMapViewBase.isUpdateManDirty() && (bl || pSSysMapViewBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysMapViewBase.getUpdateMan());
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
        return PSSysMapViewBase.remove(this, n);
    }

    private static boolean remove(PSSysMapViewBase pSSysMapViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysMapViewBase.resetBusyIndicator();
                return true;
            }
            case 1: {
                pSSysMapViewBase.resetCodeName();
                return true;
            }
            case 2: {
                pSSysMapViewBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSSysMapViewBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSSysMapViewBase.resetEmptyText();
                return true;
            }
            case 5: {
                pSSysMapViewBase.resetEmptyTextPSLanResId();
                return true;
            }
            case 6: {
                pSSysMapViewBase.resetEmptyTextPSLanResName();
                return true;
            }
            case 7: {
                pSSysMapViewBase.resetLogicName();
                return true;
            }
            case 8: {
                pSSysMapViewBase.resetMapViewStyle();
                return true;
            }
            case 9: {
                pSSysMapViewBase.resetMapViewTag();
                return true;
            }
            case 10: {
                pSSysMapViewBase.resetMapViewTag2();
                return true;
            }
            case 11: {
                pSSysMapViewBase.resetMemo();
                return true;
            }
            case 12: {
                pSSysMapViewBase.resetNavViewHeight();
                return true;
            }
            case 13: {
                pSSysMapViewBase.resetNavViewMaxHeight();
                return true;
            }
            case 14: {
                pSSysMapViewBase.resetNavViewMaxWidth();
                return true;
            }
            case 15: {
                pSSysMapViewBase.resetNavViewMinHeight();
                return true;
            }
            case 16: {
                pSSysMapViewBase.resetNavViewMinWidth();
                return true;
            }
            case 17: {
                pSSysMapViewBase.resetNavViewPos();
                return true;
            }
            case 18: {
                pSSysMapViewBase.resetNavViewShowMode();
                return true;
            }
            case 19: {
                pSSysMapViewBase.resetNavViewWidth();
                return true;
            }
            case 20: {
                pSSysMapViewBase.resetPSCtrlLogicGroupId();
                return true;
            }
            case 21: {
                pSSysMapViewBase.resetPSCtrlLogicGroupName();
                return true;
            }
            case 22: {
                pSSysMapViewBase.resetPSCtrlMsgId();
                return true;
            }
            case 23: {
                pSSysMapViewBase.resetPSCtrlMsgName();
                return true;
            }
            case 24: {
                pSSysMapViewBase.resetPSDEId();
                return true;
            }
            case 25: {
                pSSysMapViewBase.resetPSDEName();
                return true;
            }
            case 26: {
                pSSysMapViewBase.resetPSSysCssId();
                return true;
            }
            case 27: {
                pSSysMapViewBase.resetPSSysCssName();
                return true;
            }
            case 28: {
                pSSysMapViewBase.resetPSSysMapViewId();
                return true;
            }
            case 29: {
                pSSysMapViewBase.resetPSSysMapViewName();
                return true;
            }
            case 30: {
                pSSysMapViewBase.resetPSSysPFPluginId();
                return true;
            }
            case 31: {
                pSSysMapViewBase.resetPSSysPFPluginName();
                return true;
            }
            case 32: {
                pSSysMapViewBase.resetPSSystemId();
                return true;
            }
            case 33: {
                pSSysMapViewBase.resetPSSystemName();
                return true;
            }
            case 34: {
                pSSysMapViewBase.resetPSViewMsgGroupId();
                return true;
            }
            case 35: {
                pSSysMapViewBase.resetPSViewMsgGroupName();
                return true;
            }
            case 36: {
                pSSysMapViewBase.resetUpdateDate();
                return true;
            }
            case 37: {
                pSSysMapViewBase.resetUpdateMan();
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
    public PSLanguageRes getEmptyTExtPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEmptyTExtPSLanRes();
        }
        if (this.getEmptyTextPSLanResId() == null) {
            return null;
        }
        Integer n = this.objEmptyTExtPSLanResLock;
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
    public ArrayList<PSSysMapItem> getPSSysMapItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMapItem();
        }
        if (this.getPSSysMapViewId() == null) {
            return null;
        }
        PSSysMapViewService pSSysMapViewService = (PSSysMapViewService)ServiceGlobal.getService(PSSysMapViewService.class, (SessionFactory)this.getSessionFactory());
        PSSysMapItemService pSSysMapItemService = (PSSysMapItemService)ServiceGlobal.getService(PSSysMapItemService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysMapItemLock;
        synchronized (n) {
            if (this.pssysmapitem == null) {
                this.pssysmapitem = pSSysMapViewService.isTempData((IEntity)this) ? pSSysMapItemService.selectTempByPSSysMapView(this) : pSSysMapItemService.selectByPSSysMapView(this);
            }
            return this.pssysmapitem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysMapLogic> getPSSysMapLogics() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMapLogics();
        }
        if (this.getPSSysMapViewId() == null) {
            return null;
        }
        PSSysMapViewService pSSysMapViewService = (PSSysMapViewService)ServiceGlobal.getService(PSSysMapViewService.class, (SessionFactory)this.getSessionFactory());
        PSSysMapLogicService pSSysMapLogicService = (PSSysMapLogicService)ServiceGlobal.getService(PSSysMapLogicService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysMapLogicsLock;
        synchronized (n) {
            if (this.pssysmaplogics == null) {
                this.pssysmaplogics = pSSysMapViewService.isTempData((IEntity)this) ? pSSysMapLogicService.selectTempByPSSysMapView(this) : pSSysMapLogicService.selectByPSSysMapView(this);
            }
            return this.pssysmaplogics;
        }
    }

    private PSSysMapViewBase getProxyEntity() {
        return this.proxyPSSysMapViewBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysMapViewBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysMapViewBase) {
            this.proxyPSSysMapViewBase = (PSSysMapViewBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysMapViewService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BUSYINDICATOR, 0);
        fieldIndexMap.put(FIELD_CODENAME, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_EMPTYTEXT, 4);
        fieldIndexMap.put(FIELD_EMPTYTEXTPSLANRESID, 5);
        fieldIndexMap.put(FIELD_EMPTYTEXTPSLANRESNAME, 6);
        fieldIndexMap.put(FIELD_LOGICNAME, 7);
        fieldIndexMap.put(FIELD_MAPVIEWSTYLE, 8);
        fieldIndexMap.put(FIELD_MAPVIEWTAG, 9);
        fieldIndexMap.put(FIELD_MAPVIEWTAG2, 10);
        fieldIndexMap.put(FIELD_MEMO, 11);
        fieldIndexMap.put(FIELD_NAVVIEWHEIGHT, 12);
        fieldIndexMap.put(FIELD_NAVVIEWMAXHEIGHT, 13);
        fieldIndexMap.put(FIELD_NAVVIEWMAXWIDTH, 14);
        fieldIndexMap.put(FIELD_NAVVIEWMINHEIGHT, 15);
        fieldIndexMap.put(FIELD_NAVVIEWMINWIDTH, 16);
        fieldIndexMap.put(FIELD_NAVVIEWPOS, 17);
        fieldIndexMap.put(FIELD_NAVVIEWSHOWMODE, 18);
        fieldIndexMap.put(FIELD_NAVVIEWWIDTH, 19);
        fieldIndexMap.put(FIELD_PSCTRLLOGICGROUPID, 20);
        fieldIndexMap.put(FIELD_PSCTRLLOGICGROUPNAME, 21);
        fieldIndexMap.put(FIELD_PSCTRLMSGID, 22);
        fieldIndexMap.put(FIELD_PSCTRLMSGNAME, 23);
        fieldIndexMap.put(FIELD_PSDEID, 24);
        fieldIndexMap.put(FIELD_PSDENAME, 25);
        fieldIndexMap.put(FIELD_PSSYSCSSID, 26);
        fieldIndexMap.put(FIELD_PSSYSCSSNAME, 27);
        fieldIndexMap.put(FIELD_PSSYSMAPVIEWID, 28);
        fieldIndexMap.put(FIELD_PSSYSMAPVIEWNAME, 29);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 30);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 31);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 32);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 33);
        fieldIndexMap.put(FIELD_PSVIEWMSGGROUPID, 34);
        fieldIndexMap.put(FIELD_PSVIEWMSGGROUPNAME, 35);
        fieldIndexMap.put(FIELD_UPDATEDATE, 36);
        fieldIndexMap.put(FIELD_UPDATEMAN, 37);
    }
}

