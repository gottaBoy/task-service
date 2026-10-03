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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionLogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionTempl;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionVR;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQuery;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMSAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPriv;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESampleData;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESysProc;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionTemplService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionVRService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataQueryService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMSActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService;
import net.ibizsys.pscore.srv.dedesign.service.PSDESampleDataService;
import net.ibizsys.pscore.srv.dedesign.service.PSDESysProcService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDEActionParam;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADetail;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTask;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniState;
import net.ibizsys.pscore.srv.sysdesign.service.PSDEActionParamService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADetailService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysTaskService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUniStateService;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestCase;
import net.ibizsys.pscore.srv.systest.service.PSSysTestCaseService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEActionBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEActionBase.class);
    public static final String FIELD_ACTIONHOLDER = "ACTIONHOLDER";
    public static final String FIELD_ACTIONMODE = "ACTIONMODE";
    public static final String FIELD_ACTIONOPTION = "ACTIONOPTION";
    public static final String FIELD_ACTIONPARAMS = "ACTIONPARAMS";
    public static final String FIELD_ACTIONTAG = "ACTIONTAG";
    public static final String FIELD_ACTIONTAG2 = "ACTIONTAG2";
    public static final String FIELD_ACTIONTAG3 = "ACTIONTAG3";
    public static final String FIELD_ACTIONTAG4 = "ACTIONTAG4";
    public static final String FIELD_ACTIONTYPE = "ACTIONTYPE";
    public static final String FIELD_AFTERCODE = "AFTERCODE";
    public static final String FIELD_BATCHACTIONMODE = "BATCHACTIONMODE";
    public static final String FIELD_BEFORECODE = "BEFORECODE";
    public static final String FIELD_CACHECAT = "CACHECAT";
    public static final String FIELD_CACHESCOPE = "CACHESCOPE";
    public static final String FIELD_CACHETAG = "CACHETAG";
    public static final String FIELD_CACHETIMEOUT = "CACHETIMEOUT";
    public static final String FIELD_CALLEROBJ = "CALLEROBJ";
    public static final String FIELD_CALLTIMEOUT = "CALLTIMEOUT";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_CUSTOMMODE = "CUSTOMMODE";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_ENABLEAUDIT = "ENABLEAUDIT";
    public static final String FIELD_ENABLECACHE = "ENABLECACHE";
    public static final String FIELD_EXTENDMODE = "EXTENDMODE";
    public static final String FIELD_FINISHFLAG = "FINISHFLAG";
    public static final String FIELD_INPSDEFGROUPID = "INPSDEFGROUPID";
    public static final String FIELD_INPSDEFGROUPNAME = "INPSDEFGROUPNAME";
    public static final String FIELD_INPSDESAMPLEDATAID = "INPSDESAMPLEDATAID";
    public static final String FIELD_INPSDESAMPLEDATANAME = "INPSDESAMPLEDATANAME";
    public static final String FIELD_INPSSYSDYNAMODELID = "INPSSYSDYNAMODELID";
    public static final String FIELD_INPSSYSDYNAMODELNAME = "INPSSYSDYNAMODELNAME";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_NEEDRESOURCEKEY = "NEEDRESOURCEKEY";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_OUTPSDEFGROUPID = "OUTPSDEFGROUPID";
    public static final String FIELD_OUTPSDEFGROUPNAME = "OUTPSDEFGROUPNAME";
    public static final String FIELD_OUTPSDESAMPLEDATAID = "OUTPSDESAMPLEDATAID";
    public static final String FIELD_OUTPSDESAMPLEDATANAME = "OUTPSDESAMPLEDATANAME";
    public static final String FIELD_OUTPSSYSDYNAMODELID = "OUTPSSYSDYNAMODELID";
    public static final String FIELD_OUTPSSYSDYNAMODELNAME = "OUTPSSYSDYNAMODELNAME";
    public static final String FIELD_OUTREFPSDEFGROUPID = "OUTREFPSDEFGROUPID";
    public static final String FIELD_OUTREFPSDEFGROUPNAME = "OUTREFPSDEFGROUPNAME";
    public static final String FIELD_OUTREFPSDEID = "OUTREFPSDEID";
    public static final String FIELD_OUTREFPSDENAME = "OUTREFPSDENAME";
    public static final String FIELD_PARAMTYPE = "PARAMTYPE";
    public static final String FIELD_POTIME = "POTIME";
    public static final String FIELD_PREDEFINEDTYPE = "PREDEFINEDTYPE";
    public static final String FIELD_PREDEFINEDTYPEPARAM = "PREDEFINEDTYPEPARAM";
    public static final String FIELD_PREDEFINEDTYPETEXT = "PREDEFINEDTYPETEXT";
    public static final String FIELD_PREPARELAST = "PREPARELAST";
    public static final String FIELD_PSDEACTIONID = "PSDEACTIONID";
    public static final String FIELD_PSDEACTIONLOGICSCNT = "PSDEACTIONLOGICSCNT";
    public static final String FIELD_PSDEACTIONNAME = "PSDEACTIONNAME";
    public static final String FIELD_PSDEACTIONTEMPLID = "PSDEACTIONTEMPLID";
    public static final String FIELD_PSDEACTIONTEMPLNAME = "PSDEACTIONTEMPLNAME";
    public static final String FIELD_PSDEDATAFLOWID = "PSDEDATAFLOWID";
    public static final String FIELD_PSDEDATAFLOWNAME = "PSDEDATAFLOWNAME";
    public static final String FIELD_PSDEDATAQUERYID = "PSDEDATAQUERYID";
    public static final String FIELD_PSDEDATAQUERYNAME = "PSDEDATAQUERYNAME";
    public static final String FIELD_PSDEDATASETID = "PSDEDATASETID";
    public static final String FIELD_PSDEDATASETNAME = "PSDEDATASETNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDELOGICID = "PSDELOGICID";
    public static final String FIELD_PSDELOGICNAME = "PSDELOGICNAME";
    public static final String FIELD_PSDEMSACTIONSCNT = "PSDEMSACTIONSCNT";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDEOPPRIVID = "PSDEOPPRIVID";
    public static final String FIELD_PSDEOPPRIVNAME = "PSDEOPPRIVNAME";
    public static final String FIELD_PSDESYSPROCID = "PSDESYSPROCID";
    public static final String FIELD_PSDESYSPROCNAME = "PSDESYSPROCNAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSSUBSYSSADEID = "PSSUBSYSSADEID";
    public static final String FIELD_PSSUBSYSSADETAILID = "PSSUBSYSSADETAILID";
    public static final String FIELD_PSSUBSYSSADETAILNAME = "PSSUBSYSSADETAILNAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_PSSYSREQITEMID = "PSSYSREQITEMID";
    public static final String FIELD_PSSYSREQITEMNAME = "PSSYSREQITEMNAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_PSSYSTASKID = "PSSYSTASKID";
    public static final String FIELD_PSSYSTASKNAME = "PSSYSTASKNAME";
    public static final String FIELD_PSSYSTESTCASESCNT = "PSSYSTESTCASESCNT";
    public static final String FIELD_PSSYSUNISTATEID = "PSSYSUNISTATEID";
    public static final String FIELD_PSSYSUNISTATENAME = "PSSYSUNISTATENAME";
    public static final String FIELD_PUBMODE = "PUBMODE";
    public static final String FIELD_RAWSERVICEMETHOD = "RAWSERVICEMETHOD";
    public static final String FIELD_RAWSERVICEURL = "RAWSERVICEURL";
    public static final String FIELD_REQUESTFIELD = "REQUESTFIELD";
    public static final String FIELD_REQUESTMETHOD = "REQUESTMETHOD";
    public static final String FIELD_REQUESTPARAMTYPE = "REQUESTPARAMTYPE";
    public static final String FIELD_REQUESTPATH = "REQUESTPATH";
    public static final String FIELD_RETSTDDATATYPE = "RETSTDDATATYPE";
    public static final String FIELD_RETVALTYPE = "RETVALTYPE";
    public static final String FIELD_SERVICECODENAME = "SERVICECODENAME";
    public static final String FIELD_SUBSYSSADETAILMODE = "SUBSYSSADETAILMODE";
    public static final String FIELD_SYNCEVENT = "SYNCEVENT";
    public static final String FIELD_TESTACTIONMODE = "TESTACTIONMODE";
    public static final String FIELD_TESTCASEFLAG = "TESTCASEFLAG";
    public static final String FIELD_TODOTASK = "TODOTASK";
    public static final String FIELD_TSMODE = "TSMODE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_ACTIONHOLDER = 0;
    private static final int INDEX_ACTIONMODE = 1;
    private static final int INDEX_ACTIONOPTION = 2;
    private static final int INDEX_ACTIONPARAMS = 3;
    private static final int INDEX_ACTIONTAG = 4;
    private static final int INDEX_ACTIONTAG2 = 5;
    private static final int INDEX_ACTIONTAG3 = 6;
    private static final int INDEX_ACTIONTAG4 = 7;
    private static final int INDEX_ACTIONTYPE = 8;
    private static final int INDEX_AFTERCODE = 9;
    private static final int INDEX_BATCHACTIONMODE = 10;
    private static final int INDEX_BEFORECODE = 11;
    private static final int INDEX_CACHECAT = 12;
    private static final int INDEX_CACHESCOPE = 13;
    private static final int INDEX_CACHETAG = 14;
    private static final int INDEX_CACHETIMEOUT = 15;
    private static final int INDEX_CALLEROBJ = 16;
    private static final int INDEX_CALLTIMEOUT = 17;
    private static final int INDEX_CODENAME = 18;
    private static final int INDEX_CREATEDATE = 19;
    private static final int INDEX_CREATEMAN = 20;
    private static final int INDEX_CUSTOMCODE = 21;
    private static final int INDEX_CUSTOMMODE = 22;
    private static final int INDEX_DYNAMODELFLAG = 23;
    private static final int INDEX_ENABLEAUDIT = 24;
    private static final int INDEX_ENABLECACHE = 25;
    private static final int INDEX_EXTENDMODE = 26;
    private static final int INDEX_FINISHFLAG = 27;
    private static final int INDEX_INPSDEFGROUPID = 28;
    private static final int INDEX_INPSDEFGROUPNAME = 29;
    private static final int INDEX_INPSDESAMPLEDATAID = 30;
    private static final int INDEX_INPSDESAMPLEDATANAME = 31;
    private static final int INDEX_INPSSYSDYNAMODELID = 32;
    private static final int INDEX_INPSSYSDYNAMODELNAME = 33;
    private static final int INDEX_LOCKFLAG = 34;
    private static final int INDEX_LOGICNAME = 35;
    private static final int INDEX_MEMO = 36;
    private static final int INDEX_NEEDRESOURCEKEY = 37;
    private static final int INDEX_ORDERVALUE = 38;
    private static final int INDEX_OUTPSDEFGROUPID = 39;
    private static final int INDEX_OUTPSDEFGROUPNAME = 40;
    private static final int INDEX_OUTPSDESAMPLEDATAID = 41;
    private static final int INDEX_OUTPSDESAMPLEDATANAME = 42;
    private static final int INDEX_OUTPSSYSDYNAMODELID = 43;
    private static final int INDEX_OUTPSSYSDYNAMODELNAME = 44;
    private static final int INDEX_OUTREFPSDEFGROUPID = 45;
    private static final int INDEX_OUTREFPSDEFGROUPNAME = 46;
    private static final int INDEX_OUTREFPSDEID = 47;
    private static final int INDEX_OUTREFPSDENAME = 48;
    private static final int INDEX_PARAMTYPE = 49;
    private static final int INDEX_POTIME = 50;
    private static final int INDEX_PREDEFINEDTYPE = 51;
    private static final int INDEX_PREDEFINEDTYPEPARAM = 52;
    private static final int INDEX_PREDEFINEDTYPETEXT = 53;
    private static final int INDEX_PREPARELAST = 54;
    private static final int INDEX_PSDEACTIONID = 55;
    private static final int INDEX_PSDEACTIONLOGICSCNT = 56;
    private static final int INDEX_PSDEACTIONNAME = 57;
    private static final int INDEX_PSDEACTIONTEMPLID = 58;
    private static final int INDEX_PSDEACTIONTEMPLNAME = 59;
    private static final int INDEX_PSDEDATAFLOWID = 60;
    private static final int INDEX_PSDEDATAFLOWNAME = 61;
    private static final int INDEX_PSDEDATAQUERYID = 62;
    private static final int INDEX_PSDEDATAQUERYNAME = 63;
    private static final int INDEX_PSDEDATASETID = 64;
    private static final int INDEX_PSDEDATASETNAME = 65;
    private static final int INDEX_PSDEID = 66;
    private static final int INDEX_PSDELOGICID = 67;
    private static final int INDEX_PSDELOGICNAME = 68;
    private static final int INDEX_PSDEMSACTIONSCNT = 69;
    private static final int INDEX_PSDENAME = 70;
    private static final int INDEX_PSDEOPPRIVID = 71;
    private static final int INDEX_PSDEOPPRIVNAME = 72;
    private static final int INDEX_PSDESYSPROCID = 73;
    private static final int INDEX_PSDESYSPROCNAME = 74;
    private static final int INDEX_PSDYNAINSTID = 75;
    private static final int INDEX_PSSUBSYSSADEID = 76;
    private static final int INDEX_PSSUBSYSSADETAILID = 77;
    private static final int INDEX_PSSUBSYSSADETAILNAME = 78;
    private static final int INDEX_PSSYSDYNAMODELID = 79;
    private static final int INDEX_PSSYSDYNAMODELNAME = 80;
    private static final int INDEX_PSSYSPFPLUGINID = 81;
    private static final int INDEX_PSSYSPFPLUGINNAME = 82;
    private static final int INDEX_PSSYSREQITEMID = 83;
    private static final int INDEX_PSSYSREQITEMNAME = 84;
    private static final int INDEX_PSSYSSFPLUGINID = 85;
    private static final int INDEX_PSSYSSFPLUGINNAME = 86;
    private static final int INDEX_PSSYSTASKID = 87;
    private static final int INDEX_PSSYSTASKNAME = 88;
    private static final int INDEX_PSSYSTESTCASESCNT = 89;
    private static final int INDEX_PSSYSUNISTATEID = 90;
    private static final int INDEX_PSSYSUNISTATENAME = 91;
    private static final int INDEX_PUBMODE = 92;
    private static final int INDEX_RAWSERVICEMETHOD = 93;
    private static final int INDEX_RAWSERVICEURL = 94;
    private static final int INDEX_REQUESTFIELD = 95;
    private static final int INDEX_REQUESTMETHOD = 96;
    private static final int INDEX_REQUESTPARAMTYPE = 97;
    private static final int INDEX_REQUESTPATH = 98;
    private static final int INDEX_RETSTDDATATYPE = 99;
    private static final int INDEX_RETVALTYPE = 100;
    private static final int INDEX_SERVICECODENAME = 101;
    private static final int INDEX_SUBSYSSADETAILMODE = 102;
    private static final int INDEX_SYNCEVENT = 103;
    private static final int INDEX_TESTACTIONMODE = 104;
    private static final int INDEX_TESTCASEFLAG = 105;
    private static final int INDEX_TODOTASK = 106;
    private static final int INDEX_TSMODE = 107;
    private static final int INDEX_UPDATEDATE = 108;
    private static final int INDEX_UPDATEMAN = 109;
    private static final int INDEX_USERCAT = 110;
    private static final int INDEX_USERPARAMS = 111;
    private static final int INDEX_USERTAG = 112;
    private static final int INDEX_USERTAG2 = 113;
    private static final int INDEX_USERTAG3 = 114;
    private static final int INDEX_USERTAG4 = 115;
    private static final int INDEX_VALIDFLAG = 116;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEActionBase proxyPSDEActionBase = null;
    private boolean actionholderDirtyFlag = false;
    private boolean actionmodeDirtyFlag = false;
    private boolean actionoptionDirtyFlag = false;
    private boolean actionparamsDirtyFlag = false;
    private boolean actiontagDirtyFlag = false;
    private boolean actiontag2DirtyFlag = false;
    private boolean actiontag3DirtyFlag = false;
    private boolean actiontag4DirtyFlag = false;
    private boolean actiontypeDirtyFlag = false;
    private boolean aftercodeDirtyFlag = false;
    private boolean batchactionmodeDirtyFlag = false;
    private boolean beforecodeDirtyFlag = false;
    private boolean cachecatDirtyFlag = false;
    private boolean cachescopeDirtyFlag = false;
    private boolean cachetagDirtyFlag = false;
    private boolean cachetimeoutDirtyFlag = false;
    private boolean callerobjDirtyFlag = false;
    private boolean calltimeoutDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean custommodeDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean enableauditDirtyFlag = false;
    private boolean enablecacheDirtyFlag = false;
    private boolean extendmodeDirtyFlag = false;
    private boolean finishflagDirtyFlag = false;
    private boolean inpsdefgroupidDirtyFlag = false;
    private boolean inpsdefgroupnameDirtyFlag = false;
    private boolean inpsdesampledataidDirtyFlag = false;
    private boolean inpsdesampledatanameDirtyFlag = false;
    private boolean inpssysdynamodelidDirtyFlag = false;
    private boolean inpssysdynamodelnameDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean needresourcekeyDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean outpsdefgroupidDirtyFlag = false;
    private boolean outpsdefgroupnameDirtyFlag = false;
    private boolean outpsdesampledataidDirtyFlag = false;
    private boolean outpsdesampledatanameDirtyFlag = false;
    private boolean outpssysdynamodelidDirtyFlag = false;
    private boolean outpssysdynamodelnameDirtyFlag = false;
    private boolean outrefpsdefgroupidDirtyFlag = false;
    private boolean outrefpsdefgroupnameDirtyFlag = false;
    private boolean outrefpsdeidDirtyFlag = false;
    private boolean outrefpsdenameDirtyFlag = false;
    private boolean paramtypeDirtyFlag = false;
    private boolean potimeDirtyFlag = false;
    private boolean predefinedtypeDirtyFlag = false;
    private boolean predefinedtypeparamDirtyFlag = false;
    private boolean predefinedtypetextDirtyFlag = false;
    private boolean preparelastDirtyFlag = false;
    private boolean psdeactionidDirtyFlag = false;
    private boolean psdeactionlogicscntDirtyFlag = false;
    private boolean psdeactionnameDirtyFlag = false;
    private boolean psdeactiontemplidDirtyFlag = false;
    private boolean psdeactiontemplnameDirtyFlag = false;
    private boolean psdedataflowidDirtyFlag = false;
    private boolean psdedataflownameDirtyFlag = false;
    private boolean psdedataqueryidDirtyFlag = false;
    private boolean psdedataquerynameDirtyFlag = false;
    private boolean psdedatasetidDirtyFlag = false;
    private boolean psdedatasetnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdelogicidDirtyFlag = false;
    private boolean psdelogicnameDirtyFlag = false;
    private boolean psdemsactionscntDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdeopprividDirtyFlag = false;
    private boolean psdeopprivnameDirtyFlag = false;
    private boolean psdesysprocidDirtyFlag = false;
    private boolean psdesysprocnameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pssubsyssadeidDirtyFlag = false;
    private boolean pssubsyssadetailidDirtyFlag = false;
    private boolean pssubsyssadetailnameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean pssysreqitemidDirtyFlag = false;
    private boolean pssysreqitemnameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean pssystaskidDirtyFlag = false;
    private boolean pssystasknameDirtyFlag = false;
    private boolean pssystestcasescntDirtyFlag = false;
    private boolean pssysunistateidDirtyFlag = false;
    private boolean pssysunistatenameDirtyFlag = false;
    private boolean pubmodeDirtyFlag = false;
    private boolean rawservicemethodDirtyFlag = false;
    private boolean rawserviceurlDirtyFlag = false;
    private boolean requestfieldDirtyFlag = false;
    private boolean requestmethodDirtyFlag = false;
    private boolean requestparamtypeDirtyFlag = false;
    private boolean requestpathDirtyFlag = false;
    private boolean retstddatatypeDirtyFlag = false;
    private boolean retvaltypeDirtyFlag = false;
    private boolean servicecodenameDirtyFlag = false;
    private boolean subsyssadetailmodeDirtyFlag = false;
    private boolean synceventDirtyFlag = false;
    private boolean testactionmodeDirtyFlag = false;
    private boolean testcaseflagDirtyFlag = false;
    private boolean todotaskDirtyFlag = false;
    private boolean tsmodeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="actionholder")
    private Integer actionholder;
    @Column(name="actionmode")
    private String actionmode;
    @Column(name="actionoption")
    private Integer actionoption;
    @Column(name="actionparams")
    private String actionparams;
    @Column(name="actiontag")
    private String actiontag;
    @Column(name="actiontag2")
    private String actiontag2;
    @Column(name="actiontag3")
    private String actiontag3;
    @Column(name="actiontag4")
    private String actiontag4;
    @Column(name="actiontype")
    private String actiontype;
    @Column(name="aftercode")
    private String aftercode;
    @Column(name="batchactionmode")
    private Integer batchactionmode;
    @Column(name="beforecode")
    private String beforecode;
    @Column(name="cachecat")
    private String cachecat;
    @Column(name="cachescope")
    private String cachescope;
    @Column(name="cachetag")
    private String cachetag;
    @Column(name="cachetimeout")
    private Integer cachetimeout;
    @Column(name="callerobj")
    private String callerobj;
    @Column(name="calltimeout")
    private Integer calltimeout;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customcode")
    private String customcode;
    @Column(name="custommode")
    private Integer custommode;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="enableaudit")
    private Integer enableaudit;
    @Column(name="enablecache")
    private Integer enablecache;
    @Column(name="extendmode")
    private Integer extendmode;
    @Column(name="finishflag")
    private Integer finishflag;
    @Column(name="inpsdefgroupid")
    private String inpsdefgroupid;
    @Column(name="inpsdefgroupname")
    private String inpsdefgroupname;
    @Column(name="inpsdesampledataid")
    private String inpsdesampledataid;
    @Column(name="inpsdesampledataname")
    private String inpsdesampledataname;
    @Column(name="inpssysdynamodelid")
    private String inpssysdynamodelid;
    @Column(name="inpssysdynamodelname")
    private String inpssysdynamodelname;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="needresourcekey")
    private Integer needresourcekey;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="outpsdefgroupid")
    private String outpsdefgroupid;
    @Column(name="outpsdefgroupname")
    private String outpsdefgroupname;
    @Column(name="outpsdesampledataid")
    private String outpsdesampledataid;
    @Column(name="outpsdesampledataname")
    private String outpsdesampledataname;
    @Column(name="outpssysdynamodelid")
    private String outpssysdynamodelid;
    @Column(name="outpssysdynamodelname")
    private String outpssysdynamodelname;
    @Column(name="outrefpsdefgroupid")
    private String outrefpsdefgroupid;
    @Column(name="outrefpsdefgroupname")
    private String outrefpsdefgroupname;
    @Column(name="outrefpsdeid")
    private String outrefpsdeid;
    @Column(name="outrefpsdename")
    private String outrefpsdename;
    @Column(name="paramtype")
    private Integer paramtype;
    @Column(name="potime")
    private Integer potime;
    @Column(name="predefinedtype")
    private String predefinedtype;
    @Column(name="predefinedtypeparam")
    private String predefinedtypeparam;
    @Column(name="predefinedtypetext")
    private String predefinedtypetext;
    @Column(name="preparelast")
    private Integer preparelast;
    @Column(name="psdeactionid")
    private String psdeactionid;
    @Column(name="psdeactionlogicscnt")
    private Integer psdeactionlogicscnt;
    @Column(name="psdeactionname")
    private String psdeactionname;
    @Column(name="psdeactiontemplid")
    private String psdeactiontemplid;
    @Column(name="psdeactiontemplname")
    private String psdeactiontemplname;
    @Column(name="psdedataflowid")
    private String psdedataflowid;
    @Column(name="psdedataflowname")
    private String psdedataflowname;
    @Column(name="psdedataqueryid")
    private String psdedataqueryid;
    @Column(name="psdedataqueryname")
    private String psdedataqueryname;
    @Column(name="psdedatasetid")
    private String psdedatasetid;
    @Column(name="psdedatasetname")
    private String psdedatasetname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdelogicid")
    private String psdelogicid;
    @Column(name="psdelogicname")
    private String psdelogicname;
    @Column(name="psdemsactionscnt")
    private Integer psdemsactionscnt;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdeopprivid")
    private String psdeopprivid;
    @Column(name="psdeopprivname")
    private String psdeopprivname;
    @Column(name="psdesysprocid")
    private String psdesysprocid;
    @Column(name="psdesysprocname")
    private String psdesysprocname;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="pssubsyssadeid")
    private String pssubsyssadeid;
    @Column(name="pssubsyssadetailid")
    private String pssubsyssadetailid;
    @Column(name="pssubsyssadetailname")
    private String pssubsyssadetailname;
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
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
    @Column(name="pssystaskid")
    private String pssystaskid;
    @Column(name="pssystaskname")
    private String pssystaskname;
    @Column(name="pssystestcasescnt")
    private Integer pssystestcasescnt;
    @Column(name="pssysunistateid")
    private String pssysunistateid;
    @Column(name="pssysunistatename")
    private String pssysunistatename;
    @Column(name="pubmode")
    private Integer pubmode;
    @Column(name="rawservicemethod")
    private String rawservicemethod;
    @Column(name="rawserviceurl")
    private String rawserviceurl;
    @Column(name="requestfield")
    private String requestfield;
    @Column(name="requestmethod")
    private String requestmethod;
    @Column(name="requestparamtype")
    private String requestparamtype;
    @Column(name="requestpath")
    private String requestpath;
    @Column(name="retstddatatype")
    private Integer retstddatatype;
    @Column(name="retvaltype")
    private String retvaltype;
    @Column(name="servicecodename")
    private String servicecodename;
    @Column(name="subsyssadetailmode")
    private Integer subsyssadetailmode;
    @Column(name="syncevent")
    private Integer syncevent;
    @Column(name="testactionmode")
    private Integer testactionmode;
    @Column(name="testcaseflag")
    private Integer testcaseflag;
    @Column(name="todotask")
    private String todotask;
    @Column(name="tsmode")
    private String tsmode;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercat")
    private String usercat;
    @Column(name="userparams")
    private String userparams;
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
    private Integer objOutRefPSDELock = new Integer(1);
    private PSDataEntity outrefpsde = null;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSDEActionTemplLock = new Integer(1);
    private PSDEActionTempl psdeactiontempl = null;
    private Integer objPSDEDataQueryLock = new Integer(1);
    private PSDEDataQuery psdedataquery = null;
    private Integer objPSDEDataSetLock = new Integer(1);
    private PSDEDataSet psdedataset = null;
    private Integer objInPSDEFGroupLock = new Integer(1);
    private PSDEFGroup inpsdefgroup = null;
    private Integer objOutPSDEFGroupLock = new Integer(1);
    private PSDEFGroup outpsdefgroup = null;
    private Integer objOutRefPSDEFGroupLock = new Integer(1);
    private PSDEFGroup outrefpsdefgroup = null;
    private Integer objPSDEDataFlowLock = new Integer(1);
    private PSDELogic psdedataflow = null;
    private Integer objPSDELogicLock = new Integer(1);
    private PSDELogic psdelogic = null;
    private Integer objPSDEOPPrivLock = new Integer(1);
    private PSDEOPPriv psdeoppriv = null;
    private Integer objInPSDESampleDataLock = new Integer(1);
    private PSDESampleData inpsdesampledata = null;
    private Integer objOutPSDESampleDataLock = new Integer(1);
    private PSDESampleData outpsdesampledata = null;
    private Integer objPSDESysProcLock = new Integer(1);
    private PSDESysProc psdesysproc = null;
    private Integer objPSSubSysSADetailLock = new Integer(1);
    private PSSubSysSADetail pssubsyssadetail = null;
    private Integer objInPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel inpssysdynamodel = null;
    private Integer objOutPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel outpssysdynamodel = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin pssyspfplugin = null;
    private Integer objPSSysReqItemLock = new Integer(1);
    private PSSysReqItem pssysreqitem = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
    private Integer objPSSysTaskLock = new Integer(1);
    private PSSysTask pssystask = null;
    private Integer objPSSysUniStateLock = new Integer(1);
    private PSSysUniState pssysunistate = null;
    private Integer objPSDEActionLogicsLock = new Integer(1);
    private ArrayList<PSDEActionLogic> psdeactionlogics = null;
    private Integer objPSDEActionParamsLock = new Integer(1);
    private ArrayList<PSDEActionParam> psdeactionparams = null;
    private Integer objPSDEActionVRsLock = new Integer(1);
    private ArrayList<PSDEActionVR> psdeactionvrs = null;
    private Integer objPSDEMSActionsLock = new Integer(1);
    private ArrayList<PSDEMSAction> psdemsactions = null;
    private Integer objPSSysTestCasesLock = new Integer(1);
    private ArrayList<PSSysTestCase> pssystestcases = null;

    public void setActionHolder(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionHolder(n);
            return;
        }
        this.actionholder = n;
        this.actionholderDirtyFlag = true;
    }

    public Integer getActionHolder() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionHolder();
        }
        return this.actionholder;
    }

    public boolean isActionHolderDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionHolderDirty();
        }
        return this.actionholderDirtyFlag;
    }

    public void resetActionHolder() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionHolder();
            return;
        }
        this.actionholderDirtyFlag = false;
        this.actionholder = null;
    }

    public void setActionMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actionmode = string;
        this.actionmodeDirtyFlag = true;
    }

    public String getActionMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionMode();
        }
        return this.actionmode;
    }

    public boolean isActionModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionModeDirty();
        }
        return this.actionmodeDirtyFlag;
    }

    public void resetActionMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionMode();
            return;
        }
        this.actionmodeDirtyFlag = false;
        this.actionmode = null;
    }

    public void setActionOption(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionOption(n);
            return;
        }
        this.actionoption = n;
        this.actionoptionDirtyFlag = true;
    }

    public Integer getActionOption() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionOption();
        }
        return this.actionoption;
    }

    public boolean isActionOptionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionOptionDirty();
        }
        return this.actionoptionDirtyFlag;
    }

    public void resetActionOption() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionOption();
            return;
        }
        this.actionoptionDirtyFlag = false;
        this.actionoption = null;
    }

    public void setActionParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actionparams = string;
        this.actionparamsDirtyFlag = true;
    }

    public String getActionParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionParams();
        }
        return this.actionparams;
    }

    public boolean isActionParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionParamsDirty();
        }
        return this.actionparamsDirtyFlag;
    }

    public void resetActionParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionParams();
            return;
        }
        this.actionparamsDirtyFlag = false;
        this.actionparams = null;
    }

    public void setActionTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actiontag = string;
        this.actiontagDirtyFlag = true;
    }

    public String getActionTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionTag();
        }
        return this.actiontag;
    }

    public boolean isActionTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionTagDirty();
        }
        return this.actiontagDirtyFlag;
    }

    public void resetActionTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionTag();
            return;
        }
        this.actiontagDirtyFlag = false;
        this.actiontag = null;
    }

    public void setActionTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actiontag2 = string;
        this.actiontag2DirtyFlag = true;
    }

    public String getActionTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionTag2();
        }
        return this.actiontag2;
    }

    public boolean isActionTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionTag2Dirty();
        }
        return this.actiontag2DirtyFlag;
    }

    public void resetActionTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionTag2();
            return;
        }
        this.actiontag2DirtyFlag = false;
        this.actiontag2 = null;
    }

    public void setActionTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actiontag3 = string;
        this.actiontag3DirtyFlag = true;
    }

    public String getActionTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionTag3();
        }
        return this.actiontag3;
    }

    public boolean isActionTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionTag3Dirty();
        }
        return this.actiontag3DirtyFlag;
    }

    public void resetActionTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionTag3();
            return;
        }
        this.actiontag3DirtyFlag = false;
        this.actiontag3 = null;
    }

    public void setActionTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actiontag4 = string;
        this.actiontag4DirtyFlag = true;
    }

    public String getActionTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionTag4();
        }
        return this.actiontag4;
    }

    public boolean isActionTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionTag4Dirty();
        }
        return this.actiontag4DirtyFlag;
    }

    public void resetActionTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionTag4();
            return;
        }
        this.actiontag4DirtyFlag = false;
        this.actiontag4 = null;
    }

    public void setActionType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actiontype = string;
        this.actiontypeDirtyFlag = true;
    }

    public String getActionType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionType();
        }
        return this.actiontype;
    }

    public boolean isActionTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionTypeDirty();
        }
        return this.actiontypeDirtyFlag;
    }

    public void resetActionType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionType();
            return;
        }
        this.actiontypeDirtyFlag = false;
        this.actiontype = null;
    }

    public void setAfterCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAfterCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.aftercode = string;
        this.aftercodeDirtyFlag = true;
    }

    public String getAfterCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAfterCode();
        }
        return this.aftercode;
    }

    public boolean isAfterCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAfterCodeDirty();
        }
        return this.aftercodeDirtyFlag;
    }

    public void resetAfterCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAfterCode();
            return;
        }
        this.aftercodeDirtyFlag = false;
        this.aftercode = null;
    }

    public void setBatchActionMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBatchActionMode(n);
            return;
        }
        this.batchactionmode = n;
        this.batchactionmodeDirtyFlag = true;
    }

    public Integer getBatchActionMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBatchActionMode();
        }
        return this.batchactionmode;
    }

    public boolean isBatchActionModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBatchActionModeDirty();
        }
        return this.batchactionmodeDirtyFlag;
    }

    public void resetBatchActionMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBatchActionMode();
            return;
        }
        this.batchactionmodeDirtyFlag = false;
        this.batchactionmode = null;
    }

    public void setBeforeCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBeforeCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.beforecode = string;
        this.beforecodeDirtyFlag = true;
    }

    public String getBeforeCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBeforeCode();
        }
        return this.beforecode;
    }

    public boolean isBeforeCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBeforeCodeDirty();
        }
        return this.beforecodeDirtyFlag;
    }

    public void resetBeforeCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBeforeCode();
            return;
        }
        this.beforecodeDirtyFlag = false;
        this.beforecode = null;
    }

    public void setCacheCat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCacheCat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cachecat = string;
        this.cachecatDirtyFlag = true;
    }

    public String getCacheCat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCacheCat();
        }
        return this.cachecat;
    }

    public boolean isCacheCatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCacheCatDirty();
        }
        return this.cachecatDirtyFlag;
    }

    public void resetCacheCat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCacheCat();
            return;
        }
        this.cachecatDirtyFlag = false;
        this.cachecat = null;
    }

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

    public void setCacheTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCacheTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cachetag = string;
        this.cachetagDirtyFlag = true;
    }

    public String getCacheTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCacheTag();
        }
        return this.cachetag;
    }

    public boolean isCacheTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCacheTagDirty();
        }
        return this.cachetagDirtyFlag;
    }

    public void resetCacheTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCacheTag();
            return;
        }
        this.cachetagDirtyFlag = false;
        this.cachetag = null;
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

    public void setCallerObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCallerObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.callerobj = string;
        this.callerobjDirtyFlag = true;
    }

    public String getCallerObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCallerObj();
        }
        return this.callerobj;
    }

    public boolean isCallerObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCallerObjDirty();
        }
        return this.callerobjDirtyFlag;
    }

    public void resetCallerObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCallerObj();
            return;
        }
        this.callerobjDirtyFlag = false;
        this.callerobj = null;
    }

    public void setCallTimeout(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCallTimeout(n);
            return;
        }
        this.calltimeout = n;
        this.calltimeoutDirtyFlag = true;
    }

    public Integer getCallTimeout() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCallTimeout();
        }
        return this.calltimeout;
    }

    public boolean isCallTimeoutDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCallTimeoutDirty();
        }
        return this.calltimeoutDirtyFlag;
    }

    public void resetCallTimeout() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCallTimeout();
            return;
        }
        this.calltimeoutDirtyFlag = false;
        this.calltimeout = null;
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

    public void setEnableAudit(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableAudit(n);
            return;
        }
        this.enableaudit = n;
        this.enableauditDirtyFlag = true;
    }

    public Integer getEnableAudit() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableAudit();
        }
        return this.enableaudit;
    }

    public boolean isEnableAuditDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableAuditDirty();
        }
        return this.enableauditDirtyFlag;
    }

    public void resetEnableAudit() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableAudit();
            return;
        }
        this.enableauditDirtyFlag = false;
        this.enableaudit = null;
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

    public void setExtendMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExtendMode(n);
            return;
        }
        this.extendmode = n;
        this.extendmodeDirtyFlag = true;
    }

    public Integer getExtendMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExtendMode();
        }
        return this.extendmode;
    }

    public boolean isExtendModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExtendModeDirty();
        }
        return this.extendmodeDirtyFlag;
    }

    public void resetExtendMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExtendMode();
            return;
        }
        this.extendmodeDirtyFlag = false;
        this.extendmode = null;
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

    public void setInPSDEFGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInPSDEFGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.inpsdefgroupid = string;
        this.inpsdefgroupidDirtyFlag = true;
    }

    public String getInPSDEFGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInPSDEFGroupId();
        }
        return this.inpsdefgroupid;
    }

    public boolean isInPSDEFGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInPSDEFGroupIdDirty();
        }
        return this.inpsdefgroupidDirtyFlag;
    }

    public void resetInPSDEFGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInPSDEFGroupId();
            return;
        }
        this.inpsdefgroupidDirtyFlag = false;
        this.inpsdefgroupid = null;
    }

    public void setInPSDEFGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInPSDEFGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.inpsdefgroupname = string;
        this.inpsdefgroupnameDirtyFlag = true;
    }

    public String getInPSDEFGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInPSDEFGroupName();
        }
        return this.inpsdefgroupname;
    }

    public boolean isInPSDEFGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInPSDEFGroupNameDirty();
        }
        return this.inpsdefgroupnameDirtyFlag;
    }

    public void resetInPSDEFGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInPSDEFGroupName();
            return;
        }
        this.inpsdefgroupnameDirtyFlag = false;
        this.inpsdefgroupname = null;
    }

    public void setInPSDESampleDataId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInPSDESampleDataId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.inpsdesampledataid = string;
        this.inpsdesampledataidDirtyFlag = true;
    }

    public String getInPSDESampleDataId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInPSDESampleDataId();
        }
        return this.inpsdesampledataid;
    }

    public boolean isInPSDESampleDataIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInPSDESampleDataIdDirty();
        }
        return this.inpsdesampledataidDirtyFlag;
    }

    public void resetInPSDESampleDataId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInPSDESampleDataId();
            return;
        }
        this.inpsdesampledataidDirtyFlag = false;
        this.inpsdesampledataid = null;
    }

    public void setInPSDESampleDataName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInPSDESampleDataName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.inpsdesampledataname = string;
        this.inpsdesampledatanameDirtyFlag = true;
    }

    public String getInPSDESampleDataName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInPSDESampleDataName();
        }
        return this.inpsdesampledataname;
    }

    public boolean isInPSDESampleDataNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInPSDESampleDataNameDirty();
        }
        return this.inpsdesampledatanameDirtyFlag;
    }

    public void resetInPSDESampleDataName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInPSDESampleDataName();
            return;
        }
        this.inpsdesampledatanameDirtyFlag = false;
        this.inpsdesampledataname = null;
    }

    public void setInPSSysDynaModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInPSSysDynaModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.inpssysdynamodelid = string;
        this.inpssysdynamodelidDirtyFlag = true;
    }

    public String getInPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInPSSysDynaModelId();
        }
        return this.inpssysdynamodelid;
    }

    public boolean isInPSSysDynaModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInPSSysDynaModelIdDirty();
        }
        return this.inpssysdynamodelidDirtyFlag;
    }

    public void resetInPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInPSSysDynaModelId();
            return;
        }
        this.inpssysdynamodelidDirtyFlag = false;
        this.inpssysdynamodelid = null;
    }

    public void setInPSSysDynaModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInPSSysDynaModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.inpssysdynamodelname = string;
        this.inpssysdynamodelnameDirtyFlag = true;
    }

    public String getInPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInPSSysDynaModelName();
        }
        return this.inpssysdynamodelname;
    }

    public boolean isInPSSysDynaModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInPSSysDynaModelNameDirty();
        }
        return this.inpssysdynamodelnameDirtyFlag;
    }

    public void resetInPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInPSSysDynaModelName();
            return;
        }
        this.inpssysdynamodelnameDirtyFlag = false;
        this.inpssysdynamodelname = null;
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

    public void setNeedResourceKey(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNeedResourceKey(n);
            return;
        }
        this.needresourcekey = n;
        this.needresourcekeyDirtyFlag = true;
    }

    public Integer getNeedResourceKey() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNeedResourceKey();
        }
        return this.needresourcekey;
    }

    public boolean isNeedResourceKeyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNeedResourceKeyDirty();
        }
        return this.needresourcekeyDirtyFlag;
    }

    public void resetNeedResourceKey() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNeedResourceKey();
            return;
        }
        this.needresourcekeyDirtyFlag = false;
        this.needresourcekey = null;
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

    public void setOutPSDEFGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOutPSDEFGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.outpsdefgroupid = string;
        this.outpsdefgroupidDirtyFlag = true;
    }

    public String getOutPSDEFGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOutPSDEFGroupId();
        }
        return this.outpsdefgroupid;
    }

    public boolean isOutPSDEFGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOutPSDEFGroupIdDirty();
        }
        return this.outpsdefgroupidDirtyFlag;
    }

    public void resetOutPSDEFGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOutPSDEFGroupId();
            return;
        }
        this.outpsdefgroupidDirtyFlag = false;
        this.outpsdefgroupid = null;
    }

    public void setOutPSDEFGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOutPSDEFGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.outpsdefgroupname = string;
        this.outpsdefgroupnameDirtyFlag = true;
    }

    public String getOutPSDEFGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOutPSDEFGroupName();
        }
        return this.outpsdefgroupname;
    }

    public boolean isOutPSDEFGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOutPSDEFGroupNameDirty();
        }
        return this.outpsdefgroupnameDirtyFlag;
    }

    public void resetOutPSDEFGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOutPSDEFGroupName();
            return;
        }
        this.outpsdefgroupnameDirtyFlag = false;
        this.outpsdefgroupname = null;
    }

    public void setOutPSDESampleDataId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOutPSDESampleDataId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.outpsdesampledataid = string;
        this.outpsdesampledataidDirtyFlag = true;
    }

    public String getOutPSDESampleDataId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOutPSDESampleDataId();
        }
        return this.outpsdesampledataid;
    }

    public boolean isOutPSDESampleDataIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOutPSDESampleDataIdDirty();
        }
        return this.outpsdesampledataidDirtyFlag;
    }

    public void resetOutPSDESampleDataId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOutPSDESampleDataId();
            return;
        }
        this.outpsdesampledataidDirtyFlag = false;
        this.outpsdesampledataid = null;
    }

    public void setOutPSDESampleDataName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOutPSDESampleDataName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.outpsdesampledataname = string;
        this.outpsdesampledatanameDirtyFlag = true;
    }

    public String getOutPSDESampleDataName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOutPSDESampleDataName();
        }
        return this.outpsdesampledataname;
    }

    public boolean isOutPSDESampleDataNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOutPSDESampleDataNameDirty();
        }
        return this.outpsdesampledatanameDirtyFlag;
    }

    public void resetOutPSDESampleDataName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOutPSDESampleDataName();
            return;
        }
        this.outpsdesampledatanameDirtyFlag = false;
        this.outpsdesampledataname = null;
    }

    public void setOutPSSysDynaModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOutPSSysDynaModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.outpssysdynamodelid = string;
        this.outpssysdynamodelidDirtyFlag = true;
    }

    public String getOutPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOutPSSysDynaModelId();
        }
        return this.outpssysdynamodelid;
    }

    public boolean isOutPSSysDynaModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOutPSSysDynaModelIdDirty();
        }
        return this.outpssysdynamodelidDirtyFlag;
    }

    public void resetOutPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOutPSSysDynaModelId();
            return;
        }
        this.outpssysdynamodelidDirtyFlag = false;
        this.outpssysdynamodelid = null;
    }

    public void setOutPSSysDynaModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOutPSSysDynaModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.outpssysdynamodelname = string;
        this.outpssysdynamodelnameDirtyFlag = true;
    }

    public String getOutPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOutPSSysDynaModelName();
        }
        return this.outpssysdynamodelname;
    }

    public boolean isOutPSSysDynaModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOutPSSysDynaModelNameDirty();
        }
        return this.outpssysdynamodelnameDirtyFlag;
    }

    public void resetOutPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOutPSSysDynaModelName();
            return;
        }
        this.outpssysdynamodelnameDirtyFlag = false;
        this.outpssysdynamodelname = null;
    }

    public void setOutRefPSDEFGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOutRefPSDEFGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.outrefpsdefgroupid = string;
        this.outrefpsdefgroupidDirtyFlag = true;
    }

    public String getOutRefPSDEFGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOutRefPSDEFGroupId();
        }
        return this.outrefpsdefgroupid;
    }

    public boolean isOutRefPSDEFGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOutRefPSDEFGroupIdDirty();
        }
        return this.outrefpsdefgroupidDirtyFlag;
    }

    public void resetOutRefPSDEFGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOutRefPSDEFGroupId();
            return;
        }
        this.outrefpsdefgroupidDirtyFlag = false;
        this.outrefpsdefgroupid = null;
    }

    public void setOutRefPSDEFGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOutRefPSDEFGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.outrefpsdefgroupname = string;
        this.outrefpsdefgroupnameDirtyFlag = true;
    }

    public String getOutRefPSDEFGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOutRefPSDEFGroupName();
        }
        return this.outrefpsdefgroupname;
    }

    public boolean isOutRefPSDEFGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOutRefPSDEFGroupNameDirty();
        }
        return this.outrefpsdefgroupnameDirtyFlag;
    }

    public void resetOutRefPSDEFGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOutRefPSDEFGroupName();
            return;
        }
        this.outrefpsdefgroupnameDirtyFlag = false;
        this.outrefpsdefgroupname = null;
    }

    public void setOutRefPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOutRefPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.outrefpsdeid = string;
        this.outrefpsdeidDirtyFlag = true;
    }

    public String getOutRefPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOutRefPSDEId();
        }
        return this.outrefpsdeid;
    }

    public boolean isOutRefPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOutRefPSDEIdDirty();
        }
        return this.outrefpsdeidDirtyFlag;
    }

    public void resetOutRefPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOutRefPSDEId();
            return;
        }
        this.outrefpsdeidDirtyFlag = false;
        this.outrefpsdeid = null;
    }

    public void setOutRefPSDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOutRefPSDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.outrefpsdename = string;
        this.outrefpsdenameDirtyFlag = true;
    }

    public String getOutRefPSDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOutRefPSDEName();
        }
        return this.outrefpsdename;
    }

    public boolean isOutRefPSDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOutRefPSDENameDirty();
        }
        return this.outrefpsdenameDirtyFlag;
    }

    public void resetOutRefPSDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOutRefPSDEName();
            return;
        }
        this.outrefpsdenameDirtyFlag = false;
        this.outrefpsdename = null;
    }

    public void setParamType(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParamType(n);
            return;
        }
        this.paramtype = n;
        this.paramtypeDirtyFlag = true;
    }

    public Integer getParamType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamType();
        }
        return this.paramtype;
    }

    public boolean isParamTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamTypeDirty();
        }
        return this.paramtypeDirtyFlag;
    }

    public void resetParamType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParamType();
            return;
        }
        this.paramtypeDirtyFlag = false;
        this.paramtype = null;
    }

    public void setPOTime(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPOTime(n);
            return;
        }
        this.potime = n;
        this.potimeDirtyFlag = true;
    }

    public Integer getPOTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPOTime();
        }
        return this.potime;
    }

    public boolean isPOTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPOTimeDirty();
        }
        return this.potimeDirtyFlag;
    }

    public void resetPOTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPOTime();
            return;
        }
        this.potimeDirtyFlag = false;
        this.potime = null;
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

    public void setPredefinedTypeParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPredefinedTypeParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.predefinedtypeparam = string;
        this.predefinedtypeparamDirtyFlag = true;
    }

    public String getPredefinedTypeParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPredefinedTypeParam();
        }
        return this.predefinedtypeparam;
    }

    public boolean isPredefinedTypeParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPredefinedTypeParamDirty();
        }
        return this.predefinedtypeparamDirtyFlag;
    }

    public void resetPredefinedTypeParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPredefinedTypeParam();
            return;
        }
        this.predefinedtypeparamDirtyFlag = false;
        this.predefinedtypeparam = null;
    }

    public void setPredefinedTypeText(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPredefinedTypeText(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.predefinedtypetext = string;
        this.predefinedtypetextDirtyFlag = true;
    }

    public String getPredefinedTypeText() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPredefinedTypeText();
        }
        return this.predefinedtypetext;
    }

    public boolean isPredefinedTypeTextDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPredefinedTypeTextDirty();
        }
        return this.predefinedtypetextDirtyFlag;
    }

    public void resetPredefinedTypeText() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPredefinedTypeText();
            return;
        }
        this.predefinedtypetextDirtyFlag = false;
        this.predefinedtypetext = null;
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

    public void setPSDEActionLogicsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEActionLogicsCnt(n);
            return;
        }
        this.psdeactionlogicscnt = n;
        this.psdeactionlogicscntDirtyFlag = true;
    }

    public Integer getPSDEActionLogicsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionLogicsCnt();
        }
        return this.psdeactionlogicscnt;
    }

    public boolean isPSDEActionLogicsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEActionLogicsCntDirty();
        }
        return this.psdeactionlogicscntDirtyFlag;
    }

    public void resetPSDEActionLogicsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEActionLogicsCnt();
            return;
        }
        this.psdeactionlogicscntDirtyFlag = false;
        this.psdeactionlogicscnt = null;
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

    public void setPSDEActionTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEActionTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeactiontemplid = string;
        this.psdeactiontemplidDirtyFlag = true;
    }

    public String getPSDEActionTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionTemplId();
        }
        return this.psdeactiontemplid;
    }

    public boolean isPSDEActionTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEActionTemplIdDirty();
        }
        return this.psdeactiontemplidDirtyFlag;
    }

    public void resetPSDEActionTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEActionTemplId();
            return;
        }
        this.psdeactiontemplidDirtyFlag = false;
        this.psdeactiontemplid = null;
    }

    public void setPSDEActionTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEActionTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeactiontemplname = string;
        this.psdeactiontemplnameDirtyFlag = true;
    }

    public String getPSDEActionTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionTemplName();
        }
        return this.psdeactiontemplname;
    }

    public boolean isPSDEActionTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEActionTemplNameDirty();
        }
        return this.psdeactiontemplnameDirtyFlag;
    }

    public void resetPSDEActionTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEActionTemplName();
            return;
        }
        this.psdeactiontemplnameDirtyFlag = false;
        this.psdeactiontemplname = null;
    }

    public void setPSDEDataFlowId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataFlowId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedataflowid = string;
        this.psdedataflowidDirtyFlag = true;
    }

    public String getPSDEDataFlowId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataFlowId();
        }
        return this.psdedataflowid;
    }

    public boolean isPSDEDataFlowIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataFlowIdDirty();
        }
        return this.psdedataflowidDirtyFlag;
    }

    public void resetPSDEDataFlowId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataFlowId();
            return;
        }
        this.psdedataflowidDirtyFlag = false;
        this.psdedataflowid = null;
    }

    public void setPSDEDataFlowName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataFlowName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedataflowname = string;
        this.psdedataflownameDirtyFlag = true;
    }

    public String getPSDEDataFlowName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataFlowName();
        }
        return this.psdedataflowname;
    }

    public boolean isPSDEDataFlowNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataFlowNameDirty();
        }
        return this.psdedataflownameDirtyFlag;
    }

    public void resetPSDEDataFlowName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataFlowName();
            return;
        }
        this.psdedataflownameDirtyFlag = false;
        this.psdedataflowname = null;
    }

    public void setPSDEDataQueryId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataQueryId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedataqueryid = string;
        this.psdedataqueryidDirtyFlag = true;
    }

    public String getPSDEDataQueryId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataQueryId();
        }
        return this.psdedataqueryid;
    }

    public boolean isPSDEDataQueryIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataQueryIdDirty();
        }
        return this.psdedataqueryidDirtyFlag;
    }

    public void resetPSDEDataQueryId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataQueryId();
            return;
        }
        this.psdedataqueryidDirtyFlag = false;
        this.psdedataqueryid = null;
    }

    public void setPSDEDataQueryName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataQueryName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedataqueryname = string;
        this.psdedataquerynameDirtyFlag = true;
    }

    public String getPSDEDataQueryName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataQueryName();
        }
        return this.psdedataqueryname;
    }

    public boolean isPSDEDataQueryNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataQueryNameDirty();
        }
        return this.psdedataquerynameDirtyFlag;
    }

    public void resetPSDEDataQueryName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataQueryName();
            return;
        }
        this.psdedataquerynameDirtyFlag = false;
        this.psdedataqueryname = null;
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

    public void setPSDEMSActionsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEMSActionsCnt(n);
            return;
        }
        this.psdemsactionscnt = n;
        this.psdemsactionscntDirtyFlag = true;
    }

    public Integer getPSDEMSActionsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMSActionsCnt();
        }
        return this.psdemsactionscnt;
    }

    public boolean isPSDEMSActionsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEMSActionsCntDirty();
        }
        return this.psdemsactionscntDirtyFlag;
    }

    public void resetPSDEMSActionsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEMSActionsCnt();
            return;
        }
        this.psdemsactionscntDirtyFlag = false;
        this.psdemsactionscnt = null;
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

    public void setPSDESysProcId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDESysProcId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdesysprocid = string;
        this.psdesysprocidDirtyFlag = true;
    }

    public String getPSDESysProcId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDESysProcId();
        }
        return this.psdesysprocid;
    }

    public boolean isPSDESysProcIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDESysProcIdDirty();
        }
        return this.psdesysprocidDirtyFlag;
    }

    public void resetPSDESysProcId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDESysProcId();
            return;
        }
        this.psdesysprocidDirtyFlag = false;
        this.psdesysprocid = null;
    }

    public void setPSDESysProcName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDESysProcName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdesysprocname = string;
        this.psdesysprocnameDirtyFlag = true;
    }

    public String getPSDESysProcName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDESysProcName();
        }
        return this.psdesysprocname;
    }

    public boolean isPSDESysProcNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDESysProcNameDirty();
        }
        return this.psdesysprocnameDirtyFlag;
    }

    public void resetPSDESysProcName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDESysProcName();
            return;
        }
        this.psdesysprocnameDirtyFlag = false;
        this.psdesysprocname = null;
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

    public void setPSSubSysSADEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysSADEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsyssadeid = string;
        this.pssubsyssadeidDirtyFlag = true;
    }

    public String getPSSubSysSADEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysSADEId();
        }
        return this.pssubsyssadeid;
    }

    public boolean isPSSubSysSADEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysSADEIdDirty();
        }
        return this.pssubsyssadeidDirtyFlag;
    }

    public void resetPSSubSysSADEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysSADEId();
            return;
        }
        this.pssubsyssadeidDirtyFlag = false;
        this.pssubsyssadeid = null;
    }

    public void setPSSubSysSADetailId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysSADetailId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsyssadetailid = string;
        this.pssubsyssadetailidDirtyFlag = true;
    }

    public String getPSSubSysSADetailId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysSADetailId();
        }
        return this.pssubsyssadetailid;
    }

    public boolean isPSSubSysSADetailIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysSADetailIdDirty();
        }
        return this.pssubsyssadetailidDirtyFlag;
    }

    public void resetPSSubSysSADetailId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysSADetailId();
            return;
        }
        this.pssubsyssadetailidDirtyFlag = false;
        this.pssubsyssadetailid = null;
    }

    public void setPSSubSysSADetailName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysSADetailName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsyssadetailname = string;
        this.pssubsyssadetailnameDirtyFlag = true;
    }

    public String getPSSubSysSADetailName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysSADetailName();
        }
        return this.pssubsyssadetailname;
    }

    public boolean isPSSubSysSADetailNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysSADetailNameDirty();
        }
        return this.pssubsyssadetailnameDirtyFlag;
    }

    public void resetPSSubSysSADetailName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysSADetailName();
            return;
        }
        this.pssubsyssadetailnameDirtyFlag = false;
        this.pssubsyssadetailname = null;
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

    public void setPSSysTestCasesCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTestCasesCnt(n);
            return;
        }
        this.pssystestcasescnt = n;
        this.pssystestcasescntDirtyFlag = true;
    }

    public Integer getPSSysTestCasesCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTestCasesCnt();
        }
        return this.pssystestcasescnt;
    }

    public boolean isPSSysTestCasesCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTestCasesCntDirty();
        }
        return this.pssystestcasescntDirtyFlag;
    }

    public void resetPSSysTestCasesCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTestCasesCnt();
            return;
        }
        this.pssystestcasescntDirtyFlag = false;
        this.pssystestcasescnt = null;
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

    public void setPubMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPubMode(n);
            return;
        }
        this.pubmode = n;
        this.pubmodeDirtyFlag = true;
    }

    public Integer getPubMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPubMode();
        }
        return this.pubmode;
    }

    public boolean isPubModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPubModeDirty();
        }
        return this.pubmodeDirtyFlag;
    }

    public void resetPubMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPubMode();
            return;
        }
        this.pubmodeDirtyFlag = false;
        this.pubmode = null;
    }

    public void setRawServiceMethod(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRawServiceMethod(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rawservicemethod = string;
        this.rawservicemethodDirtyFlag = true;
    }

    public String getRawServiceMethod() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRawServiceMethod();
        }
        return this.rawservicemethod;
    }

    public boolean isRawServiceMethodDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRawServiceMethodDirty();
        }
        return this.rawservicemethodDirtyFlag;
    }

    public void resetRawServiceMethod() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRawServiceMethod();
            return;
        }
        this.rawservicemethodDirtyFlag = false;
        this.rawservicemethod = null;
    }

    public void setRawServiceUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRawServiceUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rawserviceurl = string;
        this.rawserviceurlDirtyFlag = true;
    }

    public String getRawServiceUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRawServiceUrl();
        }
        return this.rawserviceurl;
    }

    public boolean isRawServiceUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRawServiceUrlDirty();
        }
        return this.rawserviceurlDirtyFlag;
    }

    public void resetRawServiceUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRawServiceUrl();
            return;
        }
        this.rawserviceurlDirtyFlag = false;
        this.rawserviceurl = null;
    }

    public void setRequestField(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRequestField(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.requestfield = string;
        this.requestfieldDirtyFlag = true;
    }

    public String getRequestField() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRequestField();
        }
        return this.requestfield;
    }

    public boolean isRequestFieldDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRequestFieldDirty();
        }
        return this.requestfieldDirtyFlag;
    }

    public void resetRequestField() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRequestField();
            return;
        }
        this.requestfieldDirtyFlag = false;
        this.requestfield = null;
    }

    public void setRequestMethod(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRequestMethod(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.requestmethod = string;
        this.requestmethodDirtyFlag = true;
    }

    public String getRequestMethod() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRequestMethod();
        }
        return this.requestmethod;
    }

    public boolean isRequestMethodDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRequestMethodDirty();
        }
        return this.requestmethodDirtyFlag;
    }

    public void resetRequestMethod() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRequestMethod();
            return;
        }
        this.requestmethodDirtyFlag = false;
        this.requestmethod = null;
    }

    public void setRequestParamType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRequestParamType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.requestparamtype = string;
        this.requestparamtypeDirtyFlag = true;
    }

    public String getRequestParamType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRequestParamType();
        }
        return this.requestparamtype;
    }

    public boolean isRequestParamTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRequestParamTypeDirty();
        }
        return this.requestparamtypeDirtyFlag;
    }

    public void resetRequestParamType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRequestParamType();
            return;
        }
        this.requestparamtypeDirtyFlag = false;
        this.requestparamtype = null;
    }

    public void setRequestPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRequestPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.requestpath = string;
        this.requestpathDirtyFlag = true;
    }

    public String getRequestPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRequestPath();
        }
        return this.requestpath;
    }

    public boolean isRequestPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRequestPathDirty();
        }
        return this.requestpathDirtyFlag;
    }

    public void resetRequestPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRequestPath();
            return;
        }
        this.requestpathDirtyFlag = false;
        this.requestpath = null;
    }

    public void setRetStdDataType(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRetStdDataType(n);
            return;
        }
        this.retstddatatype = n;
        this.retstddatatypeDirtyFlag = true;
    }

    public Integer getRetStdDataType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRetStdDataType();
        }
        return this.retstddatatype;
    }

    public boolean isRetStdDataTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRetStdDataTypeDirty();
        }
        return this.retstddatatypeDirtyFlag;
    }

    public void resetRetStdDataType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRetStdDataType();
            return;
        }
        this.retstddatatypeDirtyFlag = false;
        this.retstddatatype = null;
    }

    public void setRetValType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRetValType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.retvaltype = string;
        this.retvaltypeDirtyFlag = true;
    }

    public String getRetValType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRetValType();
        }
        return this.retvaltype;
    }

    public boolean isRetValTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRetValTypeDirty();
        }
        return this.retvaltypeDirtyFlag;
    }

    public void resetRetValType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRetValType();
            return;
        }
        this.retvaltypeDirtyFlag = false;
        this.retvaltype = null;
    }

    public void setServiceCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServiceCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.servicecodename = string;
        this.servicecodenameDirtyFlag = true;
    }

    public String getServiceCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServiceCodeName();
        }
        return this.servicecodename;
    }

    public boolean isServiceCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServiceCodeNameDirty();
        }
        return this.servicecodenameDirtyFlag;
    }

    public void resetServiceCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServiceCodeName();
            return;
        }
        this.servicecodenameDirtyFlag = false;
        this.servicecodename = null;
    }

    public void setSubSysSADetailMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSubSysSADetailMode(n);
            return;
        }
        this.subsyssadetailmode = n;
        this.subsyssadetailmodeDirtyFlag = true;
    }

    public Integer getSubSysSADetailMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSubSysSADetailMode();
        }
        return this.subsyssadetailmode;
    }

    public boolean isSubSysSADetailModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSubSysSADetailModeDirty();
        }
        return this.subsyssadetailmodeDirtyFlag;
    }

    public void resetSubSysSADetailMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSubSysSADetailMode();
            return;
        }
        this.subsyssadetailmodeDirtyFlag = false;
        this.subsyssadetailmode = null;
    }

    public void setSyncEvent(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSyncEvent(n);
            return;
        }
        this.syncevent = n;
        this.synceventDirtyFlag = true;
    }

    public Integer getSyncEvent() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSyncEvent();
        }
        return this.syncevent;
    }

    public boolean isSyncEventDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSyncEventDirty();
        }
        return this.synceventDirtyFlag;
    }

    public void resetSyncEvent() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSyncEvent();
            return;
        }
        this.synceventDirtyFlag = false;
        this.syncevent = null;
    }

    public void setTestActionMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTestActionMode(n);
            return;
        }
        this.testactionmode = n;
        this.testactionmodeDirtyFlag = true;
    }

    public Integer getTestActionMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTestActionMode();
        }
        return this.testactionmode;
    }

    public boolean isTestActionModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTestActionModeDirty();
        }
        return this.testactionmodeDirtyFlag;
    }

    public void resetTestActionMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTestActionMode();
            return;
        }
        this.testactionmodeDirtyFlag = false;
        this.testactionmode = null;
    }

    public void setTestCaseFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTestCaseFlag(n);
            return;
        }
        this.testcaseflag = n;
        this.testcaseflagDirtyFlag = true;
    }

    public Integer getTestCaseFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTestCaseFlag();
        }
        return this.testcaseflag;
    }

    public boolean isTestCaseFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTestCaseFlagDirty();
        }
        return this.testcaseflagDirtyFlag;
    }

    public void resetTestCaseFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTestCaseFlag();
            return;
        }
        this.testcaseflagDirtyFlag = false;
        this.testcaseflag = null;
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

    public void setTSMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTSMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tsmode = string;
        this.tsmodeDirtyFlag = true;
    }

    public String getTSMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTSMode();
        }
        return this.tsmode;
    }

    public boolean isTSModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTSModeDirty();
        }
        return this.tsmodeDirtyFlag;
    }

    public void resetTSMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTSMode();
            return;
        }
        this.tsmodeDirtyFlag = false;
        this.tsmode = null;
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
        PSDEActionBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEActionBase pSDEActionBase) {
        pSDEActionBase.resetActionHolder();
        pSDEActionBase.resetActionMode();
        pSDEActionBase.resetActionOption();
        pSDEActionBase.resetActionParams();
        pSDEActionBase.resetActionTag();
        pSDEActionBase.resetActionTag2();
        pSDEActionBase.resetActionTag3();
        pSDEActionBase.resetActionTag4();
        pSDEActionBase.resetActionType();
        pSDEActionBase.resetAfterCode();
        pSDEActionBase.resetBatchActionMode();
        pSDEActionBase.resetBeforeCode();
        pSDEActionBase.resetCacheCat();
        pSDEActionBase.resetCacheScope();
        pSDEActionBase.resetCacheTag();
        pSDEActionBase.resetCacheTimeout();
        pSDEActionBase.resetCallerObj();
        pSDEActionBase.resetCallTimeout();
        pSDEActionBase.resetCodeName();
        pSDEActionBase.resetCreateDate();
        pSDEActionBase.resetCreateMan();
        pSDEActionBase.resetCustomCode();
        pSDEActionBase.resetCustomMode();
        pSDEActionBase.resetDynaModelFlag();
        pSDEActionBase.resetEnableAudit();
        pSDEActionBase.resetEnableCache();
        pSDEActionBase.resetExtendMode();
        pSDEActionBase.resetFinishFlag();
        pSDEActionBase.resetInPSDEFGroupId();
        pSDEActionBase.resetInPSDEFGroupName();
        pSDEActionBase.resetInPSDESampleDataId();
        pSDEActionBase.resetInPSDESampleDataName();
        pSDEActionBase.resetInPSSysDynaModelId();
        pSDEActionBase.resetInPSSysDynaModelName();
        pSDEActionBase.resetLockFlag();
        pSDEActionBase.resetLogicName();
        pSDEActionBase.resetMemo();
        pSDEActionBase.resetNeedResourceKey();
        pSDEActionBase.resetOrderValue();
        pSDEActionBase.resetOutPSDEFGroupId();
        pSDEActionBase.resetOutPSDEFGroupName();
        pSDEActionBase.resetOutPSDESampleDataId();
        pSDEActionBase.resetOutPSDESampleDataName();
        pSDEActionBase.resetOutPSSysDynaModelId();
        pSDEActionBase.resetOutPSSysDynaModelName();
        pSDEActionBase.resetOutRefPSDEFGroupId();
        pSDEActionBase.resetOutRefPSDEFGroupName();
        pSDEActionBase.resetOutRefPSDEId();
        pSDEActionBase.resetOutRefPSDEName();
        pSDEActionBase.resetParamType();
        pSDEActionBase.resetPOTime();
        pSDEActionBase.resetPredefinedType();
        pSDEActionBase.resetPredefinedTypeParam();
        pSDEActionBase.resetPredefinedTypeText();
        pSDEActionBase.resetPrepareLast();
        pSDEActionBase.resetPSDEActionId();
        pSDEActionBase.resetPSDEActionLogicsCnt();
        pSDEActionBase.resetPSDEActionName();
        pSDEActionBase.resetPSDEActionTemplId();
        pSDEActionBase.resetPSDEActionTemplName();
        pSDEActionBase.resetPSDEDataFlowId();
        pSDEActionBase.resetPSDEDataFlowName();
        pSDEActionBase.resetPSDEDataQueryId();
        pSDEActionBase.resetPSDEDataQueryName();
        pSDEActionBase.resetPSDEDataSetId();
        pSDEActionBase.resetPSDEDataSetName();
        pSDEActionBase.resetPSDEId();
        pSDEActionBase.resetPSDELogicId();
        pSDEActionBase.resetPSDELogicName();
        pSDEActionBase.resetPSDEMSActionsCnt();
        pSDEActionBase.resetPSDEName();
        pSDEActionBase.resetPSDEOPPrivId();
        pSDEActionBase.resetPSDEOPPrivName();
        pSDEActionBase.resetPSDESysProcId();
        pSDEActionBase.resetPSDESysProcName();
        pSDEActionBase.resetPSDynaInstId();
        pSDEActionBase.resetPSSubSysSADEId();
        pSDEActionBase.resetPSSubSysSADetailId();
        pSDEActionBase.resetPSSubSysSADetailName();
        pSDEActionBase.resetPSSysDynaModelId();
        pSDEActionBase.resetPSSysDynaModelName();
        pSDEActionBase.resetPSSysPFPluginId();
        pSDEActionBase.resetPSSysPFPluginName();
        pSDEActionBase.resetPSSysReqItemId();
        pSDEActionBase.resetPSSysReqItemName();
        pSDEActionBase.resetPSSysSFPluginId();
        pSDEActionBase.resetPSSysSFPluginName();
        pSDEActionBase.resetPSSysTaskId();
        pSDEActionBase.resetPSSysTaskName();
        pSDEActionBase.resetPSSysTestCasesCnt();
        pSDEActionBase.resetPSSysUniStateId();
        pSDEActionBase.resetPSSysUniStateName();
        pSDEActionBase.resetPubMode();
        pSDEActionBase.resetRawServiceMethod();
        pSDEActionBase.resetRawServiceUrl();
        pSDEActionBase.resetRequestField();
        pSDEActionBase.resetRequestMethod();
        pSDEActionBase.resetRequestParamType();
        pSDEActionBase.resetRequestPath();
        pSDEActionBase.resetRetStdDataType();
        pSDEActionBase.resetRetValType();
        pSDEActionBase.resetServiceCodeName();
        pSDEActionBase.resetSubSysSADetailMode();
        pSDEActionBase.resetSyncEvent();
        pSDEActionBase.resetTestActionMode();
        pSDEActionBase.resetTestCaseFlag();
        pSDEActionBase.resetToDoTask();
        pSDEActionBase.resetTSMode();
        pSDEActionBase.resetUpdateDate();
        pSDEActionBase.resetUpdateMan();
        pSDEActionBase.resetUserCat();
        pSDEActionBase.resetUserParams();
        pSDEActionBase.resetUserTag();
        pSDEActionBase.resetUserTag2();
        pSDEActionBase.resetUserTag3();
        pSDEActionBase.resetUserTag4();
        pSDEActionBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isActionHolderDirty()) {
            hashMap.put(FIELD_ACTIONHOLDER, this.getActionHolder());
        }
        if (!bl || this.isActionModeDirty()) {
            hashMap.put(FIELD_ACTIONMODE, this.getActionMode());
        }
        if (!bl || this.isActionOptionDirty()) {
            hashMap.put(FIELD_ACTIONOPTION, this.getActionOption());
        }
        if (!bl || this.isActionParamsDirty()) {
            hashMap.put(FIELD_ACTIONPARAMS, this.getActionParams());
        }
        if (!bl || this.isActionTagDirty()) {
            hashMap.put(FIELD_ACTIONTAG, this.getActionTag());
        }
        if (!bl || this.isActionTag2Dirty()) {
            hashMap.put(FIELD_ACTIONTAG2, this.getActionTag2());
        }
        if (!bl || this.isActionTag3Dirty()) {
            hashMap.put(FIELD_ACTIONTAG3, this.getActionTag3());
        }
        if (!bl || this.isActionTag4Dirty()) {
            hashMap.put(FIELD_ACTIONTAG4, this.getActionTag4());
        }
        if (!bl || this.isActionTypeDirty()) {
            hashMap.put(FIELD_ACTIONTYPE, this.getActionType());
        }
        if (!bl || this.isAfterCodeDirty()) {
            hashMap.put(FIELD_AFTERCODE, this.getAfterCode());
        }
        if (!bl || this.isBatchActionModeDirty()) {
            hashMap.put(FIELD_BATCHACTIONMODE, this.getBatchActionMode());
        }
        if (!bl || this.isBeforeCodeDirty()) {
            hashMap.put(FIELD_BEFORECODE, this.getBeforeCode());
        }
        if (!bl || this.isCacheCatDirty()) {
            hashMap.put(FIELD_CACHECAT, this.getCacheCat());
        }
        if (!bl || this.isCacheScopeDirty()) {
            hashMap.put(FIELD_CACHESCOPE, this.getCacheScope());
        }
        if (!bl || this.isCacheTagDirty()) {
            hashMap.put(FIELD_CACHETAG, this.getCacheTag());
        }
        if (!bl || this.isCacheTimeoutDirty()) {
            hashMap.put(FIELD_CACHETIMEOUT, this.getCacheTimeout());
        }
        if (!bl || this.isCallerObjDirty()) {
            hashMap.put(FIELD_CALLEROBJ, this.getCallerObj());
        }
        if (!bl || this.isCallTimeoutDirty()) {
            hashMap.put(FIELD_CALLTIMEOUT, this.getCallTimeout());
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
        if (!bl || this.isCustomModeDirty()) {
            hashMap.put(FIELD_CUSTOMMODE, this.getCustomMode());
        }
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isEnableAuditDirty()) {
            hashMap.put(FIELD_ENABLEAUDIT, this.getEnableAudit());
        }
        if (!bl || this.isEnableCacheDirty()) {
            hashMap.put(FIELD_ENABLECACHE, this.getEnableCache());
        }
        if (!bl || this.isExtendModeDirty()) {
            hashMap.put(FIELD_EXTENDMODE, this.getExtendMode());
        }
        if (!bl || this.isFinishFlagDirty()) {
            hashMap.put(FIELD_FINISHFLAG, this.getFinishFlag());
        }
        if (!bl || this.isInPSDEFGroupIdDirty()) {
            hashMap.put(FIELD_INPSDEFGROUPID, this.getInPSDEFGroupId());
        }
        if (!bl || this.isInPSDEFGroupNameDirty()) {
            hashMap.put(FIELD_INPSDEFGROUPNAME, this.getInPSDEFGroupName());
        }
        if (!bl || this.isInPSDESampleDataIdDirty()) {
            hashMap.put(FIELD_INPSDESAMPLEDATAID, this.getInPSDESampleDataId());
        }
        if (!bl || this.isInPSDESampleDataNameDirty()) {
            hashMap.put(FIELD_INPSDESAMPLEDATANAME, this.getInPSDESampleDataName());
        }
        if (!bl || this.isInPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_INPSSYSDYNAMODELID, this.getInPSSysDynaModelId());
        }
        if (!bl || this.isInPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_INPSSYSDYNAMODELNAME, this.getInPSSysDynaModelName());
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
        if (!bl || this.isNeedResourceKeyDirty()) {
            hashMap.put(FIELD_NEEDRESOURCEKEY, this.getNeedResourceKey());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isOutPSDEFGroupIdDirty()) {
            hashMap.put(FIELD_OUTPSDEFGROUPID, this.getOutPSDEFGroupId());
        }
        if (!bl || this.isOutPSDEFGroupNameDirty()) {
            hashMap.put(FIELD_OUTPSDEFGROUPNAME, this.getOutPSDEFGroupName());
        }
        if (!bl || this.isOutPSDESampleDataIdDirty()) {
            hashMap.put(FIELD_OUTPSDESAMPLEDATAID, this.getOutPSDESampleDataId());
        }
        if (!bl || this.isOutPSDESampleDataNameDirty()) {
            hashMap.put(FIELD_OUTPSDESAMPLEDATANAME, this.getOutPSDESampleDataName());
        }
        if (!bl || this.isOutPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_OUTPSSYSDYNAMODELID, this.getOutPSSysDynaModelId());
        }
        if (!bl || this.isOutPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_OUTPSSYSDYNAMODELNAME, this.getOutPSSysDynaModelName());
        }
        if (!bl || this.isOutRefPSDEFGroupIdDirty()) {
            hashMap.put(FIELD_OUTREFPSDEFGROUPID, this.getOutRefPSDEFGroupId());
        }
        if (!bl || this.isOutRefPSDEFGroupNameDirty()) {
            hashMap.put(FIELD_OUTREFPSDEFGROUPNAME, this.getOutRefPSDEFGroupName());
        }
        if (!bl || this.isOutRefPSDEIdDirty()) {
            hashMap.put(FIELD_OUTREFPSDEID, this.getOutRefPSDEId());
        }
        if (!bl || this.isOutRefPSDENameDirty()) {
            hashMap.put(FIELD_OUTREFPSDENAME, this.getOutRefPSDEName());
        }
        if (!bl || this.isParamTypeDirty()) {
            hashMap.put(FIELD_PARAMTYPE, this.getParamType());
        }
        if (!bl || this.isPOTimeDirty()) {
            hashMap.put(FIELD_POTIME, this.getPOTime());
        }
        if (!bl || this.isPredefinedTypeDirty()) {
            hashMap.put(FIELD_PREDEFINEDTYPE, this.getPredefinedType());
        }
        if (!bl || this.isPredefinedTypeParamDirty()) {
            hashMap.put(FIELD_PREDEFINEDTYPEPARAM, this.getPredefinedTypeParam());
        }
        if (!bl || this.isPredefinedTypeTextDirty()) {
            hashMap.put(FIELD_PREDEFINEDTYPETEXT, this.getPredefinedTypeText());
        }
        if (!bl || this.isPrepareLastDirty()) {
            hashMap.put(FIELD_PREPARELAST, this.getPrepareLast());
        }
        if (!bl || this.isPSDEActionIdDirty()) {
            hashMap.put(FIELD_PSDEACTIONID, this.getPSDEActionId());
        }
        if (!bl || this.isPSDEActionLogicsCntDirty()) {
            hashMap.put(FIELD_PSDEACTIONLOGICSCNT, this.getPSDEActionLogicsCnt());
        }
        if (!bl || this.isPSDEActionNameDirty()) {
            hashMap.put(FIELD_PSDEACTIONNAME, this.getPSDEActionName());
        }
        if (!bl || this.isPSDEActionTemplIdDirty()) {
            hashMap.put(FIELD_PSDEACTIONTEMPLID, this.getPSDEActionTemplId());
        }
        if (!bl || this.isPSDEActionTemplNameDirty()) {
            hashMap.put(FIELD_PSDEACTIONTEMPLNAME, this.getPSDEActionTemplName());
        }
        if (!bl || this.isPSDEDataFlowIdDirty()) {
            hashMap.put(FIELD_PSDEDATAFLOWID, this.getPSDEDataFlowId());
        }
        if (!bl || this.isPSDEDataFlowNameDirty()) {
            hashMap.put(FIELD_PSDEDATAFLOWNAME, this.getPSDEDataFlowName());
        }
        if (!bl || this.isPSDEDataQueryIdDirty()) {
            hashMap.put(FIELD_PSDEDATAQUERYID, this.getPSDEDataQueryId());
        }
        if (!bl || this.isPSDEDataQueryNameDirty()) {
            hashMap.put(FIELD_PSDEDATAQUERYNAME, this.getPSDEDataQueryName());
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
        if (!bl || this.isPSDELogicIdDirty()) {
            hashMap.put(FIELD_PSDELOGICID, this.getPSDELogicId());
        }
        if (!bl || this.isPSDELogicNameDirty()) {
            hashMap.put(FIELD_PSDELOGICNAME, this.getPSDELogicName());
        }
        if (!bl || this.isPSDEMSActionsCntDirty()) {
            hashMap.put(FIELD_PSDEMSACTIONSCNT, this.getPSDEMSActionsCnt());
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
        if (!bl || this.isPSDESysProcIdDirty()) {
            hashMap.put(FIELD_PSDESYSPROCID, this.getPSDESysProcId());
        }
        if (!bl || this.isPSDESysProcNameDirty()) {
            hashMap.put(FIELD_PSDESYSPROCNAME, this.getPSDESysProcName());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSSubSysSADEIdDirty()) {
            hashMap.put(FIELD_PSSUBSYSSADEID, this.getPSSubSysSADEId());
        }
        if (!bl || this.isPSSubSysSADetailIdDirty()) {
            hashMap.put(FIELD_PSSUBSYSSADETAILID, this.getPSSubSysSADetailId());
        }
        if (!bl || this.isPSSubSysSADetailNameDirty()) {
            hashMap.put(FIELD_PSSUBSYSSADETAILNAME, this.getPSSubSysSADetailName());
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
        if (!bl || this.isPSSysSFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINID, this.getPSSysSFPluginId());
        }
        if (!bl || this.isPSSysSFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINNAME, this.getPSSysSFPluginName());
        }
        if (!bl || this.isPSSysTaskIdDirty()) {
            hashMap.put(FIELD_PSSYSTASKID, this.getPSSysTaskId());
        }
        if (!bl || this.isPSSysTaskNameDirty()) {
            hashMap.put(FIELD_PSSYSTASKNAME, this.getPSSysTaskName());
        }
        if (!bl || this.isPSSysTestCasesCntDirty()) {
            hashMap.put(FIELD_PSSYSTESTCASESCNT, this.getPSSysTestCasesCnt());
        }
        if (!bl || this.isPSSysUniStateIdDirty()) {
            hashMap.put(FIELD_PSSYSUNISTATEID, this.getPSSysUniStateId());
        }
        if (!bl || this.isPSSysUniStateNameDirty()) {
            hashMap.put(FIELD_PSSYSUNISTATENAME, this.getPSSysUniStateName());
        }
        if (!bl || this.isPubModeDirty()) {
            hashMap.put(FIELD_PUBMODE, this.getPubMode());
        }
        if (!bl || this.isRawServiceMethodDirty()) {
            hashMap.put(FIELD_RAWSERVICEMETHOD, this.getRawServiceMethod());
        }
        if (!bl || this.isRawServiceUrlDirty()) {
            hashMap.put(FIELD_RAWSERVICEURL, this.getRawServiceUrl());
        }
        if (!bl || this.isRequestFieldDirty()) {
            hashMap.put(FIELD_REQUESTFIELD, this.getRequestField());
        }
        if (!bl || this.isRequestMethodDirty()) {
            hashMap.put(FIELD_REQUESTMETHOD, this.getRequestMethod());
        }
        if (!bl || this.isRequestParamTypeDirty()) {
            hashMap.put(FIELD_REQUESTPARAMTYPE, this.getRequestParamType());
        }
        if (!bl || this.isRequestPathDirty()) {
            hashMap.put(FIELD_REQUESTPATH, this.getRequestPath());
        }
        if (!bl || this.isRetStdDataTypeDirty()) {
            hashMap.put(FIELD_RETSTDDATATYPE, this.getRetStdDataType());
        }
        if (!bl || this.isRetValTypeDirty()) {
            hashMap.put(FIELD_RETVALTYPE, this.getRetValType());
        }
        if (!bl || this.isServiceCodeNameDirty()) {
            hashMap.put(FIELD_SERVICECODENAME, this.getServiceCodeName());
        }
        if (!bl || this.isSubSysSADetailModeDirty()) {
            hashMap.put(FIELD_SUBSYSSADETAILMODE, this.getSubSysSADetailMode());
        }
        if (!bl || this.isSyncEventDirty()) {
            hashMap.put(FIELD_SYNCEVENT, this.getSyncEvent());
        }
        if (!bl || this.isTestActionModeDirty()) {
            hashMap.put(FIELD_TESTACTIONMODE, this.getTestActionMode());
        }
        if (!bl || this.isTestCaseFlagDirty()) {
            hashMap.put(FIELD_TESTCASEFLAG, this.getTestCaseFlag());
        }
        if (!bl || this.isToDoTaskDirty()) {
            hashMap.put(FIELD_TODOTASK, this.getToDoTask());
        }
        if (!bl || this.isTSModeDirty()) {
            hashMap.put(FIELD_TSMODE, this.getTSMode());
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
        if (!bl || this.isUserParamsDirty()) {
            hashMap.put(FIELD_USERPARAMS, this.getUserParams());
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
        return PSDEActionBase.get(this, n);
    }

    private static Object get(PSDEActionBase pSDEActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEActionBase.getActionHolder();
            }
            case 1: {
                return pSDEActionBase.getActionMode();
            }
            case 2: {
                return pSDEActionBase.getActionOption();
            }
            case 3: {
                return pSDEActionBase.getActionParams();
            }
            case 4: {
                return pSDEActionBase.getActionTag();
            }
            case 5: {
                return pSDEActionBase.getActionTag2();
            }
            case 6: {
                return pSDEActionBase.getActionTag3();
            }
            case 7: {
                return pSDEActionBase.getActionTag4();
            }
            case 8: {
                return pSDEActionBase.getActionType();
            }
            case 9: {
                return pSDEActionBase.getAfterCode();
            }
            case 10: {
                return pSDEActionBase.getBatchActionMode();
            }
            case 11: {
                return pSDEActionBase.getBeforeCode();
            }
            case 12: {
                return pSDEActionBase.getCacheCat();
            }
            case 13: {
                return pSDEActionBase.getCacheScope();
            }
            case 14: {
                return pSDEActionBase.getCacheTag();
            }
            case 15: {
                return pSDEActionBase.getCacheTimeout();
            }
            case 16: {
                return pSDEActionBase.getCallerObj();
            }
            case 17: {
                return pSDEActionBase.getCallTimeout();
            }
            case 18: {
                return pSDEActionBase.getCodeName();
            }
            case 19: {
                return pSDEActionBase.getCreateDate();
            }
            case 20: {
                return pSDEActionBase.getCreateMan();
            }
            case 21: {
                return pSDEActionBase.getCustomCode();
            }
            case 22: {
                return pSDEActionBase.getCustomMode();
            }
            case 23: {
                return pSDEActionBase.getDynaModelFlag();
            }
            case 24: {
                return pSDEActionBase.getEnableAudit();
            }
            case 25: {
                return pSDEActionBase.getEnableCache();
            }
            case 26: {
                return pSDEActionBase.getExtendMode();
            }
            case 27: {
                return pSDEActionBase.getFinishFlag();
            }
            case 28: {
                return pSDEActionBase.getInPSDEFGroupId();
            }
            case 29: {
                return pSDEActionBase.getInPSDEFGroupName();
            }
            case 30: {
                return pSDEActionBase.getInPSDESampleDataId();
            }
            case 31: {
                return pSDEActionBase.getInPSDESampleDataName();
            }
            case 32: {
                return pSDEActionBase.getInPSSysDynaModelId();
            }
            case 33: {
                return pSDEActionBase.getInPSSysDynaModelName();
            }
            case 34: {
                return pSDEActionBase.getLockFlag();
            }
            case 35: {
                return pSDEActionBase.getLogicName();
            }
            case 36: {
                return pSDEActionBase.getMemo();
            }
            case 37: {
                return pSDEActionBase.getNeedResourceKey();
            }
            case 38: {
                return pSDEActionBase.getOrderValue();
            }
            case 39: {
                return pSDEActionBase.getOutPSDEFGroupId();
            }
            case 40: {
                return pSDEActionBase.getOutPSDEFGroupName();
            }
            case 41: {
                return pSDEActionBase.getOutPSDESampleDataId();
            }
            case 42: {
                return pSDEActionBase.getOutPSDESampleDataName();
            }
            case 43: {
                return pSDEActionBase.getOutPSSysDynaModelId();
            }
            case 44: {
                return pSDEActionBase.getOutPSSysDynaModelName();
            }
            case 45: {
                return pSDEActionBase.getOutRefPSDEFGroupId();
            }
            case 46: {
                return pSDEActionBase.getOutRefPSDEFGroupName();
            }
            case 47: {
                return pSDEActionBase.getOutRefPSDEId();
            }
            case 48: {
                return pSDEActionBase.getOutRefPSDEName();
            }
            case 49: {
                return pSDEActionBase.getParamType();
            }
            case 50: {
                return pSDEActionBase.getPOTime();
            }
            case 51: {
                return pSDEActionBase.getPredefinedType();
            }
            case 52: {
                return pSDEActionBase.getPredefinedTypeParam();
            }
            case 53: {
                return pSDEActionBase.getPredefinedTypeText();
            }
            case 54: {
                return pSDEActionBase.getPrepareLast();
            }
            case 55: {
                return pSDEActionBase.getPSDEActionId();
            }
            case 56: {
                return pSDEActionBase.getPSDEActionLogicsCnt();
            }
            case 57: {
                return pSDEActionBase.getPSDEActionName();
            }
            case 58: {
                return pSDEActionBase.getPSDEActionTemplId();
            }
            case 59: {
                return pSDEActionBase.getPSDEActionTemplName();
            }
            case 60: {
                return pSDEActionBase.getPSDEDataFlowId();
            }
            case 61: {
                return pSDEActionBase.getPSDEDataFlowName();
            }
            case 62: {
                return pSDEActionBase.getPSDEDataQueryId();
            }
            case 63: {
                return pSDEActionBase.getPSDEDataQueryName();
            }
            case 64: {
                return pSDEActionBase.getPSDEDataSetId();
            }
            case 65: {
                return pSDEActionBase.getPSDEDataSetName();
            }
            case 66: {
                return pSDEActionBase.getPSDEId();
            }
            case 67: {
                return pSDEActionBase.getPSDELogicId();
            }
            case 68: {
                return pSDEActionBase.getPSDELogicName();
            }
            case 69: {
                return pSDEActionBase.getPSDEMSActionsCnt();
            }
            case 70: {
                return pSDEActionBase.getPSDEName();
            }
            case 71: {
                return pSDEActionBase.getPSDEOPPrivId();
            }
            case 72: {
                return pSDEActionBase.getPSDEOPPrivName();
            }
            case 73: {
                return pSDEActionBase.getPSDESysProcId();
            }
            case 74: {
                return pSDEActionBase.getPSDESysProcName();
            }
            case 75: {
                return pSDEActionBase.getPSDynaInstId();
            }
            case 76: {
                return pSDEActionBase.getPSSubSysSADEId();
            }
            case 77: {
                return pSDEActionBase.getPSSubSysSADetailId();
            }
            case 78: {
                return pSDEActionBase.getPSSubSysSADetailName();
            }
            case 79: {
                return pSDEActionBase.getPSSysDynaModelId();
            }
            case 80: {
                return pSDEActionBase.getPSSysDynaModelName();
            }
            case 81: {
                return pSDEActionBase.getPSSysPFPluginId();
            }
            case 82: {
                return pSDEActionBase.getPSSysPFPluginName();
            }
            case 83: {
                return pSDEActionBase.getPSSysReqItemId();
            }
            case 84: {
                return pSDEActionBase.getPSSysReqItemName();
            }
            case 85: {
                return pSDEActionBase.getPSSysSFPluginId();
            }
            case 86: {
                return pSDEActionBase.getPSSysSFPluginName();
            }
            case 87: {
                return pSDEActionBase.getPSSysTaskId();
            }
            case 88: {
                return pSDEActionBase.getPSSysTaskName();
            }
            case 89: {
                return pSDEActionBase.getPSSysTestCasesCnt();
            }
            case 90: {
                return pSDEActionBase.getPSSysUniStateId();
            }
            case 91: {
                return pSDEActionBase.getPSSysUniStateName();
            }
            case 92: {
                return pSDEActionBase.getPubMode();
            }
            case 93: {
                return pSDEActionBase.getRawServiceMethod();
            }
            case 94: {
                return pSDEActionBase.getRawServiceUrl();
            }
            case 95: {
                return pSDEActionBase.getRequestField();
            }
            case 96: {
                return pSDEActionBase.getRequestMethod();
            }
            case 97: {
                return pSDEActionBase.getRequestParamType();
            }
            case 98: {
                return pSDEActionBase.getRequestPath();
            }
            case 99: {
                return pSDEActionBase.getRetStdDataType();
            }
            case 100: {
                return pSDEActionBase.getRetValType();
            }
            case 101: {
                return pSDEActionBase.getServiceCodeName();
            }
            case 102: {
                return pSDEActionBase.getSubSysSADetailMode();
            }
            case 103: {
                return pSDEActionBase.getSyncEvent();
            }
            case 104: {
                return pSDEActionBase.getTestActionMode();
            }
            case 105: {
                return pSDEActionBase.getTestCaseFlag();
            }
            case 106: {
                return pSDEActionBase.getToDoTask();
            }
            case 107: {
                return pSDEActionBase.getTSMode();
            }
            case 108: {
                return pSDEActionBase.getUpdateDate();
            }
            case 109: {
                return pSDEActionBase.getUpdateMan();
            }
            case 110: {
                return pSDEActionBase.getUserCat();
            }
            case 111: {
                return pSDEActionBase.getUserParams();
            }
            case 112: {
                return pSDEActionBase.getUserTag();
            }
            case 113: {
                return pSDEActionBase.getUserTag2();
            }
            case 114: {
                return pSDEActionBase.getUserTag3();
            }
            case 115: {
                return pSDEActionBase.getUserTag4();
            }
            case 116: {
                return pSDEActionBase.getValidFlag();
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
        PSDEActionBase.set(this, n, object);
    }

    private static void set(PSDEActionBase pSDEActionBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEActionBase.setActionHolder(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDEActionBase.setActionMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEActionBase.setActionOption(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSDEActionBase.setActionParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEActionBase.setActionTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEActionBase.setActionTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEActionBase.setActionTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEActionBase.setActionTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEActionBase.setActionType(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEActionBase.setAfterCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEActionBase.setBatchActionMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSDEActionBase.setBeforeCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEActionBase.setCacheCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEActionBase.setCacheScope(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEActionBase.setCacheTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEActionBase.setCacheTimeout(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSDEActionBase.setCallerObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEActionBase.setCallTimeout(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSDEActionBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEActionBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 20: {
                pSDEActionBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEActionBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEActionBase.setCustomMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 23: {
                pSDEActionBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 24: {
                pSDEActionBase.setEnableAudit(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 25: {
                pSDEActionBase.setEnableCache(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 26: {
                pSDEActionBase.setExtendMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 27: {
                pSDEActionBase.setFinishFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 28: {
                pSDEActionBase.setInPSDEFGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDEActionBase.setInPSDEFGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDEActionBase.setInPSDESampleDataId(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDEActionBase.setInPSDESampleDataName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDEActionBase.setInPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDEActionBase.setInPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDEActionBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 35: {
                pSDEActionBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDEActionBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDEActionBase.setNeedResourceKey(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 38: {
                pSDEActionBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 39: {
                pSDEActionBase.setOutPSDEFGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDEActionBase.setOutPSDEFGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDEActionBase.setOutPSDESampleDataId(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDEActionBase.setOutPSDESampleDataName(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSDEActionBase.setOutPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSDEActionBase.setOutPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSDEActionBase.setOutRefPSDEFGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSDEActionBase.setOutRefPSDEFGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSDEActionBase.setOutRefPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSDEActionBase.setOutRefPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSDEActionBase.setParamType(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 50: {
                pSDEActionBase.setPOTime(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 51: {
                pSDEActionBase.setPredefinedType(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSDEActionBase.setPredefinedTypeParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSDEActionBase.setPredefinedTypeText(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSDEActionBase.setPrepareLast(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 55: {
                pSDEActionBase.setPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSDEActionBase.setPSDEActionLogicsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 57: {
                pSDEActionBase.setPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 58: {
                pSDEActionBase.setPSDEActionTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 59: {
                pSDEActionBase.setPSDEActionTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 60: {
                pSDEActionBase.setPSDEDataFlowId(DataObject.getStringValue((Object)object));
                return;
            }
            case 61: {
                pSDEActionBase.setPSDEDataFlowName(DataObject.getStringValue((Object)object));
                return;
            }
            case 62: {
                pSDEActionBase.setPSDEDataQueryId(DataObject.getStringValue((Object)object));
                return;
            }
            case 63: {
                pSDEActionBase.setPSDEDataQueryName(DataObject.getStringValue((Object)object));
                return;
            }
            case 64: {
                pSDEActionBase.setPSDEDataSetId(DataObject.getStringValue((Object)object));
                return;
            }
            case 65: {
                pSDEActionBase.setPSDEDataSetName(DataObject.getStringValue((Object)object));
                return;
            }
            case 66: {
                pSDEActionBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 67: {
                pSDEActionBase.setPSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 68: {
                pSDEActionBase.setPSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 69: {
                pSDEActionBase.setPSDEMSActionsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 70: {
                pSDEActionBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 71: {
                pSDEActionBase.setPSDEOPPrivId(DataObject.getStringValue((Object)object));
                return;
            }
            case 72: {
                pSDEActionBase.setPSDEOPPrivName(DataObject.getStringValue((Object)object));
                return;
            }
            case 73: {
                pSDEActionBase.setPSDESysProcId(DataObject.getStringValue((Object)object));
                return;
            }
            case 74: {
                pSDEActionBase.setPSDESysProcName(DataObject.getStringValue((Object)object));
                return;
            }
            case 75: {
                pSDEActionBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 76: {
                pSDEActionBase.setPSSubSysSADEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 77: {
                pSDEActionBase.setPSSubSysSADetailId(DataObject.getStringValue((Object)object));
                return;
            }
            case 78: {
                pSDEActionBase.setPSSubSysSADetailName(DataObject.getStringValue((Object)object));
                return;
            }
            case 79: {
                pSDEActionBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 80: {
                pSDEActionBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 81: {
                pSDEActionBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 82: {
                pSDEActionBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 83: {
                pSDEActionBase.setPSSysReqItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 84: {
                pSDEActionBase.setPSSysReqItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 85: {
                pSDEActionBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 86: {
                pSDEActionBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 87: {
                pSDEActionBase.setPSSysTaskId(DataObject.getStringValue((Object)object));
                return;
            }
            case 88: {
                pSDEActionBase.setPSSysTaskName(DataObject.getStringValue((Object)object));
                return;
            }
            case 89: {
                pSDEActionBase.setPSSysTestCasesCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 90: {
                pSDEActionBase.setPSSysUniStateId(DataObject.getStringValue((Object)object));
                return;
            }
            case 91: {
                pSDEActionBase.setPSSysUniStateName(DataObject.getStringValue((Object)object));
                return;
            }
            case 92: {
                pSDEActionBase.setPubMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 93: {
                pSDEActionBase.setRawServiceMethod(DataObject.getStringValue((Object)object));
                return;
            }
            case 94: {
                pSDEActionBase.setRawServiceUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 95: {
                pSDEActionBase.setRequestField(DataObject.getStringValue((Object)object));
                return;
            }
            case 96: {
                pSDEActionBase.setRequestMethod(DataObject.getStringValue((Object)object));
                return;
            }
            case 97: {
                pSDEActionBase.setRequestParamType(DataObject.getStringValue((Object)object));
                return;
            }
            case 98: {
                pSDEActionBase.setRequestPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 99: {
                pSDEActionBase.setRetStdDataType(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 100: {
                pSDEActionBase.setRetValType(DataObject.getStringValue((Object)object));
                return;
            }
            case 101: {
                pSDEActionBase.setServiceCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 102: {
                pSDEActionBase.setSubSysSADetailMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 103: {
                pSDEActionBase.setSyncEvent(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 104: {
                pSDEActionBase.setTestActionMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 105: {
                pSDEActionBase.setTestCaseFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 106: {
                pSDEActionBase.setToDoTask(DataObject.getStringValue((Object)object));
                return;
            }
            case 107: {
                pSDEActionBase.setTSMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 108: {
                pSDEActionBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 109: {
                pSDEActionBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 110: {
                pSDEActionBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 111: {
                pSDEActionBase.setUserParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 112: {
                pSDEActionBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 113: {
                pSDEActionBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 114: {
                pSDEActionBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 115: {
                pSDEActionBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 116: {
                pSDEActionBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDEActionBase.isNull(this, n);
    }

    private static boolean isNull(PSDEActionBase pSDEActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEActionBase.getActionHolder() == null;
            }
            case 1: {
                return pSDEActionBase.getActionMode() == null;
            }
            case 2: {
                return pSDEActionBase.getActionOption() == null;
            }
            case 3: {
                return pSDEActionBase.getActionParams() == null;
            }
            case 4: {
                return pSDEActionBase.getActionTag() == null;
            }
            case 5: {
                return pSDEActionBase.getActionTag2() == null;
            }
            case 6: {
                return pSDEActionBase.getActionTag3() == null;
            }
            case 7: {
                return pSDEActionBase.getActionTag4() == null;
            }
            case 8: {
                return pSDEActionBase.getActionType() == null;
            }
            case 9: {
                return pSDEActionBase.getAfterCode() == null;
            }
            case 10: {
                return pSDEActionBase.getBatchActionMode() == null;
            }
            case 11: {
                return pSDEActionBase.getBeforeCode() == null;
            }
            case 12: {
                return pSDEActionBase.getCacheCat() == null;
            }
            case 13: {
                return pSDEActionBase.getCacheScope() == null;
            }
            case 14: {
                return pSDEActionBase.getCacheTag() == null;
            }
            case 15: {
                return pSDEActionBase.getCacheTimeout() == null;
            }
            case 16: {
                return pSDEActionBase.getCallerObj() == null;
            }
            case 17: {
                return pSDEActionBase.getCallTimeout() == null;
            }
            case 18: {
                return pSDEActionBase.getCodeName() == null;
            }
            case 19: {
                return pSDEActionBase.getCreateDate() == null;
            }
            case 20: {
                return pSDEActionBase.getCreateMan() == null;
            }
            case 21: {
                return pSDEActionBase.getCustomCode() == null;
            }
            case 22: {
                return pSDEActionBase.getCustomMode() == null;
            }
            case 23: {
                return pSDEActionBase.getDynaModelFlag() == null;
            }
            case 24: {
                return pSDEActionBase.getEnableAudit() == null;
            }
            case 25: {
                return pSDEActionBase.getEnableCache() == null;
            }
            case 26: {
                return pSDEActionBase.getExtendMode() == null;
            }
            case 27: {
                return pSDEActionBase.getFinishFlag() == null;
            }
            case 28: {
                return pSDEActionBase.getInPSDEFGroupId() == null;
            }
            case 29: {
                return pSDEActionBase.getInPSDEFGroupName() == null;
            }
            case 30: {
                return pSDEActionBase.getInPSDESampleDataId() == null;
            }
            case 31: {
                return pSDEActionBase.getInPSDESampleDataName() == null;
            }
            case 32: {
                return pSDEActionBase.getInPSSysDynaModelId() == null;
            }
            case 33: {
                return pSDEActionBase.getInPSSysDynaModelName() == null;
            }
            case 34: {
                return pSDEActionBase.getLockFlag() == null;
            }
            case 35: {
                return pSDEActionBase.getLogicName() == null;
            }
            case 36: {
                return pSDEActionBase.getMemo() == null;
            }
            case 37: {
                return pSDEActionBase.getNeedResourceKey() == null;
            }
            case 38: {
                return pSDEActionBase.getOrderValue() == null;
            }
            case 39: {
                return pSDEActionBase.getOutPSDEFGroupId() == null;
            }
            case 40: {
                return pSDEActionBase.getOutPSDEFGroupName() == null;
            }
            case 41: {
                return pSDEActionBase.getOutPSDESampleDataId() == null;
            }
            case 42: {
                return pSDEActionBase.getOutPSDESampleDataName() == null;
            }
            case 43: {
                return pSDEActionBase.getOutPSSysDynaModelId() == null;
            }
            case 44: {
                return pSDEActionBase.getOutPSSysDynaModelName() == null;
            }
            case 45: {
                return pSDEActionBase.getOutRefPSDEFGroupId() == null;
            }
            case 46: {
                return pSDEActionBase.getOutRefPSDEFGroupName() == null;
            }
            case 47: {
                return pSDEActionBase.getOutRefPSDEId() == null;
            }
            case 48: {
                return pSDEActionBase.getOutRefPSDEName() == null;
            }
            case 49: {
                return pSDEActionBase.getParamType() == null;
            }
            case 50: {
                return pSDEActionBase.getPOTime() == null;
            }
            case 51: {
                return pSDEActionBase.getPredefinedType() == null;
            }
            case 52: {
                return pSDEActionBase.getPredefinedTypeParam() == null;
            }
            case 53: {
                return pSDEActionBase.getPredefinedTypeText() == null;
            }
            case 54: {
                return pSDEActionBase.getPrepareLast() == null;
            }
            case 55: {
                return pSDEActionBase.getPSDEActionId() == null;
            }
            case 56: {
                return pSDEActionBase.getPSDEActionLogicsCnt() == null;
            }
            case 57: {
                return pSDEActionBase.getPSDEActionName() == null;
            }
            case 58: {
                return pSDEActionBase.getPSDEActionTemplId() == null;
            }
            case 59: {
                return pSDEActionBase.getPSDEActionTemplName() == null;
            }
            case 60: {
                return pSDEActionBase.getPSDEDataFlowId() == null;
            }
            case 61: {
                return pSDEActionBase.getPSDEDataFlowName() == null;
            }
            case 62: {
                return pSDEActionBase.getPSDEDataQueryId() == null;
            }
            case 63: {
                return pSDEActionBase.getPSDEDataQueryName() == null;
            }
            case 64: {
                return pSDEActionBase.getPSDEDataSetId() == null;
            }
            case 65: {
                return pSDEActionBase.getPSDEDataSetName() == null;
            }
            case 66: {
                return pSDEActionBase.getPSDEId() == null;
            }
            case 67: {
                return pSDEActionBase.getPSDELogicId() == null;
            }
            case 68: {
                return pSDEActionBase.getPSDELogicName() == null;
            }
            case 69: {
                return pSDEActionBase.getPSDEMSActionsCnt() == null;
            }
            case 70: {
                return pSDEActionBase.getPSDEName() == null;
            }
            case 71: {
                return pSDEActionBase.getPSDEOPPrivId() == null;
            }
            case 72: {
                return pSDEActionBase.getPSDEOPPrivName() == null;
            }
            case 73: {
                return pSDEActionBase.getPSDESysProcId() == null;
            }
            case 74: {
                return pSDEActionBase.getPSDESysProcName() == null;
            }
            case 75: {
                return pSDEActionBase.getPSDynaInstId() == null;
            }
            case 76: {
                return pSDEActionBase.getPSSubSysSADEId() == null;
            }
            case 77: {
                return pSDEActionBase.getPSSubSysSADetailId() == null;
            }
            case 78: {
                return pSDEActionBase.getPSSubSysSADetailName() == null;
            }
            case 79: {
                return pSDEActionBase.getPSSysDynaModelId() == null;
            }
            case 80: {
                return pSDEActionBase.getPSSysDynaModelName() == null;
            }
            case 81: {
                return pSDEActionBase.getPSSysPFPluginId() == null;
            }
            case 82: {
                return pSDEActionBase.getPSSysPFPluginName() == null;
            }
            case 83: {
                return pSDEActionBase.getPSSysReqItemId() == null;
            }
            case 84: {
                return pSDEActionBase.getPSSysReqItemName() == null;
            }
            case 85: {
                return pSDEActionBase.getPSSysSFPluginId() == null;
            }
            case 86: {
                return pSDEActionBase.getPSSysSFPluginName() == null;
            }
            case 87: {
                return pSDEActionBase.getPSSysTaskId() == null;
            }
            case 88: {
                return pSDEActionBase.getPSSysTaskName() == null;
            }
            case 89: {
                return pSDEActionBase.getPSSysTestCasesCnt() == null;
            }
            case 90: {
                return pSDEActionBase.getPSSysUniStateId() == null;
            }
            case 91: {
                return pSDEActionBase.getPSSysUniStateName() == null;
            }
            case 92: {
                return pSDEActionBase.getPubMode() == null;
            }
            case 93: {
                return pSDEActionBase.getRawServiceMethod() == null;
            }
            case 94: {
                return pSDEActionBase.getRawServiceUrl() == null;
            }
            case 95: {
                return pSDEActionBase.getRequestField() == null;
            }
            case 96: {
                return pSDEActionBase.getRequestMethod() == null;
            }
            case 97: {
                return pSDEActionBase.getRequestParamType() == null;
            }
            case 98: {
                return pSDEActionBase.getRequestPath() == null;
            }
            case 99: {
                return pSDEActionBase.getRetStdDataType() == null;
            }
            case 100: {
                return pSDEActionBase.getRetValType() == null;
            }
            case 101: {
                return pSDEActionBase.getServiceCodeName() == null;
            }
            case 102: {
                return pSDEActionBase.getSubSysSADetailMode() == null;
            }
            case 103: {
                return pSDEActionBase.getSyncEvent() == null;
            }
            case 104: {
                return pSDEActionBase.getTestActionMode() == null;
            }
            case 105: {
                return pSDEActionBase.getTestCaseFlag() == null;
            }
            case 106: {
                return pSDEActionBase.getToDoTask() == null;
            }
            case 107: {
                return pSDEActionBase.getTSMode() == null;
            }
            case 108: {
                return pSDEActionBase.getUpdateDate() == null;
            }
            case 109: {
                return pSDEActionBase.getUpdateMan() == null;
            }
            case 110: {
                return pSDEActionBase.getUserCat() == null;
            }
            case 111: {
                return pSDEActionBase.getUserParams() == null;
            }
            case 112: {
                return pSDEActionBase.getUserTag() == null;
            }
            case 113: {
                return pSDEActionBase.getUserTag2() == null;
            }
            case 114: {
                return pSDEActionBase.getUserTag3() == null;
            }
            case 115: {
                return pSDEActionBase.getUserTag4() == null;
            }
            case 116: {
                return pSDEActionBase.getValidFlag() == null;
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
        return PSDEActionBase.contains(this, n);
    }

    private static boolean contains(PSDEActionBase pSDEActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEActionBase.isActionHolderDirty();
            }
            case 1: {
                return pSDEActionBase.isActionModeDirty();
            }
            case 2: {
                return pSDEActionBase.isActionOptionDirty();
            }
            case 3: {
                return pSDEActionBase.isActionParamsDirty();
            }
            case 4: {
                return pSDEActionBase.isActionTagDirty();
            }
            case 5: {
                return pSDEActionBase.isActionTag2Dirty();
            }
            case 6: {
                return pSDEActionBase.isActionTag3Dirty();
            }
            case 7: {
                return pSDEActionBase.isActionTag4Dirty();
            }
            case 8: {
                return pSDEActionBase.isActionTypeDirty();
            }
            case 9: {
                return pSDEActionBase.isAfterCodeDirty();
            }
            case 10: {
                return pSDEActionBase.isBatchActionModeDirty();
            }
            case 11: {
                return pSDEActionBase.isBeforeCodeDirty();
            }
            case 12: {
                return pSDEActionBase.isCacheCatDirty();
            }
            case 13: {
                return pSDEActionBase.isCacheScopeDirty();
            }
            case 14: {
                return pSDEActionBase.isCacheTagDirty();
            }
            case 15: {
                return pSDEActionBase.isCacheTimeoutDirty();
            }
            case 16: {
                return pSDEActionBase.isCallerObjDirty();
            }
            case 17: {
                return pSDEActionBase.isCallTimeoutDirty();
            }
            case 18: {
                return pSDEActionBase.isCodeNameDirty();
            }
            case 19: {
                return pSDEActionBase.isCreateDateDirty();
            }
            case 20: {
                return pSDEActionBase.isCreateManDirty();
            }
            case 21: {
                return pSDEActionBase.isCustomCodeDirty();
            }
            case 22: {
                return pSDEActionBase.isCustomModeDirty();
            }
            case 23: {
                return pSDEActionBase.isDynaModelFlagDirty();
            }
            case 24: {
                return pSDEActionBase.isEnableAuditDirty();
            }
            case 25: {
                return pSDEActionBase.isEnableCacheDirty();
            }
            case 26: {
                return pSDEActionBase.isExtendModeDirty();
            }
            case 27: {
                return pSDEActionBase.isFinishFlagDirty();
            }
            case 28: {
                return pSDEActionBase.isInPSDEFGroupIdDirty();
            }
            case 29: {
                return pSDEActionBase.isInPSDEFGroupNameDirty();
            }
            case 30: {
                return pSDEActionBase.isInPSDESampleDataIdDirty();
            }
            case 31: {
                return pSDEActionBase.isInPSDESampleDataNameDirty();
            }
            case 32: {
                return pSDEActionBase.isInPSSysDynaModelIdDirty();
            }
            case 33: {
                return pSDEActionBase.isInPSSysDynaModelNameDirty();
            }
            case 34: {
                return pSDEActionBase.isLockFlagDirty();
            }
            case 35: {
                return pSDEActionBase.isLogicNameDirty();
            }
            case 36: {
                return pSDEActionBase.isMemoDirty();
            }
            case 37: {
                return pSDEActionBase.isNeedResourceKeyDirty();
            }
            case 38: {
                return pSDEActionBase.isOrderValueDirty();
            }
            case 39: {
                return pSDEActionBase.isOutPSDEFGroupIdDirty();
            }
            case 40: {
                return pSDEActionBase.isOutPSDEFGroupNameDirty();
            }
            case 41: {
                return pSDEActionBase.isOutPSDESampleDataIdDirty();
            }
            case 42: {
                return pSDEActionBase.isOutPSDESampleDataNameDirty();
            }
            case 43: {
                return pSDEActionBase.isOutPSSysDynaModelIdDirty();
            }
            case 44: {
                return pSDEActionBase.isOutPSSysDynaModelNameDirty();
            }
            case 45: {
                return pSDEActionBase.isOutRefPSDEFGroupIdDirty();
            }
            case 46: {
                return pSDEActionBase.isOutRefPSDEFGroupNameDirty();
            }
            case 47: {
                return pSDEActionBase.isOutRefPSDEIdDirty();
            }
            case 48: {
                return pSDEActionBase.isOutRefPSDENameDirty();
            }
            case 49: {
                return pSDEActionBase.isParamTypeDirty();
            }
            case 50: {
                return pSDEActionBase.isPOTimeDirty();
            }
            case 51: {
                return pSDEActionBase.isPredefinedTypeDirty();
            }
            case 52: {
                return pSDEActionBase.isPredefinedTypeParamDirty();
            }
            case 53: {
                return pSDEActionBase.isPredefinedTypeTextDirty();
            }
            case 54: {
                return pSDEActionBase.isPrepareLastDirty();
            }
            case 55: {
                return pSDEActionBase.isPSDEActionIdDirty();
            }
            case 56: {
                return pSDEActionBase.isPSDEActionLogicsCntDirty();
            }
            case 57: {
                return pSDEActionBase.isPSDEActionNameDirty();
            }
            case 58: {
                return pSDEActionBase.isPSDEActionTemplIdDirty();
            }
            case 59: {
                return pSDEActionBase.isPSDEActionTemplNameDirty();
            }
            case 60: {
                return pSDEActionBase.isPSDEDataFlowIdDirty();
            }
            case 61: {
                return pSDEActionBase.isPSDEDataFlowNameDirty();
            }
            case 62: {
                return pSDEActionBase.isPSDEDataQueryIdDirty();
            }
            case 63: {
                return pSDEActionBase.isPSDEDataQueryNameDirty();
            }
            case 64: {
                return pSDEActionBase.isPSDEDataSetIdDirty();
            }
            case 65: {
                return pSDEActionBase.isPSDEDataSetNameDirty();
            }
            case 66: {
                return pSDEActionBase.isPSDEIdDirty();
            }
            case 67: {
                return pSDEActionBase.isPSDELogicIdDirty();
            }
            case 68: {
                return pSDEActionBase.isPSDELogicNameDirty();
            }
            case 69: {
                return pSDEActionBase.isPSDEMSActionsCntDirty();
            }
            case 70: {
                return pSDEActionBase.isPSDENameDirty();
            }
            case 71: {
                return pSDEActionBase.isPSDEOPPrivIdDirty();
            }
            case 72: {
                return pSDEActionBase.isPSDEOPPrivNameDirty();
            }
            case 73: {
                return pSDEActionBase.isPSDESysProcIdDirty();
            }
            case 74: {
                return pSDEActionBase.isPSDESysProcNameDirty();
            }
            case 75: {
                return pSDEActionBase.isPSDynaInstIdDirty();
            }
            case 76: {
                return pSDEActionBase.isPSSubSysSADEIdDirty();
            }
            case 77: {
                return pSDEActionBase.isPSSubSysSADetailIdDirty();
            }
            case 78: {
                return pSDEActionBase.isPSSubSysSADetailNameDirty();
            }
            case 79: {
                return pSDEActionBase.isPSSysDynaModelIdDirty();
            }
            case 80: {
                return pSDEActionBase.isPSSysDynaModelNameDirty();
            }
            case 81: {
                return pSDEActionBase.isPSSysPFPluginIdDirty();
            }
            case 82: {
                return pSDEActionBase.isPSSysPFPluginNameDirty();
            }
            case 83: {
                return pSDEActionBase.isPSSysReqItemIdDirty();
            }
            case 84: {
                return pSDEActionBase.isPSSysReqItemNameDirty();
            }
            case 85: {
                return pSDEActionBase.isPSSysSFPluginIdDirty();
            }
            case 86: {
                return pSDEActionBase.isPSSysSFPluginNameDirty();
            }
            case 87: {
                return pSDEActionBase.isPSSysTaskIdDirty();
            }
            case 88: {
                return pSDEActionBase.isPSSysTaskNameDirty();
            }
            case 89: {
                return pSDEActionBase.isPSSysTestCasesCntDirty();
            }
            case 90: {
                return pSDEActionBase.isPSSysUniStateIdDirty();
            }
            case 91: {
                return pSDEActionBase.isPSSysUniStateNameDirty();
            }
            case 92: {
                return pSDEActionBase.isPubModeDirty();
            }
            case 93: {
                return pSDEActionBase.isRawServiceMethodDirty();
            }
            case 94: {
                return pSDEActionBase.isRawServiceUrlDirty();
            }
            case 95: {
                return pSDEActionBase.isRequestFieldDirty();
            }
            case 96: {
                return pSDEActionBase.isRequestMethodDirty();
            }
            case 97: {
                return pSDEActionBase.isRequestParamTypeDirty();
            }
            case 98: {
                return pSDEActionBase.isRequestPathDirty();
            }
            case 99: {
                return pSDEActionBase.isRetStdDataTypeDirty();
            }
            case 100: {
                return pSDEActionBase.isRetValTypeDirty();
            }
            case 101: {
                return pSDEActionBase.isServiceCodeNameDirty();
            }
            case 102: {
                return pSDEActionBase.isSubSysSADetailModeDirty();
            }
            case 103: {
                return pSDEActionBase.isSyncEventDirty();
            }
            case 104: {
                return pSDEActionBase.isTestActionModeDirty();
            }
            case 105: {
                return pSDEActionBase.isTestCaseFlagDirty();
            }
            case 106: {
                return pSDEActionBase.isToDoTaskDirty();
            }
            case 107: {
                return pSDEActionBase.isTSModeDirty();
            }
            case 108: {
                return pSDEActionBase.isUpdateDateDirty();
            }
            case 109: {
                return pSDEActionBase.isUpdateManDirty();
            }
            case 110: {
                return pSDEActionBase.isUserCatDirty();
            }
            case 111: {
                return pSDEActionBase.isUserParamsDirty();
            }
            case 112: {
                return pSDEActionBase.isUserTagDirty();
            }
            case 113: {
                return pSDEActionBase.isUserTag2Dirty();
            }
            case 114: {
                return pSDEActionBase.isUserTag3Dirty();
            }
            case 115: {
                return pSDEActionBase.isUserTag4Dirty();
            }
            case 116: {
                return pSDEActionBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEActionBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEActionBase pSDEActionBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEActionBase.getActionHolder() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionholder", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getActionHolder()), (boolean)false);
        }
        if (bl || pSDEActionBase.getActionMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionmode", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getActionMode()), (boolean)false);
        }
        if (bl || pSDEActionBase.getActionOption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionoption", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getActionOption()), (boolean)false);
        }
        if (bl || pSDEActionBase.getActionParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparams", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getActionParams()), (boolean)false);
        }
        if (bl || pSDEActionBase.getActionTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actiontag", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getActionTag()), (boolean)false);
        }
        if (bl || pSDEActionBase.getActionTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actiontag2", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getActionTag2()), (boolean)false);
        }
        if (bl || pSDEActionBase.getActionTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actiontag3", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getActionTag3()), (boolean)false);
        }
        if (bl || pSDEActionBase.getActionTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actiontag4", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getActionTag4()), (boolean)false);
        }
        if (bl || pSDEActionBase.getActionType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actiontype", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getActionType()), (boolean)false);
        }
        if (bl || pSDEActionBase.getAfterCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aftercode", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getAfterCode()), (boolean)false);
        }
        if (bl || pSDEActionBase.getBatchActionMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"batchactionmode", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getBatchActionMode()), (boolean)false);
        }
        if (bl || pSDEActionBase.getBeforeCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"beforecode", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getBeforeCode()), (boolean)false);
        }
        if (bl || pSDEActionBase.getCacheCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cachecat", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getCacheCat()), (boolean)false);
        }
        if (bl || pSDEActionBase.getCacheScope() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cachescope", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getCacheScope()), (boolean)false);
        }
        if (bl || pSDEActionBase.getCacheTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cachetag", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getCacheTag()), (boolean)false);
        }
        if (bl || pSDEActionBase.getCacheTimeout() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cachetimeout", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getCacheTimeout()), (boolean)false);
        }
        if (bl || pSDEActionBase.getCallerObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"callerobj", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getCallerObj()), (boolean)false);
        }
        if (bl || pSDEActionBase.getCallTimeout() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"calltimeout", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getCallTimeout()), (boolean)false);
        }
        if (bl || pSDEActionBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDEActionBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEActionBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEActionBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSDEActionBase.getCustomMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"custommode", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getCustomMode()), (boolean)false);
        }
        if (bl || pSDEActionBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSDEActionBase.getEnableAudit() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableaudit", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getEnableAudit()), (boolean)false);
        }
        if (bl || pSDEActionBase.getEnableCache() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablecache", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getEnableCache()), (boolean)false);
        }
        if (bl || pSDEActionBase.getExtendMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"extendmode", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getExtendMode()), (boolean)false);
        }
        if (bl || pSDEActionBase.getFinishFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"finishflag", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getFinishFlag()), (boolean)false);
        }
        if (bl || pSDEActionBase.getInPSDEFGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"inpsdefgroupid", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getInPSDEFGroupId()), (boolean)false);
        }
        if (bl || pSDEActionBase.getInPSDEFGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"inpsdefgroupname", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getInPSDEFGroupName()), (boolean)false);
        }
        if (bl || pSDEActionBase.getInPSDESampleDataId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"inpsdesampledataid", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getInPSDESampleDataId()), (boolean)false);
        }
        if (bl || pSDEActionBase.getInPSDESampleDataName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"inpsdesampledataname", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getInPSDESampleDataName()), (boolean)false);
        }
        if (bl || pSDEActionBase.getInPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"inpssysdynamodelid", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getInPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSDEActionBase.getInPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"inpssysdynamodelname", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getInPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSDEActionBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSDEActionBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getLogicName()), (boolean)false);
        }
        if (bl || pSDEActionBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEActionBase.getNeedResourceKey() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"needresourcekey", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getNeedResourceKey()), (boolean)false);
        }
        if (bl || pSDEActionBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEActionBase.getOutPSDEFGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"outpsdefgroupid", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getOutPSDEFGroupId()), (boolean)false);
        }
        if (bl || pSDEActionBase.getOutPSDEFGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"outpsdefgroupname", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getOutPSDEFGroupName()), (boolean)false);
        }
        if (bl || pSDEActionBase.getOutPSDESampleDataId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"outpsdesampledataid", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getOutPSDESampleDataId()), (boolean)false);
        }
        if (bl || pSDEActionBase.getOutPSDESampleDataName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"outpsdesampledataname", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getOutPSDESampleDataName()), (boolean)false);
        }
        if (bl || pSDEActionBase.getOutPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"outpssysdynamodelid", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getOutPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSDEActionBase.getOutPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"outpssysdynamodelname", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getOutPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSDEActionBase.getOutRefPSDEFGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"outrefpsdefgroupid", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getOutRefPSDEFGroupId()), (boolean)false);
        }
        if (bl || pSDEActionBase.getOutRefPSDEFGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"outrefpsdefgroupname", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getOutRefPSDEFGroupName()), (boolean)false);
        }
        if (bl || pSDEActionBase.getOutRefPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"outrefpsdeid", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getOutRefPSDEId()), (boolean)false);
        }
        if (bl || pSDEActionBase.getOutRefPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"outrefpsdename", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getOutRefPSDEName()), (boolean)false);
        }
        if (bl || pSDEActionBase.getParamType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"paramtype", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getParamType()), (boolean)false);
        }
        if (bl || pSDEActionBase.getPOTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"potime", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getPOTime()), (boolean)false);
        }
        if (bl || pSDEActionBase.getPredefinedType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"predefinedtype", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getPredefinedType()), (boolean)false);
        }
        if (bl || pSDEActionBase.getPredefinedTypeParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"predefinedtypeparam", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getPredefinedTypeParam()), (boolean)false);
        }
        if (bl || pSDEActionBase.getPredefinedTypeText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"predefinedtypetext", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getPredefinedTypeText()), (boolean)false);
        }
        if (bl || pSDEActionBase.getPrepareLast() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"preparelast", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getPrepareLast()), (boolean)false);
        }
        if (bl || pSDEActionBase.getPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionid", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getPSDEActionId()), (boolean)false);
        }
        if (bl || pSDEActionBase.getPSDEActionLogicsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionlogicscnt", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getPSDEActionLogicsCnt()), (boolean)false);
        }
        if (bl || pSDEActionBase.getPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionname", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getPSDEActionName()), (boolean)false);
        }
        if (bl || pSDEActionBase.getPSDEActionTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactiontemplid", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getPSDEActionTemplId()), (boolean)false);
        }
        if (bl || pSDEActionBase.getPSDEActionTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactiontemplname", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getPSDEActionTemplName()), (boolean)false);
        }
        if (bl || pSDEActionBase.getPSDEDataFlowId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedataflowid", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getPSDEDataFlowId()), (boolean)false);
        }
        if (bl || pSDEActionBase.getPSDEDataFlowName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedataflowname", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getPSDEDataFlowName()), (boolean)false);
        }
        if (bl || pSDEActionBase.getPSDEDataQueryId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedataqueryid", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getPSDEDataQueryId()), (boolean)false);
        }
        if (bl || pSDEActionBase.getPSDEDataQueryName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedataqueryname", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getPSDEDataQueryName()), (boolean)false);
        }
        if (bl || pSDEActionBase.getPSDEDataSetId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedatasetid", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getPSDEDataSetId()), (boolean)false);
        }
        if (bl || pSDEActionBase.getPSDEDataSetName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedatasetname", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getPSDEDataSetName()), (boolean)false);
        }
        if (bl || pSDEActionBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEActionBase.getPSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicid", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getPSDELogicId()), (boolean)false);
        }
        if (bl || pSDEActionBase.getPSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicname", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getPSDELogicName()), (boolean)false);
        }
        if (bl || pSDEActionBase.getPSDEMSActionsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdemsactionscnt", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getPSDEMSActionsCnt()), (boolean)false);
        }
        if (bl || pSDEActionBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEActionBase.getPSDEOPPrivId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeopprivid", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getPSDEOPPrivId()), (boolean)false);
        }
        if (bl || pSDEActionBase.getPSDEOPPrivName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeopprivname", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getPSDEOPPrivName()), (boolean)false);
        }
        if (bl || pSDEActionBase.getPSDESysProcId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdesysprocid", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getPSDESysProcId()), (boolean)false);
        }
        if (bl || pSDEActionBase.getPSDESysProcName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdesysprocname", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getPSDESysProcName()), (boolean)false);
        }
        if (bl || pSDEActionBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSDEActionBase.getPSSubSysSADEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsyssadeid", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getPSSubSysSADEId()), (boolean)false);
        }
        if (bl || pSDEActionBase.getPSSubSysSADetailId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsyssadetailid", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getPSSubSysSADetailId()), (boolean)false);
        }
        if (bl || pSDEActionBase.getPSSubSysSADetailName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsyssadetailname", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getPSSubSysSADetailName()), (boolean)false);
        }
        if (bl || pSDEActionBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSDEActionBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSDEActionBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSDEActionBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSDEActionBase.getPSSysReqItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemid", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getPSSysReqItemId()), (boolean)false);
        }
        if (bl || pSDEActionBase.getPSSysReqItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemname", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getPSSysReqItemName()), (boolean)false);
        }
        if (bl || pSDEActionBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSDEActionBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSDEActionBase.getPSSysTaskId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystaskid", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getPSSysTaskId()), (boolean)false);
        }
        if (bl || pSDEActionBase.getPSSysTaskName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystaskname", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getPSSysTaskName()), (boolean)false);
        }
        if (bl || pSDEActionBase.getPSSysTestCasesCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystestcasescnt", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getPSSysTestCasesCnt()), (boolean)false);
        }
        if (bl || pSDEActionBase.getPSSysUniStateId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysunistateid", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getPSSysUniStateId()), (boolean)false);
        }
        if (bl || pSDEActionBase.getPSSysUniStateName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysunistatename", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getPSSysUniStateName()), (boolean)false);
        }
        if (bl || pSDEActionBase.getPubMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubmode", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getPubMode()), (boolean)false);
        }
        if (bl || pSDEActionBase.getRawServiceMethod() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rawservicemethod", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getRawServiceMethod()), (boolean)false);
        }
        if (bl || pSDEActionBase.getRawServiceUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rawserviceurl", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getRawServiceUrl()), (boolean)false);
        }
        if (bl || pSDEActionBase.getRequestField() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"requestfield", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getRequestField()), (boolean)false);
        }
        if (bl || pSDEActionBase.getRequestMethod() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"requestmethod", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getRequestMethod()), (boolean)false);
        }
        if (bl || pSDEActionBase.getRequestParamType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"requestparamtype", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getRequestParamType()), (boolean)false);
        }
        if (bl || pSDEActionBase.getRequestPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"requestpath", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getRequestPath()), (boolean)false);
        }
        if (bl || pSDEActionBase.getRetStdDataType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"retstddatatype", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getRetStdDataType()), (boolean)false);
        }
        if (bl || pSDEActionBase.getRetValType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"retvaltype", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getRetValType()), (boolean)false);
        }
        if (bl || pSDEActionBase.getServiceCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"servicecodename", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getServiceCodeName()), (boolean)false);
        }
        if (bl || pSDEActionBase.getSubSysSADetailMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"subsyssadetailmode", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getSubSysSADetailMode()), (boolean)false);
        }
        if (bl || pSDEActionBase.getSyncEvent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"syncevent", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getSyncEvent()), (boolean)false);
        }
        if (bl || pSDEActionBase.getTestActionMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"testactionmode", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getTestActionMode()), (boolean)false);
        }
        if (bl || pSDEActionBase.getTestCaseFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"testcaseflag", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getTestCaseFlag()), (boolean)false);
        }
        if (bl || pSDEActionBase.getToDoTask() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"todotask", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getToDoTask()), (boolean)false);
        }
        if (bl || pSDEActionBase.getTSMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tsmode", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getTSMode()), (boolean)false);
        }
        if (bl || pSDEActionBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEActionBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEActionBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEActionBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getUserParams()), (boolean)false);
        }
        if (bl || pSDEActionBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEActionBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEActionBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEActionBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEActionBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDEActionBase.getJSONValue((Object)pSDEActionBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEActionBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEActionBase pSDEActionBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEActionBase.getActionHolder() != null) {
            object = pSDEActionBase.getActionHolder();
            xmlNode.setAttribute(FIELD_ACTIONHOLDER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEActionBase.getActionMode() != null) {
            object = pSDEActionBase.getActionMode();
            xmlNode.setAttribute(FIELD_ACTIONMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getActionOption() != null) {
            object = pSDEActionBase.getActionOption();
            xmlNode.setAttribute(FIELD_ACTIONOPTION, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEActionBase.getActionParams() != null) {
            object = pSDEActionBase.getActionParams();
            xmlNode.setAttribute(FIELD_ACTIONPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getActionTag() != null) {
            object = pSDEActionBase.getActionTag();
            xmlNode.setAttribute(FIELD_ACTIONTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getActionTag2() != null) {
            object = pSDEActionBase.getActionTag2();
            xmlNode.setAttribute(FIELD_ACTIONTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getActionTag3() != null) {
            object = pSDEActionBase.getActionTag3();
            xmlNode.setAttribute(FIELD_ACTIONTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getActionTag4() != null) {
            object = pSDEActionBase.getActionTag4();
            xmlNode.setAttribute(FIELD_ACTIONTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getActionType() != null) {
            object = pSDEActionBase.getActionType();
            xmlNode.setAttribute(FIELD_ACTIONTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getAfterCode() != null) {
            object = pSDEActionBase.getAfterCode();
            xmlNode.setAttribute(FIELD_AFTERCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getBatchActionMode() != null) {
            object = pSDEActionBase.getBatchActionMode();
            xmlNode.setAttribute(FIELD_BATCHACTIONMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEActionBase.getBeforeCode() != null) {
            object = pSDEActionBase.getBeforeCode();
            xmlNode.setAttribute(FIELD_BEFORECODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getCacheCat() != null) {
            object = pSDEActionBase.getCacheCat();
            xmlNode.setAttribute(FIELD_CACHECAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getCacheScope() != null) {
            object = pSDEActionBase.getCacheScope();
            xmlNode.setAttribute(FIELD_CACHESCOPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getCacheTag() != null) {
            object = pSDEActionBase.getCacheTag();
            xmlNode.setAttribute(FIELD_CACHETAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getCacheTimeout() != null) {
            object = pSDEActionBase.getCacheTimeout();
            xmlNode.setAttribute(FIELD_CACHETIMEOUT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEActionBase.getCallerObj() != null) {
            object = pSDEActionBase.getCallerObj();
            xmlNode.setAttribute(FIELD_CALLEROBJ, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getCallTimeout() != null) {
            object = pSDEActionBase.getCallTimeout();
            xmlNode.setAttribute(FIELD_CALLTIMEOUT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEActionBase.getCodeName() != null) {
            object = pSDEActionBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getCreateDate() != null) {
            object = pSDEActionBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEActionBase.getCreateMan() != null) {
            object = pSDEActionBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getCustomCode() != null) {
            object = pSDEActionBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getCustomMode() != null) {
            object = pSDEActionBase.getCustomMode();
            xmlNode.setAttribute(FIELD_CUSTOMMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEActionBase.getDynaModelFlag() != null) {
            object = pSDEActionBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEActionBase.getEnableAudit() != null) {
            object = pSDEActionBase.getEnableAudit();
            xmlNode.setAttribute(FIELD_ENABLEAUDIT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEActionBase.getEnableCache() != null) {
            object = pSDEActionBase.getEnableCache();
            xmlNode.setAttribute(FIELD_ENABLECACHE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEActionBase.getExtendMode() != null) {
            object = pSDEActionBase.getExtendMode();
            xmlNode.setAttribute(FIELD_EXTENDMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEActionBase.getFinishFlag() != null) {
            object = pSDEActionBase.getFinishFlag();
            xmlNode.setAttribute(FIELD_FINISHFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEActionBase.getInPSDEFGroupId() != null) {
            object = pSDEActionBase.getInPSDEFGroupId();
            xmlNode.setAttribute(FIELD_INPSDEFGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getInPSDEFGroupName() != null) {
            object = pSDEActionBase.getInPSDEFGroupName();
            xmlNode.setAttribute(FIELD_INPSDEFGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getInPSDESampleDataId() != null) {
            object = pSDEActionBase.getInPSDESampleDataId();
            xmlNode.setAttribute(FIELD_INPSDESAMPLEDATAID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getInPSDESampleDataName() != null) {
            object = pSDEActionBase.getInPSDESampleDataName();
            xmlNode.setAttribute(FIELD_INPSDESAMPLEDATANAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getInPSSysDynaModelId() != null) {
            object = pSDEActionBase.getInPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_INPSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getInPSSysDynaModelName() != null) {
            object = pSDEActionBase.getInPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_INPSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getLockFlag() != null) {
            object = pSDEActionBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEActionBase.getLogicName() != null) {
            object = pSDEActionBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getMemo() != null) {
            object = pSDEActionBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getNeedResourceKey() != null) {
            object = pSDEActionBase.getNeedResourceKey();
            xmlNode.setAttribute(FIELD_NEEDRESOURCEKEY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEActionBase.getOrderValue() != null) {
            object = pSDEActionBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEActionBase.getOutPSDEFGroupId() != null) {
            object = pSDEActionBase.getOutPSDEFGroupId();
            xmlNode.setAttribute(FIELD_OUTPSDEFGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getOutPSDEFGroupName() != null) {
            object = pSDEActionBase.getOutPSDEFGroupName();
            xmlNode.setAttribute(FIELD_OUTPSDEFGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getOutPSDESampleDataId() != null) {
            object = pSDEActionBase.getOutPSDESampleDataId();
            xmlNode.setAttribute(FIELD_OUTPSDESAMPLEDATAID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getOutPSDESampleDataName() != null) {
            object = pSDEActionBase.getOutPSDESampleDataName();
            xmlNode.setAttribute(FIELD_OUTPSDESAMPLEDATANAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getOutPSSysDynaModelId() != null) {
            object = pSDEActionBase.getOutPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_OUTPSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getOutPSSysDynaModelName() != null) {
            object = pSDEActionBase.getOutPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_OUTPSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getOutRefPSDEFGroupId() != null) {
            object = pSDEActionBase.getOutRefPSDEFGroupId();
            xmlNode.setAttribute(FIELD_OUTREFPSDEFGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getOutRefPSDEFGroupName() != null) {
            object = pSDEActionBase.getOutRefPSDEFGroupName();
            xmlNode.setAttribute(FIELD_OUTREFPSDEFGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getOutRefPSDEId() != null) {
            object = pSDEActionBase.getOutRefPSDEId();
            xmlNode.setAttribute(FIELD_OUTREFPSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getOutRefPSDEName() != null) {
            object = pSDEActionBase.getOutRefPSDEName();
            xmlNode.setAttribute(FIELD_OUTREFPSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getParamType() != null) {
            object = pSDEActionBase.getParamType();
            xmlNode.setAttribute(FIELD_PARAMTYPE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEActionBase.getPOTime() != null) {
            object = pSDEActionBase.getPOTime();
            xmlNode.setAttribute(FIELD_POTIME, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEActionBase.getPredefinedType() != null) {
            object = pSDEActionBase.getPredefinedType();
            xmlNode.setAttribute(FIELD_PREDEFINEDTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getPredefinedTypeParam() != null) {
            object = pSDEActionBase.getPredefinedTypeParam();
            xmlNode.setAttribute(FIELD_PREDEFINEDTYPEPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getPredefinedTypeText() != null) {
            object = pSDEActionBase.getPredefinedTypeText();
            xmlNode.setAttribute(FIELD_PREDEFINEDTYPETEXT, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getPrepareLast() != null) {
            object = pSDEActionBase.getPrepareLast();
            xmlNode.setAttribute(FIELD_PREPARELAST, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEActionBase.getPSDEActionId() != null) {
            object = pSDEActionBase.getPSDEActionId();
            xmlNode.setAttribute(FIELD_PSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getPSDEActionLogicsCnt() != null) {
            object = pSDEActionBase.getPSDEActionLogicsCnt();
            xmlNode.setAttribute(FIELD_PSDEACTIONLOGICSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEActionBase.getPSDEActionName() != null) {
            object = pSDEActionBase.getPSDEActionName();
            xmlNode.setAttribute(FIELD_PSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getPSDEActionTemplId() != null) {
            object = pSDEActionBase.getPSDEActionTemplId();
            xmlNode.setAttribute(FIELD_PSDEACTIONTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getPSDEActionTemplName() != null) {
            object = pSDEActionBase.getPSDEActionTemplName();
            xmlNode.setAttribute(FIELD_PSDEACTIONTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getPSDEDataFlowId() != null) {
            object = pSDEActionBase.getPSDEDataFlowId();
            xmlNode.setAttribute(FIELD_PSDEDATAFLOWID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getPSDEDataFlowName() != null) {
            object = pSDEActionBase.getPSDEDataFlowName();
            xmlNode.setAttribute(FIELD_PSDEDATAFLOWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getPSDEDataQueryId() != null) {
            object = pSDEActionBase.getPSDEDataQueryId();
            xmlNode.setAttribute(FIELD_PSDEDATAQUERYID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getPSDEDataQueryName() != null) {
            object = pSDEActionBase.getPSDEDataQueryName();
            xmlNode.setAttribute(FIELD_PSDEDATAQUERYNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getPSDEDataSetId() != null) {
            object = pSDEActionBase.getPSDEDataSetId();
            xmlNode.setAttribute(FIELD_PSDEDATASETID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getPSDEDataSetName() != null) {
            object = pSDEActionBase.getPSDEDataSetName();
            xmlNode.setAttribute(FIELD_PSDEDATASETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getPSDEId() != null) {
            object = pSDEActionBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getPSDELogicId() != null) {
            object = pSDEActionBase.getPSDELogicId();
            xmlNode.setAttribute(FIELD_PSDELOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getPSDELogicName() != null) {
            object = pSDEActionBase.getPSDELogicName();
            xmlNode.setAttribute(FIELD_PSDELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getPSDEMSActionsCnt() != null) {
            object = pSDEActionBase.getPSDEMSActionsCnt();
            xmlNode.setAttribute(FIELD_PSDEMSACTIONSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEActionBase.getPSDEName() != null) {
            object = pSDEActionBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getPSDEOPPrivId() != null) {
            object = pSDEActionBase.getPSDEOPPrivId();
            xmlNode.setAttribute(FIELD_PSDEOPPRIVID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getPSDEOPPrivName() != null) {
            object = pSDEActionBase.getPSDEOPPrivName();
            xmlNode.setAttribute(FIELD_PSDEOPPRIVNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getPSDESysProcId() != null) {
            object = pSDEActionBase.getPSDESysProcId();
            xmlNode.setAttribute(FIELD_PSDESYSPROCID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getPSDESysProcName() != null) {
            object = pSDEActionBase.getPSDESysProcName();
            xmlNode.setAttribute(FIELD_PSDESYSPROCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getPSDynaInstId() != null) {
            object = pSDEActionBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getPSSubSysSADEId() != null) {
            object = pSDEActionBase.getPSSubSysSADEId();
            xmlNode.setAttribute(FIELD_PSSUBSYSSADEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getPSSubSysSADetailId() != null) {
            object = pSDEActionBase.getPSSubSysSADetailId();
            xmlNode.setAttribute(FIELD_PSSUBSYSSADETAILID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getPSSubSysSADetailName() != null) {
            object = pSDEActionBase.getPSSubSysSADetailName();
            xmlNode.setAttribute(FIELD_PSSUBSYSSADETAILNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getPSSysDynaModelId() != null) {
            object = pSDEActionBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getPSSysDynaModelName() != null) {
            object = pSDEActionBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getPSSysPFPluginId() != null) {
            object = pSDEActionBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getPSSysPFPluginName() != null) {
            object = pSDEActionBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getPSSysReqItemId() != null) {
            object = pSDEActionBase.getPSSysReqItemId();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getPSSysReqItemName() != null) {
            object = pSDEActionBase.getPSSysReqItemName();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getPSSysSFPluginId() != null) {
            object = pSDEActionBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getPSSysSFPluginName() != null) {
            object = pSDEActionBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getPSSysTaskId() != null) {
            object = pSDEActionBase.getPSSysTaskId();
            xmlNode.setAttribute(FIELD_PSSYSTASKID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getPSSysTaskName() != null) {
            object = pSDEActionBase.getPSSysTaskName();
            xmlNode.setAttribute(FIELD_PSSYSTASKNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getPSSysTestCasesCnt() != null) {
            object = pSDEActionBase.getPSSysTestCasesCnt();
            xmlNode.setAttribute(FIELD_PSSYSTESTCASESCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEActionBase.getPSSysUniStateId() != null) {
            object = pSDEActionBase.getPSSysUniStateId();
            xmlNode.setAttribute(FIELD_PSSYSUNISTATEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getPSSysUniStateName() != null) {
            object = pSDEActionBase.getPSSysUniStateName();
            xmlNode.setAttribute(FIELD_PSSYSUNISTATENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getPubMode() != null) {
            object = pSDEActionBase.getPubMode();
            xmlNode.setAttribute(FIELD_PUBMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEActionBase.getRawServiceMethod() != null) {
            object = pSDEActionBase.getRawServiceMethod();
            xmlNode.setAttribute(FIELD_RAWSERVICEMETHOD, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getRawServiceUrl() != null) {
            object = pSDEActionBase.getRawServiceUrl();
            xmlNode.setAttribute(FIELD_RAWSERVICEURL, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getRequestField() != null) {
            object = pSDEActionBase.getRequestField();
            xmlNode.setAttribute(FIELD_REQUESTFIELD, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getRequestMethod() != null) {
            object = pSDEActionBase.getRequestMethod();
            xmlNode.setAttribute(FIELD_REQUESTMETHOD, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getRequestParamType() != null) {
            object = pSDEActionBase.getRequestParamType();
            xmlNode.setAttribute(FIELD_REQUESTPARAMTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getRequestPath() != null) {
            object = pSDEActionBase.getRequestPath();
            xmlNode.setAttribute(FIELD_REQUESTPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getRetStdDataType() != null) {
            object = pSDEActionBase.getRetStdDataType();
            xmlNode.setAttribute(FIELD_RETSTDDATATYPE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEActionBase.getRetValType() != null) {
            object = pSDEActionBase.getRetValType();
            xmlNode.setAttribute(FIELD_RETVALTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getServiceCodeName() != null) {
            object = pSDEActionBase.getServiceCodeName();
            xmlNode.setAttribute(FIELD_SERVICECODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getSubSysSADetailMode() != null) {
            object = pSDEActionBase.getSubSysSADetailMode();
            xmlNode.setAttribute(FIELD_SUBSYSSADETAILMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEActionBase.getSyncEvent() != null) {
            object = pSDEActionBase.getSyncEvent();
            xmlNode.setAttribute(FIELD_SYNCEVENT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEActionBase.getTestActionMode() != null) {
            object = pSDEActionBase.getTestActionMode();
            xmlNode.setAttribute(FIELD_TESTACTIONMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEActionBase.getTestCaseFlag() != null) {
            object = pSDEActionBase.getTestCaseFlag();
            xmlNode.setAttribute(FIELD_TESTCASEFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEActionBase.getToDoTask() != null) {
            object = pSDEActionBase.getToDoTask();
            xmlNode.setAttribute(FIELD_TODOTASK, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getTSMode() != null) {
            object = pSDEActionBase.getTSMode();
            xmlNode.setAttribute(FIELD_TSMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getUpdateDate() != null) {
            object = pSDEActionBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEActionBase.getUpdateMan() != null) {
            object = pSDEActionBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getUserCat() != null) {
            object = pSDEActionBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getUserParams() != null) {
            object = pSDEActionBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getUserTag() != null) {
            object = pSDEActionBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getUserTag2() != null) {
            object = pSDEActionBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getUserTag3() != null) {
            object = pSDEActionBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getUserTag4() != null) {
            object = pSDEActionBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionBase.getValidFlag() != null) {
            object = pSDEActionBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEActionBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEActionBase pSDEActionBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEActionBase.isActionHolderDirty() && (bl || pSDEActionBase.getActionHolder() != null)) {
            iDataObject.set(FIELD_ACTIONHOLDER, (Object)pSDEActionBase.getActionHolder());
        }
        if (pSDEActionBase.isActionModeDirty() && (bl || pSDEActionBase.getActionMode() != null)) {
            iDataObject.set(FIELD_ACTIONMODE, (Object)pSDEActionBase.getActionMode());
        }
        if (pSDEActionBase.isActionOptionDirty() && (bl || pSDEActionBase.getActionOption() != null)) {
            iDataObject.set(FIELD_ACTIONOPTION, (Object)pSDEActionBase.getActionOption());
        }
        if (pSDEActionBase.isActionParamsDirty() && (bl || pSDEActionBase.getActionParams() != null)) {
            iDataObject.set(FIELD_ACTIONPARAMS, (Object)pSDEActionBase.getActionParams());
        }
        if (pSDEActionBase.isActionTagDirty() && (bl || pSDEActionBase.getActionTag() != null)) {
            iDataObject.set(FIELD_ACTIONTAG, (Object)pSDEActionBase.getActionTag());
        }
        if (pSDEActionBase.isActionTag2Dirty() && (bl || pSDEActionBase.getActionTag2() != null)) {
            iDataObject.set(FIELD_ACTIONTAG2, (Object)pSDEActionBase.getActionTag2());
        }
        if (pSDEActionBase.isActionTag3Dirty() && (bl || pSDEActionBase.getActionTag3() != null)) {
            iDataObject.set(FIELD_ACTIONTAG3, (Object)pSDEActionBase.getActionTag3());
        }
        if (pSDEActionBase.isActionTag4Dirty() && (bl || pSDEActionBase.getActionTag4() != null)) {
            iDataObject.set(FIELD_ACTIONTAG4, (Object)pSDEActionBase.getActionTag4());
        }
        if (pSDEActionBase.isActionTypeDirty() && (bl || pSDEActionBase.getActionType() != null)) {
            iDataObject.set(FIELD_ACTIONTYPE, (Object)pSDEActionBase.getActionType());
        }
        if (pSDEActionBase.isAfterCodeDirty() && (bl || pSDEActionBase.getAfterCode() != null)) {
            iDataObject.set(FIELD_AFTERCODE, (Object)pSDEActionBase.getAfterCode());
        }
        if (pSDEActionBase.isBatchActionModeDirty() && (bl || pSDEActionBase.getBatchActionMode() != null)) {
            iDataObject.set(FIELD_BATCHACTIONMODE, (Object)pSDEActionBase.getBatchActionMode());
        }
        if (pSDEActionBase.isBeforeCodeDirty() && (bl || pSDEActionBase.getBeforeCode() != null)) {
            iDataObject.set(FIELD_BEFORECODE, (Object)pSDEActionBase.getBeforeCode());
        }
        if (pSDEActionBase.isCacheCatDirty() && (bl || pSDEActionBase.getCacheCat() != null)) {
            iDataObject.set(FIELD_CACHECAT, (Object)pSDEActionBase.getCacheCat());
        }
        if (pSDEActionBase.isCacheScopeDirty() && (bl || pSDEActionBase.getCacheScope() != null)) {
            iDataObject.set(FIELD_CACHESCOPE, (Object)pSDEActionBase.getCacheScope());
        }
        if (pSDEActionBase.isCacheTagDirty() && (bl || pSDEActionBase.getCacheTag() != null)) {
            iDataObject.set(FIELD_CACHETAG, (Object)pSDEActionBase.getCacheTag());
        }
        if (pSDEActionBase.isCacheTimeoutDirty() && (bl || pSDEActionBase.getCacheTimeout() != null)) {
            iDataObject.set(FIELD_CACHETIMEOUT, (Object)pSDEActionBase.getCacheTimeout());
        }
        if (pSDEActionBase.isCallerObjDirty() && (bl || pSDEActionBase.getCallerObj() != null)) {
            iDataObject.set(FIELD_CALLEROBJ, (Object)pSDEActionBase.getCallerObj());
        }
        if (pSDEActionBase.isCallTimeoutDirty() && (bl || pSDEActionBase.getCallTimeout() != null)) {
            iDataObject.set(FIELD_CALLTIMEOUT, (Object)pSDEActionBase.getCallTimeout());
        }
        if (pSDEActionBase.isCodeNameDirty() && (bl || pSDEActionBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDEActionBase.getCodeName());
        }
        if (pSDEActionBase.isCreateDateDirty() && (bl || pSDEActionBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEActionBase.getCreateDate());
        }
        if (pSDEActionBase.isCreateManDirty() && (bl || pSDEActionBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEActionBase.getCreateMan());
        }
        if (pSDEActionBase.isCustomCodeDirty() && (bl || pSDEActionBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSDEActionBase.getCustomCode());
        }
        if (pSDEActionBase.isCustomModeDirty() && (bl || pSDEActionBase.getCustomMode() != null)) {
            iDataObject.set(FIELD_CUSTOMMODE, (Object)pSDEActionBase.getCustomMode());
        }
        if (pSDEActionBase.isDynaModelFlagDirty() && (bl || pSDEActionBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSDEActionBase.getDynaModelFlag());
        }
        if (pSDEActionBase.isEnableAuditDirty() && (bl || pSDEActionBase.getEnableAudit() != null)) {
            iDataObject.set(FIELD_ENABLEAUDIT, (Object)pSDEActionBase.getEnableAudit());
        }
        if (pSDEActionBase.isEnableCacheDirty() && (bl || pSDEActionBase.getEnableCache() != null)) {
            iDataObject.set(FIELD_ENABLECACHE, (Object)pSDEActionBase.getEnableCache());
        }
        if (pSDEActionBase.isExtendModeDirty() && (bl || pSDEActionBase.getExtendMode() != null)) {
            iDataObject.set(FIELD_EXTENDMODE, (Object)pSDEActionBase.getExtendMode());
        }
        if (pSDEActionBase.isFinishFlagDirty() && (bl || pSDEActionBase.getFinishFlag() != null)) {
            iDataObject.set(FIELD_FINISHFLAG, (Object)pSDEActionBase.getFinishFlag());
        }
        if (pSDEActionBase.isInPSDEFGroupIdDirty() && (bl || pSDEActionBase.getInPSDEFGroupId() != null)) {
            iDataObject.set(FIELD_INPSDEFGROUPID, (Object)pSDEActionBase.getInPSDEFGroupId());
        }
        if (pSDEActionBase.isInPSDEFGroupNameDirty() && (bl || pSDEActionBase.getInPSDEFGroupName() != null)) {
            iDataObject.set(FIELD_INPSDEFGROUPNAME, (Object)pSDEActionBase.getInPSDEFGroupName());
        }
        if (pSDEActionBase.isInPSDESampleDataIdDirty() && (bl || pSDEActionBase.getInPSDESampleDataId() != null)) {
            iDataObject.set(FIELD_INPSDESAMPLEDATAID, (Object)pSDEActionBase.getInPSDESampleDataId());
        }
        if (pSDEActionBase.isInPSDESampleDataNameDirty() && (bl || pSDEActionBase.getInPSDESampleDataName() != null)) {
            iDataObject.set(FIELD_INPSDESAMPLEDATANAME, (Object)pSDEActionBase.getInPSDESampleDataName());
        }
        if (pSDEActionBase.isInPSSysDynaModelIdDirty() && (bl || pSDEActionBase.getInPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_INPSSYSDYNAMODELID, (Object)pSDEActionBase.getInPSSysDynaModelId());
        }
        if (pSDEActionBase.isInPSSysDynaModelNameDirty() && (bl || pSDEActionBase.getInPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_INPSSYSDYNAMODELNAME, (Object)pSDEActionBase.getInPSSysDynaModelName());
        }
        if (pSDEActionBase.isLockFlagDirty() && (bl || pSDEActionBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSDEActionBase.getLockFlag());
        }
        if (pSDEActionBase.isLogicNameDirty() && (bl || pSDEActionBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSDEActionBase.getLogicName());
        }
        if (pSDEActionBase.isMemoDirty() && (bl || pSDEActionBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEActionBase.getMemo());
        }
        if (pSDEActionBase.isNeedResourceKeyDirty() && (bl || pSDEActionBase.getNeedResourceKey() != null)) {
            iDataObject.set(FIELD_NEEDRESOURCEKEY, (Object)pSDEActionBase.getNeedResourceKey());
        }
        if (pSDEActionBase.isOrderValueDirty() && (bl || pSDEActionBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEActionBase.getOrderValue());
        }
        if (pSDEActionBase.isOutPSDEFGroupIdDirty() && (bl || pSDEActionBase.getOutPSDEFGroupId() != null)) {
            iDataObject.set(FIELD_OUTPSDEFGROUPID, (Object)pSDEActionBase.getOutPSDEFGroupId());
        }
        if (pSDEActionBase.isOutPSDEFGroupNameDirty() && (bl || pSDEActionBase.getOutPSDEFGroupName() != null)) {
            iDataObject.set(FIELD_OUTPSDEFGROUPNAME, (Object)pSDEActionBase.getOutPSDEFGroupName());
        }
        if (pSDEActionBase.isOutPSDESampleDataIdDirty() && (bl || pSDEActionBase.getOutPSDESampleDataId() != null)) {
            iDataObject.set(FIELD_OUTPSDESAMPLEDATAID, (Object)pSDEActionBase.getOutPSDESampleDataId());
        }
        if (pSDEActionBase.isOutPSDESampleDataNameDirty() && (bl || pSDEActionBase.getOutPSDESampleDataName() != null)) {
            iDataObject.set(FIELD_OUTPSDESAMPLEDATANAME, (Object)pSDEActionBase.getOutPSDESampleDataName());
        }
        if (pSDEActionBase.isOutPSSysDynaModelIdDirty() && (bl || pSDEActionBase.getOutPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_OUTPSSYSDYNAMODELID, (Object)pSDEActionBase.getOutPSSysDynaModelId());
        }
        if (pSDEActionBase.isOutPSSysDynaModelNameDirty() && (bl || pSDEActionBase.getOutPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_OUTPSSYSDYNAMODELNAME, (Object)pSDEActionBase.getOutPSSysDynaModelName());
        }
        if (pSDEActionBase.isOutRefPSDEFGroupIdDirty() && (bl || pSDEActionBase.getOutRefPSDEFGroupId() != null)) {
            iDataObject.set(FIELD_OUTREFPSDEFGROUPID, (Object)pSDEActionBase.getOutRefPSDEFGroupId());
        }
        if (pSDEActionBase.isOutRefPSDEFGroupNameDirty() && (bl || pSDEActionBase.getOutRefPSDEFGroupName() != null)) {
            iDataObject.set(FIELD_OUTREFPSDEFGROUPNAME, (Object)pSDEActionBase.getOutRefPSDEFGroupName());
        }
        if (pSDEActionBase.isOutRefPSDEIdDirty() && (bl || pSDEActionBase.getOutRefPSDEId() != null)) {
            iDataObject.set(FIELD_OUTREFPSDEID, (Object)pSDEActionBase.getOutRefPSDEId());
        }
        if (pSDEActionBase.isOutRefPSDENameDirty() && (bl || pSDEActionBase.getOutRefPSDEName() != null)) {
            iDataObject.set(FIELD_OUTREFPSDENAME, (Object)pSDEActionBase.getOutRefPSDEName());
        }
        if (pSDEActionBase.isParamTypeDirty() && (bl || pSDEActionBase.getParamType() != null)) {
            iDataObject.set(FIELD_PARAMTYPE, (Object)pSDEActionBase.getParamType());
        }
        if (pSDEActionBase.isPOTimeDirty() && (bl || pSDEActionBase.getPOTime() != null)) {
            iDataObject.set(FIELD_POTIME, (Object)pSDEActionBase.getPOTime());
        }
        if (pSDEActionBase.isPredefinedTypeDirty() && (bl || pSDEActionBase.getPredefinedType() != null)) {
            iDataObject.set(FIELD_PREDEFINEDTYPE, (Object)pSDEActionBase.getPredefinedType());
        }
        if (pSDEActionBase.isPredefinedTypeParamDirty() && (bl || pSDEActionBase.getPredefinedTypeParam() != null)) {
            iDataObject.set(FIELD_PREDEFINEDTYPEPARAM, (Object)pSDEActionBase.getPredefinedTypeParam());
        }
        if (pSDEActionBase.isPredefinedTypeTextDirty() && (bl || pSDEActionBase.getPredefinedTypeText() != null)) {
            iDataObject.set(FIELD_PREDEFINEDTYPETEXT, (Object)pSDEActionBase.getPredefinedTypeText());
        }
        if (pSDEActionBase.isPrepareLastDirty() && (bl || pSDEActionBase.getPrepareLast() != null)) {
            iDataObject.set(FIELD_PREPARELAST, (Object)pSDEActionBase.getPrepareLast());
        }
        if (pSDEActionBase.isPSDEActionIdDirty() && (bl || pSDEActionBase.getPSDEActionId() != null)) {
            iDataObject.set(FIELD_PSDEACTIONID, (Object)pSDEActionBase.getPSDEActionId());
        }
        if (pSDEActionBase.isPSDEActionLogicsCntDirty() && (bl || pSDEActionBase.getPSDEActionLogicsCnt() != null)) {
            iDataObject.set(FIELD_PSDEACTIONLOGICSCNT, (Object)pSDEActionBase.getPSDEActionLogicsCnt());
        }
        if (pSDEActionBase.isPSDEActionNameDirty() && (bl || pSDEActionBase.getPSDEActionName() != null)) {
            iDataObject.set(FIELD_PSDEACTIONNAME, (Object)pSDEActionBase.getPSDEActionName());
        }
        if (pSDEActionBase.isPSDEActionTemplIdDirty() && (bl || pSDEActionBase.getPSDEActionTemplId() != null)) {
            iDataObject.set(FIELD_PSDEACTIONTEMPLID, (Object)pSDEActionBase.getPSDEActionTemplId());
        }
        if (pSDEActionBase.isPSDEActionTemplNameDirty() && (bl || pSDEActionBase.getPSDEActionTemplName() != null)) {
            iDataObject.set(FIELD_PSDEACTIONTEMPLNAME, (Object)pSDEActionBase.getPSDEActionTemplName());
        }
        if (pSDEActionBase.isPSDEDataFlowIdDirty() && (bl || pSDEActionBase.getPSDEDataFlowId() != null)) {
            iDataObject.set(FIELD_PSDEDATAFLOWID, (Object)pSDEActionBase.getPSDEDataFlowId());
        }
        if (pSDEActionBase.isPSDEDataFlowNameDirty() && (bl || pSDEActionBase.getPSDEDataFlowName() != null)) {
            iDataObject.set(FIELD_PSDEDATAFLOWNAME, (Object)pSDEActionBase.getPSDEDataFlowName());
        }
        if (pSDEActionBase.isPSDEDataQueryIdDirty() && (bl || pSDEActionBase.getPSDEDataQueryId() != null)) {
            iDataObject.set(FIELD_PSDEDATAQUERYID, (Object)pSDEActionBase.getPSDEDataQueryId());
        }
        if (pSDEActionBase.isPSDEDataQueryNameDirty() && (bl || pSDEActionBase.getPSDEDataQueryName() != null)) {
            iDataObject.set(FIELD_PSDEDATAQUERYNAME, (Object)pSDEActionBase.getPSDEDataQueryName());
        }
        if (pSDEActionBase.isPSDEDataSetIdDirty() && (bl || pSDEActionBase.getPSDEDataSetId() != null)) {
            iDataObject.set(FIELD_PSDEDATASETID, (Object)pSDEActionBase.getPSDEDataSetId());
        }
        if (pSDEActionBase.isPSDEDataSetNameDirty() && (bl || pSDEActionBase.getPSDEDataSetName() != null)) {
            iDataObject.set(FIELD_PSDEDATASETNAME, (Object)pSDEActionBase.getPSDEDataSetName());
        }
        if (pSDEActionBase.isPSDEIdDirty() && (bl || pSDEActionBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEActionBase.getPSDEId());
        }
        if (pSDEActionBase.isPSDELogicIdDirty() && (bl || pSDEActionBase.getPSDELogicId() != null)) {
            iDataObject.set(FIELD_PSDELOGICID, (Object)pSDEActionBase.getPSDELogicId());
        }
        if (pSDEActionBase.isPSDELogicNameDirty() && (bl || pSDEActionBase.getPSDELogicName() != null)) {
            iDataObject.set(FIELD_PSDELOGICNAME, (Object)pSDEActionBase.getPSDELogicName());
        }
        if (pSDEActionBase.isPSDEMSActionsCntDirty() && (bl || pSDEActionBase.getPSDEMSActionsCnt() != null)) {
            iDataObject.set(FIELD_PSDEMSACTIONSCNT, (Object)pSDEActionBase.getPSDEMSActionsCnt());
        }
        if (pSDEActionBase.isPSDENameDirty() && (bl || pSDEActionBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEActionBase.getPSDEName());
        }
        if (pSDEActionBase.isPSDEOPPrivIdDirty() && (bl || pSDEActionBase.getPSDEOPPrivId() != null)) {
            iDataObject.set(FIELD_PSDEOPPRIVID, (Object)pSDEActionBase.getPSDEOPPrivId());
        }
        if (pSDEActionBase.isPSDEOPPrivNameDirty() && (bl || pSDEActionBase.getPSDEOPPrivName() != null)) {
            iDataObject.set(FIELD_PSDEOPPRIVNAME, (Object)pSDEActionBase.getPSDEOPPrivName());
        }
        if (pSDEActionBase.isPSDESysProcIdDirty() && (bl || pSDEActionBase.getPSDESysProcId() != null)) {
            iDataObject.set(FIELD_PSDESYSPROCID, (Object)pSDEActionBase.getPSDESysProcId());
        }
        if (pSDEActionBase.isPSDESysProcNameDirty() && (bl || pSDEActionBase.getPSDESysProcName() != null)) {
            iDataObject.set(FIELD_PSDESYSPROCNAME, (Object)pSDEActionBase.getPSDESysProcName());
        }
        if (pSDEActionBase.isPSDynaInstIdDirty() && (bl || pSDEActionBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSDEActionBase.getPSDynaInstId());
        }
        if (pSDEActionBase.isPSSubSysSADEIdDirty() && (bl || pSDEActionBase.getPSSubSysSADEId() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSADEID, (Object)pSDEActionBase.getPSSubSysSADEId());
        }
        if (pSDEActionBase.isPSSubSysSADetailIdDirty() && (bl || pSDEActionBase.getPSSubSysSADetailId() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSADETAILID, (Object)pSDEActionBase.getPSSubSysSADetailId());
        }
        if (pSDEActionBase.isPSSubSysSADetailNameDirty() && (bl || pSDEActionBase.getPSSubSysSADetailName() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSADETAILNAME, (Object)pSDEActionBase.getPSSubSysSADetailName());
        }
        if (pSDEActionBase.isPSSysDynaModelIdDirty() && (bl || pSDEActionBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSDEActionBase.getPSSysDynaModelId());
        }
        if (pSDEActionBase.isPSSysDynaModelNameDirty() && (bl || pSDEActionBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSDEActionBase.getPSSysDynaModelName());
        }
        if (pSDEActionBase.isPSSysPFPluginIdDirty() && (bl || pSDEActionBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSDEActionBase.getPSSysPFPluginId());
        }
        if (pSDEActionBase.isPSSysPFPluginNameDirty() && (bl || pSDEActionBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSDEActionBase.getPSSysPFPluginName());
        }
        if (pSDEActionBase.isPSSysReqItemIdDirty() && (bl || pSDEActionBase.getPSSysReqItemId() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMID, (Object)pSDEActionBase.getPSSysReqItemId());
        }
        if (pSDEActionBase.isPSSysReqItemNameDirty() && (bl || pSDEActionBase.getPSSysReqItemName() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMNAME, (Object)pSDEActionBase.getPSSysReqItemName());
        }
        if (pSDEActionBase.isPSSysSFPluginIdDirty() && (bl || pSDEActionBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSDEActionBase.getPSSysSFPluginId());
        }
        if (pSDEActionBase.isPSSysSFPluginNameDirty() && (bl || pSDEActionBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSDEActionBase.getPSSysSFPluginName());
        }
        if (pSDEActionBase.isPSSysTaskIdDirty() && (bl || pSDEActionBase.getPSSysTaskId() != null)) {
            iDataObject.set(FIELD_PSSYSTASKID, (Object)pSDEActionBase.getPSSysTaskId());
        }
        if (pSDEActionBase.isPSSysTaskNameDirty() && (bl || pSDEActionBase.getPSSysTaskName() != null)) {
            iDataObject.set(FIELD_PSSYSTASKNAME, (Object)pSDEActionBase.getPSSysTaskName());
        }
        if (pSDEActionBase.isPSSysTestCasesCntDirty() && (bl || pSDEActionBase.getPSSysTestCasesCnt() != null)) {
            iDataObject.set(FIELD_PSSYSTESTCASESCNT, (Object)pSDEActionBase.getPSSysTestCasesCnt());
        }
        if (pSDEActionBase.isPSSysUniStateIdDirty() && (bl || pSDEActionBase.getPSSysUniStateId() != null)) {
            iDataObject.set(FIELD_PSSYSUNISTATEID, (Object)pSDEActionBase.getPSSysUniStateId());
        }
        if (pSDEActionBase.isPSSysUniStateNameDirty() && (bl || pSDEActionBase.getPSSysUniStateName() != null)) {
            iDataObject.set(FIELD_PSSYSUNISTATENAME, (Object)pSDEActionBase.getPSSysUniStateName());
        }
        if (pSDEActionBase.isPubModeDirty() && (bl || pSDEActionBase.getPubMode() != null)) {
            iDataObject.set(FIELD_PUBMODE, (Object)pSDEActionBase.getPubMode());
        }
        if (pSDEActionBase.isRawServiceMethodDirty() && (bl || pSDEActionBase.getRawServiceMethod() != null)) {
            iDataObject.set(FIELD_RAWSERVICEMETHOD, (Object)pSDEActionBase.getRawServiceMethod());
        }
        if (pSDEActionBase.isRawServiceUrlDirty() && (bl || pSDEActionBase.getRawServiceUrl() != null)) {
            iDataObject.set(FIELD_RAWSERVICEURL, (Object)pSDEActionBase.getRawServiceUrl());
        }
        if (pSDEActionBase.isRequestFieldDirty() && (bl || pSDEActionBase.getRequestField() != null)) {
            iDataObject.set(FIELD_REQUESTFIELD, (Object)pSDEActionBase.getRequestField());
        }
        if (pSDEActionBase.isRequestMethodDirty() && (bl || pSDEActionBase.getRequestMethod() != null)) {
            iDataObject.set(FIELD_REQUESTMETHOD, (Object)pSDEActionBase.getRequestMethod());
        }
        if (pSDEActionBase.isRequestParamTypeDirty() && (bl || pSDEActionBase.getRequestParamType() != null)) {
            iDataObject.set(FIELD_REQUESTPARAMTYPE, (Object)pSDEActionBase.getRequestParamType());
        }
        if (pSDEActionBase.isRequestPathDirty() && (bl || pSDEActionBase.getRequestPath() != null)) {
            iDataObject.set(FIELD_REQUESTPATH, (Object)pSDEActionBase.getRequestPath());
        }
        if (pSDEActionBase.isRetStdDataTypeDirty() && (bl || pSDEActionBase.getRetStdDataType() != null)) {
            iDataObject.set(FIELD_RETSTDDATATYPE, (Object)pSDEActionBase.getRetStdDataType());
        }
        if (pSDEActionBase.isRetValTypeDirty() && (bl || pSDEActionBase.getRetValType() != null)) {
            iDataObject.set(FIELD_RETVALTYPE, (Object)pSDEActionBase.getRetValType());
        }
        if (pSDEActionBase.isServiceCodeNameDirty() && (bl || pSDEActionBase.getServiceCodeName() != null)) {
            iDataObject.set(FIELD_SERVICECODENAME, (Object)pSDEActionBase.getServiceCodeName());
        }
        if (pSDEActionBase.isSubSysSADetailModeDirty() && (bl || pSDEActionBase.getSubSysSADetailMode() != null)) {
            iDataObject.set(FIELD_SUBSYSSADETAILMODE, (Object)pSDEActionBase.getSubSysSADetailMode());
        }
        if (pSDEActionBase.isSyncEventDirty() && (bl || pSDEActionBase.getSyncEvent() != null)) {
            iDataObject.set(FIELD_SYNCEVENT, (Object)pSDEActionBase.getSyncEvent());
        }
        if (pSDEActionBase.isTestActionModeDirty() && (bl || pSDEActionBase.getTestActionMode() != null)) {
            iDataObject.set(FIELD_TESTACTIONMODE, (Object)pSDEActionBase.getTestActionMode());
        }
        if (pSDEActionBase.isTestCaseFlagDirty() && (bl || pSDEActionBase.getTestCaseFlag() != null)) {
            iDataObject.set(FIELD_TESTCASEFLAG, (Object)pSDEActionBase.getTestCaseFlag());
        }
        if (pSDEActionBase.isToDoTaskDirty() && (bl || pSDEActionBase.getToDoTask() != null)) {
            iDataObject.set(FIELD_TODOTASK, (Object)pSDEActionBase.getToDoTask());
        }
        if (pSDEActionBase.isTSModeDirty() && (bl || pSDEActionBase.getTSMode() != null)) {
            iDataObject.set(FIELD_TSMODE, (Object)pSDEActionBase.getTSMode());
        }
        if (pSDEActionBase.isUpdateDateDirty() && (bl || pSDEActionBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEActionBase.getUpdateDate());
        }
        if (pSDEActionBase.isUpdateManDirty() && (bl || pSDEActionBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEActionBase.getUpdateMan());
        }
        if (pSDEActionBase.isUserCatDirty() && (bl || pSDEActionBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEActionBase.getUserCat());
        }
        if (pSDEActionBase.isUserParamsDirty() && (bl || pSDEActionBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSDEActionBase.getUserParams());
        }
        if (pSDEActionBase.isUserTagDirty() && (bl || pSDEActionBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEActionBase.getUserTag());
        }
        if (pSDEActionBase.isUserTag2Dirty() && (bl || pSDEActionBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEActionBase.getUserTag2());
        }
        if (pSDEActionBase.isUserTag3Dirty() && (bl || pSDEActionBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEActionBase.getUserTag3());
        }
        if (pSDEActionBase.isUserTag4Dirty() && (bl || pSDEActionBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEActionBase.getUserTag4());
        }
        if (pSDEActionBase.isValidFlagDirty() && (bl || pSDEActionBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDEActionBase.getValidFlag());
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
        return PSDEActionBase.remove(this, n);
    }

    private static boolean remove(PSDEActionBase pSDEActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEActionBase.resetActionHolder();
                return true;
            }
            case 1: {
                pSDEActionBase.resetActionMode();
                return true;
            }
            case 2: {
                pSDEActionBase.resetActionOption();
                return true;
            }
            case 3: {
                pSDEActionBase.resetActionParams();
                return true;
            }
            case 4: {
                pSDEActionBase.resetActionTag();
                return true;
            }
            case 5: {
                pSDEActionBase.resetActionTag2();
                return true;
            }
            case 6: {
                pSDEActionBase.resetActionTag3();
                return true;
            }
            case 7: {
                pSDEActionBase.resetActionTag4();
                return true;
            }
            case 8: {
                pSDEActionBase.resetActionType();
                return true;
            }
            case 9: {
                pSDEActionBase.resetAfterCode();
                return true;
            }
            case 10: {
                pSDEActionBase.resetBatchActionMode();
                return true;
            }
            case 11: {
                pSDEActionBase.resetBeforeCode();
                return true;
            }
            case 12: {
                pSDEActionBase.resetCacheCat();
                return true;
            }
            case 13: {
                pSDEActionBase.resetCacheScope();
                return true;
            }
            case 14: {
                pSDEActionBase.resetCacheTag();
                return true;
            }
            case 15: {
                pSDEActionBase.resetCacheTimeout();
                return true;
            }
            case 16: {
                pSDEActionBase.resetCallerObj();
                return true;
            }
            case 17: {
                pSDEActionBase.resetCallTimeout();
                return true;
            }
            case 18: {
                pSDEActionBase.resetCodeName();
                return true;
            }
            case 19: {
                pSDEActionBase.resetCreateDate();
                return true;
            }
            case 20: {
                pSDEActionBase.resetCreateMan();
                return true;
            }
            case 21: {
                pSDEActionBase.resetCustomCode();
                return true;
            }
            case 22: {
                pSDEActionBase.resetCustomMode();
                return true;
            }
            case 23: {
                pSDEActionBase.resetDynaModelFlag();
                return true;
            }
            case 24: {
                pSDEActionBase.resetEnableAudit();
                return true;
            }
            case 25: {
                pSDEActionBase.resetEnableCache();
                return true;
            }
            case 26: {
                pSDEActionBase.resetExtendMode();
                return true;
            }
            case 27: {
                pSDEActionBase.resetFinishFlag();
                return true;
            }
            case 28: {
                pSDEActionBase.resetInPSDEFGroupId();
                return true;
            }
            case 29: {
                pSDEActionBase.resetInPSDEFGroupName();
                return true;
            }
            case 30: {
                pSDEActionBase.resetInPSDESampleDataId();
                return true;
            }
            case 31: {
                pSDEActionBase.resetInPSDESampleDataName();
                return true;
            }
            case 32: {
                pSDEActionBase.resetInPSSysDynaModelId();
                return true;
            }
            case 33: {
                pSDEActionBase.resetInPSSysDynaModelName();
                return true;
            }
            case 34: {
                pSDEActionBase.resetLockFlag();
                return true;
            }
            case 35: {
                pSDEActionBase.resetLogicName();
                return true;
            }
            case 36: {
                pSDEActionBase.resetMemo();
                return true;
            }
            case 37: {
                pSDEActionBase.resetNeedResourceKey();
                return true;
            }
            case 38: {
                pSDEActionBase.resetOrderValue();
                return true;
            }
            case 39: {
                pSDEActionBase.resetOutPSDEFGroupId();
                return true;
            }
            case 40: {
                pSDEActionBase.resetOutPSDEFGroupName();
                return true;
            }
            case 41: {
                pSDEActionBase.resetOutPSDESampleDataId();
                return true;
            }
            case 42: {
                pSDEActionBase.resetOutPSDESampleDataName();
                return true;
            }
            case 43: {
                pSDEActionBase.resetOutPSSysDynaModelId();
                return true;
            }
            case 44: {
                pSDEActionBase.resetOutPSSysDynaModelName();
                return true;
            }
            case 45: {
                pSDEActionBase.resetOutRefPSDEFGroupId();
                return true;
            }
            case 46: {
                pSDEActionBase.resetOutRefPSDEFGroupName();
                return true;
            }
            case 47: {
                pSDEActionBase.resetOutRefPSDEId();
                return true;
            }
            case 48: {
                pSDEActionBase.resetOutRefPSDEName();
                return true;
            }
            case 49: {
                pSDEActionBase.resetParamType();
                return true;
            }
            case 50: {
                pSDEActionBase.resetPOTime();
                return true;
            }
            case 51: {
                pSDEActionBase.resetPredefinedType();
                return true;
            }
            case 52: {
                pSDEActionBase.resetPredefinedTypeParam();
                return true;
            }
            case 53: {
                pSDEActionBase.resetPredefinedTypeText();
                return true;
            }
            case 54: {
                pSDEActionBase.resetPrepareLast();
                return true;
            }
            case 55: {
                pSDEActionBase.resetPSDEActionId();
                return true;
            }
            case 56: {
                pSDEActionBase.resetPSDEActionLogicsCnt();
                return true;
            }
            case 57: {
                pSDEActionBase.resetPSDEActionName();
                return true;
            }
            case 58: {
                pSDEActionBase.resetPSDEActionTemplId();
                return true;
            }
            case 59: {
                pSDEActionBase.resetPSDEActionTemplName();
                return true;
            }
            case 60: {
                pSDEActionBase.resetPSDEDataFlowId();
                return true;
            }
            case 61: {
                pSDEActionBase.resetPSDEDataFlowName();
                return true;
            }
            case 62: {
                pSDEActionBase.resetPSDEDataQueryId();
                return true;
            }
            case 63: {
                pSDEActionBase.resetPSDEDataQueryName();
                return true;
            }
            case 64: {
                pSDEActionBase.resetPSDEDataSetId();
                return true;
            }
            case 65: {
                pSDEActionBase.resetPSDEDataSetName();
                return true;
            }
            case 66: {
                pSDEActionBase.resetPSDEId();
                return true;
            }
            case 67: {
                pSDEActionBase.resetPSDELogicId();
                return true;
            }
            case 68: {
                pSDEActionBase.resetPSDELogicName();
                return true;
            }
            case 69: {
                pSDEActionBase.resetPSDEMSActionsCnt();
                return true;
            }
            case 70: {
                pSDEActionBase.resetPSDEName();
                return true;
            }
            case 71: {
                pSDEActionBase.resetPSDEOPPrivId();
                return true;
            }
            case 72: {
                pSDEActionBase.resetPSDEOPPrivName();
                return true;
            }
            case 73: {
                pSDEActionBase.resetPSDESysProcId();
                return true;
            }
            case 74: {
                pSDEActionBase.resetPSDESysProcName();
                return true;
            }
            case 75: {
                pSDEActionBase.resetPSDynaInstId();
                return true;
            }
            case 76: {
                pSDEActionBase.resetPSSubSysSADEId();
                return true;
            }
            case 77: {
                pSDEActionBase.resetPSSubSysSADetailId();
                return true;
            }
            case 78: {
                pSDEActionBase.resetPSSubSysSADetailName();
                return true;
            }
            case 79: {
                pSDEActionBase.resetPSSysDynaModelId();
                return true;
            }
            case 80: {
                pSDEActionBase.resetPSSysDynaModelName();
                return true;
            }
            case 81: {
                pSDEActionBase.resetPSSysPFPluginId();
                return true;
            }
            case 82: {
                pSDEActionBase.resetPSSysPFPluginName();
                return true;
            }
            case 83: {
                pSDEActionBase.resetPSSysReqItemId();
                return true;
            }
            case 84: {
                pSDEActionBase.resetPSSysReqItemName();
                return true;
            }
            case 85: {
                pSDEActionBase.resetPSSysSFPluginId();
                return true;
            }
            case 86: {
                pSDEActionBase.resetPSSysSFPluginName();
                return true;
            }
            case 87: {
                pSDEActionBase.resetPSSysTaskId();
                return true;
            }
            case 88: {
                pSDEActionBase.resetPSSysTaskName();
                return true;
            }
            case 89: {
                pSDEActionBase.resetPSSysTestCasesCnt();
                return true;
            }
            case 90: {
                pSDEActionBase.resetPSSysUniStateId();
                return true;
            }
            case 91: {
                pSDEActionBase.resetPSSysUniStateName();
                return true;
            }
            case 92: {
                pSDEActionBase.resetPubMode();
                return true;
            }
            case 93: {
                pSDEActionBase.resetRawServiceMethod();
                return true;
            }
            case 94: {
                pSDEActionBase.resetRawServiceUrl();
                return true;
            }
            case 95: {
                pSDEActionBase.resetRequestField();
                return true;
            }
            case 96: {
                pSDEActionBase.resetRequestMethod();
                return true;
            }
            case 97: {
                pSDEActionBase.resetRequestParamType();
                return true;
            }
            case 98: {
                pSDEActionBase.resetRequestPath();
                return true;
            }
            case 99: {
                pSDEActionBase.resetRetStdDataType();
                return true;
            }
            case 100: {
                pSDEActionBase.resetRetValType();
                return true;
            }
            case 101: {
                pSDEActionBase.resetServiceCodeName();
                return true;
            }
            case 102: {
                pSDEActionBase.resetSubSysSADetailMode();
                return true;
            }
            case 103: {
                pSDEActionBase.resetSyncEvent();
                return true;
            }
            case 104: {
                pSDEActionBase.resetTestActionMode();
                return true;
            }
            case 105: {
                pSDEActionBase.resetTestCaseFlag();
                return true;
            }
            case 106: {
                pSDEActionBase.resetToDoTask();
                return true;
            }
            case 107: {
                pSDEActionBase.resetTSMode();
                return true;
            }
            case 108: {
                pSDEActionBase.resetUpdateDate();
                return true;
            }
            case 109: {
                pSDEActionBase.resetUpdateMan();
                return true;
            }
            case 110: {
                pSDEActionBase.resetUserCat();
                return true;
            }
            case 111: {
                pSDEActionBase.resetUserParams();
                return true;
            }
            case 112: {
                pSDEActionBase.resetUserTag();
                return true;
            }
            case 113: {
                pSDEActionBase.resetUserTag2();
                return true;
            }
            case 114: {
                pSDEActionBase.resetUserTag3();
                return true;
            }
            case 115: {
                pSDEActionBase.resetUserTag4();
                return true;
            }
            case 116: {
                pSDEActionBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getOutRefPSDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOutRefPSDE();
        }
        if (this.getOutRefPSDEId() == null) {
            return null;
        }
        Integer n = this.objOutRefPSDELock;
        synchronized (n) {
            if (this.outrefpsde != null && DataTypeHelper.compare((int)25, (Object)this.getOutRefPSDEId(), (Object)this.outrefpsde.getPSDataEntityId()) != 0L) {
                this.outrefpsde = null;
            }
            if (this.outrefpsde == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getOutRefPSDEId());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.outrefpsde = pSDataEntity;
            }
            return this.outrefpsde;
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
    public PSDEActionTempl getPSDEActionTempl() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionTempl();
        }
        if (this.getPSDEActionTemplId() == null) {
            return null;
        }
        Integer n = this.objPSDEActionTemplLock;
        synchronized (n) {
            if (this.psdeactiontempl != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEActionTemplId(), (Object)this.psdeactiontempl.getPSDEActionTemplId()) != 0L) {
                this.psdeactiontempl = null;
            }
            if (this.psdeactiontempl == null) {
                PSDEActionTempl pSDEActionTempl = new PSDEActionTempl();
                pSDEActionTempl.setPSDEActionTemplId(this.getPSDEActionTemplId());
                PSDEActionTemplService pSDEActionTemplService = (PSDEActionTemplService)ServiceGlobal.getService(PSDEActionTemplService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionTemplService.autoGet(pSDEActionTempl);
                this.psdeactiontempl = pSDEActionTempl;
            }
            return this.psdeactiontempl;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataQuery getPSDEDataQuery() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataQuery();
        }
        if (this.getPSDEDataQueryId() == null) {
            return null;
        }
        Integer n = this.objPSDEDataQueryLock;
        synchronized (n) {
            if (this.psdedataquery != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDataQueryId(), (Object)this.psdedataquery.getPSDEDataQueryId()) != 0L) {
                this.psdedataquery = null;
            }
            if (this.psdedataquery == null) {
                PSDEDataQuery pSDEDataQuery = new PSDEDataQuery();
                pSDEDataQuery.setPSDEDataQueryId(this.getPSDEDataQueryId());
                PSDEDataQueryService pSDEDataQueryService = (PSDEDataQueryService)ServiceGlobal.getService(PSDEDataQueryService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataQueryService.autoGet(pSDEDataQuery);
                this.psdedataquery = pSDEDataQuery;
            }
            return this.psdedataquery;
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
                pSDEDataSetService.autoGet(pSDEDataSet);
                this.psdedataset = pSDEDataSet;
            }
            return this.psdedataset;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEFGroup getInPSDEFGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInPSDEFGroup();
        }
        if (this.getInPSDEFGroupId() == null) {
            return null;
        }
        Integer n = this.objInPSDEFGroupLock;
        synchronized (n) {
            if (this.inpsdefgroup != null && DataTypeHelper.compare((int)25, (Object)this.getInPSDEFGroupId(), (Object)this.inpsdefgroup.getPSDEFGroupId()) != 0L) {
                this.inpsdefgroup = null;
            }
            if (this.inpsdefgroup == null) {
                PSDEFGroup pSDEFGroup = new PSDEFGroup();
                pSDEFGroup.setPSDEFGroupId(this.getInPSDEFGroupId());
                PSDEFGroupService pSDEFGroupService = (PSDEFGroupService)ServiceGlobal.getService(PSDEFGroupService.class, (SessionFactory)this.getSessionFactory());
                pSDEFGroupService.autoGet(pSDEFGroup);
                this.inpsdefgroup = pSDEFGroup;
            }
            return this.inpsdefgroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEFGroup getOutPSDEFGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOutPSDEFGroup();
        }
        if (this.getOutPSDEFGroupId() == null) {
            return null;
        }
        Integer n = this.objOutPSDEFGroupLock;
        synchronized (n) {
            if (this.outpsdefgroup != null && DataTypeHelper.compare((int)25, (Object)this.getOutPSDEFGroupId(), (Object)this.outpsdefgroup.getPSDEFGroupId()) != 0L) {
                this.outpsdefgroup = null;
            }
            if (this.outpsdefgroup == null) {
                PSDEFGroup pSDEFGroup = new PSDEFGroup();
                pSDEFGroup.setPSDEFGroupId(this.getOutPSDEFGroupId());
                PSDEFGroupService pSDEFGroupService = (PSDEFGroupService)ServiceGlobal.getService(PSDEFGroupService.class, (SessionFactory)this.getSessionFactory());
                pSDEFGroupService.autoGet(pSDEFGroup);
                this.outpsdefgroup = pSDEFGroup;
            }
            return this.outpsdefgroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEFGroup getOutRefPSDEFGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOutRefPSDEFGroup();
        }
        if (this.getOutRefPSDEFGroupId() == null) {
            return null;
        }
        Integer n = this.objOutRefPSDEFGroupLock;
        synchronized (n) {
            if (this.outrefpsdefgroup != null && DataTypeHelper.compare((int)25, (Object)this.getOutRefPSDEFGroupId(), (Object)this.outrefpsdefgroup.getPSDEFGroupId()) != 0L) {
                this.outrefpsdefgroup = null;
            }
            if (this.outrefpsdefgroup == null) {
                PSDEFGroup pSDEFGroup = new PSDEFGroup();
                pSDEFGroup.setPSDEFGroupId(this.getOutRefPSDEFGroupId());
                PSDEFGroupService pSDEFGroupService = (PSDEFGroupService)ServiceGlobal.getService(PSDEFGroupService.class, (SessionFactory)this.getSessionFactory());
                pSDEFGroupService.autoGet(pSDEFGroup);
                this.outrefpsdefgroup = pSDEFGroup;
            }
            return this.outrefpsdefgroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDELogic getPSDEDataFlow() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataFlow();
        }
        if (this.getPSDEDataFlowId() == null) {
            return null;
        }
        Integer n = this.objPSDEDataFlowLock;
        synchronized (n) {
            if (this.psdedataflow != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDataFlowId(), (Object)this.psdedataflow.getPSDELogicId()) != 0L) {
                this.psdedataflow = null;
            }
            if (this.psdedataflow == null) {
                PSDELogic pSDELogic = new PSDELogic();
                pSDELogic.setPSDELogicId(this.getPSDEDataFlowId());
                PSDELogicService pSDELogicService = (PSDELogicService)ServiceGlobal.getService(PSDELogicService.class, (SessionFactory)this.getSessionFactory());
                pSDELogicService.autoGet(pSDELogic);
                this.psdedataflow = pSDELogic;
            }
            return this.psdedataflow;
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
    public PSDESampleData getInPSDESampleData() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInPSDESampleData();
        }
        if (this.getInPSDESampleDataId() == null) {
            return null;
        }
        Integer n = this.objInPSDESampleDataLock;
        synchronized (n) {
            if (this.inpsdesampledata != null && DataTypeHelper.compare((int)25, (Object)this.getInPSDESampleDataId(), (Object)this.inpsdesampledata.getPSDESampleDataId()) != 0L) {
                this.inpsdesampledata = null;
            }
            if (this.inpsdesampledata == null) {
                PSDESampleData pSDESampleData = new PSDESampleData();
                pSDESampleData.setPSDESampleDataId(this.getInPSDESampleDataId());
                PSDESampleDataService pSDESampleDataService = (PSDESampleDataService)ServiceGlobal.getService(PSDESampleDataService.class, (SessionFactory)this.getSessionFactory());
                pSDESampleDataService.autoGet(pSDESampleData);
                this.inpsdesampledata = pSDESampleData;
            }
            return this.inpsdesampledata;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDESampleData getOutPSDESampleData() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOutPSDESampleData();
        }
        if (this.getOutPSDESampleDataId() == null) {
            return null;
        }
        Integer n = this.objOutPSDESampleDataLock;
        synchronized (n) {
            if (this.outpsdesampledata != null && DataTypeHelper.compare((int)25, (Object)this.getOutPSDESampleDataId(), (Object)this.outpsdesampledata.getPSDESampleDataId()) != 0L) {
                this.outpsdesampledata = null;
            }
            if (this.outpsdesampledata == null) {
                PSDESampleData pSDESampleData = new PSDESampleData();
                pSDESampleData.setPSDESampleDataId(this.getOutPSDESampleDataId());
                PSDESampleDataService pSDESampleDataService = (PSDESampleDataService)ServiceGlobal.getService(PSDESampleDataService.class, (SessionFactory)this.getSessionFactory());
                pSDESampleDataService.autoGet(pSDESampleData);
                this.outpsdesampledata = pSDESampleData;
            }
            return this.outpsdesampledata;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDESysProc getPSDESysProc() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDESysProc();
        }
        if (this.getPSDESysProcId() == null) {
            return null;
        }
        Integer n = this.objPSDESysProcLock;
        synchronized (n) {
            if (this.psdesysproc != null && DataTypeHelper.compare((int)25, (Object)this.getPSDESysProcId(), (Object)this.psdesysproc.getPSDESysProcId()) != 0L) {
                this.psdesysproc = null;
            }
            if (this.psdesysproc == null) {
                PSDESysProc pSDESysProc = new PSDESysProc();
                pSDESysProc.setPSDESysProcId(this.getPSDESysProcId());
                PSDESysProcService pSDESysProcService = (PSDESysProcService)ServiceGlobal.getService(PSDESysProcService.class, (SessionFactory)this.getSessionFactory());
                pSDESysProcService.autoGet(pSDESysProc);
                this.psdesysproc = pSDESysProc;
            }
            return this.psdesysproc;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSubSysSADetail getPSSubSysSADetail() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysSADetail();
        }
        if (this.getPSSubSysSADetailId() == null) {
            return null;
        }
        Integer n = this.objPSSubSysSADetailLock;
        synchronized (n) {
            if (this.pssubsyssadetail != null && DataTypeHelper.compare((int)25, (Object)this.getPSSubSysSADetailId(), (Object)this.pssubsyssadetail.getPSSubSysSADetailId()) != 0L) {
                this.pssubsyssadetail = null;
            }
            if (this.pssubsyssadetail == null) {
                PSSubSysSADetail pSSubSysSADetail = new PSSubSysSADetail();
                pSSubSysSADetail.setPSSubSysSADetailId(this.getPSSubSysSADetailId());
                PSSubSysSADetailService pSSubSysSADetailService = (PSSubSysSADetailService)ServiceGlobal.getService(PSSubSysSADetailService.class, (SessionFactory)this.getSessionFactory());
                pSSubSysSADetailService.autoGet(pSSubSysSADetail);
                this.pssubsyssadetail = pSSubSysSADetail;
            }
            return this.pssubsyssadetail;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDynaModel getInPSSysDynaModel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInPSSysDynaModel();
        }
        if (this.getInPSSysDynaModelId() == null) {
            return null;
        }
        Integer n = this.objInPSSysDynaModelLock;
        synchronized (n) {
            if (this.inpssysdynamodel != null && DataTypeHelper.compare((int)25, (Object)this.getInPSSysDynaModelId(), (Object)this.inpssysdynamodel.getPSSysDynaModelId()) != 0L) {
                this.inpssysdynamodel = null;
            }
            if (this.inpssysdynamodel == null) {
                PSSysDynaModel pSSysDynaModel = new PSSysDynaModel();
                pSSysDynaModel.setPSSysDynaModelId(this.getInPSSysDynaModelId());
                PSSysDynaModelService pSSysDynaModelService = (PSSysDynaModelService)ServiceGlobal.getService(PSSysDynaModelService.class, (SessionFactory)this.getSessionFactory());
                pSSysDynaModelService.autoGet(pSSysDynaModel);
                this.inpssysdynamodel = pSSysDynaModel;
            }
            return this.inpssysdynamodel;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDynaModel getOutPSSysDynaModel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOutPSSysDynaModel();
        }
        if (this.getOutPSSysDynaModelId() == null) {
            return null;
        }
        Integer n = this.objOutPSSysDynaModelLock;
        synchronized (n) {
            if (this.outpssysdynamodel != null && DataTypeHelper.compare((int)25, (Object)this.getOutPSSysDynaModelId(), (Object)this.outpssysdynamodel.getPSSysDynaModelId()) != 0L) {
                this.outpssysdynamodel = null;
            }
            if (this.outpssysdynamodel == null) {
                PSSysDynaModel pSSysDynaModel = new PSSysDynaModel();
                pSSysDynaModel.setPSSysDynaModelId(this.getOutPSSysDynaModelId());
                PSSysDynaModelService pSSysDynaModelService = (PSSysDynaModelService)ServiceGlobal.getService(PSSysDynaModelService.class, (SessionFactory)this.getSessionFactory());
                pSSysDynaModelService.autoGet(pSSysDynaModel);
                this.outpssysdynamodel = pSSysDynaModel;
            }
            return this.outpssysdynamodel;
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
                pSSysReqItemService.autoGet(pSSysReqItem);
                this.pssysreqitem = pSSysReqItem;
            }
            return this.pssysreqitem;
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
                pSSysTaskService.autoGet(pSSysTask);
                this.pssystask = pSSysTask;
            }
            return this.pssystask;
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
                pSSysUniStateService.autoGet(pSSysUniState);
                this.pssysunistate = pSSysUniState;
            }
            return this.pssysunistate;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEActionLogic> getPSDEActionLogics() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionLogics();
        }
        if (this.getPSDEActionId() == null) {
            return null;
        }
        PSDEActionLogicService pSDEActionLogicService = (PSDEActionLogicService)ServiceGlobal.getService(PSDEActionLogicService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEActionLogicsLock;
        synchronized (n) {
            if (this.psdeactionlogics == null) {
                this.psdeactionlogics = pSDEActionLogicService.selectByPSDEAction(this);
            }
            return this.psdeactionlogics;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEActionParam> getPSDEActionParams() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionParams();
        }
        if (this.getPSDEActionId() == null) {
            return null;
        }
        PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
        PSDEActionParamService pSDEActionParamService = (PSDEActionParamService)ServiceGlobal.getService(PSDEActionParamService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEActionParamsLock;
        synchronized (n) {
            if (this.psdeactionparams == null) {
                this.psdeactionparams = pSDEActionService.isTempData(this) ? pSDEActionParamService.selectTempByPSDEAction(this) : pSDEActionParamService.selectByPSDEAction(this);
            }
            return this.psdeactionparams;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEActionVR> getPSDEActionVRs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionVRs();
        }
        if (this.getPSDEActionId() == null) {
            return null;
        }
        PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
        PSDEActionVRService pSDEActionVRService = (PSDEActionVRService)ServiceGlobal.getService(PSDEActionVRService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEActionVRsLock;
        synchronized (n) {
            if (this.psdeactionvrs == null) {
                this.psdeactionvrs = pSDEActionService.isTempData(this) ? pSDEActionVRService.selectTempByPSDEAction(this) : pSDEActionVRService.selectByPSDEAction(this);
            }
            return this.psdeactionvrs;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEMSAction> getPSDEMSActions() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMSActions();
        }
        if (this.getPSDEActionId() == null) {
            return null;
        }
        PSDEMSActionService pSDEMSActionService = (PSDEMSActionService)ServiceGlobal.getService(PSDEMSActionService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEMSActionsLock;
        synchronized (n) {
            if (this.psdemsactions == null) {
                this.psdemsactions = pSDEMSActionService.selectByPSDEAction(this);
            }
            return this.psdemsactions;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysTestCase> getPSSysTestCases() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTestCases();
        }
        if (this.getPSDEActionId() == null) {
            return null;
        }
        PSSysTestCaseService pSSysTestCaseService = (PSSysTestCaseService)ServiceGlobal.getService(PSSysTestCaseService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysTestCasesLock;
        synchronized (n) {
            if (this.pssystestcases == null) {
                this.pssystestcases = pSSysTestCaseService.selectByPSDEAction(this);
            }
            return this.pssystestcases;
        }
    }

    private PSDEActionBase getProxyEntity() {
        return this.proxyPSDEActionBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEActionBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEActionBase) {
            this.proxyPSDEActionBase = (PSDEActionBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ACTIONHOLDER, 0);
        fieldIndexMap.put(FIELD_ACTIONMODE, 1);
        fieldIndexMap.put(FIELD_ACTIONOPTION, 2);
        fieldIndexMap.put(FIELD_ACTIONPARAMS, 3);
        fieldIndexMap.put(FIELD_ACTIONTAG, 4);
        fieldIndexMap.put(FIELD_ACTIONTAG2, 5);
        fieldIndexMap.put(FIELD_ACTIONTAG3, 6);
        fieldIndexMap.put(FIELD_ACTIONTAG4, 7);
        fieldIndexMap.put(FIELD_ACTIONTYPE, 8);
        fieldIndexMap.put(FIELD_AFTERCODE, 9);
        fieldIndexMap.put(FIELD_BATCHACTIONMODE, 10);
        fieldIndexMap.put(FIELD_BEFORECODE, 11);
        fieldIndexMap.put(FIELD_CACHECAT, 12);
        fieldIndexMap.put(FIELD_CACHESCOPE, 13);
        fieldIndexMap.put(FIELD_CACHETAG, 14);
        fieldIndexMap.put(FIELD_CACHETIMEOUT, 15);
        fieldIndexMap.put(FIELD_CALLEROBJ, 16);
        fieldIndexMap.put(FIELD_CALLTIMEOUT, 17);
        fieldIndexMap.put(FIELD_CODENAME, 18);
        fieldIndexMap.put(FIELD_CREATEDATE, 19);
        fieldIndexMap.put(FIELD_CREATEMAN, 20);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 21);
        fieldIndexMap.put(FIELD_CUSTOMMODE, 22);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 23);
        fieldIndexMap.put(FIELD_ENABLEAUDIT, 24);
        fieldIndexMap.put(FIELD_ENABLECACHE, 25);
        fieldIndexMap.put(FIELD_EXTENDMODE, 26);
        fieldIndexMap.put(FIELD_FINISHFLAG, 27);
        fieldIndexMap.put(FIELD_INPSDEFGROUPID, 28);
        fieldIndexMap.put(FIELD_INPSDEFGROUPNAME, 29);
        fieldIndexMap.put(FIELD_INPSDESAMPLEDATAID, 30);
        fieldIndexMap.put(FIELD_INPSDESAMPLEDATANAME, 31);
        fieldIndexMap.put(FIELD_INPSSYSDYNAMODELID, 32);
        fieldIndexMap.put(FIELD_INPSSYSDYNAMODELNAME, 33);
        fieldIndexMap.put(FIELD_LOCKFLAG, 34);
        fieldIndexMap.put(FIELD_LOGICNAME, 35);
        fieldIndexMap.put(FIELD_MEMO, 36);
        fieldIndexMap.put(FIELD_NEEDRESOURCEKEY, 37);
        fieldIndexMap.put(FIELD_ORDERVALUE, 38);
        fieldIndexMap.put(FIELD_OUTPSDEFGROUPID, 39);
        fieldIndexMap.put(FIELD_OUTPSDEFGROUPNAME, 40);
        fieldIndexMap.put(FIELD_OUTPSDESAMPLEDATAID, 41);
        fieldIndexMap.put(FIELD_OUTPSDESAMPLEDATANAME, 42);
        fieldIndexMap.put(FIELD_OUTPSSYSDYNAMODELID, 43);
        fieldIndexMap.put(FIELD_OUTPSSYSDYNAMODELNAME, 44);
        fieldIndexMap.put(FIELD_OUTREFPSDEFGROUPID, 45);
        fieldIndexMap.put(FIELD_OUTREFPSDEFGROUPNAME, 46);
        fieldIndexMap.put(FIELD_OUTREFPSDEID, 47);
        fieldIndexMap.put(FIELD_OUTREFPSDENAME, 48);
        fieldIndexMap.put(FIELD_PARAMTYPE, 49);
        fieldIndexMap.put(FIELD_POTIME, 50);
        fieldIndexMap.put(FIELD_PREDEFINEDTYPE, 51);
        fieldIndexMap.put(FIELD_PREDEFINEDTYPEPARAM, 52);
        fieldIndexMap.put(FIELD_PREDEFINEDTYPETEXT, 53);
        fieldIndexMap.put(FIELD_PREPARELAST, 54);
        fieldIndexMap.put(FIELD_PSDEACTIONID, 55);
        fieldIndexMap.put(FIELD_PSDEACTIONLOGICSCNT, 56);
        fieldIndexMap.put(FIELD_PSDEACTIONNAME, 57);
        fieldIndexMap.put(FIELD_PSDEACTIONTEMPLID, 58);
        fieldIndexMap.put(FIELD_PSDEACTIONTEMPLNAME, 59);
        fieldIndexMap.put(FIELD_PSDEDATAFLOWID, 60);
        fieldIndexMap.put(FIELD_PSDEDATAFLOWNAME, 61);
        fieldIndexMap.put(FIELD_PSDEDATAQUERYID, 62);
        fieldIndexMap.put(FIELD_PSDEDATAQUERYNAME, 63);
        fieldIndexMap.put(FIELD_PSDEDATASETID, 64);
        fieldIndexMap.put(FIELD_PSDEDATASETNAME, 65);
        fieldIndexMap.put(FIELD_PSDEID, 66);
        fieldIndexMap.put(FIELD_PSDELOGICID, 67);
        fieldIndexMap.put(FIELD_PSDELOGICNAME, 68);
        fieldIndexMap.put(FIELD_PSDEMSACTIONSCNT, 69);
        fieldIndexMap.put(FIELD_PSDENAME, 70);
        fieldIndexMap.put(FIELD_PSDEOPPRIVID, 71);
        fieldIndexMap.put(FIELD_PSDEOPPRIVNAME, 72);
        fieldIndexMap.put(FIELD_PSDESYSPROCID, 73);
        fieldIndexMap.put(FIELD_PSDESYSPROCNAME, 74);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 75);
        fieldIndexMap.put(FIELD_PSSUBSYSSADEID, 76);
        fieldIndexMap.put(FIELD_PSSUBSYSSADETAILID, 77);
        fieldIndexMap.put(FIELD_PSSUBSYSSADETAILNAME, 78);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 79);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 80);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 81);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 82);
        fieldIndexMap.put(FIELD_PSSYSREQITEMID, 83);
        fieldIndexMap.put(FIELD_PSSYSREQITEMNAME, 84);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 85);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 86);
        fieldIndexMap.put(FIELD_PSSYSTASKID, 87);
        fieldIndexMap.put(FIELD_PSSYSTASKNAME, 88);
        fieldIndexMap.put(FIELD_PSSYSTESTCASESCNT, 89);
        fieldIndexMap.put(FIELD_PSSYSUNISTATEID, 90);
        fieldIndexMap.put(FIELD_PSSYSUNISTATENAME, 91);
        fieldIndexMap.put(FIELD_PUBMODE, 92);
        fieldIndexMap.put(FIELD_RAWSERVICEMETHOD, 93);
        fieldIndexMap.put(FIELD_RAWSERVICEURL, 94);
        fieldIndexMap.put(FIELD_REQUESTFIELD, 95);
        fieldIndexMap.put(FIELD_REQUESTMETHOD, 96);
        fieldIndexMap.put(FIELD_REQUESTPARAMTYPE, 97);
        fieldIndexMap.put(FIELD_REQUESTPATH, 98);
        fieldIndexMap.put(FIELD_RETSTDDATATYPE, 99);
        fieldIndexMap.put(FIELD_RETVALTYPE, 100);
        fieldIndexMap.put(FIELD_SERVICECODENAME, 101);
        fieldIndexMap.put(FIELD_SUBSYSSADETAILMODE, 102);
        fieldIndexMap.put(FIELD_SYNCEVENT, 103);
        fieldIndexMap.put(FIELD_TESTACTIONMODE, 104);
        fieldIndexMap.put(FIELD_TESTCASEFLAG, 105);
        fieldIndexMap.put(FIELD_TODOTASK, 106);
        fieldIndexMap.put(FIELD_TSMODE, 107);
        fieldIndexMap.put(FIELD_UPDATEDATE, 108);
        fieldIndexMap.put(FIELD_UPDATEMAN, 109);
        fieldIndexMap.put(FIELD_USERCAT, 110);
        fieldIndexMap.put(FIELD_USERPARAMS, 111);
        fieldIndexMap.put(FIELD_USERTAG, 112);
        fieldIndexMap.put(FIELD_USERTAG2, 113);
        fieldIndexMap.put(FIELD_USERTAG3, 114);
        fieldIndexMap.put(FIELD_USERTAG4, 115);
        fieldIndexMap.put(FIELD_VALIDFLAG, 116);
    }
}

