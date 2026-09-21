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

public abstract class PSPMSServerBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSPMSServerBase.class);
    public static final String FIELD_APIPATH = "APIPATH";
    public static final String FIELD_APITOKEN = "APITOKEN";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_IPADDR = "IPADDR";
    public static final String FIELD_IPADDR2 = "IPADDR2";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PASSWD = "PASSWD";
    public static final String FIELD_PMSPASSWD = "PMSPASSWD";
    public static final String FIELD_PMSUSERNAME = "PMSUSERNAME";
    public static final String FIELD_PORT = "PORT";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSPMSSERVERID = "PSPMSSERVERID";
    public static final String FIELD_PSPMSSERVERNAME = "PSPMSSERVERNAME";
    public static final String FIELD_PSSVRDOMAINID = "PSSVRDOMAINID";
    public static final String FIELD_PSSVRDOMAINNAME = "PSSVRDOMAINNAME";
    public static final String FIELD_PSTAG = "PSTAG";
    public static final String FIELD_PSTAG2 = "PSTAG2";
    public static final String FIELD_PSTAG3 = "PSTAG3";
    public static final String FIELD_PSTAG4 = "PSTAG4";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_URL = "URL";
    public static final String FIELD_USERNAME = "USERNAME";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_APIPATH = 0;
    private static final int INDEX_APITOKEN = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_IPADDR = 4;
    private static final int INDEX_IPADDR2 = 5;
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_PASSWD = 7;
    private static final int INDEX_PMSPASSWD = 8;
    private static final int INDEX_PMSUSERNAME = 9;
    private static final int INDEX_PORT = 10;
    private static final int INDEX_PSDEVCENTERID = 11;
    private static final int INDEX_PSDEVCENTERNAME = 12;
    private static final int INDEX_PSPMSSERVERID = 13;
    private static final int INDEX_PSPMSSERVERNAME = 14;
    private static final int INDEX_PSSVRDOMAINID = 15;
    private static final int INDEX_PSSVRDOMAINNAME = 16;
    private static final int INDEX_PSTAG = 17;
    private static final int INDEX_PSTAG2 = 18;
    private static final int INDEX_PSTAG3 = 19;
    private static final int INDEX_PSTAG4 = 20;
    private static final int INDEX_UPDATEDATE = 21;
    private static final int INDEX_UPDATEMAN = 22;
    private static final int INDEX_URL = 23;
    private static final int INDEX_USERNAME = 24;
    private static final int INDEX_USERTAG = 25;
    private static final int INDEX_USERTAG2 = 26;
    private static final int INDEX_VALIDFLAG = 27;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSPMSServerBase proxyPSPMSServerBase = null;
    private boolean apipathDirtyFlag = false;
    private boolean apitokenDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean ipaddrDirtyFlag = false;
    private boolean ipaddr2DirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean passwdDirtyFlag = false;
    private boolean pmspasswdDirtyFlag = false;
    private boolean pmsusernameDirtyFlag = false;
    private boolean portDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean pspmsserveridDirtyFlag = false;
    private boolean pspmsservernameDirtyFlag = false;
    private boolean pssvrdomainidDirtyFlag = false;
    private boolean pssvrdomainnameDirtyFlag = false;
    private boolean pstagDirtyFlag = false;
    private boolean pstag2DirtyFlag = false;
    private boolean pstag3DirtyFlag = false;
    private boolean pstag4DirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean urlDirtyFlag = false;
    private boolean usernameDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="apipath")
    private String apipath;
    @Column(name="apitoken")
    private String apitoken;
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
    @Column(name="pmspasswd")
    private String pmspasswd;
    @Column(name="pmsusername")
    private String pmsusername;
    @Column(name="port")
    private Integer port;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="pspmsserverid")
    private String pspmsserverid;
    @Column(name="pspmsservername")
    private String pspmsservername;
    @Column(name="pssvrdomainid")
    private String pssvrdomainid;
    @Column(name="pssvrdomainname")
    private String pssvrdomainname;
    @Column(name="pstag")
    private String pstag;
    @Column(name="pstag2")
    private String pstag2;
    @Column(name="pstag3")
    private String pstag3;
    @Column(name="pstag4")
    private String pstag4;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="url")
    private String url;
    @Column(name="username")
    private String username;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
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

    public void setPMSPasswd(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPMSPasswd(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pmspasswd = string;
        this.pmspasswdDirtyFlag = true;
    }

    public String getPMSPasswd() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPMSPasswd();
        }
        return this.pmspasswd;
    }

    public boolean isPMSPasswdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPMSPasswdDirty();
        }
        return this.pmspasswdDirtyFlag;
    }

    public void resetPMSPasswd() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPMSPasswd();
            return;
        }
        this.pmspasswdDirtyFlag = false;
        this.pmspasswd = null;
    }

    public void setPMSUserName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPMSUserName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pmsusername = string;
        this.pmsusernameDirtyFlag = true;
    }

    public String getPMSUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPMSUserName();
        }
        return this.pmsusername;
    }

    public boolean isPMSUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPMSUserNameDirty();
        }
        return this.pmsusernameDirtyFlag;
    }

    public void resetPMSUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPMSUserName();
            return;
        }
        this.pmsusernameDirtyFlag = false;
        this.pmsusername = null;
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

    public void setPSTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pstag = string;
        this.pstagDirtyFlag = true;
    }

    public String getPSTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSTag();
        }
        return this.pstag;
    }

    public boolean isPSTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSTagDirty();
        }
        return this.pstagDirtyFlag;
    }

    public void resetPSTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSTag();
            return;
        }
        this.pstagDirtyFlag = false;
        this.pstag = null;
    }

    public void setPSTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pstag2 = string;
        this.pstag2DirtyFlag = true;
    }

    public String getPSTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSTag2();
        }
        return this.pstag2;
    }

    public boolean isPSTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSTag2Dirty();
        }
        return this.pstag2DirtyFlag;
    }

    public void resetPSTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSTag2();
            return;
        }
        this.pstag2DirtyFlag = false;
        this.pstag2 = null;
    }

    public void setPSTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pstag3 = string;
        this.pstag3DirtyFlag = true;
    }

    public String getPSTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSTag3();
        }
        return this.pstag3;
    }

    public boolean isPSTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSTag3Dirty();
        }
        return this.pstag3DirtyFlag;
    }

    public void resetPSTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSTag3();
            return;
        }
        this.pstag3DirtyFlag = false;
        this.pstag3 = null;
    }

    public void setPSTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pstag4 = string;
        this.pstag4DirtyFlag = true;
    }

    public String getPSTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSTag4();
        }
        return this.pstag4;
    }

    public boolean isPSTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSTag4Dirty();
        }
        return this.pstag4DirtyFlag;
    }

    public void resetPSTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSTag4();
            return;
        }
        this.pstag4DirtyFlag = false;
        this.pstag4 = null;
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

    public void setUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.url = string;
        this.urlDirtyFlag = true;
    }

    public String getUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUrl();
        }
        return this.url;
    }

    public boolean isUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUrlDirty();
        }
        return this.urlDirtyFlag;
    }

    public void resetUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUrl();
            return;
        }
        this.urlDirtyFlag = false;
        this.url = null;
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
        PSPMSServerBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSPMSServerBase pSPMSServerBase) {
        pSPMSServerBase.resetAPIPath();
        pSPMSServerBase.resetAPIToken();
        pSPMSServerBase.resetCreateDate();
        pSPMSServerBase.resetCreateMan();
        pSPMSServerBase.resetIpAddr();
        pSPMSServerBase.resetIpAddr2();
        pSPMSServerBase.resetMemo();
        pSPMSServerBase.resetPasswd();
        pSPMSServerBase.resetPMSPasswd();
        pSPMSServerBase.resetPMSUserName();
        pSPMSServerBase.resetPort();
        pSPMSServerBase.resetPSDevCenterId();
        pSPMSServerBase.resetPSDevCenterName();
        pSPMSServerBase.resetPSPMSServerId();
        pSPMSServerBase.resetPSPMSServerName();
        pSPMSServerBase.resetPSSvrDomainId();
        pSPMSServerBase.resetPSSvrDomainName();
        pSPMSServerBase.resetPSTag();
        pSPMSServerBase.resetPSTag2();
        pSPMSServerBase.resetPSTag3();
        pSPMSServerBase.resetPSTag4();
        pSPMSServerBase.resetUpdateDate();
        pSPMSServerBase.resetUpdateMan();
        pSPMSServerBase.resetUrl();
        pSPMSServerBase.resetUserName();
        pSPMSServerBase.resetUserTag();
        pSPMSServerBase.resetUserTag2();
        pSPMSServerBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAPIPathDirty()) {
            hashMap.put(FIELD_APIPATH, this.getAPIPath());
        }
        if (!bl || this.isAPITokenDirty()) {
            hashMap.put(FIELD_APITOKEN, this.getAPIToken());
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
        if (!bl || this.isPMSPasswdDirty()) {
            hashMap.put(FIELD_PMSPASSWD, this.getPMSPasswd());
        }
        if (!bl || this.isPMSUserNameDirty()) {
            hashMap.put(FIELD_PMSUSERNAME, this.getPMSUserName());
        }
        if (!bl || this.isPortDirty()) {
            hashMap.put(FIELD_PORT, this.getPort());
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
        if (!bl || this.isPSSvrDomainIdDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINID, this.getPSSvrDomainId());
        }
        if (!bl || this.isPSSvrDomainNameDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINNAME, this.getPSSvrDomainName());
        }
        if (!bl || this.isPSTagDirty()) {
            hashMap.put(FIELD_PSTAG, this.getPSTag());
        }
        if (!bl || this.isPSTag2Dirty()) {
            hashMap.put(FIELD_PSTAG2, this.getPSTag2());
        }
        if (!bl || this.isPSTag3Dirty()) {
            hashMap.put(FIELD_PSTAG3, this.getPSTag3());
        }
        if (!bl || this.isPSTag4Dirty()) {
            hashMap.put(FIELD_PSTAG4, this.getPSTag4());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUrlDirty()) {
            hashMap.put(FIELD_URL, this.getUrl());
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
        return PSPMSServerBase.get(this, n);
    }

    private static Object get(PSPMSServerBase pSPMSServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPMSServerBase.getAPIPath();
            }
            case 1: {
                return pSPMSServerBase.getAPIToken();
            }
            case 2: {
                return pSPMSServerBase.getCreateDate();
            }
            case 3: {
                return pSPMSServerBase.getCreateMan();
            }
            case 4: {
                return pSPMSServerBase.getIpAddr();
            }
            case 5: {
                return pSPMSServerBase.getIpAddr2();
            }
            case 6: {
                return pSPMSServerBase.getMemo();
            }
            case 7: {
                return pSPMSServerBase.getPasswd();
            }
            case 8: {
                return pSPMSServerBase.getPMSPasswd();
            }
            case 9: {
                return pSPMSServerBase.getPMSUserName();
            }
            case 10: {
                return pSPMSServerBase.getPort();
            }
            case 11: {
                return pSPMSServerBase.getPSDevCenterId();
            }
            case 12: {
                return pSPMSServerBase.getPSDevCenterName();
            }
            case 13: {
                return pSPMSServerBase.getPSPMSServerId();
            }
            case 14: {
                return pSPMSServerBase.getPSPMSServerName();
            }
            case 15: {
                return pSPMSServerBase.getPSSvrDomainId();
            }
            case 16: {
                return pSPMSServerBase.getPSSvrDomainName();
            }
            case 17: {
                return pSPMSServerBase.getPSTag();
            }
            case 18: {
                return pSPMSServerBase.getPSTag2();
            }
            case 19: {
                return pSPMSServerBase.getPSTag3();
            }
            case 20: {
                return pSPMSServerBase.getPSTag4();
            }
            case 21: {
                return pSPMSServerBase.getUpdateDate();
            }
            case 22: {
                return pSPMSServerBase.getUpdateMan();
            }
            case 23: {
                return pSPMSServerBase.getUrl();
            }
            case 24: {
                return pSPMSServerBase.getUserName();
            }
            case 25: {
                return pSPMSServerBase.getUserTag();
            }
            case 26: {
                return pSPMSServerBase.getUserTag2();
            }
            case 27: {
                return pSPMSServerBase.getValidFlag();
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
        PSPMSServerBase.set(this, n, object);
    }

    private static void set(PSPMSServerBase pSPMSServerBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSPMSServerBase.setAPIPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSPMSServerBase.setAPIToken(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSPMSServerBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSPMSServerBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSPMSServerBase.setIpAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSPMSServerBase.setIpAddr2(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSPMSServerBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSPMSServerBase.setPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSPMSServerBase.setPMSPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSPMSServerBase.setPMSUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSPMSServerBase.setPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSPMSServerBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSPMSServerBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSPMSServerBase.setPSPMSServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSPMSServerBase.setPSPMSServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSPMSServerBase.setPSSvrDomainId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSPMSServerBase.setPSSvrDomainName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSPMSServerBase.setPSTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSPMSServerBase.setPSTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSPMSServerBase.setPSTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSPMSServerBase.setPSTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSPMSServerBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 22: {
                pSPMSServerBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSPMSServerBase.setUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSPMSServerBase.setUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSPMSServerBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSPMSServerBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSPMSServerBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSPMSServerBase.isNull(this, n);
    }

    private static boolean isNull(PSPMSServerBase pSPMSServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPMSServerBase.getAPIPath() == null;
            }
            case 1: {
                return pSPMSServerBase.getAPIToken() == null;
            }
            case 2: {
                return pSPMSServerBase.getCreateDate() == null;
            }
            case 3: {
                return pSPMSServerBase.getCreateMan() == null;
            }
            case 4: {
                return pSPMSServerBase.getIpAddr() == null;
            }
            case 5: {
                return pSPMSServerBase.getIpAddr2() == null;
            }
            case 6: {
                return pSPMSServerBase.getMemo() == null;
            }
            case 7: {
                return pSPMSServerBase.getPasswd() == null;
            }
            case 8: {
                return pSPMSServerBase.getPMSPasswd() == null;
            }
            case 9: {
                return pSPMSServerBase.getPMSUserName() == null;
            }
            case 10: {
                return pSPMSServerBase.getPort() == null;
            }
            case 11: {
                return pSPMSServerBase.getPSDevCenterId() == null;
            }
            case 12: {
                return pSPMSServerBase.getPSDevCenterName() == null;
            }
            case 13: {
                return pSPMSServerBase.getPSPMSServerId() == null;
            }
            case 14: {
                return pSPMSServerBase.getPSPMSServerName() == null;
            }
            case 15: {
                return pSPMSServerBase.getPSSvrDomainId() == null;
            }
            case 16: {
                return pSPMSServerBase.getPSSvrDomainName() == null;
            }
            case 17: {
                return pSPMSServerBase.getPSTag() == null;
            }
            case 18: {
                return pSPMSServerBase.getPSTag2() == null;
            }
            case 19: {
                return pSPMSServerBase.getPSTag3() == null;
            }
            case 20: {
                return pSPMSServerBase.getPSTag4() == null;
            }
            case 21: {
                return pSPMSServerBase.getUpdateDate() == null;
            }
            case 22: {
                return pSPMSServerBase.getUpdateMan() == null;
            }
            case 23: {
                return pSPMSServerBase.getUrl() == null;
            }
            case 24: {
                return pSPMSServerBase.getUserName() == null;
            }
            case 25: {
                return pSPMSServerBase.getUserTag() == null;
            }
            case 26: {
                return pSPMSServerBase.getUserTag2() == null;
            }
            case 27: {
                return pSPMSServerBase.getValidFlag() == null;
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
        return PSPMSServerBase.contains(this, n);
    }

    private static boolean contains(PSPMSServerBase pSPMSServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPMSServerBase.isAPIPathDirty();
            }
            case 1: {
                return pSPMSServerBase.isAPITokenDirty();
            }
            case 2: {
                return pSPMSServerBase.isCreateDateDirty();
            }
            case 3: {
                return pSPMSServerBase.isCreateManDirty();
            }
            case 4: {
                return pSPMSServerBase.isIpAddrDirty();
            }
            case 5: {
                return pSPMSServerBase.isIpAddr2Dirty();
            }
            case 6: {
                return pSPMSServerBase.isMemoDirty();
            }
            case 7: {
                return pSPMSServerBase.isPasswdDirty();
            }
            case 8: {
                return pSPMSServerBase.isPMSPasswdDirty();
            }
            case 9: {
                return pSPMSServerBase.isPMSUserNameDirty();
            }
            case 10: {
                return pSPMSServerBase.isPortDirty();
            }
            case 11: {
                return pSPMSServerBase.isPSDevCenterIdDirty();
            }
            case 12: {
                return pSPMSServerBase.isPSDevCenterNameDirty();
            }
            case 13: {
                return pSPMSServerBase.isPSPMSServerIdDirty();
            }
            case 14: {
                return pSPMSServerBase.isPSPMSServerNameDirty();
            }
            case 15: {
                return pSPMSServerBase.isPSSvrDomainIdDirty();
            }
            case 16: {
                return pSPMSServerBase.isPSSvrDomainNameDirty();
            }
            case 17: {
                return pSPMSServerBase.isPSTagDirty();
            }
            case 18: {
                return pSPMSServerBase.isPSTag2Dirty();
            }
            case 19: {
                return pSPMSServerBase.isPSTag3Dirty();
            }
            case 20: {
                return pSPMSServerBase.isPSTag4Dirty();
            }
            case 21: {
                return pSPMSServerBase.isUpdateDateDirty();
            }
            case 22: {
                return pSPMSServerBase.isUpdateManDirty();
            }
            case 23: {
                return pSPMSServerBase.isUrlDirty();
            }
            case 24: {
                return pSPMSServerBase.isUserNameDirty();
            }
            case 25: {
                return pSPMSServerBase.isUserTagDirty();
            }
            case 26: {
                return pSPMSServerBase.isUserTag2Dirty();
            }
            case 27: {
                return pSPMSServerBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSPMSServerBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSPMSServerBase pSPMSServerBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSPMSServerBase.getAPIPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"apipath", (Object)PSPMSServerBase.getJSONValue((Object)pSPMSServerBase.getAPIPath()), (boolean)false);
        }
        if (bl || pSPMSServerBase.getAPIToken() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"apitoken", (Object)PSPMSServerBase.getJSONValue((Object)pSPMSServerBase.getAPIToken()), (boolean)false);
        }
        if (bl || pSPMSServerBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSPMSServerBase.getJSONValue((Object)pSPMSServerBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSPMSServerBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSPMSServerBase.getJSONValue((Object)pSPMSServerBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSPMSServerBase.getIpAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr", (Object)PSPMSServerBase.getJSONValue((Object)pSPMSServerBase.getIpAddr()), (boolean)false);
        }
        if (bl || pSPMSServerBase.getIpAddr2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr2", (Object)PSPMSServerBase.getJSONValue((Object)pSPMSServerBase.getIpAddr2()), (boolean)false);
        }
        if (bl || pSPMSServerBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSPMSServerBase.getJSONValue((Object)pSPMSServerBase.getMemo()), (boolean)false);
        }
        if (bl || pSPMSServerBase.getPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"passwd", (Object)PSPMSServerBase.getJSONValue((Object)pSPMSServerBase.getPasswd()), (boolean)false);
        }
        if (bl || pSPMSServerBase.getPMSPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pmspasswd", (Object)PSPMSServerBase.getJSONValue((Object)pSPMSServerBase.getPMSPasswd()), (boolean)false);
        }
        if (bl || pSPMSServerBase.getPMSUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pmsusername", (Object)PSPMSServerBase.getJSONValue((Object)pSPMSServerBase.getPMSUserName()), (boolean)false);
        }
        if (bl || pSPMSServerBase.getPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"port", (Object)PSPMSServerBase.getJSONValue((Object)pSPMSServerBase.getPort()), (boolean)false);
        }
        if (bl || pSPMSServerBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSPMSServerBase.getJSONValue((Object)pSPMSServerBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSPMSServerBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSPMSServerBase.getJSONValue((Object)pSPMSServerBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSPMSServerBase.getPSPMSServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspmsserverid", (Object)PSPMSServerBase.getJSONValue((Object)pSPMSServerBase.getPSPMSServerId()), (boolean)false);
        }
        if (bl || pSPMSServerBase.getPSPMSServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspmsservername", (Object)PSPMSServerBase.getJSONValue((Object)pSPMSServerBase.getPSPMSServerName()), (boolean)false);
        }
        if (bl || pSPMSServerBase.getPSSvrDomainId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainid", (Object)PSPMSServerBase.getJSONValue((Object)pSPMSServerBase.getPSSvrDomainId()), (boolean)false);
        }
        if (bl || pSPMSServerBase.getPSSvrDomainName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainname", (Object)PSPMSServerBase.getJSONValue((Object)pSPMSServerBase.getPSSvrDomainName()), (boolean)false);
        }
        if (bl || pSPMSServerBase.getPSTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstag", (Object)PSPMSServerBase.getJSONValue((Object)pSPMSServerBase.getPSTag()), (boolean)false);
        }
        if (bl || pSPMSServerBase.getPSTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstag2", (Object)PSPMSServerBase.getJSONValue((Object)pSPMSServerBase.getPSTag2()), (boolean)false);
        }
        if (bl || pSPMSServerBase.getPSTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstag3", (Object)PSPMSServerBase.getJSONValue((Object)pSPMSServerBase.getPSTag3()), (boolean)false);
        }
        if (bl || pSPMSServerBase.getPSTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstag4", (Object)PSPMSServerBase.getJSONValue((Object)pSPMSServerBase.getPSTag4()), (boolean)false);
        }
        if (bl || pSPMSServerBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSPMSServerBase.getJSONValue((Object)pSPMSServerBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSPMSServerBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSPMSServerBase.getJSONValue((Object)pSPMSServerBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSPMSServerBase.getUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"url", (Object)PSPMSServerBase.getJSONValue((Object)pSPMSServerBase.getUrl()), (boolean)false);
        }
        if (bl || pSPMSServerBase.getUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"username", (Object)PSPMSServerBase.getJSONValue((Object)pSPMSServerBase.getUserName()), (boolean)false);
        }
        if (bl || pSPMSServerBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSPMSServerBase.getJSONValue((Object)pSPMSServerBase.getUserTag()), (boolean)false);
        }
        if (bl || pSPMSServerBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSPMSServerBase.getJSONValue((Object)pSPMSServerBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSPMSServerBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSPMSServerBase.getJSONValue((Object)pSPMSServerBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSPMSServerBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSPMSServerBase pSPMSServerBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSPMSServerBase.getAPIPath() != null) {
            object = pSPMSServerBase.getAPIPath();
            xmlNode.setAttribute(FIELD_APIPATH, (String)(object == null ? "" : object));
        }
        if (bl || pSPMSServerBase.getAPIToken() != null) {
            object = pSPMSServerBase.getAPIToken();
            xmlNode.setAttribute(FIELD_APITOKEN, object == null ? "" : (String)object);
        }
        if (bl || pSPMSServerBase.getCreateDate() != null) {
            object = pSPMSServerBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPMSServerBase.getCreateMan() != null) {
            object = pSPMSServerBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPMSServerBase.getIpAddr() != null) {
            object = pSPMSServerBase.getIpAddr();
            xmlNode.setAttribute(FIELD_IPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSPMSServerBase.getIpAddr2() != null) {
            object = pSPMSServerBase.getIpAddr2();
            xmlNode.setAttribute(FIELD_IPADDR2, object == null ? "" : (String)object);
        }
        if (bl || pSPMSServerBase.getMemo() != null) {
            object = pSPMSServerBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSPMSServerBase.getPasswd() != null) {
            object = pSPMSServerBase.getPasswd();
            xmlNode.setAttribute(FIELD_PASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSPMSServerBase.getPMSPasswd() != null) {
            object = pSPMSServerBase.getPMSPasswd();
            xmlNode.setAttribute(FIELD_PMSPASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSPMSServerBase.getPMSUserName() != null) {
            object = pSPMSServerBase.getPMSUserName();
            xmlNode.setAttribute(FIELD_PMSUSERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPMSServerBase.getPort() != null) {
            object = pSPMSServerBase.getPort();
            xmlNode.setAttribute(FIELD_PORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPMSServerBase.getPSDevCenterId() != null) {
            object = pSPMSServerBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSPMSServerBase.getPSDevCenterName() != null) {
            object = pSPMSServerBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPMSServerBase.getPSPMSServerId() != null) {
            object = pSPMSServerBase.getPSPMSServerId();
            xmlNode.setAttribute(FIELD_PSPMSSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSPMSServerBase.getPSPMSServerName() != null) {
            object = pSPMSServerBase.getPSPMSServerName();
            xmlNode.setAttribute(FIELD_PSPMSSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPMSServerBase.getPSSvrDomainId() != null) {
            object = pSPMSServerBase.getPSSvrDomainId();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINID, object == null ? "" : (String)object);
        }
        if (bl || pSPMSServerBase.getPSSvrDomainName() != null) {
            object = pSPMSServerBase.getPSSvrDomainName();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPMSServerBase.getPSTag() != null) {
            object = pSPMSServerBase.getPSTag();
            xmlNode.setAttribute(FIELD_PSTAG, object == null ? "" : (String)object);
        }
        if (bl || pSPMSServerBase.getPSTag2() != null) {
            object = pSPMSServerBase.getPSTag2();
            xmlNode.setAttribute(FIELD_PSTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSPMSServerBase.getPSTag3() != null) {
            object = pSPMSServerBase.getPSTag3();
            xmlNode.setAttribute(FIELD_PSTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSPMSServerBase.getPSTag4() != null) {
            object = pSPMSServerBase.getPSTag4();
            xmlNode.setAttribute(FIELD_PSTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSPMSServerBase.getUpdateDate() != null) {
            object = pSPMSServerBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPMSServerBase.getUpdateMan() != null) {
            object = pSPMSServerBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPMSServerBase.getUrl() != null) {
            object = pSPMSServerBase.getUrl();
            xmlNode.setAttribute(FIELD_URL, object == null ? "" : (String)object);
        }
        if (bl || pSPMSServerBase.getUserName() != null) {
            object = pSPMSServerBase.getUserName();
            xmlNode.setAttribute(FIELD_USERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPMSServerBase.getUserTag() != null) {
            object = pSPMSServerBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSPMSServerBase.getUserTag2() != null) {
            object = pSPMSServerBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSPMSServerBase.getValidFlag() != null) {
            object = pSPMSServerBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSPMSServerBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSPMSServerBase pSPMSServerBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSPMSServerBase.isAPIPathDirty() && (bl || pSPMSServerBase.getAPIPath() != null)) {
            iDataObject.set(FIELD_APIPATH, (Object)pSPMSServerBase.getAPIPath());
        }
        if (pSPMSServerBase.isAPITokenDirty() && (bl || pSPMSServerBase.getAPIToken() != null)) {
            iDataObject.set(FIELD_APITOKEN, (Object)pSPMSServerBase.getAPIToken());
        }
        if (pSPMSServerBase.isCreateDateDirty() && (bl || pSPMSServerBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSPMSServerBase.getCreateDate());
        }
        if (pSPMSServerBase.isCreateManDirty() && (bl || pSPMSServerBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSPMSServerBase.getCreateMan());
        }
        if (pSPMSServerBase.isIpAddrDirty() && (bl || pSPMSServerBase.getIpAddr() != null)) {
            iDataObject.set(FIELD_IPADDR, (Object)pSPMSServerBase.getIpAddr());
        }
        if (pSPMSServerBase.isIpAddr2Dirty() && (bl || pSPMSServerBase.getIpAddr2() != null)) {
            iDataObject.set(FIELD_IPADDR2, (Object)pSPMSServerBase.getIpAddr2());
        }
        if (pSPMSServerBase.isMemoDirty() && (bl || pSPMSServerBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSPMSServerBase.getMemo());
        }
        if (pSPMSServerBase.isPasswdDirty() && (bl || pSPMSServerBase.getPasswd() != null)) {
            iDataObject.set(FIELD_PASSWD, (Object)pSPMSServerBase.getPasswd());
        }
        if (pSPMSServerBase.isPMSPasswdDirty() && (bl || pSPMSServerBase.getPMSPasswd() != null)) {
            iDataObject.set(FIELD_PMSPASSWD, (Object)pSPMSServerBase.getPMSPasswd());
        }
        if (pSPMSServerBase.isPMSUserNameDirty() && (bl || pSPMSServerBase.getPMSUserName() != null)) {
            iDataObject.set(FIELD_PMSUSERNAME, (Object)pSPMSServerBase.getPMSUserName());
        }
        if (pSPMSServerBase.isPortDirty() && (bl || pSPMSServerBase.getPort() != null)) {
            iDataObject.set(FIELD_PORT, (Object)pSPMSServerBase.getPort());
        }
        if (pSPMSServerBase.isPSDevCenterIdDirty() && (bl || pSPMSServerBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSPMSServerBase.getPSDevCenterId());
        }
        if (pSPMSServerBase.isPSDevCenterNameDirty() && (bl || pSPMSServerBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSPMSServerBase.getPSDevCenterName());
        }
        if (pSPMSServerBase.isPSPMSServerIdDirty() && (bl || pSPMSServerBase.getPSPMSServerId() != null)) {
            iDataObject.set(FIELD_PSPMSSERVERID, (Object)pSPMSServerBase.getPSPMSServerId());
        }
        if (pSPMSServerBase.isPSPMSServerNameDirty() && (bl || pSPMSServerBase.getPSPMSServerName() != null)) {
            iDataObject.set(FIELD_PSPMSSERVERNAME, (Object)pSPMSServerBase.getPSPMSServerName());
        }
        if (pSPMSServerBase.isPSSvrDomainIdDirty() && (bl || pSPMSServerBase.getPSSvrDomainId() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINID, (Object)pSPMSServerBase.getPSSvrDomainId());
        }
        if (pSPMSServerBase.isPSSvrDomainNameDirty() && (bl || pSPMSServerBase.getPSSvrDomainName() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINNAME, (Object)pSPMSServerBase.getPSSvrDomainName());
        }
        if (pSPMSServerBase.isPSTagDirty() && (bl || pSPMSServerBase.getPSTag() != null)) {
            iDataObject.set(FIELD_PSTAG, (Object)pSPMSServerBase.getPSTag());
        }
        if (pSPMSServerBase.isPSTag2Dirty() && (bl || pSPMSServerBase.getPSTag2() != null)) {
            iDataObject.set(FIELD_PSTAG2, (Object)pSPMSServerBase.getPSTag2());
        }
        if (pSPMSServerBase.isPSTag3Dirty() && (bl || pSPMSServerBase.getPSTag3() != null)) {
            iDataObject.set(FIELD_PSTAG3, (Object)pSPMSServerBase.getPSTag3());
        }
        if (pSPMSServerBase.isPSTag4Dirty() && (bl || pSPMSServerBase.getPSTag4() != null)) {
            iDataObject.set(FIELD_PSTAG4, (Object)pSPMSServerBase.getPSTag4());
        }
        if (pSPMSServerBase.isUpdateDateDirty() && (bl || pSPMSServerBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSPMSServerBase.getUpdateDate());
        }
        if (pSPMSServerBase.isUpdateManDirty() && (bl || pSPMSServerBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSPMSServerBase.getUpdateMan());
        }
        if (pSPMSServerBase.isUrlDirty() && (bl || pSPMSServerBase.getUrl() != null)) {
            iDataObject.set(FIELD_URL, (Object)pSPMSServerBase.getUrl());
        }
        if (pSPMSServerBase.isUserNameDirty() && (bl || pSPMSServerBase.getUserName() != null)) {
            iDataObject.set(FIELD_USERNAME, (Object)pSPMSServerBase.getUserName());
        }
        if (pSPMSServerBase.isUserTagDirty() && (bl || pSPMSServerBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSPMSServerBase.getUserTag());
        }
        if (pSPMSServerBase.isUserTag2Dirty() && (bl || pSPMSServerBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSPMSServerBase.getUserTag2());
        }
        if (pSPMSServerBase.isValidFlagDirty() && (bl || pSPMSServerBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSPMSServerBase.getValidFlag());
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
        return PSPMSServerBase.remove(this, n);
    }

    private static boolean remove(PSPMSServerBase pSPMSServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSPMSServerBase.resetAPIPath();
                return true;
            }
            case 1: {
                pSPMSServerBase.resetAPIToken();
                return true;
            }
            case 2: {
                pSPMSServerBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSPMSServerBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSPMSServerBase.resetIpAddr();
                return true;
            }
            case 5: {
                pSPMSServerBase.resetIpAddr2();
                return true;
            }
            case 6: {
                pSPMSServerBase.resetMemo();
                return true;
            }
            case 7: {
                pSPMSServerBase.resetPasswd();
                return true;
            }
            case 8: {
                pSPMSServerBase.resetPMSPasswd();
                return true;
            }
            case 9: {
                pSPMSServerBase.resetPMSUserName();
                return true;
            }
            case 10: {
                pSPMSServerBase.resetPort();
                return true;
            }
            case 11: {
                pSPMSServerBase.resetPSDevCenterId();
                return true;
            }
            case 12: {
                pSPMSServerBase.resetPSDevCenterName();
                return true;
            }
            case 13: {
                pSPMSServerBase.resetPSPMSServerId();
                return true;
            }
            case 14: {
                pSPMSServerBase.resetPSPMSServerName();
                return true;
            }
            case 15: {
                pSPMSServerBase.resetPSSvrDomainId();
                return true;
            }
            case 16: {
                pSPMSServerBase.resetPSSvrDomainName();
                return true;
            }
            case 17: {
                pSPMSServerBase.resetPSTag();
                return true;
            }
            case 18: {
                pSPMSServerBase.resetPSTag2();
                return true;
            }
            case 19: {
                pSPMSServerBase.resetPSTag3();
                return true;
            }
            case 20: {
                pSPMSServerBase.resetPSTag4();
                return true;
            }
            case 21: {
                pSPMSServerBase.resetUpdateDate();
                return true;
            }
            case 22: {
                pSPMSServerBase.resetUpdateMan();
                return true;
            }
            case 23: {
                pSPMSServerBase.resetUrl();
                return true;
            }
            case 24: {
                pSPMSServerBase.resetUserName();
                return true;
            }
            case 25: {
                pSPMSServerBase.resetUserTag();
                return true;
            }
            case 26: {
                pSPMSServerBase.resetUserTag2();
                return true;
            }
            case 27: {
                pSPMSServerBase.resetValidFlag();
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

    private PSPMSServerBase getProxyEntity() {
        return this.proxyPSPMSServerBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSPMSServerBase = null;
        if (iDataObject != null && iDataObject instanceof PSPMSServerBase) {
            this.proxyPSPMSServerBase = (PSPMSServerBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSPMSServerService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_APIPATH, 0);
        fieldIndexMap.put(FIELD_APITOKEN, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_IPADDR, 4);
        fieldIndexMap.put(FIELD_IPADDR2, 5);
        fieldIndexMap.put(FIELD_MEMO, 6);
        fieldIndexMap.put(FIELD_PASSWD, 7);
        fieldIndexMap.put(FIELD_PMSPASSWD, 8);
        fieldIndexMap.put(FIELD_PMSUSERNAME, 9);
        fieldIndexMap.put(FIELD_PORT, 10);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 11);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 12);
        fieldIndexMap.put(FIELD_PSPMSSERVERID, 13);
        fieldIndexMap.put(FIELD_PSPMSSERVERNAME, 14);
        fieldIndexMap.put(FIELD_PSSVRDOMAINID, 15);
        fieldIndexMap.put(FIELD_PSSVRDOMAINNAME, 16);
        fieldIndexMap.put(FIELD_PSTAG, 17);
        fieldIndexMap.put(FIELD_PSTAG2, 18);
        fieldIndexMap.put(FIELD_PSTAG3, 19);
        fieldIndexMap.put(FIELD_PSTAG4, 20);
        fieldIndexMap.put(FIELD_UPDATEDATE, 21);
        fieldIndexMap.put(FIELD_UPDATEMAN, 22);
        fieldIndexMap.put(FIELD_URL, 23);
        fieldIndexMap.put(FIELD_USERNAME, 24);
        fieldIndexMap.put(FIELD_USERTAG, 25);
        fieldIndexMap.put(FIELD_USERTAG2, 26);
        fieldIndexMap.put(FIELD_VALIDFLAG, 27);
    }
}

