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
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysMsgTemplBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysMsgTemplBase.class);
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
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_CUSTOMMODE = "CUSTOMMODE";
    public static final String FIELD_DDCONTENT = "DDCONTENT";
    public static final String FIELD_DDCONTENTPSDEFID = "DDCONTENTPSDEFID";
    public static final String FIELD_DDCONTENTPSDEFNAME = "DDCONTENTPSDEFNAME";
    public static final String FIELD_DDPSLANRESID = "DDPSLANRESID";
    public static final String FIELD_DDPSLANRESNAME = "DDPSLANRESNAME";
    public static final String FIELD_IMCONTENT = "IMCONTENT";
    public static final String FIELD_IMCONTENTPSDEFID = "IMCONTENTPSDEFID";
    public static final String FIELD_IMCONTENTPSDEFNAME = "IMCONTENTPSDEFNAME";
    public static final String FIELD_IMPSLANRESID = "IMPSLANRESID";
    public static final String FIELD_IMPSLANRESNAME = "IMPSLANRESNAME";
    public static final String FIELD_LANPSDEFID = "LANPSDEFID";
    public static final String FIELD_LANPSDEFNAME = "LANPSDEFNAME";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MAILGROUPSEND = "MAILGROUPSEND";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MOBTASKURL = "MOBTASKURL";
    public static final String FIELD_MOBTASKURLPSDEFID = "MOBTASKURLPSDEFID";
    public static final String FIELD_MOBTASKURLPSDEFNAME = "MOBTASKURLPSDEFNAME";
    public static final String FIELD_MSGTEMPLPARAMS = "MSGTEMPLPARAMS";
    public static final String FIELD_MSGTEMPLTAG = "MSGTEMPLTAG";
    public static final String FIELD_MSGTEMPLTAG2 = "MSGTEMPLTAG2";
    public static final String FIELD_MSGTEMPLTYPE = "MSGTEMPLTYPE";
    public static final String FIELD_PSDEDSID = "PSDEDSID";
    public static final String FIELD_PSDEDSNAME = "PSDEDSNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSMSGTEMPLID = "PSSYSMSGTEMPLID";
    public static final String FIELD_PSSYSMSGTEMPLNAME = "PSSYSMSGTEMPLNAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_SMSCONTENT = "SMSCONTENT";
    public static final String FIELD_SMSCONTENTPSDEFID = "SMSCONTENTPSDEFID";
    public static final String FIELD_SMSCONTENTPSDEFNAME = "SMSCONTENTPSDEFNAME";
    public static final String FIELD_SMSPSLANRESID = "SMSPSLANRESID";
    public static final String FIELD_SMSPSLANRESNAME = "SMSPSLANRESNAME";
    public static final String FIELD_SUBJECT = "SUBJECT";
    public static final String FIELD_SUBJECTPSDEFID = "SUBJECTPSDEFID";
    public static final String FIELD_SUBJECTPSDEFNAME = "SUBJECTPSDEFNAME";
    public static final String FIELD_SUBPSLANRESID = "SUBPSLANRESID";
    public static final String FIELD_SUBPSLANRESNAME = "SUBPSLANRESNAME";
    public static final String FIELD_TASKURL = "TASKURL";
    public static final String FIELD_TASKURLPSDEFID = "TASKURLPSDEFID";
    public static final String FIELD_TASKURLPSDEFNAME = "TASKURLPSDEFNAME";
    public static final String FIELD_TEMPLENGINE = "TEMPLENGINE";
    public static final String FIELD_TEMPLTAGPSDEFID = "TEMPLTAGPSDEFID";
    public static final String FIELD_TEMPLTAGPSDEFNAME = "TEMPLTAGPSDEFNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USER2PSDEFID = "USER2PSDEFID";
    public static final String FIELD_USER2PSDEFNAME = "USER2PSDEFNAME";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERPSDEFID = "USERPSDEFID";
    public static final String FIELD_USERPSDEFNAME = "USERPSDEFNAME";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_WCCONTENT = "WCCONTENT";
    public static final String FIELD_WCCONTENTPSDEFID = "WCCONTENTPSDEFID";
    public static final String FIELD_WCCONTENTPSDEFNAME = "WCCONTENTPSDEFNAME";
    public static final String FIELD_WXPSLANRESID = "WXPSLANRESID";
    public static final String FIELD_WXPSLANRESNAME = "WXPSLANRESNAME";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CONTENT = 1;
    private static final int INDEX_CONTENTPSDEFID = 2;
    private static final int INDEX_CONTENTPSDEFNAME = 3;
    private static final int INDEX_CONTENTPSLANRESID = 4;
    private static final int INDEX_CONTENTPSLANRESNAME = 5;
    private static final int INDEX_CONTENTTYPE = 6;
    private static final int INDEX_CONTENTTYPEPSDEFID = 7;
    private static final int INDEX_CONTENTTYPEPSDEFNAME = 8;
    private static final int INDEX_CREATEDATE = 9;
    private static final int INDEX_CREATEMAN = 10;
    private static final int INDEX_CUSTOMCODE = 11;
    private static final int INDEX_CUSTOMMODE = 12;
    private static final int INDEX_DDCONTENT = 13;
    private static final int INDEX_DDCONTENTPSDEFID = 14;
    private static final int INDEX_DDCONTENTPSDEFNAME = 15;
    private static final int INDEX_DDPSLANRESID = 16;
    private static final int INDEX_DDPSLANRESNAME = 17;
    private static final int INDEX_IMCONTENT = 18;
    private static final int INDEX_IMCONTENTPSDEFID = 19;
    private static final int INDEX_IMCONTENTPSDEFNAME = 20;
    private static final int INDEX_IMPSLANRESID = 21;
    private static final int INDEX_IMPSLANRESNAME = 22;
    private static final int INDEX_LANPSDEFID = 23;
    private static final int INDEX_LANPSDEFNAME = 24;
    private static final int INDEX_LOCKFLAG = 25;
    private static final int INDEX_MAILGROUPSEND = 26;
    private static final int INDEX_MEMO = 27;
    private static final int INDEX_MOBTASKURL = 28;
    private static final int INDEX_MOBTASKURLPSDEFID = 29;
    private static final int INDEX_MOBTASKURLPSDEFNAME = 30;
    private static final int INDEX_MSGTEMPLPARAMS = 31;
    private static final int INDEX_MSGTEMPLTAG = 32;
    private static final int INDEX_MSGTEMPLTAG2 = 33;
    private static final int INDEX_MSGTEMPLTYPE = 34;
    private static final int INDEX_PSDEDSID = 35;
    private static final int INDEX_PSDEDSNAME = 36;
    private static final int INDEX_PSDEID = 37;
    private static final int INDEX_PSDENAME = 38;
    private static final int INDEX_PSMODULEID = 39;
    private static final int INDEX_PSMODULENAME = 40;
    private static final int INDEX_PSSYSDYNAMODELID = 41;
    private static final int INDEX_PSSYSDYNAMODELNAME = 42;
    private static final int INDEX_PSSYSMSGTEMPLID = 43;
    private static final int INDEX_PSSYSMSGTEMPLNAME = 44;
    private static final int INDEX_PSSYSSFPLUGINID = 45;
    private static final int INDEX_PSSYSSFPLUGINNAME = 46;
    private static final int INDEX_PSSYSTEMID = 47;
    private static final int INDEX_PSSYSTEMNAME = 48;
    private static final int INDEX_SMSCONTENT = 49;
    private static final int INDEX_SMSCONTENTPSDEFID = 50;
    private static final int INDEX_SMSCONTENTPSDEFNAME = 51;
    private static final int INDEX_SMSPSLANRESID = 52;
    private static final int INDEX_SMSPSLANRESNAME = 53;
    private static final int INDEX_SUBJECT = 54;
    private static final int INDEX_SUBJECTPSDEFID = 55;
    private static final int INDEX_SUBJECTPSDEFNAME = 56;
    private static final int INDEX_SUBPSLANRESID = 57;
    private static final int INDEX_SUBPSLANRESNAME = 58;
    private static final int INDEX_TASKURL = 59;
    private static final int INDEX_TASKURLPSDEFID = 60;
    private static final int INDEX_TASKURLPSDEFNAME = 61;
    private static final int INDEX_TEMPLENGINE = 62;
    private static final int INDEX_TEMPLTAGPSDEFID = 63;
    private static final int INDEX_TEMPLTAGPSDEFNAME = 64;
    private static final int INDEX_UPDATEDATE = 65;
    private static final int INDEX_UPDATEMAN = 66;
    private static final int INDEX_USER2PSDEFID = 67;
    private static final int INDEX_USER2PSDEFNAME = 68;
    private static final int INDEX_USERCAT = 69;
    private static final int INDEX_USERPSDEFID = 70;
    private static final int INDEX_USERPSDEFNAME = 71;
    private static final int INDEX_USERTAG = 72;
    private static final int INDEX_USERTAG2 = 73;
    private static final int INDEX_USERTAG3 = 74;
    private static final int INDEX_USERTAG4 = 75;
    private static final int INDEX_WCCONTENT = 76;
    private static final int INDEX_WCCONTENTPSDEFID = 77;
    private static final int INDEX_WCCONTENTPSDEFNAME = 78;
    private static final int INDEX_WXPSLANRESID = 79;
    private static final int INDEX_WXPSLANRESNAME = 80;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysMsgTemplBase proxyPSSysMsgTemplBase = null;
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
    private boolean customcodeDirtyFlag = false;
    private boolean custommodeDirtyFlag = false;
    private boolean ddcontentDirtyFlag = false;
    private boolean ddcontentpsdefidDirtyFlag = false;
    private boolean ddcontentpsdefnameDirtyFlag = false;
    private boolean ddpslanresidDirtyFlag = false;
    private boolean ddpslanresnameDirtyFlag = false;
    private boolean imcontentDirtyFlag = false;
    private boolean imcontentpsdefidDirtyFlag = false;
    private boolean imcontentpsdefnameDirtyFlag = false;
    private boolean impslanresidDirtyFlag = false;
    private boolean impslanresnameDirtyFlag = false;
    private boolean lanpsdefidDirtyFlag = false;
    private boolean lanpsdefnameDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean mailgroupsendDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean mobtaskurlDirtyFlag = false;
    private boolean mobtaskurlpsdefidDirtyFlag = false;
    private boolean mobtaskurlpsdefnameDirtyFlag = false;
    private boolean msgtemplparamsDirtyFlag = false;
    private boolean msgtempltagDirtyFlag = false;
    private boolean msgtempltag2DirtyFlag = false;
    private boolean msgtempltypeDirtyFlag = false;
    private boolean psdedsidDirtyFlag = false;
    private boolean psdedsnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssysmsgtemplidDirtyFlag = false;
    private boolean pssysmsgtemplnameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean smscontentDirtyFlag = false;
    private boolean smscontentpsdefidDirtyFlag = false;
    private boolean smscontentpsdefnameDirtyFlag = false;
    private boolean smspslanresidDirtyFlag = false;
    private boolean smspslanresnameDirtyFlag = false;
    private boolean subjectDirtyFlag = false;
    private boolean subjectpsdefidDirtyFlag = false;
    private boolean subjectpsdefnameDirtyFlag = false;
    private boolean subpslanresidDirtyFlag = false;
    private boolean subpslanresnameDirtyFlag = false;
    private boolean taskurlDirtyFlag = false;
    private boolean taskurlpsdefidDirtyFlag = false;
    private boolean taskurlpsdefnameDirtyFlag = false;
    private boolean templengineDirtyFlag = false;
    private boolean templtagpsdefidDirtyFlag = false;
    private boolean templtagpsdefnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean user2psdefidDirtyFlag = false;
    private boolean user2psdefnameDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean userpsdefidDirtyFlag = false;
    private boolean userpsdefnameDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean wccontentDirtyFlag = false;
    private boolean wccontentpsdefidDirtyFlag = false;
    private boolean wccontentpsdefnameDirtyFlag = false;
    private boolean wxpslanresidDirtyFlag = false;
    private boolean wxpslanresnameDirtyFlag = false;
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
    @Column(name="customcode")
    private String customcode;
    @Column(name="custommode")
    private Integer custommode;
    @Column(name="ddcontent")
    private String ddcontent;
    @Column(name="ddcontentpsdefid")
    private String ddcontentpsdefid;
    @Column(name="ddcontentpsdefname")
    private String ddcontentpsdefname;
    @Column(name="ddpslanresid")
    private String ddpslanresid;
    @Column(name="ddpslanresname")
    private String ddpslanresname;
    @Column(name="imcontent")
    private String imcontent;
    @Column(name="imcontentpsdefid")
    private String imcontentpsdefid;
    @Column(name="imcontentpsdefname")
    private String imcontentpsdefname;
    @Column(name="impslanresid")
    private String impslanresid;
    @Column(name="impslanresname")
    private String impslanresname;
    @Column(name="lanpsdefid")
    private String lanpsdefid;
    @Column(name="lanpsdefname")
    private String lanpsdefname;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="mailgroupsend")
    private Integer mailgroupsend;
    @Column(name="memo")
    private String memo;
    @Column(name="mobtaskurl")
    private String mobtaskurl;
    @Column(name="mobtaskurlpsdefid")
    private String mobtaskurlpsdefid;
    @Column(name="mobtaskurlpsdefname")
    private String mobtaskurlpsdefname;
    @Column(name="msgtemplparams")
    private String msgtemplparams;
    @Column(name="msgtempltag")
    private String msgtempltag;
    @Column(name="msgtempltag2")
    private String msgtempltag2;
    @Column(name="msgtempltype")
    private String msgtempltype;
    @Column(name="psdedsid")
    private String psdedsid;
    @Column(name="psdedsname")
    private String psdedsname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
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
    @Column(name="smscontent")
    private String smscontent;
    @Column(name="smscontentpsdefid")
    private String smscontentpsdefid;
    @Column(name="smscontentpsdefname")
    private String smscontentpsdefname;
    @Column(name="smspslanresid")
    private String smspslanresid;
    @Column(name="smspslanresname")
    private String smspslanresname;
    @Column(name="subject")
    private String subject;
    @Column(name="subjectpsdefid")
    private String subjectpsdefid;
    @Column(name="subjectpsdefname")
    private String subjectpsdefname;
    @Column(name="subpslanresid")
    private String subpslanresid;
    @Column(name="subpslanresname")
    private String subpslanresname;
    @Column(name="taskurl")
    private String taskurl;
    @Column(name="taskurlpsdefid")
    private String taskurlpsdefid;
    @Column(name="taskurlpsdefname")
    private String taskurlpsdefname;
    @Column(name="templengine")
    private String templengine;
    @Column(name="templtagpsdefid")
    private String templtagpsdefid;
    @Column(name="templtagpsdefname")
    private String templtagpsdefname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="user2psdefid")
    private String user2psdefid;
    @Column(name="user2psdefname")
    private String user2psdefname;
    @Column(name="usercat")
    private String usercat;
    @Column(name="userpsdefid")
    private String userpsdefid;
    @Column(name="userpsdefname")
    private String userpsdefname;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    @Column(name="wccontent")
    private String wccontent;
    @Column(name="wccontentpsdefid")
    private String wccontentpsdefid;
    @Column(name="wccontentpsdefname")
    private String wccontentpsdefname;
    @Column(name="wxpslanresid")
    private String wxpslanresid;
    @Column(name="wxpslanresname")
    private String wxpslanresname;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSDEDSLock = new Integer(1);
    private PSDEDataSet psdeds = null;
    private Integer objContentPSDEFLock = new Integer(1);
    private PSDEField contentpsdef = null;
    private Integer objContentTypePSDEFLock = new Integer(1);
    private PSDEField contenttypepsdef = null;
    private Integer objDDContentPSDEFLock = new Integer(1);
    private PSDEField ddcontentpsdef = null;
    private Integer objIMContentPSDEFLock = new Integer(1);
    private PSDEField imcontentpsdef = null;
    private Integer objLanPSDEFLock = new Integer(1);
    private PSDEField lanpsdef = null;
    private Integer objMobTaskUrlPSDEFLock = new Integer(1);
    private PSDEField mobtaskurlpsdef = null;
    private Integer objSMSContentPSDEFLock = new Integer(1);
    private PSDEField smscontentpsdef = null;
    private Integer objSubjectPSDEFLock = new Integer(1);
    private PSDEField subjectpsdef = null;
    private Integer objTaskUrlPSDEFLock = new Integer(1);
    private PSDEField taskurlpsdef = null;
    private Integer objTemplTagPSDEFLock = new Integer(1);
    private PSDEField templtagpsdef = null;
    private Integer objUser2PSDEFLock = new Integer(1);
    private PSDEField user2psdef = null;
    private Integer objUserPSDEFLock = new Integer(1);
    private PSDEField userpsdef = null;
    private Integer objWCContentPSDEFLock = new Integer(1);
    private PSDEField wccontentpsdef = null;
    private Integer objContentPSLanResLock = new Integer(1);
    private PSLanguageRes contentpslanres = null;
    private Integer objDDPSLanResLock = new Integer(1);
    private PSLanguageRes ddpslanres = null;
    private Integer objIMPSLanResLock = new Integer(1);
    private PSLanguageRes impslanres = null;
    private Integer objSMSPSLanResLock = new Integer(1);
    private PSLanguageRes smspslanres = null;
    private Integer objSubPSLanResLock = new Integer(1);
    private PSLanguageRes subpslanres = null;
    private Integer objWXPSLanResLock = new Integer(1);
    private PSLanguageRes wxpslanres = null;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;

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

    public void setCustomCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customcode = string;
        this.customcodeDirtyFlag = true;
    }

    public String getCustomCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomCode();
        }
        return this.customcode;
    }

    public boolean isCustomCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomCodeDirty();
        }
        return this.customcodeDirtyFlag;
    }

    public void resetCustomCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomCode();
            return;
        }
        this.customcodeDirtyFlag = false;
        this.customcode = null;
    }

    public void setCustomMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomMode(n);
            return;
        }
        this.custommode = n;
        this.custommodeDirtyFlag = true;
    }

    public Integer getCustomMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomMode();
        }
        return this.custommode;
    }

    public boolean isCustomModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomModeDirty();
        }
        return this.custommodeDirtyFlag;
    }

    public void resetCustomMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomMode();
            return;
        }
        this.custommodeDirtyFlag = false;
        this.custommode = null;
    }

    public void setDDContent(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDDContent(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ddcontent = string;
        this.ddcontentDirtyFlag = true;
    }

    public String getDDContent() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDDContent();
        }
        return this.ddcontent;
    }

    public boolean isDDContentDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDDContentDirty();
        }
        return this.ddcontentDirtyFlag;
    }

    public void resetDDContent() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDDContent();
            return;
        }
        this.ddcontentDirtyFlag = false;
        this.ddcontent = null;
    }

    public void setDDContentPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDDContentPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ddcontentpsdefid = string;
        this.ddcontentpsdefidDirtyFlag = true;
    }

    public String getDDContentPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDDContentPSDEFId();
        }
        return this.ddcontentpsdefid;
    }

    public boolean isDDContentPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDDContentPSDEFIdDirty();
        }
        return this.ddcontentpsdefidDirtyFlag;
    }

    public void resetDDContentPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDDContentPSDEFId();
            return;
        }
        this.ddcontentpsdefidDirtyFlag = false;
        this.ddcontentpsdefid = null;
    }

    public void setDDContentPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDDContentPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ddcontentpsdefname = string;
        this.ddcontentpsdefnameDirtyFlag = true;
    }

    public String getDDContentPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDDContentPSDEFName();
        }
        return this.ddcontentpsdefname;
    }

    public boolean isDDContentPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDDContentPSDEFNameDirty();
        }
        return this.ddcontentpsdefnameDirtyFlag;
    }

    public void resetDDContentPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDDContentPSDEFName();
            return;
        }
        this.ddcontentpsdefnameDirtyFlag = false;
        this.ddcontentpsdefname = null;
    }

    public void setDDPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDDPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ddpslanresid = string;
        this.ddpslanresidDirtyFlag = true;
    }

    public String getDDPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDDPSLanResId();
        }
        return this.ddpslanresid;
    }

    public boolean isDDPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDDPSLanResIdDirty();
        }
        return this.ddpslanresidDirtyFlag;
    }

    public void resetDDPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDDPSLanResId();
            return;
        }
        this.ddpslanresidDirtyFlag = false;
        this.ddpslanresid = null;
    }

    public void setDDPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDDPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ddpslanresname = string;
        this.ddpslanresnameDirtyFlag = true;
    }

    public String getDDPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDDPSLanResName();
        }
        return this.ddpslanresname;
    }

    public boolean isDDPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDDPSLanResNameDirty();
        }
        return this.ddpslanresnameDirtyFlag;
    }

    public void resetDDPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDDPSLanResName();
            return;
        }
        this.ddpslanresnameDirtyFlag = false;
        this.ddpslanresname = null;
    }

    public void setIMContent(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIMContent(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.imcontent = string;
        this.imcontentDirtyFlag = true;
    }

    public String getIMContent() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIMContent();
        }
        return this.imcontent;
    }

    public boolean isIMContentDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIMContentDirty();
        }
        return this.imcontentDirtyFlag;
    }

    public void resetIMContent() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIMContent();
            return;
        }
        this.imcontentDirtyFlag = false;
        this.imcontent = null;
    }

    public void setIMContentPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIMContentPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.imcontentpsdefid = string;
        this.imcontentpsdefidDirtyFlag = true;
    }

    public String getIMContentPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIMContentPSDEFId();
        }
        return this.imcontentpsdefid;
    }

    public boolean isIMContentPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIMContentPSDEFIdDirty();
        }
        return this.imcontentpsdefidDirtyFlag;
    }

    public void resetIMContentPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIMContentPSDEFId();
            return;
        }
        this.imcontentpsdefidDirtyFlag = false;
        this.imcontentpsdefid = null;
    }

    public void setIMContentPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIMContentPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.imcontentpsdefname = string;
        this.imcontentpsdefnameDirtyFlag = true;
    }

    public String getIMContentPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIMContentPSDEFName();
        }
        return this.imcontentpsdefname;
    }

    public boolean isIMContentPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIMContentPSDEFNameDirty();
        }
        return this.imcontentpsdefnameDirtyFlag;
    }

    public void resetIMContentPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIMContentPSDEFName();
            return;
        }
        this.imcontentpsdefnameDirtyFlag = false;
        this.imcontentpsdefname = null;
    }

    public void setIMPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIMPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.impslanresid = string;
        this.impslanresidDirtyFlag = true;
    }

    public String getIMPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIMPSLanResId();
        }
        return this.impslanresid;
    }

    public boolean isIMPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIMPSLanResIdDirty();
        }
        return this.impslanresidDirtyFlag;
    }

    public void resetIMPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIMPSLanResId();
            return;
        }
        this.impslanresidDirtyFlag = false;
        this.impslanresid = null;
    }

    public void setIMPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIMPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.impslanresname = string;
        this.impslanresnameDirtyFlag = true;
    }

    public String getIMPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIMPSLanResName();
        }
        return this.impslanresname;
    }

    public boolean isIMPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIMPSLanResNameDirty();
        }
        return this.impslanresnameDirtyFlag;
    }

    public void resetIMPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIMPSLanResName();
            return;
        }
        this.impslanresnameDirtyFlag = false;
        this.impslanresname = null;
    }

    public void setLanPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLanPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.lanpsdefid = string;
        this.lanpsdefidDirtyFlag = true;
    }

    public String getLanPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLanPSDEFId();
        }
        return this.lanpsdefid;
    }

    public boolean isLanPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLanPSDEFIdDirty();
        }
        return this.lanpsdefidDirtyFlag;
    }

    public void resetLanPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLanPSDEFId();
            return;
        }
        this.lanpsdefidDirtyFlag = false;
        this.lanpsdefid = null;
    }

    public void setLanPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLanPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.lanpsdefname = string;
        this.lanpsdefnameDirtyFlag = true;
    }

    public String getLanPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLanPSDEFName();
        }
        return this.lanpsdefname;
    }

    public boolean isLanPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLanPSDEFNameDirty();
        }
        return this.lanpsdefnameDirtyFlag;
    }

    public void resetLanPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLanPSDEFName();
            return;
        }
        this.lanpsdefnameDirtyFlag = false;
        this.lanpsdefname = null;
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

    public void setMailGroupSend(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMailGroupSend(n);
            return;
        }
        this.mailgroupsend = n;
        this.mailgroupsendDirtyFlag = true;
    }

    public Integer getMailGroupSend() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMailGroupSend();
        }
        return this.mailgroupsend;
    }

    public boolean isMailGroupSendDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMailGroupSendDirty();
        }
        return this.mailgroupsendDirtyFlag;
    }

    public void resetMailGroupSend() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMailGroupSend();
            return;
        }
        this.mailgroupsendDirtyFlag = false;
        this.mailgroupsend = null;
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

    public void setMobTaskUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobTaskUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobtaskurl = string;
        this.mobtaskurlDirtyFlag = true;
    }

    public String getMobTaskUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobTaskUrl();
        }
        return this.mobtaskurl;
    }

    public boolean isMobTaskUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobTaskUrlDirty();
        }
        return this.mobtaskurlDirtyFlag;
    }

    public void resetMobTaskUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobTaskUrl();
            return;
        }
        this.mobtaskurlDirtyFlag = false;
        this.mobtaskurl = null;
    }

    public void setMobTaskUrlPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobTaskUrlPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobtaskurlpsdefid = string;
        this.mobtaskurlpsdefidDirtyFlag = true;
    }

    public String getMobTaskUrlPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobTaskUrlPSDEFId();
        }
        return this.mobtaskurlpsdefid;
    }

    public boolean isMobTaskUrlPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobTaskUrlPSDEFIdDirty();
        }
        return this.mobtaskurlpsdefidDirtyFlag;
    }

    public void resetMobTaskUrlPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobTaskUrlPSDEFId();
            return;
        }
        this.mobtaskurlpsdefidDirtyFlag = false;
        this.mobtaskurlpsdefid = null;
    }

    public void setMobTaskUrlPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobTaskUrlPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobtaskurlpsdefname = string;
        this.mobtaskurlpsdefnameDirtyFlag = true;
    }

    public String getMobTaskUrlPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobTaskUrlPSDEFName();
        }
        return this.mobtaskurlpsdefname;
    }

    public boolean isMobTaskUrlPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobTaskUrlPSDEFNameDirty();
        }
        return this.mobtaskurlpsdefnameDirtyFlag;
    }

    public void resetMobTaskUrlPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobTaskUrlPSDEFName();
            return;
        }
        this.mobtaskurlpsdefnameDirtyFlag = false;
        this.mobtaskurlpsdefname = null;
    }

    public void setMsgTemplParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMsgTemplParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.msgtemplparams = string;
        this.msgtemplparamsDirtyFlag = true;
    }

    public String getMsgTemplParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMsgTemplParams();
        }
        return this.msgtemplparams;
    }

    public boolean isMsgTemplParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMsgTemplParamsDirty();
        }
        return this.msgtemplparamsDirtyFlag;
    }

    public void resetMsgTemplParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMsgTemplParams();
            return;
        }
        this.msgtemplparamsDirtyFlag = false;
        this.msgtemplparams = null;
    }

    public void setMsgTemplTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMsgTemplTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.msgtempltag = string;
        this.msgtempltagDirtyFlag = true;
    }

    public String getMsgTemplTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMsgTemplTag();
        }
        return this.msgtempltag;
    }

    public boolean isMsgTemplTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMsgTemplTagDirty();
        }
        return this.msgtempltagDirtyFlag;
    }

    public void resetMsgTemplTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMsgTemplTag();
            return;
        }
        this.msgtempltagDirtyFlag = false;
        this.msgtempltag = null;
    }

    public void setMsgTemplTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMsgTemplTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.msgtempltag2 = string;
        this.msgtempltag2DirtyFlag = true;
    }

    public String getMsgTemplTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMsgTemplTag2();
        }
        return this.msgtempltag2;
    }

    public boolean isMsgTemplTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMsgTemplTag2Dirty();
        }
        return this.msgtempltag2DirtyFlag;
    }

    public void resetMsgTemplTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMsgTemplTag2();
            return;
        }
        this.msgtempltag2DirtyFlag = false;
        this.msgtempltag2 = null;
    }

    public void setMsgTemplType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMsgTemplType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.msgtempltype = string;
        this.msgtempltypeDirtyFlag = true;
    }

    public String getMsgTemplType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMsgTemplType();
        }
        return this.msgtempltype;
    }

    public boolean isMsgTemplTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMsgTemplTypeDirty();
        }
        return this.msgtempltypeDirtyFlag;
    }

    public void resetMsgTemplType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMsgTemplType();
            return;
        }
        this.msgtempltypeDirtyFlag = false;
        this.msgtempltype = null;
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

    public void setSMSContent(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSMSContent(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.smscontent = string;
        this.smscontentDirtyFlag = true;
    }

    public String getSMSContent() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSMSContent();
        }
        return this.smscontent;
    }

    public boolean isSMSContentDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSMSContentDirty();
        }
        return this.smscontentDirtyFlag;
    }

    public void resetSMSContent() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSMSContent();
            return;
        }
        this.smscontentDirtyFlag = false;
        this.smscontent = null;
    }

    public void setSMSContentPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSMSContentPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.smscontentpsdefid = string;
        this.smscontentpsdefidDirtyFlag = true;
    }

    public String getSMSContentPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSMSContentPSDEFId();
        }
        return this.smscontentpsdefid;
    }

    public boolean isSMSContentPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSMSContentPSDEFIdDirty();
        }
        return this.smscontentpsdefidDirtyFlag;
    }

    public void resetSMSContentPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSMSContentPSDEFId();
            return;
        }
        this.smscontentpsdefidDirtyFlag = false;
        this.smscontentpsdefid = null;
    }

    public void setSMSContentPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSMSContentPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.smscontentpsdefname = string;
        this.smscontentpsdefnameDirtyFlag = true;
    }

    public String getSMSContentPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSMSContentPSDEFName();
        }
        return this.smscontentpsdefname;
    }

    public boolean isSMSContentPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSMSContentPSDEFNameDirty();
        }
        return this.smscontentpsdefnameDirtyFlag;
    }

    public void resetSMSContentPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSMSContentPSDEFName();
            return;
        }
        this.smscontentpsdefnameDirtyFlag = false;
        this.smscontentpsdefname = null;
    }

    public void setSMSPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSMSPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.smspslanresid = string;
        this.smspslanresidDirtyFlag = true;
    }

    public String getSMSPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSMSPSLanResId();
        }
        return this.smspslanresid;
    }

    public boolean isSMSPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSMSPSLanResIdDirty();
        }
        return this.smspslanresidDirtyFlag;
    }

    public void resetSMSPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSMSPSLanResId();
            return;
        }
        this.smspslanresidDirtyFlag = false;
        this.smspslanresid = null;
    }

    public void setSMSPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSMSPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.smspslanresname = string;
        this.smspslanresnameDirtyFlag = true;
    }

    public String getSMSPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSMSPSLanResName();
        }
        return this.smspslanresname;
    }

    public boolean isSMSPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSMSPSLanResNameDirty();
        }
        return this.smspslanresnameDirtyFlag;
    }

    public void resetSMSPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSMSPSLanResName();
            return;
        }
        this.smspslanresnameDirtyFlag = false;
        this.smspslanresname = null;
    }

    public void setSubject(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSubject(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.subject = string;
        this.subjectDirtyFlag = true;
    }

    public String getSubject() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSubject();
        }
        return this.subject;
    }

    public boolean isSubjectDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSubjectDirty();
        }
        return this.subjectDirtyFlag;
    }

    public void resetSubject() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSubject();
            return;
        }
        this.subjectDirtyFlag = false;
        this.subject = null;
    }

    public void setSubjectPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSubjectPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.subjectpsdefid = string;
        this.subjectpsdefidDirtyFlag = true;
    }

    public String getSubjectPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSubjectPSDEFId();
        }
        return this.subjectpsdefid;
    }

    public boolean isSubjectPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSubjectPSDEFIdDirty();
        }
        return this.subjectpsdefidDirtyFlag;
    }

    public void resetSubjectPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSubjectPSDEFId();
            return;
        }
        this.subjectpsdefidDirtyFlag = false;
        this.subjectpsdefid = null;
    }

    public void setSubjectPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSubjectPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.subjectpsdefname = string;
        this.subjectpsdefnameDirtyFlag = true;
    }

    public String getSubjectPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSubjectPSDEFName();
        }
        return this.subjectpsdefname;
    }

    public boolean isSubjectPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSubjectPSDEFNameDirty();
        }
        return this.subjectpsdefnameDirtyFlag;
    }

    public void resetSubjectPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSubjectPSDEFName();
            return;
        }
        this.subjectpsdefnameDirtyFlag = false;
        this.subjectpsdefname = null;
    }

    public void setSubPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSubPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.subpslanresid = string;
        this.subpslanresidDirtyFlag = true;
    }

    public String getSubPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSubPSLanResId();
        }
        return this.subpslanresid;
    }

    public boolean isSubPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSubPSLanResIdDirty();
        }
        return this.subpslanresidDirtyFlag;
    }

    public void resetSubPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSubPSLanResId();
            return;
        }
        this.subpslanresidDirtyFlag = false;
        this.subpslanresid = null;
    }

    public void setSubPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSubPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.subpslanresname = string;
        this.subpslanresnameDirtyFlag = true;
    }

    public String getSubPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSubPSLanResName();
        }
        return this.subpslanresname;
    }

    public boolean isSubPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSubPSLanResNameDirty();
        }
        return this.subpslanresnameDirtyFlag;
    }

    public void resetSubPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSubPSLanResName();
            return;
        }
        this.subpslanresnameDirtyFlag = false;
        this.subpslanresname = null;
    }

    public void setTaskUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTaskUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.taskurl = string;
        this.taskurlDirtyFlag = true;
    }

    public String getTaskUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTaskUrl();
        }
        return this.taskurl;
    }

    public boolean isTaskUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTaskUrlDirty();
        }
        return this.taskurlDirtyFlag;
    }

    public void resetTaskUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTaskUrl();
            return;
        }
        this.taskurlDirtyFlag = false;
        this.taskurl = null;
    }

    public void setTaskUrlPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTaskUrlPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.taskurlpsdefid = string;
        this.taskurlpsdefidDirtyFlag = true;
    }

    public String getTaskUrlPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTaskUrlPSDEFId();
        }
        return this.taskurlpsdefid;
    }

    public boolean isTaskUrlPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTaskUrlPSDEFIdDirty();
        }
        return this.taskurlpsdefidDirtyFlag;
    }

    public void resetTaskUrlPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTaskUrlPSDEFId();
            return;
        }
        this.taskurlpsdefidDirtyFlag = false;
        this.taskurlpsdefid = null;
    }

    public void setTaskUrlPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTaskUrlPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.taskurlpsdefname = string;
        this.taskurlpsdefnameDirtyFlag = true;
    }

    public String getTaskUrlPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTaskUrlPSDEFName();
        }
        return this.taskurlpsdefname;
    }

    public boolean isTaskUrlPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTaskUrlPSDEFNameDirty();
        }
        return this.taskurlpsdefnameDirtyFlag;
    }

    public void resetTaskUrlPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTaskUrlPSDEFName();
            return;
        }
        this.taskurlpsdefnameDirtyFlag = false;
        this.taskurlpsdefname = null;
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

    public void setTemplTagPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplTagPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templtagpsdefid = string;
        this.templtagpsdefidDirtyFlag = true;
    }

    public String getTemplTagPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplTagPSDEFId();
        }
        return this.templtagpsdefid;
    }

    public boolean isTemplTagPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplTagPSDEFIdDirty();
        }
        return this.templtagpsdefidDirtyFlag;
    }

    public void resetTemplTagPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplTagPSDEFId();
            return;
        }
        this.templtagpsdefidDirtyFlag = false;
        this.templtagpsdefid = null;
    }

    public void setTemplTagPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplTagPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templtagpsdefname = string;
        this.templtagpsdefnameDirtyFlag = true;
    }

    public String getTemplTagPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplTagPSDEFName();
        }
        return this.templtagpsdefname;
    }

    public boolean isTemplTagPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplTagPSDEFNameDirty();
        }
        return this.templtagpsdefnameDirtyFlag;
    }

    public void resetTemplTagPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplTagPSDEFName();
            return;
        }
        this.templtagpsdefnameDirtyFlag = false;
        this.templtagpsdefname = null;
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

    public void setUser2PSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUser2PSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.user2psdefid = string;
        this.user2psdefidDirtyFlag = true;
    }

    public String getUser2PSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUser2PSDEFId();
        }
        return this.user2psdefid;
    }

    public boolean isUser2PSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUser2PSDEFIdDirty();
        }
        return this.user2psdefidDirtyFlag;
    }

    public void resetUser2PSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUser2PSDEFId();
            return;
        }
        this.user2psdefidDirtyFlag = false;
        this.user2psdefid = null;
    }

    public void setUser2PSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUser2PSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.user2psdefname = string;
        this.user2psdefnameDirtyFlag = true;
    }

    public String getUser2PSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUser2PSDEFName();
        }
        return this.user2psdefname;
    }

    public boolean isUser2PSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUser2PSDEFNameDirty();
        }
        return this.user2psdefnameDirtyFlag;
    }

    public void resetUser2PSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUser2PSDEFName();
            return;
        }
        this.user2psdefnameDirtyFlag = false;
        this.user2psdefname = null;
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

    public void setUserPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userpsdefid = string;
        this.userpsdefidDirtyFlag = true;
    }

    public String getUserPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserPSDEFId();
        }
        return this.userpsdefid;
    }

    public boolean isUserPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserPSDEFIdDirty();
        }
        return this.userpsdefidDirtyFlag;
    }

    public void resetUserPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserPSDEFId();
            return;
        }
        this.userpsdefidDirtyFlag = false;
        this.userpsdefid = null;
    }

    public void setUserPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userpsdefname = string;
        this.userpsdefnameDirtyFlag = true;
    }

    public String getUserPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserPSDEFName();
        }
        return this.userpsdefname;
    }

    public boolean isUserPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserPSDEFNameDirty();
        }
        return this.userpsdefnameDirtyFlag;
    }

    public void resetUserPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserPSDEFName();
            return;
        }
        this.userpsdefnameDirtyFlag = false;
        this.userpsdefname = null;
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

    public void setWCContent(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWCContent(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wccontent = string;
        this.wccontentDirtyFlag = true;
    }

    public String getWCContent() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWCContent();
        }
        return this.wccontent;
    }

    public boolean isWCContentDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWCContentDirty();
        }
        return this.wccontentDirtyFlag;
    }

    public void resetWCContent() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWCContent();
            return;
        }
        this.wccontentDirtyFlag = false;
        this.wccontent = null;
    }

    public void setWCContentPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWCContentPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wccontentpsdefid = string;
        this.wccontentpsdefidDirtyFlag = true;
    }

    public String getWCContentPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWCContentPSDEFId();
        }
        return this.wccontentpsdefid;
    }

    public boolean isWCContentPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWCContentPSDEFIdDirty();
        }
        return this.wccontentpsdefidDirtyFlag;
    }

    public void resetWCContentPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWCContentPSDEFId();
            return;
        }
        this.wccontentpsdefidDirtyFlag = false;
        this.wccontentpsdefid = null;
    }

    public void setWCContentPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWCContentPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wccontentpsdefname = string;
        this.wccontentpsdefnameDirtyFlag = true;
    }

    public String getWCContentPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWCContentPSDEFName();
        }
        return this.wccontentpsdefname;
    }

    public boolean isWCContentPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWCContentPSDEFNameDirty();
        }
        return this.wccontentpsdefnameDirtyFlag;
    }

    public void resetWCContentPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWCContentPSDEFName();
            return;
        }
        this.wccontentpsdefnameDirtyFlag = false;
        this.wccontentpsdefname = null;
    }

    public void setWXPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWXPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wxpslanresid = string;
        this.wxpslanresidDirtyFlag = true;
    }

    public String getWXPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWXPSLanResId();
        }
        return this.wxpslanresid;
    }

    public boolean isWXPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWXPSLanResIdDirty();
        }
        return this.wxpslanresidDirtyFlag;
    }

    public void resetWXPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWXPSLanResId();
            return;
        }
        this.wxpslanresidDirtyFlag = false;
        this.wxpslanresid = null;
    }

    public void setWXPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWXPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wxpslanresname = string;
        this.wxpslanresnameDirtyFlag = true;
    }

    public String getWXPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWXPSLanResName();
        }
        return this.wxpslanresname;
    }

    public boolean isWXPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWXPSLanResNameDirty();
        }
        return this.wxpslanresnameDirtyFlag;
    }

    public void resetWXPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWXPSLanResName();
            return;
        }
        this.wxpslanresnameDirtyFlag = false;
        this.wxpslanresname = null;
    }

    protected void onReset() {
        PSSysMsgTemplBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysMsgTemplBase pSSysMsgTemplBase) {
        pSSysMsgTemplBase.resetCodeName();
        pSSysMsgTemplBase.resetContent();
        pSSysMsgTemplBase.resetContentPSDEFId();
        pSSysMsgTemplBase.resetContentPSDEFName();
        pSSysMsgTemplBase.resetContentPSLanResId();
        pSSysMsgTemplBase.resetContentPSLanResName();
        pSSysMsgTemplBase.resetContentType();
        pSSysMsgTemplBase.resetContentTypePSDEFId();
        pSSysMsgTemplBase.resetContentTypePSDEFName();
        pSSysMsgTemplBase.resetCreateDate();
        pSSysMsgTemplBase.resetCreateMan();
        pSSysMsgTemplBase.resetCustomCode();
        pSSysMsgTemplBase.resetCustomMode();
        pSSysMsgTemplBase.resetDDContent();
        pSSysMsgTemplBase.resetDDContentPSDEFId();
        pSSysMsgTemplBase.resetDDContentPSDEFName();
        pSSysMsgTemplBase.resetDDPSLanResId();
        pSSysMsgTemplBase.resetDDPSLanResName();
        pSSysMsgTemplBase.resetIMContent();
        pSSysMsgTemplBase.resetIMContentPSDEFId();
        pSSysMsgTemplBase.resetIMContentPSDEFName();
        pSSysMsgTemplBase.resetIMPSLanResId();
        pSSysMsgTemplBase.resetIMPSLanResName();
        pSSysMsgTemplBase.resetLanPSDEFId();
        pSSysMsgTemplBase.resetLanPSDEFName();
        pSSysMsgTemplBase.resetLockFlag();
        pSSysMsgTemplBase.resetMailGroupSend();
        pSSysMsgTemplBase.resetMemo();
        pSSysMsgTemplBase.resetMobTaskUrl();
        pSSysMsgTemplBase.resetMobTaskUrlPSDEFId();
        pSSysMsgTemplBase.resetMobTaskUrlPSDEFName();
        pSSysMsgTemplBase.resetMsgTemplParams();
        pSSysMsgTemplBase.resetMsgTemplTag();
        pSSysMsgTemplBase.resetMsgTemplTag2();
        pSSysMsgTemplBase.resetMsgTemplType();
        pSSysMsgTemplBase.resetPSDEDSId();
        pSSysMsgTemplBase.resetPSDEDSName();
        pSSysMsgTemplBase.resetPSDEId();
        pSSysMsgTemplBase.resetPSDEName();
        pSSysMsgTemplBase.resetPSModuleId();
        pSSysMsgTemplBase.resetPSModuleName();
        pSSysMsgTemplBase.resetPSSysDynaModelId();
        pSSysMsgTemplBase.resetPSSysDynaModelName();
        pSSysMsgTemplBase.resetPSSysMsgTemplId();
        pSSysMsgTemplBase.resetPSSysMsgTemplName();
        pSSysMsgTemplBase.resetPSSysSFPluginId();
        pSSysMsgTemplBase.resetPSSysSFPluginName();
        pSSysMsgTemplBase.resetPSSystemId();
        pSSysMsgTemplBase.resetPSSystemName();
        pSSysMsgTemplBase.resetSMSContent();
        pSSysMsgTemplBase.resetSMSContentPSDEFId();
        pSSysMsgTemplBase.resetSMSContentPSDEFName();
        pSSysMsgTemplBase.resetSMSPSLanResId();
        pSSysMsgTemplBase.resetSMSPSLanResName();
        pSSysMsgTemplBase.resetSubject();
        pSSysMsgTemplBase.resetSubjectPSDEFId();
        pSSysMsgTemplBase.resetSubjectPSDEFName();
        pSSysMsgTemplBase.resetSubPSLanResId();
        pSSysMsgTemplBase.resetSubPSLanResName();
        pSSysMsgTemplBase.resetTaskUrl();
        pSSysMsgTemplBase.resetTaskUrlPSDEFId();
        pSSysMsgTemplBase.resetTaskUrlPSDEFName();
        pSSysMsgTemplBase.resetTemplEngine();
        pSSysMsgTemplBase.resetTemplTagPSDEFId();
        pSSysMsgTemplBase.resetTemplTagPSDEFName();
        pSSysMsgTemplBase.resetUpdateDate();
        pSSysMsgTemplBase.resetUpdateMan();
        pSSysMsgTemplBase.resetUser2PSDEFId();
        pSSysMsgTemplBase.resetUser2PSDEFName();
        pSSysMsgTemplBase.resetUserCat();
        pSSysMsgTemplBase.resetUserPSDEFId();
        pSSysMsgTemplBase.resetUserPSDEFName();
        pSSysMsgTemplBase.resetUserTag();
        pSSysMsgTemplBase.resetUserTag2();
        pSSysMsgTemplBase.resetUserTag3();
        pSSysMsgTemplBase.resetUserTag4();
        pSSysMsgTemplBase.resetWCContent();
        pSSysMsgTemplBase.resetWCContentPSDEFId();
        pSSysMsgTemplBase.resetWCContentPSDEFName();
        pSSysMsgTemplBase.resetWXPSLanResId();
        pSSysMsgTemplBase.resetWXPSLanResName();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
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
        if (!bl || this.isCustomCodeDirty()) {
            hashMap.put(FIELD_CUSTOMCODE, this.getCustomCode());
        }
        if (!bl || this.isCustomModeDirty()) {
            hashMap.put(FIELD_CUSTOMMODE, this.getCustomMode());
        }
        if (!bl || this.isDDContentDirty()) {
            hashMap.put(FIELD_DDCONTENT, this.getDDContent());
        }
        if (!bl || this.isDDContentPSDEFIdDirty()) {
            hashMap.put(FIELD_DDCONTENTPSDEFID, this.getDDContentPSDEFId());
        }
        if (!bl || this.isDDContentPSDEFNameDirty()) {
            hashMap.put(FIELD_DDCONTENTPSDEFNAME, this.getDDContentPSDEFName());
        }
        if (!bl || this.isDDPSLanResIdDirty()) {
            hashMap.put(FIELD_DDPSLANRESID, this.getDDPSLanResId());
        }
        if (!bl || this.isDDPSLanResNameDirty()) {
            hashMap.put(FIELD_DDPSLANRESNAME, this.getDDPSLanResName());
        }
        if (!bl || this.isIMContentDirty()) {
            hashMap.put(FIELD_IMCONTENT, this.getIMContent());
        }
        if (!bl || this.isIMContentPSDEFIdDirty()) {
            hashMap.put(FIELD_IMCONTENTPSDEFID, this.getIMContentPSDEFId());
        }
        if (!bl || this.isIMContentPSDEFNameDirty()) {
            hashMap.put(FIELD_IMCONTENTPSDEFNAME, this.getIMContentPSDEFName());
        }
        if (!bl || this.isIMPSLanResIdDirty()) {
            hashMap.put(FIELD_IMPSLANRESID, this.getIMPSLanResId());
        }
        if (!bl || this.isIMPSLanResNameDirty()) {
            hashMap.put(FIELD_IMPSLANRESNAME, this.getIMPSLanResName());
        }
        if (!bl || this.isLanPSDEFIdDirty()) {
            hashMap.put(FIELD_LANPSDEFID, this.getLanPSDEFId());
        }
        if (!bl || this.isLanPSDEFNameDirty()) {
            hashMap.put(FIELD_LANPSDEFNAME, this.getLanPSDEFName());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMailGroupSendDirty()) {
            hashMap.put(FIELD_MAILGROUPSEND, this.getMailGroupSend());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMobTaskUrlDirty()) {
            hashMap.put(FIELD_MOBTASKURL, this.getMobTaskUrl());
        }
        if (!bl || this.isMobTaskUrlPSDEFIdDirty()) {
            hashMap.put(FIELD_MOBTASKURLPSDEFID, this.getMobTaskUrlPSDEFId());
        }
        if (!bl || this.isMobTaskUrlPSDEFNameDirty()) {
            hashMap.put(FIELD_MOBTASKURLPSDEFNAME, this.getMobTaskUrlPSDEFName());
        }
        if (!bl || this.isMsgTemplParamsDirty()) {
            hashMap.put(FIELD_MSGTEMPLPARAMS, this.getMsgTemplParams());
        }
        if (!bl || this.isMsgTemplTagDirty()) {
            hashMap.put(FIELD_MSGTEMPLTAG, this.getMsgTemplTag());
        }
        if (!bl || this.isMsgTemplTag2Dirty()) {
            hashMap.put(FIELD_MSGTEMPLTAG2, this.getMsgTemplTag2());
        }
        if (!bl || this.isMsgTemplTypeDirty()) {
            hashMap.put(FIELD_MSGTEMPLTYPE, this.getMsgTemplType());
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
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
        }
        if (!bl || this.isPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELID, this.getPSSysDynaModelId());
        }
        if (!bl || this.isPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELNAME, this.getPSSysDynaModelName());
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
        if (!bl || this.isSMSContentDirty()) {
            hashMap.put(FIELD_SMSCONTENT, this.getSMSContent());
        }
        if (!bl || this.isSMSContentPSDEFIdDirty()) {
            hashMap.put(FIELD_SMSCONTENTPSDEFID, this.getSMSContentPSDEFId());
        }
        if (!bl || this.isSMSContentPSDEFNameDirty()) {
            hashMap.put(FIELD_SMSCONTENTPSDEFNAME, this.getSMSContentPSDEFName());
        }
        if (!bl || this.isSMSPSLanResIdDirty()) {
            hashMap.put(FIELD_SMSPSLANRESID, this.getSMSPSLanResId());
        }
        if (!bl || this.isSMSPSLanResNameDirty()) {
            hashMap.put(FIELD_SMSPSLANRESNAME, this.getSMSPSLanResName());
        }
        if (!bl || this.isSubjectDirty()) {
            hashMap.put(FIELD_SUBJECT, this.getSubject());
        }
        if (!bl || this.isSubjectPSDEFIdDirty()) {
            hashMap.put(FIELD_SUBJECTPSDEFID, this.getSubjectPSDEFId());
        }
        if (!bl || this.isSubjectPSDEFNameDirty()) {
            hashMap.put(FIELD_SUBJECTPSDEFNAME, this.getSubjectPSDEFName());
        }
        if (!bl || this.isSubPSLanResIdDirty()) {
            hashMap.put(FIELD_SUBPSLANRESID, this.getSubPSLanResId());
        }
        if (!bl || this.isSubPSLanResNameDirty()) {
            hashMap.put(FIELD_SUBPSLANRESNAME, this.getSubPSLanResName());
        }
        if (!bl || this.isTaskUrlDirty()) {
            hashMap.put(FIELD_TASKURL, this.getTaskUrl());
        }
        if (!bl || this.isTaskUrlPSDEFIdDirty()) {
            hashMap.put(FIELD_TASKURLPSDEFID, this.getTaskUrlPSDEFId());
        }
        if (!bl || this.isTaskUrlPSDEFNameDirty()) {
            hashMap.put(FIELD_TASKURLPSDEFNAME, this.getTaskUrlPSDEFName());
        }
        if (!bl || this.isTemplEngineDirty()) {
            hashMap.put(FIELD_TEMPLENGINE, this.getTemplEngine());
        }
        if (!bl || this.isTemplTagPSDEFIdDirty()) {
            hashMap.put(FIELD_TEMPLTAGPSDEFID, this.getTemplTagPSDEFId());
        }
        if (!bl || this.isTemplTagPSDEFNameDirty()) {
            hashMap.put(FIELD_TEMPLTAGPSDEFNAME, this.getTemplTagPSDEFName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUser2PSDEFIdDirty()) {
            hashMap.put(FIELD_USER2PSDEFID, this.getUser2PSDEFId());
        }
        if (!bl || this.isUser2PSDEFNameDirty()) {
            hashMap.put(FIELD_USER2PSDEFNAME, this.getUser2PSDEFName());
        }
        if (!bl || this.isUserCatDirty()) {
            hashMap.put(FIELD_USERCAT, this.getUserCat());
        }
        if (!bl || this.isUserPSDEFIdDirty()) {
            hashMap.put(FIELD_USERPSDEFID, this.getUserPSDEFId());
        }
        if (!bl || this.isUserPSDEFNameDirty()) {
            hashMap.put(FIELD_USERPSDEFNAME, this.getUserPSDEFName());
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
        if (!bl || this.isWCContentDirty()) {
            hashMap.put(FIELD_WCCONTENT, this.getWCContent());
        }
        if (!bl || this.isWCContentPSDEFIdDirty()) {
            hashMap.put(FIELD_WCCONTENTPSDEFID, this.getWCContentPSDEFId());
        }
        if (!bl || this.isWCContentPSDEFNameDirty()) {
            hashMap.put(FIELD_WCCONTENTPSDEFNAME, this.getWCContentPSDEFName());
        }
        if (!bl || this.isWXPSLanResIdDirty()) {
            hashMap.put(FIELD_WXPSLANRESID, this.getWXPSLanResId());
        }
        if (!bl || this.isWXPSLanResNameDirty()) {
            hashMap.put(FIELD_WXPSLANRESNAME, this.getWXPSLanResName());
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
        return PSSysMsgTemplBase.get(this, n);
    }

    private static Object get(PSSysMsgTemplBase pSSysMsgTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysMsgTemplBase.getCodeName();
            }
            case 1: {
                return pSSysMsgTemplBase.getContent();
            }
            case 2: {
                return pSSysMsgTemplBase.getContentPSDEFId();
            }
            case 3: {
                return pSSysMsgTemplBase.getContentPSDEFName();
            }
            case 4: {
                return pSSysMsgTemplBase.getContentPSLanResId();
            }
            case 5: {
                return pSSysMsgTemplBase.getContentPSLanResName();
            }
            case 6: {
                return pSSysMsgTemplBase.getContentType();
            }
            case 7: {
                return pSSysMsgTemplBase.getContentTypePSDEFId();
            }
            case 8: {
                return pSSysMsgTemplBase.getContentTypePSDEFName();
            }
            case 9: {
                return pSSysMsgTemplBase.getCreateDate();
            }
            case 10: {
                return pSSysMsgTemplBase.getCreateMan();
            }
            case 11: {
                return pSSysMsgTemplBase.getCustomCode();
            }
            case 12: {
                return pSSysMsgTemplBase.getCustomMode();
            }
            case 13: {
                return pSSysMsgTemplBase.getDDContent();
            }
            case 14: {
                return pSSysMsgTemplBase.getDDContentPSDEFId();
            }
            case 15: {
                return pSSysMsgTemplBase.getDDContentPSDEFName();
            }
            case 16: {
                return pSSysMsgTemplBase.getDDPSLanResId();
            }
            case 17: {
                return pSSysMsgTemplBase.getDDPSLanResName();
            }
            case 18: {
                return pSSysMsgTemplBase.getIMContent();
            }
            case 19: {
                return pSSysMsgTemplBase.getIMContentPSDEFId();
            }
            case 20: {
                return pSSysMsgTemplBase.getIMContentPSDEFName();
            }
            case 21: {
                return pSSysMsgTemplBase.getIMPSLanResId();
            }
            case 22: {
                return pSSysMsgTemplBase.getIMPSLanResName();
            }
            case 23: {
                return pSSysMsgTemplBase.getLanPSDEFId();
            }
            case 24: {
                return pSSysMsgTemplBase.getLanPSDEFName();
            }
            case 25: {
                return pSSysMsgTemplBase.getLockFlag();
            }
            case 26: {
                return pSSysMsgTemplBase.getMailGroupSend();
            }
            case 27: {
                return pSSysMsgTemplBase.getMemo();
            }
            case 28: {
                return pSSysMsgTemplBase.getMobTaskUrl();
            }
            case 29: {
                return pSSysMsgTemplBase.getMobTaskUrlPSDEFId();
            }
            case 30: {
                return pSSysMsgTemplBase.getMobTaskUrlPSDEFName();
            }
            case 31: {
                return pSSysMsgTemplBase.getMsgTemplParams();
            }
            case 32: {
                return pSSysMsgTemplBase.getMsgTemplTag();
            }
            case 33: {
                return pSSysMsgTemplBase.getMsgTemplTag2();
            }
            case 34: {
                return pSSysMsgTemplBase.getMsgTemplType();
            }
            case 35: {
                return pSSysMsgTemplBase.getPSDEDSId();
            }
            case 36: {
                return pSSysMsgTemplBase.getPSDEDSName();
            }
            case 37: {
                return pSSysMsgTemplBase.getPSDEId();
            }
            case 38: {
                return pSSysMsgTemplBase.getPSDEName();
            }
            case 39: {
                return pSSysMsgTemplBase.getPSModuleId();
            }
            case 40: {
                return pSSysMsgTemplBase.getPSModuleName();
            }
            case 41: {
                return pSSysMsgTemplBase.getPSSysDynaModelId();
            }
            case 42: {
                return pSSysMsgTemplBase.getPSSysDynaModelName();
            }
            case 43: {
                return pSSysMsgTemplBase.getPSSysMsgTemplId();
            }
            case 44: {
                return pSSysMsgTemplBase.getPSSysMsgTemplName();
            }
            case 45: {
                return pSSysMsgTemplBase.getPSSysSFPluginId();
            }
            case 46: {
                return pSSysMsgTemplBase.getPSSysSFPluginName();
            }
            case 47: {
                return pSSysMsgTemplBase.getPSSystemId();
            }
            case 48: {
                return pSSysMsgTemplBase.getPSSystemName();
            }
            case 49: {
                return pSSysMsgTemplBase.getSMSContent();
            }
            case 50: {
                return pSSysMsgTemplBase.getSMSContentPSDEFId();
            }
            case 51: {
                return pSSysMsgTemplBase.getSMSContentPSDEFName();
            }
            case 52: {
                return pSSysMsgTemplBase.getSMSPSLanResId();
            }
            case 53: {
                return pSSysMsgTemplBase.getSMSPSLanResName();
            }
            case 54: {
                return pSSysMsgTemplBase.getSubject();
            }
            case 55: {
                return pSSysMsgTemplBase.getSubjectPSDEFId();
            }
            case 56: {
                return pSSysMsgTemplBase.getSubjectPSDEFName();
            }
            case 57: {
                return pSSysMsgTemplBase.getSubPSLanResId();
            }
            case 58: {
                return pSSysMsgTemplBase.getSubPSLanResName();
            }
            case 59: {
                return pSSysMsgTemplBase.getTaskUrl();
            }
            case 60: {
                return pSSysMsgTemplBase.getTaskUrlPSDEFId();
            }
            case 61: {
                return pSSysMsgTemplBase.getTaskUrlPSDEFName();
            }
            case 62: {
                return pSSysMsgTemplBase.getTemplEngine();
            }
            case 63: {
                return pSSysMsgTemplBase.getTemplTagPSDEFId();
            }
            case 64: {
                return pSSysMsgTemplBase.getTemplTagPSDEFName();
            }
            case 65: {
                return pSSysMsgTemplBase.getUpdateDate();
            }
            case 66: {
                return pSSysMsgTemplBase.getUpdateMan();
            }
            case 67: {
                return pSSysMsgTemplBase.getUser2PSDEFId();
            }
            case 68: {
                return pSSysMsgTemplBase.getUser2PSDEFName();
            }
            case 69: {
                return pSSysMsgTemplBase.getUserCat();
            }
            case 70: {
                return pSSysMsgTemplBase.getUserPSDEFId();
            }
            case 71: {
                return pSSysMsgTemplBase.getUserPSDEFName();
            }
            case 72: {
                return pSSysMsgTemplBase.getUserTag();
            }
            case 73: {
                return pSSysMsgTemplBase.getUserTag2();
            }
            case 74: {
                return pSSysMsgTemplBase.getUserTag3();
            }
            case 75: {
                return pSSysMsgTemplBase.getUserTag4();
            }
            case 76: {
                return pSSysMsgTemplBase.getWCContent();
            }
            case 77: {
                return pSSysMsgTemplBase.getWCContentPSDEFId();
            }
            case 78: {
                return pSSysMsgTemplBase.getWCContentPSDEFName();
            }
            case 79: {
                return pSSysMsgTemplBase.getWXPSLanResId();
            }
            case 80: {
                return pSSysMsgTemplBase.getWXPSLanResName();
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
        PSSysMsgTemplBase.set(this, n, object);
    }

    private static void set(PSSysMsgTemplBase pSSysMsgTemplBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysMsgTemplBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysMsgTemplBase.setContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysMsgTemplBase.setContentPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysMsgTemplBase.setContentPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysMsgTemplBase.setContentPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysMsgTemplBase.setContentPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysMsgTemplBase.setContentType(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysMsgTemplBase.setContentTypePSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysMsgTemplBase.setContentTypePSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysMsgTemplBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSSysMsgTemplBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysMsgTemplBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysMsgTemplBase.setCustomMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSSysMsgTemplBase.setDDContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysMsgTemplBase.setDDContentPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysMsgTemplBase.setDDContentPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysMsgTemplBase.setDDPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysMsgTemplBase.setDDPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysMsgTemplBase.setIMContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysMsgTemplBase.setIMContentPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysMsgTemplBase.setIMContentPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysMsgTemplBase.setIMPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysMsgTemplBase.setIMPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysMsgTemplBase.setLanPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysMsgTemplBase.setLanPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysMsgTemplBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 26: {
                pSSysMsgTemplBase.setMailGroupSend(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 27: {
                pSSysMsgTemplBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysMsgTemplBase.setMobTaskUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysMsgTemplBase.setMobTaskUrlPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysMsgTemplBase.setMobTaskUrlPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysMsgTemplBase.setMsgTemplParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysMsgTemplBase.setMsgTemplTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysMsgTemplBase.setMsgTemplTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysMsgTemplBase.setMsgTemplType(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSysMsgTemplBase.setPSDEDSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSSysMsgTemplBase.setPSDEDSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSSysMsgTemplBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSSysMsgTemplBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSSysMsgTemplBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSSysMsgTemplBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSSysMsgTemplBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSSysMsgTemplBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSSysMsgTemplBase.setPSSysMsgTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSSysMsgTemplBase.setPSSysMsgTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSSysMsgTemplBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSSysMsgTemplBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSSysMsgTemplBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSSysMsgTemplBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSSysMsgTemplBase.setSMSContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSSysMsgTemplBase.setSMSContentPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSSysMsgTemplBase.setSMSContentPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSSysMsgTemplBase.setSMSPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSSysMsgTemplBase.setSMSPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSSysMsgTemplBase.setSubject(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSSysMsgTemplBase.setSubjectPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSSysMsgTemplBase.setSubjectPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSSysMsgTemplBase.setSubPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 58: {
                pSSysMsgTemplBase.setSubPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 59: {
                pSSysMsgTemplBase.setTaskUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 60: {
                pSSysMsgTemplBase.setTaskUrlPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 61: {
                pSSysMsgTemplBase.setTaskUrlPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 62: {
                pSSysMsgTemplBase.setTemplEngine(DataObject.getStringValue((Object)object));
                return;
            }
            case 63: {
                pSSysMsgTemplBase.setTemplTagPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 64: {
                pSSysMsgTemplBase.setTemplTagPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 65: {
                pSSysMsgTemplBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 66: {
                pSSysMsgTemplBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 67: {
                pSSysMsgTemplBase.setUser2PSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 68: {
                pSSysMsgTemplBase.setUser2PSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 69: {
                pSSysMsgTemplBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 70: {
                pSSysMsgTemplBase.setUserPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 71: {
                pSSysMsgTemplBase.setUserPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 72: {
                pSSysMsgTemplBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 73: {
                pSSysMsgTemplBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 74: {
                pSSysMsgTemplBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 75: {
                pSSysMsgTemplBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 76: {
                pSSysMsgTemplBase.setWCContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 77: {
                pSSysMsgTemplBase.setWCContentPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 78: {
                pSSysMsgTemplBase.setWCContentPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 79: {
                pSSysMsgTemplBase.setWXPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 80: {
                pSSysMsgTemplBase.setWXPSLanResName(DataObject.getStringValue((Object)object));
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
        return PSSysMsgTemplBase.isNull(this, n);
    }

    private static boolean isNull(PSSysMsgTemplBase pSSysMsgTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysMsgTemplBase.getCodeName() == null;
            }
            case 1: {
                return pSSysMsgTemplBase.getContent() == null;
            }
            case 2: {
                return pSSysMsgTemplBase.getContentPSDEFId() == null;
            }
            case 3: {
                return pSSysMsgTemplBase.getContentPSDEFName() == null;
            }
            case 4: {
                return pSSysMsgTemplBase.getContentPSLanResId() == null;
            }
            case 5: {
                return pSSysMsgTemplBase.getContentPSLanResName() == null;
            }
            case 6: {
                return pSSysMsgTemplBase.getContentType() == null;
            }
            case 7: {
                return pSSysMsgTemplBase.getContentTypePSDEFId() == null;
            }
            case 8: {
                return pSSysMsgTemplBase.getContentTypePSDEFName() == null;
            }
            case 9: {
                return pSSysMsgTemplBase.getCreateDate() == null;
            }
            case 10: {
                return pSSysMsgTemplBase.getCreateMan() == null;
            }
            case 11: {
                return pSSysMsgTemplBase.getCustomCode() == null;
            }
            case 12: {
                return pSSysMsgTemplBase.getCustomMode() == null;
            }
            case 13: {
                return pSSysMsgTemplBase.getDDContent() == null;
            }
            case 14: {
                return pSSysMsgTemplBase.getDDContentPSDEFId() == null;
            }
            case 15: {
                return pSSysMsgTemplBase.getDDContentPSDEFName() == null;
            }
            case 16: {
                return pSSysMsgTemplBase.getDDPSLanResId() == null;
            }
            case 17: {
                return pSSysMsgTemplBase.getDDPSLanResName() == null;
            }
            case 18: {
                return pSSysMsgTemplBase.getIMContent() == null;
            }
            case 19: {
                return pSSysMsgTemplBase.getIMContentPSDEFId() == null;
            }
            case 20: {
                return pSSysMsgTemplBase.getIMContentPSDEFName() == null;
            }
            case 21: {
                return pSSysMsgTemplBase.getIMPSLanResId() == null;
            }
            case 22: {
                return pSSysMsgTemplBase.getIMPSLanResName() == null;
            }
            case 23: {
                return pSSysMsgTemplBase.getLanPSDEFId() == null;
            }
            case 24: {
                return pSSysMsgTemplBase.getLanPSDEFName() == null;
            }
            case 25: {
                return pSSysMsgTemplBase.getLockFlag() == null;
            }
            case 26: {
                return pSSysMsgTemplBase.getMailGroupSend() == null;
            }
            case 27: {
                return pSSysMsgTemplBase.getMemo() == null;
            }
            case 28: {
                return pSSysMsgTemplBase.getMobTaskUrl() == null;
            }
            case 29: {
                return pSSysMsgTemplBase.getMobTaskUrlPSDEFId() == null;
            }
            case 30: {
                return pSSysMsgTemplBase.getMobTaskUrlPSDEFName() == null;
            }
            case 31: {
                return pSSysMsgTemplBase.getMsgTemplParams() == null;
            }
            case 32: {
                return pSSysMsgTemplBase.getMsgTemplTag() == null;
            }
            case 33: {
                return pSSysMsgTemplBase.getMsgTemplTag2() == null;
            }
            case 34: {
                return pSSysMsgTemplBase.getMsgTemplType() == null;
            }
            case 35: {
                return pSSysMsgTemplBase.getPSDEDSId() == null;
            }
            case 36: {
                return pSSysMsgTemplBase.getPSDEDSName() == null;
            }
            case 37: {
                return pSSysMsgTemplBase.getPSDEId() == null;
            }
            case 38: {
                return pSSysMsgTemplBase.getPSDEName() == null;
            }
            case 39: {
                return pSSysMsgTemplBase.getPSModuleId() == null;
            }
            case 40: {
                return pSSysMsgTemplBase.getPSModuleName() == null;
            }
            case 41: {
                return pSSysMsgTemplBase.getPSSysDynaModelId() == null;
            }
            case 42: {
                return pSSysMsgTemplBase.getPSSysDynaModelName() == null;
            }
            case 43: {
                return pSSysMsgTemplBase.getPSSysMsgTemplId() == null;
            }
            case 44: {
                return pSSysMsgTemplBase.getPSSysMsgTemplName() == null;
            }
            case 45: {
                return pSSysMsgTemplBase.getPSSysSFPluginId() == null;
            }
            case 46: {
                return pSSysMsgTemplBase.getPSSysSFPluginName() == null;
            }
            case 47: {
                return pSSysMsgTemplBase.getPSSystemId() == null;
            }
            case 48: {
                return pSSysMsgTemplBase.getPSSystemName() == null;
            }
            case 49: {
                return pSSysMsgTemplBase.getSMSContent() == null;
            }
            case 50: {
                return pSSysMsgTemplBase.getSMSContentPSDEFId() == null;
            }
            case 51: {
                return pSSysMsgTemplBase.getSMSContentPSDEFName() == null;
            }
            case 52: {
                return pSSysMsgTemplBase.getSMSPSLanResId() == null;
            }
            case 53: {
                return pSSysMsgTemplBase.getSMSPSLanResName() == null;
            }
            case 54: {
                return pSSysMsgTemplBase.getSubject() == null;
            }
            case 55: {
                return pSSysMsgTemplBase.getSubjectPSDEFId() == null;
            }
            case 56: {
                return pSSysMsgTemplBase.getSubjectPSDEFName() == null;
            }
            case 57: {
                return pSSysMsgTemplBase.getSubPSLanResId() == null;
            }
            case 58: {
                return pSSysMsgTemplBase.getSubPSLanResName() == null;
            }
            case 59: {
                return pSSysMsgTemplBase.getTaskUrl() == null;
            }
            case 60: {
                return pSSysMsgTemplBase.getTaskUrlPSDEFId() == null;
            }
            case 61: {
                return pSSysMsgTemplBase.getTaskUrlPSDEFName() == null;
            }
            case 62: {
                return pSSysMsgTemplBase.getTemplEngine() == null;
            }
            case 63: {
                return pSSysMsgTemplBase.getTemplTagPSDEFId() == null;
            }
            case 64: {
                return pSSysMsgTemplBase.getTemplTagPSDEFName() == null;
            }
            case 65: {
                return pSSysMsgTemplBase.getUpdateDate() == null;
            }
            case 66: {
                return pSSysMsgTemplBase.getUpdateMan() == null;
            }
            case 67: {
                return pSSysMsgTemplBase.getUser2PSDEFId() == null;
            }
            case 68: {
                return pSSysMsgTemplBase.getUser2PSDEFName() == null;
            }
            case 69: {
                return pSSysMsgTemplBase.getUserCat() == null;
            }
            case 70: {
                return pSSysMsgTemplBase.getUserPSDEFId() == null;
            }
            case 71: {
                return pSSysMsgTemplBase.getUserPSDEFName() == null;
            }
            case 72: {
                return pSSysMsgTemplBase.getUserTag() == null;
            }
            case 73: {
                return pSSysMsgTemplBase.getUserTag2() == null;
            }
            case 74: {
                return pSSysMsgTemplBase.getUserTag3() == null;
            }
            case 75: {
                return pSSysMsgTemplBase.getUserTag4() == null;
            }
            case 76: {
                return pSSysMsgTemplBase.getWCContent() == null;
            }
            case 77: {
                return pSSysMsgTemplBase.getWCContentPSDEFId() == null;
            }
            case 78: {
                return pSSysMsgTemplBase.getWCContentPSDEFName() == null;
            }
            case 79: {
                return pSSysMsgTemplBase.getWXPSLanResId() == null;
            }
            case 80: {
                return pSSysMsgTemplBase.getWXPSLanResName() == null;
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
        return PSSysMsgTemplBase.contains(this, n);
    }

    private static boolean contains(PSSysMsgTemplBase pSSysMsgTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysMsgTemplBase.isCodeNameDirty();
            }
            case 1: {
                return pSSysMsgTemplBase.isContentDirty();
            }
            case 2: {
                return pSSysMsgTemplBase.isContentPSDEFIdDirty();
            }
            case 3: {
                return pSSysMsgTemplBase.isContentPSDEFNameDirty();
            }
            case 4: {
                return pSSysMsgTemplBase.isContentPSLanResIdDirty();
            }
            case 5: {
                return pSSysMsgTemplBase.isContentPSLanResNameDirty();
            }
            case 6: {
                return pSSysMsgTemplBase.isContentTypeDirty();
            }
            case 7: {
                return pSSysMsgTemplBase.isContentTypePSDEFIdDirty();
            }
            case 8: {
                return pSSysMsgTemplBase.isContentTypePSDEFNameDirty();
            }
            case 9: {
                return pSSysMsgTemplBase.isCreateDateDirty();
            }
            case 10: {
                return pSSysMsgTemplBase.isCreateManDirty();
            }
            case 11: {
                return pSSysMsgTemplBase.isCustomCodeDirty();
            }
            case 12: {
                return pSSysMsgTemplBase.isCustomModeDirty();
            }
            case 13: {
                return pSSysMsgTemplBase.isDDContentDirty();
            }
            case 14: {
                return pSSysMsgTemplBase.isDDContentPSDEFIdDirty();
            }
            case 15: {
                return pSSysMsgTemplBase.isDDContentPSDEFNameDirty();
            }
            case 16: {
                return pSSysMsgTemplBase.isDDPSLanResIdDirty();
            }
            case 17: {
                return pSSysMsgTemplBase.isDDPSLanResNameDirty();
            }
            case 18: {
                return pSSysMsgTemplBase.isIMContentDirty();
            }
            case 19: {
                return pSSysMsgTemplBase.isIMContentPSDEFIdDirty();
            }
            case 20: {
                return pSSysMsgTemplBase.isIMContentPSDEFNameDirty();
            }
            case 21: {
                return pSSysMsgTemplBase.isIMPSLanResIdDirty();
            }
            case 22: {
                return pSSysMsgTemplBase.isIMPSLanResNameDirty();
            }
            case 23: {
                return pSSysMsgTemplBase.isLanPSDEFIdDirty();
            }
            case 24: {
                return pSSysMsgTemplBase.isLanPSDEFNameDirty();
            }
            case 25: {
                return pSSysMsgTemplBase.isLockFlagDirty();
            }
            case 26: {
                return pSSysMsgTemplBase.isMailGroupSendDirty();
            }
            case 27: {
                return pSSysMsgTemplBase.isMemoDirty();
            }
            case 28: {
                return pSSysMsgTemplBase.isMobTaskUrlDirty();
            }
            case 29: {
                return pSSysMsgTemplBase.isMobTaskUrlPSDEFIdDirty();
            }
            case 30: {
                return pSSysMsgTemplBase.isMobTaskUrlPSDEFNameDirty();
            }
            case 31: {
                return pSSysMsgTemplBase.isMsgTemplParamsDirty();
            }
            case 32: {
                return pSSysMsgTemplBase.isMsgTemplTagDirty();
            }
            case 33: {
                return pSSysMsgTemplBase.isMsgTemplTag2Dirty();
            }
            case 34: {
                return pSSysMsgTemplBase.isMsgTemplTypeDirty();
            }
            case 35: {
                return pSSysMsgTemplBase.isPSDEDSIdDirty();
            }
            case 36: {
                return pSSysMsgTemplBase.isPSDEDSNameDirty();
            }
            case 37: {
                return pSSysMsgTemplBase.isPSDEIdDirty();
            }
            case 38: {
                return pSSysMsgTemplBase.isPSDENameDirty();
            }
            case 39: {
                return pSSysMsgTemplBase.isPSModuleIdDirty();
            }
            case 40: {
                return pSSysMsgTemplBase.isPSModuleNameDirty();
            }
            case 41: {
                return pSSysMsgTemplBase.isPSSysDynaModelIdDirty();
            }
            case 42: {
                return pSSysMsgTemplBase.isPSSysDynaModelNameDirty();
            }
            case 43: {
                return pSSysMsgTemplBase.isPSSysMsgTemplIdDirty();
            }
            case 44: {
                return pSSysMsgTemplBase.isPSSysMsgTemplNameDirty();
            }
            case 45: {
                return pSSysMsgTemplBase.isPSSysSFPluginIdDirty();
            }
            case 46: {
                return pSSysMsgTemplBase.isPSSysSFPluginNameDirty();
            }
            case 47: {
                return pSSysMsgTemplBase.isPSSystemIdDirty();
            }
            case 48: {
                return pSSysMsgTemplBase.isPSSystemNameDirty();
            }
            case 49: {
                return pSSysMsgTemplBase.isSMSContentDirty();
            }
            case 50: {
                return pSSysMsgTemplBase.isSMSContentPSDEFIdDirty();
            }
            case 51: {
                return pSSysMsgTemplBase.isSMSContentPSDEFNameDirty();
            }
            case 52: {
                return pSSysMsgTemplBase.isSMSPSLanResIdDirty();
            }
            case 53: {
                return pSSysMsgTemplBase.isSMSPSLanResNameDirty();
            }
            case 54: {
                return pSSysMsgTemplBase.isSubjectDirty();
            }
            case 55: {
                return pSSysMsgTemplBase.isSubjectPSDEFIdDirty();
            }
            case 56: {
                return pSSysMsgTemplBase.isSubjectPSDEFNameDirty();
            }
            case 57: {
                return pSSysMsgTemplBase.isSubPSLanResIdDirty();
            }
            case 58: {
                return pSSysMsgTemplBase.isSubPSLanResNameDirty();
            }
            case 59: {
                return pSSysMsgTemplBase.isTaskUrlDirty();
            }
            case 60: {
                return pSSysMsgTemplBase.isTaskUrlPSDEFIdDirty();
            }
            case 61: {
                return pSSysMsgTemplBase.isTaskUrlPSDEFNameDirty();
            }
            case 62: {
                return pSSysMsgTemplBase.isTemplEngineDirty();
            }
            case 63: {
                return pSSysMsgTemplBase.isTemplTagPSDEFIdDirty();
            }
            case 64: {
                return pSSysMsgTemplBase.isTemplTagPSDEFNameDirty();
            }
            case 65: {
                return pSSysMsgTemplBase.isUpdateDateDirty();
            }
            case 66: {
                return pSSysMsgTemplBase.isUpdateManDirty();
            }
            case 67: {
                return pSSysMsgTemplBase.isUser2PSDEFIdDirty();
            }
            case 68: {
                return pSSysMsgTemplBase.isUser2PSDEFNameDirty();
            }
            case 69: {
                return pSSysMsgTemplBase.isUserCatDirty();
            }
            case 70: {
                return pSSysMsgTemplBase.isUserPSDEFIdDirty();
            }
            case 71: {
                return pSSysMsgTemplBase.isUserPSDEFNameDirty();
            }
            case 72: {
                return pSSysMsgTemplBase.isUserTagDirty();
            }
            case 73: {
                return pSSysMsgTemplBase.isUserTag2Dirty();
            }
            case 74: {
                return pSSysMsgTemplBase.isUserTag3Dirty();
            }
            case 75: {
                return pSSysMsgTemplBase.isUserTag4Dirty();
            }
            case 76: {
                return pSSysMsgTemplBase.isWCContentDirty();
            }
            case 77: {
                return pSSysMsgTemplBase.isWCContentPSDEFIdDirty();
            }
            case 78: {
                return pSSysMsgTemplBase.isWCContentPSDEFNameDirty();
            }
            case 79: {
                return pSSysMsgTemplBase.isWXPSLanResIdDirty();
            }
            case 80: {
                return pSSysMsgTemplBase.isWXPSLanResNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysMsgTemplBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysMsgTemplBase pSSysMsgTemplBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysMsgTemplBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"content", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getContent()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getContentPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contentpsdefid", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getContentPSDEFId()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getContentPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contentpsdefname", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getContentPSDEFName()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getContentPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contentpslanresid", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getContentPSLanResId()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getContentPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contentpslanresname", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getContentPSLanResName()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getContentType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contenttype", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getContentType()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getContentTypePSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contenttypepsdefid", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getContentTypePSDEFId()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getContentTypePSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contenttypepsdefname", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getContentTypePSDEFName()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getCustomMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"custommode", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getCustomMode()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getDDContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ddcontent", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getDDContent()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getDDContentPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ddcontentpsdefid", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getDDContentPSDEFId()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getDDContentPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ddcontentpsdefname", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getDDContentPSDEFName()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getDDPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ddpslanresid", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getDDPSLanResId()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getDDPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ddpslanresname", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getDDPSLanResName()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getIMContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"imcontent", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getIMContent()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getIMContentPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"imcontentpsdefid", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getIMContentPSDEFId()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getIMContentPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"imcontentpsdefname", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getIMContentPSDEFName()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getIMPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"impslanresid", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getIMPSLanResId()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getIMPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"impslanresname", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getIMPSLanResName()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getLanPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lanpsdefid", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getLanPSDEFId()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getLanPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lanpsdefname", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getLanPSDEFName()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getMailGroupSend() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mailgroupsend", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getMailGroupSend()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getMobTaskUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobtaskurl", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getMobTaskUrl()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getMobTaskUrlPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobtaskurlpsdefid", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getMobTaskUrlPSDEFId()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getMobTaskUrlPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobtaskurlpsdefname", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getMobTaskUrlPSDEFName()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getMsgTemplParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"msgtemplparams", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getMsgTemplParams()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getMsgTemplTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"msgtempltag", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getMsgTemplTag()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getMsgTemplTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"msgtempltag2", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getMsgTemplTag2()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getMsgTemplType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"msgtempltype", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getMsgTemplType()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getPSDEDSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedsid", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getPSDEDSId()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getPSDEDSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedsname", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getPSDEDSName()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getPSSysMsgTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmsgtemplid", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getPSSysMsgTemplId()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getPSSysMsgTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmsgtemplname", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getPSSysMsgTemplName()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getSMSContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"smscontent", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getSMSContent()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getSMSContentPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"smscontentpsdefid", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getSMSContentPSDEFId()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getSMSContentPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"smscontentpsdefname", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getSMSContentPSDEFName()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getSMSPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"smspslanresid", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getSMSPSLanResId()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getSMSPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"smspslanresname", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getSMSPSLanResName()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getSubject() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"subject", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getSubject()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getSubjectPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"subjectpsdefid", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getSubjectPSDEFId()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getSubjectPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"subjectpsdefname", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getSubjectPSDEFName()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getSubPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"subpslanresid", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getSubPSLanResId()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getSubPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"subpslanresname", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getSubPSLanResName()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getTaskUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"taskurl", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getTaskUrl()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getTaskUrlPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"taskurlpsdefid", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getTaskUrlPSDEFId()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getTaskUrlPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"taskurlpsdefname", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getTaskUrlPSDEFName()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getTemplEngine() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templengine", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getTemplEngine()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getTemplTagPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templtagpsdefid", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getTemplTagPSDEFId()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getTemplTagPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templtagpsdefname", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getTemplTagPSDEFName()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getUser2PSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"user2psdefid", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getUser2PSDEFId()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getUser2PSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"user2psdefname", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getUser2PSDEFName()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getUserPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userpsdefid", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getUserPSDEFId()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getUserPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userpsdefname", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getUserPSDEFName()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getWCContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wccontent", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getWCContent()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getWCContentPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wccontentpsdefid", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getWCContentPSDEFId()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getWCContentPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wccontentpsdefname", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getWCContentPSDEFName()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getWXPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wxpslanresid", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getWXPSLanResId()), (boolean)false);
        }
        if (bl || pSSysMsgTemplBase.getWXPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wxpslanresname", (Object)PSSysMsgTemplBase.getJSONValue((Object)pSSysMsgTemplBase.getWXPSLanResName()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysMsgTemplBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysMsgTemplBase pSSysMsgTemplBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysMsgTemplBase.getCodeName() != null) {
            object = pSSysMsgTemplBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, (String)(object == null ? "" : object));
        }
        if (bl || pSSysMsgTemplBase.getContent() != null) {
            object = pSSysMsgTemplBase.getContent();
            xmlNode.setAttribute(FIELD_CONTENT, (String)(object == null ? "" : object));
        }
        if (bl || pSSysMsgTemplBase.getContentPSDEFId() != null) {
            object = pSSysMsgTemplBase.getContentPSDEFId();
            xmlNode.setAttribute(FIELD_CONTENTPSDEFID, (String)(object == null ? "" : object));
        }
        if (bl || pSSysMsgTemplBase.getContentPSDEFName() != null) {
            object = pSSysMsgTemplBase.getContentPSDEFName();
            xmlNode.setAttribute(FIELD_CONTENTPSDEFNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSSysMsgTemplBase.getContentPSLanResId() != null) {
            object = pSSysMsgTemplBase.getContentPSLanResId();
            xmlNode.setAttribute(FIELD_CONTENTPSLANRESID, (String)(object == null ? "" : object));
        }
        if (bl || pSSysMsgTemplBase.getContentPSLanResName() != null) {
            object = pSSysMsgTemplBase.getContentPSLanResName();
            xmlNode.setAttribute(FIELD_CONTENTPSLANRESNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSSysMsgTemplBase.getContentType() != null) {
            object = pSSysMsgTemplBase.getContentType();
            xmlNode.setAttribute(FIELD_CONTENTTYPE, (String)(object == null ? "" : object));
        }
        if (bl || pSSysMsgTemplBase.getContentTypePSDEFId() != null) {
            object = pSSysMsgTemplBase.getContentTypePSDEFId();
            xmlNode.setAttribute(FIELD_CONTENTTYPEPSDEFID, (String)(object == null ? "" : object));
        }
        if (bl || pSSysMsgTemplBase.getContentTypePSDEFName() != null) {
            object = pSSysMsgTemplBase.getContentTypePSDEFName();
            xmlNode.setAttribute(FIELD_CONTENTTYPEPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getCreateDate() != null) {
            object = pSSysMsgTemplBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysMsgTemplBase.getCreateMan() != null) {
            object = pSSysMsgTemplBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getCustomCode() != null) {
            object = pSSysMsgTemplBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getCustomMode() != null) {
            object = pSSysMsgTemplBase.getCustomMode();
            xmlNode.setAttribute(FIELD_CUSTOMMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysMsgTemplBase.getDDContent() != null) {
            object = pSSysMsgTemplBase.getDDContent();
            xmlNode.setAttribute(FIELD_DDCONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getDDContentPSDEFId() != null) {
            object = pSSysMsgTemplBase.getDDContentPSDEFId();
            xmlNode.setAttribute(FIELD_DDCONTENTPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getDDContentPSDEFName() != null) {
            object = pSSysMsgTemplBase.getDDContentPSDEFName();
            xmlNode.setAttribute(FIELD_DDCONTENTPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getDDPSLanResId() != null) {
            object = pSSysMsgTemplBase.getDDPSLanResId();
            xmlNode.setAttribute(FIELD_DDPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getDDPSLanResName() != null) {
            object = pSSysMsgTemplBase.getDDPSLanResName();
            xmlNode.setAttribute(FIELD_DDPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getIMContent() != null) {
            object = pSSysMsgTemplBase.getIMContent();
            xmlNode.setAttribute(FIELD_IMCONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getIMContentPSDEFId() != null) {
            object = pSSysMsgTemplBase.getIMContentPSDEFId();
            xmlNode.setAttribute(FIELD_IMCONTENTPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getIMContentPSDEFName() != null) {
            object = pSSysMsgTemplBase.getIMContentPSDEFName();
            xmlNode.setAttribute(FIELD_IMCONTENTPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getIMPSLanResId() != null) {
            object = pSSysMsgTemplBase.getIMPSLanResId();
            xmlNode.setAttribute(FIELD_IMPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getIMPSLanResName() != null) {
            object = pSSysMsgTemplBase.getIMPSLanResName();
            xmlNode.setAttribute(FIELD_IMPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getLanPSDEFId() != null) {
            object = pSSysMsgTemplBase.getLanPSDEFId();
            xmlNode.setAttribute(FIELD_LANPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getLanPSDEFName() != null) {
            object = pSSysMsgTemplBase.getLanPSDEFName();
            xmlNode.setAttribute(FIELD_LANPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getLockFlag() != null) {
            object = pSSysMsgTemplBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysMsgTemplBase.getMailGroupSend() != null) {
            object = pSSysMsgTemplBase.getMailGroupSend();
            xmlNode.setAttribute(FIELD_MAILGROUPSEND, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysMsgTemplBase.getMemo() != null) {
            object = pSSysMsgTemplBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getMobTaskUrl() != null) {
            object = pSSysMsgTemplBase.getMobTaskUrl();
            xmlNode.setAttribute(FIELD_MOBTASKURL, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getMobTaskUrlPSDEFId() != null) {
            object = pSSysMsgTemplBase.getMobTaskUrlPSDEFId();
            xmlNode.setAttribute(FIELD_MOBTASKURLPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getMobTaskUrlPSDEFName() != null) {
            object = pSSysMsgTemplBase.getMobTaskUrlPSDEFName();
            xmlNode.setAttribute(FIELD_MOBTASKURLPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getMsgTemplParams() != null) {
            object = pSSysMsgTemplBase.getMsgTemplParams();
            xmlNode.setAttribute(FIELD_MSGTEMPLPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getMsgTemplTag() != null) {
            object = pSSysMsgTemplBase.getMsgTemplTag();
            xmlNode.setAttribute(FIELD_MSGTEMPLTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getMsgTemplTag2() != null) {
            object = pSSysMsgTemplBase.getMsgTemplTag2();
            xmlNode.setAttribute(FIELD_MSGTEMPLTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getMsgTemplType() != null) {
            object = pSSysMsgTemplBase.getMsgTemplType();
            xmlNode.setAttribute(FIELD_MSGTEMPLTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getPSDEDSId() != null) {
            object = pSSysMsgTemplBase.getPSDEDSId();
            xmlNode.setAttribute(FIELD_PSDEDSID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getPSDEDSName() != null) {
            object = pSSysMsgTemplBase.getPSDEDSName();
            xmlNode.setAttribute(FIELD_PSDEDSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getPSDEId() != null) {
            object = pSSysMsgTemplBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getPSDEName() != null) {
            object = pSSysMsgTemplBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getPSModuleId() != null) {
            object = pSSysMsgTemplBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getPSModuleName() != null) {
            object = pSSysMsgTemplBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getPSSysDynaModelId() != null) {
            object = pSSysMsgTemplBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getPSSysDynaModelName() != null) {
            object = pSSysMsgTemplBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getPSSysMsgTemplId() != null) {
            object = pSSysMsgTemplBase.getPSSysMsgTemplId();
            xmlNode.setAttribute(FIELD_PSSYSMSGTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getPSSysMsgTemplName() != null) {
            object = pSSysMsgTemplBase.getPSSysMsgTemplName();
            xmlNode.setAttribute(FIELD_PSSYSMSGTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getPSSysSFPluginId() != null) {
            object = pSSysMsgTemplBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getPSSysSFPluginName() != null) {
            object = pSSysMsgTemplBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getPSSystemId() != null) {
            object = pSSysMsgTemplBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getPSSystemName() != null) {
            object = pSSysMsgTemplBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getSMSContent() != null) {
            object = pSSysMsgTemplBase.getSMSContent();
            xmlNode.setAttribute(FIELD_SMSCONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getSMSContentPSDEFId() != null) {
            object = pSSysMsgTemplBase.getSMSContentPSDEFId();
            xmlNode.setAttribute(FIELD_SMSCONTENTPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getSMSContentPSDEFName() != null) {
            object = pSSysMsgTemplBase.getSMSContentPSDEFName();
            xmlNode.setAttribute(FIELD_SMSCONTENTPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getSMSPSLanResId() != null) {
            object = pSSysMsgTemplBase.getSMSPSLanResId();
            xmlNode.setAttribute(FIELD_SMSPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getSMSPSLanResName() != null) {
            object = pSSysMsgTemplBase.getSMSPSLanResName();
            xmlNode.setAttribute(FIELD_SMSPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getSubject() != null) {
            object = pSSysMsgTemplBase.getSubject();
            xmlNode.setAttribute(FIELD_SUBJECT, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getSubjectPSDEFId() != null) {
            object = pSSysMsgTemplBase.getSubjectPSDEFId();
            xmlNode.setAttribute(FIELD_SUBJECTPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getSubjectPSDEFName() != null) {
            object = pSSysMsgTemplBase.getSubjectPSDEFName();
            xmlNode.setAttribute(FIELD_SUBJECTPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getSubPSLanResId() != null) {
            object = pSSysMsgTemplBase.getSubPSLanResId();
            xmlNode.setAttribute(FIELD_SUBPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getSubPSLanResName() != null) {
            object = pSSysMsgTemplBase.getSubPSLanResName();
            xmlNode.setAttribute(FIELD_SUBPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getTaskUrl() != null) {
            object = pSSysMsgTemplBase.getTaskUrl();
            xmlNode.setAttribute(FIELD_TASKURL, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getTaskUrlPSDEFId() != null) {
            object = pSSysMsgTemplBase.getTaskUrlPSDEFId();
            xmlNode.setAttribute(FIELD_TASKURLPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getTaskUrlPSDEFName() != null) {
            object = pSSysMsgTemplBase.getTaskUrlPSDEFName();
            xmlNode.setAttribute(FIELD_TASKURLPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getTemplEngine() != null) {
            object = pSSysMsgTemplBase.getTemplEngine();
            xmlNode.setAttribute(FIELD_TEMPLENGINE, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getTemplTagPSDEFId() != null) {
            object = pSSysMsgTemplBase.getTemplTagPSDEFId();
            xmlNode.setAttribute(FIELD_TEMPLTAGPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getTemplTagPSDEFName() != null) {
            object = pSSysMsgTemplBase.getTemplTagPSDEFName();
            xmlNode.setAttribute(FIELD_TEMPLTAGPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getUpdateDate() != null) {
            object = pSSysMsgTemplBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysMsgTemplBase.getUpdateMan() != null) {
            object = pSSysMsgTemplBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getUser2PSDEFId() != null) {
            object = pSSysMsgTemplBase.getUser2PSDEFId();
            xmlNode.setAttribute(FIELD_USER2PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getUser2PSDEFName() != null) {
            object = pSSysMsgTemplBase.getUser2PSDEFName();
            xmlNode.setAttribute(FIELD_USER2PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getUserCat() != null) {
            object = pSSysMsgTemplBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getUserPSDEFId() != null) {
            object = pSSysMsgTemplBase.getUserPSDEFId();
            xmlNode.setAttribute(FIELD_USERPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getUserPSDEFName() != null) {
            object = pSSysMsgTemplBase.getUserPSDEFName();
            xmlNode.setAttribute(FIELD_USERPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getUserTag() != null) {
            object = pSSysMsgTemplBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getUserTag2() != null) {
            object = pSSysMsgTemplBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getUserTag3() != null) {
            object = pSSysMsgTemplBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getUserTag4() != null) {
            object = pSSysMsgTemplBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getWCContent() != null) {
            object = pSSysMsgTemplBase.getWCContent();
            xmlNode.setAttribute(FIELD_WCCONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getWCContentPSDEFId() != null) {
            object = pSSysMsgTemplBase.getWCContentPSDEFId();
            xmlNode.setAttribute(FIELD_WCCONTENTPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getWCContentPSDEFName() != null) {
            object = pSSysMsgTemplBase.getWCContentPSDEFName();
            xmlNode.setAttribute(FIELD_WCCONTENTPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getWXPSLanResId() != null) {
            object = pSSysMsgTemplBase.getWXPSLanResId();
            xmlNode.setAttribute(FIELD_WXPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTemplBase.getWXPSLanResName() != null) {
            object = pSSysMsgTemplBase.getWXPSLanResName();
            xmlNode.setAttribute(FIELD_WXPSLANRESNAME, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysMsgTemplBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysMsgTemplBase pSSysMsgTemplBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysMsgTemplBase.isCodeNameDirty() && (bl || pSSysMsgTemplBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysMsgTemplBase.getCodeName());
        }
        if (pSSysMsgTemplBase.isContentDirty() && (bl || pSSysMsgTemplBase.getContent() != null)) {
            iDataObject.set(FIELD_CONTENT, (Object)pSSysMsgTemplBase.getContent());
        }
        if (pSSysMsgTemplBase.isContentPSDEFIdDirty() && (bl || pSSysMsgTemplBase.getContentPSDEFId() != null)) {
            iDataObject.set(FIELD_CONTENTPSDEFID, (Object)pSSysMsgTemplBase.getContentPSDEFId());
        }
        if (pSSysMsgTemplBase.isContentPSDEFNameDirty() && (bl || pSSysMsgTemplBase.getContentPSDEFName() != null)) {
            iDataObject.set(FIELD_CONTENTPSDEFNAME, (Object)pSSysMsgTemplBase.getContentPSDEFName());
        }
        if (pSSysMsgTemplBase.isContentPSLanResIdDirty() && (bl || pSSysMsgTemplBase.getContentPSLanResId() != null)) {
            iDataObject.set(FIELD_CONTENTPSLANRESID, (Object)pSSysMsgTemplBase.getContentPSLanResId());
        }
        if (pSSysMsgTemplBase.isContentPSLanResNameDirty() && (bl || pSSysMsgTemplBase.getContentPSLanResName() != null)) {
            iDataObject.set(FIELD_CONTENTPSLANRESNAME, (Object)pSSysMsgTemplBase.getContentPSLanResName());
        }
        if (pSSysMsgTemplBase.isContentTypeDirty() && (bl || pSSysMsgTemplBase.getContentType() != null)) {
            iDataObject.set(FIELD_CONTENTTYPE, (Object)pSSysMsgTemplBase.getContentType());
        }
        if (pSSysMsgTemplBase.isContentTypePSDEFIdDirty() && (bl || pSSysMsgTemplBase.getContentTypePSDEFId() != null)) {
            iDataObject.set(FIELD_CONTENTTYPEPSDEFID, (Object)pSSysMsgTemplBase.getContentTypePSDEFId());
        }
        if (pSSysMsgTemplBase.isContentTypePSDEFNameDirty() && (bl || pSSysMsgTemplBase.getContentTypePSDEFName() != null)) {
            iDataObject.set(FIELD_CONTENTTYPEPSDEFNAME, (Object)pSSysMsgTemplBase.getContentTypePSDEFName());
        }
        if (pSSysMsgTemplBase.isCreateDateDirty() && (bl || pSSysMsgTemplBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysMsgTemplBase.getCreateDate());
        }
        if (pSSysMsgTemplBase.isCreateManDirty() && (bl || pSSysMsgTemplBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysMsgTemplBase.getCreateMan());
        }
        if (pSSysMsgTemplBase.isCustomCodeDirty() && (bl || pSSysMsgTemplBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSSysMsgTemplBase.getCustomCode());
        }
        if (pSSysMsgTemplBase.isCustomModeDirty() && (bl || pSSysMsgTemplBase.getCustomMode() != null)) {
            iDataObject.set(FIELD_CUSTOMMODE, (Object)pSSysMsgTemplBase.getCustomMode());
        }
        if (pSSysMsgTemplBase.isDDContentDirty() && (bl || pSSysMsgTemplBase.getDDContent() != null)) {
            iDataObject.set(FIELD_DDCONTENT, (Object)pSSysMsgTemplBase.getDDContent());
        }
        if (pSSysMsgTemplBase.isDDContentPSDEFIdDirty() && (bl || pSSysMsgTemplBase.getDDContentPSDEFId() != null)) {
            iDataObject.set(FIELD_DDCONTENTPSDEFID, (Object)pSSysMsgTemplBase.getDDContentPSDEFId());
        }
        if (pSSysMsgTemplBase.isDDContentPSDEFNameDirty() && (bl || pSSysMsgTemplBase.getDDContentPSDEFName() != null)) {
            iDataObject.set(FIELD_DDCONTENTPSDEFNAME, (Object)pSSysMsgTemplBase.getDDContentPSDEFName());
        }
        if (pSSysMsgTemplBase.isDDPSLanResIdDirty() && (bl || pSSysMsgTemplBase.getDDPSLanResId() != null)) {
            iDataObject.set(FIELD_DDPSLANRESID, (Object)pSSysMsgTemplBase.getDDPSLanResId());
        }
        if (pSSysMsgTemplBase.isDDPSLanResNameDirty() && (bl || pSSysMsgTemplBase.getDDPSLanResName() != null)) {
            iDataObject.set(FIELD_DDPSLANRESNAME, (Object)pSSysMsgTemplBase.getDDPSLanResName());
        }
        if (pSSysMsgTemplBase.isIMContentDirty() && (bl || pSSysMsgTemplBase.getIMContent() != null)) {
            iDataObject.set(FIELD_IMCONTENT, (Object)pSSysMsgTemplBase.getIMContent());
        }
        if (pSSysMsgTemplBase.isIMContentPSDEFIdDirty() && (bl || pSSysMsgTemplBase.getIMContentPSDEFId() != null)) {
            iDataObject.set(FIELD_IMCONTENTPSDEFID, (Object)pSSysMsgTemplBase.getIMContentPSDEFId());
        }
        if (pSSysMsgTemplBase.isIMContentPSDEFNameDirty() && (bl || pSSysMsgTemplBase.getIMContentPSDEFName() != null)) {
            iDataObject.set(FIELD_IMCONTENTPSDEFNAME, (Object)pSSysMsgTemplBase.getIMContentPSDEFName());
        }
        if (pSSysMsgTemplBase.isIMPSLanResIdDirty() && (bl || pSSysMsgTemplBase.getIMPSLanResId() != null)) {
            iDataObject.set(FIELD_IMPSLANRESID, (Object)pSSysMsgTemplBase.getIMPSLanResId());
        }
        if (pSSysMsgTemplBase.isIMPSLanResNameDirty() && (bl || pSSysMsgTemplBase.getIMPSLanResName() != null)) {
            iDataObject.set(FIELD_IMPSLANRESNAME, (Object)pSSysMsgTemplBase.getIMPSLanResName());
        }
        if (pSSysMsgTemplBase.isLanPSDEFIdDirty() && (bl || pSSysMsgTemplBase.getLanPSDEFId() != null)) {
            iDataObject.set(FIELD_LANPSDEFID, (Object)pSSysMsgTemplBase.getLanPSDEFId());
        }
        if (pSSysMsgTemplBase.isLanPSDEFNameDirty() && (bl || pSSysMsgTemplBase.getLanPSDEFName() != null)) {
            iDataObject.set(FIELD_LANPSDEFNAME, (Object)pSSysMsgTemplBase.getLanPSDEFName());
        }
        if (pSSysMsgTemplBase.isLockFlagDirty() && (bl || pSSysMsgTemplBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSSysMsgTemplBase.getLockFlag());
        }
        if (pSSysMsgTemplBase.isMailGroupSendDirty() && (bl || pSSysMsgTemplBase.getMailGroupSend() != null)) {
            iDataObject.set(FIELD_MAILGROUPSEND, (Object)pSSysMsgTemplBase.getMailGroupSend());
        }
        if (pSSysMsgTemplBase.isMemoDirty() && (bl || pSSysMsgTemplBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysMsgTemplBase.getMemo());
        }
        if (pSSysMsgTemplBase.isMobTaskUrlDirty() && (bl || pSSysMsgTemplBase.getMobTaskUrl() != null)) {
            iDataObject.set(FIELD_MOBTASKURL, (Object)pSSysMsgTemplBase.getMobTaskUrl());
        }
        if (pSSysMsgTemplBase.isMobTaskUrlPSDEFIdDirty() && (bl || pSSysMsgTemplBase.getMobTaskUrlPSDEFId() != null)) {
            iDataObject.set(FIELD_MOBTASKURLPSDEFID, (Object)pSSysMsgTemplBase.getMobTaskUrlPSDEFId());
        }
        if (pSSysMsgTemplBase.isMobTaskUrlPSDEFNameDirty() && (bl || pSSysMsgTemplBase.getMobTaskUrlPSDEFName() != null)) {
            iDataObject.set(FIELD_MOBTASKURLPSDEFNAME, (Object)pSSysMsgTemplBase.getMobTaskUrlPSDEFName());
        }
        if (pSSysMsgTemplBase.isMsgTemplParamsDirty() && (bl || pSSysMsgTemplBase.getMsgTemplParams() != null)) {
            iDataObject.set(FIELD_MSGTEMPLPARAMS, (Object)pSSysMsgTemplBase.getMsgTemplParams());
        }
        if (pSSysMsgTemplBase.isMsgTemplTagDirty() && (bl || pSSysMsgTemplBase.getMsgTemplTag() != null)) {
            iDataObject.set(FIELD_MSGTEMPLTAG, (Object)pSSysMsgTemplBase.getMsgTemplTag());
        }
        if (pSSysMsgTemplBase.isMsgTemplTag2Dirty() && (bl || pSSysMsgTemplBase.getMsgTemplTag2() != null)) {
            iDataObject.set(FIELD_MSGTEMPLTAG2, (Object)pSSysMsgTemplBase.getMsgTemplTag2());
        }
        if (pSSysMsgTemplBase.isMsgTemplTypeDirty() && (bl || pSSysMsgTemplBase.getMsgTemplType() != null)) {
            iDataObject.set(FIELD_MSGTEMPLTYPE, (Object)pSSysMsgTemplBase.getMsgTemplType());
        }
        if (pSSysMsgTemplBase.isPSDEDSIdDirty() && (bl || pSSysMsgTemplBase.getPSDEDSId() != null)) {
            iDataObject.set(FIELD_PSDEDSID, (Object)pSSysMsgTemplBase.getPSDEDSId());
        }
        if (pSSysMsgTemplBase.isPSDEDSNameDirty() && (bl || pSSysMsgTemplBase.getPSDEDSName() != null)) {
            iDataObject.set(FIELD_PSDEDSNAME, (Object)pSSysMsgTemplBase.getPSDEDSName());
        }
        if (pSSysMsgTemplBase.isPSDEIdDirty() && (bl || pSSysMsgTemplBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysMsgTemplBase.getPSDEId());
        }
        if (pSSysMsgTemplBase.isPSDENameDirty() && (bl || pSSysMsgTemplBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSSysMsgTemplBase.getPSDEName());
        }
        if (pSSysMsgTemplBase.isPSModuleIdDirty() && (bl || pSSysMsgTemplBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysMsgTemplBase.getPSModuleId());
        }
        if (pSSysMsgTemplBase.isPSModuleNameDirty() && (bl || pSSysMsgTemplBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysMsgTemplBase.getPSModuleName());
        }
        if (pSSysMsgTemplBase.isPSSysDynaModelIdDirty() && (bl || pSSysMsgTemplBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSSysMsgTemplBase.getPSSysDynaModelId());
        }
        if (pSSysMsgTemplBase.isPSSysDynaModelNameDirty() && (bl || pSSysMsgTemplBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSSysMsgTemplBase.getPSSysDynaModelName());
        }
        if (pSSysMsgTemplBase.isPSSysMsgTemplIdDirty() && (bl || pSSysMsgTemplBase.getPSSysMsgTemplId() != null)) {
            iDataObject.set(FIELD_PSSYSMSGTEMPLID, (Object)pSSysMsgTemplBase.getPSSysMsgTemplId());
        }
        if (pSSysMsgTemplBase.isPSSysMsgTemplNameDirty() && (bl || pSSysMsgTemplBase.getPSSysMsgTemplName() != null)) {
            iDataObject.set(FIELD_PSSYSMSGTEMPLNAME, (Object)pSSysMsgTemplBase.getPSSysMsgTemplName());
        }
        if (pSSysMsgTemplBase.isPSSysSFPluginIdDirty() && (bl || pSSysMsgTemplBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSSysMsgTemplBase.getPSSysSFPluginId());
        }
        if (pSSysMsgTemplBase.isPSSysSFPluginNameDirty() && (bl || pSSysMsgTemplBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSSysMsgTemplBase.getPSSysSFPluginName());
        }
        if (pSSysMsgTemplBase.isPSSystemIdDirty() && (bl || pSSysMsgTemplBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysMsgTemplBase.getPSSystemId());
        }
        if (pSSysMsgTemplBase.isPSSystemNameDirty() && (bl || pSSysMsgTemplBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysMsgTemplBase.getPSSystemName());
        }
        if (pSSysMsgTemplBase.isSMSContentDirty() && (bl || pSSysMsgTemplBase.getSMSContent() != null)) {
            iDataObject.set(FIELD_SMSCONTENT, (Object)pSSysMsgTemplBase.getSMSContent());
        }
        if (pSSysMsgTemplBase.isSMSContentPSDEFIdDirty() && (bl || pSSysMsgTemplBase.getSMSContentPSDEFId() != null)) {
            iDataObject.set(FIELD_SMSCONTENTPSDEFID, (Object)pSSysMsgTemplBase.getSMSContentPSDEFId());
        }
        if (pSSysMsgTemplBase.isSMSContentPSDEFNameDirty() && (bl || pSSysMsgTemplBase.getSMSContentPSDEFName() != null)) {
            iDataObject.set(FIELD_SMSCONTENTPSDEFNAME, (Object)pSSysMsgTemplBase.getSMSContentPSDEFName());
        }
        if (pSSysMsgTemplBase.isSMSPSLanResIdDirty() && (bl || pSSysMsgTemplBase.getSMSPSLanResId() != null)) {
            iDataObject.set(FIELD_SMSPSLANRESID, (Object)pSSysMsgTemplBase.getSMSPSLanResId());
        }
        if (pSSysMsgTemplBase.isSMSPSLanResNameDirty() && (bl || pSSysMsgTemplBase.getSMSPSLanResName() != null)) {
            iDataObject.set(FIELD_SMSPSLANRESNAME, (Object)pSSysMsgTemplBase.getSMSPSLanResName());
        }
        if (pSSysMsgTemplBase.isSubjectDirty() && (bl || pSSysMsgTemplBase.getSubject() != null)) {
            iDataObject.set(FIELD_SUBJECT, (Object)pSSysMsgTemplBase.getSubject());
        }
        if (pSSysMsgTemplBase.isSubjectPSDEFIdDirty() && (bl || pSSysMsgTemplBase.getSubjectPSDEFId() != null)) {
            iDataObject.set(FIELD_SUBJECTPSDEFID, (Object)pSSysMsgTemplBase.getSubjectPSDEFId());
        }
        if (pSSysMsgTemplBase.isSubjectPSDEFNameDirty() && (bl || pSSysMsgTemplBase.getSubjectPSDEFName() != null)) {
            iDataObject.set(FIELD_SUBJECTPSDEFNAME, (Object)pSSysMsgTemplBase.getSubjectPSDEFName());
        }
        if (pSSysMsgTemplBase.isSubPSLanResIdDirty() && (bl || pSSysMsgTemplBase.getSubPSLanResId() != null)) {
            iDataObject.set(FIELD_SUBPSLANRESID, (Object)pSSysMsgTemplBase.getSubPSLanResId());
        }
        if (pSSysMsgTemplBase.isSubPSLanResNameDirty() && (bl || pSSysMsgTemplBase.getSubPSLanResName() != null)) {
            iDataObject.set(FIELD_SUBPSLANRESNAME, (Object)pSSysMsgTemplBase.getSubPSLanResName());
        }
        if (pSSysMsgTemplBase.isTaskUrlDirty() && (bl || pSSysMsgTemplBase.getTaskUrl() != null)) {
            iDataObject.set(FIELD_TASKURL, (Object)pSSysMsgTemplBase.getTaskUrl());
        }
        if (pSSysMsgTemplBase.isTaskUrlPSDEFIdDirty() && (bl || pSSysMsgTemplBase.getTaskUrlPSDEFId() != null)) {
            iDataObject.set(FIELD_TASKURLPSDEFID, (Object)pSSysMsgTemplBase.getTaskUrlPSDEFId());
        }
        if (pSSysMsgTemplBase.isTaskUrlPSDEFNameDirty() && (bl || pSSysMsgTemplBase.getTaskUrlPSDEFName() != null)) {
            iDataObject.set(FIELD_TASKURLPSDEFNAME, (Object)pSSysMsgTemplBase.getTaskUrlPSDEFName());
        }
        if (pSSysMsgTemplBase.isTemplEngineDirty() && (bl || pSSysMsgTemplBase.getTemplEngine() != null)) {
            iDataObject.set(FIELD_TEMPLENGINE, (Object)pSSysMsgTemplBase.getTemplEngine());
        }
        if (pSSysMsgTemplBase.isTemplTagPSDEFIdDirty() && (bl || pSSysMsgTemplBase.getTemplTagPSDEFId() != null)) {
            iDataObject.set(FIELD_TEMPLTAGPSDEFID, (Object)pSSysMsgTemplBase.getTemplTagPSDEFId());
        }
        if (pSSysMsgTemplBase.isTemplTagPSDEFNameDirty() && (bl || pSSysMsgTemplBase.getTemplTagPSDEFName() != null)) {
            iDataObject.set(FIELD_TEMPLTAGPSDEFNAME, (Object)pSSysMsgTemplBase.getTemplTagPSDEFName());
        }
        if (pSSysMsgTemplBase.isUpdateDateDirty() && (bl || pSSysMsgTemplBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysMsgTemplBase.getUpdateDate());
        }
        if (pSSysMsgTemplBase.isUpdateManDirty() && (bl || pSSysMsgTemplBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysMsgTemplBase.getUpdateMan());
        }
        if (pSSysMsgTemplBase.isUser2PSDEFIdDirty() && (bl || pSSysMsgTemplBase.getUser2PSDEFId() != null)) {
            iDataObject.set(FIELD_USER2PSDEFID, (Object)pSSysMsgTemplBase.getUser2PSDEFId());
        }
        if (pSSysMsgTemplBase.isUser2PSDEFNameDirty() && (bl || pSSysMsgTemplBase.getUser2PSDEFName() != null)) {
            iDataObject.set(FIELD_USER2PSDEFNAME, (Object)pSSysMsgTemplBase.getUser2PSDEFName());
        }
        if (pSSysMsgTemplBase.isUserCatDirty() && (bl || pSSysMsgTemplBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysMsgTemplBase.getUserCat());
        }
        if (pSSysMsgTemplBase.isUserPSDEFIdDirty() && (bl || pSSysMsgTemplBase.getUserPSDEFId() != null)) {
            iDataObject.set(FIELD_USERPSDEFID, (Object)pSSysMsgTemplBase.getUserPSDEFId());
        }
        if (pSSysMsgTemplBase.isUserPSDEFNameDirty() && (bl || pSSysMsgTemplBase.getUserPSDEFName() != null)) {
            iDataObject.set(FIELD_USERPSDEFNAME, (Object)pSSysMsgTemplBase.getUserPSDEFName());
        }
        if (pSSysMsgTemplBase.isUserTagDirty() && (bl || pSSysMsgTemplBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysMsgTemplBase.getUserTag());
        }
        if (pSSysMsgTemplBase.isUserTag2Dirty() && (bl || pSSysMsgTemplBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysMsgTemplBase.getUserTag2());
        }
        if (pSSysMsgTemplBase.isUserTag3Dirty() && (bl || pSSysMsgTemplBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysMsgTemplBase.getUserTag3());
        }
        if (pSSysMsgTemplBase.isUserTag4Dirty() && (bl || pSSysMsgTemplBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysMsgTemplBase.getUserTag4());
        }
        if (pSSysMsgTemplBase.isWCContentDirty() && (bl || pSSysMsgTemplBase.getWCContent() != null)) {
            iDataObject.set(FIELD_WCCONTENT, (Object)pSSysMsgTemplBase.getWCContent());
        }
        if (pSSysMsgTemplBase.isWCContentPSDEFIdDirty() && (bl || pSSysMsgTemplBase.getWCContentPSDEFId() != null)) {
            iDataObject.set(FIELD_WCCONTENTPSDEFID, (Object)pSSysMsgTemplBase.getWCContentPSDEFId());
        }
        if (pSSysMsgTemplBase.isWCContentPSDEFNameDirty() && (bl || pSSysMsgTemplBase.getWCContentPSDEFName() != null)) {
            iDataObject.set(FIELD_WCCONTENTPSDEFNAME, (Object)pSSysMsgTemplBase.getWCContentPSDEFName());
        }
        if (pSSysMsgTemplBase.isWXPSLanResIdDirty() && (bl || pSSysMsgTemplBase.getWXPSLanResId() != null)) {
            iDataObject.set(FIELD_WXPSLANRESID, (Object)pSSysMsgTemplBase.getWXPSLanResId());
        }
        if (pSSysMsgTemplBase.isWXPSLanResNameDirty() && (bl || pSSysMsgTemplBase.getWXPSLanResName() != null)) {
            iDataObject.set(FIELD_WXPSLANRESNAME, (Object)pSSysMsgTemplBase.getWXPSLanResName());
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
        return PSSysMsgTemplBase.remove(this, n);
    }

    private static boolean remove(PSSysMsgTemplBase pSSysMsgTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysMsgTemplBase.resetCodeName();
                return true;
            }
            case 1: {
                pSSysMsgTemplBase.resetContent();
                return true;
            }
            case 2: {
                pSSysMsgTemplBase.resetContentPSDEFId();
                return true;
            }
            case 3: {
                pSSysMsgTemplBase.resetContentPSDEFName();
                return true;
            }
            case 4: {
                pSSysMsgTemplBase.resetContentPSLanResId();
                return true;
            }
            case 5: {
                pSSysMsgTemplBase.resetContentPSLanResName();
                return true;
            }
            case 6: {
                pSSysMsgTemplBase.resetContentType();
                return true;
            }
            case 7: {
                pSSysMsgTemplBase.resetContentTypePSDEFId();
                return true;
            }
            case 8: {
                pSSysMsgTemplBase.resetContentTypePSDEFName();
                return true;
            }
            case 9: {
                pSSysMsgTemplBase.resetCreateDate();
                return true;
            }
            case 10: {
                pSSysMsgTemplBase.resetCreateMan();
                return true;
            }
            case 11: {
                pSSysMsgTemplBase.resetCustomCode();
                return true;
            }
            case 12: {
                pSSysMsgTemplBase.resetCustomMode();
                return true;
            }
            case 13: {
                pSSysMsgTemplBase.resetDDContent();
                return true;
            }
            case 14: {
                pSSysMsgTemplBase.resetDDContentPSDEFId();
                return true;
            }
            case 15: {
                pSSysMsgTemplBase.resetDDContentPSDEFName();
                return true;
            }
            case 16: {
                pSSysMsgTemplBase.resetDDPSLanResId();
                return true;
            }
            case 17: {
                pSSysMsgTemplBase.resetDDPSLanResName();
                return true;
            }
            case 18: {
                pSSysMsgTemplBase.resetIMContent();
                return true;
            }
            case 19: {
                pSSysMsgTemplBase.resetIMContentPSDEFId();
                return true;
            }
            case 20: {
                pSSysMsgTemplBase.resetIMContentPSDEFName();
                return true;
            }
            case 21: {
                pSSysMsgTemplBase.resetIMPSLanResId();
                return true;
            }
            case 22: {
                pSSysMsgTemplBase.resetIMPSLanResName();
                return true;
            }
            case 23: {
                pSSysMsgTemplBase.resetLanPSDEFId();
                return true;
            }
            case 24: {
                pSSysMsgTemplBase.resetLanPSDEFName();
                return true;
            }
            case 25: {
                pSSysMsgTemplBase.resetLockFlag();
                return true;
            }
            case 26: {
                pSSysMsgTemplBase.resetMailGroupSend();
                return true;
            }
            case 27: {
                pSSysMsgTemplBase.resetMemo();
                return true;
            }
            case 28: {
                pSSysMsgTemplBase.resetMobTaskUrl();
                return true;
            }
            case 29: {
                pSSysMsgTemplBase.resetMobTaskUrlPSDEFId();
                return true;
            }
            case 30: {
                pSSysMsgTemplBase.resetMobTaskUrlPSDEFName();
                return true;
            }
            case 31: {
                pSSysMsgTemplBase.resetMsgTemplParams();
                return true;
            }
            case 32: {
                pSSysMsgTemplBase.resetMsgTemplTag();
                return true;
            }
            case 33: {
                pSSysMsgTemplBase.resetMsgTemplTag2();
                return true;
            }
            case 34: {
                pSSysMsgTemplBase.resetMsgTemplType();
                return true;
            }
            case 35: {
                pSSysMsgTemplBase.resetPSDEDSId();
                return true;
            }
            case 36: {
                pSSysMsgTemplBase.resetPSDEDSName();
                return true;
            }
            case 37: {
                pSSysMsgTemplBase.resetPSDEId();
                return true;
            }
            case 38: {
                pSSysMsgTemplBase.resetPSDEName();
                return true;
            }
            case 39: {
                pSSysMsgTemplBase.resetPSModuleId();
                return true;
            }
            case 40: {
                pSSysMsgTemplBase.resetPSModuleName();
                return true;
            }
            case 41: {
                pSSysMsgTemplBase.resetPSSysDynaModelId();
                return true;
            }
            case 42: {
                pSSysMsgTemplBase.resetPSSysDynaModelName();
                return true;
            }
            case 43: {
                pSSysMsgTemplBase.resetPSSysMsgTemplId();
                return true;
            }
            case 44: {
                pSSysMsgTemplBase.resetPSSysMsgTemplName();
                return true;
            }
            case 45: {
                pSSysMsgTemplBase.resetPSSysSFPluginId();
                return true;
            }
            case 46: {
                pSSysMsgTemplBase.resetPSSysSFPluginName();
                return true;
            }
            case 47: {
                pSSysMsgTemplBase.resetPSSystemId();
                return true;
            }
            case 48: {
                pSSysMsgTemplBase.resetPSSystemName();
                return true;
            }
            case 49: {
                pSSysMsgTemplBase.resetSMSContent();
                return true;
            }
            case 50: {
                pSSysMsgTemplBase.resetSMSContentPSDEFId();
                return true;
            }
            case 51: {
                pSSysMsgTemplBase.resetSMSContentPSDEFName();
                return true;
            }
            case 52: {
                pSSysMsgTemplBase.resetSMSPSLanResId();
                return true;
            }
            case 53: {
                pSSysMsgTemplBase.resetSMSPSLanResName();
                return true;
            }
            case 54: {
                pSSysMsgTemplBase.resetSubject();
                return true;
            }
            case 55: {
                pSSysMsgTemplBase.resetSubjectPSDEFId();
                return true;
            }
            case 56: {
                pSSysMsgTemplBase.resetSubjectPSDEFName();
                return true;
            }
            case 57: {
                pSSysMsgTemplBase.resetSubPSLanResId();
                return true;
            }
            case 58: {
                pSSysMsgTemplBase.resetSubPSLanResName();
                return true;
            }
            case 59: {
                pSSysMsgTemplBase.resetTaskUrl();
                return true;
            }
            case 60: {
                pSSysMsgTemplBase.resetTaskUrlPSDEFId();
                return true;
            }
            case 61: {
                pSSysMsgTemplBase.resetTaskUrlPSDEFName();
                return true;
            }
            case 62: {
                pSSysMsgTemplBase.resetTemplEngine();
                return true;
            }
            case 63: {
                pSSysMsgTemplBase.resetTemplTagPSDEFId();
                return true;
            }
            case 64: {
                pSSysMsgTemplBase.resetTemplTagPSDEFName();
                return true;
            }
            case 65: {
                pSSysMsgTemplBase.resetUpdateDate();
                return true;
            }
            case 66: {
                pSSysMsgTemplBase.resetUpdateMan();
                return true;
            }
            case 67: {
                pSSysMsgTemplBase.resetUser2PSDEFId();
                return true;
            }
            case 68: {
                pSSysMsgTemplBase.resetUser2PSDEFName();
                return true;
            }
            case 69: {
                pSSysMsgTemplBase.resetUserCat();
                return true;
            }
            case 70: {
                pSSysMsgTemplBase.resetUserPSDEFId();
                return true;
            }
            case 71: {
                pSSysMsgTemplBase.resetUserPSDEFName();
                return true;
            }
            case 72: {
                pSSysMsgTemplBase.resetUserTag();
                return true;
            }
            case 73: {
                pSSysMsgTemplBase.resetUserTag2();
                return true;
            }
            case 74: {
                pSSysMsgTemplBase.resetUserTag3();
                return true;
            }
            case 75: {
                pSSysMsgTemplBase.resetUserTag4();
                return true;
            }
            case 76: {
                pSSysMsgTemplBase.resetWCContent();
                return true;
            }
            case 77: {
                pSSysMsgTemplBase.resetWCContentPSDEFId();
                return true;
            }
            case 78: {
                pSSysMsgTemplBase.resetWCContentPSDEFName();
                return true;
            }
            case 79: {
                pSSysMsgTemplBase.resetWXPSLanResId();
                return true;
            }
            case 80: {
                pSSysMsgTemplBase.resetWXPSLanResName();
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
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.contentpsdef = pSDEField;
            }
            return this.contentpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getContentTypePSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContentTypePSDEF();
        }
        if (this.getContentTypePSDEFId() == null) {
            return null;
        }
        Integer n = this.objContentTypePSDEFLock;
        synchronized (n) {
            if (this.contenttypepsdef != null && DataTypeHelper.compare((int)25, (Object)this.getContentTypePSDEFId(), (Object)this.contenttypepsdef.getPSDEFieldId()) != 0L) {
                this.contenttypepsdef = null;
            }
            if (this.contenttypepsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getContentTypePSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.contenttypepsdef = pSDEField;
            }
            return this.contenttypepsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getDDContentPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDDContentPSDEF();
        }
        if (this.getDDContentPSDEFId() == null) {
            return null;
        }
        Integer n = this.objDDContentPSDEFLock;
        synchronized (n) {
            if (this.ddcontentpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getDDContentPSDEFId(), (Object)this.ddcontentpsdef.getPSDEFieldId()) != 0L) {
                this.ddcontentpsdef = null;
            }
            if (this.ddcontentpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getDDContentPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.ddcontentpsdef = pSDEField;
            }
            return this.ddcontentpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getIMContentPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIMContentPSDEF();
        }
        if (this.getIMContentPSDEFId() == null) {
            return null;
        }
        Integer n = this.objIMContentPSDEFLock;
        synchronized (n) {
            if (this.imcontentpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getIMContentPSDEFId(), (Object)this.imcontentpsdef.getPSDEFieldId()) != 0L) {
                this.imcontentpsdef = null;
            }
            if (this.imcontentpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getIMContentPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.imcontentpsdef = pSDEField;
            }
            return this.imcontentpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getLanPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLanPSDEF();
        }
        if (this.getLanPSDEFId() == null) {
            return null;
        }
        Integer n = this.objLanPSDEFLock;
        synchronized (n) {
            if (this.lanpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getLanPSDEFId(), (Object)this.lanpsdef.getPSDEFieldId()) != 0L) {
                this.lanpsdef = null;
            }
            if (this.lanpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getLanPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.lanpsdef = pSDEField;
            }
            return this.lanpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getMobTaskUrlPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobTaskUrlPSDEF();
        }
        if (this.getMobTaskUrlPSDEFId() == null) {
            return null;
        }
        Integer n = this.objMobTaskUrlPSDEFLock;
        synchronized (n) {
            if (this.mobtaskurlpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getMobTaskUrlPSDEFId(), (Object)this.mobtaskurlpsdef.getPSDEFieldId()) != 0L) {
                this.mobtaskurlpsdef = null;
            }
            if (this.mobtaskurlpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getMobTaskUrlPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.mobtaskurlpsdef = pSDEField;
            }
            return this.mobtaskurlpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getSMSContentPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSMSContentPSDEF();
        }
        if (this.getSMSContentPSDEFId() == null) {
            return null;
        }
        Integer n = this.objSMSContentPSDEFLock;
        synchronized (n) {
            if (this.smscontentpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getSMSContentPSDEFId(), (Object)this.smscontentpsdef.getPSDEFieldId()) != 0L) {
                this.smscontentpsdef = null;
            }
            if (this.smscontentpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getSMSContentPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.smscontentpsdef = pSDEField;
            }
            return this.smscontentpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getSubjectPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSubjectPSDEF();
        }
        if (this.getSubjectPSDEFId() == null) {
            return null;
        }
        Integer n = this.objSubjectPSDEFLock;
        synchronized (n) {
            if (this.subjectpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getSubjectPSDEFId(), (Object)this.subjectpsdef.getPSDEFieldId()) != 0L) {
                this.subjectpsdef = null;
            }
            if (this.subjectpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getSubjectPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.subjectpsdef = pSDEField;
            }
            return this.subjectpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getTaskUrlPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTaskUrlPSDEF();
        }
        if (this.getTaskUrlPSDEFId() == null) {
            return null;
        }
        Integer n = this.objTaskUrlPSDEFLock;
        synchronized (n) {
            if (this.taskurlpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getTaskUrlPSDEFId(), (Object)this.taskurlpsdef.getPSDEFieldId()) != 0L) {
                this.taskurlpsdef = null;
            }
            if (this.taskurlpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getTaskUrlPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.taskurlpsdef = pSDEField;
            }
            return this.taskurlpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getTemplTagPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplTagPSDEF();
        }
        if (this.getTemplTagPSDEFId() == null) {
            return null;
        }
        Integer n = this.objTemplTagPSDEFLock;
        synchronized (n) {
            if (this.templtagpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getTemplTagPSDEFId(), (Object)this.templtagpsdef.getPSDEFieldId()) != 0L) {
                this.templtagpsdef = null;
            }
            if (this.templtagpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getTemplTagPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.templtagpsdef = pSDEField;
            }
            return this.templtagpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getUser2PSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUser2PSDEF();
        }
        if (this.getUser2PSDEFId() == null) {
            return null;
        }
        Integer n = this.objUser2PSDEFLock;
        synchronized (n) {
            if (this.user2psdef != null && DataTypeHelper.compare((int)25, (Object)this.getUser2PSDEFId(), (Object)this.user2psdef.getPSDEFieldId()) != 0L) {
                this.user2psdef = null;
            }
            if (this.user2psdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getUser2PSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.user2psdef = pSDEField;
            }
            return this.user2psdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getUserPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserPSDEF();
        }
        if (this.getUserPSDEFId() == null) {
            return null;
        }
        Integer n = this.objUserPSDEFLock;
        synchronized (n) {
            if (this.userpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getUserPSDEFId(), (Object)this.userpsdef.getPSDEFieldId()) != 0L) {
                this.userpsdef = null;
            }
            if (this.userpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getUserPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.userpsdef = pSDEField;
            }
            return this.userpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getWCContentPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWCContentPSDEF();
        }
        if (this.getWCContentPSDEFId() == null) {
            return null;
        }
        Integer n = this.objWCContentPSDEFLock;
        synchronized (n) {
            if (this.wccontentpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getWCContentPSDEFId(), (Object)this.wccontentpsdef.getPSDEFieldId()) != 0L) {
                this.wccontentpsdef = null;
            }
            if (this.wccontentpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getWCContentPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.wccontentpsdef = pSDEField;
            }
            return this.wccontentpsdef;
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
                pSLanguageResService.autoGet((IEntity)pSLanguageRes);
                this.contentpslanres = pSLanguageRes;
            }
            return this.contentpslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getDDPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDDPSLanRes();
        }
        if (this.getDDPSLanResId() == null) {
            return null;
        }
        Integer n = this.objDDPSLanResLock;
        synchronized (n) {
            if (this.ddpslanres != null && DataTypeHelper.compare((int)25, (Object)this.getDDPSLanResId(), (Object)this.ddpslanres.getPSLanguageResId()) != 0L) {
                this.ddpslanres = null;
            }
            if (this.ddpslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getDDPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet((IEntity)pSLanguageRes);
                this.ddpslanres = pSLanguageRes;
            }
            return this.ddpslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getIMPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIMPSLanRes();
        }
        if (this.getIMPSLanResId() == null) {
            return null;
        }
        Integer n = this.objIMPSLanResLock;
        synchronized (n) {
            if (this.impslanres != null && DataTypeHelper.compare((int)25, (Object)this.getIMPSLanResId(), (Object)this.impslanres.getPSLanguageResId()) != 0L) {
                this.impslanres = null;
            }
            if (this.impslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getIMPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet((IEntity)pSLanguageRes);
                this.impslanres = pSLanguageRes;
            }
            return this.impslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getSMSPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSMSPSLanRes();
        }
        if (this.getSMSPSLanResId() == null) {
            return null;
        }
        Integer n = this.objSMSPSLanResLock;
        synchronized (n) {
            if (this.smspslanres != null && DataTypeHelper.compare((int)25, (Object)this.getSMSPSLanResId(), (Object)this.smspslanres.getPSLanguageResId()) != 0L) {
                this.smspslanres = null;
            }
            if (this.smspslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getSMSPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet((IEntity)pSLanguageRes);
                this.smspslanres = pSLanguageRes;
            }
            return this.smspslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getSubPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSubPSLanRes();
        }
        if (this.getSubPSLanResId() == null) {
            return null;
        }
        Integer n = this.objSubPSLanResLock;
        synchronized (n) {
            if (this.subpslanres != null && DataTypeHelper.compare((int)25, (Object)this.getSubPSLanResId(), (Object)this.subpslanres.getPSLanguageResId()) != 0L) {
                this.subpslanres = null;
            }
            if (this.subpslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getSubPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet((IEntity)pSLanguageRes);
                this.subpslanres = pSLanguageRes;
            }
            return this.subpslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getWXPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWXPSLanRes();
        }
        if (this.getWXPSLanResId() == null) {
            return null;
        }
        Integer n = this.objWXPSLanResLock;
        synchronized (n) {
            if (this.wxpslanres != null && DataTypeHelper.compare((int)25, (Object)this.getWXPSLanResId(), (Object)this.wxpslanres.getPSLanguageResId()) != 0L) {
                this.wxpslanres = null;
            }
            if (this.wxpslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getWXPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet((IEntity)pSLanguageRes);
                this.wxpslanres = pSLanguageRes;
            }
            return this.wxpslanres;
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
                pSSysSFPluginService.autoGet((IEntity)pSSysSFPlugin);
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
                pSSystemService.autoGet((IEntity)pSSystem);
                this.pssystem = pSSystem;
            }
            return this.pssystem;
        }
    }

    private PSSysMsgTemplBase getProxyEntity() {
        return this.proxyPSSysMsgTemplBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysMsgTemplBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysMsgTemplBase) {
            this.proxyPSSysMsgTemplBase = (PSSysMsgTemplBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgTemplService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CONTENT, 1);
        fieldIndexMap.put(FIELD_CONTENTPSDEFID, 2);
        fieldIndexMap.put(FIELD_CONTENTPSDEFNAME, 3);
        fieldIndexMap.put(FIELD_CONTENTPSLANRESID, 4);
        fieldIndexMap.put(FIELD_CONTENTPSLANRESNAME, 5);
        fieldIndexMap.put(FIELD_CONTENTTYPE, 6);
        fieldIndexMap.put(FIELD_CONTENTTYPEPSDEFID, 7);
        fieldIndexMap.put(FIELD_CONTENTTYPEPSDEFNAME, 8);
        fieldIndexMap.put(FIELD_CREATEDATE, 9);
        fieldIndexMap.put(FIELD_CREATEMAN, 10);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 11);
        fieldIndexMap.put(FIELD_CUSTOMMODE, 12);
        fieldIndexMap.put(FIELD_DDCONTENT, 13);
        fieldIndexMap.put(FIELD_DDCONTENTPSDEFID, 14);
        fieldIndexMap.put(FIELD_DDCONTENTPSDEFNAME, 15);
        fieldIndexMap.put(FIELD_DDPSLANRESID, 16);
        fieldIndexMap.put(FIELD_DDPSLANRESNAME, 17);
        fieldIndexMap.put(FIELD_IMCONTENT, 18);
        fieldIndexMap.put(FIELD_IMCONTENTPSDEFID, 19);
        fieldIndexMap.put(FIELD_IMCONTENTPSDEFNAME, 20);
        fieldIndexMap.put(FIELD_IMPSLANRESID, 21);
        fieldIndexMap.put(FIELD_IMPSLANRESNAME, 22);
        fieldIndexMap.put(FIELD_LANPSDEFID, 23);
        fieldIndexMap.put(FIELD_LANPSDEFNAME, 24);
        fieldIndexMap.put(FIELD_LOCKFLAG, 25);
        fieldIndexMap.put(FIELD_MAILGROUPSEND, 26);
        fieldIndexMap.put(FIELD_MEMO, 27);
        fieldIndexMap.put(FIELD_MOBTASKURL, 28);
        fieldIndexMap.put(FIELD_MOBTASKURLPSDEFID, 29);
        fieldIndexMap.put(FIELD_MOBTASKURLPSDEFNAME, 30);
        fieldIndexMap.put(FIELD_MSGTEMPLPARAMS, 31);
        fieldIndexMap.put(FIELD_MSGTEMPLTAG, 32);
        fieldIndexMap.put(FIELD_MSGTEMPLTAG2, 33);
        fieldIndexMap.put(FIELD_MSGTEMPLTYPE, 34);
        fieldIndexMap.put(FIELD_PSDEDSID, 35);
        fieldIndexMap.put(FIELD_PSDEDSNAME, 36);
        fieldIndexMap.put(FIELD_PSDEID, 37);
        fieldIndexMap.put(FIELD_PSDENAME, 38);
        fieldIndexMap.put(FIELD_PSMODULEID, 39);
        fieldIndexMap.put(FIELD_PSMODULENAME, 40);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 41);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 42);
        fieldIndexMap.put(FIELD_PSSYSMSGTEMPLID, 43);
        fieldIndexMap.put(FIELD_PSSYSMSGTEMPLNAME, 44);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 45);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 46);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 47);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 48);
        fieldIndexMap.put(FIELD_SMSCONTENT, 49);
        fieldIndexMap.put(FIELD_SMSCONTENTPSDEFID, 50);
        fieldIndexMap.put(FIELD_SMSCONTENTPSDEFNAME, 51);
        fieldIndexMap.put(FIELD_SMSPSLANRESID, 52);
        fieldIndexMap.put(FIELD_SMSPSLANRESNAME, 53);
        fieldIndexMap.put(FIELD_SUBJECT, 54);
        fieldIndexMap.put(FIELD_SUBJECTPSDEFID, 55);
        fieldIndexMap.put(FIELD_SUBJECTPSDEFNAME, 56);
        fieldIndexMap.put(FIELD_SUBPSLANRESID, 57);
        fieldIndexMap.put(FIELD_SUBPSLANRESNAME, 58);
        fieldIndexMap.put(FIELD_TASKURL, 59);
        fieldIndexMap.put(FIELD_TASKURLPSDEFID, 60);
        fieldIndexMap.put(FIELD_TASKURLPSDEFNAME, 61);
        fieldIndexMap.put(FIELD_TEMPLENGINE, 62);
        fieldIndexMap.put(FIELD_TEMPLTAGPSDEFID, 63);
        fieldIndexMap.put(FIELD_TEMPLTAGPSDEFNAME, 64);
        fieldIndexMap.put(FIELD_UPDATEDATE, 65);
        fieldIndexMap.put(FIELD_UPDATEMAN, 66);
        fieldIndexMap.put(FIELD_USER2PSDEFID, 67);
        fieldIndexMap.put(FIELD_USER2PSDEFNAME, 68);
        fieldIndexMap.put(FIELD_USERCAT, 69);
        fieldIndexMap.put(FIELD_USERPSDEFID, 70);
        fieldIndexMap.put(FIELD_USERPSDEFNAME, 71);
        fieldIndexMap.put(FIELD_USERTAG, 72);
        fieldIndexMap.put(FIELD_USERTAG2, 73);
        fieldIndexMap.put(FIELD_USERTAG3, 74);
        fieldIndexMap.put(FIELD_USERTAG4, 75);
        fieldIndexMap.put(FIELD_WCCONTENT, 76);
        fieldIndexMap.put(FIELD_WCCONTENTPSDEFID, 77);
        fieldIndexMap.put(FIELD_WCCONTENTPSDEFNAME, 78);
        fieldIndexMap.put(FIELD_WXPSLANRESID, 79);
        fieldIndexMap.put(FIELD_WXPSLANRESNAME, 80);
    }
}

