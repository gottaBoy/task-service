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
import net.ibizsys.pscore.srv.config.entity.PSSFACHandler;
import net.ibizsys.pscore.srv.config.service.PSSFACHandlerService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPriv;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSACHandlerAction;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTask;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniState;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUserDR;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerActionService;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysTaskService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUniStateService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUserDRService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSACHandlerBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSACHandlerBase.class);
    public static final String FIELD_CACHESCOPE = "CACHESCOPE";
    public static final String FIELD_CACHETIMEOUT = "CACHETIMEOUT";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_COPYPSDEACTIONID = "COPYPSDEACTIONID";
    public static final String FIELD_COPYPSDEACTIONNAME = "COPYPSDEACTIONNAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CREATEPSDEACTIONID = "CREATEPSDEACTIONID";
    public static final String FIELD_CREATEPSDEACTIONNAME = "CREATEPSDEACTIONNAME";
    public static final String FIELD_CREATEPSDEOPPRIVID = "CREATEPSDEOPPRIVID";
    public static final String FIELD_CREATEPSDEOPPRIVINAME = "CREATEPSDEOPPRIVINAME";
    public static final String FIELD_CREATETIMEOUT = "CREATETIMEOUT";
    public static final String FIELD_CTRLTYPE = "CTRLTYPE";
    public static final String FIELD_CUSTOMCOND = "CUSTOMCOND";
    public static final String FIELD_CUSTOMTYPE = "CUSTOMTYPE";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_ENABLECACHE = "ENABLECACHE";
    public static final String FIELD_ENABLEORGDR = "ENABLEORGDR";
    public static final String FIELD_ENABLESECBC = "ENABLESECBC";
    public static final String FIELD_ENABLESECDR = "ENABLESECDR";
    public static final String FIELD_ENABLEUSERDR = "ENABLEUSERDR";
    public static final String FIELD_EXPORTPSDEOPPRIVID = "EXPORTPSDEOPPRIVID";
    public static final String FIELD_EXPORTPSDEOPPRIVNAME = "EXPORTPSDEOPPRIVINAME";
    public static final String FIELD_FETCHTIMEOUT = "FETCHTIMEOUT";
    public static final String FIELD_FINISHFLAG = "FINISHFLAG";
    public static final String FIELD_GETDRAFTPSDEACTIONID = "GETDRAFTPSDEACTIONID";
    public static final String FIELD_GETDRAFTPSDEACTIONNAME = "GETDRAFTPSDEACTIONNAME";
    public static final String FIELD_GETPSDEACTIONID = "GETPSDEACTIONID";
    public static final String FIELD_GETPSDEACTIONNAME = "GETPSDEACTIONNAME";
    public static final String FIELD_GETTIMEOUT = "GETTIMEOUT";
    public static final String FIELD_GROUPMOVEPSDEACTIONID = "GROUPMOVEPSDEACTIONID";
    public static final String FIELD_GROUPMOVEPSDEACTIONNAME = "GROUPMOVEPSDEACTIONNAME";
    public static final String FIELD_GROUPPSDEID = "GROUPPSDEID";
    public static final String FIELD_GROUPPSDENAME = "GROUPPSDENAME";
    public static final String FIELD_HANDLEROBJ = "HANDLEROBJ";
    public static final String FIELD_HANDLEROBJ2 = "HANDLEROBJ2";
    public static final String FIELD_HANDLERPARAMS = "HANDLERPARAMS";
    public static final String FIELD_HANDLERTAG = "HANDLERTAG";
    public static final String FIELD_HANDLERTAG2 = "HANDLERTAG2";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MOVEPSDEACTIONID = "MOVEPSDEACTIONID";
    public static final String FIELD_MOVEPSDEACTIONNAME = "MOVEPSDEACTIONNAME";
    public static final String FIELD_ORGDR = "ORGDR";
    public static final String FIELD_PSACHANDLERID = "PSACHANDLERID";
    public static final String FIELD_PSACHANDLERNAME = "PSACHANDLERNAME";
    public static final String FIELD_PSDEDATASETID = "PSDEDATASETID";
    public static final String FIELD_PSDEDATASETNAME = "PSDEDATASETNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSFACHANDLERID = "PSSFACHANDLERID";
    public static final String FIELD_PSSFACHANDLERNAME = "PSSFACHANDLERNAME";
    public static final String FIELD_PSSFID = "PSSFID";
    public static final String FIELD_PSSFNAME = "PSSFNAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSREQITEMID = "PSSYSREQITEMID";
    public static final String FIELD_PSSYSREQITEMNAME = "PSSYSREQITEMNAME";
    public static final String FIELD_PSSYSTASKID = "PSSYSTASKID";
    public static final String FIELD_PSSYSTASKNAME = "PSSYSTASKNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSSYSUNISTATEID = "PSSYSUNISTATEID";
    public static final String FIELD_PSSYSUNISTATENAME = "PSSYSUNISTATENAME";
    public static final String FIELD_PSSYSUSERDRID = "PSSYSUSERDRID";
    public static final String FIELD_PSSYSUSERDRID2 = "PSSYSUSERDRID2";
    public static final String FIELD_PSSYSUSERDRNAME = "PSSYSUSERDRNAME";
    public static final String FIELD_PSSYSUSERDRNAME2 = "PSSYSUSERDRNAME2";
    public static final String FIELD_READPSDEOPPRIVID = "READPSDEOPPRIVID";
    public static final String FIELD_READPSDEOPPRIVNAME = "READPSDEOPPRIVNAME";
    public static final String FIELD_REMOVEPSDEACTIONID = "REMOVEPSDEACTIONID";
    public static final String FIELD_REMOVEPSDEACTIONNAME = "REMOVEPSDEACTIONNAME";
    public static final String FIELD_REMOVEPSDEOPPRIVID = "REMOVEPSDEOPPRIVID";
    public static final String FIELD_REMOVEPSDEOPPRIVNAME = "REMOVEPSDEOPPRIVNAME";
    public static final String FIELD_REMOVETIMEOUT = "REMOVETIMEOUT";
    public static final String FIELD_SECBC = "SECBC";
    public static final String FIELD_SECDR = "SECDR";
    public static final String FIELD_SYSUSERDR2PARAM = "SYSUSERDR2PARAM";
    public static final String FIELD_SYSUSERDRPARAM = "SYSUSERDRPARAM";
    public static final String FIELD_TEMPMODE = "TEMPMODE";
    public static final String FIELD_TODOTASK = "TODOTASK";
    public static final String FIELD_UNISTATEFIELD = "UNISTATEFIELD";
    public static final String FIELD_UNISTATEKEYVALUE = "UNISTATEKEYVALUE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_UPDATEPSDEACTIONID = "UPDATEPSDEACTIONID";
    public static final String FIELD_UPDATEPSDEACTIONNAME = "UPDATEPSDEACTIONNAME";
    public static final String FIELD_UPDATEPSDEOPPRIVID = "UPDATEPSDEOPPRIVID";
    public static final String FIELD_UPDATEPSDEOPPRIVNAME = "UPDATEPSDEOPPRIVNAME";
    public static final String FIELD_UPDATETIMEOUT = "UPDATETIMEOUT";
    public static final String FIELD_USER2PSDEACTIONID = "USER2PSDEACTIONID";
    public static final String FIELD_USER2PSDEACTIONNAME = "USER2PSDEACTIONNAME";
    public static final String FIELD_USER2PSDEOPPRIVID = "USER2PSDEOPPRIVID";
    public static final String FIELD_USER2PSDEOPPRIVNAME = "USER2PSDEOPPRIVINAME";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    public static final String FIELD_USERPSDEACTIONID = "USERPSDEACTIONID";
    public static final String FIELD_USERPSDEACTIONNAME = "USERPSDEACTIONNAME";
    public static final String FIELD_USERPSDEOPPRIVID = "USERPSDEOPPRIVID";
    public static final String FIELD_USERPSDEOPPRIVNAME = "USERPSDEOPPRIVINAME";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CACHESCOPE = 0;
    private static final int INDEX_CACHETIMEOUT = 1;
    private static final int INDEX_CODENAME = 2;
    private static final int INDEX_COPYPSDEACTIONID = 3;
    private static final int INDEX_COPYPSDEACTIONNAME = 4;
    private static final int INDEX_CREATEDATE = 5;
    private static final int INDEX_CREATEMAN = 6;
    private static final int INDEX_CREATEPSDEACTIONID = 7;
    private static final int INDEX_CREATEPSDEACTIONNAME = 8;
    private static final int INDEX_CREATEPSDEOPPRIVID = 9;
    private static final int INDEX_CREATEPSDEOPPRIVINAME = 10;
    private static final int INDEX_CREATETIMEOUT = 11;
    private static final int INDEX_CTRLTYPE = 12;
    private static final int INDEX_CUSTOMCOND = 13;
    private static final int INDEX_CUSTOMTYPE = 14;
    private static final int INDEX_DYNAMODELFLAG = 15;
    private static final int INDEX_ENABLECACHE = 16;
    private static final int INDEX_ENABLEORGDR = 17;
    private static final int INDEX_ENABLESECBC = 18;
    private static final int INDEX_ENABLESECDR = 19;
    private static final int INDEX_ENABLEUSERDR = 20;
    private static final int INDEX_EXPORTPSDEOPPRIVID = 21;
    private static final int INDEX_EXPORTPSDEOPPRIVNAME = 22;
    private static final int INDEX_FETCHTIMEOUT = 23;
    private static final int INDEX_FINISHFLAG = 24;
    private static final int INDEX_GETDRAFTPSDEACTIONID = 25;
    private static final int INDEX_GETDRAFTPSDEACTIONNAME = 26;
    private static final int INDEX_GETPSDEACTIONID = 27;
    private static final int INDEX_GETPSDEACTIONNAME = 28;
    private static final int INDEX_GETTIMEOUT = 29;
    private static final int INDEX_GROUPMOVEPSDEACTIONID = 30;
    private static final int INDEX_GROUPMOVEPSDEACTIONNAME = 31;
    private static final int INDEX_GROUPPSDEID = 32;
    private static final int INDEX_GROUPPSDENAME = 33;
    private static final int INDEX_HANDLEROBJ = 34;
    private static final int INDEX_HANDLEROBJ2 = 35;
    private static final int INDEX_HANDLERPARAMS = 36;
    private static final int INDEX_HANDLERTAG = 37;
    private static final int INDEX_HANDLERTAG2 = 38;
    private static final int INDEX_LOCKFLAG = 39;
    private static final int INDEX_MEMO = 40;
    private static final int INDEX_MOVEPSDEACTIONID = 41;
    private static final int INDEX_MOVEPSDEACTIONNAME = 42;
    private static final int INDEX_ORGDR = 43;
    private static final int INDEX_PSACHANDLERID = 44;
    private static final int INDEX_PSACHANDLERNAME = 45;
    private static final int INDEX_PSDEDATASETID = 46;
    private static final int INDEX_PSDEDATASETNAME = 47;
    private static final int INDEX_PSDEID = 48;
    private static final int INDEX_PSDENAME = 49;
    private static final int INDEX_PSDYNAINSTID = 50;
    private static final int INDEX_PSMODULEID = 51;
    private static final int INDEX_PSMODULENAME = 52;
    private static final int INDEX_PSSFACHANDLERID = 53;
    private static final int INDEX_PSSFACHANDLERNAME = 54;
    private static final int INDEX_PSSFID = 55;
    private static final int INDEX_PSSFNAME = 56;
    private static final int INDEX_PSSYSDYNAMODELID = 57;
    private static final int INDEX_PSSYSDYNAMODELNAME = 58;
    private static final int INDEX_PSSYSREQITEMID = 59;
    private static final int INDEX_PSSYSREQITEMNAME = 60;
    private static final int INDEX_PSSYSTASKID = 61;
    private static final int INDEX_PSSYSTASKNAME = 62;
    private static final int INDEX_PSSYSTEMID = 63;
    private static final int INDEX_PSSYSTEMNAME = 64;
    private static final int INDEX_PSSYSUNISTATEID = 65;
    private static final int INDEX_PSSYSUNISTATENAME = 66;
    private static final int INDEX_PSSYSUSERDRID = 67;
    private static final int INDEX_PSSYSUSERDRID2 = 68;
    private static final int INDEX_PSSYSUSERDRNAME = 69;
    private static final int INDEX_PSSYSUSERDRNAME2 = 70;
    private static final int INDEX_READPSDEOPPRIVID = 71;
    private static final int INDEX_READPSDEOPPRIVNAME = 72;
    private static final int INDEX_REMOVEPSDEACTIONID = 73;
    private static final int INDEX_REMOVEPSDEACTIONNAME = 74;
    private static final int INDEX_REMOVEPSDEOPPRIVID = 75;
    private static final int INDEX_REMOVEPSDEOPPRIVNAME = 76;
    private static final int INDEX_REMOVETIMEOUT = 77;
    private static final int INDEX_SECBC = 78;
    private static final int INDEX_SECDR = 79;
    private static final int INDEX_SYSUSERDR2PARAM = 80;
    private static final int INDEX_SYSUSERDRPARAM = 81;
    private static final int INDEX_TEMPMODE = 82;
    private static final int INDEX_TODOTASK = 83;
    private static final int INDEX_UNISTATEFIELD = 84;
    private static final int INDEX_UNISTATEKEYVALUE = 85;
    private static final int INDEX_UPDATEDATE = 86;
    private static final int INDEX_UPDATEMAN = 87;
    private static final int INDEX_UPDATEPSDEACTIONID = 88;
    private static final int INDEX_UPDATEPSDEACTIONNAME = 89;
    private static final int INDEX_UPDATEPSDEOPPRIVID = 90;
    private static final int INDEX_UPDATEPSDEOPPRIVNAME = 91;
    private static final int INDEX_UPDATETIMEOUT = 92;
    private static final int INDEX_USER2PSDEACTIONID = 93;
    private static final int INDEX_USER2PSDEACTIONNAME = 94;
    private static final int INDEX_USER2PSDEOPPRIVID = 95;
    private static final int INDEX_USER2PSDEOPPRIVNAME = 96;
    private static final int INDEX_USERCAT = 97;
    private static final int INDEX_USERPARAMS = 98;
    private static final int INDEX_USERPSDEACTIONID = 99;
    private static final int INDEX_USERPSDEACTIONNAME = 100;
    private static final int INDEX_USERPSDEOPPRIVID = 101;
    private static final int INDEX_USERPSDEOPPRIVNAME = 102;
    private static final int INDEX_USERTAG = 103;
    private static final int INDEX_USERTAG2 = 104;
    private static final int INDEX_USERTAG3 = 105;
    private static final int INDEX_USERTAG4 = 106;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSACHandlerBase proxyPSACHandlerBase = null;
    private boolean cachescopeDirtyFlag = false;
    private boolean cachetimeoutDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean copypsdeactionidDirtyFlag = false;
    private boolean copypsdeactionnameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean createpsdeactionidDirtyFlag = false;
    private boolean createpsdeactionnameDirtyFlag = false;
    private boolean createpsdeopprividDirtyFlag = false;
    private boolean createpsdeopprivinameDirtyFlag = false;
    private boolean createtimeoutDirtyFlag = false;
    private boolean ctrltypeDirtyFlag = false;
    private boolean customcondDirtyFlag = false;
    private boolean customtypeDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean enablecacheDirtyFlag = false;
    private boolean enableorgdrDirtyFlag = false;
    private boolean enablesecbcDirtyFlag = false;
    private boolean enablesecdrDirtyFlag = false;
    private boolean enableuserdrDirtyFlag = false;
    private boolean exportpsdeopprividDirtyFlag = false;
    private boolean exportpsdeopprivnameDirtyFlag = false;
    private boolean fetchtimeoutDirtyFlag = false;
    private boolean finishflagDirtyFlag = false;
    private boolean getdraftpsdeactionidDirtyFlag = false;
    private boolean getdraftpsdeactionnameDirtyFlag = false;
    private boolean getpsdeactionidDirtyFlag = false;
    private boolean getpsdeactionnameDirtyFlag = false;
    private boolean gettimeoutDirtyFlag = false;
    private boolean groupmovepsdeactionidDirtyFlag = false;
    private boolean groupmovepsdeactionnameDirtyFlag = false;
    private boolean grouppsdeidDirtyFlag = false;
    private boolean grouppsdenameDirtyFlag = false;
    private boolean handlerobjDirtyFlag = false;
    private boolean handlerobj2DirtyFlag = false;
    private boolean handlerparamsDirtyFlag = false;
    private boolean handlertagDirtyFlag = false;
    private boolean handlertag2DirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean movepsdeactionidDirtyFlag = false;
    private boolean movepsdeactionnameDirtyFlag = false;
    private boolean orgdrDirtyFlag = false;
    private boolean psachandleridDirtyFlag = false;
    private boolean psachandlernameDirtyFlag = false;
    private boolean psdedatasetidDirtyFlag = false;
    private boolean psdedatasetnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssfachandleridDirtyFlag = false;
    private boolean pssfachandlernameDirtyFlag = false;
    private boolean pssfidDirtyFlag = false;
    private boolean pssfnameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssysreqitemidDirtyFlag = false;
    private boolean pssysreqitemnameDirtyFlag = false;
    private boolean pssystaskidDirtyFlag = false;
    private boolean pssystasknameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean pssysunistateidDirtyFlag = false;
    private boolean pssysunistatenameDirtyFlag = false;
    private boolean pssysuserdridDirtyFlag = false;
    private boolean pssysuserdrid2DirtyFlag = false;
    private boolean pssysuserdrnameDirtyFlag = false;
    private boolean pssysuserdrname2DirtyFlag = false;
    private boolean readpsdeopprividDirtyFlag = false;
    private boolean readpsdeopprivnameDirtyFlag = false;
    private boolean removepsdeactionidDirtyFlag = false;
    private boolean removepsdeactionnameDirtyFlag = false;
    private boolean removepsdeopprividDirtyFlag = false;
    private boolean removepsdeopprivnameDirtyFlag = false;
    private boolean removetimeoutDirtyFlag = false;
    private boolean secbcDirtyFlag = false;
    private boolean secdrDirtyFlag = false;
    private boolean sysuserdr2paramDirtyFlag = false;
    private boolean sysuserdrparamDirtyFlag = false;
    private boolean tempmodeDirtyFlag = false;
    private boolean todotaskDirtyFlag = false;
    private boolean unistatefieldDirtyFlag = false;
    private boolean unistatekeyvalueDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean updatepsdeactionidDirtyFlag = false;
    private boolean updatepsdeactionnameDirtyFlag = false;
    private boolean updatepsdeopprividDirtyFlag = false;
    private boolean updatepsdeopprivnameDirtyFlag = false;
    private boolean updatetimeoutDirtyFlag = false;
    private boolean user2psdeactionidDirtyFlag = false;
    private boolean user2psdeactionnameDirtyFlag = false;
    private boolean user2psdeopprividDirtyFlag = false;
    private boolean user2psdeopprivnameDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    private boolean userpsdeactionidDirtyFlag = false;
    private boolean userpsdeactionnameDirtyFlag = false;
    private boolean userpsdeopprividDirtyFlag = false;
    private boolean userpsdeopprivnameDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="cachescope")
    private Integer cachescope;
    @Column(name="cachetimeout")
    private Integer cachetimeout;
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
    @Column(name="createpsdeopprivid")
    private String createpsdeopprivid;
    @Column(name="createpsdeoppriviname")
    private String createpsdeoppriviname;
    @Column(name="createtimeout")
    private Integer createtimeout;
    @Column(name="ctrltype")
    private String ctrltype;
    @Column(name="customcond")
    private String customcond;
    @Column(name="customtype")
    private String customtype;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="enablecache")
    private Integer enablecache;
    @Column(name="enableorgdr")
    private Integer enableorgdr;
    @Column(name="enablesecbc")
    private Integer enablesecbc;
    @Column(name="enablesecdr")
    private Integer enablesecdr;
    @Column(name="enableuserdr")
    private Integer enableuserdr;
    @Column(name="exportpsdeopprivid")
    private String exportpsdeopprivid;
    @Column(name="exportpsdeopprivname")
    private String exportpsdeopprivname;
    @Column(name="fetchtimeout")
    private Integer fetchtimeout;
    @Column(name="finishflag")
    private Integer finishflag;
    @Column(name="getdraftpsdeactionid")
    private String getdraftpsdeactionid;
    @Column(name="getdraftpsdeactionname")
    private String getdraftpsdeactionname;
    @Column(name="getpsdeactionid")
    private String getpsdeactionid;
    @Column(name="getpsdeactionname")
    private String getpsdeactionname;
    @Column(name="gettimeout")
    private Integer gettimeout;
    @Column(name="groupmovepsdeactionid")
    private String groupmovepsdeactionid;
    @Column(name="groupmovepsdeactionname")
    private String groupmovepsdeactionname;
    @Column(name="grouppsdeid")
    private String grouppsdeid;
    @Column(name="grouppsdename")
    private String grouppsdename;
    @Column(name="handlerobj")
    private String handlerobj;
    @Column(name="handlerobj2")
    private String handlerobj2;
    @Column(name="handlerparams")
    private String handlerparams;
    @Column(name="handlertag")
    private String handlertag;
    @Column(name="handlertag2")
    private String handlertag2;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
    @Column(name="movepsdeactionid")
    private String movepsdeactionid;
    @Column(name="movepsdeactionname")
    private String movepsdeactionname;
    @Column(name="orgdr")
    private Integer orgdr;
    @Column(name="psachandlerid")
    private String psachandlerid;
    @Column(name="psachandlername")
    private String psachandlername;
    @Column(name="psdedatasetid")
    private String psdedatasetid;
    @Column(name="psdedatasetname")
    private String psdedatasetname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssfachandlerid")
    private String pssfachandlerid;
    @Column(name="pssfachandlername")
    private String pssfachandlername;
    @Column(name="pssfid")
    private String pssfid;
    @Column(name="pssfname")
    private String pssfname;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssysreqitemid")
    private String pssysreqitemid;
    @Column(name="pssysreqitemname")
    private String pssysreqitemname;
    @Column(name="pssystaskid")
    private String pssystaskid;
    @Column(name="pssystaskname")
    private String pssystaskname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="pssysunistateid")
    private String pssysunistateid;
    @Column(name="pssysunistatename")
    private String pssysunistatename;
    @Column(name="pssysuserdrid")
    private String pssysuserdrid;
    @Column(name="pssysuserdrid2")
    private String pssysuserdrid2;
    @Column(name="pssysuserdrname")
    private String pssysuserdrname;
    @Column(name="pssysuserdrname2")
    private String pssysuserdrname2;
    @Column(name="readpsdeopprivid")
    private String readpsdeopprivid;
    @Column(name="readpsdeopprivname")
    private String readpsdeopprivname;
    @Column(name="removepsdeactionid")
    private String removepsdeactionid;
    @Column(name="removepsdeactionname")
    private String removepsdeactionname;
    @Column(name="removepsdeopprivid")
    private String removepsdeopprivid;
    @Column(name="removepsdeopprivname")
    private String removepsdeopprivname;
    @Column(name="removetimeout")
    private Integer removetimeout;
    @Column(name="secbc")
    private String secbc;
    @Column(name="secdr")
    private Integer secdr;
    @Column(name="sysuserdr2param")
    private String sysuserdr2param;
    @Column(name="sysuserdrparam")
    private String sysuserdrparam;
    @Column(name="tempmode")
    private Integer tempmode;
    @Column(name="todotask")
    private String todotask;
    @Column(name="unistatefield")
    private String unistatefield;
    @Column(name="unistatekeyvalue")
    private String unistatekeyvalue;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="updatepsdeactionid")
    private String updatepsdeactionid;
    @Column(name="updatepsdeactionname")
    private String updatepsdeactionname;
    @Column(name="updatepsdeopprivid")
    private String updatepsdeopprivid;
    @Column(name="updatepsdeopprivname")
    private String updatepsdeopprivname;
    @Column(name="updatetimeout")
    private Integer updatetimeout;
    @Column(name="user2psdeactionid")
    private String user2psdeactionid;
    @Column(name="user2psdeactionname")
    private String user2psdeactionname;
    @Column(name="user2psdeopprivid")
    private String user2psdeopprivid;
    @Column(name="user2psdeopprivname")
    private String user2psdeopprivname;
    @Column(name="usercat")
    private String usercat;
    @Column(name="userparams")
    private String userparams;
    @Column(name="userpsdeactionid")
    private String userpsdeactionid;
    @Column(name="userpsdeactionname")
    private String userpsdeactionname;
    @Column(name="userpsdeopprivid")
    private String userpsdeopprivid;
    @Column(name="userpsdeopprivname")
    private String userpsdeopprivname;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    private Integer objGroupPSDELock = new Integer(1);
    private PSDataEntity grouppsde = null;
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
    private Integer objGroupMovePSDEActionLock = new Integer(1);
    private PSDEAction groupmovepsdeaction = null;
    private Integer objMovePSDEActionLock = new Integer(1);
    private PSDEAction movepsdeaction = null;
    private Integer objRemovePSDEActionLock = new Integer(1);
    private PSDEAction removepsdeaction = null;
    private Integer objUpdatePSDEActionLock = new Integer(1);
    private PSDEAction updatepsdeaction = null;
    private Integer objUser2PSDEActionLock = new Integer(1);
    private PSDEAction user2psdeaction = null;
    private Integer objUserPSDEActionLock = new Integer(1);
    private PSDEAction userpsdeaction = null;
    private Integer objPSDEDataSetLock = new Integer(1);
    private PSDEDataSet psdedataset = null;
    private Integer objCreatePSDEOPPrivLock = new Integer(1);
    private PSDEOPPriv createpsdeoppriv = null;
    private Integer objExportPSDEOPPrivLock = new Integer(1);
    private PSDEOPPriv exportpsdeoppriv = null;
    private Integer objReadPSDEOPPrivLock = new Integer(1);
    private PSDEOPPriv readpsdeoppriv = null;
    private Integer objRemovePSDEOPPrivLock = new Integer(1);
    private PSDEOPPriv removepsdeoppriv = null;
    private Integer objUpdatePSDEOPPrivLock = new Integer(1);
    private PSDEOPPriv updatepsdeoppriv = null;
    private Integer objUser2PSDEOPPrivLock = new Integer(1);
    private PSDEOPPriv user2psdeoppriv = null;
    private Integer objUserPSDEOPPrivLock = new Integer(1);
    private PSDEOPPriv userpsdeoppriv = null;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSFACHandlerLock = new Integer(1);
    private PSSFACHandler pssfachandler = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSysReqItemLock = new Integer(1);
    private PSSysReqItem pssysreqitem = null;
    private Integer objPSSysTaskLock = new Integer(1);
    private PSSysTask pssystask = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSSysUniStateLock = new Integer(1);
    private PSSysUniState pssysunistate = null;
    private Integer objPSSysUserDRLock = new Integer(1);
    private PSSysUserDR pssysuserdr = null;
    private Integer objPSSysUserDR2Lock = new Integer(1);
    private PSSysUserDR pssysuserdr2 = null;
    private Integer objPSACHandlerActionsLock = new Integer(1);
    private ArrayList<PSACHandlerAction> psachandleractions = null;

    public void setCacheScope(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCacheScope(n);
            return;
        }
        this.cachescope = n;
        this.cachescopeDirtyFlag = true;
    }

    public Integer getCacheScope() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCacheScope();
        }
        return this.cachescope;
    }

    public boolean isCacheScopeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCacheScopeDirty();
        }
        return this.cachescopeDirtyFlag;
    }

    public void resetCacheScope() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCacheScope();
            return;
        }
        this.cachescopeDirtyFlag = false;
        this.cachescope = null;
    }

    public void setCacheTimeout(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCacheTimeout(n);
            return;
        }
        this.cachetimeout = n;
        this.cachetimeoutDirtyFlag = true;
    }

    public Integer getCacheTimeout() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCacheTimeout();
        }
        return this.cachetimeout;
    }

    public boolean isCacheTimeoutDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCacheTimeoutDirty();
        }
        return this.cachetimeoutDirtyFlag;
    }

    public void resetCacheTimeout() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCacheTimeout();
            return;
        }
        this.cachetimeoutDirtyFlag = false;
        this.cachetimeout = null;
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

    public void setCreatePSDEOPPrivId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreatePSDEOPPrivId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.createpsdeopprivid = string;
        this.createpsdeopprividDirtyFlag = true;
    }

    public String getCreatePSDEOPPrivId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreatePSDEOPPrivId();
        }
        return this.createpsdeopprivid;
    }

    public boolean isCreatePSDEOPPrivIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreatePSDEOPPrivIdDirty();
        }
        return this.createpsdeopprividDirtyFlag;
    }

    public void resetCreatePSDEOPPrivId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreatePSDEOPPrivId();
            return;
        }
        this.createpsdeopprividDirtyFlag = false;
        this.createpsdeopprivid = null;
    }

    public void setCreatePSDEOPPrivIName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreatePSDEOPPrivIName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.createpsdeoppriviname = string;
        this.createpsdeopprivinameDirtyFlag = true;
    }

    public String getCreatePSDEOPPrivIName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreatePSDEOPPrivIName();
        }
        return this.createpsdeoppriviname;
    }

    public boolean isCreatePSDEOPPrivINameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreatePSDEOPPrivINameDirty();
        }
        return this.createpsdeopprivinameDirtyFlag;
    }

    public void resetCreatePSDEOPPrivIName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreatePSDEOPPrivIName();
            return;
        }
        this.createpsdeopprivinameDirtyFlag = false;
        this.createpsdeoppriviname = null;
    }

    public void setCreateTimeout(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateTimeout(n);
            return;
        }
        this.createtimeout = n;
        this.createtimeoutDirtyFlag = true;
    }

    public Integer getCreateTimeout() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreateTimeout();
        }
        return this.createtimeout;
    }

    public boolean isCreateTimeoutDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreateTimeoutDirty();
        }
        return this.createtimeoutDirtyFlag;
    }

    public void resetCreateTimeout() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreateTimeout();
            return;
        }
        this.createtimeoutDirtyFlag = false;
        this.createtimeout = null;
    }

    public void setCtrlType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ctrltype = string;
        this.ctrltypeDirtyFlag = true;
    }

    public String getCtrlType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlType();
        }
        return this.ctrltype;
    }

    public boolean isCtrlTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlTypeDirty();
        }
        return this.ctrltypeDirtyFlag;
    }

    public void resetCtrlType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlType();
            return;
        }
        this.ctrltypeDirtyFlag = false;
        this.ctrltype = null;
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

    public void setEnableCache(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableCache(n);
            return;
        }
        this.enablecache = n;
        this.enablecacheDirtyFlag = true;
    }

    public Integer getEnableCache() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableCache();
        }
        return this.enablecache;
    }

    public boolean isEnableCacheDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableCacheDirty();
        }
        return this.enablecacheDirtyFlag;
    }

    public void resetEnableCache() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableCache();
            return;
        }
        this.enablecacheDirtyFlag = false;
        this.enablecache = null;
    }

    public void setEnableOrgDR(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableOrgDR(n);
            return;
        }
        this.enableorgdr = n;
        this.enableorgdrDirtyFlag = true;
    }

    public Integer getEnableOrgDR() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableOrgDR();
        }
        return this.enableorgdr;
    }

    public boolean isEnableOrgDRDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableOrgDRDirty();
        }
        return this.enableorgdrDirtyFlag;
    }

    public void resetEnableOrgDR() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableOrgDR();
            return;
        }
        this.enableorgdrDirtyFlag = false;
        this.enableorgdr = null;
    }

    public void setEnableSecBC(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableSecBC(n);
            return;
        }
        this.enablesecbc = n;
        this.enablesecbcDirtyFlag = true;
    }

    public Integer getEnableSecBC() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableSecBC();
        }
        return this.enablesecbc;
    }

    public boolean isEnableSecBCDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableSecBCDirty();
        }
        return this.enablesecbcDirtyFlag;
    }

    public void resetEnableSecBC() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableSecBC();
            return;
        }
        this.enablesecbcDirtyFlag = false;
        this.enablesecbc = null;
    }

    public void setEnableSecDR(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableSecDR(n);
            return;
        }
        this.enablesecdr = n;
        this.enablesecdrDirtyFlag = true;
    }

    public Integer getEnableSecDR() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableSecDR();
        }
        return this.enablesecdr;
    }

    public boolean isEnableSecDRDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableSecDRDirty();
        }
        return this.enablesecdrDirtyFlag;
    }

    public void resetEnableSecDR() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableSecDR();
            return;
        }
        this.enablesecdrDirtyFlag = false;
        this.enablesecdr = null;
    }

    public void setEnableUserDR(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableUserDR(n);
            return;
        }
        this.enableuserdr = n;
        this.enableuserdrDirtyFlag = true;
    }

    public Integer getEnableUserDR() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableUserDR();
        }
        return this.enableuserdr;
    }

    public boolean isEnableUserDRDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableUserDRDirty();
        }
        return this.enableuserdrDirtyFlag;
    }

    public void resetEnableUserDR() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableUserDR();
            return;
        }
        this.enableuserdrDirtyFlag = false;
        this.enableuserdr = null;
    }

    public void setExportPSDEOPPrivId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExportPSDEOPPrivId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.exportpsdeopprivid = string;
        this.exportpsdeopprividDirtyFlag = true;
    }

    public String getExportPSDEOPPrivId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExportPSDEOPPrivId();
        }
        return this.exportpsdeopprivid;
    }

    public boolean isExportPSDEOPPrivIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExportPSDEOPPrivIdDirty();
        }
        return this.exportpsdeopprividDirtyFlag;
    }

    public void resetExportPSDEOPPrivId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExportPSDEOPPrivId();
            return;
        }
        this.exportpsdeopprividDirtyFlag = false;
        this.exportpsdeopprivid = null;
    }

    public void setExportPSDEOPPrivName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExportPSDEOPPrivName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.exportpsdeopprivname = string;
        this.exportpsdeopprivnameDirtyFlag = true;
    }

    public String getExportPSDEOPPrivName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExportPSDEOPPrivName();
        }
        return this.exportpsdeopprivname;
    }

    public boolean isExportPSDEOPPrivNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExportPSDEOPPrivNameDirty();
        }
        return this.exportpsdeopprivnameDirtyFlag;
    }

    public void resetExportPSDEOPPrivName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExportPSDEOPPrivName();
            return;
        }
        this.exportpsdeopprivnameDirtyFlag = false;
        this.exportpsdeopprivname = null;
    }

    public void setFetchTimeout(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFetchTimeout(n);
            return;
        }
        this.fetchtimeout = n;
        this.fetchtimeoutDirtyFlag = true;
    }

    public Integer getFetchTimeout() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFetchTimeout();
        }
        return this.fetchtimeout;
    }

    public boolean isFetchTimeoutDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFetchTimeoutDirty();
        }
        return this.fetchtimeoutDirtyFlag;
    }

    public void resetFetchTimeout() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFetchTimeout();
            return;
        }
        this.fetchtimeoutDirtyFlag = false;
        this.fetchtimeout = null;
    }

    public void setFinishFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFinishFlag(n);
            return;
        }
        this.finishflag = n;
        this.finishflagDirtyFlag = true;
    }

    public Integer getFinishFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFinishFlag();
        }
        return this.finishflag;
    }

    public boolean isFinishFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFinishFlagDirty();
        }
        return this.finishflagDirtyFlag;
    }

    public void resetFinishFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFinishFlag();
            return;
        }
        this.finishflagDirtyFlag = false;
        this.finishflag = null;
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

    public void setGetTimeout(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGetTimeout(n);
            return;
        }
        this.gettimeout = n;
        this.gettimeoutDirtyFlag = true;
    }

    public Integer getGetTimeout() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGetTimeout();
        }
        return this.gettimeout;
    }

    public boolean isGetTimeoutDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGetTimeoutDirty();
        }
        return this.gettimeoutDirtyFlag;
    }

    public void resetGetTimeout() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGetTimeout();
            return;
        }
        this.gettimeoutDirtyFlag = false;
        this.gettimeout = null;
    }

    public void setGroupMovePSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupMovePSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.groupmovepsdeactionid = string;
        this.groupmovepsdeactionidDirtyFlag = true;
    }

    public String getGroupMovePSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupMovePSDEActionId();
        }
        return this.groupmovepsdeactionid;
    }

    public boolean isGroupMovePSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupMovePSDEActionIdDirty();
        }
        return this.groupmovepsdeactionidDirtyFlag;
    }

    public void resetGroupMovePSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupMovePSDEActionId();
            return;
        }
        this.groupmovepsdeactionidDirtyFlag = false;
        this.groupmovepsdeactionid = null;
    }

    public void setGroupMovePSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupMovePSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.groupmovepsdeactionname = string;
        this.groupmovepsdeactionnameDirtyFlag = true;
    }

    public String getGroupMovePSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupMovePSDEActionName();
        }
        return this.groupmovepsdeactionname;
    }

    public boolean isGroupMovePSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupMovePSDEActionNameDirty();
        }
        return this.groupmovepsdeactionnameDirtyFlag;
    }

    public void resetGroupMovePSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupMovePSDEActionName();
            return;
        }
        this.groupmovepsdeactionnameDirtyFlag = false;
        this.groupmovepsdeactionname = null;
    }

    public void setGroupPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.grouppsdeid = string;
        this.grouppsdeidDirtyFlag = true;
    }

    public String getGroupPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupPSDEId();
        }
        return this.grouppsdeid;
    }

    public boolean isGroupPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupPSDEIdDirty();
        }
        return this.grouppsdeidDirtyFlag;
    }

    public void resetGroupPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupPSDEId();
            return;
        }
        this.grouppsdeidDirtyFlag = false;
        this.grouppsdeid = null;
    }

    public void setGroupPSDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupPSDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.grouppsdename = string;
        this.grouppsdenameDirtyFlag = true;
    }

    public String getGroupPSDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupPSDEName();
        }
        return this.grouppsdename;
    }

    public boolean isGroupPSDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupPSDENameDirty();
        }
        return this.grouppsdenameDirtyFlag;
    }

    public void resetGroupPSDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupPSDEName();
            return;
        }
        this.grouppsdenameDirtyFlag = false;
        this.grouppsdename = null;
    }

    public void setHandlerObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHandlerObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.handlerobj = string;
        this.handlerobjDirtyFlag = true;
    }

    public String getHandlerObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHandlerObj();
        }
        return this.handlerobj;
    }

    public boolean isHandlerObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHandlerObjDirty();
        }
        return this.handlerobjDirtyFlag;
    }

    public void resetHandlerObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHandlerObj();
            return;
        }
        this.handlerobjDirtyFlag = false;
        this.handlerobj = null;
    }

    public void setHandlerObj2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHandlerObj2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.handlerobj2 = string;
        this.handlerobj2DirtyFlag = true;
    }

    public String getHandlerObj2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHandlerObj2();
        }
        return this.handlerobj2;
    }

    public boolean isHandlerObj2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHandlerObj2Dirty();
        }
        return this.handlerobj2DirtyFlag;
    }

    public void resetHandlerObj2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHandlerObj2();
            return;
        }
        this.handlerobj2DirtyFlag = false;
        this.handlerobj2 = null;
    }

    public void setHandlerParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHandlerParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.handlerparams = string;
        this.handlerparamsDirtyFlag = true;
    }

    public String getHandlerParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHandlerParams();
        }
        return this.handlerparams;
    }

    public boolean isHandlerParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHandlerParamsDirty();
        }
        return this.handlerparamsDirtyFlag;
    }

    public void resetHandlerParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHandlerParams();
            return;
        }
        this.handlerparamsDirtyFlag = false;
        this.handlerparams = null;
    }

    public void setHandlerTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHandlerTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.handlertag = string;
        this.handlertagDirtyFlag = true;
    }

    public String getHandlerTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHandlerTag();
        }
        return this.handlertag;
    }

    public boolean isHandlerTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHandlerTagDirty();
        }
        return this.handlertagDirtyFlag;
    }

    public void resetHandlerTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHandlerTag();
            return;
        }
        this.handlertagDirtyFlag = false;
        this.handlertag = null;
    }

    public void setHandlerTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHandlerTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.handlertag2 = string;
        this.handlertag2DirtyFlag = true;
    }

    public String getHandlerTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHandlerTag2();
        }
        return this.handlertag2;
    }

    public boolean isHandlerTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHandlerTag2Dirty();
        }
        return this.handlertag2DirtyFlag;
    }

    public void resetHandlerTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHandlerTag2();
            return;
        }
        this.handlertag2DirtyFlag = false;
        this.handlertag2 = null;
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

    public void setMovePSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMovePSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.movepsdeactionid = string;
        this.movepsdeactionidDirtyFlag = true;
    }

    public String getMovePSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMovePSDEActionId();
        }
        return this.movepsdeactionid;
    }

    public boolean isMovePSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMovePSDEActionIdDirty();
        }
        return this.movepsdeactionidDirtyFlag;
    }

    public void resetMovePSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMovePSDEActionId();
            return;
        }
        this.movepsdeactionidDirtyFlag = false;
        this.movepsdeactionid = null;
    }

    public void setMovePSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMovePSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.movepsdeactionname = string;
        this.movepsdeactionnameDirtyFlag = true;
    }

    public String getMovePSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMovePSDEActionName();
        }
        return this.movepsdeactionname;
    }

    public boolean isMovePSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMovePSDEActionNameDirty();
        }
        return this.movepsdeactionnameDirtyFlag;
    }

    public void resetMovePSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMovePSDEActionName();
            return;
        }
        this.movepsdeactionnameDirtyFlag = false;
        this.movepsdeactionname = null;
    }

    public void setOrgDR(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrgDR(n);
            return;
        }
        this.orgdr = n;
        this.orgdrDirtyFlag = true;
    }

    public Integer getOrgDR() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrgDR();
        }
        return this.orgdr;
    }

    public boolean isOrgDRDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrgDRDirty();
        }
        return this.orgdrDirtyFlag;
    }

    public void resetOrgDR() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrgDR();
            return;
        }
        this.orgdrDirtyFlag = false;
        this.orgdr = null;
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

    public void setPSSFACHandlerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFACHandlerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfachandlerid = string;
        this.pssfachandleridDirtyFlag = true;
    }

    public String getPSSFACHandlerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFACHandlerId();
        }
        return this.pssfachandlerid;
    }

    public boolean isPSSFACHandlerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFACHandlerIdDirty();
        }
        return this.pssfachandleridDirtyFlag;
    }

    public void resetPSSFACHandlerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFACHandlerId();
            return;
        }
        this.pssfachandleridDirtyFlag = false;
        this.pssfachandlerid = null;
    }

    public void setPSSFACHandlerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFACHandlerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfachandlername = string;
        this.pssfachandlernameDirtyFlag = true;
    }

    public String getPSSFACHandlerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFACHandlerName();
        }
        return this.pssfachandlername;
    }

    public boolean isPSSFACHandlerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFACHandlerNameDirty();
        }
        return this.pssfachandlernameDirtyFlag;
    }

    public void resetPSSFACHandlerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFACHandlerName();
            return;
        }
        this.pssfachandlernameDirtyFlag = false;
        this.pssfachandlername = null;
    }

    public void setPSSFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfid = string;
        this.pssfidDirtyFlag = true;
    }

    public String getPSSFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFId();
        }
        return this.pssfid;
    }

    public boolean isPSSFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFIdDirty();
        }
        return this.pssfidDirtyFlag;
    }

    public void resetPSSFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFId();
            return;
        }
        this.pssfidDirtyFlag = false;
        this.pssfid = null;
    }

    public void setPSSFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfname = string;
        this.pssfnameDirtyFlag = true;
    }

    public String getPSSFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFName();
        }
        return this.pssfname;
    }

    public boolean isPSSFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFNameDirty();
        }
        return this.pssfnameDirtyFlag;
    }

    public void resetPSSFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFName();
            return;
        }
        this.pssfnameDirtyFlag = false;
        this.pssfname = null;
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

    public void setPSSysTaskId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTaskId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystaskid = string;
        this.pssystaskidDirtyFlag = true;
    }

    public String getPSSysTaskId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTaskId();
        }
        return this.pssystaskid;
    }

    public boolean isPSSysTaskIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTaskIdDirty();
        }
        return this.pssystaskidDirtyFlag;
    }

    public void resetPSSysTaskId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTaskId();
            return;
        }
        this.pssystaskidDirtyFlag = false;
        this.pssystaskid = null;
    }

    public void setPSSysTaskName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTaskName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystaskname = string;
        this.pssystasknameDirtyFlag = true;
    }

    public String getPSSysTaskName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTaskName();
        }
        return this.pssystaskname;
    }

    public boolean isPSSysTaskNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTaskNameDirty();
        }
        return this.pssystasknameDirtyFlag;
    }

    public void resetPSSysTaskName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTaskName();
            return;
        }
        this.pssystasknameDirtyFlag = false;
        this.pssystaskname = null;
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

    public void setPSSysUniStateId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUniStateId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysunistateid = string;
        this.pssysunistateidDirtyFlag = true;
    }

    public String getPSSysUniStateId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUniStateId();
        }
        return this.pssysunistateid;
    }

    public boolean isPSSysUniStateIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUniStateIdDirty();
        }
        return this.pssysunistateidDirtyFlag;
    }

    public void resetPSSysUniStateId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUniStateId();
            return;
        }
        this.pssysunistateidDirtyFlag = false;
        this.pssysunistateid = null;
    }

    public void setPSSysUniStateName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUniStateName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysunistatename = string;
        this.pssysunistatenameDirtyFlag = true;
    }

    public String getPSSysUniStateName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUniStateName();
        }
        return this.pssysunistatename;
    }

    public boolean isPSSysUniStateNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUniStateNameDirty();
        }
        return this.pssysunistatenameDirtyFlag;
    }

    public void resetPSSysUniStateName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUniStateName();
            return;
        }
        this.pssysunistatenameDirtyFlag = false;
        this.pssysunistatename = null;
    }

    public void setPSSysUserDRId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUserDRId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysuserdrid = string;
        this.pssysuserdridDirtyFlag = true;
    }

    public String getPSSysUserDRId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUserDRId();
        }
        return this.pssysuserdrid;
    }

    public boolean isPSSysUserDRIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUserDRIdDirty();
        }
        return this.pssysuserdridDirtyFlag;
    }

    public void resetPSSysUserDRId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUserDRId();
            return;
        }
        this.pssysuserdridDirtyFlag = false;
        this.pssysuserdrid = null;
    }

    public void setPSSysUserDRId2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUserDRId2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysuserdrid2 = string;
        this.pssysuserdrid2DirtyFlag = true;
    }

    public String getPSSysUserDRId2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUserDRId2();
        }
        return this.pssysuserdrid2;
    }

    public boolean isPSSysUserDRId2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUserDRId2Dirty();
        }
        return this.pssysuserdrid2DirtyFlag;
    }

    public void resetPSSysUserDRId2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUserDRId2();
            return;
        }
        this.pssysuserdrid2DirtyFlag = false;
        this.pssysuserdrid2 = null;
    }

    public void setPSSysUserDRName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUserDRName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysuserdrname = string;
        this.pssysuserdrnameDirtyFlag = true;
    }

    public String getPSSysUserDRName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUserDRName();
        }
        return this.pssysuserdrname;
    }

    public boolean isPSSysUserDRNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUserDRNameDirty();
        }
        return this.pssysuserdrnameDirtyFlag;
    }

    public void resetPSSysUserDRName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUserDRName();
            return;
        }
        this.pssysuserdrnameDirtyFlag = false;
        this.pssysuserdrname = null;
    }

    public void setPSSysUserDRName2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUserDRName2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysuserdrname2 = string;
        this.pssysuserdrname2DirtyFlag = true;
    }

    public String getPSSysUserDRName2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUserDRName2();
        }
        return this.pssysuserdrname2;
    }

    public boolean isPSSysUserDRName2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUserDRName2Dirty();
        }
        return this.pssysuserdrname2DirtyFlag;
    }

    public void resetPSSysUserDRName2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUserDRName2();
            return;
        }
        this.pssysuserdrname2DirtyFlag = false;
        this.pssysuserdrname2 = null;
    }

    public void setReadPSDEOPPrivId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReadPSDEOPPrivId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.readpsdeopprivid = string;
        this.readpsdeopprividDirtyFlag = true;
    }

    public String getReadPSDEOPPrivId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReadPSDEOPPrivId();
        }
        return this.readpsdeopprivid;
    }

    public boolean isReadPSDEOPPrivIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReadPSDEOPPrivIdDirty();
        }
        return this.readpsdeopprividDirtyFlag;
    }

    public void resetReadPSDEOPPrivId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReadPSDEOPPrivId();
            return;
        }
        this.readpsdeopprividDirtyFlag = false;
        this.readpsdeopprivid = null;
    }

    public void setReadPSDEOPPrivName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReadPSDEOPPrivName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.readpsdeopprivname = string;
        this.readpsdeopprivnameDirtyFlag = true;
    }

    public String getReadPSDEOPPrivName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReadPSDEOPPrivName();
        }
        return this.readpsdeopprivname;
    }

    public boolean isReadPSDEOPPrivNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReadPSDEOPPrivNameDirty();
        }
        return this.readpsdeopprivnameDirtyFlag;
    }

    public void resetReadPSDEOPPrivName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReadPSDEOPPrivName();
            return;
        }
        this.readpsdeopprivnameDirtyFlag = false;
        this.readpsdeopprivname = null;
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

    public void setRemovePSDEOPPrivId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRemovePSDEOPPrivId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.removepsdeopprivid = string;
        this.removepsdeopprividDirtyFlag = true;
    }

    public String getRemovePSDEOPPrivId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRemovePSDEOPPrivId();
        }
        return this.removepsdeopprivid;
    }

    public boolean isRemovePSDEOPPrivIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRemovePSDEOPPrivIdDirty();
        }
        return this.removepsdeopprividDirtyFlag;
    }

    public void resetRemovePSDEOPPrivId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRemovePSDEOPPrivId();
            return;
        }
        this.removepsdeopprividDirtyFlag = false;
        this.removepsdeopprivid = null;
    }

    public void setRemovePSDEOPPrivName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRemovePSDEOPPrivName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.removepsdeopprivname = string;
        this.removepsdeopprivnameDirtyFlag = true;
    }

    public String getRemovePSDEOPPrivName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRemovePSDEOPPrivName();
        }
        return this.removepsdeopprivname;
    }

    public boolean isRemovePSDEOPPrivNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRemovePSDEOPPrivNameDirty();
        }
        return this.removepsdeopprivnameDirtyFlag;
    }

    public void resetRemovePSDEOPPrivName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRemovePSDEOPPrivName();
            return;
        }
        this.removepsdeopprivnameDirtyFlag = false;
        this.removepsdeopprivname = null;
    }

    public void setRemoveTimeout(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRemoveTimeout(n);
            return;
        }
        this.removetimeout = n;
        this.removetimeoutDirtyFlag = true;
    }

    public Integer getRemoveTimeout() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRemoveTimeout();
        }
        return this.removetimeout;
    }

    public boolean isRemoveTimeoutDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRemoveTimeoutDirty();
        }
        return this.removetimeoutDirtyFlag;
    }

    public void resetRemoveTimeout() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRemoveTimeout();
            return;
        }
        this.removetimeoutDirtyFlag = false;
        this.removetimeout = null;
    }

    public void setSecBC(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSecBC(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.secbc = string;
        this.secbcDirtyFlag = true;
    }

    public String getSecBC() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSecBC();
        }
        return this.secbc;
    }

    public boolean isSecBCDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSecBCDirty();
        }
        return this.secbcDirtyFlag;
    }

    public void resetSecBC() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSecBC();
            return;
        }
        this.secbcDirtyFlag = false;
        this.secbc = null;
    }

    public void setSecDR(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSecDR(n);
            return;
        }
        this.secdr = n;
        this.secdrDirtyFlag = true;
    }

    public Integer getSecDR() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSecDR();
        }
        return this.secdr;
    }

    public boolean isSecDRDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSecDRDirty();
        }
        return this.secdrDirtyFlag;
    }

    public void resetSecDR() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSecDR();
            return;
        }
        this.secdrDirtyFlag = false;
        this.secdr = null;
    }

    public void setSysUserDR2Param(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysUserDR2Param(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sysuserdr2param = string;
        this.sysuserdr2paramDirtyFlag = true;
    }

    public String getSysUserDR2Param() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysUserDR2Param();
        }
        return this.sysuserdr2param;
    }

    public boolean isSysUserDR2ParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysUserDR2ParamDirty();
        }
        return this.sysuserdr2paramDirtyFlag;
    }

    public void resetSysUserDR2Param() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysUserDR2Param();
            return;
        }
        this.sysuserdr2paramDirtyFlag = false;
        this.sysuserdr2param = null;
    }

    public void setSysUserDRParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysUserDRParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sysuserdrparam = string;
        this.sysuserdrparamDirtyFlag = true;
    }

    public String getSysUserDRParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysUserDRParam();
        }
        return this.sysuserdrparam;
    }

    public boolean isSysUserDRParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysUserDRParamDirty();
        }
        return this.sysuserdrparamDirtyFlag;
    }

    public void resetSysUserDRParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysUserDRParam();
            return;
        }
        this.sysuserdrparamDirtyFlag = false;
        this.sysuserdrparam = null;
    }

    public void setTempMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTempMode(n);
            return;
        }
        this.tempmode = n;
        this.tempmodeDirtyFlag = true;
    }

    public Integer getTempMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTempMode();
        }
        return this.tempmode;
    }

    public boolean isTempModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTempModeDirty();
        }
        return this.tempmodeDirtyFlag;
    }

    public void resetTempMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTempMode();
            return;
        }
        this.tempmodeDirtyFlag = false;
        this.tempmode = null;
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

    public void setUniStateField(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUniStateField(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.unistatefield = string;
        this.unistatefieldDirtyFlag = true;
    }

    public String getUniStateField() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUniStateField();
        }
        return this.unistatefield;
    }

    public boolean isUniStateFieldDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUniStateFieldDirty();
        }
        return this.unistatefieldDirtyFlag;
    }

    public void resetUniStateField() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUniStateField();
            return;
        }
        this.unistatefieldDirtyFlag = false;
        this.unistatefield = null;
    }

    public void setUniStateKeyValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUniStateKeyValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.unistatekeyvalue = string;
        this.unistatekeyvalueDirtyFlag = true;
    }

    public String getUniStateKeyValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUniStateKeyValue();
        }
        return this.unistatekeyvalue;
    }

    public boolean isUniStateKeyValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUniStateKeyValueDirty();
        }
        return this.unistatekeyvalueDirtyFlag;
    }

    public void resetUniStateKeyValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUniStateKeyValue();
            return;
        }
        this.unistatekeyvalueDirtyFlag = false;
        this.unistatekeyvalue = null;
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

    public void setUpdatePSDEOPPrivId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdatePSDEOPPrivId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.updatepsdeopprivid = string;
        this.updatepsdeopprividDirtyFlag = true;
    }

    public String getUpdatePSDEOPPrivId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdatePSDEOPPrivId();
        }
        return this.updatepsdeopprivid;
    }

    public boolean isUpdatePSDEOPPrivIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdatePSDEOPPrivIdDirty();
        }
        return this.updatepsdeopprividDirtyFlag;
    }

    public void resetUpdatePSDEOPPrivId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdatePSDEOPPrivId();
            return;
        }
        this.updatepsdeopprividDirtyFlag = false;
        this.updatepsdeopprivid = null;
    }

    public void setUpdatePSDEOPPrivName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdatePSDEOPPrivName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.updatepsdeopprivname = string;
        this.updatepsdeopprivnameDirtyFlag = true;
    }

    public String getUpdatePSDEOPPrivName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdatePSDEOPPrivName();
        }
        return this.updatepsdeopprivname;
    }

    public boolean isUpdatePSDEOPPrivNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdatePSDEOPPrivNameDirty();
        }
        return this.updatepsdeopprivnameDirtyFlag;
    }

    public void resetUpdatePSDEOPPrivName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdatePSDEOPPrivName();
            return;
        }
        this.updatepsdeopprivnameDirtyFlag = false;
        this.updatepsdeopprivname = null;
    }

    public void setUpdateTimeout(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateTimeout(n);
            return;
        }
        this.updatetimeout = n;
        this.updatetimeoutDirtyFlag = true;
    }

    public Integer getUpdateTimeout() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdateTimeout();
        }
        return this.updatetimeout;
    }

    public boolean isUpdateTimeoutDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdateTimeoutDirty();
        }
        return this.updatetimeoutDirtyFlag;
    }

    public void resetUpdateTimeout() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdateTimeout();
            return;
        }
        this.updatetimeoutDirtyFlag = false;
        this.updatetimeout = null;
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

    public void setUser2PSDEOPPrivId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUser2PSDEOPPrivId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.user2psdeopprivid = string;
        this.user2psdeopprividDirtyFlag = true;
    }

    public String getUser2PSDEOPPrivId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUser2PSDEOPPrivId();
        }
        return this.user2psdeopprivid;
    }

    public boolean isUser2PSDEOPPrivIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUser2PSDEOPPrivIdDirty();
        }
        return this.user2psdeopprividDirtyFlag;
    }

    public void resetUser2PSDEOPPrivId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUser2PSDEOPPrivId();
            return;
        }
        this.user2psdeopprividDirtyFlag = false;
        this.user2psdeopprivid = null;
    }

    public void setUser2PSDEOPPrivName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUser2PSDEOPPrivName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.user2psdeopprivname = string;
        this.user2psdeopprivnameDirtyFlag = true;
    }

    public String getUser2PSDEOPPrivName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUser2PSDEOPPrivName();
        }
        return this.user2psdeopprivname;
    }

    public boolean isUser2PSDEOPPrivNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUser2PSDEOPPrivNameDirty();
        }
        return this.user2psdeopprivnameDirtyFlag;
    }

    public void resetUser2PSDEOPPrivName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUser2PSDEOPPrivName();
            return;
        }
        this.user2psdeopprivnameDirtyFlag = false;
        this.user2psdeopprivname = null;
    }

    public void setUserCat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserCat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usercat = string;
        this.usercatDirtyFlag = true;
    }

    public String getUserCat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserCat();
        }
        return this.usercat;
    }

    public boolean isUserCatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserCatDirty();
        }
        return this.usercatDirtyFlag;
    }

    public void resetUserCat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserCat();
            return;
        }
        this.usercatDirtyFlag = false;
        this.usercat = null;
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

    public void setUserPSDEOPPrivId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserPSDEOPPrivId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userpsdeopprivid = string;
        this.userpsdeopprividDirtyFlag = true;
    }

    public String getUserPSDEOPPrivId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserPSDEOPPrivId();
        }
        return this.userpsdeopprivid;
    }

    public boolean isUserPSDEOPPrivIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserPSDEOPPrivIdDirty();
        }
        return this.userpsdeopprividDirtyFlag;
    }

    public void resetUserPSDEOPPrivId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserPSDEOPPrivId();
            return;
        }
        this.userpsdeopprividDirtyFlag = false;
        this.userpsdeopprivid = null;
    }

    public void setUserPSDEOPPrivName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserPSDEOPPrivName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userpsdeopprivname = string;
        this.userpsdeopprivnameDirtyFlag = true;
    }

    public String getUserPSDEOPPrivName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserPSDEOPPrivName();
        }
        return this.userpsdeopprivname;
    }

    public boolean isUserPSDEOPPrivNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserPSDEOPPrivNameDirty();
        }
        return this.userpsdeopprivnameDirtyFlag;
    }

    public void resetUserPSDEOPPrivName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserPSDEOPPrivName();
            return;
        }
        this.userpsdeopprivnameDirtyFlag = false;
        this.userpsdeopprivname = null;
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

    public void setUserTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag3 = string;
        this.usertag3DirtyFlag = true;
    }

    public String getUserTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag3();
        }
        return this.usertag3;
    }

    public boolean isUserTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag3Dirty();
        }
        return this.usertag3DirtyFlag;
    }

    public void resetUserTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag3();
            return;
        }
        this.usertag3DirtyFlag = false;
        this.usertag3 = null;
    }

    public void setUserTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag4 = string;
        this.usertag4DirtyFlag = true;
    }

    public String getUserTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag4();
        }
        return this.usertag4;
    }

    public boolean isUserTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag4Dirty();
        }
        return this.usertag4DirtyFlag;
    }

    public void resetUserTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag4();
            return;
        }
        this.usertag4DirtyFlag = false;
        this.usertag4 = null;
    }

    protected void onReset() {
        PSACHandlerBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSACHandlerBase pSACHandlerBase) {
        pSACHandlerBase.resetCacheScope();
        pSACHandlerBase.resetCacheTimeout();
        pSACHandlerBase.resetCodeName();
        pSACHandlerBase.resetCopyPSDEActionId();
        pSACHandlerBase.resetCopyPSDEActionName();
        pSACHandlerBase.resetCreateDate();
        pSACHandlerBase.resetCreateMan();
        pSACHandlerBase.resetCreatePSDEActionId();
        pSACHandlerBase.resetCreatePSDEActionName();
        pSACHandlerBase.resetCreatePSDEOPPrivId();
        pSACHandlerBase.resetCreatePSDEOPPrivIName();
        pSACHandlerBase.resetCreateTimeout();
        pSACHandlerBase.resetCtrlType();
        pSACHandlerBase.resetCustomCond();
        pSACHandlerBase.resetCustomType();
        pSACHandlerBase.resetDynaModelFlag();
        pSACHandlerBase.resetEnableCache();
        pSACHandlerBase.resetEnableOrgDR();
        pSACHandlerBase.resetEnableSecBC();
        pSACHandlerBase.resetEnableSecDR();
        pSACHandlerBase.resetEnableUserDR();
        pSACHandlerBase.resetExportPSDEOPPrivId();
        pSACHandlerBase.resetExportPSDEOPPrivName();
        pSACHandlerBase.resetFetchTimeout();
        pSACHandlerBase.resetFinishFlag();
        pSACHandlerBase.resetGetDraftPSDEActionId();
        pSACHandlerBase.resetGetDraftPSDEActionName();
        pSACHandlerBase.resetGetPSDEActionId();
        pSACHandlerBase.resetGetPSDEActionName();
        pSACHandlerBase.resetGetTimeout();
        pSACHandlerBase.resetGroupMovePSDEActionId();
        pSACHandlerBase.resetGroupMovePSDEActionName();
        pSACHandlerBase.resetGroupPSDEId();
        pSACHandlerBase.resetGroupPSDEName();
        pSACHandlerBase.resetHandlerObj();
        pSACHandlerBase.resetHandlerObj2();
        pSACHandlerBase.resetHandlerParams();
        pSACHandlerBase.resetHandlerTag();
        pSACHandlerBase.resetHandlerTag2();
        pSACHandlerBase.resetLockFlag();
        pSACHandlerBase.resetMemo();
        pSACHandlerBase.resetMovePSDEActionId();
        pSACHandlerBase.resetMovePSDEActionName();
        pSACHandlerBase.resetOrgDR();
        pSACHandlerBase.resetPSACHandlerId();
        pSACHandlerBase.resetPSACHandlerName();
        pSACHandlerBase.resetPSDEDataSetId();
        pSACHandlerBase.resetPSDEDataSetName();
        pSACHandlerBase.resetPSDEId();
        pSACHandlerBase.resetPSDEName();
        pSACHandlerBase.resetPSDynaInstId();
        pSACHandlerBase.resetPSModuleId();
        pSACHandlerBase.resetPSModuleName();
        pSACHandlerBase.resetPSSFACHandlerId();
        pSACHandlerBase.resetPSSFACHandlerName();
        pSACHandlerBase.resetPSSFId();
        pSACHandlerBase.resetPSSFName();
        pSACHandlerBase.resetPSSysDynaModelId();
        pSACHandlerBase.resetPSSysDynaModelName();
        pSACHandlerBase.resetPSSysReqItemId();
        pSACHandlerBase.resetPSSysReqItemName();
        pSACHandlerBase.resetPSSysTaskId();
        pSACHandlerBase.resetPSSysTaskName();
        pSACHandlerBase.resetPSSystemId();
        pSACHandlerBase.resetPSSystemName();
        pSACHandlerBase.resetPSSysUniStateId();
        pSACHandlerBase.resetPSSysUniStateName();
        pSACHandlerBase.resetPSSysUserDRId();
        pSACHandlerBase.resetPSSysUserDRId2();
        pSACHandlerBase.resetPSSysUserDRName();
        pSACHandlerBase.resetPSSysUserDRName2();
        pSACHandlerBase.resetReadPSDEOPPrivId();
        pSACHandlerBase.resetReadPSDEOPPrivName();
        pSACHandlerBase.resetRemovePSDEActionId();
        pSACHandlerBase.resetRemovePSDEActionName();
        pSACHandlerBase.resetRemovePSDEOPPrivId();
        pSACHandlerBase.resetRemovePSDEOPPrivName();
        pSACHandlerBase.resetRemoveTimeout();
        pSACHandlerBase.resetSecBC();
        pSACHandlerBase.resetSecDR();
        pSACHandlerBase.resetSysUserDR2Param();
        pSACHandlerBase.resetSysUserDRParam();
        pSACHandlerBase.resetTempMode();
        pSACHandlerBase.resetToDoTask();
        pSACHandlerBase.resetUniStateField();
        pSACHandlerBase.resetUniStateKeyValue();
        pSACHandlerBase.resetUpdateDate();
        pSACHandlerBase.resetUpdateMan();
        pSACHandlerBase.resetUpdatePSDEActionId();
        pSACHandlerBase.resetUpdatePSDEActionName();
        pSACHandlerBase.resetUpdatePSDEOPPrivId();
        pSACHandlerBase.resetUpdatePSDEOPPrivName();
        pSACHandlerBase.resetUpdateTimeout();
        pSACHandlerBase.resetUser2PSDEActionId();
        pSACHandlerBase.resetUser2PSDEActionName();
        pSACHandlerBase.resetUser2PSDEOPPrivId();
        pSACHandlerBase.resetUser2PSDEOPPrivName();
        pSACHandlerBase.resetUserCat();
        pSACHandlerBase.resetUserParams();
        pSACHandlerBase.resetUserPSDEActionId();
        pSACHandlerBase.resetUserPSDEActionName();
        pSACHandlerBase.resetUserPSDEOPPrivId();
        pSACHandlerBase.resetUserPSDEOPPrivName();
        pSACHandlerBase.resetUserTag();
        pSACHandlerBase.resetUserTag2();
        pSACHandlerBase.resetUserTag3();
        pSACHandlerBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCacheScopeDirty()) {
            hashMap.put(FIELD_CACHESCOPE, this.getCacheScope());
        }
        if (!bl || this.isCacheTimeoutDirty()) {
            hashMap.put(FIELD_CACHETIMEOUT, this.getCacheTimeout());
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
        if (!bl || this.isCreatePSDEOPPrivIdDirty()) {
            hashMap.put(FIELD_CREATEPSDEOPPRIVID, this.getCreatePSDEOPPrivId());
        }
        if (!bl || this.isCreatePSDEOPPrivINameDirty()) {
            hashMap.put(FIELD_CREATEPSDEOPPRIVINAME, this.getCreatePSDEOPPrivIName());
        }
        if (!bl || this.isCreateTimeoutDirty()) {
            hashMap.put(FIELD_CREATETIMEOUT, this.getCreateTimeout());
        }
        if (!bl || this.isCtrlTypeDirty()) {
            hashMap.put(FIELD_CTRLTYPE, this.getCtrlType());
        }
        if (!bl || this.isCustomCondDirty()) {
            hashMap.put(FIELD_CUSTOMCOND, this.getCustomCond());
        }
        if (!bl || this.isCustomTypeDirty()) {
            hashMap.put(FIELD_CUSTOMTYPE, this.getCustomType());
        }
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isEnableCacheDirty()) {
            hashMap.put(FIELD_ENABLECACHE, this.getEnableCache());
        }
        if (!bl || this.isEnableOrgDRDirty()) {
            hashMap.put(FIELD_ENABLEORGDR, this.getEnableOrgDR());
        }
        if (!bl || this.isEnableSecBCDirty()) {
            hashMap.put(FIELD_ENABLESECBC, this.getEnableSecBC());
        }
        if (!bl || this.isEnableSecDRDirty()) {
            hashMap.put(FIELD_ENABLESECDR, this.getEnableSecDR());
        }
        if (!bl || this.isEnableUserDRDirty()) {
            hashMap.put(FIELD_ENABLEUSERDR, this.getEnableUserDR());
        }
        if (!bl || this.isExportPSDEOPPrivIdDirty()) {
            hashMap.put(FIELD_EXPORTPSDEOPPRIVID, this.getExportPSDEOPPrivId());
        }
        if (!bl || this.isExportPSDEOPPrivNameDirty()) {
            hashMap.put(FIELD_EXPORTPSDEOPPRIVNAME, this.getExportPSDEOPPrivName());
        }
        if (!bl || this.isFetchTimeoutDirty()) {
            hashMap.put(FIELD_FETCHTIMEOUT, this.getFetchTimeout());
        }
        if (!bl || this.isFinishFlagDirty()) {
            hashMap.put(FIELD_FINISHFLAG, this.getFinishFlag());
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
        if (!bl || this.isGetTimeoutDirty()) {
            hashMap.put(FIELD_GETTIMEOUT, this.getGetTimeout());
        }
        if (!bl || this.isGroupMovePSDEActionIdDirty()) {
            hashMap.put(FIELD_GROUPMOVEPSDEACTIONID, this.getGroupMovePSDEActionId());
        }
        if (!bl || this.isGroupMovePSDEActionNameDirty()) {
            hashMap.put(FIELD_GROUPMOVEPSDEACTIONNAME, this.getGroupMovePSDEActionName());
        }
        if (!bl || this.isGroupPSDEIdDirty()) {
            hashMap.put(FIELD_GROUPPSDEID, this.getGroupPSDEId());
        }
        if (!bl || this.isGroupPSDENameDirty()) {
            hashMap.put(FIELD_GROUPPSDENAME, this.getGroupPSDEName());
        }
        if (!bl || this.isHandlerObjDirty()) {
            hashMap.put(FIELD_HANDLEROBJ, this.getHandlerObj());
        }
        if (!bl || this.isHandlerObj2Dirty()) {
            hashMap.put(FIELD_HANDLEROBJ2, this.getHandlerObj2());
        }
        if (!bl || this.isHandlerParamsDirty()) {
            hashMap.put(FIELD_HANDLERPARAMS, this.getHandlerParams());
        }
        if (!bl || this.isHandlerTagDirty()) {
            hashMap.put(FIELD_HANDLERTAG, this.getHandlerTag());
        }
        if (!bl || this.isHandlerTag2Dirty()) {
            hashMap.put(FIELD_HANDLERTAG2, this.getHandlerTag2());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMovePSDEActionIdDirty()) {
            hashMap.put(FIELD_MOVEPSDEACTIONID, this.getMovePSDEActionId());
        }
        if (!bl || this.isMovePSDEActionNameDirty()) {
            hashMap.put(FIELD_MOVEPSDEACTIONNAME, this.getMovePSDEActionName());
        }
        if (!bl || this.isOrgDRDirty()) {
            hashMap.put(FIELD_ORGDR, this.getOrgDR());
        }
        if (!bl || this.isPSACHandlerIdDirty()) {
            hashMap.put(FIELD_PSACHANDLERID, this.getPSACHandlerId());
        }
        if (!bl || this.isPSACHandlerNameDirty()) {
            hashMap.put(FIELD_PSACHANDLERNAME, this.getPSACHandlerName());
        }
        if (!bl || this.isPSDEDataSetIdDirty()) {
            hashMap.put(FIELD_PSDEDATASETID, this.getPSDEDataSetId());
        }
        if (!bl || this.isPSDEDataSetNameDirty()) {
            hashMap.put(FIELD_PSDEDATASETNAME, this.getPSDEDataSetName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
        }
        if (!bl || this.isPSSFACHandlerIdDirty()) {
            hashMap.put(FIELD_PSSFACHANDLERID, this.getPSSFACHandlerId());
        }
        if (!bl || this.isPSSFACHandlerNameDirty()) {
            hashMap.put(FIELD_PSSFACHANDLERNAME, this.getPSSFACHandlerName());
        }
        if (!bl || this.isPSSFIdDirty()) {
            hashMap.put(FIELD_PSSFID, this.getPSSFId());
        }
        if (!bl || this.isPSSFNameDirty()) {
            hashMap.put(FIELD_PSSFNAME, this.getPSSFName());
        }
        if (!bl || this.isPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELID, this.getPSSysDynaModelId());
        }
        if (!bl || this.isPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELNAME, this.getPSSysDynaModelName());
        }
        if (!bl || this.isPSSysReqItemIdDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMID, this.getPSSysReqItemId());
        }
        if (!bl || this.isPSSysReqItemNameDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMNAME, this.getPSSysReqItemName());
        }
        if (!bl || this.isPSSysTaskIdDirty()) {
            hashMap.put(FIELD_PSSYSTASKID, this.getPSSysTaskId());
        }
        if (!bl || this.isPSSysTaskNameDirty()) {
            hashMap.put(FIELD_PSSYSTASKNAME, this.getPSSysTaskName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isPSSysUniStateIdDirty()) {
            hashMap.put(FIELD_PSSYSUNISTATEID, this.getPSSysUniStateId());
        }
        if (!bl || this.isPSSysUniStateNameDirty()) {
            hashMap.put(FIELD_PSSYSUNISTATENAME, this.getPSSysUniStateName());
        }
        if (!bl || this.isPSSysUserDRIdDirty()) {
            hashMap.put(FIELD_PSSYSUSERDRID, this.getPSSysUserDRId());
        }
        if (!bl || this.isPSSysUserDRId2Dirty()) {
            hashMap.put(FIELD_PSSYSUSERDRID2, this.getPSSysUserDRId2());
        }
        if (!bl || this.isPSSysUserDRNameDirty()) {
            hashMap.put(FIELD_PSSYSUSERDRNAME, this.getPSSysUserDRName());
        }
        if (!bl || this.isPSSysUserDRName2Dirty()) {
            hashMap.put(FIELD_PSSYSUSERDRNAME2, this.getPSSysUserDRName2());
        }
        if (!bl || this.isReadPSDEOPPrivIdDirty()) {
            hashMap.put(FIELD_READPSDEOPPRIVID, this.getReadPSDEOPPrivId());
        }
        if (!bl || this.isReadPSDEOPPrivNameDirty()) {
            hashMap.put(FIELD_READPSDEOPPRIVNAME, this.getReadPSDEOPPrivName());
        }
        if (!bl || this.isRemovePSDEActionIdDirty()) {
            hashMap.put(FIELD_REMOVEPSDEACTIONID, this.getRemovePSDEActionId());
        }
        if (!bl || this.isRemovePSDEActionNameDirty()) {
            hashMap.put(FIELD_REMOVEPSDEACTIONNAME, this.getRemovePSDEActionName());
        }
        if (!bl || this.isRemovePSDEOPPrivIdDirty()) {
            hashMap.put(FIELD_REMOVEPSDEOPPRIVID, this.getRemovePSDEOPPrivId());
        }
        if (!bl || this.isRemovePSDEOPPrivNameDirty()) {
            hashMap.put(FIELD_REMOVEPSDEOPPRIVNAME, this.getRemovePSDEOPPrivName());
        }
        if (!bl || this.isRemoveTimeoutDirty()) {
            hashMap.put(FIELD_REMOVETIMEOUT, this.getRemoveTimeout());
        }
        if (!bl || this.isSecBCDirty()) {
            hashMap.put(FIELD_SECBC, this.getSecBC());
        }
        if (!bl || this.isSecDRDirty()) {
            hashMap.put(FIELD_SECDR, this.getSecDR());
        }
        if (!bl || this.isSysUserDR2ParamDirty()) {
            hashMap.put(FIELD_SYSUSERDR2PARAM, this.getSysUserDR2Param());
        }
        if (!bl || this.isSysUserDRParamDirty()) {
            hashMap.put(FIELD_SYSUSERDRPARAM, this.getSysUserDRParam());
        }
        if (!bl || this.isTempModeDirty()) {
            hashMap.put(FIELD_TEMPMODE, this.getTempMode());
        }
        if (!bl || this.isToDoTaskDirty()) {
            hashMap.put(FIELD_TODOTASK, this.getToDoTask());
        }
        if (!bl || this.isUniStateFieldDirty()) {
            hashMap.put(FIELD_UNISTATEFIELD, this.getUniStateField());
        }
        if (!bl || this.isUniStateKeyValueDirty()) {
            hashMap.put(FIELD_UNISTATEKEYVALUE, this.getUniStateKeyValue());
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
        if (!bl || this.isUpdatePSDEOPPrivIdDirty()) {
            hashMap.put(FIELD_UPDATEPSDEOPPRIVID, this.getUpdatePSDEOPPrivId());
        }
        if (!bl || this.isUpdatePSDEOPPrivNameDirty()) {
            hashMap.put(FIELD_UPDATEPSDEOPPRIVNAME, this.getUpdatePSDEOPPrivName());
        }
        if (!bl || this.isUpdateTimeoutDirty()) {
            hashMap.put(FIELD_UPDATETIMEOUT, this.getUpdateTimeout());
        }
        if (!bl || this.isUser2PSDEActionIdDirty()) {
            hashMap.put(FIELD_USER2PSDEACTIONID, this.getUser2PSDEActionId());
        }
        if (!bl || this.isUser2PSDEActionNameDirty()) {
            hashMap.put(FIELD_USER2PSDEACTIONNAME, this.getUser2PSDEActionName());
        }
        if (!bl || this.isUser2PSDEOPPrivIdDirty()) {
            hashMap.put(FIELD_USER2PSDEOPPRIVID, this.getUser2PSDEOPPrivId());
        }
        if (!bl || this.isUser2PSDEOPPrivNameDirty()) {
            hashMap.put(FIELD_USER2PSDEOPPRIVNAME, this.getUser2PSDEOPPrivName());
        }
        if (!bl || this.isUserCatDirty()) {
            hashMap.put(FIELD_USERCAT, this.getUserCat());
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
        if (!bl || this.isUserPSDEOPPrivIdDirty()) {
            hashMap.put(FIELD_USERPSDEOPPRIVID, this.getUserPSDEOPPrivId());
        }
        if (!bl || this.isUserPSDEOPPrivNameDirty()) {
            hashMap.put(FIELD_USERPSDEOPPRIVNAME, this.getUserPSDEOPPrivName());
        }
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bl || this.isUserTag2Dirty()) {
            hashMap.put(FIELD_USERTAG2, this.getUserTag2());
        }
        if (!bl || this.isUserTag3Dirty()) {
            hashMap.put(FIELD_USERTAG3, this.getUserTag3());
        }
        if (!bl || this.isUserTag4Dirty()) {
            hashMap.put(FIELD_USERTAG4, this.getUserTag4());
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
        return PSACHandlerBase.get(this, n);
    }

    private static Object get(PSACHandlerBase pSACHandlerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSACHandlerBase.getCacheScope();
            }
            case 1: {
                return pSACHandlerBase.getCacheTimeout();
            }
            case 2: {
                return pSACHandlerBase.getCodeName();
            }
            case 3: {
                return pSACHandlerBase.getCopyPSDEActionId();
            }
            case 4: {
                return pSACHandlerBase.getCopyPSDEActionName();
            }
            case 5: {
                return pSACHandlerBase.getCreateDate();
            }
            case 6: {
                return pSACHandlerBase.getCreateMan();
            }
            case 7: {
                return pSACHandlerBase.getCreatePSDEActionId();
            }
            case 8: {
                return pSACHandlerBase.getCreatePSDEActionName();
            }
            case 9: {
                return pSACHandlerBase.getCreatePSDEOPPrivId();
            }
            case 10: {
                return pSACHandlerBase.getCreatePSDEOPPrivIName();
            }
            case 11: {
                return pSACHandlerBase.getCreateTimeout();
            }
            case 12: {
                return pSACHandlerBase.getCtrlType();
            }
            case 13: {
                return pSACHandlerBase.getCustomCond();
            }
            case 14: {
                return pSACHandlerBase.getCustomType();
            }
            case 15: {
                return pSACHandlerBase.getDynaModelFlag();
            }
            case 16: {
                return pSACHandlerBase.getEnableCache();
            }
            case 17: {
                return pSACHandlerBase.getEnableOrgDR();
            }
            case 18: {
                return pSACHandlerBase.getEnableSecBC();
            }
            case 19: {
                return pSACHandlerBase.getEnableSecDR();
            }
            case 20: {
                return pSACHandlerBase.getEnableUserDR();
            }
            case 21: {
                return pSACHandlerBase.getExportPSDEOPPrivId();
            }
            case 22: {
                return pSACHandlerBase.getExportPSDEOPPrivName();
            }
            case 23: {
                return pSACHandlerBase.getFetchTimeout();
            }
            case 24: {
                return pSACHandlerBase.getFinishFlag();
            }
            case 25: {
                return pSACHandlerBase.getGetDraftPSDEActionId();
            }
            case 26: {
                return pSACHandlerBase.getGetDraftPSDEActionName();
            }
            case 27: {
                return pSACHandlerBase.getGetPSDEActionId();
            }
            case 28: {
                return pSACHandlerBase.getGetPSDEActionName();
            }
            case 29: {
                return pSACHandlerBase.getGetTimeout();
            }
            case 30: {
                return pSACHandlerBase.getGroupMovePSDEActionId();
            }
            case 31: {
                return pSACHandlerBase.getGroupMovePSDEActionName();
            }
            case 32: {
                return pSACHandlerBase.getGroupPSDEId();
            }
            case 33: {
                return pSACHandlerBase.getGroupPSDEName();
            }
            case 34: {
                return pSACHandlerBase.getHandlerObj();
            }
            case 35: {
                return pSACHandlerBase.getHandlerObj2();
            }
            case 36: {
                return pSACHandlerBase.getHandlerParams();
            }
            case 37: {
                return pSACHandlerBase.getHandlerTag();
            }
            case 38: {
                return pSACHandlerBase.getHandlerTag2();
            }
            case 39: {
                return pSACHandlerBase.getLockFlag();
            }
            case 40: {
                return pSACHandlerBase.getMemo();
            }
            case 41: {
                return pSACHandlerBase.getMovePSDEActionId();
            }
            case 42: {
                return pSACHandlerBase.getMovePSDEActionName();
            }
            case 43: {
                return pSACHandlerBase.getOrgDR();
            }
            case 44: {
                return pSACHandlerBase.getPSACHandlerId();
            }
            case 45: {
                return pSACHandlerBase.getPSACHandlerName();
            }
            case 46: {
                return pSACHandlerBase.getPSDEDataSetId();
            }
            case 47: {
                return pSACHandlerBase.getPSDEDataSetName();
            }
            case 48: {
                return pSACHandlerBase.getPSDEId();
            }
            case 49: {
                return pSACHandlerBase.getPSDEName();
            }
            case 50: {
                return pSACHandlerBase.getPSDynaInstId();
            }
            case 51: {
                return pSACHandlerBase.getPSModuleId();
            }
            case 52: {
                return pSACHandlerBase.getPSModuleName();
            }
            case 53: {
                return pSACHandlerBase.getPSSFACHandlerId();
            }
            case 54: {
                return pSACHandlerBase.getPSSFACHandlerName();
            }
            case 55: {
                return pSACHandlerBase.getPSSFId();
            }
            case 56: {
                return pSACHandlerBase.getPSSFName();
            }
            case 57: {
                return pSACHandlerBase.getPSSysDynaModelId();
            }
            case 58: {
                return pSACHandlerBase.getPSSysDynaModelName();
            }
            case 59: {
                return pSACHandlerBase.getPSSysReqItemId();
            }
            case 60: {
                return pSACHandlerBase.getPSSysReqItemName();
            }
            case 61: {
                return pSACHandlerBase.getPSSysTaskId();
            }
            case 62: {
                return pSACHandlerBase.getPSSysTaskName();
            }
            case 63: {
                return pSACHandlerBase.getPSSystemId();
            }
            case 64: {
                return pSACHandlerBase.getPSSystemName();
            }
            case 65: {
                return pSACHandlerBase.getPSSysUniStateId();
            }
            case 66: {
                return pSACHandlerBase.getPSSysUniStateName();
            }
            case 67: {
                return pSACHandlerBase.getPSSysUserDRId();
            }
            case 68: {
                return pSACHandlerBase.getPSSysUserDRId2();
            }
            case 69: {
                return pSACHandlerBase.getPSSysUserDRName();
            }
            case 70: {
                return pSACHandlerBase.getPSSysUserDRName2();
            }
            case 71: {
                return pSACHandlerBase.getReadPSDEOPPrivId();
            }
            case 72: {
                return pSACHandlerBase.getReadPSDEOPPrivName();
            }
            case 73: {
                return pSACHandlerBase.getRemovePSDEActionId();
            }
            case 74: {
                return pSACHandlerBase.getRemovePSDEActionName();
            }
            case 75: {
                return pSACHandlerBase.getRemovePSDEOPPrivId();
            }
            case 76: {
                return pSACHandlerBase.getRemovePSDEOPPrivName();
            }
            case 77: {
                return pSACHandlerBase.getRemoveTimeout();
            }
            case 78: {
                return pSACHandlerBase.getSecBC();
            }
            case 79: {
                return pSACHandlerBase.getSecDR();
            }
            case 80: {
                return pSACHandlerBase.getSysUserDR2Param();
            }
            case 81: {
                return pSACHandlerBase.getSysUserDRParam();
            }
            case 82: {
                return pSACHandlerBase.getTempMode();
            }
            case 83: {
                return pSACHandlerBase.getToDoTask();
            }
            case 84: {
                return pSACHandlerBase.getUniStateField();
            }
            case 85: {
                return pSACHandlerBase.getUniStateKeyValue();
            }
            case 86: {
                return pSACHandlerBase.getUpdateDate();
            }
            case 87: {
                return pSACHandlerBase.getUpdateMan();
            }
            case 88: {
                return pSACHandlerBase.getUpdatePSDEActionId();
            }
            case 89: {
                return pSACHandlerBase.getUpdatePSDEActionName();
            }
            case 90: {
                return pSACHandlerBase.getUpdatePSDEOPPrivId();
            }
            case 91: {
                return pSACHandlerBase.getUpdatePSDEOPPrivName();
            }
            case 92: {
                return pSACHandlerBase.getUpdateTimeout();
            }
            case 93: {
                return pSACHandlerBase.getUser2PSDEActionId();
            }
            case 94: {
                return pSACHandlerBase.getUser2PSDEActionName();
            }
            case 95: {
                return pSACHandlerBase.getUser2PSDEOPPrivId();
            }
            case 96: {
                return pSACHandlerBase.getUser2PSDEOPPrivName();
            }
            case 97: {
                return pSACHandlerBase.getUserCat();
            }
            case 98: {
                return pSACHandlerBase.getUserParams();
            }
            case 99: {
                return pSACHandlerBase.getUserPSDEActionId();
            }
            case 100: {
                return pSACHandlerBase.getUserPSDEActionName();
            }
            case 101: {
                return pSACHandlerBase.getUserPSDEOPPrivId();
            }
            case 102: {
                return pSACHandlerBase.getUserPSDEOPPrivName();
            }
            case 103: {
                return pSACHandlerBase.getUserTag();
            }
            case 104: {
                return pSACHandlerBase.getUserTag2();
            }
            case 105: {
                return pSACHandlerBase.getUserTag3();
            }
            case 106: {
                return pSACHandlerBase.getUserTag4();
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
        PSACHandlerBase.set(this, n, object);
    }

    private static void set(PSACHandlerBase pSACHandlerBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSACHandlerBase.setCacheScope(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSACHandlerBase.setCacheTimeout(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 2: {
                pSACHandlerBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSACHandlerBase.setCopyPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSACHandlerBase.setCopyPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSACHandlerBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSACHandlerBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSACHandlerBase.setCreatePSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSACHandlerBase.setCreatePSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSACHandlerBase.setCreatePSDEOPPrivId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSACHandlerBase.setCreatePSDEOPPrivIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSACHandlerBase.setCreateTimeout(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSACHandlerBase.setCtrlType(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSACHandlerBase.setCustomCond(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSACHandlerBase.setCustomType(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSACHandlerBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSACHandlerBase.setEnableCache(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSACHandlerBase.setEnableOrgDR(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSACHandlerBase.setEnableSecBC(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSACHandlerBase.setEnableSecDR(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 20: {
                pSACHandlerBase.setEnableUserDR(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 21: {
                pSACHandlerBase.setExportPSDEOPPrivId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSACHandlerBase.setExportPSDEOPPrivName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSACHandlerBase.setFetchTimeout(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 24: {
                pSACHandlerBase.setFinishFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 25: {
                pSACHandlerBase.setGetDraftPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSACHandlerBase.setGetDraftPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSACHandlerBase.setGetPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSACHandlerBase.setGetPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSACHandlerBase.setGetTimeout(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 30: {
                pSACHandlerBase.setGroupMovePSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSACHandlerBase.setGroupMovePSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSACHandlerBase.setGroupPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSACHandlerBase.setGroupPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSACHandlerBase.setHandlerObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSACHandlerBase.setHandlerObj2(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSACHandlerBase.setHandlerParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSACHandlerBase.setHandlerTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSACHandlerBase.setHandlerTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSACHandlerBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 40: {
                pSACHandlerBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSACHandlerBase.setMovePSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSACHandlerBase.setMovePSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSACHandlerBase.setOrgDR(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 44: {
                pSACHandlerBase.setPSACHandlerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSACHandlerBase.setPSACHandlerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSACHandlerBase.setPSDEDataSetId(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSACHandlerBase.setPSDEDataSetName(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSACHandlerBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSACHandlerBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSACHandlerBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSACHandlerBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSACHandlerBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSACHandlerBase.setPSSFACHandlerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSACHandlerBase.setPSSFACHandlerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSACHandlerBase.setPSSFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSACHandlerBase.setPSSFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSACHandlerBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 58: {
                pSACHandlerBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 59: {
                pSACHandlerBase.setPSSysReqItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 60: {
                pSACHandlerBase.setPSSysReqItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 61: {
                pSACHandlerBase.setPSSysTaskId(DataObject.getStringValue((Object)object));
                return;
            }
            case 62: {
                pSACHandlerBase.setPSSysTaskName(DataObject.getStringValue((Object)object));
                return;
            }
            case 63: {
                pSACHandlerBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 64: {
                pSACHandlerBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 65: {
                pSACHandlerBase.setPSSysUniStateId(DataObject.getStringValue((Object)object));
                return;
            }
            case 66: {
                pSACHandlerBase.setPSSysUniStateName(DataObject.getStringValue((Object)object));
                return;
            }
            case 67: {
                pSACHandlerBase.setPSSysUserDRId(DataObject.getStringValue((Object)object));
                return;
            }
            case 68: {
                pSACHandlerBase.setPSSysUserDRId2(DataObject.getStringValue((Object)object));
                return;
            }
            case 69: {
                pSACHandlerBase.setPSSysUserDRName(DataObject.getStringValue((Object)object));
                return;
            }
            case 70: {
                pSACHandlerBase.setPSSysUserDRName2(DataObject.getStringValue((Object)object));
                return;
            }
            case 71: {
                pSACHandlerBase.setReadPSDEOPPrivId(DataObject.getStringValue((Object)object));
                return;
            }
            case 72: {
                pSACHandlerBase.setReadPSDEOPPrivName(DataObject.getStringValue((Object)object));
                return;
            }
            case 73: {
                pSACHandlerBase.setRemovePSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 74: {
                pSACHandlerBase.setRemovePSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 75: {
                pSACHandlerBase.setRemovePSDEOPPrivId(DataObject.getStringValue((Object)object));
                return;
            }
            case 76: {
                pSACHandlerBase.setRemovePSDEOPPrivName(DataObject.getStringValue((Object)object));
                return;
            }
            case 77: {
                pSACHandlerBase.setRemoveTimeout(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 78: {
                pSACHandlerBase.setSecBC(DataObject.getStringValue((Object)object));
                return;
            }
            case 79: {
                pSACHandlerBase.setSecDR(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 80: {
                pSACHandlerBase.setSysUserDR2Param(DataObject.getStringValue((Object)object));
                return;
            }
            case 81: {
                pSACHandlerBase.setSysUserDRParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 82: {
                pSACHandlerBase.setTempMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 83: {
                pSACHandlerBase.setToDoTask(DataObject.getStringValue((Object)object));
                return;
            }
            case 84: {
                pSACHandlerBase.setUniStateField(DataObject.getStringValue((Object)object));
                return;
            }
            case 85: {
                pSACHandlerBase.setUniStateKeyValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 86: {
                pSACHandlerBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 87: {
                pSACHandlerBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 88: {
                pSACHandlerBase.setUpdatePSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 89: {
                pSACHandlerBase.setUpdatePSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 90: {
                pSACHandlerBase.setUpdatePSDEOPPrivId(DataObject.getStringValue((Object)object));
                return;
            }
            case 91: {
                pSACHandlerBase.setUpdatePSDEOPPrivName(DataObject.getStringValue((Object)object));
                return;
            }
            case 92: {
                pSACHandlerBase.setUpdateTimeout(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 93: {
                pSACHandlerBase.setUser2PSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 94: {
                pSACHandlerBase.setUser2PSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 95: {
                pSACHandlerBase.setUser2PSDEOPPrivId(DataObject.getStringValue((Object)object));
                return;
            }
            case 96: {
                pSACHandlerBase.setUser2PSDEOPPrivName(DataObject.getStringValue((Object)object));
                return;
            }
            case 97: {
                pSACHandlerBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 98: {
                pSACHandlerBase.setUserParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 99: {
                pSACHandlerBase.setUserPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 100: {
                pSACHandlerBase.setUserPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 101: {
                pSACHandlerBase.setUserPSDEOPPrivId(DataObject.getStringValue((Object)object));
                return;
            }
            case 102: {
                pSACHandlerBase.setUserPSDEOPPrivName(DataObject.getStringValue((Object)object));
                return;
            }
            case 103: {
                pSACHandlerBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 104: {
                pSACHandlerBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 105: {
                pSACHandlerBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 106: {
                pSACHandlerBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSACHandlerBase.isNull(this, n);
    }

    private static boolean isNull(PSACHandlerBase pSACHandlerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSACHandlerBase.getCacheScope() == null;
            }
            case 1: {
                return pSACHandlerBase.getCacheTimeout() == null;
            }
            case 2: {
                return pSACHandlerBase.getCodeName() == null;
            }
            case 3: {
                return pSACHandlerBase.getCopyPSDEActionId() == null;
            }
            case 4: {
                return pSACHandlerBase.getCopyPSDEActionName() == null;
            }
            case 5: {
                return pSACHandlerBase.getCreateDate() == null;
            }
            case 6: {
                return pSACHandlerBase.getCreateMan() == null;
            }
            case 7: {
                return pSACHandlerBase.getCreatePSDEActionId() == null;
            }
            case 8: {
                return pSACHandlerBase.getCreatePSDEActionName() == null;
            }
            case 9: {
                return pSACHandlerBase.getCreatePSDEOPPrivId() == null;
            }
            case 10: {
                return pSACHandlerBase.getCreatePSDEOPPrivIName() == null;
            }
            case 11: {
                return pSACHandlerBase.getCreateTimeout() == null;
            }
            case 12: {
                return pSACHandlerBase.getCtrlType() == null;
            }
            case 13: {
                return pSACHandlerBase.getCustomCond() == null;
            }
            case 14: {
                return pSACHandlerBase.getCustomType() == null;
            }
            case 15: {
                return pSACHandlerBase.getDynaModelFlag() == null;
            }
            case 16: {
                return pSACHandlerBase.getEnableCache() == null;
            }
            case 17: {
                return pSACHandlerBase.getEnableOrgDR() == null;
            }
            case 18: {
                return pSACHandlerBase.getEnableSecBC() == null;
            }
            case 19: {
                return pSACHandlerBase.getEnableSecDR() == null;
            }
            case 20: {
                return pSACHandlerBase.getEnableUserDR() == null;
            }
            case 21: {
                return pSACHandlerBase.getExportPSDEOPPrivId() == null;
            }
            case 22: {
                return pSACHandlerBase.getExportPSDEOPPrivName() == null;
            }
            case 23: {
                return pSACHandlerBase.getFetchTimeout() == null;
            }
            case 24: {
                return pSACHandlerBase.getFinishFlag() == null;
            }
            case 25: {
                return pSACHandlerBase.getGetDraftPSDEActionId() == null;
            }
            case 26: {
                return pSACHandlerBase.getGetDraftPSDEActionName() == null;
            }
            case 27: {
                return pSACHandlerBase.getGetPSDEActionId() == null;
            }
            case 28: {
                return pSACHandlerBase.getGetPSDEActionName() == null;
            }
            case 29: {
                return pSACHandlerBase.getGetTimeout() == null;
            }
            case 30: {
                return pSACHandlerBase.getGroupMovePSDEActionId() == null;
            }
            case 31: {
                return pSACHandlerBase.getGroupMovePSDEActionName() == null;
            }
            case 32: {
                return pSACHandlerBase.getGroupPSDEId() == null;
            }
            case 33: {
                return pSACHandlerBase.getGroupPSDEName() == null;
            }
            case 34: {
                return pSACHandlerBase.getHandlerObj() == null;
            }
            case 35: {
                return pSACHandlerBase.getHandlerObj2() == null;
            }
            case 36: {
                return pSACHandlerBase.getHandlerParams() == null;
            }
            case 37: {
                return pSACHandlerBase.getHandlerTag() == null;
            }
            case 38: {
                return pSACHandlerBase.getHandlerTag2() == null;
            }
            case 39: {
                return pSACHandlerBase.getLockFlag() == null;
            }
            case 40: {
                return pSACHandlerBase.getMemo() == null;
            }
            case 41: {
                return pSACHandlerBase.getMovePSDEActionId() == null;
            }
            case 42: {
                return pSACHandlerBase.getMovePSDEActionName() == null;
            }
            case 43: {
                return pSACHandlerBase.getOrgDR() == null;
            }
            case 44: {
                return pSACHandlerBase.getPSACHandlerId() == null;
            }
            case 45: {
                return pSACHandlerBase.getPSACHandlerName() == null;
            }
            case 46: {
                return pSACHandlerBase.getPSDEDataSetId() == null;
            }
            case 47: {
                return pSACHandlerBase.getPSDEDataSetName() == null;
            }
            case 48: {
                return pSACHandlerBase.getPSDEId() == null;
            }
            case 49: {
                return pSACHandlerBase.getPSDEName() == null;
            }
            case 50: {
                return pSACHandlerBase.getPSDynaInstId() == null;
            }
            case 51: {
                return pSACHandlerBase.getPSModuleId() == null;
            }
            case 52: {
                return pSACHandlerBase.getPSModuleName() == null;
            }
            case 53: {
                return pSACHandlerBase.getPSSFACHandlerId() == null;
            }
            case 54: {
                return pSACHandlerBase.getPSSFACHandlerName() == null;
            }
            case 55: {
                return pSACHandlerBase.getPSSFId() == null;
            }
            case 56: {
                return pSACHandlerBase.getPSSFName() == null;
            }
            case 57: {
                return pSACHandlerBase.getPSSysDynaModelId() == null;
            }
            case 58: {
                return pSACHandlerBase.getPSSysDynaModelName() == null;
            }
            case 59: {
                return pSACHandlerBase.getPSSysReqItemId() == null;
            }
            case 60: {
                return pSACHandlerBase.getPSSysReqItemName() == null;
            }
            case 61: {
                return pSACHandlerBase.getPSSysTaskId() == null;
            }
            case 62: {
                return pSACHandlerBase.getPSSysTaskName() == null;
            }
            case 63: {
                return pSACHandlerBase.getPSSystemId() == null;
            }
            case 64: {
                return pSACHandlerBase.getPSSystemName() == null;
            }
            case 65: {
                return pSACHandlerBase.getPSSysUniStateId() == null;
            }
            case 66: {
                return pSACHandlerBase.getPSSysUniStateName() == null;
            }
            case 67: {
                return pSACHandlerBase.getPSSysUserDRId() == null;
            }
            case 68: {
                return pSACHandlerBase.getPSSysUserDRId2() == null;
            }
            case 69: {
                return pSACHandlerBase.getPSSysUserDRName() == null;
            }
            case 70: {
                return pSACHandlerBase.getPSSysUserDRName2() == null;
            }
            case 71: {
                return pSACHandlerBase.getReadPSDEOPPrivId() == null;
            }
            case 72: {
                return pSACHandlerBase.getReadPSDEOPPrivName() == null;
            }
            case 73: {
                return pSACHandlerBase.getRemovePSDEActionId() == null;
            }
            case 74: {
                return pSACHandlerBase.getRemovePSDEActionName() == null;
            }
            case 75: {
                return pSACHandlerBase.getRemovePSDEOPPrivId() == null;
            }
            case 76: {
                return pSACHandlerBase.getRemovePSDEOPPrivName() == null;
            }
            case 77: {
                return pSACHandlerBase.getRemoveTimeout() == null;
            }
            case 78: {
                return pSACHandlerBase.getSecBC() == null;
            }
            case 79: {
                return pSACHandlerBase.getSecDR() == null;
            }
            case 80: {
                return pSACHandlerBase.getSysUserDR2Param() == null;
            }
            case 81: {
                return pSACHandlerBase.getSysUserDRParam() == null;
            }
            case 82: {
                return pSACHandlerBase.getTempMode() == null;
            }
            case 83: {
                return pSACHandlerBase.getToDoTask() == null;
            }
            case 84: {
                return pSACHandlerBase.getUniStateField() == null;
            }
            case 85: {
                return pSACHandlerBase.getUniStateKeyValue() == null;
            }
            case 86: {
                return pSACHandlerBase.getUpdateDate() == null;
            }
            case 87: {
                return pSACHandlerBase.getUpdateMan() == null;
            }
            case 88: {
                return pSACHandlerBase.getUpdatePSDEActionId() == null;
            }
            case 89: {
                return pSACHandlerBase.getUpdatePSDEActionName() == null;
            }
            case 90: {
                return pSACHandlerBase.getUpdatePSDEOPPrivId() == null;
            }
            case 91: {
                return pSACHandlerBase.getUpdatePSDEOPPrivName() == null;
            }
            case 92: {
                return pSACHandlerBase.getUpdateTimeout() == null;
            }
            case 93: {
                return pSACHandlerBase.getUser2PSDEActionId() == null;
            }
            case 94: {
                return pSACHandlerBase.getUser2PSDEActionName() == null;
            }
            case 95: {
                return pSACHandlerBase.getUser2PSDEOPPrivId() == null;
            }
            case 96: {
                return pSACHandlerBase.getUser2PSDEOPPrivName() == null;
            }
            case 97: {
                return pSACHandlerBase.getUserCat() == null;
            }
            case 98: {
                return pSACHandlerBase.getUserParams() == null;
            }
            case 99: {
                return pSACHandlerBase.getUserPSDEActionId() == null;
            }
            case 100: {
                return pSACHandlerBase.getUserPSDEActionName() == null;
            }
            case 101: {
                return pSACHandlerBase.getUserPSDEOPPrivId() == null;
            }
            case 102: {
                return pSACHandlerBase.getUserPSDEOPPrivName() == null;
            }
            case 103: {
                return pSACHandlerBase.getUserTag() == null;
            }
            case 104: {
                return pSACHandlerBase.getUserTag2() == null;
            }
            case 105: {
                return pSACHandlerBase.getUserTag3() == null;
            }
            case 106: {
                return pSACHandlerBase.getUserTag4() == null;
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
        return PSACHandlerBase.contains(this, n);
    }

    private static boolean contains(PSACHandlerBase pSACHandlerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSACHandlerBase.isCacheScopeDirty();
            }
            case 1: {
                return pSACHandlerBase.isCacheTimeoutDirty();
            }
            case 2: {
                return pSACHandlerBase.isCodeNameDirty();
            }
            case 3: {
                return pSACHandlerBase.isCopyPSDEActionIdDirty();
            }
            case 4: {
                return pSACHandlerBase.isCopyPSDEActionNameDirty();
            }
            case 5: {
                return pSACHandlerBase.isCreateDateDirty();
            }
            case 6: {
                return pSACHandlerBase.isCreateManDirty();
            }
            case 7: {
                return pSACHandlerBase.isCreatePSDEActionIdDirty();
            }
            case 8: {
                return pSACHandlerBase.isCreatePSDEActionNameDirty();
            }
            case 9: {
                return pSACHandlerBase.isCreatePSDEOPPrivIdDirty();
            }
            case 10: {
                return pSACHandlerBase.isCreatePSDEOPPrivINameDirty();
            }
            case 11: {
                return pSACHandlerBase.isCreateTimeoutDirty();
            }
            case 12: {
                return pSACHandlerBase.isCtrlTypeDirty();
            }
            case 13: {
                return pSACHandlerBase.isCustomCondDirty();
            }
            case 14: {
                return pSACHandlerBase.isCustomTypeDirty();
            }
            case 15: {
                return pSACHandlerBase.isDynaModelFlagDirty();
            }
            case 16: {
                return pSACHandlerBase.isEnableCacheDirty();
            }
            case 17: {
                return pSACHandlerBase.isEnableOrgDRDirty();
            }
            case 18: {
                return pSACHandlerBase.isEnableSecBCDirty();
            }
            case 19: {
                return pSACHandlerBase.isEnableSecDRDirty();
            }
            case 20: {
                return pSACHandlerBase.isEnableUserDRDirty();
            }
            case 21: {
                return pSACHandlerBase.isExportPSDEOPPrivIdDirty();
            }
            case 22: {
                return pSACHandlerBase.isExportPSDEOPPrivNameDirty();
            }
            case 23: {
                return pSACHandlerBase.isFetchTimeoutDirty();
            }
            case 24: {
                return pSACHandlerBase.isFinishFlagDirty();
            }
            case 25: {
                return pSACHandlerBase.isGetDraftPSDEActionIdDirty();
            }
            case 26: {
                return pSACHandlerBase.isGetDraftPSDEActionNameDirty();
            }
            case 27: {
                return pSACHandlerBase.isGetPSDEActionIdDirty();
            }
            case 28: {
                return pSACHandlerBase.isGetPSDEActionNameDirty();
            }
            case 29: {
                return pSACHandlerBase.isGetTimeoutDirty();
            }
            case 30: {
                return pSACHandlerBase.isGroupMovePSDEActionIdDirty();
            }
            case 31: {
                return pSACHandlerBase.isGroupMovePSDEActionNameDirty();
            }
            case 32: {
                return pSACHandlerBase.isGroupPSDEIdDirty();
            }
            case 33: {
                return pSACHandlerBase.isGroupPSDENameDirty();
            }
            case 34: {
                return pSACHandlerBase.isHandlerObjDirty();
            }
            case 35: {
                return pSACHandlerBase.isHandlerObj2Dirty();
            }
            case 36: {
                return pSACHandlerBase.isHandlerParamsDirty();
            }
            case 37: {
                return pSACHandlerBase.isHandlerTagDirty();
            }
            case 38: {
                return pSACHandlerBase.isHandlerTag2Dirty();
            }
            case 39: {
                return pSACHandlerBase.isLockFlagDirty();
            }
            case 40: {
                return pSACHandlerBase.isMemoDirty();
            }
            case 41: {
                return pSACHandlerBase.isMovePSDEActionIdDirty();
            }
            case 42: {
                return pSACHandlerBase.isMovePSDEActionNameDirty();
            }
            case 43: {
                return pSACHandlerBase.isOrgDRDirty();
            }
            case 44: {
                return pSACHandlerBase.isPSACHandlerIdDirty();
            }
            case 45: {
                return pSACHandlerBase.isPSACHandlerNameDirty();
            }
            case 46: {
                return pSACHandlerBase.isPSDEDataSetIdDirty();
            }
            case 47: {
                return pSACHandlerBase.isPSDEDataSetNameDirty();
            }
            case 48: {
                return pSACHandlerBase.isPSDEIdDirty();
            }
            case 49: {
                return pSACHandlerBase.isPSDENameDirty();
            }
            case 50: {
                return pSACHandlerBase.isPSDynaInstIdDirty();
            }
            case 51: {
                return pSACHandlerBase.isPSModuleIdDirty();
            }
            case 52: {
                return pSACHandlerBase.isPSModuleNameDirty();
            }
            case 53: {
                return pSACHandlerBase.isPSSFACHandlerIdDirty();
            }
            case 54: {
                return pSACHandlerBase.isPSSFACHandlerNameDirty();
            }
            case 55: {
                return pSACHandlerBase.isPSSFIdDirty();
            }
            case 56: {
                return pSACHandlerBase.isPSSFNameDirty();
            }
            case 57: {
                return pSACHandlerBase.isPSSysDynaModelIdDirty();
            }
            case 58: {
                return pSACHandlerBase.isPSSysDynaModelNameDirty();
            }
            case 59: {
                return pSACHandlerBase.isPSSysReqItemIdDirty();
            }
            case 60: {
                return pSACHandlerBase.isPSSysReqItemNameDirty();
            }
            case 61: {
                return pSACHandlerBase.isPSSysTaskIdDirty();
            }
            case 62: {
                return pSACHandlerBase.isPSSysTaskNameDirty();
            }
            case 63: {
                return pSACHandlerBase.isPSSystemIdDirty();
            }
            case 64: {
                return pSACHandlerBase.isPSSystemNameDirty();
            }
            case 65: {
                return pSACHandlerBase.isPSSysUniStateIdDirty();
            }
            case 66: {
                return pSACHandlerBase.isPSSysUniStateNameDirty();
            }
            case 67: {
                return pSACHandlerBase.isPSSysUserDRIdDirty();
            }
            case 68: {
                return pSACHandlerBase.isPSSysUserDRId2Dirty();
            }
            case 69: {
                return pSACHandlerBase.isPSSysUserDRNameDirty();
            }
            case 70: {
                return pSACHandlerBase.isPSSysUserDRName2Dirty();
            }
            case 71: {
                return pSACHandlerBase.isReadPSDEOPPrivIdDirty();
            }
            case 72: {
                return pSACHandlerBase.isReadPSDEOPPrivNameDirty();
            }
            case 73: {
                return pSACHandlerBase.isRemovePSDEActionIdDirty();
            }
            case 74: {
                return pSACHandlerBase.isRemovePSDEActionNameDirty();
            }
            case 75: {
                return pSACHandlerBase.isRemovePSDEOPPrivIdDirty();
            }
            case 76: {
                return pSACHandlerBase.isRemovePSDEOPPrivNameDirty();
            }
            case 77: {
                return pSACHandlerBase.isRemoveTimeoutDirty();
            }
            case 78: {
                return pSACHandlerBase.isSecBCDirty();
            }
            case 79: {
                return pSACHandlerBase.isSecDRDirty();
            }
            case 80: {
                return pSACHandlerBase.isSysUserDR2ParamDirty();
            }
            case 81: {
                return pSACHandlerBase.isSysUserDRParamDirty();
            }
            case 82: {
                return pSACHandlerBase.isTempModeDirty();
            }
            case 83: {
                return pSACHandlerBase.isToDoTaskDirty();
            }
            case 84: {
                return pSACHandlerBase.isUniStateFieldDirty();
            }
            case 85: {
                return pSACHandlerBase.isUniStateKeyValueDirty();
            }
            case 86: {
                return pSACHandlerBase.isUpdateDateDirty();
            }
            case 87: {
                return pSACHandlerBase.isUpdateManDirty();
            }
            case 88: {
                return pSACHandlerBase.isUpdatePSDEActionIdDirty();
            }
            case 89: {
                return pSACHandlerBase.isUpdatePSDEActionNameDirty();
            }
            case 90: {
                return pSACHandlerBase.isUpdatePSDEOPPrivIdDirty();
            }
            case 91: {
                return pSACHandlerBase.isUpdatePSDEOPPrivNameDirty();
            }
            case 92: {
                return pSACHandlerBase.isUpdateTimeoutDirty();
            }
            case 93: {
                return pSACHandlerBase.isUser2PSDEActionIdDirty();
            }
            case 94: {
                return pSACHandlerBase.isUser2PSDEActionNameDirty();
            }
            case 95: {
                return pSACHandlerBase.isUser2PSDEOPPrivIdDirty();
            }
            case 96: {
                return pSACHandlerBase.isUser2PSDEOPPrivNameDirty();
            }
            case 97: {
                return pSACHandlerBase.isUserCatDirty();
            }
            case 98: {
                return pSACHandlerBase.isUserParamsDirty();
            }
            case 99: {
                return pSACHandlerBase.isUserPSDEActionIdDirty();
            }
            case 100: {
                return pSACHandlerBase.isUserPSDEActionNameDirty();
            }
            case 101: {
                return pSACHandlerBase.isUserPSDEOPPrivIdDirty();
            }
            case 102: {
                return pSACHandlerBase.isUserPSDEOPPrivNameDirty();
            }
            case 103: {
                return pSACHandlerBase.isUserTagDirty();
            }
            case 104: {
                return pSACHandlerBase.isUserTag2Dirty();
            }
            case 105: {
                return pSACHandlerBase.isUserTag3Dirty();
            }
            case 106: {
                return pSACHandlerBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSACHandlerBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSACHandlerBase pSACHandlerBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSACHandlerBase.getCacheScope() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cachescope", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getCacheScope()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getCacheTimeout() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cachetimeout", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getCacheTimeout()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getCodeName()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getCopyPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"copypsdeactionid", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getCopyPSDEActionId()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getCopyPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"copypsdeactionname", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getCopyPSDEActionName()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getCreatePSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createpsdeactionid", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getCreatePSDEActionId()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getCreatePSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createpsdeactionname", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getCreatePSDEActionName()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getCreatePSDEOPPrivId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createpsdeopprivid", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getCreatePSDEOPPrivId()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getCreatePSDEOPPrivIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createpsdeoppriviname", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getCreatePSDEOPPrivIName()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getCreateTimeout() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createtimeout", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getCreateTimeout()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getCtrlType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrltype", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getCtrlType()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getCustomCond() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcond", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getCustomCond()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getCustomType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customtype", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getCustomType()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getEnableCache() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablecache", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getEnableCache()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getEnableOrgDR() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableorgdr", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getEnableOrgDR()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getEnableSecBC() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablesecbc", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getEnableSecBC()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getEnableSecDR() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablesecdr", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getEnableSecDR()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getEnableUserDR() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableuserdr", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getEnableUserDR()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getExportPSDEOPPrivId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"exportpsdeopprivid", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getExportPSDEOPPrivId()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getExportPSDEOPPrivName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"exportpsdeoppriviname", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getExportPSDEOPPrivName()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getFetchTimeout() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fetchtimeout", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getFetchTimeout()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getFinishFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"finishflag", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getFinishFlag()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getGetDraftPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"getdraftpsdeactionid", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getGetDraftPSDEActionId()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getGetDraftPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"getdraftpsdeactionname", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getGetDraftPSDEActionName()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getGetPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"getpsdeactionid", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getGetPSDEActionId()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getGetPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"getpsdeactionname", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getGetPSDEActionName()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getGetTimeout() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gettimeout", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getGetTimeout()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getGroupMovePSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"groupmovepsdeactionid", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getGroupMovePSDEActionId()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getGroupMovePSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"groupmovepsdeactionname", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getGroupMovePSDEActionName()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getGroupPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouppsdeid", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getGroupPSDEId()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getGroupPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouppsdename", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getGroupPSDEName()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getHandlerObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"handlerobj", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getHandlerObj()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getHandlerObj2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"handlerobj2", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getHandlerObj2()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getHandlerParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"handlerparams", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getHandlerParams()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getHandlerTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"handlertag", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getHandlerTag()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getHandlerTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"handlertag2", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getHandlerTag2()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getMemo()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getMovePSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"movepsdeactionid", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getMovePSDEActionId()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getMovePSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"movepsdeactionname", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getMovePSDEActionName()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getOrgDR() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"orgdr", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getOrgDR()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getPSACHandlerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psachandlerid", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getPSACHandlerId()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getPSACHandlerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psachandlername", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getPSACHandlerName()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getPSDEDataSetId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedatasetid", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getPSDEDataSetId()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getPSDEDataSetName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedatasetname", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getPSDEDataSetName()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getPSSFACHandlerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfachandlerid", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getPSSFACHandlerId()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getPSSFACHandlerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfachandlername", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getPSSFACHandlerName()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getPSSFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfid", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getPSSFId()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getPSSFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfname", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getPSSFName()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getPSSysReqItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemid", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getPSSysReqItemId()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getPSSysReqItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemname", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getPSSysReqItemName()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getPSSysTaskId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystaskid", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getPSSysTaskId()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getPSSysTaskName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystaskname", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getPSSysTaskName()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getPSSysUniStateId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysunistateid", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getPSSysUniStateId()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getPSSysUniStateName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysunistatename", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getPSSysUniStateName()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getPSSysUserDRId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuserdrid", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getPSSysUserDRId()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getPSSysUserDRId2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuserdrid2", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getPSSysUserDRId2()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getPSSysUserDRName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuserdrname", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getPSSysUserDRName()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getPSSysUserDRName2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuserdrname2", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getPSSysUserDRName2()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getReadPSDEOPPrivId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"readpsdeopprivid", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getReadPSDEOPPrivId()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getReadPSDEOPPrivName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"readpsdeopprivname", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getReadPSDEOPPrivName()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getRemovePSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"removepsdeactionid", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getRemovePSDEActionId()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getRemovePSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"removepsdeactionname", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getRemovePSDEActionName()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getRemovePSDEOPPrivId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"removepsdeopprivid", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getRemovePSDEOPPrivId()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getRemovePSDEOPPrivName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"removepsdeopprivname", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getRemovePSDEOPPrivName()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getRemoveTimeout() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"removetimeout", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getRemoveTimeout()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getSecBC() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"secbc", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getSecBC()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getSecDR() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"secdr", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getSecDR()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getSysUserDR2Param() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sysuserdr2param", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getSysUserDR2Param()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getSysUserDRParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sysuserdrparam", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getSysUserDRParam()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getTempMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tempmode", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getTempMode()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getToDoTask() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"todotask", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getToDoTask()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getUniStateField() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"unistatefield", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getUniStateField()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getUniStateKeyValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"unistatekeyvalue", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getUniStateKeyValue()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getUpdatePSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatepsdeactionid", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getUpdatePSDEActionId()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getUpdatePSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatepsdeactionname", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getUpdatePSDEActionName()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getUpdatePSDEOPPrivId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatepsdeopprivid", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getUpdatePSDEOPPrivId()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getUpdatePSDEOPPrivName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatepsdeopprivname", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getUpdatePSDEOPPrivName()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getUpdateTimeout() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatetimeout", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getUpdateTimeout()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getUser2PSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"user2psdeactionid", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getUser2PSDEActionId()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getUser2PSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"user2psdeactionname", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getUser2PSDEActionName()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getUser2PSDEOPPrivId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"user2psdeopprivid", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getUser2PSDEOPPrivId()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getUser2PSDEOPPrivName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"user2psdeoppriviname", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getUser2PSDEOPPrivName()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getUserCat()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getUserParams()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getUserPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userpsdeactionid", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getUserPSDEActionId()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getUserPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userpsdeactionname", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getUserPSDEActionName()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getUserPSDEOPPrivId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userpsdeopprivid", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getUserPSDEOPPrivId()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getUserPSDEOPPrivName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userpsdeoppriviname", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getUserPSDEOPPrivName()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getUserTag()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSACHandlerBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSACHandlerBase.getJSONValue((Object)pSACHandlerBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSACHandlerBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSACHandlerBase pSACHandlerBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSACHandlerBase.getCacheScope() != null) {
            object = pSACHandlerBase.getCacheScope();
            xmlNode.setAttribute(FIELD_CACHESCOPE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSACHandlerBase.getCacheTimeout() != null) {
            object = pSACHandlerBase.getCacheTimeout();
            xmlNode.setAttribute(FIELD_CACHETIMEOUT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSACHandlerBase.getCodeName() != null) {
            object = pSACHandlerBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getCopyPSDEActionId() != null) {
            object = pSACHandlerBase.getCopyPSDEActionId();
            xmlNode.setAttribute(FIELD_COPYPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getCopyPSDEActionName() != null) {
            object = pSACHandlerBase.getCopyPSDEActionName();
            xmlNode.setAttribute(FIELD_COPYPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getCreateDate() != null) {
            object = pSACHandlerBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSACHandlerBase.getCreateMan() != null) {
            object = pSACHandlerBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getCreatePSDEActionId() != null) {
            object = pSACHandlerBase.getCreatePSDEActionId();
            xmlNode.setAttribute(FIELD_CREATEPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getCreatePSDEActionName() != null) {
            object = pSACHandlerBase.getCreatePSDEActionName();
            xmlNode.setAttribute(FIELD_CREATEPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getCreatePSDEOPPrivId() != null) {
            object = pSACHandlerBase.getCreatePSDEOPPrivId();
            xmlNode.setAttribute(FIELD_CREATEPSDEOPPRIVID, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getCreatePSDEOPPrivIName() != null) {
            object = pSACHandlerBase.getCreatePSDEOPPrivIName();
            xmlNode.setAttribute(FIELD_CREATEPSDEOPPRIVINAME, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getCreateTimeout() != null) {
            object = pSACHandlerBase.getCreateTimeout();
            xmlNode.setAttribute(FIELD_CREATETIMEOUT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSACHandlerBase.getCtrlType() != null) {
            object = pSACHandlerBase.getCtrlType();
            xmlNode.setAttribute(FIELD_CTRLTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getCustomCond() != null) {
            object = pSACHandlerBase.getCustomCond();
            xmlNode.setAttribute(FIELD_CUSTOMCOND, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getCustomType() != null) {
            object = pSACHandlerBase.getCustomType();
            xmlNode.setAttribute(FIELD_CUSTOMTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getDynaModelFlag() != null) {
            object = pSACHandlerBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSACHandlerBase.getEnableCache() != null) {
            object = pSACHandlerBase.getEnableCache();
            xmlNode.setAttribute(FIELD_ENABLECACHE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSACHandlerBase.getEnableOrgDR() != null) {
            object = pSACHandlerBase.getEnableOrgDR();
            xmlNode.setAttribute(FIELD_ENABLEORGDR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSACHandlerBase.getEnableSecBC() != null) {
            object = pSACHandlerBase.getEnableSecBC();
            xmlNode.setAttribute(FIELD_ENABLESECBC, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSACHandlerBase.getEnableSecDR() != null) {
            object = pSACHandlerBase.getEnableSecDR();
            xmlNode.setAttribute(FIELD_ENABLESECDR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSACHandlerBase.getEnableUserDR() != null) {
            object = pSACHandlerBase.getEnableUserDR();
            xmlNode.setAttribute(FIELD_ENABLEUSERDR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSACHandlerBase.getExportPSDEOPPrivId() != null) {
            object = pSACHandlerBase.getExportPSDEOPPrivId();
            xmlNode.setAttribute(FIELD_EXPORTPSDEOPPRIVID, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getExportPSDEOPPrivName() != null) {
            object = pSACHandlerBase.getExportPSDEOPPrivName();
            xmlNode.setAttribute("EXPORTPSDEOPPRIVNAME", object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getFetchTimeout() != null) {
            object = pSACHandlerBase.getFetchTimeout();
            xmlNode.setAttribute(FIELD_FETCHTIMEOUT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSACHandlerBase.getFinishFlag() != null) {
            object = pSACHandlerBase.getFinishFlag();
            xmlNode.setAttribute(FIELD_FINISHFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSACHandlerBase.getGetDraftPSDEActionId() != null) {
            object = pSACHandlerBase.getGetDraftPSDEActionId();
            xmlNode.setAttribute(FIELD_GETDRAFTPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getGetDraftPSDEActionName() != null) {
            object = pSACHandlerBase.getGetDraftPSDEActionName();
            xmlNode.setAttribute(FIELD_GETDRAFTPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getGetPSDEActionId() != null) {
            object = pSACHandlerBase.getGetPSDEActionId();
            xmlNode.setAttribute(FIELD_GETPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getGetPSDEActionName() != null) {
            object = pSACHandlerBase.getGetPSDEActionName();
            xmlNode.setAttribute(FIELD_GETPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getGetTimeout() != null) {
            object = pSACHandlerBase.getGetTimeout();
            xmlNode.setAttribute(FIELD_GETTIMEOUT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSACHandlerBase.getGroupMovePSDEActionId() != null) {
            object = pSACHandlerBase.getGroupMovePSDEActionId();
            xmlNode.setAttribute(FIELD_GROUPMOVEPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getGroupMovePSDEActionName() != null) {
            object = pSACHandlerBase.getGroupMovePSDEActionName();
            xmlNode.setAttribute(FIELD_GROUPMOVEPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getGroupPSDEId() != null) {
            object = pSACHandlerBase.getGroupPSDEId();
            xmlNode.setAttribute(FIELD_GROUPPSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getGroupPSDEName() != null) {
            object = pSACHandlerBase.getGroupPSDEName();
            xmlNode.setAttribute(FIELD_GROUPPSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getHandlerObj() != null) {
            object = pSACHandlerBase.getHandlerObj();
            xmlNode.setAttribute(FIELD_HANDLEROBJ, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getHandlerObj2() != null) {
            object = pSACHandlerBase.getHandlerObj2();
            xmlNode.setAttribute(FIELD_HANDLEROBJ2, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getHandlerParams() != null) {
            object = pSACHandlerBase.getHandlerParams();
            xmlNode.setAttribute(FIELD_HANDLERPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getHandlerTag() != null) {
            object = pSACHandlerBase.getHandlerTag();
            xmlNode.setAttribute(FIELD_HANDLERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getHandlerTag2() != null) {
            object = pSACHandlerBase.getHandlerTag2();
            xmlNode.setAttribute(FIELD_HANDLERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getLockFlag() != null) {
            object = pSACHandlerBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSACHandlerBase.getMemo() != null) {
            object = pSACHandlerBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getMovePSDEActionId() != null) {
            object = pSACHandlerBase.getMovePSDEActionId();
            xmlNode.setAttribute(FIELD_MOVEPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getMovePSDEActionName() != null) {
            object = pSACHandlerBase.getMovePSDEActionName();
            xmlNode.setAttribute(FIELD_MOVEPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getOrgDR() != null) {
            object = pSACHandlerBase.getOrgDR();
            xmlNode.setAttribute(FIELD_ORGDR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSACHandlerBase.getPSACHandlerId() != null) {
            object = pSACHandlerBase.getPSACHandlerId();
            xmlNode.setAttribute(FIELD_PSACHANDLERID, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getPSACHandlerName() != null) {
            object = pSACHandlerBase.getPSACHandlerName();
            xmlNode.setAttribute(FIELD_PSACHANDLERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getPSDEDataSetId() != null) {
            object = pSACHandlerBase.getPSDEDataSetId();
            xmlNode.setAttribute(FIELD_PSDEDATASETID, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getPSDEDataSetName() != null) {
            object = pSACHandlerBase.getPSDEDataSetName();
            xmlNode.setAttribute(FIELD_PSDEDATASETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getPSDEId() != null) {
            object = pSACHandlerBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getPSDEName() != null) {
            object = pSACHandlerBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getPSDynaInstId() != null) {
            object = pSACHandlerBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getPSModuleId() != null) {
            object = pSACHandlerBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getPSModuleName() != null) {
            object = pSACHandlerBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getPSSFACHandlerId() != null) {
            object = pSACHandlerBase.getPSSFACHandlerId();
            xmlNode.setAttribute(FIELD_PSSFACHANDLERID, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getPSSFACHandlerName() != null) {
            object = pSACHandlerBase.getPSSFACHandlerName();
            xmlNode.setAttribute(FIELD_PSSFACHANDLERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getPSSFId() != null) {
            object = pSACHandlerBase.getPSSFId();
            xmlNode.setAttribute(FIELD_PSSFID, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getPSSFName() != null) {
            object = pSACHandlerBase.getPSSFName();
            xmlNode.setAttribute(FIELD_PSSFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getPSSysDynaModelId() != null) {
            object = pSACHandlerBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getPSSysDynaModelName() != null) {
            object = pSACHandlerBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getPSSysReqItemId() != null) {
            object = pSACHandlerBase.getPSSysReqItemId();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getPSSysReqItemName() != null) {
            object = pSACHandlerBase.getPSSysReqItemName();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getPSSysTaskId() != null) {
            object = pSACHandlerBase.getPSSysTaskId();
            xmlNode.setAttribute(FIELD_PSSYSTASKID, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getPSSysTaskName() != null) {
            object = pSACHandlerBase.getPSSysTaskName();
            xmlNode.setAttribute(FIELD_PSSYSTASKNAME, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getPSSystemId() != null) {
            object = pSACHandlerBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getPSSystemName() != null) {
            object = pSACHandlerBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getPSSysUniStateId() != null) {
            object = pSACHandlerBase.getPSSysUniStateId();
            xmlNode.setAttribute(FIELD_PSSYSUNISTATEID, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getPSSysUniStateName() != null) {
            object = pSACHandlerBase.getPSSysUniStateName();
            xmlNode.setAttribute(FIELD_PSSYSUNISTATENAME, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getPSSysUserDRId() != null) {
            object = pSACHandlerBase.getPSSysUserDRId();
            xmlNode.setAttribute(FIELD_PSSYSUSERDRID, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getPSSysUserDRId2() != null) {
            object = pSACHandlerBase.getPSSysUserDRId2();
            xmlNode.setAttribute(FIELD_PSSYSUSERDRID2, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getPSSysUserDRName() != null) {
            object = pSACHandlerBase.getPSSysUserDRName();
            xmlNode.setAttribute(FIELD_PSSYSUSERDRNAME, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getPSSysUserDRName2() != null) {
            object = pSACHandlerBase.getPSSysUserDRName2();
            xmlNode.setAttribute(FIELD_PSSYSUSERDRNAME2, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getReadPSDEOPPrivId() != null) {
            object = pSACHandlerBase.getReadPSDEOPPrivId();
            xmlNode.setAttribute(FIELD_READPSDEOPPRIVID, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getReadPSDEOPPrivName() != null) {
            object = pSACHandlerBase.getReadPSDEOPPrivName();
            xmlNode.setAttribute(FIELD_READPSDEOPPRIVNAME, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getRemovePSDEActionId() != null) {
            object = pSACHandlerBase.getRemovePSDEActionId();
            xmlNode.setAttribute(FIELD_REMOVEPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getRemovePSDEActionName() != null) {
            object = pSACHandlerBase.getRemovePSDEActionName();
            xmlNode.setAttribute(FIELD_REMOVEPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getRemovePSDEOPPrivId() != null) {
            object = pSACHandlerBase.getRemovePSDEOPPrivId();
            xmlNode.setAttribute(FIELD_REMOVEPSDEOPPRIVID, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getRemovePSDEOPPrivName() != null) {
            object = pSACHandlerBase.getRemovePSDEOPPrivName();
            xmlNode.setAttribute(FIELD_REMOVEPSDEOPPRIVNAME, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getRemoveTimeout() != null) {
            object = pSACHandlerBase.getRemoveTimeout();
            xmlNode.setAttribute(FIELD_REMOVETIMEOUT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSACHandlerBase.getSecBC() != null) {
            object = pSACHandlerBase.getSecBC();
            xmlNode.setAttribute(FIELD_SECBC, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getSecDR() != null) {
            object = pSACHandlerBase.getSecDR();
            xmlNode.setAttribute(FIELD_SECDR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSACHandlerBase.getSysUserDR2Param() != null) {
            object = pSACHandlerBase.getSysUserDR2Param();
            xmlNode.setAttribute(FIELD_SYSUSERDR2PARAM, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getSysUserDRParam() != null) {
            object = pSACHandlerBase.getSysUserDRParam();
            xmlNode.setAttribute(FIELD_SYSUSERDRPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getTempMode() != null) {
            object = pSACHandlerBase.getTempMode();
            xmlNode.setAttribute(FIELD_TEMPMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSACHandlerBase.getToDoTask() != null) {
            object = pSACHandlerBase.getToDoTask();
            xmlNode.setAttribute(FIELD_TODOTASK, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getUniStateField() != null) {
            object = pSACHandlerBase.getUniStateField();
            xmlNode.setAttribute(FIELD_UNISTATEFIELD, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getUniStateKeyValue() != null) {
            object = pSACHandlerBase.getUniStateKeyValue();
            xmlNode.setAttribute(FIELD_UNISTATEKEYVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getUpdateDate() != null) {
            object = pSACHandlerBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSACHandlerBase.getUpdateMan() != null) {
            object = pSACHandlerBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getUpdatePSDEActionId() != null) {
            object = pSACHandlerBase.getUpdatePSDEActionId();
            xmlNode.setAttribute(FIELD_UPDATEPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getUpdatePSDEActionName() != null) {
            object = pSACHandlerBase.getUpdatePSDEActionName();
            xmlNode.setAttribute(FIELD_UPDATEPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getUpdatePSDEOPPrivId() != null) {
            object = pSACHandlerBase.getUpdatePSDEOPPrivId();
            xmlNode.setAttribute(FIELD_UPDATEPSDEOPPRIVID, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getUpdatePSDEOPPrivName() != null) {
            object = pSACHandlerBase.getUpdatePSDEOPPrivName();
            xmlNode.setAttribute(FIELD_UPDATEPSDEOPPRIVNAME, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getUpdateTimeout() != null) {
            object = pSACHandlerBase.getUpdateTimeout();
            xmlNode.setAttribute(FIELD_UPDATETIMEOUT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSACHandlerBase.getUser2PSDEActionId() != null) {
            object = pSACHandlerBase.getUser2PSDEActionId();
            xmlNode.setAttribute(FIELD_USER2PSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getUser2PSDEActionName() != null) {
            object = pSACHandlerBase.getUser2PSDEActionName();
            xmlNode.setAttribute(FIELD_USER2PSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getUser2PSDEOPPrivId() != null) {
            object = pSACHandlerBase.getUser2PSDEOPPrivId();
            xmlNode.setAttribute(FIELD_USER2PSDEOPPRIVID, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getUser2PSDEOPPrivName() != null) {
            object = pSACHandlerBase.getUser2PSDEOPPrivName();
            xmlNode.setAttribute("USER2PSDEOPPRIVNAME", object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getUserCat() != null) {
            object = pSACHandlerBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getUserParams() != null) {
            object = pSACHandlerBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getUserPSDEActionId() != null) {
            object = pSACHandlerBase.getUserPSDEActionId();
            xmlNode.setAttribute(FIELD_USERPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getUserPSDEActionName() != null) {
            object = pSACHandlerBase.getUserPSDEActionName();
            xmlNode.setAttribute(FIELD_USERPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getUserPSDEOPPrivId() != null) {
            object = pSACHandlerBase.getUserPSDEOPPrivId();
            xmlNode.setAttribute(FIELD_USERPSDEOPPRIVID, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getUserPSDEOPPrivName() != null) {
            object = pSACHandlerBase.getUserPSDEOPPrivName();
            xmlNode.setAttribute("USERPSDEOPPRIVNAME", object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getUserTag() != null) {
            object = pSACHandlerBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getUserTag2() != null) {
            object = pSACHandlerBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getUserTag3() != null) {
            object = pSACHandlerBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSACHandlerBase.getUserTag4() != null) {
            object = pSACHandlerBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSACHandlerBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSACHandlerBase pSACHandlerBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSACHandlerBase.isCacheScopeDirty() && (bl || pSACHandlerBase.getCacheScope() != null)) {
            iDataObject.set(FIELD_CACHESCOPE, (Object)pSACHandlerBase.getCacheScope());
        }
        if (pSACHandlerBase.isCacheTimeoutDirty() && (bl || pSACHandlerBase.getCacheTimeout() != null)) {
            iDataObject.set(FIELD_CACHETIMEOUT, (Object)pSACHandlerBase.getCacheTimeout());
        }
        if (pSACHandlerBase.isCodeNameDirty() && (bl || pSACHandlerBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSACHandlerBase.getCodeName());
        }
        if (pSACHandlerBase.isCopyPSDEActionIdDirty() && (bl || pSACHandlerBase.getCopyPSDEActionId() != null)) {
            iDataObject.set(FIELD_COPYPSDEACTIONID, (Object)pSACHandlerBase.getCopyPSDEActionId());
        }
        if (pSACHandlerBase.isCopyPSDEActionNameDirty() && (bl || pSACHandlerBase.getCopyPSDEActionName() != null)) {
            iDataObject.set(FIELD_COPYPSDEACTIONNAME, (Object)pSACHandlerBase.getCopyPSDEActionName());
        }
        if (pSACHandlerBase.isCreateDateDirty() && (bl || pSACHandlerBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSACHandlerBase.getCreateDate());
        }
        if (pSACHandlerBase.isCreateManDirty() && (bl || pSACHandlerBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSACHandlerBase.getCreateMan());
        }
        if (pSACHandlerBase.isCreatePSDEActionIdDirty() && (bl || pSACHandlerBase.getCreatePSDEActionId() != null)) {
            iDataObject.set(FIELD_CREATEPSDEACTIONID, (Object)pSACHandlerBase.getCreatePSDEActionId());
        }
        if (pSACHandlerBase.isCreatePSDEActionNameDirty() && (bl || pSACHandlerBase.getCreatePSDEActionName() != null)) {
            iDataObject.set(FIELD_CREATEPSDEACTIONNAME, (Object)pSACHandlerBase.getCreatePSDEActionName());
        }
        if (pSACHandlerBase.isCreatePSDEOPPrivIdDirty() && (bl || pSACHandlerBase.getCreatePSDEOPPrivId() != null)) {
            iDataObject.set(FIELD_CREATEPSDEOPPRIVID, (Object)pSACHandlerBase.getCreatePSDEOPPrivId());
        }
        if (pSACHandlerBase.isCreatePSDEOPPrivINameDirty() && (bl || pSACHandlerBase.getCreatePSDEOPPrivIName() != null)) {
            iDataObject.set(FIELD_CREATEPSDEOPPRIVINAME, (Object)pSACHandlerBase.getCreatePSDEOPPrivIName());
        }
        if (pSACHandlerBase.isCreateTimeoutDirty() && (bl || pSACHandlerBase.getCreateTimeout() != null)) {
            iDataObject.set(FIELD_CREATETIMEOUT, (Object)pSACHandlerBase.getCreateTimeout());
        }
        if (pSACHandlerBase.isCtrlTypeDirty() && (bl || pSACHandlerBase.getCtrlType() != null)) {
            iDataObject.set(FIELD_CTRLTYPE, (Object)pSACHandlerBase.getCtrlType());
        }
        if (pSACHandlerBase.isCustomCondDirty() && (bl || pSACHandlerBase.getCustomCond() != null)) {
            iDataObject.set(FIELD_CUSTOMCOND, (Object)pSACHandlerBase.getCustomCond());
        }
        if (pSACHandlerBase.isCustomTypeDirty() && (bl || pSACHandlerBase.getCustomType() != null)) {
            iDataObject.set(FIELD_CUSTOMTYPE, (Object)pSACHandlerBase.getCustomType());
        }
        if (pSACHandlerBase.isDynaModelFlagDirty() && (bl || pSACHandlerBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSACHandlerBase.getDynaModelFlag());
        }
        if (pSACHandlerBase.isEnableCacheDirty() && (bl || pSACHandlerBase.getEnableCache() != null)) {
            iDataObject.set(FIELD_ENABLECACHE, (Object)pSACHandlerBase.getEnableCache());
        }
        if (pSACHandlerBase.isEnableOrgDRDirty() && (bl || pSACHandlerBase.getEnableOrgDR() != null)) {
            iDataObject.set(FIELD_ENABLEORGDR, (Object)pSACHandlerBase.getEnableOrgDR());
        }
        if (pSACHandlerBase.isEnableSecBCDirty() && (bl || pSACHandlerBase.getEnableSecBC() != null)) {
            iDataObject.set(FIELD_ENABLESECBC, (Object)pSACHandlerBase.getEnableSecBC());
        }
        if (pSACHandlerBase.isEnableSecDRDirty() && (bl || pSACHandlerBase.getEnableSecDR() != null)) {
            iDataObject.set(FIELD_ENABLESECDR, (Object)pSACHandlerBase.getEnableSecDR());
        }
        if (pSACHandlerBase.isEnableUserDRDirty() && (bl || pSACHandlerBase.getEnableUserDR() != null)) {
            iDataObject.set(FIELD_ENABLEUSERDR, (Object)pSACHandlerBase.getEnableUserDR());
        }
        if (pSACHandlerBase.isExportPSDEOPPrivIdDirty() && (bl || pSACHandlerBase.getExportPSDEOPPrivId() != null)) {
            iDataObject.set(FIELD_EXPORTPSDEOPPRIVID, (Object)pSACHandlerBase.getExportPSDEOPPrivId());
        }
        if (pSACHandlerBase.isExportPSDEOPPrivNameDirty() && (bl || pSACHandlerBase.getExportPSDEOPPrivName() != null)) {
            iDataObject.set(FIELD_EXPORTPSDEOPPRIVNAME, (Object)pSACHandlerBase.getExportPSDEOPPrivName());
        }
        if (pSACHandlerBase.isFetchTimeoutDirty() && (bl || pSACHandlerBase.getFetchTimeout() != null)) {
            iDataObject.set(FIELD_FETCHTIMEOUT, (Object)pSACHandlerBase.getFetchTimeout());
        }
        if (pSACHandlerBase.isFinishFlagDirty() && (bl || pSACHandlerBase.getFinishFlag() != null)) {
            iDataObject.set(FIELD_FINISHFLAG, (Object)pSACHandlerBase.getFinishFlag());
        }
        if (pSACHandlerBase.isGetDraftPSDEActionIdDirty() && (bl || pSACHandlerBase.getGetDraftPSDEActionId() != null)) {
            iDataObject.set(FIELD_GETDRAFTPSDEACTIONID, (Object)pSACHandlerBase.getGetDraftPSDEActionId());
        }
        if (pSACHandlerBase.isGetDraftPSDEActionNameDirty() && (bl || pSACHandlerBase.getGetDraftPSDEActionName() != null)) {
            iDataObject.set(FIELD_GETDRAFTPSDEACTIONNAME, (Object)pSACHandlerBase.getGetDraftPSDEActionName());
        }
        if (pSACHandlerBase.isGetPSDEActionIdDirty() && (bl || pSACHandlerBase.getGetPSDEActionId() != null)) {
            iDataObject.set(FIELD_GETPSDEACTIONID, (Object)pSACHandlerBase.getGetPSDEActionId());
        }
        if (pSACHandlerBase.isGetPSDEActionNameDirty() && (bl || pSACHandlerBase.getGetPSDEActionName() != null)) {
            iDataObject.set(FIELD_GETPSDEACTIONNAME, (Object)pSACHandlerBase.getGetPSDEActionName());
        }
        if (pSACHandlerBase.isGetTimeoutDirty() && (bl || pSACHandlerBase.getGetTimeout() != null)) {
            iDataObject.set(FIELD_GETTIMEOUT, (Object)pSACHandlerBase.getGetTimeout());
        }
        if (pSACHandlerBase.isGroupMovePSDEActionIdDirty() && (bl || pSACHandlerBase.getGroupMovePSDEActionId() != null)) {
            iDataObject.set(FIELD_GROUPMOVEPSDEACTIONID, (Object)pSACHandlerBase.getGroupMovePSDEActionId());
        }
        if (pSACHandlerBase.isGroupMovePSDEActionNameDirty() && (bl || pSACHandlerBase.getGroupMovePSDEActionName() != null)) {
            iDataObject.set(FIELD_GROUPMOVEPSDEACTIONNAME, (Object)pSACHandlerBase.getGroupMovePSDEActionName());
        }
        if (pSACHandlerBase.isGroupPSDEIdDirty() && (bl || pSACHandlerBase.getGroupPSDEId() != null)) {
            iDataObject.set(FIELD_GROUPPSDEID, (Object)pSACHandlerBase.getGroupPSDEId());
        }
        if (pSACHandlerBase.isGroupPSDENameDirty() && (bl || pSACHandlerBase.getGroupPSDEName() != null)) {
            iDataObject.set(FIELD_GROUPPSDENAME, (Object)pSACHandlerBase.getGroupPSDEName());
        }
        if (pSACHandlerBase.isHandlerObjDirty() && (bl || pSACHandlerBase.getHandlerObj() != null)) {
            iDataObject.set(FIELD_HANDLEROBJ, (Object)pSACHandlerBase.getHandlerObj());
        }
        if (pSACHandlerBase.isHandlerObj2Dirty() && (bl || pSACHandlerBase.getHandlerObj2() != null)) {
            iDataObject.set(FIELD_HANDLEROBJ2, (Object)pSACHandlerBase.getHandlerObj2());
        }
        if (pSACHandlerBase.isHandlerParamsDirty() && (bl || pSACHandlerBase.getHandlerParams() != null)) {
            iDataObject.set(FIELD_HANDLERPARAMS, (Object)pSACHandlerBase.getHandlerParams());
        }
        if (pSACHandlerBase.isHandlerTagDirty() && (bl || pSACHandlerBase.getHandlerTag() != null)) {
            iDataObject.set(FIELD_HANDLERTAG, (Object)pSACHandlerBase.getHandlerTag());
        }
        if (pSACHandlerBase.isHandlerTag2Dirty() && (bl || pSACHandlerBase.getHandlerTag2() != null)) {
            iDataObject.set(FIELD_HANDLERTAG2, (Object)pSACHandlerBase.getHandlerTag2());
        }
        if (pSACHandlerBase.isLockFlagDirty() && (bl || pSACHandlerBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSACHandlerBase.getLockFlag());
        }
        if (pSACHandlerBase.isMemoDirty() && (bl || pSACHandlerBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSACHandlerBase.getMemo());
        }
        if (pSACHandlerBase.isMovePSDEActionIdDirty() && (bl || pSACHandlerBase.getMovePSDEActionId() != null)) {
            iDataObject.set(FIELD_MOVEPSDEACTIONID, (Object)pSACHandlerBase.getMovePSDEActionId());
        }
        if (pSACHandlerBase.isMovePSDEActionNameDirty() && (bl || pSACHandlerBase.getMovePSDEActionName() != null)) {
            iDataObject.set(FIELD_MOVEPSDEACTIONNAME, (Object)pSACHandlerBase.getMovePSDEActionName());
        }
        if (pSACHandlerBase.isOrgDRDirty() && (bl || pSACHandlerBase.getOrgDR() != null)) {
            iDataObject.set(FIELD_ORGDR, (Object)pSACHandlerBase.getOrgDR());
        }
        if (pSACHandlerBase.isPSACHandlerIdDirty() && (bl || pSACHandlerBase.getPSACHandlerId() != null)) {
            iDataObject.set(FIELD_PSACHANDLERID, (Object)pSACHandlerBase.getPSACHandlerId());
        }
        if (pSACHandlerBase.isPSACHandlerNameDirty() && (bl || pSACHandlerBase.getPSACHandlerName() != null)) {
            iDataObject.set(FIELD_PSACHANDLERNAME, (Object)pSACHandlerBase.getPSACHandlerName());
        }
        if (pSACHandlerBase.isPSDEDataSetIdDirty() && (bl || pSACHandlerBase.getPSDEDataSetId() != null)) {
            iDataObject.set(FIELD_PSDEDATASETID, (Object)pSACHandlerBase.getPSDEDataSetId());
        }
        if (pSACHandlerBase.isPSDEDataSetNameDirty() && (bl || pSACHandlerBase.getPSDEDataSetName() != null)) {
            iDataObject.set(FIELD_PSDEDATASETNAME, (Object)pSACHandlerBase.getPSDEDataSetName());
        }
        if (pSACHandlerBase.isPSDEIdDirty() && (bl || pSACHandlerBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSACHandlerBase.getPSDEId());
        }
        if (pSACHandlerBase.isPSDENameDirty() && (bl || pSACHandlerBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSACHandlerBase.getPSDEName());
        }
        if (pSACHandlerBase.isPSDynaInstIdDirty() && (bl || pSACHandlerBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSACHandlerBase.getPSDynaInstId());
        }
        if (pSACHandlerBase.isPSModuleIdDirty() && (bl || pSACHandlerBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSACHandlerBase.getPSModuleId());
        }
        if (pSACHandlerBase.isPSModuleNameDirty() && (bl || pSACHandlerBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSACHandlerBase.getPSModuleName());
        }
        if (pSACHandlerBase.isPSSFACHandlerIdDirty() && (bl || pSACHandlerBase.getPSSFACHandlerId() != null)) {
            iDataObject.set(FIELD_PSSFACHANDLERID, (Object)pSACHandlerBase.getPSSFACHandlerId());
        }
        if (pSACHandlerBase.isPSSFACHandlerNameDirty() && (bl || pSACHandlerBase.getPSSFACHandlerName() != null)) {
            iDataObject.set(FIELD_PSSFACHANDLERNAME, (Object)pSACHandlerBase.getPSSFACHandlerName());
        }
        if (pSACHandlerBase.isPSSFIdDirty() && (bl || pSACHandlerBase.getPSSFId() != null)) {
            iDataObject.set(FIELD_PSSFID, (Object)pSACHandlerBase.getPSSFId());
        }
        if (pSACHandlerBase.isPSSFNameDirty() && (bl || pSACHandlerBase.getPSSFName() != null)) {
            iDataObject.set(FIELD_PSSFNAME, (Object)pSACHandlerBase.getPSSFName());
        }
        if (pSACHandlerBase.isPSSysDynaModelIdDirty() && (bl || pSACHandlerBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSACHandlerBase.getPSSysDynaModelId());
        }
        if (pSACHandlerBase.isPSSysDynaModelNameDirty() && (bl || pSACHandlerBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSACHandlerBase.getPSSysDynaModelName());
        }
        if (pSACHandlerBase.isPSSysReqItemIdDirty() && (bl || pSACHandlerBase.getPSSysReqItemId() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMID, (Object)pSACHandlerBase.getPSSysReqItemId());
        }
        if (pSACHandlerBase.isPSSysReqItemNameDirty() && (bl || pSACHandlerBase.getPSSysReqItemName() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMNAME, (Object)pSACHandlerBase.getPSSysReqItemName());
        }
        if (pSACHandlerBase.isPSSysTaskIdDirty() && (bl || pSACHandlerBase.getPSSysTaskId() != null)) {
            iDataObject.set(FIELD_PSSYSTASKID, (Object)pSACHandlerBase.getPSSysTaskId());
        }
        if (pSACHandlerBase.isPSSysTaskNameDirty() && (bl || pSACHandlerBase.getPSSysTaskName() != null)) {
            iDataObject.set(FIELD_PSSYSTASKNAME, (Object)pSACHandlerBase.getPSSysTaskName());
        }
        if (pSACHandlerBase.isPSSystemIdDirty() && (bl || pSACHandlerBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSACHandlerBase.getPSSystemId());
        }
        if (pSACHandlerBase.isPSSystemNameDirty() && (bl || pSACHandlerBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSACHandlerBase.getPSSystemName());
        }
        if (pSACHandlerBase.isPSSysUniStateIdDirty() && (bl || pSACHandlerBase.getPSSysUniStateId() != null)) {
            iDataObject.set(FIELD_PSSYSUNISTATEID, (Object)pSACHandlerBase.getPSSysUniStateId());
        }
        if (pSACHandlerBase.isPSSysUniStateNameDirty() && (bl || pSACHandlerBase.getPSSysUniStateName() != null)) {
            iDataObject.set(FIELD_PSSYSUNISTATENAME, (Object)pSACHandlerBase.getPSSysUniStateName());
        }
        if (pSACHandlerBase.isPSSysUserDRIdDirty() && (bl || pSACHandlerBase.getPSSysUserDRId() != null)) {
            iDataObject.set(FIELD_PSSYSUSERDRID, (Object)pSACHandlerBase.getPSSysUserDRId());
        }
        if (pSACHandlerBase.isPSSysUserDRId2Dirty() && (bl || pSACHandlerBase.getPSSysUserDRId2() != null)) {
            iDataObject.set(FIELD_PSSYSUSERDRID2, (Object)pSACHandlerBase.getPSSysUserDRId2());
        }
        if (pSACHandlerBase.isPSSysUserDRNameDirty() && (bl || pSACHandlerBase.getPSSysUserDRName() != null)) {
            iDataObject.set(FIELD_PSSYSUSERDRNAME, (Object)pSACHandlerBase.getPSSysUserDRName());
        }
        if (pSACHandlerBase.isPSSysUserDRName2Dirty() && (bl || pSACHandlerBase.getPSSysUserDRName2() != null)) {
            iDataObject.set(FIELD_PSSYSUSERDRNAME2, (Object)pSACHandlerBase.getPSSysUserDRName2());
        }
        if (pSACHandlerBase.isReadPSDEOPPrivIdDirty() && (bl || pSACHandlerBase.getReadPSDEOPPrivId() != null)) {
            iDataObject.set(FIELD_READPSDEOPPRIVID, (Object)pSACHandlerBase.getReadPSDEOPPrivId());
        }
        if (pSACHandlerBase.isReadPSDEOPPrivNameDirty() && (bl || pSACHandlerBase.getReadPSDEOPPrivName() != null)) {
            iDataObject.set(FIELD_READPSDEOPPRIVNAME, (Object)pSACHandlerBase.getReadPSDEOPPrivName());
        }
        if (pSACHandlerBase.isRemovePSDEActionIdDirty() && (bl || pSACHandlerBase.getRemovePSDEActionId() != null)) {
            iDataObject.set(FIELD_REMOVEPSDEACTIONID, (Object)pSACHandlerBase.getRemovePSDEActionId());
        }
        if (pSACHandlerBase.isRemovePSDEActionNameDirty() && (bl || pSACHandlerBase.getRemovePSDEActionName() != null)) {
            iDataObject.set(FIELD_REMOVEPSDEACTIONNAME, (Object)pSACHandlerBase.getRemovePSDEActionName());
        }
        if (pSACHandlerBase.isRemovePSDEOPPrivIdDirty() && (bl || pSACHandlerBase.getRemovePSDEOPPrivId() != null)) {
            iDataObject.set(FIELD_REMOVEPSDEOPPRIVID, (Object)pSACHandlerBase.getRemovePSDEOPPrivId());
        }
        if (pSACHandlerBase.isRemovePSDEOPPrivNameDirty() && (bl || pSACHandlerBase.getRemovePSDEOPPrivName() != null)) {
            iDataObject.set(FIELD_REMOVEPSDEOPPRIVNAME, (Object)pSACHandlerBase.getRemovePSDEOPPrivName());
        }
        if (pSACHandlerBase.isRemoveTimeoutDirty() && (bl || pSACHandlerBase.getRemoveTimeout() != null)) {
            iDataObject.set(FIELD_REMOVETIMEOUT, (Object)pSACHandlerBase.getRemoveTimeout());
        }
        if (pSACHandlerBase.isSecBCDirty() && (bl || pSACHandlerBase.getSecBC() != null)) {
            iDataObject.set(FIELD_SECBC, (Object)pSACHandlerBase.getSecBC());
        }
        if (pSACHandlerBase.isSecDRDirty() && (bl || pSACHandlerBase.getSecDR() != null)) {
            iDataObject.set(FIELD_SECDR, (Object)pSACHandlerBase.getSecDR());
        }
        if (pSACHandlerBase.isSysUserDR2ParamDirty() && (bl || pSACHandlerBase.getSysUserDR2Param() != null)) {
            iDataObject.set(FIELD_SYSUSERDR2PARAM, (Object)pSACHandlerBase.getSysUserDR2Param());
        }
        if (pSACHandlerBase.isSysUserDRParamDirty() && (bl || pSACHandlerBase.getSysUserDRParam() != null)) {
            iDataObject.set(FIELD_SYSUSERDRPARAM, (Object)pSACHandlerBase.getSysUserDRParam());
        }
        if (pSACHandlerBase.isTempModeDirty() && (bl || pSACHandlerBase.getTempMode() != null)) {
            iDataObject.set(FIELD_TEMPMODE, (Object)pSACHandlerBase.getTempMode());
        }
        if (pSACHandlerBase.isToDoTaskDirty() && (bl || pSACHandlerBase.getToDoTask() != null)) {
            iDataObject.set(FIELD_TODOTASK, (Object)pSACHandlerBase.getToDoTask());
        }
        if (pSACHandlerBase.isUniStateFieldDirty() && (bl || pSACHandlerBase.getUniStateField() != null)) {
            iDataObject.set(FIELD_UNISTATEFIELD, (Object)pSACHandlerBase.getUniStateField());
        }
        if (pSACHandlerBase.isUniStateKeyValueDirty() && (bl || pSACHandlerBase.getUniStateKeyValue() != null)) {
            iDataObject.set(FIELD_UNISTATEKEYVALUE, (Object)pSACHandlerBase.getUniStateKeyValue());
        }
        if (pSACHandlerBase.isUpdateDateDirty() && (bl || pSACHandlerBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSACHandlerBase.getUpdateDate());
        }
        if (pSACHandlerBase.isUpdateManDirty() && (bl || pSACHandlerBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSACHandlerBase.getUpdateMan());
        }
        if (pSACHandlerBase.isUpdatePSDEActionIdDirty() && (bl || pSACHandlerBase.getUpdatePSDEActionId() != null)) {
            iDataObject.set(FIELD_UPDATEPSDEACTIONID, (Object)pSACHandlerBase.getUpdatePSDEActionId());
        }
        if (pSACHandlerBase.isUpdatePSDEActionNameDirty() && (bl || pSACHandlerBase.getUpdatePSDEActionName() != null)) {
            iDataObject.set(FIELD_UPDATEPSDEACTIONNAME, (Object)pSACHandlerBase.getUpdatePSDEActionName());
        }
        if (pSACHandlerBase.isUpdatePSDEOPPrivIdDirty() && (bl || pSACHandlerBase.getUpdatePSDEOPPrivId() != null)) {
            iDataObject.set(FIELD_UPDATEPSDEOPPRIVID, (Object)pSACHandlerBase.getUpdatePSDEOPPrivId());
        }
        if (pSACHandlerBase.isUpdatePSDEOPPrivNameDirty() && (bl || pSACHandlerBase.getUpdatePSDEOPPrivName() != null)) {
            iDataObject.set(FIELD_UPDATEPSDEOPPRIVNAME, (Object)pSACHandlerBase.getUpdatePSDEOPPrivName());
        }
        if (pSACHandlerBase.isUpdateTimeoutDirty() && (bl || pSACHandlerBase.getUpdateTimeout() != null)) {
            iDataObject.set(FIELD_UPDATETIMEOUT, (Object)pSACHandlerBase.getUpdateTimeout());
        }
        if (pSACHandlerBase.isUser2PSDEActionIdDirty() && (bl || pSACHandlerBase.getUser2PSDEActionId() != null)) {
            iDataObject.set(FIELD_USER2PSDEACTIONID, (Object)pSACHandlerBase.getUser2PSDEActionId());
        }
        if (pSACHandlerBase.isUser2PSDEActionNameDirty() && (bl || pSACHandlerBase.getUser2PSDEActionName() != null)) {
            iDataObject.set(FIELD_USER2PSDEACTIONNAME, (Object)pSACHandlerBase.getUser2PSDEActionName());
        }
        if (pSACHandlerBase.isUser2PSDEOPPrivIdDirty() && (bl || pSACHandlerBase.getUser2PSDEOPPrivId() != null)) {
            iDataObject.set(FIELD_USER2PSDEOPPRIVID, (Object)pSACHandlerBase.getUser2PSDEOPPrivId());
        }
        if (pSACHandlerBase.isUser2PSDEOPPrivNameDirty() && (bl || pSACHandlerBase.getUser2PSDEOPPrivName() != null)) {
            iDataObject.set(FIELD_USER2PSDEOPPRIVNAME, (Object)pSACHandlerBase.getUser2PSDEOPPrivName());
        }
        if (pSACHandlerBase.isUserCatDirty() && (bl || pSACHandlerBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSACHandlerBase.getUserCat());
        }
        if (pSACHandlerBase.isUserParamsDirty() && (bl || pSACHandlerBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSACHandlerBase.getUserParams());
        }
        if (pSACHandlerBase.isUserPSDEActionIdDirty() && (bl || pSACHandlerBase.getUserPSDEActionId() != null)) {
            iDataObject.set(FIELD_USERPSDEACTIONID, (Object)pSACHandlerBase.getUserPSDEActionId());
        }
        if (pSACHandlerBase.isUserPSDEActionNameDirty() && (bl || pSACHandlerBase.getUserPSDEActionName() != null)) {
            iDataObject.set(FIELD_USERPSDEACTIONNAME, (Object)pSACHandlerBase.getUserPSDEActionName());
        }
        if (pSACHandlerBase.isUserPSDEOPPrivIdDirty() && (bl || pSACHandlerBase.getUserPSDEOPPrivId() != null)) {
            iDataObject.set(FIELD_USERPSDEOPPRIVID, (Object)pSACHandlerBase.getUserPSDEOPPrivId());
        }
        if (pSACHandlerBase.isUserPSDEOPPrivNameDirty() && (bl || pSACHandlerBase.getUserPSDEOPPrivName() != null)) {
            iDataObject.set(FIELD_USERPSDEOPPRIVNAME, (Object)pSACHandlerBase.getUserPSDEOPPrivName());
        }
        if (pSACHandlerBase.isUserTagDirty() && (bl || pSACHandlerBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSACHandlerBase.getUserTag());
        }
        if (pSACHandlerBase.isUserTag2Dirty() && (bl || pSACHandlerBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSACHandlerBase.getUserTag2());
        }
        if (pSACHandlerBase.isUserTag3Dirty() && (bl || pSACHandlerBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSACHandlerBase.getUserTag3());
        }
        if (pSACHandlerBase.isUserTag4Dirty() && (bl || pSACHandlerBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSACHandlerBase.getUserTag4());
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
        return PSACHandlerBase.remove(this, n);
    }

    private static boolean remove(PSACHandlerBase pSACHandlerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSACHandlerBase.resetCacheScope();
                return true;
            }
            case 1: {
                pSACHandlerBase.resetCacheTimeout();
                return true;
            }
            case 2: {
                pSACHandlerBase.resetCodeName();
                return true;
            }
            case 3: {
                pSACHandlerBase.resetCopyPSDEActionId();
                return true;
            }
            case 4: {
                pSACHandlerBase.resetCopyPSDEActionName();
                return true;
            }
            case 5: {
                pSACHandlerBase.resetCreateDate();
                return true;
            }
            case 6: {
                pSACHandlerBase.resetCreateMan();
                return true;
            }
            case 7: {
                pSACHandlerBase.resetCreatePSDEActionId();
                return true;
            }
            case 8: {
                pSACHandlerBase.resetCreatePSDEActionName();
                return true;
            }
            case 9: {
                pSACHandlerBase.resetCreatePSDEOPPrivId();
                return true;
            }
            case 10: {
                pSACHandlerBase.resetCreatePSDEOPPrivIName();
                return true;
            }
            case 11: {
                pSACHandlerBase.resetCreateTimeout();
                return true;
            }
            case 12: {
                pSACHandlerBase.resetCtrlType();
                return true;
            }
            case 13: {
                pSACHandlerBase.resetCustomCond();
                return true;
            }
            case 14: {
                pSACHandlerBase.resetCustomType();
                return true;
            }
            case 15: {
                pSACHandlerBase.resetDynaModelFlag();
                return true;
            }
            case 16: {
                pSACHandlerBase.resetEnableCache();
                return true;
            }
            case 17: {
                pSACHandlerBase.resetEnableOrgDR();
                return true;
            }
            case 18: {
                pSACHandlerBase.resetEnableSecBC();
                return true;
            }
            case 19: {
                pSACHandlerBase.resetEnableSecDR();
                return true;
            }
            case 20: {
                pSACHandlerBase.resetEnableUserDR();
                return true;
            }
            case 21: {
                pSACHandlerBase.resetExportPSDEOPPrivId();
                return true;
            }
            case 22: {
                pSACHandlerBase.resetExportPSDEOPPrivName();
                return true;
            }
            case 23: {
                pSACHandlerBase.resetFetchTimeout();
                return true;
            }
            case 24: {
                pSACHandlerBase.resetFinishFlag();
                return true;
            }
            case 25: {
                pSACHandlerBase.resetGetDraftPSDEActionId();
                return true;
            }
            case 26: {
                pSACHandlerBase.resetGetDraftPSDEActionName();
                return true;
            }
            case 27: {
                pSACHandlerBase.resetGetPSDEActionId();
                return true;
            }
            case 28: {
                pSACHandlerBase.resetGetPSDEActionName();
                return true;
            }
            case 29: {
                pSACHandlerBase.resetGetTimeout();
                return true;
            }
            case 30: {
                pSACHandlerBase.resetGroupMovePSDEActionId();
                return true;
            }
            case 31: {
                pSACHandlerBase.resetGroupMovePSDEActionName();
                return true;
            }
            case 32: {
                pSACHandlerBase.resetGroupPSDEId();
                return true;
            }
            case 33: {
                pSACHandlerBase.resetGroupPSDEName();
                return true;
            }
            case 34: {
                pSACHandlerBase.resetHandlerObj();
                return true;
            }
            case 35: {
                pSACHandlerBase.resetHandlerObj2();
                return true;
            }
            case 36: {
                pSACHandlerBase.resetHandlerParams();
                return true;
            }
            case 37: {
                pSACHandlerBase.resetHandlerTag();
                return true;
            }
            case 38: {
                pSACHandlerBase.resetHandlerTag2();
                return true;
            }
            case 39: {
                pSACHandlerBase.resetLockFlag();
                return true;
            }
            case 40: {
                pSACHandlerBase.resetMemo();
                return true;
            }
            case 41: {
                pSACHandlerBase.resetMovePSDEActionId();
                return true;
            }
            case 42: {
                pSACHandlerBase.resetMovePSDEActionName();
                return true;
            }
            case 43: {
                pSACHandlerBase.resetOrgDR();
                return true;
            }
            case 44: {
                pSACHandlerBase.resetPSACHandlerId();
                return true;
            }
            case 45: {
                pSACHandlerBase.resetPSACHandlerName();
                return true;
            }
            case 46: {
                pSACHandlerBase.resetPSDEDataSetId();
                return true;
            }
            case 47: {
                pSACHandlerBase.resetPSDEDataSetName();
                return true;
            }
            case 48: {
                pSACHandlerBase.resetPSDEId();
                return true;
            }
            case 49: {
                pSACHandlerBase.resetPSDEName();
                return true;
            }
            case 50: {
                pSACHandlerBase.resetPSDynaInstId();
                return true;
            }
            case 51: {
                pSACHandlerBase.resetPSModuleId();
                return true;
            }
            case 52: {
                pSACHandlerBase.resetPSModuleName();
                return true;
            }
            case 53: {
                pSACHandlerBase.resetPSSFACHandlerId();
                return true;
            }
            case 54: {
                pSACHandlerBase.resetPSSFACHandlerName();
                return true;
            }
            case 55: {
                pSACHandlerBase.resetPSSFId();
                return true;
            }
            case 56: {
                pSACHandlerBase.resetPSSFName();
                return true;
            }
            case 57: {
                pSACHandlerBase.resetPSSysDynaModelId();
                return true;
            }
            case 58: {
                pSACHandlerBase.resetPSSysDynaModelName();
                return true;
            }
            case 59: {
                pSACHandlerBase.resetPSSysReqItemId();
                return true;
            }
            case 60: {
                pSACHandlerBase.resetPSSysReqItemName();
                return true;
            }
            case 61: {
                pSACHandlerBase.resetPSSysTaskId();
                return true;
            }
            case 62: {
                pSACHandlerBase.resetPSSysTaskName();
                return true;
            }
            case 63: {
                pSACHandlerBase.resetPSSystemId();
                return true;
            }
            case 64: {
                pSACHandlerBase.resetPSSystemName();
                return true;
            }
            case 65: {
                pSACHandlerBase.resetPSSysUniStateId();
                return true;
            }
            case 66: {
                pSACHandlerBase.resetPSSysUniStateName();
                return true;
            }
            case 67: {
                pSACHandlerBase.resetPSSysUserDRId();
                return true;
            }
            case 68: {
                pSACHandlerBase.resetPSSysUserDRId2();
                return true;
            }
            case 69: {
                pSACHandlerBase.resetPSSysUserDRName();
                return true;
            }
            case 70: {
                pSACHandlerBase.resetPSSysUserDRName2();
                return true;
            }
            case 71: {
                pSACHandlerBase.resetReadPSDEOPPrivId();
                return true;
            }
            case 72: {
                pSACHandlerBase.resetReadPSDEOPPrivName();
                return true;
            }
            case 73: {
                pSACHandlerBase.resetRemovePSDEActionId();
                return true;
            }
            case 74: {
                pSACHandlerBase.resetRemovePSDEActionName();
                return true;
            }
            case 75: {
                pSACHandlerBase.resetRemovePSDEOPPrivId();
                return true;
            }
            case 76: {
                pSACHandlerBase.resetRemovePSDEOPPrivName();
                return true;
            }
            case 77: {
                pSACHandlerBase.resetRemoveTimeout();
                return true;
            }
            case 78: {
                pSACHandlerBase.resetSecBC();
                return true;
            }
            case 79: {
                pSACHandlerBase.resetSecDR();
                return true;
            }
            case 80: {
                pSACHandlerBase.resetSysUserDR2Param();
                return true;
            }
            case 81: {
                pSACHandlerBase.resetSysUserDRParam();
                return true;
            }
            case 82: {
                pSACHandlerBase.resetTempMode();
                return true;
            }
            case 83: {
                pSACHandlerBase.resetToDoTask();
                return true;
            }
            case 84: {
                pSACHandlerBase.resetUniStateField();
                return true;
            }
            case 85: {
                pSACHandlerBase.resetUniStateKeyValue();
                return true;
            }
            case 86: {
                pSACHandlerBase.resetUpdateDate();
                return true;
            }
            case 87: {
                pSACHandlerBase.resetUpdateMan();
                return true;
            }
            case 88: {
                pSACHandlerBase.resetUpdatePSDEActionId();
                return true;
            }
            case 89: {
                pSACHandlerBase.resetUpdatePSDEActionName();
                return true;
            }
            case 90: {
                pSACHandlerBase.resetUpdatePSDEOPPrivId();
                return true;
            }
            case 91: {
                pSACHandlerBase.resetUpdatePSDEOPPrivName();
                return true;
            }
            case 92: {
                pSACHandlerBase.resetUpdateTimeout();
                return true;
            }
            case 93: {
                pSACHandlerBase.resetUser2PSDEActionId();
                return true;
            }
            case 94: {
                pSACHandlerBase.resetUser2PSDEActionName();
                return true;
            }
            case 95: {
                pSACHandlerBase.resetUser2PSDEOPPrivId();
                return true;
            }
            case 96: {
                pSACHandlerBase.resetUser2PSDEOPPrivName();
                return true;
            }
            case 97: {
                pSACHandlerBase.resetUserCat();
                return true;
            }
            case 98: {
                pSACHandlerBase.resetUserParams();
                return true;
            }
            case 99: {
                pSACHandlerBase.resetUserPSDEActionId();
                return true;
            }
            case 100: {
                pSACHandlerBase.resetUserPSDEActionName();
                return true;
            }
            case 101: {
                pSACHandlerBase.resetUserPSDEOPPrivId();
                return true;
            }
            case 102: {
                pSACHandlerBase.resetUserPSDEOPPrivName();
                return true;
            }
            case 103: {
                pSACHandlerBase.resetUserTag();
                return true;
            }
            case 104: {
                pSACHandlerBase.resetUserTag2();
                return true;
            }
            case 105: {
                pSACHandlerBase.resetUserTag3();
                return true;
            }
            case 106: {
                pSACHandlerBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getGroupPSDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupPSDE();
        }
        if (this.getGroupPSDEId() == null) {
            return null;
        }
        Integer n = this.objGroupPSDELock;
        synchronized (n) {
            if (this.grouppsde != null && DataTypeHelper.compare((int)25, (Object)this.getGroupPSDEId(), (Object)this.grouppsde.getPSDataEntityId()) != 0L) {
                this.grouppsde = null;
            }
            if (this.grouppsde == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getGroupPSDEId());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
                this.grouppsde = pSDataEntity;
            }
            return this.grouppsde;
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
    public PSDEAction getGroupMovePSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupMovePSDEAction();
        }
        if (this.getGroupMovePSDEActionId() == null) {
            return null;
        }
        Integer n = this.objGroupMovePSDEActionLock;
        synchronized (n) {
            if (this.groupmovepsdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getGroupMovePSDEActionId(), (Object)this.groupmovepsdeaction.getPSDEActionId()) != 0L) {
                this.groupmovepsdeaction = null;
            }
            if (this.groupmovepsdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getGroupMovePSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet((IEntity)pSDEAction);
                this.groupmovepsdeaction = pSDEAction;
            }
            return this.groupmovepsdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEAction getMovePSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMovePSDEAction();
        }
        if (this.getMovePSDEActionId() == null) {
            return null;
        }
        Integer n = this.objMovePSDEActionLock;
        synchronized (n) {
            if (this.movepsdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getMovePSDEActionId(), (Object)this.movepsdeaction.getPSDEActionId()) != 0L) {
                this.movepsdeaction = null;
            }
            if (this.movepsdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getMovePSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet((IEntity)pSDEAction);
                this.movepsdeaction = pSDEAction;
            }
            return this.movepsdeaction;
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
                pSDEDataSetService.autoGet((IEntity)pSDEDataSet);
                this.psdedataset = pSDEDataSet;
            }
            return this.psdedataset;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEOPPriv getCreatePSDEOPPriv() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreatePSDEOPPriv();
        }
        if (this.getCreatePSDEOPPrivId() == null) {
            return null;
        }
        Integer n = this.objCreatePSDEOPPrivLock;
        synchronized (n) {
            if (this.createpsdeoppriv != null && DataTypeHelper.compare((int)25, (Object)this.getCreatePSDEOPPrivId(), (Object)this.createpsdeoppriv.getPSDEOPPrivId()) != 0L) {
                this.createpsdeoppriv = null;
            }
            if (this.createpsdeoppriv == null) {
                PSDEOPPriv pSDEOPPriv = new PSDEOPPriv();
                pSDEOPPriv.setPSDEOPPrivId(this.getCreatePSDEOPPrivId());
                PSDEOPPrivService pSDEOPPrivService = (PSDEOPPrivService)ServiceGlobal.getService(PSDEOPPrivService.class, (SessionFactory)this.getSessionFactory());
                pSDEOPPrivService.autoGet((IEntity)pSDEOPPriv);
                this.createpsdeoppriv = pSDEOPPriv;
            }
            return this.createpsdeoppriv;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEOPPriv getExportPSDEOPPriv() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExportPSDEOPPriv();
        }
        if (this.getExportPSDEOPPrivId() == null) {
            return null;
        }
        Integer n = this.objExportPSDEOPPrivLock;
        synchronized (n) {
            if (this.exportpsdeoppriv != null && DataTypeHelper.compare((int)25, (Object)this.getExportPSDEOPPrivId(), (Object)this.exportpsdeoppriv.getPSDEOPPrivId()) != 0L) {
                this.exportpsdeoppriv = null;
            }
            if (this.exportpsdeoppriv == null) {
                PSDEOPPriv pSDEOPPriv = new PSDEOPPriv();
                pSDEOPPriv.setPSDEOPPrivId(this.getExportPSDEOPPrivId());
                PSDEOPPrivService pSDEOPPrivService = (PSDEOPPrivService)ServiceGlobal.getService(PSDEOPPrivService.class, (SessionFactory)this.getSessionFactory());
                pSDEOPPrivService.autoGet((IEntity)pSDEOPPriv);
                this.exportpsdeoppriv = pSDEOPPriv;
            }
            return this.exportpsdeoppriv;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEOPPriv getReadPSDEOPPriv() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReadPSDEOPPriv();
        }
        if (this.getReadPSDEOPPrivId() == null) {
            return null;
        }
        Integer n = this.objReadPSDEOPPrivLock;
        synchronized (n) {
            if (this.readpsdeoppriv != null && DataTypeHelper.compare((int)25, (Object)this.getReadPSDEOPPrivId(), (Object)this.readpsdeoppriv.getPSDEOPPrivId()) != 0L) {
                this.readpsdeoppriv = null;
            }
            if (this.readpsdeoppriv == null) {
                PSDEOPPriv pSDEOPPriv = new PSDEOPPriv();
                pSDEOPPriv.setPSDEOPPrivId(this.getReadPSDEOPPrivId());
                PSDEOPPrivService pSDEOPPrivService = (PSDEOPPrivService)ServiceGlobal.getService(PSDEOPPrivService.class, (SessionFactory)this.getSessionFactory());
                pSDEOPPrivService.autoGet((IEntity)pSDEOPPriv);
                this.readpsdeoppriv = pSDEOPPriv;
            }
            return this.readpsdeoppriv;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEOPPriv getRemovePSDEOPPriv() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRemovePSDEOPPriv();
        }
        if (this.getRemovePSDEOPPrivId() == null) {
            return null;
        }
        Integer n = this.objRemovePSDEOPPrivLock;
        synchronized (n) {
            if (this.removepsdeoppriv != null && DataTypeHelper.compare((int)25, (Object)this.getRemovePSDEOPPrivId(), (Object)this.removepsdeoppriv.getPSDEOPPrivId()) != 0L) {
                this.removepsdeoppriv = null;
            }
            if (this.removepsdeoppriv == null) {
                PSDEOPPriv pSDEOPPriv = new PSDEOPPriv();
                pSDEOPPriv.setPSDEOPPrivId(this.getRemovePSDEOPPrivId());
                PSDEOPPrivService pSDEOPPrivService = (PSDEOPPrivService)ServiceGlobal.getService(PSDEOPPrivService.class, (SessionFactory)this.getSessionFactory());
                pSDEOPPrivService.autoGet((IEntity)pSDEOPPriv);
                this.removepsdeoppriv = pSDEOPPriv;
            }
            return this.removepsdeoppriv;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEOPPriv getUpdatePSDEOPPriv() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdatePSDEOPPriv();
        }
        if (this.getUpdatePSDEOPPrivId() == null) {
            return null;
        }
        Integer n = this.objUpdatePSDEOPPrivLock;
        synchronized (n) {
            if (this.updatepsdeoppriv != null && DataTypeHelper.compare((int)25, (Object)this.getUpdatePSDEOPPrivId(), (Object)this.updatepsdeoppriv.getPSDEOPPrivId()) != 0L) {
                this.updatepsdeoppriv = null;
            }
            if (this.updatepsdeoppriv == null) {
                PSDEOPPriv pSDEOPPriv = new PSDEOPPriv();
                pSDEOPPriv.setPSDEOPPrivId(this.getUpdatePSDEOPPrivId());
                PSDEOPPrivService pSDEOPPrivService = (PSDEOPPrivService)ServiceGlobal.getService(PSDEOPPrivService.class, (SessionFactory)this.getSessionFactory());
                pSDEOPPrivService.autoGet((IEntity)pSDEOPPriv);
                this.updatepsdeoppriv = pSDEOPPriv;
            }
            return this.updatepsdeoppriv;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEOPPriv getUser2PSDEOPPriv() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUser2PSDEOPPriv();
        }
        if (this.getUser2PSDEOPPrivId() == null) {
            return null;
        }
        Integer n = this.objUser2PSDEOPPrivLock;
        synchronized (n) {
            if (this.user2psdeoppriv != null && DataTypeHelper.compare((int)25, (Object)this.getUser2PSDEOPPrivId(), (Object)this.user2psdeoppriv.getPSDEOPPrivId()) != 0L) {
                this.user2psdeoppriv = null;
            }
            if (this.user2psdeoppriv == null) {
                PSDEOPPriv pSDEOPPriv = new PSDEOPPriv();
                pSDEOPPriv.setPSDEOPPrivId(this.getUser2PSDEOPPrivId());
                PSDEOPPrivService pSDEOPPrivService = (PSDEOPPrivService)ServiceGlobal.getService(PSDEOPPrivService.class, (SessionFactory)this.getSessionFactory());
                pSDEOPPrivService.autoGet((IEntity)pSDEOPPriv);
                this.user2psdeoppriv = pSDEOPPriv;
            }
            return this.user2psdeoppriv;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEOPPriv getUserPSDEOPPriv() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserPSDEOPPriv();
        }
        if (this.getUserPSDEOPPrivId() == null) {
            return null;
        }
        Integer n = this.objUserPSDEOPPrivLock;
        synchronized (n) {
            if (this.userpsdeoppriv != null && DataTypeHelper.compare((int)25, (Object)this.getUserPSDEOPPrivId(), (Object)this.userpsdeoppriv.getPSDEOPPrivId()) != 0L) {
                this.userpsdeoppriv = null;
            }
            if (this.userpsdeoppriv == null) {
                PSDEOPPriv pSDEOPPriv = new PSDEOPPriv();
                pSDEOPPriv.setPSDEOPPrivId(this.getUserPSDEOPPrivId());
                PSDEOPPrivService pSDEOPPrivService = (PSDEOPPrivService)ServiceGlobal.getService(PSDEOPPrivService.class, (SessionFactory)this.getSessionFactory());
                pSDEOPPrivService.autoGet((IEntity)pSDEOPPriv);
                this.userpsdeoppriv = pSDEOPPriv;
            }
            return this.userpsdeoppriv;
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
    public PSSFACHandler getPSSFACHandler() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFACHandler();
        }
        if (this.getPSSFACHandlerId() == null) {
            return null;
        }
        Integer n = this.objPSSFACHandlerLock;
        synchronized (n) {
            if (this.pssfachandler != null && DataTypeHelper.compare((int)25, (Object)this.getPSSFACHandlerId(), (Object)this.pssfachandler.getPSSFACHandlerId()) != 0L) {
                this.pssfachandler = null;
            }
            if (this.pssfachandler == null) {
                PSSFACHandler pSSFACHandler = new PSSFACHandler();
                pSSFACHandler.setPSSFACHandlerId(this.getPSSFACHandlerId());
                PSSFACHandlerService pSSFACHandlerService = (PSSFACHandlerService)ServiceGlobal.getService(PSSFACHandlerService.class, (SessionFactory)this.getSessionFactory());
                pSSFACHandlerService.autoGet((IEntity)pSSFACHandler);
                this.pssfachandler = pSSFACHandler;
            }
            return this.pssfachandler;
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
    public PSSysTask getPSSysTask() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTask();
        }
        if (this.getPSSysTaskId() == null) {
            return null;
        }
        Integer n = this.objPSSysTaskLock;
        synchronized (n) {
            if (this.pssystask != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysTaskId(), (Object)this.pssystask.getPSSysTaskId()) != 0L) {
                this.pssystask = null;
            }
            if (this.pssystask == null) {
                PSSysTask pSSysTask = new PSSysTask();
                pSSysTask.setPSSysTaskId(this.getPSSysTaskId());
                PSSysTaskService pSSysTaskService = (PSSysTaskService)ServiceGlobal.getService(PSSysTaskService.class, (SessionFactory)this.getSessionFactory());
                pSSysTaskService.autoGet((IEntity)pSSysTask);
                this.pssystask = pSSysTask;
            }
            return this.pssystask;
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
    public PSSysUniState getPSSysUniState() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUniState();
        }
        if (this.getPSSysUniStateId() == null) {
            return null;
        }
        Integer n = this.objPSSysUniStateLock;
        synchronized (n) {
            if (this.pssysunistate != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysUniStateId(), (Object)this.pssysunistate.getPSSysUniStateId()) != 0L) {
                this.pssysunistate = null;
            }
            if (this.pssysunistate == null) {
                PSSysUniState pSSysUniState = new PSSysUniState();
                pSSysUniState.setPSSysUniStateId(this.getPSSysUniStateId());
                PSSysUniStateService pSSysUniStateService = (PSSysUniStateService)ServiceGlobal.getService(PSSysUniStateService.class, (SessionFactory)this.getSessionFactory());
                pSSysUniStateService.autoGet((IEntity)pSSysUniState);
                this.pssysunistate = pSSysUniState;
            }
            return this.pssysunistate;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysUserDR getPSSysUserDR() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUserDR();
        }
        if (this.getPSSysUserDRId() == null) {
            return null;
        }
        Integer n = this.objPSSysUserDRLock;
        synchronized (n) {
            if (this.pssysuserdr != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysUserDRId(), (Object)this.pssysuserdr.getPSSysUserDRId()) != 0L) {
                this.pssysuserdr = null;
            }
            if (this.pssysuserdr == null) {
                PSSysUserDR pSSysUserDR = new PSSysUserDR();
                pSSysUserDR.setPSSysUserDRId(this.getPSSysUserDRId());
                PSSysUserDRService pSSysUserDRService = (PSSysUserDRService)ServiceGlobal.getService(PSSysUserDRService.class, (SessionFactory)this.getSessionFactory());
                pSSysUserDRService.autoGet((IEntity)pSSysUserDR);
                this.pssysuserdr = pSSysUserDR;
            }
            return this.pssysuserdr;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysUserDR getPSSysUserDR2() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUserDR2();
        }
        if (this.getPSSysUserDRId2() == null) {
            return null;
        }
        Integer n = this.objPSSysUserDR2Lock;
        synchronized (n) {
            if (this.pssysuserdr2 != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysUserDRId2(), (Object)this.pssysuserdr2.getPSSysUserDRId()) != 0L) {
                this.pssysuserdr2 = null;
            }
            if (this.pssysuserdr2 == null) {
                PSSysUserDR pSSysUserDR = new PSSysUserDR();
                pSSysUserDR.setPSSysUserDRId(this.getPSSysUserDRId2());
                PSSysUserDRService pSSysUserDRService = (PSSysUserDRService)ServiceGlobal.getService(PSSysUserDRService.class, (SessionFactory)this.getSessionFactory());
                pSSysUserDRService.autoGet((IEntity)pSSysUserDR);
                this.pssysuserdr2 = pSSysUserDR;
            }
            return this.pssysuserdr2;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSACHandlerAction> getPSACHandlerActions() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSACHandlerActions();
        }
        if (this.getPSACHandlerId() == null) {
            return null;
        }
        PSACHandlerActionService pSACHandlerActionService = (PSACHandlerActionService)ServiceGlobal.getService(PSACHandlerActionService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSACHandlerActionsLock;
        synchronized (n) {
            if (this.psachandleractions == null) {
                this.psachandleractions = pSACHandlerActionService.selectByPSACHandler(this);
            }
            return this.psachandleractions;
        }
    }

    private PSACHandlerBase getProxyEntity() {
        return this.proxyPSACHandlerBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSACHandlerBase = null;
        if (iDataObject != null && iDataObject instanceof PSACHandlerBase) {
            this.proxyPSACHandlerBase = (PSACHandlerBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CACHESCOPE, 0);
        fieldIndexMap.put(FIELD_CACHETIMEOUT, 1);
        fieldIndexMap.put(FIELD_CODENAME, 2);
        fieldIndexMap.put(FIELD_COPYPSDEACTIONID, 3);
        fieldIndexMap.put(FIELD_COPYPSDEACTIONNAME, 4);
        fieldIndexMap.put(FIELD_CREATEDATE, 5);
        fieldIndexMap.put(FIELD_CREATEMAN, 6);
        fieldIndexMap.put(FIELD_CREATEPSDEACTIONID, 7);
        fieldIndexMap.put(FIELD_CREATEPSDEACTIONNAME, 8);
        fieldIndexMap.put(FIELD_CREATEPSDEOPPRIVID, 9);
        fieldIndexMap.put(FIELD_CREATEPSDEOPPRIVINAME, 10);
        fieldIndexMap.put(FIELD_CREATETIMEOUT, 11);
        fieldIndexMap.put(FIELD_CTRLTYPE, 12);
        fieldIndexMap.put(FIELD_CUSTOMCOND, 13);
        fieldIndexMap.put(FIELD_CUSTOMTYPE, 14);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 15);
        fieldIndexMap.put(FIELD_ENABLECACHE, 16);
        fieldIndexMap.put(FIELD_ENABLEORGDR, 17);
        fieldIndexMap.put(FIELD_ENABLESECBC, 18);
        fieldIndexMap.put(FIELD_ENABLESECDR, 19);
        fieldIndexMap.put(FIELD_ENABLEUSERDR, 20);
        fieldIndexMap.put(FIELD_EXPORTPSDEOPPRIVID, 21);
        fieldIndexMap.put(FIELD_EXPORTPSDEOPPRIVNAME, 22);
        fieldIndexMap.put(FIELD_FETCHTIMEOUT, 23);
        fieldIndexMap.put(FIELD_FINISHFLAG, 24);
        fieldIndexMap.put(FIELD_GETDRAFTPSDEACTIONID, 25);
        fieldIndexMap.put(FIELD_GETDRAFTPSDEACTIONNAME, 26);
        fieldIndexMap.put(FIELD_GETPSDEACTIONID, 27);
        fieldIndexMap.put(FIELD_GETPSDEACTIONNAME, 28);
        fieldIndexMap.put(FIELD_GETTIMEOUT, 29);
        fieldIndexMap.put(FIELD_GROUPMOVEPSDEACTIONID, 30);
        fieldIndexMap.put(FIELD_GROUPMOVEPSDEACTIONNAME, 31);
        fieldIndexMap.put(FIELD_GROUPPSDEID, 32);
        fieldIndexMap.put(FIELD_GROUPPSDENAME, 33);
        fieldIndexMap.put(FIELD_HANDLEROBJ, 34);
        fieldIndexMap.put(FIELD_HANDLEROBJ2, 35);
        fieldIndexMap.put(FIELD_HANDLERPARAMS, 36);
        fieldIndexMap.put(FIELD_HANDLERTAG, 37);
        fieldIndexMap.put(FIELD_HANDLERTAG2, 38);
        fieldIndexMap.put(FIELD_LOCKFLAG, 39);
        fieldIndexMap.put(FIELD_MEMO, 40);
        fieldIndexMap.put(FIELD_MOVEPSDEACTIONID, 41);
        fieldIndexMap.put(FIELD_MOVEPSDEACTIONNAME, 42);
        fieldIndexMap.put(FIELD_ORGDR, 43);
        fieldIndexMap.put(FIELD_PSACHANDLERID, 44);
        fieldIndexMap.put(FIELD_PSACHANDLERNAME, 45);
        fieldIndexMap.put(FIELD_PSDEDATASETID, 46);
        fieldIndexMap.put(FIELD_PSDEDATASETNAME, 47);
        fieldIndexMap.put(FIELD_PSDEID, 48);
        fieldIndexMap.put(FIELD_PSDENAME, 49);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 50);
        fieldIndexMap.put(FIELD_PSMODULEID, 51);
        fieldIndexMap.put(FIELD_PSMODULENAME, 52);
        fieldIndexMap.put(FIELD_PSSFACHANDLERID, 53);
        fieldIndexMap.put(FIELD_PSSFACHANDLERNAME, 54);
        fieldIndexMap.put(FIELD_PSSFID, 55);
        fieldIndexMap.put(FIELD_PSSFNAME, 56);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 57);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 58);
        fieldIndexMap.put(FIELD_PSSYSREQITEMID, 59);
        fieldIndexMap.put(FIELD_PSSYSREQITEMNAME, 60);
        fieldIndexMap.put(FIELD_PSSYSTASKID, 61);
        fieldIndexMap.put(FIELD_PSSYSTASKNAME, 62);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 63);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 64);
        fieldIndexMap.put(FIELD_PSSYSUNISTATEID, 65);
        fieldIndexMap.put(FIELD_PSSYSUNISTATENAME, 66);
        fieldIndexMap.put(FIELD_PSSYSUSERDRID, 67);
        fieldIndexMap.put(FIELD_PSSYSUSERDRID2, 68);
        fieldIndexMap.put(FIELD_PSSYSUSERDRNAME, 69);
        fieldIndexMap.put(FIELD_PSSYSUSERDRNAME2, 70);
        fieldIndexMap.put(FIELD_READPSDEOPPRIVID, 71);
        fieldIndexMap.put(FIELD_READPSDEOPPRIVNAME, 72);
        fieldIndexMap.put(FIELD_REMOVEPSDEACTIONID, 73);
        fieldIndexMap.put(FIELD_REMOVEPSDEACTIONNAME, 74);
        fieldIndexMap.put(FIELD_REMOVEPSDEOPPRIVID, 75);
        fieldIndexMap.put(FIELD_REMOVEPSDEOPPRIVNAME, 76);
        fieldIndexMap.put(FIELD_REMOVETIMEOUT, 77);
        fieldIndexMap.put(FIELD_SECBC, 78);
        fieldIndexMap.put(FIELD_SECDR, 79);
        fieldIndexMap.put(FIELD_SYSUSERDR2PARAM, 80);
        fieldIndexMap.put(FIELD_SYSUSERDRPARAM, 81);
        fieldIndexMap.put(FIELD_TEMPMODE, 82);
        fieldIndexMap.put(FIELD_TODOTASK, 83);
        fieldIndexMap.put(FIELD_UNISTATEFIELD, 84);
        fieldIndexMap.put(FIELD_UNISTATEKEYVALUE, 85);
        fieldIndexMap.put(FIELD_UPDATEDATE, 86);
        fieldIndexMap.put(FIELD_UPDATEMAN, 87);
        fieldIndexMap.put(FIELD_UPDATEPSDEACTIONID, 88);
        fieldIndexMap.put(FIELD_UPDATEPSDEACTIONNAME, 89);
        fieldIndexMap.put(FIELD_UPDATEPSDEOPPRIVID, 90);
        fieldIndexMap.put(FIELD_UPDATEPSDEOPPRIVNAME, 91);
        fieldIndexMap.put(FIELD_UPDATETIMEOUT, 92);
        fieldIndexMap.put(FIELD_USER2PSDEACTIONID, 93);
        fieldIndexMap.put(FIELD_USER2PSDEACTIONNAME, 94);
        fieldIndexMap.put(FIELD_USER2PSDEOPPRIVID, 95);
        fieldIndexMap.put(FIELD_USER2PSDEOPPRIVNAME, 96);
        fieldIndexMap.put(FIELD_USERCAT, 97);
        fieldIndexMap.put(FIELD_USERPARAMS, 98);
        fieldIndexMap.put(FIELD_USERPSDEACTIONID, 99);
        fieldIndexMap.put(FIELD_USERPSDEACTIONNAME, 100);
        fieldIndexMap.put(FIELD_USERPSDEOPPRIVID, 101);
        fieldIndexMap.put(FIELD_USERPSDEOPPRIVNAME, 102);
        fieldIndexMap.put(FIELD_USERTAG, 103);
        fieldIndexMap.put(FIELD_USERTAG2, 104);
        fieldIndexMap.put(FIELD_USERTAG3, 105);
        fieldIndexMap.put(FIELD_USERTAG4, 106);
    }
}

