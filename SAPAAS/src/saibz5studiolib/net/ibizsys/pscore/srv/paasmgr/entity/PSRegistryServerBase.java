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

public abstract class PSRegistryServerBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSRegistryServerBase.class);
    public static final String FIELD_APIPATH = "APIPATH";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_IPADDR = "IPADDR";
    public static final String FIELD_IPADDR2 = "IPADDR2";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PASSWD = "PASSWD";
    public static final String FIELD_PORT = "PORT";
    public static final String FIELD_PSREGISTRYSERVERID = "PSREGISTRYSERVERID";
    public static final String FIELD_PSREGISTRYSERVERNAME = "PSREGISTRYSERVERNAME";
    public static final String FIELD_PSSVRDOMAINID = "PSSVRDOMAINID";
    public static final String FIELD_PSSVRDOMAINNAME = "PSSVRDOMAINNAME";
    public static final String FIELD_REGISTRYPASSWD = "REGISTRYPASSWD";
    public static final String FIELD_REGISTRYTYPE = "REGISTRYTYPE";
    public static final String FIELD_REGISTRYURL = "REGISTRYURL";
    public static final String FIELD_REGISTRYUSERNAME = "REGISTRYUSERNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERNAME = "USERNAME";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_APIPATH = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_IPADDR = 3;
    private static final int INDEX_IPADDR2 = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_PASSWD = 6;
    private static final int INDEX_PORT = 7;
    private static final int INDEX_PSREGISTRYSERVERID = 8;
    private static final int INDEX_PSREGISTRYSERVERNAME = 9;
    private static final int INDEX_PSSVRDOMAINID = 10;
    private static final int INDEX_PSSVRDOMAINNAME = 11;
    private static final int INDEX_REGISTRYPASSWD = 12;
    private static final int INDEX_REGISTRYTYPE = 13;
    private static final int INDEX_REGISTRYURL = 14;
    private static final int INDEX_REGISTRYUSERNAME = 15;
    private static final int INDEX_UPDATEDATE = 16;
    private static final int INDEX_UPDATEMAN = 17;
    private static final int INDEX_USERNAME = 18;
    private static final int INDEX_VALIDFLAG = 19;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSRegistryServerBase proxyPSRegistryServerBase = null;
    private boolean apipathDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean ipaddrDirtyFlag = false;
    private boolean ipaddr2DirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean passwdDirtyFlag = false;
    private boolean portDirtyFlag = false;
    private boolean psregistryserveridDirtyFlag = false;
    private boolean psregistryservernameDirtyFlag = false;
    private boolean pssvrdomainidDirtyFlag = false;
    private boolean pssvrdomainnameDirtyFlag = false;
    private boolean registrypasswdDirtyFlag = false;
    private boolean registrytypeDirtyFlag = false;
    private boolean registryurlDirtyFlag = false;
    private boolean registryusernameDirtyFlag = false;
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
    @Column(name="memo")
    private String memo;
    @Column(name="passwd")
    private String passwd;
    @Column(name="port")
    private Integer port;
    @Column(name="psregistryserverid")
    private String psregistryserverid;
    @Column(name="psregistryservername")
    private String psregistryservername;
    @Column(name="pssvrdomainid")
    private String pssvrdomainid;
    @Column(name="pssvrdomainname")
    private String pssvrdomainname;
    @Column(name="registrypasswd")
    private String registrypasswd;
    @Column(name="registrytype")
    private String registrytype;
    @Column(name="registryurl")
    private String registryurl;
    @Column(name="registryusername")
    private String registryusername;
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

    public void setPSRegistryServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSRegistryServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psregistryserverid = string;
        this.psregistryserveridDirtyFlag = true;
    }

    public String getPSRegistryServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSRegistryServerId();
        }
        return this.psregistryserverid;
    }

    public boolean isPSRegistryServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSRegistryServerIdDirty();
        }
        return this.psregistryserveridDirtyFlag;
    }

    public void resetPSRegistryServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSRegistryServerId();
            return;
        }
        this.psregistryserveridDirtyFlag = false;
        this.psregistryserverid = null;
    }

    public void setPSRegistryServerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSRegistryServerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psregistryservername = string;
        this.psregistryservernameDirtyFlag = true;
    }

    public String getPSRegistryServerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSRegistryServerName();
        }
        return this.psregistryservername;
    }

    public boolean isPSRegistryServerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSRegistryServerNameDirty();
        }
        return this.psregistryservernameDirtyFlag;
    }

    public void resetPSRegistryServerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSRegistryServerName();
            return;
        }
        this.psregistryservernameDirtyFlag = false;
        this.psregistryservername = null;
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

    public void setRegistryPasswd(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRegistryPasswd(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.registrypasswd = string;
        this.registrypasswdDirtyFlag = true;
    }

    public String getRegistryPasswd() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRegistryPasswd();
        }
        return this.registrypasswd;
    }

    public boolean isRegistryPasswdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRegistryPasswdDirty();
        }
        return this.registrypasswdDirtyFlag;
    }

    public void resetRegistryPasswd() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRegistryPasswd();
            return;
        }
        this.registrypasswdDirtyFlag = false;
        this.registrypasswd = null;
    }

    public void setRegistryType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRegistryType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.registrytype = string;
        this.registrytypeDirtyFlag = true;
    }

    public String getRegistryType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRegistryType();
        }
        return this.registrytype;
    }

    public boolean isRegistryTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRegistryTypeDirty();
        }
        return this.registrytypeDirtyFlag;
    }

    public void resetRegistryType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRegistryType();
            return;
        }
        this.registrytypeDirtyFlag = false;
        this.registrytype = null;
    }

    public void setRegistryUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRegistryUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.registryurl = string;
        this.registryurlDirtyFlag = true;
    }

    public String getRegistryUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRegistryUrl();
        }
        return this.registryurl;
    }

    public boolean isRegistryUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRegistryUrlDirty();
        }
        return this.registryurlDirtyFlag;
    }

    public void resetRegistryUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRegistryUrl();
            return;
        }
        this.registryurlDirtyFlag = false;
        this.registryurl = null;
    }

    public void setRegistryUserName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRegistryUserName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.registryusername = string;
        this.registryusernameDirtyFlag = true;
    }

    public String getRegistryUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRegistryUserName();
        }
        return this.registryusername;
    }

    public boolean isRegistryUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRegistryUserNameDirty();
        }
        return this.registryusernameDirtyFlag;
    }

    public void resetRegistryUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRegistryUserName();
            return;
        }
        this.registryusernameDirtyFlag = false;
        this.registryusername = null;
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
        PSRegistryServerBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSRegistryServerBase pSRegistryServerBase) {
        pSRegistryServerBase.resetAPIPath();
        pSRegistryServerBase.resetCreateDate();
        pSRegistryServerBase.resetCreateMan();
        pSRegistryServerBase.resetIpAddr();
        pSRegistryServerBase.resetIpAddr2();
        pSRegistryServerBase.resetMemo();
        pSRegistryServerBase.resetPasswd();
        pSRegistryServerBase.resetPort();
        pSRegistryServerBase.resetPSRegistryServerId();
        pSRegistryServerBase.resetPSRegistryServerName();
        pSRegistryServerBase.resetPSSvrDomainId();
        pSRegistryServerBase.resetPSSvrDomainName();
        pSRegistryServerBase.resetRegistryPasswd();
        pSRegistryServerBase.resetRegistryType();
        pSRegistryServerBase.resetRegistryUrl();
        pSRegistryServerBase.resetRegistryUserName();
        pSRegistryServerBase.resetUpdateDate();
        pSRegistryServerBase.resetUpdateMan();
        pSRegistryServerBase.resetUserName();
        pSRegistryServerBase.resetValidFlag();
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
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPasswdDirty()) {
            hashMap.put(FIELD_PASSWD, this.getPasswd());
        }
        if (!bl || this.isPortDirty()) {
            hashMap.put(FIELD_PORT, this.getPort());
        }
        if (!bl || this.isPSRegistryServerIdDirty()) {
            hashMap.put(FIELD_PSREGISTRYSERVERID, this.getPSRegistryServerId());
        }
        if (!bl || this.isPSRegistryServerNameDirty()) {
            hashMap.put(FIELD_PSREGISTRYSERVERNAME, this.getPSRegistryServerName());
        }
        if (!bl || this.isPSSvrDomainIdDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINID, this.getPSSvrDomainId());
        }
        if (!bl || this.isPSSvrDomainNameDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINNAME, this.getPSSvrDomainName());
        }
        if (!bl || this.isRegistryPasswdDirty()) {
            hashMap.put(FIELD_REGISTRYPASSWD, this.getRegistryPasswd());
        }
        if (!bl || this.isRegistryTypeDirty()) {
            hashMap.put(FIELD_REGISTRYTYPE, this.getRegistryType());
        }
        if (!bl || this.isRegistryUrlDirty()) {
            hashMap.put(FIELD_REGISTRYURL, this.getRegistryUrl());
        }
        if (!bl || this.isRegistryUserNameDirty()) {
            hashMap.put(FIELD_REGISTRYUSERNAME, this.getRegistryUserName());
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
        return PSRegistryServerBase.get(this, n);
    }

    private static Object get(PSRegistryServerBase pSRegistryServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSRegistryServerBase.getAPIPath();
            }
            case 1: {
                return pSRegistryServerBase.getCreateDate();
            }
            case 2: {
                return pSRegistryServerBase.getCreateMan();
            }
            case 3: {
                return pSRegistryServerBase.getIpAddr();
            }
            case 4: {
                return pSRegistryServerBase.getIpAddr2();
            }
            case 5: {
                return pSRegistryServerBase.getMemo();
            }
            case 6: {
                return pSRegistryServerBase.getPasswd();
            }
            case 7: {
                return pSRegistryServerBase.getPort();
            }
            case 8: {
                return pSRegistryServerBase.getPSRegistryServerId();
            }
            case 9: {
                return pSRegistryServerBase.getPSRegistryServerName();
            }
            case 10: {
                return pSRegistryServerBase.getPSSvrDomainId();
            }
            case 11: {
                return pSRegistryServerBase.getPSSvrDomainName();
            }
            case 12: {
                return pSRegistryServerBase.getRegistryPasswd();
            }
            case 13: {
                return pSRegistryServerBase.getRegistryType();
            }
            case 14: {
                return pSRegistryServerBase.getRegistryUrl();
            }
            case 15: {
                return pSRegistryServerBase.getRegistryUserName();
            }
            case 16: {
                return pSRegistryServerBase.getUpdateDate();
            }
            case 17: {
                return pSRegistryServerBase.getUpdateMan();
            }
            case 18: {
                return pSRegistryServerBase.getUserName();
            }
            case 19: {
                return pSRegistryServerBase.getValidFlag();
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
        PSRegistryServerBase.set(this, n, object);
    }

    private static void set(PSRegistryServerBase pSRegistryServerBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSRegistryServerBase.setAPIPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSRegistryServerBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSRegistryServerBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSRegistryServerBase.setIpAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSRegistryServerBase.setIpAddr2(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSRegistryServerBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSRegistryServerBase.setPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSRegistryServerBase.setPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSRegistryServerBase.setPSRegistryServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSRegistryServerBase.setPSRegistryServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSRegistryServerBase.setPSSvrDomainId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSRegistryServerBase.setPSSvrDomainName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSRegistryServerBase.setRegistryPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSRegistryServerBase.setRegistryType(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSRegistryServerBase.setRegistryUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSRegistryServerBase.setRegistryUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSRegistryServerBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 17: {
                pSRegistryServerBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSRegistryServerBase.setUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSRegistryServerBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSRegistryServerBase.isNull(this, n);
    }

    private static boolean isNull(PSRegistryServerBase pSRegistryServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSRegistryServerBase.getAPIPath() == null;
            }
            case 1: {
                return pSRegistryServerBase.getCreateDate() == null;
            }
            case 2: {
                return pSRegistryServerBase.getCreateMan() == null;
            }
            case 3: {
                return pSRegistryServerBase.getIpAddr() == null;
            }
            case 4: {
                return pSRegistryServerBase.getIpAddr2() == null;
            }
            case 5: {
                return pSRegistryServerBase.getMemo() == null;
            }
            case 6: {
                return pSRegistryServerBase.getPasswd() == null;
            }
            case 7: {
                return pSRegistryServerBase.getPort() == null;
            }
            case 8: {
                return pSRegistryServerBase.getPSRegistryServerId() == null;
            }
            case 9: {
                return pSRegistryServerBase.getPSRegistryServerName() == null;
            }
            case 10: {
                return pSRegistryServerBase.getPSSvrDomainId() == null;
            }
            case 11: {
                return pSRegistryServerBase.getPSSvrDomainName() == null;
            }
            case 12: {
                return pSRegistryServerBase.getRegistryPasswd() == null;
            }
            case 13: {
                return pSRegistryServerBase.getRegistryType() == null;
            }
            case 14: {
                return pSRegistryServerBase.getRegistryUrl() == null;
            }
            case 15: {
                return pSRegistryServerBase.getRegistryUserName() == null;
            }
            case 16: {
                return pSRegistryServerBase.getUpdateDate() == null;
            }
            case 17: {
                return pSRegistryServerBase.getUpdateMan() == null;
            }
            case 18: {
                return pSRegistryServerBase.getUserName() == null;
            }
            case 19: {
                return pSRegistryServerBase.getValidFlag() == null;
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
        return PSRegistryServerBase.contains(this, n);
    }

    private static boolean contains(PSRegistryServerBase pSRegistryServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSRegistryServerBase.isAPIPathDirty();
            }
            case 1: {
                return pSRegistryServerBase.isCreateDateDirty();
            }
            case 2: {
                return pSRegistryServerBase.isCreateManDirty();
            }
            case 3: {
                return pSRegistryServerBase.isIpAddrDirty();
            }
            case 4: {
                return pSRegistryServerBase.isIpAddr2Dirty();
            }
            case 5: {
                return pSRegistryServerBase.isMemoDirty();
            }
            case 6: {
                return pSRegistryServerBase.isPasswdDirty();
            }
            case 7: {
                return pSRegistryServerBase.isPortDirty();
            }
            case 8: {
                return pSRegistryServerBase.isPSRegistryServerIdDirty();
            }
            case 9: {
                return pSRegistryServerBase.isPSRegistryServerNameDirty();
            }
            case 10: {
                return pSRegistryServerBase.isPSSvrDomainIdDirty();
            }
            case 11: {
                return pSRegistryServerBase.isPSSvrDomainNameDirty();
            }
            case 12: {
                return pSRegistryServerBase.isRegistryPasswdDirty();
            }
            case 13: {
                return pSRegistryServerBase.isRegistryTypeDirty();
            }
            case 14: {
                return pSRegistryServerBase.isRegistryUrlDirty();
            }
            case 15: {
                return pSRegistryServerBase.isRegistryUserNameDirty();
            }
            case 16: {
                return pSRegistryServerBase.isUpdateDateDirty();
            }
            case 17: {
                return pSRegistryServerBase.isUpdateManDirty();
            }
            case 18: {
                return pSRegistryServerBase.isUserNameDirty();
            }
            case 19: {
                return pSRegistryServerBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSRegistryServerBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSRegistryServerBase pSRegistryServerBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSRegistryServerBase.getAPIPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"apipath", (Object)PSRegistryServerBase.getJSONValue((Object)pSRegistryServerBase.getAPIPath()), (boolean)false);
        }
        if (bl || pSRegistryServerBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSRegistryServerBase.getJSONValue((Object)pSRegistryServerBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSRegistryServerBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSRegistryServerBase.getJSONValue((Object)pSRegistryServerBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSRegistryServerBase.getIpAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr", (Object)PSRegistryServerBase.getJSONValue((Object)pSRegistryServerBase.getIpAddr()), (boolean)false);
        }
        if (bl || pSRegistryServerBase.getIpAddr2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr2", (Object)PSRegistryServerBase.getJSONValue((Object)pSRegistryServerBase.getIpAddr2()), (boolean)false);
        }
        if (bl || pSRegistryServerBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSRegistryServerBase.getJSONValue((Object)pSRegistryServerBase.getMemo()), (boolean)false);
        }
        if (bl || pSRegistryServerBase.getPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"passwd", (Object)PSRegistryServerBase.getJSONValue((Object)pSRegistryServerBase.getPasswd()), (boolean)false);
        }
        if (bl || pSRegistryServerBase.getPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"port", (Object)PSRegistryServerBase.getJSONValue((Object)pSRegistryServerBase.getPort()), (boolean)false);
        }
        if (bl || pSRegistryServerBase.getPSRegistryServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psregistryserverid", (Object)PSRegistryServerBase.getJSONValue((Object)pSRegistryServerBase.getPSRegistryServerId()), (boolean)false);
        }
        if (bl || pSRegistryServerBase.getPSRegistryServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psregistryservername", (Object)PSRegistryServerBase.getJSONValue((Object)pSRegistryServerBase.getPSRegistryServerName()), (boolean)false);
        }
        if (bl || pSRegistryServerBase.getPSSvrDomainId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainid", (Object)PSRegistryServerBase.getJSONValue((Object)pSRegistryServerBase.getPSSvrDomainId()), (boolean)false);
        }
        if (bl || pSRegistryServerBase.getPSSvrDomainName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainname", (Object)PSRegistryServerBase.getJSONValue((Object)pSRegistryServerBase.getPSSvrDomainName()), (boolean)false);
        }
        if (bl || pSRegistryServerBase.getRegistryPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"registrypasswd", (Object)PSRegistryServerBase.getJSONValue((Object)pSRegistryServerBase.getRegistryPasswd()), (boolean)false);
        }
        if (bl || pSRegistryServerBase.getRegistryType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"registrytype", (Object)PSRegistryServerBase.getJSONValue((Object)pSRegistryServerBase.getRegistryType()), (boolean)false);
        }
        if (bl || pSRegistryServerBase.getRegistryUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"registryurl", (Object)PSRegistryServerBase.getJSONValue((Object)pSRegistryServerBase.getRegistryUrl()), (boolean)false);
        }
        if (bl || pSRegistryServerBase.getRegistryUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"registryusername", (Object)PSRegistryServerBase.getJSONValue((Object)pSRegistryServerBase.getRegistryUserName()), (boolean)false);
        }
        if (bl || pSRegistryServerBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSRegistryServerBase.getJSONValue((Object)pSRegistryServerBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSRegistryServerBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSRegistryServerBase.getJSONValue((Object)pSRegistryServerBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSRegistryServerBase.getUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"username", (Object)PSRegistryServerBase.getJSONValue((Object)pSRegistryServerBase.getUserName()), (boolean)false);
        }
        if (bl || pSRegistryServerBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSRegistryServerBase.getJSONValue((Object)pSRegistryServerBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSRegistryServerBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSRegistryServerBase pSRegistryServerBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSRegistryServerBase.getAPIPath() != null) {
            object = pSRegistryServerBase.getAPIPath();
            xmlNode.setAttribute(FIELD_APIPATH, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryServerBase.getCreateDate() != null) {
            object = pSRegistryServerBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSRegistryServerBase.getCreateMan() != null) {
            object = pSRegistryServerBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryServerBase.getIpAddr() != null) {
            object = pSRegistryServerBase.getIpAddr();
            xmlNode.setAttribute(FIELD_IPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryServerBase.getIpAddr2() != null) {
            object = pSRegistryServerBase.getIpAddr2();
            xmlNode.setAttribute(FIELD_IPADDR2, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryServerBase.getMemo() != null) {
            object = pSRegistryServerBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryServerBase.getPasswd() != null) {
            object = pSRegistryServerBase.getPasswd();
            xmlNode.setAttribute(FIELD_PASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryServerBase.getPort() != null) {
            object = pSRegistryServerBase.getPort();
            xmlNode.setAttribute(FIELD_PORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSRegistryServerBase.getPSRegistryServerId() != null) {
            object = pSRegistryServerBase.getPSRegistryServerId();
            xmlNode.setAttribute(FIELD_PSREGISTRYSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryServerBase.getPSRegistryServerName() != null) {
            object = pSRegistryServerBase.getPSRegistryServerName();
            xmlNode.setAttribute(FIELD_PSREGISTRYSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryServerBase.getPSSvrDomainId() != null) {
            object = pSRegistryServerBase.getPSSvrDomainId();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINID, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryServerBase.getPSSvrDomainName() != null) {
            object = pSRegistryServerBase.getPSSvrDomainName();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryServerBase.getRegistryPasswd() != null) {
            object = pSRegistryServerBase.getRegistryPasswd();
            xmlNode.setAttribute(FIELD_REGISTRYPASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryServerBase.getRegistryType() != null) {
            object = pSRegistryServerBase.getRegistryType();
            xmlNode.setAttribute(FIELD_REGISTRYTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryServerBase.getRegistryUrl() != null) {
            object = pSRegistryServerBase.getRegistryUrl();
            xmlNode.setAttribute(FIELD_REGISTRYURL, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryServerBase.getRegistryUserName() != null) {
            object = pSRegistryServerBase.getRegistryUserName();
            xmlNode.setAttribute(FIELD_REGISTRYUSERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryServerBase.getUpdateDate() != null) {
            object = pSRegistryServerBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSRegistryServerBase.getUpdateMan() != null) {
            object = pSRegistryServerBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryServerBase.getUserName() != null) {
            object = pSRegistryServerBase.getUserName();
            xmlNode.setAttribute(FIELD_USERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryServerBase.getValidFlag() != null) {
            object = pSRegistryServerBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSRegistryServerBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSRegistryServerBase pSRegistryServerBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSRegistryServerBase.isAPIPathDirty() && (bl || pSRegistryServerBase.getAPIPath() != null)) {
            iDataObject.set(FIELD_APIPATH, (Object)pSRegistryServerBase.getAPIPath());
        }
        if (pSRegistryServerBase.isCreateDateDirty() && (bl || pSRegistryServerBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSRegistryServerBase.getCreateDate());
        }
        if (pSRegistryServerBase.isCreateManDirty() && (bl || pSRegistryServerBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSRegistryServerBase.getCreateMan());
        }
        if (pSRegistryServerBase.isIpAddrDirty() && (bl || pSRegistryServerBase.getIpAddr() != null)) {
            iDataObject.set(FIELD_IPADDR, (Object)pSRegistryServerBase.getIpAddr());
        }
        if (pSRegistryServerBase.isIpAddr2Dirty() && (bl || pSRegistryServerBase.getIpAddr2() != null)) {
            iDataObject.set(FIELD_IPADDR2, (Object)pSRegistryServerBase.getIpAddr2());
        }
        if (pSRegistryServerBase.isMemoDirty() && (bl || pSRegistryServerBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSRegistryServerBase.getMemo());
        }
        if (pSRegistryServerBase.isPasswdDirty() && (bl || pSRegistryServerBase.getPasswd() != null)) {
            iDataObject.set(FIELD_PASSWD, (Object)pSRegistryServerBase.getPasswd());
        }
        if (pSRegistryServerBase.isPortDirty() && (bl || pSRegistryServerBase.getPort() != null)) {
            iDataObject.set(FIELD_PORT, (Object)pSRegistryServerBase.getPort());
        }
        if (pSRegistryServerBase.isPSRegistryServerIdDirty() && (bl || pSRegistryServerBase.getPSRegistryServerId() != null)) {
            iDataObject.set(FIELD_PSREGISTRYSERVERID, (Object)pSRegistryServerBase.getPSRegistryServerId());
        }
        if (pSRegistryServerBase.isPSRegistryServerNameDirty() && (bl || pSRegistryServerBase.getPSRegistryServerName() != null)) {
            iDataObject.set(FIELD_PSREGISTRYSERVERNAME, (Object)pSRegistryServerBase.getPSRegistryServerName());
        }
        if (pSRegistryServerBase.isPSSvrDomainIdDirty() && (bl || pSRegistryServerBase.getPSSvrDomainId() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINID, (Object)pSRegistryServerBase.getPSSvrDomainId());
        }
        if (pSRegistryServerBase.isPSSvrDomainNameDirty() && (bl || pSRegistryServerBase.getPSSvrDomainName() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINNAME, (Object)pSRegistryServerBase.getPSSvrDomainName());
        }
        if (pSRegistryServerBase.isRegistryPasswdDirty() && (bl || pSRegistryServerBase.getRegistryPasswd() != null)) {
            iDataObject.set(FIELD_REGISTRYPASSWD, (Object)pSRegistryServerBase.getRegistryPasswd());
        }
        if (pSRegistryServerBase.isRegistryTypeDirty() && (bl || pSRegistryServerBase.getRegistryType() != null)) {
            iDataObject.set(FIELD_REGISTRYTYPE, (Object)pSRegistryServerBase.getRegistryType());
        }
        if (pSRegistryServerBase.isRegistryUrlDirty() && (bl || pSRegistryServerBase.getRegistryUrl() != null)) {
            iDataObject.set(FIELD_REGISTRYURL, (Object)pSRegistryServerBase.getRegistryUrl());
        }
        if (pSRegistryServerBase.isRegistryUserNameDirty() && (bl || pSRegistryServerBase.getRegistryUserName() != null)) {
            iDataObject.set(FIELD_REGISTRYUSERNAME, (Object)pSRegistryServerBase.getRegistryUserName());
        }
        if (pSRegistryServerBase.isUpdateDateDirty() && (bl || pSRegistryServerBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSRegistryServerBase.getUpdateDate());
        }
        if (pSRegistryServerBase.isUpdateManDirty() && (bl || pSRegistryServerBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSRegistryServerBase.getUpdateMan());
        }
        if (pSRegistryServerBase.isUserNameDirty() && (bl || pSRegistryServerBase.getUserName() != null)) {
            iDataObject.set(FIELD_USERNAME, (Object)pSRegistryServerBase.getUserName());
        }
        if (pSRegistryServerBase.isValidFlagDirty() && (bl || pSRegistryServerBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSRegistryServerBase.getValidFlag());
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
        return PSRegistryServerBase.remove(this, n);
    }

    private static boolean remove(PSRegistryServerBase pSRegistryServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSRegistryServerBase.resetAPIPath();
                return true;
            }
            case 1: {
                pSRegistryServerBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSRegistryServerBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSRegistryServerBase.resetIpAddr();
                return true;
            }
            case 4: {
                pSRegistryServerBase.resetIpAddr2();
                return true;
            }
            case 5: {
                pSRegistryServerBase.resetMemo();
                return true;
            }
            case 6: {
                pSRegistryServerBase.resetPasswd();
                return true;
            }
            case 7: {
                pSRegistryServerBase.resetPort();
                return true;
            }
            case 8: {
                pSRegistryServerBase.resetPSRegistryServerId();
                return true;
            }
            case 9: {
                pSRegistryServerBase.resetPSRegistryServerName();
                return true;
            }
            case 10: {
                pSRegistryServerBase.resetPSSvrDomainId();
                return true;
            }
            case 11: {
                pSRegistryServerBase.resetPSSvrDomainName();
                return true;
            }
            case 12: {
                pSRegistryServerBase.resetRegistryPasswd();
                return true;
            }
            case 13: {
                pSRegistryServerBase.resetRegistryType();
                return true;
            }
            case 14: {
                pSRegistryServerBase.resetRegistryUrl();
                return true;
            }
            case 15: {
                pSRegistryServerBase.resetRegistryUserName();
                return true;
            }
            case 16: {
                pSRegistryServerBase.resetUpdateDate();
                return true;
            }
            case 17: {
                pSRegistryServerBase.resetUpdateMan();
                return true;
            }
            case 18: {
                pSRegistryServerBase.resetUserName();
                return true;
            }
            case 19: {
                pSRegistryServerBase.resetValidFlag();
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

    private PSRegistryServerBase getProxyEntity() {
        return this.proxyPSRegistryServerBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSRegistryServerBase = null;
        if (iDataObject != null && iDataObject instanceof PSRegistryServerBase) {
            this.proxyPSRegistryServerBase = (PSRegistryServerBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSRegistryServerService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_APIPATH, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_IPADDR, 3);
        fieldIndexMap.put(FIELD_IPADDR2, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_PASSWD, 6);
        fieldIndexMap.put(FIELD_PORT, 7);
        fieldIndexMap.put(FIELD_PSREGISTRYSERVERID, 8);
        fieldIndexMap.put(FIELD_PSREGISTRYSERVERNAME, 9);
        fieldIndexMap.put(FIELD_PSSVRDOMAINID, 10);
        fieldIndexMap.put(FIELD_PSSVRDOMAINNAME, 11);
        fieldIndexMap.put(FIELD_REGISTRYPASSWD, 12);
        fieldIndexMap.put(FIELD_REGISTRYTYPE, 13);
        fieldIndexMap.put(FIELD_REGISTRYURL, 14);
        fieldIndexMap.put(FIELD_REGISTRYUSERNAME, 15);
        fieldIndexMap.put(FIELD_UPDATEDATE, 16);
        fieldIndexMap.put(FIELD_UPDATEMAN, 17);
        fieldIndexMap.put(FIELD_USERNAME, 18);
        fieldIndexMap.put(FIELD_VALIDFLAG, 19);
    }
}

