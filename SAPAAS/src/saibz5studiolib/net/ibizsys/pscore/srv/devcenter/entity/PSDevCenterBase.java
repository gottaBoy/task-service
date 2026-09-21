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
package net.ibizsys.pscore.srv.devcenter.entity;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCCluster;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCCodeSnippet;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCContainerSpec;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCDETempl;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCDeployServer;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCFile;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMSPlatform;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCModelTempl;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRegistryRepo;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRobotAbility;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCSearchEngineInst;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCSyncData;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCWFEngineInst;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkshopServer;
import net.ibizsys.pscore.srv.devcenter.service.PSDCClusterService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCCodeSnippetService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCContainerSpecService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCDETemplService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCDeployServerService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCFileService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCModelTemplService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCRegistryRepoService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCRobotAbilityService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCSearchEngineInstService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCSyncDataService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCWFEngineInstService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCWorkshopServerService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCredential;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDCInst;
import net.ibizsys.pscore.srv.paasmgr.entity.PSMavenRepo;
import net.ibizsys.pscore.srv.paasmgr.entity.PSPMSServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSRTWXAccount;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSVNInstRepo;
import net.ibizsys.pscore.srv.paasmgr.entity.PSStudioPlugin;
import net.ibizsys.pscore.srv.paasmgr.entity.PSStudioServerGrp;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrProvider;
import net.ibizsys.pscore.srv.paasmgr.service.PSCredentialService;
import net.ibizsys.pscore.srv.paasmgr.service.PSDCInstService;
import net.ibizsys.pscore.srv.paasmgr.service.PSMavenRepoService;
import net.ibizsys.pscore.srv.paasmgr.service.PSPMSServerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSRTWXAccountService;
import net.ibizsys.pscore.srv.paasmgr.service.PSSVNInstRepoService;
import net.ibizsys.pscore.srv.paasmgr.service.PSStudioPluginService;
import net.ibizsys.pscore.srv.paasmgr.service.PSStudioServerGrpService;
import net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService;
import net.ibizsys.pscore.srv.paasmgr.service.PSSvrProviderService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevCenterBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevCenterBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DCAPIFLAG = "DCAPIFLAG";
    public static final String FIELD_DCAPITOKEN = "DCAPITOKEN";
    public static final String FIELD_DCLEVEL = "DCLEVEL";
    public static final String FIELD_DCROWKEY = "DCROWKEY";
    public static final String FIELD_DCTAG = "DCTAG";
    public static final String FIELD_DCTAG2 = "DCTAG2";
    public static final String FIELD_DCTAG3 = "DCTAG3";
    public static final String FIELD_DCTAG4 = "DCTAG4";
    public static final String FIELD_DCTYPE = "DCTYPE";
    public static final String FIELD_DOMAINNAME = "DOMAINNAME";
    public static final String FIELD_ENABLEDEPLOYCENTER = "ENABLEDEPLOYCENTER";
    public static final String FIELD_ENABLEWORKSPACE = "ENABLEWORKSPACE";
    public static final String FIELD_ENABLEWSSERVER = "ENABLEWSSERVER";
    public static final String FIELD_ENTITYCNT = "ENTITYCNT";
    public static final String FIELD_EXPERIENCE = "EXPERIENCE";
    public static final String FIELD_EXPIREDTIME = "EXPIREDTIME";
    public static final String FIELD_FULLDOMAINNAME = "FULLDOMAINNAME";
    public static final String FIELD_IPADDRS = "IPADDRS";
    public static final String FIELD_LICINFO = "LICINFO";
    public static final String FIELD_LICKEY = "LICKEY";
    public static final String FIELD_LINKIBIZ5FLAG = "LINKIBIZ5FLAG";
    public static final String FIELD_MAXACTIVEUSERCNT = "MAXACTIVEUSERCNT";
    public static final String FIELD_MAXENTITYCNT = "MAXENTITYCNT";
    public static final String FIELD_MAXSYSCNT = "MAXSYSCNT";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MOBCERTCHGTIME = "MOBCERTCHGTIME";
    public static final String FIELD_MOBTDCHGTIME = "MOBTDCHGTIME";
    public static final String FIELD_PSDCINSTID = "PSDCINSTID";
    public static final String FIELD_PSDCINSTNAME = "PSDCINSTNAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSPMSSERVERID = "PSPMSSERVERID";
    public static final String FIELD_PSPMSSERVERNAME = "PSPMSSERVERNAME";
    public static final String FIELD_PSRTWXACCOUNTID = "PSRTWXACCOUNTID";
    public static final String FIELD_PSRTWXACCOUNTNAME = "PSRTWXACCOUNTNAME";
    public static final String FIELD_PSSTUDIOSERVERGRPID = "PSSTUDIOSERVERGRPID";
    public static final String FIELD_PSSTUDIOSERVERGRPNAME = "PSSTUDIOSERVERGRPNAME";
    public static final String FIELD_PSSVNINSTREPOID = "PSSVNINSTREPOID";
    public static final String FIELD_PSSVNINSTREPONAME = "PSSVNINSTREPONAME";
    public static final String FIELD_PSSVRDOMAINID = "PSSVRDOMAINID";
    public static final String FIELD_PSSVRDOMAINNAME = "PSSVRDOMAINNAME";
    public static final String FIELD_PSSVRPROVIDERID = "PSSVRPROVIDERID";
    public static final String FIELD_PSSVRPROVIDERNAME = "PSSVRPROVIDERNAME";
    public static final String FIELD_ROBOTCHGTIME = "ROBOTCHGTIME";
    public static final String FIELD_ROPSSVNINSTREPOID = "ROPSSVNINSTREPOID";
    public static final String FIELD_ROPSSVNINSTREPONAME = "ROPSSVNINSTREPONAME";
    public static final String FIELD_SPFLAG = "SPFLAG";
    public static final String FIELD_STUDIOTAG = "STUDIOTAG";
    public static final String FIELD_STUDIOTAG2 = "STUDIOTAG2";
    public static final String FIELD_STUDIOVER = "STUDIOVER";
    public static final String FIELD_SYSAPIFLAG = "SYSAPIFLAG";
    public static final String FIELD_SYSCNT = "SYSCNT";
    public static final String FIELD_SYSSN = "SYSSN";
    public static final String FIELD_TOTALENERGY = "TOTALENERGY";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_V6PSSVNINSTREPOID = "V6PSSVNINSTREPOID";
    public static final String FIELD_V6PSSVNINSTREPONAME = "V6PSSVNINSTREPONAME";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_WEBFOLDER = "WEBFOLDER";
    public static final String FIELD_WEBSITEURL = "WEBSITEURL";
    public static final String FIELD_WXDEPTID = "WXDEPTID";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DCAPIFLAG = 2;
    private static final int INDEX_DCAPITOKEN = 3;
    private static final int INDEX_DCLEVEL = 4;
    private static final int INDEX_DCROWKEY = 5;
    private static final int INDEX_DCTAG = 6;
    private static final int INDEX_DCTAG2 = 7;
    private static final int INDEX_DCTAG3 = 8;
    private static final int INDEX_DCTAG4 = 9;
    private static final int INDEX_DCTYPE = 10;
    private static final int INDEX_DOMAINNAME = 11;
    private static final int INDEX_ENABLEDEPLOYCENTER = 12;
    private static final int INDEX_ENABLEWORKSPACE = 13;
    private static final int INDEX_ENABLEWSSERVER = 14;
    private static final int INDEX_ENTITYCNT = 15;
    private static final int INDEX_EXPERIENCE = 16;
    private static final int INDEX_EXPIREDTIME = 17;
    private static final int INDEX_FULLDOMAINNAME = 18;
    private static final int INDEX_IPADDRS = 19;
    private static final int INDEX_LICINFO = 20;
    private static final int INDEX_LICKEY = 21;
    private static final int INDEX_LINKIBIZ5FLAG = 22;
    private static final int INDEX_MAXACTIVEUSERCNT = 23;
    private static final int INDEX_MAXENTITYCNT = 24;
    private static final int INDEX_MAXSYSCNT = 25;
    private static final int INDEX_MEMO = 26;
    private static final int INDEX_MOBCERTCHGTIME = 27;
    private static final int INDEX_MOBTDCHGTIME = 28;
    private static final int INDEX_PSDCINSTID = 29;
    private static final int INDEX_PSDCINSTNAME = 30;
    private static final int INDEX_PSDEVCENTERID = 31;
    private static final int INDEX_PSDEVCENTERNAME = 32;
    private static final int INDEX_PSPMSSERVERID = 33;
    private static final int INDEX_PSPMSSERVERNAME = 34;
    private static final int INDEX_PSRTWXACCOUNTID = 35;
    private static final int INDEX_PSRTWXACCOUNTNAME = 36;
    private static final int INDEX_PSSTUDIOSERVERGRPID = 37;
    private static final int INDEX_PSSTUDIOSERVERGRPNAME = 38;
    private static final int INDEX_PSSVNINSTREPOID = 39;
    private static final int INDEX_PSSVNINSTREPONAME = 40;
    private static final int INDEX_PSSVRDOMAINID = 41;
    private static final int INDEX_PSSVRDOMAINNAME = 42;
    private static final int INDEX_PSSVRPROVIDERID = 43;
    private static final int INDEX_PSSVRPROVIDERNAME = 44;
    private static final int INDEX_ROBOTCHGTIME = 45;
    private static final int INDEX_ROPSSVNINSTREPOID = 46;
    private static final int INDEX_ROPSSVNINSTREPONAME = 47;
    private static final int INDEX_SPFLAG = 48;
    private static final int INDEX_STUDIOTAG = 49;
    private static final int INDEX_STUDIOTAG2 = 50;
    private static final int INDEX_STUDIOVER = 51;
    private static final int INDEX_SYSAPIFLAG = 52;
    private static final int INDEX_SYSCNT = 53;
    private static final int INDEX_SYSSN = 54;
    private static final int INDEX_TOTALENERGY = 55;
    private static final int INDEX_UPDATEDATE = 56;
    private static final int INDEX_UPDATEMAN = 57;
    private static final int INDEX_V6PSSVNINSTREPOID = 58;
    private static final int INDEX_V6PSSVNINSTREPONAME = 59;
    private static final int INDEX_VALIDFLAG = 60;
    private static final int INDEX_WEBFOLDER = 61;
    private static final int INDEX_WEBSITEURL = 62;
    private static final int INDEX_WXDEPTID = 63;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevCenterBase proxyPSDevCenterBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dcapiflagDirtyFlag = false;
    private boolean dcapitokenDirtyFlag = false;
    private boolean dclevelDirtyFlag = false;
    private boolean dcrowkeyDirtyFlag = false;
    private boolean dctagDirtyFlag = false;
    private boolean dctag2DirtyFlag = false;
    private boolean dctag3DirtyFlag = false;
    private boolean dctag4DirtyFlag = false;
    private boolean dctypeDirtyFlag = false;
    private boolean domainnameDirtyFlag = false;
    private boolean enabledeploycenterDirtyFlag = false;
    private boolean enableworkspaceDirtyFlag = false;
    private boolean enablewsserverDirtyFlag = false;
    private boolean entitycntDirtyFlag = false;
    private boolean experienceDirtyFlag = false;
    private boolean expiredtimeDirtyFlag = false;
    private boolean fulldomainnameDirtyFlag = false;
    private boolean ipaddrsDirtyFlag = false;
    private boolean licinfoDirtyFlag = false;
    private boolean lickeyDirtyFlag = false;
    private boolean linkibiz5flagDirtyFlag = false;
    private boolean maxactiveusercntDirtyFlag = false;
    private boolean maxentitycntDirtyFlag = false;
    private boolean maxsyscntDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean mobcertchgtimeDirtyFlag = false;
    private boolean mobtdchgtimeDirtyFlag = false;
    private boolean psdcinstidDirtyFlag = false;
    private boolean psdcinstnameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean pspmsserveridDirtyFlag = false;
    private boolean pspmsservernameDirtyFlag = false;
    private boolean psrtwxaccountidDirtyFlag = false;
    private boolean psrtwxaccountnameDirtyFlag = false;
    private boolean psstudioservergrpidDirtyFlag = false;
    private boolean psstudioservergrpnameDirtyFlag = false;
    private boolean pssvninstrepoidDirtyFlag = false;
    private boolean pssvninstreponameDirtyFlag = false;
    private boolean pssvrdomainidDirtyFlag = false;
    private boolean pssvrdomainnameDirtyFlag = false;
    private boolean pssvrprovideridDirtyFlag = false;
    private boolean pssvrprovidernameDirtyFlag = false;
    private boolean robotchgtimeDirtyFlag = false;
    private boolean ropssvninstrepoidDirtyFlag = false;
    private boolean ropssvninstreponameDirtyFlag = false;
    private boolean spflagDirtyFlag = false;
    private boolean studiotagDirtyFlag = false;
    private boolean studiotag2DirtyFlag = false;
    private boolean studioverDirtyFlag = false;
    private boolean sysapiflagDirtyFlag = false;
    private boolean syscntDirtyFlag = false;
    private boolean syssnDirtyFlag = false;
    private boolean totalenergyDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean v6pssvninstrepoidDirtyFlag = false;
    private boolean v6pssvninstreponameDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean webfolderDirtyFlag = false;
    private boolean websiteurlDirtyFlag = false;
    private boolean wxdeptidDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dcapiflag")
    private Integer dcapiflag;
    @Column(name="dcapitoken")
    private String dcapitoken;
    @Column(name="dclevel")
    private Integer dclevel;
    @Column(name="dcrowkey")
    private String dcrowkey;
    @Column(name="dctag")
    private String dctag;
    @Column(name="dctag2")
    private String dctag2;
    @Column(name="dctag3")
    private String dctag3;
    @Column(name="dctag4")
    private String dctag4;
    @Column(name="dctype")
    private String dctype;
    @Column(name="domainname")
    private String domainname;
    @Column(name="enabledeploycenter")
    private Integer enabledeploycenter;
    @Column(name="enableworkspace")
    private Integer enableworkspace;
    @Column(name="enablewsserver")
    private Integer enablewsserver;
    @Column(name="entitycnt")
    private Integer entitycnt;
    @Column(name="experience")
    private Integer experience;
    @Column(name="expiredtime")
    private Timestamp expiredtime;
    @Column(name="fulldomainname")
    private String fulldomainname;
    @Column(name="ipaddrs")
    private String ipaddrs;
    @Column(name="licinfo")
    private String licinfo;
    @Column(name="lickey")
    private String lickey;
    @Column(name="linkibiz5flag")
    private Integer linkibiz5flag;
    @Column(name="maxactiveusercnt")
    private Integer maxactiveusercnt;
    @Column(name="maxentitycnt")
    private Integer maxentitycnt;
    @Column(name="maxsyscnt")
    private Integer maxsyscnt;
    @Column(name="memo")
    private String memo;
    @Column(name="mobcertchgtime")
    private Timestamp mobcertchgtime;
    @Column(name="mobtdchgtime")
    private Timestamp mobtdchgtime;
    @Column(name="psdcinstid")
    private String psdcinstid;
    @Column(name="psdcinstname")
    private String psdcinstname;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="pspmsserverid")
    private String pspmsserverid;
    @Column(name="pspmsservername")
    private String pspmsservername;
    @Column(name="psrtwxaccountid")
    private String psrtwxaccountid;
    @Column(name="psrtwxaccountname")
    private String psrtwxaccountname;
    @Column(name="psstudioservergrpid")
    private String psstudioservergrpid;
    @Column(name="psstudioservergrpname")
    private String psstudioservergrpname;
    @Column(name="pssvninstrepoid")
    private String pssvninstrepoid;
    @Column(name="pssvninstreponame")
    private String pssvninstreponame;
    @Column(name="pssvrdomainid")
    private String pssvrdomainid;
    @Column(name="pssvrdomainname")
    private String pssvrdomainname;
    @Column(name="pssvrproviderid")
    private String pssvrproviderid;
    @Column(name="pssvrprovidername")
    private String pssvrprovidername;
    @Column(name="robotchgtime")
    private Timestamp robotchgtime;
    @Column(name="ropssvninstrepoid")
    private String ropssvninstrepoid;
    @Column(name="ropssvninstreponame")
    private String ropssvninstreponame;
    @Column(name="spflag")
    private Integer spflag;
    @Column(name="studiotag")
    private String studiotag;
    @Column(name="studiotag2")
    private String studiotag2;
    @Column(name="studiover")
    private String studiover;
    @Column(name="sysapiflag")
    private Integer sysapiflag;
    @Column(name="syscnt")
    private Integer syscnt;
    @Column(name="syssn")
    private Integer syssn;
    @Column(name="totalenergy")
    private Integer totalenergy;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="v6pssvninstrepoid")
    private String v6pssvninstrepoid;
    @Column(name="v6pssvninstreponame")
    private String v6pssvninstreponame;
    @Column(name="validflag")
    private Integer validflag;
    @Column(name="webfolder")
    private String webfolder;
    @Column(name="websiteurl")
    private String websiteurl;
    @Column(name="wxdeptid")
    private Integer wxdeptid;
    private Integer objPSDCInstLock = new Integer(1);
    private PSDCInst psdcinst = null;
    private Integer objPSPMSServerLock = new Integer(1);
    private PSPMSServer pspmsserver = null;
    private Integer objPSRTWXAccountLock = new Integer(1);
    private PSRTWXAccount psrtwxaccount = null;
    private Integer objPSStudioServerGrpLock = new Integer(1);
    private PSStudioServerGrp psstudioservergrp = null;
    private Integer objPSSvnInstRepoLock = new Integer(1);
    private PSSVNInstRepo pssvninstrepo = null;
    private Integer objROPSSvnInstRepoLock = new Integer(1);
    private PSSVNInstRepo ropssvninstrepo = null;
    private Integer objV6PSSvnInstRepoLock = new Integer(1);
    private PSSVNInstRepo v6pssvninstrepo = null;
    private Integer objPSSvrDomainLock = new Integer(1);
    private PSSvrDomain pssvrdomain = null;
    private Integer objPSSvrProviderLock = new Integer(1);
    private PSSvrProvider pssvrprovider = null;
    private Integer objPSCredentialsLock = new Integer(1);
    private ArrayList<PSCredential> pscredentials = null;
    private Integer objPSDCClustersLock = new Integer(1);
    private ArrayList<PSDCCluster> psdcclusters = null;
    private Integer objPSDCCodeSnippetsLock = new Integer(1);
    private ArrayList<PSDCCodeSnippet> psdccodesnippets = null;
    private Integer objPSDCContainerSpecsLock = new Integer(1);
    private ArrayList<PSDCContainerSpec> psdccontainerspecs = null;
    private Integer objPSDCDeployServerLock = new Integer(1);
    private ArrayList<PSDCDeployServer> psdcdeployserver = null;
    private Integer objPSDCDETemplsLock = new Integer(1);
    private ArrayList<PSDCDETempl> psdcdetempls = null;
    private Integer objPSDCFilesLock = new Integer(1);
    private ArrayList<PSDCFile> psdcfiles = null;
    private Integer objPSDCModelTemplsLock = new Integer(1);
    private ArrayList<PSDCModelTempl> psdcmodeltempls = null;
    private Integer objPSDCMSPlatformsLock = new Integer(1);
    private ArrayList<PSDCMSPlatform> psdcmsplatforms = null;
    private Integer objPSDCRegistryReposLock = new Integer(1);
    private ArrayList<PSDCRegistryRepo> psdcregistryrepos = null;
    private Integer objPSDCRobotAbilitiesLock = new Integer(1);
    private ArrayList<PSDCRobotAbility> psdcrobotabilities = null;
    private Integer objPSDCSearchEngineInstsLock = new Integer(1);
    private ArrayList<PSDCSearchEngineInst> psdcsearchengineinsts = null;
    private Integer objPSDCSyncDatasLock = new Integer(1);
    private ArrayList<PSDCSyncData> psdcsyncdatas = null;
    private Integer objPSDCWFEngineInstsLock = new Integer(1);
    private ArrayList<PSDCWFEngineInst> psdcwfengineinsts = null;
    private Integer objPSDCWorkshopServersLock = new Integer(1);
    private ArrayList<PSDCWorkshopServer> psdcworkshopservers = null;
    private Integer objPSMavenReposLock = new Integer(1);
    private ArrayList<PSMavenRepo> psmavenrepos = null;
    private Integer objPSStudioPluginsLock = new Integer(1);
    private ArrayList<PSStudioPlugin> psstudioplugins = null;

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

    public void setDCAPIFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDCAPIFlag(n);
            return;
        }
        this.dcapiflag = n;
        this.dcapiflagDirtyFlag = true;
    }

    public Integer getDCAPIFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDCAPIFlag();
        }
        return this.dcapiflag;
    }

    public boolean isDCAPIFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDCAPIFlagDirty();
        }
        return this.dcapiflagDirtyFlag;
    }

    public void resetDCAPIFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDCAPIFlag();
            return;
        }
        this.dcapiflagDirtyFlag = false;
        this.dcapiflag = null;
    }

    public void setDCAPIToken(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDCAPIToken(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dcapitoken = string;
        this.dcapitokenDirtyFlag = true;
    }

    public String getDCAPIToken() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDCAPIToken();
        }
        return this.dcapitoken;
    }

    public boolean isDCAPITokenDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDCAPITokenDirty();
        }
        return this.dcapitokenDirtyFlag;
    }

    public void resetDCAPIToken() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDCAPIToken();
            return;
        }
        this.dcapitokenDirtyFlag = false;
        this.dcapitoken = null;
    }

    public void setDCLevel(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDCLevel(n);
            return;
        }
        this.dclevel = n;
        this.dclevelDirtyFlag = true;
    }

    public Integer getDCLevel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDCLevel();
        }
        return this.dclevel;
    }

    public boolean isDCLevelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDCLevelDirty();
        }
        return this.dclevelDirtyFlag;
    }

    public void resetDCLevel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDCLevel();
            return;
        }
        this.dclevelDirtyFlag = false;
        this.dclevel = null;
    }

    public void setDCRowKey(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDCRowKey(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dcrowkey = string;
        this.dcrowkeyDirtyFlag = true;
    }

    public String getDCRowKey() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDCRowKey();
        }
        return this.dcrowkey;
    }

    public boolean isDCRowKeyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDCRowKeyDirty();
        }
        return this.dcrowkeyDirtyFlag;
    }

    public void resetDCRowKey() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDCRowKey();
            return;
        }
        this.dcrowkeyDirtyFlag = false;
        this.dcrowkey = null;
    }

    public void setDCTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDCTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dctag = string;
        this.dctagDirtyFlag = true;
    }

    public String getDCTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDCTag();
        }
        return this.dctag;
    }

    public boolean isDCTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDCTagDirty();
        }
        return this.dctagDirtyFlag;
    }

    public void resetDCTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDCTag();
            return;
        }
        this.dctagDirtyFlag = false;
        this.dctag = null;
    }

    public void setDCTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDCTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dctag2 = string;
        this.dctag2DirtyFlag = true;
    }

    public String getDCTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDCTag2();
        }
        return this.dctag2;
    }

    public boolean isDCTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDCTag2Dirty();
        }
        return this.dctag2DirtyFlag;
    }

    public void resetDCTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDCTag2();
            return;
        }
        this.dctag2DirtyFlag = false;
        this.dctag2 = null;
    }

    public void setDCTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDCTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dctag3 = string;
        this.dctag3DirtyFlag = true;
    }

    public String getDCTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDCTag3();
        }
        return this.dctag3;
    }

    public boolean isDCTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDCTag3Dirty();
        }
        return this.dctag3DirtyFlag;
    }

    public void resetDCTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDCTag3();
            return;
        }
        this.dctag3DirtyFlag = false;
        this.dctag3 = null;
    }

    public void setDCTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDCTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dctag4 = string;
        this.dctag4DirtyFlag = true;
    }

    public String getDCTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDCTag4();
        }
        return this.dctag4;
    }

    public boolean isDCTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDCTag4Dirty();
        }
        return this.dctag4DirtyFlag;
    }

    public void resetDCTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDCTag4();
            return;
        }
        this.dctag4DirtyFlag = false;
        this.dctag4 = null;
    }

    public void setDCType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDCType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dctype = string;
        this.dctypeDirtyFlag = true;
    }

    public String getDCType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDCType();
        }
        return this.dctype;
    }

    public boolean isDCTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDCTypeDirty();
        }
        return this.dctypeDirtyFlag;
    }

    public void resetDCType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDCType();
            return;
        }
        this.dctypeDirtyFlag = false;
        this.dctype = null;
    }

    public void setDomainName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDomainName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        if (string != null) {
            string = string.toLowerCase();
        }
        this.domainname = string;
        this.domainnameDirtyFlag = true;
    }

    public String getDomainName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDomainName();
        }
        return this.domainname;
    }

    public boolean isDomainNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDomainNameDirty();
        }
        return this.domainnameDirtyFlag;
    }

    public void resetDomainName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDomainName();
            return;
        }
        this.domainnameDirtyFlag = false;
        this.domainname = null;
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

    public void setEnableWorkspace(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableWorkspace(n);
            return;
        }
        this.enableworkspace = n;
        this.enableworkspaceDirtyFlag = true;
    }

    public Integer getEnableWorkspace() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableWorkspace();
        }
        return this.enableworkspace;
    }

    public boolean isEnableWorkspaceDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableWorkspaceDirty();
        }
        return this.enableworkspaceDirtyFlag;
    }

    public void resetEnableWorkspace() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableWorkspace();
            return;
        }
        this.enableworkspaceDirtyFlag = false;
        this.enableworkspace = null;
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

    public void setExperience(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExperience(n);
            return;
        }
        this.experience = n;
        this.experienceDirtyFlag = true;
    }

    public Integer getExperience() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExperience();
        }
        return this.experience;
    }

    public boolean isExperienceDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExperienceDirty();
        }
        return this.experienceDirtyFlag;
    }

    public void resetExperience() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExperience();
            return;
        }
        this.experienceDirtyFlag = false;
        this.experience = null;
    }

    public void setExpiredTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExpiredTime(timestamp);
            return;
        }
        this.expiredtime = timestamp;
        this.expiredtimeDirtyFlag = true;
    }

    public Timestamp getExpiredTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExpiredTime();
        }
        return this.expiredtime;
    }

    public boolean isExpiredTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExpiredTimeDirty();
        }
        return this.expiredtimeDirtyFlag;
    }

    public void resetExpiredTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExpiredTime();
            return;
        }
        this.expiredtimeDirtyFlag = false;
        this.expiredtime = null;
    }

    public void setFullDomainName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFullDomainName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.fulldomainname = string;
        this.fulldomainnameDirtyFlag = true;
    }

    public String getFullDomainName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFullDomainName();
        }
        return this.fulldomainname;
    }

    public boolean isFullDomainNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFullDomainNameDirty();
        }
        return this.fulldomainnameDirtyFlag;
    }

    public void resetFullDomainName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFullDomainName();
            return;
        }
        this.fulldomainnameDirtyFlag = false;
        this.fulldomainname = null;
    }

    public void setIPAddrs(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIPAddrs(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ipaddrs = string;
        this.ipaddrsDirtyFlag = true;
    }

    public String getIPAddrs() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIPAddrs();
        }
        return this.ipaddrs;
    }

    public boolean isIPAddrsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIPAddrsDirty();
        }
        return this.ipaddrsDirtyFlag;
    }

    public void resetIPAddrs() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIPAddrs();
            return;
        }
        this.ipaddrsDirtyFlag = false;
        this.ipaddrs = null;
    }

    public void setLicInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLicInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.licinfo = string;
        this.licinfoDirtyFlag = true;
    }

    public String getLicInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLicInfo();
        }
        return this.licinfo;
    }

    public boolean isLicInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLicInfoDirty();
        }
        return this.licinfoDirtyFlag;
    }

    public void resetLicInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLicInfo();
            return;
        }
        this.licinfoDirtyFlag = false;
        this.licinfo = null;
    }

    public void setLicKey(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLicKey(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.lickey = string;
        this.lickeyDirtyFlag = true;
    }

    public String getLicKey() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLicKey();
        }
        return this.lickey;
    }

    public boolean isLicKeyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLicKeyDirty();
        }
        return this.lickeyDirtyFlag;
    }

    public void resetLicKey() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLicKey();
            return;
        }
        this.lickeyDirtyFlag = false;
        this.lickey = null;
    }

    public void setLinkIBiz5Flag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLinkIBiz5Flag(n);
            return;
        }
        this.linkibiz5flag = n;
        this.linkibiz5flagDirtyFlag = true;
    }

    public Integer getLinkIBiz5Flag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLinkIBiz5Flag();
        }
        return this.linkibiz5flag;
    }

    public boolean isLinkIBiz5FlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLinkIBiz5FlagDirty();
        }
        return this.linkibiz5flagDirtyFlag;
    }

    public void resetLinkIBiz5Flag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLinkIBiz5Flag();
            return;
        }
        this.linkibiz5flagDirtyFlag = false;
        this.linkibiz5flag = null;
    }

    public void setMaxActiveUserCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxActiveUserCnt(n);
            return;
        }
        this.maxactiveusercnt = n;
        this.maxactiveusercntDirtyFlag = true;
    }

    public Integer getMaxActiveUserCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxActiveUserCnt();
        }
        return this.maxactiveusercnt;
    }

    public boolean isMaxActiveUserCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxActiveUserCntDirty();
        }
        return this.maxactiveusercntDirtyFlag;
    }

    public void resetMaxActiveUserCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxActiveUserCnt();
            return;
        }
        this.maxactiveusercntDirtyFlag = false;
        this.maxactiveusercnt = null;
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

    public void setMaxSysCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxSysCnt(n);
            return;
        }
        this.maxsyscnt = n;
        this.maxsyscntDirtyFlag = true;
    }

    public Integer getMaxSysCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxSysCnt();
        }
        return this.maxsyscnt;
    }

    public boolean isMaxSysCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxSysCntDirty();
        }
        return this.maxsyscntDirtyFlag;
    }

    public void resetMaxSysCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxSysCnt();
            return;
        }
        this.maxsyscntDirtyFlag = false;
        this.maxsyscnt = null;
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

    public void setMobCertChgTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobCertChgTime(timestamp);
            return;
        }
        this.mobcertchgtime = timestamp;
        this.mobcertchgtimeDirtyFlag = true;
    }

    public Timestamp getMobCertChgTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobCertChgTime();
        }
        return this.mobcertchgtime;
    }

    public boolean isMobCertChgTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobCertChgTimeDirty();
        }
        return this.mobcertchgtimeDirtyFlag;
    }

    public void resetMobCertChgTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobCertChgTime();
            return;
        }
        this.mobcertchgtimeDirtyFlag = false;
        this.mobcertchgtime = null;
    }

    public void setMobTDChgTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobTDChgTime(timestamp);
            return;
        }
        this.mobtdchgtime = timestamp;
        this.mobtdchgtimeDirtyFlag = true;
    }

    public Timestamp getMobTDChgTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobTDChgTime();
        }
        return this.mobtdchgtime;
    }

    public boolean isMobTDChgTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobTDChgTimeDirty();
        }
        return this.mobtdchgtimeDirtyFlag;
    }

    public void resetMobTDChgTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobTDChgTime();
            return;
        }
        this.mobtdchgtimeDirtyFlag = false;
        this.mobtdchgtime = null;
    }

    public void setPSDCInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcinstid = string;
        this.psdcinstidDirtyFlag = true;
    }

    public String getPSDCInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCInstId();
        }
        return this.psdcinstid;
    }

    public boolean isPSDCInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCInstIdDirty();
        }
        return this.psdcinstidDirtyFlag;
    }

    public void resetPSDCInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCInstId();
            return;
        }
        this.psdcinstidDirtyFlag = false;
        this.psdcinstid = null;
    }

    public void setPSDCInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcinstname = string;
        this.psdcinstnameDirtyFlag = true;
    }

    public String getPSDCInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCInstName();
        }
        return this.psdcinstname;
    }

    public boolean isPSDCInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCInstNameDirty();
        }
        return this.psdcinstnameDirtyFlag;
    }

    public void resetPSDCInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCInstName();
            return;
        }
        this.psdcinstnameDirtyFlag = false;
        this.psdcinstname = null;
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

    public void setPSPMSServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPMSServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspmsserverid = string;
        this.pspmsserveridDirtyFlag = true;
    }

    public String getPSPMSServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPMSServerId();
        }
        return this.pspmsserverid;
    }

    public boolean isPSPMSServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPMSServerIdDirty();
        }
        return this.pspmsserveridDirtyFlag;
    }

    public void resetPSPMSServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPMSServerId();
            return;
        }
        this.pspmsserveridDirtyFlag = false;
        this.pspmsserverid = null;
    }

    public void setPSPMSServerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPMSServerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspmsservername = string;
        this.pspmsservernameDirtyFlag = true;
    }

    public String getPSPMSServerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPMSServerName();
        }
        return this.pspmsservername;
    }

    public boolean isPSPMSServerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPMSServerNameDirty();
        }
        return this.pspmsservernameDirtyFlag;
    }

    public void resetPSPMSServerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPMSServerName();
            return;
        }
        this.pspmsservernameDirtyFlag = false;
        this.pspmsservername = null;
    }

    public void setPSRTWXAccountId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSRTWXAccountId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psrtwxaccountid = string;
        this.psrtwxaccountidDirtyFlag = true;
    }

    public String getPSRTWXAccountId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSRTWXAccountId();
        }
        return this.psrtwxaccountid;
    }

    public boolean isPSRTWXAccountIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSRTWXAccountIdDirty();
        }
        return this.psrtwxaccountidDirtyFlag;
    }

    public void resetPSRTWXAccountId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSRTWXAccountId();
            return;
        }
        this.psrtwxaccountidDirtyFlag = false;
        this.psrtwxaccountid = null;
    }

    public void setPSRTWXAccountName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSRTWXAccountName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psrtwxaccountname = string;
        this.psrtwxaccountnameDirtyFlag = true;
    }

    public String getPSRTWXAccountName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSRTWXAccountName();
        }
        return this.psrtwxaccountname;
    }

    public boolean isPSRTWXAccountNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSRTWXAccountNameDirty();
        }
        return this.psrtwxaccountnameDirtyFlag;
    }

    public void resetPSRTWXAccountName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSRTWXAccountName();
            return;
        }
        this.psrtwxaccountnameDirtyFlag = false;
        this.psrtwxaccountname = null;
    }

    public void setPSStudioServerGrpId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSStudioServerGrpId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psstudioservergrpid = string;
        this.psstudioservergrpidDirtyFlag = true;
    }

    public String getPSStudioServerGrpId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSStudioServerGrpId();
        }
        return this.psstudioservergrpid;
    }

    public boolean isPSStudioServerGrpIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSStudioServerGrpIdDirty();
        }
        return this.psstudioservergrpidDirtyFlag;
    }

    public void resetPSStudioServerGrpId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSStudioServerGrpId();
            return;
        }
        this.psstudioservergrpidDirtyFlag = false;
        this.psstudioservergrpid = null;
    }

    public void setPSStudioServerGrpName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSStudioServerGrpName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psstudioservergrpname = string;
        this.psstudioservergrpnameDirtyFlag = true;
    }

    public String getPSStudioServerGrpName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSStudioServerGrpName();
        }
        return this.psstudioservergrpname;
    }

    public boolean isPSStudioServerGrpNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSStudioServerGrpNameDirty();
        }
        return this.psstudioservergrpnameDirtyFlag;
    }

    public void resetPSStudioServerGrpName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSStudioServerGrpName();
            return;
        }
        this.psstudioservergrpnameDirtyFlag = false;
        this.psstudioservergrpname = null;
    }

    public void setPSSvnInstRepoId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSvnInstRepoId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssvninstrepoid = string;
        this.pssvninstrepoidDirtyFlag = true;
    }

    public String getPSSvnInstRepoId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSvnInstRepoId();
        }
        return this.pssvninstrepoid;
    }

    public boolean isPSSvnInstRepoIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSvnInstRepoIdDirty();
        }
        return this.pssvninstrepoidDirtyFlag;
    }

    public void resetPSSvnInstRepoId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSvnInstRepoId();
            return;
        }
        this.pssvninstrepoidDirtyFlag = false;
        this.pssvninstrepoid = null;
    }

    public void setPSSvnInstRepoName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSvnInstRepoName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssvninstreponame = string;
        this.pssvninstreponameDirtyFlag = true;
    }

    public String getPSSvnInstRepoName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSvnInstRepoName();
        }
        return this.pssvninstreponame;
    }

    public boolean isPSSvnInstRepoNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSvnInstRepoNameDirty();
        }
        return this.pssvninstreponameDirtyFlag;
    }

    public void resetPSSvnInstRepoName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSvnInstRepoName();
            return;
        }
        this.pssvninstreponameDirtyFlag = false;
        this.pssvninstreponame = null;
    }

    public void setPSSvrDomainId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSvrDomainId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssvrdomainid = string;
        this.pssvrdomainidDirtyFlag = true;
    }

    public String getPSSvrDomainId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSvrDomainId();
        }
        return this.pssvrdomainid;
    }

    public boolean isPSSvrDomainIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSvrDomainIdDirty();
        }
        return this.pssvrdomainidDirtyFlag;
    }

    public void resetPSSvrDomainId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSvrDomainId();
            return;
        }
        this.pssvrdomainidDirtyFlag = false;
        this.pssvrdomainid = null;
    }

    public void setPSSvrDomainName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSvrDomainName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssvrdomainname = string;
        this.pssvrdomainnameDirtyFlag = true;
    }

    public String getPSSvrDomainName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSvrDomainName();
        }
        return this.pssvrdomainname;
    }

    public boolean isPSSvrDomainNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSvrDomainNameDirty();
        }
        return this.pssvrdomainnameDirtyFlag;
    }

    public void resetPSSvrDomainName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSvrDomainName();
            return;
        }
        this.pssvrdomainnameDirtyFlag = false;
        this.pssvrdomainname = null;
    }

    public void setPSSvrProviderId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSvrProviderId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssvrproviderid = string;
        this.pssvrprovideridDirtyFlag = true;
    }

    public String getPSSvrProviderId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSvrProviderId();
        }
        return this.pssvrproviderid;
    }

    public boolean isPSSvrProviderIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSvrProviderIdDirty();
        }
        return this.pssvrprovideridDirtyFlag;
    }

    public void resetPSSvrProviderId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSvrProviderId();
            return;
        }
        this.pssvrprovideridDirtyFlag = false;
        this.pssvrproviderid = null;
    }

    public void setPSSvrProviderName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSvrProviderName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssvrprovidername = string;
        this.pssvrprovidernameDirtyFlag = true;
    }

    public String getPSSvrProviderName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSvrProviderName();
        }
        return this.pssvrprovidername;
    }

    public boolean isPSSvrProviderNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSvrProviderNameDirty();
        }
        return this.pssvrprovidernameDirtyFlag;
    }

    public void resetPSSvrProviderName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSvrProviderName();
            return;
        }
        this.pssvrprovidernameDirtyFlag = false;
        this.pssvrprovidername = null;
    }

    public void setRobotChgTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRobotChgTime(timestamp);
            return;
        }
        this.robotchgtime = timestamp;
        this.robotchgtimeDirtyFlag = true;
    }

    public Timestamp getRobotChgTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRobotChgTime();
        }
        return this.robotchgtime;
    }

    public boolean isRobotChgTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRobotChgTimeDirty();
        }
        return this.robotchgtimeDirtyFlag;
    }

    public void resetRobotChgTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRobotChgTime();
            return;
        }
        this.robotchgtimeDirtyFlag = false;
        this.robotchgtime = null;
    }

    public void setROPSSvnInstRepoId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setROPSSvnInstRepoId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ropssvninstrepoid = string;
        this.ropssvninstrepoidDirtyFlag = true;
    }

    public String getROPSSvnInstRepoId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getROPSSvnInstRepoId();
        }
        return this.ropssvninstrepoid;
    }

    public boolean isROPSSvnInstRepoIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isROPSSvnInstRepoIdDirty();
        }
        return this.ropssvninstrepoidDirtyFlag;
    }

    public void resetROPSSvnInstRepoId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetROPSSvnInstRepoId();
            return;
        }
        this.ropssvninstrepoidDirtyFlag = false;
        this.ropssvninstrepoid = null;
    }

    public void setROPSSvnInstRepoName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setROPSSvnInstRepoName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ropssvninstreponame = string;
        this.ropssvninstreponameDirtyFlag = true;
    }

    public String getROPSSvnInstRepoName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getROPSSvnInstRepoName();
        }
        return this.ropssvninstreponame;
    }

    public boolean isROPSSvnInstRepoNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isROPSSvnInstRepoNameDirty();
        }
        return this.ropssvninstreponameDirtyFlag;
    }

    public void resetROPSSvnInstRepoName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetROPSSvnInstRepoName();
            return;
        }
        this.ropssvninstreponameDirtyFlag = false;
        this.ropssvninstreponame = null;
    }

    public void setSPFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSPFlag(n);
            return;
        }
        this.spflag = n;
        this.spflagDirtyFlag = true;
    }

    public Integer getSPFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSPFlag();
        }
        return this.spflag;
    }

    public boolean isSPFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSPFlagDirty();
        }
        return this.spflagDirtyFlag;
    }

    public void resetSPFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSPFlag();
            return;
        }
        this.spflagDirtyFlag = false;
        this.spflag = null;
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

    public void setSysAPIFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysAPIFlag(n);
            return;
        }
        this.sysapiflag = n;
        this.sysapiflagDirtyFlag = true;
    }

    public Integer getSysAPIFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysAPIFlag();
        }
        return this.sysapiflag;
    }

    public boolean isSysAPIFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysAPIFlagDirty();
        }
        return this.sysapiflagDirtyFlag;
    }

    public void resetSysAPIFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysAPIFlag();
            return;
        }
        this.sysapiflagDirtyFlag = false;
        this.sysapiflag = null;
    }

    public void setSysCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysCnt(n);
            return;
        }
        this.syscnt = n;
        this.syscntDirtyFlag = true;
    }

    public Integer getSysCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysCnt();
        }
        return this.syscnt;
    }

    public boolean isSysCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysCntDirty();
        }
        return this.syscntDirtyFlag;
    }

    public void resetSysCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysCnt();
            return;
        }
        this.syscntDirtyFlag = false;
        this.syscnt = null;
    }

    public void setSysSN(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysSN(n);
            return;
        }
        this.syssn = n;
        this.syssnDirtyFlag = true;
    }

    public Integer getSysSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysSN();
        }
        return this.syssn;
    }

    public boolean isSysSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysSNDirty();
        }
        return this.syssnDirtyFlag;
    }

    public void resetSysSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysSN();
            return;
        }
        this.syssnDirtyFlag = false;
        this.syssn = null;
    }

    public void setTotalEnergy(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTotalEnergy(n);
            return;
        }
        this.totalenergy = n;
        this.totalenergyDirtyFlag = true;
    }

    public Integer getTotalEnergy() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTotalEnergy();
        }
        return this.totalenergy;
    }

    public boolean isTotalEnergyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTotalEnergyDirty();
        }
        return this.totalenergyDirtyFlag;
    }

    public void resetTotalEnergy() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTotalEnergy();
            return;
        }
        this.totalenergyDirtyFlag = false;
        this.totalenergy = null;
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

    public void setV6PSSvnInstRepoId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setV6PSSvnInstRepoId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.v6pssvninstrepoid = string;
        this.v6pssvninstrepoidDirtyFlag = true;
    }

    public String getV6PSSvnInstRepoId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getV6PSSvnInstRepoId();
        }
        return this.v6pssvninstrepoid;
    }

    public boolean isV6PSSvnInstRepoIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isV6PSSvnInstRepoIdDirty();
        }
        return this.v6pssvninstrepoidDirtyFlag;
    }

    public void resetV6PSSvnInstRepoId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetV6PSSvnInstRepoId();
            return;
        }
        this.v6pssvninstrepoidDirtyFlag = false;
        this.v6pssvninstrepoid = null;
    }

    public void setV6PSSvnInstRepoName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setV6PSSvnInstRepoName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.v6pssvninstreponame = string;
        this.v6pssvninstreponameDirtyFlag = true;
    }

    public String getV6PSSvnInstRepoName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getV6PSSvnInstRepoName();
        }
        return this.v6pssvninstreponame;
    }

    public boolean isV6PSSvnInstRepoNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isV6PSSvnInstRepoNameDirty();
        }
        return this.v6pssvninstreponameDirtyFlag;
    }

    public void resetV6PSSvnInstRepoName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetV6PSSvnInstRepoName();
            return;
        }
        this.v6pssvninstreponameDirtyFlag = false;
        this.v6pssvninstreponame = null;
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

    public void setWebFolder(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWebFolder(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.webfolder = string;
        this.webfolderDirtyFlag = true;
    }

    public String getWebFolder() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWebFolder();
        }
        return this.webfolder;
    }

    public boolean isWebFolderDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWebFolderDirty();
        }
        return this.webfolderDirtyFlag;
    }

    public void resetWebFolder() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWebFolder();
            return;
        }
        this.webfolderDirtyFlag = false;
        this.webfolder = null;
    }

    public void setWebSiteUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWebSiteUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.websiteurl = string;
        this.websiteurlDirtyFlag = true;
    }

    public String getWebSiteUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWebSiteUrl();
        }
        return this.websiteurl;
    }

    public boolean isWebSiteUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWebSiteUrlDirty();
        }
        return this.websiteurlDirtyFlag;
    }

    public void resetWebSiteUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWebSiteUrl();
            return;
        }
        this.websiteurlDirtyFlag = false;
        this.websiteurl = null;
    }

    public void setWXDeptId(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWXDeptId(n);
            return;
        }
        this.wxdeptid = n;
        this.wxdeptidDirtyFlag = true;
    }

    public Integer getWXDeptId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWXDeptId();
        }
        return this.wxdeptid;
    }

    public boolean isWXDeptIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWXDeptIdDirty();
        }
        return this.wxdeptidDirtyFlag;
    }

    public void resetWXDeptId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWXDeptId();
            return;
        }
        this.wxdeptidDirtyFlag = false;
        this.wxdeptid = null;
    }

    protected void onReset() {
        PSDevCenterBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevCenterBase pSDevCenterBase) {
        pSDevCenterBase.resetCreateDate();
        pSDevCenterBase.resetCreateMan();
        pSDevCenterBase.resetDCAPIFlag();
        pSDevCenterBase.resetDCAPIToken();
        pSDevCenterBase.resetDCLevel();
        pSDevCenterBase.resetDCRowKey();
        pSDevCenterBase.resetDCTag();
        pSDevCenterBase.resetDCTag2();
        pSDevCenterBase.resetDCTag3();
        pSDevCenterBase.resetDCTag4();
        pSDevCenterBase.resetDCType();
        pSDevCenterBase.resetDomainName();
        pSDevCenterBase.resetEnableDeployCenter();
        pSDevCenterBase.resetEnableWorkspace();
        pSDevCenterBase.resetEnableWSServer();
        pSDevCenterBase.resetEntityCnt();
        pSDevCenterBase.resetExperience();
        pSDevCenterBase.resetExpiredTime();
        pSDevCenterBase.resetFullDomainName();
        pSDevCenterBase.resetIPAddrs();
        pSDevCenterBase.resetLicInfo();
        pSDevCenterBase.resetLicKey();
        pSDevCenterBase.resetLinkIBiz5Flag();
        pSDevCenterBase.resetMaxActiveUserCnt();
        pSDevCenterBase.resetMaxEntityCnt();
        pSDevCenterBase.resetMaxSysCnt();
        pSDevCenterBase.resetMemo();
        pSDevCenterBase.resetMobCertChgTime();
        pSDevCenterBase.resetMobTDChgTime();
        pSDevCenterBase.resetPSDCInstId();
        pSDevCenterBase.resetPSDCInstName();
        pSDevCenterBase.resetPSDevCenterId();
        pSDevCenterBase.resetPSDevCenterName();
        pSDevCenterBase.resetPSPMSServerId();
        pSDevCenterBase.resetPSPMSServerName();
        pSDevCenterBase.resetPSRTWXAccountId();
        pSDevCenterBase.resetPSRTWXAccountName();
        pSDevCenterBase.resetPSStudioServerGrpId();
        pSDevCenterBase.resetPSStudioServerGrpName();
        pSDevCenterBase.resetPSSvnInstRepoId();
        pSDevCenterBase.resetPSSvnInstRepoName();
        pSDevCenterBase.resetPSSvrDomainId();
        pSDevCenterBase.resetPSSvrDomainName();
        pSDevCenterBase.resetPSSvrProviderId();
        pSDevCenterBase.resetPSSvrProviderName();
        pSDevCenterBase.resetRobotChgTime();
        pSDevCenterBase.resetROPSSvnInstRepoId();
        pSDevCenterBase.resetROPSSvnInstRepoName();
        pSDevCenterBase.resetSPFlag();
        pSDevCenterBase.resetStudioTag();
        pSDevCenterBase.resetStudioTag2();
        pSDevCenterBase.resetStudioVer();
        pSDevCenterBase.resetSysAPIFlag();
        pSDevCenterBase.resetSysCnt();
        pSDevCenterBase.resetSysSN();
        pSDevCenterBase.resetTotalEnergy();
        pSDevCenterBase.resetUpdateDate();
        pSDevCenterBase.resetUpdateMan();
        pSDevCenterBase.resetV6PSSvnInstRepoId();
        pSDevCenterBase.resetV6PSSvnInstRepoName();
        pSDevCenterBase.resetValidFlag();
        pSDevCenterBase.resetWebFolder();
        pSDevCenterBase.resetWebSiteUrl();
        pSDevCenterBase.resetWXDeptId();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDCAPIFlagDirty()) {
            hashMap.put(FIELD_DCAPIFLAG, this.getDCAPIFlag());
        }
        if (!bl || this.isDCAPITokenDirty()) {
            hashMap.put(FIELD_DCAPITOKEN, this.getDCAPIToken());
        }
        if (!bl || this.isDCLevelDirty()) {
            hashMap.put(FIELD_DCLEVEL, this.getDCLevel());
        }
        if (!bl || this.isDCRowKeyDirty()) {
            hashMap.put(FIELD_DCROWKEY, this.getDCRowKey());
        }
        if (!bl || this.isDCTagDirty()) {
            hashMap.put(FIELD_DCTAG, this.getDCTag());
        }
        if (!bl || this.isDCTag2Dirty()) {
            hashMap.put(FIELD_DCTAG2, this.getDCTag2());
        }
        if (!bl || this.isDCTag3Dirty()) {
            hashMap.put(FIELD_DCTAG3, this.getDCTag3());
        }
        if (!bl || this.isDCTag4Dirty()) {
            hashMap.put(FIELD_DCTAG4, this.getDCTag4());
        }
        if (!bl || this.isDCTypeDirty()) {
            hashMap.put(FIELD_DCTYPE, this.getDCType());
        }
        if (!bl || this.isDomainNameDirty()) {
            hashMap.put(FIELD_DOMAINNAME, this.getDomainName());
        }
        if (!bl || this.isEnableDeployCenterDirty()) {
            hashMap.put(FIELD_ENABLEDEPLOYCENTER, this.getEnableDeployCenter());
        }
        if (!bl || this.isEnableWorkspaceDirty()) {
            hashMap.put(FIELD_ENABLEWORKSPACE, this.getEnableWorkspace());
        }
        if (!bl || this.isEnableWSServerDirty()) {
            hashMap.put(FIELD_ENABLEWSSERVER, this.getEnableWSServer());
        }
        if (!bl || this.isEntityCntDirty()) {
            hashMap.put(FIELD_ENTITYCNT, this.getEntityCnt());
        }
        if (!bl || this.isExperienceDirty()) {
            hashMap.put(FIELD_EXPERIENCE, this.getExperience());
        }
        if (!bl || this.isExpiredTimeDirty()) {
            hashMap.put(FIELD_EXPIREDTIME, this.getExpiredTime());
        }
        if (!bl || this.isFullDomainNameDirty()) {
            hashMap.put(FIELD_FULLDOMAINNAME, this.getFullDomainName());
        }
        if (!bl || this.isIPAddrsDirty()) {
            hashMap.put(FIELD_IPADDRS, this.getIPAddrs());
        }
        if (!bl || this.isLicInfoDirty()) {
            hashMap.put(FIELD_LICINFO, this.getLicInfo());
        }
        if (!bl || this.isLicKeyDirty()) {
            hashMap.put(FIELD_LICKEY, this.getLicKey());
        }
        if (!bl || this.isLinkIBiz5FlagDirty()) {
            hashMap.put(FIELD_LINKIBIZ5FLAG, this.getLinkIBiz5Flag());
        }
        if (!bl || this.isMaxActiveUserCntDirty()) {
            hashMap.put(FIELD_MAXACTIVEUSERCNT, this.getMaxActiveUserCnt());
        }
        if (!bl || this.isMaxEntityCntDirty()) {
            hashMap.put(FIELD_MAXENTITYCNT, this.getMaxEntityCnt());
        }
        if (!bl || this.isMaxSysCntDirty()) {
            hashMap.put(FIELD_MAXSYSCNT, this.getMaxSysCnt());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMobCertChgTimeDirty()) {
            hashMap.put(FIELD_MOBCERTCHGTIME, this.getMobCertChgTime());
        }
        if (!bl || this.isMobTDChgTimeDirty()) {
            hashMap.put(FIELD_MOBTDCHGTIME, this.getMobTDChgTime());
        }
        if (!bl || this.isPSDCInstIdDirty()) {
            hashMap.put(FIELD_PSDCINSTID, this.getPSDCInstId());
        }
        if (!bl || this.isPSDCInstNameDirty()) {
            hashMap.put(FIELD_PSDCINSTNAME, this.getPSDCInstName());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSPMSServerIdDirty()) {
            hashMap.put(FIELD_PSPMSSERVERID, this.getPSPMSServerId());
        }
        if (!bl || this.isPSPMSServerNameDirty()) {
            hashMap.put(FIELD_PSPMSSERVERNAME, this.getPSPMSServerName());
        }
        if (!bl || this.isPSRTWXAccountIdDirty()) {
            hashMap.put(FIELD_PSRTWXACCOUNTID, this.getPSRTWXAccountId());
        }
        if (!bl || this.isPSRTWXAccountNameDirty()) {
            hashMap.put(FIELD_PSRTWXACCOUNTNAME, this.getPSRTWXAccountName());
        }
        if (!bl || this.isPSStudioServerGrpIdDirty()) {
            hashMap.put(FIELD_PSSTUDIOSERVERGRPID, this.getPSStudioServerGrpId());
        }
        if (!bl || this.isPSStudioServerGrpNameDirty()) {
            hashMap.put(FIELD_PSSTUDIOSERVERGRPNAME, this.getPSStudioServerGrpName());
        }
        if (!bl || this.isPSSvnInstRepoIdDirty()) {
            hashMap.put(FIELD_PSSVNINSTREPOID, this.getPSSvnInstRepoId());
        }
        if (!bl || this.isPSSvnInstRepoNameDirty()) {
            hashMap.put(FIELD_PSSVNINSTREPONAME, this.getPSSvnInstRepoName());
        }
        if (!bl || this.isPSSvrDomainIdDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINID, this.getPSSvrDomainId());
        }
        if (!bl || this.isPSSvrDomainNameDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINNAME, this.getPSSvrDomainName());
        }
        if (!bl || this.isPSSvrProviderIdDirty()) {
            hashMap.put(FIELD_PSSVRPROVIDERID, this.getPSSvrProviderId());
        }
        if (!bl || this.isPSSvrProviderNameDirty()) {
            hashMap.put(FIELD_PSSVRPROVIDERNAME, this.getPSSvrProviderName());
        }
        if (!bl || this.isRobotChgTimeDirty()) {
            hashMap.put(FIELD_ROBOTCHGTIME, this.getRobotChgTime());
        }
        if (!bl || this.isROPSSvnInstRepoIdDirty()) {
            hashMap.put(FIELD_ROPSSVNINSTREPOID, this.getROPSSvnInstRepoId());
        }
        if (!bl || this.isROPSSvnInstRepoNameDirty()) {
            hashMap.put(FIELD_ROPSSVNINSTREPONAME, this.getROPSSvnInstRepoName());
        }
        if (!bl || this.isSPFlagDirty()) {
            hashMap.put(FIELD_SPFLAG, this.getSPFlag());
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
        if (!bl || this.isSysAPIFlagDirty()) {
            hashMap.put(FIELD_SYSAPIFLAG, this.getSysAPIFlag());
        }
        if (!bl || this.isSysCntDirty()) {
            hashMap.put(FIELD_SYSCNT, this.getSysCnt());
        }
        if (!bl || this.isSysSNDirty()) {
            hashMap.put(FIELD_SYSSN, this.getSysSN());
        }
        if (!bl || this.isTotalEnergyDirty()) {
            hashMap.put(FIELD_TOTALENERGY, this.getTotalEnergy());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isV6PSSvnInstRepoIdDirty()) {
            hashMap.put(FIELD_V6PSSVNINSTREPOID, this.getV6PSSvnInstRepoId());
        }
        if (!bl || this.isV6PSSvnInstRepoNameDirty()) {
            hashMap.put(FIELD_V6PSSVNINSTREPONAME, this.getV6PSSvnInstRepoName());
        }
        if (!bl || this.isValidFlagDirty()) {
            hashMap.put(FIELD_VALIDFLAG, this.getValidFlag());
        }
        if (!bl || this.isWebFolderDirty()) {
            hashMap.put(FIELD_WEBFOLDER, this.getWebFolder());
        }
        if (!bl || this.isWebSiteUrlDirty()) {
            hashMap.put(FIELD_WEBSITEURL, this.getWebSiteUrl());
        }
        if (!bl || this.isWXDeptIdDirty()) {
            hashMap.put(FIELD_WXDEPTID, this.getWXDeptId());
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
        return PSDevCenterBase.get(this, n);
    }

    private static Object get(PSDevCenterBase pSDevCenterBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevCenterBase.getCreateDate();
            }
            case 1: {
                return pSDevCenterBase.getCreateMan();
            }
            case 2: {
                return pSDevCenterBase.getDCAPIFlag();
            }
            case 3: {
                return pSDevCenterBase.getDCAPIToken();
            }
            case 4: {
                return pSDevCenterBase.getDCLevel();
            }
            case 5: {
                return pSDevCenterBase.getDCRowKey();
            }
            case 6: {
                return pSDevCenterBase.getDCTag();
            }
            case 7: {
                return pSDevCenterBase.getDCTag2();
            }
            case 8: {
                return pSDevCenterBase.getDCTag3();
            }
            case 9: {
                return pSDevCenterBase.getDCTag4();
            }
            case 10: {
                return pSDevCenterBase.getDCType();
            }
            case 11: {
                return pSDevCenterBase.getDomainName();
            }
            case 12: {
                return pSDevCenterBase.getEnableDeployCenter();
            }
            case 13: {
                return pSDevCenterBase.getEnableWorkspace();
            }
            case 14: {
                return pSDevCenterBase.getEnableWSServer();
            }
            case 15: {
                return pSDevCenterBase.getEntityCnt();
            }
            case 16: {
                return pSDevCenterBase.getExperience();
            }
            case 17: {
                return pSDevCenterBase.getExpiredTime();
            }
            case 18: {
                return pSDevCenterBase.getFullDomainName();
            }
            case 19: {
                return pSDevCenterBase.getIPAddrs();
            }
            case 20: {
                return pSDevCenterBase.getLicInfo();
            }
            case 21: {
                return pSDevCenterBase.getLicKey();
            }
            case 22: {
                return pSDevCenterBase.getLinkIBiz5Flag();
            }
            case 23: {
                return pSDevCenterBase.getMaxActiveUserCnt();
            }
            case 24: {
                return pSDevCenterBase.getMaxEntityCnt();
            }
            case 25: {
                return pSDevCenterBase.getMaxSysCnt();
            }
            case 26: {
                return pSDevCenterBase.getMemo();
            }
            case 27: {
                return pSDevCenterBase.getMobCertChgTime();
            }
            case 28: {
                return pSDevCenterBase.getMobTDChgTime();
            }
            case 29: {
                return pSDevCenterBase.getPSDCInstId();
            }
            case 30: {
                return pSDevCenterBase.getPSDCInstName();
            }
            case 31: {
                return pSDevCenterBase.getPSDevCenterId();
            }
            case 32: {
                return pSDevCenterBase.getPSDevCenterName();
            }
            case 33: {
                return pSDevCenterBase.getPSPMSServerId();
            }
            case 34: {
                return pSDevCenterBase.getPSPMSServerName();
            }
            case 35: {
                return pSDevCenterBase.getPSRTWXAccountId();
            }
            case 36: {
                return pSDevCenterBase.getPSRTWXAccountName();
            }
            case 37: {
                return pSDevCenterBase.getPSStudioServerGrpId();
            }
            case 38: {
                return pSDevCenterBase.getPSStudioServerGrpName();
            }
            case 39: {
                return pSDevCenterBase.getPSSvnInstRepoId();
            }
            case 40: {
                return pSDevCenterBase.getPSSvnInstRepoName();
            }
            case 41: {
                return pSDevCenterBase.getPSSvrDomainId();
            }
            case 42: {
                return pSDevCenterBase.getPSSvrDomainName();
            }
            case 43: {
                return pSDevCenterBase.getPSSvrProviderId();
            }
            case 44: {
                return pSDevCenterBase.getPSSvrProviderName();
            }
            case 45: {
                return pSDevCenterBase.getRobotChgTime();
            }
            case 46: {
                return pSDevCenterBase.getROPSSvnInstRepoId();
            }
            case 47: {
                return pSDevCenterBase.getROPSSvnInstRepoName();
            }
            case 48: {
                return pSDevCenterBase.getSPFlag();
            }
            case 49: {
                return pSDevCenterBase.getStudioTag();
            }
            case 50: {
                return pSDevCenterBase.getStudioTag2();
            }
            case 51: {
                return pSDevCenterBase.getStudioVer();
            }
            case 52: {
                return pSDevCenterBase.getSysAPIFlag();
            }
            case 53: {
                return pSDevCenterBase.getSysCnt();
            }
            case 54: {
                return pSDevCenterBase.getSysSN();
            }
            case 55: {
                return pSDevCenterBase.getTotalEnergy();
            }
            case 56: {
                return pSDevCenterBase.getUpdateDate();
            }
            case 57: {
                return pSDevCenterBase.getUpdateMan();
            }
            case 58: {
                return pSDevCenterBase.getV6PSSvnInstRepoId();
            }
            case 59: {
                return pSDevCenterBase.getV6PSSvnInstRepoName();
            }
            case 60: {
                return pSDevCenterBase.getValidFlag();
            }
            case 61: {
                return pSDevCenterBase.getWebFolder();
            }
            case 62: {
                return pSDevCenterBase.getWebSiteUrl();
            }
            case 63: {
                return pSDevCenterBase.getWXDeptId();
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
        PSDevCenterBase.set(this, n, object);
    }

    private static void set(PSDevCenterBase pSDevCenterBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevCenterBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDevCenterBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevCenterBase.setDCAPIFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSDevCenterBase.setDCAPIToken(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevCenterBase.setDCLevel(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDevCenterBase.setDCRowKey(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevCenterBase.setDCTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevCenterBase.setDCTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevCenterBase.setDCTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevCenterBase.setDCTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevCenterBase.setDCType(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevCenterBase.setDomainName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevCenterBase.setEnableDeployCenter(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSDevCenterBase.setEnableWorkspace(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSDevCenterBase.setEnableWSServer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSDevCenterBase.setEntityCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSDevCenterBase.setExperience(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSDevCenterBase.setExpiredTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 18: {
                pSDevCenterBase.setFullDomainName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDevCenterBase.setIPAddrs(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDevCenterBase.setLicInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDevCenterBase.setLicKey(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDevCenterBase.setLinkIBiz5Flag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 23: {
                pSDevCenterBase.setMaxActiveUserCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 24: {
                pSDevCenterBase.setMaxEntityCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 25: {
                pSDevCenterBase.setMaxSysCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 26: {
                pSDevCenterBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDevCenterBase.setMobCertChgTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 28: {
                pSDevCenterBase.setMobTDChgTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 29: {
                pSDevCenterBase.setPSDCInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDevCenterBase.setPSDCInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDevCenterBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDevCenterBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDevCenterBase.setPSPMSServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDevCenterBase.setPSPMSServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDevCenterBase.setPSRTWXAccountId(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDevCenterBase.setPSRTWXAccountName(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDevCenterBase.setPSStudioServerGrpId(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDevCenterBase.setPSStudioServerGrpName(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDevCenterBase.setPSSvnInstRepoId(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDevCenterBase.setPSSvnInstRepoName(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDevCenterBase.setPSSvrDomainId(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDevCenterBase.setPSSvrDomainName(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSDevCenterBase.setPSSvrProviderId(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSDevCenterBase.setPSSvrProviderName(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSDevCenterBase.setRobotChgTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 46: {
                pSDevCenterBase.setROPSSvnInstRepoId(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSDevCenterBase.setROPSSvnInstRepoName(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSDevCenterBase.setSPFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 49: {
                pSDevCenterBase.setStudioTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSDevCenterBase.setStudioTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSDevCenterBase.setStudioVer(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSDevCenterBase.setSysAPIFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 53: {
                pSDevCenterBase.setSysCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 54: {
                pSDevCenterBase.setSysSN(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 55: {
                pSDevCenterBase.setTotalEnergy(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 56: {
                pSDevCenterBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 57: {
                pSDevCenterBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 58: {
                pSDevCenterBase.setV6PSSvnInstRepoId(DataObject.getStringValue((Object)object));
                return;
            }
            case 59: {
                pSDevCenterBase.setV6PSSvnInstRepoName(DataObject.getStringValue((Object)object));
                return;
            }
            case 60: {
                pSDevCenterBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 61: {
                pSDevCenterBase.setWebFolder(DataObject.getStringValue((Object)object));
                return;
            }
            case 62: {
                pSDevCenterBase.setWebSiteUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 63: {
                pSDevCenterBase.setWXDeptId(DataObject.getIntegerValue((Object)object));
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
        return PSDevCenterBase.isNull(this, n);
    }

    private static boolean isNull(PSDevCenterBase pSDevCenterBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevCenterBase.getCreateDate() == null;
            }
            case 1: {
                return pSDevCenterBase.getCreateMan() == null;
            }
            case 2: {
                return pSDevCenterBase.getDCAPIFlag() == null;
            }
            case 3: {
                return pSDevCenterBase.getDCAPIToken() == null;
            }
            case 4: {
                return pSDevCenterBase.getDCLevel() == null;
            }
            case 5: {
                return pSDevCenterBase.getDCRowKey() == null;
            }
            case 6: {
                return pSDevCenterBase.getDCTag() == null;
            }
            case 7: {
                return pSDevCenterBase.getDCTag2() == null;
            }
            case 8: {
                return pSDevCenterBase.getDCTag3() == null;
            }
            case 9: {
                return pSDevCenterBase.getDCTag4() == null;
            }
            case 10: {
                return pSDevCenterBase.getDCType() == null;
            }
            case 11: {
                return pSDevCenterBase.getDomainName() == null;
            }
            case 12: {
                return pSDevCenterBase.getEnableDeployCenter() == null;
            }
            case 13: {
                return pSDevCenterBase.getEnableWorkspace() == null;
            }
            case 14: {
                return pSDevCenterBase.getEnableWSServer() == null;
            }
            case 15: {
                return pSDevCenterBase.getEntityCnt() == null;
            }
            case 16: {
                return pSDevCenterBase.getExperience() == null;
            }
            case 17: {
                return pSDevCenterBase.getExpiredTime() == null;
            }
            case 18: {
                return pSDevCenterBase.getFullDomainName() == null;
            }
            case 19: {
                return pSDevCenterBase.getIPAddrs() == null;
            }
            case 20: {
                return pSDevCenterBase.getLicInfo() == null;
            }
            case 21: {
                return pSDevCenterBase.getLicKey() == null;
            }
            case 22: {
                return pSDevCenterBase.getLinkIBiz5Flag() == null;
            }
            case 23: {
                return pSDevCenterBase.getMaxActiveUserCnt() == null;
            }
            case 24: {
                return pSDevCenterBase.getMaxEntityCnt() == null;
            }
            case 25: {
                return pSDevCenterBase.getMaxSysCnt() == null;
            }
            case 26: {
                return pSDevCenterBase.getMemo() == null;
            }
            case 27: {
                return pSDevCenterBase.getMobCertChgTime() == null;
            }
            case 28: {
                return pSDevCenterBase.getMobTDChgTime() == null;
            }
            case 29: {
                return pSDevCenterBase.getPSDCInstId() == null;
            }
            case 30: {
                return pSDevCenterBase.getPSDCInstName() == null;
            }
            case 31: {
                return pSDevCenterBase.getPSDevCenterId() == null;
            }
            case 32: {
                return pSDevCenterBase.getPSDevCenterName() == null;
            }
            case 33: {
                return pSDevCenterBase.getPSPMSServerId() == null;
            }
            case 34: {
                return pSDevCenterBase.getPSPMSServerName() == null;
            }
            case 35: {
                return pSDevCenterBase.getPSRTWXAccountId() == null;
            }
            case 36: {
                return pSDevCenterBase.getPSRTWXAccountName() == null;
            }
            case 37: {
                return pSDevCenterBase.getPSStudioServerGrpId() == null;
            }
            case 38: {
                return pSDevCenterBase.getPSStudioServerGrpName() == null;
            }
            case 39: {
                return pSDevCenterBase.getPSSvnInstRepoId() == null;
            }
            case 40: {
                return pSDevCenterBase.getPSSvnInstRepoName() == null;
            }
            case 41: {
                return pSDevCenterBase.getPSSvrDomainId() == null;
            }
            case 42: {
                return pSDevCenterBase.getPSSvrDomainName() == null;
            }
            case 43: {
                return pSDevCenterBase.getPSSvrProviderId() == null;
            }
            case 44: {
                return pSDevCenterBase.getPSSvrProviderName() == null;
            }
            case 45: {
                return pSDevCenterBase.getRobotChgTime() == null;
            }
            case 46: {
                return pSDevCenterBase.getROPSSvnInstRepoId() == null;
            }
            case 47: {
                return pSDevCenterBase.getROPSSvnInstRepoName() == null;
            }
            case 48: {
                return pSDevCenterBase.getSPFlag() == null;
            }
            case 49: {
                return pSDevCenterBase.getStudioTag() == null;
            }
            case 50: {
                return pSDevCenterBase.getStudioTag2() == null;
            }
            case 51: {
                return pSDevCenterBase.getStudioVer() == null;
            }
            case 52: {
                return pSDevCenterBase.getSysAPIFlag() == null;
            }
            case 53: {
                return pSDevCenterBase.getSysCnt() == null;
            }
            case 54: {
                return pSDevCenterBase.getSysSN() == null;
            }
            case 55: {
                return pSDevCenterBase.getTotalEnergy() == null;
            }
            case 56: {
                return pSDevCenterBase.getUpdateDate() == null;
            }
            case 57: {
                return pSDevCenterBase.getUpdateMan() == null;
            }
            case 58: {
                return pSDevCenterBase.getV6PSSvnInstRepoId() == null;
            }
            case 59: {
                return pSDevCenterBase.getV6PSSvnInstRepoName() == null;
            }
            case 60: {
                return pSDevCenterBase.getValidFlag() == null;
            }
            case 61: {
                return pSDevCenterBase.getWebFolder() == null;
            }
            case 62: {
                return pSDevCenterBase.getWebSiteUrl() == null;
            }
            case 63: {
                return pSDevCenterBase.getWXDeptId() == null;
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
        return PSDevCenterBase.contains(this, n);
    }

    private static boolean contains(PSDevCenterBase pSDevCenterBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevCenterBase.isCreateDateDirty();
            }
            case 1: {
                return pSDevCenterBase.isCreateManDirty();
            }
            case 2: {
                return pSDevCenterBase.isDCAPIFlagDirty();
            }
            case 3: {
                return pSDevCenterBase.isDCAPITokenDirty();
            }
            case 4: {
                return pSDevCenterBase.isDCLevelDirty();
            }
            case 5: {
                return pSDevCenterBase.isDCRowKeyDirty();
            }
            case 6: {
                return pSDevCenterBase.isDCTagDirty();
            }
            case 7: {
                return pSDevCenterBase.isDCTag2Dirty();
            }
            case 8: {
                return pSDevCenterBase.isDCTag3Dirty();
            }
            case 9: {
                return pSDevCenterBase.isDCTag4Dirty();
            }
            case 10: {
                return pSDevCenterBase.isDCTypeDirty();
            }
            case 11: {
                return pSDevCenterBase.isDomainNameDirty();
            }
            case 12: {
                return pSDevCenterBase.isEnableDeployCenterDirty();
            }
            case 13: {
                return pSDevCenterBase.isEnableWorkspaceDirty();
            }
            case 14: {
                return pSDevCenterBase.isEnableWSServerDirty();
            }
            case 15: {
                return pSDevCenterBase.isEntityCntDirty();
            }
            case 16: {
                return pSDevCenterBase.isExperienceDirty();
            }
            case 17: {
                return pSDevCenterBase.isExpiredTimeDirty();
            }
            case 18: {
                return pSDevCenterBase.isFullDomainNameDirty();
            }
            case 19: {
                return pSDevCenterBase.isIPAddrsDirty();
            }
            case 20: {
                return pSDevCenterBase.isLicInfoDirty();
            }
            case 21: {
                return pSDevCenterBase.isLicKeyDirty();
            }
            case 22: {
                return pSDevCenterBase.isLinkIBiz5FlagDirty();
            }
            case 23: {
                return pSDevCenterBase.isMaxActiveUserCntDirty();
            }
            case 24: {
                return pSDevCenterBase.isMaxEntityCntDirty();
            }
            case 25: {
                return pSDevCenterBase.isMaxSysCntDirty();
            }
            case 26: {
                return pSDevCenterBase.isMemoDirty();
            }
            case 27: {
                return pSDevCenterBase.isMobCertChgTimeDirty();
            }
            case 28: {
                return pSDevCenterBase.isMobTDChgTimeDirty();
            }
            case 29: {
                return pSDevCenterBase.isPSDCInstIdDirty();
            }
            case 30: {
                return pSDevCenterBase.isPSDCInstNameDirty();
            }
            case 31: {
                return pSDevCenterBase.isPSDevCenterIdDirty();
            }
            case 32: {
                return pSDevCenterBase.isPSDevCenterNameDirty();
            }
            case 33: {
                return pSDevCenterBase.isPSPMSServerIdDirty();
            }
            case 34: {
                return pSDevCenterBase.isPSPMSServerNameDirty();
            }
            case 35: {
                return pSDevCenterBase.isPSRTWXAccountIdDirty();
            }
            case 36: {
                return pSDevCenterBase.isPSRTWXAccountNameDirty();
            }
            case 37: {
                return pSDevCenterBase.isPSStudioServerGrpIdDirty();
            }
            case 38: {
                return pSDevCenterBase.isPSStudioServerGrpNameDirty();
            }
            case 39: {
                return pSDevCenterBase.isPSSvnInstRepoIdDirty();
            }
            case 40: {
                return pSDevCenterBase.isPSSvnInstRepoNameDirty();
            }
            case 41: {
                return pSDevCenterBase.isPSSvrDomainIdDirty();
            }
            case 42: {
                return pSDevCenterBase.isPSSvrDomainNameDirty();
            }
            case 43: {
                return pSDevCenterBase.isPSSvrProviderIdDirty();
            }
            case 44: {
                return pSDevCenterBase.isPSSvrProviderNameDirty();
            }
            case 45: {
                return pSDevCenterBase.isRobotChgTimeDirty();
            }
            case 46: {
                return pSDevCenterBase.isROPSSvnInstRepoIdDirty();
            }
            case 47: {
                return pSDevCenterBase.isROPSSvnInstRepoNameDirty();
            }
            case 48: {
                return pSDevCenterBase.isSPFlagDirty();
            }
            case 49: {
                return pSDevCenterBase.isStudioTagDirty();
            }
            case 50: {
                return pSDevCenterBase.isStudioTag2Dirty();
            }
            case 51: {
                return pSDevCenterBase.isStudioVerDirty();
            }
            case 52: {
                return pSDevCenterBase.isSysAPIFlagDirty();
            }
            case 53: {
                return pSDevCenterBase.isSysCntDirty();
            }
            case 54: {
                return pSDevCenterBase.isSysSNDirty();
            }
            case 55: {
                return pSDevCenterBase.isTotalEnergyDirty();
            }
            case 56: {
                return pSDevCenterBase.isUpdateDateDirty();
            }
            case 57: {
                return pSDevCenterBase.isUpdateManDirty();
            }
            case 58: {
                return pSDevCenterBase.isV6PSSvnInstRepoIdDirty();
            }
            case 59: {
                return pSDevCenterBase.isV6PSSvnInstRepoNameDirty();
            }
            case 60: {
                return pSDevCenterBase.isValidFlagDirty();
            }
            case 61: {
                return pSDevCenterBase.isWebFolderDirty();
            }
            case 62: {
                return pSDevCenterBase.isWebSiteUrlDirty();
            }
            case 63: {
                return pSDevCenterBase.isWXDeptIdDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevCenterBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevCenterBase pSDevCenterBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevCenterBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getDCAPIFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dcapiflag", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getDCAPIFlag()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getDCAPIToken() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dcapitoken", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getDCAPIToken()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getDCLevel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dclevel", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getDCLevel()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getDCRowKey() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dcrowkey", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getDCRowKey()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getDCTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dctag", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getDCTag()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getDCTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dctag2", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getDCTag2()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getDCTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dctag3", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getDCTag3()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getDCTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dctag4", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getDCTag4()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getDCType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dctype", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getDCType()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getDomainName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"domainname", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getDomainName()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getEnableDeployCenter() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enabledeploycenter", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getEnableDeployCenter()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getEnableWorkspace() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableworkspace", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getEnableWorkspace()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getEnableWSServer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablewsserver", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getEnableWSServer()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getEntityCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"entitycnt", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getEntityCnt()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getExperience() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"experience", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getExperience()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getExpiredTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"expiredtime", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getExpiredTime()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getFullDomainName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fulldomainname", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getFullDomainName()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getIPAddrs() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddrs", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getIPAddrs()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getLicInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"licinfo", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getLicInfo()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getLicKey() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lickey", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getLicKey()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getLinkIBiz5Flag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkibiz5flag", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getLinkIBiz5Flag()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getMaxActiveUserCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxactiveusercnt", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getMaxActiveUserCnt()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getMaxEntityCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxentitycnt", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getMaxEntityCnt()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getMaxSysCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxsyscnt", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getMaxSysCnt()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getMobCertChgTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobcertchgtime", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getMobCertChgTime()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getMobTDChgTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobtdchgtime", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getMobTDChgTime()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getPSDCInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcinstid", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getPSDCInstId()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getPSDCInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcinstname", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getPSDCInstName()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getPSPMSServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspmsserverid", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getPSPMSServerId()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getPSPMSServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspmsservername", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getPSPMSServerName()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getPSRTWXAccountId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psrtwxaccountid", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getPSRTWXAccountId()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getPSRTWXAccountName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psrtwxaccountname", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getPSRTWXAccountName()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getPSStudioServerGrpId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psstudioservergrpid", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getPSStudioServerGrpId()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getPSStudioServerGrpName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psstudioservergrpname", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getPSStudioServerGrpName()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getPSSvnInstRepoId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvninstrepoid", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getPSSvnInstRepoId()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getPSSvnInstRepoName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvninstreponame", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getPSSvnInstRepoName()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getPSSvrDomainId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainid", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getPSSvrDomainId()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getPSSvrDomainName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainname", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getPSSvrDomainName()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getPSSvrProviderId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrproviderid", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getPSSvrProviderId()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getPSSvrProviderName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrprovidername", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getPSSvrProviderName()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getRobotChgTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"robotchgtime", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getRobotChgTime()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getROPSSvnInstRepoId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ropssvninstrepoid", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getROPSSvnInstRepoId()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getROPSSvnInstRepoName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ropssvninstreponame", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getROPSSvnInstRepoName()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getSPFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"spflag", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getSPFlag()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getStudioTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"studiotag", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getStudioTag()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getStudioTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"studiotag2", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getStudioTag2()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getStudioVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"studiover", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getStudioVer()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getSysAPIFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sysapiflag", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getSysAPIFlag()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getSysCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"syscnt", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getSysCnt()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getSysSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"syssn", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getSysSN()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getTotalEnergy() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"totalenergy", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getTotalEnergy()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getV6PSSvnInstRepoId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"v6pssvninstrepoid", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getV6PSSvnInstRepoId()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getV6PSSvnInstRepoName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"v6pssvninstreponame", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getV6PSSvnInstRepoName()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getWebFolder() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"webfolder", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getWebFolder()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getWebSiteUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"websiteurl", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getWebSiteUrl()), (boolean)false);
        }
        if (bl || pSDevCenterBase.getWXDeptId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wxdeptid", (Object)PSDevCenterBase.getJSONValue((Object)pSDevCenterBase.getWXDeptId()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevCenterBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevCenterBase pSDevCenterBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevCenterBase.getCreateDate() != null) {
            object = pSDevCenterBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevCenterBase.getCreateMan() != null) {
            object = pSDevCenterBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterBase.getDCAPIFlag() != null) {
            object = pSDevCenterBase.getDCAPIFlag();
            xmlNode.setAttribute(FIELD_DCAPIFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterBase.getDCAPIToken() != null) {
            object = pSDevCenterBase.getDCAPIToken();
            xmlNode.setAttribute(FIELD_DCAPITOKEN, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterBase.getDCLevel() != null) {
            object = pSDevCenterBase.getDCLevel();
            xmlNode.setAttribute(FIELD_DCLEVEL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterBase.getDCRowKey() != null) {
            object = pSDevCenterBase.getDCRowKey();
            xmlNode.setAttribute(FIELD_DCROWKEY, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterBase.getDCTag() != null) {
            object = pSDevCenterBase.getDCTag();
            xmlNode.setAttribute(FIELD_DCTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterBase.getDCTag2() != null) {
            object = pSDevCenterBase.getDCTag2();
            xmlNode.setAttribute(FIELD_DCTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterBase.getDCTag3() != null) {
            object = pSDevCenterBase.getDCTag3();
            xmlNode.setAttribute(FIELD_DCTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterBase.getDCTag4() != null) {
            object = pSDevCenterBase.getDCTag4();
            xmlNode.setAttribute(FIELD_DCTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterBase.getDCType() != null) {
            object = pSDevCenterBase.getDCType();
            xmlNode.setAttribute(FIELD_DCTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterBase.getDomainName() != null) {
            object = pSDevCenterBase.getDomainName();
            xmlNode.setAttribute(FIELD_DOMAINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterBase.getEnableDeployCenter() != null) {
            object = pSDevCenterBase.getEnableDeployCenter();
            xmlNode.setAttribute(FIELD_ENABLEDEPLOYCENTER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterBase.getEnableWorkspace() != null) {
            object = pSDevCenterBase.getEnableWorkspace();
            xmlNode.setAttribute(FIELD_ENABLEWORKSPACE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterBase.getEnableWSServer() != null) {
            object = pSDevCenterBase.getEnableWSServer();
            xmlNode.setAttribute(FIELD_ENABLEWSSERVER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterBase.getEntityCnt() != null) {
            object = pSDevCenterBase.getEntityCnt();
            xmlNode.setAttribute(FIELD_ENTITYCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterBase.getExperience() != null) {
            object = pSDevCenterBase.getExperience();
            xmlNode.setAttribute(FIELD_EXPERIENCE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterBase.getExpiredTime() != null) {
            object = pSDevCenterBase.getExpiredTime();
            xmlNode.setAttribute(FIELD_EXPIREDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevCenterBase.getFullDomainName() != null) {
            object = pSDevCenterBase.getFullDomainName();
            xmlNode.setAttribute(FIELD_FULLDOMAINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterBase.getIPAddrs() != null) {
            object = pSDevCenterBase.getIPAddrs();
            xmlNode.setAttribute(FIELD_IPADDRS, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterBase.getLicInfo() != null) {
            object = pSDevCenterBase.getLicInfo();
            xmlNode.setAttribute(FIELD_LICINFO, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterBase.getLicKey() != null) {
            object = pSDevCenterBase.getLicKey();
            xmlNode.setAttribute(FIELD_LICKEY, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterBase.getLinkIBiz5Flag() != null) {
            object = pSDevCenterBase.getLinkIBiz5Flag();
            xmlNode.setAttribute(FIELD_LINKIBIZ5FLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterBase.getMaxActiveUserCnt() != null) {
            object = pSDevCenterBase.getMaxActiveUserCnt();
            xmlNode.setAttribute(FIELD_MAXACTIVEUSERCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterBase.getMaxEntityCnt() != null) {
            object = pSDevCenterBase.getMaxEntityCnt();
            xmlNode.setAttribute(FIELD_MAXENTITYCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterBase.getMaxSysCnt() != null) {
            object = pSDevCenterBase.getMaxSysCnt();
            xmlNode.setAttribute(FIELD_MAXSYSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterBase.getMemo() != null) {
            object = pSDevCenterBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterBase.getMobCertChgTime() != null) {
            object = pSDevCenterBase.getMobCertChgTime();
            xmlNode.setAttribute(FIELD_MOBCERTCHGTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevCenterBase.getMobTDChgTime() != null) {
            object = pSDevCenterBase.getMobTDChgTime();
            xmlNode.setAttribute(FIELD_MOBTDCHGTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevCenterBase.getPSDCInstId() != null) {
            object = pSDevCenterBase.getPSDCInstId();
            xmlNode.setAttribute(FIELD_PSDCINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterBase.getPSDCInstName() != null) {
            object = pSDevCenterBase.getPSDCInstName();
            xmlNode.setAttribute(FIELD_PSDCINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterBase.getPSDevCenterId() != null) {
            object = pSDevCenterBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterBase.getPSDevCenterName() != null) {
            object = pSDevCenterBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterBase.getPSPMSServerId() != null) {
            object = pSDevCenterBase.getPSPMSServerId();
            xmlNode.setAttribute(FIELD_PSPMSSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterBase.getPSPMSServerName() != null) {
            object = pSDevCenterBase.getPSPMSServerName();
            xmlNode.setAttribute(FIELD_PSPMSSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterBase.getPSRTWXAccountId() != null) {
            object = pSDevCenterBase.getPSRTWXAccountId();
            xmlNode.setAttribute(FIELD_PSRTWXACCOUNTID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterBase.getPSRTWXAccountName() != null) {
            object = pSDevCenterBase.getPSRTWXAccountName();
            xmlNode.setAttribute(FIELD_PSRTWXACCOUNTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterBase.getPSStudioServerGrpId() != null) {
            object = pSDevCenterBase.getPSStudioServerGrpId();
            xmlNode.setAttribute(FIELD_PSSTUDIOSERVERGRPID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterBase.getPSStudioServerGrpName() != null) {
            object = pSDevCenterBase.getPSStudioServerGrpName();
            xmlNode.setAttribute(FIELD_PSSTUDIOSERVERGRPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterBase.getPSSvnInstRepoId() != null) {
            object = pSDevCenterBase.getPSSvnInstRepoId();
            xmlNode.setAttribute(FIELD_PSSVNINSTREPOID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterBase.getPSSvnInstRepoName() != null) {
            object = pSDevCenterBase.getPSSvnInstRepoName();
            xmlNode.setAttribute(FIELD_PSSVNINSTREPONAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterBase.getPSSvrDomainId() != null) {
            object = pSDevCenterBase.getPSSvrDomainId();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterBase.getPSSvrDomainName() != null) {
            object = pSDevCenterBase.getPSSvrDomainName();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterBase.getPSSvrProviderId() != null) {
            object = pSDevCenterBase.getPSSvrProviderId();
            xmlNode.setAttribute(FIELD_PSSVRPROVIDERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterBase.getPSSvrProviderName() != null) {
            object = pSDevCenterBase.getPSSvrProviderName();
            xmlNode.setAttribute(FIELD_PSSVRPROVIDERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterBase.getRobotChgTime() != null) {
            object = pSDevCenterBase.getRobotChgTime();
            xmlNode.setAttribute(FIELD_ROBOTCHGTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevCenterBase.getROPSSvnInstRepoId() != null) {
            object = pSDevCenterBase.getROPSSvnInstRepoId();
            xmlNode.setAttribute(FIELD_ROPSSVNINSTREPOID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterBase.getROPSSvnInstRepoName() != null) {
            object = pSDevCenterBase.getROPSSvnInstRepoName();
            xmlNode.setAttribute(FIELD_ROPSSVNINSTREPONAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterBase.getSPFlag() != null) {
            object = pSDevCenterBase.getSPFlag();
            xmlNode.setAttribute(FIELD_SPFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterBase.getStudioTag() != null) {
            object = pSDevCenterBase.getStudioTag();
            xmlNode.setAttribute(FIELD_STUDIOTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterBase.getStudioTag2() != null) {
            object = pSDevCenterBase.getStudioTag2();
            xmlNode.setAttribute(FIELD_STUDIOTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterBase.getStudioVer() != null) {
            object = pSDevCenterBase.getStudioVer();
            xmlNode.setAttribute(FIELD_STUDIOVER, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterBase.getSysAPIFlag() != null) {
            object = pSDevCenterBase.getSysAPIFlag();
            xmlNode.setAttribute(FIELD_SYSAPIFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterBase.getSysCnt() != null) {
            object = pSDevCenterBase.getSysCnt();
            xmlNode.setAttribute(FIELD_SYSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterBase.getSysSN() != null) {
            object = pSDevCenterBase.getSysSN();
            xmlNode.setAttribute(FIELD_SYSSN, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterBase.getTotalEnergy() != null) {
            object = pSDevCenterBase.getTotalEnergy();
            xmlNode.setAttribute(FIELD_TOTALENERGY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterBase.getUpdateDate() != null) {
            object = pSDevCenterBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevCenterBase.getUpdateMan() != null) {
            object = pSDevCenterBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterBase.getV6PSSvnInstRepoId() != null) {
            object = pSDevCenterBase.getV6PSSvnInstRepoId();
            xmlNode.setAttribute(FIELD_V6PSSVNINSTREPOID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterBase.getV6PSSvnInstRepoName() != null) {
            object = pSDevCenterBase.getV6PSSvnInstRepoName();
            xmlNode.setAttribute(FIELD_V6PSSVNINSTREPONAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterBase.getValidFlag() != null) {
            object = pSDevCenterBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterBase.getWebFolder() != null) {
            object = pSDevCenterBase.getWebFolder();
            xmlNode.setAttribute(FIELD_WEBFOLDER, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterBase.getWebSiteUrl() != null) {
            object = pSDevCenterBase.getWebSiteUrl();
            xmlNode.setAttribute(FIELD_WEBSITEURL, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterBase.getWXDeptId() != null) {
            object = pSDevCenterBase.getWXDeptId();
            xmlNode.setAttribute(FIELD_WXDEPTID, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevCenterBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevCenterBase pSDevCenterBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevCenterBase.isCreateDateDirty() && (bl || pSDevCenterBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevCenterBase.getCreateDate());
        }
        if (pSDevCenterBase.isCreateManDirty() && (bl || pSDevCenterBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevCenterBase.getCreateMan());
        }
        if (pSDevCenterBase.isDCAPIFlagDirty() && (bl || pSDevCenterBase.getDCAPIFlag() != null)) {
            iDataObject.set(FIELD_DCAPIFLAG, (Object)pSDevCenterBase.getDCAPIFlag());
        }
        if (pSDevCenterBase.isDCAPITokenDirty() && (bl || pSDevCenterBase.getDCAPIToken() != null)) {
            iDataObject.set(FIELD_DCAPITOKEN, (Object)pSDevCenterBase.getDCAPIToken());
        }
        if (pSDevCenterBase.isDCLevelDirty() && (bl || pSDevCenterBase.getDCLevel() != null)) {
            iDataObject.set(FIELD_DCLEVEL, (Object)pSDevCenterBase.getDCLevel());
        }
        if (pSDevCenterBase.isDCRowKeyDirty() && (bl || pSDevCenterBase.getDCRowKey() != null)) {
            iDataObject.set(FIELD_DCROWKEY, (Object)pSDevCenterBase.getDCRowKey());
        }
        if (pSDevCenterBase.isDCTagDirty() && (bl || pSDevCenterBase.getDCTag() != null)) {
            iDataObject.set(FIELD_DCTAG, (Object)pSDevCenterBase.getDCTag());
        }
        if (pSDevCenterBase.isDCTag2Dirty() && (bl || pSDevCenterBase.getDCTag2() != null)) {
            iDataObject.set(FIELD_DCTAG2, (Object)pSDevCenterBase.getDCTag2());
        }
        if (pSDevCenterBase.isDCTag3Dirty() && (bl || pSDevCenterBase.getDCTag3() != null)) {
            iDataObject.set(FIELD_DCTAG3, (Object)pSDevCenterBase.getDCTag3());
        }
        if (pSDevCenterBase.isDCTag4Dirty() && (bl || pSDevCenterBase.getDCTag4() != null)) {
            iDataObject.set(FIELD_DCTAG4, (Object)pSDevCenterBase.getDCTag4());
        }
        if (pSDevCenterBase.isDCTypeDirty() && (bl || pSDevCenterBase.getDCType() != null)) {
            iDataObject.set(FIELD_DCTYPE, (Object)pSDevCenterBase.getDCType());
        }
        if (pSDevCenterBase.isDomainNameDirty() && (bl || pSDevCenterBase.getDomainName() != null)) {
            iDataObject.set(FIELD_DOMAINNAME, (Object)pSDevCenterBase.getDomainName());
        }
        if (pSDevCenterBase.isEnableDeployCenterDirty() && (bl || pSDevCenterBase.getEnableDeployCenter() != null)) {
            iDataObject.set(FIELD_ENABLEDEPLOYCENTER, (Object)pSDevCenterBase.getEnableDeployCenter());
        }
        if (pSDevCenterBase.isEnableWorkspaceDirty() && (bl || pSDevCenterBase.getEnableWorkspace() != null)) {
            iDataObject.set(FIELD_ENABLEWORKSPACE, (Object)pSDevCenterBase.getEnableWorkspace());
        }
        if (pSDevCenterBase.isEnableWSServerDirty() && (bl || pSDevCenterBase.getEnableWSServer() != null)) {
            iDataObject.set(FIELD_ENABLEWSSERVER, (Object)pSDevCenterBase.getEnableWSServer());
        }
        if (pSDevCenterBase.isEntityCntDirty() && (bl || pSDevCenterBase.getEntityCnt() != null)) {
            iDataObject.set(FIELD_ENTITYCNT, (Object)pSDevCenterBase.getEntityCnt());
        }
        if (pSDevCenterBase.isExperienceDirty() && (bl || pSDevCenterBase.getExperience() != null)) {
            iDataObject.set(FIELD_EXPERIENCE, (Object)pSDevCenterBase.getExperience());
        }
        if (pSDevCenterBase.isExpiredTimeDirty() && (bl || pSDevCenterBase.getExpiredTime() != null)) {
            iDataObject.set(FIELD_EXPIREDTIME, (Object)pSDevCenterBase.getExpiredTime());
        }
        if (pSDevCenterBase.isFullDomainNameDirty() && (bl || pSDevCenterBase.getFullDomainName() != null)) {
            iDataObject.set(FIELD_FULLDOMAINNAME, (Object)pSDevCenterBase.getFullDomainName());
        }
        if (pSDevCenterBase.isIPAddrsDirty() && (bl || pSDevCenterBase.getIPAddrs() != null)) {
            iDataObject.set(FIELD_IPADDRS, (Object)pSDevCenterBase.getIPAddrs());
        }
        if (pSDevCenterBase.isLicInfoDirty() && (bl || pSDevCenterBase.getLicInfo() != null)) {
            iDataObject.set(FIELD_LICINFO, (Object)pSDevCenterBase.getLicInfo());
        }
        if (pSDevCenterBase.isLicKeyDirty() && (bl || pSDevCenterBase.getLicKey() != null)) {
            iDataObject.set(FIELD_LICKEY, (Object)pSDevCenterBase.getLicKey());
        }
        if (pSDevCenterBase.isLinkIBiz5FlagDirty() && (bl || pSDevCenterBase.getLinkIBiz5Flag() != null)) {
            iDataObject.set(FIELD_LINKIBIZ5FLAG, (Object)pSDevCenterBase.getLinkIBiz5Flag());
        }
        if (pSDevCenterBase.isMaxActiveUserCntDirty() && (bl || pSDevCenterBase.getMaxActiveUserCnt() != null)) {
            iDataObject.set(FIELD_MAXACTIVEUSERCNT, (Object)pSDevCenterBase.getMaxActiveUserCnt());
        }
        if (pSDevCenterBase.isMaxEntityCntDirty() && (bl || pSDevCenterBase.getMaxEntityCnt() != null)) {
            iDataObject.set(FIELD_MAXENTITYCNT, (Object)pSDevCenterBase.getMaxEntityCnt());
        }
        if (pSDevCenterBase.isMaxSysCntDirty() && (bl || pSDevCenterBase.getMaxSysCnt() != null)) {
            iDataObject.set(FIELD_MAXSYSCNT, (Object)pSDevCenterBase.getMaxSysCnt());
        }
        if (pSDevCenterBase.isMemoDirty() && (bl || pSDevCenterBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevCenterBase.getMemo());
        }
        if (pSDevCenterBase.isMobCertChgTimeDirty() && (bl || pSDevCenterBase.getMobCertChgTime() != null)) {
            iDataObject.set(FIELD_MOBCERTCHGTIME, (Object)pSDevCenterBase.getMobCertChgTime());
        }
        if (pSDevCenterBase.isMobTDChgTimeDirty() && (bl || pSDevCenterBase.getMobTDChgTime() != null)) {
            iDataObject.set(FIELD_MOBTDCHGTIME, (Object)pSDevCenterBase.getMobTDChgTime());
        }
        if (pSDevCenterBase.isPSDCInstIdDirty() && (bl || pSDevCenterBase.getPSDCInstId() != null)) {
            iDataObject.set(FIELD_PSDCINSTID, (Object)pSDevCenterBase.getPSDCInstId());
        }
        if (pSDevCenterBase.isPSDCInstNameDirty() && (bl || pSDevCenterBase.getPSDCInstName() != null)) {
            iDataObject.set(FIELD_PSDCINSTNAME, (Object)pSDevCenterBase.getPSDCInstName());
        }
        if (pSDevCenterBase.isPSDevCenterIdDirty() && (bl || pSDevCenterBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDevCenterBase.getPSDevCenterId());
        }
        if (pSDevCenterBase.isPSDevCenterNameDirty() && (bl || pSDevCenterBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDevCenterBase.getPSDevCenterName());
        }
        if (pSDevCenterBase.isPSPMSServerIdDirty() && (bl || pSDevCenterBase.getPSPMSServerId() != null)) {
            iDataObject.set(FIELD_PSPMSSERVERID, (Object)pSDevCenterBase.getPSPMSServerId());
        }
        if (pSDevCenterBase.isPSPMSServerNameDirty() && (bl || pSDevCenterBase.getPSPMSServerName() != null)) {
            iDataObject.set(FIELD_PSPMSSERVERNAME, (Object)pSDevCenterBase.getPSPMSServerName());
        }
        if (pSDevCenterBase.isPSRTWXAccountIdDirty() && (bl || pSDevCenterBase.getPSRTWXAccountId() != null)) {
            iDataObject.set(FIELD_PSRTWXACCOUNTID, (Object)pSDevCenterBase.getPSRTWXAccountId());
        }
        if (pSDevCenterBase.isPSRTWXAccountNameDirty() && (bl || pSDevCenterBase.getPSRTWXAccountName() != null)) {
            iDataObject.set(FIELD_PSRTWXACCOUNTNAME, (Object)pSDevCenterBase.getPSRTWXAccountName());
        }
        if (pSDevCenterBase.isPSStudioServerGrpIdDirty() && (bl || pSDevCenterBase.getPSStudioServerGrpId() != null)) {
            iDataObject.set(FIELD_PSSTUDIOSERVERGRPID, (Object)pSDevCenterBase.getPSStudioServerGrpId());
        }
        if (pSDevCenterBase.isPSStudioServerGrpNameDirty() && (bl || pSDevCenterBase.getPSStudioServerGrpName() != null)) {
            iDataObject.set(FIELD_PSSTUDIOSERVERGRPNAME, (Object)pSDevCenterBase.getPSStudioServerGrpName());
        }
        if (pSDevCenterBase.isPSSvnInstRepoIdDirty() && (bl || pSDevCenterBase.getPSSvnInstRepoId() != null)) {
            iDataObject.set(FIELD_PSSVNINSTREPOID, (Object)pSDevCenterBase.getPSSvnInstRepoId());
        }
        if (pSDevCenterBase.isPSSvnInstRepoNameDirty() && (bl || pSDevCenterBase.getPSSvnInstRepoName() != null)) {
            iDataObject.set(FIELD_PSSVNINSTREPONAME, (Object)pSDevCenterBase.getPSSvnInstRepoName());
        }
        if (pSDevCenterBase.isPSSvrDomainIdDirty() && (bl || pSDevCenterBase.getPSSvrDomainId() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINID, (Object)pSDevCenterBase.getPSSvrDomainId());
        }
        if (pSDevCenterBase.isPSSvrDomainNameDirty() && (bl || pSDevCenterBase.getPSSvrDomainName() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINNAME, (Object)pSDevCenterBase.getPSSvrDomainName());
        }
        if (pSDevCenterBase.isPSSvrProviderIdDirty() && (bl || pSDevCenterBase.getPSSvrProviderId() != null)) {
            iDataObject.set(FIELD_PSSVRPROVIDERID, (Object)pSDevCenterBase.getPSSvrProviderId());
        }
        if (pSDevCenterBase.isPSSvrProviderNameDirty() && (bl || pSDevCenterBase.getPSSvrProviderName() != null)) {
            iDataObject.set(FIELD_PSSVRPROVIDERNAME, (Object)pSDevCenterBase.getPSSvrProviderName());
        }
        if (pSDevCenterBase.isRobotChgTimeDirty() && (bl || pSDevCenterBase.getRobotChgTime() != null)) {
            iDataObject.set(FIELD_ROBOTCHGTIME, (Object)pSDevCenterBase.getRobotChgTime());
        }
        if (pSDevCenterBase.isROPSSvnInstRepoIdDirty() && (bl || pSDevCenterBase.getROPSSvnInstRepoId() != null)) {
            iDataObject.set(FIELD_ROPSSVNINSTREPOID, (Object)pSDevCenterBase.getROPSSvnInstRepoId());
        }
        if (pSDevCenterBase.isROPSSvnInstRepoNameDirty() && (bl || pSDevCenterBase.getROPSSvnInstRepoName() != null)) {
            iDataObject.set(FIELD_ROPSSVNINSTREPONAME, (Object)pSDevCenterBase.getROPSSvnInstRepoName());
        }
        if (pSDevCenterBase.isSPFlagDirty() && (bl || pSDevCenterBase.getSPFlag() != null)) {
            iDataObject.set(FIELD_SPFLAG, (Object)pSDevCenterBase.getSPFlag());
        }
        if (pSDevCenterBase.isStudioTagDirty() && (bl || pSDevCenterBase.getStudioTag() != null)) {
            iDataObject.set(FIELD_STUDIOTAG, (Object)pSDevCenterBase.getStudioTag());
        }
        if (pSDevCenterBase.isStudioTag2Dirty() && (bl || pSDevCenterBase.getStudioTag2() != null)) {
            iDataObject.set(FIELD_STUDIOTAG2, (Object)pSDevCenterBase.getStudioTag2());
        }
        if (pSDevCenterBase.isStudioVerDirty() && (bl || pSDevCenterBase.getStudioVer() != null)) {
            iDataObject.set(FIELD_STUDIOVER, (Object)pSDevCenterBase.getStudioVer());
        }
        if (pSDevCenterBase.isSysAPIFlagDirty() && (bl || pSDevCenterBase.getSysAPIFlag() != null)) {
            iDataObject.set(FIELD_SYSAPIFLAG, (Object)pSDevCenterBase.getSysAPIFlag());
        }
        if (pSDevCenterBase.isSysCntDirty() && (bl || pSDevCenterBase.getSysCnt() != null)) {
            iDataObject.set(FIELD_SYSCNT, (Object)pSDevCenterBase.getSysCnt());
        }
        if (pSDevCenterBase.isSysSNDirty() && (bl || pSDevCenterBase.getSysSN() != null)) {
            iDataObject.set(FIELD_SYSSN, (Object)pSDevCenterBase.getSysSN());
        }
        if (pSDevCenterBase.isTotalEnergyDirty() && (bl || pSDevCenterBase.getTotalEnergy() != null)) {
            iDataObject.set(FIELD_TOTALENERGY, (Object)pSDevCenterBase.getTotalEnergy());
        }
        if (pSDevCenterBase.isUpdateDateDirty() && (bl || pSDevCenterBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevCenterBase.getUpdateDate());
        }
        if (pSDevCenterBase.isUpdateManDirty() && (bl || pSDevCenterBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevCenterBase.getUpdateMan());
        }
        if (pSDevCenterBase.isV6PSSvnInstRepoIdDirty() && (bl || pSDevCenterBase.getV6PSSvnInstRepoId() != null)) {
            iDataObject.set(FIELD_V6PSSVNINSTREPOID, (Object)pSDevCenterBase.getV6PSSvnInstRepoId());
        }
        if (pSDevCenterBase.isV6PSSvnInstRepoNameDirty() && (bl || pSDevCenterBase.getV6PSSvnInstRepoName() != null)) {
            iDataObject.set(FIELD_V6PSSVNINSTREPONAME, (Object)pSDevCenterBase.getV6PSSvnInstRepoName());
        }
        if (pSDevCenterBase.isValidFlagDirty() && (bl || pSDevCenterBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDevCenterBase.getValidFlag());
        }
        if (pSDevCenterBase.isWebFolderDirty() && (bl || pSDevCenterBase.getWebFolder() != null)) {
            iDataObject.set(FIELD_WEBFOLDER, (Object)pSDevCenterBase.getWebFolder());
        }
        if (pSDevCenterBase.isWebSiteUrlDirty() && (bl || pSDevCenterBase.getWebSiteUrl() != null)) {
            iDataObject.set(FIELD_WEBSITEURL, (Object)pSDevCenterBase.getWebSiteUrl());
        }
        if (pSDevCenterBase.isWXDeptIdDirty() && (bl || pSDevCenterBase.getWXDeptId() != null)) {
            iDataObject.set(FIELD_WXDEPTID, (Object)pSDevCenterBase.getWXDeptId());
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
        return PSDevCenterBase.remove(this, n);
    }

    private static boolean remove(PSDevCenterBase pSDevCenterBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevCenterBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDevCenterBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDevCenterBase.resetDCAPIFlag();
                return true;
            }
            case 3: {
                pSDevCenterBase.resetDCAPIToken();
                return true;
            }
            case 4: {
                pSDevCenterBase.resetDCLevel();
                return true;
            }
            case 5: {
                pSDevCenterBase.resetDCRowKey();
                return true;
            }
            case 6: {
                pSDevCenterBase.resetDCTag();
                return true;
            }
            case 7: {
                pSDevCenterBase.resetDCTag2();
                return true;
            }
            case 8: {
                pSDevCenterBase.resetDCTag3();
                return true;
            }
            case 9: {
                pSDevCenterBase.resetDCTag4();
                return true;
            }
            case 10: {
                pSDevCenterBase.resetDCType();
                return true;
            }
            case 11: {
                pSDevCenterBase.resetDomainName();
                return true;
            }
            case 12: {
                pSDevCenterBase.resetEnableDeployCenter();
                return true;
            }
            case 13: {
                pSDevCenterBase.resetEnableWorkspace();
                return true;
            }
            case 14: {
                pSDevCenterBase.resetEnableWSServer();
                return true;
            }
            case 15: {
                pSDevCenterBase.resetEntityCnt();
                return true;
            }
            case 16: {
                pSDevCenterBase.resetExperience();
                return true;
            }
            case 17: {
                pSDevCenterBase.resetExpiredTime();
                return true;
            }
            case 18: {
                pSDevCenterBase.resetFullDomainName();
                return true;
            }
            case 19: {
                pSDevCenterBase.resetIPAddrs();
                return true;
            }
            case 20: {
                pSDevCenterBase.resetLicInfo();
                return true;
            }
            case 21: {
                pSDevCenterBase.resetLicKey();
                return true;
            }
            case 22: {
                pSDevCenterBase.resetLinkIBiz5Flag();
                return true;
            }
            case 23: {
                pSDevCenterBase.resetMaxActiveUserCnt();
                return true;
            }
            case 24: {
                pSDevCenterBase.resetMaxEntityCnt();
                return true;
            }
            case 25: {
                pSDevCenterBase.resetMaxSysCnt();
                return true;
            }
            case 26: {
                pSDevCenterBase.resetMemo();
                return true;
            }
            case 27: {
                pSDevCenterBase.resetMobCertChgTime();
                return true;
            }
            case 28: {
                pSDevCenterBase.resetMobTDChgTime();
                return true;
            }
            case 29: {
                pSDevCenterBase.resetPSDCInstId();
                return true;
            }
            case 30: {
                pSDevCenterBase.resetPSDCInstName();
                return true;
            }
            case 31: {
                pSDevCenterBase.resetPSDevCenterId();
                return true;
            }
            case 32: {
                pSDevCenterBase.resetPSDevCenterName();
                return true;
            }
            case 33: {
                pSDevCenterBase.resetPSPMSServerId();
                return true;
            }
            case 34: {
                pSDevCenterBase.resetPSPMSServerName();
                return true;
            }
            case 35: {
                pSDevCenterBase.resetPSRTWXAccountId();
                return true;
            }
            case 36: {
                pSDevCenterBase.resetPSRTWXAccountName();
                return true;
            }
            case 37: {
                pSDevCenterBase.resetPSStudioServerGrpId();
                return true;
            }
            case 38: {
                pSDevCenterBase.resetPSStudioServerGrpName();
                return true;
            }
            case 39: {
                pSDevCenterBase.resetPSSvnInstRepoId();
                return true;
            }
            case 40: {
                pSDevCenterBase.resetPSSvnInstRepoName();
                return true;
            }
            case 41: {
                pSDevCenterBase.resetPSSvrDomainId();
                return true;
            }
            case 42: {
                pSDevCenterBase.resetPSSvrDomainName();
                return true;
            }
            case 43: {
                pSDevCenterBase.resetPSSvrProviderId();
                return true;
            }
            case 44: {
                pSDevCenterBase.resetPSSvrProviderName();
                return true;
            }
            case 45: {
                pSDevCenterBase.resetRobotChgTime();
                return true;
            }
            case 46: {
                pSDevCenterBase.resetROPSSvnInstRepoId();
                return true;
            }
            case 47: {
                pSDevCenterBase.resetROPSSvnInstRepoName();
                return true;
            }
            case 48: {
                pSDevCenterBase.resetSPFlag();
                return true;
            }
            case 49: {
                pSDevCenterBase.resetStudioTag();
                return true;
            }
            case 50: {
                pSDevCenterBase.resetStudioTag2();
                return true;
            }
            case 51: {
                pSDevCenterBase.resetStudioVer();
                return true;
            }
            case 52: {
                pSDevCenterBase.resetSysAPIFlag();
                return true;
            }
            case 53: {
                pSDevCenterBase.resetSysCnt();
                return true;
            }
            case 54: {
                pSDevCenterBase.resetSysSN();
                return true;
            }
            case 55: {
                pSDevCenterBase.resetTotalEnergy();
                return true;
            }
            case 56: {
                pSDevCenterBase.resetUpdateDate();
                return true;
            }
            case 57: {
                pSDevCenterBase.resetUpdateMan();
                return true;
            }
            case 58: {
                pSDevCenterBase.resetV6PSSvnInstRepoId();
                return true;
            }
            case 59: {
                pSDevCenterBase.resetV6PSSvnInstRepoName();
                return true;
            }
            case 60: {
                pSDevCenterBase.resetValidFlag();
                return true;
            }
            case 61: {
                pSDevCenterBase.resetWebFolder();
                return true;
            }
            case 62: {
                pSDevCenterBase.resetWebSiteUrl();
                return true;
            }
            case 63: {
                pSDevCenterBase.resetWXDeptId();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCInst getPSDCInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCInst();
        }
        if (this.getPSDCInstId() == null) {
            return null;
        }
        Integer n = this.objPSDCInstLock;
        synchronized (n) {
            if (this.psdcinst != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCInstId(), (Object)this.psdcinst.getPSDCInstId()) != 0L) {
                this.psdcinst = null;
            }
            if (this.psdcinst == null) {
                PSDCInst pSDCInst = new PSDCInst();
                pSDCInst.setPSDCInstId(this.getPSDCInstId());
                PSDCInstService pSDCInstService = (PSDCInstService)ServiceGlobal.getService(PSDCInstService.class, (SessionFactory)this.getSessionFactory());
                pSDCInstService.autoGet((IEntity)pSDCInst);
                this.psdcinst = pSDCInst;
            }
            return this.psdcinst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPMSServer getPSPMSServer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPMSServer();
        }
        if (this.getPSPMSServerId() == null) {
            return null;
        }
        Integer n = this.objPSPMSServerLock;
        synchronized (n) {
            if (this.pspmsserver != null && DataTypeHelper.compare((int)25, (Object)this.getPSPMSServerId(), (Object)this.pspmsserver.getPSPMSServerId()) != 0L) {
                this.pspmsserver = null;
            }
            if (this.pspmsserver == null) {
                PSPMSServer pSPMSServer = new PSPMSServer();
                pSPMSServer.setPSPMSServerId(this.getPSPMSServerId());
                PSPMSServerService pSPMSServerService = (PSPMSServerService)ServiceGlobal.getService(PSPMSServerService.class, (SessionFactory)this.getSessionFactory());
                pSPMSServerService.autoGet((IEntity)pSPMSServer);
                this.pspmsserver = pSPMSServer;
            }
            return this.pspmsserver;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSRTWXAccount getPSRTWXAccount() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSRTWXAccount();
        }
        if (this.getPSRTWXAccountId() == null) {
            return null;
        }
        Integer n = this.objPSRTWXAccountLock;
        synchronized (n) {
            if (this.psrtwxaccount != null && DataTypeHelper.compare((int)25, (Object)this.getPSRTWXAccountId(), (Object)this.psrtwxaccount.getPSRTWXAccountId()) != 0L) {
                this.psrtwxaccount = null;
            }
            if (this.psrtwxaccount == null) {
                PSRTWXAccount pSRTWXAccount = new PSRTWXAccount();
                pSRTWXAccount.setPSRTWXAccountId(this.getPSRTWXAccountId());
                PSRTWXAccountService pSRTWXAccountService = (PSRTWXAccountService)ServiceGlobal.getService(PSRTWXAccountService.class, (SessionFactory)this.getSessionFactory());
                pSRTWXAccountService.autoGet((IEntity)pSRTWXAccount);
                this.psrtwxaccount = pSRTWXAccount;
            }
            return this.psrtwxaccount;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSStudioServerGrp getPSStudioServerGrp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSStudioServerGrp();
        }
        if (this.getPSStudioServerGrpId() == null) {
            return null;
        }
        Integer n = this.objPSStudioServerGrpLock;
        synchronized (n) {
            if (this.psstudioservergrp != null && DataTypeHelper.compare((int)25, (Object)this.getPSStudioServerGrpId(), (Object)this.psstudioservergrp.getPSStudioServerGrpId()) != 0L) {
                this.psstudioservergrp = null;
            }
            if (this.psstudioservergrp == null) {
                PSStudioServerGrp pSStudioServerGrp = new PSStudioServerGrp();
                pSStudioServerGrp.setPSStudioServerGrpId(this.getPSStudioServerGrpId());
                PSStudioServerGrpService pSStudioServerGrpService = (PSStudioServerGrpService)ServiceGlobal.getService(PSStudioServerGrpService.class, (SessionFactory)this.getSessionFactory());
                pSStudioServerGrpService.autoGet((IEntity)pSStudioServerGrp);
                this.psstudioservergrp = pSStudioServerGrp;
            }
            return this.psstudioservergrp;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSVNInstRepo getPSSvnInstRepo() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSvnInstRepo();
        }
        if (this.getPSSvnInstRepoId() == null) {
            return null;
        }
        Integer n = this.objPSSvnInstRepoLock;
        synchronized (n) {
            if (this.pssvninstrepo != null && DataTypeHelper.compare((int)25, (Object)this.getPSSvnInstRepoId(), (Object)this.pssvninstrepo.getPSSVNInstRepoId()) != 0L) {
                this.pssvninstrepo = null;
            }
            if (this.pssvninstrepo == null) {
                PSSVNInstRepo pSSVNInstRepo = new PSSVNInstRepo();
                pSSVNInstRepo.setPSSVNInstRepoId(this.getPSSvnInstRepoId());
                PSSVNInstRepoService pSSVNInstRepoService = (PSSVNInstRepoService)ServiceGlobal.getService(PSSVNInstRepoService.class, (SessionFactory)this.getSessionFactory());
                pSSVNInstRepoService.autoGet((IEntity)pSSVNInstRepo);
                this.pssvninstrepo = pSSVNInstRepo;
            }
            return this.pssvninstrepo;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSVNInstRepo getROPSSvnInstRepo() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getROPSSvnInstRepo();
        }
        if (this.getROPSSvnInstRepoId() == null) {
            return null;
        }
        Integer n = this.objROPSSvnInstRepoLock;
        synchronized (n) {
            if (this.ropssvninstrepo != null && DataTypeHelper.compare((int)25, (Object)this.getROPSSvnInstRepoId(), (Object)this.ropssvninstrepo.getPSSVNInstRepoId()) != 0L) {
                this.ropssvninstrepo = null;
            }
            if (this.ropssvninstrepo == null) {
                PSSVNInstRepo pSSVNInstRepo = new PSSVNInstRepo();
                pSSVNInstRepo.setPSSVNInstRepoId(this.getROPSSvnInstRepoId());
                PSSVNInstRepoService pSSVNInstRepoService = (PSSVNInstRepoService)ServiceGlobal.getService(PSSVNInstRepoService.class, (SessionFactory)this.getSessionFactory());
                pSSVNInstRepoService.autoGet((IEntity)pSSVNInstRepo);
                this.ropssvninstrepo = pSSVNInstRepo;
            }
            return this.ropssvninstrepo;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSVNInstRepo getV6PSSvnInstRepo() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getV6PSSvnInstRepo();
        }
        if (this.getV6PSSvnInstRepoId() == null) {
            return null;
        }
        Integer n = this.objV6PSSvnInstRepoLock;
        synchronized (n) {
            if (this.v6pssvninstrepo != null && DataTypeHelper.compare((int)25, (Object)this.getV6PSSvnInstRepoId(), (Object)this.v6pssvninstrepo.getPSSVNInstRepoId()) != 0L) {
                this.v6pssvninstrepo = null;
            }
            if (this.v6pssvninstrepo == null) {
                PSSVNInstRepo pSSVNInstRepo = new PSSVNInstRepo();
                pSSVNInstRepo.setPSSVNInstRepoId(this.getV6PSSvnInstRepoId());
                PSSVNInstRepoService pSSVNInstRepoService = (PSSVNInstRepoService)ServiceGlobal.getService(PSSVNInstRepoService.class, (SessionFactory)this.getSessionFactory());
                pSSVNInstRepoService.autoGet((IEntity)pSSVNInstRepo);
                this.v6pssvninstrepo = pSSVNInstRepo;
            }
            return this.v6pssvninstrepo;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSvrDomain getPSSvrDomain() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSvrDomain();
        }
        if (this.getPSSvrDomainId() == null) {
            return null;
        }
        Integer n = this.objPSSvrDomainLock;
        synchronized (n) {
            if (this.pssvrdomain != null && DataTypeHelper.compare((int)25, (Object)this.getPSSvrDomainId(), (Object)this.pssvrdomain.getPSSvrDomainId()) != 0L) {
                this.pssvrdomain = null;
            }
            if (this.pssvrdomain == null) {
                PSSvrDomain pSSvrDomain = new PSSvrDomain();
                pSSvrDomain.setPSSvrDomainId(this.getPSSvrDomainId());
                PSSvrDomainService pSSvrDomainService = (PSSvrDomainService)ServiceGlobal.getService(PSSvrDomainService.class, (SessionFactory)this.getSessionFactory());
                pSSvrDomainService.autoGet((IEntity)pSSvrDomain);
                this.pssvrdomain = pSSvrDomain;
            }
            return this.pssvrdomain;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSvrProvider getPSSvrProvider() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSvrProvider();
        }
        if (this.getPSSvrProviderId() == null) {
            return null;
        }
        Integer n = this.objPSSvrProviderLock;
        synchronized (n) {
            if (this.pssvrprovider != null && DataTypeHelper.compare((int)25, (Object)this.getPSSvrProviderId(), (Object)this.pssvrprovider.getPSSvrProviderId()) != 0L) {
                this.pssvrprovider = null;
            }
            if (this.pssvrprovider == null) {
                PSSvrProvider pSSvrProvider = new PSSvrProvider();
                pSSvrProvider.setPSSvrProviderId(this.getPSSvrProviderId());
                PSSvrProviderService pSSvrProviderService = (PSSvrProviderService)ServiceGlobal.getService(PSSvrProviderService.class, (SessionFactory)this.getSessionFactory());
                pSSvrProviderService.autoGet((IEntity)pSSvrProvider);
                this.pssvrprovider = pSSvrProvider;
            }
            return this.pssvrprovider;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSCredential> getPSCredentials() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCredentials();
        }
        if (this.getPSDevCenterId() == null) {
            return null;
        }
        PSCredentialService pSCredentialService = (PSCredentialService)ServiceGlobal.getService(PSCredentialService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSCredentialsLock;
        synchronized (n) {
            if (this.pscredentials == null) {
                this.pscredentials = pSCredentialService.selectByPSDevCenter(this);
            }
            return this.pscredentials;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDCCluster> getPSDCClusters() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCClusters();
        }
        if (this.getPSDevCenterId() == null) {
            return null;
        }
        PSDCClusterService pSDCClusterService = (PSDCClusterService)ServiceGlobal.getService(PSDCClusterService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDCClustersLock;
        synchronized (n) {
            if (this.psdcclusters == null) {
                this.psdcclusters = pSDCClusterService.selectByPSDevCenter(this);
            }
            return this.psdcclusters;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDCCodeSnippet> getPSDCCodeSnippets() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCCodeSnippets();
        }
        if (this.getPSDevCenterId() == null) {
            return null;
        }
        PSDCCodeSnippetService pSDCCodeSnippetService = (PSDCCodeSnippetService)ServiceGlobal.getService(PSDCCodeSnippetService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDCCodeSnippetsLock;
        synchronized (n) {
            if (this.psdccodesnippets == null) {
                this.psdccodesnippets = pSDCCodeSnippetService.selectByPSDevCenter(this);
            }
            return this.psdccodesnippets;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDCContainerSpec> getPSDCContainerSpecs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCContainerSpecs();
        }
        if (this.getPSDevCenterId() == null) {
            return null;
        }
        PSDCContainerSpecService pSDCContainerSpecService = (PSDCContainerSpecService)ServiceGlobal.getService(PSDCContainerSpecService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDCContainerSpecsLock;
        synchronized (n) {
            if (this.psdccontainerspecs == null) {
                this.psdccontainerspecs = pSDCContainerSpecService.selectByPSDevCenter(this);
            }
            return this.psdccontainerspecs;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDCDeployServer> getPSDCDeployServer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCDeployServer();
        }
        if (this.getPSDevCenterId() == null) {
            return null;
        }
        PSDCDeployServerService pSDCDeployServerService = (PSDCDeployServerService)ServiceGlobal.getService(PSDCDeployServerService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDCDeployServerLock;
        synchronized (n) {
            if (this.psdcdeployserver == null) {
                this.psdcdeployserver = pSDCDeployServerService.selectByPSDevCenter(this);
            }
            return this.psdcdeployserver;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDCDETempl> getPSDCDETempls() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCDETempls();
        }
        if (this.getPSDevCenterId() == null) {
            return null;
        }
        PSDCDETemplService pSDCDETemplService = (PSDCDETemplService)ServiceGlobal.getService(PSDCDETemplService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDCDETemplsLock;
        synchronized (n) {
            if (this.psdcdetempls == null) {
                this.psdcdetempls = pSDCDETemplService.selectByPSDevCenter(this);
            }
            return this.psdcdetempls;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDCFile> getPSDCFiles() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCFiles();
        }
        if (this.getPSDevCenterId() == null) {
            return null;
        }
        PSDCFileService pSDCFileService = (PSDCFileService)ServiceGlobal.getService(PSDCFileService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDCFilesLock;
        synchronized (n) {
            if (this.psdcfiles == null) {
                this.psdcfiles = pSDCFileService.selectByPSDevCenter(this);
            }
            return this.psdcfiles;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDCModelTempl> getPSDCModelTempls() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCModelTempls();
        }
        if (this.getPSDevCenterId() == null) {
            return null;
        }
        PSDCModelTemplService pSDCModelTemplService = (PSDCModelTemplService)ServiceGlobal.getService(PSDCModelTemplService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDCModelTemplsLock;
        synchronized (n) {
            if (this.psdcmodeltempls == null) {
                this.psdcmodeltempls = pSDCModelTemplService.selectByPSDevCenter(this);
            }
            return this.psdcmodeltempls;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDCMSPlatform> getPSDCMSPlatforms() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMSPlatforms();
        }
        if (this.getPSDevCenterId() == null) {
            return null;
        }
        PSDCMSPlatformService pSDCMSPlatformService = (PSDCMSPlatformService)ServiceGlobal.getService(PSDCMSPlatformService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDCMSPlatformsLock;
        synchronized (n) {
            if (this.psdcmsplatforms == null) {
                this.psdcmsplatforms = pSDCMSPlatformService.selectByPSDevCenter(this);
            }
            return this.psdcmsplatforms;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDCRegistryRepo> getPSDCRegistryRepos() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCRegistryRepos();
        }
        if (this.getPSDevCenterId() == null) {
            return null;
        }
        PSDCRegistryRepoService pSDCRegistryRepoService = (PSDCRegistryRepoService)ServiceGlobal.getService(PSDCRegistryRepoService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDCRegistryReposLock;
        synchronized (n) {
            if (this.psdcregistryrepos == null) {
                this.psdcregistryrepos = pSDCRegistryRepoService.selectByPSDevCenter(this);
            }
            return this.psdcregistryrepos;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDCRobotAbility> getPSDCRobotAbilities() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCRobotAbilities();
        }
        if (this.getPSDevCenterId() == null) {
            return null;
        }
        PSDCRobotAbilityService pSDCRobotAbilityService = (PSDCRobotAbilityService)ServiceGlobal.getService(PSDCRobotAbilityService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDCRobotAbilitiesLock;
        synchronized (n) {
            if (this.psdcrobotabilities == null) {
                this.psdcrobotabilities = pSDCRobotAbilityService.selectByPSDevCenter(this);
            }
            return this.psdcrobotabilities;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDCSearchEngineInst> getPSDCSearchEngineInsts() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCSearchEngineInsts();
        }
        if (this.getPSDevCenterId() == null) {
            return null;
        }
        PSDCSearchEngineInstService pSDCSearchEngineInstService = (PSDCSearchEngineInstService)ServiceGlobal.getService(PSDCSearchEngineInstService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDCSearchEngineInstsLock;
        synchronized (n) {
            if (this.psdcsearchengineinsts == null) {
                this.psdcsearchengineinsts = pSDCSearchEngineInstService.selectByPSDevCenter(this);
            }
            return this.psdcsearchengineinsts;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDCSyncData> getPSDCSyncDatas() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCSyncDatas();
        }
        if (this.getPSDevCenterId() == null) {
            return null;
        }
        PSDCSyncDataService pSDCSyncDataService = (PSDCSyncDataService)ServiceGlobal.getService(PSDCSyncDataService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDCSyncDatasLock;
        synchronized (n) {
            if (this.psdcsyncdatas == null) {
                this.psdcsyncdatas = pSDCSyncDataService.selectByPSDevCenter(this);
            }
            return this.psdcsyncdatas;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDCWFEngineInst> getPSDCWFEngineInsts() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCWFEngineInsts();
        }
        if (this.getPSDevCenterId() == null) {
            return null;
        }
        PSDCWFEngineInstService pSDCWFEngineInstService = (PSDCWFEngineInstService)ServiceGlobal.getService(PSDCWFEngineInstService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDCWFEngineInstsLock;
        synchronized (n) {
            if (this.psdcwfengineinsts == null) {
                this.psdcwfengineinsts = pSDCWFEngineInstService.selectByPSDevCenter(this);
            }
            return this.psdcwfengineinsts;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDCWorkshopServer> getPSDCWorkshopServers() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCWorkshopServers();
        }
        if (this.getPSDevCenterId() == null) {
            return null;
        }
        PSDCWorkshopServerService pSDCWorkshopServerService = (PSDCWorkshopServerService)ServiceGlobal.getService(PSDCWorkshopServerService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDCWorkshopServersLock;
        synchronized (n) {
            if (this.psdcworkshopservers == null) {
                this.psdcworkshopservers = pSDCWorkshopServerService.selectByPSDevCenter(this);
            }
            return this.psdcworkshopservers;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSMavenRepo> getPSMavenRepos() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMavenRepos();
        }
        if (this.getPSDevCenterId() == null) {
            return null;
        }
        PSMavenRepoService pSMavenRepoService = (PSMavenRepoService)ServiceGlobal.getService(PSMavenRepoService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSMavenReposLock;
        synchronized (n) {
            if (this.psmavenrepos == null) {
                this.psmavenrepos = pSMavenRepoService.selectByPSDevCenter(this);
            }
            return this.psmavenrepos;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSStudioPlugin> getPSStudioPlugins() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSStudioPlugins();
        }
        if (this.getPSDevCenterId() == null) {
            return null;
        }
        PSStudioPluginService pSStudioPluginService = (PSStudioPluginService)ServiceGlobal.getService(PSStudioPluginService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSStudioPluginsLock;
        synchronized (n) {
            if (this.psstudioplugins == null) {
                this.psstudioplugins = pSStudioPluginService.selectByPSDevCenter(this);
            }
            return this.psstudioplugins;
        }
    }

    private PSDevCenterBase getProxyEntity() {
        return this.proxyPSDevCenterBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevCenterBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevCenterBase) {
            this.proxyPSDevCenterBase = (PSDevCenterBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DCAPIFLAG, 2);
        fieldIndexMap.put(FIELD_DCAPITOKEN, 3);
        fieldIndexMap.put(FIELD_DCLEVEL, 4);
        fieldIndexMap.put(FIELD_DCROWKEY, 5);
        fieldIndexMap.put(FIELD_DCTAG, 6);
        fieldIndexMap.put(FIELD_DCTAG2, 7);
        fieldIndexMap.put(FIELD_DCTAG3, 8);
        fieldIndexMap.put(FIELD_DCTAG4, 9);
        fieldIndexMap.put(FIELD_DCTYPE, 10);
        fieldIndexMap.put(FIELD_DOMAINNAME, 11);
        fieldIndexMap.put(FIELD_ENABLEDEPLOYCENTER, 12);
        fieldIndexMap.put(FIELD_ENABLEWORKSPACE, 13);
        fieldIndexMap.put(FIELD_ENABLEWSSERVER, 14);
        fieldIndexMap.put(FIELD_ENTITYCNT, 15);
        fieldIndexMap.put(FIELD_EXPERIENCE, 16);
        fieldIndexMap.put(FIELD_EXPIREDTIME, 17);
        fieldIndexMap.put(FIELD_FULLDOMAINNAME, 18);
        fieldIndexMap.put(FIELD_IPADDRS, 19);
        fieldIndexMap.put(FIELD_LICINFO, 20);
        fieldIndexMap.put(FIELD_LICKEY, 21);
        fieldIndexMap.put(FIELD_LINKIBIZ5FLAG, 22);
        fieldIndexMap.put(FIELD_MAXACTIVEUSERCNT, 23);
        fieldIndexMap.put(FIELD_MAXENTITYCNT, 24);
        fieldIndexMap.put(FIELD_MAXSYSCNT, 25);
        fieldIndexMap.put(FIELD_MEMO, 26);
        fieldIndexMap.put(FIELD_MOBCERTCHGTIME, 27);
        fieldIndexMap.put(FIELD_MOBTDCHGTIME, 28);
        fieldIndexMap.put(FIELD_PSDCINSTID, 29);
        fieldIndexMap.put(FIELD_PSDCINSTNAME, 30);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 31);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 32);
        fieldIndexMap.put(FIELD_PSPMSSERVERID, 33);
        fieldIndexMap.put(FIELD_PSPMSSERVERNAME, 34);
        fieldIndexMap.put(FIELD_PSRTWXACCOUNTID, 35);
        fieldIndexMap.put(FIELD_PSRTWXACCOUNTNAME, 36);
        fieldIndexMap.put(FIELD_PSSTUDIOSERVERGRPID, 37);
        fieldIndexMap.put(FIELD_PSSTUDIOSERVERGRPNAME, 38);
        fieldIndexMap.put(FIELD_PSSVNINSTREPOID, 39);
        fieldIndexMap.put(FIELD_PSSVNINSTREPONAME, 40);
        fieldIndexMap.put(FIELD_PSSVRDOMAINID, 41);
        fieldIndexMap.put(FIELD_PSSVRDOMAINNAME, 42);
        fieldIndexMap.put(FIELD_PSSVRPROVIDERID, 43);
        fieldIndexMap.put(FIELD_PSSVRPROVIDERNAME, 44);
        fieldIndexMap.put(FIELD_ROBOTCHGTIME, 45);
        fieldIndexMap.put(FIELD_ROPSSVNINSTREPOID, 46);
        fieldIndexMap.put(FIELD_ROPSSVNINSTREPONAME, 47);
        fieldIndexMap.put(FIELD_SPFLAG, 48);
        fieldIndexMap.put(FIELD_STUDIOTAG, 49);
        fieldIndexMap.put(FIELD_STUDIOTAG2, 50);
        fieldIndexMap.put(FIELD_STUDIOVER, 51);
        fieldIndexMap.put(FIELD_SYSAPIFLAG, 52);
        fieldIndexMap.put(FIELD_SYSCNT, 53);
        fieldIndexMap.put(FIELD_SYSSN, 54);
        fieldIndexMap.put(FIELD_TOTALENERGY, 55);
        fieldIndexMap.put(FIELD_UPDATEDATE, 56);
        fieldIndexMap.put(FIELD_UPDATEMAN, 57);
        fieldIndexMap.put(FIELD_V6PSSVNINSTREPOID, 58);
        fieldIndexMap.put(FIELD_V6PSSVNINSTREPONAME, 59);
        fieldIndexMap.put(FIELD_VALIDFLAG, 60);
        fieldIndexMap.put(FIELD_WEBFOLDER, 61);
        fieldIndexMap.put(FIELD_WEBSITEURL, 62);
        fieldIndexMap.put(FIELD_WXDEPTID, 63);
    }
}

