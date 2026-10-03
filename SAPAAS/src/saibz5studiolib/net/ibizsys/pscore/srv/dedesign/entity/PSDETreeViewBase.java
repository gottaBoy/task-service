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
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.service.PSSysPFPluginService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGrid;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeCol;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeLogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeNode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeColService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeViewService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSACHandler;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlLogicGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlMsg;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCounter;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgGroup;
import net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCtrlLogicGroupService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCtrlMsgService;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCounterService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGroupService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDETreeViewBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDETreeViewBase.class);
    public static final String FIELD_BUFFERRENDERERMODE = "BUFFERRENDERERMODE";
    public static final String FIELD_BUSYINDICATOR = "BUSYINDICATOR";
    public static final String FIELD_CATPSCODELISTID = "CATPSCODELISTID";
    public static final String FIELD_CATPSCODELISTNAME = "CATPSCODELISTNAME";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_COLENABLEFILTER = "COLENABLEFILTER";
    public static final String FIELD_COLENABLELINK = "COLENABLELINK";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_EMPTYTEXT = "EMPTYTEXT";
    public static final String FIELD_EMPTYTEXTPSLANRESID = "EMPTYTEXTPSLANRESID";
    public static final String FIELD_EMPTYTEXTPSLANRESNAME = "EMPTYTEXTPSLANRESNAME";
    public static final String FIELD_ENABLEEDIT = "ENABLEEDIT";
    public static final String FIELD_ENABLEITEMPRIV = "ENABLEITEMPRIV";
    public static final String FIELD_ENABLESEARCH = "ENABLESEARCH";
    public static final String FIELD_FROZENCOL = "FROZENCOL";
    public static final String FIELD_FROZENLASTCOL = "FROZENLASTCOL";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_NAVVIEWHEIGHT = "NAVVIEWHEIGHT";
    public static final String FIELD_NAVVIEWMAXHEIGHT = "NAVVIEWMAXHEIGHT";
    public static final String FIELD_NAVVIEWMAXWIDTH = "NAVVIEWMAXWIDTH";
    public static final String FIELD_NAVVIEWMINHEIGHT = "NAVVIEWMINHEIGHT";
    public static final String FIELD_NAVVIEWMINWIDTH = "NAVVIEWMINWIDTH";
    public static final String FIELD_NAVVIEWPOS = "NAVVIEWPOS";
    public static final String FIELD_NAVVIEWSHOWMODE = "NAVVIEWSHOWMODE";
    public static final String FIELD_NAVVIEWWIDTH = "NAVVIEWWIDTH";
    public static final String FIELD_NOICONDEFAULT = "NOICONDEFAULT";
    public static final String FIELD_PSACHANDLERID = "PSACHANDLERID";
    public static final String FIELD_PSACHANDLERNAME = "PSACHANDLERNAME";
    public static final String FIELD_PSCTRLLOGICGROUPID = "PSCTRLLOGICGROUPID";
    public static final String FIELD_PSCTRLLOGICGROUPNAME = "PSCTRLLOGICGROUPNAME";
    public static final String FIELD_PSCTRLMSGID = "PSCTRLMSGID";
    public static final String FIELD_PSCTRLMSGNAME = "PSCTRLMSGNAME";
    public static final String FIELD_PSDEGRIDID = "PSDEGRIDID";
    public static final String FIELD_PSDEGRIDNAME = "PSDEGRIDNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDETREEVIEWID = "PSDETREEVIEWID";
    public static final String FIELD_PSDETREEVIEWNAME = "PSDETREEVIEWNAME";
    public static final String FIELD_PSSYSCOUNTERID = "PSSYSCOUNTERID";
    public static final String FIELD_PSSYSCOUNTERNAME = "PSSYSCOUNTERNAME";
    public static final String FIELD_PSSYSCSSID = "PSSYSCSSID";
    public static final String FIELD_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSVIEWMSGGROUPID = "PSVIEWMSGGROUPID";
    public static final String FIELD_PSVIEWMSGGROUPNAME = "PSVIEWMSGGROUPNAME";
    public static final String FIELD_ROOTSELECT = "ROOTSELECT";
    public static final String FIELD_SHOWROOT = "SHOWROOT";
    public static final String FIELD_SRFSYSPUB = "SRFSYSPUB";
    public static final String FIELD_TODOTASK = "TODOTASK";
    public static final String FIELD_TREEGRIDFLAG = "TREEGRIDFLAG";
    public static final String FIELD_TREEMODEL = "TREEMODEL";
    public static final String FIELD_TREESTYLE = "TREESTYLE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_BUFFERRENDERERMODE = 0;
    private static final int INDEX_BUSYINDICATOR = 1;
    private static final int INDEX_CATPSCODELISTID = 2;
    private static final int INDEX_CATPSCODELISTNAME = 3;
    private static final int INDEX_CODENAME = 4;
    private static final int INDEX_COLENABLEFILTER = 5;
    private static final int INDEX_COLENABLELINK = 6;
    private static final int INDEX_CREATEDATE = 7;
    private static final int INDEX_CREATEMAN = 8;
    private static final int INDEX_EMPTYTEXT = 9;
    private static final int INDEX_EMPTYTEXTPSLANRESID = 10;
    private static final int INDEX_EMPTYTEXTPSLANRESNAME = 11;
    private static final int INDEX_ENABLEEDIT = 12;
    private static final int INDEX_ENABLEITEMPRIV = 13;
    private static final int INDEX_ENABLESEARCH = 14;
    private static final int INDEX_FROZENCOL = 15;
    private static final int INDEX_FROZENLASTCOL = 16;
    private static final int INDEX_LOCKFLAG = 17;
    private static final int INDEX_MEMO = 18;
    private static final int INDEX_NAVVIEWHEIGHT = 19;
    private static final int INDEX_NAVVIEWMAXHEIGHT = 20;
    private static final int INDEX_NAVVIEWMAXWIDTH = 21;
    private static final int INDEX_NAVVIEWMINHEIGHT = 22;
    private static final int INDEX_NAVVIEWMINWIDTH = 23;
    private static final int INDEX_NAVVIEWPOS = 24;
    private static final int INDEX_NAVVIEWSHOWMODE = 25;
    private static final int INDEX_NAVVIEWWIDTH = 26;
    private static final int INDEX_NOICONDEFAULT = 27;
    private static final int INDEX_PSACHANDLERID = 28;
    private static final int INDEX_PSACHANDLERNAME = 29;
    private static final int INDEX_PSCTRLLOGICGROUPID = 30;
    private static final int INDEX_PSCTRLLOGICGROUPNAME = 31;
    private static final int INDEX_PSCTRLMSGID = 32;
    private static final int INDEX_PSCTRLMSGNAME = 33;
    private static final int INDEX_PSDEGRIDID = 34;
    private static final int INDEX_PSDEGRIDNAME = 35;
    private static final int INDEX_PSDEID = 36;
    private static final int INDEX_PSDENAME = 37;
    private static final int INDEX_PSDETREEVIEWID = 38;
    private static final int INDEX_PSDETREEVIEWNAME = 39;
    private static final int INDEX_PSSYSCOUNTERID = 40;
    private static final int INDEX_PSSYSCOUNTERNAME = 41;
    private static final int INDEX_PSSYSCSSID = 42;
    private static final int INDEX_PSSYSCSSNAME = 43;
    private static final int INDEX_PSSYSPFPLUGINID = 44;
    private static final int INDEX_PSSYSPFPLUGINNAME = 45;
    private static final int INDEX_PSSYSTEMID = 46;
    private static final int INDEX_PSSYSTEMNAME = 47;
    private static final int INDEX_PSVIEWMSGGROUPID = 48;
    private static final int INDEX_PSVIEWMSGGROUPNAME = 49;
    private static final int INDEX_ROOTSELECT = 50;
    private static final int INDEX_SHOWROOT = 51;
    private static final int INDEX_SRFSYSPUB = 52;
    private static final int INDEX_TODOTASK = 53;
    private static final int INDEX_TREEGRIDFLAG = 54;
    private static final int INDEX_TREEMODEL = 55;
    private static final int INDEX_TREESTYLE = 56;
    private static final int INDEX_UPDATEDATE = 57;
    private static final int INDEX_UPDATEMAN = 58;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDETreeViewBase proxyPSDETreeViewBase = null;
    private boolean bufferrenderermodeDirtyFlag = false;
    private boolean busyindicatorDirtyFlag = false;
    private boolean catpscodelistidDirtyFlag = false;
    private boolean catpscodelistnameDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean colenablefilterDirtyFlag = false;
    private boolean colenablelinkDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean emptytextDirtyFlag = false;
    private boolean emptytextpslanresidDirtyFlag = false;
    private boolean emptytextpslanresnameDirtyFlag = false;
    private boolean enableeditDirtyFlag = false;
    private boolean enableitemprivDirtyFlag = false;
    private boolean enablesearchDirtyFlag = false;
    private boolean frozencolDirtyFlag = false;
    private boolean frozenlastcolDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean navviewheightDirtyFlag = false;
    private boolean navviewmaxheightDirtyFlag = false;
    private boolean navviewmaxwidthDirtyFlag = false;
    private boolean navviewminheightDirtyFlag = false;
    private boolean navviewminwidthDirtyFlag = false;
    private boolean navviewposDirtyFlag = false;
    private boolean navviewshowmodeDirtyFlag = false;
    private boolean navviewwidthDirtyFlag = false;
    private boolean noicondefaultDirtyFlag = false;
    private boolean psachandleridDirtyFlag = false;
    private boolean psachandlernameDirtyFlag = false;
    private boolean psctrllogicgroupidDirtyFlag = false;
    private boolean psctrllogicgroupnameDirtyFlag = false;
    private boolean psctrlmsgidDirtyFlag = false;
    private boolean psctrlmsgnameDirtyFlag = false;
    private boolean psdegrididDirtyFlag = false;
    private boolean psdegridnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdetreeviewidDirtyFlag = false;
    private boolean psdetreeviewnameDirtyFlag = false;
    private boolean pssyscounteridDirtyFlag = false;
    private boolean pssyscounternameDirtyFlag = false;
    private boolean pssyscssidDirtyFlag = false;
    private boolean pssyscssnameDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean psviewmsggroupidDirtyFlag = false;
    private boolean psviewmsggroupnameDirtyFlag = false;
    private boolean rootselectDirtyFlag = false;
    private boolean showrootDirtyFlag = false;
    private boolean srfsyspubDirtyFlag = false;
    private boolean todotaskDirtyFlag = false;
    private boolean treegridflagDirtyFlag = false;
    private boolean treemodelDirtyFlag = false;
    private boolean treestyleDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="bufferrenderermode")
    private Integer bufferrenderermode;
    @Column(name="busyindicator")
    private Integer busyindicator;
    @Column(name="catpscodelistid")
    private String catpscodelistid;
    @Column(name="catpscodelistname")
    private String catpscodelistname;
    @Column(name="codename")
    private String codename;
    @Column(name="colenablefilter")
    private Integer colenablefilter;
    @Column(name="colenablelink")
    private Integer colenablelink;
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
    @Column(name="enableitempriv")
    private Integer enableitempriv;
    @Column(name="enablesearch")
    private Integer enablesearch;
    @Column(name="frozencol")
    private Integer frozencol;
    @Column(name="frozenlastcol")
    private Integer frozenlastcol;
    @Column(name="lockflag")
    private Integer lockflag;
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
    @Column(name="noicondefault")
    private Integer noicondefault;
    @Column(name="psachandlerid")
    private String psachandlerid;
    @Column(name="psachandlername")
    private String psachandlername;
    @Column(name="psctrllogicgroupid")
    private String psctrllogicgroupid;
    @Column(name="psctrllogicgroupname")
    private String psctrllogicgroupname;
    @Column(name="psctrlmsgid")
    private String psctrlmsgid;
    @Column(name="psctrlmsgname")
    private String psctrlmsgname;
    @Column(name="psdegridid")
    private String psdegridid;
    @Column(name="psdegridname")
    private String psdegridname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdetreeviewid")
    private String psdetreeviewid;
    @Column(name="psdetreeviewname")
    private String psdetreeviewname;
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
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="psviewmsggroupid")
    private String psviewmsggroupid;
    @Column(name="psviewmsggroupname")
    private String psviewmsggroupname;
    @Column(name="rootselect")
    private Integer rootselect;
    @Column(name="showroot")
    private Integer showroot;
    @Column(name="srfsyspub")
    private Integer srfsyspub;
    @Column(name="todotask")
    private String todotask;
    @Column(name="treegridflag")
    private Integer treegridflag;
    @Column(name="treemodel")
    private String treemodel;
    @Column(name="treestyle")
    private String treestyle;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSACHandlerLock = new Integer(1);
    private PSACHandler psachandler = null;
    private Integer objCatPSCodeListLock = new Integer(1);
    private PSCodeList catpscodelist = null;
    private Integer objPSCtrlLogicGroupLock = new Integer(1);
    private PSCtrlLogicGroup psctrllogicgroup = null;
    private Integer objPSCtrlMsgLock = new Integer(1);
    private PSCtrlMsg psctrlmsg = null;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSDEGridLock = new Integer(1);
    private PSDEGrid psdegrid = null;
    private Integer objEmptyTextPSLanResLock = new Integer(1);
    private PSLanguageRes emptytextpslanres = null;
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
    private Integer objPSDETreeColsLock = new Integer(1);
    private ArrayList<PSDETreeCol> psdetreecols = null;
    private Integer objPSDETreeLogicsLock = new Integer(1);
    private ArrayList<PSDETreeLogic> psdetreelogics = null;
    private Integer objPSDETreeNodesLock = new Integer(1);
    private ArrayList<PSDETreeNode> psdetreenodes = null;

    public void setBufferRendererMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBufferRendererMode(n);
            return;
        }
        this.bufferrenderermode = n;
        this.bufferrenderermodeDirtyFlag = true;
    }

    public Integer getBufferRendererMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBufferRendererMode();
        }
        return this.bufferrenderermode;
    }

    public boolean isBufferRendererModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBufferRendererModeDirty();
        }
        return this.bufferrenderermodeDirtyFlag;
    }

    public void resetBufferRendererMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBufferRendererMode();
            return;
        }
        this.bufferrenderermodeDirtyFlag = false;
        this.bufferrenderermode = null;
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

    public void setCatPSCodeListId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCatPSCodeListId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.catpscodelistid = string;
        this.catpscodelistidDirtyFlag = true;
    }

    public String getCatPSCodeListId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCatPSCodeListId();
        }
        return this.catpscodelistid;
    }

    public boolean isCatPSCodeListIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCatPSCodeListIdDirty();
        }
        return this.catpscodelistidDirtyFlag;
    }

    public void resetCatPSCodeListId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCatPSCodeListId();
            return;
        }
        this.catpscodelistidDirtyFlag = false;
        this.catpscodelistid = null;
    }

    public void setCatPSCodeListName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCatPSCodeListName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.catpscodelistname = string;
        this.catpscodelistnameDirtyFlag = true;
    }

    public String getCatPSCodeListName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCatPSCodeListName();
        }
        return this.catpscodelistname;
    }

    public boolean isCatPSCodeListNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCatPSCodeListNameDirty();
        }
        return this.catpscodelistnameDirtyFlag;
    }

    public void resetCatPSCodeListName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCatPSCodeListName();
            return;
        }
        this.catpscodelistnameDirtyFlag = false;
        this.catpscodelistname = null;
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

    public void setColEnableFilter(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setColEnableFilter(n);
            return;
        }
        this.colenablefilter = n;
        this.colenablefilterDirtyFlag = true;
    }

    public Integer getColEnableFilter() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getColEnableFilter();
        }
        return this.colenablefilter;
    }

    public boolean isColEnableFilterDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isColEnableFilterDirty();
        }
        return this.colenablefilterDirtyFlag;
    }

    public void resetColEnableFilter() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetColEnableFilter();
            return;
        }
        this.colenablefilterDirtyFlag = false;
        this.colenablefilter = null;
    }

    public void setColEnableLink(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setColEnableLink(n);
            return;
        }
        this.colenablelink = n;
        this.colenablelinkDirtyFlag = true;
    }

    public Integer getColEnableLink() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getColEnableLink();
        }
        return this.colenablelink;
    }

    public boolean isColEnableLinkDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isColEnableLinkDirty();
        }
        return this.colenablelinkDirtyFlag;
    }

    public void resetColEnableLink() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetColEnableLink();
            return;
        }
        this.colenablelinkDirtyFlag = false;
        this.colenablelink = null;
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

    public void setEnableSearch(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableSearch(n);
            return;
        }
        this.enablesearch = n;
        this.enablesearchDirtyFlag = true;
    }

    public Integer getEnableSearch() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableSearch();
        }
        return this.enablesearch;
    }

    public boolean isEnableSearchDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableSearchDirty();
        }
        return this.enablesearchDirtyFlag;
    }

    public void resetEnableSearch() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableSearch();
            return;
        }
        this.enablesearchDirtyFlag = false;
        this.enablesearch = null;
    }

    public void setFrozenCol(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFrozenCol(n);
            return;
        }
        this.frozencol = n;
        this.frozencolDirtyFlag = true;
    }

    public Integer getFrozenCol() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFrozenCol();
        }
        return this.frozencol;
    }

    public boolean isFrozenColDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFrozenColDirty();
        }
        return this.frozencolDirtyFlag;
    }

    public void resetFrozenCol() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFrozenCol();
            return;
        }
        this.frozencolDirtyFlag = false;
        this.frozencol = null;
    }

    public void setFrozenLastCol(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFrozenLastCol(n);
            return;
        }
        this.frozenlastcol = n;
        this.frozenlastcolDirtyFlag = true;
    }

    public Integer getFrozenLastCol() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFrozenLastCol();
        }
        return this.frozenlastcol;
    }

    public boolean isFrozenLastColDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFrozenLastColDirty();
        }
        return this.frozenlastcolDirtyFlag;
    }

    public void resetFrozenLastCol() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFrozenLastCol();
            return;
        }
        this.frozenlastcolDirtyFlag = false;
        this.frozenlastcol = null;
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

    public void setNoIconDefault(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNoIconDefault(n);
            return;
        }
        this.noicondefault = n;
        this.noicondefaultDirtyFlag = true;
    }

    public Integer getNoIconDefault() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNoIconDefault();
        }
        return this.noicondefault;
    }

    public boolean isNoIconDefaultDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNoIconDefaultDirty();
        }
        return this.noicondefaultDirtyFlag;
    }

    public void resetNoIconDefault() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNoIconDefault();
            return;
        }
        this.noicondefaultDirtyFlag = false;
        this.noicondefault = null;
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

    public void setRootSelect(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRootSelect(n);
            return;
        }
        this.rootselect = n;
        this.rootselectDirtyFlag = true;
    }

    public Integer getRootSelect() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRootSelect();
        }
        return this.rootselect;
    }

    public boolean isRootSelectDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRootSelectDirty();
        }
        return this.rootselectDirtyFlag;
    }

    public void resetRootSelect() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRootSelect();
            return;
        }
        this.rootselectDirtyFlag = false;
        this.rootselect = null;
    }

    public void setShowRoot(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setShowRoot(n);
            return;
        }
        this.showroot = n;
        this.showrootDirtyFlag = true;
    }

    public Integer getShowRoot() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getShowRoot();
        }
        return this.showroot;
    }

    public boolean isShowRootDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isShowRootDirty();
        }
        return this.showrootDirtyFlag;
    }

    public void resetShowRoot() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetShowRoot();
            return;
        }
        this.showrootDirtyFlag = false;
        this.showroot = null;
    }

    public void setSRFSysPub(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSRFSysPub(n);
            return;
        }
        this.srfsyspub = n;
        this.srfsyspubDirtyFlag = true;
    }

    public Integer getSRFSysPub() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSRFSysPub();
        }
        return this.srfsyspub;
    }

    public boolean isSRFSysPubDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSRFSysPubDirty();
        }
        return this.srfsyspubDirtyFlag;
    }

    public void resetSRFSysPub() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSRFSysPub();
            return;
        }
        this.srfsyspubDirtyFlag = false;
        this.srfsyspub = null;
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

    public void setTreeGridFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTreeGridFlag(n);
            return;
        }
        this.treegridflag = n;
        this.treegridflagDirtyFlag = true;
    }

    public Integer getTreeGridFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTreeGridFlag();
        }
        return this.treegridflag;
    }

    public boolean isTreeGridFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTreeGridFlagDirty();
        }
        return this.treegridflagDirtyFlag;
    }

    public void resetTreeGridFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTreeGridFlag();
            return;
        }
        this.treegridflagDirtyFlag = false;
        this.treegridflag = null;
    }

    public void setTreeModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTreeModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.treemodel = string;
        this.treemodelDirtyFlag = true;
    }

    public String getTreeModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTreeModel();
        }
        return this.treemodel;
    }

    public boolean isTreeModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTreeModelDirty();
        }
        return this.treemodelDirtyFlag;
    }

    public void resetTreeModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTreeModel();
            return;
        }
        this.treemodelDirtyFlag = false;
        this.treemodel = null;
    }

    public void setTreeStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTreeStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.treestyle = string;
        this.treestyleDirtyFlag = true;
    }

    public String getTreeStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTreeStyle();
        }
        return this.treestyle;
    }

    public boolean isTreeStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTreeStyleDirty();
        }
        return this.treestyleDirtyFlag;
    }

    public void resetTreeStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTreeStyle();
            return;
        }
        this.treestyleDirtyFlag = false;
        this.treestyle = null;
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
        PSDETreeViewBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDETreeViewBase pSDETreeViewBase) {
        pSDETreeViewBase.resetBufferRendererMode();
        pSDETreeViewBase.resetBusyIndicator();
        pSDETreeViewBase.resetCatPSCodeListId();
        pSDETreeViewBase.resetCatPSCodeListName();
        pSDETreeViewBase.resetCodeName();
        pSDETreeViewBase.resetColEnableFilter();
        pSDETreeViewBase.resetColEnableLink();
        pSDETreeViewBase.resetCreateDate();
        pSDETreeViewBase.resetCreateMan();
        pSDETreeViewBase.resetEmptyText();
        pSDETreeViewBase.resetEmptyTextPSLanResId();
        pSDETreeViewBase.resetEmptyTextPSLanResName();
        pSDETreeViewBase.resetEnableEdit();
        pSDETreeViewBase.resetEnableItemPriv();
        pSDETreeViewBase.resetEnableSearch();
        pSDETreeViewBase.resetFrozenCol();
        pSDETreeViewBase.resetFrozenLastCol();
        pSDETreeViewBase.resetLockFlag();
        pSDETreeViewBase.resetMemo();
        pSDETreeViewBase.resetNavViewHeight();
        pSDETreeViewBase.resetNavViewMaxHeight();
        pSDETreeViewBase.resetNavViewMaxWidth();
        pSDETreeViewBase.resetNavViewMinHeight();
        pSDETreeViewBase.resetNavViewMinWidth();
        pSDETreeViewBase.resetNavViewPos();
        pSDETreeViewBase.resetNavViewShowMode();
        pSDETreeViewBase.resetNavViewWidth();
        pSDETreeViewBase.resetNoIconDefault();
        pSDETreeViewBase.resetPSACHandlerId();
        pSDETreeViewBase.resetPSACHandlerName();
        pSDETreeViewBase.resetPSCtrlLogicGroupId();
        pSDETreeViewBase.resetPSCtrlLogicGroupName();
        pSDETreeViewBase.resetPSCtrlMsgId();
        pSDETreeViewBase.resetPSCtrlMsgName();
        pSDETreeViewBase.resetPSDEGridId();
        pSDETreeViewBase.resetPSDEGridName();
        pSDETreeViewBase.resetPSDEId();
        pSDETreeViewBase.resetPSDEName();
        pSDETreeViewBase.resetPSDETreeViewId();
        pSDETreeViewBase.resetPSDETreeViewName();
        pSDETreeViewBase.resetPSSysCounterId();
        pSDETreeViewBase.resetPSSysCounterName();
        pSDETreeViewBase.resetPSSysCssId();
        pSDETreeViewBase.resetPSSysCssName();
        pSDETreeViewBase.resetPSSysPFPluginId();
        pSDETreeViewBase.resetPSSysPFPluginName();
        pSDETreeViewBase.resetPSSystemId();
        pSDETreeViewBase.resetPSSystemName();
        pSDETreeViewBase.resetPSViewMsgGroupId();
        pSDETreeViewBase.resetPSViewMsgGroupName();
        pSDETreeViewBase.resetRootSelect();
        pSDETreeViewBase.resetShowRoot();
        pSDETreeViewBase.resetSRFSysPub();
        pSDETreeViewBase.resetToDoTask();
        pSDETreeViewBase.resetTreeGridFlag();
        pSDETreeViewBase.resetTreeModel();
        pSDETreeViewBase.resetTreeStyle();
        pSDETreeViewBase.resetUpdateDate();
        pSDETreeViewBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBufferRendererModeDirty()) {
            hashMap.put(FIELD_BUFFERRENDERERMODE, this.getBufferRendererMode());
        }
        if (!bl || this.isBusyIndicatorDirty()) {
            hashMap.put(FIELD_BUSYINDICATOR, this.getBusyIndicator());
        }
        if (!bl || this.isCatPSCodeListIdDirty()) {
            hashMap.put(FIELD_CATPSCODELISTID, this.getCatPSCodeListId());
        }
        if (!bl || this.isCatPSCodeListNameDirty()) {
            hashMap.put(FIELD_CATPSCODELISTNAME, this.getCatPSCodeListName());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isColEnableFilterDirty()) {
            hashMap.put(FIELD_COLENABLEFILTER, this.getColEnableFilter());
        }
        if (!bl || this.isColEnableLinkDirty()) {
            hashMap.put(FIELD_COLENABLELINK, this.getColEnableLink());
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
        if (!bl || this.isEnableItemPrivDirty()) {
            hashMap.put(FIELD_ENABLEITEMPRIV, this.getEnableItemPriv());
        }
        if (!bl || this.isEnableSearchDirty()) {
            hashMap.put(FIELD_ENABLESEARCH, this.getEnableSearch());
        }
        if (!bl || this.isFrozenColDirty()) {
            hashMap.put(FIELD_FROZENCOL, this.getFrozenCol());
        }
        if (!bl || this.isFrozenLastColDirty()) {
            hashMap.put(FIELD_FROZENLASTCOL, this.getFrozenLastCol());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
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
        if (!bl || this.isNoIconDefaultDirty()) {
            hashMap.put(FIELD_NOICONDEFAULT, this.getNoIconDefault());
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
        if (!bl || this.isPSCtrlMsgIdDirty()) {
            hashMap.put(FIELD_PSCTRLMSGID, this.getPSCtrlMsgId());
        }
        if (!bl || this.isPSCtrlMsgNameDirty()) {
            hashMap.put(FIELD_PSCTRLMSGNAME, this.getPSCtrlMsgName());
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
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDETreeViewIdDirty()) {
            hashMap.put(FIELD_PSDETREEVIEWID, this.getPSDETreeViewId());
        }
        if (!bl || this.isPSDETreeViewNameDirty()) {
            hashMap.put(FIELD_PSDETREEVIEWNAME, this.getPSDETreeViewName());
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
        if (!bl || this.isRootSelectDirty()) {
            hashMap.put(FIELD_ROOTSELECT, this.getRootSelect());
        }
        if (!bl || this.isShowRootDirty()) {
            hashMap.put(FIELD_SHOWROOT, this.getShowRoot());
        }
        if (!bl || this.isSRFSysPubDirty()) {
            hashMap.put(FIELD_SRFSYSPUB, this.getSRFSysPub());
        }
        if (!bl || this.isToDoTaskDirty()) {
            hashMap.put(FIELD_TODOTASK, this.getToDoTask());
        }
        if (!bl || this.isTreeGridFlagDirty()) {
            hashMap.put(FIELD_TREEGRIDFLAG, this.getTreeGridFlag());
        }
        if (!bl || this.isTreeModelDirty()) {
            hashMap.put(FIELD_TREEMODEL, this.getTreeModel());
        }
        if (!bl || this.isTreeStyleDirty()) {
            hashMap.put(FIELD_TREESTYLE, this.getTreeStyle());
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
        return PSDETreeViewBase.get(this, n);
    }

    private static Object get(PSDETreeViewBase pSDETreeViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDETreeViewBase.getBufferRendererMode();
            }
            case 1: {
                return pSDETreeViewBase.getBusyIndicator();
            }
            case 2: {
                return pSDETreeViewBase.getCatPSCodeListId();
            }
            case 3: {
                return pSDETreeViewBase.getCatPSCodeListName();
            }
            case 4: {
                return pSDETreeViewBase.getCodeName();
            }
            case 5: {
                return pSDETreeViewBase.getColEnableFilter();
            }
            case 6: {
                return pSDETreeViewBase.getColEnableLink();
            }
            case 7: {
                return pSDETreeViewBase.getCreateDate();
            }
            case 8: {
                return pSDETreeViewBase.getCreateMan();
            }
            case 9: {
                return pSDETreeViewBase.getEmptyText();
            }
            case 10: {
                return pSDETreeViewBase.getEmptyTextPSLanResId();
            }
            case 11: {
                return pSDETreeViewBase.getEmptyTextPSLanResName();
            }
            case 12: {
                return pSDETreeViewBase.getEnableEdit();
            }
            case 13: {
                return pSDETreeViewBase.getEnableItemPriv();
            }
            case 14: {
                return pSDETreeViewBase.getEnableSearch();
            }
            case 15: {
                return pSDETreeViewBase.getFrozenCol();
            }
            case 16: {
                return pSDETreeViewBase.getFrozenLastCol();
            }
            case 17: {
                return pSDETreeViewBase.getLockFlag();
            }
            case 18: {
                return pSDETreeViewBase.getMemo();
            }
            case 19: {
                return pSDETreeViewBase.getNavViewHeight();
            }
            case 20: {
                return pSDETreeViewBase.getNavViewMaxHeight();
            }
            case 21: {
                return pSDETreeViewBase.getNavViewMaxWidth();
            }
            case 22: {
                return pSDETreeViewBase.getNavViewMinHeight();
            }
            case 23: {
                return pSDETreeViewBase.getNavViewMinWidth();
            }
            case 24: {
                return pSDETreeViewBase.getNavViewPos();
            }
            case 25: {
                return pSDETreeViewBase.getNavViewShowMode();
            }
            case 26: {
                return pSDETreeViewBase.getNavViewWidth();
            }
            case 27: {
                return pSDETreeViewBase.getNoIconDefault();
            }
            case 28: {
                return pSDETreeViewBase.getPSACHandlerId();
            }
            case 29: {
                return pSDETreeViewBase.getPSACHandlerName();
            }
            case 30: {
                return pSDETreeViewBase.getPSCtrlLogicGroupId();
            }
            case 31: {
                return pSDETreeViewBase.getPSCtrlLogicGroupName();
            }
            case 32: {
                return pSDETreeViewBase.getPSCtrlMsgId();
            }
            case 33: {
                return pSDETreeViewBase.getPSCtrlMsgName();
            }
            case 34: {
                return pSDETreeViewBase.getPSDEGridId();
            }
            case 35: {
                return pSDETreeViewBase.getPSDEGridName();
            }
            case 36: {
                return pSDETreeViewBase.getPSDEId();
            }
            case 37: {
                return pSDETreeViewBase.getPSDEName();
            }
            case 38: {
                return pSDETreeViewBase.getPSDETreeViewId();
            }
            case 39: {
                return pSDETreeViewBase.getPSDETreeViewName();
            }
            case 40: {
                return pSDETreeViewBase.getPSSysCounterId();
            }
            case 41: {
                return pSDETreeViewBase.getPSSysCounterName();
            }
            case 42: {
                return pSDETreeViewBase.getPSSysCssId();
            }
            case 43: {
                return pSDETreeViewBase.getPSSysCssName();
            }
            case 44: {
                return pSDETreeViewBase.getPSSysPFPluginId();
            }
            case 45: {
                return pSDETreeViewBase.getPSSysPFPluginName();
            }
            case 46: {
                return pSDETreeViewBase.getPSSystemId();
            }
            case 47: {
                return pSDETreeViewBase.getPSSystemName();
            }
            case 48: {
                return pSDETreeViewBase.getPSViewMsgGroupId();
            }
            case 49: {
                return pSDETreeViewBase.getPSViewMsgGroupName();
            }
            case 50: {
                return pSDETreeViewBase.getRootSelect();
            }
            case 51: {
                return pSDETreeViewBase.getShowRoot();
            }
            case 52: {
                return pSDETreeViewBase.getSRFSysPub();
            }
            case 53: {
                return pSDETreeViewBase.getToDoTask();
            }
            case 54: {
                return pSDETreeViewBase.getTreeGridFlag();
            }
            case 55: {
                return pSDETreeViewBase.getTreeModel();
            }
            case 56: {
                return pSDETreeViewBase.getTreeStyle();
            }
            case 57: {
                return pSDETreeViewBase.getUpdateDate();
            }
            case 58: {
                return pSDETreeViewBase.getUpdateMan();
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
        PSDETreeViewBase.set(this, n, object);
    }

    private static void set(PSDETreeViewBase pSDETreeViewBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDETreeViewBase.setBufferRendererMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDETreeViewBase.setBusyIndicator(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 2: {
                pSDETreeViewBase.setCatPSCodeListId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDETreeViewBase.setCatPSCodeListName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDETreeViewBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDETreeViewBase.setColEnableFilter(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDETreeViewBase.setColEnableLink(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSDETreeViewBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSDETreeViewBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDETreeViewBase.setEmptyText(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDETreeViewBase.setEmptyTextPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDETreeViewBase.setEmptyTextPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDETreeViewBase.setEnableEdit(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSDETreeViewBase.setEnableItemPriv(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSDETreeViewBase.setEnableSearch(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSDETreeViewBase.setFrozenCol(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSDETreeViewBase.setFrozenLastCol(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSDETreeViewBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSDETreeViewBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDETreeViewBase.setNavViewHeight(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 20: {
                pSDETreeViewBase.setNavViewMaxHeight(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 21: {
                pSDETreeViewBase.setNavViewMaxWidth(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 22: {
                pSDETreeViewBase.setNavViewMinHeight(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 23: {
                pSDETreeViewBase.setNavViewMinWidth(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 24: {
                pSDETreeViewBase.setNavViewPos(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDETreeViewBase.setNavViewShowMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 26: {
                pSDETreeViewBase.setNavViewWidth(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 27: {
                pSDETreeViewBase.setNoIconDefault(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 28: {
                pSDETreeViewBase.setPSACHandlerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDETreeViewBase.setPSACHandlerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDETreeViewBase.setPSCtrlLogicGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDETreeViewBase.setPSCtrlLogicGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDETreeViewBase.setPSCtrlMsgId(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDETreeViewBase.setPSCtrlMsgName(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDETreeViewBase.setPSDEGridId(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDETreeViewBase.setPSDEGridName(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDETreeViewBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDETreeViewBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDETreeViewBase.setPSDETreeViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDETreeViewBase.setPSDETreeViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDETreeViewBase.setPSSysCounterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDETreeViewBase.setPSSysCounterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDETreeViewBase.setPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSDETreeViewBase.setPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSDETreeViewBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSDETreeViewBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSDETreeViewBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSDETreeViewBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSDETreeViewBase.setPSViewMsgGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSDETreeViewBase.setPSViewMsgGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSDETreeViewBase.setRootSelect(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 51: {
                pSDETreeViewBase.setShowRoot(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 52: {
                pSDETreeViewBase.setSRFSysPub(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 53: {
                pSDETreeViewBase.setToDoTask(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSDETreeViewBase.setTreeGridFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 55: {
                pSDETreeViewBase.setTreeModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSDETreeViewBase.setTreeStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSDETreeViewBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 58: {
                pSDETreeViewBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDETreeViewBase.isNull(this, n);
    }

    private static boolean isNull(PSDETreeViewBase pSDETreeViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDETreeViewBase.getBufferRendererMode() == null;
            }
            case 1: {
                return pSDETreeViewBase.getBusyIndicator() == null;
            }
            case 2: {
                return pSDETreeViewBase.getCatPSCodeListId() == null;
            }
            case 3: {
                return pSDETreeViewBase.getCatPSCodeListName() == null;
            }
            case 4: {
                return pSDETreeViewBase.getCodeName() == null;
            }
            case 5: {
                return pSDETreeViewBase.getColEnableFilter() == null;
            }
            case 6: {
                return pSDETreeViewBase.getColEnableLink() == null;
            }
            case 7: {
                return pSDETreeViewBase.getCreateDate() == null;
            }
            case 8: {
                return pSDETreeViewBase.getCreateMan() == null;
            }
            case 9: {
                return pSDETreeViewBase.getEmptyText() == null;
            }
            case 10: {
                return pSDETreeViewBase.getEmptyTextPSLanResId() == null;
            }
            case 11: {
                return pSDETreeViewBase.getEmptyTextPSLanResName() == null;
            }
            case 12: {
                return pSDETreeViewBase.getEnableEdit() == null;
            }
            case 13: {
                return pSDETreeViewBase.getEnableItemPriv() == null;
            }
            case 14: {
                return pSDETreeViewBase.getEnableSearch() == null;
            }
            case 15: {
                return pSDETreeViewBase.getFrozenCol() == null;
            }
            case 16: {
                return pSDETreeViewBase.getFrozenLastCol() == null;
            }
            case 17: {
                return pSDETreeViewBase.getLockFlag() == null;
            }
            case 18: {
                return pSDETreeViewBase.getMemo() == null;
            }
            case 19: {
                return pSDETreeViewBase.getNavViewHeight() == null;
            }
            case 20: {
                return pSDETreeViewBase.getNavViewMaxHeight() == null;
            }
            case 21: {
                return pSDETreeViewBase.getNavViewMaxWidth() == null;
            }
            case 22: {
                return pSDETreeViewBase.getNavViewMinHeight() == null;
            }
            case 23: {
                return pSDETreeViewBase.getNavViewMinWidth() == null;
            }
            case 24: {
                return pSDETreeViewBase.getNavViewPos() == null;
            }
            case 25: {
                return pSDETreeViewBase.getNavViewShowMode() == null;
            }
            case 26: {
                return pSDETreeViewBase.getNavViewWidth() == null;
            }
            case 27: {
                return pSDETreeViewBase.getNoIconDefault() == null;
            }
            case 28: {
                return pSDETreeViewBase.getPSACHandlerId() == null;
            }
            case 29: {
                return pSDETreeViewBase.getPSACHandlerName() == null;
            }
            case 30: {
                return pSDETreeViewBase.getPSCtrlLogicGroupId() == null;
            }
            case 31: {
                return pSDETreeViewBase.getPSCtrlLogicGroupName() == null;
            }
            case 32: {
                return pSDETreeViewBase.getPSCtrlMsgId() == null;
            }
            case 33: {
                return pSDETreeViewBase.getPSCtrlMsgName() == null;
            }
            case 34: {
                return pSDETreeViewBase.getPSDEGridId() == null;
            }
            case 35: {
                return pSDETreeViewBase.getPSDEGridName() == null;
            }
            case 36: {
                return pSDETreeViewBase.getPSDEId() == null;
            }
            case 37: {
                return pSDETreeViewBase.getPSDEName() == null;
            }
            case 38: {
                return pSDETreeViewBase.getPSDETreeViewId() == null;
            }
            case 39: {
                return pSDETreeViewBase.getPSDETreeViewName() == null;
            }
            case 40: {
                return pSDETreeViewBase.getPSSysCounterId() == null;
            }
            case 41: {
                return pSDETreeViewBase.getPSSysCounterName() == null;
            }
            case 42: {
                return pSDETreeViewBase.getPSSysCssId() == null;
            }
            case 43: {
                return pSDETreeViewBase.getPSSysCssName() == null;
            }
            case 44: {
                return pSDETreeViewBase.getPSSysPFPluginId() == null;
            }
            case 45: {
                return pSDETreeViewBase.getPSSysPFPluginName() == null;
            }
            case 46: {
                return pSDETreeViewBase.getPSSystemId() == null;
            }
            case 47: {
                return pSDETreeViewBase.getPSSystemName() == null;
            }
            case 48: {
                return pSDETreeViewBase.getPSViewMsgGroupId() == null;
            }
            case 49: {
                return pSDETreeViewBase.getPSViewMsgGroupName() == null;
            }
            case 50: {
                return pSDETreeViewBase.getRootSelect() == null;
            }
            case 51: {
                return pSDETreeViewBase.getShowRoot() == null;
            }
            case 52: {
                return pSDETreeViewBase.getSRFSysPub() == null;
            }
            case 53: {
                return pSDETreeViewBase.getToDoTask() == null;
            }
            case 54: {
                return pSDETreeViewBase.getTreeGridFlag() == null;
            }
            case 55: {
                return pSDETreeViewBase.getTreeModel() == null;
            }
            case 56: {
                return pSDETreeViewBase.getTreeStyle() == null;
            }
            case 57: {
                return pSDETreeViewBase.getUpdateDate() == null;
            }
            case 58: {
                return pSDETreeViewBase.getUpdateMan() == null;
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
        return PSDETreeViewBase.contains(this, n);
    }

    private static boolean contains(PSDETreeViewBase pSDETreeViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDETreeViewBase.isBufferRendererModeDirty();
            }
            case 1: {
                return pSDETreeViewBase.isBusyIndicatorDirty();
            }
            case 2: {
                return pSDETreeViewBase.isCatPSCodeListIdDirty();
            }
            case 3: {
                return pSDETreeViewBase.isCatPSCodeListNameDirty();
            }
            case 4: {
                return pSDETreeViewBase.isCodeNameDirty();
            }
            case 5: {
                return pSDETreeViewBase.isColEnableFilterDirty();
            }
            case 6: {
                return pSDETreeViewBase.isColEnableLinkDirty();
            }
            case 7: {
                return pSDETreeViewBase.isCreateDateDirty();
            }
            case 8: {
                return pSDETreeViewBase.isCreateManDirty();
            }
            case 9: {
                return pSDETreeViewBase.isEmptyTextDirty();
            }
            case 10: {
                return pSDETreeViewBase.isEmptyTextPSLanResIdDirty();
            }
            case 11: {
                return pSDETreeViewBase.isEmptyTextPSLanResNameDirty();
            }
            case 12: {
                return pSDETreeViewBase.isEnableEditDirty();
            }
            case 13: {
                return pSDETreeViewBase.isEnableItemPrivDirty();
            }
            case 14: {
                return pSDETreeViewBase.isEnableSearchDirty();
            }
            case 15: {
                return pSDETreeViewBase.isFrozenColDirty();
            }
            case 16: {
                return pSDETreeViewBase.isFrozenLastColDirty();
            }
            case 17: {
                return pSDETreeViewBase.isLockFlagDirty();
            }
            case 18: {
                return pSDETreeViewBase.isMemoDirty();
            }
            case 19: {
                return pSDETreeViewBase.isNavViewHeightDirty();
            }
            case 20: {
                return pSDETreeViewBase.isNavViewMaxHeightDirty();
            }
            case 21: {
                return pSDETreeViewBase.isNavViewMaxWidthDirty();
            }
            case 22: {
                return pSDETreeViewBase.isNavViewMinHeightDirty();
            }
            case 23: {
                return pSDETreeViewBase.isNavViewMinWidthDirty();
            }
            case 24: {
                return pSDETreeViewBase.isNavViewPosDirty();
            }
            case 25: {
                return pSDETreeViewBase.isNavViewShowModeDirty();
            }
            case 26: {
                return pSDETreeViewBase.isNavViewWidthDirty();
            }
            case 27: {
                return pSDETreeViewBase.isNoIconDefaultDirty();
            }
            case 28: {
                return pSDETreeViewBase.isPSACHandlerIdDirty();
            }
            case 29: {
                return pSDETreeViewBase.isPSACHandlerNameDirty();
            }
            case 30: {
                return pSDETreeViewBase.isPSCtrlLogicGroupIdDirty();
            }
            case 31: {
                return pSDETreeViewBase.isPSCtrlLogicGroupNameDirty();
            }
            case 32: {
                return pSDETreeViewBase.isPSCtrlMsgIdDirty();
            }
            case 33: {
                return pSDETreeViewBase.isPSCtrlMsgNameDirty();
            }
            case 34: {
                return pSDETreeViewBase.isPSDEGridIdDirty();
            }
            case 35: {
                return pSDETreeViewBase.isPSDEGridNameDirty();
            }
            case 36: {
                return pSDETreeViewBase.isPSDEIdDirty();
            }
            case 37: {
                return pSDETreeViewBase.isPSDENameDirty();
            }
            case 38: {
                return pSDETreeViewBase.isPSDETreeViewIdDirty();
            }
            case 39: {
                return pSDETreeViewBase.isPSDETreeViewNameDirty();
            }
            case 40: {
                return pSDETreeViewBase.isPSSysCounterIdDirty();
            }
            case 41: {
                return pSDETreeViewBase.isPSSysCounterNameDirty();
            }
            case 42: {
                return pSDETreeViewBase.isPSSysCssIdDirty();
            }
            case 43: {
                return pSDETreeViewBase.isPSSysCssNameDirty();
            }
            case 44: {
                return pSDETreeViewBase.isPSSysPFPluginIdDirty();
            }
            case 45: {
                return pSDETreeViewBase.isPSSysPFPluginNameDirty();
            }
            case 46: {
                return pSDETreeViewBase.isPSSystemIdDirty();
            }
            case 47: {
                return pSDETreeViewBase.isPSSystemNameDirty();
            }
            case 48: {
                return pSDETreeViewBase.isPSViewMsgGroupIdDirty();
            }
            case 49: {
                return pSDETreeViewBase.isPSViewMsgGroupNameDirty();
            }
            case 50: {
                return pSDETreeViewBase.isRootSelectDirty();
            }
            case 51: {
                return pSDETreeViewBase.isShowRootDirty();
            }
            case 52: {
                return pSDETreeViewBase.isSRFSysPubDirty();
            }
            case 53: {
                return pSDETreeViewBase.isToDoTaskDirty();
            }
            case 54: {
                return pSDETreeViewBase.isTreeGridFlagDirty();
            }
            case 55: {
                return pSDETreeViewBase.isTreeModelDirty();
            }
            case 56: {
                return pSDETreeViewBase.isTreeStyleDirty();
            }
            case 57: {
                return pSDETreeViewBase.isUpdateDateDirty();
            }
            case 58: {
                return pSDETreeViewBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDETreeViewBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDETreeViewBase pSDETreeViewBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDETreeViewBase.getBufferRendererMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bufferrenderermode", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getBufferRendererMode()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getBusyIndicator() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"busyindicator", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getBusyIndicator()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getCatPSCodeListId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"catpscodelistid", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getCatPSCodeListId()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getCatPSCodeListName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"catpscodelistname", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getCatPSCodeListName()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getColEnableFilter() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"colenablefilter", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getColEnableFilter()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getColEnableLink() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"colenablelink", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getColEnableLink()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getEmptyText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"emptytext", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getEmptyText()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getEmptyTextPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"emptytextpslanresid", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getEmptyTextPSLanResId()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getEmptyTextPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"emptytextpslanresname", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getEmptyTextPSLanResName()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getEnableEdit() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableedit", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getEnableEdit()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getEnableItemPriv() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableitempriv", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getEnableItemPriv()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getEnableSearch() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablesearch", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getEnableSearch()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getFrozenCol() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"frozencol", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getFrozenCol()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getFrozenLastCol() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"frozenlastcol", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getFrozenLastCol()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getMemo()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getNavViewHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewheight", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getNavViewHeight()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getNavViewMaxHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewmaxheight", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getNavViewMaxHeight()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getNavViewMaxWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewmaxwidth", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getNavViewMaxWidth()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getNavViewMinHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewminheight", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getNavViewMinHeight()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getNavViewMinWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewminwidth", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getNavViewMinWidth()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getNavViewPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewpos", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getNavViewPos()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getNavViewShowMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewshowmode", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getNavViewShowMode()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getNavViewWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewwidth", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getNavViewWidth()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getNoIconDefault() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"noicondefault", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getNoIconDefault()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getPSACHandlerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psachandlerid", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getPSACHandlerId()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getPSACHandlerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psachandlername", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getPSACHandlerName()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getPSCtrlLogicGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrllogicgroupid", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getPSCtrlLogicGroupId()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getPSCtrlLogicGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrllogicgroupname", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getPSCtrlLogicGroupName()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getPSCtrlMsgId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrlmsgid", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getPSCtrlMsgId()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getPSCtrlMsgName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrlmsgname", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getPSCtrlMsgName()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getPSDEGridId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdegridid", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getPSDEGridId()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getPSDEGridName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdegridname", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getPSDEGridName()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getPSDETreeViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetreeviewid", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getPSDETreeViewId()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getPSDETreeViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetreeviewname", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getPSDETreeViewName()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getPSSysCounterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscounterid", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getPSSysCounterId()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getPSSysCounterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscountername", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getPSSysCounterName()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssid", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getPSSysCssId()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssname", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getPSSysCssName()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getPSViewMsgGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewmsggroupid", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getPSViewMsgGroupId()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getPSViewMsgGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewmsggroupname", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getPSViewMsgGroupName()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getRootSelect() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rootselect", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getRootSelect()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getShowRoot() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"showroot", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getShowRoot()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getSRFSysPub() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srfsyspub", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getSRFSysPub()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getToDoTask() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"todotask", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getToDoTask()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getTreeGridFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"treegridflag", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getTreeGridFlag()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getTreeModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"treemodel", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getTreeModel()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getTreeStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"treestyle", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getTreeStyle()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDETreeViewBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDETreeViewBase.getJSONValue((Object)pSDETreeViewBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDETreeViewBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDETreeViewBase pSDETreeViewBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDETreeViewBase.getBufferRendererMode() != null) {
            object = pSDETreeViewBase.getBufferRendererMode();
            xmlNode.setAttribute(FIELD_BUFFERRENDERERMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeViewBase.getBusyIndicator() != null) {
            object = pSDETreeViewBase.getBusyIndicator();
            xmlNode.setAttribute(FIELD_BUSYINDICATOR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeViewBase.getCatPSCodeListId() != null) {
            object = pSDETreeViewBase.getCatPSCodeListId();
            xmlNode.setAttribute(FIELD_CATPSCODELISTID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeViewBase.getCatPSCodeListName() != null) {
            object = pSDETreeViewBase.getCatPSCodeListName();
            xmlNode.setAttribute(FIELD_CATPSCODELISTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeViewBase.getCodeName() != null) {
            object = pSDETreeViewBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeViewBase.getColEnableFilter() != null) {
            object = pSDETreeViewBase.getColEnableFilter();
            xmlNode.setAttribute(FIELD_COLENABLEFILTER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeViewBase.getColEnableLink() != null) {
            object = pSDETreeViewBase.getColEnableLink();
            xmlNode.setAttribute(FIELD_COLENABLELINK, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeViewBase.getCreateDate() != null) {
            object = pSDETreeViewBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDETreeViewBase.getCreateMan() != null) {
            object = pSDETreeViewBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeViewBase.getEmptyText() != null) {
            object = pSDETreeViewBase.getEmptyText();
            xmlNode.setAttribute(FIELD_EMPTYTEXT, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeViewBase.getEmptyTextPSLanResId() != null) {
            object = pSDETreeViewBase.getEmptyTextPSLanResId();
            xmlNode.setAttribute(FIELD_EMPTYTEXTPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeViewBase.getEmptyTextPSLanResName() != null) {
            object = pSDETreeViewBase.getEmptyTextPSLanResName();
            xmlNode.setAttribute(FIELD_EMPTYTEXTPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeViewBase.getEnableEdit() != null) {
            object = pSDETreeViewBase.getEnableEdit();
            xmlNode.setAttribute(FIELD_ENABLEEDIT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeViewBase.getEnableItemPriv() != null) {
            object = pSDETreeViewBase.getEnableItemPriv();
            xmlNode.setAttribute(FIELD_ENABLEITEMPRIV, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeViewBase.getEnableSearch() != null) {
            object = pSDETreeViewBase.getEnableSearch();
            xmlNode.setAttribute(FIELD_ENABLESEARCH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeViewBase.getFrozenCol() != null) {
            object = pSDETreeViewBase.getFrozenCol();
            xmlNode.setAttribute(FIELD_FROZENCOL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeViewBase.getFrozenLastCol() != null) {
            object = pSDETreeViewBase.getFrozenLastCol();
            xmlNode.setAttribute(FIELD_FROZENLASTCOL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeViewBase.getLockFlag() != null) {
            object = pSDETreeViewBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeViewBase.getMemo() != null) {
            object = pSDETreeViewBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeViewBase.getNavViewHeight() != null) {
            object = pSDETreeViewBase.getNavViewHeight();
            xmlNode.setAttribute(FIELD_NAVVIEWHEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeViewBase.getNavViewMaxHeight() != null) {
            object = pSDETreeViewBase.getNavViewMaxHeight();
            xmlNode.setAttribute(FIELD_NAVVIEWMAXHEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeViewBase.getNavViewMaxWidth() != null) {
            object = pSDETreeViewBase.getNavViewMaxWidth();
            xmlNode.setAttribute(FIELD_NAVVIEWMAXWIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeViewBase.getNavViewMinHeight() != null) {
            object = pSDETreeViewBase.getNavViewMinHeight();
            xmlNode.setAttribute(FIELD_NAVVIEWMINHEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeViewBase.getNavViewMinWidth() != null) {
            object = pSDETreeViewBase.getNavViewMinWidth();
            xmlNode.setAttribute(FIELD_NAVVIEWMINWIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeViewBase.getNavViewPos() != null) {
            object = pSDETreeViewBase.getNavViewPos();
            xmlNode.setAttribute(FIELD_NAVVIEWPOS, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeViewBase.getNavViewShowMode() != null) {
            object = pSDETreeViewBase.getNavViewShowMode();
            xmlNode.setAttribute(FIELD_NAVVIEWSHOWMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeViewBase.getNavViewWidth() != null) {
            object = pSDETreeViewBase.getNavViewWidth();
            xmlNode.setAttribute(FIELD_NAVVIEWWIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeViewBase.getNoIconDefault() != null) {
            object = pSDETreeViewBase.getNoIconDefault();
            xmlNode.setAttribute(FIELD_NOICONDEFAULT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeViewBase.getPSACHandlerId() != null) {
            object = pSDETreeViewBase.getPSACHandlerId();
            xmlNode.setAttribute(FIELD_PSACHANDLERID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeViewBase.getPSACHandlerName() != null) {
            object = pSDETreeViewBase.getPSACHandlerName();
            xmlNode.setAttribute(FIELD_PSACHANDLERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeViewBase.getPSCtrlLogicGroupId() != null) {
            object = pSDETreeViewBase.getPSCtrlLogicGroupId();
            xmlNode.setAttribute(FIELD_PSCTRLLOGICGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeViewBase.getPSCtrlLogicGroupName() != null) {
            object = pSDETreeViewBase.getPSCtrlLogicGroupName();
            xmlNode.setAttribute(FIELD_PSCTRLLOGICGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeViewBase.getPSCtrlMsgId() != null) {
            object = pSDETreeViewBase.getPSCtrlMsgId();
            xmlNode.setAttribute(FIELD_PSCTRLMSGID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeViewBase.getPSCtrlMsgName() != null) {
            object = pSDETreeViewBase.getPSCtrlMsgName();
            xmlNode.setAttribute(FIELD_PSCTRLMSGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeViewBase.getPSDEGridId() != null) {
            object = pSDETreeViewBase.getPSDEGridId();
            xmlNode.setAttribute(FIELD_PSDEGRIDID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeViewBase.getPSDEGridName() != null) {
            object = pSDETreeViewBase.getPSDEGridName();
            xmlNode.setAttribute(FIELD_PSDEGRIDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeViewBase.getPSDEId() != null) {
            object = pSDETreeViewBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeViewBase.getPSDEName() != null) {
            object = pSDETreeViewBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeViewBase.getPSDETreeViewId() != null) {
            object = pSDETreeViewBase.getPSDETreeViewId();
            xmlNode.setAttribute(FIELD_PSDETREEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeViewBase.getPSDETreeViewName() != null) {
            object = pSDETreeViewBase.getPSDETreeViewName();
            xmlNode.setAttribute(FIELD_PSDETREEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeViewBase.getPSSysCounterId() != null) {
            object = pSDETreeViewBase.getPSSysCounterId();
            xmlNode.setAttribute(FIELD_PSSYSCOUNTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeViewBase.getPSSysCounterName() != null) {
            object = pSDETreeViewBase.getPSSysCounterName();
            xmlNode.setAttribute(FIELD_PSSYSCOUNTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeViewBase.getPSSysCssId() != null) {
            object = pSDETreeViewBase.getPSSysCssId();
            xmlNode.setAttribute(FIELD_PSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeViewBase.getPSSysCssName() != null) {
            object = pSDETreeViewBase.getPSSysCssName();
            xmlNode.setAttribute(FIELD_PSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeViewBase.getPSSysPFPluginId() != null) {
            object = pSDETreeViewBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeViewBase.getPSSysPFPluginName() != null) {
            object = pSDETreeViewBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeViewBase.getPSSystemId() != null) {
            object = pSDETreeViewBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeViewBase.getPSSystemName() != null) {
            object = pSDETreeViewBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeViewBase.getPSViewMsgGroupId() != null) {
            object = pSDETreeViewBase.getPSViewMsgGroupId();
            xmlNode.setAttribute(FIELD_PSVIEWMSGGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeViewBase.getPSViewMsgGroupName() != null) {
            object = pSDETreeViewBase.getPSViewMsgGroupName();
            xmlNode.setAttribute(FIELD_PSVIEWMSGGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeViewBase.getRootSelect() != null) {
            object = pSDETreeViewBase.getRootSelect();
            xmlNode.setAttribute(FIELD_ROOTSELECT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeViewBase.getShowRoot() != null) {
            object = pSDETreeViewBase.getShowRoot();
            xmlNode.setAttribute(FIELD_SHOWROOT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeViewBase.getSRFSysPub() != null) {
            object = pSDETreeViewBase.getSRFSysPub();
            xmlNode.setAttribute(FIELD_SRFSYSPUB, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeViewBase.getToDoTask() != null) {
            object = pSDETreeViewBase.getToDoTask();
            xmlNode.setAttribute(FIELD_TODOTASK, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeViewBase.getTreeGridFlag() != null) {
            object = pSDETreeViewBase.getTreeGridFlag();
            xmlNode.setAttribute(FIELD_TREEGRIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeViewBase.getTreeModel() != null) {
            object = pSDETreeViewBase.getTreeModel();
            xmlNode.setAttribute(FIELD_TREEMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeViewBase.getTreeStyle() != null) {
            object = pSDETreeViewBase.getTreeStyle();
            xmlNode.setAttribute(FIELD_TREESTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeViewBase.getUpdateDate() != null) {
            object = pSDETreeViewBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDETreeViewBase.getUpdateMan() != null) {
            object = pSDETreeViewBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDETreeViewBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDETreeViewBase pSDETreeViewBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDETreeViewBase.isBufferRendererModeDirty() && (bl || pSDETreeViewBase.getBufferRendererMode() != null)) {
            iDataObject.set(FIELD_BUFFERRENDERERMODE, (Object)pSDETreeViewBase.getBufferRendererMode());
        }
        if (pSDETreeViewBase.isBusyIndicatorDirty() && (bl || pSDETreeViewBase.getBusyIndicator() != null)) {
            iDataObject.set(FIELD_BUSYINDICATOR, (Object)pSDETreeViewBase.getBusyIndicator());
        }
        if (pSDETreeViewBase.isCatPSCodeListIdDirty() && (bl || pSDETreeViewBase.getCatPSCodeListId() != null)) {
            iDataObject.set(FIELD_CATPSCODELISTID, (Object)pSDETreeViewBase.getCatPSCodeListId());
        }
        if (pSDETreeViewBase.isCatPSCodeListNameDirty() && (bl || pSDETreeViewBase.getCatPSCodeListName() != null)) {
            iDataObject.set(FIELD_CATPSCODELISTNAME, (Object)pSDETreeViewBase.getCatPSCodeListName());
        }
        if (pSDETreeViewBase.isCodeNameDirty() && (bl || pSDETreeViewBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDETreeViewBase.getCodeName());
        }
        if (pSDETreeViewBase.isColEnableFilterDirty() && (bl || pSDETreeViewBase.getColEnableFilter() != null)) {
            iDataObject.set(FIELD_COLENABLEFILTER, (Object)pSDETreeViewBase.getColEnableFilter());
        }
        if (pSDETreeViewBase.isColEnableLinkDirty() && (bl || pSDETreeViewBase.getColEnableLink() != null)) {
            iDataObject.set(FIELD_COLENABLELINK, (Object)pSDETreeViewBase.getColEnableLink());
        }
        if (pSDETreeViewBase.isCreateDateDirty() && (bl || pSDETreeViewBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDETreeViewBase.getCreateDate());
        }
        if (pSDETreeViewBase.isCreateManDirty() && (bl || pSDETreeViewBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDETreeViewBase.getCreateMan());
        }
        if (pSDETreeViewBase.isEmptyTextDirty() && (bl || pSDETreeViewBase.getEmptyText() != null)) {
            iDataObject.set(FIELD_EMPTYTEXT, (Object)pSDETreeViewBase.getEmptyText());
        }
        if (pSDETreeViewBase.isEmptyTextPSLanResIdDirty() && (bl || pSDETreeViewBase.getEmptyTextPSLanResId() != null)) {
            iDataObject.set(FIELD_EMPTYTEXTPSLANRESID, (Object)pSDETreeViewBase.getEmptyTextPSLanResId());
        }
        if (pSDETreeViewBase.isEmptyTextPSLanResNameDirty() && (bl || pSDETreeViewBase.getEmptyTextPSLanResName() != null)) {
            iDataObject.set(FIELD_EMPTYTEXTPSLANRESNAME, (Object)pSDETreeViewBase.getEmptyTextPSLanResName());
        }
        if (pSDETreeViewBase.isEnableEditDirty() && (bl || pSDETreeViewBase.getEnableEdit() != null)) {
            iDataObject.set(FIELD_ENABLEEDIT, (Object)pSDETreeViewBase.getEnableEdit());
        }
        if (pSDETreeViewBase.isEnableItemPrivDirty() && (bl || pSDETreeViewBase.getEnableItemPriv() != null)) {
            iDataObject.set(FIELD_ENABLEITEMPRIV, (Object)pSDETreeViewBase.getEnableItemPriv());
        }
        if (pSDETreeViewBase.isEnableSearchDirty() && (bl || pSDETreeViewBase.getEnableSearch() != null)) {
            iDataObject.set(FIELD_ENABLESEARCH, (Object)pSDETreeViewBase.getEnableSearch());
        }
        if (pSDETreeViewBase.isFrozenColDirty() && (bl || pSDETreeViewBase.getFrozenCol() != null)) {
            iDataObject.set(FIELD_FROZENCOL, (Object)pSDETreeViewBase.getFrozenCol());
        }
        if (pSDETreeViewBase.isFrozenLastColDirty() && (bl || pSDETreeViewBase.getFrozenLastCol() != null)) {
            iDataObject.set(FIELD_FROZENLASTCOL, (Object)pSDETreeViewBase.getFrozenLastCol());
        }
        if (pSDETreeViewBase.isLockFlagDirty() && (bl || pSDETreeViewBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSDETreeViewBase.getLockFlag());
        }
        if (pSDETreeViewBase.isMemoDirty() && (bl || pSDETreeViewBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDETreeViewBase.getMemo());
        }
        if (pSDETreeViewBase.isNavViewHeightDirty() && (bl || pSDETreeViewBase.getNavViewHeight() != null)) {
            iDataObject.set(FIELD_NAVVIEWHEIGHT, (Object)pSDETreeViewBase.getNavViewHeight());
        }
        if (pSDETreeViewBase.isNavViewMaxHeightDirty() && (bl || pSDETreeViewBase.getNavViewMaxHeight() != null)) {
            iDataObject.set(FIELD_NAVVIEWMAXHEIGHT, (Object)pSDETreeViewBase.getNavViewMaxHeight());
        }
        if (pSDETreeViewBase.isNavViewMaxWidthDirty() && (bl || pSDETreeViewBase.getNavViewMaxWidth() != null)) {
            iDataObject.set(FIELD_NAVVIEWMAXWIDTH, (Object)pSDETreeViewBase.getNavViewMaxWidth());
        }
        if (pSDETreeViewBase.isNavViewMinHeightDirty() && (bl || pSDETreeViewBase.getNavViewMinHeight() != null)) {
            iDataObject.set(FIELD_NAVVIEWMINHEIGHT, (Object)pSDETreeViewBase.getNavViewMinHeight());
        }
        if (pSDETreeViewBase.isNavViewMinWidthDirty() && (bl || pSDETreeViewBase.getNavViewMinWidth() != null)) {
            iDataObject.set(FIELD_NAVVIEWMINWIDTH, (Object)pSDETreeViewBase.getNavViewMinWidth());
        }
        if (pSDETreeViewBase.isNavViewPosDirty() && (bl || pSDETreeViewBase.getNavViewPos() != null)) {
            iDataObject.set(FIELD_NAVVIEWPOS, (Object)pSDETreeViewBase.getNavViewPos());
        }
        if (pSDETreeViewBase.isNavViewShowModeDirty() && (bl || pSDETreeViewBase.getNavViewShowMode() != null)) {
            iDataObject.set(FIELD_NAVVIEWSHOWMODE, (Object)pSDETreeViewBase.getNavViewShowMode());
        }
        if (pSDETreeViewBase.isNavViewWidthDirty() && (bl || pSDETreeViewBase.getNavViewWidth() != null)) {
            iDataObject.set(FIELD_NAVVIEWWIDTH, (Object)pSDETreeViewBase.getNavViewWidth());
        }
        if (pSDETreeViewBase.isNoIconDefaultDirty() && (bl || pSDETreeViewBase.getNoIconDefault() != null)) {
            iDataObject.set(FIELD_NOICONDEFAULT, (Object)pSDETreeViewBase.getNoIconDefault());
        }
        if (pSDETreeViewBase.isPSACHandlerIdDirty() && (bl || pSDETreeViewBase.getPSACHandlerId() != null)) {
            iDataObject.set(FIELD_PSACHANDLERID, (Object)pSDETreeViewBase.getPSACHandlerId());
        }
        if (pSDETreeViewBase.isPSACHandlerNameDirty() && (bl || pSDETreeViewBase.getPSACHandlerName() != null)) {
            iDataObject.set(FIELD_PSACHANDLERNAME, (Object)pSDETreeViewBase.getPSACHandlerName());
        }
        if (pSDETreeViewBase.isPSCtrlLogicGroupIdDirty() && (bl || pSDETreeViewBase.getPSCtrlLogicGroupId() != null)) {
            iDataObject.set(FIELD_PSCTRLLOGICGROUPID, (Object)pSDETreeViewBase.getPSCtrlLogicGroupId());
        }
        if (pSDETreeViewBase.isPSCtrlLogicGroupNameDirty() && (bl || pSDETreeViewBase.getPSCtrlLogicGroupName() != null)) {
            iDataObject.set(FIELD_PSCTRLLOGICGROUPNAME, (Object)pSDETreeViewBase.getPSCtrlLogicGroupName());
        }
        if (pSDETreeViewBase.isPSCtrlMsgIdDirty() && (bl || pSDETreeViewBase.getPSCtrlMsgId() != null)) {
            iDataObject.set(FIELD_PSCTRLMSGID, (Object)pSDETreeViewBase.getPSCtrlMsgId());
        }
        if (pSDETreeViewBase.isPSCtrlMsgNameDirty() && (bl || pSDETreeViewBase.getPSCtrlMsgName() != null)) {
            iDataObject.set(FIELD_PSCTRLMSGNAME, (Object)pSDETreeViewBase.getPSCtrlMsgName());
        }
        if (pSDETreeViewBase.isPSDEGridIdDirty() && (bl || pSDETreeViewBase.getPSDEGridId() != null)) {
            iDataObject.set(FIELD_PSDEGRIDID, (Object)pSDETreeViewBase.getPSDEGridId());
        }
        if (pSDETreeViewBase.isPSDEGridNameDirty() && (bl || pSDETreeViewBase.getPSDEGridName() != null)) {
            iDataObject.set(FIELD_PSDEGRIDNAME, (Object)pSDETreeViewBase.getPSDEGridName());
        }
        if (pSDETreeViewBase.isPSDEIdDirty() && (bl || pSDETreeViewBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDETreeViewBase.getPSDEId());
        }
        if (pSDETreeViewBase.isPSDENameDirty() && (bl || pSDETreeViewBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDETreeViewBase.getPSDEName());
        }
        if (pSDETreeViewBase.isPSDETreeViewIdDirty() && (bl || pSDETreeViewBase.getPSDETreeViewId() != null)) {
            iDataObject.set(FIELD_PSDETREEVIEWID, (Object)pSDETreeViewBase.getPSDETreeViewId());
        }
        if (pSDETreeViewBase.isPSDETreeViewNameDirty() && (bl || pSDETreeViewBase.getPSDETreeViewName() != null)) {
            iDataObject.set(FIELD_PSDETREEVIEWNAME, (Object)pSDETreeViewBase.getPSDETreeViewName());
        }
        if (pSDETreeViewBase.isPSSysCounterIdDirty() && (bl || pSDETreeViewBase.getPSSysCounterId() != null)) {
            iDataObject.set(FIELD_PSSYSCOUNTERID, (Object)pSDETreeViewBase.getPSSysCounterId());
        }
        if (pSDETreeViewBase.isPSSysCounterNameDirty() && (bl || pSDETreeViewBase.getPSSysCounterName() != null)) {
            iDataObject.set(FIELD_PSSYSCOUNTERNAME, (Object)pSDETreeViewBase.getPSSysCounterName());
        }
        if (pSDETreeViewBase.isPSSysCssIdDirty() && (bl || pSDETreeViewBase.getPSSysCssId() != null)) {
            iDataObject.set(FIELD_PSSYSCSSID, (Object)pSDETreeViewBase.getPSSysCssId());
        }
        if (pSDETreeViewBase.isPSSysCssNameDirty() && (bl || pSDETreeViewBase.getPSSysCssName() != null)) {
            iDataObject.set(FIELD_PSSYSCSSNAME, (Object)pSDETreeViewBase.getPSSysCssName());
        }
        if (pSDETreeViewBase.isPSSysPFPluginIdDirty() && (bl || pSDETreeViewBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSDETreeViewBase.getPSSysPFPluginId());
        }
        if (pSDETreeViewBase.isPSSysPFPluginNameDirty() && (bl || pSDETreeViewBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSDETreeViewBase.getPSSysPFPluginName());
        }
        if (pSDETreeViewBase.isPSSystemIdDirty() && (bl || pSDETreeViewBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSDETreeViewBase.getPSSystemId());
        }
        if (pSDETreeViewBase.isPSSystemNameDirty() && (bl || pSDETreeViewBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSDETreeViewBase.getPSSystemName());
        }
        if (pSDETreeViewBase.isPSViewMsgGroupIdDirty() && (bl || pSDETreeViewBase.getPSViewMsgGroupId() != null)) {
            iDataObject.set(FIELD_PSVIEWMSGGROUPID, (Object)pSDETreeViewBase.getPSViewMsgGroupId());
        }
        if (pSDETreeViewBase.isPSViewMsgGroupNameDirty() && (bl || pSDETreeViewBase.getPSViewMsgGroupName() != null)) {
            iDataObject.set(FIELD_PSVIEWMSGGROUPNAME, (Object)pSDETreeViewBase.getPSViewMsgGroupName());
        }
        if (pSDETreeViewBase.isRootSelectDirty() && (bl || pSDETreeViewBase.getRootSelect() != null)) {
            iDataObject.set(FIELD_ROOTSELECT, (Object)pSDETreeViewBase.getRootSelect());
        }
        if (pSDETreeViewBase.isShowRootDirty() && (bl || pSDETreeViewBase.getShowRoot() != null)) {
            iDataObject.set(FIELD_SHOWROOT, (Object)pSDETreeViewBase.getShowRoot());
        }
        if (pSDETreeViewBase.isSRFSysPubDirty() && (bl || pSDETreeViewBase.getSRFSysPub() != null)) {
            iDataObject.set(FIELD_SRFSYSPUB, (Object)pSDETreeViewBase.getSRFSysPub());
        }
        if (pSDETreeViewBase.isToDoTaskDirty() && (bl || pSDETreeViewBase.getToDoTask() != null)) {
            iDataObject.set(FIELD_TODOTASK, (Object)pSDETreeViewBase.getToDoTask());
        }
        if (pSDETreeViewBase.isTreeGridFlagDirty() && (bl || pSDETreeViewBase.getTreeGridFlag() != null)) {
            iDataObject.set(FIELD_TREEGRIDFLAG, (Object)pSDETreeViewBase.getTreeGridFlag());
        }
        if (pSDETreeViewBase.isTreeModelDirty() && (bl || pSDETreeViewBase.getTreeModel() != null)) {
            iDataObject.set(FIELD_TREEMODEL, (Object)pSDETreeViewBase.getTreeModel());
        }
        if (pSDETreeViewBase.isTreeStyleDirty() && (bl || pSDETreeViewBase.getTreeStyle() != null)) {
            iDataObject.set(FIELD_TREESTYLE, (Object)pSDETreeViewBase.getTreeStyle());
        }
        if (pSDETreeViewBase.isUpdateDateDirty() && (bl || pSDETreeViewBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDETreeViewBase.getUpdateDate());
        }
        if (pSDETreeViewBase.isUpdateManDirty() && (bl || pSDETreeViewBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDETreeViewBase.getUpdateMan());
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
        return PSDETreeViewBase.remove(this, n);
    }

    private static boolean remove(PSDETreeViewBase pSDETreeViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDETreeViewBase.resetBufferRendererMode();
                return true;
            }
            case 1: {
                pSDETreeViewBase.resetBusyIndicator();
                return true;
            }
            case 2: {
                pSDETreeViewBase.resetCatPSCodeListId();
                return true;
            }
            case 3: {
                pSDETreeViewBase.resetCatPSCodeListName();
                return true;
            }
            case 4: {
                pSDETreeViewBase.resetCodeName();
                return true;
            }
            case 5: {
                pSDETreeViewBase.resetColEnableFilter();
                return true;
            }
            case 6: {
                pSDETreeViewBase.resetColEnableLink();
                return true;
            }
            case 7: {
                pSDETreeViewBase.resetCreateDate();
                return true;
            }
            case 8: {
                pSDETreeViewBase.resetCreateMan();
                return true;
            }
            case 9: {
                pSDETreeViewBase.resetEmptyText();
                return true;
            }
            case 10: {
                pSDETreeViewBase.resetEmptyTextPSLanResId();
                return true;
            }
            case 11: {
                pSDETreeViewBase.resetEmptyTextPSLanResName();
                return true;
            }
            case 12: {
                pSDETreeViewBase.resetEnableEdit();
                return true;
            }
            case 13: {
                pSDETreeViewBase.resetEnableItemPriv();
                return true;
            }
            case 14: {
                pSDETreeViewBase.resetEnableSearch();
                return true;
            }
            case 15: {
                pSDETreeViewBase.resetFrozenCol();
                return true;
            }
            case 16: {
                pSDETreeViewBase.resetFrozenLastCol();
                return true;
            }
            case 17: {
                pSDETreeViewBase.resetLockFlag();
                return true;
            }
            case 18: {
                pSDETreeViewBase.resetMemo();
                return true;
            }
            case 19: {
                pSDETreeViewBase.resetNavViewHeight();
                return true;
            }
            case 20: {
                pSDETreeViewBase.resetNavViewMaxHeight();
                return true;
            }
            case 21: {
                pSDETreeViewBase.resetNavViewMaxWidth();
                return true;
            }
            case 22: {
                pSDETreeViewBase.resetNavViewMinHeight();
                return true;
            }
            case 23: {
                pSDETreeViewBase.resetNavViewMinWidth();
                return true;
            }
            case 24: {
                pSDETreeViewBase.resetNavViewPos();
                return true;
            }
            case 25: {
                pSDETreeViewBase.resetNavViewShowMode();
                return true;
            }
            case 26: {
                pSDETreeViewBase.resetNavViewWidth();
                return true;
            }
            case 27: {
                pSDETreeViewBase.resetNoIconDefault();
                return true;
            }
            case 28: {
                pSDETreeViewBase.resetPSACHandlerId();
                return true;
            }
            case 29: {
                pSDETreeViewBase.resetPSACHandlerName();
                return true;
            }
            case 30: {
                pSDETreeViewBase.resetPSCtrlLogicGroupId();
                return true;
            }
            case 31: {
                pSDETreeViewBase.resetPSCtrlLogicGroupName();
                return true;
            }
            case 32: {
                pSDETreeViewBase.resetPSCtrlMsgId();
                return true;
            }
            case 33: {
                pSDETreeViewBase.resetPSCtrlMsgName();
                return true;
            }
            case 34: {
                pSDETreeViewBase.resetPSDEGridId();
                return true;
            }
            case 35: {
                pSDETreeViewBase.resetPSDEGridName();
                return true;
            }
            case 36: {
                pSDETreeViewBase.resetPSDEId();
                return true;
            }
            case 37: {
                pSDETreeViewBase.resetPSDEName();
                return true;
            }
            case 38: {
                pSDETreeViewBase.resetPSDETreeViewId();
                return true;
            }
            case 39: {
                pSDETreeViewBase.resetPSDETreeViewName();
                return true;
            }
            case 40: {
                pSDETreeViewBase.resetPSSysCounterId();
                return true;
            }
            case 41: {
                pSDETreeViewBase.resetPSSysCounterName();
                return true;
            }
            case 42: {
                pSDETreeViewBase.resetPSSysCssId();
                return true;
            }
            case 43: {
                pSDETreeViewBase.resetPSSysCssName();
                return true;
            }
            case 44: {
                pSDETreeViewBase.resetPSSysPFPluginId();
                return true;
            }
            case 45: {
                pSDETreeViewBase.resetPSSysPFPluginName();
                return true;
            }
            case 46: {
                pSDETreeViewBase.resetPSSystemId();
                return true;
            }
            case 47: {
                pSDETreeViewBase.resetPSSystemName();
                return true;
            }
            case 48: {
                pSDETreeViewBase.resetPSViewMsgGroupId();
                return true;
            }
            case 49: {
                pSDETreeViewBase.resetPSViewMsgGroupName();
                return true;
            }
            case 50: {
                pSDETreeViewBase.resetRootSelect();
                return true;
            }
            case 51: {
                pSDETreeViewBase.resetShowRoot();
                return true;
            }
            case 52: {
                pSDETreeViewBase.resetSRFSysPub();
                return true;
            }
            case 53: {
                pSDETreeViewBase.resetToDoTask();
                return true;
            }
            case 54: {
                pSDETreeViewBase.resetTreeGridFlag();
                return true;
            }
            case 55: {
                pSDETreeViewBase.resetTreeModel();
                return true;
            }
            case 56: {
                pSDETreeViewBase.resetTreeStyle();
                return true;
            }
            case 57: {
                pSDETreeViewBase.resetUpdateDate();
                return true;
            }
            case 58: {
                pSDETreeViewBase.resetUpdateMan();
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
    public PSCodeList getCatPSCodeList() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCatPSCodeList();
        }
        if (this.getCatPSCodeListId() == null) {
            return null;
        }
        Integer n = this.objCatPSCodeListLock;
        synchronized (n) {
            if (this.catpscodelist != null && DataTypeHelper.compare((int)25, (Object)this.getCatPSCodeListId(), (Object)this.catpscodelist.getPSCodeListId()) != 0L) {
                this.catpscodelist = null;
            }
            if (this.catpscodelist == null) {
                PSCodeList pSCodeList = new PSCodeList();
                pSCodeList.setPSCodeListId(this.getCatPSCodeListId());
                PSCodeListService pSCodeListService = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.getSessionFactory());
                pSCodeListService.autoGet(pSCodeList);
                this.catpscodelist = pSCodeList;
            }
            return this.catpscodelist;
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
                pSLanguageResService.autoGet(pSLanguageRes);
                this.emptytextpslanres = pSLanguageRes;
            }
            return this.emptytextpslanres;
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
    public ArrayList<PSDETreeCol> getPSDETreeCols() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETreeCols();
        }
        if (this.getPSDETreeViewId() == null) {
            return null;
        }
        PSDETreeViewService pSDETreeViewService = (PSDETreeViewService)ServiceGlobal.getService(PSDETreeViewService.class, (SessionFactory)this.getSessionFactory());
        PSDETreeColService pSDETreeColService = (PSDETreeColService)ServiceGlobal.getService(PSDETreeColService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDETreeColsLock;
        synchronized (n) {
            if (this.psdetreecols == null) {
                this.psdetreecols = pSDETreeViewService.isTempData(this) ? pSDETreeColService.selectTempByPSDETreeView(this) : pSDETreeColService.selectByPSDETreeView(this);
            }
            return this.psdetreecols;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDETreeLogic> getPSDETreeLogics() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETreeLogics();
        }
        if (this.getPSDETreeViewId() == null) {
            return null;
        }
        PSDETreeViewService pSDETreeViewService = (PSDETreeViewService)ServiceGlobal.getService(PSDETreeViewService.class, (SessionFactory)this.getSessionFactory());
        PSDETreeLogicService pSDETreeLogicService = (PSDETreeLogicService)ServiceGlobal.getService(PSDETreeLogicService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDETreeLogicsLock;
        synchronized (n) {
            if (this.psdetreelogics == null) {
                this.psdetreelogics = pSDETreeViewService.isTempData(this) ? pSDETreeLogicService.selectTempByPSDETreeView(this) : pSDETreeLogicService.selectByPSDETreeView(this);
            }
            return this.psdetreelogics;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDETreeNode> getPSDETreeNodes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETreeNodes();
        }
        if (this.getPSDETreeViewId() == null) {
            return null;
        }
        PSDETreeViewService pSDETreeViewService = (PSDETreeViewService)ServiceGlobal.getService(PSDETreeViewService.class, (SessionFactory)this.getSessionFactory());
        PSDETreeNodeService pSDETreeNodeService = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDETreeNodesLock;
        synchronized (n) {
            if (this.psdetreenodes == null) {
                this.psdetreenodes = pSDETreeViewService.isTempData(this) ? pSDETreeNodeService.selectTempByPSDETreeView(this) : pSDETreeNodeService.selectByPSDETreeView(this);
            }
            return this.psdetreenodes;
        }
    }

    private PSDETreeViewBase getProxyEntity() {
        return this.proxyPSDETreeViewBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDETreeViewBase = null;
        if (iDataObject != null && iDataObject instanceof PSDETreeViewBase) {
            this.proxyPSDETreeViewBase = (PSDETreeViewBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDETreeViewService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BUFFERRENDERERMODE, 0);
        fieldIndexMap.put(FIELD_BUSYINDICATOR, 1);
        fieldIndexMap.put(FIELD_CATPSCODELISTID, 2);
        fieldIndexMap.put(FIELD_CATPSCODELISTNAME, 3);
        fieldIndexMap.put(FIELD_CODENAME, 4);
        fieldIndexMap.put(FIELD_COLENABLEFILTER, 5);
        fieldIndexMap.put(FIELD_COLENABLELINK, 6);
        fieldIndexMap.put(FIELD_CREATEDATE, 7);
        fieldIndexMap.put(FIELD_CREATEMAN, 8);
        fieldIndexMap.put(FIELD_EMPTYTEXT, 9);
        fieldIndexMap.put(FIELD_EMPTYTEXTPSLANRESID, 10);
        fieldIndexMap.put(FIELD_EMPTYTEXTPSLANRESNAME, 11);
        fieldIndexMap.put(FIELD_ENABLEEDIT, 12);
        fieldIndexMap.put(FIELD_ENABLEITEMPRIV, 13);
        fieldIndexMap.put(FIELD_ENABLESEARCH, 14);
        fieldIndexMap.put(FIELD_FROZENCOL, 15);
        fieldIndexMap.put(FIELD_FROZENLASTCOL, 16);
        fieldIndexMap.put(FIELD_LOCKFLAG, 17);
        fieldIndexMap.put(FIELD_MEMO, 18);
        fieldIndexMap.put(FIELD_NAVVIEWHEIGHT, 19);
        fieldIndexMap.put(FIELD_NAVVIEWMAXHEIGHT, 20);
        fieldIndexMap.put(FIELD_NAVVIEWMAXWIDTH, 21);
        fieldIndexMap.put(FIELD_NAVVIEWMINHEIGHT, 22);
        fieldIndexMap.put(FIELD_NAVVIEWMINWIDTH, 23);
        fieldIndexMap.put(FIELD_NAVVIEWPOS, 24);
        fieldIndexMap.put(FIELD_NAVVIEWSHOWMODE, 25);
        fieldIndexMap.put(FIELD_NAVVIEWWIDTH, 26);
        fieldIndexMap.put(FIELD_NOICONDEFAULT, 27);
        fieldIndexMap.put(FIELD_PSACHANDLERID, 28);
        fieldIndexMap.put(FIELD_PSACHANDLERNAME, 29);
        fieldIndexMap.put(FIELD_PSCTRLLOGICGROUPID, 30);
        fieldIndexMap.put(FIELD_PSCTRLLOGICGROUPNAME, 31);
        fieldIndexMap.put(FIELD_PSCTRLMSGID, 32);
        fieldIndexMap.put(FIELD_PSCTRLMSGNAME, 33);
        fieldIndexMap.put(FIELD_PSDEGRIDID, 34);
        fieldIndexMap.put(FIELD_PSDEGRIDNAME, 35);
        fieldIndexMap.put(FIELD_PSDEID, 36);
        fieldIndexMap.put(FIELD_PSDENAME, 37);
        fieldIndexMap.put(FIELD_PSDETREEVIEWID, 38);
        fieldIndexMap.put(FIELD_PSDETREEVIEWNAME, 39);
        fieldIndexMap.put(FIELD_PSSYSCOUNTERID, 40);
        fieldIndexMap.put(FIELD_PSSYSCOUNTERNAME, 41);
        fieldIndexMap.put(FIELD_PSSYSCSSID, 42);
        fieldIndexMap.put(FIELD_PSSYSCSSNAME, 43);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 44);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 45);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 46);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 47);
        fieldIndexMap.put(FIELD_PSVIEWMSGGROUPID, 48);
        fieldIndexMap.put(FIELD_PSVIEWMSGGROUPNAME, 49);
        fieldIndexMap.put(FIELD_ROOTSELECT, 50);
        fieldIndexMap.put(FIELD_SHOWROOT, 51);
        fieldIndexMap.put(FIELD_SRFSYSPUB, 52);
        fieldIndexMap.put(FIELD_TODOTASK, 53);
        fieldIndexMap.put(FIELD_TREEGRIDFLAG, 54);
        fieldIndexMap.put(FIELD_TREEMODEL, 55);
        fieldIndexMap.put(FIELD_TREESTYLE, 56);
        fieldIndexMap.put(FIELD_UPDATEDATE, 57);
        fieldIndexMap.put(FIELD_UPDATEMAN, 58);
    }
}

