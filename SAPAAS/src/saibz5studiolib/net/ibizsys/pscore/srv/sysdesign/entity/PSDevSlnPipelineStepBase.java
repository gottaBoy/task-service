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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCBDInst;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCCodeSnippet;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCFile;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMSPlatform;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMSPlatformFunc;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMSPlatformNode;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRegistryItem;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRegistryRepo;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInst;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVN;
import net.ibizsys.pscore.srv.devcenter.service.PSDCBDInstService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCCodeSnippetService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCFileService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformFuncService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformNodeService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCRegistryItemService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCRegistryRepoService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepFunc;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDeploy;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnPipeline;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnPipelineStage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysSrv;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysVer;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnTempl;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepFuncService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDeployService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineStageService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysSrvService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysVerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnPipelineStepBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevSlnPipelineStepBase.class);
    public static final String FIELD_ACTIONPARAMS = "ACTIONPARAMS";
    public static final String FIELD_ACTIONTYPE = "ACTIONTYPE";
    public static final String FIELD_AGENTPSDCREGISTRYITEMID = "AGENTPSDCREGISTRYITEMID";
    public static final String FIELD_AGENTPSDCREGISTRYITEMNAME = "AGENTPSDCREGISTRYITEMNAME";
    public static final String FIELD_CHECKINMODE = "CHECKINMODE";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CONDMODEL = "CONDMODEL";
    public static final String FIELD_CONDMODELFLAG = "CONDMODELFLAG";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCHECKOUT = "CUSTOMCHECKOUT";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MODELPSDEVCENTERSVNID = "MODELPSDEVCENTERSVNID";
    public static final String FIELD_MODELPSDEVCENTERSVNNAME = "MODELPSDEVCENTERSVNNAME";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDCBDINSTID = "PSDCBDINSTID";
    public static final String FIELD_PSDCBDINSTNAME = "PSDCBDINSTNAME";
    public static final String FIELD_PSDCCODESNIPPETID = "PSDCCODESNIPPETID";
    public static final String FIELD_PSDCCODESNIPPETNAME = "PSDCCODESNIPPETNAME";
    public static final String FIELD_PSDCFILEID = "PSDCFILEID";
    public static final String FIELD_PSDCFILENAME = "PSDCFILENAME";
    public static final String FIELD_PSDCMSPLATFORMFUNCID = "PSDCMSPLATFORMFUNCID";
    public static final String FIELD_PSDCMSPLATFORMFUNCNAME = "PSDCMSPLATFORMFUNCNAME";
    public static final String FIELD_PSDCMSPLATFORMID = "PSDCMSPLATFORMID";
    public static final String FIELD_PSDCMSPLATFORMNAME = "PSDCMSPLATFORMNAME";
    public static final String FIELD_PSDCMSPLATFORMNODEID = "PSDCMSPLATFORMNODEID";
    public static final String FIELD_PSDCMSPLATFORMNODENAME = "PSDCMSPLATFORMNODENAME";
    public static final String FIELD_PSDCREGISTRYITEMID = "PSDCREGISTRYITEMID";
    public static final String FIELD_PSDCREGISTRYITEMNAME = "PSDCREGISTRYITEMNAME";
    public static final String FIELD_PSDCREGISTRYREPOID = "PSDCREGISTRYREPOID";
    public static final String FIELD_PSDCREGISTRYREPONAME = "PSDCREGISTRYREPONAME";
    public static final String FIELD_PSDEVCENTERDBINSTID = "PSDEVCENTERDBINSTID";
    public static final String FIELD_PSDEVCENTERDBINSTNAME = "PSDEVCENTERDBINSTNAME";
    public static final String FIELD_PSDEVCENTERSVNID = "PSDEVCENTERSVNID";
    public static final String FIELD_PSDEVCENTERSVNNAME = "PSDEVCENTERSVNNAME";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNMSDEPAPIID = "PSDEVSLNMSDEPAPIID";
    public static final String FIELD_PSDEVSLNMSDEPAPINAME = "PSDEVSLNMSDEPAPINAME";
    public static final String FIELD_PSDEVSLNMSDEPAPPID = "PSDEVSLNMSDEPAPPID";
    public static final String FIELD_PSDEVSLNMSDEPAPPNAME = "PSDEVSLNMSDEPAPPNAME";
    public static final String FIELD_PSDEVSLNMSDEPFUNCID = "PSDEVSLNMSDEPFUNCID";
    public static final String FIELD_PSDEVSLNMSDEPFUNCNAME = "PSDEVSLNMSDEPFUNCNAME";
    public static final String FIELD_PSDEVSLNMSDEPLOYID = "PSDEVSLNMSDEPLOYID";
    public static final String FIELD_PSDEVSLNMSDEPLOYNAME = "PSDEVSLNMSDEPLOYNAME";
    public static final String FIELD_PSDEVSLNPIPELINEID = "PSDEVSLNPIPELINEID";
    public static final String FIELD_PSDEVSLNPIPELINENAME = "PSDEVSLNPIPELINENAME";
    public static final String FIELD_PSDEVSLNPIPELINESTAGEID = "PSDEVSLNPIPELINESTAGEID";
    public static final String FIELD_PSDEVSLNPIPELINESTAGENAME = "PSDEVSLNPIPELINESTAGENAME";
    public static final String FIELD_PSDEVSLNPIPELINESTEPID = "PSDEVSLNPIPELINESTEPID";
    public static final String FIELD_PSDEVSLNPIPELINESTEPNAME = "PSDEVSLNPIPELINESTEPNAME";
    public static final String FIELD_PSDEVSLNSYSAPIID = "PSDEVSLNSYSAPIID";
    public static final String FIELD_PSDEVSLNSYSAPINAME = "PSDEVSLNSYSAPINAME";
    public static final String FIELD_PSDEVSLNSYSAPPID = "PSDEVSLNSYSAPPID";
    public static final String FIELD_PSDEVSLNSYSAPPNAME = "PSDEVSLNSYSAPPNAME";
    public static final String FIELD_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String FIELD_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String FIELD_PSDEVSLNSYSSRVID = "PSDEVSLNSYSSRVID";
    public static final String FIELD_PSDEVSLNSYSSRVNAME = "PSDEVSLNSYSSRVNAME";
    public static final String FIELD_PSDEVSLNSYSVERID = "PSDEVSLNSYSVERID";
    public static final String FIELD_PSDEVSLNSYSVERNAME = "PSDEVSLNSYSVERNAME";
    public static final String FIELD_PSDEVSLNTEMPLID = "PSDEVSLNTEMPLID";
    public static final String FIELD_PSDEVSLNTEMPLNAME = "PSDEVSLNTEMPLNAME";
    public static final String FIELD_REFPSDEVSLNPIPELINEID = "REFPSDEVSLNPIPELINEID";
    public static final String FIELD_REFPSDEVSLNPIPELINENAME = "REFPSDEVSLNPIPELINENAME";
    public static final String FIELD_RUNCMD = "RUNCMD";
    public static final String FIELD_STEPTAG = "STEPTAG";
    public static final String FIELD_STEPTAG2 = "STEPTAG2";
    public static final String FIELD_STEPTAG3 = "STEPTAG3";
    public static final String FIELD_STEPTAG4 = "STEPTAG4";
    public static final String FIELD_TEMPLATEMODE = "TEMPLATEMODE";
    public static final String FIELD_TEMPLPSDEVCENTERSVNID = "TEMPLPSDEVCENTERSVNID";
    public static final String FIELD_TEMPLPSDEVCENTERSVNNAME = "TEMPLPSDEVCENTERSVNNAME";
    public static final String FIELD_TOOLPSDCREGISTRYITEMID = "TOOLPSDCREGISTRYITEMID";
    public static final String FIELD_TOOLPSDCREGISTRYITEMNAME = "TOOLPSDCREGISTRYITEMNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_WORKFOLDER = "WORKFOLDER";
    private static final int INDEX_ACTIONPARAMS = 0;
    private static final int INDEX_ACTIONTYPE = 1;
    private static final int INDEX_AGENTPSDCREGISTRYITEMID = 2;
    private static final int INDEX_AGENTPSDCREGISTRYITEMNAME = 3;
    private static final int INDEX_CHECKINMODE = 4;
    private static final int INDEX_CODENAME = 5;
    private static final int INDEX_CONDMODEL = 6;
    private static final int INDEX_CONDMODELFLAG = 7;
    private static final int INDEX_CREATEDATE = 8;
    private static final int INDEX_CREATEMAN = 9;
    private static final int INDEX_CUSTOMCHECKOUT = 10;
    private static final int INDEX_CUSTOMCODE = 11;
    private static final int INDEX_MEMO = 12;
    private static final int INDEX_MODELPSDEVCENTERSVNID = 13;
    private static final int INDEX_MODELPSDEVCENTERSVNNAME = 14;
    private static final int INDEX_ORDERVALUE = 15;
    private static final int INDEX_PSDCBDINSTID = 16;
    private static final int INDEX_PSDCBDINSTNAME = 17;
    private static final int INDEX_PSDCCODESNIPPETID = 18;
    private static final int INDEX_PSDCCODESNIPPETNAME = 19;
    private static final int INDEX_PSDCFILEID = 20;
    private static final int INDEX_PSDCFILENAME = 21;
    private static final int INDEX_PSDCMSPLATFORMFUNCID = 22;
    private static final int INDEX_PSDCMSPLATFORMFUNCNAME = 23;
    private static final int INDEX_PSDCMSPLATFORMID = 24;
    private static final int INDEX_PSDCMSPLATFORMNAME = 25;
    private static final int INDEX_PSDCMSPLATFORMNODEID = 26;
    private static final int INDEX_PSDCMSPLATFORMNODENAME = 27;
    private static final int INDEX_PSDCREGISTRYITEMID = 28;
    private static final int INDEX_PSDCREGISTRYITEMNAME = 29;
    private static final int INDEX_PSDCREGISTRYREPOID = 30;
    private static final int INDEX_PSDCREGISTRYREPONAME = 31;
    private static final int INDEX_PSDEVCENTERDBINSTID = 32;
    private static final int INDEX_PSDEVCENTERDBINSTNAME = 33;
    private static final int INDEX_PSDEVCENTERSVNID = 34;
    private static final int INDEX_PSDEVCENTERSVNNAME = 35;
    private static final int INDEX_PSDEVSLNID = 36;
    private static final int INDEX_PSDEVSLNMSDEPAPIID = 37;
    private static final int INDEX_PSDEVSLNMSDEPAPINAME = 38;
    private static final int INDEX_PSDEVSLNMSDEPAPPID = 39;
    private static final int INDEX_PSDEVSLNMSDEPAPPNAME = 40;
    private static final int INDEX_PSDEVSLNMSDEPFUNCID = 41;
    private static final int INDEX_PSDEVSLNMSDEPFUNCNAME = 42;
    private static final int INDEX_PSDEVSLNMSDEPLOYID = 43;
    private static final int INDEX_PSDEVSLNMSDEPLOYNAME = 44;
    private static final int INDEX_PSDEVSLNPIPELINEID = 45;
    private static final int INDEX_PSDEVSLNPIPELINENAME = 46;
    private static final int INDEX_PSDEVSLNPIPELINESTAGEID = 47;
    private static final int INDEX_PSDEVSLNPIPELINESTAGENAME = 48;
    private static final int INDEX_PSDEVSLNPIPELINESTEPID = 49;
    private static final int INDEX_PSDEVSLNPIPELINESTEPNAME = 50;
    private static final int INDEX_PSDEVSLNSYSAPIID = 51;
    private static final int INDEX_PSDEVSLNSYSAPINAME = 52;
    private static final int INDEX_PSDEVSLNSYSAPPID = 53;
    private static final int INDEX_PSDEVSLNSYSAPPNAME = 54;
    private static final int INDEX_PSDEVSLNSYSID = 55;
    private static final int INDEX_PSDEVSLNSYSNAME = 56;
    private static final int INDEX_PSDEVSLNSYSSRVID = 57;
    private static final int INDEX_PSDEVSLNSYSSRVNAME = 58;
    private static final int INDEX_PSDEVSLNSYSVERID = 59;
    private static final int INDEX_PSDEVSLNSYSVERNAME = 60;
    private static final int INDEX_PSDEVSLNTEMPLID = 61;
    private static final int INDEX_PSDEVSLNTEMPLNAME = 62;
    private static final int INDEX_REFPSDEVSLNPIPELINEID = 63;
    private static final int INDEX_REFPSDEVSLNPIPELINENAME = 64;
    private static final int INDEX_RUNCMD = 65;
    private static final int INDEX_STEPTAG = 66;
    private static final int INDEX_STEPTAG2 = 67;
    private static final int INDEX_STEPTAG3 = 68;
    private static final int INDEX_STEPTAG4 = 69;
    private static final int INDEX_TEMPLATEMODE = 70;
    private static final int INDEX_TEMPLPSDEVCENTERSVNID = 71;
    private static final int INDEX_TEMPLPSDEVCENTERSVNNAME = 72;
    private static final int INDEX_TOOLPSDCREGISTRYITEMID = 73;
    private static final int INDEX_TOOLPSDCREGISTRYITEMNAME = 74;
    private static final int INDEX_UPDATEDATE = 75;
    private static final int INDEX_UPDATEMAN = 76;
    private static final int INDEX_USERCAT = 77;
    private static final int INDEX_USERTAG = 78;
    private static final int INDEX_USERTAG2 = 79;
    private static final int INDEX_USERTAG3 = 80;
    private static final int INDEX_USERTAG4 = 81;
    private static final int INDEX_VALIDFLAG = 82;
    private static final int INDEX_WORKFOLDER = 83;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevSlnPipelineStepBase proxyPSDevSlnPipelineStepBase = null;
    private boolean actionparamsDirtyFlag = false;
    private boolean actiontypeDirtyFlag = false;
    private boolean agentpsdcregistryitemidDirtyFlag = false;
    private boolean agentpsdcregistryitemnameDirtyFlag = false;
    private boolean checkinmodeDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean condmodelDirtyFlag = false;
    private boolean condmodelflagDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcheckoutDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean modelpsdevcentersvnidDirtyFlag = false;
    private boolean modelpsdevcentersvnnameDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdcbdinstidDirtyFlag = false;
    private boolean psdcbdinstnameDirtyFlag = false;
    private boolean psdccodesnippetidDirtyFlag = false;
    private boolean psdccodesnippetnameDirtyFlag = false;
    private boolean psdcfileidDirtyFlag = false;
    private boolean psdcfilenameDirtyFlag = false;
    private boolean psdcmsplatformfuncidDirtyFlag = false;
    private boolean psdcmsplatformfuncnameDirtyFlag = false;
    private boolean psdcmsplatformidDirtyFlag = false;
    private boolean psdcmsplatformnameDirtyFlag = false;
    private boolean psdcmsplatformnodeidDirtyFlag = false;
    private boolean psdcmsplatformnodenameDirtyFlag = false;
    private boolean psdcregistryitemidDirtyFlag = false;
    private boolean psdcregistryitemnameDirtyFlag = false;
    private boolean psdcregistryrepoidDirtyFlag = false;
    private boolean psdcregistryreponameDirtyFlag = false;
    private boolean psdevcenterdbinstidDirtyFlag = false;
    private boolean psdevcenterdbinstnameDirtyFlag = false;
    private boolean psdevcentersvnidDirtyFlag = false;
    private boolean psdevcentersvnnameDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnmsdepapiidDirtyFlag = false;
    private boolean psdevslnmsdepapinameDirtyFlag = false;
    private boolean psdevslnmsdepappidDirtyFlag = false;
    private boolean psdevslnmsdepappnameDirtyFlag = false;
    private boolean psdevslnmsdepfuncidDirtyFlag = false;
    private boolean psdevslnmsdepfuncnameDirtyFlag = false;
    private boolean psdevslnmsdeployidDirtyFlag = false;
    private boolean psdevslnmsdeploynameDirtyFlag = false;
    private boolean psdevslnpipelineidDirtyFlag = false;
    private boolean psdevslnpipelinenameDirtyFlag = false;
    private boolean psdevslnpipelinestageidDirtyFlag = false;
    private boolean psdevslnpipelinestagenameDirtyFlag = false;
    private boolean psdevslnpipelinestepidDirtyFlag = false;
    private boolean psdevslnpipelinestepnameDirtyFlag = false;
    private boolean psdevslnsysapiidDirtyFlag = false;
    private boolean psdevslnsysapinameDirtyFlag = false;
    private boolean psdevslnsysappidDirtyFlag = false;
    private boolean psdevslnsysappnameDirtyFlag = false;
    private boolean psdevslnsysidDirtyFlag = false;
    private boolean psdevslnsysnameDirtyFlag = false;
    private boolean psdevslnsyssrvidDirtyFlag = false;
    private boolean psdevslnsyssrvnameDirtyFlag = false;
    private boolean psdevslnsysveridDirtyFlag = false;
    private boolean psdevslnsysvernameDirtyFlag = false;
    private boolean psdevslntemplidDirtyFlag = false;
    private boolean psdevslntemplnameDirtyFlag = false;
    private boolean refpsdevslnpipelineidDirtyFlag = false;
    private boolean refpsdevslnpipelinenameDirtyFlag = false;
    private boolean runcmdDirtyFlag = false;
    private boolean steptagDirtyFlag = false;
    private boolean steptag2DirtyFlag = false;
    private boolean steptag3DirtyFlag = false;
    private boolean steptag4DirtyFlag = false;
    private boolean templatemodeDirtyFlag = false;
    private boolean templpsdevcentersvnidDirtyFlag = false;
    private boolean templpsdevcentersvnnameDirtyFlag = false;
    private boolean toolpsdcregistryitemidDirtyFlag = false;
    private boolean toolpsdcregistryitemnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean workfolderDirtyFlag = false;
    @Column(name="actionparams")
    private String actionparams;
    @Column(name="actiontype")
    private String actiontype;
    @Column(name="agentpsdcregistryitemid")
    private String agentpsdcregistryitemid;
    @Column(name="agentpsdcregistryitemname")
    private String agentpsdcregistryitemname;
    @Column(name="checkinmode")
    private Integer checkinmode;
    @Column(name="codename")
    private String codename;
    @Column(name="condmodel")
    private String condmodel;
    @Column(name="condmodelflag")
    private Integer condmodelflag;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customcheckout")
    private Integer customcheckout;
    @Column(name="customcode")
    private String customcode;
    @Column(name="memo")
    private String memo;
    @Column(name="modelpsdevcentersvnid")
    private String modelpsdevcentersvnid;
    @Column(name="modelpsdevcentersvnname")
    private String modelpsdevcentersvnname;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psdcbdinstid")
    private String psdcbdinstid;
    @Column(name="psdcbdinstname")
    private String psdcbdinstname;
    @Column(name="psdccodesnippetid")
    private String psdccodesnippetid;
    @Column(name="psdccodesnippetname")
    private String psdccodesnippetname;
    @Column(name="psdcfileid")
    private String psdcfileid;
    @Column(name="psdcfilename")
    private String psdcfilename;
    @Column(name="psdcmsplatformfuncid")
    private String psdcmsplatformfuncid;
    @Column(name="psdcmsplatformfuncname")
    private String psdcmsplatformfuncname;
    @Column(name="psdcmsplatformid")
    private String psdcmsplatformid;
    @Column(name="psdcmsplatformname")
    private String psdcmsplatformname;
    @Column(name="psdcmsplatformnodeid")
    private String psdcmsplatformnodeid;
    @Column(name="psdcmsplatformnodename")
    private String psdcmsplatformnodename;
    @Column(name="psdcregistryitemid")
    private String psdcregistryitemid;
    @Column(name="psdcregistryitemname")
    private String psdcregistryitemname;
    @Column(name="psdcregistryrepoid")
    private String psdcregistryrepoid;
    @Column(name="psdcregistryreponame")
    private String psdcregistryreponame;
    @Column(name="psdevcenterdbinstid")
    private String psdevcenterdbinstid;
    @Column(name="psdevcenterdbinstname")
    private String psdevcenterdbinstname;
    @Column(name="psdevcentersvnid")
    private String psdevcentersvnid;
    @Column(name="psdevcentersvnname")
    private String psdevcentersvnname;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnmsdepapiid")
    private String psdevslnmsdepapiid;
    @Column(name="psdevslnmsdepapiname")
    private String psdevslnmsdepapiname;
    @Column(name="psdevslnmsdepappid")
    private String psdevslnmsdepappid;
    @Column(name="psdevslnmsdepappname")
    private String psdevslnmsdepappname;
    @Column(name="psdevslnmsdepfuncid")
    private String psdevslnmsdepfuncid;
    @Column(name="psdevslnmsdepfuncname")
    private String psdevslnmsdepfuncname;
    @Column(name="psdevslnmsdeployid")
    private String psdevslnmsdeployid;
    @Column(name="psdevslnmsdeployname")
    private String psdevslnmsdeployname;
    @Column(name="psdevslnpipelineid")
    private String psdevslnpipelineid;
    @Column(name="psdevslnpipelinename")
    private String psdevslnpipelinename;
    @Column(name="psdevslnpipelinestageid")
    private String psdevslnpipelinestageid;
    @Column(name="psdevslnpipelinestagename")
    private String psdevslnpipelinestagename;
    @Column(name="psdevslnpipelinestepid")
    private String psdevslnpipelinestepid;
    @Column(name="psdevslnpipelinestepname")
    private String psdevslnpipelinestepname;
    @Column(name="psdevslnsysapiid")
    private String psdevslnsysapiid;
    @Column(name="psdevslnsysapiname")
    private String psdevslnsysapiname;
    @Column(name="psdevslnsysappid")
    private String psdevslnsysappid;
    @Column(name="psdevslnsysappname")
    private String psdevslnsysappname;
    @Column(name="psdevslnsysid")
    private String psdevslnsysid;
    @Column(name="psdevslnsysname")
    private String psdevslnsysname;
    @Column(name="psdevslnsyssrvid")
    private String psdevslnsyssrvid;
    @Column(name="psdevslnsyssrvname")
    private String psdevslnsyssrvname;
    @Column(name="psdevslnsysverid")
    private String psdevslnsysverid;
    @Column(name="psdevslnsysvername")
    private String psdevslnsysvername;
    @Column(name="psdevslntemplid")
    private String psdevslntemplid;
    @Column(name="psdevslntemplname")
    private String psdevslntemplname;
    @Column(name="refpsdevslnpipelineid")
    private String refpsdevslnpipelineid;
    @Column(name="refpsdevslnpipelinename")
    private String refpsdevslnpipelinename;
    @Column(name="runcmd")
    private String runcmd;
    @Column(name="steptag")
    private String steptag;
    @Column(name="steptag2")
    private String steptag2;
    @Column(name="steptag3")
    private String steptag3;
    @Column(name="steptag4")
    private String steptag4;
    @Column(name="templatemode")
    private Integer templatemode;
    @Column(name="templpsdevcentersvnid")
    private String templpsdevcentersvnid;
    @Column(name="templpsdevcentersvnname")
    private String templpsdevcentersvnname;
    @Column(name="toolpsdcregistryitemid")
    private String toolpsdcregistryitemid;
    @Column(name="toolpsdcregistryitemname")
    private String toolpsdcregistryitemname;
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
    @Column(name="workfolder")
    private String workfolder;
    private Integer objPSDCBDInstLock = new Integer(1);
    private PSDCBDInst psdcbdinst = null;
    private Integer objPSDCCodeSnippetLock = new Integer(1);
    private PSDCCodeSnippet psdccodesnippet = null;
    private Integer objPSDCFileLock = new Integer(1);
    private PSDCFile psdcfile = null;
    private Integer objPSDCMSPlatformFuncLock = new Integer(1);
    private PSDCMSPlatformFunc psdcmsplatformfunc = null;
    private Integer objPSDCMSPlatformNodeLock = new Integer(1);
    private PSDCMSPlatformNode psdcmsplatformnode = null;
    private Integer objPSDCMSPlatformLock = new Integer(1);
    private PSDCMSPlatform psdcmsplatform = null;
    private Integer objAgentPSDCRegistryItemLock = new Integer(1);
    private PSDCRegistryItem agentpsdcregistryitem = null;
    private Integer objPSDCRegistryItemLock = new Integer(1);
    private PSDCRegistryItem psdcregistryitem = null;
    private Integer objToolPSDCRegistryItemLock = new Integer(1);
    private PSDCRegistryItem toolpsdcregistryitem = null;
    private Integer objPSDCRegistryRepoLock = new Integer(1);
    private PSDCRegistryRepo psdcregistryrepo = null;
    private Integer objPSDevCenterDBInstLock = new Integer(1);
    private PSDevCenterDBInst psdevcenterdbinst = null;
    private Integer objModelPSDevCenterSVNLock = new Integer(1);
    private PSDevCenterSVN modelpsdevcentersvn = null;
    private Integer objPSDevCenterSVNLock = new Integer(1);
    private PSDevCenterSVN psdevcentersvn = null;
    private Integer objTemplPSDevCenterSVNLock = new Integer(1);
    private PSDevCenterSVN templpsdevcentersvn = null;
    private Integer objPSDevSlnMSDepAPILock = new Integer(1);
    private PSDevSlnMSDepAPI psdevslnmsdepapi = null;
    private Integer objPSDevSlnMSDepAppLock = new Integer(1);
    private PSDevSlnMSDepApp psdevslnmsdepapp = null;
    private Integer objPSDevSlnMSDepFuncLock = new Integer(1);
    private PSDevSlnMSDepFunc psdevslnmsdepfunc = null;
    private Integer objPSDevSlnMSDeployLock = new Integer(1);
    private PSDevSlnMSDeploy psdevslnmsdeploy = null;
    private Integer objPSDevSlnPipelineStageLock = new Integer(1);
    private PSDevSlnPipelineStage psdevslnpipelinestage = null;
    private Integer objPSDevSlnPipelineLock = new Integer(1);
    private PSDevSlnPipeline psdevslnpipeline = null;
    private Integer objRefPSDevSlnPipelineLock = new Integer(1);
    private PSDevSlnPipeline refpsdevslnpipeline = null;
    private Integer objPSDevSlnSysAPILock = new Integer(1);
    private PSDevSlnSysAPI psdevslnsysapi = null;
    private Integer objPSDevSlnSysAppLock = new Integer(1);
    private PSDevSlnSysApp psdevslnsysapp = null;
    private Integer objPSDevSlnSysSrvLock = new Integer(1);
    private PSDevSlnSysSrv psdevslnsyssrv = null;
    private Integer objPSDevSlnSysVerLock = new Integer(1);
    private PSDevSlnSysVer psdevslnsysver = null;
    private Integer objPSDevSlnSysLock = new Integer(1);
    private PSDevSlnSys psdevslnsys = null;
    private Integer objPSDevSlnTemplLock = new Integer(1);
    private PSDevSlnTempl psdevslntempl = null;

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

    public void setAgentPSDCRegistryItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAgentPSDCRegistryItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.agentpsdcregistryitemid = string;
        this.agentpsdcregistryitemidDirtyFlag = true;
    }

    public String getAgentPSDCRegistryItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAgentPSDCRegistryItemId();
        }
        return this.agentpsdcregistryitemid;
    }

    public boolean isAgentPSDCRegistryItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAgentPSDCRegistryItemIdDirty();
        }
        return this.agentpsdcregistryitemidDirtyFlag;
    }

    public void resetAgentPSDCRegistryItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAgentPSDCRegistryItemId();
            return;
        }
        this.agentpsdcregistryitemidDirtyFlag = false;
        this.agentpsdcregistryitemid = null;
    }

    public void setAgentPSDCRegistryItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAgentPSDCRegistryItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.agentpsdcregistryitemname = string;
        this.agentpsdcregistryitemnameDirtyFlag = true;
    }

    public String getAgentPSDCRegistryItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAgentPSDCRegistryItemName();
        }
        return this.agentpsdcregistryitemname;
    }

    public boolean isAgentPSDCRegistryItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAgentPSDCRegistryItemNameDirty();
        }
        return this.agentpsdcregistryitemnameDirtyFlag;
    }

    public void resetAgentPSDCRegistryItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAgentPSDCRegistryItemName();
            return;
        }
        this.agentpsdcregistryitemnameDirtyFlag = false;
        this.agentpsdcregistryitemname = null;
    }

    public void setCheckinMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCheckinMode(n);
            return;
        }
        this.checkinmode = n;
        this.checkinmodeDirtyFlag = true;
    }

    public Integer getCheckinMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCheckinMode();
        }
        return this.checkinmode;
    }

    public boolean isCheckinModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCheckinModeDirty();
        }
        return this.checkinmodeDirtyFlag;
    }

    public void resetCheckinMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCheckinMode();
            return;
        }
        this.checkinmodeDirtyFlag = false;
        this.checkinmode = null;
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

    public void setCondModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCondModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.condmodel = string;
        this.condmodelDirtyFlag = true;
    }

    public String getCondModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCondModel();
        }
        return this.condmodel;
    }

    public boolean isCondModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCondModelDirty();
        }
        return this.condmodelDirtyFlag;
    }

    public void resetCondModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCondModel();
            return;
        }
        this.condmodelDirtyFlag = false;
        this.condmodel = null;
    }

    public void setCondModelFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCondModelFlag(n);
            return;
        }
        this.condmodelflag = n;
        this.condmodelflagDirtyFlag = true;
    }

    public Integer getCondModelFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCondModelFlag();
        }
        return this.condmodelflag;
    }

    public boolean isCondModelFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCondModelFlagDirty();
        }
        return this.condmodelflagDirtyFlag;
    }

    public void resetCondModelFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCondModelFlag();
            return;
        }
        this.condmodelflagDirtyFlag = false;
        this.condmodelflag = null;
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

    public void setCustomCheckout(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomCheckout(n);
            return;
        }
        this.customcheckout = n;
        this.customcheckoutDirtyFlag = true;
    }

    public Integer getCustomCheckout() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomCheckout();
        }
        return this.customcheckout;
    }

    public boolean isCustomCheckoutDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomCheckoutDirty();
        }
        return this.customcheckoutDirtyFlag;
    }

    public void resetCustomCheckout() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomCheckout();
            return;
        }
        this.customcheckoutDirtyFlag = false;
        this.customcheckout = null;
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

    public void setPSDCBDInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCBDInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcbdinstid = string;
        this.psdcbdinstidDirtyFlag = true;
    }

    public String getPSDCBDInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCBDInstId();
        }
        return this.psdcbdinstid;
    }

    public boolean isPSDCBDInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCBDInstIdDirty();
        }
        return this.psdcbdinstidDirtyFlag;
    }

    public void resetPSDCBDInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCBDInstId();
            return;
        }
        this.psdcbdinstidDirtyFlag = false;
        this.psdcbdinstid = null;
    }

    public void setPSDCBDInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCBDInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcbdinstname = string;
        this.psdcbdinstnameDirtyFlag = true;
    }

    public String getPSDCBDInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCBDInstName();
        }
        return this.psdcbdinstname;
    }

    public boolean isPSDCBDInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCBDInstNameDirty();
        }
        return this.psdcbdinstnameDirtyFlag;
    }

    public void resetPSDCBDInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCBDInstName();
            return;
        }
        this.psdcbdinstnameDirtyFlag = false;
        this.psdcbdinstname = null;
    }

    public void setPSDCCodeSnippetId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCCodeSnippetId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdccodesnippetid = string;
        this.psdccodesnippetidDirtyFlag = true;
    }

    public String getPSDCCodeSnippetId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCCodeSnippetId();
        }
        return this.psdccodesnippetid;
    }

    public boolean isPSDCCodeSnippetIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCCodeSnippetIdDirty();
        }
        return this.psdccodesnippetidDirtyFlag;
    }

    public void resetPSDCCodeSnippetId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCCodeSnippetId();
            return;
        }
        this.psdccodesnippetidDirtyFlag = false;
        this.psdccodesnippetid = null;
    }

    public void setPSDCCodeSnippetName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCCodeSnippetName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdccodesnippetname = string;
        this.psdccodesnippetnameDirtyFlag = true;
    }

    public String getPSDCCodeSnippetName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCCodeSnippetName();
        }
        return this.psdccodesnippetname;
    }

    public boolean isPSDCCodeSnippetNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCCodeSnippetNameDirty();
        }
        return this.psdccodesnippetnameDirtyFlag;
    }

    public void resetPSDCCodeSnippetName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCCodeSnippetName();
            return;
        }
        this.psdccodesnippetnameDirtyFlag = false;
        this.psdccodesnippetname = null;
    }

    public void setPSDCFileId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCFileId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcfileid = string;
        this.psdcfileidDirtyFlag = true;
    }

    public String getPSDCFileId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCFileId();
        }
        return this.psdcfileid;
    }

    public boolean isPSDCFileIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCFileIdDirty();
        }
        return this.psdcfileidDirtyFlag;
    }

    public void resetPSDCFileId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCFileId();
            return;
        }
        this.psdcfileidDirtyFlag = false;
        this.psdcfileid = null;
    }

    public void setPSDCFileName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCFileName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcfilename = string;
        this.psdcfilenameDirtyFlag = true;
    }

    public String getPSDCFileName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCFileName();
        }
        return this.psdcfilename;
    }

    public boolean isPSDCFileNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCFileNameDirty();
        }
        return this.psdcfilenameDirtyFlag;
    }

    public void resetPSDCFileName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCFileName();
            return;
        }
        this.psdcfilenameDirtyFlag = false;
        this.psdcfilename = null;
    }

    public void setPSDCMSPlatformFuncId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCMSPlatformFuncId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcmsplatformfuncid = string;
        this.psdcmsplatformfuncidDirtyFlag = true;
    }

    public String getPSDCMSPlatformFuncId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMSPlatformFuncId();
        }
        return this.psdcmsplatformfuncid;
    }

    public boolean isPSDCMSPlatformFuncIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCMSPlatformFuncIdDirty();
        }
        return this.psdcmsplatformfuncidDirtyFlag;
    }

    public void resetPSDCMSPlatformFuncId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCMSPlatformFuncId();
            return;
        }
        this.psdcmsplatformfuncidDirtyFlag = false;
        this.psdcmsplatformfuncid = null;
    }

    public void setPSDCMSPlatformFuncName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCMSPlatformFuncName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcmsplatformfuncname = string;
        this.psdcmsplatformfuncnameDirtyFlag = true;
    }

    public String getPSDCMSPlatformFuncName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMSPlatformFuncName();
        }
        return this.psdcmsplatformfuncname;
    }

    public boolean isPSDCMSPlatformFuncNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCMSPlatformFuncNameDirty();
        }
        return this.psdcmsplatformfuncnameDirtyFlag;
    }

    public void resetPSDCMSPlatformFuncName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCMSPlatformFuncName();
            return;
        }
        this.psdcmsplatformfuncnameDirtyFlag = false;
        this.psdcmsplatformfuncname = null;
    }

    public void setPSDCMSPlatformId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCMSPlatformId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcmsplatformid = string;
        this.psdcmsplatformidDirtyFlag = true;
    }

    public String getPSDCMSPlatformId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMSPlatformId();
        }
        return this.psdcmsplatformid;
    }

    public boolean isPSDCMSPlatformIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCMSPlatformIdDirty();
        }
        return this.psdcmsplatformidDirtyFlag;
    }

    public void resetPSDCMSPlatformId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCMSPlatformId();
            return;
        }
        this.psdcmsplatformidDirtyFlag = false;
        this.psdcmsplatformid = null;
    }

    public void setPSDCMSPlatformName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCMSPlatformName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcmsplatformname = string;
        this.psdcmsplatformnameDirtyFlag = true;
    }

    public String getPSDCMSPlatformName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMSPlatformName();
        }
        return this.psdcmsplatformname;
    }

    public boolean isPSDCMSPlatformNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCMSPlatformNameDirty();
        }
        return this.psdcmsplatformnameDirtyFlag;
    }

    public void resetPSDCMSPlatformName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCMSPlatformName();
            return;
        }
        this.psdcmsplatformnameDirtyFlag = false;
        this.psdcmsplatformname = null;
    }

    public void setPSDCMSPlatformNodeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCMSPlatformNodeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcmsplatformnodeid = string;
        this.psdcmsplatformnodeidDirtyFlag = true;
    }

    public String getPSDCMSPlatformNodeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMSPlatformNodeId();
        }
        return this.psdcmsplatformnodeid;
    }

    public boolean isPSDCMSPlatformNodeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCMSPlatformNodeIdDirty();
        }
        return this.psdcmsplatformnodeidDirtyFlag;
    }

    public void resetPSDCMSPlatformNodeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCMSPlatformNodeId();
            return;
        }
        this.psdcmsplatformnodeidDirtyFlag = false;
        this.psdcmsplatformnodeid = null;
    }

    public void setPSDCMSPlatformNodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCMSPlatformNodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcmsplatformnodename = string;
        this.psdcmsplatformnodenameDirtyFlag = true;
    }

    public String getPSDCMSPlatformNodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMSPlatformNodeName();
        }
        return this.psdcmsplatformnodename;
    }

    public boolean isPSDCMSPlatformNodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCMSPlatformNodeNameDirty();
        }
        return this.psdcmsplatformnodenameDirtyFlag;
    }

    public void resetPSDCMSPlatformNodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCMSPlatformNodeName();
            return;
        }
        this.psdcmsplatformnodenameDirtyFlag = false;
        this.psdcmsplatformnodename = null;
    }

    public void setPSDCRegistryItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCRegistryItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcregistryitemid = string;
        this.psdcregistryitemidDirtyFlag = true;
    }

    public String getPSDCRegistryItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCRegistryItemId();
        }
        return this.psdcregistryitemid;
    }

    public boolean isPSDCRegistryItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCRegistryItemIdDirty();
        }
        return this.psdcregistryitemidDirtyFlag;
    }

    public void resetPSDCRegistryItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCRegistryItemId();
            return;
        }
        this.psdcregistryitemidDirtyFlag = false;
        this.psdcregistryitemid = null;
    }

    public void setPSDCRegistryItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCRegistryItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcregistryitemname = string;
        this.psdcregistryitemnameDirtyFlag = true;
    }

    public String getPSDCRegistryItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCRegistryItemName();
        }
        return this.psdcregistryitemname;
    }

    public boolean isPSDCRegistryItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCRegistryItemNameDirty();
        }
        return this.psdcregistryitemnameDirtyFlag;
    }

    public void resetPSDCRegistryItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCRegistryItemName();
            return;
        }
        this.psdcregistryitemnameDirtyFlag = false;
        this.psdcregistryitemname = null;
    }

    public void setPSDCRegistryRepoId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCRegistryRepoId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcregistryrepoid = string;
        this.psdcregistryrepoidDirtyFlag = true;
    }

    public String getPSDCRegistryRepoId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCRegistryRepoId();
        }
        return this.psdcregistryrepoid;
    }

    public boolean isPSDCRegistryRepoIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCRegistryRepoIdDirty();
        }
        return this.psdcregistryrepoidDirtyFlag;
    }

    public void resetPSDCRegistryRepoId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCRegistryRepoId();
            return;
        }
        this.psdcregistryrepoidDirtyFlag = false;
        this.psdcregistryrepoid = null;
    }

    public void setPSDCRegistryRepoName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCRegistryRepoName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcregistryreponame = string;
        this.psdcregistryreponameDirtyFlag = true;
    }

    public String getPSDCRegistryRepoName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCRegistryRepoName();
        }
        return this.psdcregistryreponame;
    }

    public boolean isPSDCRegistryRepoNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCRegistryRepoNameDirty();
        }
        return this.psdcregistryreponameDirtyFlag;
    }

    public void resetPSDCRegistryRepoName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCRegistryRepoName();
            return;
        }
        this.psdcregistryreponameDirtyFlag = false;
        this.psdcregistryreponame = null;
    }

    public void setPSDevCenterDBInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterDBInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterdbinstid = string;
        this.psdevcenterdbinstidDirtyFlag = true;
    }

    public String getPSDevCenterDBInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterDBInstId();
        }
        return this.psdevcenterdbinstid;
    }

    public boolean isPSDevCenterDBInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterDBInstIdDirty();
        }
        return this.psdevcenterdbinstidDirtyFlag;
    }

    public void resetPSDevCenterDBInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterDBInstId();
            return;
        }
        this.psdevcenterdbinstidDirtyFlag = false;
        this.psdevcenterdbinstid = null;
    }

    public void setPSDevCenterDBInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterDBInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterdbinstname = string;
        this.psdevcenterdbinstnameDirtyFlag = true;
    }

    public String getPSDevCenterDBInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterDBInstName();
        }
        return this.psdevcenterdbinstname;
    }

    public boolean isPSDevCenterDBInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterDBInstNameDirty();
        }
        return this.psdevcenterdbinstnameDirtyFlag;
    }

    public void resetPSDevCenterDBInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterDBInstName();
            return;
        }
        this.psdevcenterdbinstnameDirtyFlag = false;
        this.psdevcenterdbinstname = null;
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

    public void setPSDevSlnMSDepAPIId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnMSDepAPIId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnmsdepapiid = string;
        this.psdevslnmsdepapiidDirtyFlag = true;
    }

    public String getPSDevSlnMSDepAPIId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDepAPIId();
        }
        return this.psdevslnmsdepapiid;
    }

    public boolean isPSDevSlnMSDepAPIIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnMSDepAPIIdDirty();
        }
        return this.psdevslnmsdepapiidDirtyFlag;
    }

    public void resetPSDevSlnMSDepAPIId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnMSDepAPIId();
            return;
        }
        this.psdevslnmsdepapiidDirtyFlag = false;
        this.psdevslnmsdepapiid = null;
    }

    public void setPSDevSlnMSDepAPIName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnMSDepAPIName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnmsdepapiname = string;
        this.psdevslnmsdepapinameDirtyFlag = true;
    }

    public String getPSDevSlnMSDepAPIName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDepAPIName();
        }
        return this.psdevslnmsdepapiname;
    }

    public boolean isPSDevSlnMSDepAPINameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnMSDepAPINameDirty();
        }
        return this.psdevslnmsdepapinameDirtyFlag;
    }

    public void resetPSDevSlnMSDepAPIName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnMSDepAPIName();
            return;
        }
        this.psdevslnmsdepapinameDirtyFlag = false;
        this.psdevslnmsdepapiname = null;
    }

    public void setPSDevSlnMSDepAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnMSDepAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnmsdepappid = string;
        this.psdevslnmsdepappidDirtyFlag = true;
    }

    public String getPSDevSlnMSDepAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDepAppId();
        }
        return this.psdevslnmsdepappid;
    }

    public boolean isPSDevSlnMSDepAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnMSDepAppIdDirty();
        }
        return this.psdevslnmsdepappidDirtyFlag;
    }

    public void resetPSDevSlnMSDepAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnMSDepAppId();
            return;
        }
        this.psdevslnmsdepappidDirtyFlag = false;
        this.psdevslnmsdepappid = null;
    }

    public void setPSDevSlnMSDepAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnMSDepAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnmsdepappname = string;
        this.psdevslnmsdepappnameDirtyFlag = true;
    }

    public String getPSDevSlnMSDepAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDepAppName();
        }
        return this.psdevslnmsdepappname;
    }

    public boolean isPSDevSlnMSDepAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnMSDepAppNameDirty();
        }
        return this.psdevslnmsdepappnameDirtyFlag;
    }

    public void resetPSDevSlnMSDepAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnMSDepAppName();
            return;
        }
        this.psdevslnmsdepappnameDirtyFlag = false;
        this.psdevslnmsdepappname = null;
    }

    public void setPSDevSlnMSDepFuncId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnMSDepFuncId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnmsdepfuncid = string;
        this.psdevslnmsdepfuncidDirtyFlag = true;
    }

    public String getPSDevSlnMSDepFuncId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDepFuncId();
        }
        return this.psdevslnmsdepfuncid;
    }

    public boolean isPSDevSlnMSDepFuncIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnMSDepFuncIdDirty();
        }
        return this.psdevslnmsdepfuncidDirtyFlag;
    }

    public void resetPSDevSlnMSDepFuncId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnMSDepFuncId();
            return;
        }
        this.psdevslnmsdepfuncidDirtyFlag = false;
        this.psdevslnmsdepfuncid = null;
    }

    public void setPSDevSlnMSDepFuncName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnMSDepFuncName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnmsdepfuncname = string;
        this.psdevslnmsdepfuncnameDirtyFlag = true;
    }

    public String getPSDevSlnMSDepFuncName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDepFuncName();
        }
        return this.psdevslnmsdepfuncname;
    }

    public boolean isPSDevSlnMSDepFuncNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnMSDepFuncNameDirty();
        }
        return this.psdevslnmsdepfuncnameDirtyFlag;
    }

    public void resetPSDevSlnMSDepFuncName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnMSDepFuncName();
            return;
        }
        this.psdevslnmsdepfuncnameDirtyFlag = false;
        this.psdevslnmsdepfuncname = null;
    }

    public void setPSDevSlnMSDeployId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnMSDeployId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnmsdeployid = string;
        this.psdevslnmsdeployidDirtyFlag = true;
    }

    public String getPSDevSlnMSDeployId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDeployId();
        }
        return this.psdevslnmsdeployid;
    }

    public boolean isPSDevSlnMSDeployIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnMSDeployIdDirty();
        }
        return this.psdevslnmsdeployidDirtyFlag;
    }

    public void resetPSDevSlnMSDeployId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnMSDeployId();
            return;
        }
        this.psdevslnmsdeployidDirtyFlag = false;
        this.psdevslnmsdeployid = null;
    }

    public void setPSDevSlnMSDeployName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnMSDeployName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnmsdeployname = string;
        this.psdevslnmsdeploynameDirtyFlag = true;
    }

    public String getPSDevSlnMSDeployName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDeployName();
        }
        return this.psdevslnmsdeployname;
    }

    public boolean isPSDevSlnMSDeployNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnMSDeployNameDirty();
        }
        return this.psdevslnmsdeploynameDirtyFlag;
    }

    public void resetPSDevSlnMSDeployName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnMSDeployName();
            return;
        }
        this.psdevslnmsdeploynameDirtyFlag = false;
        this.psdevslnmsdeployname = null;
    }

    public void setPSDevSlnPipelineId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnPipelineId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnpipelineid = string;
        this.psdevslnpipelineidDirtyFlag = true;
    }

    public String getPSDevSlnPipelineId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnPipelineId();
        }
        return this.psdevslnpipelineid;
    }

    public boolean isPSDevSlnPipelineIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnPipelineIdDirty();
        }
        return this.psdevslnpipelineidDirtyFlag;
    }

    public void resetPSDevSlnPipelineId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnPipelineId();
            return;
        }
        this.psdevslnpipelineidDirtyFlag = false;
        this.psdevslnpipelineid = null;
    }

    public void setPSDevSlnPipelineName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnPipelineName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnpipelinename = string;
        this.psdevslnpipelinenameDirtyFlag = true;
    }

    public String getPSDevSlnPipelineName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnPipelineName();
        }
        return this.psdevslnpipelinename;
    }

    public boolean isPSDevSlnPipelineNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnPipelineNameDirty();
        }
        return this.psdevslnpipelinenameDirtyFlag;
    }

    public void resetPSDevSlnPipelineName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnPipelineName();
            return;
        }
        this.psdevslnpipelinenameDirtyFlag = false;
        this.psdevslnpipelinename = null;
    }

    public void setPSDevSlnPipelineStageId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnPipelineStageId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnpipelinestageid = string;
        this.psdevslnpipelinestageidDirtyFlag = true;
    }

    public String getPSDevSlnPipelineStageId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnPipelineStageId();
        }
        return this.psdevslnpipelinestageid;
    }

    public boolean isPSDevSlnPipelineStageIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnPipelineStageIdDirty();
        }
        return this.psdevslnpipelinestageidDirtyFlag;
    }

    public void resetPSDevSlnPipelineStageId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnPipelineStageId();
            return;
        }
        this.psdevslnpipelinestageidDirtyFlag = false;
        this.psdevslnpipelinestageid = null;
    }

    public void setPSDevSlnPipelineStageName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnPipelineStageName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnpipelinestagename = string;
        this.psdevslnpipelinestagenameDirtyFlag = true;
    }

    public String getPSDevSlnPipelineStageName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnPipelineStageName();
        }
        return this.psdevslnpipelinestagename;
    }

    public boolean isPSDevSlnPipelineStageNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnPipelineStageNameDirty();
        }
        return this.psdevslnpipelinestagenameDirtyFlag;
    }

    public void resetPSDevSlnPipelineStageName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnPipelineStageName();
            return;
        }
        this.psdevslnpipelinestagenameDirtyFlag = false;
        this.psdevslnpipelinestagename = null;
    }

    public void setPSDevSlnPipelineStepId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnPipelineStepId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnpipelinestepid = string;
        this.psdevslnpipelinestepidDirtyFlag = true;
    }

    public String getPSDevSlnPipelineStepId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnPipelineStepId();
        }
        return this.psdevslnpipelinestepid;
    }

    public boolean isPSDevSlnPipelineStepIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnPipelineStepIdDirty();
        }
        return this.psdevslnpipelinestepidDirtyFlag;
    }

    public void resetPSDevSlnPipelineStepId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnPipelineStepId();
            return;
        }
        this.psdevslnpipelinestepidDirtyFlag = false;
        this.psdevslnpipelinestepid = null;
    }

    public void setPSDevSlnPipelineStepName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnPipelineStepName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnpipelinestepname = string;
        this.psdevslnpipelinestepnameDirtyFlag = true;
    }

    public String getPSDevSlnPipelineStepName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnPipelineStepName();
        }
        return this.psdevslnpipelinestepname;
    }

    public boolean isPSDevSlnPipelineStepNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnPipelineStepNameDirty();
        }
        return this.psdevslnpipelinestepnameDirtyFlag;
    }

    public void resetPSDevSlnPipelineStepName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnPipelineStepName();
            return;
        }
        this.psdevslnpipelinestepnameDirtyFlag = false;
        this.psdevslnpipelinestepname = null;
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

    public void setPSDevSlnSysAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysappid = string;
        this.psdevslnsysappidDirtyFlag = true;
    }

    public String getPSDevSlnSysAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysAppId();
        }
        return this.psdevslnsysappid;
    }

    public boolean isPSDevSlnSysAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysAppIdDirty();
        }
        return this.psdevslnsysappidDirtyFlag;
    }

    public void resetPSDevSlnSysAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysAppId();
            return;
        }
        this.psdevslnsysappidDirtyFlag = false;
        this.psdevslnsysappid = null;
    }

    public void setPSDevSlnSysAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysappname = string;
        this.psdevslnsysappnameDirtyFlag = true;
    }

    public String getPSDevSlnSysAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysAppName();
        }
        return this.psdevslnsysappname;
    }

    public boolean isPSDevSlnSysAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysAppNameDirty();
        }
        return this.psdevslnsysappnameDirtyFlag;
    }

    public void resetPSDevSlnSysAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysAppName();
            return;
        }
        this.psdevslnsysappnameDirtyFlag = false;
        this.psdevslnsysappname = null;
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

    public void setPSDevSlnSysSrvId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysSrvId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsyssrvid = string;
        this.psdevslnsyssrvidDirtyFlag = true;
    }

    public String getPSDevSlnSysSrvId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysSrvId();
        }
        return this.psdevslnsyssrvid;
    }

    public boolean isPSDevSlnSysSrvIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysSrvIdDirty();
        }
        return this.psdevslnsyssrvidDirtyFlag;
    }

    public void resetPSDevSlnSysSrvId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysSrvId();
            return;
        }
        this.psdevslnsyssrvidDirtyFlag = false;
        this.psdevslnsyssrvid = null;
    }

    public void setPSDevSlnSysSrvName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysSrvName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsyssrvname = string;
        this.psdevslnsyssrvnameDirtyFlag = true;
    }

    public String getPSDevSlnSysSrvName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysSrvName();
        }
        return this.psdevslnsyssrvname;
    }

    public boolean isPSDevSlnSysSrvNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysSrvNameDirty();
        }
        return this.psdevslnsyssrvnameDirtyFlag;
    }

    public void resetPSDevSlnSysSrvName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysSrvName();
            return;
        }
        this.psdevslnsyssrvnameDirtyFlag = false;
        this.psdevslnsyssrvname = null;
    }

    public void setPSDevSlnSysVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysverid = string;
        this.psdevslnsysveridDirtyFlag = true;
    }

    public String getPSDevSlnSysVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysVerId();
        }
        return this.psdevslnsysverid;
    }

    public boolean isPSDevSlnSysVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysVerIdDirty();
        }
        return this.psdevslnsysveridDirtyFlag;
    }

    public void resetPSDevSlnSysVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysVerId();
            return;
        }
        this.psdevslnsysveridDirtyFlag = false;
        this.psdevslnsysverid = null;
    }

    public void setPSDevSlnSysVerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysVerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysvername = string;
        this.psdevslnsysvernameDirtyFlag = true;
    }

    public String getPSDevSlnSysVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysVerName();
        }
        return this.psdevslnsysvername;
    }

    public boolean isPSDevSlnSysVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysVerNameDirty();
        }
        return this.psdevslnsysvernameDirtyFlag;
    }

    public void resetPSDevSlnSysVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysVerName();
            return;
        }
        this.psdevslnsysvernameDirtyFlag = false;
        this.psdevslnsysvername = null;
    }

    public void setPSDevSlnTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslntemplid = string;
        this.psdevslntemplidDirtyFlag = true;
    }

    public String getPSDevSlnTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnTemplId();
        }
        return this.psdevslntemplid;
    }

    public boolean isPSDevSlnTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnTemplIdDirty();
        }
        return this.psdevslntemplidDirtyFlag;
    }

    public void resetPSDevSlnTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnTemplId();
            return;
        }
        this.psdevslntemplidDirtyFlag = false;
        this.psdevslntemplid = null;
    }

    public void setPSDevSlnTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslntemplname = string;
        this.psdevslntemplnameDirtyFlag = true;
    }

    public String getPSDevSlnTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnTemplName();
        }
        return this.psdevslntemplname;
    }

    public boolean isPSDevSlnTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnTemplNameDirty();
        }
        return this.psdevslntemplnameDirtyFlag;
    }

    public void resetPSDevSlnTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnTemplName();
            return;
        }
        this.psdevslntemplnameDirtyFlag = false;
        this.psdevslntemplname = null;
    }

    public void setRefPSDevSlnPipelineId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSDevSlnPipelineId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsdevslnpipelineid = string;
        this.refpsdevslnpipelineidDirtyFlag = true;
    }

    public String getRefPSDevSlnPipelineId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDevSlnPipelineId();
        }
        return this.refpsdevslnpipelineid;
    }

    public boolean isRefPSDevSlnPipelineIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSDevSlnPipelineIdDirty();
        }
        return this.refpsdevslnpipelineidDirtyFlag;
    }

    public void resetRefPSDevSlnPipelineId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSDevSlnPipelineId();
            return;
        }
        this.refpsdevslnpipelineidDirtyFlag = false;
        this.refpsdevslnpipelineid = null;
    }

    public void setRefPSDevSlnPipelineName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSDevSlnPipelineName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsdevslnpipelinename = string;
        this.refpsdevslnpipelinenameDirtyFlag = true;
    }

    public String getRefPSDevSlnPipelineName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDevSlnPipelineName();
        }
        return this.refpsdevslnpipelinename;
    }

    public boolean isRefPSDevSlnPipelineNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSDevSlnPipelineNameDirty();
        }
        return this.refpsdevslnpipelinenameDirtyFlag;
    }

    public void resetRefPSDevSlnPipelineName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSDevSlnPipelineName();
            return;
        }
        this.refpsdevslnpipelinenameDirtyFlag = false;
        this.refpsdevslnpipelinename = null;
    }

    public void setRunCmd(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRunCmd(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.runcmd = string;
        this.runcmdDirtyFlag = true;
    }

    public String getRunCmd() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRunCmd();
        }
        return this.runcmd;
    }

    public boolean isRunCmdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRunCmdDirty();
        }
        return this.runcmdDirtyFlag;
    }

    public void resetRunCmd() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRunCmd();
            return;
        }
        this.runcmdDirtyFlag = false;
        this.runcmd = null;
    }

    public void setStepTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStepTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.steptag = string;
        this.steptagDirtyFlag = true;
    }

    public String getStepTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStepTag();
        }
        return this.steptag;
    }

    public boolean isStepTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStepTagDirty();
        }
        return this.steptagDirtyFlag;
    }

    public void resetStepTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStepTag();
            return;
        }
        this.steptagDirtyFlag = false;
        this.steptag = null;
    }

    public void setStepTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStepTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.steptag2 = string;
        this.steptag2DirtyFlag = true;
    }

    public String getStepTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStepTag2();
        }
        return this.steptag2;
    }

    public boolean isStepTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStepTag2Dirty();
        }
        return this.steptag2DirtyFlag;
    }

    public void resetStepTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStepTag2();
            return;
        }
        this.steptag2DirtyFlag = false;
        this.steptag2 = null;
    }

    public void setStepTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStepTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.steptag3 = string;
        this.steptag3DirtyFlag = true;
    }

    public String getStepTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStepTag3();
        }
        return this.steptag3;
    }

    public boolean isStepTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStepTag3Dirty();
        }
        return this.steptag3DirtyFlag;
    }

    public void resetStepTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStepTag3();
            return;
        }
        this.steptag3DirtyFlag = false;
        this.steptag3 = null;
    }

    public void setStepTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStepTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.steptag4 = string;
        this.steptag4DirtyFlag = true;
    }

    public String getStepTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStepTag4();
        }
        return this.steptag4;
    }

    public boolean isStepTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStepTag4Dirty();
        }
        return this.steptag4DirtyFlag;
    }

    public void resetStepTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStepTag4();
            return;
        }
        this.steptag4DirtyFlag = false;
        this.steptag4 = null;
    }

    public void setTemplateMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplateMode(n);
            return;
        }
        this.templatemode = n;
        this.templatemodeDirtyFlag = true;
    }

    public Integer getTemplateMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplateMode();
        }
        return this.templatemode;
    }

    public boolean isTemplateModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplateModeDirty();
        }
        return this.templatemodeDirtyFlag;
    }

    public void resetTemplateMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplateMode();
            return;
        }
        this.templatemodeDirtyFlag = false;
        this.templatemode = null;
    }

    public void setTemplPSDevCenterSVNId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplPSDevCenterSVNId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templpsdevcentersvnid = string;
        this.templpsdevcentersvnidDirtyFlag = true;
    }

    public String getTemplPSDevCenterSVNId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplPSDevCenterSVNId();
        }
        return this.templpsdevcentersvnid;
    }

    public boolean isTemplPSDevCenterSVNIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplPSDevCenterSVNIdDirty();
        }
        return this.templpsdevcentersvnidDirtyFlag;
    }

    public void resetTemplPSDevCenterSVNId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplPSDevCenterSVNId();
            return;
        }
        this.templpsdevcentersvnidDirtyFlag = false;
        this.templpsdevcentersvnid = null;
    }

    public void setTemplPSDevCenterSVNName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplPSDevCenterSVNName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templpsdevcentersvnname = string;
        this.templpsdevcentersvnnameDirtyFlag = true;
    }

    public String getTemplPSDevCenterSVNName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplPSDevCenterSVNName();
        }
        return this.templpsdevcentersvnname;
    }

    public boolean isTemplPSDevCenterSVNNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplPSDevCenterSVNNameDirty();
        }
        return this.templpsdevcentersvnnameDirtyFlag;
    }

    public void resetTemplPSDevCenterSVNName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplPSDevCenterSVNName();
            return;
        }
        this.templpsdevcentersvnnameDirtyFlag = false;
        this.templpsdevcentersvnname = null;
    }

    public void setToolPSDCRegistryItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setToolPSDCRegistryItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.toolpsdcregistryitemid = string;
        this.toolpsdcregistryitemidDirtyFlag = true;
    }

    public String getToolPSDCRegistryItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getToolPSDCRegistryItemId();
        }
        return this.toolpsdcregistryitemid;
    }

    public boolean isToolPSDCRegistryItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isToolPSDCRegistryItemIdDirty();
        }
        return this.toolpsdcregistryitemidDirtyFlag;
    }

    public void resetToolPSDCRegistryItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetToolPSDCRegistryItemId();
            return;
        }
        this.toolpsdcregistryitemidDirtyFlag = false;
        this.toolpsdcregistryitemid = null;
    }

    public void setToolPSDCRegistryItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setToolPSDCRegistryItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.toolpsdcregistryitemname = string;
        this.toolpsdcregistryitemnameDirtyFlag = true;
    }

    public String getToolPSDCRegistryItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getToolPSDCRegistryItemName();
        }
        return this.toolpsdcregistryitemname;
    }

    public boolean isToolPSDCRegistryItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isToolPSDCRegistryItemNameDirty();
        }
        return this.toolpsdcregistryitemnameDirtyFlag;
    }

    public void resetToolPSDCRegistryItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetToolPSDCRegistryItemName();
            return;
        }
        this.toolpsdcregistryitemnameDirtyFlag = false;
        this.toolpsdcregistryitemname = null;
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

    public void setWorkFolder(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWorkFolder(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.workfolder = string;
        this.workfolderDirtyFlag = true;
    }

    public String getWorkFolder() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWorkFolder();
        }
        return this.workfolder;
    }

    public boolean isWorkFolderDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWorkFolderDirty();
        }
        return this.workfolderDirtyFlag;
    }

    public void resetWorkFolder() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWorkFolder();
            return;
        }
        this.workfolderDirtyFlag = false;
        this.workfolder = null;
    }

    protected void onReset() {
        PSDevSlnPipelineStepBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevSlnPipelineStepBase pSDevSlnPipelineStepBase) {
        pSDevSlnPipelineStepBase.resetActionParams();
        pSDevSlnPipelineStepBase.resetActionType();
        pSDevSlnPipelineStepBase.resetAgentPSDCRegistryItemId();
        pSDevSlnPipelineStepBase.resetAgentPSDCRegistryItemName();
        pSDevSlnPipelineStepBase.resetCheckinMode();
        pSDevSlnPipelineStepBase.resetCodeName();
        pSDevSlnPipelineStepBase.resetCondModel();
        pSDevSlnPipelineStepBase.resetCondModelFlag();
        pSDevSlnPipelineStepBase.resetCreateDate();
        pSDevSlnPipelineStepBase.resetCreateMan();
        pSDevSlnPipelineStepBase.resetCustomCheckout();
        pSDevSlnPipelineStepBase.resetCustomCode();
        pSDevSlnPipelineStepBase.resetMemo();
        pSDevSlnPipelineStepBase.resetModelPSDevCenterSVNId();
        pSDevSlnPipelineStepBase.resetModelPSDevCenterSVNName();
        pSDevSlnPipelineStepBase.resetOrderValue();
        pSDevSlnPipelineStepBase.resetPSDCBDInstId();
        pSDevSlnPipelineStepBase.resetPSDCBDInstName();
        pSDevSlnPipelineStepBase.resetPSDCCodeSnippetId();
        pSDevSlnPipelineStepBase.resetPSDCCodeSnippetName();
        pSDevSlnPipelineStepBase.resetPSDCFileId();
        pSDevSlnPipelineStepBase.resetPSDCFileName();
        pSDevSlnPipelineStepBase.resetPSDCMSPlatformFuncId();
        pSDevSlnPipelineStepBase.resetPSDCMSPlatformFuncName();
        pSDevSlnPipelineStepBase.resetPSDCMSPlatformId();
        pSDevSlnPipelineStepBase.resetPSDCMSPlatformName();
        pSDevSlnPipelineStepBase.resetPSDCMSPlatformNodeId();
        pSDevSlnPipelineStepBase.resetPSDCMSPlatformNodeName();
        pSDevSlnPipelineStepBase.resetPSDCRegistryItemId();
        pSDevSlnPipelineStepBase.resetPSDCRegistryItemName();
        pSDevSlnPipelineStepBase.resetPSDCRegistryRepoId();
        pSDevSlnPipelineStepBase.resetPSDCRegistryRepoName();
        pSDevSlnPipelineStepBase.resetPSDevCenterDBInstId();
        pSDevSlnPipelineStepBase.resetPSDevCenterDBInstName();
        pSDevSlnPipelineStepBase.resetPSDevCenterSVNId();
        pSDevSlnPipelineStepBase.resetPSDevCenterSVNName();
        pSDevSlnPipelineStepBase.resetPSDevSlnId();
        pSDevSlnPipelineStepBase.resetPSDevSlnMSDepAPIId();
        pSDevSlnPipelineStepBase.resetPSDevSlnMSDepAPIName();
        pSDevSlnPipelineStepBase.resetPSDevSlnMSDepAppId();
        pSDevSlnPipelineStepBase.resetPSDevSlnMSDepAppName();
        pSDevSlnPipelineStepBase.resetPSDevSlnMSDepFuncId();
        pSDevSlnPipelineStepBase.resetPSDevSlnMSDepFuncName();
        pSDevSlnPipelineStepBase.resetPSDevSlnMSDeployId();
        pSDevSlnPipelineStepBase.resetPSDevSlnMSDeployName();
        pSDevSlnPipelineStepBase.resetPSDevSlnPipelineId();
        pSDevSlnPipelineStepBase.resetPSDevSlnPipelineName();
        pSDevSlnPipelineStepBase.resetPSDevSlnPipelineStageId();
        pSDevSlnPipelineStepBase.resetPSDevSlnPipelineStageName();
        pSDevSlnPipelineStepBase.resetPSDevSlnPipelineStepId();
        pSDevSlnPipelineStepBase.resetPSDevSlnPipelineStepName();
        pSDevSlnPipelineStepBase.resetPSDevSlnSysAPIId();
        pSDevSlnPipelineStepBase.resetPSDevSlnSysAPIName();
        pSDevSlnPipelineStepBase.resetPSDevSlnSysAppId();
        pSDevSlnPipelineStepBase.resetPSDevSlnSysAppName();
        pSDevSlnPipelineStepBase.resetPSDevSlnSysId();
        pSDevSlnPipelineStepBase.resetPSDevSlnSysName();
        pSDevSlnPipelineStepBase.resetPSDevSlnSysSrvId();
        pSDevSlnPipelineStepBase.resetPSDevSlnSysSrvName();
        pSDevSlnPipelineStepBase.resetPSDevSlnSysVerId();
        pSDevSlnPipelineStepBase.resetPSDevSlnSysVerName();
        pSDevSlnPipelineStepBase.resetPSDevSlnTemplId();
        pSDevSlnPipelineStepBase.resetPSDevSlnTemplName();
        pSDevSlnPipelineStepBase.resetRefPSDevSlnPipelineId();
        pSDevSlnPipelineStepBase.resetRefPSDevSlnPipelineName();
        pSDevSlnPipelineStepBase.resetRunCmd();
        pSDevSlnPipelineStepBase.resetStepTag();
        pSDevSlnPipelineStepBase.resetStepTag2();
        pSDevSlnPipelineStepBase.resetStepTag3();
        pSDevSlnPipelineStepBase.resetStepTag4();
        pSDevSlnPipelineStepBase.resetTemplateMode();
        pSDevSlnPipelineStepBase.resetTemplPSDevCenterSVNId();
        pSDevSlnPipelineStepBase.resetTemplPSDevCenterSVNName();
        pSDevSlnPipelineStepBase.resetToolPSDCRegistryItemId();
        pSDevSlnPipelineStepBase.resetToolPSDCRegistryItemName();
        pSDevSlnPipelineStepBase.resetUpdateDate();
        pSDevSlnPipelineStepBase.resetUpdateMan();
        pSDevSlnPipelineStepBase.resetUserCat();
        pSDevSlnPipelineStepBase.resetUserTag();
        pSDevSlnPipelineStepBase.resetUserTag2();
        pSDevSlnPipelineStepBase.resetUserTag3();
        pSDevSlnPipelineStepBase.resetUserTag4();
        pSDevSlnPipelineStepBase.resetValidFlag();
        pSDevSlnPipelineStepBase.resetWorkFolder();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isActionParamsDirty()) {
            hashMap.put(FIELD_ACTIONPARAMS, this.getActionParams());
        }
        if (!bl || this.isActionTypeDirty()) {
            hashMap.put(FIELD_ACTIONTYPE, this.getActionType());
        }
        if (!bl || this.isAgentPSDCRegistryItemIdDirty()) {
            hashMap.put(FIELD_AGENTPSDCREGISTRYITEMID, this.getAgentPSDCRegistryItemId());
        }
        if (!bl || this.isAgentPSDCRegistryItemNameDirty()) {
            hashMap.put(FIELD_AGENTPSDCREGISTRYITEMNAME, this.getAgentPSDCRegistryItemName());
        }
        if (!bl || this.isCheckinModeDirty()) {
            hashMap.put(FIELD_CHECKINMODE, this.getCheckinMode());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCondModelDirty()) {
            hashMap.put(FIELD_CONDMODEL, this.getCondModel());
        }
        if (!bl || this.isCondModelFlagDirty()) {
            hashMap.put(FIELD_CONDMODELFLAG, this.getCondModelFlag());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCustomCheckoutDirty()) {
            hashMap.put(FIELD_CUSTOMCHECKOUT, this.getCustomCheckout());
        }
        if (!bl || this.isCustomCodeDirty()) {
            hashMap.put(FIELD_CUSTOMCODE, this.getCustomCode());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isModelPSDevCenterSVNIdDirty()) {
            hashMap.put(FIELD_MODELPSDEVCENTERSVNID, this.getModelPSDevCenterSVNId());
        }
        if (!bl || this.isModelPSDevCenterSVNNameDirty()) {
            hashMap.put(FIELD_MODELPSDEVCENTERSVNNAME, this.getModelPSDevCenterSVNName());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSDCBDInstIdDirty()) {
            hashMap.put(FIELD_PSDCBDINSTID, this.getPSDCBDInstId());
        }
        if (!bl || this.isPSDCBDInstNameDirty()) {
            hashMap.put(FIELD_PSDCBDINSTNAME, this.getPSDCBDInstName());
        }
        if (!bl || this.isPSDCCodeSnippetIdDirty()) {
            hashMap.put(FIELD_PSDCCODESNIPPETID, this.getPSDCCodeSnippetId());
        }
        if (!bl || this.isPSDCCodeSnippetNameDirty()) {
            hashMap.put(FIELD_PSDCCODESNIPPETNAME, this.getPSDCCodeSnippetName());
        }
        if (!bl || this.isPSDCFileIdDirty()) {
            hashMap.put(FIELD_PSDCFILEID, this.getPSDCFileId());
        }
        if (!bl || this.isPSDCFileNameDirty()) {
            hashMap.put(FIELD_PSDCFILENAME, this.getPSDCFileName());
        }
        if (!bl || this.isPSDCMSPlatformFuncIdDirty()) {
            hashMap.put(FIELD_PSDCMSPLATFORMFUNCID, this.getPSDCMSPlatformFuncId());
        }
        if (!bl || this.isPSDCMSPlatformFuncNameDirty()) {
            hashMap.put(FIELD_PSDCMSPLATFORMFUNCNAME, this.getPSDCMSPlatformFuncName());
        }
        if (!bl || this.isPSDCMSPlatformIdDirty()) {
            hashMap.put(FIELD_PSDCMSPLATFORMID, this.getPSDCMSPlatformId());
        }
        if (!bl || this.isPSDCMSPlatformNameDirty()) {
            hashMap.put(FIELD_PSDCMSPLATFORMNAME, this.getPSDCMSPlatformName());
        }
        if (!bl || this.isPSDCMSPlatformNodeIdDirty()) {
            hashMap.put(FIELD_PSDCMSPLATFORMNODEID, this.getPSDCMSPlatformNodeId());
        }
        if (!bl || this.isPSDCMSPlatformNodeNameDirty()) {
            hashMap.put(FIELD_PSDCMSPLATFORMNODENAME, this.getPSDCMSPlatformNodeName());
        }
        if (!bl || this.isPSDCRegistryItemIdDirty()) {
            hashMap.put(FIELD_PSDCREGISTRYITEMID, this.getPSDCRegistryItemId());
        }
        if (!bl || this.isPSDCRegistryItemNameDirty()) {
            hashMap.put(FIELD_PSDCREGISTRYITEMNAME, this.getPSDCRegistryItemName());
        }
        if (!bl || this.isPSDCRegistryRepoIdDirty()) {
            hashMap.put(FIELD_PSDCREGISTRYREPOID, this.getPSDCRegistryRepoId());
        }
        if (!bl || this.isPSDCRegistryRepoNameDirty()) {
            hashMap.put(FIELD_PSDCREGISTRYREPONAME, this.getPSDCRegistryRepoName());
        }
        if (!bl || this.isPSDevCenterDBInstIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERDBINSTID, this.getPSDevCenterDBInstId());
        }
        if (!bl || this.isPSDevCenterDBInstNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERDBINSTNAME, this.getPSDevCenterDBInstName());
        }
        if (!bl || this.isPSDevCenterSVNIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERSVNID, this.getPSDevCenterSVNId());
        }
        if (!bl || this.isPSDevCenterSVNNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERSVNNAME, this.getPSDevCenterSVNName());
        }
        if (!bl || this.isPSDevSlnIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNID, this.getPSDevSlnId());
        }
        if (!bl || this.isPSDevSlnMSDepAPIIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNMSDEPAPIID, this.getPSDevSlnMSDepAPIId());
        }
        if (!bl || this.isPSDevSlnMSDepAPINameDirty()) {
            hashMap.put(FIELD_PSDEVSLNMSDEPAPINAME, this.getPSDevSlnMSDepAPIName());
        }
        if (!bl || this.isPSDevSlnMSDepAppIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNMSDEPAPPID, this.getPSDevSlnMSDepAppId());
        }
        if (!bl || this.isPSDevSlnMSDepAppNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNMSDEPAPPNAME, this.getPSDevSlnMSDepAppName());
        }
        if (!bl || this.isPSDevSlnMSDepFuncIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNMSDEPFUNCID, this.getPSDevSlnMSDepFuncId());
        }
        if (!bl || this.isPSDevSlnMSDepFuncNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNMSDEPFUNCNAME, this.getPSDevSlnMSDepFuncName());
        }
        if (!bl || this.isPSDevSlnMSDeployIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNMSDEPLOYID, this.getPSDevSlnMSDeployId());
        }
        if (!bl || this.isPSDevSlnMSDeployNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNMSDEPLOYNAME, this.getPSDevSlnMSDeployName());
        }
        if (!bl || this.isPSDevSlnPipelineIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNPIPELINEID, this.getPSDevSlnPipelineId());
        }
        if (!bl || this.isPSDevSlnPipelineNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNPIPELINENAME, this.getPSDevSlnPipelineName());
        }
        if (!bl || this.isPSDevSlnPipelineStageIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNPIPELINESTAGEID, this.getPSDevSlnPipelineStageId());
        }
        if (!bl || this.isPSDevSlnPipelineStageNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNPIPELINESTAGENAME, this.getPSDevSlnPipelineStageName());
        }
        if (!bl || this.isPSDevSlnPipelineStepIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNPIPELINESTEPID, this.getPSDevSlnPipelineStepId());
        }
        if (!bl || this.isPSDevSlnPipelineStepNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNPIPELINESTEPNAME, this.getPSDevSlnPipelineStepName());
        }
        if (!bl || this.isPSDevSlnSysAPIIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSAPIID, this.getPSDevSlnSysAPIId());
        }
        if (!bl || this.isPSDevSlnSysAPINameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSAPINAME, this.getPSDevSlnSysAPIName());
        }
        if (!bl || this.isPSDevSlnSysAppIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSAPPID, this.getPSDevSlnSysAppId());
        }
        if (!bl || this.isPSDevSlnSysAppNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSAPPNAME, this.getPSDevSlnSysAppName());
        }
        if (!bl || this.isPSDevSlnSysIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSID, this.getPSDevSlnSysId());
        }
        if (!bl || this.isPSDevSlnSysNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSNAME, this.getPSDevSlnSysName());
        }
        if (!bl || this.isPSDevSlnSysSrvIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSSRVID, this.getPSDevSlnSysSrvId());
        }
        if (!bl || this.isPSDevSlnSysSrvNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSSRVNAME, this.getPSDevSlnSysSrvName());
        }
        if (!bl || this.isPSDevSlnSysVerIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSVERID, this.getPSDevSlnSysVerId());
        }
        if (!bl || this.isPSDevSlnSysVerNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSVERNAME, this.getPSDevSlnSysVerName());
        }
        if (!bl || this.isPSDevSlnTemplIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNTEMPLID, this.getPSDevSlnTemplId());
        }
        if (!bl || this.isPSDevSlnTemplNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNTEMPLNAME, this.getPSDevSlnTemplName());
        }
        if (!bl || this.isRefPSDevSlnPipelineIdDirty()) {
            hashMap.put(FIELD_REFPSDEVSLNPIPELINEID, this.getRefPSDevSlnPipelineId());
        }
        if (!bl || this.isRefPSDevSlnPipelineNameDirty()) {
            hashMap.put(FIELD_REFPSDEVSLNPIPELINENAME, this.getRefPSDevSlnPipelineName());
        }
        if (!bl || this.isRunCmdDirty()) {
            hashMap.put(FIELD_RUNCMD, this.getRunCmd());
        }
        if (!bl || this.isStepTagDirty()) {
            hashMap.put(FIELD_STEPTAG, this.getStepTag());
        }
        if (!bl || this.isStepTag2Dirty()) {
            hashMap.put(FIELD_STEPTAG2, this.getStepTag2());
        }
        if (!bl || this.isStepTag3Dirty()) {
            hashMap.put(FIELD_STEPTAG3, this.getStepTag3());
        }
        if (!bl || this.isStepTag4Dirty()) {
            hashMap.put(FIELD_STEPTAG4, this.getStepTag4());
        }
        if (!bl || this.isTemplateModeDirty()) {
            hashMap.put(FIELD_TEMPLATEMODE, this.getTemplateMode());
        }
        if (!bl || this.isTemplPSDevCenterSVNIdDirty()) {
            hashMap.put(FIELD_TEMPLPSDEVCENTERSVNID, this.getTemplPSDevCenterSVNId());
        }
        if (!bl || this.isTemplPSDevCenterSVNNameDirty()) {
            hashMap.put(FIELD_TEMPLPSDEVCENTERSVNNAME, this.getTemplPSDevCenterSVNName());
        }
        if (!bl || this.isToolPSDCRegistryItemIdDirty()) {
            hashMap.put(FIELD_TOOLPSDCREGISTRYITEMID, this.getToolPSDCRegistryItemId());
        }
        if (!bl || this.isToolPSDCRegistryItemNameDirty()) {
            hashMap.put(FIELD_TOOLPSDCREGISTRYITEMNAME, this.getToolPSDCRegistryItemName());
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
        if (!bl || this.isWorkFolderDirty()) {
            hashMap.put(FIELD_WORKFOLDER, this.getWorkFolder());
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
        return PSDevSlnPipelineStepBase.get(this, n);
    }

    private static Object get(PSDevSlnPipelineStepBase pSDevSlnPipelineStepBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnPipelineStepBase.getActionParams();
            }
            case 1: {
                return pSDevSlnPipelineStepBase.getActionType();
            }
            case 2: {
                return pSDevSlnPipelineStepBase.getAgentPSDCRegistryItemId();
            }
            case 3: {
                return pSDevSlnPipelineStepBase.getAgentPSDCRegistryItemName();
            }
            case 4: {
                return pSDevSlnPipelineStepBase.getCheckinMode();
            }
            case 5: {
                return pSDevSlnPipelineStepBase.getCodeName();
            }
            case 6: {
                return pSDevSlnPipelineStepBase.getCondModel();
            }
            case 7: {
                return pSDevSlnPipelineStepBase.getCondModelFlag();
            }
            case 8: {
                return pSDevSlnPipelineStepBase.getCreateDate();
            }
            case 9: {
                return pSDevSlnPipelineStepBase.getCreateMan();
            }
            case 10: {
                return pSDevSlnPipelineStepBase.getCustomCheckout();
            }
            case 11: {
                return pSDevSlnPipelineStepBase.getCustomCode();
            }
            case 12: {
                return pSDevSlnPipelineStepBase.getMemo();
            }
            case 13: {
                return pSDevSlnPipelineStepBase.getModelPSDevCenterSVNId();
            }
            case 14: {
                return pSDevSlnPipelineStepBase.getModelPSDevCenterSVNName();
            }
            case 15: {
                return pSDevSlnPipelineStepBase.getOrderValue();
            }
            case 16: {
                return pSDevSlnPipelineStepBase.getPSDCBDInstId();
            }
            case 17: {
                return pSDevSlnPipelineStepBase.getPSDCBDInstName();
            }
            case 18: {
                return pSDevSlnPipelineStepBase.getPSDCCodeSnippetId();
            }
            case 19: {
                return pSDevSlnPipelineStepBase.getPSDCCodeSnippetName();
            }
            case 20: {
                return pSDevSlnPipelineStepBase.getPSDCFileId();
            }
            case 21: {
                return pSDevSlnPipelineStepBase.getPSDCFileName();
            }
            case 22: {
                return pSDevSlnPipelineStepBase.getPSDCMSPlatformFuncId();
            }
            case 23: {
                return pSDevSlnPipelineStepBase.getPSDCMSPlatformFuncName();
            }
            case 24: {
                return pSDevSlnPipelineStepBase.getPSDCMSPlatformId();
            }
            case 25: {
                return pSDevSlnPipelineStepBase.getPSDCMSPlatformName();
            }
            case 26: {
                return pSDevSlnPipelineStepBase.getPSDCMSPlatformNodeId();
            }
            case 27: {
                return pSDevSlnPipelineStepBase.getPSDCMSPlatformNodeName();
            }
            case 28: {
                return pSDevSlnPipelineStepBase.getPSDCRegistryItemId();
            }
            case 29: {
                return pSDevSlnPipelineStepBase.getPSDCRegistryItemName();
            }
            case 30: {
                return pSDevSlnPipelineStepBase.getPSDCRegistryRepoId();
            }
            case 31: {
                return pSDevSlnPipelineStepBase.getPSDCRegistryRepoName();
            }
            case 32: {
                return pSDevSlnPipelineStepBase.getPSDevCenterDBInstId();
            }
            case 33: {
                return pSDevSlnPipelineStepBase.getPSDevCenterDBInstName();
            }
            case 34: {
                return pSDevSlnPipelineStepBase.getPSDevCenterSVNId();
            }
            case 35: {
                return pSDevSlnPipelineStepBase.getPSDevCenterSVNName();
            }
            case 36: {
                return pSDevSlnPipelineStepBase.getPSDevSlnId();
            }
            case 37: {
                return pSDevSlnPipelineStepBase.getPSDevSlnMSDepAPIId();
            }
            case 38: {
                return pSDevSlnPipelineStepBase.getPSDevSlnMSDepAPIName();
            }
            case 39: {
                return pSDevSlnPipelineStepBase.getPSDevSlnMSDepAppId();
            }
            case 40: {
                return pSDevSlnPipelineStepBase.getPSDevSlnMSDepAppName();
            }
            case 41: {
                return pSDevSlnPipelineStepBase.getPSDevSlnMSDepFuncId();
            }
            case 42: {
                return pSDevSlnPipelineStepBase.getPSDevSlnMSDepFuncName();
            }
            case 43: {
                return pSDevSlnPipelineStepBase.getPSDevSlnMSDeployId();
            }
            case 44: {
                return pSDevSlnPipelineStepBase.getPSDevSlnMSDeployName();
            }
            case 45: {
                return pSDevSlnPipelineStepBase.getPSDevSlnPipelineId();
            }
            case 46: {
                return pSDevSlnPipelineStepBase.getPSDevSlnPipelineName();
            }
            case 47: {
                return pSDevSlnPipelineStepBase.getPSDevSlnPipelineStageId();
            }
            case 48: {
                return pSDevSlnPipelineStepBase.getPSDevSlnPipelineStageName();
            }
            case 49: {
                return pSDevSlnPipelineStepBase.getPSDevSlnPipelineStepId();
            }
            case 50: {
                return pSDevSlnPipelineStepBase.getPSDevSlnPipelineStepName();
            }
            case 51: {
                return pSDevSlnPipelineStepBase.getPSDevSlnSysAPIId();
            }
            case 52: {
                return pSDevSlnPipelineStepBase.getPSDevSlnSysAPIName();
            }
            case 53: {
                return pSDevSlnPipelineStepBase.getPSDevSlnSysAppId();
            }
            case 54: {
                return pSDevSlnPipelineStepBase.getPSDevSlnSysAppName();
            }
            case 55: {
                return pSDevSlnPipelineStepBase.getPSDevSlnSysId();
            }
            case 56: {
                return pSDevSlnPipelineStepBase.getPSDevSlnSysName();
            }
            case 57: {
                return pSDevSlnPipelineStepBase.getPSDevSlnSysSrvId();
            }
            case 58: {
                return pSDevSlnPipelineStepBase.getPSDevSlnSysSrvName();
            }
            case 59: {
                return pSDevSlnPipelineStepBase.getPSDevSlnSysVerId();
            }
            case 60: {
                return pSDevSlnPipelineStepBase.getPSDevSlnSysVerName();
            }
            case 61: {
                return pSDevSlnPipelineStepBase.getPSDevSlnTemplId();
            }
            case 62: {
                return pSDevSlnPipelineStepBase.getPSDevSlnTemplName();
            }
            case 63: {
                return pSDevSlnPipelineStepBase.getRefPSDevSlnPipelineId();
            }
            case 64: {
                return pSDevSlnPipelineStepBase.getRefPSDevSlnPipelineName();
            }
            case 65: {
                return pSDevSlnPipelineStepBase.getRunCmd();
            }
            case 66: {
                return pSDevSlnPipelineStepBase.getStepTag();
            }
            case 67: {
                return pSDevSlnPipelineStepBase.getStepTag2();
            }
            case 68: {
                return pSDevSlnPipelineStepBase.getStepTag3();
            }
            case 69: {
                return pSDevSlnPipelineStepBase.getStepTag4();
            }
            case 70: {
                return pSDevSlnPipelineStepBase.getTemplateMode();
            }
            case 71: {
                return pSDevSlnPipelineStepBase.getTemplPSDevCenterSVNId();
            }
            case 72: {
                return pSDevSlnPipelineStepBase.getTemplPSDevCenterSVNName();
            }
            case 73: {
                return pSDevSlnPipelineStepBase.getToolPSDCRegistryItemId();
            }
            case 74: {
                return pSDevSlnPipelineStepBase.getToolPSDCRegistryItemName();
            }
            case 75: {
                return pSDevSlnPipelineStepBase.getUpdateDate();
            }
            case 76: {
                return pSDevSlnPipelineStepBase.getUpdateMan();
            }
            case 77: {
                return pSDevSlnPipelineStepBase.getUserCat();
            }
            case 78: {
                return pSDevSlnPipelineStepBase.getUserTag();
            }
            case 79: {
                return pSDevSlnPipelineStepBase.getUserTag2();
            }
            case 80: {
                return pSDevSlnPipelineStepBase.getUserTag3();
            }
            case 81: {
                return pSDevSlnPipelineStepBase.getUserTag4();
            }
            case 82: {
                return pSDevSlnPipelineStepBase.getValidFlag();
            }
            case 83: {
                return pSDevSlnPipelineStepBase.getWorkFolder();
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
        PSDevSlnPipelineStepBase.set(this, n, object);
    }

    private static void set(PSDevSlnPipelineStepBase pSDevSlnPipelineStepBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnPipelineStepBase.setActionParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDevSlnPipelineStepBase.setActionType(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevSlnPipelineStepBase.setAgentPSDCRegistryItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDevSlnPipelineStepBase.setAgentPSDCRegistryItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevSlnPipelineStepBase.setCheckinMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDevSlnPipelineStepBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevSlnPipelineStepBase.setCondModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevSlnPipelineStepBase.setCondModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSDevSlnPipelineStepBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSDevSlnPipelineStepBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevSlnPipelineStepBase.setCustomCheckout(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSDevSlnPipelineStepBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevSlnPipelineStepBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDevSlnPipelineStepBase.setModelPSDevCenterSVNId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDevSlnPipelineStepBase.setModelPSDevCenterSVNName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDevSlnPipelineStepBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSDevSlnPipelineStepBase.setPSDCBDInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDevSlnPipelineStepBase.setPSDCBDInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDevSlnPipelineStepBase.setPSDCCodeSnippetId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDevSlnPipelineStepBase.setPSDCCodeSnippetName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDevSlnPipelineStepBase.setPSDCFileId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDevSlnPipelineStepBase.setPSDCFileName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDevSlnPipelineStepBase.setPSDCMSPlatformFuncId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDevSlnPipelineStepBase.setPSDCMSPlatformFuncName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDevSlnPipelineStepBase.setPSDCMSPlatformId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDevSlnPipelineStepBase.setPSDCMSPlatformName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDevSlnPipelineStepBase.setPSDCMSPlatformNodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDevSlnPipelineStepBase.setPSDCMSPlatformNodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDevSlnPipelineStepBase.setPSDCRegistryItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDevSlnPipelineStepBase.setPSDCRegistryItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDevSlnPipelineStepBase.setPSDCRegistryRepoId(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDevSlnPipelineStepBase.setPSDCRegistryRepoName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDevSlnPipelineStepBase.setPSDevCenterDBInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDevSlnPipelineStepBase.setPSDevCenterDBInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDevSlnPipelineStepBase.setPSDevCenterSVNId(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDevSlnPipelineStepBase.setPSDevCenterSVNName(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDevSlnPipelineStepBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDevSlnPipelineStepBase.setPSDevSlnMSDepAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDevSlnPipelineStepBase.setPSDevSlnMSDepAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDevSlnPipelineStepBase.setPSDevSlnMSDepAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDevSlnPipelineStepBase.setPSDevSlnMSDepAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDevSlnPipelineStepBase.setPSDevSlnMSDepFuncId(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDevSlnPipelineStepBase.setPSDevSlnMSDepFuncName(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSDevSlnPipelineStepBase.setPSDevSlnMSDeployId(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSDevSlnPipelineStepBase.setPSDevSlnMSDeployName(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSDevSlnPipelineStepBase.setPSDevSlnPipelineId(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSDevSlnPipelineStepBase.setPSDevSlnPipelineName(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSDevSlnPipelineStepBase.setPSDevSlnPipelineStageId(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSDevSlnPipelineStepBase.setPSDevSlnPipelineStageName(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSDevSlnPipelineStepBase.setPSDevSlnPipelineStepId(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSDevSlnPipelineStepBase.setPSDevSlnPipelineStepName(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSDevSlnPipelineStepBase.setPSDevSlnSysAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSDevSlnPipelineStepBase.setPSDevSlnSysAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSDevSlnPipelineStepBase.setPSDevSlnSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSDevSlnPipelineStepBase.setPSDevSlnSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSDevSlnPipelineStepBase.setPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSDevSlnPipelineStepBase.setPSDevSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSDevSlnPipelineStepBase.setPSDevSlnSysSrvId(DataObject.getStringValue((Object)object));
                return;
            }
            case 58: {
                pSDevSlnPipelineStepBase.setPSDevSlnSysSrvName(DataObject.getStringValue((Object)object));
                return;
            }
            case 59: {
                pSDevSlnPipelineStepBase.setPSDevSlnSysVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 60: {
                pSDevSlnPipelineStepBase.setPSDevSlnSysVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 61: {
                pSDevSlnPipelineStepBase.setPSDevSlnTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 62: {
                pSDevSlnPipelineStepBase.setPSDevSlnTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 63: {
                pSDevSlnPipelineStepBase.setRefPSDevSlnPipelineId(DataObject.getStringValue((Object)object));
                return;
            }
            case 64: {
                pSDevSlnPipelineStepBase.setRefPSDevSlnPipelineName(DataObject.getStringValue((Object)object));
                return;
            }
            case 65: {
                pSDevSlnPipelineStepBase.setRunCmd(DataObject.getStringValue((Object)object));
                return;
            }
            case 66: {
                pSDevSlnPipelineStepBase.setStepTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 67: {
                pSDevSlnPipelineStepBase.setStepTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 68: {
                pSDevSlnPipelineStepBase.setStepTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 69: {
                pSDevSlnPipelineStepBase.setStepTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 70: {
                pSDevSlnPipelineStepBase.setTemplateMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 71: {
                pSDevSlnPipelineStepBase.setTemplPSDevCenterSVNId(DataObject.getStringValue((Object)object));
                return;
            }
            case 72: {
                pSDevSlnPipelineStepBase.setTemplPSDevCenterSVNName(DataObject.getStringValue((Object)object));
                return;
            }
            case 73: {
                pSDevSlnPipelineStepBase.setToolPSDCRegistryItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 74: {
                pSDevSlnPipelineStepBase.setToolPSDCRegistryItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 75: {
                pSDevSlnPipelineStepBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 76: {
                pSDevSlnPipelineStepBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 77: {
                pSDevSlnPipelineStepBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 78: {
                pSDevSlnPipelineStepBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 79: {
                pSDevSlnPipelineStepBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 80: {
                pSDevSlnPipelineStepBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 81: {
                pSDevSlnPipelineStepBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 82: {
                pSDevSlnPipelineStepBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 83: {
                pSDevSlnPipelineStepBase.setWorkFolder(DataObject.getStringValue((Object)object));
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
        return PSDevSlnPipelineStepBase.isNull(this, n);
    }

    private static boolean isNull(PSDevSlnPipelineStepBase pSDevSlnPipelineStepBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnPipelineStepBase.getActionParams() == null;
            }
            case 1: {
                return pSDevSlnPipelineStepBase.getActionType() == null;
            }
            case 2: {
                return pSDevSlnPipelineStepBase.getAgentPSDCRegistryItemId() == null;
            }
            case 3: {
                return pSDevSlnPipelineStepBase.getAgentPSDCRegistryItemName() == null;
            }
            case 4: {
                return pSDevSlnPipelineStepBase.getCheckinMode() == null;
            }
            case 5: {
                return pSDevSlnPipelineStepBase.getCodeName() == null;
            }
            case 6: {
                return pSDevSlnPipelineStepBase.getCondModel() == null;
            }
            case 7: {
                return pSDevSlnPipelineStepBase.getCondModelFlag() == null;
            }
            case 8: {
                return pSDevSlnPipelineStepBase.getCreateDate() == null;
            }
            case 9: {
                return pSDevSlnPipelineStepBase.getCreateMan() == null;
            }
            case 10: {
                return pSDevSlnPipelineStepBase.getCustomCheckout() == null;
            }
            case 11: {
                return pSDevSlnPipelineStepBase.getCustomCode() == null;
            }
            case 12: {
                return pSDevSlnPipelineStepBase.getMemo() == null;
            }
            case 13: {
                return pSDevSlnPipelineStepBase.getModelPSDevCenterSVNId() == null;
            }
            case 14: {
                return pSDevSlnPipelineStepBase.getModelPSDevCenterSVNName() == null;
            }
            case 15: {
                return pSDevSlnPipelineStepBase.getOrderValue() == null;
            }
            case 16: {
                return pSDevSlnPipelineStepBase.getPSDCBDInstId() == null;
            }
            case 17: {
                return pSDevSlnPipelineStepBase.getPSDCBDInstName() == null;
            }
            case 18: {
                return pSDevSlnPipelineStepBase.getPSDCCodeSnippetId() == null;
            }
            case 19: {
                return pSDevSlnPipelineStepBase.getPSDCCodeSnippetName() == null;
            }
            case 20: {
                return pSDevSlnPipelineStepBase.getPSDCFileId() == null;
            }
            case 21: {
                return pSDevSlnPipelineStepBase.getPSDCFileName() == null;
            }
            case 22: {
                return pSDevSlnPipelineStepBase.getPSDCMSPlatformFuncId() == null;
            }
            case 23: {
                return pSDevSlnPipelineStepBase.getPSDCMSPlatformFuncName() == null;
            }
            case 24: {
                return pSDevSlnPipelineStepBase.getPSDCMSPlatformId() == null;
            }
            case 25: {
                return pSDevSlnPipelineStepBase.getPSDCMSPlatformName() == null;
            }
            case 26: {
                return pSDevSlnPipelineStepBase.getPSDCMSPlatformNodeId() == null;
            }
            case 27: {
                return pSDevSlnPipelineStepBase.getPSDCMSPlatformNodeName() == null;
            }
            case 28: {
                return pSDevSlnPipelineStepBase.getPSDCRegistryItemId() == null;
            }
            case 29: {
                return pSDevSlnPipelineStepBase.getPSDCRegistryItemName() == null;
            }
            case 30: {
                return pSDevSlnPipelineStepBase.getPSDCRegistryRepoId() == null;
            }
            case 31: {
                return pSDevSlnPipelineStepBase.getPSDCRegistryRepoName() == null;
            }
            case 32: {
                return pSDevSlnPipelineStepBase.getPSDevCenterDBInstId() == null;
            }
            case 33: {
                return pSDevSlnPipelineStepBase.getPSDevCenterDBInstName() == null;
            }
            case 34: {
                return pSDevSlnPipelineStepBase.getPSDevCenterSVNId() == null;
            }
            case 35: {
                return pSDevSlnPipelineStepBase.getPSDevCenterSVNName() == null;
            }
            case 36: {
                return pSDevSlnPipelineStepBase.getPSDevSlnId() == null;
            }
            case 37: {
                return pSDevSlnPipelineStepBase.getPSDevSlnMSDepAPIId() == null;
            }
            case 38: {
                return pSDevSlnPipelineStepBase.getPSDevSlnMSDepAPIName() == null;
            }
            case 39: {
                return pSDevSlnPipelineStepBase.getPSDevSlnMSDepAppId() == null;
            }
            case 40: {
                return pSDevSlnPipelineStepBase.getPSDevSlnMSDepAppName() == null;
            }
            case 41: {
                return pSDevSlnPipelineStepBase.getPSDevSlnMSDepFuncId() == null;
            }
            case 42: {
                return pSDevSlnPipelineStepBase.getPSDevSlnMSDepFuncName() == null;
            }
            case 43: {
                return pSDevSlnPipelineStepBase.getPSDevSlnMSDeployId() == null;
            }
            case 44: {
                return pSDevSlnPipelineStepBase.getPSDevSlnMSDeployName() == null;
            }
            case 45: {
                return pSDevSlnPipelineStepBase.getPSDevSlnPipelineId() == null;
            }
            case 46: {
                return pSDevSlnPipelineStepBase.getPSDevSlnPipelineName() == null;
            }
            case 47: {
                return pSDevSlnPipelineStepBase.getPSDevSlnPipelineStageId() == null;
            }
            case 48: {
                return pSDevSlnPipelineStepBase.getPSDevSlnPipelineStageName() == null;
            }
            case 49: {
                return pSDevSlnPipelineStepBase.getPSDevSlnPipelineStepId() == null;
            }
            case 50: {
                return pSDevSlnPipelineStepBase.getPSDevSlnPipelineStepName() == null;
            }
            case 51: {
                return pSDevSlnPipelineStepBase.getPSDevSlnSysAPIId() == null;
            }
            case 52: {
                return pSDevSlnPipelineStepBase.getPSDevSlnSysAPIName() == null;
            }
            case 53: {
                return pSDevSlnPipelineStepBase.getPSDevSlnSysAppId() == null;
            }
            case 54: {
                return pSDevSlnPipelineStepBase.getPSDevSlnSysAppName() == null;
            }
            case 55: {
                return pSDevSlnPipelineStepBase.getPSDevSlnSysId() == null;
            }
            case 56: {
                return pSDevSlnPipelineStepBase.getPSDevSlnSysName() == null;
            }
            case 57: {
                return pSDevSlnPipelineStepBase.getPSDevSlnSysSrvId() == null;
            }
            case 58: {
                return pSDevSlnPipelineStepBase.getPSDevSlnSysSrvName() == null;
            }
            case 59: {
                return pSDevSlnPipelineStepBase.getPSDevSlnSysVerId() == null;
            }
            case 60: {
                return pSDevSlnPipelineStepBase.getPSDevSlnSysVerName() == null;
            }
            case 61: {
                return pSDevSlnPipelineStepBase.getPSDevSlnTemplId() == null;
            }
            case 62: {
                return pSDevSlnPipelineStepBase.getPSDevSlnTemplName() == null;
            }
            case 63: {
                return pSDevSlnPipelineStepBase.getRefPSDevSlnPipelineId() == null;
            }
            case 64: {
                return pSDevSlnPipelineStepBase.getRefPSDevSlnPipelineName() == null;
            }
            case 65: {
                return pSDevSlnPipelineStepBase.getRunCmd() == null;
            }
            case 66: {
                return pSDevSlnPipelineStepBase.getStepTag() == null;
            }
            case 67: {
                return pSDevSlnPipelineStepBase.getStepTag2() == null;
            }
            case 68: {
                return pSDevSlnPipelineStepBase.getStepTag3() == null;
            }
            case 69: {
                return pSDevSlnPipelineStepBase.getStepTag4() == null;
            }
            case 70: {
                return pSDevSlnPipelineStepBase.getTemplateMode() == null;
            }
            case 71: {
                return pSDevSlnPipelineStepBase.getTemplPSDevCenterSVNId() == null;
            }
            case 72: {
                return pSDevSlnPipelineStepBase.getTemplPSDevCenterSVNName() == null;
            }
            case 73: {
                return pSDevSlnPipelineStepBase.getToolPSDCRegistryItemId() == null;
            }
            case 74: {
                return pSDevSlnPipelineStepBase.getToolPSDCRegistryItemName() == null;
            }
            case 75: {
                return pSDevSlnPipelineStepBase.getUpdateDate() == null;
            }
            case 76: {
                return pSDevSlnPipelineStepBase.getUpdateMan() == null;
            }
            case 77: {
                return pSDevSlnPipelineStepBase.getUserCat() == null;
            }
            case 78: {
                return pSDevSlnPipelineStepBase.getUserTag() == null;
            }
            case 79: {
                return pSDevSlnPipelineStepBase.getUserTag2() == null;
            }
            case 80: {
                return pSDevSlnPipelineStepBase.getUserTag3() == null;
            }
            case 81: {
                return pSDevSlnPipelineStepBase.getUserTag4() == null;
            }
            case 82: {
                return pSDevSlnPipelineStepBase.getValidFlag() == null;
            }
            case 83: {
                return pSDevSlnPipelineStepBase.getWorkFolder() == null;
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
        return PSDevSlnPipelineStepBase.contains(this, n);
    }

    private static boolean contains(PSDevSlnPipelineStepBase pSDevSlnPipelineStepBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnPipelineStepBase.isActionParamsDirty();
            }
            case 1: {
                return pSDevSlnPipelineStepBase.isActionTypeDirty();
            }
            case 2: {
                return pSDevSlnPipelineStepBase.isAgentPSDCRegistryItemIdDirty();
            }
            case 3: {
                return pSDevSlnPipelineStepBase.isAgentPSDCRegistryItemNameDirty();
            }
            case 4: {
                return pSDevSlnPipelineStepBase.isCheckinModeDirty();
            }
            case 5: {
                return pSDevSlnPipelineStepBase.isCodeNameDirty();
            }
            case 6: {
                return pSDevSlnPipelineStepBase.isCondModelDirty();
            }
            case 7: {
                return pSDevSlnPipelineStepBase.isCondModelFlagDirty();
            }
            case 8: {
                return pSDevSlnPipelineStepBase.isCreateDateDirty();
            }
            case 9: {
                return pSDevSlnPipelineStepBase.isCreateManDirty();
            }
            case 10: {
                return pSDevSlnPipelineStepBase.isCustomCheckoutDirty();
            }
            case 11: {
                return pSDevSlnPipelineStepBase.isCustomCodeDirty();
            }
            case 12: {
                return pSDevSlnPipelineStepBase.isMemoDirty();
            }
            case 13: {
                return pSDevSlnPipelineStepBase.isModelPSDevCenterSVNIdDirty();
            }
            case 14: {
                return pSDevSlnPipelineStepBase.isModelPSDevCenterSVNNameDirty();
            }
            case 15: {
                return pSDevSlnPipelineStepBase.isOrderValueDirty();
            }
            case 16: {
                return pSDevSlnPipelineStepBase.isPSDCBDInstIdDirty();
            }
            case 17: {
                return pSDevSlnPipelineStepBase.isPSDCBDInstNameDirty();
            }
            case 18: {
                return pSDevSlnPipelineStepBase.isPSDCCodeSnippetIdDirty();
            }
            case 19: {
                return pSDevSlnPipelineStepBase.isPSDCCodeSnippetNameDirty();
            }
            case 20: {
                return pSDevSlnPipelineStepBase.isPSDCFileIdDirty();
            }
            case 21: {
                return pSDevSlnPipelineStepBase.isPSDCFileNameDirty();
            }
            case 22: {
                return pSDevSlnPipelineStepBase.isPSDCMSPlatformFuncIdDirty();
            }
            case 23: {
                return pSDevSlnPipelineStepBase.isPSDCMSPlatformFuncNameDirty();
            }
            case 24: {
                return pSDevSlnPipelineStepBase.isPSDCMSPlatformIdDirty();
            }
            case 25: {
                return pSDevSlnPipelineStepBase.isPSDCMSPlatformNameDirty();
            }
            case 26: {
                return pSDevSlnPipelineStepBase.isPSDCMSPlatformNodeIdDirty();
            }
            case 27: {
                return pSDevSlnPipelineStepBase.isPSDCMSPlatformNodeNameDirty();
            }
            case 28: {
                return pSDevSlnPipelineStepBase.isPSDCRegistryItemIdDirty();
            }
            case 29: {
                return pSDevSlnPipelineStepBase.isPSDCRegistryItemNameDirty();
            }
            case 30: {
                return pSDevSlnPipelineStepBase.isPSDCRegistryRepoIdDirty();
            }
            case 31: {
                return pSDevSlnPipelineStepBase.isPSDCRegistryRepoNameDirty();
            }
            case 32: {
                return pSDevSlnPipelineStepBase.isPSDevCenterDBInstIdDirty();
            }
            case 33: {
                return pSDevSlnPipelineStepBase.isPSDevCenterDBInstNameDirty();
            }
            case 34: {
                return pSDevSlnPipelineStepBase.isPSDevCenterSVNIdDirty();
            }
            case 35: {
                return pSDevSlnPipelineStepBase.isPSDevCenterSVNNameDirty();
            }
            case 36: {
                return pSDevSlnPipelineStepBase.isPSDevSlnIdDirty();
            }
            case 37: {
                return pSDevSlnPipelineStepBase.isPSDevSlnMSDepAPIIdDirty();
            }
            case 38: {
                return pSDevSlnPipelineStepBase.isPSDevSlnMSDepAPINameDirty();
            }
            case 39: {
                return pSDevSlnPipelineStepBase.isPSDevSlnMSDepAppIdDirty();
            }
            case 40: {
                return pSDevSlnPipelineStepBase.isPSDevSlnMSDepAppNameDirty();
            }
            case 41: {
                return pSDevSlnPipelineStepBase.isPSDevSlnMSDepFuncIdDirty();
            }
            case 42: {
                return pSDevSlnPipelineStepBase.isPSDevSlnMSDepFuncNameDirty();
            }
            case 43: {
                return pSDevSlnPipelineStepBase.isPSDevSlnMSDeployIdDirty();
            }
            case 44: {
                return pSDevSlnPipelineStepBase.isPSDevSlnMSDeployNameDirty();
            }
            case 45: {
                return pSDevSlnPipelineStepBase.isPSDevSlnPipelineIdDirty();
            }
            case 46: {
                return pSDevSlnPipelineStepBase.isPSDevSlnPipelineNameDirty();
            }
            case 47: {
                return pSDevSlnPipelineStepBase.isPSDevSlnPipelineStageIdDirty();
            }
            case 48: {
                return pSDevSlnPipelineStepBase.isPSDevSlnPipelineStageNameDirty();
            }
            case 49: {
                return pSDevSlnPipelineStepBase.isPSDevSlnPipelineStepIdDirty();
            }
            case 50: {
                return pSDevSlnPipelineStepBase.isPSDevSlnPipelineStepNameDirty();
            }
            case 51: {
                return pSDevSlnPipelineStepBase.isPSDevSlnSysAPIIdDirty();
            }
            case 52: {
                return pSDevSlnPipelineStepBase.isPSDevSlnSysAPINameDirty();
            }
            case 53: {
                return pSDevSlnPipelineStepBase.isPSDevSlnSysAppIdDirty();
            }
            case 54: {
                return pSDevSlnPipelineStepBase.isPSDevSlnSysAppNameDirty();
            }
            case 55: {
                return pSDevSlnPipelineStepBase.isPSDevSlnSysIdDirty();
            }
            case 56: {
                return pSDevSlnPipelineStepBase.isPSDevSlnSysNameDirty();
            }
            case 57: {
                return pSDevSlnPipelineStepBase.isPSDevSlnSysSrvIdDirty();
            }
            case 58: {
                return pSDevSlnPipelineStepBase.isPSDevSlnSysSrvNameDirty();
            }
            case 59: {
                return pSDevSlnPipelineStepBase.isPSDevSlnSysVerIdDirty();
            }
            case 60: {
                return pSDevSlnPipelineStepBase.isPSDevSlnSysVerNameDirty();
            }
            case 61: {
                return pSDevSlnPipelineStepBase.isPSDevSlnTemplIdDirty();
            }
            case 62: {
                return pSDevSlnPipelineStepBase.isPSDevSlnTemplNameDirty();
            }
            case 63: {
                return pSDevSlnPipelineStepBase.isRefPSDevSlnPipelineIdDirty();
            }
            case 64: {
                return pSDevSlnPipelineStepBase.isRefPSDevSlnPipelineNameDirty();
            }
            case 65: {
                return pSDevSlnPipelineStepBase.isRunCmdDirty();
            }
            case 66: {
                return pSDevSlnPipelineStepBase.isStepTagDirty();
            }
            case 67: {
                return pSDevSlnPipelineStepBase.isStepTag2Dirty();
            }
            case 68: {
                return pSDevSlnPipelineStepBase.isStepTag3Dirty();
            }
            case 69: {
                return pSDevSlnPipelineStepBase.isStepTag4Dirty();
            }
            case 70: {
                return pSDevSlnPipelineStepBase.isTemplateModeDirty();
            }
            case 71: {
                return pSDevSlnPipelineStepBase.isTemplPSDevCenterSVNIdDirty();
            }
            case 72: {
                return pSDevSlnPipelineStepBase.isTemplPSDevCenterSVNNameDirty();
            }
            case 73: {
                return pSDevSlnPipelineStepBase.isToolPSDCRegistryItemIdDirty();
            }
            case 74: {
                return pSDevSlnPipelineStepBase.isToolPSDCRegistryItemNameDirty();
            }
            case 75: {
                return pSDevSlnPipelineStepBase.isUpdateDateDirty();
            }
            case 76: {
                return pSDevSlnPipelineStepBase.isUpdateManDirty();
            }
            case 77: {
                return pSDevSlnPipelineStepBase.isUserCatDirty();
            }
            case 78: {
                return pSDevSlnPipelineStepBase.isUserTagDirty();
            }
            case 79: {
                return pSDevSlnPipelineStepBase.isUserTag2Dirty();
            }
            case 80: {
                return pSDevSlnPipelineStepBase.isUserTag3Dirty();
            }
            case 81: {
                return pSDevSlnPipelineStepBase.isUserTag4Dirty();
            }
            case 82: {
                return pSDevSlnPipelineStepBase.isValidFlagDirty();
            }
            case 83: {
                return pSDevSlnPipelineStepBase.isWorkFolderDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevSlnPipelineStepBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevSlnPipelineStepBase pSDevSlnPipelineStepBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevSlnPipelineStepBase.getActionParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparams", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getActionParams()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getActionType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actiontype", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getActionType()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getAgentPSDCRegistryItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"agentpsdcregistryitemid", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getAgentPSDCRegistryItemId()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getAgentPSDCRegistryItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"agentpsdcregistryitemname", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getAgentPSDCRegistryItemName()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getCheckinMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"checkinmode", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getCheckinMode()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getCondModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"condmodel", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getCondModel()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getCondModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"condmodelflag", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getCondModelFlag()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getCustomCheckout() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcheckout", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getCustomCheckout()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getModelPSDevCenterSVNId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelpsdevcentersvnid", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getModelPSDevCenterSVNId()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getModelPSDevCenterSVNName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelpsdevcentersvnname", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getModelPSDevCenterSVNName()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDCBDInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcbdinstid", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getPSDCBDInstId()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDCBDInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcbdinstname", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getPSDCBDInstName()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDCCodeSnippetId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdccodesnippetid", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getPSDCCodeSnippetId()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDCCodeSnippetName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdccodesnippetname", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getPSDCCodeSnippetName()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDCFileId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcfileid", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getPSDCFileId()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDCFileName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcfilename", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getPSDCFileName()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDCMSPlatformFuncId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmsplatformfuncid", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getPSDCMSPlatformFuncId()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDCMSPlatformFuncName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmsplatformfuncname", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getPSDCMSPlatformFuncName()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDCMSPlatformId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmsplatformid", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getPSDCMSPlatformId()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDCMSPlatformName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmsplatformname", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getPSDCMSPlatformName()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDCMSPlatformNodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmsplatformnodeid", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getPSDCMSPlatformNodeId()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDCMSPlatformNodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmsplatformnodename", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getPSDCMSPlatformNodeName()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDCRegistryItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcregistryitemid", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getPSDCRegistryItemId()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDCRegistryItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcregistryitemname", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getPSDCRegistryItemName()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDCRegistryRepoId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcregistryrepoid", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getPSDCRegistryRepoId()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDCRegistryRepoName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcregistryreponame", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getPSDCRegistryRepoName()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevCenterDBInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterdbinstid", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getPSDevCenterDBInstId()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevCenterDBInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterdbinstname", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getPSDevCenterDBInstName()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevCenterSVNId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentersvnid", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getPSDevCenterSVNId()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevCenterSVNName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentersvnname", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getPSDevCenterSVNName()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevSlnMSDepAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnmsdepapiid", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getPSDevSlnMSDepAPIId()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevSlnMSDepAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnmsdepapiname", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getPSDevSlnMSDepAPIName()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevSlnMSDepAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnmsdepappid", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getPSDevSlnMSDepAppId()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevSlnMSDepAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnmsdepappname", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getPSDevSlnMSDepAppName()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevSlnMSDepFuncId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnmsdepfuncid", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getPSDevSlnMSDepFuncId()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevSlnMSDepFuncName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnmsdepfuncname", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getPSDevSlnMSDepFuncName()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevSlnMSDeployId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnmsdeployid", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getPSDevSlnMSDeployId()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevSlnMSDeployName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnmsdeployname", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getPSDevSlnMSDeployName()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevSlnPipelineId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnpipelineid", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getPSDevSlnPipelineId()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevSlnPipelineName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnpipelinename", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getPSDevSlnPipelineName()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevSlnPipelineStageId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnpipelinestageid", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getPSDevSlnPipelineStageId()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevSlnPipelineStageName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnpipelinestagename", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getPSDevSlnPipelineStageName()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevSlnPipelineStepId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnpipelinestepid", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getPSDevSlnPipelineStepId()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevSlnPipelineStepName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnpipelinestepname", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getPSDevSlnPipelineStepName()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevSlnSysAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysapiid", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getPSDevSlnSysAPIId()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevSlnSysAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysapiname", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getPSDevSlnSysAPIName()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevSlnSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysappid", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getPSDevSlnSysAppId()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevSlnSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysappname", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getPSDevSlnSysAppName()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysid", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysname", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getPSDevSlnSysName()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevSlnSysSrvId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsyssrvid", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getPSDevSlnSysSrvId()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevSlnSysSrvName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsyssrvname", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getPSDevSlnSysSrvName()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevSlnSysVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysverid", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getPSDevSlnSysVerId()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevSlnSysVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysvername", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getPSDevSlnSysVerName()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevSlnTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslntemplid", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getPSDevSlnTemplId()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevSlnTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslntemplname", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getPSDevSlnTemplName()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getRefPSDevSlnPipelineId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdevslnpipelineid", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getRefPSDevSlnPipelineId()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getRefPSDevSlnPipelineName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdevslnpipelinename", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getRefPSDevSlnPipelineName()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getRunCmd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"runcmd", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getRunCmd()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getStepTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"steptag", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getStepTag()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getStepTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"steptag2", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getStepTag2()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getStepTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"steptag3", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getStepTag3()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getStepTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"steptag4", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getStepTag4()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getTemplateMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templatemode", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getTemplateMode()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getTemplPSDevCenterSVNId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templpsdevcentersvnid", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getTemplPSDevCenterSVNId()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getTemplPSDevCenterSVNName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templpsdevcentersvnname", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getTemplPSDevCenterSVNName()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getToolPSDCRegistryItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"toolpsdcregistryitemid", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getToolPSDCRegistryItemId()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getToolPSDCRegistryItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"toolpsdcregistryitemname", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getToolPSDCRegistryItemName()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStepBase.getWorkFolder() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"workfolder", (Object)PSDevSlnPipelineStepBase.getJSONValue((Object)pSDevSlnPipelineStepBase.getWorkFolder()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevSlnPipelineStepBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevSlnPipelineStepBase pSDevSlnPipelineStepBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevSlnPipelineStepBase.getActionParams() != null) {
            object = pSDevSlnPipelineStepBase.getActionParams();
            xmlNode.setAttribute(FIELD_ACTIONPARAMS, (String)(object == null ? "" : object));
        }
        if (bl || pSDevSlnPipelineStepBase.getActionType() != null) {
            object = pSDevSlnPipelineStepBase.getActionType();
            xmlNode.setAttribute(FIELD_ACTIONTYPE, (String)(object == null ? "" : object));
        }
        if (bl || pSDevSlnPipelineStepBase.getAgentPSDCRegistryItemId() != null) {
            object = pSDevSlnPipelineStepBase.getAgentPSDCRegistryItemId();
            xmlNode.setAttribute(FIELD_AGENTPSDCREGISTRYITEMID, (String)(object == null ? "" : object));
        }
        if (bl || pSDevSlnPipelineStepBase.getAgentPSDCRegistryItemName() != null) {
            object = pSDevSlnPipelineStepBase.getAgentPSDCRegistryItemName();
            xmlNode.setAttribute(FIELD_AGENTPSDCREGISTRYITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getCheckinMode() != null) {
            object = pSDevSlnPipelineStepBase.getCheckinMode();
            xmlNode.setAttribute(FIELD_CHECKINMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnPipelineStepBase.getCodeName() != null) {
            object = pSDevSlnPipelineStepBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getCondModel() != null) {
            object = pSDevSlnPipelineStepBase.getCondModel();
            xmlNode.setAttribute(FIELD_CONDMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getCondModelFlag() != null) {
            object = pSDevSlnPipelineStepBase.getCondModelFlag();
            xmlNode.setAttribute(FIELD_CONDMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnPipelineStepBase.getCreateDate() != null) {
            object = pSDevSlnPipelineStepBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnPipelineStepBase.getCreateMan() != null) {
            object = pSDevSlnPipelineStepBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getCustomCheckout() != null) {
            object = pSDevSlnPipelineStepBase.getCustomCheckout();
            xmlNode.setAttribute(FIELD_CUSTOMCHECKOUT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnPipelineStepBase.getCustomCode() != null) {
            object = pSDevSlnPipelineStepBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getMemo() != null) {
            object = pSDevSlnPipelineStepBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getModelPSDevCenterSVNId() != null) {
            object = pSDevSlnPipelineStepBase.getModelPSDevCenterSVNId();
            xmlNode.setAttribute(FIELD_MODELPSDEVCENTERSVNID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getModelPSDevCenterSVNName() != null) {
            object = pSDevSlnPipelineStepBase.getModelPSDevCenterSVNName();
            xmlNode.setAttribute(FIELD_MODELPSDEVCENTERSVNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getOrderValue() != null) {
            object = pSDevSlnPipelineStepBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDCBDInstId() != null) {
            object = pSDevSlnPipelineStepBase.getPSDCBDInstId();
            xmlNode.setAttribute(FIELD_PSDCBDINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDCBDInstName() != null) {
            object = pSDevSlnPipelineStepBase.getPSDCBDInstName();
            xmlNode.setAttribute(FIELD_PSDCBDINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDCCodeSnippetId() != null) {
            object = pSDevSlnPipelineStepBase.getPSDCCodeSnippetId();
            xmlNode.setAttribute(FIELD_PSDCCODESNIPPETID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDCCodeSnippetName() != null) {
            object = pSDevSlnPipelineStepBase.getPSDCCodeSnippetName();
            xmlNode.setAttribute(FIELD_PSDCCODESNIPPETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDCFileId() != null) {
            object = pSDevSlnPipelineStepBase.getPSDCFileId();
            xmlNode.setAttribute(FIELD_PSDCFILEID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDCFileName() != null) {
            object = pSDevSlnPipelineStepBase.getPSDCFileName();
            xmlNode.setAttribute(FIELD_PSDCFILENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDCMSPlatformFuncId() != null) {
            object = pSDevSlnPipelineStepBase.getPSDCMSPlatformFuncId();
            xmlNode.setAttribute(FIELD_PSDCMSPLATFORMFUNCID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDCMSPlatformFuncName() != null) {
            object = pSDevSlnPipelineStepBase.getPSDCMSPlatformFuncName();
            xmlNode.setAttribute(FIELD_PSDCMSPLATFORMFUNCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDCMSPlatformId() != null) {
            object = pSDevSlnPipelineStepBase.getPSDCMSPlatformId();
            xmlNode.setAttribute(FIELD_PSDCMSPLATFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDCMSPlatformName() != null) {
            object = pSDevSlnPipelineStepBase.getPSDCMSPlatformName();
            xmlNode.setAttribute(FIELD_PSDCMSPLATFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDCMSPlatformNodeId() != null) {
            object = pSDevSlnPipelineStepBase.getPSDCMSPlatformNodeId();
            xmlNode.setAttribute(FIELD_PSDCMSPLATFORMNODEID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDCMSPlatformNodeName() != null) {
            object = pSDevSlnPipelineStepBase.getPSDCMSPlatformNodeName();
            xmlNode.setAttribute(FIELD_PSDCMSPLATFORMNODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDCRegistryItemId() != null) {
            object = pSDevSlnPipelineStepBase.getPSDCRegistryItemId();
            xmlNode.setAttribute(FIELD_PSDCREGISTRYITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDCRegistryItemName() != null) {
            object = pSDevSlnPipelineStepBase.getPSDCRegistryItemName();
            xmlNode.setAttribute(FIELD_PSDCREGISTRYITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDCRegistryRepoId() != null) {
            object = pSDevSlnPipelineStepBase.getPSDCRegistryRepoId();
            xmlNode.setAttribute(FIELD_PSDCREGISTRYREPOID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDCRegistryRepoName() != null) {
            object = pSDevSlnPipelineStepBase.getPSDCRegistryRepoName();
            xmlNode.setAttribute(FIELD_PSDCREGISTRYREPONAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevCenterDBInstId() != null) {
            object = pSDevSlnPipelineStepBase.getPSDevCenterDBInstId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERDBINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevCenterDBInstName() != null) {
            object = pSDevSlnPipelineStepBase.getPSDevCenterDBInstName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERDBINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevCenterSVNId() != null) {
            object = pSDevSlnPipelineStepBase.getPSDevCenterSVNId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERSVNID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevCenterSVNName() != null) {
            object = pSDevSlnPipelineStepBase.getPSDevCenterSVNName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERSVNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevSlnId() != null) {
            object = pSDevSlnPipelineStepBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevSlnMSDepAPIId() != null) {
            object = pSDevSlnPipelineStepBase.getPSDevSlnMSDepAPIId();
            xmlNode.setAttribute(FIELD_PSDEVSLNMSDEPAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevSlnMSDepAPIName() != null) {
            object = pSDevSlnPipelineStepBase.getPSDevSlnMSDepAPIName();
            xmlNode.setAttribute(FIELD_PSDEVSLNMSDEPAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevSlnMSDepAppId() != null) {
            object = pSDevSlnPipelineStepBase.getPSDevSlnMSDepAppId();
            xmlNode.setAttribute(FIELD_PSDEVSLNMSDEPAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevSlnMSDepAppName() != null) {
            object = pSDevSlnPipelineStepBase.getPSDevSlnMSDepAppName();
            xmlNode.setAttribute(FIELD_PSDEVSLNMSDEPAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevSlnMSDepFuncId() != null) {
            object = pSDevSlnPipelineStepBase.getPSDevSlnMSDepFuncId();
            xmlNode.setAttribute(FIELD_PSDEVSLNMSDEPFUNCID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevSlnMSDepFuncName() != null) {
            object = pSDevSlnPipelineStepBase.getPSDevSlnMSDepFuncName();
            xmlNode.setAttribute(FIELD_PSDEVSLNMSDEPFUNCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevSlnMSDeployId() != null) {
            object = pSDevSlnPipelineStepBase.getPSDevSlnMSDeployId();
            xmlNode.setAttribute(FIELD_PSDEVSLNMSDEPLOYID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevSlnMSDeployName() != null) {
            object = pSDevSlnPipelineStepBase.getPSDevSlnMSDeployName();
            xmlNode.setAttribute(FIELD_PSDEVSLNMSDEPLOYNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevSlnPipelineId() != null) {
            object = pSDevSlnPipelineStepBase.getPSDevSlnPipelineId();
            xmlNode.setAttribute(FIELD_PSDEVSLNPIPELINEID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevSlnPipelineName() != null) {
            object = pSDevSlnPipelineStepBase.getPSDevSlnPipelineName();
            xmlNode.setAttribute(FIELD_PSDEVSLNPIPELINENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevSlnPipelineStageId() != null) {
            object = pSDevSlnPipelineStepBase.getPSDevSlnPipelineStageId();
            xmlNode.setAttribute(FIELD_PSDEVSLNPIPELINESTAGEID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevSlnPipelineStageName() != null) {
            object = pSDevSlnPipelineStepBase.getPSDevSlnPipelineStageName();
            xmlNode.setAttribute(FIELD_PSDEVSLNPIPELINESTAGENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevSlnPipelineStepId() != null) {
            object = pSDevSlnPipelineStepBase.getPSDevSlnPipelineStepId();
            xmlNode.setAttribute(FIELD_PSDEVSLNPIPELINESTEPID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevSlnPipelineStepName() != null) {
            object = pSDevSlnPipelineStepBase.getPSDevSlnPipelineStepName();
            xmlNode.setAttribute(FIELD_PSDEVSLNPIPELINESTEPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevSlnSysAPIId() != null) {
            object = pSDevSlnPipelineStepBase.getPSDevSlnSysAPIId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevSlnSysAPIName() != null) {
            object = pSDevSlnPipelineStepBase.getPSDevSlnSysAPIName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevSlnSysAppId() != null) {
            object = pSDevSlnPipelineStepBase.getPSDevSlnSysAppId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevSlnSysAppName() != null) {
            object = pSDevSlnPipelineStepBase.getPSDevSlnSysAppName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevSlnSysId() != null) {
            object = pSDevSlnPipelineStepBase.getPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevSlnSysName() != null) {
            object = pSDevSlnPipelineStepBase.getPSDevSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevSlnSysSrvId() != null) {
            object = pSDevSlnPipelineStepBase.getPSDevSlnSysSrvId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSSRVID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevSlnSysSrvName() != null) {
            object = pSDevSlnPipelineStepBase.getPSDevSlnSysSrvName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSSRVNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevSlnSysVerId() != null) {
            object = pSDevSlnPipelineStepBase.getPSDevSlnSysVerId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevSlnSysVerName() != null) {
            object = pSDevSlnPipelineStepBase.getPSDevSlnSysVerName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevSlnTemplId() != null) {
            object = pSDevSlnPipelineStepBase.getPSDevSlnTemplId();
            xmlNode.setAttribute(FIELD_PSDEVSLNTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getPSDevSlnTemplName() != null) {
            object = pSDevSlnPipelineStepBase.getPSDevSlnTemplName();
            xmlNode.setAttribute(FIELD_PSDEVSLNTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getRefPSDevSlnPipelineId() != null) {
            object = pSDevSlnPipelineStepBase.getRefPSDevSlnPipelineId();
            xmlNode.setAttribute(FIELD_REFPSDEVSLNPIPELINEID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getRefPSDevSlnPipelineName() != null) {
            object = pSDevSlnPipelineStepBase.getRefPSDevSlnPipelineName();
            xmlNode.setAttribute(FIELD_REFPSDEVSLNPIPELINENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getRunCmd() != null) {
            object = pSDevSlnPipelineStepBase.getRunCmd();
            xmlNode.setAttribute(FIELD_RUNCMD, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getStepTag() != null) {
            object = pSDevSlnPipelineStepBase.getStepTag();
            xmlNode.setAttribute(FIELD_STEPTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getStepTag2() != null) {
            object = pSDevSlnPipelineStepBase.getStepTag2();
            xmlNode.setAttribute(FIELD_STEPTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getStepTag3() != null) {
            object = pSDevSlnPipelineStepBase.getStepTag3();
            xmlNode.setAttribute(FIELD_STEPTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getStepTag4() != null) {
            object = pSDevSlnPipelineStepBase.getStepTag4();
            xmlNode.setAttribute(FIELD_STEPTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getTemplateMode() != null) {
            object = pSDevSlnPipelineStepBase.getTemplateMode();
            xmlNode.setAttribute(FIELD_TEMPLATEMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnPipelineStepBase.getTemplPSDevCenterSVNId() != null) {
            object = pSDevSlnPipelineStepBase.getTemplPSDevCenterSVNId();
            xmlNode.setAttribute(FIELD_TEMPLPSDEVCENTERSVNID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getTemplPSDevCenterSVNName() != null) {
            object = pSDevSlnPipelineStepBase.getTemplPSDevCenterSVNName();
            xmlNode.setAttribute(FIELD_TEMPLPSDEVCENTERSVNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getToolPSDCRegistryItemId() != null) {
            object = pSDevSlnPipelineStepBase.getToolPSDCRegistryItemId();
            xmlNode.setAttribute(FIELD_TOOLPSDCREGISTRYITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getToolPSDCRegistryItemName() != null) {
            object = pSDevSlnPipelineStepBase.getToolPSDCRegistryItemName();
            xmlNode.setAttribute(FIELD_TOOLPSDCREGISTRYITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getUpdateDate() != null) {
            object = pSDevSlnPipelineStepBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnPipelineStepBase.getUpdateMan() != null) {
            object = pSDevSlnPipelineStepBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getUserCat() != null) {
            object = pSDevSlnPipelineStepBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getUserTag() != null) {
            object = pSDevSlnPipelineStepBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getUserTag2() != null) {
            object = pSDevSlnPipelineStepBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getUserTag3() != null) {
            object = pSDevSlnPipelineStepBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getUserTag4() != null) {
            object = pSDevSlnPipelineStepBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStepBase.getValidFlag() != null) {
            object = pSDevSlnPipelineStepBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnPipelineStepBase.getWorkFolder() != null) {
            object = pSDevSlnPipelineStepBase.getWorkFolder();
            xmlNode.setAttribute(FIELD_WORKFOLDER, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevSlnPipelineStepBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevSlnPipelineStepBase pSDevSlnPipelineStepBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevSlnPipelineStepBase.isActionParamsDirty() && (bl || pSDevSlnPipelineStepBase.getActionParams() != null)) {
            iDataObject.set(FIELD_ACTIONPARAMS, (Object)pSDevSlnPipelineStepBase.getActionParams());
        }
        if (pSDevSlnPipelineStepBase.isActionTypeDirty() && (bl || pSDevSlnPipelineStepBase.getActionType() != null)) {
            iDataObject.set(FIELD_ACTIONTYPE, (Object)pSDevSlnPipelineStepBase.getActionType());
        }
        if (pSDevSlnPipelineStepBase.isAgentPSDCRegistryItemIdDirty() && (bl || pSDevSlnPipelineStepBase.getAgentPSDCRegistryItemId() != null)) {
            iDataObject.set(FIELD_AGENTPSDCREGISTRYITEMID, (Object)pSDevSlnPipelineStepBase.getAgentPSDCRegistryItemId());
        }
        if (pSDevSlnPipelineStepBase.isAgentPSDCRegistryItemNameDirty() && (bl || pSDevSlnPipelineStepBase.getAgentPSDCRegistryItemName() != null)) {
            iDataObject.set(FIELD_AGENTPSDCREGISTRYITEMNAME, (Object)pSDevSlnPipelineStepBase.getAgentPSDCRegistryItemName());
        }
        if (pSDevSlnPipelineStepBase.isCheckinModeDirty() && (bl || pSDevSlnPipelineStepBase.getCheckinMode() != null)) {
            iDataObject.set(FIELD_CHECKINMODE, (Object)pSDevSlnPipelineStepBase.getCheckinMode());
        }
        if (pSDevSlnPipelineStepBase.isCodeNameDirty() && (bl || pSDevSlnPipelineStepBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDevSlnPipelineStepBase.getCodeName());
        }
        if (pSDevSlnPipelineStepBase.isCondModelDirty() && (bl || pSDevSlnPipelineStepBase.getCondModel() != null)) {
            iDataObject.set(FIELD_CONDMODEL, (Object)pSDevSlnPipelineStepBase.getCondModel());
        }
        if (pSDevSlnPipelineStepBase.isCondModelFlagDirty() && (bl || pSDevSlnPipelineStepBase.getCondModelFlag() != null)) {
            iDataObject.set(FIELD_CONDMODELFLAG, (Object)pSDevSlnPipelineStepBase.getCondModelFlag());
        }
        if (pSDevSlnPipelineStepBase.isCreateDateDirty() && (bl || pSDevSlnPipelineStepBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevSlnPipelineStepBase.getCreateDate());
        }
        if (pSDevSlnPipelineStepBase.isCreateManDirty() && (bl || pSDevSlnPipelineStepBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevSlnPipelineStepBase.getCreateMan());
        }
        if (pSDevSlnPipelineStepBase.isCustomCheckoutDirty() && (bl || pSDevSlnPipelineStepBase.getCustomCheckout() != null)) {
            iDataObject.set(FIELD_CUSTOMCHECKOUT, (Object)pSDevSlnPipelineStepBase.getCustomCheckout());
        }
        if (pSDevSlnPipelineStepBase.isCustomCodeDirty() && (bl || pSDevSlnPipelineStepBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSDevSlnPipelineStepBase.getCustomCode());
        }
        if (pSDevSlnPipelineStepBase.isMemoDirty() && (bl || pSDevSlnPipelineStepBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevSlnPipelineStepBase.getMemo());
        }
        if (pSDevSlnPipelineStepBase.isModelPSDevCenterSVNIdDirty() && (bl || pSDevSlnPipelineStepBase.getModelPSDevCenterSVNId() != null)) {
            iDataObject.set(FIELD_MODELPSDEVCENTERSVNID, (Object)pSDevSlnPipelineStepBase.getModelPSDevCenterSVNId());
        }
        if (pSDevSlnPipelineStepBase.isModelPSDevCenterSVNNameDirty() && (bl || pSDevSlnPipelineStepBase.getModelPSDevCenterSVNName() != null)) {
            iDataObject.set(FIELD_MODELPSDEVCENTERSVNNAME, (Object)pSDevSlnPipelineStepBase.getModelPSDevCenterSVNName());
        }
        if (pSDevSlnPipelineStepBase.isOrderValueDirty() && (bl || pSDevSlnPipelineStepBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDevSlnPipelineStepBase.getOrderValue());
        }
        if (pSDevSlnPipelineStepBase.isPSDCBDInstIdDirty() && (bl || pSDevSlnPipelineStepBase.getPSDCBDInstId() != null)) {
            iDataObject.set(FIELD_PSDCBDINSTID, (Object)pSDevSlnPipelineStepBase.getPSDCBDInstId());
        }
        if (pSDevSlnPipelineStepBase.isPSDCBDInstNameDirty() && (bl || pSDevSlnPipelineStepBase.getPSDCBDInstName() != null)) {
            iDataObject.set(FIELD_PSDCBDINSTNAME, (Object)pSDevSlnPipelineStepBase.getPSDCBDInstName());
        }
        if (pSDevSlnPipelineStepBase.isPSDCCodeSnippetIdDirty() && (bl || pSDevSlnPipelineStepBase.getPSDCCodeSnippetId() != null)) {
            iDataObject.set(FIELD_PSDCCODESNIPPETID, (Object)pSDevSlnPipelineStepBase.getPSDCCodeSnippetId());
        }
        if (pSDevSlnPipelineStepBase.isPSDCCodeSnippetNameDirty() && (bl || pSDevSlnPipelineStepBase.getPSDCCodeSnippetName() != null)) {
            iDataObject.set(FIELD_PSDCCODESNIPPETNAME, (Object)pSDevSlnPipelineStepBase.getPSDCCodeSnippetName());
        }
        if (pSDevSlnPipelineStepBase.isPSDCFileIdDirty() && (bl || pSDevSlnPipelineStepBase.getPSDCFileId() != null)) {
            iDataObject.set(FIELD_PSDCFILEID, (Object)pSDevSlnPipelineStepBase.getPSDCFileId());
        }
        if (pSDevSlnPipelineStepBase.isPSDCFileNameDirty() && (bl || pSDevSlnPipelineStepBase.getPSDCFileName() != null)) {
            iDataObject.set(FIELD_PSDCFILENAME, (Object)pSDevSlnPipelineStepBase.getPSDCFileName());
        }
        if (pSDevSlnPipelineStepBase.isPSDCMSPlatformFuncIdDirty() && (bl || pSDevSlnPipelineStepBase.getPSDCMSPlatformFuncId() != null)) {
            iDataObject.set(FIELD_PSDCMSPLATFORMFUNCID, (Object)pSDevSlnPipelineStepBase.getPSDCMSPlatformFuncId());
        }
        if (pSDevSlnPipelineStepBase.isPSDCMSPlatformFuncNameDirty() && (bl || pSDevSlnPipelineStepBase.getPSDCMSPlatformFuncName() != null)) {
            iDataObject.set(FIELD_PSDCMSPLATFORMFUNCNAME, (Object)pSDevSlnPipelineStepBase.getPSDCMSPlatformFuncName());
        }
        if (pSDevSlnPipelineStepBase.isPSDCMSPlatformIdDirty() && (bl || pSDevSlnPipelineStepBase.getPSDCMSPlatformId() != null)) {
            iDataObject.set(FIELD_PSDCMSPLATFORMID, (Object)pSDevSlnPipelineStepBase.getPSDCMSPlatformId());
        }
        if (pSDevSlnPipelineStepBase.isPSDCMSPlatformNameDirty() && (bl || pSDevSlnPipelineStepBase.getPSDCMSPlatformName() != null)) {
            iDataObject.set(FIELD_PSDCMSPLATFORMNAME, (Object)pSDevSlnPipelineStepBase.getPSDCMSPlatformName());
        }
        if (pSDevSlnPipelineStepBase.isPSDCMSPlatformNodeIdDirty() && (bl || pSDevSlnPipelineStepBase.getPSDCMSPlatformNodeId() != null)) {
            iDataObject.set(FIELD_PSDCMSPLATFORMNODEID, (Object)pSDevSlnPipelineStepBase.getPSDCMSPlatformNodeId());
        }
        if (pSDevSlnPipelineStepBase.isPSDCMSPlatformNodeNameDirty() && (bl || pSDevSlnPipelineStepBase.getPSDCMSPlatformNodeName() != null)) {
            iDataObject.set(FIELD_PSDCMSPLATFORMNODENAME, (Object)pSDevSlnPipelineStepBase.getPSDCMSPlatformNodeName());
        }
        if (pSDevSlnPipelineStepBase.isPSDCRegistryItemIdDirty() && (bl || pSDevSlnPipelineStepBase.getPSDCRegistryItemId() != null)) {
            iDataObject.set(FIELD_PSDCREGISTRYITEMID, (Object)pSDevSlnPipelineStepBase.getPSDCRegistryItemId());
        }
        if (pSDevSlnPipelineStepBase.isPSDCRegistryItemNameDirty() && (bl || pSDevSlnPipelineStepBase.getPSDCRegistryItemName() != null)) {
            iDataObject.set(FIELD_PSDCREGISTRYITEMNAME, (Object)pSDevSlnPipelineStepBase.getPSDCRegistryItemName());
        }
        if (pSDevSlnPipelineStepBase.isPSDCRegistryRepoIdDirty() && (bl || pSDevSlnPipelineStepBase.getPSDCRegistryRepoId() != null)) {
            iDataObject.set(FIELD_PSDCREGISTRYREPOID, (Object)pSDevSlnPipelineStepBase.getPSDCRegistryRepoId());
        }
        if (pSDevSlnPipelineStepBase.isPSDCRegistryRepoNameDirty() && (bl || pSDevSlnPipelineStepBase.getPSDCRegistryRepoName() != null)) {
            iDataObject.set(FIELD_PSDCREGISTRYREPONAME, (Object)pSDevSlnPipelineStepBase.getPSDCRegistryRepoName());
        }
        if (pSDevSlnPipelineStepBase.isPSDevCenterDBInstIdDirty() && (bl || pSDevSlnPipelineStepBase.getPSDevCenterDBInstId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERDBINSTID, (Object)pSDevSlnPipelineStepBase.getPSDevCenterDBInstId());
        }
        if (pSDevSlnPipelineStepBase.isPSDevCenterDBInstNameDirty() && (bl || pSDevSlnPipelineStepBase.getPSDevCenterDBInstName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERDBINSTNAME, (Object)pSDevSlnPipelineStepBase.getPSDevCenterDBInstName());
        }
        if (pSDevSlnPipelineStepBase.isPSDevCenterSVNIdDirty() && (bl || pSDevSlnPipelineStepBase.getPSDevCenterSVNId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERSVNID, (Object)pSDevSlnPipelineStepBase.getPSDevCenterSVNId());
        }
        if (pSDevSlnPipelineStepBase.isPSDevCenterSVNNameDirty() && (bl || pSDevSlnPipelineStepBase.getPSDevCenterSVNName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERSVNNAME, (Object)pSDevSlnPipelineStepBase.getPSDevCenterSVNName());
        }
        if (pSDevSlnPipelineStepBase.isPSDevSlnIdDirty() && (bl || pSDevSlnPipelineStepBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDevSlnPipelineStepBase.getPSDevSlnId());
        }
        if (pSDevSlnPipelineStepBase.isPSDevSlnMSDepAPIIdDirty() && (bl || pSDevSlnPipelineStepBase.getPSDevSlnMSDepAPIId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNMSDEPAPIID, (Object)pSDevSlnPipelineStepBase.getPSDevSlnMSDepAPIId());
        }
        if (pSDevSlnPipelineStepBase.isPSDevSlnMSDepAPINameDirty() && (bl || pSDevSlnPipelineStepBase.getPSDevSlnMSDepAPIName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNMSDEPAPINAME, (Object)pSDevSlnPipelineStepBase.getPSDevSlnMSDepAPIName());
        }
        if (pSDevSlnPipelineStepBase.isPSDevSlnMSDepAppIdDirty() && (bl || pSDevSlnPipelineStepBase.getPSDevSlnMSDepAppId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNMSDEPAPPID, (Object)pSDevSlnPipelineStepBase.getPSDevSlnMSDepAppId());
        }
        if (pSDevSlnPipelineStepBase.isPSDevSlnMSDepAppNameDirty() && (bl || pSDevSlnPipelineStepBase.getPSDevSlnMSDepAppName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNMSDEPAPPNAME, (Object)pSDevSlnPipelineStepBase.getPSDevSlnMSDepAppName());
        }
        if (pSDevSlnPipelineStepBase.isPSDevSlnMSDepFuncIdDirty() && (bl || pSDevSlnPipelineStepBase.getPSDevSlnMSDepFuncId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNMSDEPFUNCID, (Object)pSDevSlnPipelineStepBase.getPSDevSlnMSDepFuncId());
        }
        if (pSDevSlnPipelineStepBase.isPSDevSlnMSDepFuncNameDirty() && (bl || pSDevSlnPipelineStepBase.getPSDevSlnMSDepFuncName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNMSDEPFUNCNAME, (Object)pSDevSlnPipelineStepBase.getPSDevSlnMSDepFuncName());
        }
        if (pSDevSlnPipelineStepBase.isPSDevSlnMSDeployIdDirty() && (bl || pSDevSlnPipelineStepBase.getPSDevSlnMSDeployId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNMSDEPLOYID, (Object)pSDevSlnPipelineStepBase.getPSDevSlnMSDeployId());
        }
        if (pSDevSlnPipelineStepBase.isPSDevSlnMSDeployNameDirty() && (bl || pSDevSlnPipelineStepBase.getPSDevSlnMSDeployName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNMSDEPLOYNAME, (Object)pSDevSlnPipelineStepBase.getPSDevSlnMSDeployName());
        }
        if (pSDevSlnPipelineStepBase.isPSDevSlnPipelineIdDirty() && (bl || pSDevSlnPipelineStepBase.getPSDevSlnPipelineId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNPIPELINEID, (Object)pSDevSlnPipelineStepBase.getPSDevSlnPipelineId());
        }
        if (pSDevSlnPipelineStepBase.isPSDevSlnPipelineNameDirty() && (bl || pSDevSlnPipelineStepBase.getPSDevSlnPipelineName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNPIPELINENAME, (Object)pSDevSlnPipelineStepBase.getPSDevSlnPipelineName());
        }
        if (pSDevSlnPipelineStepBase.isPSDevSlnPipelineStageIdDirty() && (bl || pSDevSlnPipelineStepBase.getPSDevSlnPipelineStageId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNPIPELINESTAGEID, (Object)pSDevSlnPipelineStepBase.getPSDevSlnPipelineStageId());
        }
        if (pSDevSlnPipelineStepBase.isPSDevSlnPipelineStageNameDirty() && (bl || pSDevSlnPipelineStepBase.getPSDevSlnPipelineStageName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNPIPELINESTAGENAME, (Object)pSDevSlnPipelineStepBase.getPSDevSlnPipelineStageName());
        }
        if (pSDevSlnPipelineStepBase.isPSDevSlnPipelineStepIdDirty() && (bl || pSDevSlnPipelineStepBase.getPSDevSlnPipelineStepId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNPIPELINESTEPID, (Object)pSDevSlnPipelineStepBase.getPSDevSlnPipelineStepId());
        }
        if (pSDevSlnPipelineStepBase.isPSDevSlnPipelineStepNameDirty() && (bl || pSDevSlnPipelineStepBase.getPSDevSlnPipelineStepName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNPIPELINESTEPNAME, (Object)pSDevSlnPipelineStepBase.getPSDevSlnPipelineStepName());
        }
        if (pSDevSlnPipelineStepBase.isPSDevSlnSysAPIIdDirty() && (bl || pSDevSlnPipelineStepBase.getPSDevSlnSysAPIId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSAPIID, (Object)pSDevSlnPipelineStepBase.getPSDevSlnSysAPIId());
        }
        if (pSDevSlnPipelineStepBase.isPSDevSlnSysAPINameDirty() && (bl || pSDevSlnPipelineStepBase.getPSDevSlnSysAPIName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSAPINAME, (Object)pSDevSlnPipelineStepBase.getPSDevSlnSysAPIName());
        }
        if (pSDevSlnPipelineStepBase.isPSDevSlnSysAppIdDirty() && (bl || pSDevSlnPipelineStepBase.getPSDevSlnSysAppId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSAPPID, (Object)pSDevSlnPipelineStepBase.getPSDevSlnSysAppId());
        }
        if (pSDevSlnPipelineStepBase.isPSDevSlnSysAppNameDirty() && (bl || pSDevSlnPipelineStepBase.getPSDevSlnSysAppName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSAPPNAME, (Object)pSDevSlnPipelineStepBase.getPSDevSlnSysAppName());
        }
        if (pSDevSlnPipelineStepBase.isPSDevSlnSysIdDirty() && (bl || pSDevSlnPipelineStepBase.getPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSID, (Object)pSDevSlnPipelineStepBase.getPSDevSlnSysId());
        }
        if (pSDevSlnPipelineStepBase.isPSDevSlnSysNameDirty() && (bl || pSDevSlnPipelineStepBase.getPSDevSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSNAME, (Object)pSDevSlnPipelineStepBase.getPSDevSlnSysName());
        }
        if (pSDevSlnPipelineStepBase.isPSDevSlnSysSrvIdDirty() && (bl || pSDevSlnPipelineStepBase.getPSDevSlnSysSrvId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSSRVID, (Object)pSDevSlnPipelineStepBase.getPSDevSlnSysSrvId());
        }
        if (pSDevSlnPipelineStepBase.isPSDevSlnSysSrvNameDirty() && (bl || pSDevSlnPipelineStepBase.getPSDevSlnSysSrvName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSSRVNAME, (Object)pSDevSlnPipelineStepBase.getPSDevSlnSysSrvName());
        }
        if (pSDevSlnPipelineStepBase.isPSDevSlnSysVerIdDirty() && (bl || pSDevSlnPipelineStepBase.getPSDevSlnSysVerId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSVERID, (Object)pSDevSlnPipelineStepBase.getPSDevSlnSysVerId());
        }
        if (pSDevSlnPipelineStepBase.isPSDevSlnSysVerNameDirty() && (bl || pSDevSlnPipelineStepBase.getPSDevSlnSysVerName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSVERNAME, (Object)pSDevSlnPipelineStepBase.getPSDevSlnSysVerName());
        }
        if (pSDevSlnPipelineStepBase.isPSDevSlnTemplIdDirty() && (bl || pSDevSlnPipelineStepBase.getPSDevSlnTemplId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNTEMPLID, (Object)pSDevSlnPipelineStepBase.getPSDevSlnTemplId());
        }
        if (pSDevSlnPipelineStepBase.isPSDevSlnTemplNameDirty() && (bl || pSDevSlnPipelineStepBase.getPSDevSlnTemplName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNTEMPLNAME, (Object)pSDevSlnPipelineStepBase.getPSDevSlnTemplName());
        }
        if (pSDevSlnPipelineStepBase.isRefPSDevSlnPipelineIdDirty() && (bl || pSDevSlnPipelineStepBase.getRefPSDevSlnPipelineId() != null)) {
            iDataObject.set(FIELD_REFPSDEVSLNPIPELINEID, (Object)pSDevSlnPipelineStepBase.getRefPSDevSlnPipelineId());
        }
        if (pSDevSlnPipelineStepBase.isRefPSDevSlnPipelineNameDirty() && (bl || pSDevSlnPipelineStepBase.getRefPSDevSlnPipelineName() != null)) {
            iDataObject.set(FIELD_REFPSDEVSLNPIPELINENAME, (Object)pSDevSlnPipelineStepBase.getRefPSDevSlnPipelineName());
        }
        if (pSDevSlnPipelineStepBase.isRunCmdDirty() && (bl || pSDevSlnPipelineStepBase.getRunCmd() != null)) {
            iDataObject.set(FIELD_RUNCMD, (Object)pSDevSlnPipelineStepBase.getRunCmd());
        }
        if (pSDevSlnPipelineStepBase.isStepTagDirty() && (bl || pSDevSlnPipelineStepBase.getStepTag() != null)) {
            iDataObject.set(FIELD_STEPTAG, (Object)pSDevSlnPipelineStepBase.getStepTag());
        }
        if (pSDevSlnPipelineStepBase.isStepTag2Dirty() && (bl || pSDevSlnPipelineStepBase.getStepTag2() != null)) {
            iDataObject.set(FIELD_STEPTAG2, (Object)pSDevSlnPipelineStepBase.getStepTag2());
        }
        if (pSDevSlnPipelineStepBase.isStepTag3Dirty() && (bl || pSDevSlnPipelineStepBase.getStepTag3() != null)) {
            iDataObject.set(FIELD_STEPTAG3, (Object)pSDevSlnPipelineStepBase.getStepTag3());
        }
        if (pSDevSlnPipelineStepBase.isStepTag4Dirty() && (bl || pSDevSlnPipelineStepBase.getStepTag4() != null)) {
            iDataObject.set(FIELD_STEPTAG4, (Object)pSDevSlnPipelineStepBase.getStepTag4());
        }
        if (pSDevSlnPipelineStepBase.isTemplateModeDirty() && (bl || pSDevSlnPipelineStepBase.getTemplateMode() != null)) {
            iDataObject.set(FIELD_TEMPLATEMODE, (Object)pSDevSlnPipelineStepBase.getTemplateMode());
        }
        if (pSDevSlnPipelineStepBase.isTemplPSDevCenterSVNIdDirty() && (bl || pSDevSlnPipelineStepBase.getTemplPSDevCenterSVNId() != null)) {
            iDataObject.set(FIELD_TEMPLPSDEVCENTERSVNID, (Object)pSDevSlnPipelineStepBase.getTemplPSDevCenterSVNId());
        }
        if (pSDevSlnPipelineStepBase.isTemplPSDevCenterSVNNameDirty() && (bl || pSDevSlnPipelineStepBase.getTemplPSDevCenterSVNName() != null)) {
            iDataObject.set(FIELD_TEMPLPSDEVCENTERSVNNAME, (Object)pSDevSlnPipelineStepBase.getTemplPSDevCenterSVNName());
        }
        if (pSDevSlnPipelineStepBase.isToolPSDCRegistryItemIdDirty() && (bl || pSDevSlnPipelineStepBase.getToolPSDCRegistryItemId() != null)) {
            iDataObject.set(FIELD_TOOLPSDCREGISTRYITEMID, (Object)pSDevSlnPipelineStepBase.getToolPSDCRegistryItemId());
        }
        if (pSDevSlnPipelineStepBase.isToolPSDCRegistryItemNameDirty() && (bl || pSDevSlnPipelineStepBase.getToolPSDCRegistryItemName() != null)) {
            iDataObject.set(FIELD_TOOLPSDCREGISTRYITEMNAME, (Object)pSDevSlnPipelineStepBase.getToolPSDCRegistryItemName());
        }
        if (pSDevSlnPipelineStepBase.isUpdateDateDirty() && (bl || pSDevSlnPipelineStepBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevSlnPipelineStepBase.getUpdateDate());
        }
        if (pSDevSlnPipelineStepBase.isUpdateManDirty() && (bl || pSDevSlnPipelineStepBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevSlnPipelineStepBase.getUpdateMan());
        }
        if (pSDevSlnPipelineStepBase.isUserCatDirty() && (bl || pSDevSlnPipelineStepBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDevSlnPipelineStepBase.getUserCat());
        }
        if (pSDevSlnPipelineStepBase.isUserTagDirty() && (bl || pSDevSlnPipelineStepBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDevSlnPipelineStepBase.getUserTag());
        }
        if (pSDevSlnPipelineStepBase.isUserTag2Dirty() && (bl || pSDevSlnPipelineStepBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDevSlnPipelineStepBase.getUserTag2());
        }
        if (pSDevSlnPipelineStepBase.isUserTag3Dirty() && (bl || pSDevSlnPipelineStepBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDevSlnPipelineStepBase.getUserTag3());
        }
        if (pSDevSlnPipelineStepBase.isUserTag4Dirty() && (bl || pSDevSlnPipelineStepBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDevSlnPipelineStepBase.getUserTag4());
        }
        if (pSDevSlnPipelineStepBase.isValidFlagDirty() && (bl || pSDevSlnPipelineStepBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDevSlnPipelineStepBase.getValidFlag());
        }
        if (pSDevSlnPipelineStepBase.isWorkFolderDirty() && (bl || pSDevSlnPipelineStepBase.getWorkFolder() != null)) {
            iDataObject.set(FIELD_WORKFOLDER, (Object)pSDevSlnPipelineStepBase.getWorkFolder());
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
        return PSDevSlnPipelineStepBase.remove(this, n);
    }

    private static boolean remove(PSDevSlnPipelineStepBase pSDevSlnPipelineStepBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnPipelineStepBase.resetActionParams();
                return true;
            }
            case 1: {
                pSDevSlnPipelineStepBase.resetActionType();
                return true;
            }
            case 2: {
                pSDevSlnPipelineStepBase.resetAgentPSDCRegistryItemId();
                return true;
            }
            case 3: {
                pSDevSlnPipelineStepBase.resetAgentPSDCRegistryItemName();
                return true;
            }
            case 4: {
                pSDevSlnPipelineStepBase.resetCheckinMode();
                return true;
            }
            case 5: {
                pSDevSlnPipelineStepBase.resetCodeName();
                return true;
            }
            case 6: {
                pSDevSlnPipelineStepBase.resetCondModel();
                return true;
            }
            case 7: {
                pSDevSlnPipelineStepBase.resetCondModelFlag();
                return true;
            }
            case 8: {
                pSDevSlnPipelineStepBase.resetCreateDate();
                return true;
            }
            case 9: {
                pSDevSlnPipelineStepBase.resetCreateMan();
                return true;
            }
            case 10: {
                pSDevSlnPipelineStepBase.resetCustomCheckout();
                return true;
            }
            case 11: {
                pSDevSlnPipelineStepBase.resetCustomCode();
                return true;
            }
            case 12: {
                pSDevSlnPipelineStepBase.resetMemo();
                return true;
            }
            case 13: {
                pSDevSlnPipelineStepBase.resetModelPSDevCenterSVNId();
                return true;
            }
            case 14: {
                pSDevSlnPipelineStepBase.resetModelPSDevCenterSVNName();
                return true;
            }
            case 15: {
                pSDevSlnPipelineStepBase.resetOrderValue();
                return true;
            }
            case 16: {
                pSDevSlnPipelineStepBase.resetPSDCBDInstId();
                return true;
            }
            case 17: {
                pSDevSlnPipelineStepBase.resetPSDCBDInstName();
                return true;
            }
            case 18: {
                pSDevSlnPipelineStepBase.resetPSDCCodeSnippetId();
                return true;
            }
            case 19: {
                pSDevSlnPipelineStepBase.resetPSDCCodeSnippetName();
                return true;
            }
            case 20: {
                pSDevSlnPipelineStepBase.resetPSDCFileId();
                return true;
            }
            case 21: {
                pSDevSlnPipelineStepBase.resetPSDCFileName();
                return true;
            }
            case 22: {
                pSDevSlnPipelineStepBase.resetPSDCMSPlatformFuncId();
                return true;
            }
            case 23: {
                pSDevSlnPipelineStepBase.resetPSDCMSPlatformFuncName();
                return true;
            }
            case 24: {
                pSDevSlnPipelineStepBase.resetPSDCMSPlatformId();
                return true;
            }
            case 25: {
                pSDevSlnPipelineStepBase.resetPSDCMSPlatformName();
                return true;
            }
            case 26: {
                pSDevSlnPipelineStepBase.resetPSDCMSPlatformNodeId();
                return true;
            }
            case 27: {
                pSDevSlnPipelineStepBase.resetPSDCMSPlatformNodeName();
                return true;
            }
            case 28: {
                pSDevSlnPipelineStepBase.resetPSDCRegistryItemId();
                return true;
            }
            case 29: {
                pSDevSlnPipelineStepBase.resetPSDCRegistryItemName();
                return true;
            }
            case 30: {
                pSDevSlnPipelineStepBase.resetPSDCRegistryRepoId();
                return true;
            }
            case 31: {
                pSDevSlnPipelineStepBase.resetPSDCRegistryRepoName();
                return true;
            }
            case 32: {
                pSDevSlnPipelineStepBase.resetPSDevCenterDBInstId();
                return true;
            }
            case 33: {
                pSDevSlnPipelineStepBase.resetPSDevCenterDBInstName();
                return true;
            }
            case 34: {
                pSDevSlnPipelineStepBase.resetPSDevCenterSVNId();
                return true;
            }
            case 35: {
                pSDevSlnPipelineStepBase.resetPSDevCenterSVNName();
                return true;
            }
            case 36: {
                pSDevSlnPipelineStepBase.resetPSDevSlnId();
                return true;
            }
            case 37: {
                pSDevSlnPipelineStepBase.resetPSDevSlnMSDepAPIId();
                return true;
            }
            case 38: {
                pSDevSlnPipelineStepBase.resetPSDevSlnMSDepAPIName();
                return true;
            }
            case 39: {
                pSDevSlnPipelineStepBase.resetPSDevSlnMSDepAppId();
                return true;
            }
            case 40: {
                pSDevSlnPipelineStepBase.resetPSDevSlnMSDepAppName();
                return true;
            }
            case 41: {
                pSDevSlnPipelineStepBase.resetPSDevSlnMSDepFuncId();
                return true;
            }
            case 42: {
                pSDevSlnPipelineStepBase.resetPSDevSlnMSDepFuncName();
                return true;
            }
            case 43: {
                pSDevSlnPipelineStepBase.resetPSDevSlnMSDeployId();
                return true;
            }
            case 44: {
                pSDevSlnPipelineStepBase.resetPSDevSlnMSDeployName();
                return true;
            }
            case 45: {
                pSDevSlnPipelineStepBase.resetPSDevSlnPipelineId();
                return true;
            }
            case 46: {
                pSDevSlnPipelineStepBase.resetPSDevSlnPipelineName();
                return true;
            }
            case 47: {
                pSDevSlnPipelineStepBase.resetPSDevSlnPipelineStageId();
                return true;
            }
            case 48: {
                pSDevSlnPipelineStepBase.resetPSDevSlnPipelineStageName();
                return true;
            }
            case 49: {
                pSDevSlnPipelineStepBase.resetPSDevSlnPipelineStepId();
                return true;
            }
            case 50: {
                pSDevSlnPipelineStepBase.resetPSDevSlnPipelineStepName();
                return true;
            }
            case 51: {
                pSDevSlnPipelineStepBase.resetPSDevSlnSysAPIId();
                return true;
            }
            case 52: {
                pSDevSlnPipelineStepBase.resetPSDevSlnSysAPIName();
                return true;
            }
            case 53: {
                pSDevSlnPipelineStepBase.resetPSDevSlnSysAppId();
                return true;
            }
            case 54: {
                pSDevSlnPipelineStepBase.resetPSDevSlnSysAppName();
                return true;
            }
            case 55: {
                pSDevSlnPipelineStepBase.resetPSDevSlnSysId();
                return true;
            }
            case 56: {
                pSDevSlnPipelineStepBase.resetPSDevSlnSysName();
                return true;
            }
            case 57: {
                pSDevSlnPipelineStepBase.resetPSDevSlnSysSrvId();
                return true;
            }
            case 58: {
                pSDevSlnPipelineStepBase.resetPSDevSlnSysSrvName();
                return true;
            }
            case 59: {
                pSDevSlnPipelineStepBase.resetPSDevSlnSysVerId();
                return true;
            }
            case 60: {
                pSDevSlnPipelineStepBase.resetPSDevSlnSysVerName();
                return true;
            }
            case 61: {
                pSDevSlnPipelineStepBase.resetPSDevSlnTemplId();
                return true;
            }
            case 62: {
                pSDevSlnPipelineStepBase.resetPSDevSlnTemplName();
                return true;
            }
            case 63: {
                pSDevSlnPipelineStepBase.resetRefPSDevSlnPipelineId();
                return true;
            }
            case 64: {
                pSDevSlnPipelineStepBase.resetRefPSDevSlnPipelineName();
                return true;
            }
            case 65: {
                pSDevSlnPipelineStepBase.resetRunCmd();
                return true;
            }
            case 66: {
                pSDevSlnPipelineStepBase.resetStepTag();
                return true;
            }
            case 67: {
                pSDevSlnPipelineStepBase.resetStepTag2();
                return true;
            }
            case 68: {
                pSDevSlnPipelineStepBase.resetStepTag3();
                return true;
            }
            case 69: {
                pSDevSlnPipelineStepBase.resetStepTag4();
                return true;
            }
            case 70: {
                pSDevSlnPipelineStepBase.resetTemplateMode();
                return true;
            }
            case 71: {
                pSDevSlnPipelineStepBase.resetTemplPSDevCenterSVNId();
                return true;
            }
            case 72: {
                pSDevSlnPipelineStepBase.resetTemplPSDevCenterSVNName();
                return true;
            }
            case 73: {
                pSDevSlnPipelineStepBase.resetToolPSDCRegistryItemId();
                return true;
            }
            case 74: {
                pSDevSlnPipelineStepBase.resetToolPSDCRegistryItemName();
                return true;
            }
            case 75: {
                pSDevSlnPipelineStepBase.resetUpdateDate();
                return true;
            }
            case 76: {
                pSDevSlnPipelineStepBase.resetUpdateMan();
                return true;
            }
            case 77: {
                pSDevSlnPipelineStepBase.resetUserCat();
                return true;
            }
            case 78: {
                pSDevSlnPipelineStepBase.resetUserTag();
                return true;
            }
            case 79: {
                pSDevSlnPipelineStepBase.resetUserTag2();
                return true;
            }
            case 80: {
                pSDevSlnPipelineStepBase.resetUserTag3();
                return true;
            }
            case 81: {
                pSDevSlnPipelineStepBase.resetUserTag4();
                return true;
            }
            case 82: {
                pSDevSlnPipelineStepBase.resetValidFlag();
                return true;
            }
            case 83: {
                pSDevSlnPipelineStepBase.resetWorkFolder();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCBDInst getPSDCBDInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCBDInst();
        }
        if (this.getPSDCBDInstId() == null) {
            return null;
        }
        Integer n = this.objPSDCBDInstLock;
        synchronized (n) {
            if (this.psdcbdinst != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCBDInstId(), (Object)this.psdcbdinst.getPSDCBDInstId()) != 0L) {
                this.psdcbdinst = null;
            }
            if (this.psdcbdinst == null) {
                PSDCBDInst pSDCBDInst = new PSDCBDInst();
                pSDCBDInst.setPSDCBDInstId(this.getPSDCBDInstId());
                PSDCBDInstService pSDCBDInstService = (PSDCBDInstService)ServiceGlobal.getService(PSDCBDInstService.class, (SessionFactory)this.getSessionFactory());
                pSDCBDInstService.autoGet(pSDCBDInst);
                this.psdcbdinst = pSDCBDInst;
            }
            return this.psdcbdinst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCCodeSnippet getPSDCCodeSnippet() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCCodeSnippet();
        }
        if (this.getPSDCCodeSnippetId() == null) {
            return null;
        }
        Integer n = this.objPSDCCodeSnippetLock;
        synchronized (n) {
            if (this.psdccodesnippet != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCCodeSnippetId(), (Object)this.psdccodesnippet.getPSDCCodeSnippetId()) != 0L) {
                this.psdccodesnippet = null;
            }
            if (this.psdccodesnippet == null) {
                PSDCCodeSnippet pSDCCodeSnippet = new PSDCCodeSnippet();
                pSDCCodeSnippet.setPSDCCodeSnippetId(this.getPSDCCodeSnippetId());
                PSDCCodeSnippetService pSDCCodeSnippetService = (PSDCCodeSnippetService)ServiceGlobal.getService(PSDCCodeSnippetService.class, (SessionFactory)this.getSessionFactory());
                pSDCCodeSnippetService.autoGet(pSDCCodeSnippet);
                this.psdccodesnippet = pSDCCodeSnippet;
            }
            return this.psdccodesnippet;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCFile getPSDCFile() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCFile();
        }
        if (this.getPSDCFileId() == null) {
            return null;
        }
        Integer n = this.objPSDCFileLock;
        synchronized (n) {
            if (this.psdcfile != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCFileId(), (Object)this.psdcfile.getPSDCFileId()) != 0L) {
                this.psdcfile = null;
            }
            if (this.psdcfile == null) {
                PSDCFile pSDCFile = new PSDCFile();
                pSDCFile.setPSDCFileId(this.getPSDCFileId());
                PSDCFileService pSDCFileService = (PSDCFileService)ServiceGlobal.getService(PSDCFileService.class, (SessionFactory)this.getSessionFactory());
                pSDCFileService.autoGet(pSDCFile);
                this.psdcfile = pSDCFile;
            }
            return this.psdcfile;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCMSPlatformFunc getPSDCMSPlatformFunc() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMSPlatformFunc();
        }
        if (this.getPSDCMSPlatformFuncId() == null) {
            return null;
        }
        Integer n = this.objPSDCMSPlatformFuncLock;
        synchronized (n) {
            if (this.psdcmsplatformfunc != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCMSPlatformFuncId(), (Object)this.psdcmsplatformfunc.getPSDCMSPlatformFuncId()) != 0L) {
                this.psdcmsplatformfunc = null;
            }
            if (this.psdcmsplatformfunc == null) {
                PSDCMSPlatformFunc pSDCMSPlatformFunc = new PSDCMSPlatformFunc();
                pSDCMSPlatformFunc.setPSDCMSPlatformFuncId(this.getPSDCMSPlatformFuncId());
                PSDCMSPlatformFuncService pSDCMSPlatformFuncService = (PSDCMSPlatformFuncService)ServiceGlobal.getService(PSDCMSPlatformFuncService.class, (SessionFactory)this.getSessionFactory());
                pSDCMSPlatformFuncService.autoGet(pSDCMSPlatformFunc);
                this.psdcmsplatformfunc = pSDCMSPlatformFunc;
            }
            return this.psdcmsplatformfunc;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCMSPlatformNode getPSDCMSPlatformNode() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMSPlatformNode();
        }
        if (this.getPSDCMSPlatformNodeId() == null) {
            return null;
        }
        Integer n = this.objPSDCMSPlatformNodeLock;
        synchronized (n) {
            if (this.psdcmsplatformnode != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCMSPlatformNodeId(), (Object)this.psdcmsplatformnode.getPSDCMSPlatformNodeId()) != 0L) {
                this.psdcmsplatformnode = null;
            }
            if (this.psdcmsplatformnode == null) {
                PSDCMSPlatformNode pSDCMSPlatformNode = new PSDCMSPlatformNode();
                pSDCMSPlatformNode.setPSDCMSPlatformNodeId(this.getPSDCMSPlatformNodeId());
                PSDCMSPlatformNodeService pSDCMSPlatformNodeService = (PSDCMSPlatformNodeService)ServiceGlobal.getService(PSDCMSPlatformNodeService.class, (SessionFactory)this.getSessionFactory());
                pSDCMSPlatformNodeService.autoGet(pSDCMSPlatformNode);
                this.psdcmsplatformnode = pSDCMSPlatformNode;
            }
            return this.psdcmsplatformnode;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCMSPlatform getPSDCMSPlatform() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMSPlatform();
        }
        if (this.getPSDCMSPlatformId() == null) {
            return null;
        }
        Integer n = this.objPSDCMSPlatformLock;
        synchronized (n) {
            if (this.psdcmsplatform != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCMSPlatformId(), (Object)this.psdcmsplatform.getPSDCMSPlatformId()) != 0L) {
                this.psdcmsplatform = null;
            }
            if (this.psdcmsplatform == null) {
                PSDCMSPlatform pSDCMSPlatform = new PSDCMSPlatform();
                pSDCMSPlatform.setPSDCMSPlatformId(this.getPSDCMSPlatformId());
                PSDCMSPlatformService pSDCMSPlatformService = (PSDCMSPlatformService)ServiceGlobal.getService(PSDCMSPlatformService.class, (SessionFactory)this.getSessionFactory());
                pSDCMSPlatformService.autoGet(pSDCMSPlatform);
                this.psdcmsplatform = pSDCMSPlatform;
            }
            return this.psdcmsplatform;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCRegistryItem getAgentPSDCRegistryItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAgentPSDCRegistryItem();
        }
        if (this.getAgentPSDCRegistryItemId() == null) {
            return null;
        }
        Integer n = this.objAgentPSDCRegistryItemLock;
        synchronized (n) {
            if (this.agentpsdcregistryitem != null && DataTypeHelper.compare((int)25, (Object)this.getAgentPSDCRegistryItemId(), (Object)this.agentpsdcregistryitem.getPSDCRegistryItemId()) != 0L) {
                this.agentpsdcregistryitem = null;
            }
            if (this.agentpsdcregistryitem == null) {
                PSDCRegistryItem pSDCRegistryItem = new PSDCRegistryItem();
                pSDCRegistryItem.setPSDCRegistryItemId(this.getAgentPSDCRegistryItemId());
                PSDCRegistryItemService pSDCRegistryItemService = (PSDCRegistryItemService)ServiceGlobal.getService(PSDCRegistryItemService.class, (SessionFactory)this.getSessionFactory());
                pSDCRegistryItemService.autoGet(pSDCRegistryItem);
                this.agentpsdcregistryitem = pSDCRegistryItem;
            }
            return this.agentpsdcregistryitem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCRegistryItem getPSDCRegistryItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCRegistryItem();
        }
        if (this.getPSDCRegistryItemId() == null) {
            return null;
        }
        Integer n = this.objPSDCRegistryItemLock;
        synchronized (n) {
            if (this.psdcregistryitem != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCRegistryItemId(), (Object)this.psdcregistryitem.getPSDCRegistryItemId()) != 0L) {
                this.psdcregistryitem = null;
            }
            if (this.psdcregistryitem == null) {
                PSDCRegistryItem pSDCRegistryItem = new PSDCRegistryItem();
                pSDCRegistryItem.setPSDCRegistryItemId(this.getPSDCRegistryItemId());
                PSDCRegistryItemService pSDCRegistryItemService = (PSDCRegistryItemService)ServiceGlobal.getService(PSDCRegistryItemService.class, (SessionFactory)this.getSessionFactory());
                pSDCRegistryItemService.autoGet(pSDCRegistryItem);
                this.psdcregistryitem = pSDCRegistryItem;
            }
            return this.psdcregistryitem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCRegistryItem getToolPSDCRegistryItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getToolPSDCRegistryItem();
        }
        if (this.getToolPSDCRegistryItemId() == null) {
            return null;
        }
        Integer n = this.objToolPSDCRegistryItemLock;
        synchronized (n) {
            if (this.toolpsdcregistryitem != null && DataTypeHelper.compare((int)25, (Object)this.getToolPSDCRegistryItemId(), (Object)this.toolpsdcregistryitem.getPSDCRegistryItemId()) != 0L) {
                this.toolpsdcregistryitem = null;
            }
            if (this.toolpsdcregistryitem == null) {
                PSDCRegistryItem pSDCRegistryItem = new PSDCRegistryItem();
                pSDCRegistryItem.setPSDCRegistryItemId(this.getToolPSDCRegistryItemId());
                PSDCRegistryItemService pSDCRegistryItemService = (PSDCRegistryItemService)ServiceGlobal.getService(PSDCRegistryItemService.class, (SessionFactory)this.getSessionFactory());
                pSDCRegistryItemService.autoGet(pSDCRegistryItem);
                this.toolpsdcregistryitem = pSDCRegistryItem;
            }
            return this.toolpsdcregistryitem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCRegistryRepo getPSDCRegistryRepo() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCRegistryRepo();
        }
        if (this.getPSDCRegistryRepoId() == null) {
            return null;
        }
        Integer n = this.objPSDCRegistryRepoLock;
        synchronized (n) {
            if (this.psdcregistryrepo != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCRegistryRepoId(), (Object)this.psdcregistryrepo.getPSDCRegistryRepoId()) != 0L) {
                this.psdcregistryrepo = null;
            }
            if (this.psdcregistryrepo == null) {
                PSDCRegistryRepo pSDCRegistryRepo = new PSDCRegistryRepo();
                pSDCRegistryRepo.setPSDCRegistryRepoId(this.getPSDCRegistryRepoId());
                PSDCRegistryRepoService pSDCRegistryRepoService = (PSDCRegistryRepoService)ServiceGlobal.getService(PSDCRegistryRepoService.class, (SessionFactory)this.getSessionFactory());
                pSDCRegistryRepoService.autoGet(pSDCRegistryRepo);
                this.psdcregistryrepo = pSDCRegistryRepo;
            }
            return this.psdcregistryrepo;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterDBInst getPSDevCenterDBInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterDBInst();
        }
        if (this.getPSDevCenterDBInstId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterDBInstLock;
        synchronized (n) {
            if (this.psdevcenterdbinst != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterDBInstId(), (Object)this.psdevcenterdbinst.getPSDevCenterDBInstId()) != 0L) {
                this.psdevcenterdbinst = null;
            }
            if (this.psdevcenterdbinst == null) {
                PSDevCenterDBInst pSDevCenterDBInst = new PSDevCenterDBInst();
                pSDevCenterDBInst.setPSDevCenterDBInstId(this.getPSDevCenterDBInstId());
                PSDevCenterDBInstService pSDevCenterDBInstService = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterDBInstService.autoGet(pSDevCenterDBInst);
                this.psdevcenterdbinst = pSDevCenterDBInst;
            }
            return this.psdevcenterdbinst;
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
    public PSDevCenterSVN getTemplPSDevCenterSVN() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplPSDevCenterSVN();
        }
        if (this.getTemplPSDevCenterSVNId() == null) {
            return null;
        }
        Integer n = this.objTemplPSDevCenterSVNLock;
        synchronized (n) {
            if (this.templpsdevcentersvn != null && DataTypeHelper.compare((int)25, (Object)this.getTemplPSDevCenterSVNId(), (Object)this.templpsdevcentersvn.getPSDevCenterSVNId()) != 0L) {
                this.templpsdevcentersvn = null;
            }
            if (this.templpsdevcentersvn == null) {
                PSDevCenterSVN pSDevCenterSVN = new PSDevCenterSVN();
                pSDevCenterSVN.setPSDevCenterSVNId(this.getTemplPSDevCenterSVNId());
                PSDevCenterSVNService pSDevCenterSVNService = (PSDevCenterSVNService)ServiceGlobal.getService(PSDevCenterSVNService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterSVNService.autoGet(pSDevCenterSVN);
                this.templpsdevcentersvn = pSDevCenterSVN;
            }
            return this.templpsdevcentersvn;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnMSDepAPI getPSDevSlnMSDepAPI() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDepAPI();
        }
        if (this.getPSDevSlnMSDepAPIId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnMSDepAPILock;
        synchronized (n) {
            if (this.psdevslnmsdepapi != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnMSDepAPIId(), (Object)this.psdevslnmsdepapi.getPSDevSlnMSDepAPIId()) != 0L) {
                this.psdevslnmsdepapi = null;
            }
            if (this.psdevslnmsdepapi == null) {
                PSDevSlnMSDepAPI pSDevSlnMSDepAPI = new PSDevSlnMSDepAPI();
                pSDevSlnMSDepAPI.setPSDevSlnMSDepAPIId(this.getPSDevSlnMSDepAPIId());
                PSDevSlnMSDepAPIService pSDevSlnMSDepAPIService = (PSDevSlnMSDepAPIService)ServiceGlobal.getService(PSDevSlnMSDepAPIService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnMSDepAPIService.autoGet(pSDevSlnMSDepAPI);
                this.psdevslnmsdepapi = pSDevSlnMSDepAPI;
            }
            return this.psdevslnmsdepapi;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnMSDepApp getPSDevSlnMSDepApp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDepApp();
        }
        if (this.getPSDevSlnMSDepAppId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnMSDepAppLock;
        synchronized (n) {
            if (this.psdevslnmsdepapp != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnMSDepAppId(), (Object)this.psdevslnmsdepapp.getPSDevSlnMSDepAppId()) != 0L) {
                this.psdevslnmsdepapp = null;
            }
            if (this.psdevslnmsdepapp == null) {
                PSDevSlnMSDepApp pSDevSlnMSDepApp = new PSDevSlnMSDepApp();
                pSDevSlnMSDepApp.setPSDevSlnMSDepAppId(this.getPSDevSlnMSDepAppId());
                PSDevSlnMSDepAppService pSDevSlnMSDepAppService = (PSDevSlnMSDepAppService)ServiceGlobal.getService(PSDevSlnMSDepAppService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnMSDepAppService.autoGet(pSDevSlnMSDepApp);
                this.psdevslnmsdepapp = pSDevSlnMSDepApp;
            }
            return this.psdevslnmsdepapp;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnMSDepFunc getPSDevSlnMSDepFunc() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDepFunc();
        }
        if (this.getPSDevSlnMSDepFuncId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnMSDepFuncLock;
        synchronized (n) {
            if (this.psdevslnmsdepfunc != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnMSDepFuncId(), (Object)this.psdevslnmsdepfunc.getPSDevSlnMSDepFuncId()) != 0L) {
                this.psdevslnmsdepfunc = null;
            }
            if (this.psdevslnmsdepfunc == null) {
                PSDevSlnMSDepFunc pSDevSlnMSDepFunc = new PSDevSlnMSDepFunc();
                pSDevSlnMSDepFunc.setPSDevSlnMSDepFuncId(this.getPSDevSlnMSDepFuncId());
                PSDevSlnMSDepFuncService pSDevSlnMSDepFuncService = (PSDevSlnMSDepFuncService)ServiceGlobal.getService(PSDevSlnMSDepFuncService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnMSDepFuncService.autoGet(pSDevSlnMSDepFunc);
                this.psdevslnmsdepfunc = pSDevSlnMSDepFunc;
            }
            return this.psdevslnmsdepfunc;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnMSDeploy getPSDevSlnMSDeploy() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDeploy();
        }
        if (this.getPSDevSlnMSDeployId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnMSDeployLock;
        synchronized (n) {
            if (this.psdevslnmsdeploy != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnMSDeployId(), (Object)this.psdevslnmsdeploy.getPSDevSlnMSDeployId()) != 0L) {
                this.psdevslnmsdeploy = null;
            }
            if (this.psdevslnmsdeploy == null) {
                PSDevSlnMSDeploy pSDevSlnMSDeploy = new PSDevSlnMSDeploy();
                pSDevSlnMSDeploy.setPSDevSlnMSDeployId(this.getPSDevSlnMSDeployId());
                PSDevSlnMSDeployService pSDevSlnMSDeployService = (PSDevSlnMSDeployService)ServiceGlobal.getService(PSDevSlnMSDeployService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnMSDeployService.autoGet(pSDevSlnMSDeploy);
                this.psdevslnmsdeploy = pSDevSlnMSDeploy;
            }
            return this.psdevslnmsdeploy;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnPipelineStage getPSDevSlnPipelineStage() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnPipelineStage();
        }
        if (this.getPSDevSlnPipelineStageId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnPipelineStageLock;
        synchronized (n) {
            if (this.psdevslnpipelinestage != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnPipelineStageId(), (Object)this.psdevslnpipelinestage.getPSDevSlnPipelineStageId()) != 0L) {
                this.psdevslnpipelinestage = null;
            }
            if (this.psdevslnpipelinestage == null) {
                PSDevSlnPipelineStage pSDevSlnPipelineStage = new PSDevSlnPipelineStage();
                pSDevSlnPipelineStage.setPSDevSlnPipelineStageId(this.getPSDevSlnPipelineStageId());
                PSDevSlnPipelineStageService pSDevSlnPipelineStageService = (PSDevSlnPipelineStageService)ServiceGlobal.getService(PSDevSlnPipelineStageService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnPipelineStageService.autoGet(pSDevSlnPipelineStage);
                this.psdevslnpipelinestage = pSDevSlnPipelineStage;
            }
            return this.psdevslnpipelinestage;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnPipeline getPSDevSlnPipeline() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnPipeline();
        }
        if (this.getPSDevSlnPipelineId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnPipelineLock;
        synchronized (n) {
            if (this.psdevslnpipeline != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnPipelineId(), (Object)this.psdevslnpipeline.getPSDevSlnPipelineId()) != 0L) {
                this.psdevslnpipeline = null;
            }
            if (this.psdevslnpipeline == null) {
                PSDevSlnPipeline pSDevSlnPipeline = new PSDevSlnPipeline();
                pSDevSlnPipeline.setPSDevSlnPipelineId(this.getPSDevSlnPipelineId());
                PSDevSlnPipelineService pSDevSlnPipelineService = (PSDevSlnPipelineService)ServiceGlobal.getService(PSDevSlnPipelineService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnPipelineService.autoGet(pSDevSlnPipeline);
                this.psdevslnpipeline = pSDevSlnPipeline;
            }
            return this.psdevslnpipeline;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnPipeline getRefPSDevSlnPipeline() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDevSlnPipeline();
        }
        if (this.getRefPSDevSlnPipelineId() == null) {
            return null;
        }
        Integer n = this.objRefPSDevSlnPipelineLock;
        synchronized (n) {
            if (this.refpsdevslnpipeline != null && DataTypeHelper.compare((int)25, (Object)this.getRefPSDevSlnPipelineId(), (Object)this.refpsdevslnpipeline.getPSDevSlnPipelineId()) != 0L) {
                this.refpsdevslnpipeline = null;
            }
            if (this.refpsdevslnpipeline == null) {
                PSDevSlnPipeline pSDevSlnPipeline = new PSDevSlnPipeline();
                pSDevSlnPipeline.setPSDevSlnPipelineId(this.getRefPSDevSlnPipelineId());
                PSDevSlnPipelineService pSDevSlnPipelineService = (PSDevSlnPipelineService)ServiceGlobal.getService(PSDevSlnPipelineService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnPipelineService.autoGet(pSDevSlnPipeline);
                this.refpsdevslnpipeline = pSDevSlnPipeline;
            }
            return this.refpsdevslnpipeline;
        }
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
    public PSDevSlnSysApp getPSDevSlnSysApp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysApp();
        }
        if (this.getPSDevSlnSysAppId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnSysAppLock;
        synchronized (n) {
            if (this.psdevslnsysapp != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnSysAppId(), (Object)this.psdevslnsysapp.getPSDevSlnSysAppId()) != 0L) {
                this.psdevslnsysapp = null;
            }
            if (this.psdevslnsysapp == null) {
                PSDevSlnSysApp pSDevSlnSysApp = new PSDevSlnSysApp();
                pSDevSlnSysApp.setPSDevSlnSysAppId(this.getPSDevSlnSysAppId());
                PSDevSlnSysAppService pSDevSlnSysAppService = (PSDevSlnSysAppService)ServiceGlobal.getService(PSDevSlnSysAppService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysAppService.autoGet(pSDevSlnSysApp);
                this.psdevslnsysapp = pSDevSlnSysApp;
            }
            return this.psdevslnsysapp;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnSysSrv getPSDevSlnSysSrv() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysSrv();
        }
        if (this.getPSDevSlnSysSrvId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnSysSrvLock;
        synchronized (n) {
            if (this.psdevslnsyssrv != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnSysSrvId(), (Object)this.psdevslnsyssrv.getPSDevSlnSysSrvId()) != 0L) {
                this.psdevslnsyssrv = null;
            }
            if (this.psdevslnsyssrv == null) {
                PSDevSlnSysSrv pSDevSlnSysSrv = new PSDevSlnSysSrv();
                pSDevSlnSysSrv.setPSDevSlnSysSrvId(this.getPSDevSlnSysSrvId());
                PSDevSlnSysSrvService pSDevSlnSysSrvService = (PSDevSlnSysSrvService)ServiceGlobal.getService(PSDevSlnSysSrvService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysSrvService.autoGet(pSDevSlnSysSrv);
                this.psdevslnsyssrv = pSDevSlnSysSrv;
            }
            return this.psdevslnsyssrv;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnSysVer getPSDevSlnSysVer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysVer();
        }
        if (this.getPSDevSlnSysVerId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnSysVerLock;
        synchronized (n) {
            if (this.psdevslnsysver != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnSysVerId(), (Object)this.psdevslnsysver.getPSDevSlnSysVerId()) != 0L) {
                this.psdevslnsysver = null;
            }
            if (this.psdevslnsysver == null) {
                PSDevSlnSysVer pSDevSlnSysVer = new PSDevSlnSysVer();
                pSDevSlnSysVer.setPSDevSlnSysVerId(this.getPSDevSlnSysVerId());
                PSDevSlnSysVerService pSDevSlnSysVerService = (PSDevSlnSysVerService)ServiceGlobal.getService(PSDevSlnSysVerService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysVerService.autoGet(pSDevSlnSysVer);
                this.psdevslnsysver = pSDevSlnSysVer;
            }
            return this.psdevslnsysver;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnSys getPSDevSlnSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSys();
        }
        if (this.getPSDevSlnSysId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnSysLock;
        synchronized (n) {
            if (this.psdevslnsys != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnSysId(), (Object)this.psdevslnsys.getPSDevSlnSysId()) != 0L) {
                this.psdevslnsys = null;
            }
            if (this.psdevslnsys == null) {
                PSDevSlnSys pSDevSlnSys = new PSDevSlnSys();
                pSDevSlnSys.setPSDevSlnSysId(this.getPSDevSlnSysId());
                PSDevSlnSysService pSDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysService.autoGet(pSDevSlnSys);
                this.psdevslnsys = pSDevSlnSys;
            }
            return this.psdevslnsys;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnTempl getPSDevSlnTempl() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnTempl();
        }
        if (this.getPSDevSlnTemplId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnTemplLock;
        synchronized (n) {
            if (this.psdevslntempl != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnTemplId(), (Object)this.psdevslntempl.getPSDevSlnTemplId()) != 0L) {
                this.psdevslntempl = null;
            }
            if (this.psdevslntempl == null) {
                PSDevSlnTempl pSDevSlnTempl = new PSDevSlnTempl();
                pSDevSlnTempl.setPSDevSlnTemplId(this.getPSDevSlnTemplId());
                PSDevSlnTemplService pSDevSlnTemplService = (PSDevSlnTemplService)ServiceGlobal.getService(PSDevSlnTemplService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnTemplService.autoGet(pSDevSlnTempl);
                this.psdevslntempl = pSDevSlnTempl;
            }
            return this.psdevslntempl;
        }
    }

    private PSDevSlnPipelineStepBase getProxyEntity() {
        return this.proxyPSDevSlnPipelineStepBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevSlnPipelineStepBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevSlnPipelineStepBase) {
            this.proxyPSDevSlnPipelineStepBase = (PSDevSlnPipelineStepBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineStepService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ACTIONPARAMS, 0);
        fieldIndexMap.put(FIELD_ACTIONTYPE, 1);
        fieldIndexMap.put(FIELD_AGENTPSDCREGISTRYITEMID, 2);
        fieldIndexMap.put(FIELD_AGENTPSDCREGISTRYITEMNAME, 3);
        fieldIndexMap.put(FIELD_CHECKINMODE, 4);
        fieldIndexMap.put(FIELD_CODENAME, 5);
        fieldIndexMap.put(FIELD_CONDMODEL, 6);
        fieldIndexMap.put(FIELD_CONDMODELFLAG, 7);
        fieldIndexMap.put(FIELD_CREATEDATE, 8);
        fieldIndexMap.put(FIELD_CREATEMAN, 9);
        fieldIndexMap.put(FIELD_CUSTOMCHECKOUT, 10);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 11);
        fieldIndexMap.put(FIELD_MEMO, 12);
        fieldIndexMap.put(FIELD_MODELPSDEVCENTERSVNID, 13);
        fieldIndexMap.put(FIELD_MODELPSDEVCENTERSVNNAME, 14);
        fieldIndexMap.put(FIELD_ORDERVALUE, 15);
        fieldIndexMap.put(FIELD_PSDCBDINSTID, 16);
        fieldIndexMap.put(FIELD_PSDCBDINSTNAME, 17);
        fieldIndexMap.put(FIELD_PSDCCODESNIPPETID, 18);
        fieldIndexMap.put(FIELD_PSDCCODESNIPPETNAME, 19);
        fieldIndexMap.put(FIELD_PSDCFILEID, 20);
        fieldIndexMap.put(FIELD_PSDCFILENAME, 21);
        fieldIndexMap.put(FIELD_PSDCMSPLATFORMFUNCID, 22);
        fieldIndexMap.put(FIELD_PSDCMSPLATFORMFUNCNAME, 23);
        fieldIndexMap.put(FIELD_PSDCMSPLATFORMID, 24);
        fieldIndexMap.put(FIELD_PSDCMSPLATFORMNAME, 25);
        fieldIndexMap.put(FIELD_PSDCMSPLATFORMNODEID, 26);
        fieldIndexMap.put(FIELD_PSDCMSPLATFORMNODENAME, 27);
        fieldIndexMap.put(FIELD_PSDCREGISTRYITEMID, 28);
        fieldIndexMap.put(FIELD_PSDCREGISTRYITEMNAME, 29);
        fieldIndexMap.put(FIELD_PSDCREGISTRYREPOID, 30);
        fieldIndexMap.put(FIELD_PSDCREGISTRYREPONAME, 31);
        fieldIndexMap.put(FIELD_PSDEVCENTERDBINSTID, 32);
        fieldIndexMap.put(FIELD_PSDEVCENTERDBINSTNAME, 33);
        fieldIndexMap.put(FIELD_PSDEVCENTERSVNID, 34);
        fieldIndexMap.put(FIELD_PSDEVCENTERSVNNAME, 35);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 36);
        fieldIndexMap.put(FIELD_PSDEVSLNMSDEPAPIID, 37);
        fieldIndexMap.put(FIELD_PSDEVSLNMSDEPAPINAME, 38);
        fieldIndexMap.put(FIELD_PSDEVSLNMSDEPAPPID, 39);
        fieldIndexMap.put(FIELD_PSDEVSLNMSDEPAPPNAME, 40);
        fieldIndexMap.put(FIELD_PSDEVSLNMSDEPFUNCID, 41);
        fieldIndexMap.put(FIELD_PSDEVSLNMSDEPFUNCNAME, 42);
        fieldIndexMap.put(FIELD_PSDEVSLNMSDEPLOYID, 43);
        fieldIndexMap.put(FIELD_PSDEVSLNMSDEPLOYNAME, 44);
        fieldIndexMap.put(FIELD_PSDEVSLNPIPELINEID, 45);
        fieldIndexMap.put(FIELD_PSDEVSLNPIPELINENAME, 46);
        fieldIndexMap.put(FIELD_PSDEVSLNPIPELINESTAGEID, 47);
        fieldIndexMap.put(FIELD_PSDEVSLNPIPELINESTAGENAME, 48);
        fieldIndexMap.put(FIELD_PSDEVSLNPIPELINESTEPID, 49);
        fieldIndexMap.put(FIELD_PSDEVSLNPIPELINESTEPNAME, 50);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSAPIID, 51);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSAPINAME, 52);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSAPPID, 53);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSAPPNAME, 54);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSID, 55);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSNAME, 56);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSSRVID, 57);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSSRVNAME, 58);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSVERID, 59);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSVERNAME, 60);
        fieldIndexMap.put(FIELD_PSDEVSLNTEMPLID, 61);
        fieldIndexMap.put(FIELD_PSDEVSLNTEMPLNAME, 62);
        fieldIndexMap.put(FIELD_REFPSDEVSLNPIPELINEID, 63);
        fieldIndexMap.put(FIELD_REFPSDEVSLNPIPELINENAME, 64);
        fieldIndexMap.put(FIELD_RUNCMD, 65);
        fieldIndexMap.put(FIELD_STEPTAG, 66);
        fieldIndexMap.put(FIELD_STEPTAG2, 67);
        fieldIndexMap.put(FIELD_STEPTAG3, 68);
        fieldIndexMap.put(FIELD_STEPTAG4, 69);
        fieldIndexMap.put(FIELD_TEMPLATEMODE, 70);
        fieldIndexMap.put(FIELD_TEMPLPSDEVCENTERSVNID, 71);
        fieldIndexMap.put(FIELD_TEMPLPSDEVCENTERSVNNAME, 72);
        fieldIndexMap.put(FIELD_TOOLPSDCREGISTRYITEMID, 73);
        fieldIndexMap.put(FIELD_TOOLPSDCREGISTRYITEMNAME, 74);
        fieldIndexMap.put(FIELD_UPDATEDATE, 75);
        fieldIndexMap.put(FIELD_UPDATEMAN, 76);
        fieldIndexMap.put(FIELD_USERCAT, 77);
        fieldIndexMap.put(FIELD_USERTAG, 78);
        fieldIndexMap.put(FIELD_USERTAG2, 79);
        fieldIndexMap.put(FIELD_USERTAG3, 80);
        fieldIndexMap.put(FIELD_USERTAG4, 81);
        fieldIndexMap.put(FIELD_VALIDFLAG, 82);
        fieldIndexMap.put(FIELD_WORKFOLDER, 83);
    }
}

