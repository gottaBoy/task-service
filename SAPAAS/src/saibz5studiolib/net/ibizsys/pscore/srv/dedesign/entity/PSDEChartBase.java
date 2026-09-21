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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEChartAxes;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEChartLogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEChartParam;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartAxesService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartParamService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSACHandler;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlLogicGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlMsg;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysChartTheme;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgGroup;
import net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCtrlLogicGroupService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCtrlMsgService;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysChartThemeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGroupService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEChartBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEChartBase.class);
    public static final String FIELD_ADPSDELOGICID = "ADPSDELOGICID";
    public static final String FIELD_ADPSDELOGICNAME = "ADPSDELOGICNAME";
    public static final String FIELD_BUSYINDICATOR = "BUSYINDICATOR";
    public static final String FIELD_CHARTMODEL = "CHARTMODEL";
    public static final String FIELD_CHARTTHEME = "CHARTTHEME";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_COORDINATESYSTEM = "COORDINATESYSTEM";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCOND = "CUSTOMCOND";
    public static final String FIELD_CUSTOMTYPE = "CUSTOMTYPE";
    public static final String FIELD_DATAGRIDPOS = "DATAGRIDPOS";
    public static final String FIELD_EMPTYTEXT = "EMPTYTEXT";
    public static final String FIELD_EMPTYTEXTPSLANRESID = "EMPTYTEXTPSLANRESID";
    public static final String FIELD_EMPTYTEXTPSLANRESNAME = "EMPTYTEXTPSLANRESNAME";
    public static final String FIELD_LEGENDPOS = "LEGENDPOS";
    public static final String FIELD_LNPSLANRESID = "LNPSLANRESID";
    public static final String FIELD_LNPSLANRESNAME = "LNPSLANRESNAME";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MINORSORTDIR = "MINORSORTDIR";
    public static final String FIELD_MINORSORTPSDEFID = "MINORSORTPSDEFID";
    public static final String FIELD_MINORSORTPSDEFNAME = "MINORSORTPSDEFNAME";
    public static final String FIELD_NAVVIEWHEIGHT = "NAVVIEWHEIGHT";
    public static final String FIELD_NAVVIEWMAXHEIGHT = "NAVVIEWMAXHEIGHT";
    public static final String FIELD_NAVVIEWMAXWIDTH = "NAVVIEWMAXWIDTH";
    public static final String FIELD_NAVVIEWMINHEIGHT = "NAVVIEWMINHEIGHT";
    public static final String FIELD_NAVVIEWMINWIDTH = "NAVVIEWMINWIDTH";
    public static final String FIELD_NAVVIEWPOS = "NAVVIEWPOS";
    public static final String FIELD_NAVVIEWSHOWMODE = "NAVVIEWSHOWMODE";
    public static final String FIELD_NAVVIEWWIDTH = "NAVVIEWWIDTH";
    public static final String FIELD_PSACHANDLERID = "PSACHANDLERID";
    public static final String FIELD_PSACHANDLERNAME = "PSACHANDLERNAME";
    public static final String FIELD_PSCTRLLOGICGROUPID = "PSCTRLLOGICGROUPID";
    public static final String FIELD_PSCTRLLOGICGROUPNAME = "PSCTRLLOGICGROUPNAME";
    public static final String FIELD_PSCTRLMSGID = "PSCTRLMSGID";
    public static final String FIELD_PSCTRLMSGNAME = "PSCTRLMSGNAME";
    public static final String FIELD_PSDECHARTID = "PSDECHARTID";
    public static final String FIELD_PSDECHARTNAME = "PSDECHARTNAME";
    public static final String FIELD_PSDEDSID = "PSDEDSID";
    public static final String FIELD_PSDEDSNAME = "PSDEDSNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSSYSCHARTTHEMEID = "PSSYSCHARTTHEMEID";
    public static final String FIELD_PSSYSCHARTTHEMENAME = "PSSYSCHARTTHEMENAME";
    public static final String FIELD_PSSYSCSSID = "PSSYSCSSID";
    public static final String FIELD_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_PSSYSREQITEMID = "PSSYSREQITEMID";
    public static final String FIELD_PSSYSREQITEMNAME = "PSSYSREQITEMNAME";
    public static final String FIELD_PSVIEWMSGGROUPID = "PSVIEWMSGGROUPID";
    public static final String FIELD_PSVIEWMSGGROUPNAME = "PSVIEWMSGGROUPNAME";
    public static final String FIELD_SHOWDATAGRID = "SHOWDATAGRID";
    public static final String FIELD_SHOWLEGEND = "SHOWLEGEND";
    public static final String FIELD_SHOWTITLE = "SHOWTITLE";
    public static final String FIELD_SRFSYSPUB = "SRFSYSPUB";
    public static final String FIELD_SUBTITLE = "SUBTITLE";
    public static final String FIELD_SUBTITLEPSLANRESID = "SUBTITLEPSLANRESID";
    public static final String FIELD_SUBTITLEPSLANRESNAME = "SUBTITLEPSLANRESNAME";
    public static final String FIELD_TITLEPOS = "TITLEPOS";
    public static final String FIELD_TODOTASK = "TODOTASK";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    private static final int INDEX_ADPSDELOGICID = 0;
    private static final int INDEX_ADPSDELOGICNAME = 1;
    private static final int INDEX_BUSYINDICATOR = 2;
    private static final int INDEX_CHARTMODEL = 3;
    private static final int INDEX_CHARTTHEME = 4;
    private static final int INDEX_CODENAME = 5;
    private static final int INDEX_COORDINATESYSTEM = 6;
    private static final int INDEX_CREATEDATE = 7;
    private static final int INDEX_CREATEMAN = 8;
    private static final int INDEX_CUSTOMCOND = 9;
    private static final int INDEX_CUSTOMTYPE = 10;
    private static final int INDEX_DATAGRIDPOS = 11;
    private static final int INDEX_EMPTYTEXT = 12;
    private static final int INDEX_EMPTYTEXTPSLANRESID = 13;
    private static final int INDEX_EMPTYTEXTPSLANRESNAME = 14;
    private static final int INDEX_LEGENDPOS = 15;
    private static final int INDEX_LNPSLANRESID = 16;
    private static final int INDEX_LNPSLANRESNAME = 17;
    private static final int INDEX_LOCKFLAG = 18;
    private static final int INDEX_LOGICNAME = 19;
    private static final int INDEX_MEMO = 20;
    private static final int INDEX_MINORSORTDIR = 21;
    private static final int INDEX_MINORSORTPSDEFID = 22;
    private static final int INDEX_MINORSORTPSDEFNAME = 23;
    private static final int INDEX_NAVVIEWHEIGHT = 24;
    private static final int INDEX_NAVVIEWMAXHEIGHT = 25;
    private static final int INDEX_NAVVIEWMAXWIDTH = 26;
    private static final int INDEX_NAVVIEWMINHEIGHT = 27;
    private static final int INDEX_NAVVIEWMINWIDTH = 28;
    private static final int INDEX_NAVVIEWPOS = 29;
    private static final int INDEX_NAVVIEWSHOWMODE = 30;
    private static final int INDEX_NAVVIEWWIDTH = 31;
    private static final int INDEX_PSACHANDLERID = 32;
    private static final int INDEX_PSACHANDLERNAME = 33;
    private static final int INDEX_PSCTRLLOGICGROUPID = 34;
    private static final int INDEX_PSCTRLLOGICGROUPNAME = 35;
    private static final int INDEX_PSCTRLMSGID = 36;
    private static final int INDEX_PSCTRLMSGNAME = 37;
    private static final int INDEX_PSDECHARTID = 38;
    private static final int INDEX_PSDECHARTNAME = 39;
    private static final int INDEX_PSDEDSID = 40;
    private static final int INDEX_PSDEDSNAME = 41;
    private static final int INDEX_PSDEID = 42;
    private static final int INDEX_PSDENAME = 43;
    private static final int INDEX_PSSYSCHARTTHEMEID = 44;
    private static final int INDEX_PSSYSCHARTTHEMENAME = 45;
    private static final int INDEX_PSSYSCSSID = 46;
    private static final int INDEX_PSSYSCSSNAME = 47;
    private static final int INDEX_PSSYSDYNAMODELID = 48;
    private static final int INDEX_PSSYSDYNAMODELNAME = 49;
    private static final int INDEX_PSSYSPFPLUGINID = 50;
    private static final int INDEX_PSSYSPFPLUGINNAME = 51;
    private static final int INDEX_PSSYSREQITEMID = 52;
    private static final int INDEX_PSSYSREQITEMNAME = 53;
    private static final int INDEX_PSVIEWMSGGROUPID = 54;
    private static final int INDEX_PSVIEWMSGGROUPNAME = 55;
    private static final int INDEX_SHOWDATAGRID = 56;
    private static final int INDEX_SHOWLEGEND = 57;
    private static final int INDEX_SHOWTITLE = 58;
    private static final int INDEX_SRFSYSPUB = 59;
    private static final int INDEX_SUBTITLE = 60;
    private static final int INDEX_SUBTITLEPSLANRESID = 61;
    private static final int INDEX_SUBTITLEPSLANRESNAME = 62;
    private static final int INDEX_TITLEPOS = 63;
    private static final int INDEX_TODOTASK = 64;
    private static final int INDEX_UPDATEDATE = 65;
    private static final int INDEX_UPDATEMAN = 66;
    private static final int INDEX_USERPARAMS = 67;
    private static final int INDEX_USERTAG = 68;
    private static final int INDEX_USERTAG2 = 69;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEChartBase proxyPSDEChartBase = null;
    private boolean adpsdelogicidDirtyFlag = false;
    private boolean adpsdelogicnameDirtyFlag = false;
    private boolean busyindicatorDirtyFlag = false;
    private boolean chartmodelDirtyFlag = false;
    private boolean chartthemeDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean coordinatesystemDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcondDirtyFlag = false;
    private boolean customtypeDirtyFlag = false;
    private boolean datagridposDirtyFlag = false;
    private boolean emptytextDirtyFlag = false;
    private boolean emptytextpslanresidDirtyFlag = false;
    private boolean emptytextpslanresnameDirtyFlag = false;
    private boolean legendposDirtyFlag = false;
    private boolean lnpslanresidDirtyFlag = false;
    private boolean lnpslanresnameDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean minorsortdirDirtyFlag = false;
    private boolean minorsortpsdefidDirtyFlag = false;
    private boolean minorsortpsdefnameDirtyFlag = false;
    private boolean navviewheightDirtyFlag = false;
    private boolean navviewmaxheightDirtyFlag = false;
    private boolean navviewmaxwidthDirtyFlag = false;
    private boolean navviewminheightDirtyFlag = false;
    private boolean navviewminwidthDirtyFlag = false;
    private boolean navviewposDirtyFlag = false;
    private boolean navviewshowmodeDirtyFlag = false;
    private boolean navviewwidthDirtyFlag = false;
    private boolean psachandleridDirtyFlag = false;
    private boolean psachandlernameDirtyFlag = false;
    private boolean psctrllogicgroupidDirtyFlag = false;
    private boolean psctrllogicgroupnameDirtyFlag = false;
    private boolean psctrlmsgidDirtyFlag = false;
    private boolean psctrlmsgnameDirtyFlag = false;
    private boolean psdechartidDirtyFlag = false;
    private boolean psdechartnameDirtyFlag = false;
    private boolean psdedsidDirtyFlag = false;
    private boolean psdedsnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean pssyschartthemeidDirtyFlag = false;
    private boolean pssyschartthemenameDirtyFlag = false;
    private boolean pssyscssidDirtyFlag = false;
    private boolean pssyscssnameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean pssysreqitemidDirtyFlag = false;
    private boolean pssysreqitemnameDirtyFlag = false;
    private boolean psviewmsggroupidDirtyFlag = false;
    private boolean psviewmsggroupnameDirtyFlag = false;
    private boolean showdatagridDirtyFlag = false;
    private boolean showlegendDirtyFlag = false;
    private boolean showtitleDirtyFlag = false;
    private boolean srfsyspubDirtyFlag = false;
    private boolean subtitleDirtyFlag = false;
    private boolean subtitlepslanresidDirtyFlag = false;
    private boolean subtitlepslanresnameDirtyFlag = false;
    private boolean titleposDirtyFlag = false;
    private boolean todotaskDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    @Column(name="adpsdelogicid")
    private String adpsdelogicid;
    @Column(name="adpsdelogicname")
    private String adpsdelogicname;
    @Column(name="busyindicator")
    private Integer busyindicator;
    @Column(name="chartmodel")
    private String chartmodel;
    @Column(name="charttheme")
    private String charttheme;
    @Column(name="codename")
    private String codename;
    @Column(name="coordinatesystem")
    private String coordinatesystem;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customcond")
    private String customcond;
    @Column(name="customtype")
    private String customtype;
    @Column(name="datagridpos")
    private String datagridpos;
    @Column(name="emptytext")
    private String emptytext;
    @Column(name="emptytextpslanresid")
    private String emptytextpslanresid;
    @Column(name="emptytextpslanresname")
    private String emptytextpslanresname;
    @Column(name="legendpos")
    private String legendpos;
    @Column(name="lnpslanresid")
    private String lnpslanresid;
    @Column(name="lnpslanresname")
    private String lnpslanresname;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="minorsortdir")
    private String minorsortdir;
    @Column(name="minorsortpsdefid")
    private String minorsortpsdefid;
    @Column(name="minorsortpsdefname")
    private String minorsortpsdefname;
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
    @Column(name="psdechartid")
    private String psdechartid;
    @Column(name="psdechartname")
    private String psdechartname;
    @Column(name="psdedsid")
    private String psdedsid;
    @Column(name="psdedsname")
    private String psdedsname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="pssyschartthemeid")
    private String pssyschartthemeid;
    @Column(name="pssyschartthemename")
    private String pssyschartthemename;
    @Column(name="pssyscssid")
    private String pssyscssid;
    @Column(name="pssyscssname")
    private String pssyscssname;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssyspfpluginid")
    private String pssyspfpluginid;
    @Column(name="pssyspfpluginname")
    private String pssyspfpluginname;
    @Column(name="pssysreqitemid")
    private String pssysreqitemid;
    @Column(name="pssysreqitemname")
    private String pssysreqitemname;
    @Column(name="psviewmsggroupid")
    private String psviewmsggroupid;
    @Column(name="psviewmsggroupname")
    private String psviewmsggroupname;
    @Column(name="showdatagrid")
    private Integer showdatagrid;
    @Column(name="showlegend")
    private Integer showlegend;
    @Column(name="showtitle")
    private Integer showtitle;
    @Column(name="srfsyspub")
    private Integer srfsyspub;
    @Column(name="subtitle")
    private String subtitle;
    @Column(name="subtitlepslanresid")
    private String subtitlepslanresid;
    @Column(name="subtitlepslanresname")
    private String subtitlepslanresname;
    @Column(name="titlepos")
    private String titlepos;
    @Column(name="todotask")
    private String todotask;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userparams")
    private String userparams;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    private Integer objPSACHandlerLock = new Integer(1);
    private PSACHandler psachandler = null;
    private Integer objPSCtrlLogicGroupLock = new Integer(1);
    private PSCtrlLogicGroup psctrllogicgroup = null;
    private Integer objPSCtrlMsgLock = new Integer(1);
    private PSCtrlMsg psctrlmsg = null;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSDEDSLock = new Integer(1);
    private PSDEDataSet psdeds = null;
    private Integer objMinorSortPSDEFLock = new Integer(1);
    private PSDEField minorsortpsdef = null;
    private Integer objADPSDELogicLock = new Integer(1);
    private PSDELogic adpsdelogic = null;
    private Integer objEmptyTextPSLanResLock = new Integer(1);
    private PSLanguageRes emptytextpslanres = null;
    private Integer objLNPSLanResLock = new Integer(1);
    private PSLanguageRes lnpslanres = null;
    private Integer objSubTitlePSLanResLock = new Integer(1);
    private PSLanguageRes subtitlepslanres = null;
    private Integer objPSSysChartThemeLock = new Integer(1);
    private PSSysChartTheme pssyscharttheme = null;
    private Integer objPSSysCssLock = new Integer(1);
    private PSSysCss pssyscss = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin pssyspfplugin = null;
    private Integer objPSSysReqItemLock = new Integer(1);
    private PSSysReqItem pssysreqitem = null;
    private Integer objPSViewMsgGroupLock = new Integer(1);
    private PSViewMsgGroup psviewmsggroup = null;
    private Integer objPSDEChartAxesesLock = new Integer(1);
    private ArrayList<PSDEChartAxes> psdechartaxeses = null;
    private Integer objPSDEChartLogicsLock = new Integer(1);
    private ArrayList<PSDEChartLogic> psdechartlogics = null;
    private Integer objPSDEChartParamsLock = new Integer(1);
    private ArrayList<PSDEChartParam> psdechartparams = null;

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

    public void setChartModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setChartModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.chartmodel = string;
        this.chartmodelDirtyFlag = true;
    }

    public String getChartModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getChartModel();
        }
        return this.chartmodel;
    }

    public boolean isChartModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isChartModelDirty();
        }
        return this.chartmodelDirtyFlag;
    }

    public void resetChartModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetChartModel();
            return;
        }
        this.chartmodelDirtyFlag = false;
        this.chartmodel = null;
    }

    public void setChartTheme(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setChartTheme(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.charttheme = string;
        this.chartthemeDirtyFlag = true;
    }

    public String getChartTheme() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getChartTheme();
        }
        return this.charttheme;
    }

    public boolean isChartThemeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isChartThemeDirty();
        }
        return this.chartthemeDirtyFlag;
    }

    public void resetChartTheme() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetChartTheme();
            return;
        }
        this.chartthemeDirtyFlag = false;
        this.charttheme = null;
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

    public void setCoordinateSystem(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCoordinateSystem(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.coordinatesystem = string;
        this.coordinatesystemDirtyFlag = true;
    }

    public String getCoordinateSystem() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCoordinateSystem();
        }
        return this.coordinatesystem;
    }

    public boolean isCoordinateSystemDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCoordinateSystemDirty();
        }
        return this.coordinatesystemDirtyFlag;
    }

    public void resetCoordinateSystem() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCoordinateSystem();
            return;
        }
        this.coordinatesystemDirtyFlag = false;
        this.coordinatesystem = null;
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

    public void setDataGridPos(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataGridPos(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.datagridpos = string;
        this.datagridposDirtyFlag = true;
    }

    public String getDataGridPos() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataGridPos();
        }
        return this.datagridpos;
    }

    public boolean isDataGridPosDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataGridPosDirty();
        }
        return this.datagridposDirtyFlag;
    }

    public void resetDataGridPos() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataGridPos();
            return;
        }
        this.datagridposDirtyFlag = false;
        this.datagridpos = null;
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

    public void setLegendPos(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLegendPos(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.legendpos = string;
        this.legendposDirtyFlag = true;
    }

    public String getLegendPos() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLegendPos();
        }
        return this.legendpos;
    }

    public boolean isLegendPosDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLegendPosDirty();
        }
        return this.legendposDirtyFlag;
    }

    public void resetLegendPos() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLegendPos();
            return;
        }
        this.legendposDirtyFlag = false;
        this.legendpos = null;
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

    public void setMinorSortDir(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinorSortDir(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.minorsortdir = string;
        this.minorsortdirDirtyFlag = true;
    }

    public String getMinorSortDir() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorSortDir();
        }
        return this.minorsortdir;
    }

    public boolean isMinorSortDirDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinorSortDirDirty();
        }
        return this.minorsortdirDirtyFlag;
    }

    public void resetMinorSortDir() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinorSortDir();
            return;
        }
        this.minorsortdirDirtyFlag = false;
        this.minorsortdir = null;
    }

    public void setMinorSortPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinorSortPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.minorsortpsdefid = string;
        this.minorsortpsdefidDirtyFlag = true;
    }

    public String getMinorSortPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorSortPSDEFId();
        }
        return this.minorsortpsdefid;
    }

    public boolean isMinorSortPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinorSortPSDEFIdDirty();
        }
        return this.minorsortpsdefidDirtyFlag;
    }

    public void resetMinorSortPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinorSortPSDEFId();
            return;
        }
        this.minorsortpsdefidDirtyFlag = false;
        this.minorsortpsdefid = null;
    }

    public void setMinorSortPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinorSortPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.minorsortpsdefname = string;
        this.minorsortpsdefnameDirtyFlag = true;
    }

    public String getMinorSortPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorSortPSDEFName();
        }
        return this.minorsortpsdefname;
    }

    public boolean isMinorSortPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinorSortPSDEFNameDirty();
        }
        return this.minorsortpsdefnameDirtyFlag;
    }

    public void resetMinorSortPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinorSortPSDEFName();
            return;
        }
        this.minorsortpsdefnameDirtyFlag = false;
        this.minorsortpsdefname = null;
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

    public void setPSSysChartThemeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysChartThemeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyschartthemeid = string;
        this.pssyschartthemeidDirtyFlag = true;
    }

    public String getPSSysChartThemeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysChartThemeId();
        }
        return this.pssyschartthemeid;
    }

    public boolean isPSSysChartThemeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysChartThemeIdDirty();
        }
        return this.pssyschartthemeidDirtyFlag;
    }

    public void resetPSSysChartThemeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysChartThemeId();
            return;
        }
        this.pssyschartthemeidDirtyFlag = false;
        this.pssyschartthemeid = null;
    }

    public void setPSSysChartThemeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysChartThemeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyschartthemename = string;
        this.pssyschartthemenameDirtyFlag = true;
    }

    public String getPSSysChartThemeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysChartThemeName();
        }
        return this.pssyschartthemename;
    }

    public boolean isPSSysChartThemeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysChartThemeNameDirty();
        }
        return this.pssyschartthemenameDirtyFlag;
    }

    public void resetPSSysChartThemeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysChartThemeName();
            return;
        }
        this.pssyschartthemenameDirtyFlag = false;
        this.pssyschartthemename = null;
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

    public void setShowDataGrid(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setShowDataGrid(n);
            return;
        }
        this.showdatagrid = n;
        this.showdatagridDirtyFlag = true;
    }

    public Integer getShowDataGrid() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getShowDataGrid();
        }
        return this.showdatagrid;
    }

    public boolean isShowDataGridDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isShowDataGridDirty();
        }
        return this.showdatagridDirtyFlag;
    }

    public void resetShowDataGrid() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetShowDataGrid();
            return;
        }
        this.showdatagridDirtyFlag = false;
        this.showdatagrid = null;
    }

    public void setShowLegend(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setShowLegend(n);
            return;
        }
        this.showlegend = n;
        this.showlegendDirtyFlag = true;
    }

    public Integer getShowLegend() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getShowLegend();
        }
        return this.showlegend;
    }

    public boolean isShowLegendDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isShowLegendDirty();
        }
        return this.showlegendDirtyFlag;
    }

    public void resetShowLegend() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetShowLegend();
            return;
        }
        this.showlegendDirtyFlag = false;
        this.showlegend = null;
    }

    public void setShowTitle(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setShowTitle(n);
            return;
        }
        this.showtitle = n;
        this.showtitleDirtyFlag = true;
    }

    public Integer getShowTitle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getShowTitle();
        }
        return this.showtitle;
    }

    public boolean isShowTitleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isShowTitleDirty();
        }
        return this.showtitleDirtyFlag;
    }

    public void resetShowTitle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetShowTitle();
            return;
        }
        this.showtitleDirtyFlag = false;
        this.showtitle = null;
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

    public void setSubTitle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSubTitle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.subtitle = string;
        this.subtitleDirtyFlag = true;
    }

    public String getSubTitle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSubTitle();
        }
        return this.subtitle;
    }

    public boolean isSubTitleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSubTitleDirty();
        }
        return this.subtitleDirtyFlag;
    }

    public void resetSubTitle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSubTitle();
            return;
        }
        this.subtitleDirtyFlag = false;
        this.subtitle = null;
    }

    public void setSubTitlePSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSubTitlePSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.subtitlepslanresid = string;
        this.subtitlepslanresidDirtyFlag = true;
    }

    public String getSubTitlePSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSubTitlePSLanResId();
        }
        return this.subtitlepslanresid;
    }

    public boolean isSubTitlePSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSubTitlePSLanResIdDirty();
        }
        return this.subtitlepslanresidDirtyFlag;
    }

    public void resetSubTitlePSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSubTitlePSLanResId();
            return;
        }
        this.subtitlepslanresidDirtyFlag = false;
        this.subtitlepslanresid = null;
    }

    public void setSubTitlePSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSubTitlePSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.subtitlepslanresname = string;
        this.subtitlepslanresnameDirtyFlag = true;
    }

    public String getSubTitlePSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSubTitlePSLanResName();
        }
        return this.subtitlepslanresname;
    }

    public boolean isSubTitlePSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSubTitlePSLanResNameDirty();
        }
        return this.subtitlepslanresnameDirtyFlag;
    }

    public void resetSubTitlePSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSubTitlePSLanResName();
            return;
        }
        this.subtitlepslanresnameDirtyFlag = false;
        this.subtitlepslanresname = null;
    }

    public void setTitlePos(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTitlePos(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.titlepos = string;
        this.titleposDirtyFlag = true;
    }

    public String getTitlePos() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTitlePos();
        }
        return this.titlepos;
    }

    public boolean isTitlePosDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTitlePosDirty();
        }
        return this.titleposDirtyFlag;
    }

    public void resetTitlePos() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTitlePos();
            return;
        }
        this.titleposDirtyFlag = false;
        this.titlepos = null;
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

    protected void onReset() {
        PSDEChartBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEChartBase pSDEChartBase) {
        pSDEChartBase.resetADPSDELogicId();
        pSDEChartBase.resetADPSDELogicName();
        pSDEChartBase.resetBusyIndicator();
        pSDEChartBase.resetChartModel();
        pSDEChartBase.resetChartTheme();
        pSDEChartBase.resetCodeName();
        pSDEChartBase.resetCoordinateSystem();
        pSDEChartBase.resetCreateDate();
        pSDEChartBase.resetCreateMan();
        pSDEChartBase.resetCustomCond();
        pSDEChartBase.resetCustomType();
        pSDEChartBase.resetDataGridPos();
        pSDEChartBase.resetEmptyText();
        pSDEChartBase.resetEmptyTextPSLanResId();
        pSDEChartBase.resetEmptyTextPSLanResName();
        pSDEChartBase.resetLegendPos();
        pSDEChartBase.resetLNPSLanResId();
        pSDEChartBase.resetLNPSLanResName();
        pSDEChartBase.resetLockFlag();
        pSDEChartBase.resetLogicName();
        pSDEChartBase.resetMemo();
        pSDEChartBase.resetMinorSortDir();
        pSDEChartBase.resetMinorSortPSDEFId();
        pSDEChartBase.resetMinorSortPSDEFName();
        pSDEChartBase.resetNavViewHeight();
        pSDEChartBase.resetNavViewMaxHeight();
        pSDEChartBase.resetNavViewMaxWidth();
        pSDEChartBase.resetNavViewMinHeight();
        pSDEChartBase.resetNavViewMinWidth();
        pSDEChartBase.resetNavViewPos();
        pSDEChartBase.resetNavViewShowMode();
        pSDEChartBase.resetNavViewWidth();
        pSDEChartBase.resetPSACHandlerId();
        pSDEChartBase.resetPSACHandlerName();
        pSDEChartBase.resetPSCtrlLogicGroupId();
        pSDEChartBase.resetPSCtrlLogicGroupName();
        pSDEChartBase.resetPSCtrlMsgId();
        pSDEChartBase.resetPSCtrlMsgName();
        pSDEChartBase.resetPSDEChartId();
        pSDEChartBase.resetPSDEChartName();
        pSDEChartBase.resetPSDEDSId();
        pSDEChartBase.resetPSDEDSName();
        pSDEChartBase.resetPSDEId();
        pSDEChartBase.resetPSDEName();
        pSDEChartBase.resetPSSysChartThemeId();
        pSDEChartBase.resetPSSysChartThemeName();
        pSDEChartBase.resetPSSysCssId();
        pSDEChartBase.resetPSSysCssName();
        pSDEChartBase.resetPSSysDynaModelId();
        pSDEChartBase.resetPSSysDynaModelName();
        pSDEChartBase.resetPSSysPFPluginId();
        pSDEChartBase.resetPSSysPFPluginName();
        pSDEChartBase.resetPSSysReqItemId();
        pSDEChartBase.resetPSSysReqItemName();
        pSDEChartBase.resetPSViewMsgGroupId();
        pSDEChartBase.resetPSViewMsgGroupName();
        pSDEChartBase.resetShowDataGrid();
        pSDEChartBase.resetShowLegend();
        pSDEChartBase.resetShowTitle();
        pSDEChartBase.resetSRFSysPub();
        pSDEChartBase.resetSubTitle();
        pSDEChartBase.resetSubTitlePSLanResId();
        pSDEChartBase.resetSubTitlePSLanResName();
        pSDEChartBase.resetTitlePos();
        pSDEChartBase.resetToDoTask();
        pSDEChartBase.resetUpdateDate();
        pSDEChartBase.resetUpdateMan();
        pSDEChartBase.resetUserParams();
        pSDEChartBase.resetUserTag();
        pSDEChartBase.resetUserTag2();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isADPSDELogicIdDirty()) {
            hashMap.put(FIELD_ADPSDELOGICID, this.getADPSDELogicId());
        }
        if (!bl || this.isADPSDELogicNameDirty()) {
            hashMap.put(FIELD_ADPSDELOGICNAME, this.getADPSDELogicName());
        }
        if (!bl || this.isBusyIndicatorDirty()) {
            hashMap.put(FIELD_BUSYINDICATOR, this.getBusyIndicator());
        }
        if (!bl || this.isChartModelDirty()) {
            hashMap.put(FIELD_CHARTMODEL, this.getChartModel());
        }
        if (!bl || this.isChartThemeDirty()) {
            hashMap.put(FIELD_CHARTTHEME, this.getChartTheme());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCoordinateSystemDirty()) {
            hashMap.put(FIELD_COORDINATESYSTEM, this.getCoordinateSystem());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCustomCondDirty()) {
            hashMap.put(FIELD_CUSTOMCOND, this.getCustomCond());
        }
        if (!bl || this.isCustomTypeDirty()) {
            hashMap.put(FIELD_CUSTOMTYPE, this.getCustomType());
        }
        if (!bl || this.isDataGridPosDirty()) {
            hashMap.put(FIELD_DATAGRIDPOS, this.getDataGridPos());
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
        if (!bl || this.isLegendPosDirty()) {
            hashMap.put(FIELD_LEGENDPOS, this.getLegendPos());
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
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMinorSortDirDirty()) {
            hashMap.put(FIELD_MINORSORTDIR, this.getMinorSortDir());
        }
        if (!bl || this.isMinorSortPSDEFIdDirty()) {
            hashMap.put(FIELD_MINORSORTPSDEFID, this.getMinorSortPSDEFId());
        }
        if (!bl || this.isMinorSortPSDEFNameDirty()) {
            hashMap.put(FIELD_MINORSORTPSDEFNAME, this.getMinorSortPSDEFName());
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
        if (!bl || this.isPSDEChartIdDirty()) {
            hashMap.put(FIELD_PSDECHARTID, this.getPSDEChartId());
        }
        if (!bl || this.isPSDEChartNameDirty()) {
            hashMap.put(FIELD_PSDECHARTNAME, this.getPSDEChartName());
        }
        if (!bl || this.isPSDEDSIdDirty()) {
            hashMap.put(FIELD_PSDEDSID, this.getPSDEDSId());
        }
        if (!bl || this.isPSDEDSNameDirty()) {
            hashMap.put(FIELD_PSDEDSNAME, this.getPSDEDSName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSSysChartThemeIdDirty()) {
            hashMap.put(FIELD_PSSYSCHARTTHEMEID, this.getPSSysChartThemeId());
        }
        if (!bl || this.isPSSysChartThemeNameDirty()) {
            hashMap.put(FIELD_PSSYSCHARTTHEMENAME, this.getPSSysChartThemeName());
        }
        if (!bl || this.isPSSysCssIdDirty()) {
            hashMap.put(FIELD_PSSYSCSSID, this.getPSSysCssId());
        }
        if (!bl || this.isPSSysCssNameDirty()) {
            hashMap.put(FIELD_PSSYSCSSNAME, this.getPSSysCssName());
        }
        if (!bl || this.isPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELID, this.getPSSysDynaModelId());
        }
        if (!bl || this.isPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELNAME, this.getPSSysDynaModelName());
        }
        if (!bl || this.isPSSysPFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINID, this.getPSSysPFPluginId());
        }
        if (!bl || this.isPSSysPFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINNAME, this.getPSSysPFPluginName());
        }
        if (!bl || this.isPSSysReqItemIdDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMID, this.getPSSysReqItemId());
        }
        if (!bl || this.isPSSysReqItemNameDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMNAME, this.getPSSysReqItemName());
        }
        if (!bl || this.isPSViewMsgGroupIdDirty()) {
            hashMap.put(FIELD_PSVIEWMSGGROUPID, this.getPSViewMsgGroupId());
        }
        if (!bl || this.isPSViewMsgGroupNameDirty()) {
            hashMap.put(FIELD_PSVIEWMSGGROUPNAME, this.getPSViewMsgGroupName());
        }
        if (!bl || this.isShowDataGridDirty()) {
            hashMap.put(FIELD_SHOWDATAGRID, this.getShowDataGrid());
        }
        if (!bl || this.isShowLegendDirty()) {
            hashMap.put(FIELD_SHOWLEGEND, this.getShowLegend());
        }
        if (!bl || this.isShowTitleDirty()) {
            hashMap.put(FIELD_SHOWTITLE, this.getShowTitle());
        }
        if (!bl || this.isSRFSysPubDirty()) {
            hashMap.put(FIELD_SRFSYSPUB, this.getSRFSysPub());
        }
        if (!bl || this.isSubTitleDirty()) {
            hashMap.put(FIELD_SUBTITLE, this.getSubTitle());
        }
        if (!bl || this.isSubTitlePSLanResIdDirty()) {
            hashMap.put(FIELD_SUBTITLEPSLANRESID, this.getSubTitlePSLanResId());
        }
        if (!bl || this.isSubTitlePSLanResNameDirty()) {
            hashMap.put(FIELD_SUBTITLEPSLANRESNAME, this.getSubTitlePSLanResName());
        }
        if (!bl || this.isTitlePosDirty()) {
            hashMap.put(FIELD_TITLEPOS, this.getTitlePos());
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
        if (!bl || this.isUserParamsDirty()) {
            hashMap.put(FIELD_USERPARAMS, this.getUserParams());
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
        return PSDEChartBase.get(this, n);
    }

    private static Object get(PSDEChartBase pSDEChartBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEChartBase.getADPSDELogicId();
            }
            case 1: {
                return pSDEChartBase.getADPSDELogicName();
            }
            case 2: {
                return pSDEChartBase.getBusyIndicator();
            }
            case 3: {
                return pSDEChartBase.getChartModel();
            }
            case 4: {
                return pSDEChartBase.getChartTheme();
            }
            case 5: {
                return pSDEChartBase.getCodeName();
            }
            case 6: {
                return pSDEChartBase.getCoordinateSystem();
            }
            case 7: {
                return pSDEChartBase.getCreateDate();
            }
            case 8: {
                return pSDEChartBase.getCreateMan();
            }
            case 9: {
                return pSDEChartBase.getCustomCond();
            }
            case 10: {
                return pSDEChartBase.getCustomType();
            }
            case 11: {
                return pSDEChartBase.getDataGridPos();
            }
            case 12: {
                return pSDEChartBase.getEmptyText();
            }
            case 13: {
                return pSDEChartBase.getEmptyTextPSLanResId();
            }
            case 14: {
                return pSDEChartBase.getEmptyTextPSLanResName();
            }
            case 15: {
                return pSDEChartBase.getLegendPos();
            }
            case 16: {
                return pSDEChartBase.getLNPSLanResId();
            }
            case 17: {
                return pSDEChartBase.getLNPSLanResName();
            }
            case 18: {
                return pSDEChartBase.getLockFlag();
            }
            case 19: {
                return pSDEChartBase.getLogicName();
            }
            case 20: {
                return pSDEChartBase.getMemo();
            }
            case 21: {
                return pSDEChartBase.getMinorSortDir();
            }
            case 22: {
                return pSDEChartBase.getMinorSortPSDEFId();
            }
            case 23: {
                return pSDEChartBase.getMinorSortPSDEFName();
            }
            case 24: {
                return pSDEChartBase.getNavViewHeight();
            }
            case 25: {
                return pSDEChartBase.getNavViewMaxHeight();
            }
            case 26: {
                return pSDEChartBase.getNavViewMaxWidth();
            }
            case 27: {
                return pSDEChartBase.getNavViewMinHeight();
            }
            case 28: {
                return pSDEChartBase.getNavViewMinWidth();
            }
            case 29: {
                return pSDEChartBase.getNavViewPos();
            }
            case 30: {
                return pSDEChartBase.getNavViewShowMode();
            }
            case 31: {
                return pSDEChartBase.getNavViewWidth();
            }
            case 32: {
                return pSDEChartBase.getPSACHandlerId();
            }
            case 33: {
                return pSDEChartBase.getPSACHandlerName();
            }
            case 34: {
                return pSDEChartBase.getPSCtrlLogicGroupId();
            }
            case 35: {
                return pSDEChartBase.getPSCtrlLogicGroupName();
            }
            case 36: {
                return pSDEChartBase.getPSCtrlMsgId();
            }
            case 37: {
                return pSDEChartBase.getPSCtrlMsgName();
            }
            case 38: {
                return pSDEChartBase.getPSDEChartId();
            }
            case 39: {
                return pSDEChartBase.getPSDEChartName();
            }
            case 40: {
                return pSDEChartBase.getPSDEDSId();
            }
            case 41: {
                return pSDEChartBase.getPSDEDSName();
            }
            case 42: {
                return pSDEChartBase.getPSDEId();
            }
            case 43: {
                return pSDEChartBase.getPSDEName();
            }
            case 44: {
                return pSDEChartBase.getPSSysChartThemeId();
            }
            case 45: {
                return pSDEChartBase.getPSSysChartThemeName();
            }
            case 46: {
                return pSDEChartBase.getPSSysCssId();
            }
            case 47: {
                return pSDEChartBase.getPSSysCssName();
            }
            case 48: {
                return pSDEChartBase.getPSSysDynaModelId();
            }
            case 49: {
                return pSDEChartBase.getPSSysDynaModelName();
            }
            case 50: {
                return pSDEChartBase.getPSSysPFPluginId();
            }
            case 51: {
                return pSDEChartBase.getPSSysPFPluginName();
            }
            case 52: {
                return pSDEChartBase.getPSSysReqItemId();
            }
            case 53: {
                return pSDEChartBase.getPSSysReqItemName();
            }
            case 54: {
                return pSDEChartBase.getPSViewMsgGroupId();
            }
            case 55: {
                return pSDEChartBase.getPSViewMsgGroupName();
            }
            case 56: {
                return pSDEChartBase.getShowDataGrid();
            }
            case 57: {
                return pSDEChartBase.getShowLegend();
            }
            case 58: {
                return pSDEChartBase.getShowTitle();
            }
            case 59: {
                return pSDEChartBase.getSRFSysPub();
            }
            case 60: {
                return pSDEChartBase.getSubTitle();
            }
            case 61: {
                return pSDEChartBase.getSubTitlePSLanResId();
            }
            case 62: {
                return pSDEChartBase.getSubTitlePSLanResName();
            }
            case 63: {
                return pSDEChartBase.getTitlePos();
            }
            case 64: {
                return pSDEChartBase.getToDoTask();
            }
            case 65: {
                return pSDEChartBase.getUpdateDate();
            }
            case 66: {
                return pSDEChartBase.getUpdateMan();
            }
            case 67: {
                return pSDEChartBase.getUserParams();
            }
            case 68: {
                return pSDEChartBase.getUserTag();
            }
            case 69: {
                return pSDEChartBase.getUserTag2();
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
        PSDEChartBase.set(this, n, object);
    }

    private static void set(PSDEChartBase pSDEChartBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEChartBase.setADPSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEChartBase.setADPSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEChartBase.setBusyIndicator(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSDEChartBase.setChartModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEChartBase.setChartTheme(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEChartBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEChartBase.setCoordinateSystem(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEChartBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSDEChartBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEChartBase.setCustomCond(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEChartBase.setCustomType(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEChartBase.setDataGridPos(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEChartBase.setEmptyText(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEChartBase.setEmptyTextPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEChartBase.setEmptyTextPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEChartBase.setLegendPos(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEChartBase.setLNPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEChartBase.setLNPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEChartBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSDEChartBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEChartBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEChartBase.setMinorSortDir(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEChartBase.setMinorSortPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEChartBase.setMinorSortPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEChartBase.setNavViewHeight(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 25: {
                pSDEChartBase.setNavViewMaxHeight(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 26: {
                pSDEChartBase.setNavViewMaxWidth(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 27: {
                pSDEChartBase.setNavViewMinHeight(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 28: {
                pSDEChartBase.setNavViewMinWidth(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 29: {
                pSDEChartBase.setNavViewPos(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDEChartBase.setNavViewShowMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 31: {
                pSDEChartBase.setNavViewWidth(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 32: {
                pSDEChartBase.setPSACHandlerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDEChartBase.setPSACHandlerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDEChartBase.setPSCtrlLogicGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDEChartBase.setPSCtrlLogicGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDEChartBase.setPSCtrlMsgId(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDEChartBase.setPSCtrlMsgName(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDEChartBase.setPSDEChartId(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDEChartBase.setPSDEChartName(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDEChartBase.setPSDEDSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDEChartBase.setPSDEDSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDEChartBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSDEChartBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSDEChartBase.setPSSysChartThemeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSDEChartBase.setPSSysChartThemeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSDEChartBase.setPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSDEChartBase.setPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSDEChartBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSDEChartBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSDEChartBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSDEChartBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSDEChartBase.setPSSysReqItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSDEChartBase.setPSSysReqItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSDEChartBase.setPSViewMsgGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSDEChartBase.setPSViewMsgGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSDEChartBase.setShowDataGrid(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 57: {
                pSDEChartBase.setShowLegend(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 58: {
                pSDEChartBase.setShowTitle(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 59: {
                pSDEChartBase.setSRFSysPub(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 60: {
                pSDEChartBase.setSubTitle(DataObject.getStringValue((Object)object));
                return;
            }
            case 61: {
                pSDEChartBase.setSubTitlePSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 62: {
                pSDEChartBase.setSubTitlePSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 63: {
                pSDEChartBase.setTitlePos(DataObject.getStringValue((Object)object));
                return;
            }
            case 64: {
                pSDEChartBase.setToDoTask(DataObject.getStringValue((Object)object));
                return;
            }
            case 65: {
                pSDEChartBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 66: {
                pSDEChartBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 67: {
                pSDEChartBase.setUserParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 68: {
                pSDEChartBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 69: {
                pSDEChartBase.setUserTag2(DataObject.getStringValue((Object)object));
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
        return PSDEChartBase.isNull(this, n);
    }

    private static boolean isNull(PSDEChartBase pSDEChartBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEChartBase.getADPSDELogicId() == null;
            }
            case 1: {
                return pSDEChartBase.getADPSDELogicName() == null;
            }
            case 2: {
                return pSDEChartBase.getBusyIndicator() == null;
            }
            case 3: {
                return pSDEChartBase.getChartModel() == null;
            }
            case 4: {
                return pSDEChartBase.getChartTheme() == null;
            }
            case 5: {
                return pSDEChartBase.getCodeName() == null;
            }
            case 6: {
                return pSDEChartBase.getCoordinateSystem() == null;
            }
            case 7: {
                return pSDEChartBase.getCreateDate() == null;
            }
            case 8: {
                return pSDEChartBase.getCreateMan() == null;
            }
            case 9: {
                return pSDEChartBase.getCustomCond() == null;
            }
            case 10: {
                return pSDEChartBase.getCustomType() == null;
            }
            case 11: {
                return pSDEChartBase.getDataGridPos() == null;
            }
            case 12: {
                return pSDEChartBase.getEmptyText() == null;
            }
            case 13: {
                return pSDEChartBase.getEmptyTextPSLanResId() == null;
            }
            case 14: {
                return pSDEChartBase.getEmptyTextPSLanResName() == null;
            }
            case 15: {
                return pSDEChartBase.getLegendPos() == null;
            }
            case 16: {
                return pSDEChartBase.getLNPSLanResId() == null;
            }
            case 17: {
                return pSDEChartBase.getLNPSLanResName() == null;
            }
            case 18: {
                return pSDEChartBase.getLockFlag() == null;
            }
            case 19: {
                return pSDEChartBase.getLogicName() == null;
            }
            case 20: {
                return pSDEChartBase.getMemo() == null;
            }
            case 21: {
                return pSDEChartBase.getMinorSortDir() == null;
            }
            case 22: {
                return pSDEChartBase.getMinorSortPSDEFId() == null;
            }
            case 23: {
                return pSDEChartBase.getMinorSortPSDEFName() == null;
            }
            case 24: {
                return pSDEChartBase.getNavViewHeight() == null;
            }
            case 25: {
                return pSDEChartBase.getNavViewMaxHeight() == null;
            }
            case 26: {
                return pSDEChartBase.getNavViewMaxWidth() == null;
            }
            case 27: {
                return pSDEChartBase.getNavViewMinHeight() == null;
            }
            case 28: {
                return pSDEChartBase.getNavViewMinWidth() == null;
            }
            case 29: {
                return pSDEChartBase.getNavViewPos() == null;
            }
            case 30: {
                return pSDEChartBase.getNavViewShowMode() == null;
            }
            case 31: {
                return pSDEChartBase.getNavViewWidth() == null;
            }
            case 32: {
                return pSDEChartBase.getPSACHandlerId() == null;
            }
            case 33: {
                return pSDEChartBase.getPSACHandlerName() == null;
            }
            case 34: {
                return pSDEChartBase.getPSCtrlLogicGroupId() == null;
            }
            case 35: {
                return pSDEChartBase.getPSCtrlLogicGroupName() == null;
            }
            case 36: {
                return pSDEChartBase.getPSCtrlMsgId() == null;
            }
            case 37: {
                return pSDEChartBase.getPSCtrlMsgName() == null;
            }
            case 38: {
                return pSDEChartBase.getPSDEChartId() == null;
            }
            case 39: {
                return pSDEChartBase.getPSDEChartName() == null;
            }
            case 40: {
                return pSDEChartBase.getPSDEDSId() == null;
            }
            case 41: {
                return pSDEChartBase.getPSDEDSName() == null;
            }
            case 42: {
                return pSDEChartBase.getPSDEId() == null;
            }
            case 43: {
                return pSDEChartBase.getPSDEName() == null;
            }
            case 44: {
                return pSDEChartBase.getPSSysChartThemeId() == null;
            }
            case 45: {
                return pSDEChartBase.getPSSysChartThemeName() == null;
            }
            case 46: {
                return pSDEChartBase.getPSSysCssId() == null;
            }
            case 47: {
                return pSDEChartBase.getPSSysCssName() == null;
            }
            case 48: {
                return pSDEChartBase.getPSSysDynaModelId() == null;
            }
            case 49: {
                return pSDEChartBase.getPSSysDynaModelName() == null;
            }
            case 50: {
                return pSDEChartBase.getPSSysPFPluginId() == null;
            }
            case 51: {
                return pSDEChartBase.getPSSysPFPluginName() == null;
            }
            case 52: {
                return pSDEChartBase.getPSSysReqItemId() == null;
            }
            case 53: {
                return pSDEChartBase.getPSSysReqItemName() == null;
            }
            case 54: {
                return pSDEChartBase.getPSViewMsgGroupId() == null;
            }
            case 55: {
                return pSDEChartBase.getPSViewMsgGroupName() == null;
            }
            case 56: {
                return pSDEChartBase.getShowDataGrid() == null;
            }
            case 57: {
                return pSDEChartBase.getShowLegend() == null;
            }
            case 58: {
                return pSDEChartBase.getShowTitle() == null;
            }
            case 59: {
                return pSDEChartBase.getSRFSysPub() == null;
            }
            case 60: {
                return pSDEChartBase.getSubTitle() == null;
            }
            case 61: {
                return pSDEChartBase.getSubTitlePSLanResId() == null;
            }
            case 62: {
                return pSDEChartBase.getSubTitlePSLanResName() == null;
            }
            case 63: {
                return pSDEChartBase.getTitlePos() == null;
            }
            case 64: {
                return pSDEChartBase.getToDoTask() == null;
            }
            case 65: {
                return pSDEChartBase.getUpdateDate() == null;
            }
            case 66: {
                return pSDEChartBase.getUpdateMan() == null;
            }
            case 67: {
                return pSDEChartBase.getUserParams() == null;
            }
            case 68: {
                return pSDEChartBase.getUserTag() == null;
            }
            case 69: {
                return pSDEChartBase.getUserTag2() == null;
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
        return PSDEChartBase.contains(this, n);
    }

    private static boolean contains(PSDEChartBase pSDEChartBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEChartBase.isADPSDELogicIdDirty();
            }
            case 1: {
                return pSDEChartBase.isADPSDELogicNameDirty();
            }
            case 2: {
                return pSDEChartBase.isBusyIndicatorDirty();
            }
            case 3: {
                return pSDEChartBase.isChartModelDirty();
            }
            case 4: {
                return pSDEChartBase.isChartThemeDirty();
            }
            case 5: {
                return pSDEChartBase.isCodeNameDirty();
            }
            case 6: {
                return pSDEChartBase.isCoordinateSystemDirty();
            }
            case 7: {
                return pSDEChartBase.isCreateDateDirty();
            }
            case 8: {
                return pSDEChartBase.isCreateManDirty();
            }
            case 9: {
                return pSDEChartBase.isCustomCondDirty();
            }
            case 10: {
                return pSDEChartBase.isCustomTypeDirty();
            }
            case 11: {
                return pSDEChartBase.isDataGridPosDirty();
            }
            case 12: {
                return pSDEChartBase.isEmptyTextDirty();
            }
            case 13: {
                return pSDEChartBase.isEmptyTextPSLanResIdDirty();
            }
            case 14: {
                return pSDEChartBase.isEmptyTextPSLanResNameDirty();
            }
            case 15: {
                return pSDEChartBase.isLegendPosDirty();
            }
            case 16: {
                return pSDEChartBase.isLNPSLanResIdDirty();
            }
            case 17: {
                return pSDEChartBase.isLNPSLanResNameDirty();
            }
            case 18: {
                return pSDEChartBase.isLockFlagDirty();
            }
            case 19: {
                return pSDEChartBase.isLogicNameDirty();
            }
            case 20: {
                return pSDEChartBase.isMemoDirty();
            }
            case 21: {
                return pSDEChartBase.isMinorSortDirDirty();
            }
            case 22: {
                return pSDEChartBase.isMinorSortPSDEFIdDirty();
            }
            case 23: {
                return pSDEChartBase.isMinorSortPSDEFNameDirty();
            }
            case 24: {
                return pSDEChartBase.isNavViewHeightDirty();
            }
            case 25: {
                return pSDEChartBase.isNavViewMaxHeightDirty();
            }
            case 26: {
                return pSDEChartBase.isNavViewMaxWidthDirty();
            }
            case 27: {
                return pSDEChartBase.isNavViewMinHeightDirty();
            }
            case 28: {
                return pSDEChartBase.isNavViewMinWidthDirty();
            }
            case 29: {
                return pSDEChartBase.isNavViewPosDirty();
            }
            case 30: {
                return pSDEChartBase.isNavViewShowModeDirty();
            }
            case 31: {
                return pSDEChartBase.isNavViewWidthDirty();
            }
            case 32: {
                return pSDEChartBase.isPSACHandlerIdDirty();
            }
            case 33: {
                return pSDEChartBase.isPSACHandlerNameDirty();
            }
            case 34: {
                return pSDEChartBase.isPSCtrlLogicGroupIdDirty();
            }
            case 35: {
                return pSDEChartBase.isPSCtrlLogicGroupNameDirty();
            }
            case 36: {
                return pSDEChartBase.isPSCtrlMsgIdDirty();
            }
            case 37: {
                return pSDEChartBase.isPSCtrlMsgNameDirty();
            }
            case 38: {
                return pSDEChartBase.isPSDEChartIdDirty();
            }
            case 39: {
                return pSDEChartBase.isPSDEChartNameDirty();
            }
            case 40: {
                return pSDEChartBase.isPSDEDSIdDirty();
            }
            case 41: {
                return pSDEChartBase.isPSDEDSNameDirty();
            }
            case 42: {
                return pSDEChartBase.isPSDEIdDirty();
            }
            case 43: {
                return pSDEChartBase.isPSDENameDirty();
            }
            case 44: {
                return pSDEChartBase.isPSSysChartThemeIdDirty();
            }
            case 45: {
                return pSDEChartBase.isPSSysChartThemeNameDirty();
            }
            case 46: {
                return pSDEChartBase.isPSSysCssIdDirty();
            }
            case 47: {
                return pSDEChartBase.isPSSysCssNameDirty();
            }
            case 48: {
                return pSDEChartBase.isPSSysDynaModelIdDirty();
            }
            case 49: {
                return pSDEChartBase.isPSSysDynaModelNameDirty();
            }
            case 50: {
                return pSDEChartBase.isPSSysPFPluginIdDirty();
            }
            case 51: {
                return pSDEChartBase.isPSSysPFPluginNameDirty();
            }
            case 52: {
                return pSDEChartBase.isPSSysReqItemIdDirty();
            }
            case 53: {
                return pSDEChartBase.isPSSysReqItemNameDirty();
            }
            case 54: {
                return pSDEChartBase.isPSViewMsgGroupIdDirty();
            }
            case 55: {
                return pSDEChartBase.isPSViewMsgGroupNameDirty();
            }
            case 56: {
                return pSDEChartBase.isShowDataGridDirty();
            }
            case 57: {
                return pSDEChartBase.isShowLegendDirty();
            }
            case 58: {
                return pSDEChartBase.isShowTitleDirty();
            }
            case 59: {
                return pSDEChartBase.isSRFSysPubDirty();
            }
            case 60: {
                return pSDEChartBase.isSubTitleDirty();
            }
            case 61: {
                return pSDEChartBase.isSubTitlePSLanResIdDirty();
            }
            case 62: {
                return pSDEChartBase.isSubTitlePSLanResNameDirty();
            }
            case 63: {
                return pSDEChartBase.isTitlePosDirty();
            }
            case 64: {
                return pSDEChartBase.isToDoTaskDirty();
            }
            case 65: {
                return pSDEChartBase.isUpdateDateDirty();
            }
            case 66: {
                return pSDEChartBase.isUpdateManDirty();
            }
            case 67: {
                return pSDEChartBase.isUserParamsDirty();
            }
            case 68: {
                return pSDEChartBase.isUserTagDirty();
            }
            case 69: {
                return pSDEChartBase.isUserTag2Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEChartBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEChartBase pSDEChartBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEChartBase.getADPSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"adpsdelogicid", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getADPSDELogicId()), (boolean)false);
        }
        if (bl || pSDEChartBase.getADPSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"adpsdelogicname", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getADPSDELogicName()), (boolean)false);
        }
        if (bl || pSDEChartBase.getBusyIndicator() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"busyindicator", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getBusyIndicator()), (boolean)false);
        }
        if (bl || pSDEChartBase.getChartModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"chartmodel", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getChartModel()), (boolean)false);
        }
        if (bl || pSDEChartBase.getChartTheme() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"charttheme", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getChartTheme()), (boolean)false);
        }
        if (bl || pSDEChartBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDEChartBase.getCoordinateSystem() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"coordinatesystem", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getCoordinateSystem()), (boolean)false);
        }
        if (bl || pSDEChartBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEChartBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEChartBase.getCustomCond() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcond", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getCustomCond()), (boolean)false);
        }
        if (bl || pSDEChartBase.getCustomType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customtype", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getCustomType()), (boolean)false);
        }
        if (bl || pSDEChartBase.getDataGridPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"datagridpos", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getDataGridPos()), (boolean)false);
        }
        if (bl || pSDEChartBase.getEmptyText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"emptytext", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getEmptyText()), (boolean)false);
        }
        if (bl || pSDEChartBase.getEmptyTextPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"emptytextpslanresid", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getEmptyTextPSLanResId()), (boolean)false);
        }
        if (bl || pSDEChartBase.getEmptyTextPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"emptytextpslanresname", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getEmptyTextPSLanResName()), (boolean)false);
        }
        if (bl || pSDEChartBase.getLegendPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"legendpos", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getLegendPos()), (boolean)false);
        }
        if (bl || pSDEChartBase.getLNPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lnpslanresid", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getLNPSLanResId()), (boolean)false);
        }
        if (bl || pSDEChartBase.getLNPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lnpslanresname", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getLNPSLanResName()), (boolean)false);
        }
        if (bl || pSDEChartBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSDEChartBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getLogicName()), (boolean)false);
        }
        if (bl || pSDEChartBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEChartBase.getMinorSortDir() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minorsortdir", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getMinorSortDir()), (boolean)false);
        }
        if (bl || pSDEChartBase.getMinorSortPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minorsortpsdefid", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getMinorSortPSDEFId()), (boolean)false);
        }
        if (bl || pSDEChartBase.getMinorSortPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minorsortpsdefname", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getMinorSortPSDEFName()), (boolean)false);
        }
        if (bl || pSDEChartBase.getNavViewHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewheight", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getNavViewHeight()), (boolean)false);
        }
        if (bl || pSDEChartBase.getNavViewMaxHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewmaxheight", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getNavViewMaxHeight()), (boolean)false);
        }
        if (bl || pSDEChartBase.getNavViewMaxWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewmaxwidth", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getNavViewMaxWidth()), (boolean)false);
        }
        if (bl || pSDEChartBase.getNavViewMinHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewminheight", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getNavViewMinHeight()), (boolean)false);
        }
        if (bl || pSDEChartBase.getNavViewMinWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewminwidth", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getNavViewMinWidth()), (boolean)false);
        }
        if (bl || pSDEChartBase.getNavViewPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewpos", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getNavViewPos()), (boolean)false);
        }
        if (bl || pSDEChartBase.getNavViewShowMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewshowmode", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getNavViewShowMode()), (boolean)false);
        }
        if (bl || pSDEChartBase.getNavViewWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewwidth", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getNavViewWidth()), (boolean)false);
        }
        if (bl || pSDEChartBase.getPSACHandlerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psachandlerid", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getPSACHandlerId()), (boolean)false);
        }
        if (bl || pSDEChartBase.getPSACHandlerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psachandlername", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getPSACHandlerName()), (boolean)false);
        }
        if (bl || pSDEChartBase.getPSCtrlLogicGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrllogicgroupid", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getPSCtrlLogicGroupId()), (boolean)false);
        }
        if (bl || pSDEChartBase.getPSCtrlLogicGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrllogicgroupname", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getPSCtrlLogicGroupName()), (boolean)false);
        }
        if (bl || pSDEChartBase.getPSCtrlMsgId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrlmsgid", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getPSCtrlMsgId()), (boolean)false);
        }
        if (bl || pSDEChartBase.getPSCtrlMsgName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrlmsgname", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getPSCtrlMsgName()), (boolean)false);
        }
        if (bl || pSDEChartBase.getPSDEChartId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdechartid", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getPSDEChartId()), (boolean)false);
        }
        if (bl || pSDEChartBase.getPSDEChartName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdechartname", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getPSDEChartName()), (boolean)false);
        }
        if (bl || pSDEChartBase.getPSDEDSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedsid", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getPSDEDSId()), (boolean)false);
        }
        if (bl || pSDEChartBase.getPSDEDSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedsname", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getPSDEDSName()), (boolean)false);
        }
        if (bl || pSDEChartBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEChartBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEChartBase.getPSSysChartThemeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyschartthemeid", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getPSSysChartThemeId()), (boolean)false);
        }
        if (bl || pSDEChartBase.getPSSysChartThemeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyschartthemename", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getPSSysChartThemeName()), (boolean)false);
        }
        if (bl || pSDEChartBase.getPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssid", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getPSSysCssId()), (boolean)false);
        }
        if (bl || pSDEChartBase.getPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssname", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getPSSysCssName()), (boolean)false);
        }
        if (bl || pSDEChartBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSDEChartBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSDEChartBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSDEChartBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSDEChartBase.getPSSysReqItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemid", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getPSSysReqItemId()), (boolean)false);
        }
        if (bl || pSDEChartBase.getPSSysReqItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemname", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getPSSysReqItemName()), (boolean)false);
        }
        if (bl || pSDEChartBase.getPSViewMsgGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewmsggroupid", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getPSViewMsgGroupId()), (boolean)false);
        }
        if (bl || pSDEChartBase.getPSViewMsgGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewmsggroupname", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getPSViewMsgGroupName()), (boolean)false);
        }
        if (bl || pSDEChartBase.getShowDataGrid() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"showdatagrid", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getShowDataGrid()), (boolean)false);
        }
        if (bl || pSDEChartBase.getShowLegend() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"showlegend", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getShowLegend()), (boolean)false);
        }
        if (bl || pSDEChartBase.getShowTitle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"showtitle", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getShowTitle()), (boolean)false);
        }
        if (bl || pSDEChartBase.getSRFSysPub() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srfsyspub", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getSRFSysPub()), (boolean)false);
        }
        if (bl || pSDEChartBase.getSubTitle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"subtitle", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getSubTitle()), (boolean)false);
        }
        if (bl || pSDEChartBase.getSubTitlePSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"subtitlepslanresid", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getSubTitlePSLanResId()), (boolean)false);
        }
        if (bl || pSDEChartBase.getSubTitlePSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"subtitlepslanresname", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getSubTitlePSLanResName()), (boolean)false);
        }
        if (bl || pSDEChartBase.getTitlePos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"titlepos", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getTitlePos()), (boolean)false);
        }
        if (bl || pSDEChartBase.getToDoTask() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"todotask", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getToDoTask()), (boolean)false);
        }
        if (bl || pSDEChartBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEChartBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEChartBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getUserParams()), (boolean)false);
        }
        if (bl || pSDEChartBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEChartBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEChartBase.getJSONValue((Object)pSDEChartBase.getUserTag2()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEChartBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEChartBase pSDEChartBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEChartBase.getADPSDELogicId() != null) {
            object = pSDEChartBase.getADPSDELogicId();
            xmlNode.setAttribute(FIELD_ADPSDELOGICID, (String)(object == null ? "" : object));
        }
        if (bl || pSDEChartBase.getADPSDELogicName() != null) {
            object = pSDEChartBase.getADPSDELogicName();
            xmlNode.setAttribute(FIELD_ADPSDELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartBase.getBusyIndicator() != null) {
            object = pSDEChartBase.getBusyIndicator();
            xmlNode.setAttribute(FIELD_BUSYINDICATOR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEChartBase.getChartModel() != null) {
            object = pSDEChartBase.getChartModel();
            xmlNode.setAttribute(FIELD_CHARTMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartBase.getChartTheme() != null) {
            object = pSDEChartBase.getChartTheme();
            xmlNode.setAttribute(FIELD_CHARTTHEME, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartBase.getCodeName() != null) {
            object = pSDEChartBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartBase.getCoordinateSystem() != null) {
            object = pSDEChartBase.getCoordinateSystem();
            xmlNode.setAttribute(FIELD_COORDINATESYSTEM, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartBase.getCreateDate() != null) {
            object = pSDEChartBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEChartBase.getCreateMan() != null) {
            object = pSDEChartBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartBase.getCustomCond() != null) {
            object = pSDEChartBase.getCustomCond();
            xmlNode.setAttribute(FIELD_CUSTOMCOND, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartBase.getCustomType() != null) {
            object = pSDEChartBase.getCustomType();
            xmlNode.setAttribute(FIELD_CUSTOMTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartBase.getDataGridPos() != null) {
            object = pSDEChartBase.getDataGridPos();
            xmlNode.setAttribute(FIELD_DATAGRIDPOS, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartBase.getEmptyText() != null) {
            object = pSDEChartBase.getEmptyText();
            xmlNode.setAttribute(FIELD_EMPTYTEXT, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartBase.getEmptyTextPSLanResId() != null) {
            object = pSDEChartBase.getEmptyTextPSLanResId();
            xmlNode.setAttribute(FIELD_EMPTYTEXTPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartBase.getEmptyTextPSLanResName() != null) {
            object = pSDEChartBase.getEmptyTextPSLanResName();
            xmlNode.setAttribute(FIELD_EMPTYTEXTPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartBase.getLegendPos() != null) {
            object = pSDEChartBase.getLegendPos();
            xmlNode.setAttribute(FIELD_LEGENDPOS, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartBase.getLNPSLanResId() != null) {
            object = pSDEChartBase.getLNPSLanResId();
            xmlNode.setAttribute(FIELD_LNPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartBase.getLNPSLanResName() != null) {
            object = pSDEChartBase.getLNPSLanResName();
            xmlNode.setAttribute(FIELD_LNPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartBase.getLockFlag() != null) {
            object = pSDEChartBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEChartBase.getLogicName() != null) {
            object = pSDEChartBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartBase.getMemo() != null) {
            object = pSDEChartBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartBase.getMinorSortDir() != null) {
            object = pSDEChartBase.getMinorSortDir();
            xmlNode.setAttribute(FIELD_MINORSORTDIR, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartBase.getMinorSortPSDEFId() != null) {
            object = pSDEChartBase.getMinorSortPSDEFId();
            xmlNode.setAttribute(FIELD_MINORSORTPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartBase.getMinorSortPSDEFName() != null) {
            object = pSDEChartBase.getMinorSortPSDEFName();
            xmlNode.setAttribute(FIELD_MINORSORTPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartBase.getNavViewHeight() != null) {
            object = pSDEChartBase.getNavViewHeight();
            xmlNode.setAttribute(FIELD_NAVVIEWHEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEChartBase.getNavViewMaxHeight() != null) {
            object = pSDEChartBase.getNavViewMaxHeight();
            xmlNode.setAttribute(FIELD_NAVVIEWMAXHEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEChartBase.getNavViewMaxWidth() != null) {
            object = pSDEChartBase.getNavViewMaxWidth();
            xmlNode.setAttribute(FIELD_NAVVIEWMAXWIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEChartBase.getNavViewMinHeight() != null) {
            object = pSDEChartBase.getNavViewMinHeight();
            xmlNode.setAttribute(FIELD_NAVVIEWMINHEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEChartBase.getNavViewMinWidth() != null) {
            object = pSDEChartBase.getNavViewMinWidth();
            xmlNode.setAttribute(FIELD_NAVVIEWMINWIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEChartBase.getNavViewPos() != null) {
            object = pSDEChartBase.getNavViewPos();
            xmlNode.setAttribute(FIELD_NAVVIEWPOS, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartBase.getNavViewShowMode() != null) {
            object = pSDEChartBase.getNavViewShowMode();
            xmlNode.setAttribute(FIELD_NAVVIEWSHOWMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEChartBase.getNavViewWidth() != null) {
            object = pSDEChartBase.getNavViewWidth();
            xmlNode.setAttribute(FIELD_NAVVIEWWIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEChartBase.getPSACHandlerId() != null) {
            object = pSDEChartBase.getPSACHandlerId();
            xmlNode.setAttribute(FIELD_PSACHANDLERID, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartBase.getPSACHandlerName() != null) {
            object = pSDEChartBase.getPSACHandlerName();
            xmlNode.setAttribute(FIELD_PSACHANDLERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartBase.getPSCtrlLogicGroupId() != null) {
            object = pSDEChartBase.getPSCtrlLogicGroupId();
            xmlNode.setAttribute(FIELD_PSCTRLLOGICGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartBase.getPSCtrlLogicGroupName() != null) {
            object = pSDEChartBase.getPSCtrlLogicGroupName();
            xmlNode.setAttribute(FIELD_PSCTRLLOGICGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartBase.getPSCtrlMsgId() != null) {
            object = pSDEChartBase.getPSCtrlMsgId();
            xmlNode.setAttribute(FIELD_PSCTRLMSGID, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartBase.getPSCtrlMsgName() != null) {
            object = pSDEChartBase.getPSCtrlMsgName();
            xmlNode.setAttribute(FIELD_PSCTRLMSGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartBase.getPSDEChartId() != null) {
            object = pSDEChartBase.getPSDEChartId();
            xmlNode.setAttribute(FIELD_PSDECHARTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartBase.getPSDEChartName() != null) {
            object = pSDEChartBase.getPSDEChartName();
            xmlNode.setAttribute(FIELD_PSDECHARTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartBase.getPSDEDSId() != null) {
            object = pSDEChartBase.getPSDEDSId();
            xmlNode.setAttribute(FIELD_PSDEDSID, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartBase.getPSDEDSName() != null) {
            object = pSDEChartBase.getPSDEDSName();
            xmlNode.setAttribute(FIELD_PSDEDSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartBase.getPSDEId() != null) {
            object = pSDEChartBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartBase.getPSDEName() != null) {
            object = pSDEChartBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartBase.getPSSysChartThemeId() != null) {
            object = pSDEChartBase.getPSSysChartThemeId();
            xmlNode.setAttribute(FIELD_PSSYSCHARTTHEMEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartBase.getPSSysChartThemeName() != null) {
            object = pSDEChartBase.getPSSysChartThemeName();
            xmlNode.setAttribute(FIELD_PSSYSCHARTTHEMENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartBase.getPSSysCssId() != null) {
            object = pSDEChartBase.getPSSysCssId();
            xmlNode.setAttribute(FIELD_PSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartBase.getPSSysCssName() != null) {
            object = pSDEChartBase.getPSSysCssName();
            xmlNode.setAttribute(FIELD_PSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartBase.getPSSysDynaModelId() != null) {
            object = pSDEChartBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartBase.getPSSysDynaModelName() != null) {
            object = pSDEChartBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartBase.getPSSysPFPluginId() != null) {
            object = pSDEChartBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartBase.getPSSysPFPluginName() != null) {
            object = pSDEChartBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartBase.getPSSysReqItemId() != null) {
            object = pSDEChartBase.getPSSysReqItemId();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartBase.getPSSysReqItemName() != null) {
            object = pSDEChartBase.getPSSysReqItemName();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartBase.getPSViewMsgGroupId() != null) {
            object = pSDEChartBase.getPSViewMsgGroupId();
            xmlNode.setAttribute(FIELD_PSVIEWMSGGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartBase.getPSViewMsgGroupName() != null) {
            object = pSDEChartBase.getPSViewMsgGroupName();
            xmlNode.setAttribute(FIELD_PSVIEWMSGGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartBase.getShowDataGrid() != null) {
            object = pSDEChartBase.getShowDataGrid();
            xmlNode.setAttribute(FIELD_SHOWDATAGRID, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEChartBase.getShowLegend() != null) {
            object = pSDEChartBase.getShowLegend();
            xmlNode.setAttribute(FIELD_SHOWLEGEND, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEChartBase.getShowTitle() != null) {
            object = pSDEChartBase.getShowTitle();
            xmlNode.setAttribute(FIELD_SHOWTITLE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEChartBase.getSRFSysPub() != null) {
            object = pSDEChartBase.getSRFSysPub();
            xmlNode.setAttribute(FIELD_SRFSYSPUB, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEChartBase.getSubTitle() != null) {
            object = pSDEChartBase.getSubTitle();
            xmlNode.setAttribute(FIELD_SUBTITLE, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartBase.getSubTitlePSLanResId() != null) {
            object = pSDEChartBase.getSubTitlePSLanResId();
            xmlNode.setAttribute(FIELD_SUBTITLEPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartBase.getSubTitlePSLanResName() != null) {
            object = pSDEChartBase.getSubTitlePSLanResName();
            xmlNode.setAttribute(FIELD_SUBTITLEPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartBase.getTitlePos() != null) {
            object = pSDEChartBase.getTitlePos();
            xmlNode.setAttribute(FIELD_TITLEPOS, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartBase.getToDoTask() != null) {
            object = pSDEChartBase.getToDoTask();
            xmlNode.setAttribute(FIELD_TODOTASK, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartBase.getUpdateDate() != null) {
            object = pSDEChartBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEChartBase.getUpdateMan() != null) {
            object = pSDEChartBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartBase.getUserParams() != null) {
            object = pSDEChartBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartBase.getUserTag() != null) {
            object = pSDEChartBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartBase.getUserTag2() != null) {
            object = pSDEChartBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEChartBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEChartBase pSDEChartBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEChartBase.isADPSDELogicIdDirty() && (bl || pSDEChartBase.getADPSDELogicId() != null)) {
            iDataObject.set(FIELD_ADPSDELOGICID, (Object)pSDEChartBase.getADPSDELogicId());
        }
        if (pSDEChartBase.isADPSDELogicNameDirty() && (bl || pSDEChartBase.getADPSDELogicName() != null)) {
            iDataObject.set(FIELD_ADPSDELOGICNAME, (Object)pSDEChartBase.getADPSDELogicName());
        }
        if (pSDEChartBase.isBusyIndicatorDirty() && (bl || pSDEChartBase.getBusyIndicator() != null)) {
            iDataObject.set(FIELD_BUSYINDICATOR, (Object)pSDEChartBase.getBusyIndicator());
        }
        if (pSDEChartBase.isChartModelDirty() && (bl || pSDEChartBase.getChartModel() != null)) {
            iDataObject.set(FIELD_CHARTMODEL, (Object)pSDEChartBase.getChartModel());
        }
        if (pSDEChartBase.isChartThemeDirty() && (bl || pSDEChartBase.getChartTheme() != null)) {
            iDataObject.set(FIELD_CHARTTHEME, (Object)pSDEChartBase.getChartTheme());
        }
        if (pSDEChartBase.isCodeNameDirty() && (bl || pSDEChartBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDEChartBase.getCodeName());
        }
        if (pSDEChartBase.isCoordinateSystemDirty() && (bl || pSDEChartBase.getCoordinateSystem() != null)) {
            iDataObject.set(FIELD_COORDINATESYSTEM, (Object)pSDEChartBase.getCoordinateSystem());
        }
        if (pSDEChartBase.isCreateDateDirty() && (bl || pSDEChartBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEChartBase.getCreateDate());
        }
        if (pSDEChartBase.isCreateManDirty() && (bl || pSDEChartBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEChartBase.getCreateMan());
        }
        if (pSDEChartBase.isCustomCondDirty() && (bl || pSDEChartBase.getCustomCond() != null)) {
            iDataObject.set(FIELD_CUSTOMCOND, (Object)pSDEChartBase.getCustomCond());
        }
        if (pSDEChartBase.isCustomTypeDirty() && (bl || pSDEChartBase.getCustomType() != null)) {
            iDataObject.set(FIELD_CUSTOMTYPE, (Object)pSDEChartBase.getCustomType());
        }
        if (pSDEChartBase.isDataGridPosDirty() && (bl || pSDEChartBase.getDataGridPos() != null)) {
            iDataObject.set(FIELD_DATAGRIDPOS, (Object)pSDEChartBase.getDataGridPos());
        }
        if (pSDEChartBase.isEmptyTextDirty() && (bl || pSDEChartBase.getEmptyText() != null)) {
            iDataObject.set(FIELD_EMPTYTEXT, (Object)pSDEChartBase.getEmptyText());
        }
        if (pSDEChartBase.isEmptyTextPSLanResIdDirty() && (bl || pSDEChartBase.getEmptyTextPSLanResId() != null)) {
            iDataObject.set(FIELD_EMPTYTEXTPSLANRESID, (Object)pSDEChartBase.getEmptyTextPSLanResId());
        }
        if (pSDEChartBase.isEmptyTextPSLanResNameDirty() && (bl || pSDEChartBase.getEmptyTextPSLanResName() != null)) {
            iDataObject.set(FIELD_EMPTYTEXTPSLANRESNAME, (Object)pSDEChartBase.getEmptyTextPSLanResName());
        }
        if (pSDEChartBase.isLegendPosDirty() && (bl || pSDEChartBase.getLegendPos() != null)) {
            iDataObject.set(FIELD_LEGENDPOS, (Object)pSDEChartBase.getLegendPos());
        }
        if (pSDEChartBase.isLNPSLanResIdDirty() && (bl || pSDEChartBase.getLNPSLanResId() != null)) {
            iDataObject.set(FIELD_LNPSLANRESID, (Object)pSDEChartBase.getLNPSLanResId());
        }
        if (pSDEChartBase.isLNPSLanResNameDirty() && (bl || pSDEChartBase.getLNPSLanResName() != null)) {
            iDataObject.set(FIELD_LNPSLANRESNAME, (Object)pSDEChartBase.getLNPSLanResName());
        }
        if (pSDEChartBase.isLockFlagDirty() && (bl || pSDEChartBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSDEChartBase.getLockFlag());
        }
        if (pSDEChartBase.isLogicNameDirty() && (bl || pSDEChartBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSDEChartBase.getLogicName());
        }
        if (pSDEChartBase.isMemoDirty() && (bl || pSDEChartBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEChartBase.getMemo());
        }
        if (pSDEChartBase.isMinorSortDirDirty() && (bl || pSDEChartBase.getMinorSortDir() != null)) {
            iDataObject.set(FIELD_MINORSORTDIR, (Object)pSDEChartBase.getMinorSortDir());
        }
        if (pSDEChartBase.isMinorSortPSDEFIdDirty() && (bl || pSDEChartBase.getMinorSortPSDEFId() != null)) {
            iDataObject.set(FIELD_MINORSORTPSDEFID, (Object)pSDEChartBase.getMinorSortPSDEFId());
        }
        if (pSDEChartBase.isMinorSortPSDEFNameDirty() && (bl || pSDEChartBase.getMinorSortPSDEFName() != null)) {
            iDataObject.set(FIELD_MINORSORTPSDEFNAME, (Object)pSDEChartBase.getMinorSortPSDEFName());
        }
        if (pSDEChartBase.isNavViewHeightDirty() && (bl || pSDEChartBase.getNavViewHeight() != null)) {
            iDataObject.set(FIELD_NAVVIEWHEIGHT, (Object)pSDEChartBase.getNavViewHeight());
        }
        if (pSDEChartBase.isNavViewMaxHeightDirty() && (bl || pSDEChartBase.getNavViewMaxHeight() != null)) {
            iDataObject.set(FIELD_NAVVIEWMAXHEIGHT, (Object)pSDEChartBase.getNavViewMaxHeight());
        }
        if (pSDEChartBase.isNavViewMaxWidthDirty() && (bl || pSDEChartBase.getNavViewMaxWidth() != null)) {
            iDataObject.set(FIELD_NAVVIEWMAXWIDTH, (Object)pSDEChartBase.getNavViewMaxWidth());
        }
        if (pSDEChartBase.isNavViewMinHeightDirty() && (bl || pSDEChartBase.getNavViewMinHeight() != null)) {
            iDataObject.set(FIELD_NAVVIEWMINHEIGHT, (Object)pSDEChartBase.getNavViewMinHeight());
        }
        if (pSDEChartBase.isNavViewMinWidthDirty() && (bl || pSDEChartBase.getNavViewMinWidth() != null)) {
            iDataObject.set(FIELD_NAVVIEWMINWIDTH, (Object)pSDEChartBase.getNavViewMinWidth());
        }
        if (pSDEChartBase.isNavViewPosDirty() && (bl || pSDEChartBase.getNavViewPos() != null)) {
            iDataObject.set(FIELD_NAVVIEWPOS, (Object)pSDEChartBase.getNavViewPos());
        }
        if (pSDEChartBase.isNavViewShowModeDirty() && (bl || pSDEChartBase.getNavViewShowMode() != null)) {
            iDataObject.set(FIELD_NAVVIEWSHOWMODE, (Object)pSDEChartBase.getNavViewShowMode());
        }
        if (pSDEChartBase.isNavViewWidthDirty() && (bl || pSDEChartBase.getNavViewWidth() != null)) {
            iDataObject.set(FIELD_NAVVIEWWIDTH, (Object)pSDEChartBase.getNavViewWidth());
        }
        if (pSDEChartBase.isPSACHandlerIdDirty() && (bl || pSDEChartBase.getPSACHandlerId() != null)) {
            iDataObject.set(FIELD_PSACHANDLERID, (Object)pSDEChartBase.getPSACHandlerId());
        }
        if (pSDEChartBase.isPSACHandlerNameDirty() && (bl || pSDEChartBase.getPSACHandlerName() != null)) {
            iDataObject.set(FIELD_PSACHANDLERNAME, (Object)pSDEChartBase.getPSACHandlerName());
        }
        if (pSDEChartBase.isPSCtrlLogicGroupIdDirty() && (bl || pSDEChartBase.getPSCtrlLogicGroupId() != null)) {
            iDataObject.set(FIELD_PSCTRLLOGICGROUPID, (Object)pSDEChartBase.getPSCtrlLogicGroupId());
        }
        if (pSDEChartBase.isPSCtrlLogicGroupNameDirty() && (bl || pSDEChartBase.getPSCtrlLogicGroupName() != null)) {
            iDataObject.set(FIELD_PSCTRLLOGICGROUPNAME, (Object)pSDEChartBase.getPSCtrlLogicGroupName());
        }
        if (pSDEChartBase.isPSCtrlMsgIdDirty() && (bl || pSDEChartBase.getPSCtrlMsgId() != null)) {
            iDataObject.set(FIELD_PSCTRLMSGID, (Object)pSDEChartBase.getPSCtrlMsgId());
        }
        if (pSDEChartBase.isPSCtrlMsgNameDirty() && (bl || pSDEChartBase.getPSCtrlMsgName() != null)) {
            iDataObject.set(FIELD_PSCTRLMSGNAME, (Object)pSDEChartBase.getPSCtrlMsgName());
        }
        if (pSDEChartBase.isPSDEChartIdDirty() && (bl || pSDEChartBase.getPSDEChartId() != null)) {
            iDataObject.set(FIELD_PSDECHARTID, (Object)pSDEChartBase.getPSDEChartId());
        }
        if (pSDEChartBase.isPSDEChartNameDirty() && (bl || pSDEChartBase.getPSDEChartName() != null)) {
            iDataObject.set(FIELD_PSDECHARTNAME, (Object)pSDEChartBase.getPSDEChartName());
        }
        if (pSDEChartBase.isPSDEDSIdDirty() && (bl || pSDEChartBase.getPSDEDSId() != null)) {
            iDataObject.set(FIELD_PSDEDSID, (Object)pSDEChartBase.getPSDEDSId());
        }
        if (pSDEChartBase.isPSDEDSNameDirty() && (bl || pSDEChartBase.getPSDEDSName() != null)) {
            iDataObject.set(FIELD_PSDEDSNAME, (Object)pSDEChartBase.getPSDEDSName());
        }
        if (pSDEChartBase.isPSDEIdDirty() && (bl || pSDEChartBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEChartBase.getPSDEId());
        }
        if (pSDEChartBase.isPSDENameDirty() && (bl || pSDEChartBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEChartBase.getPSDEName());
        }
        if (pSDEChartBase.isPSSysChartThemeIdDirty() && (bl || pSDEChartBase.getPSSysChartThemeId() != null)) {
            iDataObject.set(FIELD_PSSYSCHARTTHEMEID, (Object)pSDEChartBase.getPSSysChartThemeId());
        }
        if (pSDEChartBase.isPSSysChartThemeNameDirty() && (bl || pSDEChartBase.getPSSysChartThemeName() != null)) {
            iDataObject.set(FIELD_PSSYSCHARTTHEMENAME, (Object)pSDEChartBase.getPSSysChartThemeName());
        }
        if (pSDEChartBase.isPSSysCssIdDirty() && (bl || pSDEChartBase.getPSSysCssId() != null)) {
            iDataObject.set(FIELD_PSSYSCSSID, (Object)pSDEChartBase.getPSSysCssId());
        }
        if (pSDEChartBase.isPSSysCssNameDirty() && (bl || pSDEChartBase.getPSSysCssName() != null)) {
            iDataObject.set(FIELD_PSSYSCSSNAME, (Object)pSDEChartBase.getPSSysCssName());
        }
        if (pSDEChartBase.isPSSysDynaModelIdDirty() && (bl || pSDEChartBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSDEChartBase.getPSSysDynaModelId());
        }
        if (pSDEChartBase.isPSSysDynaModelNameDirty() && (bl || pSDEChartBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSDEChartBase.getPSSysDynaModelName());
        }
        if (pSDEChartBase.isPSSysPFPluginIdDirty() && (bl || pSDEChartBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSDEChartBase.getPSSysPFPluginId());
        }
        if (pSDEChartBase.isPSSysPFPluginNameDirty() && (bl || pSDEChartBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSDEChartBase.getPSSysPFPluginName());
        }
        if (pSDEChartBase.isPSSysReqItemIdDirty() && (bl || pSDEChartBase.getPSSysReqItemId() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMID, (Object)pSDEChartBase.getPSSysReqItemId());
        }
        if (pSDEChartBase.isPSSysReqItemNameDirty() && (bl || pSDEChartBase.getPSSysReqItemName() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMNAME, (Object)pSDEChartBase.getPSSysReqItemName());
        }
        if (pSDEChartBase.isPSViewMsgGroupIdDirty() && (bl || pSDEChartBase.getPSViewMsgGroupId() != null)) {
            iDataObject.set(FIELD_PSVIEWMSGGROUPID, (Object)pSDEChartBase.getPSViewMsgGroupId());
        }
        if (pSDEChartBase.isPSViewMsgGroupNameDirty() && (bl || pSDEChartBase.getPSViewMsgGroupName() != null)) {
            iDataObject.set(FIELD_PSVIEWMSGGROUPNAME, (Object)pSDEChartBase.getPSViewMsgGroupName());
        }
        if (pSDEChartBase.isShowDataGridDirty() && (bl || pSDEChartBase.getShowDataGrid() != null)) {
            iDataObject.set(FIELD_SHOWDATAGRID, (Object)pSDEChartBase.getShowDataGrid());
        }
        if (pSDEChartBase.isShowLegendDirty() && (bl || pSDEChartBase.getShowLegend() != null)) {
            iDataObject.set(FIELD_SHOWLEGEND, (Object)pSDEChartBase.getShowLegend());
        }
        if (pSDEChartBase.isShowTitleDirty() && (bl || pSDEChartBase.getShowTitle() != null)) {
            iDataObject.set(FIELD_SHOWTITLE, (Object)pSDEChartBase.getShowTitle());
        }
        if (pSDEChartBase.isSRFSysPubDirty() && (bl || pSDEChartBase.getSRFSysPub() != null)) {
            iDataObject.set(FIELD_SRFSYSPUB, (Object)pSDEChartBase.getSRFSysPub());
        }
        if (pSDEChartBase.isSubTitleDirty() && (bl || pSDEChartBase.getSubTitle() != null)) {
            iDataObject.set(FIELD_SUBTITLE, (Object)pSDEChartBase.getSubTitle());
        }
        if (pSDEChartBase.isSubTitlePSLanResIdDirty() && (bl || pSDEChartBase.getSubTitlePSLanResId() != null)) {
            iDataObject.set(FIELD_SUBTITLEPSLANRESID, (Object)pSDEChartBase.getSubTitlePSLanResId());
        }
        if (pSDEChartBase.isSubTitlePSLanResNameDirty() && (bl || pSDEChartBase.getSubTitlePSLanResName() != null)) {
            iDataObject.set(FIELD_SUBTITLEPSLANRESNAME, (Object)pSDEChartBase.getSubTitlePSLanResName());
        }
        if (pSDEChartBase.isTitlePosDirty() && (bl || pSDEChartBase.getTitlePos() != null)) {
            iDataObject.set(FIELD_TITLEPOS, (Object)pSDEChartBase.getTitlePos());
        }
        if (pSDEChartBase.isToDoTaskDirty() && (bl || pSDEChartBase.getToDoTask() != null)) {
            iDataObject.set(FIELD_TODOTASK, (Object)pSDEChartBase.getToDoTask());
        }
        if (pSDEChartBase.isUpdateDateDirty() && (bl || pSDEChartBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEChartBase.getUpdateDate());
        }
        if (pSDEChartBase.isUpdateManDirty() && (bl || pSDEChartBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEChartBase.getUpdateMan());
        }
        if (pSDEChartBase.isUserParamsDirty() && (bl || pSDEChartBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSDEChartBase.getUserParams());
        }
        if (pSDEChartBase.isUserTagDirty() && (bl || pSDEChartBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEChartBase.getUserTag());
        }
        if (pSDEChartBase.isUserTag2Dirty() && (bl || pSDEChartBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEChartBase.getUserTag2());
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
        return PSDEChartBase.remove(this, n);
    }

    private static boolean remove(PSDEChartBase pSDEChartBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEChartBase.resetADPSDELogicId();
                return true;
            }
            case 1: {
                pSDEChartBase.resetADPSDELogicName();
                return true;
            }
            case 2: {
                pSDEChartBase.resetBusyIndicator();
                return true;
            }
            case 3: {
                pSDEChartBase.resetChartModel();
                return true;
            }
            case 4: {
                pSDEChartBase.resetChartTheme();
                return true;
            }
            case 5: {
                pSDEChartBase.resetCodeName();
                return true;
            }
            case 6: {
                pSDEChartBase.resetCoordinateSystem();
                return true;
            }
            case 7: {
                pSDEChartBase.resetCreateDate();
                return true;
            }
            case 8: {
                pSDEChartBase.resetCreateMan();
                return true;
            }
            case 9: {
                pSDEChartBase.resetCustomCond();
                return true;
            }
            case 10: {
                pSDEChartBase.resetCustomType();
                return true;
            }
            case 11: {
                pSDEChartBase.resetDataGridPos();
                return true;
            }
            case 12: {
                pSDEChartBase.resetEmptyText();
                return true;
            }
            case 13: {
                pSDEChartBase.resetEmptyTextPSLanResId();
                return true;
            }
            case 14: {
                pSDEChartBase.resetEmptyTextPSLanResName();
                return true;
            }
            case 15: {
                pSDEChartBase.resetLegendPos();
                return true;
            }
            case 16: {
                pSDEChartBase.resetLNPSLanResId();
                return true;
            }
            case 17: {
                pSDEChartBase.resetLNPSLanResName();
                return true;
            }
            case 18: {
                pSDEChartBase.resetLockFlag();
                return true;
            }
            case 19: {
                pSDEChartBase.resetLogicName();
                return true;
            }
            case 20: {
                pSDEChartBase.resetMemo();
                return true;
            }
            case 21: {
                pSDEChartBase.resetMinorSortDir();
                return true;
            }
            case 22: {
                pSDEChartBase.resetMinorSortPSDEFId();
                return true;
            }
            case 23: {
                pSDEChartBase.resetMinorSortPSDEFName();
                return true;
            }
            case 24: {
                pSDEChartBase.resetNavViewHeight();
                return true;
            }
            case 25: {
                pSDEChartBase.resetNavViewMaxHeight();
                return true;
            }
            case 26: {
                pSDEChartBase.resetNavViewMaxWidth();
                return true;
            }
            case 27: {
                pSDEChartBase.resetNavViewMinHeight();
                return true;
            }
            case 28: {
                pSDEChartBase.resetNavViewMinWidth();
                return true;
            }
            case 29: {
                pSDEChartBase.resetNavViewPos();
                return true;
            }
            case 30: {
                pSDEChartBase.resetNavViewShowMode();
                return true;
            }
            case 31: {
                pSDEChartBase.resetNavViewWidth();
                return true;
            }
            case 32: {
                pSDEChartBase.resetPSACHandlerId();
                return true;
            }
            case 33: {
                pSDEChartBase.resetPSACHandlerName();
                return true;
            }
            case 34: {
                pSDEChartBase.resetPSCtrlLogicGroupId();
                return true;
            }
            case 35: {
                pSDEChartBase.resetPSCtrlLogicGroupName();
                return true;
            }
            case 36: {
                pSDEChartBase.resetPSCtrlMsgId();
                return true;
            }
            case 37: {
                pSDEChartBase.resetPSCtrlMsgName();
                return true;
            }
            case 38: {
                pSDEChartBase.resetPSDEChartId();
                return true;
            }
            case 39: {
                pSDEChartBase.resetPSDEChartName();
                return true;
            }
            case 40: {
                pSDEChartBase.resetPSDEDSId();
                return true;
            }
            case 41: {
                pSDEChartBase.resetPSDEDSName();
                return true;
            }
            case 42: {
                pSDEChartBase.resetPSDEId();
                return true;
            }
            case 43: {
                pSDEChartBase.resetPSDEName();
                return true;
            }
            case 44: {
                pSDEChartBase.resetPSSysChartThemeId();
                return true;
            }
            case 45: {
                pSDEChartBase.resetPSSysChartThemeName();
                return true;
            }
            case 46: {
                pSDEChartBase.resetPSSysCssId();
                return true;
            }
            case 47: {
                pSDEChartBase.resetPSSysCssName();
                return true;
            }
            case 48: {
                pSDEChartBase.resetPSSysDynaModelId();
                return true;
            }
            case 49: {
                pSDEChartBase.resetPSSysDynaModelName();
                return true;
            }
            case 50: {
                pSDEChartBase.resetPSSysPFPluginId();
                return true;
            }
            case 51: {
                pSDEChartBase.resetPSSysPFPluginName();
                return true;
            }
            case 52: {
                pSDEChartBase.resetPSSysReqItemId();
                return true;
            }
            case 53: {
                pSDEChartBase.resetPSSysReqItemName();
                return true;
            }
            case 54: {
                pSDEChartBase.resetPSViewMsgGroupId();
                return true;
            }
            case 55: {
                pSDEChartBase.resetPSViewMsgGroupName();
                return true;
            }
            case 56: {
                pSDEChartBase.resetShowDataGrid();
                return true;
            }
            case 57: {
                pSDEChartBase.resetShowLegend();
                return true;
            }
            case 58: {
                pSDEChartBase.resetShowTitle();
                return true;
            }
            case 59: {
                pSDEChartBase.resetSRFSysPub();
                return true;
            }
            case 60: {
                pSDEChartBase.resetSubTitle();
                return true;
            }
            case 61: {
                pSDEChartBase.resetSubTitlePSLanResId();
                return true;
            }
            case 62: {
                pSDEChartBase.resetSubTitlePSLanResName();
                return true;
            }
            case 63: {
                pSDEChartBase.resetTitlePos();
                return true;
            }
            case 64: {
                pSDEChartBase.resetToDoTask();
                return true;
            }
            case 65: {
                pSDEChartBase.resetUpdateDate();
                return true;
            }
            case 66: {
                pSDEChartBase.resetUpdateMan();
                return true;
            }
            case 67: {
                pSDEChartBase.resetUserParams();
                return true;
            }
            case 68: {
                pSDEChartBase.resetUserTag();
                return true;
            }
            case 69: {
                pSDEChartBase.resetUserTag2();
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
    public PSDEField getMinorSortPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorSortPSDEF();
        }
        if (this.getMinorSortPSDEFId() == null) {
            return null;
        }
        Integer n = this.objMinorSortPSDEFLock;
        synchronized (n) {
            if (this.minorsortpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getMinorSortPSDEFId(), (Object)this.minorsortpsdef.getPSDEFieldId()) != 0L) {
                this.minorsortpsdef = null;
            }
            if (this.minorsortpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getMinorSortPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.minorsortpsdef = pSDEField;
            }
            return this.minorsortpsdef;
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
                pSDELogicService.autoGet((IEntity)pSDELogic);
                this.adpsdelogic = pSDELogic;
            }
            return this.adpsdelogic;
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
                pSLanguageResService.autoGet((IEntity)pSLanguageRes);
                this.lnpslanres = pSLanguageRes;
            }
            return this.lnpslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getSubTitlePSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSubTitlePSLanRes();
        }
        if (this.getSubTitlePSLanResId() == null) {
            return null;
        }
        Integer n = this.objSubTitlePSLanResLock;
        synchronized (n) {
            if (this.subtitlepslanres != null && DataTypeHelper.compare((int)25, (Object)this.getSubTitlePSLanResId(), (Object)this.subtitlepslanres.getPSLanguageResId()) != 0L) {
                this.subtitlepslanres = null;
            }
            if (this.subtitlepslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getSubTitlePSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet((IEntity)pSLanguageRes);
                this.subtitlepslanres = pSLanguageRes;
            }
            return this.subtitlepslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysChartTheme getPSSysChartTheme() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysChartTheme();
        }
        if (this.getPSSysChartThemeId() == null) {
            return null;
        }
        Integer n = this.objPSSysChartThemeLock;
        synchronized (n) {
            if (this.pssyscharttheme != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysChartThemeId(), (Object)this.pssyscharttheme.getPSSysChartThemeId()) != 0L) {
                this.pssyscharttheme = null;
            }
            if (this.pssyscharttheme == null) {
                PSSysChartTheme pSSysChartTheme = new PSSysChartTheme();
                pSSysChartTheme.setPSSysChartThemeId(this.getPSSysChartThemeId());
                PSSysChartThemeService pSSysChartThemeService = (PSSysChartThemeService)ServiceGlobal.getService(PSSysChartThemeService.class, (SessionFactory)this.getSessionFactory());
                pSSysChartThemeService.autoGet((IEntity)pSSysChartTheme);
                this.pssyscharttheme = pSSysChartTheme;
            }
            return this.pssyscharttheme;
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
                pSSysDynaModelService.autoGet((IEntity)pSSysDynaModel);
                this.pssysdynamodel = pSSysDynaModel;
            }
            return this.pssysdynamodel;
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
    public ArrayList<PSDEChartAxes> getPSDEChartAxeses() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEChartAxeses();
        }
        if (this.getPSDEChartId() == null) {
            return null;
        }
        PSDEChartService pSDEChartService = (PSDEChartService)ServiceGlobal.getService(PSDEChartService.class, (SessionFactory)this.getSessionFactory());
        PSDEChartAxesService pSDEChartAxesService = (PSDEChartAxesService)ServiceGlobal.getService(PSDEChartAxesService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEChartAxesesLock;
        synchronized (n) {
            if (this.psdechartaxeses == null) {
                this.psdechartaxeses = pSDEChartService.isTempData((IEntity)this) ? pSDEChartAxesService.selectTempByPSDEChart(this) : pSDEChartAxesService.selectByPSDEChart(this);
            }
            return this.psdechartaxeses;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEChartLogic> getPSDEChartLogics() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEChartLogics();
        }
        if (this.getPSDEChartId() == null) {
            return null;
        }
        PSDEChartService pSDEChartService = (PSDEChartService)ServiceGlobal.getService(PSDEChartService.class, (SessionFactory)this.getSessionFactory());
        PSDEChartLogicService pSDEChartLogicService = (PSDEChartLogicService)ServiceGlobal.getService(PSDEChartLogicService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEChartLogicsLock;
        synchronized (n) {
            if (this.psdechartlogics == null) {
                this.psdechartlogics = pSDEChartService.isTempData((IEntity)this) ? pSDEChartLogicService.selectTempByPSDEChart(this) : pSDEChartLogicService.selectByPSDEChart(this);
            }
            return this.psdechartlogics;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEChartParam> getPSDEChartParams() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEChartParams();
        }
        if (this.getPSDEChartId() == null) {
            return null;
        }
        PSDEChartService pSDEChartService = (PSDEChartService)ServiceGlobal.getService(PSDEChartService.class, (SessionFactory)this.getSessionFactory());
        PSDEChartParamService pSDEChartParamService = (PSDEChartParamService)ServiceGlobal.getService(PSDEChartParamService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEChartParamsLock;
        synchronized (n) {
            if (this.psdechartparams == null) {
                this.psdechartparams = pSDEChartService.isTempData((IEntity)this) ? pSDEChartParamService.selectTempByPSDEChart(this) : pSDEChartParamService.selectByPSDEChart(this);
            }
            return this.psdechartparams;
        }
    }

    private PSDEChartBase getProxyEntity() {
        return this.proxyPSDEChartBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEChartBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEChartBase) {
            this.proxyPSDEChartBase = (PSDEChartBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEChartService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ADPSDELOGICID, 0);
        fieldIndexMap.put(FIELD_ADPSDELOGICNAME, 1);
        fieldIndexMap.put(FIELD_BUSYINDICATOR, 2);
        fieldIndexMap.put(FIELD_CHARTMODEL, 3);
        fieldIndexMap.put(FIELD_CHARTTHEME, 4);
        fieldIndexMap.put(FIELD_CODENAME, 5);
        fieldIndexMap.put(FIELD_COORDINATESYSTEM, 6);
        fieldIndexMap.put(FIELD_CREATEDATE, 7);
        fieldIndexMap.put(FIELD_CREATEMAN, 8);
        fieldIndexMap.put(FIELD_CUSTOMCOND, 9);
        fieldIndexMap.put(FIELD_CUSTOMTYPE, 10);
        fieldIndexMap.put(FIELD_DATAGRIDPOS, 11);
        fieldIndexMap.put(FIELD_EMPTYTEXT, 12);
        fieldIndexMap.put(FIELD_EMPTYTEXTPSLANRESID, 13);
        fieldIndexMap.put(FIELD_EMPTYTEXTPSLANRESNAME, 14);
        fieldIndexMap.put(FIELD_LEGENDPOS, 15);
        fieldIndexMap.put(FIELD_LNPSLANRESID, 16);
        fieldIndexMap.put(FIELD_LNPSLANRESNAME, 17);
        fieldIndexMap.put(FIELD_LOCKFLAG, 18);
        fieldIndexMap.put(FIELD_LOGICNAME, 19);
        fieldIndexMap.put(FIELD_MEMO, 20);
        fieldIndexMap.put(FIELD_MINORSORTDIR, 21);
        fieldIndexMap.put(FIELD_MINORSORTPSDEFID, 22);
        fieldIndexMap.put(FIELD_MINORSORTPSDEFNAME, 23);
        fieldIndexMap.put(FIELD_NAVVIEWHEIGHT, 24);
        fieldIndexMap.put(FIELD_NAVVIEWMAXHEIGHT, 25);
        fieldIndexMap.put(FIELD_NAVVIEWMAXWIDTH, 26);
        fieldIndexMap.put(FIELD_NAVVIEWMINHEIGHT, 27);
        fieldIndexMap.put(FIELD_NAVVIEWMINWIDTH, 28);
        fieldIndexMap.put(FIELD_NAVVIEWPOS, 29);
        fieldIndexMap.put(FIELD_NAVVIEWSHOWMODE, 30);
        fieldIndexMap.put(FIELD_NAVVIEWWIDTH, 31);
        fieldIndexMap.put(FIELD_PSACHANDLERID, 32);
        fieldIndexMap.put(FIELD_PSACHANDLERNAME, 33);
        fieldIndexMap.put(FIELD_PSCTRLLOGICGROUPID, 34);
        fieldIndexMap.put(FIELD_PSCTRLLOGICGROUPNAME, 35);
        fieldIndexMap.put(FIELD_PSCTRLMSGID, 36);
        fieldIndexMap.put(FIELD_PSCTRLMSGNAME, 37);
        fieldIndexMap.put(FIELD_PSDECHARTID, 38);
        fieldIndexMap.put(FIELD_PSDECHARTNAME, 39);
        fieldIndexMap.put(FIELD_PSDEDSID, 40);
        fieldIndexMap.put(FIELD_PSDEDSNAME, 41);
        fieldIndexMap.put(FIELD_PSDEID, 42);
        fieldIndexMap.put(FIELD_PSDENAME, 43);
        fieldIndexMap.put(FIELD_PSSYSCHARTTHEMEID, 44);
        fieldIndexMap.put(FIELD_PSSYSCHARTTHEMENAME, 45);
        fieldIndexMap.put(FIELD_PSSYSCSSID, 46);
        fieldIndexMap.put(FIELD_PSSYSCSSNAME, 47);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 48);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 49);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 50);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 51);
        fieldIndexMap.put(FIELD_PSSYSREQITEMID, 52);
        fieldIndexMap.put(FIELD_PSSYSREQITEMNAME, 53);
        fieldIndexMap.put(FIELD_PSVIEWMSGGROUPID, 54);
        fieldIndexMap.put(FIELD_PSVIEWMSGGROUPNAME, 55);
        fieldIndexMap.put(FIELD_SHOWDATAGRID, 56);
        fieldIndexMap.put(FIELD_SHOWLEGEND, 57);
        fieldIndexMap.put(FIELD_SHOWTITLE, 58);
        fieldIndexMap.put(FIELD_SRFSYSPUB, 59);
        fieldIndexMap.put(FIELD_SUBTITLE, 60);
        fieldIndexMap.put(FIELD_SUBTITLEPSLANRESID, 61);
        fieldIndexMap.put(FIELD_SUBTITLEPSLANRESNAME, 62);
        fieldIndexMap.put(FIELD_TITLEPOS, 63);
        fieldIndexMap.put(FIELD_TODOTASK, 64);
        fieldIndexMap.put(FIELD_UPDATEDATE, 65);
        fieldIndexMap.put(FIELD_UPDATEMAN, 66);
        fieldIndexMap.put(FIELD_USERPARAMS, 67);
        fieldIndexMap.put(FIELD_USERTAG, 68);
        fieldIndexMap.put(FIELD_USERTAG2, 69);
    }
}

