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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQuery;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSync;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFValueRule;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMainState;
import net.ibizsys.pscore.srv.dedesign.entity.PSDENotify;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataQueryService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSyncService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFValueRuleService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMainStateService;
import net.ibizsys.pscore.srv.dedesign.service.PSDENotifyService;
import net.ibizsys.pscore.srv.dedesign.service.PSDERService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDELogicNode;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSequence;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTranslator;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysValueRule;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDELogicNodeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSequenceService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysTranslatorService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysValueRuleService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEActionLogicBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEActionLogicBase.class);
    public static final String FIELD_ATTACHMODE = "ATTACHMODE";
    public static final String FIELD_CLONEPARAMFLAG = "CLONEPARAMFLAG";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_DATASYNCEVENT = "DATASYNCEVENT";
    public static final String FIELD_DSTPSDEACTIONID = "DSTPSDEACTIONID";
    public static final String FIELD_DSTPSDEACTIONNAME = "DSTPSDEACTIONNAME";
    public static final String FIELD_DSTPSDEDATAQUERYID = "DSTPSDEDATAQUERYID";
    public static final String FIELD_DSTPSDEDATAQUERYNAME = "DSTPSDEDATAQUERYNAME";
    public static final String FIELD_DSTPSDEDATASETID = "DSTPSDEDATASETID";
    public static final String FIELD_DSTPSDEDATASETNAME = "DSTPSDEDATASETNAME";
    public static final String FIELD_DSTPSDEID = "DSTPSDEID";
    public static final String FIELD_DSTPSDELOGICID = "DSTPSDELOGICID";
    public static final String FIELD_DSTPSDELOGICNAME = "DSTPSDELOGICNAME";
    public static final String FIELD_DSTPSDENAME = "DSTPSDENAME";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_ERRORCODE = "ERRORCODE";
    public static final String FIELD_ERRORMSG = "ERRORMSG";
    public static final String FIELD_ERRORPSLANRESID = "ERRORPSLANRESID";
    public static final String FIELD_ERRORPSLANRESNAME = "ERRORPSLANRESNAME";
    public static final String FIELD_EXCEPTIONOBJ = "EXCEPTIONOBJ";
    public static final String FIELD_IGNOREEXCEPTION = "IGNOREEXCEPTION";
    public static final String FIELD_INTERNALLOGIC = "INTERNALLOGIC";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_LOGICHOLDER = "LOGICHOLDER";
    public static final String FIELD_MAJORPSDERID = "MAJORPSDERID";
    public static final String FIELD_MAJORPSDERNAME = "MAJORPSDERNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MINORPSDERID = "MINORPSDERID";
    public static final String FIELD_MINORPSDERNAME = "MINORPSDERNAME";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PREPARELAST = "PREPARELAST";
    public static final String FIELD_PROPERTYMAP = "PROPERTYMAP";
    public static final String FIELD_PSDEACTIONID = "PSDEACTIONID";
    public static final String FIELD_PSDEACTIONLOGICID = "PSDEACTIONLOGICID";
    public static final String FIELD_PSDEACTIONLOGICNAME = "PSDEACTIONLOGICNAME";
    public static final String FIELD_PSDEACTIONNAME = "PSDEACTIONNAME";
    public static final String FIELD_PSDEDATASYNCID = "PSDEDATASYNCID";
    public static final String FIELD_PSDEDATASYNCNAME = "PSDEDATASYNCNAME";
    public static final String FIELD_PSDEFID = "PSDEFID";
    public static final String FIELD_PSDEFNAME = "PSDEFNAME";
    public static final String FIELD_PSDEFVALUERULEID = "PSDEFVALUERULEID";
    public static final String FIELD_PSDEFVALUERULENAME = "PSDEFVALUERULENAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDELOGICID = "PSDELOGICID";
    public static final String FIELD_PSDELOGICNAME = "PSDELOGICNAME";
    public static final String FIELD_PSDEMAINSTATEID = "PSDEMAINSTATEID";
    public static final String FIELD_PSDEMAINSTATENAME = "PSDEMAINSTATENAME";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDENOTIFYID = "PSDENOTIFYID";
    public static final String FIELD_PSDENOTIFYNAME = "PSDENOTIFYNAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSSYSDELOGICNODEID = "PSSYSDELOGICNODEID";
    public static final String FIELD_PSSYSDELOGICNODENAME = "PSSYSDELOGICNODENAME";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_PSSYSSEQUENCEID = "PSSYSSEQUENCEID";
    public static final String FIELD_PSSYSSEQUENCENAME = "PSSYSSEQUENCENAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_PSSYSTRANSLATORID = "PSSYSTRANSLATORID";
    public static final String FIELD_PSSYSTRANSLATORNAME = "PSSYSTRANSLATORNAME";
    public static final String FIELD_PSSYSVALUERULEID = "PSSYSVALUERULEID";
    public static final String FIELD_PSSYSVALUERULENAME = "PSSYSVALUERULENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_ATTACHMODE = 0;
    private static final int INDEX_CLONEPARAMFLAG = 1;
    private static final int INDEX_CODENAME = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEMAN = 4;
    private static final int INDEX_CUSTOMCODE = 5;
    private static final int INDEX_DATASYNCEVENT = 6;
    private static final int INDEX_DSTPSDEACTIONID = 7;
    private static final int INDEX_DSTPSDEACTIONNAME = 8;
    private static final int INDEX_DSTPSDEDATAQUERYID = 9;
    private static final int INDEX_DSTPSDEDATAQUERYNAME = 10;
    private static final int INDEX_DSTPSDEDATASETID = 11;
    private static final int INDEX_DSTPSDEDATASETNAME = 12;
    private static final int INDEX_DSTPSDEID = 13;
    private static final int INDEX_DSTPSDELOGICID = 14;
    private static final int INDEX_DSTPSDELOGICNAME = 15;
    private static final int INDEX_DSTPSDENAME = 16;
    private static final int INDEX_DYNAMODELFLAG = 17;
    private static final int INDEX_ERRORCODE = 18;
    private static final int INDEX_ERRORMSG = 19;
    private static final int INDEX_ERRORPSLANRESID = 20;
    private static final int INDEX_ERRORPSLANRESNAME = 21;
    private static final int INDEX_EXCEPTIONOBJ = 22;
    private static final int INDEX_IGNOREEXCEPTION = 23;
    private static final int INDEX_INTERNALLOGIC = 24;
    private static final int INDEX_LOCKFLAG = 25;
    private static final int INDEX_LOGICHOLDER = 26;
    private static final int INDEX_MAJORPSDERID = 27;
    private static final int INDEX_MAJORPSDERNAME = 28;
    private static final int INDEX_MEMO = 29;
    private static final int INDEX_MINORPSDERID = 30;
    private static final int INDEX_MINORPSDERNAME = 31;
    private static final int INDEX_ORDERVALUE = 32;
    private static final int INDEX_PREPARELAST = 33;
    private static final int INDEX_PROPERTYMAP = 34;
    private static final int INDEX_PSDEACTIONID = 35;
    private static final int INDEX_PSDEACTIONLOGICID = 36;
    private static final int INDEX_PSDEACTIONLOGICNAME = 37;
    private static final int INDEX_PSDEACTIONNAME = 38;
    private static final int INDEX_PSDEDATASYNCID = 39;
    private static final int INDEX_PSDEDATASYNCNAME = 40;
    private static final int INDEX_PSDEFID = 41;
    private static final int INDEX_PSDEFNAME = 42;
    private static final int INDEX_PSDEFVALUERULEID = 43;
    private static final int INDEX_PSDEFVALUERULENAME = 44;
    private static final int INDEX_PSDEID = 45;
    private static final int INDEX_PSDELOGICID = 46;
    private static final int INDEX_PSDELOGICNAME = 47;
    private static final int INDEX_PSDEMAINSTATEID = 48;
    private static final int INDEX_PSDEMAINSTATENAME = 49;
    private static final int INDEX_PSDENAME = 50;
    private static final int INDEX_PSDENOTIFYID = 51;
    private static final int INDEX_PSDENOTIFYNAME = 52;
    private static final int INDEX_PSDYNAINSTID = 53;
    private static final int INDEX_PSSYSDELOGICNODEID = 54;
    private static final int INDEX_PSSYSDELOGICNODENAME = 55;
    private static final int INDEX_PSSYSPFPLUGINID = 56;
    private static final int INDEX_PSSYSPFPLUGINNAME = 57;
    private static final int INDEX_PSSYSSEQUENCEID = 58;
    private static final int INDEX_PSSYSSEQUENCENAME = 59;
    private static final int INDEX_PSSYSSFPLUGINID = 60;
    private static final int INDEX_PSSYSSFPLUGINNAME = 61;
    private static final int INDEX_PSSYSTRANSLATORID = 62;
    private static final int INDEX_PSSYSTRANSLATORNAME = 63;
    private static final int INDEX_PSSYSVALUERULEID = 64;
    private static final int INDEX_PSSYSVALUERULENAME = 65;
    private static final int INDEX_UPDATEDATE = 66;
    private static final int INDEX_UPDATEMAN = 67;
    private static final int INDEX_USERCAT = 68;
    private static final int INDEX_USERTAG = 69;
    private static final int INDEX_USERTAG2 = 70;
    private static final int INDEX_USERTAG3 = 71;
    private static final int INDEX_USERTAG4 = 72;
    private static final int INDEX_VALIDFLAG = 73;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEActionLogicBase proxyPSDEActionLogicBase = null;
    private boolean attachmodeDirtyFlag = false;
    private boolean cloneparamflagDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean datasynceventDirtyFlag = false;
    private boolean dstpsdeactionidDirtyFlag = false;
    private boolean dstpsdeactionnameDirtyFlag = false;
    private boolean dstpsdedataqueryidDirtyFlag = false;
    private boolean dstpsdedataquerynameDirtyFlag = false;
    private boolean dstpsdedatasetidDirtyFlag = false;
    private boolean dstpsdedatasetnameDirtyFlag = false;
    private boolean dstpsdeidDirtyFlag = false;
    private boolean dstpsdelogicidDirtyFlag = false;
    private boolean dstpsdelogicnameDirtyFlag = false;
    private boolean dstpsdenameDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean errorcodeDirtyFlag = false;
    private boolean errormsgDirtyFlag = false;
    private boolean errorpslanresidDirtyFlag = false;
    private boolean errorpslanresnameDirtyFlag = false;
    private boolean exceptionobjDirtyFlag = false;
    private boolean ignoreexceptionDirtyFlag = false;
    private boolean internallogicDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean logicholderDirtyFlag = false;
    private boolean majorpsderidDirtyFlag = false;
    private boolean majorpsdernameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean minorpsderidDirtyFlag = false;
    private boolean minorpsdernameDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean preparelastDirtyFlag = false;
    private boolean propertymapDirtyFlag = false;
    private boolean psdeactionidDirtyFlag = false;
    private boolean psdeactionlogicidDirtyFlag = false;
    private boolean psdeactionlogicnameDirtyFlag = false;
    private boolean psdeactionnameDirtyFlag = false;
    private boolean psdedatasyncidDirtyFlag = false;
    private boolean psdedatasyncnameDirtyFlag = false;
    private boolean psdefidDirtyFlag = false;
    private boolean psdefnameDirtyFlag = false;
    private boolean psdefvalueruleidDirtyFlag = false;
    private boolean psdefvaluerulenameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdelogicidDirtyFlag = false;
    private boolean psdelogicnameDirtyFlag = false;
    private boolean psdemainstateidDirtyFlag = false;
    private boolean psdemainstatenameDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdenotifyidDirtyFlag = false;
    private boolean psdenotifynameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pssysdelogicnodeidDirtyFlag = false;
    private boolean pssysdelogicnodenameDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean pssyssequenceidDirtyFlag = false;
    private boolean pssyssequencenameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean pssystranslatoridDirtyFlag = false;
    private boolean pssystranslatornameDirtyFlag = false;
    private boolean pssysvalueruleidDirtyFlag = false;
    private boolean pssysvaluerulenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="attachmode")
    private String attachmode;
    @Column(name="cloneparamflag")
    private Integer cloneparamflag;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customcode")
    private String customcode;
    @Column(name="datasyncevent")
    private Integer datasyncevent;
    @Column(name="dstpsdeactionid")
    private String dstpsdeactionid;
    @Column(name="dstpsdeactionname")
    private String dstpsdeactionname;
    @Column(name="dstpsdedataqueryid")
    private String dstpsdedataqueryid;
    @Column(name="dstpsdedataqueryname")
    private String dstpsdedataqueryname;
    @Column(name="dstpsdedatasetid")
    private String dstpsdedatasetid;
    @Column(name="dstpsdedatasetname")
    private String dstpsdedatasetname;
    @Column(name="dstpsdeid")
    private String dstpsdeid;
    @Column(name="dstpsdelogicid")
    private String dstpsdelogicid;
    @Column(name="dstpsdelogicname")
    private String dstpsdelogicname;
    @Column(name="dstpsdename")
    private String dstpsdename;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="errorcode")
    private Integer errorcode;
    @Column(name="errormsg")
    private String errormsg;
    @Column(name="errorpslanresid")
    private String errorpslanresid;
    @Column(name="errorpslanresname")
    private String errorpslanresname;
    @Column(name="exceptionobj")
    private String exceptionobj;
    @Column(name="ignoreexception")
    private Integer ignoreexception;
    @Column(name="internallogic")
    private Integer internallogic;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="logicholder")
    private Integer logicholder;
    @Column(name="majorpsderid")
    private String majorpsderid;
    @Column(name="majorpsdername")
    private String majorpsdername;
    @Column(name="memo")
    private String memo;
    @Column(name="minorpsderid")
    private String minorpsderid;
    @Column(name="minorpsdername")
    private String minorpsdername;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="preparelast")
    private Integer preparelast;
    @Column(name="propertymap")
    private String propertymap;
    @Column(name="psdeactionid")
    private String psdeactionid;
    @Column(name="psdeactionlogicid")
    private String psdeactionlogicid;
    @Column(name="psdeactionlogicname")
    private String psdeactionlogicname;
    @Column(name="psdeactionname")
    private String psdeactionname;
    @Column(name="psdedatasyncid")
    private String psdedatasyncid;
    @Column(name="psdedatasyncname")
    private String psdedatasyncname;
    @Column(name="psdefid")
    private String psdefid;
    @Column(name="psdefname")
    private String psdefname;
    @Column(name="psdefvalueruleid")
    private String psdefvalueruleid;
    @Column(name="psdefvaluerulename")
    private String psdefvaluerulename;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdelogicid")
    private String psdelogicid;
    @Column(name="psdelogicname")
    private String psdelogicname;
    @Column(name="psdemainstateid")
    private String psdemainstateid;
    @Column(name="psdemainstatename")
    private String psdemainstatename;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdenotifyid")
    private String psdenotifyid;
    @Column(name="psdenotifyname")
    private String psdenotifyname;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="pssysdelogicnodeid")
    private String pssysdelogicnodeid;
    @Column(name="pssysdelogicnodename")
    private String pssysdelogicnodename;
    @Column(name="pssyspfpluginid")
    private String pssyspfpluginid;
    @Column(name="pssyspfpluginname")
    private String pssyspfpluginname;
    @Column(name="pssyssequenceid")
    private String pssyssequenceid;
    @Column(name="pssyssequencename")
    private String pssyssequencename;
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
    @Column(name="pssystranslatorid")
    private String pssystranslatorid;
    @Column(name="pssystranslatorname")
    private String pssystranslatorname;
    @Column(name="pssysvalueruleid")
    private String pssysvalueruleid;
    @Column(name="pssysvaluerulename")
    private String pssysvaluerulename;
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
    private Integer objDstPSDELock = new Integer(1);
    private PSDataEntity dstpsde = null;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objDstPSDEActionLock = new Integer(1);
    private PSDEAction dstpsdeaction = null;
    private Integer objPSDEActionLock = new Integer(1);
    private PSDEAction psdeaction = null;
    private Integer objDstPSDEDataQueryLock = new Integer(1);
    private PSDEDataQuery dstpsdedataquery = null;
    private Integer objDstPSDEDataSetLock = new Integer(1);
    private PSDEDataSet dstpsdedataset = null;
    private Integer objPSDEDataSyncLock = new Integer(1);
    private PSDEDataSync psdedatasync = null;
    private Integer objPSDEFLock = new Integer(1);
    private PSDEField psdef = null;
    private Integer objPSDEFValueRuleLock = new Integer(1);
    private PSDEFValueRule psdefvaluerule = null;
    private Integer objDstPSDELogicLock = new Integer(1);
    private PSDELogic dstpsdelogic = null;
    private Integer objPSDELogicLock = new Integer(1);
    private PSDELogic psdelogic = null;
    private Integer objPSDEMainStateLock = new Integer(1);
    private PSDEMainState psdemainstate = null;
    private Integer objPSDENotifyLock = new Integer(1);
    private PSDENotify psdenotify = null;
    private Integer objMajorPSDEIdLock = new Integer(1);
    private PSDER majorpsdeid = null;
    private Integer objMinorPSDERLock = new Integer(1);
    private PSDER minorpsder = null;
    private Integer objErrorPSLanResLock = new Integer(1);
    private PSLanguageRes errorpslanres = null;
    private Integer objPSSysDELogicNodeLock = new Integer(1);
    private PSSysDELogicNode pssysdelogicnode = null;
    private Integer objPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin pssyspfplugin = null;
    private Integer objPSSysSequenceLock = new Integer(1);
    private PSSysSequence pssyssequence = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
    private Integer objPSSysTranslatorLock = new Integer(1);
    private PSSysTranslator pssystranslator = null;
    private Integer objPSSysValueRuleLock = new Integer(1);
    private PSSysValueRule pssysvaluerule = null;

    public void setAttachMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAttachMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.attachmode = string;
        this.attachmodeDirtyFlag = true;
    }

    public String getAttachMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAttachMode();
        }
        return this.attachmode;
    }

    public boolean isAttachModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAttachModeDirty();
        }
        return this.attachmodeDirtyFlag;
    }

    public void resetAttachMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAttachMode();
            return;
        }
        this.attachmodeDirtyFlag = false;
        this.attachmode = null;
    }

    public void setCloneParamFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCloneParamFlag(n);
            return;
        }
        this.cloneparamflag = n;
        this.cloneparamflagDirtyFlag = true;
    }

    public Integer getCloneParamFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCloneParamFlag();
        }
        return this.cloneparamflag;
    }

    public boolean isCloneParamFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCloneParamFlagDirty();
        }
        return this.cloneparamflagDirtyFlag;
    }

    public void resetCloneParamFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCloneParamFlag();
            return;
        }
        this.cloneparamflagDirtyFlag = false;
        this.cloneparamflag = null;
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

    public void setDataSyncEvent(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataSyncEvent(n);
            return;
        }
        this.datasyncevent = n;
        this.datasynceventDirtyFlag = true;
    }

    public Integer getDataSyncEvent() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataSyncEvent();
        }
        return this.datasyncevent;
    }

    public boolean isDataSyncEventDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataSyncEventDirty();
        }
        return this.datasynceventDirtyFlag;
    }

    public void resetDataSyncEvent() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataSyncEvent();
            return;
        }
        this.datasynceventDirtyFlag = false;
        this.datasyncevent = null;
    }

    public void setDstPSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdeactionid = string;
        this.dstpsdeactionidDirtyFlag = true;
    }

    public String getDstPSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEActionId();
        }
        return this.dstpsdeactionid;
    }

    public boolean isDstPSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEActionIdDirty();
        }
        return this.dstpsdeactionidDirtyFlag;
    }

    public void resetDstPSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEActionId();
            return;
        }
        this.dstpsdeactionidDirtyFlag = false;
        this.dstpsdeactionid = null;
    }

    public void setDstPSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdeactionname = string;
        this.dstpsdeactionnameDirtyFlag = true;
    }

    public String getDstPSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEActionName();
        }
        return this.dstpsdeactionname;
    }

    public boolean isDstPSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEActionNameDirty();
        }
        return this.dstpsdeactionnameDirtyFlag;
    }

    public void resetDstPSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEActionName();
            return;
        }
        this.dstpsdeactionnameDirtyFlag = false;
        this.dstpsdeactionname = null;
    }

    public void setDstPSDEDataQueryId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEDataQueryId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdedataqueryid = string;
        this.dstpsdedataqueryidDirtyFlag = true;
    }

    public String getDstPSDEDataQueryId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEDataQueryId();
        }
        return this.dstpsdedataqueryid;
    }

    public boolean isDstPSDEDataQueryIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEDataQueryIdDirty();
        }
        return this.dstpsdedataqueryidDirtyFlag;
    }

    public void resetDstPSDEDataQueryId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEDataQueryId();
            return;
        }
        this.dstpsdedataqueryidDirtyFlag = false;
        this.dstpsdedataqueryid = null;
    }

    public void setDstPSDEDataQueryName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEDataQueryName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdedataqueryname = string;
        this.dstpsdedataquerynameDirtyFlag = true;
    }

    public String getDstPSDEDataQueryName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEDataQueryName();
        }
        return this.dstpsdedataqueryname;
    }

    public boolean isDstPSDEDataQueryNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEDataQueryNameDirty();
        }
        return this.dstpsdedataquerynameDirtyFlag;
    }

    public void resetDstPSDEDataQueryName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEDataQueryName();
            return;
        }
        this.dstpsdedataquerynameDirtyFlag = false;
        this.dstpsdedataqueryname = null;
    }

    public void setDstPSDEDataSetId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEDataSetId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdedatasetid = string;
        this.dstpsdedatasetidDirtyFlag = true;
    }

    public String getDstPSDEDataSetId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEDataSetId();
        }
        return this.dstpsdedatasetid;
    }

    public boolean isDstPSDEDataSetIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEDataSetIdDirty();
        }
        return this.dstpsdedatasetidDirtyFlag;
    }

    public void resetDstPSDEDataSetId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEDataSetId();
            return;
        }
        this.dstpsdedatasetidDirtyFlag = false;
        this.dstpsdedatasetid = null;
    }

    public void setDstPSDEDataSetName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEDataSetName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdedatasetname = string;
        this.dstpsdedatasetnameDirtyFlag = true;
    }

    public String getDstPSDEDataSetName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEDataSetName();
        }
        return this.dstpsdedatasetname;
    }

    public boolean isDstPSDEDataSetNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEDataSetNameDirty();
        }
        return this.dstpsdedatasetnameDirtyFlag;
    }

    public void resetDstPSDEDataSetName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEDataSetName();
            return;
        }
        this.dstpsdedatasetnameDirtyFlag = false;
        this.dstpsdedatasetname = null;
    }

    public void setDstPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdeid = string;
        this.dstpsdeidDirtyFlag = true;
    }

    public String getDstPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEId();
        }
        return this.dstpsdeid;
    }

    public boolean isDstPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEIdDirty();
        }
        return this.dstpsdeidDirtyFlag;
    }

    public void resetDstPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEId();
            return;
        }
        this.dstpsdeidDirtyFlag = false;
        this.dstpsdeid = null;
    }

    public void setDstPSDELogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDELogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdelogicid = string;
        this.dstpsdelogicidDirtyFlag = true;
    }

    public String getDstPSDELogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDELogicId();
        }
        return this.dstpsdelogicid;
    }

    public boolean isDstPSDELogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDELogicIdDirty();
        }
        return this.dstpsdelogicidDirtyFlag;
    }

    public void resetDstPSDELogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDELogicId();
            return;
        }
        this.dstpsdelogicidDirtyFlag = false;
        this.dstpsdelogicid = null;
    }

    public void setDstPSDELogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDELogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdelogicname = string;
        this.dstpsdelogicnameDirtyFlag = true;
    }

    public String getDstPSDELogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDELogicName();
        }
        return this.dstpsdelogicname;
    }

    public boolean isDstPSDELogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDELogicNameDirty();
        }
        return this.dstpsdelogicnameDirtyFlag;
    }

    public void resetDstPSDELogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDELogicName();
            return;
        }
        this.dstpsdelogicnameDirtyFlag = false;
        this.dstpsdelogicname = null;
    }

    public void setDstPSDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdename = string;
        this.dstpsdenameDirtyFlag = true;
    }

    public String getDstPSDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEName();
        }
        return this.dstpsdename;
    }

    public boolean isDstPSDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDENameDirty();
        }
        return this.dstpsdenameDirtyFlag;
    }

    public void resetDstPSDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEName();
            return;
        }
        this.dstpsdenameDirtyFlag = false;
        this.dstpsdename = null;
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

    public void setErrorCode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setErrorCode(n);
            return;
        }
        this.errorcode = n;
        this.errorcodeDirtyFlag = true;
    }

    public Integer getErrorCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getErrorCode();
        }
        return this.errorcode;
    }

    public boolean isErrorCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isErrorCodeDirty();
        }
        return this.errorcodeDirtyFlag;
    }

    public void resetErrorCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetErrorCode();
            return;
        }
        this.errorcodeDirtyFlag = false;
        this.errorcode = null;
    }

    public void setErrorMsg(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setErrorMsg(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.errormsg = string;
        this.errormsgDirtyFlag = true;
    }

    public String getErrorMsg() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getErrorMsg();
        }
        return this.errormsg;
    }

    public boolean isErrorMsgDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isErrorMsgDirty();
        }
        return this.errormsgDirtyFlag;
    }

    public void resetErrorMsg() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetErrorMsg();
            return;
        }
        this.errormsgDirtyFlag = false;
        this.errormsg = null;
    }

    public void setErrorPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setErrorPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.errorpslanresid = string;
        this.errorpslanresidDirtyFlag = true;
    }

    public String getErrorPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getErrorPSLanResId();
        }
        return this.errorpslanresid;
    }

    public boolean isErrorPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isErrorPSLanResIdDirty();
        }
        return this.errorpslanresidDirtyFlag;
    }

    public void resetErrorPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetErrorPSLanResId();
            return;
        }
        this.errorpslanresidDirtyFlag = false;
        this.errorpslanresid = null;
    }

    public void setErrorPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setErrorPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.errorpslanresname = string;
        this.errorpslanresnameDirtyFlag = true;
    }

    public String getErrorPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getErrorPSLanResName();
        }
        return this.errorpslanresname;
    }

    public boolean isErrorPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isErrorPSLanResNameDirty();
        }
        return this.errorpslanresnameDirtyFlag;
    }

    public void resetErrorPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetErrorPSLanResName();
            return;
        }
        this.errorpslanresnameDirtyFlag = false;
        this.errorpslanresname = null;
    }

    public void setExceptionObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExceptionObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.exceptionobj = string;
        this.exceptionobjDirtyFlag = true;
    }

    public String getExceptionObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExceptionObj();
        }
        return this.exceptionobj;
    }

    public boolean isExceptionObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExceptionObjDirty();
        }
        return this.exceptionobjDirtyFlag;
    }

    public void resetExceptionObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExceptionObj();
            return;
        }
        this.exceptionobjDirtyFlag = false;
        this.exceptionobj = null;
    }

    public void setIgnoreException(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIgnoreException(n);
            return;
        }
        this.ignoreexception = n;
        this.ignoreexceptionDirtyFlag = true;
    }

    public Integer getIgnoreException() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIgnoreException();
        }
        return this.ignoreexception;
    }

    public boolean isIgnoreExceptionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIgnoreExceptionDirty();
        }
        return this.ignoreexceptionDirtyFlag;
    }

    public void resetIgnoreException() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIgnoreException();
            return;
        }
        this.ignoreexceptionDirtyFlag = false;
        this.ignoreexception = null;
    }

    public void setInternalLogic(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInternalLogic(n);
            return;
        }
        this.internallogic = n;
        this.internallogicDirtyFlag = true;
    }

    public Integer getInternalLogic() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInternalLogic();
        }
        return this.internallogic;
    }

    public boolean isInternalLogicDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInternalLogicDirty();
        }
        return this.internallogicDirtyFlag;
    }

    public void resetInternalLogic() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInternalLogic();
            return;
        }
        this.internallogicDirtyFlag = false;
        this.internallogic = null;
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

    public void setLogicHolder(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicHolder(n);
            return;
        }
        this.logicholder = n;
        this.logicholderDirtyFlag = true;
    }

    public Integer getLogicHolder() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicHolder();
        }
        return this.logicholder;
    }

    public boolean isLogicHolderDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicHolderDirty();
        }
        return this.logicholderDirtyFlag;
    }

    public void resetLogicHolder() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicHolder();
            return;
        }
        this.logicholderDirtyFlag = false;
        this.logicholder = null;
    }

    public void setMajorPSDERId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMajorPSDERId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.majorpsderid = string;
        this.majorpsderidDirtyFlag = true;
    }

    public String getMajorPSDERId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorPSDERId();
        }
        return this.majorpsderid;
    }

    public boolean isMajorPSDERIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMajorPSDERIdDirty();
        }
        return this.majorpsderidDirtyFlag;
    }

    public void resetMajorPSDERId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMajorPSDERId();
            return;
        }
        this.majorpsderidDirtyFlag = false;
        this.majorpsderid = null;
    }

    public void setMajorPSDERName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMajorPSDERName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.majorpsdername = string;
        this.majorpsdernameDirtyFlag = true;
    }

    public String getMajorPSDERName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorPSDERName();
        }
        return this.majorpsdername;
    }

    public boolean isMajorPSDERNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMajorPSDERNameDirty();
        }
        return this.majorpsdernameDirtyFlag;
    }

    public void resetMajorPSDERName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMajorPSDERName();
            return;
        }
        this.majorpsdernameDirtyFlag = false;
        this.majorpsdername = null;
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

    public void setMinorPSDERId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinorPSDERId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.minorpsderid = string;
        this.minorpsderidDirtyFlag = true;
    }

    public String getMinorPSDERId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorPSDERId();
        }
        return this.minorpsderid;
    }

    public boolean isMinorPSDERIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinorPSDERIdDirty();
        }
        return this.minorpsderidDirtyFlag;
    }

    public void resetMinorPSDERId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinorPSDERId();
            return;
        }
        this.minorpsderidDirtyFlag = false;
        this.minorpsderid = null;
    }

    public void setMinorPSDERName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinorPSDERName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.minorpsdername = string;
        this.minorpsdernameDirtyFlag = true;
    }

    public String getMinorPSDERName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorPSDERName();
        }
        return this.minorpsdername;
    }

    public boolean isMinorPSDERNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinorPSDERNameDirty();
        }
        return this.minorpsdernameDirtyFlag;
    }

    public void resetMinorPSDERName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinorPSDERName();
            return;
        }
        this.minorpsdernameDirtyFlag = false;
        this.minorpsdername = null;
    }

    public void setOrderValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrderValue(n);
            return;
        }
        this.ordervalue = n;
        this.ordervalueDirtyFlag = true;
    }

    public Integer getOrderValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrderValue();
        }
        return this.ordervalue;
    }

    public boolean isOrderValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrderValueDirty();
        }
        return this.ordervalueDirtyFlag;
    }

    public void resetOrderValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrderValue();
            return;
        }
        this.ordervalueDirtyFlag = false;
        this.ordervalue = null;
    }

    public void setPrepareLast(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPrepareLast(n);
            return;
        }
        this.preparelast = n;
        this.preparelastDirtyFlag = true;
    }

    public Integer getPrepareLast() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPrepareLast();
        }
        return this.preparelast;
    }

    public boolean isPrepareLastDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPrepareLastDirty();
        }
        return this.preparelastDirtyFlag;
    }

    public void resetPrepareLast() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPrepareLast();
            return;
        }
        this.preparelastDirtyFlag = false;
        this.preparelast = null;
    }

    public void setPropertyMap(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPropertyMap(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.propertymap = string;
        this.propertymapDirtyFlag = true;
    }

    public String getPropertyMap() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPropertyMap();
        }
        return this.propertymap;
    }

    public boolean isPropertyMapDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPropertyMapDirty();
        }
        return this.propertymapDirtyFlag;
    }

    public void resetPropertyMap() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPropertyMap();
            return;
        }
        this.propertymapDirtyFlag = false;
        this.propertymap = null;
    }

    public void setPSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeactionid = string;
        this.psdeactionidDirtyFlag = true;
    }

    public String getPSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionId();
        }
        return this.psdeactionid;
    }

    public boolean isPSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEActionIdDirty();
        }
        return this.psdeactionidDirtyFlag;
    }

    public void resetPSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEActionId();
            return;
        }
        this.psdeactionidDirtyFlag = false;
        this.psdeactionid = null;
    }

    public void setPSDEActionLogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEActionLogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeactionlogicid = string;
        this.psdeactionlogicidDirtyFlag = true;
    }

    public String getPSDEActionLogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionLogicId();
        }
        return this.psdeactionlogicid;
    }

    public boolean isPSDEActionLogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEActionLogicIdDirty();
        }
        return this.psdeactionlogicidDirtyFlag;
    }

    public void resetPSDEActionLogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEActionLogicId();
            return;
        }
        this.psdeactionlogicidDirtyFlag = false;
        this.psdeactionlogicid = null;
    }

    public void setPSDEActionLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEActionLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeactionlogicname = string;
        this.psdeactionlogicnameDirtyFlag = true;
    }

    public String getPSDEActionLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionLogicName();
        }
        return this.psdeactionlogicname;
    }

    public boolean isPSDEActionLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEActionLogicNameDirty();
        }
        return this.psdeactionlogicnameDirtyFlag;
    }

    public void resetPSDEActionLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEActionLogicName();
            return;
        }
        this.psdeactionlogicnameDirtyFlag = false;
        this.psdeactionlogicname = null;
    }

    public void setPSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeactionname = string;
        this.psdeactionnameDirtyFlag = true;
    }

    public String getPSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionName();
        }
        return this.psdeactionname;
    }

    public boolean isPSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEActionNameDirty();
        }
        return this.psdeactionnameDirtyFlag;
    }

    public void resetPSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEActionName();
            return;
        }
        this.psdeactionnameDirtyFlag = false;
        this.psdeactionname = null;
    }

    public void setPSDEDataSyncId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataSyncId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedatasyncid = string;
        this.psdedatasyncidDirtyFlag = true;
    }

    public String getPSDEDataSyncId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataSyncId();
        }
        return this.psdedatasyncid;
    }

    public boolean isPSDEDataSyncIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataSyncIdDirty();
        }
        return this.psdedatasyncidDirtyFlag;
    }

    public void resetPSDEDataSyncId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataSyncId();
            return;
        }
        this.psdedatasyncidDirtyFlag = false;
        this.psdedatasyncid = null;
    }

    public void setPSDEDataSyncName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataSyncName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedatasyncname = string;
        this.psdedatasyncnameDirtyFlag = true;
    }

    public String getPSDEDataSyncName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataSyncName();
        }
        return this.psdedatasyncname;
    }

    public boolean isPSDEDataSyncNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataSyncNameDirty();
        }
        return this.psdedatasyncnameDirtyFlag;
    }

    public void resetPSDEDataSyncName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataSyncName();
            return;
        }
        this.psdedatasyncnameDirtyFlag = false;
        this.psdedatasyncname = null;
    }

    public void setPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefid = string;
        this.psdefidDirtyFlag = true;
    }

    public String getPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFId();
        }
        return this.psdefid;
    }

    public boolean isPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFIdDirty();
        }
        return this.psdefidDirtyFlag;
    }

    public void resetPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFId();
            return;
        }
        this.psdefidDirtyFlag = false;
        this.psdefid = null;
    }

    public void setPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefname = string;
        this.psdefnameDirtyFlag = true;
    }

    public String getPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFName();
        }
        return this.psdefname;
    }

    public boolean isPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFNameDirty();
        }
        return this.psdefnameDirtyFlag;
    }

    public void resetPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFName();
            return;
        }
        this.psdefnameDirtyFlag = false;
        this.psdefname = null;
    }

    public void setPSDEFValueRuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFValueRuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefvalueruleid = string;
        this.psdefvalueruleidDirtyFlag = true;
    }

    public String getPSDEFValueRuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFValueRuleId();
        }
        return this.psdefvalueruleid;
    }

    public boolean isPSDEFValueRuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFValueRuleIdDirty();
        }
        return this.psdefvalueruleidDirtyFlag;
    }

    public void resetPSDEFValueRuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFValueRuleId();
            return;
        }
        this.psdefvalueruleidDirtyFlag = false;
        this.psdefvalueruleid = null;
    }

    public void setPSDEFValueRuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFValueRuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefvaluerulename = string;
        this.psdefvaluerulenameDirtyFlag = true;
    }

    public String getPSDEFValueRuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFValueRuleName();
        }
        return this.psdefvaluerulename;
    }

    public boolean isPSDEFValueRuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFValueRuleNameDirty();
        }
        return this.psdefvaluerulenameDirtyFlag;
    }

    public void resetPSDEFValueRuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFValueRuleName();
            return;
        }
        this.psdefvaluerulenameDirtyFlag = false;
        this.psdefvaluerulename = null;
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

    public void setPSDEMainStateId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEMainStateId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdemainstateid = string;
        this.psdemainstateidDirtyFlag = true;
    }

    public String getPSDEMainStateId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMainStateId();
        }
        return this.psdemainstateid;
    }

    public boolean isPSDEMainStateIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEMainStateIdDirty();
        }
        return this.psdemainstateidDirtyFlag;
    }

    public void resetPSDEMainStateId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEMainStateId();
            return;
        }
        this.psdemainstateidDirtyFlag = false;
        this.psdemainstateid = null;
    }

    public void setPSDEMainStateName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEMainStateName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdemainstatename = string;
        this.psdemainstatenameDirtyFlag = true;
    }

    public String getPSDEMainStateName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMainStateName();
        }
        return this.psdemainstatename;
    }

    public boolean isPSDEMainStateNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEMainStateNameDirty();
        }
        return this.psdemainstatenameDirtyFlag;
    }

    public void resetPSDEMainStateName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEMainStateName();
            return;
        }
        this.psdemainstatenameDirtyFlag = false;
        this.psdemainstatename = null;
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

    public void setPSDENotifyId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDENotifyId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdenotifyid = string;
        this.psdenotifyidDirtyFlag = true;
    }

    public String getPSDENotifyId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDENotifyId();
        }
        return this.psdenotifyid;
    }

    public boolean isPSDENotifyIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDENotifyIdDirty();
        }
        return this.psdenotifyidDirtyFlag;
    }

    public void resetPSDENotifyId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDENotifyId();
            return;
        }
        this.psdenotifyidDirtyFlag = false;
        this.psdenotifyid = null;
    }

    public void setPSDENotifyName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDENotifyName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdenotifyname = string;
        this.psdenotifynameDirtyFlag = true;
    }

    public String getPSDENotifyName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDENotifyName();
        }
        return this.psdenotifyname;
    }

    public boolean isPSDENotifyNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDENotifyNameDirty();
        }
        return this.psdenotifynameDirtyFlag;
    }

    public void resetPSDENotifyName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDENotifyName();
            return;
        }
        this.psdenotifynameDirtyFlag = false;
        this.psdenotifyname = null;
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

    public void setPSSysDELogicNodeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDELogicNodeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdelogicnodeid = string;
        this.pssysdelogicnodeidDirtyFlag = true;
    }

    public String getPSSysDELogicNodeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDELogicNodeId();
        }
        return this.pssysdelogicnodeid;
    }

    public boolean isPSSysDELogicNodeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDELogicNodeIdDirty();
        }
        return this.pssysdelogicnodeidDirtyFlag;
    }

    public void resetPSSysDELogicNodeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDELogicNodeId();
            return;
        }
        this.pssysdelogicnodeidDirtyFlag = false;
        this.pssysdelogicnodeid = null;
    }

    public void setPSSysDELogicNodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDELogicNodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdelogicnodename = string;
        this.pssysdelogicnodenameDirtyFlag = true;
    }

    public String getPSSysDELogicNodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDELogicNodeName();
        }
        return this.pssysdelogicnodename;
    }

    public boolean isPSSysDELogicNodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDELogicNodeNameDirty();
        }
        return this.pssysdelogicnodenameDirtyFlag;
    }

    public void resetPSSysDELogicNodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDELogicNodeName();
            return;
        }
        this.pssysdelogicnodenameDirtyFlag = false;
        this.pssysdelogicnodename = null;
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

    public void setPSSysSequenceId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSequenceId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssequenceid = string;
        this.pssyssequenceidDirtyFlag = true;
    }

    public String getPSSysSequenceId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSequenceId();
        }
        return this.pssyssequenceid;
    }

    public boolean isPSSysSequenceIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSequenceIdDirty();
        }
        return this.pssyssequenceidDirtyFlag;
    }

    public void resetPSSysSequenceId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSequenceId();
            return;
        }
        this.pssyssequenceidDirtyFlag = false;
        this.pssyssequenceid = null;
    }

    public void setPSSysSequenceName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSequenceName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssequencename = string;
        this.pssyssequencenameDirtyFlag = true;
    }

    public String getPSSysSequenceName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSequenceName();
        }
        return this.pssyssequencename;
    }

    public boolean isPSSysSequenceNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSequenceNameDirty();
        }
        return this.pssyssequencenameDirtyFlag;
    }

    public void resetPSSysSequenceName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSequenceName();
            return;
        }
        this.pssyssequencenameDirtyFlag = false;
        this.pssyssequencename = null;
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

    public void setPSSysTranslatorId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTranslatorId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystranslatorid = string;
        this.pssystranslatoridDirtyFlag = true;
    }

    public String getPSSysTranslatorId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTranslatorId();
        }
        return this.pssystranslatorid;
    }

    public boolean isPSSysTranslatorIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTranslatorIdDirty();
        }
        return this.pssystranslatoridDirtyFlag;
    }

    public void resetPSSysTranslatorId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTranslatorId();
            return;
        }
        this.pssystranslatoridDirtyFlag = false;
        this.pssystranslatorid = null;
    }

    public void setPSSysTranslatorName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTranslatorName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystranslatorname = string;
        this.pssystranslatornameDirtyFlag = true;
    }

    public String getPSSysTranslatorName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTranslatorName();
        }
        return this.pssystranslatorname;
    }

    public boolean isPSSysTranslatorNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTranslatorNameDirty();
        }
        return this.pssystranslatornameDirtyFlag;
    }

    public void resetPSSysTranslatorName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTranslatorName();
            return;
        }
        this.pssystranslatornameDirtyFlag = false;
        this.pssystranslatorname = null;
    }

    public void setPSSysValueRuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysValueRuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysvalueruleid = string;
        this.pssysvalueruleidDirtyFlag = true;
    }

    public String getPSSysValueRuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysValueRuleId();
        }
        return this.pssysvalueruleid;
    }

    public boolean isPSSysValueRuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysValueRuleIdDirty();
        }
        return this.pssysvalueruleidDirtyFlag;
    }

    public void resetPSSysValueRuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysValueRuleId();
            return;
        }
        this.pssysvalueruleidDirtyFlag = false;
        this.pssysvalueruleid = null;
    }

    public void setPSSysValueRuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysValueRuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysvaluerulename = string;
        this.pssysvaluerulenameDirtyFlag = true;
    }

    public String getPSSysValueRuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysValueRuleName();
        }
        return this.pssysvaluerulename;
    }

    public boolean isPSSysValueRuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysValueRuleNameDirty();
        }
        return this.pssysvaluerulenameDirtyFlag;
    }

    public void resetPSSysValueRuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysValueRuleName();
            return;
        }
        this.pssysvaluerulenameDirtyFlag = false;
        this.pssysvaluerulename = null;
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

    protected void onReset() {
        PSDEActionLogicBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEActionLogicBase pSDEActionLogicBase) {
        pSDEActionLogicBase.resetAttachMode();
        pSDEActionLogicBase.resetCloneParamFlag();
        pSDEActionLogicBase.resetCodeName();
        pSDEActionLogicBase.resetCreateDate();
        pSDEActionLogicBase.resetCreateMan();
        pSDEActionLogicBase.resetCustomCode();
        pSDEActionLogicBase.resetDataSyncEvent();
        pSDEActionLogicBase.resetDstPSDEActionId();
        pSDEActionLogicBase.resetDstPSDEActionName();
        pSDEActionLogicBase.resetDstPSDEDataQueryId();
        pSDEActionLogicBase.resetDstPSDEDataQueryName();
        pSDEActionLogicBase.resetDstPSDEDataSetId();
        pSDEActionLogicBase.resetDstPSDEDataSetName();
        pSDEActionLogicBase.resetDstPSDEId();
        pSDEActionLogicBase.resetDstPSDELogicId();
        pSDEActionLogicBase.resetDstPSDELogicName();
        pSDEActionLogicBase.resetDstPSDEName();
        pSDEActionLogicBase.resetDynaModelFlag();
        pSDEActionLogicBase.resetErrorCode();
        pSDEActionLogicBase.resetErrorMsg();
        pSDEActionLogicBase.resetErrorPSLanResId();
        pSDEActionLogicBase.resetErrorPSLanResName();
        pSDEActionLogicBase.resetExceptionObj();
        pSDEActionLogicBase.resetIgnoreException();
        pSDEActionLogicBase.resetInternalLogic();
        pSDEActionLogicBase.resetLockFlag();
        pSDEActionLogicBase.resetLogicHolder();
        pSDEActionLogicBase.resetMajorPSDERId();
        pSDEActionLogicBase.resetMajorPSDERName();
        pSDEActionLogicBase.resetMemo();
        pSDEActionLogicBase.resetMinorPSDERId();
        pSDEActionLogicBase.resetMinorPSDERName();
        pSDEActionLogicBase.resetOrderValue();
        pSDEActionLogicBase.resetPrepareLast();
        pSDEActionLogicBase.resetPropertyMap();
        pSDEActionLogicBase.resetPSDEActionId();
        pSDEActionLogicBase.resetPSDEActionLogicId();
        pSDEActionLogicBase.resetPSDEActionLogicName();
        pSDEActionLogicBase.resetPSDEActionName();
        pSDEActionLogicBase.resetPSDEDataSyncId();
        pSDEActionLogicBase.resetPSDEDataSyncName();
        pSDEActionLogicBase.resetPSDEFId();
        pSDEActionLogicBase.resetPSDEFName();
        pSDEActionLogicBase.resetPSDEFValueRuleId();
        pSDEActionLogicBase.resetPSDEFValueRuleName();
        pSDEActionLogicBase.resetPSDEId();
        pSDEActionLogicBase.resetPSDELogicId();
        pSDEActionLogicBase.resetPSDELogicName();
        pSDEActionLogicBase.resetPSDEMainStateId();
        pSDEActionLogicBase.resetPSDEMainStateName();
        pSDEActionLogicBase.resetPSDEName();
        pSDEActionLogicBase.resetPSDENotifyId();
        pSDEActionLogicBase.resetPSDENotifyName();
        pSDEActionLogicBase.resetPSDynaInstId();
        pSDEActionLogicBase.resetPSSysDELogicNodeId();
        pSDEActionLogicBase.resetPSSysDELogicNodeName();
        pSDEActionLogicBase.resetPSSysPFPluginId();
        pSDEActionLogicBase.resetPSSysPFPluginName();
        pSDEActionLogicBase.resetPSSysSequenceId();
        pSDEActionLogicBase.resetPSSysSequenceName();
        pSDEActionLogicBase.resetPSSysSFPluginId();
        pSDEActionLogicBase.resetPSSysSFPluginName();
        pSDEActionLogicBase.resetPSSysTranslatorId();
        pSDEActionLogicBase.resetPSSysTranslatorName();
        pSDEActionLogicBase.resetPSSysValueRuleId();
        pSDEActionLogicBase.resetPSSysValueRuleName();
        pSDEActionLogicBase.resetUpdateDate();
        pSDEActionLogicBase.resetUpdateMan();
        pSDEActionLogicBase.resetUserCat();
        pSDEActionLogicBase.resetUserTag();
        pSDEActionLogicBase.resetUserTag2();
        pSDEActionLogicBase.resetUserTag3();
        pSDEActionLogicBase.resetUserTag4();
        pSDEActionLogicBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAttachModeDirty()) {
            hashMap.put(FIELD_ATTACHMODE, this.getAttachMode());
        }
        if (!bl || this.isCloneParamFlagDirty()) {
            hashMap.put(FIELD_CLONEPARAMFLAG, this.getCloneParamFlag());
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
        if (!bl || this.isCustomCodeDirty()) {
            hashMap.put(FIELD_CUSTOMCODE, this.getCustomCode());
        }
        if (!bl || this.isDataSyncEventDirty()) {
            hashMap.put(FIELD_DATASYNCEVENT, this.getDataSyncEvent());
        }
        if (!bl || this.isDstPSDEActionIdDirty()) {
            hashMap.put(FIELD_DSTPSDEACTIONID, this.getDstPSDEActionId());
        }
        if (!bl || this.isDstPSDEActionNameDirty()) {
            hashMap.put(FIELD_DSTPSDEACTIONNAME, this.getDstPSDEActionName());
        }
        if (!bl || this.isDstPSDEDataQueryIdDirty()) {
            hashMap.put(FIELD_DSTPSDEDATAQUERYID, this.getDstPSDEDataQueryId());
        }
        if (!bl || this.isDstPSDEDataQueryNameDirty()) {
            hashMap.put(FIELD_DSTPSDEDATAQUERYNAME, this.getDstPSDEDataQueryName());
        }
        if (!bl || this.isDstPSDEDataSetIdDirty()) {
            hashMap.put(FIELD_DSTPSDEDATASETID, this.getDstPSDEDataSetId());
        }
        if (!bl || this.isDstPSDEDataSetNameDirty()) {
            hashMap.put(FIELD_DSTPSDEDATASETNAME, this.getDstPSDEDataSetName());
        }
        if (!bl || this.isDstPSDEIdDirty()) {
            hashMap.put(FIELD_DSTPSDEID, this.getDstPSDEId());
        }
        if (!bl || this.isDstPSDELogicIdDirty()) {
            hashMap.put(FIELD_DSTPSDELOGICID, this.getDstPSDELogicId());
        }
        if (!bl || this.isDstPSDELogicNameDirty()) {
            hashMap.put(FIELD_DSTPSDELOGICNAME, this.getDstPSDELogicName());
        }
        if (!bl || this.isDstPSDENameDirty()) {
            hashMap.put(FIELD_DSTPSDENAME, this.getDstPSDEName());
        }
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isErrorCodeDirty()) {
            hashMap.put(FIELD_ERRORCODE, this.getErrorCode());
        }
        if (!bl || this.isErrorMsgDirty()) {
            hashMap.put(FIELD_ERRORMSG, this.getErrorMsg());
        }
        if (!bl || this.isErrorPSLanResIdDirty()) {
            hashMap.put(FIELD_ERRORPSLANRESID, this.getErrorPSLanResId());
        }
        if (!bl || this.isErrorPSLanResNameDirty()) {
            hashMap.put(FIELD_ERRORPSLANRESNAME, this.getErrorPSLanResName());
        }
        if (!bl || this.isExceptionObjDirty()) {
            hashMap.put(FIELD_EXCEPTIONOBJ, this.getExceptionObj());
        }
        if (!bl || this.isIgnoreExceptionDirty()) {
            hashMap.put(FIELD_IGNOREEXCEPTION, this.getIgnoreException());
        }
        if (!bl || this.isInternalLogicDirty()) {
            hashMap.put(FIELD_INTERNALLOGIC, this.getInternalLogic());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isLogicHolderDirty()) {
            hashMap.put(FIELD_LOGICHOLDER, this.getLogicHolder());
        }
        if (!bl || this.isMajorPSDERIdDirty()) {
            hashMap.put(FIELD_MAJORPSDERID, this.getMajorPSDERId());
        }
        if (!bl || this.isMajorPSDERNameDirty()) {
            hashMap.put(FIELD_MAJORPSDERNAME, this.getMajorPSDERName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMinorPSDERIdDirty()) {
            hashMap.put(FIELD_MINORPSDERID, this.getMinorPSDERId());
        }
        if (!bl || this.isMinorPSDERNameDirty()) {
            hashMap.put(FIELD_MINORPSDERNAME, this.getMinorPSDERName());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPrepareLastDirty()) {
            hashMap.put(FIELD_PREPARELAST, this.getPrepareLast());
        }
        if (!bl || this.isPropertyMapDirty()) {
            hashMap.put(FIELD_PROPERTYMAP, this.getPropertyMap());
        }
        if (!bl || this.isPSDEActionIdDirty()) {
            hashMap.put(FIELD_PSDEACTIONID, this.getPSDEActionId());
        }
        if (!bl || this.isPSDEActionLogicIdDirty()) {
            hashMap.put(FIELD_PSDEACTIONLOGICID, this.getPSDEActionLogicId());
        }
        if (!bl || this.isPSDEActionLogicNameDirty()) {
            hashMap.put(FIELD_PSDEACTIONLOGICNAME, this.getPSDEActionLogicName());
        }
        if (!bl || this.isPSDEActionNameDirty()) {
            hashMap.put(FIELD_PSDEACTIONNAME, this.getPSDEActionName());
        }
        if (!bl || this.isPSDEDataSyncIdDirty()) {
            hashMap.put(FIELD_PSDEDATASYNCID, this.getPSDEDataSyncId());
        }
        if (!bl || this.isPSDEDataSyncNameDirty()) {
            hashMap.put(FIELD_PSDEDATASYNCNAME, this.getPSDEDataSyncName());
        }
        if (!bl || this.isPSDEFIdDirty()) {
            hashMap.put(FIELD_PSDEFID, this.getPSDEFId());
        }
        if (!bl || this.isPSDEFNameDirty()) {
            hashMap.put(FIELD_PSDEFNAME, this.getPSDEFName());
        }
        if (!bl || this.isPSDEFValueRuleIdDirty()) {
            hashMap.put(FIELD_PSDEFVALUERULEID, this.getPSDEFValueRuleId());
        }
        if (!bl || this.isPSDEFValueRuleNameDirty()) {
            hashMap.put(FIELD_PSDEFVALUERULENAME, this.getPSDEFValueRuleName());
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
        if (!bl || this.isPSDEMainStateIdDirty()) {
            hashMap.put(FIELD_PSDEMAINSTATEID, this.getPSDEMainStateId());
        }
        if (!bl || this.isPSDEMainStateNameDirty()) {
            hashMap.put(FIELD_PSDEMAINSTATENAME, this.getPSDEMainStateName());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDENotifyIdDirty()) {
            hashMap.put(FIELD_PSDENOTIFYID, this.getPSDENotifyId());
        }
        if (!bl || this.isPSDENotifyNameDirty()) {
            hashMap.put(FIELD_PSDENOTIFYNAME, this.getPSDENotifyName());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSSysDELogicNodeIdDirty()) {
            hashMap.put(FIELD_PSSYSDELOGICNODEID, this.getPSSysDELogicNodeId());
        }
        if (!bl || this.isPSSysDELogicNodeNameDirty()) {
            hashMap.put(FIELD_PSSYSDELOGICNODENAME, this.getPSSysDELogicNodeName());
        }
        if (!bl || this.isPSSysPFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINID, this.getPSSysPFPluginId());
        }
        if (!bl || this.isPSSysPFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINNAME, this.getPSSysPFPluginName());
        }
        if (!bl || this.isPSSysSequenceIdDirty()) {
            hashMap.put(FIELD_PSSYSSEQUENCEID, this.getPSSysSequenceId());
        }
        if (!bl || this.isPSSysSequenceNameDirty()) {
            hashMap.put(FIELD_PSSYSSEQUENCENAME, this.getPSSysSequenceName());
        }
        if (!bl || this.isPSSysSFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINID, this.getPSSysSFPluginId());
        }
        if (!bl || this.isPSSysSFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINNAME, this.getPSSysSFPluginName());
        }
        if (!bl || this.isPSSysTranslatorIdDirty()) {
            hashMap.put(FIELD_PSSYSTRANSLATORID, this.getPSSysTranslatorId());
        }
        if (!bl || this.isPSSysTranslatorNameDirty()) {
            hashMap.put(FIELD_PSSYSTRANSLATORNAME, this.getPSSysTranslatorName());
        }
        if (!bl || this.isPSSysValueRuleIdDirty()) {
            hashMap.put(FIELD_PSSYSVALUERULEID, this.getPSSysValueRuleId());
        }
        if (!bl || this.isPSSysValueRuleNameDirty()) {
            hashMap.put(FIELD_PSSYSVALUERULENAME, this.getPSSysValueRuleName());
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
        return PSDEActionLogicBase.get(this, n);
    }

    private static Object get(PSDEActionLogicBase pSDEActionLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEActionLogicBase.getAttachMode();
            }
            case 1: {
                return pSDEActionLogicBase.getCloneParamFlag();
            }
            case 2: {
                return pSDEActionLogicBase.getCodeName();
            }
            case 3: {
                return pSDEActionLogicBase.getCreateDate();
            }
            case 4: {
                return pSDEActionLogicBase.getCreateMan();
            }
            case 5: {
                return pSDEActionLogicBase.getCustomCode();
            }
            case 6: {
                return pSDEActionLogicBase.getDataSyncEvent();
            }
            case 7: {
                return pSDEActionLogicBase.getDstPSDEActionId();
            }
            case 8: {
                return pSDEActionLogicBase.getDstPSDEActionName();
            }
            case 9: {
                return pSDEActionLogicBase.getDstPSDEDataQueryId();
            }
            case 10: {
                return pSDEActionLogicBase.getDstPSDEDataQueryName();
            }
            case 11: {
                return pSDEActionLogicBase.getDstPSDEDataSetId();
            }
            case 12: {
                return pSDEActionLogicBase.getDstPSDEDataSetName();
            }
            case 13: {
                return pSDEActionLogicBase.getDstPSDEId();
            }
            case 14: {
                return pSDEActionLogicBase.getDstPSDELogicId();
            }
            case 15: {
                return pSDEActionLogicBase.getDstPSDELogicName();
            }
            case 16: {
                return pSDEActionLogicBase.getDstPSDEName();
            }
            case 17: {
                return pSDEActionLogicBase.getDynaModelFlag();
            }
            case 18: {
                return pSDEActionLogicBase.getErrorCode();
            }
            case 19: {
                return pSDEActionLogicBase.getErrorMsg();
            }
            case 20: {
                return pSDEActionLogicBase.getErrorPSLanResId();
            }
            case 21: {
                return pSDEActionLogicBase.getErrorPSLanResName();
            }
            case 22: {
                return pSDEActionLogicBase.getExceptionObj();
            }
            case 23: {
                return pSDEActionLogicBase.getIgnoreException();
            }
            case 24: {
                return pSDEActionLogicBase.getInternalLogic();
            }
            case 25: {
                return pSDEActionLogicBase.getLockFlag();
            }
            case 26: {
                return pSDEActionLogicBase.getLogicHolder();
            }
            case 27: {
                return pSDEActionLogicBase.getMajorPSDERId();
            }
            case 28: {
                return pSDEActionLogicBase.getMajorPSDERName();
            }
            case 29: {
                return pSDEActionLogicBase.getMemo();
            }
            case 30: {
                return pSDEActionLogicBase.getMinorPSDERId();
            }
            case 31: {
                return pSDEActionLogicBase.getMinorPSDERName();
            }
            case 32: {
                return pSDEActionLogicBase.getOrderValue();
            }
            case 33: {
                return pSDEActionLogicBase.getPrepareLast();
            }
            case 34: {
                return pSDEActionLogicBase.getPropertyMap();
            }
            case 35: {
                return pSDEActionLogicBase.getPSDEActionId();
            }
            case 36: {
                return pSDEActionLogicBase.getPSDEActionLogicId();
            }
            case 37: {
                return pSDEActionLogicBase.getPSDEActionLogicName();
            }
            case 38: {
                return pSDEActionLogicBase.getPSDEActionName();
            }
            case 39: {
                return pSDEActionLogicBase.getPSDEDataSyncId();
            }
            case 40: {
                return pSDEActionLogicBase.getPSDEDataSyncName();
            }
            case 41: {
                return pSDEActionLogicBase.getPSDEFId();
            }
            case 42: {
                return pSDEActionLogicBase.getPSDEFName();
            }
            case 43: {
                return pSDEActionLogicBase.getPSDEFValueRuleId();
            }
            case 44: {
                return pSDEActionLogicBase.getPSDEFValueRuleName();
            }
            case 45: {
                return pSDEActionLogicBase.getPSDEId();
            }
            case 46: {
                return pSDEActionLogicBase.getPSDELogicId();
            }
            case 47: {
                return pSDEActionLogicBase.getPSDELogicName();
            }
            case 48: {
                return pSDEActionLogicBase.getPSDEMainStateId();
            }
            case 49: {
                return pSDEActionLogicBase.getPSDEMainStateName();
            }
            case 50: {
                return pSDEActionLogicBase.getPSDEName();
            }
            case 51: {
                return pSDEActionLogicBase.getPSDENotifyId();
            }
            case 52: {
                return pSDEActionLogicBase.getPSDENotifyName();
            }
            case 53: {
                return pSDEActionLogicBase.getPSDynaInstId();
            }
            case 54: {
                return pSDEActionLogicBase.getPSSysDELogicNodeId();
            }
            case 55: {
                return pSDEActionLogicBase.getPSSysDELogicNodeName();
            }
            case 56: {
                return pSDEActionLogicBase.getPSSysPFPluginId();
            }
            case 57: {
                return pSDEActionLogicBase.getPSSysPFPluginName();
            }
            case 58: {
                return pSDEActionLogicBase.getPSSysSequenceId();
            }
            case 59: {
                return pSDEActionLogicBase.getPSSysSequenceName();
            }
            case 60: {
                return pSDEActionLogicBase.getPSSysSFPluginId();
            }
            case 61: {
                return pSDEActionLogicBase.getPSSysSFPluginName();
            }
            case 62: {
                return pSDEActionLogicBase.getPSSysTranslatorId();
            }
            case 63: {
                return pSDEActionLogicBase.getPSSysTranslatorName();
            }
            case 64: {
                return pSDEActionLogicBase.getPSSysValueRuleId();
            }
            case 65: {
                return pSDEActionLogicBase.getPSSysValueRuleName();
            }
            case 66: {
                return pSDEActionLogicBase.getUpdateDate();
            }
            case 67: {
                return pSDEActionLogicBase.getUpdateMan();
            }
            case 68: {
                return pSDEActionLogicBase.getUserCat();
            }
            case 69: {
                return pSDEActionLogicBase.getUserTag();
            }
            case 70: {
                return pSDEActionLogicBase.getUserTag2();
            }
            case 71: {
                return pSDEActionLogicBase.getUserTag3();
            }
            case 72: {
                return pSDEActionLogicBase.getUserTag4();
            }
            case 73: {
                return pSDEActionLogicBase.getValidFlag();
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
        PSDEActionLogicBase.set(this, n, object);
    }

    private static void set(PSDEActionLogicBase pSDEActionLogicBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEActionLogicBase.setAttachMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEActionLogicBase.setCloneParamFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 2: {
                pSDEActionLogicBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEActionLogicBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSDEActionLogicBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEActionLogicBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEActionLogicBase.setDataSyncEvent(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSDEActionLogicBase.setDstPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEActionLogicBase.setDstPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEActionLogicBase.setDstPSDEDataQueryId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEActionLogicBase.setDstPSDEDataQueryName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEActionLogicBase.setDstPSDEDataSetId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEActionLogicBase.setDstPSDEDataSetName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEActionLogicBase.setDstPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEActionLogicBase.setDstPSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEActionLogicBase.setDstPSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEActionLogicBase.setDstPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEActionLogicBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSDEActionLogicBase.setErrorCode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSDEActionLogicBase.setErrorMsg(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEActionLogicBase.setErrorPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEActionLogicBase.setErrorPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEActionLogicBase.setExceptionObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEActionLogicBase.setIgnoreException(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 24: {
                pSDEActionLogicBase.setInternalLogic(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 25: {
                pSDEActionLogicBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 26: {
                pSDEActionLogicBase.setLogicHolder(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 27: {
                pSDEActionLogicBase.setMajorPSDERId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEActionLogicBase.setMajorPSDERName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDEActionLogicBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDEActionLogicBase.setMinorPSDERId(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDEActionLogicBase.setMinorPSDERName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDEActionLogicBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 33: {
                pSDEActionLogicBase.setPrepareLast(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 34: {
                pSDEActionLogicBase.setPropertyMap(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDEActionLogicBase.setPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDEActionLogicBase.setPSDEActionLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDEActionLogicBase.setPSDEActionLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDEActionLogicBase.setPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDEActionLogicBase.setPSDEDataSyncId(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDEActionLogicBase.setPSDEDataSyncName(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDEActionLogicBase.setPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDEActionLogicBase.setPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSDEActionLogicBase.setPSDEFValueRuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSDEActionLogicBase.setPSDEFValueRuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSDEActionLogicBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSDEActionLogicBase.setPSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSDEActionLogicBase.setPSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSDEActionLogicBase.setPSDEMainStateId(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSDEActionLogicBase.setPSDEMainStateName(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSDEActionLogicBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSDEActionLogicBase.setPSDENotifyId(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSDEActionLogicBase.setPSDENotifyName(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSDEActionLogicBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSDEActionLogicBase.setPSSysDELogicNodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSDEActionLogicBase.setPSSysDELogicNodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSDEActionLogicBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSDEActionLogicBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 58: {
                pSDEActionLogicBase.setPSSysSequenceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 59: {
                pSDEActionLogicBase.setPSSysSequenceName(DataObject.getStringValue((Object)object));
                return;
            }
            case 60: {
                pSDEActionLogicBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 61: {
                pSDEActionLogicBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 62: {
                pSDEActionLogicBase.setPSSysTranslatorId(DataObject.getStringValue((Object)object));
                return;
            }
            case 63: {
                pSDEActionLogicBase.setPSSysTranslatorName(DataObject.getStringValue((Object)object));
                return;
            }
            case 64: {
                pSDEActionLogicBase.setPSSysValueRuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 65: {
                pSDEActionLogicBase.setPSSysValueRuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 66: {
                pSDEActionLogicBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 67: {
                pSDEActionLogicBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 68: {
                pSDEActionLogicBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 69: {
                pSDEActionLogicBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 70: {
                pSDEActionLogicBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 71: {
                pSDEActionLogicBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 72: {
                pSDEActionLogicBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 73: {
                pSDEActionLogicBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDEActionLogicBase.isNull(this, n);
    }

    private static boolean isNull(PSDEActionLogicBase pSDEActionLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEActionLogicBase.getAttachMode() == null;
            }
            case 1: {
                return pSDEActionLogicBase.getCloneParamFlag() == null;
            }
            case 2: {
                return pSDEActionLogicBase.getCodeName() == null;
            }
            case 3: {
                return pSDEActionLogicBase.getCreateDate() == null;
            }
            case 4: {
                return pSDEActionLogicBase.getCreateMan() == null;
            }
            case 5: {
                return pSDEActionLogicBase.getCustomCode() == null;
            }
            case 6: {
                return pSDEActionLogicBase.getDataSyncEvent() == null;
            }
            case 7: {
                return pSDEActionLogicBase.getDstPSDEActionId() == null;
            }
            case 8: {
                return pSDEActionLogicBase.getDstPSDEActionName() == null;
            }
            case 9: {
                return pSDEActionLogicBase.getDstPSDEDataQueryId() == null;
            }
            case 10: {
                return pSDEActionLogicBase.getDstPSDEDataQueryName() == null;
            }
            case 11: {
                return pSDEActionLogicBase.getDstPSDEDataSetId() == null;
            }
            case 12: {
                return pSDEActionLogicBase.getDstPSDEDataSetName() == null;
            }
            case 13: {
                return pSDEActionLogicBase.getDstPSDEId() == null;
            }
            case 14: {
                return pSDEActionLogicBase.getDstPSDELogicId() == null;
            }
            case 15: {
                return pSDEActionLogicBase.getDstPSDELogicName() == null;
            }
            case 16: {
                return pSDEActionLogicBase.getDstPSDEName() == null;
            }
            case 17: {
                return pSDEActionLogicBase.getDynaModelFlag() == null;
            }
            case 18: {
                return pSDEActionLogicBase.getErrorCode() == null;
            }
            case 19: {
                return pSDEActionLogicBase.getErrorMsg() == null;
            }
            case 20: {
                return pSDEActionLogicBase.getErrorPSLanResId() == null;
            }
            case 21: {
                return pSDEActionLogicBase.getErrorPSLanResName() == null;
            }
            case 22: {
                return pSDEActionLogicBase.getExceptionObj() == null;
            }
            case 23: {
                return pSDEActionLogicBase.getIgnoreException() == null;
            }
            case 24: {
                return pSDEActionLogicBase.getInternalLogic() == null;
            }
            case 25: {
                return pSDEActionLogicBase.getLockFlag() == null;
            }
            case 26: {
                return pSDEActionLogicBase.getLogicHolder() == null;
            }
            case 27: {
                return pSDEActionLogicBase.getMajorPSDERId() == null;
            }
            case 28: {
                return pSDEActionLogicBase.getMajorPSDERName() == null;
            }
            case 29: {
                return pSDEActionLogicBase.getMemo() == null;
            }
            case 30: {
                return pSDEActionLogicBase.getMinorPSDERId() == null;
            }
            case 31: {
                return pSDEActionLogicBase.getMinorPSDERName() == null;
            }
            case 32: {
                return pSDEActionLogicBase.getOrderValue() == null;
            }
            case 33: {
                return pSDEActionLogicBase.getPrepareLast() == null;
            }
            case 34: {
                return pSDEActionLogicBase.getPropertyMap() == null;
            }
            case 35: {
                return pSDEActionLogicBase.getPSDEActionId() == null;
            }
            case 36: {
                return pSDEActionLogicBase.getPSDEActionLogicId() == null;
            }
            case 37: {
                return pSDEActionLogicBase.getPSDEActionLogicName() == null;
            }
            case 38: {
                return pSDEActionLogicBase.getPSDEActionName() == null;
            }
            case 39: {
                return pSDEActionLogicBase.getPSDEDataSyncId() == null;
            }
            case 40: {
                return pSDEActionLogicBase.getPSDEDataSyncName() == null;
            }
            case 41: {
                return pSDEActionLogicBase.getPSDEFId() == null;
            }
            case 42: {
                return pSDEActionLogicBase.getPSDEFName() == null;
            }
            case 43: {
                return pSDEActionLogicBase.getPSDEFValueRuleId() == null;
            }
            case 44: {
                return pSDEActionLogicBase.getPSDEFValueRuleName() == null;
            }
            case 45: {
                return pSDEActionLogicBase.getPSDEId() == null;
            }
            case 46: {
                return pSDEActionLogicBase.getPSDELogicId() == null;
            }
            case 47: {
                return pSDEActionLogicBase.getPSDELogicName() == null;
            }
            case 48: {
                return pSDEActionLogicBase.getPSDEMainStateId() == null;
            }
            case 49: {
                return pSDEActionLogicBase.getPSDEMainStateName() == null;
            }
            case 50: {
                return pSDEActionLogicBase.getPSDEName() == null;
            }
            case 51: {
                return pSDEActionLogicBase.getPSDENotifyId() == null;
            }
            case 52: {
                return pSDEActionLogicBase.getPSDENotifyName() == null;
            }
            case 53: {
                return pSDEActionLogicBase.getPSDynaInstId() == null;
            }
            case 54: {
                return pSDEActionLogicBase.getPSSysDELogicNodeId() == null;
            }
            case 55: {
                return pSDEActionLogicBase.getPSSysDELogicNodeName() == null;
            }
            case 56: {
                return pSDEActionLogicBase.getPSSysPFPluginId() == null;
            }
            case 57: {
                return pSDEActionLogicBase.getPSSysPFPluginName() == null;
            }
            case 58: {
                return pSDEActionLogicBase.getPSSysSequenceId() == null;
            }
            case 59: {
                return pSDEActionLogicBase.getPSSysSequenceName() == null;
            }
            case 60: {
                return pSDEActionLogicBase.getPSSysSFPluginId() == null;
            }
            case 61: {
                return pSDEActionLogicBase.getPSSysSFPluginName() == null;
            }
            case 62: {
                return pSDEActionLogicBase.getPSSysTranslatorId() == null;
            }
            case 63: {
                return pSDEActionLogicBase.getPSSysTranslatorName() == null;
            }
            case 64: {
                return pSDEActionLogicBase.getPSSysValueRuleId() == null;
            }
            case 65: {
                return pSDEActionLogicBase.getPSSysValueRuleName() == null;
            }
            case 66: {
                return pSDEActionLogicBase.getUpdateDate() == null;
            }
            case 67: {
                return pSDEActionLogicBase.getUpdateMan() == null;
            }
            case 68: {
                return pSDEActionLogicBase.getUserCat() == null;
            }
            case 69: {
                return pSDEActionLogicBase.getUserTag() == null;
            }
            case 70: {
                return pSDEActionLogicBase.getUserTag2() == null;
            }
            case 71: {
                return pSDEActionLogicBase.getUserTag3() == null;
            }
            case 72: {
                return pSDEActionLogicBase.getUserTag4() == null;
            }
            case 73: {
                return pSDEActionLogicBase.getValidFlag() == null;
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
        return PSDEActionLogicBase.contains(this, n);
    }

    private static boolean contains(PSDEActionLogicBase pSDEActionLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEActionLogicBase.isAttachModeDirty();
            }
            case 1: {
                return pSDEActionLogicBase.isCloneParamFlagDirty();
            }
            case 2: {
                return pSDEActionLogicBase.isCodeNameDirty();
            }
            case 3: {
                return pSDEActionLogicBase.isCreateDateDirty();
            }
            case 4: {
                return pSDEActionLogicBase.isCreateManDirty();
            }
            case 5: {
                return pSDEActionLogicBase.isCustomCodeDirty();
            }
            case 6: {
                return pSDEActionLogicBase.isDataSyncEventDirty();
            }
            case 7: {
                return pSDEActionLogicBase.isDstPSDEActionIdDirty();
            }
            case 8: {
                return pSDEActionLogicBase.isDstPSDEActionNameDirty();
            }
            case 9: {
                return pSDEActionLogicBase.isDstPSDEDataQueryIdDirty();
            }
            case 10: {
                return pSDEActionLogicBase.isDstPSDEDataQueryNameDirty();
            }
            case 11: {
                return pSDEActionLogicBase.isDstPSDEDataSetIdDirty();
            }
            case 12: {
                return pSDEActionLogicBase.isDstPSDEDataSetNameDirty();
            }
            case 13: {
                return pSDEActionLogicBase.isDstPSDEIdDirty();
            }
            case 14: {
                return pSDEActionLogicBase.isDstPSDELogicIdDirty();
            }
            case 15: {
                return pSDEActionLogicBase.isDstPSDELogicNameDirty();
            }
            case 16: {
                return pSDEActionLogicBase.isDstPSDENameDirty();
            }
            case 17: {
                return pSDEActionLogicBase.isDynaModelFlagDirty();
            }
            case 18: {
                return pSDEActionLogicBase.isErrorCodeDirty();
            }
            case 19: {
                return pSDEActionLogicBase.isErrorMsgDirty();
            }
            case 20: {
                return pSDEActionLogicBase.isErrorPSLanResIdDirty();
            }
            case 21: {
                return pSDEActionLogicBase.isErrorPSLanResNameDirty();
            }
            case 22: {
                return pSDEActionLogicBase.isExceptionObjDirty();
            }
            case 23: {
                return pSDEActionLogicBase.isIgnoreExceptionDirty();
            }
            case 24: {
                return pSDEActionLogicBase.isInternalLogicDirty();
            }
            case 25: {
                return pSDEActionLogicBase.isLockFlagDirty();
            }
            case 26: {
                return pSDEActionLogicBase.isLogicHolderDirty();
            }
            case 27: {
                return pSDEActionLogicBase.isMajorPSDERIdDirty();
            }
            case 28: {
                return pSDEActionLogicBase.isMajorPSDERNameDirty();
            }
            case 29: {
                return pSDEActionLogicBase.isMemoDirty();
            }
            case 30: {
                return pSDEActionLogicBase.isMinorPSDERIdDirty();
            }
            case 31: {
                return pSDEActionLogicBase.isMinorPSDERNameDirty();
            }
            case 32: {
                return pSDEActionLogicBase.isOrderValueDirty();
            }
            case 33: {
                return pSDEActionLogicBase.isPrepareLastDirty();
            }
            case 34: {
                return pSDEActionLogicBase.isPropertyMapDirty();
            }
            case 35: {
                return pSDEActionLogicBase.isPSDEActionIdDirty();
            }
            case 36: {
                return pSDEActionLogicBase.isPSDEActionLogicIdDirty();
            }
            case 37: {
                return pSDEActionLogicBase.isPSDEActionLogicNameDirty();
            }
            case 38: {
                return pSDEActionLogicBase.isPSDEActionNameDirty();
            }
            case 39: {
                return pSDEActionLogicBase.isPSDEDataSyncIdDirty();
            }
            case 40: {
                return pSDEActionLogicBase.isPSDEDataSyncNameDirty();
            }
            case 41: {
                return pSDEActionLogicBase.isPSDEFIdDirty();
            }
            case 42: {
                return pSDEActionLogicBase.isPSDEFNameDirty();
            }
            case 43: {
                return pSDEActionLogicBase.isPSDEFValueRuleIdDirty();
            }
            case 44: {
                return pSDEActionLogicBase.isPSDEFValueRuleNameDirty();
            }
            case 45: {
                return pSDEActionLogicBase.isPSDEIdDirty();
            }
            case 46: {
                return pSDEActionLogicBase.isPSDELogicIdDirty();
            }
            case 47: {
                return pSDEActionLogicBase.isPSDELogicNameDirty();
            }
            case 48: {
                return pSDEActionLogicBase.isPSDEMainStateIdDirty();
            }
            case 49: {
                return pSDEActionLogicBase.isPSDEMainStateNameDirty();
            }
            case 50: {
                return pSDEActionLogicBase.isPSDENameDirty();
            }
            case 51: {
                return pSDEActionLogicBase.isPSDENotifyIdDirty();
            }
            case 52: {
                return pSDEActionLogicBase.isPSDENotifyNameDirty();
            }
            case 53: {
                return pSDEActionLogicBase.isPSDynaInstIdDirty();
            }
            case 54: {
                return pSDEActionLogicBase.isPSSysDELogicNodeIdDirty();
            }
            case 55: {
                return pSDEActionLogicBase.isPSSysDELogicNodeNameDirty();
            }
            case 56: {
                return pSDEActionLogicBase.isPSSysPFPluginIdDirty();
            }
            case 57: {
                return pSDEActionLogicBase.isPSSysPFPluginNameDirty();
            }
            case 58: {
                return pSDEActionLogicBase.isPSSysSequenceIdDirty();
            }
            case 59: {
                return pSDEActionLogicBase.isPSSysSequenceNameDirty();
            }
            case 60: {
                return pSDEActionLogicBase.isPSSysSFPluginIdDirty();
            }
            case 61: {
                return pSDEActionLogicBase.isPSSysSFPluginNameDirty();
            }
            case 62: {
                return pSDEActionLogicBase.isPSSysTranslatorIdDirty();
            }
            case 63: {
                return pSDEActionLogicBase.isPSSysTranslatorNameDirty();
            }
            case 64: {
                return pSDEActionLogicBase.isPSSysValueRuleIdDirty();
            }
            case 65: {
                return pSDEActionLogicBase.isPSSysValueRuleNameDirty();
            }
            case 66: {
                return pSDEActionLogicBase.isUpdateDateDirty();
            }
            case 67: {
                return pSDEActionLogicBase.isUpdateManDirty();
            }
            case 68: {
                return pSDEActionLogicBase.isUserCatDirty();
            }
            case 69: {
                return pSDEActionLogicBase.isUserTagDirty();
            }
            case 70: {
                return pSDEActionLogicBase.isUserTag2Dirty();
            }
            case 71: {
                return pSDEActionLogicBase.isUserTag3Dirty();
            }
            case 72: {
                return pSDEActionLogicBase.isUserTag4Dirty();
            }
            case 73: {
                return pSDEActionLogicBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEActionLogicBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEActionLogicBase pSDEActionLogicBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEActionLogicBase.getAttachMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"attachmode", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getAttachMode()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getCloneParamFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cloneparamflag", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getCloneParamFlag()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getDataSyncEvent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"datasyncevent", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getDataSyncEvent()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getDstPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdeactionid", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getDstPSDEActionId()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getDstPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdeactionname", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getDstPSDEActionName()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getDstPSDEDataQueryId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdedataqueryid", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getDstPSDEDataQueryId()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getDstPSDEDataQueryName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdedataqueryname", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getDstPSDEDataQueryName()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getDstPSDEDataSetId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdedatasetid", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getDstPSDEDataSetId()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getDstPSDEDataSetName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdedatasetname", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getDstPSDEDataSetName()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getDstPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdeid", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getDstPSDEId()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getDstPSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdelogicid", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getDstPSDELogicId()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getDstPSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdelogicname", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getDstPSDELogicName()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getDstPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdename", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getDstPSDEName()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getErrorCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"errorcode", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getErrorCode()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getErrorMsg() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"errormsg", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getErrorMsg()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getErrorPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"errorpslanresid", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getErrorPSLanResId()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getErrorPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"errorpslanresname", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getErrorPSLanResName()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getExceptionObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"exceptionobj", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getExceptionObj()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getIgnoreException() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ignoreexception", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getIgnoreException()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getInternalLogic() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"internallogic", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getInternalLogic()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getLogicHolder() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicholder", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getLogicHolder()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getMajorPSDERId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"majorpsderid", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getMajorPSDERId()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getMajorPSDERName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"majorpsdername", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getMajorPSDERName()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getMinorPSDERId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minorpsderid", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getMinorPSDERId()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getMinorPSDERName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minorpsdername", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getMinorPSDERName()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getPrepareLast() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"preparelast", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getPrepareLast()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getPropertyMap() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"propertymap", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getPropertyMap()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionid", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getPSDEActionId()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getPSDEActionLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionlogicid", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getPSDEActionLogicId()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getPSDEActionLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionlogicname", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getPSDEActionLogicName()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionname", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getPSDEActionName()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getPSDEDataSyncId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedatasyncid", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getPSDEDataSyncId()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getPSDEDataSyncName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedatasyncname", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getPSDEDataSyncName()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefid", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getPSDEFId()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefname", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getPSDEFName()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getPSDEFValueRuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefvalueruleid", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getPSDEFValueRuleId()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getPSDEFValueRuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefvaluerulename", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getPSDEFValueRuleName()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getPSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicid", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getPSDELogicId()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getPSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicname", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getPSDELogicName()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getPSDEMainStateId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdemainstateid", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getPSDEMainStateId()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getPSDEMainStateName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdemainstatename", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getPSDEMainStateName()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getPSDENotifyId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdenotifyid", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getPSDENotifyId()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getPSDENotifyName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdenotifyname", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getPSDENotifyName()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getPSSysDELogicNodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdelogicnodeid", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getPSSysDELogicNodeId()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getPSSysDELogicNodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdelogicnodename", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getPSSysDELogicNodeName()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getPSSysSequenceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssequenceid", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getPSSysSequenceId()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getPSSysSequenceName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssequencename", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getPSSysSequenceName()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getPSSysTranslatorId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystranslatorid", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getPSSysTranslatorId()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getPSSysTranslatorName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystranslatorname", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getPSSysTranslatorName()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getPSSysValueRuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysvalueruleid", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getPSSysValueRuleId()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getPSSysValueRuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysvaluerulename", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getPSSysValueRuleName()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEActionLogicBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDEActionLogicBase.getJSONValue((Object)pSDEActionLogicBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEActionLogicBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEActionLogicBase pSDEActionLogicBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEActionLogicBase.getAttachMode() != null) {
            object = pSDEActionLogicBase.getAttachMode();
            xmlNode.setAttribute(FIELD_ATTACHMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getCloneParamFlag() != null) {
            object = pSDEActionLogicBase.getCloneParamFlag();
            xmlNode.setAttribute(FIELD_CLONEPARAMFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEActionLogicBase.getCodeName() != null) {
            object = pSDEActionLogicBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getCreateDate() != null) {
            object = pSDEActionLogicBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEActionLogicBase.getCreateMan() != null) {
            object = pSDEActionLogicBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getCustomCode() != null) {
            object = pSDEActionLogicBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getDataSyncEvent() != null) {
            object = pSDEActionLogicBase.getDataSyncEvent();
            xmlNode.setAttribute(FIELD_DATASYNCEVENT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEActionLogicBase.getDstPSDEActionId() != null) {
            object = pSDEActionLogicBase.getDstPSDEActionId();
            xmlNode.setAttribute(FIELD_DSTPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getDstPSDEActionName() != null) {
            object = pSDEActionLogicBase.getDstPSDEActionName();
            xmlNode.setAttribute(FIELD_DSTPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getDstPSDEDataQueryId() != null) {
            object = pSDEActionLogicBase.getDstPSDEDataQueryId();
            xmlNode.setAttribute(FIELD_DSTPSDEDATAQUERYID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getDstPSDEDataQueryName() != null) {
            object = pSDEActionLogicBase.getDstPSDEDataQueryName();
            xmlNode.setAttribute(FIELD_DSTPSDEDATAQUERYNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getDstPSDEDataSetId() != null) {
            object = pSDEActionLogicBase.getDstPSDEDataSetId();
            xmlNode.setAttribute(FIELD_DSTPSDEDATASETID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getDstPSDEDataSetName() != null) {
            object = pSDEActionLogicBase.getDstPSDEDataSetName();
            xmlNode.setAttribute(FIELD_DSTPSDEDATASETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getDstPSDEId() != null) {
            object = pSDEActionLogicBase.getDstPSDEId();
            xmlNode.setAttribute(FIELD_DSTPSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getDstPSDELogicId() != null) {
            object = pSDEActionLogicBase.getDstPSDELogicId();
            xmlNode.setAttribute(FIELD_DSTPSDELOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getDstPSDELogicName() != null) {
            object = pSDEActionLogicBase.getDstPSDELogicName();
            xmlNode.setAttribute(FIELD_DSTPSDELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getDstPSDEName() != null) {
            object = pSDEActionLogicBase.getDstPSDEName();
            xmlNode.setAttribute(FIELD_DSTPSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getDynaModelFlag() != null) {
            object = pSDEActionLogicBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEActionLogicBase.getErrorCode() != null) {
            object = pSDEActionLogicBase.getErrorCode();
            xmlNode.setAttribute(FIELD_ERRORCODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEActionLogicBase.getErrorMsg() != null) {
            object = pSDEActionLogicBase.getErrorMsg();
            xmlNode.setAttribute(FIELD_ERRORMSG, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getErrorPSLanResId() != null) {
            object = pSDEActionLogicBase.getErrorPSLanResId();
            xmlNode.setAttribute(FIELD_ERRORPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getErrorPSLanResName() != null) {
            object = pSDEActionLogicBase.getErrorPSLanResName();
            xmlNode.setAttribute(FIELD_ERRORPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getExceptionObj() != null) {
            object = pSDEActionLogicBase.getExceptionObj();
            xmlNode.setAttribute(FIELD_EXCEPTIONOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getIgnoreException() != null) {
            object = pSDEActionLogicBase.getIgnoreException();
            xmlNode.setAttribute(FIELD_IGNOREEXCEPTION, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEActionLogicBase.getInternalLogic() != null) {
            object = pSDEActionLogicBase.getInternalLogic();
            xmlNode.setAttribute(FIELD_INTERNALLOGIC, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEActionLogicBase.getLockFlag() != null) {
            object = pSDEActionLogicBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEActionLogicBase.getLogicHolder() != null) {
            object = pSDEActionLogicBase.getLogicHolder();
            xmlNode.setAttribute(FIELD_LOGICHOLDER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEActionLogicBase.getMajorPSDERId() != null) {
            object = pSDEActionLogicBase.getMajorPSDERId();
            xmlNode.setAttribute(FIELD_MAJORPSDERID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getMajorPSDERName() != null) {
            object = pSDEActionLogicBase.getMajorPSDERName();
            xmlNode.setAttribute(FIELD_MAJORPSDERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getMemo() != null) {
            object = pSDEActionLogicBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getMinorPSDERId() != null) {
            object = pSDEActionLogicBase.getMinorPSDERId();
            xmlNode.setAttribute(FIELD_MINORPSDERID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getMinorPSDERName() != null) {
            object = pSDEActionLogicBase.getMinorPSDERName();
            xmlNode.setAttribute(FIELD_MINORPSDERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getOrderValue() != null) {
            object = pSDEActionLogicBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEActionLogicBase.getPrepareLast() != null) {
            object = pSDEActionLogicBase.getPrepareLast();
            xmlNode.setAttribute(FIELD_PREPARELAST, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEActionLogicBase.getPropertyMap() != null) {
            object = pSDEActionLogicBase.getPropertyMap();
            xmlNode.setAttribute(FIELD_PROPERTYMAP, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getPSDEActionId() != null) {
            object = pSDEActionLogicBase.getPSDEActionId();
            xmlNode.setAttribute(FIELD_PSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getPSDEActionLogicId() != null) {
            object = pSDEActionLogicBase.getPSDEActionLogicId();
            xmlNode.setAttribute(FIELD_PSDEACTIONLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getPSDEActionLogicName() != null) {
            object = pSDEActionLogicBase.getPSDEActionLogicName();
            xmlNode.setAttribute(FIELD_PSDEACTIONLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getPSDEActionName() != null) {
            object = pSDEActionLogicBase.getPSDEActionName();
            xmlNode.setAttribute(FIELD_PSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getPSDEDataSyncId() != null) {
            object = pSDEActionLogicBase.getPSDEDataSyncId();
            xmlNode.setAttribute(FIELD_PSDEDATASYNCID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getPSDEDataSyncName() != null) {
            object = pSDEActionLogicBase.getPSDEDataSyncName();
            xmlNode.setAttribute(FIELD_PSDEDATASYNCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getPSDEFId() != null) {
            object = pSDEActionLogicBase.getPSDEFId();
            xmlNode.setAttribute(FIELD_PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getPSDEFName() != null) {
            object = pSDEActionLogicBase.getPSDEFName();
            xmlNode.setAttribute(FIELD_PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getPSDEFValueRuleId() != null) {
            object = pSDEActionLogicBase.getPSDEFValueRuleId();
            xmlNode.setAttribute(FIELD_PSDEFVALUERULEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getPSDEFValueRuleName() != null) {
            object = pSDEActionLogicBase.getPSDEFValueRuleName();
            xmlNode.setAttribute(FIELD_PSDEFVALUERULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getPSDEId() != null) {
            object = pSDEActionLogicBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getPSDELogicId() != null) {
            object = pSDEActionLogicBase.getPSDELogicId();
            xmlNode.setAttribute(FIELD_PSDELOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getPSDELogicName() != null) {
            object = pSDEActionLogicBase.getPSDELogicName();
            xmlNode.setAttribute(FIELD_PSDELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getPSDEMainStateId() != null) {
            object = pSDEActionLogicBase.getPSDEMainStateId();
            xmlNode.setAttribute(FIELD_PSDEMAINSTATEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getPSDEMainStateName() != null) {
            object = pSDEActionLogicBase.getPSDEMainStateName();
            xmlNode.setAttribute(FIELD_PSDEMAINSTATENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getPSDEName() != null) {
            object = pSDEActionLogicBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getPSDENotifyId() != null) {
            object = pSDEActionLogicBase.getPSDENotifyId();
            xmlNode.setAttribute(FIELD_PSDENOTIFYID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getPSDENotifyName() != null) {
            object = pSDEActionLogicBase.getPSDENotifyName();
            xmlNode.setAttribute(FIELD_PSDENOTIFYNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getPSDynaInstId() != null) {
            object = pSDEActionLogicBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getPSSysDELogicNodeId() != null) {
            object = pSDEActionLogicBase.getPSSysDELogicNodeId();
            xmlNode.setAttribute(FIELD_PSSYSDELOGICNODEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getPSSysDELogicNodeName() != null) {
            object = pSDEActionLogicBase.getPSSysDELogicNodeName();
            xmlNode.setAttribute(FIELD_PSSYSDELOGICNODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getPSSysPFPluginId() != null) {
            object = pSDEActionLogicBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getPSSysPFPluginName() != null) {
            object = pSDEActionLogicBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getPSSysSequenceId() != null) {
            object = pSDEActionLogicBase.getPSSysSequenceId();
            xmlNode.setAttribute(FIELD_PSSYSSEQUENCEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getPSSysSequenceName() != null) {
            object = pSDEActionLogicBase.getPSSysSequenceName();
            xmlNode.setAttribute(FIELD_PSSYSSEQUENCENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getPSSysSFPluginId() != null) {
            object = pSDEActionLogicBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getPSSysSFPluginName() != null) {
            object = pSDEActionLogicBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getPSSysTranslatorId() != null) {
            object = pSDEActionLogicBase.getPSSysTranslatorId();
            xmlNode.setAttribute(FIELD_PSSYSTRANSLATORID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getPSSysTranslatorName() != null) {
            object = pSDEActionLogicBase.getPSSysTranslatorName();
            xmlNode.setAttribute(FIELD_PSSYSTRANSLATORNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getPSSysValueRuleId() != null) {
            object = pSDEActionLogicBase.getPSSysValueRuleId();
            xmlNode.setAttribute(FIELD_PSSYSVALUERULEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getPSSysValueRuleName() != null) {
            object = pSDEActionLogicBase.getPSSysValueRuleName();
            xmlNode.setAttribute(FIELD_PSSYSVALUERULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getUpdateDate() != null) {
            object = pSDEActionLogicBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEActionLogicBase.getUpdateMan() != null) {
            object = pSDEActionLogicBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getUserCat() != null) {
            object = pSDEActionLogicBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getUserTag() != null) {
            object = pSDEActionLogicBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getUserTag2() != null) {
            object = pSDEActionLogicBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getUserTag3() != null) {
            object = pSDEActionLogicBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getUserTag4() != null) {
            object = pSDEActionLogicBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionLogicBase.getValidFlag() != null) {
            object = pSDEActionLogicBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEActionLogicBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEActionLogicBase pSDEActionLogicBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEActionLogicBase.isAttachModeDirty() && (bl || pSDEActionLogicBase.getAttachMode() != null)) {
            iDataObject.set(FIELD_ATTACHMODE, (Object)pSDEActionLogicBase.getAttachMode());
        }
        if (pSDEActionLogicBase.isCloneParamFlagDirty() && (bl || pSDEActionLogicBase.getCloneParamFlag() != null)) {
            iDataObject.set(FIELD_CLONEPARAMFLAG, (Object)pSDEActionLogicBase.getCloneParamFlag());
        }
        if (pSDEActionLogicBase.isCodeNameDirty() && (bl || pSDEActionLogicBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDEActionLogicBase.getCodeName());
        }
        if (pSDEActionLogicBase.isCreateDateDirty() && (bl || pSDEActionLogicBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEActionLogicBase.getCreateDate());
        }
        if (pSDEActionLogicBase.isCreateManDirty() && (bl || pSDEActionLogicBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEActionLogicBase.getCreateMan());
        }
        if (pSDEActionLogicBase.isCustomCodeDirty() && (bl || pSDEActionLogicBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSDEActionLogicBase.getCustomCode());
        }
        if (pSDEActionLogicBase.isDataSyncEventDirty() && (bl || pSDEActionLogicBase.getDataSyncEvent() != null)) {
            iDataObject.set(FIELD_DATASYNCEVENT, (Object)pSDEActionLogicBase.getDataSyncEvent());
        }
        if (pSDEActionLogicBase.isDstPSDEActionIdDirty() && (bl || pSDEActionLogicBase.getDstPSDEActionId() != null)) {
            iDataObject.set(FIELD_DSTPSDEACTIONID, (Object)pSDEActionLogicBase.getDstPSDEActionId());
        }
        if (pSDEActionLogicBase.isDstPSDEActionNameDirty() && (bl || pSDEActionLogicBase.getDstPSDEActionName() != null)) {
            iDataObject.set(FIELD_DSTPSDEACTIONNAME, (Object)pSDEActionLogicBase.getDstPSDEActionName());
        }
        if (pSDEActionLogicBase.isDstPSDEDataQueryIdDirty() && (bl || pSDEActionLogicBase.getDstPSDEDataQueryId() != null)) {
            iDataObject.set(FIELD_DSTPSDEDATAQUERYID, (Object)pSDEActionLogicBase.getDstPSDEDataQueryId());
        }
        if (pSDEActionLogicBase.isDstPSDEDataQueryNameDirty() && (bl || pSDEActionLogicBase.getDstPSDEDataQueryName() != null)) {
            iDataObject.set(FIELD_DSTPSDEDATAQUERYNAME, (Object)pSDEActionLogicBase.getDstPSDEDataQueryName());
        }
        if (pSDEActionLogicBase.isDstPSDEDataSetIdDirty() && (bl || pSDEActionLogicBase.getDstPSDEDataSetId() != null)) {
            iDataObject.set(FIELD_DSTPSDEDATASETID, (Object)pSDEActionLogicBase.getDstPSDEDataSetId());
        }
        if (pSDEActionLogicBase.isDstPSDEDataSetNameDirty() && (bl || pSDEActionLogicBase.getDstPSDEDataSetName() != null)) {
            iDataObject.set(FIELD_DSTPSDEDATASETNAME, (Object)pSDEActionLogicBase.getDstPSDEDataSetName());
        }
        if (pSDEActionLogicBase.isDstPSDEIdDirty() && (bl || pSDEActionLogicBase.getDstPSDEId() != null)) {
            iDataObject.set(FIELD_DSTPSDEID, (Object)pSDEActionLogicBase.getDstPSDEId());
        }
        if (pSDEActionLogicBase.isDstPSDELogicIdDirty() && (bl || pSDEActionLogicBase.getDstPSDELogicId() != null)) {
            iDataObject.set(FIELD_DSTPSDELOGICID, (Object)pSDEActionLogicBase.getDstPSDELogicId());
        }
        if (pSDEActionLogicBase.isDstPSDELogicNameDirty() && (bl || pSDEActionLogicBase.getDstPSDELogicName() != null)) {
            iDataObject.set(FIELD_DSTPSDELOGICNAME, (Object)pSDEActionLogicBase.getDstPSDELogicName());
        }
        if (pSDEActionLogicBase.isDstPSDENameDirty() && (bl || pSDEActionLogicBase.getDstPSDEName() != null)) {
            iDataObject.set(FIELD_DSTPSDENAME, (Object)pSDEActionLogicBase.getDstPSDEName());
        }
        if (pSDEActionLogicBase.isDynaModelFlagDirty() && (bl || pSDEActionLogicBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSDEActionLogicBase.getDynaModelFlag());
        }
        if (pSDEActionLogicBase.isErrorCodeDirty() && (bl || pSDEActionLogicBase.getErrorCode() != null)) {
            iDataObject.set(FIELD_ERRORCODE, (Object)pSDEActionLogicBase.getErrorCode());
        }
        if (pSDEActionLogicBase.isErrorMsgDirty() && (bl || pSDEActionLogicBase.getErrorMsg() != null)) {
            iDataObject.set(FIELD_ERRORMSG, (Object)pSDEActionLogicBase.getErrorMsg());
        }
        if (pSDEActionLogicBase.isErrorPSLanResIdDirty() && (bl || pSDEActionLogicBase.getErrorPSLanResId() != null)) {
            iDataObject.set(FIELD_ERRORPSLANRESID, (Object)pSDEActionLogicBase.getErrorPSLanResId());
        }
        if (pSDEActionLogicBase.isErrorPSLanResNameDirty() && (bl || pSDEActionLogicBase.getErrorPSLanResName() != null)) {
            iDataObject.set(FIELD_ERRORPSLANRESNAME, (Object)pSDEActionLogicBase.getErrorPSLanResName());
        }
        if (pSDEActionLogicBase.isExceptionObjDirty() && (bl || pSDEActionLogicBase.getExceptionObj() != null)) {
            iDataObject.set(FIELD_EXCEPTIONOBJ, (Object)pSDEActionLogicBase.getExceptionObj());
        }
        if (pSDEActionLogicBase.isIgnoreExceptionDirty() && (bl || pSDEActionLogicBase.getIgnoreException() != null)) {
            iDataObject.set(FIELD_IGNOREEXCEPTION, (Object)pSDEActionLogicBase.getIgnoreException());
        }
        if (pSDEActionLogicBase.isInternalLogicDirty() && (bl || pSDEActionLogicBase.getInternalLogic() != null)) {
            iDataObject.set(FIELD_INTERNALLOGIC, (Object)pSDEActionLogicBase.getInternalLogic());
        }
        if (pSDEActionLogicBase.isLockFlagDirty() && (bl || pSDEActionLogicBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSDEActionLogicBase.getLockFlag());
        }
        if (pSDEActionLogicBase.isLogicHolderDirty() && (bl || pSDEActionLogicBase.getLogicHolder() != null)) {
            iDataObject.set(FIELD_LOGICHOLDER, (Object)pSDEActionLogicBase.getLogicHolder());
        }
        if (pSDEActionLogicBase.isMajorPSDERIdDirty() && (bl || pSDEActionLogicBase.getMajorPSDERId() != null)) {
            iDataObject.set(FIELD_MAJORPSDERID, (Object)pSDEActionLogicBase.getMajorPSDERId());
        }
        if (pSDEActionLogicBase.isMajorPSDERNameDirty() && (bl || pSDEActionLogicBase.getMajorPSDERName() != null)) {
            iDataObject.set(FIELD_MAJORPSDERNAME, (Object)pSDEActionLogicBase.getMajorPSDERName());
        }
        if (pSDEActionLogicBase.isMemoDirty() && (bl || pSDEActionLogicBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEActionLogicBase.getMemo());
        }
        if (pSDEActionLogicBase.isMinorPSDERIdDirty() && (bl || pSDEActionLogicBase.getMinorPSDERId() != null)) {
            iDataObject.set(FIELD_MINORPSDERID, (Object)pSDEActionLogicBase.getMinorPSDERId());
        }
        if (pSDEActionLogicBase.isMinorPSDERNameDirty() && (bl || pSDEActionLogicBase.getMinorPSDERName() != null)) {
            iDataObject.set(FIELD_MINORPSDERNAME, (Object)pSDEActionLogicBase.getMinorPSDERName());
        }
        if (pSDEActionLogicBase.isOrderValueDirty() && (bl || pSDEActionLogicBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEActionLogicBase.getOrderValue());
        }
        if (pSDEActionLogicBase.isPrepareLastDirty() && (bl || pSDEActionLogicBase.getPrepareLast() != null)) {
            iDataObject.set(FIELD_PREPARELAST, (Object)pSDEActionLogicBase.getPrepareLast());
        }
        if (pSDEActionLogicBase.isPropertyMapDirty() && (bl || pSDEActionLogicBase.getPropertyMap() != null)) {
            iDataObject.set(FIELD_PROPERTYMAP, (Object)pSDEActionLogicBase.getPropertyMap());
        }
        if (pSDEActionLogicBase.isPSDEActionIdDirty() && (bl || pSDEActionLogicBase.getPSDEActionId() != null)) {
            iDataObject.set(FIELD_PSDEACTIONID, (Object)pSDEActionLogicBase.getPSDEActionId());
        }
        if (pSDEActionLogicBase.isPSDEActionLogicIdDirty() && (bl || pSDEActionLogicBase.getPSDEActionLogicId() != null)) {
            iDataObject.set(FIELD_PSDEACTIONLOGICID, (Object)pSDEActionLogicBase.getPSDEActionLogicId());
        }
        if (pSDEActionLogicBase.isPSDEActionLogicNameDirty() && (bl || pSDEActionLogicBase.getPSDEActionLogicName() != null)) {
            iDataObject.set(FIELD_PSDEACTIONLOGICNAME, (Object)pSDEActionLogicBase.getPSDEActionLogicName());
        }
        if (pSDEActionLogicBase.isPSDEActionNameDirty() && (bl || pSDEActionLogicBase.getPSDEActionName() != null)) {
            iDataObject.set(FIELD_PSDEACTIONNAME, (Object)pSDEActionLogicBase.getPSDEActionName());
        }
        if (pSDEActionLogicBase.isPSDEDataSyncIdDirty() && (bl || pSDEActionLogicBase.getPSDEDataSyncId() != null)) {
            iDataObject.set(FIELD_PSDEDATASYNCID, (Object)pSDEActionLogicBase.getPSDEDataSyncId());
        }
        if (pSDEActionLogicBase.isPSDEDataSyncNameDirty() && (bl || pSDEActionLogicBase.getPSDEDataSyncName() != null)) {
            iDataObject.set(FIELD_PSDEDATASYNCNAME, (Object)pSDEActionLogicBase.getPSDEDataSyncName());
        }
        if (pSDEActionLogicBase.isPSDEFIdDirty() && (bl || pSDEActionLogicBase.getPSDEFId() != null)) {
            iDataObject.set(FIELD_PSDEFID, (Object)pSDEActionLogicBase.getPSDEFId());
        }
        if (pSDEActionLogicBase.isPSDEFNameDirty() && (bl || pSDEActionLogicBase.getPSDEFName() != null)) {
            iDataObject.set(FIELD_PSDEFNAME, (Object)pSDEActionLogicBase.getPSDEFName());
        }
        if (pSDEActionLogicBase.isPSDEFValueRuleIdDirty() && (bl || pSDEActionLogicBase.getPSDEFValueRuleId() != null)) {
            iDataObject.set(FIELD_PSDEFVALUERULEID, (Object)pSDEActionLogicBase.getPSDEFValueRuleId());
        }
        if (pSDEActionLogicBase.isPSDEFValueRuleNameDirty() && (bl || pSDEActionLogicBase.getPSDEFValueRuleName() != null)) {
            iDataObject.set(FIELD_PSDEFVALUERULENAME, (Object)pSDEActionLogicBase.getPSDEFValueRuleName());
        }
        if (pSDEActionLogicBase.isPSDEIdDirty() && (bl || pSDEActionLogicBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEActionLogicBase.getPSDEId());
        }
        if (pSDEActionLogicBase.isPSDELogicIdDirty() && (bl || pSDEActionLogicBase.getPSDELogicId() != null)) {
            iDataObject.set(FIELD_PSDELOGICID, (Object)pSDEActionLogicBase.getPSDELogicId());
        }
        if (pSDEActionLogicBase.isPSDELogicNameDirty() && (bl || pSDEActionLogicBase.getPSDELogicName() != null)) {
            iDataObject.set(FIELD_PSDELOGICNAME, (Object)pSDEActionLogicBase.getPSDELogicName());
        }
        if (pSDEActionLogicBase.isPSDEMainStateIdDirty() && (bl || pSDEActionLogicBase.getPSDEMainStateId() != null)) {
            iDataObject.set(FIELD_PSDEMAINSTATEID, (Object)pSDEActionLogicBase.getPSDEMainStateId());
        }
        if (pSDEActionLogicBase.isPSDEMainStateNameDirty() && (bl || pSDEActionLogicBase.getPSDEMainStateName() != null)) {
            iDataObject.set(FIELD_PSDEMAINSTATENAME, (Object)pSDEActionLogicBase.getPSDEMainStateName());
        }
        if (pSDEActionLogicBase.isPSDENameDirty() && (bl || pSDEActionLogicBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEActionLogicBase.getPSDEName());
        }
        if (pSDEActionLogicBase.isPSDENotifyIdDirty() && (bl || pSDEActionLogicBase.getPSDENotifyId() != null)) {
            iDataObject.set(FIELD_PSDENOTIFYID, (Object)pSDEActionLogicBase.getPSDENotifyId());
        }
        if (pSDEActionLogicBase.isPSDENotifyNameDirty() && (bl || pSDEActionLogicBase.getPSDENotifyName() != null)) {
            iDataObject.set(FIELD_PSDENOTIFYNAME, (Object)pSDEActionLogicBase.getPSDENotifyName());
        }
        if (pSDEActionLogicBase.isPSDynaInstIdDirty() && (bl || pSDEActionLogicBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSDEActionLogicBase.getPSDynaInstId());
        }
        if (pSDEActionLogicBase.isPSSysDELogicNodeIdDirty() && (bl || pSDEActionLogicBase.getPSSysDELogicNodeId() != null)) {
            iDataObject.set(FIELD_PSSYSDELOGICNODEID, (Object)pSDEActionLogicBase.getPSSysDELogicNodeId());
        }
        if (pSDEActionLogicBase.isPSSysDELogicNodeNameDirty() && (bl || pSDEActionLogicBase.getPSSysDELogicNodeName() != null)) {
            iDataObject.set(FIELD_PSSYSDELOGICNODENAME, (Object)pSDEActionLogicBase.getPSSysDELogicNodeName());
        }
        if (pSDEActionLogicBase.isPSSysPFPluginIdDirty() && (bl || pSDEActionLogicBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSDEActionLogicBase.getPSSysPFPluginId());
        }
        if (pSDEActionLogicBase.isPSSysPFPluginNameDirty() && (bl || pSDEActionLogicBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSDEActionLogicBase.getPSSysPFPluginName());
        }
        if (pSDEActionLogicBase.isPSSysSequenceIdDirty() && (bl || pSDEActionLogicBase.getPSSysSequenceId() != null)) {
            iDataObject.set(FIELD_PSSYSSEQUENCEID, (Object)pSDEActionLogicBase.getPSSysSequenceId());
        }
        if (pSDEActionLogicBase.isPSSysSequenceNameDirty() && (bl || pSDEActionLogicBase.getPSSysSequenceName() != null)) {
            iDataObject.set(FIELD_PSSYSSEQUENCENAME, (Object)pSDEActionLogicBase.getPSSysSequenceName());
        }
        if (pSDEActionLogicBase.isPSSysSFPluginIdDirty() && (bl || pSDEActionLogicBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSDEActionLogicBase.getPSSysSFPluginId());
        }
        if (pSDEActionLogicBase.isPSSysSFPluginNameDirty() && (bl || pSDEActionLogicBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSDEActionLogicBase.getPSSysSFPluginName());
        }
        if (pSDEActionLogicBase.isPSSysTranslatorIdDirty() && (bl || pSDEActionLogicBase.getPSSysTranslatorId() != null)) {
            iDataObject.set(FIELD_PSSYSTRANSLATORID, (Object)pSDEActionLogicBase.getPSSysTranslatorId());
        }
        if (pSDEActionLogicBase.isPSSysTranslatorNameDirty() && (bl || pSDEActionLogicBase.getPSSysTranslatorName() != null)) {
            iDataObject.set(FIELD_PSSYSTRANSLATORNAME, (Object)pSDEActionLogicBase.getPSSysTranslatorName());
        }
        if (pSDEActionLogicBase.isPSSysValueRuleIdDirty() && (bl || pSDEActionLogicBase.getPSSysValueRuleId() != null)) {
            iDataObject.set(FIELD_PSSYSVALUERULEID, (Object)pSDEActionLogicBase.getPSSysValueRuleId());
        }
        if (pSDEActionLogicBase.isPSSysValueRuleNameDirty() && (bl || pSDEActionLogicBase.getPSSysValueRuleName() != null)) {
            iDataObject.set(FIELD_PSSYSVALUERULENAME, (Object)pSDEActionLogicBase.getPSSysValueRuleName());
        }
        if (pSDEActionLogicBase.isUpdateDateDirty() && (bl || pSDEActionLogicBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEActionLogicBase.getUpdateDate());
        }
        if (pSDEActionLogicBase.isUpdateManDirty() && (bl || pSDEActionLogicBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEActionLogicBase.getUpdateMan());
        }
        if (pSDEActionLogicBase.isUserCatDirty() && (bl || pSDEActionLogicBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEActionLogicBase.getUserCat());
        }
        if (pSDEActionLogicBase.isUserTagDirty() && (bl || pSDEActionLogicBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEActionLogicBase.getUserTag());
        }
        if (pSDEActionLogicBase.isUserTag2Dirty() && (bl || pSDEActionLogicBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEActionLogicBase.getUserTag2());
        }
        if (pSDEActionLogicBase.isUserTag3Dirty() && (bl || pSDEActionLogicBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEActionLogicBase.getUserTag3());
        }
        if (pSDEActionLogicBase.isUserTag4Dirty() && (bl || pSDEActionLogicBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEActionLogicBase.getUserTag4());
        }
        if (pSDEActionLogicBase.isValidFlagDirty() && (bl || pSDEActionLogicBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDEActionLogicBase.getValidFlag());
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
        return PSDEActionLogicBase.remove(this, n);
    }

    private static boolean remove(PSDEActionLogicBase pSDEActionLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEActionLogicBase.resetAttachMode();
                return true;
            }
            case 1: {
                pSDEActionLogicBase.resetCloneParamFlag();
                return true;
            }
            case 2: {
                pSDEActionLogicBase.resetCodeName();
                return true;
            }
            case 3: {
                pSDEActionLogicBase.resetCreateDate();
                return true;
            }
            case 4: {
                pSDEActionLogicBase.resetCreateMan();
                return true;
            }
            case 5: {
                pSDEActionLogicBase.resetCustomCode();
                return true;
            }
            case 6: {
                pSDEActionLogicBase.resetDataSyncEvent();
                return true;
            }
            case 7: {
                pSDEActionLogicBase.resetDstPSDEActionId();
                return true;
            }
            case 8: {
                pSDEActionLogicBase.resetDstPSDEActionName();
                return true;
            }
            case 9: {
                pSDEActionLogicBase.resetDstPSDEDataQueryId();
                return true;
            }
            case 10: {
                pSDEActionLogicBase.resetDstPSDEDataQueryName();
                return true;
            }
            case 11: {
                pSDEActionLogicBase.resetDstPSDEDataSetId();
                return true;
            }
            case 12: {
                pSDEActionLogicBase.resetDstPSDEDataSetName();
                return true;
            }
            case 13: {
                pSDEActionLogicBase.resetDstPSDEId();
                return true;
            }
            case 14: {
                pSDEActionLogicBase.resetDstPSDELogicId();
                return true;
            }
            case 15: {
                pSDEActionLogicBase.resetDstPSDELogicName();
                return true;
            }
            case 16: {
                pSDEActionLogicBase.resetDstPSDEName();
                return true;
            }
            case 17: {
                pSDEActionLogicBase.resetDynaModelFlag();
                return true;
            }
            case 18: {
                pSDEActionLogicBase.resetErrorCode();
                return true;
            }
            case 19: {
                pSDEActionLogicBase.resetErrorMsg();
                return true;
            }
            case 20: {
                pSDEActionLogicBase.resetErrorPSLanResId();
                return true;
            }
            case 21: {
                pSDEActionLogicBase.resetErrorPSLanResName();
                return true;
            }
            case 22: {
                pSDEActionLogicBase.resetExceptionObj();
                return true;
            }
            case 23: {
                pSDEActionLogicBase.resetIgnoreException();
                return true;
            }
            case 24: {
                pSDEActionLogicBase.resetInternalLogic();
                return true;
            }
            case 25: {
                pSDEActionLogicBase.resetLockFlag();
                return true;
            }
            case 26: {
                pSDEActionLogicBase.resetLogicHolder();
                return true;
            }
            case 27: {
                pSDEActionLogicBase.resetMajorPSDERId();
                return true;
            }
            case 28: {
                pSDEActionLogicBase.resetMajorPSDERName();
                return true;
            }
            case 29: {
                pSDEActionLogicBase.resetMemo();
                return true;
            }
            case 30: {
                pSDEActionLogicBase.resetMinorPSDERId();
                return true;
            }
            case 31: {
                pSDEActionLogicBase.resetMinorPSDERName();
                return true;
            }
            case 32: {
                pSDEActionLogicBase.resetOrderValue();
                return true;
            }
            case 33: {
                pSDEActionLogicBase.resetPrepareLast();
                return true;
            }
            case 34: {
                pSDEActionLogicBase.resetPropertyMap();
                return true;
            }
            case 35: {
                pSDEActionLogicBase.resetPSDEActionId();
                return true;
            }
            case 36: {
                pSDEActionLogicBase.resetPSDEActionLogicId();
                return true;
            }
            case 37: {
                pSDEActionLogicBase.resetPSDEActionLogicName();
                return true;
            }
            case 38: {
                pSDEActionLogicBase.resetPSDEActionName();
                return true;
            }
            case 39: {
                pSDEActionLogicBase.resetPSDEDataSyncId();
                return true;
            }
            case 40: {
                pSDEActionLogicBase.resetPSDEDataSyncName();
                return true;
            }
            case 41: {
                pSDEActionLogicBase.resetPSDEFId();
                return true;
            }
            case 42: {
                pSDEActionLogicBase.resetPSDEFName();
                return true;
            }
            case 43: {
                pSDEActionLogicBase.resetPSDEFValueRuleId();
                return true;
            }
            case 44: {
                pSDEActionLogicBase.resetPSDEFValueRuleName();
                return true;
            }
            case 45: {
                pSDEActionLogicBase.resetPSDEId();
                return true;
            }
            case 46: {
                pSDEActionLogicBase.resetPSDELogicId();
                return true;
            }
            case 47: {
                pSDEActionLogicBase.resetPSDELogicName();
                return true;
            }
            case 48: {
                pSDEActionLogicBase.resetPSDEMainStateId();
                return true;
            }
            case 49: {
                pSDEActionLogicBase.resetPSDEMainStateName();
                return true;
            }
            case 50: {
                pSDEActionLogicBase.resetPSDEName();
                return true;
            }
            case 51: {
                pSDEActionLogicBase.resetPSDENotifyId();
                return true;
            }
            case 52: {
                pSDEActionLogicBase.resetPSDENotifyName();
                return true;
            }
            case 53: {
                pSDEActionLogicBase.resetPSDynaInstId();
                return true;
            }
            case 54: {
                pSDEActionLogicBase.resetPSSysDELogicNodeId();
                return true;
            }
            case 55: {
                pSDEActionLogicBase.resetPSSysDELogicNodeName();
                return true;
            }
            case 56: {
                pSDEActionLogicBase.resetPSSysPFPluginId();
                return true;
            }
            case 57: {
                pSDEActionLogicBase.resetPSSysPFPluginName();
                return true;
            }
            case 58: {
                pSDEActionLogicBase.resetPSSysSequenceId();
                return true;
            }
            case 59: {
                pSDEActionLogicBase.resetPSSysSequenceName();
                return true;
            }
            case 60: {
                pSDEActionLogicBase.resetPSSysSFPluginId();
                return true;
            }
            case 61: {
                pSDEActionLogicBase.resetPSSysSFPluginName();
                return true;
            }
            case 62: {
                pSDEActionLogicBase.resetPSSysTranslatorId();
                return true;
            }
            case 63: {
                pSDEActionLogicBase.resetPSSysTranslatorName();
                return true;
            }
            case 64: {
                pSDEActionLogicBase.resetPSSysValueRuleId();
                return true;
            }
            case 65: {
                pSDEActionLogicBase.resetPSSysValueRuleName();
                return true;
            }
            case 66: {
                pSDEActionLogicBase.resetUpdateDate();
                return true;
            }
            case 67: {
                pSDEActionLogicBase.resetUpdateMan();
                return true;
            }
            case 68: {
                pSDEActionLogicBase.resetUserCat();
                return true;
            }
            case 69: {
                pSDEActionLogicBase.resetUserTag();
                return true;
            }
            case 70: {
                pSDEActionLogicBase.resetUserTag2();
                return true;
            }
            case 71: {
                pSDEActionLogicBase.resetUserTag3();
                return true;
            }
            case 72: {
                pSDEActionLogicBase.resetUserTag4();
                return true;
            }
            case 73: {
                pSDEActionLogicBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getDstPSDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDE();
        }
        if (this.getDstPSDEId() == null) {
            return null;
        }
        Integer n = this.objDstPSDELock;
        synchronized (n) {
            if (this.dstpsde != null && DataTypeHelper.compare((int)25, (Object)this.getDstPSDEId(), (Object)this.dstpsde.getPSDataEntityId()) != 0L) {
                this.dstpsde = null;
            }
            if (this.dstpsde == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getDstPSDEId());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.dstpsde = pSDataEntity;
            }
            return this.dstpsde;
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
    public PSDEAction getDstPSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEAction();
        }
        if (this.getDstPSDEActionId() == null) {
            return null;
        }
        Integer n = this.objDstPSDEActionLock;
        synchronized (n) {
            if (this.dstpsdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getDstPSDEActionId(), (Object)this.dstpsdeaction.getPSDEActionId()) != 0L) {
                this.dstpsdeaction = null;
            }
            if (this.dstpsdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getDstPSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet(pSDEAction);
                this.dstpsdeaction = pSDEAction;
            }
            return this.dstpsdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEAction getPSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEAction();
        }
        if (this.getPSDEActionId() == null) {
            return null;
        }
        Integer n = this.objPSDEActionLock;
        synchronized (n) {
            if (this.psdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEActionId(), (Object)this.psdeaction.getPSDEActionId()) != 0L) {
                this.psdeaction = null;
            }
            if (this.psdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getPSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet(pSDEAction);
                this.psdeaction = pSDEAction;
            }
            return this.psdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataQuery getDstPSDEDataQuery() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEDataQuery();
        }
        if (this.getDstPSDEDataQueryId() == null) {
            return null;
        }
        Integer n = this.objDstPSDEDataQueryLock;
        synchronized (n) {
            if (this.dstpsdedataquery != null && DataTypeHelper.compare((int)25, (Object)this.getDstPSDEDataQueryId(), (Object)this.dstpsdedataquery.getPSDEDataQueryId()) != 0L) {
                this.dstpsdedataquery = null;
            }
            if (this.dstpsdedataquery == null) {
                PSDEDataQuery pSDEDataQuery = new PSDEDataQuery();
                pSDEDataQuery.setPSDEDataQueryId(this.getDstPSDEDataQueryId());
                PSDEDataQueryService pSDEDataQueryService = (PSDEDataQueryService)ServiceGlobal.getService(PSDEDataQueryService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataQueryService.autoGet(pSDEDataQuery);
                this.dstpsdedataquery = pSDEDataQuery;
            }
            return this.dstpsdedataquery;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataSet getDstPSDEDataSet() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEDataSet();
        }
        if (this.getDstPSDEDataSetId() == null) {
            return null;
        }
        Integer n = this.objDstPSDEDataSetLock;
        synchronized (n) {
            if (this.dstpsdedataset != null && DataTypeHelper.compare((int)25, (Object)this.getDstPSDEDataSetId(), (Object)this.dstpsdedataset.getPSDEDataSetId()) != 0L) {
                this.dstpsdedataset = null;
            }
            if (this.dstpsdedataset == null) {
                PSDEDataSet pSDEDataSet = new PSDEDataSet();
                pSDEDataSet.setPSDEDataSetId(this.getDstPSDEDataSetId());
                PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataSetService.autoGet(pSDEDataSet);
                this.dstpsdedataset = pSDEDataSet;
            }
            return this.dstpsdedataset;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataSync getPSDEDataSync() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataSync();
        }
        if (this.getPSDEDataSyncId() == null) {
            return null;
        }
        Integer n = this.objPSDEDataSyncLock;
        synchronized (n) {
            if (this.psdedatasync != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDataSyncId(), (Object)this.psdedatasync.getPSDEDataSyncId()) != 0L) {
                this.psdedatasync = null;
            }
            if (this.psdedatasync == null) {
                PSDEDataSync pSDEDataSync = new PSDEDataSync();
                pSDEDataSync.setPSDEDataSyncId(this.getPSDEDataSyncId());
                PSDEDataSyncService pSDEDataSyncService = (PSDEDataSyncService)ServiceGlobal.getService(PSDEDataSyncService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataSyncService.autoGet(pSDEDataSync);
                this.psdedatasync = pSDEDataSync;
            }
            return this.psdedatasync;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEF();
        }
        if (this.getPSDEFId() == null) {
            return null;
        }
        Integer n = this.objPSDEFLock;
        synchronized (n) {
            if (this.psdef != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFId(), (Object)this.psdef.getPSDEFieldId()) != 0L) {
                this.psdef = null;
            }
            if (this.psdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.psdef = pSDEField;
            }
            return this.psdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEFValueRule getPSDEFValueRule() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFValueRule();
        }
        if (this.getPSDEFValueRuleId() == null) {
            return null;
        }
        Integer n = this.objPSDEFValueRuleLock;
        synchronized (n) {
            if (this.psdefvaluerule != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFValueRuleId(), (Object)this.psdefvaluerule.getPSDEFValueRuleId()) != 0L) {
                this.psdefvaluerule = null;
            }
            if (this.psdefvaluerule == null) {
                PSDEFValueRule pSDEFValueRule = new PSDEFValueRule();
                pSDEFValueRule.setPSDEFValueRuleId(this.getPSDEFValueRuleId());
                PSDEFValueRuleService pSDEFValueRuleService = (PSDEFValueRuleService)ServiceGlobal.getService(PSDEFValueRuleService.class, (SessionFactory)this.getSessionFactory());
                pSDEFValueRuleService.autoGet(pSDEFValueRule);
                this.psdefvaluerule = pSDEFValueRule;
            }
            return this.psdefvaluerule;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDELogic getDstPSDELogic() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDELogic();
        }
        if (this.getDstPSDELogicId() == null) {
            return null;
        }
        Integer n = this.objDstPSDELogicLock;
        synchronized (n) {
            if (this.dstpsdelogic != null && DataTypeHelper.compare((int)25, (Object)this.getDstPSDELogicId(), (Object)this.dstpsdelogic.getPSDELogicId()) != 0L) {
                this.dstpsdelogic = null;
            }
            if (this.dstpsdelogic == null) {
                PSDELogic pSDELogic = new PSDELogic();
                pSDELogic.setPSDELogicId(this.getDstPSDELogicId());
                PSDELogicService pSDELogicService = (PSDELogicService)ServiceGlobal.getService(PSDELogicService.class, (SessionFactory)this.getSessionFactory());
                pSDELogicService.autoGet(pSDELogic);
                this.dstpsdelogic = pSDELogic;
            }
            return this.dstpsdelogic;
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
    public PSDEMainState getPSDEMainState() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMainState();
        }
        if (this.getPSDEMainStateId() == null) {
            return null;
        }
        Integer n = this.objPSDEMainStateLock;
        synchronized (n) {
            if (this.psdemainstate != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEMainStateId(), (Object)this.psdemainstate.getPSDEMainStateId()) != 0L) {
                this.psdemainstate = null;
            }
            if (this.psdemainstate == null) {
                PSDEMainState pSDEMainState = new PSDEMainState();
                pSDEMainState.setPSDEMainStateId(this.getPSDEMainStateId());
                PSDEMainStateService pSDEMainStateService = (PSDEMainStateService)ServiceGlobal.getService(PSDEMainStateService.class, (SessionFactory)this.getSessionFactory());
                pSDEMainStateService.autoGet(pSDEMainState);
                this.psdemainstate = pSDEMainState;
            }
            return this.psdemainstate;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDENotify getPSDENotify() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDENotify();
        }
        if (this.getPSDENotifyId() == null) {
            return null;
        }
        Integer n = this.objPSDENotifyLock;
        synchronized (n) {
            if (this.psdenotify != null && DataTypeHelper.compare((int)25, (Object)this.getPSDENotifyId(), (Object)this.psdenotify.getPSDENotifyId()) != 0L) {
                this.psdenotify = null;
            }
            if (this.psdenotify == null) {
                PSDENotify pSDENotify = new PSDENotify();
                pSDENotify.setPSDENotifyId(this.getPSDENotifyId());
                PSDENotifyService pSDENotifyService = (PSDENotifyService)ServiceGlobal.getService(PSDENotifyService.class, (SessionFactory)this.getSessionFactory());
                pSDENotifyService.autoGet(pSDENotify);
                this.psdenotify = pSDENotify;
            }
            return this.psdenotify;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDER getMajorPSDEId() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorPSDEId();
        }
        if (this.getMajorPSDERId() == null) {
            return null;
        }
        Integer n = this.objMajorPSDEIdLock;
        synchronized (n) {
            if (this.majorpsdeid != null && DataTypeHelper.compare((int)25, (Object)this.getMajorPSDERId(), (Object)this.majorpsdeid.getPSDERId()) != 0L) {
                this.majorpsdeid = null;
            }
            if (this.majorpsdeid == null) {
                PSDER pSDER = new PSDER();
                pSDER.setPSDERId(this.getMajorPSDERId());
                PSDERService pSDERService = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)this.getSessionFactory());
                pSDERService.autoGet(pSDER);
                this.majorpsdeid = pSDER;
            }
            return this.majorpsdeid;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDER getMinorPSDER() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorPSDER();
        }
        if (this.getMinorPSDERId() == null) {
            return null;
        }
        Integer n = this.objMinorPSDERLock;
        synchronized (n) {
            if (this.minorpsder != null && DataTypeHelper.compare((int)25, (Object)this.getMinorPSDERId(), (Object)this.minorpsder.getPSDERId()) != 0L) {
                this.minorpsder = null;
            }
            if (this.minorpsder == null) {
                PSDER pSDER = new PSDER();
                pSDER.setPSDERId(this.getMinorPSDERId());
                PSDERService pSDERService = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)this.getSessionFactory());
                pSDERService.autoGet(pSDER);
                this.minorpsder = pSDER;
            }
            return this.minorpsder;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getErrorPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getErrorPSLanRes();
        }
        if (this.getErrorPSLanResId() == null) {
            return null;
        }
        Integer n = this.objErrorPSLanResLock;
        synchronized (n) {
            if (this.errorpslanres != null && DataTypeHelper.compare((int)25, (Object)this.getErrorPSLanResId(), (Object)this.errorpslanres.getPSLanguageResId()) != 0L) {
                this.errorpslanres = null;
            }
            if (this.errorpslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getErrorPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet(pSLanguageRes);
                this.errorpslanres = pSLanguageRes;
            }
            return this.errorpslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDELogicNode getPSSysDELogicNode() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDELogicNode();
        }
        if (this.getPSSysDELogicNodeId() == null) {
            return null;
        }
        Integer n = this.objPSSysDELogicNodeLock;
        synchronized (n) {
            if (this.pssysdelogicnode != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysDELogicNodeId(), (Object)this.pssysdelogicnode.getPSSysDELogicNodeId()) != 0L) {
                this.pssysdelogicnode = null;
            }
            if (this.pssysdelogicnode == null) {
                PSSysDELogicNode pSSysDELogicNode = new PSSysDELogicNode();
                pSSysDELogicNode.setPSSysDELogicNodeId(this.getPSSysDELogicNodeId());
                PSSysDELogicNodeService pSSysDELogicNodeService = (PSSysDELogicNodeService)ServiceGlobal.getService(PSSysDELogicNodeService.class, (SessionFactory)this.getSessionFactory());
                pSSysDELogicNodeService.autoGet(pSSysDELogicNode);
                this.pssysdelogicnode = pSSysDELogicNode;
            }
            return this.pssysdelogicnode;
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
    public PSSysSequence getPSSysSequence() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSequence();
        }
        if (this.getPSSysSequenceId() == null) {
            return null;
        }
        Integer n = this.objPSSysSequenceLock;
        synchronized (n) {
            if (this.pssyssequence != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysSequenceId(), (Object)this.pssyssequence.getPSSysSequenceId()) != 0L) {
                this.pssyssequence = null;
            }
            if (this.pssyssequence == null) {
                PSSysSequence pSSysSequence = new PSSysSequence();
                pSSysSequence.setPSSysSequenceId(this.getPSSysSequenceId());
                PSSysSequenceService pSSysSequenceService = (PSSysSequenceService)ServiceGlobal.getService(PSSysSequenceService.class, (SessionFactory)this.getSessionFactory());
                pSSysSequenceService.autoGet(pSSysSequence);
                this.pssyssequence = pSSysSequence;
            }
            return this.pssyssequence;
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
    public PSSysTranslator getPSSysTranslator() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTranslator();
        }
        if (this.getPSSysTranslatorId() == null) {
            return null;
        }
        Integer n = this.objPSSysTranslatorLock;
        synchronized (n) {
            if (this.pssystranslator != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysTranslatorId(), (Object)this.pssystranslator.getPSSysTranslatorId()) != 0L) {
                this.pssystranslator = null;
            }
            if (this.pssystranslator == null) {
                PSSysTranslator pSSysTranslator = new PSSysTranslator();
                pSSysTranslator.setPSSysTranslatorId(this.getPSSysTranslatorId());
                PSSysTranslatorService pSSysTranslatorService = (PSSysTranslatorService)ServiceGlobal.getService(PSSysTranslatorService.class, (SessionFactory)this.getSessionFactory());
                pSSysTranslatorService.autoGet(pSSysTranslator);
                this.pssystranslator = pSSysTranslator;
            }
            return this.pssystranslator;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysValueRule getPSSysValueRule() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysValueRule();
        }
        if (this.getPSSysValueRuleId() == null) {
            return null;
        }
        Integer n = this.objPSSysValueRuleLock;
        synchronized (n) {
            if (this.pssysvaluerule != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysValueRuleId(), (Object)this.pssysvaluerule.getPSSysValueRuleId()) != 0L) {
                this.pssysvaluerule = null;
            }
            if (this.pssysvaluerule == null) {
                PSSysValueRule pSSysValueRule = new PSSysValueRule();
                pSSysValueRule.setPSSysValueRuleId(this.getPSSysValueRuleId());
                PSSysValueRuleService pSSysValueRuleService = (PSSysValueRuleService)ServiceGlobal.getService(PSSysValueRuleService.class, (SessionFactory)this.getSessionFactory());
                pSSysValueRuleService.autoGet(pSSysValueRule);
                this.pssysvaluerule = pSSysValueRule;
            }
            return this.pssysvaluerule;
        }
    }

    private PSDEActionLogicBase getProxyEntity() {
        return this.proxyPSDEActionLogicBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEActionLogicBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEActionLogicBase) {
            this.proxyPSDEActionLogicBase = (PSDEActionLogicBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionLogicService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ATTACHMODE, 0);
        fieldIndexMap.put(FIELD_CLONEPARAMFLAG, 1);
        fieldIndexMap.put(FIELD_CODENAME, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 5);
        fieldIndexMap.put(FIELD_DATASYNCEVENT, 6);
        fieldIndexMap.put(FIELD_DSTPSDEACTIONID, 7);
        fieldIndexMap.put(FIELD_DSTPSDEACTIONNAME, 8);
        fieldIndexMap.put(FIELD_DSTPSDEDATAQUERYID, 9);
        fieldIndexMap.put(FIELD_DSTPSDEDATAQUERYNAME, 10);
        fieldIndexMap.put(FIELD_DSTPSDEDATASETID, 11);
        fieldIndexMap.put(FIELD_DSTPSDEDATASETNAME, 12);
        fieldIndexMap.put(FIELD_DSTPSDEID, 13);
        fieldIndexMap.put(FIELD_DSTPSDELOGICID, 14);
        fieldIndexMap.put(FIELD_DSTPSDELOGICNAME, 15);
        fieldIndexMap.put(FIELD_DSTPSDENAME, 16);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 17);
        fieldIndexMap.put(FIELD_ERRORCODE, 18);
        fieldIndexMap.put(FIELD_ERRORMSG, 19);
        fieldIndexMap.put(FIELD_ERRORPSLANRESID, 20);
        fieldIndexMap.put(FIELD_ERRORPSLANRESNAME, 21);
        fieldIndexMap.put(FIELD_EXCEPTIONOBJ, 22);
        fieldIndexMap.put(FIELD_IGNOREEXCEPTION, 23);
        fieldIndexMap.put(FIELD_INTERNALLOGIC, 24);
        fieldIndexMap.put(FIELD_LOCKFLAG, 25);
        fieldIndexMap.put(FIELD_LOGICHOLDER, 26);
        fieldIndexMap.put(FIELD_MAJORPSDERID, 27);
        fieldIndexMap.put(FIELD_MAJORPSDERNAME, 28);
        fieldIndexMap.put(FIELD_MEMO, 29);
        fieldIndexMap.put(FIELD_MINORPSDERID, 30);
        fieldIndexMap.put(FIELD_MINORPSDERNAME, 31);
        fieldIndexMap.put(FIELD_ORDERVALUE, 32);
        fieldIndexMap.put(FIELD_PREPARELAST, 33);
        fieldIndexMap.put(FIELD_PROPERTYMAP, 34);
        fieldIndexMap.put(FIELD_PSDEACTIONID, 35);
        fieldIndexMap.put(FIELD_PSDEACTIONLOGICID, 36);
        fieldIndexMap.put(FIELD_PSDEACTIONLOGICNAME, 37);
        fieldIndexMap.put(FIELD_PSDEACTIONNAME, 38);
        fieldIndexMap.put(FIELD_PSDEDATASYNCID, 39);
        fieldIndexMap.put(FIELD_PSDEDATASYNCNAME, 40);
        fieldIndexMap.put(FIELD_PSDEFID, 41);
        fieldIndexMap.put(FIELD_PSDEFNAME, 42);
        fieldIndexMap.put(FIELD_PSDEFVALUERULEID, 43);
        fieldIndexMap.put(FIELD_PSDEFVALUERULENAME, 44);
        fieldIndexMap.put(FIELD_PSDEID, 45);
        fieldIndexMap.put(FIELD_PSDELOGICID, 46);
        fieldIndexMap.put(FIELD_PSDELOGICNAME, 47);
        fieldIndexMap.put(FIELD_PSDEMAINSTATEID, 48);
        fieldIndexMap.put(FIELD_PSDEMAINSTATENAME, 49);
        fieldIndexMap.put(FIELD_PSDENAME, 50);
        fieldIndexMap.put(FIELD_PSDENOTIFYID, 51);
        fieldIndexMap.put(FIELD_PSDENOTIFYNAME, 52);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 53);
        fieldIndexMap.put(FIELD_PSSYSDELOGICNODEID, 54);
        fieldIndexMap.put(FIELD_PSSYSDELOGICNODENAME, 55);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 56);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 57);
        fieldIndexMap.put(FIELD_PSSYSSEQUENCEID, 58);
        fieldIndexMap.put(FIELD_PSSYSSEQUENCENAME, 59);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 60);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 61);
        fieldIndexMap.put(FIELD_PSSYSTRANSLATORID, 62);
        fieldIndexMap.put(FIELD_PSSYSTRANSLATORNAME, 63);
        fieldIndexMap.put(FIELD_PSSYSVALUERULEID, 64);
        fieldIndexMap.put(FIELD_PSSYSVALUERULENAME, 65);
        fieldIndexMap.put(FIELD_UPDATEDATE, 66);
        fieldIndexMap.put(FIELD_UPDATEMAN, 67);
        fieldIndexMap.put(FIELD_USERCAT, 68);
        fieldIndexMap.put(FIELD_USERTAG, 69);
        fieldIndexMap.put(FIELD_USERTAG2, 70);
        fieldIndexMap.put(FIELD_USERTAG3, 71);
        fieldIndexMap.put(FIELD_USERTAG4, 72);
        fieldIndexMap.put(FIELD_VALIDFLAG, 73);
    }
}

