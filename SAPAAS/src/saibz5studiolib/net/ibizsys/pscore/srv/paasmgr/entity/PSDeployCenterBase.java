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
package net.ibizsys.pscore.srv.paasmgr.entity;

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
import net.ibizsys.pscore.srv.paasmgr.entity.PSRegistryRepo;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain;
import net.ibizsys.pscore.srv.paasmgr.service.PSRegistryRepoService;
import net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDeployCenterBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDeployCenterBase.class);
    public static final String FIELD_ADMINPASSWD = "ADMINPASSWD";
    public static final String FIELD_ADMINUSERNAME = "ADMINUSERNAME";
    public static final String FIELD_APITOKEN = "APITOKEN";
    public static final String FIELD_APIURL = "APIURL";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DCTYPE = "DCTYPE";
    public static final String FIELD_DCTYPE2 = "DCTYPE2";
    public static final String FIELD_IPADDR = "IPADDR";
    public static final String FIELD_IPADDR2 = "IPADDR2";
    public static final String FIELD_LOCALRES = "LOCALRES";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PASSWD = "PASSWD";
    public static final String FIELD_PORT = "PORT";
    public static final String FIELD_PSDEPLOYCENTERID = "PSDEPLOYCENTERID";
    public static final String FIELD_PSDEPLOYCENTERNAME = "PSDEPLOYCENTERNAME";
    public static final String FIELD_PSREGISTRYREPOID = "PSREGISTRYREPOID";
    public static final String FIELD_PSREGISTRYREPONAME = "PSREGISTRYREPONAME";
    public static final String FIELD_PSSVRDOMAINID = "PSSVRDOMAINID";
    public static final String FIELD_PSSVRDOMAINNAME = "PSSVRDOMAINNAME";
    public static final String FIELD_RESSTATE = "RESSTATE";
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
    private static final int INDEX_CREATEDATE = 4;
    private static final int INDEX_CREATEMAN = 5;
    private static final int INDEX_DCTYPE = 6;
    private static final int INDEX_DCTYPE2 = 7;
    private static final int INDEX_IPADDR = 8;
    private static final int INDEX_IPADDR2 = 9;
    private static final int INDEX_LOCALRES = 10;
    private static final int INDEX_MEMO = 11;
    private static final int INDEX_PASSWD = 12;
    private static final int INDEX_PORT = 13;
    private static final int INDEX_PSDEPLOYCENTERID = 14;
    private static final int INDEX_PSDEPLOYCENTERNAME = 15;
    private static final int INDEX_PSREGISTRYREPOID = 16;
    private static final int INDEX_PSREGISTRYREPONAME = 17;
    private static final int INDEX_PSSVRDOMAINID = 18;
    private static final int INDEX_PSSVRDOMAINNAME = 19;
    private static final int INDEX_RESSTATE = 20;
    private static final int INDEX_SSHIPADDR = 21;
    private static final int INDEX_SSHPORT = 22;
    private static final int INDEX_UPDATEDATE = 23;
    private static final int INDEX_UPDATEMAN = 24;
    private static final int INDEX_UPLOADFILEMODE = 25;
    private static final int INDEX_UPLOADPATH = 26;
    private static final int INDEX_USERNAME = 27;
    private static final int INDEX_VALIDFLAG = 28;
    private static final int INDEX_WEBCONSOLEPATH = 29;
    private static final int INDEX_WORKSHOPPATH = 30;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDeployCenterBase proxyPSDeployCenterBase = null;
    private boolean adminpasswdDirtyFlag = false;
    private boolean adminusernameDirtyFlag = false;
    private boolean apitokenDirtyFlag = false;
    private boolean apiurlDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dctypeDirtyFlag = false;
    private boolean dctype2DirtyFlag = false;
    private boolean ipaddrDirtyFlag = false;
    private boolean ipaddr2DirtyFlag = false;
    private boolean localresDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean passwdDirtyFlag = false;
    private boolean portDirtyFlag = false;
    private boolean psdeploycenteridDirtyFlag = false;
    private boolean psdeploycenternameDirtyFlag = false;
    private boolean psregistryrepoidDirtyFlag = false;
    private boolean psregistryreponameDirtyFlag = false;
    private boolean pssvrdomainidDirtyFlag = false;
    private boolean pssvrdomainnameDirtyFlag = false;
    private boolean resstateDirtyFlag = false;
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
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dctype")
    private String dctype;
    @Column(name="dctype2")
    private String dctype2;
    @Column(name="ipaddr")
    private String ipaddr;
    @Column(name="ipaddr2")
    private String ipaddr2;
    @Column(name="localres")
    private Integer localres;
    @Column(name="memo")
    private String memo;
    @Column(name="passwd")
    private String passwd;
    @Column(name="port")
    private Integer port;
    @Column(name="psdeploycenterid")
    private String psdeploycenterid;
    @Column(name="psdeploycentername")
    private String psdeploycentername;
    @Column(name="psregistryrepoid")
    private String psregistryrepoid;
    @Column(name="psregistryreponame")
    private String psregistryreponame;
    @Column(name="pssvrdomainid")
    private String pssvrdomainid;
    @Column(name="pssvrdomainname")
    private String pssvrdomainname;
    @Column(name="resstate")
    private Integer resstate;
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
    private Integer objPSRegistryRepoLock = new Integer(1);
    private PSRegistryRepo psregistryrepo = null;
    private Integer objPSSvrDomainLock = new Integer(1);
    private PSSvrDomain pssvrdomain = null;

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

    public void setLocalRes(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLocalRes(n);
            return;
        }
        this.localres = n;
        this.localresDirtyFlag = true;
    }

    public Integer getLocalRes() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLocalRes();
        }
        return this.localres;
    }

    public boolean isLocalResDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLocalResDirty();
        }
        return this.localresDirtyFlag;
    }

    public void resetLocalRes() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLocalRes();
            return;
        }
        this.localresDirtyFlag = false;
        this.localres = null;
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

    public void setPSRegistryRepoId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSRegistryRepoId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psregistryrepoid = string;
        this.psregistryrepoidDirtyFlag = true;
    }

    public String getPSRegistryRepoId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSRegistryRepoId();
        }
        return this.psregistryrepoid;
    }

    public boolean isPSRegistryRepoIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSRegistryRepoIdDirty();
        }
        return this.psregistryrepoidDirtyFlag;
    }

    public void resetPSRegistryRepoId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSRegistryRepoId();
            return;
        }
        this.psregistryrepoidDirtyFlag = false;
        this.psregistryrepoid = null;
    }

    public void setPSRegistryRepoName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSRegistryRepoName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psregistryreponame = string;
        this.psregistryreponameDirtyFlag = true;
    }

    public String getPSRegistryRepoName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSRegistryRepoName();
        }
        return this.psregistryreponame;
    }

    public boolean isPSRegistryRepoNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSRegistryRepoNameDirty();
        }
        return this.psregistryreponameDirtyFlag;
    }

    public void resetPSRegistryRepoName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSRegistryRepoName();
            return;
        }
        this.psregistryreponameDirtyFlag = false;
        this.psregistryreponame = null;
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
        PSDeployCenterBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDeployCenterBase pSDeployCenterBase) {
        pSDeployCenterBase.resetAdminPasswd();
        pSDeployCenterBase.resetAdminUserName();
        pSDeployCenterBase.resetAPIToken();
        pSDeployCenterBase.resetAPIUrl();
        pSDeployCenterBase.resetCreateDate();
        pSDeployCenterBase.resetCreateMan();
        pSDeployCenterBase.resetDCType();
        pSDeployCenterBase.resetDCType2();
        pSDeployCenterBase.resetIpAddr();
        pSDeployCenterBase.resetIpAddr2();
        pSDeployCenterBase.resetLocalRes();
        pSDeployCenterBase.resetMemo();
        pSDeployCenterBase.resetPasswd();
        pSDeployCenterBase.resetPort();
        pSDeployCenterBase.resetPSDeployCenterId();
        pSDeployCenterBase.resetPSDeployCenterName();
        pSDeployCenterBase.resetPSRegistryRepoId();
        pSDeployCenterBase.resetPSRegistryRepoName();
        pSDeployCenterBase.resetPSSvrDomainId();
        pSDeployCenterBase.resetPSSvrDomainName();
        pSDeployCenterBase.resetResState();
        pSDeployCenterBase.resetSSHIPAddr();
        pSDeployCenterBase.resetSSHPort();
        pSDeployCenterBase.resetUpdateDate();
        pSDeployCenterBase.resetUpdateMan();
        pSDeployCenterBase.resetUploadFileMode();
        pSDeployCenterBase.resetUploadPath();
        pSDeployCenterBase.resetUserName();
        pSDeployCenterBase.resetValidFlag();
        pSDeployCenterBase.resetWebConsolePath();
        pSDeployCenterBase.resetWorkshopPath();
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
        if (!bl || this.isIpAddrDirty()) {
            hashMap.put(FIELD_IPADDR, this.getIpAddr());
        }
        if (!bl || this.isIpAddr2Dirty()) {
            hashMap.put(FIELD_IPADDR2, this.getIpAddr2());
        }
        if (!bl || this.isLocalResDirty()) {
            hashMap.put(FIELD_LOCALRES, this.getLocalRes());
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
        if (!bl || this.isPSDeployCenterIdDirty()) {
            hashMap.put(FIELD_PSDEPLOYCENTERID, this.getPSDeployCenterId());
        }
        if (!bl || this.isPSDeployCenterNameDirty()) {
            hashMap.put(FIELD_PSDEPLOYCENTERNAME, this.getPSDeployCenterName());
        }
        if (!bl || this.isPSRegistryRepoIdDirty()) {
            hashMap.put(FIELD_PSREGISTRYREPOID, this.getPSRegistryRepoId());
        }
        if (!bl || this.isPSRegistryRepoNameDirty()) {
            hashMap.put(FIELD_PSREGISTRYREPONAME, this.getPSRegistryRepoName());
        }
        if (!bl || this.isPSSvrDomainIdDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINID, this.getPSSvrDomainId());
        }
        if (!bl || this.isPSSvrDomainNameDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINNAME, this.getPSSvrDomainName());
        }
        if (!bl || this.isResStateDirty()) {
            hashMap.put(FIELD_RESSTATE, this.getResState());
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
        return PSDeployCenterBase.get(this, n);
    }

    private static Object get(PSDeployCenterBase pSDeployCenterBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDeployCenterBase.getAdminPasswd();
            }
            case 1: {
                return pSDeployCenterBase.getAdminUserName();
            }
            case 2: {
                return pSDeployCenterBase.getAPIToken();
            }
            case 3: {
                return pSDeployCenterBase.getAPIUrl();
            }
            case 4: {
                return pSDeployCenterBase.getCreateDate();
            }
            case 5: {
                return pSDeployCenterBase.getCreateMan();
            }
            case 6: {
                return pSDeployCenterBase.getDCType();
            }
            case 7: {
                return pSDeployCenterBase.getDCType2();
            }
            case 8: {
                return pSDeployCenterBase.getIpAddr();
            }
            case 9: {
                return pSDeployCenterBase.getIpAddr2();
            }
            case 10: {
                return pSDeployCenterBase.getLocalRes();
            }
            case 11: {
                return pSDeployCenterBase.getMemo();
            }
            case 12: {
                return pSDeployCenterBase.getPasswd();
            }
            case 13: {
                return pSDeployCenterBase.getPort();
            }
            case 14: {
                return pSDeployCenterBase.getPSDeployCenterId();
            }
            case 15: {
                return pSDeployCenterBase.getPSDeployCenterName();
            }
            case 16: {
                return pSDeployCenterBase.getPSRegistryRepoId();
            }
            case 17: {
                return pSDeployCenterBase.getPSRegistryRepoName();
            }
            case 18: {
                return pSDeployCenterBase.getPSSvrDomainId();
            }
            case 19: {
                return pSDeployCenterBase.getPSSvrDomainName();
            }
            case 20: {
                return pSDeployCenterBase.getResState();
            }
            case 21: {
                return pSDeployCenterBase.getSSHIPAddr();
            }
            case 22: {
                return pSDeployCenterBase.getSSHPort();
            }
            case 23: {
                return pSDeployCenterBase.getUpdateDate();
            }
            case 24: {
                return pSDeployCenterBase.getUpdateMan();
            }
            case 25: {
                return pSDeployCenterBase.getUploadFileMode();
            }
            case 26: {
                return pSDeployCenterBase.getUploadPath();
            }
            case 27: {
                return pSDeployCenterBase.getUserName();
            }
            case 28: {
                return pSDeployCenterBase.getValidFlag();
            }
            case 29: {
                return pSDeployCenterBase.getWebConsolePath();
            }
            case 30: {
                return pSDeployCenterBase.getWorkshopPath();
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
        PSDeployCenterBase.set(this, n, object);
    }

    private static void set(PSDeployCenterBase pSDeployCenterBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDeployCenterBase.setAdminPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDeployCenterBase.setAdminUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDeployCenterBase.setAPIToken(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDeployCenterBase.setAPIUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDeployCenterBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 5: {
                pSDeployCenterBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDeployCenterBase.setDCType(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDeployCenterBase.setDCType2(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDeployCenterBase.setIpAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDeployCenterBase.setIpAddr2(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDeployCenterBase.setLocalRes(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSDeployCenterBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDeployCenterBase.setPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDeployCenterBase.setPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSDeployCenterBase.setPSDeployCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDeployCenterBase.setPSDeployCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDeployCenterBase.setPSRegistryRepoId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDeployCenterBase.setPSRegistryRepoName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDeployCenterBase.setPSSvrDomainId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDeployCenterBase.setPSSvrDomainName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDeployCenterBase.setResState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 21: {
                pSDeployCenterBase.setSSHIPAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDeployCenterBase.setSSHPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 23: {
                pSDeployCenterBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 24: {
                pSDeployCenterBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDeployCenterBase.setUploadFileMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDeployCenterBase.setUploadPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDeployCenterBase.setUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDeployCenterBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 29: {
                pSDeployCenterBase.setWebConsolePath(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDeployCenterBase.setWorkshopPath(DataObject.getStringValue((Object)object));
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
        return PSDeployCenterBase.isNull(this, n);
    }

    private static boolean isNull(PSDeployCenterBase pSDeployCenterBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDeployCenterBase.getAdminPasswd() == null;
            }
            case 1: {
                return pSDeployCenterBase.getAdminUserName() == null;
            }
            case 2: {
                return pSDeployCenterBase.getAPIToken() == null;
            }
            case 3: {
                return pSDeployCenterBase.getAPIUrl() == null;
            }
            case 4: {
                return pSDeployCenterBase.getCreateDate() == null;
            }
            case 5: {
                return pSDeployCenterBase.getCreateMan() == null;
            }
            case 6: {
                return pSDeployCenterBase.getDCType() == null;
            }
            case 7: {
                return pSDeployCenterBase.getDCType2() == null;
            }
            case 8: {
                return pSDeployCenterBase.getIpAddr() == null;
            }
            case 9: {
                return pSDeployCenterBase.getIpAddr2() == null;
            }
            case 10: {
                return pSDeployCenterBase.getLocalRes() == null;
            }
            case 11: {
                return pSDeployCenterBase.getMemo() == null;
            }
            case 12: {
                return pSDeployCenterBase.getPasswd() == null;
            }
            case 13: {
                return pSDeployCenterBase.getPort() == null;
            }
            case 14: {
                return pSDeployCenterBase.getPSDeployCenterId() == null;
            }
            case 15: {
                return pSDeployCenterBase.getPSDeployCenterName() == null;
            }
            case 16: {
                return pSDeployCenterBase.getPSRegistryRepoId() == null;
            }
            case 17: {
                return pSDeployCenterBase.getPSRegistryRepoName() == null;
            }
            case 18: {
                return pSDeployCenterBase.getPSSvrDomainId() == null;
            }
            case 19: {
                return pSDeployCenterBase.getPSSvrDomainName() == null;
            }
            case 20: {
                return pSDeployCenterBase.getResState() == null;
            }
            case 21: {
                return pSDeployCenterBase.getSSHIPAddr() == null;
            }
            case 22: {
                return pSDeployCenterBase.getSSHPort() == null;
            }
            case 23: {
                return pSDeployCenterBase.getUpdateDate() == null;
            }
            case 24: {
                return pSDeployCenterBase.getUpdateMan() == null;
            }
            case 25: {
                return pSDeployCenterBase.getUploadFileMode() == null;
            }
            case 26: {
                return pSDeployCenterBase.getUploadPath() == null;
            }
            case 27: {
                return pSDeployCenterBase.getUserName() == null;
            }
            case 28: {
                return pSDeployCenterBase.getValidFlag() == null;
            }
            case 29: {
                return pSDeployCenterBase.getWebConsolePath() == null;
            }
            case 30: {
                return pSDeployCenterBase.getWorkshopPath() == null;
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
        return PSDeployCenterBase.contains(this, n);
    }

    private static boolean contains(PSDeployCenterBase pSDeployCenterBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDeployCenterBase.isAdminPasswdDirty();
            }
            case 1: {
                return pSDeployCenterBase.isAdminUserNameDirty();
            }
            case 2: {
                return pSDeployCenterBase.isAPITokenDirty();
            }
            case 3: {
                return pSDeployCenterBase.isAPIUrlDirty();
            }
            case 4: {
                return pSDeployCenterBase.isCreateDateDirty();
            }
            case 5: {
                return pSDeployCenterBase.isCreateManDirty();
            }
            case 6: {
                return pSDeployCenterBase.isDCTypeDirty();
            }
            case 7: {
                return pSDeployCenterBase.isDCType2Dirty();
            }
            case 8: {
                return pSDeployCenterBase.isIpAddrDirty();
            }
            case 9: {
                return pSDeployCenterBase.isIpAddr2Dirty();
            }
            case 10: {
                return pSDeployCenterBase.isLocalResDirty();
            }
            case 11: {
                return pSDeployCenterBase.isMemoDirty();
            }
            case 12: {
                return pSDeployCenterBase.isPasswdDirty();
            }
            case 13: {
                return pSDeployCenterBase.isPortDirty();
            }
            case 14: {
                return pSDeployCenterBase.isPSDeployCenterIdDirty();
            }
            case 15: {
                return pSDeployCenterBase.isPSDeployCenterNameDirty();
            }
            case 16: {
                return pSDeployCenterBase.isPSRegistryRepoIdDirty();
            }
            case 17: {
                return pSDeployCenterBase.isPSRegistryRepoNameDirty();
            }
            case 18: {
                return pSDeployCenterBase.isPSSvrDomainIdDirty();
            }
            case 19: {
                return pSDeployCenterBase.isPSSvrDomainNameDirty();
            }
            case 20: {
                return pSDeployCenterBase.isResStateDirty();
            }
            case 21: {
                return pSDeployCenterBase.isSSHIPAddrDirty();
            }
            case 22: {
                return pSDeployCenterBase.isSSHPortDirty();
            }
            case 23: {
                return pSDeployCenterBase.isUpdateDateDirty();
            }
            case 24: {
                return pSDeployCenterBase.isUpdateManDirty();
            }
            case 25: {
                return pSDeployCenterBase.isUploadFileModeDirty();
            }
            case 26: {
                return pSDeployCenterBase.isUploadPathDirty();
            }
            case 27: {
                return pSDeployCenterBase.isUserNameDirty();
            }
            case 28: {
                return pSDeployCenterBase.isValidFlagDirty();
            }
            case 29: {
                return pSDeployCenterBase.isWebConsolePathDirty();
            }
            case 30: {
                return pSDeployCenterBase.isWorkshopPathDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDeployCenterBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDeployCenterBase pSDeployCenterBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDeployCenterBase.getAdminPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"adminpasswd", (Object)PSDeployCenterBase.getJSONValue((Object)pSDeployCenterBase.getAdminPasswd()), (boolean)false);
        }
        if (bl || pSDeployCenterBase.getAdminUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"adminusername", (Object)PSDeployCenterBase.getJSONValue((Object)pSDeployCenterBase.getAdminUserName()), (boolean)false);
        }
        if (bl || pSDeployCenterBase.getAPIToken() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"apitoken", (Object)PSDeployCenterBase.getJSONValue((Object)pSDeployCenterBase.getAPIToken()), (boolean)false);
        }
        if (bl || pSDeployCenterBase.getAPIUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"apiurl", (Object)PSDeployCenterBase.getJSONValue((Object)pSDeployCenterBase.getAPIUrl()), (boolean)false);
        }
        if (bl || pSDeployCenterBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDeployCenterBase.getJSONValue((Object)pSDeployCenterBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDeployCenterBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDeployCenterBase.getJSONValue((Object)pSDeployCenterBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDeployCenterBase.getDCType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dctype", (Object)PSDeployCenterBase.getJSONValue((Object)pSDeployCenterBase.getDCType()), (boolean)false);
        }
        if (bl || pSDeployCenterBase.getDCType2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dctype2", (Object)PSDeployCenterBase.getJSONValue((Object)pSDeployCenterBase.getDCType2()), (boolean)false);
        }
        if (bl || pSDeployCenterBase.getIpAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr", (Object)PSDeployCenterBase.getJSONValue((Object)pSDeployCenterBase.getIpAddr()), (boolean)false);
        }
        if (bl || pSDeployCenterBase.getIpAddr2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr2", (Object)PSDeployCenterBase.getJSONValue((Object)pSDeployCenterBase.getIpAddr2()), (boolean)false);
        }
        if (bl || pSDeployCenterBase.getLocalRes() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"localres", (Object)PSDeployCenterBase.getJSONValue((Object)pSDeployCenterBase.getLocalRes()), (boolean)false);
        }
        if (bl || pSDeployCenterBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDeployCenterBase.getJSONValue((Object)pSDeployCenterBase.getMemo()), (boolean)false);
        }
        if (bl || pSDeployCenterBase.getPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"passwd", (Object)PSDeployCenterBase.getJSONValue((Object)pSDeployCenterBase.getPasswd()), (boolean)false);
        }
        if (bl || pSDeployCenterBase.getPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"port", (Object)PSDeployCenterBase.getJSONValue((Object)pSDeployCenterBase.getPort()), (boolean)false);
        }
        if (bl || pSDeployCenterBase.getPSDeployCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeploycenterid", (Object)PSDeployCenterBase.getJSONValue((Object)pSDeployCenterBase.getPSDeployCenterId()), (boolean)false);
        }
        if (bl || pSDeployCenterBase.getPSDeployCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeploycentername", (Object)PSDeployCenterBase.getJSONValue((Object)pSDeployCenterBase.getPSDeployCenterName()), (boolean)false);
        }
        if (bl || pSDeployCenterBase.getPSRegistryRepoId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psregistryrepoid", (Object)PSDeployCenterBase.getJSONValue((Object)pSDeployCenterBase.getPSRegistryRepoId()), (boolean)false);
        }
        if (bl || pSDeployCenterBase.getPSRegistryRepoName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psregistryreponame", (Object)PSDeployCenterBase.getJSONValue((Object)pSDeployCenterBase.getPSRegistryRepoName()), (boolean)false);
        }
        if (bl || pSDeployCenterBase.getPSSvrDomainId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainid", (Object)PSDeployCenterBase.getJSONValue((Object)pSDeployCenterBase.getPSSvrDomainId()), (boolean)false);
        }
        if (bl || pSDeployCenterBase.getPSSvrDomainName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainname", (Object)PSDeployCenterBase.getJSONValue((Object)pSDeployCenterBase.getPSSvrDomainName()), (boolean)false);
        }
        if (bl || pSDeployCenterBase.getResState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resstate", (Object)PSDeployCenterBase.getJSONValue((Object)pSDeployCenterBase.getResState()), (boolean)false);
        }
        if (bl || pSDeployCenterBase.getSSHIPAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sshipaddr", (Object)PSDeployCenterBase.getJSONValue((Object)pSDeployCenterBase.getSSHIPAddr()), (boolean)false);
        }
        if (bl || pSDeployCenterBase.getSSHPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sshport", (Object)PSDeployCenterBase.getJSONValue((Object)pSDeployCenterBase.getSSHPort()), (boolean)false);
        }
        if (bl || pSDeployCenterBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDeployCenterBase.getJSONValue((Object)pSDeployCenterBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDeployCenterBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDeployCenterBase.getJSONValue((Object)pSDeployCenterBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDeployCenterBase.getUploadFileMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uploadfilemode", (Object)PSDeployCenterBase.getJSONValue((Object)pSDeployCenterBase.getUploadFileMode()), (boolean)false);
        }
        if (bl || pSDeployCenterBase.getUploadPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uploadpath", (Object)PSDeployCenterBase.getJSONValue((Object)pSDeployCenterBase.getUploadPath()), (boolean)false);
        }
        if (bl || pSDeployCenterBase.getUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"username", (Object)PSDeployCenterBase.getJSONValue((Object)pSDeployCenterBase.getUserName()), (boolean)false);
        }
        if (bl || pSDeployCenterBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDeployCenterBase.getJSONValue((Object)pSDeployCenterBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSDeployCenterBase.getWebConsolePath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"webconsolepath", (Object)PSDeployCenterBase.getJSONValue((Object)pSDeployCenterBase.getWebConsolePath()), (boolean)false);
        }
        if (bl || pSDeployCenterBase.getWorkshopPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"workshoppath", (Object)PSDeployCenterBase.getJSONValue((Object)pSDeployCenterBase.getWorkshopPath()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDeployCenterBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDeployCenterBase pSDeployCenterBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDeployCenterBase.getAdminPasswd() != null) {
            object = pSDeployCenterBase.getAdminPasswd();
            xmlNode.setAttribute(FIELD_ADMINPASSWD, (String)(object == null ? "" : object));
        }
        if (bl || pSDeployCenterBase.getAdminUserName() != null) {
            object = pSDeployCenterBase.getAdminUserName();
            xmlNode.setAttribute(FIELD_ADMINUSERNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDeployCenterBase.getAPIToken() != null) {
            object = pSDeployCenterBase.getAPIToken();
            xmlNode.setAttribute(FIELD_APITOKEN, (String)(object == null ? "" : object));
        }
        if (bl || pSDeployCenterBase.getAPIUrl() != null) {
            object = pSDeployCenterBase.getAPIUrl();
            xmlNode.setAttribute(FIELD_APIURL, object == null ? "" : (String)object);
        }
        if (bl || pSDeployCenterBase.getCreateDate() != null) {
            object = pSDeployCenterBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDeployCenterBase.getCreateMan() != null) {
            object = pSDeployCenterBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDeployCenterBase.getDCType() != null) {
            object = pSDeployCenterBase.getDCType();
            xmlNode.setAttribute(FIELD_DCTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDeployCenterBase.getDCType2() != null) {
            object = pSDeployCenterBase.getDCType2();
            xmlNode.setAttribute(FIELD_DCTYPE2, object == null ? "" : (String)object);
        }
        if (bl || pSDeployCenterBase.getIpAddr() != null) {
            object = pSDeployCenterBase.getIpAddr();
            xmlNode.setAttribute(FIELD_IPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSDeployCenterBase.getIpAddr2() != null) {
            object = pSDeployCenterBase.getIpAddr2();
            xmlNode.setAttribute(FIELD_IPADDR2, object == null ? "" : (String)object);
        }
        if (bl || pSDeployCenterBase.getLocalRes() != null) {
            object = pSDeployCenterBase.getLocalRes();
            xmlNode.setAttribute(FIELD_LOCALRES, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDeployCenterBase.getMemo() != null) {
            object = pSDeployCenterBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDeployCenterBase.getPasswd() != null) {
            object = pSDeployCenterBase.getPasswd();
            xmlNode.setAttribute(FIELD_PASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSDeployCenterBase.getPort() != null) {
            object = pSDeployCenterBase.getPort();
            xmlNode.setAttribute(FIELD_PORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDeployCenterBase.getPSDeployCenterId() != null) {
            object = pSDeployCenterBase.getPSDeployCenterId();
            xmlNode.setAttribute(FIELD_PSDEPLOYCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDeployCenterBase.getPSDeployCenterName() != null) {
            object = pSDeployCenterBase.getPSDeployCenterName();
            xmlNode.setAttribute(FIELD_PSDEPLOYCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDeployCenterBase.getPSRegistryRepoId() != null) {
            object = pSDeployCenterBase.getPSRegistryRepoId();
            xmlNode.setAttribute(FIELD_PSREGISTRYREPOID, object == null ? "" : (String)object);
        }
        if (bl || pSDeployCenterBase.getPSRegistryRepoName() != null) {
            object = pSDeployCenterBase.getPSRegistryRepoName();
            xmlNode.setAttribute(FIELD_PSREGISTRYREPONAME, object == null ? "" : (String)object);
        }
        if (bl || pSDeployCenterBase.getPSSvrDomainId() != null) {
            object = pSDeployCenterBase.getPSSvrDomainId();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINID, object == null ? "" : (String)object);
        }
        if (bl || pSDeployCenterBase.getPSSvrDomainName() != null) {
            object = pSDeployCenterBase.getPSSvrDomainName();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDeployCenterBase.getResState() != null) {
            object = pSDeployCenterBase.getResState();
            xmlNode.setAttribute(FIELD_RESSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDeployCenterBase.getSSHIPAddr() != null) {
            object = pSDeployCenterBase.getSSHIPAddr();
            xmlNode.setAttribute(FIELD_SSHIPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSDeployCenterBase.getSSHPort() != null) {
            object = pSDeployCenterBase.getSSHPort();
            xmlNode.setAttribute(FIELD_SSHPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDeployCenterBase.getUpdateDate() != null) {
            object = pSDeployCenterBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDeployCenterBase.getUpdateMan() != null) {
            object = pSDeployCenterBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDeployCenterBase.getUploadFileMode() != null) {
            object = pSDeployCenterBase.getUploadFileMode();
            xmlNode.setAttribute(FIELD_UPLOADFILEMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDeployCenterBase.getUploadPath() != null) {
            object = pSDeployCenterBase.getUploadPath();
            xmlNode.setAttribute(FIELD_UPLOADPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDeployCenterBase.getUserName() != null) {
            object = pSDeployCenterBase.getUserName();
            xmlNode.setAttribute(FIELD_USERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDeployCenterBase.getValidFlag() != null) {
            object = pSDeployCenterBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDeployCenterBase.getWebConsolePath() != null) {
            object = pSDeployCenterBase.getWebConsolePath();
            xmlNode.setAttribute(FIELD_WEBCONSOLEPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDeployCenterBase.getWorkshopPath() != null) {
            object = pSDeployCenterBase.getWorkshopPath();
            xmlNode.setAttribute(FIELD_WORKSHOPPATH, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDeployCenterBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDeployCenterBase pSDeployCenterBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDeployCenterBase.isAdminPasswdDirty() && (bl || pSDeployCenterBase.getAdminPasswd() != null)) {
            iDataObject.set(FIELD_ADMINPASSWD, (Object)pSDeployCenterBase.getAdminPasswd());
        }
        if (pSDeployCenterBase.isAdminUserNameDirty() && (bl || pSDeployCenterBase.getAdminUserName() != null)) {
            iDataObject.set(FIELD_ADMINUSERNAME, (Object)pSDeployCenterBase.getAdminUserName());
        }
        if (pSDeployCenterBase.isAPITokenDirty() && (bl || pSDeployCenterBase.getAPIToken() != null)) {
            iDataObject.set(FIELD_APITOKEN, (Object)pSDeployCenterBase.getAPIToken());
        }
        if (pSDeployCenterBase.isAPIUrlDirty() && (bl || pSDeployCenterBase.getAPIUrl() != null)) {
            iDataObject.set(FIELD_APIURL, (Object)pSDeployCenterBase.getAPIUrl());
        }
        if (pSDeployCenterBase.isCreateDateDirty() && (bl || pSDeployCenterBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDeployCenterBase.getCreateDate());
        }
        if (pSDeployCenterBase.isCreateManDirty() && (bl || pSDeployCenterBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDeployCenterBase.getCreateMan());
        }
        if (pSDeployCenterBase.isDCTypeDirty() && (bl || pSDeployCenterBase.getDCType() != null)) {
            iDataObject.set(FIELD_DCTYPE, (Object)pSDeployCenterBase.getDCType());
        }
        if (pSDeployCenterBase.isDCType2Dirty() && (bl || pSDeployCenterBase.getDCType2() != null)) {
            iDataObject.set(FIELD_DCTYPE2, (Object)pSDeployCenterBase.getDCType2());
        }
        if (pSDeployCenterBase.isIpAddrDirty() && (bl || pSDeployCenterBase.getIpAddr() != null)) {
            iDataObject.set(FIELD_IPADDR, (Object)pSDeployCenterBase.getIpAddr());
        }
        if (pSDeployCenterBase.isIpAddr2Dirty() && (bl || pSDeployCenterBase.getIpAddr2() != null)) {
            iDataObject.set(FIELD_IPADDR2, (Object)pSDeployCenterBase.getIpAddr2());
        }
        if (pSDeployCenterBase.isLocalResDirty() && (bl || pSDeployCenterBase.getLocalRes() != null)) {
            iDataObject.set(FIELD_LOCALRES, (Object)pSDeployCenterBase.getLocalRes());
        }
        if (pSDeployCenterBase.isMemoDirty() && (bl || pSDeployCenterBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDeployCenterBase.getMemo());
        }
        if (pSDeployCenterBase.isPasswdDirty() && (bl || pSDeployCenterBase.getPasswd() != null)) {
            iDataObject.set(FIELD_PASSWD, (Object)pSDeployCenterBase.getPasswd());
        }
        if (pSDeployCenterBase.isPortDirty() && (bl || pSDeployCenterBase.getPort() != null)) {
            iDataObject.set(FIELD_PORT, (Object)pSDeployCenterBase.getPort());
        }
        if (pSDeployCenterBase.isPSDeployCenterIdDirty() && (bl || pSDeployCenterBase.getPSDeployCenterId() != null)) {
            iDataObject.set(FIELD_PSDEPLOYCENTERID, (Object)pSDeployCenterBase.getPSDeployCenterId());
        }
        if (pSDeployCenterBase.isPSDeployCenterNameDirty() && (bl || pSDeployCenterBase.getPSDeployCenterName() != null)) {
            iDataObject.set(FIELD_PSDEPLOYCENTERNAME, (Object)pSDeployCenterBase.getPSDeployCenterName());
        }
        if (pSDeployCenterBase.isPSRegistryRepoIdDirty() && (bl || pSDeployCenterBase.getPSRegistryRepoId() != null)) {
            iDataObject.set(FIELD_PSREGISTRYREPOID, (Object)pSDeployCenterBase.getPSRegistryRepoId());
        }
        if (pSDeployCenterBase.isPSRegistryRepoNameDirty() && (bl || pSDeployCenterBase.getPSRegistryRepoName() != null)) {
            iDataObject.set(FIELD_PSREGISTRYREPONAME, (Object)pSDeployCenterBase.getPSRegistryRepoName());
        }
        if (pSDeployCenterBase.isPSSvrDomainIdDirty() && (bl || pSDeployCenterBase.getPSSvrDomainId() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINID, (Object)pSDeployCenterBase.getPSSvrDomainId());
        }
        if (pSDeployCenterBase.isPSSvrDomainNameDirty() && (bl || pSDeployCenterBase.getPSSvrDomainName() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINNAME, (Object)pSDeployCenterBase.getPSSvrDomainName());
        }
        if (pSDeployCenterBase.isResStateDirty() && (bl || pSDeployCenterBase.getResState() != null)) {
            iDataObject.set(FIELD_RESSTATE, (Object)pSDeployCenterBase.getResState());
        }
        if (pSDeployCenterBase.isSSHIPAddrDirty() && (bl || pSDeployCenterBase.getSSHIPAddr() != null)) {
            iDataObject.set(FIELD_SSHIPADDR, (Object)pSDeployCenterBase.getSSHIPAddr());
        }
        if (pSDeployCenterBase.isSSHPortDirty() && (bl || pSDeployCenterBase.getSSHPort() != null)) {
            iDataObject.set(FIELD_SSHPORT, (Object)pSDeployCenterBase.getSSHPort());
        }
        if (pSDeployCenterBase.isUpdateDateDirty() && (bl || pSDeployCenterBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDeployCenterBase.getUpdateDate());
        }
        if (pSDeployCenterBase.isUpdateManDirty() && (bl || pSDeployCenterBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDeployCenterBase.getUpdateMan());
        }
        if (pSDeployCenterBase.isUploadFileModeDirty() && (bl || pSDeployCenterBase.getUploadFileMode() != null)) {
            iDataObject.set(FIELD_UPLOADFILEMODE, (Object)pSDeployCenterBase.getUploadFileMode());
        }
        if (pSDeployCenterBase.isUploadPathDirty() && (bl || pSDeployCenterBase.getUploadPath() != null)) {
            iDataObject.set(FIELD_UPLOADPATH, (Object)pSDeployCenterBase.getUploadPath());
        }
        if (pSDeployCenterBase.isUserNameDirty() && (bl || pSDeployCenterBase.getUserName() != null)) {
            iDataObject.set(FIELD_USERNAME, (Object)pSDeployCenterBase.getUserName());
        }
        if (pSDeployCenterBase.isValidFlagDirty() && (bl || pSDeployCenterBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDeployCenterBase.getValidFlag());
        }
        if (pSDeployCenterBase.isWebConsolePathDirty() && (bl || pSDeployCenterBase.getWebConsolePath() != null)) {
            iDataObject.set(FIELD_WEBCONSOLEPATH, (Object)pSDeployCenterBase.getWebConsolePath());
        }
        if (pSDeployCenterBase.isWorkshopPathDirty() && (bl || pSDeployCenterBase.getWorkshopPath() != null)) {
            iDataObject.set(FIELD_WORKSHOPPATH, (Object)pSDeployCenterBase.getWorkshopPath());
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
        return PSDeployCenterBase.remove(this, n);
    }

    private static boolean remove(PSDeployCenterBase pSDeployCenterBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDeployCenterBase.resetAdminPasswd();
                return true;
            }
            case 1: {
                pSDeployCenterBase.resetAdminUserName();
                return true;
            }
            case 2: {
                pSDeployCenterBase.resetAPIToken();
                return true;
            }
            case 3: {
                pSDeployCenterBase.resetAPIUrl();
                return true;
            }
            case 4: {
                pSDeployCenterBase.resetCreateDate();
                return true;
            }
            case 5: {
                pSDeployCenterBase.resetCreateMan();
                return true;
            }
            case 6: {
                pSDeployCenterBase.resetDCType();
                return true;
            }
            case 7: {
                pSDeployCenterBase.resetDCType2();
                return true;
            }
            case 8: {
                pSDeployCenterBase.resetIpAddr();
                return true;
            }
            case 9: {
                pSDeployCenterBase.resetIpAddr2();
                return true;
            }
            case 10: {
                pSDeployCenterBase.resetLocalRes();
                return true;
            }
            case 11: {
                pSDeployCenterBase.resetMemo();
                return true;
            }
            case 12: {
                pSDeployCenterBase.resetPasswd();
                return true;
            }
            case 13: {
                pSDeployCenterBase.resetPort();
                return true;
            }
            case 14: {
                pSDeployCenterBase.resetPSDeployCenterId();
                return true;
            }
            case 15: {
                pSDeployCenterBase.resetPSDeployCenterName();
                return true;
            }
            case 16: {
                pSDeployCenterBase.resetPSRegistryRepoId();
                return true;
            }
            case 17: {
                pSDeployCenterBase.resetPSRegistryRepoName();
                return true;
            }
            case 18: {
                pSDeployCenterBase.resetPSSvrDomainId();
                return true;
            }
            case 19: {
                pSDeployCenterBase.resetPSSvrDomainName();
                return true;
            }
            case 20: {
                pSDeployCenterBase.resetResState();
                return true;
            }
            case 21: {
                pSDeployCenterBase.resetSSHIPAddr();
                return true;
            }
            case 22: {
                pSDeployCenterBase.resetSSHPort();
                return true;
            }
            case 23: {
                pSDeployCenterBase.resetUpdateDate();
                return true;
            }
            case 24: {
                pSDeployCenterBase.resetUpdateMan();
                return true;
            }
            case 25: {
                pSDeployCenterBase.resetUploadFileMode();
                return true;
            }
            case 26: {
                pSDeployCenterBase.resetUploadPath();
                return true;
            }
            case 27: {
                pSDeployCenterBase.resetUserName();
                return true;
            }
            case 28: {
                pSDeployCenterBase.resetValidFlag();
                return true;
            }
            case 29: {
                pSDeployCenterBase.resetWebConsolePath();
                return true;
            }
            case 30: {
                pSDeployCenterBase.resetWorkshopPath();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSRegistryRepo getPSRegistryRepo() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSRegistryRepo();
        }
        if (this.getPSRegistryRepoId() == null) {
            return null;
        }
        Integer n = this.objPSRegistryRepoLock;
        synchronized (n) {
            if (this.psregistryrepo != null && DataTypeHelper.compare((int)25, (Object)this.getPSRegistryRepoId(), (Object)this.psregistryrepo.getPSRegistryRepoId()) != 0L) {
                this.psregistryrepo = null;
            }
            if (this.psregistryrepo == null) {
                PSRegistryRepo pSRegistryRepo = new PSRegistryRepo();
                pSRegistryRepo.setPSRegistryRepoId(this.getPSRegistryRepoId());
                PSRegistryRepoService pSRegistryRepoService = (PSRegistryRepoService)ServiceGlobal.getService(PSRegistryRepoService.class, (SessionFactory)this.getSessionFactory());
                pSRegistryRepoService.autoGet(pSRegistryRepo);
                this.psregistryrepo = pSRegistryRepo;
            }
            return this.psregistryrepo;
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
                pSSvrDomainService.autoGet(pSSvrDomain);
                this.pssvrdomain = pSSvrDomain;
            }
            return this.pssvrdomain;
        }
    }

    private PSDeployCenterBase getProxyEntity() {
        return this.proxyPSDeployCenterBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDeployCenterBase = null;
        if (iDataObject != null && iDataObject instanceof PSDeployCenterBase) {
            this.proxyPSDeployCenterBase = (PSDeployCenterBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSDeployCenterService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ADMINPASSWD, 0);
        fieldIndexMap.put(FIELD_ADMINUSERNAME, 1);
        fieldIndexMap.put(FIELD_APITOKEN, 2);
        fieldIndexMap.put(FIELD_APIURL, 3);
        fieldIndexMap.put(FIELD_CREATEDATE, 4);
        fieldIndexMap.put(FIELD_CREATEMAN, 5);
        fieldIndexMap.put(FIELD_DCTYPE, 6);
        fieldIndexMap.put(FIELD_DCTYPE2, 7);
        fieldIndexMap.put(FIELD_IPADDR, 8);
        fieldIndexMap.put(FIELD_IPADDR2, 9);
        fieldIndexMap.put(FIELD_LOCALRES, 10);
        fieldIndexMap.put(FIELD_MEMO, 11);
        fieldIndexMap.put(FIELD_PASSWD, 12);
        fieldIndexMap.put(FIELD_PORT, 13);
        fieldIndexMap.put(FIELD_PSDEPLOYCENTERID, 14);
        fieldIndexMap.put(FIELD_PSDEPLOYCENTERNAME, 15);
        fieldIndexMap.put(FIELD_PSREGISTRYREPOID, 16);
        fieldIndexMap.put(FIELD_PSREGISTRYREPONAME, 17);
        fieldIndexMap.put(FIELD_PSSVRDOMAINID, 18);
        fieldIndexMap.put(FIELD_PSSVRDOMAINNAME, 19);
        fieldIndexMap.put(FIELD_RESSTATE, 20);
        fieldIndexMap.put(FIELD_SSHIPADDR, 21);
        fieldIndexMap.put(FIELD_SSHPORT, 22);
        fieldIndexMap.put(FIELD_UPDATEDATE, 23);
        fieldIndexMap.put(FIELD_UPDATEMAN, 24);
        fieldIndexMap.put(FIELD_UPLOADFILEMODE, 25);
        fieldIndexMap.put(FIELD_UPLOADPATH, 26);
        fieldIndexMap.put(FIELD_USERNAME, 27);
        fieldIndexMap.put(FIELD_VALIDFLAG, 28);
        fieldIndexMap.put(FIELD_WEBCONSOLEPATH, 29);
        fieldIndexMap.put(FIELD_WORKSHOPPATH, 30);
    }
}

