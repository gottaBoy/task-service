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
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIScheme;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAISchemeService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADE;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADERS;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADetail;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSAHandler;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADERSService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADEService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADetailService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSAHandlerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysServiceAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSubSysServiceAPIBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSubSysServiceAPIBase.class);
    public static final String FIELD_ADDDEMODE = "ADDDEMODE";
    public static final String FIELD_ADDDEPARAMS = "ADDDEPARAMS";
    public static final String FIELD_ADDDEPREFIX = "ADDDEPREFIX";
    public static final String FIELD_APISOURCE = "APISOURCE";
    public static final String FIELD_APITAG = "APITAG";
    public static final String FIELD_APITAG2 = "APITAG2";
    public static final String FIELD_APITYPE = "APITYPE";
    public static final String FIELD_AUTHACCESSTOKENURI = "AUTHACCESSTOKENURI";
    public static final String FIELD_AUTHCLIENTID = "AUTHCLIENTID";
    public static final String FIELD_AUTHCLIENTSECRET = "AUTHCLIENTSECRET";
    public static final String FIELD_AUTHCODE = "AUTHCODE";
    public static final String FIELD_AUTHMODE = "AUTHMODE";
    public static final String FIELD_AUTHPARAM = "AUTHPARAM";
    public static final String FIELD_AUTHPARAM2 = "AUTHPARAM2";
    public static final String FIELD_AUTHPARAM3 = "AUTHPARAM3";
    public static final String FIELD_AUTHPARAM4 = "AUTHPARAM4";
    public static final String FIELD_AUTHTIMEOUT = "AUTHTIMEOUT";
    public static final String FIELD_BASECLSPARAMS = "BASECLSPARAMS";
    public static final String FIELD_CFGPSMODELSTORAGEID = "CFGPSMODELSTORAGEID";
    public static final String FIELD_CFGTAG = "CFGTAG";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CODENAMEMODE = "CODENAMEMODE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_CUSTOMMODE = "CUSTOMMODE";
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
    public static final String FIELD_FROMDEMODELFLAG = "FROMDEMODELFLAG";
    public static final String FIELD_HEADERPARAMS = "HEADERPARAMS";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_METHODCODE = "METHODCODE";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PREDEFINEDTYPE = "PREDEFINEDTYPE";
    public static final String FIELD_PSDEVSLNSYSAPIID = "PSDEVSLNSYSAPIID";
    public static final String FIELD_PSDEVSLNSYSAPINAME = "PSDEVSLNSYSAPINAME";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSUBSYSSERVICEAPIID = "PSSUBSYSSERVICEAPIID";
    public static final String FIELD_PSSUBSYSSERVICEAPINAME = "PSSUBSYSSERVICEAPINAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSEAISCHEMEID = "PSSYSEAISCHEMEID";
    public static final String FIELD_PSSYSEAISCHEMENAME = "PSSYSEAISCHEMENAME";
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
    public static final String FIELD_SCRIPTENGINE = "SCRIPTENGINE";
    public static final String FIELD_SERVICECODENAME = "SERVICECODENAME";
    public static final String FIELD_SERVICEDTOFLAG = "SERVICEDTOFLAG";
    public static final String FIELD_SERVICEPARAM = "SERVICEPARAM";
    public static final String FIELD_SERVICEPARAM2 = "SERVICEPARAM2";
    public static final String FIELD_SERVICEPARAM3 = "SERVICEPARAM3";
    public static final String FIELD_SERVICEPARAM4 = "SERVICEPARAM4";
    public static final String FIELD_SERVICEPARAMS = "SERVICEPARAMS";
    public static final String FIELD_SERVICEPATH = "SERVICEPATH";
    public static final String FIELD_SERVICETYPE = "SERVICETYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_VER = "VER";
    private static final int INDEX_ADDDEMODE = 0;
    private static final int INDEX_ADDDEPARAMS = 1;
    private static final int INDEX_ADDDEPREFIX = 2;
    private static final int INDEX_APISOURCE = 3;
    private static final int INDEX_APITAG = 4;
    private static final int INDEX_APITAG2 = 5;
    private static final int INDEX_APITYPE = 6;
    private static final int INDEX_AUTHACCESSTOKENURI = 7;
    private static final int INDEX_AUTHCLIENTID = 8;
    private static final int INDEX_AUTHCLIENTSECRET = 9;
    private static final int INDEX_AUTHCODE = 10;
    private static final int INDEX_AUTHMODE = 11;
    private static final int INDEX_AUTHPARAM = 12;
    private static final int INDEX_AUTHPARAM2 = 13;
    private static final int INDEX_AUTHPARAM3 = 14;
    private static final int INDEX_AUTHPARAM4 = 15;
    private static final int INDEX_AUTHTIMEOUT = 16;
    private static final int INDEX_BASECLSPARAMS = 17;
    private static final int INDEX_CFGPSMODELSTORAGEID = 18;
    private static final int INDEX_CFGTAG = 19;
    private static final int INDEX_CODENAME = 20;
    private static final int INDEX_CODENAMEMODE = 21;
    private static final int INDEX_CREATEDATE = 22;
    private static final int INDEX_CREATEMAN = 23;
    private static final int INDEX_CUSTOMCODE = 24;
    private static final int INDEX_CUSTOMMODE = 25;
    private static final int INDEX_DEFCREATEREQMETHOD = 26;
    private static final int INDEX_DEFDEACTIONREQMETHOD = 27;
    private static final int INDEX_DEFDEDATASETREQMETHOD = 28;
    private static final int INDEX_DEFDELETEREQMETHOD = 29;
    private static final int INDEX_DEFGETDRAFTREQMETHOD = 30;
    private static final int INDEX_DEFGETREQMETHOD = 31;
    private static final int INDEX_DEFNEEDRESOURCEKEY = 32;
    private static final int INDEX_DEFSELECTREQMETHOD = 33;
    private static final int INDEX_DEFUPDATEREQMETHOD = 34;
    private static final int INDEX_DEPSSYSSFPLUGINID = 35;
    private static final int INDEX_DEPSSYSSFPLUGINNAME = 36;
    private static final int INDEX_ENABLEAPIMODELEX = 37;
    private static final int INDEX_FROMDEMODELFLAG = 38;
    private static final int INDEX_HEADERPARAMS = 39;
    private static final int INDEX_LOCKFLAG = 40;
    private static final int INDEX_MEMO = 41;
    private static final int INDEX_METHODCODE = 42;
    private static final int INDEX_ORDERVALUE = 43;
    private static final int INDEX_PREDEFINEDTYPE = 44;
    private static final int INDEX_PSDEVSLNSYSAPIID = 45;
    private static final int INDEX_PSDEVSLNSYSAPINAME = 46;
    private static final int INDEX_PSMODULEID = 47;
    private static final int INDEX_PSMODULENAME = 48;
    private static final int INDEX_PSSUBSYSSERVICEAPIID = 49;
    private static final int INDEX_PSSUBSYSSERVICEAPINAME = 50;
    private static final int INDEX_PSSYSDYNAMODELID = 51;
    private static final int INDEX_PSSYSDYNAMODELNAME = 52;
    private static final int INDEX_PSSYSEAISCHEMEID = 53;
    private static final int INDEX_PSSYSEAISCHEMENAME = 54;
    private static final int INDEX_PSSYSREQITEMID = 55;
    private static final int INDEX_PSSYSREQITEMNAME = 56;
    private static final int INDEX_PSSYSRESOURCEID = 57;
    private static final int INDEX_PSSYSRESOURCENAME = 58;
    private static final int INDEX_PSSYSSAHANDLERID = 59;
    private static final int INDEX_PSSYSSAHANDLERNAME = 60;
    private static final int INDEX_PSSYSSERVICEAPIID = 61;
    private static final int INDEX_PSSYSSERVICEAPINAME = 62;
    private static final int INDEX_PSSYSSFPLUGINID = 63;
    private static final int INDEX_PSSYSSFPLUGINNAME = 64;
    private static final int INDEX_PSSYSTEMID = 65;
    private static final int INDEX_PSSYSTEMNAME = 66;
    private static final int INDEX_RESETDEFACTIONCODENAME = 67;
    private static final int INDEX_SCRIPTENGINE = 68;
    private static final int INDEX_SERVICECODENAME = 69;
    private static final int INDEX_SERVICEDTOFLAG = 70;
    private static final int INDEX_SERVICEPARAM = 71;
    private static final int INDEX_SERVICEPARAM2 = 72;
    private static final int INDEX_SERVICEPARAM3 = 73;
    private static final int INDEX_SERVICEPARAM4 = 74;
    private static final int INDEX_SERVICEPARAMS = 75;
    private static final int INDEX_SERVICEPATH = 76;
    private static final int INDEX_SERVICETYPE = 77;
    private static final int INDEX_UPDATEDATE = 78;
    private static final int INDEX_UPDATEMAN = 79;
    private static final int INDEX_USERCAT = 80;
    private static final int INDEX_USERTAG = 81;
    private static final int INDEX_USERTAG2 = 82;
    private static final int INDEX_USERTAG3 = 83;
    private static final int INDEX_USERTAG4 = 84;
    private static final int INDEX_VALIDFLAG = 85;
    private static final int INDEX_VER = 86;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSubSysServiceAPIBase proxyPSSubSysServiceAPIBase = null;
    private boolean adddemodeDirtyFlag = false;
    private boolean adddeparamsDirtyFlag = false;
    private boolean adddeprefixDirtyFlag = false;
    private boolean apisourceDirtyFlag = false;
    private boolean apitagDirtyFlag = false;
    private boolean apitag2DirtyFlag = false;
    private boolean apitypeDirtyFlag = false;
    private boolean authaccesstokenuriDirtyFlag = false;
    private boolean authclientidDirtyFlag = false;
    private boolean authclientsecretDirtyFlag = false;
    private boolean authcodeDirtyFlag = false;
    private boolean authmodeDirtyFlag = false;
    private boolean authparamDirtyFlag = false;
    private boolean authparam2DirtyFlag = false;
    private boolean authparam3DirtyFlag = false;
    private boolean authparam4DirtyFlag = false;
    private boolean authtimeoutDirtyFlag = false;
    private boolean baseclsparamsDirtyFlag = false;
    private boolean cfgpsmodelstorageidDirtyFlag = false;
    private boolean cfgtagDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean codenamemodeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean custommodeDirtyFlag = false;
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
    private boolean fromdemodelflagDirtyFlag = false;
    private boolean headerparamsDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean methodcodeDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean predefinedtypeDirtyFlag = false;
    private boolean psdevslnsysapiidDirtyFlag = false;
    private boolean psdevslnsysapinameDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssubsysserviceapiidDirtyFlag = false;
    private boolean pssubsysserviceapinameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssyseaischemeidDirtyFlag = false;
    private boolean pssyseaischemenameDirtyFlag = false;
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
    private boolean scriptengineDirtyFlag = false;
    private boolean servicecodenameDirtyFlag = false;
    private boolean servicedtoflagDirtyFlag = false;
    private boolean serviceparamDirtyFlag = false;
    private boolean serviceparam2DirtyFlag = false;
    private boolean serviceparam3DirtyFlag = false;
    private boolean serviceparam4DirtyFlag = false;
    private boolean serviceparamsDirtyFlag = false;
    private boolean servicepathDirtyFlag = false;
    private boolean servicetypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean verDirtyFlag = false;
    @Column(name="adddemode")
    private Integer adddemode;
    @Column(name="adddeparams")
    private String adddeparams;
    @Column(name="adddeprefix")
    private String adddeprefix;
    @Column(name="apisource")
    private String apisource;
    @Column(name="apitag")
    private String apitag;
    @Column(name="apitag2")
    private String apitag2;
    @Column(name="apitype")
    private String apitype;
    @Column(name="authaccesstokenuri")
    private String authaccesstokenuri;
    @Column(name="authclientid")
    private String authclientid;
    @Column(name="authclientsecret")
    private String authclientsecret;
    @Column(name="authcode")
    private String authcode;
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
    @Column(name="authtimeout")
    private Integer authtimeout;
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
    @Column(name="fromdemodelflag")
    private Integer fromdemodelflag;
    @Column(name="headerparams")
    private String headerparams;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
    @Column(name="methodcode")
    private String methodcode;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="predefinedtype")
    private String predefinedtype;
    @Column(name="psdevslnsysapiid")
    private String psdevslnsysapiid;
    @Column(name="psdevslnsysapiname")
    private String psdevslnsysapiname;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssubsysserviceapiid")
    private String pssubsysserviceapiid;
    @Column(name="pssubsysserviceapiname")
    private String pssubsysserviceapiname;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssyseaischemeid")
    private String pssyseaischemeid;
    @Column(name="pssyseaischemename")
    private String pssyseaischemename;
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
    @Column(name="scriptengine")
    private String scriptengine;
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
    @Column(name="servicepath")
    private String servicepath;
    @Column(name="servicetype")
    private String servicetype;
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
    private Integer objPSDevSlnSysAPILock = new Integer(1);
    private PSDevSlnSysAPI psdevslnsysapi = null;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSysEAISchemeLock = new Integer(1);
    private PSSysEAIScheme pssyseaischeme = null;
    private Integer objPSSysReqItemLock = new Integer(1);
    private PSSysReqItem pssysreqitem = null;
    private Integer objPSSysResourceLock = new Integer(1);
    private PSSysResource pssysresource = null;
    private Integer objPSSysSAHandlerLock = new Integer(1);
    private PSSysSAHandler pssyssahandler = null;
    private Integer objPSSysServiceAPILock = new Integer(1);
    private PSSysServiceAPI pssysserviceapi = null;
    private Integer objDEPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin depssyssfplugin = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSDataEntitiesLock = new Integer(1);
    private ArrayList<PSDataEntity> psdataentities = null;
    private Integer objPSSubSysSADERSsLock = new Integer(1);
    private ArrayList<PSSubSysSADERS> pssubsyssaderss = null;
    private Integer objPSSubSysSADetailsLock = new Integer(1);
    private ArrayList<PSSubSysSADetail> pssubsyssadetails = null;
    private Integer objPSSubSysSADEsLock = new Integer(1);
    private ArrayList<PSSubSysSADE> pssubsyssades = null;

    public void setAddDEMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAddDEMode(n);
            return;
        }
        this.adddemode = n;
        this.adddemodeDirtyFlag = true;
    }

    public Integer getAddDEMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAddDEMode();
        }
        return this.adddemode;
    }

    public boolean isAddDEModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAddDEModeDirty();
        }
        return this.adddemodeDirtyFlag;
    }

    public void resetAddDEMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAddDEMode();
            return;
        }
        this.adddemodeDirtyFlag = false;
        this.adddemode = null;
    }

    public void setAddDEParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAddDEParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.adddeparams = string;
        this.adddeparamsDirtyFlag = true;
    }

    public String getAddDEParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAddDEParams();
        }
        return this.adddeparams;
    }

    public boolean isAddDEParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAddDEParamsDirty();
        }
        return this.adddeparamsDirtyFlag;
    }

    public void resetAddDEParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAddDEParams();
            return;
        }
        this.adddeparamsDirtyFlag = false;
        this.adddeparams = null;
    }

    public void setAddDEPrefix(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAddDEPrefix(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.adddeprefix = string;
        this.adddeprefixDirtyFlag = true;
    }

    public String getAddDEPrefix() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAddDEPrefix();
        }
        return this.adddeprefix;
    }

    public boolean isAddDEPrefixDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAddDEPrefixDirty();
        }
        return this.adddeprefixDirtyFlag;
    }

    public void resetAddDEPrefix() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAddDEPrefix();
            return;
        }
        this.adddeprefixDirtyFlag = false;
        this.adddeprefix = null;
    }

    public void setAPISource(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAPISource(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.apisource = string;
        this.apisourceDirtyFlag = true;
    }

    public String getAPISource() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAPISource();
        }
        return this.apisource;
    }

    public boolean isAPISourceDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAPISourceDirty();
        }
        return this.apisourceDirtyFlag;
    }

    public void resetAPISource() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAPISource();
            return;
        }
        this.apisourceDirtyFlag = false;
        this.apisource = null;
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

    public void setAuthAccessTokenUri(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAuthAccessTokenUri(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.authaccesstokenuri = string;
        this.authaccesstokenuriDirtyFlag = true;
    }

    public String getAuthAccessTokenUri() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAuthAccessTokenUri();
        }
        return this.authaccesstokenuri;
    }

    public boolean isAuthAccessTokenUriDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAuthAccessTokenUriDirty();
        }
        return this.authaccesstokenuriDirtyFlag;
    }

    public void resetAuthAccessTokenUri() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAuthAccessTokenUri();
            return;
        }
        this.authaccesstokenuriDirtyFlag = false;
        this.authaccesstokenuri = null;
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

    public void setAuthCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAuthCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.authcode = string;
        this.authcodeDirtyFlag = true;
    }

    public String getAuthCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAuthCode();
        }
        return this.authcode;
    }

    public boolean isAuthCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAuthCodeDirty();
        }
        return this.authcodeDirtyFlag;
    }

    public void resetAuthCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAuthCode();
            return;
        }
        this.authcodeDirtyFlag = false;
        this.authcode = null;
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

    public void setAuthTimeout(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAuthTimeout(n);
            return;
        }
        this.authtimeout = n;
        this.authtimeoutDirtyFlag = true;
    }

    public Integer getAuthTimeout() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAuthTimeout();
        }
        return this.authtimeout;
    }

    public boolean isAuthTimeoutDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAuthTimeoutDirty();
        }
        return this.authtimeoutDirtyFlag;
    }

    public void resetAuthTimeout() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAuthTimeout();
            return;
        }
        this.authtimeoutDirtyFlag = false;
        this.authtimeout = null;
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

    public void setFromDEModelFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFromDEModelFlag(n);
            return;
        }
        this.fromdemodelflag = n;
        this.fromdemodelflagDirtyFlag = true;
    }

    public Integer getFromDEModelFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFromDEModelFlag();
        }
        return this.fromdemodelflag;
    }

    public boolean isFromDEModelFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFromDEModelFlagDirty();
        }
        return this.fromdemodelflagDirtyFlag;
    }

    public void resetFromDEModelFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFromDEModelFlag();
            return;
        }
        this.fromdemodelflagDirtyFlag = false;
        this.fromdemodelflag = null;
    }

    public void setHeaderParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHeaderParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.headerparams = string;
        this.headerparamsDirtyFlag = true;
    }

    public String getHeaderParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHeaderParams();
        }
        return this.headerparams;
    }

    public boolean isHeaderParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHeaderParamsDirty();
        }
        return this.headerparamsDirtyFlag;
    }

    public void resetHeaderParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHeaderParams();
            return;
        }
        this.headerparamsDirtyFlag = false;
        this.headerparams = null;
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

    public void setMethodCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMethodCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.methodcode = string;
        this.methodcodeDirtyFlag = true;
    }

    public String getMethodCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMethodCode();
        }
        return this.methodcode;
    }

    public boolean isMethodCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMethodCodeDirty();
        }
        return this.methodcodeDirtyFlag;
    }

    public void resetMethodCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMethodCode();
            return;
        }
        this.methodcodeDirtyFlag = false;
        this.methodcode = null;
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

    public void setPSDevSlnSysAPIName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysAPIName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysapiname = string;
        this.psdevslnsysapinameDirtyFlag = true;
    }

    public String getPSDevSlnSysAPIName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysAPIName();
        }
        return this.psdevslnsysapiname;
    }

    public boolean isPSDevSlnSysAPINameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysAPINameDirty();
        }
        return this.psdevslnsysapinameDirtyFlag;
    }

    public void resetPSDevSlnSysAPIName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysAPIName();
            return;
        }
        this.psdevslnsysapinameDirtyFlag = false;
        this.psdevslnsysapiname = null;
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

    public void setPSSubSysServiceAPIId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysServiceAPIId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsysserviceapiid = string;
        this.pssubsysserviceapiidDirtyFlag = true;
    }

    public String getPSSubSysServiceAPIId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysServiceAPIId();
        }
        return this.pssubsysserviceapiid;
    }

    public boolean isPSSubSysServiceAPIIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysServiceAPIIdDirty();
        }
        return this.pssubsysserviceapiidDirtyFlag;
    }

    public void resetPSSubSysServiceAPIId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysServiceAPIId();
            return;
        }
        this.pssubsysserviceapiidDirtyFlag = false;
        this.pssubsysserviceapiid = null;
    }

    public void setPSSubSysServiceAPIName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysServiceAPIName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsysserviceapiname = string;
        this.pssubsysserviceapinameDirtyFlag = true;
    }

    public String getPSSubSysServiceAPIName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysServiceAPIName();
        }
        return this.pssubsysserviceapiname;
    }

    public boolean isPSSubSysServiceAPINameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysServiceAPINameDirty();
        }
        return this.pssubsysserviceapinameDirtyFlag;
    }

    public void resetPSSubSysServiceAPIName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysServiceAPIName();
            return;
        }
        this.pssubsysserviceapinameDirtyFlag = false;
        this.pssubsysserviceapiname = null;
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

    public void setPSSysEAISchemeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysEAISchemeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyseaischemeid = string;
        this.pssyseaischemeidDirtyFlag = true;
    }

    public String getPSSysEAISchemeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAISchemeId();
        }
        return this.pssyseaischemeid;
    }

    public boolean isPSSysEAISchemeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysEAISchemeIdDirty();
        }
        return this.pssyseaischemeidDirtyFlag;
    }

    public void resetPSSysEAISchemeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysEAISchemeId();
            return;
        }
        this.pssyseaischemeidDirtyFlag = false;
        this.pssyseaischemeid = null;
    }

    public void setPSSysEAISchemeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysEAISchemeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyseaischemename = string;
        this.pssyseaischemenameDirtyFlag = true;
    }

    public String getPSSysEAISchemeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAISchemeName();
        }
        return this.pssyseaischemename;
    }

    public boolean isPSSysEAISchemeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysEAISchemeNameDirty();
        }
        return this.pssyseaischemenameDirtyFlag;
    }

    public void resetPSSysEAISchemeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysEAISchemeName();
            return;
        }
        this.pssyseaischemenameDirtyFlag = false;
        this.pssyseaischemename = null;
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

    public void setScriptEngine(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setScriptEngine(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.scriptengine = string;
        this.scriptengineDirtyFlag = true;
    }

    public String getScriptEngine() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getScriptEngine();
        }
        return this.scriptengine;
    }

    public boolean isScriptEngineDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isScriptEngineDirty();
        }
        return this.scriptengineDirtyFlag;
    }

    public void resetScriptEngine() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetScriptEngine();
            return;
        }
        this.scriptengineDirtyFlag = false;
        this.scriptengine = null;
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

    public void setServicePath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServicePath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.servicepath = string;
        this.servicepathDirtyFlag = true;
    }

    public String getServicePath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServicePath();
        }
        return this.servicepath;
    }

    public boolean isServicePathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServicePathDirty();
        }
        return this.servicepathDirtyFlag;
    }

    public void resetServicePath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServicePath();
            return;
        }
        this.servicepathDirtyFlag = false;
        this.servicepath = null;
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
        PSSubSysServiceAPIBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSubSysServiceAPIBase pSSubSysServiceAPIBase) {
        pSSubSysServiceAPIBase.resetAddDEMode();
        pSSubSysServiceAPIBase.resetAddDEParams();
        pSSubSysServiceAPIBase.resetAddDEPrefix();
        pSSubSysServiceAPIBase.resetAPISource();
        pSSubSysServiceAPIBase.resetAPITag();
        pSSubSysServiceAPIBase.resetAPITag2();
        pSSubSysServiceAPIBase.resetAPIType();
        pSSubSysServiceAPIBase.resetAuthAccessTokenUri();
        pSSubSysServiceAPIBase.resetAuthClientId();
        pSSubSysServiceAPIBase.resetAuthClientSecret();
        pSSubSysServiceAPIBase.resetAuthCode();
        pSSubSysServiceAPIBase.resetAuthMode();
        pSSubSysServiceAPIBase.resetAuthParam();
        pSSubSysServiceAPIBase.resetAuthParam2();
        pSSubSysServiceAPIBase.resetAuthParam3();
        pSSubSysServiceAPIBase.resetAuthParam4();
        pSSubSysServiceAPIBase.resetAuthTimeout();
        pSSubSysServiceAPIBase.resetBaseClsParams();
        pSSubSysServiceAPIBase.resetCfgPSModelStorageId();
        pSSubSysServiceAPIBase.resetCfgTag();
        pSSubSysServiceAPIBase.resetCodeName();
        pSSubSysServiceAPIBase.resetCodeNameMode();
        pSSubSysServiceAPIBase.resetCreateDate();
        pSSubSysServiceAPIBase.resetCreateMan();
        pSSubSysServiceAPIBase.resetCustomCode();
        pSSubSysServiceAPIBase.resetCustomMode();
        pSSubSysServiceAPIBase.resetDefCreateReqMethod();
        pSSubSysServiceAPIBase.resetDefDEActionReqMethod();
        pSSubSysServiceAPIBase.resetDefDEDataSetReqMethod();
        pSSubSysServiceAPIBase.resetDefDeleteReqMethod();
        pSSubSysServiceAPIBase.resetDefGetDraftReqMethod();
        pSSubSysServiceAPIBase.resetDefGetReqMethod();
        pSSubSysServiceAPIBase.resetDefNeedResourceKey();
        pSSubSysServiceAPIBase.resetDefSelectReqMethod();
        pSSubSysServiceAPIBase.resetDefUpdateReqMethod();
        pSSubSysServiceAPIBase.resetDEPSSysSFPluginId();
        pSSubSysServiceAPIBase.resetDEPSSysSFPluginName();
        pSSubSysServiceAPIBase.resetEnableAPIModelEx();
        pSSubSysServiceAPIBase.resetFromDEModelFlag();
        pSSubSysServiceAPIBase.resetHeaderParams();
        pSSubSysServiceAPIBase.resetLockFlag();
        pSSubSysServiceAPIBase.resetMemo();
        pSSubSysServiceAPIBase.resetMethodCode();
        pSSubSysServiceAPIBase.resetOrderValue();
        pSSubSysServiceAPIBase.resetPredefinedType();
        pSSubSysServiceAPIBase.resetPSDevSlnSysAPIId();
        pSSubSysServiceAPIBase.resetPSDevSlnSysAPIName();
        pSSubSysServiceAPIBase.resetPSModuleId();
        pSSubSysServiceAPIBase.resetPSModuleName();
        pSSubSysServiceAPIBase.resetPSSubSysServiceAPIId();
        pSSubSysServiceAPIBase.resetPSSubSysServiceAPIName();
        pSSubSysServiceAPIBase.resetPSSysDynaModelId();
        pSSubSysServiceAPIBase.resetPSSysDynaModelName();
        pSSubSysServiceAPIBase.resetPSSysEAISchemeId();
        pSSubSysServiceAPIBase.resetPSSysEAISchemeName();
        pSSubSysServiceAPIBase.resetPSSysReqItemId();
        pSSubSysServiceAPIBase.resetPSSysReqItemName();
        pSSubSysServiceAPIBase.resetPSSysResourceId();
        pSSubSysServiceAPIBase.resetPSSysResourceName();
        pSSubSysServiceAPIBase.resetPSSysSAHandlerId();
        pSSubSysServiceAPIBase.resetPSSysSAHandlerName();
        pSSubSysServiceAPIBase.resetPSSysServiceAPIId();
        pSSubSysServiceAPIBase.resetPSSysServiceAPIName();
        pSSubSysServiceAPIBase.resetPSSysSFPluginId();
        pSSubSysServiceAPIBase.resetPSSysSFPluginName();
        pSSubSysServiceAPIBase.resetPSSystemId();
        pSSubSysServiceAPIBase.resetPSSystemName();
        pSSubSysServiceAPIBase.resetResetDefActionCodeName();
        pSSubSysServiceAPIBase.resetScriptEngine();
        pSSubSysServiceAPIBase.resetServiceCodeName();
        pSSubSysServiceAPIBase.resetServiceDTOFlag();
        pSSubSysServiceAPIBase.resetServiceParam();
        pSSubSysServiceAPIBase.resetServiceParam2();
        pSSubSysServiceAPIBase.resetServiceParam3();
        pSSubSysServiceAPIBase.resetServiceParam4();
        pSSubSysServiceAPIBase.resetServiceParams();
        pSSubSysServiceAPIBase.resetServicePath();
        pSSubSysServiceAPIBase.resetServiceType();
        pSSubSysServiceAPIBase.resetUpdateDate();
        pSSubSysServiceAPIBase.resetUpdateMan();
        pSSubSysServiceAPIBase.resetUserCat();
        pSSubSysServiceAPIBase.resetUserTag();
        pSSubSysServiceAPIBase.resetUserTag2();
        pSSubSysServiceAPIBase.resetUserTag3();
        pSSubSysServiceAPIBase.resetUserTag4();
        pSSubSysServiceAPIBase.resetValidFlag();
        pSSubSysServiceAPIBase.resetVer();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAddDEModeDirty()) {
            hashMap.put(FIELD_ADDDEMODE, this.getAddDEMode());
        }
        if (!bl || this.isAddDEParamsDirty()) {
            hashMap.put(FIELD_ADDDEPARAMS, this.getAddDEParams());
        }
        if (!bl || this.isAddDEPrefixDirty()) {
            hashMap.put(FIELD_ADDDEPREFIX, this.getAddDEPrefix());
        }
        if (!bl || this.isAPISourceDirty()) {
            hashMap.put(FIELD_APISOURCE, this.getAPISource());
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
        if (!bl || this.isAuthAccessTokenUriDirty()) {
            hashMap.put(FIELD_AUTHACCESSTOKENURI, this.getAuthAccessTokenUri());
        }
        if (!bl || this.isAuthClientIdDirty()) {
            hashMap.put(FIELD_AUTHCLIENTID, this.getAuthClientId());
        }
        if (!bl || this.isAuthClientSecretDirty()) {
            hashMap.put(FIELD_AUTHCLIENTSECRET, this.getAuthClientSecret());
        }
        if (!bl || this.isAuthCodeDirty()) {
            hashMap.put(FIELD_AUTHCODE, this.getAuthCode());
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
        if (!bl || this.isAuthTimeoutDirty()) {
            hashMap.put(FIELD_AUTHTIMEOUT, this.getAuthTimeout());
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
        if (!bl || this.isFromDEModelFlagDirty()) {
            hashMap.put(FIELD_FROMDEMODELFLAG, this.getFromDEModelFlag());
        }
        if (!bl || this.isHeaderParamsDirty()) {
            hashMap.put(FIELD_HEADERPARAMS, this.getHeaderParams());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMethodCodeDirty()) {
            hashMap.put(FIELD_METHODCODE, this.getMethodCode());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPredefinedTypeDirty()) {
            hashMap.put(FIELD_PREDEFINEDTYPE, this.getPredefinedType());
        }
        if (!bl || this.isPSDevSlnSysAPIIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSAPIID, this.getPSDevSlnSysAPIId());
        }
        if (!bl || this.isPSDevSlnSysAPINameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSAPINAME, this.getPSDevSlnSysAPIName());
        }
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
        }
        if (!bl || this.isPSSubSysServiceAPIIdDirty()) {
            hashMap.put(FIELD_PSSUBSYSSERVICEAPIID, this.getPSSubSysServiceAPIId());
        }
        if (!bl || this.isPSSubSysServiceAPINameDirty()) {
            hashMap.put(FIELD_PSSUBSYSSERVICEAPINAME, this.getPSSubSysServiceAPIName());
        }
        if (!bl || this.isPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELID, this.getPSSysDynaModelId());
        }
        if (!bl || this.isPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELNAME, this.getPSSysDynaModelName());
        }
        if (!bl || this.isPSSysEAISchemeIdDirty()) {
            hashMap.put(FIELD_PSSYSEAISCHEMEID, this.getPSSysEAISchemeId());
        }
        if (!bl || this.isPSSysEAISchemeNameDirty()) {
            hashMap.put(FIELD_PSSYSEAISCHEMENAME, this.getPSSysEAISchemeName());
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
        if (!bl || this.isScriptEngineDirty()) {
            hashMap.put(FIELD_SCRIPTENGINE, this.getScriptEngine());
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
        if (!bl || this.isServicePathDirty()) {
            hashMap.put(FIELD_SERVICEPATH, this.getServicePath());
        }
        if (!bl || this.isServiceTypeDirty()) {
            hashMap.put(FIELD_SERVICETYPE, this.getServiceType());
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
        return PSSubSysServiceAPIBase.get(this, n);
    }

    private static Object get(PSSubSysServiceAPIBase pSSubSysServiceAPIBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSubSysServiceAPIBase.getAddDEMode();
            }
            case 1: {
                return pSSubSysServiceAPIBase.getAddDEParams();
            }
            case 2: {
                return pSSubSysServiceAPIBase.getAddDEPrefix();
            }
            case 3: {
                return pSSubSysServiceAPIBase.getAPISource();
            }
            case 4: {
                return pSSubSysServiceAPIBase.getAPITag();
            }
            case 5: {
                return pSSubSysServiceAPIBase.getAPITag2();
            }
            case 6: {
                return pSSubSysServiceAPIBase.getAPIType();
            }
            case 7: {
                return pSSubSysServiceAPIBase.getAuthAccessTokenUri();
            }
            case 8: {
                return pSSubSysServiceAPIBase.getAuthClientId();
            }
            case 9: {
                return pSSubSysServiceAPIBase.getAuthClientSecret();
            }
            case 10: {
                return pSSubSysServiceAPIBase.getAuthCode();
            }
            case 11: {
                return pSSubSysServiceAPIBase.getAuthMode();
            }
            case 12: {
                return pSSubSysServiceAPIBase.getAuthParam();
            }
            case 13: {
                return pSSubSysServiceAPIBase.getAuthParam2();
            }
            case 14: {
                return pSSubSysServiceAPIBase.getAuthParam3();
            }
            case 15: {
                return pSSubSysServiceAPIBase.getAuthParam4();
            }
            case 16: {
                return pSSubSysServiceAPIBase.getAuthTimeout();
            }
            case 17: {
                return pSSubSysServiceAPIBase.getBaseClsParams();
            }
            case 18: {
                return pSSubSysServiceAPIBase.getCfgPSModelStorageId();
            }
            case 19: {
                return pSSubSysServiceAPIBase.getCfgTag();
            }
            case 20: {
                return pSSubSysServiceAPIBase.getCodeName();
            }
            case 21: {
                return pSSubSysServiceAPIBase.getCodeNameMode();
            }
            case 22: {
                return pSSubSysServiceAPIBase.getCreateDate();
            }
            case 23: {
                return pSSubSysServiceAPIBase.getCreateMan();
            }
            case 24: {
                return pSSubSysServiceAPIBase.getCustomCode();
            }
            case 25: {
                return pSSubSysServiceAPIBase.getCustomMode();
            }
            case 26: {
                return pSSubSysServiceAPIBase.getDefCreateReqMethod();
            }
            case 27: {
                return pSSubSysServiceAPIBase.getDefDEActionReqMethod();
            }
            case 28: {
                return pSSubSysServiceAPIBase.getDefDEDataSetReqMethod();
            }
            case 29: {
                return pSSubSysServiceAPIBase.getDefDeleteReqMethod();
            }
            case 30: {
                return pSSubSysServiceAPIBase.getDefGetDraftReqMethod();
            }
            case 31: {
                return pSSubSysServiceAPIBase.getDefGetReqMethod();
            }
            case 32: {
                return pSSubSysServiceAPIBase.getDefNeedResourceKey();
            }
            case 33: {
                return pSSubSysServiceAPIBase.getDefSelectReqMethod();
            }
            case 34: {
                return pSSubSysServiceAPIBase.getDefUpdateReqMethod();
            }
            case 35: {
                return pSSubSysServiceAPIBase.getDEPSSysSFPluginId();
            }
            case 36: {
                return pSSubSysServiceAPIBase.getDEPSSysSFPluginName();
            }
            case 37: {
                return pSSubSysServiceAPIBase.getEnableAPIModelEx();
            }
            case 38: {
                return pSSubSysServiceAPIBase.getFromDEModelFlag();
            }
            case 39: {
                return pSSubSysServiceAPIBase.getHeaderParams();
            }
            case 40: {
                return pSSubSysServiceAPIBase.getLockFlag();
            }
            case 41: {
                return pSSubSysServiceAPIBase.getMemo();
            }
            case 42: {
                return pSSubSysServiceAPIBase.getMethodCode();
            }
            case 43: {
                return pSSubSysServiceAPIBase.getOrderValue();
            }
            case 44: {
                return pSSubSysServiceAPIBase.getPredefinedType();
            }
            case 45: {
                return pSSubSysServiceAPIBase.getPSDevSlnSysAPIId();
            }
            case 46: {
                return pSSubSysServiceAPIBase.getPSDevSlnSysAPIName();
            }
            case 47: {
                return pSSubSysServiceAPIBase.getPSModuleId();
            }
            case 48: {
                return pSSubSysServiceAPIBase.getPSModuleName();
            }
            case 49: {
                return pSSubSysServiceAPIBase.getPSSubSysServiceAPIId();
            }
            case 50: {
                return pSSubSysServiceAPIBase.getPSSubSysServiceAPIName();
            }
            case 51: {
                return pSSubSysServiceAPIBase.getPSSysDynaModelId();
            }
            case 52: {
                return pSSubSysServiceAPIBase.getPSSysDynaModelName();
            }
            case 53: {
                return pSSubSysServiceAPIBase.getPSSysEAISchemeId();
            }
            case 54: {
                return pSSubSysServiceAPIBase.getPSSysEAISchemeName();
            }
            case 55: {
                return pSSubSysServiceAPIBase.getPSSysReqItemId();
            }
            case 56: {
                return pSSubSysServiceAPIBase.getPSSysReqItemName();
            }
            case 57: {
                return pSSubSysServiceAPIBase.getPSSysResourceId();
            }
            case 58: {
                return pSSubSysServiceAPIBase.getPSSysResourceName();
            }
            case 59: {
                return pSSubSysServiceAPIBase.getPSSysSAHandlerId();
            }
            case 60: {
                return pSSubSysServiceAPIBase.getPSSysSAHandlerName();
            }
            case 61: {
                return pSSubSysServiceAPIBase.getPSSysServiceAPIId();
            }
            case 62: {
                return pSSubSysServiceAPIBase.getPSSysServiceAPIName();
            }
            case 63: {
                return pSSubSysServiceAPIBase.getPSSysSFPluginId();
            }
            case 64: {
                return pSSubSysServiceAPIBase.getPSSysSFPluginName();
            }
            case 65: {
                return pSSubSysServiceAPIBase.getPSSystemId();
            }
            case 66: {
                return pSSubSysServiceAPIBase.getPSSystemName();
            }
            case 67: {
                return pSSubSysServiceAPIBase.getResetDefActionCodeName();
            }
            case 68: {
                return pSSubSysServiceAPIBase.getScriptEngine();
            }
            case 69: {
                return pSSubSysServiceAPIBase.getServiceCodeName();
            }
            case 70: {
                return pSSubSysServiceAPIBase.getServiceDTOFlag();
            }
            case 71: {
                return pSSubSysServiceAPIBase.getServiceParam();
            }
            case 72: {
                return pSSubSysServiceAPIBase.getServiceParam2();
            }
            case 73: {
                return pSSubSysServiceAPIBase.getServiceParam3();
            }
            case 74: {
                return pSSubSysServiceAPIBase.getServiceParam4();
            }
            case 75: {
                return pSSubSysServiceAPIBase.getServiceParams();
            }
            case 76: {
                return pSSubSysServiceAPIBase.getServicePath();
            }
            case 77: {
                return pSSubSysServiceAPIBase.getServiceType();
            }
            case 78: {
                return pSSubSysServiceAPIBase.getUpdateDate();
            }
            case 79: {
                return pSSubSysServiceAPIBase.getUpdateMan();
            }
            case 80: {
                return pSSubSysServiceAPIBase.getUserCat();
            }
            case 81: {
                return pSSubSysServiceAPIBase.getUserTag();
            }
            case 82: {
                return pSSubSysServiceAPIBase.getUserTag2();
            }
            case 83: {
                return pSSubSysServiceAPIBase.getUserTag3();
            }
            case 84: {
                return pSSubSysServiceAPIBase.getUserTag4();
            }
            case 85: {
                return pSSubSysServiceAPIBase.getValidFlag();
            }
            case 86: {
                return pSSubSysServiceAPIBase.getVer();
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
        PSSubSysServiceAPIBase.set(this, n, object);
    }

    private static void set(PSSubSysServiceAPIBase pSSubSysServiceAPIBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSubSysServiceAPIBase.setAddDEMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSSubSysServiceAPIBase.setAddDEParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSubSysServiceAPIBase.setAddDEPrefix(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSubSysServiceAPIBase.setAPISource(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSubSysServiceAPIBase.setAPITag(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSubSysServiceAPIBase.setAPITag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSubSysServiceAPIBase.setAPIType(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSubSysServiceAPIBase.setAuthAccessTokenUri(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSubSysServiceAPIBase.setAuthClientId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSubSysServiceAPIBase.setAuthClientSecret(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSubSysServiceAPIBase.setAuthCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSubSysServiceAPIBase.setAuthMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSubSysServiceAPIBase.setAuthParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSubSysServiceAPIBase.setAuthParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSubSysServiceAPIBase.setAuthParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSubSysServiceAPIBase.setAuthParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSubSysServiceAPIBase.setAuthTimeout(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSSubSysServiceAPIBase.setBaseClsParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSubSysServiceAPIBase.setCfgPSModelStorageId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSubSysServiceAPIBase.setCfgTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSubSysServiceAPIBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSubSysServiceAPIBase.setCodeNameMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSubSysServiceAPIBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 23: {
                pSSubSysServiceAPIBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSubSysServiceAPIBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSubSysServiceAPIBase.setCustomMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 26: {
                pSSubSysServiceAPIBase.setDefCreateReqMethod(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSubSysServiceAPIBase.setDefDEActionReqMethod(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSubSysServiceAPIBase.setDefDEDataSetReqMethod(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSubSysServiceAPIBase.setDefDeleteReqMethod(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSubSysServiceAPIBase.setDefGetDraftReqMethod(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSubSysServiceAPIBase.setDefGetReqMethod(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSubSysServiceAPIBase.setDefNeedResourceKey(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 33: {
                pSSubSysServiceAPIBase.setDefSelectReqMethod(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSubSysServiceAPIBase.setDefUpdateReqMethod(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSubSysServiceAPIBase.setDEPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSSubSysServiceAPIBase.setDEPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSSubSysServiceAPIBase.setEnableAPIModelEx(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 38: {
                pSSubSysServiceAPIBase.setFromDEModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 39: {
                pSSubSysServiceAPIBase.setHeaderParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSSubSysServiceAPIBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 41: {
                pSSubSysServiceAPIBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSSubSysServiceAPIBase.setMethodCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSSubSysServiceAPIBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 44: {
                pSSubSysServiceAPIBase.setPredefinedType(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSSubSysServiceAPIBase.setPSDevSlnSysAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSSubSysServiceAPIBase.setPSDevSlnSysAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSSubSysServiceAPIBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSSubSysServiceAPIBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSSubSysServiceAPIBase.setPSSubSysServiceAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSSubSysServiceAPIBase.setPSSubSysServiceAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSSubSysServiceAPIBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSSubSysServiceAPIBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSSubSysServiceAPIBase.setPSSysEAISchemeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSSubSysServiceAPIBase.setPSSysEAISchemeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSSubSysServiceAPIBase.setPSSysReqItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSSubSysServiceAPIBase.setPSSysReqItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSSubSysServiceAPIBase.setPSSysResourceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 58: {
                pSSubSysServiceAPIBase.setPSSysResourceName(DataObject.getStringValue((Object)object));
                return;
            }
            case 59: {
                pSSubSysServiceAPIBase.setPSSysSAHandlerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 60: {
                pSSubSysServiceAPIBase.setPSSysSAHandlerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 61: {
                pSSubSysServiceAPIBase.setPSSysServiceAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 62: {
                pSSubSysServiceAPIBase.setPSSysServiceAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 63: {
                pSSubSysServiceAPIBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 64: {
                pSSubSysServiceAPIBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 65: {
                pSSubSysServiceAPIBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 66: {
                pSSubSysServiceAPIBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 67: {
                pSSubSysServiceAPIBase.setResetDefActionCodeName(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 68: {
                pSSubSysServiceAPIBase.setScriptEngine(DataObject.getStringValue((Object)object));
                return;
            }
            case 69: {
                pSSubSysServiceAPIBase.setServiceCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 70: {
                pSSubSysServiceAPIBase.setServiceDTOFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 71: {
                pSSubSysServiceAPIBase.setServiceParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 72: {
                pSSubSysServiceAPIBase.setServiceParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 73: {
                pSSubSysServiceAPIBase.setServiceParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 74: {
                pSSubSysServiceAPIBase.setServiceParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 75: {
                pSSubSysServiceAPIBase.setServiceParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 76: {
                pSSubSysServiceAPIBase.setServicePath(DataObject.getStringValue((Object)object));
                return;
            }
            case 77: {
                pSSubSysServiceAPIBase.setServiceType(DataObject.getStringValue((Object)object));
                return;
            }
            case 78: {
                pSSubSysServiceAPIBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 79: {
                pSSubSysServiceAPIBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 80: {
                pSSubSysServiceAPIBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 81: {
                pSSubSysServiceAPIBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 82: {
                pSSubSysServiceAPIBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 83: {
                pSSubSysServiceAPIBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 84: {
                pSSubSysServiceAPIBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 85: {
                pSSubSysServiceAPIBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 86: {
                pSSubSysServiceAPIBase.setVer(DataObject.getIntegerValue((Object)object));
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
        return PSSubSysServiceAPIBase.isNull(this, n);
    }

    private static boolean isNull(PSSubSysServiceAPIBase pSSubSysServiceAPIBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSubSysServiceAPIBase.getAddDEMode() == null;
            }
            case 1: {
                return pSSubSysServiceAPIBase.getAddDEParams() == null;
            }
            case 2: {
                return pSSubSysServiceAPIBase.getAddDEPrefix() == null;
            }
            case 3: {
                return pSSubSysServiceAPIBase.getAPISource() == null;
            }
            case 4: {
                return pSSubSysServiceAPIBase.getAPITag() == null;
            }
            case 5: {
                return pSSubSysServiceAPIBase.getAPITag2() == null;
            }
            case 6: {
                return pSSubSysServiceAPIBase.getAPIType() == null;
            }
            case 7: {
                return pSSubSysServiceAPIBase.getAuthAccessTokenUri() == null;
            }
            case 8: {
                return pSSubSysServiceAPIBase.getAuthClientId() == null;
            }
            case 9: {
                return pSSubSysServiceAPIBase.getAuthClientSecret() == null;
            }
            case 10: {
                return pSSubSysServiceAPIBase.getAuthCode() == null;
            }
            case 11: {
                return pSSubSysServiceAPIBase.getAuthMode() == null;
            }
            case 12: {
                return pSSubSysServiceAPIBase.getAuthParam() == null;
            }
            case 13: {
                return pSSubSysServiceAPIBase.getAuthParam2() == null;
            }
            case 14: {
                return pSSubSysServiceAPIBase.getAuthParam3() == null;
            }
            case 15: {
                return pSSubSysServiceAPIBase.getAuthParam4() == null;
            }
            case 16: {
                return pSSubSysServiceAPIBase.getAuthTimeout() == null;
            }
            case 17: {
                return pSSubSysServiceAPIBase.getBaseClsParams() == null;
            }
            case 18: {
                return pSSubSysServiceAPIBase.getCfgPSModelStorageId() == null;
            }
            case 19: {
                return pSSubSysServiceAPIBase.getCfgTag() == null;
            }
            case 20: {
                return pSSubSysServiceAPIBase.getCodeName() == null;
            }
            case 21: {
                return pSSubSysServiceAPIBase.getCodeNameMode() == null;
            }
            case 22: {
                return pSSubSysServiceAPIBase.getCreateDate() == null;
            }
            case 23: {
                return pSSubSysServiceAPIBase.getCreateMan() == null;
            }
            case 24: {
                return pSSubSysServiceAPIBase.getCustomCode() == null;
            }
            case 25: {
                return pSSubSysServiceAPIBase.getCustomMode() == null;
            }
            case 26: {
                return pSSubSysServiceAPIBase.getDefCreateReqMethod() == null;
            }
            case 27: {
                return pSSubSysServiceAPIBase.getDefDEActionReqMethod() == null;
            }
            case 28: {
                return pSSubSysServiceAPIBase.getDefDEDataSetReqMethod() == null;
            }
            case 29: {
                return pSSubSysServiceAPIBase.getDefDeleteReqMethod() == null;
            }
            case 30: {
                return pSSubSysServiceAPIBase.getDefGetDraftReqMethod() == null;
            }
            case 31: {
                return pSSubSysServiceAPIBase.getDefGetReqMethod() == null;
            }
            case 32: {
                return pSSubSysServiceAPIBase.getDefNeedResourceKey() == null;
            }
            case 33: {
                return pSSubSysServiceAPIBase.getDefSelectReqMethod() == null;
            }
            case 34: {
                return pSSubSysServiceAPIBase.getDefUpdateReqMethod() == null;
            }
            case 35: {
                return pSSubSysServiceAPIBase.getDEPSSysSFPluginId() == null;
            }
            case 36: {
                return pSSubSysServiceAPIBase.getDEPSSysSFPluginName() == null;
            }
            case 37: {
                return pSSubSysServiceAPIBase.getEnableAPIModelEx() == null;
            }
            case 38: {
                return pSSubSysServiceAPIBase.getFromDEModelFlag() == null;
            }
            case 39: {
                return pSSubSysServiceAPIBase.getHeaderParams() == null;
            }
            case 40: {
                return pSSubSysServiceAPIBase.getLockFlag() == null;
            }
            case 41: {
                return pSSubSysServiceAPIBase.getMemo() == null;
            }
            case 42: {
                return pSSubSysServiceAPIBase.getMethodCode() == null;
            }
            case 43: {
                return pSSubSysServiceAPIBase.getOrderValue() == null;
            }
            case 44: {
                return pSSubSysServiceAPIBase.getPredefinedType() == null;
            }
            case 45: {
                return pSSubSysServiceAPIBase.getPSDevSlnSysAPIId() == null;
            }
            case 46: {
                return pSSubSysServiceAPIBase.getPSDevSlnSysAPIName() == null;
            }
            case 47: {
                return pSSubSysServiceAPIBase.getPSModuleId() == null;
            }
            case 48: {
                return pSSubSysServiceAPIBase.getPSModuleName() == null;
            }
            case 49: {
                return pSSubSysServiceAPIBase.getPSSubSysServiceAPIId() == null;
            }
            case 50: {
                return pSSubSysServiceAPIBase.getPSSubSysServiceAPIName() == null;
            }
            case 51: {
                return pSSubSysServiceAPIBase.getPSSysDynaModelId() == null;
            }
            case 52: {
                return pSSubSysServiceAPIBase.getPSSysDynaModelName() == null;
            }
            case 53: {
                return pSSubSysServiceAPIBase.getPSSysEAISchemeId() == null;
            }
            case 54: {
                return pSSubSysServiceAPIBase.getPSSysEAISchemeName() == null;
            }
            case 55: {
                return pSSubSysServiceAPIBase.getPSSysReqItemId() == null;
            }
            case 56: {
                return pSSubSysServiceAPIBase.getPSSysReqItemName() == null;
            }
            case 57: {
                return pSSubSysServiceAPIBase.getPSSysResourceId() == null;
            }
            case 58: {
                return pSSubSysServiceAPIBase.getPSSysResourceName() == null;
            }
            case 59: {
                return pSSubSysServiceAPIBase.getPSSysSAHandlerId() == null;
            }
            case 60: {
                return pSSubSysServiceAPIBase.getPSSysSAHandlerName() == null;
            }
            case 61: {
                return pSSubSysServiceAPIBase.getPSSysServiceAPIId() == null;
            }
            case 62: {
                return pSSubSysServiceAPIBase.getPSSysServiceAPIName() == null;
            }
            case 63: {
                return pSSubSysServiceAPIBase.getPSSysSFPluginId() == null;
            }
            case 64: {
                return pSSubSysServiceAPIBase.getPSSysSFPluginName() == null;
            }
            case 65: {
                return pSSubSysServiceAPIBase.getPSSystemId() == null;
            }
            case 66: {
                return pSSubSysServiceAPIBase.getPSSystemName() == null;
            }
            case 67: {
                return pSSubSysServiceAPIBase.getResetDefActionCodeName() == null;
            }
            case 68: {
                return pSSubSysServiceAPIBase.getScriptEngine() == null;
            }
            case 69: {
                return pSSubSysServiceAPIBase.getServiceCodeName() == null;
            }
            case 70: {
                return pSSubSysServiceAPIBase.getServiceDTOFlag() == null;
            }
            case 71: {
                return pSSubSysServiceAPIBase.getServiceParam() == null;
            }
            case 72: {
                return pSSubSysServiceAPIBase.getServiceParam2() == null;
            }
            case 73: {
                return pSSubSysServiceAPIBase.getServiceParam3() == null;
            }
            case 74: {
                return pSSubSysServiceAPIBase.getServiceParam4() == null;
            }
            case 75: {
                return pSSubSysServiceAPIBase.getServiceParams() == null;
            }
            case 76: {
                return pSSubSysServiceAPIBase.getServicePath() == null;
            }
            case 77: {
                return pSSubSysServiceAPIBase.getServiceType() == null;
            }
            case 78: {
                return pSSubSysServiceAPIBase.getUpdateDate() == null;
            }
            case 79: {
                return pSSubSysServiceAPIBase.getUpdateMan() == null;
            }
            case 80: {
                return pSSubSysServiceAPIBase.getUserCat() == null;
            }
            case 81: {
                return pSSubSysServiceAPIBase.getUserTag() == null;
            }
            case 82: {
                return pSSubSysServiceAPIBase.getUserTag2() == null;
            }
            case 83: {
                return pSSubSysServiceAPIBase.getUserTag3() == null;
            }
            case 84: {
                return pSSubSysServiceAPIBase.getUserTag4() == null;
            }
            case 85: {
                return pSSubSysServiceAPIBase.getValidFlag() == null;
            }
            case 86: {
                return pSSubSysServiceAPIBase.getVer() == null;
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
        return PSSubSysServiceAPIBase.contains(this, n);
    }

    private static boolean contains(PSSubSysServiceAPIBase pSSubSysServiceAPIBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSubSysServiceAPIBase.isAddDEModeDirty();
            }
            case 1: {
                return pSSubSysServiceAPIBase.isAddDEParamsDirty();
            }
            case 2: {
                return pSSubSysServiceAPIBase.isAddDEPrefixDirty();
            }
            case 3: {
                return pSSubSysServiceAPIBase.isAPISourceDirty();
            }
            case 4: {
                return pSSubSysServiceAPIBase.isAPITagDirty();
            }
            case 5: {
                return pSSubSysServiceAPIBase.isAPITag2Dirty();
            }
            case 6: {
                return pSSubSysServiceAPIBase.isAPITypeDirty();
            }
            case 7: {
                return pSSubSysServiceAPIBase.isAuthAccessTokenUriDirty();
            }
            case 8: {
                return pSSubSysServiceAPIBase.isAuthClientIdDirty();
            }
            case 9: {
                return pSSubSysServiceAPIBase.isAuthClientSecretDirty();
            }
            case 10: {
                return pSSubSysServiceAPIBase.isAuthCodeDirty();
            }
            case 11: {
                return pSSubSysServiceAPIBase.isAuthModeDirty();
            }
            case 12: {
                return pSSubSysServiceAPIBase.isAuthParamDirty();
            }
            case 13: {
                return pSSubSysServiceAPIBase.isAuthParam2Dirty();
            }
            case 14: {
                return pSSubSysServiceAPIBase.isAuthParam3Dirty();
            }
            case 15: {
                return pSSubSysServiceAPIBase.isAuthParam4Dirty();
            }
            case 16: {
                return pSSubSysServiceAPIBase.isAuthTimeoutDirty();
            }
            case 17: {
                return pSSubSysServiceAPIBase.isBaseClsParamsDirty();
            }
            case 18: {
                return pSSubSysServiceAPIBase.isCfgPSModelStorageIdDirty();
            }
            case 19: {
                return pSSubSysServiceAPIBase.isCfgTagDirty();
            }
            case 20: {
                return pSSubSysServiceAPIBase.isCodeNameDirty();
            }
            case 21: {
                return pSSubSysServiceAPIBase.isCodeNameModeDirty();
            }
            case 22: {
                return pSSubSysServiceAPIBase.isCreateDateDirty();
            }
            case 23: {
                return pSSubSysServiceAPIBase.isCreateManDirty();
            }
            case 24: {
                return pSSubSysServiceAPIBase.isCustomCodeDirty();
            }
            case 25: {
                return pSSubSysServiceAPIBase.isCustomModeDirty();
            }
            case 26: {
                return pSSubSysServiceAPIBase.isDefCreateReqMethodDirty();
            }
            case 27: {
                return pSSubSysServiceAPIBase.isDefDEActionReqMethodDirty();
            }
            case 28: {
                return pSSubSysServiceAPIBase.isDefDEDataSetReqMethodDirty();
            }
            case 29: {
                return pSSubSysServiceAPIBase.isDefDeleteReqMethodDirty();
            }
            case 30: {
                return pSSubSysServiceAPIBase.isDefGetDraftReqMethodDirty();
            }
            case 31: {
                return pSSubSysServiceAPIBase.isDefGetReqMethodDirty();
            }
            case 32: {
                return pSSubSysServiceAPIBase.isDefNeedResourceKeyDirty();
            }
            case 33: {
                return pSSubSysServiceAPIBase.isDefSelectReqMethodDirty();
            }
            case 34: {
                return pSSubSysServiceAPIBase.isDefUpdateReqMethodDirty();
            }
            case 35: {
                return pSSubSysServiceAPIBase.isDEPSSysSFPluginIdDirty();
            }
            case 36: {
                return pSSubSysServiceAPIBase.isDEPSSysSFPluginNameDirty();
            }
            case 37: {
                return pSSubSysServiceAPIBase.isEnableAPIModelExDirty();
            }
            case 38: {
                return pSSubSysServiceAPIBase.isFromDEModelFlagDirty();
            }
            case 39: {
                return pSSubSysServiceAPIBase.isHeaderParamsDirty();
            }
            case 40: {
                return pSSubSysServiceAPIBase.isLockFlagDirty();
            }
            case 41: {
                return pSSubSysServiceAPIBase.isMemoDirty();
            }
            case 42: {
                return pSSubSysServiceAPIBase.isMethodCodeDirty();
            }
            case 43: {
                return pSSubSysServiceAPIBase.isOrderValueDirty();
            }
            case 44: {
                return pSSubSysServiceAPIBase.isPredefinedTypeDirty();
            }
            case 45: {
                return pSSubSysServiceAPIBase.isPSDevSlnSysAPIIdDirty();
            }
            case 46: {
                return pSSubSysServiceAPIBase.isPSDevSlnSysAPINameDirty();
            }
            case 47: {
                return pSSubSysServiceAPIBase.isPSModuleIdDirty();
            }
            case 48: {
                return pSSubSysServiceAPIBase.isPSModuleNameDirty();
            }
            case 49: {
                return pSSubSysServiceAPIBase.isPSSubSysServiceAPIIdDirty();
            }
            case 50: {
                return pSSubSysServiceAPIBase.isPSSubSysServiceAPINameDirty();
            }
            case 51: {
                return pSSubSysServiceAPIBase.isPSSysDynaModelIdDirty();
            }
            case 52: {
                return pSSubSysServiceAPIBase.isPSSysDynaModelNameDirty();
            }
            case 53: {
                return pSSubSysServiceAPIBase.isPSSysEAISchemeIdDirty();
            }
            case 54: {
                return pSSubSysServiceAPIBase.isPSSysEAISchemeNameDirty();
            }
            case 55: {
                return pSSubSysServiceAPIBase.isPSSysReqItemIdDirty();
            }
            case 56: {
                return pSSubSysServiceAPIBase.isPSSysReqItemNameDirty();
            }
            case 57: {
                return pSSubSysServiceAPIBase.isPSSysResourceIdDirty();
            }
            case 58: {
                return pSSubSysServiceAPIBase.isPSSysResourceNameDirty();
            }
            case 59: {
                return pSSubSysServiceAPIBase.isPSSysSAHandlerIdDirty();
            }
            case 60: {
                return pSSubSysServiceAPIBase.isPSSysSAHandlerNameDirty();
            }
            case 61: {
                return pSSubSysServiceAPIBase.isPSSysServiceAPIIdDirty();
            }
            case 62: {
                return pSSubSysServiceAPIBase.isPSSysServiceAPINameDirty();
            }
            case 63: {
                return pSSubSysServiceAPIBase.isPSSysSFPluginIdDirty();
            }
            case 64: {
                return pSSubSysServiceAPIBase.isPSSysSFPluginNameDirty();
            }
            case 65: {
                return pSSubSysServiceAPIBase.isPSSystemIdDirty();
            }
            case 66: {
                return pSSubSysServiceAPIBase.isPSSystemNameDirty();
            }
            case 67: {
                return pSSubSysServiceAPIBase.isResetDefActionCodeNameDirty();
            }
            case 68: {
                return pSSubSysServiceAPIBase.isScriptEngineDirty();
            }
            case 69: {
                return pSSubSysServiceAPIBase.isServiceCodeNameDirty();
            }
            case 70: {
                return pSSubSysServiceAPIBase.isServiceDTOFlagDirty();
            }
            case 71: {
                return pSSubSysServiceAPIBase.isServiceParamDirty();
            }
            case 72: {
                return pSSubSysServiceAPIBase.isServiceParam2Dirty();
            }
            case 73: {
                return pSSubSysServiceAPIBase.isServiceParam3Dirty();
            }
            case 74: {
                return pSSubSysServiceAPIBase.isServiceParam4Dirty();
            }
            case 75: {
                return pSSubSysServiceAPIBase.isServiceParamsDirty();
            }
            case 76: {
                return pSSubSysServiceAPIBase.isServicePathDirty();
            }
            case 77: {
                return pSSubSysServiceAPIBase.isServiceTypeDirty();
            }
            case 78: {
                return pSSubSysServiceAPIBase.isUpdateDateDirty();
            }
            case 79: {
                return pSSubSysServiceAPIBase.isUpdateManDirty();
            }
            case 80: {
                return pSSubSysServiceAPIBase.isUserCatDirty();
            }
            case 81: {
                return pSSubSysServiceAPIBase.isUserTagDirty();
            }
            case 82: {
                return pSSubSysServiceAPIBase.isUserTag2Dirty();
            }
            case 83: {
                return pSSubSysServiceAPIBase.isUserTag3Dirty();
            }
            case 84: {
                return pSSubSysServiceAPIBase.isUserTag4Dirty();
            }
            case 85: {
                return pSSubSysServiceAPIBase.isValidFlagDirty();
            }
            case 86: {
                return pSSubSysServiceAPIBase.isVerDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSubSysServiceAPIBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSubSysServiceAPIBase pSSubSysServiceAPIBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSubSysServiceAPIBase.getAddDEMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"adddemode", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getAddDEMode()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getAddDEParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"adddeparams", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getAddDEParams()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getAddDEPrefix() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"adddeprefix", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getAddDEPrefix()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getAPISource() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"apisource", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getAPISource()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getAPITag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"apitag", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getAPITag()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getAPITag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"apitag2", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getAPITag2()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getAPIType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"apitype", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getAPIType()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getAuthAccessTokenUri() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authaccesstokenuri", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getAuthAccessTokenUri()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getAuthClientId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authclientid", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getAuthClientId()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getAuthClientSecret() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authclientsecret", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getAuthClientSecret()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getAuthCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authcode", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getAuthCode()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getAuthMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authmode", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getAuthMode()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getAuthParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authparam", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getAuthParam()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getAuthParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authparam2", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getAuthParam2()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getAuthParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authparam3", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getAuthParam3()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getAuthParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authparam4", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getAuthParam4()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getAuthTimeout() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authtimeout", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getAuthTimeout()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getBaseClsParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"baseclsparams", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getBaseClsParams()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getCfgPSModelStorageId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cfgpsmodelstorageid", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getCfgPSModelStorageId()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getCfgTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cfgtag", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getCfgTag()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getCodeNameMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codenamemode", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getCodeNameMode()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getCustomMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"custommode", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getCustomMode()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getDefCreateReqMethod() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defcreatereqmethod", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getDefCreateReqMethod()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getDefDEActionReqMethod() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defdeactionreqmethod", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getDefDEActionReqMethod()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getDefDEDataSetReqMethod() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defdedatasetreqmethod", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getDefDEDataSetReqMethod()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getDefDeleteReqMethod() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defdeletereqmethod", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getDefDeleteReqMethod()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getDefGetDraftReqMethod() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defgetdraftreqmethod", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getDefGetDraftReqMethod()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getDefGetReqMethod() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defgetreqmethod", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getDefGetReqMethod()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getDefNeedResourceKey() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defneedresourcekey", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getDefNeedResourceKey()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getDefSelectReqMethod() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defselectreqmethod", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getDefSelectReqMethod()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getDefUpdateReqMethod() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defupdatereqmethod", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getDefUpdateReqMethod()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getDEPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"depssyssfpluginid", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getDEPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getDEPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"depssyssfpluginname", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getDEPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getEnableAPIModelEx() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableapimodelex", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getEnableAPIModelEx()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getFromDEModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fromdemodelflag", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getFromDEModelFlag()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getHeaderParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"headerparams", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getHeaderParams()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getMemo()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getMethodCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"methodcode", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getMethodCode()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getPredefinedType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"predefinedtype", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getPredefinedType()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getPSDevSlnSysAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysapiid", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getPSDevSlnSysAPIId()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getPSDevSlnSysAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysapiname", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getPSDevSlnSysAPIName()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getPSSubSysServiceAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysserviceapiid", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getPSSubSysServiceAPIId()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getPSSubSysServiceAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysserviceapiname", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getPSSubSysServiceAPIName()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getPSSysEAISchemeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseaischemeid", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getPSSysEAISchemeId()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getPSSysEAISchemeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseaischemename", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getPSSysEAISchemeName()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getPSSysReqItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemid", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getPSSysReqItemId()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getPSSysReqItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemname", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getPSSysReqItemName()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getPSSysResourceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysresourceid", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getPSSysResourceId()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getPSSysResourceName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysresourcename", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getPSSysResourceName()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getPSSysSAHandlerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssahandlerid", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getPSSysSAHandlerId()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getPSSysSAHandlerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssahandlername", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getPSSysSAHandlerName()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getPSSysServiceAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysserviceapiid", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getPSSysServiceAPIId()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getPSSysServiceAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysserviceapiname", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getPSSysServiceAPIName()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getResetDefActionCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resetdefactioncodename", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getResetDefActionCodeName()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getScriptEngine() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"scriptengine", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getScriptEngine()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getServiceCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"servicecodename", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getServiceCodeName()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getServiceDTOFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"servicedtoflag", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getServiceDTOFlag()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getServiceParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"serviceparam", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getServiceParam()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getServiceParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"serviceparam2", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getServiceParam2()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getServiceParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"serviceparam3", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getServiceParam3()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getServiceParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"serviceparam4", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getServiceParam4()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getServiceParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"serviceparams", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getServiceParams()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getServicePath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"servicepath", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getServicePath()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getServiceType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"servicetype", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getServiceType()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSSubSysServiceAPIBase.getVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ver", (Object)PSSubSysServiceAPIBase.getJSONValue((Object)pSSubSysServiceAPIBase.getVer()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSubSysServiceAPIBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSubSysServiceAPIBase pSSubSysServiceAPIBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSubSysServiceAPIBase.getAddDEMode() != null) {
            object = pSSubSysServiceAPIBase.getAddDEMode();
            xmlNode.setAttribute(FIELD_ADDDEMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSubSysServiceAPIBase.getAddDEParams() != null) {
            object = pSSubSysServiceAPIBase.getAddDEParams();
            xmlNode.setAttribute(FIELD_ADDDEPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getAddDEPrefix() != null) {
            object = pSSubSysServiceAPIBase.getAddDEPrefix();
            xmlNode.setAttribute(FIELD_ADDDEPREFIX, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getAPISource() != null) {
            object = pSSubSysServiceAPIBase.getAPISource();
            xmlNode.setAttribute(FIELD_APISOURCE, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getAPITag() != null) {
            object = pSSubSysServiceAPIBase.getAPITag();
            xmlNode.setAttribute(FIELD_APITAG, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getAPITag2() != null) {
            object = pSSubSysServiceAPIBase.getAPITag2();
            xmlNode.setAttribute(FIELD_APITAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getAPIType() != null) {
            object = pSSubSysServiceAPIBase.getAPIType();
            xmlNode.setAttribute(FIELD_APITYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getAuthAccessTokenUri() != null) {
            object = pSSubSysServiceAPIBase.getAuthAccessTokenUri();
            xmlNode.setAttribute(FIELD_AUTHACCESSTOKENURI, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getAuthClientId() != null) {
            object = pSSubSysServiceAPIBase.getAuthClientId();
            xmlNode.setAttribute(FIELD_AUTHCLIENTID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getAuthClientSecret() != null) {
            object = pSSubSysServiceAPIBase.getAuthClientSecret();
            xmlNode.setAttribute(FIELD_AUTHCLIENTSECRET, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getAuthCode() != null) {
            object = pSSubSysServiceAPIBase.getAuthCode();
            xmlNode.setAttribute(FIELD_AUTHCODE, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getAuthMode() != null) {
            object = pSSubSysServiceAPIBase.getAuthMode();
            xmlNode.setAttribute(FIELD_AUTHMODE, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getAuthParam() != null) {
            object = pSSubSysServiceAPIBase.getAuthParam();
            xmlNode.setAttribute(FIELD_AUTHPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getAuthParam2() != null) {
            object = pSSubSysServiceAPIBase.getAuthParam2();
            xmlNode.setAttribute(FIELD_AUTHPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getAuthParam3() != null) {
            object = pSSubSysServiceAPIBase.getAuthParam3();
            xmlNode.setAttribute(FIELD_AUTHPARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getAuthParam4() != null) {
            object = pSSubSysServiceAPIBase.getAuthParam4();
            xmlNode.setAttribute(FIELD_AUTHPARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getAuthTimeout() != null) {
            object = pSSubSysServiceAPIBase.getAuthTimeout();
            xmlNode.setAttribute(FIELD_AUTHTIMEOUT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSubSysServiceAPIBase.getBaseClsParams() != null) {
            object = pSSubSysServiceAPIBase.getBaseClsParams();
            xmlNode.setAttribute(FIELD_BASECLSPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getCfgPSModelStorageId() != null) {
            object = pSSubSysServiceAPIBase.getCfgPSModelStorageId();
            xmlNode.setAttribute(FIELD_CFGPSMODELSTORAGEID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getCfgTag() != null) {
            object = pSSubSysServiceAPIBase.getCfgTag();
            xmlNode.setAttribute(FIELD_CFGTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getCodeName() != null) {
            object = pSSubSysServiceAPIBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getCodeNameMode() != null) {
            object = pSSubSysServiceAPIBase.getCodeNameMode();
            xmlNode.setAttribute(FIELD_CODENAMEMODE, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getCreateDate() != null) {
            object = pSSubSysServiceAPIBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSubSysServiceAPIBase.getCreateMan() != null) {
            object = pSSubSysServiceAPIBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getCustomCode() != null) {
            object = pSSubSysServiceAPIBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getCustomMode() != null) {
            object = pSSubSysServiceAPIBase.getCustomMode();
            xmlNode.setAttribute(FIELD_CUSTOMMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSubSysServiceAPIBase.getDefCreateReqMethod() != null) {
            object = pSSubSysServiceAPIBase.getDefCreateReqMethod();
            xmlNode.setAttribute(FIELD_DEFCREATEREQMETHOD, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getDefDEActionReqMethod() != null) {
            object = pSSubSysServiceAPIBase.getDefDEActionReqMethod();
            xmlNode.setAttribute(FIELD_DEFDEACTIONREQMETHOD, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getDefDEDataSetReqMethod() != null) {
            object = pSSubSysServiceAPIBase.getDefDEDataSetReqMethod();
            xmlNode.setAttribute(FIELD_DEFDEDATASETREQMETHOD, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getDefDeleteReqMethod() != null) {
            object = pSSubSysServiceAPIBase.getDefDeleteReqMethod();
            xmlNode.setAttribute(FIELD_DEFDELETEREQMETHOD, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getDefGetDraftReqMethod() != null) {
            object = pSSubSysServiceAPIBase.getDefGetDraftReqMethod();
            xmlNode.setAttribute(FIELD_DEFGETDRAFTREQMETHOD, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getDefGetReqMethod() != null) {
            object = pSSubSysServiceAPIBase.getDefGetReqMethod();
            xmlNode.setAttribute(FIELD_DEFGETREQMETHOD, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getDefNeedResourceKey() != null) {
            object = pSSubSysServiceAPIBase.getDefNeedResourceKey();
            xmlNode.setAttribute(FIELD_DEFNEEDRESOURCEKEY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSubSysServiceAPIBase.getDefSelectReqMethod() != null) {
            object = pSSubSysServiceAPIBase.getDefSelectReqMethod();
            xmlNode.setAttribute(FIELD_DEFSELECTREQMETHOD, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getDefUpdateReqMethod() != null) {
            object = pSSubSysServiceAPIBase.getDefUpdateReqMethod();
            xmlNode.setAttribute(FIELD_DEFUPDATEREQMETHOD, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getDEPSSysSFPluginId() != null) {
            object = pSSubSysServiceAPIBase.getDEPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_DEPSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getDEPSSysSFPluginName() != null) {
            object = pSSubSysServiceAPIBase.getDEPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_DEPSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getEnableAPIModelEx() != null) {
            object = pSSubSysServiceAPIBase.getEnableAPIModelEx();
            xmlNode.setAttribute(FIELD_ENABLEAPIMODELEX, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSubSysServiceAPIBase.getFromDEModelFlag() != null) {
            object = pSSubSysServiceAPIBase.getFromDEModelFlag();
            xmlNode.setAttribute(FIELD_FROMDEMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSubSysServiceAPIBase.getHeaderParams() != null) {
            object = pSSubSysServiceAPIBase.getHeaderParams();
            xmlNode.setAttribute(FIELD_HEADERPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getLockFlag() != null) {
            object = pSSubSysServiceAPIBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSubSysServiceAPIBase.getMemo() != null) {
            object = pSSubSysServiceAPIBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getMethodCode() != null) {
            object = pSSubSysServiceAPIBase.getMethodCode();
            xmlNode.setAttribute(FIELD_METHODCODE, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getOrderValue() != null) {
            object = pSSubSysServiceAPIBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSubSysServiceAPIBase.getPredefinedType() != null) {
            object = pSSubSysServiceAPIBase.getPredefinedType();
            xmlNode.setAttribute(FIELD_PREDEFINEDTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getPSDevSlnSysAPIId() != null) {
            object = pSSubSysServiceAPIBase.getPSDevSlnSysAPIId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getPSDevSlnSysAPIName() != null) {
            object = pSSubSysServiceAPIBase.getPSDevSlnSysAPIName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getPSModuleId() != null) {
            object = pSSubSysServiceAPIBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getPSModuleName() != null) {
            object = pSSubSysServiceAPIBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getPSSubSysServiceAPIId() != null) {
            object = pSSubSysServiceAPIBase.getPSSubSysServiceAPIId();
            xmlNode.setAttribute(FIELD_PSSUBSYSSERVICEAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getPSSubSysServiceAPIName() != null) {
            object = pSSubSysServiceAPIBase.getPSSubSysServiceAPIName();
            xmlNode.setAttribute(FIELD_PSSUBSYSSERVICEAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getPSSysDynaModelId() != null) {
            object = pSSubSysServiceAPIBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getPSSysDynaModelName() != null) {
            object = pSSubSysServiceAPIBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getPSSysEAISchemeId() != null) {
            object = pSSubSysServiceAPIBase.getPSSysEAISchemeId();
            xmlNode.setAttribute(FIELD_PSSYSEAISCHEMEID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getPSSysEAISchemeName() != null) {
            object = pSSubSysServiceAPIBase.getPSSysEAISchemeName();
            xmlNode.setAttribute(FIELD_PSSYSEAISCHEMENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getPSSysReqItemId() != null) {
            object = pSSubSysServiceAPIBase.getPSSysReqItemId();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getPSSysReqItemName() != null) {
            object = pSSubSysServiceAPIBase.getPSSysReqItemName();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getPSSysResourceId() != null) {
            object = pSSubSysServiceAPIBase.getPSSysResourceId();
            xmlNode.setAttribute(FIELD_PSSYSRESOURCEID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getPSSysResourceName() != null) {
            object = pSSubSysServiceAPIBase.getPSSysResourceName();
            xmlNode.setAttribute(FIELD_PSSYSRESOURCENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getPSSysSAHandlerId() != null) {
            object = pSSubSysServiceAPIBase.getPSSysSAHandlerId();
            xmlNode.setAttribute(FIELD_PSSYSSAHANDLERID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getPSSysSAHandlerName() != null) {
            object = pSSubSysServiceAPIBase.getPSSysSAHandlerName();
            xmlNode.setAttribute(FIELD_PSSYSSAHANDLERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getPSSysServiceAPIId() != null) {
            object = pSSubSysServiceAPIBase.getPSSysServiceAPIId();
            xmlNode.setAttribute(FIELD_PSSYSSERVICEAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getPSSysServiceAPIName() != null) {
            object = pSSubSysServiceAPIBase.getPSSysServiceAPIName();
            xmlNode.setAttribute(FIELD_PSSYSSERVICEAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getPSSysSFPluginId() != null) {
            object = pSSubSysServiceAPIBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getPSSysSFPluginName() != null) {
            object = pSSubSysServiceAPIBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getPSSystemId() != null) {
            object = pSSubSysServiceAPIBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getPSSystemName() != null) {
            object = pSSubSysServiceAPIBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getResetDefActionCodeName() != null) {
            object = pSSubSysServiceAPIBase.getResetDefActionCodeName();
            xmlNode.setAttribute(FIELD_RESETDEFACTIONCODENAME, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSubSysServiceAPIBase.getScriptEngine() != null) {
            object = pSSubSysServiceAPIBase.getScriptEngine();
            xmlNode.setAttribute(FIELD_SCRIPTENGINE, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getServiceCodeName() != null) {
            object = pSSubSysServiceAPIBase.getServiceCodeName();
            xmlNode.setAttribute(FIELD_SERVICECODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getServiceDTOFlag() != null) {
            object = pSSubSysServiceAPIBase.getServiceDTOFlag();
            xmlNode.setAttribute(FIELD_SERVICEDTOFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSubSysServiceAPIBase.getServiceParam() != null) {
            object = pSSubSysServiceAPIBase.getServiceParam();
            xmlNode.setAttribute(FIELD_SERVICEPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getServiceParam2() != null) {
            object = pSSubSysServiceAPIBase.getServiceParam2();
            xmlNode.setAttribute(FIELD_SERVICEPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getServiceParam3() != null) {
            object = pSSubSysServiceAPIBase.getServiceParam3();
            xmlNode.setAttribute(FIELD_SERVICEPARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getServiceParam4() != null) {
            object = pSSubSysServiceAPIBase.getServiceParam4();
            xmlNode.setAttribute(FIELD_SERVICEPARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getServiceParams() != null) {
            object = pSSubSysServiceAPIBase.getServiceParams();
            xmlNode.setAttribute(FIELD_SERVICEPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getServicePath() != null) {
            object = pSSubSysServiceAPIBase.getServicePath();
            xmlNode.setAttribute(FIELD_SERVICEPATH, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getServiceType() != null) {
            object = pSSubSysServiceAPIBase.getServiceType();
            xmlNode.setAttribute(FIELD_SERVICETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getUpdateDate() != null) {
            object = pSSubSysServiceAPIBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSubSysServiceAPIBase.getUpdateMan() != null) {
            object = pSSubSysServiceAPIBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getUserCat() != null) {
            object = pSSubSysServiceAPIBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getUserTag() != null) {
            object = pSSubSysServiceAPIBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getUserTag2() != null) {
            object = pSSubSysServiceAPIBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getUserTag3() != null) {
            object = pSSubSysServiceAPIBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getUserTag4() != null) {
            object = pSSubSysServiceAPIBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysServiceAPIBase.getValidFlag() != null) {
            object = pSSubSysServiceAPIBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSubSysServiceAPIBase.getVer() != null) {
            object = pSSubSysServiceAPIBase.getVer();
            xmlNode.setAttribute(FIELD_VER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSubSysServiceAPIBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSubSysServiceAPIBase pSSubSysServiceAPIBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSubSysServiceAPIBase.isAddDEModeDirty() && (bl || pSSubSysServiceAPIBase.getAddDEMode() != null)) {
            iDataObject.set(FIELD_ADDDEMODE, (Object)pSSubSysServiceAPIBase.getAddDEMode());
        }
        if (pSSubSysServiceAPIBase.isAddDEParamsDirty() && (bl || pSSubSysServiceAPIBase.getAddDEParams() != null)) {
            iDataObject.set(FIELD_ADDDEPARAMS, (Object)pSSubSysServiceAPIBase.getAddDEParams());
        }
        if (pSSubSysServiceAPIBase.isAddDEPrefixDirty() && (bl || pSSubSysServiceAPIBase.getAddDEPrefix() != null)) {
            iDataObject.set(FIELD_ADDDEPREFIX, (Object)pSSubSysServiceAPIBase.getAddDEPrefix());
        }
        if (pSSubSysServiceAPIBase.isAPISourceDirty() && (bl || pSSubSysServiceAPIBase.getAPISource() != null)) {
            iDataObject.set(FIELD_APISOURCE, (Object)pSSubSysServiceAPIBase.getAPISource());
        }
        if (pSSubSysServiceAPIBase.isAPITagDirty() && (bl || pSSubSysServiceAPIBase.getAPITag() != null)) {
            iDataObject.set(FIELD_APITAG, (Object)pSSubSysServiceAPIBase.getAPITag());
        }
        if (pSSubSysServiceAPIBase.isAPITag2Dirty() && (bl || pSSubSysServiceAPIBase.getAPITag2() != null)) {
            iDataObject.set(FIELD_APITAG2, (Object)pSSubSysServiceAPIBase.getAPITag2());
        }
        if (pSSubSysServiceAPIBase.isAPITypeDirty() && (bl || pSSubSysServiceAPIBase.getAPIType() != null)) {
            iDataObject.set(FIELD_APITYPE, (Object)pSSubSysServiceAPIBase.getAPIType());
        }
        if (pSSubSysServiceAPIBase.isAuthAccessTokenUriDirty() && (bl || pSSubSysServiceAPIBase.getAuthAccessTokenUri() != null)) {
            iDataObject.set(FIELD_AUTHACCESSTOKENURI, (Object)pSSubSysServiceAPIBase.getAuthAccessTokenUri());
        }
        if (pSSubSysServiceAPIBase.isAuthClientIdDirty() && (bl || pSSubSysServiceAPIBase.getAuthClientId() != null)) {
            iDataObject.set(FIELD_AUTHCLIENTID, (Object)pSSubSysServiceAPIBase.getAuthClientId());
        }
        if (pSSubSysServiceAPIBase.isAuthClientSecretDirty() && (bl || pSSubSysServiceAPIBase.getAuthClientSecret() != null)) {
            iDataObject.set(FIELD_AUTHCLIENTSECRET, (Object)pSSubSysServiceAPIBase.getAuthClientSecret());
        }
        if (pSSubSysServiceAPIBase.isAuthCodeDirty() && (bl || pSSubSysServiceAPIBase.getAuthCode() != null)) {
            iDataObject.set(FIELD_AUTHCODE, (Object)pSSubSysServiceAPIBase.getAuthCode());
        }
        if (pSSubSysServiceAPIBase.isAuthModeDirty() && (bl || pSSubSysServiceAPIBase.getAuthMode() != null)) {
            iDataObject.set(FIELD_AUTHMODE, (Object)pSSubSysServiceAPIBase.getAuthMode());
        }
        if (pSSubSysServiceAPIBase.isAuthParamDirty() && (bl || pSSubSysServiceAPIBase.getAuthParam() != null)) {
            iDataObject.set(FIELD_AUTHPARAM, (Object)pSSubSysServiceAPIBase.getAuthParam());
        }
        if (pSSubSysServiceAPIBase.isAuthParam2Dirty() && (bl || pSSubSysServiceAPIBase.getAuthParam2() != null)) {
            iDataObject.set(FIELD_AUTHPARAM2, (Object)pSSubSysServiceAPIBase.getAuthParam2());
        }
        if (pSSubSysServiceAPIBase.isAuthParam3Dirty() && (bl || pSSubSysServiceAPIBase.getAuthParam3() != null)) {
            iDataObject.set(FIELD_AUTHPARAM3, (Object)pSSubSysServiceAPIBase.getAuthParam3());
        }
        if (pSSubSysServiceAPIBase.isAuthParam4Dirty() && (bl || pSSubSysServiceAPIBase.getAuthParam4() != null)) {
            iDataObject.set(FIELD_AUTHPARAM4, (Object)pSSubSysServiceAPIBase.getAuthParam4());
        }
        if (pSSubSysServiceAPIBase.isAuthTimeoutDirty() && (bl || pSSubSysServiceAPIBase.getAuthTimeout() != null)) {
            iDataObject.set(FIELD_AUTHTIMEOUT, (Object)pSSubSysServiceAPIBase.getAuthTimeout());
        }
        if (pSSubSysServiceAPIBase.isBaseClsParamsDirty() && (bl || pSSubSysServiceAPIBase.getBaseClsParams() != null)) {
            iDataObject.set(FIELD_BASECLSPARAMS, (Object)pSSubSysServiceAPIBase.getBaseClsParams());
        }
        if (pSSubSysServiceAPIBase.isCfgPSModelStorageIdDirty() && (bl || pSSubSysServiceAPIBase.getCfgPSModelStorageId() != null)) {
            iDataObject.set(FIELD_CFGPSMODELSTORAGEID, (Object)pSSubSysServiceAPIBase.getCfgPSModelStorageId());
        }
        if (pSSubSysServiceAPIBase.isCfgTagDirty() && (bl || pSSubSysServiceAPIBase.getCfgTag() != null)) {
            iDataObject.set(FIELD_CFGTAG, (Object)pSSubSysServiceAPIBase.getCfgTag());
        }
        if (pSSubSysServiceAPIBase.isCodeNameDirty() && (bl || pSSubSysServiceAPIBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSubSysServiceAPIBase.getCodeName());
        }
        if (pSSubSysServiceAPIBase.isCodeNameModeDirty() && (bl || pSSubSysServiceAPIBase.getCodeNameMode() != null)) {
            iDataObject.set(FIELD_CODENAMEMODE, (Object)pSSubSysServiceAPIBase.getCodeNameMode());
        }
        if (pSSubSysServiceAPIBase.isCreateDateDirty() && (bl || pSSubSysServiceAPIBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSubSysServiceAPIBase.getCreateDate());
        }
        if (pSSubSysServiceAPIBase.isCreateManDirty() && (bl || pSSubSysServiceAPIBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSubSysServiceAPIBase.getCreateMan());
        }
        if (pSSubSysServiceAPIBase.isCustomCodeDirty() && (bl || pSSubSysServiceAPIBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSSubSysServiceAPIBase.getCustomCode());
        }
        if (pSSubSysServiceAPIBase.isCustomModeDirty() && (bl || pSSubSysServiceAPIBase.getCustomMode() != null)) {
            iDataObject.set(FIELD_CUSTOMMODE, (Object)pSSubSysServiceAPIBase.getCustomMode());
        }
        if (pSSubSysServiceAPIBase.isDefCreateReqMethodDirty() && (bl || pSSubSysServiceAPIBase.getDefCreateReqMethod() != null)) {
            iDataObject.set(FIELD_DEFCREATEREQMETHOD, (Object)pSSubSysServiceAPIBase.getDefCreateReqMethod());
        }
        if (pSSubSysServiceAPIBase.isDefDEActionReqMethodDirty() && (bl || pSSubSysServiceAPIBase.getDefDEActionReqMethod() != null)) {
            iDataObject.set(FIELD_DEFDEACTIONREQMETHOD, (Object)pSSubSysServiceAPIBase.getDefDEActionReqMethod());
        }
        if (pSSubSysServiceAPIBase.isDefDEDataSetReqMethodDirty() && (bl || pSSubSysServiceAPIBase.getDefDEDataSetReqMethod() != null)) {
            iDataObject.set(FIELD_DEFDEDATASETREQMETHOD, (Object)pSSubSysServiceAPIBase.getDefDEDataSetReqMethod());
        }
        if (pSSubSysServiceAPIBase.isDefDeleteReqMethodDirty() && (bl || pSSubSysServiceAPIBase.getDefDeleteReqMethod() != null)) {
            iDataObject.set(FIELD_DEFDELETEREQMETHOD, (Object)pSSubSysServiceAPIBase.getDefDeleteReqMethod());
        }
        if (pSSubSysServiceAPIBase.isDefGetDraftReqMethodDirty() && (bl || pSSubSysServiceAPIBase.getDefGetDraftReqMethod() != null)) {
            iDataObject.set(FIELD_DEFGETDRAFTREQMETHOD, (Object)pSSubSysServiceAPIBase.getDefGetDraftReqMethod());
        }
        if (pSSubSysServiceAPIBase.isDefGetReqMethodDirty() && (bl || pSSubSysServiceAPIBase.getDefGetReqMethod() != null)) {
            iDataObject.set(FIELD_DEFGETREQMETHOD, (Object)pSSubSysServiceAPIBase.getDefGetReqMethod());
        }
        if (pSSubSysServiceAPIBase.isDefNeedResourceKeyDirty() && (bl || pSSubSysServiceAPIBase.getDefNeedResourceKey() != null)) {
            iDataObject.set(FIELD_DEFNEEDRESOURCEKEY, (Object)pSSubSysServiceAPIBase.getDefNeedResourceKey());
        }
        if (pSSubSysServiceAPIBase.isDefSelectReqMethodDirty() && (bl || pSSubSysServiceAPIBase.getDefSelectReqMethod() != null)) {
            iDataObject.set(FIELD_DEFSELECTREQMETHOD, (Object)pSSubSysServiceAPIBase.getDefSelectReqMethod());
        }
        if (pSSubSysServiceAPIBase.isDefUpdateReqMethodDirty() && (bl || pSSubSysServiceAPIBase.getDefUpdateReqMethod() != null)) {
            iDataObject.set(FIELD_DEFUPDATEREQMETHOD, (Object)pSSubSysServiceAPIBase.getDefUpdateReqMethod());
        }
        if (pSSubSysServiceAPIBase.isDEPSSysSFPluginIdDirty() && (bl || pSSubSysServiceAPIBase.getDEPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_DEPSSYSSFPLUGINID, (Object)pSSubSysServiceAPIBase.getDEPSSysSFPluginId());
        }
        if (pSSubSysServiceAPIBase.isDEPSSysSFPluginNameDirty() && (bl || pSSubSysServiceAPIBase.getDEPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_DEPSSYSSFPLUGINNAME, (Object)pSSubSysServiceAPIBase.getDEPSSysSFPluginName());
        }
        if (pSSubSysServiceAPIBase.isEnableAPIModelExDirty() && (bl || pSSubSysServiceAPIBase.getEnableAPIModelEx() != null)) {
            iDataObject.set(FIELD_ENABLEAPIMODELEX, (Object)pSSubSysServiceAPIBase.getEnableAPIModelEx());
        }
        if (pSSubSysServiceAPIBase.isFromDEModelFlagDirty() && (bl || pSSubSysServiceAPIBase.getFromDEModelFlag() != null)) {
            iDataObject.set(FIELD_FROMDEMODELFLAG, (Object)pSSubSysServiceAPIBase.getFromDEModelFlag());
        }
        if (pSSubSysServiceAPIBase.isHeaderParamsDirty() && (bl || pSSubSysServiceAPIBase.getHeaderParams() != null)) {
            iDataObject.set(FIELD_HEADERPARAMS, (Object)pSSubSysServiceAPIBase.getHeaderParams());
        }
        if (pSSubSysServiceAPIBase.isLockFlagDirty() && (bl || pSSubSysServiceAPIBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSSubSysServiceAPIBase.getLockFlag());
        }
        if (pSSubSysServiceAPIBase.isMemoDirty() && (bl || pSSubSysServiceAPIBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSubSysServiceAPIBase.getMemo());
        }
        if (pSSubSysServiceAPIBase.isMethodCodeDirty() && (bl || pSSubSysServiceAPIBase.getMethodCode() != null)) {
            iDataObject.set(FIELD_METHODCODE, (Object)pSSubSysServiceAPIBase.getMethodCode());
        }
        if (pSSubSysServiceAPIBase.isOrderValueDirty() && (bl || pSSubSysServiceAPIBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSubSysServiceAPIBase.getOrderValue());
        }
        if (pSSubSysServiceAPIBase.isPredefinedTypeDirty() && (bl || pSSubSysServiceAPIBase.getPredefinedType() != null)) {
            iDataObject.set(FIELD_PREDEFINEDTYPE, (Object)pSSubSysServiceAPIBase.getPredefinedType());
        }
        if (pSSubSysServiceAPIBase.isPSDevSlnSysAPIIdDirty() && (bl || pSSubSysServiceAPIBase.getPSDevSlnSysAPIId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSAPIID, (Object)pSSubSysServiceAPIBase.getPSDevSlnSysAPIId());
        }
        if (pSSubSysServiceAPIBase.isPSDevSlnSysAPINameDirty() && (bl || pSSubSysServiceAPIBase.getPSDevSlnSysAPIName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSAPINAME, (Object)pSSubSysServiceAPIBase.getPSDevSlnSysAPIName());
        }
        if (pSSubSysServiceAPIBase.isPSModuleIdDirty() && (bl || pSSubSysServiceAPIBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSubSysServiceAPIBase.getPSModuleId());
        }
        if (pSSubSysServiceAPIBase.isPSModuleNameDirty() && (bl || pSSubSysServiceAPIBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSubSysServiceAPIBase.getPSModuleName());
        }
        if (pSSubSysServiceAPIBase.isPSSubSysServiceAPIIdDirty() && (bl || pSSubSysServiceAPIBase.getPSSubSysServiceAPIId() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSERVICEAPIID, (Object)pSSubSysServiceAPIBase.getPSSubSysServiceAPIId());
        }
        if (pSSubSysServiceAPIBase.isPSSubSysServiceAPINameDirty() && (bl || pSSubSysServiceAPIBase.getPSSubSysServiceAPIName() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSERVICEAPINAME, (Object)pSSubSysServiceAPIBase.getPSSubSysServiceAPIName());
        }
        if (pSSubSysServiceAPIBase.isPSSysDynaModelIdDirty() && (bl || pSSubSysServiceAPIBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSSubSysServiceAPIBase.getPSSysDynaModelId());
        }
        if (pSSubSysServiceAPIBase.isPSSysDynaModelNameDirty() && (bl || pSSubSysServiceAPIBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSSubSysServiceAPIBase.getPSSysDynaModelName());
        }
        if (pSSubSysServiceAPIBase.isPSSysEAISchemeIdDirty() && (bl || pSSubSysServiceAPIBase.getPSSysEAISchemeId() != null)) {
            iDataObject.set(FIELD_PSSYSEAISCHEMEID, (Object)pSSubSysServiceAPIBase.getPSSysEAISchemeId());
        }
        if (pSSubSysServiceAPIBase.isPSSysEAISchemeNameDirty() && (bl || pSSubSysServiceAPIBase.getPSSysEAISchemeName() != null)) {
            iDataObject.set(FIELD_PSSYSEAISCHEMENAME, (Object)pSSubSysServiceAPIBase.getPSSysEAISchemeName());
        }
        if (pSSubSysServiceAPIBase.isPSSysReqItemIdDirty() && (bl || pSSubSysServiceAPIBase.getPSSysReqItemId() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMID, (Object)pSSubSysServiceAPIBase.getPSSysReqItemId());
        }
        if (pSSubSysServiceAPIBase.isPSSysReqItemNameDirty() && (bl || pSSubSysServiceAPIBase.getPSSysReqItemName() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMNAME, (Object)pSSubSysServiceAPIBase.getPSSysReqItemName());
        }
        if (pSSubSysServiceAPIBase.isPSSysResourceIdDirty() && (bl || pSSubSysServiceAPIBase.getPSSysResourceId() != null)) {
            iDataObject.set(FIELD_PSSYSRESOURCEID, (Object)pSSubSysServiceAPIBase.getPSSysResourceId());
        }
        if (pSSubSysServiceAPIBase.isPSSysResourceNameDirty() && (bl || pSSubSysServiceAPIBase.getPSSysResourceName() != null)) {
            iDataObject.set(FIELD_PSSYSRESOURCENAME, (Object)pSSubSysServiceAPIBase.getPSSysResourceName());
        }
        if (pSSubSysServiceAPIBase.isPSSysSAHandlerIdDirty() && (bl || pSSubSysServiceAPIBase.getPSSysSAHandlerId() != null)) {
            iDataObject.set(FIELD_PSSYSSAHANDLERID, (Object)pSSubSysServiceAPIBase.getPSSysSAHandlerId());
        }
        if (pSSubSysServiceAPIBase.isPSSysSAHandlerNameDirty() && (bl || pSSubSysServiceAPIBase.getPSSysSAHandlerName() != null)) {
            iDataObject.set(FIELD_PSSYSSAHANDLERNAME, (Object)pSSubSysServiceAPIBase.getPSSysSAHandlerName());
        }
        if (pSSubSysServiceAPIBase.isPSSysServiceAPIIdDirty() && (bl || pSSubSysServiceAPIBase.getPSSysServiceAPIId() != null)) {
            iDataObject.set(FIELD_PSSYSSERVICEAPIID, (Object)pSSubSysServiceAPIBase.getPSSysServiceAPIId());
        }
        if (pSSubSysServiceAPIBase.isPSSysServiceAPINameDirty() && (bl || pSSubSysServiceAPIBase.getPSSysServiceAPIName() != null)) {
            iDataObject.set(FIELD_PSSYSSERVICEAPINAME, (Object)pSSubSysServiceAPIBase.getPSSysServiceAPIName());
        }
        if (pSSubSysServiceAPIBase.isPSSysSFPluginIdDirty() && (bl || pSSubSysServiceAPIBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSSubSysServiceAPIBase.getPSSysSFPluginId());
        }
        if (pSSubSysServiceAPIBase.isPSSysSFPluginNameDirty() && (bl || pSSubSysServiceAPIBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSSubSysServiceAPIBase.getPSSysSFPluginName());
        }
        if (pSSubSysServiceAPIBase.isPSSystemIdDirty() && (bl || pSSubSysServiceAPIBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSubSysServiceAPIBase.getPSSystemId());
        }
        if (pSSubSysServiceAPIBase.isPSSystemNameDirty() && (bl || pSSubSysServiceAPIBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSubSysServiceAPIBase.getPSSystemName());
        }
        if (pSSubSysServiceAPIBase.isResetDefActionCodeNameDirty() && (bl || pSSubSysServiceAPIBase.getResetDefActionCodeName() != null)) {
            iDataObject.set(FIELD_RESETDEFACTIONCODENAME, (Object)pSSubSysServiceAPIBase.getResetDefActionCodeName());
        }
        if (pSSubSysServiceAPIBase.isScriptEngineDirty() && (bl || pSSubSysServiceAPIBase.getScriptEngine() != null)) {
            iDataObject.set(FIELD_SCRIPTENGINE, (Object)pSSubSysServiceAPIBase.getScriptEngine());
        }
        if (pSSubSysServiceAPIBase.isServiceCodeNameDirty() && (bl || pSSubSysServiceAPIBase.getServiceCodeName() != null)) {
            iDataObject.set(FIELD_SERVICECODENAME, (Object)pSSubSysServiceAPIBase.getServiceCodeName());
        }
        if (pSSubSysServiceAPIBase.isServiceDTOFlagDirty() && (bl || pSSubSysServiceAPIBase.getServiceDTOFlag() != null)) {
            iDataObject.set(FIELD_SERVICEDTOFLAG, (Object)pSSubSysServiceAPIBase.getServiceDTOFlag());
        }
        if (pSSubSysServiceAPIBase.isServiceParamDirty() && (bl || pSSubSysServiceAPIBase.getServiceParam() != null)) {
            iDataObject.set(FIELD_SERVICEPARAM, (Object)pSSubSysServiceAPIBase.getServiceParam());
        }
        if (pSSubSysServiceAPIBase.isServiceParam2Dirty() && (bl || pSSubSysServiceAPIBase.getServiceParam2() != null)) {
            iDataObject.set(FIELD_SERVICEPARAM2, (Object)pSSubSysServiceAPIBase.getServiceParam2());
        }
        if (pSSubSysServiceAPIBase.isServiceParam3Dirty() && (bl || pSSubSysServiceAPIBase.getServiceParam3() != null)) {
            iDataObject.set(FIELD_SERVICEPARAM3, (Object)pSSubSysServiceAPIBase.getServiceParam3());
        }
        if (pSSubSysServiceAPIBase.isServiceParam4Dirty() && (bl || pSSubSysServiceAPIBase.getServiceParam4() != null)) {
            iDataObject.set(FIELD_SERVICEPARAM4, (Object)pSSubSysServiceAPIBase.getServiceParam4());
        }
        if (pSSubSysServiceAPIBase.isServiceParamsDirty() && (bl || pSSubSysServiceAPIBase.getServiceParams() != null)) {
            iDataObject.set(FIELD_SERVICEPARAMS, (Object)pSSubSysServiceAPIBase.getServiceParams());
        }
        if (pSSubSysServiceAPIBase.isServicePathDirty() && (bl || pSSubSysServiceAPIBase.getServicePath() != null)) {
            iDataObject.set(FIELD_SERVICEPATH, (Object)pSSubSysServiceAPIBase.getServicePath());
        }
        if (pSSubSysServiceAPIBase.isServiceTypeDirty() && (bl || pSSubSysServiceAPIBase.getServiceType() != null)) {
            iDataObject.set(FIELD_SERVICETYPE, (Object)pSSubSysServiceAPIBase.getServiceType());
        }
        if (pSSubSysServiceAPIBase.isUpdateDateDirty() && (bl || pSSubSysServiceAPIBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSubSysServiceAPIBase.getUpdateDate());
        }
        if (pSSubSysServiceAPIBase.isUpdateManDirty() && (bl || pSSubSysServiceAPIBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSubSysServiceAPIBase.getUpdateMan());
        }
        if (pSSubSysServiceAPIBase.isUserCatDirty() && (bl || pSSubSysServiceAPIBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSubSysServiceAPIBase.getUserCat());
        }
        if (pSSubSysServiceAPIBase.isUserTagDirty() && (bl || pSSubSysServiceAPIBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSubSysServiceAPIBase.getUserTag());
        }
        if (pSSubSysServiceAPIBase.isUserTag2Dirty() && (bl || pSSubSysServiceAPIBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSubSysServiceAPIBase.getUserTag2());
        }
        if (pSSubSysServiceAPIBase.isUserTag3Dirty() && (bl || pSSubSysServiceAPIBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSubSysServiceAPIBase.getUserTag3());
        }
        if (pSSubSysServiceAPIBase.isUserTag4Dirty() && (bl || pSSubSysServiceAPIBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSubSysServiceAPIBase.getUserTag4());
        }
        if (pSSubSysServiceAPIBase.isValidFlagDirty() && (bl || pSSubSysServiceAPIBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSubSysServiceAPIBase.getValidFlag());
        }
        if (pSSubSysServiceAPIBase.isVerDirty() && (bl || pSSubSysServiceAPIBase.getVer() != null)) {
            iDataObject.set(FIELD_VER, (Object)pSSubSysServiceAPIBase.getVer());
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
        return PSSubSysServiceAPIBase.remove(this, n);
    }

    private static boolean remove(PSSubSysServiceAPIBase pSSubSysServiceAPIBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSubSysServiceAPIBase.resetAddDEMode();
                return true;
            }
            case 1: {
                pSSubSysServiceAPIBase.resetAddDEParams();
                return true;
            }
            case 2: {
                pSSubSysServiceAPIBase.resetAddDEPrefix();
                return true;
            }
            case 3: {
                pSSubSysServiceAPIBase.resetAPISource();
                return true;
            }
            case 4: {
                pSSubSysServiceAPIBase.resetAPITag();
                return true;
            }
            case 5: {
                pSSubSysServiceAPIBase.resetAPITag2();
                return true;
            }
            case 6: {
                pSSubSysServiceAPIBase.resetAPIType();
                return true;
            }
            case 7: {
                pSSubSysServiceAPIBase.resetAuthAccessTokenUri();
                return true;
            }
            case 8: {
                pSSubSysServiceAPIBase.resetAuthClientId();
                return true;
            }
            case 9: {
                pSSubSysServiceAPIBase.resetAuthClientSecret();
                return true;
            }
            case 10: {
                pSSubSysServiceAPIBase.resetAuthCode();
                return true;
            }
            case 11: {
                pSSubSysServiceAPIBase.resetAuthMode();
                return true;
            }
            case 12: {
                pSSubSysServiceAPIBase.resetAuthParam();
                return true;
            }
            case 13: {
                pSSubSysServiceAPIBase.resetAuthParam2();
                return true;
            }
            case 14: {
                pSSubSysServiceAPIBase.resetAuthParam3();
                return true;
            }
            case 15: {
                pSSubSysServiceAPIBase.resetAuthParam4();
                return true;
            }
            case 16: {
                pSSubSysServiceAPIBase.resetAuthTimeout();
                return true;
            }
            case 17: {
                pSSubSysServiceAPIBase.resetBaseClsParams();
                return true;
            }
            case 18: {
                pSSubSysServiceAPIBase.resetCfgPSModelStorageId();
                return true;
            }
            case 19: {
                pSSubSysServiceAPIBase.resetCfgTag();
                return true;
            }
            case 20: {
                pSSubSysServiceAPIBase.resetCodeName();
                return true;
            }
            case 21: {
                pSSubSysServiceAPIBase.resetCodeNameMode();
                return true;
            }
            case 22: {
                pSSubSysServiceAPIBase.resetCreateDate();
                return true;
            }
            case 23: {
                pSSubSysServiceAPIBase.resetCreateMan();
                return true;
            }
            case 24: {
                pSSubSysServiceAPIBase.resetCustomCode();
                return true;
            }
            case 25: {
                pSSubSysServiceAPIBase.resetCustomMode();
                return true;
            }
            case 26: {
                pSSubSysServiceAPIBase.resetDefCreateReqMethod();
                return true;
            }
            case 27: {
                pSSubSysServiceAPIBase.resetDefDEActionReqMethod();
                return true;
            }
            case 28: {
                pSSubSysServiceAPIBase.resetDefDEDataSetReqMethod();
                return true;
            }
            case 29: {
                pSSubSysServiceAPIBase.resetDefDeleteReqMethod();
                return true;
            }
            case 30: {
                pSSubSysServiceAPIBase.resetDefGetDraftReqMethod();
                return true;
            }
            case 31: {
                pSSubSysServiceAPIBase.resetDefGetReqMethod();
                return true;
            }
            case 32: {
                pSSubSysServiceAPIBase.resetDefNeedResourceKey();
                return true;
            }
            case 33: {
                pSSubSysServiceAPIBase.resetDefSelectReqMethod();
                return true;
            }
            case 34: {
                pSSubSysServiceAPIBase.resetDefUpdateReqMethod();
                return true;
            }
            case 35: {
                pSSubSysServiceAPIBase.resetDEPSSysSFPluginId();
                return true;
            }
            case 36: {
                pSSubSysServiceAPIBase.resetDEPSSysSFPluginName();
                return true;
            }
            case 37: {
                pSSubSysServiceAPIBase.resetEnableAPIModelEx();
                return true;
            }
            case 38: {
                pSSubSysServiceAPIBase.resetFromDEModelFlag();
                return true;
            }
            case 39: {
                pSSubSysServiceAPIBase.resetHeaderParams();
                return true;
            }
            case 40: {
                pSSubSysServiceAPIBase.resetLockFlag();
                return true;
            }
            case 41: {
                pSSubSysServiceAPIBase.resetMemo();
                return true;
            }
            case 42: {
                pSSubSysServiceAPIBase.resetMethodCode();
                return true;
            }
            case 43: {
                pSSubSysServiceAPIBase.resetOrderValue();
                return true;
            }
            case 44: {
                pSSubSysServiceAPIBase.resetPredefinedType();
                return true;
            }
            case 45: {
                pSSubSysServiceAPIBase.resetPSDevSlnSysAPIId();
                return true;
            }
            case 46: {
                pSSubSysServiceAPIBase.resetPSDevSlnSysAPIName();
                return true;
            }
            case 47: {
                pSSubSysServiceAPIBase.resetPSModuleId();
                return true;
            }
            case 48: {
                pSSubSysServiceAPIBase.resetPSModuleName();
                return true;
            }
            case 49: {
                pSSubSysServiceAPIBase.resetPSSubSysServiceAPIId();
                return true;
            }
            case 50: {
                pSSubSysServiceAPIBase.resetPSSubSysServiceAPIName();
                return true;
            }
            case 51: {
                pSSubSysServiceAPIBase.resetPSSysDynaModelId();
                return true;
            }
            case 52: {
                pSSubSysServiceAPIBase.resetPSSysDynaModelName();
                return true;
            }
            case 53: {
                pSSubSysServiceAPIBase.resetPSSysEAISchemeId();
                return true;
            }
            case 54: {
                pSSubSysServiceAPIBase.resetPSSysEAISchemeName();
                return true;
            }
            case 55: {
                pSSubSysServiceAPIBase.resetPSSysReqItemId();
                return true;
            }
            case 56: {
                pSSubSysServiceAPIBase.resetPSSysReqItemName();
                return true;
            }
            case 57: {
                pSSubSysServiceAPIBase.resetPSSysResourceId();
                return true;
            }
            case 58: {
                pSSubSysServiceAPIBase.resetPSSysResourceName();
                return true;
            }
            case 59: {
                pSSubSysServiceAPIBase.resetPSSysSAHandlerId();
                return true;
            }
            case 60: {
                pSSubSysServiceAPIBase.resetPSSysSAHandlerName();
                return true;
            }
            case 61: {
                pSSubSysServiceAPIBase.resetPSSysServiceAPIId();
                return true;
            }
            case 62: {
                pSSubSysServiceAPIBase.resetPSSysServiceAPIName();
                return true;
            }
            case 63: {
                pSSubSysServiceAPIBase.resetPSSysSFPluginId();
                return true;
            }
            case 64: {
                pSSubSysServiceAPIBase.resetPSSysSFPluginName();
                return true;
            }
            case 65: {
                pSSubSysServiceAPIBase.resetPSSystemId();
                return true;
            }
            case 66: {
                pSSubSysServiceAPIBase.resetPSSystemName();
                return true;
            }
            case 67: {
                pSSubSysServiceAPIBase.resetResetDefActionCodeName();
                return true;
            }
            case 68: {
                pSSubSysServiceAPIBase.resetScriptEngine();
                return true;
            }
            case 69: {
                pSSubSysServiceAPIBase.resetServiceCodeName();
                return true;
            }
            case 70: {
                pSSubSysServiceAPIBase.resetServiceDTOFlag();
                return true;
            }
            case 71: {
                pSSubSysServiceAPIBase.resetServiceParam();
                return true;
            }
            case 72: {
                pSSubSysServiceAPIBase.resetServiceParam2();
                return true;
            }
            case 73: {
                pSSubSysServiceAPIBase.resetServiceParam3();
                return true;
            }
            case 74: {
                pSSubSysServiceAPIBase.resetServiceParam4();
                return true;
            }
            case 75: {
                pSSubSysServiceAPIBase.resetServiceParams();
                return true;
            }
            case 76: {
                pSSubSysServiceAPIBase.resetServicePath();
                return true;
            }
            case 77: {
                pSSubSysServiceAPIBase.resetServiceType();
                return true;
            }
            case 78: {
                pSSubSysServiceAPIBase.resetUpdateDate();
                return true;
            }
            case 79: {
                pSSubSysServiceAPIBase.resetUpdateMan();
                return true;
            }
            case 80: {
                pSSubSysServiceAPIBase.resetUserCat();
                return true;
            }
            case 81: {
                pSSubSysServiceAPIBase.resetUserTag();
                return true;
            }
            case 82: {
                pSSubSysServiceAPIBase.resetUserTag2();
                return true;
            }
            case 83: {
                pSSubSysServiceAPIBase.resetUserTag3();
                return true;
            }
            case 84: {
                pSSubSysServiceAPIBase.resetUserTag4();
                return true;
            }
            case 85: {
                pSSubSysServiceAPIBase.resetValidFlag();
                return true;
            }
            case 86: {
                pSSubSysServiceAPIBase.resetVer();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnSysAPI getPSDevSlnSysAPI() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysAPI();
        }
        if (this.getPSDevSlnSysAPIId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnSysAPILock;
        synchronized (n) {
            if (this.psdevslnsysapi != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnSysAPIId(), (Object)this.psdevslnsysapi.getPSDevSlnSysAPIId()) != 0L) {
                this.psdevslnsysapi = null;
            }
            if (this.psdevslnsysapi == null) {
                PSDevSlnSysAPI pSDevSlnSysAPI = new PSDevSlnSysAPI();
                pSDevSlnSysAPI.setPSDevSlnSysAPIId(this.getPSDevSlnSysAPIId());
                PSDevSlnSysAPIService pSDevSlnSysAPIService = (PSDevSlnSysAPIService)ServiceGlobal.getService(PSDevSlnSysAPIService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysAPIService.autoGet(pSDevSlnSysAPI);
                this.psdevslnsysapi = pSDevSlnSysAPI;
            }
            return this.psdevslnsysapi;
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
    public PSSysEAIScheme getPSSysEAIScheme() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAIScheme();
        }
        if (this.getPSSysEAISchemeId() == null) {
            return null;
        }
        Integer n = this.objPSSysEAISchemeLock;
        synchronized (n) {
            if (this.pssyseaischeme != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysEAISchemeId(), (Object)this.pssyseaischeme.getPSSysEAISchemeId()) != 0L) {
                this.pssyseaischeme = null;
            }
            if (this.pssyseaischeme == null) {
                PSSysEAIScheme pSSysEAIScheme = new PSSysEAIScheme();
                pSSysEAIScheme.setPSSysEAISchemeId(this.getPSSysEAISchemeId());
                PSSysEAISchemeService pSSysEAISchemeService = (PSSysEAISchemeService)ServiceGlobal.getService(PSSysEAISchemeService.class, (SessionFactory)this.getSessionFactory());
                pSSysEAISchemeService.autoGet(pSSysEAIScheme);
                this.pssyseaischeme = pSSysEAIScheme;
            }
            return this.pssyseaischeme;
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
                pSSysResourceService.autoGet(pSSysResource);
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
                pSSysSAHandlerService.autoGet(pSSysSAHandler);
                this.pssyssahandler = pSSysSAHandler;
            }
            return this.pssyssahandler;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysServiceAPI getPSSysServiceAPI() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysServiceAPI();
        }
        if (this.getPSSysServiceAPIId() == null) {
            return null;
        }
        Integer n = this.objPSSysServiceAPILock;
        synchronized (n) {
            if (this.pssysserviceapi != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysServiceAPIId(), (Object)this.pssysserviceapi.getPSSysServiceAPIId()) != 0L) {
                this.pssysserviceapi = null;
            }
            if (this.pssysserviceapi == null) {
                PSSysServiceAPI pSSysServiceAPI = new PSSysServiceAPI();
                pSSysServiceAPI.setPSSysServiceAPIId(this.getPSSysServiceAPIId());
                PSSysServiceAPIService pSSysServiceAPIService = (PSSysServiceAPIService)ServiceGlobal.getService(PSSysServiceAPIService.class, (SessionFactory)this.getSessionFactory());
                pSSysServiceAPIService.autoGet(pSSysServiceAPI);
                this.pssysserviceapi = pSSysServiceAPI;
            }
            return this.pssysserviceapi;
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
                pSSysSFPluginService.autoGet(pSSysSFPlugin);
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
    public ArrayList<PSDataEntity> getPSDataEntities() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDataEntities();
        }
        if (this.getPSSubSysServiceAPIId() == null) {
            return null;
        }
        PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDataEntitiesLock;
        synchronized (n) {
            if (this.psdataentities == null) {
                this.psdataentities = pSDataEntityService.selectByPSSubSysServiceAPI(this);
            }
            return this.psdataentities;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSubSysSADERS> getPSSubSysSADERSs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysSADERSs();
        }
        if (this.getPSSubSysServiceAPIId() == null) {
            return null;
        }
        PSSubSysSADERSService pSSubSysSADERSService = (PSSubSysSADERSService)ServiceGlobal.getService(PSSubSysSADERSService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSubSysSADERSsLock;
        synchronized (n) {
            if (this.pssubsyssaderss == null) {
                this.pssubsyssaderss = pSSubSysSADERSService.selectByPSSubSysServiceAPI(this);
            }
            return this.pssubsyssaderss;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSubSysSADetail> getPSSubSysSADetails() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysSADetails();
        }
        if (this.getPSSubSysServiceAPIId() == null) {
            return null;
        }
        PSSubSysSADetailService pSSubSysSADetailService = (PSSubSysSADetailService)ServiceGlobal.getService(PSSubSysSADetailService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSubSysSADetailsLock;
        synchronized (n) {
            if (this.pssubsyssadetails == null) {
                this.pssubsyssadetails = pSSubSysSADetailService.selectByPSSubSysServiceAPI(this);
            }
            return this.pssubsyssadetails;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSubSysSADE> getPSSubSysSADEs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysSADEs();
        }
        if (this.getPSSubSysServiceAPIId() == null) {
            return null;
        }
        PSSubSysSADEService pSSubSysSADEService = (PSSubSysSADEService)ServiceGlobal.getService(PSSubSysSADEService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSubSysSADEsLock;
        synchronized (n) {
            if (this.pssubsyssades == null) {
                this.pssubsyssades = pSSubSysSADEService.selectByPSSubSysServiceAPI(this);
            }
            return this.pssubsyssades;
        }
    }

    private PSSubSysServiceAPIBase getProxyEntity() {
        return this.proxyPSSubSysServiceAPIBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSubSysServiceAPIBase = null;
        if (iDataObject != null && iDataObject instanceof PSSubSysServiceAPIBase) {
            this.proxyPSSubSysServiceAPIBase = (PSSubSysServiceAPIBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSubSysServiceAPIService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ADDDEMODE, 0);
        fieldIndexMap.put(FIELD_ADDDEPARAMS, 1);
        fieldIndexMap.put(FIELD_ADDDEPREFIX, 2);
        fieldIndexMap.put(FIELD_APISOURCE, 3);
        fieldIndexMap.put(FIELD_APITAG, 4);
        fieldIndexMap.put(FIELD_APITAG2, 5);
        fieldIndexMap.put(FIELD_APITYPE, 6);
        fieldIndexMap.put(FIELD_AUTHACCESSTOKENURI, 7);
        fieldIndexMap.put(FIELD_AUTHCLIENTID, 8);
        fieldIndexMap.put(FIELD_AUTHCLIENTSECRET, 9);
        fieldIndexMap.put(FIELD_AUTHCODE, 10);
        fieldIndexMap.put(FIELD_AUTHMODE, 11);
        fieldIndexMap.put(FIELD_AUTHPARAM, 12);
        fieldIndexMap.put(FIELD_AUTHPARAM2, 13);
        fieldIndexMap.put(FIELD_AUTHPARAM3, 14);
        fieldIndexMap.put(FIELD_AUTHPARAM4, 15);
        fieldIndexMap.put(FIELD_AUTHTIMEOUT, 16);
        fieldIndexMap.put(FIELD_BASECLSPARAMS, 17);
        fieldIndexMap.put(FIELD_CFGPSMODELSTORAGEID, 18);
        fieldIndexMap.put(FIELD_CFGTAG, 19);
        fieldIndexMap.put(FIELD_CODENAME, 20);
        fieldIndexMap.put(FIELD_CODENAMEMODE, 21);
        fieldIndexMap.put(FIELD_CREATEDATE, 22);
        fieldIndexMap.put(FIELD_CREATEMAN, 23);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 24);
        fieldIndexMap.put(FIELD_CUSTOMMODE, 25);
        fieldIndexMap.put(FIELD_DEFCREATEREQMETHOD, 26);
        fieldIndexMap.put(FIELD_DEFDEACTIONREQMETHOD, 27);
        fieldIndexMap.put(FIELD_DEFDEDATASETREQMETHOD, 28);
        fieldIndexMap.put(FIELD_DEFDELETEREQMETHOD, 29);
        fieldIndexMap.put(FIELD_DEFGETDRAFTREQMETHOD, 30);
        fieldIndexMap.put(FIELD_DEFGETREQMETHOD, 31);
        fieldIndexMap.put(FIELD_DEFNEEDRESOURCEKEY, 32);
        fieldIndexMap.put(FIELD_DEFSELECTREQMETHOD, 33);
        fieldIndexMap.put(FIELD_DEFUPDATEREQMETHOD, 34);
        fieldIndexMap.put(FIELD_DEPSSYSSFPLUGINID, 35);
        fieldIndexMap.put(FIELD_DEPSSYSSFPLUGINNAME, 36);
        fieldIndexMap.put(FIELD_ENABLEAPIMODELEX, 37);
        fieldIndexMap.put(FIELD_FROMDEMODELFLAG, 38);
        fieldIndexMap.put(FIELD_HEADERPARAMS, 39);
        fieldIndexMap.put(FIELD_LOCKFLAG, 40);
        fieldIndexMap.put(FIELD_MEMO, 41);
        fieldIndexMap.put(FIELD_METHODCODE, 42);
        fieldIndexMap.put(FIELD_ORDERVALUE, 43);
        fieldIndexMap.put(FIELD_PREDEFINEDTYPE, 44);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSAPIID, 45);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSAPINAME, 46);
        fieldIndexMap.put(FIELD_PSMODULEID, 47);
        fieldIndexMap.put(FIELD_PSMODULENAME, 48);
        fieldIndexMap.put(FIELD_PSSUBSYSSERVICEAPIID, 49);
        fieldIndexMap.put(FIELD_PSSUBSYSSERVICEAPINAME, 50);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 51);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 52);
        fieldIndexMap.put(FIELD_PSSYSEAISCHEMEID, 53);
        fieldIndexMap.put(FIELD_PSSYSEAISCHEMENAME, 54);
        fieldIndexMap.put(FIELD_PSSYSREQITEMID, 55);
        fieldIndexMap.put(FIELD_PSSYSREQITEMNAME, 56);
        fieldIndexMap.put(FIELD_PSSYSRESOURCEID, 57);
        fieldIndexMap.put(FIELD_PSSYSRESOURCENAME, 58);
        fieldIndexMap.put(FIELD_PSSYSSAHANDLERID, 59);
        fieldIndexMap.put(FIELD_PSSYSSAHANDLERNAME, 60);
        fieldIndexMap.put(FIELD_PSSYSSERVICEAPIID, 61);
        fieldIndexMap.put(FIELD_PSSYSSERVICEAPINAME, 62);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 63);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 64);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 65);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 66);
        fieldIndexMap.put(FIELD_RESETDEFACTIONCODENAME, 67);
        fieldIndexMap.put(FIELD_SCRIPTENGINE, 68);
        fieldIndexMap.put(FIELD_SERVICECODENAME, 69);
        fieldIndexMap.put(FIELD_SERVICEDTOFLAG, 70);
        fieldIndexMap.put(FIELD_SERVICEPARAM, 71);
        fieldIndexMap.put(FIELD_SERVICEPARAM2, 72);
        fieldIndexMap.put(FIELD_SERVICEPARAM3, 73);
        fieldIndexMap.put(FIELD_SERVICEPARAM4, 74);
        fieldIndexMap.put(FIELD_SERVICEPARAMS, 75);
        fieldIndexMap.put(FIELD_SERVICEPATH, 76);
        fieldIndexMap.put(FIELD_SERVICETYPE, 77);
        fieldIndexMap.put(FIELD_UPDATEDATE, 78);
        fieldIndexMap.put(FIELD_UPDATEMAN, 79);
        fieldIndexMap.put(FIELD_USERCAT, 80);
        fieldIndexMap.put(FIELD_USERTAG, 81);
        fieldIndexMap.put(FIELD_USERTAG2, 82);
        fieldIndexMap.put(FIELD_USERTAG3, 83);
        fieldIndexMap.put(FIELD_USERTAG4, 84);
        fieldIndexMap.put(FIELD_VALIDFLAG, 85);
        fieldIndexMap.put(FIELD_VER, 86);
    }
}

