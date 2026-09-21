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
import net.ibizsys.pscore.srv.config.entity.PSPF;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.service.PSPFService;
import net.ibizsys.pscore.srv.config.service.PSSysPFPluginService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFIUpdate;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFInputTipSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormLogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFIUpdateService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFInputTipSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDEForm;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaInst;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaDEFormService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaInstService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSACHandler;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlLogicGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlMsg;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCounter;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgGroup;
import net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCtrlLogicGroupService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCtrlMsgService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCounterService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGroupService;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFDE;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFDEService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEFormBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEFormBase.class);
    public static final String FIELD_BUSYINDICATOR = "BUSYINDICATOR";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_COPYPSDEACTIONID = "COPYPSDEACTIONID";
    public static final String FIELD_COPYPSDEACTIONNAME = "COPYPSDEACTIONNAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CREATEPSDEACTIONID = "CREATEPSDEACTIONID";
    public static final String FIELD_CREATEPSDEACTIONNAME = "CREATEPSDEACTIONNAME";
    public static final String FIELD_CTRLCOLSPAN = "CTRLCOLSPAN";
    public static final String FIELD_DATATYPE = "DATATYPE";
    public static final String FIELD_DETAILSTYLE = "DETAILSTYLE";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_DYNASYSREFMODE = "DYNASYSREFMODE";
    public static final String FIELD_ENABLEADVSEARCH = "ENABLEADVSEARCH";
    public static final String FIELD_ENABLEAUTOSAVE = "ENABLEAUTOSAVE";
    public static final String FIELD_ENABLECUSTOMIZED = "ENABLECUSTOMIZED";
    public static final String FIELD_ENABLEFILTERSAVE = "ENABLEFILTERSAVE";
    public static final String FIELD_ENABLEITEMFILTER = "ENABLEITEMFILTER";
    public static final String FIELD_ENABLEITEMPRIV = "ENABLEITEMPRIV";
    public static final String FIELD_FORMITEMSTYLE = "FORMITEMSTYLE";
    public static final String FIELD_FORMMODEL = "FORMMODEL";
    public static final String FIELD_FORMNAVBAR = "FORMNAVBAR";
    public static final String FIELD_FORMSN = "FORMSN";
    public static final String FIELD_FORMSTYLE = "FORMSTYLE";
    public static final String FIELD_FORMTAG = "FORMTAG";
    public static final String FIELD_FORMTAG2 = "FORMTAG2";
    public static final String FIELD_FORMTAG3 = "FORMTAG3";
    public static final String FIELD_FORMTAG4 = "FORMTAG4";
    public static final String FIELD_FORMTYPE = "FORMTYPE";
    public static final String FIELD_FORMWIDTH = "FORMWIDTH";
    public static final String FIELD_FUNCMODE = "FUNCMODE";
    public static final String FIELD_GETDRAFTPSDEACTIONID = "GETDRAFTPSDEACTIONID";
    public static final String FIELD_GETDRAFTPSDEACTIONNAME = "GETDRAFTPSDEACTIONNAME";
    public static final String FIELD_GETPSDEACTIONID = "GETPSDEACTIONID";
    public static final String FIELD_GETPSDEACTIONNAME = "GETPSDEACTIONNAME";
    public static final String FIELD_INFOFORMFLAG = "INFOFORMFLAG";
    public static final String FIELD_LABELCOLSPAN = "LABELCOLSPAN";
    public static final String FIELD_LABELCOLSPAN2 = "LABELCOLSPAN2";
    public static final String FIELD_LABELWIDTH = "LABELWIDTH";
    public static final String FIELD_LAYOUTMODE = "LAYOUTMODE";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MOBFLAG = "MOBFLAG";
    public static final String FIELD_NAVBARHEIGHT = "NAVBARHEIGHT";
    public static final String FIELD_NAVBARPOS = "NAVBARPOS";
    public static final String FIELD_NAVBARPSSYSCSSID = "NAVBARPSSYSCSSID";
    public static final String FIELD_NAVBARPSSYSCSSNAME = "NAVBARPSSYSCSSNAME";
    public static final String FIELD_NAVBARSTYLE = "NAVBARSTYLE";
    public static final String FIELD_NAVBARWIDTH = "NAVBARWIDTH";
    public static final String FIELD_PDVTPARAM = "PDVTPARAM";
    public static final String FIELD_PSACHANDLERID = "PSACHANDLERID";
    public static final String FIELD_PSACHANDLERNAME = "PSACHANDLERNAME";
    public static final String FIELD_PSCTRLLOGICGROUPID = "PSCTRLLOGICGROUPID";
    public static final String FIELD_PSCTRLLOGICGROUPNAME = "PSCTRLLOGICGROUPNAME";
    public static final String FIELD_PSCTRLMSGID = "PSCTRLMSGID";
    public static final String FIELD_PSCTRLMSGNAME = "PSCTRLMSGNAME";
    public static final String FIELD_PSDEFINPUTTIPSETID = "PSDEFINPUTTIPSETID";
    public static final String FIELD_PSDEFINPUTTIPSETNAME = "PSDEFINPUTTIPSETNAME";
    public static final String FIELD_PSDEFORMID = "PSDEFORMID";
    public static final String FIELD_PSDEFORMNAME = "PSDEFORMNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDYNADEFORMID = "PSDYNADEFORMID";
    public static final String FIELD_PSDYNADEFORMINSTID = "PSDYNADEFORMINSTID";
    public static final String FIELD_PSDYNADEFORMINSTNAME = "PSDYNADEFORMINSTNAME";
    public static final String FIELD_PSDYNADEFORMNAME = "PSDYNADEFORMNAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSDYNAINSTNAME = "PSDYNAINSTNAME";
    public static final String FIELD_PSPFID = "PSPFID";
    public static final String FIELD_PSPFNAME = "PSPFNAME";
    public static final String FIELD_PSSYSCOUNTERID = "PSSYSCOUNTERID";
    public static final String FIELD_PSSYSCOUNTERNAME = "PSSYSCOUNTERNAME";
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
    public static final String FIELD_PSWFDEID = "PSWFDEID";
    public static final String FIELD_PSWFDENAME = "PSWFDENAME";
    public static final String FIELD_PSWFID = "PSWFID";
    public static final String FIELD_REMOVEPSDEACTIONID = "REMOVEPSDEACTIONID";
    public static final String FIELD_REMOVEPSDEACTIONNAME = "REMOVEPSDEACTIONNAME";
    public static final String FIELD_SEARCHBTNPOS = "SEARCHBTNPOS";
    public static final String FIELD_SEARCHBTNSTYLE = "SEARCHBTNSTYLE";
    public static final String FIELD_SHOWTABHEADER = "SHOWTABHEADER";
    public static final String FIELD_SRFSYSPUB = "SRFSYSPUB";
    public static final String FIELD_TABHEADERPOS = "TABHEADERPOS";
    public static final String FIELD_TODOTASK = "TODOTASK";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_UPDATEPSDEACTIONID = "UPDATEPSDEACTIONID";
    public static final String FIELD_UPDATEPSDEACTIONNAME = "UPDATEPSDEACTIONNAME";
    public static final String FIELD_USER2PSDEACTIONID = "USER2PSDEACTIONID";
    public static final String FIELD_USER2PSDEACTIONNAME = "USER2PSDEACTIONNAME";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    public static final String FIELD_USERPSDEACTIONID = "USERPSDEACTIONID";
    public static final String FIELD_USERPSDEACTIONNAME = "USERPSDEACTIONNAME";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    private static final int INDEX_BUSYINDICATOR = 0;
    private static final int INDEX_CODENAME = 1;
    private static final int INDEX_COPYPSDEACTIONID = 2;
    private static final int INDEX_COPYPSDEACTIONNAME = 3;
    private static final int INDEX_CREATEDATE = 4;
    private static final int INDEX_CREATEMAN = 5;
    private static final int INDEX_CREATEPSDEACTIONID = 6;
    private static final int INDEX_CREATEPSDEACTIONNAME = 7;
    private static final int INDEX_CTRLCOLSPAN = 8;
    private static final int INDEX_DATATYPE = 9;
    private static final int INDEX_DETAILSTYLE = 10;
    private static final int INDEX_DYNAMODELFLAG = 11;
    private static final int INDEX_DYNASYSREFMODE = 12;
    private static final int INDEX_ENABLEADVSEARCH = 13;
    private static final int INDEX_ENABLEAUTOSAVE = 14;
    private static final int INDEX_ENABLECUSTOMIZED = 15;
    private static final int INDEX_ENABLEFILTERSAVE = 16;
    private static final int INDEX_ENABLEITEMFILTER = 17;
    private static final int INDEX_ENABLEITEMPRIV = 18;
    private static final int INDEX_FORMITEMSTYLE = 19;
    private static final int INDEX_FORMMODEL = 20;
    private static final int INDEX_FORMNAVBAR = 21;
    private static final int INDEX_FORMSN = 22;
    private static final int INDEX_FORMSTYLE = 23;
    private static final int INDEX_FORMTAG = 24;
    private static final int INDEX_FORMTAG2 = 25;
    private static final int INDEX_FORMTAG3 = 26;
    private static final int INDEX_FORMTAG4 = 27;
    private static final int INDEX_FORMTYPE = 28;
    private static final int INDEX_FORMWIDTH = 29;
    private static final int INDEX_FUNCMODE = 30;
    private static final int INDEX_GETDRAFTPSDEACTIONID = 31;
    private static final int INDEX_GETDRAFTPSDEACTIONNAME = 32;
    private static final int INDEX_GETPSDEACTIONID = 33;
    private static final int INDEX_GETPSDEACTIONNAME = 34;
    private static final int INDEX_INFOFORMFLAG = 35;
    private static final int INDEX_LABELCOLSPAN = 36;
    private static final int INDEX_LABELCOLSPAN2 = 37;
    private static final int INDEX_LABELWIDTH = 38;
    private static final int INDEX_LAYOUTMODE = 39;
    private static final int INDEX_LOCKFLAG = 40;
    private static final int INDEX_MEMO = 41;
    private static final int INDEX_MOBFLAG = 42;
    private static final int INDEX_NAVBARHEIGHT = 43;
    private static final int INDEX_NAVBARPOS = 44;
    private static final int INDEX_NAVBARPSSYSCSSID = 45;
    private static final int INDEX_NAVBARPSSYSCSSNAME = 46;
    private static final int INDEX_NAVBARSTYLE = 47;
    private static final int INDEX_NAVBARWIDTH = 48;
    private static final int INDEX_PDVTPARAM = 49;
    private static final int INDEX_PSACHANDLERID = 50;
    private static final int INDEX_PSACHANDLERNAME = 51;
    private static final int INDEX_PSCTRLLOGICGROUPID = 52;
    private static final int INDEX_PSCTRLLOGICGROUPNAME = 53;
    private static final int INDEX_PSCTRLMSGID = 54;
    private static final int INDEX_PSCTRLMSGNAME = 55;
    private static final int INDEX_PSDEFINPUTTIPSETID = 56;
    private static final int INDEX_PSDEFINPUTTIPSETNAME = 57;
    private static final int INDEX_PSDEFORMID = 58;
    private static final int INDEX_PSDEFORMNAME = 59;
    private static final int INDEX_PSDEID = 60;
    private static final int INDEX_PSDENAME = 61;
    private static final int INDEX_PSDYNADEFORMID = 62;
    private static final int INDEX_PSDYNADEFORMINSTID = 63;
    private static final int INDEX_PSDYNADEFORMINSTNAME = 64;
    private static final int INDEX_PSDYNADEFORMNAME = 65;
    private static final int INDEX_PSDYNAINSTID = 66;
    private static final int INDEX_PSDYNAINSTNAME = 67;
    private static final int INDEX_PSPFID = 68;
    private static final int INDEX_PSPFNAME = 69;
    private static final int INDEX_PSSYSCOUNTERID = 70;
    private static final int INDEX_PSSYSCOUNTERNAME = 71;
    private static final int INDEX_PSSYSCSSID = 72;
    private static final int INDEX_PSSYSCSSNAME = 73;
    private static final int INDEX_PSSYSDYNAMODELID = 74;
    private static final int INDEX_PSSYSDYNAMODELNAME = 75;
    private static final int INDEX_PSSYSPFPLUGINID = 76;
    private static final int INDEX_PSSYSPFPLUGINNAME = 77;
    private static final int INDEX_PSSYSREQITEMID = 78;
    private static final int INDEX_PSSYSREQITEMNAME = 79;
    private static final int INDEX_PSVIEWMSGGROUPID = 80;
    private static final int INDEX_PSVIEWMSGGROUPNAME = 81;
    private static final int INDEX_PSWFDEID = 82;
    private static final int INDEX_PSWFDENAME = 83;
    private static final int INDEX_PSWFID = 84;
    private static final int INDEX_REMOVEPSDEACTIONID = 85;
    private static final int INDEX_REMOVEPSDEACTIONNAME = 86;
    private static final int INDEX_SEARCHBTNPOS = 87;
    private static final int INDEX_SEARCHBTNSTYLE = 88;
    private static final int INDEX_SHOWTABHEADER = 89;
    private static final int INDEX_SRFSYSPUB = 90;
    private static final int INDEX_TABHEADERPOS = 91;
    private static final int INDEX_TODOTASK = 92;
    private static final int INDEX_UPDATEDATE = 93;
    private static final int INDEX_UPDATEMAN = 94;
    private static final int INDEX_UPDATEPSDEACTIONID = 95;
    private static final int INDEX_UPDATEPSDEACTIONNAME = 96;
    private static final int INDEX_USER2PSDEACTIONID = 97;
    private static final int INDEX_USER2PSDEACTIONNAME = 98;
    private static final int INDEX_USERPARAMS = 99;
    private static final int INDEX_USERPSDEACTIONID = 100;
    private static final int INDEX_USERPSDEACTIONNAME = 101;
    private static final int INDEX_USERTAG = 102;
    private static final int INDEX_USERTAG2 = 103;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEFormBase proxyPSDEFormBase = null;
    private boolean busyindicatorDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean copypsdeactionidDirtyFlag = false;
    private boolean copypsdeactionnameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean createpsdeactionidDirtyFlag = false;
    private boolean createpsdeactionnameDirtyFlag = false;
    private boolean ctrlcolspanDirtyFlag = false;
    private boolean datatypeDirtyFlag = false;
    private boolean detailstyleDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean dynasysrefmodeDirtyFlag = false;
    private boolean enableadvsearchDirtyFlag = false;
    private boolean enableautosaveDirtyFlag = false;
    private boolean enablecustomizedDirtyFlag = false;
    private boolean enablefiltersaveDirtyFlag = false;
    private boolean enableitemfilterDirtyFlag = false;
    private boolean enableitemprivDirtyFlag = false;
    private boolean formitemstyleDirtyFlag = false;
    private boolean formmodelDirtyFlag = false;
    private boolean formnavbarDirtyFlag = false;
    private boolean formsnDirtyFlag = false;
    private boolean formstyleDirtyFlag = false;
    private boolean formtagDirtyFlag = false;
    private boolean formtag2DirtyFlag = false;
    private boolean formtag3DirtyFlag = false;
    private boolean formtag4DirtyFlag = false;
    private boolean formtypeDirtyFlag = false;
    private boolean formwidthDirtyFlag = false;
    private boolean funcmodeDirtyFlag = false;
    private boolean getdraftpsdeactionidDirtyFlag = false;
    private boolean getdraftpsdeactionnameDirtyFlag = false;
    private boolean getpsdeactionidDirtyFlag = false;
    private boolean getpsdeactionnameDirtyFlag = false;
    private boolean infoformflagDirtyFlag = false;
    private boolean labelcolspanDirtyFlag = false;
    private boolean labelcolspan2DirtyFlag = false;
    private boolean labelwidthDirtyFlag = false;
    private boolean layoutmodeDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean mobflagDirtyFlag = false;
    private boolean navbarheightDirtyFlag = false;
    private boolean navbarposDirtyFlag = false;
    private boolean navbarpssyscssidDirtyFlag = false;
    private boolean navbarpssyscssnameDirtyFlag = false;
    private boolean navbarstyleDirtyFlag = false;
    private boolean navbarwidthDirtyFlag = false;
    private boolean pdvtparamDirtyFlag = false;
    private boolean psachandleridDirtyFlag = false;
    private boolean psachandlernameDirtyFlag = false;
    private boolean psctrllogicgroupidDirtyFlag = false;
    private boolean psctrllogicgroupnameDirtyFlag = false;
    private boolean psctrlmsgidDirtyFlag = false;
    private boolean psctrlmsgnameDirtyFlag = false;
    private boolean psdefinputtipsetidDirtyFlag = false;
    private boolean psdefinputtipsetnameDirtyFlag = false;
    private boolean psdeformidDirtyFlag = false;
    private boolean psdeformnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdynadeformidDirtyFlag = false;
    private boolean psdynadeforminstidDirtyFlag = false;
    private boolean psdynadeforminstnameDirtyFlag = false;
    private boolean psdynadeformnameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean psdynainstnameDirtyFlag = false;
    private boolean pspfidDirtyFlag = false;
    private boolean pspfnameDirtyFlag = false;
    private boolean pssyscounteridDirtyFlag = false;
    private boolean pssyscounternameDirtyFlag = false;
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
    private boolean pswfdeidDirtyFlag = false;
    private boolean pswfdenameDirtyFlag = false;
    private boolean pswfidDirtyFlag = false;
    private boolean removepsdeactionidDirtyFlag = false;
    private boolean removepsdeactionnameDirtyFlag = false;
    private boolean searchbtnposDirtyFlag = false;
    private boolean searchbtnstyleDirtyFlag = false;
    private boolean showtabheaderDirtyFlag = false;
    private boolean srfsyspubDirtyFlag = false;
    private boolean tabheaderposDirtyFlag = false;
    private boolean todotaskDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean updatepsdeactionidDirtyFlag = false;
    private boolean updatepsdeactionnameDirtyFlag = false;
    private boolean user2psdeactionidDirtyFlag = false;
    private boolean user2psdeactionnameDirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    private boolean userpsdeactionidDirtyFlag = false;
    private boolean userpsdeactionnameDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    @Column(name="busyindicator")
    private Integer busyindicator;
    @Column(name="codename")
    private String codename;
    @Column(name="copypsdeactionid")
    private String copypsdeactionid;
    @Column(name="copypsdeactionname")
    private String copypsdeactionname;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="createpsdeactionid")
    private String createpsdeactionid;
    @Column(name="createpsdeactionname")
    private String createpsdeactionname;
    @Column(name="ctrlcolspan")
    private Integer ctrlcolspan;
    @Column(name="datatype")
    private String datatype;
    @Column(name="detailstyle")
    private String detailstyle;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="dynasysrefmode")
    private Integer dynasysrefmode;
    @Column(name="enableadvsearch")
    private Integer enableadvsearch;
    @Column(name="enableautosave")
    private Integer enableautosave;
    @Column(name="enablecustomized")
    private Integer enablecustomized;
    @Column(name="enablefiltersave")
    private Integer enablefiltersave;
    @Column(name="enableitemfilter")
    private Integer enableitemfilter;
    @Column(name="enableitempriv")
    private Integer enableitempriv;
    @Column(name="formitemstyle")
    private String formitemstyle;
    @Column(name="formmodel")
    private String formmodel;
    @Column(name="formnavbar")
    private Integer formnavbar;
    @Column(name="formsn")
    private String formsn;
    @Column(name="formstyle")
    private String formstyle;
    @Column(name="formtag")
    private String formtag;
    @Column(name="formtag2")
    private String formtag2;
    @Column(name="formtag3")
    private String formtag3;
    @Column(name="formtag4")
    private String formtag4;
    @Column(name="formtype")
    private String formtype;
    @Column(name="formwidth")
    private Integer formwidth;
    @Column(name="funcmode")
    private String funcmode;
    @Column(name="getdraftpsdeactionid")
    private String getdraftpsdeactionid;
    @Column(name="getdraftpsdeactionname")
    private String getdraftpsdeactionname;
    @Column(name="getpsdeactionid")
    private String getpsdeactionid;
    @Column(name="getpsdeactionname")
    private String getpsdeactionname;
    @Column(name="infoformflag")
    private Integer infoformflag;
    @Column(name="labelcolspan")
    private Integer labelcolspan;
    @Column(name="labelcolspan2")
    private Integer labelcolspan2;
    @Column(name="labelwidth")
    private Integer labelwidth;
    @Column(name="layoutmode")
    private String layoutmode;
    @Column(name="lockflag")
    private Integer lockflag;
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
    @Column(name="pdvtparam")
    private String pdvtparam;
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
    @Column(name="psdefinputtipsetid")
    private String psdefinputtipsetid;
    @Column(name="psdefinputtipsetname")
    private String psdefinputtipsetname;
    @Column(name="psdeformid")
    private String psdeformid;
    @Column(name="psdeformname")
    private String psdeformname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdynadeformid")
    private String psdynadeformid;
    @Column(name="psdynadeforminstid")
    private String psdynadeforminstid;
    @Column(name="psdynadeforminstname")
    private String psdynadeforminstname;
    @Column(name="psdynadeformname")
    private String psdynadeformname;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="psdynainstname")
    private String psdynainstname;
    @Column(name="pspfid")
    private String pspfid;
    @Column(name="pspfname")
    private String pspfname;
    @Column(name="pssyscounterid")
    private String pssyscounterid;
    @Column(name="pssyscountername")
    private String pssyscountername;
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
    @Column(name="pswfdeid")
    private String pswfdeid;
    @Column(name="pswfdename")
    private String pswfdename;
    @Column(name="pswfid")
    private String pswfid;
    @Column(name="removepsdeactionid")
    private String removepsdeactionid;
    @Column(name="removepsdeactionname")
    private String removepsdeactionname;
    @Column(name="searchbtnpos")
    private String searchbtnpos;
    @Column(name="searchbtnstyle")
    private String searchbtnstyle;
    @Column(name="showtabheader")
    private Integer showtabheader;
    @Column(name="srfsyspub")
    private Integer srfsyspub;
    @Column(name="tabheaderpos")
    private String tabheaderpos;
    @Column(name="todotask")
    private String todotask;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="updatepsdeactionid")
    private String updatepsdeactionid;
    @Column(name="updatepsdeactionname")
    private String updatepsdeactionname;
    @Column(name="user2psdeactionid")
    private String user2psdeactionid;
    @Column(name="user2psdeactionname")
    private String user2psdeactionname;
    @Column(name="userparams")
    private String userparams;
    @Column(name="userpsdeactionid")
    private String userpsdeactionid;
    @Column(name="userpsdeactionname")
    private String userpsdeactionname;
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
    private Integer objCopyPSDEActionLock = new Integer(1);
    private PSDEAction copypsdeaction = null;
    private Integer objCreatePSDEActionLock = new Integer(1);
    private PSDEAction createpsdeaction = null;
    private Integer objGetDraftPSDEActionLock = new Integer(1);
    private PSDEAction getdraftpsdeaction = null;
    private Integer objGetPSDEActionLock = new Integer(1);
    private PSDEAction getpsdeaction = null;
    private Integer objRemovePSDEActionLock = new Integer(1);
    private PSDEAction removepsdeaction = null;
    private Integer objUpdatePSDEActionLock = new Integer(1);
    private PSDEAction updatepsdeaction = null;
    private Integer objUser2PSDEActionLock = new Integer(1);
    private PSDEAction user2psdeaction = null;
    private Integer objUserPSDEActionLock = new Integer(1);
    private PSDEAction userpsdeaction = null;
    private Integer objPSDEFInputTipSetLock = new Integer(1);
    private PSDEFInputTipSet psdefinputtipset = null;
    private Integer objPSDynaDEFormLock = new Integer(1);
    private PSDynaDEForm psdynadeform = null;
    private Integer objPSDynaInstLock = new Integer(1);
    private PSDynaInst psdynainst = null;
    private Integer objPSPFLock = new Integer(1);
    private PSPF pspf = null;
    private Integer objPSSysCounterLock = new Integer(1);
    private PSSysCounter pssyscounter = null;
    private Integer objNavBarPSSysCssLock = new Integer(1);
    private PSSysCss navbarpssyscss = null;
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
    private Integer objPSWFDELock = new Integer(1);
    private PSWFDE pswfde = null;
    private Integer objPSDEFIUpdatesLock = new Integer(1);
    private ArrayList<PSDEFIUpdate> psdefiupdates = null;
    private Integer objPSDEFormDetailsLock = new Integer(1);
    private ArrayList<PSDEFormDetail> psdeformdetails = null;
    private Integer objPSDEFormLogicsLock = new Integer(1);
    private ArrayList<PSDEFormLogic> psdeformlogics = null;

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

    public void setCopyPSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCopyPSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.copypsdeactionid = string;
        this.copypsdeactionidDirtyFlag = true;
    }

    public String getCopyPSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCopyPSDEActionId();
        }
        return this.copypsdeactionid;
    }

    public boolean isCopyPSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCopyPSDEActionIdDirty();
        }
        return this.copypsdeactionidDirtyFlag;
    }

    public void resetCopyPSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCopyPSDEActionId();
            return;
        }
        this.copypsdeactionidDirtyFlag = false;
        this.copypsdeactionid = null;
    }

    public void setCopyPSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCopyPSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.copypsdeactionname = string;
        this.copypsdeactionnameDirtyFlag = true;
    }

    public String getCopyPSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCopyPSDEActionName();
        }
        return this.copypsdeactionname;
    }

    public boolean isCopyPSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCopyPSDEActionNameDirty();
        }
        return this.copypsdeactionnameDirtyFlag;
    }

    public void resetCopyPSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCopyPSDEActionName();
            return;
        }
        this.copypsdeactionnameDirtyFlag = false;
        this.copypsdeactionname = null;
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

    public void setCreatePSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreatePSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.createpsdeactionid = string;
        this.createpsdeactionidDirtyFlag = true;
    }

    public String getCreatePSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreatePSDEActionId();
        }
        return this.createpsdeactionid;
    }

    public boolean isCreatePSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreatePSDEActionIdDirty();
        }
        return this.createpsdeactionidDirtyFlag;
    }

    public void resetCreatePSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreatePSDEActionId();
            return;
        }
        this.createpsdeactionidDirtyFlag = false;
        this.createpsdeactionid = null;
    }

    public void setCreatePSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreatePSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.createpsdeactionname = string;
        this.createpsdeactionnameDirtyFlag = true;
    }

    public String getCreatePSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreatePSDEActionName();
        }
        return this.createpsdeactionname;
    }

    public boolean isCreatePSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreatePSDEActionNameDirty();
        }
        return this.createpsdeactionnameDirtyFlag;
    }

    public void resetCreatePSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreatePSDEActionName();
            return;
        }
        this.createpsdeactionnameDirtyFlag = false;
        this.createpsdeactionname = null;
    }

    public void setCtrlColSpan(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlColSpan(n);
            return;
        }
        this.ctrlcolspan = n;
        this.ctrlcolspanDirtyFlag = true;
    }

    public Integer getCtrlColSpan() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlColSpan();
        }
        return this.ctrlcolspan;
    }

    public boolean isCtrlColSpanDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlColSpanDirty();
        }
        return this.ctrlcolspanDirtyFlag;
    }

    public void resetCtrlColSpan() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlColSpan();
            return;
        }
        this.ctrlcolspanDirtyFlag = false;
        this.ctrlcolspan = null;
    }

    public void setDataType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.datatype = string;
        this.datatypeDirtyFlag = true;
    }

    public String getDataType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataType();
        }
        return this.datatype;
    }

    public boolean isDataTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataTypeDirty();
        }
        return this.datatypeDirtyFlag;
    }

    public void resetDataType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataType();
            return;
        }
        this.datatypeDirtyFlag = false;
        this.datatype = null;
    }

    public void setDetailStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDetailStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.detailstyle = string;
        this.detailstyleDirtyFlag = true;
    }

    public String getDetailStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDetailStyle();
        }
        return this.detailstyle;
    }

    public boolean isDetailStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDetailStyleDirty();
        }
        return this.detailstyleDirtyFlag;
    }

    public void resetDetailStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDetailStyle();
            return;
        }
        this.detailstyleDirtyFlag = false;
        this.detailstyle = null;
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

    public void setDynaSysRefMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaSysRefMode(n);
            return;
        }
        this.dynasysrefmode = n;
        this.dynasysrefmodeDirtyFlag = true;
    }

    public Integer getDynaSysRefMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaSysRefMode();
        }
        return this.dynasysrefmode;
    }

    public boolean isDynaSysRefModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaSysRefModeDirty();
        }
        return this.dynasysrefmodeDirtyFlag;
    }

    public void resetDynaSysRefMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaSysRefMode();
            return;
        }
        this.dynasysrefmodeDirtyFlag = false;
        this.dynasysrefmode = null;
    }

    public void setEnableAdvSearch(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableAdvSearch(n);
            return;
        }
        this.enableadvsearch = n;
        this.enableadvsearchDirtyFlag = true;
    }

    public Integer getEnableAdvSearch() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableAdvSearch();
        }
        return this.enableadvsearch;
    }

    public boolean isEnableAdvSearchDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableAdvSearchDirty();
        }
        return this.enableadvsearchDirtyFlag;
    }

    public void resetEnableAdvSearch() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableAdvSearch();
            return;
        }
        this.enableadvsearchDirtyFlag = false;
        this.enableadvsearch = null;
    }

    public void setEnableAutoSave(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableAutoSave(n);
            return;
        }
        this.enableautosave = n;
        this.enableautosaveDirtyFlag = true;
    }

    public Integer getEnableAutoSave() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableAutoSave();
        }
        return this.enableautosave;
    }

    public boolean isEnableAutoSaveDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableAutoSaveDirty();
        }
        return this.enableautosaveDirtyFlag;
    }

    public void resetEnableAutoSave() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableAutoSave();
            return;
        }
        this.enableautosaveDirtyFlag = false;
        this.enableautosave = null;
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

    public void setEnableFilterSave(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableFilterSave(n);
            return;
        }
        this.enablefiltersave = n;
        this.enablefiltersaveDirtyFlag = true;
    }

    public Integer getEnableFilterSave() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableFilterSave();
        }
        return this.enablefiltersave;
    }

    public boolean isEnableFilterSaveDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableFilterSaveDirty();
        }
        return this.enablefiltersaveDirtyFlag;
    }

    public void resetEnableFilterSave() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableFilterSave();
            return;
        }
        this.enablefiltersaveDirtyFlag = false;
        this.enablefiltersave = null;
    }

    public void setEnableItemFilter(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableItemFilter(n);
            return;
        }
        this.enableitemfilter = n;
        this.enableitemfilterDirtyFlag = true;
    }

    public Integer getEnableItemFilter() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableItemFilter();
        }
        return this.enableitemfilter;
    }

    public boolean isEnableItemFilterDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableItemFilterDirty();
        }
        return this.enableitemfilterDirtyFlag;
    }

    public void resetEnableItemFilter() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableItemFilter();
            return;
        }
        this.enableitemfilterDirtyFlag = false;
        this.enableitemfilter = null;
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

    public void setFormItemStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFormItemStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.formitemstyle = string;
        this.formitemstyleDirtyFlag = true;
    }

    public String getFormItemStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFormItemStyle();
        }
        return this.formitemstyle;
    }

    public boolean isFormItemStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFormItemStyleDirty();
        }
        return this.formitemstyleDirtyFlag;
    }

    public void resetFormItemStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFormItemStyle();
            return;
        }
        this.formitemstyleDirtyFlag = false;
        this.formitemstyle = null;
    }

    public void setFormModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFormModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.formmodel = string;
        this.formmodelDirtyFlag = true;
    }

    public String getFormModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFormModel();
        }
        return this.formmodel;
    }

    public boolean isFormModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFormModelDirty();
        }
        return this.formmodelDirtyFlag;
    }

    public void resetFormModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFormModel();
            return;
        }
        this.formmodelDirtyFlag = false;
        this.formmodel = null;
    }

    public void setFormNavBar(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFormNavBar(n);
            return;
        }
        this.formnavbar = n;
        this.formnavbarDirtyFlag = true;
    }

    public Integer getFormNavBar() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFormNavBar();
        }
        return this.formnavbar;
    }

    public boolean isFormNavBarDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFormNavBarDirty();
        }
        return this.formnavbarDirtyFlag;
    }

    public void resetFormNavBar() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFormNavBar();
            return;
        }
        this.formnavbarDirtyFlag = false;
        this.formnavbar = null;
    }

    public void setFormSN(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFormSN(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.formsn = string;
        this.formsnDirtyFlag = true;
    }

    public String getFormSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFormSN();
        }
        return this.formsn;
    }

    public boolean isFormSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFormSNDirty();
        }
        return this.formsnDirtyFlag;
    }

    public void resetFormSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFormSN();
            return;
        }
        this.formsnDirtyFlag = false;
        this.formsn = null;
    }

    public void setFormStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFormStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.formstyle = string;
        this.formstyleDirtyFlag = true;
    }

    public String getFormStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFormStyle();
        }
        return this.formstyle;
    }

    public boolean isFormStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFormStyleDirty();
        }
        return this.formstyleDirtyFlag;
    }

    public void resetFormStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFormStyle();
            return;
        }
        this.formstyleDirtyFlag = false;
        this.formstyle = null;
    }

    public void setFormTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFormTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.formtag = string;
        this.formtagDirtyFlag = true;
    }

    public String getFormTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFormTag();
        }
        return this.formtag;
    }

    public boolean isFormTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFormTagDirty();
        }
        return this.formtagDirtyFlag;
    }

    public void resetFormTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFormTag();
            return;
        }
        this.formtagDirtyFlag = false;
        this.formtag = null;
    }

    public void setFormTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFormTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.formtag2 = string;
        this.formtag2DirtyFlag = true;
    }

    public String getFormTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFormTag2();
        }
        return this.formtag2;
    }

    public boolean isFormTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFormTag2Dirty();
        }
        return this.formtag2DirtyFlag;
    }

    public void resetFormTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFormTag2();
            return;
        }
        this.formtag2DirtyFlag = false;
        this.formtag2 = null;
    }

    public void setFormTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFormTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.formtag3 = string;
        this.formtag3DirtyFlag = true;
    }

    public String getFormTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFormTag3();
        }
        return this.formtag3;
    }

    public boolean isFormTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFormTag3Dirty();
        }
        return this.formtag3DirtyFlag;
    }

    public void resetFormTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFormTag3();
            return;
        }
        this.formtag3DirtyFlag = false;
        this.formtag3 = null;
    }

    public void setFormTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFormTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.formtag4 = string;
        this.formtag4DirtyFlag = true;
    }

    public String getFormTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFormTag4();
        }
        return this.formtag4;
    }

    public boolean isFormTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFormTag4Dirty();
        }
        return this.formtag4DirtyFlag;
    }

    public void resetFormTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFormTag4();
            return;
        }
        this.formtag4DirtyFlag = false;
        this.formtag4 = null;
    }

    public void setFormType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFormType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.formtype = string;
        this.formtypeDirtyFlag = true;
    }

    public String getFormType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFormType();
        }
        return this.formtype;
    }

    public boolean isFormTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFormTypeDirty();
        }
        return this.formtypeDirtyFlag;
    }

    public void resetFormType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFormType();
            return;
        }
        this.formtypeDirtyFlag = false;
        this.formtype = null;
    }

    public void setFormWidth(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFormWidth(n);
            return;
        }
        this.formwidth = n;
        this.formwidthDirtyFlag = true;
    }

    public Integer getFormWidth() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFormWidth();
        }
        return this.formwidth;
    }

    public boolean isFormWidthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFormWidthDirty();
        }
        return this.formwidthDirtyFlag;
    }

    public void resetFormWidth() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFormWidth();
            return;
        }
        this.formwidthDirtyFlag = false;
        this.formwidth = null;
    }

    public void setFuncMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFuncMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.funcmode = string;
        this.funcmodeDirtyFlag = true;
    }

    public String getFuncMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFuncMode();
        }
        return this.funcmode;
    }

    public boolean isFuncModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFuncModeDirty();
        }
        return this.funcmodeDirtyFlag;
    }

    public void resetFuncMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFuncMode();
            return;
        }
        this.funcmodeDirtyFlag = false;
        this.funcmode = null;
    }

    public void setGetDraftPSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGetDraftPSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.getdraftpsdeactionid = string;
        this.getdraftpsdeactionidDirtyFlag = true;
    }

    public String getGetDraftPSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGetDraftPSDEActionId();
        }
        return this.getdraftpsdeactionid;
    }

    public boolean isGetDraftPSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGetDraftPSDEActionIdDirty();
        }
        return this.getdraftpsdeactionidDirtyFlag;
    }

    public void resetGetDraftPSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGetDraftPSDEActionId();
            return;
        }
        this.getdraftpsdeactionidDirtyFlag = false;
        this.getdraftpsdeactionid = null;
    }

    public void setGetDraftPSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGetDraftPSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.getdraftpsdeactionname = string;
        this.getdraftpsdeactionnameDirtyFlag = true;
    }

    public String getGetDraftPSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGetDraftPSDEActionName();
        }
        return this.getdraftpsdeactionname;
    }

    public boolean isGetDraftPSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGetDraftPSDEActionNameDirty();
        }
        return this.getdraftpsdeactionnameDirtyFlag;
    }

    public void resetGetDraftPSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGetDraftPSDEActionName();
            return;
        }
        this.getdraftpsdeactionnameDirtyFlag = false;
        this.getdraftpsdeactionname = null;
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

    public void setInfoFormFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInfoFormFlag(n);
            return;
        }
        this.infoformflag = n;
        this.infoformflagDirtyFlag = true;
    }

    public Integer getInfoFormFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInfoFormFlag();
        }
        return this.infoformflag;
    }

    public boolean isInfoFormFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInfoFormFlagDirty();
        }
        return this.infoformflagDirtyFlag;
    }

    public void resetInfoFormFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInfoFormFlag();
            return;
        }
        this.infoformflagDirtyFlag = false;
        this.infoformflag = null;
    }

    public void setLabelColSpan(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLabelColSpan(n);
            return;
        }
        this.labelcolspan = n;
        this.labelcolspanDirtyFlag = true;
    }

    public Integer getLabelColSpan() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLabelColSpan();
        }
        return this.labelcolspan;
    }

    public boolean isLabelColSpanDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLabelColSpanDirty();
        }
        return this.labelcolspanDirtyFlag;
    }

    public void resetLabelColSpan() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLabelColSpan();
            return;
        }
        this.labelcolspanDirtyFlag = false;
        this.labelcolspan = null;
    }

    public void setLabelColSpan2(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLabelColSpan2(n);
            return;
        }
        this.labelcolspan2 = n;
        this.labelcolspan2DirtyFlag = true;
    }

    public Integer getLabelColSpan2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLabelColSpan2();
        }
        return this.labelcolspan2;
    }

    public boolean isLabelColSpan2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLabelColSpan2Dirty();
        }
        return this.labelcolspan2DirtyFlag;
    }

    public void resetLabelColSpan2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLabelColSpan2();
            return;
        }
        this.labelcolspan2DirtyFlag = false;
        this.labelcolspan2 = null;
    }

    public void setLabelWidth(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLabelWidth(n);
            return;
        }
        this.labelwidth = n;
        this.labelwidthDirtyFlag = true;
    }

    public Integer getLabelWidth() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLabelWidth();
        }
        return this.labelwidth;
    }

    public boolean isLabelWidthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLabelWidthDirty();
        }
        return this.labelwidthDirtyFlag;
    }

    public void resetLabelWidth() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLabelWidth();
            return;
        }
        this.labelwidthDirtyFlag = false;
        this.labelwidth = null;
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

    public void setPDVTParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPDVTParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pdvtparam = string;
        this.pdvtparamDirtyFlag = true;
    }

    public String getPDVTParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPDVTParam();
        }
        return this.pdvtparam;
    }

    public boolean isPDVTParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPDVTParamDirty();
        }
        return this.pdvtparamDirtyFlag;
    }

    public void resetPDVTParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPDVTParam();
            return;
        }
        this.pdvtparamDirtyFlag = false;
        this.pdvtparam = null;
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

    public void setPSDynaDEFormId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaDEFormId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynadeformid = string;
        this.psdynadeformidDirtyFlag = true;
    }

    public String getPSDynaDEFormId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaDEFormId();
        }
        return this.psdynadeformid;
    }

    public boolean isPSDynaDEFormIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaDEFormIdDirty();
        }
        return this.psdynadeformidDirtyFlag;
    }

    public void resetPSDynaDEFormId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaDEFormId();
            return;
        }
        this.psdynadeformidDirtyFlag = false;
        this.psdynadeformid = null;
    }

    public void setPSDynaDEFormInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaDEFormInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynadeforminstid = string;
        this.psdynadeforminstidDirtyFlag = true;
    }

    public String getPSDynaDEFormInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaDEFormInstId();
        }
        return this.psdynadeforminstid;
    }

    public boolean isPSDynaDEFormInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaDEFormInstIdDirty();
        }
        return this.psdynadeforminstidDirtyFlag;
    }

    public void resetPSDynaDEFormInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaDEFormInstId();
            return;
        }
        this.psdynadeforminstidDirtyFlag = false;
        this.psdynadeforminstid = null;
    }

    public void setPSDynaDEFormInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaDEFormInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynadeforminstname = string;
        this.psdynadeforminstnameDirtyFlag = true;
    }

    public String getPSDynaDEFormInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaDEFormInstName();
        }
        return this.psdynadeforminstname;
    }

    public boolean isPSDynaDEFormInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaDEFormInstNameDirty();
        }
        return this.psdynadeforminstnameDirtyFlag;
    }

    public void resetPSDynaDEFormInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaDEFormInstName();
            return;
        }
        this.psdynadeforminstnameDirtyFlag = false;
        this.psdynadeforminstname = null;
    }

    public void setPSDynaDEFormName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaDEFormName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynadeformname = string;
        this.psdynadeformnameDirtyFlag = true;
    }

    public String getPSDynaDEFormName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaDEFormName();
        }
        return this.psdynadeformname;
    }

    public boolean isPSDynaDEFormNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaDEFormNameDirty();
        }
        return this.psdynadeformnameDirtyFlag;
    }

    public void resetPSDynaDEFormName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaDEFormName();
            return;
        }
        this.psdynadeformnameDirtyFlag = false;
        this.psdynadeformname = null;
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

    public void setPSDynaInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynainstname = string;
        this.psdynainstnameDirtyFlag = true;
    }

    public String getPSDynaInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaInstName();
        }
        return this.psdynainstname;
    }

    public boolean isPSDynaInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaInstNameDirty();
        }
        return this.psdynainstnameDirtyFlag;
    }

    public void resetPSDynaInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaInstName();
            return;
        }
        this.psdynainstnameDirtyFlag = false;
        this.psdynainstname = null;
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

    public void setPSWFDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfdeid = string;
        this.pswfdeidDirtyFlag = true;
    }

    public String getPSWFDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFDEId();
        }
        return this.pswfdeid;
    }

    public boolean isPSWFDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFDEIdDirty();
        }
        return this.pswfdeidDirtyFlag;
    }

    public void resetPSWFDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFDEId();
            return;
        }
        this.pswfdeidDirtyFlag = false;
        this.pswfdeid = null;
    }

    public void setPSWFDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfdename = string;
        this.pswfdenameDirtyFlag = true;
    }

    public String getPSWFDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFDEName();
        }
        return this.pswfdename;
    }

    public boolean isPSWFDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFDENameDirty();
        }
        return this.pswfdenameDirtyFlag;
    }

    public void resetPSWFDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFDEName();
            return;
        }
        this.pswfdenameDirtyFlag = false;
        this.pswfdename = null;
    }

    public void setPSWFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfid = string;
        this.pswfidDirtyFlag = true;
    }

    public String getPSWFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFId();
        }
        return this.pswfid;
    }

    public boolean isPSWFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFIdDirty();
        }
        return this.pswfidDirtyFlag;
    }

    public void resetPSWFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFId();
            return;
        }
        this.pswfidDirtyFlag = false;
        this.pswfid = null;
    }

    public void setRemovePSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRemovePSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.removepsdeactionid = string;
        this.removepsdeactionidDirtyFlag = true;
    }

    public String getRemovePSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRemovePSDEActionId();
        }
        return this.removepsdeactionid;
    }

    public boolean isRemovePSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRemovePSDEActionIdDirty();
        }
        return this.removepsdeactionidDirtyFlag;
    }

    public void resetRemovePSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRemovePSDEActionId();
            return;
        }
        this.removepsdeactionidDirtyFlag = false;
        this.removepsdeactionid = null;
    }

    public void setRemovePSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRemovePSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.removepsdeactionname = string;
        this.removepsdeactionnameDirtyFlag = true;
    }

    public String getRemovePSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRemovePSDEActionName();
        }
        return this.removepsdeactionname;
    }

    public boolean isRemovePSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRemovePSDEActionNameDirty();
        }
        return this.removepsdeactionnameDirtyFlag;
    }

    public void resetRemovePSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRemovePSDEActionName();
            return;
        }
        this.removepsdeactionnameDirtyFlag = false;
        this.removepsdeactionname = null;
    }

    public void setSearchBtnPos(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSearchBtnPos(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.searchbtnpos = string;
        this.searchbtnposDirtyFlag = true;
    }

    public String getSearchBtnPos() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSearchBtnPos();
        }
        return this.searchbtnpos;
    }

    public boolean isSearchBtnPosDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSearchBtnPosDirty();
        }
        return this.searchbtnposDirtyFlag;
    }

    public void resetSearchBtnPos() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSearchBtnPos();
            return;
        }
        this.searchbtnposDirtyFlag = false;
        this.searchbtnpos = null;
    }

    public void setSearchBtnStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSearchBtnStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.searchbtnstyle = string;
        this.searchbtnstyleDirtyFlag = true;
    }

    public String getSearchBtnStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSearchBtnStyle();
        }
        return this.searchbtnstyle;
    }

    public boolean isSearchBtnStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSearchBtnStyleDirty();
        }
        return this.searchbtnstyleDirtyFlag;
    }

    public void resetSearchBtnStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSearchBtnStyle();
            return;
        }
        this.searchbtnstyleDirtyFlag = false;
        this.searchbtnstyle = null;
    }

    public void setShowTabHeader(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setShowTabHeader(n);
            return;
        }
        this.showtabheader = n;
        this.showtabheaderDirtyFlag = true;
    }

    public Integer getShowTabHeader() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getShowTabHeader();
        }
        return this.showtabheader;
    }

    public boolean isShowTabHeaderDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isShowTabHeaderDirty();
        }
        return this.showtabheaderDirtyFlag;
    }

    public void resetShowTabHeader() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetShowTabHeader();
            return;
        }
        this.showtabheaderDirtyFlag = false;
        this.showtabheader = null;
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

    public void setTabHeaderPos(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTabHeaderPos(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tabheaderpos = string;
        this.tabheaderposDirtyFlag = true;
    }

    public String getTabHeaderPos() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTabHeaderPos();
        }
        return this.tabheaderpos;
    }

    public boolean isTabHeaderPosDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTabHeaderPosDirty();
        }
        return this.tabheaderposDirtyFlag;
    }

    public void resetTabHeaderPos() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTabHeaderPos();
            return;
        }
        this.tabheaderposDirtyFlag = false;
        this.tabheaderpos = null;
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

    public void setUpdatePSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdatePSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.updatepsdeactionid = string;
        this.updatepsdeactionidDirtyFlag = true;
    }

    public String getUpdatePSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdatePSDEActionId();
        }
        return this.updatepsdeactionid;
    }

    public boolean isUpdatePSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdatePSDEActionIdDirty();
        }
        return this.updatepsdeactionidDirtyFlag;
    }

    public void resetUpdatePSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdatePSDEActionId();
            return;
        }
        this.updatepsdeactionidDirtyFlag = false;
        this.updatepsdeactionid = null;
    }

    public void setUpdatePSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdatePSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.updatepsdeactionname = string;
        this.updatepsdeactionnameDirtyFlag = true;
    }

    public String getUpdatePSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdatePSDEActionName();
        }
        return this.updatepsdeactionname;
    }

    public boolean isUpdatePSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdatePSDEActionNameDirty();
        }
        return this.updatepsdeactionnameDirtyFlag;
    }

    public void resetUpdatePSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdatePSDEActionName();
            return;
        }
        this.updatepsdeactionnameDirtyFlag = false;
        this.updatepsdeactionname = null;
    }

    public void setUser2PSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUser2PSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.user2psdeactionid = string;
        this.user2psdeactionidDirtyFlag = true;
    }

    public String getUser2PSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUser2PSDEActionId();
        }
        return this.user2psdeactionid;
    }

    public boolean isUser2PSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUser2PSDEActionIdDirty();
        }
        return this.user2psdeactionidDirtyFlag;
    }

    public void resetUser2PSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUser2PSDEActionId();
            return;
        }
        this.user2psdeactionidDirtyFlag = false;
        this.user2psdeactionid = null;
    }

    public void setUser2PSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUser2PSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.user2psdeactionname = string;
        this.user2psdeactionnameDirtyFlag = true;
    }

    public String getUser2PSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUser2PSDEActionName();
        }
        return this.user2psdeactionname;
    }

    public boolean isUser2PSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUser2PSDEActionNameDirty();
        }
        return this.user2psdeactionnameDirtyFlag;
    }

    public void resetUser2PSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUser2PSDEActionName();
            return;
        }
        this.user2psdeactionnameDirtyFlag = false;
        this.user2psdeactionname = null;
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

    public void setUserPSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserPSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userpsdeactionid = string;
        this.userpsdeactionidDirtyFlag = true;
    }

    public String getUserPSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserPSDEActionId();
        }
        return this.userpsdeactionid;
    }

    public boolean isUserPSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserPSDEActionIdDirty();
        }
        return this.userpsdeactionidDirtyFlag;
    }

    public void resetUserPSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserPSDEActionId();
            return;
        }
        this.userpsdeactionidDirtyFlag = false;
        this.userpsdeactionid = null;
    }

    public void setUserPSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserPSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userpsdeactionname = string;
        this.userpsdeactionnameDirtyFlag = true;
    }

    public String getUserPSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserPSDEActionName();
        }
        return this.userpsdeactionname;
    }

    public boolean isUserPSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserPSDEActionNameDirty();
        }
        return this.userpsdeactionnameDirtyFlag;
    }

    public void resetUserPSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserPSDEActionName();
            return;
        }
        this.userpsdeactionnameDirtyFlag = false;
        this.userpsdeactionname = null;
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
        PSDEFormBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEFormBase pSDEFormBase) {
        pSDEFormBase.resetBusyIndicator();
        pSDEFormBase.resetCodeName();
        pSDEFormBase.resetCopyPSDEActionId();
        pSDEFormBase.resetCopyPSDEActionName();
        pSDEFormBase.resetCreateDate();
        pSDEFormBase.resetCreateMan();
        pSDEFormBase.resetCreatePSDEActionId();
        pSDEFormBase.resetCreatePSDEActionName();
        pSDEFormBase.resetCtrlColSpan();
        pSDEFormBase.resetDataType();
        pSDEFormBase.resetDetailStyle();
        pSDEFormBase.resetDynaModelFlag();
        pSDEFormBase.resetDynaSysRefMode();
        pSDEFormBase.resetEnableAdvSearch();
        pSDEFormBase.resetEnableAutoSave();
        pSDEFormBase.resetEnableCustomized();
        pSDEFormBase.resetEnableFilterSave();
        pSDEFormBase.resetEnableItemFilter();
        pSDEFormBase.resetEnableItemPriv();
        pSDEFormBase.resetFormItemStyle();
        pSDEFormBase.resetFormModel();
        pSDEFormBase.resetFormNavBar();
        pSDEFormBase.resetFormSN();
        pSDEFormBase.resetFormStyle();
        pSDEFormBase.resetFormTag();
        pSDEFormBase.resetFormTag2();
        pSDEFormBase.resetFormTag3();
        pSDEFormBase.resetFormTag4();
        pSDEFormBase.resetFormType();
        pSDEFormBase.resetFormWidth();
        pSDEFormBase.resetFuncMode();
        pSDEFormBase.resetGetDraftPSDEActionId();
        pSDEFormBase.resetGetDraftPSDEActionName();
        pSDEFormBase.resetGetPSDEActionId();
        pSDEFormBase.resetGetPSDEActionName();
        pSDEFormBase.resetInfoFormFlag();
        pSDEFormBase.resetLabelColSpan();
        pSDEFormBase.resetLabelColSpan2();
        pSDEFormBase.resetLabelWidth();
        pSDEFormBase.resetLayoutMode();
        pSDEFormBase.resetLockFlag();
        pSDEFormBase.resetMemo();
        pSDEFormBase.resetMobFlag();
        pSDEFormBase.resetNavBarHeight();
        pSDEFormBase.resetNavBarPos();
        pSDEFormBase.resetNavBarPSSysCssId();
        pSDEFormBase.resetNavBarPSSysCssName();
        pSDEFormBase.resetNavBarStyle();
        pSDEFormBase.resetNavBarWidth();
        pSDEFormBase.resetPDVTParam();
        pSDEFormBase.resetPSACHandlerId();
        pSDEFormBase.resetPSACHandlerName();
        pSDEFormBase.resetPSCtrlLogicGroupId();
        pSDEFormBase.resetPSCtrlLogicGroupName();
        pSDEFormBase.resetPSCtrlMsgId();
        pSDEFormBase.resetPSCtrlMsgName();
        pSDEFormBase.resetPSDEFInputTipSetId();
        pSDEFormBase.resetPSDEFInputTipSetName();
        pSDEFormBase.resetPSDEFormId();
        pSDEFormBase.resetPSDEFormName();
        pSDEFormBase.resetPSDEId();
        pSDEFormBase.resetPSDEName();
        pSDEFormBase.resetPSDynaDEFormId();
        pSDEFormBase.resetPSDynaDEFormInstId();
        pSDEFormBase.resetPSDynaDEFormInstName();
        pSDEFormBase.resetPSDynaDEFormName();
        pSDEFormBase.resetPSDynaInstId();
        pSDEFormBase.resetPSDynaInstName();
        pSDEFormBase.resetPSPFId();
        pSDEFormBase.resetPSPFName();
        pSDEFormBase.resetPSSysCounterId();
        pSDEFormBase.resetPSSysCounterName();
        pSDEFormBase.resetPSSysCssId();
        pSDEFormBase.resetPSSysCssName();
        pSDEFormBase.resetPSSysDynaModelId();
        pSDEFormBase.resetPSSysDynaModelName();
        pSDEFormBase.resetPSSysPFPluginId();
        pSDEFormBase.resetPSSysPFPluginName();
        pSDEFormBase.resetPSSysReqItemId();
        pSDEFormBase.resetPSSysReqItemName();
        pSDEFormBase.resetPSViewMsgGroupId();
        pSDEFormBase.resetPSViewMsgGroupName();
        pSDEFormBase.resetPSWFDEId();
        pSDEFormBase.resetPSWFDEName();
        pSDEFormBase.resetPSWFId();
        pSDEFormBase.resetRemovePSDEActionId();
        pSDEFormBase.resetRemovePSDEActionName();
        pSDEFormBase.resetSearchBtnPos();
        pSDEFormBase.resetSearchBtnStyle();
        pSDEFormBase.resetShowTabHeader();
        pSDEFormBase.resetSRFSysPub();
        pSDEFormBase.resetTabHeaderPos();
        pSDEFormBase.resetToDoTask();
        pSDEFormBase.resetUpdateDate();
        pSDEFormBase.resetUpdateMan();
        pSDEFormBase.resetUpdatePSDEActionId();
        pSDEFormBase.resetUpdatePSDEActionName();
        pSDEFormBase.resetUser2PSDEActionId();
        pSDEFormBase.resetUser2PSDEActionName();
        pSDEFormBase.resetUserParams();
        pSDEFormBase.resetUserPSDEActionId();
        pSDEFormBase.resetUserPSDEActionName();
        pSDEFormBase.resetUserTag();
        pSDEFormBase.resetUserTag2();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBusyIndicatorDirty()) {
            hashMap.put(FIELD_BUSYINDICATOR, this.getBusyIndicator());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCopyPSDEActionIdDirty()) {
            hashMap.put(FIELD_COPYPSDEACTIONID, this.getCopyPSDEActionId());
        }
        if (!bl || this.isCopyPSDEActionNameDirty()) {
            hashMap.put(FIELD_COPYPSDEACTIONNAME, this.getCopyPSDEActionName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCreatePSDEActionIdDirty()) {
            hashMap.put(FIELD_CREATEPSDEACTIONID, this.getCreatePSDEActionId());
        }
        if (!bl || this.isCreatePSDEActionNameDirty()) {
            hashMap.put(FIELD_CREATEPSDEACTIONNAME, this.getCreatePSDEActionName());
        }
        if (!bl || this.isCtrlColSpanDirty()) {
            hashMap.put(FIELD_CTRLCOLSPAN, this.getCtrlColSpan());
        }
        if (!bl || this.isDataTypeDirty()) {
            hashMap.put(FIELD_DATATYPE, this.getDataType());
        }
        if (!bl || this.isDetailStyleDirty()) {
            hashMap.put(FIELD_DETAILSTYLE, this.getDetailStyle());
        }
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isDynaSysRefModeDirty()) {
            hashMap.put(FIELD_DYNASYSREFMODE, this.getDynaSysRefMode());
        }
        if (!bl || this.isEnableAdvSearchDirty()) {
            hashMap.put(FIELD_ENABLEADVSEARCH, this.getEnableAdvSearch());
        }
        if (!bl || this.isEnableAutoSaveDirty()) {
            hashMap.put(FIELD_ENABLEAUTOSAVE, this.getEnableAutoSave());
        }
        if (!bl || this.isEnableCustomizedDirty()) {
            hashMap.put(FIELD_ENABLECUSTOMIZED, this.getEnableCustomized());
        }
        if (!bl || this.isEnableFilterSaveDirty()) {
            hashMap.put(FIELD_ENABLEFILTERSAVE, this.getEnableFilterSave());
        }
        if (!bl || this.isEnableItemFilterDirty()) {
            hashMap.put(FIELD_ENABLEITEMFILTER, this.getEnableItemFilter());
        }
        if (!bl || this.isEnableItemPrivDirty()) {
            hashMap.put(FIELD_ENABLEITEMPRIV, this.getEnableItemPriv());
        }
        if (!bl || this.isFormItemStyleDirty()) {
            hashMap.put(FIELD_FORMITEMSTYLE, this.getFormItemStyle());
        }
        if (!bl || this.isFormModelDirty()) {
            hashMap.put(FIELD_FORMMODEL, this.getFormModel());
        }
        if (!bl || this.isFormNavBarDirty()) {
            hashMap.put(FIELD_FORMNAVBAR, this.getFormNavBar());
        }
        if (!bl || this.isFormSNDirty()) {
            hashMap.put(FIELD_FORMSN, this.getFormSN());
        }
        if (!bl || this.isFormStyleDirty()) {
            hashMap.put(FIELD_FORMSTYLE, this.getFormStyle());
        }
        if (!bl || this.isFormTagDirty()) {
            hashMap.put(FIELD_FORMTAG, this.getFormTag());
        }
        if (!bl || this.isFormTag2Dirty()) {
            hashMap.put(FIELD_FORMTAG2, this.getFormTag2());
        }
        if (!bl || this.isFormTag3Dirty()) {
            hashMap.put(FIELD_FORMTAG3, this.getFormTag3());
        }
        if (!bl || this.isFormTag4Dirty()) {
            hashMap.put(FIELD_FORMTAG4, this.getFormTag4());
        }
        if (!bl || this.isFormTypeDirty()) {
            hashMap.put(FIELD_FORMTYPE, this.getFormType());
        }
        if (!bl || this.isFormWidthDirty()) {
            hashMap.put(FIELD_FORMWIDTH, this.getFormWidth());
        }
        if (!bl || this.isFuncModeDirty()) {
            hashMap.put(FIELD_FUNCMODE, this.getFuncMode());
        }
        if (!bl || this.isGetDraftPSDEActionIdDirty()) {
            hashMap.put(FIELD_GETDRAFTPSDEACTIONID, this.getGetDraftPSDEActionId());
        }
        if (!bl || this.isGetDraftPSDEActionNameDirty()) {
            hashMap.put(FIELD_GETDRAFTPSDEACTIONNAME, this.getGetDraftPSDEActionName());
        }
        if (!bl || this.isGetPSDEActionIdDirty()) {
            hashMap.put(FIELD_GETPSDEACTIONID, this.getGetPSDEActionId());
        }
        if (!bl || this.isGetPSDEActionNameDirty()) {
            hashMap.put(FIELD_GETPSDEACTIONNAME, this.getGetPSDEActionName());
        }
        if (!bl || this.isInfoFormFlagDirty()) {
            hashMap.put(FIELD_INFOFORMFLAG, this.getInfoFormFlag());
        }
        if (!bl || this.isLabelColSpanDirty()) {
            hashMap.put(FIELD_LABELCOLSPAN, this.getLabelColSpan());
        }
        if (!bl || this.isLabelColSpan2Dirty()) {
            hashMap.put(FIELD_LABELCOLSPAN2, this.getLabelColSpan2());
        }
        if (!bl || this.isLabelWidthDirty()) {
            hashMap.put(FIELD_LABELWIDTH, this.getLabelWidth());
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
        if (!bl || this.isPDVTParamDirty()) {
            hashMap.put(FIELD_PDVTPARAM, this.getPDVTParam());
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
        if (!bl || this.isPSDEFInputTipSetIdDirty()) {
            hashMap.put(FIELD_PSDEFINPUTTIPSETID, this.getPSDEFInputTipSetId());
        }
        if (!bl || this.isPSDEFInputTipSetNameDirty()) {
            hashMap.put(FIELD_PSDEFINPUTTIPSETNAME, this.getPSDEFInputTipSetName());
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
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDynaDEFormIdDirty()) {
            hashMap.put(FIELD_PSDYNADEFORMID, this.getPSDynaDEFormId());
        }
        if (!bl || this.isPSDynaDEFormInstIdDirty()) {
            hashMap.put(FIELD_PSDYNADEFORMINSTID, this.getPSDynaDEFormInstId());
        }
        if (!bl || this.isPSDynaDEFormInstNameDirty()) {
            hashMap.put(FIELD_PSDYNADEFORMINSTNAME, this.getPSDynaDEFormInstName());
        }
        if (!bl || this.isPSDynaDEFormNameDirty()) {
            hashMap.put(FIELD_PSDYNADEFORMNAME, this.getPSDynaDEFormName());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSDynaInstNameDirty()) {
            hashMap.put(FIELD_PSDYNAINSTNAME, this.getPSDynaInstName());
        }
        if (!bl || this.isPSPFIdDirty()) {
            hashMap.put(FIELD_PSPFID, this.getPSPFId());
        }
        if (!bl || this.isPSPFNameDirty()) {
            hashMap.put(FIELD_PSPFNAME, this.getPSPFName());
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
        if (!bl || this.isPSWFDEIdDirty()) {
            hashMap.put(FIELD_PSWFDEID, this.getPSWFDEId());
        }
        if (!bl || this.isPSWFDENameDirty()) {
            hashMap.put(FIELD_PSWFDENAME, this.getPSWFDEName());
        }
        if (!bl || this.isPSWFIdDirty()) {
            hashMap.put(FIELD_PSWFID, this.getPSWFId());
        }
        if (!bl || this.isRemovePSDEActionIdDirty()) {
            hashMap.put(FIELD_REMOVEPSDEACTIONID, this.getRemovePSDEActionId());
        }
        if (!bl || this.isRemovePSDEActionNameDirty()) {
            hashMap.put(FIELD_REMOVEPSDEACTIONNAME, this.getRemovePSDEActionName());
        }
        if (!bl || this.isSearchBtnPosDirty()) {
            hashMap.put(FIELD_SEARCHBTNPOS, this.getSearchBtnPos());
        }
        if (!bl || this.isSearchBtnStyleDirty()) {
            hashMap.put(FIELD_SEARCHBTNSTYLE, this.getSearchBtnStyle());
        }
        if (!bl || this.isShowTabHeaderDirty()) {
            hashMap.put(FIELD_SHOWTABHEADER, this.getShowTabHeader());
        }
        if (!bl || this.isSRFSysPubDirty()) {
            hashMap.put(FIELD_SRFSYSPUB, this.getSRFSysPub());
        }
        if (!bl || this.isTabHeaderPosDirty()) {
            hashMap.put(FIELD_TABHEADERPOS, this.getTabHeaderPos());
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
        if (!bl || this.isUpdatePSDEActionIdDirty()) {
            hashMap.put(FIELD_UPDATEPSDEACTIONID, this.getUpdatePSDEActionId());
        }
        if (!bl || this.isUpdatePSDEActionNameDirty()) {
            hashMap.put(FIELD_UPDATEPSDEACTIONNAME, this.getUpdatePSDEActionName());
        }
        if (!bl || this.isUser2PSDEActionIdDirty()) {
            hashMap.put(FIELD_USER2PSDEACTIONID, this.getUser2PSDEActionId());
        }
        if (!bl || this.isUser2PSDEActionNameDirty()) {
            hashMap.put(FIELD_USER2PSDEACTIONNAME, this.getUser2PSDEActionName());
        }
        if (!bl || this.isUserParamsDirty()) {
            hashMap.put(FIELD_USERPARAMS, this.getUserParams());
        }
        if (!bl || this.isUserPSDEActionIdDirty()) {
            hashMap.put(FIELD_USERPSDEACTIONID, this.getUserPSDEActionId());
        }
        if (!bl || this.isUserPSDEActionNameDirty()) {
            hashMap.put(FIELD_USERPSDEACTIONNAME, this.getUserPSDEActionName());
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
        return PSDEFormBase.get(this, n);
    }

    private static Object get(PSDEFormBase pSDEFormBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFormBase.getBusyIndicator();
            }
            case 1: {
                return pSDEFormBase.getCodeName();
            }
            case 2: {
                return pSDEFormBase.getCopyPSDEActionId();
            }
            case 3: {
                return pSDEFormBase.getCopyPSDEActionName();
            }
            case 4: {
                return pSDEFormBase.getCreateDate();
            }
            case 5: {
                return pSDEFormBase.getCreateMan();
            }
            case 6: {
                return pSDEFormBase.getCreatePSDEActionId();
            }
            case 7: {
                return pSDEFormBase.getCreatePSDEActionName();
            }
            case 8: {
                return pSDEFormBase.getCtrlColSpan();
            }
            case 9: {
                return pSDEFormBase.getDataType();
            }
            case 10: {
                return pSDEFormBase.getDetailStyle();
            }
            case 11: {
                return pSDEFormBase.getDynaModelFlag();
            }
            case 12: {
                return pSDEFormBase.getDynaSysRefMode();
            }
            case 13: {
                return pSDEFormBase.getEnableAdvSearch();
            }
            case 14: {
                return pSDEFormBase.getEnableAutoSave();
            }
            case 15: {
                return pSDEFormBase.getEnableCustomized();
            }
            case 16: {
                return pSDEFormBase.getEnableFilterSave();
            }
            case 17: {
                return pSDEFormBase.getEnableItemFilter();
            }
            case 18: {
                return pSDEFormBase.getEnableItemPriv();
            }
            case 19: {
                return pSDEFormBase.getFormItemStyle();
            }
            case 20: {
                return pSDEFormBase.getFormModel();
            }
            case 21: {
                return pSDEFormBase.getFormNavBar();
            }
            case 22: {
                return pSDEFormBase.getFormSN();
            }
            case 23: {
                return pSDEFormBase.getFormStyle();
            }
            case 24: {
                return pSDEFormBase.getFormTag();
            }
            case 25: {
                return pSDEFormBase.getFormTag2();
            }
            case 26: {
                return pSDEFormBase.getFormTag3();
            }
            case 27: {
                return pSDEFormBase.getFormTag4();
            }
            case 28: {
                return pSDEFormBase.getFormType();
            }
            case 29: {
                return pSDEFormBase.getFormWidth();
            }
            case 30: {
                return pSDEFormBase.getFuncMode();
            }
            case 31: {
                return pSDEFormBase.getGetDraftPSDEActionId();
            }
            case 32: {
                return pSDEFormBase.getGetDraftPSDEActionName();
            }
            case 33: {
                return pSDEFormBase.getGetPSDEActionId();
            }
            case 34: {
                return pSDEFormBase.getGetPSDEActionName();
            }
            case 35: {
                return pSDEFormBase.getInfoFormFlag();
            }
            case 36: {
                return pSDEFormBase.getLabelColSpan();
            }
            case 37: {
                return pSDEFormBase.getLabelColSpan2();
            }
            case 38: {
                return pSDEFormBase.getLabelWidth();
            }
            case 39: {
                return pSDEFormBase.getLayoutMode();
            }
            case 40: {
                return pSDEFormBase.getLockFlag();
            }
            case 41: {
                return pSDEFormBase.getMemo();
            }
            case 42: {
                return pSDEFormBase.getMobFlag();
            }
            case 43: {
                return pSDEFormBase.getNavBarHeight();
            }
            case 44: {
                return pSDEFormBase.getNavBarPos();
            }
            case 45: {
                return pSDEFormBase.getNavBarPSSysCssId();
            }
            case 46: {
                return pSDEFormBase.getNavBarPSSysCssName();
            }
            case 47: {
                return pSDEFormBase.getNavBarStyle();
            }
            case 48: {
                return pSDEFormBase.getNavBarWidth();
            }
            case 49: {
                return pSDEFormBase.getPDVTParam();
            }
            case 50: {
                return pSDEFormBase.getPSACHandlerId();
            }
            case 51: {
                return pSDEFormBase.getPSACHandlerName();
            }
            case 52: {
                return pSDEFormBase.getPSCtrlLogicGroupId();
            }
            case 53: {
                return pSDEFormBase.getPSCtrlLogicGroupName();
            }
            case 54: {
                return pSDEFormBase.getPSCtrlMsgId();
            }
            case 55: {
                return pSDEFormBase.getPSCtrlMsgName();
            }
            case 56: {
                return pSDEFormBase.getPSDEFInputTipSetId();
            }
            case 57: {
                return pSDEFormBase.getPSDEFInputTipSetName();
            }
            case 58: {
                return pSDEFormBase.getPSDEFormId();
            }
            case 59: {
                return pSDEFormBase.getPSDEFormName();
            }
            case 60: {
                return pSDEFormBase.getPSDEId();
            }
            case 61: {
                return pSDEFormBase.getPSDEName();
            }
            case 62: {
                return pSDEFormBase.getPSDynaDEFormId();
            }
            case 63: {
                return pSDEFormBase.getPSDynaDEFormInstId();
            }
            case 64: {
                return pSDEFormBase.getPSDynaDEFormInstName();
            }
            case 65: {
                return pSDEFormBase.getPSDynaDEFormName();
            }
            case 66: {
                return pSDEFormBase.getPSDynaInstId();
            }
            case 67: {
                return pSDEFormBase.getPSDynaInstName();
            }
            case 68: {
                return pSDEFormBase.getPSPFId();
            }
            case 69: {
                return pSDEFormBase.getPSPFName();
            }
            case 70: {
                return pSDEFormBase.getPSSysCounterId();
            }
            case 71: {
                return pSDEFormBase.getPSSysCounterName();
            }
            case 72: {
                return pSDEFormBase.getPSSysCssId();
            }
            case 73: {
                return pSDEFormBase.getPSSysCssName();
            }
            case 74: {
                return pSDEFormBase.getPSSysDynaModelId();
            }
            case 75: {
                return pSDEFormBase.getPSSysDynaModelName();
            }
            case 76: {
                return pSDEFormBase.getPSSysPFPluginId();
            }
            case 77: {
                return pSDEFormBase.getPSSysPFPluginName();
            }
            case 78: {
                return pSDEFormBase.getPSSysReqItemId();
            }
            case 79: {
                return pSDEFormBase.getPSSysReqItemName();
            }
            case 80: {
                return pSDEFormBase.getPSViewMsgGroupId();
            }
            case 81: {
                return pSDEFormBase.getPSViewMsgGroupName();
            }
            case 82: {
                return pSDEFormBase.getPSWFDEId();
            }
            case 83: {
                return pSDEFormBase.getPSWFDEName();
            }
            case 84: {
                return pSDEFormBase.getPSWFId();
            }
            case 85: {
                return pSDEFormBase.getRemovePSDEActionId();
            }
            case 86: {
                return pSDEFormBase.getRemovePSDEActionName();
            }
            case 87: {
                return pSDEFormBase.getSearchBtnPos();
            }
            case 88: {
                return pSDEFormBase.getSearchBtnStyle();
            }
            case 89: {
                return pSDEFormBase.getShowTabHeader();
            }
            case 90: {
                return pSDEFormBase.getSRFSysPub();
            }
            case 91: {
                return pSDEFormBase.getTabHeaderPos();
            }
            case 92: {
                return pSDEFormBase.getToDoTask();
            }
            case 93: {
                return pSDEFormBase.getUpdateDate();
            }
            case 94: {
                return pSDEFormBase.getUpdateMan();
            }
            case 95: {
                return pSDEFormBase.getUpdatePSDEActionId();
            }
            case 96: {
                return pSDEFormBase.getUpdatePSDEActionName();
            }
            case 97: {
                return pSDEFormBase.getUser2PSDEActionId();
            }
            case 98: {
                return pSDEFormBase.getUser2PSDEActionName();
            }
            case 99: {
                return pSDEFormBase.getUserParams();
            }
            case 100: {
                return pSDEFormBase.getUserPSDEActionId();
            }
            case 101: {
                return pSDEFormBase.getUserPSDEActionName();
            }
            case 102: {
                return pSDEFormBase.getUserTag();
            }
            case 103: {
                return pSDEFormBase.getUserTag2();
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
        PSDEFormBase.set(this, n, object);
    }

    private static void set(PSDEFormBase pSDEFormBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEFormBase.setBusyIndicator(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDEFormBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEFormBase.setCopyPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEFormBase.setCopyPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEFormBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 5: {
                pSDEFormBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEFormBase.setCreatePSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEFormBase.setCreatePSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEFormBase.setCtrlColSpan(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSDEFormBase.setDataType(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEFormBase.setDetailStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEFormBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSDEFormBase.setDynaSysRefMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSDEFormBase.setEnableAdvSearch(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSDEFormBase.setEnableAutoSave(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSDEFormBase.setEnableCustomized(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSDEFormBase.setEnableFilterSave(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSDEFormBase.setEnableItemFilter(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSDEFormBase.setEnableItemPriv(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSDEFormBase.setFormItemStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEFormBase.setFormModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEFormBase.setFormNavBar(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 22: {
                pSDEFormBase.setFormSN(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEFormBase.setFormStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEFormBase.setFormTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEFormBase.setFormTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEFormBase.setFormTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDEFormBase.setFormTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEFormBase.setFormType(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDEFormBase.setFormWidth(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 30: {
                pSDEFormBase.setFuncMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDEFormBase.setGetDraftPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDEFormBase.setGetDraftPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDEFormBase.setGetPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDEFormBase.setGetPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDEFormBase.setInfoFormFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 36: {
                pSDEFormBase.setLabelColSpan(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 37: {
                pSDEFormBase.setLabelColSpan2(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 38: {
                pSDEFormBase.setLabelWidth(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 39: {
                pSDEFormBase.setLayoutMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDEFormBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 41: {
                pSDEFormBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDEFormBase.setMobFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 43: {
                pSDEFormBase.setNavBarHeight(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 44: {
                pSDEFormBase.setNavBarPos(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSDEFormBase.setNavBarPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSDEFormBase.setNavBarPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSDEFormBase.setNavBarStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSDEFormBase.setNavBarWidth(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 49: {
                pSDEFormBase.setPDVTParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSDEFormBase.setPSACHandlerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSDEFormBase.setPSACHandlerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSDEFormBase.setPSCtrlLogicGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSDEFormBase.setPSCtrlLogicGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSDEFormBase.setPSCtrlMsgId(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSDEFormBase.setPSCtrlMsgName(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSDEFormBase.setPSDEFInputTipSetId(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSDEFormBase.setPSDEFInputTipSetName(DataObject.getStringValue((Object)object));
                return;
            }
            case 58: {
                pSDEFormBase.setPSDEFormId(DataObject.getStringValue((Object)object));
                return;
            }
            case 59: {
                pSDEFormBase.setPSDEFormName(DataObject.getStringValue((Object)object));
                return;
            }
            case 60: {
                pSDEFormBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 61: {
                pSDEFormBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 62: {
                pSDEFormBase.setPSDynaDEFormId(DataObject.getStringValue((Object)object));
                return;
            }
            case 63: {
                pSDEFormBase.setPSDynaDEFormInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 64: {
                pSDEFormBase.setPSDynaDEFormInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 65: {
                pSDEFormBase.setPSDynaDEFormName(DataObject.getStringValue((Object)object));
                return;
            }
            case 66: {
                pSDEFormBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 67: {
                pSDEFormBase.setPSDynaInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 68: {
                pSDEFormBase.setPSPFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 69: {
                pSDEFormBase.setPSPFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 70: {
                pSDEFormBase.setPSSysCounterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 71: {
                pSDEFormBase.setPSSysCounterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 72: {
                pSDEFormBase.setPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 73: {
                pSDEFormBase.setPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 74: {
                pSDEFormBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 75: {
                pSDEFormBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 76: {
                pSDEFormBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 77: {
                pSDEFormBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 78: {
                pSDEFormBase.setPSSysReqItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 79: {
                pSDEFormBase.setPSSysReqItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 80: {
                pSDEFormBase.setPSViewMsgGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 81: {
                pSDEFormBase.setPSViewMsgGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 82: {
                pSDEFormBase.setPSWFDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 83: {
                pSDEFormBase.setPSWFDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 84: {
                pSDEFormBase.setPSWFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 85: {
                pSDEFormBase.setRemovePSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 86: {
                pSDEFormBase.setRemovePSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 87: {
                pSDEFormBase.setSearchBtnPos(DataObject.getStringValue((Object)object));
                return;
            }
            case 88: {
                pSDEFormBase.setSearchBtnStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 89: {
                pSDEFormBase.setShowTabHeader(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 90: {
                pSDEFormBase.setSRFSysPub(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 91: {
                pSDEFormBase.setTabHeaderPos(DataObject.getStringValue((Object)object));
                return;
            }
            case 92: {
                pSDEFormBase.setToDoTask(DataObject.getStringValue((Object)object));
                return;
            }
            case 93: {
                pSDEFormBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 94: {
                pSDEFormBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 95: {
                pSDEFormBase.setUpdatePSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 96: {
                pSDEFormBase.setUpdatePSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 97: {
                pSDEFormBase.setUser2PSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 98: {
                pSDEFormBase.setUser2PSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 99: {
                pSDEFormBase.setUserParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 100: {
                pSDEFormBase.setUserPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 101: {
                pSDEFormBase.setUserPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 102: {
                pSDEFormBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 103: {
                pSDEFormBase.setUserTag2(DataObject.getStringValue((Object)object));
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
        return PSDEFormBase.isNull(this, n);
    }

    private static boolean isNull(PSDEFormBase pSDEFormBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFormBase.getBusyIndicator() == null;
            }
            case 1: {
                return pSDEFormBase.getCodeName() == null;
            }
            case 2: {
                return pSDEFormBase.getCopyPSDEActionId() == null;
            }
            case 3: {
                return pSDEFormBase.getCopyPSDEActionName() == null;
            }
            case 4: {
                return pSDEFormBase.getCreateDate() == null;
            }
            case 5: {
                return pSDEFormBase.getCreateMan() == null;
            }
            case 6: {
                return pSDEFormBase.getCreatePSDEActionId() == null;
            }
            case 7: {
                return pSDEFormBase.getCreatePSDEActionName() == null;
            }
            case 8: {
                return pSDEFormBase.getCtrlColSpan() == null;
            }
            case 9: {
                return pSDEFormBase.getDataType() == null;
            }
            case 10: {
                return pSDEFormBase.getDetailStyle() == null;
            }
            case 11: {
                return pSDEFormBase.getDynaModelFlag() == null;
            }
            case 12: {
                return pSDEFormBase.getDynaSysRefMode() == null;
            }
            case 13: {
                return pSDEFormBase.getEnableAdvSearch() == null;
            }
            case 14: {
                return pSDEFormBase.getEnableAutoSave() == null;
            }
            case 15: {
                return pSDEFormBase.getEnableCustomized() == null;
            }
            case 16: {
                return pSDEFormBase.getEnableFilterSave() == null;
            }
            case 17: {
                return pSDEFormBase.getEnableItemFilter() == null;
            }
            case 18: {
                return pSDEFormBase.getEnableItemPriv() == null;
            }
            case 19: {
                return pSDEFormBase.getFormItemStyle() == null;
            }
            case 20: {
                return pSDEFormBase.getFormModel() == null;
            }
            case 21: {
                return pSDEFormBase.getFormNavBar() == null;
            }
            case 22: {
                return pSDEFormBase.getFormSN() == null;
            }
            case 23: {
                return pSDEFormBase.getFormStyle() == null;
            }
            case 24: {
                return pSDEFormBase.getFormTag() == null;
            }
            case 25: {
                return pSDEFormBase.getFormTag2() == null;
            }
            case 26: {
                return pSDEFormBase.getFormTag3() == null;
            }
            case 27: {
                return pSDEFormBase.getFormTag4() == null;
            }
            case 28: {
                return pSDEFormBase.getFormType() == null;
            }
            case 29: {
                return pSDEFormBase.getFormWidth() == null;
            }
            case 30: {
                return pSDEFormBase.getFuncMode() == null;
            }
            case 31: {
                return pSDEFormBase.getGetDraftPSDEActionId() == null;
            }
            case 32: {
                return pSDEFormBase.getGetDraftPSDEActionName() == null;
            }
            case 33: {
                return pSDEFormBase.getGetPSDEActionId() == null;
            }
            case 34: {
                return pSDEFormBase.getGetPSDEActionName() == null;
            }
            case 35: {
                return pSDEFormBase.getInfoFormFlag() == null;
            }
            case 36: {
                return pSDEFormBase.getLabelColSpan() == null;
            }
            case 37: {
                return pSDEFormBase.getLabelColSpan2() == null;
            }
            case 38: {
                return pSDEFormBase.getLabelWidth() == null;
            }
            case 39: {
                return pSDEFormBase.getLayoutMode() == null;
            }
            case 40: {
                return pSDEFormBase.getLockFlag() == null;
            }
            case 41: {
                return pSDEFormBase.getMemo() == null;
            }
            case 42: {
                return pSDEFormBase.getMobFlag() == null;
            }
            case 43: {
                return pSDEFormBase.getNavBarHeight() == null;
            }
            case 44: {
                return pSDEFormBase.getNavBarPos() == null;
            }
            case 45: {
                return pSDEFormBase.getNavBarPSSysCssId() == null;
            }
            case 46: {
                return pSDEFormBase.getNavBarPSSysCssName() == null;
            }
            case 47: {
                return pSDEFormBase.getNavBarStyle() == null;
            }
            case 48: {
                return pSDEFormBase.getNavBarWidth() == null;
            }
            case 49: {
                return pSDEFormBase.getPDVTParam() == null;
            }
            case 50: {
                return pSDEFormBase.getPSACHandlerId() == null;
            }
            case 51: {
                return pSDEFormBase.getPSACHandlerName() == null;
            }
            case 52: {
                return pSDEFormBase.getPSCtrlLogicGroupId() == null;
            }
            case 53: {
                return pSDEFormBase.getPSCtrlLogicGroupName() == null;
            }
            case 54: {
                return pSDEFormBase.getPSCtrlMsgId() == null;
            }
            case 55: {
                return pSDEFormBase.getPSCtrlMsgName() == null;
            }
            case 56: {
                return pSDEFormBase.getPSDEFInputTipSetId() == null;
            }
            case 57: {
                return pSDEFormBase.getPSDEFInputTipSetName() == null;
            }
            case 58: {
                return pSDEFormBase.getPSDEFormId() == null;
            }
            case 59: {
                return pSDEFormBase.getPSDEFormName() == null;
            }
            case 60: {
                return pSDEFormBase.getPSDEId() == null;
            }
            case 61: {
                return pSDEFormBase.getPSDEName() == null;
            }
            case 62: {
                return pSDEFormBase.getPSDynaDEFormId() == null;
            }
            case 63: {
                return pSDEFormBase.getPSDynaDEFormInstId() == null;
            }
            case 64: {
                return pSDEFormBase.getPSDynaDEFormInstName() == null;
            }
            case 65: {
                return pSDEFormBase.getPSDynaDEFormName() == null;
            }
            case 66: {
                return pSDEFormBase.getPSDynaInstId() == null;
            }
            case 67: {
                return pSDEFormBase.getPSDynaInstName() == null;
            }
            case 68: {
                return pSDEFormBase.getPSPFId() == null;
            }
            case 69: {
                return pSDEFormBase.getPSPFName() == null;
            }
            case 70: {
                return pSDEFormBase.getPSSysCounterId() == null;
            }
            case 71: {
                return pSDEFormBase.getPSSysCounterName() == null;
            }
            case 72: {
                return pSDEFormBase.getPSSysCssId() == null;
            }
            case 73: {
                return pSDEFormBase.getPSSysCssName() == null;
            }
            case 74: {
                return pSDEFormBase.getPSSysDynaModelId() == null;
            }
            case 75: {
                return pSDEFormBase.getPSSysDynaModelName() == null;
            }
            case 76: {
                return pSDEFormBase.getPSSysPFPluginId() == null;
            }
            case 77: {
                return pSDEFormBase.getPSSysPFPluginName() == null;
            }
            case 78: {
                return pSDEFormBase.getPSSysReqItemId() == null;
            }
            case 79: {
                return pSDEFormBase.getPSSysReqItemName() == null;
            }
            case 80: {
                return pSDEFormBase.getPSViewMsgGroupId() == null;
            }
            case 81: {
                return pSDEFormBase.getPSViewMsgGroupName() == null;
            }
            case 82: {
                return pSDEFormBase.getPSWFDEId() == null;
            }
            case 83: {
                return pSDEFormBase.getPSWFDEName() == null;
            }
            case 84: {
                return pSDEFormBase.getPSWFId() == null;
            }
            case 85: {
                return pSDEFormBase.getRemovePSDEActionId() == null;
            }
            case 86: {
                return pSDEFormBase.getRemovePSDEActionName() == null;
            }
            case 87: {
                return pSDEFormBase.getSearchBtnPos() == null;
            }
            case 88: {
                return pSDEFormBase.getSearchBtnStyle() == null;
            }
            case 89: {
                return pSDEFormBase.getShowTabHeader() == null;
            }
            case 90: {
                return pSDEFormBase.getSRFSysPub() == null;
            }
            case 91: {
                return pSDEFormBase.getTabHeaderPos() == null;
            }
            case 92: {
                return pSDEFormBase.getToDoTask() == null;
            }
            case 93: {
                return pSDEFormBase.getUpdateDate() == null;
            }
            case 94: {
                return pSDEFormBase.getUpdateMan() == null;
            }
            case 95: {
                return pSDEFormBase.getUpdatePSDEActionId() == null;
            }
            case 96: {
                return pSDEFormBase.getUpdatePSDEActionName() == null;
            }
            case 97: {
                return pSDEFormBase.getUser2PSDEActionId() == null;
            }
            case 98: {
                return pSDEFormBase.getUser2PSDEActionName() == null;
            }
            case 99: {
                return pSDEFormBase.getUserParams() == null;
            }
            case 100: {
                return pSDEFormBase.getUserPSDEActionId() == null;
            }
            case 101: {
                return pSDEFormBase.getUserPSDEActionName() == null;
            }
            case 102: {
                return pSDEFormBase.getUserTag() == null;
            }
            case 103: {
                return pSDEFormBase.getUserTag2() == null;
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
        return PSDEFormBase.contains(this, n);
    }

    private static boolean contains(PSDEFormBase pSDEFormBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFormBase.isBusyIndicatorDirty();
            }
            case 1: {
                return pSDEFormBase.isCodeNameDirty();
            }
            case 2: {
                return pSDEFormBase.isCopyPSDEActionIdDirty();
            }
            case 3: {
                return pSDEFormBase.isCopyPSDEActionNameDirty();
            }
            case 4: {
                return pSDEFormBase.isCreateDateDirty();
            }
            case 5: {
                return pSDEFormBase.isCreateManDirty();
            }
            case 6: {
                return pSDEFormBase.isCreatePSDEActionIdDirty();
            }
            case 7: {
                return pSDEFormBase.isCreatePSDEActionNameDirty();
            }
            case 8: {
                return pSDEFormBase.isCtrlColSpanDirty();
            }
            case 9: {
                return pSDEFormBase.isDataTypeDirty();
            }
            case 10: {
                return pSDEFormBase.isDetailStyleDirty();
            }
            case 11: {
                return pSDEFormBase.isDynaModelFlagDirty();
            }
            case 12: {
                return pSDEFormBase.isDynaSysRefModeDirty();
            }
            case 13: {
                return pSDEFormBase.isEnableAdvSearchDirty();
            }
            case 14: {
                return pSDEFormBase.isEnableAutoSaveDirty();
            }
            case 15: {
                return pSDEFormBase.isEnableCustomizedDirty();
            }
            case 16: {
                return pSDEFormBase.isEnableFilterSaveDirty();
            }
            case 17: {
                return pSDEFormBase.isEnableItemFilterDirty();
            }
            case 18: {
                return pSDEFormBase.isEnableItemPrivDirty();
            }
            case 19: {
                return pSDEFormBase.isFormItemStyleDirty();
            }
            case 20: {
                return pSDEFormBase.isFormModelDirty();
            }
            case 21: {
                return pSDEFormBase.isFormNavBarDirty();
            }
            case 22: {
                return pSDEFormBase.isFormSNDirty();
            }
            case 23: {
                return pSDEFormBase.isFormStyleDirty();
            }
            case 24: {
                return pSDEFormBase.isFormTagDirty();
            }
            case 25: {
                return pSDEFormBase.isFormTag2Dirty();
            }
            case 26: {
                return pSDEFormBase.isFormTag3Dirty();
            }
            case 27: {
                return pSDEFormBase.isFormTag4Dirty();
            }
            case 28: {
                return pSDEFormBase.isFormTypeDirty();
            }
            case 29: {
                return pSDEFormBase.isFormWidthDirty();
            }
            case 30: {
                return pSDEFormBase.isFuncModeDirty();
            }
            case 31: {
                return pSDEFormBase.isGetDraftPSDEActionIdDirty();
            }
            case 32: {
                return pSDEFormBase.isGetDraftPSDEActionNameDirty();
            }
            case 33: {
                return pSDEFormBase.isGetPSDEActionIdDirty();
            }
            case 34: {
                return pSDEFormBase.isGetPSDEActionNameDirty();
            }
            case 35: {
                return pSDEFormBase.isInfoFormFlagDirty();
            }
            case 36: {
                return pSDEFormBase.isLabelColSpanDirty();
            }
            case 37: {
                return pSDEFormBase.isLabelColSpan2Dirty();
            }
            case 38: {
                return pSDEFormBase.isLabelWidthDirty();
            }
            case 39: {
                return pSDEFormBase.isLayoutModeDirty();
            }
            case 40: {
                return pSDEFormBase.isLockFlagDirty();
            }
            case 41: {
                return pSDEFormBase.isMemoDirty();
            }
            case 42: {
                return pSDEFormBase.isMobFlagDirty();
            }
            case 43: {
                return pSDEFormBase.isNavBarHeightDirty();
            }
            case 44: {
                return pSDEFormBase.isNavBarPosDirty();
            }
            case 45: {
                return pSDEFormBase.isNavBarPSSysCssIdDirty();
            }
            case 46: {
                return pSDEFormBase.isNavBarPSSysCssNameDirty();
            }
            case 47: {
                return pSDEFormBase.isNavBarStyleDirty();
            }
            case 48: {
                return pSDEFormBase.isNavBarWidthDirty();
            }
            case 49: {
                return pSDEFormBase.isPDVTParamDirty();
            }
            case 50: {
                return pSDEFormBase.isPSACHandlerIdDirty();
            }
            case 51: {
                return pSDEFormBase.isPSACHandlerNameDirty();
            }
            case 52: {
                return pSDEFormBase.isPSCtrlLogicGroupIdDirty();
            }
            case 53: {
                return pSDEFormBase.isPSCtrlLogicGroupNameDirty();
            }
            case 54: {
                return pSDEFormBase.isPSCtrlMsgIdDirty();
            }
            case 55: {
                return pSDEFormBase.isPSCtrlMsgNameDirty();
            }
            case 56: {
                return pSDEFormBase.isPSDEFInputTipSetIdDirty();
            }
            case 57: {
                return pSDEFormBase.isPSDEFInputTipSetNameDirty();
            }
            case 58: {
                return pSDEFormBase.isPSDEFormIdDirty();
            }
            case 59: {
                return pSDEFormBase.isPSDEFormNameDirty();
            }
            case 60: {
                return pSDEFormBase.isPSDEIdDirty();
            }
            case 61: {
                return pSDEFormBase.isPSDENameDirty();
            }
            case 62: {
                return pSDEFormBase.isPSDynaDEFormIdDirty();
            }
            case 63: {
                return pSDEFormBase.isPSDynaDEFormInstIdDirty();
            }
            case 64: {
                return pSDEFormBase.isPSDynaDEFormInstNameDirty();
            }
            case 65: {
                return pSDEFormBase.isPSDynaDEFormNameDirty();
            }
            case 66: {
                return pSDEFormBase.isPSDynaInstIdDirty();
            }
            case 67: {
                return pSDEFormBase.isPSDynaInstNameDirty();
            }
            case 68: {
                return pSDEFormBase.isPSPFIdDirty();
            }
            case 69: {
                return pSDEFormBase.isPSPFNameDirty();
            }
            case 70: {
                return pSDEFormBase.isPSSysCounterIdDirty();
            }
            case 71: {
                return pSDEFormBase.isPSSysCounterNameDirty();
            }
            case 72: {
                return pSDEFormBase.isPSSysCssIdDirty();
            }
            case 73: {
                return pSDEFormBase.isPSSysCssNameDirty();
            }
            case 74: {
                return pSDEFormBase.isPSSysDynaModelIdDirty();
            }
            case 75: {
                return pSDEFormBase.isPSSysDynaModelNameDirty();
            }
            case 76: {
                return pSDEFormBase.isPSSysPFPluginIdDirty();
            }
            case 77: {
                return pSDEFormBase.isPSSysPFPluginNameDirty();
            }
            case 78: {
                return pSDEFormBase.isPSSysReqItemIdDirty();
            }
            case 79: {
                return pSDEFormBase.isPSSysReqItemNameDirty();
            }
            case 80: {
                return pSDEFormBase.isPSViewMsgGroupIdDirty();
            }
            case 81: {
                return pSDEFormBase.isPSViewMsgGroupNameDirty();
            }
            case 82: {
                return pSDEFormBase.isPSWFDEIdDirty();
            }
            case 83: {
                return pSDEFormBase.isPSWFDENameDirty();
            }
            case 84: {
                return pSDEFormBase.isPSWFIdDirty();
            }
            case 85: {
                return pSDEFormBase.isRemovePSDEActionIdDirty();
            }
            case 86: {
                return pSDEFormBase.isRemovePSDEActionNameDirty();
            }
            case 87: {
                return pSDEFormBase.isSearchBtnPosDirty();
            }
            case 88: {
                return pSDEFormBase.isSearchBtnStyleDirty();
            }
            case 89: {
                return pSDEFormBase.isShowTabHeaderDirty();
            }
            case 90: {
                return pSDEFormBase.isSRFSysPubDirty();
            }
            case 91: {
                return pSDEFormBase.isTabHeaderPosDirty();
            }
            case 92: {
                return pSDEFormBase.isToDoTaskDirty();
            }
            case 93: {
                return pSDEFormBase.isUpdateDateDirty();
            }
            case 94: {
                return pSDEFormBase.isUpdateManDirty();
            }
            case 95: {
                return pSDEFormBase.isUpdatePSDEActionIdDirty();
            }
            case 96: {
                return pSDEFormBase.isUpdatePSDEActionNameDirty();
            }
            case 97: {
                return pSDEFormBase.isUser2PSDEActionIdDirty();
            }
            case 98: {
                return pSDEFormBase.isUser2PSDEActionNameDirty();
            }
            case 99: {
                return pSDEFormBase.isUserParamsDirty();
            }
            case 100: {
                return pSDEFormBase.isUserPSDEActionIdDirty();
            }
            case 101: {
                return pSDEFormBase.isUserPSDEActionNameDirty();
            }
            case 102: {
                return pSDEFormBase.isUserTagDirty();
            }
            case 103: {
                return pSDEFormBase.isUserTag2Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEFormBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEFormBase pSDEFormBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEFormBase.getBusyIndicator() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"busyindicator", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getBusyIndicator()), (boolean)false);
        }
        if (bl || pSDEFormBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDEFormBase.getCopyPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"copypsdeactionid", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getCopyPSDEActionId()), (boolean)false);
        }
        if (bl || pSDEFormBase.getCopyPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"copypsdeactionname", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getCopyPSDEActionName()), (boolean)false);
        }
        if (bl || pSDEFormBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEFormBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEFormBase.getCreatePSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createpsdeactionid", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getCreatePSDEActionId()), (boolean)false);
        }
        if (bl || pSDEFormBase.getCreatePSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createpsdeactionname", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getCreatePSDEActionName()), (boolean)false);
        }
        if (bl || pSDEFormBase.getCtrlColSpan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlcolspan", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getCtrlColSpan()), (boolean)false);
        }
        if (bl || pSDEFormBase.getDataType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"datatype", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getDataType()), (boolean)false);
        }
        if (bl || pSDEFormBase.getDetailStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"detailstyle", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getDetailStyle()), (boolean)false);
        }
        if (bl || pSDEFormBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSDEFormBase.getDynaSysRefMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynasysrefmode", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getDynaSysRefMode()), (boolean)false);
        }
        if (bl || pSDEFormBase.getEnableAdvSearch() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableadvsearch", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getEnableAdvSearch()), (boolean)false);
        }
        if (bl || pSDEFormBase.getEnableAutoSave() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableautosave", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getEnableAutoSave()), (boolean)false);
        }
        if (bl || pSDEFormBase.getEnableCustomized() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablecustomized", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getEnableCustomized()), (boolean)false);
        }
        if (bl || pSDEFormBase.getEnableFilterSave() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablefiltersave", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getEnableFilterSave()), (boolean)false);
        }
        if (bl || pSDEFormBase.getEnableItemFilter() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableitemfilter", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getEnableItemFilter()), (boolean)false);
        }
        if (bl || pSDEFormBase.getEnableItemPriv() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableitempriv", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getEnableItemPriv()), (boolean)false);
        }
        if (bl || pSDEFormBase.getFormItemStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"formitemstyle", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getFormItemStyle()), (boolean)false);
        }
        if (bl || pSDEFormBase.getFormModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"formmodel", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getFormModel()), (boolean)false);
        }
        if (bl || pSDEFormBase.getFormNavBar() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"formnavbar", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getFormNavBar()), (boolean)false);
        }
        if (bl || pSDEFormBase.getFormSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"formsn", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getFormSN()), (boolean)false);
        }
        if (bl || pSDEFormBase.getFormStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"formstyle", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getFormStyle()), (boolean)false);
        }
        if (bl || pSDEFormBase.getFormTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"formtag", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getFormTag()), (boolean)false);
        }
        if (bl || pSDEFormBase.getFormTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"formtag2", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getFormTag2()), (boolean)false);
        }
        if (bl || pSDEFormBase.getFormTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"formtag3", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getFormTag3()), (boolean)false);
        }
        if (bl || pSDEFormBase.getFormTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"formtag4", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getFormTag4()), (boolean)false);
        }
        if (bl || pSDEFormBase.getFormType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"formtype", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getFormType()), (boolean)false);
        }
        if (bl || pSDEFormBase.getFormWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"formwidth", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getFormWidth()), (boolean)false);
        }
        if (bl || pSDEFormBase.getFuncMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"funcmode", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getFuncMode()), (boolean)false);
        }
        if (bl || pSDEFormBase.getGetDraftPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"getdraftpsdeactionid", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getGetDraftPSDEActionId()), (boolean)false);
        }
        if (bl || pSDEFormBase.getGetDraftPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"getdraftpsdeactionname", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getGetDraftPSDEActionName()), (boolean)false);
        }
        if (bl || pSDEFormBase.getGetPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"getpsdeactionid", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getGetPSDEActionId()), (boolean)false);
        }
        if (bl || pSDEFormBase.getGetPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"getpsdeactionname", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getGetPSDEActionName()), (boolean)false);
        }
        if (bl || pSDEFormBase.getInfoFormFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"infoformflag", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getInfoFormFlag()), (boolean)false);
        }
        if (bl || pSDEFormBase.getLabelColSpan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"labelcolspan", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getLabelColSpan()), (boolean)false);
        }
        if (bl || pSDEFormBase.getLabelColSpan2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"labelcolspan2", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getLabelColSpan2()), (boolean)false);
        }
        if (bl || pSDEFormBase.getLabelWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"labelwidth", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getLabelWidth()), (boolean)false);
        }
        if (bl || pSDEFormBase.getLayoutMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"layoutmode", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getLayoutMode()), (boolean)false);
        }
        if (bl || pSDEFormBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSDEFormBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEFormBase.getMobFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobflag", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getMobFlag()), (boolean)false);
        }
        if (bl || pSDEFormBase.getNavBarHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navbarheight", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getNavBarHeight()), (boolean)false);
        }
        if (bl || pSDEFormBase.getNavBarPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navbarpos", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getNavBarPos()), (boolean)false);
        }
        if (bl || pSDEFormBase.getNavBarPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navbarpssyscssid", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getNavBarPSSysCssId()), (boolean)false);
        }
        if (bl || pSDEFormBase.getNavBarPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navbarpssyscssname", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getNavBarPSSysCssName()), (boolean)false);
        }
        if (bl || pSDEFormBase.getNavBarStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navbarstyle", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getNavBarStyle()), (boolean)false);
        }
        if (bl || pSDEFormBase.getNavBarWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navbarwidth", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getNavBarWidth()), (boolean)false);
        }
        if (bl || pSDEFormBase.getPDVTParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pdvtparam", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getPDVTParam()), (boolean)false);
        }
        if (bl || pSDEFormBase.getPSACHandlerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psachandlerid", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getPSACHandlerId()), (boolean)false);
        }
        if (bl || pSDEFormBase.getPSACHandlerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psachandlername", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getPSACHandlerName()), (boolean)false);
        }
        if (bl || pSDEFormBase.getPSCtrlLogicGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrllogicgroupid", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getPSCtrlLogicGroupId()), (boolean)false);
        }
        if (bl || pSDEFormBase.getPSCtrlLogicGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrllogicgroupname", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getPSCtrlLogicGroupName()), (boolean)false);
        }
        if (bl || pSDEFormBase.getPSCtrlMsgId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrlmsgid", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getPSCtrlMsgId()), (boolean)false);
        }
        if (bl || pSDEFormBase.getPSCtrlMsgName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrlmsgname", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getPSCtrlMsgName()), (boolean)false);
        }
        if (bl || pSDEFormBase.getPSDEFInputTipSetId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefinputtipsetid", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getPSDEFInputTipSetId()), (boolean)false);
        }
        if (bl || pSDEFormBase.getPSDEFInputTipSetName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefinputtipsetname", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getPSDEFInputTipSetName()), (boolean)false);
        }
        if (bl || pSDEFormBase.getPSDEFormId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformid", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getPSDEFormId()), (boolean)false);
        }
        if (bl || pSDEFormBase.getPSDEFormName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformname", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getPSDEFormName()), (boolean)false);
        }
        if (bl || pSDEFormBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEFormBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEFormBase.getPSDynaDEFormId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynadeformid", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getPSDynaDEFormId()), (boolean)false);
        }
        if (bl || pSDEFormBase.getPSDynaDEFormInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynadeforminstid", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getPSDynaDEFormInstId()), (boolean)false);
        }
        if (bl || pSDEFormBase.getPSDynaDEFormInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynadeforminstname", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getPSDynaDEFormInstName()), (boolean)false);
        }
        if (bl || pSDEFormBase.getPSDynaDEFormName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynadeformname", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getPSDynaDEFormName()), (boolean)false);
        }
        if (bl || pSDEFormBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSDEFormBase.getPSDynaInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstname", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getPSDynaInstName()), (boolean)false);
        }
        if (bl || pSDEFormBase.getPSPFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfid", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getPSPFId()), (boolean)false);
        }
        if (bl || pSDEFormBase.getPSPFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfname", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getPSPFName()), (boolean)false);
        }
        if (bl || pSDEFormBase.getPSSysCounterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscounterid", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getPSSysCounterId()), (boolean)false);
        }
        if (bl || pSDEFormBase.getPSSysCounterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscountername", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getPSSysCounterName()), (boolean)false);
        }
        if (bl || pSDEFormBase.getPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssid", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getPSSysCssId()), (boolean)false);
        }
        if (bl || pSDEFormBase.getPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssname", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getPSSysCssName()), (boolean)false);
        }
        if (bl || pSDEFormBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSDEFormBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSDEFormBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSDEFormBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSDEFormBase.getPSSysReqItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemid", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getPSSysReqItemId()), (boolean)false);
        }
        if (bl || pSDEFormBase.getPSSysReqItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemname", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getPSSysReqItemName()), (boolean)false);
        }
        if (bl || pSDEFormBase.getPSViewMsgGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewmsggroupid", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getPSViewMsgGroupId()), (boolean)false);
        }
        if (bl || pSDEFormBase.getPSViewMsgGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewmsggroupname", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getPSViewMsgGroupName()), (boolean)false);
        }
        if (bl || pSDEFormBase.getPSWFDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfdeid", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getPSWFDEId()), (boolean)false);
        }
        if (bl || pSDEFormBase.getPSWFDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfdename", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getPSWFDEName()), (boolean)false);
        }
        if (bl || pSDEFormBase.getPSWFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfid", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getPSWFId()), (boolean)false);
        }
        if (bl || pSDEFormBase.getRemovePSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"removepsdeactionid", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getRemovePSDEActionId()), (boolean)false);
        }
        if (bl || pSDEFormBase.getRemovePSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"removepsdeactionname", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getRemovePSDEActionName()), (boolean)false);
        }
        if (bl || pSDEFormBase.getSearchBtnPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"searchbtnpos", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getSearchBtnPos()), (boolean)false);
        }
        if (bl || pSDEFormBase.getSearchBtnStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"searchbtnstyle", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getSearchBtnStyle()), (boolean)false);
        }
        if (bl || pSDEFormBase.getShowTabHeader() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"showtabheader", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getShowTabHeader()), (boolean)false);
        }
        if (bl || pSDEFormBase.getSRFSysPub() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srfsyspub", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getSRFSysPub()), (boolean)false);
        }
        if (bl || pSDEFormBase.getTabHeaderPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tabheaderpos", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getTabHeaderPos()), (boolean)false);
        }
        if (bl || pSDEFormBase.getToDoTask() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"todotask", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getToDoTask()), (boolean)false);
        }
        if (bl || pSDEFormBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEFormBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEFormBase.getUpdatePSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatepsdeactionid", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getUpdatePSDEActionId()), (boolean)false);
        }
        if (bl || pSDEFormBase.getUpdatePSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatepsdeactionname", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getUpdatePSDEActionName()), (boolean)false);
        }
        if (bl || pSDEFormBase.getUser2PSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"user2psdeactionid", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getUser2PSDEActionId()), (boolean)false);
        }
        if (bl || pSDEFormBase.getUser2PSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"user2psdeactionname", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getUser2PSDEActionName()), (boolean)false);
        }
        if (bl || pSDEFormBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getUserParams()), (boolean)false);
        }
        if (bl || pSDEFormBase.getUserPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userpsdeactionid", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getUserPSDEActionId()), (boolean)false);
        }
        if (bl || pSDEFormBase.getUserPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userpsdeactionname", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getUserPSDEActionName()), (boolean)false);
        }
        if (bl || pSDEFormBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEFormBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEFormBase.getJSONValue((Object)pSDEFormBase.getUserTag2()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEFormBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEFormBase pSDEFormBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEFormBase.getBusyIndicator() != null) {
            object = pSDEFormBase.getBusyIndicator();
            xmlNode.setAttribute(FIELD_BUSYINDICATOR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormBase.getCodeName() != null) {
            object = pSDEFormBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getCopyPSDEActionId() != null) {
            object = pSDEFormBase.getCopyPSDEActionId();
            xmlNode.setAttribute(FIELD_COPYPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getCopyPSDEActionName() != null) {
            object = pSDEFormBase.getCopyPSDEActionName();
            xmlNode.setAttribute(FIELD_COPYPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getCreateDate() != null) {
            object = pSDEFormBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEFormBase.getCreateMan() != null) {
            object = pSDEFormBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getCreatePSDEActionId() != null) {
            object = pSDEFormBase.getCreatePSDEActionId();
            xmlNode.setAttribute(FIELD_CREATEPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getCreatePSDEActionName() != null) {
            object = pSDEFormBase.getCreatePSDEActionName();
            xmlNode.setAttribute(FIELD_CREATEPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getCtrlColSpan() != null) {
            object = pSDEFormBase.getCtrlColSpan();
            xmlNode.setAttribute(FIELD_CTRLCOLSPAN, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormBase.getDataType() != null) {
            object = pSDEFormBase.getDataType();
            xmlNode.setAttribute(FIELD_DATATYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getDetailStyle() != null) {
            object = pSDEFormBase.getDetailStyle();
            xmlNode.setAttribute(FIELD_DETAILSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getDynaModelFlag() != null) {
            object = pSDEFormBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormBase.getDynaSysRefMode() != null) {
            object = pSDEFormBase.getDynaSysRefMode();
            xmlNode.setAttribute(FIELD_DYNASYSREFMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormBase.getEnableAdvSearch() != null) {
            object = pSDEFormBase.getEnableAdvSearch();
            xmlNode.setAttribute(FIELD_ENABLEADVSEARCH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormBase.getEnableAutoSave() != null) {
            object = pSDEFormBase.getEnableAutoSave();
            xmlNode.setAttribute(FIELD_ENABLEAUTOSAVE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormBase.getEnableCustomized() != null) {
            object = pSDEFormBase.getEnableCustomized();
            xmlNode.setAttribute(FIELD_ENABLECUSTOMIZED, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormBase.getEnableFilterSave() != null) {
            object = pSDEFormBase.getEnableFilterSave();
            xmlNode.setAttribute(FIELD_ENABLEFILTERSAVE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormBase.getEnableItemFilter() != null) {
            object = pSDEFormBase.getEnableItemFilter();
            xmlNode.setAttribute(FIELD_ENABLEITEMFILTER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormBase.getEnableItemPriv() != null) {
            object = pSDEFormBase.getEnableItemPriv();
            xmlNode.setAttribute(FIELD_ENABLEITEMPRIV, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormBase.getFormItemStyle() != null) {
            object = pSDEFormBase.getFormItemStyle();
            xmlNode.setAttribute(FIELD_FORMITEMSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getFormModel() != null) {
            object = pSDEFormBase.getFormModel();
            xmlNode.setAttribute(FIELD_FORMMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getFormNavBar() != null) {
            object = pSDEFormBase.getFormNavBar();
            xmlNode.setAttribute(FIELD_FORMNAVBAR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormBase.getFormSN() != null) {
            object = pSDEFormBase.getFormSN();
            xmlNode.setAttribute(FIELD_FORMSN, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getFormStyle() != null) {
            object = pSDEFormBase.getFormStyle();
            xmlNode.setAttribute(FIELD_FORMSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getFormTag() != null) {
            object = pSDEFormBase.getFormTag();
            xmlNode.setAttribute(FIELD_FORMTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getFormTag2() != null) {
            object = pSDEFormBase.getFormTag2();
            xmlNode.setAttribute(FIELD_FORMTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getFormTag3() != null) {
            object = pSDEFormBase.getFormTag3();
            xmlNode.setAttribute(FIELD_FORMTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getFormTag4() != null) {
            object = pSDEFormBase.getFormTag4();
            xmlNode.setAttribute(FIELD_FORMTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getFormType() != null) {
            object = pSDEFormBase.getFormType();
            xmlNode.setAttribute(FIELD_FORMTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getFormWidth() != null) {
            object = pSDEFormBase.getFormWidth();
            xmlNode.setAttribute(FIELD_FORMWIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormBase.getFuncMode() != null) {
            object = pSDEFormBase.getFuncMode();
            xmlNode.setAttribute(FIELD_FUNCMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getGetDraftPSDEActionId() != null) {
            object = pSDEFormBase.getGetDraftPSDEActionId();
            xmlNode.setAttribute(FIELD_GETDRAFTPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getGetDraftPSDEActionName() != null) {
            object = pSDEFormBase.getGetDraftPSDEActionName();
            xmlNode.setAttribute(FIELD_GETDRAFTPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getGetPSDEActionId() != null) {
            object = pSDEFormBase.getGetPSDEActionId();
            xmlNode.setAttribute(FIELD_GETPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getGetPSDEActionName() != null) {
            object = pSDEFormBase.getGetPSDEActionName();
            xmlNode.setAttribute(FIELD_GETPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getInfoFormFlag() != null) {
            object = pSDEFormBase.getInfoFormFlag();
            xmlNode.setAttribute(FIELD_INFOFORMFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormBase.getLabelColSpan() != null) {
            object = pSDEFormBase.getLabelColSpan();
            xmlNode.setAttribute(FIELD_LABELCOLSPAN, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormBase.getLabelColSpan2() != null) {
            object = pSDEFormBase.getLabelColSpan2();
            xmlNode.setAttribute(FIELD_LABELCOLSPAN2, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormBase.getLabelWidth() != null) {
            object = pSDEFormBase.getLabelWidth();
            xmlNode.setAttribute(FIELD_LABELWIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormBase.getLayoutMode() != null) {
            object = pSDEFormBase.getLayoutMode();
            xmlNode.setAttribute(FIELD_LAYOUTMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getLockFlag() != null) {
            object = pSDEFormBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormBase.getMemo() != null) {
            object = pSDEFormBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getMobFlag() != null) {
            object = pSDEFormBase.getMobFlag();
            xmlNode.setAttribute(FIELD_MOBFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormBase.getNavBarHeight() != null) {
            object = pSDEFormBase.getNavBarHeight();
            xmlNode.setAttribute(FIELD_NAVBARHEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormBase.getNavBarPos() != null) {
            object = pSDEFormBase.getNavBarPos();
            xmlNode.setAttribute(FIELD_NAVBARPOS, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getNavBarPSSysCssId() != null) {
            object = pSDEFormBase.getNavBarPSSysCssId();
            xmlNode.setAttribute(FIELD_NAVBARPSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getNavBarPSSysCssName() != null) {
            object = pSDEFormBase.getNavBarPSSysCssName();
            xmlNode.setAttribute(FIELD_NAVBARPSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getNavBarStyle() != null) {
            object = pSDEFormBase.getNavBarStyle();
            xmlNode.setAttribute(FIELD_NAVBARSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getNavBarWidth() != null) {
            object = pSDEFormBase.getNavBarWidth();
            xmlNode.setAttribute(FIELD_NAVBARWIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormBase.getPDVTParam() != null) {
            object = pSDEFormBase.getPDVTParam();
            xmlNode.setAttribute(FIELD_PDVTPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getPSACHandlerId() != null) {
            object = pSDEFormBase.getPSACHandlerId();
            xmlNode.setAttribute(FIELD_PSACHANDLERID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getPSACHandlerName() != null) {
            object = pSDEFormBase.getPSACHandlerName();
            xmlNode.setAttribute(FIELD_PSACHANDLERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getPSCtrlLogicGroupId() != null) {
            object = pSDEFormBase.getPSCtrlLogicGroupId();
            xmlNode.setAttribute(FIELD_PSCTRLLOGICGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getPSCtrlLogicGroupName() != null) {
            object = pSDEFormBase.getPSCtrlLogicGroupName();
            xmlNode.setAttribute(FIELD_PSCTRLLOGICGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getPSCtrlMsgId() != null) {
            object = pSDEFormBase.getPSCtrlMsgId();
            xmlNode.setAttribute(FIELD_PSCTRLMSGID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getPSCtrlMsgName() != null) {
            object = pSDEFormBase.getPSCtrlMsgName();
            xmlNode.setAttribute(FIELD_PSCTRLMSGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getPSDEFInputTipSetId() != null) {
            object = pSDEFormBase.getPSDEFInputTipSetId();
            xmlNode.setAttribute(FIELD_PSDEFINPUTTIPSETID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getPSDEFInputTipSetName() != null) {
            object = pSDEFormBase.getPSDEFInputTipSetName();
            xmlNode.setAttribute(FIELD_PSDEFINPUTTIPSETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getPSDEFormId() != null) {
            object = pSDEFormBase.getPSDEFormId();
            xmlNode.setAttribute(FIELD_PSDEFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getPSDEFormName() != null) {
            object = pSDEFormBase.getPSDEFormName();
            xmlNode.setAttribute(FIELD_PSDEFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getPSDEId() != null) {
            object = pSDEFormBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getPSDEName() != null) {
            object = pSDEFormBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getPSDynaDEFormId() != null) {
            object = pSDEFormBase.getPSDynaDEFormId();
            xmlNode.setAttribute(FIELD_PSDYNADEFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getPSDynaDEFormInstId() != null) {
            object = pSDEFormBase.getPSDynaDEFormInstId();
            xmlNode.setAttribute(FIELD_PSDYNADEFORMINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getPSDynaDEFormInstName() != null) {
            object = pSDEFormBase.getPSDynaDEFormInstName();
            xmlNode.setAttribute(FIELD_PSDYNADEFORMINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getPSDynaDEFormName() != null) {
            object = pSDEFormBase.getPSDynaDEFormName();
            xmlNode.setAttribute(FIELD_PSDYNADEFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getPSDynaInstId() != null) {
            object = pSDEFormBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getPSDynaInstName() != null) {
            object = pSDEFormBase.getPSDynaInstName();
            xmlNode.setAttribute(FIELD_PSDYNAINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getPSPFId() != null) {
            object = pSDEFormBase.getPSPFId();
            xmlNode.setAttribute(FIELD_PSPFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getPSPFName() != null) {
            object = pSDEFormBase.getPSPFName();
            xmlNode.setAttribute(FIELD_PSPFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getPSSysCounterId() != null) {
            object = pSDEFormBase.getPSSysCounterId();
            xmlNode.setAttribute(FIELD_PSSYSCOUNTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getPSSysCounterName() != null) {
            object = pSDEFormBase.getPSSysCounterName();
            xmlNode.setAttribute(FIELD_PSSYSCOUNTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getPSSysCssId() != null) {
            object = pSDEFormBase.getPSSysCssId();
            xmlNode.setAttribute(FIELD_PSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getPSSysCssName() != null) {
            object = pSDEFormBase.getPSSysCssName();
            xmlNode.setAttribute(FIELD_PSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getPSSysDynaModelId() != null) {
            object = pSDEFormBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getPSSysDynaModelName() != null) {
            object = pSDEFormBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getPSSysPFPluginId() != null) {
            object = pSDEFormBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getPSSysPFPluginName() != null) {
            object = pSDEFormBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getPSSysReqItemId() != null) {
            object = pSDEFormBase.getPSSysReqItemId();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getPSSysReqItemName() != null) {
            object = pSDEFormBase.getPSSysReqItemName();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getPSViewMsgGroupId() != null) {
            object = pSDEFormBase.getPSViewMsgGroupId();
            xmlNode.setAttribute(FIELD_PSVIEWMSGGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getPSViewMsgGroupName() != null) {
            object = pSDEFormBase.getPSViewMsgGroupName();
            xmlNode.setAttribute(FIELD_PSVIEWMSGGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getPSWFDEId() != null) {
            object = pSDEFormBase.getPSWFDEId();
            xmlNode.setAttribute(FIELD_PSWFDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getPSWFDEName() != null) {
            object = pSDEFormBase.getPSWFDEName();
            xmlNode.setAttribute(FIELD_PSWFDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getPSWFId() != null) {
            object = pSDEFormBase.getPSWFId();
            xmlNode.setAttribute(FIELD_PSWFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getRemovePSDEActionId() != null) {
            object = pSDEFormBase.getRemovePSDEActionId();
            xmlNode.setAttribute(FIELD_REMOVEPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getRemovePSDEActionName() != null) {
            object = pSDEFormBase.getRemovePSDEActionName();
            xmlNode.setAttribute(FIELD_REMOVEPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getSearchBtnPos() != null) {
            object = pSDEFormBase.getSearchBtnPos();
            xmlNode.setAttribute(FIELD_SEARCHBTNPOS, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getSearchBtnStyle() != null) {
            object = pSDEFormBase.getSearchBtnStyle();
            xmlNode.setAttribute(FIELD_SEARCHBTNSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getShowTabHeader() != null) {
            object = pSDEFormBase.getShowTabHeader();
            xmlNode.setAttribute(FIELD_SHOWTABHEADER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormBase.getSRFSysPub() != null) {
            object = pSDEFormBase.getSRFSysPub();
            xmlNode.setAttribute(FIELD_SRFSYSPUB, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormBase.getTabHeaderPos() != null) {
            object = pSDEFormBase.getTabHeaderPos();
            xmlNode.setAttribute(FIELD_TABHEADERPOS, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getToDoTask() != null) {
            object = pSDEFormBase.getToDoTask();
            xmlNode.setAttribute(FIELD_TODOTASK, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getUpdateDate() != null) {
            object = pSDEFormBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEFormBase.getUpdateMan() != null) {
            object = pSDEFormBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getUpdatePSDEActionId() != null) {
            object = pSDEFormBase.getUpdatePSDEActionId();
            xmlNode.setAttribute(FIELD_UPDATEPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getUpdatePSDEActionName() != null) {
            object = pSDEFormBase.getUpdatePSDEActionName();
            xmlNode.setAttribute(FIELD_UPDATEPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getUser2PSDEActionId() != null) {
            object = pSDEFormBase.getUser2PSDEActionId();
            xmlNode.setAttribute(FIELD_USER2PSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getUser2PSDEActionName() != null) {
            object = pSDEFormBase.getUser2PSDEActionName();
            xmlNode.setAttribute(FIELD_USER2PSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getUserParams() != null) {
            object = pSDEFormBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getUserPSDEActionId() != null) {
            object = pSDEFormBase.getUserPSDEActionId();
            xmlNode.setAttribute(FIELD_USERPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getUserPSDEActionName() != null) {
            object = pSDEFormBase.getUserPSDEActionName();
            xmlNode.setAttribute(FIELD_USERPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getUserTag() != null) {
            object = pSDEFormBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormBase.getUserTag2() != null) {
            object = pSDEFormBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEFormBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEFormBase pSDEFormBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEFormBase.isBusyIndicatorDirty() && (bl || pSDEFormBase.getBusyIndicator() != null)) {
            iDataObject.set(FIELD_BUSYINDICATOR, (Object)pSDEFormBase.getBusyIndicator());
        }
        if (pSDEFormBase.isCodeNameDirty() && (bl || pSDEFormBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDEFormBase.getCodeName());
        }
        if (pSDEFormBase.isCopyPSDEActionIdDirty() && (bl || pSDEFormBase.getCopyPSDEActionId() != null)) {
            iDataObject.set(FIELD_COPYPSDEACTIONID, (Object)pSDEFormBase.getCopyPSDEActionId());
        }
        if (pSDEFormBase.isCopyPSDEActionNameDirty() && (bl || pSDEFormBase.getCopyPSDEActionName() != null)) {
            iDataObject.set(FIELD_COPYPSDEACTIONNAME, (Object)pSDEFormBase.getCopyPSDEActionName());
        }
        if (pSDEFormBase.isCreateDateDirty() && (bl || pSDEFormBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEFormBase.getCreateDate());
        }
        if (pSDEFormBase.isCreateManDirty() && (bl || pSDEFormBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEFormBase.getCreateMan());
        }
        if (pSDEFormBase.isCreatePSDEActionIdDirty() && (bl || pSDEFormBase.getCreatePSDEActionId() != null)) {
            iDataObject.set(FIELD_CREATEPSDEACTIONID, (Object)pSDEFormBase.getCreatePSDEActionId());
        }
        if (pSDEFormBase.isCreatePSDEActionNameDirty() && (bl || pSDEFormBase.getCreatePSDEActionName() != null)) {
            iDataObject.set(FIELD_CREATEPSDEACTIONNAME, (Object)pSDEFormBase.getCreatePSDEActionName());
        }
        if (pSDEFormBase.isCtrlColSpanDirty() && (bl || pSDEFormBase.getCtrlColSpan() != null)) {
            iDataObject.set(FIELD_CTRLCOLSPAN, (Object)pSDEFormBase.getCtrlColSpan());
        }
        if (pSDEFormBase.isDataTypeDirty() && (bl || pSDEFormBase.getDataType() != null)) {
            iDataObject.set(FIELD_DATATYPE, (Object)pSDEFormBase.getDataType());
        }
        if (pSDEFormBase.isDetailStyleDirty() && (bl || pSDEFormBase.getDetailStyle() != null)) {
            iDataObject.set(FIELD_DETAILSTYLE, (Object)pSDEFormBase.getDetailStyle());
        }
        if (pSDEFormBase.isDynaModelFlagDirty() && (bl || pSDEFormBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSDEFormBase.getDynaModelFlag());
        }
        if (pSDEFormBase.isDynaSysRefModeDirty() && (bl || pSDEFormBase.getDynaSysRefMode() != null)) {
            iDataObject.set(FIELD_DYNASYSREFMODE, (Object)pSDEFormBase.getDynaSysRefMode());
        }
        if (pSDEFormBase.isEnableAdvSearchDirty() && (bl || pSDEFormBase.getEnableAdvSearch() != null)) {
            iDataObject.set(FIELD_ENABLEADVSEARCH, (Object)pSDEFormBase.getEnableAdvSearch());
        }
        if (pSDEFormBase.isEnableAutoSaveDirty() && (bl || pSDEFormBase.getEnableAutoSave() != null)) {
            iDataObject.set(FIELD_ENABLEAUTOSAVE, (Object)pSDEFormBase.getEnableAutoSave());
        }
        if (pSDEFormBase.isEnableCustomizedDirty() && (bl || pSDEFormBase.getEnableCustomized() != null)) {
            iDataObject.set(FIELD_ENABLECUSTOMIZED, (Object)pSDEFormBase.getEnableCustomized());
        }
        if (pSDEFormBase.isEnableFilterSaveDirty() && (bl || pSDEFormBase.getEnableFilterSave() != null)) {
            iDataObject.set(FIELD_ENABLEFILTERSAVE, (Object)pSDEFormBase.getEnableFilterSave());
        }
        if (pSDEFormBase.isEnableItemFilterDirty() && (bl || pSDEFormBase.getEnableItemFilter() != null)) {
            iDataObject.set(FIELD_ENABLEITEMFILTER, (Object)pSDEFormBase.getEnableItemFilter());
        }
        if (pSDEFormBase.isEnableItemPrivDirty() && (bl || pSDEFormBase.getEnableItemPriv() != null)) {
            iDataObject.set(FIELD_ENABLEITEMPRIV, (Object)pSDEFormBase.getEnableItemPriv());
        }
        if (pSDEFormBase.isFormItemStyleDirty() && (bl || pSDEFormBase.getFormItemStyle() != null)) {
            iDataObject.set(FIELD_FORMITEMSTYLE, (Object)pSDEFormBase.getFormItemStyle());
        }
        if (pSDEFormBase.isFormModelDirty() && (bl || pSDEFormBase.getFormModel() != null)) {
            iDataObject.set(FIELD_FORMMODEL, (Object)pSDEFormBase.getFormModel());
        }
        if (pSDEFormBase.isFormNavBarDirty() && (bl || pSDEFormBase.getFormNavBar() != null)) {
            iDataObject.set(FIELD_FORMNAVBAR, (Object)pSDEFormBase.getFormNavBar());
        }
        if (pSDEFormBase.isFormSNDirty() && (bl || pSDEFormBase.getFormSN() != null)) {
            iDataObject.set(FIELD_FORMSN, (Object)pSDEFormBase.getFormSN());
        }
        if (pSDEFormBase.isFormStyleDirty() && (bl || pSDEFormBase.getFormStyle() != null)) {
            iDataObject.set(FIELD_FORMSTYLE, (Object)pSDEFormBase.getFormStyle());
        }
        if (pSDEFormBase.isFormTagDirty() && (bl || pSDEFormBase.getFormTag() != null)) {
            iDataObject.set(FIELD_FORMTAG, (Object)pSDEFormBase.getFormTag());
        }
        if (pSDEFormBase.isFormTag2Dirty() && (bl || pSDEFormBase.getFormTag2() != null)) {
            iDataObject.set(FIELD_FORMTAG2, (Object)pSDEFormBase.getFormTag2());
        }
        if (pSDEFormBase.isFormTag3Dirty() && (bl || pSDEFormBase.getFormTag3() != null)) {
            iDataObject.set(FIELD_FORMTAG3, (Object)pSDEFormBase.getFormTag3());
        }
        if (pSDEFormBase.isFormTag4Dirty() && (bl || pSDEFormBase.getFormTag4() != null)) {
            iDataObject.set(FIELD_FORMTAG4, (Object)pSDEFormBase.getFormTag4());
        }
        if (pSDEFormBase.isFormTypeDirty() && (bl || pSDEFormBase.getFormType() != null)) {
            iDataObject.set(FIELD_FORMTYPE, (Object)pSDEFormBase.getFormType());
        }
        if (pSDEFormBase.isFormWidthDirty() && (bl || pSDEFormBase.getFormWidth() != null)) {
            iDataObject.set(FIELD_FORMWIDTH, (Object)pSDEFormBase.getFormWidth());
        }
        if (pSDEFormBase.isFuncModeDirty() && (bl || pSDEFormBase.getFuncMode() != null)) {
            iDataObject.set(FIELD_FUNCMODE, (Object)pSDEFormBase.getFuncMode());
        }
        if (pSDEFormBase.isGetDraftPSDEActionIdDirty() && (bl || pSDEFormBase.getGetDraftPSDEActionId() != null)) {
            iDataObject.set(FIELD_GETDRAFTPSDEACTIONID, (Object)pSDEFormBase.getGetDraftPSDEActionId());
        }
        if (pSDEFormBase.isGetDraftPSDEActionNameDirty() && (bl || pSDEFormBase.getGetDraftPSDEActionName() != null)) {
            iDataObject.set(FIELD_GETDRAFTPSDEACTIONNAME, (Object)pSDEFormBase.getGetDraftPSDEActionName());
        }
        if (pSDEFormBase.isGetPSDEActionIdDirty() && (bl || pSDEFormBase.getGetPSDEActionId() != null)) {
            iDataObject.set(FIELD_GETPSDEACTIONID, (Object)pSDEFormBase.getGetPSDEActionId());
        }
        if (pSDEFormBase.isGetPSDEActionNameDirty() && (bl || pSDEFormBase.getGetPSDEActionName() != null)) {
            iDataObject.set(FIELD_GETPSDEACTIONNAME, (Object)pSDEFormBase.getGetPSDEActionName());
        }
        if (pSDEFormBase.isInfoFormFlagDirty() && (bl || pSDEFormBase.getInfoFormFlag() != null)) {
            iDataObject.set(FIELD_INFOFORMFLAG, (Object)pSDEFormBase.getInfoFormFlag());
        }
        if (pSDEFormBase.isLabelColSpanDirty() && (bl || pSDEFormBase.getLabelColSpan() != null)) {
            iDataObject.set(FIELD_LABELCOLSPAN, (Object)pSDEFormBase.getLabelColSpan());
        }
        if (pSDEFormBase.isLabelColSpan2Dirty() && (bl || pSDEFormBase.getLabelColSpan2() != null)) {
            iDataObject.set(FIELD_LABELCOLSPAN2, (Object)pSDEFormBase.getLabelColSpan2());
        }
        if (pSDEFormBase.isLabelWidthDirty() && (bl || pSDEFormBase.getLabelWidth() != null)) {
            iDataObject.set(FIELD_LABELWIDTH, (Object)pSDEFormBase.getLabelWidth());
        }
        if (pSDEFormBase.isLayoutModeDirty() && (bl || pSDEFormBase.getLayoutMode() != null)) {
            iDataObject.set(FIELD_LAYOUTMODE, (Object)pSDEFormBase.getLayoutMode());
        }
        if (pSDEFormBase.isLockFlagDirty() && (bl || pSDEFormBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSDEFormBase.getLockFlag());
        }
        if (pSDEFormBase.isMemoDirty() && (bl || pSDEFormBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEFormBase.getMemo());
        }
        if (pSDEFormBase.isMobFlagDirty() && (bl || pSDEFormBase.getMobFlag() != null)) {
            iDataObject.set(FIELD_MOBFLAG, (Object)pSDEFormBase.getMobFlag());
        }
        if (pSDEFormBase.isNavBarHeightDirty() && (bl || pSDEFormBase.getNavBarHeight() != null)) {
            iDataObject.set(FIELD_NAVBARHEIGHT, (Object)pSDEFormBase.getNavBarHeight());
        }
        if (pSDEFormBase.isNavBarPosDirty() && (bl || pSDEFormBase.getNavBarPos() != null)) {
            iDataObject.set(FIELD_NAVBARPOS, (Object)pSDEFormBase.getNavBarPos());
        }
        if (pSDEFormBase.isNavBarPSSysCssIdDirty() && (bl || pSDEFormBase.getNavBarPSSysCssId() != null)) {
            iDataObject.set(FIELD_NAVBARPSSYSCSSID, (Object)pSDEFormBase.getNavBarPSSysCssId());
        }
        if (pSDEFormBase.isNavBarPSSysCssNameDirty() && (bl || pSDEFormBase.getNavBarPSSysCssName() != null)) {
            iDataObject.set(FIELD_NAVBARPSSYSCSSNAME, (Object)pSDEFormBase.getNavBarPSSysCssName());
        }
        if (pSDEFormBase.isNavBarStyleDirty() && (bl || pSDEFormBase.getNavBarStyle() != null)) {
            iDataObject.set(FIELD_NAVBARSTYLE, (Object)pSDEFormBase.getNavBarStyle());
        }
        if (pSDEFormBase.isNavBarWidthDirty() && (bl || pSDEFormBase.getNavBarWidth() != null)) {
            iDataObject.set(FIELD_NAVBARWIDTH, (Object)pSDEFormBase.getNavBarWidth());
        }
        if (pSDEFormBase.isPDVTParamDirty() && (bl || pSDEFormBase.getPDVTParam() != null)) {
            iDataObject.set(FIELD_PDVTPARAM, (Object)pSDEFormBase.getPDVTParam());
        }
        if (pSDEFormBase.isPSACHandlerIdDirty() && (bl || pSDEFormBase.getPSACHandlerId() != null)) {
            iDataObject.set(FIELD_PSACHANDLERID, (Object)pSDEFormBase.getPSACHandlerId());
        }
        if (pSDEFormBase.isPSACHandlerNameDirty() && (bl || pSDEFormBase.getPSACHandlerName() != null)) {
            iDataObject.set(FIELD_PSACHANDLERNAME, (Object)pSDEFormBase.getPSACHandlerName());
        }
        if (pSDEFormBase.isPSCtrlLogicGroupIdDirty() && (bl || pSDEFormBase.getPSCtrlLogicGroupId() != null)) {
            iDataObject.set(FIELD_PSCTRLLOGICGROUPID, (Object)pSDEFormBase.getPSCtrlLogicGroupId());
        }
        if (pSDEFormBase.isPSCtrlLogicGroupNameDirty() && (bl || pSDEFormBase.getPSCtrlLogicGroupName() != null)) {
            iDataObject.set(FIELD_PSCTRLLOGICGROUPNAME, (Object)pSDEFormBase.getPSCtrlLogicGroupName());
        }
        if (pSDEFormBase.isPSCtrlMsgIdDirty() && (bl || pSDEFormBase.getPSCtrlMsgId() != null)) {
            iDataObject.set(FIELD_PSCTRLMSGID, (Object)pSDEFormBase.getPSCtrlMsgId());
        }
        if (pSDEFormBase.isPSCtrlMsgNameDirty() && (bl || pSDEFormBase.getPSCtrlMsgName() != null)) {
            iDataObject.set(FIELD_PSCTRLMSGNAME, (Object)pSDEFormBase.getPSCtrlMsgName());
        }
        if (pSDEFormBase.isPSDEFInputTipSetIdDirty() && (bl || pSDEFormBase.getPSDEFInputTipSetId() != null)) {
            iDataObject.set(FIELD_PSDEFINPUTTIPSETID, (Object)pSDEFormBase.getPSDEFInputTipSetId());
        }
        if (pSDEFormBase.isPSDEFInputTipSetNameDirty() && (bl || pSDEFormBase.getPSDEFInputTipSetName() != null)) {
            iDataObject.set(FIELD_PSDEFINPUTTIPSETNAME, (Object)pSDEFormBase.getPSDEFInputTipSetName());
        }
        if (pSDEFormBase.isPSDEFormIdDirty() && (bl || pSDEFormBase.getPSDEFormId() != null)) {
            iDataObject.set(FIELD_PSDEFORMID, (Object)pSDEFormBase.getPSDEFormId());
        }
        if (pSDEFormBase.isPSDEFormNameDirty() && (bl || pSDEFormBase.getPSDEFormName() != null)) {
            iDataObject.set(FIELD_PSDEFORMNAME, (Object)pSDEFormBase.getPSDEFormName());
        }
        if (pSDEFormBase.isPSDEIdDirty() && (bl || pSDEFormBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEFormBase.getPSDEId());
        }
        if (pSDEFormBase.isPSDENameDirty() && (bl || pSDEFormBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEFormBase.getPSDEName());
        }
        if (pSDEFormBase.isPSDynaDEFormIdDirty() && (bl || pSDEFormBase.getPSDynaDEFormId() != null)) {
            iDataObject.set(FIELD_PSDYNADEFORMID, (Object)pSDEFormBase.getPSDynaDEFormId());
        }
        if (pSDEFormBase.isPSDynaDEFormInstIdDirty() && (bl || pSDEFormBase.getPSDynaDEFormInstId() != null)) {
            iDataObject.set(FIELD_PSDYNADEFORMINSTID, (Object)pSDEFormBase.getPSDynaDEFormInstId());
        }
        if (pSDEFormBase.isPSDynaDEFormInstNameDirty() && (bl || pSDEFormBase.getPSDynaDEFormInstName() != null)) {
            iDataObject.set(FIELD_PSDYNADEFORMINSTNAME, (Object)pSDEFormBase.getPSDynaDEFormInstName());
        }
        if (pSDEFormBase.isPSDynaDEFormNameDirty() && (bl || pSDEFormBase.getPSDynaDEFormName() != null)) {
            iDataObject.set(FIELD_PSDYNADEFORMNAME, (Object)pSDEFormBase.getPSDynaDEFormName());
        }
        if (pSDEFormBase.isPSDynaInstIdDirty() && (bl || pSDEFormBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSDEFormBase.getPSDynaInstId());
        }
        if (pSDEFormBase.isPSDynaInstNameDirty() && (bl || pSDEFormBase.getPSDynaInstName() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTNAME, (Object)pSDEFormBase.getPSDynaInstName());
        }
        if (pSDEFormBase.isPSPFIdDirty() && (bl || pSDEFormBase.getPSPFId() != null)) {
            iDataObject.set(FIELD_PSPFID, (Object)pSDEFormBase.getPSPFId());
        }
        if (pSDEFormBase.isPSPFNameDirty() && (bl || pSDEFormBase.getPSPFName() != null)) {
            iDataObject.set(FIELD_PSPFNAME, (Object)pSDEFormBase.getPSPFName());
        }
        if (pSDEFormBase.isPSSysCounterIdDirty() && (bl || pSDEFormBase.getPSSysCounterId() != null)) {
            iDataObject.set(FIELD_PSSYSCOUNTERID, (Object)pSDEFormBase.getPSSysCounterId());
        }
        if (pSDEFormBase.isPSSysCounterNameDirty() && (bl || pSDEFormBase.getPSSysCounterName() != null)) {
            iDataObject.set(FIELD_PSSYSCOUNTERNAME, (Object)pSDEFormBase.getPSSysCounterName());
        }
        if (pSDEFormBase.isPSSysCssIdDirty() && (bl || pSDEFormBase.getPSSysCssId() != null)) {
            iDataObject.set(FIELD_PSSYSCSSID, (Object)pSDEFormBase.getPSSysCssId());
        }
        if (pSDEFormBase.isPSSysCssNameDirty() && (bl || pSDEFormBase.getPSSysCssName() != null)) {
            iDataObject.set(FIELD_PSSYSCSSNAME, (Object)pSDEFormBase.getPSSysCssName());
        }
        if (pSDEFormBase.isPSSysDynaModelIdDirty() && (bl || pSDEFormBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSDEFormBase.getPSSysDynaModelId());
        }
        if (pSDEFormBase.isPSSysDynaModelNameDirty() && (bl || pSDEFormBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSDEFormBase.getPSSysDynaModelName());
        }
        if (pSDEFormBase.isPSSysPFPluginIdDirty() && (bl || pSDEFormBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSDEFormBase.getPSSysPFPluginId());
        }
        if (pSDEFormBase.isPSSysPFPluginNameDirty() && (bl || pSDEFormBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSDEFormBase.getPSSysPFPluginName());
        }
        if (pSDEFormBase.isPSSysReqItemIdDirty() && (bl || pSDEFormBase.getPSSysReqItemId() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMID, (Object)pSDEFormBase.getPSSysReqItemId());
        }
        if (pSDEFormBase.isPSSysReqItemNameDirty() && (bl || pSDEFormBase.getPSSysReqItemName() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMNAME, (Object)pSDEFormBase.getPSSysReqItemName());
        }
        if (pSDEFormBase.isPSViewMsgGroupIdDirty() && (bl || pSDEFormBase.getPSViewMsgGroupId() != null)) {
            iDataObject.set(FIELD_PSVIEWMSGGROUPID, (Object)pSDEFormBase.getPSViewMsgGroupId());
        }
        if (pSDEFormBase.isPSViewMsgGroupNameDirty() && (bl || pSDEFormBase.getPSViewMsgGroupName() != null)) {
            iDataObject.set(FIELD_PSVIEWMSGGROUPNAME, (Object)pSDEFormBase.getPSViewMsgGroupName());
        }
        if (pSDEFormBase.isPSWFDEIdDirty() && (bl || pSDEFormBase.getPSWFDEId() != null)) {
            iDataObject.set(FIELD_PSWFDEID, (Object)pSDEFormBase.getPSWFDEId());
        }
        if (pSDEFormBase.isPSWFDENameDirty() && (bl || pSDEFormBase.getPSWFDEName() != null)) {
            iDataObject.set(FIELD_PSWFDENAME, (Object)pSDEFormBase.getPSWFDEName());
        }
        if (pSDEFormBase.isPSWFIdDirty() && (bl || pSDEFormBase.getPSWFId() != null)) {
            iDataObject.set(FIELD_PSWFID, (Object)pSDEFormBase.getPSWFId());
        }
        if (pSDEFormBase.isRemovePSDEActionIdDirty() && (bl || pSDEFormBase.getRemovePSDEActionId() != null)) {
            iDataObject.set(FIELD_REMOVEPSDEACTIONID, (Object)pSDEFormBase.getRemovePSDEActionId());
        }
        if (pSDEFormBase.isRemovePSDEActionNameDirty() && (bl || pSDEFormBase.getRemovePSDEActionName() != null)) {
            iDataObject.set(FIELD_REMOVEPSDEACTIONNAME, (Object)pSDEFormBase.getRemovePSDEActionName());
        }
        if (pSDEFormBase.isSearchBtnPosDirty() && (bl || pSDEFormBase.getSearchBtnPos() != null)) {
            iDataObject.set(FIELD_SEARCHBTNPOS, (Object)pSDEFormBase.getSearchBtnPos());
        }
        if (pSDEFormBase.isSearchBtnStyleDirty() && (bl || pSDEFormBase.getSearchBtnStyle() != null)) {
            iDataObject.set(FIELD_SEARCHBTNSTYLE, (Object)pSDEFormBase.getSearchBtnStyle());
        }
        if (pSDEFormBase.isShowTabHeaderDirty() && (bl || pSDEFormBase.getShowTabHeader() != null)) {
            iDataObject.set(FIELD_SHOWTABHEADER, (Object)pSDEFormBase.getShowTabHeader());
        }
        if (pSDEFormBase.isSRFSysPubDirty() && (bl || pSDEFormBase.getSRFSysPub() != null)) {
            iDataObject.set(FIELD_SRFSYSPUB, (Object)pSDEFormBase.getSRFSysPub());
        }
        if (pSDEFormBase.isTabHeaderPosDirty() && (bl || pSDEFormBase.getTabHeaderPos() != null)) {
            iDataObject.set(FIELD_TABHEADERPOS, (Object)pSDEFormBase.getTabHeaderPos());
        }
        if (pSDEFormBase.isToDoTaskDirty() && (bl || pSDEFormBase.getToDoTask() != null)) {
            iDataObject.set(FIELD_TODOTASK, (Object)pSDEFormBase.getToDoTask());
        }
        if (pSDEFormBase.isUpdateDateDirty() && (bl || pSDEFormBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEFormBase.getUpdateDate());
        }
        if (pSDEFormBase.isUpdateManDirty() && (bl || pSDEFormBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEFormBase.getUpdateMan());
        }
        if (pSDEFormBase.isUpdatePSDEActionIdDirty() && (bl || pSDEFormBase.getUpdatePSDEActionId() != null)) {
            iDataObject.set(FIELD_UPDATEPSDEACTIONID, (Object)pSDEFormBase.getUpdatePSDEActionId());
        }
        if (pSDEFormBase.isUpdatePSDEActionNameDirty() && (bl || pSDEFormBase.getUpdatePSDEActionName() != null)) {
            iDataObject.set(FIELD_UPDATEPSDEACTIONNAME, (Object)pSDEFormBase.getUpdatePSDEActionName());
        }
        if (pSDEFormBase.isUser2PSDEActionIdDirty() && (bl || pSDEFormBase.getUser2PSDEActionId() != null)) {
            iDataObject.set(FIELD_USER2PSDEACTIONID, (Object)pSDEFormBase.getUser2PSDEActionId());
        }
        if (pSDEFormBase.isUser2PSDEActionNameDirty() && (bl || pSDEFormBase.getUser2PSDEActionName() != null)) {
            iDataObject.set(FIELD_USER2PSDEACTIONNAME, (Object)pSDEFormBase.getUser2PSDEActionName());
        }
        if (pSDEFormBase.isUserParamsDirty() && (bl || pSDEFormBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSDEFormBase.getUserParams());
        }
        if (pSDEFormBase.isUserPSDEActionIdDirty() && (bl || pSDEFormBase.getUserPSDEActionId() != null)) {
            iDataObject.set(FIELD_USERPSDEACTIONID, (Object)pSDEFormBase.getUserPSDEActionId());
        }
        if (pSDEFormBase.isUserPSDEActionNameDirty() && (bl || pSDEFormBase.getUserPSDEActionName() != null)) {
            iDataObject.set(FIELD_USERPSDEACTIONNAME, (Object)pSDEFormBase.getUserPSDEActionName());
        }
        if (pSDEFormBase.isUserTagDirty() && (bl || pSDEFormBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEFormBase.getUserTag());
        }
        if (pSDEFormBase.isUserTag2Dirty() && (bl || pSDEFormBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEFormBase.getUserTag2());
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
        return PSDEFormBase.remove(this, n);
    }

    private static boolean remove(PSDEFormBase pSDEFormBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEFormBase.resetBusyIndicator();
                return true;
            }
            case 1: {
                pSDEFormBase.resetCodeName();
                return true;
            }
            case 2: {
                pSDEFormBase.resetCopyPSDEActionId();
                return true;
            }
            case 3: {
                pSDEFormBase.resetCopyPSDEActionName();
                return true;
            }
            case 4: {
                pSDEFormBase.resetCreateDate();
                return true;
            }
            case 5: {
                pSDEFormBase.resetCreateMan();
                return true;
            }
            case 6: {
                pSDEFormBase.resetCreatePSDEActionId();
                return true;
            }
            case 7: {
                pSDEFormBase.resetCreatePSDEActionName();
                return true;
            }
            case 8: {
                pSDEFormBase.resetCtrlColSpan();
                return true;
            }
            case 9: {
                pSDEFormBase.resetDataType();
                return true;
            }
            case 10: {
                pSDEFormBase.resetDetailStyle();
                return true;
            }
            case 11: {
                pSDEFormBase.resetDynaModelFlag();
                return true;
            }
            case 12: {
                pSDEFormBase.resetDynaSysRefMode();
                return true;
            }
            case 13: {
                pSDEFormBase.resetEnableAdvSearch();
                return true;
            }
            case 14: {
                pSDEFormBase.resetEnableAutoSave();
                return true;
            }
            case 15: {
                pSDEFormBase.resetEnableCustomized();
                return true;
            }
            case 16: {
                pSDEFormBase.resetEnableFilterSave();
                return true;
            }
            case 17: {
                pSDEFormBase.resetEnableItemFilter();
                return true;
            }
            case 18: {
                pSDEFormBase.resetEnableItemPriv();
                return true;
            }
            case 19: {
                pSDEFormBase.resetFormItemStyle();
                return true;
            }
            case 20: {
                pSDEFormBase.resetFormModel();
                return true;
            }
            case 21: {
                pSDEFormBase.resetFormNavBar();
                return true;
            }
            case 22: {
                pSDEFormBase.resetFormSN();
                return true;
            }
            case 23: {
                pSDEFormBase.resetFormStyle();
                return true;
            }
            case 24: {
                pSDEFormBase.resetFormTag();
                return true;
            }
            case 25: {
                pSDEFormBase.resetFormTag2();
                return true;
            }
            case 26: {
                pSDEFormBase.resetFormTag3();
                return true;
            }
            case 27: {
                pSDEFormBase.resetFormTag4();
                return true;
            }
            case 28: {
                pSDEFormBase.resetFormType();
                return true;
            }
            case 29: {
                pSDEFormBase.resetFormWidth();
                return true;
            }
            case 30: {
                pSDEFormBase.resetFuncMode();
                return true;
            }
            case 31: {
                pSDEFormBase.resetGetDraftPSDEActionId();
                return true;
            }
            case 32: {
                pSDEFormBase.resetGetDraftPSDEActionName();
                return true;
            }
            case 33: {
                pSDEFormBase.resetGetPSDEActionId();
                return true;
            }
            case 34: {
                pSDEFormBase.resetGetPSDEActionName();
                return true;
            }
            case 35: {
                pSDEFormBase.resetInfoFormFlag();
                return true;
            }
            case 36: {
                pSDEFormBase.resetLabelColSpan();
                return true;
            }
            case 37: {
                pSDEFormBase.resetLabelColSpan2();
                return true;
            }
            case 38: {
                pSDEFormBase.resetLabelWidth();
                return true;
            }
            case 39: {
                pSDEFormBase.resetLayoutMode();
                return true;
            }
            case 40: {
                pSDEFormBase.resetLockFlag();
                return true;
            }
            case 41: {
                pSDEFormBase.resetMemo();
                return true;
            }
            case 42: {
                pSDEFormBase.resetMobFlag();
                return true;
            }
            case 43: {
                pSDEFormBase.resetNavBarHeight();
                return true;
            }
            case 44: {
                pSDEFormBase.resetNavBarPos();
                return true;
            }
            case 45: {
                pSDEFormBase.resetNavBarPSSysCssId();
                return true;
            }
            case 46: {
                pSDEFormBase.resetNavBarPSSysCssName();
                return true;
            }
            case 47: {
                pSDEFormBase.resetNavBarStyle();
                return true;
            }
            case 48: {
                pSDEFormBase.resetNavBarWidth();
                return true;
            }
            case 49: {
                pSDEFormBase.resetPDVTParam();
                return true;
            }
            case 50: {
                pSDEFormBase.resetPSACHandlerId();
                return true;
            }
            case 51: {
                pSDEFormBase.resetPSACHandlerName();
                return true;
            }
            case 52: {
                pSDEFormBase.resetPSCtrlLogicGroupId();
                return true;
            }
            case 53: {
                pSDEFormBase.resetPSCtrlLogicGroupName();
                return true;
            }
            case 54: {
                pSDEFormBase.resetPSCtrlMsgId();
                return true;
            }
            case 55: {
                pSDEFormBase.resetPSCtrlMsgName();
                return true;
            }
            case 56: {
                pSDEFormBase.resetPSDEFInputTipSetId();
                return true;
            }
            case 57: {
                pSDEFormBase.resetPSDEFInputTipSetName();
                return true;
            }
            case 58: {
                pSDEFormBase.resetPSDEFormId();
                return true;
            }
            case 59: {
                pSDEFormBase.resetPSDEFormName();
                return true;
            }
            case 60: {
                pSDEFormBase.resetPSDEId();
                return true;
            }
            case 61: {
                pSDEFormBase.resetPSDEName();
                return true;
            }
            case 62: {
                pSDEFormBase.resetPSDynaDEFormId();
                return true;
            }
            case 63: {
                pSDEFormBase.resetPSDynaDEFormInstId();
                return true;
            }
            case 64: {
                pSDEFormBase.resetPSDynaDEFormInstName();
                return true;
            }
            case 65: {
                pSDEFormBase.resetPSDynaDEFormName();
                return true;
            }
            case 66: {
                pSDEFormBase.resetPSDynaInstId();
                return true;
            }
            case 67: {
                pSDEFormBase.resetPSDynaInstName();
                return true;
            }
            case 68: {
                pSDEFormBase.resetPSPFId();
                return true;
            }
            case 69: {
                pSDEFormBase.resetPSPFName();
                return true;
            }
            case 70: {
                pSDEFormBase.resetPSSysCounterId();
                return true;
            }
            case 71: {
                pSDEFormBase.resetPSSysCounterName();
                return true;
            }
            case 72: {
                pSDEFormBase.resetPSSysCssId();
                return true;
            }
            case 73: {
                pSDEFormBase.resetPSSysCssName();
                return true;
            }
            case 74: {
                pSDEFormBase.resetPSSysDynaModelId();
                return true;
            }
            case 75: {
                pSDEFormBase.resetPSSysDynaModelName();
                return true;
            }
            case 76: {
                pSDEFormBase.resetPSSysPFPluginId();
                return true;
            }
            case 77: {
                pSDEFormBase.resetPSSysPFPluginName();
                return true;
            }
            case 78: {
                pSDEFormBase.resetPSSysReqItemId();
                return true;
            }
            case 79: {
                pSDEFormBase.resetPSSysReqItemName();
                return true;
            }
            case 80: {
                pSDEFormBase.resetPSViewMsgGroupId();
                return true;
            }
            case 81: {
                pSDEFormBase.resetPSViewMsgGroupName();
                return true;
            }
            case 82: {
                pSDEFormBase.resetPSWFDEId();
                return true;
            }
            case 83: {
                pSDEFormBase.resetPSWFDEName();
                return true;
            }
            case 84: {
                pSDEFormBase.resetPSWFId();
                return true;
            }
            case 85: {
                pSDEFormBase.resetRemovePSDEActionId();
                return true;
            }
            case 86: {
                pSDEFormBase.resetRemovePSDEActionName();
                return true;
            }
            case 87: {
                pSDEFormBase.resetSearchBtnPos();
                return true;
            }
            case 88: {
                pSDEFormBase.resetSearchBtnStyle();
                return true;
            }
            case 89: {
                pSDEFormBase.resetShowTabHeader();
                return true;
            }
            case 90: {
                pSDEFormBase.resetSRFSysPub();
                return true;
            }
            case 91: {
                pSDEFormBase.resetTabHeaderPos();
                return true;
            }
            case 92: {
                pSDEFormBase.resetToDoTask();
                return true;
            }
            case 93: {
                pSDEFormBase.resetUpdateDate();
                return true;
            }
            case 94: {
                pSDEFormBase.resetUpdateMan();
                return true;
            }
            case 95: {
                pSDEFormBase.resetUpdatePSDEActionId();
                return true;
            }
            case 96: {
                pSDEFormBase.resetUpdatePSDEActionName();
                return true;
            }
            case 97: {
                pSDEFormBase.resetUser2PSDEActionId();
                return true;
            }
            case 98: {
                pSDEFormBase.resetUser2PSDEActionName();
                return true;
            }
            case 99: {
                pSDEFormBase.resetUserParams();
                return true;
            }
            case 100: {
                pSDEFormBase.resetUserPSDEActionId();
                return true;
            }
            case 101: {
                pSDEFormBase.resetUserPSDEActionName();
                return true;
            }
            case 102: {
                pSDEFormBase.resetUserTag();
                return true;
            }
            case 103: {
                pSDEFormBase.resetUserTag2();
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
    public PSDEAction getCopyPSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCopyPSDEAction();
        }
        if (this.getCopyPSDEActionId() == null) {
            return null;
        }
        Integer n = this.objCopyPSDEActionLock;
        synchronized (n) {
            if (this.copypsdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getCopyPSDEActionId(), (Object)this.copypsdeaction.getPSDEActionId()) != 0L) {
                this.copypsdeaction = null;
            }
            if (this.copypsdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getCopyPSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet((IEntity)pSDEAction);
                this.copypsdeaction = pSDEAction;
            }
            return this.copypsdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEAction getCreatePSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreatePSDEAction();
        }
        if (this.getCreatePSDEActionId() == null) {
            return null;
        }
        Integer n = this.objCreatePSDEActionLock;
        synchronized (n) {
            if (this.createpsdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getCreatePSDEActionId(), (Object)this.createpsdeaction.getPSDEActionId()) != 0L) {
                this.createpsdeaction = null;
            }
            if (this.createpsdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getCreatePSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet((IEntity)pSDEAction);
                this.createpsdeaction = pSDEAction;
            }
            return this.createpsdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEAction getGetDraftPSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGetDraftPSDEAction();
        }
        if (this.getGetDraftPSDEActionId() == null) {
            return null;
        }
        Integer n = this.objGetDraftPSDEActionLock;
        synchronized (n) {
            if (this.getdraftpsdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getGetDraftPSDEActionId(), (Object)this.getdraftpsdeaction.getPSDEActionId()) != 0L) {
                this.getdraftpsdeaction = null;
            }
            if (this.getdraftpsdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getGetDraftPSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet((IEntity)pSDEAction);
                this.getdraftpsdeaction = pSDEAction;
            }
            return this.getdraftpsdeaction;
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
    public PSDEAction getRemovePSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRemovePSDEAction();
        }
        if (this.getRemovePSDEActionId() == null) {
            return null;
        }
        Integer n = this.objRemovePSDEActionLock;
        synchronized (n) {
            if (this.removepsdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getRemovePSDEActionId(), (Object)this.removepsdeaction.getPSDEActionId()) != 0L) {
                this.removepsdeaction = null;
            }
            if (this.removepsdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getRemovePSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet((IEntity)pSDEAction);
                this.removepsdeaction = pSDEAction;
            }
            return this.removepsdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEAction getUpdatePSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdatePSDEAction();
        }
        if (this.getUpdatePSDEActionId() == null) {
            return null;
        }
        Integer n = this.objUpdatePSDEActionLock;
        synchronized (n) {
            if (this.updatepsdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getUpdatePSDEActionId(), (Object)this.updatepsdeaction.getPSDEActionId()) != 0L) {
                this.updatepsdeaction = null;
            }
            if (this.updatepsdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getUpdatePSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet((IEntity)pSDEAction);
                this.updatepsdeaction = pSDEAction;
            }
            return this.updatepsdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEAction getUser2PSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUser2PSDEAction();
        }
        if (this.getUser2PSDEActionId() == null) {
            return null;
        }
        Integer n = this.objUser2PSDEActionLock;
        synchronized (n) {
            if (this.user2psdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getUser2PSDEActionId(), (Object)this.user2psdeaction.getPSDEActionId()) != 0L) {
                this.user2psdeaction = null;
            }
            if (this.user2psdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getUser2PSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet((IEntity)pSDEAction);
                this.user2psdeaction = pSDEAction;
            }
            return this.user2psdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEAction getUserPSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserPSDEAction();
        }
        if (this.getUserPSDEActionId() == null) {
            return null;
        }
        Integer n = this.objUserPSDEActionLock;
        synchronized (n) {
            if (this.userpsdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getUserPSDEActionId(), (Object)this.userpsdeaction.getPSDEActionId()) != 0L) {
                this.userpsdeaction = null;
            }
            if (this.userpsdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getUserPSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet((IEntity)pSDEAction);
                this.userpsdeaction = pSDEAction;
            }
            return this.userpsdeaction;
        }
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
                pSDEFInputTipSetService.autoGet((IEntity)pSDEFInputTipSet);
                this.psdefinputtipset = pSDEFInputTipSet;
            }
            return this.psdefinputtipset;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDynaDEForm getPSDynaDEForm() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaDEForm();
        }
        if (this.getPSDynaDEFormId() == null) {
            return null;
        }
        Integer n = this.objPSDynaDEFormLock;
        synchronized (n) {
            if (this.psdynadeform != null && DataTypeHelper.compare((int)25, (Object)this.getPSDynaDEFormId(), (Object)this.psdynadeform.getPSDynaDEFormId()) != 0L) {
                this.psdynadeform = null;
            }
            if (this.psdynadeform == null) {
                PSDynaDEForm pSDynaDEForm = new PSDynaDEForm();
                pSDynaDEForm.setPSDynaDEFormId(this.getPSDynaDEFormId());
                PSDynaDEFormService pSDynaDEFormService = (PSDynaDEFormService)ServiceGlobal.getService(PSDynaDEFormService.class, (SessionFactory)this.getSessionFactory());
                pSDynaDEFormService.autoGet((IEntity)pSDynaDEForm);
                this.psdynadeform = pSDynaDEForm;
            }
            return this.psdynadeform;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDynaInst getPSDynaInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaInst();
        }
        if (this.getPSDynaInstId() == null) {
            return null;
        }
        Integer n = this.objPSDynaInstLock;
        synchronized (n) {
            if (this.psdynainst != null && DataTypeHelper.compare((int)25, (Object)this.getPSDynaInstId(), (Object)this.psdynainst.getPSDynaInstId()) != 0L) {
                this.psdynainst = null;
            }
            if (this.psdynainst == null) {
                PSDynaInst pSDynaInst = new PSDynaInst();
                pSDynaInst.setPSDynaInstId(this.getPSDynaInstId());
                PSDynaInstService pSDynaInstService = (PSDynaInstService)ServiceGlobal.getService(PSDynaInstService.class, (SessionFactory)this.getSessionFactory());
                pSDynaInstService.autoGet((IEntity)pSDynaInst);
                this.psdynainst = pSDynaInst;
            }
            return this.psdynainst;
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
                pSPFService.autoGet((IEntity)pSPF);
                this.pspf = pSPF;
            }
            return this.pspf;
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
                pSSysCounterService.autoGet((IEntity)pSSysCounter);
                this.pssyscounter = pSSysCounter;
            }
            return this.pssyscounter;
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
    public PSWFDE getPSWFDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFDE();
        }
        if (this.getPSWFDEId() == null) {
            return null;
        }
        Integer n = this.objPSWFDELock;
        synchronized (n) {
            if (this.pswfde != null && DataTypeHelper.compare((int)25, (Object)this.getPSWFDEId(), (Object)this.pswfde.getPSWFDEId()) != 0L) {
                this.pswfde = null;
            }
            if (this.pswfde == null) {
                PSWFDE pSWFDE = new PSWFDE();
                pSWFDE.setPSWFDEId(this.getPSWFDEId());
                PSWFDEService pSWFDEService = (PSWFDEService)ServiceGlobal.getService(PSWFDEService.class, (SessionFactory)this.getSessionFactory());
                pSWFDEService.autoGet((IEntity)pSWFDE);
                this.pswfde = pSWFDE;
            }
            return this.pswfde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEFIUpdate> getPSDEFIUpdates() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFIUpdates();
        }
        if (this.getPSDEFormId() == null) {
            return null;
        }
        PSDEFormService pSDEFormService = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
        PSDEFIUpdateService pSDEFIUpdateService = (PSDEFIUpdateService)ServiceGlobal.getService(PSDEFIUpdateService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEFIUpdatesLock;
        synchronized (n) {
            if (this.psdefiupdates == null) {
                this.psdefiupdates = pSDEFormService.isTempData((IEntity)this) ? pSDEFIUpdateService.selectTempByPSDEForm(this) : pSDEFIUpdateService.selectByPSDEForm(this);
            }
            return this.psdefiupdates;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEFormDetail> getPSDEFormDetails() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFormDetails();
        }
        if (this.getPSDEFormId() == null) {
            return null;
        }
        PSDEFormService pSDEFormService = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
        PSDEFormDetailService pSDEFormDetailService = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEFormDetailsLock;
        synchronized (n) {
            if (this.psdeformdetails == null) {
                this.psdeformdetails = pSDEFormService.isTempData((IEntity)this) ? pSDEFormDetailService.selectTempByPSDEForm(this) : pSDEFormDetailService.selectByPSDEForm(this);
            }
            return this.psdeformdetails;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEFormLogic> getPSDEFormLogics() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFormLogics();
        }
        if (this.getPSDEFormId() == null) {
            return null;
        }
        PSDEFormService pSDEFormService = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
        PSDEFormLogicService pSDEFormLogicService = (PSDEFormLogicService)ServiceGlobal.getService(PSDEFormLogicService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEFormLogicsLock;
        synchronized (n) {
            if (this.psdeformlogics == null) {
                this.psdeformlogics = pSDEFormService.isTempData((IEntity)this) ? pSDEFormLogicService.selectTempByPSDEForm(this) : pSDEFormLogicService.selectByPSDEForm(this);
            }
            return this.psdeformlogics;
        }
    }

    private PSDEFormBase getProxyEntity() {
        return this.proxyPSDEFormBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEFormBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEFormBase) {
            this.proxyPSDEFormBase = (PSDEFormBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BUSYINDICATOR, 0);
        fieldIndexMap.put(FIELD_CODENAME, 1);
        fieldIndexMap.put(FIELD_COPYPSDEACTIONID, 2);
        fieldIndexMap.put(FIELD_COPYPSDEACTIONNAME, 3);
        fieldIndexMap.put(FIELD_CREATEDATE, 4);
        fieldIndexMap.put(FIELD_CREATEMAN, 5);
        fieldIndexMap.put(FIELD_CREATEPSDEACTIONID, 6);
        fieldIndexMap.put(FIELD_CREATEPSDEACTIONNAME, 7);
        fieldIndexMap.put(FIELD_CTRLCOLSPAN, 8);
        fieldIndexMap.put(FIELD_DATATYPE, 9);
        fieldIndexMap.put(FIELD_DETAILSTYLE, 10);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 11);
        fieldIndexMap.put(FIELD_DYNASYSREFMODE, 12);
        fieldIndexMap.put(FIELD_ENABLEADVSEARCH, 13);
        fieldIndexMap.put(FIELD_ENABLEAUTOSAVE, 14);
        fieldIndexMap.put(FIELD_ENABLECUSTOMIZED, 15);
        fieldIndexMap.put(FIELD_ENABLEFILTERSAVE, 16);
        fieldIndexMap.put(FIELD_ENABLEITEMFILTER, 17);
        fieldIndexMap.put(FIELD_ENABLEITEMPRIV, 18);
        fieldIndexMap.put(FIELD_FORMITEMSTYLE, 19);
        fieldIndexMap.put(FIELD_FORMMODEL, 20);
        fieldIndexMap.put(FIELD_FORMNAVBAR, 21);
        fieldIndexMap.put(FIELD_FORMSN, 22);
        fieldIndexMap.put(FIELD_FORMSTYLE, 23);
        fieldIndexMap.put(FIELD_FORMTAG, 24);
        fieldIndexMap.put(FIELD_FORMTAG2, 25);
        fieldIndexMap.put(FIELD_FORMTAG3, 26);
        fieldIndexMap.put(FIELD_FORMTAG4, 27);
        fieldIndexMap.put(FIELD_FORMTYPE, 28);
        fieldIndexMap.put(FIELD_FORMWIDTH, 29);
        fieldIndexMap.put(FIELD_FUNCMODE, 30);
        fieldIndexMap.put(FIELD_GETDRAFTPSDEACTIONID, 31);
        fieldIndexMap.put(FIELD_GETDRAFTPSDEACTIONNAME, 32);
        fieldIndexMap.put(FIELD_GETPSDEACTIONID, 33);
        fieldIndexMap.put(FIELD_GETPSDEACTIONNAME, 34);
        fieldIndexMap.put(FIELD_INFOFORMFLAG, 35);
        fieldIndexMap.put(FIELD_LABELCOLSPAN, 36);
        fieldIndexMap.put(FIELD_LABELCOLSPAN2, 37);
        fieldIndexMap.put(FIELD_LABELWIDTH, 38);
        fieldIndexMap.put(FIELD_LAYOUTMODE, 39);
        fieldIndexMap.put(FIELD_LOCKFLAG, 40);
        fieldIndexMap.put(FIELD_MEMO, 41);
        fieldIndexMap.put(FIELD_MOBFLAG, 42);
        fieldIndexMap.put(FIELD_NAVBARHEIGHT, 43);
        fieldIndexMap.put(FIELD_NAVBARPOS, 44);
        fieldIndexMap.put(FIELD_NAVBARPSSYSCSSID, 45);
        fieldIndexMap.put(FIELD_NAVBARPSSYSCSSNAME, 46);
        fieldIndexMap.put(FIELD_NAVBARSTYLE, 47);
        fieldIndexMap.put(FIELD_NAVBARWIDTH, 48);
        fieldIndexMap.put(FIELD_PDVTPARAM, 49);
        fieldIndexMap.put(FIELD_PSACHANDLERID, 50);
        fieldIndexMap.put(FIELD_PSACHANDLERNAME, 51);
        fieldIndexMap.put(FIELD_PSCTRLLOGICGROUPID, 52);
        fieldIndexMap.put(FIELD_PSCTRLLOGICGROUPNAME, 53);
        fieldIndexMap.put(FIELD_PSCTRLMSGID, 54);
        fieldIndexMap.put(FIELD_PSCTRLMSGNAME, 55);
        fieldIndexMap.put(FIELD_PSDEFINPUTTIPSETID, 56);
        fieldIndexMap.put(FIELD_PSDEFINPUTTIPSETNAME, 57);
        fieldIndexMap.put(FIELD_PSDEFORMID, 58);
        fieldIndexMap.put(FIELD_PSDEFORMNAME, 59);
        fieldIndexMap.put(FIELD_PSDEID, 60);
        fieldIndexMap.put(FIELD_PSDENAME, 61);
        fieldIndexMap.put(FIELD_PSDYNADEFORMID, 62);
        fieldIndexMap.put(FIELD_PSDYNADEFORMINSTID, 63);
        fieldIndexMap.put(FIELD_PSDYNADEFORMINSTNAME, 64);
        fieldIndexMap.put(FIELD_PSDYNADEFORMNAME, 65);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 66);
        fieldIndexMap.put(FIELD_PSDYNAINSTNAME, 67);
        fieldIndexMap.put(FIELD_PSPFID, 68);
        fieldIndexMap.put(FIELD_PSPFNAME, 69);
        fieldIndexMap.put(FIELD_PSSYSCOUNTERID, 70);
        fieldIndexMap.put(FIELD_PSSYSCOUNTERNAME, 71);
        fieldIndexMap.put(FIELD_PSSYSCSSID, 72);
        fieldIndexMap.put(FIELD_PSSYSCSSNAME, 73);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 74);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 75);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 76);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 77);
        fieldIndexMap.put(FIELD_PSSYSREQITEMID, 78);
        fieldIndexMap.put(FIELD_PSSYSREQITEMNAME, 79);
        fieldIndexMap.put(FIELD_PSVIEWMSGGROUPID, 80);
        fieldIndexMap.put(FIELD_PSVIEWMSGGROUPNAME, 81);
        fieldIndexMap.put(FIELD_PSWFDEID, 82);
        fieldIndexMap.put(FIELD_PSWFDENAME, 83);
        fieldIndexMap.put(FIELD_PSWFID, 84);
        fieldIndexMap.put(FIELD_REMOVEPSDEACTIONID, 85);
        fieldIndexMap.put(FIELD_REMOVEPSDEACTIONNAME, 86);
        fieldIndexMap.put(FIELD_SEARCHBTNPOS, 87);
        fieldIndexMap.put(FIELD_SEARCHBTNSTYLE, 88);
        fieldIndexMap.put(FIELD_SHOWTABHEADER, 89);
        fieldIndexMap.put(FIELD_SRFSYSPUB, 90);
        fieldIndexMap.put(FIELD_TABHEADERPOS, 91);
        fieldIndexMap.put(FIELD_TODOTASK, 92);
        fieldIndexMap.put(FIELD_UPDATEDATE, 93);
        fieldIndexMap.put(FIELD_UPDATEMAN, 94);
        fieldIndexMap.put(FIELD_UPDATEPSDEACTIONID, 95);
        fieldIndexMap.put(FIELD_UPDATEPSDEACTIONNAME, 96);
        fieldIndexMap.put(FIELD_USER2PSDEACTIONID, 97);
        fieldIndexMap.put(FIELD_USER2PSDEACTIONNAME, 98);
        fieldIndexMap.put(FIELD_USERPARAMS, 99);
        fieldIndexMap.put(FIELD_USERPSDEACTIONID, 100);
        fieldIndexMap.put(FIELD_USERPSDEACTIONNAME, 101);
        fieldIndexMap.put(FIELD_USERTAG, 102);
        fieldIndexMap.put(FIELD_USERTAG2, 103);
    }
}

