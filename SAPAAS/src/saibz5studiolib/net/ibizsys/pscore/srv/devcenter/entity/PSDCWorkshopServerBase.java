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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSWorkshopServer;
import net.ibizsys.pscore.srv.paasmgr.service.PSWorkshopServerService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCWorkshopServerBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCWorkshopServerBase.class);
    public static final String FIELD_ADMINPASSWD = "ADMINPASSWD";
    public static final String FIELD_ADMINUSERNAME = "ADMINUSERNAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String FIELD_EXPRIEDTIME = "EXPRIEDTIME";
    public static final String FIELD_GITPASSWORD = "GITPASSWORD";
    public static final String FIELD_GITPATH = "GITPATH";
    public static final String FIELD_GITUSERNAME = "GITUSERNAME";
    public static final String FIELD_IPADDR = "IPADDR";
    public static final String FIELD_IPADDR2 = "IPADDR2";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PASSWD = "PASSWD";
    public static final String FIELD_PORT = "PORT";
    public static final String FIELD_PSDCWORKSHOPSERVERID = "PSDCWORKSHOPSERVERID";
    public static final String FIELD_PSDCWORKSHOPSERVERNAME = "PSDCWORKSHOPSERVERNAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSWORKSHOPSERVERID = "PSWORKSHOPSERVERID";
    public static final String FIELD_PSWORKSHOPSERVERNAME = "PSWORKSHOPSERVERNAME";
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
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_DEFAULTFLAG = 4;
    private static final int INDEX_EXPRIEDTIME = 5;
    private static final int INDEX_GITPASSWORD = 6;
    private static final int INDEX_GITPATH = 7;
    private static final int INDEX_GITUSERNAME = 8;
    private static final int INDEX_IPADDR = 9;
    private static final int INDEX_IPADDR2 = 10;
    private static final int INDEX_MEMO = 11;
    private static final int INDEX_PASSWD = 12;
    private static final int INDEX_PORT = 13;
    private static final int INDEX_PSDCWORKSHOPSERVERID = 14;
    private static final int INDEX_PSDCWORKSHOPSERVERNAME = 15;
    private static final int INDEX_PSDEVCENTERID = 16;
    private static final int INDEX_PSDEVCENTERNAME = 17;
    private static final int INDEX_PSWORKSHOPSERVERID = 18;
    private static final int INDEX_PSWORKSHOPSERVERNAME = 19;
    private static final int INDEX_REFCOUNT = 20;
    private static final int INDEX_RESPOS = 21;
    private static final int INDEX_RESREADYTIME = 22;
    private static final int INDEX_RESSTATE = 23;
    private static final int INDEX_RESVER = 24;
    private static final int INDEX_SSHIPADDR = 25;
    private static final int INDEX_SSHPORT = 26;
    private static final int INDEX_UPDATEDATE = 27;
    private static final int INDEX_UPDATEMAN = 28;
    private static final int INDEX_UPLOADFILEMODE = 29;
    private static final int INDEX_UPLOADPATH = 30;
    private static final int INDEX_USERNAME = 31;
    private static final int INDEX_VALIDFLAG = 32;
    private static final int INDEX_WEBCONSOLEPATH = 33;
    private static final int INDEX_WORKSHOPPATH = 34;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCWorkshopServerBase proxyPSDCWorkshopServerBase = null;
    private boolean adminpasswdDirtyFlag = false;
    private boolean adminusernameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defaultflagDirtyFlag = false;
    private boolean expriedtimeDirtyFlag = false;
    private boolean gitpasswordDirtyFlag = false;
    private boolean gitpathDirtyFlag = false;
    private boolean gitusernameDirtyFlag = false;
    private boolean ipaddrDirtyFlag = false;
    private boolean ipaddr2DirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean passwdDirtyFlag = false;
    private boolean portDirtyFlag = false;
    private boolean psdcworkshopserveridDirtyFlag = false;
    private boolean psdcworkshopservernameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psworkshopserveridDirtyFlag = false;
    private boolean psworkshopservernameDirtyFlag = false;
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
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="defaultflag")
    private Integer defaultflag;
    @Column(name="expriedtime")
    private Timestamp expriedtime;
    @Column(name="gitpassword")
    private String gitpassword;
    @Column(name="gitpath")
    private String gitpath;
    @Column(name="gitusername")
    private String gitusername;
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
    @Column(name="psdcworkshopserverid")
    private String psdcworkshopserverid;
    @Column(name="psdcworkshopservername")
    private String psdcworkshopservername;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psworkshopserverid")
    private String psworkshopserverid;
    @Column(name="psworkshopservername")
    private String psworkshopservername;
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
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSWorkshopServerLock = new Integer(1);
    private PSWorkshopServer psworkshopserver = null;

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

    public void setGITPassword(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGITPassword(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.gitpassword = string;
        this.gitpasswordDirtyFlag = true;
    }

    public String getGITPassword() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGITPassword();
        }
        return this.gitpassword;
    }

    public boolean isGITPasswordDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGITPasswordDirty();
        }
        return this.gitpasswordDirtyFlag;
    }

    public void resetGITPassword() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGITPassword();
            return;
        }
        this.gitpasswordDirtyFlag = false;
        this.gitpassword = null;
    }

    public void setGitPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGitPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.gitpath = string;
        this.gitpathDirtyFlag = true;
    }

    public String getGitPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGitPath();
        }
        return this.gitpath;
    }

    public boolean isGitPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGitPathDirty();
        }
        return this.gitpathDirtyFlag;
    }

    public void resetGitPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGitPath();
            return;
        }
        this.gitpathDirtyFlag = false;
        this.gitpath = null;
    }

    public void setGITUserName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGITUserName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.gitusername = string;
        this.gitusernameDirtyFlag = true;
    }

    public String getGITUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGITUserName();
        }
        return this.gitusername;
    }

    public boolean isGITUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGITUserNameDirty();
        }
        return this.gitusernameDirtyFlag;
    }

    public void resetGITUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGITUserName();
            return;
        }
        this.gitusernameDirtyFlag = false;
        this.gitusername = null;
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

    public void setPSDCWorkshopServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCWorkshopServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcworkshopserverid = string;
        this.psdcworkshopserveridDirtyFlag = true;
    }

    public String getPSDCWorkshopServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCWorkshopServerId();
        }
        return this.psdcworkshopserverid;
    }

    public boolean isPSDCWorkshopServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCWorkshopServerIdDirty();
        }
        return this.psdcworkshopserveridDirtyFlag;
    }

    public void resetPSDCWorkshopServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCWorkshopServerId();
            return;
        }
        this.psdcworkshopserveridDirtyFlag = false;
        this.psdcworkshopserverid = null;
    }

    public void setPSDCWorkshopServerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCWorkshopServerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcworkshopservername = string;
        this.psdcworkshopservernameDirtyFlag = true;
    }

    public String getPSDCWorkshopServerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCWorkshopServerName();
        }
        return this.psdcworkshopservername;
    }

    public boolean isPSDCWorkshopServerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCWorkshopServerNameDirty();
        }
        return this.psdcworkshopservernameDirtyFlag;
    }

    public void resetPSDCWorkshopServerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCWorkshopServerName();
            return;
        }
        this.psdcworkshopservernameDirtyFlag = false;
        this.psdcworkshopservername = null;
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

    public void setPSWorkshopServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWorkshopServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psworkshopserverid = string;
        this.psworkshopserveridDirtyFlag = true;
    }

    public String getPSWorkshopServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWorkshopServerId();
        }
        return this.psworkshopserverid;
    }

    public boolean isPSWorkshopServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWorkshopServerIdDirty();
        }
        return this.psworkshopserveridDirtyFlag;
    }

    public void resetPSWorkshopServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWorkshopServerId();
            return;
        }
        this.psworkshopserveridDirtyFlag = false;
        this.psworkshopserverid = null;
    }

    public void setPSWorkshopServerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWorkshopServerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psworkshopservername = string;
        this.psworkshopservernameDirtyFlag = true;
    }

    public String getPSWorkshopServerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWorkshopServerName();
        }
        return this.psworkshopservername;
    }

    public boolean isPSWorkshopServerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWorkshopServerNameDirty();
        }
        return this.psworkshopservernameDirtyFlag;
    }

    public void resetPSWorkshopServerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWorkshopServerName();
            return;
        }
        this.psworkshopservernameDirtyFlag = false;
        this.psworkshopservername = null;
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
        PSDCWorkshopServerBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCWorkshopServerBase pSDCWorkshopServerBase) {
        pSDCWorkshopServerBase.resetAdminPasswd();
        pSDCWorkshopServerBase.resetAdminUserName();
        pSDCWorkshopServerBase.resetCreateDate();
        pSDCWorkshopServerBase.resetCreateMan();
        pSDCWorkshopServerBase.resetDefaultFlag();
        pSDCWorkshopServerBase.resetExpriedTime();
        pSDCWorkshopServerBase.resetGITPassword();
        pSDCWorkshopServerBase.resetGitPath();
        pSDCWorkshopServerBase.resetGITUserName();
        pSDCWorkshopServerBase.resetIpAddr();
        pSDCWorkshopServerBase.resetIpAddr2();
        pSDCWorkshopServerBase.resetMemo();
        pSDCWorkshopServerBase.resetPasswd();
        pSDCWorkshopServerBase.resetPort();
        pSDCWorkshopServerBase.resetPSDCWorkshopServerId();
        pSDCWorkshopServerBase.resetPSDCWorkshopServerName();
        pSDCWorkshopServerBase.resetPSDevCenterId();
        pSDCWorkshopServerBase.resetPSDevCenterName();
        pSDCWorkshopServerBase.resetPSWorkshopServerId();
        pSDCWorkshopServerBase.resetPSWorkshopServerName();
        pSDCWorkshopServerBase.resetRefCount();
        pSDCWorkshopServerBase.resetResPos();
        pSDCWorkshopServerBase.resetResReadyTime();
        pSDCWorkshopServerBase.resetResState();
        pSDCWorkshopServerBase.resetResVer();
        pSDCWorkshopServerBase.resetSSHIPAddr();
        pSDCWorkshopServerBase.resetSSHPort();
        pSDCWorkshopServerBase.resetUpdateDate();
        pSDCWorkshopServerBase.resetUpdateMan();
        pSDCWorkshopServerBase.resetUploadFileMode();
        pSDCWorkshopServerBase.resetUploadPath();
        pSDCWorkshopServerBase.resetUserName();
        pSDCWorkshopServerBase.resetValidFlag();
        pSDCWorkshopServerBase.resetWebConsolePath();
        pSDCWorkshopServerBase.resetWorkshopPath();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAdminPasswdDirty()) {
            hashMap.put(FIELD_ADMINPASSWD, this.getAdminPasswd());
        }
        if (!bl || this.isAdminUserNameDirty()) {
            hashMap.put(FIELD_ADMINUSERNAME, this.getAdminUserName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDefaultFlagDirty()) {
            hashMap.put(FIELD_DEFAULTFLAG, this.getDefaultFlag());
        }
        if (!bl || this.isExpriedTimeDirty()) {
            hashMap.put(FIELD_EXPRIEDTIME, this.getExpriedTime());
        }
        if (!bl || this.isGITPasswordDirty()) {
            hashMap.put(FIELD_GITPASSWORD, this.getGITPassword());
        }
        if (!bl || this.isGitPathDirty()) {
            hashMap.put(FIELD_GITPATH, this.getGitPath());
        }
        if (!bl || this.isGITUserNameDirty()) {
            hashMap.put(FIELD_GITUSERNAME, this.getGITUserName());
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
        if (!bl || this.isPSDCWorkshopServerIdDirty()) {
            hashMap.put(FIELD_PSDCWORKSHOPSERVERID, this.getPSDCWorkshopServerId());
        }
        if (!bl || this.isPSDCWorkshopServerNameDirty()) {
            hashMap.put(FIELD_PSDCWORKSHOPSERVERNAME, this.getPSDCWorkshopServerName());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSWorkshopServerIdDirty()) {
            hashMap.put(FIELD_PSWORKSHOPSERVERID, this.getPSWorkshopServerId());
        }
        if (!bl || this.isPSWorkshopServerNameDirty()) {
            hashMap.put(FIELD_PSWORKSHOPSERVERNAME, this.getPSWorkshopServerName());
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
        return PSDCWorkshopServerBase.get(this, n);
    }

    private static Object get(PSDCWorkshopServerBase pSDCWorkshopServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCWorkshopServerBase.getAdminPasswd();
            }
            case 1: {
                return pSDCWorkshopServerBase.getAdminUserName();
            }
            case 2: {
                return pSDCWorkshopServerBase.getCreateDate();
            }
            case 3: {
                return pSDCWorkshopServerBase.getCreateMan();
            }
            case 4: {
                return pSDCWorkshopServerBase.getDefaultFlag();
            }
            case 5: {
                return pSDCWorkshopServerBase.getExpriedTime();
            }
            case 6: {
                return pSDCWorkshopServerBase.getGITPassword();
            }
            case 7: {
                return pSDCWorkshopServerBase.getGitPath();
            }
            case 8: {
                return pSDCWorkshopServerBase.getGITUserName();
            }
            case 9: {
                return pSDCWorkshopServerBase.getIpAddr();
            }
            case 10: {
                return pSDCWorkshopServerBase.getIpAddr2();
            }
            case 11: {
                return pSDCWorkshopServerBase.getMemo();
            }
            case 12: {
                return pSDCWorkshopServerBase.getPasswd();
            }
            case 13: {
                return pSDCWorkshopServerBase.getPort();
            }
            case 14: {
                return pSDCWorkshopServerBase.getPSDCWorkshopServerId();
            }
            case 15: {
                return pSDCWorkshopServerBase.getPSDCWorkshopServerName();
            }
            case 16: {
                return pSDCWorkshopServerBase.getPSDevCenterId();
            }
            case 17: {
                return pSDCWorkshopServerBase.getPSDevCenterName();
            }
            case 18: {
                return pSDCWorkshopServerBase.getPSWorkshopServerId();
            }
            case 19: {
                return pSDCWorkshopServerBase.getPSWorkshopServerName();
            }
            case 20: {
                return pSDCWorkshopServerBase.getRefCount();
            }
            case 21: {
                return pSDCWorkshopServerBase.getResPos();
            }
            case 22: {
                return pSDCWorkshopServerBase.getResReadyTime();
            }
            case 23: {
                return pSDCWorkshopServerBase.getResState();
            }
            case 24: {
                return pSDCWorkshopServerBase.getResVer();
            }
            case 25: {
                return pSDCWorkshopServerBase.getSSHIPAddr();
            }
            case 26: {
                return pSDCWorkshopServerBase.getSSHPort();
            }
            case 27: {
                return pSDCWorkshopServerBase.getUpdateDate();
            }
            case 28: {
                return pSDCWorkshopServerBase.getUpdateMan();
            }
            case 29: {
                return pSDCWorkshopServerBase.getUploadFileMode();
            }
            case 30: {
                return pSDCWorkshopServerBase.getUploadPath();
            }
            case 31: {
                return pSDCWorkshopServerBase.getUserName();
            }
            case 32: {
                return pSDCWorkshopServerBase.getValidFlag();
            }
            case 33: {
                return pSDCWorkshopServerBase.getWebConsolePath();
            }
            case 34: {
                return pSDCWorkshopServerBase.getWorkshopPath();
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
        PSDCWorkshopServerBase.set(this, n, object);
    }

    private static void set(PSDCWorkshopServerBase pSDCWorkshopServerBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCWorkshopServerBase.setAdminPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDCWorkshopServerBase.setAdminUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDCWorkshopServerBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSDCWorkshopServerBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDCWorkshopServerBase.setDefaultFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDCWorkshopServerBase.setExpriedTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSDCWorkshopServerBase.setGITPassword(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCWorkshopServerBase.setGitPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCWorkshopServerBase.setGITUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDCWorkshopServerBase.setIpAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDCWorkshopServerBase.setIpAddr2(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDCWorkshopServerBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDCWorkshopServerBase.setPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDCWorkshopServerBase.setPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSDCWorkshopServerBase.setPSDCWorkshopServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDCWorkshopServerBase.setPSDCWorkshopServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDCWorkshopServerBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDCWorkshopServerBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDCWorkshopServerBase.setPSWorkshopServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDCWorkshopServerBase.setPSWorkshopServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDCWorkshopServerBase.setRefCount(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 21: {
                pSDCWorkshopServerBase.setResPos(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 22: {
                pSDCWorkshopServerBase.setResReadyTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 23: {
                pSDCWorkshopServerBase.setResState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 24: {
                pSDCWorkshopServerBase.setResVer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 25: {
                pSDCWorkshopServerBase.setSSHIPAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDCWorkshopServerBase.setSSHPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 27: {
                pSDCWorkshopServerBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 28: {
                pSDCWorkshopServerBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDCWorkshopServerBase.setUploadFileMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDCWorkshopServerBase.setUploadPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDCWorkshopServerBase.setUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDCWorkshopServerBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 33: {
                pSDCWorkshopServerBase.setWebConsolePath(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDCWorkshopServerBase.setWorkshopPath(DataObject.getStringValue((Object)object));
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
        return PSDCWorkshopServerBase.isNull(this, n);
    }

    private static boolean isNull(PSDCWorkshopServerBase pSDCWorkshopServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCWorkshopServerBase.getAdminPasswd() == null;
            }
            case 1: {
                return pSDCWorkshopServerBase.getAdminUserName() == null;
            }
            case 2: {
                return pSDCWorkshopServerBase.getCreateDate() == null;
            }
            case 3: {
                return pSDCWorkshopServerBase.getCreateMan() == null;
            }
            case 4: {
                return pSDCWorkshopServerBase.getDefaultFlag() == null;
            }
            case 5: {
                return pSDCWorkshopServerBase.getExpriedTime() == null;
            }
            case 6: {
                return pSDCWorkshopServerBase.getGITPassword() == null;
            }
            case 7: {
                return pSDCWorkshopServerBase.getGitPath() == null;
            }
            case 8: {
                return pSDCWorkshopServerBase.getGITUserName() == null;
            }
            case 9: {
                return pSDCWorkshopServerBase.getIpAddr() == null;
            }
            case 10: {
                return pSDCWorkshopServerBase.getIpAddr2() == null;
            }
            case 11: {
                return pSDCWorkshopServerBase.getMemo() == null;
            }
            case 12: {
                return pSDCWorkshopServerBase.getPasswd() == null;
            }
            case 13: {
                return pSDCWorkshopServerBase.getPort() == null;
            }
            case 14: {
                return pSDCWorkshopServerBase.getPSDCWorkshopServerId() == null;
            }
            case 15: {
                return pSDCWorkshopServerBase.getPSDCWorkshopServerName() == null;
            }
            case 16: {
                return pSDCWorkshopServerBase.getPSDevCenterId() == null;
            }
            case 17: {
                return pSDCWorkshopServerBase.getPSDevCenterName() == null;
            }
            case 18: {
                return pSDCWorkshopServerBase.getPSWorkshopServerId() == null;
            }
            case 19: {
                return pSDCWorkshopServerBase.getPSWorkshopServerName() == null;
            }
            case 20: {
                return pSDCWorkshopServerBase.getRefCount() == null;
            }
            case 21: {
                return pSDCWorkshopServerBase.getResPos() == null;
            }
            case 22: {
                return pSDCWorkshopServerBase.getResReadyTime() == null;
            }
            case 23: {
                return pSDCWorkshopServerBase.getResState() == null;
            }
            case 24: {
                return pSDCWorkshopServerBase.getResVer() == null;
            }
            case 25: {
                return pSDCWorkshopServerBase.getSSHIPAddr() == null;
            }
            case 26: {
                return pSDCWorkshopServerBase.getSSHPort() == null;
            }
            case 27: {
                return pSDCWorkshopServerBase.getUpdateDate() == null;
            }
            case 28: {
                return pSDCWorkshopServerBase.getUpdateMan() == null;
            }
            case 29: {
                return pSDCWorkshopServerBase.getUploadFileMode() == null;
            }
            case 30: {
                return pSDCWorkshopServerBase.getUploadPath() == null;
            }
            case 31: {
                return pSDCWorkshopServerBase.getUserName() == null;
            }
            case 32: {
                return pSDCWorkshopServerBase.getValidFlag() == null;
            }
            case 33: {
                return pSDCWorkshopServerBase.getWebConsolePath() == null;
            }
            case 34: {
                return pSDCWorkshopServerBase.getWorkshopPath() == null;
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
        return PSDCWorkshopServerBase.contains(this, n);
    }

    private static boolean contains(PSDCWorkshopServerBase pSDCWorkshopServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCWorkshopServerBase.isAdminPasswdDirty();
            }
            case 1: {
                return pSDCWorkshopServerBase.isAdminUserNameDirty();
            }
            case 2: {
                return pSDCWorkshopServerBase.isCreateDateDirty();
            }
            case 3: {
                return pSDCWorkshopServerBase.isCreateManDirty();
            }
            case 4: {
                return pSDCWorkshopServerBase.isDefaultFlagDirty();
            }
            case 5: {
                return pSDCWorkshopServerBase.isExpriedTimeDirty();
            }
            case 6: {
                return pSDCWorkshopServerBase.isGITPasswordDirty();
            }
            case 7: {
                return pSDCWorkshopServerBase.isGitPathDirty();
            }
            case 8: {
                return pSDCWorkshopServerBase.isGITUserNameDirty();
            }
            case 9: {
                return pSDCWorkshopServerBase.isIpAddrDirty();
            }
            case 10: {
                return pSDCWorkshopServerBase.isIpAddr2Dirty();
            }
            case 11: {
                return pSDCWorkshopServerBase.isMemoDirty();
            }
            case 12: {
                return pSDCWorkshopServerBase.isPasswdDirty();
            }
            case 13: {
                return pSDCWorkshopServerBase.isPortDirty();
            }
            case 14: {
                return pSDCWorkshopServerBase.isPSDCWorkshopServerIdDirty();
            }
            case 15: {
                return pSDCWorkshopServerBase.isPSDCWorkshopServerNameDirty();
            }
            case 16: {
                return pSDCWorkshopServerBase.isPSDevCenterIdDirty();
            }
            case 17: {
                return pSDCWorkshopServerBase.isPSDevCenterNameDirty();
            }
            case 18: {
                return pSDCWorkshopServerBase.isPSWorkshopServerIdDirty();
            }
            case 19: {
                return pSDCWorkshopServerBase.isPSWorkshopServerNameDirty();
            }
            case 20: {
                return pSDCWorkshopServerBase.isRefCountDirty();
            }
            case 21: {
                return pSDCWorkshopServerBase.isResPosDirty();
            }
            case 22: {
                return pSDCWorkshopServerBase.isResReadyTimeDirty();
            }
            case 23: {
                return pSDCWorkshopServerBase.isResStateDirty();
            }
            case 24: {
                return pSDCWorkshopServerBase.isResVerDirty();
            }
            case 25: {
                return pSDCWorkshopServerBase.isSSHIPAddrDirty();
            }
            case 26: {
                return pSDCWorkshopServerBase.isSSHPortDirty();
            }
            case 27: {
                return pSDCWorkshopServerBase.isUpdateDateDirty();
            }
            case 28: {
                return pSDCWorkshopServerBase.isUpdateManDirty();
            }
            case 29: {
                return pSDCWorkshopServerBase.isUploadFileModeDirty();
            }
            case 30: {
                return pSDCWorkshopServerBase.isUploadPathDirty();
            }
            case 31: {
                return pSDCWorkshopServerBase.isUserNameDirty();
            }
            case 32: {
                return pSDCWorkshopServerBase.isValidFlagDirty();
            }
            case 33: {
                return pSDCWorkshopServerBase.isWebConsolePathDirty();
            }
            case 34: {
                return pSDCWorkshopServerBase.isWorkshopPathDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCWorkshopServerBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCWorkshopServerBase pSDCWorkshopServerBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCWorkshopServerBase.getAdminPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"adminpasswd", (Object)PSDCWorkshopServerBase.getJSONValue((Object)pSDCWorkshopServerBase.getAdminPasswd()), (boolean)false);
        }
        if (bl || pSDCWorkshopServerBase.getAdminUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"adminusername", (Object)PSDCWorkshopServerBase.getJSONValue((Object)pSDCWorkshopServerBase.getAdminUserName()), (boolean)false);
        }
        if (bl || pSDCWorkshopServerBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCWorkshopServerBase.getJSONValue((Object)pSDCWorkshopServerBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCWorkshopServerBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCWorkshopServerBase.getJSONValue((Object)pSDCWorkshopServerBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCWorkshopServerBase.getDefaultFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultflag", (Object)PSDCWorkshopServerBase.getJSONValue((Object)pSDCWorkshopServerBase.getDefaultFlag()), (boolean)false);
        }
        if (bl || pSDCWorkshopServerBase.getExpriedTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"expriedtime", (Object)PSDCWorkshopServerBase.getJSONValue((Object)pSDCWorkshopServerBase.getExpriedTime()), (boolean)false);
        }
        if (bl || pSDCWorkshopServerBase.getGITPassword() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gitpassword", (Object)PSDCWorkshopServerBase.getJSONValue((Object)pSDCWorkshopServerBase.getGITPassword()), (boolean)false);
        }
        if (bl || pSDCWorkshopServerBase.getGitPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gitpath", (Object)PSDCWorkshopServerBase.getJSONValue((Object)pSDCWorkshopServerBase.getGitPath()), (boolean)false);
        }
        if (bl || pSDCWorkshopServerBase.getGITUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gitusername", (Object)PSDCWorkshopServerBase.getJSONValue((Object)pSDCWorkshopServerBase.getGITUserName()), (boolean)false);
        }
        if (bl || pSDCWorkshopServerBase.getIpAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr", (Object)PSDCWorkshopServerBase.getJSONValue((Object)pSDCWorkshopServerBase.getIpAddr()), (boolean)false);
        }
        if (bl || pSDCWorkshopServerBase.getIpAddr2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr2", (Object)PSDCWorkshopServerBase.getJSONValue((Object)pSDCWorkshopServerBase.getIpAddr2()), (boolean)false);
        }
        if (bl || pSDCWorkshopServerBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCWorkshopServerBase.getJSONValue((Object)pSDCWorkshopServerBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCWorkshopServerBase.getPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"passwd", (Object)PSDCWorkshopServerBase.getJSONValue((Object)pSDCWorkshopServerBase.getPasswd()), (boolean)false);
        }
        if (bl || pSDCWorkshopServerBase.getPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"port", (Object)PSDCWorkshopServerBase.getJSONValue((Object)pSDCWorkshopServerBase.getPort()), (boolean)false);
        }
        if (bl || pSDCWorkshopServerBase.getPSDCWorkshopServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcworkshopserverid", (Object)PSDCWorkshopServerBase.getJSONValue((Object)pSDCWorkshopServerBase.getPSDCWorkshopServerId()), (boolean)false);
        }
        if (bl || pSDCWorkshopServerBase.getPSDCWorkshopServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcworkshopservername", (Object)PSDCWorkshopServerBase.getJSONValue((Object)pSDCWorkshopServerBase.getPSDCWorkshopServerName()), (boolean)false);
        }
        if (bl || pSDCWorkshopServerBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDCWorkshopServerBase.getJSONValue((Object)pSDCWorkshopServerBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDCWorkshopServerBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDCWorkshopServerBase.getJSONValue((Object)pSDCWorkshopServerBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDCWorkshopServerBase.getPSWorkshopServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psworkshopserverid", (Object)PSDCWorkshopServerBase.getJSONValue((Object)pSDCWorkshopServerBase.getPSWorkshopServerId()), (boolean)false);
        }
        if (bl || pSDCWorkshopServerBase.getPSWorkshopServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psworkshopservername", (Object)PSDCWorkshopServerBase.getJSONValue((Object)pSDCWorkshopServerBase.getPSWorkshopServerName()), (boolean)false);
        }
        if (bl || pSDCWorkshopServerBase.getRefCount() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refcount", (Object)PSDCWorkshopServerBase.getJSONValue((Object)pSDCWorkshopServerBase.getRefCount()), (boolean)false);
        }
        if (bl || pSDCWorkshopServerBase.getResPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"respos", (Object)PSDCWorkshopServerBase.getJSONValue((Object)pSDCWorkshopServerBase.getResPos()), (boolean)false);
        }
        if (bl || pSDCWorkshopServerBase.getResReadyTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resreadytime", (Object)PSDCWorkshopServerBase.getJSONValue((Object)pSDCWorkshopServerBase.getResReadyTime()), (boolean)false);
        }
        if (bl || pSDCWorkshopServerBase.getResState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resstate", (Object)PSDCWorkshopServerBase.getJSONValue((Object)pSDCWorkshopServerBase.getResState()), (boolean)false);
        }
        if (bl || pSDCWorkshopServerBase.getResVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resver", (Object)PSDCWorkshopServerBase.getJSONValue((Object)pSDCWorkshopServerBase.getResVer()), (boolean)false);
        }
        if (bl || pSDCWorkshopServerBase.getSSHIPAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sshipaddr", (Object)PSDCWorkshopServerBase.getJSONValue((Object)pSDCWorkshopServerBase.getSSHIPAddr()), (boolean)false);
        }
        if (bl || pSDCWorkshopServerBase.getSSHPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sshport", (Object)PSDCWorkshopServerBase.getJSONValue((Object)pSDCWorkshopServerBase.getSSHPort()), (boolean)false);
        }
        if (bl || pSDCWorkshopServerBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCWorkshopServerBase.getJSONValue((Object)pSDCWorkshopServerBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCWorkshopServerBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCWorkshopServerBase.getJSONValue((Object)pSDCWorkshopServerBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDCWorkshopServerBase.getUploadFileMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uploadfilemode", (Object)PSDCWorkshopServerBase.getJSONValue((Object)pSDCWorkshopServerBase.getUploadFileMode()), (boolean)false);
        }
        if (bl || pSDCWorkshopServerBase.getUploadPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uploadpath", (Object)PSDCWorkshopServerBase.getJSONValue((Object)pSDCWorkshopServerBase.getUploadPath()), (boolean)false);
        }
        if (bl || pSDCWorkshopServerBase.getUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"username", (Object)PSDCWorkshopServerBase.getJSONValue((Object)pSDCWorkshopServerBase.getUserName()), (boolean)false);
        }
        if (bl || pSDCWorkshopServerBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDCWorkshopServerBase.getJSONValue((Object)pSDCWorkshopServerBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSDCWorkshopServerBase.getWebConsolePath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"webconsolepath", (Object)PSDCWorkshopServerBase.getJSONValue((Object)pSDCWorkshopServerBase.getWebConsolePath()), (boolean)false);
        }
        if (bl || pSDCWorkshopServerBase.getWorkshopPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"workshoppath", (Object)PSDCWorkshopServerBase.getJSONValue((Object)pSDCWorkshopServerBase.getWorkshopPath()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCWorkshopServerBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCWorkshopServerBase pSDCWorkshopServerBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCWorkshopServerBase.getAdminPasswd() != null) {
            object = pSDCWorkshopServerBase.getAdminPasswd();
            xmlNode.setAttribute(FIELD_ADMINPASSWD, (String)(object == null ? "" : object));
        }
        if (bl || pSDCWorkshopServerBase.getAdminUserName() != null) {
            object = pSDCWorkshopServerBase.getAdminUserName();
            xmlNode.setAttribute(FIELD_ADMINUSERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkshopServerBase.getCreateDate() != null) {
            object = pSDCWorkshopServerBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCWorkshopServerBase.getCreateMan() != null) {
            object = pSDCWorkshopServerBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkshopServerBase.getDefaultFlag() != null) {
            object = pSDCWorkshopServerBase.getDefaultFlag();
            xmlNode.setAttribute(FIELD_DEFAULTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCWorkshopServerBase.getExpriedTime() != null) {
            object = pSDCWorkshopServerBase.getExpriedTime();
            xmlNode.setAttribute(FIELD_EXPRIEDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCWorkshopServerBase.getGITPassword() != null) {
            object = pSDCWorkshopServerBase.getGITPassword();
            xmlNode.setAttribute(FIELD_GITPASSWORD, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkshopServerBase.getGitPath() != null) {
            object = pSDCWorkshopServerBase.getGitPath();
            xmlNode.setAttribute(FIELD_GITPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkshopServerBase.getGITUserName() != null) {
            object = pSDCWorkshopServerBase.getGITUserName();
            xmlNode.setAttribute(FIELD_GITUSERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkshopServerBase.getIpAddr() != null) {
            object = pSDCWorkshopServerBase.getIpAddr();
            xmlNode.setAttribute(FIELD_IPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkshopServerBase.getIpAddr2() != null) {
            object = pSDCWorkshopServerBase.getIpAddr2();
            xmlNode.setAttribute(FIELD_IPADDR2, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkshopServerBase.getMemo() != null) {
            object = pSDCWorkshopServerBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkshopServerBase.getPasswd() != null) {
            object = pSDCWorkshopServerBase.getPasswd();
            xmlNode.setAttribute(FIELD_PASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkshopServerBase.getPort() != null) {
            object = pSDCWorkshopServerBase.getPort();
            xmlNode.setAttribute(FIELD_PORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCWorkshopServerBase.getPSDCWorkshopServerId() != null) {
            object = pSDCWorkshopServerBase.getPSDCWorkshopServerId();
            xmlNode.setAttribute(FIELD_PSDCWORKSHOPSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkshopServerBase.getPSDCWorkshopServerName() != null) {
            object = pSDCWorkshopServerBase.getPSDCWorkshopServerName();
            xmlNode.setAttribute(FIELD_PSDCWORKSHOPSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkshopServerBase.getPSDevCenterId() != null) {
            object = pSDCWorkshopServerBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkshopServerBase.getPSDevCenterName() != null) {
            object = pSDCWorkshopServerBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkshopServerBase.getPSWorkshopServerId() != null) {
            object = pSDCWorkshopServerBase.getPSWorkshopServerId();
            xmlNode.setAttribute(FIELD_PSWORKSHOPSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkshopServerBase.getPSWorkshopServerName() != null) {
            object = pSDCWorkshopServerBase.getPSWorkshopServerName();
            xmlNode.setAttribute(FIELD_PSWORKSHOPSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkshopServerBase.getRefCount() != null) {
            object = pSDCWorkshopServerBase.getRefCount();
            xmlNode.setAttribute(FIELD_REFCOUNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCWorkshopServerBase.getResPos() != null) {
            object = pSDCWorkshopServerBase.getResPos();
            xmlNode.setAttribute(FIELD_RESPOS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCWorkshopServerBase.getResReadyTime() != null) {
            object = pSDCWorkshopServerBase.getResReadyTime();
            xmlNode.setAttribute(FIELD_RESREADYTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCWorkshopServerBase.getResState() != null) {
            object = pSDCWorkshopServerBase.getResState();
            xmlNode.setAttribute(FIELD_RESSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCWorkshopServerBase.getResVer() != null) {
            object = pSDCWorkshopServerBase.getResVer();
            xmlNode.setAttribute(FIELD_RESVER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCWorkshopServerBase.getSSHIPAddr() != null) {
            object = pSDCWorkshopServerBase.getSSHIPAddr();
            xmlNode.setAttribute(FIELD_SSHIPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkshopServerBase.getSSHPort() != null) {
            object = pSDCWorkshopServerBase.getSSHPort();
            xmlNode.setAttribute(FIELD_SSHPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCWorkshopServerBase.getUpdateDate() != null) {
            object = pSDCWorkshopServerBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCWorkshopServerBase.getUpdateMan() != null) {
            object = pSDCWorkshopServerBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkshopServerBase.getUploadFileMode() != null) {
            object = pSDCWorkshopServerBase.getUploadFileMode();
            xmlNode.setAttribute(FIELD_UPLOADFILEMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkshopServerBase.getUploadPath() != null) {
            object = pSDCWorkshopServerBase.getUploadPath();
            xmlNode.setAttribute(FIELD_UPLOADPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkshopServerBase.getUserName() != null) {
            object = pSDCWorkshopServerBase.getUserName();
            xmlNode.setAttribute(FIELD_USERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkshopServerBase.getValidFlag() != null) {
            object = pSDCWorkshopServerBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCWorkshopServerBase.getWebConsolePath() != null) {
            object = pSDCWorkshopServerBase.getWebConsolePath();
            xmlNode.setAttribute(FIELD_WEBCONSOLEPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkshopServerBase.getWorkshopPath() != null) {
            object = pSDCWorkshopServerBase.getWorkshopPath();
            xmlNode.setAttribute(FIELD_WORKSHOPPATH, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCWorkshopServerBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCWorkshopServerBase pSDCWorkshopServerBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCWorkshopServerBase.isAdminPasswdDirty() && (bl || pSDCWorkshopServerBase.getAdminPasswd() != null)) {
            iDataObject.set(FIELD_ADMINPASSWD, (Object)pSDCWorkshopServerBase.getAdminPasswd());
        }
        if (pSDCWorkshopServerBase.isAdminUserNameDirty() && (bl || pSDCWorkshopServerBase.getAdminUserName() != null)) {
            iDataObject.set(FIELD_ADMINUSERNAME, (Object)pSDCWorkshopServerBase.getAdminUserName());
        }
        if (pSDCWorkshopServerBase.isCreateDateDirty() && (bl || pSDCWorkshopServerBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCWorkshopServerBase.getCreateDate());
        }
        if (pSDCWorkshopServerBase.isCreateManDirty() && (bl || pSDCWorkshopServerBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCWorkshopServerBase.getCreateMan());
        }
        if (pSDCWorkshopServerBase.isDefaultFlagDirty() && (bl || pSDCWorkshopServerBase.getDefaultFlag() != null)) {
            iDataObject.set(FIELD_DEFAULTFLAG, (Object)pSDCWorkshopServerBase.getDefaultFlag());
        }
        if (pSDCWorkshopServerBase.isExpriedTimeDirty() && (bl || pSDCWorkshopServerBase.getExpriedTime() != null)) {
            iDataObject.set(FIELD_EXPRIEDTIME, (Object)pSDCWorkshopServerBase.getExpriedTime());
        }
        if (pSDCWorkshopServerBase.isGITPasswordDirty() && (bl || pSDCWorkshopServerBase.getGITPassword() != null)) {
            iDataObject.set(FIELD_GITPASSWORD, (Object)pSDCWorkshopServerBase.getGITPassword());
        }
        if (pSDCWorkshopServerBase.isGitPathDirty() && (bl || pSDCWorkshopServerBase.getGitPath() != null)) {
            iDataObject.set(FIELD_GITPATH, (Object)pSDCWorkshopServerBase.getGitPath());
        }
        if (pSDCWorkshopServerBase.isGITUserNameDirty() && (bl || pSDCWorkshopServerBase.getGITUserName() != null)) {
            iDataObject.set(FIELD_GITUSERNAME, (Object)pSDCWorkshopServerBase.getGITUserName());
        }
        if (pSDCWorkshopServerBase.isIpAddrDirty() && (bl || pSDCWorkshopServerBase.getIpAddr() != null)) {
            iDataObject.set(FIELD_IPADDR, (Object)pSDCWorkshopServerBase.getIpAddr());
        }
        if (pSDCWorkshopServerBase.isIpAddr2Dirty() && (bl || pSDCWorkshopServerBase.getIpAddr2() != null)) {
            iDataObject.set(FIELD_IPADDR2, (Object)pSDCWorkshopServerBase.getIpAddr2());
        }
        if (pSDCWorkshopServerBase.isMemoDirty() && (bl || pSDCWorkshopServerBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCWorkshopServerBase.getMemo());
        }
        if (pSDCWorkshopServerBase.isPasswdDirty() && (bl || pSDCWorkshopServerBase.getPasswd() != null)) {
            iDataObject.set(FIELD_PASSWD, (Object)pSDCWorkshopServerBase.getPasswd());
        }
        if (pSDCWorkshopServerBase.isPortDirty() && (bl || pSDCWorkshopServerBase.getPort() != null)) {
            iDataObject.set(FIELD_PORT, (Object)pSDCWorkshopServerBase.getPort());
        }
        if (pSDCWorkshopServerBase.isPSDCWorkshopServerIdDirty() && (bl || pSDCWorkshopServerBase.getPSDCWorkshopServerId() != null)) {
            iDataObject.set(FIELD_PSDCWORKSHOPSERVERID, (Object)pSDCWorkshopServerBase.getPSDCWorkshopServerId());
        }
        if (pSDCWorkshopServerBase.isPSDCWorkshopServerNameDirty() && (bl || pSDCWorkshopServerBase.getPSDCWorkshopServerName() != null)) {
            iDataObject.set(FIELD_PSDCWORKSHOPSERVERNAME, (Object)pSDCWorkshopServerBase.getPSDCWorkshopServerName());
        }
        if (pSDCWorkshopServerBase.isPSDevCenterIdDirty() && (bl || pSDCWorkshopServerBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDCWorkshopServerBase.getPSDevCenterId());
        }
        if (pSDCWorkshopServerBase.isPSDevCenterNameDirty() && (bl || pSDCWorkshopServerBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDCWorkshopServerBase.getPSDevCenterName());
        }
        if (pSDCWorkshopServerBase.isPSWorkshopServerIdDirty() && (bl || pSDCWorkshopServerBase.getPSWorkshopServerId() != null)) {
            iDataObject.set(FIELD_PSWORKSHOPSERVERID, (Object)pSDCWorkshopServerBase.getPSWorkshopServerId());
        }
        if (pSDCWorkshopServerBase.isPSWorkshopServerNameDirty() && (bl || pSDCWorkshopServerBase.getPSWorkshopServerName() != null)) {
            iDataObject.set(FIELD_PSWORKSHOPSERVERNAME, (Object)pSDCWorkshopServerBase.getPSWorkshopServerName());
        }
        if (pSDCWorkshopServerBase.isRefCountDirty() && (bl || pSDCWorkshopServerBase.getRefCount() != null)) {
            iDataObject.set(FIELD_REFCOUNT, (Object)pSDCWorkshopServerBase.getRefCount());
        }
        if (pSDCWorkshopServerBase.isResPosDirty() && (bl || pSDCWorkshopServerBase.getResPos() != null)) {
            iDataObject.set(FIELD_RESPOS, (Object)pSDCWorkshopServerBase.getResPos());
        }
        if (pSDCWorkshopServerBase.isResReadyTimeDirty() && (bl || pSDCWorkshopServerBase.getResReadyTime() != null)) {
            iDataObject.set(FIELD_RESREADYTIME, (Object)pSDCWorkshopServerBase.getResReadyTime());
        }
        if (pSDCWorkshopServerBase.isResStateDirty() && (bl || pSDCWorkshopServerBase.getResState() != null)) {
            iDataObject.set(FIELD_RESSTATE, (Object)pSDCWorkshopServerBase.getResState());
        }
        if (pSDCWorkshopServerBase.isResVerDirty() && (bl || pSDCWorkshopServerBase.getResVer() != null)) {
            iDataObject.set(FIELD_RESVER, (Object)pSDCWorkshopServerBase.getResVer());
        }
        if (pSDCWorkshopServerBase.isSSHIPAddrDirty() && (bl || pSDCWorkshopServerBase.getSSHIPAddr() != null)) {
            iDataObject.set(FIELD_SSHIPADDR, (Object)pSDCWorkshopServerBase.getSSHIPAddr());
        }
        if (pSDCWorkshopServerBase.isSSHPortDirty() && (bl || pSDCWorkshopServerBase.getSSHPort() != null)) {
            iDataObject.set(FIELD_SSHPORT, (Object)pSDCWorkshopServerBase.getSSHPort());
        }
        if (pSDCWorkshopServerBase.isUpdateDateDirty() && (bl || pSDCWorkshopServerBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCWorkshopServerBase.getUpdateDate());
        }
        if (pSDCWorkshopServerBase.isUpdateManDirty() && (bl || pSDCWorkshopServerBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCWorkshopServerBase.getUpdateMan());
        }
        if (pSDCWorkshopServerBase.isUploadFileModeDirty() && (bl || pSDCWorkshopServerBase.getUploadFileMode() != null)) {
            iDataObject.set(FIELD_UPLOADFILEMODE, (Object)pSDCWorkshopServerBase.getUploadFileMode());
        }
        if (pSDCWorkshopServerBase.isUploadPathDirty() && (bl || pSDCWorkshopServerBase.getUploadPath() != null)) {
            iDataObject.set(FIELD_UPLOADPATH, (Object)pSDCWorkshopServerBase.getUploadPath());
        }
        if (pSDCWorkshopServerBase.isUserNameDirty() && (bl || pSDCWorkshopServerBase.getUserName() != null)) {
            iDataObject.set(FIELD_USERNAME, (Object)pSDCWorkshopServerBase.getUserName());
        }
        if (pSDCWorkshopServerBase.isValidFlagDirty() && (bl || pSDCWorkshopServerBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDCWorkshopServerBase.getValidFlag());
        }
        if (pSDCWorkshopServerBase.isWebConsolePathDirty() && (bl || pSDCWorkshopServerBase.getWebConsolePath() != null)) {
            iDataObject.set(FIELD_WEBCONSOLEPATH, (Object)pSDCWorkshopServerBase.getWebConsolePath());
        }
        if (pSDCWorkshopServerBase.isWorkshopPathDirty() && (bl || pSDCWorkshopServerBase.getWorkshopPath() != null)) {
            iDataObject.set(FIELD_WORKSHOPPATH, (Object)pSDCWorkshopServerBase.getWorkshopPath());
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
        return PSDCWorkshopServerBase.remove(this, n);
    }

    private static boolean remove(PSDCWorkshopServerBase pSDCWorkshopServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCWorkshopServerBase.resetAdminPasswd();
                return true;
            }
            case 1: {
                pSDCWorkshopServerBase.resetAdminUserName();
                return true;
            }
            case 2: {
                pSDCWorkshopServerBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSDCWorkshopServerBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSDCWorkshopServerBase.resetDefaultFlag();
                return true;
            }
            case 5: {
                pSDCWorkshopServerBase.resetExpriedTime();
                return true;
            }
            case 6: {
                pSDCWorkshopServerBase.resetGITPassword();
                return true;
            }
            case 7: {
                pSDCWorkshopServerBase.resetGitPath();
                return true;
            }
            case 8: {
                pSDCWorkshopServerBase.resetGITUserName();
                return true;
            }
            case 9: {
                pSDCWorkshopServerBase.resetIpAddr();
                return true;
            }
            case 10: {
                pSDCWorkshopServerBase.resetIpAddr2();
                return true;
            }
            case 11: {
                pSDCWorkshopServerBase.resetMemo();
                return true;
            }
            case 12: {
                pSDCWorkshopServerBase.resetPasswd();
                return true;
            }
            case 13: {
                pSDCWorkshopServerBase.resetPort();
                return true;
            }
            case 14: {
                pSDCWorkshopServerBase.resetPSDCWorkshopServerId();
                return true;
            }
            case 15: {
                pSDCWorkshopServerBase.resetPSDCWorkshopServerName();
                return true;
            }
            case 16: {
                pSDCWorkshopServerBase.resetPSDevCenterId();
                return true;
            }
            case 17: {
                pSDCWorkshopServerBase.resetPSDevCenterName();
                return true;
            }
            case 18: {
                pSDCWorkshopServerBase.resetPSWorkshopServerId();
                return true;
            }
            case 19: {
                pSDCWorkshopServerBase.resetPSWorkshopServerName();
                return true;
            }
            case 20: {
                pSDCWorkshopServerBase.resetRefCount();
                return true;
            }
            case 21: {
                pSDCWorkshopServerBase.resetResPos();
                return true;
            }
            case 22: {
                pSDCWorkshopServerBase.resetResReadyTime();
                return true;
            }
            case 23: {
                pSDCWorkshopServerBase.resetResState();
                return true;
            }
            case 24: {
                pSDCWorkshopServerBase.resetResVer();
                return true;
            }
            case 25: {
                pSDCWorkshopServerBase.resetSSHIPAddr();
                return true;
            }
            case 26: {
                pSDCWorkshopServerBase.resetSSHPort();
                return true;
            }
            case 27: {
                pSDCWorkshopServerBase.resetUpdateDate();
                return true;
            }
            case 28: {
                pSDCWorkshopServerBase.resetUpdateMan();
                return true;
            }
            case 29: {
                pSDCWorkshopServerBase.resetUploadFileMode();
                return true;
            }
            case 30: {
                pSDCWorkshopServerBase.resetUploadPath();
                return true;
            }
            case 31: {
                pSDCWorkshopServerBase.resetUserName();
                return true;
            }
            case 32: {
                pSDCWorkshopServerBase.resetValidFlag();
                return true;
            }
            case 33: {
                pSDCWorkshopServerBase.resetWebConsolePath();
                return true;
            }
            case 34: {
                pSDCWorkshopServerBase.resetWorkshopPath();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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
    public PSWorkshopServer getPSWorkshopServer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWorkshopServer();
        }
        if (this.getPSWorkshopServerId() == null) {
            return null;
        }
        Integer n = this.objPSWorkshopServerLock;
        synchronized (n) {
            if (this.psworkshopserver != null && DataTypeHelper.compare((int)25, (Object)this.getPSWorkshopServerId(), (Object)this.psworkshopserver.getPSWorkshopServerId()) != 0L) {
                this.psworkshopserver = null;
            }
            if (this.psworkshopserver == null) {
                PSWorkshopServer pSWorkshopServer = new PSWorkshopServer();
                pSWorkshopServer.setPSWorkshopServerId(this.getPSWorkshopServerId());
                PSWorkshopServerService pSWorkshopServerService = (PSWorkshopServerService)ServiceGlobal.getService(PSWorkshopServerService.class, (SessionFactory)this.getSessionFactory());
                pSWorkshopServerService.autoGet(pSWorkshopServer);
                this.psworkshopserver = pSWorkshopServer;
            }
            return this.psworkshopserver;
        }
    }

    private PSDCWorkshopServerBase getProxyEntity() {
        return this.proxyPSDCWorkshopServerBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCWorkshopServerBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCWorkshopServerBase) {
            this.proxyPSDCWorkshopServerBase = (PSDCWorkshopServerBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCWorkshopServerService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ADMINPASSWD, 0);
        fieldIndexMap.put(FIELD_ADMINUSERNAME, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_DEFAULTFLAG, 4);
        fieldIndexMap.put(FIELD_EXPRIEDTIME, 5);
        fieldIndexMap.put(FIELD_GITPASSWORD, 6);
        fieldIndexMap.put(FIELD_GITPATH, 7);
        fieldIndexMap.put(FIELD_GITUSERNAME, 8);
        fieldIndexMap.put(FIELD_IPADDR, 9);
        fieldIndexMap.put(FIELD_IPADDR2, 10);
        fieldIndexMap.put(FIELD_MEMO, 11);
        fieldIndexMap.put(FIELD_PASSWD, 12);
        fieldIndexMap.put(FIELD_PORT, 13);
        fieldIndexMap.put(FIELD_PSDCWORKSHOPSERVERID, 14);
        fieldIndexMap.put(FIELD_PSDCWORKSHOPSERVERNAME, 15);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 16);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 17);
        fieldIndexMap.put(FIELD_PSWORKSHOPSERVERID, 18);
        fieldIndexMap.put(FIELD_PSWORKSHOPSERVERNAME, 19);
        fieldIndexMap.put(FIELD_REFCOUNT, 20);
        fieldIndexMap.put(FIELD_RESPOS, 21);
        fieldIndexMap.put(FIELD_RESREADYTIME, 22);
        fieldIndexMap.put(FIELD_RESSTATE, 23);
        fieldIndexMap.put(FIELD_RESVER, 24);
        fieldIndexMap.put(FIELD_SSHIPADDR, 25);
        fieldIndexMap.put(FIELD_SSHPORT, 26);
        fieldIndexMap.put(FIELD_UPDATEDATE, 27);
        fieldIndexMap.put(FIELD_UPDATEMAN, 28);
        fieldIndexMap.put(FIELD_UPLOADFILEMODE, 29);
        fieldIndexMap.put(FIELD_UPLOADPATH, 30);
        fieldIndexMap.put(FIELD_USERNAME, 31);
        fieldIndexMap.put(FIELD_VALIDFLAG, 32);
        fieldIndexMap.put(FIELD_WEBCONSOLEPATH, 33);
        fieldIndexMap.put(FIELD_WORKSHOPPATH, 34);
    }
}

