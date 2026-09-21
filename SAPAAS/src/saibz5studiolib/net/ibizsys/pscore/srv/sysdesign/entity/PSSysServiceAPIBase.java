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
import net.ibizsys.pscore.srv.config.entity.PSSysResource;
import net.ibizsys.pscore.srv.config.service.PSSysResourceService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPriv;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEServiceAPI;
import net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEServiceAPIService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDESARS;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSAHandler;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTranslator;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSDESARSService;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSAHandlerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysTranslatorService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysServiceAPIBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysServiceAPIBase.class);
    public static final String FIELD_APILEVEL = "APILEVEL";
    public static final String FIELD_APIMODE = "APIMODE";
    public static final String FIELD_APITAG = "APITAG";
    public static final String FIELD_APITAG2 = "APITAG2";
    public static final String FIELD_APITYPE = "APITYPE";
    public static final String FIELD_AUTHCHECKTOKENURI = "AUTHCHECKTOKENURI";
    public static final String FIELD_AUTHCLIENTID = "AUTHCLIENTID";
    public static final String FIELD_AUTHCLIENTSECRET = "AUTHCLIENTSECRET";
    public static final String FIELD_AUTHMODE = "AUTHMODE";
    public static final String FIELD_AUTHPARAM = "AUTHPARAM";
    public static final String FIELD_AUTHPARAM2 = "AUTHPARAM2";
    public static final String FIELD_AUTHPARAM3 = "AUTHPARAM3";
    public static final String FIELD_AUTHPARAM4 = "AUTHPARAM4";
    public static final String FIELD_BASECLSPARAMS = "BASECLSPARAMS";
    public static final String FIELD_CFGPSMODELSTORAGEID = "CFGPSMODELSTORAGEID";
    public static final String FIELD_CFGTAG = "CFGTAG";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CODENAMEMODE = "CODENAMEMODE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_CUSTOMMODE = "CUSTOMMODE";
    public static final String FIELD_DEFAULTPORT = "DEFAULTPORT";
    public static final String FIELD_DEFAULTPSDEOPPRIVID = "DEFAULTPSDEOPPRIVID";
    public static final String FIELD_DEFAULTPSDEOPPRIVNAME = "DEFAULTPSDEOPPRIVNAME";
    public static final String FIELD_DEFCREATEREQMETHOD = "DEFCREATEREQMETHOD";
    public static final String FIELD_DEFDEACTIONREQMETHOD = "DEFDEACTIONREQMETHOD";
    public static final String FIELD_DEFDEDATASETREQMETHOD = "DEFDEDATASETREQMETHOD";
    public static final String FIELD_DEFDELETEREQMETHOD = "DEFDELETEREQMETHOD";
    public static final String FIELD_DEFGETDRAFTREQMETHOD = "DEFGETDRAFTREQMETHOD";
    public static final String FIELD_DEFGETREQMETHOD = "DEFGETREQMETHOD";
    public static final String FIELD_DEFNEEDRESOURCEKEY = "DEFNEEDRESOURCEKEY";
    public static final String FIELD_DEFSELECTREQMETHOD = "DEFSELECTREQMETHOD";
    public static final String FIELD_DEFUPDATEREQMETHOD = "DEFUPDATEREQMETHOD";
    public static final String FIELD_DEPSSYSSFPLUGINID = "DEPSSYSSFPLUGINID";
    public static final String FIELD_DEPSSYSSFPLUGINNAME = "DEPSSYSSFPLUGINNAME";
    public static final String FIELD_ENABLEAPIMODELEX = "ENABLEAPIMODELEX";
    public static final String FIELD_ENABLEGATEWAY = "ENABLEGATEWAY";
    public static final String FIELD_IGNOREAUTHPATTERNS = "IGNOREAUTHPATTERNS";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_NAMINGSERVICE = "NAMINGSERVICE";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_OUTPSSYSTRANSLATORID = "OUTPSSYSTRANSLATORID";
    public static final String FIELD_OUTPSSYSTRANSLATORNAME = "OUTPSSYSTRANSLATORNAME";
    public static final String FIELD_PREDEFINEDTYPE = "PREDEFINEDTYPE";
    public static final String FIELD_PSDEVSLNSYSAPIID = "PSDEVSLNSYSAPIID";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSREQITEMID = "PSSYSREQITEMID";
    public static final String FIELD_PSSYSREQITEMNAME = "PSSYSREQITEMNAME";
    public static final String FIELD_PSSYSRESOURCEID = "PSSYSRESOURCEID";
    public static final String FIELD_PSSYSRESOURCENAME = "PSSYSRESOURCENAME";
    public static final String FIELD_PSSYSSAHANDLERID = "PSSYSSAHANDLERID";
    public static final String FIELD_PSSYSSAHANDLERNAME = "PSSYSSAHANDLERNAME";
    public static final String FIELD_PSSYSSERVICEAPIID = "PSSYSSERVICEAPIID";
    public static final String FIELD_PSSYSSERVICEAPINAME = "PSSYSSERVICEAPINAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_RESETDEFACTIONCODENAME = "RESETDEFACTIONCODENAME";
    public static final String FIELD_SERVICECODENAME = "SERVICECODENAME";
    public static final String FIELD_SERVICEDTOFLAG = "SERVICEDTOFLAG";
    public static final String FIELD_SERVICEPARAM = "SERVICEPARAM";
    public static final String FIELD_SERVICEPARAM2 = "SERVICEPARAM2";
    public static final String FIELD_SERVICEPARAM3 = "SERVICEPARAM3";
    public static final String FIELD_SERVICEPARAM4 = "SERVICEPARAM4";
    public static final String FIELD_SERVICEPARAMS = "SERVICEPARAMS";
    public static final String FIELD_SERVICETYPE = "SERVICETYPE";
    public static final String FIELD_UNIQUETAG = "UNIQUETAG";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_VER = "VER";
    private static final int INDEX_APILEVEL = 0;
    private static final int INDEX_APIMODE = 1;
    private static final int INDEX_APITAG = 2;
    private static final int INDEX_APITAG2 = 3;
    private static final int INDEX_APITYPE = 4;
    private static final int INDEX_AUTHCHECKTOKENURI = 5;
    private static final int INDEX_AUTHCLIENTID = 6;
    private static final int INDEX_AUTHCLIENTSECRET = 7;
    private static final int INDEX_AUTHMODE = 8;
    private static final int INDEX_AUTHPARAM = 9;
    private static final int INDEX_AUTHPARAM2 = 10;
    private static final int INDEX_AUTHPARAM3 = 11;
    private static final int INDEX_AUTHPARAM4 = 12;
    private static final int INDEX_BASECLSPARAMS = 13;
    private static final int INDEX_CFGPSMODELSTORAGEID = 14;
    private static final int INDEX_CFGTAG = 15;
    private static final int INDEX_CODENAME = 16;
    private static final int INDEX_CODENAMEMODE = 17;
    private static final int INDEX_CREATEDATE = 18;
    private static final int INDEX_CREATEMAN = 19;
    private static final int INDEX_CUSTOMCODE = 20;
    private static final int INDEX_CUSTOMMODE = 21;
    private static final int INDEX_DEFAULTPORT = 22;
    private static final int INDEX_DEFAULTPSDEOPPRIVID = 23;
    private static final int INDEX_DEFAULTPSDEOPPRIVNAME = 24;
    private static final int INDEX_DEFCREATEREQMETHOD = 25;
    private static final int INDEX_DEFDEACTIONREQMETHOD = 26;
    private static final int INDEX_DEFDEDATASETREQMETHOD = 27;
    private static final int INDEX_DEFDELETEREQMETHOD = 28;
    private static final int INDEX_DEFGETDRAFTREQMETHOD = 29;
    private static final int INDEX_DEFGETREQMETHOD = 30;
    private static final int INDEX_DEFNEEDRESOURCEKEY = 31;
    private static final int INDEX_DEFSELECTREQMETHOD = 32;
    private static final int INDEX_DEFUPDATEREQMETHOD = 33;
    private static final int INDEX_DEPSSYSSFPLUGINID = 34;
    private static final int INDEX_DEPSSYSSFPLUGINNAME = 35;
    private static final int INDEX_ENABLEAPIMODELEX = 36;
    private static final int INDEX_ENABLEGATEWAY = 37;
    private static final int INDEX_IGNOREAUTHPATTERNS = 38;
    private static final int INDEX_LOCKFLAG = 39;
    private static final int INDEX_MEMO = 40;
    private static final int INDEX_NAMINGSERVICE = 41;
    private static final int INDEX_ORDERVALUE = 42;
    private static final int INDEX_OUTPSSYSTRANSLATORID = 43;
    private static final int INDEX_OUTPSSYSTRANSLATORNAME = 44;
    private static final int INDEX_PREDEFINEDTYPE = 45;
    private static final int INDEX_PSDEVSLNSYSAPIID = 46;
    private static final int INDEX_PSMODULEID = 47;
    private static final int INDEX_PSMODULENAME = 48;
    private static final int INDEX_PSSYSDYNAMODELID = 49;
    private static final int INDEX_PSSYSDYNAMODELNAME = 50;
    private static final int INDEX_PSSYSREQITEMID = 51;
    private static final int INDEX_PSSYSREQITEMNAME = 52;
    private static final int INDEX_PSSYSRESOURCEID = 53;
    private static final int INDEX_PSSYSRESOURCENAME = 54;
    private static final int INDEX_PSSYSSAHANDLERID = 55;
    private static final int INDEX_PSSYSSAHANDLERNAME = 56;
    private static final int INDEX_PSSYSSERVICEAPIID = 57;
    private static final int INDEX_PSSYSSERVICEAPINAME = 58;
    private static final int INDEX_PSSYSSFPLUGINID = 59;
    private static final int INDEX_PSSYSSFPLUGINNAME = 60;
    private static final int INDEX_PSSYSTEMID = 61;
    private static final int INDEX_PSSYSTEMNAME = 62;
    private static final int INDEX_RESETDEFACTIONCODENAME = 63;
    private static final int INDEX_SERVICECODENAME = 64;
    private static final int INDEX_SERVICEDTOFLAG = 65;
    private static final int INDEX_SERVICEPARAM = 66;
    private static final int INDEX_SERVICEPARAM2 = 67;
    private static final int INDEX_SERVICEPARAM3 = 68;
    private static final int INDEX_SERVICEPARAM4 = 69;
    private static final int INDEX_SERVICEPARAMS = 70;
    private static final int INDEX_SERVICETYPE = 71;
    private static final int INDEX_UNIQUETAG = 72;
    private static final int INDEX_UPDATEDATE = 73;
    private static final int INDEX_UPDATEMAN = 74;
    private static final int INDEX_USERCAT = 75;
    private static final int INDEX_USERTAG = 76;
    private static final int INDEX_USERTAG2 = 77;
    private static final int INDEX_USERTAG3 = 78;
    private static final int INDEX_USERTAG4 = 79;
    private static final int INDEX_VALIDFLAG = 80;
    private static final int INDEX_VER = 81;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysServiceAPIBase proxyPSSysServiceAPIBase = null;
    private boolean apilevelDirtyFlag = false;
    private boolean apimodeDirtyFlag = false;
    private boolean apitagDirtyFlag = false;
    private boolean apitag2DirtyFlag = false;
    private boolean apitypeDirtyFlag = false;
    private boolean authchecktokenuriDirtyFlag = false;
    private boolean authclientidDirtyFlag = false;
    private boolean authclientsecretDirtyFlag = false;
    private boolean authmodeDirtyFlag = false;
    private boolean authparamDirtyFlag = false;
    private boolean authparam2DirtyFlag = false;
    private boolean authparam3DirtyFlag = false;
    private boolean authparam4DirtyFlag = false;
    private boolean baseclsparamsDirtyFlag = false;
    private boolean cfgpsmodelstorageidDirtyFlag = false;
    private boolean cfgtagDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean codenamemodeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean custommodeDirtyFlag = false;
    private boolean defaultportDirtyFlag = false;
    private boolean defaultpsdeopprividDirtyFlag = false;
    private boolean defaultpsdeopprivnameDirtyFlag = false;
    private boolean defcreatereqmethodDirtyFlag = false;
    private boolean defdeactionreqmethodDirtyFlag = false;
    private boolean defdedatasetreqmethodDirtyFlag = false;
    private boolean defdeletereqmethodDirtyFlag = false;
    private boolean defgetdraftreqmethodDirtyFlag = false;
    private boolean defgetreqmethodDirtyFlag = false;
    private boolean defneedresourcekeyDirtyFlag = false;
    private boolean defselectreqmethodDirtyFlag = false;
    private boolean defupdatereqmethodDirtyFlag = false;
    private boolean depssyssfpluginidDirtyFlag = false;
    private boolean depssyssfpluginnameDirtyFlag = false;
    private boolean enableapimodelexDirtyFlag = false;
    private boolean enablegatewayDirtyFlag = false;
    private boolean ignoreauthpatternsDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean namingserviceDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean outpssystranslatoridDirtyFlag = false;
    private boolean outpssystranslatornameDirtyFlag = false;
    private boolean predefinedtypeDirtyFlag = false;
    private boolean psdevslnsysapiidDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssysreqitemidDirtyFlag = false;
    private boolean pssysreqitemnameDirtyFlag = false;
    private boolean pssysresourceidDirtyFlag = false;
    private boolean pssysresourcenameDirtyFlag = false;
    private boolean pssyssahandleridDirtyFlag = false;
    private boolean pssyssahandlernameDirtyFlag = false;
    private boolean pssysserviceapiidDirtyFlag = false;
    private boolean pssysserviceapinameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean resetdefactioncodenameDirtyFlag = false;
    private boolean servicecodenameDirtyFlag = false;
    private boolean servicedtoflagDirtyFlag = false;
    private boolean serviceparamDirtyFlag = false;
    private boolean serviceparam2DirtyFlag = false;
    private boolean serviceparam3DirtyFlag = false;
    private boolean serviceparam4DirtyFlag = false;
    private boolean serviceparamsDirtyFlag = false;
    private boolean servicetypeDirtyFlag = false;
    private boolean uniquetagDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean verDirtyFlag = false;
    @Column(name="apilevel")
    private Integer apilevel;
    @Column(name="apimode")
    private Integer apimode;
    @Column(name="apitag")
    private String apitag;
    @Column(name="apitag2")
    private String apitag2;
    @Column(name="apitype")
    private String apitype;
    @Column(name="authchecktokenuri")
    private String authchecktokenuri;
    @Column(name="authclientid")
    private String authclientid;
    @Column(name="authclientsecret")
    private String authclientsecret;
    @Column(name="authmode")
    private String authmode;
    @Column(name="authparam")
    private String authparam;
    @Column(name="authparam2")
    private String authparam2;
    @Column(name="authparam3")
    private String authparam3;
    @Column(name="authparam4")
    private String authparam4;
    @Column(name="baseclsparams")
    private String baseclsparams;
    @Column(name="cfgpsmodelstorageid")
    private String cfgpsmodelstorageid;
    @Column(name="cfgtag")
    private String cfgtag;
    @Column(name="codename")
    private String codename;
    @Column(name="codenamemode")
    private String codenamemode;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customcode")
    private String customcode;
    @Column(name="custommode")
    private Integer custommode;
    @Column(name="defaultport")
    private Integer defaultport;
    @Column(name="defaultpsdeopprivid")
    private String defaultpsdeopprivid;
    @Column(name="defaultpsdeopprivname")
    private String defaultpsdeopprivname;
    @Column(name="defcreatereqmethod")
    private String defcreatereqmethod;
    @Column(name="defdeactionreqmethod")
    private String defdeactionreqmethod;
    @Column(name="defdedatasetreqmethod")
    private String defdedatasetreqmethod;
    @Column(name="defdeletereqmethod")
    private String defdeletereqmethod;
    @Column(name="defgetdraftreqmethod")
    private String defgetdraftreqmethod;
    @Column(name="defgetreqmethod")
    private String defgetreqmethod;
    @Column(name="defneedresourcekey")
    private Integer defneedresourcekey;
    @Column(name="defselectreqmethod")
    private String defselectreqmethod;
    @Column(name="defupdatereqmethod")
    private String defupdatereqmethod;
    @Column(name="depssyssfpluginid")
    private String depssyssfpluginid;
    @Column(name="depssyssfpluginname")
    private String depssyssfpluginname;
    @Column(name="enableapimodelex")
    private Integer enableapimodelex;
    @Column(name="enablegateway")
    private Integer enablegateway;
    @Column(name="ignoreauthpatterns")
    private String ignoreauthpatterns;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
    @Column(name="namingservice")
    private String namingservice;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="outpssystranslatorid")
    private String outpssystranslatorid;
    @Column(name="outpssystranslatorname")
    private String outpssystranslatorname;
    @Column(name="predefinedtype")
    private String predefinedtype;
    @Column(name="psdevslnsysapiid")
    private String psdevslnsysapiid;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssysreqitemid")
    private String pssysreqitemid;
    @Column(name="pssysreqitemname")
    private String pssysreqitemname;
    @Column(name="pssysresourceid")
    private String pssysresourceid;
    @Column(name="pssysresourcename")
    private String pssysresourcename;
    @Column(name="pssyssahandlerid")
    private String pssyssahandlerid;
    @Column(name="pssyssahandlername")
    private String pssyssahandlername;
    @Column(name="pssysserviceapiid")
    private String pssysserviceapiid;
    @Column(name="pssysserviceapiname")
    private String pssysserviceapiname;
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="resetdefactioncodename")
    private Integer resetdefactioncodename;
    @Column(name="servicecodename")
    private String servicecodename;
    @Column(name="servicedtoflag")
    private Integer servicedtoflag;
    @Column(name="serviceparam")
    private String serviceparam;
    @Column(name="serviceparam2")
    private String serviceparam2;
    @Column(name="serviceparam3")
    private String serviceparam3;
    @Column(name="serviceparam4")
    private String serviceparam4;
    @Column(name="serviceparams")
    private String serviceparams;
    @Column(name="servicetype")
    private String servicetype;
    @Column(name="uniquetag")
    private String uniquetag;
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
    @Column(name="ver")
    private Integer ver;
    private Integer objDefaultPSDEOPPrivLock = new Integer(1);
    private PSDEOPPriv defaultpsdeoppriv = null;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSysReqItemLock = new Integer(1);
    private PSSysReqItem pssysreqitem = null;
    private Integer objPSSysResourceLock = new Integer(1);
    private PSSysResource pssysresource = null;
    private Integer objPSSysSAHandlerLock = new Integer(1);
    private PSSysSAHandler pssyssahandler = null;
    private Integer objDEPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin depssyssfplugin = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objOutPSSysTranslatorLock = new Integer(1);
    private PSSysTranslator outpssystranslator = null;
    private Integer objPSDESARSesLock = new Integer(1);
    private ArrayList<PSDESARS> psdesarses = null;
    private Integer objPSDEServiceAPIsLock = new Integer(1);
    private ArrayList<PSDEServiceAPI> psdeserviceapis = null;

    public void setAPILevel(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAPILevel(n);
            return;
        }
        this.apilevel = n;
        this.apilevelDirtyFlag = true;
    }

    public Integer getAPILevel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAPILevel();
        }
        return this.apilevel;
    }

    public boolean isAPILevelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAPILevelDirty();
        }
        return this.apilevelDirtyFlag;
    }

    public void resetAPILevel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAPILevel();
            return;
        }
        this.apilevelDirtyFlag = false;
        this.apilevel = null;
    }

    public void setAPIMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAPIMode(n);
            return;
        }
        this.apimode = n;
        this.apimodeDirtyFlag = true;
    }

    public Integer getAPIMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAPIMode();
        }
        return this.apimode;
    }

    public boolean isAPIModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAPIModeDirty();
        }
        return this.apimodeDirtyFlag;
    }

    public void resetAPIMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAPIMode();
            return;
        }
        this.apimodeDirtyFlag = false;
        this.apimode = null;
    }

    public void setAPITag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAPITag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.apitag = string;
        this.apitagDirtyFlag = true;
    }

    public String getAPITag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAPITag();
        }
        return this.apitag;
    }

    public boolean isAPITagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAPITagDirty();
        }
        return this.apitagDirtyFlag;
    }

    public void resetAPITag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAPITag();
            return;
        }
        this.apitagDirtyFlag = false;
        this.apitag = null;
    }

    public void setAPITag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAPITag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.apitag2 = string;
        this.apitag2DirtyFlag = true;
    }

    public String getAPITag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAPITag2();
        }
        return this.apitag2;
    }

    public boolean isAPITag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAPITag2Dirty();
        }
        return this.apitag2DirtyFlag;
    }

    public void resetAPITag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAPITag2();
            return;
        }
        this.apitag2DirtyFlag = false;
        this.apitag2 = null;
    }

    public void setAPIType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAPIType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.apitype = string;
        this.apitypeDirtyFlag = true;
    }

    public String getAPIType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAPIType();
        }
        return this.apitype;
    }

    public boolean isAPITypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAPITypeDirty();
        }
        return this.apitypeDirtyFlag;
    }

    public void resetAPIType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAPIType();
            return;
        }
        this.apitypeDirtyFlag = false;
        this.apitype = null;
    }

    public void setAuthCheckTokenUri(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAuthCheckTokenUri(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.authchecktokenuri = string;
        this.authchecktokenuriDirtyFlag = true;
    }

    public String getAuthCheckTokenUri() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAuthCheckTokenUri();
        }
        return this.authchecktokenuri;
    }

    public boolean isAuthCheckTokenUriDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAuthCheckTokenUriDirty();
        }
        return this.authchecktokenuriDirtyFlag;
    }

    public void resetAuthCheckTokenUri() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAuthCheckTokenUri();
            return;
        }
        this.authchecktokenuriDirtyFlag = false;
        this.authchecktokenuri = null;
    }

    public void setAuthClientId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAuthClientId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.authclientid = string;
        this.authclientidDirtyFlag = true;
    }

    public String getAuthClientId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAuthClientId();
        }
        return this.authclientid;
    }

    public boolean isAuthClientIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAuthClientIdDirty();
        }
        return this.authclientidDirtyFlag;
    }

    public void resetAuthClientId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAuthClientId();
            return;
        }
        this.authclientidDirtyFlag = false;
        this.authclientid = null;
    }

    public void setAuthClientSecret(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAuthClientSecret(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.authclientsecret = string;
        this.authclientsecretDirtyFlag = true;
    }

    public String getAuthClientSecret() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAuthClientSecret();
        }
        return this.authclientsecret;
    }

    public boolean isAuthClientSecretDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAuthClientSecretDirty();
        }
        return this.authclientsecretDirtyFlag;
    }

    public void resetAuthClientSecret() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAuthClientSecret();
            return;
        }
        this.authclientsecretDirtyFlag = false;
        this.authclientsecret = null;
    }

    public void setAuthMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAuthMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.authmode = string;
        this.authmodeDirtyFlag = true;
    }

    public String getAuthMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAuthMode();
        }
        return this.authmode;
    }

    public boolean isAuthModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAuthModeDirty();
        }
        return this.authmodeDirtyFlag;
    }

    public void resetAuthMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAuthMode();
            return;
        }
        this.authmodeDirtyFlag = false;
        this.authmode = null;
    }

    public void setAuthParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAuthParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.authparam = string;
        this.authparamDirtyFlag = true;
    }

    public String getAuthParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAuthParam();
        }
        return this.authparam;
    }

    public boolean isAuthParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAuthParamDirty();
        }
        return this.authparamDirtyFlag;
    }

    public void resetAuthParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAuthParam();
            return;
        }
        this.authparamDirtyFlag = false;
        this.authparam = null;
    }

    public void setAuthParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAuthParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.authparam2 = string;
        this.authparam2DirtyFlag = true;
    }

    public String getAuthParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAuthParam2();
        }
        return this.authparam2;
    }

    public boolean isAuthParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAuthParam2Dirty();
        }
        return this.authparam2DirtyFlag;
    }

    public void resetAuthParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAuthParam2();
            return;
        }
        this.authparam2DirtyFlag = false;
        this.authparam2 = null;
    }

    public void setAuthParam3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAuthParam3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.authparam3 = string;
        this.authparam3DirtyFlag = true;
    }

    public String getAuthParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAuthParam3();
        }
        return this.authparam3;
    }

    public boolean isAuthParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAuthParam3Dirty();
        }
        return this.authparam3DirtyFlag;
    }

    public void resetAuthParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAuthParam3();
            return;
        }
        this.authparam3DirtyFlag = false;
        this.authparam3 = null;
    }

    public void setAuthParam4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAuthParam4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.authparam4 = string;
        this.authparam4DirtyFlag = true;
    }

    public String getAuthParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAuthParam4();
        }
        return this.authparam4;
    }

    public boolean isAuthParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAuthParam4Dirty();
        }
        return this.authparam4DirtyFlag;
    }

    public void resetAuthParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAuthParam4();
            return;
        }
        this.authparam4DirtyFlag = false;
        this.authparam4 = null;
    }

    public void setBaseClsParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBaseClsParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.baseclsparams = string;
        this.baseclsparamsDirtyFlag = true;
    }

    public String getBaseClsParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBaseClsParams();
        }
        return this.baseclsparams;
    }

    public boolean isBaseClsParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBaseClsParamsDirty();
        }
        return this.baseclsparamsDirtyFlag;
    }

    public void resetBaseClsParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBaseClsParams();
            return;
        }
        this.baseclsparamsDirtyFlag = false;
        this.baseclsparams = null;
    }

    public void setCfgPSModelStorageId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCfgPSModelStorageId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cfgpsmodelstorageid = string;
        this.cfgpsmodelstorageidDirtyFlag = true;
    }

    public String getCfgPSModelStorageId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCfgPSModelStorageId();
        }
        return this.cfgpsmodelstorageid;
    }

    public boolean isCfgPSModelStorageIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCfgPSModelStorageIdDirty();
        }
        return this.cfgpsmodelstorageidDirtyFlag;
    }

    public void resetCfgPSModelStorageId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCfgPSModelStorageId();
            return;
        }
        this.cfgpsmodelstorageidDirtyFlag = false;
        this.cfgpsmodelstorageid = null;
    }

    public void setCfgTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCfgTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cfgtag = string;
        this.cfgtagDirtyFlag = true;
    }

    public String getCfgTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCfgTag();
        }
        return this.cfgtag;
    }

    public boolean isCfgTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCfgTagDirty();
        }
        return this.cfgtagDirtyFlag;
    }

    public void resetCfgTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCfgTag();
            return;
        }
        this.cfgtagDirtyFlag = false;
        this.cfgtag = null;
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

    public void setCodeNameMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeNameMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codenamemode = string;
        this.codenamemodeDirtyFlag = true;
    }

    public String getCodeNameMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeNameMode();
        }
        return this.codenamemode;
    }

    public boolean isCodeNameModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeNameModeDirty();
        }
        return this.codenamemodeDirtyFlag;
    }

    public void resetCodeNameMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeNameMode();
            return;
        }
        this.codenamemodeDirtyFlag = false;
        this.codenamemode = null;
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

    public void setDefaultPort(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultPort(n);
            return;
        }
        this.defaultport = n;
        this.defaultportDirtyFlag = true;
    }

    public Integer getDefaultPort() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultPort();
        }
        return this.defaultport;
    }

    public boolean isDefaultPortDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultPortDirty();
        }
        return this.defaultportDirtyFlag;
    }

    public void resetDefaultPort() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultPort();
            return;
        }
        this.defaultportDirtyFlag = false;
        this.defaultport = null;
    }

    public void setDefaultPSDEOPPrivId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultPSDEOPPrivId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.defaultpsdeopprivid = string;
        this.defaultpsdeopprividDirtyFlag = true;
    }

    public String getDefaultPSDEOPPrivId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultPSDEOPPrivId();
        }
        return this.defaultpsdeopprivid;
    }

    public boolean isDefaultPSDEOPPrivIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultPSDEOPPrivIdDirty();
        }
        return this.defaultpsdeopprividDirtyFlag;
    }

    public void resetDefaultPSDEOPPrivId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultPSDEOPPrivId();
            return;
        }
        this.defaultpsdeopprividDirtyFlag = false;
        this.defaultpsdeopprivid = null;
    }

    public void setDefaultPSDEOPPrivName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultPSDEOPPrivName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.defaultpsdeopprivname = string;
        this.defaultpsdeopprivnameDirtyFlag = true;
    }

    public String getDefaultPSDEOPPrivName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultPSDEOPPrivName();
        }
        return this.defaultpsdeopprivname;
    }

    public boolean isDefaultPSDEOPPrivNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultPSDEOPPrivNameDirty();
        }
        return this.defaultpsdeopprivnameDirtyFlag;
    }

    public void resetDefaultPSDEOPPrivName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultPSDEOPPrivName();
            return;
        }
        this.defaultpsdeopprivnameDirtyFlag = false;
        this.defaultpsdeopprivname = null;
    }

    public void setDefCreateReqMethod(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefCreateReqMethod(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.defcreatereqmethod = string;
        this.defcreatereqmethodDirtyFlag = true;
    }

    public String getDefCreateReqMethod() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefCreateReqMethod();
        }
        return this.defcreatereqmethod;
    }

    public boolean isDefCreateReqMethodDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefCreateReqMethodDirty();
        }
        return this.defcreatereqmethodDirtyFlag;
    }

    public void resetDefCreateReqMethod() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefCreateReqMethod();
            return;
        }
        this.defcreatereqmethodDirtyFlag = false;
        this.defcreatereqmethod = null;
    }

    public void setDefDEActionReqMethod(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefDEActionReqMethod(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.defdeactionreqmethod = string;
        this.defdeactionreqmethodDirtyFlag = true;
    }

    public String getDefDEActionReqMethod() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefDEActionReqMethod();
        }
        return this.defdeactionreqmethod;
    }

    public boolean isDefDEActionReqMethodDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefDEActionReqMethodDirty();
        }
        return this.defdeactionreqmethodDirtyFlag;
    }

    public void resetDefDEActionReqMethod() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefDEActionReqMethod();
            return;
        }
        this.defdeactionreqmethodDirtyFlag = false;
        this.defdeactionreqmethod = null;
    }

    public void setDefDEDataSetReqMethod(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefDEDataSetReqMethod(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.defdedatasetreqmethod = string;
        this.defdedatasetreqmethodDirtyFlag = true;
    }

    public String getDefDEDataSetReqMethod() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefDEDataSetReqMethod();
        }
        return this.defdedatasetreqmethod;
    }

    public boolean isDefDEDataSetReqMethodDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefDEDataSetReqMethodDirty();
        }
        return this.defdedatasetreqmethodDirtyFlag;
    }

    public void resetDefDEDataSetReqMethod() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefDEDataSetReqMethod();
            return;
        }
        this.defdedatasetreqmethodDirtyFlag = false;
        this.defdedatasetreqmethod = null;
    }

    public void setDefDeleteReqMethod(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefDeleteReqMethod(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.defdeletereqmethod = string;
        this.defdeletereqmethodDirtyFlag = true;
    }

    public String getDefDeleteReqMethod() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefDeleteReqMethod();
        }
        return this.defdeletereqmethod;
    }

    public boolean isDefDeleteReqMethodDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefDeleteReqMethodDirty();
        }
        return this.defdeletereqmethodDirtyFlag;
    }

    public void resetDefDeleteReqMethod() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefDeleteReqMethod();
            return;
        }
        this.defdeletereqmethodDirtyFlag = false;
        this.defdeletereqmethod = null;
    }

    public void setDefGetDraftReqMethod(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefGetDraftReqMethod(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.defgetdraftreqmethod = string;
        this.defgetdraftreqmethodDirtyFlag = true;
    }

    public String getDefGetDraftReqMethod() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefGetDraftReqMethod();
        }
        return this.defgetdraftreqmethod;
    }

    public boolean isDefGetDraftReqMethodDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefGetDraftReqMethodDirty();
        }
        return this.defgetdraftreqmethodDirtyFlag;
    }

    public void resetDefGetDraftReqMethod() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefGetDraftReqMethod();
            return;
        }
        this.defgetdraftreqmethodDirtyFlag = false;
        this.defgetdraftreqmethod = null;
    }

    public void setDefGetReqMethod(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefGetReqMethod(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.defgetreqmethod = string;
        this.defgetreqmethodDirtyFlag = true;
    }

    public String getDefGetReqMethod() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefGetReqMethod();
        }
        return this.defgetreqmethod;
    }

    public boolean isDefGetReqMethodDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefGetReqMethodDirty();
        }
        return this.defgetreqmethodDirtyFlag;
    }

    public void resetDefGetReqMethod() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefGetReqMethod();
            return;
        }
        this.defgetreqmethodDirtyFlag = false;
        this.defgetreqmethod = null;
    }

    public void setDefNeedResourceKey(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefNeedResourceKey(n);
            return;
        }
        this.defneedresourcekey = n;
        this.defneedresourcekeyDirtyFlag = true;
    }

    public Integer getDefNeedResourceKey() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefNeedResourceKey();
        }
        return this.defneedresourcekey;
    }

    public boolean isDefNeedResourceKeyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefNeedResourceKeyDirty();
        }
        return this.defneedresourcekeyDirtyFlag;
    }

    public void resetDefNeedResourceKey() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefNeedResourceKey();
            return;
        }
        this.defneedresourcekeyDirtyFlag = false;
        this.defneedresourcekey = null;
    }

    public void setDefSelectReqMethod(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefSelectReqMethod(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.defselectreqmethod = string;
        this.defselectreqmethodDirtyFlag = true;
    }

    public String getDefSelectReqMethod() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefSelectReqMethod();
        }
        return this.defselectreqmethod;
    }

    public boolean isDefSelectReqMethodDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefSelectReqMethodDirty();
        }
        return this.defselectreqmethodDirtyFlag;
    }

    public void resetDefSelectReqMethod() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefSelectReqMethod();
            return;
        }
        this.defselectreqmethodDirtyFlag = false;
        this.defselectreqmethod = null;
    }

    public void setDefUpdateReqMethod(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefUpdateReqMethod(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.defupdatereqmethod = string;
        this.defupdatereqmethodDirtyFlag = true;
    }

    public String getDefUpdateReqMethod() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefUpdateReqMethod();
        }
        return this.defupdatereqmethod;
    }

    public boolean isDefUpdateReqMethodDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefUpdateReqMethodDirty();
        }
        return this.defupdatereqmethodDirtyFlag;
    }

    public void resetDefUpdateReqMethod() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefUpdateReqMethod();
            return;
        }
        this.defupdatereqmethodDirtyFlag = false;
        this.defupdatereqmethod = null;
    }

    public void setDEPSSysSFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEPSSysSFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.depssyssfpluginid = string;
        this.depssyssfpluginidDirtyFlag = true;
    }

    public String getDEPSSysSFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEPSSysSFPluginId();
        }
        return this.depssyssfpluginid;
    }

    public boolean isDEPSSysSFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEPSSysSFPluginIdDirty();
        }
        return this.depssyssfpluginidDirtyFlag;
    }

    public void resetDEPSSysSFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEPSSysSFPluginId();
            return;
        }
        this.depssyssfpluginidDirtyFlag = false;
        this.depssyssfpluginid = null;
    }

    public void setDEPSSysSFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEPSSysSFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.depssyssfpluginname = string;
        this.depssyssfpluginnameDirtyFlag = true;
    }

    public String getDEPSSysSFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEPSSysSFPluginName();
        }
        return this.depssyssfpluginname;
    }

    public boolean isDEPSSysSFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEPSSysSFPluginNameDirty();
        }
        return this.depssyssfpluginnameDirtyFlag;
    }

    public void resetDEPSSysSFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEPSSysSFPluginName();
            return;
        }
        this.depssyssfpluginnameDirtyFlag = false;
        this.depssyssfpluginname = null;
    }

    public void setEnableAPIModelEx(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableAPIModelEx(n);
            return;
        }
        this.enableapimodelex = n;
        this.enableapimodelexDirtyFlag = true;
    }

    public Integer getEnableAPIModelEx() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableAPIModelEx();
        }
        return this.enableapimodelex;
    }

    public boolean isEnableAPIModelExDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableAPIModelExDirty();
        }
        return this.enableapimodelexDirtyFlag;
    }

    public void resetEnableAPIModelEx() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableAPIModelEx();
            return;
        }
        this.enableapimodelexDirtyFlag = false;
        this.enableapimodelex = null;
    }

    public void setEnableGateway(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableGateway(n);
            return;
        }
        this.enablegateway = n;
        this.enablegatewayDirtyFlag = true;
    }

    public Integer getEnableGateway() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableGateway();
        }
        return this.enablegateway;
    }

    public boolean isEnableGatewayDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableGatewayDirty();
        }
        return this.enablegatewayDirtyFlag;
    }

    public void resetEnableGateway() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableGateway();
            return;
        }
        this.enablegatewayDirtyFlag = false;
        this.enablegateway = null;
    }

    public void setIgnoreAuthPatterns(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIgnoreAuthPatterns(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ignoreauthpatterns = string;
        this.ignoreauthpatternsDirtyFlag = true;
    }

    public String getIgnoreAuthPatterns() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIgnoreAuthPatterns();
        }
        return this.ignoreauthpatterns;
    }

    public boolean isIgnoreAuthPatternsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIgnoreAuthPatternsDirty();
        }
        return this.ignoreauthpatternsDirtyFlag;
    }

    public void resetIgnoreAuthPatterns() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIgnoreAuthPatterns();
            return;
        }
        this.ignoreauthpatternsDirtyFlag = false;
        this.ignoreauthpatterns = null;
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

    public void setNamingService(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNamingService(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.namingservice = string;
        this.namingserviceDirtyFlag = true;
    }

    public String getNamingService() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNamingService();
        }
        return this.namingservice;
    }

    public boolean isNamingServiceDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNamingServiceDirty();
        }
        return this.namingserviceDirtyFlag;
    }

    public void resetNamingService() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNamingService();
            return;
        }
        this.namingserviceDirtyFlag = false;
        this.namingservice = null;
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

    public void setOutPSSysTranslatorId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOutPSSysTranslatorId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.outpssystranslatorid = string;
        this.outpssystranslatoridDirtyFlag = true;
    }

    public String getOutPSSysTranslatorId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOutPSSysTranslatorId();
        }
        return this.outpssystranslatorid;
    }

    public boolean isOutPSSysTranslatorIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOutPSSysTranslatorIdDirty();
        }
        return this.outpssystranslatoridDirtyFlag;
    }

    public void resetOutPSSysTranslatorId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOutPSSysTranslatorId();
            return;
        }
        this.outpssystranslatoridDirtyFlag = false;
        this.outpssystranslatorid = null;
    }

    public void setOutPSSysTranslatorName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOutPSSysTranslatorName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.outpssystranslatorname = string;
        this.outpssystranslatornameDirtyFlag = true;
    }

    public String getOutPSSysTranslatorName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOutPSSysTranslatorName();
        }
        return this.outpssystranslatorname;
    }

    public boolean isOutPSSysTranslatorNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOutPSSysTranslatorNameDirty();
        }
        return this.outpssystranslatornameDirtyFlag;
    }

    public void resetOutPSSysTranslatorName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOutPSSysTranslatorName();
            return;
        }
        this.outpssystranslatornameDirtyFlag = false;
        this.outpssystranslatorname = null;
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

    public void setPSDevSlnSysAPIId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysAPIId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysapiid = string;
        this.psdevslnsysapiidDirtyFlag = true;
    }

    public String getPSDevSlnSysAPIId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysAPIId();
        }
        return this.psdevslnsysapiid;
    }

    public boolean isPSDevSlnSysAPIIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysAPIIdDirty();
        }
        return this.psdevslnsysapiidDirtyFlag;
    }

    public void resetPSDevSlnSysAPIId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysAPIId();
            return;
        }
        this.psdevslnsysapiidDirtyFlag = false;
        this.psdevslnsysapiid = null;
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

    public void setPSSysResourceId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysResourceId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysresourceid = string;
        this.pssysresourceidDirtyFlag = true;
    }

    public String getPSSysResourceId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysResourceId();
        }
        return this.pssysresourceid;
    }

    public boolean isPSSysResourceIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysResourceIdDirty();
        }
        return this.pssysresourceidDirtyFlag;
    }

    public void resetPSSysResourceId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysResourceId();
            return;
        }
        this.pssysresourceidDirtyFlag = false;
        this.pssysresourceid = null;
    }

    public void setPSSysResourceName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysResourceName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysresourcename = string;
        this.pssysresourcenameDirtyFlag = true;
    }

    public String getPSSysResourceName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysResourceName();
        }
        return this.pssysresourcename;
    }

    public boolean isPSSysResourceNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysResourceNameDirty();
        }
        return this.pssysresourcenameDirtyFlag;
    }

    public void resetPSSysResourceName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysResourceName();
            return;
        }
        this.pssysresourcenameDirtyFlag = false;
        this.pssysresourcename = null;
    }

    public void setPSSysSAHandlerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSAHandlerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssahandlerid = string;
        this.pssyssahandleridDirtyFlag = true;
    }

    public String getPSSysSAHandlerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSAHandlerId();
        }
        return this.pssyssahandlerid;
    }

    public boolean isPSSysSAHandlerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSAHandlerIdDirty();
        }
        return this.pssyssahandleridDirtyFlag;
    }

    public void resetPSSysSAHandlerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSAHandlerId();
            return;
        }
        this.pssyssahandleridDirtyFlag = false;
        this.pssyssahandlerid = null;
    }

    public void setPSSysSAHandlerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSAHandlerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssahandlername = string;
        this.pssyssahandlernameDirtyFlag = true;
    }

    public String getPSSysSAHandlerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSAHandlerName();
        }
        return this.pssyssahandlername;
    }

    public boolean isPSSysSAHandlerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSAHandlerNameDirty();
        }
        return this.pssyssahandlernameDirtyFlag;
    }

    public void resetPSSysSAHandlerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSAHandlerName();
            return;
        }
        this.pssyssahandlernameDirtyFlag = false;
        this.pssyssahandlername = null;
    }

    public void setPSSysServiceAPIId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysServiceAPIId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysserviceapiid = string;
        this.pssysserviceapiidDirtyFlag = true;
    }

    public String getPSSysServiceAPIId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysServiceAPIId();
        }
        return this.pssysserviceapiid;
    }

    public boolean isPSSysServiceAPIIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysServiceAPIIdDirty();
        }
        return this.pssysserviceapiidDirtyFlag;
    }

    public void resetPSSysServiceAPIId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysServiceAPIId();
            return;
        }
        this.pssysserviceapiidDirtyFlag = false;
        this.pssysserviceapiid = null;
    }

    public void setPSSysServiceAPIName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysServiceAPIName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysserviceapiname = string;
        this.pssysserviceapinameDirtyFlag = true;
    }

    public String getPSSysServiceAPIName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysServiceAPIName();
        }
        return this.pssysserviceapiname;
    }

    public boolean isPSSysServiceAPINameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysServiceAPINameDirty();
        }
        return this.pssysserviceapinameDirtyFlag;
    }

    public void resetPSSysServiceAPIName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysServiceAPIName();
            return;
        }
        this.pssysserviceapinameDirtyFlag = false;
        this.pssysserviceapiname = null;
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

    public void setResetDefActionCodeName(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResetDefActionCodeName(n);
            return;
        }
        this.resetdefactioncodename = n;
        this.resetdefactioncodenameDirtyFlag = true;
    }

    public Integer getResetDefActionCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResetDefActionCodeName();
        }
        return this.resetdefactioncodename;
    }

    public boolean isResetDefActionCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResetDefActionCodeNameDirty();
        }
        return this.resetdefactioncodenameDirtyFlag;
    }

    public void resetResetDefActionCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResetDefActionCodeName();
            return;
        }
        this.resetdefactioncodenameDirtyFlag = false;
        this.resetdefactioncodename = null;
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

    public void setServiceDTOFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServiceDTOFlag(n);
            return;
        }
        this.servicedtoflag = n;
        this.servicedtoflagDirtyFlag = true;
    }

    public Integer getServiceDTOFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServiceDTOFlag();
        }
        return this.servicedtoflag;
    }

    public boolean isServiceDTOFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServiceDTOFlagDirty();
        }
        return this.servicedtoflagDirtyFlag;
    }

    public void resetServiceDTOFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServiceDTOFlag();
            return;
        }
        this.servicedtoflagDirtyFlag = false;
        this.servicedtoflag = null;
    }

    public void setServiceParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServiceParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.serviceparam = string;
        this.serviceparamDirtyFlag = true;
    }

    public String getServiceParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServiceParam();
        }
        return this.serviceparam;
    }

    public boolean isServiceParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServiceParamDirty();
        }
        return this.serviceparamDirtyFlag;
    }

    public void resetServiceParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServiceParam();
            return;
        }
        this.serviceparamDirtyFlag = false;
        this.serviceparam = null;
    }

    public void setServiceParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServiceParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.serviceparam2 = string;
        this.serviceparam2DirtyFlag = true;
    }

    public String getServiceParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServiceParam2();
        }
        return this.serviceparam2;
    }

    public boolean isServiceParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServiceParam2Dirty();
        }
        return this.serviceparam2DirtyFlag;
    }

    public void resetServiceParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServiceParam2();
            return;
        }
        this.serviceparam2DirtyFlag = false;
        this.serviceparam2 = null;
    }

    public void setServiceParam3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServiceParam3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.serviceparam3 = string;
        this.serviceparam3DirtyFlag = true;
    }

    public String getServiceParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServiceParam3();
        }
        return this.serviceparam3;
    }

    public boolean isServiceParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServiceParam3Dirty();
        }
        return this.serviceparam3DirtyFlag;
    }

    public void resetServiceParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServiceParam3();
            return;
        }
        this.serviceparam3DirtyFlag = false;
        this.serviceparam3 = null;
    }

    public void setServiceParam4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServiceParam4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.serviceparam4 = string;
        this.serviceparam4DirtyFlag = true;
    }

    public String getServiceParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServiceParam4();
        }
        return this.serviceparam4;
    }

    public boolean isServiceParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServiceParam4Dirty();
        }
        return this.serviceparam4DirtyFlag;
    }

    public void resetServiceParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServiceParam4();
            return;
        }
        this.serviceparam4DirtyFlag = false;
        this.serviceparam4 = null;
    }

    public void setServiceParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServiceParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.serviceparams = string;
        this.serviceparamsDirtyFlag = true;
    }

    public String getServiceParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServiceParams();
        }
        return this.serviceparams;
    }

    public boolean isServiceParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServiceParamsDirty();
        }
        return this.serviceparamsDirtyFlag;
    }

    public void resetServiceParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServiceParams();
            return;
        }
        this.serviceparamsDirtyFlag = false;
        this.serviceparams = null;
    }

    public void setServiceType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServiceType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.servicetype = string;
        this.servicetypeDirtyFlag = true;
    }

    public String getServiceType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServiceType();
        }
        return this.servicetype;
    }

    public boolean isServiceTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServiceTypeDirty();
        }
        return this.servicetypeDirtyFlag;
    }

    public void resetServiceType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServiceType();
            return;
        }
        this.servicetypeDirtyFlag = false;
        this.servicetype = null;
    }

    public void setUniqueTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUniqueTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uniquetag = string;
        this.uniquetagDirtyFlag = true;
    }

    public String getUniqueTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUniqueTag();
        }
        return this.uniquetag;
    }

    public boolean isUniqueTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUniqueTagDirty();
        }
        return this.uniquetagDirtyFlag;
    }

    public void resetUniqueTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUniqueTag();
            return;
        }
        this.uniquetagDirtyFlag = false;
        this.uniquetag = null;
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

    public void setVer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVer(n);
            return;
        }
        this.ver = n;
        this.verDirtyFlag = true;
    }

    public Integer getVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVer();
        }
        return this.ver;
    }

    public boolean isVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVerDirty();
        }
        return this.verDirtyFlag;
    }

    public void resetVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVer();
            return;
        }
        this.verDirtyFlag = false;
        this.ver = null;
    }

    protected void onReset() {
        PSSysServiceAPIBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysServiceAPIBase pSSysServiceAPIBase) {
        pSSysServiceAPIBase.resetAPILevel();
        pSSysServiceAPIBase.resetAPIMode();
        pSSysServiceAPIBase.resetAPITag();
        pSSysServiceAPIBase.resetAPITag2();
        pSSysServiceAPIBase.resetAPIType();
        pSSysServiceAPIBase.resetAuthCheckTokenUri();
        pSSysServiceAPIBase.resetAuthClientId();
        pSSysServiceAPIBase.resetAuthClientSecret();
        pSSysServiceAPIBase.resetAuthMode();
        pSSysServiceAPIBase.resetAuthParam();
        pSSysServiceAPIBase.resetAuthParam2();
        pSSysServiceAPIBase.resetAuthParam3();
        pSSysServiceAPIBase.resetAuthParam4();
        pSSysServiceAPIBase.resetBaseClsParams();
        pSSysServiceAPIBase.resetCfgPSModelStorageId();
        pSSysServiceAPIBase.resetCfgTag();
        pSSysServiceAPIBase.resetCodeName();
        pSSysServiceAPIBase.resetCodeNameMode();
        pSSysServiceAPIBase.resetCreateDate();
        pSSysServiceAPIBase.resetCreateMan();
        pSSysServiceAPIBase.resetCustomCode();
        pSSysServiceAPIBase.resetCustomMode();
        pSSysServiceAPIBase.resetDefaultPort();
        pSSysServiceAPIBase.resetDefaultPSDEOPPrivId();
        pSSysServiceAPIBase.resetDefaultPSDEOPPrivName();
        pSSysServiceAPIBase.resetDefCreateReqMethod();
        pSSysServiceAPIBase.resetDefDEActionReqMethod();
        pSSysServiceAPIBase.resetDefDEDataSetReqMethod();
        pSSysServiceAPIBase.resetDefDeleteReqMethod();
        pSSysServiceAPIBase.resetDefGetDraftReqMethod();
        pSSysServiceAPIBase.resetDefGetReqMethod();
        pSSysServiceAPIBase.resetDefNeedResourceKey();
        pSSysServiceAPIBase.resetDefSelectReqMethod();
        pSSysServiceAPIBase.resetDefUpdateReqMethod();
        pSSysServiceAPIBase.resetDEPSSysSFPluginId();
        pSSysServiceAPIBase.resetDEPSSysSFPluginName();
        pSSysServiceAPIBase.resetEnableAPIModelEx();
        pSSysServiceAPIBase.resetEnableGateway();
        pSSysServiceAPIBase.resetIgnoreAuthPatterns();
        pSSysServiceAPIBase.resetLockFlag();
        pSSysServiceAPIBase.resetMemo();
        pSSysServiceAPIBase.resetNamingService();
        pSSysServiceAPIBase.resetOrderValue();
        pSSysServiceAPIBase.resetOutPSSysTranslatorId();
        pSSysServiceAPIBase.resetOutPSSysTranslatorName();
        pSSysServiceAPIBase.resetPredefinedType();
        pSSysServiceAPIBase.resetPSDevSlnSysAPIId();
        pSSysServiceAPIBase.resetPSModuleId();
        pSSysServiceAPIBase.resetPSModuleName();
        pSSysServiceAPIBase.resetPSSysDynaModelId();
        pSSysServiceAPIBase.resetPSSysDynaModelName();
        pSSysServiceAPIBase.resetPSSysReqItemId();
        pSSysServiceAPIBase.resetPSSysReqItemName();
        pSSysServiceAPIBase.resetPSSysResourceId();
        pSSysServiceAPIBase.resetPSSysResourceName();
        pSSysServiceAPIBase.resetPSSysSAHandlerId();
        pSSysServiceAPIBase.resetPSSysSAHandlerName();
        pSSysServiceAPIBase.resetPSSysServiceAPIId();
        pSSysServiceAPIBase.resetPSSysServiceAPIName();
        pSSysServiceAPIBase.resetPSSysSFPluginId();
        pSSysServiceAPIBase.resetPSSysSFPluginName();
        pSSysServiceAPIBase.resetPSSystemId();
        pSSysServiceAPIBase.resetPSSystemName();
        pSSysServiceAPIBase.resetResetDefActionCodeName();
        pSSysServiceAPIBase.resetServiceCodeName();
        pSSysServiceAPIBase.resetServiceDTOFlag();
        pSSysServiceAPIBase.resetServiceParam();
        pSSysServiceAPIBase.resetServiceParam2();
        pSSysServiceAPIBase.resetServiceParam3();
        pSSysServiceAPIBase.resetServiceParam4();
        pSSysServiceAPIBase.resetServiceParams();
        pSSysServiceAPIBase.resetServiceType();
        pSSysServiceAPIBase.resetUniqueTag();
        pSSysServiceAPIBase.resetUpdateDate();
        pSSysServiceAPIBase.resetUpdateMan();
        pSSysServiceAPIBase.resetUserCat();
        pSSysServiceAPIBase.resetUserTag();
        pSSysServiceAPIBase.resetUserTag2();
        pSSysServiceAPIBase.resetUserTag3();
        pSSysServiceAPIBase.resetUserTag4();
        pSSysServiceAPIBase.resetValidFlag();
        pSSysServiceAPIBase.resetVer();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAPILevelDirty()) {
            hashMap.put(FIELD_APILEVEL, this.getAPILevel());
        }
        if (!bl || this.isAPIModeDirty()) {
            hashMap.put(FIELD_APIMODE, this.getAPIMode());
        }
        if (!bl || this.isAPITagDirty()) {
            hashMap.put(FIELD_APITAG, this.getAPITag());
        }
        if (!bl || this.isAPITag2Dirty()) {
            hashMap.put(FIELD_APITAG2, this.getAPITag2());
        }
        if (!bl || this.isAPITypeDirty()) {
            hashMap.put(FIELD_APITYPE, this.getAPIType());
        }
        if (!bl || this.isAuthCheckTokenUriDirty()) {
            hashMap.put(FIELD_AUTHCHECKTOKENURI, this.getAuthCheckTokenUri());
        }
        if (!bl || this.isAuthClientIdDirty()) {
            hashMap.put(FIELD_AUTHCLIENTID, this.getAuthClientId());
        }
        if (!bl || this.isAuthClientSecretDirty()) {
            hashMap.put(FIELD_AUTHCLIENTSECRET, this.getAuthClientSecret());
        }
        if (!bl || this.isAuthModeDirty()) {
            hashMap.put(FIELD_AUTHMODE, this.getAuthMode());
        }
        if (!bl || this.isAuthParamDirty()) {
            hashMap.put(FIELD_AUTHPARAM, this.getAuthParam());
        }
        if (!bl || this.isAuthParam2Dirty()) {
            hashMap.put(FIELD_AUTHPARAM2, this.getAuthParam2());
        }
        if (!bl || this.isAuthParam3Dirty()) {
            hashMap.put(FIELD_AUTHPARAM3, this.getAuthParam3());
        }
        if (!bl || this.isAuthParam4Dirty()) {
            hashMap.put(FIELD_AUTHPARAM4, this.getAuthParam4());
        }
        if (!bl || this.isBaseClsParamsDirty()) {
            hashMap.put(FIELD_BASECLSPARAMS, this.getBaseClsParams());
        }
        if (!bl || this.isCfgPSModelStorageIdDirty()) {
            hashMap.put(FIELD_CFGPSMODELSTORAGEID, this.getCfgPSModelStorageId());
        }
        if (!bl || this.isCfgTagDirty()) {
            hashMap.put(FIELD_CFGTAG, this.getCfgTag());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCodeNameModeDirty()) {
            hashMap.put(FIELD_CODENAMEMODE, this.getCodeNameMode());
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
        if (!bl || this.isDefaultPortDirty()) {
            hashMap.put(FIELD_DEFAULTPORT, this.getDefaultPort());
        }
        if (!bl || this.isDefaultPSDEOPPrivIdDirty()) {
            hashMap.put(FIELD_DEFAULTPSDEOPPRIVID, this.getDefaultPSDEOPPrivId());
        }
        if (!bl || this.isDefaultPSDEOPPrivNameDirty()) {
            hashMap.put(FIELD_DEFAULTPSDEOPPRIVNAME, this.getDefaultPSDEOPPrivName());
        }
        if (!bl || this.isDefCreateReqMethodDirty()) {
            hashMap.put(FIELD_DEFCREATEREQMETHOD, this.getDefCreateReqMethod());
        }
        if (!bl || this.isDefDEActionReqMethodDirty()) {
            hashMap.put(FIELD_DEFDEACTIONREQMETHOD, this.getDefDEActionReqMethod());
        }
        if (!bl || this.isDefDEDataSetReqMethodDirty()) {
            hashMap.put(FIELD_DEFDEDATASETREQMETHOD, this.getDefDEDataSetReqMethod());
        }
        if (!bl || this.isDefDeleteReqMethodDirty()) {
            hashMap.put(FIELD_DEFDELETEREQMETHOD, this.getDefDeleteReqMethod());
        }
        if (!bl || this.isDefGetDraftReqMethodDirty()) {
            hashMap.put(FIELD_DEFGETDRAFTREQMETHOD, this.getDefGetDraftReqMethod());
        }
        if (!bl || this.isDefGetReqMethodDirty()) {
            hashMap.put(FIELD_DEFGETREQMETHOD, this.getDefGetReqMethod());
        }
        if (!bl || this.isDefNeedResourceKeyDirty()) {
            hashMap.put(FIELD_DEFNEEDRESOURCEKEY, this.getDefNeedResourceKey());
        }
        if (!bl || this.isDefSelectReqMethodDirty()) {
            hashMap.put(FIELD_DEFSELECTREQMETHOD, this.getDefSelectReqMethod());
        }
        if (!bl || this.isDefUpdateReqMethodDirty()) {
            hashMap.put(FIELD_DEFUPDATEREQMETHOD, this.getDefUpdateReqMethod());
        }
        if (!bl || this.isDEPSSysSFPluginIdDirty()) {
            hashMap.put(FIELD_DEPSSYSSFPLUGINID, this.getDEPSSysSFPluginId());
        }
        if (!bl || this.isDEPSSysSFPluginNameDirty()) {
            hashMap.put(FIELD_DEPSSYSSFPLUGINNAME, this.getDEPSSysSFPluginName());
        }
        if (!bl || this.isEnableAPIModelExDirty()) {
            hashMap.put(FIELD_ENABLEAPIMODELEX, this.getEnableAPIModelEx());
        }
        if (!bl || this.isEnableGatewayDirty()) {
            hashMap.put(FIELD_ENABLEGATEWAY, this.getEnableGateway());
        }
        if (!bl || this.isIgnoreAuthPatternsDirty()) {
            hashMap.put(FIELD_IGNOREAUTHPATTERNS, this.getIgnoreAuthPatterns());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isNamingServiceDirty()) {
            hashMap.put(FIELD_NAMINGSERVICE, this.getNamingService());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isOutPSSysTranslatorIdDirty()) {
            hashMap.put(FIELD_OUTPSSYSTRANSLATORID, this.getOutPSSysTranslatorId());
        }
        if (!bl || this.isOutPSSysTranslatorNameDirty()) {
            hashMap.put(FIELD_OUTPSSYSTRANSLATORNAME, this.getOutPSSysTranslatorName());
        }
        if (!bl || this.isPredefinedTypeDirty()) {
            hashMap.put(FIELD_PREDEFINEDTYPE, this.getPredefinedType());
        }
        if (!bl || this.isPSDevSlnSysAPIIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSAPIID, this.getPSDevSlnSysAPIId());
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
        if (!bl || this.isPSSysReqItemIdDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMID, this.getPSSysReqItemId());
        }
        if (!bl || this.isPSSysReqItemNameDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMNAME, this.getPSSysReqItemName());
        }
        if (!bl || this.isPSSysResourceIdDirty()) {
            hashMap.put(FIELD_PSSYSRESOURCEID, this.getPSSysResourceId());
        }
        if (!bl || this.isPSSysResourceNameDirty()) {
            hashMap.put(FIELD_PSSYSRESOURCENAME, this.getPSSysResourceName());
        }
        if (!bl || this.isPSSysSAHandlerIdDirty()) {
            hashMap.put(FIELD_PSSYSSAHANDLERID, this.getPSSysSAHandlerId());
        }
        if (!bl || this.isPSSysSAHandlerNameDirty()) {
            hashMap.put(FIELD_PSSYSSAHANDLERNAME, this.getPSSysSAHandlerName());
        }
        if (!bl || this.isPSSysServiceAPIIdDirty()) {
            hashMap.put(FIELD_PSSYSSERVICEAPIID, this.getPSSysServiceAPIId());
        }
        if (!bl || this.isPSSysServiceAPINameDirty()) {
            hashMap.put(FIELD_PSSYSSERVICEAPINAME, this.getPSSysServiceAPIName());
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
        if (!bl || this.isResetDefActionCodeNameDirty()) {
            hashMap.put(FIELD_RESETDEFACTIONCODENAME, this.getResetDefActionCodeName());
        }
        if (!bl || this.isServiceCodeNameDirty()) {
            hashMap.put(FIELD_SERVICECODENAME, this.getServiceCodeName());
        }
        if (!bl || this.isServiceDTOFlagDirty()) {
            hashMap.put(FIELD_SERVICEDTOFLAG, this.getServiceDTOFlag());
        }
        if (!bl || this.isServiceParamDirty()) {
            hashMap.put(FIELD_SERVICEPARAM, this.getServiceParam());
        }
        if (!bl || this.isServiceParam2Dirty()) {
            hashMap.put(FIELD_SERVICEPARAM2, this.getServiceParam2());
        }
        if (!bl || this.isServiceParam3Dirty()) {
            hashMap.put(FIELD_SERVICEPARAM3, this.getServiceParam3());
        }
        if (!bl || this.isServiceParam4Dirty()) {
            hashMap.put(FIELD_SERVICEPARAM4, this.getServiceParam4());
        }
        if (!bl || this.isServiceParamsDirty()) {
            hashMap.put(FIELD_SERVICEPARAMS, this.getServiceParams());
        }
        if (!bl || this.isServiceTypeDirty()) {
            hashMap.put(FIELD_SERVICETYPE, this.getServiceType());
        }
        if (!bl || this.isUniqueTagDirty()) {
            hashMap.put(FIELD_UNIQUETAG, this.getUniqueTag());
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
        if (!bl || this.isVerDirty()) {
            hashMap.put(FIELD_VER, this.getVer());
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
        return PSSysServiceAPIBase.get(this, n);
    }

    private static Object get(PSSysServiceAPIBase pSSysServiceAPIBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysServiceAPIBase.getAPILevel();
            }
            case 1: {
                return pSSysServiceAPIBase.getAPIMode();
            }
            case 2: {
                return pSSysServiceAPIBase.getAPITag();
            }
            case 3: {
                return pSSysServiceAPIBase.getAPITag2();
            }
            case 4: {
                return pSSysServiceAPIBase.getAPIType();
            }
            case 5: {
                return pSSysServiceAPIBase.getAuthCheckTokenUri();
            }
            case 6: {
                return pSSysServiceAPIBase.getAuthClientId();
            }
            case 7: {
                return pSSysServiceAPIBase.getAuthClientSecret();
            }
            case 8: {
                return pSSysServiceAPIBase.getAuthMode();
            }
            case 9: {
                return pSSysServiceAPIBase.getAuthParam();
            }
            case 10: {
                return pSSysServiceAPIBase.getAuthParam2();
            }
            case 11: {
                return pSSysServiceAPIBase.getAuthParam3();
            }
            case 12: {
                return pSSysServiceAPIBase.getAuthParam4();
            }
            case 13: {
                return pSSysServiceAPIBase.getBaseClsParams();
            }
            case 14: {
                return pSSysServiceAPIBase.getCfgPSModelStorageId();
            }
            case 15: {
                return pSSysServiceAPIBase.getCfgTag();
            }
            case 16: {
                return pSSysServiceAPIBase.getCodeName();
            }
            case 17: {
                return pSSysServiceAPIBase.getCodeNameMode();
            }
            case 18: {
                return pSSysServiceAPIBase.getCreateDate();
            }
            case 19: {
                return pSSysServiceAPIBase.getCreateMan();
            }
            case 20: {
                return pSSysServiceAPIBase.getCustomCode();
            }
            case 21: {
                return pSSysServiceAPIBase.getCustomMode();
            }
            case 22: {
                return pSSysServiceAPIBase.getDefaultPort();
            }
            case 23: {
                return pSSysServiceAPIBase.getDefaultPSDEOPPrivId();
            }
            case 24: {
                return pSSysServiceAPIBase.getDefaultPSDEOPPrivName();
            }
            case 25: {
                return pSSysServiceAPIBase.getDefCreateReqMethod();
            }
            case 26: {
                return pSSysServiceAPIBase.getDefDEActionReqMethod();
            }
            case 27: {
                return pSSysServiceAPIBase.getDefDEDataSetReqMethod();
            }
            case 28: {
                return pSSysServiceAPIBase.getDefDeleteReqMethod();
            }
            case 29: {
                return pSSysServiceAPIBase.getDefGetDraftReqMethod();
            }
            case 30: {
                return pSSysServiceAPIBase.getDefGetReqMethod();
            }
            case 31: {
                return pSSysServiceAPIBase.getDefNeedResourceKey();
            }
            case 32: {
                return pSSysServiceAPIBase.getDefSelectReqMethod();
            }
            case 33: {
                return pSSysServiceAPIBase.getDefUpdateReqMethod();
            }
            case 34: {
                return pSSysServiceAPIBase.getDEPSSysSFPluginId();
            }
            case 35: {
                return pSSysServiceAPIBase.getDEPSSysSFPluginName();
            }
            case 36: {
                return pSSysServiceAPIBase.getEnableAPIModelEx();
            }
            case 37: {
                return pSSysServiceAPIBase.getEnableGateway();
            }
            case 38: {
                return pSSysServiceAPIBase.getIgnoreAuthPatterns();
            }
            case 39: {
                return pSSysServiceAPIBase.getLockFlag();
            }
            case 40: {
                return pSSysServiceAPIBase.getMemo();
            }
            case 41: {
                return pSSysServiceAPIBase.getNamingService();
            }
            case 42: {
                return pSSysServiceAPIBase.getOrderValue();
            }
            case 43: {
                return pSSysServiceAPIBase.getOutPSSysTranslatorId();
            }
            case 44: {
                return pSSysServiceAPIBase.getOutPSSysTranslatorName();
            }
            case 45: {
                return pSSysServiceAPIBase.getPredefinedType();
            }
            case 46: {
                return pSSysServiceAPIBase.getPSDevSlnSysAPIId();
            }
            case 47: {
                return pSSysServiceAPIBase.getPSModuleId();
            }
            case 48: {
                return pSSysServiceAPIBase.getPSModuleName();
            }
            case 49: {
                return pSSysServiceAPIBase.getPSSysDynaModelId();
            }
            case 50: {
                return pSSysServiceAPIBase.getPSSysDynaModelName();
            }
            case 51: {
                return pSSysServiceAPIBase.getPSSysReqItemId();
            }
            case 52: {
                return pSSysServiceAPIBase.getPSSysReqItemName();
            }
            case 53: {
                return pSSysServiceAPIBase.getPSSysResourceId();
            }
            case 54: {
                return pSSysServiceAPIBase.getPSSysResourceName();
            }
            case 55: {
                return pSSysServiceAPIBase.getPSSysSAHandlerId();
            }
            case 56: {
                return pSSysServiceAPIBase.getPSSysSAHandlerName();
            }
            case 57: {
                return pSSysServiceAPIBase.getPSSysServiceAPIId();
            }
            case 58: {
                return pSSysServiceAPIBase.getPSSysServiceAPIName();
            }
            case 59: {
                return pSSysServiceAPIBase.getPSSysSFPluginId();
            }
            case 60: {
                return pSSysServiceAPIBase.getPSSysSFPluginName();
            }
            case 61: {
                return pSSysServiceAPIBase.getPSSystemId();
            }
            case 62: {
                return pSSysServiceAPIBase.getPSSystemName();
            }
            case 63: {
                return pSSysServiceAPIBase.getResetDefActionCodeName();
            }
            case 64: {
                return pSSysServiceAPIBase.getServiceCodeName();
            }
            case 65: {
                return pSSysServiceAPIBase.getServiceDTOFlag();
            }
            case 66: {
                return pSSysServiceAPIBase.getServiceParam();
            }
            case 67: {
                return pSSysServiceAPIBase.getServiceParam2();
            }
            case 68: {
                return pSSysServiceAPIBase.getServiceParam3();
            }
            case 69: {
                return pSSysServiceAPIBase.getServiceParam4();
            }
            case 70: {
                return pSSysServiceAPIBase.getServiceParams();
            }
            case 71: {
                return pSSysServiceAPIBase.getServiceType();
            }
            case 72: {
                return pSSysServiceAPIBase.getUniqueTag();
            }
            case 73: {
                return pSSysServiceAPIBase.getUpdateDate();
            }
            case 74: {
                return pSSysServiceAPIBase.getUpdateMan();
            }
            case 75: {
                return pSSysServiceAPIBase.getUserCat();
            }
            case 76: {
                return pSSysServiceAPIBase.getUserTag();
            }
            case 77: {
                return pSSysServiceAPIBase.getUserTag2();
            }
            case 78: {
                return pSSysServiceAPIBase.getUserTag3();
            }
            case 79: {
                return pSSysServiceAPIBase.getUserTag4();
            }
            case 80: {
                return pSSysServiceAPIBase.getValidFlag();
            }
            case 81: {
                return pSSysServiceAPIBase.getVer();
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
        PSSysServiceAPIBase.set(this, n, object);
    }

    private static void set(PSSysServiceAPIBase pSSysServiceAPIBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysServiceAPIBase.setAPILevel(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSSysServiceAPIBase.setAPIMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 2: {
                pSSysServiceAPIBase.setAPITag(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysServiceAPIBase.setAPITag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysServiceAPIBase.setAPIType(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysServiceAPIBase.setAuthCheckTokenUri(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysServiceAPIBase.setAuthClientId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysServiceAPIBase.setAuthClientSecret(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysServiceAPIBase.setAuthMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysServiceAPIBase.setAuthParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysServiceAPIBase.setAuthParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysServiceAPIBase.setAuthParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysServiceAPIBase.setAuthParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysServiceAPIBase.setBaseClsParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysServiceAPIBase.setCfgPSModelStorageId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysServiceAPIBase.setCfgTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysServiceAPIBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysServiceAPIBase.setCodeNameMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysServiceAPIBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 19: {
                pSSysServiceAPIBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysServiceAPIBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysServiceAPIBase.setCustomMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 22: {
                pSSysServiceAPIBase.setDefaultPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 23: {
                pSSysServiceAPIBase.setDefaultPSDEOPPrivId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysServiceAPIBase.setDefaultPSDEOPPrivName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysServiceAPIBase.setDefCreateReqMethod(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysServiceAPIBase.setDefDEActionReqMethod(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysServiceAPIBase.setDefDEDataSetReqMethod(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysServiceAPIBase.setDefDeleteReqMethod(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysServiceAPIBase.setDefGetDraftReqMethod(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysServiceAPIBase.setDefGetReqMethod(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysServiceAPIBase.setDefNeedResourceKey(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 32: {
                pSSysServiceAPIBase.setDefSelectReqMethod(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysServiceAPIBase.setDefUpdateReqMethod(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysServiceAPIBase.setDEPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSysServiceAPIBase.setDEPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSSysServiceAPIBase.setEnableAPIModelEx(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 37: {
                pSSysServiceAPIBase.setEnableGateway(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 38: {
                pSSysServiceAPIBase.setIgnoreAuthPatterns(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSSysServiceAPIBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 40: {
                pSSysServiceAPIBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSSysServiceAPIBase.setNamingService(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSSysServiceAPIBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 43: {
                pSSysServiceAPIBase.setOutPSSysTranslatorId(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSSysServiceAPIBase.setOutPSSysTranslatorName(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSSysServiceAPIBase.setPredefinedType(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSSysServiceAPIBase.setPSDevSlnSysAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSSysServiceAPIBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSSysServiceAPIBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSSysServiceAPIBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSSysServiceAPIBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSSysServiceAPIBase.setPSSysReqItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSSysServiceAPIBase.setPSSysReqItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSSysServiceAPIBase.setPSSysResourceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSSysServiceAPIBase.setPSSysResourceName(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSSysServiceAPIBase.setPSSysSAHandlerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSSysServiceAPIBase.setPSSysSAHandlerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSSysServiceAPIBase.setPSSysServiceAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 58: {
                pSSysServiceAPIBase.setPSSysServiceAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 59: {
                pSSysServiceAPIBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 60: {
                pSSysServiceAPIBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 61: {
                pSSysServiceAPIBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 62: {
                pSSysServiceAPIBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 63: {
                pSSysServiceAPIBase.setResetDefActionCodeName(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 64: {
                pSSysServiceAPIBase.setServiceCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 65: {
                pSSysServiceAPIBase.setServiceDTOFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 66: {
                pSSysServiceAPIBase.setServiceParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 67: {
                pSSysServiceAPIBase.setServiceParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 68: {
                pSSysServiceAPIBase.setServiceParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 69: {
                pSSysServiceAPIBase.setServiceParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 70: {
                pSSysServiceAPIBase.setServiceParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 71: {
                pSSysServiceAPIBase.setServiceType(DataObject.getStringValue((Object)object));
                return;
            }
            case 72: {
                pSSysServiceAPIBase.setUniqueTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 73: {
                pSSysServiceAPIBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 74: {
                pSSysServiceAPIBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 75: {
                pSSysServiceAPIBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 76: {
                pSSysServiceAPIBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 77: {
                pSSysServiceAPIBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 78: {
                pSSysServiceAPIBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 79: {
                pSSysServiceAPIBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 80: {
                pSSysServiceAPIBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 81: {
                pSSysServiceAPIBase.setVer(DataObject.getIntegerValue((Object)object));
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
        return PSSysServiceAPIBase.isNull(this, n);
    }

    private static boolean isNull(PSSysServiceAPIBase pSSysServiceAPIBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysServiceAPIBase.getAPILevel() == null;
            }
            case 1: {
                return pSSysServiceAPIBase.getAPIMode() == null;
            }
            case 2: {
                return pSSysServiceAPIBase.getAPITag() == null;
            }
            case 3: {
                return pSSysServiceAPIBase.getAPITag2() == null;
            }
            case 4: {
                return pSSysServiceAPIBase.getAPIType() == null;
            }
            case 5: {
                return pSSysServiceAPIBase.getAuthCheckTokenUri() == null;
            }
            case 6: {
                return pSSysServiceAPIBase.getAuthClientId() == null;
            }
            case 7: {
                return pSSysServiceAPIBase.getAuthClientSecret() == null;
            }
            case 8: {
                return pSSysServiceAPIBase.getAuthMode() == null;
            }
            case 9: {
                return pSSysServiceAPIBase.getAuthParam() == null;
            }
            case 10: {
                return pSSysServiceAPIBase.getAuthParam2() == null;
            }
            case 11: {
                return pSSysServiceAPIBase.getAuthParam3() == null;
            }
            case 12: {
                return pSSysServiceAPIBase.getAuthParam4() == null;
            }
            case 13: {
                return pSSysServiceAPIBase.getBaseClsParams() == null;
            }
            case 14: {
                return pSSysServiceAPIBase.getCfgPSModelStorageId() == null;
            }
            case 15: {
                return pSSysServiceAPIBase.getCfgTag() == null;
            }
            case 16: {
                return pSSysServiceAPIBase.getCodeName() == null;
            }
            case 17: {
                return pSSysServiceAPIBase.getCodeNameMode() == null;
            }
            case 18: {
                return pSSysServiceAPIBase.getCreateDate() == null;
            }
            case 19: {
                return pSSysServiceAPIBase.getCreateMan() == null;
            }
            case 20: {
                return pSSysServiceAPIBase.getCustomCode() == null;
            }
            case 21: {
                return pSSysServiceAPIBase.getCustomMode() == null;
            }
            case 22: {
                return pSSysServiceAPIBase.getDefaultPort() == null;
            }
            case 23: {
                return pSSysServiceAPIBase.getDefaultPSDEOPPrivId() == null;
            }
            case 24: {
                return pSSysServiceAPIBase.getDefaultPSDEOPPrivName() == null;
            }
            case 25: {
                return pSSysServiceAPIBase.getDefCreateReqMethod() == null;
            }
            case 26: {
                return pSSysServiceAPIBase.getDefDEActionReqMethod() == null;
            }
            case 27: {
                return pSSysServiceAPIBase.getDefDEDataSetReqMethod() == null;
            }
            case 28: {
                return pSSysServiceAPIBase.getDefDeleteReqMethod() == null;
            }
            case 29: {
                return pSSysServiceAPIBase.getDefGetDraftReqMethod() == null;
            }
            case 30: {
                return pSSysServiceAPIBase.getDefGetReqMethod() == null;
            }
            case 31: {
                return pSSysServiceAPIBase.getDefNeedResourceKey() == null;
            }
            case 32: {
                return pSSysServiceAPIBase.getDefSelectReqMethod() == null;
            }
            case 33: {
                return pSSysServiceAPIBase.getDefUpdateReqMethod() == null;
            }
            case 34: {
                return pSSysServiceAPIBase.getDEPSSysSFPluginId() == null;
            }
            case 35: {
                return pSSysServiceAPIBase.getDEPSSysSFPluginName() == null;
            }
            case 36: {
                return pSSysServiceAPIBase.getEnableAPIModelEx() == null;
            }
            case 37: {
                return pSSysServiceAPIBase.getEnableGateway() == null;
            }
            case 38: {
                return pSSysServiceAPIBase.getIgnoreAuthPatterns() == null;
            }
            case 39: {
                return pSSysServiceAPIBase.getLockFlag() == null;
            }
            case 40: {
                return pSSysServiceAPIBase.getMemo() == null;
            }
            case 41: {
                return pSSysServiceAPIBase.getNamingService() == null;
            }
            case 42: {
                return pSSysServiceAPIBase.getOrderValue() == null;
            }
            case 43: {
                return pSSysServiceAPIBase.getOutPSSysTranslatorId() == null;
            }
            case 44: {
                return pSSysServiceAPIBase.getOutPSSysTranslatorName() == null;
            }
            case 45: {
                return pSSysServiceAPIBase.getPredefinedType() == null;
            }
            case 46: {
                return pSSysServiceAPIBase.getPSDevSlnSysAPIId() == null;
            }
            case 47: {
                return pSSysServiceAPIBase.getPSModuleId() == null;
            }
            case 48: {
                return pSSysServiceAPIBase.getPSModuleName() == null;
            }
            case 49: {
                return pSSysServiceAPIBase.getPSSysDynaModelId() == null;
            }
            case 50: {
                return pSSysServiceAPIBase.getPSSysDynaModelName() == null;
            }
            case 51: {
                return pSSysServiceAPIBase.getPSSysReqItemId() == null;
            }
            case 52: {
                return pSSysServiceAPIBase.getPSSysReqItemName() == null;
            }
            case 53: {
                return pSSysServiceAPIBase.getPSSysResourceId() == null;
            }
            case 54: {
                return pSSysServiceAPIBase.getPSSysResourceName() == null;
            }
            case 55: {
                return pSSysServiceAPIBase.getPSSysSAHandlerId() == null;
            }
            case 56: {
                return pSSysServiceAPIBase.getPSSysSAHandlerName() == null;
            }
            case 57: {
                return pSSysServiceAPIBase.getPSSysServiceAPIId() == null;
            }
            case 58: {
                return pSSysServiceAPIBase.getPSSysServiceAPIName() == null;
            }
            case 59: {
                return pSSysServiceAPIBase.getPSSysSFPluginId() == null;
            }
            case 60: {
                return pSSysServiceAPIBase.getPSSysSFPluginName() == null;
            }
            case 61: {
                return pSSysServiceAPIBase.getPSSystemId() == null;
            }
            case 62: {
                return pSSysServiceAPIBase.getPSSystemName() == null;
            }
            case 63: {
                return pSSysServiceAPIBase.getResetDefActionCodeName() == null;
            }
            case 64: {
                return pSSysServiceAPIBase.getServiceCodeName() == null;
            }
            case 65: {
                return pSSysServiceAPIBase.getServiceDTOFlag() == null;
            }
            case 66: {
                return pSSysServiceAPIBase.getServiceParam() == null;
            }
            case 67: {
                return pSSysServiceAPIBase.getServiceParam2() == null;
            }
            case 68: {
                return pSSysServiceAPIBase.getServiceParam3() == null;
            }
            case 69: {
                return pSSysServiceAPIBase.getServiceParam4() == null;
            }
            case 70: {
                return pSSysServiceAPIBase.getServiceParams() == null;
            }
            case 71: {
                return pSSysServiceAPIBase.getServiceType() == null;
            }
            case 72: {
                return pSSysServiceAPIBase.getUniqueTag() == null;
            }
            case 73: {
                return pSSysServiceAPIBase.getUpdateDate() == null;
            }
            case 74: {
                return pSSysServiceAPIBase.getUpdateMan() == null;
            }
            case 75: {
                return pSSysServiceAPIBase.getUserCat() == null;
            }
            case 76: {
                return pSSysServiceAPIBase.getUserTag() == null;
            }
            case 77: {
                return pSSysServiceAPIBase.getUserTag2() == null;
            }
            case 78: {
                return pSSysServiceAPIBase.getUserTag3() == null;
            }
            case 79: {
                return pSSysServiceAPIBase.getUserTag4() == null;
            }
            case 80: {
                return pSSysServiceAPIBase.getValidFlag() == null;
            }
            case 81: {
                return pSSysServiceAPIBase.getVer() == null;
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
        return PSSysServiceAPIBase.contains(this, n);
    }

    private static boolean contains(PSSysServiceAPIBase pSSysServiceAPIBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysServiceAPIBase.isAPILevelDirty();
            }
            case 1: {
                return pSSysServiceAPIBase.isAPIModeDirty();
            }
            case 2: {
                return pSSysServiceAPIBase.isAPITagDirty();
            }
            case 3: {
                return pSSysServiceAPIBase.isAPITag2Dirty();
            }
            case 4: {
                return pSSysServiceAPIBase.isAPITypeDirty();
            }
            case 5: {
                return pSSysServiceAPIBase.isAuthCheckTokenUriDirty();
            }
            case 6: {
                return pSSysServiceAPIBase.isAuthClientIdDirty();
            }
            case 7: {
                return pSSysServiceAPIBase.isAuthClientSecretDirty();
            }
            case 8: {
                return pSSysServiceAPIBase.isAuthModeDirty();
            }
            case 9: {
                return pSSysServiceAPIBase.isAuthParamDirty();
            }
            case 10: {
                return pSSysServiceAPIBase.isAuthParam2Dirty();
            }
            case 11: {
                return pSSysServiceAPIBase.isAuthParam3Dirty();
            }
            case 12: {
                return pSSysServiceAPIBase.isAuthParam4Dirty();
            }
            case 13: {
                return pSSysServiceAPIBase.isBaseClsParamsDirty();
            }
            case 14: {
                return pSSysServiceAPIBase.isCfgPSModelStorageIdDirty();
            }
            case 15: {
                return pSSysServiceAPIBase.isCfgTagDirty();
            }
            case 16: {
                return pSSysServiceAPIBase.isCodeNameDirty();
            }
            case 17: {
                return pSSysServiceAPIBase.isCodeNameModeDirty();
            }
            case 18: {
                return pSSysServiceAPIBase.isCreateDateDirty();
            }
            case 19: {
                return pSSysServiceAPIBase.isCreateManDirty();
            }
            case 20: {
                return pSSysServiceAPIBase.isCustomCodeDirty();
            }
            case 21: {
                return pSSysServiceAPIBase.isCustomModeDirty();
            }
            case 22: {
                return pSSysServiceAPIBase.isDefaultPortDirty();
            }
            case 23: {
                return pSSysServiceAPIBase.isDefaultPSDEOPPrivIdDirty();
            }
            case 24: {
                return pSSysServiceAPIBase.isDefaultPSDEOPPrivNameDirty();
            }
            case 25: {
                return pSSysServiceAPIBase.isDefCreateReqMethodDirty();
            }
            case 26: {
                return pSSysServiceAPIBase.isDefDEActionReqMethodDirty();
            }
            case 27: {
                return pSSysServiceAPIBase.isDefDEDataSetReqMethodDirty();
            }
            case 28: {
                return pSSysServiceAPIBase.isDefDeleteReqMethodDirty();
            }
            case 29: {
                return pSSysServiceAPIBase.isDefGetDraftReqMethodDirty();
            }
            case 30: {
                return pSSysServiceAPIBase.isDefGetReqMethodDirty();
            }
            case 31: {
                return pSSysServiceAPIBase.isDefNeedResourceKeyDirty();
            }
            case 32: {
                return pSSysServiceAPIBase.isDefSelectReqMethodDirty();
            }
            case 33: {
                return pSSysServiceAPIBase.isDefUpdateReqMethodDirty();
            }
            case 34: {
                return pSSysServiceAPIBase.isDEPSSysSFPluginIdDirty();
            }
            case 35: {
                return pSSysServiceAPIBase.isDEPSSysSFPluginNameDirty();
            }
            case 36: {
                return pSSysServiceAPIBase.isEnableAPIModelExDirty();
            }
            case 37: {
                return pSSysServiceAPIBase.isEnableGatewayDirty();
            }
            case 38: {
                return pSSysServiceAPIBase.isIgnoreAuthPatternsDirty();
            }
            case 39: {
                return pSSysServiceAPIBase.isLockFlagDirty();
            }
            case 40: {
                return pSSysServiceAPIBase.isMemoDirty();
            }
            case 41: {
                return pSSysServiceAPIBase.isNamingServiceDirty();
            }
            case 42: {
                return pSSysServiceAPIBase.isOrderValueDirty();
            }
            case 43: {
                return pSSysServiceAPIBase.isOutPSSysTranslatorIdDirty();
            }
            case 44: {
                return pSSysServiceAPIBase.isOutPSSysTranslatorNameDirty();
            }
            case 45: {
                return pSSysServiceAPIBase.isPredefinedTypeDirty();
            }
            case 46: {
                return pSSysServiceAPIBase.isPSDevSlnSysAPIIdDirty();
            }
            case 47: {
                return pSSysServiceAPIBase.isPSModuleIdDirty();
            }
            case 48: {
                return pSSysServiceAPIBase.isPSModuleNameDirty();
            }
            case 49: {
                return pSSysServiceAPIBase.isPSSysDynaModelIdDirty();
            }
            case 50: {
                return pSSysServiceAPIBase.isPSSysDynaModelNameDirty();
            }
            case 51: {
                return pSSysServiceAPIBase.isPSSysReqItemIdDirty();
            }
            case 52: {
                return pSSysServiceAPIBase.isPSSysReqItemNameDirty();
            }
            case 53: {
                return pSSysServiceAPIBase.isPSSysResourceIdDirty();
            }
            case 54: {
                return pSSysServiceAPIBase.isPSSysResourceNameDirty();
            }
            case 55: {
                return pSSysServiceAPIBase.isPSSysSAHandlerIdDirty();
            }
            case 56: {
                return pSSysServiceAPIBase.isPSSysSAHandlerNameDirty();
            }
            case 57: {
                return pSSysServiceAPIBase.isPSSysServiceAPIIdDirty();
            }
            case 58: {
                return pSSysServiceAPIBase.isPSSysServiceAPINameDirty();
            }
            case 59: {
                return pSSysServiceAPIBase.isPSSysSFPluginIdDirty();
            }
            case 60: {
                return pSSysServiceAPIBase.isPSSysSFPluginNameDirty();
            }
            case 61: {
                return pSSysServiceAPIBase.isPSSystemIdDirty();
            }
            case 62: {
                return pSSysServiceAPIBase.isPSSystemNameDirty();
            }
            case 63: {
                return pSSysServiceAPIBase.isResetDefActionCodeNameDirty();
            }
            case 64: {
                return pSSysServiceAPIBase.isServiceCodeNameDirty();
            }
            case 65: {
                return pSSysServiceAPIBase.isServiceDTOFlagDirty();
            }
            case 66: {
                return pSSysServiceAPIBase.isServiceParamDirty();
            }
            case 67: {
                return pSSysServiceAPIBase.isServiceParam2Dirty();
            }
            case 68: {
                return pSSysServiceAPIBase.isServiceParam3Dirty();
            }
            case 69: {
                return pSSysServiceAPIBase.isServiceParam4Dirty();
            }
            case 70: {
                return pSSysServiceAPIBase.isServiceParamsDirty();
            }
            case 71: {
                return pSSysServiceAPIBase.isServiceTypeDirty();
            }
            case 72: {
                return pSSysServiceAPIBase.isUniqueTagDirty();
            }
            case 73: {
                return pSSysServiceAPIBase.isUpdateDateDirty();
            }
            case 74: {
                return pSSysServiceAPIBase.isUpdateManDirty();
            }
            case 75: {
                return pSSysServiceAPIBase.isUserCatDirty();
            }
            case 76: {
                return pSSysServiceAPIBase.isUserTagDirty();
            }
            case 77: {
                return pSSysServiceAPIBase.isUserTag2Dirty();
            }
            case 78: {
                return pSSysServiceAPIBase.isUserTag3Dirty();
            }
            case 79: {
                return pSSysServiceAPIBase.isUserTag4Dirty();
            }
            case 80: {
                return pSSysServiceAPIBase.isValidFlagDirty();
            }
            case 81: {
                return pSSysServiceAPIBase.isVerDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysServiceAPIBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysServiceAPIBase pSSysServiceAPIBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysServiceAPIBase.getAPILevel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"apilevel", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getAPILevel()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getAPIMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"apimode", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getAPIMode()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getAPITag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"apitag", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getAPITag()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getAPITag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"apitag2", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getAPITag2()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getAPIType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"apitype", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getAPIType()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getAuthCheckTokenUri() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authchecktokenuri", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getAuthCheckTokenUri()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getAuthClientId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authclientid", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getAuthClientId()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getAuthClientSecret() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authclientsecret", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getAuthClientSecret()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getAuthMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authmode", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getAuthMode()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getAuthParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authparam", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getAuthParam()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getAuthParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authparam2", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getAuthParam2()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getAuthParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authparam3", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getAuthParam3()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getAuthParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authparam4", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getAuthParam4()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getBaseClsParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"baseclsparams", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getBaseClsParams()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getCfgPSModelStorageId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cfgpsmodelstorageid", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getCfgPSModelStorageId()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getCfgTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cfgtag", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getCfgTag()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getCodeNameMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codenamemode", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getCodeNameMode()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getCustomMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"custommode", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getCustomMode()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getDefaultPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultport", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getDefaultPort()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getDefaultPSDEOPPrivId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultpsdeopprivid", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getDefaultPSDEOPPrivId()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getDefaultPSDEOPPrivName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultpsdeopprivname", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getDefaultPSDEOPPrivName()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getDefCreateReqMethod() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defcreatereqmethod", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getDefCreateReqMethod()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getDefDEActionReqMethod() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defdeactionreqmethod", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getDefDEActionReqMethod()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getDefDEDataSetReqMethod() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defdedatasetreqmethod", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getDefDEDataSetReqMethod()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getDefDeleteReqMethod() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defdeletereqmethod", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getDefDeleteReqMethod()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getDefGetDraftReqMethod() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defgetdraftreqmethod", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getDefGetDraftReqMethod()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getDefGetReqMethod() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defgetreqmethod", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getDefGetReqMethod()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getDefNeedResourceKey() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defneedresourcekey", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getDefNeedResourceKey()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getDefSelectReqMethod() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defselectreqmethod", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getDefSelectReqMethod()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getDefUpdateReqMethod() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defupdatereqmethod", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getDefUpdateReqMethod()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getDEPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"depssyssfpluginid", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getDEPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getDEPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"depssyssfpluginname", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getDEPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getEnableAPIModelEx() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableapimodelex", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getEnableAPIModelEx()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getEnableGateway() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablegateway", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getEnableGateway()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getIgnoreAuthPatterns() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ignoreauthpatterns", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getIgnoreAuthPatterns()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getNamingService() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"namingservice", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getNamingService()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getOutPSSysTranslatorId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"outpssystranslatorid", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getOutPSSysTranslatorId()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getOutPSSysTranslatorName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"outpssystranslatorname", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getOutPSSysTranslatorName()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getPredefinedType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"predefinedtype", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getPredefinedType()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getPSDevSlnSysAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysapiid", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getPSDevSlnSysAPIId()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getPSSysReqItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemid", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getPSSysReqItemId()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getPSSysReqItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemname", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getPSSysReqItemName()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getPSSysResourceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysresourceid", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getPSSysResourceId()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getPSSysResourceName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysresourcename", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getPSSysResourceName()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getPSSysSAHandlerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssahandlerid", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getPSSysSAHandlerId()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getPSSysSAHandlerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssahandlername", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getPSSysSAHandlerName()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getPSSysServiceAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysserviceapiid", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getPSSysServiceAPIId()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getPSSysServiceAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysserviceapiname", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getPSSysServiceAPIName()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getResetDefActionCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resetdefactioncodename", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getResetDefActionCodeName()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getServiceCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"servicecodename", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getServiceCodeName()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getServiceDTOFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"servicedtoflag", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getServiceDTOFlag()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getServiceParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"serviceparam", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getServiceParam()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getServiceParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"serviceparam2", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getServiceParam2()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getServiceParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"serviceparam3", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getServiceParam3()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getServiceParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"serviceparam4", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getServiceParam4()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getServiceParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"serviceparams", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getServiceParams()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getServiceType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"servicetype", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getServiceType()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getUniqueTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uniquetag", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getUniqueTag()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSSysServiceAPIBase.getVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ver", (Object)PSSysServiceAPIBase.getJSONValue((Object)pSSysServiceAPIBase.getVer()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysServiceAPIBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysServiceAPIBase pSSysServiceAPIBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysServiceAPIBase.getAPILevel() != null) {
            object = pSSysServiceAPIBase.getAPILevel();
            xmlNode.setAttribute(FIELD_APILEVEL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysServiceAPIBase.getAPIMode() != null) {
            object = pSSysServiceAPIBase.getAPIMode();
            xmlNode.setAttribute(FIELD_APIMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysServiceAPIBase.getAPITag() != null) {
            object = pSSysServiceAPIBase.getAPITag();
            xmlNode.setAttribute(FIELD_APITAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getAPITag2() != null) {
            object = pSSysServiceAPIBase.getAPITag2();
            xmlNode.setAttribute(FIELD_APITAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getAPIType() != null) {
            object = pSSysServiceAPIBase.getAPIType();
            xmlNode.setAttribute(FIELD_APITYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getAuthCheckTokenUri() != null) {
            object = pSSysServiceAPIBase.getAuthCheckTokenUri();
            xmlNode.setAttribute(FIELD_AUTHCHECKTOKENURI, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getAuthClientId() != null) {
            object = pSSysServiceAPIBase.getAuthClientId();
            xmlNode.setAttribute(FIELD_AUTHCLIENTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getAuthClientSecret() != null) {
            object = pSSysServiceAPIBase.getAuthClientSecret();
            xmlNode.setAttribute(FIELD_AUTHCLIENTSECRET, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getAuthMode() != null) {
            object = pSSysServiceAPIBase.getAuthMode();
            xmlNode.setAttribute(FIELD_AUTHMODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getAuthParam() != null) {
            object = pSSysServiceAPIBase.getAuthParam();
            xmlNode.setAttribute(FIELD_AUTHPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getAuthParam2() != null) {
            object = pSSysServiceAPIBase.getAuthParam2();
            xmlNode.setAttribute(FIELD_AUTHPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getAuthParam3() != null) {
            object = pSSysServiceAPIBase.getAuthParam3();
            xmlNode.setAttribute(FIELD_AUTHPARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getAuthParam4() != null) {
            object = pSSysServiceAPIBase.getAuthParam4();
            xmlNode.setAttribute(FIELD_AUTHPARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getBaseClsParams() != null) {
            object = pSSysServiceAPIBase.getBaseClsParams();
            xmlNode.setAttribute(FIELD_BASECLSPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getCfgPSModelStorageId() != null) {
            object = pSSysServiceAPIBase.getCfgPSModelStorageId();
            xmlNode.setAttribute(FIELD_CFGPSMODELSTORAGEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getCfgTag() != null) {
            object = pSSysServiceAPIBase.getCfgTag();
            xmlNode.setAttribute(FIELD_CFGTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getCodeName() != null) {
            object = pSSysServiceAPIBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getCodeNameMode() != null) {
            object = pSSysServiceAPIBase.getCodeNameMode();
            xmlNode.setAttribute(FIELD_CODENAMEMODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getCreateDate() != null) {
            object = pSSysServiceAPIBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysServiceAPIBase.getCreateMan() != null) {
            object = pSSysServiceAPIBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getCustomCode() != null) {
            object = pSSysServiceAPIBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getCustomMode() != null) {
            object = pSSysServiceAPIBase.getCustomMode();
            xmlNode.setAttribute(FIELD_CUSTOMMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysServiceAPIBase.getDefaultPort() != null) {
            object = pSSysServiceAPIBase.getDefaultPort();
            xmlNode.setAttribute(FIELD_DEFAULTPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysServiceAPIBase.getDefaultPSDEOPPrivId() != null) {
            object = pSSysServiceAPIBase.getDefaultPSDEOPPrivId();
            xmlNode.setAttribute(FIELD_DEFAULTPSDEOPPRIVID, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getDefaultPSDEOPPrivName() != null) {
            object = pSSysServiceAPIBase.getDefaultPSDEOPPrivName();
            xmlNode.setAttribute(FIELD_DEFAULTPSDEOPPRIVNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getDefCreateReqMethod() != null) {
            object = pSSysServiceAPIBase.getDefCreateReqMethod();
            xmlNode.setAttribute(FIELD_DEFCREATEREQMETHOD, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getDefDEActionReqMethod() != null) {
            object = pSSysServiceAPIBase.getDefDEActionReqMethod();
            xmlNode.setAttribute(FIELD_DEFDEACTIONREQMETHOD, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getDefDEDataSetReqMethod() != null) {
            object = pSSysServiceAPIBase.getDefDEDataSetReqMethod();
            xmlNode.setAttribute(FIELD_DEFDEDATASETREQMETHOD, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getDefDeleteReqMethod() != null) {
            object = pSSysServiceAPIBase.getDefDeleteReqMethod();
            xmlNode.setAttribute(FIELD_DEFDELETEREQMETHOD, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getDefGetDraftReqMethod() != null) {
            object = pSSysServiceAPIBase.getDefGetDraftReqMethod();
            xmlNode.setAttribute(FIELD_DEFGETDRAFTREQMETHOD, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getDefGetReqMethod() != null) {
            object = pSSysServiceAPIBase.getDefGetReqMethod();
            xmlNode.setAttribute(FIELD_DEFGETREQMETHOD, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getDefNeedResourceKey() != null) {
            object = pSSysServiceAPIBase.getDefNeedResourceKey();
            xmlNode.setAttribute(FIELD_DEFNEEDRESOURCEKEY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysServiceAPIBase.getDefSelectReqMethod() != null) {
            object = pSSysServiceAPIBase.getDefSelectReqMethod();
            xmlNode.setAttribute(FIELD_DEFSELECTREQMETHOD, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getDefUpdateReqMethod() != null) {
            object = pSSysServiceAPIBase.getDefUpdateReqMethod();
            xmlNode.setAttribute(FIELD_DEFUPDATEREQMETHOD, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getDEPSSysSFPluginId() != null) {
            object = pSSysServiceAPIBase.getDEPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_DEPSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getDEPSSysSFPluginName() != null) {
            object = pSSysServiceAPIBase.getDEPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_DEPSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getEnableAPIModelEx() != null) {
            object = pSSysServiceAPIBase.getEnableAPIModelEx();
            xmlNode.setAttribute(FIELD_ENABLEAPIMODELEX, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysServiceAPIBase.getEnableGateway() != null) {
            object = pSSysServiceAPIBase.getEnableGateway();
            xmlNode.setAttribute(FIELD_ENABLEGATEWAY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysServiceAPIBase.getIgnoreAuthPatterns() != null) {
            object = pSSysServiceAPIBase.getIgnoreAuthPatterns();
            xmlNode.setAttribute(FIELD_IGNOREAUTHPATTERNS, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getLockFlag() != null) {
            object = pSSysServiceAPIBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysServiceAPIBase.getMemo() != null) {
            object = pSSysServiceAPIBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getNamingService() != null) {
            object = pSSysServiceAPIBase.getNamingService();
            xmlNode.setAttribute(FIELD_NAMINGSERVICE, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getOrderValue() != null) {
            object = pSSysServiceAPIBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysServiceAPIBase.getOutPSSysTranslatorId() != null) {
            object = pSSysServiceAPIBase.getOutPSSysTranslatorId();
            xmlNode.setAttribute(FIELD_OUTPSSYSTRANSLATORID, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getOutPSSysTranslatorName() != null) {
            object = pSSysServiceAPIBase.getOutPSSysTranslatorName();
            xmlNode.setAttribute(FIELD_OUTPSSYSTRANSLATORNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getPredefinedType() != null) {
            object = pSSysServiceAPIBase.getPredefinedType();
            xmlNode.setAttribute(FIELD_PREDEFINEDTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getPSDevSlnSysAPIId() != null) {
            object = pSSysServiceAPIBase.getPSDevSlnSysAPIId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getPSModuleId() != null) {
            object = pSSysServiceAPIBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getPSModuleName() != null) {
            object = pSSysServiceAPIBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getPSSysDynaModelId() != null) {
            object = pSSysServiceAPIBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getPSSysDynaModelName() != null) {
            object = pSSysServiceAPIBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getPSSysReqItemId() != null) {
            object = pSSysServiceAPIBase.getPSSysReqItemId();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getPSSysReqItemName() != null) {
            object = pSSysServiceAPIBase.getPSSysReqItemName();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getPSSysResourceId() != null) {
            object = pSSysServiceAPIBase.getPSSysResourceId();
            xmlNode.setAttribute(FIELD_PSSYSRESOURCEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getPSSysResourceName() != null) {
            object = pSSysServiceAPIBase.getPSSysResourceName();
            xmlNode.setAttribute(FIELD_PSSYSRESOURCENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getPSSysSAHandlerId() != null) {
            object = pSSysServiceAPIBase.getPSSysSAHandlerId();
            xmlNode.setAttribute(FIELD_PSSYSSAHANDLERID, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getPSSysSAHandlerName() != null) {
            object = pSSysServiceAPIBase.getPSSysSAHandlerName();
            xmlNode.setAttribute(FIELD_PSSYSSAHANDLERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getPSSysServiceAPIId() != null) {
            object = pSSysServiceAPIBase.getPSSysServiceAPIId();
            xmlNode.setAttribute(FIELD_PSSYSSERVICEAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getPSSysServiceAPIName() != null) {
            object = pSSysServiceAPIBase.getPSSysServiceAPIName();
            xmlNode.setAttribute(FIELD_PSSYSSERVICEAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getPSSysSFPluginId() != null) {
            object = pSSysServiceAPIBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getPSSysSFPluginName() != null) {
            object = pSSysServiceAPIBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getPSSystemId() != null) {
            object = pSSysServiceAPIBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getPSSystemName() != null) {
            object = pSSysServiceAPIBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getResetDefActionCodeName() != null) {
            object = pSSysServiceAPIBase.getResetDefActionCodeName();
            xmlNode.setAttribute(FIELD_RESETDEFACTIONCODENAME, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysServiceAPIBase.getServiceCodeName() != null) {
            object = pSSysServiceAPIBase.getServiceCodeName();
            xmlNode.setAttribute(FIELD_SERVICECODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getServiceDTOFlag() != null) {
            object = pSSysServiceAPIBase.getServiceDTOFlag();
            xmlNode.setAttribute(FIELD_SERVICEDTOFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysServiceAPIBase.getServiceParam() != null) {
            object = pSSysServiceAPIBase.getServiceParam();
            xmlNode.setAttribute(FIELD_SERVICEPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getServiceParam2() != null) {
            object = pSSysServiceAPIBase.getServiceParam2();
            xmlNode.setAttribute(FIELD_SERVICEPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getServiceParam3() != null) {
            object = pSSysServiceAPIBase.getServiceParam3();
            xmlNode.setAttribute(FIELD_SERVICEPARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getServiceParam4() != null) {
            object = pSSysServiceAPIBase.getServiceParam4();
            xmlNode.setAttribute(FIELD_SERVICEPARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getServiceParams() != null) {
            object = pSSysServiceAPIBase.getServiceParams();
            xmlNode.setAttribute(FIELD_SERVICEPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getServiceType() != null) {
            object = pSSysServiceAPIBase.getServiceType();
            xmlNode.setAttribute(FIELD_SERVICETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getUniqueTag() != null) {
            object = pSSysServiceAPIBase.getUniqueTag();
            xmlNode.setAttribute(FIELD_UNIQUETAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getUpdateDate() != null) {
            object = pSSysServiceAPIBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysServiceAPIBase.getUpdateMan() != null) {
            object = pSSysServiceAPIBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getUserCat() != null) {
            object = pSSysServiceAPIBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getUserTag() != null) {
            object = pSSysServiceAPIBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getUserTag2() != null) {
            object = pSSysServiceAPIBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getUserTag3() != null) {
            object = pSSysServiceAPIBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getUserTag4() != null) {
            object = pSSysServiceAPIBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysServiceAPIBase.getValidFlag() != null) {
            object = pSSysServiceAPIBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysServiceAPIBase.getVer() != null) {
            object = pSSysServiceAPIBase.getVer();
            xmlNode.setAttribute(FIELD_VER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysServiceAPIBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysServiceAPIBase pSSysServiceAPIBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysServiceAPIBase.isAPILevelDirty() && (bl || pSSysServiceAPIBase.getAPILevel() != null)) {
            iDataObject.set(FIELD_APILEVEL, (Object)pSSysServiceAPIBase.getAPILevel());
        }
        if (pSSysServiceAPIBase.isAPIModeDirty() && (bl || pSSysServiceAPIBase.getAPIMode() != null)) {
            iDataObject.set(FIELD_APIMODE, (Object)pSSysServiceAPIBase.getAPIMode());
        }
        if (pSSysServiceAPIBase.isAPITagDirty() && (bl || pSSysServiceAPIBase.getAPITag() != null)) {
            iDataObject.set(FIELD_APITAG, (Object)pSSysServiceAPIBase.getAPITag());
        }
        if (pSSysServiceAPIBase.isAPITag2Dirty() && (bl || pSSysServiceAPIBase.getAPITag2() != null)) {
            iDataObject.set(FIELD_APITAG2, (Object)pSSysServiceAPIBase.getAPITag2());
        }
        if (pSSysServiceAPIBase.isAPITypeDirty() && (bl || pSSysServiceAPIBase.getAPIType() != null)) {
            iDataObject.set(FIELD_APITYPE, (Object)pSSysServiceAPIBase.getAPIType());
        }
        if (pSSysServiceAPIBase.isAuthCheckTokenUriDirty() && (bl || pSSysServiceAPIBase.getAuthCheckTokenUri() != null)) {
            iDataObject.set(FIELD_AUTHCHECKTOKENURI, (Object)pSSysServiceAPIBase.getAuthCheckTokenUri());
        }
        if (pSSysServiceAPIBase.isAuthClientIdDirty() && (bl || pSSysServiceAPIBase.getAuthClientId() != null)) {
            iDataObject.set(FIELD_AUTHCLIENTID, (Object)pSSysServiceAPIBase.getAuthClientId());
        }
        if (pSSysServiceAPIBase.isAuthClientSecretDirty() && (bl || pSSysServiceAPIBase.getAuthClientSecret() != null)) {
            iDataObject.set(FIELD_AUTHCLIENTSECRET, (Object)pSSysServiceAPIBase.getAuthClientSecret());
        }
        if (pSSysServiceAPIBase.isAuthModeDirty() && (bl || pSSysServiceAPIBase.getAuthMode() != null)) {
            iDataObject.set(FIELD_AUTHMODE, (Object)pSSysServiceAPIBase.getAuthMode());
        }
        if (pSSysServiceAPIBase.isAuthParamDirty() && (bl || pSSysServiceAPIBase.getAuthParam() != null)) {
            iDataObject.set(FIELD_AUTHPARAM, (Object)pSSysServiceAPIBase.getAuthParam());
        }
        if (pSSysServiceAPIBase.isAuthParam2Dirty() && (bl || pSSysServiceAPIBase.getAuthParam2() != null)) {
            iDataObject.set(FIELD_AUTHPARAM2, (Object)pSSysServiceAPIBase.getAuthParam2());
        }
        if (pSSysServiceAPIBase.isAuthParam3Dirty() && (bl || pSSysServiceAPIBase.getAuthParam3() != null)) {
            iDataObject.set(FIELD_AUTHPARAM3, (Object)pSSysServiceAPIBase.getAuthParam3());
        }
        if (pSSysServiceAPIBase.isAuthParam4Dirty() && (bl || pSSysServiceAPIBase.getAuthParam4() != null)) {
            iDataObject.set(FIELD_AUTHPARAM4, (Object)pSSysServiceAPIBase.getAuthParam4());
        }
        if (pSSysServiceAPIBase.isBaseClsParamsDirty() && (bl || pSSysServiceAPIBase.getBaseClsParams() != null)) {
            iDataObject.set(FIELD_BASECLSPARAMS, (Object)pSSysServiceAPIBase.getBaseClsParams());
        }
        if (pSSysServiceAPIBase.isCfgPSModelStorageIdDirty() && (bl || pSSysServiceAPIBase.getCfgPSModelStorageId() != null)) {
            iDataObject.set(FIELD_CFGPSMODELSTORAGEID, (Object)pSSysServiceAPIBase.getCfgPSModelStorageId());
        }
        if (pSSysServiceAPIBase.isCfgTagDirty() && (bl || pSSysServiceAPIBase.getCfgTag() != null)) {
            iDataObject.set(FIELD_CFGTAG, (Object)pSSysServiceAPIBase.getCfgTag());
        }
        if (pSSysServiceAPIBase.isCodeNameDirty() && (bl || pSSysServiceAPIBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysServiceAPIBase.getCodeName());
        }
        if (pSSysServiceAPIBase.isCodeNameModeDirty() && (bl || pSSysServiceAPIBase.getCodeNameMode() != null)) {
            iDataObject.set(FIELD_CODENAMEMODE, (Object)pSSysServiceAPIBase.getCodeNameMode());
        }
        if (pSSysServiceAPIBase.isCreateDateDirty() && (bl || pSSysServiceAPIBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysServiceAPIBase.getCreateDate());
        }
        if (pSSysServiceAPIBase.isCreateManDirty() && (bl || pSSysServiceAPIBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysServiceAPIBase.getCreateMan());
        }
        if (pSSysServiceAPIBase.isCustomCodeDirty() && (bl || pSSysServiceAPIBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSSysServiceAPIBase.getCustomCode());
        }
        if (pSSysServiceAPIBase.isCustomModeDirty() && (bl || pSSysServiceAPIBase.getCustomMode() != null)) {
            iDataObject.set(FIELD_CUSTOMMODE, (Object)pSSysServiceAPIBase.getCustomMode());
        }
        if (pSSysServiceAPIBase.isDefaultPortDirty() && (bl || pSSysServiceAPIBase.getDefaultPort() != null)) {
            iDataObject.set(FIELD_DEFAULTPORT, (Object)pSSysServiceAPIBase.getDefaultPort());
        }
        if (pSSysServiceAPIBase.isDefaultPSDEOPPrivIdDirty() && (bl || pSSysServiceAPIBase.getDefaultPSDEOPPrivId() != null)) {
            iDataObject.set(FIELD_DEFAULTPSDEOPPRIVID, (Object)pSSysServiceAPIBase.getDefaultPSDEOPPrivId());
        }
        if (pSSysServiceAPIBase.isDefaultPSDEOPPrivNameDirty() && (bl || pSSysServiceAPIBase.getDefaultPSDEOPPrivName() != null)) {
            iDataObject.set(FIELD_DEFAULTPSDEOPPRIVNAME, (Object)pSSysServiceAPIBase.getDefaultPSDEOPPrivName());
        }
        if (pSSysServiceAPIBase.isDefCreateReqMethodDirty() && (bl || pSSysServiceAPIBase.getDefCreateReqMethod() != null)) {
            iDataObject.set(FIELD_DEFCREATEREQMETHOD, (Object)pSSysServiceAPIBase.getDefCreateReqMethod());
        }
        if (pSSysServiceAPIBase.isDefDEActionReqMethodDirty() && (bl || pSSysServiceAPIBase.getDefDEActionReqMethod() != null)) {
            iDataObject.set(FIELD_DEFDEACTIONREQMETHOD, (Object)pSSysServiceAPIBase.getDefDEActionReqMethod());
        }
        if (pSSysServiceAPIBase.isDefDEDataSetReqMethodDirty() && (bl || pSSysServiceAPIBase.getDefDEDataSetReqMethod() != null)) {
            iDataObject.set(FIELD_DEFDEDATASETREQMETHOD, (Object)pSSysServiceAPIBase.getDefDEDataSetReqMethod());
        }
        if (pSSysServiceAPIBase.isDefDeleteReqMethodDirty() && (bl || pSSysServiceAPIBase.getDefDeleteReqMethod() != null)) {
            iDataObject.set(FIELD_DEFDELETEREQMETHOD, (Object)pSSysServiceAPIBase.getDefDeleteReqMethod());
        }
        if (pSSysServiceAPIBase.isDefGetDraftReqMethodDirty() && (bl || pSSysServiceAPIBase.getDefGetDraftReqMethod() != null)) {
            iDataObject.set(FIELD_DEFGETDRAFTREQMETHOD, (Object)pSSysServiceAPIBase.getDefGetDraftReqMethod());
        }
        if (pSSysServiceAPIBase.isDefGetReqMethodDirty() && (bl || pSSysServiceAPIBase.getDefGetReqMethod() != null)) {
            iDataObject.set(FIELD_DEFGETREQMETHOD, (Object)pSSysServiceAPIBase.getDefGetReqMethod());
        }
        if (pSSysServiceAPIBase.isDefNeedResourceKeyDirty() && (bl || pSSysServiceAPIBase.getDefNeedResourceKey() != null)) {
            iDataObject.set(FIELD_DEFNEEDRESOURCEKEY, (Object)pSSysServiceAPIBase.getDefNeedResourceKey());
        }
        if (pSSysServiceAPIBase.isDefSelectReqMethodDirty() && (bl || pSSysServiceAPIBase.getDefSelectReqMethod() != null)) {
            iDataObject.set(FIELD_DEFSELECTREQMETHOD, (Object)pSSysServiceAPIBase.getDefSelectReqMethod());
        }
        if (pSSysServiceAPIBase.isDefUpdateReqMethodDirty() && (bl || pSSysServiceAPIBase.getDefUpdateReqMethod() != null)) {
            iDataObject.set(FIELD_DEFUPDATEREQMETHOD, (Object)pSSysServiceAPIBase.getDefUpdateReqMethod());
        }
        if (pSSysServiceAPIBase.isDEPSSysSFPluginIdDirty() && (bl || pSSysServiceAPIBase.getDEPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_DEPSSYSSFPLUGINID, (Object)pSSysServiceAPIBase.getDEPSSysSFPluginId());
        }
        if (pSSysServiceAPIBase.isDEPSSysSFPluginNameDirty() && (bl || pSSysServiceAPIBase.getDEPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_DEPSSYSSFPLUGINNAME, (Object)pSSysServiceAPIBase.getDEPSSysSFPluginName());
        }
        if (pSSysServiceAPIBase.isEnableAPIModelExDirty() && (bl || pSSysServiceAPIBase.getEnableAPIModelEx() != null)) {
            iDataObject.set(FIELD_ENABLEAPIMODELEX, (Object)pSSysServiceAPIBase.getEnableAPIModelEx());
        }
        if (pSSysServiceAPIBase.isEnableGatewayDirty() && (bl || pSSysServiceAPIBase.getEnableGateway() != null)) {
            iDataObject.set(FIELD_ENABLEGATEWAY, (Object)pSSysServiceAPIBase.getEnableGateway());
        }
        if (pSSysServiceAPIBase.isIgnoreAuthPatternsDirty() && (bl || pSSysServiceAPIBase.getIgnoreAuthPatterns() != null)) {
            iDataObject.set(FIELD_IGNOREAUTHPATTERNS, (Object)pSSysServiceAPIBase.getIgnoreAuthPatterns());
        }
        if (pSSysServiceAPIBase.isLockFlagDirty() && (bl || pSSysServiceAPIBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSSysServiceAPIBase.getLockFlag());
        }
        if (pSSysServiceAPIBase.isMemoDirty() && (bl || pSSysServiceAPIBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysServiceAPIBase.getMemo());
        }
        if (pSSysServiceAPIBase.isNamingServiceDirty() && (bl || pSSysServiceAPIBase.getNamingService() != null)) {
            iDataObject.set(FIELD_NAMINGSERVICE, (Object)pSSysServiceAPIBase.getNamingService());
        }
        if (pSSysServiceAPIBase.isOrderValueDirty() && (bl || pSSysServiceAPIBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysServiceAPIBase.getOrderValue());
        }
        if (pSSysServiceAPIBase.isOutPSSysTranslatorIdDirty() && (bl || pSSysServiceAPIBase.getOutPSSysTranslatorId() != null)) {
            iDataObject.set(FIELD_OUTPSSYSTRANSLATORID, (Object)pSSysServiceAPIBase.getOutPSSysTranslatorId());
        }
        if (pSSysServiceAPIBase.isOutPSSysTranslatorNameDirty() && (bl || pSSysServiceAPIBase.getOutPSSysTranslatorName() != null)) {
            iDataObject.set(FIELD_OUTPSSYSTRANSLATORNAME, (Object)pSSysServiceAPIBase.getOutPSSysTranslatorName());
        }
        if (pSSysServiceAPIBase.isPredefinedTypeDirty() && (bl || pSSysServiceAPIBase.getPredefinedType() != null)) {
            iDataObject.set(FIELD_PREDEFINEDTYPE, (Object)pSSysServiceAPIBase.getPredefinedType());
        }
        if (pSSysServiceAPIBase.isPSDevSlnSysAPIIdDirty() && (bl || pSSysServiceAPIBase.getPSDevSlnSysAPIId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSAPIID, (Object)pSSysServiceAPIBase.getPSDevSlnSysAPIId());
        }
        if (pSSysServiceAPIBase.isPSModuleIdDirty() && (bl || pSSysServiceAPIBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysServiceAPIBase.getPSModuleId());
        }
        if (pSSysServiceAPIBase.isPSModuleNameDirty() && (bl || pSSysServiceAPIBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysServiceAPIBase.getPSModuleName());
        }
        if (pSSysServiceAPIBase.isPSSysDynaModelIdDirty() && (bl || pSSysServiceAPIBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSSysServiceAPIBase.getPSSysDynaModelId());
        }
        if (pSSysServiceAPIBase.isPSSysDynaModelNameDirty() && (bl || pSSysServiceAPIBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSSysServiceAPIBase.getPSSysDynaModelName());
        }
        if (pSSysServiceAPIBase.isPSSysReqItemIdDirty() && (bl || pSSysServiceAPIBase.getPSSysReqItemId() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMID, (Object)pSSysServiceAPIBase.getPSSysReqItemId());
        }
        if (pSSysServiceAPIBase.isPSSysReqItemNameDirty() && (bl || pSSysServiceAPIBase.getPSSysReqItemName() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMNAME, (Object)pSSysServiceAPIBase.getPSSysReqItemName());
        }
        if (pSSysServiceAPIBase.isPSSysResourceIdDirty() && (bl || pSSysServiceAPIBase.getPSSysResourceId() != null)) {
            iDataObject.set(FIELD_PSSYSRESOURCEID, (Object)pSSysServiceAPIBase.getPSSysResourceId());
        }
        if (pSSysServiceAPIBase.isPSSysResourceNameDirty() && (bl || pSSysServiceAPIBase.getPSSysResourceName() != null)) {
            iDataObject.set(FIELD_PSSYSRESOURCENAME, (Object)pSSysServiceAPIBase.getPSSysResourceName());
        }
        if (pSSysServiceAPIBase.isPSSysSAHandlerIdDirty() && (bl || pSSysServiceAPIBase.getPSSysSAHandlerId() != null)) {
            iDataObject.set(FIELD_PSSYSSAHANDLERID, (Object)pSSysServiceAPIBase.getPSSysSAHandlerId());
        }
        if (pSSysServiceAPIBase.isPSSysSAHandlerNameDirty() && (bl || pSSysServiceAPIBase.getPSSysSAHandlerName() != null)) {
            iDataObject.set(FIELD_PSSYSSAHANDLERNAME, (Object)pSSysServiceAPIBase.getPSSysSAHandlerName());
        }
        if (pSSysServiceAPIBase.isPSSysServiceAPIIdDirty() && (bl || pSSysServiceAPIBase.getPSSysServiceAPIId() != null)) {
            iDataObject.set(FIELD_PSSYSSERVICEAPIID, (Object)pSSysServiceAPIBase.getPSSysServiceAPIId());
        }
        if (pSSysServiceAPIBase.isPSSysServiceAPINameDirty() && (bl || pSSysServiceAPIBase.getPSSysServiceAPIName() != null)) {
            iDataObject.set(FIELD_PSSYSSERVICEAPINAME, (Object)pSSysServiceAPIBase.getPSSysServiceAPIName());
        }
        if (pSSysServiceAPIBase.isPSSysSFPluginIdDirty() && (bl || pSSysServiceAPIBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSSysServiceAPIBase.getPSSysSFPluginId());
        }
        if (pSSysServiceAPIBase.isPSSysSFPluginNameDirty() && (bl || pSSysServiceAPIBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSSysServiceAPIBase.getPSSysSFPluginName());
        }
        if (pSSysServiceAPIBase.isPSSystemIdDirty() && (bl || pSSysServiceAPIBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysServiceAPIBase.getPSSystemId());
        }
        if (pSSysServiceAPIBase.isPSSystemNameDirty() && (bl || pSSysServiceAPIBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysServiceAPIBase.getPSSystemName());
        }
        if (pSSysServiceAPIBase.isResetDefActionCodeNameDirty() && (bl || pSSysServiceAPIBase.getResetDefActionCodeName() != null)) {
            iDataObject.set(FIELD_RESETDEFACTIONCODENAME, (Object)pSSysServiceAPIBase.getResetDefActionCodeName());
        }
        if (pSSysServiceAPIBase.isServiceCodeNameDirty() && (bl || pSSysServiceAPIBase.getServiceCodeName() != null)) {
            iDataObject.set(FIELD_SERVICECODENAME, (Object)pSSysServiceAPIBase.getServiceCodeName());
        }
        if (pSSysServiceAPIBase.isServiceDTOFlagDirty() && (bl || pSSysServiceAPIBase.getServiceDTOFlag() != null)) {
            iDataObject.set(FIELD_SERVICEDTOFLAG, (Object)pSSysServiceAPIBase.getServiceDTOFlag());
        }
        if (pSSysServiceAPIBase.isServiceParamDirty() && (bl || pSSysServiceAPIBase.getServiceParam() != null)) {
            iDataObject.set(FIELD_SERVICEPARAM, (Object)pSSysServiceAPIBase.getServiceParam());
        }
        if (pSSysServiceAPIBase.isServiceParam2Dirty() && (bl || pSSysServiceAPIBase.getServiceParam2() != null)) {
            iDataObject.set(FIELD_SERVICEPARAM2, (Object)pSSysServiceAPIBase.getServiceParam2());
        }
        if (pSSysServiceAPIBase.isServiceParam3Dirty() && (bl || pSSysServiceAPIBase.getServiceParam3() != null)) {
            iDataObject.set(FIELD_SERVICEPARAM3, (Object)pSSysServiceAPIBase.getServiceParam3());
        }
        if (pSSysServiceAPIBase.isServiceParam4Dirty() && (bl || pSSysServiceAPIBase.getServiceParam4() != null)) {
            iDataObject.set(FIELD_SERVICEPARAM4, (Object)pSSysServiceAPIBase.getServiceParam4());
        }
        if (pSSysServiceAPIBase.isServiceParamsDirty() && (bl || pSSysServiceAPIBase.getServiceParams() != null)) {
            iDataObject.set(FIELD_SERVICEPARAMS, (Object)pSSysServiceAPIBase.getServiceParams());
        }
        if (pSSysServiceAPIBase.isServiceTypeDirty() && (bl || pSSysServiceAPIBase.getServiceType() != null)) {
            iDataObject.set(FIELD_SERVICETYPE, (Object)pSSysServiceAPIBase.getServiceType());
        }
        if (pSSysServiceAPIBase.isUniqueTagDirty() && (bl || pSSysServiceAPIBase.getUniqueTag() != null)) {
            iDataObject.set(FIELD_UNIQUETAG, (Object)pSSysServiceAPIBase.getUniqueTag());
        }
        if (pSSysServiceAPIBase.isUpdateDateDirty() && (bl || pSSysServiceAPIBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysServiceAPIBase.getUpdateDate());
        }
        if (pSSysServiceAPIBase.isUpdateManDirty() && (bl || pSSysServiceAPIBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysServiceAPIBase.getUpdateMan());
        }
        if (pSSysServiceAPIBase.isUserCatDirty() && (bl || pSSysServiceAPIBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysServiceAPIBase.getUserCat());
        }
        if (pSSysServiceAPIBase.isUserTagDirty() && (bl || pSSysServiceAPIBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysServiceAPIBase.getUserTag());
        }
        if (pSSysServiceAPIBase.isUserTag2Dirty() && (bl || pSSysServiceAPIBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysServiceAPIBase.getUserTag2());
        }
        if (pSSysServiceAPIBase.isUserTag3Dirty() && (bl || pSSysServiceAPIBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysServiceAPIBase.getUserTag3());
        }
        if (pSSysServiceAPIBase.isUserTag4Dirty() && (bl || pSSysServiceAPIBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysServiceAPIBase.getUserTag4());
        }
        if (pSSysServiceAPIBase.isValidFlagDirty() && (bl || pSSysServiceAPIBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysServiceAPIBase.getValidFlag());
        }
        if (pSSysServiceAPIBase.isVerDirty() && (bl || pSSysServiceAPIBase.getVer() != null)) {
            iDataObject.set(FIELD_VER, (Object)pSSysServiceAPIBase.getVer());
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
        return PSSysServiceAPIBase.remove(this, n);
    }

    private static boolean remove(PSSysServiceAPIBase pSSysServiceAPIBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysServiceAPIBase.resetAPILevel();
                return true;
            }
            case 1: {
                pSSysServiceAPIBase.resetAPIMode();
                return true;
            }
            case 2: {
                pSSysServiceAPIBase.resetAPITag();
                return true;
            }
            case 3: {
                pSSysServiceAPIBase.resetAPITag2();
                return true;
            }
            case 4: {
                pSSysServiceAPIBase.resetAPIType();
                return true;
            }
            case 5: {
                pSSysServiceAPIBase.resetAuthCheckTokenUri();
                return true;
            }
            case 6: {
                pSSysServiceAPIBase.resetAuthClientId();
                return true;
            }
            case 7: {
                pSSysServiceAPIBase.resetAuthClientSecret();
                return true;
            }
            case 8: {
                pSSysServiceAPIBase.resetAuthMode();
                return true;
            }
            case 9: {
                pSSysServiceAPIBase.resetAuthParam();
                return true;
            }
            case 10: {
                pSSysServiceAPIBase.resetAuthParam2();
                return true;
            }
            case 11: {
                pSSysServiceAPIBase.resetAuthParam3();
                return true;
            }
            case 12: {
                pSSysServiceAPIBase.resetAuthParam4();
                return true;
            }
            case 13: {
                pSSysServiceAPIBase.resetBaseClsParams();
                return true;
            }
            case 14: {
                pSSysServiceAPIBase.resetCfgPSModelStorageId();
                return true;
            }
            case 15: {
                pSSysServiceAPIBase.resetCfgTag();
                return true;
            }
            case 16: {
                pSSysServiceAPIBase.resetCodeName();
                return true;
            }
            case 17: {
                pSSysServiceAPIBase.resetCodeNameMode();
                return true;
            }
            case 18: {
                pSSysServiceAPIBase.resetCreateDate();
                return true;
            }
            case 19: {
                pSSysServiceAPIBase.resetCreateMan();
                return true;
            }
            case 20: {
                pSSysServiceAPIBase.resetCustomCode();
                return true;
            }
            case 21: {
                pSSysServiceAPIBase.resetCustomMode();
                return true;
            }
            case 22: {
                pSSysServiceAPIBase.resetDefaultPort();
                return true;
            }
            case 23: {
                pSSysServiceAPIBase.resetDefaultPSDEOPPrivId();
                return true;
            }
            case 24: {
                pSSysServiceAPIBase.resetDefaultPSDEOPPrivName();
                return true;
            }
            case 25: {
                pSSysServiceAPIBase.resetDefCreateReqMethod();
                return true;
            }
            case 26: {
                pSSysServiceAPIBase.resetDefDEActionReqMethod();
                return true;
            }
            case 27: {
                pSSysServiceAPIBase.resetDefDEDataSetReqMethod();
                return true;
            }
            case 28: {
                pSSysServiceAPIBase.resetDefDeleteReqMethod();
                return true;
            }
            case 29: {
                pSSysServiceAPIBase.resetDefGetDraftReqMethod();
                return true;
            }
            case 30: {
                pSSysServiceAPIBase.resetDefGetReqMethod();
                return true;
            }
            case 31: {
                pSSysServiceAPIBase.resetDefNeedResourceKey();
                return true;
            }
            case 32: {
                pSSysServiceAPIBase.resetDefSelectReqMethod();
                return true;
            }
            case 33: {
                pSSysServiceAPIBase.resetDefUpdateReqMethod();
                return true;
            }
            case 34: {
                pSSysServiceAPIBase.resetDEPSSysSFPluginId();
                return true;
            }
            case 35: {
                pSSysServiceAPIBase.resetDEPSSysSFPluginName();
                return true;
            }
            case 36: {
                pSSysServiceAPIBase.resetEnableAPIModelEx();
                return true;
            }
            case 37: {
                pSSysServiceAPIBase.resetEnableGateway();
                return true;
            }
            case 38: {
                pSSysServiceAPIBase.resetIgnoreAuthPatterns();
                return true;
            }
            case 39: {
                pSSysServiceAPIBase.resetLockFlag();
                return true;
            }
            case 40: {
                pSSysServiceAPIBase.resetMemo();
                return true;
            }
            case 41: {
                pSSysServiceAPIBase.resetNamingService();
                return true;
            }
            case 42: {
                pSSysServiceAPIBase.resetOrderValue();
                return true;
            }
            case 43: {
                pSSysServiceAPIBase.resetOutPSSysTranslatorId();
                return true;
            }
            case 44: {
                pSSysServiceAPIBase.resetOutPSSysTranslatorName();
                return true;
            }
            case 45: {
                pSSysServiceAPIBase.resetPredefinedType();
                return true;
            }
            case 46: {
                pSSysServiceAPIBase.resetPSDevSlnSysAPIId();
                return true;
            }
            case 47: {
                pSSysServiceAPIBase.resetPSModuleId();
                return true;
            }
            case 48: {
                pSSysServiceAPIBase.resetPSModuleName();
                return true;
            }
            case 49: {
                pSSysServiceAPIBase.resetPSSysDynaModelId();
                return true;
            }
            case 50: {
                pSSysServiceAPIBase.resetPSSysDynaModelName();
                return true;
            }
            case 51: {
                pSSysServiceAPIBase.resetPSSysReqItemId();
                return true;
            }
            case 52: {
                pSSysServiceAPIBase.resetPSSysReqItemName();
                return true;
            }
            case 53: {
                pSSysServiceAPIBase.resetPSSysResourceId();
                return true;
            }
            case 54: {
                pSSysServiceAPIBase.resetPSSysResourceName();
                return true;
            }
            case 55: {
                pSSysServiceAPIBase.resetPSSysSAHandlerId();
                return true;
            }
            case 56: {
                pSSysServiceAPIBase.resetPSSysSAHandlerName();
                return true;
            }
            case 57: {
                pSSysServiceAPIBase.resetPSSysServiceAPIId();
                return true;
            }
            case 58: {
                pSSysServiceAPIBase.resetPSSysServiceAPIName();
                return true;
            }
            case 59: {
                pSSysServiceAPIBase.resetPSSysSFPluginId();
                return true;
            }
            case 60: {
                pSSysServiceAPIBase.resetPSSysSFPluginName();
                return true;
            }
            case 61: {
                pSSysServiceAPIBase.resetPSSystemId();
                return true;
            }
            case 62: {
                pSSysServiceAPIBase.resetPSSystemName();
                return true;
            }
            case 63: {
                pSSysServiceAPIBase.resetResetDefActionCodeName();
                return true;
            }
            case 64: {
                pSSysServiceAPIBase.resetServiceCodeName();
                return true;
            }
            case 65: {
                pSSysServiceAPIBase.resetServiceDTOFlag();
                return true;
            }
            case 66: {
                pSSysServiceAPIBase.resetServiceParam();
                return true;
            }
            case 67: {
                pSSysServiceAPIBase.resetServiceParam2();
                return true;
            }
            case 68: {
                pSSysServiceAPIBase.resetServiceParam3();
                return true;
            }
            case 69: {
                pSSysServiceAPIBase.resetServiceParam4();
                return true;
            }
            case 70: {
                pSSysServiceAPIBase.resetServiceParams();
                return true;
            }
            case 71: {
                pSSysServiceAPIBase.resetServiceType();
                return true;
            }
            case 72: {
                pSSysServiceAPIBase.resetUniqueTag();
                return true;
            }
            case 73: {
                pSSysServiceAPIBase.resetUpdateDate();
                return true;
            }
            case 74: {
                pSSysServiceAPIBase.resetUpdateMan();
                return true;
            }
            case 75: {
                pSSysServiceAPIBase.resetUserCat();
                return true;
            }
            case 76: {
                pSSysServiceAPIBase.resetUserTag();
                return true;
            }
            case 77: {
                pSSysServiceAPIBase.resetUserTag2();
                return true;
            }
            case 78: {
                pSSysServiceAPIBase.resetUserTag3();
                return true;
            }
            case 79: {
                pSSysServiceAPIBase.resetUserTag4();
                return true;
            }
            case 80: {
                pSSysServiceAPIBase.resetValidFlag();
                return true;
            }
            case 81: {
                pSSysServiceAPIBase.resetVer();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEOPPriv getDefaultPSDEOPPriv() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultPSDEOPPriv();
        }
        if (this.getDefaultPSDEOPPrivId() == null) {
            return null;
        }
        Integer n = this.objDefaultPSDEOPPrivLock;
        synchronized (n) {
            if (this.defaultpsdeoppriv != null && DataTypeHelper.compare((int)25, (Object)this.getDefaultPSDEOPPrivId(), (Object)this.defaultpsdeoppriv.getPSDEOPPrivId()) != 0L) {
                this.defaultpsdeoppriv = null;
            }
            if (this.defaultpsdeoppriv == null) {
                PSDEOPPriv pSDEOPPriv = new PSDEOPPriv();
                pSDEOPPriv.setPSDEOPPrivId(this.getDefaultPSDEOPPrivId());
                PSDEOPPrivService pSDEOPPrivService = (PSDEOPPrivService)ServiceGlobal.getService(PSDEOPPrivService.class, (SessionFactory)this.getSessionFactory());
                pSDEOPPrivService.autoGet((IEntity)pSDEOPPriv);
                this.defaultpsdeoppriv = pSDEOPPriv;
            }
            return this.defaultpsdeoppriv;
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
    public PSSysResource getPSSysResource() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysResource();
        }
        if (this.getPSSysResourceId() == null) {
            return null;
        }
        Integer n = this.objPSSysResourceLock;
        synchronized (n) {
            if (this.pssysresource != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysResourceId(), (Object)this.pssysresource.getPSSysResourceId()) != 0L) {
                this.pssysresource = null;
            }
            if (this.pssysresource == null) {
                PSSysResource pSSysResource = new PSSysResource();
                pSSysResource.setPSSysResourceId(this.getPSSysResourceId());
                PSSysResourceService pSSysResourceService = (PSSysResourceService)ServiceGlobal.getService(PSSysResourceService.class, (SessionFactory)this.getSessionFactory());
                pSSysResourceService.autoGet((IEntity)pSSysResource);
                this.pssysresource = pSSysResource;
            }
            return this.pssysresource;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysSAHandler getPSSysSAHandler() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSAHandler();
        }
        if (this.getPSSysSAHandlerId() == null) {
            return null;
        }
        Integer n = this.objPSSysSAHandlerLock;
        synchronized (n) {
            if (this.pssyssahandler != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysSAHandlerId(), (Object)this.pssyssahandler.getPSSysSAHandlerId()) != 0L) {
                this.pssyssahandler = null;
            }
            if (this.pssyssahandler == null) {
                PSSysSAHandler pSSysSAHandler = new PSSysSAHandler();
                pSSysSAHandler.setPSSysSAHandlerId(this.getPSSysSAHandlerId());
                PSSysSAHandlerService pSSysSAHandlerService = (PSSysSAHandlerService)ServiceGlobal.getService(PSSysSAHandlerService.class, (SessionFactory)this.getSessionFactory());
                pSSysSAHandlerService.autoGet((IEntity)pSSysSAHandler);
                this.pssyssahandler = pSSysSAHandler;
            }
            return this.pssyssahandler;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysSFPlugin getDEPSSysSFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEPSSysSFPlugin();
        }
        if (this.getDEPSSysSFPluginId() == null) {
            return null;
        }
        Integer n = this.objDEPSSysSFPluginLock;
        synchronized (n) {
            if (this.depssyssfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getDEPSSysSFPluginId(), (Object)this.depssyssfplugin.getPSSysSFPluginId()) != 0L) {
                this.depssyssfplugin = null;
            }
            if (this.depssyssfplugin == null) {
                PSSysSFPlugin pSSysSFPlugin = new PSSysSFPlugin();
                pSSysSFPlugin.setPSSysSFPluginId(this.getDEPSSysSFPluginId());
                PSSysSFPluginService pSSysSFPluginService = (PSSysSFPluginService)ServiceGlobal.getService(PSSysSFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysSFPluginService.autoGet((IEntity)pSSysSFPlugin);
                this.depssyssfplugin = pSSysSFPlugin;
            }
            return this.depssyssfplugin;
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysTranslator getOutPSSysTranslator() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOutPSSysTranslator();
        }
        if (this.getOutPSSysTranslatorId() == null) {
            return null;
        }
        Integer n = this.objOutPSSysTranslatorLock;
        synchronized (n) {
            if (this.outpssystranslator != null && DataTypeHelper.compare((int)25, (Object)this.getOutPSSysTranslatorId(), (Object)this.outpssystranslator.getPSSysTranslatorId()) != 0L) {
                this.outpssystranslator = null;
            }
            if (this.outpssystranslator == null) {
                PSSysTranslator pSSysTranslator = new PSSysTranslator();
                pSSysTranslator.setPSSysTranslatorId(this.getOutPSSysTranslatorId());
                PSSysTranslatorService pSSysTranslatorService = (PSSysTranslatorService)ServiceGlobal.getService(PSSysTranslatorService.class, (SessionFactory)this.getSessionFactory());
                pSSysTranslatorService.autoGet((IEntity)pSSysTranslator);
                this.outpssystranslator = pSSysTranslator;
            }
            return this.outpssystranslator;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDESARS> getPSDESARSes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDESARSes();
        }
        if (this.getPSSysServiceAPIId() == null) {
            return null;
        }
        PSDESARSService pSDESARSService = (PSDESARSService)ServiceGlobal.getService(PSDESARSService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDESARSesLock;
        synchronized (n) {
            if (this.psdesarses == null) {
                this.psdesarses = pSDESARSService.selectByPSSysServiceAPI(this);
            }
            return this.psdesarses;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEServiceAPI> getPSDEServiceAPIs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEServiceAPIs();
        }
        if (this.getPSSysServiceAPIId() == null) {
            return null;
        }
        PSDEServiceAPIService pSDEServiceAPIService = (PSDEServiceAPIService)ServiceGlobal.getService(PSDEServiceAPIService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEServiceAPIsLock;
        synchronized (n) {
            if (this.psdeserviceapis == null) {
                this.psdeserviceapis = pSDEServiceAPIService.selectByPSSysServiceAPI(this);
            }
            return this.psdeserviceapis;
        }
    }

    private PSSysServiceAPIBase getProxyEntity() {
        return this.proxyPSSysServiceAPIBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysServiceAPIBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysServiceAPIBase) {
            this.proxyPSSysServiceAPIBase = (PSSysServiceAPIBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysServiceAPIService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_APILEVEL, 0);
        fieldIndexMap.put(FIELD_APIMODE, 1);
        fieldIndexMap.put(FIELD_APITAG, 2);
        fieldIndexMap.put(FIELD_APITAG2, 3);
        fieldIndexMap.put(FIELD_APITYPE, 4);
        fieldIndexMap.put(FIELD_AUTHCHECKTOKENURI, 5);
        fieldIndexMap.put(FIELD_AUTHCLIENTID, 6);
        fieldIndexMap.put(FIELD_AUTHCLIENTSECRET, 7);
        fieldIndexMap.put(FIELD_AUTHMODE, 8);
        fieldIndexMap.put(FIELD_AUTHPARAM, 9);
        fieldIndexMap.put(FIELD_AUTHPARAM2, 10);
        fieldIndexMap.put(FIELD_AUTHPARAM3, 11);
        fieldIndexMap.put(FIELD_AUTHPARAM4, 12);
        fieldIndexMap.put(FIELD_BASECLSPARAMS, 13);
        fieldIndexMap.put(FIELD_CFGPSMODELSTORAGEID, 14);
        fieldIndexMap.put(FIELD_CFGTAG, 15);
        fieldIndexMap.put(FIELD_CODENAME, 16);
        fieldIndexMap.put(FIELD_CODENAMEMODE, 17);
        fieldIndexMap.put(FIELD_CREATEDATE, 18);
        fieldIndexMap.put(FIELD_CREATEMAN, 19);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 20);
        fieldIndexMap.put(FIELD_CUSTOMMODE, 21);
        fieldIndexMap.put(FIELD_DEFAULTPORT, 22);
        fieldIndexMap.put(FIELD_DEFAULTPSDEOPPRIVID, 23);
        fieldIndexMap.put(FIELD_DEFAULTPSDEOPPRIVNAME, 24);
        fieldIndexMap.put(FIELD_DEFCREATEREQMETHOD, 25);
        fieldIndexMap.put(FIELD_DEFDEACTIONREQMETHOD, 26);
        fieldIndexMap.put(FIELD_DEFDEDATASETREQMETHOD, 27);
        fieldIndexMap.put(FIELD_DEFDELETEREQMETHOD, 28);
        fieldIndexMap.put(FIELD_DEFGETDRAFTREQMETHOD, 29);
        fieldIndexMap.put(FIELD_DEFGETREQMETHOD, 30);
        fieldIndexMap.put(FIELD_DEFNEEDRESOURCEKEY, 31);
        fieldIndexMap.put(FIELD_DEFSELECTREQMETHOD, 32);
        fieldIndexMap.put(FIELD_DEFUPDATEREQMETHOD, 33);
        fieldIndexMap.put(FIELD_DEPSSYSSFPLUGINID, 34);
        fieldIndexMap.put(FIELD_DEPSSYSSFPLUGINNAME, 35);
        fieldIndexMap.put(FIELD_ENABLEAPIMODELEX, 36);
        fieldIndexMap.put(FIELD_ENABLEGATEWAY, 37);
        fieldIndexMap.put(FIELD_IGNOREAUTHPATTERNS, 38);
        fieldIndexMap.put(FIELD_LOCKFLAG, 39);
        fieldIndexMap.put(FIELD_MEMO, 40);
        fieldIndexMap.put(FIELD_NAMINGSERVICE, 41);
        fieldIndexMap.put(FIELD_ORDERVALUE, 42);
        fieldIndexMap.put(FIELD_OUTPSSYSTRANSLATORID, 43);
        fieldIndexMap.put(FIELD_OUTPSSYSTRANSLATORNAME, 44);
        fieldIndexMap.put(FIELD_PREDEFINEDTYPE, 45);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSAPIID, 46);
        fieldIndexMap.put(FIELD_PSMODULEID, 47);
        fieldIndexMap.put(FIELD_PSMODULENAME, 48);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 49);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 50);
        fieldIndexMap.put(FIELD_PSSYSREQITEMID, 51);
        fieldIndexMap.put(FIELD_PSSYSREQITEMNAME, 52);
        fieldIndexMap.put(FIELD_PSSYSRESOURCEID, 53);
        fieldIndexMap.put(FIELD_PSSYSRESOURCENAME, 54);
        fieldIndexMap.put(FIELD_PSSYSSAHANDLERID, 55);
        fieldIndexMap.put(FIELD_PSSYSSAHANDLERNAME, 56);
        fieldIndexMap.put(FIELD_PSSYSSERVICEAPIID, 57);
        fieldIndexMap.put(FIELD_PSSYSSERVICEAPINAME, 58);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 59);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 60);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 61);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 62);
        fieldIndexMap.put(FIELD_RESETDEFACTIONCODENAME, 63);
        fieldIndexMap.put(FIELD_SERVICECODENAME, 64);
        fieldIndexMap.put(FIELD_SERVICEDTOFLAG, 65);
        fieldIndexMap.put(FIELD_SERVICEPARAM, 66);
        fieldIndexMap.put(FIELD_SERVICEPARAM2, 67);
        fieldIndexMap.put(FIELD_SERVICEPARAM3, 68);
        fieldIndexMap.put(FIELD_SERVICEPARAM4, 69);
        fieldIndexMap.put(FIELD_SERVICEPARAMS, 70);
        fieldIndexMap.put(FIELD_SERVICETYPE, 71);
        fieldIndexMap.put(FIELD_UNIQUETAG, 72);
        fieldIndexMap.put(FIELD_UPDATEDATE, 73);
        fieldIndexMap.put(FIELD_UPDATEMAN, 74);
        fieldIndexMap.put(FIELD_USERCAT, 75);
        fieldIndexMap.put(FIELD_USERTAG, 76);
        fieldIndexMap.put(FIELD_USERTAG2, 77);
        fieldIndexMap.put(FIELD_USERTAG3, 78);
        fieldIndexMap.put(FIELD_USERTAG4, 79);
        fieldIndexMap.put(FIELD_VALIDFLAG, 80);
        fieldIndexMap.put(FIELD_VER, 81);
    }
}

