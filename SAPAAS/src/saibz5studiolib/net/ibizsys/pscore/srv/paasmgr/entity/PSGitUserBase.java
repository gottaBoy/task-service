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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSVNServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain;
import net.ibizsys.pscore.srv.paasmgr.service.PSSVNServerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSGitUserBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSGitUserBase.class);
    public static final String FIELD_ALLDCFLAG = "ALLDCFLAG";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CREDENTIALSYNCMODE = "CREDENTIALSYNCMODE";
    public static final String FIELD_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String FIELD_EMAIL = "EMAIL";
    public static final String FIELD_GITPATH = "GITPATH";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PASSWD = "PASSWD";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSGITUSERID = "PSGITUSERID";
    public static final String FIELD_PSGITUSERNAME = "PSGITUSERNAME";
    public static final String FIELD_PSSVNSERVERID = "PSSVNSERVERID";
    public static final String FIELD_PSSVNSERVERNAME = "PSSVNSERVERNAME";
    public static final String FIELD_PSSVRDOMAINID = "PSSVRDOMAINID";
    public static final String FIELD_PSSVRDOMAINNAME = "PSSVRDOMAINNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERNAME = "USERNAME";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_ALLDCFLAG = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_CREDENTIALSYNCMODE = 3;
    private static final int INDEX_DEFAULTFLAG = 4;
    private static final int INDEX_EMAIL = 5;
    private static final int INDEX_GITPATH = 6;
    private static final int INDEX_MEMO = 7;
    private static final int INDEX_PASSWD = 8;
    private static final int INDEX_PSDEVCENTERID = 9;
    private static final int INDEX_PSDEVCENTERNAME = 10;
    private static final int INDEX_PSGITUSERID = 11;
    private static final int INDEX_PSGITUSERNAME = 12;
    private static final int INDEX_PSSVNSERVERID = 13;
    private static final int INDEX_PSSVNSERVERNAME = 14;
    private static final int INDEX_PSSVRDOMAINID = 15;
    private static final int INDEX_PSSVRDOMAINNAME = 16;
    private static final int INDEX_UPDATEDATE = 17;
    private static final int INDEX_UPDATEMAN = 18;
    private static final int INDEX_USERNAME = 19;
    private static final int INDEX_VALIDFLAG = 20;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSGitUserBase proxyPSGitUserBase = null;
    private boolean alldcflagDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean credentialsyncmodeDirtyFlag = false;
    private boolean defaultflagDirtyFlag = false;
    private boolean emailDirtyFlag = false;
    private boolean gitpathDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean passwdDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psgituseridDirtyFlag = false;
    private boolean psgitusernameDirtyFlag = false;
    private boolean pssvnserveridDirtyFlag = false;
    private boolean pssvnservernameDirtyFlag = false;
    private boolean pssvrdomainidDirtyFlag = false;
    private boolean pssvrdomainnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usernameDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="alldcflag")
    private Integer alldcflag;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="credentialsyncmode")
    private Integer credentialsyncmode;
    @Column(name="defaultflag")
    private Integer defaultflag;
    @Column(name="email")
    private String email;
    @Column(name="gitpath")
    private String gitpath;
    @Column(name="memo")
    private String memo;
    @Column(name="passwd")
    private String passwd;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psgituserid")
    private String psgituserid;
    @Column(name="psgitusername")
    private String psgitusername;
    @Column(name="pssvnserverid")
    private String pssvnserverid;
    @Column(name="pssvnservername")
    private String pssvnservername;
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
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPssvnserverLock = new Integer(1);
    private PSSVNServer pssvnserver = null;
    private Integer objPSSvrDomainLock = new Integer(1);
    private PSSvrDomain pssvrdomain = null;

    public void setAllDCFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAllDCFlag(n);
            return;
        }
        this.alldcflag = n;
        this.alldcflagDirtyFlag = true;
    }

    public Integer getAllDCFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAllDCFlag();
        }
        return this.alldcflag;
    }

    public boolean isAllDCFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAllDCFlagDirty();
        }
        return this.alldcflagDirtyFlag;
    }

    public void resetAllDCFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAllDCFlag();
            return;
        }
        this.alldcflagDirtyFlag = false;
        this.alldcflag = null;
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

    public void setCredentialSyncMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCredentialSyncMode(n);
            return;
        }
        this.credentialsyncmode = n;
        this.credentialsyncmodeDirtyFlag = true;
    }

    public Integer getCredentialSyncMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCredentialSyncMode();
        }
        return this.credentialsyncmode;
    }

    public boolean isCredentialSyncModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCredentialSyncModeDirty();
        }
        return this.credentialsyncmodeDirtyFlag;
    }

    public void resetCredentialSyncMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCredentialSyncMode();
            return;
        }
        this.credentialsyncmodeDirtyFlag = false;
        this.credentialsyncmode = null;
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

    public void setEmail(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEmail(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.email = string;
        this.emailDirtyFlag = true;
    }

    public String getEmail() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEmail();
        }
        return this.email;
    }

    public boolean isEmailDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEmailDirty();
        }
        return this.emailDirtyFlag;
    }

    public void resetEmail() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEmail();
            return;
        }
        this.emailDirtyFlag = false;
        this.email = null;
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

    public void setPSGitUserId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSGitUserId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psgituserid = string;
        this.psgituseridDirtyFlag = true;
    }

    public String getPSGitUserId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSGitUserId();
        }
        return this.psgituserid;
    }

    public boolean isPSGitUserIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSGitUserIdDirty();
        }
        return this.psgituseridDirtyFlag;
    }

    public void resetPSGitUserId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSGitUserId();
            return;
        }
        this.psgituseridDirtyFlag = false;
        this.psgituserid = null;
    }

    public void setPSGitUserName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSGitUserName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psgitusername = string;
        this.psgitusernameDirtyFlag = true;
    }

    public String getPSGitUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSGitUserName();
        }
        return this.psgitusername;
    }

    public boolean isPSGitUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSGitUserNameDirty();
        }
        return this.psgitusernameDirtyFlag;
    }

    public void resetPSGitUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSGitUserName();
            return;
        }
        this.psgitusernameDirtyFlag = false;
        this.psgitusername = null;
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
        PSGitUserBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSGitUserBase pSGitUserBase) {
        pSGitUserBase.resetAllDCFlag();
        pSGitUserBase.resetCreateDate();
        pSGitUserBase.resetCreateMan();
        pSGitUserBase.resetCredentialSyncMode();
        pSGitUserBase.resetDefaultFlag();
        pSGitUserBase.resetEmail();
        pSGitUserBase.resetGitPath();
        pSGitUserBase.resetMemo();
        pSGitUserBase.resetPasswd();
        pSGitUserBase.resetPSDevCenterId();
        pSGitUserBase.resetPSDevCenterName();
        pSGitUserBase.resetPSGitUserId();
        pSGitUserBase.resetPSGitUserName();
        pSGitUserBase.resetPSSVNServerId();
        pSGitUserBase.resetPSSVNServerName();
        pSGitUserBase.resetPSSvrDomainId();
        pSGitUserBase.resetPSSvrDomainName();
        pSGitUserBase.resetUpdateDate();
        pSGitUserBase.resetUpdateMan();
        pSGitUserBase.resetUserName();
        pSGitUserBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAllDCFlagDirty()) {
            hashMap.put(FIELD_ALLDCFLAG, this.getAllDCFlag());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCredentialSyncModeDirty()) {
            hashMap.put(FIELD_CREDENTIALSYNCMODE, this.getCredentialSyncMode());
        }
        if (!bl || this.isDefaultFlagDirty()) {
            hashMap.put(FIELD_DEFAULTFLAG, this.getDefaultFlag());
        }
        if (!bl || this.isEmailDirty()) {
            hashMap.put(FIELD_EMAIL, this.getEmail());
        }
        if (!bl || this.isGitPathDirty()) {
            hashMap.put(FIELD_GITPATH, this.getGitPath());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPasswdDirty()) {
            hashMap.put(FIELD_PASSWD, this.getPasswd());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSGitUserIdDirty()) {
            hashMap.put(FIELD_PSGITUSERID, this.getPSGitUserId());
        }
        if (!bl || this.isPSGitUserNameDirty()) {
            hashMap.put(FIELD_PSGITUSERNAME, this.getPSGitUserName());
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
        return PSGitUserBase.get(this, n);
    }

    private static Object get(PSGitUserBase pSGitUserBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSGitUserBase.getAllDCFlag();
            }
            case 1: {
                return pSGitUserBase.getCreateDate();
            }
            case 2: {
                return pSGitUserBase.getCreateMan();
            }
            case 3: {
                return pSGitUserBase.getCredentialSyncMode();
            }
            case 4: {
                return pSGitUserBase.getDefaultFlag();
            }
            case 5: {
                return pSGitUserBase.getEmail();
            }
            case 6: {
                return pSGitUserBase.getGitPath();
            }
            case 7: {
                return pSGitUserBase.getMemo();
            }
            case 8: {
                return pSGitUserBase.getPasswd();
            }
            case 9: {
                return pSGitUserBase.getPSDevCenterId();
            }
            case 10: {
                return pSGitUserBase.getPSDevCenterName();
            }
            case 11: {
                return pSGitUserBase.getPSGitUserId();
            }
            case 12: {
                return pSGitUserBase.getPSGitUserName();
            }
            case 13: {
                return pSGitUserBase.getPSSVNServerId();
            }
            case 14: {
                return pSGitUserBase.getPSSVNServerName();
            }
            case 15: {
                return pSGitUserBase.getPSSvrDomainId();
            }
            case 16: {
                return pSGitUserBase.getPSSvrDomainName();
            }
            case 17: {
                return pSGitUserBase.getUpdateDate();
            }
            case 18: {
                return pSGitUserBase.getUpdateMan();
            }
            case 19: {
                return pSGitUserBase.getUserName();
            }
            case 20: {
                return pSGitUserBase.getValidFlag();
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
        PSGitUserBase.set(this, n, object);
    }

    private static void set(PSGitUserBase pSGitUserBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSGitUserBase.setAllDCFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSGitUserBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSGitUserBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSGitUserBase.setCredentialSyncMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSGitUserBase.setDefaultFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSGitUserBase.setEmail(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSGitUserBase.setGitPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSGitUserBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSGitUserBase.setPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSGitUserBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSGitUserBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSGitUserBase.setPSGitUserId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSGitUserBase.setPSGitUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSGitUserBase.setPSSVNServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSGitUserBase.setPSSVNServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSGitUserBase.setPSSvrDomainId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSGitUserBase.setPSSvrDomainName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSGitUserBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 18: {
                pSGitUserBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSGitUserBase.setUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSGitUserBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSGitUserBase.isNull(this, n);
    }

    private static boolean isNull(PSGitUserBase pSGitUserBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSGitUserBase.getAllDCFlag() == null;
            }
            case 1: {
                return pSGitUserBase.getCreateDate() == null;
            }
            case 2: {
                return pSGitUserBase.getCreateMan() == null;
            }
            case 3: {
                return pSGitUserBase.getCredentialSyncMode() == null;
            }
            case 4: {
                return pSGitUserBase.getDefaultFlag() == null;
            }
            case 5: {
                return pSGitUserBase.getEmail() == null;
            }
            case 6: {
                return pSGitUserBase.getGitPath() == null;
            }
            case 7: {
                return pSGitUserBase.getMemo() == null;
            }
            case 8: {
                return pSGitUserBase.getPasswd() == null;
            }
            case 9: {
                return pSGitUserBase.getPSDevCenterId() == null;
            }
            case 10: {
                return pSGitUserBase.getPSDevCenterName() == null;
            }
            case 11: {
                return pSGitUserBase.getPSGitUserId() == null;
            }
            case 12: {
                return pSGitUserBase.getPSGitUserName() == null;
            }
            case 13: {
                return pSGitUserBase.getPSSVNServerId() == null;
            }
            case 14: {
                return pSGitUserBase.getPSSVNServerName() == null;
            }
            case 15: {
                return pSGitUserBase.getPSSvrDomainId() == null;
            }
            case 16: {
                return pSGitUserBase.getPSSvrDomainName() == null;
            }
            case 17: {
                return pSGitUserBase.getUpdateDate() == null;
            }
            case 18: {
                return pSGitUserBase.getUpdateMan() == null;
            }
            case 19: {
                return pSGitUserBase.getUserName() == null;
            }
            case 20: {
                return pSGitUserBase.getValidFlag() == null;
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
        return PSGitUserBase.contains(this, n);
    }

    private static boolean contains(PSGitUserBase pSGitUserBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSGitUserBase.isAllDCFlagDirty();
            }
            case 1: {
                return pSGitUserBase.isCreateDateDirty();
            }
            case 2: {
                return pSGitUserBase.isCreateManDirty();
            }
            case 3: {
                return pSGitUserBase.isCredentialSyncModeDirty();
            }
            case 4: {
                return pSGitUserBase.isDefaultFlagDirty();
            }
            case 5: {
                return pSGitUserBase.isEmailDirty();
            }
            case 6: {
                return pSGitUserBase.isGitPathDirty();
            }
            case 7: {
                return pSGitUserBase.isMemoDirty();
            }
            case 8: {
                return pSGitUserBase.isPasswdDirty();
            }
            case 9: {
                return pSGitUserBase.isPSDevCenterIdDirty();
            }
            case 10: {
                return pSGitUserBase.isPSDevCenterNameDirty();
            }
            case 11: {
                return pSGitUserBase.isPSGitUserIdDirty();
            }
            case 12: {
                return pSGitUserBase.isPSGitUserNameDirty();
            }
            case 13: {
                return pSGitUserBase.isPSSVNServerIdDirty();
            }
            case 14: {
                return pSGitUserBase.isPSSVNServerNameDirty();
            }
            case 15: {
                return pSGitUserBase.isPSSvrDomainIdDirty();
            }
            case 16: {
                return pSGitUserBase.isPSSvrDomainNameDirty();
            }
            case 17: {
                return pSGitUserBase.isUpdateDateDirty();
            }
            case 18: {
                return pSGitUserBase.isUpdateManDirty();
            }
            case 19: {
                return pSGitUserBase.isUserNameDirty();
            }
            case 20: {
                return pSGitUserBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSGitUserBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSGitUserBase pSGitUserBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSGitUserBase.getAllDCFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"alldcflag", (Object)PSGitUserBase.getJSONValue((Object)pSGitUserBase.getAllDCFlag()), (boolean)false);
        }
        if (bl || pSGitUserBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSGitUserBase.getJSONValue((Object)pSGitUserBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSGitUserBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSGitUserBase.getJSONValue((Object)pSGitUserBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSGitUserBase.getCredentialSyncMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"credentialsyncmode", (Object)PSGitUserBase.getJSONValue((Object)pSGitUserBase.getCredentialSyncMode()), (boolean)false);
        }
        if (bl || pSGitUserBase.getDefaultFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultflag", (Object)PSGitUserBase.getJSONValue((Object)pSGitUserBase.getDefaultFlag()), (boolean)false);
        }
        if (bl || pSGitUserBase.getEmail() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"email", (Object)PSGitUserBase.getJSONValue((Object)pSGitUserBase.getEmail()), (boolean)false);
        }
        if (bl || pSGitUserBase.getGitPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gitpath", (Object)PSGitUserBase.getJSONValue((Object)pSGitUserBase.getGitPath()), (boolean)false);
        }
        if (bl || pSGitUserBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSGitUserBase.getJSONValue((Object)pSGitUserBase.getMemo()), (boolean)false);
        }
        if (bl || pSGitUserBase.getPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"passwd", (Object)PSGitUserBase.getJSONValue((Object)pSGitUserBase.getPasswd()), (boolean)false);
        }
        if (bl || pSGitUserBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSGitUserBase.getJSONValue((Object)pSGitUserBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSGitUserBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSGitUserBase.getJSONValue((Object)pSGitUserBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSGitUserBase.getPSGitUserId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psgituserid", (Object)PSGitUserBase.getJSONValue((Object)pSGitUserBase.getPSGitUserId()), (boolean)false);
        }
        if (bl || pSGitUserBase.getPSGitUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psgitusername", (Object)PSGitUserBase.getJSONValue((Object)pSGitUserBase.getPSGitUserName()), (boolean)false);
        }
        if (bl || pSGitUserBase.getPSSVNServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvnserverid", (Object)PSGitUserBase.getJSONValue((Object)pSGitUserBase.getPSSVNServerId()), (boolean)false);
        }
        if (bl || pSGitUserBase.getPSSVNServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvnservername", (Object)PSGitUserBase.getJSONValue((Object)pSGitUserBase.getPSSVNServerName()), (boolean)false);
        }
        if (bl || pSGitUserBase.getPSSvrDomainId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainid", (Object)PSGitUserBase.getJSONValue((Object)pSGitUserBase.getPSSvrDomainId()), (boolean)false);
        }
        if (bl || pSGitUserBase.getPSSvrDomainName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainname", (Object)PSGitUserBase.getJSONValue((Object)pSGitUserBase.getPSSvrDomainName()), (boolean)false);
        }
        if (bl || pSGitUserBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSGitUserBase.getJSONValue((Object)pSGitUserBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSGitUserBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSGitUserBase.getJSONValue((Object)pSGitUserBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSGitUserBase.getUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"username", (Object)PSGitUserBase.getJSONValue((Object)pSGitUserBase.getUserName()), (boolean)false);
        }
        if (bl || pSGitUserBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSGitUserBase.getJSONValue((Object)pSGitUserBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSGitUserBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSGitUserBase pSGitUserBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSGitUserBase.getAllDCFlag() != null) {
            object = pSGitUserBase.getAllDCFlag();
            xmlNode.setAttribute(FIELD_ALLDCFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSGitUserBase.getCreateDate() != null) {
            object = pSGitUserBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSGitUserBase.getCreateMan() != null) {
            object = pSGitUserBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSGitUserBase.getCredentialSyncMode() != null) {
            object = pSGitUserBase.getCredentialSyncMode();
            xmlNode.setAttribute(FIELD_CREDENTIALSYNCMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSGitUserBase.getDefaultFlag() != null) {
            object = pSGitUserBase.getDefaultFlag();
            xmlNode.setAttribute(FIELD_DEFAULTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSGitUserBase.getEmail() != null) {
            object = pSGitUserBase.getEmail();
            xmlNode.setAttribute(FIELD_EMAIL, object == null ? "" : (String)object);
        }
        if (bl || pSGitUserBase.getGitPath() != null) {
            object = pSGitUserBase.getGitPath();
            xmlNode.setAttribute(FIELD_GITPATH, object == null ? "" : (String)object);
        }
        if (bl || pSGitUserBase.getMemo() != null) {
            object = pSGitUserBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSGitUserBase.getPasswd() != null) {
            object = pSGitUserBase.getPasswd();
            xmlNode.setAttribute(FIELD_PASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSGitUserBase.getPSDevCenterId() != null) {
            object = pSGitUserBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSGitUserBase.getPSDevCenterName() != null) {
            object = pSGitUserBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSGitUserBase.getPSGitUserId() != null) {
            object = pSGitUserBase.getPSGitUserId();
            xmlNode.setAttribute(FIELD_PSGITUSERID, object == null ? "" : (String)object);
        }
        if (bl || pSGitUserBase.getPSGitUserName() != null) {
            object = pSGitUserBase.getPSGitUserName();
            xmlNode.setAttribute(FIELD_PSGITUSERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSGitUserBase.getPSSVNServerId() != null) {
            object = pSGitUserBase.getPSSVNServerId();
            xmlNode.setAttribute(FIELD_PSSVNSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSGitUserBase.getPSSVNServerName() != null) {
            object = pSGitUserBase.getPSSVNServerName();
            xmlNode.setAttribute(FIELD_PSSVNSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSGitUserBase.getPSSvrDomainId() != null) {
            object = pSGitUserBase.getPSSvrDomainId();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINID, object == null ? "" : (String)object);
        }
        if (bl || pSGitUserBase.getPSSvrDomainName() != null) {
            object = pSGitUserBase.getPSSvrDomainName();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSGitUserBase.getUpdateDate() != null) {
            object = pSGitUserBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSGitUserBase.getUpdateMan() != null) {
            object = pSGitUserBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSGitUserBase.getUserName() != null) {
            object = pSGitUserBase.getUserName();
            xmlNode.setAttribute(FIELD_USERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSGitUserBase.getValidFlag() != null) {
            object = pSGitUserBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSGitUserBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSGitUserBase pSGitUserBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSGitUserBase.isAllDCFlagDirty() && (bl || pSGitUserBase.getAllDCFlag() != null)) {
            iDataObject.set(FIELD_ALLDCFLAG, (Object)pSGitUserBase.getAllDCFlag());
        }
        if (pSGitUserBase.isCreateDateDirty() && (bl || pSGitUserBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSGitUserBase.getCreateDate());
        }
        if (pSGitUserBase.isCreateManDirty() && (bl || pSGitUserBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSGitUserBase.getCreateMan());
        }
        if (pSGitUserBase.isCredentialSyncModeDirty() && (bl || pSGitUserBase.getCredentialSyncMode() != null)) {
            iDataObject.set(FIELD_CREDENTIALSYNCMODE, (Object)pSGitUserBase.getCredentialSyncMode());
        }
        if (pSGitUserBase.isDefaultFlagDirty() && (bl || pSGitUserBase.getDefaultFlag() != null)) {
            iDataObject.set(FIELD_DEFAULTFLAG, (Object)pSGitUserBase.getDefaultFlag());
        }
        if (pSGitUserBase.isEmailDirty() && (bl || pSGitUserBase.getEmail() != null)) {
            iDataObject.set(FIELD_EMAIL, (Object)pSGitUserBase.getEmail());
        }
        if (pSGitUserBase.isGitPathDirty() && (bl || pSGitUserBase.getGitPath() != null)) {
            iDataObject.set(FIELD_GITPATH, (Object)pSGitUserBase.getGitPath());
        }
        if (pSGitUserBase.isMemoDirty() && (bl || pSGitUserBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSGitUserBase.getMemo());
        }
        if (pSGitUserBase.isPasswdDirty() && (bl || pSGitUserBase.getPasswd() != null)) {
            iDataObject.set(FIELD_PASSWD, (Object)pSGitUserBase.getPasswd());
        }
        if (pSGitUserBase.isPSDevCenterIdDirty() && (bl || pSGitUserBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSGitUserBase.getPSDevCenterId());
        }
        if (pSGitUserBase.isPSDevCenterNameDirty() && (bl || pSGitUserBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSGitUserBase.getPSDevCenterName());
        }
        if (pSGitUserBase.isPSGitUserIdDirty() && (bl || pSGitUserBase.getPSGitUserId() != null)) {
            iDataObject.set(FIELD_PSGITUSERID, (Object)pSGitUserBase.getPSGitUserId());
        }
        if (pSGitUserBase.isPSGitUserNameDirty() && (bl || pSGitUserBase.getPSGitUserName() != null)) {
            iDataObject.set(FIELD_PSGITUSERNAME, (Object)pSGitUserBase.getPSGitUserName());
        }
        if (pSGitUserBase.isPSSVNServerIdDirty() && (bl || pSGitUserBase.getPSSVNServerId() != null)) {
            iDataObject.set(FIELD_PSSVNSERVERID, (Object)pSGitUserBase.getPSSVNServerId());
        }
        if (pSGitUserBase.isPSSVNServerNameDirty() && (bl || pSGitUserBase.getPSSVNServerName() != null)) {
            iDataObject.set(FIELD_PSSVNSERVERNAME, (Object)pSGitUserBase.getPSSVNServerName());
        }
        if (pSGitUserBase.isPSSvrDomainIdDirty() && (bl || pSGitUserBase.getPSSvrDomainId() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINID, (Object)pSGitUserBase.getPSSvrDomainId());
        }
        if (pSGitUserBase.isPSSvrDomainNameDirty() && (bl || pSGitUserBase.getPSSvrDomainName() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINNAME, (Object)pSGitUserBase.getPSSvrDomainName());
        }
        if (pSGitUserBase.isUpdateDateDirty() && (bl || pSGitUserBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSGitUserBase.getUpdateDate());
        }
        if (pSGitUserBase.isUpdateManDirty() && (bl || pSGitUserBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSGitUserBase.getUpdateMan());
        }
        if (pSGitUserBase.isUserNameDirty() && (bl || pSGitUserBase.getUserName() != null)) {
            iDataObject.set(FIELD_USERNAME, (Object)pSGitUserBase.getUserName());
        }
        if (pSGitUserBase.isValidFlagDirty() && (bl || pSGitUserBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSGitUserBase.getValidFlag());
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
        return PSGitUserBase.remove(this, n);
    }

    private static boolean remove(PSGitUserBase pSGitUserBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSGitUserBase.resetAllDCFlag();
                return true;
            }
            case 1: {
                pSGitUserBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSGitUserBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSGitUserBase.resetCredentialSyncMode();
                return true;
            }
            case 4: {
                pSGitUserBase.resetDefaultFlag();
                return true;
            }
            case 5: {
                pSGitUserBase.resetEmail();
                return true;
            }
            case 6: {
                pSGitUserBase.resetGitPath();
                return true;
            }
            case 7: {
                pSGitUserBase.resetMemo();
                return true;
            }
            case 8: {
                pSGitUserBase.resetPasswd();
                return true;
            }
            case 9: {
                pSGitUserBase.resetPSDevCenterId();
                return true;
            }
            case 10: {
                pSGitUserBase.resetPSDevCenterName();
                return true;
            }
            case 11: {
                pSGitUserBase.resetPSGitUserId();
                return true;
            }
            case 12: {
                pSGitUserBase.resetPSGitUserName();
                return true;
            }
            case 13: {
                pSGitUserBase.resetPSSVNServerId();
                return true;
            }
            case 14: {
                pSGitUserBase.resetPSSVNServerName();
                return true;
            }
            case 15: {
                pSGitUserBase.resetPSSvrDomainId();
                return true;
            }
            case 16: {
                pSGitUserBase.resetPSSvrDomainName();
                return true;
            }
            case 17: {
                pSGitUserBase.resetUpdateDate();
                return true;
            }
            case 18: {
                pSGitUserBase.resetUpdateMan();
                return true;
            }
            case 19: {
                pSGitUserBase.resetUserName();
                return true;
            }
            case 20: {
                pSGitUserBase.resetValidFlag();
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
                pSDevCenterService.autoGet((IEntity)pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSVNServer getPssvnserver() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPssvnserver();
        }
        if (this.getPSSVNServerId() == null) {
            return null;
        }
        Integer n = this.objPssvnserverLock;
        synchronized (n) {
            if (this.pssvnserver != null && DataTypeHelper.compare((int)25, (Object)this.getPSSVNServerId(), (Object)this.pssvnserver.getPSSVNServerId()) != 0L) {
                this.pssvnserver = null;
            }
            if (this.pssvnserver == null) {
                PSSVNServer pSSVNServer = new PSSVNServer();
                pSSVNServer.setPSSVNServerId(this.getPSSVNServerId());
                PSSVNServerService pSSVNServerService = (PSSVNServerService)ServiceGlobal.getService(PSSVNServerService.class, (SessionFactory)this.getSessionFactory());
                pSSVNServerService.autoGet((IEntity)pSSVNServer);
                this.pssvnserver = pSSVNServer;
            }
            return this.pssvnserver;
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

    private PSGitUserBase getProxyEntity() {
        return this.proxyPSGitUserBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSGitUserBase = null;
        if (iDataObject != null && iDataObject instanceof PSGitUserBase) {
            this.proxyPSGitUserBase = (PSGitUserBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSGitUserService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ALLDCFLAG, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_CREDENTIALSYNCMODE, 3);
        fieldIndexMap.put(FIELD_DEFAULTFLAG, 4);
        fieldIndexMap.put(FIELD_EMAIL, 5);
        fieldIndexMap.put(FIELD_GITPATH, 6);
        fieldIndexMap.put(FIELD_MEMO, 7);
        fieldIndexMap.put(FIELD_PASSWD, 8);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 9);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 10);
        fieldIndexMap.put(FIELD_PSGITUSERID, 11);
        fieldIndexMap.put(FIELD_PSGITUSERNAME, 12);
        fieldIndexMap.put(FIELD_PSSVNSERVERID, 13);
        fieldIndexMap.put(FIELD_PSSVNSERVERNAME, 14);
        fieldIndexMap.put(FIELD_PSSVRDOMAINID, 15);
        fieldIndexMap.put(FIELD_PSSVRDOMAINNAME, 16);
        fieldIndexMap.put(FIELD_UPDATEDATE, 17);
        fieldIndexMap.put(FIELD_UPDATEMAN, 18);
        fieldIndexMap.put(FIELD_USERNAME, 19);
        fieldIndexMap.put(FIELD_VALIDFLAG, 20);
    }
}

