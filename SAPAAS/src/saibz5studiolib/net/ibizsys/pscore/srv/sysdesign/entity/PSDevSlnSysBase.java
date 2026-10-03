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
import net.ibizsys.pscore.srv.config.entity.PSPF;
import net.ibizsys.pscore.srv.config.entity.PSSF;
import net.ibizsys.pscore.srv.config.entity.PSSubSys;
import net.ibizsys.pscore.srv.config.entity.PSSysPolicy;
import net.ibizsys.pscore.srv.config.service.PSPFService;
import net.ibizsys.pscore.srv.config.service.PSSFService;
import net.ibizsys.pscore.srv.config.service.PSSubSysService;
import net.ibizsys.pscore.srv.config.service.PSSysPolicyService;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCBDInst;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCDeployCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCModelTempl;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRegistryItem;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRobot;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCSysLic;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterAS;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInst;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVN;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterTS;
import net.ibizsys.pscore.srv.devcenter.service.PSDCBDInstService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCDeployCenterService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCModelTemplService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCRegistryItemService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCRobotService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCSysLicService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterASService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterTSService;
import net.ibizsys.pscore.srv.dynasys.entity.PSDevSlnSysDynaInst;
import net.ibizsys.pscore.srv.dynasys.service.PSDevSlnSysDynaInstService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDBDevInst;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServer;
import net.ibizsys.pscore.srv.paasmgr.service.PSDBDevInstService;
import net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstService;
import net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysRef;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysSrv;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysWSGit;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysRefService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysSrvService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysWSGitService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysBak;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysDepInst;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysRefLink;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSStudioTheme;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysBakService;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysDepInstService;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysRefLinkService;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSStudioThemeService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnSysBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevSlnSysBase.class);
    public static final String FIELD_ACTIONOWNER = "ACTIONOWNER";
    public static final String FIELD_APIFLAG = "APIFLAG";
    public static final String FIELD_CALLBACKTAG = "CALLBACKTAG";
    public static final String FIELD_CALLBACKURL = "CALLBACKURL";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CURACTION = "CURACTION";
    public static final String FIELD_DB2PSDCDBINSTID = "DB2PSDCDBINSTID";
    public static final String FIELD_DB2PSDCDBINSTNAME = "DB2PSDCDBINSTNAME";
    public static final String FIELD_DBTYPES = "DBTYPES";
    public static final String FIELD_DBVERSION = "DBVERSION";
    public static final String FIELD_DEPLOYSYSID = "DEPLOYSYSID";
    public static final String FIELD_DEPLOYSYSORGID = "DEPLOYSYSORGID";
    public static final String FIELD_DEPLOYSYSORGSECTORID = "DEPLOYSYSORGSECTORID";
    public static final String FIELD_DEPLOYSYSTAG = "DEPLOYSYSTAG";
    public static final String FIELD_DEPLOYSYSTAG2 = "DEPLOYSYSTAG2";
    public static final String FIELD_DEPLOYSYSTYPE = "DEPLOYSYSTYPE";
    public static final String FIELD_DEVRESINFO = "DEVRESINFO";
    public static final String FIELD_DEVRESSTATE = "DEVRESSTATE";
    public static final String FIELD_DEVSYSSTATE = "DEVSYSSTATE";
    public static final String FIELD_DOCGITBRANCH = "DOCGITBRANCH";
    public static final String FIELD_DOCGITPATH = "DOCGITPATH";
    public static final String FIELD_DOCPSDEVCENTERSVNID = "DOCPSDEVCENTERSVNID";
    public static final String FIELD_DOCPSDEVCENTERSVNNAME = "DOCPSDEVCENTERSVNNAME";
    public static final String FIELD_ENABLECALLBACK = "ENABLECALLBACK";
    public static final String FIELD_ENABLEDB2 = "ENABLEDB2";
    public static final String FIELD_ENABLEDEPLOYCENTER = "ENABLEDEPLOYCENTER";
    public static final String FIELD_ENABLEDM = "ENABLEDM";
    public static final String FIELD_ENABLEDYNASYS = "ENABLEDYNASYS";
    public static final String FIELD_ENABLEFOLDERKEY = "ENABLEFOLDERKEY";
    public static final String FIELD_ENABLEHANA = "ENABLEHANA";
    public static final String FIELD_ENABLEHBASE = "ENABLEHBASE";
    public static final String FIELD_ENABLEMYSQL5 = "ENABLEMYSQL5";
    public static final String FIELD_ENABLEORACLE = "ENABLEORACLE";
    public static final String FIELD_ENABLEPGSQL = "ENABLEPGSQL";
    public static final String FIELD_ENABLEPPAS = "ENABLEPPAS";
    public static final String FIELD_ENABLESQLITE = "ENABLESQLITE";
    public static final String FIELD_ENABLESQLSERVER = "ENABLESQLSERVER";
    public static final String FIELD_ENABLEWSSERVER = "ENABLEWSSERVER";
    public static final String FIELD_ENTITYCNT = "ENTITYCNT";
    public static final String FIELD_EXPRIEDTIME = "EXPRIEDTIME";
    public static final String FIELD_GITBRANCH = "GITBRANCH";
    public static final String FIELD_GITPATH = "GITPATH";
    public static final String FIELD_HBASEPSDCBDINSTID = "HBASEPSDCBDINSTID";
    public static final String FIELD_HBASEPSDCBDINSTNAME = "HBASEPSDCBDINSTNAME";
    public static final String FIELD_INITPARAMS = "INITPARAMS";
    public static final String FIELD_JITPSDBDEVINSTID = "JITPSDBDEVINSTID";
    public static final String FIELD_JITPSDBDEVINSTNAME = "JITPSDBDEVINSTNAME";
    public static final String FIELD_JITPSDEVCENTERTSID = "JITPSDEVCENTERTSID";
    public static final String FIELD_JITPSDEVCENTERTSNAME = "JITPSDEVCENTERTSNAME";
    public static final String FIELD_LASTACTIVETIME = "LASTACTIVETIME";
    public static final String FIELD_LOADTIME = "LOADTIME";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_LOWCODEMODE = "LOWCODEMODE";
    public static final String FIELD_MAINPSDEVSLNSYSID = "MAINPSDEVSLNSYSID";
    public static final String FIELD_MAINPSDEVSLNSYSNAME = "MAINPSDEVSLNSYSNAME";
    public static final String FIELD_MAXENTITYCNT = "MAXENTITYCNT";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MODELGITBRANCH = "MODELGITBRANCH";
    public static final String FIELD_MODELGITPATH = "MODELGITPATH";
    public static final String FIELD_MODELINSTVER = "MODELINSTVER";
    public static final String FIELD_MODELPREFIX = "MODELPREFIX";
    public static final String FIELD_MODELPSDEVCENTERSVNID = "MODELPSDEVCENTERSVNID";
    public static final String FIELD_MODELPSDEVCENTERSVNNAME = "MODELPSDEVCENTERSVNNAME";
    public static final String FIELD_MSSQLPSDCDBINSTID = "MSSQLPSDCDBINSTID";
    public static final String FIELD_MSSQLPSDCDBINSTNAME = "MSSQLPSDCDBINSTNAME";
    public static final String FIELD_MYSQLPSDCDBINSTID = "MYSQLPSDCDBINSTID";
    public static final String FIELD_MYSQLPSDCDBINSTNAME = "MYSQLPSDCDBINSTNAME";
    public static final String FIELD_OFFLINETIME = "OFFLINETIME";
    public static final String FIELD_ORAPSDCDBINSTID = "ORAPSDCDBINSTID";
    public static final String FIELD_ORAPSDCDBINSTNAME = "ORAPSDCDBINSTNAME";
    public static final String FIELD_PGSQLPSDCDBINSTID = "PGSQLPSDCDBINSTID";
    public static final String FIELD_PGSQLPSDCDBINSTNAME = "PGSQLPSDCDBINSTNAME";
    public static final String FIELD_PPASPSDCDBINSTID = "PPASPSDCDBINSTID";
    public static final String FIELD_PPASPSDCDBINSTNAME = "PPASPSDCDBINSTNAME";
    public static final String FIELD_PPSDEVSLNSYSID = "PPSDEVSLNSYSID";
    public static final String FIELD_PPSDEVSLNSYSNAME = "PPSDEVSLNSYSNAME";
    public static final String FIELD_PSDCDEPLOYCENTERID = "PSDCDEPLOYCENTERID";
    public static final String FIELD_PSDCDEPLOYCENTERNAME = "PSDCDEPLOYCENTERNAME";
    public static final String FIELD_PSDCMODELTEMPLID = "PSDCMODELTEMPLID";
    public static final String FIELD_PSDCMODELTEMPLNAME = "PSDCMODELTEMPLNAME";
    public static final String FIELD_PSDCROBOTID = "PSDCROBOTID";
    public static final String FIELD_PSDCROBOTNAME = "PSDCROBOTNAME";
    public static final String FIELD_PSDCSYSLICID = "PSDCSYSLICID";
    public static final String FIELD_PSDCSYSLICNAME = "PSDCSYSLICNAME";
    public static final String FIELD_PSDCWORKSPACEID = "PSDCWORKSPACEID";
    public static final String FIELD_PSDEVCENTERASID = "PSDEVCENTERASID";
    public static final String FIELD_PSDEVCENTERASID2 = "PSDEVCENTERASID2";
    public static final String FIELD_PSDEVCENTERAS3ID = "PSDEVCENTERASID3";
    public static final String FIELD_PSDEVCENTERAS4ID = "PSDEVCENTERASID4";
    public static final String FIELD_PSDEVCENTERASNAME = "PSDEVCENTERASNAME";
    public static final String FIELD_PSDEVCENTERASNAME2 = "PSDEVCENTERASNAME2";
    public static final String FIELD_PSDEVCENTERAS3NAME = "PSDEVCENTERASNAME3";
    public static final String FIELD_PSDEVCENTERAS4NAME = "PSDEVCENTERASNAME4";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVCENTERSVNID = "PSDEVCENTERSVNID";
    public static final String FIELD_PSDEVCENTERSVNNAME = "PSDEVCENTERSVNNAME";
    public static final String FIELD_PSDEVCENTERTSID = "PSDEVCENTERTSID";
    public static final String FIELD_PSDEVCENTERTSNAME = "PSDEVCENTERTSNAME";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String FIELD_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String FIELD_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String FIELD_PSDEVSLNSYSRESID = "PSDEVSLNSYSRESID";
    public static final String FIELD_PSDEVSLNSYSRESNAME = "PSDEVSLNSYSRESNAME";
    public static final String FIELD_PSPFID = "PSPFID";
    public static final String FIELD_PSPFNAME = "PSPFNAME";
    public static final String FIELD_PSSFID = "PSSFID";
    public static final String FIELD_PSSFNAME = "PSSFNAME";
    public static final String FIELD_PSSTUDIOTHEMEID = "PSSTUDIOTHEMEID";
    public static final String FIELD_PSSTUDIOTHEMENAME = "PSSTUDIOTHEMENAME";
    public static final String FIELD_PSSYSMODELINSTID = "PSSYSMODELINSTID";
    public static final String FIELD_PSSYSMODELINSTNAME = "PSSYSMODELINSTNAME";
    public static final String FIELD_PSSYSPOLICYID = "PSSYSPOLICYID";
    public static final String FIELD_PSSYSPOLICYNAME = "PSSYSPOLICYNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSTASKSERVERID = "PSTASKSERVERID";
    public static final String FIELD_PSTASKSERVERNAME = "PSTASKSERVERNAME";
    public static final String FIELD_PUBCODE = "PUBCODE";
    public static final String FIELD_RESREADYTIME = "RESREADYTIME";
    public static final String FIELD_ROGITBRANCH = "ROGITBRANCH";
    public static final String FIELD_ROGITPATH = "ROGITPATH";
    public static final String FIELD_ROPSDEVCENTERSVNID = "ROPSDEVCENTERSVNID";
    public static final String FIELD_ROPSDEVCENTERSVNNAME = "ROPSDEVCENTERSVNNAME";
    public static final String FIELD_RTMODELPSDEVCENTERSVNID = "RTMODELPSDEVCENTERSVNID";
    public static final String FIELD_RTMODELPSDEVCENTERSVNNAME = "RTMODELPSDEVCENTERSVNNAME";
    public static final String FIELD_SAASMODE = "SAASMODE";
    public static final String FIELD_SFPSSUBSYSID = "SFPSSUBSYSID";
    public static final String FIELD_SFPSSUBSYSNAME = "SFPSSUBSYSNAME";
    public static final String FIELD_SHAREFLAG = "SHAREFLAG";
    public static final String FIELD_STUDIOTAG = "STUDIOTAG";
    public static final String FIELD_STUDIOTAG2 = "STUDIOTAG2";
    public static final String FIELD_STUDIOVER = "STUDIOVER";
    public static final String FIELD_SYSFOLDER = "SYSFOLDER";
    public static final String FIELD_SYSMDURL = "SYSMDURL";
    public static final String FIELD_SYSROWKEY = "SYSROWKEY";
    public static final String FIELD_SYSTAG = "SYSTAG";
    public static final String FIELD_SYSTAG2 = "SYSTAG2";
    public static final String FIELD_SYSTAG3 = "SYSTAG3";
    public static final String FIELD_SYSTAG4 = "SYSTAG4";
    public static final String FIELD_SYSTYPE = "SYSTYPE";
    public static final String FIELD_SYSVER = "SYSVER";
    public static final String FIELD_TEMPLENGINE = "TEMPLENGINE";
    public static final String FIELD_THEMECSSSTYLE = "THEMECSSSTYLE";
    public static final String FIELD_UNLOADTIME = "UNLOADTIME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_VCTYPE = "VCTYPE";
    private static final int INDEX_ACTIONOWNER = 0;
    private static final int INDEX_APIFLAG = 1;
    private static final int INDEX_CALLBACKTAG = 2;
    private static final int INDEX_CALLBACKURL = 3;
    private static final int INDEX_CODENAME = 4;
    private static final int INDEX_CREATEDATE = 5;
    private static final int INDEX_CREATEMAN = 6;
    private static final int INDEX_CURACTION = 7;
    private static final int INDEX_DB2PSDCDBINSTID = 8;
    private static final int INDEX_DB2PSDCDBINSTNAME = 9;
    private static final int INDEX_DBTYPES = 10;
    private static final int INDEX_DBVERSION = 11;
    private static final int INDEX_DEPLOYSYSID = 12;
    private static final int INDEX_DEPLOYSYSORGID = 13;
    private static final int INDEX_DEPLOYSYSORGSECTORID = 14;
    private static final int INDEX_DEPLOYSYSTAG = 15;
    private static final int INDEX_DEPLOYSYSTAG2 = 16;
    private static final int INDEX_DEPLOYSYSTYPE = 17;
    private static final int INDEX_DEVRESINFO = 18;
    private static final int INDEX_DEVRESSTATE = 19;
    private static final int INDEX_DEVSYSSTATE = 20;
    private static final int INDEX_DOCGITBRANCH = 21;
    private static final int INDEX_DOCGITPATH = 22;
    private static final int INDEX_DOCPSDEVCENTERSVNID = 23;
    private static final int INDEX_DOCPSDEVCENTERSVNNAME = 24;
    private static final int INDEX_ENABLECALLBACK = 25;
    private static final int INDEX_ENABLEDB2 = 26;
    private static final int INDEX_ENABLEDEPLOYCENTER = 27;
    private static final int INDEX_ENABLEDM = 28;
    private static final int INDEX_ENABLEDYNASYS = 29;
    private static final int INDEX_ENABLEFOLDERKEY = 30;
    private static final int INDEX_ENABLEHANA = 31;
    private static final int INDEX_ENABLEHBASE = 32;
    private static final int INDEX_ENABLEMYSQL5 = 33;
    private static final int INDEX_ENABLEORACLE = 34;
    private static final int INDEX_ENABLEPGSQL = 35;
    private static final int INDEX_ENABLEPPAS = 36;
    private static final int INDEX_ENABLESQLITE = 37;
    private static final int INDEX_ENABLESQLSERVER = 38;
    private static final int INDEX_ENABLEWSSERVER = 39;
    private static final int INDEX_ENTITYCNT = 40;
    private static final int INDEX_EXPRIEDTIME = 41;
    private static final int INDEX_GITBRANCH = 42;
    private static final int INDEX_GITPATH = 43;
    private static final int INDEX_HBASEPSDCBDINSTID = 44;
    private static final int INDEX_HBASEPSDCBDINSTNAME = 45;
    private static final int INDEX_INITPARAMS = 46;
    private static final int INDEX_JITPSDBDEVINSTID = 47;
    private static final int INDEX_JITPSDBDEVINSTNAME = 48;
    private static final int INDEX_JITPSDEVCENTERTSID = 49;
    private static final int INDEX_JITPSDEVCENTERTSNAME = 50;
    private static final int INDEX_LASTACTIVETIME = 51;
    private static final int INDEX_LOADTIME = 52;
    private static final int INDEX_LOGICNAME = 53;
    private static final int INDEX_LOWCODEMODE = 54;
    private static final int INDEX_MAINPSDEVSLNSYSID = 55;
    private static final int INDEX_MAINPSDEVSLNSYSNAME = 56;
    private static final int INDEX_MAXENTITYCNT = 57;
    private static final int INDEX_MEMO = 58;
    private static final int INDEX_MODELGITBRANCH = 59;
    private static final int INDEX_MODELGITPATH = 60;
    private static final int INDEX_MODELINSTVER = 61;
    private static final int INDEX_MODELPREFIX = 62;
    private static final int INDEX_MODELPSDEVCENTERSVNID = 63;
    private static final int INDEX_MODELPSDEVCENTERSVNNAME = 64;
    private static final int INDEX_MSSQLPSDCDBINSTID = 65;
    private static final int INDEX_MSSQLPSDCDBINSTNAME = 66;
    private static final int INDEX_MYSQLPSDCDBINSTID = 67;
    private static final int INDEX_MYSQLPSDCDBINSTNAME = 68;
    private static final int INDEX_OFFLINETIME = 69;
    private static final int INDEX_ORAPSDCDBINSTID = 70;
    private static final int INDEX_ORAPSDCDBINSTNAME = 71;
    private static final int INDEX_PGSQLPSDCDBINSTID = 72;
    private static final int INDEX_PGSQLPSDCDBINSTNAME = 73;
    private static final int INDEX_PPASPSDCDBINSTID = 74;
    private static final int INDEX_PPASPSDCDBINSTNAME = 75;
    private static final int INDEX_PPSDEVSLNSYSID = 76;
    private static final int INDEX_PPSDEVSLNSYSNAME = 77;
    private static final int INDEX_PSDCDEPLOYCENTERID = 78;
    private static final int INDEX_PSDCDEPLOYCENTERNAME = 79;
    private static final int INDEX_PSDCMODELTEMPLID = 80;
    private static final int INDEX_PSDCMODELTEMPLNAME = 81;
    private static final int INDEX_PSDCROBOTID = 82;
    private static final int INDEX_PSDCROBOTNAME = 83;
    private static final int INDEX_PSDCSYSLICID = 84;
    private static final int INDEX_PSDCSYSLICNAME = 85;
    private static final int INDEX_PSDCWORKSPACEID = 86;
    private static final int INDEX_PSDEVCENTERASID = 87;
    private static final int INDEX_PSDEVCENTERASID2 = 88;
    private static final int INDEX_PSDEVCENTERAS3ID = 89;
    private static final int INDEX_PSDEVCENTERAS4ID = 90;
    private static final int INDEX_PSDEVCENTERASNAME = 91;
    private static final int INDEX_PSDEVCENTERASNAME2 = 92;
    private static final int INDEX_PSDEVCENTERAS3NAME = 93;
    private static final int INDEX_PSDEVCENTERAS4NAME = 94;
    private static final int INDEX_PSDEVCENTERID = 95;
    private static final int INDEX_PSDEVCENTERNAME = 96;
    private static final int INDEX_PSDEVCENTERSVNID = 97;
    private static final int INDEX_PSDEVCENTERSVNNAME = 98;
    private static final int INDEX_PSDEVCENTERTSID = 99;
    private static final int INDEX_PSDEVCENTERTSNAME = 100;
    private static final int INDEX_PSDEVSLNID = 101;
    private static final int INDEX_PSDEVSLNNAME = 102;
    private static final int INDEX_PSDEVSLNSYSID = 103;
    private static final int INDEX_PSDEVSLNSYSNAME = 104;
    private static final int INDEX_PSDEVSLNSYSRESID = 105;
    private static final int INDEX_PSDEVSLNSYSRESNAME = 106;
    private static final int INDEX_PSPFID = 107;
    private static final int INDEX_PSPFNAME = 108;
    private static final int INDEX_PSSFID = 109;
    private static final int INDEX_PSSFNAME = 110;
    private static final int INDEX_PSSTUDIOTHEMEID = 111;
    private static final int INDEX_PSSTUDIOTHEMENAME = 112;
    private static final int INDEX_PSSYSMODELINSTID = 113;
    private static final int INDEX_PSSYSMODELINSTNAME = 114;
    private static final int INDEX_PSSYSPOLICYID = 115;
    private static final int INDEX_PSSYSPOLICYNAME = 116;
    private static final int INDEX_PSSYSTEMID = 117;
    private static final int INDEX_PSTASKSERVERID = 118;
    private static final int INDEX_PSTASKSERVERNAME = 119;
    private static final int INDEX_PUBCODE = 120;
    private static final int INDEX_RESREADYTIME = 121;
    private static final int INDEX_ROGITBRANCH = 122;
    private static final int INDEX_ROGITPATH = 123;
    private static final int INDEX_ROPSDEVCENTERSVNID = 124;
    private static final int INDEX_ROPSDEVCENTERSVNNAME = 125;
    private static final int INDEX_RTMODELPSDEVCENTERSVNID = 126;
    private static final int INDEX_RTMODELPSDEVCENTERSVNNAME = 127;
    private static final int INDEX_SAASMODE = 128;
    private static final int INDEX_SFPSSUBSYSID = 129;
    private static final int INDEX_SFPSSUBSYSNAME = 130;
    private static final int INDEX_SHAREFLAG = 131;
    private static final int INDEX_STUDIOTAG = 132;
    private static final int INDEX_STUDIOTAG2 = 133;
    private static final int INDEX_STUDIOVER = 134;
    private static final int INDEX_SYSFOLDER = 135;
    private static final int INDEX_SYSMDURL = 136;
    private static final int INDEX_SYSROWKEY = 137;
    private static final int INDEX_SYSTAG = 138;
    private static final int INDEX_SYSTAG2 = 139;
    private static final int INDEX_SYSTAG3 = 140;
    private static final int INDEX_SYSTAG4 = 141;
    private static final int INDEX_SYSTYPE = 142;
    private static final int INDEX_SYSVER = 143;
    private static final int INDEX_TEMPLENGINE = 144;
    private static final int INDEX_THEMECSSSTYLE = 145;
    private static final int INDEX_UNLOADTIME = 146;
    private static final int INDEX_UPDATEDATE = 147;
    private static final int INDEX_UPDATEMAN = 148;
    private static final int INDEX_USERCAT = 149;
    private static final int INDEX_USERTAG = 150;
    private static final int INDEX_USERTAG2 = 151;
    private static final int INDEX_USERTAG3 = 152;
    private static final int INDEX_USERTAG4 = 153;
    private static final int INDEX_VALIDFLAG = 154;
    private static final int INDEX_VCTYPE = 155;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevSlnSysBase proxyPSDevSlnSysBase = null;
    private boolean actionownerDirtyFlag = false;
    private boolean apiflagDirtyFlag = false;
    private boolean callbacktagDirtyFlag = false;
    private boolean callbackurlDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean curactionDirtyFlag = false;
    private boolean db2psdcdbinstidDirtyFlag = false;
    private boolean db2psdcdbinstnameDirtyFlag = false;
    private boolean dbtypesDirtyFlag = false;
    private boolean dbversionDirtyFlag = false;
    private boolean deploysysidDirtyFlag = false;
    private boolean deploysysorgidDirtyFlag = false;
    private boolean deploysysorgsectoridDirtyFlag = false;
    private boolean deploysystagDirtyFlag = false;
    private boolean deploysystag2DirtyFlag = false;
    private boolean deploysystypeDirtyFlag = false;
    private boolean devresinfoDirtyFlag = false;
    private boolean devresstateDirtyFlag = false;
    private boolean devsysstateDirtyFlag = false;
    private boolean docgitbranchDirtyFlag = false;
    private boolean docgitpathDirtyFlag = false;
    private boolean docpsdevcentersvnidDirtyFlag = false;
    private boolean docpsdevcentersvnnameDirtyFlag = false;
    private boolean enablecallbackDirtyFlag = false;
    private boolean enabledb2DirtyFlag = false;
    private boolean enabledeploycenterDirtyFlag = false;
    private boolean enabledmDirtyFlag = false;
    private boolean enabledynasysDirtyFlag = false;
    private boolean enablefolderkeyDirtyFlag = false;
    private boolean enablehanaDirtyFlag = false;
    private boolean enablehbaseDirtyFlag = false;
    private boolean enablemysql5DirtyFlag = false;
    private boolean enableoracleDirtyFlag = false;
    private boolean enablepgsqlDirtyFlag = false;
    private boolean enableppasDirtyFlag = false;
    private boolean enablesqliteDirtyFlag = false;
    private boolean enablesqlserverDirtyFlag = false;
    private boolean enablewsserverDirtyFlag = false;
    private boolean entitycntDirtyFlag = false;
    private boolean expriedtimeDirtyFlag = false;
    private boolean gitbranchDirtyFlag = false;
    private boolean gitpathDirtyFlag = false;
    private boolean hbasepsdcbdinstidDirtyFlag = false;
    private boolean hbasepsdcbdinstnameDirtyFlag = false;
    private boolean initparamsDirtyFlag = false;
    private boolean jitpsdbdevinstidDirtyFlag = false;
    private boolean jitpsdbdevinstnameDirtyFlag = false;
    private boolean jitpsdevcentertsidDirtyFlag = false;
    private boolean jitpsdevcentertsnameDirtyFlag = false;
    private boolean lastactivetimeDirtyFlag = false;
    private boolean loadtimeDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean lowcodemodeDirtyFlag = false;
    private boolean mainpsdevslnsysidDirtyFlag = false;
    private boolean mainpsdevslnsysnameDirtyFlag = false;
    private boolean maxentitycntDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean modelgitbranchDirtyFlag = false;
    private boolean modelgitpathDirtyFlag = false;
    private boolean modelinstverDirtyFlag = false;
    private boolean modelprefixDirtyFlag = false;
    private boolean modelpsdevcentersvnidDirtyFlag = false;
    private boolean modelpsdevcentersvnnameDirtyFlag = false;
    private boolean mssqlpsdcdbinstidDirtyFlag = false;
    private boolean mssqlpsdcdbinstnameDirtyFlag = false;
    private boolean mysqlpsdcdbinstidDirtyFlag = false;
    private boolean mysqlpsdcdbinstnameDirtyFlag = false;
    private boolean offlinetimeDirtyFlag = false;
    private boolean orapsdcdbinstidDirtyFlag = false;
    private boolean orapsdcdbinstnameDirtyFlag = false;
    private boolean pgsqlpsdcdbinstidDirtyFlag = false;
    private boolean pgsqlpsdcdbinstnameDirtyFlag = false;
    private boolean ppaspsdcdbinstidDirtyFlag = false;
    private boolean ppaspsdcdbinstnameDirtyFlag = false;
    private boolean ppsdevslnsysidDirtyFlag = false;
    private boolean ppsdevslnsysnameDirtyFlag = false;
    private boolean psdcdeploycenteridDirtyFlag = false;
    private boolean psdcdeploycenternameDirtyFlag = false;
    private boolean psdcmodeltemplidDirtyFlag = false;
    private boolean psdcmodeltemplnameDirtyFlag = false;
    private boolean psdcrobotidDirtyFlag = false;
    private boolean psdcrobotnameDirtyFlag = false;
    private boolean psdcsyslicidDirtyFlag = false;
    private boolean psdcsyslicnameDirtyFlag = false;
    private boolean psdcworkspaceidDirtyFlag = false;
    private boolean psdevcenterasidDirtyFlag = false;
    private boolean psdevcenterasid2DirtyFlag = false;
    private boolean psdevcenteras3idDirtyFlag = false;
    private boolean psdevcenteras4idDirtyFlag = false;
    private boolean psdevcenterasnameDirtyFlag = false;
    private boolean psdevcenterasname2DirtyFlag = false;
    private boolean psdevcenteras3nameDirtyFlag = false;
    private boolean psdevcenteras4nameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevcentersvnidDirtyFlag = false;
    private boolean psdevcentersvnnameDirtyFlag = false;
    private boolean psdevcentertsidDirtyFlag = false;
    private boolean psdevcentertsnameDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnnameDirtyFlag = false;
    private boolean psdevslnsysidDirtyFlag = false;
    private boolean psdevslnsysnameDirtyFlag = false;
    private boolean psdevslnsysresidDirtyFlag = false;
    private boolean psdevslnsysresnameDirtyFlag = false;
    private boolean pspfidDirtyFlag = false;
    private boolean pspfnameDirtyFlag = false;
    private boolean pssfidDirtyFlag = false;
    private boolean pssfnameDirtyFlag = false;
    private boolean psstudiothemeidDirtyFlag = false;
    private boolean psstudiothemenameDirtyFlag = false;
    private boolean pssysmodelinstidDirtyFlag = false;
    private boolean pssysmodelinstnameDirtyFlag = false;
    private boolean pssyspolicyidDirtyFlag = false;
    private boolean pssyspolicynameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pstaskserveridDirtyFlag = false;
    private boolean pstaskservernameDirtyFlag = false;
    private boolean pubcodeDirtyFlag = false;
    private boolean resreadytimeDirtyFlag = false;
    private boolean rogitbranchDirtyFlag = false;
    private boolean rogitpathDirtyFlag = false;
    private boolean ropsdevcentersvnidDirtyFlag = false;
    private boolean ropsdevcentersvnnameDirtyFlag = false;
    private boolean rtmodelpsdevcentersvnidDirtyFlag = false;
    private boolean rtmodelpsdevcentersvnnameDirtyFlag = false;
    private boolean saasmodeDirtyFlag = false;
    private boolean sfpssubsysidDirtyFlag = false;
    private boolean sfpssubsysnameDirtyFlag = false;
    private boolean shareflagDirtyFlag = false;
    private boolean studiotagDirtyFlag = false;
    private boolean studiotag2DirtyFlag = false;
    private boolean studioverDirtyFlag = false;
    private boolean sysfolderDirtyFlag = false;
    private boolean sysmdurlDirtyFlag = false;
    private boolean sysrowkeyDirtyFlag = false;
    private boolean systagDirtyFlag = false;
    private boolean systag2DirtyFlag = false;
    private boolean systag3DirtyFlag = false;
    private boolean systag4DirtyFlag = false;
    private boolean systypeDirtyFlag = false;
    private boolean sysverDirtyFlag = false;
    private boolean templengineDirtyFlag = false;
    private boolean themecssstyleDirtyFlag = false;
    private boolean unloadtimeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean vctypeDirtyFlag = false;
    @Column(name="actionowner")
    private String actionowner;
    @Column(name="apiflag")
    private Integer apiflag;
    @Column(name="callbacktag")
    private String callbacktag;
    @Column(name="callbackurl")
    private String callbackurl;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="curaction")
    private String curaction;
    @Column(name="db2psdcdbinstid")
    private String db2psdcdbinstid;
    @Column(name="db2psdcdbinstname")
    private String db2psdcdbinstname;
    @Column(name="dbtypes")
    private String dbtypes;
    @Column(name="dbversion")
    private Integer dbversion;
    @Column(name="deploysysid")
    private String deploysysid;
    @Column(name="deploysysorgid")
    private String deploysysorgid;
    @Column(name="deploysysorgsectorid")
    private String deploysysorgsectorid;
    @Column(name="deploysystag")
    private String deploysystag;
    @Column(name="deploysystag2")
    private String deploysystag2;
    @Column(name="deploysystype")
    private String deploysystype;
    @Column(name="devresinfo")
    private String devresinfo;
    @Column(name="devresstate")
    private Integer devresstate;
    @Column(name="devsysstate")
    private Integer devsysstate;
    @Column(name="docgitbranch")
    private String docgitbranch;
    @Column(name="docgitpath")
    private String docgitpath;
    @Column(name="docpsdevcentersvnid")
    private String docpsdevcentersvnid;
    @Column(name="docpsdevcentersvnname")
    private String docpsdevcentersvnname;
    @Column(name="enablecallback")
    private Integer enablecallback;
    @Column(name="enabledb2")
    private Integer enabledb2;
    @Column(name="enabledeploycenter")
    private Integer enabledeploycenter;
    @Column(name="enabledm")
    private Integer enabledm;
    @Column(name="enabledynasys")
    private Integer enabledynasys;
    @Column(name="enablefolderkey")
    private Integer enablefolderkey;
    @Column(name="enablehana")
    private Integer enablehana;
    @Column(name="enablehbase")
    private Integer enablehbase;
    @Column(name="enablemysql5")
    private Integer enablemysql5;
    @Column(name="enableoracle")
    private Integer enableoracle;
    @Column(name="enablepgsql")
    private Integer enablepgsql;
    @Column(name="enableppas")
    private Integer enableppas;
    @Column(name="enablesqlite")
    private Integer enablesqlite;
    @Column(name="enablesqlserver")
    private Integer enablesqlserver;
    @Column(name="enablewsserver")
    private Integer enablewsserver;
    @Column(name="entitycnt")
    private Integer entitycnt;
    @Column(name="expriedtime")
    private Timestamp expriedtime;
    @Column(name="gitbranch")
    private String gitbranch;
    @Column(name="gitpath")
    private String gitpath;
    @Column(name="hbasepsdcbdinstid")
    private String hbasepsdcbdinstid;
    @Column(name="hbasepsdcbdinstname")
    private String hbasepsdcbdinstname;
    @Column(name="initparams")
    private String initparams;
    @Column(name="jitpsdbdevinstid")
    private String jitpsdbdevinstid;
    @Column(name="jitpsdbdevinstname")
    private String jitpsdbdevinstname;
    @Column(name="jitpsdevcentertsid")
    private String jitpsdevcentertsid;
    @Column(name="jitpsdevcentertsname")
    private String jitpsdevcentertsname;
    @Column(name="lastactivetime")
    private Timestamp lastactivetime;
    @Column(name="loadtime")
    private Timestamp loadtime;
    @Column(name="logicname")
    private String logicname;
    @Column(name="lowcodemode")
    private Integer lowcodemode;
    @Column(name="mainpsdevslnsysid")
    private String mainpsdevslnsysid;
    @Column(name="mainpsdevslnsysname")
    private String mainpsdevslnsysname;
    @Column(name="maxentitycnt")
    private Integer maxentitycnt;
    @Column(name="memo")
    private String memo;
    @Column(name="modelgitbranch")
    private String modelgitbranch;
    @Column(name="modelgitpath")
    private String modelgitpath;
    @Column(name="modelinstver")
    private Integer modelinstver;
    @Column(name="modelprefix")
    private String modelprefix;
    @Column(name="modelpsdevcentersvnid")
    private String modelpsdevcentersvnid;
    @Column(name="modelpsdevcentersvnname")
    private String modelpsdevcentersvnname;
    @Column(name="mssqlpsdcdbinstid")
    private String mssqlpsdcdbinstid;
    @Column(name="mssqlpsdcdbinstname")
    private String mssqlpsdcdbinstname;
    @Column(name="mysqlpsdcdbinstid")
    private String mysqlpsdcdbinstid;
    @Column(name="mysqlpsdcdbinstname")
    private String mysqlpsdcdbinstname;
    @Column(name="offlinetime")
    private Timestamp offlinetime;
    @Column(name="orapsdcdbinstid")
    private String orapsdcdbinstid;
    @Column(name="orapsdcdbinstname")
    private String orapsdcdbinstname;
    @Column(name="pgsqlpsdcdbinstid")
    private String pgsqlpsdcdbinstid;
    @Column(name="pgsqlpsdcdbinstname")
    private String pgsqlpsdcdbinstname;
    @Column(name="ppaspsdcdbinstid")
    private String ppaspsdcdbinstid;
    @Column(name="ppaspsdcdbinstname")
    private String ppaspsdcdbinstname;
    @Column(name="ppsdevslnsysid")
    private String ppsdevslnsysid;
    @Column(name="ppsdevslnsysname")
    private String ppsdevslnsysname;
    @Column(name="psdcdeploycenterid")
    private String psdcdeploycenterid;
    @Column(name="psdcdeploycentername")
    private String psdcdeploycentername;
    @Column(name="psdcmodeltemplid")
    private String psdcmodeltemplid;
    @Column(name="psdcmodeltemplname")
    private String psdcmodeltemplname;
    @Column(name="psdcrobotid")
    private String psdcrobotid;
    @Column(name="psdcrobotname")
    private String psdcrobotname;
    @Column(name="psdcsyslicid")
    private String psdcsyslicid;
    @Column(name="psdcsyslicname")
    private String psdcsyslicname;
    @Column(name="psdcworkspaceid")
    private String psdcworkspaceid;
    @Column(name="psdevcenterasid")
    private String psdevcenterasid;
    @Column(name="psdevcenterasid2")
    private String psdevcenterasid2;
    @Column(name="psdevcenteras3id")
    private String psdevcenteras3id;
    @Column(name="psdevcenteras4id")
    private String psdevcenteras4id;
    @Column(name="psdevcenterasname")
    private String psdevcenterasname;
    @Column(name="psdevcenterasname2")
    private String psdevcenterasname2;
    @Column(name="psdevcenteras3name")
    private String psdevcenteras3name;
    @Column(name="psdevcenteras4name")
    private String psdevcenteras4name;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psdevcentersvnid")
    private String psdevcentersvnid;
    @Column(name="psdevcentersvnname")
    private String psdevcentersvnname;
    @Column(name="psdevcentertsid")
    private String psdevcentertsid;
    @Column(name="psdevcentertsname")
    private String psdevcentertsname;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnname")
    private String psdevslnname;
    @Column(name="psdevslnsysid")
    private String psdevslnsysid;
    @Column(name="psdevslnsysname")
    private String psdevslnsysname;
    @Column(name="psdevslnsysresid")
    private String psdevslnsysresid;
    @Column(name="psdevslnsysresname")
    private String psdevslnsysresname;
    @Column(name="pspfid")
    private String pspfid;
    @Column(name="pspfname")
    private String pspfname;
    @Column(name="pssfid")
    private String pssfid;
    @Column(name="pssfname")
    private String pssfname;
    @Column(name="psstudiothemeid")
    private String psstudiothemeid;
    @Column(name="psstudiothemename")
    private String psstudiothemename;
    @Column(name="pssysmodelinstid")
    private String pssysmodelinstid;
    @Column(name="pssysmodelinstname")
    private String pssysmodelinstname;
    @Column(name="pssyspolicyid")
    private String pssyspolicyid;
    @Column(name="pssyspolicyname")
    private String pssyspolicyname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pstaskserverid")
    private String pstaskserverid;
    @Column(name="pstaskservername")
    private String pstaskservername;
    @Column(name="pubcode")
    private Integer pubcode;
    @Column(name="resreadytime")
    private Timestamp resreadytime;
    @Column(name="rogitbranch")
    private String rogitbranch;
    @Column(name="rogitpath")
    private String rogitpath;
    @Column(name="ropsdevcentersvnid")
    private String ropsdevcentersvnid;
    @Column(name="ropsdevcentersvnname")
    private String ropsdevcentersvnname;
    @Column(name="rtmodelpsdevcentersvnid")
    private String rtmodelpsdevcentersvnid;
    @Column(name="rtmodelpsdevcentersvnname")
    private String rtmodelpsdevcentersvnname;
    @Column(name="saasmode")
    private Integer saasmode;
    @Column(name="sfpssubsysid")
    private String sfpssubsysid;
    @Column(name="sfpssubsysname")
    private String sfpssubsysname;
    @Column(name="shareflag")
    private Integer shareflag;
    @Column(name="studiotag")
    private String studiotag;
    @Column(name="studiotag2")
    private String studiotag2;
    @Column(name="studiover")
    private String studiover;
    @Column(name="sysfolder")
    private String sysfolder;
    @Column(name="sysmdurl")
    private String sysmdurl;
    @Column(name="sysrowkey")
    private String sysrowkey;
    @Column(name="systag")
    private String systag;
    @Column(name="systag2")
    private String systag2;
    @Column(name="systag3")
    private String systag3;
    @Column(name="systag4")
    private String systag4;
    @Column(name="systype")
    private String systype;
    @Column(name="sysver")
    private String sysver;
    @Column(name="templengine")
    private String templengine;
    @Column(name="themecssstyle")
    private String themecssstyle;
    @Column(name="unloadtime")
    private Timestamp unloadtime;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercat")
    private String usercat;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    @Column(name="validflag")
    private Integer validflag;
    @Column(name="vctype")
    private String vctype;
    private Integer objJitPSDBDevInstLock = new Integer(1);
    private PSDBDevInst jitpsdbdevinst = null;
    private Integer objHBasePSDCDBInstLock = new Integer(1);
    private PSDCBDInst hbasepsdcdbinst = null;
    private Integer objPSDCDeployCenterLock = new Integer(1);
    private PSDCDeployCenter psdcdeploycenter = null;
    private Integer objPSDCModelTemplLock = new Integer(1);
    private PSDCModelTempl psdcmodeltempl = null;
    private Integer objPSDCRobotLock = new Integer(1);
    private PSDCRobot psdcrobot = null;
    private Integer objPSDCSysLicLock = new Integer(1);
    private PSDCSysLic psdcsyslic = null;
    private Integer objPSDevCenterASLock = new Integer(1);
    private PSDevCenterAS psdevcenteras = null;
    private Integer objPSDevCenterAS2Lock = new Integer(1);
    private PSDevCenterAS psdevcenteras2 = null;
    private Integer objPSDevCenterAS3Lock = new Integer(1);
    private PSDevCenterAS psdevcenteras3 = null;
    private Integer objPSDevCenterAS4Lock = new Integer(1);
    private PSDevCenterAS psdevcenteras4 = null;
    private Integer objDB2PSDCDBInstLock = new Integer(1);
    private PSDevCenterDBInst db2psdcdbinst = null;
    private Integer objMSSQLPSDCDBInstLock = new Integer(1);
    private PSDevCenterDBInst mssqlpsdcdbinst = null;
    private Integer objMySQLPSDCDBInstLock = new Integer(1);
    private PSDevCenterDBInst mysqlpsdcdbinst = null;
    private Integer objOraPSDCDBInstLock = new Integer(1);
    private PSDevCenterDBInst orapsdcdbinst = null;
    private Integer objPGSQLPSDCDBInstLock = new Integer(1);
    private PSDevCenterDBInst pgsqlpsdcdbinst = null;
    private Integer objPPASPSDCDBInstLock = new Integer(1);
    private PSDevCenterDBInst ppaspsdcdbinst = null;
    private Integer objDocPSDevCenterSVNLock = new Integer(1);
    private PSDevCenterSVN docpsdevcentersvn = null;
    private Integer objModelPSDevCenterSVNLock = new Integer(1);
    private PSDevCenterSVN modelpsdevcentersvn = null;
    private Integer objPSDevCenterSVNLock = new Integer(1);
    private PSDevCenterSVN psdevcentersvn = null;
    private Integer objROPSDevCenterSvnLock = new Integer(1);
    private PSDevCenterSVN ropsdevcentersvn = null;
    private Integer objRTModelPSDevCenterSVNLock = new Integer(1);
    private PSDevCenterSVN rtmodelpsdevcentersvn = null;
    private Integer objJITPSDevCenterTSLock = new Integer(1);
    private PSDevCenterTS jitpsdevcenterts = null;
    private Integer objPSDevCenterTSLock = new Integer(1);
    private PSDevCenterTS psdevcenterts = null;
    private Integer objPSDevSlnSysResLock = new Integer(1);
    private PSDevSlnSysRes psdevslnsysres = null;
    private Integer objMainPSDevSlnSysLock = new Integer(1);
    private PSDevSlnSys mainpsdevslnsys = null;
    private Integer objPPSDevSlnSysLock = new Integer(1);
    private PSDevSlnSys ppsdevslnsys = null;
    private Integer objPSDevSlnLock = new Integer(1);
    private PSDevSln psdevsln = null;
    private Integer objPSPFLock = new Integer(1);
    private PSPF pspf = null;
    private Integer objPSSFLock = new Integer(1);
    private PSSF pssf = null;
    private Integer objPSStudioThemeLock = new Integer(1);
    private PSStudioTheme psstudiotheme = null;
    private Integer objSFPSSubSysLock = new Integer(1);
    private PSSubSys sfpssubsys = null;
    private Integer objPSSysModelInstLock = new Integer(1);
    private PSSysModelInst pssysmodelinst = null;
    private Integer objPSSysPolicyLock = new Integer(1);
    private PSSysPolicy pssyspolicy = null;
    private Integer objPSTaskServerLock = new Integer(1);
    private PSTaskServer pstaskserver = null;
    private Integer objPSDCRegistryItemsLock = new Integer(1);
    private ArrayList<PSDCRegistryItem> psdcregistryitems = null;
    private Integer objPSDevSlnMSDepResesLock = new Integer(1);
    private ArrayList<PSDevSlnMSDepRes> psdevslnmsdepreses = null;
    private Integer objPSDevSlnSysAPIsLock = new Integer(1);
    private ArrayList<PSDevSlnSysAPI> psdevslnsysapis = null;
    private Integer objPSDevSlnSysAppsLock = new Integer(1);
    private ArrayList<PSDevSlnSysApp> psdevslnsysapps = null;
    private Integer objPSDevSlnSysBaksLock = new Integer(1);
    private ArrayList<PSDevSlnSysBak> psdevslnsysbaks = null;
    private Integer objPSDevSlnSysDepInstsLock = new Integer(1);
    private ArrayList<PSDevSlnSysDepInst> psdevslnsysdepinsts = null;
    private Integer objPSDevSlnSysDynaInstsLock = new Integer(1);
    private ArrayList<PSDevSlnSysDynaInst> psdevslnsysdynainsts = null;
    private Integer objPSDevSlnSysRefLinksLock = new Integer(1);
    private ArrayList<PSDevSlnSysRefLink> psdevslnsysreflinks = null;
    private Integer objPSDevSlnSysRefsLock = new Integer(1);
    private ArrayList<PSDevSlnSysRef> psdevslnsysrefs = null;
    private Integer objPSDevSlnSysSrvsLock = new Integer(1);
    private ArrayList<PSDevSlnSysSrv> psdevslnsyssrvs = null;
    private Integer objPSDevSlnSysWSGitLock = new Integer(1);
    private ArrayList<PSDevSlnSysWSGit> psdevslnsyswsgit = null;

    public void setActionOwner(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionOwner(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actionowner = string;
        this.actionownerDirtyFlag = true;
    }

    public String getActionOwner() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionOwner();
        }
        return this.actionowner;
    }

    public boolean isActionOwnerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionOwnerDirty();
        }
        return this.actionownerDirtyFlag;
    }

    public void resetActionOwner() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionOwner();
            return;
        }
        this.actionownerDirtyFlag = false;
        this.actionowner = null;
    }

    public void setAPIFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAPIFlag(n);
            return;
        }
        this.apiflag = n;
        this.apiflagDirtyFlag = true;
    }

    public Integer getAPIFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAPIFlag();
        }
        return this.apiflag;
    }

    public boolean isAPIFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAPIFlagDirty();
        }
        return this.apiflagDirtyFlag;
    }

    public void resetAPIFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAPIFlag();
            return;
        }
        this.apiflagDirtyFlag = false;
        this.apiflag = null;
    }

    public void setCallbackTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCallbackTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.callbacktag = string;
        this.callbacktagDirtyFlag = true;
    }

    public String getCallbackTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCallbackTag();
        }
        return this.callbacktag;
    }

    public boolean isCallbackTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCallbackTagDirty();
        }
        return this.callbacktagDirtyFlag;
    }

    public void resetCallbackTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCallbackTag();
            return;
        }
        this.callbacktagDirtyFlag = false;
        this.callbacktag = null;
    }

    public void setCallbackUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCallbackUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.callbackurl = string;
        this.callbackurlDirtyFlag = true;
    }

    public String getCallbackUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCallbackUrl();
        }
        return this.callbackurl;
    }

    public boolean isCallbackUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCallbackUrlDirty();
        }
        return this.callbackurlDirtyFlag;
    }

    public void resetCallbackUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCallbackUrl();
            return;
        }
        this.callbackurlDirtyFlag = false;
        this.callbackurl = null;
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

    public void setCurAction(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCurAction(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.curaction = string;
        this.curactionDirtyFlag = true;
    }

    public String getCurAction() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCurAction();
        }
        return this.curaction;
    }

    public boolean isCurActionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCurActionDirty();
        }
        return this.curactionDirtyFlag;
    }

    public void resetCurAction() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCurAction();
            return;
        }
        this.curactionDirtyFlag = false;
        this.curaction = null;
    }

    public void setDB2PSDCDBInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDB2PSDCDBInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.db2psdcdbinstid = string;
        this.db2psdcdbinstidDirtyFlag = true;
    }

    public String getDB2PSDCDBInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDB2PSDCDBInstId();
        }
        return this.db2psdcdbinstid;
    }

    public boolean isDB2PSDCDBInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDB2PSDCDBInstIdDirty();
        }
        return this.db2psdcdbinstidDirtyFlag;
    }

    public void resetDB2PSDCDBInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDB2PSDCDBInstId();
            return;
        }
        this.db2psdcdbinstidDirtyFlag = false;
        this.db2psdcdbinstid = null;
    }

    public void setDB2PSDCDBInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDB2PSDCDBInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.db2psdcdbinstname = string;
        this.db2psdcdbinstnameDirtyFlag = true;
    }

    public String getDB2PSDCDBInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDB2PSDCDBInstName();
        }
        return this.db2psdcdbinstname;
    }

    public boolean isDB2PSDCDBInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDB2PSDCDBInstNameDirty();
        }
        return this.db2psdcdbinstnameDirtyFlag;
    }

    public void resetDB2PSDCDBInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDB2PSDCDBInstName();
            return;
        }
        this.db2psdcdbinstnameDirtyFlag = false;
        this.db2psdcdbinstname = null;
    }

    public void setDBTypes(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDBTypes(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dbtypes = string;
        this.dbtypesDirtyFlag = true;
    }

    public String getDBTypes() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDBTypes();
        }
        return this.dbtypes;
    }

    public boolean isDBTypesDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDBTypesDirty();
        }
        return this.dbtypesDirtyFlag;
    }

    public void resetDBTypes() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDBTypes();
            return;
        }
        this.dbtypesDirtyFlag = false;
        this.dbtypes = null;
    }

    public void setDBVersion(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDBVersion(n);
            return;
        }
        this.dbversion = n;
        this.dbversionDirtyFlag = true;
    }

    public Integer getDBVersion() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDBVersion();
        }
        return this.dbversion;
    }

    public boolean isDBVersionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDBVersionDirty();
        }
        return this.dbversionDirtyFlag;
    }

    public void resetDBVersion() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDBVersion();
            return;
        }
        this.dbversionDirtyFlag = false;
        this.dbversion = null;
    }

    public void setDeploySysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDeploySysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.deploysysid = string;
        this.deploysysidDirtyFlag = true;
    }

    public String getDeploySysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDeploySysId();
        }
        return this.deploysysid;
    }

    public boolean isDeploySysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDeploySysIdDirty();
        }
        return this.deploysysidDirtyFlag;
    }

    public void resetDeploySysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDeploySysId();
            return;
        }
        this.deploysysidDirtyFlag = false;
        this.deploysysid = null;
    }

    public void setDeploySysOrgId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDeploySysOrgId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.deploysysorgid = string;
        this.deploysysorgidDirtyFlag = true;
    }

    public String getDeploySysOrgId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDeploySysOrgId();
        }
        return this.deploysysorgid;
    }

    public boolean isDeploySysOrgIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDeploySysOrgIdDirty();
        }
        return this.deploysysorgidDirtyFlag;
    }

    public void resetDeploySysOrgId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDeploySysOrgId();
            return;
        }
        this.deploysysorgidDirtyFlag = false;
        this.deploysysorgid = null;
    }

    public void setDeploySysOrgSectorId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDeploySysOrgSectorId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.deploysysorgsectorid = string;
        this.deploysysorgsectoridDirtyFlag = true;
    }

    public String getDeploySysOrgSectorId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDeploySysOrgSectorId();
        }
        return this.deploysysorgsectorid;
    }

    public boolean isDeploySysOrgSectorIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDeploySysOrgSectorIdDirty();
        }
        return this.deploysysorgsectoridDirtyFlag;
    }

    public void resetDeploySysOrgSectorId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDeploySysOrgSectorId();
            return;
        }
        this.deploysysorgsectoridDirtyFlag = false;
        this.deploysysorgsectorid = null;
    }

    public void setDeploySysTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDeploySysTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.deploysystag = string;
        this.deploysystagDirtyFlag = true;
    }

    public String getDeploySysTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDeploySysTag();
        }
        return this.deploysystag;
    }

    public boolean isDeploySysTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDeploySysTagDirty();
        }
        return this.deploysystagDirtyFlag;
    }

    public void resetDeploySysTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDeploySysTag();
            return;
        }
        this.deploysystagDirtyFlag = false;
        this.deploysystag = null;
    }

    public void setDeploySysTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDeploySysTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.deploysystag2 = string;
        this.deploysystag2DirtyFlag = true;
    }

    public String getDeploySysTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDeploySysTag2();
        }
        return this.deploysystag2;
    }

    public boolean isDeploySysTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDeploySysTag2Dirty();
        }
        return this.deploysystag2DirtyFlag;
    }

    public void resetDeploySysTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDeploySysTag2();
            return;
        }
        this.deploysystag2DirtyFlag = false;
        this.deploysystag2 = null;
    }

    public void setDeploySysType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDeploySysType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.deploysystype = string;
        this.deploysystypeDirtyFlag = true;
    }

    public String getDeploySysType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDeploySysType();
        }
        return this.deploysystype;
    }

    public boolean isDeploySysTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDeploySysTypeDirty();
        }
        return this.deploysystypeDirtyFlag;
    }

    public void resetDeploySysType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDeploySysType();
            return;
        }
        this.deploysystypeDirtyFlag = false;
        this.deploysystype = null;
    }

    public void setDevResInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDevResInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.devresinfo = string;
        this.devresinfoDirtyFlag = true;
    }

    public String getDevResInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDevResInfo();
        }
        return this.devresinfo;
    }

    public boolean isDevResInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDevResInfoDirty();
        }
        return this.devresinfoDirtyFlag;
    }

    public void resetDevResInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDevResInfo();
            return;
        }
        this.devresinfoDirtyFlag = false;
        this.devresinfo = null;
    }

    public void setDevResState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDevResState(n);
            return;
        }
        this.devresstate = n;
        this.devresstateDirtyFlag = true;
    }

    public Integer getDevResState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDevResState();
        }
        return this.devresstate;
    }

    public boolean isDevResStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDevResStateDirty();
        }
        return this.devresstateDirtyFlag;
    }

    public void resetDevResState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDevResState();
            return;
        }
        this.devresstateDirtyFlag = false;
        this.devresstate = null;
    }

    public void setDevSysState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDevSysState(n);
            return;
        }
        this.devsysstate = n;
        this.devsysstateDirtyFlag = true;
    }

    public Integer getDevSysState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDevSysState();
        }
        return this.devsysstate;
    }

    public boolean isDevSysStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDevSysStateDirty();
        }
        return this.devsysstateDirtyFlag;
    }

    public void resetDevSysState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDevSysState();
            return;
        }
        this.devsysstateDirtyFlag = false;
        this.devsysstate = null;
    }

    public void setDocGitBranch(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDocGitBranch(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.docgitbranch = string;
        this.docgitbranchDirtyFlag = true;
    }

    public String getDocGitBranch() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDocGitBranch();
        }
        return this.docgitbranch;
    }

    public boolean isDocGitBranchDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDocGitBranchDirty();
        }
        return this.docgitbranchDirtyFlag;
    }

    public void resetDocGitBranch() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDocGitBranch();
            return;
        }
        this.docgitbranchDirtyFlag = false;
        this.docgitbranch = null;
    }

    public void setDocGitPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDocGitPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.docgitpath = string;
        this.docgitpathDirtyFlag = true;
    }

    public String getDocGitPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDocGitPath();
        }
        return this.docgitpath;
    }

    public boolean isDocGitPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDocGitPathDirty();
        }
        return this.docgitpathDirtyFlag;
    }

    public void resetDocGitPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDocGitPath();
            return;
        }
        this.docgitpathDirtyFlag = false;
        this.docgitpath = null;
    }

    public void setDocPSDevCenterSVNId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDocPSDevCenterSVNId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.docpsdevcentersvnid = string;
        this.docpsdevcentersvnidDirtyFlag = true;
    }

    public String getDocPSDevCenterSVNId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDocPSDevCenterSVNId();
        }
        return this.docpsdevcentersvnid;
    }

    public boolean isDocPSDevCenterSVNIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDocPSDevCenterSVNIdDirty();
        }
        return this.docpsdevcentersvnidDirtyFlag;
    }

    public void resetDocPSDevCenterSVNId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDocPSDevCenterSVNId();
            return;
        }
        this.docpsdevcentersvnidDirtyFlag = false;
        this.docpsdevcentersvnid = null;
    }

    public void setDocPSDevCenterSVNName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDocPSDevCenterSVNName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.docpsdevcentersvnname = string;
        this.docpsdevcentersvnnameDirtyFlag = true;
    }

    public String getDocPSDevCenterSVNName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDocPSDevCenterSVNName();
        }
        return this.docpsdevcentersvnname;
    }

    public boolean isDocPSDevCenterSVNNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDocPSDevCenterSVNNameDirty();
        }
        return this.docpsdevcentersvnnameDirtyFlag;
    }

    public void resetDocPSDevCenterSVNName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDocPSDevCenterSVNName();
            return;
        }
        this.docpsdevcentersvnnameDirtyFlag = false;
        this.docpsdevcentersvnname = null;
    }

    public void setEnableCallback(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableCallback(n);
            return;
        }
        this.enablecallback = n;
        this.enablecallbackDirtyFlag = true;
    }

    public Integer getEnableCallback() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableCallback();
        }
        return this.enablecallback;
    }

    public boolean isEnableCallbackDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableCallbackDirty();
        }
        return this.enablecallbackDirtyFlag;
    }

    public void resetEnableCallback() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableCallback();
            return;
        }
        this.enablecallbackDirtyFlag = false;
        this.enablecallback = null;
    }

    public void setEnableDB2(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableDB2(n);
            return;
        }
        this.enabledb2 = n;
        this.enabledb2DirtyFlag = true;
    }

    public Integer getEnableDB2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableDB2();
        }
        return this.enabledb2;
    }

    public boolean isEnableDB2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableDB2Dirty();
        }
        return this.enabledb2DirtyFlag;
    }

    public void resetEnableDB2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableDB2();
            return;
        }
        this.enabledb2DirtyFlag = false;
        this.enabledb2 = null;
    }

    public void setEnableDeployCenter(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableDeployCenter(n);
            return;
        }
        this.enabledeploycenter = n;
        this.enabledeploycenterDirtyFlag = true;
    }

    public Integer getEnableDeployCenter() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableDeployCenter();
        }
        return this.enabledeploycenter;
    }

    public boolean isEnableDeployCenterDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableDeployCenterDirty();
        }
        return this.enabledeploycenterDirtyFlag;
    }

    public void resetEnableDeployCenter() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableDeployCenter();
            return;
        }
        this.enabledeploycenterDirtyFlag = false;
        this.enabledeploycenter = null;
    }

    public void setEnableDM(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableDM(n);
            return;
        }
        this.enabledm = n;
        this.enabledmDirtyFlag = true;
    }

    public Integer getEnableDM() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableDM();
        }
        return this.enabledm;
    }

    public boolean isEnableDMDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableDMDirty();
        }
        return this.enabledmDirtyFlag;
    }

    public void resetEnableDM() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableDM();
            return;
        }
        this.enabledmDirtyFlag = false;
        this.enabledm = null;
    }

    public void setEnableDynaSys(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableDynaSys(n);
            return;
        }
        this.enabledynasys = n;
        this.enabledynasysDirtyFlag = true;
    }

    public Integer getEnableDynaSys() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableDynaSys();
        }
        return this.enabledynasys;
    }

    public boolean isEnableDynaSysDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableDynaSysDirty();
        }
        return this.enabledynasysDirtyFlag;
    }

    public void resetEnableDynaSys() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableDynaSys();
            return;
        }
        this.enabledynasysDirtyFlag = false;
        this.enabledynasys = null;
    }

    public void setEnableFolderKey(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableFolderKey(n);
            return;
        }
        this.enablefolderkey = n;
        this.enablefolderkeyDirtyFlag = true;
    }

    public Integer getEnableFolderKey() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableFolderKey();
        }
        return this.enablefolderkey;
    }

    public boolean isEnableFolderKeyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableFolderKeyDirty();
        }
        return this.enablefolderkeyDirtyFlag;
    }

    public void resetEnableFolderKey() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableFolderKey();
            return;
        }
        this.enablefolderkeyDirtyFlag = false;
        this.enablefolderkey = null;
    }

    public void setEnableHANA(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableHANA(n);
            return;
        }
        this.enablehana = n;
        this.enablehanaDirtyFlag = true;
    }

    public Integer getEnableHANA() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableHANA();
        }
        return this.enablehana;
    }

    public boolean isEnableHANADirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableHANADirty();
        }
        return this.enablehanaDirtyFlag;
    }

    public void resetEnableHANA() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableHANA();
            return;
        }
        this.enablehanaDirtyFlag = false;
        this.enablehana = null;
    }

    public void setEnableHBase(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableHBase(n);
            return;
        }
        this.enablehbase = n;
        this.enablehbaseDirtyFlag = true;
    }

    public Integer getEnableHBase() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableHBase();
        }
        return this.enablehbase;
    }

    public boolean isEnableHBaseDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableHBaseDirty();
        }
        return this.enablehbaseDirtyFlag;
    }

    public void resetEnableHBase() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableHBase();
            return;
        }
        this.enablehbaseDirtyFlag = false;
        this.enablehbase = null;
    }

    public void setEnableMySQL5(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableMySQL5(n);
            return;
        }
        this.enablemysql5 = n;
        this.enablemysql5DirtyFlag = true;
    }

    public Integer getEnableMySQL5() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableMySQL5();
        }
        return this.enablemysql5;
    }

    public boolean isEnableMySQL5Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableMySQL5Dirty();
        }
        return this.enablemysql5DirtyFlag;
    }

    public void resetEnableMySQL5() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableMySQL5();
            return;
        }
        this.enablemysql5DirtyFlag = false;
        this.enablemysql5 = null;
    }

    public void setEnableOracle(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableOracle(n);
            return;
        }
        this.enableoracle = n;
        this.enableoracleDirtyFlag = true;
    }

    public Integer getEnableOracle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableOracle();
        }
        return this.enableoracle;
    }

    public boolean isEnableOracleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableOracleDirty();
        }
        return this.enableoracleDirtyFlag;
    }

    public void resetEnableOracle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableOracle();
            return;
        }
        this.enableoracleDirtyFlag = false;
        this.enableoracle = null;
    }

    public void setEnablePGSQL(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnablePGSQL(n);
            return;
        }
        this.enablepgsql = n;
        this.enablepgsqlDirtyFlag = true;
    }

    public Integer getEnablePGSQL() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnablePGSQL();
        }
        return this.enablepgsql;
    }

    public boolean isEnablePGSQLDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnablePGSQLDirty();
        }
        return this.enablepgsqlDirtyFlag;
    }

    public void resetEnablePGSQL() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnablePGSQL();
            return;
        }
        this.enablepgsqlDirtyFlag = false;
        this.enablepgsql = null;
    }

    public void setEnablePPAS(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnablePPAS(n);
            return;
        }
        this.enableppas = n;
        this.enableppasDirtyFlag = true;
    }

    public Integer getEnablePPAS() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnablePPAS();
        }
        return this.enableppas;
    }

    public boolean isEnablePPASDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnablePPASDirty();
        }
        return this.enableppasDirtyFlag;
    }

    public void resetEnablePPAS() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnablePPAS();
            return;
        }
        this.enableppasDirtyFlag = false;
        this.enableppas = null;
    }

    public void setEnableSQLite(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableSQLite(n);
            return;
        }
        this.enablesqlite = n;
        this.enablesqliteDirtyFlag = true;
    }

    public Integer getEnableSQLite() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableSQLite();
        }
        return this.enablesqlite;
    }

    public boolean isEnableSQLiteDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableSQLiteDirty();
        }
        return this.enablesqliteDirtyFlag;
    }

    public void resetEnableSQLite() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableSQLite();
            return;
        }
        this.enablesqliteDirtyFlag = false;
        this.enablesqlite = null;
    }

    public void setEnableSqlServer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableSqlServer(n);
            return;
        }
        this.enablesqlserver = n;
        this.enablesqlserverDirtyFlag = true;
    }

    public Integer getEnableSqlServer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableSqlServer();
        }
        return this.enablesqlserver;
    }

    public boolean isEnableSqlServerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableSqlServerDirty();
        }
        return this.enablesqlserverDirtyFlag;
    }

    public void resetEnableSqlServer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableSqlServer();
            return;
        }
        this.enablesqlserverDirtyFlag = false;
        this.enablesqlserver = null;
    }

    public void setEnableWSServer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableWSServer(n);
            return;
        }
        this.enablewsserver = n;
        this.enablewsserverDirtyFlag = true;
    }

    public Integer getEnableWSServer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableWSServer();
        }
        return this.enablewsserver;
    }

    public boolean isEnableWSServerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableWSServerDirty();
        }
        return this.enablewsserverDirtyFlag;
    }

    public void resetEnableWSServer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableWSServer();
            return;
        }
        this.enablewsserverDirtyFlag = false;
        this.enablewsserver = null;
    }

    public void setEntityCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEntityCnt(n);
            return;
        }
        this.entitycnt = n;
        this.entitycntDirtyFlag = true;
    }

    public Integer getEntityCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEntityCnt();
        }
        return this.entitycnt;
    }

    public boolean isEntityCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEntityCntDirty();
        }
        return this.entitycntDirtyFlag;
    }

    public void resetEntityCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEntityCnt();
            return;
        }
        this.entitycntDirtyFlag = false;
        this.entitycnt = null;
    }

    public void setExpriedTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExpriedTime(timestamp);
            return;
        }
        this.expriedtime = timestamp;
        this.expriedtimeDirtyFlag = true;
    }

    public Timestamp getExpriedTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExpriedTime();
        }
        return this.expriedtime;
    }

    public boolean isExpriedTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExpriedTimeDirty();
        }
        return this.expriedtimeDirtyFlag;
    }

    public void resetExpriedTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExpriedTime();
            return;
        }
        this.expriedtimeDirtyFlag = false;
        this.expriedtime = null;
    }

    public void setGitBranch(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGitBranch(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.gitbranch = string;
        this.gitbranchDirtyFlag = true;
    }

    public String getGitBranch() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGitBranch();
        }
        return this.gitbranch;
    }

    public boolean isGitBranchDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGitBranchDirty();
        }
        return this.gitbranchDirtyFlag;
    }

    public void resetGitBranch() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGitBranch();
            return;
        }
        this.gitbranchDirtyFlag = false;
        this.gitbranch = null;
    }

    public void setGitPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGitPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.gitpath = string;
        this.gitpathDirtyFlag = true;
    }

    public String getGitPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGitPath();
        }
        return this.gitpath;
    }

    public boolean isGitPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGitPathDirty();
        }
        return this.gitpathDirtyFlag;
    }

    public void resetGitPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGitPath();
            return;
        }
        this.gitpathDirtyFlag = false;
        this.gitpath = null;
    }

    public void setHBasePSDCBDInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHBasePSDCBDInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.hbasepsdcbdinstid = string;
        this.hbasepsdcbdinstidDirtyFlag = true;
    }

    public String getHBasePSDCBDInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHBasePSDCBDInstId();
        }
        return this.hbasepsdcbdinstid;
    }

    public boolean isHBasePSDCBDInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHBasePSDCBDInstIdDirty();
        }
        return this.hbasepsdcbdinstidDirtyFlag;
    }

    public void resetHBasePSDCBDInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHBasePSDCBDInstId();
            return;
        }
        this.hbasepsdcbdinstidDirtyFlag = false;
        this.hbasepsdcbdinstid = null;
    }

    public void setHBasePSDCBDInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHBasePSDCBDInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.hbasepsdcbdinstname = string;
        this.hbasepsdcbdinstnameDirtyFlag = true;
    }

    public String getHBasePSDCBDInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHBasePSDCBDInstName();
        }
        return this.hbasepsdcbdinstname;
    }

    public boolean isHBasePSDCBDInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHBasePSDCBDInstNameDirty();
        }
        return this.hbasepsdcbdinstnameDirtyFlag;
    }

    public void resetHBasePSDCBDInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHBasePSDCBDInstName();
            return;
        }
        this.hbasepsdcbdinstnameDirtyFlag = false;
        this.hbasepsdcbdinstname = null;
    }

    public void setInitParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInitParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.initparams = string;
        this.initparamsDirtyFlag = true;
    }

    public String getInitParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInitParams();
        }
        return this.initparams;
    }

    public boolean isInitParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInitParamsDirty();
        }
        return this.initparamsDirtyFlag;
    }

    public void resetInitParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInitParams();
            return;
        }
        this.initparamsDirtyFlag = false;
        this.initparams = null;
    }

    public void setJITPSDBDevInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setJITPSDBDevInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.jitpsdbdevinstid = string;
        this.jitpsdbdevinstidDirtyFlag = true;
    }

    public String getJITPSDBDevInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getJITPSDBDevInstId();
        }
        return this.jitpsdbdevinstid;
    }

    public boolean isJITPSDBDevInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isJITPSDBDevInstIdDirty();
        }
        return this.jitpsdbdevinstidDirtyFlag;
    }

    public void resetJITPSDBDevInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetJITPSDBDevInstId();
            return;
        }
        this.jitpsdbdevinstidDirtyFlag = false;
        this.jitpsdbdevinstid = null;
    }

    public void setJITPSDBDevInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setJITPSDBDevInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.jitpsdbdevinstname = string;
        this.jitpsdbdevinstnameDirtyFlag = true;
    }

    public String getJITPSDBDevInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getJITPSDBDevInstName();
        }
        return this.jitpsdbdevinstname;
    }

    public boolean isJITPSDBDevInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isJITPSDBDevInstNameDirty();
        }
        return this.jitpsdbdevinstnameDirtyFlag;
    }

    public void resetJITPSDBDevInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetJITPSDBDevInstName();
            return;
        }
        this.jitpsdbdevinstnameDirtyFlag = false;
        this.jitpsdbdevinstname = null;
    }

    public void setJITPSDevCenterTSId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setJITPSDevCenterTSId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.jitpsdevcentertsid = string;
        this.jitpsdevcentertsidDirtyFlag = true;
    }

    public String getJITPSDevCenterTSId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getJITPSDevCenterTSId();
        }
        return this.jitpsdevcentertsid;
    }

    public boolean isJITPSDevCenterTSIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isJITPSDevCenterTSIdDirty();
        }
        return this.jitpsdevcentertsidDirtyFlag;
    }

    public void resetJITPSDevCenterTSId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetJITPSDevCenterTSId();
            return;
        }
        this.jitpsdevcentertsidDirtyFlag = false;
        this.jitpsdevcentertsid = null;
    }

    public void setJITPSDevCenterTSName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setJITPSDevCenterTSName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.jitpsdevcentertsname = string;
        this.jitpsdevcentertsnameDirtyFlag = true;
    }

    public String getJITPSDevCenterTSName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getJITPSDevCenterTSName();
        }
        return this.jitpsdevcentertsname;
    }

    public boolean isJITPSDevCenterTSNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isJITPSDevCenterTSNameDirty();
        }
        return this.jitpsdevcentertsnameDirtyFlag;
    }

    public void resetJITPSDevCenterTSName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetJITPSDevCenterTSName();
            return;
        }
        this.jitpsdevcentertsnameDirtyFlag = false;
        this.jitpsdevcentertsname = null;
    }

    public void setLastActiveTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLastActiveTime(timestamp);
            return;
        }
        this.lastactivetime = timestamp;
        this.lastactivetimeDirtyFlag = true;
    }

    public Timestamp getLastActiveTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLastActiveTime();
        }
        return this.lastactivetime;
    }

    public boolean isLastActiveTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLastActiveTimeDirty();
        }
        return this.lastactivetimeDirtyFlag;
    }

    public void resetLastActiveTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLastActiveTime();
            return;
        }
        this.lastactivetimeDirtyFlag = false;
        this.lastactivetime = null;
    }

    public void setLoadTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLoadTime(timestamp);
            return;
        }
        this.loadtime = timestamp;
        this.loadtimeDirtyFlag = true;
    }

    public Timestamp getLoadTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLoadTime();
        }
        return this.loadtime;
    }

    public boolean isLoadTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLoadTimeDirty();
        }
        return this.loadtimeDirtyFlag;
    }

    public void resetLoadTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLoadTime();
            return;
        }
        this.loadtimeDirtyFlag = false;
        this.loadtime = null;
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

    public void setLowCodeMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLowCodeMode(n);
            return;
        }
        this.lowcodemode = n;
        this.lowcodemodeDirtyFlag = true;
    }

    public Integer getLowCodeMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLowCodeMode();
        }
        return this.lowcodemode;
    }

    public boolean isLowCodeModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLowCodeModeDirty();
        }
        return this.lowcodemodeDirtyFlag;
    }

    public void resetLowCodeMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLowCodeMode();
            return;
        }
        this.lowcodemodeDirtyFlag = false;
        this.lowcodemode = null;
    }

    public void setMainPSDevSlnSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMainPSDevSlnSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mainpsdevslnsysid = string;
        this.mainpsdevslnsysidDirtyFlag = true;
    }

    public String getMainPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMainPSDevSlnSysId();
        }
        return this.mainpsdevslnsysid;
    }

    public boolean isMainPSDevSlnSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMainPSDevSlnSysIdDirty();
        }
        return this.mainpsdevslnsysidDirtyFlag;
    }

    public void resetMainPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMainPSDevSlnSysId();
            return;
        }
        this.mainpsdevslnsysidDirtyFlag = false;
        this.mainpsdevslnsysid = null;
    }

    public void setMainPSDevSlnSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMainPSDevSlnSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mainpsdevslnsysname = string;
        this.mainpsdevslnsysnameDirtyFlag = true;
    }

    public String getMainPSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMainPSDevSlnSysName();
        }
        return this.mainpsdevslnsysname;
    }

    public boolean isMainPSDevSlnSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMainPSDevSlnSysNameDirty();
        }
        return this.mainpsdevslnsysnameDirtyFlag;
    }

    public void resetMainPSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMainPSDevSlnSysName();
            return;
        }
        this.mainpsdevslnsysnameDirtyFlag = false;
        this.mainpsdevslnsysname = null;
    }

    public void setMaxEntityCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxEntityCnt(n);
            return;
        }
        this.maxentitycnt = n;
        this.maxentitycntDirtyFlag = true;
    }

    public Integer getMaxEntityCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxEntityCnt();
        }
        return this.maxentitycnt;
    }

    public boolean isMaxEntityCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxEntityCntDirty();
        }
        return this.maxentitycntDirtyFlag;
    }

    public void resetMaxEntityCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxEntityCnt();
            return;
        }
        this.maxentitycntDirtyFlag = false;
        this.maxentitycnt = null;
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

    public void setModelGitBranch(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelGitBranch(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modelgitbranch = string;
        this.modelgitbranchDirtyFlag = true;
    }

    public String getModelGitBranch() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelGitBranch();
        }
        return this.modelgitbranch;
    }

    public boolean isModelGitBranchDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelGitBranchDirty();
        }
        return this.modelgitbranchDirtyFlag;
    }

    public void resetModelGitBranch() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelGitBranch();
            return;
        }
        this.modelgitbranchDirtyFlag = false;
        this.modelgitbranch = null;
    }

    public void setModelGitPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelGitPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modelgitpath = string;
        this.modelgitpathDirtyFlag = true;
    }

    public String getModelGitPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelGitPath();
        }
        return this.modelgitpath;
    }

    public boolean isModelGitPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelGitPathDirty();
        }
        return this.modelgitpathDirtyFlag;
    }

    public void resetModelGitPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelGitPath();
            return;
        }
        this.modelgitpathDirtyFlag = false;
        this.modelgitpath = null;
    }

    public void setModelInstVer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelInstVer(n);
            return;
        }
        this.modelinstver = n;
        this.modelinstverDirtyFlag = true;
    }

    public Integer getModelInstVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelInstVer();
        }
        return this.modelinstver;
    }

    public boolean isModelInstVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelInstVerDirty();
        }
        return this.modelinstverDirtyFlag;
    }

    public void resetModelInstVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelInstVer();
            return;
        }
        this.modelinstverDirtyFlag = false;
        this.modelinstver = null;
    }

    public void setModelPrefix(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelPrefix(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modelprefix = string;
        this.modelprefixDirtyFlag = true;
    }

    public String getModelPrefix() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelPrefix();
        }
        return this.modelprefix;
    }

    public boolean isModelPrefixDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelPrefixDirty();
        }
        return this.modelprefixDirtyFlag;
    }

    public void resetModelPrefix() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelPrefix();
            return;
        }
        this.modelprefixDirtyFlag = false;
        this.modelprefix = null;
    }

    public void setModelPSDevCenterSVNId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelPSDevCenterSVNId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modelpsdevcentersvnid = string;
        this.modelpsdevcentersvnidDirtyFlag = true;
    }

    public String getModelPSDevCenterSVNId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelPSDevCenterSVNId();
        }
        return this.modelpsdevcentersvnid;
    }

    public boolean isModelPSDevCenterSVNIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelPSDevCenterSVNIdDirty();
        }
        return this.modelpsdevcentersvnidDirtyFlag;
    }

    public void resetModelPSDevCenterSVNId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelPSDevCenterSVNId();
            return;
        }
        this.modelpsdevcentersvnidDirtyFlag = false;
        this.modelpsdevcentersvnid = null;
    }

    public void setModelPSDevCenterSVNName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelPSDevCenterSVNName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modelpsdevcentersvnname = string;
        this.modelpsdevcentersvnnameDirtyFlag = true;
    }

    public String getModelPSDevCenterSVNName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelPSDevCenterSVNName();
        }
        return this.modelpsdevcentersvnname;
    }

    public boolean isModelPSDevCenterSVNNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelPSDevCenterSVNNameDirty();
        }
        return this.modelpsdevcentersvnnameDirtyFlag;
    }

    public void resetModelPSDevCenterSVNName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelPSDevCenterSVNName();
            return;
        }
        this.modelpsdevcentersvnnameDirtyFlag = false;
        this.modelpsdevcentersvnname = null;
    }

    public void setMSSQLPSDCDBInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMSSQLPSDCDBInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mssqlpsdcdbinstid = string;
        this.mssqlpsdcdbinstidDirtyFlag = true;
    }

    public String getMSSQLPSDCDBInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMSSQLPSDCDBInstId();
        }
        return this.mssqlpsdcdbinstid;
    }

    public boolean isMSSQLPSDCDBInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMSSQLPSDCDBInstIdDirty();
        }
        return this.mssqlpsdcdbinstidDirtyFlag;
    }

    public void resetMSSQLPSDCDBInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMSSQLPSDCDBInstId();
            return;
        }
        this.mssqlpsdcdbinstidDirtyFlag = false;
        this.mssqlpsdcdbinstid = null;
    }

    public void setMSSQLPSDCDBInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMSSQLPSDCDBInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mssqlpsdcdbinstname = string;
        this.mssqlpsdcdbinstnameDirtyFlag = true;
    }

    public String getMSSQLPSDCDBInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMSSQLPSDCDBInstName();
        }
        return this.mssqlpsdcdbinstname;
    }

    public boolean isMSSQLPSDCDBInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMSSQLPSDCDBInstNameDirty();
        }
        return this.mssqlpsdcdbinstnameDirtyFlag;
    }

    public void resetMSSQLPSDCDBInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMSSQLPSDCDBInstName();
            return;
        }
        this.mssqlpsdcdbinstnameDirtyFlag = false;
        this.mssqlpsdcdbinstname = null;
    }

    public void setMySQLPSDCDBInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMySQLPSDCDBInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mysqlpsdcdbinstid = string;
        this.mysqlpsdcdbinstidDirtyFlag = true;
    }

    public String getMySQLPSDCDBInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMySQLPSDCDBInstId();
        }
        return this.mysqlpsdcdbinstid;
    }

    public boolean isMySQLPSDCDBInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMySQLPSDCDBInstIdDirty();
        }
        return this.mysqlpsdcdbinstidDirtyFlag;
    }

    public void resetMySQLPSDCDBInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMySQLPSDCDBInstId();
            return;
        }
        this.mysqlpsdcdbinstidDirtyFlag = false;
        this.mysqlpsdcdbinstid = null;
    }

    public void setMySQLPSDCDBInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMySQLPSDCDBInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mysqlpsdcdbinstname = string;
        this.mysqlpsdcdbinstnameDirtyFlag = true;
    }

    public String getMySQLPSDCDBInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMySQLPSDCDBInstName();
        }
        return this.mysqlpsdcdbinstname;
    }

    public boolean isMySQLPSDCDBInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMySQLPSDCDBInstNameDirty();
        }
        return this.mysqlpsdcdbinstnameDirtyFlag;
    }

    public void resetMySQLPSDCDBInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMySQLPSDCDBInstName();
            return;
        }
        this.mysqlpsdcdbinstnameDirtyFlag = false;
        this.mysqlpsdcdbinstname = null;
    }

    public void setOfflineTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOfflineTime(timestamp);
            return;
        }
        this.offlinetime = timestamp;
        this.offlinetimeDirtyFlag = true;
    }

    public Timestamp getOfflineTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOfflineTime();
        }
        return this.offlinetime;
    }

    public boolean isOfflineTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOfflineTimeDirty();
        }
        return this.offlinetimeDirtyFlag;
    }

    public void resetOfflineTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOfflineTime();
            return;
        }
        this.offlinetimeDirtyFlag = false;
        this.offlinetime = null;
    }

    public void setOraPSDCDBInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOraPSDCDBInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.orapsdcdbinstid = string;
        this.orapsdcdbinstidDirtyFlag = true;
    }

    public String getOraPSDCDBInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOraPSDCDBInstId();
        }
        return this.orapsdcdbinstid;
    }

    public boolean isOraPSDCDBInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOraPSDCDBInstIdDirty();
        }
        return this.orapsdcdbinstidDirtyFlag;
    }

    public void resetOraPSDCDBInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOraPSDCDBInstId();
            return;
        }
        this.orapsdcdbinstidDirtyFlag = false;
        this.orapsdcdbinstid = null;
    }

    public void setOraPSDCDBInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOraPSDCDBInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.orapsdcdbinstname = string;
        this.orapsdcdbinstnameDirtyFlag = true;
    }

    public String getOraPSDCDBInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOraPSDCDBInstName();
        }
        return this.orapsdcdbinstname;
    }

    public boolean isOraPSDCDBInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOraPSDCDBInstNameDirty();
        }
        return this.orapsdcdbinstnameDirtyFlag;
    }

    public void resetOraPSDCDBInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOraPSDCDBInstName();
            return;
        }
        this.orapsdcdbinstnameDirtyFlag = false;
        this.orapsdcdbinstname = null;
    }

    public void setPGSQLPSDCDBInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPGSQLPSDCDBInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pgsqlpsdcdbinstid = string;
        this.pgsqlpsdcdbinstidDirtyFlag = true;
    }

    public String getPGSQLPSDCDBInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPGSQLPSDCDBInstId();
        }
        return this.pgsqlpsdcdbinstid;
    }

    public boolean isPGSQLPSDCDBInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPGSQLPSDCDBInstIdDirty();
        }
        return this.pgsqlpsdcdbinstidDirtyFlag;
    }

    public void resetPGSQLPSDCDBInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPGSQLPSDCDBInstId();
            return;
        }
        this.pgsqlpsdcdbinstidDirtyFlag = false;
        this.pgsqlpsdcdbinstid = null;
    }

    public void setPGSQLPSDCDBInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPGSQLPSDCDBInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pgsqlpsdcdbinstname = string;
        this.pgsqlpsdcdbinstnameDirtyFlag = true;
    }

    public String getPGSQLPSDCDBInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPGSQLPSDCDBInstName();
        }
        return this.pgsqlpsdcdbinstname;
    }

    public boolean isPGSQLPSDCDBInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPGSQLPSDCDBInstNameDirty();
        }
        return this.pgsqlpsdcdbinstnameDirtyFlag;
    }

    public void resetPGSQLPSDCDBInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPGSQLPSDCDBInstName();
            return;
        }
        this.pgsqlpsdcdbinstnameDirtyFlag = false;
        this.pgsqlpsdcdbinstname = null;
    }

    public void setPPASPSDCDBInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPASPSDCDBInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppaspsdcdbinstid = string;
        this.ppaspsdcdbinstidDirtyFlag = true;
    }

    public String getPPASPSDCDBInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPASPSDCDBInstId();
        }
        return this.ppaspsdcdbinstid;
    }

    public boolean isPPASPSDCDBInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPASPSDCDBInstIdDirty();
        }
        return this.ppaspsdcdbinstidDirtyFlag;
    }

    public void resetPPASPSDCDBInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPASPSDCDBInstId();
            return;
        }
        this.ppaspsdcdbinstidDirtyFlag = false;
        this.ppaspsdcdbinstid = null;
    }

    public void setPPASPSDCDBInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPASPSDCDBInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppaspsdcdbinstname = string;
        this.ppaspsdcdbinstnameDirtyFlag = true;
    }

    public String getPPASPSDCDBInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPASPSDCDBInstName();
        }
        return this.ppaspsdcdbinstname;
    }

    public boolean isPPASPSDCDBInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPASPSDCDBInstNameDirty();
        }
        return this.ppaspsdcdbinstnameDirtyFlag;
    }

    public void resetPPASPSDCDBInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPASPSDCDBInstName();
            return;
        }
        this.ppaspsdcdbinstnameDirtyFlag = false;
        this.ppaspsdcdbinstname = null;
    }

    public void setPPSDevSlnSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSDevSlnSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsdevslnsysid = string;
        this.ppsdevslnsysidDirtyFlag = true;
    }

    public String getPPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDevSlnSysId();
        }
        return this.ppsdevslnsysid;
    }

    public boolean isPPSDevSlnSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSDevSlnSysIdDirty();
        }
        return this.ppsdevslnsysidDirtyFlag;
    }

    public void resetPPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSDevSlnSysId();
            return;
        }
        this.ppsdevslnsysidDirtyFlag = false;
        this.ppsdevslnsysid = null;
    }

    public void setPPSDevSlnSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSDevSlnSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsdevslnsysname = string;
        this.ppsdevslnsysnameDirtyFlag = true;
    }

    public String getPPSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDevSlnSysName();
        }
        return this.ppsdevslnsysname;
    }

    public boolean isPPSDevSlnSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSDevSlnSysNameDirty();
        }
        return this.ppsdevslnsysnameDirtyFlag;
    }

    public void resetPPSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSDevSlnSysName();
            return;
        }
        this.ppsdevslnsysnameDirtyFlag = false;
        this.ppsdevslnsysname = null;
    }

    public void setPSDCDeployCenterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCDeployCenterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcdeploycenterid = string;
        this.psdcdeploycenteridDirtyFlag = true;
    }

    public String getPSDCDeployCenterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCDeployCenterId();
        }
        return this.psdcdeploycenterid;
    }

    public boolean isPSDCDeployCenterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCDeployCenterIdDirty();
        }
        return this.psdcdeploycenteridDirtyFlag;
    }

    public void resetPSDCDeployCenterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCDeployCenterId();
            return;
        }
        this.psdcdeploycenteridDirtyFlag = false;
        this.psdcdeploycenterid = null;
    }

    public void setPSDCDeployCenterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCDeployCenterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcdeploycentername = string;
        this.psdcdeploycenternameDirtyFlag = true;
    }

    public String getPSDCDeployCenterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCDeployCenterName();
        }
        return this.psdcdeploycentername;
    }

    public boolean isPSDCDeployCenterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCDeployCenterNameDirty();
        }
        return this.psdcdeploycenternameDirtyFlag;
    }

    public void resetPSDCDeployCenterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCDeployCenterName();
            return;
        }
        this.psdcdeploycenternameDirtyFlag = false;
        this.psdcdeploycentername = null;
    }

    public void setPSDCModelTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCModelTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcmodeltemplid = string;
        this.psdcmodeltemplidDirtyFlag = true;
    }

    public String getPSDCModelTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCModelTemplId();
        }
        return this.psdcmodeltemplid;
    }

    public boolean isPSDCModelTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCModelTemplIdDirty();
        }
        return this.psdcmodeltemplidDirtyFlag;
    }

    public void resetPSDCModelTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCModelTemplId();
            return;
        }
        this.psdcmodeltemplidDirtyFlag = false;
        this.psdcmodeltemplid = null;
    }

    public void setPSDCModelTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCModelTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcmodeltemplname = string;
        this.psdcmodeltemplnameDirtyFlag = true;
    }

    public String getPSDCModelTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCModelTemplName();
        }
        return this.psdcmodeltemplname;
    }

    public boolean isPSDCModelTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCModelTemplNameDirty();
        }
        return this.psdcmodeltemplnameDirtyFlag;
    }

    public void resetPSDCModelTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCModelTemplName();
            return;
        }
        this.psdcmodeltemplnameDirtyFlag = false;
        this.psdcmodeltemplname = null;
    }

    public void setPSDCRobotId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCRobotId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcrobotid = string;
        this.psdcrobotidDirtyFlag = true;
    }

    public String getPSDCRobotId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCRobotId();
        }
        return this.psdcrobotid;
    }

    public boolean isPSDCRobotIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCRobotIdDirty();
        }
        return this.psdcrobotidDirtyFlag;
    }

    public void resetPSDCRobotId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCRobotId();
            return;
        }
        this.psdcrobotidDirtyFlag = false;
        this.psdcrobotid = null;
    }

    public void setPSDCRobotName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCRobotName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcrobotname = string;
        this.psdcrobotnameDirtyFlag = true;
    }

    public String getPSDCRobotName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCRobotName();
        }
        return this.psdcrobotname;
    }

    public boolean isPSDCRobotNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCRobotNameDirty();
        }
        return this.psdcrobotnameDirtyFlag;
    }

    public void resetPSDCRobotName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCRobotName();
            return;
        }
        this.psdcrobotnameDirtyFlag = false;
        this.psdcrobotname = null;
    }

    public void setPSDCSysLicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCSysLicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcsyslicid = string;
        this.psdcsyslicidDirtyFlag = true;
    }

    public String getPSDCSysLicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCSysLicId();
        }
        return this.psdcsyslicid;
    }

    public boolean isPSDCSysLicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCSysLicIdDirty();
        }
        return this.psdcsyslicidDirtyFlag;
    }

    public void resetPSDCSysLicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCSysLicId();
            return;
        }
        this.psdcsyslicidDirtyFlag = false;
        this.psdcsyslicid = null;
    }

    public void setPSDCSysLicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCSysLicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcsyslicname = string;
        this.psdcsyslicnameDirtyFlag = true;
    }

    public String getPSDCSysLicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCSysLicName();
        }
        return this.psdcsyslicname;
    }

    public boolean isPSDCSysLicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCSysLicNameDirty();
        }
        return this.psdcsyslicnameDirtyFlag;
    }

    public void resetPSDCSysLicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCSysLicName();
            return;
        }
        this.psdcsyslicnameDirtyFlag = false;
        this.psdcsyslicname = null;
    }

    public void setPSDCWorkspaceId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCWorkspaceId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcworkspaceid = string;
        this.psdcworkspaceidDirtyFlag = true;
    }

    public String getPSDCWorkspaceId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCWorkspaceId();
        }
        return this.psdcworkspaceid;
    }

    public boolean isPSDCWorkspaceIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCWorkspaceIdDirty();
        }
        return this.psdcworkspaceidDirtyFlag;
    }

    public void resetPSDCWorkspaceId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCWorkspaceId();
            return;
        }
        this.psdcworkspaceidDirtyFlag = false;
        this.psdcworkspaceid = null;
    }

    public void setPSDevCenterASId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterASId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterasid = string;
        this.psdevcenterasidDirtyFlag = true;
    }

    public String getPSDevCenterASId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterASId();
        }
        return this.psdevcenterasid;
    }

    public boolean isPSDevCenterASIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterASIdDirty();
        }
        return this.psdevcenterasidDirtyFlag;
    }

    public void resetPSDevCenterASId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterASId();
            return;
        }
        this.psdevcenterasidDirtyFlag = false;
        this.psdevcenterasid = null;
    }

    public void setPSDevCenterASId2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterASId2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterasid2 = string;
        this.psdevcenterasid2DirtyFlag = true;
    }

    public String getPSDevCenterASId2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterASId2();
        }
        return this.psdevcenterasid2;
    }

    public boolean isPSDevCenterASId2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterASId2Dirty();
        }
        return this.psdevcenterasid2DirtyFlag;
    }

    public void resetPSDevCenterASId2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterASId2();
            return;
        }
        this.psdevcenterasid2DirtyFlag = false;
        this.psdevcenterasid2 = null;
    }

    public void setPSDevCenterAS3Id(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterAS3Id(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenteras3id = string;
        this.psdevcenteras3idDirtyFlag = true;
    }

    public String getPSDevCenterAS3Id() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterAS3Id();
        }
        return this.psdevcenteras3id;
    }

    public boolean isPSDevCenterAS3IdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterAS3IdDirty();
        }
        return this.psdevcenteras3idDirtyFlag;
    }

    public void resetPSDevCenterAS3Id() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterAS3Id();
            return;
        }
        this.psdevcenteras3idDirtyFlag = false;
        this.psdevcenteras3id = null;
    }

    public void setPSDevCenterAS4Id(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterAS4Id(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenteras4id = string;
        this.psdevcenteras4idDirtyFlag = true;
    }

    public String getPSDevCenterAS4Id() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterAS4Id();
        }
        return this.psdevcenteras4id;
    }

    public boolean isPSDevCenterAS4IdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterAS4IdDirty();
        }
        return this.psdevcenteras4idDirtyFlag;
    }

    public void resetPSDevCenterAS4Id() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterAS4Id();
            return;
        }
        this.psdevcenteras4idDirtyFlag = false;
        this.psdevcenteras4id = null;
    }

    public void setPSDevCenterASName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterASName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterasname = string;
        this.psdevcenterasnameDirtyFlag = true;
    }

    public String getPSDevCenterASName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterASName();
        }
        return this.psdevcenterasname;
    }

    public boolean isPSDevCenterASNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterASNameDirty();
        }
        return this.psdevcenterasnameDirtyFlag;
    }

    public void resetPSDevCenterASName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterASName();
            return;
        }
        this.psdevcenterasnameDirtyFlag = false;
        this.psdevcenterasname = null;
    }

    public void setPSDevCenterASName2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterASName2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterasname2 = string;
        this.psdevcenterasname2DirtyFlag = true;
    }

    public String getPSDevCenterASName2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterASName2();
        }
        return this.psdevcenterasname2;
    }

    public boolean isPSDevCenterASName2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterASName2Dirty();
        }
        return this.psdevcenterasname2DirtyFlag;
    }

    public void resetPSDevCenterASName2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterASName2();
            return;
        }
        this.psdevcenterasname2DirtyFlag = false;
        this.psdevcenterasname2 = null;
    }

    public void setPSDevCenterAS3Name(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterAS3Name(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenteras3name = string;
        this.psdevcenteras3nameDirtyFlag = true;
    }

    public String getPSDevCenterAS3Name() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterAS3Name();
        }
        return this.psdevcenteras3name;
    }

    public boolean isPSDevCenterAS3NameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterAS3NameDirty();
        }
        return this.psdevcenteras3nameDirtyFlag;
    }

    public void resetPSDevCenterAS3Name() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterAS3Name();
            return;
        }
        this.psdevcenteras3nameDirtyFlag = false;
        this.psdevcenteras3name = null;
    }

    public void setPSDevCenterAS4Name(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterAS4Name(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenteras4name = string;
        this.psdevcenteras4nameDirtyFlag = true;
    }

    public String getPSDevCenterAS4Name() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterAS4Name();
        }
        return this.psdevcenteras4name;
    }

    public boolean isPSDevCenterAS4NameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterAS4NameDirty();
        }
        return this.psdevcenteras4nameDirtyFlag;
    }

    public void resetPSDevCenterAS4Name() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterAS4Name();
            return;
        }
        this.psdevcenteras4nameDirtyFlag = false;
        this.psdevcenteras4name = null;
    }

    public void setPSDevCenterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterid = string;
        this.psdevcenteridDirtyFlag = true;
    }

    public String getPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterId();
        }
        return this.psdevcenterid;
    }

    public boolean isPSDevCenterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterIdDirty();
        }
        return this.psdevcenteridDirtyFlag;
    }

    public void resetPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterId();
            return;
        }
        this.psdevcenteridDirtyFlag = false;
        this.psdevcenterid = null;
    }

    public void setPSDevCenterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentername = string;
        this.psdevcenternameDirtyFlag = true;
    }

    public String getPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterName();
        }
        return this.psdevcentername;
    }

    public boolean isPSDevCenterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterNameDirty();
        }
        return this.psdevcenternameDirtyFlag;
    }

    public void resetPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterName();
            return;
        }
        this.psdevcenternameDirtyFlag = false;
        this.psdevcentername = null;
    }

    public void setPSDevCenterSVNId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterSVNId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentersvnid = string;
        this.psdevcentersvnidDirtyFlag = true;
    }

    public String getPSDevCenterSVNId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterSVNId();
        }
        return this.psdevcentersvnid;
    }

    public boolean isPSDevCenterSVNIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterSVNIdDirty();
        }
        return this.psdevcentersvnidDirtyFlag;
    }

    public void resetPSDevCenterSVNId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterSVNId();
            return;
        }
        this.psdevcentersvnidDirtyFlag = false;
        this.psdevcentersvnid = null;
    }

    public void setPSDevCenterSVNName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterSVNName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentersvnname = string;
        this.psdevcentersvnnameDirtyFlag = true;
    }

    public String getPSDevCenterSVNName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterSVNName();
        }
        return this.psdevcentersvnname;
    }

    public boolean isPSDevCenterSVNNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterSVNNameDirty();
        }
        return this.psdevcentersvnnameDirtyFlag;
    }

    public void resetPSDevCenterSVNName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterSVNName();
            return;
        }
        this.psdevcentersvnnameDirtyFlag = false;
        this.psdevcentersvnname = null;
    }

    public void setPSDevCenterTSId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterTSId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentertsid = string;
        this.psdevcentertsidDirtyFlag = true;
    }

    public String getPSDevCenterTSId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterTSId();
        }
        return this.psdevcentertsid;
    }

    public boolean isPSDevCenterTSIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterTSIdDirty();
        }
        return this.psdevcentertsidDirtyFlag;
    }

    public void resetPSDevCenterTSId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterTSId();
            return;
        }
        this.psdevcentertsidDirtyFlag = false;
        this.psdevcentertsid = null;
    }

    public void setPSDevCenterTSName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterTSName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentertsname = string;
        this.psdevcentertsnameDirtyFlag = true;
    }

    public String getPSDevCenterTSName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterTSName();
        }
        return this.psdevcentertsname;
    }

    public boolean isPSDevCenterTSNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterTSNameDirty();
        }
        return this.psdevcentertsnameDirtyFlag;
    }

    public void resetPSDevCenterTSName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterTSName();
            return;
        }
        this.psdevcentertsnameDirtyFlag = false;
        this.psdevcentertsname = null;
    }

    public void setPSDevSlnId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnid = string;
        this.psdevslnidDirtyFlag = true;
    }

    public String getPSDevSlnId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnId();
        }
        return this.psdevslnid;
    }

    public boolean isPSDevSlnIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnIdDirty();
        }
        return this.psdevslnidDirtyFlag;
    }

    public void resetPSDevSlnId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnId();
            return;
        }
        this.psdevslnidDirtyFlag = false;
        this.psdevslnid = null;
    }

    public void setPSDevSlnName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnname = string;
        this.psdevslnnameDirtyFlag = true;
    }

    public String getPSDevSlnName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnName();
        }
        return this.psdevslnname;
    }

    public boolean isPSDevSlnNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnNameDirty();
        }
        return this.psdevslnnameDirtyFlag;
    }

    public void resetPSDevSlnName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnName();
            return;
        }
        this.psdevslnnameDirtyFlag = false;
        this.psdevslnname = null;
    }

    public void setPSDevSlnSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysid = string;
        this.psdevslnsysidDirtyFlag = true;
    }

    public String getPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysId();
        }
        return this.psdevslnsysid;
    }

    public boolean isPSDevSlnSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysIdDirty();
        }
        return this.psdevslnsysidDirtyFlag;
    }

    public void resetPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysId();
            return;
        }
        this.psdevslnsysidDirtyFlag = false;
        this.psdevslnsysid = null;
    }

    public void setPSDevSlnSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysname = string;
        this.psdevslnsysnameDirtyFlag = true;
    }

    public String getPSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysName();
        }
        return this.psdevslnsysname;
    }

    public boolean isPSDevSlnSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysNameDirty();
        }
        return this.psdevslnsysnameDirtyFlag;
    }

    public void resetPSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysName();
            return;
        }
        this.psdevslnsysnameDirtyFlag = false;
        this.psdevslnsysname = null;
    }

    public void setPSDevSlnSysResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysresid = string;
        this.psdevslnsysresidDirtyFlag = true;
    }

    public String getPSDevSlnSysResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysResId();
        }
        return this.psdevslnsysresid;
    }

    public boolean isPSDevSlnSysResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysResIdDirty();
        }
        return this.psdevslnsysresidDirtyFlag;
    }

    public void resetPSDevSlnSysResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysResId();
            return;
        }
        this.psdevslnsysresidDirtyFlag = false;
        this.psdevslnsysresid = null;
    }

    public void setPSDevSlnSysResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysresname = string;
        this.psdevslnsysresnameDirtyFlag = true;
    }

    public String getPSDevSlnSysResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysResName();
        }
        return this.psdevslnsysresname;
    }

    public boolean isPSDevSlnSysResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysResNameDirty();
        }
        return this.psdevslnsysresnameDirtyFlag;
    }

    public void resetPSDevSlnSysResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysResName();
            return;
        }
        this.psdevslnsysresnameDirtyFlag = false;
        this.psdevslnsysresname = null;
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

    public void setPSStudioThemeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSStudioThemeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psstudiothemeid = string;
        this.psstudiothemeidDirtyFlag = true;
    }

    public String getPSStudioThemeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSStudioThemeId();
        }
        return this.psstudiothemeid;
    }

    public boolean isPSStudioThemeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSStudioThemeIdDirty();
        }
        return this.psstudiothemeidDirtyFlag;
    }

    public void resetPSStudioThemeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSStudioThemeId();
            return;
        }
        this.psstudiothemeidDirtyFlag = false;
        this.psstudiothemeid = null;
    }

    public void setPSStudioThemeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSStudioThemeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psstudiothemename = string;
        this.psstudiothemenameDirtyFlag = true;
    }

    public String getPSStudioThemeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSStudioThemeName();
        }
        return this.psstudiothemename;
    }

    public boolean isPSStudioThemeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSStudioThemeNameDirty();
        }
        return this.psstudiothemenameDirtyFlag;
    }

    public void resetPSStudioThemeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSStudioThemeName();
            return;
        }
        this.psstudiothemenameDirtyFlag = false;
        this.psstudiothemename = null;
    }

    public void setPSSysModelInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelinstid = string;
        this.pssysmodelinstidDirtyFlag = true;
    }

    public String getPSSysModelInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelInstId();
        }
        return this.pssysmodelinstid;
    }

    public boolean isPSSysModelInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelInstIdDirty();
        }
        return this.pssysmodelinstidDirtyFlag;
    }

    public void resetPSSysModelInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelInstId();
            return;
        }
        this.pssysmodelinstidDirtyFlag = false;
        this.pssysmodelinstid = null;
    }

    public void setPSSysModelInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelinstname = string;
        this.pssysmodelinstnameDirtyFlag = true;
    }

    public String getPSSysModelInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelInstName();
        }
        return this.pssysmodelinstname;
    }

    public boolean isPSSysModelInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelInstNameDirty();
        }
        return this.pssysmodelinstnameDirtyFlag;
    }

    public void resetPSSysModelInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelInstName();
            return;
        }
        this.pssysmodelinstnameDirtyFlag = false;
        this.pssysmodelinstname = null;
    }

    public void setPSSysPolicyId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPolicyId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyspolicyid = string;
        this.pssyspolicyidDirtyFlag = true;
    }

    public String getPSSysPolicyId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPolicyId();
        }
        return this.pssyspolicyid;
    }

    public boolean isPSSysPolicyIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPolicyIdDirty();
        }
        return this.pssyspolicyidDirtyFlag;
    }

    public void resetPSSysPolicyId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPolicyId();
            return;
        }
        this.pssyspolicyidDirtyFlag = false;
        this.pssyspolicyid = null;
    }

    public void setPSSysPolicyName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPolicyName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyspolicyname = string;
        this.pssyspolicynameDirtyFlag = true;
    }

    public String getPSSysPolicyName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPolicyName();
        }
        return this.pssyspolicyname;
    }

    public boolean isPSSysPolicyNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPolicyNameDirty();
        }
        return this.pssyspolicynameDirtyFlag;
    }

    public void resetPSSysPolicyName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPolicyName();
            return;
        }
        this.pssyspolicynameDirtyFlag = false;
        this.pssyspolicyname = null;
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

    public void setPSTaskServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSTaskServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pstaskserverid = string;
        this.pstaskserveridDirtyFlag = true;
    }

    public String getPSTaskServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSTaskServerId();
        }
        return this.pstaskserverid;
    }

    public boolean isPSTaskServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSTaskServerIdDirty();
        }
        return this.pstaskserveridDirtyFlag;
    }

    public void resetPSTaskServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSTaskServerId();
            return;
        }
        this.pstaskserveridDirtyFlag = false;
        this.pstaskserverid = null;
    }

    public void setPSTaskServerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSTaskServerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pstaskservername = string;
        this.pstaskservernameDirtyFlag = true;
    }

    public String getPSTaskServerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSTaskServerName();
        }
        return this.pstaskservername;
    }

    public boolean isPSTaskServerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSTaskServerNameDirty();
        }
        return this.pstaskservernameDirtyFlag;
    }

    public void resetPSTaskServerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSTaskServerName();
            return;
        }
        this.pstaskservernameDirtyFlag = false;
        this.pstaskservername = null;
    }

    public void setPubCode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPubCode(n);
            return;
        }
        this.pubcode = n;
        this.pubcodeDirtyFlag = true;
    }

    public Integer getPubCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPubCode();
        }
        return this.pubcode;
    }

    public boolean isPubCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPubCodeDirty();
        }
        return this.pubcodeDirtyFlag;
    }

    public void resetPubCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPubCode();
            return;
        }
        this.pubcodeDirtyFlag = false;
        this.pubcode = null;
    }

    public void setResReadyTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResReadyTime(timestamp);
            return;
        }
        this.resreadytime = timestamp;
        this.resreadytimeDirtyFlag = true;
    }

    public Timestamp getResReadyTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResReadyTime();
        }
        return this.resreadytime;
    }

    public boolean isResReadyTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResReadyTimeDirty();
        }
        return this.resreadytimeDirtyFlag;
    }

    public void resetResReadyTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResReadyTime();
            return;
        }
        this.resreadytimeDirtyFlag = false;
        this.resreadytime = null;
    }

    public void setROGitBranch(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setROGitBranch(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rogitbranch = string;
        this.rogitbranchDirtyFlag = true;
    }

    public String getROGitBranch() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getROGitBranch();
        }
        return this.rogitbranch;
    }

    public boolean isROGitBranchDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isROGitBranchDirty();
        }
        return this.rogitbranchDirtyFlag;
    }

    public void resetROGitBranch() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetROGitBranch();
            return;
        }
        this.rogitbranchDirtyFlag = false;
        this.rogitbranch = null;
    }

    public void setROGitPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setROGitPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rogitpath = string;
        this.rogitpathDirtyFlag = true;
    }

    public String getROGitPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getROGitPath();
        }
        return this.rogitpath;
    }

    public boolean isROGitPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isROGitPathDirty();
        }
        return this.rogitpathDirtyFlag;
    }

    public void resetROGitPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetROGitPath();
            return;
        }
        this.rogitpathDirtyFlag = false;
        this.rogitpath = null;
    }

    public void setROPSDevCenterSvnId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setROPSDevCenterSvnId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ropsdevcentersvnid = string;
        this.ropsdevcentersvnidDirtyFlag = true;
    }

    public String getROPSDevCenterSvnId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getROPSDevCenterSvnId();
        }
        return this.ropsdevcentersvnid;
    }

    public boolean isROPSDevCenterSvnIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isROPSDevCenterSvnIdDirty();
        }
        return this.ropsdevcentersvnidDirtyFlag;
    }

    public void resetROPSDevCenterSvnId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetROPSDevCenterSvnId();
            return;
        }
        this.ropsdevcentersvnidDirtyFlag = false;
        this.ropsdevcentersvnid = null;
    }

    public void setROPSDevCenterSvnName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setROPSDevCenterSvnName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ropsdevcentersvnname = string;
        this.ropsdevcentersvnnameDirtyFlag = true;
    }

    public String getROPSDevCenterSvnName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getROPSDevCenterSvnName();
        }
        return this.ropsdevcentersvnname;
    }

    public boolean isROPSDevCenterSvnNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isROPSDevCenterSvnNameDirty();
        }
        return this.ropsdevcentersvnnameDirtyFlag;
    }

    public void resetROPSDevCenterSvnName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetROPSDevCenterSvnName();
            return;
        }
        this.ropsdevcentersvnnameDirtyFlag = false;
        this.ropsdevcentersvnname = null;
    }

    public void setRTModelPSDevCenterSVNId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRTModelPSDevCenterSVNId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rtmodelpsdevcentersvnid = string;
        this.rtmodelpsdevcentersvnidDirtyFlag = true;
    }

    public String getRTModelPSDevCenterSVNId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRTModelPSDevCenterSVNId();
        }
        return this.rtmodelpsdevcentersvnid;
    }

    public boolean isRTModelPSDevCenterSVNIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRTModelPSDevCenterSVNIdDirty();
        }
        return this.rtmodelpsdevcentersvnidDirtyFlag;
    }

    public void resetRTModelPSDevCenterSVNId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRTModelPSDevCenterSVNId();
            return;
        }
        this.rtmodelpsdevcentersvnidDirtyFlag = false;
        this.rtmodelpsdevcentersvnid = null;
    }

    public void setRTModelPSDevCenterSVNName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRTModelPSDevCenterSVNName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rtmodelpsdevcentersvnname = string;
        this.rtmodelpsdevcentersvnnameDirtyFlag = true;
    }

    public String getRTModelPSDevCenterSVNName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRTModelPSDevCenterSVNName();
        }
        return this.rtmodelpsdevcentersvnname;
    }

    public boolean isRTModelPSDevCenterSVNNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRTModelPSDevCenterSVNNameDirty();
        }
        return this.rtmodelpsdevcentersvnnameDirtyFlag;
    }

    public void resetRTModelPSDevCenterSVNName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRTModelPSDevCenterSVNName();
            return;
        }
        this.rtmodelpsdevcentersvnnameDirtyFlag = false;
        this.rtmodelpsdevcentersvnname = null;
    }

    public void setSaaSMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSaaSMode(n);
            return;
        }
        this.saasmode = n;
        this.saasmodeDirtyFlag = true;
    }

    public Integer getSaaSMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSaaSMode();
        }
        return this.saasmode;
    }

    public boolean isSaaSModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSaaSModeDirty();
        }
        return this.saasmodeDirtyFlag;
    }

    public void resetSaaSMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSaaSMode();
            return;
        }
        this.saasmodeDirtyFlag = false;
        this.saasmode = null;
    }

    public void setSFPSSubSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSFPSSubSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sfpssubsysid = string;
        this.sfpssubsysidDirtyFlag = true;
    }

    public String getSFPSSubSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSFPSSubSysId();
        }
        return this.sfpssubsysid;
    }

    public boolean isSFPSSubSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSFPSSubSysIdDirty();
        }
        return this.sfpssubsysidDirtyFlag;
    }

    public void resetSFPSSubSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSFPSSubSysId();
            return;
        }
        this.sfpssubsysidDirtyFlag = false;
        this.sfpssubsysid = null;
    }

    public void setSFPSSubSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSFPSSubSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sfpssubsysname = string;
        this.sfpssubsysnameDirtyFlag = true;
    }

    public String getSFPSSubSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSFPSSubSysName();
        }
        return this.sfpssubsysname;
    }

    public boolean isSFPSSubSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSFPSSubSysNameDirty();
        }
        return this.sfpssubsysnameDirtyFlag;
    }

    public void resetSFPSSubSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSFPSSubSysName();
            return;
        }
        this.sfpssubsysnameDirtyFlag = false;
        this.sfpssubsysname = null;
    }

    public void setShareFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setShareFlag(n);
            return;
        }
        this.shareflag = n;
        this.shareflagDirtyFlag = true;
    }

    public Integer getShareFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getShareFlag();
        }
        return this.shareflag;
    }

    public boolean isShareFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isShareFlagDirty();
        }
        return this.shareflagDirtyFlag;
    }

    public void resetShareFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetShareFlag();
            return;
        }
        this.shareflagDirtyFlag = false;
        this.shareflag = null;
    }

    public void setStudioTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStudioTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.studiotag = string;
        this.studiotagDirtyFlag = true;
    }

    public String getStudioTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStudioTag();
        }
        return this.studiotag;
    }

    public boolean isStudioTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStudioTagDirty();
        }
        return this.studiotagDirtyFlag;
    }

    public void resetStudioTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStudioTag();
            return;
        }
        this.studiotagDirtyFlag = false;
        this.studiotag = null;
    }

    public void setStudioTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStudioTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.studiotag2 = string;
        this.studiotag2DirtyFlag = true;
    }

    public String getStudioTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStudioTag2();
        }
        return this.studiotag2;
    }

    public boolean isStudioTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStudioTag2Dirty();
        }
        return this.studiotag2DirtyFlag;
    }

    public void resetStudioTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStudioTag2();
            return;
        }
        this.studiotag2DirtyFlag = false;
        this.studiotag2 = null;
    }

    public void setStudioVer(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStudioVer(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.studiover = string;
        this.studioverDirtyFlag = true;
    }

    public String getStudioVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStudioVer();
        }
        return this.studiover;
    }

    public boolean isStudioVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStudioVerDirty();
        }
        return this.studioverDirtyFlag;
    }

    public void resetStudioVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStudioVer();
            return;
        }
        this.studioverDirtyFlag = false;
        this.studiover = null;
    }

    public void setSysFolder(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysFolder(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sysfolder = string;
        this.sysfolderDirtyFlag = true;
    }

    public String getSysFolder() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysFolder();
        }
        return this.sysfolder;
    }

    public boolean isSysFolderDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysFolderDirty();
        }
        return this.sysfolderDirtyFlag;
    }

    public void resetSysFolder() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysFolder();
            return;
        }
        this.sysfolderDirtyFlag = false;
        this.sysfolder = null;
    }

    public void setSysMDUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysMDUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sysmdurl = string;
        this.sysmdurlDirtyFlag = true;
    }

    public String getSysMDUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysMDUrl();
        }
        return this.sysmdurl;
    }

    public boolean isSysMDUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysMDUrlDirty();
        }
        return this.sysmdurlDirtyFlag;
    }

    public void resetSysMDUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysMDUrl();
            return;
        }
        this.sysmdurlDirtyFlag = false;
        this.sysmdurl = null;
    }

    public void setSysRowKey(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysRowKey(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sysrowkey = string;
        this.sysrowkeyDirtyFlag = true;
    }

    public String getSysRowKey() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysRowKey();
        }
        return this.sysrowkey;
    }

    public boolean isSysRowKeyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysRowKeyDirty();
        }
        return this.sysrowkeyDirtyFlag;
    }

    public void resetSysRowKey() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysRowKey();
            return;
        }
        this.sysrowkeyDirtyFlag = false;
        this.sysrowkey = null;
    }

    public void setSysTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.systag = string;
        this.systagDirtyFlag = true;
    }

    public String getSysTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysTag();
        }
        return this.systag;
    }

    public boolean isSysTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysTagDirty();
        }
        return this.systagDirtyFlag;
    }

    public void resetSysTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysTag();
            return;
        }
        this.systagDirtyFlag = false;
        this.systag = null;
    }

    public void setSysTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.systag2 = string;
        this.systag2DirtyFlag = true;
    }

    public String getSysTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysTag2();
        }
        return this.systag2;
    }

    public boolean isSysTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysTag2Dirty();
        }
        return this.systag2DirtyFlag;
    }

    public void resetSysTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysTag2();
            return;
        }
        this.systag2DirtyFlag = false;
        this.systag2 = null;
    }

    public void setSysTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.systag3 = string;
        this.systag3DirtyFlag = true;
    }

    public String getSysTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysTag3();
        }
        return this.systag3;
    }

    public boolean isSysTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysTag3Dirty();
        }
        return this.systag3DirtyFlag;
    }

    public void resetSysTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysTag3();
            return;
        }
        this.systag3DirtyFlag = false;
        this.systag3 = null;
    }

    public void setSysTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.systag4 = string;
        this.systag4DirtyFlag = true;
    }

    public String getSysTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysTag4();
        }
        return this.systag4;
    }

    public boolean isSysTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysTag4Dirty();
        }
        return this.systag4DirtyFlag;
    }

    public void resetSysTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysTag4();
            return;
        }
        this.systag4DirtyFlag = false;
        this.systag4 = null;
    }

    public void setSysType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.systype = string;
        this.systypeDirtyFlag = true;
    }

    public String getSysType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysType();
        }
        return this.systype;
    }

    public boolean isSysTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysTypeDirty();
        }
        return this.systypeDirtyFlag;
    }

    public void resetSysType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysType();
            return;
        }
        this.systypeDirtyFlag = false;
        this.systype = null;
    }

    public void setSysVer(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysVer(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sysver = string;
        this.sysverDirtyFlag = true;
    }

    public String getSysVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysVer();
        }
        return this.sysver;
    }

    public boolean isSysVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysVerDirty();
        }
        return this.sysverDirtyFlag;
    }

    public void resetSysVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysVer();
            return;
        }
        this.sysverDirtyFlag = false;
        this.sysver = null;
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

    public void setThemeCssStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setThemeCssStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.themecssstyle = string;
        this.themecssstyleDirtyFlag = true;
    }

    public String getThemeCssStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getThemeCssStyle();
        }
        return this.themecssstyle;
    }

    public boolean isThemeCssStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isThemeCssStyleDirty();
        }
        return this.themecssstyleDirtyFlag;
    }

    public void resetThemeCssStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetThemeCssStyle();
            return;
        }
        this.themecssstyleDirtyFlag = false;
        this.themecssstyle = null;
    }

    public void setUnloadTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUnloadTime(timestamp);
            return;
        }
        this.unloadtime = timestamp;
        this.unloadtimeDirtyFlag = true;
    }

    public Timestamp getUnloadTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUnloadTime();
        }
        return this.unloadtime;
    }

    public boolean isUnloadTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUnloadTimeDirty();
        }
        return this.unloadtimeDirtyFlag;
    }

    public void resetUnloadTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUnloadTime();
            return;
        }
        this.unloadtimeDirtyFlag = false;
        this.unloadtime = null;
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

    public void setValidFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValidFlag(n);
            return;
        }
        this.validflag = n;
        this.validflagDirtyFlag = true;
    }

    public Integer getValidFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValidFlag();
        }
        return this.validflag;
    }

    public boolean isValidFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValidFlagDirty();
        }
        return this.validflagDirtyFlag;
    }

    public void resetValidFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValidFlag();
            return;
        }
        this.validflagDirtyFlag = false;
        this.validflag = null;
    }

    public void setVCType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVCType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.vctype = string;
        this.vctypeDirtyFlag = true;
    }

    public String getVCType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVCType();
        }
        return this.vctype;
    }

    public boolean isVCTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVCTypeDirty();
        }
        return this.vctypeDirtyFlag;
    }

    public void resetVCType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVCType();
            return;
        }
        this.vctypeDirtyFlag = false;
        this.vctype = null;
    }

    protected void onReset() {
        PSDevSlnSysBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevSlnSysBase pSDevSlnSysBase) {
        pSDevSlnSysBase.resetActionOwner();
        pSDevSlnSysBase.resetAPIFlag();
        pSDevSlnSysBase.resetCallbackTag();
        pSDevSlnSysBase.resetCallbackUrl();
        pSDevSlnSysBase.resetCodeName();
        pSDevSlnSysBase.resetCreateDate();
        pSDevSlnSysBase.resetCreateMan();
        pSDevSlnSysBase.resetCurAction();
        pSDevSlnSysBase.resetDB2PSDCDBInstId();
        pSDevSlnSysBase.resetDB2PSDCDBInstName();
        pSDevSlnSysBase.resetDBTypes();
        pSDevSlnSysBase.resetDBVersion();
        pSDevSlnSysBase.resetDeploySysId();
        pSDevSlnSysBase.resetDeploySysOrgId();
        pSDevSlnSysBase.resetDeploySysOrgSectorId();
        pSDevSlnSysBase.resetDeploySysTag();
        pSDevSlnSysBase.resetDeploySysTag2();
        pSDevSlnSysBase.resetDeploySysType();
        pSDevSlnSysBase.resetDevResInfo();
        pSDevSlnSysBase.resetDevResState();
        pSDevSlnSysBase.resetDevSysState();
        pSDevSlnSysBase.resetDocGitBranch();
        pSDevSlnSysBase.resetDocGitPath();
        pSDevSlnSysBase.resetDocPSDevCenterSVNId();
        pSDevSlnSysBase.resetDocPSDevCenterSVNName();
        pSDevSlnSysBase.resetEnableCallback();
        pSDevSlnSysBase.resetEnableDB2();
        pSDevSlnSysBase.resetEnableDeployCenter();
        pSDevSlnSysBase.resetEnableDM();
        pSDevSlnSysBase.resetEnableDynaSys();
        pSDevSlnSysBase.resetEnableFolderKey();
        pSDevSlnSysBase.resetEnableHANA();
        pSDevSlnSysBase.resetEnableHBase();
        pSDevSlnSysBase.resetEnableMySQL5();
        pSDevSlnSysBase.resetEnableOracle();
        pSDevSlnSysBase.resetEnablePGSQL();
        pSDevSlnSysBase.resetEnablePPAS();
        pSDevSlnSysBase.resetEnableSQLite();
        pSDevSlnSysBase.resetEnableSqlServer();
        pSDevSlnSysBase.resetEnableWSServer();
        pSDevSlnSysBase.resetEntityCnt();
        pSDevSlnSysBase.resetExpriedTime();
        pSDevSlnSysBase.resetGitBranch();
        pSDevSlnSysBase.resetGitPath();
        pSDevSlnSysBase.resetHBasePSDCBDInstId();
        pSDevSlnSysBase.resetHBasePSDCBDInstName();
        pSDevSlnSysBase.resetInitParams();
        pSDevSlnSysBase.resetJITPSDBDevInstId();
        pSDevSlnSysBase.resetJITPSDBDevInstName();
        pSDevSlnSysBase.resetJITPSDevCenterTSId();
        pSDevSlnSysBase.resetJITPSDevCenterTSName();
        pSDevSlnSysBase.resetLastActiveTime();
        pSDevSlnSysBase.resetLoadTime();
        pSDevSlnSysBase.resetLogicName();
        pSDevSlnSysBase.resetLowCodeMode();
        pSDevSlnSysBase.resetMainPSDevSlnSysId();
        pSDevSlnSysBase.resetMainPSDevSlnSysName();
        pSDevSlnSysBase.resetMaxEntityCnt();
        pSDevSlnSysBase.resetMemo();
        pSDevSlnSysBase.resetModelGitBranch();
        pSDevSlnSysBase.resetModelGitPath();
        pSDevSlnSysBase.resetModelInstVer();
        pSDevSlnSysBase.resetModelPrefix();
        pSDevSlnSysBase.resetModelPSDevCenterSVNId();
        pSDevSlnSysBase.resetModelPSDevCenterSVNName();
        pSDevSlnSysBase.resetMSSQLPSDCDBInstId();
        pSDevSlnSysBase.resetMSSQLPSDCDBInstName();
        pSDevSlnSysBase.resetMySQLPSDCDBInstId();
        pSDevSlnSysBase.resetMySQLPSDCDBInstName();
        pSDevSlnSysBase.resetOfflineTime();
        pSDevSlnSysBase.resetOraPSDCDBInstId();
        pSDevSlnSysBase.resetOraPSDCDBInstName();
        pSDevSlnSysBase.resetPGSQLPSDCDBInstId();
        pSDevSlnSysBase.resetPGSQLPSDCDBInstName();
        pSDevSlnSysBase.resetPPASPSDCDBInstId();
        pSDevSlnSysBase.resetPPASPSDCDBInstName();
        pSDevSlnSysBase.resetPPSDevSlnSysId();
        pSDevSlnSysBase.resetPPSDevSlnSysName();
        pSDevSlnSysBase.resetPSDCDeployCenterId();
        pSDevSlnSysBase.resetPSDCDeployCenterName();
        pSDevSlnSysBase.resetPSDCModelTemplId();
        pSDevSlnSysBase.resetPSDCModelTemplName();
        pSDevSlnSysBase.resetPSDCRobotId();
        pSDevSlnSysBase.resetPSDCRobotName();
        pSDevSlnSysBase.resetPSDCSysLicId();
        pSDevSlnSysBase.resetPSDCSysLicName();
        pSDevSlnSysBase.resetPSDCWorkspaceId();
        pSDevSlnSysBase.resetPSDevCenterASId();
        pSDevSlnSysBase.resetPSDevCenterASId2();
        pSDevSlnSysBase.resetPSDevCenterAS3Id();
        pSDevSlnSysBase.resetPSDevCenterAS4Id();
        pSDevSlnSysBase.resetPSDevCenterASName();
        pSDevSlnSysBase.resetPSDevCenterASName2();
        pSDevSlnSysBase.resetPSDevCenterAS3Name();
        pSDevSlnSysBase.resetPSDevCenterAS4Name();
        pSDevSlnSysBase.resetPSDevCenterId();
        pSDevSlnSysBase.resetPSDevCenterName();
        pSDevSlnSysBase.resetPSDevCenterSVNId();
        pSDevSlnSysBase.resetPSDevCenterSVNName();
        pSDevSlnSysBase.resetPSDevCenterTSId();
        pSDevSlnSysBase.resetPSDevCenterTSName();
        pSDevSlnSysBase.resetPSDevSlnId();
        pSDevSlnSysBase.resetPSDevSlnName();
        pSDevSlnSysBase.resetPSDevSlnSysId();
        pSDevSlnSysBase.resetPSDevSlnSysName();
        pSDevSlnSysBase.resetPSDevSlnSysResId();
        pSDevSlnSysBase.resetPSDevSlnSysResName();
        pSDevSlnSysBase.resetPSPFId();
        pSDevSlnSysBase.resetPSPFName();
        pSDevSlnSysBase.resetPSSFId();
        pSDevSlnSysBase.resetPSSFName();
        pSDevSlnSysBase.resetPSStudioThemeId();
        pSDevSlnSysBase.resetPSStudioThemeName();
        pSDevSlnSysBase.resetPSSysModelInstId();
        pSDevSlnSysBase.resetPSSysModelInstName();
        pSDevSlnSysBase.resetPSSysPolicyId();
        pSDevSlnSysBase.resetPSSysPolicyName();
        pSDevSlnSysBase.resetPSSystemId();
        pSDevSlnSysBase.resetPSTaskServerId();
        pSDevSlnSysBase.resetPSTaskServerName();
        pSDevSlnSysBase.resetPubCode();
        pSDevSlnSysBase.resetResReadyTime();
        pSDevSlnSysBase.resetROGitBranch();
        pSDevSlnSysBase.resetROGitPath();
        pSDevSlnSysBase.resetROPSDevCenterSvnId();
        pSDevSlnSysBase.resetROPSDevCenterSvnName();
        pSDevSlnSysBase.resetRTModelPSDevCenterSVNId();
        pSDevSlnSysBase.resetRTModelPSDevCenterSVNName();
        pSDevSlnSysBase.resetSaaSMode();
        pSDevSlnSysBase.resetSFPSSubSysId();
        pSDevSlnSysBase.resetSFPSSubSysName();
        pSDevSlnSysBase.resetShareFlag();
        pSDevSlnSysBase.resetStudioTag();
        pSDevSlnSysBase.resetStudioTag2();
        pSDevSlnSysBase.resetStudioVer();
        pSDevSlnSysBase.resetSysFolder();
        pSDevSlnSysBase.resetSysMDUrl();
        pSDevSlnSysBase.resetSysRowKey();
        pSDevSlnSysBase.resetSysTag();
        pSDevSlnSysBase.resetSysTag2();
        pSDevSlnSysBase.resetSysTag3();
        pSDevSlnSysBase.resetSysTag4();
        pSDevSlnSysBase.resetSysType();
        pSDevSlnSysBase.resetSysVer();
        pSDevSlnSysBase.resetTemplEngine();
        pSDevSlnSysBase.resetThemeCssStyle();
        pSDevSlnSysBase.resetUnloadTime();
        pSDevSlnSysBase.resetUpdateDate();
        pSDevSlnSysBase.resetUpdateMan();
        pSDevSlnSysBase.resetUserCat();
        pSDevSlnSysBase.resetUserTag();
        pSDevSlnSysBase.resetUserTag2();
        pSDevSlnSysBase.resetUserTag3();
        pSDevSlnSysBase.resetUserTag4();
        pSDevSlnSysBase.resetValidFlag();
        pSDevSlnSysBase.resetVCType();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isActionOwnerDirty()) {
            hashMap.put(FIELD_ACTIONOWNER, this.getActionOwner());
        }
        if (!bl || this.isAPIFlagDirty()) {
            hashMap.put(FIELD_APIFLAG, this.getAPIFlag());
        }
        if (!bl || this.isCallbackTagDirty()) {
            hashMap.put(FIELD_CALLBACKTAG, this.getCallbackTag());
        }
        if (!bl || this.isCallbackUrlDirty()) {
            hashMap.put(FIELD_CALLBACKURL, this.getCallbackUrl());
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
        if (!bl || this.isCurActionDirty()) {
            hashMap.put(FIELD_CURACTION, this.getCurAction());
        }
        if (!bl || this.isDB2PSDCDBInstIdDirty()) {
            hashMap.put(FIELD_DB2PSDCDBINSTID, this.getDB2PSDCDBInstId());
        }
        if (!bl || this.isDB2PSDCDBInstNameDirty()) {
            hashMap.put(FIELD_DB2PSDCDBINSTNAME, this.getDB2PSDCDBInstName());
        }
        if (!bl || this.isDBTypesDirty()) {
            hashMap.put(FIELD_DBTYPES, this.getDBTypes());
        }
        if (!bl || this.isDBVersionDirty()) {
            hashMap.put(FIELD_DBVERSION, this.getDBVersion());
        }
        if (!bl || this.isDeploySysIdDirty()) {
            hashMap.put(FIELD_DEPLOYSYSID, this.getDeploySysId());
        }
        if (!bl || this.isDeploySysOrgIdDirty()) {
            hashMap.put(FIELD_DEPLOYSYSORGID, this.getDeploySysOrgId());
        }
        if (!bl || this.isDeploySysOrgSectorIdDirty()) {
            hashMap.put(FIELD_DEPLOYSYSORGSECTORID, this.getDeploySysOrgSectorId());
        }
        if (!bl || this.isDeploySysTagDirty()) {
            hashMap.put(FIELD_DEPLOYSYSTAG, this.getDeploySysTag());
        }
        if (!bl || this.isDeploySysTag2Dirty()) {
            hashMap.put(FIELD_DEPLOYSYSTAG2, this.getDeploySysTag2());
        }
        if (!bl || this.isDeploySysTypeDirty()) {
            hashMap.put(FIELD_DEPLOYSYSTYPE, this.getDeploySysType());
        }
        if (!bl || this.isDevResInfoDirty()) {
            hashMap.put(FIELD_DEVRESINFO, this.getDevResInfo());
        }
        if (!bl || this.isDevResStateDirty()) {
            hashMap.put(FIELD_DEVRESSTATE, this.getDevResState());
        }
        if (!bl || this.isDevSysStateDirty()) {
            hashMap.put(FIELD_DEVSYSSTATE, this.getDevSysState());
        }
        if (!bl || this.isDocGitBranchDirty()) {
            hashMap.put(FIELD_DOCGITBRANCH, this.getDocGitBranch());
        }
        if (!bl || this.isDocGitPathDirty()) {
            hashMap.put(FIELD_DOCGITPATH, this.getDocGitPath());
        }
        if (!bl || this.isDocPSDevCenterSVNIdDirty()) {
            hashMap.put(FIELD_DOCPSDEVCENTERSVNID, this.getDocPSDevCenterSVNId());
        }
        if (!bl || this.isDocPSDevCenterSVNNameDirty()) {
            hashMap.put(FIELD_DOCPSDEVCENTERSVNNAME, this.getDocPSDevCenterSVNName());
        }
        if (!bl || this.isEnableCallbackDirty()) {
            hashMap.put(FIELD_ENABLECALLBACK, this.getEnableCallback());
        }
        if (!bl || this.isEnableDB2Dirty()) {
            hashMap.put(FIELD_ENABLEDB2, this.getEnableDB2());
        }
        if (!bl || this.isEnableDeployCenterDirty()) {
            hashMap.put(FIELD_ENABLEDEPLOYCENTER, this.getEnableDeployCenter());
        }
        if (!bl || this.isEnableDMDirty()) {
            hashMap.put(FIELD_ENABLEDM, this.getEnableDM());
        }
        if (!bl || this.isEnableDynaSysDirty()) {
            hashMap.put(FIELD_ENABLEDYNASYS, this.getEnableDynaSys());
        }
        if (!bl || this.isEnableFolderKeyDirty()) {
            hashMap.put(FIELD_ENABLEFOLDERKEY, this.getEnableFolderKey());
        }
        if (!bl || this.isEnableHANADirty()) {
            hashMap.put(FIELD_ENABLEHANA, this.getEnableHANA());
        }
        if (!bl || this.isEnableHBaseDirty()) {
            hashMap.put(FIELD_ENABLEHBASE, this.getEnableHBase());
        }
        if (!bl || this.isEnableMySQL5Dirty()) {
            hashMap.put(FIELD_ENABLEMYSQL5, this.getEnableMySQL5());
        }
        if (!bl || this.isEnableOracleDirty()) {
            hashMap.put(FIELD_ENABLEORACLE, this.getEnableOracle());
        }
        if (!bl || this.isEnablePGSQLDirty()) {
            hashMap.put(FIELD_ENABLEPGSQL, this.getEnablePGSQL());
        }
        if (!bl || this.isEnablePPASDirty()) {
            hashMap.put(FIELD_ENABLEPPAS, this.getEnablePPAS());
        }
        if (!bl || this.isEnableSQLiteDirty()) {
            hashMap.put(FIELD_ENABLESQLITE, this.getEnableSQLite());
        }
        if (!bl || this.isEnableSqlServerDirty()) {
            hashMap.put(FIELD_ENABLESQLSERVER, this.getEnableSqlServer());
        }
        if (!bl || this.isEnableWSServerDirty()) {
            hashMap.put(FIELD_ENABLEWSSERVER, this.getEnableWSServer());
        }
        if (!bl || this.isEntityCntDirty()) {
            hashMap.put(FIELD_ENTITYCNT, this.getEntityCnt());
        }
        if (!bl || this.isExpriedTimeDirty()) {
            hashMap.put(FIELD_EXPRIEDTIME, this.getExpriedTime());
        }
        if (!bl || this.isGitBranchDirty()) {
            hashMap.put(FIELD_GITBRANCH, this.getGitBranch());
        }
        if (!bl || this.isGitPathDirty()) {
            hashMap.put(FIELD_GITPATH, this.getGitPath());
        }
        if (!bl || this.isHBasePSDCBDInstIdDirty()) {
            hashMap.put(FIELD_HBASEPSDCBDINSTID, this.getHBasePSDCBDInstId());
        }
        if (!bl || this.isHBasePSDCBDInstNameDirty()) {
            hashMap.put(FIELD_HBASEPSDCBDINSTNAME, this.getHBasePSDCBDInstName());
        }
        if (!bl || this.isInitParamsDirty()) {
            hashMap.put(FIELD_INITPARAMS, this.getInitParams());
        }
        if (!bl || this.isJITPSDBDevInstIdDirty()) {
            hashMap.put(FIELD_JITPSDBDEVINSTID, this.getJITPSDBDevInstId());
        }
        if (!bl || this.isJITPSDBDevInstNameDirty()) {
            hashMap.put(FIELD_JITPSDBDEVINSTNAME, this.getJITPSDBDevInstName());
        }
        if (!bl || this.isJITPSDevCenterTSIdDirty()) {
            hashMap.put(FIELD_JITPSDEVCENTERTSID, this.getJITPSDevCenterTSId());
        }
        if (!bl || this.isJITPSDevCenterTSNameDirty()) {
            hashMap.put(FIELD_JITPSDEVCENTERTSNAME, this.getJITPSDevCenterTSName());
        }
        if (!bl || this.isLastActiveTimeDirty()) {
            hashMap.put(FIELD_LASTACTIVETIME, this.getLastActiveTime());
        }
        if (!bl || this.isLoadTimeDirty()) {
            hashMap.put(FIELD_LOADTIME, this.getLoadTime());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isLowCodeModeDirty()) {
            hashMap.put(FIELD_LOWCODEMODE, this.getLowCodeMode());
        }
        if (!bl || this.isMainPSDevSlnSysIdDirty()) {
            hashMap.put(FIELD_MAINPSDEVSLNSYSID, this.getMainPSDevSlnSysId());
        }
        if (!bl || this.isMainPSDevSlnSysNameDirty()) {
            hashMap.put(FIELD_MAINPSDEVSLNSYSNAME, this.getMainPSDevSlnSysName());
        }
        if (!bl || this.isMaxEntityCntDirty()) {
            hashMap.put(FIELD_MAXENTITYCNT, this.getMaxEntityCnt());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isModelGitBranchDirty()) {
            hashMap.put(FIELD_MODELGITBRANCH, this.getModelGitBranch());
        }
        if (!bl || this.isModelGitPathDirty()) {
            hashMap.put(FIELD_MODELGITPATH, this.getModelGitPath());
        }
        if (!bl || this.isModelInstVerDirty()) {
            hashMap.put(FIELD_MODELINSTVER, this.getModelInstVer());
        }
        if (!bl || this.isModelPrefixDirty()) {
            hashMap.put(FIELD_MODELPREFIX, this.getModelPrefix());
        }
        if (!bl || this.isModelPSDevCenterSVNIdDirty()) {
            hashMap.put(FIELD_MODELPSDEVCENTERSVNID, this.getModelPSDevCenterSVNId());
        }
        if (!bl || this.isModelPSDevCenterSVNNameDirty()) {
            hashMap.put(FIELD_MODELPSDEVCENTERSVNNAME, this.getModelPSDevCenterSVNName());
        }
        if (!bl || this.isMSSQLPSDCDBInstIdDirty()) {
            hashMap.put(FIELD_MSSQLPSDCDBINSTID, this.getMSSQLPSDCDBInstId());
        }
        if (!bl || this.isMSSQLPSDCDBInstNameDirty()) {
            hashMap.put(FIELD_MSSQLPSDCDBINSTNAME, this.getMSSQLPSDCDBInstName());
        }
        if (!bl || this.isMySQLPSDCDBInstIdDirty()) {
            hashMap.put(FIELD_MYSQLPSDCDBINSTID, this.getMySQLPSDCDBInstId());
        }
        if (!bl || this.isMySQLPSDCDBInstNameDirty()) {
            hashMap.put(FIELD_MYSQLPSDCDBINSTNAME, this.getMySQLPSDCDBInstName());
        }
        if (!bl || this.isOfflineTimeDirty()) {
            hashMap.put(FIELD_OFFLINETIME, this.getOfflineTime());
        }
        if (!bl || this.isOraPSDCDBInstIdDirty()) {
            hashMap.put(FIELD_ORAPSDCDBINSTID, this.getOraPSDCDBInstId());
        }
        if (!bl || this.isOraPSDCDBInstNameDirty()) {
            hashMap.put(FIELD_ORAPSDCDBINSTNAME, this.getOraPSDCDBInstName());
        }
        if (!bl || this.isPGSQLPSDCDBInstIdDirty()) {
            hashMap.put(FIELD_PGSQLPSDCDBINSTID, this.getPGSQLPSDCDBInstId());
        }
        if (!bl || this.isPGSQLPSDCDBInstNameDirty()) {
            hashMap.put(FIELD_PGSQLPSDCDBINSTNAME, this.getPGSQLPSDCDBInstName());
        }
        if (!bl || this.isPPASPSDCDBInstIdDirty()) {
            hashMap.put(FIELD_PPASPSDCDBINSTID, this.getPPASPSDCDBInstId());
        }
        if (!bl || this.isPPASPSDCDBInstNameDirty()) {
            hashMap.put(FIELD_PPASPSDCDBINSTNAME, this.getPPASPSDCDBInstName());
        }
        if (!bl || this.isPPSDevSlnSysIdDirty()) {
            hashMap.put(FIELD_PPSDEVSLNSYSID, this.getPPSDevSlnSysId());
        }
        if (!bl || this.isPPSDevSlnSysNameDirty()) {
            hashMap.put(FIELD_PPSDEVSLNSYSNAME, this.getPPSDevSlnSysName());
        }
        if (!bl || this.isPSDCDeployCenterIdDirty()) {
            hashMap.put(FIELD_PSDCDEPLOYCENTERID, this.getPSDCDeployCenterId());
        }
        if (!bl || this.isPSDCDeployCenterNameDirty()) {
            hashMap.put(FIELD_PSDCDEPLOYCENTERNAME, this.getPSDCDeployCenterName());
        }
        if (!bl || this.isPSDCModelTemplIdDirty()) {
            hashMap.put(FIELD_PSDCMODELTEMPLID, this.getPSDCModelTemplId());
        }
        if (!bl || this.isPSDCModelTemplNameDirty()) {
            hashMap.put(FIELD_PSDCMODELTEMPLNAME, this.getPSDCModelTemplName());
        }
        if (!bl || this.isPSDCRobotIdDirty()) {
            hashMap.put(FIELD_PSDCROBOTID, this.getPSDCRobotId());
        }
        if (!bl || this.isPSDCRobotNameDirty()) {
            hashMap.put(FIELD_PSDCROBOTNAME, this.getPSDCRobotName());
        }
        if (!bl || this.isPSDCSysLicIdDirty()) {
            hashMap.put(FIELD_PSDCSYSLICID, this.getPSDCSysLicId());
        }
        if (!bl || this.isPSDCSysLicNameDirty()) {
            hashMap.put(FIELD_PSDCSYSLICNAME, this.getPSDCSysLicName());
        }
        if (!bl || this.isPSDCWorkspaceIdDirty()) {
            hashMap.put(FIELD_PSDCWORKSPACEID, this.getPSDCWorkspaceId());
        }
        if (!bl || this.isPSDevCenterASIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERASID, this.getPSDevCenterASId());
        }
        if (!bl || this.isPSDevCenterASId2Dirty()) {
            hashMap.put(FIELD_PSDEVCENTERASID2, this.getPSDevCenterASId2());
        }
        if (!bl || this.isPSDevCenterAS3IdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERAS3ID, this.getPSDevCenterAS3Id());
        }
        if (!bl || this.isPSDevCenterAS4IdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERAS4ID, this.getPSDevCenterAS4Id());
        }
        if (!bl || this.isPSDevCenterASNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERASNAME, this.getPSDevCenterASName());
        }
        if (!bl || this.isPSDevCenterASName2Dirty()) {
            hashMap.put(FIELD_PSDEVCENTERASNAME2, this.getPSDevCenterASName2());
        }
        if (!bl || this.isPSDevCenterAS3NameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERAS3NAME, this.getPSDevCenterAS3Name());
        }
        if (!bl || this.isPSDevCenterAS4NameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERAS4NAME, this.getPSDevCenterAS4Name());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSDevCenterSVNIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERSVNID, this.getPSDevCenterSVNId());
        }
        if (!bl || this.isPSDevCenterSVNNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERSVNNAME, this.getPSDevCenterSVNName());
        }
        if (!bl || this.isPSDevCenterTSIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERTSID, this.getPSDevCenterTSId());
        }
        if (!bl || this.isPSDevCenterTSNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERTSNAME, this.getPSDevCenterTSName());
        }
        if (!bl || this.isPSDevSlnIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNID, this.getPSDevSlnId());
        }
        if (!bl || this.isPSDevSlnNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNNAME, this.getPSDevSlnName());
        }
        if (!bl || this.isPSDevSlnSysIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSID, this.getPSDevSlnSysId());
        }
        if (!bl || this.isPSDevSlnSysNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSNAME, this.getPSDevSlnSysName());
        }
        if (!bl || this.isPSDevSlnSysResIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSRESID, this.getPSDevSlnSysResId());
        }
        if (!bl || this.isPSDevSlnSysResNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSRESNAME, this.getPSDevSlnSysResName());
        }
        if (!bl || this.isPSPFIdDirty()) {
            hashMap.put(FIELD_PSPFID, this.getPSPFId());
        }
        if (!bl || this.isPSPFNameDirty()) {
            hashMap.put(FIELD_PSPFNAME, this.getPSPFName());
        }
        if (!bl || this.isPSSFIdDirty()) {
            hashMap.put(FIELD_PSSFID, this.getPSSFId());
        }
        if (!bl || this.isPSSFNameDirty()) {
            hashMap.put(FIELD_PSSFNAME, this.getPSSFName());
        }
        if (!bl || this.isPSStudioThemeIdDirty()) {
            hashMap.put(FIELD_PSSTUDIOTHEMEID, this.getPSStudioThemeId());
        }
        if (!bl || this.isPSStudioThemeNameDirty()) {
            hashMap.put(FIELD_PSSTUDIOTHEMENAME, this.getPSStudioThemeName());
        }
        if (!bl || this.isPSSysModelInstIdDirty()) {
            hashMap.put(FIELD_PSSYSMODELINSTID, this.getPSSysModelInstId());
        }
        if (!bl || this.isPSSysModelInstNameDirty()) {
            hashMap.put(FIELD_PSSYSMODELINSTNAME, this.getPSSysModelInstName());
        }
        if (!bl || this.isPSSysPolicyIdDirty()) {
            hashMap.put(FIELD_PSSYSPOLICYID, this.getPSSysPolicyId());
        }
        if (!bl || this.isPSSysPolicyNameDirty()) {
            hashMap.put(FIELD_PSSYSPOLICYNAME, this.getPSSysPolicyName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSTaskServerIdDirty()) {
            hashMap.put(FIELD_PSTASKSERVERID, this.getPSTaskServerId());
        }
        if (!bl || this.isPSTaskServerNameDirty()) {
            hashMap.put(FIELD_PSTASKSERVERNAME, this.getPSTaskServerName());
        }
        if (!bl || this.isPubCodeDirty()) {
            hashMap.put(FIELD_PUBCODE, this.getPubCode());
        }
        if (!bl || this.isResReadyTimeDirty()) {
            hashMap.put(FIELD_RESREADYTIME, this.getResReadyTime());
        }
        if (!bl || this.isROGitBranchDirty()) {
            hashMap.put(FIELD_ROGITBRANCH, this.getROGitBranch());
        }
        if (!bl || this.isROGitPathDirty()) {
            hashMap.put(FIELD_ROGITPATH, this.getROGitPath());
        }
        if (!bl || this.isROPSDevCenterSvnIdDirty()) {
            hashMap.put(FIELD_ROPSDEVCENTERSVNID, this.getROPSDevCenterSvnId());
        }
        if (!bl || this.isROPSDevCenterSvnNameDirty()) {
            hashMap.put(FIELD_ROPSDEVCENTERSVNNAME, this.getROPSDevCenterSvnName());
        }
        if (!bl || this.isRTModelPSDevCenterSVNIdDirty()) {
            hashMap.put(FIELD_RTMODELPSDEVCENTERSVNID, this.getRTModelPSDevCenterSVNId());
        }
        if (!bl || this.isRTModelPSDevCenterSVNNameDirty()) {
            hashMap.put(FIELD_RTMODELPSDEVCENTERSVNNAME, this.getRTModelPSDevCenterSVNName());
        }
        if (!bl || this.isSaaSModeDirty()) {
            hashMap.put(FIELD_SAASMODE, this.getSaaSMode());
        }
        if (!bl || this.isSFPSSubSysIdDirty()) {
            hashMap.put(FIELD_SFPSSUBSYSID, this.getSFPSSubSysId());
        }
        if (!bl || this.isSFPSSubSysNameDirty()) {
            hashMap.put(FIELD_SFPSSUBSYSNAME, this.getSFPSSubSysName());
        }
        if (!bl || this.isShareFlagDirty()) {
            hashMap.put(FIELD_SHAREFLAG, this.getShareFlag());
        }
        if (!bl || this.isStudioTagDirty()) {
            hashMap.put(FIELD_STUDIOTAG, this.getStudioTag());
        }
        if (!bl || this.isStudioTag2Dirty()) {
            hashMap.put(FIELD_STUDIOTAG2, this.getStudioTag2());
        }
        if (!bl || this.isStudioVerDirty()) {
            hashMap.put(FIELD_STUDIOVER, this.getStudioVer());
        }
        if (!bl || this.isSysFolderDirty()) {
            hashMap.put(FIELD_SYSFOLDER, this.getSysFolder());
        }
        if (!bl || this.isSysMDUrlDirty()) {
            hashMap.put(FIELD_SYSMDURL, this.getSysMDUrl());
        }
        if (!bl || this.isSysRowKeyDirty()) {
            hashMap.put(FIELD_SYSROWKEY, this.getSysRowKey());
        }
        if (!bl || this.isSysTagDirty()) {
            hashMap.put(FIELD_SYSTAG, this.getSysTag());
        }
        if (!bl || this.isSysTag2Dirty()) {
            hashMap.put(FIELD_SYSTAG2, this.getSysTag2());
        }
        if (!bl || this.isSysTag3Dirty()) {
            hashMap.put(FIELD_SYSTAG3, this.getSysTag3());
        }
        if (!bl || this.isSysTag4Dirty()) {
            hashMap.put(FIELD_SYSTAG4, this.getSysTag4());
        }
        if (!bl || this.isSysTypeDirty()) {
            hashMap.put(FIELD_SYSTYPE, this.getSysType());
        }
        if (!bl || this.isSysVerDirty()) {
            hashMap.put(FIELD_SYSVER, this.getSysVer());
        }
        if (!bl || this.isTemplEngineDirty()) {
            hashMap.put(FIELD_TEMPLENGINE, this.getTemplEngine());
        }
        if (!bl || this.isThemeCssStyleDirty()) {
            hashMap.put(FIELD_THEMECSSSTYLE, this.getThemeCssStyle());
        }
        if (!bl || this.isUnloadTimeDirty()) {
            hashMap.put(FIELD_UNLOADTIME, this.getUnloadTime());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserCatDirty()) {
            hashMap.put(FIELD_USERCAT, this.getUserCat());
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
        if (!bl || this.isValidFlagDirty()) {
            hashMap.put(FIELD_VALIDFLAG, this.getValidFlag());
        }
        if (!bl || this.isVCTypeDirty()) {
            hashMap.put(FIELD_VCTYPE, this.getVCType());
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
        return PSDevSlnSysBase.get(this, n);
    }

    private static Object get(PSDevSlnSysBase pSDevSlnSysBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysBase.getActionOwner();
            }
            case 1: {
                return pSDevSlnSysBase.getAPIFlag();
            }
            case 2: {
                return pSDevSlnSysBase.getCallbackTag();
            }
            case 3: {
                return pSDevSlnSysBase.getCallbackUrl();
            }
            case 4: {
                return pSDevSlnSysBase.getCodeName();
            }
            case 5: {
                return pSDevSlnSysBase.getCreateDate();
            }
            case 6: {
                return pSDevSlnSysBase.getCreateMan();
            }
            case 7: {
                return pSDevSlnSysBase.getCurAction();
            }
            case 8: {
                return pSDevSlnSysBase.getDB2PSDCDBInstId();
            }
            case 9: {
                return pSDevSlnSysBase.getDB2PSDCDBInstName();
            }
            case 10: {
                return pSDevSlnSysBase.getDBTypes();
            }
            case 11: {
                return pSDevSlnSysBase.getDBVersion();
            }
            case 12: {
                return pSDevSlnSysBase.getDeploySysId();
            }
            case 13: {
                return pSDevSlnSysBase.getDeploySysOrgId();
            }
            case 14: {
                return pSDevSlnSysBase.getDeploySysOrgSectorId();
            }
            case 15: {
                return pSDevSlnSysBase.getDeploySysTag();
            }
            case 16: {
                return pSDevSlnSysBase.getDeploySysTag2();
            }
            case 17: {
                return pSDevSlnSysBase.getDeploySysType();
            }
            case 18: {
                return pSDevSlnSysBase.getDevResInfo();
            }
            case 19: {
                return pSDevSlnSysBase.getDevResState();
            }
            case 20: {
                return pSDevSlnSysBase.getDevSysState();
            }
            case 21: {
                return pSDevSlnSysBase.getDocGitBranch();
            }
            case 22: {
                return pSDevSlnSysBase.getDocGitPath();
            }
            case 23: {
                return pSDevSlnSysBase.getDocPSDevCenterSVNId();
            }
            case 24: {
                return pSDevSlnSysBase.getDocPSDevCenterSVNName();
            }
            case 25: {
                return pSDevSlnSysBase.getEnableCallback();
            }
            case 26: {
                return pSDevSlnSysBase.getEnableDB2();
            }
            case 27: {
                return pSDevSlnSysBase.getEnableDeployCenter();
            }
            case 28: {
                return pSDevSlnSysBase.getEnableDM();
            }
            case 29: {
                return pSDevSlnSysBase.getEnableDynaSys();
            }
            case 30: {
                return pSDevSlnSysBase.getEnableFolderKey();
            }
            case 31: {
                return pSDevSlnSysBase.getEnableHANA();
            }
            case 32: {
                return pSDevSlnSysBase.getEnableHBase();
            }
            case 33: {
                return pSDevSlnSysBase.getEnableMySQL5();
            }
            case 34: {
                return pSDevSlnSysBase.getEnableOracle();
            }
            case 35: {
                return pSDevSlnSysBase.getEnablePGSQL();
            }
            case 36: {
                return pSDevSlnSysBase.getEnablePPAS();
            }
            case 37: {
                return pSDevSlnSysBase.getEnableSQLite();
            }
            case 38: {
                return pSDevSlnSysBase.getEnableSqlServer();
            }
            case 39: {
                return pSDevSlnSysBase.getEnableWSServer();
            }
            case 40: {
                return pSDevSlnSysBase.getEntityCnt();
            }
            case 41: {
                return pSDevSlnSysBase.getExpriedTime();
            }
            case 42: {
                return pSDevSlnSysBase.getGitBranch();
            }
            case 43: {
                return pSDevSlnSysBase.getGitPath();
            }
            case 44: {
                return pSDevSlnSysBase.getHBasePSDCBDInstId();
            }
            case 45: {
                return pSDevSlnSysBase.getHBasePSDCBDInstName();
            }
            case 46: {
                return pSDevSlnSysBase.getInitParams();
            }
            case 47: {
                return pSDevSlnSysBase.getJITPSDBDevInstId();
            }
            case 48: {
                return pSDevSlnSysBase.getJITPSDBDevInstName();
            }
            case 49: {
                return pSDevSlnSysBase.getJITPSDevCenterTSId();
            }
            case 50: {
                return pSDevSlnSysBase.getJITPSDevCenterTSName();
            }
            case 51: {
                return pSDevSlnSysBase.getLastActiveTime();
            }
            case 52: {
                return pSDevSlnSysBase.getLoadTime();
            }
            case 53: {
                return pSDevSlnSysBase.getLogicName();
            }
            case 54: {
                return pSDevSlnSysBase.getLowCodeMode();
            }
            case 55: {
                return pSDevSlnSysBase.getMainPSDevSlnSysId();
            }
            case 56: {
                return pSDevSlnSysBase.getMainPSDevSlnSysName();
            }
            case 57: {
                return pSDevSlnSysBase.getMaxEntityCnt();
            }
            case 58: {
                return pSDevSlnSysBase.getMemo();
            }
            case 59: {
                return pSDevSlnSysBase.getModelGitBranch();
            }
            case 60: {
                return pSDevSlnSysBase.getModelGitPath();
            }
            case 61: {
                return pSDevSlnSysBase.getModelInstVer();
            }
            case 62: {
                return pSDevSlnSysBase.getModelPrefix();
            }
            case 63: {
                return pSDevSlnSysBase.getModelPSDevCenterSVNId();
            }
            case 64: {
                return pSDevSlnSysBase.getModelPSDevCenterSVNName();
            }
            case 65: {
                return pSDevSlnSysBase.getMSSQLPSDCDBInstId();
            }
            case 66: {
                return pSDevSlnSysBase.getMSSQLPSDCDBInstName();
            }
            case 67: {
                return pSDevSlnSysBase.getMySQLPSDCDBInstId();
            }
            case 68: {
                return pSDevSlnSysBase.getMySQLPSDCDBInstName();
            }
            case 69: {
                return pSDevSlnSysBase.getOfflineTime();
            }
            case 70: {
                return pSDevSlnSysBase.getOraPSDCDBInstId();
            }
            case 71: {
                return pSDevSlnSysBase.getOraPSDCDBInstName();
            }
            case 72: {
                return pSDevSlnSysBase.getPGSQLPSDCDBInstId();
            }
            case 73: {
                return pSDevSlnSysBase.getPGSQLPSDCDBInstName();
            }
            case 74: {
                return pSDevSlnSysBase.getPPASPSDCDBInstId();
            }
            case 75: {
                return pSDevSlnSysBase.getPPASPSDCDBInstName();
            }
            case 76: {
                return pSDevSlnSysBase.getPPSDevSlnSysId();
            }
            case 77: {
                return pSDevSlnSysBase.getPPSDevSlnSysName();
            }
            case 78: {
                return pSDevSlnSysBase.getPSDCDeployCenterId();
            }
            case 79: {
                return pSDevSlnSysBase.getPSDCDeployCenterName();
            }
            case 80: {
                return pSDevSlnSysBase.getPSDCModelTemplId();
            }
            case 81: {
                return pSDevSlnSysBase.getPSDCModelTemplName();
            }
            case 82: {
                return pSDevSlnSysBase.getPSDCRobotId();
            }
            case 83: {
                return pSDevSlnSysBase.getPSDCRobotName();
            }
            case 84: {
                return pSDevSlnSysBase.getPSDCSysLicId();
            }
            case 85: {
                return pSDevSlnSysBase.getPSDCSysLicName();
            }
            case 86: {
                return pSDevSlnSysBase.getPSDCWorkspaceId();
            }
            case 87: {
                return pSDevSlnSysBase.getPSDevCenterASId();
            }
            case 88: {
                return pSDevSlnSysBase.getPSDevCenterASId2();
            }
            case 89: {
                return pSDevSlnSysBase.getPSDevCenterAS3Id();
            }
            case 90: {
                return pSDevSlnSysBase.getPSDevCenterAS4Id();
            }
            case 91: {
                return pSDevSlnSysBase.getPSDevCenterASName();
            }
            case 92: {
                return pSDevSlnSysBase.getPSDevCenterASName2();
            }
            case 93: {
                return pSDevSlnSysBase.getPSDevCenterAS3Name();
            }
            case 94: {
                return pSDevSlnSysBase.getPSDevCenterAS4Name();
            }
            case 95: {
                return pSDevSlnSysBase.getPSDevCenterId();
            }
            case 96: {
                return pSDevSlnSysBase.getPSDevCenterName();
            }
            case 97: {
                return pSDevSlnSysBase.getPSDevCenterSVNId();
            }
            case 98: {
                return pSDevSlnSysBase.getPSDevCenterSVNName();
            }
            case 99: {
                return pSDevSlnSysBase.getPSDevCenterTSId();
            }
            case 100: {
                return pSDevSlnSysBase.getPSDevCenterTSName();
            }
            case 101: {
                return pSDevSlnSysBase.getPSDevSlnId();
            }
            case 102: {
                return pSDevSlnSysBase.getPSDevSlnName();
            }
            case 103: {
                return pSDevSlnSysBase.getPSDevSlnSysId();
            }
            case 104: {
                return pSDevSlnSysBase.getPSDevSlnSysName();
            }
            case 105: {
                return pSDevSlnSysBase.getPSDevSlnSysResId();
            }
            case 106: {
                return pSDevSlnSysBase.getPSDevSlnSysResName();
            }
            case 107: {
                return pSDevSlnSysBase.getPSPFId();
            }
            case 108: {
                return pSDevSlnSysBase.getPSPFName();
            }
            case 109: {
                return pSDevSlnSysBase.getPSSFId();
            }
            case 110: {
                return pSDevSlnSysBase.getPSSFName();
            }
            case 111: {
                return pSDevSlnSysBase.getPSStudioThemeId();
            }
            case 112: {
                return pSDevSlnSysBase.getPSStudioThemeName();
            }
            case 113: {
                return pSDevSlnSysBase.getPSSysModelInstId();
            }
            case 114: {
                return pSDevSlnSysBase.getPSSysModelInstName();
            }
            case 115: {
                return pSDevSlnSysBase.getPSSysPolicyId();
            }
            case 116: {
                return pSDevSlnSysBase.getPSSysPolicyName();
            }
            case 117: {
                return pSDevSlnSysBase.getPSSystemId();
            }
            case 118: {
                return pSDevSlnSysBase.getPSTaskServerId();
            }
            case 119: {
                return pSDevSlnSysBase.getPSTaskServerName();
            }
            case 120: {
                return pSDevSlnSysBase.getPubCode();
            }
            case 121: {
                return pSDevSlnSysBase.getResReadyTime();
            }
            case 122: {
                return pSDevSlnSysBase.getROGitBranch();
            }
            case 123: {
                return pSDevSlnSysBase.getROGitPath();
            }
            case 124: {
                return pSDevSlnSysBase.getROPSDevCenterSvnId();
            }
            case 125: {
                return pSDevSlnSysBase.getROPSDevCenterSvnName();
            }
            case 126: {
                return pSDevSlnSysBase.getRTModelPSDevCenterSVNId();
            }
            case 127: {
                return pSDevSlnSysBase.getRTModelPSDevCenterSVNName();
            }
            case 128: {
                return pSDevSlnSysBase.getSaaSMode();
            }
            case 129: {
                return pSDevSlnSysBase.getSFPSSubSysId();
            }
            case 130: {
                return pSDevSlnSysBase.getSFPSSubSysName();
            }
            case 131: {
                return pSDevSlnSysBase.getShareFlag();
            }
            case 132: {
                return pSDevSlnSysBase.getStudioTag();
            }
            case 133: {
                return pSDevSlnSysBase.getStudioTag2();
            }
            case 134: {
                return pSDevSlnSysBase.getStudioVer();
            }
            case 135: {
                return pSDevSlnSysBase.getSysFolder();
            }
            case 136: {
                return pSDevSlnSysBase.getSysMDUrl();
            }
            case 137: {
                return pSDevSlnSysBase.getSysRowKey();
            }
            case 138: {
                return pSDevSlnSysBase.getSysTag();
            }
            case 139: {
                return pSDevSlnSysBase.getSysTag2();
            }
            case 140: {
                return pSDevSlnSysBase.getSysTag3();
            }
            case 141: {
                return pSDevSlnSysBase.getSysTag4();
            }
            case 142: {
                return pSDevSlnSysBase.getSysType();
            }
            case 143: {
                return pSDevSlnSysBase.getSysVer();
            }
            case 144: {
                return pSDevSlnSysBase.getTemplEngine();
            }
            case 145: {
                return pSDevSlnSysBase.getThemeCssStyle();
            }
            case 146: {
                return pSDevSlnSysBase.getUnloadTime();
            }
            case 147: {
                return pSDevSlnSysBase.getUpdateDate();
            }
            case 148: {
                return pSDevSlnSysBase.getUpdateMan();
            }
            case 149: {
                return pSDevSlnSysBase.getUserCat();
            }
            case 150: {
                return pSDevSlnSysBase.getUserTag();
            }
            case 151: {
                return pSDevSlnSysBase.getUserTag2();
            }
            case 152: {
                return pSDevSlnSysBase.getUserTag3();
            }
            case 153: {
                return pSDevSlnSysBase.getUserTag4();
            }
            case 154: {
                return pSDevSlnSysBase.getValidFlag();
            }
            case 155: {
                return pSDevSlnSysBase.getVCType();
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
        PSDevSlnSysBase.set(this, n, object);
    }

    private static void set(PSDevSlnSysBase pSDevSlnSysBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnSysBase.setActionOwner(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDevSlnSysBase.setAPIFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 2: {
                pSDevSlnSysBase.setCallbackTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDevSlnSysBase.setCallbackUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevSlnSysBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevSlnSysBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSDevSlnSysBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevSlnSysBase.setCurAction(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevSlnSysBase.setDB2PSDCDBInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevSlnSysBase.setDB2PSDCDBInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevSlnSysBase.setDBTypes(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevSlnSysBase.setDBVersion(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSDevSlnSysBase.setDeploySysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDevSlnSysBase.setDeploySysOrgId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDevSlnSysBase.setDeploySysOrgSectorId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDevSlnSysBase.setDeploySysTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDevSlnSysBase.setDeploySysTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDevSlnSysBase.setDeploySysType(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDevSlnSysBase.setDevResInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDevSlnSysBase.setDevResState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 20: {
                pSDevSlnSysBase.setDevSysState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 21: {
                pSDevSlnSysBase.setDocGitBranch(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDevSlnSysBase.setDocGitPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDevSlnSysBase.setDocPSDevCenterSVNId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDevSlnSysBase.setDocPSDevCenterSVNName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDevSlnSysBase.setEnableCallback(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 26: {
                pSDevSlnSysBase.setEnableDB2(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 27: {
                pSDevSlnSysBase.setEnableDeployCenter(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 28: {
                pSDevSlnSysBase.setEnableDM(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 29: {
                pSDevSlnSysBase.setEnableDynaSys(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 30: {
                pSDevSlnSysBase.setEnableFolderKey(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 31: {
                pSDevSlnSysBase.setEnableHANA(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 32: {
                pSDevSlnSysBase.setEnableHBase(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 33: {
                pSDevSlnSysBase.setEnableMySQL5(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 34: {
                pSDevSlnSysBase.setEnableOracle(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 35: {
                pSDevSlnSysBase.setEnablePGSQL(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 36: {
                pSDevSlnSysBase.setEnablePPAS(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 37: {
                pSDevSlnSysBase.setEnableSQLite(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 38: {
                pSDevSlnSysBase.setEnableSqlServer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 39: {
                pSDevSlnSysBase.setEnableWSServer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 40: {
                pSDevSlnSysBase.setEntityCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 41: {
                pSDevSlnSysBase.setExpriedTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 42: {
                pSDevSlnSysBase.setGitBranch(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSDevSlnSysBase.setGitPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSDevSlnSysBase.setHBasePSDCBDInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSDevSlnSysBase.setHBasePSDCBDInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSDevSlnSysBase.setInitParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSDevSlnSysBase.setJITPSDBDevInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSDevSlnSysBase.setJITPSDBDevInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSDevSlnSysBase.setJITPSDevCenterTSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSDevSlnSysBase.setJITPSDevCenterTSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSDevSlnSysBase.setLastActiveTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 52: {
                pSDevSlnSysBase.setLoadTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 53: {
                pSDevSlnSysBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSDevSlnSysBase.setLowCodeMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 55: {
                pSDevSlnSysBase.setMainPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSDevSlnSysBase.setMainPSDevSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSDevSlnSysBase.setMaxEntityCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 58: {
                pSDevSlnSysBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 59: {
                pSDevSlnSysBase.setModelGitBranch(DataObject.getStringValue((Object)object));
                return;
            }
            case 60: {
                pSDevSlnSysBase.setModelGitPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 61: {
                pSDevSlnSysBase.setModelInstVer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 62: {
                pSDevSlnSysBase.setModelPrefix(DataObject.getStringValue((Object)object));
                return;
            }
            case 63: {
                pSDevSlnSysBase.setModelPSDevCenterSVNId(DataObject.getStringValue((Object)object));
                return;
            }
            case 64: {
                pSDevSlnSysBase.setModelPSDevCenterSVNName(DataObject.getStringValue((Object)object));
                return;
            }
            case 65: {
                pSDevSlnSysBase.setMSSQLPSDCDBInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 66: {
                pSDevSlnSysBase.setMSSQLPSDCDBInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 67: {
                pSDevSlnSysBase.setMySQLPSDCDBInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 68: {
                pSDevSlnSysBase.setMySQLPSDCDBInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 69: {
                pSDevSlnSysBase.setOfflineTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 70: {
                pSDevSlnSysBase.setOraPSDCDBInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 71: {
                pSDevSlnSysBase.setOraPSDCDBInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 72: {
                pSDevSlnSysBase.setPGSQLPSDCDBInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 73: {
                pSDevSlnSysBase.setPGSQLPSDCDBInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 74: {
                pSDevSlnSysBase.setPPASPSDCDBInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 75: {
                pSDevSlnSysBase.setPPASPSDCDBInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 76: {
                pSDevSlnSysBase.setPPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 77: {
                pSDevSlnSysBase.setPPSDevSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 78: {
                pSDevSlnSysBase.setPSDCDeployCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 79: {
                pSDevSlnSysBase.setPSDCDeployCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 80: {
                pSDevSlnSysBase.setPSDCModelTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 81: {
                pSDevSlnSysBase.setPSDCModelTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 82: {
                pSDevSlnSysBase.setPSDCRobotId(DataObject.getStringValue((Object)object));
                return;
            }
            case 83: {
                pSDevSlnSysBase.setPSDCRobotName(DataObject.getStringValue((Object)object));
                return;
            }
            case 84: {
                pSDevSlnSysBase.setPSDCSysLicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 85: {
                pSDevSlnSysBase.setPSDCSysLicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 86: {
                pSDevSlnSysBase.setPSDCWorkspaceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 87: {
                pSDevSlnSysBase.setPSDevCenterASId(DataObject.getStringValue((Object)object));
                return;
            }
            case 88: {
                pSDevSlnSysBase.setPSDevCenterASId2(DataObject.getStringValue((Object)object));
                return;
            }
            case 89: {
                pSDevSlnSysBase.setPSDevCenterAS3Id(DataObject.getStringValue((Object)object));
                return;
            }
            case 90: {
                pSDevSlnSysBase.setPSDevCenterAS4Id(DataObject.getStringValue((Object)object));
                return;
            }
            case 91: {
                pSDevSlnSysBase.setPSDevCenterASName(DataObject.getStringValue((Object)object));
                return;
            }
            case 92: {
                pSDevSlnSysBase.setPSDevCenterASName2(DataObject.getStringValue((Object)object));
                return;
            }
            case 93: {
                pSDevSlnSysBase.setPSDevCenterAS3Name(DataObject.getStringValue((Object)object));
                return;
            }
            case 94: {
                pSDevSlnSysBase.setPSDevCenterAS4Name(DataObject.getStringValue((Object)object));
                return;
            }
            case 95: {
                pSDevSlnSysBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 96: {
                pSDevSlnSysBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 97: {
                pSDevSlnSysBase.setPSDevCenterSVNId(DataObject.getStringValue((Object)object));
                return;
            }
            case 98: {
                pSDevSlnSysBase.setPSDevCenterSVNName(DataObject.getStringValue((Object)object));
                return;
            }
            case 99: {
                pSDevSlnSysBase.setPSDevCenterTSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 100: {
                pSDevSlnSysBase.setPSDevCenterTSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 101: {
                pSDevSlnSysBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 102: {
                pSDevSlnSysBase.setPSDevSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 103: {
                pSDevSlnSysBase.setPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 104: {
                pSDevSlnSysBase.setPSDevSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 105: {
                pSDevSlnSysBase.setPSDevSlnSysResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 106: {
                pSDevSlnSysBase.setPSDevSlnSysResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 107: {
                pSDevSlnSysBase.setPSPFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 108: {
                pSDevSlnSysBase.setPSPFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 109: {
                pSDevSlnSysBase.setPSSFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 110: {
                pSDevSlnSysBase.setPSSFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 111: {
                pSDevSlnSysBase.setPSStudioThemeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 112: {
                pSDevSlnSysBase.setPSStudioThemeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 113: {
                pSDevSlnSysBase.setPSSysModelInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 114: {
                pSDevSlnSysBase.setPSSysModelInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 115: {
                pSDevSlnSysBase.setPSSysPolicyId(DataObject.getStringValue((Object)object));
                return;
            }
            case 116: {
                pSDevSlnSysBase.setPSSysPolicyName(DataObject.getStringValue((Object)object));
                return;
            }
            case 117: {
                pSDevSlnSysBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 118: {
                pSDevSlnSysBase.setPSTaskServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 119: {
                pSDevSlnSysBase.setPSTaskServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 120: {
                pSDevSlnSysBase.setPubCode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 121: {
                pSDevSlnSysBase.setResReadyTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 122: {
                pSDevSlnSysBase.setROGitBranch(DataObject.getStringValue((Object)object));
                return;
            }
            case 123: {
                pSDevSlnSysBase.setROGitPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 124: {
                pSDevSlnSysBase.setROPSDevCenterSvnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 125: {
                pSDevSlnSysBase.setROPSDevCenterSvnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 126: {
                pSDevSlnSysBase.setRTModelPSDevCenterSVNId(DataObject.getStringValue((Object)object));
                return;
            }
            case 127: {
                pSDevSlnSysBase.setRTModelPSDevCenterSVNName(DataObject.getStringValue((Object)object));
                return;
            }
            case 128: {
                pSDevSlnSysBase.setSaaSMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 129: {
                pSDevSlnSysBase.setSFPSSubSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 130: {
                pSDevSlnSysBase.setSFPSSubSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 131: {
                pSDevSlnSysBase.setShareFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 132: {
                pSDevSlnSysBase.setStudioTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 133: {
                pSDevSlnSysBase.setStudioTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 134: {
                pSDevSlnSysBase.setStudioVer(DataObject.getStringValue((Object)object));
                return;
            }
            case 135: {
                pSDevSlnSysBase.setSysFolder(DataObject.getStringValue((Object)object));
                return;
            }
            case 136: {
                pSDevSlnSysBase.setSysMDUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 137: {
                pSDevSlnSysBase.setSysRowKey(DataObject.getStringValue((Object)object));
                return;
            }
            case 138: {
                pSDevSlnSysBase.setSysTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 139: {
                pSDevSlnSysBase.setSysTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 140: {
                pSDevSlnSysBase.setSysTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 141: {
                pSDevSlnSysBase.setSysTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 142: {
                pSDevSlnSysBase.setSysType(DataObject.getStringValue((Object)object));
                return;
            }
            case 143: {
                pSDevSlnSysBase.setSysVer(DataObject.getStringValue((Object)object));
                return;
            }
            case 144: {
                pSDevSlnSysBase.setTemplEngine(DataObject.getStringValue((Object)object));
                return;
            }
            case 145: {
                pSDevSlnSysBase.setThemeCssStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 146: {
                pSDevSlnSysBase.setUnloadTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 147: {
                pSDevSlnSysBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 148: {
                pSDevSlnSysBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 149: {
                pSDevSlnSysBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 150: {
                pSDevSlnSysBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 151: {
                pSDevSlnSysBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 152: {
                pSDevSlnSysBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 153: {
                pSDevSlnSysBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 154: {
                pSDevSlnSysBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 155: {
                pSDevSlnSysBase.setVCType(DataObject.getStringValue((Object)object));
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
        return PSDevSlnSysBase.isNull(this, n);
    }

    private static boolean isNull(PSDevSlnSysBase pSDevSlnSysBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysBase.getActionOwner() == null;
            }
            case 1: {
                return pSDevSlnSysBase.getAPIFlag() == null;
            }
            case 2: {
                return pSDevSlnSysBase.getCallbackTag() == null;
            }
            case 3: {
                return pSDevSlnSysBase.getCallbackUrl() == null;
            }
            case 4: {
                return pSDevSlnSysBase.getCodeName() == null;
            }
            case 5: {
                return pSDevSlnSysBase.getCreateDate() == null;
            }
            case 6: {
                return pSDevSlnSysBase.getCreateMan() == null;
            }
            case 7: {
                return pSDevSlnSysBase.getCurAction() == null;
            }
            case 8: {
                return pSDevSlnSysBase.getDB2PSDCDBInstId() == null;
            }
            case 9: {
                return pSDevSlnSysBase.getDB2PSDCDBInstName() == null;
            }
            case 10: {
                return pSDevSlnSysBase.getDBTypes() == null;
            }
            case 11: {
                return pSDevSlnSysBase.getDBVersion() == null;
            }
            case 12: {
                return pSDevSlnSysBase.getDeploySysId() == null;
            }
            case 13: {
                return pSDevSlnSysBase.getDeploySysOrgId() == null;
            }
            case 14: {
                return pSDevSlnSysBase.getDeploySysOrgSectorId() == null;
            }
            case 15: {
                return pSDevSlnSysBase.getDeploySysTag() == null;
            }
            case 16: {
                return pSDevSlnSysBase.getDeploySysTag2() == null;
            }
            case 17: {
                return pSDevSlnSysBase.getDeploySysType() == null;
            }
            case 18: {
                return pSDevSlnSysBase.getDevResInfo() == null;
            }
            case 19: {
                return pSDevSlnSysBase.getDevResState() == null;
            }
            case 20: {
                return pSDevSlnSysBase.getDevSysState() == null;
            }
            case 21: {
                return pSDevSlnSysBase.getDocGitBranch() == null;
            }
            case 22: {
                return pSDevSlnSysBase.getDocGitPath() == null;
            }
            case 23: {
                return pSDevSlnSysBase.getDocPSDevCenterSVNId() == null;
            }
            case 24: {
                return pSDevSlnSysBase.getDocPSDevCenterSVNName() == null;
            }
            case 25: {
                return pSDevSlnSysBase.getEnableCallback() == null;
            }
            case 26: {
                return pSDevSlnSysBase.getEnableDB2() == null;
            }
            case 27: {
                return pSDevSlnSysBase.getEnableDeployCenter() == null;
            }
            case 28: {
                return pSDevSlnSysBase.getEnableDM() == null;
            }
            case 29: {
                return pSDevSlnSysBase.getEnableDynaSys() == null;
            }
            case 30: {
                return pSDevSlnSysBase.getEnableFolderKey() == null;
            }
            case 31: {
                return pSDevSlnSysBase.getEnableHANA() == null;
            }
            case 32: {
                return pSDevSlnSysBase.getEnableHBase() == null;
            }
            case 33: {
                return pSDevSlnSysBase.getEnableMySQL5() == null;
            }
            case 34: {
                return pSDevSlnSysBase.getEnableOracle() == null;
            }
            case 35: {
                return pSDevSlnSysBase.getEnablePGSQL() == null;
            }
            case 36: {
                return pSDevSlnSysBase.getEnablePPAS() == null;
            }
            case 37: {
                return pSDevSlnSysBase.getEnableSQLite() == null;
            }
            case 38: {
                return pSDevSlnSysBase.getEnableSqlServer() == null;
            }
            case 39: {
                return pSDevSlnSysBase.getEnableWSServer() == null;
            }
            case 40: {
                return pSDevSlnSysBase.getEntityCnt() == null;
            }
            case 41: {
                return pSDevSlnSysBase.getExpriedTime() == null;
            }
            case 42: {
                return pSDevSlnSysBase.getGitBranch() == null;
            }
            case 43: {
                return pSDevSlnSysBase.getGitPath() == null;
            }
            case 44: {
                return pSDevSlnSysBase.getHBasePSDCBDInstId() == null;
            }
            case 45: {
                return pSDevSlnSysBase.getHBasePSDCBDInstName() == null;
            }
            case 46: {
                return pSDevSlnSysBase.getInitParams() == null;
            }
            case 47: {
                return pSDevSlnSysBase.getJITPSDBDevInstId() == null;
            }
            case 48: {
                return pSDevSlnSysBase.getJITPSDBDevInstName() == null;
            }
            case 49: {
                return pSDevSlnSysBase.getJITPSDevCenterTSId() == null;
            }
            case 50: {
                return pSDevSlnSysBase.getJITPSDevCenterTSName() == null;
            }
            case 51: {
                return pSDevSlnSysBase.getLastActiveTime() == null;
            }
            case 52: {
                return pSDevSlnSysBase.getLoadTime() == null;
            }
            case 53: {
                return pSDevSlnSysBase.getLogicName() == null;
            }
            case 54: {
                return pSDevSlnSysBase.getLowCodeMode() == null;
            }
            case 55: {
                return pSDevSlnSysBase.getMainPSDevSlnSysId() == null;
            }
            case 56: {
                return pSDevSlnSysBase.getMainPSDevSlnSysName() == null;
            }
            case 57: {
                return pSDevSlnSysBase.getMaxEntityCnt() == null;
            }
            case 58: {
                return pSDevSlnSysBase.getMemo() == null;
            }
            case 59: {
                return pSDevSlnSysBase.getModelGitBranch() == null;
            }
            case 60: {
                return pSDevSlnSysBase.getModelGitPath() == null;
            }
            case 61: {
                return pSDevSlnSysBase.getModelInstVer() == null;
            }
            case 62: {
                return pSDevSlnSysBase.getModelPrefix() == null;
            }
            case 63: {
                return pSDevSlnSysBase.getModelPSDevCenterSVNId() == null;
            }
            case 64: {
                return pSDevSlnSysBase.getModelPSDevCenterSVNName() == null;
            }
            case 65: {
                return pSDevSlnSysBase.getMSSQLPSDCDBInstId() == null;
            }
            case 66: {
                return pSDevSlnSysBase.getMSSQLPSDCDBInstName() == null;
            }
            case 67: {
                return pSDevSlnSysBase.getMySQLPSDCDBInstId() == null;
            }
            case 68: {
                return pSDevSlnSysBase.getMySQLPSDCDBInstName() == null;
            }
            case 69: {
                return pSDevSlnSysBase.getOfflineTime() == null;
            }
            case 70: {
                return pSDevSlnSysBase.getOraPSDCDBInstId() == null;
            }
            case 71: {
                return pSDevSlnSysBase.getOraPSDCDBInstName() == null;
            }
            case 72: {
                return pSDevSlnSysBase.getPGSQLPSDCDBInstId() == null;
            }
            case 73: {
                return pSDevSlnSysBase.getPGSQLPSDCDBInstName() == null;
            }
            case 74: {
                return pSDevSlnSysBase.getPPASPSDCDBInstId() == null;
            }
            case 75: {
                return pSDevSlnSysBase.getPPASPSDCDBInstName() == null;
            }
            case 76: {
                return pSDevSlnSysBase.getPPSDevSlnSysId() == null;
            }
            case 77: {
                return pSDevSlnSysBase.getPPSDevSlnSysName() == null;
            }
            case 78: {
                return pSDevSlnSysBase.getPSDCDeployCenterId() == null;
            }
            case 79: {
                return pSDevSlnSysBase.getPSDCDeployCenterName() == null;
            }
            case 80: {
                return pSDevSlnSysBase.getPSDCModelTemplId() == null;
            }
            case 81: {
                return pSDevSlnSysBase.getPSDCModelTemplName() == null;
            }
            case 82: {
                return pSDevSlnSysBase.getPSDCRobotId() == null;
            }
            case 83: {
                return pSDevSlnSysBase.getPSDCRobotName() == null;
            }
            case 84: {
                return pSDevSlnSysBase.getPSDCSysLicId() == null;
            }
            case 85: {
                return pSDevSlnSysBase.getPSDCSysLicName() == null;
            }
            case 86: {
                return pSDevSlnSysBase.getPSDCWorkspaceId() == null;
            }
            case 87: {
                return pSDevSlnSysBase.getPSDevCenterASId() == null;
            }
            case 88: {
                return pSDevSlnSysBase.getPSDevCenterASId2() == null;
            }
            case 89: {
                return pSDevSlnSysBase.getPSDevCenterAS3Id() == null;
            }
            case 90: {
                return pSDevSlnSysBase.getPSDevCenterAS4Id() == null;
            }
            case 91: {
                return pSDevSlnSysBase.getPSDevCenterASName() == null;
            }
            case 92: {
                return pSDevSlnSysBase.getPSDevCenterASName2() == null;
            }
            case 93: {
                return pSDevSlnSysBase.getPSDevCenterAS3Name() == null;
            }
            case 94: {
                return pSDevSlnSysBase.getPSDevCenterAS4Name() == null;
            }
            case 95: {
                return pSDevSlnSysBase.getPSDevCenterId() == null;
            }
            case 96: {
                return pSDevSlnSysBase.getPSDevCenterName() == null;
            }
            case 97: {
                return pSDevSlnSysBase.getPSDevCenterSVNId() == null;
            }
            case 98: {
                return pSDevSlnSysBase.getPSDevCenterSVNName() == null;
            }
            case 99: {
                return pSDevSlnSysBase.getPSDevCenterTSId() == null;
            }
            case 100: {
                return pSDevSlnSysBase.getPSDevCenterTSName() == null;
            }
            case 101: {
                return pSDevSlnSysBase.getPSDevSlnId() == null;
            }
            case 102: {
                return pSDevSlnSysBase.getPSDevSlnName() == null;
            }
            case 103: {
                return pSDevSlnSysBase.getPSDevSlnSysId() == null;
            }
            case 104: {
                return pSDevSlnSysBase.getPSDevSlnSysName() == null;
            }
            case 105: {
                return pSDevSlnSysBase.getPSDevSlnSysResId() == null;
            }
            case 106: {
                return pSDevSlnSysBase.getPSDevSlnSysResName() == null;
            }
            case 107: {
                return pSDevSlnSysBase.getPSPFId() == null;
            }
            case 108: {
                return pSDevSlnSysBase.getPSPFName() == null;
            }
            case 109: {
                return pSDevSlnSysBase.getPSSFId() == null;
            }
            case 110: {
                return pSDevSlnSysBase.getPSSFName() == null;
            }
            case 111: {
                return pSDevSlnSysBase.getPSStudioThemeId() == null;
            }
            case 112: {
                return pSDevSlnSysBase.getPSStudioThemeName() == null;
            }
            case 113: {
                return pSDevSlnSysBase.getPSSysModelInstId() == null;
            }
            case 114: {
                return pSDevSlnSysBase.getPSSysModelInstName() == null;
            }
            case 115: {
                return pSDevSlnSysBase.getPSSysPolicyId() == null;
            }
            case 116: {
                return pSDevSlnSysBase.getPSSysPolicyName() == null;
            }
            case 117: {
                return pSDevSlnSysBase.getPSSystemId() == null;
            }
            case 118: {
                return pSDevSlnSysBase.getPSTaskServerId() == null;
            }
            case 119: {
                return pSDevSlnSysBase.getPSTaskServerName() == null;
            }
            case 120: {
                return pSDevSlnSysBase.getPubCode() == null;
            }
            case 121: {
                return pSDevSlnSysBase.getResReadyTime() == null;
            }
            case 122: {
                return pSDevSlnSysBase.getROGitBranch() == null;
            }
            case 123: {
                return pSDevSlnSysBase.getROGitPath() == null;
            }
            case 124: {
                return pSDevSlnSysBase.getROPSDevCenterSvnId() == null;
            }
            case 125: {
                return pSDevSlnSysBase.getROPSDevCenterSvnName() == null;
            }
            case 126: {
                return pSDevSlnSysBase.getRTModelPSDevCenterSVNId() == null;
            }
            case 127: {
                return pSDevSlnSysBase.getRTModelPSDevCenterSVNName() == null;
            }
            case 128: {
                return pSDevSlnSysBase.getSaaSMode() == null;
            }
            case 129: {
                return pSDevSlnSysBase.getSFPSSubSysId() == null;
            }
            case 130: {
                return pSDevSlnSysBase.getSFPSSubSysName() == null;
            }
            case 131: {
                return pSDevSlnSysBase.getShareFlag() == null;
            }
            case 132: {
                return pSDevSlnSysBase.getStudioTag() == null;
            }
            case 133: {
                return pSDevSlnSysBase.getStudioTag2() == null;
            }
            case 134: {
                return pSDevSlnSysBase.getStudioVer() == null;
            }
            case 135: {
                return pSDevSlnSysBase.getSysFolder() == null;
            }
            case 136: {
                return pSDevSlnSysBase.getSysMDUrl() == null;
            }
            case 137: {
                return pSDevSlnSysBase.getSysRowKey() == null;
            }
            case 138: {
                return pSDevSlnSysBase.getSysTag() == null;
            }
            case 139: {
                return pSDevSlnSysBase.getSysTag2() == null;
            }
            case 140: {
                return pSDevSlnSysBase.getSysTag3() == null;
            }
            case 141: {
                return pSDevSlnSysBase.getSysTag4() == null;
            }
            case 142: {
                return pSDevSlnSysBase.getSysType() == null;
            }
            case 143: {
                return pSDevSlnSysBase.getSysVer() == null;
            }
            case 144: {
                return pSDevSlnSysBase.getTemplEngine() == null;
            }
            case 145: {
                return pSDevSlnSysBase.getThemeCssStyle() == null;
            }
            case 146: {
                return pSDevSlnSysBase.getUnloadTime() == null;
            }
            case 147: {
                return pSDevSlnSysBase.getUpdateDate() == null;
            }
            case 148: {
                return pSDevSlnSysBase.getUpdateMan() == null;
            }
            case 149: {
                return pSDevSlnSysBase.getUserCat() == null;
            }
            case 150: {
                return pSDevSlnSysBase.getUserTag() == null;
            }
            case 151: {
                return pSDevSlnSysBase.getUserTag2() == null;
            }
            case 152: {
                return pSDevSlnSysBase.getUserTag3() == null;
            }
            case 153: {
                return pSDevSlnSysBase.getUserTag4() == null;
            }
            case 154: {
                return pSDevSlnSysBase.getValidFlag() == null;
            }
            case 155: {
                return pSDevSlnSysBase.getVCType() == null;
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
        return PSDevSlnSysBase.contains(this, n);
    }

    private static boolean contains(PSDevSlnSysBase pSDevSlnSysBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysBase.isActionOwnerDirty();
            }
            case 1: {
                return pSDevSlnSysBase.isAPIFlagDirty();
            }
            case 2: {
                return pSDevSlnSysBase.isCallbackTagDirty();
            }
            case 3: {
                return pSDevSlnSysBase.isCallbackUrlDirty();
            }
            case 4: {
                return pSDevSlnSysBase.isCodeNameDirty();
            }
            case 5: {
                return pSDevSlnSysBase.isCreateDateDirty();
            }
            case 6: {
                return pSDevSlnSysBase.isCreateManDirty();
            }
            case 7: {
                return pSDevSlnSysBase.isCurActionDirty();
            }
            case 8: {
                return pSDevSlnSysBase.isDB2PSDCDBInstIdDirty();
            }
            case 9: {
                return pSDevSlnSysBase.isDB2PSDCDBInstNameDirty();
            }
            case 10: {
                return pSDevSlnSysBase.isDBTypesDirty();
            }
            case 11: {
                return pSDevSlnSysBase.isDBVersionDirty();
            }
            case 12: {
                return pSDevSlnSysBase.isDeploySysIdDirty();
            }
            case 13: {
                return pSDevSlnSysBase.isDeploySysOrgIdDirty();
            }
            case 14: {
                return pSDevSlnSysBase.isDeploySysOrgSectorIdDirty();
            }
            case 15: {
                return pSDevSlnSysBase.isDeploySysTagDirty();
            }
            case 16: {
                return pSDevSlnSysBase.isDeploySysTag2Dirty();
            }
            case 17: {
                return pSDevSlnSysBase.isDeploySysTypeDirty();
            }
            case 18: {
                return pSDevSlnSysBase.isDevResInfoDirty();
            }
            case 19: {
                return pSDevSlnSysBase.isDevResStateDirty();
            }
            case 20: {
                return pSDevSlnSysBase.isDevSysStateDirty();
            }
            case 21: {
                return pSDevSlnSysBase.isDocGitBranchDirty();
            }
            case 22: {
                return pSDevSlnSysBase.isDocGitPathDirty();
            }
            case 23: {
                return pSDevSlnSysBase.isDocPSDevCenterSVNIdDirty();
            }
            case 24: {
                return pSDevSlnSysBase.isDocPSDevCenterSVNNameDirty();
            }
            case 25: {
                return pSDevSlnSysBase.isEnableCallbackDirty();
            }
            case 26: {
                return pSDevSlnSysBase.isEnableDB2Dirty();
            }
            case 27: {
                return pSDevSlnSysBase.isEnableDeployCenterDirty();
            }
            case 28: {
                return pSDevSlnSysBase.isEnableDMDirty();
            }
            case 29: {
                return pSDevSlnSysBase.isEnableDynaSysDirty();
            }
            case 30: {
                return pSDevSlnSysBase.isEnableFolderKeyDirty();
            }
            case 31: {
                return pSDevSlnSysBase.isEnableHANADirty();
            }
            case 32: {
                return pSDevSlnSysBase.isEnableHBaseDirty();
            }
            case 33: {
                return pSDevSlnSysBase.isEnableMySQL5Dirty();
            }
            case 34: {
                return pSDevSlnSysBase.isEnableOracleDirty();
            }
            case 35: {
                return pSDevSlnSysBase.isEnablePGSQLDirty();
            }
            case 36: {
                return pSDevSlnSysBase.isEnablePPASDirty();
            }
            case 37: {
                return pSDevSlnSysBase.isEnableSQLiteDirty();
            }
            case 38: {
                return pSDevSlnSysBase.isEnableSqlServerDirty();
            }
            case 39: {
                return pSDevSlnSysBase.isEnableWSServerDirty();
            }
            case 40: {
                return pSDevSlnSysBase.isEntityCntDirty();
            }
            case 41: {
                return pSDevSlnSysBase.isExpriedTimeDirty();
            }
            case 42: {
                return pSDevSlnSysBase.isGitBranchDirty();
            }
            case 43: {
                return pSDevSlnSysBase.isGitPathDirty();
            }
            case 44: {
                return pSDevSlnSysBase.isHBasePSDCBDInstIdDirty();
            }
            case 45: {
                return pSDevSlnSysBase.isHBasePSDCBDInstNameDirty();
            }
            case 46: {
                return pSDevSlnSysBase.isInitParamsDirty();
            }
            case 47: {
                return pSDevSlnSysBase.isJITPSDBDevInstIdDirty();
            }
            case 48: {
                return pSDevSlnSysBase.isJITPSDBDevInstNameDirty();
            }
            case 49: {
                return pSDevSlnSysBase.isJITPSDevCenterTSIdDirty();
            }
            case 50: {
                return pSDevSlnSysBase.isJITPSDevCenterTSNameDirty();
            }
            case 51: {
                return pSDevSlnSysBase.isLastActiveTimeDirty();
            }
            case 52: {
                return pSDevSlnSysBase.isLoadTimeDirty();
            }
            case 53: {
                return pSDevSlnSysBase.isLogicNameDirty();
            }
            case 54: {
                return pSDevSlnSysBase.isLowCodeModeDirty();
            }
            case 55: {
                return pSDevSlnSysBase.isMainPSDevSlnSysIdDirty();
            }
            case 56: {
                return pSDevSlnSysBase.isMainPSDevSlnSysNameDirty();
            }
            case 57: {
                return pSDevSlnSysBase.isMaxEntityCntDirty();
            }
            case 58: {
                return pSDevSlnSysBase.isMemoDirty();
            }
            case 59: {
                return pSDevSlnSysBase.isModelGitBranchDirty();
            }
            case 60: {
                return pSDevSlnSysBase.isModelGitPathDirty();
            }
            case 61: {
                return pSDevSlnSysBase.isModelInstVerDirty();
            }
            case 62: {
                return pSDevSlnSysBase.isModelPrefixDirty();
            }
            case 63: {
                return pSDevSlnSysBase.isModelPSDevCenterSVNIdDirty();
            }
            case 64: {
                return pSDevSlnSysBase.isModelPSDevCenterSVNNameDirty();
            }
            case 65: {
                return pSDevSlnSysBase.isMSSQLPSDCDBInstIdDirty();
            }
            case 66: {
                return pSDevSlnSysBase.isMSSQLPSDCDBInstNameDirty();
            }
            case 67: {
                return pSDevSlnSysBase.isMySQLPSDCDBInstIdDirty();
            }
            case 68: {
                return pSDevSlnSysBase.isMySQLPSDCDBInstNameDirty();
            }
            case 69: {
                return pSDevSlnSysBase.isOfflineTimeDirty();
            }
            case 70: {
                return pSDevSlnSysBase.isOraPSDCDBInstIdDirty();
            }
            case 71: {
                return pSDevSlnSysBase.isOraPSDCDBInstNameDirty();
            }
            case 72: {
                return pSDevSlnSysBase.isPGSQLPSDCDBInstIdDirty();
            }
            case 73: {
                return pSDevSlnSysBase.isPGSQLPSDCDBInstNameDirty();
            }
            case 74: {
                return pSDevSlnSysBase.isPPASPSDCDBInstIdDirty();
            }
            case 75: {
                return pSDevSlnSysBase.isPPASPSDCDBInstNameDirty();
            }
            case 76: {
                return pSDevSlnSysBase.isPPSDevSlnSysIdDirty();
            }
            case 77: {
                return pSDevSlnSysBase.isPPSDevSlnSysNameDirty();
            }
            case 78: {
                return pSDevSlnSysBase.isPSDCDeployCenterIdDirty();
            }
            case 79: {
                return pSDevSlnSysBase.isPSDCDeployCenterNameDirty();
            }
            case 80: {
                return pSDevSlnSysBase.isPSDCModelTemplIdDirty();
            }
            case 81: {
                return pSDevSlnSysBase.isPSDCModelTemplNameDirty();
            }
            case 82: {
                return pSDevSlnSysBase.isPSDCRobotIdDirty();
            }
            case 83: {
                return pSDevSlnSysBase.isPSDCRobotNameDirty();
            }
            case 84: {
                return pSDevSlnSysBase.isPSDCSysLicIdDirty();
            }
            case 85: {
                return pSDevSlnSysBase.isPSDCSysLicNameDirty();
            }
            case 86: {
                return pSDevSlnSysBase.isPSDCWorkspaceIdDirty();
            }
            case 87: {
                return pSDevSlnSysBase.isPSDevCenterASIdDirty();
            }
            case 88: {
                return pSDevSlnSysBase.isPSDevCenterASId2Dirty();
            }
            case 89: {
                return pSDevSlnSysBase.isPSDevCenterAS3IdDirty();
            }
            case 90: {
                return pSDevSlnSysBase.isPSDevCenterAS4IdDirty();
            }
            case 91: {
                return pSDevSlnSysBase.isPSDevCenterASNameDirty();
            }
            case 92: {
                return pSDevSlnSysBase.isPSDevCenterASName2Dirty();
            }
            case 93: {
                return pSDevSlnSysBase.isPSDevCenterAS3NameDirty();
            }
            case 94: {
                return pSDevSlnSysBase.isPSDevCenterAS4NameDirty();
            }
            case 95: {
                return pSDevSlnSysBase.isPSDevCenterIdDirty();
            }
            case 96: {
                return pSDevSlnSysBase.isPSDevCenterNameDirty();
            }
            case 97: {
                return pSDevSlnSysBase.isPSDevCenterSVNIdDirty();
            }
            case 98: {
                return pSDevSlnSysBase.isPSDevCenterSVNNameDirty();
            }
            case 99: {
                return pSDevSlnSysBase.isPSDevCenterTSIdDirty();
            }
            case 100: {
                return pSDevSlnSysBase.isPSDevCenterTSNameDirty();
            }
            case 101: {
                return pSDevSlnSysBase.isPSDevSlnIdDirty();
            }
            case 102: {
                return pSDevSlnSysBase.isPSDevSlnNameDirty();
            }
            case 103: {
                return pSDevSlnSysBase.isPSDevSlnSysIdDirty();
            }
            case 104: {
                return pSDevSlnSysBase.isPSDevSlnSysNameDirty();
            }
            case 105: {
                return pSDevSlnSysBase.isPSDevSlnSysResIdDirty();
            }
            case 106: {
                return pSDevSlnSysBase.isPSDevSlnSysResNameDirty();
            }
            case 107: {
                return pSDevSlnSysBase.isPSPFIdDirty();
            }
            case 108: {
                return pSDevSlnSysBase.isPSPFNameDirty();
            }
            case 109: {
                return pSDevSlnSysBase.isPSSFIdDirty();
            }
            case 110: {
                return pSDevSlnSysBase.isPSSFNameDirty();
            }
            case 111: {
                return pSDevSlnSysBase.isPSStudioThemeIdDirty();
            }
            case 112: {
                return pSDevSlnSysBase.isPSStudioThemeNameDirty();
            }
            case 113: {
                return pSDevSlnSysBase.isPSSysModelInstIdDirty();
            }
            case 114: {
                return pSDevSlnSysBase.isPSSysModelInstNameDirty();
            }
            case 115: {
                return pSDevSlnSysBase.isPSSysPolicyIdDirty();
            }
            case 116: {
                return pSDevSlnSysBase.isPSSysPolicyNameDirty();
            }
            case 117: {
                return pSDevSlnSysBase.isPSSystemIdDirty();
            }
            case 118: {
                return pSDevSlnSysBase.isPSTaskServerIdDirty();
            }
            case 119: {
                return pSDevSlnSysBase.isPSTaskServerNameDirty();
            }
            case 120: {
                return pSDevSlnSysBase.isPubCodeDirty();
            }
            case 121: {
                return pSDevSlnSysBase.isResReadyTimeDirty();
            }
            case 122: {
                return pSDevSlnSysBase.isROGitBranchDirty();
            }
            case 123: {
                return pSDevSlnSysBase.isROGitPathDirty();
            }
            case 124: {
                return pSDevSlnSysBase.isROPSDevCenterSvnIdDirty();
            }
            case 125: {
                return pSDevSlnSysBase.isROPSDevCenterSvnNameDirty();
            }
            case 126: {
                return pSDevSlnSysBase.isRTModelPSDevCenterSVNIdDirty();
            }
            case 127: {
                return pSDevSlnSysBase.isRTModelPSDevCenterSVNNameDirty();
            }
            case 128: {
                return pSDevSlnSysBase.isSaaSModeDirty();
            }
            case 129: {
                return pSDevSlnSysBase.isSFPSSubSysIdDirty();
            }
            case 130: {
                return pSDevSlnSysBase.isSFPSSubSysNameDirty();
            }
            case 131: {
                return pSDevSlnSysBase.isShareFlagDirty();
            }
            case 132: {
                return pSDevSlnSysBase.isStudioTagDirty();
            }
            case 133: {
                return pSDevSlnSysBase.isStudioTag2Dirty();
            }
            case 134: {
                return pSDevSlnSysBase.isStudioVerDirty();
            }
            case 135: {
                return pSDevSlnSysBase.isSysFolderDirty();
            }
            case 136: {
                return pSDevSlnSysBase.isSysMDUrlDirty();
            }
            case 137: {
                return pSDevSlnSysBase.isSysRowKeyDirty();
            }
            case 138: {
                return pSDevSlnSysBase.isSysTagDirty();
            }
            case 139: {
                return pSDevSlnSysBase.isSysTag2Dirty();
            }
            case 140: {
                return pSDevSlnSysBase.isSysTag3Dirty();
            }
            case 141: {
                return pSDevSlnSysBase.isSysTag4Dirty();
            }
            case 142: {
                return pSDevSlnSysBase.isSysTypeDirty();
            }
            case 143: {
                return pSDevSlnSysBase.isSysVerDirty();
            }
            case 144: {
                return pSDevSlnSysBase.isTemplEngineDirty();
            }
            case 145: {
                return pSDevSlnSysBase.isThemeCssStyleDirty();
            }
            case 146: {
                return pSDevSlnSysBase.isUnloadTimeDirty();
            }
            case 147: {
                return pSDevSlnSysBase.isUpdateDateDirty();
            }
            case 148: {
                return pSDevSlnSysBase.isUpdateManDirty();
            }
            case 149: {
                return pSDevSlnSysBase.isUserCatDirty();
            }
            case 150: {
                return pSDevSlnSysBase.isUserTagDirty();
            }
            case 151: {
                return pSDevSlnSysBase.isUserTag2Dirty();
            }
            case 152: {
                return pSDevSlnSysBase.isUserTag3Dirty();
            }
            case 153: {
                return pSDevSlnSysBase.isUserTag4Dirty();
            }
            case 154: {
                return pSDevSlnSysBase.isValidFlagDirty();
            }
            case 155: {
                return pSDevSlnSysBase.isVCTypeDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevSlnSysBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevSlnSysBase pSDevSlnSysBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevSlnSysBase.getActionOwner() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionowner", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getActionOwner()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getAPIFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"apiflag", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getAPIFlag()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getCallbackTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"callbacktag", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getCallbackTag()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getCallbackUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"callbackurl", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getCallbackUrl()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getCurAction() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"curaction", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getCurAction()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getDB2PSDCDBInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"db2psdcdbinstid", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getDB2PSDCDBInstId()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getDB2PSDCDBInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"db2psdcdbinstname", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getDB2PSDCDBInstName()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getDBTypes() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dbtypes", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getDBTypes()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getDBVersion() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dbversion", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getDBVersion()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getDeploySysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deploysysid", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getDeploySysId()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getDeploySysOrgId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deploysysorgid", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getDeploySysOrgId()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getDeploySysOrgSectorId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deploysysorgsectorid", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getDeploySysOrgSectorId()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getDeploySysTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deploysystag", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getDeploySysTag()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getDeploySysTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deploysystag2", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getDeploySysTag2()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getDeploySysType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deploysystype", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getDeploySysType()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getDevResInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"devresinfo", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getDevResInfo()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getDevResState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"devresstate", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getDevResState()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getDevSysState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"devsysstate", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getDevSysState()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getDocGitBranch() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"docgitbranch", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getDocGitBranch()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getDocGitPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"docgitpath", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getDocGitPath()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getDocPSDevCenterSVNId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"docpsdevcentersvnid", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getDocPSDevCenterSVNId()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getDocPSDevCenterSVNName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"docpsdevcentersvnname", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getDocPSDevCenterSVNName()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getEnableCallback() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablecallback", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getEnableCallback()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getEnableDB2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enabledb2", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getEnableDB2()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getEnableDeployCenter() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enabledeploycenter", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getEnableDeployCenter()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getEnableDM() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enabledm", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getEnableDM()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getEnableDynaSys() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enabledynasys", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getEnableDynaSys()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getEnableFolderKey() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablefolderkey", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getEnableFolderKey()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getEnableHANA() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablehana", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getEnableHANA()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getEnableHBase() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablehbase", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getEnableHBase()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getEnableMySQL5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablemysql5", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getEnableMySQL5()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getEnableOracle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableoracle", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getEnableOracle()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getEnablePGSQL() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablepgsql", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getEnablePGSQL()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getEnablePPAS() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableppas", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getEnablePPAS()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getEnableSQLite() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablesqlite", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getEnableSQLite()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getEnableSqlServer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablesqlserver", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getEnableSqlServer()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getEnableWSServer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablewsserver", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getEnableWSServer()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getEntityCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"entitycnt", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getEntityCnt()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getExpriedTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"expriedtime", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getExpriedTime()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getGitBranch() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gitbranch", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getGitBranch()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getGitPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gitpath", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getGitPath()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getHBasePSDCBDInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"hbasepsdcbdinstid", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getHBasePSDCBDInstId()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getHBasePSDCBDInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"hbasepsdcbdinstname", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getHBasePSDCBDInstName()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getInitParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"initparams", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getInitParams()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getJITPSDBDevInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"jitpsdbdevinstid", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getJITPSDBDevInstId()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getJITPSDBDevInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"jitpsdbdevinstname", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getJITPSDBDevInstName()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getJITPSDevCenterTSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"jitpsdevcentertsid", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getJITPSDevCenterTSId()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getJITPSDevCenterTSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"jitpsdevcentertsname", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getJITPSDevCenterTSName()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getLastActiveTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lastactivetime", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getLastActiveTime()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getLoadTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"loadtime", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getLoadTime()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getLogicName()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getLowCodeMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lowcodemode", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getLowCodeMode()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getMainPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mainpsdevslnsysid", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getMainPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getMainPSDevSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mainpsdevslnsysname", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getMainPSDevSlnSysName()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getMaxEntityCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxentitycnt", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getMaxEntityCnt()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getModelGitBranch() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelgitbranch", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getModelGitBranch()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getModelGitPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelgitpath", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getModelGitPath()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getModelInstVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelinstver", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getModelInstVer()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getModelPrefix() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelprefix", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getModelPrefix()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getModelPSDevCenterSVNId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelpsdevcentersvnid", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getModelPSDevCenterSVNId()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getModelPSDevCenterSVNName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelpsdevcentersvnname", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getModelPSDevCenterSVNName()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getMSSQLPSDCDBInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mssqlpsdcdbinstid", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getMSSQLPSDCDBInstId()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getMSSQLPSDCDBInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mssqlpsdcdbinstname", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getMSSQLPSDCDBInstName()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getMySQLPSDCDBInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mysqlpsdcdbinstid", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getMySQLPSDCDBInstId()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getMySQLPSDCDBInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mysqlpsdcdbinstname", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getMySQLPSDCDBInstName()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getOfflineTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"offlinetime", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getOfflineTime()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getOraPSDCDBInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"orapsdcdbinstid", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getOraPSDCDBInstId()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getOraPSDCDBInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"orapsdcdbinstname", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getOraPSDCDBInstName()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getPGSQLPSDCDBInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pgsqlpsdcdbinstid", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getPGSQLPSDCDBInstId()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getPGSQLPSDCDBInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pgsqlpsdcdbinstname", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getPGSQLPSDCDBInstName()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getPPASPSDCDBInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppaspsdcdbinstid", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getPPASPSDCDBInstId()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getPPASPSDCDBInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppaspsdcdbinstname", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getPPASPSDCDBInstName()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getPPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsdevslnsysid", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getPPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getPPSDevSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsdevslnsysname", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getPPSDevSlnSysName()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getPSDCDeployCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcdeploycenterid", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getPSDCDeployCenterId()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getPSDCDeployCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcdeploycentername", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getPSDCDeployCenterName()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getPSDCModelTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmodeltemplid", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getPSDCModelTemplId()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getPSDCModelTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmodeltemplname", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getPSDCModelTemplName()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getPSDCRobotId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcrobotid", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getPSDCRobotId()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getPSDCRobotName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcrobotname", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getPSDCRobotName()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getPSDCSysLicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcsyslicid", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getPSDCSysLicId()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getPSDCSysLicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcsyslicname", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getPSDCSysLicName()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getPSDCWorkspaceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcworkspaceid", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getPSDCWorkspaceId()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getPSDevCenterASId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterasid", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getPSDevCenterASId()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getPSDevCenterASId2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterasid2", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getPSDevCenterASId2()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getPSDevCenterAS3Id() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterasid3", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getPSDevCenterAS3Id()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getPSDevCenterAS4Id() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterasid4", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getPSDevCenterAS4Id()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getPSDevCenterASName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterasname", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getPSDevCenterASName()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getPSDevCenterASName2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterasname2", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getPSDevCenterASName2()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getPSDevCenterAS3Name() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterasname3", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getPSDevCenterAS3Name()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getPSDevCenterAS4Name() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterasname4", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getPSDevCenterAS4Name()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getPSDevCenterSVNId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentersvnid", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getPSDevCenterSVNId()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getPSDevCenterSVNName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentersvnname", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getPSDevCenterSVNName()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getPSDevCenterTSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentertsid", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getPSDevCenterTSId()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getPSDevCenterTSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentertsname", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getPSDevCenterTSName()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getPSDevSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnname", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getPSDevSlnName()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysid", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getPSDevSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysname", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getPSDevSlnSysName()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getPSDevSlnSysResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysresid", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getPSDevSlnSysResId()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getPSDevSlnSysResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysresname", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getPSDevSlnSysResName()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getPSPFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfid", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getPSPFId()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getPSPFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfname", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getPSPFName()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getPSSFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfid", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getPSSFId()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getPSSFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfname", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getPSSFName()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getPSStudioThemeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psstudiothemeid", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getPSStudioThemeId()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getPSStudioThemeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psstudiothemename", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getPSStudioThemeName()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getPSSysModelInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelinstid", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getPSSysModelInstId()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getPSSysModelInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelinstname", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getPSSysModelInstName()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getPSSysPolicyId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspolicyid", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getPSSysPolicyId()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getPSSysPolicyName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspolicyname", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getPSSysPolicyName()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getPSTaskServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskserverid", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getPSTaskServerId()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getPSTaskServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskservername", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getPSTaskServerName()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getPubCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubcode", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getPubCode()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getResReadyTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resreadytime", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getResReadyTime()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getROGitBranch() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rogitbranch", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getROGitBranch()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getROGitPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rogitpath", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getROGitPath()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getROPSDevCenterSvnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ropsdevcentersvnid", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getROPSDevCenterSvnId()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getROPSDevCenterSvnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ropsdevcentersvnname", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getROPSDevCenterSvnName()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getRTModelPSDevCenterSVNId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rtmodelpsdevcentersvnid", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getRTModelPSDevCenterSVNId()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getRTModelPSDevCenterSVNName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rtmodelpsdevcentersvnname", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getRTModelPSDevCenterSVNName()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getSaaSMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"saasmode", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getSaaSMode()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getSFPSSubSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sfpssubsysid", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getSFPSSubSysId()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getSFPSSubSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sfpssubsysname", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getSFPSSubSysName()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getShareFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"shareflag", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getShareFlag()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getStudioTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"studiotag", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getStudioTag()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getStudioTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"studiotag2", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getStudioTag2()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getStudioVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"studiover", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getStudioVer()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getSysFolder() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sysfolder", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getSysFolder()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getSysMDUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sysmdurl", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getSysMDUrl()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getSysRowKey() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sysrowkey", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getSysRowKey()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getSysTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"systag", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getSysTag()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getSysTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"systag2", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getSysTag2()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getSysTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"systag3", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getSysTag3()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getSysTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"systag4", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getSysTag4()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getSysType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"systype", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getSysType()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getSysVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sysver", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getSysVer()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getTemplEngine() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templengine", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getTemplEngine()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getThemeCssStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"themecssstyle", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getThemeCssStyle()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getUnloadTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"unloadtime", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getUnloadTime()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSDevSlnSysBase.getVCType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"vctype", (Object)PSDevSlnSysBase.getJSONValue((Object)pSDevSlnSysBase.getVCType()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevSlnSysBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevSlnSysBase pSDevSlnSysBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevSlnSysBase.getActionOwner() != null) {
            object = pSDevSlnSysBase.getActionOwner();
            xmlNode.setAttribute(FIELD_ACTIONOWNER, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getAPIFlag() != null) {
            object = pSDevSlnSysBase.getAPIFlag();
            xmlNode.setAttribute(FIELD_APIFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysBase.getCallbackTag() != null) {
            object = pSDevSlnSysBase.getCallbackTag();
            xmlNode.setAttribute(FIELD_CALLBACKTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getCallbackUrl() != null) {
            object = pSDevSlnSysBase.getCallbackUrl();
            xmlNode.setAttribute(FIELD_CALLBACKURL, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getCodeName() != null) {
            object = pSDevSlnSysBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getCreateDate() != null) {
            object = pSDevSlnSysBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysBase.getCreateMan() != null) {
            object = pSDevSlnSysBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getCurAction() != null) {
            object = pSDevSlnSysBase.getCurAction();
            xmlNode.setAttribute(FIELD_CURACTION, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getDB2PSDCDBInstId() != null) {
            object = pSDevSlnSysBase.getDB2PSDCDBInstId();
            xmlNode.setAttribute(FIELD_DB2PSDCDBINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getDB2PSDCDBInstName() != null) {
            object = pSDevSlnSysBase.getDB2PSDCDBInstName();
            xmlNode.setAttribute(FIELD_DB2PSDCDBINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getDBTypes() != null) {
            object = pSDevSlnSysBase.getDBTypes();
            xmlNode.setAttribute(FIELD_DBTYPES, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getDBVersion() != null) {
            object = pSDevSlnSysBase.getDBVersion();
            xmlNode.setAttribute(FIELD_DBVERSION, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysBase.getDeploySysId() != null) {
            object = pSDevSlnSysBase.getDeploySysId();
            xmlNode.setAttribute(FIELD_DEPLOYSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getDeploySysOrgId() != null) {
            object = pSDevSlnSysBase.getDeploySysOrgId();
            xmlNode.setAttribute(FIELD_DEPLOYSYSORGID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getDeploySysOrgSectorId() != null) {
            object = pSDevSlnSysBase.getDeploySysOrgSectorId();
            xmlNode.setAttribute(FIELD_DEPLOYSYSORGSECTORID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getDeploySysTag() != null) {
            object = pSDevSlnSysBase.getDeploySysTag();
            xmlNode.setAttribute(FIELD_DEPLOYSYSTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getDeploySysTag2() != null) {
            object = pSDevSlnSysBase.getDeploySysTag2();
            xmlNode.setAttribute(FIELD_DEPLOYSYSTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getDeploySysType() != null) {
            object = pSDevSlnSysBase.getDeploySysType();
            xmlNode.setAttribute(FIELD_DEPLOYSYSTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getDevResInfo() != null) {
            object = pSDevSlnSysBase.getDevResInfo();
            xmlNode.setAttribute(FIELD_DEVRESINFO, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getDevResState() != null) {
            object = pSDevSlnSysBase.getDevResState();
            xmlNode.setAttribute(FIELD_DEVRESSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysBase.getDevSysState() != null) {
            object = pSDevSlnSysBase.getDevSysState();
            xmlNode.setAttribute(FIELD_DEVSYSSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysBase.getDocGitBranch() != null) {
            object = pSDevSlnSysBase.getDocGitBranch();
            xmlNode.setAttribute(FIELD_DOCGITBRANCH, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getDocGitPath() != null) {
            object = pSDevSlnSysBase.getDocGitPath();
            xmlNode.setAttribute(FIELD_DOCGITPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getDocPSDevCenterSVNId() != null) {
            object = pSDevSlnSysBase.getDocPSDevCenterSVNId();
            xmlNode.setAttribute(FIELD_DOCPSDEVCENTERSVNID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getDocPSDevCenterSVNName() != null) {
            object = pSDevSlnSysBase.getDocPSDevCenterSVNName();
            xmlNode.setAttribute(FIELD_DOCPSDEVCENTERSVNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getEnableCallback() != null) {
            object = pSDevSlnSysBase.getEnableCallback();
            xmlNode.setAttribute(FIELD_ENABLECALLBACK, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysBase.getEnableDB2() != null) {
            object = pSDevSlnSysBase.getEnableDB2();
            xmlNode.setAttribute(FIELD_ENABLEDB2, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysBase.getEnableDeployCenter() != null) {
            object = pSDevSlnSysBase.getEnableDeployCenter();
            xmlNode.setAttribute(FIELD_ENABLEDEPLOYCENTER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysBase.getEnableDM() != null) {
            object = pSDevSlnSysBase.getEnableDM();
            xmlNode.setAttribute(FIELD_ENABLEDM, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysBase.getEnableDynaSys() != null) {
            object = pSDevSlnSysBase.getEnableDynaSys();
            xmlNode.setAttribute(FIELD_ENABLEDYNASYS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysBase.getEnableFolderKey() != null) {
            object = pSDevSlnSysBase.getEnableFolderKey();
            xmlNode.setAttribute(FIELD_ENABLEFOLDERKEY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysBase.getEnableHANA() != null) {
            object = pSDevSlnSysBase.getEnableHANA();
            xmlNode.setAttribute(FIELD_ENABLEHANA, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysBase.getEnableHBase() != null) {
            object = pSDevSlnSysBase.getEnableHBase();
            xmlNode.setAttribute(FIELD_ENABLEHBASE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysBase.getEnableMySQL5() != null) {
            object = pSDevSlnSysBase.getEnableMySQL5();
            xmlNode.setAttribute(FIELD_ENABLEMYSQL5, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysBase.getEnableOracle() != null) {
            object = pSDevSlnSysBase.getEnableOracle();
            xmlNode.setAttribute(FIELD_ENABLEORACLE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysBase.getEnablePGSQL() != null) {
            object = pSDevSlnSysBase.getEnablePGSQL();
            xmlNode.setAttribute(FIELD_ENABLEPGSQL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysBase.getEnablePPAS() != null) {
            object = pSDevSlnSysBase.getEnablePPAS();
            xmlNode.setAttribute(FIELD_ENABLEPPAS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysBase.getEnableSQLite() != null) {
            object = pSDevSlnSysBase.getEnableSQLite();
            xmlNode.setAttribute(FIELD_ENABLESQLITE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysBase.getEnableSqlServer() != null) {
            object = pSDevSlnSysBase.getEnableSqlServer();
            xmlNode.setAttribute(FIELD_ENABLESQLSERVER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysBase.getEnableWSServer() != null) {
            object = pSDevSlnSysBase.getEnableWSServer();
            xmlNode.setAttribute(FIELD_ENABLEWSSERVER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysBase.getEntityCnt() != null) {
            object = pSDevSlnSysBase.getEntityCnt();
            xmlNode.setAttribute(FIELD_ENTITYCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysBase.getExpriedTime() != null) {
            object = pSDevSlnSysBase.getExpriedTime();
            xmlNode.setAttribute(FIELD_EXPRIEDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysBase.getGitBranch() != null) {
            object = pSDevSlnSysBase.getGitBranch();
            xmlNode.setAttribute(FIELD_GITBRANCH, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getGitPath() != null) {
            object = pSDevSlnSysBase.getGitPath();
            xmlNode.setAttribute(FIELD_GITPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getHBasePSDCBDInstId() != null) {
            object = pSDevSlnSysBase.getHBasePSDCBDInstId();
            xmlNode.setAttribute(FIELD_HBASEPSDCBDINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getHBasePSDCBDInstName() != null) {
            object = pSDevSlnSysBase.getHBasePSDCBDInstName();
            xmlNode.setAttribute(FIELD_HBASEPSDCBDINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getInitParams() != null) {
            object = pSDevSlnSysBase.getInitParams();
            xmlNode.setAttribute(FIELD_INITPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getJITPSDBDevInstId() != null) {
            object = pSDevSlnSysBase.getJITPSDBDevInstId();
            xmlNode.setAttribute(FIELD_JITPSDBDEVINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getJITPSDBDevInstName() != null) {
            object = pSDevSlnSysBase.getJITPSDBDevInstName();
            xmlNode.setAttribute(FIELD_JITPSDBDEVINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getJITPSDevCenterTSId() != null) {
            object = pSDevSlnSysBase.getJITPSDevCenterTSId();
            xmlNode.setAttribute(FIELD_JITPSDEVCENTERTSID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getJITPSDevCenterTSName() != null) {
            object = pSDevSlnSysBase.getJITPSDevCenterTSName();
            xmlNode.setAttribute(FIELD_JITPSDEVCENTERTSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getLastActiveTime() != null) {
            object = pSDevSlnSysBase.getLastActiveTime();
            xmlNode.setAttribute(FIELD_LASTACTIVETIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysBase.getLoadTime() != null) {
            object = pSDevSlnSysBase.getLoadTime();
            xmlNode.setAttribute(FIELD_LOADTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysBase.getLogicName() != null) {
            object = pSDevSlnSysBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getLowCodeMode() != null) {
            object = pSDevSlnSysBase.getLowCodeMode();
            xmlNode.setAttribute(FIELD_LOWCODEMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysBase.getMainPSDevSlnSysId() != null) {
            object = pSDevSlnSysBase.getMainPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_MAINPSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getMainPSDevSlnSysName() != null) {
            object = pSDevSlnSysBase.getMainPSDevSlnSysName();
            xmlNode.setAttribute(FIELD_MAINPSDEVSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getMaxEntityCnt() != null) {
            object = pSDevSlnSysBase.getMaxEntityCnt();
            xmlNode.setAttribute(FIELD_MAXENTITYCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysBase.getMemo() != null) {
            object = pSDevSlnSysBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getModelGitBranch() != null) {
            object = pSDevSlnSysBase.getModelGitBranch();
            xmlNode.setAttribute(FIELD_MODELGITBRANCH, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getModelGitPath() != null) {
            object = pSDevSlnSysBase.getModelGitPath();
            xmlNode.setAttribute(FIELD_MODELGITPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getModelInstVer() != null) {
            object = pSDevSlnSysBase.getModelInstVer();
            xmlNode.setAttribute(FIELD_MODELINSTVER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysBase.getModelPrefix() != null) {
            object = pSDevSlnSysBase.getModelPrefix();
            xmlNode.setAttribute(FIELD_MODELPREFIX, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getModelPSDevCenterSVNId() != null) {
            object = pSDevSlnSysBase.getModelPSDevCenterSVNId();
            xmlNode.setAttribute(FIELD_MODELPSDEVCENTERSVNID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getModelPSDevCenterSVNName() != null) {
            object = pSDevSlnSysBase.getModelPSDevCenterSVNName();
            xmlNode.setAttribute(FIELD_MODELPSDEVCENTERSVNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getMSSQLPSDCDBInstId() != null) {
            object = pSDevSlnSysBase.getMSSQLPSDCDBInstId();
            xmlNode.setAttribute(FIELD_MSSQLPSDCDBINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getMSSQLPSDCDBInstName() != null) {
            object = pSDevSlnSysBase.getMSSQLPSDCDBInstName();
            xmlNode.setAttribute(FIELD_MSSQLPSDCDBINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getMySQLPSDCDBInstId() != null) {
            object = pSDevSlnSysBase.getMySQLPSDCDBInstId();
            xmlNode.setAttribute(FIELD_MYSQLPSDCDBINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getMySQLPSDCDBInstName() != null) {
            object = pSDevSlnSysBase.getMySQLPSDCDBInstName();
            xmlNode.setAttribute(FIELD_MYSQLPSDCDBINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getOfflineTime() != null) {
            object = pSDevSlnSysBase.getOfflineTime();
            xmlNode.setAttribute(FIELD_OFFLINETIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysBase.getOraPSDCDBInstId() != null) {
            object = pSDevSlnSysBase.getOraPSDCDBInstId();
            xmlNode.setAttribute(FIELD_ORAPSDCDBINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getOraPSDCDBInstName() != null) {
            object = pSDevSlnSysBase.getOraPSDCDBInstName();
            xmlNode.setAttribute(FIELD_ORAPSDCDBINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getPGSQLPSDCDBInstId() != null) {
            object = pSDevSlnSysBase.getPGSQLPSDCDBInstId();
            xmlNode.setAttribute(FIELD_PGSQLPSDCDBINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getPGSQLPSDCDBInstName() != null) {
            object = pSDevSlnSysBase.getPGSQLPSDCDBInstName();
            xmlNode.setAttribute(FIELD_PGSQLPSDCDBINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getPPASPSDCDBInstId() != null) {
            object = pSDevSlnSysBase.getPPASPSDCDBInstId();
            xmlNode.setAttribute(FIELD_PPASPSDCDBINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getPPASPSDCDBInstName() != null) {
            object = pSDevSlnSysBase.getPPASPSDCDBInstName();
            xmlNode.setAttribute(FIELD_PPASPSDCDBINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getPPSDevSlnSysId() != null) {
            object = pSDevSlnSysBase.getPPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PPSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getPPSDevSlnSysName() != null) {
            object = pSDevSlnSysBase.getPPSDevSlnSysName();
            xmlNode.setAttribute(FIELD_PPSDEVSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getPSDCDeployCenterId() != null) {
            object = pSDevSlnSysBase.getPSDCDeployCenterId();
            xmlNode.setAttribute(FIELD_PSDCDEPLOYCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getPSDCDeployCenterName() != null) {
            object = pSDevSlnSysBase.getPSDCDeployCenterName();
            xmlNode.setAttribute(FIELD_PSDCDEPLOYCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getPSDCModelTemplId() != null) {
            object = pSDevSlnSysBase.getPSDCModelTemplId();
            xmlNode.setAttribute(FIELD_PSDCMODELTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getPSDCModelTemplName() != null) {
            object = pSDevSlnSysBase.getPSDCModelTemplName();
            xmlNode.setAttribute(FIELD_PSDCMODELTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getPSDCRobotId() != null) {
            object = pSDevSlnSysBase.getPSDCRobotId();
            xmlNode.setAttribute(FIELD_PSDCROBOTID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getPSDCRobotName() != null) {
            object = pSDevSlnSysBase.getPSDCRobotName();
            xmlNode.setAttribute(FIELD_PSDCROBOTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getPSDCSysLicId() != null) {
            object = pSDevSlnSysBase.getPSDCSysLicId();
            xmlNode.setAttribute(FIELD_PSDCSYSLICID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getPSDCSysLicName() != null) {
            object = pSDevSlnSysBase.getPSDCSysLicName();
            xmlNode.setAttribute(FIELD_PSDCSYSLICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getPSDCWorkspaceId() != null) {
            object = pSDevSlnSysBase.getPSDCWorkspaceId();
            xmlNode.setAttribute(FIELD_PSDCWORKSPACEID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getPSDevCenterASId() != null) {
            object = pSDevSlnSysBase.getPSDevCenterASId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERASID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getPSDevCenterASId2() != null) {
            object = pSDevSlnSysBase.getPSDevCenterASId2();
            xmlNode.setAttribute(FIELD_PSDEVCENTERASID2, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getPSDevCenterAS3Id() != null) {
            object = pSDevSlnSysBase.getPSDevCenterAS3Id();
            xmlNode.setAttribute("PSDEVCENTERAS3ID", object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getPSDevCenterAS4Id() != null) {
            object = pSDevSlnSysBase.getPSDevCenterAS4Id();
            xmlNode.setAttribute("PSDEVCENTERAS4ID", object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getPSDevCenterASName() != null) {
            object = pSDevSlnSysBase.getPSDevCenterASName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERASNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getPSDevCenterASName2() != null) {
            object = pSDevSlnSysBase.getPSDevCenterASName2();
            xmlNode.setAttribute(FIELD_PSDEVCENTERASNAME2, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getPSDevCenterAS3Name() != null) {
            object = pSDevSlnSysBase.getPSDevCenterAS3Name();
            xmlNode.setAttribute("PSDEVCENTERAS3NAME", object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getPSDevCenterAS4Name() != null) {
            object = pSDevSlnSysBase.getPSDevCenterAS4Name();
            xmlNode.setAttribute("PSDEVCENTERAS4NAME", object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getPSDevCenterId() != null) {
            object = pSDevSlnSysBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getPSDevCenterName() != null) {
            object = pSDevSlnSysBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getPSDevCenterSVNId() != null) {
            object = pSDevSlnSysBase.getPSDevCenterSVNId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERSVNID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getPSDevCenterSVNName() != null) {
            object = pSDevSlnSysBase.getPSDevCenterSVNName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERSVNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getPSDevCenterTSId() != null) {
            object = pSDevSlnSysBase.getPSDevCenterTSId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERTSID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getPSDevCenterTSName() != null) {
            object = pSDevSlnSysBase.getPSDevCenterTSName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERTSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getPSDevSlnId() != null) {
            object = pSDevSlnSysBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getPSDevSlnName() != null) {
            object = pSDevSlnSysBase.getPSDevSlnName();
            xmlNode.setAttribute(FIELD_PSDEVSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getPSDevSlnSysId() != null) {
            object = pSDevSlnSysBase.getPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getPSDevSlnSysName() != null) {
            object = pSDevSlnSysBase.getPSDevSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getPSDevSlnSysResId() != null) {
            object = pSDevSlnSysBase.getPSDevSlnSysResId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getPSDevSlnSysResName() != null) {
            object = pSDevSlnSysBase.getPSDevSlnSysResName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getPSPFId() != null) {
            object = pSDevSlnSysBase.getPSPFId();
            xmlNode.setAttribute(FIELD_PSPFID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getPSPFName() != null) {
            object = pSDevSlnSysBase.getPSPFName();
            xmlNode.setAttribute(FIELD_PSPFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getPSSFId() != null) {
            object = pSDevSlnSysBase.getPSSFId();
            xmlNode.setAttribute(FIELD_PSSFID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getPSSFName() != null) {
            object = pSDevSlnSysBase.getPSSFName();
            xmlNode.setAttribute(FIELD_PSSFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getPSStudioThemeId() != null) {
            object = pSDevSlnSysBase.getPSStudioThemeId();
            xmlNode.setAttribute(FIELD_PSSTUDIOTHEMEID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getPSStudioThemeName() != null) {
            object = pSDevSlnSysBase.getPSStudioThemeName();
            xmlNode.setAttribute(FIELD_PSSTUDIOTHEMENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getPSSysModelInstId() != null) {
            object = pSDevSlnSysBase.getPSSysModelInstId();
            xmlNode.setAttribute(FIELD_PSSYSMODELINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getPSSysModelInstName() != null) {
            object = pSDevSlnSysBase.getPSSysModelInstName();
            xmlNode.setAttribute(FIELD_PSSYSMODELINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getPSSysPolicyId() != null) {
            object = pSDevSlnSysBase.getPSSysPolicyId();
            xmlNode.setAttribute(FIELD_PSSYSPOLICYID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getPSSysPolicyName() != null) {
            object = pSDevSlnSysBase.getPSSysPolicyName();
            xmlNode.setAttribute(FIELD_PSSYSPOLICYNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getPSSystemId() != null) {
            object = pSDevSlnSysBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getPSTaskServerId() != null) {
            object = pSDevSlnSysBase.getPSTaskServerId();
            xmlNode.setAttribute(FIELD_PSTASKSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getPSTaskServerName() != null) {
            object = pSDevSlnSysBase.getPSTaskServerName();
            xmlNode.setAttribute(FIELD_PSTASKSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getPubCode() != null) {
            object = pSDevSlnSysBase.getPubCode();
            xmlNode.setAttribute(FIELD_PUBCODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysBase.getResReadyTime() != null) {
            object = pSDevSlnSysBase.getResReadyTime();
            xmlNode.setAttribute(FIELD_RESREADYTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysBase.getROGitBranch() != null) {
            object = pSDevSlnSysBase.getROGitBranch();
            xmlNode.setAttribute(FIELD_ROGITBRANCH, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getROGitPath() != null) {
            object = pSDevSlnSysBase.getROGitPath();
            xmlNode.setAttribute(FIELD_ROGITPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getROPSDevCenterSvnId() != null) {
            object = pSDevSlnSysBase.getROPSDevCenterSvnId();
            xmlNode.setAttribute(FIELD_ROPSDEVCENTERSVNID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getROPSDevCenterSvnName() != null) {
            object = pSDevSlnSysBase.getROPSDevCenterSvnName();
            xmlNode.setAttribute(FIELD_ROPSDEVCENTERSVNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getRTModelPSDevCenterSVNId() != null) {
            object = pSDevSlnSysBase.getRTModelPSDevCenterSVNId();
            xmlNode.setAttribute(FIELD_RTMODELPSDEVCENTERSVNID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getRTModelPSDevCenterSVNName() != null) {
            object = pSDevSlnSysBase.getRTModelPSDevCenterSVNName();
            xmlNode.setAttribute(FIELD_RTMODELPSDEVCENTERSVNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getSaaSMode() != null) {
            object = pSDevSlnSysBase.getSaaSMode();
            xmlNode.setAttribute(FIELD_SAASMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysBase.getSFPSSubSysId() != null) {
            object = pSDevSlnSysBase.getSFPSSubSysId();
            xmlNode.setAttribute(FIELD_SFPSSUBSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getSFPSSubSysName() != null) {
            object = pSDevSlnSysBase.getSFPSSubSysName();
            xmlNode.setAttribute(FIELD_SFPSSUBSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getShareFlag() != null) {
            object = pSDevSlnSysBase.getShareFlag();
            xmlNode.setAttribute(FIELD_SHAREFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysBase.getStudioTag() != null) {
            object = pSDevSlnSysBase.getStudioTag();
            xmlNode.setAttribute(FIELD_STUDIOTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getStudioTag2() != null) {
            object = pSDevSlnSysBase.getStudioTag2();
            xmlNode.setAttribute(FIELD_STUDIOTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getStudioVer() != null) {
            object = pSDevSlnSysBase.getStudioVer();
            xmlNode.setAttribute(FIELD_STUDIOVER, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getSysFolder() != null) {
            object = pSDevSlnSysBase.getSysFolder();
            xmlNode.setAttribute(FIELD_SYSFOLDER, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getSysMDUrl() != null) {
            object = pSDevSlnSysBase.getSysMDUrl();
            xmlNode.setAttribute(FIELD_SYSMDURL, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getSysRowKey() != null) {
            object = pSDevSlnSysBase.getSysRowKey();
            xmlNode.setAttribute(FIELD_SYSROWKEY, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getSysTag() != null) {
            object = pSDevSlnSysBase.getSysTag();
            xmlNode.setAttribute(FIELD_SYSTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getSysTag2() != null) {
            object = pSDevSlnSysBase.getSysTag2();
            xmlNode.setAttribute(FIELD_SYSTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getSysTag3() != null) {
            object = pSDevSlnSysBase.getSysTag3();
            xmlNode.setAttribute(FIELD_SYSTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getSysTag4() != null) {
            object = pSDevSlnSysBase.getSysTag4();
            xmlNode.setAttribute(FIELD_SYSTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getSysType() != null) {
            object = pSDevSlnSysBase.getSysType();
            xmlNode.setAttribute(FIELD_SYSTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getSysVer() != null) {
            object = pSDevSlnSysBase.getSysVer();
            xmlNode.setAttribute(FIELD_SYSVER, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getTemplEngine() != null) {
            object = pSDevSlnSysBase.getTemplEngine();
            xmlNode.setAttribute(FIELD_TEMPLENGINE, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getThemeCssStyle() != null) {
            object = pSDevSlnSysBase.getThemeCssStyle();
            xmlNode.setAttribute(FIELD_THEMECSSSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getUnloadTime() != null) {
            object = pSDevSlnSysBase.getUnloadTime();
            xmlNode.setAttribute(FIELD_UNLOADTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysBase.getUpdateDate() != null) {
            object = pSDevSlnSysBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysBase.getUpdateMan() != null) {
            object = pSDevSlnSysBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getUserCat() != null) {
            object = pSDevSlnSysBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getUserTag() != null) {
            object = pSDevSlnSysBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getUserTag2() != null) {
            object = pSDevSlnSysBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getUserTag3() != null) {
            object = pSDevSlnSysBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getUserTag4() != null) {
            object = pSDevSlnSysBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBase.getValidFlag() != null) {
            object = pSDevSlnSysBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysBase.getVCType() != null) {
            object = pSDevSlnSysBase.getVCType();
            xmlNode.setAttribute(FIELD_VCTYPE, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevSlnSysBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevSlnSysBase pSDevSlnSysBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevSlnSysBase.isActionOwnerDirty() && (bl || pSDevSlnSysBase.getActionOwner() != null)) {
            iDataObject.set(FIELD_ACTIONOWNER, (Object)pSDevSlnSysBase.getActionOwner());
        }
        if (pSDevSlnSysBase.isAPIFlagDirty() && (bl || pSDevSlnSysBase.getAPIFlag() != null)) {
            iDataObject.set(FIELD_APIFLAG, (Object)pSDevSlnSysBase.getAPIFlag());
        }
        if (pSDevSlnSysBase.isCallbackTagDirty() && (bl || pSDevSlnSysBase.getCallbackTag() != null)) {
            iDataObject.set(FIELD_CALLBACKTAG, (Object)pSDevSlnSysBase.getCallbackTag());
        }
        if (pSDevSlnSysBase.isCallbackUrlDirty() && (bl || pSDevSlnSysBase.getCallbackUrl() != null)) {
            iDataObject.set(FIELD_CALLBACKURL, (Object)pSDevSlnSysBase.getCallbackUrl());
        }
        if (pSDevSlnSysBase.isCodeNameDirty() && (bl || pSDevSlnSysBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDevSlnSysBase.getCodeName());
        }
        if (pSDevSlnSysBase.isCreateDateDirty() && (bl || pSDevSlnSysBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevSlnSysBase.getCreateDate());
        }
        if (pSDevSlnSysBase.isCreateManDirty() && (bl || pSDevSlnSysBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevSlnSysBase.getCreateMan());
        }
        if (pSDevSlnSysBase.isCurActionDirty() && (bl || pSDevSlnSysBase.getCurAction() != null)) {
            iDataObject.set(FIELD_CURACTION, (Object)pSDevSlnSysBase.getCurAction());
        }
        if (pSDevSlnSysBase.isDB2PSDCDBInstIdDirty() && (bl || pSDevSlnSysBase.getDB2PSDCDBInstId() != null)) {
            iDataObject.set(FIELD_DB2PSDCDBINSTID, (Object)pSDevSlnSysBase.getDB2PSDCDBInstId());
        }
        if (pSDevSlnSysBase.isDB2PSDCDBInstNameDirty() && (bl || pSDevSlnSysBase.getDB2PSDCDBInstName() != null)) {
            iDataObject.set(FIELD_DB2PSDCDBINSTNAME, (Object)pSDevSlnSysBase.getDB2PSDCDBInstName());
        }
        if (pSDevSlnSysBase.isDBTypesDirty() && (bl || pSDevSlnSysBase.getDBTypes() != null)) {
            iDataObject.set(FIELD_DBTYPES, (Object)pSDevSlnSysBase.getDBTypes());
        }
        if (pSDevSlnSysBase.isDBVersionDirty() && (bl || pSDevSlnSysBase.getDBVersion() != null)) {
            iDataObject.set(FIELD_DBVERSION, (Object)pSDevSlnSysBase.getDBVersion());
        }
        if (pSDevSlnSysBase.isDeploySysIdDirty() && (bl || pSDevSlnSysBase.getDeploySysId() != null)) {
            iDataObject.set(FIELD_DEPLOYSYSID, (Object)pSDevSlnSysBase.getDeploySysId());
        }
        if (pSDevSlnSysBase.isDeploySysOrgIdDirty() && (bl || pSDevSlnSysBase.getDeploySysOrgId() != null)) {
            iDataObject.set(FIELD_DEPLOYSYSORGID, (Object)pSDevSlnSysBase.getDeploySysOrgId());
        }
        if (pSDevSlnSysBase.isDeploySysOrgSectorIdDirty() && (bl || pSDevSlnSysBase.getDeploySysOrgSectorId() != null)) {
            iDataObject.set(FIELD_DEPLOYSYSORGSECTORID, (Object)pSDevSlnSysBase.getDeploySysOrgSectorId());
        }
        if (pSDevSlnSysBase.isDeploySysTagDirty() && (bl || pSDevSlnSysBase.getDeploySysTag() != null)) {
            iDataObject.set(FIELD_DEPLOYSYSTAG, (Object)pSDevSlnSysBase.getDeploySysTag());
        }
        if (pSDevSlnSysBase.isDeploySysTag2Dirty() && (bl || pSDevSlnSysBase.getDeploySysTag2() != null)) {
            iDataObject.set(FIELD_DEPLOYSYSTAG2, (Object)pSDevSlnSysBase.getDeploySysTag2());
        }
        if (pSDevSlnSysBase.isDeploySysTypeDirty() && (bl || pSDevSlnSysBase.getDeploySysType() != null)) {
            iDataObject.set(FIELD_DEPLOYSYSTYPE, (Object)pSDevSlnSysBase.getDeploySysType());
        }
        if (pSDevSlnSysBase.isDevResInfoDirty() && (bl || pSDevSlnSysBase.getDevResInfo() != null)) {
            iDataObject.set(FIELD_DEVRESINFO, (Object)pSDevSlnSysBase.getDevResInfo());
        }
        if (pSDevSlnSysBase.isDevResStateDirty() && (bl || pSDevSlnSysBase.getDevResState() != null)) {
            iDataObject.set(FIELD_DEVRESSTATE, (Object)pSDevSlnSysBase.getDevResState());
        }
        if (pSDevSlnSysBase.isDevSysStateDirty() && (bl || pSDevSlnSysBase.getDevSysState() != null)) {
            iDataObject.set(FIELD_DEVSYSSTATE, (Object)pSDevSlnSysBase.getDevSysState());
        }
        if (pSDevSlnSysBase.isDocGitBranchDirty() && (bl || pSDevSlnSysBase.getDocGitBranch() != null)) {
            iDataObject.set(FIELD_DOCGITBRANCH, (Object)pSDevSlnSysBase.getDocGitBranch());
        }
        if (pSDevSlnSysBase.isDocGitPathDirty() && (bl || pSDevSlnSysBase.getDocGitPath() != null)) {
            iDataObject.set(FIELD_DOCGITPATH, (Object)pSDevSlnSysBase.getDocGitPath());
        }
        if (pSDevSlnSysBase.isDocPSDevCenterSVNIdDirty() && (bl || pSDevSlnSysBase.getDocPSDevCenterSVNId() != null)) {
            iDataObject.set(FIELD_DOCPSDEVCENTERSVNID, (Object)pSDevSlnSysBase.getDocPSDevCenterSVNId());
        }
        if (pSDevSlnSysBase.isDocPSDevCenterSVNNameDirty() && (bl || pSDevSlnSysBase.getDocPSDevCenterSVNName() != null)) {
            iDataObject.set(FIELD_DOCPSDEVCENTERSVNNAME, (Object)pSDevSlnSysBase.getDocPSDevCenterSVNName());
        }
        if (pSDevSlnSysBase.isEnableCallbackDirty() && (bl || pSDevSlnSysBase.getEnableCallback() != null)) {
            iDataObject.set(FIELD_ENABLECALLBACK, (Object)pSDevSlnSysBase.getEnableCallback());
        }
        if (pSDevSlnSysBase.isEnableDB2Dirty() && (bl || pSDevSlnSysBase.getEnableDB2() != null)) {
            iDataObject.set(FIELD_ENABLEDB2, (Object)pSDevSlnSysBase.getEnableDB2());
        }
        if (pSDevSlnSysBase.isEnableDeployCenterDirty() && (bl || pSDevSlnSysBase.getEnableDeployCenter() != null)) {
            iDataObject.set(FIELD_ENABLEDEPLOYCENTER, (Object)pSDevSlnSysBase.getEnableDeployCenter());
        }
        if (pSDevSlnSysBase.isEnableDMDirty() && (bl || pSDevSlnSysBase.getEnableDM() != null)) {
            iDataObject.set(FIELD_ENABLEDM, (Object)pSDevSlnSysBase.getEnableDM());
        }
        if (pSDevSlnSysBase.isEnableDynaSysDirty() && (bl || pSDevSlnSysBase.getEnableDynaSys() != null)) {
            iDataObject.set(FIELD_ENABLEDYNASYS, (Object)pSDevSlnSysBase.getEnableDynaSys());
        }
        if (pSDevSlnSysBase.isEnableFolderKeyDirty() && (bl || pSDevSlnSysBase.getEnableFolderKey() != null)) {
            iDataObject.set(FIELD_ENABLEFOLDERKEY, (Object)pSDevSlnSysBase.getEnableFolderKey());
        }
        if (pSDevSlnSysBase.isEnableHANADirty() && (bl || pSDevSlnSysBase.getEnableHANA() != null)) {
            iDataObject.set(FIELD_ENABLEHANA, (Object)pSDevSlnSysBase.getEnableHANA());
        }
        if (pSDevSlnSysBase.isEnableHBaseDirty() && (bl || pSDevSlnSysBase.getEnableHBase() != null)) {
            iDataObject.set(FIELD_ENABLEHBASE, (Object)pSDevSlnSysBase.getEnableHBase());
        }
        if (pSDevSlnSysBase.isEnableMySQL5Dirty() && (bl || pSDevSlnSysBase.getEnableMySQL5() != null)) {
            iDataObject.set(FIELD_ENABLEMYSQL5, (Object)pSDevSlnSysBase.getEnableMySQL5());
        }
        if (pSDevSlnSysBase.isEnableOracleDirty() && (bl || pSDevSlnSysBase.getEnableOracle() != null)) {
            iDataObject.set(FIELD_ENABLEORACLE, (Object)pSDevSlnSysBase.getEnableOracle());
        }
        if (pSDevSlnSysBase.isEnablePGSQLDirty() && (bl || pSDevSlnSysBase.getEnablePGSQL() != null)) {
            iDataObject.set(FIELD_ENABLEPGSQL, (Object)pSDevSlnSysBase.getEnablePGSQL());
        }
        if (pSDevSlnSysBase.isEnablePPASDirty() && (bl || pSDevSlnSysBase.getEnablePPAS() != null)) {
            iDataObject.set(FIELD_ENABLEPPAS, (Object)pSDevSlnSysBase.getEnablePPAS());
        }
        if (pSDevSlnSysBase.isEnableSQLiteDirty() && (bl || pSDevSlnSysBase.getEnableSQLite() != null)) {
            iDataObject.set(FIELD_ENABLESQLITE, (Object)pSDevSlnSysBase.getEnableSQLite());
        }
        if (pSDevSlnSysBase.isEnableSqlServerDirty() && (bl || pSDevSlnSysBase.getEnableSqlServer() != null)) {
            iDataObject.set(FIELD_ENABLESQLSERVER, (Object)pSDevSlnSysBase.getEnableSqlServer());
        }
        if (pSDevSlnSysBase.isEnableWSServerDirty() && (bl || pSDevSlnSysBase.getEnableWSServer() != null)) {
            iDataObject.set(FIELD_ENABLEWSSERVER, (Object)pSDevSlnSysBase.getEnableWSServer());
        }
        if (pSDevSlnSysBase.isEntityCntDirty() && (bl || pSDevSlnSysBase.getEntityCnt() != null)) {
            iDataObject.set(FIELD_ENTITYCNT, (Object)pSDevSlnSysBase.getEntityCnt());
        }
        if (pSDevSlnSysBase.isExpriedTimeDirty() && (bl || pSDevSlnSysBase.getExpriedTime() != null)) {
            iDataObject.set(FIELD_EXPRIEDTIME, (Object)pSDevSlnSysBase.getExpriedTime());
        }
        if (pSDevSlnSysBase.isGitBranchDirty() && (bl || pSDevSlnSysBase.getGitBranch() != null)) {
            iDataObject.set(FIELD_GITBRANCH, (Object)pSDevSlnSysBase.getGitBranch());
        }
        if (pSDevSlnSysBase.isGitPathDirty() && (bl || pSDevSlnSysBase.getGitPath() != null)) {
            iDataObject.set(FIELD_GITPATH, (Object)pSDevSlnSysBase.getGitPath());
        }
        if (pSDevSlnSysBase.isHBasePSDCBDInstIdDirty() && (bl || pSDevSlnSysBase.getHBasePSDCBDInstId() != null)) {
            iDataObject.set(FIELD_HBASEPSDCBDINSTID, (Object)pSDevSlnSysBase.getHBasePSDCBDInstId());
        }
        if (pSDevSlnSysBase.isHBasePSDCBDInstNameDirty() && (bl || pSDevSlnSysBase.getHBasePSDCBDInstName() != null)) {
            iDataObject.set(FIELD_HBASEPSDCBDINSTNAME, (Object)pSDevSlnSysBase.getHBasePSDCBDInstName());
        }
        if (pSDevSlnSysBase.isInitParamsDirty() && (bl || pSDevSlnSysBase.getInitParams() != null)) {
            iDataObject.set(FIELD_INITPARAMS, (Object)pSDevSlnSysBase.getInitParams());
        }
        if (pSDevSlnSysBase.isJITPSDBDevInstIdDirty() && (bl || pSDevSlnSysBase.getJITPSDBDevInstId() != null)) {
            iDataObject.set(FIELD_JITPSDBDEVINSTID, (Object)pSDevSlnSysBase.getJITPSDBDevInstId());
        }
        if (pSDevSlnSysBase.isJITPSDBDevInstNameDirty() && (bl || pSDevSlnSysBase.getJITPSDBDevInstName() != null)) {
            iDataObject.set(FIELD_JITPSDBDEVINSTNAME, (Object)pSDevSlnSysBase.getJITPSDBDevInstName());
        }
        if (pSDevSlnSysBase.isJITPSDevCenterTSIdDirty() && (bl || pSDevSlnSysBase.getJITPSDevCenterTSId() != null)) {
            iDataObject.set(FIELD_JITPSDEVCENTERTSID, (Object)pSDevSlnSysBase.getJITPSDevCenterTSId());
        }
        if (pSDevSlnSysBase.isJITPSDevCenterTSNameDirty() && (bl || pSDevSlnSysBase.getJITPSDevCenterTSName() != null)) {
            iDataObject.set(FIELD_JITPSDEVCENTERTSNAME, (Object)pSDevSlnSysBase.getJITPSDevCenterTSName());
        }
        if (pSDevSlnSysBase.isLastActiveTimeDirty() && (bl || pSDevSlnSysBase.getLastActiveTime() != null)) {
            iDataObject.set(FIELD_LASTACTIVETIME, (Object)pSDevSlnSysBase.getLastActiveTime());
        }
        if (pSDevSlnSysBase.isLoadTimeDirty() && (bl || pSDevSlnSysBase.getLoadTime() != null)) {
            iDataObject.set(FIELD_LOADTIME, (Object)pSDevSlnSysBase.getLoadTime());
        }
        if (pSDevSlnSysBase.isLogicNameDirty() && (bl || pSDevSlnSysBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSDevSlnSysBase.getLogicName());
        }
        if (pSDevSlnSysBase.isLowCodeModeDirty() && (bl || pSDevSlnSysBase.getLowCodeMode() != null)) {
            iDataObject.set(FIELD_LOWCODEMODE, (Object)pSDevSlnSysBase.getLowCodeMode());
        }
        if (pSDevSlnSysBase.isMainPSDevSlnSysIdDirty() && (bl || pSDevSlnSysBase.getMainPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_MAINPSDEVSLNSYSID, (Object)pSDevSlnSysBase.getMainPSDevSlnSysId());
        }
        if (pSDevSlnSysBase.isMainPSDevSlnSysNameDirty() && (bl || pSDevSlnSysBase.getMainPSDevSlnSysName() != null)) {
            iDataObject.set(FIELD_MAINPSDEVSLNSYSNAME, (Object)pSDevSlnSysBase.getMainPSDevSlnSysName());
        }
        if (pSDevSlnSysBase.isMaxEntityCntDirty() && (bl || pSDevSlnSysBase.getMaxEntityCnt() != null)) {
            iDataObject.set(FIELD_MAXENTITYCNT, (Object)pSDevSlnSysBase.getMaxEntityCnt());
        }
        if (pSDevSlnSysBase.isMemoDirty() && (bl || pSDevSlnSysBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevSlnSysBase.getMemo());
        }
        if (pSDevSlnSysBase.isModelGitBranchDirty() && (bl || pSDevSlnSysBase.getModelGitBranch() != null)) {
            iDataObject.set(FIELD_MODELGITBRANCH, (Object)pSDevSlnSysBase.getModelGitBranch());
        }
        if (pSDevSlnSysBase.isModelGitPathDirty() && (bl || pSDevSlnSysBase.getModelGitPath() != null)) {
            iDataObject.set(FIELD_MODELGITPATH, (Object)pSDevSlnSysBase.getModelGitPath());
        }
        if (pSDevSlnSysBase.isModelInstVerDirty() && (bl || pSDevSlnSysBase.getModelInstVer() != null)) {
            iDataObject.set(FIELD_MODELINSTVER, (Object)pSDevSlnSysBase.getModelInstVer());
        }
        if (pSDevSlnSysBase.isModelPrefixDirty() && (bl || pSDevSlnSysBase.getModelPrefix() != null)) {
            iDataObject.set(FIELD_MODELPREFIX, (Object)pSDevSlnSysBase.getModelPrefix());
        }
        if (pSDevSlnSysBase.isModelPSDevCenterSVNIdDirty() && (bl || pSDevSlnSysBase.getModelPSDevCenterSVNId() != null)) {
            iDataObject.set(FIELD_MODELPSDEVCENTERSVNID, (Object)pSDevSlnSysBase.getModelPSDevCenterSVNId());
        }
        if (pSDevSlnSysBase.isModelPSDevCenterSVNNameDirty() && (bl || pSDevSlnSysBase.getModelPSDevCenterSVNName() != null)) {
            iDataObject.set(FIELD_MODELPSDEVCENTERSVNNAME, (Object)pSDevSlnSysBase.getModelPSDevCenterSVNName());
        }
        if (pSDevSlnSysBase.isMSSQLPSDCDBInstIdDirty() && (bl || pSDevSlnSysBase.getMSSQLPSDCDBInstId() != null)) {
            iDataObject.set(FIELD_MSSQLPSDCDBINSTID, (Object)pSDevSlnSysBase.getMSSQLPSDCDBInstId());
        }
        if (pSDevSlnSysBase.isMSSQLPSDCDBInstNameDirty() && (bl || pSDevSlnSysBase.getMSSQLPSDCDBInstName() != null)) {
            iDataObject.set(FIELD_MSSQLPSDCDBINSTNAME, (Object)pSDevSlnSysBase.getMSSQLPSDCDBInstName());
        }
        if (pSDevSlnSysBase.isMySQLPSDCDBInstIdDirty() && (bl || pSDevSlnSysBase.getMySQLPSDCDBInstId() != null)) {
            iDataObject.set(FIELD_MYSQLPSDCDBINSTID, (Object)pSDevSlnSysBase.getMySQLPSDCDBInstId());
        }
        if (pSDevSlnSysBase.isMySQLPSDCDBInstNameDirty() && (bl || pSDevSlnSysBase.getMySQLPSDCDBInstName() != null)) {
            iDataObject.set(FIELD_MYSQLPSDCDBINSTNAME, (Object)pSDevSlnSysBase.getMySQLPSDCDBInstName());
        }
        if (pSDevSlnSysBase.isOfflineTimeDirty() && (bl || pSDevSlnSysBase.getOfflineTime() != null)) {
            iDataObject.set(FIELD_OFFLINETIME, (Object)pSDevSlnSysBase.getOfflineTime());
        }
        if (pSDevSlnSysBase.isOraPSDCDBInstIdDirty() && (bl || pSDevSlnSysBase.getOraPSDCDBInstId() != null)) {
            iDataObject.set(FIELD_ORAPSDCDBINSTID, (Object)pSDevSlnSysBase.getOraPSDCDBInstId());
        }
        if (pSDevSlnSysBase.isOraPSDCDBInstNameDirty() && (bl || pSDevSlnSysBase.getOraPSDCDBInstName() != null)) {
            iDataObject.set(FIELD_ORAPSDCDBINSTNAME, (Object)pSDevSlnSysBase.getOraPSDCDBInstName());
        }
        if (pSDevSlnSysBase.isPGSQLPSDCDBInstIdDirty() && (bl || pSDevSlnSysBase.getPGSQLPSDCDBInstId() != null)) {
            iDataObject.set(FIELD_PGSQLPSDCDBINSTID, (Object)pSDevSlnSysBase.getPGSQLPSDCDBInstId());
        }
        if (pSDevSlnSysBase.isPGSQLPSDCDBInstNameDirty() && (bl || pSDevSlnSysBase.getPGSQLPSDCDBInstName() != null)) {
            iDataObject.set(FIELD_PGSQLPSDCDBINSTNAME, (Object)pSDevSlnSysBase.getPGSQLPSDCDBInstName());
        }
        if (pSDevSlnSysBase.isPPASPSDCDBInstIdDirty() && (bl || pSDevSlnSysBase.getPPASPSDCDBInstId() != null)) {
            iDataObject.set(FIELD_PPASPSDCDBINSTID, (Object)pSDevSlnSysBase.getPPASPSDCDBInstId());
        }
        if (pSDevSlnSysBase.isPPASPSDCDBInstNameDirty() && (bl || pSDevSlnSysBase.getPPASPSDCDBInstName() != null)) {
            iDataObject.set(FIELD_PPASPSDCDBINSTNAME, (Object)pSDevSlnSysBase.getPPASPSDCDBInstName());
        }
        if (pSDevSlnSysBase.isPPSDevSlnSysIdDirty() && (bl || pSDevSlnSysBase.getPPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PPSDEVSLNSYSID, (Object)pSDevSlnSysBase.getPPSDevSlnSysId());
        }
        if (pSDevSlnSysBase.isPPSDevSlnSysNameDirty() && (bl || pSDevSlnSysBase.getPPSDevSlnSysName() != null)) {
            iDataObject.set(FIELD_PPSDEVSLNSYSNAME, (Object)pSDevSlnSysBase.getPPSDevSlnSysName());
        }
        if (pSDevSlnSysBase.isPSDCDeployCenterIdDirty() && (bl || pSDevSlnSysBase.getPSDCDeployCenterId() != null)) {
            iDataObject.set(FIELD_PSDCDEPLOYCENTERID, (Object)pSDevSlnSysBase.getPSDCDeployCenterId());
        }
        if (pSDevSlnSysBase.isPSDCDeployCenterNameDirty() && (bl || pSDevSlnSysBase.getPSDCDeployCenterName() != null)) {
            iDataObject.set(FIELD_PSDCDEPLOYCENTERNAME, (Object)pSDevSlnSysBase.getPSDCDeployCenterName());
        }
        if (pSDevSlnSysBase.isPSDCModelTemplIdDirty() && (bl || pSDevSlnSysBase.getPSDCModelTemplId() != null)) {
            iDataObject.set(FIELD_PSDCMODELTEMPLID, (Object)pSDevSlnSysBase.getPSDCModelTemplId());
        }
        if (pSDevSlnSysBase.isPSDCModelTemplNameDirty() && (bl || pSDevSlnSysBase.getPSDCModelTemplName() != null)) {
            iDataObject.set(FIELD_PSDCMODELTEMPLNAME, (Object)pSDevSlnSysBase.getPSDCModelTemplName());
        }
        if (pSDevSlnSysBase.isPSDCRobotIdDirty() && (bl || pSDevSlnSysBase.getPSDCRobotId() != null)) {
            iDataObject.set(FIELD_PSDCROBOTID, (Object)pSDevSlnSysBase.getPSDCRobotId());
        }
        if (pSDevSlnSysBase.isPSDCRobotNameDirty() && (bl || pSDevSlnSysBase.getPSDCRobotName() != null)) {
            iDataObject.set(FIELD_PSDCROBOTNAME, (Object)pSDevSlnSysBase.getPSDCRobotName());
        }
        if (pSDevSlnSysBase.isPSDCSysLicIdDirty() && (bl || pSDevSlnSysBase.getPSDCSysLicId() != null)) {
            iDataObject.set(FIELD_PSDCSYSLICID, (Object)pSDevSlnSysBase.getPSDCSysLicId());
        }
        if (pSDevSlnSysBase.isPSDCSysLicNameDirty() && (bl || pSDevSlnSysBase.getPSDCSysLicName() != null)) {
            iDataObject.set(FIELD_PSDCSYSLICNAME, (Object)pSDevSlnSysBase.getPSDCSysLicName());
        }
        if (pSDevSlnSysBase.isPSDCWorkspaceIdDirty() && (bl || pSDevSlnSysBase.getPSDCWorkspaceId() != null)) {
            iDataObject.set(FIELD_PSDCWORKSPACEID, (Object)pSDevSlnSysBase.getPSDCWorkspaceId());
        }
        if (pSDevSlnSysBase.isPSDevCenterASIdDirty() && (bl || pSDevSlnSysBase.getPSDevCenterASId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERASID, (Object)pSDevSlnSysBase.getPSDevCenterASId());
        }
        if (pSDevSlnSysBase.isPSDevCenterASId2Dirty() && (bl || pSDevSlnSysBase.getPSDevCenterASId2() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERASID2, (Object)pSDevSlnSysBase.getPSDevCenterASId2());
        }
        if (pSDevSlnSysBase.isPSDevCenterAS3IdDirty() && (bl || pSDevSlnSysBase.getPSDevCenterAS3Id() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERAS3ID, (Object)pSDevSlnSysBase.getPSDevCenterAS3Id());
        }
        if (pSDevSlnSysBase.isPSDevCenterAS4IdDirty() && (bl || pSDevSlnSysBase.getPSDevCenterAS4Id() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERAS4ID, (Object)pSDevSlnSysBase.getPSDevCenterAS4Id());
        }
        if (pSDevSlnSysBase.isPSDevCenterASNameDirty() && (bl || pSDevSlnSysBase.getPSDevCenterASName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERASNAME, (Object)pSDevSlnSysBase.getPSDevCenterASName());
        }
        if (pSDevSlnSysBase.isPSDevCenterASName2Dirty() && (bl || pSDevSlnSysBase.getPSDevCenterASName2() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERASNAME2, (Object)pSDevSlnSysBase.getPSDevCenterASName2());
        }
        if (pSDevSlnSysBase.isPSDevCenterAS3NameDirty() && (bl || pSDevSlnSysBase.getPSDevCenterAS3Name() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERAS3NAME, (Object)pSDevSlnSysBase.getPSDevCenterAS3Name());
        }
        if (pSDevSlnSysBase.isPSDevCenterAS4NameDirty() && (bl || pSDevSlnSysBase.getPSDevCenterAS4Name() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERAS4NAME, (Object)pSDevSlnSysBase.getPSDevCenterAS4Name());
        }
        if (pSDevSlnSysBase.isPSDevCenterIdDirty() && (bl || pSDevSlnSysBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDevSlnSysBase.getPSDevCenterId());
        }
        if (pSDevSlnSysBase.isPSDevCenterNameDirty() && (bl || pSDevSlnSysBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDevSlnSysBase.getPSDevCenterName());
        }
        if (pSDevSlnSysBase.isPSDevCenterSVNIdDirty() && (bl || pSDevSlnSysBase.getPSDevCenterSVNId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERSVNID, (Object)pSDevSlnSysBase.getPSDevCenterSVNId());
        }
        if (pSDevSlnSysBase.isPSDevCenterSVNNameDirty() && (bl || pSDevSlnSysBase.getPSDevCenterSVNName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERSVNNAME, (Object)pSDevSlnSysBase.getPSDevCenterSVNName());
        }
        if (pSDevSlnSysBase.isPSDevCenterTSIdDirty() && (bl || pSDevSlnSysBase.getPSDevCenterTSId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERTSID, (Object)pSDevSlnSysBase.getPSDevCenterTSId());
        }
        if (pSDevSlnSysBase.isPSDevCenterTSNameDirty() && (bl || pSDevSlnSysBase.getPSDevCenterTSName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERTSNAME, (Object)pSDevSlnSysBase.getPSDevCenterTSName());
        }
        if (pSDevSlnSysBase.isPSDevSlnIdDirty() && (bl || pSDevSlnSysBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDevSlnSysBase.getPSDevSlnId());
        }
        if (pSDevSlnSysBase.isPSDevSlnNameDirty() && (bl || pSDevSlnSysBase.getPSDevSlnName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNNAME, (Object)pSDevSlnSysBase.getPSDevSlnName());
        }
        if (pSDevSlnSysBase.isPSDevSlnSysIdDirty() && (bl || pSDevSlnSysBase.getPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSID, (Object)pSDevSlnSysBase.getPSDevSlnSysId());
        }
        if (pSDevSlnSysBase.isPSDevSlnSysNameDirty() && (bl || pSDevSlnSysBase.getPSDevSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSNAME, (Object)pSDevSlnSysBase.getPSDevSlnSysName());
        }
        if (pSDevSlnSysBase.isPSDevSlnSysResIdDirty() && (bl || pSDevSlnSysBase.getPSDevSlnSysResId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSRESID, (Object)pSDevSlnSysBase.getPSDevSlnSysResId());
        }
        if (pSDevSlnSysBase.isPSDevSlnSysResNameDirty() && (bl || pSDevSlnSysBase.getPSDevSlnSysResName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSRESNAME, (Object)pSDevSlnSysBase.getPSDevSlnSysResName());
        }
        if (pSDevSlnSysBase.isPSPFIdDirty() && (bl || pSDevSlnSysBase.getPSPFId() != null)) {
            iDataObject.set(FIELD_PSPFID, (Object)pSDevSlnSysBase.getPSPFId());
        }
        if (pSDevSlnSysBase.isPSPFNameDirty() && (bl || pSDevSlnSysBase.getPSPFName() != null)) {
            iDataObject.set(FIELD_PSPFNAME, (Object)pSDevSlnSysBase.getPSPFName());
        }
        if (pSDevSlnSysBase.isPSSFIdDirty() && (bl || pSDevSlnSysBase.getPSSFId() != null)) {
            iDataObject.set(FIELD_PSSFID, (Object)pSDevSlnSysBase.getPSSFId());
        }
        if (pSDevSlnSysBase.isPSSFNameDirty() && (bl || pSDevSlnSysBase.getPSSFName() != null)) {
            iDataObject.set(FIELD_PSSFNAME, (Object)pSDevSlnSysBase.getPSSFName());
        }
        if (pSDevSlnSysBase.isPSStudioThemeIdDirty() && (bl || pSDevSlnSysBase.getPSStudioThemeId() != null)) {
            iDataObject.set(FIELD_PSSTUDIOTHEMEID, (Object)pSDevSlnSysBase.getPSStudioThemeId());
        }
        if (pSDevSlnSysBase.isPSStudioThemeNameDirty() && (bl || pSDevSlnSysBase.getPSStudioThemeName() != null)) {
            iDataObject.set(FIELD_PSSTUDIOTHEMENAME, (Object)pSDevSlnSysBase.getPSStudioThemeName());
        }
        if (pSDevSlnSysBase.isPSSysModelInstIdDirty() && (bl || pSDevSlnSysBase.getPSSysModelInstId() != null)) {
            iDataObject.set(FIELD_PSSYSMODELINSTID, (Object)pSDevSlnSysBase.getPSSysModelInstId());
        }
        if (pSDevSlnSysBase.isPSSysModelInstNameDirty() && (bl || pSDevSlnSysBase.getPSSysModelInstName() != null)) {
            iDataObject.set(FIELD_PSSYSMODELINSTNAME, (Object)pSDevSlnSysBase.getPSSysModelInstName());
        }
        if (pSDevSlnSysBase.isPSSysPolicyIdDirty() && (bl || pSDevSlnSysBase.getPSSysPolicyId() != null)) {
            iDataObject.set(FIELD_PSSYSPOLICYID, (Object)pSDevSlnSysBase.getPSSysPolicyId());
        }
        if (pSDevSlnSysBase.isPSSysPolicyNameDirty() && (bl || pSDevSlnSysBase.getPSSysPolicyName() != null)) {
            iDataObject.set(FIELD_PSSYSPOLICYNAME, (Object)pSDevSlnSysBase.getPSSysPolicyName());
        }
        if (pSDevSlnSysBase.isPSSystemIdDirty() && (bl || pSDevSlnSysBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSDevSlnSysBase.getPSSystemId());
        }
        if (pSDevSlnSysBase.isPSTaskServerIdDirty() && (bl || pSDevSlnSysBase.getPSTaskServerId() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERID, (Object)pSDevSlnSysBase.getPSTaskServerId());
        }
        if (pSDevSlnSysBase.isPSTaskServerNameDirty() && (bl || pSDevSlnSysBase.getPSTaskServerName() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERNAME, (Object)pSDevSlnSysBase.getPSTaskServerName());
        }
        if (pSDevSlnSysBase.isPubCodeDirty() && (bl || pSDevSlnSysBase.getPubCode() != null)) {
            iDataObject.set(FIELD_PUBCODE, (Object)pSDevSlnSysBase.getPubCode());
        }
        if (pSDevSlnSysBase.isResReadyTimeDirty() && (bl || pSDevSlnSysBase.getResReadyTime() != null)) {
            iDataObject.set(FIELD_RESREADYTIME, (Object)pSDevSlnSysBase.getResReadyTime());
        }
        if (pSDevSlnSysBase.isROGitBranchDirty() && (bl || pSDevSlnSysBase.getROGitBranch() != null)) {
            iDataObject.set(FIELD_ROGITBRANCH, (Object)pSDevSlnSysBase.getROGitBranch());
        }
        if (pSDevSlnSysBase.isROGitPathDirty() && (bl || pSDevSlnSysBase.getROGitPath() != null)) {
            iDataObject.set(FIELD_ROGITPATH, (Object)pSDevSlnSysBase.getROGitPath());
        }
        if (pSDevSlnSysBase.isROPSDevCenterSvnIdDirty() && (bl || pSDevSlnSysBase.getROPSDevCenterSvnId() != null)) {
            iDataObject.set(FIELD_ROPSDEVCENTERSVNID, (Object)pSDevSlnSysBase.getROPSDevCenterSvnId());
        }
        if (pSDevSlnSysBase.isROPSDevCenterSvnNameDirty() && (bl || pSDevSlnSysBase.getROPSDevCenterSvnName() != null)) {
            iDataObject.set(FIELD_ROPSDEVCENTERSVNNAME, (Object)pSDevSlnSysBase.getROPSDevCenterSvnName());
        }
        if (pSDevSlnSysBase.isRTModelPSDevCenterSVNIdDirty() && (bl || pSDevSlnSysBase.getRTModelPSDevCenterSVNId() != null)) {
            iDataObject.set(FIELD_RTMODELPSDEVCENTERSVNID, (Object)pSDevSlnSysBase.getRTModelPSDevCenterSVNId());
        }
        if (pSDevSlnSysBase.isRTModelPSDevCenterSVNNameDirty() && (bl || pSDevSlnSysBase.getRTModelPSDevCenterSVNName() != null)) {
            iDataObject.set(FIELD_RTMODELPSDEVCENTERSVNNAME, (Object)pSDevSlnSysBase.getRTModelPSDevCenterSVNName());
        }
        if (pSDevSlnSysBase.isSaaSModeDirty() && (bl || pSDevSlnSysBase.getSaaSMode() != null)) {
            iDataObject.set(FIELD_SAASMODE, (Object)pSDevSlnSysBase.getSaaSMode());
        }
        if (pSDevSlnSysBase.isSFPSSubSysIdDirty() && (bl || pSDevSlnSysBase.getSFPSSubSysId() != null)) {
            iDataObject.set(FIELD_SFPSSUBSYSID, (Object)pSDevSlnSysBase.getSFPSSubSysId());
        }
        if (pSDevSlnSysBase.isSFPSSubSysNameDirty() && (bl || pSDevSlnSysBase.getSFPSSubSysName() != null)) {
            iDataObject.set(FIELD_SFPSSUBSYSNAME, (Object)pSDevSlnSysBase.getSFPSSubSysName());
        }
        if (pSDevSlnSysBase.isShareFlagDirty() && (bl || pSDevSlnSysBase.getShareFlag() != null)) {
            iDataObject.set(FIELD_SHAREFLAG, (Object)pSDevSlnSysBase.getShareFlag());
        }
        if (pSDevSlnSysBase.isStudioTagDirty() && (bl || pSDevSlnSysBase.getStudioTag() != null)) {
            iDataObject.set(FIELD_STUDIOTAG, (Object)pSDevSlnSysBase.getStudioTag());
        }
        if (pSDevSlnSysBase.isStudioTag2Dirty() && (bl || pSDevSlnSysBase.getStudioTag2() != null)) {
            iDataObject.set(FIELD_STUDIOTAG2, (Object)pSDevSlnSysBase.getStudioTag2());
        }
        if (pSDevSlnSysBase.isStudioVerDirty() && (bl || pSDevSlnSysBase.getStudioVer() != null)) {
            iDataObject.set(FIELD_STUDIOVER, (Object)pSDevSlnSysBase.getStudioVer());
        }
        if (pSDevSlnSysBase.isSysFolderDirty() && (bl || pSDevSlnSysBase.getSysFolder() != null)) {
            iDataObject.set(FIELD_SYSFOLDER, (Object)pSDevSlnSysBase.getSysFolder());
        }
        if (pSDevSlnSysBase.isSysMDUrlDirty() && (bl || pSDevSlnSysBase.getSysMDUrl() != null)) {
            iDataObject.set(FIELD_SYSMDURL, (Object)pSDevSlnSysBase.getSysMDUrl());
        }
        if (pSDevSlnSysBase.isSysRowKeyDirty() && (bl || pSDevSlnSysBase.getSysRowKey() != null)) {
            iDataObject.set(FIELD_SYSROWKEY, (Object)pSDevSlnSysBase.getSysRowKey());
        }
        if (pSDevSlnSysBase.isSysTagDirty() && (bl || pSDevSlnSysBase.getSysTag() != null)) {
            iDataObject.set(FIELD_SYSTAG, (Object)pSDevSlnSysBase.getSysTag());
        }
        if (pSDevSlnSysBase.isSysTag2Dirty() && (bl || pSDevSlnSysBase.getSysTag2() != null)) {
            iDataObject.set(FIELD_SYSTAG2, (Object)pSDevSlnSysBase.getSysTag2());
        }
        if (pSDevSlnSysBase.isSysTag3Dirty() && (bl || pSDevSlnSysBase.getSysTag3() != null)) {
            iDataObject.set(FIELD_SYSTAG3, (Object)pSDevSlnSysBase.getSysTag3());
        }
        if (pSDevSlnSysBase.isSysTag4Dirty() && (bl || pSDevSlnSysBase.getSysTag4() != null)) {
            iDataObject.set(FIELD_SYSTAG4, (Object)pSDevSlnSysBase.getSysTag4());
        }
        if (pSDevSlnSysBase.isSysTypeDirty() && (bl || pSDevSlnSysBase.getSysType() != null)) {
            iDataObject.set(FIELD_SYSTYPE, (Object)pSDevSlnSysBase.getSysType());
        }
        if (pSDevSlnSysBase.isSysVerDirty() && (bl || pSDevSlnSysBase.getSysVer() != null)) {
            iDataObject.set(FIELD_SYSVER, (Object)pSDevSlnSysBase.getSysVer());
        }
        if (pSDevSlnSysBase.isTemplEngineDirty() && (bl || pSDevSlnSysBase.getTemplEngine() != null)) {
            iDataObject.set(FIELD_TEMPLENGINE, (Object)pSDevSlnSysBase.getTemplEngine());
        }
        if (pSDevSlnSysBase.isThemeCssStyleDirty() && (bl || pSDevSlnSysBase.getThemeCssStyle() != null)) {
            iDataObject.set(FIELD_THEMECSSSTYLE, (Object)pSDevSlnSysBase.getThemeCssStyle());
        }
        if (pSDevSlnSysBase.isUnloadTimeDirty() && (bl || pSDevSlnSysBase.getUnloadTime() != null)) {
            iDataObject.set(FIELD_UNLOADTIME, (Object)pSDevSlnSysBase.getUnloadTime());
        }
        if (pSDevSlnSysBase.isUpdateDateDirty() && (bl || pSDevSlnSysBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevSlnSysBase.getUpdateDate());
        }
        if (pSDevSlnSysBase.isUpdateManDirty() && (bl || pSDevSlnSysBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevSlnSysBase.getUpdateMan());
        }
        if (pSDevSlnSysBase.isUserCatDirty() && (bl || pSDevSlnSysBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDevSlnSysBase.getUserCat());
        }
        if (pSDevSlnSysBase.isUserTagDirty() && (bl || pSDevSlnSysBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDevSlnSysBase.getUserTag());
        }
        if (pSDevSlnSysBase.isUserTag2Dirty() && (bl || pSDevSlnSysBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDevSlnSysBase.getUserTag2());
        }
        if (pSDevSlnSysBase.isUserTag3Dirty() && (bl || pSDevSlnSysBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDevSlnSysBase.getUserTag3());
        }
        if (pSDevSlnSysBase.isUserTag4Dirty() && (bl || pSDevSlnSysBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDevSlnSysBase.getUserTag4());
        }
        if (pSDevSlnSysBase.isValidFlagDirty() && (bl || pSDevSlnSysBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDevSlnSysBase.getValidFlag());
        }
        if (pSDevSlnSysBase.isVCTypeDirty() && (bl || pSDevSlnSysBase.getVCType() != null)) {
            iDataObject.set(FIELD_VCTYPE, (Object)pSDevSlnSysBase.getVCType());
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
        return PSDevSlnSysBase.remove(this, n);
    }

    private static boolean remove(PSDevSlnSysBase pSDevSlnSysBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnSysBase.resetActionOwner();
                return true;
            }
            case 1: {
                pSDevSlnSysBase.resetAPIFlag();
                return true;
            }
            case 2: {
                pSDevSlnSysBase.resetCallbackTag();
                return true;
            }
            case 3: {
                pSDevSlnSysBase.resetCallbackUrl();
                return true;
            }
            case 4: {
                pSDevSlnSysBase.resetCodeName();
                return true;
            }
            case 5: {
                pSDevSlnSysBase.resetCreateDate();
                return true;
            }
            case 6: {
                pSDevSlnSysBase.resetCreateMan();
                return true;
            }
            case 7: {
                pSDevSlnSysBase.resetCurAction();
                return true;
            }
            case 8: {
                pSDevSlnSysBase.resetDB2PSDCDBInstId();
                return true;
            }
            case 9: {
                pSDevSlnSysBase.resetDB2PSDCDBInstName();
                return true;
            }
            case 10: {
                pSDevSlnSysBase.resetDBTypes();
                return true;
            }
            case 11: {
                pSDevSlnSysBase.resetDBVersion();
                return true;
            }
            case 12: {
                pSDevSlnSysBase.resetDeploySysId();
                return true;
            }
            case 13: {
                pSDevSlnSysBase.resetDeploySysOrgId();
                return true;
            }
            case 14: {
                pSDevSlnSysBase.resetDeploySysOrgSectorId();
                return true;
            }
            case 15: {
                pSDevSlnSysBase.resetDeploySysTag();
                return true;
            }
            case 16: {
                pSDevSlnSysBase.resetDeploySysTag2();
                return true;
            }
            case 17: {
                pSDevSlnSysBase.resetDeploySysType();
                return true;
            }
            case 18: {
                pSDevSlnSysBase.resetDevResInfo();
                return true;
            }
            case 19: {
                pSDevSlnSysBase.resetDevResState();
                return true;
            }
            case 20: {
                pSDevSlnSysBase.resetDevSysState();
                return true;
            }
            case 21: {
                pSDevSlnSysBase.resetDocGitBranch();
                return true;
            }
            case 22: {
                pSDevSlnSysBase.resetDocGitPath();
                return true;
            }
            case 23: {
                pSDevSlnSysBase.resetDocPSDevCenterSVNId();
                return true;
            }
            case 24: {
                pSDevSlnSysBase.resetDocPSDevCenterSVNName();
                return true;
            }
            case 25: {
                pSDevSlnSysBase.resetEnableCallback();
                return true;
            }
            case 26: {
                pSDevSlnSysBase.resetEnableDB2();
                return true;
            }
            case 27: {
                pSDevSlnSysBase.resetEnableDeployCenter();
                return true;
            }
            case 28: {
                pSDevSlnSysBase.resetEnableDM();
                return true;
            }
            case 29: {
                pSDevSlnSysBase.resetEnableDynaSys();
                return true;
            }
            case 30: {
                pSDevSlnSysBase.resetEnableFolderKey();
                return true;
            }
            case 31: {
                pSDevSlnSysBase.resetEnableHANA();
                return true;
            }
            case 32: {
                pSDevSlnSysBase.resetEnableHBase();
                return true;
            }
            case 33: {
                pSDevSlnSysBase.resetEnableMySQL5();
                return true;
            }
            case 34: {
                pSDevSlnSysBase.resetEnableOracle();
                return true;
            }
            case 35: {
                pSDevSlnSysBase.resetEnablePGSQL();
                return true;
            }
            case 36: {
                pSDevSlnSysBase.resetEnablePPAS();
                return true;
            }
            case 37: {
                pSDevSlnSysBase.resetEnableSQLite();
                return true;
            }
            case 38: {
                pSDevSlnSysBase.resetEnableSqlServer();
                return true;
            }
            case 39: {
                pSDevSlnSysBase.resetEnableWSServer();
                return true;
            }
            case 40: {
                pSDevSlnSysBase.resetEntityCnt();
                return true;
            }
            case 41: {
                pSDevSlnSysBase.resetExpriedTime();
                return true;
            }
            case 42: {
                pSDevSlnSysBase.resetGitBranch();
                return true;
            }
            case 43: {
                pSDevSlnSysBase.resetGitPath();
                return true;
            }
            case 44: {
                pSDevSlnSysBase.resetHBasePSDCBDInstId();
                return true;
            }
            case 45: {
                pSDevSlnSysBase.resetHBasePSDCBDInstName();
                return true;
            }
            case 46: {
                pSDevSlnSysBase.resetInitParams();
                return true;
            }
            case 47: {
                pSDevSlnSysBase.resetJITPSDBDevInstId();
                return true;
            }
            case 48: {
                pSDevSlnSysBase.resetJITPSDBDevInstName();
                return true;
            }
            case 49: {
                pSDevSlnSysBase.resetJITPSDevCenterTSId();
                return true;
            }
            case 50: {
                pSDevSlnSysBase.resetJITPSDevCenterTSName();
                return true;
            }
            case 51: {
                pSDevSlnSysBase.resetLastActiveTime();
                return true;
            }
            case 52: {
                pSDevSlnSysBase.resetLoadTime();
                return true;
            }
            case 53: {
                pSDevSlnSysBase.resetLogicName();
                return true;
            }
            case 54: {
                pSDevSlnSysBase.resetLowCodeMode();
                return true;
            }
            case 55: {
                pSDevSlnSysBase.resetMainPSDevSlnSysId();
                return true;
            }
            case 56: {
                pSDevSlnSysBase.resetMainPSDevSlnSysName();
                return true;
            }
            case 57: {
                pSDevSlnSysBase.resetMaxEntityCnt();
                return true;
            }
            case 58: {
                pSDevSlnSysBase.resetMemo();
                return true;
            }
            case 59: {
                pSDevSlnSysBase.resetModelGitBranch();
                return true;
            }
            case 60: {
                pSDevSlnSysBase.resetModelGitPath();
                return true;
            }
            case 61: {
                pSDevSlnSysBase.resetModelInstVer();
                return true;
            }
            case 62: {
                pSDevSlnSysBase.resetModelPrefix();
                return true;
            }
            case 63: {
                pSDevSlnSysBase.resetModelPSDevCenterSVNId();
                return true;
            }
            case 64: {
                pSDevSlnSysBase.resetModelPSDevCenterSVNName();
                return true;
            }
            case 65: {
                pSDevSlnSysBase.resetMSSQLPSDCDBInstId();
                return true;
            }
            case 66: {
                pSDevSlnSysBase.resetMSSQLPSDCDBInstName();
                return true;
            }
            case 67: {
                pSDevSlnSysBase.resetMySQLPSDCDBInstId();
                return true;
            }
            case 68: {
                pSDevSlnSysBase.resetMySQLPSDCDBInstName();
                return true;
            }
            case 69: {
                pSDevSlnSysBase.resetOfflineTime();
                return true;
            }
            case 70: {
                pSDevSlnSysBase.resetOraPSDCDBInstId();
                return true;
            }
            case 71: {
                pSDevSlnSysBase.resetOraPSDCDBInstName();
                return true;
            }
            case 72: {
                pSDevSlnSysBase.resetPGSQLPSDCDBInstId();
                return true;
            }
            case 73: {
                pSDevSlnSysBase.resetPGSQLPSDCDBInstName();
                return true;
            }
            case 74: {
                pSDevSlnSysBase.resetPPASPSDCDBInstId();
                return true;
            }
            case 75: {
                pSDevSlnSysBase.resetPPASPSDCDBInstName();
                return true;
            }
            case 76: {
                pSDevSlnSysBase.resetPPSDevSlnSysId();
                return true;
            }
            case 77: {
                pSDevSlnSysBase.resetPPSDevSlnSysName();
                return true;
            }
            case 78: {
                pSDevSlnSysBase.resetPSDCDeployCenterId();
                return true;
            }
            case 79: {
                pSDevSlnSysBase.resetPSDCDeployCenterName();
                return true;
            }
            case 80: {
                pSDevSlnSysBase.resetPSDCModelTemplId();
                return true;
            }
            case 81: {
                pSDevSlnSysBase.resetPSDCModelTemplName();
                return true;
            }
            case 82: {
                pSDevSlnSysBase.resetPSDCRobotId();
                return true;
            }
            case 83: {
                pSDevSlnSysBase.resetPSDCRobotName();
                return true;
            }
            case 84: {
                pSDevSlnSysBase.resetPSDCSysLicId();
                return true;
            }
            case 85: {
                pSDevSlnSysBase.resetPSDCSysLicName();
                return true;
            }
            case 86: {
                pSDevSlnSysBase.resetPSDCWorkspaceId();
                return true;
            }
            case 87: {
                pSDevSlnSysBase.resetPSDevCenterASId();
                return true;
            }
            case 88: {
                pSDevSlnSysBase.resetPSDevCenterASId2();
                return true;
            }
            case 89: {
                pSDevSlnSysBase.resetPSDevCenterAS3Id();
                return true;
            }
            case 90: {
                pSDevSlnSysBase.resetPSDevCenterAS4Id();
                return true;
            }
            case 91: {
                pSDevSlnSysBase.resetPSDevCenterASName();
                return true;
            }
            case 92: {
                pSDevSlnSysBase.resetPSDevCenterASName2();
                return true;
            }
            case 93: {
                pSDevSlnSysBase.resetPSDevCenterAS3Name();
                return true;
            }
            case 94: {
                pSDevSlnSysBase.resetPSDevCenterAS4Name();
                return true;
            }
            case 95: {
                pSDevSlnSysBase.resetPSDevCenterId();
                return true;
            }
            case 96: {
                pSDevSlnSysBase.resetPSDevCenterName();
                return true;
            }
            case 97: {
                pSDevSlnSysBase.resetPSDevCenterSVNId();
                return true;
            }
            case 98: {
                pSDevSlnSysBase.resetPSDevCenterSVNName();
                return true;
            }
            case 99: {
                pSDevSlnSysBase.resetPSDevCenterTSId();
                return true;
            }
            case 100: {
                pSDevSlnSysBase.resetPSDevCenterTSName();
                return true;
            }
            case 101: {
                pSDevSlnSysBase.resetPSDevSlnId();
                return true;
            }
            case 102: {
                pSDevSlnSysBase.resetPSDevSlnName();
                return true;
            }
            case 103: {
                pSDevSlnSysBase.resetPSDevSlnSysId();
                return true;
            }
            case 104: {
                pSDevSlnSysBase.resetPSDevSlnSysName();
                return true;
            }
            case 105: {
                pSDevSlnSysBase.resetPSDevSlnSysResId();
                return true;
            }
            case 106: {
                pSDevSlnSysBase.resetPSDevSlnSysResName();
                return true;
            }
            case 107: {
                pSDevSlnSysBase.resetPSPFId();
                return true;
            }
            case 108: {
                pSDevSlnSysBase.resetPSPFName();
                return true;
            }
            case 109: {
                pSDevSlnSysBase.resetPSSFId();
                return true;
            }
            case 110: {
                pSDevSlnSysBase.resetPSSFName();
                return true;
            }
            case 111: {
                pSDevSlnSysBase.resetPSStudioThemeId();
                return true;
            }
            case 112: {
                pSDevSlnSysBase.resetPSStudioThemeName();
                return true;
            }
            case 113: {
                pSDevSlnSysBase.resetPSSysModelInstId();
                return true;
            }
            case 114: {
                pSDevSlnSysBase.resetPSSysModelInstName();
                return true;
            }
            case 115: {
                pSDevSlnSysBase.resetPSSysPolicyId();
                return true;
            }
            case 116: {
                pSDevSlnSysBase.resetPSSysPolicyName();
                return true;
            }
            case 117: {
                pSDevSlnSysBase.resetPSSystemId();
                return true;
            }
            case 118: {
                pSDevSlnSysBase.resetPSTaskServerId();
                return true;
            }
            case 119: {
                pSDevSlnSysBase.resetPSTaskServerName();
                return true;
            }
            case 120: {
                pSDevSlnSysBase.resetPubCode();
                return true;
            }
            case 121: {
                pSDevSlnSysBase.resetResReadyTime();
                return true;
            }
            case 122: {
                pSDevSlnSysBase.resetROGitBranch();
                return true;
            }
            case 123: {
                pSDevSlnSysBase.resetROGitPath();
                return true;
            }
            case 124: {
                pSDevSlnSysBase.resetROPSDevCenterSvnId();
                return true;
            }
            case 125: {
                pSDevSlnSysBase.resetROPSDevCenterSvnName();
                return true;
            }
            case 126: {
                pSDevSlnSysBase.resetRTModelPSDevCenterSVNId();
                return true;
            }
            case 127: {
                pSDevSlnSysBase.resetRTModelPSDevCenterSVNName();
                return true;
            }
            case 128: {
                pSDevSlnSysBase.resetSaaSMode();
                return true;
            }
            case 129: {
                pSDevSlnSysBase.resetSFPSSubSysId();
                return true;
            }
            case 130: {
                pSDevSlnSysBase.resetSFPSSubSysName();
                return true;
            }
            case 131: {
                pSDevSlnSysBase.resetShareFlag();
                return true;
            }
            case 132: {
                pSDevSlnSysBase.resetStudioTag();
                return true;
            }
            case 133: {
                pSDevSlnSysBase.resetStudioTag2();
                return true;
            }
            case 134: {
                pSDevSlnSysBase.resetStudioVer();
                return true;
            }
            case 135: {
                pSDevSlnSysBase.resetSysFolder();
                return true;
            }
            case 136: {
                pSDevSlnSysBase.resetSysMDUrl();
                return true;
            }
            case 137: {
                pSDevSlnSysBase.resetSysRowKey();
                return true;
            }
            case 138: {
                pSDevSlnSysBase.resetSysTag();
                return true;
            }
            case 139: {
                pSDevSlnSysBase.resetSysTag2();
                return true;
            }
            case 140: {
                pSDevSlnSysBase.resetSysTag3();
                return true;
            }
            case 141: {
                pSDevSlnSysBase.resetSysTag4();
                return true;
            }
            case 142: {
                pSDevSlnSysBase.resetSysType();
                return true;
            }
            case 143: {
                pSDevSlnSysBase.resetSysVer();
                return true;
            }
            case 144: {
                pSDevSlnSysBase.resetTemplEngine();
                return true;
            }
            case 145: {
                pSDevSlnSysBase.resetThemeCssStyle();
                return true;
            }
            case 146: {
                pSDevSlnSysBase.resetUnloadTime();
                return true;
            }
            case 147: {
                pSDevSlnSysBase.resetUpdateDate();
                return true;
            }
            case 148: {
                pSDevSlnSysBase.resetUpdateMan();
                return true;
            }
            case 149: {
                pSDevSlnSysBase.resetUserCat();
                return true;
            }
            case 150: {
                pSDevSlnSysBase.resetUserTag();
                return true;
            }
            case 151: {
                pSDevSlnSysBase.resetUserTag2();
                return true;
            }
            case 152: {
                pSDevSlnSysBase.resetUserTag3();
                return true;
            }
            case 153: {
                pSDevSlnSysBase.resetUserTag4();
                return true;
            }
            case 154: {
                pSDevSlnSysBase.resetValidFlag();
                return true;
            }
            case 155: {
                pSDevSlnSysBase.resetVCType();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDBDevInst getJitPSDBDevInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getJitPSDBDevInst();
        }
        if (this.getJITPSDBDevInstId() == null) {
            return null;
        }
        Integer n = this.objJitPSDBDevInstLock;
        synchronized (n) {
            if (this.jitpsdbdevinst != null && DataTypeHelper.compare((int)25, (Object)this.getJITPSDBDevInstId(), (Object)this.jitpsdbdevinst.getPSDBDevInstId()) != 0L) {
                this.jitpsdbdevinst = null;
            }
            if (this.jitpsdbdevinst == null) {
                PSDBDevInst pSDBDevInst = new PSDBDevInst();
                pSDBDevInst.setPSDBDevInstId(this.getJITPSDBDevInstId());
                PSDBDevInstService pSDBDevInstService = (PSDBDevInstService)ServiceGlobal.getService(PSDBDevInstService.class, (SessionFactory)this.getSessionFactory());
                pSDBDevInstService.autoGet(pSDBDevInst);
                this.jitpsdbdevinst = pSDBDevInst;
            }
            return this.jitpsdbdevinst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCBDInst getHBasePSDCDBInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHBasePSDCDBInst();
        }
        if (this.getHBasePSDCBDInstId() == null) {
            return null;
        }
        Integer n = this.objHBasePSDCDBInstLock;
        synchronized (n) {
            if (this.hbasepsdcdbinst != null && DataTypeHelper.compare((int)25, (Object)this.getHBasePSDCBDInstId(), (Object)this.hbasepsdcdbinst.getPSDCBDInstId()) != 0L) {
                this.hbasepsdcdbinst = null;
            }
            if (this.hbasepsdcdbinst == null) {
                PSDCBDInst pSDCBDInst = new PSDCBDInst();
                pSDCBDInst.setPSDCBDInstId(this.getHBasePSDCBDInstId());
                PSDCBDInstService pSDCBDInstService = (PSDCBDInstService)ServiceGlobal.getService(PSDCBDInstService.class, (SessionFactory)this.getSessionFactory());
                pSDCBDInstService.autoGet(pSDCBDInst);
                this.hbasepsdcdbinst = pSDCBDInst;
            }
            return this.hbasepsdcdbinst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCDeployCenter getPSDCDeployCenter() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCDeployCenter();
        }
        if (this.getPSDCDeployCenterId() == null) {
            return null;
        }
        Integer n = this.objPSDCDeployCenterLock;
        synchronized (n) {
            if (this.psdcdeploycenter != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCDeployCenterId(), (Object)this.psdcdeploycenter.getPSDCDeployCenterId()) != 0L) {
                this.psdcdeploycenter = null;
            }
            if (this.psdcdeploycenter == null) {
                PSDCDeployCenter pSDCDeployCenter = new PSDCDeployCenter();
                pSDCDeployCenter.setPSDCDeployCenterId(this.getPSDCDeployCenterId());
                PSDCDeployCenterService pSDCDeployCenterService = (PSDCDeployCenterService)ServiceGlobal.getService(PSDCDeployCenterService.class, (SessionFactory)this.getSessionFactory());
                pSDCDeployCenterService.autoGet(pSDCDeployCenter);
                this.psdcdeploycenter = pSDCDeployCenter;
            }
            return this.psdcdeploycenter;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCModelTempl getPSDCModelTempl() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCModelTempl();
        }
        if (this.getPSDCModelTemplId() == null) {
            return null;
        }
        Integer n = this.objPSDCModelTemplLock;
        synchronized (n) {
            if (this.psdcmodeltempl != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCModelTemplId(), (Object)this.psdcmodeltempl.getPSDCModelTemplId()) != 0L) {
                this.psdcmodeltempl = null;
            }
            if (this.psdcmodeltempl == null) {
                PSDCModelTempl pSDCModelTempl = new PSDCModelTempl();
                pSDCModelTempl.setPSDCModelTemplId(this.getPSDCModelTemplId());
                PSDCModelTemplService pSDCModelTemplService = (PSDCModelTemplService)ServiceGlobal.getService(PSDCModelTemplService.class, (SessionFactory)this.getSessionFactory());
                pSDCModelTemplService.autoGet(pSDCModelTempl);
                this.psdcmodeltempl = pSDCModelTempl;
            }
            return this.psdcmodeltempl;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCRobot getPSDCRobot() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCRobot();
        }
        if (this.getPSDCRobotId() == null) {
            return null;
        }
        Integer n = this.objPSDCRobotLock;
        synchronized (n) {
            if (this.psdcrobot != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCRobotId(), (Object)this.psdcrobot.getPSDCRobotId()) != 0L) {
                this.psdcrobot = null;
            }
            if (this.psdcrobot == null) {
                PSDCRobot pSDCRobot = new PSDCRobot();
                pSDCRobot.setPSDCRobotId(this.getPSDCRobotId());
                PSDCRobotService pSDCRobotService = (PSDCRobotService)ServiceGlobal.getService(PSDCRobotService.class, (SessionFactory)this.getSessionFactory());
                pSDCRobotService.autoGet(pSDCRobot);
                this.psdcrobot = pSDCRobot;
            }
            return this.psdcrobot;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCSysLic getPSDCSysLic() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCSysLic();
        }
        if (this.getPSDCSysLicId() == null) {
            return null;
        }
        Integer n = this.objPSDCSysLicLock;
        synchronized (n) {
            if (this.psdcsyslic != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCSysLicId(), (Object)this.psdcsyslic.getPSDCSysLicId()) != 0L) {
                this.psdcsyslic = null;
            }
            if (this.psdcsyslic == null) {
                PSDCSysLic pSDCSysLic = new PSDCSysLic();
                pSDCSysLic.setPSDCSysLicId(this.getPSDCSysLicId());
                PSDCSysLicService pSDCSysLicService = (PSDCSysLicService)ServiceGlobal.getService(PSDCSysLicService.class, (SessionFactory)this.getSessionFactory());
                pSDCSysLicService.autoGet(pSDCSysLic);
                this.psdcsyslic = pSDCSysLic;
            }
            return this.psdcsyslic;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterAS getPSDevCenterAS() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterAS();
        }
        if (this.getPSDevCenterASId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterASLock;
        synchronized (n) {
            if (this.psdevcenteras != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterASId(), (Object)this.psdevcenteras.getPSDevCenterASId()) != 0L) {
                this.psdevcenteras = null;
            }
            if (this.psdevcenteras == null) {
                PSDevCenterAS pSDevCenterAS = new PSDevCenterAS();
                pSDevCenterAS.setPSDevCenterASId(this.getPSDevCenterASId());
                PSDevCenterASService pSDevCenterASService = (PSDevCenterASService)ServiceGlobal.getService(PSDevCenterASService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterASService.autoGet(pSDevCenterAS);
                this.psdevcenteras = pSDevCenterAS;
            }
            return this.psdevcenteras;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterAS getPSDevCenterAS2() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterAS2();
        }
        if (this.getPSDevCenterASId2() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterAS2Lock;
        synchronized (n) {
            if (this.psdevcenteras2 != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterASId2(), (Object)this.psdevcenteras2.getPSDevCenterASId()) != 0L) {
                this.psdevcenteras2 = null;
            }
            if (this.psdevcenteras2 == null) {
                PSDevCenterAS pSDevCenterAS = new PSDevCenterAS();
                pSDevCenterAS.setPSDevCenterASId(this.getPSDevCenterASId2());
                PSDevCenterASService pSDevCenterASService = (PSDevCenterASService)ServiceGlobal.getService(PSDevCenterASService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterASService.autoGet(pSDevCenterAS);
                this.psdevcenteras2 = pSDevCenterAS;
            }
            return this.psdevcenteras2;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterAS getPSDevCenterAS3() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterAS3();
        }
        if (this.getPSDevCenterAS3Id() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterAS3Lock;
        synchronized (n) {
            if (this.psdevcenteras3 != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterAS3Id(), (Object)this.psdevcenteras3.getPSDevCenterASId()) != 0L) {
                this.psdevcenteras3 = null;
            }
            if (this.psdevcenteras3 == null) {
                PSDevCenterAS pSDevCenterAS = new PSDevCenterAS();
                pSDevCenterAS.setPSDevCenterASId(this.getPSDevCenterAS3Id());
                PSDevCenterASService pSDevCenterASService = (PSDevCenterASService)ServiceGlobal.getService(PSDevCenterASService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterASService.autoGet(pSDevCenterAS);
                this.psdevcenteras3 = pSDevCenterAS;
            }
            return this.psdevcenteras3;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterAS getPSDevCenterAS4() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterAS4();
        }
        if (this.getPSDevCenterAS4Id() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterAS4Lock;
        synchronized (n) {
            if (this.psdevcenteras4 != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterAS4Id(), (Object)this.psdevcenteras4.getPSDevCenterASId()) != 0L) {
                this.psdevcenteras4 = null;
            }
            if (this.psdevcenteras4 == null) {
                PSDevCenterAS pSDevCenterAS = new PSDevCenterAS();
                pSDevCenterAS.setPSDevCenterASId(this.getPSDevCenterAS4Id());
                PSDevCenterASService pSDevCenterASService = (PSDevCenterASService)ServiceGlobal.getService(PSDevCenterASService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterASService.autoGet(pSDevCenterAS);
                this.psdevcenteras4 = pSDevCenterAS;
            }
            return this.psdevcenteras4;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterDBInst getDB2PSDCDBInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDB2PSDCDBInst();
        }
        if (this.getDB2PSDCDBInstId() == null) {
            return null;
        }
        Integer n = this.objDB2PSDCDBInstLock;
        synchronized (n) {
            if (this.db2psdcdbinst != null && DataTypeHelper.compare((int)25, (Object)this.getDB2PSDCDBInstId(), (Object)this.db2psdcdbinst.getPSDevCenterDBInstId()) != 0L) {
                this.db2psdcdbinst = null;
            }
            if (this.db2psdcdbinst == null) {
                PSDevCenterDBInst pSDevCenterDBInst = new PSDevCenterDBInst();
                pSDevCenterDBInst.setPSDevCenterDBInstId(this.getDB2PSDCDBInstId());
                PSDevCenterDBInstService pSDevCenterDBInstService = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterDBInstService.autoGet(pSDevCenterDBInst);
                this.db2psdcdbinst = pSDevCenterDBInst;
            }
            return this.db2psdcdbinst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterDBInst getMSSQLPSDCDBInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMSSQLPSDCDBInst();
        }
        if (this.getMSSQLPSDCDBInstId() == null) {
            return null;
        }
        Integer n = this.objMSSQLPSDCDBInstLock;
        synchronized (n) {
            if (this.mssqlpsdcdbinst != null && DataTypeHelper.compare((int)25, (Object)this.getMSSQLPSDCDBInstId(), (Object)this.mssqlpsdcdbinst.getPSDevCenterDBInstId()) != 0L) {
                this.mssqlpsdcdbinst = null;
            }
            if (this.mssqlpsdcdbinst == null) {
                PSDevCenterDBInst pSDevCenterDBInst = new PSDevCenterDBInst();
                pSDevCenterDBInst.setPSDevCenterDBInstId(this.getMSSQLPSDCDBInstId());
                PSDevCenterDBInstService pSDevCenterDBInstService = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterDBInstService.autoGet(pSDevCenterDBInst);
                this.mssqlpsdcdbinst = pSDevCenterDBInst;
            }
            return this.mssqlpsdcdbinst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterDBInst getMySQLPSDCDBInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMySQLPSDCDBInst();
        }
        if (this.getMySQLPSDCDBInstId() == null) {
            return null;
        }
        Integer n = this.objMySQLPSDCDBInstLock;
        synchronized (n) {
            if (this.mysqlpsdcdbinst != null && DataTypeHelper.compare((int)25, (Object)this.getMySQLPSDCDBInstId(), (Object)this.mysqlpsdcdbinst.getPSDevCenterDBInstId()) != 0L) {
                this.mysqlpsdcdbinst = null;
            }
            if (this.mysqlpsdcdbinst == null) {
                PSDevCenterDBInst pSDevCenterDBInst = new PSDevCenterDBInst();
                pSDevCenterDBInst.setPSDevCenterDBInstId(this.getMySQLPSDCDBInstId());
                PSDevCenterDBInstService pSDevCenterDBInstService = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterDBInstService.autoGet(pSDevCenterDBInst);
                this.mysqlpsdcdbinst = pSDevCenterDBInst;
            }
            return this.mysqlpsdcdbinst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterDBInst getOraPSDCDBInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOraPSDCDBInst();
        }
        if (this.getOraPSDCDBInstId() == null) {
            return null;
        }
        Integer n = this.objOraPSDCDBInstLock;
        synchronized (n) {
            if (this.orapsdcdbinst != null && DataTypeHelper.compare((int)25, (Object)this.getOraPSDCDBInstId(), (Object)this.orapsdcdbinst.getPSDevCenterDBInstId()) != 0L) {
                this.orapsdcdbinst = null;
            }
            if (this.orapsdcdbinst == null) {
                PSDevCenterDBInst pSDevCenterDBInst = new PSDevCenterDBInst();
                pSDevCenterDBInst.setPSDevCenterDBInstId(this.getOraPSDCDBInstId());
                PSDevCenterDBInstService pSDevCenterDBInstService = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterDBInstService.autoGet(pSDevCenterDBInst);
                this.orapsdcdbinst = pSDevCenterDBInst;
            }
            return this.orapsdcdbinst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterDBInst getPGSQLPSDCDBInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPGSQLPSDCDBInst();
        }
        if (this.getPGSQLPSDCDBInstId() == null) {
            return null;
        }
        Integer n = this.objPGSQLPSDCDBInstLock;
        synchronized (n) {
            if (this.pgsqlpsdcdbinst != null && DataTypeHelper.compare((int)25, (Object)this.getPGSQLPSDCDBInstId(), (Object)this.pgsqlpsdcdbinst.getPSDevCenterDBInstId()) != 0L) {
                this.pgsqlpsdcdbinst = null;
            }
            if (this.pgsqlpsdcdbinst == null) {
                PSDevCenterDBInst pSDevCenterDBInst = new PSDevCenterDBInst();
                pSDevCenterDBInst.setPSDevCenterDBInstId(this.getPGSQLPSDCDBInstId());
                PSDevCenterDBInstService pSDevCenterDBInstService = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterDBInstService.autoGet(pSDevCenterDBInst);
                this.pgsqlpsdcdbinst = pSDevCenterDBInst;
            }
            return this.pgsqlpsdcdbinst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterDBInst getPPASPSDCDBInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPASPSDCDBInst();
        }
        if (this.getPPASPSDCDBInstId() == null) {
            return null;
        }
        Integer n = this.objPPASPSDCDBInstLock;
        synchronized (n) {
            if (this.ppaspsdcdbinst != null && DataTypeHelper.compare((int)25, (Object)this.getPPASPSDCDBInstId(), (Object)this.ppaspsdcdbinst.getPSDevCenterDBInstId()) != 0L) {
                this.ppaspsdcdbinst = null;
            }
            if (this.ppaspsdcdbinst == null) {
                PSDevCenterDBInst pSDevCenterDBInst = new PSDevCenterDBInst();
                pSDevCenterDBInst.setPSDevCenterDBInstId(this.getPPASPSDCDBInstId());
                PSDevCenterDBInstService pSDevCenterDBInstService = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterDBInstService.autoGet(pSDevCenterDBInst);
                this.ppaspsdcdbinst = pSDevCenterDBInst;
            }
            return this.ppaspsdcdbinst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterSVN getDocPSDevCenterSVN() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDocPSDevCenterSVN();
        }
        if (this.getDocPSDevCenterSVNId() == null) {
            return null;
        }
        Integer n = this.objDocPSDevCenterSVNLock;
        synchronized (n) {
            if (this.docpsdevcentersvn != null && DataTypeHelper.compare((int)25, (Object)this.getDocPSDevCenterSVNId(), (Object)this.docpsdevcentersvn.getPSDevCenterSVNId()) != 0L) {
                this.docpsdevcentersvn = null;
            }
            if (this.docpsdevcentersvn == null) {
                PSDevCenterSVN pSDevCenterSVN = new PSDevCenterSVN();
                pSDevCenterSVN.setPSDevCenterSVNId(this.getDocPSDevCenterSVNId());
                PSDevCenterSVNService pSDevCenterSVNService = (PSDevCenterSVNService)ServiceGlobal.getService(PSDevCenterSVNService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterSVNService.autoGet(pSDevCenterSVN);
                this.docpsdevcentersvn = pSDevCenterSVN;
            }
            return this.docpsdevcentersvn;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterSVN getModelPSDevCenterSVN() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelPSDevCenterSVN();
        }
        if (this.getModelPSDevCenterSVNId() == null) {
            return null;
        }
        Integer n = this.objModelPSDevCenterSVNLock;
        synchronized (n) {
            if (this.modelpsdevcentersvn != null && DataTypeHelper.compare((int)25, (Object)this.getModelPSDevCenterSVNId(), (Object)this.modelpsdevcentersvn.getPSDevCenterSVNId()) != 0L) {
                this.modelpsdevcentersvn = null;
            }
            if (this.modelpsdevcentersvn == null) {
                PSDevCenterSVN pSDevCenterSVN = new PSDevCenterSVN();
                pSDevCenterSVN.setPSDevCenterSVNId(this.getModelPSDevCenterSVNId());
                PSDevCenterSVNService pSDevCenterSVNService = (PSDevCenterSVNService)ServiceGlobal.getService(PSDevCenterSVNService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterSVNService.autoGet(pSDevCenterSVN);
                this.modelpsdevcentersvn = pSDevCenterSVN;
            }
            return this.modelpsdevcentersvn;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterSVN getPSDevCenterSVN() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterSVN();
        }
        if (this.getPSDevCenterSVNId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterSVNLock;
        synchronized (n) {
            if (this.psdevcentersvn != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterSVNId(), (Object)this.psdevcentersvn.getPSDevCenterSVNId()) != 0L) {
                this.psdevcentersvn = null;
            }
            if (this.psdevcentersvn == null) {
                PSDevCenterSVN pSDevCenterSVN = new PSDevCenterSVN();
                pSDevCenterSVN.setPSDevCenterSVNId(this.getPSDevCenterSVNId());
                PSDevCenterSVNService pSDevCenterSVNService = (PSDevCenterSVNService)ServiceGlobal.getService(PSDevCenterSVNService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterSVNService.autoGet(pSDevCenterSVN);
                this.psdevcentersvn = pSDevCenterSVN;
            }
            return this.psdevcentersvn;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterSVN getROPSDevCenterSvn() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getROPSDevCenterSvn();
        }
        if (this.getROPSDevCenterSvnId() == null) {
            return null;
        }
        Integer n = this.objROPSDevCenterSvnLock;
        synchronized (n) {
            if (this.ropsdevcentersvn != null && DataTypeHelper.compare((int)25, (Object)this.getROPSDevCenterSvnId(), (Object)this.ropsdevcentersvn.getPSDevCenterSVNId()) != 0L) {
                this.ropsdevcentersvn = null;
            }
            if (this.ropsdevcentersvn == null) {
                PSDevCenterSVN pSDevCenterSVN = new PSDevCenterSVN();
                pSDevCenterSVN.setPSDevCenterSVNId(this.getROPSDevCenterSvnId());
                PSDevCenterSVNService pSDevCenterSVNService = (PSDevCenterSVNService)ServiceGlobal.getService(PSDevCenterSVNService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterSVNService.autoGet(pSDevCenterSVN);
                this.ropsdevcentersvn = pSDevCenterSVN;
            }
            return this.ropsdevcentersvn;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterSVN getRTModelPSDevCenterSVN() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRTModelPSDevCenterSVN();
        }
        if (this.getRTModelPSDevCenterSVNId() == null) {
            return null;
        }
        Integer n = this.objRTModelPSDevCenterSVNLock;
        synchronized (n) {
            if (this.rtmodelpsdevcentersvn != null && DataTypeHelper.compare((int)25, (Object)this.getRTModelPSDevCenterSVNId(), (Object)this.rtmodelpsdevcentersvn.getPSDevCenterSVNId()) != 0L) {
                this.rtmodelpsdevcentersvn = null;
            }
            if (this.rtmodelpsdevcentersvn == null) {
                PSDevCenterSVN pSDevCenterSVN = new PSDevCenterSVN();
                pSDevCenterSVN.setPSDevCenterSVNId(this.getRTModelPSDevCenterSVNId());
                PSDevCenterSVNService pSDevCenterSVNService = (PSDevCenterSVNService)ServiceGlobal.getService(PSDevCenterSVNService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterSVNService.autoGet(pSDevCenterSVN);
                this.rtmodelpsdevcentersvn = pSDevCenterSVN;
            }
            return this.rtmodelpsdevcentersvn;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterTS getJITPSDevCenterTS() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getJITPSDevCenterTS();
        }
        if (this.getJITPSDevCenterTSId() == null) {
            return null;
        }
        Integer n = this.objJITPSDevCenterTSLock;
        synchronized (n) {
            if (this.jitpsdevcenterts != null && DataTypeHelper.compare((int)25, (Object)this.getJITPSDevCenterTSId(), (Object)this.jitpsdevcenterts.getPSDevCenterTSId()) != 0L) {
                this.jitpsdevcenterts = null;
            }
            if (this.jitpsdevcenterts == null) {
                PSDevCenterTS pSDevCenterTS = new PSDevCenterTS();
                pSDevCenterTS.setPSDevCenterTSId(this.getJITPSDevCenterTSId());
                PSDevCenterTSService pSDevCenterTSService = (PSDevCenterTSService)ServiceGlobal.getService(PSDevCenterTSService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterTSService.autoGet(pSDevCenterTS);
                this.jitpsdevcenterts = pSDevCenterTS;
            }
            return this.jitpsdevcenterts;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterTS getPSDevCenterTS() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterTS();
        }
        if (this.getPSDevCenterTSId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterTSLock;
        synchronized (n) {
            if (this.psdevcenterts != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterTSId(), (Object)this.psdevcenterts.getPSDevCenterTSId()) != 0L) {
                this.psdevcenterts = null;
            }
            if (this.psdevcenterts == null) {
                PSDevCenterTS pSDevCenterTS = new PSDevCenterTS();
                pSDevCenterTS.setPSDevCenterTSId(this.getPSDevCenterTSId());
                PSDevCenterTSService pSDevCenterTSService = (PSDevCenterTSService)ServiceGlobal.getService(PSDevCenterTSService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterTSService.autoGet(pSDevCenterTS);
                this.psdevcenterts = pSDevCenterTS;
            }
            return this.psdevcenterts;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnSysRes getPSDevSlnSysRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysRes();
        }
        if (this.getPSDevSlnSysResId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnSysResLock;
        synchronized (n) {
            if (this.psdevslnsysres != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnSysResId(), (Object)this.psdevslnsysres.getPSDevSlnSysResId()) != 0L) {
                this.psdevslnsysres = null;
            }
            if (this.psdevslnsysres == null) {
                PSDevSlnSysRes pSDevSlnSysRes = new PSDevSlnSysRes();
                pSDevSlnSysRes.setPSDevSlnSysResId(this.getPSDevSlnSysResId());
                PSDevSlnSysResService pSDevSlnSysResService = (PSDevSlnSysResService)ServiceGlobal.getService(PSDevSlnSysResService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysResService.autoGet(pSDevSlnSysRes);
                this.psdevslnsysres = pSDevSlnSysRes;
            }
            return this.psdevslnsysres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnSys getMainPSDevSlnSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMainPSDevSlnSys();
        }
        if (this.getMainPSDevSlnSysId() == null) {
            return null;
        }
        Integer n = this.objMainPSDevSlnSysLock;
        synchronized (n) {
            if (this.mainpsdevslnsys != null && DataTypeHelper.compare((int)25, (Object)this.getMainPSDevSlnSysId(), (Object)this.mainpsdevslnsys.getPSDevSlnSysId()) != 0L) {
                this.mainpsdevslnsys = null;
            }
            if (this.mainpsdevslnsys == null) {
                PSDevSlnSys pSDevSlnSys = new PSDevSlnSys();
                pSDevSlnSys.setPSDevSlnSysId(this.getMainPSDevSlnSysId());
                PSDevSlnSysService pSDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysService.autoGet(pSDevSlnSys);
                this.mainpsdevslnsys = pSDevSlnSys;
            }
            return this.mainpsdevslnsys;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnSys getPPSDevSlnSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDevSlnSys();
        }
        if (this.getPPSDevSlnSysId() == null) {
            return null;
        }
        Integer n = this.objPPSDevSlnSysLock;
        synchronized (n) {
            if (this.ppsdevslnsys != null && DataTypeHelper.compare((int)25, (Object)this.getPPSDevSlnSysId(), (Object)this.ppsdevslnsys.getPSDevSlnSysId()) != 0L) {
                this.ppsdevslnsys = null;
            }
            if (this.ppsdevslnsys == null) {
                PSDevSlnSys pSDevSlnSys = new PSDevSlnSys();
                pSDevSlnSys.setPSDevSlnSysId(this.getPPSDevSlnSysId());
                PSDevSlnSysService pSDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysService.autoGet(pSDevSlnSys);
                this.ppsdevslnsys = pSDevSlnSys;
            }
            return this.ppsdevslnsys;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSln getPSDevSln() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSln();
        }
        if (this.getPSDevSlnId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnLock;
        synchronized (n) {
            if (this.psdevsln != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnId(), (Object)this.psdevsln.getPSDevSlnId()) != 0L) {
                this.psdevsln = null;
            }
            if (this.psdevsln == null) {
                PSDevSln pSDevSln = new PSDevSln();
                pSDevSln.setPSDevSlnId(this.getPSDevSlnId());
                PSDevSlnService pSDevSlnService = (PSDevSlnService)ServiceGlobal.getService(PSDevSlnService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnService.autoGet(pSDevSln);
                this.psdevsln = pSDevSln;
            }
            return this.psdevsln;
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
                pSPFService.autoGet(pSPF);
                this.pspf = pSPF;
            }
            return this.pspf;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSF getPSSF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSF();
        }
        if (this.getPSSFId() == null) {
            return null;
        }
        Integer n = this.objPSSFLock;
        synchronized (n) {
            if (this.pssf != null && DataTypeHelper.compare((int)25, (Object)this.getPSSFId(), (Object)this.pssf.getPSSFId()) != 0L) {
                this.pssf = null;
            }
            if (this.pssf == null) {
                PSSF pSSF = new PSSF();
                pSSF.setPSSFId(this.getPSSFId());
                PSSFService pSSFService = (PSSFService)ServiceGlobal.getService(PSSFService.class, (SessionFactory)this.getSessionFactory());
                pSSFService.autoGet(pSSF);
                this.pssf = pSSF;
            }
            return this.pssf;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSStudioTheme getPSStudioTheme() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSStudioTheme();
        }
        if (this.getPSStudioThemeId() == null) {
            return null;
        }
        Integer n = this.objPSStudioThemeLock;
        synchronized (n) {
            if (this.psstudiotheme != null && DataTypeHelper.compare((int)25, (Object)this.getPSStudioThemeId(), (Object)this.psstudiotheme.getPSStudioThemeId()) != 0L) {
                this.psstudiotheme = null;
            }
            if (this.psstudiotheme == null) {
                PSStudioTheme pSStudioTheme = new PSStudioTheme();
                pSStudioTheme.setPSStudioThemeId(this.getPSStudioThemeId());
                PSStudioThemeService pSStudioThemeService = (PSStudioThemeService)ServiceGlobal.getService(PSStudioThemeService.class, (SessionFactory)this.getSessionFactory());
                pSStudioThemeService.autoGet(pSStudioTheme);
                this.psstudiotheme = pSStudioTheme;
            }
            return this.psstudiotheme;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSubSys getSFPSSubSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSFPSSubSys();
        }
        if (this.getSFPSSubSysId() == null) {
            return null;
        }
        Integer n = this.objSFPSSubSysLock;
        synchronized (n) {
            if (this.sfpssubsys != null && DataTypeHelper.compare((int)25, (Object)this.getSFPSSubSysId(), (Object)this.sfpssubsys.getPSSubSysId()) != 0L) {
                this.sfpssubsys = null;
            }
            if (this.sfpssubsys == null) {
                PSSubSys pSSubSys = new PSSubSys();
                pSSubSys.setPSSubSysId(this.getSFPSSubSysId());
                PSSubSysService pSSubSysService = (PSSubSysService)ServiceGlobal.getService(PSSubSysService.class, (SessionFactory)this.getSessionFactory());
                pSSubSysService.autoGet(pSSubSys);
                this.sfpssubsys = pSSubSys;
            }
            return this.sfpssubsys;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysModelInst getPSSysModelInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelInst();
        }
        if (this.getPSSysModelInstId() == null) {
            return null;
        }
        Integer n = this.objPSSysModelInstLock;
        synchronized (n) {
            if (this.pssysmodelinst != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysModelInstId(), (Object)this.pssysmodelinst.getPSSysModelInstId()) != 0L) {
                this.pssysmodelinst = null;
            }
            if (this.pssysmodelinst == null) {
                PSSysModelInst pSSysModelInst = new PSSysModelInst();
                pSSysModelInst.setPSSysModelInstId(this.getPSSysModelInstId());
                PSSysModelInstService pSSysModelInstService = (PSSysModelInstService)ServiceGlobal.getService(PSSysModelInstService.class, (SessionFactory)this.getSessionFactory());
                pSSysModelInstService.autoGet(pSSysModelInst);
                this.pssysmodelinst = pSSysModelInst;
            }
            return this.pssysmodelinst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysPolicy getPSSysPolicy() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPolicy();
        }
        if (this.getPSSysPolicyId() == null) {
            return null;
        }
        Integer n = this.objPSSysPolicyLock;
        synchronized (n) {
            if (this.pssyspolicy != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysPolicyId(), (Object)this.pssyspolicy.getPSSysPolicyId()) != 0L) {
                this.pssyspolicy = null;
            }
            if (this.pssyspolicy == null) {
                PSSysPolicy pSSysPolicy = new PSSysPolicy();
                pSSysPolicy.setPSSysPolicyId(this.getPSSysPolicyId());
                PSSysPolicyService pSSysPolicyService = (PSSysPolicyService)ServiceGlobal.getService(PSSysPolicyService.class, (SessionFactory)this.getSessionFactory());
                pSSysPolicyService.autoGet(pSSysPolicy);
                this.pssyspolicy = pSSysPolicy;
            }
            return this.pssyspolicy;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSTaskServer getPSTaskServer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSTaskServer();
        }
        if (this.getPSTaskServerId() == null) {
            return null;
        }
        Integer n = this.objPSTaskServerLock;
        synchronized (n) {
            if (this.pstaskserver != null && DataTypeHelper.compare((int)25, (Object)this.getPSTaskServerId(), (Object)this.pstaskserver.getPSTaskServerId()) != 0L) {
                this.pstaskserver = null;
            }
            if (this.pstaskserver == null) {
                PSTaskServer pSTaskServer = new PSTaskServer();
                pSTaskServer.setPSTaskServerId(this.getPSTaskServerId());
                PSTaskServerService pSTaskServerService = (PSTaskServerService)ServiceGlobal.getService(PSTaskServerService.class, (SessionFactory)this.getSessionFactory());
                pSTaskServerService.autoGet(pSTaskServer);
                this.pstaskserver = pSTaskServer;
            }
            return this.pstaskserver;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDCRegistryItem> getPSDCRegistryItems() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCRegistryItems();
        }
        if (this.getPSDevSlnSysId() == null) {
            return null;
        }
        PSDCRegistryItemService pSDCRegistryItemService = (PSDCRegistryItemService)ServiceGlobal.getService(PSDCRegistryItemService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDCRegistryItemsLock;
        synchronized (n) {
            if (this.psdcregistryitems == null) {
                this.psdcregistryitems = pSDCRegistryItemService.selectByPSDevSlnSys(this);
            }
            return this.psdcregistryitems;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDevSlnMSDepRes> getPSDevSlnMSDepReses() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDepReses();
        }
        if (this.getPSDevSlnSysId() == null) {
            return null;
        }
        PSDevSlnMSDepResService pSDevSlnMSDepResService = (PSDevSlnMSDepResService)ServiceGlobal.getService(PSDevSlnMSDepResService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDevSlnMSDepResesLock;
        synchronized (n) {
            if (this.psdevslnmsdepreses == null) {
                this.psdevslnmsdepreses = pSDevSlnMSDepResService.selectByPSDevSlnSys(this);
            }
            return this.psdevslnmsdepreses;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDevSlnSysAPI> getPSDevSlnSysAPIs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysAPIs();
        }
        if (this.getPSDevSlnSysId() == null) {
            return null;
        }
        PSDevSlnSysAPIService pSDevSlnSysAPIService = (PSDevSlnSysAPIService)ServiceGlobal.getService(PSDevSlnSysAPIService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDevSlnSysAPIsLock;
        synchronized (n) {
            if (this.psdevslnsysapis == null) {
                this.psdevslnsysapis = pSDevSlnSysAPIService.selectByPSDevSlnSys(this);
            }
            return this.psdevslnsysapis;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDevSlnSysApp> getPSDevSlnSysApps() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysApps();
        }
        if (this.getPSDevSlnSysId() == null) {
            return null;
        }
        PSDevSlnSysAppService pSDevSlnSysAppService = (PSDevSlnSysAppService)ServiceGlobal.getService(PSDevSlnSysAppService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDevSlnSysAppsLock;
        synchronized (n) {
            if (this.psdevslnsysapps == null) {
                this.psdevslnsysapps = pSDevSlnSysAppService.selectByPSDevSlnSys(this);
            }
            return this.psdevslnsysapps;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDevSlnSysBak> getPSDevSlnSysBaks() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysBaks();
        }
        if (this.getPSDevSlnSysId() == null) {
            return null;
        }
        PSDevSlnSysBakService pSDevSlnSysBakService = (PSDevSlnSysBakService)ServiceGlobal.getService(PSDevSlnSysBakService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDevSlnSysBaksLock;
        synchronized (n) {
            if (this.psdevslnsysbaks == null) {
                this.psdevslnsysbaks = pSDevSlnSysBakService.selectByPSDevSlnSys(this);
            }
            return this.psdevslnsysbaks;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDevSlnSysDepInst> getPSDevSlnSysDepInsts() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysDepInsts();
        }
        if (this.getPSDevSlnSysId() == null) {
            return null;
        }
        PSDevSlnSysDepInstService pSDevSlnSysDepInstService = (PSDevSlnSysDepInstService)ServiceGlobal.getService(PSDevSlnSysDepInstService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDevSlnSysDepInstsLock;
        synchronized (n) {
            if (this.psdevslnsysdepinsts == null) {
                this.psdevslnsysdepinsts = pSDevSlnSysDepInstService.selectByPSDevSlnSys(this);
            }
            return this.psdevslnsysdepinsts;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDevSlnSysDynaInst> getPSDevSlnSysDynaInsts() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysDynaInsts();
        }
        if (this.getPSDevSlnSysId() == null) {
            return null;
        }
        PSDevSlnSysDynaInstService pSDevSlnSysDynaInstService = (PSDevSlnSysDynaInstService)ServiceGlobal.getService(PSDevSlnSysDynaInstService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDevSlnSysDynaInstsLock;
        synchronized (n) {
            if (this.psdevslnsysdynainsts == null) {
                this.psdevslnsysdynainsts = pSDevSlnSysDynaInstService.selectByPSDevSlnSys(this);
            }
            return this.psdevslnsysdynainsts;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDevSlnSysRefLink> getPSDevSlnSysRefLinks() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysRefLinks();
        }
        if (this.getPSDevSlnSysId() == null) {
            return null;
        }
        PSDevSlnSysRefLinkService pSDevSlnSysRefLinkService = (PSDevSlnSysRefLinkService)ServiceGlobal.getService(PSDevSlnSysRefLinkService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDevSlnSysRefLinksLock;
        synchronized (n) {
            if (this.psdevslnsysreflinks == null) {
                this.psdevslnsysreflinks = pSDevSlnSysRefLinkService.selectByPSDevSlnSys(this);
            }
            return this.psdevslnsysreflinks;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDevSlnSysRef> getPSDevSlnSysRefs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysRefs();
        }
        if (this.getPSDevSlnSysId() == null) {
            return null;
        }
        PSDevSlnSysRefService pSDevSlnSysRefService = (PSDevSlnSysRefService)ServiceGlobal.getService(PSDevSlnSysRefService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDevSlnSysRefsLock;
        synchronized (n) {
            if (this.psdevslnsysrefs == null) {
                this.psdevslnsysrefs = pSDevSlnSysRefService.selectByPSDevSlnSys(this);
            }
            return this.psdevslnsysrefs;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDevSlnSysSrv> getPSDevSlnSysSrvs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysSrvs();
        }
        if (this.getPSDevSlnSysId() == null) {
            return null;
        }
        PSDevSlnSysSrvService pSDevSlnSysSrvService = (PSDevSlnSysSrvService)ServiceGlobal.getService(PSDevSlnSysSrvService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDevSlnSysSrvsLock;
        synchronized (n) {
            if (this.psdevslnsyssrvs == null) {
                this.psdevslnsyssrvs = pSDevSlnSysSrvService.selectByPSDevSlnSys(this);
            }
            return this.psdevslnsyssrvs;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDevSlnSysWSGit> getPSDevSlnSysWSGit() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysWSGit();
        }
        if (this.getPSDevSlnSysId() == null) {
            return null;
        }
        PSDevSlnSysWSGitService pSDevSlnSysWSGitService = (PSDevSlnSysWSGitService)ServiceGlobal.getService(PSDevSlnSysWSGitService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDevSlnSysWSGitLock;
        synchronized (n) {
            if (this.psdevslnsyswsgit == null) {
                this.psdevslnsyswsgit = pSDevSlnSysWSGitService.selectByPSDevSlnSys(this);
            }
            return this.psdevslnsyswsgit;
        }
    }

    private PSDevSlnSysBase getProxyEntity() {
        return this.proxyPSDevSlnSysBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevSlnSysBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevSlnSysBase) {
            this.proxyPSDevSlnSysBase = (PSDevSlnSysBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ACTIONOWNER, 0);
        fieldIndexMap.put(FIELD_APIFLAG, 1);
        fieldIndexMap.put(FIELD_CALLBACKTAG, 2);
        fieldIndexMap.put(FIELD_CALLBACKURL, 3);
        fieldIndexMap.put(FIELD_CODENAME, 4);
        fieldIndexMap.put(FIELD_CREATEDATE, 5);
        fieldIndexMap.put(FIELD_CREATEMAN, 6);
        fieldIndexMap.put(FIELD_CURACTION, 7);
        fieldIndexMap.put(FIELD_DB2PSDCDBINSTID, 8);
        fieldIndexMap.put(FIELD_DB2PSDCDBINSTNAME, 9);
        fieldIndexMap.put(FIELD_DBTYPES, 10);
        fieldIndexMap.put(FIELD_DBVERSION, 11);
        fieldIndexMap.put(FIELD_DEPLOYSYSID, 12);
        fieldIndexMap.put(FIELD_DEPLOYSYSORGID, 13);
        fieldIndexMap.put(FIELD_DEPLOYSYSORGSECTORID, 14);
        fieldIndexMap.put(FIELD_DEPLOYSYSTAG, 15);
        fieldIndexMap.put(FIELD_DEPLOYSYSTAG2, 16);
        fieldIndexMap.put(FIELD_DEPLOYSYSTYPE, 17);
        fieldIndexMap.put(FIELD_DEVRESINFO, 18);
        fieldIndexMap.put(FIELD_DEVRESSTATE, 19);
        fieldIndexMap.put(FIELD_DEVSYSSTATE, 20);
        fieldIndexMap.put(FIELD_DOCGITBRANCH, 21);
        fieldIndexMap.put(FIELD_DOCGITPATH, 22);
        fieldIndexMap.put(FIELD_DOCPSDEVCENTERSVNID, 23);
        fieldIndexMap.put(FIELD_DOCPSDEVCENTERSVNNAME, 24);
        fieldIndexMap.put(FIELD_ENABLECALLBACK, 25);
        fieldIndexMap.put(FIELD_ENABLEDB2, 26);
        fieldIndexMap.put(FIELD_ENABLEDEPLOYCENTER, 27);
        fieldIndexMap.put(FIELD_ENABLEDM, 28);
        fieldIndexMap.put(FIELD_ENABLEDYNASYS, 29);
        fieldIndexMap.put(FIELD_ENABLEFOLDERKEY, 30);
        fieldIndexMap.put(FIELD_ENABLEHANA, 31);
        fieldIndexMap.put(FIELD_ENABLEHBASE, 32);
        fieldIndexMap.put(FIELD_ENABLEMYSQL5, 33);
        fieldIndexMap.put(FIELD_ENABLEORACLE, 34);
        fieldIndexMap.put(FIELD_ENABLEPGSQL, 35);
        fieldIndexMap.put(FIELD_ENABLEPPAS, 36);
        fieldIndexMap.put(FIELD_ENABLESQLITE, 37);
        fieldIndexMap.put(FIELD_ENABLESQLSERVER, 38);
        fieldIndexMap.put(FIELD_ENABLEWSSERVER, 39);
        fieldIndexMap.put(FIELD_ENTITYCNT, 40);
        fieldIndexMap.put(FIELD_EXPRIEDTIME, 41);
        fieldIndexMap.put(FIELD_GITBRANCH, 42);
        fieldIndexMap.put(FIELD_GITPATH, 43);
        fieldIndexMap.put(FIELD_HBASEPSDCBDINSTID, 44);
        fieldIndexMap.put(FIELD_HBASEPSDCBDINSTNAME, 45);
        fieldIndexMap.put(FIELD_INITPARAMS, 46);
        fieldIndexMap.put(FIELD_JITPSDBDEVINSTID, 47);
        fieldIndexMap.put(FIELD_JITPSDBDEVINSTNAME, 48);
        fieldIndexMap.put(FIELD_JITPSDEVCENTERTSID, 49);
        fieldIndexMap.put(FIELD_JITPSDEVCENTERTSNAME, 50);
        fieldIndexMap.put(FIELD_LASTACTIVETIME, 51);
        fieldIndexMap.put(FIELD_LOADTIME, 52);
        fieldIndexMap.put(FIELD_LOGICNAME, 53);
        fieldIndexMap.put(FIELD_LOWCODEMODE, 54);
        fieldIndexMap.put(FIELD_MAINPSDEVSLNSYSID, 55);
        fieldIndexMap.put(FIELD_MAINPSDEVSLNSYSNAME, 56);
        fieldIndexMap.put(FIELD_MAXENTITYCNT, 57);
        fieldIndexMap.put(FIELD_MEMO, 58);
        fieldIndexMap.put(FIELD_MODELGITBRANCH, 59);
        fieldIndexMap.put(FIELD_MODELGITPATH, 60);
        fieldIndexMap.put(FIELD_MODELINSTVER, 61);
        fieldIndexMap.put(FIELD_MODELPREFIX, 62);
        fieldIndexMap.put(FIELD_MODELPSDEVCENTERSVNID, 63);
        fieldIndexMap.put(FIELD_MODELPSDEVCENTERSVNNAME, 64);
        fieldIndexMap.put(FIELD_MSSQLPSDCDBINSTID, 65);
        fieldIndexMap.put(FIELD_MSSQLPSDCDBINSTNAME, 66);
        fieldIndexMap.put(FIELD_MYSQLPSDCDBINSTID, 67);
        fieldIndexMap.put(FIELD_MYSQLPSDCDBINSTNAME, 68);
        fieldIndexMap.put(FIELD_OFFLINETIME, 69);
        fieldIndexMap.put(FIELD_ORAPSDCDBINSTID, 70);
        fieldIndexMap.put(FIELD_ORAPSDCDBINSTNAME, 71);
        fieldIndexMap.put(FIELD_PGSQLPSDCDBINSTID, 72);
        fieldIndexMap.put(FIELD_PGSQLPSDCDBINSTNAME, 73);
        fieldIndexMap.put(FIELD_PPASPSDCDBINSTID, 74);
        fieldIndexMap.put(FIELD_PPASPSDCDBINSTNAME, 75);
        fieldIndexMap.put(FIELD_PPSDEVSLNSYSID, 76);
        fieldIndexMap.put(FIELD_PPSDEVSLNSYSNAME, 77);
        fieldIndexMap.put(FIELD_PSDCDEPLOYCENTERID, 78);
        fieldIndexMap.put(FIELD_PSDCDEPLOYCENTERNAME, 79);
        fieldIndexMap.put(FIELD_PSDCMODELTEMPLID, 80);
        fieldIndexMap.put(FIELD_PSDCMODELTEMPLNAME, 81);
        fieldIndexMap.put(FIELD_PSDCROBOTID, 82);
        fieldIndexMap.put(FIELD_PSDCROBOTNAME, 83);
        fieldIndexMap.put(FIELD_PSDCSYSLICID, 84);
        fieldIndexMap.put(FIELD_PSDCSYSLICNAME, 85);
        fieldIndexMap.put(FIELD_PSDCWORKSPACEID, 86);
        fieldIndexMap.put(FIELD_PSDEVCENTERASID, 87);
        fieldIndexMap.put(FIELD_PSDEVCENTERASID2, 88);
        fieldIndexMap.put(FIELD_PSDEVCENTERAS3ID, 89);
        fieldIndexMap.put(FIELD_PSDEVCENTERAS4ID, 90);
        fieldIndexMap.put(FIELD_PSDEVCENTERASNAME, 91);
        fieldIndexMap.put(FIELD_PSDEVCENTERASNAME2, 92);
        fieldIndexMap.put(FIELD_PSDEVCENTERAS3NAME, 93);
        fieldIndexMap.put(FIELD_PSDEVCENTERAS4NAME, 94);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 95);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 96);
        fieldIndexMap.put(FIELD_PSDEVCENTERSVNID, 97);
        fieldIndexMap.put(FIELD_PSDEVCENTERSVNNAME, 98);
        fieldIndexMap.put(FIELD_PSDEVCENTERTSID, 99);
        fieldIndexMap.put(FIELD_PSDEVCENTERTSNAME, 100);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 101);
        fieldIndexMap.put(FIELD_PSDEVSLNNAME, 102);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSID, 103);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSNAME, 104);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSRESID, 105);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSRESNAME, 106);
        fieldIndexMap.put(FIELD_PSPFID, 107);
        fieldIndexMap.put(FIELD_PSPFNAME, 108);
        fieldIndexMap.put(FIELD_PSSFID, 109);
        fieldIndexMap.put(FIELD_PSSFNAME, 110);
        fieldIndexMap.put(FIELD_PSSTUDIOTHEMEID, 111);
        fieldIndexMap.put(FIELD_PSSTUDIOTHEMENAME, 112);
        fieldIndexMap.put(FIELD_PSSYSMODELINSTID, 113);
        fieldIndexMap.put(FIELD_PSSYSMODELINSTNAME, 114);
        fieldIndexMap.put(FIELD_PSSYSPOLICYID, 115);
        fieldIndexMap.put(FIELD_PSSYSPOLICYNAME, 116);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 117);
        fieldIndexMap.put(FIELD_PSTASKSERVERID, 118);
        fieldIndexMap.put(FIELD_PSTASKSERVERNAME, 119);
        fieldIndexMap.put(FIELD_PUBCODE, 120);
        fieldIndexMap.put(FIELD_RESREADYTIME, 121);
        fieldIndexMap.put(FIELD_ROGITBRANCH, 122);
        fieldIndexMap.put(FIELD_ROGITPATH, 123);
        fieldIndexMap.put(FIELD_ROPSDEVCENTERSVNID, 124);
        fieldIndexMap.put(FIELD_ROPSDEVCENTERSVNNAME, 125);
        fieldIndexMap.put(FIELD_RTMODELPSDEVCENTERSVNID, 126);
        fieldIndexMap.put(FIELD_RTMODELPSDEVCENTERSVNNAME, 127);
        fieldIndexMap.put(FIELD_SAASMODE, 128);
        fieldIndexMap.put(FIELD_SFPSSUBSYSID, 129);
        fieldIndexMap.put(FIELD_SFPSSUBSYSNAME, 130);
        fieldIndexMap.put(FIELD_SHAREFLAG, 131);
        fieldIndexMap.put(FIELD_STUDIOTAG, 132);
        fieldIndexMap.put(FIELD_STUDIOTAG2, 133);
        fieldIndexMap.put(FIELD_STUDIOVER, 134);
        fieldIndexMap.put(FIELD_SYSFOLDER, 135);
        fieldIndexMap.put(FIELD_SYSMDURL, 136);
        fieldIndexMap.put(FIELD_SYSROWKEY, 137);
        fieldIndexMap.put(FIELD_SYSTAG, 138);
        fieldIndexMap.put(FIELD_SYSTAG2, 139);
        fieldIndexMap.put(FIELD_SYSTAG3, 140);
        fieldIndexMap.put(FIELD_SYSTAG4, 141);
        fieldIndexMap.put(FIELD_SYSTYPE, 142);
        fieldIndexMap.put(FIELD_SYSVER, 143);
        fieldIndexMap.put(FIELD_TEMPLENGINE, 144);
        fieldIndexMap.put(FIELD_THEMECSSSTYLE, 145);
        fieldIndexMap.put(FIELD_UNLOADTIME, 146);
        fieldIndexMap.put(FIELD_UPDATEDATE, 147);
        fieldIndexMap.put(FIELD_UPDATEMAN, 148);
        fieldIndexMap.put(FIELD_USERCAT, 149);
        fieldIndexMap.put(FIELD_USERTAG, 150);
        fieldIndexMap.put(FIELD_USERTAG2, 151);
        fieldIndexMap.put(FIELD_USERTAG3, 152);
        fieldIndexMap.put(FIELD_USERTAG4, 153);
        fieldIndexMap.put(FIELD_VALIDFLAG, 154);
        fieldIndexMap.put(FIELD_VCTYPE, 155);
    }
}

