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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDSDQ;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDSParam;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataImp;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPriv;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESampleData;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDSDQService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDSParamService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataImpService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService;
import net.ibizsys.pscore.srv.dedesign.service.PSDERService;
import net.ibizsys.pscore.srv.dedesign.service.PSDESampleDataService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADetail;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTask;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniState;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUserDR;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADetailService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysTaskService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUniStateService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUserDRService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEDataSetBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEDataSetBase.class);
    public static final String FIELD_ACTIONHOLDER = "ACTIONHOLDER";
    public static final String FIELD_ADPSDELOGICID = "ADPSDELOGICID";
    public static final String FIELD_ADPSDELOGICNAME = "ADPSDELOGICNAME";
    public static final String FIELD_AFTERCODE = "AFTERCODE";
    public static final String FIELD_AGGDATAPSDERID = "AGGDATAPSDERID";
    public static final String FIELD_AGGDATAPSDERNAME = "AGGDATAPSDERNAME";
    public static final String FIELD_BEFORECODE = "BEFORECODE";
    public static final String FIELD_CACHECAT = "CACHECAT";
    public static final String FIELD_CACHECHECKSTATE = "CACHECHECKSTATE";
    public static final String FIELD_CACHESCOPE = "CACHESCOPE";
    public static final String FIELD_CACHESTATEPSDELOGICID = "CACHESTATEPSDELOGICID";
    public static final String FIELD_CACHESTATEPSDELOGICNAME = "CACHESTATEPSDELOGICNAME";
    public static final String FIELD_CACHETAG = "CACHETAG";
    public static final String FIELD_CACHETIMEOUT = "CACHETIMEOUT";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_CUSTOMMODE = "CUSTOMMODE";
    public static final String FIELD_DATASETPARAMS = "DATASETPARAMS";
    public static final String FIELD_DATASETSN = "DATASETSN";
    public static final String FIELD_DEFAULTMODE = "DEFAULTMODE";
    public static final String FIELD_DSOPTION = "DSOPTION";
    public static final String FIELD_DSTAG = "DSTAG";
    public static final String FIELD_DSTAG2 = "DSTAG2";
    public static final String FIELD_DSTAG3 = "DSTAG3";
    public static final String FIELD_DSTAG4 = "DSTAG4";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_ENABLEAUDIT = "ENABLEAUDIT";
    public static final String FIELD_ENABLECACHE = "ENABLECACHE";
    public static final String FIELD_ENABLEGROUP = "ENABLEGROUP";
    public static final String FIELD_ENABLEORGDR = "ENABLEORGDR";
    public static final String FIELD_ENABLESECBC = "ENABLESECBC";
    public static final String FIELD_ENABLESECDR = "ENABLESECDR";
    public static final String FIELD_ENABLETEMPDATA = "ENABLETEMPDATA";
    public static final String FIELD_ENABLEUSERDR = "ENABLEUSERDR";
    public static final String FIELD_EXTENDMODE = "EXTENDMODE";
    public static final String FIELD_FILTERMODEL = "FILTERMODEL";
    public static final String FIELD_FINISHFLAG = "FINISHFLAG";
    public static final String FIELD_INPSDEFGROUPID = "INPSDEFGROUPID";
    public static final String FIELD_INPSDEFGROUPNAME = "INPSDEFGROUPNAME";
    public static final String FIELD_INPSDESAMPLEDATAID = "INPSDESAMPLEDATAID";
    public static final String FIELD_INPSDESAMPLEDATANAME = "INPSDESAMPLEDATANAME";
    public static final String FIELD_INPSSYSDYNAMODELID = "INPSSYSDYNAMODELID";
    public static final String FIELD_INPSSYSDYNAMODELNAME = "INPSSYSDYNAMODELNAME";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MAJORPSDEFID = "MAJORPSDEFID";
    public static final String FIELD_MAJORPSDEFNAME = "MAJORPSDEFNAME";
    public static final String FIELD_MAJORSORTDIR = "MAJORSORTDIR";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MINORPSDEFID = "MINORPSDEFID";
    public static final String FIELD_MINORPSDEFNAME = "MINORPSDEFNAME";
    public static final String FIELD_MINORSORTDIR = "MINORSORTDIR";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_ORGDR = "ORGDR";
    public static final String FIELD_OUTPSDEFGROUPID = "OUTPSDEFGROUPID";
    public static final String FIELD_OUTPSDEFGROUPNAME = "OUTPSDEFGROUPNAME";
    public static final String FIELD_OUTPSDESAMPLEDATAID = "OUTPSDESAMPLEDATAID";
    public static final String FIELD_OUTPSDESAMPLEDATANAME = "OUTPSDESAMPLEDATANAME";
    public static final String FIELD_PAGESIZE = "PAGESIZE";
    public static final String FIELD_PARAMTYPE = "PARAMTYPE";
    public static final String FIELD_POTIME = "POTIME";
    public static final String FIELD_PREDEFINEDTYPEPARAM = "PREDEFINEDTYPEPARAM";
    public static final String FIELD_PREDEFINEDTYPETEXT = "PREDEFINEDTYPETEXT";
    public static final String FIELD_PREDEFINETYPE = "PREDEFINETYPE";
    public static final String FIELD_PSCODELISTID = "PSCODELISTID";
    public static final String FIELD_PSCODELISTNAME = "PSCODELISTNAME";
    public static final String FIELD_PSDEDATAIMPID = "PSDEDATAIMPID";
    public static final String FIELD_PSDEDATAIMPNAME = "PSDEDATAIMPNAME";
    public static final String FIELD_PSDEDATASETID = "PSDEDATASETID";
    public static final String FIELD_PSDEDATASETNAME = "PSDEDATASETNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDELOGICID = "PSDELOGICID";
    public static final String FIELD_PSDELOGICNAME = "PSDELOGICNAME";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDEOPPRIVID = "PSDEOPPRIVID";
    public static final String FIELD_PSDEOPPRIVNAME = "PSDEOPPRIVNAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSSUBSYSSADEID = "PSSUBSYSSADEID";
    public static final String FIELD_PSSUBSYSSADETAILID = "PSSUBSYSSADETAILID";
    public static final String FIELD_PSSUBSYSSADETAILNAME = "PSSUBSYSSADETAILNAME";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_PSSYSREQITEMID = "PSSYSREQITEMID";
    public static final String FIELD_PSSYSREQITEMNAME = "PSSYSREQITEMNAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_PSSYSTASKID = "PSSYSTASKID";
    public static final String FIELD_PSSYSTASKNAME = "PSSYSTASKNAME";
    public static final String FIELD_PSSYSUNISTATEID = "PSSYSUNISTATEID";
    public static final String FIELD_PSSYSUNISTATENAME = "PSSYSUNISTATENAME";
    public static final String FIELD_PSSYSUSERDRID = "PSSYSUSERDRID";
    public static final String FIELD_PSSYSUSERDRID2 = "PSSYSUSERDRID2";
    public static final String FIELD_PSSYSUSERDRNAME = "PSSYSUSERDRNAME";
    public static final String FIELD_PSSYSUSERDRNAME2 = "PSSYSUSERDRNAME2";
    public static final String FIELD_PUBMODE = "PUBMODE";
    public static final String FIELD_RAWSERVICEMETHOD = "RAWSERVICEMETHOD";
    public static final String FIELD_RAWSERVICEURL = "RAWSERVICEURL";
    public static final String FIELD_REQUESTMETHOD = "REQUESTMETHOD";
    public static final String FIELD_REQUESTPATH = "REQUESTPATH";
    public static final String FIELD_RETVALTYPE = "RETVALTYPE";
    public static final String FIELD_SECBC = "SECBC";
    public static final String FIELD_SECDR = "SECDR";
    public static final String FIELD_SERVICECODENAME = "SERVICECODENAME";
    public static final String FIELD_SUBSYSSADETAILMODE = "SUBSYSSADETAILMODE";
    public static final String FIELD_SYSUSERDR2PARAM = "SYSUSERDR2PARAM";
    public static final String FIELD_SYSUSERDRPARAM = "SYSUSERDRPARAM";
    public static final String FIELD_TODOTASK = "TODOTASK";
    public static final String FIELD_UNIONMODE = "UNIONMODE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_VIEWCOLLEVEL = "VIEWCOLLEVEL";
    private static final int INDEX_ACTIONHOLDER = 0;
    private static final int INDEX_ADPSDELOGICID = 1;
    private static final int INDEX_ADPSDELOGICNAME = 2;
    private static final int INDEX_AFTERCODE = 3;
    private static final int INDEX_AGGDATAPSDERID = 4;
    private static final int INDEX_AGGDATAPSDERNAME = 5;
    private static final int INDEX_BEFORECODE = 6;
    private static final int INDEX_CACHECAT = 7;
    private static final int INDEX_CACHECHECKSTATE = 8;
    private static final int INDEX_CACHESCOPE = 9;
    private static final int INDEX_CACHESTATEPSDELOGICID = 10;
    private static final int INDEX_CACHESTATEPSDELOGICNAME = 11;
    private static final int INDEX_CACHETAG = 12;
    private static final int INDEX_CACHETIMEOUT = 13;
    private static final int INDEX_CODENAME = 14;
    private static final int INDEX_CREATEDATE = 15;
    private static final int INDEX_CREATEMAN = 16;
    private static final int INDEX_CUSTOMCODE = 17;
    private static final int INDEX_CUSTOMMODE = 18;
    private static final int INDEX_DATASETPARAMS = 19;
    private static final int INDEX_DATASETSN = 20;
    private static final int INDEX_DEFAULTMODE = 21;
    private static final int INDEX_DSOPTION = 22;
    private static final int INDEX_DSTAG = 23;
    private static final int INDEX_DSTAG2 = 24;
    private static final int INDEX_DSTAG3 = 25;
    private static final int INDEX_DSTAG4 = 26;
    private static final int INDEX_DYNAMODELFLAG = 27;
    private static final int INDEX_ENABLEAUDIT = 28;
    private static final int INDEX_ENABLECACHE = 29;
    private static final int INDEX_ENABLEGROUP = 30;
    private static final int INDEX_ENABLEORGDR = 31;
    private static final int INDEX_ENABLESECBC = 32;
    private static final int INDEX_ENABLESECDR = 33;
    private static final int INDEX_ENABLETEMPDATA = 34;
    private static final int INDEX_ENABLEUSERDR = 35;
    private static final int INDEX_EXTENDMODE = 36;
    private static final int INDEX_FILTERMODEL = 37;
    private static final int INDEX_FINISHFLAG = 38;
    private static final int INDEX_INPSDEFGROUPID = 39;
    private static final int INDEX_INPSDEFGROUPNAME = 40;
    private static final int INDEX_INPSDESAMPLEDATAID = 41;
    private static final int INDEX_INPSDESAMPLEDATANAME = 42;
    private static final int INDEX_INPSSYSDYNAMODELID = 43;
    private static final int INDEX_INPSSYSDYNAMODELNAME = 44;
    private static final int INDEX_LOCKFLAG = 45;
    private static final int INDEX_LOGICNAME = 46;
    private static final int INDEX_MAJORPSDEFID = 47;
    private static final int INDEX_MAJORPSDEFNAME = 48;
    private static final int INDEX_MAJORSORTDIR = 49;
    private static final int INDEX_MEMO = 50;
    private static final int INDEX_MINORPSDEFID = 51;
    private static final int INDEX_MINORPSDEFNAME = 52;
    private static final int INDEX_MINORSORTDIR = 53;
    private static final int INDEX_ORDERVALUE = 54;
    private static final int INDEX_ORGDR = 55;
    private static final int INDEX_OUTPSDEFGROUPID = 56;
    private static final int INDEX_OUTPSDEFGROUPNAME = 57;
    private static final int INDEX_OUTPSDESAMPLEDATAID = 58;
    private static final int INDEX_OUTPSDESAMPLEDATANAME = 59;
    private static final int INDEX_PAGESIZE = 60;
    private static final int INDEX_PARAMTYPE = 61;
    private static final int INDEX_POTIME = 62;
    private static final int INDEX_PREDEFINEDTYPEPARAM = 63;
    private static final int INDEX_PREDEFINEDTYPETEXT = 64;
    private static final int INDEX_PREDEFINETYPE = 65;
    private static final int INDEX_PSCODELISTID = 66;
    private static final int INDEX_PSCODELISTNAME = 67;
    private static final int INDEX_PSDEDATAIMPID = 68;
    private static final int INDEX_PSDEDATAIMPNAME = 69;
    private static final int INDEX_PSDEDATASETID = 70;
    private static final int INDEX_PSDEDATASETNAME = 71;
    private static final int INDEX_PSDEID = 72;
    private static final int INDEX_PSDELOGICID = 73;
    private static final int INDEX_PSDELOGICNAME = 74;
    private static final int INDEX_PSDENAME = 75;
    private static final int INDEX_PSDEOPPRIVID = 76;
    private static final int INDEX_PSDEOPPRIVNAME = 77;
    private static final int INDEX_PSDYNAINSTID = 78;
    private static final int INDEX_PSSUBSYSSADEID = 79;
    private static final int INDEX_PSSUBSYSSADETAILID = 80;
    private static final int INDEX_PSSUBSYSSADETAILNAME = 81;
    private static final int INDEX_PSSYSPFPLUGINID = 82;
    private static final int INDEX_PSSYSPFPLUGINNAME = 83;
    private static final int INDEX_PSSYSREQITEMID = 84;
    private static final int INDEX_PSSYSREQITEMNAME = 85;
    private static final int INDEX_PSSYSSFPLUGINID = 86;
    private static final int INDEX_PSSYSSFPLUGINNAME = 87;
    private static final int INDEX_PSSYSTASKID = 88;
    private static final int INDEX_PSSYSTASKNAME = 89;
    private static final int INDEX_PSSYSUNISTATEID = 90;
    private static final int INDEX_PSSYSUNISTATENAME = 91;
    private static final int INDEX_PSSYSUSERDRID = 92;
    private static final int INDEX_PSSYSUSERDRID2 = 93;
    private static final int INDEX_PSSYSUSERDRNAME = 94;
    private static final int INDEX_PSSYSUSERDRNAME2 = 95;
    private static final int INDEX_PUBMODE = 96;
    private static final int INDEX_RAWSERVICEMETHOD = 97;
    private static final int INDEX_RAWSERVICEURL = 98;
    private static final int INDEX_REQUESTMETHOD = 99;
    private static final int INDEX_REQUESTPATH = 100;
    private static final int INDEX_RETVALTYPE = 101;
    private static final int INDEX_SECBC = 102;
    private static final int INDEX_SECDR = 103;
    private static final int INDEX_SERVICECODENAME = 104;
    private static final int INDEX_SUBSYSSADETAILMODE = 105;
    private static final int INDEX_SYSUSERDR2PARAM = 106;
    private static final int INDEX_SYSUSERDRPARAM = 107;
    private static final int INDEX_TODOTASK = 108;
    private static final int INDEX_UNIONMODE = 109;
    private static final int INDEX_UPDATEDATE = 110;
    private static final int INDEX_UPDATEMAN = 111;
    private static final int INDEX_USERCAT = 112;
    private static final int INDEX_USERPARAMS = 113;
    private static final int INDEX_USERTAG = 114;
    private static final int INDEX_USERTAG2 = 115;
    private static final int INDEX_USERTAG3 = 116;
    private static final int INDEX_USERTAG4 = 117;
    private static final int INDEX_VALIDFLAG = 118;
    private static final int INDEX_VIEWCOLLEVEL = 119;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEDataSetBase proxyPSDEDataSetBase = null;
    private boolean actionholderDirtyFlag = false;
    private boolean adpsdelogicidDirtyFlag = false;
    private boolean adpsdelogicnameDirtyFlag = false;
    private boolean aftercodeDirtyFlag = false;
    private boolean aggdatapsderidDirtyFlag = false;
    private boolean aggdatapsdernameDirtyFlag = false;
    private boolean beforecodeDirtyFlag = false;
    private boolean cachecatDirtyFlag = false;
    private boolean cachecheckstateDirtyFlag = false;
    private boolean cachescopeDirtyFlag = false;
    private boolean cachestatepsdelogicidDirtyFlag = false;
    private boolean cachestatepsdelogicnameDirtyFlag = false;
    private boolean cachetagDirtyFlag = false;
    private boolean cachetimeoutDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean custommodeDirtyFlag = false;
    private boolean datasetparamsDirtyFlag = false;
    private boolean datasetsnDirtyFlag = false;
    private boolean defaultmodeDirtyFlag = false;
    private boolean dsoptionDirtyFlag = false;
    private boolean dstagDirtyFlag = false;
    private boolean dstag2DirtyFlag = false;
    private boolean dstag3DirtyFlag = false;
    private boolean dstag4DirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean enableauditDirtyFlag = false;
    private boolean enablecacheDirtyFlag = false;
    private boolean enablegroupDirtyFlag = false;
    private boolean enableorgdrDirtyFlag = false;
    private boolean enablesecbcDirtyFlag = false;
    private boolean enablesecdrDirtyFlag = false;
    private boolean enabletempdataDirtyFlag = false;
    private boolean enableuserdrDirtyFlag = false;
    private boolean extendmodeDirtyFlag = false;
    private boolean filtermodelDirtyFlag = false;
    private boolean finishflagDirtyFlag = false;
    private boolean inpsdefgroupidDirtyFlag = false;
    private boolean inpsdefgroupnameDirtyFlag = false;
    private boolean inpsdesampledataidDirtyFlag = false;
    private boolean inpsdesampledatanameDirtyFlag = false;
    private boolean inpssysdynamodelidDirtyFlag = false;
    private boolean inpssysdynamodelnameDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean majorpsdefidDirtyFlag = false;
    private boolean majorpsdefnameDirtyFlag = false;
    private boolean majorsortdirDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean minorpsdefidDirtyFlag = false;
    private boolean minorpsdefnameDirtyFlag = false;
    private boolean minorsortdirDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean orgdrDirtyFlag = false;
    private boolean outpsdefgroupidDirtyFlag = false;
    private boolean outpsdefgroupnameDirtyFlag = false;
    private boolean outpsdesampledataidDirtyFlag = false;
    private boolean outpsdesampledatanameDirtyFlag = false;
    private boolean pagesizeDirtyFlag = false;
    private boolean paramtypeDirtyFlag = false;
    private boolean potimeDirtyFlag = false;
    private boolean predefinedtypeparamDirtyFlag = false;
    private boolean predefinedtypetextDirtyFlag = false;
    private boolean predefinetypeDirtyFlag = false;
    private boolean pscodelistidDirtyFlag = false;
    private boolean pscodelistnameDirtyFlag = false;
    private boolean psdedataimpidDirtyFlag = false;
    private boolean psdedataimpnameDirtyFlag = false;
    private boolean psdedatasetidDirtyFlag = false;
    private boolean psdedatasetnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdelogicidDirtyFlag = false;
    private boolean psdelogicnameDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdeopprividDirtyFlag = false;
    private boolean psdeopprivnameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pssubsyssadeidDirtyFlag = false;
    private boolean pssubsyssadetailidDirtyFlag = false;
    private boolean pssubsyssadetailnameDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean pssysreqitemidDirtyFlag = false;
    private boolean pssysreqitemnameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean pssystaskidDirtyFlag = false;
    private boolean pssystasknameDirtyFlag = false;
    private boolean pssysunistateidDirtyFlag = false;
    private boolean pssysunistatenameDirtyFlag = false;
    private boolean pssysuserdridDirtyFlag = false;
    private boolean pssysuserdrid2DirtyFlag = false;
    private boolean pssysuserdrnameDirtyFlag = false;
    private boolean pssysuserdrname2DirtyFlag = false;
    private boolean pubmodeDirtyFlag = false;
    private boolean rawservicemethodDirtyFlag = false;
    private boolean rawserviceurlDirtyFlag = false;
    private boolean requestmethodDirtyFlag = false;
    private boolean requestpathDirtyFlag = false;
    private boolean retvaltypeDirtyFlag = false;
    private boolean secbcDirtyFlag = false;
    private boolean secdrDirtyFlag = false;
    private boolean servicecodenameDirtyFlag = false;
    private boolean subsyssadetailmodeDirtyFlag = false;
    private boolean sysuserdr2paramDirtyFlag = false;
    private boolean sysuserdrparamDirtyFlag = false;
    private boolean todotaskDirtyFlag = false;
    private boolean unionmodeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean viewcollevelDirtyFlag = false;
    @Column(name="actionholder")
    private Integer actionholder;
    @Column(name="adpsdelogicid")
    private String adpsdelogicid;
    @Column(name="adpsdelogicname")
    private String adpsdelogicname;
    @Column(name="aftercode")
    private String aftercode;
    @Column(name="aggdatapsderid")
    private String aggdatapsderid;
    @Column(name="aggdatapsdername")
    private String aggdatapsdername;
    @Column(name="beforecode")
    private String beforecode;
    @Column(name="cachecat")
    private String cachecat;
    @Column(name="cachecheckstate")
    private String cachecheckstate;
    @Column(name="cachescope")
    private String cachescope;
    @Column(name="cachestatepsdelogicid")
    private String cachestatepsdelogicid;
    @Column(name="cachestatepsdelogicname")
    private String cachestatepsdelogicname;
    @Column(name="cachetag")
    private String cachetag;
    @Column(name="cachetimeout")
    private Integer cachetimeout;
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
    @Column(name="datasetparams")
    private String datasetparams;
    @Column(name="datasetsn")
    private String datasetsn;
    @Column(name="defaultmode")
    private Integer defaultmode;
    @Column(name="dsoption")
    private Integer dsoption;
    @Column(name="dstag")
    private String dstag;
    @Column(name="dstag2")
    private String dstag2;
    @Column(name="dstag3")
    private String dstag3;
    @Column(name="dstag4")
    private String dstag4;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="enableaudit")
    private Integer enableaudit;
    @Column(name="enablecache")
    private Integer enablecache;
    @Column(name="enablegroup")
    private Integer enablegroup;
    @Column(name="enableorgdr")
    private Integer enableorgdr;
    @Column(name="enablesecbc")
    private Integer enablesecbc;
    @Column(name="enablesecdr")
    private Integer enablesecdr;
    @Column(name="enabletempdata")
    private Integer enabletempdata;
    @Column(name="enableuserdr")
    private Integer enableuserdr;
    @Column(name="extendmode")
    private Integer extendmode;
    @Column(name="filtermodel")
    private String filtermodel;
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
    @Column(name="majorpsdefid")
    private String majorpsdefid;
    @Column(name="majorpsdefname")
    private String majorpsdefname;
    @Column(name="majorsortdir")
    private String majorsortdir;
    @Column(name="memo")
    private String memo;
    @Column(name="minorpsdefid")
    private String minorpsdefid;
    @Column(name="minorpsdefname")
    private String minorpsdefname;
    @Column(name="minorsortdir")
    private String minorsortdir;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="orgdr")
    private Integer orgdr;
    @Column(name="outpsdefgroupid")
    private String outpsdefgroupid;
    @Column(name="outpsdefgroupname")
    private String outpsdefgroupname;
    @Column(name="outpsdesampledataid")
    private String outpsdesampledataid;
    @Column(name="outpsdesampledataname")
    private String outpsdesampledataname;
    @Column(name="pagesize")
    private Integer pagesize;
    @Column(name="paramtype")
    private Integer paramtype;
    @Column(name="potime")
    private Integer potime;
    @Column(name="predefinedtypeparam")
    private String predefinedtypeparam;
    @Column(name="predefinedtypetext")
    private String predefinedtypetext;
    @Column(name="predefinetype")
    private String predefinetype;
    @Column(name="pscodelistid")
    private String pscodelistid;
    @Column(name="pscodelistname")
    private String pscodelistname;
    @Column(name="psdedataimpid")
    private String psdedataimpid;
    @Column(name="psdedataimpname")
    private String psdedataimpname;
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
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdeopprivid")
    private String psdeopprivid;
    @Column(name="psdeopprivname")
    private String psdeopprivname;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="pssubsyssadeid")
    private String pssubsyssadeid;
    @Column(name="pssubsyssadetailid")
    private String pssubsyssadetailid;
    @Column(name="pssubsyssadetailname")
    private String pssubsyssadetailname;
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
    @Column(name="pubmode")
    private Integer pubmode;
    @Column(name="rawservicemethod")
    private String rawservicemethod;
    @Column(name="rawserviceurl")
    private String rawserviceurl;
    @Column(name="requestmethod")
    private String requestmethod;
    @Column(name="requestpath")
    private String requestpath;
    @Column(name="retvaltype")
    private String retvaltype;
    @Column(name="secbc")
    private String secbc;
    @Column(name="secdr")
    private Integer secdr;
    @Column(name="servicecodename")
    private String servicecodename;
    @Column(name="subsyssadetailmode")
    private Integer subsyssadetailmode;
    @Column(name="sysuserdr2param")
    private String sysuserdr2param;
    @Column(name="sysuserdrparam")
    private String sysuserdrparam;
    @Column(name="todotask")
    private String todotask;
    @Column(name="unionmode")
    private String unionmode;
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
    @Column(name="viewcollevel")
    private Integer viewcollevel;
    private Integer objPSCodeListLock = new Integer(1);
    private PSCodeList pscodelist = null;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSDEDataImpLock = new Integer(1);
    private PSDEDataImp psdedataimp = null;
    private Integer objInPSDEFGroupLock = new Integer(1);
    private PSDEFGroup inpsdefgroup = null;
    private Integer objOutPSDEFGroupLock = new Integer(1);
    private PSDEFGroup outpsdefgroup = null;
    private Integer objMajorPSDEFLock = new Integer(1);
    private PSDEField majorpsdef = null;
    private Integer objMinorPSDEFLock = new Integer(1);
    private PSDEField minorpsdef = null;
    private Integer objADPSDELogicLock = new Integer(1);
    private PSDELogic adpsdelogic = null;
    private Integer objCacheStatePSDELogicLock = new Integer(1);
    private PSDELogic cachestatepsdelogic = null;
    private Integer objPSDELogicLock = new Integer(1);
    private PSDELogic psdelogic = null;
    private Integer objPSDEOPPrivLock = new Integer(1);
    private PSDEOPPriv psdeoppriv = null;
    private Integer objAggDataPSDERLock = new Integer(1);
    private PSDER aggdatapsder = null;
    private Integer objInPSDESampleDataLock = new Integer(1);
    private PSDESampleData inpsdesampledata = null;
    private Integer objOutPSDESampleDataLock = new Integer(1);
    private PSDESampleData outpsdesampledata = null;
    private Integer objPSSubSysSADetailLock = new Integer(1);
    private PSSubSysSADetail pssubsyssadetail = null;
    private Integer objInPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel inpssysdynamodel = null;
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
    private Integer objPSSysUserDRLock = new Integer(1);
    private PSSysUserDR pssysuserdr = null;
    private Integer objPSSysUserDR2Lock = new Integer(1);
    private PSSysUserDR pssysuserdr2 = null;
    private Integer objPSDEDSDQsLock = new Integer(1);
    private ArrayList<PSDEDSDQ> psdedsdqs = null;
    private Integer objPSDEDSParamsLock = new Integer(1);
    private ArrayList<PSDEDSParam> psdedsparams = null;

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

    public void setAggDataPSDERId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAggDataPSDERId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.aggdatapsderid = string;
        this.aggdatapsderidDirtyFlag = true;
    }

    public String getAggDataPSDERId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAggDataPSDERId();
        }
        return this.aggdatapsderid;
    }

    public boolean isAggDataPSDERIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAggDataPSDERIdDirty();
        }
        return this.aggdatapsderidDirtyFlag;
    }

    public void resetAggDataPSDERId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAggDataPSDERId();
            return;
        }
        this.aggdatapsderidDirtyFlag = false;
        this.aggdatapsderid = null;
    }

    public void setAggDataPSDERName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAggDataPSDERName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.aggdatapsdername = string;
        this.aggdatapsdernameDirtyFlag = true;
    }

    public String getAggDataPSDERName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAggDataPSDERName();
        }
        return this.aggdatapsdername;
    }

    public boolean isAggDataPSDERNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAggDataPSDERNameDirty();
        }
        return this.aggdatapsdernameDirtyFlag;
    }

    public void resetAggDataPSDERName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAggDataPSDERName();
            return;
        }
        this.aggdatapsdernameDirtyFlag = false;
        this.aggdatapsdername = null;
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

    public void setCacheCheckState(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCacheCheckState(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cachecheckstate = string;
        this.cachecheckstateDirtyFlag = true;
    }

    public String getCacheCheckState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCacheCheckState();
        }
        return this.cachecheckstate;
    }

    public boolean isCacheCheckStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCacheCheckStateDirty();
        }
        return this.cachecheckstateDirtyFlag;
    }

    public void resetCacheCheckState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCacheCheckState();
            return;
        }
        this.cachecheckstateDirtyFlag = false;
        this.cachecheckstate = null;
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

    public void setCacheStatePSDELogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCacheStatePSDELogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cachestatepsdelogicid = string;
        this.cachestatepsdelogicidDirtyFlag = true;
    }

    public String getCacheStatePSDELogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCacheStatePSDELogicId();
        }
        return this.cachestatepsdelogicid;
    }

    public boolean isCacheStatePSDELogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCacheStatePSDELogicIdDirty();
        }
        return this.cachestatepsdelogicidDirtyFlag;
    }

    public void resetCacheStatePSDELogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCacheStatePSDELogicId();
            return;
        }
        this.cachestatepsdelogicidDirtyFlag = false;
        this.cachestatepsdelogicid = null;
    }

    public void setCacheStatePSDELogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCacheStatePSDELogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cachestatepsdelogicname = string;
        this.cachestatepsdelogicnameDirtyFlag = true;
    }

    public String getCacheStatePSDELogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCacheStatePSDELogicName();
        }
        return this.cachestatepsdelogicname;
    }

    public boolean isCacheStatePSDELogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCacheStatePSDELogicNameDirty();
        }
        return this.cachestatepsdelogicnameDirtyFlag;
    }

    public void resetCacheStatePSDELogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCacheStatePSDELogicName();
            return;
        }
        this.cachestatepsdelogicnameDirtyFlag = false;
        this.cachestatepsdelogicname = null;
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

    public void setDataSetParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataSetParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.datasetparams = string;
        this.datasetparamsDirtyFlag = true;
    }

    public String getDataSetParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataSetParams();
        }
        return this.datasetparams;
    }

    public boolean isDataSetParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataSetParamsDirty();
        }
        return this.datasetparamsDirtyFlag;
    }

    public void resetDataSetParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataSetParams();
            return;
        }
        this.datasetparamsDirtyFlag = false;
        this.datasetparams = null;
    }

    public void setDataSetSN(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataSetSN(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.datasetsn = string;
        this.datasetsnDirtyFlag = true;
    }

    public String getDataSetSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataSetSN();
        }
        return this.datasetsn;
    }

    public boolean isDataSetSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataSetSNDirty();
        }
        return this.datasetsnDirtyFlag;
    }

    public void resetDataSetSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataSetSN();
            return;
        }
        this.datasetsnDirtyFlag = false;
        this.datasetsn = null;
    }

    public void setDefaultMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultMode(n);
            return;
        }
        this.defaultmode = n;
        this.defaultmodeDirtyFlag = true;
    }

    public Integer getDefaultMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultMode();
        }
        return this.defaultmode;
    }

    public boolean isDefaultModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultModeDirty();
        }
        return this.defaultmodeDirtyFlag;
    }

    public void resetDefaultMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultMode();
            return;
        }
        this.defaultmodeDirtyFlag = false;
        this.defaultmode = null;
    }

    public void setDSOption(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDSOption(n);
            return;
        }
        this.dsoption = n;
        this.dsoptionDirtyFlag = true;
    }

    public Integer getDSOption() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDSOption();
        }
        return this.dsoption;
    }

    public boolean isDSOptionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDSOptionDirty();
        }
        return this.dsoptionDirtyFlag;
    }

    public void resetDSOption() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDSOption();
            return;
        }
        this.dsoptionDirtyFlag = false;
        this.dsoption = null;
    }

    public void setDSTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDSTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstag = string;
        this.dstagDirtyFlag = true;
    }

    public String getDSTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDSTag();
        }
        return this.dstag;
    }

    public boolean isDSTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDSTagDirty();
        }
        return this.dstagDirtyFlag;
    }

    public void resetDSTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDSTag();
            return;
        }
        this.dstagDirtyFlag = false;
        this.dstag = null;
    }

    public void setDSTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDSTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstag2 = string;
        this.dstag2DirtyFlag = true;
    }

    public String getDSTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDSTag2();
        }
        return this.dstag2;
    }

    public boolean isDSTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDSTag2Dirty();
        }
        return this.dstag2DirtyFlag;
    }

    public void resetDSTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDSTag2();
            return;
        }
        this.dstag2DirtyFlag = false;
        this.dstag2 = null;
    }

    public void setDSTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDSTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstag3 = string;
        this.dstag3DirtyFlag = true;
    }

    public String getDSTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDSTag3();
        }
        return this.dstag3;
    }

    public boolean isDSTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDSTag3Dirty();
        }
        return this.dstag3DirtyFlag;
    }

    public void resetDSTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDSTag3();
            return;
        }
        this.dstag3DirtyFlag = false;
        this.dstag3 = null;
    }

    public void setDSTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDSTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstag4 = string;
        this.dstag4DirtyFlag = true;
    }

    public String getDSTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDSTag4();
        }
        return this.dstag4;
    }

    public boolean isDSTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDSTag4Dirty();
        }
        return this.dstag4DirtyFlag;
    }

    public void resetDSTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDSTag4();
            return;
        }
        this.dstag4DirtyFlag = false;
        this.dstag4 = null;
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

    public void setEnableGroup(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableGroup(n);
            return;
        }
        this.enablegroup = n;
        this.enablegroupDirtyFlag = true;
    }

    public Integer getEnableGroup() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableGroup();
        }
        return this.enablegroup;
    }

    public boolean isEnableGroupDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableGroupDirty();
        }
        return this.enablegroupDirtyFlag;
    }

    public void resetEnableGroup() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableGroup();
            return;
        }
        this.enablegroupDirtyFlag = false;
        this.enablegroup = null;
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

    public void setEnableTempData(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableTempData(n);
            return;
        }
        this.enabletempdata = n;
        this.enabletempdataDirtyFlag = true;
    }

    public Integer getEnableTempData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableTempData();
        }
        return this.enabletempdata;
    }

    public boolean isEnableTempDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableTempDataDirty();
        }
        return this.enabletempdataDirtyFlag;
    }

    public void resetEnableTempData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableTempData();
            return;
        }
        this.enabletempdataDirtyFlag = false;
        this.enabletempdata = null;
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

    public void setFilterModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFilterModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.filtermodel = string;
        this.filtermodelDirtyFlag = true;
    }

    public String getFilterModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFilterModel();
        }
        return this.filtermodel;
    }

    public boolean isFilterModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFilterModelDirty();
        }
        return this.filtermodelDirtyFlag;
    }

    public void resetFilterModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFilterModel();
            return;
        }
        this.filtermodelDirtyFlag = false;
        this.filtermodel = null;
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

    public void setMajorPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMajorPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.majorpsdefid = string;
        this.majorpsdefidDirtyFlag = true;
    }

    public String getMajorPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorPSDEFId();
        }
        return this.majorpsdefid;
    }

    public boolean isMajorPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMajorPSDEFIdDirty();
        }
        return this.majorpsdefidDirtyFlag;
    }

    public void resetMajorPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMajorPSDEFId();
            return;
        }
        this.majorpsdefidDirtyFlag = false;
        this.majorpsdefid = null;
    }

    public void setMajorPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMajorPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.majorpsdefname = string;
        this.majorpsdefnameDirtyFlag = true;
    }

    public String getMajorPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorPSDEFName();
        }
        return this.majorpsdefname;
    }

    public boolean isMajorPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMajorPSDEFNameDirty();
        }
        return this.majorpsdefnameDirtyFlag;
    }

    public void resetMajorPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMajorPSDEFName();
            return;
        }
        this.majorpsdefnameDirtyFlag = false;
        this.majorpsdefname = null;
    }

    public void setMajorSortDir(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMajorSortDir(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.majorsortdir = string;
        this.majorsortdirDirtyFlag = true;
    }

    public String getMajorSortDir() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorSortDir();
        }
        return this.majorsortdir;
    }

    public boolean isMajorSortDirDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMajorSortDirDirty();
        }
        return this.majorsortdirDirtyFlag;
    }

    public void resetMajorSortDir() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMajorSortDir();
            return;
        }
        this.majorsortdirDirtyFlag = false;
        this.majorsortdir = null;
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

    public void setMinorPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinorPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.minorpsdefid = string;
        this.minorpsdefidDirtyFlag = true;
    }

    public String getMinorPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorPSDEFId();
        }
        return this.minorpsdefid;
    }

    public boolean isMinorPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinorPSDEFIdDirty();
        }
        return this.minorpsdefidDirtyFlag;
    }

    public void resetMinorPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinorPSDEFId();
            return;
        }
        this.minorpsdefidDirtyFlag = false;
        this.minorpsdefid = null;
    }

    public void setMinorPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinorPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.minorpsdefname = string;
        this.minorpsdefnameDirtyFlag = true;
    }

    public String getMinorPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorPSDEFName();
        }
        return this.minorpsdefname;
    }

    public boolean isMinorPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinorPSDEFNameDirty();
        }
        return this.minorpsdefnameDirtyFlag;
    }

    public void resetMinorPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinorPSDEFName();
            return;
        }
        this.minorpsdefnameDirtyFlag = false;
        this.minorpsdefname = null;
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

    public void setPageSize(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPageSize(n);
            return;
        }
        this.pagesize = n;
        this.pagesizeDirtyFlag = true;
    }

    public Integer getPageSize() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPageSize();
        }
        return this.pagesize;
    }

    public boolean isPageSizeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPageSizeDirty();
        }
        return this.pagesizeDirtyFlag;
    }

    public void resetPageSize() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPageSize();
            return;
        }
        this.pagesizeDirtyFlag = false;
        this.pagesize = null;
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

    public void setPredefineType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPredefineType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.predefinetype = string;
        this.predefinetypeDirtyFlag = true;
    }

    public String getPredefineType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPredefineType();
        }
        return this.predefinetype;
    }

    public boolean isPredefineTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPredefineTypeDirty();
        }
        return this.predefinetypeDirtyFlag;
    }

    public void resetPredefineType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPredefineType();
            return;
        }
        this.predefinetypeDirtyFlag = false;
        this.predefinetype = null;
    }

    public void setPSCodeListId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCodeListId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscodelistid = string;
        this.pscodelistidDirtyFlag = true;
    }

    public String getPSCodeListId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeListId();
        }
        return this.pscodelistid;
    }

    public boolean isPSCodeListIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCodeListIdDirty();
        }
        return this.pscodelistidDirtyFlag;
    }

    public void resetPSCodeListId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCodeListId();
            return;
        }
        this.pscodelistidDirtyFlag = false;
        this.pscodelistid = null;
    }

    public void setPSCodeListName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCodeListName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscodelistname = string;
        this.pscodelistnameDirtyFlag = true;
    }

    public String getPSCodeListName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeListName();
        }
        return this.pscodelistname;
    }

    public boolean isPSCodeListNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCodeListNameDirty();
        }
        return this.pscodelistnameDirtyFlag;
    }

    public void resetPSCodeListName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCodeListName();
            return;
        }
        this.pscodelistnameDirtyFlag = false;
        this.pscodelistname = null;
    }

    public void setPSDEDataImpId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataImpId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedataimpid = string;
        this.psdedataimpidDirtyFlag = true;
    }

    public String getPSDEDataImpId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataImpId();
        }
        return this.psdedataimpid;
    }

    public boolean isPSDEDataImpIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataImpIdDirty();
        }
        return this.psdedataimpidDirtyFlag;
    }

    public void resetPSDEDataImpId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataImpId();
            return;
        }
        this.psdedataimpidDirtyFlag = false;
        this.psdedataimpid = null;
    }

    public void setPSDEDataImpName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataImpName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedataimpname = string;
        this.psdedataimpnameDirtyFlag = true;
    }

    public String getPSDEDataImpName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataImpName();
        }
        return this.psdedataimpname;
    }

    public boolean isPSDEDataImpNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataImpNameDirty();
        }
        return this.psdedataimpnameDirtyFlag;
    }

    public void resetPSDEDataImpName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataImpName();
            return;
        }
        this.psdedataimpnameDirtyFlag = false;
        this.psdedataimpname = null;
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

    public void setUnionMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUnionMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.unionmode = string;
        this.unionmodeDirtyFlag = true;
    }

    public String getUnionMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUnionMode();
        }
        return this.unionmode;
    }

    public boolean isUnionModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUnionModeDirty();
        }
        return this.unionmodeDirtyFlag;
    }

    public void resetUnionMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUnionMode();
            return;
        }
        this.unionmodeDirtyFlag = false;
        this.unionmode = null;
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

    public void setViewColLevel(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewColLevel(n);
            return;
        }
        this.viewcollevel = n;
        this.viewcollevelDirtyFlag = true;
    }

    public Integer getViewColLevel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewColLevel();
        }
        return this.viewcollevel;
    }

    public boolean isViewColLevelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewColLevelDirty();
        }
        return this.viewcollevelDirtyFlag;
    }

    public void resetViewColLevel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewColLevel();
            return;
        }
        this.viewcollevelDirtyFlag = false;
        this.viewcollevel = null;
    }

    protected void onReset() {
        PSDEDataSetBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEDataSetBase pSDEDataSetBase) {
        pSDEDataSetBase.resetActionHolder();
        pSDEDataSetBase.resetADPSDELogicId();
        pSDEDataSetBase.resetADPSDELogicName();
        pSDEDataSetBase.resetAfterCode();
        pSDEDataSetBase.resetAggDataPSDERId();
        pSDEDataSetBase.resetAggDataPSDERName();
        pSDEDataSetBase.resetBeforeCode();
        pSDEDataSetBase.resetCacheCat();
        pSDEDataSetBase.resetCacheCheckState();
        pSDEDataSetBase.resetCacheScope();
        pSDEDataSetBase.resetCacheStatePSDELogicId();
        pSDEDataSetBase.resetCacheStatePSDELogicName();
        pSDEDataSetBase.resetCacheTag();
        pSDEDataSetBase.resetCacheTimeout();
        pSDEDataSetBase.resetCodeName();
        pSDEDataSetBase.resetCreateDate();
        pSDEDataSetBase.resetCreateMan();
        pSDEDataSetBase.resetCustomCode();
        pSDEDataSetBase.resetCustomMode();
        pSDEDataSetBase.resetDataSetParams();
        pSDEDataSetBase.resetDataSetSN();
        pSDEDataSetBase.resetDefaultMode();
        pSDEDataSetBase.resetDSOption();
        pSDEDataSetBase.resetDSTag();
        pSDEDataSetBase.resetDSTag2();
        pSDEDataSetBase.resetDSTag3();
        pSDEDataSetBase.resetDSTag4();
        pSDEDataSetBase.resetDynaModelFlag();
        pSDEDataSetBase.resetEnableAudit();
        pSDEDataSetBase.resetEnableCache();
        pSDEDataSetBase.resetEnableGroup();
        pSDEDataSetBase.resetEnableOrgDR();
        pSDEDataSetBase.resetEnableSecBC();
        pSDEDataSetBase.resetEnableSecDR();
        pSDEDataSetBase.resetEnableTempData();
        pSDEDataSetBase.resetEnableUserDR();
        pSDEDataSetBase.resetExtendMode();
        pSDEDataSetBase.resetFilterModel();
        pSDEDataSetBase.resetFinishFlag();
        pSDEDataSetBase.resetInPSDEFGroupId();
        pSDEDataSetBase.resetInPSDEFGroupName();
        pSDEDataSetBase.resetInPSDESampleDataId();
        pSDEDataSetBase.resetInPSDESampleDataName();
        pSDEDataSetBase.resetInPSSysDynaModelId();
        pSDEDataSetBase.resetInPSSysDynaModelName();
        pSDEDataSetBase.resetLockFlag();
        pSDEDataSetBase.resetLogicName();
        pSDEDataSetBase.resetMajorPSDEFId();
        pSDEDataSetBase.resetMajorPSDEFName();
        pSDEDataSetBase.resetMajorSortDir();
        pSDEDataSetBase.resetMemo();
        pSDEDataSetBase.resetMinorPSDEFId();
        pSDEDataSetBase.resetMinorPSDEFName();
        pSDEDataSetBase.resetMinorSortDir();
        pSDEDataSetBase.resetOrderValue();
        pSDEDataSetBase.resetOrgDR();
        pSDEDataSetBase.resetOutPSDEFGroupId();
        pSDEDataSetBase.resetOutPSDEFGroupName();
        pSDEDataSetBase.resetOutPSDESampleDataId();
        pSDEDataSetBase.resetOutPSDESampleDataName();
        pSDEDataSetBase.resetPageSize();
        pSDEDataSetBase.resetParamType();
        pSDEDataSetBase.resetPOTime();
        pSDEDataSetBase.resetPredefinedTypeParam();
        pSDEDataSetBase.resetPredefinedTypeText();
        pSDEDataSetBase.resetPredefineType();
        pSDEDataSetBase.resetPSCodeListId();
        pSDEDataSetBase.resetPSCodeListName();
        pSDEDataSetBase.resetPSDEDataImpId();
        pSDEDataSetBase.resetPSDEDataImpName();
        pSDEDataSetBase.resetPSDEDataSetId();
        pSDEDataSetBase.resetPSDEDataSetName();
        pSDEDataSetBase.resetPSDEId();
        pSDEDataSetBase.resetPSDELogicId();
        pSDEDataSetBase.resetPSDELogicName();
        pSDEDataSetBase.resetPSDEName();
        pSDEDataSetBase.resetPSDEOPPrivId();
        pSDEDataSetBase.resetPSDEOPPrivName();
        pSDEDataSetBase.resetPSDynaInstId();
        pSDEDataSetBase.resetPSSubSysSADEId();
        pSDEDataSetBase.resetPSSubSysSADetailId();
        pSDEDataSetBase.resetPSSubSysSADetailName();
        pSDEDataSetBase.resetPSSysPFPluginId();
        pSDEDataSetBase.resetPSSysPFPluginName();
        pSDEDataSetBase.resetPSSysReqItemId();
        pSDEDataSetBase.resetPSSysReqItemName();
        pSDEDataSetBase.resetPSSysSFPluginId();
        pSDEDataSetBase.resetPSSysSFPluginName();
        pSDEDataSetBase.resetPSSysTaskId();
        pSDEDataSetBase.resetPSSysTaskName();
        pSDEDataSetBase.resetPSSysUniStateId();
        pSDEDataSetBase.resetPSSysUniStateName();
        pSDEDataSetBase.resetPSSysUserDRId();
        pSDEDataSetBase.resetPSSysUserDRId2();
        pSDEDataSetBase.resetPSSysUserDRName();
        pSDEDataSetBase.resetPSSysUserDRName2();
        pSDEDataSetBase.resetPubMode();
        pSDEDataSetBase.resetRawServiceMethod();
        pSDEDataSetBase.resetRawServiceUrl();
        pSDEDataSetBase.resetRequestMethod();
        pSDEDataSetBase.resetRequestPath();
        pSDEDataSetBase.resetRetValType();
        pSDEDataSetBase.resetSecBC();
        pSDEDataSetBase.resetSecDR();
        pSDEDataSetBase.resetServiceCodeName();
        pSDEDataSetBase.resetSubSysSADetailMode();
        pSDEDataSetBase.resetSysUserDR2Param();
        pSDEDataSetBase.resetSysUserDRParam();
        pSDEDataSetBase.resetToDoTask();
        pSDEDataSetBase.resetUnionMode();
        pSDEDataSetBase.resetUpdateDate();
        pSDEDataSetBase.resetUpdateMan();
        pSDEDataSetBase.resetUserCat();
        pSDEDataSetBase.resetUserParams();
        pSDEDataSetBase.resetUserTag();
        pSDEDataSetBase.resetUserTag2();
        pSDEDataSetBase.resetUserTag3();
        pSDEDataSetBase.resetUserTag4();
        pSDEDataSetBase.resetValidFlag();
        pSDEDataSetBase.resetViewColLevel();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isActionHolderDirty()) {
            hashMap.put(FIELD_ACTIONHOLDER, this.getActionHolder());
        }
        if (!bl || this.isADPSDELogicIdDirty()) {
            hashMap.put(FIELD_ADPSDELOGICID, this.getADPSDELogicId());
        }
        if (!bl || this.isADPSDELogicNameDirty()) {
            hashMap.put(FIELD_ADPSDELOGICNAME, this.getADPSDELogicName());
        }
        if (!bl || this.isAfterCodeDirty()) {
            hashMap.put(FIELD_AFTERCODE, this.getAfterCode());
        }
        if (!bl || this.isAggDataPSDERIdDirty()) {
            hashMap.put(FIELD_AGGDATAPSDERID, this.getAggDataPSDERId());
        }
        if (!bl || this.isAggDataPSDERNameDirty()) {
            hashMap.put(FIELD_AGGDATAPSDERNAME, this.getAggDataPSDERName());
        }
        if (!bl || this.isBeforeCodeDirty()) {
            hashMap.put(FIELD_BEFORECODE, this.getBeforeCode());
        }
        if (!bl || this.isCacheCatDirty()) {
            hashMap.put(FIELD_CACHECAT, this.getCacheCat());
        }
        if (!bl || this.isCacheCheckStateDirty()) {
            hashMap.put(FIELD_CACHECHECKSTATE, this.getCacheCheckState());
        }
        if (!bl || this.isCacheScopeDirty()) {
            hashMap.put(FIELD_CACHESCOPE, this.getCacheScope());
        }
        if (!bl || this.isCacheStatePSDELogicIdDirty()) {
            hashMap.put(FIELD_CACHESTATEPSDELOGICID, this.getCacheStatePSDELogicId());
        }
        if (!bl || this.isCacheStatePSDELogicNameDirty()) {
            hashMap.put(FIELD_CACHESTATEPSDELOGICNAME, this.getCacheStatePSDELogicName());
        }
        if (!bl || this.isCacheTagDirty()) {
            hashMap.put(FIELD_CACHETAG, this.getCacheTag());
        }
        if (!bl || this.isCacheTimeoutDirty()) {
            hashMap.put(FIELD_CACHETIMEOUT, this.getCacheTimeout());
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
        if (!bl || this.isDataSetParamsDirty()) {
            hashMap.put(FIELD_DATASETPARAMS, this.getDataSetParams());
        }
        if (!bl || this.isDataSetSNDirty()) {
            hashMap.put(FIELD_DATASETSN, this.getDataSetSN());
        }
        if (!bl || this.isDefaultModeDirty()) {
            hashMap.put(FIELD_DEFAULTMODE, this.getDefaultMode());
        }
        if (!bl || this.isDSOptionDirty()) {
            hashMap.put(FIELD_DSOPTION, this.getDSOption());
        }
        if (!bl || this.isDSTagDirty()) {
            hashMap.put(FIELD_DSTAG, this.getDSTag());
        }
        if (!bl || this.isDSTag2Dirty()) {
            hashMap.put(FIELD_DSTAG2, this.getDSTag2());
        }
        if (!bl || this.isDSTag3Dirty()) {
            hashMap.put(FIELD_DSTAG3, this.getDSTag3());
        }
        if (!bl || this.isDSTag4Dirty()) {
            hashMap.put(FIELD_DSTAG4, this.getDSTag4());
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
        if (!bl || this.isEnableGroupDirty()) {
            hashMap.put(FIELD_ENABLEGROUP, this.getEnableGroup());
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
        if (!bl || this.isEnableTempDataDirty()) {
            hashMap.put(FIELD_ENABLETEMPDATA, this.getEnableTempData());
        }
        if (!bl || this.isEnableUserDRDirty()) {
            hashMap.put(FIELD_ENABLEUSERDR, this.getEnableUserDR());
        }
        if (!bl || this.isExtendModeDirty()) {
            hashMap.put(FIELD_EXTENDMODE, this.getExtendMode());
        }
        if (!bl || this.isFilterModelDirty()) {
            hashMap.put(FIELD_FILTERMODEL, this.getFilterModel());
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
        if (!bl || this.isMajorPSDEFIdDirty()) {
            hashMap.put(FIELD_MAJORPSDEFID, this.getMajorPSDEFId());
        }
        if (!bl || this.isMajorPSDEFNameDirty()) {
            hashMap.put(FIELD_MAJORPSDEFNAME, this.getMajorPSDEFName());
        }
        if (!bl || this.isMajorSortDirDirty()) {
            hashMap.put(FIELD_MAJORSORTDIR, this.getMajorSortDir());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMinorPSDEFIdDirty()) {
            hashMap.put(FIELD_MINORPSDEFID, this.getMinorPSDEFId());
        }
        if (!bl || this.isMinorPSDEFNameDirty()) {
            hashMap.put(FIELD_MINORPSDEFNAME, this.getMinorPSDEFName());
        }
        if (!bl || this.isMinorSortDirDirty()) {
            hashMap.put(FIELD_MINORSORTDIR, this.getMinorSortDir());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isOrgDRDirty()) {
            hashMap.put(FIELD_ORGDR, this.getOrgDR());
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
        if (!bl || this.isPageSizeDirty()) {
            hashMap.put(FIELD_PAGESIZE, this.getPageSize());
        }
        if (!bl || this.isParamTypeDirty()) {
            hashMap.put(FIELD_PARAMTYPE, this.getParamType());
        }
        if (!bl || this.isPOTimeDirty()) {
            hashMap.put(FIELD_POTIME, this.getPOTime());
        }
        if (!bl || this.isPredefinedTypeParamDirty()) {
            hashMap.put(FIELD_PREDEFINEDTYPEPARAM, this.getPredefinedTypeParam());
        }
        if (!bl || this.isPredefinedTypeTextDirty()) {
            hashMap.put(FIELD_PREDEFINEDTYPETEXT, this.getPredefinedTypeText());
        }
        if (!bl || this.isPredefineTypeDirty()) {
            hashMap.put(FIELD_PREDEFINETYPE, this.getPredefineType());
        }
        if (!bl || this.isPSCodeListIdDirty()) {
            hashMap.put(FIELD_PSCODELISTID, this.getPSCodeListId());
        }
        if (!bl || this.isPSCodeListNameDirty()) {
            hashMap.put(FIELD_PSCODELISTNAME, this.getPSCodeListName());
        }
        if (!bl || this.isPSDEDataImpIdDirty()) {
            hashMap.put(FIELD_PSDEDATAIMPID, this.getPSDEDataImpId());
        }
        if (!bl || this.isPSDEDataImpNameDirty()) {
            hashMap.put(FIELD_PSDEDATAIMPNAME, this.getPSDEDataImpName());
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
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDEOPPrivIdDirty()) {
            hashMap.put(FIELD_PSDEOPPRIVID, this.getPSDEOPPrivId());
        }
        if (!bl || this.isPSDEOPPrivNameDirty()) {
            hashMap.put(FIELD_PSDEOPPRIVNAME, this.getPSDEOPPrivName());
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
        if (!bl || this.isPubModeDirty()) {
            hashMap.put(FIELD_PUBMODE, this.getPubMode());
        }
        if (!bl || this.isRawServiceMethodDirty()) {
            hashMap.put(FIELD_RAWSERVICEMETHOD, this.getRawServiceMethod());
        }
        if (!bl || this.isRawServiceUrlDirty()) {
            hashMap.put(FIELD_RAWSERVICEURL, this.getRawServiceUrl());
        }
        if (!bl || this.isRequestMethodDirty()) {
            hashMap.put(FIELD_REQUESTMETHOD, this.getRequestMethod());
        }
        if (!bl || this.isRequestPathDirty()) {
            hashMap.put(FIELD_REQUESTPATH, this.getRequestPath());
        }
        if (!bl || this.isRetValTypeDirty()) {
            hashMap.put(FIELD_RETVALTYPE, this.getRetValType());
        }
        if (!bl || this.isSecBCDirty()) {
            hashMap.put(FIELD_SECBC, this.getSecBC());
        }
        if (!bl || this.isSecDRDirty()) {
            hashMap.put(FIELD_SECDR, this.getSecDR());
        }
        if (!bl || this.isServiceCodeNameDirty()) {
            hashMap.put(FIELD_SERVICECODENAME, this.getServiceCodeName());
        }
        if (!bl || this.isSubSysSADetailModeDirty()) {
            hashMap.put(FIELD_SUBSYSSADETAILMODE, this.getSubSysSADetailMode());
        }
        if (!bl || this.isSysUserDR2ParamDirty()) {
            hashMap.put(FIELD_SYSUSERDR2PARAM, this.getSysUserDR2Param());
        }
        if (!bl || this.isSysUserDRParamDirty()) {
            hashMap.put(FIELD_SYSUSERDRPARAM, this.getSysUserDRParam());
        }
        if (!bl || this.isToDoTaskDirty()) {
            hashMap.put(FIELD_TODOTASK, this.getToDoTask());
        }
        if (!bl || this.isUnionModeDirty()) {
            hashMap.put(FIELD_UNIONMODE, this.getUnionMode());
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
        if (!bl || this.isViewColLevelDirty()) {
            hashMap.put(FIELD_VIEWCOLLEVEL, this.getViewColLevel());
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
        return PSDEDataSetBase.get(this, n);
    }

    private static Object get(PSDEDataSetBase pSDEDataSetBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDataSetBase.getActionHolder();
            }
            case 1: {
                return pSDEDataSetBase.getADPSDELogicId();
            }
            case 2: {
                return pSDEDataSetBase.getADPSDELogicName();
            }
            case 3: {
                return pSDEDataSetBase.getAfterCode();
            }
            case 4: {
                return pSDEDataSetBase.getAggDataPSDERId();
            }
            case 5: {
                return pSDEDataSetBase.getAggDataPSDERName();
            }
            case 6: {
                return pSDEDataSetBase.getBeforeCode();
            }
            case 7: {
                return pSDEDataSetBase.getCacheCat();
            }
            case 8: {
                return pSDEDataSetBase.getCacheCheckState();
            }
            case 9: {
                return pSDEDataSetBase.getCacheScope();
            }
            case 10: {
                return pSDEDataSetBase.getCacheStatePSDELogicId();
            }
            case 11: {
                return pSDEDataSetBase.getCacheStatePSDELogicName();
            }
            case 12: {
                return pSDEDataSetBase.getCacheTag();
            }
            case 13: {
                return pSDEDataSetBase.getCacheTimeout();
            }
            case 14: {
                return pSDEDataSetBase.getCodeName();
            }
            case 15: {
                return pSDEDataSetBase.getCreateDate();
            }
            case 16: {
                return pSDEDataSetBase.getCreateMan();
            }
            case 17: {
                return pSDEDataSetBase.getCustomCode();
            }
            case 18: {
                return pSDEDataSetBase.getCustomMode();
            }
            case 19: {
                return pSDEDataSetBase.getDataSetParams();
            }
            case 20: {
                return pSDEDataSetBase.getDataSetSN();
            }
            case 21: {
                return pSDEDataSetBase.getDefaultMode();
            }
            case 22: {
                return pSDEDataSetBase.getDSOption();
            }
            case 23: {
                return pSDEDataSetBase.getDSTag();
            }
            case 24: {
                return pSDEDataSetBase.getDSTag2();
            }
            case 25: {
                return pSDEDataSetBase.getDSTag3();
            }
            case 26: {
                return pSDEDataSetBase.getDSTag4();
            }
            case 27: {
                return pSDEDataSetBase.getDynaModelFlag();
            }
            case 28: {
                return pSDEDataSetBase.getEnableAudit();
            }
            case 29: {
                return pSDEDataSetBase.getEnableCache();
            }
            case 30: {
                return pSDEDataSetBase.getEnableGroup();
            }
            case 31: {
                return pSDEDataSetBase.getEnableOrgDR();
            }
            case 32: {
                return pSDEDataSetBase.getEnableSecBC();
            }
            case 33: {
                return pSDEDataSetBase.getEnableSecDR();
            }
            case 34: {
                return pSDEDataSetBase.getEnableTempData();
            }
            case 35: {
                return pSDEDataSetBase.getEnableUserDR();
            }
            case 36: {
                return pSDEDataSetBase.getExtendMode();
            }
            case 37: {
                return pSDEDataSetBase.getFilterModel();
            }
            case 38: {
                return pSDEDataSetBase.getFinishFlag();
            }
            case 39: {
                return pSDEDataSetBase.getInPSDEFGroupId();
            }
            case 40: {
                return pSDEDataSetBase.getInPSDEFGroupName();
            }
            case 41: {
                return pSDEDataSetBase.getInPSDESampleDataId();
            }
            case 42: {
                return pSDEDataSetBase.getInPSDESampleDataName();
            }
            case 43: {
                return pSDEDataSetBase.getInPSSysDynaModelId();
            }
            case 44: {
                return pSDEDataSetBase.getInPSSysDynaModelName();
            }
            case 45: {
                return pSDEDataSetBase.getLockFlag();
            }
            case 46: {
                return pSDEDataSetBase.getLogicName();
            }
            case 47: {
                return pSDEDataSetBase.getMajorPSDEFId();
            }
            case 48: {
                return pSDEDataSetBase.getMajorPSDEFName();
            }
            case 49: {
                return pSDEDataSetBase.getMajorSortDir();
            }
            case 50: {
                return pSDEDataSetBase.getMemo();
            }
            case 51: {
                return pSDEDataSetBase.getMinorPSDEFId();
            }
            case 52: {
                return pSDEDataSetBase.getMinorPSDEFName();
            }
            case 53: {
                return pSDEDataSetBase.getMinorSortDir();
            }
            case 54: {
                return pSDEDataSetBase.getOrderValue();
            }
            case 55: {
                return pSDEDataSetBase.getOrgDR();
            }
            case 56: {
                return pSDEDataSetBase.getOutPSDEFGroupId();
            }
            case 57: {
                return pSDEDataSetBase.getOutPSDEFGroupName();
            }
            case 58: {
                return pSDEDataSetBase.getOutPSDESampleDataId();
            }
            case 59: {
                return pSDEDataSetBase.getOutPSDESampleDataName();
            }
            case 60: {
                return pSDEDataSetBase.getPageSize();
            }
            case 61: {
                return pSDEDataSetBase.getParamType();
            }
            case 62: {
                return pSDEDataSetBase.getPOTime();
            }
            case 63: {
                return pSDEDataSetBase.getPredefinedTypeParam();
            }
            case 64: {
                return pSDEDataSetBase.getPredefinedTypeText();
            }
            case 65: {
                return pSDEDataSetBase.getPredefineType();
            }
            case 66: {
                return pSDEDataSetBase.getPSCodeListId();
            }
            case 67: {
                return pSDEDataSetBase.getPSCodeListName();
            }
            case 68: {
                return pSDEDataSetBase.getPSDEDataImpId();
            }
            case 69: {
                return pSDEDataSetBase.getPSDEDataImpName();
            }
            case 70: {
                return pSDEDataSetBase.getPSDEDataSetId();
            }
            case 71: {
                return pSDEDataSetBase.getPSDEDataSetName();
            }
            case 72: {
                return pSDEDataSetBase.getPSDEId();
            }
            case 73: {
                return pSDEDataSetBase.getPSDELogicId();
            }
            case 74: {
                return pSDEDataSetBase.getPSDELogicName();
            }
            case 75: {
                return pSDEDataSetBase.getPSDEName();
            }
            case 76: {
                return pSDEDataSetBase.getPSDEOPPrivId();
            }
            case 77: {
                return pSDEDataSetBase.getPSDEOPPrivName();
            }
            case 78: {
                return pSDEDataSetBase.getPSDynaInstId();
            }
            case 79: {
                return pSDEDataSetBase.getPSSubSysSADEId();
            }
            case 80: {
                return pSDEDataSetBase.getPSSubSysSADetailId();
            }
            case 81: {
                return pSDEDataSetBase.getPSSubSysSADetailName();
            }
            case 82: {
                return pSDEDataSetBase.getPSSysPFPluginId();
            }
            case 83: {
                return pSDEDataSetBase.getPSSysPFPluginName();
            }
            case 84: {
                return pSDEDataSetBase.getPSSysReqItemId();
            }
            case 85: {
                return pSDEDataSetBase.getPSSysReqItemName();
            }
            case 86: {
                return pSDEDataSetBase.getPSSysSFPluginId();
            }
            case 87: {
                return pSDEDataSetBase.getPSSysSFPluginName();
            }
            case 88: {
                return pSDEDataSetBase.getPSSysTaskId();
            }
            case 89: {
                return pSDEDataSetBase.getPSSysTaskName();
            }
            case 90: {
                return pSDEDataSetBase.getPSSysUniStateId();
            }
            case 91: {
                return pSDEDataSetBase.getPSSysUniStateName();
            }
            case 92: {
                return pSDEDataSetBase.getPSSysUserDRId();
            }
            case 93: {
                return pSDEDataSetBase.getPSSysUserDRId2();
            }
            case 94: {
                return pSDEDataSetBase.getPSSysUserDRName();
            }
            case 95: {
                return pSDEDataSetBase.getPSSysUserDRName2();
            }
            case 96: {
                return pSDEDataSetBase.getPubMode();
            }
            case 97: {
                return pSDEDataSetBase.getRawServiceMethod();
            }
            case 98: {
                return pSDEDataSetBase.getRawServiceUrl();
            }
            case 99: {
                return pSDEDataSetBase.getRequestMethod();
            }
            case 100: {
                return pSDEDataSetBase.getRequestPath();
            }
            case 101: {
                return pSDEDataSetBase.getRetValType();
            }
            case 102: {
                return pSDEDataSetBase.getSecBC();
            }
            case 103: {
                return pSDEDataSetBase.getSecDR();
            }
            case 104: {
                return pSDEDataSetBase.getServiceCodeName();
            }
            case 105: {
                return pSDEDataSetBase.getSubSysSADetailMode();
            }
            case 106: {
                return pSDEDataSetBase.getSysUserDR2Param();
            }
            case 107: {
                return pSDEDataSetBase.getSysUserDRParam();
            }
            case 108: {
                return pSDEDataSetBase.getToDoTask();
            }
            case 109: {
                return pSDEDataSetBase.getUnionMode();
            }
            case 110: {
                return pSDEDataSetBase.getUpdateDate();
            }
            case 111: {
                return pSDEDataSetBase.getUpdateMan();
            }
            case 112: {
                return pSDEDataSetBase.getUserCat();
            }
            case 113: {
                return pSDEDataSetBase.getUserParams();
            }
            case 114: {
                return pSDEDataSetBase.getUserTag();
            }
            case 115: {
                return pSDEDataSetBase.getUserTag2();
            }
            case 116: {
                return pSDEDataSetBase.getUserTag3();
            }
            case 117: {
                return pSDEDataSetBase.getUserTag4();
            }
            case 118: {
                return pSDEDataSetBase.getValidFlag();
            }
            case 119: {
                return pSDEDataSetBase.getViewColLevel();
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
        PSDEDataSetBase.set(this, n, object);
    }

    private static void set(PSDEDataSetBase pSDEDataSetBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEDataSetBase.setActionHolder(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDEDataSetBase.setADPSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEDataSetBase.setADPSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEDataSetBase.setAfterCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEDataSetBase.setAggDataPSDERId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEDataSetBase.setAggDataPSDERName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEDataSetBase.setBeforeCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEDataSetBase.setCacheCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEDataSetBase.setCacheCheckState(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEDataSetBase.setCacheScope(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEDataSetBase.setCacheStatePSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEDataSetBase.setCacheStatePSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEDataSetBase.setCacheTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEDataSetBase.setCacheTimeout(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSDEDataSetBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEDataSetBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 16: {
                pSDEDataSetBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEDataSetBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEDataSetBase.setCustomMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSDEDataSetBase.setDataSetParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEDataSetBase.setDataSetSN(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEDataSetBase.setDefaultMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 22: {
                pSDEDataSetBase.setDSOption(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 23: {
                pSDEDataSetBase.setDSTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEDataSetBase.setDSTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEDataSetBase.setDSTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEDataSetBase.setDSTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDEDataSetBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 28: {
                pSDEDataSetBase.setEnableAudit(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 29: {
                pSDEDataSetBase.setEnableCache(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 30: {
                pSDEDataSetBase.setEnableGroup(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 31: {
                pSDEDataSetBase.setEnableOrgDR(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 32: {
                pSDEDataSetBase.setEnableSecBC(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 33: {
                pSDEDataSetBase.setEnableSecDR(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 34: {
                pSDEDataSetBase.setEnableTempData(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 35: {
                pSDEDataSetBase.setEnableUserDR(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 36: {
                pSDEDataSetBase.setExtendMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 37: {
                pSDEDataSetBase.setFilterModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDEDataSetBase.setFinishFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 39: {
                pSDEDataSetBase.setInPSDEFGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDEDataSetBase.setInPSDEFGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDEDataSetBase.setInPSDESampleDataId(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDEDataSetBase.setInPSDESampleDataName(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSDEDataSetBase.setInPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSDEDataSetBase.setInPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSDEDataSetBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 46: {
                pSDEDataSetBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSDEDataSetBase.setMajorPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSDEDataSetBase.setMajorPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSDEDataSetBase.setMajorSortDir(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSDEDataSetBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSDEDataSetBase.setMinorPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSDEDataSetBase.setMinorPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSDEDataSetBase.setMinorSortDir(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSDEDataSetBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 55: {
                pSDEDataSetBase.setOrgDR(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 56: {
                pSDEDataSetBase.setOutPSDEFGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSDEDataSetBase.setOutPSDEFGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 58: {
                pSDEDataSetBase.setOutPSDESampleDataId(DataObject.getStringValue((Object)object));
                return;
            }
            case 59: {
                pSDEDataSetBase.setOutPSDESampleDataName(DataObject.getStringValue((Object)object));
                return;
            }
            case 60: {
                pSDEDataSetBase.setPageSize(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 61: {
                pSDEDataSetBase.setParamType(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 62: {
                pSDEDataSetBase.setPOTime(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 63: {
                pSDEDataSetBase.setPredefinedTypeParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 64: {
                pSDEDataSetBase.setPredefinedTypeText(DataObject.getStringValue((Object)object));
                return;
            }
            case 65: {
                pSDEDataSetBase.setPredefineType(DataObject.getStringValue((Object)object));
                return;
            }
            case 66: {
                pSDEDataSetBase.setPSCodeListId(DataObject.getStringValue((Object)object));
                return;
            }
            case 67: {
                pSDEDataSetBase.setPSCodeListName(DataObject.getStringValue((Object)object));
                return;
            }
            case 68: {
                pSDEDataSetBase.setPSDEDataImpId(DataObject.getStringValue((Object)object));
                return;
            }
            case 69: {
                pSDEDataSetBase.setPSDEDataImpName(DataObject.getStringValue((Object)object));
                return;
            }
            case 70: {
                pSDEDataSetBase.setPSDEDataSetId(DataObject.getStringValue((Object)object));
                return;
            }
            case 71: {
                pSDEDataSetBase.setPSDEDataSetName(DataObject.getStringValue((Object)object));
                return;
            }
            case 72: {
                pSDEDataSetBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 73: {
                pSDEDataSetBase.setPSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 74: {
                pSDEDataSetBase.setPSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 75: {
                pSDEDataSetBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 76: {
                pSDEDataSetBase.setPSDEOPPrivId(DataObject.getStringValue((Object)object));
                return;
            }
            case 77: {
                pSDEDataSetBase.setPSDEOPPrivName(DataObject.getStringValue((Object)object));
                return;
            }
            case 78: {
                pSDEDataSetBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 79: {
                pSDEDataSetBase.setPSSubSysSADEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 80: {
                pSDEDataSetBase.setPSSubSysSADetailId(DataObject.getStringValue((Object)object));
                return;
            }
            case 81: {
                pSDEDataSetBase.setPSSubSysSADetailName(DataObject.getStringValue((Object)object));
                return;
            }
            case 82: {
                pSDEDataSetBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 83: {
                pSDEDataSetBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 84: {
                pSDEDataSetBase.setPSSysReqItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 85: {
                pSDEDataSetBase.setPSSysReqItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 86: {
                pSDEDataSetBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 87: {
                pSDEDataSetBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 88: {
                pSDEDataSetBase.setPSSysTaskId(DataObject.getStringValue((Object)object));
                return;
            }
            case 89: {
                pSDEDataSetBase.setPSSysTaskName(DataObject.getStringValue((Object)object));
                return;
            }
            case 90: {
                pSDEDataSetBase.setPSSysUniStateId(DataObject.getStringValue((Object)object));
                return;
            }
            case 91: {
                pSDEDataSetBase.setPSSysUniStateName(DataObject.getStringValue((Object)object));
                return;
            }
            case 92: {
                pSDEDataSetBase.setPSSysUserDRId(DataObject.getStringValue((Object)object));
                return;
            }
            case 93: {
                pSDEDataSetBase.setPSSysUserDRId2(DataObject.getStringValue((Object)object));
                return;
            }
            case 94: {
                pSDEDataSetBase.setPSSysUserDRName(DataObject.getStringValue((Object)object));
                return;
            }
            case 95: {
                pSDEDataSetBase.setPSSysUserDRName2(DataObject.getStringValue((Object)object));
                return;
            }
            case 96: {
                pSDEDataSetBase.setPubMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 97: {
                pSDEDataSetBase.setRawServiceMethod(DataObject.getStringValue((Object)object));
                return;
            }
            case 98: {
                pSDEDataSetBase.setRawServiceUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 99: {
                pSDEDataSetBase.setRequestMethod(DataObject.getStringValue((Object)object));
                return;
            }
            case 100: {
                pSDEDataSetBase.setRequestPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 101: {
                pSDEDataSetBase.setRetValType(DataObject.getStringValue((Object)object));
                return;
            }
            case 102: {
                pSDEDataSetBase.setSecBC(DataObject.getStringValue((Object)object));
                return;
            }
            case 103: {
                pSDEDataSetBase.setSecDR(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 104: {
                pSDEDataSetBase.setServiceCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 105: {
                pSDEDataSetBase.setSubSysSADetailMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 106: {
                pSDEDataSetBase.setSysUserDR2Param(DataObject.getStringValue((Object)object));
                return;
            }
            case 107: {
                pSDEDataSetBase.setSysUserDRParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 108: {
                pSDEDataSetBase.setToDoTask(DataObject.getStringValue((Object)object));
                return;
            }
            case 109: {
                pSDEDataSetBase.setUnionMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 110: {
                pSDEDataSetBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 111: {
                pSDEDataSetBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 112: {
                pSDEDataSetBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 113: {
                pSDEDataSetBase.setUserParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 114: {
                pSDEDataSetBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 115: {
                pSDEDataSetBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 116: {
                pSDEDataSetBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 117: {
                pSDEDataSetBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 118: {
                pSDEDataSetBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 119: {
                pSDEDataSetBase.setViewColLevel(DataObject.getIntegerValue((Object)object));
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
        return PSDEDataSetBase.isNull(this, n);
    }

    private static boolean isNull(PSDEDataSetBase pSDEDataSetBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDataSetBase.getActionHolder() == null;
            }
            case 1: {
                return pSDEDataSetBase.getADPSDELogicId() == null;
            }
            case 2: {
                return pSDEDataSetBase.getADPSDELogicName() == null;
            }
            case 3: {
                return pSDEDataSetBase.getAfterCode() == null;
            }
            case 4: {
                return pSDEDataSetBase.getAggDataPSDERId() == null;
            }
            case 5: {
                return pSDEDataSetBase.getAggDataPSDERName() == null;
            }
            case 6: {
                return pSDEDataSetBase.getBeforeCode() == null;
            }
            case 7: {
                return pSDEDataSetBase.getCacheCat() == null;
            }
            case 8: {
                return pSDEDataSetBase.getCacheCheckState() == null;
            }
            case 9: {
                return pSDEDataSetBase.getCacheScope() == null;
            }
            case 10: {
                return pSDEDataSetBase.getCacheStatePSDELogicId() == null;
            }
            case 11: {
                return pSDEDataSetBase.getCacheStatePSDELogicName() == null;
            }
            case 12: {
                return pSDEDataSetBase.getCacheTag() == null;
            }
            case 13: {
                return pSDEDataSetBase.getCacheTimeout() == null;
            }
            case 14: {
                return pSDEDataSetBase.getCodeName() == null;
            }
            case 15: {
                return pSDEDataSetBase.getCreateDate() == null;
            }
            case 16: {
                return pSDEDataSetBase.getCreateMan() == null;
            }
            case 17: {
                return pSDEDataSetBase.getCustomCode() == null;
            }
            case 18: {
                return pSDEDataSetBase.getCustomMode() == null;
            }
            case 19: {
                return pSDEDataSetBase.getDataSetParams() == null;
            }
            case 20: {
                return pSDEDataSetBase.getDataSetSN() == null;
            }
            case 21: {
                return pSDEDataSetBase.getDefaultMode() == null;
            }
            case 22: {
                return pSDEDataSetBase.getDSOption() == null;
            }
            case 23: {
                return pSDEDataSetBase.getDSTag() == null;
            }
            case 24: {
                return pSDEDataSetBase.getDSTag2() == null;
            }
            case 25: {
                return pSDEDataSetBase.getDSTag3() == null;
            }
            case 26: {
                return pSDEDataSetBase.getDSTag4() == null;
            }
            case 27: {
                return pSDEDataSetBase.getDynaModelFlag() == null;
            }
            case 28: {
                return pSDEDataSetBase.getEnableAudit() == null;
            }
            case 29: {
                return pSDEDataSetBase.getEnableCache() == null;
            }
            case 30: {
                return pSDEDataSetBase.getEnableGroup() == null;
            }
            case 31: {
                return pSDEDataSetBase.getEnableOrgDR() == null;
            }
            case 32: {
                return pSDEDataSetBase.getEnableSecBC() == null;
            }
            case 33: {
                return pSDEDataSetBase.getEnableSecDR() == null;
            }
            case 34: {
                return pSDEDataSetBase.getEnableTempData() == null;
            }
            case 35: {
                return pSDEDataSetBase.getEnableUserDR() == null;
            }
            case 36: {
                return pSDEDataSetBase.getExtendMode() == null;
            }
            case 37: {
                return pSDEDataSetBase.getFilterModel() == null;
            }
            case 38: {
                return pSDEDataSetBase.getFinishFlag() == null;
            }
            case 39: {
                return pSDEDataSetBase.getInPSDEFGroupId() == null;
            }
            case 40: {
                return pSDEDataSetBase.getInPSDEFGroupName() == null;
            }
            case 41: {
                return pSDEDataSetBase.getInPSDESampleDataId() == null;
            }
            case 42: {
                return pSDEDataSetBase.getInPSDESampleDataName() == null;
            }
            case 43: {
                return pSDEDataSetBase.getInPSSysDynaModelId() == null;
            }
            case 44: {
                return pSDEDataSetBase.getInPSSysDynaModelName() == null;
            }
            case 45: {
                return pSDEDataSetBase.getLockFlag() == null;
            }
            case 46: {
                return pSDEDataSetBase.getLogicName() == null;
            }
            case 47: {
                return pSDEDataSetBase.getMajorPSDEFId() == null;
            }
            case 48: {
                return pSDEDataSetBase.getMajorPSDEFName() == null;
            }
            case 49: {
                return pSDEDataSetBase.getMajorSortDir() == null;
            }
            case 50: {
                return pSDEDataSetBase.getMemo() == null;
            }
            case 51: {
                return pSDEDataSetBase.getMinorPSDEFId() == null;
            }
            case 52: {
                return pSDEDataSetBase.getMinorPSDEFName() == null;
            }
            case 53: {
                return pSDEDataSetBase.getMinorSortDir() == null;
            }
            case 54: {
                return pSDEDataSetBase.getOrderValue() == null;
            }
            case 55: {
                return pSDEDataSetBase.getOrgDR() == null;
            }
            case 56: {
                return pSDEDataSetBase.getOutPSDEFGroupId() == null;
            }
            case 57: {
                return pSDEDataSetBase.getOutPSDEFGroupName() == null;
            }
            case 58: {
                return pSDEDataSetBase.getOutPSDESampleDataId() == null;
            }
            case 59: {
                return pSDEDataSetBase.getOutPSDESampleDataName() == null;
            }
            case 60: {
                return pSDEDataSetBase.getPageSize() == null;
            }
            case 61: {
                return pSDEDataSetBase.getParamType() == null;
            }
            case 62: {
                return pSDEDataSetBase.getPOTime() == null;
            }
            case 63: {
                return pSDEDataSetBase.getPredefinedTypeParam() == null;
            }
            case 64: {
                return pSDEDataSetBase.getPredefinedTypeText() == null;
            }
            case 65: {
                return pSDEDataSetBase.getPredefineType() == null;
            }
            case 66: {
                return pSDEDataSetBase.getPSCodeListId() == null;
            }
            case 67: {
                return pSDEDataSetBase.getPSCodeListName() == null;
            }
            case 68: {
                return pSDEDataSetBase.getPSDEDataImpId() == null;
            }
            case 69: {
                return pSDEDataSetBase.getPSDEDataImpName() == null;
            }
            case 70: {
                return pSDEDataSetBase.getPSDEDataSetId() == null;
            }
            case 71: {
                return pSDEDataSetBase.getPSDEDataSetName() == null;
            }
            case 72: {
                return pSDEDataSetBase.getPSDEId() == null;
            }
            case 73: {
                return pSDEDataSetBase.getPSDELogicId() == null;
            }
            case 74: {
                return pSDEDataSetBase.getPSDELogicName() == null;
            }
            case 75: {
                return pSDEDataSetBase.getPSDEName() == null;
            }
            case 76: {
                return pSDEDataSetBase.getPSDEOPPrivId() == null;
            }
            case 77: {
                return pSDEDataSetBase.getPSDEOPPrivName() == null;
            }
            case 78: {
                return pSDEDataSetBase.getPSDynaInstId() == null;
            }
            case 79: {
                return pSDEDataSetBase.getPSSubSysSADEId() == null;
            }
            case 80: {
                return pSDEDataSetBase.getPSSubSysSADetailId() == null;
            }
            case 81: {
                return pSDEDataSetBase.getPSSubSysSADetailName() == null;
            }
            case 82: {
                return pSDEDataSetBase.getPSSysPFPluginId() == null;
            }
            case 83: {
                return pSDEDataSetBase.getPSSysPFPluginName() == null;
            }
            case 84: {
                return pSDEDataSetBase.getPSSysReqItemId() == null;
            }
            case 85: {
                return pSDEDataSetBase.getPSSysReqItemName() == null;
            }
            case 86: {
                return pSDEDataSetBase.getPSSysSFPluginId() == null;
            }
            case 87: {
                return pSDEDataSetBase.getPSSysSFPluginName() == null;
            }
            case 88: {
                return pSDEDataSetBase.getPSSysTaskId() == null;
            }
            case 89: {
                return pSDEDataSetBase.getPSSysTaskName() == null;
            }
            case 90: {
                return pSDEDataSetBase.getPSSysUniStateId() == null;
            }
            case 91: {
                return pSDEDataSetBase.getPSSysUniStateName() == null;
            }
            case 92: {
                return pSDEDataSetBase.getPSSysUserDRId() == null;
            }
            case 93: {
                return pSDEDataSetBase.getPSSysUserDRId2() == null;
            }
            case 94: {
                return pSDEDataSetBase.getPSSysUserDRName() == null;
            }
            case 95: {
                return pSDEDataSetBase.getPSSysUserDRName2() == null;
            }
            case 96: {
                return pSDEDataSetBase.getPubMode() == null;
            }
            case 97: {
                return pSDEDataSetBase.getRawServiceMethod() == null;
            }
            case 98: {
                return pSDEDataSetBase.getRawServiceUrl() == null;
            }
            case 99: {
                return pSDEDataSetBase.getRequestMethod() == null;
            }
            case 100: {
                return pSDEDataSetBase.getRequestPath() == null;
            }
            case 101: {
                return pSDEDataSetBase.getRetValType() == null;
            }
            case 102: {
                return pSDEDataSetBase.getSecBC() == null;
            }
            case 103: {
                return pSDEDataSetBase.getSecDR() == null;
            }
            case 104: {
                return pSDEDataSetBase.getServiceCodeName() == null;
            }
            case 105: {
                return pSDEDataSetBase.getSubSysSADetailMode() == null;
            }
            case 106: {
                return pSDEDataSetBase.getSysUserDR2Param() == null;
            }
            case 107: {
                return pSDEDataSetBase.getSysUserDRParam() == null;
            }
            case 108: {
                return pSDEDataSetBase.getToDoTask() == null;
            }
            case 109: {
                return pSDEDataSetBase.getUnionMode() == null;
            }
            case 110: {
                return pSDEDataSetBase.getUpdateDate() == null;
            }
            case 111: {
                return pSDEDataSetBase.getUpdateMan() == null;
            }
            case 112: {
                return pSDEDataSetBase.getUserCat() == null;
            }
            case 113: {
                return pSDEDataSetBase.getUserParams() == null;
            }
            case 114: {
                return pSDEDataSetBase.getUserTag() == null;
            }
            case 115: {
                return pSDEDataSetBase.getUserTag2() == null;
            }
            case 116: {
                return pSDEDataSetBase.getUserTag3() == null;
            }
            case 117: {
                return pSDEDataSetBase.getUserTag4() == null;
            }
            case 118: {
                return pSDEDataSetBase.getValidFlag() == null;
            }
            case 119: {
                return pSDEDataSetBase.getViewColLevel() == null;
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
        return PSDEDataSetBase.contains(this, n);
    }

    private static boolean contains(PSDEDataSetBase pSDEDataSetBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDataSetBase.isActionHolderDirty();
            }
            case 1: {
                return pSDEDataSetBase.isADPSDELogicIdDirty();
            }
            case 2: {
                return pSDEDataSetBase.isADPSDELogicNameDirty();
            }
            case 3: {
                return pSDEDataSetBase.isAfterCodeDirty();
            }
            case 4: {
                return pSDEDataSetBase.isAggDataPSDERIdDirty();
            }
            case 5: {
                return pSDEDataSetBase.isAggDataPSDERNameDirty();
            }
            case 6: {
                return pSDEDataSetBase.isBeforeCodeDirty();
            }
            case 7: {
                return pSDEDataSetBase.isCacheCatDirty();
            }
            case 8: {
                return pSDEDataSetBase.isCacheCheckStateDirty();
            }
            case 9: {
                return pSDEDataSetBase.isCacheScopeDirty();
            }
            case 10: {
                return pSDEDataSetBase.isCacheStatePSDELogicIdDirty();
            }
            case 11: {
                return pSDEDataSetBase.isCacheStatePSDELogicNameDirty();
            }
            case 12: {
                return pSDEDataSetBase.isCacheTagDirty();
            }
            case 13: {
                return pSDEDataSetBase.isCacheTimeoutDirty();
            }
            case 14: {
                return pSDEDataSetBase.isCodeNameDirty();
            }
            case 15: {
                return pSDEDataSetBase.isCreateDateDirty();
            }
            case 16: {
                return pSDEDataSetBase.isCreateManDirty();
            }
            case 17: {
                return pSDEDataSetBase.isCustomCodeDirty();
            }
            case 18: {
                return pSDEDataSetBase.isCustomModeDirty();
            }
            case 19: {
                return pSDEDataSetBase.isDataSetParamsDirty();
            }
            case 20: {
                return pSDEDataSetBase.isDataSetSNDirty();
            }
            case 21: {
                return pSDEDataSetBase.isDefaultModeDirty();
            }
            case 22: {
                return pSDEDataSetBase.isDSOptionDirty();
            }
            case 23: {
                return pSDEDataSetBase.isDSTagDirty();
            }
            case 24: {
                return pSDEDataSetBase.isDSTag2Dirty();
            }
            case 25: {
                return pSDEDataSetBase.isDSTag3Dirty();
            }
            case 26: {
                return pSDEDataSetBase.isDSTag4Dirty();
            }
            case 27: {
                return pSDEDataSetBase.isDynaModelFlagDirty();
            }
            case 28: {
                return pSDEDataSetBase.isEnableAuditDirty();
            }
            case 29: {
                return pSDEDataSetBase.isEnableCacheDirty();
            }
            case 30: {
                return pSDEDataSetBase.isEnableGroupDirty();
            }
            case 31: {
                return pSDEDataSetBase.isEnableOrgDRDirty();
            }
            case 32: {
                return pSDEDataSetBase.isEnableSecBCDirty();
            }
            case 33: {
                return pSDEDataSetBase.isEnableSecDRDirty();
            }
            case 34: {
                return pSDEDataSetBase.isEnableTempDataDirty();
            }
            case 35: {
                return pSDEDataSetBase.isEnableUserDRDirty();
            }
            case 36: {
                return pSDEDataSetBase.isExtendModeDirty();
            }
            case 37: {
                return pSDEDataSetBase.isFilterModelDirty();
            }
            case 38: {
                return pSDEDataSetBase.isFinishFlagDirty();
            }
            case 39: {
                return pSDEDataSetBase.isInPSDEFGroupIdDirty();
            }
            case 40: {
                return pSDEDataSetBase.isInPSDEFGroupNameDirty();
            }
            case 41: {
                return pSDEDataSetBase.isInPSDESampleDataIdDirty();
            }
            case 42: {
                return pSDEDataSetBase.isInPSDESampleDataNameDirty();
            }
            case 43: {
                return pSDEDataSetBase.isInPSSysDynaModelIdDirty();
            }
            case 44: {
                return pSDEDataSetBase.isInPSSysDynaModelNameDirty();
            }
            case 45: {
                return pSDEDataSetBase.isLockFlagDirty();
            }
            case 46: {
                return pSDEDataSetBase.isLogicNameDirty();
            }
            case 47: {
                return pSDEDataSetBase.isMajorPSDEFIdDirty();
            }
            case 48: {
                return pSDEDataSetBase.isMajorPSDEFNameDirty();
            }
            case 49: {
                return pSDEDataSetBase.isMajorSortDirDirty();
            }
            case 50: {
                return pSDEDataSetBase.isMemoDirty();
            }
            case 51: {
                return pSDEDataSetBase.isMinorPSDEFIdDirty();
            }
            case 52: {
                return pSDEDataSetBase.isMinorPSDEFNameDirty();
            }
            case 53: {
                return pSDEDataSetBase.isMinorSortDirDirty();
            }
            case 54: {
                return pSDEDataSetBase.isOrderValueDirty();
            }
            case 55: {
                return pSDEDataSetBase.isOrgDRDirty();
            }
            case 56: {
                return pSDEDataSetBase.isOutPSDEFGroupIdDirty();
            }
            case 57: {
                return pSDEDataSetBase.isOutPSDEFGroupNameDirty();
            }
            case 58: {
                return pSDEDataSetBase.isOutPSDESampleDataIdDirty();
            }
            case 59: {
                return pSDEDataSetBase.isOutPSDESampleDataNameDirty();
            }
            case 60: {
                return pSDEDataSetBase.isPageSizeDirty();
            }
            case 61: {
                return pSDEDataSetBase.isParamTypeDirty();
            }
            case 62: {
                return pSDEDataSetBase.isPOTimeDirty();
            }
            case 63: {
                return pSDEDataSetBase.isPredefinedTypeParamDirty();
            }
            case 64: {
                return pSDEDataSetBase.isPredefinedTypeTextDirty();
            }
            case 65: {
                return pSDEDataSetBase.isPredefineTypeDirty();
            }
            case 66: {
                return pSDEDataSetBase.isPSCodeListIdDirty();
            }
            case 67: {
                return pSDEDataSetBase.isPSCodeListNameDirty();
            }
            case 68: {
                return pSDEDataSetBase.isPSDEDataImpIdDirty();
            }
            case 69: {
                return pSDEDataSetBase.isPSDEDataImpNameDirty();
            }
            case 70: {
                return pSDEDataSetBase.isPSDEDataSetIdDirty();
            }
            case 71: {
                return pSDEDataSetBase.isPSDEDataSetNameDirty();
            }
            case 72: {
                return pSDEDataSetBase.isPSDEIdDirty();
            }
            case 73: {
                return pSDEDataSetBase.isPSDELogicIdDirty();
            }
            case 74: {
                return pSDEDataSetBase.isPSDELogicNameDirty();
            }
            case 75: {
                return pSDEDataSetBase.isPSDENameDirty();
            }
            case 76: {
                return pSDEDataSetBase.isPSDEOPPrivIdDirty();
            }
            case 77: {
                return pSDEDataSetBase.isPSDEOPPrivNameDirty();
            }
            case 78: {
                return pSDEDataSetBase.isPSDynaInstIdDirty();
            }
            case 79: {
                return pSDEDataSetBase.isPSSubSysSADEIdDirty();
            }
            case 80: {
                return pSDEDataSetBase.isPSSubSysSADetailIdDirty();
            }
            case 81: {
                return pSDEDataSetBase.isPSSubSysSADetailNameDirty();
            }
            case 82: {
                return pSDEDataSetBase.isPSSysPFPluginIdDirty();
            }
            case 83: {
                return pSDEDataSetBase.isPSSysPFPluginNameDirty();
            }
            case 84: {
                return pSDEDataSetBase.isPSSysReqItemIdDirty();
            }
            case 85: {
                return pSDEDataSetBase.isPSSysReqItemNameDirty();
            }
            case 86: {
                return pSDEDataSetBase.isPSSysSFPluginIdDirty();
            }
            case 87: {
                return pSDEDataSetBase.isPSSysSFPluginNameDirty();
            }
            case 88: {
                return pSDEDataSetBase.isPSSysTaskIdDirty();
            }
            case 89: {
                return pSDEDataSetBase.isPSSysTaskNameDirty();
            }
            case 90: {
                return pSDEDataSetBase.isPSSysUniStateIdDirty();
            }
            case 91: {
                return pSDEDataSetBase.isPSSysUniStateNameDirty();
            }
            case 92: {
                return pSDEDataSetBase.isPSSysUserDRIdDirty();
            }
            case 93: {
                return pSDEDataSetBase.isPSSysUserDRId2Dirty();
            }
            case 94: {
                return pSDEDataSetBase.isPSSysUserDRNameDirty();
            }
            case 95: {
                return pSDEDataSetBase.isPSSysUserDRName2Dirty();
            }
            case 96: {
                return pSDEDataSetBase.isPubModeDirty();
            }
            case 97: {
                return pSDEDataSetBase.isRawServiceMethodDirty();
            }
            case 98: {
                return pSDEDataSetBase.isRawServiceUrlDirty();
            }
            case 99: {
                return pSDEDataSetBase.isRequestMethodDirty();
            }
            case 100: {
                return pSDEDataSetBase.isRequestPathDirty();
            }
            case 101: {
                return pSDEDataSetBase.isRetValTypeDirty();
            }
            case 102: {
                return pSDEDataSetBase.isSecBCDirty();
            }
            case 103: {
                return pSDEDataSetBase.isSecDRDirty();
            }
            case 104: {
                return pSDEDataSetBase.isServiceCodeNameDirty();
            }
            case 105: {
                return pSDEDataSetBase.isSubSysSADetailModeDirty();
            }
            case 106: {
                return pSDEDataSetBase.isSysUserDR2ParamDirty();
            }
            case 107: {
                return pSDEDataSetBase.isSysUserDRParamDirty();
            }
            case 108: {
                return pSDEDataSetBase.isToDoTaskDirty();
            }
            case 109: {
                return pSDEDataSetBase.isUnionModeDirty();
            }
            case 110: {
                return pSDEDataSetBase.isUpdateDateDirty();
            }
            case 111: {
                return pSDEDataSetBase.isUpdateManDirty();
            }
            case 112: {
                return pSDEDataSetBase.isUserCatDirty();
            }
            case 113: {
                return pSDEDataSetBase.isUserParamsDirty();
            }
            case 114: {
                return pSDEDataSetBase.isUserTagDirty();
            }
            case 115: {
                return pSDEDataSetBase.isUserTag2Dirty();
            }
            case 116: {
                return pSDEDataSetBase.isUserTag3Dirty();
            }
            case 117: {
                return pSDEDataSetBase.isUserTag4Dirty();
            }
            case 118: {
                return pSDEDataSetBase.isValidFlagDirty();
            }
            case 119: {
                return pSDEDataSetBase.isViewColLevelDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEDataSetBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEDataSetBase pSDEDataSetBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEDataSetBase.getActionHolder() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionholder", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getActionHolder()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getADPSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"adpsdelogicid", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getADPSDELogicId()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getADPSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"adpsdelogicname", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getADPSDELogicName()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getAfterCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aftercode", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getAfterCode()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getAggDataPSDERId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aggdatapsderid", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getAggDataPSDERId()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getAggDataPSDERName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aggdatapsdername", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getAggDataPSDERName()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getBeforeCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"beforecode", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getBeforeCode()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getCacheCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cachecat", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getCacheCat()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getCacheCheckState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cachecheckstate", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getCacheCheckState()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getCacheScope() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cachescope", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getCacheScope()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getCacheStatePSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cachestatepsdelogicid", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getCacheStatePSDELogicId()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getCacheStatePSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cachestatepsdelogicname", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getCacheStatePSDELogicName()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getCacheTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cachetag", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getCacheTag()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getCacheTimeout() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cachetimeout", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getCacheTimeout()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getCustomMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"custommode", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getCustomMode()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getDataSetParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"datasetparams", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getDataSetParams()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getDataSetSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"datasetsn", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getDataSetSN()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getDefaultMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultmode", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getDefaultMode()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getDSOption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dsoption", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getDSOption()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getDSTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstag", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getDSTag()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getDSTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstag2", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getDSTag2()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getDSTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstag3", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getDSTag3()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getDSTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstag4", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getDSTag4()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getEnableAudit() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableaudit", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getEnableAudit()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getEnableCache() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablecache", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getEnableCache()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getEnableGroup() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablegroup", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getEnableGroup()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getEnableOrgDR() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableorgdr", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getEnableOrgDR()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getEnableSecBC() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablesecbc", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getEnableSecBC()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getEnableSecDR() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablesecdr", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getEnableSecDR()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getEnableTempData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enabletempdata", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getEnableTempData()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getEnableUserDR() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableuserdr", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getEnableUserDR()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getExtendMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"extendmode", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getExtendMode()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getFilterModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"filtermodel", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getFilterModel()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getFinishFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"finishflag", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getFinishFlag()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getInPSDEFGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"inpsdefgroupid", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getInPSDEFGroupId()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getInPSDEFGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"inpsdefgroupname", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getInPSDEFGroupName()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getInPSDESampleDataId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"inpsdesampledataid", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getInPSDESampleDataId()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getInPSDESampleDataName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"inpsdesampledataname", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getInPSDESampleDataName()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getInPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"inpssysdynamodelid", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getInPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getInPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"inpssysdynamodelname", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getInPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getLogicName()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getMajorPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"majorpsdefid", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getMajorPSDEFId()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getMajorPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"majorpsdefname", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getMajorPSDEFName()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getMajorSortDir() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"majorsortdir", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getMajorSortDir()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getMinorPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minorpsdefid", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getMinorPSDEFId()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getMinorPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minorpsdefname", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getMinorPSDEFName()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getMinorSortDir() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minorsortdir", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getMinorSortDir()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getOrgDR() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"orgdr", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getOrgDR()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getOutPSDEFGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"outpsdefgroupid", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getOutPSDEFGroupId()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getOutPSDEFGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"outpsdefgroupname", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getOutPSDEFGroupName()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getOutPSDESampleDataId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"outpsdesampledataid", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getOutPSDESampleDataId()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getOutPSDESampleDataName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"outpsdesampledataname", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getOutPSDESampleDataName()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getPageSize() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pagesize", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getPageSize()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getParamType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"paramtype", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getParamType()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getPOTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"potime", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getPOTime()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getPredefinedTypeParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"predefinedtypeparam", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getPredefinedTypeParam()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getPredefinedTypeText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"predefinedtypetext", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getPredefinedTypeText()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getPredefineType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"predefinetype", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getPredefineType()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getPSCodeListId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelistid", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getPSCodeListId()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getPSCodeListName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelistname", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getPSCodeListName()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getPSDEDataImpId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedataimpid", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getPSDEDataImpId()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getPSDEDataImpName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedataimpname", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getPSDEDataImpName()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getPSDEDataSetId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedatasetid", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getPSDEDataSetId()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getPSDEDataSetName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedatasetname", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getPSDEDataSetName()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getPSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicid", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getPSDELogicId()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getPSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicname", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getPSDELogicName()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getPSDEOPPrivId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeopprivid", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getPSDEOPPrivId()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getPSDEOPPrivName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeopprivname", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getPSDEOPPrivName()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getPSSubSysSADEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsyssadeid", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getPSSubSysSADEId()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getPSSubSysSADetailId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsyssadetailid", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getPSSubSysSADetailId()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getPSSubSysSADetailName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsyssadetailname", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getPSSubSysSADetailName()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getPSSysReqItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemid", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getPSSysReqItemId()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getPSSysReqItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemname", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getPSSysReqItemName()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getPSSysTaskId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystaskid", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getPSSysTaskId()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getPSSysTaskName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystaskname", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getPSSysTaskName()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getPSSysUniStateId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysunistateid", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getPSSysUniStateId()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getPSSysUniStateName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysunistatename", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getPSSysUniStateName()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getPSSysUserDRId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuserdrid", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getPSSysUserDRId()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getPSSysUserDRId2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuserdrid2", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getPSSysUserDRId2()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getPSSysUserDRName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuserdrname", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getPSSysUserDRName()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getPSSysUserDRName2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuserdrname2", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getPSSysUserDRName2()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getPubMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubmode", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getPubMode()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getRawServiceMethod() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rawservicemethod", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getRawServiceMethod()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getRawServiceUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rawserviceurl", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getRawServiceUrl()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getRequestMethod() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"requestmethod", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getRequestMethod()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getRequestPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"requestpath", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getRequestPath()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getRetValType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"retvaltype", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getRetValType()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getSecBC() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"secbc", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getSecBC()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getSecDR() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"secdr", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getSecDR()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getServiceCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"servicecodename", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getServiceCodeName()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getSubSysSADetailMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"subsyssadetailmode", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getSubSysSADetailMode()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getSysUserDR2Param() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sysuserdr2param", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getSysUserDR2Param()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getSysUserDRParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sysuserdrparam", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getSysUserDRParam()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getToDoTask() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"todotask", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getToDoTask()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getUnionMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"unionmode", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getUnionMode()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getUserParams()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSDEDataSetBase.getViewColLevel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewcollevel", (Object)PSDEDataSetBase.getJSONValue((Object)pSDEDataSetBase.getViewColLevel()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEDataSetBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEDataSetBase pSDEDataSetBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEDataSetBase.getActionHolder() != null) {
            object = pSDEDataSetBase.getActionHolder();
            xmlNode.setAttribute(FIELD_ACTIONHOLDER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataSetBase.getADPSDELogicId() != null) {
            object = pSDEDataSetBase.getADPSDELogicId();
            xmlNode.setAttribute(FIELD_ADPSDELOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getADPSDELogicName() != null) {
            object = pSDEDataSetBase.getADPSDELogicName();
            xmlNode.setAttribute(FIELD_ADPSDELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getAfterCode() != null) {
            object = pSDEDataSetBase.getAfterCode();
            xmlNode.setAttribute(FIELD_AFTERCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getAggDataPSDERId() != null) {
            object = pSDEDataSetBase.getAggDataPSDERId();
            xmlNode.setAttribute(FIELD_AGGDATAPSDERID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getAggDataPSDERName() != null) {
            object = pSDEDataSetBase.getAggDataPSDERName();
            xmlNode.setAttribute(FIELD_AGGDATAPSDERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getBeforeCode() != null) {
            object = pSDEDataSetBase.getBeforeCode();
            xmlNode.setAttribute(FIELD_BEFORECODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getCacheCat() != null) {
            object = pSDEDataSetBase.getCacheCat();
            xmlNode.setAttribute(FIELD_CACHECAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getCacheCheckState() != null) {
            object = pSDEDataSetBase.getCacheCheckState();
            xmlNode.setAttribute(FIELD_CACHECHECKSTATE, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getCacheScope() != null) {
            object = pSDEDataSetBase.getCacheScope();
            xmlNode.setAttribute(FIELD_CACHESCOPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getCacheStatePSDELogicId() != null) {
            object = pSDEDataSetBase.getCacheStatePSDELogicId();
            xmlNode.setAttribute(FIELD_CACHESTATEPSDELOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getCacheStatePSDELogicName() != null) {
            object = pSDEDataSetBase.getCacheStatePSDELogicName();
            xmlNode.setAttribute(FIELD_CACHESTATEPSDELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getCacheTag() != null) {
            object = pSDEDataSetBase.getCacheTag();
            xmlNode.setAttribute(FIELD_CACHETAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getCacheTimeout() != null) {
            object = pSDEDataSetBase.getCacheTimeout();
            xmlNode.setAttribute(FIELD_CACHETIMEOUT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataSetBase.getCodeName() != null) {
            object = pSDEDataSetBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getCreateDate() != null) {
            object = pSDEDataSetBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDataSetBase.getCreateMan() != null) {
            object = pSDEDataSetBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getCustomCode() != null) {
            object = pSDEDataSetBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getCustomMode() != null) {
            object = pSDEDataSetBase.getCustomMode();
            xmlNode.setAttribute(FIELD_CUSTOMMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataSetBase.getDataSetParams() != null) {
            object = pSDEDataSetBase.getDataSetParams();
            xmlNode.setAttribute(FIELD_DATASETPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getDataSetSN() != null) {
            object = pSDEDataSetBase.getDataSetSN();
            xmlNode.setAttribute(FIELD_DATASETSN, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getDefaultMode() != null) {
            object = pSDEDataSetBase.getDefaultMode();
            xmlNode.setAttribute(FIELD_DEFAULTMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataSetBase.getDSOption() != null) {
            object = pSDEDataSetBase.getDSOption();
            xmlNode.setAttribute(FIELD_DSOPTION, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataSetBase.getDSTag() != null) {
            object = pSDEDataSetBase.getDSTag();
            xmlNode.setAttribute(FIELD_DSTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getDSTag2() != null) {
            object = pSDEDataSetBase.getDSTag2();
            xmlNode.setAttribute(FIELD_DSTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getDSTag3() != null) {
            object = pSDEDataSetBase.getDSTag3();
            xmlNode.setAttribute(FIELD_DSTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getDSTag4() != null) {
            object = pSDEDataSetBase.getDSTag4();
            xmlNode.setAttribute(FIELD_DSTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getDynaModelFlag() != null) {
            object = pSDEDataSetBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataSetBase.getEnableAudit() != null) {
            object = pSDEDataSetBase.getEnableAudit();
            xmlNode.setAttribute(FIELD_ENABLEAUDIT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataSetBase.getEnableCache() != null) {
            object = pSDEDataSetBase.getEnableCache();
            xmlNode.setAttribute(FIELD_ENABLECACHE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataSetBase.getEnableGroup() != null) {
            object = pSDEDataSetBase.getEnableGroup();
            xmlNode.setAttribute(FIELD_ENABLEGROUP, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataSetBase.getEnableOrgDR() != null) {
            object = pSDEDataSetBase.getEnableOrgDR();
            xmlNode.setAttribute(FIELD_ENABLEORGDR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataSetBase.getEnableSecBC() != null) {
            object = pSDEDataSetBase.getEnableSecBC();
            xmlNode.setAttribute(FIELD_ENABLESECBC, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataSetBase.getEnableSecDR() != null) {
            object = pSDEDataSetBase.getEnableSecDR();
            xmlNode.setAttribute(FIELD_ENABLESECDR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataSetBase.getEnableTempData() != null) {
            object = pSDEDataSetBase.getEnableTempData();
            xmlNode.setAttribute(FIELD_ENABLETEMPDATA, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataSetBase.getEnableUserDR() != null) {
            object = pSDEDataSetBase.getEnableUserDR();
            xmlNode.setAttribute(FIELD_ENABLEUSERDR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataSetBase.getExtendMode() != null) {
            object = pSDEDataSetBase.getExtendMode();
            xmlNode.setAttribute(FIELD_EXTENDMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataSetBase.getFilterModel() != null) {
            object = pSDEDataSetBase.getFilterModel();
            xmlNode.setAttribute(FIELD_FILTERMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getFinishFlag() != null) {
            object = pSDEDataSetBase.getFinishFlag();
            xmlNode.setAttribute(FIELD_FINISHFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataSetBase.getInPSDEFGroupId() != null) {
            object = pSDEDataSetBase.getInPSDEFGroupId();
            xmlNode.setAttribute(FIELD_INPSDEFGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getInPSDEFGroupName() != null) {
            object = pSDEDataSetBase.getInPSDEFGroupName();
            xmlNode.setAttribute(FIELD_INPSDEFGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getInPSDESampleDataId() != null) {
            object = pSDEDataSetBase.getInPSDESampleDataId();
            xmlNode.setAttribute(FIELD_INPSDESAMPLEDATAID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getInPSDESampleDataName() != null) {
            object = pSDEDataSetBase.getInPSDESampleDataName();
            xmlNode.setAttribute(FIELD_INPSDESAMPLEDATANAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getInPSSysDynaModelId() != null) {
            object = pSDEDataSetBase.getInPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_INPSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getInPSSysDynaModelName() != null) {
            object = pSDEDataSetBase.getInPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_INPSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getLockFlag() != null) {
            object = pSDEDataSetBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataSetBase.getLogicName() != null) {
            object = pSDEDataSetBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getMajorPSDEFId() != null) {
            object = pSDEDataSetBase.getMajorPSDEFId();
            xmlNode.setAttribute(FIELD_MAJORPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getMajorPSDEFName() != null) {
            object = pSDEDataSetBase.getMajorPSDEFName();
            xmlNode.setAttribute(FIELD_MAJORPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getMajorSortDir() != null) {
            object = pSDEDataSetBase.getMajorSortDir();
            xmlNode.setAttribute(FIELD_MAJORSORTDIR, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getMemo() != null) {
            object = pSDEDataSetBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getMinorPSDEFId() != null) {
            object = pSDEDataSetBase.getMinorPSDEFId();
            xmlNode.setAttribute(FIELD_MINORPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getMinorPSDEFName() != null) {
            object = pSDEDataSetBase.getMinorPSDEFName();
            xmlNode.setAttribute(FIELD_MINORPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getMinorSortDir() != null) {
            object = pSDEDataSetBase.getMinorSortDir();
            xmlNode.setAttribute(FIELD_MINORSORTDIR, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getOrderValue() != null) {
            object = pSDEDataSetBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataSetBase.getOrgDR() != null) {
            object = pSDEDataSetBase.getOrgDR();
            xmlNode.setAttribute(FIELD_ORGDR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataSetBase.getOutPSDEFGroupId() != null) {
            object = pSDEDataSetBase.getOutPSDEFGroupId();
            xmlNode.setAttribute(FIELD_OUTPSDEFGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getOutPSDEFGroupName() != null) {
            object = pSDEDataSetBase.getOutPSDEFGroupName();
            xmlNode.setAttribute(FIELD_OUTPSDEFGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getOutPSDESampleDataId() != null) {
            object = pSDEDataSetBase.getOutPSDESampleDataId();
            xmlNode.setAttribute(FIELD_OUTPSDESAMPLEDATAID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getOutPSDESampleDataName() != null) {
            object = pSDEDataSetBase.getOutPSDESampleDataName();
            xmlNode.setAttribute(FIELD_OUTPSDESAMPLEDATANAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getPageSize() != null) {
            object = pSDEDataSetBase.getPageSize();
            xmlNode.setAttribute(FIELD_PAGESIZE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataSetBase.getParamType() != null) {
            object = pSDEDataSetBase.getParamType();
            xmlNode.setAttribute(FIELD_PARAMTYPE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataSetBase.getPOTime() != null) {
            object = pSDEDataSetBase.getPOTime();
            xmlNode.setAttribute(FIELD_POTIME, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataSetBase.getPredefinedTypeParam() != null) {
            object = pSDEDataSetBase.getPredefinedTypeParam();
            xmlNode.setAttribute(FIELD_PREDEFINEDTYPEPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getPredefinedTypeText() != null) {
            object = pSDEDataSetBase.getPredefinedTypeText();
            xmlNode.setAttribute(FIELD_PREDEFINEDTYPETEXT, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getPredefineType() != null) {
            object = pSDEDataSetBase.getPredefineType();
            xmlNode.setAttribute(FIELD_PREDEFINETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getPSCodeListId() != null) {
            object = pSDEDataSetBase.getPSCodeListId();
            xmlNode.setAttribute(FIELD_PSCODELISTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getPSCodeListName() != null) {
            object = pSDEDataSetBase.getPSCodeListName();
            xmlNode.setAttribute(FIELD_PSCODELISTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getPSDEDataImpId() != null) {
            object = pSDEDataSetBase.getPSDEDataImpId();
            xmlNode.setAttribute(FIELD_PSDEDATAIMPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getPSDEDataImpName() != null) {
            object = pSDEDataSetBase.getPSDEDataImpName();
            xmlNode.setAttribute(FIELD_PSDEDATAIMPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getPSDEDataSetId() != null) {
            object = pSDEDataSetBase.getPSDEDataSetId();
            xmlNode.setAttribute(FIELD_PSDEDATASETID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getPSDEDataSetName() != null) {
            object = pSDEDataSetBase.getPSDEDataSetName();
            xmlNode.setAttribute(FIELD_PSDEDATASETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getPSDEId() != null) {
            object = pSDEDataSetBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getPSDELogicId() != null) {
            object = pSDEDataSetBase.getPSDELogicId();
            xmlNode.setAttribute(FIELD_PSDELOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getPSDELogicName() != null) {
            object = pSDEDataSetBase.getPSDELogicName();
            xmlNode.setAttribute(FIELD_PSDELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getPSDEName() != null) {
            object = pSDEDataSetBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getPSDEOPPrivId() != null) {
            object = pSDEDataSetBase.getPSDEOPPrivId();
            xmlNode.setAttribute(FIELD_PSDEOPPRIVID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getPSDEOPPrivName() != null) {
            object = pSDEDataSetBase.getPSDEOPPrivName();
            xmlNode.setAttribute(FIELD_PSDEOPPRIVNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getPSDynaInstId() != null) {
            object = pSDEDataSetBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getPSSubSysSADEId() != null) {
            object = pSDEDataSetBase.getPSSubSysSADEId();
            xmlNode.setAttribute(FIELD_PSSUBSYSSADEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getPSSubSysSADetailId() != null) {
            object = pSDEDataSetBase.getPSSubSysSADetailId();
            xmlNode.setAttribute(FIELD_PSSUBSYSSADETAILID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getPSSubSysSADetailName() != null) {
            object = pSDEDataSetBase.getPSSubSysSADetailName();
            xmlNode.setAttribute(FIELD_PSSUBSYSSADETAILNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getPSSysPFPluginId() != null) {
            object = pSDEDataSetBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getPSSysPFPluginName() != null) {
            object = pSDEDataSetBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getPSSysReqItemId() != null) {
            object = pSDEDataSetBase.getPSSysReqItemId();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getPSSysReqItemName() != null) {
            object = pSDEDataSetBase.getPSSysReqItemName();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getPSSysSFPluginId() != null) {
            object = pSDEDataSetBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getPSSysSFPluginName() != null) {
            object = pSDEDataSetBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getPSSysTaskId() != null) {
            object = pSDEDataSetBase.getPSSysTaskId();
            xmlNode.setAttribute(FIELD_PSSYSTASKID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getPSSysTaskName() != null) {
            object = pSDEDataSetBase.getPSSysTaskName();
            xmlNode.setAttribute(FIELD_PSSYSTASKNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getPSSysUniStateId() != null) {
            object = pSDEDataSetBase.getPSSysUniStateId();
            xmlNode.setAttribute(FIELD_PSSYSUNISTATEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getPSSysUniStateName() != null) {
            object = pSDEDataSetBase.getPSSysUniStateName();
            xmlNode.setAttribute(FIELD_PSSYSUNISTATENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getPSSysUserDRId() != null) {
            object = pSDEDataSetBase.getPSSysUserDRId();
            xmlNode.setAttribute(FIELD_PSSYSUSERDRID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getPSSysUserDRId2() != null) {
            object = pSDEDataSetBase.getPSSysUserDRId2();
            xmlNode.setAttribute(FIELD_PSSYSUSERDRID2, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getPSSysUserDRName() != null) {
            object = pSDEDataSetBase.getPSSysUserDRName();
            xmlNode.setAttribute(FIELD_PSSYSUSERDRNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getPSSysUserDRName2() != null) {
            object = pSDEDataSetBase.getPSSysUserDRName2();
            xmlNode.setAttribute(FIELD_PSSYSUSERDRNAME2, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getPubMode() != null) {
            object = pSDEDataSetBase.getPubMode();
            xmlNode.setAttribute(FIELD_PUBMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataSetBase.getRawServiceMethod() != null) {
            object = pSDEDataSetBase.getRawServiceMethod();
            xmlNode.setAttribute(FIELD_RAWSERVICEMETHOD, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getRawServiceUrl() != null) {
            object = pSDEDataSetBase.getRawServiceUrl();
            xmlNode.setAttribute(FIELD_RAWSERVICEURL, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getRequestMethod() != null) {
            object = pSDEDataSetBase.getRequestMethod();
            xmlNode.setAttribute(FIELD_REQUESTMETHOD, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getRequestPath() != null) {
            object = pSDEDataSetBase.getRequestPath();
            xmlNode.setAttribute(FIELD_REQUESTPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getRetValType() != null) {
            object = pSDEDataSetBase.getRetValType();
            xmlNode.setAttribute(FIELD_RETVALTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getSecBC() != null) {
            object = pSDEDataSetBase.getSecBC();
            xmlNode.setAttribute(FIELD_SECBC, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getSecDR() != null) {
            object = pSDEDataSetBase.getSecDR();
            xmlNode.setAttribute(FIELD_SECDR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataSetBase.getServiceCodeName() != null) {
            object = pSDEDataSetBase.getServiceCodeName();
            xmlNode.setAttribute(FIELD_SERVICECODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getSubSysSADetailMode() != null) {
            object = pSDEDataSetBase.getSubSysSADetailMode();
            xmlNode.setAttribute(FIELD_SUBSYSSADETAILMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataSetBase.getSysUserDR2Param() != null) {
            object = pSDEDataSetBase.getSysUserDR2Param();
            xmlNode.setAttribute(FIELD_SYSUSERDR2PARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getSysUserDRParam() != null) {
            object = pSDEDataSetBase.getSysUserDRParam();
            xmlNode.setAttribute(FIELD_SYSUSERDRPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getToDoTask() != null) {
            object = pSDEDataSetBase.getToDoTask();
            xmlNode.setAttribute(FIELD_TODOTASK, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getUnionMode() != null) {
            object = pSDEDataSetBase.getUnionMode();
            xmlNode.setAttribute(FIELD_UNIONMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getUpdateDate() != null) {
            object = pSDEDataSetBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDataSetBase.getUpdateMan() != null) {
            object = pSDEDataSetBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getUserCat() != null) {
            object = pSDEDataSetBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getUserParams() != null) {
            object = pSDEDataSetBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getUserTag() != null) {
            object = pSDEDataSetBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getUserTag2() != null) {
            object = pSDEDataSetBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getUserTag3() != null) {
            object = pSDEDataSetBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getUserTag4() != null) {
            object = pSDEDataSetBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSetBase.getValidFlag() != null) {
            object = pSDEDataSetBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataSetBase.getViewColLevel() != null) {
            object = pSDEDataSetBase.getViewColLevel();
            xmlNode.setAttribute(FIELD_VIEWCOLLEVEL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEDataSetBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEDataSetBase pSDEDataSetBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEDataSetBase.isActionHolderDirty() && (bl || pSDEDataSetBase.getActionHolder() != null)) {
            iDataObject.set(FIELD_ACTIONHOLDER, (Object)pSDEDataSetBase.getActionHolder());
        }
        if (pSDEDataSetBase.isADPSDELogicIdDirty() && (bl || pSDEDataSetBase.getADPSDELogicId() != null)) {
            iDataObject.set(FIELD_ADPSDELOGICID, (Object)pSDEDataSetBase.getADPSDELogicId());
        }
        if (pSDEDataSetBase.isADPSDELogicNameDirty() && (bl || pSDEDataSetBase.getADPSDELogicName() != null)) {
            iDataObject.set(FIELD_ADPSDELOGICNAME, (Object)pSDEDataSetBase.getADPSDELogicName());
        }
        if (pSDEDataSetBase.isAfterCodeDirty() && (bl || pSDEDataSetBase.getAfterCode() != null)) {
            iDataObject.set(FIELD_AFTERCODE, (Object)pSDEDataSetBase.getAfterCode());
        }
        if (pSDEDataSetBase.isAggDataPSDERIdDirty() && (bl || pSDEDataSetBase.getAggDataPSDERId() != null)) {
            iDataObject.set(FIELD_AGGDATAPSDERID, (Object)pSDEDataSetBase.getAggDataPSDERId());
        }
        if (pSDEDataSetBase.isAggDataPSDERNameDirty() && (bl || pSDEDataSetBase.getAggDataPSDERName() != null)) {
            iDataObject.set(FIELD_AGGDATAPSDERNAME, (Object)pSDEDataSetBase.getAggDataPSDERName());
        }
        if (pSDEDataSetBase.isBeforeCodeDirty() && (bl || pSDEDataSetBase.getBeforeCode() != null)) {
            iDataObject.set(FIELD_BEFORECODE, (Object)pSDEDataSetBase.getBeforeCode());
        }
        if (pSDEDataSetBase.isCacheCatDirty() && (bl || pSDEDataSetBase.getCacheCat() != null)) {
            iDataObject.set(FIELD_CACHECAT, (Object)pSDEDataSetBase.getCacheCat());
        }
        if (pSDEDataSetBase.isCacheCheckStateDirty() && (bl || pSDEDataSetBase.getCacheCheckState() != null)) {
            iDataObject.set(FIELD_CACHECHECKSTATE, (Object)pSDEDataSetBase.getCacheCheckState());
        }
        if (pSDEDataSetBase.isCacheScopeDirty() && (bl || pSDEDataSetBase.getCacheScope() != null)) {
            iDataObject.set(FIELD_CACHESCOPE, (Object)pSDEDataSetBase.getCacheScope());
        }
        if (pSDEDataSetBase.isCacheStatePSDELogicIdDirty() && (bl || pSDEDataSetBase.getCacheStatePSDELogicId() != null)) {
            iDataObject.set(FIELD_CACHESTATEPSDELOGICID, (Object)pSDEDataSetBase.getCacheStatePSDELogicId());
        }
        if (pSDEDataSetBase.isCacheStatePSDELogicNameDirty() && (bl || pSDEDataSetBase.getCacheStatePSDELogicName() != null)) {
            iDataObject.set(FIELD_CACHESTATEPSDELOGICNAME, (Object)pSDEDataSetBase.getCacheStatePSDELogicName());
        }
        if (pSDEDataSetBase.isCacheTagDirty() && (bl || pSDEDataSetBase.getCacheTag() != null)) {
            iDataObject.set(FIELD_CACHETAG, (Object)pSDEDataSetBase.getCacheTag());
        }
        if (pSDEDataSetBase.isCacheTimeoutDirty() && (bl || pSDEDataSetBase.getCacheTimeout() != null)) {
            iDataObject.set(FIELD_CACHETIMEOUT, (Object)pSDEDataSetBase.getCacheTimeout());
        }
        if (pSDEDataSetBase.isCodeNameDirty() && (bl || pSDEDataSetBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDEDataSetBase.getCodeName());
        }
        if (pSDEDataSetBase.isCreateDateDirty() && (bl || pSDEDataSetBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEDataSetBase.getCreateDate());
        }
        if (pSDEDataSetBase.isCreateManDirty() && (bl || pSDEDataSetBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEDataSetBase.getCreateMan());
        }
        if (pSDEDataSetBase.isCustomCodeDirty() && (bl || pSDEDataSetBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSDEDataSetBase.getCustomCode());
        }
        if (pSDEDataSetBase.isCustomModeDirty() && (bl || pSDEDataSetBase.getCustomMode() != null)) {
            iDataObject.set(FIELD_CUSTOMMODE, (Object)pSDEDataSetBase.getCustomMode());
        }
        if (pSDEDataSetBase.isDataSetParamsDirty() && (bl || pSDEDataSetBase.getDataSetParams() != null)) {
            iDataObject.set(FIELD_DATASETPARAMS, (Object)pSDEDataSetBase.getDataSetParams());
        }
        if (pSDEDataSetBase.isDataSetSNDirty() && (bl || pSDEDataSetBase.getDataSetSN() != null)) {
            iDataObject.set(FIELD_DATASETSN, (Object)pSDEDataSetBase.getDataSetSN());
        }
        if (pSDEDataSetBase.isDefaultModeDirty() && (bl || pSDEDataSetBase.getDefaultMode() != null)) {
            iDataObject.set(FIELD_DEFAULTMODE, (Object)pSDEDataSetBase.getDefaultMode());
        }
        if (pSDEDataSetBase.isDSOptionDirty() && (bl || pSDEDataSetBase.getDSOption() != null)) {
            iDataObject.set(FIELD_DSOPTION, (Object)pSDEDataSetBase.getDSOption());
        }
        if (pSDEDataSetBase.isDSTagDirty() && (bl || pSDEDataSetBase.getDSTag() != null)) {
            iDataObject.set(FIELD_DSTAG, (Object)pSDEDataSetBase.getDSTag());
        }
        if (pSDEDataSetBase.isDSTag2Dirty() && (bl || pSDEDataSetBase.getDSTag2() != null)) {
            iDataObject.set(FIELD_DSTAG2, (Object)pSDEDataSetBase.getDSTag2());
        }
        if (pSDEDataSetBase.isDSTag3Dirty() && (bl || pSDEDataSetBase.getDSTag3() != null)) {
            iDataObject.set(FIELD_DSTAG3, (Object)pSDEDataSetBase.getDSTag3());
        }
        if (pSDEDataSetBase.isDSTag4Dirty() && (bl || pSDEDataSetBase.getDSTag4() != null)) {
            iDataObject.set(FIELD_DSTAG4, (Object)pSDEDataSetBase.getDSTag4());
        }
        if (pSDEDataSetBase.isDynaModelFlagDirty() && (bl || pSDEDataSetBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSDEDataSetBase.getDynaModelFlag());
        }
        if (pSDEDataSetBase.isEnableAuditDirty() && (bl || pSDEDataSetBase.getEnableAudit() != null)) {
            iDataObject.set(FIELD_ENABLEAUDIT, (Object)pSDEDataSetBase.getEnableAudit());
        }
        if (pSDEDataSetBase.isEnableCacheDirty() && (bl || pSDEDataSetBase.getEnableCache() != null)) {
            iDataObject.set(FIELD_ENABLECACHE, (Object)pSDEDataSetBase.getEnableCache());
        }
        if (pSDEDataSetBase.isEnableGroupDirty() && (bl || pSDEDataSetBase.getEnableGroup() != null)) {
            iDataObject.set(FIELD_ENABLEGROUP, (Object)pSDEDataSetBase.getEnableGroup());
        }
        if (pSDEDataSetBase.isEnableOrgDRDirty() && (bl || pSDEDataSetBase.getEnableOrgDR() != null)) {
            iDataObject.set(FIELD_ENABLEORGDR, (Object)pSDEDataSetBase.getEnableOrgDR());
        }
        if (pSDEDataSetBase.isEnableSecBCDirty() && (bl || pSDEDataSetBase.getEnableSecBC() != null)) {
            iDataObject.set(FIELD_ENABLESECBC, (Object)pSDEDataSetBase.getEnableSecBC());
        }
        if (pSDEDataSetBase.isEnableSecDRDirty() && (bl || pSDEDataSetBase.getEnableSecDR() != null)) {
            iDataObject.set(FIELD_ENABLESECDR, (Object)pSDEDataSetBase.getEnableSecDR());
        }
        if (pSDEDataSetBase.isEnableTempDataDirty() && (bl || pSDEDataSetBase.getEnableTempData() != null)) {
            iDataObject.set(FIELD_ENABLETEMPDATA, (Object)pSDEDataSetBase.getEnableTempData());
        }
        if (pSDEDataSetBase.isEnableUserDRDirty() && (bl || pSDEDataSetBase.getEnableUserDR() != null)) {
            iDataObject.set(FIELD_ENABLEUSERDR, (Object)pSDEDataSetBase.getEnableUserDR());
        }
        if (pSDEDataSetBase.isExtendModeDirty() && (bl || pSDEDataSetBase.getExtendMode() != null)) {
            iDataObject.set(FIELD_EXTENDMODE, (Object)pSDEDataSetBase.getExtendMode());
        }
        if (pSDEDataSetBase.isFilterModelDirty() && (bl || pSDEDataSetBase.getFilterModel() != null)) {
            iDataObject.set(FIELD_FILTERMODEL, (Object)pSDEDataSetBase.getFilterModel());
        }
        if (pSDEDataSetBase.isFinishFlagDirty() && (bl || pSDEDataSetBase.getFinishFlag() != null)) {
            iDataObject.set(FIELD_FINISHFLAG, (Object)pSDEDataSetBase.getFinishFlag());
        }
        if (pSDEDataSetBase.isInPSDEFGroupIdDirty() && (bl || pSDEDataSetBase.getInPSDEFGroupId() != null)) {
            iDataObject.set(FIELD_INPSDEFGROUPID, (Object)pSDEDataSetBase.getInPSDEFGroupId());
        }
        if (pSDEDataSetBase.isInPSDEFGroupNameDirty() && (bl || pSDEDataSetBase.getInPSDEFGroupName() != null)) {
            iDataObject.set(FIELD_INPSDEFGROUPNAME, (Object)pSDEDataSetBase.getInPSDEFGroupName());
        }
        if (pSDEDataSetBase.isInPSDESampleDataIdDirty() && (bl || pSDEDataSetBase.getInPSDESampleDataId() != null)) {
            iDataObject.set(FIELD_INPSDESAMPLEDATAID, (Object)pSDEDataSetBase.getInPSDESampleDataId());
        }
        if (pSDEDataSetBase.isInPSDESampleDataNameDirty() && (bl || pSDEDataSetBase.getInPSDESampleDataName() != null)) {
            iDataObject.set(FIELD_INPSDESAMPLEDATANAME, (Object)pSDEDataSetBase.getInPSDESampleDataName());
        }
        if (pSDEDataSetBase.isInPSSysDynaModelIdDirty() && (bl || pSDEDataSetBase.getInPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_INPSSYSDYNAMODELID, (Object)pSDEDataSetBase.getInPSSysDynaModelId());
        }
        if (pSDEDataSetBase.isInPSSysDynaModelNameDirty() && (bl || pSDEDataSetBase.getInPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_INPSSYSDYNAMODELNAME, (Object)pSDEDataSetBase.getInPSSysDynaModelName());
        }
        if (pSDEDataSetBase.isLockFlagDirty() && (bl || pSDEDataSetBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSDEDataSetBase.getLockFlag());
        }
        if (pSDEDataSetBase.isLogicNameDirty() && (bl || pSDEDataSetBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSDEDataSetBase.getLogicName());
        }
        if (pSDEDataSetBase.isMajorPSDEFIdDirty() && (bl || pSDEDataSetBase.getMajorPSDEFId() != null)) {
            iDataObject.set(FIELD_MAJORPSDEFID, (Object)pSDEDataSetBase.getMajorPSDEFId());
        }
        if (pSDEDataSetBase.isMajorPSDEFNameDirty() && (bl || pSDEDataSetBase.getMajorPSDEFName() != null)) {
            iDataObject.set(FIELD_MAJORPSDEFNAME, (Object)pSDEDataSetBase.getMajorPSDEFName());
        }
        if (pSDEDataSetBase.isMajorSortDirDirty() && (bl || pSDEDataSetBase.getMajorSortDir() != null)) {
            iDataObject.set(FIELD_MAJORSORTDIR, (Object)pSDEDataSetBase.getMajorSortDir());
        }
        if (pSDEDataSetBase.isMemoDirty() && (bl || pSDEDataSetBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEDataSetBase.getMemo());
        }
        if (pSDEDataSetBase.isMinorPSDEFIdDirty() && (bl || pSDEDataSetBase.getMinorPSDEFId() != null)) {
            iDataObject.set(FIELD_MINORPSDEFID, (Object)pSDEDataSetBase.getMinorPSDEFId());
        }
        if (pSDEDataSetBase.isMinorPSDEFNameDirty() && (bl || pSDEDataSetBase.getMinorPSDEFName() != null)) {
            iDataObject.set(FIELD_MINORPSDEFNAME, (Object)pSDEDataSetBase.getMinorPSDEFName());
        }
        if (pSDEDataSetBase.isMinorSortDirDirty() && (bl || pSDEDataSetBase.getMinorSortDir() != null)) {
            iDataObject.set(FIELD_MINORSORTDIR, (Object)pSDEDataSetBase.getMinorSortDir());
        }
        if (pSDEDataSetBase.isOrderValueDirty() && (bl || pSDEDataSetBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEDataSetBase.getOrderValue());
        }
        if (pSDEDataSetBase.isOrgDRDirty() && (bl || pSDEDataSetBase.getOrgDR() != null)) {
            iDataObject.set(FIELD_ORGDR, (Object)pSDEDataSetBase.getOrgDR());
        }
        if (pSDEDataSetBase.isOutPSDEFGroupIdDirty() && (bl || pSDEDataSetBase.getOutPSDEFGroupId() != null)) {
            iDataObject.set(FIELD_OUTPSDEFGROUPID, (Object)pSDEDataSetBase.getOutPSDEFGroupId());
        }
        if (pSDEDataSetBase.isOutPSDEFGroupNameDirty() && (bl || pSDEDataSetBase.getOutPSDEFGroupName() != null)) {
            iDataObject.set(FIELD_OUTPSDEFGROUPNAME, (Object)pSDEDataSetBase.getOutPSDEFGroupName());
        }
        if (pSDEDataSetBase.isOutPSDESampleDataIdDirty() && (bl || pSDEDataSetBase.getOutPSDESampleDataId() != null)) {
            iDataObject.set(FIELD_OUTPSDESAMPLEDATAID, (Object)pSDEDataSetBase.getOutPSDESampleDataId());
        }
        if (pSDEDataSetBase.isOutPSDESampleDataNameDirty() && (bl || pSDEDataSetBase.getOutPSDESampleDataName() != null)) {
            iDataObject.set(FIELD_OUTPSDESAMPLEDATANAME, (Object)pSDEDataSetBase.getOutPSDESampleDataName());
        }
        if (pSDEDataSetBase.isPageSizeDirty() && (bl || pSDEDataSetBase.getPageSize() != null)) {
            iDataObject.set(FIELD_PAGESIZE, (Object)pSDEDataSetBase.getPageSize());
        }
        if (pSDEDataSetBase.isParamTypeDirty() && (bl || pSDEDataSetBase.getParamType() != null)) {
            iDataObject.set(FIELD_PARAMTYPE, (Object)pSDEDataSetBase.getParamType());
        }
        if (pSDEDataSetBase.isPOTimeDirty() && (bl || pSDEDataSetBase.getPOTime() != null)) {
            iDataObject.set(FIELD_POTIME, (Object)pSDEDataSetBase.getPOTime());
        }
        if (pSDEDataSetBase.isPredefinedTypeParamDirty() && (bl || pSDEDataSetBase.getPredefinedTypeParam() != null)) {
            iDataObject.set(FIELD_PREDEFINEDTYPEPARAM, (Object)pSDEDataSetBase.getPredefinedTypeParam());
        }
        if (pSDEDataSetBase.isPredefinedTypeTextDirty() && (bl || pSDEDataSetBase.getPredefinedTypeText() != null)) {
            iDataObject.set(FIELD_PREDEFINEDTYPETEXT, (Object)pSDEDataSetBase.getPredefinedTypeText());
        }
        if (pSDEDataSetBase.isPredefineTypeDirty() && (bl || pSDEDataSetBase.getPredefineType() != null)) {
            iDataObject.set(FIELD_PREDEFINETYPE, (Object)pSDEDataSetBase.getPredefineType());
        }
        if (pSDEDataSetBase.isPSCodeListIdDirty() && (bl || pSDEDataSetBase.getPSCodeListId() != null)) {
            iDataObject.set(FIELD_PSCODELISTID, (Object)pSDEDataSetBase.getPSCodeListId());
        }
        if (pSDEDataSetBase.isPSCodeListNameDirty() && (bl || pSDEDataSetBase.getPSCodeListName() != null)) {
            iDataObject.set(FIELD_PSCODELISTNAME, (Object)pSDEDataSetBase.getPSCodeListName());
        }
        if (pSDEDataSetBase.isPSDEDataImpIdDirty() && (bl || pSDEDataSetBase.getPSDEDataImpId() != null)) {
            iDataObject.set(FIELD_PSDEDATAIMPID, (Object)pSDEDataSetBase.getPSDEDataImpId());
        }
        if (pSDEDataSetBase.isPSDEDataImpNameDirty() && (bl || pSDEDataSetBase.getPSDEDataImpName() != null)) {
            iDataObject.set(FIELD_PSDEDATAIMPNAME, (Object)pSDEDataSetBase.getPSDEDataImpName());
        }
        if (pSDEDataSetBase.isPSDEDataSetIdDirty() && (bl || pSDEDataSetBase.getPSDEDataSetId() != null)) {
            iDataObject.set(FIELD_PSDEDATASETID, (Object)pSDEDataSetBase.getPSDEDataSetId());
        }
        if (pSDEDataSetBase.isPSDEDataSetNameDirty() && (bl || pSDEDataSetBase.getPSDEDataSetName() != null)) {
            iDataObject.set(FIELD_PSDEDATASETNAME, (Object)pSDEDataSetBase.getPSDEDataSetName());
        }
        if (pSDEDataSetBase.isPSDEIdDirty() && (bl || pSDEDataSetBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEDataSetBase.getPSDEId());
        }
        if (pSDEDataSetBase.isPSDELogicIdDirty() && (bl || pSDEDataSetBase.getPSDELogicId() != null)) {
            iDataObject.set(FIELD_PSDELOGICID, (Object)pSDEDataSetBase.getPSDELogicId());
        }
        if (pSDEDataSetBase.isPSDELogicNameDirty() && (bl || pSDEDataSetBase.getPSDELogicName() != null)) {
            iDataObject.set(FIELD_PSDELOGICNAME, (Object)pSDEDataSetBase.getPSDELogicName());
        }
        if (pSDEDataSetBase.isPSDENameDirty() && (bl || pSDEDataSetBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEDataSetBase.getPSDEName());
        }
        if (pSDEDataSetBase.isPSDEOPPrivIdDirty() && (bl || pSDEDataSetBase.getPSDEOPPrivId() != null)) {
            iDataObject.set(FIELD_PSDEOPPRIVID, (Object)pSDEDataSetBase.getPSDEOPPrivId());
        }
        if (pSDEDataSetBase.isPSDEOPPrivNameDirty() && (bl || pSDEDataSetBase.getPSDEOPPrivName() != null)) {
            iDataObject.set(FIELD_PSDEOPPRIVNAME, (Object)pSDEDataSetBase.getPSDEOPPrivName());
        }
        if (pSDEDataSetBase.isPSDynaInstIdDirty() && (bl || pSDEDataSetBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSDEDataSetBase.getPSDynaInstId());
        }
        if (pSDEDataSetBase.isPSSubSysSADEIdDirty() && (bl || pSDEDataSetBase.getPSSubSysSADEId() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSADEID, (Object)pSDEDataSetBase.getPSSubSysSADEId());
        }
        if (pSDEDataSetBase.isPSSubSysSADetailIdDirty() && (bl || pSDEDataSetBase.getPSSubSysSADetailId() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSADETAILID, (Object)pSDEDataSetBase.getPSSubSysSADetailId());
        }
        if (pSDEDataSetBase.isPSSubSysSADetailNameDirty() && (bl || pSDEDataSetBase.getPSSubSysSADetailName() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSADETAILNAME, (Object)pSDEDataSetBase.getPSSubSysSADetailName());
        }
        if (pSDEDataSetBase.isPSSysPFPluginIdDirty() && (bl || pSDEDataSetBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSDEDataSetBase.getPSSysPFPluginId());
        }
        if (pSDEDataSetBase.isPSSysPFPluginNameDirty() && (bl || pSDEDataSetBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSDEDataSetBase.getPSSysPFPluginName());
        }
        if (pSDEDataSetBase.isPSSysReqItemIdDirty() && (bl || pSDEDataSetBase.getPSSysReqItemId() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMID, (Object)pSDEDataSetBase.getPSSysReqItemId());
        }
        if (pSDEDataSetBase.isPSSysReqItemNameDirty() && (bl || pSDEDataSetBase.getPSSysReqItemName() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMNAME, (Object)pSDEDataSetBase.getPSSysReqItemName());
        }
        if (pSDEDataSetBase.isPSSysSFPluginIdDirty() && (bl || pSDEDataSetBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSDEDataSetBase.getPSSysSFPluginId());
        }
        if (pSDEDataSetBase.isPSSysSFPluginNameDirty() && (bl || pSDEDataSetBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSDEDataSetBase.getPSSysSFPluginName());
        }
        if (pSDEDataSetBase.isPSSysTaskIdDirty() && (bl || pSDEDataSetBase.getPSSysTaskId() != null)) {
            iDataObject.set(FIELD_PSSYSTASKID, (Object)pSDEDataSetBase.getPSSysTaskId());
        }
        if (pSDEDataSetBase.isPSSysTaskNameDirty() && (bl || pSDEDataSetBase.getPSSysTaskName() != null)) {
            iDataObject.set(FIELD_PSSYSTASKNAME, (Object)pSDEDataSetBase.getPSSysTaskName());
        }
        if (pSDEDataSetBase.isPSSysUniStateIdDirty() && (bl || pSDEDataSetBase.getPSSysUniStateId() != null)) {
            iDataObject.set(FIELD_PSSYSUNISTATEID, (Object)pSDEDataSetBase.getPSSysUniStateId());
        }
        if (pSDEDataSetBase.isPSSysUniStateNameDirty() && (bl || pSDEDataSetBase.getPSSysUniStateName() != null)) {
            iDataObject.set(FIELD_PSSYSUNISTATENAME, (Object)pSDEDataSetBase.getPSSysUniStateName());
        }
        if (pSDEDataSetBase.isPSSysUserDRIdDirty() && (bl || pSDEDataSetBase.getPSSysUserDRId() != null)) {
            iDataObject.set(FIELD_PSSYSUSERDRID, (Object)pSDEDataSetBase.getPSSysUserDRId());
        }
        if (pSDEDataSetBase.isPSSysUserDRId2Dirty() && (bl || pSDEDataSetBase.getPSSysUserDRId2() != null)) {
            iDataObject.set(FIELD_PSSYSUSERDRID2, (Object)pSDEDataSetBase.getPSSysUserDRId2());
        }
        if (pSDEDataSetBase.isPSSysUserDRNameDirty() && (bl || pSDEDataSetBase.getPSSysUserDRName() != null)) {
            iDataObject.set(FIELD_PSSYSUSERDRNAME, (Object)pSDEDataSetBase.getPSSysUserDRName());
        }
        if (pSDEDataSetBase.isPSSysUserDRName2Dirty() && (bl || pSDEDataSetBase.getPSSysUserDRName2() != null)) {
            iDataObject.set(FIELD_PSSYSUSERDRNAME2, (Object)pSDEDataSetBase.getPSSysUserDRName2());
        }
        if (pSDEDataSetBase.isPubModeDirty() && (bl || pSDEDataSetBase.getPubMode() != null)) {
            iDataObject.set(FIELD_PUBMODE, (Object)pSDEDataSetBase.getPubMode());
        }
        if (pSDEDataSetBase.isRawServiceMethodDirty() && (bl || pSDEDataSetBase.getRawServiceMethod() != null)) {
            iDataObject.set(FIELD_RAWSERVICEMETHOD, (Object)pSDEDataSetBase.getRawServiceMethod());
        }
        if (pSDEDataSetBase.isRawServiceUrlDirty() && (bl || pSDEDataSetBase.getRawServiceUrl() != null)) {
            iDataObject.set(FIELD_RAWSERVICEURL, (Object)pSDEDataSetBase.getRawServiceUrl());
        }
        if (pSDEDataSetBase.isRequestMethodDirty() && (bl || pSDEDataSetBase.getRequestMethod() != null)) {
            iDataObject.set(FIELD_REQUESTMETHOD, (Object)pSDEDataSetBase.getRequestMethod());
        }
        if (pSDEDataSetBase.isRequestPathDirty() && (bl || pSDEDataSetBase.getRequestPath() != null)) {
            iDataObject.set(FIELD_REQUESTPATH, (Object)pSDEDataSetBase.getRequestPath());
        }
        if (pSDEDataSetBase.isRetValTypeDirty() && (bl || pSDEDataSetBase.getRetValType() != null)) {
            iDataObject.set(FIELD_RETVALTYPE, (Object)pSDEDataSetBase.getRetValType());
        }
        if (pSDEDataSetBase.isSecBCDirty() && (bl || pSDEDataSetBase.getSecBC() != null)) {
            iDataObject.set(FIELD_SECBC, (Object)pSDEDataSetBase.getSecBC());
        }
        if (pSDEDataSetBase.isSecDRDirty() && (bl || pSDEDataSetBase.getSecDR() != null)) {
            iDataObject.set(FIELD_SECDR, (Object)pSDEDataSetBase.getSecDR());
        }
        if (pSDEDataSetBase.isServiceCodeNameDirty() && (bl || pSDEDataSetBase.getServiceCodeName() != null)) {
            iDataObject.set(FIELD_SERVICECODENAME, (Object)pSDEDataSetBase.getServiceCodeName());
        }
        if (pSDEDataSetBase.isSubSysSADetailModeDirty() && (bl || pSDEDataSetBase.getSubSysSADetailMode() != null)) {
            iDataObject.set(FIELD_SUBSYSSADETAILMODE, (Object)pSDEDataSetBase.getSubSysSADetailMode());
        }
        if (pSDEDataSetBase.isSysUserDR2ParamDirty() && (bl || pSDEDataSetBase.getSysUserDR2Param() != null)) {
            iDataObject.set(FIELD_SYSUSERDR2PARAM, (Object)pSDEDataSetBase.getSysUserDR2Param());
        }
        if (pSDEDataSetBase.isSysUserDRParamDirty() && (bl || pSDEDataSetBase.getSysUserDRParam() != null)) {
            iDataObject.set(FIELD_SYSUSERDRPARAM, (Object)pSDEDataSetBase.getSysUserDRParam());
        }
        if (pSDEDataSetBase.isToDoTaskDirty() && (bl || pSDEDataSetBase.getToDoTask() != null)) {
            iDataObject.set(FIELD_TODOTASK, (Object)pSDEDataSetBase.getToDoTask());
        }
        if (pSDEDataSetBase.isUnionModeDirty() && (bl || pSDEDataSetBase.getUnionMode() != null)) {
            iDataObject.set(FIELD_UNIONMODE, (Object)pSDEDataSetBase.getUnionMode());
        }
        if (pSDEDataSetBase.isUpdateDateDirty() && (bl || pSDEDataSetBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEDataSetBase.getUpdateDate());
        }
        if (pSDEDataSetBase.isUpdateManDirty() && (bl || pSDEDataSetBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEDataSetBase.getUpdateMan());
        }
        if (pSDEDataSetBase.isUserCatDirty() && (bl || pSDEDataSetBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEDataSetBase.getUserCat());
        }
        if (pSDEDataSetBase.isUserParamsDirty() && (bl || pSDEDataSetBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSDEDataSetBase.getUserParams());
        }
        if (pSDEDataSetBase.isUserTagDirty() && (bl || pSDEDataSetBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEDataSetBase.getUserTag());
        }
        if (pSDEDataSetBase.isUserTag2Dirty() && (bl || pSDEDataSetBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEDataSetBase.getUserTag2());
        }
        if (pSDEDataSetBase.isUserTag3Dirty() && (bl || pSDEDataSetBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEDataSetBase.getUserTag3());
        }
        if (pSDEDataSetBase.isUserTag4Dirty() && (bl || pSDEDataSetBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEDataSetBase.getUserTag4());
        }
        if (pSDEDataSetBase.isValidFlagDirty() && (bl || pSDEDataSetBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDEDataSetBase.getValidFlag());
        }
        if (pSDEDataSetBase.isViewColLevelDirty() && (bl || pSDEDataSetBase.getViewColLevel() != null)) {
            iDataObject.set(FIELD_VIEWCOLLEVEL, (Object)pSDEDataSetBase.getViewColLevel());
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
        return PSDEDataSetBase.remove(this, n);
    }

    private static boolean remove(PSDEDataSetBase pSDEDataSetBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEDataSetBase.resetActionHolder();
                return true;
            }
            case 1: {
                pSDEDataSetBase.resetADPSDELogicId();
                return true;
            }
            case 2: {
                pSDEDataSetBase.resetADPSDELogicName();
                return true;
            }
            case 3: {
                pSDEDataSetBase.resetAfterCode();
                return true;
            }
            case 4: {
                pSDEDataSetBase.resetAggDataPSDERId();
                return true;
            }
            case 5: {
                pSDEDataSetBase.resetAggDataPSDERName();
                return true;
            }
            case 6: {
                pSDEDataSetBase.resetBeforeCode();
                return true;
            }
            case 7: {
                pSDEDataSetBase.resetCacheCat();
                return true;
            }
            case 8: {
                pSDEDataSetBase.resetCacheCheckState();
                return true;
            }
            case 9: {
                pSDEDataSetBase.resetCacheScope();
                return true;
            }
            case 10: {
                pSDEDataSetBase.resetCacheStatePSDELogicId();
                return true;
            }
            case 11: {
                pSDEDataSetBase.resetCacheStatePSDELogicName();
                return true;
            }
            case 12: {
                pSDEDataSetBase.resetCacheTag();
                return true;
            }
            case 13: {
                pSDEDataSetBase.resetCacheTimeout();
                return true;
            }
            case 14: {
                pSDEDataSetBase.resetCodeName();
                return true;
            }
            case 15: {
                pSDEDataSetBase.resetCreateDate();
                return true;
            }
            case 16: {
                pSDEDataSetBase.resetCreateMan();
                return true;
            }
            case 17: {
                pSDEDataSetBase.resetCustomCode();
                return true;
            }
            case 18: {
                pSDEDataSetBase.resetCustomMode();
                return true;
            }
            case 19: {
                pSDEDataSetBase.resetDataSetParams();
                return true;
            }
            case 20: {
                pSDEDataSetBase.resetDataSetSN();
                return true;
            }
            case 21: {
                pSDEDataSetBase.resetDefaultMode();
                return true;
            }
            case 22: {
                pSDEDataSetBase.resetDSOption();
                return true;
            }
            case 23: {
                pSDEDataSetBase.resetDSTag();
                return true;
            }
            case 24: {
                pSDEDataSetBase.resetDSTag2();
                return true;
            }
            case 25: {
                pSDEDataSetBase.resetDSTag3();
                return true;
            }
            case 26: {
                pSDEDataSetBase.resetDSTag4();
                return true;
            }
            case 27: {
                pSDEDataSetBase.resetDynaModelFlag();
                return true;
            }
            case 28: {
                pSDEDataSetBase.resetEnableAudit();
                return true;
            }
            case 29: {
                pSDEDataSetBase.resetEnableCache();
                return true;
            }
            case 30: {
                pSDEDataSetBase.resetEnableGroup();
                return true;
            }
            case 31: {
                pSDEDataSetBase.resetEnableOrgDR();
                return true;
            }
            case 32: {
                pSDEDataSetBase.resetEnableSecBC();
                return true;
            }
            case 33: {
                pSDEDataSetBase.resetEnableSecDR();
                return true;
            }
            case 34: {
                pSDEDataSetBase.resetEnableTempData();
                return true;
            }
            case 35: {
                pSDEDataSetBase.resetEnableUserDR();
                return true;
            }
            case 36: {
                pSDEDataSetBase.resetExtendMode();
                return true;
            }
            case 37: {
                pSDEDataSetBase.resetFilterModel();
                return true;
            }
            case 38: {
                pSDEDataSetBase.resetFinishFlag();
                return true;
            }
            case 39: {
                pSDEDataSetBase.resetInPSDEFGroupId();
                return true;
            }
            case 40: {
                pSDEDataSetBase.resetInPSDEFGroupName();
                return true;
            }
            case 41: {
                pSDEDataSetBase.resetInPSDESampleDataId();
                return true;
            }
            case 42: {
                pSDEDataSetBase.resetInPSDESampleDataName();
                return true;
            }
            case 43: {
                pSDEDataSetBase.resetInPSSysDynaModelId();
                return true;
            }
            case 44: {
                pSDEDataSetBase.resetInPSSysDynaModelName();
                return true;
            }
            case 45: {
                pSDEDataSetBase.resetLockFlag();
                return true;
            }
            case 46: {
                pSDEDataSetBase.resetLogicName();
                return true;
            }
            case 47: {
                pSDEDataSetBase.resetMajorPSDEFId();
                return true;
            }
            case 48: {
                pSDEDataSetBase.resetMajorPSDEFName();
                return true;
            }
            case 49: {
                pSDEDataSetBase.resetMajorSortDir();
                return true;
            }
            case 50: {
                pSDEDataSetBase.resetMemo();
                return true;
            }
            case 51: {
                pSDEDataSetBase.resetMinorPSDEFId();
                return true;
            }
            case 52: {
                pSDEDataSetBase.resetMinorPSDEFName();
                return true;
            }
            case 53: {
                pSDEDataSetBase.resetMinorSortDir();
                return true;
            }
            case 54: {
                pSDEDataSetBase.resetOrderValue();
                return true;
            }
            case 55: {
                pSDEDataSetBase.resetOrgDR();
                return true;
            }
            case 56: {
                pSDEDataSetBase.resetOutPSDEFGroupId();
                return true;
            }
            case 57: {
                pSDEDataSetBase.resetOutPSDEFGroupName();
                return true;
            }
            case 58: {
                pSDEDataSetBase.resetOutPSDESampleDataId();
                return true;
            }
            case 59: {
                pSDEDataSetBase.resetOutPSDESampleDataName();
                return true;
            }
            case 60: {
                pSDEDataSetBase.resetPageSize();
                return true;
            }
            case 61: {
                pSDEDataSetBase.resetParamType();
                return true;
            }
            case 62: {
                pSDEDataSetBase.resetPOTime();
                return true;
            }
            case 63: {
                pSDEDataSetBase.resetPredefinedTypeParam();
                return true;
            }
            case 64: {
                pSDEDataSetBase.resetPredefinedTypeText();
                return true;
            }
            case 65: {
                pSDEDataSetBase.resetPredefineType();
                return true;
            }
            case 66: {
                pSDEDataSetBase.resetPSCodeListId();
                return true;
            }
            case 67: {
                pSDEDataSetBase.resetPSCodeListName();
                return true;
            }
            case 68: {
                pSDEDataSetBase.resetPSDEDataImpId();
                return true;
            }
            case 69: {
                pSDEDataSetBase.resetPSDEDataImpName();
                return true;
            }
            case 70: {
                pSDEDataSetBase.resetPSDEDataSetId();
                return true;
            }
            case 71: {
                pSDEDataSetBase.resetPSDEDataSetName();
                return true;
            }
            case 72: {
                pSDEDataSetBase.resetPSDEId();
                return true;
            }
            case 73: {
                pSDEDataSetBase.resetPSDELogicId();
                return true;
            }
            case 74: {
                pSDEDataSetBase.resetPSDELogicName();
                return true;
            }
            case 75: {
                pSDEDataSetBase.resetPSDEName();
                return true;
            }
            case 76: {
                pSDEDataSetBase.resetPSDEOPPrivId();
                return true;
            }
            case 77: {
                pSDEDataSetBase.resetPSDEOPPrivName();
                return true;
            }
            case 78: {
                pSDEDataSetBase.resetPSDynaInstId();
                return true;
            }
            case 79: {
                pSDEDataSetBase.resetPSSubSysSADEId();
                return true;
            }
            case 80: {
                pSDEDataSetBase.resetPSSubSysSADetailId();
                return true;
            }
            case 81: {
                pSDEDataSetBase.resetPSSubSysSADetailName();
                return true;
            }
            case 82: {
                pSDEDataSetBase.resetPSSysPFPluginId();
                return true;
            }
            case 83: {
                pSDEDataSetBase.resetPSSysPFPluginName();
                return true;
            }
            case 84: {
                pSDEDataSetBase.resetPSSysReqItemId();
                return true;
            }
            case 85: {
                pSDEDataSetBase.resetPSSysReqItemName();
                return true;
            }
            case 86: {
                pSDEDataSetBase.resetPSSysSFPluginId();
                return true;
            }
            case 87: {
                pSDEDataSetBase.resetPSSysSFPluginName();
                return true;
            }
            case 88: {
                pSDEDataSetBase.resetPSSysTaskId();
                return true;
            }
            case 89: {
                pSDEDataSetBase.resetPSSysTaskName();
                return true;
            }
            case 90: {
                pSDEDataSetBase.resetPSSysUniStateId();
                return true;
            }
            case 91: {
                pSDEDataSetBase.resetPSSysUniStateName();
                return true;
            }
            case 92: {
                pSDEDataSetBase.resetPSSysUserDRId();
                return true;
            }
            case 93: {
                pSDEDataSetBase.resetPSSysUserDRId2();
                return true;
            }
            case 94: {
                pSDEDataSetBase.resetPSSysUserDRName();
                return true;
            }
            case 95: {
                pSDEDataSetBase.resetPSSysUserDRName2();
                return true;
            }
            case 96: {
                pSDEDataSetBase.resetPubMode();
                return true;
            }
            case 97: {
                pSDEDataSetBase.resetRawServiceMethod();
                return true;
            }
            case 98: {
                pSDEDataSetBase.resetRawServiceUrl();
                return true;
            }
            case 99: {
                pSDEDataSetBase.resetRequestMethod();
                return true;
            }
            case 100: {
                pSDEDataSetBase.resetRequestPath();
                return true;
            }
            case 101: {
                pSDEDataSetBase.resetRetValType();
                return true;
            }
            case 102: {
                pSDEDataSetBase.resetSecBC();
                return true;
            }
            case 103: {
                pSDEDataSetBase.resetSecDR();
                return true;
            }
            case 104: {
                pSDEDataSetBase.resetServiceCodeName();
                return true;
            }
            case 105: {
                pSDEDataSetBase.resetSubSysSADetailMode();
                return true;
            }
            case 106: {
                pSDEDataSetBase.resetSysUserDR2Param();
                return true;
            }
            case 107: {
                pSDEDataSetBase.resetSysUserDRParam();
                return true;
            }
            case 108: {
                pSDEDataSetBase.resetToDoTask();
                return true;
            }
            case 109: {
                pSDEDataSetBase.resetUnionMode();
                return true;
            }
            case 110: {
                pSDEDataSetBase.resetUpdateDate();
                return true;
            }
            case 111: {
                pSDEDataSetBase.resetUpdateMan();
                return true;
            }
            case 112: {
                pSDEDataSetBase.resetUserCat();
                return true;
            }
            case 113: {
                pSDEDataSetBase.resetUserParams();
                return true;
            }
            case 114: {
                pSDEDataSetBase.resetUserTag();
                return true;
            }
            case 115: {
                pSDEDataSetBase.resetUserTag2();
                return true;
            }
            case 116: {
                pSDEDataSetBase.resetUserTag3();
                return true;
            }
            case 117: {
                pSDEDataSetBase.resetUserTag4();
                return true;
            }
            case 118: {
                pSDEDataSetBase.resetValidFlag();
                return true;
            }
            case 119: {
                pSDEDataSetBase.resetViewColLevel();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCodeList getPSCodeList() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeList();
        }
        if (this.getPSCodeListId() == null) {
            return null;
        }
        Integer n = this.objPSCodeListLock;
        synchronized (n) {
            if (this.pscodelist != null && DataTypeHelper.compare((int)25, (Object)this.getPSCodeListId(), (Object)this.pscodelist.getPSCodeListId()) != 0L) {
                this.pscodelist = null;
            }
            if (this.pscodelist == null) {
                PSCodeList pSCodeList = new PSCodeList();
                pSCodeList.setPSCodeListId(this.getPSCodeListId());
                PSCodeListService pSCodeListService = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.getSessionFactory());
                pSCodeListService.autoGet(pSCodeList);
                this.pscodelist = pSCodeList;
            }
            return this.pscodelist;
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
    public PSDEDataImp getPSDEDataImp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataImp();
        }
        if (this.getPSDEDataImpId() == null) {
            return null;
        }
        Integer n = this.objPSDEDataImpLock;
        synchronized (n) {
            if (this.psdedataimp != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDataImpId(), (Object)this.psdedataimp.getPSDEDataImpId()) != 0L) {
                this.psdedataimp = null;
            }
            if (this.psdedataimp == null) {
                PSDEDataImp pSDEDataImp = new PSDEDataImp();
                pSDEDataImp.setPSDEDataImpId(this.getPSDEDataImpId());
                PSDEDataImpService pSDEDataImpService = (PSDEDataImpService)ServiceGlobal.getService(PSDEDataImpService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataImpService.autoGet(pSDEDataImp);
                this.psdedataimp = pSDEDataImp;
            }
            return this.psdedataimp;
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
    public PSDEField getMajorPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorPSDEF();
        }
        if (this.getMajorPSDEFId() == null) {
            return null;
        }
        Integer n = this.objMajorPSDEFLock;
        synchronized (n) {
            if (this.majorpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getMajorPSDEFId(), (Object)this.majorpsdef.getPSDEFieldId()) != 0L) {
                this.majorpsdef = null;
            }
            if (this.majorpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getMajorPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.majorpsdef = pSDEField;
            }
            return this.majorpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getMinorPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorPSDEF();
        }
        if (this.getMinorPSDEFId() == null) {
            return null;
        }
        Integer n = this.objMinorPSDEFLock;
        synchronized (n) {
            if (this.minorpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getMinorPSDEFId(), (Object)this.minorpsdef.getPSDEFieldId()) != 0L) {
                this.minorpsdef = null;
            }
            if (this.minorpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getMinorPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.minorpsdef = pSDEField;
            }
            return this.minorpsdef;
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
                pSDELogicService.autoGet(pSDELogic);
                this.adpsdelogic = pSDELogic;
            }
            return this.adpsdelogic;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDELogic getCacheStatePSDELogic() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCacheStatePSDELogic();
        }
        if (this.getCacheStatePSDELogicId() == null) {
            return null;
        }
        Integer n = this.objCacheStatePSDELogicLock;
        synchronized (n) {
            if (this.cachestatepsdelogic != null && DataTypeHelper.compare((int)25, (Object)this.getCacheStatePSDELogicId(), (Object)this.cachestatepsdelogic.getPSDELogicId()) != 0L) {
                this.cachestatepsdelogic = null;
            }
            if (this.cachestatepsdelogic == null) {
                PSDELogic pSDELogic = new PSDELogic();
                pSDELogic.setPSDELogicId(this.getCacheStatePSDELogicId());
                PSDELogicService pSDELogicService = (PSDELogicService)ServiceGlobal.getService(PSDELogicService.class, (SessionFactory)this.getSessionFactory());
                pSDELogicService.autoGet(pSDELogic);
                this.cachestatepsdelogic = pSDELogic;
            }
            return this.cachestatepsdelogic;
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
    public PSDER getAggDataPSDER() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAggDataPSDER();
        }
        if (this.getAggDataPSDERId() == null) {
            return null;
        }
        Integer n = this.objAggDataPSDERLock;
        synchronized (n) {
            if (this.aggdatapsder != null && DataTypeHelper.compare((int)25, (Object)this.getAggDataPSDERId(), (Object)this.aggdatapsder.getPSDERId()) != 0L) {
                this.aggdatapsder = null;
            }
            if (this.aggdatapsder == null) {
                PSDER pSDER = new PSDER();
                pSDER.setPSDERId(this.getAggDataPSDERId());
                PSDERService pSDERService = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)this.getSessionFactory());
                pSDERService.autoGet(pSDER);
                this.aggdatapsder = pSDER;
            }
            return this.aggdatapsder;
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
                pSSysUserDRService.autoGet(pSSysUserDR);
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
                pSSysUserDRService.autoGet(pSSysUserDR);
                this.pssysuserdr2 = pSSysUserDR;
            }
            return this.pssysuserdr2;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEDSDQ> getPSDEDSDQs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDSDQs();
        }
        if (this.getPSDEDataSetId() == null) {
            return null;
        }
        PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
        PSDEDSDQService pSDEDSDQService = (PSDEDSDQService)ServiceGlobal.getService(PSDEDSDQService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEDSDQsLock;
        synchronized (n) {
            if (this.psdedsdqs == null) {
                this.psdedsdqs = pSDEDataSetService.isTempData(this) ? pSDEDSDQService.selectTempByPSDEDataSet(this) : pSDEDSDQService.selectByPSDEDataSet(this);
            }
            return this.psdedsdqs;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEDSParam> getPSDEDSParams() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDSParams();
        }
        if (this.getPSDEDataSetId() == null) {
            return null;
        }
        PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
        PSDEDSParamService pSDEDSParamService = (PSDEDSParamService)ServiceGlobal.getService(PSDEDSParamService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEDSParamsLock;
        synchronized (n) {
            if (this.psdedsparams == null) {
                this.psdedsparams = pSDEDataSetService.isTempData(this) ? pSDEDSParamService.selectTempByPSDEDS(this) : pSDEDSParamService.selectByPSDEDS(this);
            }
            return this.psdedsparams;
        }
    }

    private PSDEDataSetBase getProxyEntity() {
        return this.proxyPSDEDataSetBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEDataSetBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEDataSetBase) {
            this.proxyPSDEDataSetBase = (PSDEDataSetBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ACTIONHOLDER, 0);
        fieldIndexMap.put(FIELD_ADPSDELOGICID, 1);
        fieldIndexMap.put(FIELD_ADPSDELOGICNAME, 2);
        fieldIndexMap.put(FIELD_AFTERCODE, 3);
        fieldIndexMap.put(FIELD_AGGDATAPSDERID, 4);
        fieldIndexMap.put(FIELD_AGGDATAPSDERNAME, 5);
        fieldIndexMap.put(FIELD_BEFORECODE, 6);
        fieldIndexMap.put(FIELD_CACHECAT, 7);
        fieldIndexMap.put(FIELD_CACHECHECKSTATE, 8);
        fieldIndexMap.put(FIELD_CACHESCOPE, 9);
        fieldIndexMap.put(FIELD_CACHESTATEPSDELOGICID, 10);
        fieldIndexMap.put(FIELD_CACHESTATEPSDELOGICNAME, 11);
        fieldIndexMap.put(FIELD_CACHETAG, 12);
        fieldIndexMap.put(FIELD_CACHETIMEOUT, 13);
        fieldIndexMap.put(FIELD_CODENAME, 14);
        fieldIndexMap.put(FIELD_CREATEDATE, 15);
        fieldIndexMap.put(FIELD_CREATEMAN, 16);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 17);
        fieldIndexMap.put(FIELD_CUSTOMMODE, 18);
        fieldIndexMap.put(FIELD_DATASETPARAMS, 19);
        fieldIndexMap.put(FIELD_DATASETSN, 20);
        fieldIndexMap.put(FIELD_DEFAULTMODE, 21);
        fieldIndexMap.put(FIELD_DSOPTION, 22);
        fieldIndexMap.put(FIELD_DSTAG, 23);
        fieldIndexMap.put(FIELD_DSTAG2, 24);
        fieldIndexMap.put(FIELD_DSTAG3, 25);
        fieldIndexMap.put(FIELD_DSTAG4, 26);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 27);
        fieldIndexMap.put(FIELD_ENABLEAUDIT, 28);
        fieldIndexMap.put(FIELD_ENABLECACHE, 29);
        fieldIndexMap.put(FIELD_ENABLEGROUP, 30);
        fieldIndexMap.put(FIELD_ENABLEORGDR, 31);
        fieldIndexMap.put(FIELD_ENABLESECBC, 32);
        fieldIndexMap.put(FIELD_ENABLESECDR, 33);
        fieldIndexMap.put(FIELD_ENABLETEMPDATA, 34);
        fieldIndexMap.put(FIELD_ENABLEUSERDR, 35);
        fieldIndexMap.put(FIELD_EXTENDMODE, 36);
        fieldIndexMap.put(FIELD_FILTERMODEL, 37);
        fieldIndexMap.put(FIELD_FINISHFLAG, 38);
        fieldIndexMap.put(FIELD_INPSDEFGROUPID, 39);
        fieldIndexMap.put(FIELD_INPSDEFGROUPNAME, 40);
        fieldIndexMap.put(FIELD_INPSDESAMPLEDATAID, 41);
        fieldIndexMap.put(FIELD_INPSDESAMPLEDATANAME, 42);
        fieldIndexMap.put(FIELD_INPSSYSDYNAMODELID, 43);
        fieldIndexMap.put(FIELD_INPSSYSDYNAMODELNAME, 44);
        fieldIndexMap.put(FIELD_LOCKFLAG, 45);
        fieldIndexMap.put(FIELD_LOGICNAME, 46);
        fieldIndexMap.put(FIELD_MAJORPSDEFID, 47);
        fieldIndexMap.put(FIELD_MAJORPSDEFNAME, 48);
        fieldIndexMap.put(FIELD_MAJORSORTDIR, 49);
        fieldIndexMap.put(FIELD_MEMO, 50);
        fieldIndexMap.put(FIELD_MINORPSDEFID, 51);
        fieldIndexMap.put(FIELD_MINORPSDEFNAME, 52);
        fieldIndexMap.put(FIELD_MINORSORTDIR, 53);
        fieldIndexMap.put(FIELD_ORDERVALUE, 54);
        fieldIndexMap.put(FIELD_ORGDR, 55);
        fieldIndexMap.put(FIELD_OUTPSDEFGROUPID, 56);
        fieldIndexMap.put(FIELD_OUTPSDEFGROUPNAME, 57);
        fieldIndexMap.put(FIELD_OUTPSDESAMPLEDATAID, 58);
        fieldIndexMap.put(FIELD_OUTPSDESAMPLEDATANAME, 59);
        fieldIndexMap.put(FIELD_PAGESIZE, 60);
        fieldIndexMap.put(FIELD_PARAMTYPE, 61);
        fieldIndexMap.put(FIELD_POTIME, 62);
        fieldIndexMap.put(FIELD_PREDEFINEDTYPEPARAM, 63);
        fieldIndexMap.put(FIELD_PREDEFINEDTYPETEXT, 64);
        fieldIndexMap.put(FIELD_PREDEFINETYPE, 65);
        fieldIndexMap.put(FIELD_PSCODELISTID, 66);
        fieldIndexMap.put(FIELD_PSCODELISTNAME, 67);
        fieldIndexMap.put(FIELD_PSDEDATAIMPID, 68);
        fieldIndexMap.put(FIELD_PSDEDATAIMPNAME, 69);
        fieldIndexMap.put(FIELD_PSDEDATASETID, 70);
        fieldIndexMap.put(FIELD_PSDEDATASETNAME, 71);
        fieldIndexMap.put(FIELD_PSDEID, 72);
        fieldIndexMap.put(FIELD_PSDELOGICID, 73);
        fieldIndexMap.put(FIELD_PSDELOGICNAME, 74);
        fieldIndexMap.put(FIELD_PSDENAME, 75);
        fieldIndexMap.put(FIELD_PSDEOPPRIVID, 76);
        fieldIndexMap.put(FIELD_PSDEOPPRIVNAME, 77);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 78);
        fieldIndexMap.put(FIELD_PSSUBSYSSADEID, 79);
        fieldIndexMap.put(FIELD_PSSUBSYSSADETAILID, 80);
        fieldIndexMap.put(FIELD_PSSUBSYSSADETAILNAME, 81);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 82);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 83);
        fieldIndexMap.put(FIELD_PSSYSREQITEMID, 84);
        fieldIndexMap.put(FIELD_PSSYSREQITEMNAME, 85);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 86);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 87);
        fieldIndexMap.put(FIELD_PSSYSTASKID, 88);
        fieldIndexMap.put(FIELD_PSSYSTASKNAME, 89);
        fieldIndexMap.put(FIELD_PSSYSUNISTATEID, 90);
        fieldIndexMap.put(FIELD_PSSYSUNISTATENAME, 91);
        fieldIndexMap.put(FIELD_PSSYSUSERDRID, 92);
        fieldIndexMap.put(FIELD_PSSYSUSERDRID2, 93);
        fieldIndexMap.put(FIELD_PSSYSUSERDRNAME, 94);
        fieldIndexMap.put(FIELD_PSSYSUSERDRNAME2, 95);
        fieldIndexMap.put(FIELD_PUBMODE, 96);
        fieldIndexMap.put(FIELD_RAWSERVICEMETHOD, 97);
        fieldIndexMap.put(FIELD_RAWSERVICEURL, 98);
        fieldIndexMap.put(FIELD_REQUESTMETHOD, 99);
        fieldIndexMap.put(FIELD_REQUESTPATH, 100);
        fieldIndexMap.put(FIELD_RETVALTYPE, 101);
        fieldIndexMap.put(FIELD_SECBC, 102);
        fieldIndexMap.put(FIELD_SECDR, 103);
        fieldIndexMap.put(FIELD_SERVICECODENAME, 104);
        fieldIndexMap.put(FIELD_SUBSYSSADETAILMODE, 105);
        fieldIndexMap.put(FIELD_SYSUSERDR2PARAM, 106);
        fieldIndexMap.put(FIELD_SYSUSERDRPARAM, 107);
        fieldIndexMap.put(FIELD_TODOTASK, 108);
        fieldIndexMap.put(FIELD_UNIONMODE, 109);
        fieldIndexMap.put(FIELD_UPDATEDATE, 110);
        fieldIndexMap.put(FIELD_UPDATEMAN, 111);
        fieldIndexMap.put(FIELD_USERCAT, 112);
        fieldIndexMap.put(FIELD_USERPARAMS, 113);
        fieldIndexMap.put(FIELD_USERTAG, 114);
        fieldIndexMap.put(FIELD_USERTAG2, 115);
        fieldIndexMap.put(FIELD_USERTAG3, 116);
        fieldIndexMap.put(FIELD_USERTAG4, 117);
        fieldIndexMap.put(FIELD_VALIDFLAG, 118);
        fieldIndexMap.put(FIELD_VIEWCOLLEVEL, 119);
    }
}

