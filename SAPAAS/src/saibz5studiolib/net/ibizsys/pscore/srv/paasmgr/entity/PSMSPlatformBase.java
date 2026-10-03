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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMSPlatform;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSMSPlatformFunc;
import net.ibizsys.pscore.srv.paasmgr.entity.PSMSPlatformNode;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain;
import net.ibizsys.pscore.srv.paasmgr.service.PSMSPlatformFuncService;
import net.ibizsys.pscore.srv.paasmgr.service.PSMSPlatformNodeService;
import net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSMSPlatformBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSMSPlatformBase.class);
    public static final String FIELD_ADMINPASSWD = "ADMINPASSWD";
    public static final String FIELD_ADMINUSERNAME = "ADMINUSERNAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_IPADDR = "IPADDR";
    public static final String FIELD_IPADDR2 = "IPADDR2";
    public static final String FIELD_LOCALRES = "LOCALRES";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MSTYPE = "MSTYPE";
    public static final String FIELD_PASSWD = "PASSWD";
    public static final String FIELD_PORT = "PORT";
    public static final String FIELD_PSMSPLATFORMID = "PSMSPLATFORMID";
    public static final String FIELD_PSMSPLATFORMNAME = "PSMSPLATFORMNAME";
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
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_IPADDR = 4;
    private static final int INDEX_IPADDR2 = 5;
    private static final int INDEX_LOCALRES = 6;
    private static final int INDEX_MEMO = 7;
    private static final int INDEX_MSTYPE = 8;
    private static final int INDEX_PASSWD = 9;
    private static final int INDEX_PORT = 10;
    private static final int INDEX_PSMSPLATFORMID = 11;
    private static final int INDEX_PSMSPLATFORMNAME = 12;
    private static final int INDEX_PSSVRDOMAINID = 13;
    private static final int INDEX_PSSVRDOMAINNAME = 14;
    private static final int INDEX_RESSTATE = 15;
    private static final int INDEX_SSHIPADDR = 16;
    private static final int INDEX_SSHPORT = 17;
    private static final int INDEX_UPDATEDATE = 18;
    private static final int INDEX_UPDATEMAN = 19;
    private static final int INDEX_UPLOADFILEMODE = 20;
    private static final int INDEX_UPLOADPATH = 21;
    private static final int INDEX_USERNAME = 22;
    private static final int INDEX_VALIDFLAG = 23;
    private static final int INDEX_WEBCONSOLEPATH = 24;
    private static final int INDEX_WORKSHOPPATH = 25;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSMSPlatformBase proxyPSMSPlatformBase = null;
    private boolean adminpasswdDirtyFlag = false;
    private boolean adminusernameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean ipaddrDirtyFlag = false;
    private boolean ipaddr2DirtyFlag = false;
    private boolean localresDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean mstypeDirtyFlag = false;
    private boolean passwdDirtyFlag = false;
    private boolean portDirtyFlag = false;
    private boolean psmsplatformidDirtyFlag = false;
    private boolean psmsplatformnameDirtyFlag = false;
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
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="ipaddr")
    private String ipaddr;
    @Column(name="ipaddr2")
    private String ipaddr2;
    @Column(name="localres")
    private Integer localres;
    @Column(name="memo")
    private String memo;
    @Column(name="mstype")
    private String mstype;
    @Column(name="passwd")
    private String passwd;
    @Column(name="port")
    private Integer port;
    @Column(name="psmsplatformid")
    private String psmsplatformid;
    @Column(name="psmsplatformname")
    private String psmsplatformname;
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
    private Integer objPSSvrDomainLock = new Integer(1);
    private PSSvrDomain pssvrdomain = null;
    private Integer objPSDCMSPlatformLock = new Integer(1);
    private ArrayList<PSDCMSPlatform> psdcmsplatform = null;
    private Integer objPSMSPlatformFuncsLock = new Integer(1);
    private ArrayList<PSMSPlatformFunc> psmsplatformfuncs = null;
    private Integer objPSMSPlatformNodesLock = new Integer(1);
    private ArrayList<PSMSPlatformNode> psmsplatformnodes = null;

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

    public void setMSType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMSType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mstype = string;
        this.mstypeDirtyFlag = true;
    }

    public String getMSType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMSType();
        }
        return this.mstype;
    }

    public boolean isMSTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMSTypeDirty();
        }
        return this.mstypeDirtyFlag;
    }

    public void resetMSType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMSType();
            return;
        }
        this.mstypeDirtyFlag = false;
        this.mstype = null;
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

    public void setPSMSPlatformId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSMSPlatformId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmsplatformid = string;
        this.psmsplatformidDirtyFlag = true;
    }

    public String getPSMSPlatformId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMSPlatformId();
        }
        return this.psmsplatformid;
    }

    public boolean isPSMSPlatformIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSMSPlatformIdDirty();
        }
        return this.psmsplatformidDirtyFlag;
    }

    public void resetPSMSPlatformId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSMSPlatformId();
            return;
        }
        this.psmsplatformidDirtyFlag = false;
        this.psmsplatformid = null;
    }

    public void setPSMSPlatformName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSMSPlatformName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmsplatformname = string;
        this.psmsplatformnameDirtyFlag = true;
    }

    public String getPSMSPlatformName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMSPlatformName();
        }
        return this.psmsplatformname;
    }

    public boolean isPSMSPlatformNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSMSPlatformNameDirty();
        }
        return this.psmsplatformnameDirtyFlag;
    }

    public void resetPSMSPlatformName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSMSPlatformName();
            return;
        }
        this.psmsplatformnameDirtyFlag = false;
        this.psmsplatformname = null;
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
        PSMSPlatformBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSMSPlatformBase pSMSPlatformBase) {
        pSMSPlatformBase.resetAdminPasswd();
        pSMSPlatformBase.resetAdminUserName();
        pSMSPlatformBase.resetCreateDate();
        pSMSPlatformBase.resetCreateMan();
        pSMSPlatformBase.resetIpAddr();
        pSMSPlatformBase.resetIpAddr2();
        pSMSPlatformBase.resetLocalRes();
        pSMSPlatformBase.resetMemo();
        pSMSPlatformBase.resetMSType();
        pSMSPlatformBase.resetPasswd();
        pSMSPlatformBase.resetPort();
        pSMSPlatformBase.resetPSMSPlatformId();
        pSMSPlatformBase.resetPSMSPlatformName();
        pSMSPlatformBase.resetPSSvrDomainId();
        pSMSPlatformBase.resetPSSvrDomainName();
        pSMSPlatformBase.resetResState();
        pSMSPlatformBase.resetSSHIPAddr();
        pSMSPlatformBase.resetSSHPort();
        pSMSPlatformBase.resetUpdateDate();
        pSMSPlatformBase.resetUpdateMan();
        pSMSPlatformBase.resetUploadFileMode();
        pSMSPlatformBase.resetUploadPath();
        pSMSPlatformBase.resetUserName();
        pSMSPlatformBase.resetValidFlag();
        pSMSPlatformBase.resetWebConsolePath();
        pSMSPlatformBase.resetWorkshopPath();
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
        if (!bl || this.isMSTypeDirty()) {
            hashMap.put(FIELD_MSTYPE, this.getMSType());
        }
        if (!bl || this.isPasswdDirty()) {
            hashMap.put(FIELD_PASSWD, this.getPasswd());
        }
        if (!bl || this.isPortDirty()) {
            hashMap.put(FIELD_PORT, this.getPort());
        }
        if (!bl || this.isPSMSPlatformIdDirty()) {
            hashMap.put(FIELD_PSMSPLATFORMID, this.getPSMSPlatformId());
        }
        if (!bl || this.isPSMSPlatformNameDirty()) {
            hashMap.put(FIELD_PSMSPLATFORMNAME, this.getPSMSPlatformName());
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
        return PSMSPlatformBase.get(this, n);
    }

    private static Object get(PSMSPlatformBase pSMSPlatformBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSMSPlatformBase.getAdminPasswd();
            }
            case 1: {
                return pSMSPlatformBase.getAdminUserName();
            }
            case 2: {
                return pSMSPlatformBase.getCreateDate();
            }
            case 3: {
                return pSMSPlatformBase.getCreateMan();
            }
            case 4: {
                return pSMSPlatformBase.getIpAddr();
            }
            case 5: {
                return pSMSPlatformBase.getIpAddr2();
            }
            case 6: {
                return pSMSPlatformBase.getLocalRes();
            }
            case 7: {
                return pSMSPlatformBase.getMemo();
            }
            case 8: {
                return pSMSPlatformBase.getMSType();
            }
            case 9: {
                return pSMSPlatformBase.getPasswd();
            }
            case 10: {
                return pSMSPlatformBase.getPort();
            }
            case 11: {
                return pSMSPlatformBase.getPSMSPlatformId();
            }
            case 12: {
                return pSMSPlatformBase.getPSMSPlatformName();
            }
            case 13: {
                return pSMSPlatformBase.getPSSvrDomainId();
            }
            case 14: {
                return pSMSPlatformBase.getPSSvrDomainName();
            }
            case 15: {
                return pSMSPlatformBase.getResState();
            }
            case 16: {
                return pSMSPlatformBase.getSSHIPAddr();
            }
            case 17: {
                return pSMSPlatformBase.getSSHPort();
            }
            case 18: {
                return pSMSPlatformBase.getUpdateDate();
            }
            case 19: {
                return pSMSPlatformBase.getUpdateMan();
            }
            case 20: {
                return pSMSPlatformBase.getUploadFileMode();
            }
            case 21: {
                return pSMSPlatformBase.getUploadPath();
            }
            case 22: {
                return pSMSPlatformBase.getUserName();
            }
            case 23: {
                return pSMSPlatformBase.getValidFlag();
            }
            case 24: {
                return pSMSPlatformBase.getWebConsolePath();
            }
            case 25: {
                return pSMSPlatformBase.getWorkshopPath();
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
        PSMSPlatformBase.set(this, n, object);
    }

    private static void set(PSMSPlatformBase pSMSPlatformBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSMSPlatformBase.setAdminPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSMSPlatformBase.setAdminUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSMSPlatformBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSMSPlatformBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSMSPlatformBase.setIpAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSMSPlatformBase.setIpAddr2(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSMSPlatformBase.setLocalRes(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSMSPlatformBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSMSPlatformBase.setMSType(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSMSPlatformBase.setPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSMSPlatformBase.setPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSMSPlatformBase.setPSMSPlatformId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSMSPlatformBase.setPSMSPlatformName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSMSPlatformBase.setPSSvrDomainId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSMSPlatformBase.setPSSvrDomainName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSMSPlatformBase.setResState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSMSPlatformBase.setSSHIPAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSMSPlatformBase.setSSHPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSMSPlatformBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 19: {
                pSMSPlatformBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSMSPlatformBase.setUploadFileMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSMSPlatformBase.setUploadPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSMSPlatformBase.setUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSMSPlatformBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 24: {
                pSMSPlatformBase.setWebConsolePath(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSMSPlatformBase.setWorkshopPath(DataObject.getStringValue((Object)object));
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
        return PSMSPlatformBase.isNull(this, n);
    }

    private static boolean isNull(PSMSPlatformBase pSMSPlatformBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSMSPlatformBase.getAdminPasswd() == null;
            }
            case 1: {
                return pSMSPlatformBase.getAdminUserName() == null;
            }
            case 2: {
                return pSMSPlatformBase.getCreateDate() == null;
            }
            case 3: {
                return pSMSPlatformBase.getCreateMan() == null;
            }
            case 4: {
                return pSMSPlatformBase.getIpAddr() == null;
            }
            case 5: {
                return pSMSPlatformBase.getIpAddr2() == null;
            }
            case 6: {
                return pSMSPlatformBase.getLocalRes() == null;
            }
            case 7: {
                return pSMSPlatformBase.getMemo() == null;
            }
            case 8: {
                return pSMSPlatformBase.getMSType() == null;
            }
            case 9: {
                return pSMSPlatformBase.getPasswd() == null;
            }
            case 10: {
                return pSMSPlatformBase.getPort() == null;
            }
            case 11: {
                return pSMSPlatformBase.getPSMSPlatformId() == null;
            }
            case 12: {
                return pSMSPlatformBase.getPSMSPlatformName() == null;
            }
            case 13: {
                return pSMSPlatformBase.getPSSvrDomainId() == null;
            }
            case 14: {
                return pSMSPlatformBase.getPSSvrDomainName() == null;
            }
            case 15: {
                return pSMSPlatformBase.getResState() == null;
            }
            case 16: {
                return pSMSPlatformBase.getSSHIPAddr() == null;
            }
            case 17: {
                return pSMSPlatformBase.getSSHPort() == null;
            }
            case 18: {
                return pSMSPlatformBase.getUpdateDate() == null;
            }
            case 19: {
                return pSMSPlatformBase.getUpdateMan() == null;
            }
            case 20: {
                return pSMSPlatformBase.getUploadFileMode() == null;
            }
            case 21: {
                return pSMSPlatformBase.getUploadPath() == null;
            }
            case 22: {
                return pSMSPlatformBase.getUserName() == null;
            }
            case 23: {
                return pSMSPlatformBase.getValidFlag() == null;
            }
            case 24: {
                return pSMSPlatformBase.getWebConsolePath() == null;
            }
            case 25: {
                return pSMSPlatformBase.getWorkshopPath() == null;
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
        return PSMSPlatformBase.contains(this, n);
    }

    private static boolean contains(PSMSPlatformBase pSMSPlatformBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSMSPlatformBase.isAdminPasswdDirty();
            }
            case 1: {
                return pSMSPlatformBase.isAdminUserNameDirty();
            }
            case 2: {
                return pSMSPlatformBase.isCreateDateDirty();
            }
            case 3: {
                return pSMSPlatformBase.isCreateManDirty();
            }
            case 4: {
                return pSMSPlatformBase.isIpAddrDirty();
            }
            case 5: {
                return pSMSPlatformBase.isIpAddr2Dirty();
            }
            case 6: {
                return pSMSPlatformBase.isLocalResDirty();
            }
            case 7: {
                return pSMSPlatformBase.isMemoDirty();
            }
            case 8: {
                return pSMSPlatformBase.isMSTypeDirty();
            }
            case 9: {
                return pSMSPlatformBase.isPasswdDirty();
            }
            case 10: {
                return pSMSPlatformBase.isPortDirty();
            }
            case 11: {
                return pSMSPlatformBase.isPSMSPlatformIdDirty();
            }
            case 12: {
                return pSMSPlatformBase.isPSMSPlatformNameDirty();
            }
            case 13: {
                return pSMSPlatformBase.isPSSvrDomainIdDirty();
            }
            case 14: {
                return pSMSPlatformBase.isPSSvrDomainNameDirty();
            }
            case 15: {
                return pSMSPlatformBase.isResStateDirty();
            }
            case 16: {
                return pSMSPlatformBase.isSSHIPAddrDirty();
            }
            case 17: {
                return pSMSPlatformBase.isSSHPortDirty();
            }
            case 18: {
                return pSMSPlatformBase.isUpdateDateDirty();
            }
            case 19: {
                return pSMSPlatformBase.isUpdateManDirty();
            }
            case 20: {
                return pSMSPlatformBase.isUploadFileModeDirty();
            }
            case 21: {
                return pSMSPlatformBase.isUploadPathDirty();
            }
            case 22: {
                return pSMSPlatformBase.isUserNameDirty();
            }
            case 23: {
                return pSMSPlatformBase.isValidFlagDirty();
            }
            case 24: {
                return pSMSPlatformBase.isWebConsolePathDirty();
            }
            case 25: {
                return pSMSPlatformBase.isWorkshopPathDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSMSPlatformBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSMSPlatformBase pSMSPlatformBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSMSPlatformBase.getAdminPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"adminpasswd", (Object)PSMSPlatformBase.getJSONValue((Object)pSMSPlatformBase.getAdminPasswd()), (boolean)false);
        }
        if (bl || pSMSPlatformBase.getAdminUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"adminusername", (Object)PSMSPlatformBase.getJSONValue((Object)pSMSPlatformBase.getAdminUserName()), (boolean)false);
        }
        if (bl || pSMSPlatformBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSMSPlatformBase.getJSONValue((Object)pSMSPlatformBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSMSPlatformBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSMSPlatformBase.getJSONValue((Object)pSMSPlatformBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSMSPlatformBase.getIpAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr", (Object)PSMSPlatformBase.getJSONValue((Object)pSMSPlatformBase.getIpAddr()), (boolean)false);
        }
        if (bl || pSMSPlatformBase.getIpAddr2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr2", (Object)PSMSPlatformBase.getJSONValue((Object)pSMSPlatformBase.getIpAddr2()), (boolean)false);
        }
        if (bl || pSMSPlatformBase.getLocalRes() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"localres", (Object)PSMSPlatformBase.getJSONValue((Object)pSMSPlatformBase.getLocalRes()), (boolean)false);
        }
        if (bl || pSMSPlatformBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSMSPlatformBase.getJSONValue((Object)pSMSPlatformBase.getMemo()), (boolean)false);
        }
        if (bl || pSMSPlatformBase.getMSType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mstype", (Object)PSMSPlatformBase.getJSONValue((Object)pSMSPlatformBase.getMSType()), (boolean)false);
        }
        if (bl || pSMSPlatformBase.getPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"passwd", (Object)PSMSPlatformBase.getJSONValue((Object)pSMSPlatformBase.getPasswd()), (boolean)false);
        }
        if (bl || pSMSPlatformBase.getPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"port", (Object)PSMSPlatformBase.getJSONValue((Object)pSMSPlatformBase.getPort()), (boolean)false);
        }
        if (bl || pSMSPlatformBase.getPSMSPlatformId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmsplatformid", (Object)PSMSPlatformBase.getJSONValue((Object)pSMSPlatformBase.getPSMSPlatformId()), (boolean)false);
        }
        if (bl || pSMSPlatformBase.getPSMSPlatformName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmsplatformname", (Object)PSMSPlatformBase.getJSONValue((Object)pSMSPlatformBase.getPSMSPlatformName()), (boolean)false);
        }
        if (bl || pSMSPlatformBase.getPSSvrDomainId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainid", (Object)PSMSPlatformBase.getJSONValue((Object)pSMSPlatformBase.getPSSvrDomainId()), (boolean)false);
        }
        if (bl || pSMSPlatformBase.getPSSvrDomainName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainname", (Object)PSMSPlatformBase.getJSONValue((Object)pSMSPlatformBase.getPSSvrDomainName()), (boolean)false);
        }
        if (bl || pSMSPlatformBase.getResState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resstate", (Object)PSMSPlatformBase.getJSONValue((Object)pSMSPlatformBase.getResState()), (boolean)false);
        }
        if (bl || pSMSPlatformBase.getSSHIPAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sshipaddr", (Object)PSMSPlatformBase.getJSONValue((Object)pSMSPlatformBase.getSSHIPAddr()), (boolean)false);
        }
        if (bl || pSMSPlatformBase.getSSHPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sshport", (Object)PSMSPlatformBase.getJSONValue((Object)pSMSPlatformBase.getSSHPort()), (boolean)false);
        }
        if (bl || pSMSPlatformBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSMSPlatformBase.getJSONValue((Object)pSMSPlatformBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSMSPlatformBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSMSPlatformBase.getJSONValue((Object)pSMSPlatformBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSMSPlatformBase.getUploadFileMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uploadfilemode", (Object)PSMSPlatformBase.getJSONValue((Object)pSMSPlatformBase.getUploadFileMode()), (boolean)false);
        }
        if (bl || pSMSPlatformBase.getUploadPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uploadpath", (Object)PSMSPlatformBase.getJSONValue((Object)pSMSPlatformBase.getUploadPath()), (boolean)false);
        }
        if (bl || pSMSPlatformBase.getUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"username", (Object)PSMSPlatformBase.getJSONValue((Object)pSMSPlatformBase.getUserName()), (boolean)false);
        }
        if (bl || pSMSPlatformBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSMSPlatformBase.getJSONValue((Object)pSMSPlatformBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSMSPlatformBase.getWebConsolePath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"webconsolepath", (Object)PSMSPlatformBase.getJSONValue((Object)pSMSPlatformBase.getWebConsolePath()), (boolean)false);
        }
        if (bl || pSMSPlatformBase.getWorkshopPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"workshoppath", (Object)PSMSPlatformBase.getJSONValue((Object)pSMSPlatformBase.getWorkshopPath()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSMSPlatformBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSMSPlatformBase pSMSPlatformBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSMSPlatformBase.getAdminPasswd() != null) {
            object = pSMSPlatformBase.getAdminPasswd();
            xmlNode.setAttribute(FIELD_ADMINPASSWD, (String)(object == null ? "" : object));
        }
        if (bl || pSMSPlatformBase.getAdminUserName() != null) {
            object = pSMSPlatformBase.getAdminUserName();
            xmlNode.setAttribute(FIELD_ADMINUSERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSMSPlatformBase.getCreateDate() != null) {
            object = pSMSPlatformBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSMSPlatformBase.getCreateMan() != null) {
            object = pSMSPlatformBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSMSPlatformBase.getIpAddr() != null) {
            object = pSMSPlatformBase.getIpAddr();
            xmlNode.setAttribute(FIELD_IPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSMSPlatformBase.getIpAddr2() != null) {
            object = pSMSPlatformBase.getIpAddr2();
            xmlNode.setAttribute(FIELD_IPADDR2, object == null ? "" : (String)object);
        }
        if (bl || pSMSPlatformBase.getLocalRes() != null) {
            object = pSMSPlatformBase.getLocalRes();
            xmlNode.setAttribute(FIELD_LOCALRES, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSMSPlatformBase.getMemo() != null) {
            object = pSMSPlatformBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSMSPlatformBase.getMSType() != null) {
            object = pSMSPlatformBase.getMSType();
            xmlNode.setAttribute(FIELD_MSTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSMSPlatformBase.getPasswd() != null) {
            object = pSMSPlatformBase.getPasswd();
            xmlNode.setAttribute(FIELD_PASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSMSPlatformBase.getPort() != null) {
            object = pSMSPlatformBase.getPort();
            xmlNode.setAttribute(FIELD_PORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSMSPlatformBase.getPSMSPlatformId() != null) {
            object = pSMSPlatformBase.getPSMSPlatformId();
            xmlNode.setAttribute(FIELD_PSMSPLATFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSMSPlatformBase.getPSMSPlatformName() != null) {
            object = pSMSPlatformBase.getPSMSPlatformName();
            xmlNode.setAttribute(FIELD_PSMSPLATFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSMSPlatformBase.getPSSvrDomainId() != null) {
            object = pSMSPlatformBase.getPSSvrDomainId();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINID, object == null ? "" : (String)object);
        }
        if (bl || pSMSPlatformBase.getPSSvrDomainName() != null) {
            object = pSMSPlatformBase.getPSSvrDomainName();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSMSPlatformBase.getResState() != null) {
            object = pSMSPlatformBase.getResState();
            xmlNode.setAttribute(FIELD_RESSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSMSPlatformBase.getSSHIPAddr() != null) {
            object = pSMSPlatformBase.getSSHIPAddr();
            xmlNode.setAttribute(FIELD_SSHIPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSMSPlatformBase.getSSHPort() != null) {
            object = pSMSPlatformBase.getSSHPort();
            xmlNode.setAttribute(FIELD_SSHPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSMSPlatformBase.getUpdateDate() != null) {
            object = pSMSPlatformBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSMSPlatformBase.getUpdateMan() != null) {
            object = pSMSPlatformBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSMSPlatformBase.getUploadFileMode() != null) {
            object = pSMSPlatformBase.getUploadFileMode();
            xmlNode.setAttribute(FIELD_UPLOADFILEMODE, object == null ? "" : (String)object);
        }
        if (bl || pSMSPlatformBase.getUploadPath() != null) {
            object = pSMSPlatformBase.getUploadPath();
            xmlNode.setAttribute(FIELD_UPLOADPATH, object == null ? "" : (String)object);
        }
        if (bl || pSMSPlatformBase.getUserName() != null) {
            object = pSMSPlatformBase.getUserName();
            xmlNode.setAttribute(FIELD_USERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSMSPlatformBase.getValidFlag() != null) {
            object = pSMSPlatformBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSMSPlatformBase.getWebConsolePath() != null) {
            object = pSMSPlatformBase.getWebConsolePath();
            xmlNode.setAttribute(FIELD_WEBCONSOLEPATH, object == null ? "" : (String)object);
        }
        if (bl || pSMSPlatformBase.getWorkshopPath() != null) {
            object = pSMSPlatformBase.getWorkshopPath();
            xmlNode.setAttribute(FIELD_WORKSHOPPATH, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSMSPlatformBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSMSPlatformBase pSMSPlatformBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSMSPlatformBase.isAdminPasswdDirty() && (bl || pSMSPlatformBase.getAdminPasswd() != null)) {
            iDataObject.set(FIELD_ADMINPASSWD, (Object)pSMSPlatformBase.getAdminPasswd());
        }
        if (pSMSPlatformBase.isAdminUserNameDirty() && (bl || pSMSPlatformBase.getAdminUserName() != null)) {
            iDataObject.set(FIELD_ADMINUSERNAME, (Object)pSMSPlatformBase.getAdminUserName());
        }
        if (pSMSPlatformBase.isCreateDateDirty() && (bl || pSMSPlatformBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSMSPlatformBase.getCreateDate());
        }
        if (pSMSPlatformBase.isCreateManDirty() && (bl || pSMSPlatformBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSMSPlatformBase.getCreateMan());
        }
        if (pSMSPlatformBase.isIpAddrDirty() && (bl || pSMSPlatformBase.getIpAddr() != null)) {
            iDataObject.set(FIELD_IPADDR, (Object)pSMSPlatformBase.getIpAddr());
        }
        if (pSMSPlatformBase.isIpAddr2Dirty() && (bl || pSMSPlatformBase.getIpAddr2() != null)) {
            iDataObject.set(FIELD_IPADDR2, (Object)pSMSPlatformBase.getIpAddr2());
        }
        if (pSMSPlatformBase.isLocalResDirty() && (bl || pSMSPlatformBase.getLocalRes() != null)) {
            iDataObject.set(FIELD_LOCALRES, (Object)pSMSPlatformBase.getLocalRes());
        }
        if (pSMSPlatformBase.isMemoDirty() && (bl || pSMSPlatformBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSMSPlatformBase.getMemo());
        }
        if (pSMSPlatformBase.isMSTypeDirty() && (bl || pSMSPlatformBase.getMSType() != null)) {
            iDataObject.set(FIELD_MSTYPE, (Object)pSMSPlatformBase.getMSType());
        }
        if (pSMSPlatformBase.isPasswdDirty() && (bl || pSMSPlatformBase.getPasswd() != null)) {
            iDataObject.set(FIELD_PASSWD, (Object)pSMSPlatformBase.getPasswd());
        }
        if (pSMSPlatformBase.isPortDirty() && (bl || pSMSPlatformBase.getPort() != null)) {
            iDataObject.set(FIELD_PORT, (Object)pSMSPlatformBase.getPort());
        }
        if (pSMSPlatformBase.isPSMSPlatformIdDirty() && (bl || pSMSPlatformBase.getPSMSPlatformId() != null)) {
            iDataObject.set(FIELD_PSMSPLATFORMID, (Object)pSMSPlatformBase.getPSMSPlatformId());
        }
        if (pSMSPlatformBase.isPSMSPlatformNameDirty() && (bl || pSMSPlatformBase.getPSMSPlatformName() != null)) {
            iDataObject.set(FIELD_PSMSPLATFORMNAME, (Object)pSMSPlatformBase.getPSMSPlatformName());
        }
        if (pSMSPlatformBase.isPSSvrDomainIdDirty() && (bl || pSMSPlatformBase.getPSSvrDomainId() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINID, (Object)pSMSPlatformBase.getPSSvrDomainId());
        }
        if (pSMSPlatformBase.isPSSvrDomainNameDirty() && (bl || pSMSPlatformBase.getPSSvrDomainName() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINNAME, (Object)pSMSPlatformBase.getPSSvrDomainName());
        }
        if (pSMSPlatformBase.isResStateDirty() && (bl || pSMSPlatformBase.getResState() != null)) {
            iDataObject.set(FIELD_RESSTATE, (Object)pSMSPlatformBase.getResState());
        }
        if (pSMSPlatformBase.isSSHIPAddrDirty() && (bl || pSMSPlatformBase.getSSHIPAddr() != null)) {
            iDataObject.set(FIELD_SSHIPADDR, (Object)pSMSPlatformBase.getSSHIPAddr());
        }
        if (pSMSPlatformBase.isSSHPortDirty() && (bl || pSMSPlatformBase.getSSHPort() != null)) {
            iDataObject.set(FIELD_SSHPORT, (Object)pSMSPlatformBase.getSSHPort());
        }
        if (pSMSPlatformBase.isUpdateDateDirty() && (bl || pSMSPlatformBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSMSPlatformBase.getUpdateDate());
        }
        if (pSMSPlatformBase.isUpdateManDirty() && (bl || pSMSPlatformBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSMSPlatformBase.getUpdateMan());
        }
        if (pSMSPlatformBase.isUploadFileModeDirty() && (bl || pSMSPlatformBase.getUploadFileMode() != null)) {
            iDataObject.set(FIELD_UPLOADFILEMODE, (Object)pSMSPlatformBase.getUploadFileMode());
        }
        if (pSMSPlatformBase.isUploadPathDirty() && (bl || pSMSPlatformBase.getUploadPath() != null)) {
            iDataObject.set(FIELD_UPLOADPATH, (Object)pSMSPlatformBase.getUploadPath());
        }
        if (pSMSPlatformBase.isUserNameDirty() && (bl || pSMSPlatformBase.getUserName() != null)) {
            iDataObject.set(FIELD_USERNAME, (Object)pSMSPlatformBase.getUserName());
        }
        if (pSMSPlatformBase.isValidFlagDirty() && (bl || pSMSPlatformBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSMSPlatformBase.getValidFlag());
        }
        if (pSMSPlatformBase.isWebConsolePathDirty() && (bl || pSMSPlatformBase.getWebConsolePath() != null)) {
            iDataObject.set(FIELD_WEBCONSOLEPATH, (Object)pSMSPlatformBase.getWebConsolePath());
        }
        if (pSMSPlatformBase.isWorkshopPathDirty() && (bl || pSMSPlatformBase.getWorkshopPath() != null)) {
            iDataObject.set(FIELD_WORKSHOPPATH, (Object)pSMSPlatformBase.getWorkshopPath());
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
        return PSMSPlatformBase.remove(this, n);
    }

    private static boolean remove(PSMSPlatformBase pSMSPlatformBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSMSPlatformBase.resetAdminPasswd();
                return true;
            }
            case 1: {
                pSMSPlatformBase.resetAdminUserName();
                return true;
            }
            case 2: {
                pSMSPlatformBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSMSPlatformBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSMSPlatformBase.resetIpAddr();
                return true;
            }
            case 5: {
                pSMSPlatformBase.resetIpAddr2();
                return true;
            }
            case 6: {
                pSMSPlatformBase.resetLocalRes();
                return true;
            }
            case 7: {
                pSMSPlatformBase.resetMemo();
                return true;
            }
            case 8: {
                pSMSPlatformBase.resetMSType();
                return true;
            }
            case 9: {
                pSMSPlatformBase.resetPasswd();
                return true;
            }
            case 10: {
                pSMSPlatformBase.resetPort();
                return true;
            }
            case 11: {
                pSMSPlatformBase.resetPSMSPlatformId();
                return true;
            }
            case 12: {
                pSMSPlatformBase.resetPSMSPlatformName();
                return true;
            }
            case 13: {
                pSMSPlatformBase.resetPSSvrDomainId();
                return true;
            }
            case 14: {
                pSMSPlatformBase.resetPSSvrDomainName();
                return true;
            }
            case 15: {
                pSMSPlatformBase.resetResState();
                return true;
            }
            case 16: {
                pSMSPlatformBase.resetSSHIPAddr();
                return true;
            }
            case 17: {
                pSMSPlatformBase.resetSSHPort();
                return true;
            }
            case 18: {
                pSMSPlatformBase.resetUpdateDate();
                return true;
            }
            case 19: {
                pSMSPlatformBase.resetUpdateMan();
                return true;
            }
            case 20: {
                pSMSPlatformBase.resetUploadFileMode();
                return true;
            }
            case 21: {
                pSMSPlatformBase.resetUploadPath();
                return true;
            }
            case 22: {
                pSMSPlatformBase.resetUserName();
                return true;
            }
            case 23: {
                pSMSPlatformBase.resetValidFlag();
                return true;
            }
            case 24: {
                pSMSPlatformBase.resetWebConsolePath();
                return true;
            }
            case 25: {
                pSMSPlatformBase.resetWorkshopPath();
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
                pSSvrDomainService.autoGet(pSSvrDomain);
                this.pssvrdomain = pSSvrDomain;
            }
            return this.pssvrdomain;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDCMSPlatform> getPSDCMSPlatform() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMSPlatform();
        }
        if (this.getPSMSPlatformId() == null) {
            return null;
        }
        PSDCMSPlatformService pSDCMSPlatformService = (PSDCMSPlatformService)ServiceGlobal.getService(PSDCMSPlatformService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDCMSPlatformLock;
        synchronized (n) {
            if (this.psdcmsplatform == null) {
                this.psdcmsplatform = pSDCMSPlatformService.selectByPSMSPlatform(this);
            }
            return this.psdcmsplatform;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSMSPlatformFunc> getPSMSPlatformFuncs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMSPlatformFuncs();
        }
        if (this.getPSMSPlatformId() == null) {
            return null;
        }
        PSMSPlatformFuncService pSMSPlatformFuncService = (PSMSPlatformFuncService)ServiceGlobal.getService(PSMSPlatformFuncService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSMSPlatformFuncsLock;
        synchronized (n) {
            if (this.psmsplatformfuncs == null) {
                this.psmsplatformfuncs = pSMSPlatformFuncService.selectByPSMSPlatform(this);
            }
            return this.psmsplatformfuncs;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSMSPlatformNode> getPSMSPlatformNodes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMSPlatformNodes();
        }
        if (this.getPSMSPlatformId() == null) {
            return null;
        }
        PSMSPlatformNodeService pSMSPlatformNodeService = (PSMSPlatformNodeService)ServiceGlobal.getService(PSMSPlatformNodeService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSMSPlatformNodesLock;
        synchronized (n) {
            if (this.psmsplatformnodes == null) {
                this.psmsplatformnodes = pSMSPlatformNodeService.selectByPSMSPlatform(this);
            }
            return this.psmsplatformnodes;
        }
    }

    private PSMSPlatformBase getProxyEntity() {
        return this.proxyPSMSPlatformBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSMSPlatformBase = null;
        if (iDataObject != null && iDataObject instanceof PSMSPlatformBase) {
            this.proxyPSMSPlatformBase = (PSMSPlatformBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSMSPlatformService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ADMINPASSWD, 0);
        fieldIndexMap.put(FIELD_ADMINUSERNAME, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_IPADDR, 4);
        fieldIndexMap.put(FIELD_IPADDR2, 5);
        fieldIndexMap.put(FIELD_LOCALRES, 6);
        fieldIndexMap.put(FIELD_MEMO, 7);
        fieldIndexMap.put(FIELD_MSTYPE, 8);
        fieldIndexMap.put(FIELD_PASSWD, 9);
        fieldIndexMap.put(FIELD_PORT, 10);
        fieldIndexMap.put(FIELD_PSMSPLATFORMID, 11);
        fieldIndexMap.put(FIELD_PSMSPLATFORMNAME, 12);
        fieldIndexMap.put(FIELD_PSSVRDOMAINID, 13);
        fieldIndexMap.put(FIELD_PSSVRDOMAINNAME, 14);
        fieldIndexMap.put(FIELD_RESSTATE, 15);
        fieldIndexMap.put(FIELD_SSHIPADDR, 16);
        fieldIndexMap.put(FIELD_SSHPORT, 17);
        fieldIndexMap.put(FIELD_UPDATEDATE, 18);
        fieldIndexMap.put(FIELD_UPDATEMAN, 19);
        fieldIndexMap.put(FIELD_UPLOADFILEMODE, 20);
        fieldIndexMap.put(FIELD_UPLOADPATH, 21);
        fieldIndexMap.put(FIELD_USERNAME, 22);
        fieldIndexMap.put(FIELD_VALIDFLAG, 23);
        fieldIndexMap.put(FIELD_WEBCONSOLEPATH, 24);
        fieldIndexMap.put(FIELD_WORKSHOPPATH, 25);
    }
}

