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
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain;
import net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSVNServerBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSVNServerBase.class);
    public static final String FIELD_AUTHZCFG = "AUTHZCFG";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_GITADMINPASS = "GITADMINPASS";
    public static final String FIELD_GITADMINUSER = "GITADMINUSER";
    public static final String FIELD_GITPASSWORD = "GITPASSWORD";
    public static final String FIELD_GITPATH = "GITPATH";
    public static final String FIELD_GITPRJ = "GITPRJ";
    public static final String FIELD_GITTOKEN = "GITTOKEN";
    public static final String FIELD_GITUSERNAME = "GITUSERNAME";
    public static final String FIELD_IPADDR = "IPADDR";
    public static final String FIELD_IPADDR2 = "IPADDR2";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PASSWD = "PASSWD";
    public static final String FIELD_PORT = "PORT";
    public static final String FIELD_PSSVNSERVERID = "PSSVNSERVERID";
    public static final String FIELD_PSSVNSERVERNAME = "PSSVNSERVERNAME";
    public static final String FIELD_PSSVRDOMAINID = "PSSVRDOMAINID";
    public static final String FIELD_PSSVRDOMAINNAME = "PSSVRDOMAINNAME";
    public static final String FIELD_SLAVEIPADDR = "SLAVEIPADDR";
    public static final String FIELD_SLAVEIPADDR2 = "SLAVEIPADDR2";
    public static final String FIELD_SLAVEPASSWD = "SLAVEPASSWD";
    public static final String FIELD_SLAVEPORT = "SLAVEPORT";
    public static final String FIELD_SLAVESVNPASSWD = "SLAVESVNPASSWD";
    public static final String FIELD_SLAVESVNROOT = "SLAVESVNROOT";
    public static final String FIELD_SLAVESVNURL = "SLAVESVNURL";
    public static final String FIELD_SLAVESVNUSERNAME = "SLAVESVNUSERNAME";
    public static final String FIELD_SLAVEUSERNAME = "SLAVEUSERNAME";
    public static final String FIELD_SVNPASSWD = "SVNPASSWD";
    public static final String FIELD_SVNROOT = "SVNROOT";
    public static final String FIELD_SVNTYPE = "SVNTYPE";
    public static final String FIELD_SVNURL = "SVNURL";
    public static final String FIELD_SVNUSERNAME = "SVNUSERNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERNAME = "USERNAME";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_AUTHZCFG = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_GITADMINPASS = 3;
    private static final int INDEX_GITADMINUSER = 4;
    private static final int INDEX_GITPASSWORD = 5;
    private static final int INDEX_GITPATH = 6;
    private static final int INDEX_GITPRJ = 7;
    private static final int INDEX_GITTOKEN = 8;
    private static final int INDEX_GITUSERNAME = 9;
    private static final int INDEX_IPADDR = 10;
    private static final int INDEX_IPADDR2 = 11;
    private static final int INDEX_MEMO = 12;
    private static final int INDEX_PASSWD = 13;
    private static final int INDEX_PORT = 14;
    private static final int INDEX_PSSVNSERVERID = 15;
    private static final int INDEX_PSSVNSERVERNAME = 16;
    private static final int INDEX_PSSVRDOMAINID = 17;
    private static final int INDEX_PSSVRDOMAINNAME = 18;
    private static final int INDEX_SLAVEIPADDR = 19;
    private static final int INDEX_SLAVEIPADDR2 = 20;
    private static final int INDEX_SLAVEPASSWD = 21;
    private static final int INDEX_SLAVEPORT = 22;
    private static final int INDEX_SLAVESVNPASSWD = 23;
    private static final int INDEX_SLAVESVNROOT = 24;
    private static final int INDEX_SLAVESVNURL = 25;
    private static final int INDEX_SLAVESVNUSERNAME = 26;
    private static final int INDEX_SLAVEUSERNAME = 27;
    private static final int INDEX_SVNPASSWD = 28;
    private static final int INDEX_SVNROOT = 29;
    private static final int INDEX_SVNTYPE = 30;
    private static final int INDEX_SVNURL = 31;
    private static final int INDEX_SVNUSERNAME = 32;
    private static final int INDEX_UPDATEDATE = 33;
    private static final int INDEX_UPDATEMAN = 34;
    private static final int INDEX_USERNAME = 35;
    private static final int INDEX_USERTAG = 36;
    private static final int INDEX_USERTAG2 = 37;
    private static final int INDEX_USERTAG3 = 38;
    private static final int INDEX_USERTAG4 = 39;
    private static final int INDEX_VALIDFLAG = 40;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSVNServerBase proxyPSSVNServerBase = null;
    private boolean authzcfgDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean gitadminpassDirtyFlag = false;
    private boolean gitadminuserDirtyFlag = false;
    private boolean gitpasswordDirtyFlag = false;
    private boolean gitpathDirtyFlag = false;
    private boolean gitprjDirtyFlag = false;
    private boolean gittokenDirtyFlag = false;
    private boolean gitusernameDirtyFlag = false;
    private boolean ipaddrDirtyFlag = false;
    private boolean ipaddr2DirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean passwdDirtyFlag = false;
    private boolean portDirtyFlag = false;
    private boolean pssvnserveridDirtyFlag = false;
    private boolean pssvnservernameDirtyFlag = false;
    private boolean pssvrdomainidDirtyFlag = false;
    private boolean pssvrdomainnameDirtyFlag = false;
    private boolean slaveipaddrDirtyFlag = false;
    private boolean slaveipaddr2DirtyFlag = false;
    private boolean slavepasswdDirtyFlag = false;
    private boolean slaveportDirtyFlag = false;
    private boolean slavesvnpasswdDirtyFlag = false;
    private boolean slavesvnrootDirtyFlag = false;
    private boolean slavesvnurlDirtyFlag = false;
    private boolean slavesvnusernameDirtyFlag = false;
    private boolean slaveusernameDirtyFlag = false;
    private boolean svnpasswdDirtyFlag = false;
    private boolean svnrootDirtyFlag = false;
    private boolean svntypeDirtyFlag = false;
    private boolean svnurlDirtyFlag = false;
    private boolean svnusernameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usernameDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="authzcfg")
    private String authzcfg;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="gitadminpass")
    private String gitadminpass;
    @Column(name="gitadminuser")
    private String gitadminuser;
    @Column(name="gitpassword")
    private String gitpassword;
    @Column(name="gitpath")
    private String gitpath;
    @Column(name="gitprj")
    private String gitprj;
    @Column(name="gittoken")
    private String gittoken;
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
    @Column(name="pssvnserverid")
    private String pssvnserverid;
    @Column(name="pssvnservername")
    private String pssvnservername;
    @Column(name="pssvrdomainid")
    private String pssvrdomainid;
    @Column(name="pssvrdomainname")
    private String pssvrdomainname;
    @Column(name="slaveipaddr")
    private String slaveipaddr;
    @Column(name="slaveipaddr2")
    private String slaveipaddr2;
    @Column(name="slavepasswd")
    private String slavepasswd;
    @Column(name="slaveport")
    private Integer slaveport;
    @Column(name="slavesvnpasswd")
    private String slavesvnpasswd;
    @Column(name="slavesvnroot")
    private String slavesvnroot;
    @Column(name="slavesvnurl")
    private String slavesvnurl;
    @Column(name="slavesvnusername")
    private String slavesvnusername;
    @Column(name="slaveusername")
    private String slaveusername;
    @Column(name="svnpasswd")
    private String svnpasswd;
    @Column(name="svnroot")
    private String svnroot;
    @Column(name="svntype")
    private String svntype;
    @Column(name="svnurl")
    private String svnurl;
    @Column(name="svnusername")
    private String svnusername;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="username")
    private String username;
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
    private Integer objPSSvrDomainLock = new Integer(1);
    private PSSvrDomain pssvrdomain = null;

    public void setAuthzCfg(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAuthzCfg(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.authzcfg = string;
        this.authzcfgDirtyFlag = true;
    }

    public String getAuthzCfg() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAuthzCfg();
        }
        return this.authzcfg;
    }

    public boolean isAuthzCfgDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAuthzCfgDirty();
        }
        return this.authzcfgDirtyFlag;
    }

    public void resetAuthzCfg() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAuthzCfg();
            return;
        }
        this.authzcfgDirtyFlag = false;
        this.authzcfg = null;
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

    public void setGitAdminPass(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGitAdminPass(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.gitadminpass = string;
        this.gitadminpassDirtyFlag = true;
    }

    public String getGitAdminPass() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGitAdminPass();
        }
        return this.gitadminpass;
    }

    public boolean isGitAdminPassDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGitAdminPassDirty();
        }
        return this.gitadminpassDirtyFlag;
    }

    public void resetGitAdminPass() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGitAdminPass();
            return;
        }
        this.gitadminpassDirtyFlag = false;
        this.gitadminpass = null;
    }

    public void setGitAdminUser(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGitAdminUser(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.gitadminuser = string;
        this.gitadminuserDirtyFlag = true;
    }

    public String getGitAdminUser() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGitAdminUser();
        }
        return this.gitadminuser;
    }

    public boolean isGitAdminUserDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGitAdminUserDirty();
        }
        return this.gitadminuserDirtyFlag;
    }

    public void resetGitAdminUser() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGitAdminUser();
            return;
        }
        this.gitadminuserDirtyFlag = false;
        this.gitadminuser = null;
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

    public void setGitPrj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGitPrj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.gitprj = string;
        this.gitprjDirtyFlag = true;
    }

    public String getGitPrj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGitPrj();
        }
        return this.gitprj;
    }

    public boolean isGitPrjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGitPrjDirty();
        }
        return this.gitprjDirtyFlag;
    }

    public void resetGitPrj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGitPrj();
            return;
        }
        this.gitprjDirtyFlag = false;
        this.gitprj = null;
    }

    public void setGitToken(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGitToken(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.gittoken = string;
        this.gittokenDirtyFlag = true;
    }

    public String getGitToken() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGitToken();
        }
        return this.gittoken;
    }

    public boolean isGitTokenDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGitTokenDirty();
        }
        return this.gittokenDirtyFlag;
    }

    public void resetGitToken() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGitToken();
            return;
        }
        this.gittokenDirtyFlag = false;
        this.gittoken = null;
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

    public void setPSSVNServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSVNServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssvnserverid = string;
        this.pssvnserveridDirtyFlag = true;
    }

    public String getPSSVNServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSVNServerId();
        }
        return this.pssvnserverid;
    }

    public boolean isPSSVNServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSVNServerIdDirty();
        }
        return this.pssvnserveridDirtyFlag;
    }

    public void resetPSSVNServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSVNServerId();
            return;
        }
        this.pssvnserveridDirtyFlag = false;
        this.pssvnserverid = null;
    }

    public void setPSSVNServerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSVNServerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssvnservername = string;
        this.pssvnservernameDirtyFlag = true;
    }

    public String getPSSVNServerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSVNServerName();
        }
        return this.pssvnservername;
    }

    public boolean isPSSVNServerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSVNServerNameDirty();
        }
        return this.pssvnservernameDirtyFlag;
    }

    public void resetPSSVNServerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSVNServerName();
            return;
        }
        this.pssvnservernameDirtyFlag = false;
        this.pssvnservername = null;
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

    public void setSlaveIPADDR(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSlaveIPADDR(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.slaveipaddr = string;
        this.slaveipaddrDirtyFlag = true;
    }

    public String getSlaveIPADDR() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSlaveIPADDR();
        }
        return this.slaveipaddr;
    }

    public boolean isSlaveIPADDRDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSlaveIPADDRDirty();
        }
        return this.slaveipaddrDirtyFlag;
    }

    public void resetSlaveIPADDR() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSlaveIPADDR();
            return;
        }
        this.slaveipaddrDirtyFlag = false;
        this.slaveipaddr = null;
    }

    public void setSlaveIpAddr2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSlaveIpAddr2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.slaveipaddr2 = string;
        this.slaveipaddr2DirtyFlag = true;
    }

    public String getSlaveIpAddr2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSlaveIpAddr2();
        }
        return this.slaveipaddr2;
    }

    public boolean isSlaveIpAddr2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSlaveIpAddr2Dirty();
        }
        return this.slaveipaddr2DirtyFlag;
    }

    public void resetSlaveIpAddr2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSlaveIpAddr2();
            return;
        }
        this.slaveipaddr2DirtyFlag = false;
        this.slaveipaddr2 = null;
    }

    public void setSlavePasswd(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSlavePasswd(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.slavepasswd = string;
        this.slavepasswdDirtyFlag = true;
    }

    public String getSlavePasswd() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSlavePasswd();
        }
        return this.slavepasswd;
    }

    public boolean isSlavePasswdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSlavePasswdDirty();
        }
        return this.slavepasswdDirtyFlag;
    }

    public void resetSlavePasswd() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSlavePasswd();
            return;
        }
        this.slavepasswdDirtyFlag = false;
        this.slavepasswd = null;
    }

    public void setSlavePort(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSlavePort(n);
            return;
        }
        this.slaveport = n;
        this.slaveportDirtyFlag = true;
    }

    public Integer getSlavePort() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSlavePort();
        }
        return this.slaveport;
    }

    public boolean isSlavePortDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSlavePortDirty();
        }
        return this.slaveportDirtyFlag;
    }

    public void resetSlavePort() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSlavePort();
            return;
        }
        this.slaveportDirtyFlag = false;
        this.slaveport = null;
    }

    public void setSlaveSvnPassWd(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSlaveSvnPassWd(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.slavesvnpasswd = string;
        this.slavesvnpasswdDirtyFlag = true;
    }

    public String getSlaveSvnPassWd() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSlaveSvnPassWd();
        }
        return this.slavesvnpasswd;
    }

    public boolean isSlaveSvnPassWdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSlaveSvnPassWdDirty();
        }
        return this.slavesvnpasswdDirtyFlag;
    }

    public void resetSlaveSvnPassWd() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSlaveSvnPassWd();
            return;
        }
        this.slavesvnpasswdDirtyFlag = false;
        this.slavesvnpasswd = null;
    }

    public void setSlaveSVNRoot(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSlaveSVNRoot(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.slavesvnroot = string;
        this.slavesvnrootDirtyFlag = true;
    }

    public String getSlaveSVNRoot() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSlaveSVNRoot();
        }
        return this.slavesvnroot;
    }

    public boolean isSlaveSVNRootDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSlaveSVNRootDirty();
        }
        return this.slavesvnrootDirtyFlag;
    }

    public void resetSlaveSVNRoot() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSlaveSVNRoot();
            return;
        }
        this.slavesvnrootDirtyFlag = false;
        this.slavesvnroot = null;
    }

    public void setSlaveSVNUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSlaveSVNUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.slavesvnurl = string;
        this.slavesvnurlDirtyFlag = true;
    }

    public String getSlaveSVNUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSlaveSVNUrl();
        }
        return this.slavesvnurl;
    }

    public boolean isSlaveSVNUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSlaveSVNUrlDirty();
        }
        return this.slavesvnurlDirtyFlag;
    }

    public void resetSlaveSVNUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSlaveSVNUrl();
            return;
        }
        this.slavesvnurlDirtyFlag = false;
        this.slavesvnurl = null;
    }

    public void setSlaveSvnUserName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSlaveSvnUserName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.slavesvnusername = string;
        this.slavesvnusernameDirtyFlag = true;
    }

    public String getSlaveSvnUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSlaveSvnUserName();
        }
        return this.slavesvnusername;
    }

    public boolean isSlaveSvnUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSlaveSvnUserNameDirty();
        }
        return this.slavesvnusernameDirtyFlag;
    }

    public void resetSlaveSvnUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSlaveSvnUserName();
            return;
        }
        this.slavesvnusernameDirtyFlag = false;
        this.slavesvnusername = null;
    }

    public void setSlaveUserName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSlaveUserName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.slaveusername = string;
        this.slaveusernameDirtyFlag = true;
    }

    public String getSlaveUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSlaveUserName();
        }
        return this.slaveusername;
    }

    public boolean isSlaveUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSlaveUserNameDirty();
        }
        return this.slaveusernameDirtyFlag;
    }

    public void resetSlaveUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSlaveUserName();
            return;
        }
        this.slaveusernameDirtyFlag = false;
        this.slaveusername = null;
    }

    public void setSvnPassWd(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSvnPassWd(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.svnpasswd = string;
        this.svnpasswdDirtyFlag = true;
    }

    public String getSvnPassWd() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSvnPassWd();
        }
        return this.svnpasswd;
    }

    public boolean isSvnPassWdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSvnPassWdDirty();
        }
        return this.svnpasswdDirtyFlag;
    }

    public void resetSvnPassWd() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSvnPassWd();
            return;
        }
        this.svnpasswdDirtyFlag = false;
        this.svnpasswd = null;
    }

    public void setSVNRoot(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSVNRoot(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.svnroot = string;
        this.svnrootDirtyFlag = true;
    }

    public String getSVNRoot() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSVNRoot();
        }
        return this.svnroot;
    }

    public boolean isSVNRootDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSVNRootDirty();
        }
        return this.svnrootDirtyFlag;
    }

    public void resetSVNRoot() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSVNRoot();
            return;
        }
        this.svnrootDirtyFlag = false;
        this.svnroot = null;
    }

    public void setSVNType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSVNType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.svntype = string;
        this.svntypeDirtyFlag = true;
    }

    public String getSVNType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSVNType();
        }
        return this.svntype;
    }

    public boolean isSVNTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSVNTypeDirty();
        }
        return this.svntypeDirtyFlag;
    }

    public void resetSVNType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSVNType();
            return;
        }
        this.svntypeDirtyFlag = false;
        this.svntype = null;
    }

    public void setSVNUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSVNUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.svnurl = string;
        this.svnurlDirtyFlag = true;
    }

    public String getSVNUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSVNUrl();
        }
        return this.svnurl;
    }

    public boolean isSVNUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSVNUrlDirty();
        }
        return this.svnurlDirtyFlag;
    }

    public void resetSVNUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSVNUrl();
            return;
        }
        this.svnurlDirtyFlag = false;
        this.svnurl = null;
    }

    public void setSvnUserName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSvnUserName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.svnusername = string;
        this.svnusernameDirtyFlag = true;
    }

    public String getSvnUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSvnUserName();
        }
        return this.svnusername;
    }

    public boolean isSvnUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSvnUserNameDirty();
        }
        return this.svnusernameDirtyFlag;
    }

    public void resetSvnUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSvnUserName();
            return;
        }
        this.svnusernameDirtyFlag = false;
        this.svnusername = null;
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
        PSSVNServerBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSVNServerBase pSSVNServerBase) {
        pSSVNServerBase.resetAuthzCfg();
        pSSVNServerBase.resetCreateDate();
        pSSVNServerBase.resetCreateMan();
        pSSVNServerBase.resetGitAdminPass();
        pSSVNServerBase.resetGitAdminUser();
        pSSVNServerBase.resetGITPassword();
        pSSVNServerBase.resetGitPath();
        pSSVNServerBase.resetGitPrj();
        pSSVNServerBase.resetGitToken();
        pSSVNServerBase.resetGITUserName();
        pSSVNServerBase.resetIpAddr();
        pSSVNServerBase.resetIpAddr2();
        pSSVNServerBase.resetMemo();
        pSSVNServerBase.resetPasswd();
        pSSVNServerBase.resetPort();
        pSSVNServerBase.resetPSSVNServerId();
        pSSVNServerBase.resetPSSVNServerName();
        pSSVNServerBase.resetPSSvrDomainId();
        pSSVNServerBase.resetPSSvrDomainName();
        pSSVNServerBase.resetSlaveIPADDR();
        pSSVNServerBase.resetSlaveIpAddr2();
        pSSVNServerBase.resetSlavePasswd();
        pSSVNServerBase.resetSlavePort();
        pSSVNServerBase.resetSlaveSvnPassWd();
        pSSVNServerBase.resetSlaveSVNRoot();
        pSSVNServerBase.resetSlaveSVNUrl();
        pSSVNServerBase.resetSlaveSvnUserName();
        pSSVNServerBase.resetSlaveUserName();
        pSSVNServerBase.resetSvnPassWd();
        pSSVNServerBase.resetSVNRoot();
        pSSVNServerBase.resetSVNType();
        pSSVNServerBase.resetSVNUrl();
        pSSVNServerBase.resetSvnUserName();
        pSSVNServerBase.resetUpdateDate();
        pSSVNServerBase.resetUpdateMan();
        pSSVNServerBase.resetUserName();
        pSSVNServerBase.resetUserTag();
        pSSVNServerBase.resetUserTag2();
        pSSVNServerBase.resetUserTag3();
        pSSVNServerBase.resetUserTag4();
        pSSVNServerBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAuthzCfgDirty()) {
            hashMap.put(FIELD_AUTHZCFG, this.getAuthzCfg());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isGitAdminPassDirty()) {
            hashMap.put(FIELD_GITADMINPASS, this.getGitAdminPass());
        }
        if (!bl || this.isGitAdminUserDirty()) {
            hashMap.put(FIELD_GITADMINUSER, this.getGitAdminUser());
        }
        if (!bl || this.isGITPasswordDirty()) {
            hashMap.put(FIELD_GITPASSWORD, this.getGITPassword());
        }
        if (!bl || this.isGitPathDirty()) {
            hashMap.put(FIELD_GITPATH, this.getGitPath());
        }
        if (!bl || this.isGitPrjDirty()) {
            hashMap.put(FIELD_GITPRJ, this.getGitPrj());
        }
        if (!bl || this.isGitTokenDirty()) {
            hashMap.put(FIELD_GITTOKEN, this.getGitToken());
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
        if (!bl || this.isPSSVNServerIdDirty()) {
            hashMap.put(FIELD_PSSVNSERVERID, this.getPSSVNServerId());
        }
        if (!bl || this.isPSSVNServerNameDirty()) {
            hashMap.put(FIELD_PSSVNSERVERNAME, this.getPSSVNServerName());
        }
        if (!bl || this.isPSSvrDomainIdDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINID, this.getPSSvrDomainId());
        }
        if (!bl || this.isPSSvrDomainNameDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINNAME, this.getPSSvrDomainName());
        }
        if (!bl || this.isSlaveIPADDRDirty()) {
            hashMap.put(FIELD_SLAVEIPADDR, this.getSlaveIPADDR());
        }
        if (!bl || this.isSlaveIpAddr2Dirty()) {
            hashMap.put(FIELD_SLAVEIPADDR2, this.getSlaveIpAddr2());
        }
        if (!bl || this.isSlavePasswdDirty()) {
            hashMap.put(FIELD_SLAVEPASSWD, this.getSlavePasswd());
        }
        if (!bl || this.isSlavePortDirty()) {
            hashMap.put(FIELD_SLAVEPORT, this.getSlavePort());
        }
        if (!bl || this.isSlaveSvnPassWdDirty()) {
            hashMap.put(FIELD_SLAVESVNPASSWD, this.getSlaveSvnPassWd());
        }
        if (!bl || this.isSlaveSVNRootDirty()) {
            hashMap.put(FIELD_SLAVESVNROOT, this.getSlaveSVNRoot());
        }
        if (!bl || this.isSlaveSVNUrlDirty()) {
            hashMap.put(FIELD_SLAVESVNURL, this.getSlaveSVNUrl());
        }
        if (!bl || this.isSlaveSvnUserNameDirty()) {
            hashMap.put(FIELD_SLAVESVNUSERNAME, this.getSlaveSvnUserName());
        }
        if (!bl || this.isSlaveUserNameDirty()) {
            hashMap.put(FIELD_SLAVEUSERNAME, this.getSlaveUserName());
        }
        if (!bl || this.isSvnPassWdDirty()) {
            hashMap.put(FIELD_SVNPASSWD, this.getSvnPassWd());
        }
        if (!bl || this.isSVNRootDirty()) {
            hashMap.put(FIELD_SVNROOT, this.getSVNRoot());
        }
        if (!bl || this.isSVNTypeDirty()) {
            hashMap.put(FIELD_SVNTYPE, this.getSVNType());
        }
        if (!bl || this.isSVNUrlDirty()) {
            hashMap.put(FIELD_SVNURL, this.getSVNUrl());
        }
        if (!bl || this.isSvnUserNameDirty()) {
            hashMap.put(FIELD_SVNUSERNAME, this.getSvnUserName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserNameDirty()) {
            hashMap.put(FIELD_USERNAME, this.getUserName());
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
        return PSSVNServerBase.get(this, n);
    }

    private static Object get(PSSVNServerBase pSSVNServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSVNServerBase.getAuthzCfg();
            }
            case 1: {
                return pSSVNServerBase.getCreateDate();
            }
            case 2: {
                return pSSVNServerBase.getCreateMan();
            }
            case 3: {
                return pSSVNServerBase.getGitAdminPass();
            }
            case 4: {
                return pSSVNServerBase.getGitAdminUser();
            }
            case 5: {
                return pSSVNServerBase.getGITPassword();
            }
            case 6: {
                return pSSVNServerBase.getGitPath();
            }
            case 7: {
                return pSSVNServerBase.getGitPrj();
            }
            case 8: {
                return pSSVNServerBase.getGitToken();
            }
            case 9: {
                return pSSVNServerBase.getGITUserName();
            }
            case 10: {
                return pSSVNServerBase.getIpAddr();
            }
            case 11: {
                return pSSVNServerBase.getIpAddr2();
            }
            case 12: {
                return pSSVNServerBase.getMemo();
            }
            case 13: {
                return pSSVNServerBase.getPasswd();
            }
            case 14: {
                return pSSVNServerBase.getPort();
            }
            case 15: {
                return pSSVNServerBase.getPSSVNServerId();
            }
            case 16: {
                return pSSVNServerBase.getPSSVNServerName();
            }
            case 17: {
                return pSSVNServerBase.getPSSvrDomainId();
            }
            case 18: {
                return pSSVNServerBase.getPSSvrDomainName();
            }
            case 19: {
                return pSSVNServerBase.getSlaveIPADDR();
            }
            case 20: {
                return pSSVNServerBase.getSlaveIpAddr2();
            }
            case 21: {
                return pSSVNServerBase.getSlavePasswd();
            }
            case 22: {
                return pSSVNServerBase.getSlavePort();
            }
            case 23: {
                return pSSVNServerBase.getSlaveSvnPassWd();
            }
            case 24: {
                return pSSVNServerBase.getSlaveSVNRoot();
            }
            case 25: {
                return pSSVNServerBase.getSlaveSVNUrl();
            }
            case 26: {
                return pSSVNServerBase.getSlaveSvnUserName();
            }
            case 27: {
                return pSSVNServerBase.getSlaveUserName();
            }
            case 28: {
                return pSSVNServerBase.getSvnPassWd();
            }
            case 29: {
                return pSSVNServerBase.getSVNRoot();
            }
            case 30: {
                return pSSVNServerBase.getSVNType();
            }
            case 31: {
                return pSSVNServerBase.getSVNUrl();
            }
            case 32: {
                return pSSVNServerBase.getSvnUserName();
            }
            case 33: {
                return pSSVNServerBase.getUpdateDate();
            }
            case 34: {
                return pSSVNServerBase.getUpdateMan();
            }
            case 35: {
                return pSSVNServerBase.getUserName();
            }
            case 36: {
                return pSSVNServerBase.getUserTag();
            }
            case 37: {
                return pSSVNServerBase.getUserTag2();
            }
            case 38: {
                return pSSVNServerBase.getUserTag3();
            }
            case 39: {
                return pSSVNServerBase.getUserTag4();
            }
            case 40: {
                return pSSVNServerBase.getValidFlag();
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
        PSSVNServerBase.set(this, n, object);
    }

    private static void set(PSSVNServerBase pSSVNServerBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSVNServerBase.setAuthzCfg(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSVNServerBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSVNServerBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSVNServerBase.setGitAdminPass(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSVNServerBase.setGitAdminUser(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSVNServerBase.setGITPassword(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSVNServerBase.setGitPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSVNServerBase.setGitPrj(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSVNServerBase.setGitToken(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSVNServerBase.setGITUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSVNServerBase.setIpAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSVNServerBase.setIpAddr2(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSVNServerBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSVNServerBase.setPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSVNServerBase.setPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSSVNServerBase.setPSSVNServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSVNServerBase.setPSSVNServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSVNServerBase.setPSSvrDomainId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSVNServerBase.setPSSvrDomainName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSVNServerBase.setSlaveIPADDR(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSVNServerBase.setSlaveIpAddr2(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSVNServerBase.setSlavePasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSVNServerBase.setSlavePort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 23: {
                pSSVNServerBase.setSlaveSvnPassWd(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSVNServerBase.setSlaveSVNRoot(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSVNServerBase.setSlaveSVNUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSVNServerBase.setSlaveSvnUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSVNServerBase.setSlaveUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSVNServerBase.setSvnPassWd(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSVNServerBase.setSVNRoot(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSVNServerBase.setSVNType(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSVNServerBase.setSVNUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSVNServerBase.setSvnUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSVNServerBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 34: {
                pSSVNServerBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSVNServerBase.setUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSSVNServerBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSSVNServerBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSSVNServerBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSSVNServerBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSSVNServerBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSVNServerBase.isNull(this, n);
    }

    private static boolean isNull(PSSVNServerBase pSSVNServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSVNServerBase.getAuthzCfg() == null;
            }
            case 1: {
                return pSSVNServerBase.getCreateDate() == null;
            }
            case 2: {
                return pSSVNServerBase.getCreateMan() == null;
            }
            case 3: {
                return pSSVNServerBase.getGitAdminPass() == null;
            }
            case 4: {
                return pSSVNServerBase.getGitAdminUser() == null;
            }
            case 5: {
                return pSSVNServerBase.getGITPassword() == null;
            }
            case 6: {
                return pSSVNServerBase.getGitPath() == null;
            }
            case 7: {
                return pSSVNServerBase.getGitPrj() == null;
            }
            case 8: {
                return pSSVNServerBase.getGitToken() == null;
            }
            case 9: {
                return pSSVNServerBase.getGITUserName() == null;
            }
            case 10: {
                return pSSVNServerBase.getIpAddr() == null;
            }
            case 11: {
                return pSSVNServerBase.getIpAddr2() == null;
            }
            case 12: {
                return pSSVNServerBase.getMemo() == null;
            }
            case 13: {
                return pSSVNServerBase.getPasswd() == null;
            }
            case 14: {
                return pSSVNServerBase.getPort() == null;
            }
            case 15: {
                return pSSVNServerBase.getPSSVNServerId() == null;
            }
            case 16: {
                return pSSVNServerBase.getPSSVNServerName() == null;
            }
            case 17: {
                return pSSVNServerBase.getPSSvrDomainId() == null;
            }
            case 18: {
                return pSSVNServerBase.getPSSvrDomainName() == null;
            }
            case 19: {
                return pSSVNServerBase.getSlaveIPADDR() == null;
            }
            case 20: {
                return pSSVNServerBase.getSlaveIpAddr2() == null;
            }
            case 21: {
                return pSSVNServerBase.getSlavePasswd() == null;
            }
            case 22: {
                return pSSVNServerBase.getSlavePort() == null;
            }
            case 23: {
                return pSSVNServerBase.getSlaveSvnPassWd() == null;
            }
            case 24: {
                return pSSVNServerBase.getSlaveSVNRoot() == null;
            }
            case 25: {
                return pSSVNServerBase.getSlaveSVNUrl() == null;
            }
            case 26: {
                return pSSVNServerBase.getSlaveSvnUserName() == null;
            }
            case 27: {
                return pSSVNServerBase.getSlaveUserName() == null;
            }
            case 28: {
                return pSSVNServerBase.getSvnPassWd() == null;
            }
            case 29: {
                return pSSVNServerBase.getSVNRoot() == null;
            }
            case 30: {
                return pSSVNServerBase.getSVNType() == null;
            }
            case 31: {
                return pSSVNServerBase.getSVNUrl() == null;
            }
            case 32: {
                return pSSVNServerBase.getSvnUserName() == null;
            }
            case 33: {
                return pSSVNServerBase.getUpdateDate() == null;
            }
            case 34: {
                return pSSVNServerBase.getUpdateMan() == null;
            }
            case 35: {
                return pSSVNServerBase.getUserName() == null;
            }
            case 36: {
                return pSSVNServerBase.getUserTag() == null;
            }
            case 37: {
                return pSSVNServerBase.getUserTag2() == null;
            }
            case 38: {
                return pSSVNServerBase.getUserTag3() == null;
            }
            case 39: {
                return pSSVNServerBase.getUserTag4() == null;
            }
            case 40: {
                return pSSVNServerBase.getValidFlag() == null;
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
        return PSSVNServerBase.contains(this, n);
    }

    private static boolean contains(PSSVNServerBase pSSVNServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSVNServerBase.isAuthzCfgDirty();
            }
            case 1: {
                return pSSVNServerBase.isCreateDateDirty();
            }
            case 2: {
                return pSSVNServerBase.isCreateManDirty();
            }
            case 3: {
                return pSSVNServerBase.isGitAdminPassDirty();
            }
            case 4: {
                return pSSVNServerBase.isGitAdminUserDirty();
            }
            case 5: {
                return pSSVNServerBase.isGITPasswordDirty();
            }
            case 6: {
                return pSSVNServerBase.isGitPathDirty();
            }
            case 7: {
                return pSSVNServerBase.isGitPrjDirty();
            }
            case 8: {
                return pSSVNServerBase.isGitTokenDirty();
            }
            case 9: {
                return pSSVNServerBase.isGITUserNameDirty();
            }
            case 10: {
                return pSSVNServerBase.isIpAddrDirty();
            }
            case 11: {
                return pSSVNServerBase.isIpAddr2Dirty();
            }
            case 12: {
                return pSSVNServerBase.isMemoDirty();
            }
            case 13: {
                return pSSVNServerBase.isPasswdDirty();
            }
            case 14: {
                return pSSVNServerBase.isPortDirty();
            }
            case 15: {
                return pSSVNServerBase.isPSSVNServerIdDirty();
            }
            case 16: {
                return pSSVNServerBase.isPSSVNServerNameDirty();
            }
            case 17: {
                return pSSVNServerBase.isPSSvrDomainIdDirty();
            }
            case 18: {
                return pSSVNServerBase.isPSSvrDomainNameDirty();
            }
            case 19: {
                return pSSVNServerBase.isSlaveIPADDRDirty();
            }
            case 20: {
                return pSSVNServerBase.isSlaveIpAddr2Dirty();
            }
            case 21: {
                return pSSVNServerBase.isSlavePasswdDirty();
            }
            case 22: {
                return pSSVNServerBase.isSlavePortDirty();
            }
            case 23: {
                return pSSVNServerBase.isSlaveSvnPassWdDirty();
            }
            case 24: {
                return pSSVNServerBase.isSlaveSVNRootDirty();
            }
            case 25: {
                return pSSVNServerBase.isSlaveSVNUrlDirty();
            }
            case 26: {
                return pSSVNServerBase.isSlaveSvnUserNameDirty();
            }
            case 27: {
                return pSSVNServerBase.isSlaveUserNameDirty();
            }
            case 28: {
                return pSSVNServerBase.isSvnPassWdDirty();
            }
            case 29: {
                return pSSVNServerBase.isSVNRootDirty();
            }
            case 30: {
                return pSSVNServerBase.isSVNTypeDirty();
            }
            case 31: {
                return pSSVNServerBase.isSVNUrlDirty();
            }
            case 32: {
                return pSSVNServerBase.isSvnUserNameDirty();
            }
            case 33: {
                return pSSVNServerBase.isUpdateDateDirty();
            }
            case 34: {
                return pSSVNServerBase.isUpdateManDirty();
            }
            case 35: {
                return pSSVNServerBase.isUserNameDirty();
            }
            case 36: {
                return pSSVNServerBase.isUserTagDirty();
            }
            case 37: {
                return pSSVNServerBase.isUserTag2Dirty();
            }
            case 38: {
                return pSSVNServerBase.isUserTag3Dirty();
            }
            case 39: {
                return pSSVNServerBase.isUserTag4Dirty();
            }
            case 40: {
                return pSSVNServerBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSVNServerBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSVNServerBase pSSVNServerBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSVNServerBase.getAuthzCfg() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authzcfg", (Object)PSSVNServerBase.getJSONValue((Object)pSSVNServerBase.getAuthzCfg()), (boolean)false);
        }
        if (bl || pSSVNServerBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSVNServerBase.getJSONValue((Object)pSSVNServerBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSVNServerBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSVNServerBase.getJSONValue((Object)pSSVNServerBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSVNServerBase.getGitAdminPass() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gitadminpass", (Object)PSSVNServerBase.getJSONValue((Object)pSSVNServerBase.getGitAdminPass()), (boolean)false);
        }
        if (bl || pSSVNServerBase.getGitAdminUser() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gitadminuser", (Object)PSSVNServerBase.getJSONValue((Object)pSSVNServerBase.getGitAdminUser()), (boolean)false);
        }
        if (bl || pSSVNServerBase.getGITPassword() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gitpassword", (Object)PSSVNServerBase.getJSONValue((Object)pSSVNServerBase.getGITPassword()), (boolean)false);
        }
        if (bl || pSSVNServerBase.getGitPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gitpath", (Object)PSSVNServerBase.getJSONValue((Object)pSSVNServerBase.getGitPath()), (boolean)false);
        }
        if (bl || pSSVNServerBase.getGitPrj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gitprj", (Object)PSSVNServerBase.getJSONValue((Object)pSSVNServerBase.getGitPrj()), (boolean)false);
        }
        if (bl || pSSVNServerBase.getGitToken() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gittoken", (Object)PSSVNServerBase.getJSONValue((Object)pSSVNServerBase.getGitToken()), (boolean)false);
        }
        if (bl || pSSVNServerBase.getGITUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gitusername", (Object)PSSVNServerBase.getJSONValue((Object)pSSVNServerBase.getGITUserName()), (boolean)false);
        }
        if (bl || pSSVNServerBase.getIpAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr", (Object)PSSVNServerBase.getJSONValue((Object)pSSVNServerBase.getIpAddr()), (boolean)false);
        }
        if (bl || pSSVNServerBase.getIpAddr2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr2", (Object)PSSVNServerBase.getJSONValue((Object)pSSVNServerBase.getIpAddr2()), (boolean)false);
        }
        if (bl || pSSVNServerBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSVNServerBase.getJSONValue((Object)pSSVNServerBase.getMemo()), (boolean)false);
        }
        if (bl || pSSVNServerBase.getPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"passwd", (Object)PSSVNServerBase.getJSONValue((Object)pSSVNServerBase.getPasswd()), (boolean)false);
        }
        if (bl || pSSVNServerBase.getPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"port", (Object)PSSVNServerBase.getJSONValue((Object)pSSVNServerBase.getPort()), (boolean)false);
        }
        if (bl || pSSVNServerBase.getPSSVNServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvnserverid", (Object)PSSVNServerBase.getJSONValue((Object)pSSVNServerBase.getPSSVNServerId()), (boolean)false);
        }
        if (bl || pSSVNServerBase.getPSSVNServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvnservername", (Object)PSSVNServerBase.getJSONValue((Object)pSSVNServerBase.getPSSVNServerName()), (boolean)false);
        }
        if (bl || pSSVNServerBase.getPSSvrDomainId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainid", (Object)PSSVNServerBase.getJSONValue((Object)pSSVNServerBase.getPSSvrDomainId()), (boolean)false);
        }
        if (bl || pSSVNServerBase.getPSSvrDomainName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainname", (Object)PSSVNServerBase.getJSONValue((Object)pSSVNServerBase.getPSSvrDomainName()), (boolean)false);
        }
        if (bl || pSSVNServerBase.getSlaveIPADDR() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"slaveipaddr", (Object)PSSVNServerBase.getJSONValue((Object)pSSVNServerBase.getSlaveIPADDR()), (boolean)false);
        }
        if (bl || pSSVNServerBase.getSlaveIpAddr2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"slaveipaddr2", (Object)PSSVNServerBase.getJSONValue((Object)pSSVNServerBase.getSlaveIpAddr2()), (boolean)false);
        }
        if (bl || pSSVNServerBase.getSlavePasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"slavepasswd", (Object)PSSVNServerBase.getJSONValue((Object)pSSVNServerBase.getSlavePasswd()), (boolean)false);
        }
        if (bl || pSSVNServerBase.getSlavePort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"slaveport", (Object)PSSVNServerBase.getJSONValue((Object)pSSVNServerBase.getSlavePort()), (boolean)false);
        }
        if (bl || pSSVNServerBase.getSlaveSvnPassWd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"slavesvnpasswd", (Object)PSSVNServerBase.getJSONValue((Object)pSSVNServerBase.getSlaveSvnPassWd()), (boolean)false);
        }
        if (bl || pSSVNServerBase.getSlaveSVNRoot() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"slavesvnroot", (Object)PSSVNServerBase.getJSONValue((Object)pSSVNServerBase.getSlaveSVNRoot()), (boolean)false);
        }
        if (bl || pSSVNServerBase.getSlaveSVNUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"slavesvnurl", (Object)PSSVNServerBase.getJSONValue((Object)pSSVNServerBase.getSlaveSVNUrl()), (boolean)false);
        }
        if (bl || pSSVNServerBase.getSlaveSvnUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"slavesvnusername", (Object)PSSVNServerBase.getJSONValue((Object)pSSVNServerBase.getSlaveSvnUserName()), (boolean)false);
        }
        if (bl || pSSVNServerBase.getSlaveUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"slaveusername", (Object)PSSVNServerBase.getJSONValue((Object)pSSVNServerBase.getSlaveUserName()), (boolean)false);
        }
        if (bl || pSSVNServerBase.getSvnPassWd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"svnpasswd", (Object)PSSVNServerBase.getJSONValue((Object)pSSVNServerBase.getSvnPassWd()), (boolean)false);
        }
        if (bl || pSSVNServerBase.getSVNRoot() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"svnroot", (Object)PSSVNServerBase.getJSONValue((Object)pSSVNServerBase.getSVNRoot()), (boolean)false);
        }
        if (bl || pSSVNServerBase.getSVNType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"svntype", (Object)PSSVNServerBase.getJSONValue((Object)pSSVNServerBase.getSVNType()), (boolean)false);
        }
        if (bl || pSSVNServerBase.getSVNUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"svnurl", (Object)PSSVNServerBase.getJSONValue((Object)pSSVNServerBase.getSVNUrl()), (boolean)false);
        }
        if (bl || pSSVNServerBase.getSvnUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"svnusername", (Object)PSSVNServerBase.getJSONValue((Object)pSSVNServerBase.getSvnUserName()), (boolean)false);
        }
        if (bl || pSSVNServerBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSVNServerBase.getJSONValue((Object)pSSVNServerBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSVNServerBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSVNServerBase.getJSONValue((Object)pSSVNServerBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSVNServerBase.getUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"username", (Object)PSSVNServerBase.getJSONValue((Object)pSSVNServerBase.getUserName()), (boolean)false);
        }
        if (bl || pSSVNServerBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSVNServerBase.getJSONValue((Object)pSSVNServerBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSVNServerBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSVNServerBase.getJSONValue((Object)pSSVNServerBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSVNServerBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSVNServerBase.getJSONValue((Object)pSSVNServerBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSVNServerBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSVNServerBase.getJSONValue((Object)pSSVNServerBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSVNServerBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSVNServerBase.getJSONValue((Object)pSSVNServerBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSVNServerBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSVNServerBase pSSVNServerBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSVNServerBase.getAuthzCfg() != null) {
            object = pSSVNServerBase.getAuthzCfg();
            xmlNode.setAttribute(FIELD_AUTHZCFG, object == null ? "" : (String)object);
        }
        if (bl || pSSVNServerBase.getCreateDate() != null) {
            object = pSSVNServerBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSVNServerBase.getCreateMan() != null) {
            object = pSSVNServerBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSVNServerBase.getGitAdminPass() != null) {
            object = pSSVNServerBase.getGitAdminPass();
            xmlNode.setAttribute(FIELD_GITADMINPASS, object == null ? "" : (String)object);
        }
        if (bl || pSSVNServerBase.getGitAdminUser() != null) {
            object = pSSVNServerBase.getGitAdminUser();
            xmlNode.setAttribute(FIELD_GITADMINUSER, object == null ? "" : (String)object);
        }
        if (bl || pSSVNServerBase.getGITPassword() != null) {
            object = pSSVNServerBase.getGITPassword();
            xmlNode.setAttribute(FIELD_GITPASSWORD, object == null ? "" : (String)object);
        }
        if (bl || pSSVNServerBase.getGitPath() != null) {
            object = pSSVNServerBase.getGitPath();
            xmlNode.setAttribute(FIELD_GITPATH, object == null ? "" : (String)object);
        }
        if (bl || pSSVNServerBase.getGitPrj() != null) {
            object = pSSVNServerBase.getGitPrj();
            xmlNode.setAttribute(FIELD_GITPRJ, object == null ? "" : (String)object);
        }
        if (bl || pSSVNServerBase.getGitToken() != null) {
            object = pSSVNServerBase.getGitToken();
            xmlNode.setAttribute(FIELD_GITTOKEN, object == null ? "" : (String)object);
        }
        if (bl || pSSVNServerBase.getGITUserName() != null) {
            object = pSSVNServerBase.getGITUserName();
            xmlNode.setAttribute(FIELD_GITUSERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSVNServerBase.getIpAddr() != null) {
            object = pSSVNServerBase.getIpAddr();
            xmlNode.setAttribute(FIELD_IPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSSVNServerBase.getIpAddr2() != null) {
            object = pSSVNServerBase.getIpAddr2();
            xmlNode.setAttribute(FIELD_IPADDR2, object == null ? "" : (String)object);
        }
        if (bl || pSSVNServerBase.getMemo() != null) {
            object = pSSVNServerBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSVNServerBase.getPasswd() != null) {
            object = pSSVNServerBase.getPasswd();
            xmlNode.setAttribute(FIELD_PASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSSVNServerBase.getPort() != null) {
            object = pSSVNServerBase.getPort();
            xmlNode.setAttribute(FIELD_PORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSVNServerBase.getPSSVNServerId() != null) {
            object = pSSVNServerBase.getPSSVNServerId();
            xmlNode.setAttribute(FIELD_PSSVNSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSSVNServerBase.getPSSVNServerName() != null) {
            object = pSSVNServerBase.getPSSVNServerName();
            xmlNode.setAttribute(FIELD_PSSVNSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSVNServerBase.getPSSvrDomainId() != null) {
            object = pSSVNServerBase.getPSSvrDomainId();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINID, object == null ? "" : (String)object);
        }
        if (bl || pSSVNServerBase.getPSSvrDomainName() != null) {
            object = pSSVNServerBase.getPSSvrDomainName();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSVNServerBase.getSlaveIPADDR() != null) {
            object = pSSVNServerBase.getSlaveIPADDR();
            xmlNode.setAttribute(FIELD_SLAVEIPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSSVNServerBase.getSlaveIpAddr2() != null) {
            object = pSSVNServerBase.getSlaveIpAddr2();
            xmlNode.setAttribute(FIELD_SLAVEIPADDR2, object == null ? "" : (String)object);
        }
        if (bl || pSSVNServerBase.getSlavePasswd() != null) {
            object = pSSVNServerBase.getSlavePasswd();
            xmlNode.setAttribute(FIELD_SLAVEPASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSSVNServerBase.getSlavePort() != null) {
            object = pSSVNServerBase.getSlavePort();
            xmlNode.setAttribute(FIELD_SLAVEPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSVNServerBase.getSlaveSvnPassWd() != null) {
            object = pSSVNServerBase.getSlaveSvnPassWd();
            xmlNode.setAttribute(FIELD_SLAVESVNPASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSSVNServerBase.getSlaveSVNRoot() != null) {
            object = pSSVNServerBase.getSlaveSVNRoot();
            xmlNode.setAttribute(FIELD_SLAVESVNROOT, object == null ? "" : (String)object);
        }
        if (bl || pSSVNServerBase.getSlaveSVNUrl() != null) {
            object = pSSVNServerBase.getSlaveSVNUrl();
            xmlNode.setAttribute(FIELD_SLAVESVNURL, object == null ? "" : (String)object);
        }
        if (bl || pSSVNServerBase.getSlaveSvnUserName() != null) {
            object = pSSVNServerBase.getSlaveSvnUserName();
            xmlNode.setAttribute(FIELD_SLAVESVNUSERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSVNServerBase.getSlaveUserName() != null) {
            object = pSSVNServerBase.getSlaveUserName();
            xmlNode.setAttribute(FIELD_SLAVEUSERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSVNServerBase.getSvnPassWd() != null) {
            object = pSSVNServerBase.getSvnPassWd();
            xmlNode.setAttribute(FIELD_SVNPASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSSVNServerBase.getSVNRoot() != null) {
            object = pSSVNServerBase.getSVNRoot();
            xmlNode.setAttribute(FIELD_SVNROOT, object == null ? "" : (String)object);
        }
        if (bl || pSSVNServerBase.getSVNType() != null) {
            object = pSSVNServerBase.getSVNType();
            xmlNode.setAttribute(FIELD_SVNTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSVNServerBase.getSVNUrl() != null) {
            object = pSSVNServerBase.getSVNUrl();
            xmlNode.setAttribute(FIELD_SVNURL, object == null ? "" : (String)object);
        }
        if (bl || pSSVNServerBase.getSvnUserName() != null) {
            object = pSSVNServerBase.getSvnUserName();
            xmlNode.setAttribute(FIELD_SVNUSERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSVNServerBase.getUpdateDate() != null) {
            object = pSSVNServerBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSVNServerBase.getUpdateMan() != null) {
            object = pSSVNServerBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSVNServerBase.getUserName() != null) {
            object = pSSVNServerBase.getUserName();
            xmlNode.setAttribute(FIELD_USERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSVNServerBase.getUserTag() != null) {
            object = pSSVNServerBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSVNServerBase.getUserTag2() != null) {
            object = pSSVNServerBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSVNServerBase.getUserTag3() != null) {
            object = pSSVNServerBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSVNServerBase.getUserTag4() != null) {
            object = pSSVNServerBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSVNServerBase.getValidFlag() != null) {
            object = pSSVNServerBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSVNServerBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSVNServerBase pSSVNServerBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSVNServerBase.isAuthzCfgDirty() && (bl || pSSVNServerBase.getAuthzCfg() != null)) {
            iDataObject.set(FIELD_AUTHZCFG, (Object)pSSVNServerBase.getAuthzCfg());
        }
        if (pSSVNServerBase.isCreateDateDirty() && (bl || pSSVNServerBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSVNServerBase.getCreateDate());
        }
        if (pSSVNServerBase.isCreateManDirty() && (bl || pSSVNServerBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSVNServerBase.getCreateMan());
        }
        if (pSSVNServerBase.isGitAdminPassDirty() && (bl || pSSVNServerBase.getGitAdminPass() != null)) {
            iDataObject.set(FIELD_GITADMINPASS, (Object)pSSVNServerBase.getGitAdminPass());
        }
        if (pSSVNServerBase.isGitAdminUserDirty() && (bl || pSSVNServerBase.getGitAdminUser() != null)) {
            iDataObject.set(FIELD_GITADMINUSER, (Object)pSSVNServerBase.getGitAdminUser());
        }
        if (pSSVNServerBase.isGITPasswordDirty() && (bl || pSSVNServerBase.getGITPassword() != null)) {
            iDataObject.set(FIELD_GITPASSWORD, (Object)pSSVNServerBase.getGITPassword());
        }
        if (pSSVNServerBase.isGitPathDirty() && (bl || pSSVNServerBase.getGitPath() != null)) {
            iDataObject.set(FIELD_GITPATH, (Object)pSSVNServerBase.getGitPath());
        }
        if (pSSVNServerBase.isGitPrjDirty() && (bl || pSSVNServerBase.getGitPrj() != null)) {
            iDataObject.set(FIELD_GITPRJ, (Object)pSSVNServerBase.getGitPrj());
        }
        if (pSSVNServerBase.isGitTokenDirty() && (bl || pSSVNServerBase.getGitToken() != null)) {
            iDataObject.set(FIELD_GITTOKEN, (Object)pSSVNServerBase.getGitToken());
        }
        if (pSSVNServerBase.isGITUserNameDirty() && (bl || pSSVNServerBase.getGITUserName() != null)) {
            iDataObject.set(FIELD_GITUSERNAME, (Object)pSSVNServerBase.getGITUserName());
        }
        if (pSSVNServerBase.isIpAddrDirty() && (bl || pSSVNServerBase.getIpAddr() != null)) {
            iDataObject.set(FIELD_IPADDR, (Object)pSSVNServerBase.getIpAddr());
        }
        if (pSSVNServerBase.isIpAddr2Dirty() && (bl || pSSVNServerBase.getIpAddr2() != null)) {
            iDataObject.set(FIELD_IPADDR2, (Object)pSSVNServerBase.getIpAddr2());
        }
        if (pSSVNServerBase.isMemoDirty() && (bl || pSSVNServerBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSVNServerBase.getMemo());
        }
        if (pSSVNServerBase.isPasswdDirty() && (bl || pSSVNServerBase.getPasswd() != null)) {
            iDataObject.set(FIELD_PASSWD, (Object)pSSVNServerBase.getPasswd());
        }
        if (pSSVNServerBase.isPortDirty() && (bl || pSSVNServerBase.getPort() != null)) {
            iDataObject.set(FIELD_PORT, (Object)pSSVNServerBase.getPort());
        }
        if (pSSVNServerBase.isPSSVNServerIdDirty() && (bl || pSSVNServerBase.getPSSVNServerId() != null)) {
            iDataObject.set(FIELD_PSSVNSERVERID, (Object)pSSVNServerBase.getPSSVNServerId());
        }
        if (pSSVNServerBase.isPSSVNServerNameDirty() && (bl || pSSVNServerBase.getPSSVNServerName() != null)) {
            iDataObject.set(FIELD_PSSVNSERVERNAME, (Object)pSSVNServerBase.getPSSVNServerName());
        }
        if (pSSVNServerBase.isPSSvrDomainIdDirty() && (bl || pSSVNServerBase.getPSSvrDomainId() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINID, (Object)pSSVNServerBase.getPSSvrDomainId());
        }
        if (pSSVNServerBase.isPSSvrDomainNameDirty() && (bl || pSSVNServerBase.getPSSvrDomainName() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINNAME, (Object)pSSVNServerBase.getPSSvrDomainName());
        }
        if (pSSVNServerBase.isSlaveIPADDRDirty() && (bl || pSSVNServerBase.getSlaveIPADDR() != null)) {
            iDataObject.set(FIELD_SLAVEIPADDR, (Object)pSSVNServerBase.getSlaveIPADDR());
        }
        if (pSSVNServerBase.isSlaveIpAddr2Dirty() && (bl || pSSVNServerBase.getSlaveIpAddr2() != null)) {
            iDataObject.set(FIELD_SLAVEIPADDR2, (Object)pSSVNServerBase.getSlaveIpAddr2());
        }
        if (pSSVNServerBase.isSlavePasswdDirty() && (bl || pSSVNServerBase.getSlavePasswd() != null)) {
            iDataObject.set(FIELD_SLAVEPASSWD, (Object)pSSVNServerBase.getSlavePasswd());
        }
        if (pSSVNServerBase.isSlavePortDirty() && (bl || pSSVNServerBase.getSlavePort() != null)) {
            iDataObject.set(FIELD_SLAVEPORT, (Object)pSSVNServerBase.getSlavePort());
        }
        if (pSSVNServerBase.isSlaveSvnPassWdDirty() && (bl || pSSVNServerBase.getSlaveSvnPassWd() != null)) {
            iDataObject.set(FIELD_SLAVESVNPASSWD, (Object)pSSVNServerBase.getSlaveSvnPassWd());
        }
        if (pSSVNServerBase.isSlaveSVNRootDirty() && (bl || pSSVNServerBase.getSlaveSVNRoot() != null)) {
            iDataObject.set(FIELD_SLAVESVNROOT, (Object)pSSVNServerBase.getSlaveSVNRoot());
        }
        if (pSSVNServerBase.isSlaveSVNUrlDirty() && (bl || pSSVNServerBase.getSlaveSVNUrl() != null)) {
            iDataObject.set(FIELD_SLAVESVNURL, (Object)pSSVNServerBase.getSlaveSVNUrl());
        }
        if (pSSVNServerBase.isSlaveSvnUserNameDirty() && (bl || pSSVNServerBase.getSlaveSvnUserName() != null)) {
            iDataObject.set(FIELD_SLAVESVNUSERNAME, (Object)pSSVNServerBase.getSlaveSvnUserName());
        }
        if (pSSVNServerBase.isSlaveUserNameDirty() && (bl || pSSVNServerBase.getSlaveUserName() != null)) {
            iDataObject.set(FIELD_SLAVEUSERNAME, (Object)pSSVNServerBase.getSlaveUserName());
        }
        if (pSSVNServerBase.isSvnPassWdDirty() && (bl || pSSVNServerBase.getSvnPassWd() != null)) {
            iDataObject.set(FIELD_SVNPASSWD, (Object)pSSVNServerBase.getSvnPassWd());
        }
        if (pSSVNServerBase.isSVNRootDirty() && (bl || pSSVNServerBase.getSVNRoot() != null)) {
            iDataObject.set(FIELD_SVNROOT, (Object)pSSVNServerBase.getSVNRoot());
        }
        if (pSSVNServerBase.isSVNTypeDirty() && (bl || pSSVNServerBase.getSVNType() != null)) {
            iDataObject.set(FIELD_SVNTYPE, (Object)pSSVNServerBase.getSVNType());
        }
        if (pSSVNServerBase.isSVNUrlDirty() && (bl || pSSVNServerBase.getSVNUrl() != null)) {
            iDataObject.set(FIELD_SVNURL, (Object)pSSVNServerBase.getSVNUrl());
        }
        if (pSSVNServerBase.isSvnUserNameDirty() && (bl || pSSVNServerBase.getSvnUserName() != null)) {
            iDataObject.set(FIELD_SVNUSERNAME, (Object)pSSVNServerBase.getSvnUserName());
        }
        if (pSSVNServerBase.isUpdateDateDirty() && (bl || pSSVNServerBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSVNServerBase.getUpdateDate());
        }
        if (pSSVNServerBase.isUpdateManDirty() && (bl || pSSVNServerBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSVNServerBase.getUpdateMan());
        }
        if (pSSVNServerBase.isUserNameDirty() && (bl || pSSVNServerBase.getUserName() != null)) {
            iDataObject.set(FIELD_USERNAME, (Object)pSSVNServerBase.getUserName());
        }
        if (pSSVNServerBase.isUserTagDirty() && (bl || pSSVNServerBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSVNServerBase.getUserTag());
        }
        if (pSSVNServerBase.isUserTag2Dirty() && (bl || pSSVNServerBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSVNServerBase.getUserTag2());
        }
        if (pSSVNServerBase.isUserTag3Dirty() && (bl || pSSVNServerBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSVNServerBase.getUserTag3());
        }
        if (pSSVNServerBase.isUserTag4Dirty() && (bl || pSSVNServerBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSVNServerBase.getUserTag4());
        }
        if (pSSVNServerBase.isValidFlagDirty() && (bl || pSSVNServerBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSVNServerBase.getValidFlag());
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
        return PSSVNServerBase.remove(this, n);
    }

    private static boolean remove(PSSVNServerBase pSSVNServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSVNServerBase.resetAuthzCfg();
                return true;
            }
            case 1: {
                pSSVNServerBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSVNServerBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSVNServerBase.resetGitAdminPass();
                return true;
            }
            case 4: {
                pSSVNServerBase.resetGitAdminUser();
                return true;
            }
            case 5: {
                pSSVNServerBase.resetGITPassword();
                return true;
            }
            case 6: {
                pSSVNServerBase.resetGitPath();
                return true;
            }
            case 7: {
                pSSVNServerBase.resetGitPrj();
                return true;
            }
            case 8: {
                pSSVNServerBase.resetGitToken();
                return true;
            }
            case 9: {
                pSSVNServerBase.resetGITUserName();
                return true;
            }
            case 10: {
                pSSVNServerBase.resetIpAddr();
                return true;
            }
            case 11: {
                pSSVNServerBase.resetIpAddr2();
                return true;
            }
            case 12: {
                pSSVNServerBase.resetMemo();
                return true;
            }
            case 13: {
                pSSVNServerBase.resetPasswd();
                return true;
            }
            case 14: {
                pSSVNServerBase.resetPort();
                return true;
            }
            case 15: {
                pSSVNServerBase.resetPSSVNServerId();
                return true;
            }
            case 16: {
                pSSVNServerBase.resetPSSVNServerName();
                return true;
            }
            case 17: {
                pSSVNServerBase.resetPSSvrDomainId();
                return true;
            }
            case 18: {
                pSSVNServerBase.resetPSSvrDomainName();
                return true;
            }
            case 19: {
                pSSVNServerBase.resetSlaveIPADDR();
                return true;
            }
            case 20: {
                pSSVNServerBase.resetSlaveIpAddr2();
                return true;
            }
            case 21: {
                pSSVNServerBase.resetSlavePasswd();
                return true;
            }
            case 22: {
                pSSVNServerBase.resetSlavePort();
                return true;
            }
            case 23: {
                pSSVNServerBase.resetSlaveSvnPassWd();
                return true;
            }
            case 24: {
                pSSVNServerBase.resetSlaveSVNRoot();
                return true;
            }
            case 25: {
                pSSVNServerBase.resetSlaveSVNUrl();
                return true;
            }
            case 26: {
                pSSVNServerBase.resetSlaveSvnUserName();
                return true;
            }
            case 27: {
                pSSVNServerBase.resetSlaveUserName();
                return true;
            }
            case 28: {
                pSSVNServerBase.resetSvnPassWd();
                return true;
            }
            case 29: {
                pSSVNServerBase.resetSVNRoot();
                return true;
            }
            case 30: {
                pSSVNServerBase.resetSVNType();
                return true;
            }
            case 31: {
                pSSVNServerBase.resetSVNUrl();
                return true;
            }
            case 32: {
                pSSVNServerBase.resetSvnUserName();
                return true;
            }
            case 33: {
                pSSVNServerBase.resetUpdateDate();
                return true;
            }
            case 34: {
                pSSVNServerBase.resetUpdateMan();
                return true;
            }
            case 35: {
                pSSVNServerBase.resetUserName();
                return true;
            }
            case 36: {
                pSSVNServerBase.resetUserTag();
                return true;
            }
            case 37: {
                pSSVNServerBase.resetUserTag2();
                return true;
            }
            case 38: {
                pSSVNServerBase.resetUserTag3();
                return true;
            }
            case 39: {
                pSSVNServerBase.resetUserTag4();
                return true;
            }
            case 40: {
                pSSVNServerBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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

    private PSSVNServerBase getProxyEntity() {
        return this.proxyPSSVNServerBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSVNServerBase = null;
        if (iDataObject != null && iDataObject instanceof PSSVNServerBase) {
            this.proxyPSSVNServerBase = (PSSVNServerBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSSVNServerService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_AUTHZCFG, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_GITADMINPASS, 3);
        fieldIndexMap.put(FIELD_GITADMINUSER, 4);
        fieldIndexMap.put(FIELD_GITPASSWORD, 5);
        fieldIndexMap.put(FIELD_GITPATH, 6);
        fieldIndexMap.put(FIELD_GITPRJ, 7);
        fieldIndexMap.put(FIELD_GITTOKEN, 8);
        fieldIndexMap.put(FIELD_GITUSERNAME, 9);
        fieldIndexMap.put(FIELD_IPADDR, 10);
        fieldIndexMap.put(FIELD_IPADDR2, 11);
        fieldIndexMap.put(FIELD_MEMO, 12);
        fieldIndexMap.put(FIELD_PASSWD, 13);
        fieldIndexMap.put(FIELD_PORT, 14);
        fieldIndexMap.put(FIELD_PSSVNSERVERID, 15);
        fieldIndexMap.put(FIELD_PSSVNSERVERNAME, 16);
        fieldIndexMap.put(FIELD_PSSVRDOMAINID, 17);
        fieldIndexMap.put(FIELD_PSSVRDOMAINNAME, 18);
        fieldIndexMap.put(FIELD_SLAVEIPADDR, 19);
        fieldIndexMap.put(FIELD_SLAVEIPADDR2, 20);
        fieldIndexMap.put(FIELD_SLAVEPASSWD, 21);
        fieldIndexMap.put(FIELD_SLAVEPORT, 22);
        fieldIndexMap.put(FIELD_SLAVESVNPASSWD, 23);
        fieldIndexMap.put(FIELD_SLAVESVNROOT, 24);
        fieldIndexMap.put(FIELD_SLAVESVNURL, 25);
        fieldIndexMap.put(FIELD_SLAVESVNUSERNAME, 26);
        fieldIndexMap.put(FIELD_SLAVEUSERNAME, 27);
        fieldIndexMap.put(FIELD_SVNPASSWD, 28);
        fieldIndexMap.put(FIELD_SVNROOT, 29);
        fieldIndexMap.put(FIELD_SVNTYPE, 30);
        fieldIndexMap.put(FIELD_SVNURL, 31);
        fieldIndexMap.put(FIELD_SVNUSERNAME, 32);
        fieldIndexMap.put(FIELD_UPDATEDATE, 33);
        fieldIndexMap.put(FIELD_UPDATEMAN, 34);
        fieldIndexMap.put(FIELD_USERNAME, 35);
        fieldIndexMap.put(FIELD_USERTAG, 36);
        fieldIndexMap.put(FIELD_USERTAG2, 37);
        fieldIndexMap.put(FIELD_USERTAG3, 38);
        fieldIndexMap.put(FIELD_USERTAG4, 39);
        fieldIndexMap.put(FIELD_VALIDFLAG, 40);
    }
}

