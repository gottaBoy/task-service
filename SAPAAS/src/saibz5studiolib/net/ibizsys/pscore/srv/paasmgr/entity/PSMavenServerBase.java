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

public abstract class PSMavenServerBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSMavenServerBase.class);
    public static final String FIELD_APIPATH = "APIPATH";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_IPADDR = "IPADDR";
    public static final String FIELD_IPADDR2 = "IPADDR2";
    public static final String FIELD_MAVENPASSWD = "MAVENPASSWD";
    public static final String FIELD_MAVENSERVERTYPE = "MAVENSERVERTYPE";
    public static final String FIELD_MAVENURL = "MAVENURL";
    public static final String FIELD_MAVENUSERNAME = "MAVENUSERNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PASSWD = "PASSWD";
    public static final String FIELD_PORT = "PORT";
    public static final String FIELD_PSMAVENSERVERID = "PSMAVENSERVERID";
    public static final String FIELD_PSMAVENSERVERNAME = "PSMAVENSERVERNAME";
    public static final String FIELD_PSSVRDOMAINID = "PSSVRDOMAINID";
    public static final String FIELD_PSSVRDOMAINNAME = "PSSVRDOMAINNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERNAME = "USERNAME";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_APIPATH = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_IPADDR = 3;
    private static final int INDEX_IPADDR2 = 4;
    private static final int INDEX_MAVENPASSWD = 5;
    private static final int INDEX_MAVENSERVERTYPE = 6;
    private static final int INDEX_MAVENURL = 7;
    private static final int INDEX_MAVENUSERNAME = 8;
    private static final int INDEX_MEMO = 9;
    private static final int INDEX_PASSWD = 10;
    private static final int INDEX_PORT = 11;
    private static final int INDEX_PSMAVENSERVERID = 12;
    private static final int INDEX_PSMAVENSERVERNAME = 13;
    private static final int INDEX_PSSVRDOMAINID = 14;
    private static final int INDEX_PSSVRDOMAINNAME = 15;
    private static final int INDEX_UPDATEDATE = 16;
    private static final int INDEX_UPDATEMAN = 17;
    private static final int INDEX_USERNAME = 18;
    private static final int INDEX_VALIDFLAG = 19;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSMavenServerBase proxyPSMavenServerBase = null;
    private boolean apipathDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean ipaddrDirtyFlag = false;
    private boolean ipaddr2DirtyFlag = false;
    private boolean mavenpasswdDirtyFlag = false;
    private boolean mavenservertypeDirtyFlag = false;
    private boolean mavenurlDirtyFlag = false;
    private boolean mavenusernameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean passwdDirtyFlag = false;
    private boolean portDirtyFlag = false;
    private boolean psmavenserveridDirtyFlag = false;
    private boolean psmavenservernameDirtyFlag = false;
    private boolean pssvrdomainidDirtyFlag = false;
    private boolean pssvrdomainnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usernameDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="apipath")
    private String apipath;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="ipaddr")
    private String ipaddr;
    @Column(name="ipaddr2")
    private String ipaddr2;
    @Column(name="mavenpasswd")
    private String mavenpasswd;
    @Column(name="mavenservertype")
    private String mavenservertype;
    @Column(name="mavenurl")
    private String mavenurl;
    @Column(name="mavenusername")
    private String mavenusername;
    @Column(name="memo")
    private String memo;
    @Column(name="passwd")
    private String passwd;
    @Column(name="port")
    private Integer port;
    @Column(name="psmavenserverid")
    private String psmavenserverid;
    @Column(name="psmavenservername")
    private String psmavenservername;
    @Column(name="pssvrdomainid")
    private String pssvrdomainid;
    @Column(name="pssvrdomainname")
    private String pssvrdomainname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="username")
    private String username;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSSvrDomainLock = new Integer(1);
    private PSSvrDomain pssvrdomain = null;

    public void setAPIPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAPIPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.apipath = string;
        this.apipathDirtyFlag = true;
    }

    public String getAPIPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAPIPath();
        }
        return this.apipath;
    }

    public boolean isAPIPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAPIPathDirty();
        }
        return this.apipathDirtyFlag;
    }

    public void resetAPIPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAPIPath();
            return;
        }
        this.apipathDirtyFlag = false;
        this.apipath = null;
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

    public void setMavenPasswd(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMavenPasswd(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mavenpasswd = string;
        this.mavenpasswdDirtyFlag = true;
    }

    public String getMavenPasswd() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMavenPasswd();
        }
        return this.mavenpasswd;
    }

    public boolean isMavenPasswdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMavenPasswdDirty();
        }
        return this.mavenpasswdDirtyFlag;
    }

    public void resetMavenPasswd() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMavenPasswd();
            return;
        }
        this.mavenpasswdDirtyFlag = false;
        this.mavenpasswd = null;
    }

    public void setMavenServerType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMavenServerType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mavenservertype = string;
        this.mavenservertypeDirtyFlag = true;
    }

    public String getMavenServerType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMavenServerType();
        }
        return this.mavenservertype;
    }

    public boolean isMavenServerTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMavenServerTypeDirty();
        }
        return this.mavenservertypeDirtyFlag;
    }

    public void resetMavenServerType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMavenServerType();
            return;
        }
        this.mavenservertypeDirtyFlag = false;
        this.mavenservertype = null;
    }

    public void setMavenUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMavenUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mavenurl = string;
        this.mavenurlDirtyFlag = true;
    }

    public String getMavenUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMavenUrl();
        }
        return this.mavenurl;
    }

    public boolean isMavenUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMavenUrlDirty();
        }
        return this.mavenurlDirtyFlag;
    }

    public void resetMavenUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMavenUrl();
            return;
        }
        this.mavenurlDirtyFlag = false;
        this.mavenurl = null;
    }

    public void setMavenUserName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMavenUserName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mavenusername = string;
        this.mavenusernameDirtyFlag = true;
    }

    public String getMavenUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMavenUserName();
        }
        return this.mavenusername;
    }

    public boolean isMavenUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMavenUserNameDirty();
        }
        return this.mavenusernameDirtyFlag;
    }

    public void resetMavenUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMavenUserName();
            return;
        }
        this.mavenusernameDirtyFlag = false;
        this.mavenusername = null;
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

    public void setPSMavenServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSMavenServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmavenserverid = string;
        this.psmavenserveridDirtyFlag = true;
    }

    public String getPSMavenServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMavenServerId();
        }
        return this.psmavenserverid;
    }

    public boolean isPSMavenServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSMavenServerIdDirty();
        }
        return this.psmavenserveridDirtyFlag;
    }

    public void resetPSMavenServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSMavenServerId();
            return;
        }
        this.psmavenserveridDirtyFlag = false;
        this.psmavenserverid = null;
    }

    public void setPSMavenServerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSMavenServerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmavenservername = string;
        this.psmavenservernameDirtyFlag = true;
    }

    public String getPSMavenServerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMavenServerName();
        }
        return this.psmavenservername;
    }

    public boolean isPSMavenServerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSMavenServerNameDirty();
        }
        return this.psmavenservernameDirtyFlag;
    }

    public void resetPSMavenServerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSMavenServerName();
            return;
        }
        this.psmavenservernameDirtyFlag = false;
        this.psmavenservername = null;
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
        PSMavenServerBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSMavenServerBase pSMavenServerBase) {
        pSMavenServerBase.resetAPIPath();
        pSMavenServerBase.resetCreateDate();
        pSMavenServerBase.resetCreateMan();
        pSMavenServerBase.resetIpAddr();
        pSMavenServerBase.resetIpAddr2();
        pSMavenServerBase.resetMavenPasswd();
        pSMavenServerBase.resetMavenServerType();
        pSMavenServerBase.resetMavenUrl();
        pSMavenServerBase.resetMavenUserName();
        pSMavenServerBase.resetMemo();
        pSMavenServerBase.resetPasswd();
        pSMavenServerBase.resetPort();
        pSMavenServerBase.resetPSMavenServerId();
        pSMavenServerBase.resetPSMavenServerName();
        pSMavenServerBase.resetPSSvrDomainId();
        pSMavenServerBase.resetPSSvrDomainName();
        pSMavenServerBase.resetUpdateDate();
        pSMavenServerBase.resetUpdateMan();
        pSMavenServerBase.resetUserName();
        pSMavenServerBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAPIPathDirty()) {
            hashMap.put(FIELD_APIPATH, this.getAPIPath());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isIpAddrDirty()) {
            hashMap.put(FIELD_IPADDR, this.getIpAddr());
        }
        if (!bl || this.isIpAddr2Dirty()) {
            hashMap.put(FIELD_IPADDR2, this.getIpAddr2());
        }
        if (!bl || this.isMavenPasswdDirty()) {
            hashMap.put(FIELD_MAVENPASSWD, this.getMavenPasswd());
        }
        if (!bl || this.isMavenServerTypeDirty()) {
            hashMap.put(FIELD_MAVENSERVERTYPE, this.getMavenServerType());
        }
        if (!bl || this.isMavenUrlDirty()) {
            hashMap.put(FIELD_MAVENURL, this.getMavenUrl());
        }
        if (!bl || this.isMavenUserNameDirty()) {
            hashMap.put(FIELD_MAVENUSERNAME, this.getMavenUserName());
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
        if (!bl || this.isPSMavenServerIdDirty()) {
            hashMap.put(FIELD_PSMAVENSERVERID, this.getPSMavenServerId());
        }
        if (!bl || this.isPSMavenServerNameDirty()) {
            hashMap.put(FIELD_PSMAVENSERVERNAME, this.getPSMavenServerName());
        }
        if (!bl || this.isPSSvrDomainIdDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINID, this.getPSSvrDomainId());
        }
        if (!bl || this.isPSSvrDomainNameDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINNAME, this.getPSSvrDomainName());
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
        return PSMavenServerBase.get(this, n);
    }

    private static Object get(PSMavenServerBase pSMavenServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSMavenServerBase.getAPIPath();
            }
            case 1: {
                return pSMavenServerBase.getCreateDate();
            }
            case 2: {
                return pSMavenServerBase.getCreateMan();
            }
            case 3: {
                return pSMavenServerBase.getIpAddr();
            }
            case 4: {
                return pSMavenServerBase.getIpAddr2();
            }
            case 5: {
                return pSMavenServerBase.getMavenPasswd();
            }
            case 6: {
                return pSMavenServerBase.getMavenServerType();
            }
            case 7: {
                return pSMavenServerBase.getMavenUrl();
            }
            case 8: {
                return pSMavenServerBase.getMavenUserName();
            }
            case 9: {
                return pSMavenServerBase.getMemo();
            }
            case 10: {
                return pSMavenServerBase.getPasswd();
            }
            case 11: {
                return pSMavenServerBase.getPort();
            }
            case 12: {
                return pSMavenServerBase.getPSMavenServerId();
            }
            case 13: {
                return pSMavenServerBase.getPSMavenServerName();
            }
            case 14: {
                return pSMavenServerBase.getPSSvrDomainId();
            }
            case 15: {
                return pSMavenServerBase.getPSSvrDomainName();
            }
            case 16: {
                return pSMavenServerBase.getUpdateDate();
            }
            case 17: {
                return pSMavenServerBase.getUpdateMan();
            }
            case 18: {
                return pSMavenServerBase.getUserName();
            }
            case 19: {
                return pSMavenServerBase.getValidFlag();
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
        PSMavenServerBase.set(this, n, object);
    }

    private static void set(PSMavenServerBase pSMavenServerBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSMavenServerBase.setAPIPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSMavenServerBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSMavenServerBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSMavenServerBase.setIpAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSMavenServerBase.setIpAddr2(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSMavenServerBase.setMavenPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSMavenServerBase.setMavenServerType(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSMavenServerBase.setMavenUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSMavenServerBase.setMavenUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSMavenServerBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSMavenServerBase.setPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSMavenServerBase.setPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSMavenServerBase.setPSMavenServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSMavenServerBase.setPSMavenServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSMavenServerBase.setPSSvrDomainId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSMavenServerBase.setPSSvrDomainName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSMavenServerBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 17: {
                pSMavenServerBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSMavenServerBase.setUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSMavenServerBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSMavenServerBase.isNull(this, n);
    }

    private static boolean isNull(PSMavenServerBase pSMavenServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSMavenServerBase.getAPIPath() == null;
            }
            case 1: {
                return pSMavenServerBase.getCreateDate() == null;
            }
            case 2: {
                return pSMavenServerBase.getCreateMan() == null;
            }
            case 3: {
                return pSMavenServerBase.getIpAddr() == null;
            }
            case 4: {
                return pSMavenServerBase.getIpAddr2() == null;
            }
            case 5: {
                return pSMavenServerBase.getMavenPasswd() == null;
            }
            case 6: {
                return pSMavenServerBase.getMavenServerType() == null;
            }
            case 7: {
                return pSMavenServerBase.getMavenUrl() == null;
            }
            case 8: {
                return pSMavenServerBase.getMavenUserName() == null;
            }
            case 9: {
                return pSMavenServerBase.getMemo() == null;
            }
            case 10: {
                return pSMavenServerBase.getPasswd() == null;
            }
            case 11: {
                return pSMavenServerBase.getPort() == null;
            }
            case 12: {
                return pSMavenServerBase.getPSMavenServerId() == null;
            }
            case 13: {
                return pSMavenServerBase.getPSMavenServerName() == null;
            }
            case 14: {
                return pSMavenServerBase.getPSSvrDomainId() == null;
            }
            case 15: {
                return pSMavenServerBase.getPSSvrDomainName() == null;
            }
            case 16: {
                return pSMavenServerBase.getUpdateDate() == null;
            }
            case 17: {
                return pSMavenServerBase.getUpdateMan() == null;
            }
            case 18: {
                return pSMavenServerBase.getUserName() == null;
            }
            case 19: {
                return pSMavenServerBase.getValidFlag() == null;
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
        return PSMavenServerBase.contains(this, n);
    }

    private static boolean contains(PSMavenServerBase pSMavenServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSMavenServerBase.isAPIPathDirty();
            }
            case 1: {
                return pSMavenServerBase.isCreateDateDirty();
            }
            case 2: {
                return pSMavenServerBase.isCreateManDirty();
            }
            case 3: {
                return pSMavenServerBase.isIpAddrDirty();
            }
            case 4: {
                return pSMavenServerBase.isIpAddr2Dirty();
            }
            case 5: {
                return pSMavenServerBase.isMavenPasswdDirty();
            }
            case 6: {
                return pSMavenServerBase.isMavenServerTypeDirty();
            }
            case 7: {
                return pSMavenServerBase.isMavenUrlDirty();
            }
            case 8: {
                return pSMavenServerBase.isMavenUserNameDirty();
            }
            case 9: {
                return pSMavenServerBase.isMemoDirty();
            }
            case 10: {
                return pSMavenServerBase.isPasswdDirty();
            }
            case 11: {
                return pSMavenServerBase.isPortDirty();
            }
            case 12: {
                return pSMavenServerBase.isPSMavenServerIdDirty();
            }
            case 13: {
                return pSMavenServerBase.isPSMavenServerNameDirty();
            }
            case 14: {
                return pSMavenServerBase.isPSSvrDomainIdDirty();
            }
            case 15: {
                return pSMavenServerBase.isPSSvrDomainNameDirty();
            }
            case 16: {
                return pSMavenServerBase.isUpdateDateDirty();
            }
            case 17: {
                return pSMavenServerBase.isUpdateManDirty();
            }
            case 18: {
                return pSMavenServerBase.isUserNameDirty();
            }
            case 19: {
                return pSMavenServerBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSMavenServerBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSMavenServerBase pSMavenServerBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSMavenServerBase.getAPIPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"apipath", (Object)PSMavenServerBase.getJSONValue((Object)pSMavenServerBase.getAPIPath()), (boolean)false);
        }
        if (bl || pSMavenServerBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSMavenServerBase.getJSONValue((Object)pSMavenServerBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSMavenServerBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSMavenServerBase.getJSONValue((Object)pSMavenServerBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSMavenServerBase.getIpAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr", (Object)PSMavenServerBase.getJSONValue((Object)pSMavenServerBase.getIpAddr()), (boolean)false);
        }
        if (bl || pSMavenServerBase.getIpAddr2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr2", (Object)PSMavenServerBase.getJSONValue((Object)pSMavenServerBase.getIpAddr2()), (boolean)false);
        }
        if (bl || pSMavenServerBase.getMavenPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mavenpasswd", (Object)PSMavenServerBase.getJSONValue((Object)pSMavenServerBase.getMavenPasswd()), (boolean)false);
        }
        if (bl || pSMavenServerBase.getMavenServerType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mavenservertype", (Object)PSMavenServerBase.getJSONValue((Object)pSMavenServerBase.getMavenServerType()), (boolean)false);
        }
        if (bl || pSMavenServerBase.getMavenUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mavenurl", (Object)PSMavenServerBase.getJSONValue((Object)pSMavenServerBase.getMavenUrl()), (boolean)false);
        }
        if (bl || pSMavenServerBase.getMavenUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mavenusername", (Object)PSMavenServerBase.getJSONValue((Object)pSMavenServerBase.getMavenUserName()), (boolean)false);
        }
        if (bl || pSMavenServerBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSMavenServerBase.getJSONValue((Object)pSMavenServerBase.getMemo()), (boolean)false);
        }
        if (bl || pSMavenServerBase.getPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"passwd", (Object)PSMavenServerBase.getJSONValue((Object)pSMavenServerBase.getPasswd()), (boolean)false);
        }
        if (bl || pSMavenServerBase.getPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"port", (Object)PSMavenServerBase.getJSONValue((Object)pSMavenServerBase.getPort()), (boolean)false);
        }
        if (bl || pSMavenServerBase.getPSMavenServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmavenserverid", (Object)PSMavenServerBase.getJSONValue((Object)pSMavenServerBase.getPSMavenServerId()), (boolean)false);
        }
        if (bl || pSMavenServerBase.getPSMavenServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmavenservername", (Object)PSMavenServerBase.getJSONValue((Object)pSMavenServerBase.getPSMavenServerName()), (boolean)false);
        }
        if (bl || pSMavenServerBase.getPSSvrDomainId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainid", (Object)PSMavenServerBase.getJSONValue((Object)pSMavenServerBase.getPSSvrDomainId()), (boolean)false);
        }
        if (bl || pSMavenServerBase.getPSSvrDomainName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainname", (Object)PSMavenServerBase.getJSONValue((Object)pSMavenServerBase.getPSSvrDomainName()), (boolean)false);
        }
        if (bl || pSMavenServerBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSMavenServerBase.getJSONValue((Object)pSMavenServerBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSMavenServerBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSMavenServerBase.getJSONValue((Object)pSMavenServerBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSMavenServerBase.getUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"username", (Object)PSMavenServerBase.getJSONValue((Object)pSMavenServerBase.getUserName()), (boolean)false);
        }
        if (bl || pSMavenServerBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSMavenServerBase.getJSONValue((Object)pSMavenServerBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSMavenServerBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSMavenServerBase pSMavenServerBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSMavenServerBase.getAPIPath() != null) {
            object = pSMavenServerBase.getAPIPath();
            xmlNode.setAttribute(FIELD_APIPATH, object == null ? "" : (String)object);
        }
        if (bl || pSMavenServerBase.getCreateDate() != null) {
            object = pSMavenServerBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSMavenServerBase.getCreateMan() != null) {
            object = pSMavenServerBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSMavenServerBase.getIpAddr() != null) {
            object = pSMavenServerBase.getIpAddr();
            xmlNode.setAttribute(FIELD_IPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSMavenServerBase.getIpAddr2() != null) {
            object = pSMavenServerBase.getIpAddr2();
            xmlNode.setAttribute(FIELD_IPADDR2, object == null ? "" : (String)object);
        }
        if (bl || pSMavenServerBase.getMavenPasswd() != null) {
            object = pSMavenServerBase.getMavenPasswd();
            xmlNode.setAttribute(FIELD_MAVENPASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSMavenServerBase.getMavenServerType() != null) {
            object = pSMavenServerBase.getMavenServerType();
            xmlNode.setAttribute(FIELD_MAVENSERVERTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSMavenServerBase.getMavenUrl() != null) {
            object = pSMavenServerBase.getMavenUrl();
            xmlNode.setAttribute(FIELD_MAVENURL, object == null ? "" : (String)object);
        }
        if (bl || pSMavenServerBase.getMavenUserName() != null) {
            object = pSMavenServerBase.getMavenUserName();
            xmlNode.setAttribute(FIELD_MAVENUSERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSMavenServerBase.getMemo() != null) {
            object = pSMavenServerBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSMavenServerBase.getPasswd() != null) {
            object = pSMavenServerBase.getPasswd();
            xmlNode.setAttribute(FIELD_PASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSMavenServerBase.getPort() != null) {
            object = pSMavenServerBase.getPort();
            xmlNode.setAttribute(FIELD_PORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSMavenServerBase.getPSMavenServerId() != null) {
            object = pSMavenServerBase.getPSMavenServerId();
            xmlNode.setAttribute(FIELD_PSMAVENSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSMavenServerBase.getPSMavenServerName() != null) {
            object = pSMavenServerBase.getPSMavenServerName();
            xmlNode.setAttribute(FIELD_PSMAVENSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSMavenServerBase.getPSSvrDomainId() != null) {
            object = pSMavenServerBase.getPSSvrDomainId();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINID, object == null ? "" : (String)object);
        }
        if (bl || pSMavenServerBase.getPSSvrDomainName() != null) {
            object = pSMavenServerBase.getPSSvrDomainName();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSMavenServerBase.getUpdateDate() != null) {
            object = pSMavenServerBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSMavenServerBase.getUpdateMan() != null) {
            object = pSMavenServerBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSMavenServerBase.getUserName() != null) {
            object = pSMavenServerBase.getUserName();
            xmlNode.setAttribute(FIELD_USERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSMavenServerBase.getValidFlag() != null) {
            object = pSMavenServerBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSMavenServerBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSMavenServerBase pSMavenServerBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSMavenServerBase.isAPIPathDirty() && (bl || pSMavenServerBase.getAPIPath() != null)) {
            iDataObject.set(FIELD_APIPATH, (Object)pSMavenServerBase.getAPIPath());
        }
        if (pSMavenServerBase.isCreateDateDirty() && (bl || pSMavenServerBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSMavenServerBase.getCreateDate());
        }
        if (pSMavenServerBase.isCreateManDirty() && (bl || pSMavenServerBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSMavenServerBase.getCreateMan());
        }
        if (pSMavenServerBase.isIpAddrDirty() && (bl || pSMavenServerBase.getIpAddr() != null)) {
            iDataObject.set(FIELD_IPADDR, (Object)pSMavenServerBase.getIpAddr());
        }
        if (pSMavenServerBase.isIpAddr2Dirty() && (bl || pSMavenServerBase.getIpAddr2() != null)) {
            iDataObject.set(FIELD_IPADDR2, (Object)pSMavenServerBase.getIpAddr2());
        }
        if (pSMavenServerBase.isMavenPasswdDirty() && (bl || pSMavenServerBase.getMavenPasswd() != null)) {
            iDataObject.set(FIELD_MAVENPASSWD, (Object)pSMavenServerBase.getMavenPasswd());
        }
        if (pSMavenServerBase.isMavenServerTypeDirty() && (bl || pSMavenServerBase.getMavenServerType() != null)) {
            iDataObject.set(FIELD_MAVENSERVERTYPE, (Object)pSMavenServerBase.getMavenServerType());
        }
        if (pSMavenServerBase.isMavenUrlDirty() && (bl || pSMavenServerBase.getMavenUrl() != null)) {
            iDataObject.set(FIELD_MAVENURL, (Object)pSMavenServerBase.getMavenUrl());
        }
        if (pSMavenServerBase.isMavenUserNameDirty() && (bl || pSMavenServerBase.getMavenUserName() != null)) {
            iDataObject.set(FIELD_MAVENUSERNAME, (Object)pSMavenServerBase.getMavenUserName());
        }
        if (pSMavenServerBase.isMemoDirty() && (bl || pSMavenServerBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSMavenServerBase.getMemo());
        }
        if (pSMavenServerBase.isPasswdDirty() && (bl || pSMavenServerBase.getPasswd() != null)) {
            iDataObject.set(FIELD_PASSWD, (Object)pSMavenServerBase.getPasswd());
        }
        if (pSMavenServerBase.isPortDirty() && (bl || pSMavenServerBase.getPort() != null)) {
            iDataObject.set(FIELD_PORT, (Object)pSMavenServerBase.getPort());
        }
        if (pSMavenServerBase.isPSMavenServerIdDirty() && (bl || pSMavenServerBase.getPSMavenServerId() != null)) {
            iDataObject.set(FIELD_PSMAVENSERVERID, (Object)pSMavenServerBase.getPSMavenServerId());
        }
        if (pSMavenServerBase.isPSMavenServerNameDirty() && (bl || pSMavenServerBase.getPSMavenServerName() != null)) {
            iDataObject.set(FIELD_PSMAVENSERVERNAME, (Object)pSMavenServerBase.getPSMavenServerName());
        }
        if (pSMavenServerBase.isPSSvrDomainIdDirty() && (bl || pSMavenServerBase.getPSSvrDomainId() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINID, (Object)pSMavenServerBase.getPSSvrDomainId());
        }
        if (pSMavenServerBase.isPSSvrDomainNameDirty() && (bl || pSMavenServerBase.getPSSvrDomainName() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINNAME, (Object)pSMavenServerBase.getPSSvrDomainName());
        }
        if (pSMavenServerBase.isUpdateDateDirty() && (bl || pSMavenServerBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSMavenServerBase.getUpdateDate());
        }
        if (pSMavenServerBase.isUpdateManDirty() && (bl || pSMavenServerBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSMavenServerBase.getUpdateMan());
        }
        if (pSMavenServerBase.isUserNameDirty() && (bl || pSMavenServerBase.getUserName() != null)) {
            iDataObject.set(FIELD_USERNAME, (Object)pSMavenServerBase.getUserName());
        }
        if (pSMavenServerBase.isValidFlagDirty() && (bl || pSMavenServerBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSMavenServerBase.getValidFlag());
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
        return PSMavenServerBase.remove(this, n);
    }

    private static boolean remove(PSMavenServerBase pSMavenServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSMavenServerBase.resetAPIPath();
                return true;
            }
            case 1: {
                pSMavenServerBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSMavenServerBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSMavenServerBase.resetIpAddr();
                return true;
            }
            case 4: {
                pSMavenServerBase.resetIpAddr2();
                return true;
            }
            case 5: {
                pSMavenServerBase.resetMavenPasswd();
                return true;
            }
            case 6: {
                pSMavenServerBase.resetMavenServerType();
                return true;
            }
            case 7: {
                pSMavenServerBase.resetMavenUrl();
                return true;
            }
            case 8: {
                pSMavenServerBase.resetMavenUserName();
                return true;
            }
            case 9: {
                pSMavenServerBase.resetMemo();
                return true;
            }
            case 10: {
                pSMavenServerBase.resetPasswd();
                return true;
            }
            case 11: {
                pSMavenServerBase.resetPort();
                return true;
            }
            case 12: {
                pSMavenServerBase.resetPSMavenServerId();
                return true;
            }
            case 13: {
                pSMavenServerBase.resetPSMavenServerName();
                return true;
            }
            case 14: {
                pSMavenServerBase.resetPSSvrDomainId();
                return true;
            }
            case 15: {
                pSMavenServerBase.resetPSSvrDomainName();
                return true;
            }
            case 16: {
                pSMavenServerBase.resetUpdateDate();
                return true;
            }
            case 17: {
                pSMavenServerBase.resetUpdateMan();
                return true;
            }
            case 18: {
                pSMavenServerBase.resetUserName();
                return true;
            }
            case 19: {
                pSMavenServerBase.resetValidFlag();
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

    private PSMavenServerBase getProxyEntity() {
        return this.proxyPSMavenServerBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSMavenServerBase = null;
        if (iDataObject != null && iDataObject instanceof PSMavenServerBase) {
            this.proxyPSMavenServerBase = (PSMavenServerBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSMavenServerService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_APIPATH, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_IPADDR, 3);
        fieldIndexMap.put(FIELD_IPADDR2, 4);
        fieldIndexMap.put(FIELD_MAVENPASSWD, 5);
        fieldIndexMap.put(FIELD_MAVENSERVERTYPE, 6);
        fieldIndexMap.put(FIELD_MAVENURL, 7);
        fieldIndexMap.put(FIELD_MAVENUSERNAME, 8);
        fieldIndexMap.put(FIELD_MEMO, 9);
        fieldIndexMap.put(FIELD_PASSWD, 10);
        fieldIndexMap.put(FIELD_PORT, 11);
        fieldIndexMap.put(FIELD_PSMAVENSERVERID, 12);
        fieldIndexMap.put(FIELD_PSMAVENSERVERNAME, 13);
        fieldIndexMap.put(FIELD_PSSVRDOMAINID, 14);
        fieldIndexMap.put(FIELD_PSSVRDOMAINNAME, 15);
        fieldIndexMap.put(FIELD_UPDATEDATE, 16);
        fieldIndexMap.put(FIELD_UPDATEMAN, 17);
        fieldIndexMap.put(FIELD_USERNAME, 18);
        fieldIndexMap.put(FIELD_VALIDFLAG, 19);
    }
}

