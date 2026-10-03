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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPriv;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMsgTempl;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgTemplService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSViewMsgBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSViewMsgBase.class);
    public static final String FIELD_CACHESCOPE = "CACHESCOPE";
    public static final String FIELD_CACHETAG2PSDEFID = "CACHETAG2PSDEFID";
    public static final String FIELD_CACHETAG2PSDEFNAME = "CACHETAG2PSDEFNAME";
    public static final String FIELD_CACHETAGPSDEFID = "CACHETAGPSDEFID";
    public static final String FIELD_CACHETAGPSDEFNAME = "CACHETAGPSDEFNAME";
    public static final String FIELD_CACHETIMEOUT = "CACHETIMEOUT";
    public static final String FIELD_CLSPSDEFID = "CLSPSDEFID";
    public static final String FIELD_CLSPSDEFNAME = "CLSPSDEFNAME";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CONTENT = "CONTENT";
    public static final String FIELD_CONTENTPSDEFID = "CONTENTPSDEFID";
    public static final String FIELD_CONTENTPSDEFNAME = "CONTENTPSDEFNAME";
    public static final String FIELD_CONTENTPSLANRESID = "CONTENTPSLANRESID";
    public static final String FIELD_CONTENTPSLANRESNAME = "CONTENTPSLANRESNAME";
    public static final String FIELD_CONTENTTYPE = "CONTENTTYPE";
    public static final String FIELD_CONTENTTYPEPSDEFID = "CONTENTTYPEPSDEFID";
    public static final String FIELD_CONTENTTYPEPSDEFNAME = "CONTENTTYPEPSDEFNAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String FIELD_DSLINK = "DSLINK";
    public static final String FIELD_DYNAMICMODE = "DYNAMICMODE";
    public static final String FIELD_ENABLECACHE = "ENABLECACHE";
    public static final String FIELD_ENABLEMODE = "ENABLEMODE";
    public static final String FIELD_ENABLEREMOVE = "ENABLEREMOVE";
    public static final String FIELD_GROUPPSDEFID = "GROUPPSDEFID";
    public static final String FIELD_GROUPPSDEFNAME = "GROUPPSDEFNAME";
    public static final String FIELD_ICONPSDEFID = "ICONPSDEFID";
    public static final String FIELD_ICONPSDEFNAME = "ICONPSDEFNAME";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MSGGROUP = "MSGGROUP";
    public static final String FIELD_MSGPOS = "MSGPOS";
    public static final String FIELD_MSGPOSPSDEFID = "MSGPOSPSDEFID";
    public static final String FIELD_MSGPOSPSDEFNAME = "MSGPOSPSDEFNAME";
    public static final String FIELD_MSGTYPE = "MSGTYPE";
    public static final String FIELD_MSGTYPEPSDEFID = "MSGTYPEPSDEFID";
    public static final String FIELD_MSGTYPEPSDEFNAME = "MSGTYPEPSDEFNAME";
    public static final String FIELD_ORDERVALUEPSDEFID = "ORDERVALUEPSDEFID";
    public static final String FIELD_ORDERVALUEPSDEFNAME = "ORDERVALUEPSDEFNAME";
    public static final String FIELD_PREDEFINEDTYPE = "PREDEFINEDTYPE";
    public static final String FIELD_PSDEDSID = "PSDEDSID";
    public static final String FIELD_PSDEDSNAME = "PSDEDSNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDELOGICID = "PSDELOGICID";
    public static final String FIELD_PSDELOGICNAME = "PSDELOGICNAME";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDEOPPRIVID = "PSDEOPPRIVID";
    public static final String FIELD_PSDEOPPRIVNAME = "PSDEOPPRIVNAME";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSCSSID = "PSSYSCSSID";
    public static final String FIELD_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String FIELD_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String FIELD_PSSYSMSGTEMPLID = "PSSYSMSGTEMPLID";
    public static final String FIELD_PSSYSMSGTEMPLNAME = "PSSYSMSGTEMPLNAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSSYSVIEWPANELID = "PSSYSVIEWPANELID";
    public static final String FIELD_PSSYSVIEWPANELNAME = "PSSYSVIEWPANELNAME";
    public static final String FIELD_PSVIEWMSGID = "PSVIEWMSGID";
    public static final String FIELD_PSVIEWMSGNAME = "PSVIEWMSGNAME";
    public static final String FIELD_REMOVEPSDEFID = "REMOVEPSDEFID";
    public static final String FIELD_REMOVEPSDEFNAME = "REMOVEPSDEFNAME";
    public static final String FIELD_TESTCUSTOMCODE = "TESTCUSTOMCODE";
    public static final String FIELD_TESTPSDELOGICID = "TESTPSDELOGICID";
    public static final String FIELD_TESTPSDELOGICNAME = "TESTPSDELOGICNAME";
    public static final String FIELD_TIMEOUT = "TIMEOUT";
    public static final String FIELD_TITLE = "TITLE";
    public static final String FIELD_TITLELANRESTAGPSDEFID = "TITLELANRESTAGPSDEFID";
    public static final String FIELD_TITLELANRESTAGPSDEFNAME = "TITLELANRESTAGPSDEFNAME";
    public static final String FIELD_TITLEPSDEFID = "TITLEPSDEFID";
    public static final String FIELD_TITLEPSDEFNAME = "TITLEPSDEFNAME";
    public static final String FIELD_TITLEPSLANRESID = "TITLEPSLANRESID";
    public static final String FIELD_TITLEPSLANRESNAME = "TITLEPSLANRESNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VIEWMSGPARAMS = "VIEWMSGPARAMS";
    public static final String FIELD_VEWMSGTAG = "VIEWMSGTAG";
    public static final String FIELD_VEWMSGTAG2 = "VIEWMSGTAG2";
    private static final int INDEX_CACHESCOPE = 0;
    private static final int INDEX_CACHETAG2PSDEFID = 1;
    private static final int INDEX_CACHETAG2PSDEFNAME = 2;
    private static final int INDEX_CACHETAGPSDEFID = 3;
    private static final int INDEX_CACHETAGPSDEFNAME = 4;
    private static final int INDEX_CACHETIMEOUT = 5;
    private static final int INDEX_CLSPSDEFID = 6;
    private static final int INDEX_CLSPSDEFNAME = 7;
    private static final int INDEX_CODENAME = 8;
    private static final int INDEX_CONTENT = 9;
    private static final int INDEX_CONTENTPSDEFID = 10;
    private static final int INDEX_CONTENTPSDEFNAME = 11;
    private static final int INDEX_CONTENTPSLANRESID = 12;
    private static final int INDEX_CONTENTPSLANRESNAME = 13;
    private static final int INDEX_CONTENTTYPE = 14;
    private static final int INDEX_CONTENTTYPEPSDEFID = 15;
    private static final int INDEX_CONTENTTYPEPSDEFNAME = 16;
    private static final int INDEX_CREATEDATE = 17;
    private static final int INDEX_CREATEMAN = 18;
    private static final int INDEX_DEFAULTFLAG = 19;
    private static final int INDEX_DSLINK = 20;
    private static final int INDEX_DYNAMICMODE = 21;
    private static final int INDEX_ENABLECACHE = 22;
    private static final int INDEX_ENABLEMODE = 23;
    private static final int INDEX_ENABLEREMOVE = 24;
    private static final int INDEX_GROUPPSDEFID = 25;
    private static final int INDEX_GROUPPSDEFNAME = 26;
    private static final int INDEX_ICONPSDEFID = 27;
    private static final int INDEX_ICONPSDEFNAME = 28;
    private static final int INDEX_LOCKFLAG = 29;
    private static final int INDEX_MEMO = 30;
    private static final int INDEX_MSGGROUP = 31;
    private static final int INDEX_MSGPOS = 32;
    private static final int INDEX_MSGPOSPSDEFID = 33;
    private static final int INDEX_MSGPOSPSDEFNAME = 34;
    private static final int INDEX_MSGTYPE = 35;
    private static final int INDEX_MSGTYPEPSDEFID = 36;
    private static final int INDEX_MSGTYPEPSDEFNAME = 37;
    private static final int INDEX_ORDERVALUEPSDEFID = 38;
    private static final int INDEX_ORDERVALUEPSDEFNAME = 39;
    private static final int INDEX_PREDEFINEDTYPE = 40;
    private static final int INDEX_PSDEDSID = 41;
    private static final int INDEX_PSDEDSNAME = 42;
    private static final int INDEX_PSDEID = 43;
    private static final int INDEX_PSDELOGICID = 44;
    private static final int INDEX_PSDELOGICNAME = 45;
    private static final int INDEX_PSDENAME = 46;
    private static final int INDEX_PSDEOPPRIVID = 47;
    private static final int INDEX_PSDEOPPRIVNAME = 48;
    private static final int INDEX_PSMODULEID = 49;
    private static final int INDEX_PSMODULENAME = 50;
    private static final int INDEX_PSSYSCSSID = 51;
    private static final int INDEX_PSSYSCSSNAME = 52;
    private static final int INDEX_PSSYSDYNAMODELID = 53;
    private static final int INDEX_PSSYSDYNAMODELNAME = 54;
    private static final int INDEX_PSSYSIMAGEID = 55;
    private static final int INDEX_PSSYSIMAGENAME = 56;
    private static final int INDEX_PSSYSMSGTEMPLID = 57;
    private static final int INDEX_PSSYSMSGTEMPLNAME = 58;
    private static final int INDEX_PSSYSSFPLUGINID = 59;
    private static final int INDEX_PSSYSSFPLUGINNAME = 60;
    private static final int INDEX_PSSYSTEMID = 61;
    private static final int INDEX_PSSYSTEMNAME = 62;
    private static final int INDEX_PSSYSVIEWPANELID = 63;
    private static final int INDEX_PSSYSVIEWPANELNAME = 64;
    private static final int INDEX_PSVIEWMSGID = 65;
    private static final int INDEX_PSVIEWMSGNAME = 66;
    private static final int INDEX_REMOVEPSDEFID = 67;
    private static final int INDEX_REMOVEPSDEFNAME = 68;
    private static final int INDEX_TESTCUSTOMCODE = 69;
    private static final int INDEX_TESTPSDELOGICID = 70;
    private static final int INDEX_TESTPSDELOGICNAME = 71;
    private static final int INDEX_TIMEOUT = 72;
    private static final int INDEX_TITLE = 73;
    private static final int INDEX_TITLELANRESTAGPSDEFID = 74;
    private static final int INDEX_TITLELANRESTAGPSDEFNAME = 75;
    private static final int INDEX_TITLEPSDEFID = 76;
    private static final int INDEX_TITLEPSDEFNAME = 77;
    private static final int INDEX_TITLEPSLANRESID = 78;
    private static final int INDEX_TITLEPSLANRESNAME = 79;
    private static final int INDEX_UPDATEDATE = 80;
    private static final int INDEX_UPDATEMAN = 81;
    private static final int INDEX_USERCAT = 82;
    private static final int INDEX_USERTAG = 83;
    private static final int INDEX_USERTAG2 = 84;
    private static final int INDEX_USERTAG3 = 85;
    private static final int INDEX_USERTAG4 = 86;
    private static final int INDEX_VIEWMSGPARAMS = 87;
    private static final int INDEX_VEWMSGTAG = 88;
    private static final int INDEX_VEWMSGTAG2 = 89;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSViewMsgBase proxyPSViewMsgBase = null;
    private boolean cachescopeDirtyFlag = false;
    private boolean cachetag2psdefidDirtyFlag = false;
    private boolean cachetag2psdefnameDirtyFlag = false;
    private boolean cachetagpsdefidDirtyFlag = false;
    private boolean cachetagpsdefnameDirtyFlag = false;
    private boolean cachetimeoutDirtyFlag = false;
    private boolean clspsdefidDirtyFlag = false;
    private boolean clspsdefnameDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean contentDirtyFlag = false;
    private boolean contentpsdefidDirtyFlag = false;
    private boolean contentpsdefnameDirtyFlag = false;
    private boolean contentpslanresidDirtyFlag = false;
    private boolean contentpslanresnameDirtyFlag = false;
    private boolean contenttypeDirtyFlag = false;
    private boolean contenttypepsdefidDirtyFlag = false;
    private boolean contenttypepsdefnameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defaultflagDirtyFlag = false;
    private boolean dslinkDirtyFlag = false;
    private boolean dynamicmodeDirtyFlag = false;
    private boolean enablecacheDirtyFlag = false;
    private boolean enablemodeDirtyFlag = false;
    private boolean enableremoveDirtyFlag = false;
    private boolean grouppsdefidDirtyFlag = false;
    private boolean grouppsdefnameDirtyFlag = false;
    private boolean iconpsdefidDirtyFlag = false;
    private boolean iconpsdefnameDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean msggroupDirtyFlag = false;
    private boolean msgposDirtyFlag = false;
    private boolean msgpospsdefidDirtyFlag = false;
    private boolean msgpospsdefnameDirtyFlag = false;
    private boolean msgtypeDirtyFlag = false;
    private boolean msgtypepsdefidDirtyFlag = false;
    private boolean msgtypepsdefnameDirtyFlag = false;
    private boolean ordervaluepsdefidDirtyFlag = false;
    private boolean ordervaluepsdefnameDirtyFlag = false;
    private boolean predefinedtypeDirtyFlag = false;
    private boolean psdedsidDirtyFlag = false;
    private boolean psdedsnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdelogicidDirtyFlag = false;
    private boolean psdelogicnameDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdeopprividDirtyFlag = false;
    private boolean psdeopprivnameDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssyscssidDirtyFlag = false;
    private boolean pssyscssnameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssysimageidDirtyFlag = false;
    private boolean pssysimagenameDirtyFlag = false;
    private boolean pssysmsgtemplidDirtyFlag = false;
    private boolean pssysmsgtemplnameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean pssysviewpanelidDirtyFlag = false;
    private boolean pssysviewpanelnameDirtyFlag = false;
    private boolean psviewmsgidDirtyFlag = false;
    private boolean psviewmsgnameDirtyFlag = false;
    private boolean removepsdefidDirtyFlag = false;
    private boolean removepsdefnameDirtyFlag = false;
    private boolean testcustomcodeDirtyFlag = false;
    private boolean testpsdelogicidDirtyFlag = false;
    private boolean testpsdelogicnameDirtyFlag = false;
    private boolean timeoutDirtyFlag = false;
    private boolean titleDirtyFlag = false;
    private boolean titlelanrestagpsdefidDirtyFlag = false;
    private boolean titlelanrestagpsdefnameDirtyFlag = false;
    private boolean titlepsdefidDirtyFlag = false;
    private boolean titlepsdefnameDirtyFlag = false;
    private boolean titlepslanresidDirtyFlag = false;
    private boolean titlepslanresnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean viewmsgparamsDirtyFlag = false;
    private boolean vewmsgtagDirtyFlag = false;
    private boolean vewmsgtag2DirtyFlag = false;
    @Column(name="cachescope")
    private String cachescope;
    @Column(name="cachetag2psdefid")
    private String cachetag2psdefid;
    @Column(name="cachetag2psdefname")
    private String cachetag2psdefname;
    @Column(name="cachetagpsdefid")
    private String cachetagpsdefid;
    @Column(name="cachetagpsdefname")
    private String cachetagpsdefname;
    @Column(name="cachetimeout")
    private Integer cachetimeout;
    @Column(name="clspsdefid")
    private String clspsdefid;
    @Column(name="clspsdefname")
    private String clspsdefname;
    @Column(name="codename")
    private String codename;
    @Column(name="content")
    private String content;
    @Column(name="contentpsdefid")
    private String contentpsdefid;
    @Column(name="contentpsdefname")
    private String contentpsdefname;
    @Column(name="contentpslanresid")
    private String contentpslanresid;
    @Column(name="contentpslanresname")
    private String contentpslanresname;
    @Column(name="contenttype")
    private String contenttype;
    @Column(name="contenttypepsdefid")
    private String contenttypepsdefid;
    @Column(name="contenttypepsdefname")
    private String contenttypepsdefname;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="defaultflag")
    private Integer defaultflag;
    @Column(name="dslink")
    private String dslink;
    @Column(name="dynamicmode")
    private Integer dynamicmode;
    @Column(name="enablecache")
    private Integer enablecache;
    @Column(name="enablemode")
    private String enablemode;
    @Column(name="enableremove")
    private Integer enableremove;
    @Column(name="grouppsdefid")
    private String grouppsdefid;
    @Column(name="grouppsdefname")
    private String grouppsdefname;
    @Column(name="iconpsdefid")
    private String iconpsdefid;
    @Column(name="iconpsdefname")
    private String iconpsdefname;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
    @Column(name="msggroup")
    private String msggroup;
    @Column(name="msgpos")
    private String msgpos;
    @Column(name="msgpospsdefid")
    private String msgpospsdefid;
    @Column(name="msgpospsdefname")
    private String msgpospsdefname;
    @Column(name="msgtype")
    private String msgtype;
    @Column(name="msgtypepsdefid")
    private String msgtypepsdefid;
    @Column(name="msgtypepsdefname")
    private String msgtypepsdefname;
    @Column(name="ordervaluepsdefid")
    private String ordervaluepsdefid;
    @Column(name="ordervaluepsdefname")
    private String ordervaluepsdefname;
    @Column(name="predefinedtype")
    private String predefinedtype;
    @Column(name="psdedsid")
    private String psdedsid;
    @Column(name="psdedsname")
    private String psdedsname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdelogicid")
    private String psdelogicid;
    @Column(name="psdelogicname")
    private String psdelogicname;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdeopprivid")
    private String psdeopprivid;
    @Column(name="psdeopprivname")
    private String psdeopprivname;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssyscssid")
    private String pssyscssid;
    @Column(name="pssyscssname")
    private String pssyscssname;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssysimageid")
    private String pssysimageid;
    @Column(name="pssysimagename")
    private String pssysimagename;
    @Column(name="pssysmsgtemplid")
    private String pssysmsgtemplid;
    @Column(name="pssysmsgtemplname")
    private String pssysmsgtemplname;
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="pssysviewpanelid")
    private String pssysviewpanelid;
    @Column(name="pssysviewpanelname")
    private String pssysviewpanelname;
    @Column(name="psviewmsgid")
    private String psviewmsgid;
    @Column(name="psviewmsgname")
    private String psviewmsgname;
    @Column(name="removepsdefid")
    private String removepsdefid;
    @Column(name="removepsdefname")
    private String removepsdefname;
    @Column(name="testcustomcode")
    private String testcustomcode;
    @Column(name="testpsdelogicid")
    private String testpsdelogicid;
    @Column(name="testpsdelogicname")
    private String testpsdelogicname;
    @Column(name="timeout")
    private Integer timeout;
    @Column(name="title")
    private String title;
    @Column(name="titlelanrestagpsdefid")
    private String titlelanrestagpsdefid;
    @Column(name="titlelanrestagpsdefname")
    private String titlelanrestagpsdefname;
    @Column(name="titlepsdefid")
    private String titlepsdefid;
    @Column(name="titlepsdefname")
    private String titlepsdefname;
    @Column(name="titlepslanresid")
    private String titlepslanresid;
    @Column(name="titlepslanresname")
    private String titlepslanresname;
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
    @Column(name="viewmsgparams")
    private String viewmsgparams;
    @Column(name="vewmsgtag")
    private String vewmsgtag;
    @Column(name="vewmsgtag2")
    private String vewmsgtag2;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSDEDSLock = new Integer(1);
    private PSDEDataSet psdeds = null;
    private Integer objCacheTag2PSDEFLock = new Integer(1);
    private PSDEField cachetag2psdef = null;
    private Integer objCacheTagPSDEFLock = new Integer(1);
    private PSDEField cachetagpsdef = null;
    private Integer objClsPSDEFLock = new Integer(1);
    private PSDEField clspsdef = null;
    private Integer objContentPSDEFLock = new Integer(1);
    private PSDEField contentpsdef = null;
    private Integer objContentTypePDEFLock = new Integer(1);
    private PSDEField contenttypepdef = null;
    private Integer objGroupPSDEFLock = new Integer(1);
    private PSDEField grouppsdef = null;
    private Integer objIconPSDEFLock = new Integer(1);
    private PSDEField iconpsdef = null;
    private Integer objMsgPosPSDEFLock = new Integer(1);
    private PSDEField msgpospsdef = null;
    private Integer objMsgTypePSDEFLock = new Integer(1);
    private PSDEField msgtypepsdef = null;
    private Integer objOrderValuePSDEFLock = new Integer(1);
    private PSDEField ordervaluepsdef = null;
    private Integer objRemovePSDEFLock = new Integer(1);
    private PSDEField removepsdef = null;
    private Integer objTltleLanResTagPSDEFLock = new Integer(1);
    private PSDEField tltlelanrestagpsdef = null;
    private Integer objTitlePSDEFLock = new Integer(1);
    private PSDEField titlepsdef = null;
    private Integer objPSDELogicLock = new Integer(1);
    private PSDELogic psdelogic = null;
    private Integer objTestPSDELogicLock = new Integer(1);
    private PSDELogic testpsdelogic = null;
    private Integer objPSDEOPPrivLock = new Integer(1);
    private PSDEOPPriv psdeoppriv = null;
    private Integer objContentPSLanResLock = new Integer(1);
    private PSLanguageRes contentpslanres = null;
    private Integer objTitlePSLanResLock = new Integer(1);
    private PSLanguageRes titlepslanres = null;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSysCssLock = new Integer(1);
    private PSSysCss pssyscss = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSysImageLock = new Integer(1);
    private PSSysImage pssysimage = null;
    private Integer objPSSysMsgTemplLock = new Integer(1);
    private PSSysMsgTempl pssysmsgtempl = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSSysViewPanelLock = new Integer(1);
    private PSSysViewPanel pssysviewpanel = null;

    public void setCacheScope(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCacheScope(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cachescope = string;
        this.cachescopeDirtyFlag = true;
    }

    public String getCacheScope() {
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

    public void setCacheTag2PSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCacheTag2PSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cachetag2psdefid = string;
        this.cachetag2psdefidDirtyFlag = true;
    }

    public String getCacheTag2PSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCacheTag2PSDEFId();
        }
        return this.cachetag2psdefid;
    }

    public boolean isCacheTag2PSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCacheTag2PSDEFIdDirty();
        }
        return this.cachetag2psdefidDirtyFlag;
    }

    public void resetCacheTag2PSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCacheTag2PSDEFId();
            return;
        }
        this.cachetag2psdefidDirtyFlag = false;
        this.cachetag2psdefid = null;
    }

    public void setCacheTag2PSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCacheTag2PSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cachetag2psdefname = string;
        this.cachetag2psdefnameDirtyFlag = true;
    }

    public String getCacheTag2PSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCacheTag2PSDEFName();
        }
        return this.cachetag2psdefname;
    }

    public boolean isCacheTag2PSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCacheTag2PSDEFNameDirty();
        }
        return this.cachetag2psdefnameDirtyFlag;
    }

    public void resetCacheTag2PSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCacheTag2PSDEFName();
            return;
        }
        this.cachetag2psdefnameDirtyFlag = false;
        this.cachetag2psdefname = null;
    }

    public void setCacheTagPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCacheTagPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cachetagpsdefid = string;
        this.cachetagpsdefidDirtyFlag = true;
    }

    public String getCacheTagPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCacheTagPSDEFId();
        }
        return this.cachetagpsdefid;
    }

    public boolean isCacheTagPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCacheTagPSDEFIdDirty();
        }
        return this.cachetagpsdefidDirtyFlag;
    }

    public void resetCacheTagPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCacheTagPSDEFId();
            return;
        }
        this.cachetagpsdefidDirtyFlag = false;
        this.cachetagpsdefid = null;
    }

    public void setCacheTagPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCacheTagPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cachetagpsdefname = string;
        this.cachetagpsdefnameDirtyFlag = true;
    }

    public String getCacheTagPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCacheTagPSDEFName();
        }
        return this.cachetagpsdefname;
    }

    public boolean isCacheTagPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCacheTagPSDEFNameDirty();
        }
        return this.cachetagpsdefnameDirtyFlag;
    }

    public void resetCacheTagPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCacheTagPSDEFName();
            return;
        }
        this.cachetagpsdefnameDirtyFlag = false;
        this.cachetagpsdefname = null;
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

    public void setClsPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setClsPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.clspsdefid = string;
        this.clspsdefidDirtyFlag = true;
    }

    public String getClsPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getClsPSDEFId();
        }
        return this.clspsdefid;
    }

    public boolean isClsPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isClsPSDEFIdDirty();
        }
        return this.clspsdefidDirtyFlag;
    }

    public void resetClsPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetClsPSDEFId();
            return;
        }
        this.clspsdefidDirtyFlag = false;
        this.clspsdefid = null;
    }

    public void setClsPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setClsPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.clspsdefname = string;
        this.clspsdefnameDirtyFlag = true;
    }

    public String getClsPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getClsPSDEFName();
        }
        return this.clspsdefname;
    }

    public boolean isClsPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isClsPSDEFNameDirty();
        }
        return this.clspsdefnameDirtyFlag;
    }

    public void resetClsPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetClsPSDEFName();
            return;
        }
        this.clspsdefnameDirtyFlag = false;
        this.clspsdefname = null;
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

    public void setContent(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContent(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.content = string;
        this.contentDirtyFlag = true;
    }

    public String getContent() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContent();
        }
        return this.content;
    }

    public boolean isContentDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContentDirty();
        }
        return this.contentDirtyFlag;
    }

    public void resetContent() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContent();
            return;
        }
        this.contentDirtyFlag = false;
        this.content = null;
    }

    public void setContentPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContentPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.contentpsdefid = string;
        this.contentpsdefidDirtyFlag = true;
    }

    public String getContentPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContentPSDEFId();
        }
        return this.contentpsdefid;
    }

    public boolean isContentPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContentPSDEFIdDirty();
        }
        return this.contentpsdefidDirtyFlag;
    }

    public void resetContentPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContentPSDEFId();
            return;
        }
        this.contentpsdefidDirtyFlag = false;
        this.contentpsdefid = null;
    }

    public void setContentPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContentPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.contentpsdefname = string;
        this.contentpsdefnameDirtyFlag = true;
    }

    public String getContentPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContentPSDEFName();
        }
        return this.contentpsdefname;
    }

    public boolean isContentPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContentPSDEFNameDirty();
        }
        return this.contentpsdefnameDirtyFlag;
    }

    public void resetContentPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContentPSDEFName();
            return;
        }
        this.contentpsdefnameDirtyFlag = false;
        this.contentpsdefname = null;
    }

    public void setContentPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContentPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.contentpslanresid = string;
        this.contentpslanresidDirtyFlag = true;
    }

    public String getContentPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContentPSLanResId();
        }
        return this.contentpslanresid;
    }

    public boolean isContentPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContentPSLanResIdDirty();
        }
        return this.contentpslanresidDirtyFlag;
    }

    public void resetContentPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContentPSLanResId();
            return;
        }
        this.contentpslanresidDirtyFlag = false;
        this.contentpslanresid = null;
    }

    public void setContentPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContentPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.contentpslanresname = string;
        this.contentpslanresnameDirtyFlag = true;
    }

    public String getContentPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContentPSLanResName();
        }
        return this.contentpslanresname;
    }

    public boolean isContentPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContentPSLanResNameDirty();
        }
        return this.contentpslanresnameDirtyFlag;
    }

    public void resetContentPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContentPSLanResName();
            return;
        }
        this.contentpslanresnameDirtyFlag = false;
        this.contentpslanresname = null;
    }

    public void setContentType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContentType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.contenttype = string;
        this.contenttypeDirtyFlag = true;
    }

    public String getContentType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContentType();
        }
        return this.contenttype;
    }

    public boolean isContentTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContentTypeDirty();
        }
        return this.contenttypeDirtyFlag;
    }

    public void resetContentType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContentType();
            return;
        }
        this.contenttypeDirtyFlag = false;
        this.contenttype = null;
    }

    public void setContentTypePSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContentTypePSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.contenttypepsdefid = string;
        this.contenttypepsdefidDirtyFlag = true;
    }

    public String getContentTypePSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContentTypePSDEFId();
        }
        return this.contenttypepsdefid;
    }

    public boolean isContentTypePSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContentTypePSDEFIdDirty();
        }
        return this.contenttypepsdefidDirtyFlag;
    }

    public void resetContentTypePSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContentTypePSDEFId();
            return;
        }
        this.contenttypepsdefidDirtyFlag = false;
        this.contenttypepsdefid = null;
    }

    public void setContentTypePSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContentTypePSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.contenttypepsdefname = string;
        this.contenttypepsdefnameDirtyFlag = true;
    }

    public String getContentTypePSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContentTypePSDEFName();
        }
        return this.contenttypepsdefname;
    }

    public boolean isContentTypePSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContentTypePSDEFNameDirty();
        }
        return this.contenttypepsdefnameDirtyFlag;
    }

    public void resetContentTypePSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContentTypePSDEFName();
            return;
        }
        this.contenttypepsdefnameDirtyFlag = false;
        this.contenttypepsdefname = null;
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

    public void setDefaultFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultFlag(n);
            return;
        }
        this.defaultflag = n;
        this.defaultflagDirtyFlag = true;
    }

    public Integer getDefaultFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultFlag();
        }
        return this.defaultflag;
    }

    public boolean isDefaultFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultFlagDirty();
        }
        return this.defaultflagDirtyFlag;
    }

    public void resetDefaultFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultFlag();
            return;
        }
        this.defaultflagDirtyFlag = false;
        this.defaultflag = null;
    }

    public void setDSLink(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDSLink(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dslink = string;
        this.dslinkDirtyFlag = true;
    }

    public String getDSLink() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDSLink();
        }
        return this.dslink;
    }

    public boolean isDSLinkDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDSLinkDirty();
        }
        return this.dslinkDirtyFlag;
    }

    public void resetDSLink() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDSLink();
            return;
        }
        this.dslinkDirtyFlag = false;
        this.dslink = null;
    }

    public void setDynamicMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynamicMode(n);
            return;
        }
        this.dynamicmode = n;
        this.dynamicmodeDirtyFlag = true;
    }

    public Integer getDynamicMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynamicMode();
        }
        return this.dynamicmode;
    }

    public boolean isDynamicModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynamicModeDirty();
        }
        return this.dynamicmodeDirtyFlag;
    }

    public void resetDynamicMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynamicMode();
            return;
        }
        this.dynamicmodeDirtyFlag = false;
        this.dynamicmode = null;
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

    public void setEnableMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.enablemode = string;
        this.enablemodeDirtyFlag = true;
    }

    public String getEnableMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableMode();
        }
        return this.enablemode;
    }

    public boolean isEnableModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableModeDirty();
        }
        return this.enablemodeDirtyFlag;
    }

    public void resetEnableMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableMode();
            return;
        }
        this.enablemodeDirtyFlag = false;
        this.enablemode = null;
    }

    public void setEnableRemove(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableRemove(n);
            return;
        }
        this.enableremove = n;
        this.enableremoveDirtyFlag = true;
    }

    public Integer getEnableRemove() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableRemove();
        }
        return this.enableremove;
    }

    public boolean isEnableRemoveDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableRemoveDirty();
        }
        return this.enableremoveDirtyFlag;
    }

    public void resetEnableRemove() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableRemove();
            return;
        }
        this.enableremoveDirtyFlag = false;
        this.enableremove = null;
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

    public void setIconPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIconPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.iconpsdefid = string;
        this.iconpsdefidDirtyFlag = true;
    }

    public String getIconPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIconPSDEFId();
        }
        return this.iconpsdefid;
    }

    public boolean isIconPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIconPSDEFIdDirty();
        }
        return this.iconpsdefidDirtyFlag;
    }

    public void resetIconPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIconPSDEFId();
            return;
        }
        this.iconpsdefidDirtyFlag = false;
        this.iconpsdefid = null;
    }

    public void setIconPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIconPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.iconpsdefname = string;
        this.iconpsdefnameDirtyFlag = true;
    }

    public String getIconPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIconPSDEFName();
        }
        return this.iconpsdefname;
    }

    public boolean isIconPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIconPSDEFNameDirty();
        }
        return this.iconpsdefnameDirtyFlag;
    }

    public void resetIconPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIconPSDEFName();
            return;
        }
        this.iconpsdefnameDirtyFlag = false;
        this.iconpsdefname = null;
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

    public void setMsgGroup(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMsgGroup(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.msggroup = string;
        this.msggroupDirtyFlag = true;
    }

    public String getMsgGroup() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMsgGroup();
        }
        return this.msggroup;
    }

    public boolean isMsgGroupDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMsgGroupDirty();
        }
        return this.msggroupDirtyFlag;
    }

    public void resetMsgGroup() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMsgGroup();
            return;
        }
        this.msggroupDirtyFlag = false;
        this.msggroup = null;
    }

    public void setMsgPos(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMsgPos(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.msgpos = string;
        this.msgposDirtyFlag = true;
    }

    public String getMsgPos() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMsgPos();
        }
        return this.msgpos;
    }

    public boolean isMsgPosDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMsgPosDirty();
        }
        return this.msgposDirtyFlag;
    }

    public void resetMsgPos() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMsgPos();
            return;
        }
        this.msgposDirtyFlag = false;
        this.msgpos = null;
    }

    public void setMsgPosPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMsgPosPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.msgpospsdefid = string;
        this.msgpospsdefidDirtyFlag = true;
    }

    public String getMsgPosPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMsgPosPSDEFId();
        }
        return this.msgpospsdefid;
    }

    public boolean isMsgPosPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMsgPosPSDEFIdDirty();
        }
        return this.msgpospsdefidDirtyFlag;
    }

    public void resetMsgPosPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMsgPosPSDEFId();
            return;
        }
        this.msgpospsdefidDirtyFlag = false;
        this.msgpospsdefid = null;
    }

    public void setMsgPosPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMsgPosPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.msgpospsdefname = string;
        this.msgpospsdefnameDirtyFlag = true;
    }

    public String getMsgPosPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMsgPosPSDEFName();
        }
        return this.msgpospsdefname;
    }

    public boolean isMsgPosPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMsgPosPSDEFNameDirty();
        }
        return this.msgpospsdefnameDirtyFlag;
    }

    public void resetMsgPosPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMsgPosPSDEFName();
            return;
        }
        this.msgpospsdefnameDirtyFlag = false;
        this.msgpospsdefname = null;
    }

    public void setMsgType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMsgType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.msgtype = string;
        this.msgtypeDirtyFlag = true;
    }

    public String getMsgType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMsgType();
        }
        return this.msgtype;
    }

    public boolean isMsgTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMsgTypeDirty();
        }
        return this.msgtypeDirtyFlag;
    }

    public void resetMsgType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMsgType();
            return;
        }
        this.msgtypeDirtyFlag = false;
        this.msgtype = null;
    }

    public void setMsgTypePSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMsgTypePSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.msgtypepsdefid = string;
        this.msgtypepsdefidDirtyFlag = true;
    }

    public String getMsgTypePSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMsgTypePSDEFId();
        }
        return this.msgtypepsdefid;
    }

    public boolean isMsgTypePSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMsgTypePSDEFIdDirty();
        }
        return this.msgtypepsdefidDirtyFlag;
    }

    public void resetMsgTypePSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMsgTypePSDEFId();
            return;
        }
        this.msgtypepsdefidDirtyFlag = false;
        this.msgtypepsdefid = null;
    }

    public void setMsgTypePSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMsgTypePSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.msgtypepsdefname = string;
        this.msgtypepsdefnameDirtyFlag = true;
    }

    public String getMsgTypePSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMsgTypePSDEFName();
        }
        return this.msgtypepsdefname;
    }

    public boolean isMsgTypePSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMsgTypePSDEFNameDirty();
        }
        return this.msgtypepsdefnameDirtyFlag;
    }

    public void resetMsgTypePSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMsgTypePSDEFName();
            return;
        }
        this.msgtypepsdefnameDirtyFlag = false;
        this.msgtypepsdefname = null;
    }

    public void setOrderValuePSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrderValuePSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ordervaluepsdefid = string;
        this.ordervaluepsdefidDirtyFlag = true;
    }

    public String getOrderValuePSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrderValuePSDEFId();
        }
        return this.ordervaluepsdefid;
    }

    public boolean isOrderValuePSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrderValuePSDEFIdDirty();
        }
        return this.ordervaluepsdefidDirtyFlag;
    }

    public void resetOrderValuePSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrderValuePSDEFId();
            return;
        }
        this.ordervaluepsdefidDirtyFlag = false;
        this.ordervaluepsdefid = null;
    }

    public void setOrderValuePSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrderValuePSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ordervaluepsdefname = string;
        this.ordervaluepsdefnameDirtyFlag = true;
    }

    public String getOrderValuePSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrderValuePSDEFName();
        }
        return this.ordervaluepsdefname;
    }

    public boolean isOrderValuePSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrderValuePSDEFNameDirty();
        }
        return this.ordervaluepsdefnameDirtyFlag;
    }

    public void resetOrderValuePSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrderValuePSDEFName();
            return;
        }
        this.ordervaluepsdefnameDirtyFlag = false;
        this.ordervaluepsdefname = null;
    }

    public void setPredefinedType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPredefinedType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.predefinedtype = string;
        this.predefinedtypeDirtyFlag = true;
    }

    public String getPredefinedType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPredefinedType();
        }
        return this.predefinedtype;
    }

    public boolean isPredefinedTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPredefinedTypeDirty();
        }
        return this.predefinedtypeDirtyFlag;
    }

    public void resetPredefinedType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPredefinedType();
            return;
        }
        this.predefinedtypeDirtyFlag = false;
        this.predefinedtype = null;
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

    public void setPSDELogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDELogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdelogicid = string;
        this.psdelogicidDirtyFlag = true;
    }

    public String getPSDELogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELogicId();
        }
        return this.psdelogicid;
    }

    public boolean isPSDELogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDELogicIdDirty();
        }
        return this.psdelogicidDirtyFlag;
    }

    public void resetPSDELogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDELogicId();
            return;
        }
        this.psdelogicidDirtyFlag = false;
        this.psdelogicid = null;
    }

    public void setPSDELogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDELogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdelogicname = string;
        this.psdelogicnameDirtyFlag = true;
    }

    public String getPSDELogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELogicName();
        }
        return this.psdelogicname;
    }

    public boolean isPSDELogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDELogicNameDirty();
        }
        return this.psdelogicnameDirtyFlag;
    }

    public void resetPSDELogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDELogicName();
            return;
        }
        this.psdelogicnameDirtyFlag = false;
        this.psdelogicname = null;
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

    public void setPSDEOPPrivId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEOPPrivId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeopprivid = string;
        this.psdeopprividDirtyFlag = true;
    }

    public String getPSDEOPPrivId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEOPPrivId();
        }
        return this.psdeopprivid;
    }

    public boolean isPSDEOPPrivIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEOPPrivIdDirty();
        }
        return this.psdeopprividDirtyFlag;
    }

    public void resetPSDEOPPrivId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEOPPrivId();
            return;
        }
        this.psdeopprividDirtyFlag = false;
        this.psdeopprivid = null;
    }

    public void setPSDEOPPrivName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEOPPrivName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeopprivname = string;
        this.psdeopprivnameDirtyFlag = true;
    }

    public String getPSDEOPPrivName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEOPPrivName();
        }
        return this.psdeopprivname;
    }

    public boolean isPSDEOPPrivNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEOPPrivNameDirty();
        }
        return this.psdeopprivnameDirtyFlag;
    }

    public void resetPSDEOPPrivName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEOPPrivName();
            return;
        }
        this.psdeopprivnameDirtyFlag = false;
        this.psdeopprivname = null;
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

    public void setPSSysImageId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysImageId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysimageid = string;
        this.pssysimageidDirtyFlag = true;
    }

    public String getPSSysImageId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysImageId();
        }
        return this.pssysimageid;
    }

    public boolean isPSSysImageIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysImageIdDirty();
        }
        return this.pssysimageidDirtyFlag;
    }

    public void resetPSSysImageId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysImageId();
            return;
        }
        this.pssysimageidDirtyFlag = false;
        this.pssysimageid = null;
    }

    public void setPSSysImageName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysImageName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysimagename = string;
        this.pssysimagenameDirtyFlag = true;
    }

    public String getPSSysImageName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysImageName();
        }
        return this.pssysimagename;
    }

    public boolean isPSSysImageNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysImageNameDirty();
        }
        return this.pssysimagenameDirtyFlag;
    }

    public void resetPSSysImageName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysImageName();
            return;
        }
        this.pssysimagenameDirtyFlag = false;
        this.pssysimagename = null;
    }

    public void setPSSysMsgTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysMsgTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmsgtemplid = string;
        this.pssysmsgtemplidDirtyFlag = true;
    }

    public String getPSSysMsgTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMsgTemplId();
        }
        return this.pssysmsgtemplid;
    }

    public boolean isPSSysMsgTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysMsgTemplIdDirty();
        }
        return this.pssysmsgtemplidDirtyFlag;
    }

    public void resetPSSysMsgTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysMsgTemplId();
            return;
        }
        this.pssysmsgtemplidDirtyFlag = false;
        this.pssysmsgtemplid = null;
    }

    public void setPSSysMsgTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysMsgTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmsgtemplname = string;
        this.pssysmsgtemplnameDirtyFlag = true;
    }

    public String getPSSysMsgTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMsgTemplName();
        }
        return this.pssysmsgtemplname;
    }

    public boolean isPSSysMsgTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysMsgTemplNameDirty();
        }
        return this.pssysmsgtemplnameDirtyFlag;
    }

    public void resetPSSysMsgTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysMsgTemplName();
            return;
        }
        this.pssysmsgtemplnameDirtyFlag = false;
        this.pssysmsgtemplname = null;
    }

    public void setPSSysSFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpluginid = string;
        this.pssyssfpluginidDirtyFlag = true;
    }

    public String getPSSysSFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPluginId();
        }
        return this.pssyssfpluginid;
    }

    public boolean isPSSysSFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPluginIdDirty();
        }
        return this.pssyssfpluginidDirtyFlag;
    }

    public void resetPSSysSFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPluginId();
            return;
        }
        this.pssyssfpluginidDirtyFlag = false;
        this.pssyssfpluginid = null;
    }

    public void setPSSysSFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpluginname = string;
        this.pssyssfpluginnameDirtyFlag = true;
    }

    public String getPSSysSFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPluginName();
        }
        return this.pssyssfpluginname;
    }

    public boolean isPSSysSFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPluginNameDirty();
        }
        return this.pssyssfpluginnameDirtyFlag;
    }

    public void resetPSSysSFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPluginName();
            return;
        }
        this.pssyssfpluginnameDirtyFlag = false;
        this.pssyssfpluginname = null;
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

    public void setPSViewMsgId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewMsgId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewmsgid = string;
        this.psviewmsgidDirtyFlag = true;
    }

    public String getPSViewMsgId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewMsgId();
        }
        return this.psviewmsgid;
    }

    public boolean isPSViewMsgIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewMsgIdDirty();
        }
        return this.psviewmsgidDirtyFlag;
    }

    public void resetPSViewMsgId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewMsgId();
            return;
        }
        this.psviewmsgidDirtyFlag = false;
        this.psviewmsgid = null;
    }

    public void setPSViewMsgName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewMsgName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewmsgname = string;
        this.psviewmsgnameDirtyFlag = true;
    }

    public String getPSViewMsgName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewMsgName();
        }
        return this.psviewmsgname;
    }

    public boolean isPSViewMsgNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewMsgNameDirty();
        }
        return this.psviewmsgnameDirtyFlag;
    }

    public void resetPSViewMsgName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewMsgName();
            return;
        }
        this.psviewmsgnameDirtyFlag = false;
        this.psviewmsgname = null;
    }

    public void setRemovePSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRemovePSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.removepsdefid = string;
        this.removepsdefidDirtyFlag = true;
    }

    public String getRemovePSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRemovePSDEFId();
        }
        return this.removepsdefid;
    }

    public boolean isRemovePSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRemovePSDEFIdDirty();
        }
        return this.removepsdefidDirtyFlag;
    }

    public void resetRemovePSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRemovePSDEFId();
            return;
        }
        this.removepsdefidDirtyFlag = false;
        this.removepsdefid = null;
    }

    public void setRemovePSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRemovePSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.removepsdefname = string;
        this.removepsdefnameDirtyFlag = true;
    }

    public String getRemovePSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRemovePSDEFName();
        }
        return this.removepsdefname;
    }

    public boolean isRemovePSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRemovePSDEFNameDirty();
        }
        return this.removepsdefnameDirtyFlag;
    }

    public void resetRemovePSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRemovePSDEFName();
            return;
        }
        this.removepsdefnameDirtyFlag = false;
        this.removepsdefname = null;
    }

    public void setTestCustomCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTestCustomCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.testcustomcode = string;
        this.testcustomcodeDirtyFlag = true;
    }

    public String getTestCustomCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTestCustomCode();
        }
        return this.testcustomcode;
    }

    public boolean isTestCustomCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTestCustomCodeDirty();
        }
        return this.testcustomcodeDirtyFlag;
    }

    public void resetTestCustomCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTestCustomCode();
            return;
        }
        this.testcustomcodeDirtyFlag = false;
        this.testcustomcode = null;
    }

    public void setTestPSDELogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTestPSDELogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.testpsdelogicid = string;
        this.testpsdelogicidDirtyFlag = true;
    }

    public String getTestPSDELogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTestPSDELogicId();
        }
        return this.testpsdelogicid;
    }

    public boolean isTestPSDELogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTestPSDELogicIdDirty();
        }
        return this.testpsdelogicidDirtyFlag;
    }

    public void resetTestPSDELogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTestPSDELogicId();
            return;
        }
        this.testpsdelogicidDirtyFlag = false;
        this.testpsdelogicid = null;
    }

    public void setTestPSDELogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTestPSDELogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.testpsdelogicname = string;
        this.testpsdelogicnameDirtyFlag = true;
    }

    public String getTestPSDELogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTestPSDELogicName();
        }
        return this.testpsdelogicname;
    }

    public boolean isTestPSDELogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTestPSDELogicNameDirty();
        }
        return this.testpsdelogicnameDirtyFlag;
    }

    public void resetTestPSDELogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTestPSDELogicName();
            return;
        }
        this.testpsdelogicnameDirtyFlag = false;
        this.testpsdelogicname = null;
    }

    public void setTimeout(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTimeout(n);
            return;
        }
        this.timeout = n;
        this.timeoutDirtyFlag = true;
    }

    public Integer getTimeout() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTimeout();
        }
        return this.timeout;
    }

    public boolean isTimeoutDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTimeoutDirty();
        }
        return this.timeoutDirtyFlag;
    }

    public void resetTimeout() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTimeout();
            return;
        }
        this.timeoutDirtyFlag = false;
        this.timeout = null;
    }

    public void setTitle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTitle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.title = string;
        this.titleDirtyFlag = true;
    }

    public String getTitle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTitle();
        }
        return this.title;
    }

    public boolean isTitleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTitleDirty();
        }
        return this.titleDirtyFlag;
    }

    public void resetTitle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTitle();
            return;
        }
        this.titleDirtyFlag = false;
        this.title = null;
    }

    public void setTitleLanResTagPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTitleLanResTagPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.titlelanrestagpsdefid = string;
        this.titlelanrestagpsdefidDirtyFlag = true;
    }

    public String getTitleLanResTagPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTitleLanResTagPSDEFId();
        }
        return this.titlelanrestagpsdefid;
    }

    public boolean isTitleLanResTagPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTitleLanResTagPSDEFIdDirty();
        }
        return this.titlelanrestagpsdefidDirtyFlag;
    }

    public void resetTitleLanResTagPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTitleLanResTagPSDEFId();
            return;
        }
        this.titlelanrestagpsdefidDirtyFlag = false;
        this.titlelanrestagpsdefid = null;
    }

    public void setTitleLanResTagPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTitleLanResTagPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.titlelanrestagpsdefname = string;
        this.titlelanrestagpsdefnameDirtyFlag = true;
    }

    public String getTitleLanResTagPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTitleLanResTagPSDEFName();
        }
        return this.titlelanrestagpsdefname;
    }

    public boolean isTitleLanResTagPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTitleLanResTagPSDEFNameDirty();
        }
        return this.titlelanrestagpsdefnameDirtyFlag;
    }

    public void resetTitleLanResTagPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTitleLanResTagPSDEFName();
            return;
        }
        this.titlelanrestagpsdefnameDirtyFlag = false;
        this.titlelanrestagpsdefname = null;
    }

    public void setTitlePSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTitlePSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.titlepsdefid = string;
        this.titlepsdefidDirtyFlag = true;
    }

    public String getTitlePSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTitlePSDEFId();
        }
        return this.titlepsdefid;
    }

    public boolean isTitlePSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTitlePSDEFIdDirty();
        }
        return this.titlepsdefidDirtyFlag;
    }

    public void resetTitlePSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTitlePSDEFId();
            return;
        }
        this.titlepsdefidDirtyFlag = false;
        this.titlepsdefid = null;
    }

    public void setTitlePSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTitlePSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.titlepsdefname = string;
        this.titlepsdefnameDirtyFlag = true;
    }

    public String getTitlePSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTitlePSDEFName();
        }
        return this.titlepsdefname;
    }

    public boolean isTitlePSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTitlePSDEFNameDirty();
        }
        return this.titlepsdefnameDirtyFlag;
    }

    public void resetTitlePSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTitlePSDEFName();
            return;
        }
        this.titlepsdefnameDirtyFlag = false;
        this.titlepsdefname = null;
    }

    public void setTitlePSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTitlePSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.titlepslanresid = string;
        this.titlepslanresidDirtyFlag = true;
    }

    public String getTitlePSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTitlePSLanResId();
        }
        return this.titlepslanresid;
    }

    public boolean isTitlePSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTitlePSLanResIdDirty();
        }
        return this.titlepslanresidDirtyFlag;
    }

    public void resetTitlePSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTitlePSLanResId();
            return;
        }
        this.titlepslanresidDirtyFlag = false;
        this.titlepslanresid = null;
    }

    public void setTitlePSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTitlePSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.titlepslanresname = string;
        this.titlepslanresnameDirtyFlag = true;
    }

    public String getTitlePSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTitlePSLanResName();
        }
        return this.titlepslanresname;
    }

    public boolean isTitlePSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTitlePSLanResNameDirty();
        }
        return this.titlepslanresnameDirtyFlag;
    }

    public void resetTitlePSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTitlePSLanResName();
            return;
        }
        this.titlepslanresnameDirtyFlag = false;
        this.titlepslanresname = null;
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

    public void setViewMsgParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewMsgParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.viewmsgparams = string;
        this.viewmsgparamsDirtyFlag = true;
    }

    public String getViewMsgParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewMsgParams();
        }
        return this.viewmsgparams;
    }

    public boolean isViewMsgParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewMsgParamsDirty();
        }
        return this.viewmsgparamsDirtyFlag;
    }

    public void resetViewMsgParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewMsgParams();
            return;
        }
        this.viewmsgparamsDirtyFlag = false;
        this.viewmsgparams = null;
    }

    public void setVewMsgTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVewMsgTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.vewmsgtag = string;
        this.vewmsgtagDirtyFlag = true;
    }

    public String getVewMsgTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVewMsgTag();
        }
        return this.vewmsgtag;
    }

    public boolean isVewMsgTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVewMsgTagDirty();
        }
        return this.vewmsgtagDirtyFlag;
    }

    public void resetVewMsgTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVewMsgTag();
            return;
        }
        this.vewmsgtagDirtyFlag = false;
        this.vewmsgtag = null;
    }

    public void setVewMsgTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVewMsgTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.vewmsgtag2 = string;
        this.vewmsgtag2DirtyFlag = true;
    }

    public String getVewMsgTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVewMsgTag2();
        }
        return this.vewmsgtag2;
    }

    public boolean isVewMsgTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVewMsgTag2Dirty();
        }
        return this.vewmsgtag2DirtyFlag;
    }

    public void resetVewMsgTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVewMsgTag2();
            return;
        }
        this.vewmsgtag2DirtyFlag = false;
        this.vewmsgtag2 = null;
    }

    protected void onReset() {
        PSViewMsgBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSViewMsgBase pSViewMsgBase) {
        pSViewMsgBase.resetCacheScope();
        pSViewMsgBase.resetCacheTag2PSDEFId();
        pSViewMsgBase.resetCacheTag2PSDEFName();
        pSViewMsgBase.resetCacheTagPSDEFId();
        pSViewMsgBase.resetCacheTagPSDEFName();
        pSViewMsgBase.resetCacheTimeout();
        pSViewMsgBase.resetClsPSDEFId();
        pSViewMsgBase.resetClsPSDEFName();
        pSViewMsgBase.resetCodeName();
        pSViewMsgBase.resetContent();
        pSViewMsgBase.resetContentPSDEFId();
        pSViewMsgBase.resetContentPSDEFName();
        pSViewMsgBase.resetContentPSLanResId();
        pSViewMsgBase.resetContentPSLanResName();
        pSViewMsgBase.resetContentType();
        pSViewMsgBase.resetContentTypePSDEFId();
        pSViewMsgBase.resetContentTypePSDEFName();
        pSViewMsgBase.resetCreateDate();
        pSViewMsgBase.resetCreateMan();
        pSViewMsgBase.resetDefaultFlag();
        pSViewMsgBase.resetDSLink();
        pSViewMsgBase.resetDynamicMode();
        pSViewMsgBase.resetEnableCache();
        pSViewMsgBase.resetEnableMode();
        pSViewMsgBase.resetEnableRemove();
        pSViewMsgBase.resetGroupPSDEFId();
        pSViewMsgBase.resetGroupPSDEFName();
        pSViewMsgBase.resetIconPSDEFId();
        pSViewMsgBase.resetIconPSDEFName();
        pSViewMsgBase.resetLockFlag();
        pSViewMsgBase.resetMemo();
        pSViewMsgBase.resetMsgGroup();
        pSViewMsgBase.resetMsgPos();
        pSViewMsgBase.resetMsgPosPSDEFId();
        pSViewMsgBase.resetMsgPosPSDEFName();
        pSViewMsgBase.resetMsgType();
        pSViewMsgBase.resetMsgTypePSDEFId();
        pSViewMsgBase.resetMsgTypePSDEFName();
        pSViewMsgBase.resetOrderValuePSDEFId();
        pSViewMsgBase.resetOrderValuePSDEFName();
        pSViewMsgBase.resetPredefinedType();
        pSViewMsgBase.resetPSDEDSId();
        pSViewMsgBase.resetPSDEDSName();
        pSViewMsgBase.resetPSDEId();
        pSViewMsgBase.resetPSDELogicId();
        pSViewMsgBase.resetPSDELogicName();
        pSViewMsgBase.resetPSDEName();
        pSViewMsgBase.resetPSDEOPPrivId();
        pSViewMsgBase.resetPSDEOPPrivName();
        pSViewMsgBase.resetPSModuleId();
        pSViewMsgBase.resetPSModuleName();
        pSViewMsgBase.resetPSSysCssId();
        pSViewMsgBase.resetPSSysCssName();
        pSViewMsgBase.resetPSSysDynaModelId();
        pSViewMsgBase.resetPSSysDynaModelName();
        pSViewMsgBase.resetPSSysImageId();
        pSViewMsgBase.resetPSSysImageName();
        pSViewMsgBase.resetPSSysMsgTemplId();
        pSViewMsgBase.resetPSSysMsgTemplName();
        pSViewMsgBase.resetPSSysSFPluginId();
        pSViewMsgBase.resetPSSysSFPluginName();
        pSViewMsgBase.resetPSSystemId();
        pSViewMsgBase.resetPSSystemName();
        pSViewMsgBase.resetPSSysViewPanelId();
        pSViewMsgBase.resetPSSysViewPanelName();
        pSViewMsgBase.resetPSViewMsgId();
        pSViewMsgBase.resetPSViewMsgName();
        pSViewMsgBase.resetRemovePSDEFId();
        pSViewMsgBase.resetRemovePSDEFName();
        pSViewMsgBase.resetTestCustomCode();
        pSViewMsgBase.resetTestPSDELogicId();
        pSViewMsgBase.resetTestPSDELogicName();
        pSViewMsgBase.resetTimeout();
        pSViewMsgBase.resetTitle();
        pSViewMsgBase.resetTitleLanResTagPSDEFId();
        pSViewMsgBase.resetTitleLanResTagPSDEFName();
        pSViewMsgBase.resetTitlePSDEFId();
        pSViewMsgBase.resetTitlePSDEFName();
        pSViewMsgBase.resetTitlePSLanResId();
        pSViewMsgBase.resetTitlePSLanResName();
        pSViewMsgBase.resetUpdateDate();
        pSViewMsgBase.resetUpdateMan();
        pSViewMsgBase.resetUserCat();
        pSViewMsgBase.resetUserTag();
        pSViewMsgBase.resetUserTag2();
        pSViewMsgBase.resetUserTag3();
        pSViewMsgBase.resetUserTag4();
        pSViewMsgBase.resetViewMsgParams();
        pSViewMsgBase.resetVewMsgTag();
        pSViewMsgBase.resetVewMsgTag2();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCacheScopeDirty()) {
            hashMap.put(FIELD_CACHESCOPE, this.getCacheScope());
        }
        if (!bl || this.isCacheTag2PSDEFIdDirty()) {
            hashMap.put(FIELD_CACHETAG2PSDEFID, this.getCacheTag2PSDEFId());
        }
        if (!bl || this.isCacheTag2PSDEFNameDirty()) {
            hashMap.put(FIELD_CACHETAG2PSDEFNAME, this.getCacheTag2PSDEFName());
        }
        if (!bl || this.isCacheTagPSDEFIdDirty()) {
            hashMap.put(FIELD_CACHETAGPSDEFID, this.getCacheTagPSDEFId());
        }
        if (!bl || this.isCacheTagPSDEFNameDirty()) {
            hashMap.put(FIELD_CACHETAGPSDEFNAME, this.getCacheTagPSDEFName());
        }
        if (!bl || this.isCacheTimeoutDirty()) {
            hashMap.put(FIELD_CACHETIMEOUT, this.getCacheTimeout());
        }
        if (!bl || this.isClsPSDEFIdDirty()) {
            hashMap.put(FIELD_CLSPSDEFID, this.getClsPSDEFId());
        }
        if (!bl || this.isClsPSDEFNameDirty()) {
            hashMap.put(FIELD_CLSPSDEFNAME, this.getClsPSDEFName());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isContentDirty()) {
            hashMap.put(FIELD_CONTENT, this.getContent());
        }
        if (!bl || this.isContentPSDEFIdDirty()) {
            hashMap.put(FIELD_CONTENTPSDEFID, this.getContentPSDEFId());
        }
        if (!bl || this.isContentPSDEFNameDirty()) {
            hashMap.put(FIELD_CONTENTPSDEFNAME, this.getContentPSDEFName());
        }
        if (!bl || this.isContentPSLanResIdDirty()) {
            hashMap.put(FIELD_CONTENTPSLANRESID, this.getContentPSLanResId());
        }
        if (!bl || this.isContentPSLanResNameDirty()) {
            hashMap.put(FIELD_CONTENTPSLANRESNAME, this.getContentPSLanResName());
        }
        if (!bl || this.isContentTypeDirty()) {
            hashMap.put(FIELD_CONTENTTYPE, this.getContentType());
        }
        if (!bl || this.isContentTypePSDEFIdDirty()) {
            hashMap.put(FIELD_CONTENTTYPEPSDEFID, this.getContentTypePSDEFId());
        }
        if (!bl || this.isContentTypePSDEFNameDirty()) {
            hashMap.put(FIELD_CONTENTTYPEPSDEFNAME, this.getContentTypePSDEFName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDefaultFlagDirty()) {
            hashMap.put(FIELD_DEFAULTFLAG, this.getDefaultFlag());
        }
        if (!bl || this.isDSLinkDirty()) {
            hashMap.put(FIELD_DSLINK, this.getDSLink());
        }
        if (!bl || this.isDynamicModeDirty()) {
            hashMap.put(FIELD_DYNAMICMODE, this.getDynamicMode());
        }
        if (!bl || this.isEnableCacheDirty()) {
            hashMap.put(FIELD_ENABLECACHE, this.getEnableCache());
        }
        if (!bl || this.isEnableModeDirty()) {
            hashMap.put(FIELD_ENABLEMODE, this.getEnableMode());
        }
        if (!bl || this.isEnableRemoveDirty()) {
            hashMap.put(FIELD_ENABLEREMOVE, this.getEnableRemove());
        }
        if (!bl || this.isGroupPSDEFIdDirty()) {
            hashMap.put(FIELD_GROUPPSDEFID, this.getGroupPSDEFId());
        }
        if (!bl || this.isGroupPSDEFNameDirty()) {
            hashMap.put(FIELD_GROUPPSDEFNAME, this.getGroupPSDEFName());
        }
        if (!bl || this.isIconPSDEFIdDirty()) {
            hashMap.put(FIELD_ICONPSDEFID, this.getIconPSDEFId());
        }
        if (!bl || this.isIconPSDEFNameDirty()) {
            hashMap.put(FIELD_ICONPSDEFNAME, this.getIconPSDEFName());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMsgGroupDirty()) {
            hashMap.put(FIELD_MSGGROUP, this.getMsgGroup());
        }
        if (!bl || this.isMsgPosDirty()) {
            hashMap.put(FIELD_MSGPOS, this.getMsgPos());
        }
        if (!bl || this.isMsgPosPSDEFIdDirty()) {
            hashMap.put(FIELD_MSGPOSPSDEFID, this.getMsgPosPSDEFId());
        }
        if (!bl || this.isMsgPosPSDEFNameDirty()) {
            hashMap.put(FIELD_MSGPOSPSDEFNAME, this.getMsgPosPSDEFName());
        }
        if (!bl || this.isMsgTypeDirty()) {
            hashMap.put(FIELD_MSGTYPE, this.getMsgType());
        }
        if (!bl || this.isMsgTypePSDEFIdDirty()) {
            hashMap.put(FIELD_MSGTYPEPSDEFID, this.getMsgTypePSDEFId());
        }
        if (!bl || this.isMsgTypePSDEFNameDirty()) {
            hashMap.put(FIELD_MSGTYPEPSDEFNAME, this.getMsgTypePSDEFName());
        }
        if (!bl || this.isOrderValuePSDEFIdDirty()) {
            hashMap.put(FIELD_ORDERVALUEPSDEFID, this.getOrderValuePSDEFId());
        }
        if (!bl || this.isOrderValuePSDEFNameDirty()) {
            hashMap.put(FIELD_ORDERVALUEPSDEFNAME, this.getOrderValuePSDEFName());
        }
        if (!bl || this.isPredefinedTypeDirty()) {
            hashMap.put(FIELD_PREDEFINEDTYPE, this.getPredefinedType());
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
        if (!bl || this.isPSDELogicIdDirty()) {
            hashMap.put(FIELD_PSDELOGICID, this.getPSDELogicId());
        }
        if (!bl || this.isPSDELogicNameDirty()) {
            hashMap.put(FIELD_PSDELOGICNAME, this.getPSDELogicName());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDEOPPrivIdDirty()) {
            hashMap.put(FIELD_PSDEOPPRIVID, this.getPSDEOPPrivId());
        }
        if (!bl || this.isPSDEOPPrivNameDirty()) {
            hashMap.put(FIELD_PSDEOPPRIVNAME, this.getPSDEOPPrivName());
        }
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
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
        if (!bl || this.isPSSysImageIdDirty()) {
            hashMap.put(FIELD_PSSYSIMAGEID, this.getPSSysImageId());
        }
        if (!bl || this.isPSSysImageNameDirty()) {
            hashMap.put(FIELD_PSSYSIMAGENAME, this.getPSSysImageName());
        }
        if (!bl || this.isPSSysMsgTemplIdDirty()) {
            hashMap.put(FIELD_PSSYSMSGTEMPLID, this.getPSSysMsgTemplId());
        }
        if (!bl || this.isPSSysMsgTemplNameDirty()) {
            hashMap.put(FIELD_PSSYSMSGTEMPLNAME, this.getPSSysMsgTemplName());
        }
        if (!bl || this.isPSSysSFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINID, this.getPSSysSFPluginId());
        }
        if (!bl || this.isPSSysSFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINNAME, this.getPSSysSFPluginName());
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
        if (!bl || this.isPSViewMsgIdDirty()) {
            hashMap.put(FIELD_PSVIEWMSGID, this.getPSViewMsgId());
        }
        if (!bl || this.isPSViewMsgNameDirty()) {
            hashMap.put(FIELD_PSVIEWMSGNAME, this.getPSViewMsgName());
        }
        if (!bl || this.isRemovePSDEFIdDirty()) {
            hashMap.put(FIELD_REMOVEPSDEFID, this.getRemovePSDEFId());
        }
        if (!bl || this.isRemovePSDEFNameDirty()) {
            hashMap.put(FIELD_REMOVEPSDEFNAME, this.getRemovePSDEFName());
        }
        if (!bl || this.isTestCustomCodeDirty()) {
            hashMap.put(FIELD_TESTCUSTOMCODE, this.getTestCustomCode());
        }
        if (!bl || this.isTestPSDELogicIdDirty()) {
            hashMap.put(FIELD_TESTPSDELOGICID, this.getTestPSDELogicId());
        }
        if (!bl || this.isTestPSDELogicNameDirty()) {
            hashMap.put(FIELD_TESTPSDELOGICNAME, this.getTestPSDELogicName());
        }
        if (!bl || this.isTimeoutDirty()) {
            hashMap.put(FIELD_TIMEOUT, this.getTimeout());
        }
        if (!bl || this.isTitleDirty()) {
            hashMap.put(FIELD_TITLE, this.getTitle());
        }
        if (!bl || this.isTitleLanResTagPSDEFIdDirty()) {
            hashMap.put(FIELD_TITLELANRESTAGPSDEFID, this.getTitleLanResTagPSDEFId());
        }
        if (!bl || this.isTitleLanResTagPSDEFNameDirty()) {
            hashMap.put(FIELD_TITLELANRESTAGPSDEFNAME, this.getTitleLanResTagPSDEFName());
        }
        if (!bl || this.isTitlePSDEFIdDirty()) {
            hashMap.put(FIELD_TITLEPSDEFID, this.getTitlePSDEFId());
        }
        if (!bl || this.isTitlePSDEFNameDirty()) {
            hashMap.put(FIELD_TITLEPSDEFNAME, this.getTitlePSDEFName());
        }
        if (!bl || this.isTitlePSLanResIdDirty()) {
            hashMap.put(FIELD_TITLEPSLANRESID, this.getTitlePSLanResId());
        }
        if (!bl || this.isTitlePSLanResNameDirty()) {
            hashMap.put(FIELD_TITLEPSLANRESNAME, this.getTitlePSLanResName());
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
        if (!bl || this.isViewMsgParamsDirty()) {
            hashMap.put(FIELD_VIEWMSGPARAMS, this.getViewMsgParams());
        }
        if (!bl || this.isVewMsgTagDirty()) {
            hashMap.put(FIELD_VEWMSGTAG, this.getVewMsgTag());
        }
        if (!bl || this.isVewMsgTag2Dirty()) {
            hashMap.put(FIELD_VEWMSGTAG2, this.getVewMsgTag2());
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
        return PSViewMsgBase.get(this, n);
    }

    private static Object get(PSViewMsgBase pSViewMsgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSViewMsgBase.getCacheScope();
            }
            case 1: {
                return pSViewMsgBase.getCacheTag2PSDEFId();
            }
            case 2: {
                return pSViewMsgBase.getCacheTag2PSDEFName();
            }
            case 3: {
                return pSViewMsgBase.getCacheTagPSDEFId();
            }
            case 4: {
                return pSViewMsgBase.getCacheTagPSDEFName();
            }
            case 5: {
                return pSViewMsgBase.getCacheTimeout();
            }
            case 6: {
                return pSViewMsgBase.getClsPSDEFId();
            }
            case 7: {
                return pSViewMsgBase.getClsPSDEFName();
            }
            case 8: {
                return pSViewMsgBase.getCodeName();
            }
            case 9: {
                return pSViewMsgBase.getContent();
            }
            case 10: {
                return pSViewMsgBase.getContentPSDEFId();
            }
            case 11: {
                return pSViewMsgBase.getContentPSDEFName();
            }
            case 12: {
                return pSViewMsgBase.getContentPSLanResId();
            }
            case 13: {
                return pSViewMsgBase.getContentPSLanResName();
            }
            case 14: {
                return pSViewMsgBase.getContentType();
            }
            case 15: {
                return pSViewMsgBase.getContentTypePSDEFId();
            }
            case 16: {
                return pSViewMsgBase.getContentTypePSDEFName();
            }
            case 17: {
                return pSViewMsgBase.getCreateDate();
            }
            case 18: {
                return pSViewMsgBase.getCreateMan();
            }
            case 19: {
                return pSViewMsgBase.getDefaultFlag();
            }
            case 20: {
                return pSViewMsgBase.getDSLink();
            }
            case 21: {
                return pSViewMsgBase.getDynamicMode();
            }
            case 22: {
                return pSViewMsgBase.getEnableCache();
            }
            case 23: {
                return pSViewMsgBase.getEnableMode();
            }
            case 24: {
                return pSViewMsgBase.getEnableRemove();
            }
            case 25: {
                return pSViewMsgBase.getGroupPSDEFId();
            }
            case 26: {
                return pSViewMsgBase.getGroupPSDEFName();
            }
            case 27: {
                return pSViewMsgBase.getIconPSDEFId();
            }
            case 28: {
                return pSViewMsgBase.getIconPSDEFName();
            }
            case 29: {
                return pSViewMsgBase.getLockFlag();
            }
            case 30: {
                return pSViewMsgBase.getMemo();
            }
            case 31: {
                return pSViewMsgBase.getMsgGroup();
            }
            case 32: {
                return pSViewMsgBase.getMsgPos();
            }
            case 33: {
                return pSViewMsgBase.getMsgPosPSDEFId();
            }
            case 34: {
                return pSViewMsgBase.getMsgPosPSDEFName();
            }
            case 35: {
                return pSViewMsgBase.getMsgType();
            }
            case 36: {
                return pSViewMsgBase.getMsgTypePSDEFId();
            }
            case 37: {
                return pSViewMsgBase.getMsgTypePSDEFName();
            }
            case 38: {
                return pSViewMsgBase.getOrderValuePSDEFId();
            }
            case 39: {
                return pSViewMsgBase.getOrderValuePSDEFName();
            }
            case 40: {
                return pSViewMsgBase.getPredefinedType();
            }
            case 41: {
                return pSViewMsgBase.getPSDEDSId();
            }
            case 42: {
                return pSViewMsgBase.getPSDEDSName();
            }
            case 43: {
                return pSViewMsgBase.getPSDEId();
            }
            case 44: {
                return pSViewMsgBase.getPSDELogicId();
            }
            case 45: {
                return pSViewMsgBase.getPSDELogicName();
            }
            case 46: {
                return pSViewMsgBase.getPSDEName();
            }
            case 47: {
                return pSViewMsgBase.getPSDEOPPrivId();
            }
            case 48: {
                return pSViewMsgBase.getPSDEOPPrivName();
            }
            case 49: {
                return pSViewMsgBase.getPSModuleId();
            }
            case 50: {
                return pSViewMsgBase.getPSModuleName();
            }
            case 51: {
                return pSViewMsgBase.getPSSysCssId();
            }
            case 52: {
                return pSViewMsgBase.getPSSysCssName();
            }
            case 53: {
                return pSViewMsgBase.getPSSysDynaModelId();
            }
            case 54: {
                return pSViewMsgBase.getPSSysDynaModelName();
            }
            case 55: {
                return pSViewMsgBase.getPSSysImageId();
            }
            case 56: {
                return pSViewMsgBase.getPSSysImageName();
            }
            case 57: {
                return pSViewMsgBase.getPSSysMsgTemplId();
            }
            case 58: {
                return pSViewMsgBase.getPSSysMsgTemplName();
            }
            case 59: {
                return pSViewMsgBase.getPSSysSFPluginId();
            }
            case 60: {
                return pSViewMsgBase.getPSSysSFPluginName();
            }
            case 61: {
                return pSViewMsgBase.getPSSystemId();
            }
            case 62: {
                return pSViewMsgBase.getPSSystemName();
            }
            case 63: {
                return pSViewMsgBase.getPSSysViewPanelId();
            }
            case 64: {
                return pSViewMsgBase.getPSSysViewPanelName();
            }
            case 65: {
                return pSViewMsgBase.getPSViewMsgId();
            }
            case 66: {
                return pSViewMsgBase.getPSViewMsgName();
            }
            case 67: {
                return pSViewMsgBase.getRemovePSDEFId();
            }
            case 68: {
                return pSViewMsgBase.getRemovePSDEFName();
            }
            case 69: {
                return pSViewMsgBase.getTestCustomCode();
            }
            case 70: {
                return pSViewMsgBase.getTestPSDELogicId();
            }
            case 71: {
                return pSViewMsgBase.getTestPSDELogicName();
            }
            case 72: {
                return pSViewMsgBase.getTimeout();
            }
            case 73: {
                return pSViewMsgBase.getTitle();
            }
            case 74: {
                return pSViewMsgBase.getTitleLanResTagPSDEFId();
            }
            case 75: {
                return pSViewMsgBase.getTitleLanResTagPSDEFName();
            }
            case 76: {
                return pSViewMsgBase.getTitlePSDEFId();
            }
            case 77: {
                return pSViewMsgBase.getTitlePSDEFName();
            }
            case 78: {
                return pSViewMsgBase.getTitlePSLanResId();
            }
            case 79: {
                return pSViewMsgBase.getTitlePSLanResName();
            }
            case 80: {
                return pSViewMsgBase.getUpdateDate();
            }
            case 81: {
                return pSViewMsgBase.getUpdateMan();
            }
            case 82: {
                return pSViewMsgBase.getUserCat();
            }
            case 83: {
                return pSViewMsgBase.getUserTag();
            }
            case 84: {
                return pSViewMsgBase.getUserTag2();
            }
            case 85: {
                return pSViewMsgBase.getUserTag3();
            }
            case 86: {
                return pSViewMsgBase.getUserTag4();
            }
            case 87: {
                return pSViewMsgBase.getViewMsgParams();
            }
            case 88: {
                return pSViewMsgBase.getVewMsgTag();
            }
            case 89: {
                return pSViewMsgBase.getVewMsgTag2();
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
        PSViewMsgBase.set(this, n, object);
    }

    private static void set(PSViewMsgBase pSViewMsgBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSViewMsgBase.setCacheScope(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSViewMsgBase.setCacheTag2PSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSViewMsgBase.setCacheTag2PSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSViewMsgBase.setCacheTagPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSViewMsgBase.setCacheTagPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSViewMsgBase.setCacheTimeout(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSViewMsgBase.setClsPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSViewMsgBase.setClsPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSViewMsgBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSViewMsgBase.setContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSViewMsgBase.setContentPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSViewMsgBase.setContentPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSViewMsgBase.setContentPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSViewMsgBase.setContentPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSViewMsgBase.setContentType(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSViewMsgBase.setContentTypePSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSViewMsgBase.setContentTypePSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSViewMsgBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 18: {
                pSViewMsgBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSViewMsgBase.setDefaultFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 20: {
                pSViewMsgBase.setDSLink(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSViewMsgBase.setDynamicMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 22: {
                pSViewMsgBase.setEnableCache(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 23: {
                pSViewMsgBase.setEnableMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSViewMsgBase.setEnableRemove(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 25: {
                pSViewMsgBase.setGroupPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSViewMsgBase.setGroupPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSViewMsgBase.setIconPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSViewMsgBase.setIconPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSViewMsgBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 30: {
                pSViewMsgBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSViewMsgBase.setMsgGroup(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSViewMsgBase.setMsgPos(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSViewMsgBase.setMsgPosPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSViewMsgBase.setMsgPosPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSViewMsgBase.setMsgType(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSViewMsgBase.setMsgTypePSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSViewMsgBase.setMsgTypePSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSViewMsgBase.setOrderValuePSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSViewMsgBase.setOrderValuePSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSViewMsgBase.setPredefinedType(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSViewMsgBase.setPSDEDSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSViewMsgBase.setPSDEDSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSViewMsgBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSViewMsgBase.setPSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSViewMsgBase.setPSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSViewMsgBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSViewMsgBase.setPSDEOPPrivId(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSViewMsgBase.setPSDEOPPrivName(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSViewMsgBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSViewMsgBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSViewMsgBase.setPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSViewMsgBase.setPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSViewMsgBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSViewMsgBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSViewMsgBase.setPSSysImageId(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSViewMsgBase.setPSSysImageName(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSViewMsgBase.setPSSysMsgTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 58: {
                pSViewMsgBase.setPSSysMsgTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 59: {
                pSViewMsgBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 60: {
                pSViewMsgBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 61: {
                pSViewMsgBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 62: {
                pSViewMsgBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 63: {
                pSViewMsgBase.setPSSysViewPanelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 64: {
                pSViewMsgBase.setPSSysViewPanelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 65: {
                pSViewMsgBase.setPSViewMsgId(DataObject.getStringValue((Object)object));
                return;
            }
            case 66: {
                pSViewMsgBase.setPSViewMsgName(DataObject.getStringValue((Object)object));
                return;
            }
            case 67: {
                pSViewMsgBase.setRemovePSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 68: {
                pSViewMsgBase.setRemovePSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 69: {
                pSViewMsgBase.setTestCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 70: {
                pSViewMsgBase.setTestPSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 71: {
                pSViewMsgBase.setTestPSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 72: {
                pSViewMsgBase.setTimeout(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 73: {
                pSViewMsgBase.setTitle(DataObject.getStringValue((Object)object));
                return;
            }
            case 74: {
                pSViewMsgBase.setTitleLanResTagPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 75: {
                pSViewMsgBase.setTitleLanResTagPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 76: {
                pSViewMsgBase.setTitlePSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 77: {
                pSViewMsgBase.setTitlePSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 78: {
                pSViewMsgBase.setTitlePSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 79: {
                pSViewMsgBase.setTitlePSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 80: {
                pSViewMsgBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 81: {
                pSViewMsgBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 82: {
                pSViewMsgBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 83: {
                pSViewMsgBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 84: {
                pSViewMsgBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 85: {
                pSViewMsgBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 86: {
                pSViewMsgBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 87: {
                pSViewMsgBase.setViewMsgParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 88: {
                pSViewMsgBase.setVewMsgTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 89: {
                pSViewMsgBase.setVewMsgTag2(DataObject.getStringValue((Object)object));
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
        return PSViewMsgBase.isNull(this, n);
    }

    private static boolean isNull(PSViewMsgBase pSViewMsgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSViewMsgBase.getCacheScope() == null;
            }
            case 1: {
                return pSViewMsgBase.getCacheTag2PSDEFId() == null;
            }
            case 2: {
                return pSViewMsgBase.getCacheTag2PSDEFName() == null;
            }
            case 3: {
                return pSViewMsgBase.getCacheTagPSDEFId() == null;
            }
            case 4: {
                return pSViewMsgBase.getCacheTagPSDEFName() == null;
            }
            case 5: {
                return pSViewMsgBase.getCacheTimeout() == null;
            }
            case 6: {
                return pSViewMsgBase.getClsPSDEFId() == null;
            }
            case 7: {
                return pSViewMsgBase.getClsPSDEFName() == null;
            }
            case 8: {
                return pSViewMsgBase.getCodeName() == null;
            }
            case 9: {
                return pSViewMsgBase.getContent() == null;
            }
            case 10: {
                return pSViewMsgBase.getContentPSDEFId() == null;
            }
            case 11: {
                return pSViewMsgBase.getContentPSDEFName() == null;
            }
            case 12: {
                return pSViewMsgBase.getContentPSLanResId() == null;
            }
            case 13: {
                return pSViewMsgBase.getContentPSLanResName() == null;
            }
            case 14: {
                return pSViewMsgBase.getContentType() == null;
            }
            case 15: {
                return pSViewMsgBase.getContentTypePSDEFId() == null;
            }
            case 16: {
                return pSViewMsgBase.getContentTypePSDEFName() == null;
            }
            case 17: {
                return pSViewMsgBase.getCreateDate() == null;
            }
            case 18: {
                return pSViewMsgBase.getCreateMan() == null;
            }
            case 19: {
                return pSViewMsgBase.getDefaultFlag() == null;
            }
            case 20: {
                return pSViewMsgBase.getDSLink() == null;
            }
            case 21: {
                return pSViewMsgBase.getDynamicMode() == null;
            }
            case 22: {
                return pSViewMsgBase.getEnableCache() == null;
            }
            case 23: {
                return pSViewMsgBase.getEnableMode() == null;
            }
            case 24: {
                return pSViewMsgBase.getEnableRemove() == null;
            }
            case 25: {
                return pSViewMsgBase.getGroupPSDEFId() == null;
            }
            case 26: {
                return pSViewMsgBase.getGroupPSDEFName() == null;
            }
            case 27: {
                return pSViewMsgBase.getIconPSDEFId() == null;
            }
            case 28: {
                return pSViewMsgBase.getIconPSDEFName() == null;
            }
            case 29: {
                return pSViewMsgBase.getLockFlag() == null;
            }
            case 30: {
                return pSViewMsgBase.getMemo() == null;
            }
            case 31: {
                return pSViewMsgBase.getMsgGroup() == null;
            }
            case 32: {
                return pSViewMsgBase.getMsgPos() == null;
            }
            case 33: {
                return pSViewMsgBase.getMsgPosPSDEFId() == null;
            }
            case 34: {
                return pSViewMsgBase.getMsgPosPSDEFName() == null;
            }
            case 35: {
                return pSViewMsgBase.getMsgType() == null;
            }
            case 36: {
                return pSViewMsgBase.getMsgTypePSDEFId() == null;
            }
            case 37: {
                return pSViewMsgBase.getMsgTypePSDEFName() == null;
            }
            case 38: {
                return pSViewMsgBase.getOrderValuePSDEFId() == null;
            }
            case 39: {
                return pSViewMsgBase.getOrderValuePSDEFName() == null;
            }
            case 40: {
                return pSViewMsgBase.getPredefinedType() == null;
            }
            case 41: {
                return pSViewMsgBase.getPSDEDSId() == null;
            }
            case 42: {
                return pSViewMsgBase.getPSDEDSName() == null;
            }
            case 43: {
                return pSViewMsgBase.getPSDEId() == null;
            }
            case 44: {
                return pSViewMsgBase.getPSDELogicId() == null;
            }
            case 45: {
                return pSViewMsgBase.getPSDELogicName() == null;
            }
            case 46: {
                return pSViewMsgBase.getPSDEName() == null;
            }
            case 47: {
                return pSViewMsgBase.getPSDEOPPrivId() == null;
            }
            case 48: {
                return pSViewMsgBase.getPSDEOPPrivName() == null;
            }
            case 49: {
                return pSViewMsgBase.getPSModuleId() == null;
            }
            case 50: {
                return pSViewMsgBase.getPSModuleName() == null;
            }
            case 51: {
                return pSViewMsgBase.getPSSysCssId() == null;
            }
            case 52: {
                return pSViewMsgBase.getPSSysCssName() == null;
            }
            case 53: {
                return pSViewMsgBase.getPSSysDynaModelId() == null;
            }
            case 54: {
                return pSViewMsgBase.getPSSysDynaModelName() == null;
            }
            case 55: {
                return pSViewMsgBase.getPSSysImageId() == null;
            }
            case 56: {
                return pSViewMsgBase.getPSSysImageName() == null;
            }
            case 57: {
                return pSViewMsgBase.getPSSysMsgTemplId() == null;
            }
            case 58: {
                return pSViewMsgBase.getPSSysMsgTemplName() == null;
            }
            case 59: {
                return pSViewMsgBase.getPSSysSFPluginId() == null;
            }
            case 60: {
                return pSViewMsgBase.getPSSysSFPluginName() == null;
            }
            case 61: {
                return pSViewMsgBase.getPSSystemId() == null;
            }
            case 62: {
                return pSViewMsgBase.getPSSystemName() == null;
            }
            case 63: {
                return pSViewMsgBase.getPSSysViewPanelId() == null;
            }
            case 64: {
                return pSViewMsgBase.getPSSysViewPanelName() == null;
            }
            case 65: {
                return pSViewMsgBase.getPSViewMsgId() == null;
            }
            case 66: {
                return pSViewMsgBase.getPSViewMsgName() == null;
            }
            case 67: {
                return pSViewMsgBase.getRemovePSDEFId() == null;
            }
            case 68: {
                return pSViewMsgBase.getRemovePSDEFName() == null;
            }
            case 69: {
                return pSViewMsgBase.getTestCustomCode() == null;
            }
            case 70: {
                return pSViewMsgBase.getTestPSDELogicId() == null;
            }
            case 71: {
                return pSViewMsgBase.getTestPSDELogicName() == null;
            }
            case 72: {
                return pSViewMsgBase.getTimeout() == null;
            }
            case 73: {
                return pSViewMsgBase.getTitle() == null;
            }
            case 74: {
                return pSViewMsgBase.getTitleLanResTagPSDEFId() == null;
            }
            case 75: {
                return pSViewMsgBase.getTitleLanResTagPSDEFName() == null;
            }
            case 76: {
                return pSViewMsgBase.getTitlePSDEFId() == null;
            }
            case 77: {
                return pSViewMsgBase.getTitlePSDEFName() == null;
            }
            case 78: {
                return pSViewMsgBase.getTitlePSLanResId() == null;
            }
            case 79: {
                return pSViewMsgBase.getTitlePSLanResName() == null;
            }
            case 80: {
                return pSViewMsgBase.getUpdateDate() == null;
            }
            case 81: {
                return pSViewMsgBase.getUpdateMan() == null;
            }
            case 82: {
                return pSViewMsgBase.getUserCat() == null;
            }
            case 83: {
                return pSViewMsgBase.getUserTag() == null;
            }
            case 84: {
                return pSViewMsgBase.getUserTag2() == null;
            }
            case 85: {
                return pSViewMsgBase.getUserTag3() == null;
            }
            case 86: {
                return pSViewMsgBase.getUserTag4() == null;
            }
            case 87: {
                return pSViewMsgBase.getViewMsgParams() == null;
            }
            case 88: {
                return pSViewMsgBase.getVewMsgTag() == null;
            }
            case 89: {
                return pSViewMsgBase.getVewMsgTag2() == null;
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
        return PSViewMsgBase.contains(this, n);
    }

    private static boolean contains(PSViewMsgBase pSViewMsgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSViewMsgBase.isCacheScopeDirty();
            }
            case 1: {
                return pSViewMsgBase.isCacheTag2PSDEFIdDirty();
            }
            case 2: {
                return pSViewMsgBase.isCacheTag2PSDEFNameDirty();
            }
            case 3: {
                return pSViewMsgBase.isCacheTagPSDEFIdDirty();
            }
            case 4: {
                return pSViewMsgBase.isCacheTagPSDEFNameDirty();
            }
            case 5: {
                return pSViewMsgBase.isCacheTimeoutDirty();
            }
            case 6: {
                return pSViewMsgBase.isClsPSDEFIdDirty();
            }
            case 7: {
                return pSViewMsgBase.isClsPSDEFNameDirty();
            }
            case 8: {
                return pSViewMsgBase.isCodeNameDirty();
            }
            case 9: {
                return pSViewMsgBase.isContentDirty();
            }
            case 10: {
                return pSViewMsgBase.isContentPSDEFIdDirty();
            }
            case 11: {
                return pSViewMsgBase.isContentPSDEFNameDirty();
            }
            case 12: {
                return pSViewMsgBase.isContentPSLanResIdDirty();
            }
            case 13: {
                return pSViewMsgBase.isContentPSLanResNameDirty();
            }
            case 14: {
                return pSViewMsgBase.isContentTypeDirty();
            }
            case 15: {
                return pSViewMsgBase.isContentTypePSDEFIdDirty();
            }
            case 16: {
                return pSViewMsgBase.isContentTypePSDEFNameDirty();
            }
            case 17: {
                return pSViewMsgBase.isCreateDateDirty();
            }
            case 18: {
                return pSViewMsgBase.isCreateManDirty();
            }
            case 19: {
                return pSViewMsgBase.isDefaultFlagDirty();
            }
            case 20: {
                return pSViewMsgBase.isDSLinkDirty();
            }
            case 21: {
                return pSViewMsgBase.isDynamicModeDirty();
            }
            case 22: {
                return pSViewMsgBase.isEnableCacheDirty();
            }
            case 23: {
                return pSViewMsgBase.isEnableModeDirty();
            }
            case 24: {
                return pSViewMsgBase.isEnableRemoveDirty();
            }
            case 25: {
                return pSViewMsgBase.isGroupPSDEFIdDirty();
            }
            case 26: {
                return pSViewMsgBase.isGroupPSDEFNameDirty();
            }
            case 27: {
                return pSViewMsgBase.isIconPSDEFIdDirty();
            }
            case 28: {
                return pSViewMsgBase.isIconPSDEFNameDirty();
            }
            case 29: {
                return pSViewMsgBase.isLockFlagDirty();
            }
            case 30: {
                return pSViewMsgBase.isMemoDirty();
            }
            case 31: {
                return pSViewMsgBase.isMsgGroupDirty();
            }
            case 32: {
                return pSViewMsgBase.isMsgPosDirty();
            }
            case 33: {
                return pSViewMsgBase.isMsgPosPSDEFIdDirty();
            }
            case 34: {
                return pSViewMsgBase.isMsgPosPSDEFNameDirty();
            }
            case 35: {
                return pSViewMsgBase.isMsgTypeDirty();
            }
            case 36: {
                return pSViewMsgBase.isMsgTypePSDEFIdDirty();
            }
            case 37: {
                return pSViewMsgBase.isMsgTypePSDEFNameDirty();
            }
            case 38: {
                return pSViewMsgBase.isOrderValuePSDEFIdDirty();
            }
            case 39: {
                return pSViewMsgBase.isOrderValuePSDEFNameDirty();
            }
            case 40: {
                return pSViewMsgBase.isPredefinedTypeDirty();
            }
            case 41: {
                return pSViewMsgBase.isPSDEDSIdDirty();
            }
            case 42: {
                return pSViewMsgBase.isPSDEDSNameDirty();
            }
            case 43: {
                return pSViewMsgBase.isPSDEIdDirty();
            }
            case 44: {
                return pSViewMsgBase.isPSDELogicIdDirty();
            }
            case 45: {
                return pSViewMsgBase.isPSDELogicNameDirty();
            }
            case 46: {
                return pSViewMsgBase.isPSDENameDirty();
            }
            case 47: {
                return pSViewMsgBase.isPSDEOPPrivIdDirty();
            }
            case 48: {
                return pSViewMsgBase.isPSDEOPPrivNameDirty();
            }
            case 49: {
                return pSViewMsgBase.isPSModuleIdDirty();
            }
            case 50: {
                return pSViewMsgBase.isPSModuleNameDirty();
            }
            case 51: {
                return pSViewMsgBase.isPSSysCssIdDirty();
            }
            case 52: {
                return pSViewMsgBase.isPSSysCssNameDirty();
            }
            case 53: {
                return pSViewMsgBase.isPSSysDynaModelIdDirty();
            }
            case 54: {
                return pSViewMsgBase.isPSSysDynaModelNameDirty();
            }
            case 55: {
                return pSViewMsgBase.isPSSysImageIdDirty();
            }
            case 56: {
                return pSViewMsgBase.isPSSysImageNameDirty();
            }
            case 57: {
                return pSViewMsgBase.isPSSysMsgTemplIdDirty();
            }
            case 58: {
                return pSViewMsgBase.isPSSysMsgTemplNameDirty();
            }
            case 59: {
                return pSViewMsgBase.isPSSysSFPluginIdDirty();
            }
            case 60: {
                return pSViewMsgBase.isPSSysSFPluginNameDirty();
            }
            case 61: {
                return pSViewMsgBase.isPSSystemIdDirty();
            }
            case 62: {
                return pSViewMsgBase.isPSSystemNameDirty();
            }
            case 63: {
                return pSViewMsgBase.isPSSysViewPanelIdDirty();
            }
            case 64: {
                return pSViewMsgBase.isPSSysViewPanelNameDirty();
            }
            case 65: {
                return pSViewMsgBase.isPSViewMsgIdDirty();
            }
            case 66: {
                return pSViewMsgBase.isPSViewMsgNameDirty();
            }
            case 67: {
                return pSViewMsgBase.isRemovePSDEFIdDirty();
            }
            case 68: {
                return pSViewMsgBase.isRemovePSDEFNameDirty();
            }
            case 69: {
                return pSViewMsgBase.isTestCustomCodeDirty();
            }
            case 70: {
                return pSViewMsgBase.isTestPSDELogicIdDirty();
            }
            case 71: {
                return pSViewMsgBase.isTestPSDELogicNameDirty();
            }
            case 72: {
                return pSViewMsgBase.isTimeoutDirty();
            }
            case 73: {
                return pSViewMsgBase.isTitleDirty();
            }
            case 74: {
                return pSViewMsgBase.isTitleLanResTagPSDEFIdDirty();
            }
            case 75: {
                return pSViewMsgBase.isTitleLanResTagPSDEFNameDirty();
            }
            case 76: {
                return pSViewMsgBase.isTitlePSDEFIdDirty();
            }
            case 77: {
                return pSViewMsgBase.isTitlePSDEFNameDirty();
            }
            case 78: {
                return pSViewMsgBase.isTitlePSLanResIdDirty();
            }
            case 79: {
                return pSViewMsgBase.isTitlePSLanResNameDirty();
            }
            case 80: {
                return pSViewMsgBase.isUpdateDateDirty();
            }
            case 81: {
                return pSViewMsgBase.isUpdateManDirty();
            }
            case 82: {
                return pSViewMsgBase.isUserCatDirty();
            }
            case 83: {
                return pSViewMsgBase.isUserTagDirty();
            }
            case 84: {
                return pSViewMsgBase.isUserTag2Dirty();
            }
            case 85: {
                return pSViewMsgBase.isUserTag3Dirty();
            }
            case 86: {
                return pSViewMsgBase.isUserTag4Dirty();
            }
            case 87: {
                return pSViewMsgBase.isViewMsgParamsDirty();
            }
            case 88: {
                return pSViewMsgBase.isVewMsgTagDirty();
            }
            case 89: {
                return pSViewMsgBase.isVewMsgTag2Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSViewMsgBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSViewMsgBase pSViewMsgBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSViewMsgBase.getCacheScope() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cachescope", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getCacheScope()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getCacheTag2PSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cachetag2psdefid", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getCacheTag2PSDEFId()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getCacheTag2PSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cachetag2psdefname", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getCacheTag2PSDEFName()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getCacheTagPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cachetagpsdefid", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getCacheTagPSDEFId()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getCacheTagPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cachetagpsdefname", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getCacheTagPSDEFName()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getCacheTimeout() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cachetimeout", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getCacheTimeout()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getClsPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"clspsdefid", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getClsPSDEFId()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getClsPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"clspsdefname", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getClsPSDEFName()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getCodeName()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"content", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getContent()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getContentPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contentpsdefid", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getContentPSDEFId()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getContentPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contentpsdefname", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getContentPSDEFName()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getContentPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contentpslanresid", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getContentPSLanResId()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getContentPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contentpslanresname", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getContentPSLanResName()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getContentType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contenttype", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getContentType()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getContentTypePSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contenttypepsdefid", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getContentTypePSDEFId()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getContentTypePSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contenttypepsdefname", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getContentTypePSDEFName()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getDefaultFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultflag", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getDefaultFlag()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getDSLink() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dslink", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getDSLink()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getDynamicMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamicmode", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getDynamicMode()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getEnableCache() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablecache", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getEnableCache()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getEnableMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablemode", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getEnableMode()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getEnableRemove() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableremove", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getEnableRemove()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getGroupPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouppsdefid", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getGroupPSDEFId()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getGroupPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouppsdefname", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getGroupPSDEFName()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getIconPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iconpsdefid", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getIconPSDEFId()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getIconPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iconpsdefname", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getIconPSDEFName()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getMemo()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getMsgGroup() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"msggroup", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getMsgGroup()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getMsgPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"msgpos", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getMsgPos()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getMsgPosPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"msgpospsdefid", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getMsgPosPSDEFId()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getMsgPosPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"msgpospsdefname", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getMsgPosPSDEFName()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getMsgType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"msgtype", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getMsgType()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getMsgTypePSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"msgtypepsdefid", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getMsgTypePSDEFId()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getMsgTypePSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"msgtypepsdefname", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getMsgTypePSDEFName()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getOrderValuePSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervaluepsdefid", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getOrderValuePSDEFId()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getOrderValuePSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervaluepsdefname", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getOrderValuePSDEFName()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getPredefinedType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"predefinedtype", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getPredefinedType()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getPSDEDSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedsid", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getPSDEDSId()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getPSDEDSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedsname", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getPSDEDSName()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getPSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicid", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getPSDELogicId()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getPSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicname", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getPSDELogicName()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getPSDEOPPrivId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeopprivid", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getPSDEOPPrivId()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getPSDEOPPrivName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeopprivname", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getPSDEOPPrivName()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssid", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getPSSysCssId()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssname", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getPSSysCssName()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getPSSysImageId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimageid", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getPSSysImageId()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getPSSysImageName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimagename", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getPSSysImageName()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getPSSysMsgTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmsgtemplid", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getPSSysMsgTemplId()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getPSSysMsgTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmsgtemplname", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getPSSysMsgTemplName()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getPSSysViewPanelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelid", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getPSSysViewPanelId()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getPSSysViewPanelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelname", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getPSSysViewPanelName()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getPSViewMsgId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewmsgid", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getPSViewMsgId()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getPSViewMsgName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewmsgname", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getPSViewMsgName()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getRemovePSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"removepsdefid", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getRemovePSDEFId()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getRemovePSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"removepsdefname", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getRemovePSDEFName()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getTestCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"testcustomcode", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getTestCustomCode()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getTestPSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"testpsdelogicid", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getTestPSDELogicId()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getTestPSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"testpsdelogicname", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getTestPSDELogicName()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getTimeout() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"timeout", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getTimeout()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getTitle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"title", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getTitle()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getTitleLanResTagPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"titlelanrestagpsdefid", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getTitleLanResTagPSDEFId()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getTitleLanResTagPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"titlelanrestagpsdefname", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getTitleLanResTagPSDEFName()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getTitlePSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"titlepsdefid", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getTitlePSDEFId()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getTitlePSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"titlepsdefname", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getTitlePSDEFName()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getTitlePSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"titlepslanresid", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getTitlePSLanResId()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getTitlePSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"titlepslanresname", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getTitlePSLanResName()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getUserCat()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getUserTag()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getViewMsgParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewmsgparams", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getViewMsgParams()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getVewMsgTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewmsgtag", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getVewMsgTag()), (boolean)false);
        }
        if (bl || pSViewMsgBase.getVewMsgTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewmsgtag2", (Object)PSViewMsgBase.getJSONValue((Object)pSViewMsgBase.getVewMsgTag2()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSViewMsgBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSViewMsgBase pSViewMsgBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSViewMsgBase.getCacheScope() != null) {
            object = pSViewMsgBase.getCacheScope();
            xmlNode.setAttribute(FIELD_CACHESCOPE, (String)(object == null ? "" : object));
        }
        if (bl || pSViewMsgBase.getCacheTag2PSDEFId() != null) {
            object = pSViewMsgBase.getCacheTag2PSDEFId();
            xmlNode.setAttribute(FIELD_CACHETAG2PSDEFID, (String)(object == null ? "" : object));
        }
        if (bl || pSViewMsgBase.getCacheTag2PSDEFName() != null) {
            object = pSViewMsgBase.getCacheTag2PSDEFName();
            xmlNode.setAttribute(FIELD_CACHETAG2PSDEFNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSViewMsgBase.getCacheTagPSDEFId() != null) {
            object = pSViewMsgBase.getCacheTagPSDEFId();
            xmlNode.setAttribute(FIELD_CACHETAGPSDEFID, (String)(object == null ? "" : object));
        }
        if (bl || pSViewMsgBase.getCacheTagPSDEFName() != null) {
            object = pSViewMsgBase.getCacheTagPSDEFName();
            xmlNode.setAttribute(FIELD_CACHETAGPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getCacheTimeout() != null) {
            object = pSViewMsgBase.getCacheTimeout();
            xmlNode.setAttribute(FIELD_CACHETIMEOUT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSViewMsgBase.getClsPSDEFId() != null) {
            object = pSViewMsgBase.getClsPSDEFId();
            xmlNode.setAttribute(FIELD_CLSPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getClsPSDEFName() != null) {
            object = pSViewMsgBase.getClsPSDEFName();
            xmlNode.setAttribute(FIELD_CLSPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getCodeName() != null) {
            object = pSViewMsgBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getContent() != null) {
            object = pSViewMsgBase.getContent();
            xmlNode.setAttribute(FIELD_CONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getContentPSDEFId() != null) {
            object = pSViewMsgBase.getContentPSDEFId();
            xmlNode.setAttribute(FIELD_CONTENTPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getContentPSDEFName() != null) {
            object = pSViewMsgBase.getContentPSDEFName();
            xmlNode.setAttribute(FIELD_CONTENTPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getContentPSLanResId() != null) {
            object = pSViewMsgBase.getContentPSLanResId();
            xmlNode.setAttribute(FIELD_CONTENTPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getContentPSLanResName() != null) {
            object = pSViewMsgBase.getContentPSLanResName();
            xmlNode.setAttribute(FIELD_CONTENTPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getContentType() != null) {
            object = pSViewMsgBase.getContentType();
            xmlNode.setAttribute(FIELD_CONTENTTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getContentTypePSDEFId() != null) {
            object = pSViewMsgBase.getContentTypePSDEFId();
            xmlNode.setAttribute(FIELD_CONTENTTYPEPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getContentTypePSDEFName() != null) {
            object = pSViewMsgBase.getContentTypePSDEFName();
            xmlNode.setAttribute(FIELD_CONTENTTYPEPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getCreateDate() != null) {
            object = pSViewMsgBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSViewMsgBase.getCreateMan() != null) {
            object = pSViewMsgBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getDefaultFlag() != null) {
            object = pSViewMsgBase.getDefaultFlag();
            xmlNode.setAttribute(FIELD_DEFAULTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSViewMsgBase.getDSLink() != null) {
            object = pSViewMsgBase.getDSLink();
            xmlNode.setAttribute(FIELD_DSLINK, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getDynamicMode() != null) {
            object = pSViewMsgBase.getDynamicMode();
            xmlNode.setAttribute(FIELD_DYNAMICMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSViewMsgBase.getEnableCache() != null) {
            object = pSViewMsgBase.getEnableCache();
            xmlNode.setAttribute(FIELD_ENABLECACHE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSViewMsgBase.getEnableMode() != null) {
            object = pSViewMsgBase.getEnableMode();
            xmlNode.setAttribute(FIELD_ENABLEMODE, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getEnableRemove() != null) {
            object = pSViewMsgBase.getEnableRemove();
            xmlNode.setAttribute(FIELD_ENABLEREMOVE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSViewMsgBase.getGroupPSDEFId() != null) {
            object = pSViewMsgBase.getGroupPSDEFId();
            xmlNode.setAttribute(FIELD_GROUPPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getGroupPSDEFName() != null) {
            object = pSViewMsgBase.getGroupPSDEFName();
            xmlNode.setAttribute(FIELD_GROUPPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getIconPSDEFId() != null) {
            object = pSViewMsgBase.getIconPSDEFId();
            xmlNode.setAttribute(FIELD_ICONPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getIconPSDEFName() != null) {
            object = pSViewMsgBase.getIconPSDEFName();
            xmlNode.setAttribute(FIELD_ICONPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getLockFlag() != null) {
            object = pSViewMsgBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSViewMsgBase.getMemo() != null) {
            object = pSViewMsgBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getMsgGroup() != null) {
            object = pSViewMsgBase.getMsgGroup();
            xmlNode.setAttribute(FIELD_MSGGROUP, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getMsgPos() != null) {
            object = pSViewMsgBase.getMsgPos();
            xmlNode.setAttribute(FIELD_MSGPOS, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getMsgPosPSDEFId() != null) {
            object = pSViewMsgBase.getMsgPosPSDEFId();
            xmlNode.setAttribute(FIELD_MSGPOSPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getMsgPosPSDEFName() != null) {
            object = pSViewMsgBase.getMsgPosPSDEFName();
            xmlNode.setAttribute(FIELD_MSGPOSPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getMsgType() != null) {
            object = pSViewMsgBase.getMsgType();
            xmlNode.setAttribute(FIELD_MSGTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getMsgTypePSDEFId() != null) {
            object = pSViewMsgBase.getMsgTypePSDEFId();
            xmlNode.setAttribute(FIELD_MSGTYPEPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getMsgTypePSDEFName() != null) {
            object = pSViewMsgBase.getMsgTypePSDEFName();
            xmlNode.setAttribute(FIELD_MSGTYPEPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getOrderValuePSDEFId() != null) {
            object = pSViewMsgBase.getOrderValuePSDEFId();
            xmlNode.setAttribute(FIELD_ORDERVALUEPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getOrderValuePSDEFName() != null) {
            object = pSViewMsgBase.getOrderValuePSDEFName();
            xmlNode.setAttribute(FIELD_ORDERVALUEPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getPredefinedType() != null) {
            object = pSViewMsgBase.getPredefinedType();
            xmlNode.setAttribute(FIELD_PREDEFINEDTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getPSDEDSId() != null) {
            object = pSViewMsgBase.getPSDEDSId();
            xmlNode.setAttribute(FIELD_PSDEDSID, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getPSDEDSName() != null) {
            object = pSViewMsgBase.getPSDEDSName();
            xmlNode.setAttribute(FIELD_PSDEDSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getPSDEId() != null) {
            object = pSViewMsgBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getPSDELogicId() != null) {
            object = pSViewMsgBase.getPSDELogicId();
            xmlNode.setAttribute(FIELD_PSDELOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getPSDELogicName() != null) {
            object = pSViewMsgBase.getPSDELogicName();
            xmlNode.setAttribute(FIELD_PSDELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getPSDEName() != null) {
            object = pSViewMsgBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getPSDEOPPrivId() != null) {
            object = pSViewMsgBase.getPSDEOPPrivId();
            xmlNode.setAttribute(FIELD_PSDEOPPRIVID, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getPSDEOPPrivName() != null) {
            object = pSViewMsgBase.getPSDEOPPrivName();
            xmlNode.setAttribute(FIELD_PSDEOPPRIVNAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getPSModuleId() != null) {
            object = pSViewMsgBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getPSModuleName() != null) {
            object = pSViewMsgBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getPSSysCssId() != null) {
            object = pSViewMsgBase.getPSSysCssId();
            xmlNode.setAttribute(FIELD_PSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getPSSysCssName() != null) {
            object = pSViewMsgBase.getPSSysCssName();
            xmlNode.setAttribute(FIELD_PSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getPSSysDynaModelId() != null) {
            object = pSViewMsgBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getPSSysDynaModelName() != null) {
            object = pSViewMsgBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getPSSysImageId() != null) {
            object = pSViewMsgBase.getPSSysImageId();
            xmlNode.setAttribute(FIELD_PSSYSIMAGEID, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getPSSysImageName() != null) {
            object = pSViewMsgBase.getPSSysImageName();
            xmlNode.setAttribute(FIELD_PSSYSIMAGENAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getPSSysMsgTemplId() != null) {
            object = pSViewMsgBase.getPSSysMsgTemplId();
            xmlNode.setAttribute(FIELD_PSSYSMSGTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getPSSysMsgTemplName() != null) {
            object = pSViewMsgBase.getPSSysMsgTemplName();
            xmlNode.setAttribute(FIELD_PSSYSMSGTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getPSSysSFPluginId() != null) {
            object = pSViewMsgBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getPSSysSFPluginName() != null) {
            object = pSViewMsgBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getPSSystemId() != null) {
            object = pSViewMsgBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getPSSystemName() != null) {
            object = pSViewMsgBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getPSSysViewPanelId() != null) {
            object = pSViewMsgBase.getPSSysViewPanelId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELID, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getPSSysViewPanelName() != null) {
            object = pSViewMsgBase.getPSSysViewPanelName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getPSViewMsgId() != null) {
            object = pSViewMsgBase.getPSViewMsgId();
            xmlNode.setAttribute(FIELD_PSVIEWMSGID, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getPSViewMsgName() != null) {
            object = pSViewMsgBase.getPSViewMsgName();
            xmlNode.setAttribute(FIELD_PSVIEWMSGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getRemovePSDEFId() != null) {
            object = pSViewMsgBase.getRemovePSDEFId();
            xmlNode.setAttribute(FIELD_REMOVEPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getRemovePSDEFName() != null) {
            object = pSViewMsgBase.getRemovePSDEFName();
            xmlNode.setAttribute(FIELD_REMOVEPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getTestCustomCode() != null) {
            object = pSViewMsgBase.getTestCustomCode();
            xmlNode.setAttribute(FIELD_TESTCUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getTestPSDELogicId() != null) {
            object = pSViewMsgBase.getTestPSDELogicId();
            xmlNode.setAttribute(FIELD_TESTPSDELOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getTestPSDELogicName() != null) {
            object = pSViewMsgBase.getTestPSDELogicName();
            xmlNode.setAttribute(FIELD_TESTPSDELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getTimeout() != null) {
            object = pSViewMsgBase.getTimeout();
            xmlNode.setAttribute(FIELD_TIMEOUT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSViewMsgBase.getTitle() != null) {
            object = pSViewMsgBase.getTitle();
            xmlNode.setAttribute(FIELD_TITLE, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getTitleLanResTagPSDEFId() != null) {
            object = pSViewMsgBase.getTitleLanResTagPSDEFId();
            xmlNode.setAttribute(FIELD_TITLELANRESTAGPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getTitleLanResTagPSDEFName() != null) {
            object = pSViewMsgBase.getTitleLanResTagPSDEFName();
            xmlNode.setAttribute(FIELD_TITLELANRESTAGPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getTitlePSDEFId() != null) {
            object = pSViewMsgBase.getTitlePSDEFId();
            xmlNode.setAttribute(FIELD_TITLEPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getTitlePSDEFName() != null) {
            object = pSViewMsgBase.getTitlePSDEFName();
            xmlNode.setAttribute(FIELD_TITLEPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getTitlePSLanResId() != null) {
            object = pSViewMsgBase.getTitlePSLanResId();
            xmlNode.setAttribute(FIELD_TITLEPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getTitlePSLanResName() != null) {
            object = pSViewMsgBase.getTitlePSLanResName();
            xmlNode.setAttribute(FIELD_TITLEPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getUpdateDate() != null) {
            object = pSViewMsgBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSViewMsgBase.getUpdateMan() != null) {
            object = pSViewMsgBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getUserCat() != null) {
            object = pSViewMsgBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getUserTag() != null) {
            object = pSViewMsgBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getUserTag2() != null) {
            object = pSViewMsgBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getUserTag3() != null) {
            object = pSViewMsgBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getUserTag4() != null) {
            object = pSViewMsgBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getViewMsgParams() != null) {
            object = pSViewMsgBase.getViewMsgParams();
            xmlNode.setAttribute(FIELD_VIEWMSGPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getVewMsgTag() != null) {
            object = pSViewMsgBase.getVewMsgTag();
            xmlNode.setAttribute("VEWMSGTAG", object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgBase.getVewMsgTag2() != null) {
            object = pSViewMsgBase.getVewMsgTag2();
            xmlNode.setAttribute("VEWMSGTAG2", object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSViewMsgBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSViewMsgBase pSViewMsgBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSViewMsgBase.isCacheScopeDirty() && (bl || pSViewMsgBase.getCacheScope() != null)) {
            iDataObject.set(FIELD_CACHESCOPE, (Object)pSViewMsgBase.getCacheScope());
        }
        if (pSViewMsgBase.isCacheTag2PSDEFIdDirty() && (bl || pSViewMsgBase.getCacheTag2PSDEFId() != null)) {
            iDataObject.set(FIELD_CACHETAG2PSDEFID, (Object)pSViewMsgBase.getCacheTag2PSDEFId());
        }
        if (pSViewMsgBase.isCacheTag2PSDEFNameDirty() && (bl || pSViewMsgBase.getCacheTag2PSDEFName() != null)) {
            iDataObject.set(FIELD_CACHETAG2PSDEFNAME, (Object)pSViewMsgBase.getCacheTag2PSDEFName());
        }
        if (pSViewMsgBase.isCacheTagPSDEFIdDirty() && (bl || pSViewMsgBase.getCacheTagPSDEFId() != null)) {
            iDataObject.set(FIELD_CACHETAGPSDEFID, (Object)pSViewMsgBase.getCacheTagPSDEFId());
        }
        if (pSViewMsgBase.isCacheTagPSDEFNameDirty() && (bl || pSViewMsgBase.getCacheTagPSDEFName() != null)) {
            iDataObject.set(FIELD_CACHETAGPSDEFNAME, (Object)pSViewMsgBase.getCacheTagPSDEFName());
        }
        if (pSViewMsgBase.isCacheTimeoutDirty() && (bl || pSViewMsgBase.getCacheTimeout() != null)) {
            iDataObject.set(FIELD_CACHETIMEOUT, (Object)pSViewMsgBase.getCacheTimeout());
        }
        if (pSViewMsgBase.isClsPSDEFIdDirty() && (bl || pSViewMsgBase.getClsPSDEFId() != null)) {
            iDataObject.set(FIELD_CLSPSDEFID, (Object)pSViewMsgBase.getClsPSDEFId());
        }
        if (pSViewMsgBase.isClsPSDEFNameDirty() && (bl || pSViewMsgBase.getClsPSDEFName() != null)) {
            iDataObject.set(FIELD_CLSPSDEFNAME, (Object)pSViewMsgBase.getClsPSDEFName());
        }
        if (pSViewMsgBase.isCodeNameDirty() && (bl || pSViewMsgBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSViewMsgBase.getCodeName());
        }
        if (pSViewMsgBase.isContentDirty() && (bl || pSViewMsgBase.getContent() != null)) {
            iDataObject.set(FIELD_CONTENT, (Object)pSViewMsgBase.getContent());
        }
        if (pSViewMsgBase.isContentPSDEFIdDirty() && (bl || pSViewMsgBase.getContentPSDEFId() != null)) {
            iDataObject.set(FIELD_CONTENTPSDEFID, (Object)pSViewMsgBase.getContentPSDEFId());
        }
        if (pSViewMsgBase.isContentPSDEFNameDirty() && (bl || pSViewMsgBase.getContentPSDEFName() != null)) {
            iDataObject.set(FIELD_CONTENTPSDEFNAME, (Object)pSViewMsgBase.getContentPSDEFName());
        }
        if (pSViewMsgBase.isContentPSLanResIdDirty() && (bl || pSViewMsgBase.getContentPSLanResId() != null)) {
            iDataObject.set(FIELD_CONTENTPSLANRESID, (Object)pSViewMsgBase.getContentPSLanResId());
        }
        if (pSViewMsgBase.isContentPSLanResNameDirty() && (bl || pSViewMsgBase.getContentPSLanResName() != null)) {
            iDataObject.set(FIELD_CONTENTPSLANRESNAME, (Object)pSViewMsgBase.getContentPSLanResName());
        }
        if (pSViewMsgBase.isContentTypeDirty() && (bl || pSViewMsgBase.getContentType() != null)) {
            iDataObject.set(FIELD_CONTENTTYPE, (Object)pSViewMsgBase.getContentType());
        }
        if (pSViewMsgBase.isContentTypePSDEFIdDirty() && (bl || pSViewMsgBase.getContentTypePSDEFId() != null)) {
            iDataObject.set(FIELD_CONTENTTYPEPSDEFID, (Object)pSViewMsgBase.getContentTypePSDEFId());
        }
        if (pSViewMsgBase.isContentTypePSDEFNameDirty() && (bl || pSViewMsgBase.getContentTypePSDEFName() != null)) {
            iDataObject.set(FIELD_CONTENTTYPEPSDEFNAME, (Object)pSViewMsgBase.getContentTypePSDEFName());
        }
        if (pSViewMsgBase.isCreateDateDirty() && (bl || pSViewMsgBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSViewMsgBase.getCreateDate());
        }
        if (pSViewMsgBase.isCreateManDirty() && (bl || pSViewMsgBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSViewMsgBase.getCreateMan());
        }
        if (pSViewMsgBase.isDefaultFlagDirty() && (bl || pSViewMsgBase.getDefaultFlag() != null)) {
            iDataObject.set(FIELD_DEFAULTFLAG, (Object)pSViewMsgBase.getDefaultFlag());
        }
        if (pSViewMsgBase.isDSLinkDirty() && (bl || pSViewMsgBase.getDSLink() != null)) {
            iDataObject.set(FIELD_DSLINK, (Object)pSViewMsgBase.getDSLink());
        }
        if (pSViewMsgBase.isDynamicModeDirty() && (bl || pSViewMsgBase.getDynamicMode() != null)) {
            iDataObject.set(FIELD_DYNAMICMODE, (Object)pSViewMsgBase.getDynamicMode());
        }
        if (pSViewMsgBase.isEnableCacheDirty() && (bl || pSViewMsgBase.getEnableCache() != null)) {
            iDataObject.set(FIELD_ENABLECACHE, (Object)pSViewMsgBase.getEnableCache());
        }
        if (pSViewMsgBase.isEnableModeDirty() && (bl || pSViewMsgBase.getEnableMode() != null)) {
            iDataObject.set(FIELD_ENABLEMODE, (Object)pSViewMsgBase.getEnableMode());
        }
        if (pSViewMsgBase.isEnableRemoveDirty() && (bl || pSViewMsgBase.getEnableRemove() != null)) {
            iDataObject.set(FIELD_ENABLEREMOVE, (Object)pSViewMsgBase.getEnableRemove());
        }
        if (pSViewMsgBase.isGroupPSDEFIdDirty() && (bl || pSViewMsgBase.getGroupPSDEFId() != null)) {
            iDataObject.set(FIELD_GROUPPSDEFID, (Object)pSViewMsgBase.getGroupPSDEFId());
        }
        if (pSViewMsgBase.isGroupPSDEFNameDirty() && (bl || pSViewMsgBase.getGroupPSDEFName() != null)) {
            iDataObject.set(FIELD_GROUPPSDEFNAME, (Object)pSViewMsgBase.getGroupPSDEFName());
        }
        if (pSViewMsgBase.isIconPSDEFIdDirty() && (bl || pSViewMsgBase.getIconPSDEFId() != null)) {
            iDataObject.set(FIELD_ICONPSDEFID, (Object)pSViewMsgBase.getIconPSDEFId());
        }
        if (pSViewMsgBase.isIconPSDEFNameDirty() && (bl || pSViewMsgBase.getIconPSDEFName() != null)) {
            iDataObject.set(FIELD_ICONPSDEFNAME, (Object)pSViewMsgBase.getIconPSDEFName());
        }
        if (pSViewMsgBase.isLockFlagDirty() && (bl || pSViewMsgBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSViewMsgBase.getLockFlag());
        }
        if (pSViewMsgBase.isMemoDirty() && (bl || pSViewMsgBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSViewMsgBase.getMemo());
        }
        if (pSViewMsgBase.isMsgGroupDirty() && (bl || pSViewMsgBase.getMsgGroup() != null)) {
            iDataObject.set(FIELD_MSGGROUP, (Object)pSViewMsgBase.getMsgGroup());
        }
        if (pSViewMsgBase.isMsgPosDirty() && (bl || pSViewMsgBase.getMsgPos() != null)) {
            iDataObject.set(FIELD_MSGPOS, (Object)pSViewMsgBase.getMsgPos());
        }
        if (pSViewMsgBase.isMsgPosPSDEFIdDirty() && (bl || pSViewMsgBase.getMsgPosPSDEFId() != null)) {
            iDataObject.set(FIELD_MSGPOSPSDEFID, (Object)pSViewMsgBase.getMsgPosPSDEFId());
        }
        if (pSViewMsgBase.isMsgPosPSDEFNameDirty() && (bl || pSViewMsgBase.getMsgPosPSDEFName() != null)) {
            iDataObject.set(FIELD_MSGPOSPSDEFNAME, (Object)pSViewMsgBase.getMsgPosPSDEFName());
        }
        if (pSViewMsgBase.isMsgTypeDirty() && (bl || pSViewMsgBase.getMsgType() != null)) {
            iDataObject.set(FIELD_MSGTYPE, (Object)pSViewMsgBase.getMsgType());
        }
        if (pSViewMsgBase.isMsgTypePSDEFIdDirty() && (bl || pSViewMsgBase.getMsgTypePSDEFId() != null)) {
            iDataObject.set(FIELD_MSGTYPEPSDEFID, (Object)pSViewMsgBase.getMsgTypePSDEFId());
        }
        if (pSViewMsgBase.isMsgTypePSDEFNameDirty() && (bl || pSViewMsgBase.getMsgTypePSDEFName() != null)) {
            iDataObject.set(FIELD_MSGTYPEPSDEFNAME, (Object)pSViewMsgBase.getMsgTypePSDEFName());
        }
        if (pSViewMsgBase.isOrderValuePSDEFIdDirty() && (bl || pSViewMsgBase.getOrderValuePSDEFId() != null)) {
            iDataObject.set(FIELD_ORDERVALUEPSDEFID, (Object)pSViewMsgBase.getOrderValuePSDEFId());
        }
        if (pSViewMsgBase.isOrderValuePSDEFNameDirty() && (bl || pSViewMsgBase.getOrderValuePSDEFName() != null)) {
            iDataObject.set(FIELD_ORDERVALUEPSDEFNAME, (Object)pSViewMsgBase.getOrderValuePSDEFName());
        }
        if (pSViewMsgBase.isPredefinedTypeDirty() && (bl || pSViewMsgBase.getPredefinedType() != null)) {
            iDataObject.set(FIELD_PREDEFINEDTYPE, (Object)pSViewMsgBase.getPredefinedType());
        }
        if (pSViewMsgBase.isPSDEDSIdDirty() && (bl || pSViewMsgBase.getPSDEDSId() != null)) {
            iDataObject.set(FIELD_PSDEDSID, (Object)pSViewMsgBase.getPSDEDSId());
        }
        if (pSViewMsgBase.isPSDEDSNameDirty() && (bl || pSViewMsgBase.getPSDEDSName() != null)) {
            iDataObject.set(FIELD_PSDEDSNAME, (Object)pSViewMsgBase.getPSDEDSName());
        }
        if (pSViewMsgBase.isPSDEIdDirty() && (bl || pSViewMsgBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSViewMsgBase.getPSDEId());
        }
        if (pSViewMsgBase.isPSDELogicIdDirty() && (bl || pSViewMsgBase.getPSDELogicId() != null)) {
            iDataObject.set(FIELD_PSDELOGICID, (Object)pSViewMsgBase.getPSDELogicId());
        }
        if (pSViewMsgBase.isPSDELogicNameDirty() && (bl || pSViewMsgBase.getPSDELogicName() != null)) {
            iDataObject.set(FIELD_PSDELOGICNAME, (Object)pSViewMsgBase.getPSDELogicName());
        }
        if (pSViewMsgBase.isPSDENameDirty() && (bl || pSViewMsgBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSViewMsgBase.getPSDEName());
        }
        if (pSViewMsgBase.isPSDEOPPrivIdDirty() && (bl || pSViewMsgBase.getPSDEOPPrivId() != null)) {
            iDataObject.set(FIELD_PSDEOPPRIVID, (Object)pSViewMsgBase.getPSDEOPPrivId());
        }
        if (pSViewMsgBase.isPSDEOPPrivNameDirty() && (bl || pSViewMsgBase.getPSDEOPPrivName() != null)) {
            iDataObject.set(FIELD_PSDEOPPRIVNAME, (Object)pSViewMsgBase.getPSDEOPPrivName());
        }
        if (pSViewMsgBase.isPSModuleIdDirty() && (bl || pSViewMsgBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSViewMsgBase.getPSModuleId());
        }
        if (pSViewMsgBase.isPSModuleNameDirty() && (bl || pSViewMsgBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSViewMsgBase.getPSModuleName());
        }
        if (pSViewMsgBase.isPSSysCssIdDirty() && (bl || pSViewMsgBase.getPSSysCssId() != null)) {
            iDataObject.set(FIELD_PSSYSCSSID, (Object)pSViewMsgBase.getPSSysCssId());
        }
        if (pSViewMsgBase.isPSSysCssNameDirty() && (bl || pSViewMsgBase.getPSSysCssName() != null)) {
            iDataObject.set(FIELD_PSSYSCSSNAME, (Object)pSViewMsgBase.getPSSysCssName());
        }
        if (pSViewMsgBase.isPSSysDynaModelIdDirty() && (bl || pSViewMsgBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSViewMsgBase.getPSSysDynaModelId());
        }
        if (pSViewMsgBase.isPSSysDynaModelNameDirty() && (bl || pSViewMsgBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSViewMsgBase.getPSSysDynaModelName());
        }
        if (pSViewMsgBase.isPSSysImageIdDirty() && (bl || pSViewMsgBase.getPSSysImageId() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGEID, (Object)pSViewMsgBase.getPSSysImageId());
        }
        if (pSViewMsgBase.isPSSysImageNameDirty() && (bl || pSViewMsgBase.getPSSysImageName() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGENAME, (Object)pSViewMsgBase.getPSSysImageName());
        }
        if (pSViewMsgBase.isPSSysMsgTemplIdDirty() && (bl || pSViewMsgBase.getPSSysMsgTemplId() != null)) {
            iDataObject.set(FIELD_PSSYSMSGTEMPLID, (Object)pSViewMsgBase.getPSSysMsgTemplId());
        }
        if (pSViewMsgBase.isPSSysMsgTemplNameDirty() && (bl || pSViewMsgBase.getPSSysMsgTemplName() != null)) {
            iDataObject.set(FIELD_PSSYSMSGTEMPLNAME, (Object)pSViewMsgBase.getPSSysMsgTemplName());
        }
        if (pSViewMsgBase.isPSSysSFPluginIdDirty() && (bl || pSViewMsgBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSViewMsgBase.getPSSysSFPluginId());
        }
        if (pSViewMsgBase.isPSSysSFPluginNameDirty() && (bl || pSViewMsgBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSViewMsgBase.getPSSysSFPluginName());
        }
        if (pSViewMsgBase.isPSSystemIdDirty() && (bl || pSViewMsgBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSViewMsgBase.getPSSystemId());
        }
        if (pSViewMsgBase.isPSSystemNameDirty() && (bl || pSViewMsgBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSViewMsgBase.getPSSystemName());
        }
        if (pSViewMsgBase.isPSSysViewPanelIdDirty() && (bl || pSViewMsgBase.getPSSysViewPanelId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELID, (Object)pSViewMsgBase.getPSSysViewPanelId());
        }
        if (pSViewMsgBase.isPSSysViewPanelNameDirty() && (bl || pSViewMsgBase.getPSSysViewPanelName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELNAME, (Object)pSViewMsgBase.getPSSysViewPanelName());
        }
        if (pSViewMsgBase.isPSViewMsgIdDirty() && (bl || pSViewMsgBase.getPSViewMsgId() != null)) {
            iDataObject.set(FIELD_PSVIEWMSGID, (Object)pSViewMsgBase.getPSViewMsgId());
        }
        if (pSViewMsgBase.isPSViewMsgNameDirty() && (bl || pSViewMsgBase.getPSViewMsgName() != null)) {
            iDataObject.set(FIELD_PSVIEWMSGNAME, (Object)pSViewMsgBase.getPSViewMsgName());
        }
        if (pSViewMsgBase.isRemovePSDEFIdDirty() && (bl || pSViewMsgBase.getRemovePSDEFId() != null)) {
            iDataObject.set(FIELD_REMOVEPSDEFID, (Object)pSViewMsgBase.getRemovePSDEFId());
        }
        if (pSViewMsgBase.isRemovePSDEFNameDirty() && (bl || pSViewMsgBase.getRemovePSDEFName() != null)) {
            iDataObject.set(FIELD_REMOVEPSDEFNAME, (Object)pSViewMsgBase.getRemovePSDEFName());
        }
        if (pSViewMsgBase.isTestCustomCodeDirty() && (bl || pSViewMsgBase.getTestCustomCode() != null)) {
            iDataObject.set(FIELD_TESTCUSTOMCODE, (Object)pSViewMsgBase.getTestCustomCode());
        }
        if (pSViewMsgBase.isTestPSDELogicIdDirty() && (bl || pSViewMsgBase.getTestPSDELogicId() != null)) {
            iDataObject.set(FIELD_TESTPSDELOGICID, (Object)pSViewMsgBase.getTestPSDELogicId());
        }
        if (pSViewMsgBase.isTestPSDELogicNameDirty() && (bl || pSViewMsgBase.getTestPSDELogicName() != null)) {
            iDataObject.set(FIELD_TESTPSDELOGICNAME, (Object)pSViewMsgBase.getTestPSDELogicName());
        }
        if (pSViewMsgBase.isTimeoutDirty() && (bl || pSViewMsgBase.getTimeout() != null)) {
            iDataObject.set(FIELD_TIMEOUT, (Object)pSViewMsgBase.getTimeout());
        }
        if (pSViewMsgBase.isTitleDirty() && (bl || pSViewMsgBase.getTitle() != null)) {
            iDataObject.set(FIELD_TITLE, (Object)pSViewMsgBase.getTitle());
        }
        if (pSViewMsgBase.isTitleLanResTagPSDEFIdDirty() && (bl || pSViewMsgBase.getTitleLanResTagPSDEFId() != null)) {
            iDataObject.set(FIELD_TITLELANRESTAGPSDEFID, (Object)pSViewMsgBase.getTitleLanResTagPSDEFId());
        }
        if (pSViewMsgBase.isTitleLanResTagPSDEFNameDirty() && (bl || pSViewMsgBase.getTitleLanResTagPSDEFName() != null)) {
            iDataObject.set(FIELD_TITLELANRESTAGPSDEFNAME, (Object)pSViewMsgBase.getTitleLanResTagPSDEFName());
        }
        if (pSViewMsgBase.isTitlePSDEFIdDirty() && (bl || pSViewMsgBase.getTitlePSDEFId() != null)) {
            iDataObject.set(FIELD_TITLEPSDEFID, (Object)pSViewMsgBase.getTitlePSDEFId());
        }
        if (pSViewMsgBase.isTitlePSDEFNameDirty() && (bl || pSViewMsgBase.getTitlePSDEFName() != null)) {
            iDataObject.set(FIELD_TITLEPSDEFNAME, (Object)pSViewMsgBase.getTitlePSDEFName());
        }
        if (pSViewMsgBase.isTitlePSLanResIdDirty() && (bl || pSViewMsgBase.getTitlePSLanResId() != null)) {
            iDataObject.set(FIELD_TITLEPSLANRESID, (Object)pSViewMsgBase.getTitlePSLanResId());
        }
        if (pSViewMsgBase.isTitlePSLanResNameDirty() && (bl || pSViewMsgBase.getTitlePSLanResName() != null)) {
            iDataObject.set(FIELD_TITLEPSLANRESNAME, (Object)pSViewMsgBase.getTitlePSLanResName());
        }
        if (pSViewMsgBase.isUpdateDateDirty() && (bl || pSViewMsgBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSViewMsgBase.getUpdateDate());
        }
        if (pSViewMsgBase.isUpdateManDirty() && (bl || pSViewMsgBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSViewMsgBase.getUpdateMan());
        }
        if (pSViewMsgBase.isUserCatDirty() && (bl || pSViewMsgBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSViewMsgBase.getUserCat());
        }
        if (pSViewMsgBase.isUserTagDirty() && (bl || pSViewMsgBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSViewMsgBase.getUserTag());
        }
        if (pSViewMsgBase.isUserTag2Dirty() && (bl || pSViewMsgBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSViewMsgBase.getUserTag2());
        }
        if (pSViewMsgBase.isUserTag3Dirty() && (bl || pSViewMsgBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSViewMsgBase.getUserTag3());
        }
        if (pSViewMsgBase.isUserTag4Dirty() && (bl || pSViewMsgBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSViewMsgBase.getUserTag4());
        }
        if (pSViewMsgBase.isViewMsgParamsDirty() && (bl || pSViewMsgBase.getViewMsgParams() != null)) {
            iDataObject.set(FIELD_VIEWMSGPARAMS, (Object)pSViewMsgBase.getViewMsgParams());
        }
        if (pSViewMsgBase.isVewMsgTagDirty() && (bl || pSViewMsgBase.getVewMsgTag() != null)) {
            iDataObject.set(FIELD_VEWMSGTAG, (Object)pSViewMsgBase.getVewMsgTag());
        }
        if (pSViewMsgBase.isVewMsgTag2Dirty() && (bl || pSViewMsgBase.getVewMsgTag2() != null)) {
            iDataObject.set(FIELD_VEWMSGTAG2, (Object)pSViewMsgBase.getVewMsgTag2());
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
        return PSViewMsgBase.remove(this, n);
    }

    private static boolean remove(PSViewMsgBase pSViewMsgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSViewMsgBase.resetCacheScope();
                return true;
            }
            case 1: {
                pSViewMsgBase.resetCacheTag2PSDEFId();
                return true;
            }
            case 2: {
                pSViewMsgBase.resetCacheTag2PSDEFName();
                return true;
            }
            case 3: {
                pSViewMsgBase.resetCacheTagPSDEFId();
                return true;
            }
            case 4: {
                pSViewMsgBase.resetCacheTagPSDEFName();
                return true;
            }
            case 5: {
                pSViewMsgBase.resetCacheTimeout();
                return true;
            }
            case 6: {
                pSViewMsgBase.resetClsPSDEFId();
                return true;
            }
            case 7: {
                pSViewMsgBase.resetClsPSDEFName();
                return true;
            }
            case 8: {
                pSViewMsgBase.resetCodeName();
                return true;
            }
            case 9: {
                pSViewMsgBase.resetContent();
                return true;
            }
            case 10: {
                pSViewMsgBase.resetContentPSDEFId();
                return true;
            }
            case 11: {
                pSViewMsgBase.resetContentPSDEFName();
                return true;
            }
            case 12: {
                pSViewMsgBase.resetContentPSLanResId();
                return true;
            }
            case 13: {
                pSViewMsgBase.resetContentPSLanResName();
                return true;
            }
            case 14: {
                pSViewMsgBase.resetContentType();
                return true;
            }
            case 15: {
                pSViewMsgBase.resetContentTypePSDEFId();
                return true;
            }
            case 16: {
                pSViewMsgBase.resetContentTypePSDEFName();
                return true;
            }
            case 17: {
                pSViewMsgBase.resetCreateDate();
                return true;
            }
            case 18: {
                pSViewMsgBase.resetCreateMan();
                return true;
            }
            case 19: {
                pSViewMsgBase.resetDefaultFlag();
                return true;
            }
            case 20: {
                pSViewMsgBase.resetDSLink();
                return true;
            }
            case 21: {
                pSViewMsgBase.resetDynamicMode();
                return true;
            }
            case 22: {
                pSViewMsgBase.resetEnableCache();
                return true;
            }
            case 23: {
                pSViewMsgBase.resetEnableMode();
                return true;
            }
            case 24: {
                pSViewMsgBase.resetEnableRemove();
                return true;
            }
            case 25: {
                pSViewMsgBase.resetGroupPSDEFId();
                return true;
            }
            case 26: {
                pSViewMsgBase.resetGroupPSDEFName();
                return true;
            }
            case 27: {
                pSViewMsgBase.resetIconPSDEFId();
                return true;
            }
            case 28: {
                pSViewMsgBase.resetIconPSDEFName();
                return true;
            }
            case 29: {
                pSViewMsgBase.resetLockFlag();
                return true;
            }
            case 30: {
                pSViewMsgBase.resetMemo();
                return true;
            }
            case 31: {
                pSViewMsgBase.resetMsgGroup();
                return true;
            }
            case 32: {
                pSViewMsgBase.resetMsgPos();
                return true;
            }
            case 33: {
                pSViewMsgBase.resetMsgPosPSDEFId();
                return true;
            }
            case 34: {
                pSViewMsgBase.resetMsgPosPSDEFName();
                return true;
            }
            case 35: {
                pSViewMsgBase.resetMsgType();
                return true;
            }
            case 36: {
                pSViewMsgBase.resetMsgTypePSDEFId();
                return true;
            }
            case 37: {
                pSViewMsgBase.resetMsgTypePSDEFName();
                return true;
            }
            case 38: {
                pSViewMsgBase.resetOrderValuePSDEFId();
                return true;
            }
            case 39: {
                pSViewMsgBase.resetOrderValuePSDEFName();
                return true;
            }
            case 40: {
                pSViewMsgBase.resetPredefinedType();
                return true;
            }
            case 41: {
                pSViewMsgBase.resetPSDEDSId();
                return true;
            }
            case 42: {
                pSViewMsgBase.resetPSDEDSName();
                return true;
            }
            case 43: {
                pSViewMsgBase.resetPSDEId();
                return true;
            }
            case 44: {
                pSViewMsgBase.resetPSDELogicId();
                return true;
            }
            case 45: {
                pSViewMsgBase.resetPSDELogicName();
                return true;
            }
            case 46: {
                pSViewMsgBase.resetPSDEName();
                return true;
            }
            case 47: {
                pSViewMsgBase.resetPSDEOPPrivId();
                return true;
            }
            case 48: {
                pSViewMsgBase.resetPSDEOPPrivName();
                return true;
            }
            case 49: {
                pSViewMsgBase.resetPSModuleId();
                return true;
            }
            case 50: {
                pSViewMsgBase.resetPSModuleName();
                return true;
            }
            case 51: {
                pSViewMsgBase.resetPSSysCssId();
                return true;
            }
            case 52: {
                pSViewMsgBase.resetPSSysCssName();
                return true;
            }
            case 53: {
                pSViewMsgBase.resetPSSysDynaModelId();
                return true;
            }
            case 54: {
                pSViewMsgBase.resetPSSysDynaModelName();
                return true;
            }
            case 55: {
                pSViewMsgBase.resetPSSysImageId();
                return true;
            }
            case 56: {
                pSViewMsgBase.resetPSSysImageName();
                return true;
            }
            case 57: {
                pSViewMsgBase.resetPSSysMsgTemplId();
                return true;
            }
            case 58: {
                pSViewMsgBase.resetPSSysMsgTemplName();
                return true;
            }
            case 59: {
                pSViewMsgBase.resetPSSysSFPluginId();
                return true;
            }
            case 60: {
                pSViewMsgBase.resetPSSysSFPluginName();
                return true;
            }
            case 61: {
                pSViewMsgBase.resetPSSystemId();
                return true;
            }
            case 62: {
                pSViewMsgBase.resetPSSystemName();
                return true;
            }
            case 63: {
                pSViewMsgBase.resetPSSysViewPanelId();
                return true;
            }
            case 64: {
                pSViewMsgBase.resetPSSysViewPanelName();
                return true;
            }
            case 65: {
                pSViewMsgBase.resetPSViewMsgId();
                return true;
            }
            case 66: {
                pSViewMsgBase.resetPSViewMsgName();
                return true;
            }
            case 67: {
                pSViewMsgBase.resetRemovePSDEFId();
                return true;
            }
            case 68: {
                pSViewMsgBase.resetRemovePSDEFName();
                return true;
            }
            case 69: {
                pSViewMsgBase.resetTestCustomCode();
                return true;
            }
            case 70: {
                pSViewMsgBase.resetTestPSDELogicId();
                return true;
            }
            case 71: {
                pSViewMsgBase.resetTestPSDELogicName();
                return true;
            }
            case 72: {
                pSViewMsgBase.resetTimeout();
                return true;
            }
            case 73: {
                pSViewMsgBase.resetTitle();
                return true;
            }
            case 74: {
                pSViewMsgBase.resetTitleLanResTagPSDEFId();
                return true;
            }
            case 75: {
                pSViewMsgBase.resetTitleLanResTagPSDEFName();
                return true;
            }
            case 76: {
                pSViewMsgBase.resetTitlePSDEFId();
                return true;
            }
            case 77: {
                pSViewMsgBase.resetTitlePSDEFName();
                return true;
            }
            case 78: {
                pSViewMsgBase.resetTitlePSLanResId();
                return true;
            }
            case 79: {
                pSViewMsgBase.resetTitlePSLanResName();
                return true;
            }
            case 80: {
                pSViewMsgBase.resetUpdateDate();
                return true;
            }
            case 81: {
                pSViewMsgBase.resetUpdateMan();
                return true;
            }
            case 82: {
                pSViewMsgBase.resetUserCat();
                return true;
            }
            case 83: {
                pSViewMsgBase.resetUserTag();
                return true;
            }
            case 84: {
                pSViewMsgBase.resetUserTag2();
                return true;
            }
            case 85: {
                pSViewMsgBase.resetUserTag3();
                return true;
            }
            case 86: {
                pSViewMsgBase.resetUserTag4();
                return true;
            }
            case 87: {
                pSViewMsgBase.resetViewMsgParams();
                return true;
            }
            case 88: {
                pSViewMsgBase.resetVewMsgTag();
                return true;
            }
            case 89: {
                pSViewMsgBase.resetVewMsgTag2();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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
                pSDEDataSetService.autoGet(pSDEDataSet);
                this.psdeds = pSDEDataSet;
            }
            return this.psdeds;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getCacheTag2PSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCacheTag2PSDEF();
        }
        if (this.getCacheTag2PSDEFId() == null) {
            return null;
        }
        Integer n = this.objCacheTag2PSDEFLock;
        synchronized (n) {
            if (this.cachetag2psdef != null && DataTypeHelper.compare((int)25, (Object)this.getCacheTag2PSDEFId(), (Object)this.cachetag2psdef.getPSDEFieldId()) != 0L) {
                this.cachetag2psdef = null;
            }
            if (this.cachetag2psdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getCacheTag2PSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.cachetag2psdef = pSDEField;
            }
            return this.cachetag2psdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getCacheTagPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCacheTagPSDEF();
        }
        if (this.getCacheTagPSDEFId() == null) {
            return null;
        }
        Integer n = this.objCacheTagPSDEFLock;
        synchronized (n) {
            if (this.cachetagpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getCacheTagPSDEFId(), (Object)this.cachetagpsdef.getPSDEFieldId()) != 0L) {
                this.cachetagpsdef = null;
            }
            if (this.cachetagpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getCacheTagPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.cachetagpsdef = pSDEField;
            }
            return this.cachetagpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getClsPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getClsPSDEF();
        }
        if (this.getClsPSDEFId() == null) {
            return null;
        }
        Integer n = this.objClsPSDEFLock;
        synchronized (n) {
            if (this.clspsdef != null && DataTypeHelper.compare((int)25, (Object)this.getClsPSDEFId(), (Object)this.clspsdef.getPSDEFieldId()) != 0L) {
                this.clspsdef = null;
            }
            if (this.clspsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getClsPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.clspsdef = pSDEField;
            }
            return this.clspsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getContentPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContentPSDEF();
        }
        if (this.getContentPSDEFId() == null) {
            return null;
        }
        Integer n = this.objContentPSDEFLock;
        synchronized (n) {
            if (this.contentpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getContentPSDEFId(), (Object)this.contentpsdef.getPSDEFieldId()) != 0L) {
                this.contentpsdef = null;
            }
            if (this.contentpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getContentPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.contentpsdef = pSDEField;
            }
            return this.contentpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getContentTypePDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContentTypePDEF();
        }
        if (this.getContentTypePSDEFId() == null) {
            return null;
        }
        Integer n = this.objContentTypePDEFLock;
        synchronized (n) {
            if (this.contenttypepdef != null && DataTypeHelper.compare((int)25, (Object)this.getContentTypePSDEFId(), (Object)this.contenttypepdef.getPSDEFieldId()) != 0L) {
                this.contenttypepdef = null;
            }
            if (this.contenttypepdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getContentTypePSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.contenttypepdef = pSDEField;
            }
            return this.contenttypepdef;
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
                pSDEFieldService.autoGet(pSDEField);
                this.grouppsdef = pSDEField;
            }
            return this.grouppsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getIconPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIconPSDEF();
        }
        if (this.getIconPSDEFId() == null) {
            return null;
        }
        Integer n = this.objIconPSDEFLock;
        synchronized (n) {
            if (this.iconpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getIconPSDEFId(), (Object)this.iconpsdef.getPSDEFieldId()) != 0L) {
                this.iconpsdef = null;
            }
            if (this.iconpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getIconPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.iconpsdef = pSDEField;
            }
            return this.iconpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getMsgPosPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMsgPosPSDEF();
        }
        if (this.getMsgPosPSDEFId() == null) {
            return null;
        }
        Integer n = this.objMsgPosPSDEFLock;
        synchronized (n) {
            if (this.msgpospsdef != null && DataTypeHelper.compare((int)25, (Object)this.getMsgPosPSDEFId(), (Object)this.msgpospsdef.getPSDEFieldId()) != 0L) {
                this.msgpospsdef = null;
            }
            if (this.msgpospsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getMsgPosPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.msgpospsdef = pSDEField;
            }
            return this.msgpospsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getMsgTypePSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMsgTypePSDEF();
        }
        if (this.getMsgTypePSDEFId() == null) {
            return null;
        }
        Integer n = this.objMsgTypePSDEFLock;
        synchronized (n) {
            if (this.msgtypepsdef != null && DataTypeHelper.compare((int)25, (Object)this.getMsgTypePSDEFId(), (Object)this.msgtypepsdef.getPSDEFieldId()) != 0L) {
                this.msgtypepsdef = null;
            }
            if (this.msgtypepsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getMsgTypePSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.msgtypepsdef = pSDEField;
            }
            return this.msgtypepsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getOrderValuePSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrderValuePSDEF();
        }
        if (this.getOrderValuePSDEFId() == null) {
            return null;
        }
        Integer n = this.objOrderValuePSDEFLock;
        synchronized (n) {
            if (this.ordervaluepsdef != null && DataTypeHelper.compare((int)25, (Object)this.getOrderValuePSDEFId(), (Object)this.ordervaluepsdef.getPSDEFieldId()) != 0L) {
                this.ordervaluepsdef = null;
            }
            if (this.ordervaluepsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getOrderValuePSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.ordervaluepsdef = pSDEField;
            }
            return this.ordervaluepsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getRemovePSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRemovePSDEF();
        }
        if (this.getRemovePSDEFId() == null) {
            return null;
        }
        Integer n = this.objRemovePSDEFLock;
        synchronized (n) {
            if (this.removepsdef != null && DataTypeHelper.compare((int)25, (Object)this.getRemovePSDEFId(), (Object)this.removepsdef.getPSDEFieldId()) != 0L) {
                this.removepsdef = null;
            }
            if (this.removepsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getRemovePSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.removepsdef = pSDEField;
            }
            return this.removepsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getTltleLanResTagPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTltleLanResTagPSDEF();
        }
        if (this.getTitleLanResTagPSDEFId() == null) {
            return null;
        }
        Integer n = this.objTltleLanResTagPSDEFLock;
        synchronized (n) {
            if (this.tltlelanrestagpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getTitleLanResTagPSDEFId(), (Object)this.tltlelanrestagpsdef.getPSDEFieldId()) != 0L) {
                this.tltlelanrestagpsdef = null;
            }
            if (this.tltlelanrestagpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getTitleLanResTagPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.tltlelanrestagpsdef = pSDEField;
            }
            return this.tltlelanrestagpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getTitlePSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTitlePSDEF();
        }
        if (this.getTitlePSDEFId() == null) {
            return null;
        }
        Integer n = this.objTitlePSDEFLock;
        synchronized (n) {
            if (this.titlepsdef != null && DataTypeHelper.compare((int)25, (Object)this.getTitlePSDEFId(), (Object)this.titlepsdef.getPSDEFieldId()) != 0L) {
                this.titlepsdef = null;
            }
            if (this.titlepsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getTitlePSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.titlepsdef = pSDEField;
            }
            return this.titlepsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDELogic getPSDELogic() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELogic();
        }
        if (this.getPSDELogicId() == null) {
            return null;
        }
        Integer n = this.objPSDELogicLock;
        synchronized (n) {
            if (this.psdelogic != null && DataTypeHelper.compare((int)25, (Object)this.getPSDELogicId(), (Object)this.psdelogic.getPSDELogicId()) != 0L) {
                this.psdelogic = null;
            }
            if (this.psdelogic == null) {
                PSDELogic pSDELogic = new PSDELogic();
                pSDELogic.setPSDELogicId(this.getPSDELogicId());
                PSDELogicService pSDELogicService = (PSDELogicService)ServiceGlobal.getService(PSDELogicService.class, (SessionFactory)this.getSessionFactory());
                pSDELogicService.autoGet(pSDELogic);
                this.psdelogic = pSDELogic;
            }
            return this.psdelogic;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDELogic getTestPSDELogic() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTestPSDELogic();
        }
        if (this.getTestPSDELogicId() == null) {
            return null;
        }
        Integer n = this.objTestPSDELogicLock;
        synchronized (n) {
            if (this.testpsdelogic != null && DataTypeHelper.compare((int)25, (Object)this.getTestPSDELogicId(), (Object)this.testpsdelogic.getPSDELogicId()) != 0L) {
                this.testpsdelogic = null;
            }
            if (this.testpsdelogic == null) {
                PSDELogic pSDELogic = new PSDELogic();
                pSDELogic.setPSDELogicId(this.getTestPSDELogicId());
                PSDELogicService pSDELogicService = (PSDELogicService)ServiceGlobal.getService(PSDELogicService.class, (SessionFactory)this.getSessionFactory());
                pSDELogicService.autoGet(pSDELogic);
                this.testpsdelogic = pSDELogic;
            }
            return this.testpsdelogic;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEOPPriv getPSDEOPPriv() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEOPPriv();
        }
        if (this.getPSDEOPPrivId() == null) {
            return null;
        }
        Integer n = this.objPSDEOPPrivLock;
        synchronized (n) {
            if (this.psdeoppriv != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEOPPrivId(), (Object)this.psdeoppriv.getPSDEOPPrivId()) != 0L) {
                this.psdeoppriv = null;
            }
            if (this.psdeoppriv == null) {
                PSDEOPPriv pSDEOPPriv = new PSDEOPPriv();
                pSDEOPPriv.setPSDEOPPrivId(this.getPSDEOPPrivId());
                PSDEOPPrivService pSDEOPPrivService = (PSDEOPPrivService)ServiceGlobal.getService(PSDEOPPrivService.class, (SessionFactory)this.getSessionFactory());
                pSDEOPPrivService.autoGet(pSDEOPPriv);
                this.psdeoppriv = pSDEOPPriv;
            }
            return this.psdeoppriv;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getContentPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContentPSLanRes();
        }
        if (this.getContentPSLanResId() == null) {
            return null;
        }
        Integer n = this.objContentPSLanResLock;
        synchronized (n) {
            if (this.contentpslanres != null && DataTypeHelper.compare((int)25, (Object)this.getContentPSLanResId(), (Object)this.contentpslanres.getPSLanguageResId()) != 0L) {
                this.contentpslanres = null;
            }
            if (this.contentpslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getContentPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet(pSLanguageRes);
                this.contentpslanres = pSLanguageRes;
            }
            return this.contentpslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getTitlePSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTitlePSLanRes();
        }
        if (this.getTitlePSLanResId() == null) {
            return null;
        }
        Integer n = this.objTitlePSLanResLock;
        synchronized (n) {
            if (this.titlepslanres != null && DataTypeHelper.compare((int)25, (Object)this.getTitlePSLanResId(), (Object)this.titlepslanres.getPSLanguageResId()) != 0L) {
                this.titlepslanres = null;
            }
            if (this.titlepslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getTitlePSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet(pSLanguageRes);
                this.titlepslanres = pSLanguageRes;
            }
            return this.titlepslanres;
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
                pSSysDynaModelService.autoGet(pSSysDynaModel);
                this.pssysdynamodel = pSSysDynaModel;
            }
            return this.pssysdynamodel;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysImage getPSSysImage() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysImage();
        }
        if (this.getPSSysImageId() == null) {
            return null;
        }
        Integer n = this.objPSSysImageLock;
        synchronized (n) {
            if (this.pssysimage != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysImageId(), (Object)this.pssysimage.getPSSysImageId()) != 0L) {
                this.pssysimage = null;
            }
            if (this.pssysimage == null) {
                PSSysImage pSSysImage = new PSSysImage();
                pSSysImage.setPSSysImageId(this.getPSSysImageId());
                PSSysImageService pSSysImageService = (PSSysImageService)ServiceGlobal.getService(PSSysImageService.class, (SessionFactory)this.getSessionFactory());
                pSSysImageService.autoGet(pSSysImage);
                this.pssysimage = pSSysImage;
            }
            return this.pssysimage;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysMsgTempl getPSSysMsgTempl() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMsgTempl();
        }
        if (this.getPSSysMsgTemplId() == null) {
            return null;
        }
        Integer n = this.objPSSysMsgTemplLock;
        synchronized (n) {
            if (this.pssysmsgtempl != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysMsgTemplId(), (Object)this.pssysmsgtempl.getPSSysMsgTemplId()) != 0L) {
                this.pssysmsgtempl = null;
            }
            if (this.pssysmsgtempl == null) {
                PSSysMsgTempl pSSysMsgTempl = new PSSysMsgTempl();
                pSSysMsgTempl.setPSSysMsgTemplId(this.getPSSysMsgTemplId());
                PSSysMsgTemplService pSSysMsgTemplService = (PSSysMsgTemplService)ServiceGlobal.getService(PSSysMsgTemplService.class, (SessionFactory)this.getSessionFactory());
                pSSysMsgTemplService.autoGet(pSSysMsgTempl);
                this.pssysmsgtempl = pSSysMsgTempl;
            }
            return this.pssysmsgtempl;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysSFPlugin getPSSysSFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPlugin();
        }
        if (this.getPSSysSFPluginId() == null) {
            return null;
        }
        Integer n = this.objPSSysSFPluginLock;
        synchronized (n) {
            if (this.pssyssfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysSFPluginId(), (Object)this.pssyssfplugin.getPSSysSFPluginId()) != 0L) {
                this.pssyssfplugin = null;
            }
            if (this.pssyssfplugin == null) {
                PSSysSFPlugin pSSysSFPlugin = new PSSysSFPlugin();
                pSSysSFPlugin.setPSSysSFPluginId(this.getPSSysSFPluginId());
                PSSysSFPluginService pSSysSFPluginService = (PSSysSFPluginService)ServiceGlobal.getService(PSSysSFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysSFPluginService.autoGet(pSSysSFPlugin);
                this.pssyssfplugin = pSSysSFPlugin;
            }
            return this.pssyssfplugin;
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
    public PSSysViewPanel getPSSysViewPanel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanel();
        }
        if (this.getPSSysViewPanelId() == null) {
            return null;
        }
        Integer n = this.objPSSysViewPanelLock;
        synchronized (n) {
            if (this.pssysviewpanel != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysViewPanelId(), (Object)this.pssysviewpanel.getPSSysViewPanelId()) != 0L) {
                this.pssysviewpanel = null;
            }
            if (this.pssysviewpanel == null) {
                PSSysViewPanel pSSysViewPanel = new PSSysViewPanel();
                pSSysViewPanel.setPSSysViewPanelId(this.getPSSysViewPanelId());
                PSSysViewPanelService pSSysViewPanelService = (PSSysViewPanelService)ServiceGlobal.getService(PSSysViewPanelService.class, (SessionFactory)this.getSessionFactory());
                pSSysViewPanelService.autoGet(pSSysViewPanel);
                this.pssysviewpanel = pSSysViewPanel;
            }
            return this.pssysviewpanel;
        }
    }

    private PSViewMsgBase getProxyEntity() {
        return this.proxyPSViewMsgBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSViewMsgBase = null;
        if (iDataObject != null && iDataObject instanceof PSViewMsgBase) {
            this.proxyPSViewMsgBase = (PSViewMsgBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CACHESCOPE, 0);
        fieldIndexMap.put(FIELD_CACHETAG2PSDEFID, 1);
        fieldIndexMap.put(FIELD_CACHETAG2PSDEFNAME, 2);
        fieldIndexMap.put(FIELD_CACHETAGPSDEFID, 3);
        fieldIndexMap.put(FIELD_CACHETAGPSDEFNAME, 4);
        fieldIndexMap.put(FIELD_CACHETIMEOUT, 5);
        fieldIndexMap.put(FIELD_CLSPSDEFID, 6);
        fieldIndexMap.put(FIELD_CLSPSDEFNAME, 7);
        fieldIndexMap.put(FIELD_CODENAME, 8);
        fieldIndexMap.put(FIELD_CONTENT, 9);
        fieldIndexMap.put(FIELD_CONTENTPSDEFID, 10);
        fieldIndexMap.put(FIELD_CONTENTPSDEFNAME, 11);
        fieldIndexMap.put(FIELD_CONTENTPSLANRESID, 12);
        fieldIndexMap.put(FIELD_CONTENTPSLANRESNAME, 13);
        fieldIndexMap.put(FIELD_CONTENTTYPE, 14);
        fieldIndexMap.put(FIELD_CONTENTTYPEPSDEFID, 15);
        fieldIndexMap.put(FIELD_CONTENTTYPEPSDEFNAME, 16);
        fieldIndexMap.put(FIELD_CREATEDATE, 17);
        fieldIndexMap.put(FIELD_CREATEMAN, 18);
        fieldIndexMap.put(FIELD_DEFAULTFLAG, 19);
        fieldIndexMap.put(FIELD_DSLINK, 20);
        fieldIndexMap.put(FIELD_DYNAMICMODE, 21);
        fieldIndexMap.put(FIELD_ENABLECACHE, 22);
        fieldIndexMap.put(FIELD_ENABLEMODE, 23);
        fieldIndexMap.put(FIELD_ENABLEREMOVE, 24);
        fieldIndexMap.put(FIELD_GROUPPSDEFID, 25);
        fieldIndexMap.put(FIELD_GROUPPSDEFNAME, 26);
        fieldIndexMap.put(FIELD_ICONPSDEFID, 27);
        fieldIndexMap.put(FIELD_ICONPSDEFNAME, 28);
        fieldIndexMap.put(FIELD_LOCKFLAG, 29);
        fieldIndexMap.put(FIELD_MEMO, 30);
        fieldIndexMap.put(FIELD_MSGGROUP, 31);
        fieldIndexMap.put(FIELD_MSGPOS, 32);
        fieldIndexMap.put(FIELD_MSGPOSPSDEFID, 33);
        fieldIndexMap.put(FIELD_MSGPOSPSDEFNAME, 34);
        fieldIndexMap.put(FIELD_MSGTYPE, 35);
        fieldIndexMap.put(FIELD_MSGTYPEPSDEFID, 36);
        fieldIndexMap.put(FIELD_MSGTYPEPSDEFNAME, 37);
        fieldIndexMap.put(FIELD_ORDERVALUEPSDEFID, 38);
        fieldIndexMap.put(FIELD_ORDERVALUEPSDEFNAME, 39);
        fieldIndexMap.put(FIELD_PREDEFINEDTYPE, 40);
        fieldIndexMap.put(FIELD_PSDEDSID, 41);
        fieldIndexMap.put(FIELD_PSDEDSNAME, 42);
        fieldIndexMap.put(FIELD_PSDEID, 43);
        fieldIndexMap.put(FIELD_PSDELOGICID, 44);
        fieldIndexMap.put(FIELD_PSDELOGICNAME, 45);
        fieldIndexMap.put(FIELD_PSDENAME, 46);
        fieldIndexMap.put(FIELD_PSDEOPPRIVID, 47);
        fieldIndexMap.put(FIELD_PSDEOPPRIVNAME, 48);
        fieldIndexMap.put(FIELD_PSMODULEID, 49);
        fieldIndexMap.put(FIELD_PSMODULENAME, 50);
        fieldIndexMap.put(FIELD_PSSYSCSSID, 51);
        fieldIndexMap.put(FIELD_PSSYSCSSNAME, 52);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 53);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 54);
        fieldIndexMap.put(FIELD_PSSYSIMAGEID, 55);
        fieldIndexMap.put(FIELD_PSSYSIMAGENAME, 56);
        fieldIndexMap.put(FIELD_PSSYSMSGTEMPLID, 57);
        fieldIndexMap.put(FIELD_PSSYSMSGTEMPLNAME, 58);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 59);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 60);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 61);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 62);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELID, 63);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELNAME, 64);
        fieldIndexMap.put(FIELD_PSVIEWMSGID, 65);
        fieldIndexMap.put(FIELD_PSVIEWMSGNAME, 66);
        fieldIndexMap.put(FIELD_REMOVEPSDEFID, 67);
        fieldIndexMap.put(FIELD_REMOVEPSDEFNAME, 68);
        fieldIndexMap.put(FIELD_TESTCUSTOMCODE, 69);
        fieldIndexMap.put(FIELD_TESTPSDELOGICID, 70);
        fieldIndexMap.put(FIELD_TESTPSDELOGICNAME, 71);
        fieldIndexMap.put(FIELD_TIMEOUT, 72);
        fieldIndexMap.put(FIELD_TITLE, 73);
        fieldIndexMap.put(FIELD_TITLELANRESTAGPSDEFID, 74);
        fieldIndexMap.put(FIELD_TITLELANRESTAGPSDEFNAME, 75);
        fieldIndexMap.put(FIELD_TITLEPSDEFID, 76);
        fieldIndexMap.put(FIELD_TITLEPSDEFNAME, 77);
        fieldIndexMap.put(FIELD_TITLEPSLANRESID, 78);
        fieldIndexMap.put(FIELD_TITLEPSLANRESNAME, 79);
        fieldIndexMap.put(FIELD_UPDATEDATE, 80);
        fieldIndexMap.put(FIELD_UPDATEMAN, 81);
        fieldIndexMap.put(FIELD_USERCAT, 82);
        fieldIndexMap.put(FIELD_USERTAG, 83);
        fieldIndexMap.put(FIELD_USERTAG2, 84);
        fieldIndexMap.put(FIELD_USERTAG3, 85);
        fieldIndexMap.put(FIELD_USERTAG4, 86);
        fieldIndexMap.put(FIELD_VIEWMSGPARAMS, 87);
        fieldIndexMap.put(FIELD_VEWMSGTAG, 88);
        fieldIndexMap.put(FIELD_VEWMSGTAG2, 89);
    }
}

