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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCContainerSpec;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCDeployServer;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCFile;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRegistryRepo;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVN;
import net.ibizsys.pscore.srv.devcenter.service.PSDCClusterService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCContainerSpecService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCDeployServerService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCFileService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCRegistryRepoService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCredential;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDeployCenter;
import net.ibizsys.pscore.srv.paasmgr.service.PSCredentialService;
import net.ibizsys.pscore.srv.paasmgr.service.PSDeployCenterService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCDeployCenterBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCDeployCenterBase.class);
    public static final String FIELD_ADMINPASSWD = "ADMINPASSWD";
    public static final String FIELD_ADMINUSERNAME = "ADMINUSERNAME";
    public static final String FIELD_APITOKEN = "APITOKEN";
    public static final String FIELD_APIURL = "APIURL";
    public static final String FIELD_CFGBRANCH = "CFGBRANCH";
    public static final String FIELD_CFGPSCREDENTIALID = "CFGPSCREDENTIALID";
    public static final String FIELD_CFGPSCREDENTIALNAME = "CFGPSCREDENTIALNAME";
    public static final String FIELD_CFGPSDEVCENTERSVNID = "CFGPSDEVCENTERSVNID";
    public static final String FIELD_CFGPSDEVCENTERSVNNAME = "CFGPSDEVCENTERSVNNAME";
    public static final String FIELD_CFGURL = "CFGURL";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DCTYPE = "DCTYPE";
    public static final String FIELD_DCTYPE2 = "DCTYPE2";
    public static final String FIELD_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String FIELD_EXPRIEDTIME = "EXPRIEDTIME";
    public static final String FIELD_IPADDR = "IPADDR";
    public static final String FIELD_IPADDR2 = "IPADDR2";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PASSWD = "PASSWD";
    public static final String FIELD_PORT = "PORT";
    public static final String FIELD_PSCREDENTIALID = "PSCREDENTIALID";
    public static final String FIELD_PSCREDENTIALNAME = "PSCREDENTIALNAME";
    public static final String FIELD_PSCREDENTIALS = "PSCREDENTIALS";
    public static final String FIELD_PSDCCLUSTERID = "PSDCCLUSTERID";
    public static final String FIELD_PSDCCLUSTERNAME = "PSDCCLUSTERNAME";
    public static final String FIELD_PSDCCONTAINERSPECID = "PSDCCONTAINERSPECID";
    public static final String FIELD_PSDCCONTAINERSPECNAME = "PSDCCONTAINERSPECNAME";
    public static final String FIELD_PSDCDEPLOYCENTERID = "PSDCDEPLOYCENTERID";
    public static final String FIELD_PSDCDEPLOYCENTERNAME = "PSDCDEPLOYCENTERNAME";
    public static final String FIELD_PSDCFILEID = "PSDCFILEID";
    public static final String FIELD_PSDCFILENAME = "PSDCFILENAME";
    public static final String FIELD_PSDCREGISTRYREPOID = "PSDCREGISTRYREPOID";
    public static final String FIELD_PSDCREGISTRYREPONAME = "PSDCREGISTRYREPONAME";
    public static final String FIELD_PSDEPLOYCENTERID = "PSDEPLOYCENTERID";
    public static final String FIELD_PSDEPLOYCENTERNAME = "PSDEPLOYCENTERNAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String FIELD_PSGITUSERS = "PSGITUSERS";
    public static final String FIELD_REFCOUNT = "REFCOUNT";
    public static final String FIELD_RESPOS = "RESPOS";
    public static final String FIELD_RESREADYTIME = "RESREADYTIME";
    public static final String FIELD_RESSTATE = "RESSTATE";
    public static final String FIELD_RESVER = "RESVER";
    public static final String FIELD_SSHIPADDR = "SSHIPADDR";
    public static final String FIELD_SSHPORT = "SSHPORT";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_UPLOADFILEMODE = "UPLOADFILEMODE";
    public static final String FIELD_UPLOADPATH = "UPLOADPATH";
    public static final String FIELD_USERNAME = "USERNAME";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_WEBCONSOLEPATH = "WEBCONSOLEPATH";
    public static final String FIELD_WORKSHOPPATH = "WORKSHOPPATH";
    private static final int INDEX_ADMINPASSWD = 0;
    private static final int INDEX_ADMINUSERNAME = 1;
    private static final int INDEX_APITOKEN = 2;
    private static final int INDEX_APIURL = 3;
    private static final int INDEX_CFGBRANCH = 4;
    private static final int INDEX_CFGPSCREDENTIALID = 5;
    private static final int INDEX_CFGPSCREDENTIALNAME = 6;
    private static final int INDEX_CFGPSDEVCENTERSVNID = 7;
    private static final int INDEX_CFGPSDEVCENTERSVNNAME = 8;
    private static final int INDEX_CFGURL = 9;
    private static final int INDEX_CREATEDATE = 10;
    private static final int INDEX_CREATEMAN = 11;
    private static final int INDEX_DCTYPE = 12;
    private static final int INDEX_DCTYPE2 = 13;
    private static final int INDEX_DEFAULTFLAG = 14;
    private static final int INDEX_EXPRIEDTIME = 15;
    private static final int INDEX_IPADDR = 16;
    private static final int INDEX_IPADDR2 = 17;
    private static final int INDEX_MEMO = 18;
    private static final int INDEX_PASSWD = 19;
    private static final int INDEX_PORT = 20;
    private static final int INDEX_PSCREDENTIALID = 21;
    private static final int INDEX_PSCREDENTIALNAME = 22;
    private static final int INDEX_PSCREDENTIALS = 23;
    private static final int INDEX_PSDCCLUSTERID = 24;
    private static final int INDEX_PSDCCLUSTERNAME = 25;
    private static final int INDEX_PSDCCONTAINERSPECID = 26;
    private static final int INDEX_PSDCCONTAINERSPECNAME = 27;
    private static final int INDEX_PSDCDEPLOYCENTERID = 28;
    private static final int INDEX_PSDCDEPLOYCENTERNAME = 29;
    private static final int INDEX_PSDCFILEID = 30;
    private static final int INDEX_PSDCFILENAME = 31;
    private static final int INDEX_PSDCREGISTRYREPOID = 32;
    private static final int INDEX_PSDCREGISTRYREPONAME = 33;
    private static final int INDEX_PSDEPLOYCENTERID = 34;
    private static final int INDEX_PSDEPLOYCENTERNAME = 35;
    private static final int INDEX_PSDEVCENTERID = 36;
    private static final int INDEX_PSDEVCENTERNAME = 37;
    private static final int INDEX_PSDEVSLNID = 38;
    private static final int INDEX_PSDEVSLNNAME = 39;
    private static final int INDEX_PSGITUSERS = 40;
    private static final int INDEX_REFCOUNT = 41;
    private static final int INDEX_RESPOS = 42;
    private static final int INDEX_RESREADYTIME = 43;
    private static final int INDEX_RESSTATE = 44;
    private static final int INDEX_RESVER = 45;
    private static final int INDEX_SSHIPADDR = 46;
    private static final int INDEX_SSHPORT = 47;
    private static final int INDEX_UPDATEDATE = 48;
    private static final int INDEX_UPDATEMAN = 49;
    private static final int INDEX_UPLOADFILEMODE = 50;
    private static final int INDEX_UPLOADPATH = 51;
    private static final int INDEX_USERNAME = 52;
    private static final int INDEX_VALIDFLAG = 53;
    private static final int INDEX_WEBCONSOLEPATH = 54;
    private static final int INDEX_WORKSHOPPATH = 55;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCDeployCenterBase proxyPSDCDeployCenterBase = null;
    private boolean adminpasswdDirtyFlag = false;
    private boolean adminusernameDirtyFlag = false;
    private boolean apitokenDirtyFlag = false;
    private boolean apiurlDirtyFlag = false;
    private boolean cfgbranchDirtyFlag = false;
    private boolean cfgpscredentialidDirtyFlag = false;
    private boolean cfgpscredentialnameDirtyFlag = false;
    private boolean cfgpsdevcentersvnidDirtyFlag = false;
    private boolean cfgpsdevcentersvnnameDirtyFlag = false;
    private boolean cfgurlDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dctypeDirtyFlag = false;
    private boolean dctype2DirtyFlag = false;
    private boolean defaultflagDirtyFlag = false;
    private boolean expriedtimeDirtyFlag = false;
    private boolean ipaddrDirtyFlag = false;
    private boolean ipaddr2DirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean passwdDirtyFlag = false;
    private boolean portDirtyFlag = false;
    private boolean pscredentialidDirtyFlag = false;
    private boolean pscredentialnameDirtyFlag = false;
    private boolean pscredentialsDirtyFlag = false;
    private boolean psdcclusteridDirtyFlag = false;
    private boolean psdcclusternameDirtyFlag = false;
    private boolean psdccontainerspecidDirtyFlag = false;
    private boolean psdccontainerspecnameDirtyFlag = false;
    private boolean psdcdeploycenteridDirtyFlag = false;
    private boolean psdcdeploycenternameDirtyFlag = false;
    private boolean psdcfileidDirtyFlag = false;
    private boolean psdcfilenameDirtyFlag = false;
    private boolean psdcregistryrepoidDirtyFlag = false;
    private boolean psdcregistryreponameDirtyFlag = false;
    private boolean psdeploycenteridDirtyFlag = false;
    private boolean psdeploycenternameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnnameDirtyFlag = false;
    private boolean psgitusersDirtyFlag = false;
    private boolean refcountDirtyFlag = false;
    private boolean resposDirtyFlag = false;
    private boolean resreadytimeDirtyFlag = false;
    private boolean resstateDirtyFlag = false;
    private boolean resverDirtyFlag = false;
    private boolean sshipaddrDirtyFlag = false;
    private boolean sshportDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean uploadfilemodeDirtyFlag = false;
    private boolean uploadpathDirtyFlag = false;
    private boolean usernameDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean webconsolepathDirtyFlag = false;
    private boolean workshoppathDirtyFlag = false;
    @Column(name="adminpasswd")
    private String adminpasswd;
    @Column(name="adminusername")
    private String adminusername;
    @Column(name="apitoken")
    private String apitoken;
    @Column(name="apiurl")
    private String apiurl;
    @Column(name="cfgbranch")
    private String cfgbranch;
    @Column(name="cfgpscredentialid")
    private String cfgpscredentialid;
    @Column(name="cfgpscredentialname")
    private String cfgpscredentialname;
    @Column(name="cfgpsdevcentersvnid")
    private String cfgpsdevcentersvnid;
    @Column(name="cfgpsdevcentersvnname")
    private String cfgpsdevcentersvnname;
    @Column(name="cfgurl")
    private String cfgurl;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dctype")
    private String dctype;
    @Column(name="dctype2")
    private String dctype2;
    @Column(name="defaultflag")
    private Integer defaultflag;
    @Column(name="expriedtime")
    private Timestamp expriedtime;
    @Column(name="ipaddr")
    private String ipaddr;
    @Column(name="ipaddr2")
    private String ipaddr2;
    @Column(name="memo")
    private String memo;
    @Column(name="passwd")
    private String passwd;
    @Column(name="port")
    private Integer port;
    @Column(name="pscredentialid")
    private String pscredentialid;
    @Column(name="pscredentialname")
    private String pscredentialname;
    @Column(name="pscredentials")
    private String pscredentials;
    @Column(name="psdcclusterid")
    private String psdcclusterid;
    @Column(name="psdcclustername")
    private String psdcclustername;
    @Column(name="psdccontainerspecid")
    private String psdccontainerspecid;
    @Column(name="psdccontainerspecname")
    private String psdccontainerspecname;
    @Column(name="psdcdeploycenterid")
    private String psdcdeploycenterid;
    @Column(name="psdcdeploycentername")
    private String psdcdeploycentername;
    @Column(name="psdcfileid")
    private String psdcfileid;
    @Column(name="psdcfilename")
    private String psdcfilename;
    @Column(name="psdcregistryrepoid")
    private String psdcregistryrepoid;
    @Column(name="psdcregistryreponame")
    private String psdcregistryreponame;
    @Column(name="psdeploycenterid")
    private String psdeploycenterid;
    @Column(name="psdeploycentername")
    private String psdeploycentername;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnname")
    private String psdevslnname;
    @Column(name="psgitusers")
    private String psgitusers;
    @Column(name="refcount")
    private Integer refcount;
    @Column(name="respos")
    private Integer respos;
    @Column(name="resreadytime")
    private Timestamp resreadytime;
    @Column(name="resstate")
    private Integer resstate;
    @Column(name="resver")
    private Integer resver;
    @Column(name="sshipaddr")
    private String sshipaddr;
    @Column(name="sshport")
    private Integer sshport;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="uploadfilemode")
    private String uploadfilemode;
    @Column(name="uploadpath")
    private String uploadpath;
    @Column(name="username")
    private String username;
    @Column(name="validflag")
    private Integer validflag;
    @Column(name="webconsolepath")
    private String webconsolepath;
    @Column(name="workshoppath")
    private String workshoppath;
    private Integer objCfgPSCredentialLock = new Integer(1);
    private PSCredential cfgpscredential = null;
    private Integer objPSCredentialLock = new Integer(1);
    private PSCredential pscredential = null;
    private Integer objPSDCClusterLock = new Integer(1);
    private PSDCCluster psdccluster = null;
    private Integer objPSDCContainerSpecLock = new Integer(1);
    private PSDCContainerSpec psdccontainerspec = null;
    private Integer objPSDCFileLock = new Integer(1);
    private PSDCFile psdcfile = null;
    private Integer objPSDCRegistryRepoLock = new Integer(1);
    private PSDCRegistryRepo psdcregistryrepo = null;
    private Integer objPSDeployCenterLock = new Integer(1);
    private PSDeployCenter psdeploycenter = null;
    private Integer objCfgPSDevCenterSVNLock = new Integer(1);
    private PSDevCenterSVN cfgpsdevcentersvn = null;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSDevSlnLock = new Integer(1);
    private PSDevSln psdevsln = null;
    private Integer objPSDCDeployServersLock = new Integer(1);
    private ArrayList<PSDCDeployServer> psdcdeployservers = null;

    public void setAdminPasswd(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAdminPasswd(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.adminpasswd = string;
        this.adminpasswdDirtyFlag = true;
    }

    public String getAdminPasswd() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAdminPasswd();
        }
        return this.adminpasswd;
    }

    public boolean isAdminPasswdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAdminPasswdDirty();
        }
        return this.adminpasswdDirtyFlag;
    }

    public void resetAdminPasswd() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAdminPasswd();
            return;
        }
        this.adminpasswdDirtyFlag = false;
        this.adminpasswd = null;
    }

    public void setAdminUserName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAdminUserName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.adminusername = string;
        this.adminusernameDirtyFlag = true;
    }

    public String getAdminUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAdminUserName();
        }
        return this.adminusername;
    }

    public boolean isAdminUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAdminUserNameDirty();
        }
        return this.adminusernameDirtyFlag;
    }

    public void resetAdminUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAdminUserName();
            return;
        }
        this.adminusernameDirtyFlag = false;
        this.adminusername = null;
    }

    public void setAPIToken(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAPIToken(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.apitoken = string;
        this.apitokenDirtyFlag = true;
    }

    public String getAPIToken() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAPIToken();
        }
        return this.apitoken;
    }

    public boolean isAPITokenDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAPITokenDirty();
        }
        return this.apitokenDirtyFlag;
    }

    public void resetAPIToken() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAPIToken();
            return;
        }
        this.apitokenDirtyFlag = false;
        this.apitoken = null;
    }

    public void setAPIUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAPIUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.apiurl = string;
        this.apiurlDirtyFlag = true;
    }

    public String getAPIUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAPIUrl();
        }
        return this.apiurl;
    }

    public boolean isAPIUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAPIUrlDirty();
        }
        return this.apiurlDirtyFlag;
    }

    public void resetAPIUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAPIUrl();
            return;
        }
        this.apiurlDirtyFlag = false;
        this.apiurl = null;
    }

    public void setCfgBranch(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCfgBranch(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cfgbranch = string;
        this.cfgbranchDirtyFlag = true;
    }

    public String getCfgBranch() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCfgBranch();
        }
        return this.cfgbranch;
    }

    public boolean isCfgBranchDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCfgBranchDirty();
        }
        return this.cfgbranchDirtyFlag;
    }

    public void resetCfgBranch() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCfgBranch();
            return;
        }
        this.cfgbranchDirtyFlag = false;
        this.cfgbranch = null;
    }

    public void setCfgPSCredentialId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCfgPSCredentialId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cfgpscredentialid = string;
        this.cfgpscredentialidDirtyFlag = true;
    }

    public String getCfgPSCredentialId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCfgPSCredentialId();
        }
        return this.cfgpscredentialid;
    }

    public boolean isCfgPSCredentialIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCfgPSCredentialIdDirty();
        }
        return this.cfgpscredentialidDirtyFlag;
    }

    public void resetCfgPSCredentialId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCfgPSCredentialId();
            return;
        }
        this.cfgpscredentialidDirtyFlag = false;
        this.cfgpscredentialid = null;
    }

    public void setCfgPSCredentialName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCfgPSCredentialName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cfgpscredentialname = string;
        this.cfgpscredentialnameDirtyFlag = true;
    }

    public String getCfgPSCredentialName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCfgPSCredentialName();
        }
        return this.cfgpscredentialname;
    }

    public boolean isCfgPSCredentialNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCfgPSCredentialNameDirty();
        }
        return this.cfgpscredentialnameDirtyFlag;
    }

    public void resetCfgPSCredentialName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCfgPSCredentialName();
            return;
        }
        this.cfgpscredentialnameDirtyFlag = false;
        this.cfgpscredentialname = null;
    }

    public void setCfgPSDevCenterSVNId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCfgPSDevCenterSVNId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cfgpsdevcentersvnid = string;
        this.cfgpsdevcentersvnidDirtyFlag = true;
    }

    public String getCfgPSDevCenterSVNId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCfgPSDevCenterSVNId();
        }
        return this.cfgpsdevcentersvnid;
    }

    public boolean isCfgPSDevCenterSVNIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCfgPSDevCenterSVNIdDirty();
        }
        return this.cfgpsdevcentersvnidDirtyFlag;
    }

    public void resetCfgPSDevCenterSVNId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCfgPSDevCenterSVNId();
            return;
        }
        this.cfgpsdevcentersvnidDirtyFlag = false;
        this.cfgpsdevcentersvnid = null;
    }

    public void setCfgPSDevCenterSVNName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCfgPSDevCenterSVNName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cfgpsdevcentersvnname = string;
        this.cfgpsdevcentersvnnameDirtyFlag = true;
    }

    public String getCfgPSDevCenterSVNName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCfgPSDevCenterSVNName();
        }
        return this.cfgpsdevcentersvnname;
    }

    public boolean isCfgPSDevCenterSVNNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCfgPSDevCenterSVNNameDirty();
        }
        return this.cfgpsdevcentersvnnameDirtyFlag;
    }

    public void resetCfgPSDevCenterSVNName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCfgPSDevCenterSVNName();
            return;
        }
        this.cfgpsdevcentersvnnameDirtyFlag = false;
        this.cfgpsdevcentersvnname = null;
    }

    public void setCfgUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCfgUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cfgurl = string;
        this.cfgurlDirtyFlag = true;
    }

    public String getCfgUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCfgUrl();
        }
        return this.cfgurl;
    }

    public boolean isCfgUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCfgUrlDirty();
        }
        return this.cfgurlDirtyFlag;
    }

    public void resetCfgUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCfgUrl();
            return;
        }
        this.cfgurlDirtyFlag = false;
        this.cfgurl = null;
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

    public void setDCType2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDCType2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dctype2 = string;
        this.dctype2DirtyFlag = true;
    }

    public String getDCType2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDCType2();
        }
        return this.dctype2;
    }

    public boolean isDCType2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDCType2Dirty();
        }
        return this.dctype2DirtyFlag;
    }

    public void resetDCType2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDCType2();
            return;
        }
        this.dctype2DirtyFlag = false;
        this.dctype2 = null;
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

    public void setExpriedTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExpriedTime(timestamp);
            return;
        }
        this.expriedtime = timestamp;
        this.expriedtimeDirtyFlag = true;
    }

    public Timestamp getExpriedTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExpriedTime();
        }
        return this.expriedtime;
    }

    public boolean isExpriedTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExpriedTimeDirty();
        }
        return this.expriedtimeDirtyFlag;
    }

    public void resetExpriedTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExpriedTime();
            return;
        }
        this.expriedtimeDirtyFlag = false;
        this.expriedtime = null;
    }

    public void setIpAddr(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIpAddr(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ipaddr = string;
        this.ipaddrDirtyFlag = true;
    }

    public String getIpAddr() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIpAddr();
        }
        return this.ipaddr;
    }

    public boolean isIpAddrDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIpAddrDirty();
        }
        return this.ipaddrDirtyFlag;
    }

    public void resetIpAddr() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIpAddr();
            return;
        }
        this.ipaddrDirtyFlag = false;
        this.ipaddr = null;
    }

    public void setIpAddr2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIpAddr2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ipaddr2 = string;
        this.ipaddr2DirtyFlag = true;
    }

    public String getIpAddr2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIpAddr2();
        }
        return this.ipaddr2;
    }

    public boolean isIpAddr2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIpAddr2Dirty();
        }
        return this.ipaddr2DirtyFlag;
    }

    public void resetIpAddr2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIpAddr2();
            return;
        }
        this.ipaddr2DirtyFlag = false;
        this.ipaddr2 = null;
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

    public void setPasswd(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPasswd(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.passwd = string;
        this.passwdDirtyFlag = true;
    }

    public String getPasswd() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPasswd();
        }
        return this.passwd;
    }

    public boolean isPasswdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPasswdDirty();
        }
        return this.passwdDirtyFlag;
    }

    public void resetPasswd() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPasswd();
            return;
        }
        this.passwdDirtyFlag = false;
        this.passwd = null;
    }

    public void setPort(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPort(n);
            return;
        }
        this.port = n;
        this.portDirtyFlag = true;
    }

    public Integer getPort() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPort();
        }
        return this.port;
    }

    public boolean isPortDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPortDirty();
        }
        return this.portDirtyFlag;
    }

    public void resetPort() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPort();
            return;
        }
        this.portDirtyFlag = false;
        this.port = null;
    }

    public void setPSCredentialId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCredentialId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscredentialid = string;
        this.pscredentialidDirtyFlag = true;
    }

    public String getPSCredentialId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCredentialId();
        }
        return this.pscredentialid;
    }

    public boolean isPSCredentialIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCredentialIdDirty();
        }
        return this.pscredentialidDirtyFlag;
    }

    public void resetPSCredentialId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCredentialId();
            return;
        }
        this.pscredentialidDirtyFlag = false;
        this.pscredentialid = null;
    }

    public void setPSCredentialName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCredentialName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscredentialname = string;
        this.pscredentialnameDirtyFlag = true;
    }

    public String getPSCredentialName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCredentialName();
        }
        return this.pscredentialname;
    }

    public boolean isPSCredentialNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCredentialNameDirty();
        }
        return this.pscredentialnameDirtyFlag;
    }

    public void resetPSCredentialName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCredentialName();
            return;
        }
        this.pscredentialnameDirtyFlag = false;
        this.pscredentialname = null;
    }

    public void setPSCredentials(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCredentials(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscredentials = string;
        this.pscredentialsDirtyFlag = true;
    }

    public String getPSCredentials() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCredentials();
        }
        return this.pscredentials;
    }

    public boolean isPSCredentialsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCredentialsDirty();
        }
        return this.pscredentialsDirtyFlag;
    }

    public void resetPSCredentials() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCredentials();
            return;
        }
        this.pscredentialsDirtyFlag = false;
        this.pscredentials = null;
    }

    public void setPSDCClusterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCClusterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcclusterid = string;
        this.psdcclusteridDirtyFlag = true;
    }

    public String getPSDCClusterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCClusterId();
        }
        return this.psdcclusterid;
    }

    public boolean isPSDCClusterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCClusterIdDirty();
        }
        return this.psdcclusteridDirtyFlag;
    }

    public void resetPSDCClusterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCClusterId();
            return;
        }
        this.psdcclusteridDirtyFlag = false;
        this.psdcclusterid = null;
    }

    public void setPSDCClusterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCClusterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcclustername = string;
        this.psdcclusternameDirtyFlag = true;
    }

    public String getPSDCClusterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCClusterName();
        }
        return this.psdcclustername;
    }

    public boolean isPSDCClusterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCClusterNameDirty();
        }
        return this.psdcclusternameDirtyFlag;
    }

    public void resetPSDCClusterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCClusterName();
            return;
        }
        this.psdcclusternameDirtyFlag = false;
        this.psdcclustername = null;
    }

    public void setPSDCContainerSpecId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCContainerSpecId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdccontainerspecid = string;
        this.psdccontainerspecidDirtyFlag = true;
    }

    public String getPSDCContainerSpecId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCContainerSpecId();
        }
        return this.psdccontainerspecid;
    }

    public boolean isPSDCContainerSpecIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCContainerSpecIdDirty();
        }
        return this.psdccontainerspecidDirtyFlag;
    }

    public void resetPSDCContainerSpecId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCContainerSpecId();
            return;
        }
        this.psdccontainerspecidDirtyFlag = false;
        this.psdccontainerspecid = null;
    }

    public void setPSDCContainerSpecName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCContainerSpecName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdccontainerspecname = string;
        this.psdccontainerspecnameDirtyFlag = true;
    }

    public String getPSDCContainerSpecName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCContainerSpecName();
        }
        return this.psdccontainerspecname;
    }

    public boolean isPSDCContainerSpecNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCContainerSpecNameDirty();
        }
        return this.psdccontainerspecnameDirtyFlag;
    }

    public void resetPSDCContainerSpecName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCContainerSpecName();
            return;
        }
        this.psdccontainerspecnameDirtyFlag = false;
        this.psdccontainerspecname = null;
    }

    public void setPSDCDeployCenterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCDeployCenterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcdeploycenterid = string;
        this.psdcdeploycenteridDirtyFlag = true;
    }

    public String getPSDCDeployCenterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCDeployCenterId();
        }
        return this.psdcdeploycenterid;
    }

    public boolean isPSDCDeployCenterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCDeployCenterIdDirty();
        }
        return this.psdcdeploycenteridDirtyFlag;
    }

    public void resetPSDCDeployCenterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCDeployCenterId();
            return;
        }
        this.psdcdeploycenteridDirtyFlag = false;
        this.psdcdeploycenterid = null;
    }

    public void setPSDCDeployCenterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCDeployCenterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcdeploycentername = string;
        this.psdcdeploycenternameDirtyFlag = true;
    }

    public String getPSDCDeployCenterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCDeployCenterName();
        }
        return this.psdcdeploycentername;
    }

    public boolean isPSDCDeployCenterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCDeployCenterNameDirty();
        }
        return this.psdcdeploycenternameDirtyFlag;
    }

    public void resetPSDCDeployCenterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCDeployCenterName();
            return;
        }
        this.psdcdeploycenternameDirtyFlag = false;
        this.psdcdeploycentername = null;
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

    public void setPSDeployCenterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDeployCenterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeploycenterid = string;
        this.psdeploycenteridDirtyFlag = true;
    }

    public String getPSDeployCenterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDeployCenterId();
        }
        return this.psdeploycenterid;
    }

    public boolean isPSDeployCenterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDeployCenterIdDirty();
        }
        return this.psdeploycenteridDirtyFlag;
    }

    public void resetPSDeployCenterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDeployCenterId();
            return;
        }
        this.psdeploycenteridDirtyFlag = false;
        this.psdeploycenterid = null;
    }

    public void setPSDeployCenterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDeployCenterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeploycentername = string;
        this.psdeploycenternameDirtyFlag = true;
    }

    public String getPSDeployCenterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDeployCenterName();
        }
        return this.psdeploycentername;
    }

    public boolean isPSDeployCenterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDeployCenterNameDirty();
        }
        return this.psdeploycenternameDirtyFlag;
    }

    public void resetPSDeployCenterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDeployCenterName();
            return;
        }
        this.psdeploycenternameDirtyFlag = false;
        this.psdeploycentername = null;
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

    public void setPSDevSlnName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnname = string;
        this.psdevslnnameDirtyFlag = true;
    }

    public String getPSDevSlnName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnName();
        }
        return this.psdevslnname;
    }

    public boolean isPSDevSlnNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnNameDirty();
        }
        return this.psdevslnnameDirtyFlag;
    }

    public void resetPSDevSlnName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnName();
            return;
        }
        this.psdevslnnameDirtyFlag = false;
        this.psdevslnname = null;
    }

    public void setPSGitUsers(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSGitUsers(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psgitusers = string;
        this.psgitusersDirtyFlag = true;
    }

    public String getPSGitUsers() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSGitUsers();
        }
        return this.psgitusers;
    }

    public boolean isPSGitUsersDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSGitUsersDirty();
        }
        return this.psgitusersDirtyFlag;
    }

    public void resetPSGitUsers() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSGitUsers();
            return;
        }
        this.psgitusersDirtyFlag = false;
        this.psgitusers = null;
    }

    public void setRefCount(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefCount(n);
            return;
        }
        this.refcount = n;
        this.refcountDirtyFlag = true;
    }

    public Integer getRefCount() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefCount();
        }
        return this.refcount;
    }

    public boolean isRefCountDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefCountDirty();
        }
        return this.refcountDirtyFlag;
    }

    public void resetRefCount() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefCount();
            return;
        }
        this.refcountDirtyFlag = false;
        this.refcount = null;
    }

    public void setResPos(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResPos(n);
            return;
        }
        this.respos = n;
        this.resposDirtyFlag = true;
    }

    public Integer getResPos() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResPos();
        }
        return this.respos;
    }

    public boolean isResPosDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResPosDirty();
        }
        return this.resposDirtyFlag;
    }

    public void resetResPos() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResPos();
            return;
        }
        this.resposDirtyFlag = false;
        this.respos = null;
    }

    public void setResReadyTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResReadyTime(timestamp);
            return;
        }
        this.resreadytime = timestamp;
        this.resreadytimeDirtyFlag = true;
    }

    public Timestamp getResReadyTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResReadyTime();
        }
        return this.resreadytime;
    }

    public boolean isResReadyTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResReadyTimeDirty();
        }
        return this.resreadytimeDirtyFlag;
    }

    public void resetResReadyTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResReadyTime();
            return;
        }
        this.resreadytimeDirtyFlag = false;
        this.resreadytime = null;
    }

    public void setResState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResState(n);
            return;
        }
        this.resstate = n;
        this.resstateDirtyFlag = true;
    }

    public Integer getResState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResState();
        }
        return this.resstate;
    }

    public boolean isResStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResStateDirty();
        }
        return this.resstateDirtyFlag;
    }

    public void resetResState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResState();
            return;
        }
        this.resstateDirtyFlag = false;
        this.resstate = null;
    }

    public void setResVer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResVer(n);
            return;
        }
        this.resver = n;
        this.resverDirtyFlag = true;
    }

    public Integer getResVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResVer();
        }
        return this.resver;
    }

    public boolean isResVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResVerDirty();
        }
        return this.resverDirtyFlag;
    }

    public void resetResVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResVer();
            return;
        }
        this.resverDirtyFlag = false;
        this.resver = null;
    }

    public void setSSHIPAddr(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSSHIPAddr(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sshipaddr = string;
        this.sshipaddrDirtyFlag = true;
    }

    public String getSSHIPAddr() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSSHIPAddr();
        }
        return this.sshipaddr;
    }

    public boolean isSSHIPAddrDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSSHIPAddrDirty();
        }
        return this.sshipaddrDirtyFlag;
    }

    public void resetSSHIPAddr() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSSHIPAddr();
            return;
        }
        this.sshipaddrDirtyFlag = false;
        this.sshipaddr = null;
    }

    public void setSSHPort(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSSHPort(n);
            return;
        }
        this.sshport = n;
        this.sshportDirtyFlag = true;
    }

    public Integer getSSHPort() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSSHPort();
        }
        return this.sshport;
    }

    public boolean isSSHPortDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSSHPortDirty();
        }
        return this.sshportDirtyFlag;
    }

    public void resetSSHPort() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSSHPort();
            return;
        }
        this.sshportDirtyFlag = false;
        this.sshport = null;
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

    public void setUploadFileMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUploadFileMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uploadfilemode = string;
        this.uploadfilemodeDirtyFlag = true;
    }

    public String getUploadFileMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUploadFileMode();
        }
        return this.uploadfilemode;
    }

    public boolean isUploadFileModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUploadFileModeDirty();
        }
        return this.uploadfilemodeDirtyFlag;
    }

    public void resetUploadFileMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUploadFileMode();
            return;
        }
        this.uploadfilemodeDirtyFlag = false;
        this.uploadfilemode = null;
    }

    public void setUploadPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUploadPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uploadpath = string;
        this.uploadpathDirtyFlag = true;
    }

    public String getUploadPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUploadPath();
        }
        return this.uploadpath;
    }

    public boolean isUploadPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUploadPathDirty();
        }
        return this.uploadpathDirtyFlag;
    }

    public void resetUploadPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUploadPath();
            return;
        }
        this.uploadpathDirtyFlag = false;
        this.uploadpath = null;
    }

    public void setUserName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.username = string;
        this.usernameDirtyFlag = true;
    }

    public String getUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserName();
        }
        return this.username;
    }

    public boolean isUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserNameDirty();
        }
        return this.usernameDirtyFlag;
    }

    public void resetUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserName();
            return;
        }
        this.usernameDirtyFlag = false;
        this.username = null;
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

    public void setWebConsolePath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWebConsolePath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.webconsolepath = string;
        this.webconsolepathDirtyFlag = true;
    }

    public String getWebConsolePath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWebConsolePath();
        }
        return this.webconsolepath;
    }

    public boolean isWebConsolePathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWebConsolePathDirty();
        }
        return this.webconsolepathDirtyFlag;
    }

    public void resetWebConsolePath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWebConsolePath();
            return;
        }
        this.webconsolepathDirtyFlag = false;
        this.webconsolepath = null;
    }

    public void setWorkshopPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWorkshopPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.workshoppath = string;
        this.workshoppathDirtyFlag = true;
    }

    public String getWorkshopPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWorkshopPath();
        }
        return this.workshoppath;
    }

    public boolean isWorkshopPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWorkshopPathDirty();
        }
        return this.workshoppathDirtyFlag;
    }

    public void resetWorkshopPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWorkshopPath();
            return;
        }
        this.workshoppathDirtyFlag = false;
        this.workshoppath = null;
    }

    protected void onReset() {
        PSDCDeployCenterBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCDeployCenterBase pSDCDeployCenterBase) {
        pSDCDeployCenterBase.resetAdminPasswd();
        pSDCDeployCenterBase.resetAdminUserName();
        pSDCDeployCenterBase.resetAPIToken();
        pSDCDeployCenterBase.resetAPIUrl();
        pSDCDeployCenterBase.resetCfgBranch();
        pSDCDeployCenterBase.resetCfgPSCredentialId();
        pSDCDeployCenterBase.resetCfgPSCredentialName();
        pSDCDeployCenterBase.resetCfgPSDevCenterSVNId();
        pSDCDeployCenterBase.resetCfgPSDevCenterSVNName();
        pSDCDeployCenterBase.resetCfgUrl();
        pSDCDeployCenterBase.resetCreateDate();
        pSDCDeployCenterBase.resetCreateMan();
        pSDCDeployCenterBase.resetDCType();
        pSDCDeployCenterBase.resetDCType2();
        pSDCDeployCenterBase.resetDefaultFlag();
        pSDCDeployCenterBase.resetExpriedTime();
        pSDCDeployCenterBase.resetIpAddr();
        pSDCDeployCenterBase.resetIpAddr2();
        pSDCDeployCenterBase.resetMemo();
        pSDCDeployCenterBase.resetPasswd();
        pSDCDeployCenterBase.resetPort();
        pSDCDeployCenterBase.resetPSCredentialId();
        pSDCDeployCenterBase.resetPSCredentialName();
        pSDCDeployCenterBase.resetPSCredentials();
        pSDCDeployCenterBase.resetPSDCClusterId();
        pSDCDeployCenterBase.resetPSDCClusterName();
        pSDCDeployCenterBase.resetPSDCContainerSpecId();
        pSDCDeployCenterBase.resetPSDCContainerSpecName();
        pSDCDeployCenterBase.resetPSDCDeployCenterId();
        pSDCDeployCenterBase.resetPSDCDeployCenterName();
        pSDCDeployCenterBase.resetPSDCFileId();
        pSDCDeployCenterBase.resetPSDCFileName();
        pSDCDeployCenterBase.resetPSDCRegistryRepoId();
        pSDCDeployCenterBase.resetPSDCRegistryRepoName();
        pSDCDeployCenterBase.resetPSDeployCenterId();
        pSDCDeployCenterBase.resetPSDeployCenterName();
        pSDCDeployCenterBase.resetPSDevCenterId();
        pSDCDeployCenterBase.resetPSDevCenterName();
        pSDCDeployCenterBase.resetPSDevSlnId();
        pSDCDeployCenterBase.resetPSDevSlnName();
        pSDCDeployCenterBase.resetPSGitUsers();
        pSDCDeployCenterBase.resetRefCount();
        pSDCDeployCenterBase.resetResPos();
        pSDCDeployCenterBase.resetResReadyTime();
        pSDCDeployCenterBase.resetResState();
        pSDCDeployCenterBase.resetResVer();
        pSDCDeployCenterBase.resetSSHIPAddr();
        pSDCDeployCenterBase.resetSSHPort();
        pSDCDeployCenterBase.resetUpdateDate();
        pSDCDeployCenterBase.resetUpdateMan();
        pSDCDeployCenterBase.resetUploadFileMode();
        pSDCDeployCenterBase.resetUploadPath();
        pSDCDeployCenterBase.resetUserName();
        pSDCDeployCenterBase.resetValidFlag();
        pSDCDeployCenterBase.resetWebConsolePath();
        pSDCDeployCenterBase.resetWorkshopPath();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAdminPasswdDirty()) {
            hashMap.put(FIELD_ADMINPASSWD, this.getAdminPasswd());
        }
        if (!bl || this.isAdminUserNameDirty()) {
            hashMap.put(FIELD_ADMINUSERNAME, this.getAdminUserName());
        }
        if (!bl || this.isAPITokenDirty()) {
            hashMap.put(FIELD_APITOKEN, this.getAPIToken());
        }
        if (!bl || this.isAPIUrlDirty()) {
            hashMap.put(FIELD_APIURL, this.getAPIUrl());
        }
        if (!bl || this.isCfgBranchDirty()) {
            hashMap.put(FIELD_CFGBRANCH, this.getCfgBranch());
        }
        if (!bl || this.isCfgPSCredentialIdDirty()) {
            hashMap.put(FIELD_CFGPSCREDENTIALID, this.getCfgPSCredentialId());
        }
        if (!bl || this.isCfgPSCredentialNameDirty()) {
            hashMap.put(FIELD_CFGPSCREDENTIALNAME, this.getCfgPSCredentialName());
        }
        if (!bl || this.isCfgPSDevCenterSVNIdDirty()) {
            hashMap.put(FIELD_CFGPSDEVCENTERSVNID, this.getCfgPSDevCenterSVNId());
        }
        if (!bl || this.isCfgPSDevCenterSVNNameDirty()) {
            hashMap.put(FIELD_CFGPSDEVCENTERSVNNAME, this.getCfgPSDevCenterSVNName());
        }
        if (!bl || this.isCfgUrlDirty()) {
            hashMap.put(FIELD_CFGURL, this.getCfgUrl());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDCTypeDirty()) {
            hashMap.put(FIELD_DCTYPE, this.getDCType());
        }
        if (!bl || this.isDCType2Dirty()) {
            hashMap.put(FIELD_DCTYPE2, this.getDCType2());
        }
        if (!bl || this.isDefaultFlagDirty()) {
            hashMap.put(FIELD_DEFAULTFLAG, this.getDefaultFlag());
        }
        if (!bl || this.isExpriedTimeDirty()) {
            hashMap.put(FIELD_EXPRIEDTIME, this.getExpriedTime());
        }
        if (!bl || this.isIpAddrDirty()) {
            hashMap.put(FIELD_IPADDR, this.getIpAddr());
        }
        if (!bl || this.isIpAddr2Dirty()) {
            hashMap.put(FIELD_IPADDR2, this.getIpAddr2());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPasswdDirty()) {
            hashMap.put(FIELD_PASSWD, this.getPasswd());
        }
        if (!bl || this.isPortDirty()) {
            hashMap.put(FIELD_PORT, this.getPort());
        }
        if (!bl || this.isPSCredentialIdDirty()) {
            hashMap.put(FIELD_PSCREDENTIALID, this.getPSCredentialId());
        }
        if (!bl || this.isPSCredentialNameDirty()) {
            hashMap.put(FIELD_PSCREDENTIALNAME, this.getPSCredentialName());
        }
        if (!bl || this.isPSCredentialsDirty()) {
            hashMap.put(FIELD_PSCREDENTIALS, this.getPSCredentials());
        }
        if (!bl || this.isPSDCClusterIdDirty()) {
            hashMap.put(FIELD_PSDCCLUSTERID, this.getPSDCClusterId());
        }
        if (!bl || this.isPSDCClusterNameDirty()) {
            hashMap.put(FIELD_PSDCCLUSTERNAME, this.getPSDCClusterName());
        }
        if (!bl || this.isPSDCContainerSpecIdDirty()) {
            hashMap.put(FIELD_PSDCCONTAINERSPECID, this.getPSDCContainerSpecId());
        }
        if (!bl || this.isPSDCContainerSpecNameDirty()) {
            hashMap.put(FIELD_PSDCCONTAINERSPECNAME, this.getPSDCContainerSpecName());
        }
        if (!bl || this.isPSDCDeployCenterIdDirty()) {
            hashMap.put(FIELD_PSDCDEPLOYCENTERID, this.getPSDCDeployCenterId());
        }
        if (!bl || this.isPSDCDeployCenterNameDirty()) {
            hashMap.put(FIELD_PSDCDEPLOYCENTERNAME, this.getPSDCDeployCenterName());
        }
        if (!bl || this.isPSDCFileIdDirty()) {
            hashMap.put(FIELD_PSDCFILEID, this.getPSDCFileId());
        }
        if (!bl || this.isPSDCFileNameDirty()) {
            hashMap.put(FIELD_PSDCFILENAME, this.getPSDCFileName());
        }
        if (!bl || this.isPSDCRegistryRepoIdDirty()) {
            hashMap.put(FIELD_PSDCREGISTRYREPOID, this.getPSDCRegistryRepoId());
        }
        if (!bl || this.isPSDCRegistryRepoNameDirty()) {
            hashMap.put(FIELD_PSDCREGISTRYREPONAME, this.getPSDCRegistryRepoName());
        }
        if (!bl || this.isPSDeployCenterIdDirty()) {
            hashMap.put(FIELD_PSDEPLOYCENTERID, this.getPSDeployCenterId());
        }
        if (!bl || this.isPSDeployCenterNameDirty()) {
            hashMap.put(FIELD_PSDEPLOYCENTERNAME, this.getPSDeployCenterName());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSDevSlnIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNID, this.getPSDevSlnId());
        }
        if (!bl || this.isPSDevSlnNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNNAME, this.getPSDevSlnName());
        }
        if (!bl || this.isPSGitUsersDirty()) {
            hashMap.put(FIELD_PSGITUSERS, this.getPSGitUsers());
        }
        if (!bl || this.isRefCountDirty()) {
            hashMap.put(FIELD_REFCOUNT, this.getRefCount());
        }
        if (!bl || this.isResPosDirty()) {
            hashMap.put(FIELD_RESPOS, this.getResPos());
        }
        if (!bl || this.isResReadyTimeDirty()) {
            hashMap.put(FIELD_RESREADYTIME, this.getResReadyTime());
        }
        if (!bl || this.isResStateDirty()) {
            hashMap.put(FIELD_RESSTATE, this.getResState());
        }
        if (!bl || this.isResVerDirty()) {
            hashMap.put(FIELD_RESVER, this.getResVer());
        }
        if (!bl || this.isSSHIPAddrDirty()) {
            hashMap.put(FIELD_SSHIPADDR, this.getSSHIPAddr());
        }
        if (!bl || this.isSSHPortDirty()) {
            hashMap.put(FIELD_SSHPORT, this.getSSHPort());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUploadFileModeDirty()) {
            hashMap.put(FIELD_UPLOADFILEMODE, this.getUploadFileMode());
        }
        if (!bl || this.isUploadPathDirty()) {
            hashMap.put(FIELD_UPLOADPATH, this.getUploadPath());
        }
        if (!bl || this.isUserNameDirty()) {
            hashMap.put(FIELD_USERNAME, this.getUserName());
        }
        if (!bl || this.isValidFlagDirty()) {
            hashMap.put(FIELD_VALIDFLAG, this.getValidFlag());
        }
        if (!bl || this.isWebConsolePathDirty()) {
            hashMap.put(FIELD_WEBCONSOLEPATH, this.getWebConsolePath());
        }
        if (!bl || this.isWorkshopPathDirty()) {
            hashMap.put(FIELD_WORKSHOPPATH, this.getWorkshopPath());
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
        return PSDCDeployCenterBase.get(this, n);
    }

    private static Object get(PSDCDeployCenterBase pSDCDeployCenterBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCDeployCenterBase.getAdminPasswd();
            }
            case 1: {
                return pSDCDeployCenterBase.getAdminUserName();
            }
            case 2: {
                return pSDCDeployCenterBase.getAPIToken();
            }
            case 3: {
                return pSDCDeployCenterBase.getAPIUrl();
            }
            case 4: {
                return pSDCDeployCenterBase.getCfgBranch();
            }
            case 5: {
                return pSDCDeployCenterBase.getCfgPSCredentialId();
            }
            case 6: {
                return pSDCDeployCenterBase.getCfgPSCredentialName();
            }
            case 7: {
                return pSDCDeployCenterBase.getCfgPSDevCenterSVNId();
            }
            case 8: {
                return pSDCDeployCenterBase.getCfgPSDevCenterSVNName();
            }
            case 9: {
                return pSDCDeployCenterBase.getCfgUrl();
            }
            case 10: {
                return pSDCDeployCenterBase.getCreateDate();
            }
            case 11: {
                return pSDCDeployCenterBase.getCreateMan();
            }
            case 12: {
                return pSDCDeployCenterBase.getDCType();
            }
            case 13: {
                return pSDCDeployCenterBase.getDCType2();
            }
            case 14: {
                return pSDCDeployCenterBase.getDefaultFlag();
            }
            case 15: {
                return pSDCDeployCenterBase.getExpriedTime();
            }
            case 16: {
                return pSDCDeployCenterBase.getIpAddr();
            }
            case 17: {
                return pSDCDeployCenterBase.getIpAddr2();
            }
            case 18: {
                return pSDCDeployCenterBase.getMemo();
            }
            case 19: {
                return pSDCDeployCenterBase.getPasswd();
            }
            case 20: {
                return pSDCDeployCenterBase.getPort();
            }
            case 21: {
                return pSDCDeployCenterBase.getPSCredentialId();
            }
            case 22: {
                return pSDCDeployCenterBase.getPSCredentialName();
            }
            case 23: {
                return pSDCDeployCenterBase.getPSCredentials();
            }
            case 24: {
                return pSDCDeployCenterBase.getPSDCClusterId();
            }
            case 25: {
                return pSDCDeployCenterBase.getPSDCClusterName();
            }
            case 26: {
                return pSDCDeployCenterBase.getPSDCContainerSpecId();
            }
            case 27: {
                return pSDCDeployCenterBase.getPSDCContainerSpecName();
            }
            case 28: {
                return pSDCDeployCenterBase.getPSDCDeployCenterId();
            }
            case 29: {
                return pSDCDeployCenterBase.getPSDCDeployCenterName();
            }
            case 30: {
                return pSDCDeployCenterBase.getPSDCFileId();
            }
            case 31: {
                return pSDCDeployCenterBase.getPSDCFileName();
            }
            case 32: {
                return pSDCDeployCenterBase.getPSDCRegistryRepoId();
            }
            case 33: {
                return pSDCDeployCenterBase.getPSDCRegistryRepoName();
            }
            case 34: {
                return pSDCDeployCenterBase.getPSDeployCenterId();
            }
            case 35: {
                return pSDCDeployCenterBase.getPSDeployCenterName();
            }
            case 36: {
                return pSDCDeployCenterBase.getPSDevCenterId();
            }
            case 37: {
                return pSDCDeployCenterBase.getPSDevCenterName();
            }
            case 38: {
                return pSDCDeployCenterBase.getPSDevSlnId();
            }
            case 39: {
                return pSDCDeployCenterBase.getPSDevSlnName();
            }
            case 40: {
                return pSDCDeployCenterBase.getPSGitUsers();
            }
            case 41: {
                return pSDCDeployCenterBase.getRefCount();
            }
            case 42: {
                return pSDCDeployCenterBase.getResPos();
            }
            case 43: {
                return pSDCDeployCenterBase.getResReadyTime();
            }
            case 44: {
                return pSDCDeployCenterBase.getResState();
            }
            case 45: {
                return pSDCDeployCenterBase.getResVer();
            }
            case 46: {
                return pSDCDeployCenterBase.getSSHIPAddr();
            }
            case 47: {
                return pSDCDeployCenterBase.getSSHPort();
            }
            case 48: {
                return pSDCDeployCenterBase.getUpdateDate();
            }
            case 49: {
                return pSDCDeployCenterBase.getUpdateMan();
            }
            case 50: {
                return pSDCDeployCenterBase.getUploadFileMode();
            }
            case 51: {
                return pSDCDeployCenterBase.getUploadPath();
            }
            case 52: {
                return pSDCDeployCenterBase.getUserName();
            }
            case 53: {
                return pSDCDeployCenterBase.getValidFlag();
            }
            case 54: {
                return pSDCDeployCenterBase.getWebConsolePath();
            }
            case 55: {
                return pSDCDeployCenterBase.getWorkshopPath();
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
        PSDCDeployCenterBase.set(this, n, object);
    }

    private static void set(PSDCDeployCenterBase pSDCDeployCenterBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCDeployCenterBase.setAdminPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDCDeployCenterBase.setAdminUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDCDeployCenterBase.setAPIToken(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCDeployCenterBase.setAPIUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDCDeployCenterBase.setCfgBranch(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCDeployCenterBase.setCfgPSCredentialId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCDeployCenterBase.setCfgPSCredentialName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCDeployCenterBase.setCfgPSDevCenterSVNId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCDeployCenterBase.setCfgPSDevCenterSVNName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDCDeployCenterBase.setCfgUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDCDeployCenterBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSDCDeployCenterBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDCDeployCenterBase.setDCType(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDCDeployCenterBase.setDCType2(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDCDeployCenterBase.setDefaultFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSDCDeployCenterBase.setExpriedTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 16: {
                pSDCDeployCenterBase.setIpAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDCDeployCenterBase.setIpAddr2(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDCDeployCenterBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDCDeployCenterBase.setPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDCDeployCenterBase.setPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 21: {
                pSDCDeployCenterBase.setPSCredentialId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDCDeployCenterBase.setPSCredentialName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDCDeployCenterBase.setPSCredentials(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDCDeployCenterBase.setPSDCClusterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDCDeployCenterBase.setPSDCClusterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDCDeployCenterBase.setPSDCContainerSpecId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDCDeployCenterBase.setPSDCContainerSpecName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDCDeployCenterBase.setPSDCDeployCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDCDeployCenterBase.setPSDCDeployCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDCDeployCenterBase.setPSDCFileId(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDCDeployCenterBase.setPSDCFileName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDCDeployCenterBase.setPSDCRegistryRepoId(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDCDeployCenterBase.setPSDCRegistryRepoName(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDCDeployCenterBase.setPSDeployCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDCDeployCenterBase.setPSDeployCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDCDeployCenterBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDCDeployCenterBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDCDeployCenterBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDCDeployCenterBase.setPSDevSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDCDeployCenterBase.setPSGitUsers(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDCDeployCenterBase.setRefCount(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 42: {
                pSDCDeployCenterBase.setResPos(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 43: {
                pSDCDeployCenterBase.setResReadyTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 44: {
                pSDCDeployCenterBase.setResState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 45: {
                pSDCDeployCenterBase.setResVer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 46: {
                pSDCDeployCenterBase.setSSHIPAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSDCDeployCenterBase.setSSHPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 48: {
                pSDCDeployCenterBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 49: {
                pSDCDeployCenterBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSDCDeployCenterBase.setUploadFileMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSDCDeployCenterBase.setUploadPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSDCDeployCenterBase.setUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSDCDeployCenterBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 54: {
                pSDCDeployCenterBase.setWebConsolePath(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSDCDeployCenterBase.setWorkshopPath(DataObject.getStringValue((Object)object));
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
        return PSDCDeployCenterBase.isNull(this, n);
    }

    private static boolean isNull(PSDCDeployCenterBase pSDCDeployCenterBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCDeployCenterBase.getAdminPasswd() == null;
            }
            case 1: {
                return pSDCDeployCenterBase.getAdminUserName() == null;
            }
            case 2: {
                return pSDCDeployCenterBase.getAPIToken() == null;
            }
            case 3: {
                return pSDCDeployCenterBase.getAPIUrl() == null;
            }
            case 4: {
                return pSDCDeployCenterBase.getCfgBranch() == null;
            }
            case 5: {
                return pSDCDeployCenterBase.getCfgPSCredentialId() == null;
            }
            case 6: {
                return pSDCDeployCenterBase.getCfgPSCredentialName() == null;
            }
            case 7: {
                return pSDCDeployCenterBase.getCfgPSDevCenterSVNId() == null;
            }
            case 8: {
                return pSDCDeployCenterBase.getCfgPSDevCenterSVNName() == null;
            }
            case 9: {
                return pSDCDeployCenterBase.getCfgUrl() == null;
            }
            case 10: {
                return pSDCDeployCenterBase.getCreateDate() == null;
            }
            case 11: {
                return pSDCDeployCenterBase.getCreateMan() == null;
            }
            case 12: {
                return pSDCDeployCenterBase.getDCType() == null;
            }
            case 13: {
                return pSDCDeployCenterBase.getDCType2() == null;
            }
            case 14: {
                return pSDCDeployCenterBase.getDefaultFlag() == null;
            }
            case 15: {
                return pSDCDeployCenterBase.getExpriedTime() == null;
            }
            case 16: {
                return pSDCDeployCenterBase.getIpAddr() == null;
            }
            case 17: {
                return pSDCDeployCenterBase.getIpAddr2() == null;
            }
            case 18: {
                return pSDCDeployCenterBase.getMemo() == null;
            }
            case 19: {
                return pSDCDeployCenterBase.getPasswd() == null;
            }
            case 20: {
                return pSDCDeployCenterBase.getPort() == null;
            }
            case 21: {
                return pSDCDeployCenterBase.getPSCredentialId() == null;
            }
            case 22: {
                return pSDCDeployCenterBase.getPSCredentialName() == null;
            }
            case 23: {
                return pSDCDeployCenterBase.getPSCredentials() == null;
            }
            case 24: {
                return pSDCDeployCenterBase.getPSDCClusterId() == null;
            }
            case 25: {
                return pSDCDeployCenterBase.getPSDCClusterName() == null;
            }
            case 26: {
                return pSDCDeployCenterBase.getPSDCContainerSpecId() == null;
            }
            case 27: {
                return pSDCDeployCenterBase.getPSDCContainerSpecName() == null;
            }
            case 28: {
                return pSDCDeployCenterBase.getPSDCDeployCenterId() == null;
            }
            case 29: {
                return pSDCDeployCenterBase.getPSDCDeployCenterName() == null;
            }
            case 30: {
                return pSDCDeployCenterBase.getPSDCFileId() == null;
            }
            case 31: {
                return pSDCDeployCenterBase.getPSDCFileName() == null;
            }
            case 32: {
                return pSDCDeployCenterBase.getPSDCRegistryRepoId() == null;
            }
            case 33: {
                return pSDCDeployCenterBase.getPSDCRegistryRepoName() == null;
            }
            case 34: {
                return pSDCDeployCenterBase.getPSDeployCenterId() == null;
            }
            case 35: {
                return pSDCDeployCenterBase.getPSDeployCenterName() == null;
            }
            case 36: {
                return pSDCDeployCenterBase.getPSDevCenterId() == null;
            }
            case 37: {
                return pSDCDeployCenterBase.getPSDevCenterName() == null;
            }
            case 38: {
                return pSDCDeployCenterBase.getPSDevSlnId() == null;
            }
            case 39: {
                return pSDCDeployCenterBase.getPSDevSlnName() == null;
            }
            case 40: {
                return pSDCDeployCenterBase.getPSGitUsers() == null;
            }
            case 41: {
                return pSDCDeployCenterBase.getRefCount() == null;
            }
            case 42: {
                return pSDCDeployCenterBase.getResPos() == null;
            }
            case 43: {
                return pSDCDeployCenterBase.getResReadyTime() == null;
            }
            case 44: {
                return pSDCDeployCenterBase.getResState() == null;
            }
            case 45: {
                return pSDCDeployCenterBase.getResVer() == null;
            }
            case 46: {
                return pSDCDeployCenterBase.getSSHIPAddr() == null;
            }
            case 47: {
                return pSDCDeployCenterBase.getSSHPort() == null;
            }
            case 48: {
                return pSDCDeployCenterBase.getUpdateDate() == null;
            }
            case 49: {
                return pSDCDeployCenterBase.getUpdateMan() == null;
            }
            case 50: {
                return pSDCDeployCenterBase.getUploadFileMode() == null;
            }
            case 51: {
                return pSDCDeployCenterBase.getUploadPath() == null;
            }
            case 52: {
                return pSDCDeployCenterBase.getUserName() == null;
            }
            case 53: {
                return pSDCDeployCenterBase.getValidFlag() == null;
            }
            case 54: {
                return pSDCDeployCenterBase.getWebConsolePath() == null;
            }
            case 55: {
                return pSDCDeployCenterBase.getWorkshopPath() == null;
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
        return PSDCDeployCenterBase.contains(this, n);
    }

    private static boolean contains(PSDCDeployCenterBase pSDCDeployCenterBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCDeployCenterBase.isAdminPasswdDirty();
            }
            case 1: {
                return pSDCDeployCenterBase.isAdminUserNameDirty();
            }
            case 2: {
                return pSDCDeployCenterBase.isAPITokenDirty();
            }
            case 3: {
                return pSDCDeployCenterBase.isAPIUrlDirty();
            }
            case 4: {
                return pSDCDeployCenterBase.isCfgBranchDirty();
            }
            case 5: {
                return pSDCDeployCenterBase.isCfgPSCredentialIdDirty();
            }
            case 6: {
                return pSDCDeployCenterBase.isCfgPSCredentialNameDirty();
            }
            case 7: {
                return pSDCDeployCenterBase.isCfgPSDevCenterSVNIdDirty();
            }
            case 8: {
                return pSDCDeployCenterBase.isCfgPSDevCenterSVNNameDirty();
            }
            case 9: {
                return pSDCDeployCenterBase.isCfgUrlDirty();
            }
            case 10: {
                return pSDCDeployCenterBase.isCreateDateDirty();
            }
            case 11: {
                return pSDCDeployCenterBase.isCreateManDirty();
            }
            case 12: {
                return pSDCDeployCenterBase.isDCTypeDirty();
            }
            case 13: {
                return pSDCDeployCenterBase.isDCType2Dirty();
            }
            case 14: {
                return pSDCDeployCenterBase.isDefaultFlagDirty();
            }
            case 15: {
                return pSDCDeployCenterBase.isExpriedTimeDirty();
            }
            case 16: {
                return pSDCDeployCenterBase.isIpAddrDirty();
            }
            case 17: {
                return pSDCDeployCenterBase.isIpAddr2Dirty();
            }
            case 18: {
                return pSDCDeployCenterBase.isMemoDirty();
            }
            case 19: {
                return pSDCDeployCenterBase.isPasswdDirty();
            }
            case 20: {
                return pSDCDeployCenterBase.isPortDirty();
            }
            case 21: {
                return pSDCDeployCenterBase.isPSCredentialIdDirty();
            }
            case 22: {
                return pSDCDeployCenterBase.isPSCredentialNameDirty();
            }
            case 23: {
                return pSDCDeployCenterBase.isPSCredentialsDirty();
            }
            case 24: {
                return pSDCDeployCenterBase.isPSDCClusterIdDirty();
            }
            case 25: {
                return pSDCDeployCenterBase.isPSDCClusterNameDirty();
            }
            case 26: {
                return pSDCDeployCenterBase.isPSDCContainerSpecIdDirty();
            }
            case 27: {
                return pSDCDeployCenterBase.isPSDCContainerSpecNameDirty();
            }
            case 28: {
                return pSDCDeployCenterBase.isPSDCDeployCenterIdDirty();
            }
            case 29: {
                return pSDCDeployCenterBase.isPSDCDeployCenterNameDirty();
            }
            case 30: {
                return pSDCDeployCenterBase.isPSDCFileIdDirty();
            }
            case 31: {
                return pSDCDeployCenterBase.isPSDCFileNameDirty();
            }
            case 32: {
                return pSDCDeployCenterBase.isPSDCRegistryRepoIdDirty();
            }
            case 33: {
                return pSDCDeployCenterBase.isPSDCRegistryRepoNameDirty();
            }
            case 34: {
                return pSDCDeployCenterBase.isPSDeployCenterIdDirty();
            }
            case 35: {
                return pSDCDeployCenterBase.isPSDeployCenterNameDirty();
            }
            case 36: {
                return pSDCDeployCenterBase.isPSDevCenterIdDirty();
            }
            case 37: {
                return pSDCDeployCenterBase.isPSDevCenterNameDirty();
            }
            case 38: {
                return pSDCDeployCenterBase.isPSDevSlnIdDirty();
            }
            case 39: {
                return pSDCDeployCenterBase.isPSDevSlnNameDirty();
            }
            case 40: {
                return pSDCDeployCenterBase.isPSGitUsersDirty();
            }
            case 41: {
                return pSDCDeployCenterBase.isRefCountDirty();
            }
            case 42: {
                return pSDCDeployCenterBase.isResPosDirty();
            }
            case 43: {
                return pSDCDeployCenterBase.isResReadyTimeDirty();
            }
            case 44: {
                return pSDCDeployCenterBase.isResStateDirty();
            }
            case 45: {
                return pSDCDeployCenterBase.isResVerDirty();
            }
            case 46: {
                return pSDCDeployCenterBase.isSSHIPAddrDirty();
            }
            case 47: {
                return pSDCDeployCenterBase.isSSHPortDirty();
            }
            case 48: {
                return pSDCDeployCenterBase.isUpdateDateDirty();
            }
            case 49: {
                return pSDCDeployCenterBase.isUpdateManDirty();
            }
            case 50: {
                return pSDCDeployCenterBase.isUploadFileModeDirty();
            }
            case 51: {
                return pSDCDeployCenterBase.isUploadPathDirty();
            }
            case 52: {
                return pSDCDeployCenterBase.isUserNameDirty();
            }
            case 53: {
                return pSDCDeployCenterBase.isValidFlagDirty();
            }
            case 54: {
                return pSDCDeployCenterBase.isWebConsolePathDirty();
            }
            case 55: {
                return pSDCDeployCenterBase.isWorkshopPathDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCDeployCenterBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCDeployCenterBase pSDCDeployCenterBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCDeployCenterBase.getAdminPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"adminpasswd", (Object)PSDCDeployCenterBase.getJSONValue((Object)pSDCDeployCenterBase.getAdminPasswd()), (boolean)false);
        }
        if (bl || pSDCDeployCenterBase.getAdminUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"adminusername", (Object)PSDCDeployCenterBase.getJSONValue((Object)pSDCDeployCenterBase.getAdminUserName()), (boolean)false);
        }
        if (bl || pSDCDeployCenterBase.getAPIToken() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"apitoken", (Object)PSDCDeployCenterBase.getJSONValue((Object)pSDCDeployCenterBase.getAPIToken()), (boolean)false);
        }
        if (bl || pSDCDeployCenterBase.getAPIUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"apiurl", (Object)PSDCDeployCenterBase.getJSONValue((Object)pSDCDeployCenterBase.getAPIUrl()), (boolean)false);
        }
        if (bl || pSDCDeployCenterBase.getCfgBranch() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cfgbranch", (Object)PSDCDeployCenterBase.getJSONValue((Object)pSDCDeployCenterBase.getCfgBranch()), (boolean)false);
        }
        if (bl || pSDCDeployCenterBase.getCfgPSCredentialId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cfgpscredentialid", (Object)PSDCDeployCenterBase.getJSONValue((Object)pSDCDeployCenterBase.getCfgPSCredentialId()), (boolean)false);
        }
        if (bl || pSDCDeployCenterBase.getCfgPSCredentialName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cfgpscredentialname", (Object)PSDCDeployCenterBase.getJSONValue((Object)pSDCDeployCenterBase.getCfgPSCredentialName()), (boolean)false);
        }
        if (bl || pSDCDeployCenterBase.getCfgPSDevCenterSVNId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cfgpsdevcentersvnid", (Object)PSDCDeployCenterBase.getJSONValue((Object)pSDCDeployCenterBase.getCfgPSDevCenterSVNId()), (boolean)false);
        }
        if (bl || pSDCDeployCenterBase.getCfgPSDevCenterSVNName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cfgpsdevcentersvnname", (Object)PSDCDeployCenterBase.getJSONValue((Object)pSDCDeployCenterBase.getCfgPSDevCenterSVNName()), (boolean)false);
        }
        if (bl || pSDCDeployCenterBase.getCfgUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cfgurl", (Object)PSDCDeployCenterBase.getJSONValue((Object)pSDCDeployCenterBase.getCfgUrl()), (boolean)false);
        }
        if (bl || pSDCDeployCenterBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCDeployCenterBase.getJSONValue((Object)pSDCDeployCenterBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCDeployCenterBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCDeployCenterBase.getJSONValue((Object)pSDCDeployCenterBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCDeployCenterBase.getDCType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dctype", (Object)PSDCDeployCenterBase.getJSONValue((Object)pSDCDeployCenterBase.getDCType()), (boolean)false);
        }
        if (bl || pSDCDeployCenterBase.getDCType2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dctype2", (Object)PSDCDeployCenterBase.getJSONValue((Object)pSDCDeployCenterBase.getDCType2()), (boolean)false);
        }
        if (bl || pSDCDeployCenterBase.getDefaultFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultflag", (Object)PSDCDeployCenterBase.getJSONValue((Object)pSDCDeployCenterBase.getDefaultFlag()), (boolean)false);
        }
        if (bl || pSDCDeployCenterBase.getExpriedTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"expriedtime", (Object)PSDCDeployCenterBase.getJSONValue((Object)pSDCDeployCenterBase.getExpriedTime()), (boolean)false);
        }
        if (bl || pSDCDeployCenterBase.getIpAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr", (Object)PSDCDeployCenterBase.getJSONValue((Object)pSDCDeployCenterBase.getIpAddr()), (boolean)false);
        }
        if (bl || pSDCDeployCenterBase.getIpAddr2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr2", (Object)PSDCDeployCenterBase.getJSONValue((Object)pSDCDeployCenterBase.getIpAddr2()), (boolean)false);
        }
        if (bl || pSDCDeployCenterBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCDeployCenterBase.getJSONValue((Object)pSDCDeployCenterBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCDeployCenterBase.getPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"passwd", (Object)PSDCDeployCenterBase.getJSONValue((Object)pSDCDeployCenterBase.getPasswd()), (boolean)false);
        }
        if (bl || pSDCDeployCenterBase.getPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"port", (Object)PSDCDeployCenterBase.getJSONValue((Object)pSDCDeployCenterBase.getPort()), (boolean)false);
        }
        if (bl || pSDCDeployCenterBase.getPSCredentialId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscredentialid", (Object)PSDCDeployCenterBase.getJSONValue((Object)pSDCDeployCenterBase.getPSCredentialId()), (boolean)false);
        }
        if (bl || pSDCDeployCenterBase.getPSCredentialName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscredentialname", (Object)PSDCDeployCenterBase.getJSONValue((Object)pSDCDeployCenterBase.getPSCredentialName()), (boolean)false);
        }
        if (bl || pSDCDeployCenterBase.getPSCredentials() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscredentials", (Object)PSDCDeployCenterBase.getJSONValue((Object)pSDCDeployCenterBase.getPSCredentials()), (boolean)false);
        }
        if (bl || pSDCDeployCenterBase.getPSDCClusterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcclusterid", (Object)PSDCDeployCenterBase.getJSONValue((Object)pSDCDeployCenterBase.getPSDCClusterId()), (boolean)false);
        }
        if (bl || pSDCDeployCenterBase.getPSDCClusterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcclustername", (Object)PSDCDeployCenterBase.getJSONValue((Object)pSDCDeployCenterBase.getPSDCClusterName()), (boolean)false);
        }
        if (bl || pSDCDeployCenterBase.getPSDCContainerSpecId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdccontainerspecid", (Object)PSDCDeployCenterBase.getJSONValue((Object)pSDCDeployCenterBase.getPSDCContainerSpecId()), (boolean)false);
        }
        if (bl || pSDCDeployCenterBase.getPSDCContainerSpecName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdccontainerspecname", (Object)PSDCDeployCenterBase.getJSONValue((Object)pSDCDeployCenterBase.getPSDCContainerSpecName()), (boolean)false);
        }
        if (bl || pSDCDeployCenterBase.getPSDCDeployCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcdeploycenterid", (Object)PSDCDeployCenterBase.getJSONValue((Object)pSDCDeployCenterBase.getPSDCDeployCenterId()), (boolean)false);
        }
        if (bl || pSDCDeployCenterBase.getPSDCDeployCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcdeploycentername", (Object)PSDCDeployCenterBase.getJSONValue((Object)pSDCDeployCenterBase.getPSDCDeployCenterName()), (boolean)false);
        }
        if (bl || pSDCDeployCenterBase.getPSDCFileId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcfileid", (Object)PSDCDeployCenterBase.getJSONValue((Object)pSDCDeployCenterBase.getPSDCFileId()), (boolean)false);
        }
        if (bl || pSDCDeployCenterBase.getPSDCFileName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcfilename", (Object)PSDCDeployCenterBase.getJSONValue((Object)pSDCDeployCenterBase.getPSDCFileName()), (boolean)false);
        }
        if (bl || pSDCDeployCenterBase.getPSDCRegistryRepoId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcregistryrepoid", (Object)PSDCDeployCenterBase.getJSONValue((Object)pSDCDeployCenterBase.getPSDCRegistryRepoId()), (boolean)false);
        }
        if (bl || pSDCDeployCenterBase.getPSDCRegistryRepoName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcregistryreponame", (Object)PSDCDeployCenterBase.getJSONValue((Object)pSDCDeployCenterBase.getPSDCRegistryRepoName()), (boolean)false);
        }
        if (bl || pSDCDeployCenterBase.getPSDeployCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeploycenterid", (Object)PSDCDeployCenterBase.getJSONValue((Object)pSDCDeployCenterBase.getPSDeployCenterId()), (boolean)false);
        }
        if (bl || pSDCDeployCenterBase.getPSDeployCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeploycentername", (Object)PSDCDeployCenterBase.getJSONValue((Object)pSDCDeployCenterBase.getPSDeployCenterName()), (boolean)false);
        }
        if (bl || pSDCDeployCenterBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDCDeployCenterBase.getJSONValue((Object)pSDCDeployCenterBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDCDeployCenterBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDCDeployCenterBase.getJSONValue((Object)pSDCDeployCenterBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDCDeployCenterBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDCDeployCenterBase.getJSONValue((Object)pSDCDeployCenterBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDCDeployCenterBase.getPSDevSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnname", (Object)PSDCDeployCenterBase.getJSONValue((Object)pSDCDeployCenterBase.getPSDevSlnName()), (boolean)false);
        }
        if (bl || pSDCDeployCenterBase.getPSGitUsers() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psgitusers", (Object)PSDCDeployCenterBase.getJSONValue((Object)pSDCDeployCenterBase.getPSGitUsers()), (boolean)false);
        }
        if (bl || pSDCDeployCenterBase.getRefCount() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refcount", (Object)PSDCDeployCenterBase.getJSONValue((Object)pSDCDeployCenterBase.getRefCount()), (boolean)false);
        }
        if (bl || pSDCDeployCenterBase.getResPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"respos", (Object)PSDCDeployCenterBase.getJSONValue((Object)pSDCDeployCenterBase.getResPos()), (boolean)false);
        }
        if (bl || pSDCDeployCenterBase.getResReadyTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resreadytime", (Object)PSDCDeployCenterBase.getJSONValue((Object)pSDCDeployCenterBase.getResReadyTime()), (boolean)false);
        }
        if (bl || pSDCDeployCenterBase.getResState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resstate", (Object)PSDCDeployCenterBase.getJSONValue((Object)pSDCDeployCenterBase.getResState()), (boolean)false);
        }
        if (bl || pSDCDeployCenterBase.getResVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resver", (Object)PSDCDeployCenterBase.getJSONValue((Object)pSDCDeployCenterBase.getResVer()), (boolean)false);
        }
        if (bl || pSDCDeployCenterBase.getSSHIPAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sshipaddr", (Object)PSDCDeployCenterBase.getJSONValue((Object)pSDCDeployCenterBase.getSSHIPAddr()), (boolean)false);
        }
        if (bl || pSDCDeployCenterBase.getSSHPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sshport", (Object)PSDCDeployCenterBase.getJSONValue((Object)pSDCDeployCenterBase.getSSHPort()), (boolean)false);
        }
        if (bl || pSDCDeployCenterBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCDeployCenterBase.getJSONValue((Object)pSDCDeployCenterBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCDeployCenterBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCDeployCenterBase.getJSONValue((Object)pSDCDeployCenterBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDCDeployCenterBase.getUploadFileMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uploadfilemode", (Object)PSDCDeployCenterBase.getJSONValue((Object)pSDCDeployCenterBase.getUploadFileMode()), (boolean)false);
        }
        if (bl || pSDCDeployCenterBase.getUploadPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uploadpath", (Object)PSDCDeployCenterBase.getJSONValue((Object)pSDCDeployCenterBase.getUploadPath()), (boolean)false);
        }
        if (bl || pSDCDeployCenterBase.getUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"username", (Object)PSDCDeployCenterBase.getJSONValue((Object)pSDCDeployCenterBase.getUserName()), (boolean)false);
        }
        if (bl || pSDCDeployCenterBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDCDeployCenterBase.getJSONValue((Object)pSDCDeployCenterBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSDCDeployCenterBase.getWebConsolePath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"webconsolepath", (Object)PSDCDeployCenterBase.getJSONValue((Object)pSDCDeployCenterBase.getWebConsolePath()), (boolean)false);
        }
        if (bl || pSDCDeployCenterBase.getWorkshopPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"workshoppath", (Object)PSDCDeployCenterBase.getJSONValue((Object)pSDCDeployCenterBase.getWorkshopPath()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCDeployCenterBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCDeployCenterBase pSDCDeployCenterBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCDeployCenterBase.getAdminPasswd() != null) {
            object = pSDCDeployCenterBase.getAdminPasswd();
            xmlNode.setAttribute(FIELD_ADMINPASSWD, (String)(object == null ? "" : object));
        }
        if (bl || pSDCDeployCenterBase.getAdminUserName() != null) {
            object = pSDCDeployCenterBase.getAdminUserName();
            xmlNode.setAttribute(FIELD_ADMINUSERNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDCDeployCenterBase.getAPIToken() != null) {
            object = pSDCDeployCenterBase.getAPIToken();
            xmlNode.setAttribute(FIELD_APITOKEN, (String)(object == null ? "" : object));
        }
        if (bl || pSDCDeployCenterBase.getAPIUrl() != null) {
            object = pSDCDeployCenterBase.getAPIUrl();
            xmlNode.setAttribute(FIELD_APIURL, (String)(object == null ? "" : object));
        }
        if (bl || pSDCDeployCenterBase.getCfgBranch() != null) {
            object = pSDCDeployCenterBase.getCfgBranch();
            xmlNode.setAttribute(FIELD_CFGBRANCH, (String)(object == null ? "" : object));
        }
        if (bl || pSDCDeployCenterBase.getCfgPSCredentialId() != null) {
            object = pSDCDeployCenterBase.getCfgPSCredentialId();
            xmlNode.setAttribute(FIELD_CFGPSCREDENTIALID, (String)(object == null ? "" : object));
        }
        if (bl || pSDCDeployCenterBase.getCfgPSCredentialName() != null) {
            object = pSDCDeployCenterBase.getCfgPSCredentialName();
            xmlNode.setAttribute(FIELD_CFGPSCREDENTIALNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDCDeployCenterBase.getCfgPSDevCenterSVNId() != null) {
            object = pSDCDeployCenterBase.getCfgPSDevCenterSVNId();
            xmlNode.setAttribute(FIELD_CFGPSDEVCENTERSVNID, (String)(object == null ? "" : object));
        }
        if (bl || pSDCDeployCenterBase.getCfgPSDevCenterSVNName() != null) {
            object = pSDCDeployCenterBase.getCfgPSDevCenterSVNName();
            xmlNode.setAttribute(FIELD_CFGPSDEVCENTERSVNNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDCDeployCenterBase.getCfgUrl() != null) {
            object = pSDCDeployCenterBase.getCfgUrl();
            xmlNode.setAttribute(FIELD_CFGURL, object == null ? "" : (String)object);
        }
        if (bl || pSDCDeployCenterBase.getCreateDate() != null) {
            object = pSDCDeployCenterBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCDeployCenterBase.getCreateMan() != null) {
            object = pSDCDeployCenterBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCDeployCenterBase.getDCType() != null) {
            object = pSDCDeployCenterBase.getDCType();
            xmlNode.setAttribute(FIELD_DCTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDCDeployCenterBase.getDCType2() != null) {
            object = pSDCDeployCenterBase.getDCType2();
            xmlNode.setAttribute(FIELD_DCTYPE2, object == null ? "" : (String)object);
        }
        if (bl || pSDCDeployCenterBase.getDefaultFlag() != null) {
            object = pSDCDeployCenterBase.getDefaultFlag();
            xmlNode.setAttribute(FIELD_DEFAULTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCDeployCenterBase.getExpriedTime() != null) {
            object = pSDCDeployCenterBase.getExpriedTime();
            xmlNode.setAttribute(FIELD_EXPRIEDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCDeployCenterBase.getIpAddr() != null) {
            object = pSDCDeployCenterBase.getIpAddr();
            xmlNode.setAttribute(FIELD_IPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSDCDeployCenterBase.getIpAddr2() != null) {
            object = pSDCDeployCenterBase.getIpAddr2();
            xmlNode.setAttribute(FIELD_IPADDR2, object == null ? "" : (String)object);
        }
        if (bl || pSDCDeployCenterBase.getMemo() != null) {
            object = pSDCDeployCenterBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCDeployCenterBase.getPasswd() != null) {
            object = pSDCDeployCenterBase.getPasswd();
            xmlNode.setAttribute(FIELD_PASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSDCDeployCenterBase.getPort() != null) {
            object = pSDCDeployCenterBase.getPort();
            xmlNode.setAttribute(FIELD_PORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCDeployCenterBase.getPSCredentialId() != null) {
            object = pSDCDeployCenterBase.getPSCredentialId();
            xmlNode.setAttribute(FIELD_PSCREDENTIALID, object == null ? "" : (String)object);
        }
        if (bl || pSDCDeployCenterBase.getPSCredentialName() != null) {
            object = pSDCDeployCenterBase.getPSCredentialName();
            xmlNode.setAttribute(FIELD_PSCREDENTIALNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCDeployCenterBase.getPSCredentials() != null) {
            object = pSDCDeployCenterBase.getPSCredentials();
            xmlNode.setAttribute(FIELD_PSCREDENTIALS, object == null ? "" : (String)object);
        }
        if (bl || pSDCDeployCenterBase.getPSDCClusterId() != null) {
            object = pSDCDeployCenterBase.getPSDCClusterId();
            xmlNode.setAttribute(FIELD_PSDCCLUSTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCDeployCenterBase.getPSDCClusterName() != null) {
            object = pSDCDeployCenterBase.getPSDCClusterName();
            xmlNode.setAttribute(FIELD_PSDCCLUSTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCDeployCenterBase.getPSDCContainerSpecId() != null) {
            object = pSDCDeployCenterBase.getPSDCContainerSpecId();
            xmlNode.setAttribute(FIELD_PSDCCONTAINERSPECID, object == null ? "" : (String)object);
        }
        if (bl || pSDCDeployCenterBase.getPSDCContainerSpecName() != null) {
            object = pSDCDeployCenterBase.getPSDCContainerSpecName();
            xmlNode.setAttribute(FIELD_PSDCCONTAINERSPECNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCDeployCenterBase.getPSDCDeployCenterId() != null) {
            object = pSDCDeployCenterBase.getPSDCDeployCenterId();
            xmlNode.setAttribute(FIELD_PSDCDEPLOYCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCDeployCenterBase.getPSDCDeployCenterName() != null) {
            object = pSDCDeployCenterBase.getPSDCDeployCenterName();
            xmlNode.setAttribute(FIELD_PSDCDEPLOYCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCDeployCenterBase.getPSDCFileId() != null) {
            object = pSDCDeployCenterBase.getPSDCFileId();
            xmlNode.setAttribute(FIELD_PSDCFILEID, object == null ? "" : (String)object);
        }
        if (bl || pSDCDeployCenterBase.getPSDCFileName() != null) {
            object = pSDCDeployCenterBase.getPSDCFileName();
            xmlNode.setAttribute(FIELD_PSDCFILENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCDeployCenterBase.getPSDCRegistryRepoId() != null) {
            object = pSDCDeployCenterBase.getPSDCRegistryRepoId();
            xmlNode.setAttribute(FIELD_PSDCREGISTRYREPOID, object == null ? "" : (String)object);
        }
        if (bl || pSDCDeployCenterBase.getPSDCRegistryRepoName() != null) {
            object = pSDCDeployCenterBase.getPSDCRegistryRepoName();
            xmlNode.setAttribute(FIELD_PSDCREGISTRYREPONAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCDeployCenterBase.getPSDeployCenterId() != null) {
            object = pSDCDeployCenterBase.getPSDeployCenterId();
            xmlNode.setAttribute(FIELD_PSDEPLOYCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCDeployCenterBase.getPSDeployCenterName() != null) {
            object = pSDCDeployCenterBase.getPSDeployCenterName();
            xmlNode.setAttribute(FIELD_PSDEPLOYCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCDeployCenterBase.getPSDevCenterId() != null) {
            object = pSDCDeployCenterBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCDeployCenterBase.getPSDevCenterName() != null) {
            object = pSDCDeployCenterBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCDeployCenterBase.getPSDevSlnId() != null) {
            object = pSDCDeployCenterBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDCDeployCenterBase.getPSDevSlnName() != null) {
            object = pSDCDeployCenterBase.getPSDevSlnName();
            xmlNode.setAttribute(FIELD_PSDEVSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCDeployCenterBase.getPSGitUsers() != null) {
            object = pSDCDeployCenterBase.getPSGitUsers();
            xmlNode.setAttribute(FIELD_PSGITUSERS, object == null ? "" : (String)object);
        }
        if (bl || pSDCDeployCenterBase.getRefCount() != null) {
            object = pSDCDeployCenterBase.getRefCount();
            xmlNode.setAttribute(FIELD_REFCOUNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCDeployCenterBase.getResPos() != null) {
            object = pSDCDeployCenterBase.getResPos();
            xmlNode.setAttribute(FIELD_RESPOS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCDeployCenterBase.getResReadyTime() != null) {
            object = pSDCDeployCenterBase.getResReadyTime();
            xmlNode.setAttribute(FIELD_RESREADYTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCDeployCenterBase.getResState() != null) {
            object = pSDCDeployCenterBase.getResState();
            xmlNode.setAttribute(FIELD_RESSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCDeployCenterBase.getResVer() != null) {
            object = pSDCDeployCenterBase.getResVer();
            xmlNode.setAttribute(FIELD_RESVER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCDeployCenterBase.getSSHIPAddr() != null) {
            object = pSDCDeployCenterBase.getSSHIPAddr();
            xmlNode.setAttribute(FIELD_SSHIPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSDCDeployCenterBase.getSSHPort() != null) {
            object = pSDCDeployCenterBase.getSSHPort();
            xmlNode.setAttribute(FIELD_SSHPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCDeployCenterBase.getUpdateDate() != null) {
            object = pSDCDeployCenterBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCDeployCenterBase.getUpdateMan() != null) {
            object = pSDCDeployCenterBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCDeployCenterBase.getUploadFileMode() != null) {
            object = pSDCDeployCenterBase.getUploadFileMode();
            xmlNode.setAttribute(FIELD_UPLOADFILEMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDCDeployCenterBase.getUploadPath() != null) {
            object = pSDCDeployCenterBase.getUploadPath();
            xmlNode.setAttribute(FIELD_UPLOADPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDCDeployCenterBase.getUserName() != null) {
            object = pSDCDeployCenterBase.getUserName();
            xmlNode.setAttribute(FIELD_USERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCDeployCenterBase.getValidFlag() != null) {
            object = pSDCDeployCenterBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCDeployCenterBase.getWebConsolePath() != null) {
            object = pSDCDeployCenterBase.getWebConsolePath();
            xmlNode.setAttribute(FIELD_WEBCONSOLEPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDCDeployCenterBase.getWorkshopPath() != null) {
            object = pSDCDeployCenterBase.getWorkshopPath();
            xmlNode.setAttribute(FIELD_WORKSHOPPATH, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCDeployCenterBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCDeployCenterBase pSDCDeployCenterBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCDeployCenterBase.isAdminPasswdDirty() && (bl || pSDCDeployCenterBase.getAdminPasswd() != null)) {
            iDataObject.set(FIELD_ADMINPASSWD, (Object)pSDCDeployCenterBase.getAdminPasswd());
        }
        if (pSDCDeployCenterBase.isAdminUserNameDirty() && (bl || pSDCDeployCenterBase.getAdminUserName() != null)) {
            iDataObject.set(FIELD_ADMINUSERNAME, (Object)pSDCDeployCenterBase.getAdminUserName());
        }
        if (pSDCDeployCenterBase.isAPITokenDirty() && (bl || pSDCDeployCenterBase.getAPIToken() != null)) {
            iDataObject.set(FIELD_APITOKEN, (Object)pSDCDeployCenterBase.getAPIToken());
        }
        if (pSDCDeployCenterBase.isAPIUrlDirty() && (bl || pSDCDeployCenterBase.getAPIUrl() != null)) {
            iDataObject.set(FIELD_APIURL, (Object)pSDCDeployCenterBase.getAPIUrl());
        }
        if (pSDCDeployCenterBase.isCfgBranchDirty() && (bl || pSDCDeployCenterBase.getCfgBranch() != null)) {
            iDataObject.set(FIELD_CFGBRANCH, (Object)pSDCDeployCenterBase.getCfgBranch());
        }
        if (pSDCDeployCenterBase.isCfgPSCredentialIdDirty() && (bl || pSDCDeployCenterBase.getCfgPSCredentialId() != null)) {
            iDataObject.set(FIELD_CFGPSCREDENTIALID, (Object)pSDCDeployCenterBase.getCfgPSCredentialId());
        }
        if (pSDCDeployCenterBase.isCfgPSCredentialNameDirty() && (bl || pSDCDeployCenterBase.getCfgPSCredentialName() != null)) {
            iDataObject.set(FIELD_CFGPSCREDENTIALNAME, (Object)pSDCDeployCenterBase.getCfgPSCredentialName());
        }
        if (pSDCDeployCenterBase.isCfgPSDevCenterSVNIdDirty() && (bl || pSDCDeployCenterBase.getCfgPSDevCenterSVNId() != null)) {
            iDataObject.set(FIELD_CFGPSDEVCENTERSVNID, (Object)pSDCDeployCenterBase.getCfgPSDevCenterSVNId());
        }
        if (pSDCDeployCenterBase.isCfgPSDevCenterSVNNameDirty() && (bl || pSDCDeployCenterBase.getCfgPSDevCenterSVNName() != null)) {
            iDataObject.set(FIELD_CFGPSDEVCENTERSVNNAME, (Object)pSDCDeployCenterBase.getCfgPSDevCenterSVNName());
        }
        if (pSDCDeployCenterBase.isCfgUrlDirty() && (bl || pSDCDeployCenterBase.getCfgUrl() != null)) {
            iDataObject.set(FIELD_CFGURL, (Object)pSDCDeployCenterBase.getCfgUrl());
        }
        if (pSDCDeployCenterBase.isCreateDateDirty() && (bl || pSDCDeployCenterBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCDeployCenterBase.getCreateDate());
        }
        if (pSDCDeployCenterBase.isCreateManDirty() && (bl || pSDCDeployCenterBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCDeployCenterBase.getCreateMan());
        }
        if (pSDCDeployCenterBase.isDCTypeDirty() && (bl || pSDCDeployCenterBase.getDCType() != null)) {
            iDataObject.set(FIELD_DCTYPE, (Object)pSDCDeployCenterBase.getDCType());
        }
        if (pSDCDeployCenterBase.isDCType2Dirty() && (bl || pSDCDeployCenterBase.getDCType2() != null)) {
            iDataObject.set(FIELD_DCTYPE2, (Object)pSDCDeployCenterBase.getDCType2());
        }
        if (pSDCDeployCenterBase.isDefaultFlagDirty() && (bl || pSDCDeployCenterBase.getDefaultFlag() != null)) {
            iDataObject.set(FIELD_DEFAULTFLAG, (Object)pSDCDeployCenterBase.getDefaultFlag());
        }
        if (pSDCDeployCenterBase.isExpriedTimeDirty() && (bl || pSDCDeployCenterBase.getExpriedTime() != null)) {
            iDataObject.set(FIELD_EXPRIEDTIME, (Object)pSDCDeployCenterBase.getExpriedTime());
        }
        if (pSDCDeployCenterBase.isIpAddrDirty() && (bl || pSDCDeployCenterBase.getIpAddr() != null)) {
            iDataObject.set(FIELD_IPADDR, (Object)pSDCDeployCenterBase.getIpAddr());
        }
        if (pSDCDeployCenterBase.isIpAddr2Dirty() && (bl || pSDCDeployCenterBase.getIpAddr2() != null)) {
            iDataObject.set(FIELD_IPADDR2, (Object)pSDCDeployCenterBase.getIpAddr2());
        }
        if (pSDCDeployCenterBase.isMemoDirty() && (bl || pSDCDeployCenterBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCDeployCenterBase.getMemo());
        }
        if (pSDCDeployCenterBase.isPasswdDirty() && (bl || pSDCDeployCenterBase.getPasswd() != null)) {
            iDataObject.set(FIELD_PASSWD, (Object)pSDCDeployCenterBase.getPasswd());
        }
        if (pSDCDeployCenterBase.isPortDirty() && (bl || pSDCDeployCenterBase.getPort() != null)) {
            iDataObject.set(FIELD_PORT, (Object)pSDCDeployCenterBase.getPort());
        }
        if (pSDCDeployCenterBase.isPSCredentialIdDirty() && (bl || pSDCDeployCenterBase.getPSCredentialId() != null)) {
            iDataObject.set(FIELD_PSCREDENTIALID, (Object)pSDCDeployCenterBase.getPSCredentialId());
        }
        if (pSDCDeployCenterBase.isPSCredentialNameDirty() && (bl || pSDCDeployCenterBase.getPSCredentialName() != null)) {
            iDataObject.set(FIELD_PSCREDENTIALNAME, (Object)pSDCDeployCenterBase.getPSCredentialName());
        }
        if (pSDCDeployCenterBase.isPSCredentialsDirty() && (bl || pSDCDeployCenterBase.getPSCredentials() != null)) {
            iDataObject.set(FIELD_PSCREDENTIALS, (Object)pSDCDeployCenterBase.getPSCredentials());
        }
        if (pSDCDeployCenterBase.isPSDCClusterIdDirty() && (bl || pSDCDeployCenterBase.getPSDCClusterId() != null)) {
            iDataObject.set(FIELD_PSDCCLUSTERID, (Object)pSDCDeployCenterBase.getPSDCClusterId());
        }
        if (pSDCDeployCenterBase.isPSDCClusterNameDirty() && (bl || pSDCDeployCenterBase.getPSDCClusterName() != null)) {
            iDataObject.set(FIELD_PSDCCLUSTERNAME, (Object)pSDCDeployCenterBase.getPSDCClusterName());
        }
        if (pSDCDeployCenterBase.isPSDCContainerSpecIdDirty() && (bl || pSDCDeployCenterBase.getPSDCContainerSpecId() != null)) {
            iDataObject.set(FIELD_PSDCCONTAINERSPECID, (Object)pSDCDeployCenterBase.getPSDCContainerSpecId());
        }
        if (pSDCDeployCenterBase.isPSDCContainerSpecNameDirty() && (bl || pSDCDeployCenterBase.getPSDCContainerSpecName() != null)) {
            iDataObject.set(FIELD_PSDCCONTAINERSPECNAME, (Object)pSDCDeployCenterBase.getPSDCContainerSpecName());
        }
        if (pSDCDeployCenterBase.isPSDCDeployCenterIdDirty() && (bl || pSDCDeployCenterBase.getPSDCDeployCenterId() != null)) {
            iDataObject.set(FIELD_PSDCDEPLOYCENTERID, (Object)pSDCDeployCenterBase.getPSDCDeployCenterId());
        }
        if (pSDCDeployCenterBase.isPSDCDeployCenterNameDirty() && (bl || pSDCDeployCenterBase.getPSDCDeployCenterName() != null)) {
            iDataObject.set(FIELD_PSDCDEPLOYCENTERNAME, (Object)pSDCDeployCenterBase.getPSDCDeployCenterName());
        }
        if (pSDCDeployCenterBase.isPSDCFileIdDirty() && (bl || pSDCDeployCenterBase.getPSDCFileId() != null)) {
            iDataObject.set(FIELD_PSDCFILEID, (Object)pSDCDeployCenterBase.getPSDCFileId());
        }
        if (pSDCDeployCenterBase.isPSDCFileNameDirty() && (bl || pSDCDeployCenterBase.getPSDCFileName() != null)) {
            iDataObject.set(FIELD_PSDCFILENAME, (Object)pSDCDeployCenterBase.getPSDCFileName());
        }
        if (pSDCDeployCenterBase.isPSDCRegistryRepoIdDirty() && (bl || pSDCDeployCenterBase.getPSDCRegistryRepoId() != null)) {
            iDataObject.set(FIELD_PSDCREGISTRYREPOID, (Object)pSDCDeployCenterBase.getPSDCRegistryRepoId());
        }
        if (pSDCDeployCenterBase.isPSDCRegistryRepoNameDirty() && (bl || pSDCDeployCenterBase.getPSDCRegistryRepoName() != null)) {
            iDataObject.set(FIELD_PSDCREGISTRYREPONAME, (Object)pSDCDeployCenterBase.getPSDCRegistryRepoName());
        }
        if (pSDCDeployCenterBase.isPSDeployCenterIdDirty() && (bl || pSDCDeployCenterBase.getPSDeployCenterId() != null)) {
            iDataObject.set(FIELD_PSDEPLOYCENTERID, (Object)pSDCDeployCenterBase.getPSDeployCenterId());
        }
        if (pSDCDeployCenterBase.isPSDeployCenterNameDirty() && (bl || pSDCDeployCenterBase.getPSDeployCenterName() != null)) {
            iDataObject.set(FIELD_PSDEPLOYCENTERNAME, (Object)pSDCDeployCenterBase.getPSDeployCenterName());
        }
        if (pSDCDeployCenterBase.isPSDevCenterIdDirty() && (bl || pSDCDeployCenterBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDCDeployCenterBase.getPSDevCenterId());
        }
        if (pSDCDeployCenterBase.isPSDevCenterNameDirty() && (bl || pSDCDeployCenterBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDCDeployCenterBase.getPSDevCenterName());
        }
        if (pSDCDeployCenterBase.isPSDevSlnIdDirty() && (bl || pSDCDeployCenterBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDCDeployCenterBase.getPSDevSlnId());
        }
        if (pSDCDeployCenterBase.isPSDevSlnNameDirty() && (bl || pSDCDeployCenterBase.getPSDevSlnName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNNAME, (Object)pSDCDeployCenterBase.getPSDevSlnName());
        }
        if (pSDCDeployCenterBase.isPSGitUsersDirty() && (bl || pSDCDeployCenterBase.getPSGitUsers() != null)) {
            iDataObject.set(FIELD_PSGITUSERS, (Object)pSDCDeployCenterBase.getPSGitUsers());
        }
        if (pSDCDeployCenterBase.isRefCountDirty() && (bl || pSDCDeployCenterBase.getRefCount() != null)) {
            iDataObject.set(FIELD_REFCOUNT, (Object)pSDCDeployCenterBase.getRefCount());
        }
        if (pSDCDeployCenterBase.isResPosDirty() && (bl || pSDCDeployCenterBase.getResPos() != null)) {
            iDataObject.set(FIELD_RESPOS, (Object)pSDCDeployCenterBase.getResPos());
        }
        if (pSDCDeployCenterBase.isResReadyTimeDirty() && (bl || pSDCDeployCenterBase.getResReadyTime() != null)) {
            iDataObject.set(FIELD_RESREADYTIME, (Object)pSDCDeployCenterBase.getResReadyTime());
        }
        if (pSDCDeployCenterBase.isResStateDirty() && (bl || pSDCDeployCenterBase.getResState() != null)) {
            iDataObject.set(FIELD_RESSTATE, (Object)pSDCDeployCenterBase.getResState());
        }
        if (pSDCDeployCenterBase.isResVerDirty() && (bl || pSDCDeployCenterBase.getResVer() != null)) {
            iDataObject.set(FIELD_RESVER, (Object)pSDCDeployCenterBase.getResVer());
        }
        if (pSDCDeployCenterBase.isSSHIPAddrDirty() && (bl || pSDCDeployCenterBase.getSSHIPAddr() != null)) {
            iDataObject.set(FIELD_SSHIPADDR, (Object)pSDCDeployCenterBase.getSSHIPAddr());
        }
        if (pSDCDeployCenterBase.isSSHPortDirty() && (bl || pSDCDeployCenterBase.getSSHPort() != null)) {
            iDataObject.set(FIELD_SSHPORT, (Object)pSDCDeployCenterBase.getSSHPort());
        }
        if (pSDCDeployCenterBase.isUpdateDateDirty() && (bl || pSDCDeployCenterBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCDeployCenterBase.getUpdateDate());
        }
        if (pSDCDeployCenterBase.isUpdateManDirty() && (bl || pSDCDeployCenterBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCDeployCenterBase.getUpdateMan());
        }
        if (pSDCDeployCenterBase.isUploadFileModeDirty() && (bl || pSDCDeployCenterBase.getUploadFileMode() != null)) {
            iDataObject.set(FIELD_UPLOADFILEMODE, (Object)pSDCDeployCenterBase.getUploadFileMode());
        }
        if (pSDCDeployCenterBase.isUploadPathDirty() && (bl || pSDCDeployCenterBase.getUploadPath() != null)) {
            iDataObject.set(FIELD_UPLOADPATH, (Object)pSDCDeployCenterBase.getUploadPath());
        }
        if (pSDCDeployCenterBase.isUserNameDirty() && (bl || pSDCDeployCenterBase.getUserName() != null)) {
            iDataObject.set(FIELD_USERNAME, (Object)pSDCDeployCenterBase.getUserName());
        }
        if (pSDCDeployCenterBase.isValidFlagDirty() && (bl || pSDCDeployCenterBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDCDeployCenterBase.getValidFlag());
        }
        if (pSDCDeployCenterBase.isWebConsolePathDirty() && (bl || pSDCDeployCenterBase.getWebConsolePath() != null)) {
            iDataObject.set(FIELD_WEBCONSOLEPATH, (Object)pSDCDeployCenterBase.getWebConsolePath());
        }
        if (pSDCDeployCenterBase.isWorkshopPathDirty() && (bl || pSDCDeployCenterBase.getWorkshopPath() != null)) {
            iDataObject.set(FIELD_WORKSHOPPATH, (Object)pSDCDeployCenterBase.getWorkshopPath());
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
        return PSDCDeployCenterBase.remove(this, n);
    }

    private static boolean remove(PSDCDeployCenterBase pSDCDeployCenterBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCDeployCenterBase.resetAdminPasswd();
                return true;
            }
            case 1: {
                pSDCDeployCenterBase.resetAdminUserName();
                return true;
            }
            case 2: {
                pSDCDeployCenterBase.resetAPIToken();
                return true;
            }
            case 3: {
                pSDCDeployCenterBase.resetAPIUrl();
                return true;
            }
            case 4: {
                pSDCDeployCenterBase.resetCfgBranch();
                return true;
            }
            case 5: {
                pSDCDeployCenterBase.resetCfgPSCredentialId();
                return true;
            }
            case 6: {
                pSDCDeployCenterBase.resetCfgPSCredentialName();
                return true;
            }
            case 7: {
                pSDCDeployCenterBase.resetCfgPSDevCenterSVNId();
                return true;
            }
            case 8: {
                pSDCDeployCenterBase.resetCfgPSDevCenterSVNName();
                return true;
            }
            case 9: {
                pSDCDeployCenterBase.resetCfgUrl();
                return true;
            }
            case 10: {
                pSDCDeployCenterBase.resetCreateDate();
                return true;
            }
            case 11: {
                pSDCDeployCenterBase.resetCreateMan();
                return true;
            }
            case 12: {
                pSDCDeployCenterBase.resetDCType();
                return true;
            }
            case 13: {
                pSDCDeployCenterBase.resetDCType2();
                return true;
            }
            case 14: {
                pSDCDeployCenterBase.resetDefaultFlag();
                return true;
            }
            case 15: {
                pSDCDeployCenterBase.resetExpriedTime();
                return true;
            }
            case 16: {
                pSDCDeployCenterBase.resetIpAddr();
                return true;
            }
            case 17: {
                pSDCDeployCenterBase.resetIpAddr2();
                return true;
            }
            case 18: {
                pSDCDeployCenterBase.resetMemo();
                return true;
            }
            case 19: {
                pSDCDeployCenterBase.resetPasswd();
                return true;
            }
            case 20: {
                pSDCDeployCenterBase.resetPort();
                return true;
            }
            case 21: {
                pSDCDeployCenterBase.resetPSCredentialId();
                return true;
            }
            case 22: {
                pSDCDeployCenterBase.resetPSCredentialName();
                return true;
            }
            case 23: {
                pSDCDeployCenterBase.resetPSCredentials();
                return true;
            }
            case 24: {
                pSDCDeployCenterBase.resetPSDCClusterId();
                return true;
            }
            case 25: {
                pSDCDeployCenterBase.resetPSDCClusterName();
                return true;
            }
            case 26: {
                pSDCDeployCenterBase.resetPSDCContainerSpecId();
                return true;
            }
            case 27: {
                pSDCDeployCenterBase.resetPSDCContainerSpecName();
                return true;
            }
            case 28: {
                pSDCDeployCenterBase.resetPSDCDeployCenterId();
                return true;
            }
            case 29: {
                pSDCDeployCenterBase.resetPSDCDeployCenterName();
                return true;
            }
            case 30: {
                pSDCDeployCenterBase.resetPSDCFileId();
                return true;
            }
            case 31: {
                pSDCDeployCenterBase.resetPSDCFileName();
                return true;
            }
            case 32: {
                pSDCDeployCenterBase.resetPSDCRegistryRepoId();
                return true;
            }
            case 33: {
                pSDCDeployCenterBase.resetPSDCRegistryRepoName();
                return true;
            }
            case 34: {
                pSDCDeployCenterBase.resetPSDeployCenterId();
                return true;
            }
            case 35: {
                pSDCDeployCenterBase.resetPSDeployCenterName();
                return true;
            }
            case 36: {
                pSDCDeployCenterBase.resetPSDevCenterId();
                return true;
            }
            case 37: {
                pSDCDeployCenterBase.resetPSDevCenterName();
                return true;
            }
            case 38: {
                pSDCDeployCenterBase.resetPSDevSlnId();
                return true;
            }
            case 39: {
                pSDCDeployCenterBase.resetPSDevSlnName();
                return true;
            }
            case 40: {
                pSDCDeployCenterBase.resetPSGitUsers();
                return true;
            }
            case 41: {
                pSDCDeployCenterBase.resetRefCount();
                return true;
            }
            case 42: {
                pSDCDeployCenterBase.resetResPos();
                return true;
            }
            case 43: {
                pSDCDeployCenterBase.resetResReadyTime();
                return true;
            }
            case 44: {
                pSDCDeployCenterBase.resetResState();
                return true;
            }
            case 45: {
                pSDCDeployCenterBase.resetResVer();
                return true;
            }
            case 46: {
                pSDCDeployCenterBase.resetSSHIPAddr();
                return true;
            }
            case 47: {
                pSDCDeployCenterBase.resetSSHPort();
                return true;
            }
            case 48: {
                pSDCDeployCenterBase.resetUpdateDate();
                return true;
            }
            case 49: {
                pSDCDeployCenterBase.resetUpdateMan();
                return true;
            }
            case 50: {
                pSDCDeployCenterBase.resetUploadFileMode();
                return true;
            }
            case 51: {
                pSDCDeployCenterBase.resetUploadPath();
                return true;
            }
            case 52: {
                pSDCDeployCenterBase.resetUserName();
                return true;
            }
            case 53: {
                pSDCDeployCenterBase.resetValidFlag();
                return true;
            }
            case 54: {
                pSDCDeployCenterBase.resetWebConsolePath();
                return true;
            }
            case 55: {
                pSDCDeployCenterBase.resetWorkshopPath();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCredential getCfgPSCredential() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCfgPSCredential();
        }
        if (this.getCfgPSCredentialId() == null) {
            return null;
        }
        Integer n = this.objCfgPSCredentialLock;
        synchronized (n) {
            if (this.cfgpscredential != null && DataTypeHelper.compare((int)25, (Object)this.getCfgPSCredentialId(), (Object)this.cfgpscredential.getPSCredentialId()) != 0L) {
                this.cfgpscredential = null;
            }
            if (this.cfgpscredential == null) {
                PSCredential pSCredential = new PSCredential();
                pSCredential.setPSCredentialId(this.getCfgPSCredentialId());
                PSCredentialService pSCredentialService = (PSCredentialService)ServiceGlobal.getService(PSCredentialService.class, (SessionFactory)this.getSessionFactory());
                pSCredentialService.autoGet(pSCredential);
                this.cfgpscredential = pSCredential;
            }
            return this.cfgpscredential;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCredential getPSCredential() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCredential();
        }
        if (this.getPSCredentialId() == null) {
            return null;
        }
        Integer n = this.objPSCredentialLock;
        synchronized (n) {
            if (this.pscredential != null && DataTypeHelper.compare((int)25, (Object)this.getPSCredentialId(), (Object)this.pscredential.getPSCredentialId()) != 0L) {
                this.pscredential = null;
            }
            if (this.pscredential == null) {
                PSCredential pSCredential = new PSCredential();
                pSCredential.setPSCredentialId(this.getPSCredentialId());
                PSCredentialService pSCredentialService = (PSCredentialService)ServiceGlobal.getService(PSCredentialService.class, (SessionFactory)this.getSessionFactory());
                pSCredentialService.autoGet(pSCredential);
                this.pscredential = pSCredential;
            }
            return this.pscredential;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCCluster getPSDCCluster() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCCluster();
        }
        if (this.getPSDCClusterId() == null) {
            return null;
        }
        Integer n = this.objPSDCClusterLock;
        synchronized (n) {
            if (this.psdccluster != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCClusterId(), (Object)this.psdccluster.getPSDCClusterId()) != 0L) {
                this.psdccluster = null;
            }
            if (this.psdccluster == null) {
                PSDCCluster pSDCCluster = new PSDCCluster();
                pSDCCluster.setPSDCClusterId(this.getPSDCClusterId());
                PSDCClusterService pSDCClusterService = (PSDCClusterService)ServiceGlobal.getService(PSDCClusterService.class, (SessionFactory)this.getSessionFactory());
                pSDCClusterService.autoGet(pSDCCluster);
                this.psdccluster = pSDCCluster;
            }
            return this.psdccluster;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCContainerSpec getPSDCContainerSpec() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCContainerSpec();
        }
        if (this.getPSDCContainerSpecId() == null) {
            return null;
        }
        Integer n = this.objPSDCContainerSpecLock;
        synchronized (n) {
            if (this.psdccontainerspec != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCContainerSpecId(), (Object)this.psdccontainerspec.getPSDCContainerSpecId()) != 0L) {
                this.psdccontainerspec = null;
            }
            if (this.psdccontainerspec == null) {
                PSDCContainerSpec pSDCContainerSpec = new PSDCContainerSpec();
                pSDCContainerSpec.setPSDCContainerSpecId(this.getPSDCContainerSpecId());
                PSDCContainerSpecService pSDCContainerSpecService = (PSDCContainerSpecService)ServiceGlobal.getService(PSDCContainerSpecService.class, (SessionFactory)this.getSessionFactory());
                pSDCContainerSpecService.autoGet(pSDCContainerSpec);
                this.psdccontainerspec = pSDCContainerSpec;
            }
            return this.psdccontainerspec;
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
    public PSDeployCenter getPSDeployCenter() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDeployCenter();
        }
        if (this.getPSDeployCenterId() == null) {
            return null;
        }
        Integer n = this.objPSDeployCenterLock;
        synchronized (n) {
            if (this.psdeploycenter != null && DataTypeHelper.compare((int)25, (Object)this.getPSDeployCenterId(), (Object)this.psdeploycenter.getPSDeployCenterId()) != 0L) {
                this.psdeploycenter = null;
            }
            if (this.psdeploycenter == null) {
                PSDeployCenter pSDeployCenter = new PSDeployCenter();
                pSDeployCenter.setPSDeployCenterId(this.getPSDeployCenterId());
                PSDeployCenterService pSDeployCenterService = (PSDeployCenterService)ServiceGlobal.getService(PSDeployCenterService.class, (SessionFactory)this.getSessionFactory());
                pSDeployCenterService.autoGet(pSDeployCenter);
                this.psdeploycenter = pSDeployCenter;
            }
            return this.psdeploycenter;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterSVN getCfgPSDevCenterSVN() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCfgPSDevCenterSVN();
        }
        if (this.getCfgPSDevCenterSVNId() == null) {
            return null;
        }
        Integer n = this.objCfgPSDevCenterSVNLock;
        synchronized (n) {
            if (this.cfgpsdevcentersvn != null && DataTypeHelper.compare((int)25, (Object)this.getCfgPSDevCenterSVNId(), (Object)this.cfgpsdevcentersvn.getPSDevCenterSVNId()) != 0L) {
                this.cfgpsdevcentersvn = null;
            }
            if (this.cfgpsdevcentersvn == null) {
                PSDevCenterSVN pSDevCenterSVN = new PSDevCenterSVN();
                pSDevCenterSVN.setPSDevCenterSVNId(this.getCfgPSDevCenterSVNId());
                PSDevCenterSVNService pSDevCenterSVNService = (PSDevCenterSVNService)ServiceGlobal.getService(PSDevCenterSVNService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterSVNService.autoGet(pSDevCenterSVN);
                this.cfgpsdevcentersvn = pSDevCenterSVN;
            }
            return this.cfgpsdevcentersvn;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenter getPSDevCenter() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenter();
        }
        if (this.getPSDevCenterId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterLock;
        synchronized (n) {
            if (this.psdevcenter != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterId(), (Object)this.psdevcenter.getPSDevCenterId()) != 0L) {
                this.psdevcenter = null;
            }
            if (this.psdevcenter == null) {
                PSDevCenter pSDevCenter = new PSDevCenter();
                pSDevCenter.setPSDevCenterId(this.getPSDevCenterId());
                PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterService.autoGet(pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSln getPSDevSln() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSln();
        }
        if (this.getPSDevSlnId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnLock;
        synchronized (n) {
            if (this.psdevsln != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnId(), (Object)this.psdevsln.getPSDevSlnId()) != 0L) {
                this.psdevsln = null;
            }
            if (this.psdevsln == null) {
                PSDevSln pSDevSln = new PSDevSln();
                pSDevSln.setPSDevSlnId(this.getPSDevSlnId());
                PSDevSlnService pSDevSlnService = (PSDevSlnService)ServiceGlobal.getService(PSDevSlnService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnService.autoGet(pSDevSln);
                this.psdevsln = pSDevSln;
            }
            return this.psdevsln;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDCDeployServer> getPSDCDeployServers() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCDeployServers();
        }
        if (this.getPSDCDeployCenterId() == null) {
            return null;
        }
        PSDCDeployServerService pSDCDeployServerService = (PSDCDeployServerService)ServiceGlobal.getService(PSDCDeployServerService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDCDeployServersLock;
        synchronized (n) {
            if (this.psdcdeployservers == null) {
                this.psdcdeployservers = pSDCDeployServerService.selectByPSDCDeployCenter(this);
            }
            return this.psdcdeployservers;
        }
    }

    private PSDCDeployCenterBase getProxyEntity() {
        return this.proxyPSDCDeployCenterBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCDeployCenterBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCDeployCenterBase) {
            this.proxyPSDCDeployCenterBase = (PSDCDeployCenterBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCDeployCenterService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ADMINPASSWD, 0);
        fieldIndexMap.put(FIELD_ADMINUSERNAME, 1);
        fieldIndexMap.put(FIELD_APITOKEN, 2);
        fieldIndexMap.put(FIELD_APIURL, 3);
        fieldIndexMap.put(FIELD_CFGBRANCH, 4);
        fieldIndexMap.put(FIELD_CFGPSCREDENTIALID, 5);
        fieldIndexMap.put(FIELD_CFGPSCREDENTIALNAME, 6);
        fieldIndexMap.put(FIELD_CFGPSDEVCENTERSVNID, 7);
        fieldIndexMap.put(FIELD_CFGPSDEVCENTERSVNNAME, 8);
        fieldIndexMap.put(FIELD_CFGURL, 9);
        fieldIndexMap.put(FIELD_CREATEDATE, 10);
        fieldIndexMap.put(FIELD_CREATEMAN, 11);
        fieldIndexMap.put(FIELD_DCTYPE, 12);
        fieldIndexMap.put(FIELD_DCTYPE2, 13);
        fieldIndexMap.put(FIELD_DEFAULTFLAG, 14);
        fieldIndexMap.put(FIELD_EXPRIEDTIME, 15);
        fieldIndexMap.put(FIELD_IPADDR, 16);
        fieldIndexMap.put(FIELD_IPADDR2, 17);
        fieldIndexMap.put(FIELD_MEMO, 18);
        fieldIndexMap.put(FIELD_PASSWD, 19);
        fieldIndexMap.put(FIELD_PORT, 20);
        fieldIndexMap.put(FIELD_PSCREDENTIALID, 21);
        fieldIndexMap.put(FIELD_PSCREDENTIALNAME, 22);
        fieldIndexMap.put(FIELD_PSCREDENTIALS, 23);
        fieldIndexMap.put(FIELD_PSDCCLUSTERID, 24);
        fieldIndexMap.put(FIELD_PSDCCLUSTERNAME, 25);
        fieldIndexMap.put(FIELD_PSDCCONTAINERSPECID, 26);
        fieldIndexMap.put(FIELD_PSDCCONTAINERSPECNAME, 27);
        fieldIndexMap.put(FIELD_PSDCDEPLOYCENTERID, 28);
        fieldIndexMap.put(FIELD_PSDCDEPLOYCENTERNAME, 29);
        fieldIndexMap.put(FIELD_PSDCFILEID, 30);
        fieldIndexMap.put(FIELD_PSDCFILENAME, 31);
        fieldIndexMap.put(FIELD_PSDCREGISTRYREPOID, 32);
        fieldIndexMap.put(FIELD_PSDCREGISTRYREPONAME, 33);
        fieldIndexMap.put(FIELD_PSDEPLOYCENTERID, 34);
        fieldIndexMap.put(FIELD_PSDEPLOYCENTERNAME, 35);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 36);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 37);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 38);
        fieldIndexMap.put(FIELD_PSDEVSLNNAME, 39);
        fieldIndexMap.put(FIELD_PSGITUSERS, 40);
        fieldIndexMap.put(FIELD_REFCOUNT, 41);
        fieldIndexMap.put(FIELD_RESPOS, 42);
        fieldIndexMap.put(FIELD_RESREADYTIME, 43);
        fieldIndexMap.put(FIELD_RESSTATE, 44);
        fieldIndexMap.put(FIELD_RESVER, 45);
        fieldIndexMap.put(FIELD_SSHIPADDR, 46);
        fieldIndexMap.put(FIELD_SSHPORT, 47);
        fieldIndexMap.put(FIELD_UPDATEDATE, 48);
        fieldIndexMap.put(FIELD_UPDATEMAN, 49);
        fieldIndexMap.put(FIELD_UPLOADFILEMODE, 50);
        fieldIndexMap.put(FIELD_UPLOADPATH, 51);
        fieldIndexMap.put(FIELD_USERNAME, 52);
        fieldIndexMap.put(FIELD_VALIDFLAG, 53);
        fieldIndexMap.put(FIELD_WEBCONSOLEPATH, 54);
        fieldIndexMap.put(FIELD_WORKSHOPPATH, 55);
    }
}

