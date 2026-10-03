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
import net.ibizsys.pscore.srv.config.entity.PSSysResource;
import net.ibizsys.pscore.srv.config.service.PSSysResourceService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDERGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDataSyncAgent;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysModelGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSDERGroupService;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysServiceAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDataSyncAgentService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysModelGroupService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysUtilDEBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysUtilDEBase.class);
    public static final String FIELD_AUTHACCESSTOKENURI = "AUTHACCESSTOKENURI";
    public static final String FIELD_AUTHCLIENTID = "AUTHCLIENTID";
    public static final String FIELD_AUTHCLIENTSECRET = "AUTHCLIENTSECRET";
    public static final String FIELD_AUTHMODE = "AUTHMODE";
    public static final String FIELD_AUTHPARAM = "AUTHPARAM";
    public static final String FIELD_AUTHPARAM2 = "AUTHPARAM2";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_CUSTOMMODE = "CUSTOMMODE";
    public static final String FIELD_INPSSYSDATASYNCAGENTID = "INPSSYSDATASYNCAGENTID";
    public static final String FIELD_INPSSYSDATASYNCAGENTNAME = "INPSSYSDATASYNCAGENTNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_OUTPSSYSDATASYNCAGENTID = "OUTPSSYSDATASYNCAGENTID";
    public static final String FIELD_OUTPSSYSDATASYNCAGENTNAME = "OUTPSSYSDATASYNCAGENTNAME";
    public static final String FIELD_OUTPSSYSRESOURCEID = "OUTPSSYSRESOURCEID";
    public static final String FIELD_OUTPSSYSRESOURCENAME = "OUTPSSYSRESOURCENAME";
    public static final String FIELD_PSDEGROUPID = "PSDEGROUPID";
    public static final String FIELD_PSDEGROUPNAME = "PSDEGROUPNAME";
    public static final String FIELD_PSDERGROUPID = "PSDERGROUPID";
    public static final String FIELD_PSDERGROUPNAME = "PSDERGROUPNAME";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSUBSYSSERVICEAPIID = "PSSUBSYSSERVICEAPIID";
    public static final String FIELD_PSSUBSYSSERVICEAPINAME = "PSSUBSYSSERVICEAPINAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSMODELGROUPID = "PSSYSMODELGROUPID";
    public static final String FIELD_PSSYSMODELGROUPNAME = "PSSYSMODELGROUPNAME";
    public static final String FIELD_PSSYSRESOURCEID = "PSSYSRESOURCEID";
    public static final String FIELD_PSSYSRESOURCENAME = "PSSYSRESOURCENAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSSYSUTILDEID = "PSSYSUTILDEID";
    public static final String FIELD_PSSYSUTILDENAME = "PSSYSUTILDENAME";
    public static final String FIELD_SERVICEPARAM = "SERVICEPARAM";
    public static final String FIELD_SERVICEPARAM2 = "SERVICEPARAM2";
    public static final String FIELD_SERVICEPATH = "SERVICEPATH";
    public static final String FIELD_UNIQUETAG = "UNIQUETAG";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_UTILOBJ = "UTILOBJ";
    public static final String FIELD_UTILPARAM = "UTILPARAM";
    public static final String FIELD_UTILPARAM10 = "UTILPARAM10";
    public static final String FIELD_UTILPARAM11 = "UTILPARAM11";
    public static final String FIELD_UTILPARAM12 = "UTILPARAM12";
    public static final String FIELD_UTILPARAM2 = "UTILPARAM2";
    public static final String FIELD_UTILPARAM3 = "UTILPARAM3";
    public static final String FIELD_UTILPARAM4 = "UTILPARAM4";
    public static final String FIELD_UTILPARAM5 = "UTILPARAM5";
    public static final String FIELD_UTILPARAM6 = "UTILPARAM6";
    public static final String FIELD_UTILPARAM7 = "UTILPARAM7";
    public static final String FIELD_UTILPARAM8 = "UTILPARAM8";
    public static final String FIELD_UTILPARAM9 = "UTILPARAM9";
    public static final String FIELD_UTILPARAMS = "UTILPARAMS";
    public static final String FIELD_UTILPSDE10ID = "UTILPSDE10ID";
    public static final String FIELD_UTILPSDE10NAME = "UTILPSDE10NAME";
    public static final String FIELD_UTILPSDE11ID = "UTILPSDE11ID";
    public static final String FIELD_UTILPSDE11NAME = "UTILPSDE11NAME";
    public static final String FIELD_UTILPSDE12ID = "UTILPSDE12ID";
    public static final String FIELD_UTILPSDE12NAME = "UTILPSDE12NAME";
    public static final String FIELD_UTILPSDE13ID = "UTILPSDE13ID";
    public static final String FIELD_UTILPSDE13NAME = "UTILPSDE13NAME";
    public static final String FIELD_UTILPSDE14ID = "UTILPSDE14ID";
    public static final String FIELD_UTILPSDE14NAME = "UTILPSDE14NAME";
    public static final String FIELD_UTILPSDE15ID = "UTILPSDE15ID";
    public static final String FIELD_UTILPSDE15NAME = "UTILPSDE15NAME";
    public static final String FIELD_UTILPSDE16ID = "UTILPSDE16ID";
    public static final String FIELD_UTILPSDE16NAME = "UTILPSDE16NAME";
    public static final String FIELD_UTILPSDE17ID = "UTILPSDE17ID";
    public static final String FIELD_UTILPSDE17NAME = "UTILPSDE17NAME";
    public static final String FIELD_UTILPSDE18ID = "UTILPSDE18ID";
    public static final String FIELD_UTILPSDE18NAME = "UTILPSDE18NAME";
    public static final String FIELD_UTILPSDE19ID = "UTILPSDE19ID";
    public static final String FIELD_UTILPSDE19NAME = "UTILPSDE19NAME";
    public static final String FIELD_UTILPSDE20ID = "UTILPSDE20ID";
    public static final String FIELD_UTILPSDE20NAME = "UTILPSDE20NAME";
    public static final String FIELD_UTILPSDE2ID = "UTILPSDE2ID";
    public static final String FIELD_UTILPSDE2NAME = "UTILPSDE2NAME";
    public static final String FIELD_UTILPSDE3ID = "UTILPSDE3ID";
    public static final String FIELD_UTILPSDE3NAME = "UTILPSDE3NAME";
    public static final String FIELD_UTILPSDE4ID = "UTILPSDE4ID";
    public static final String FIELD_UTILPSDE4NAME = "UTILPSDE4NAME";
    public static final String FIELD_UTILPSDE5ID = "UTILPSDE5ID";
    public static final String FIELD_UTILPSDE5NAME = "UTILPSDE5NAME";
    public static final String FIELD_UTILPSDE6ID = "UTILPSDE6ID";
    public static final String FIELD_UTILPSDE6NAME = "UTILPSDE6NAME";
    public static final String FIELD_UTILPSDE7ID = "UTILPSDE7ID";
    public static final String FIELD_UTILPSDE7NAME = "UTILPSDE7NAME";
    public static final String FIELD_UTILPSDE8ID = "UTILPSDE8ID";
    public static final String FIELD_UTILPSDE8NAME = "UTILPSDE8NAME";
    public static final String FIELD_UTILPSDE9ID = "UTILPSDE9ID";
    public static final String FIELD_UTILPSDE9NAME = "UTILPSDE9NAME";
    public static final String FIELD_UTILPSDEID = "UTILPSDEID";
    public static final String FIELD_UTILPSDENAME = "UTILPSDENAME";
    public static final String FIELD_UTILTAG = "UTILTAG";
    public static final String FIELD_UTILTAG2 = "UTILTAG2";
    public static final String FIELD_UTILTYPE = "UTILTYPE";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_AUTHACCESSTOKENURI = 0;
    private static final int INDEX_AUTHCLIENTID = 1;
    private static final int INDEX_AUTHCLIENTSECRET = 2;
    private static final int INDEX_AUTHMODE = 3;
    private static final int INDEX_AUTHPARAM = 4;
    private static final int INDEX_AUTHPARAM2 = 5;
    private static final int INDEX_CODENAME = 6;
    private static final int INDEX_CREATEDATE = 7;
    private static final int INDEX_CREATEMAN = 8;
    private static final int INDEX_CUSTOMCODE = 9;
    private static final int INDEX_CUSTOMMODE = 10;
    private static final int INDEX_INPSSYSDATASYNCAGENTID = 11;
    private static final int INDEX_INPSSYSDATASYNCAGENTNAME = 12;
    private static final int INDEX_MEMO = 13;
    private static final int INDEX_ORDERVALUE = 14;
    private static final int INDEX_OUTPSSYSDATASYNCAGENTID = 15;
    private static final int INDEX_OUTPSSYSDATASYNCAGENTNAME = 16;
    private static final int INDEX_OUTPSSYSRESOURCEID = 17;
    private static final int INDEX_OUTPSSYSRESOURCENAME = 18;
    private static final int INDEX_PSDEGROUPID = 19;
    private static final int INDEX_PSDEGROUPNAME = 20;
    private static final int INDEX_PSDERGROUPID = 21;
    private static final int INDEX_PSDERGROUPNAME = 22;
    private static final int INDEX_PSMODULEID = 23;
    private static final int INDEX_PSMODULENAME = 24;
    private static final int INDEX_PSSUBSYSSERVICEAPIID = 25;
    private static final int INDEX_PSSUBSYSSERVICEAPINAME = 26;
    private static final int INDEX_PSSYSDYNAMODELID = 27;
    private static final int INDEX_PSSYSDYNAMODELNAME = 28;
    private static final int INDEX_PSSYSMODELGROUPID = 29;
    private static final int INDEX_PSSYSMODELGROUPNAME = 30;
    private static final int INDEX_PSSYSRESOURCEID = 31;
    private static final int INDEX_PSSYSRESOURCENAME = 32;
    private static final int INDEX_PSSYSSFPLUGINID = 33;
    private static final int INDEX_PSSYSSFPLUGINNAME = 34;
    private static final int INDEX_PSSYSTEMID = 35;
    private static final int INDEX_PSSYSTEMNAME = 36;
    private static final int INDEX_PSSYSUTILDEID = 37;
    private static final int INDEX_PSSYSUTILDENAME = 38;
    private static final int INDEX_SERVICEPARAM = 39;
    private static final int INDEX_SERVICEPARAM2 = 40;
    private static final int INDEX_SERVICEPATH = 41;
    private static final int INDEX_UNIQUETAG = 42;
    private static final int INDEX_UPDATEDATE = 43;
    private static final int INDEX_UPDATEMAN = 44;
    private static final int INDEX_USERCAT = 45;
    private static final int INDEX_USERTAG = 46;
    private static final int INDEX_USERTAG2 = 47;
    private static final int INDEX_USERTAG3 = 48;
    private static final int INDEX_USERTAG4 = 49;
    private static final int INDEX_UTILOBJ = 50;
    private static final int INDEX_UTILPARAM = 51;
    private static final int INDEX_UTILPARAM10 = 52;
    private static final int INDEX_UTILPARAM11 = 53;
    private static final int INDEX_UTILPARAM12 = 54;
    private static final int INDEX_UTILPARAM2 = 55;
    private static final int INDEX_UTILPARAM3 = 56;
    private static final int INDEX_UTILPARAM4 = 57;
    private static final int INDEX_UTILPARAM5 = 58;
    private static final int INDEX_UTILPARAM6 = 59;
    private static final int INDEX_UTILPARAM7 = 60;
    private static final int INDEX_UTILPARAM8 = 61;
    private static final int INDEX_UTILPARAM9 = 62;
    private static final int INDEX_UTILPARAMS = 63;
    private static final int INDEX_UTILPSDE10ID = 64;
    private static final int INDEX_UTILPSDE10NAME = 65;
    private static final int INDEX_UTILPSDE11ID = 66;
    private static final int INDEX_UTILPSDE11NAME = 67;
    private static final int INDEX_UTILPSDE12ID = 68;
    private static final int INDEX_UTILPSDE12NAME = 69;
    private static final int INDEX_UTILPSDE13ID = 70;
    private static final int INDEX_UTILPSDE13NAME = 71;
    private static final int INDEX_UTILPSDE14ID = 72;
    private static final int INDEX_UTILPSDE14NAME = 73;
    private static final int INDEX_UTILPSDE15ID = 74;
    private static final int INDEX_UTILPSDE15NAME = 75;
    private static final int INDEX_UTILPSDE16ID = 76;
    private static final int INDEX_UTILPSDE16NAME = 77;
    private static final int INDEX_UTILPSDE17ID = 78;
    private static final int INDEX_UTILPSDE17NAME = 79;
    private static final int INDEX_UTILPSDE18ID = 80;
    private static final int INDEX_UTILPSDE18NAME = 81;
    private static final int INDEX_UTILPSDE19ID = 82;
    private static final int INDEX_UTILPSDE19NAME = 83;
    private static final int INDEX_UTILPSDE20ID = 84;
    private static final int INDEX_UTILPSDE20NAME = 85;
    private static final int INDEX_UTILPSDE2ID = 86;
    private static final int INDEX_UTILPSDE2NAME = 87;
    private static final int INDEX_UTILPSDE3ID = 88;
    private static final int INDEX_UTILPSDE3NAME = 89;
    private static final int INDEX_UTILPSDE4ID = 90;
    private static final int INDEX_UTILPSDE4NAME = 91;
    private static final int INDEX_UTILPSDE5ID = 92;
    private static final int INDEX_UTILPSDE5NAME = 93;
    private static final int INDEX_UTILPSDE6ID = 94;
    private static final int INDEX_UTILPSDE6NAME = 95;
    private static final int INDEX_UTILPSDE7ID = 96;
    private static final int INDEX_UTILPSDE7NAME = 97;
    private static final int INDEX_UTILPSDE8ID = 98;
    private static final int INDEX_UTILPSDE8NAME = 99;
    private static final int INDEX_UTILPSDE9ID = 100;
    private static final int INDEX_UTILPSDE9NAME = 101;
    private static final int INDEX_UTILPSDEID = 102;
    private static final int INDEX_UTILPSDENAME = 103;
    private static final int INDEX_UTILTAG = 104;
    private static final int INDEX_UTILTAG2 = 105;
    private static final int INDEX_UTILTYPE = 106;
    private static final int INDEX_VALIDFLAG = 107;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysUtilDEBase proxyPSSysUtilDEBase = null;
    private boolean authaccesstokenuriDirtyFlag = false;
    private boolean authclientidDirtyFlag = false;
    private boolean authclientsecretDirtyFlag = false;
    private boolean authmodeDirtyFlag = false;
    private boolean authparamDirtyFlag = false;
    private boolean authparam2DirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean custommodeDirtyFlag = false;
    private boolean inpssysdatasyncagentidDirtyFlag = false;
    private boolean inpssysdatasyncagentnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean outpssysdatasyncagentidDirtyFlag = false;
    private boolean outpssysdatasyncagentnameDirtyFlag = false;
    private boolean outpssysresourceidDirtyFlag = false;
    private boolean outpssysresourcenameDirtyFlag = false;
    private boolean psdegroupidDirtyFlag = false;
    private boolean psdegroupnameDirtyFlag = false;
    private boolean psdergroupidDirtyFlag = false;
    private boolean psdergroupnameDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssubsysserviceapiidDirtyFlag = false;
    private boolean pssubsysserviceapinameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssysmodelgroupidDirtyFlag = false;
    private boolean pssysmodelgroupnameDirtyFlag = false;
    private boolean pssysresourceidDirtyFlag = false;
    private boolean pssysresourcenameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean pssysutildeidDirtyFlag = false;
    private boolean pssysutildenameDirtyFlag = false;
    private boolean serviceparamDirtyFlag = false;
    private boolean serviceparam2DirtyFlag = false;
    private boolean servicepathDirtyFlag = false;
    private boolean uniquetagDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean utilobjDirtyFlag = false;
    private boolean utilparamDirtyFlag = false;
    private boolean utilparam10DirtyFlag = false;
    private boolean utilparam11DirtyFlag = false;
    private boolean utilparam12DirtyFlag = false;
    private boolean utilparam2DirtyFlag = false;
    private boolean utilparam3DirtyFlag = false;
    private boolean utilparam4DirtyFlag = false;
    private boolean utilparam5DirtyFlag = false;
    private boolean utilparam6DirtyFlag = false;
    private boolean utilparam7DirtyFlag = false;
    private boolean utilparam8DirtyFlag = false;
    private boolean utilparam9DirtyFlag = false;
    private boolean utilparamsDirtyFlag = false;
    private boolean utilpsde10idDirtyFlag = false;
    private boolean utilpsde10nameDirtyFlag = false;
    private boolean utilpsde11idDirtyFlag = false;
    private boolean utilpsde11nameDirtyFlag = false;
    private boolean utilpsde12idDirtyFlag = false;
    private boolean utilpsde12nameDirtyFlag = false;
    private boolean utilpsde13idDirtyFlag = false;
    private boolean utilpsde13nameDirtyFlag = false;
    private boolean utilpsde14idDirtyFlag = false;
    private boolean utilpsde14nameDirtyFlag = false;
    private boolean utilpsde15idDirtyFlag = false;
    private boolean utilpsde15nameDirtyFlag = false;
    private boolean utilpsde16idDirtyFlag = false;
    private boolean utilpsde16nameDirtyFlag = false;
    private boolean utilpsde17idDirtyFlag = false;
    private boolean utilpsde17nameDirtyFlag = false;
    private boolean utilpsde18idDirtyFlag = false;
    private boolean utilpsde18nameDirtyFlag = false;
    private boolean utilpsde19idDirtyFlag = false;
    private boolean utilpsde19nameDirtyFlag = false;
    private boolean utilpsde20idDirtyFlag = false;
    private boolean utilpsde20nameDirtyFlag = false;
    private boolean utilpsde2idDirtyFlag = false;
    private boolean utilpsde2nameDirtyFlag = false;
    private boolean utilpsde3idDirtyFlag = false;
    private boolean utilpsde3nameDirtyFlag = false;
    private boolean utilpsde4idDirtyFlag = false;
    private boolean utilpsde4nameDirtyFlag = false;
    private boolean utilpsde5idDirtyFlag = false;
    private boolean utilpsde5nameDirtyFlag = false;
    private boolean utilpsde6idDirtyFlag = false;
    private boolean utilpsde6nameDirtyFlag = false;
    private boolean utilpsde7idDirtyFlag = false;
    private boolean utilpsde7nameDirtyFlag = false;
    private boolean utilpsde8idDirtyFlag = false;
    private boolean utilpsde8nameDirtyFlag = false;
    private boolean utilpsde9idDirtyFlag = false;
    private boolean utilpsde9nameDirtyFlag = false;
    private boolean utilpsdeidDirtyFlag = false;
    private boolean utilpsdenameDirtyFlag = false;
    private boolean utiltagDirtyFlag = false;
    private boolean utiltag2DirtyFlag = false;
    private boolean utiltypeDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="authaccesstokenuri")
    private String authaccesstokenuri;
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
    @Column(name="inpssysdatasyncagentid")
    private String inpssysdatasyncagentid;
    @Column(name="inpssysdatasyncagentname")
    private String inpssysdatasyncagentname;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="outpssysdatasyncagentid")
    private String outpssysdatasyncagentid;
    @Column(name="outpssysdatasyncagentname")
    private String outpssysdatasyncagentname;
    @Column(name="outpssysresourceid")
    private String outpssysresourceid;
    @Column(name="outpssysresourcename")
    private String outpssysresourcename;
    @Column(name="psdegroupid")
    private String psdegroupid;
    @Column(name="psdegroupname")
    private String psdegroupname;
    @Column(name="psdergroupid")
    private String psdergroupid;
    @Column(name="psdergroupname")
    private String psdergroupname;
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
    @Column(name="pssysmodelgroupid")
    private String pssysmodelgroupid;
    @Column(name="pssysmodelgroupname")
    private String pssysmodelgroupname;
    @Column(name="pssysresourceid")
    private String pssysresourceid;
    @Column(name="pssysresourcename")
    private String pssysresourcename;
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="pssysutildeid")
    private String pssysutildeid;
    @Column(name="pssysutildename")
    private String pssysutildename;
    @Column(name="serviceparam")
    private String serviceparam;
    @Column(name="serviceparam2")
    private String serviceparam2;
    @Column(name="servicepath")
    private String servicepath;
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
    @Column(name="utilobj")
    private String utilobj;
    @Column(name="utilparam")
    private String utilparam;
    @Column(name="utilparam10")
    private Integer utilparam10;
    @Column(name="utilparam11")
    private String utilparam11;
    @Column(name="utilparam12")
    private String utilparam12;
    @Column(name="utilparam2")
    private String utilparam2;
    @Column(name="utilparam3")
    private String utilparam3;
    @Column(name="utilparam4")
    private String utilparam4;
    @Column(name="utilparam5")
    private Integer utilparam5;
    @Column(name="utilparam6")
    private Integer utilparam6;
    @Column(name="utilparam7")
    private Integer utilparam7;
    @Column(name="utilparam8")
    private Integer utilparam8;
    @Column(name="utilparam9")
    private Integer utilparam9;
    @Column(name="utilparams")
    private String utilparams;
    @Column(name="utilpsde10id")
    private String utilpsde10id;
    @Column(name="utilpsde10name")
    private String utilpsde10name;
    @Column(name="utilpsde11id")
    private String utilpsde11id;
    @Column(name="utilpsde11name")
    private String utilpsde11name;
    @Column(name="utilpsde12id")
    private String utilpsde12id;
    @Column(name="utilpsde12name")
    private String utilpsde12name;
    @Column(name="utilpsde13id")
    private String utilpsde13id;
    @Column(name="utilpsde13name")
    private String utilpsde13name;
    @Column(name="utilpsde14id")
    private String utilpsde14id;
    @Column(name="utilpsde14name")
    private String utilpsde14name;
    @Column(name="utilpsde15id")
    private String utilpsde15id;
    @Column(name="utilpsde15name")
    private String utilpsde15name;
    @Column(name="utilpsde16id")
    private String utilpsde16id;
    @Column(name="utilpsde16name")
    private String utilpsde16name;
    @Column(name="utilpsde17id")
    private String utilpsde17id;
    @Column(name="utilpsde17name")
    private String utilpsde17name;
    @Column(name="utilpsde18id")
    private String utilpsde18id;
    @Column(name="utilpsde18name")
    private String utilpsde18name;
    @Column(name="utilpsde19id")
    private String utilpsde19id;
    @Column(name="utilpsde19name")
    private String utilpsde19name;
    @Column(name="utilpsde20id")
    private String utilpsde20id;
    @Column(name="utilpsde20name")
    private String utilpsde20name;
    @Column(name="utilpsde2id")
    private String utilpsde2id;
    @Column(name="utilpsde2name")
    private String utilpsde2name;
    @Column(name="utilpsde3id")
    private String utilpsde3id;
    @Column(name="utilpsde3name")
    private String utilpsde3name;
    @Column(name="utilpsde4id")
    private String utilpsde4id;
    @Column(name="utilpsde4name")
    private String utilpsde4name;
    @Column(name="utilpsde5id")
    private String utilpsde5id;
    @Column(name="utilpsde5name")
    private String utilpsde5name;
    @Column(name="utilpsde6id")
    private String utilpsde6id;
    @Column(name="utilpsde6name")
    private String utilpsde6name;
    @Column(name="utilpsde7id")
    private String utilpsde7id;
    @Column(name="utilpsde7name")
    private String utilpsde7name;
    @Column(name="utilpsde8id")
    private String utilpsde8id;
    @Column(name="utilpsde8name")
    private String utilpsde8name;
    @Column(name="utilpsde9id")
    private String utilpsde9id;
    @Column(name="utilpsde9name")
    private String utilpsde9name;
    @Column(name="utilpsdeid")
    private String utilpsdeid;
    @Column(name="utilpsdename")
    private String utilpsdename;
    @Column(name="utiltag")
    private String utiltag;
    @Column(name="utiltag2")
    private String utiltag2;
    @Column(name="utiltype")
    private String utiltype;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objUtilPSDE10Lock = new Integer(1);
    private PSDataEntity utilpsde10 = null;
    private Integer objUtilPSDE11Lock = new Integer(1);
    private PSDataEntity utilpsde11 = null;
    private Integer objUtilPSDE12Lock = new Integer(1);
    private PSDataEntity utilpsde12 = null;
    private Integer objUtilPSDE13Lock = new Integer(1);
    private PSDataEntity utilpsde13 = null;
    private Integer objUtilPSDE14Lock = new Integer(1);
    private PSDataEntity utilpsde14 = null;
    private Integer objUtilPSDE15Lock = new Integer(1);
    private PSDataEntity utilpsde15 = null;
    private Integer objUtilPSDE16Lock = new Integer(1);
    private PSDataEntity utilpsde16 = null;
    private Integer objUtilPSDE17Lock = new Integer(1);
    private PSDataEntity utilpsde17 = null;
    private Integer objUtilPSDE18Lock = new Integer(1);
    private PSDataEntity utilpsde18 = null;
    private Integer objUtilPSDE19Lock = new Integer(1);
    private PSDataEntity utilpsde19 = null;
    private Integer objUtilPSDE20Lock = new Integer(1);
    private PSDataEntity utilpsde20 = null;
    private Integer objUtilPSDE2Lock = new Integer(1);
    private PSDataEntity utilpsde2 = null;
    private Integer objUtilPSDE3Lock = new Integer(1);
    private PSDataEntity utilpsde3 = null;
    private Integer objUtilPSDE4Lock = new Integer(1);
    private PSDataEntity utilpsde4 = null;
    private Integer objUtilPSDE5Lock = new Integer(1);
    private PSDataEntity utilpsde5 = null;
    private Integer objUtilPSDE6Lock = new Integer(1);
    private PSDataEntity utilpsde6 = null;
    private Integer objUtilPSDE7Lock = new Integer(1);
    private PSDataEntity utilpsde7 = null;
    private Integer objUtilPSDE8Lock = new Integer(1);
    private PSDataEntity utilpsde8 = null;
    private Integer objUtilPSDE9Lock = new Integer(1);
    private PSDataEntity utilpsde9 = null;
    private Integer objUtilPSDELock = new Integer(1);
    private PSDataEntity utilpsde = null;
    private Integer objPSDEGroupLock = new Integer(1);
    private PSDEGroup psdegroup = null;
    private Integer objPSDERGroupLock = new Integer(1);
    private PSDERGroup psdergroup = null;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSubSysServiceAPILock = new Integer(1);
    private PSSubSysServiceAPI pssubsysserviceapi = null;
    private Integer objInPSSysDataSyncAgentLock = new Integer(1);
    private PSSysDataSyncAgent inpssysdatasyncagent = null;
    private Integer objOutPSSysDataSyncAgentLock = new Integer(1);
    private PSSysDataSyncAgent outpssysdatasyncagent = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSysModelGroupLock = new Integer(1);
    private PSSysModelGroup pssysmodelgroup = null;
    private Integer objOutPSSysResourceLock = new Integer(1);
    private PSSysResource outpssysresource = null;
    private Integer objPSSysResourceLock = new Integer(1);
    private PSSysResource pssysresource = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;

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

    public void setInPSSysDataSyncAgentId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInPSSysDataSyncAgentId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.inpssysdatasyncagentid = string;
        this.inpssysdatasyncagentidDirtyFlag = true;
    }

    public String getInPSSysDataSyncAgentId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInPSSysDataSyncAgentId();
        }
        return this.inpssysdatasyncagentid;
    }

    public boolean isInPSSysDataSyncAgentIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInPSSysDataSyncAgentIdDirty();
        }
        return this.inpssysdatasyncagentidDirtyFlag;
    }

    public void resetInPSSysDataSyncAgentId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInPSSysDataSyncAgentId();
            return;
        }
        this.inpssysdatasyncagentidDirtyFlag = false;
        this.inpssysdatasyncagentid = null;
    }

    public void setInPSSysDataSyncAgentName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInPSSysDataSyncAgentName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.inpssysdatasyncagentname = string;
        this.inpssysdatasyncagentnameDirtyFlag = true;
    }

    public String getInPSSysDataSyncAgentName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInPSSysDataSyncAgentName();
        }
        return this.inpssysdatasyncagentname;
    }

    public boolean isInPSSysDataSyncAgentNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInPSSysDataSyncAgentNameDirty();
        }
        return this.inpssysdatasyncagentnameDirtyFlag;
    }

    public void resetInPSSysDataSyncAgentName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInPSSysDataSyncAgentName();
            return;
        }
        this.inpssysdatasyncagentnameDirtyFlag = false;
        this.inpssysdatasyncagentname = null;
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

    public void setOutPSSysDataSyncAgentId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOutPSSysDataSyncAgentId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.outpssysdatasyncagentid = string;
        this.outpssysdatasyncagentidDirtyFlag = true;
    }

    public String getOutPSSysDataSyncAgentId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOutPSSysDataSyncAgentId();
        }
        return this.outpssysdatasyncagentid;
    }

    public boolean isOutPSSysDataSyncAgentIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOutPSSysDataSyncAgentIdDirty();
        }
        return this.outpssysdatasyncagentidDirtyFlag;
    }

    public void resetOutPSSysDataSyncAgentId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOutPSSysDataSyncAgentId();
            return;
        }
        this.outpssysdatasyncagentidDirtyFlag = false;
        this.outpssysdatasyncagentid = null;
    }

    public void setOutPSSysDataSyncAgentName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOutPSSysDataSyncAgentName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.outpssysdatasyncagentname = string;
        this.outpssysdatasyncagentnameDirtyFlag = true;
    }

    public String getOutPSSysDataSyncAgentName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOutPSSysDataSyncAgentName();
        }
        return this.outpssysdatasyncagentname;
    }

    public boolean isOutPSSysDataSyncAgentNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOutPSSysDataSyncAgentNameDirty();
        }
        return this.outpssysdatasyncagentnameDirtyFlag;
    }

    public void resetOutPSSysDataSyncAgentName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOutPSSysDataSyncAgentName();
            return;
        }
        this.outpssysdatasyncagentnameDirtyFlag = false;
        this.outpssysdatasyncagentname = null;
    }

    public void setOutPSSysResourceId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOutPSSysResourceId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.outpssysresourceid = string;
        this.outpssysresourceidDirtyFlag = true;
    }

    public String getOutPSSysResourceId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOutPSSysResourceId();
        }
        return this.outpssysresourceid;
    }

    public boolean isOutPSSysResourceIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOutPSSysResourceIdDirty();
        }
        return this.outpssysresourceidDirtyFlag;
    }

    public void resetOutPSSysResourceId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOutPSSysResourceId();
            return;
        }
        this.outpssysresourceidDirtyFlag = false;
        this.outpssysresourceid = null;
    }

    public void setOutPSSysResourceName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOutPSSysResourceName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.outpssysresourcename = string;
        this.outpssysresourcenameDirtyFlag = true;
    }

    public String getOutPSSysResourceName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOutPSSysResourceName();
        }
        return this.outpssysresourcename;
    }

    public boolean isOutPSSysResourceNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOutPSSysResourceNameDirty();
        }
        return this.outpssysresourcenameDirtyFlag;
    }

    public void resetOutPSSysResourceName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOutPSSysResourceName();
            return;
        }
        this.outpssysresourcenameDirtyFlag = false;
        this.outpssysresourcename = null;
    }

    public void setPSDEGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdegroupid = string;
        this.psdegroupidDirtyFlag = true;
    }

    public String getPSDEGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGroupId();
        }
        return this.psdegroupid;
    }

    public boolean isPSDEGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEGroupIdDirty();
        }
        return this.psdegroupidDirtyFlag;
    }

    public void resetPSDEGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEGroupId();
            return;
        }
        this.psdegroupidDirtyFlag = false;
        this.psdegroupid = null;
    }

    public void setPSDEGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdegroupname = string;
        this.psdegroupnameDirtyFlag = true;
    }

    public String getPSDEGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGroupName();
        }
        return this.psdegroupname;
    }

    public boolean isPSDEGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEGroupNameDirty();
        }
        return this.psdegroupnameDirtyFlag;
    }

    public void resetPSDEGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEGroupName();
            return;
        }
        this.psdegroupnameDirtyFlag = false;
        this.psdegroupname = null;
    }

    public void setPSDERGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDERGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdergroupid = string;
        this.psdergroupidDirtyFlag = true;
    }

    public String getPSDERGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDERGroupId();
        }
        return this.psdergroupid;
    }

    public boolean isPSDERGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDERGroupIdDirty();
        }
        return this.psdergroupidDirtyFlag;
    }

    public void resetPSDERGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDERGroupId();
            return;
        }
        this.psdergroupidDirtyFlag = false;
        this.psdergroupid = null;
    }

    public void setPSDERGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDERGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdergroupname = string;
        this.psdergroupnameDirtyFlag = true;
    }

    public String getPSDERGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDERGroupName();
        }
        return this.psdergroupname;
    }

    public boolean isPSDERGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDERGroupNameDirty();
        }
        return this.psdergroupnameDirtyFlag;
    }

    public void resetPSDERGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDERGroupName();
            return;
        }
        this.psdergroupnameDirtyFlag = false;
        this.psdergroupname = null;
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

    public void setPSSysModelGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelgroupid = string;
        this.pssysmodelgroupidDirtyFlag = true;
    }

    public String getPSSysModelGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelGroupId();
        }
        return this.pssysmodelgroupid;
    }

    public boolean isPSSysModelGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelGroupIdDirty();
        }
        return this.pssysmodelgroupidDirtyFlag;
    }

    public void resetPSSysModelGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelGroupId();
            return;
        }
        this.pssysmodelgroupidDirtyFlag = false;
        this.pssysmodelgroupid = null;
    }

    public void setPSSysModelGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelgroupname = string;
        this.pssysmodelgroupnameDirtyFlag = true;
    }

    public String getPSSysModelGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelGroupName();
        }
        return this.pssysmodelgroupname;
    }

    public boolean isPSSysModelGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelGroupNameDirty();
        }
        return this.pssysmodelgroupnameDirtyFlag;
    }

    public void resetPSSysModelGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelGroupName();
            return;
        }
        this.pssysmodelgroupnameDirtyFlag = false;
        this.pssysmodelgroupname = null;
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

    public void setPSSysUtilDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUtilDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysutildeid = string;
        this.pssysutildeidDirtyFlag = true;
    }

    public String getPSSysUtilDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUtilDEId();
        }
        return this.pssysutildeid;
    }

    public boolean isPSSysUtilDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUtilDEIdDirty();
        }
        return this.pssysutildeidDirtyFlag;
    }

    public void resetPSSysUtilDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUtilDEId();
            return;
        }
        this.pssysutildeidDirtyFlag = false;
        this.pssysutildeid = null;
    }

    public void setPSSysUtilDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUtilDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysutildename = string;
        this.pssysutildenameDirtyFlag = true;
    }

    public String getPSSysUtilDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUtilDEName();
        }
        return this.pssysutildename;
    }

    public boolean isPSSysUtilDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUtilDENameDirty();
        }
        return this.pssysutildenameDirtyFlag;
    }

    public void resetPSSysUtilDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUtilDEName();
            return;
        }
        this.pssysutildenameDirtyFlag = false;
        this.pssysutildename = null;
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

    public void setUtilObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilobj = string;
        this.utilobjDirtyFlag = true;
    }

    public String getUtilObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilObj();
        }
        return this.utilobj;
    }

    public boolean isUtilObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilObjDirty();
        }
        return this.utilobjDirtyFlag;
    }

    public void resetUtilObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilObj();
            return;
        }
        this.utilobjDirtyFlag = false;
        this.utilobj = null;
    }

    public void setUtilParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilparam = string;
        this.utilparamDirtyFlag = true;
    }

    public String getUtilParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilParam();
        }
        return this.utilparam;
    }

    public boolean isUtilParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilParamDirty();
        }
        return this.utilparamDirtyFlag;
    }

    public void resetUtilParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilParam();
            return;
        }
        this.utilparamDirtyFlag = false;
        this.utilparam = null;
    }

    public void setUtilParam10(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilParam10(n);
            return;
        }
        this.utilparam10 = n;
        this.utilparam10DirtyFlag = true;
    }

    public Integer getUtilParam10() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilParam10();
        }
        return this.utilparam10;
    }

    public boolean isUtilParam10Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilParam10Dirty();
        }
        return this.utilparam10DirtyFlag;
    }

    public void resetUtilParam10() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilParam10();
            return;
        }
        this.utilparam10DirtyFlag = false;
        this.utilparam10 = null;
    }

    public void setUtilParam11(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilParam11(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilparam11 = string;
        this.utilparam11DirtyFlag = true;
    }

    public String getUtilParam11() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilParam11();
        }
        return this.utilparam11;
    }

    public boolean isUtilParam11Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilParam11Dirty();
        }
        return this.utilparam11DirtyFlag;
    }

    public void resetUtilParam11() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilParam11();
            return;
        }
        this.utilparam11DirtyFlag = false;
        this.utilparam11 = null;
    }

    public void setUtilParam12(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilParam12(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilparam12 = string;
        this.utilparam12DirtyFlag = true;
    }

    public String getUtilParam12() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilParam12();
        }
        return this.utilparam12;
    }

    public boolean isUtilParam12Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilParam12Dirty();
        }
        return this.utilparam12DirtyFlag;
    }

    public void resetUtilParam12() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilParam12();
            return;
        }
        this.utilparam12DirtyFlag = false;
        this.utilparam12 = null;
    }

    public void setUtilParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilparam2 = string;
        this.utilparam2DirtyFlag = true;
    }

    public String getUtilParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilParam2();
        }
        return this.utilparam2;
    }

    public boolean isUtilParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilParam2Dirty();
        }
        return this.utilparam2DirtyFlag;
    }

    public void resetUtilParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilParam2();
            return;
        }
        this.utilparam2DirtyFlag = false;
        this.utilparam2 = null;
    }

    public void setUtilParam3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilParam3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilparam3 = string;
        this.utilparam3DirtyFlag = true;
    }

    public String getUtilParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilParam3();
        }
        return this.utilparam3;
    }

    public boolean isUtilParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilParam3Dirty();
        }
        return this.utilparam3DirtyFlag;
    }

    public void resetUtilParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilParam3();
            return;
        }
        this.utilparam3DirtyFlag = false;
        this.utilparam3 = null;
    }

    public void setUtilParam4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilParam4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilparam4 = string;
        this.utilparam4DirtyFlag = true;
    }

    public String getUtilParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilParam4();
        }
        return this.utilparam4;
    }

    public boolean isUtilParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilParam4Dirty();
        }
        return this.utilparam4DirtyFlag;
    }

    public void resetUtilParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilParam4();
            return;
        }
        this.utilparam4DirtyFlag = false;
        this.utilparam4 = null;
    }

    public void setUtilParam5(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilParam5(n);
            return;
        }
        this.utilparam5 = n;
        this.utilparam5DirtyFlag = true;
    }

    public Integer getUtilParam5() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilParam5();
        }
        return this.utilparam5;
    }

    public boolean isUtilParam5Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilParam5Dirty();
        }
        return this.utilparam5DirtyFlag;
    }

    public void resetUtilParam5() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilParam5();
            return;
        }
        this.utilparam5DirtyFlag = false;
        this.utilparam5 = null;
    }

    public void setUtilParam6(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilParam6(n);
            return;
        }
        this.utilparam6 = n;
        this.utilparam6DirtyFlag = true;
    }

    public Integer getUtilParam6() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilParam6();
        }
        return this.utilparam6;
    }

    public boolean isUtilParam6Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilParam6Dirty();
        }
        return this.utilparam6DirtyFlag;
    }

    public void resetUtilParam6() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilParam6();
            return;
        }
        this.utilparam6DirtyFlag = false;
        this.utilparam6 = null;
    }

    public void setUtilParam7(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilParam7(n);
            return;
        }
        this.utilparam7 = n;
        this.utilparam7DirtyFlag = true;
    }

    public Integer getUtilParam7() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilParam7();
        }
        return this.utilparam7;
    }

    public boolean isUtilParam7Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilParam7Dirty();
        }
        return this.utilparam7DirtyFlag;
    }

    public void resetUtilParam7() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilParam7();
            return;
        }
        this.utilparam7DirtyFlag = false;
        this.utilparam7 = null;
    }

    public void setUtilParam8(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilParam8(n);
            return;
        }
        this.utilparam8 = n;
        this.utilparam8DirtyFlag = true;
    }

    public Integer getUtilParam8() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilParam8();
        }
        return this.utilparam8;
    }

    public boolean isUtilParam8Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilParam8Dirty();
        }
        return this.utilparam8DirtyFlag;
    }

    public void resetUtilParam8() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilParam8();
            return;
        }
        this.utilparam8DirtyFlag = false;
        this.utilparam8 = null;
    }

    public void setUtilParam9(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilParam9(n);
            return;
        }
        this.utilparam9 = n;
        this.utilparam9DirtyFlag = true;
    }

    public Integer getUtilParam9() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilParam9();
        }
        return this.utilparam9;
    }

    public boolean isUtilParam9Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilParam9Dirty();
        }
        return this.utilparam9DirtyFlag;
    }

    public void resetUtilParam9() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilParam9();
            return;
        }
        this.utilparam9DirtyFlag = false;
        this.utilparam9 = null;
    }

    public void setUtilParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilparams = string;
        this.utilparamsDirtyFlag = true;
    }

    public String getUtilParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilParams();
        }
        return this.utilparams;
    }

    public boolean isUtilParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilParamsDirty();
        }
        return this.utilparamsDirtyFlag;
    }

    public void resetUtilParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilParams();
            return;
        }
        this.utilparamsDirtyFlag = false;
        this.utilparams = null;
    }

    public void setUtilPSDE10Id(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE10Id(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde10id = string;
        this.utilpsde10idDirtyFlag = true;
    }

    public String getUtilPSDE10Id() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE10Id();
        }
        return this.utilpsde10id;
    }

    public boolean isUtilPSDE10IdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE10IdDirty();
        }
        return this.utilpsde10idDirtyFlag;
    }

    public void resetUtilPSDE10Id() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE10Id();
            return;
        }
        this.utilpsde10idDirtyFlag = false;
        this.utilpsde10id = null;
    }

    public void setUtilPSDE10Name(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE10Name(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde10name = string;
        this.utilpsde10nameDirtyFlag = true;
    }

    public String getUtilPSDE10Name() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE10Name();
        }
        return this.utilpsde10name;
    }

    public boolean isUtilPSDE10NameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE10NameDirty();
        }
        return this.utilpsde10nameDirtyFlag;
    }

    public void resetUtilPSDE10Name() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE10Name();
            return;
        }
        this.utilpsde10nameDirtyFlag = false;
        this.utilpsde10name = null;
    }

    public void setUtilPSDE11Id(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE11Id(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde11id = string;
        this.utilpsde11idDirtyFlag = true;
    }

    public String getUtilPSDE11Id() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE11Id();
        }
        return this.utilpsde11id;
    }

    public boolean isUtilPSDE11IdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE11IdDirty();
        }
        return this.utilpsde11idDirtyFlag;
    }

    public void resetUtilPSDE11Id() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE11Id();
            return;
        }
        this.utilpsde11idDirtyFlag = false;
        this.utilpsde11id = null;
    }

    public void setUtilPSDE11Name(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE11Name(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde11name = string;
        this.utilpsde11nameDirtyFlag = true;
    }

    public String getUtilPSDE11Name() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE11Name();
        }
        return this.utilpsde11name;
    }

    public boolean isUtilPSDE11NameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE11NameDirty();
        }
        return this.utilpsde11nameDirtyFlag;
    }

    public void resetUtilPSDE11Name() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE11Name();
            return;
        }
        this.utilpsde11nameDirtyFlag = false;
        this.utilpsde11name = null;
    }

    public void setUtilPSDE12Id(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE12Id(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde12id = string;
        this.utilpsde12idDirtyFlag = true;
    }

    public String getUtilPSDE12Id() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE12Id();
        }
        return this.utilpsde12id;
    }

    public boolean isUtilPSDE12IdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE12IdDirty();
        }
        return this.utilpsde12idDirtyFlag;
    }

    public void resetUtilPSDE12Id() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE12Id();
            return;
        }
        this.utilpsde12idDirtyFlag = false;
        this.utilpsde12id = null;
    }

    public void setUtilPSDE12Name(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE12Name(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde12name = string;
        this.utilpsde12nameDirtyFlag = true;
    }

    public String getUtilPSDE12Name() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE12Name();
        }
        return this.utilpsde12name;
    }

    public boolean isUtilPSDE12NameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE12NameDirty();
        }
        return this.utilpsde12nameDirtyFlag;
    }

    public void resetUtilPSDE12Name() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE12Name();
            return;
        }
        this.utilpsde12nameDirtyFlag = false;
        this.utilpsde12name = null;
    }

    public void setUtilPSDE13Id(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE13Id(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde13id = string;
        this.utilpsde13idDirtyFlag = true;
    }

    public String getUtilPSDE13Id() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE13Id();
        }
        return this.utilpsde13id;
    }

    public boolean isUtilPSDE13IdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE13IdDirty();
        }
        return this.utilpsde13idDirtyFlag;
    }

    public void resetUtilPSDE13Id() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE13Id();
            return;
        }
        this.utilpsde13idDirtyFlag = false;
        this.utilpsde13id = null;
    }

    public void setUtilPSDE13Name(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE13Name(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde13name = string;
        this.utilpsde13nameDirtyFlag = true;
    }

    public String getUtilPSDE13Name() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE13Name();
        }
        return this.utilpsde13name;
    }

    public boolean isUtilPSDE13NameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE13NameDirty();
        }
        return this.utilpsde13nameDirtyFlag;
    }

    public void resetUtilPSDE13Name() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE13Name();
            return;
        }
        this.utilpsde13nameDirtyFlag = false;
        this.utilpsde13name = null;
    }

    public void setUtilPSDE14Id(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE14Id(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde14id = string;
        this.utilpsde14idDirtyFlag = true;
    }

    public String getUtilPSDE14Id() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE14Id();
        }
        return this.utilpsde14id;
    }

    public boolean isUtilPSDE14IdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE14IdDirty();
        }
        return this.utilpsde14idDirtyFlag;
    }

    public void resetUtilPSDE14Id() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE14Id();
            return;
        }
        this.utilpsde14idDirtyFlag = false;
        this.utilpsde14id = null;
    }

    public void setUtilPSDE14Name(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE14Name(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde14name = string;
        this.utilpsde14nameDirtyFlag = true;
    }

    public String getUtilPSDE14Name() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE14Name();
        }
        return this.utilpsde14name;
    }

    public boolean isUtilPSDE14NameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE14NameDirty();
        }
        return this.utilpsde14nameDirtyFlag;
    }

    public void resetUtilPSDE14Name() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE14Name();
            return;
        }
        this.utilpsde14nameDirtyFlag = false;
        this.utilpsde14name = null;
    }

    public void setUtilPSDE15Id(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE15Id(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde15id = string;
        this.utilpsde15idDirtyFlag = true;
    }

    public String getUtilPSDE15Id() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE15Id();
        }
        return this.utilpsde15id;
    }

    public boolean isUtilPSDE15IdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE15IdDirty();
        }
        return this.utilpsde15idDirtyFlag;
    }

    public void resetUtilPSDE15Id() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE15Id();
            return;
        }
        this.utilpsde15idDirtyFlag = false;
        this.utilpsde15id = null;
    }

    public void setUtilPSDE15Name(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE15Name(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde15name = string;
        this.utilpsde15nameDirtyFlag = true;
    }

    public String getUtilPSDE15Name() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE15Name();
        }
        return this.utilpsde15name;
    }

    public boolean isUtilPSDE15NameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE15NameDirty();
        }
        return this.utilpsde15nameDirtyFlag;
    }

    public void resetUtilPSDE15Name() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE15Name();
            return;
        }
        this.utilpsde15nameDirtyFlag = false;
        this.utilpsde15name = null;
    }

    public void setUtilPSDE16Id(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE16Id(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde16id = string;
        this.utilpsde16idDirtyFlag = true;
    }

    public String getUtilPSDE16Id() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE16Id();
        }
        return this.utilpsde16id;
    }

    public boolean isUtilPSDE16IdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE16IdDirty();
        }
        return this.utilpsde16idDirtyFlag;
    }

    public void resetUtilPSDE16Id() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE16Id();
            return;
        }
        this.utilpsde16idDirtyFlag = false;
        this.utilpsde16id = null;
    }

    public void setUtilPSDE16Name(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE16Name(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde16name = string;
        this.utilpsde16nameDirtyFlag = true;
    }

    public String getUtilPSDE16Name() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE16Name();
        }
        return this.utilpsde16name;
    }

    public boolean isUtilPSDE16NameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE16NameDirty();
        }
        return this.utilpsde16nameDirtyFlag;
    }

    public void resetUtilPSDE16Name() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE16Name();
            return;
        }
        this.utilpsde16nameDirtyFlag = false;
        this.utilpsde16name = null;
    }

    public void setUtilPSDE17Id(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE17Id(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde17id = string;
        this.utilpsde17idDirtyFlag = true;
    }

    public String getUtilPSDE17Id() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE17Id();
        }
        return this.utilpsde17id;
    }

    public boolean isUtilPSDE17IdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE17IdDirty();
        }
        return this.utilpsde17idDirtyFlag;
    }

    public void resetUtilPSDE17Id() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE17Id();
            return;
        }
        this.utilpsde17idDirtyFlag = false;
        this.utilpsde17id = null;
    }

    public void setUtilPSDE17Name(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE17Name(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde17name = string;
        this.utilpsde17nameDirtyFlag = true;
    }

    public String getUtilPSDE17Name() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE17Name();
        }
        return this.utilpsde17name;
    }

    public boolean isUtilPSDE17NameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE17NameDirty();
        }
        return this.utilpsde17nameDirtyFlag;
    }

    public void resetUtilPSDE17Name() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE17Name();
            return;
        }
        this.utilpsde17nameDirtyFlag = false;
        this.utilpsde17name = null;
    }

    public void setUtilPSDE18Id(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE18Id(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde18id = string;
        this.utilpsde18idDirtyFlag = true;
    }

    public String getUtilPSDE18Id() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE18Id();
        }
        return this.utilpsde18id;
    }

    public boolean isUtilPSDE18IdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE18IdDirty();
        }
        return this.utilpsde18idDirtyFlag;
    }

    public void resetUtilPSDE18Id() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE18Id();
            return;
        }
        this.utilpsde18idDirtyFlag = false;
        this.utilpsde18id = null;
    }

    public void setUtilPSDE18Name(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE18Name(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde18name = string;
        this.utilpsde18nameDirtyFlag = true;
    }

    public String getUtilPSDE18Name() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE18Name();
        }
        return this.utilpsde18name;
    }

    public boolean isUtilPSDE18NameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE18NameDirty();
        }
        return this.utilpsde18nameDirtyFlag;
    }

    public void resetUtilPSDE18Name() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE18Name();
            return;
        }
        this.utilpsde18nameDirtyFlag = false;
        this.utilpsde18name = null;
    }

    public void setUtilPSDE19Id(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE19Id(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde19id = string;
        this.utilpsde19idDirtyFlag = true;
    }

    public String getUtilPSDE19Id() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE19Id();
        }
        return this.utilpsde19id;
    }

    public boolean isUtilPSDE19IdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE19IdDirty();
        }
        return this.utilpsde19idDirtyFlag;
    }

    public void resetUtilPSDE19Id() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE19Id();
            return;
        }
        this.utilpsde19idDirtyFlag = false;
        this.utilpsde19id = null;
    }

    public void setUtilPSDE19Name(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE19Name(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde19name = string;
        this.utilpsde19nameDirtyFlag = true;
    }

    public String getUtilPSDE19Name() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE19Name();
        }
        return this.utilpsde19name;
    }

    public boolean isUtilPSDE19NameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE19NameDirty();
        }
        return this.utilpsde19nameDirtyFlag;
    }

    public void resetUtilPSDE19Name() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE19Name();
            return;
        }
        this.utilpsde19nameDirtyFlag = false;
        this.utilpsde19name = null;
    }

    public void setUtilPSDE20Id(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE20Id(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde20id = string;
        this.utilpsde20idDirtyFlag = true;
    }

    public String getUtilPSDE20Id() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE20Id();
        }
        return this.utilpsde20id;
    }

    public boolean isUtilPSDE20IdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE20IdDirty();
        }
        return this.utilpsde20idDirtyFlag;
    }

    public void resetUtilPSDE20Id() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE20Id();
            return;
        }
        this.utilpsde20idDirtyFlag = false;
        this.utilpsde20id = null;
    }

    public void setUtilPSDE20Name(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE20Name(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde20name = string;
        this.utilpsde20nameDirtyFlag = true;
    }

    public String getUtilPSDE20Name() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE20Name();
        }
        return this.utilpsde20name;
    }

    public boolean isUtilPSDE20NameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE20NameDirty();
        }
        return this.utilpsde20nameDirtyFlag;
    }

    public void resetUtilPSDE20Name() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE20Name();
            return;
        }
        this.utilpsde20nameDirtyFlag = false;
        this.utilpsde20name = null;
    }

    public void setUtilPSDE2Id(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE2Id(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde2id = string;
        this.utilpsde2idDirtyFlag = true;
    }

    public String getUtilPSDE2Id() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE2Id();
        }
        return this.utilpsde2id;
    }

    public boolean isUtilPSDE2IdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE2IdDirty();
        }
        return this.utilpsde2idDirtyFlag;
    }

    public void resetUtilPSDE2Id() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE2Id();
            return;
        }
        this.utilpsde2idDirtyFlag = false;
        this.utilpsde2id = null;
    }

    public void setUtilPSDE2Name(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE2Name(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde2name = string;
        this.utilpsde2nameDirtyFlag = true;
    }

    public String getUtilPSDE2Name() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE2Name();
        }
        return this.utilpsde2name;
    }

    public boolean isUtilPSDE2NameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE2NameDirty();
        }
        return this.utilpsde2nameDirtyFlag;
    }

    public void resetUtilPSDE2Name() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE2Name();
            return;
        }
        this.utilpsde2nameDirtyFlag = false;
        this.utilpsde2name = null;
    }

    public void setUtilPSDE3Id(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE3Id(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde3id = string;
        this.utilpsde3idDirtyFlag = true;
    }

    public String getUtilPSDE3Id() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE3Id();
        }
        return this.utilpsde3id;
    }

    public boolean isUtilPSDE3IdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE3IdDirty();
        }
        return this.utilpsde3idDirtyFlag;
    }

    public void resetUtilPSDE3Id() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE3Id();
            return;
        }
        this.utilpsde3idDirtyFlag = false;
        this.utilpsde3id = null;
    }

    public void setUtilPSDE3Name(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE3Name(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde3name = string;
        this.utilpsde3nameDirtyFlag = true;
    }

    public String getUtilPSDE3Name() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE3Name();
        }
        return this.utilpsde3name;
    }

    public boolean isUtilPSDE3NameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE3NameDirty();
        }
        return this.utilpsde3nameDirtyFlag;
    }

    public void resetUtilPSDE3Name() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE3Name();
            return;
        }
        this.utilpsde3nameDirtyFlag = false;
        this.utilpsde3name = null;
    }

    public void setUtilPSDE4Id(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE4Id(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde4id = string;
        this.utilpsde4idDirtyFlag = true;
    }

    public String getUtilPSDE4Id() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE4Id();
        }
        return this.utilpsde4id;
    }

    public boolean isUtilPSDE4IdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE4IdDirty();
        }
        return this.utilpsde4idDirtyFlag;
    }

    public void resetUtilPSDE4Id() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE4Id();
            return;
        }
        this.utilpsde4idDirtyFlag = false;
        this.utilpsde4id = null;
    }

    public void setUtilPSDE4Name(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE4Name(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde4name = string;
        this.utilpsde4nameDirtyFlag = true;
    }

    public String getUtilPSDE4Name() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE4Name();
        }
        return this.utilpsde4name;
    }

    public boolean isUtilPSDE4NameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE4NameDirty();
        }
        return this.utilpsde4nameDirtyFlag;
    }

    public void resetUtilPSDE4Name() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE4Name();
            return;
        }
        this.utilpsde4nameDirtyFlag = false;
        this.utilpsde4name = null;
    }

    public void setUtilPSDE5Id(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE5Id(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde5id = string;
        this.utilpsde5idDirtyFlag = true;
    }

    public String getUtilPSDE5Id() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE5Id();
        }
        return this.utilpsde5id;
    }

    public boolean isUtilPSDE5IdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE5IdDirty();
        }
        return this.utilpsde5idDirtyFlag;
    }

    public void resetUtilPSDE5Id() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE5Id();
            return;
        }
        this.utilpsde5idDirtyFlag = false;
        this.utilpsde5id = null;
    }

    public void setUtilPSDE5Name(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE5Name(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde5name = string;
        this.utilpsde5nameDirtyFlag = true;
    }

    public String getUtilPSDE5Name() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE5Name();
        }
        return this.utilpsde5name;
    }

    public boolean isUtilPSDE5NameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE5NameDirty();
        }
        return this.utilpsde5nameDirtyFlag;
    }

    public void resetUtilPSDE5Name() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE5Name();
            return;
        }
        this.utilpsde5nameDirtyFlag = false;
        this.utilpsde5name = null;
    }

    public void setUtilPSDE6Id(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE6Id(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde6id = string;
        this.utilpsde6idDirtyFlag = true;
    }

    public String getUtilPSDE6Id() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE6Id();
        }
        return this.utilpsde6id;
    }

    public boolean isUtilPSDE6IdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE6IdDirty();
        }
        return this.utilpsde6idDirtyFlag;
    }

    public void resetUtilPSDE6Id() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE6Id();
            return;
        }
        this.utilpsde6idDirtyFlag = false;
        this.utilpsde6id = null;
    }

    public void setUtilPSDE6Name(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE6Name(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde6name = string;
        this.utilpsde6nameDirtyFlag = true;
    }

    public String getUtilPSDE6Name() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE6Name();
        }
        return this.utilpsde6name;
    }

    public boolean isUtilPSDE6NameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE6NameDirty();
        }
        return this.utilpsde6nameDirtyFlag;
    }

    public void resetUtilPSDE6Name() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE6Name();
            return;
        }
        this.utilpsde6nameDirtyFlag = false;
        this.utilpsde6name = null;
    }

    public void setUtilPSDE7Id(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE7Id(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde7id = string;
        this.utilpsde7idDirtyFlag = true;
    }

    public String getUtilPSDE7Id() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE7Id();
        }
        return this.utilpsde7id;
    }

    public boolean isUtilPSDE7IdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE7IdDirty();
        }
        return this.utilpsde7idDirtyFlag;
    }

    public void resetUtilPSDE7Id() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE7Id();
            return;
        }
        this.utilpsde7idDirtyFlag = false;
        this.utilpsde7id = null;
    }

    public void setUtilPSDE7Name(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE7Name(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde7name = string;
        this.utilpsde7nameDirtyFlag = true;
    }

    public String getUtilPSDE7Name() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE7Name();
        }
        return this.utilpsde7name;
    }

    public boolean isUtilPSDE7NameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE7NameDirty();
        }
        return this.utilpsde7nameDirtyFlag;
    }

    public void resetUtilPSDE7Name() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE7Name();
            return;
        }
        this.utilpsde7nameDirtyFlag = false;
        this.utilpsde7name = null;
    }

    public void setUtilPSDE8Id(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE8Id(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde8id = string;
        this.utilpsde8idDirtyFlag = true;
    }

    public String getUtilPSDE8Id() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE8Id();
        }
        return this.utilpsde8id;
    }

    public boolean isUtilPSDE8IdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE8IdDirty();
        }
        return this.utilpsde8idDirtyFlag;
    }

    public void resetUtilPSDE8Id() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE8Id();
            return;
        }
        this.utilpsde8idDirtyFlag = false;
        this.utilpsde8id = null;
    }

    public void setUtilPSDE8Name(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE8Name(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde8name = string;
        this.utilpsde8nameDirtyFlag = true;
    }

    public String getUtilPSDE8Name() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE8Name();
        }
        return this.utilpsde8name;
    }

    public boolean isUtilPSDE8NameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE8NameDirty();
        }
        return this.utilpsde8nameDirtyFlag;
    }

    public void resetUtilPSDE8Name() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE8Name();
            return;
        }
        this.utilpsde8nameDirtyFlag = false;
        this.utilpsde8name = null;
    }

    public void setUtilPSDE9Id(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE9Id(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde9id = string;
        this.utilpsde9idDirtyFlag = true;
    }

    public String getUtilPSDE9Id() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE9Id();
        }
        return this.utilpsde9id;
    }

    public boolean isUtilPSDE9IdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE9IdDirty();
        }
        return this.utilpsde9idDirtyFlag;
    }

    public void resetUtilPSDE9Id() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE9Id();
            return;
        }
        this.utilpsde9idDirtyFlag = false;
        this.utilpsde9id = null;
    }

    public void setUtilPSDE9Name(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE9Name(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde9name = string;
        this.utilpsde9nameDirtyFlag = true;
    }

    public String getUtilPSDE9Name() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE9Name();
        }
        return this.utilpsde9name;
    }

    public boolean isUtilPSDE9NameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE9NameDirty();
        }
        return this.utilpsde9nameDirtyFlag;
    }

    public void resetUtilPSDE9Name() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE9Name();
            return;
        }
        this.utilpsde9nameDirtyFlag = false;
        this.utilpsde9name = null;
    }

    public void setUtilPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsdeid = string;
        this.utilpsdeidDirtyFlag = true;
    }

    public String getUtilPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDEId();
        }
        return this.utilpsdeid;
    }

    public boolean isUtilPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDEIdDirty();
        }
        return this.utilpsdeidDirtyFlag;
    }

    public void resetUtilPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDEId();
            return;
        }
        this.utilpsdeidDirtyFlag = false;
        this.utilpsdeid = null;
    }

    public void setUtilPSDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsdename = string;
        this.utilpsdenameDirtyFlag = true;
    }

    public String getUtilPSDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDEName();
        }
        return this.utilpsdename;
    }

    public boolean isUtilPSDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDENameDirty();
        }
        return this.utilpsdenameDirtyFlag;
    }

    public void resetUtilPSDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDEName();
            return;
        }
        this.utilpsdenameDirtyFlag = false;
        this.utilpsdename = null;
    }

    public void setUtilTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        if (string != null) {
            string = string.toUpperCase();
        }
        this.utiltag = string;
        this.utiltagDirtyFlag = true;
    }

    public String getUtilTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilTag();
        }
        return this.utiltag;
    }

    public boolean isUtilTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilTagDirty();
        }
        return this.utiltagDirtyFlag;
    }

    public void resetUtilTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilTag();
            return;
        }
        this.utiltagDirtyFlag = false;
        this.utiltag = null;
    }

    public void setUtilTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utiltag2 = string;
        this.utiltag2DirtyFlag = true;
    }

    public String getUtilTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilTag2();
        }
        return this.utiltag2;
    }

    public boolean isUtilTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilTag2Dirty();
        }
        return this.utiltag2DirtyFlag;
    }

    public void resetUtilTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilTag2();
            return;
        }
        this.utiltag2DirtyFlag = false;
        this.utiltag2 = null;
    }

    public void setUtilType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utiltype = string;
        this.utiltypeDirtyFlag = true;
    }

    public String getUtilType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilType();
        }
        return this.utiltype;
    }

    public boolean isUtilTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilTypeDirty();
        }
        return this.utiltypeDirtyFlag;
    }

    public void resetUtilType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilType();
            return;
        }
        this.utiltypeDirtyFlag = false;
        this.utiltype = null;
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
        PSSysUtilDEBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysUtilDEBase pSSysUtilDEBase) {
        pSSysUtilDEBase.resetAuthAccessTokenUri();
        pSSysUtilDEBase.resetAuthClientId();
        pSSysUtilDEBase.resetAuthClientSecret();
        pSSysUtilDEBase.resetAuthMode();
        pSSysUtilDEBase.resetAuthParam();
        pSSysUtilDEBase.resetAuthParam2();
        pSSysUtilDEBase.resetCodeName();
        pSSysUtilDEBase.resetCreateDate();
        pSSysUtilDEBase.resetCreateMan();
        pSSysUtilDEBase.resetCustomCode();
        pSSysUtilDEBase.resetCustomMode();
        pSSysUtilDEBase.resetInPSSysDataSyncAgentId();
        pSSysUtilDEBase.resetInPSSysDataSyncAgentName();
        pSSysUtilDEBase.resetMemo();
        pSSysUtilDEBase.resetOrderValue();
        pSSysUtilDEBase.resetOutPSSysDataSyncAgentId();
        pSSysUtilDEBase.resetOutPSSysDataSyncAgentName();
        pSSysUtilDEBase.resetOutPSSysResourceId();
        pSSysUtilDEBase.resetOutPSSysResourceName();
        pSSysUtilDEBase.resetPSDEGroupId();
        pSSysUtilDEBase.resetPSDEGroupName();
        pSSysUtilDEBase.resetPSDERGroupId();
        pSSysUtilDEBase.resetPSDERGroupName();
        pSSysUtilDEBase.resetPSModuleId();
        pSSysUtilDEBase.resetPSModuleName();
        pSSysUtilDEBase.resetPSSubSysServiceAPIId();
        pSSysUtilDEBase.resetPSSubSysServiceAPIName();
        pSSysUtilDEBase.resetPSSysDynaModelId();
        pSSysUtilDEBase.resetPSSysDynaModelName();
        pSSysUtilDEBase.resetPSSysModelGroupId();
        pSSysUtilDEBase.resetPSSysModelGroupName();
        pSSysUtilDEBase.resetPSSysResourceId();
        pSSysUtilDEBase.resetPSSysResourceName();
        pSSysUtilDEBase.resetPSSysSFPluginId();
        pSSysUtilDEBase.resetPSSysSFPluginName();
        pSSysUtilDEBase.resetPSSystemId();
        pSSysUtilDEBase.resetPSSystemName();
        pSSysUtilDEBase.resetPSSysUtilDEId();
        pSSysUtilDEBase.resetPSSysUtilDEName();
        pSSysUtilDEBase.resetServiceParam();
        pSSysUtilDEBase.resetServiceParam2();
        pSSysUtilDEBase.resetServicePath();
        pSSysUtilDEBase.resetUniqueTag();
        pSSysUtilDEBase.resetUpdateDate();
        pSSysUtilDEBase.resetUpdateMan();
        pSSysUtilDEBase.resetUserCat();
        pSSysUtilDEBase.resetUserTag();
        pSSysUtilDEBase.resetUserTag2();
        pSSysUtilDEBase.resetUserTag3();
        pSSysUtilDEBase.resetUserTag4();
        pSSysUtilDEBase.resetUtilObj();
        pSSysUtilDEBase.resetUtilParam();
        pSSysUtilDEBase.resetUtilParam10();
        pSSysUtilDEBase.resetUtilParam11();
        pSSysUtilDEBase.resetUtilParam12();
        pSSysUtilDEBase.resetUtilParam2();
        pSSysUtilDEBase.resetUtilParam3();
        pSSysUtilDEBase.resetUtilParam4();
        pSSysUtilDEBase.resetUtilParam5();
        pSSysUtilDEBase.resetUtilParam6();
        pSSysUtilDEBase.resetUtilParam7();
        pSSysUtilDEBase.resetUtilParam8();
        pSSysUtilDEBase.resetUtilParam9();
        pSSysUtilDEBase.resetUtilParams();
        pSSysUtilDEBase.resetUtilPSDE10Id();
        pSSysUtilDEBase.resetUtilPSDE10Name();
        pSSysUtilDEBase.resetUtilPSDE11Id();
        pSSysUtilDEBase.resetUtilPSDE11Name();
        pSSysUtilDEBase.resetUtilPSDE12Id();
        pSSysUtilDEBase.resetUtilPSDE12Name();
        pSSysUtilDEBase.resetUtilPSDE13Id();
        pSSysUtilDEBase.resetUtilPSDE13Name();
        pSSysUtilDEBase.resetUtilPSDE14Id();
        pSSysUtilDEBase.resetUtilPSDE14Name();
        pSSysUtilDEBase.resetUtilPSDE15Id();
        pSSysUtilDEBase.resetUtilPSDE15Name();
        pSSysUtilDEBase.resetUtilPSDE16Id();
        pSSysUtilDEBase.resetUtilPSDE16Name();
        pSSysUtilDEBase.resetUtilPSDE17Id();
        pSSysUtilDEBase.resetUtilPSDE17Name();
        pSSysUtilDEBase.resetUtilPSDE18Id();
        pSSysUtilDEBase.resetUtilPSDE18Name();
        pSSysUtilDEBase.resetUtilPSDE19Id();
        pSSysUtilDEBase.resetUtilPSDE19Name();
        pSSysUtilDEBase.resetUtilPSDE20Id();
        pSSysUtilDEBase.resetUtilPSDE20Name();
        pSSysUtilDEBase.resetUtilPSDE2Id();
        pSSysUtilDEBase.resetUtilPSDE2Name();
        pSSysUtilDEBase.resetUtilPSDE3Id();
        pSSysUtilDEBase.resetUtilPSDE3Name();
        pSSysUtilDEBase.resetUtilPSDE4Id();
        pSSysUtilDEBase.resetUtilPSDE4Name();
        pSSysUtilDEBase.resetUtilPSDE5Id();
        pSSysUtilDEBase.resetUtilPSDE5Name();
        pSSysUtilDEBase.resetUtilPSDE6Id();
        pSSysUtilDEBase.resetUtilPSDE6Name();
        pSSysUtilDEBase.resetUtilPSDE7Id();
        pSSysUtilDEBase.resetUtilPSDE7Name();
        pSSysUtilDEBase.resetUtilPSDE8Id();
        pSSysUtilDEBase.resetUtilPSDE8Name();
        pSSysUtilDEBase.resetUtilPSDE9Id();
        pSSysUtilDEBase.resetUtilPSDE9Name();
        pSSysUtilDEBase.resetUtilPSDEId();
        pSSysUtilDEBase.resetUtilPSDEName();
        pSSysUtilDEBase.resetUtilTag();
        pSSysUtilDEBase.resetUtilTag2();
        pSSysUtilDEBase.resetUtilType();
        pSSysUtilDEBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAuthAccessTokenUriDirty()) {
            hashMap.put(FIELD_AUTHACCESSTOKENURI, this.getAuthAccessTokenUri());
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
        if (!bl || this.isInPSSysDataSyncAgentIdDirty()) {
            hashMap.put(FIELD_INPSSYSDATASYNCAGENTID, this.getInPSSysDataSyncAgentId());
        }
        if (!bl || this.isInPSSysDataSyncAgentNameDirty()) {
            hashMap.put(FIELD_INPSSYSDATASYNCAGENTNAME, this.getInPSSysDataSyncAgentName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isOutPSSysDataSyncAgentIdDirty()) {
            hashMap.put(FIELD_OUTPSSYSDATASYNCAGENTID, this.getOutPSSysDataSyncAgentId());
        }
        if (!bl || this.isOutPSSysDataSyncAgentNameDirty()) {
            hashMap.put(FIELD_OUTPSSYSDATASYNCAGENTNAME, this.getOutPSSysDataSyncAgentName());
        }
        if (!bl || this.isOutPSSysResourceIdDirty()) {
            hashMap.put(FIELD_OUTPSSYSRESOURCEID, this.getOutPSSysResourceId());
        }
        if (!bl || this.isOutPSSysResourceNameDirty()) {
            hashMap.put(FIELD_OUTPSSYSRESOURCENAME, this.getOutPSSysResourceName());
        }
        if (!bl || this.isPSDEGroupIdDirty()) {
            hashMap.put(FIELD_PSDEGROUPID, this.getPSDEGroupId());
        }
        if (!bl || this.isPSDEGroupNameDirty()) {
            hashMap.put(FIELD_PSDEGROUPNAME, this.getPSDEGroupName());
        }
        if (!bl || this.isPSDERGroupIdDirty()) {
            hashMap.put(FIELD_PSDERGROUPID, this.getPSDERGroupId());
        }
        if (!bl || this.isPSDERGroupNameDirty()) {
            hashMap.put(FIELD_PSDERGROUPNAME, this.getPSDERGroupName());
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
        if (!bl || this.isPSSysModelGroupIdDirty()) {
            hashMap.put(FIELD_PSSYSMODELGROUPID, this.getPSSysModelGroupId());
        }
        if (!bl || this.isPSSysModelGroupNameDirty()) {
            hashMap.put(FIELD_PSSYSMODELGROUPNAME, this.getPSSysModelGroupName());
        }
        if (!bl || this.isPSSysResourceIdDirty()) {
            hashMap.put(FIELD_PSSYSRESOURCEID, this.getPSSysResourceId());
        }
        if (!bl || this.isPSSysResourceNameDirty()) {
            hashMap.put(FIELD_PSSYSRESOURCENAME, this.getPSSysResourceName());
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
        if (!bl || this.isPSSysUtilDEIdDirty()) {
            hashMap.put(FIELD_PSSYSUTILDEID, this.getPSSysUtilDEId());
        }
        if (!bl || this.isPSSysUtilDENameDirty()) {
            hashMap.put(FIELD_PSSYSUTILDENAME, this.getPSSysUtilDEName());
        }
        if (!bl || this.isServiceParamDirty()) {
            hashMap.put(FIELD_SERVICEPARAM, this.getServiceParam());
        }
        if (!bl || this.isServiceParam2Dirty()) {
            hashMap.put(FIELD_SERVICEPARAM2, this.getServiceParam2());
        }
        if (!bl || this.isServicePathDirty()) {
            hashMap.put(FIELD_SERVICEPATH, this.getServicePath());
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
        if (!bl || this.isUtilObjDirty()) {
            hashMap.put(FIELD_UTILOBJ, this.getUtilObj());
        }
        if (!bl || this.isUtilParamDirty()) {
            hashMap.put(FIELD_UTILPARAM, this.getUtilParam());
        }
        if (!bl || this.isUtilParam10Dirty()) {
            hashMap.put(FIELD_UTILPARAM10, this.getUtilParam10());
        }
        if (!bl || this.isUtilParam11Dirty()) {
            hashMap.put(FIELD_UTILPARAM11, this.getUtilParam11());
        }
        if (!bl || this.isUtilParam12Dirty()) {
            hashMap.put(FIELD_UTILPARAM12, this.getUtilParam12());
        }
        if (!bl || this.isUtilParam2Dirty()) {
            hashMap.put(FIELD_UTILPARAM2, this.getUtilParam2());
        }
        if (!bl || this.isUtilParam3Dirty()) {
            hashMap.put(FIELD_UTILPARAM3, this.getUtilParam3());
        }
        if (!bl || this.isUtilParam4Dirty()) {
            hashMap.put(FIELD_UTILPARAM4, this.getUtilParam4());
        }
        if (!bl || this.isUtilParam5Dirty()) {
            hashMap.put(FIELD_UTILPARAM5, this.getUtilParam5());
        }
        if (!bl || this.isUtilParam6Dirty()) {
            hashMap.put(FIELD_UTILPARAM6, this.getUtilParam6());
        }
        if (!bl || this.isUtilParam7Dirty()) {
            hashMap.put(FIELD_UTILPARAM7, this.getUtilParam7());
        }
        if (!bl || this.isUtilParam8Dirty()) {
            hashMap.put(FIELD_UTILPARAM8, this.getUtilParam8());
        }
        if (!bl || this.isUtilParam9Dirty()) {
            hashMap.put(FIELD_UTILPARAM9, this.getUtilParam9());
        }
        if (!bl || this.isUtilParamsDirty()) {
            hashMap.put(FIELD_UTILPARAMS, this.getUtilParams());
        }
        if (!bl || this.isUtilPSDE10IdDirty()) {
            hashMap.put(FIELD_UTILPSDE10ID, this.getUtilPSDE10Id());
        }
        if (!bl || this.isUtilPSDE10NameDirty()) {
            hashMap.put(FIELD_UTILPSDE10NAME, this.getUtilPSDE10Name());
        }
        if (!bl || this.isUtilPSDE11IdDirty()) {
            hashMap.put(FIELD_UTILPSDE11ID, this.getUtilPSDE11Id());
        }
        if (!bl || this.isUtilPSDE11NameDirty()) {
            hashMap.put(FIELD_UTILPSDE11NAME, this.getUtilPSDE11Name());
        }
        if (!bl || this.isUtilPSDE12IdDirty()) {
            hashMap.put(FIELD_UTILPSDE12ID, this.getUtilPSDE12Id());
        }
        if (!bl || this.isUtilPSDE12NameDirty()) {
            hashMap.put(FIELD_UTILPSDE12NAME, this.getUtilPSDE12Name());
        }
        if (!bl || this.isUtilPSDE13IdDirty()) {
            hashMap.put(FIELD_UTILPSDE13ID, this.getUtilPSDE13Id());
        }
        if (!bl || this.isUtilPSDE13NameDirty()) {
            hashMap.put(FIELD_UTILPSDE13NAME, this.getUtilPSDE13Name());
        }
        if (!bl || this.isUtilPSDE14IdDirty()) {
            hashMap.put(FIELD_UTILPSDE14ID, this.getUtilPSDE14Id());
        }
        if (!bl || this.isUtilPSDE14NameDirty()) {
            hashMap.put(FIELD_UTILPSDE14NAME, this.getUtilPSDE14Name());
        }
        if (!bl || this.isUtilPSDE15IdDirty()) {
            hashMap.put(FIELD_UTILPSDE15ID, this.getUtilPSDE15Id());
        }
        if (!bl || this.isUtilPSDE15NameDirty()) {
            hashMap.put(FIELD_UTILPSDE15NAME, this.getUtilPSDE15Name());
        }
        if (!bl || this.isUtilPSDE16IdDirty()) {
            hashMap.put(FIELD_UTILPSDE16ID, this.getUtilPSDE16Id());
        }
        if (!bl || this.isUtilPSDE16NameDirty()) {
            hashMap.put(FIELD_UTILPSDE16NAME, this.getUtilPSDE16Name());
        }
        if (!bl || this.isUtilPSDE17IdDirty()) {
            hashMap.put(FIELD_UTILPSDE17ID, this.getUtilPSDE17Id());
        }
        if (!bl || this.isUtilPSDE17NameDirty()) {
            hashMap.put(FIELD_UTILPSDE17NAME, this.getUtilPSDE17Name());
        }
        if (!bl || this.isUtilPSDE18IdDirty()) {
            hashMap.put(FIELD_UTILPSDE18ID, this.getUtilPSDE18Id());
        }
        if (!bl || this.isUtilPSDE18NameDirty()) {
            hashMap.put(FIELD_UTILPSDE18NAME, this.getUtilPSDE18Name());
        }
        if (!bl || this.isUtilPSDE19IdDirty()) {
            hashMap.put(FIELD_UTILPSDE19ID, this.getUtilPSDE19Id());
        }
        if (!bl || this.isUtilPSDE19NameDirty()) {
            hashMap.put(FIELD_UTILPSDE19NAME, this.getUtilPSDE19Name());
        }
        if (!bl || this.isUtilPSDE20IdDirty()) {
            hashMap.put(FIELD_UTILPSDE20ID, this.getUtilPSDE20Id());
        }
        if (!bl || this.isUtilPSDE20NameDirty()) {
            hashMap.put(FIELD_UTILPSDE20NAME, this.getUtilPSDE20Name());
        }
        if (!bl || this.isUtilPSDE2IdDirty()) {
            hashMap.put(FIELD_UTILPSDE2ID, this.getUtilPSDE2Id());
        }
        if (!bl || this.isUtilPSDE2NameDirty()) {
            hashMap.put(FIELD_UTILPSDE2NAME, this.getUtilPSDE2Name());
        }
        if (!bl || this.isUtilPSDE3IdDirty()) {
            hashMap.put(FIELD_UTILPSDE3ID, this.getUtilPSDE3Id());
        }
        if (!bl || this.isUtilPSDE3NameDirty()) {
            hashMap.put(FIELD_UTILPSDE3NAME, this.getUtilPSDE3Name());
        }
        if (!bl || this.isUtilPSDE4IdDirty()) {
            hashMap.put(FIELD_UTILPSDE4ID, this.getUtilPSDE4Id());
        }
        if (!bl || this.isUtilPSDE4NameDirty()) {
            hashMap.put(FIELD_UTILPSDE4NAME, this.getUtilPSDE4Name());
        }
        if (!bl || this.isUtilPSDE5IdDirty()) {
            hashMap.put(FIELD_UTILPSDE5ID, this.getUtilPSDE5Id());
        }
        if (!bl || this.isUtilPSDE5NameDirty()) {
            hashMap.put(FIELD_UTILPSDE5NAME, this.getUtilPSDE5Name());
        }
        if (!bl || this.isUtilPSDE6IdDirty()) {
            hashMap.put(FIELD_UTILPSDE6ID, this.getUtilPSDE6Id());
        }
        if (!bl || this.isUtilPSDE6NameDirty()) {
            hashMap.put(FIELD_UTILPSDE6NAME, this.getUtilPSDE6Name());
        }
        if (!bl || this.isUtilPSDE7IdDirty()) {
            hashMap.put(FIELD_UTILPSDE7ID, this.getUtilPSDE7Id());
        }
        if (!bl || this.isUtilPSDE7NameDirty()) {
            hashMap.put(FIELD_UTILPSDE7NAME, this.getUtilPSDE7Name());
        }
        if (!bl || this.isUtilPSDE8IdDirty()) {
            hashMap.put(FIELD_UTILPSDE8ID, this.getUtilPSDE8Id());
        }
        if (!bl || this.isUtilPSDE8NameDirty()) {
            hashMap.put(FIELD_UTILPSDE8NAME, this.getUtilPSDE8Name());
        }
        if (!bl || this.isUtilPSDE9IdDirty()) {
            hashMap.put(FIELD_UTILPSDE9ID, this.getUtilPSDE9Id());
        }
        if (!bl || this.isUtilPSDE9NameDirty()) {
            hashMap.put(FIELD_UTILPSDE9NAME, this.getUtilPSDE9Name());
        }
        if (!bl || this.isUtilPSDEIdDirty()) {
            hashMap.put(FIELD_UTILPSDEID, this.getUtilPSDEId());
        }
        if (!bl || this.isUtilPSDENameDirty()) {
            hashMap.put(FIELD_UTILPSDENAME, this.getUtilPSDEName());
        }
        if (!bl || this.isUtilTagDirty()) {
            hashMap.put(FIELD_UTILTAG, this.getUtilTag());
        }
        if (!bl || this.isUtilTag2Dirty()) {
            hashMap.put(FIELD_UTILTAG2, this.getUtilTag2());
        }
        if (!bl || this.isUtilTypeDirty()) {
            hashMap.put(FIELD_UTILTYPE, this.getUtilType());
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
        return PSSysUtilDEBase.get(this, n);
    }

    private static Object get(PSSysUtilDEBase pSSysUtilDEBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysUtilDEBase.getAuthAccessTokenUri();
            }
            case 1: {
                return pSSysUtilDEBase.getAuthClientId();
            }
            case 2: {
                return pSSysUtilDEBase.getAuthClientSecret();
            }
            case 3: {
                return pSSysUtilDEBase.getAuthMode();
            }
            case 4: {
                return pSSysUtilDEBase.getAuthParam();
            }
            case 5: {
                return pSSysUtilDEBase.getAuthParam2();
            }
            case 6: {
                return pSSysUtilDEBase.getCodeName();
            }
            case 7: {
                return pSSysUtilDEBase.getCreateDate();
            }
            case 8: {
                return pSSysUtilDEBase.getCreateMan();
            }
            case 9: {
                return pSSysUtilDEBase.getCustomCode();
            }
            case 10: {
                return pSSysUtilDEBase.getCustomMode();
            }
            case 11: {
                return pSSysUtilDEBase.getInPSSysDataSyncAgentId();
            }
            case 12: {
                return pSSysUtilDEBase.getInPSSysDataSyncAgentName();
            }
            case 13: {
                return pSSysUtilDEBase.getMemo();
            }
            case 14: {
                return pSSysUtilDEBase.getOrderValue();
            }
            case 15: {
                return pSSysUtilDEBase.getOutPSSysDataSyncAgentId();
            }
            case 16: {
                return pSSysUtilDEBase.getOutPSSysDataSyncAgentName();
            }
            case 17: {
                return pSSysUtilDEBase.getOutPSSysResourceId();
            }
            case 18: {
                return pSSysUtilDEBase.getOutPSSysResourceName();
            }
            case 19: {
                return pSSysUtilDEBase.getPSDEGroupId();
            }
            case 20: {
                return pSSysUtilDEBase.getPSDEGroupName();
            }
            case 21: {
                return pSSysUtilDEBase.getPSDERGroupId();
            }
            case 22: {
                return pSSysUtilDEBase.getPSDERGroupName();
            }
            case 23: {
                return pSSysUtilDEBase.getPSModuleId();
            }
            case 24: {
                return pSSysUtilDEBase.getPSModuleName();
            }
            case 25: {
                return pSSysUtilDEBase.getPSSubSysServiceAPIId();
            }
            case 26: {
                return pSSysUtilDEBase.getPSSubSysServiceAPIName();
            }
            case 27: {
                return pSSysUtilDEBase.getPSSysDynaModelId();
            }
            case 28: {
                return pSSysUtilDEBase.getPSSysDynaModelName();
            }
            case 29: {
                return pSSysUtilDEBase.getPSSysModelGroupId();
            }
            case 30: {
                return pSSysUtilDEBase.getPSSysModelGroupName();
            }
            case 31: {
                return pSSysUtilDEBase.getPSSysResourceId();
            }
            case 32: {
                return pSSysUtilDEBase.getPSSysResourceName();
            }
            case 33: {
                return pSSysUtilDEBase.getPSSysSFPluginId();
            }
            case 34: {
                return pSSysUtilDEBase.getPSSysSFPluginName();
            }
            case 35: {
                return pSSysUtilDEBase.getPSSystemId();
            }
            case 36: {
                return pSSysUtilDEBase.getPSSystemName();
            }
            case 37: {
                return pSSysUtilDEBase.getPSSysUtilDEId();
            }
            case 38: {
                return pSSysUtilDEBase.getPSSysUtilDEName();
            }
            case 39: {
                return pSSysUtilDEBase.getServiceParam();
            }
            case 40: {
                return pSSysUtilDEBase.getServiceParam2();
            }
            case 41: {
                return pSSysUtilDEBase.getServicePath();
            }
            case 42: {
                return pSSysUtilDEBase.getUniqueTag();
            }
            case 43: {
                return pSSysUtilDEBase.getUpdateDate();
            }
            case 44: {
                return pSSysUtilDEBase.getUpdateMan();
            }
            case 45: {
                return pSSysUtilDEBase.getUserCat();
            }
            case 46: {
                return pSSysUtilDEBase.getUserTag();
            }
            case 47: {
                return pSSysUtilDEBase.getUserTag2();
            }
            case 48: {
                return pSSysUtilDEBase.getUserTag3();
            }
            case 49: {
                return pSSysUtilDEBase.getUserTag4();
            }
            case 50: {
                return pSSysUtilDEBase.getUtilObj();
            }
            case 51: {
                return pSSysUtilDEBase.getUtilParam();
            }
            case 52: {
                return pSSysUtilDEBase.getUtilParam10();
            }
            case 53: {
                return pSSysUtilDEBase.getUtilParam11();
            }
            case 54: {
                return pSSysUtilDEBase.getUtilParam12();
            }
            case 55: {
                return pSSysUtilDEBase.getUtilParam2();
            }
            case 56: {
                return pSSysUtilDEBase.getUtilParam3();
            }
            case 57: {
                return pSSysUtilDEBase.getUtilParam4();
            }
            case 58: {
                return pSSysUtilDEBase.getUtilParam5();
            }
            case 59: {
                return pSSysUtilDEBase.getUtilParam6();
            }
            case 60: {
                return pSSysUtilDEBase.getUtilParam7();
            }
            case 61: {
                return pSSysUtilDEBase.getUtilParam8();
            }
            case 62: {
                return pSSysUtilDEBase.getUtilParam9();
            }
            case 63: {
                return pSSysUtilDEBase.getUtilParams();
            }
            case 64: {
                return pSSysUtilDEBase.getUtilPSDE10Id();
            }
            case 65: {
                return pSSysUtilDEBase.getUtilPSDE10Name();
            }
            case 66: {
                return pSSysUtilDEBase.getUtilPSDE11Id();
            }
            case 67: {
                return pSSysUtilDEBase.getUtilPSDE11Name();
            }
            case 68: {
                return pSSysUtilDEBase.getUtilPSDE12Id();
            }
            case 69: {
                return pSSysUtilDEBase.getUtilPSDE12Name();
            }
            case 70: {
                return pSSysUtilDEBase.getUtilPSDE13Id();
            }
            case 71: {
                return pSSysUtilDEBase.getUtilPSDE13Name();
            }
            case 72: {
                return pSSysUtilDEBase.getUtilPSDE14Id();
            }
            case 73: {
                return pSSysUtilDEBase.getUtilPSDE14Name();
            }
            case 74: {
                return pSSysUtilDEBase.getUtilPSDE15Id();
            }
            case 75: {
                return pSSysUtilDEBase.getUtilPSDE15Name();
            }
            case 76: {
                return pSSysUtilDEBase.getUtilPSDE16Id();
            }
            case 77: {
                return pSSysUtilDEBase.getUtilPSDE16Name();
            }
            case 78: {
                return pSSysUtilDEBase.getUtilPSDE17Id();
            }
            case 79: {
                return pSSysUtilDEBase.getUtilPSDE17Name();
            }
            case 80: {
                return pSSysUtilDEBase.getUtilPSDE18Id();
            }
            case 81: {
                return pSSysUtilDEBase.getUtilPSDE18Name();
            }
            case 82: {
                return pSSysUtilDEBase.getUtilPSDE19Id();
            }
            case 83: {
                return pSSysUtilDEBase.getUtilPSDE19Name();
            }
            case 84: {
                return pSSysUtilDEBase.getUtilPSDE20Id();
            }
            case 85: {
                return pSSysUtilDEBase.getUtilPSDE20Name();
            }
            case 86: {
                return pSSysUtilDEBase.getUtilPSDE2Id();
            }
            case 87: {
                return pSSysUtilDEBase.getUtilPSDE2Name();
            }
            case 88: {
                return pSSysUtilDEBase.getUtilPSDE3Id();
            }
            case 89: {
                return pSSysUtilDEBase.getUtilPSDE3Name();
            }
            case 90: {
                return pSSysUtilDEBase.getUtilPSDE4Id();
            }
            case 91: {
                return pSSysUtilDEBase.getUtilPSDE4Name();
            }
            case 92: {
                return pSSysUtilDEBase.getUtilPSDE5Id();
            }
            case 93: {
                return pSSysUtilDEBase.getUtilPSDE5Name();
            }
            case 94: {
                return pSSysUtilDEBase.getUtilPSDE6Id();
            }
            case 95: {
                return pSSysUtilDEBase.getUtilPSDE6Name();
            }
            case 96: {
                return pSSysUtilDEBase.getUtilPSDE7Id();
            }
            case 97: {
                return pSSysUtilDEBase.getUtilPSDE7Name();
            }
            case 98: {
                return pSSysUtilDEBase.getUtilPSDE8Id();
            }
            case 99: {
                return pSSysUtilDEBase.getUtilPSDE8Name();
            }
            case 100: {
                return pSSysUtilDEBase.getUtilPSDE9Id();
            }
            case 101: {
                return pSSysUtilDEBase.getUtilPSDE9Name();
            }
            case 102: {
                return pSSysUtilDEBase.getUtilPSDEId();
            }
            case 103: {
                return pSSysUtilDEBase.getUtilPSDEName();
            }
            case 104: {
                return pSSysUtilDEBase.getUtilTag();
            }
            case 105: {
                return pSSysUtilDEBase.getUtilTag2();
            }
            case 106: {
                return pSSysUtilDEBase.getUtilType();
            }
            case 107: {
                return pSSysUtilDEBase.getValidFlag();
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
        PSSysUtilDEBase.set(this, n, object);
    }

    private static void set(PSSysUtilDEBase pSSysUtilDEBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysUtilDEBase.setAuthAccessTokenUri(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysUtilDEBase.setAuthClientId(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysUtilDEBase.setAuthClientSecret(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysUtilDEBase.setAuthMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysUtilDEBase.setAuthParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysUtilDEBase.setAuthParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysUtilDEBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysUtilDEBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSSysUtilDEBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysUtilDEBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysUtilDEBase.setCustomMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSSysUtilDEBase.setInPSSysDataSyncAgentId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysUtilDEBase.setInPSSysDataSyncAgentName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysUtilDEBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysUtilDEBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSSysUtilDEBase.setOutPSSysDataSyncAgentId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysUtilDEBase.setOutPSSysDataSyncAgentName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysUtilDEBase.setOutPSSysResourceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysUtilDEBase.setOutPSSysResourceName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysUtilDEBase.setPSDEGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysUtilDEBase.setPSDEGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysUtilDEBase.setPSDERGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysUtilDEBase.setPSDERGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysUtilDEBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysUtilDEBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysUtilDEBase.setPSSubSysServiceAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysUtilDEBase.setPSSubSysServiceAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysUtilDEBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysUtilDEBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysUtilDEBase.setPSSysModelGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysUtilDEBase.setPSSysModelGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysUtilDEBase.setPSSysResourceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysUtilDEBase.setPSSysResourceName(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysUtilDEBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysUtilDEBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSysUtilDEBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSSysUtilDEBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSSysUtilDEBase.setPSSysUtilDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSSysUtilDEBase.setPSSysUtilDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSSysUtilDEBase.setServiceParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSSysUtilDEBase.setServiceParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSSysUtilDEBase.setServicePath(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSSysUtilDEBase.setUniqueTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSSysUtilDEBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 44: {
                pSSysUtilDEBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSSysUtilDEBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSSysUtilDEBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSSysUtilDEBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSSysUtilDEBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSSysUtilDEBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSSysUtilDEBase.setUtilObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSSysUtilDEBase.setUtilParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSSysUtilDEBase.setUtilParam10(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 53: {
                pSSysUtilDEBase.setUtilParam11(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSSysUtilDEBase.setUtilParam12(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSSysUtilDEBase.setUtilParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSSysUtilDEBase.setUtilParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSSysUtilDEBase.setUtilParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 58: {
                pSSysUtilDEBase.setUtilParam5(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 59: {
                pSSysUtilDEBase.setUtilParam6(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 60: {
                pSSysUtilDEBase.setUtilParam7(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 61: {
                pSSysUtilDEBase.setUtilParam8(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 62: {
                pSSysUtilDEBase.setUtilParam9(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 63: {
                pSSysUtilDEBase.setUtilParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 64: {
                pSSysUtilDEBase.setUtilPSDE10Id(DataObject.getStringValue((Object)object));
                return;
            }
            case 65: {
                pSSysUtilDEBase.setUtilPSDE10Name(DataObject.getStringValue((Object)object));
                return;
            }
            case 66: {
                pSSysUtilDEBase.setUtilPSDE11Id(DataObject.getStringValue((Object)object));
                return;
            }
            case 67: {
                pSSysUtilDEBase.setUtilPSDE11Name(DataObject.getStringValue((Object)object));
                return;
            }
            case 68: {
                pSSysUtilDEBase.setUtilPSDE12Id(DataObject.getStringValue((Object)object));
                return;
            }
            case 69: {
                pSSysUtilDEBase.setUtilPSDE12Name(DataObject.getStringValue((Object)object));
                return;
            }
            case 70: {
                pSSysUtilDEBase.setUtilPSDE13Id(DataObject.getStringValue((Object)object));
                return;
            }
            case 71: {
                pSSysUtilDEBase.setUtilPSDE13Name(DataObject.getStringValue((Object)object));
                return;
            }
            case 72: {
                pSSysUtilDEBase.setUtilPSDE14Id(DataObject.getStringValue((Object)object));
                return;
            }
            case 73: {
                pSSysUtilDEBase.setUtilPSDE14Name(DataObject.getStringValue((Object)object));
                return;
            }
            case 74: {
                pSSysUtilDEBase.setUtilPSDE15Id(DataObject.getStringValue((Object)object));
                return;
            }
            case 75: {
                pSSysUtilDEBase.setUtilPSDE15Name(DataObject.getStringValue((Object)object));
                return;
            }
            case 76: {
                pSSysUtilDEBase.setUtilPSDE16Id(DataObject.getStringValue((Object)object));
                return;
            }
            case 77: {
                pSSysUtilDEBase.setUtilPSDE16Name(DataObject.getStringValue((Object)object));
                return;
            }
            case 78: {
                pSSysUtilDEBase.setUtilPSDE17Id(DataObject.getStringValue((Object)object));
                return;
            }
            case 79: {
                pSSysUtilDEBase.setUtilPSDE17Name(DataObject.getStringValue((Object)object));
                return;
            }
            case 80: {
                pSSysUtilDEBase.setUtilPSDE18Id(DataObject.getStringValue((Object)object));
                return;
            }
            case 81: {
                pSSysUtilDEBase.setUtilPSDE18Name(DataObject.getStringValue((Object)object));
                return;
            }
            case 82: {
                pSSysUtilDEBase.setUtilPSDE19Id(DataObject.getStringValue((Object)object));
                return;
            }
            case 83: {
                pSSysUtilDEBase.setUtilPSDE19Name(DataObject.getStringValue((Object)object));
                return;
            }
            case 84: {
                pSSysUtilDEBase.setUtilPSDE20Id(DataObject.getStringValue((Object)object));
                return;
            }
            case 85: {
                pSSysUtilDEBase.setUtilPSDE20Name(DataObject.getStringValue((Object)object));
                return;
            }
            case 86: {
                pSSysUtilDEBase.setUtilPSDE2Id(DataObject.getStringValue((Object)object));
                return;
            }
            case 87: {
                pSSysUtilDEBase.setUtilPSDE2Name(DataObject.getStringValue((Object)object));
                return;
            }
            case 88: {
                pSSysUtilDEBase.setUtilPSDE3Id(DataObject.getStringValue((Object)object));
                return;
            }
            case 89: {
                pSSysUtilDEBase.setUtilPSDE3Name(DataObject.getStringValue((Object)object));
                return;
            }
            case 90: {
                pSSysUtilDEBase.setUtilPSDE4Id(DataObject.getStringValue((Object)object));
                return;
            }
            case 91: {
                pSSysUtilDEBase.setUtilPSDE4Name(DataObject.getStringValue((Object)object));
                return;
            }
            case 92: {
                pSSysUtilDEBase.setUtilPSDE5Id(DataObject.getStringValue((Object)object));
                return;
            }
            case 93: {
                pSSysUtilDEBase.setUtilPSDE5Name(DataObject.getStringValue((Object)object));
                return;
            }
            case 94: {
                pSSysUtilDEBase.setUtilPSDE6Id(DataObject.getStringValue((Object)object));
                return;
            }
            case 95: {
                pSSysUtilDEBase.setUtilPSDE6Name(DataObject.getStringValue((Object)object));
                return;
            }
            case 96: {
                pSSysUtilDEBase.setUtilPSDE7Id(DataObject.getStringValue((Object)object));
                return;
            }
            case 97: {
                pSSysUtilDEBase.setUtilPSDE7Name(DataObject.getStringValue((Object)object));
                return;
            }
            case 98: {
                pSSysUtilDEBase.setUtilPSDE8Id(DataObject.getStringValue((Object)object));
                return;
            }
            case 99: {
                pSSysUtilDEBase.setUtilPSDE8Name(DataObject.getStringValue((Object)object));
                return;
            }
            case 100: {
                pSSysUtilDEBase.setUtilPSDE9Id(DataObject.getStringValue((Object)object));
                return;
            }
            case 101: {
                pSSysUtilDEBase.setUtilPSDE9Name(DataObject.getStringValue((Object)object));
                return;
            }
            case 102: {
                pSSysUtilDEBase.setUtilPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 103: {
                pSSysUtilDEBase.setUtilPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 104: {
                pSSysUtilDEBase.setUtilTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 105: {
                pSSysUtilDEBase.setUtilTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 106: {
                pSSysUtilDEBase.setUtilType(DataObject.getStringValue((Object)object));
                return;
            }
            case 107: {
                pSSysUtilDEBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysUtilDEBase.isNull(this, n);
    }

    private static boolean isNull(PSSysUtilDEBase pSSysUtilDEBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysUtilDEBase.getAuthAccessTokenUri() == null;
            }
            case 1: {
                return pSSysUtilDEBase.getAuthClientId() == null;
            }
            case 2: {
                return pSSysUtilDEBase.getAuthClientSecret() == null;
            }
            case 3: {
                return pSSysUtilDEBase.getAuthMode() == null;
            }
            case 4: {
                return pSSysUtilDEBase.getAuthParam() == null;
            }
            case 5: {
                return pSSysUtilDEBase.getAuthParam2() == null;
            }
            case 6: {
                return pSSysUtilDEBase.getCodeName() == null;
            }
            case 7: {
                return pSSysUtilDEBase.getCreateDate() == null;
            }
            case 8: {
                return pSSysUtilDEBase.getCreateMan() == null;
            }
            case 9: {
                return pSSysUtilDEBase.getCustomCode() == null;
            }
            case 10: {
                return pSSysUtilDEBase.getCustomMode() == null;
            }
            case 11: {
                return pSSysUtilDEBase.getInPSSysDataSyncAgentId() == null;
            }
            case 12: {
                return pSSysUtilDEBase.getInPSSysDataSyncAgentName() == null;
            }
            case 13: {
                return pSSysUtilDEBase.getMemo() == null;
            }
            case 14: {
                return pSSysUtilDEBase.getOrderValue() == null;
            }
            case 15: {
                return pSSysUtilDEBase.getOutPSSysDataSyncAgentId() == null;
            }
            case 16: {
                return pSSysUtilDEBase.getOutPSSysDataSyncAgentName() == null;
            }
            case 17: {
                return pSSysUtilDEBase.getOutPSSysResourceId() == null;
            }
            case 18: {
                return pSSysUtilDEBase.getOutPSSysResourceName() == null;
            }
            case 19: {
                return pSSysUtilDEBase.getPSDEGroupId() == null;
            }
            case 20: {
                return pSSysUtilDEBase.getPSDEGroupName() == null;
            }
            case 21: {
                return pSSysUtilDEBase.getPSDERGroupId() == null;
            }
            case 22: {
                return pSSysUtilDEBase.getPSDERGroupName() == null;
            }
            case 23: {
                return pSSysUtilDEBase.getPSModuleId() == null;
            }
            case 24: {
                return pSSysUtilDEBase.getPSModuleName() == null;
            }
            case 25: {
                return pSSysUtilDEBase.getPSSubSysServiceAPIId() == null;
            }
            case 26: {
                return pSSysUtilDEBase.getPSSubSysServiceAPIName() == null;
            }
            case 27: {
                return pSSysUtilDEBase.getPSSysDynaModelId() == null;
            }
            case 28: {
                return pSSysUtilDEBase.getPSSysDynaModelName() == null;
            }
            case 29: {
                return pSSysUtilDEBase.getPSSysModelGroupId() == null;
            }
            case 30: {
                return pSSysUtilDEBase.getPSSysModelGroupName() == null;
            }
            case 31: {
                return pSSysUtilDEBase.getPSSysResourceId() == null;
            }
            case 32: {
                return pSSysUtilDEBase.getPSSysResourceName() == null;
            }
            case 33: {
                return pSSysUtilDEBase.getPSSysSFPluginId() == null;
            }
            case 34: {
                return pSSysUtilDEBase.getPSSysSFPluginName() == null;
            }
            case 35: {
                return pSSysUtilDEBase.getPSSystemId() == null;
            }
            case 36: {
                return pSSysUtilDEBase.getPSSystemName() == null;
            }
            case 37: {
                return pSSysUtilDEBase.getPSSysUtilDEId() == null;
            }
            case 38: {
                return pSSysUtilDEBase.getPSSysUtilDEName() == null;
            }
            case 39: {
                return pSSysUtilDEBase.getServiceParam() == null;
            }
            case 40: {
                return pSSysUtilDEBase.getServiceParam2() == null;
            }
            case 41: {
                return pSSysUtilDEBase.getServicePath() == null;
            }
            case 42: {
                return pSSysUtilDEBase.getUniqueTag() == null;
            }
            case 43: {
                return pSSysUtilDEBase.getUpdateDate() == null;
            }
            case 44: {
                return pSSysUtilDEBase.getUpdateMan() == null;
            }
            case 45: {
                return pSSysUtilDEBase.getUserCat() == null;
            }
            case 46: {
                return pSSysUtilDEBase.getUserTag() == null;
            }
            case 47: {
                return pSSysUtilDEBase.getUserTag2() == null;
            }
            case 48: {
                return pSSysUtilDEBase.getUserTag3() == null;
            }
            case 49: {
                return pSSysUtilDEBase.getUserTag4() == null;
            }
            case 50: {
                return pSSysUtilDEBase.getUtilObj() == null;
            }
            case 51: {
                return pSSysUtilDEBase.getUtilParam() == null;
            }
            case 52: {
                return pSSysUtilDEBase.getUtilParam10() == null;
            }
            case 53: {
                return pSSysUtilDEBase.getUtilParam11() == null;
            }
            case 54: {
                return pSSysUtilDEBase.getUtilParam12() == null;
            }
            case 55: {
                return pSSysUtilDEBase.getUtilParam2() == null;
            }
            case 56: {
                return pSSysUtilDEBase.getUtilParam3() == null;
            }
            case 57: {
                return pSSysUtilDEBase.getUtilParam4() == null;
            }
            case 58: {
                return pSSysUtilDEBase.getUtilParam5() == null;
            }
            case 59: {
                return pSSysUtilDEBase.getUtilParam6() == null;
            }
            case 60: {
                return pSSysUtilDEBase.getUtilParam7() == null;
            }
            case 61: {
                return pSSysUtilDEBase.getUtilParam8() == null;
            }
            case 62: {
                return pSSysUtilDEBase.getUtilParam9() == null;
            }
            case 63: {
                return pSSysUtilDEBase.getUtilParams() == null;
            }
            case 64: {
                return pSSysUtilDEBase.getUtilPSDE10Id() == null;
            }
            case 65: {
                return pSSysUtilDEBase.getUtilPSDE10Name() == null;
            }
            case 66: {
                return pSSysUtilDEBase.getUtilPSDE11Id() == null;
            }
            case 67: {
                return pSSysUtilDEBase.getUtilPSDE11Name() == null;
            }
            case 68: {
                return pSSysUtilDEBase.getUtilPSDE12Id() == null;
            }
            case 69: {
                return pSSysUtilDEBase.getUtilPSDE12Name() == null;
            }
            case 70: {
                return pSSysUtilDEBase.getUtilPSDE13Id() == null;
            }
            case 71: {
                return pSSysUtilDEBase.getUtilPSDE13Name() == null;
            }
            case 72: {
                return pSSysUtilDEBase.getUtilPSDE14Id() == null;
            }
            case 73: {
                return pSSysUtilDEBase.getUtilPSDE14Name() == null;
            }
            case 74: {
                return pSSysUtilDEBase.getUtilPSDE15Id() == null;
            }
            case 75: {
                return pSSysUtilDEBase.getUtilPSDE15Name() == null;
            }
            case 76: {
                return pSSysUtilDEBase.getUtilPSDE16Id() == null;
            }
            case 77: {
                return pSSysUtilDEBase.getUtilPSDE16Name() == null;
            }
            case 78: {
                return pSSysUtilDEBase.getUtilPSDE17Id() == null;
            }
            case 79: {
                return pSSysUtilDEBase.getUtilPSDE17Name() == null;
            }
            case 80: {
                return pSSysUtilDEBase.getUtilPSDE18Id() == null;
            }
            case 81: {
                return pSSysUtilDEBase.getUtilPSDE18Name() == null;
            }
            case 82: {
                return pSSysUtilDEBase.getUtilPSDE19Id() == null;
            }
            case 83: {
                return pSSysUtilDEBase.getUtilPSDE19Name() == null;
            }
            case 84: {
                return pSSysUtilDEBase.getUtilPSDE20Id() == null;
            }
            case 85: {
                return pSSysUtilDEBase.getUtilPSDE20Name() == null;
            }
            case 86: {
                return pSSysUtilDEBase.getUtilPSDE2Id() == null;
            }
            case 87: {
                return pSSysUtilDEBase.getUtilPSDE2Name() == null;
            }
            case 88: {
                return pSSysUtilDEBase.getUtilPSDE3Id() == null;
            }
            case 89: {
                return pSSysUtilDEBase.getUtilPSDE3Name() == null;
            }
            case 90: {
                return pSSysUtilDEBase.getUtilPSDE4Id() == null;
            }
            case 91: {
                return pSSysUtilDEBase.getUtilPSDE4Name() == null;
            }
            case 92: {
                return pSSysUtilDEBase.getUtilPSDE5Id() == null;
            }
            case 93: {
                return pSSysUtilDEBase.getUtilPSDE5Name() == null;
            }
            case 94: {
                return pSSysUtilDEBase.getUtilPSDE6Id() == null;
            }
            case 95: {
                return pSSysUtilDEBase.getUtilPSDE6Name() == null;
            }
            case 96: {
                return pSSysUtilDEBase.getUtilPSDE7Id() == null;
            }
            case 97: {
                return pSSysUtilDEBase.getUtilPSDE7Name() == null;
            }
            case 98: {
                return pSSysUtilDEBase.getUtilPSDE8Id() == null;
            }
            case 99: {
                return pSSysUtilDEBase.getUtilPSDE8Name() == null;
            }
            case 100: {
                return pSSysUtilDEBase.getUtilPSDE9Id() == null;
            }
            case 101: {
                return pSSysUtilDEBase.getUtilPSDE9Name() == null;
            }
            case 102: {
                return pSSysUtilDEBase.getUtilPSDEId() == null;
            }
            case 103: {
                return pSSysUtilDEBase.getUtilPSDEName() == null;
            }
            case 104: {
                return pSSysUtilDEBase.getUtilTag() == null;
            }
            case 105: {
                return pSSysUtilDEBase.getUtilTag2() == null;
            }
            case 106: {
                return pSSysUtilDEBase.getUtilType() == null;
            }
            case 107: {
                return pSSysUtilDEBase.getValidFlag() == null;
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
        return PSSysUtilDEBase.contains(this, n);
    }

    private static boolean contains(PSSysUtilDEBase pSSysUtilDEBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysUtilDEBase.isAuthAccessTokenUriDirty();
            }
            case 1: {
                return pSSysUtilDEBase.isAuthClientIdDirty();
            }
            case 2: {
                return pSSysUtilDEBase.isAuthClientSecretDirty();
            }
            case 3: {
                return pSSysUtilDEBase.isAuthModeDirty();
            }
            case 4: {
                return pSSysUtilDEBase.isAuthParamDirty();
            }
            case 5: {
                return pSSysUtilDEBase.isAuthParam2Dirty();
            }
            case 6: {
                return pSSysUtilDEBase.isCodeNameDirty();
            }
            case 7: {
                return pSSysUtilDEBase.isCreateDateDirty();
            }
            case 8: {
                return pSSysUtilDEBase.isCreateManDirty();
            }
            case 9: {
                return pSSysUtilDEBase.isCustomCodeDirty();
            }
            case 10: {
                return pSSysUtilDEBase.isCustomModeDirty();
            }
            case 11: {
                return pSSysUtilDEBase.isInPSSysDataSyncAgentIdDirty();
            }
            case 12: {
                return pSSysUtilDEBase.isInPSSysDataSyncAgentNameDirty();
            }
            case 13: {
                return pSSysUtilDEBase.isMemoDirty();
            }
            case 14: {
                return pSSysUtilDEBase.isOrderValueDirty();
            }
            case 15: {
                return pSSysUtilDEBase.isOutPSSysDataSyncAgentIdDirty();
            }
            case 16: {
                return pSSysUtilDEBase.isOutPSSysDataSyncAgentNameDirty();
            }
            case 17: {
                return pSSysUtilDEBase.isOutPSSysResourceIdDirty();
            }
            case 18: {
                return pSSysUtilDEBase.isOutPSSysResourceNameDirty();
            }
            case 19: {
                return pSSysUtilDEBase.isPSDEGroupIdDirty();
            }
            case 20: {
                return pSSysUtilDEBase.isPSDEGroupNameDirty();
            }
            case 21: {
                return pSSysUtilDEBase.isPSDERGroupIdDirty();
            }
            case 22: {
                return pSSysUtilDEBase.isPSDERGroupNameDirty();
            }
            case 23: {
                return pSSysUtilDEBase.isPSModuleIdDirty();
            }
            case 24: {
                return pSSysUtilDEBase.isPSModuleNameDirty();
            }
            case 25: {
                return pSSysUtilDEBase.isPSSubSysServiceAPIIdDirty();
            }
            case 26: {
                return pSSysUtilDEBase.isPSSubSysServiceAPINameDirty();
            }
            case 27: {
                return pSSysUtilDEBase.isPSSysDynaModelIdDirty();
            }
            case 28: {
                return pSSysUtilDEBase.isPSSysDynaModelNameDirty();
            }
            case 29: {
                return pSSysUtilDEBase.isPSSysModelGroupIdDirty();
            }
            case 30: {
                return pSSysUtilDEBase.isPSSysModelGroupNameDirty();
            }
            case 31: {
                return pSSysUtilDEBase.isPSSysResourceIdDirty();
            }
            case 32: {
                return pSSysUtilDEBase.isPSSysResourceNameDirty();
            }
            case 33: {
                return pSSysUtilDEBase.isPSSysSFPluginIdDirty();
            }
            case 34: {
                return pSSysUtilDEBase.isPSSysSFPluginNameDirty();
            }
            case 35: {
                return pSSysUtilDEBase.isPSSystemIdDirty();
            }
            case 36: {
                return pSSysUtilDEBase.isPSSystemNameDirty();
            }
            case 37: {
                return pSSysUtilDEBase.isPSSysUtilDEIdDirty();
            }
            case 38: {
                return pSSysUtilDEBase.isPSSysUtilDENameDirty();
            }
            case 39: {
                return pSSysUtilDEBase.isServiceParamDirty();
            }
            case 40: {
                return pSSysUtilDEBase.isServiceParam2Dirty();
            }
            case 41: {
                return pSSysUtilDEBase.isServicePathDirty();
            }
            case 42: {
                return pSSysUtilDEBase.isUniqueTagDirty();
            }
            case 43: {
                return pSSysUtilDEBase.isUpdateDateDirty();
            }
            case 44: {
                return pSSysUtilDEBase.isUpdateManDirty();
            }
            case 45: {
                return pSSysUtilDEBase.isUserCatDirty();
            }
            case 46: {
                return pSSysUtilDEBase.isUserTagDirty();
            }
            case 47: {
                return pSSysUtilDEBase.isUserTag2Dirty();
            }
            case 48: {
                return pSSysUtilDEBase.isUserTag3Dirty();
            }
            case 49: {
                return pSSysUtilDEBase.isUserTag4Dirty();
            }
            case 50: {
                return pSSysUtilDEBase.isUtilObjDirty();
            }
            case 51: {
                return pSSysUtilDEBase.isUtilParamDirty();
            }
            case 52: {
                return pSSysUtilDEBase.isUtilParam10Dirty();
            }
            case 53: {
                return pSSysUtilDEBase.isUtilParam11Dirty();
            }
            case 54: {
                return pSSysUtilDEBase.isUtilParam12Dirty();
            }
            case 55: {
                return pSSysUtilDEBase.isUtilParam2Dirty();
            }
            case 56: {
                return pSSysUtilDEBase.isUtilParam3Dirty();
            }
            case 57: {
                return pSSysUtilDEBase.isUtilParam4Dirty();
            }
            case 58: {
                return pSSysUtilDEBase.isUtilParam5Dirty();
            }
            case 59: {
                return pSSysUtilDEBase.isUtilParam6Dirty();
            }
            case 60: {
                return pSSysUtilDEBase.isUtilParam7Dirty();
            }
            case 61: {
                return pSSysUtilDEBase.isUtilParam8Dirty();
            }
            case 62: {
                return pSSysUtilDEBase.isUtilParam9Dirty();
            }
            case 63: {
                return pSSysUtilDEBase.isUtilParamsDirty();
            }
            case 64: {
                return pSSysUtilDEBase.isUtilPSDE10IdDirty();
            }
            case 65: {
                return pSSysUtilDEBase.isUtilPSDE10NameDirty();
            }
            case 66: {
                return pSSysUtilDEBase.isUtilPSDE11IdDirty();
            }
            case 67: {
                return pSSysUtilDEBase.isUtilPSDE11NameDirty();
            }
            case 68: {
                return pSSysUtilDEBase.isUtilPSDE12IdDirty();
            }
            case 69: {
                return pSSysUtilDEBase.isUtilPSDE12NameDirty();
            }
            case 70: {
                return pSSysUtilDEBase.isUtilPSDE13IdDirty();
            }
            case 71: {
                return pSSysUtilDEBase.isUtilPSDE13NameDirty();
            }
            case 72: {
                return pSSysUtilDEBase.isUtilPSDE14IdDirty();
            }
            case 73: {
                return pSSysUtilDEBase.isUtilPSDE14NameDirty();
            }
            case 74: {
                return pSSysUtilDEBase.isUtilPSDE15IdDirty();
            }
            case 75: {
                return pSSysUtilDEBase.isUtilPSDE15NameDirty();
            }
            case 76: {
                return pSSysUtilDEBase.isUtilPSDE16IdDirty();
            }
            case 77: {
                return pSSysUtilDEBase.isUtilPSDE16NameDirty();
            }
            case 78: {
                return pSSysUtilDEBase.isUtilPSDE17IdDirty();
            }
            case 79: {
                return pSSysUtilDEBase.isUtilPSDE17NameDirty();
            }
            case 80: {
                return pSSysUtilDEBase.isUtilPSDE18IdDirty();
            }
            case 81: {
                return pSSysUtilDEBase.isUtilPSDE18NameDirty();
            }
            case 82: {
                return pSSysUtilDEBase.isUtilPSDE19IdDirty();
            }
            case 83: {
                return pSSysUtilDEBase.isUtilPSDE19NameDirty();
            }
            case 84: {
                return pSSysUtilDEBase.isUtilPSDE20IdDirty();
            }
            case 85: {
                return pSSysUtilDEBase.isUtilPSDE20NameDirty();
            }
            case 86: {
                return pSSysUtilDEBase.isUtilPSDE2IdDirty();
            }
            case 87: {
                return pSSysUtilDEBase.isUtilPSDE2NameDirty();
            }
            case 88: {
                return pSSysUtilDEBase.isUtilPSDE3IdDirty();
            }
            case 89: {
                return pSSysUtilDEBase.isUtilPSDE3NameDirty();
            }
            case 90: {
                return pSSysUtilDEBase.isUtilPSDE4IdDirty();
            }
            case 91: {
                return pSSysUtilDEBase.isUtilPSDE4NameDirty();
            }
            case 92: {
                return pSSysUtilDEBase.isUtilPSDE5IdDirty();
            }
            case 93: {
                return pSSysUtilDEBase.isUtilPSDE5NameDirty();
            }
            case 94: {
                return pSSysUtilDEBase.isUtilPSDE6IdDirty();
            }
            case 95: {
                return pSSysUtilDEBase.isUtilPSDE6NameDirty();
            }
            case 96: {
                return pSSysUtilDEBase.isUtilPSDE7IdDirty();
            }
            case 97: {
                return pSSysUtilDEBase.isUtilPSDE7NameDirty();
            }
            case 98: {
                return pSSysUtilDEBase.isUtilPSDE8IdDirty();
            }
            case 99: {
                return pSSysUtilDEBase.isUtilPSDE8NameDirty();
            }
            case 100: {
                return pSSysUtilDEBase.isUtilPSDE9IdDirty();
            }
            case 101: {
                return pSSysUtilDEBase.isUtilPSDE9NameDirty();
            }
            case 102: {
                return pSSysUtilDEBase.isUtilPSDEIdDirty();
            }
            case 103: {
                return pSSysUtilDEBase.isUtilPSDENameDirty();
            }
            case 104: {
                return pSSysUtilDEBase.isUtilTagDirty();
            }
            case 105: {
                return pSSysUtilDEBase.isUtilTag2Dirty();
            }
            case 106: {
                return pSSysUtilDEBase.isUtilTypeDirty();
            }
            case 107: {
                return pSSysUtilDEBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysUtilDEBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysUtilDEBase pSSysUtilDEBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysUtilDEBase.getAuthAccessTokenUri() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authaccesstokenuri", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getAuthAccessTokenUri()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getAuthClientId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authclientid", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getAuthClientId()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getAuthClientSecret() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authclientsecret", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getAuthClientSecret()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getAuthMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authmode", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getAuthMode()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getAuthParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authparam", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getAuthParam()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getAuthParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authparam2", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getAuthParam2()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getCustomMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"custommode", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getCustomMode()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getInPSSysDataSyncAgentId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"inpssysdatasyncagentid", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getInPSSysDataSyncAgentId()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getInPSSysDataSyncAgentName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"inpssysdatasyncagentname", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getInPSSysDataSyncAgentName()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getOutPSSysDataSyncAgentId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"outpssysdatasyncagentid", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getOutPSSysDataSyncAgentId()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getOutPSSysDataSyncAgentName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"outpssysdatasyncagentname", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getOutPSSysDataSyncAgentName()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getOutPSSysResourceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"outpssysresourceid", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getOutPSSysResourceId()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getOutPSSysResourceName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"outpssysresourcename", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getOutPSSysResourceName()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getPSDEGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdegroupid", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getPSDEGroupId()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getPSDEGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdegroupname", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getPSDEGroupName()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getPSDERGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdergroupid", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getPSDERGroupId()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getPSDERGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdergroupname", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getPSDERGroupName()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getPSSubSysServiceAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysserviceapiid", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getPSSubSysServiceAPIId()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getPSSubSysServiceAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysserviceapiname", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getPSSubSysServiceAPIName()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getPSSysModelGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelgroupid", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getPSSysModelGroupId()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getPSSysModelGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelgroupname", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getPSSysModelGroupName()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getPSSysResourceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysresourceid", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getPSSysResourceId()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getPSSysResourceName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysresourcename", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getPSSysResourceName()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getPSSysUtilDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysutildeid", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getPSSysUtilDEId()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getPSSysUtilDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysutildename", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getPSSysUtilDEName()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getServiceParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"serviceparam", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getServiceParam()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getServiceParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"serviceparam2", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getServiceParam2()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getServicePath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"servicepath", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getServicePath()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUniqueTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uniquetag", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUniqueTag()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUtilObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilobj", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUtilObj()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUtilParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilparam", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUtilParam()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUtilParam10() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilparam10", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUtilParam10()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUtilParam11() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilparam11", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUtilParam11()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUtilParam12() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilparam12", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUtilParam12()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUtilParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilparam2", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUtilParam2()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUtilParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilparam3", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUtilParam3()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUtilParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilparam4", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUtilParam4()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUtilParam5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilparam5", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUtilParam5()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUtilParam6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilparam6", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUtilParam6()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUtilParam7() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilparam7", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUtilParam7()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUtilParam8() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilparam8", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUtilParam8()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUtilParam9() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilparam9", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUtilParam9()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUtilParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilparams", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUtilParams()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE10Id() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde10id", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUtilPSDE10Id()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE10Name() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde10name", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUtilPSDE10Name()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE11Id() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde11id", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUtilPSDE11Id()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE11Name() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde11name", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUtilPSDE11Name()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE12Id() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde12id", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUtilPSDE12Id()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE12Name() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde12name", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUtilPSDE12Name()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE13Id() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde13id", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUtilPSDE13Id()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE13Name() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde13name", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUtilPSDE13Name()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE14Id() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde14id", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUtilPSDE14Id()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE14Name() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde14name", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUtilPSDE14Name()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE15Id() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde15id", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUtilPSDE15Id()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE15Name() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde15name", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUtilPSDE15Name()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE16Id() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde16id", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUtilPSDE16Id()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE16Name() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde16name", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUtilPSDE16Name()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE17Id() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde17id", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUtilPSDE17Id()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE17Name() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde17name", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUtilPSDE17Name()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE18Id() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde18id", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUtilPSDE18Id()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE18Name() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde18name", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUtilPSDE18Name()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE19Id() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde19id", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUtilPSDE19Id()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE19Name() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde19name", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUtilPSDE19Name()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE20Id() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde20id", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUtilPSDE20Id()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE20Name() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde20name", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUtilPSDE20Name()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE2Id() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde2id", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUtilPSDE2Id()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE2Name() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde2name", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUtilPSDE2Name()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE3Id() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde3id", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUtilPSDE3Id()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE3Name() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde3name", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUtilPSDE3Name()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE4Id() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde4id", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUtilPSDE4Id()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE4Name() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde4name", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUtilPSDE4Name()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE5Id() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde5id", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUtilPSDE5Id()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE5Name() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde5name", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUtilPSDE5Name()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE6Id() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde6id", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUtilPSDE6Id()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE6Name() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde6name", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUtilPSDE6Name()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE7Id() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde7id", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUtilPSDE7Id()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE7Name() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde7name", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUtilPSDE7Name()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE8Id() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde8id", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUtilPSDE8Id()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE8Name() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde8name", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUtilPSDE8Name()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE9Id() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde9id", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUtilPSDE9Id()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE9Name() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde9name", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUtilPSDE9Name()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsdeid", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUtilPSDEId()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsdename", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUtilPSDEName()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUtilTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utiltag", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUtilTag()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUtilTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utiltag2", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUtilTag2()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getUtilType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utiltype", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getUtilType()), (boolean)false);
        }
        if (bl || pSSysUtilDEBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysUtilDEBase.getJSONValue((Object)pSSysUtilDEBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysUtilDEBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysUtilDEBase pSSysUtilDEBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysUtilDEBase.getAuthAccessTokenUri() != null) {
            object = pSSysUtilDEBase.getAuthAccessTokenUri();
            xmlNode.setAttribute(FIELD_AUTHACCESSTOKENURI, (String)(object == null ? "" : object));
        }
        if (bl || pSSysUtilDEBase.getAuthClientId() != null) {
            object = pSSysUtilDEBase.getAuthClientId();
            xmlNode.setAttribute(FIELD_AUTHCLIENTID, (String)(object == null ? "" : object));
        }
        if (bl || pSSysUtilDEBase.getAuthClientSecret() != null) {
            object = pSSysUtilDEBase.getAuthClientSecret();
            xmlNode.setAttribute(FIELD_AUTHCLIENTSECRET, (String)(object == null ? "" : object));
        }
        if (bl || pSSysUtilDEBase.getAuthMode() != null) {
            object = pSSysUtilDEBase.getAuthMode();
            xmlNode.setAttribute(FIELD_AUTHMODE, (String)(object == null ? "" : object));
        }
        if (bl || pSSysUtilDEBase.getAuthParam() != null) {
            object = pSSysUtilDEBase.getAuthParam();
            xmlNode.setAttribute(FIELD_AUTHPARAM, (String)(object == null ? "" : object));
        }
        if (bl || pSSysUtilDEBase.getAuthParam2() != null) {
            object = pSSysUtilDEBase.getAuthParam2();
            xmlNode.setAttribute(FIELD_AUTHPARAM2, (String)(object == null ? "" : object));
        }
        if (bl || pSSysUtilDEBase.getCodeName() != null) {
            object = pSSysUtilDEBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getCreateDate() != null) {
            object = pSSysUtilDEBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysUtilDEBase.getCreateMan() != null) {
            object = pSSysUtilDEBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getCustomCode() != null) {
            object = pSSysUtilDEBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getCustomMode() != null) {
            object = pSSysUtilDEBase.getCustomMode();
            xmlNode.setAttribute(FIELD_CUSTOMMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysUtilDEBase.getInPSSysDataSyncAgentId() != null) {
            object = pSSysUtilDEBase.getInPSSysDataSyncAgentId();
            xmlNode.setAttribute(FIELD_INPSSYSDATASYNCAGENTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getInPSSysDataSyncAgentName() != null) {
            object = pSSysUtilDEBase.getInPSSysDataSyncAgentName();
            xmlNode.setAttribute(FIELD_INPSSYSDATASYNCAGENTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getMemo() != null) {
            object = pSSysUtilDEBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getOrderValue() != null) {
            object = pSSysUtilDEBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysUtilDEBase.getOutPSSysDataSyncAgentId() != null) {
            object = pSSysUtilDEBase.getOutPSSysDataSyncAgentId();
            xmlNode.setAttribute(FIELD_OUTPSSYSDATASYNCAGENTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getOutPSSysDataSyncAgentName() != null) {
            object = pSSysUtilDEBase.getOutPSSysDataSyncAgentName();
            xmlNode.setAttribute(FIELD_OUTPSSYSDATASYNCAGENTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getOutPSSysResourceId() != null) {
            object = pSSysUtilDEBase.getOutPSSysResourceId();
            xmlNode.setAttribute(FIELD_OUTPSSYSRESOURCEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getOutPSSysResourceName() != null) {
            object = pSSysUtilDEBase.getOutPSSysResourceName();
            xmlNode.setAttribute(FIELD_OUTPSSYSRESOURCENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getPSDEGroupId() != null) {
            object = pSSysUtilDEBase.getPSDEGroupId();
            xmlNode.setAttribute(FIELD_PSDEGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getPSDEGroupName() != null) {
            object = pSSysUtilDEBase.getPSDEGroupName();
            xmlNode.setAttribute(FIELD_PSDEGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getPSDERGroupId() != null) {
            object = pSSysUtilDEBase.getPSDERGroupId();
            xmlNode.setAttribute(FIELD_PSDERGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getPSDERGroupName() != null) {
            object = pSSysUtilDEBase.getPSDERGroupName();
            xmlNode.setAttribute(FIELD_PSDERGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getPSModuleId() != null) {
            object = pSSysUtilDEBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getPSModuleName() != null) {
            object = pSSysUtilDEBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getPSSubSysServiceAPIId() != null) {
            object = pSSysUtilDEBase.getPSSubSysServiceAPIId();
            xmlNode.setAttribute(FIELD_PSSUBSYSSERVICEAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getPSSubSysServiceAPIName() != null) {
            object = pSSysUtilDEBase.getPSSubSysServiceAPIName();
            xmlNode.setAttribute(FIELD_PSSUBSYSSERVICEAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getPSSysDynaModelId() != null) {
            object = pSSysUtilDEBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getPSSysDynaModelName() != null) {
            object = pSSysUtilDEBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getPSSysModelGroupId() != null) {
            object = pSSysUtilDEBase.getPSSysModelGroupId();
            xmlNode.setAttribute(FIELD_PSSYSMODELGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getPSSysModelGroupName() != null) {
            object = pSSysUtilDEBase.getPSSysModelGroupName();
            xmlNode.setAttribute(FIELD_PSSYSMODELGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getPSSysResourceId() != null) {
            object = pSSysUtilDEBase.getPSSysResourceId();
            xmlNode.setAttribute(FIELD_PSSYSRESOURCEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getPSSysResourceName() != null) {
            object = pSSysUtilDEBase.getPSSysResourceName();
            xmlNode.setAttribute(FIELD_PSSYSRESOURCENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getPSSysSFPluginId() != null) {
            object = pSSysUtilDEBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getPSSysSFPluginName() != null) {
            object = pSSysUtilDEBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getPSSystemId() != null) {
            object = pSSysUtilDEBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getPSSystemName() != null) {
            object = pSSysUtilDEBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getPSSysUtilDEId() != null) {
            object = pSSysUtilDEBase.getPSSysUtilDEId();
            xmlNode.setAttribute(FIELD_PSSYSUTILDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getPSSysUtilDEName() != null) {
            object = pSSysUtilDEBase.getPSSysUtilDEName();
            xmlNode.setAttribute(FIELD_PSSYSUTILDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getServiceParam() != null) {
            object = pSSysUtilDEBase.getServiceParam();
            xmlNode.setAttribute(FIELD_SERVICEPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getServiceParam2() != null) {
            object = pSSysUtilDEBase.getServiceParam2();
            xmlNode.setAttribute(FIELD_SERVICEPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getServicePath() != null) {
            object = pSSysUtilDEBase.getServicePath();
            xmlNode.setAttribute(FIELD_SERVICEPATH, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUniqueTag() != null) {
            object = pSSysUtilDEBase.getUniqueTag();
            xmlNode.setAttribute(FIELD_UNIQUETAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUpdateDate() != null) {
            object = pSSysUtilDEBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysUtilDEBase.getUpdateMan() != null) {
            object = pSSysUtilDEBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUserCat() != null) {
            object = pSSysUtilDEBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUserTag() != null) {
            object = pSSysUtilDEBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUserTag2() != null) {
            object = pSSysUtilDEBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUserTag3() != null) {
            object = pSSysUtilDEBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUserTag4() != null) {
            object = pSSysUtilDEBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUtilObj() != null) {
            object = pSSysUtilDEBase.getUtilObj();
            xmlNode.setAttribute(FIELD_UTILOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUtilParam() != null) {
            object = pSSysUtilDEBase.getUtilParam();
            xmlNode.setAttribute(FIELD_UTILPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUtilParam10() != null) {
            object = pSSysUtilDEBase.getUtilParam10();
            xmlNode.setAttribute(FIELD_UTILPARAM10, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysUtilDEBase.getUtilParam11() != null) {
            object = pSSysUtilDEBase.getUtilParam11();
            xmlNode.setAttribute(FIELD_UTILPARAM11, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUtilParam12() != null) {
            object = pSSysUtilDEBase.getUtilParam12();
            xmlNode.setAttribute(FIELD_UTILPARAM12, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUtilParam2() != null) {
            object = pSSysUtilDEBase.getUtilParam2();
            xmlNode.setAttribute(FIELD_UTILPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUtilParam3() != null) {
            object = pSSysUtilDEBase.getUtilParam3();
            xmlNode.setAttribute(FIELD_UTILPARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUtilParam4() != null) {
            object = pSSysUtilDEBase.getUtilParam4();
            xmlNode.setAttribute(FIELD_UTILPARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUtilParam5() != null) {
            object = pSSysUtilDEBase.getUtilParam5();
            xmlNode.setAttribute(FIELD_UTILPARAM5, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysUtilDEBase.getUtilParam6() != null) {
            object = pSSysUtilDEBase.getUtilParam6();
            xmlNode.setAttribute(FIELD_UTILPARAM6, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysUtilDEBase.getUtilParam7() != null) {
            object = pSSysUtilDEBase.getUtilParam7();
            xmlNode.setAttribute(FIELD_UTILPARAM7, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysUtilDEBase.getUtilParam8() != null) {
            object = pSSysUtilDEBase.getUtilParam8();
            xmlNode.setAttribute(FIELD_UTILPARAM8, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysUtilDEBase.getUtilParam9() != null) {
            object = pSSysUtilDEBase.getUtilParam9();
            xmlNode.setAttribute(FIELD_UTILPARAM9, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysUtilDEBase.getUtilParams() != null) {
            object = pSSysUtilDEBase.getUtilParams();
            xmlNode.setAttribute(FIELD_UTILPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE10Id() != null) {
            object = pSSysUtilDEBase.getUtilPSDE10Id();
            xmlNode.setAttribute(FIELD_UTILPSDE10ID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE10Name() != null) {
            object = pSSysUtilDEBase.getUtilPSDE10Name();
            xmlNode.setAttribute(FIELD_UTILPSDE10NAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE11Id() != null) {
            object = pSSysUtilDEBase.getUtilPSDE11Id();
            xmlNode.setAttribute(FIELD_UTILPSDE11ID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE11Name() != null) {
            object = pSSysUtilDEBase.getUtilPSDE11Name();
            xmlNode.setAttribute(FIELD_UTILPSDE11NAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE12Id() != null) {
            object = pSSysUtilDEBase.getUtilPSDE12Id();
            xmlNode.setAttribute(FIELD_UTILPSDE12ID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE12Name() != null) {
            object = pSSysUtilDEBase.getUtilPSDE12Name();
            xmlNode.setAttribute(FIELD_UTILPSDE12NAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE13Id() != null) {
            object = pSSysUtilDEBase.getUtilPSDE13Id();
            xmlNode.setAttribute(FIELD_UTILPSDE13ID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE13Name() != null) {
            object = pSSysUtilDEBase.getUtilPSDE13Name();
            xmlNode.setAttribute(FIELD_UTILPSDE13NAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE14Id() != null) {
            object = pSSysUtilDEBase.getUtilPSDE14Id();
            xmlNode.setAttribute(FIELD_UTILPSDE14ID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE14Name() != null) {
            object = pSSysUtilDEBase.getUtilPSDE14Name();
            xmlNode.setAttribute(FIELD_UTILPSDE14NAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE15Id() != null) {
            object = pSSysUtilDEBase.getUtilPSDE15Id();
            xmlNode.setAttribute(FIELD_UTILPSDE15ID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE15Name() != null) {
            object = pSSysUtilDEBase.getUtilPSDE15Name();
            xmlNode.setAttribute(FIELD_UTILPSDE15NAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE16Id() != null) {
            object = pSSysUtilDEBase.getUtilPSDE16Id();
            xmlNode.setAttribute(FIELD_UTILPSDE16ID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE16Name() != null) {
            object = pSSysUtilDEBase.getUtilPSDE16Name();
            xmlNode.setAttribute(FIELD_UTILPSDE16NAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE17Id() != null) {
            object = pSSysUtilDEBase.getUtilPSDE17Id();
            xmlNode.setAttribute(FIELD_UTILPSDE17ID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE17Name() != null) {
            object = pSSysUtilDEBase.getUtilPSDE17Name();
            xmlNode.setAttribute(FIELD_UTILPSDE17NAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE18Id() != null) {
            object = pSSysUtilDEBase.getUtilPSDE18Id();
            xmlNode.setAttribute(FIELD_UTILPSDE18ID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE18Name() != null) {
            object = pSSysUtilDEBase.getUtilPSDE18Name();
            xmlNode.setAttribute(FIELD_UTILPSDE18NAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE19Id() != null) {
            object = pSSysUtilDEBase.getUtilPSDE19Id();
            xmlNode.setAttribute(FIELD_UTILPSDE19ID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE19Name() != null) {
            object = pSSysUtilDEBase.getUtilPSDE19Name();
            xmlNode.setAttribute(FIELD_UTILPSDE19NAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE20Id() != null) {
            object = pSSysUtilDEBase.getUtilPSDE20Id();
            xmlNode.setAttribute(FIELD_UTILPSDE20ID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE20Name() != null) {
            object = pSSysUtilDEBase.getUtilPSDE20Name();
            xmlNode.setAttribute(FIELD_UTILPSDE20NAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE2Id() != null) {
            object = pSSysUtilDEBase.getUtilPSDE2Id();
            xmlNode.setAttribute(FIELD_UTILPSDE2ID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE2Name() != null) {
            object = pSSysUtilDEBase.getUtilPSDE2Name();
            xmlNode.setAttribute(FIELD_UTILPSDE2NAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE3Id() != null) {
            object = pSSysUtilDEBase.getUtilPSDE3Id();
            xmlNode.setAttribute(FIELD_UTILPSDE3ID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE3Name() != null) {
            object = pSSysUtilDEBase.getUtilPSDE3Name();
            xmlNode.setAttribute(FIELD_UTILPSDE3NAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE4Id() != null) {
            object = pSSysUtilDEBase.getUtilPSDE4Id();
            xmlNode.setAttribute(FIELD_UTILPSDE4ID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE4Name() != null) {
            object = pSSysUtilDEBase.getUtilPSDE4Name();
            xmlNode.setAttribute(FIELD_UTILPSDE4NAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE5Id() != null) {
            object = pSSysUtilDEBase.getUtilPSDE5Id();
            xmlNode.setAttribute(FIELD_UTILPSDE5ID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE5Name() != null) {
            object = pSSysUtilDEBase.getUtilPSDE5Name();
            xmlNode.setAttribute(FIELD_UTILPSDE5NAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE6Id() != null) {
            object = pSSysUtilDEBase.getUtilPSDE6Id();
            xmlNode.setAttribute(FIELD_UTILPSDE6ID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE6Name() != null) {
            object = pSSysUtilDEBase.getUtilPSDE6Name();
            xmlNode.setAttribute(FIELD_UTILPSDE6NAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE7Id() != null) {
            object = pSSysUtilDEBase.getUtilPSDE7Id();
            xmlNode.setAttribute(FIELD_UTILPSDE7ID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE7Name() != null) {
            object = pSSysUtilDEBase.getUtilPSDE7Name();
            xmlNode.setAttribute(FIELD_UTILPSDE7NAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE8Id() != null) {
            object = pSSysUtilDEBase.getUtilPSDE8Id();
            xmlNode.setAttribute(FIELD_UTILPSDE8ID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE8Name() != null) {
            object = pSSysUtilDEBase.getUtilPSDE8Name();
            xmlNode.setAttribute(FIELD_UTILPSDE8NAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE9Id() != null) {
            object = pSSysUtilDEBase.getUtilPSDE9Id();
            xmlNode.setAttribute(FIELD_UTILPSDE9ID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDE9Name() != null) {
            object = pSSysUtilDEBase.getUtilPSDE9Name();
            xmlNode.setAttribute(FIELD_UTILPSDE9NAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDEId() != null) {
            object = pSSysUtilDEBase.getUtilPSDEId();
            xmlNode.setAttribute(FIELD_UTILPSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUtilPSDEName() != null) {
            object = pSSysUtilDEBase.getUtilPSDEName();
            xmlNode.setAttribute(FIELD_UTILPSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUtilTag() != null) {
            object = pSSysUtilDEBase.getUtilTag();
            xmlNode.setAttribute(FIELD_UTILTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUtilTag2() != null) {
            object = pSSysUtilDEBase.getUtilTag2();
            xmlNode.setAttribute(FIELD_UTILTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getUtilType() != null) {
            object = pSSysUtilDEBase.getUtilType();
            xmlNode.setAttribute(FIELD_UTILTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilDEBase.getValidFlag() != null) {
            object = pSSysUtilDEBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysUtilDEBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysUtilDEBase pSSysUtilDEBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysUtilDEBase.isAuthAccessTokenUriDirty() && (bl || pSSysUtilDEBase.getAuthAccessTokenUri() != null)) {
            iDataObject.set(FIELD_AUTHACCESSTOKENURI, (Object)pSSysUtilDEBase.getAuthAccessTokenUri());
        }
        if (pSSysUtilDEBase.isAuthClientIdDirty() && (bl || pSSysUtilDEBase.getAuthClientId() != null)) {
            iDataObject.set(FIELD_AUTHCLIENTID, (Object)pSSysUtilDEBase.getAuthClientId());
        }
        if (pSSysUtilDEBase.isAuthClientSecretDirty() && (bl || pSSysUtilDEBase.getAuthClientSecret() != null)) {
            iDataObject.set(FIELD_AUTHCLIENTSECRET, (Object)pSSysUtilDEBase.getAuthClientSecret());
        }
        if (pSSysUtilDEBase.isAuthModeDirty() && (bl || pSSysUtilDEBase.getAuthMode() != null)) {
            iDataObject.set(FIELD_AUTHMODE, (Object)pSSysUtilDEBase.getAuthMode());
        }
        if (pSSysUtilDEBase.isAuthParamDirty() && (bl || pSSysUtilDEBase.getAuthParam() != null)) {
            iDataObject.set(FIELD_AUTHPARAM, (Object)pSSysUtilDEBase.getAuthParam());
        }
        if (pSSysUtilDEBase.isAuthParam2Dirty() && (bl || pSSysUtilDEBase.getAuthParam2() != null)) {
            iDataObject.set(FIELD_AUTHPARAM2, (Object)pSSysUtilDEBase.getAuthParam2());
        }
        if (pSSysUtilDEBase.isCodeNameDirty() && (bl || pSSysUtilDEBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysUtilDEBase.getCodeName());
        }
        if (pSSysUtilDEBase.isCreateDateDirty() && (bl || pSSysUtilDEBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysUtilDEBase.getCreateDate());
        }
        if (pSSysUtilDEBase.isCreateManDirty() && (bl || pSSysUtilDEBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysUtilDEBase.getCreateMan());
        }
        if (pSSysUtilDEBase.isCustomCodeDirty() && (bl || pSSysUtilDEBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSSysUtilDEBase.getCustomCode());
        }
        if (pSSysUtilDEBase.isCustomModeDirty() && (bl || pSSysUtilDEBase.getCustomMode() != null)) {
            iDataObject.set(FIELD_CUSTOMMODE, (Object)pSSysUtilDEBase.getCustomMode());
        }
        if (pSSysUtilDEBase.isInPSSysDataSyncAgentIdDirty() && (bl || pSSysUtilDEBase.getInPSSysDataSyncAgentId() != null)) {
            iDataObject.set(FIELD_INPSSYSDATASYNCAGENTID, (Object)pSSysUtilDEBase.getInPSSysDataSyncAgentId());
        }
        if (pSSysUtilDEBase.isInPSSysDataSyncAgentNameDirty() && (bl || pSSysUtilDEBase.getInPSSysDataSyncAgentName() != null)) {
            iDataObject.set(FIELD_INPSSYSDATASYNCAGENTNAME, (Object)pSSysUtilDEBase.getInPSSysDataSyncAgentName());
        }
        if (pSSysUtilDEBase.isMemoDirty() && (bl || pSSysUtilDEBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysUtilDEBase.getMemo());
        }
        if (pSSysUtilDEBase.isOrderValueDirty() && (bl || pSSysUtilDEBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysUtilDEBase.getOrderValue());
        }
        if (pSSysUtilDEBase.isOutPSSysDataSyncAgentIdDirty() && (bl || pSSysUtilDEBase.getOutPSSysDataSyncAgentId() != null)) {
            iDataObject.set(FIELD_OUTPSSYSDATASYNCAGENTID, (Object)pSSysUtilDEBase.getOutPSSysDataSyncAgentId());
        }
        if (pSSysUtilDEBase.isOutPSSysDataSyncAgentNameDirty() && (bl || pSSysUtilDEBase.getOutPSSysDataSyncAgentName() != null)) {
            iDataObject.set(FIELD_OUTPSSYSDATASYNCAGENTNAME, (Object)pSSysUtilDEBase.getOutPSSysDataSyncAgentName());
        }
        if (pSSysUtilDEBase.isOutPSSysResourceIdDirty() && (bl || pSSysUtilDEBase.getOutPSSysResourceId() != null)) {
            iDataObject.set(FIELD_OUTPSSYSRESOURCEID, (Object)pSSysUtilDEBase.getOutPSSysResourceId());
        }
        if (pSSysUtilDEBase.isOutPSSysResourceNameDirty() && (bl || pSSysUtilDEBase.getOutPSSysResourceName() != null)) {
            iDataObject.set(FIELD_OUTPSSYSRESOURCENAME, (Object)pSSysUtilDEBase.getOutPSSysResourceName());
        }
        if (pSSysUtilDEBase.isPSDEGroupIdDirty() && (bl || pSSysUtilDEBase.getPSDEGroupId() != null)) {
            iDataObject.set(FIELD_PSDEGROUPID, (Object)pSSysUtilDEBase.getPSDEGroupId());
        }
        if (pSSysUtilDEBase.isPSDEGroupNameDirty() && (bl || pSSysUtilDEBase.getPSDEGroupName() != null)) {
            iDataObject.set(FIELD_PSDEGROUPNAME, (Object)pSSysUtilDEBase.getPSDEGroupName());
        }
        if (pSSysUtilDEBase.isPSDERGroupIdDirty() && (bl || pSSysUtilDEBase.getPSDERGroupId() != null)) {
            iDataObject.set(FIELD_PSDERGROUPID, (Object)pSSysUtilDEBase.getPSDERGroupId());
        }
        if (pSSysUtilDEBase.isPSDERGroupNameDirty() && (bl || pSSysUtilDEBase.getPSDERGroupName() != null)) {
            iDataObject.set(FIELD_PSDERGROUPNAME, (Object)pSSysUtilDEBase.getPSDERGroupName());
        }
        if (pSSysUtilDEBase.isPSModuleIdDirty() && (bl || pSSysUtilDEBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysUtilDEBase.getPSModuleId());
        }
        if (pSSysUtilDEBase.isPSModuleNameDirty() && (bl || pSSysUtilDEBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysUtilDEBase.getPSModuleName());
        }
        if (pSSysUtilDEBase.isPSSubSysServiceAPIIdDirty() && (bl || pSSysUtilDEBase.getPSSubSysServiceAPIId() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSERVICEAPIID, (Object)pSSysUtilDEBase.getPSSubSysServiceAPIId());
        }
        if (pSSysUtilDEBase.isPSSubSysServiceAPINameDirty() && (bl || pSSysUtilDEBase.getPSSubSysServiceAPIName() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSERVICEAPINAME, (Object)pSSysUtilDEBase.getPSSubSysServiceAPIName());
        }
        if (pSSysUtilDEBase.isPSSysDynaModelIdDirty() && (bl || pSSysUtilDEBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSSysUtilDEBase.getPSSysDynaModelId());
        }
        if (pSSysUtilDEBase.isPSSysDynaModelNameDirty() && (bl || pSSysUtilDEBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSSysUtilDEBase.getPSSysDynaModelName());
        }
        if (pSSysUtilDEBase.isPSSysModelGroupIdDirty() && (bl || pSSysUtilDEBase.getPSSysModelGroupId() != null)) {
            iDataObject.set(FIELD_PSSYSMODELGROUPID, (Object)pSSysUtilDEBase.getPSSysModelGroupId());
        }
        if (pSSysUtilDEBase.isPSSysModelGroupNameDirty() && (bl || pSSysUtilDEBase.getPSSysModelGroupName() != null)) {
            iDataObject.set(FIELD_PSSYSMODELGROUPNAME, (Object)pSSysUtilDEBase.getPSSysModelGroupName());
        }
        if (pSSysUtilDEBase.isPSSysResourceIdDirty() && (bl || pSSysUtilDEBase.getPSSysResourceId() != null)) {
            iDataObject.set(FIELD_PSSYSRESOURCEID, (Object)pSSysUtilDEBase.getPSSysResourceId());
        }
        if (pSSysUtilDEBase.isPSSysResourceNameDirty() && (bl || pSSysUtilDEBase.getPSSysResourceName() != null)) {
            iDataObject.set(FIELD_PSSYSRESOURCENAME, (Object)pSSysUtilDEBase.getPSSysResourceName());
        }
        if (pSSysUtilDEBase.isPSSysSFPluginIdDirty() && (bl || pSSysUtilDEBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSSysUtilDEBase.getPSSysSFPluginId());
        }
        if (pSSysUtilDEBase.isPSSysSFPluginNameDirty() && (bl || pSSysUtilDEBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSSysUtilDEBase.getPSSysSFPluginName());
        }
        if (pSSysUtilDEBase.isPSSystemIdDirty() && (bl || pSSysUtilDEBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysUtilDEBase.getPSSystemId());
        }
        if (pSSysUtilDEBase.isPSSystemNameDirty() && (bl || pSSysUtilDEBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysUtilDEBase.getPSSystemName());
        }
        if (pSSysUtilDEBase.isPSSysUtilDEIdDirty() && (bl || pSSysUtilDEBase.getPSSysUtilDEId() != null)) {
            iDataObject.set(FIELD_PSSYSUTILDEID, (Object)pSSysUtilDEBase.getPSSysUtilDEId());
        }
        if (pSSysUtilDEBase.isPSSysUtilDENameDirty() && (bl || pSSysUtilDEBase.getPSSysUtilDEName() != null)) {
            iDataObject.set(FIELD_PSSYSUTILDENAME, (Object)pSSysUtilDEBase.getPSSysUtilDEName());
        }
        if (pSSysUtilDEBase.isServiceParamDirty() && (bl || pSSysUtilDEBase.getServiceParam() != null)) {
            iDataObject.set(FIELD_SERVICEPARAM, (Object)pSSysUtilDEBase.getServiceParam());
        }
        if (pSSysUtilDEBase.isServiceParam2Dirty() && (bl || pSSysUtilDEBase.getServiceParam2() != null)) {
            iDataObject.set(FIELD_SERVICEPARAM2, (Object)pSSysUtilDEBase.getServiceParam2());
        }
        if (pSSysUtilDEBase.isServicePathDirty() && (bl || pSSysUtilDEBase.getServicePath() != null)) {
            iDataObject.set(FIELD_SERVICEPATH, (Object)pSSysUtilDEBase.getServicePath());
        }
        if (pSSysUtilDEBase.isUniqueTagDirty() && (bl || pSSysUtilDEBase.getUniqueTag() != null)) {
            iDataObject.set(FIELD_UNIQUETAG, (Object)pSSysUtilDEBase.getUniqueTag());
        }
        if (pSSysUtilDEBase.isUpdateDateDirty() && (bl || pSSysUtilDEBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysUtilDEBase.getUpdateDate());
        }
        if (pSSysUtilDEBase.isUpdateManDirty() && (bl || pSSysUtilDEBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysUtilDEBase.getUpdateMan());
        }
        if (pSSysUtilDEBase.isUserCatDirty() && (bl || pSSysUtilDEBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysUtilDEBase.getUserCat());
        }
        if (pSSysUtilDEBase.isUserTagDirty() && (bl || pSSysUtilDEBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysUtilDEBase.getUserTag());
        }
        if (pSSysUtilDEBase.isUserTag2Dirty() && (bl || pSSysUtilDEBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysUtilDEBase.getUserTag2());
        }
        if (pSSysUtilDEBase.isUserTag3Dirty() && (bl || pSSysUtilDEBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysUtilDEBase.getUserTag3());
        }
        if (pSSysUtilDEBase.isUserTag4Dirty() && (bl || pSSysUtilDEBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysUtilDEBase.getUserTag4());
        }
        if (pSSysUtilDEBase.isUtilObjDirty() && (bl || pSSysUtilDEBase.getUtilObj() != null)) {
            iDataObject.set(FIELD_UTILOBJ, (Object)pSSysUtilDEBase.getUtilObj());
        }
        if (pSSysUtilDEBase.isUtilParamDirty() && (bl || pSSysUtilDEBase.getUtilParam() != null)) {
            iDataObject.set(FIELD_UTILPARAM, (Object)pSSysUtilDEBase.getUtilParam());
        }
        if (pSSysUtilDEBase.isUtilParam10Dirty() && (bl || pSSysUtilDEBase.getUtilParam10() != null)) {
            iDataObject.set(FIELD_UTILPARAM10, (Object)pSSysUtilDEBase.getUtilParam10());
        }
        if (pSSysUtilDEBase.isUtilParam11Dirty() && (bl || pSSysUtilDEBase.getUtilParam11() != null)) {
            iDataObject.set(FIELD_UTILPARAM11, (Object)pSSysUtilDEBase.getUtilParam11());
        }
        if (pSSysUtilDEBase.isUtilParam12Dirty() && (bl || pSSysUtilDEBase.getUtilParam12() != null)) {
            iDataObject.set(FIELD_UTILPARAM12, (Object)pSSysUtilDEBase.getUtilParam12());
        }
        if (pSSysUtilDEBase.isUtilParam2Dirty() && (bl || pSSysUtilDEBase.getUtilParam2() != null)) {
            iDataObject.set(FIELD_UTILPARAM2, (Object)pSSysUtilDEBase.getUtilParam2());
        }
        if (pSSysUtilDEBase.isUtilParam3Dirty() && (bl || pSSysUtilDEBase.getUtilParam3() != null)) {
            iDataObject.set(FIELD_UTILPARAM3, (Object)pSSysUtilDEBase.getUtilParam3());
        }
        if (pSSysUtilDEBase.isUtilParam4Dirty() && (bl || pSSysUtilDEBase.getUtilParam4() != null)) {
            iDataObject.set(FIELD_UTILPARAM4, (Object)pSSysUtilDEBase.getUtilParam4());
        }
        if (pSSysUtilDEBase.isUtilParam5Dirty() && (bl || pSSysUtilDEBase.getUtilParam5() != null)) {
            iDataObject.set(FIELD_UTILPARAM5, (Object)pSSysUtilDEBase.getUtilParam5());
        }
        if (pSSysUtilDEBase.isUtilParam6Dirty() && (bl || pSSysUtilDEBase.getUtilParam6() != null)) {
            iDataObject.set(FIELD_UTILPARAM6, (Object)pSSysUtilDEBase.getUtilParam6());
        }
        if (pSSysUtilDEBase.isUtilParam7Dirty() && (bl || pSSysUtilDEBase.getUtilParam7() != null)) {
            iDataObject.set(FIELD_UTILPARAM7, (Object)pSSysUtilDEBase.getUtilParam7());
        }
        if (pSSysUtilDEBase.isUtilParam8Dirty() && (bl || pSSysUtilDEBase.getUtilParam8() != null)) {
            iDataObject.set(FIELD_UTILPARAM8, (Object)pSSysUtilDEBase.getUtilParam8());
        }
        if (pSSysUtilDEBase.isUtilParam9Dirty() && (bl || pSSysUtilDEBase.getUtilParam9() != null)) {
            iDataObject.set(FIELD_UTILPARAM9, (Object)pSSysUtilDEBase.getUtilParam9());
        }
        if (pSSysUtilDEBase.isUtilParamsDirty() && (bl || pSSysUtilDEBase.getUtilParams() != null)) {
            iDataObject.set(FIELD_UTILPARAMS, (Object)pSSysUtilDEBase.getUtilParams());
        }
        if (pSSysUtilDEBase.isUtilPSDE10IdDirty() && (bl || pSSysUtilDEBase.getUtilPSDE10Id() != null)) {
            iDataObject.set(FIELD_UTILPSDE10ID, (Object)pSSysUtilDEBase.getUtilPSDE10Id());
        }
        if (pSSysUtilDEBase.isUtilPSDE10NameDirty() && (bl || pSSysUtilDEBase.getUtilPSDE10Name() != null)) {
            iDataObject.set(FIELD_UTILPSDE10NAME, (Object)pSSysUtilDEBase.getUtilPSDE10Name());
        }
        if (pSSysUtilDEBase.isUtilPSDE11IdDirty() && (bl || pSSysUtilDEBase.getUtilPSDE11Id() != null)) {
            iDataObject.set(FIELD_UTILPSDE11ID, (Object)pSSysUtilDEBase.getUtilPSDE11Id());
        }
        if (pSSysUtilDEBase.isUtilPSDE11NameDirty() && (bl || pSSysUtilDEBase.getUtilPSDE11Name() != null)) {
            iDataObject.set(FIELD_UTILPSDE11NAME, (Object)pSSysUtilDEBase.getUtilPSDE11Name());
        }
        if (pSSysUtilDEBase.isUtilPSDE12IdDirty() && (bl || pSSysUtilDEBase.getUtilPSDE12Id() != null)) {
            iDataObject.set(FIELD_UTILPSDE12ID, (Object)pSSysUtilDEBase.getUtilPSDE12Id());
        }
        if (pSSysUtilDEBase.isUtilPSDE12NameDirty() && (bl || pSSysUtilDEBase.getUtilPSDE12Name() != null)) {
            iDataObject.set(FIELD_UTILPSDE12NAME, (Object)pSSysUtilDEBase.getUtilPSDE12Name());
        }
        if (pSSysUtilDEBase.isUtilPSDE13IdDirty() && (bl || pSSysUtilDEBase.getUtilPSDE13Id() != null)) {
            iDataObject.set(FIELD_UTILPSDE13ID, (Object)pSSysUtilDEBase.getUtilPSDE13Id());
        }
        if (pSSysUtilDEBase.isUtilPSDE13NameDirty() && (bl || pSSysUtilDEBase.getUtilPSDE13Name() != null)) {
            iDataObject.set(FIELD_UTILPSDE13NAME, (Object)pSSysUtilDEBase.getUtilPSDE13Name());
        }
        if (pSSysUtilDEBase.isUtilPSDE14IdDirty() && (bl || pSSysUtilDEBase.getUtilPSDE14Id() != null)) {
            iDataObject.set(FIELD_UTILPSDE14ID, (Object)pSSysUtilDEBase.getUtilPSDE14Id());
        }
        if (pSSysUtilDEBase.isUtilPSDE14NameDirty() && (bl || pSSysUtilDEBase.getUtilPSDE14Name() != null)) {
            iDataObject.set(FIELD_UTILPSDE14NAME, (Object)pSSysUtilDEBase.getUtilPSDE14Name());
        }
        if (pSSysUtilDEBase.isUtilPSDE15IdDirty() && (bl || pSSysUtilDEBase.getUtilPSDE15Id() != null)) {
            iDataObject.set(FIELD_UTILPSDE15ID, (Object)pSSysUtilDEBase.getUtilPSDE15Id());
        }
        if (pSSysUtilDEBase.isUtilPSDE15NameDirty() && (bl || pSSysUtilDEBase.getUtilPSDE15Name() != null)) {
            iDataObject.set(FIELD_UTILPSDE15NAME, (Object)pSSysUtilDEBase.getUtilPSDE15Name());
        }
        if (pSSysUtilDEBase.isUtilPSDE16IdDirty() && (bl || pSSysUtilDEBase.getUtilPSDE16Id() != null)) {
            iDataObject.set(FIELD_UTILPSDE16ID, (Object)pSSysUtilDEBase.getUtilPSDE16Id());
        }
        if (pSSysUtilDEBase.isUtilPSDE16NameDirty() && (bl || pSSysUtilDEBase.getUtilPSDE16Name() != null)) {
            iDataObject.set(FIELD_UTILPSDE16NAME, (Object)pSSysUtilDEBase.getUtilPSDE16Name());
        }
        if (pSSysUtilDEBase.isUtilPSDE17IdDirty() && (bl || pSSysUtilDEBase.getUtilPSDE17Id() != null)) {
            iDataObject.set(FIELD_UTILPSDE17ID, (Object)pSSysUtilDEBase.getUtilPSDE17Id());
        }
        if (pSSysUtilDEBase.isUtilPSDE17NameDirty() && (bl || pSSysUtilDEBase.getUtilPSDE17Name() != null)) {
            iDataObject.set(FIELD_UTILPSDE17NAME, (Object)pSSysUtilDEBase.getUtilPSDE17Name());
        }
        if (pSSysUtilDEBase.isUtilPSDE18IdDirty() && (bl || pSSysUtilDEBase.getUtilPSDE18Id() != null)) {
            iDataObject.set(FIELD_UTILPSDE18ID, (Object)pSSysUtilDEBase.getUtilPSDE18Id());
        }
        if (pSSysUtilDEBase.isUtilPSDE18NameDirty() && (bl || pSSysUtilDEBase.getUtilPSDE18Name() != null)) {
            iDataObject.set(FIELD_UTILPSDE18NAME, (Object)pSSysUtilDEBase.getUtilPSDE18Name());
        }
        if (pSSysUtilDEBase.isUtilPSDE19IdDirty() && (bl || pSSysUtilDEBase.getUtilPSDE19Id() != null)) {
            iDataObject.set(FIELD_UTILPSDE19ID, (Object)pSSysUtilDEBase.getUtilPSDE19Id());
        }
        if (pSSysUtilDEBase.isUtilPSDE19NameDirty() && (bl || pSSysUtilDEBase.getUtilPSDE19Name() != null)) {
            iDataObject.set(FIELD_UTILPSDE19NAME, (Object)pSSysUtilDEBase.getUtilPSDE19Name());
        }
        if (pSSysUtilDEBase.isUtilPSDE20IdDirty() && (bl || pSSysUtilDEBase.getUtilPSDE20Id() != null)) {
            iDataObject.set(FIELD_UTILPSDE20ID, (Object)pSSysUtilDEBase.getUtilPSDE20Id());
        }
        if (pSSysUtilDEBase.isUtilPSDE20NameDirty() && (bl || pSSysUtilDEBase.getUtilPSDE20Name() != null)) {
            iDataObject.set(FIELD_UTILPSDE20NAME, (Object)pSSysUtilDEBase.getUtilPSDE20Name());
        }
        if (pSSysUtilDEBase.isUtilPSDE2IdDirty() && (bl || pSSysUtilDEBase.getUtilPSDE2Id() != null)) {
            iDataObject.set(FIELD_UTILPSDE2ID, (Object)pSSysUtilDEBase.getUtilPSDE2Id());
        }
        if (pSSysUtilDEBase.isUtilPSDE2NameDirty() && (bl || pSSysUtilDEBase.getUtilPSDE2Name() != null)) {
            iDataObject.set(FIELD_UTILPSDE2NAME, (Object)pSSysUtilDEBase.getUtilPSDE2Name());
        }
        if (pSSysUtilDEBase.isUtilPSDE3IdDirty() && (bl || pSSysUtilDEBase.getUtilPSDE3Id() != null)) {
            iDataObject.set(FIELD_UTILPSDE3ID, (Object)pSSysUtilDEBase.getUtilPSDE3Id());
        }
        if (pSSysUtilDEBase.isUtilPSDE3NameDirty() && (bl || pSSysUtilDEBase.getUtilPSDE3Name() != null)) {
            iDataObject.set(FIELD_UTILPSDE3NAME, (Object)pSSysUtilDEBase.getUtilPSDE3Name());
        }
        if (pSSysUtilDEBase.isUtilPSDE4IdDirty() && (bl || pSSysUtilDEBase.getUtilPSDE4Id() != null)) {
            iDataObject.set(FIELD_UTILPSDE4ID, (Object)pSSysUtilDEBase.getUtilPSDE4Id());
        }
        if (pSSysUtilDEBase.isUtilPSDE4NameDirty() && (bl || pSSysUtilDEBase.getUtilPSDE4Name() != null)) {
            iDataObject.set(FIELD_UTILPSDE4NAME, (Object)pSSysUtilDEBase.getUtilPSDE4Name());
        }
        if (pSSysUtilDEBase.isUtilPSDE5IdDirty() && (bl || pSSysUtilDEBase.getUtilPSDE5Id() != null)) {
            iDataObject.set(FIELD_UTILPSDE5ID, (Object)pSSysUtilDEBase.getUtilPSDE5Id());
        }
        if (pSSysUtilDEBase.isUtilPSDE5NameDirty() && (bl || pSSysUtilDEBase.getUtilPSDE5Name() != null)) {
            iDataObject.set(FIELD_UTILPSDE5NAME, (Object)pSSysUtilDEBase.getUtilPSDE5Name());
        }
        if (pSSysUtilDEBase.isUtilPSDE6IdDirty() && (bl || pSSysUtilDEBase.getUtilPSDE6Id() != null)) {
            iDataObject.set(FIELD_UTILPSDE6ID, (Object)pSSysUtilDEBase.getUtilPSDE6Id());
        }
        if (pSSysUtilDEBase.isUtilPSDE6NameDirty() && (bl || pSSysUtilDEBase.getUtilPSDE6Name() != null)) {
            iDataObject.set(FIELD_UTILPSDE6NAME, (Object)pSSysUtilDEBase.getUtilPSDE6Name());
        }
        if (pSSysUtilDEBase.isUtilPSDE7IdDirty() && (bl || pSSysUtilDEBase.getUtilPSDE7Id() != null)) {
            iDataObject.set(FIELD_UTILPSDE7ID, (Object)pSSysUtilDEBase.getUtilPSDE7Id());
        }
        if (pSSysUtilDEBase.isUtilPSDE7NameDirty() && (bl || pSSysUtilDEBase.getUtilPSDE7Name() != null)) {
            iDataObject.set(FIELD_UTILPSDE7NAME, (Object)pSSysUtilDEBase.getUtilPSDE7Name());
        }
        if (pSSysUtilDEBase.isUtilPSDE8IdDirty() && (bl || pSSysUtilDEBase.getUtilPSDE8Id() != null)) {
            iDataObject.set(FIELD_UTILPSDE8ID, (Object)pSSysUtilDEBase.getUtilPSDE8Id());
        }
        if (pSSysUtilDEBase.isUtilPSDE8NameDirty() && (bl || pSSysUtilDEBase.getUtilPSDE8Name() != null)) {
            iDataObject.set(FIELD_UTILPSDE8NAME, (Object)pSSysUtilDEBase.getUtilPSDE8Name());
        }
        if (pSSysUtilDEBase.isUtilPSDE9IdDirty() && (bl || pSSysUtilDEBase.getUtilPSDE9Id() != null)) {
            iDataObject.set(FIELD_UTILPSDE9ID, (Object)pSSysUtilDEBase.getUtilPSDE9Id());
        }
        if (pSSysUtilDEBase.isUtilPSDE9NameDirty() && (bl || pSSysUtilDEBase.getUtilPSDE9Name() != null)) {
            iDataObject.set(FIELD_UTILPSDE9NAME, (Object)pSSysUtilDEBase.getUtilPSDE9Name());
        }
        if (pSSysUtilDEBase.isUtilPSDEIdDirty() && (bl || pSSysUtilDEBase.getUtilPSDEId() != null)) {
            iDataObject.set(FIELD_UTILPSDEID, (Object)pSSysUtilDEBase.getUtilPSDEId());
        }
        if (pSSysUtilDEBase.isUtilPSDENameDirty() && (bl || pSSysUtilDEBase.getUtilPSDEName() != null)) {
            iDataObject.set(FIELD_UTILPSDENAME, (Object)pSSysUtilDEBase.getUtilPSDEName());
        }
        if (pSSysUtilDEBase.isUtilTagDirty() && (bl || pSSysUtilDEBase.getUtilTag() != null)) {
            iDataObject.set(FIELD_UTILTAG, (Object)pSSysUtilDEBase.getUtilTag());
        }
        if (pSSysUtilDEBase.isUtilTag2Dirty() && (bl || pSSysUtilDEBase.getUtilTag2() != null)) {
            iDataObject.set(FIELD_UTILTAG2, (Object)pSSysUtilDEBase.getUtilTag2());
        }
        if (pSSysUtilDEBase.isUtilTypeDirty() && (bl || pSSysUtilDEBase.getUtilType() != null)) {
            iDataObject.set(FIELD_UTILTYPE, (Object)pSSysUtilDEBase.getUtilType());
        }
        if (pSSysUtilDEBase.isValidFlagDirty() && (bl || pSSysUtilDEBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysUtilDEBase.getValidFlag());
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
        return PSSysUtilDEBase.remove(this, n);
    }

    private static boolean remove(PSSysUtilDEBase pSSysUtilDEBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysUtilDEBase.resetAuthAccessTokenUri();
                return true;
            }
            case 1: {
                pSSysUtilDEBase.resetAuthClientId();
                return true;
            }
            case 2: {
                pSSysUtilDEBase.resetAuthClientSecret();
                return true;
            }
            case 3: {
                pSSysUtilDEBase.resetAuthMode();
                return true;
            }
            case 4: {
                pSSysUtilDEBase.resetAuthParam();
                return true;
            }
            case 5: {
                pSSysUtilDEBase.resetAuthParam2();
                return true;
            }
            case 6: {
                pSSysUtilDEBase.resetCodeName();
                return true;
            }
            case 7: {
                pSSysUtilDEBase.resetCreateDate();
                return true;
            }
            case 8: {
                pSSysUtilDEBase.resetCreateMan();
                return true;
            }
            case 9: {
                pSSysUtilDEBase.resetCustomCode();
                return true;
            }
            case 10: {
                pSSysUtilDEBase.resetCustomMode();
                return true;
            }
            case 11: {
                pSSysUtilDEBase.resetInPSSysDataSyncAgentId();
                return true;
            }
            case 12: {
                pSSysUtilDEBase.resetInPSSysDataSyncAgentName();
                return true;
            }
            case 13: {
                pSSysUtilDEBase.resetMemo();
                return true;
            }
            case 14: {
                pSSysUtilDEBase.resetOrderValue();
                return true;
            }
            case 15: {
                pSSysUtilDEBase.resetOutPSSysDataSyncAgentId();
                return true;
            }
            case 16: {
                pSSysUtilDEBase.resetOutPSSysDataSyncAgentName();
                return true;
            }
            case 17: {
                pSSysUtilDEBase.resetOutPSSysResourceId();
                return true;
            }
            case 18: {
                pSSysUtilDEBase.resetOutPSSysResourceName();
                return true;
            }
            case 19: {
                pSSysUtilDEBase.resetPSDEGroupId();
                return true;
            }
            case 20: {
                pSSysUtilDEBase.resetPSDEGroupName();
                return true;
            }
            case 21: {
                pSSysUtilDEBase.resetPSDERGroupId();
                return true;
            }
            case 22: {
                pSSysUtilDEBase.resetPSDERGroupName();
                return true;
            }
            case 23: {
                pSSysUtilDEBase.resetPSModuleId();
                return true;
            }
            case 24: {
                pSSysUtilDEBase.resetPSModuleName();
                return true;
            }
            case 25: {
                pSSysUtilDEBase.resetPSSubSysServiceAPIId();
                return true;
            }
            case 26: {
                pSSysUtilDEBase.resetPSSubSysServiceAPIName();
                return true;
            }
            case 27: {
                pSSysUtilDEBase.resetPSSysDynaModelId();
                return true;
            }
            case 28: {
                pSSysUtilDEBase.resetPSSysDynaModelName();
                return true;
            }
            case 29: {
                pSSysUtilDEBase.resetPSSysModelGroupId();
                return true;
            }
            case 30: {
                pSSysUtilDEBase.resetPSSysModelGroupName();
                return true;
            }
            case 31: {
                pSSysUtilDEBase.resetPSSysResourceId();
                return true;
            }
            case 32: {
                pSSysUtilDEBase.resetPSSysResourceName();
                return true;
            }
            case 33: {
                pSSysUtilDEBase.resetPSSysSFPluginId();
                return true;
            }
            case 34: {
                pSSysUtilDEBase.resetPSSysSFPluginName();
                return true;
            }
            case 35: {
                pSSysUtilDEBase.resetPSSystemId();
                return true;
            }
            case 36: {
                pSSysUtilDEBase.resetPSSystemName();
                return true;
            }
            case 37: {
                pSSysUtilDEBase.resetPSSysUtilDEId();
                return true;
            }
            case 38: {
                pSSysUtilDEBase.resetPSSysUtilDEName();
                return true;
            }
            case 39: {
                pSSysUtilDEBase.resetServiceParam();
                return true;
            }
            case 40: {
                pSSysUtilDEBase.resetServiceParam2();
                return true;
            }
            case 41: {
                pSSysUtilDEBase.resetServicePath();
                return true;
            }
            case 42: {
                pSSysUtilDEBase.resetUniqueTag();
                return true;
            }
            case 43: {
                pSSysUtilDEBase.resetUpdateDate();
                return true;
            }
            case 44: {
                pSSysUtilDEBase.resetUpdateMan();
                return true;
            }
            case 45: {
                pSSysUtilDEBase.resetUserCat();
                return true;
            }
            case 46: {
                pSSysUtilDEBase.resetUserTag();
                return true;
            }
            case 47: {
                pSSysUtilDEBase.resetUserTag2();
                return true;
            }
            case 48: {
                pSSysUtilDEBase.resetUserTag3();
                return true;
            }
            case 49: {
                pSSysUtilDEBase.resetUserTag4();
                return true;
            }
            case 50: {
                pSSysUtilDEBase.resetUtilObj();
                return true;
            }
            case 51: {
                pSSysUtilDEBase.resetUtilParam();
                return true;
            }
            case 52: {
                pSSysUtilDEBase.resetUtilParam10();
                return true;
            }
            case 53: {
                pSSysUtilDEBase.resetUtilParam11();
                return true;
            }
            case 54: {
                pSSysUtilDEBase.resetUtilParam12();
                return true;
            }
            case 55: {
                pSSysUtilDEBase.resetUtilParam2();
                return true;
            }
            case 56: {
                pSSysUtilDEBase.resetUtilParam3();
                return true;
            }
            case 57: {
                pSSysUtilDEBase.resetUtilParam4();
                return true;
            }
            case 58: {
                pSSysUtilDEBase.resetUtilParam5();
                return true;
            }
            case 59: {
                pSSysUtilDEBase.resetUtilParam6();
                return true;
            }
            case 60: {
                pSSysUtilDEBase.resetUtilParam7();
                return true;
            }
            case 61: {
                pSSysUtilDEBase.resetUtilParam8();
                return true;
            }
            case 62: {
                pSSysUtilDEBase.resetUtilParam9();
                return true;
            }
            case 63: {
                pSSysUtilDEBase.resetUtilParams();
                return true;
            }
            case 64: {
                pSSysUtilDEBase.resetUtilPSDE10Id();
                return true;
            }
            case 65: {
                pSSysUtilDEBase.resetUtilPSDE10Name();
                return true;
            }
            case 66: {
                pSSysUtilDEBase.resetUtilPSDE11Id();
                return true;
            }
            case 67: {
                pSSysUtilDEBase.resetUtilPSDE11Name();
                return true;
            }
            case 68: {
                pSSysUtilDEBase.resetUtilPSDE12Id();
                return true;
            }
            case 69: {
                pSSysUtilDEBase.resetUtilPSDE12Name();
                return true;
            }
            case 70: {
                pSSysUtilDEBase.resetUtilPSDE13Id();
                return true;
            }
            case 71: {
                pSSysUtilDEBase.resetUtilPSDE13Name();
                return true;
            }
            case 72: {
                pSSysUtilDEBase.resetUtilPSDE14Id();
                return true;
            }
            case 73: {
                pSSysUtilDEBase.resetUtilPSDE14Name();
                return true;
            }
            case 74: {
                pSSysUtilDEBase.resetUtilPSDE15Id();
                return true;
            }
            case 75: {
                pSSysUtilDEBase.resetUtilPSDE15Name();
                return true;
            }
            case 76: {
                pSSysUtilDEBase.resetUtilPSDE16Id();
                return true;
            }
            case 77: {
                pSSysUtilDEBase.resetUtilPSDE16Name();
                return true;
            }
            case 78: {
                pSSysUtilDEBase.resetUtilPSDE17Id();
                return true;
            }
            case 79: {
                pSSysUtilDEBase.resetUtilPSDE17Name();
                return true;
            }
            case 80: {
                pSSysUtilDEBase.resetUtilPSDE18Id();
                return true;
            }
            case 81: {
                pSSysUtilDEBase.resetUtilPSDE18Name();
                return true;
            }
            case 82: {
                pSSysUtilDEBase.resetUtilPSDE19Id();
                return true;
            }
            case 83: {
                pSSysUtilDEBase.resetUtilPSDE19Name();
                return true;
            }
            case 84: {
                pSSysUtilDEBase.resetUtilPSDE20Id();
                return true;
            }
            case 85: {
                pSSysUtilDEBase.resetUtilPSDE20Name();
                return true;
            }
            case 86: {
                pSSysUtilDEBase.resetUtilPSDE2Id();
                return true;
            }
            case 87: {
                pSSysUtilDEBase.resetUtilPSDE2Name();
                return true;
            }
            case 88: {
                pSSysUtilDEBase.resetUtilPSDE3Id();
                return true;
            }
            case 89: {
                pSSysUtilDEBase.resetUtilPSDE3Name();
                return true;
            }
            case 90: {
                pSSysUtilDEBase.resetUtilPSDE4Id();
                return true;
            }
            case 91: {
                pSSysUtilDEBase.resetUtilPSDE4Name();
                return true;
            }
            case 92: {
                pSSysUtilDEBase.resetUtilPSDE5Id();
                return true;
            }
            case 93: {
                pSSysUtilDEBase.resetUtilPSDE5Name();
                return true;
            }
            case 94: {
                pSSysUtilDEBase.resetUtilPSDE6Id();
                return true;
            }
            case 95: {
                pSSysUtilDEBase.resetUtilPSDE6Name();
                return true;
            }
            case 96: {
                pSSysUtilDEBase.resetUtilPSDE7Id();
                return true;
            }
            case 97: {
                pSSysUtilDEBase.resetUtilPSDE7Name();
                return true;
            }
            case 98: {
                pSSysUtilDEBase.resetUtilPSDE8Id();
                return true;
            }
            case 99: {
                pSSysUtilDEBase.resetUtilPSDE8Name();
                return true;
            }
            case 100: {
                pSSysUtilDEBase.resetUtilPSDE9Id();
                return true;
            }
            case 101: {
                pSSysUtilDEBase.resetUtilPSDE9Name();
                return true;
            }
            case 102: {
                pSSysUtilDEBase.resetUtilPSDEId();
                return true;
            }
            case 103: {
                pSSysUtilDEBase.resetUtilPSDEName();
                return true;
            }
            case 104: {
                pSSysUtilDEBase.resetUtilTag();
                return true;
            }
            case 105: {
                pSSysUtilDEBase.resetUtilTag2();
                return true;
            }
            case 106: {
                pSSysUtilDEBase.resetUtilType();
                return true;
            }
            case 107: {
                pSSysUtilDEBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getUtilPSDE10() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE10();
        }
        if (this.getUtilPSDE10Id() == null) {
            return null;
        }
        Integer n = this.objUtilPSDE10Lock;
        synchronized (n) {
            if (this.utilpsde10 != null && DataTypeHelper.compare((int)25, (Object)this.getUtilPSDE10Id(), (Object)this.utilpsde10.getPSDataEntityId()) != 0L) {
                this.utilpsde10 = null;
            }
            if (this.utilpsde10 == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getUtilPSDE10Id());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.utilpsde10 = pSDataEntity;
            }
            return this.utilpsde10;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getUtilPSDE11() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE11();
        }
        if (this.getUtilPSDE11Id() == null) {
            return null;
        }
        Integer n = this.objUtilPSDE11Lock;
        synchronized (n) {
            if (this.utilpsde11 != null && DataTypeHelper.compare((int)25, (Object)this.getUtilPSDE11Id(), (Object)this.utilpsde11.getPSDataEntityId()) != 0L) {
                this.utilpsde11 = null;
            }
            if (this.utilpsde11 == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getUtilPSDE11Id());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.utilpsde11 = pSDataEntity;
            }
            return this.utilpsde11;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getUtilPSDE12() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE12();
        }
        if (this.getUtilPSDE12Id() == null) {
            return null;
        }
        Integer n = this.objUtilPSDE12Lock;
        synchronized (n) {
            if (this.utilpsde12 != null && DataTypeHelper.compare((int)25, (Object)this.getUtilPSDE12Id(), (Object)this.utilpsde12.getPSDataEntityId()) != 0L) {
                this.utilpsde12 = null;
            }
            if (this.utilpsde12 == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getUtilPSDE12Id());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.utilpsde12 = pSDataEntity;
            }
            return this.utilpsde12;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getUtilPSDE13() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE13();
        }
        if (this.getUtilPSDE13Id() == null) {
            return null;
        }
        Integer n = this.objUtilPSDE13Lock;
        synchronized (n) {
            if (this.utilpsde13 != null && DataTypeHelper.compare((int)25, (Object)this.getUtilPSDE13Id(), (Object)this.utilpsde13.getPSDataEntityId()) != 0L) {
                this.utilpsde13 = null;
            }
            if (this.utilpsde13 == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getUtilPSDE13Id());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.utilpsde13 = pSDataEntity;
            }
            return this.utilpsde13;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getUtilPSDE14() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE14();
        }
        if (this.getUtilPSDE14Id() == null) {
            return null;
        }
        Integer n = this.objUtilPSDE14Lock;
        synchronized (n) {
            if (this.utilpsde14 != null && DataTypeHelper.compare((int)25, (Object)this.getUtilPSDE14Id(), (Object)this.utilpsde14.getPSDataEntityId()) != 0L) {
                this.utilpsde14 = null;
            }
            if (this.utilpsde14 == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getUtilPSDE14Id());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.utilpsde14 = pSDataEntity;
            }
            return this.utilpsde14;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getUtilPSDE15() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE15();
        }
        if (this.getUtilPSDE15Id() == null) {
            return null;
        }
        Integer n = this.objUtilPSDE15Lock;
        synchronized (n) {
            if (this.utilpsde15 != null && DataTypeHelper.compare((int)25, (Object)this.getUtilPSDE15Id(), (Object)this.utilpsde15.getPSDataEntityId()) != 0L) {
                this.utilpsde15 = null;
            }
            if (this.utilpsde15 == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getUtilPSDE15Id());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.utilpsde15 = pSDataEntity;
            }
            return this.utilpsde15;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getUtilPSDE16() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE16();
        }
        if (this.getUtilPSDE16Id() == null) {
            return null;
        }
        Integer n = this.objUtilPSDE16Lock;
        synchronized (n) {
            if (this.utilpsde16 != null && DataTypeHelper.compare((int)25, (Object)this.getUtilPSDE16Id(), (Object)this.utilpsde16.getPSDataEntityId()) != 0L) {
                this.utilpsde16 = null;
            }
            if (this.utilpsde16 == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getUtilPSDE16Id());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.utilpsde16 = pSDataEntity;
            }
            return this.utilpsde16;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getUtilPSDE17() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE17();
        }
        if (this.getUtilPSDE17Id() == null) {
            return null;
        }
        Integer n = this.objUtilPSDE17Lock;
        synchronized (n) {
            if (this.utilpsde17 != null && DataTypeHelper.compare((int)25, (Object)this.getUtilPSDE17Id(), (Object)this.utilpsde17.getPSDataEntityId()) != 0L) {
                this.utilpsde17 = null;
            }
            if (this.utilpsde17 == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getUtilPSDE17Id());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.utilpsde17 = pSDataEntity;
            }
            return this.utilpsde17;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getUtilPSDE18() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE18();
        }
        if (this.getUtilPSDE18Id() == null) {
            return null;
        }
        Integer n = this.objUtilPSDE18Lock;
        synchronized (n) {
            if (this.utilpsde18 != null && DataTypeHelper.compare((int)25, (Object)this.getUtilPSDE18Id(), (Object)this.utilpsde18.getPSDataEntityId()) != 0L) {
                this.utilpsde18 = null;
            }
            if (this.utilpsde18 == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getUtilPSDE18Id());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.utilpsde18 = pSDataEntity;
            }
            return this.utilpsde18;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getUtilPSDE19() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE19();
        }
        if (this.getUtilPSDE19Id() == null) {
            return null;
        }
        Integer n = this.objUtilPSDE19Lock;
        synchronized (n) {
            if (this.utilpsde19 != null && DataTypeHelper.compare((int)25, (Object)this.getUtilPSDE19Id(), (Object)this.utilpsde19.getPSDataEntityId()) != 0L) {
                this.utilpsde19 = null;
            }
            if (this.utilpsde19 == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getUtilPSDE19Id());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.utilpsde19 = pSDataEntity;
            }
            return this.utilpsde19;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getUtilPSDE20() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE20();
        }
        if (this.getUtilPSDE20Id() == null) {
            return null;
        }
        Integer n = this.objUtilPSDE20Lock;
        synchronized (n) {
            if (this.utilpsde20 != null && DataTypeHelper.compare((int)25, (Object)this.getUtilPSDE20Id(), (Object)this.utilpsde20.getPSDataEntityId()) != 0L) {
                this.utilpsde20 = null;
            }
            if (this.utilpsde20 == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getUtilPSDE20Id());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.utilpsde20 = pSDataEntity;
            }
            return this.utilpsde20;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getUtilPSDE2() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE2();
        }
        if (this.getUtilPSDE2Id() == null) {
            return null;
        }
        Integer n = this.objUtilPSDE2Lock;
        synchronized (n) {
            if (this.utilpsde2 != null && DataTypeHelper.compare((int)25, (Object)this.getUtilPSDE2Id(), (Object)this.utilpsde2.getPSDataEntityId()) != 0L) {
                this.utilpsde2 = null;
            }
            if (this.utilpsde2 == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getUtilPSDE2Id());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.utilpsde2 = pSDataEntity;
            }
            return this.utilpsde2;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getUtilPSDE3() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE3();
        }
        if (this.getUtilPSDE3Id() == null) {
            return null;
        }
        Integer n = this.objUtilPSDE3Lock;
        synchronized (n) {
            if (this.utilpsde3 != null && DataTypeHelper.compare((int)25, (Object)this.getUtilPSDE3Id(), (Object)this.utilpsde3.getPSDataEntityId()) != 0L) {
                this.utilpsde3 = null;
            }
            if (this.utilpsde3 == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getUtilPSDE3Id());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.utilpsde3 = pSDataEntity;
            }
            return this.utilpsde3;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getUtilPSDE4() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE4();
        }
        if (this.getUtilPSDE4Id() == null) {
            return null;
        }
        Integer n = this.objUtilPSDE4Lock;
        synchronized (n) {
            if (this.utilpsde4 != null && DataTypeHelper.compare((int)25, (Object)this.getUtilPSDE4Id(), (Object)this.utilpsde4.getPSDataEntityId()) != 0L) {
                this.utilpsde4 = null;
            }
            if (this.utilpsde4 == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getUtilPSDE4Id());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.utilpsde4 = pSDataEntity;
            }
            return this.utilpsde4;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getUtilPSDE5() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE5();
        }
        if (this.getUtilPSDE5Id() == null) {
            return null;
        }
        Integer n = this.objUtilPSDE5Lock;
        synchronized (n) {
            if (this.utilpsde5 != null && DataTypeHelper.compare((int)25, (Object)this.getUtilPSDE5Id(), (Object)this.utilpsde5.getPSDataEntityId()) != 0L) {
                this.utilpsde5 = null;
            }
            if (this.utilpsde5 == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getUtilPSDE5Id());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.utilpsde5 = pSDataEntity;
            }
            return this.utilpsde5;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getUtilPSDE6() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE6();
        }
        if (this.getUtilPSDE6Id() == null) {
            return null;
        }
        Integer n = this.objUtilPSDE6Lock;
        synchronized (n) {
            if (this.utilpsde6 != null && DataTypeHelper.compare((int)25, (Object)this.getUtilPSDE6Id(), (Object)this.utilpsde6.getPSDataEntityId()) != 0L) {
                this.utilpsde6 = null;
            }
            if (this.utilpsde6 == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getUtilPSDE6Id());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.utilpsde6 = pSDataEntity;
            }
            return this.utilpsde6;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getUtilPSDE7() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE7();
        }
        if (this.getUtilPSDE7Id() == null) {
            return null;
        }
        Integer n = this.objUtilPSDE7Lock;
        synchronized (n) {
            if (this.utilpsde7 != null && DataTypeHelper.compare((int)25, (Object)this.getUtilPSDE7Id(), (Object)this.utilpsde7.getPSDataEntityId()) != 0L) {
                this.utilpsde7 = null;
            }
            if (this.utilpsde7 == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getUtilPSDE7Id());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.utilpsde7 = pSDataEntity;
            }
            return this.utilpsde7;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getUtilPSDE8() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE8();
        }
        if (this.getUtilPSDE8Id() == null) {
            return null;
        }
        Integer n = this.objUtilPSDE8Lock;
        synchronized (n) {
            if (this.utilpsde8 != null && DataTypeHelper.compare((int)25, (Object)this.getUtilPSDE8Id(), (Object)this.utilpsde8.getPSDataEntityId()) != 0L) {
                this.utilpsde8 = null;
            }
            if (this.utilpsde8 == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getUtilPSDE8Id());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.utilpsde8 = pSDataEntity;
            }
            return this.utilpsde8;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getUtilPSDE9() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE9();
        }
        if (this.getUtilPSDE9Id() == null) {
            return null;
        }
        Integer n = this.objUtilPSDE9Lock;
        synchronized (n) {
            if (this.utilpsde9 != null && DataTypeHelper.compare((int)25, (Object)this.getUtilPSDE9Id(), (Object)this.utilpsde9.getPSDataEntityId()) != 0L) {
                this.utilpsde9 = null;
            }
            if (this.utilpsde9 == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getUtilPSDE9Id());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.utilpsde9 = pSDataEntity;
            }
            return this.utilpsde9;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getUtilPSDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE();
        }
        if (this.getUtilPSDEId() == null) {
            return null;
        }
        Integer n = this.objUtilPSDELock;
        synchronized (n) {
            if (this.utilpsde != null && DataTypeHelper.compare((int)25, (Object)this.getUtilPSDEId(), (Object)this.utilpsde.getPSDataEntityId()) != 0L) {
                this.utilpsde = null;
            }
            if (this.utilpsde == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getUtilPSDEId());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.utilpsde = pSDataEntity;
            }
            return this.utilpsde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEGroup getPSDEGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGroup();
        }
        if (this.getPSDEGroupId() == null) {
            return null;
        }
        Integer n = this.objPSDEGroupLock;
        synchronized (n) {
            if (this.psdegroup != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEGroupId(), (Object)this.psdegroup.getPSDEGroupId()) != 0L) {
                this.psdegroup = null;
            }
            if (this.psdegroup == null) {
                PSDEGroup pSDEGroup = new PSDEGroup();
                pSDEGroup.setPSDEGroupId(this.getPSDEGroupId());
                PSDEGroupService pSDEGroupService = (PSDEGroupService)ServiceGlobal.getService(PSDEGroupService.class, (SessionFactory)this.getSessionFactory());
                pSDEGroupService.autoGet(pSDEGroup);
                this.psdegroup = pSDEGroup;
            }
            return this.psdegroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDERGroup getPSDERGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDERGroup();
        }
        if (this.getPSDERGroupId() == null) {
            return null;
        }
        Integer n = this.objPSDERGroupLock;
        synchronized (n) {
            if (this.psdergroup != null && DataTypeHelper.compare((int)25, (Object)this.getPSDERGroupId(), (Object)this.psdergroup.getPSDERGroupId()) != 0L) {
                this.psdergroup = null;
            }
            if (this.psdergroup == null) {
                PSDERGroup pSDERGroup = new PSDERGroup();
                pSDERGroup.setPSDERGroupId(this.getPSDERGroupId());
                PSDERGroupService pSDERGroupService = (PSDERGroupService)ServiceGlobal.getService(PSDERGroupService.class, (SessionFactory)this.getSessionFactory());
                pSDERGroupService.autoGet(pSDERGroup);
                this.psdergroup = pSDERGroup;
            }
            return this.psdergroup;
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
    public PSSubSysServiceAPI getPSSubSysServiceAPI() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysServiceAPI();
        }
        if (this.getPSSubSysServiceAPIId() == null) {
            return null;
        }
        Integer n = this.objPSSubSysServiceAPILock;
        synchronized (n) {
            if (this.pssubsysserviceapi != null && DataTypeHelper.compare((int)25, (Object)this.getPSSubSysServiceAPIId(), (Object)this.pssubsysserviceapi.getPSSubSysServiceAPIId()) != 0L) {
                this.pssubsysserviceapi = null;
            }
            if (this.pssubsysserviceapi == null) {
                PSSubSysServiceAPI pSSubSysServiceAPI = new PSSubSysServiceAPI();
                pSSubSysServiceAPI.setPSSubSysServiceAPIId(this.getPSSubSysServiceAPIId());
                PSSubSysServiceAPIService pSSubSysServiceAPIService = (PSSubSysServiceAPIService)ServiceGlobal.getService(PSSubSysServiceAPIService.class, (SessionFactory)this.getSessionFactory());
                pSSubSysServiceAPIService.autoGet(pSSubSysServiceAPI);
                this.pssubsysserviceapi = pSSubSysServiceAPI;
            }
            return this.pssubsysserviceapi;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDataSyncAgent getInPSSysDataSyncAgent() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInPSSysDataSyncAgent();
        }
        if (this.getInPSSysDataSyncAgentId() == null) {
            return null;
        }
        Integer n = this.objInPSSysDataSyncAgentLock;
        synchronized (n) {
            if (this.inpssysdatasyncagent != null && DataTypeHelper.compare((int)25, (Object)this.getInPSSysDataSyncAgentId(), (Object)this.inpssysdatasyncagent.getPSSysDataSyncAgentId()) != 0L) {
                this.inpssysdatasyncagent = null;
            }
            if (this.inpssysdatasyncagent == null) {
                PSSysDataSyncAgent pSSysDataSyncAgent = new PSSysDataSyncAgent();
                pSSysDataSyncAgent.setPSSysDataSyncAgentId(this.getInPSSysDataSyncAgentId());
                PSSysDataSyncAgentService pSSysDataSyncAgentService = (PSSysDataSyncAgentService)ServiceGlobal.getService(PSSysDataSyncAgentService.class, (SessionFactory)this.getSessionFactory());
                pSSysDataSyncAgentService.autoGet(pSSysDataSyncAgent);
                this.inpssysdatasyncagent = pSSysDataSyncAgent;
            }
            return this.inpssysdatasyncagent;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDataSyncAgent getOutPSSysDataSyncAgent() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOutPSSysDataSyncAgent();
        }
        if (this.getOutPSSysDataSyncAgentId() == null) {
            return null;
        }
        Integer n = this.objOutPSSysDataSyncAgentLock;
        synchronized (n) {
            if (this.outpssysdatasyncagent != null && DataTypeHelper.compare((int)25, (Object)this.getOutPSSysDataSyncAgentId(), (Object)this.outpssysdatasyncagent.getPSSysDataSyncAgentId()) != 0L) {
                this.outpssysdatasyncagent = null;
            }
            if (this.outpssysdatasyncagent == null) {
                PSSysDataSyncAgent pSSysDataSyncAgent = new PSSysDataSyncAgent();
                pSSysDataSyncAgent.setPSSysDataSyncAgentId(this.getOutPSSysDataSyncAgentId());
                PSSysDataSyncAgentService pSSysDataSyncAgentService = (PSSysDataSyncAgentService)ServiceGlobal.getService(PSSysDataSyncAgentService.class, (SessionFactory)this.getSessionFactory());
                pSSysDataSyncAgentService.autoGet(pSSysDataSyncAgent);
                this.outpssysdatasyncagent = pSSysDataSyncAgent;
            }
            return this.outpssysdatasyncagent;
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
    public PSSysModelGroup getPSSysModelGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelGroup();
        }
        if (this.getPSSysModelGroupId() == null) {
            return null;
        }
        Integer n = this.objPSSysModelGroupLock;
        synchronized (n) {
            if (this.pssysmodelgroup != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysModelGroupId(), (Object)this.pssysmodelgroup.getPSSysModelGroupId()) != 0L) {
                this.pssysmodelgroup = null;
            }
            if (this.pssysmodelgroup == null) {
                PSSysModelGroup pSSysModelGroup = new PSSysModelGroup();
                pSSysModelGroup.setPSSysModelGroupId(this.getPSSysModelGroupId());
                PSSysModelGroupService pSSysModelGroupService = (PSSysModelGroupService)ServiceGlobal.getService(PSSysModelGroupService.class, (SessionFactory)this.getSessionFactory());
                pSSysModelGroupService.autoGet(pSSysModelGroup);
                this.pssysmodelgroup = pSSysModelGroup;
            }
            return this.pssysmodelgroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysResource getOutPSSysResource() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOutPSSysResource();
        }
        if (this.getOutPSSysResourceId() == null) {
            return null;
        }
        Integer n = this.objOutPSSysResourceLock;
        synchronized (n) {
            if (this.outpssysresource != null && DataTypeHelper.compare((int)25, (Object)this.getOutPSSysResourceId(), (Object)this.outpssysresource.getPSSysResourceId()) != 0L) {
                this.outpssysresource = null;
            }
            if (this.outpssysresource == null) {
                PSSysResource pSSysResource = new PSSysResource();
                pSSysResource.setPSSysResourceId(this.getOutPSSysResourceId());
                PSSysResourceService pSSysResourceService = (PSSysResourceService)ServiceGlobal.getService(PSSysResourceService.class, (SessionFactory)this.getSessionFactory());
                pSSysResourceService.autoGet(pSSysResource);
                this.outpssysresource = pSSysResource;
            }
            return this.outpssysresource;
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

    private PSSysUtilDEBase getProxyEntity() {
        return this.proxyPSSysUtilDEBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysUtilDEBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysUtilDEBase) {
            this.proxyPSSysUtilDEBase = (PSSysUtilDEBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysUtilDEService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_AUTHACCESSTOKENURI, 0);
        fieldIndexMap.put(FIELD_AUTHCLIENTID, 1);
        fieldIndexMap.put(FIELD_AUTHCLIENTSECRET, 2);
        fieldIndexMap.put(FIELD_AUTHMODE, 3);
        fieldIndexMap.put(FIELD_AUTHPARAM, 4);
        fieldIndexMap.put(FIELD_AUTHPARAM2, 5);
        fieldIndexMap.put(FIELD_CODENAME, 6);
        fieldIndexMap.put(FIELD_CREATEDATE, 7);
        fieldIndexMap.put(FIELD_CREATEMAN, 8);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 9);
        fieldIndexMap.put(FIELD_CUSTOMMODE, 10);
        fieldIndexMap.put(FIELD_INPSSYSDATASYNCAGENTID, 11);
        fieldIndexMap.put(FIELD_INPSSYSDATASYNCAGENTNAME, 12);
        fieldIndexMap.put(FIELD_MEMO, 13);
        fieldIndexMap.put(FIELD_ORDERVALUE, 14);
        fieldIndexMap.put(FIELD_OUTPSSYSDATASYNCAGENTID, 15);
        fieldIndexMap.put(FIELD_OUTPSSYSDATASYNCAGENTNAME, 16);
        fieldIndexMap.put(FIELD_OUTPSSYSRESOURCEID, 17);
        fieldIndexMap.put(FIELD_OUTPSSYSRESOURCENAME, 18);
        fieldIndexMap.put(FIELD_PSDEGROUPID, 19);
        fieldIndexMap.put(FIELD_PSDEGROUPNAME, 20);
        fieldIndexMap.put(FIELD_PSDERGROUPID, 21);
        fieldIndexMap.put(FIELD_PSDERGROUPNAME, 22);
        fieldIndexMap.put(FIELD_PSMODULEID, 23);
        fieldIndexMap.put(FIELD_PSMODULENAME, 24);
        fieldIndexMap.put(FIELD_PSSUBSYSSERVICEAPIID, 25);
        fieldIndexMap.put(FIELD_PSSUBSYSSERVICEAPINAME, 26);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 27);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 28);
        fieldIndexMap.put(FIELD_PSSYSMODELGROUPID, 29);
        fieldIndexMap.put(FIELD_PSSYSMODELGROUPNAME, 30);
        fieldIndexMap.put(FIELD_PSSYSRESOURCEID, 31);
        fieldIndexMap.put(FIELD_PSSYSRESOURCENAME, 32);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 33);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 34);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 35);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 36);
        fieldIndexMap.put(FIELD_PSSYSUTILDEID, 37);
        fieldIndexMap.put(FIELD_PSSYSUTILDENAME, 38);
        fieldIndexMap.put(FIELD_SERVICEPARAM, 39);
        fieldIndexMap.put(FIELD_SERVICEPARAM2, 40);
        fieldIndexMap.put(FIELD_SERVICEPATH, 41);
        fieldIndexMap.put(FIELD_UNIQUETAG, 42);
        fieldIndexMap.put(FIELD_UPDATEDATE, 43);
        fieldIndexMap.put(FIELD_UPDATEMAN, 44);
        fieldIndexMap.put(FIELD_USERCAT, 45);
        fieldIndexMap.put(FIELD_USERTAG, 46);
        fieldIndexMap.put(FIELD_USERTAG2, 47);
        fieldIndexMap.put(FIELD_USERTAG3, 48);
        fieldIndexMap.put(FIELD_USERTAG4, 49);
        fieldIndexMap.put(FIELD_UTILOBJ, 50);
        fieldIndexMap.put(FIELD_UTILPARAM, 51);
        fieldIndexMap.put(FIELD_UTILPARAM10, 52);
        fieldIndexMap.put(FIELD_UTILPARAM11, 53);
        fieldIndexMap.put(FIELD_UTILPARAM12, 54);
        fieldIndexMap.put(FIELD_UTILPARAM2, 55);
        fieldIndexMap.put(FIELD_UTILPARAM3, 56);
        fieldIndexMap.put(FIELD_UTILPARAM4, 57);
        fieldIndexMap.put(FIELD_UTILPARAM5, 58);
        fieldIndexMap.put(FIELD_UTILPARAM6, 59);
        fieldIndexMap.put(FIELD_UTILPARAM7, 60);
        fieldIndexMap.put(FIELD_UTILPARAM8, 61);
        fieldIndexMap.put(FIELD_UTILPARAM9, 62);
        fieldIndexMap.put(FIELD_UTILPARAMS, 63);
        fieldIndexMap.put(FIELD_UTILPSDE10ID, 64);
        fieldIndexMap.put(FIELD_UTILPSDE10NAME, 65);
        fieldIndexMap.put(FIELD_UTILPSDE11ID, 66);
        fieldIndexMap.put(FIELD_UTILPSDE11NAME, 67);
        fieldIndexMap.put(FIELD_UTILPSDE12ID, 68);
        fieldIndexMap.put(FIELD_UTILPSDE12NAME, 69);
        fieldIndexMap.put(FIELD_UTILPSDE13ID, 70);
        fieldIndexMap.put(FIELD_UTILPSDE13NAME, 71);
        fieldIndexMap.put(FIELD_UTILPSDE14ID, 72);
        fieldIndexMap.put(FIELD_UTILPSDE14NAME, 73);
        fieldIndexMap.put(FIELD_UTILPSDE15ID, 74);
        fieldIndexMap.put(FIELD_UTILPSDE15NAME, 75);
        fieldIndexMap.put(FIELD_UTILPSDE16ID, 76);
        fieldIndexMap.put(FIELD_UTILPSDE16NAME, 77);
        fieldIndexMap.put(FIELD_UTILPSDE17ID, 78);
        fieldIndexMap.put(FIELD_UTILPSDE17NAME, 79);
        fieldIndexMap.put(FIELD_UTILPSDE18ID, 80);
        fieldIndexMap.put(FIELD_UTILPSDE18NAME, 81);
        fieldIndexMap.put(FIELD_UTILPSDE19ID, 82);
        fieldIndexMap.put(FIELD_UTILPSDE19NAME, 83);
        fieldIndexMap.put(FIELD_UTILPSDE20ID, 84);
        fieldIndexMap.put(FIELD_UTILPSDE20NAME, 85);
        fieldIndexMap.put(FIELD_UTILPSDE2ID, 86);
        fieldIndexMap.put(FIELD_UTILPSDE2NAME, 87);
        fieldIndexMap.put(FIELD_UTILPSDE3ID, 88);
        fieldIndexMap.put(FIELD_UTILPSDE3NAME, 89);
        fieldIndexMap.put(FIELD_UTILPSDE4ID, 90);
        fieldIndexMap.put(FIELD_UTILPSDE4NAME, 91);
        fieldIndexMap.put(FIELD_UTILPSDE5ID, 92);
        fieldIndexMap.put(FIELD_UTILPSDE5NAME, 93);
        fieldIndexMap.put(FIELD_UTILPSDE6ID, 94);
        fieldIndexMap.put(FIELD_UTILPSDE6NAME, 95);
        fieldIndexMap.put(FIELD_UTILPSDE7ID, 96);
        fieldIndexMap.put(FIELD_UTILPSDE7NAME, 97);
        fieldIndexMap.put(FIELD_UTILPSDE8ID, 98);
        fieldIndexMap.put(FIELD_UTILPSDE8NAME, 99);
        fieldIndexMap.put(FIELD_UTILPSDE9ID, 100);
        fieldIndexMap.put(FIELD_UTILPSDE9NAME, 101);
        fieldIndexMap.put(FIELD_UTILPSDEID, 102);
        fieldIndexMap.put(FIELD_UTILPSDENAME, 103);
        fieldIndexMap.put(FIELD_UTILTAG, 104);
        fieldIndexMap.put(FIELD_UTILTAG2, 105);
        fieldIndexMap.put(FIELD_UTILTYPE, 106);
        fieldIndexMap.put(FIELD_VALIDFLAG, 107);
    }
}

